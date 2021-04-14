package com.renanpelicari.aoptalk.manualdi.repository;

import com.renanpelicari.aoptalk.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.UUID;

@Slf4j
public class PersonRepositoryWithoutDI {

    private final JdbcTemplate jdbcTemplate;

    public PersonRepositoryWithoutDI() {
        DataSource ds = DataSourceBuilder.create()
                .driverClassName("org.h2.Driver")
                .url("jdbc:h2:mem:test")
                .username("SA")
                .password("")
                .build();
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    public Person findByEmail(String name) {
        final String sql = "SELECT ID, NAME, EMAIL FROM PERSON WHERE EMAIL = ?";
        try {
            return this.jdbcTemplate.queryForObject(sql, new Object[]{name}, PERSON_ROW_MAPPER);

        } catch (final EmptyResultDataAccessException ex) {
            log.error("Empty result data.", ex);
            return null;
        }
    }

    private static final RowMapper<Person> PERSON_ROW_MAPPER = (rs, rowNum) ->
            Person.builder()
                    .id(UUID.fromString(rs.getString("id")))
                    .name(rs.getString("name"))
                    .email(rs.getString("email"))
                    .build();
}
