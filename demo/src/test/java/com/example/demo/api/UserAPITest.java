package com.example.demo.api;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.model.UserModel;
import com.example.demo.test.TestObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.UUID;

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
