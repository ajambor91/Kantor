package net.bitstechworld.users.Testcontainers;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public class PostgreSQLTestContainer extends PostgreSQLContainer<PostgreSQLTestContainer> {
    private static PostgreSQLTestContainer postgreSQLTestContainer;
    private static String IMAGE_NAME = "postgres:17.5-alpine";
    private PostgreSQLTestContainer() {
        super(IMAGE_NAME);
        this.withUsername("TEST_USER").withPassword("TEST_PASSWORD").withDatabaseName("exchange");
        this.start();
    }

    public static PostgreSQLTestContainer getInstance() {
        if (postgreSQLTestContainer == null) {
            postgreSQLTestContainer = new PostgreSQLTestContainer();
        }
        return postgreSQLTestContainer;
    }

    public void setProps(DynamicPropertyRegistry dynamicPropertyRegistry) {
        dynamicPropertyRegistry.add("spring.datasource.url", postgreSQLTestContainer::getJdbcUrl);
        dynamicPropertyRegistry.add("spring.datasource.username", postgreSQLTestContainer::getUsername);
        dynamicPropertyRegistry.add("spring.datasource.password", postgreSQLTestContainer::getPassword);
    }
}
