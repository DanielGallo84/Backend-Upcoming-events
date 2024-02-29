package org.team4.upcomingevents.security.auth;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    void testBasicAuth() throws Exception {

        MockHttpServletResponse response = mockMvc
                .perform(get("/api/v1/login").with(httpBasic("user", "password")))
                .andExpect(status().isAccepted())
                .andReturn()
                .getResponse();

        assertThat(response.getContentAsString(),
                is("{\"roles\":\"ROLE_USER\",\"message\":\"Logged\",\"username\":\"user\"}"));
    }

}
