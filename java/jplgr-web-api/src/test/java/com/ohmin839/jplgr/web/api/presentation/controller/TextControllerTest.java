package com.ohmin839.jplgr.web.api.presentation.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ohmin839.jplgr.web.api.config.AppConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class TextControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @BeforeEach
    void setup() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Nested
    class ConstantTest {
        @Test
        void testConstant() throws Exception {
            mockMvc.perform(get("/text/constant"))
                .andExpect(status().isOk())
                .andExpect(content().string("ἄνθρωπος"))
                ;
        }
    }

    @Nested
    class ConvertStringTest {
        @Test
        void testConvertStringNoBody() throws Exception {
            mockMvc
                .perform(
                    post("/text/convert/string")
                        .contentType("text/plain;charset=UTF-8")
                )
                .andExpect(status().isBadRequest())
                ;
        }

        @Test
        void testConvertStringEmpty() throws Exception {
            mockMvc
                .perform(
                    post("/text/convert/string")
                        .contentType("text/plain;charset=UTF-8")
                        .content("")
                )
                .andExpect(status().isBadRequest())
                ;
        }

        @Test
        void testConvertStringNotEmpty() throws Exception {
            mockMvc
                .perform(
                    post("/text/convert/string")
                        .contentType("text/plain;charset=UTF-8")
                        .content(">'anthr^opos")
                )
                .andExpect(status().isOk())
                .andExpect(content().string("ἄνθρωπος"))
                ;
        }
    }
}
