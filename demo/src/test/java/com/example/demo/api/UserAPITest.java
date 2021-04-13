package com.example.demo.api;

import com.example.demo.test.TestObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserAPI.class)
class UserAPITest {

    @Mock
    private UserFantasyAPI userFantasyAPI;
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserAPI userAPI;

    @Test
    void test_getMessage() throws Exception {
        TestObject testObject = new TestObject("Lineas",4);

        given(userAPI.getMessage()).willReturn(testObject);
        mockMvc.perform(get("http://localhost:9000/test/hey")).andExpect(status().isOk());
    }





}
