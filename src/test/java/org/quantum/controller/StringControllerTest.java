package org.quantum.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class StringControllerTest {

    @Autowired
    private MockMvc mock;
    private static final String POST_URL = "/string/count";
    private static final String VALIDATION_ERROR = "string field should contain at least one character";

    @Test
    void badRequestIfEmptyString() throws Exception {
        var requestBody = """
                          {
                              "string": ""
                          }
                          """;
        mock.perform(post(POST_URL).content(requestBody).contentType("application/json;charset=UTF-8"))
            .andExpect(status().isBadRequest()).andExpect(content().string(VALIDATION_ERROR));
    }

    @Test
    void okIfRequestIsValid() throws Exception {
        var request = """
                      {
                          "string": "ssstrinnnng"
                      }
                      """;
        var expected = """
                       [
                            {
                                "n": 4
                            },
                            {
                                "s": 3
                            },
                            {
                                "r": 1
                            },
                            {
                                "t": 1
                            },
                            {
                                "g": 1
                            },
                            {
                                "i": 1
                            }
                        ]
                       """;

        mock.perform(post(POST_URL).content(request).contentType("application/json;charset=UTF-8"))
            .andExpect(status().isOk()).andExpect(content().json(expected));
    }

}
