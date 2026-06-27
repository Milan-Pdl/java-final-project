package com.pgs.apiProject.controller;

import com.pgs.apiProject.service.JournalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(JournalController.class)
class JournalControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JournalService journalService;

    @Test
    void shouldReturnOkForPostsEndpoint() throws Exception {
        mockMvc.perform(get("/api/v1/posts"))
                .andExpect(status().isOk());
    }
}
