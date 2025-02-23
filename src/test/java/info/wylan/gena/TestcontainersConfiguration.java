package info.wylan.gena;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.DynamicPropertyRegistrar;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
public class TestcontainersConfiguration {

    private static final String POSTGRES_IMAGE = "postgres:16-alpine";

    private static final String POSTGRES_DATABASE = "testdb";

    private static final String POSTGRES_USER = "test";
    private static final String POSTGRES_PASSWORD = "test";
    private static final String POSTGRES_PORT = "5432";
    private static final String POSTGRES_STARTUP_TIMEOUT = "100s";
    private static final String POSTGRES_INIT_SCRIPT = "db/init.sql";
    private static final String POSTGRES_INIT_SCRIPT_ENCODING = "UTF-8";
    private static final String POSTGRES_INIT_SCRIPT_SEPARATOR = ";";
    private static final String POSTGRES_INIT_SCRIPT_SQL_MODE = "PostgreSQL";
    private static final String POSTGRES_INIT_SCRIPT_SCHEMA = "public";
    private static final String POSTGRES_INIT_SCRIPT_DATABASE = "postgres";

    static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer<>(DockerImageName.parse(POSTGRES_IMAGE))
            .withUsername(POSTGRES_USER)
            .withPassword(POSTGRES_PASSWORD);

    @Bean
    DynamicPropertyRegistrar registerDatabaseProperties() {
        postgreSQLContainer.start();

        return registry -> {
            registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
            registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
            registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
            registry.add("spring.datasource.driver-class-name", () -> "org.postgresql.Driver");
            registry.add("spring.flyway.url", postgreSQLContainer::getJdbcUrl);
            registry.add("spring.flyway.user", postgreSQLContainer::getUsername);
            registry.add("spring.flyway.password", postgreSQLContainer::getPassword);
        };


    }
}
