package com.iplauction.arena;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.postgresql.PostgreSQLContainer;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Testcontainers
class AuctionArenaApplicationTests {

	@Container
    @ServiceConnection
    static final PostgreSQLContainer postgres =
        new PostgreSQLContainer("postgres:18-alpine");

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads(){

    }

    @Test
    void shouldCreateApplicationAndCricketSchemas(){
        Integer schemaCount = jdbcTemplate.queryForObject(
            """
                SELECT COUNT(*) FROM
                information_schema.schemata
                WHERE schema_name IN ('app','cricket')
                """, Integer.class
        );

        assertEquals(2, schemaCount,
            "Both app and cricket schemas should exist");
    }

    @Test
    void shouldSuccessfullyExecuteFlywayMigration(){
        Integer migrationCount = jdbcTemplate.queryForObject(
            """
                SELECT COUNT(*)
                FROM public.flyway_schema_history
                WHERE version = '1' AND success = TRUE
                """, Integer.class
        );

        assertEquals(1,migrationCount,"Flyway V1 migration should execute successfully");
    }
}
