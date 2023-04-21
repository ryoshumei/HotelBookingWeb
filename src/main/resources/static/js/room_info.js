const roomInfoBtns = document.querySelectorAll('[id="check_detail"]');
const backBtns = document.querySelectorAll('[id="back_btn"]');
const roomInfoBtnsLength = roomInfoBtns.length
const cards = document.querySelectorAll(".card")
const cardsLength = cards.length
const roomInfoBtnInitText = roomInfoBtns[0].textContent
let selected = false;

//cards[0].classList.toggle("active")
for(let i = 0; i < roomInfoBtnsLength; i++){

    roomInfoBtns[i].addEventListener("click", function (){
        console.log("BTn be clicked")
        cards[i].classList.toggle("active")
        hideAllOthers(i)

        // if(roomInfoBtns[i].textContent === roomInfoBtnInitText){
        //     roomInfoBtns[i].textContent = "Back"
        //     selected = true
        // } else {
        //     roomInfoBtns[i].textContent = roomInfoBtnInitText
        //     selected = false
        // }
        //
        // if(selected){
        //     hideAllOthers(i)
        // }else {
        //     releaseAll()
        // }

    })

    backBtns[i].addEventListener("click", function (){
        console.log("BTn be clicked")
        cards[i].classList.toggle("active")
        releaseAll()


    })
}

function hideAllOthers(index){
    for(let i = 0; i < cardsLength; i++){
        if(i != index){
            cards[i].style.display="none";
        }
    }
}

function releaseAll(){
    for(let i = 0; i < cardsLength; i++){
        cards[i].style.display="block";
    }
}


