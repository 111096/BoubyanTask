package com.boubyan.task;

import com.boubyan.task.jwt.JwtTokenProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTestCases {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    AuthenticationManager authenticationManager;

    @Test
    public void testRegisterCourse() throws Exception {
        // Arrange
        String courseJson = "{\"userId\":1,\"courseId\":2}";
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken("Mostafa", "1234"));

        String token = jwtTokenProvider.generateToken(authentication);
        ResultActions result = mockMvc.perform(post("/api/app/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(courseJson).header("Authorization", "Bearer " + token));
        result.andExpect(status().isOk());
    }

    @Test
    public void testCancelCourse() throws Exception {
        // Arrange
        String courseJson = "{\"userId\":1,\"courseId\":2}";
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken("Mostafa", "1234"));

        String token = jwtTokenProvider.generateToken(authentication);
        ResultActions result = mockMvc.perform(post("/api/app/register/cancel")
                .contentType(MediaType.APPLICATION_JSON)
                .content(courseJson).header("Authorization", "Bearer " + token));
        result.andExpect(status().isOk());
    }
    @Test
    public void testGetCourseById() throws Exception {
        // Arrange
        long courseId = 1L;

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken("Mostafa", "1234"));

        String token = jwtTokenProvider.generateToken(authentication);
        ResultActions result = mockMvc.perform(get("/api/app/course/{id}", courseId).header("Authorization", "Bearer " + token));

        // Assert
        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(courseId))
                .andExpect(jsonPath("$.name").value("English"));
    }


}
