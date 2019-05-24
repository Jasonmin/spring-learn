package com.zhou.learnspring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnspringApplicationTests {

    @Test
    public void contextLoads() {
    }

    private static final String API_ROOT
            = "http://localhost:8081/api/books";


}
