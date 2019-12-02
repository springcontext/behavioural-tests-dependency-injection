package com.springcontext.restapitests;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestApiTestsApplicationTests {

    @Test
    public void test_main_will_inject_dependencies() {
        RestApiTestsApplication.main(new String[]{});
    }
}
