package com.example.hotelbookingweb.controllers.admin;

import com.example.hotelbookingweb.entities.GuestEntity;
import com.example.hotelbookingweb.services.GuestsServiceImpl;
import com.example.hotelbookingweb.services.RoomsServiceImpl;
import com.example.hotelbookingweb.services.admin.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.example.hotelbookingweb.controllers.admin.AdminIssueController.CHECK_GUESTS_PATH;
import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AdminIssueController.class)
class AdminIssueControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    GuestsServiceImpl guestsService;
    @MockBean
    RoomsServiceImpl roomsService;
    @MockBean
    AdminService adminService;

    @Test
    @WithMockUser(roles = "ADMIN")
    void checkGuests() throws Exception {
        GuestEntity guestEntity = new GuestEntity(1,"test",204,26,0, LocalDate.of(2023,3,28),LocalDate.of(2023,4,2));
        List<GuestEntity> guestEntityList = new ArrayList<>();
        guestEntityList.add(guestEntity);

        given(guestsService.findAllGuests()).willReturn(guestEntityList);

        mockMvc.perform(get(CHECK_GUESTS_PATH))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/checkGuests"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void checkRooms() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(AdminIssueController.CHECK_ROOMS_PATH))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("admin/checkRooms"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("roomsList"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void deleteGuest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(AdminIssueController.DELETE_GUEST_PATH, 1)
                        .with(SecurityMockMvcRequestPostProcessors.csrf()))
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/admin/checkGuests"));
    }
}