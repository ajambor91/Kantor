package net.bitstechworld.users.Testcontainers;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

@SpringBootTest
public abstract class AbstractTest {
    private static PostgreSQLTestContainer postgreSQLTestContainer;

    static {
        postgreSQLTestContainer = PostgreSQLTestContainer.getInstance();
    }

    @DynamicPropertySource
    public static void setProps(DynamicPropertyRegistry registry) {
        postgreSQLTestContainer.setProps(registry);
    }
}
