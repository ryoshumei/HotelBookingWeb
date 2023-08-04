const roomInfoBtns = document.querySelectorAll('[id="check_detail"]')
const backBtns = document.querySelectorAll('[id="back_btn"]')
const roomInfoBtnsLength = roomInfoBtns.length
const cards = document.querySelectorAll(".card")
const cardsLength = cards.length
const roomInfoBtnInitText = roomInfoBtns[0].textContent
const nextBtn = document.querySelector("#next-btn")
const BOOKING_FORM_URL = "/roomsInformation/confirmBooking"
let clickedRoomBtn
let clickedBackBtn
// Get all "Select" buttons
const selectButtons = document.querySelectorAll('.select-room')

// Clear sessionStorage on page refresh
window.onload = function() {
    sessionStorage.clear();
};

for(let i = 0; i < roomInfoBtnsLength; i++){
    roomInfoBtns[i].addEventListener("click", function (){
        console.log("roomInfoBtn clicked")
        cards[i].classList.toggle("active")
        hideAllOthers(i)
        clickedRoomBtn = roomInfoBtns[i]
        clickedBackBtn = backBtns[i]
    })

    backBtns[i].addEventListener("click", function (){
        console.log("backBtn clicked")
        cards[i].classList.toggle("active")
        releaseAll()
        clickedRoomBtn = null
        clickedBackBtn = null
    })
}

selectButtons.forEach(function(button) {
    button.addEventListener('click', function(event) {
        // Get the data from the button
        const roomNum = event.target.getAttribute('room-num')
        const checkInDate = event.target.getAttribute('check-in-date')
        const checkOutDate = event.target.getAttribute('check-out-date')
        // Save room number to sessionStorage
        const selectedRoomNums = JSON.parse(sessionStorage.getItem('selectedRoomNums')) || []
        selectedRoomNums.push(roomNum)
        sessionStorage.setItem('selectedRoomNums', JSON.stringify(selectedRoomNums));
        // Save check-in check-out dates to sessionStorage
        if(sessionStorage.getItem('checkInDate') === null || sessionStorage.getItem('checkOutDate') === null){
            sessionStorage.setItem('checkInDate', checkInDate)
            sessionStorage.setItem('checkOutDate', checkOutDate)
        }
        // view manipulation
        document.querySelector("#selected-rooms-label").textContent += (" " + roomNum)
        clickedRoomBtn.innerHTML = "Selected"
        clickedRoomBtn.classList.add("disabled")
        clickedBackBtn.click()

    })
})

nextBtn.addEventListener("click",function (){
    const selectedRoomNums = JSON.parse(sessionStorage.getItem('selectedRoomNums'));
    console.log(selectedRoomNums)
    if(selectedRoomNums == null){
        console.log("No room selected")
        document.querySelector("#no-room-p-tag").textContent = "No room selected"
    } else {
        // Retrieve data from sessionStorage
        const checkInDate = sessionStorage.getItem('checkInDate')
        const checkOutDate = sessionStorage.getItem('checkOutDate')
        const roomNums = JSON.parse(sessionStorage.getItem('selectedRoomNums'))
        console.log(roomNums)
        // Prepare the parameters
        const params = new URLSearchParams({
            checkInDate: checkInDate,
            checkOutDate: checkOutDate,
            roomNum: roomNums
            //roomNum: roomNums.join(",")  // Convert array to comma-separated string
        })

        // Send the GET request
        window.location.href = `/roomsInformation/confirmBooking?${params}`
    }
})

function hideAllOthers(index){
    nextBtn.style.display="none"
    for(let i = 0; i < cardsLength; i++){
        if(i != index){
            cards[i].style.display="none"
        }
    }
}

function releaseAll(){
    nextBtn.style.display="block"
    for(let i = 0; i < cardsLength; i++){
        cards[i].style.display="block"
    }
}


