/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.sample;

import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.cloud.spanner.sample.entities.Singer;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import javax.annotation.Nonnull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

/** This component creates the database schema and seeds it with some random test data. */
@Component
public class DatabaseSeeder {

  /** Randomly generated names. */
  public static final ImmutableList<Singer> INITIAL_SINGERS =
      ImmutableList.of(
          new Singer("Aaliyah", "Smith"),
          new Singer("Benjamin", "Jones"),
          new Singer("Chloe", "Brown"),
          new Singer("David", "Williams"),
          new Singer("Elijah", "Johnson"),
          new Singer("Emily", "Miller"),
          new Singer("Gabriel", "Garcia"),
          new Singer("Hannah", "Rodriguez"),
          new Singer("Isabella", "Hernandez"),
          new Singer("Jacob", "Perez"));

  private static final Random RANDOM = new Random();

  private final JdbcTemplate jdbcTemplate;

  @Value("classpath:create_schema.sql")
  private Resource createSchemaFile;

  @Value("classpath:drop_schema.sql")
  private Resource dropSchemaFile;

  /** This value is determined once using a system query, and then cached. */
  private final Supplier<Boolean> isCloudSpannerPG;

  public DatabaseSeeder(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
    this.isCloudSpannerPG =
        Suppliers.memoize(() -> JdbcConfiguration.isCloudSpannerPG(jdbcTemplate));
  }

  /** Reads a resource file into a string. */
  private static String resourceAsString(Resource resource) {
    try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)) {
      return FileCopyUtils.copyToString(reader);
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }

  /**
   * Returns true if this application is currently running on a Cloud Spanner PostgreSQL database,
   * and false if it is running on an open-source PostgreSQL database.
   */
  private boolean isCloudSpanner() {
    return isCloudSpannerPG.get();
  }

  /**
   * Removes all statements that start with a 'skip_on_open_source_pg' comment if the application is
   * running on open-source PostgreSQL. This ensures that we can use the same DDL script both on
   * Cloud Spanner and on open-source PostgreSQL. It also removes any empty statements in the given
   * array.
   */
  private String[] updateDdlStatements(String[] statements) {
    if (!isCloudSpanner()) {
      for (int i = 0; i < statements.length; i++) {
        // Replace any line that starts with '/* skip_on_open_source_pg */' with an empty string.
        statements[i] =
            statements[i].replaceAll("(?m)^\\s*/\\*\\s*skip_on_open_source_pg\\s*\\*/.+$", "");
      }
    }
    // Remove any empty statements from the script.
    return Arrays.stream(statements)
        .filter(statement -> !statement.isBlank())
        .toArray(String[]::new);
  }

  /** Creates the database schema if it does not yet exist. */
  public void createDatabaseSchemaIfNotExists() {
    // We can safely just split the script based on ';', as we know that there are no literals or
    // other strings that contain semicolons in the script.
    String[] statements = updateDdlStatements(resourceAsString(createSchemaFile).split(";"));
    // Execute all the DDL statements as a JDBC batch. That ensures that Cloud Spanner will apply
    // all statements in a single DDL batch, which again is a lot more efficient than executing them
    // one-by-one.
    jdbcTemplate.batchUpdate(statements);
  }

  /** Drops the database schema if it exists. */
  public void dropDatabaseSchemaIfExists() {
    // We can safely just split the script based on ';', as we know that there are no literals or
    // other strings that contain semicolons in the script.
    String[] statements = updateDdlStatements(resourceAsString(dropSchemaFile).split(";"));
    // Execute all the DDL statements as a JDBC batch. That ensures that Cloud Spanner will apply
    // all statements in a single DDL batch, which again is a lot more efficient than executing them
    // one-by-one.
    jdbcTemplate.batchUpdate(statements);
  }

  /** Deletes all data currently in the sample tables. */
  public void deleteTestData() {
    // Delete all data in one batch.
    jdbcTemplate.batchUpdate(
        "delete from concerts",
        "delete from venues",
        "delete from tracks",
        "delete from albums",
        "delete from singers");
  }

  /** Inserts some initial test data into the database. */
  public void insertTestData() {
    jdbcTemplate.batchUpdate(
        "insert into singers (first_name, last_name) values (?, ?)",
        new BatchPreparedStatementSetter() {
          @Override
          public void setValues(@Nonnull PreparedStatement preparedStatement, int i)
              throws SQLException {
            preparedStatement.setString(1, INITIAL_SINGERS.get(i).getFirstName());
            preparedStatement.setString(2, INITIAL_SINGERS.get(i).getLastName());
          }

          @Override
          public int getBatchSize() {
            return INITIAL_SINGERS.size();
          }
        });

    List<Long> singerIds =
        jdbcTemplate.query(
            "select id from singers",
            resultSet -> {
              ImmutableList.Builder<Long> builder = ImmutableList.builder();
              while (resultSet.next()) {
                builder.add(resultSet.getLong(1));
              }
              return builder.build();
            });
    jdbcTemplate.batchUpdate(
        "insert into albums (title, marketing_budget, release_date, cover_picture, singer_id) values (?, ?, ?, ?, ?)",
        new BatchPreparedStatementSetter() {
          @Override
          public void setValues(@Nonnull PreparedStatement preparedStatement, int i)
              throws SQLException {
            preparedStatement.setString(1, randomTitle());
            preparedStatement.setBigDecimal(2, randomBigDecimal());
            preparedStatement.setObject(3, randomDate());
            preparedStatement.setBytes(4, randomBytes());
            preparedStatement.setLong(5, randomElement(singerIds));
          }

          @Override
          public int getBatchSize() {
            return INITIAL_SINGERS.size() * 20;
          }
        });
  }

  /** Generates a random title for an album or a track. */
  static String randomTitle() {
    return randomElement(ADJECTIVES) + " " + randomElement(NOUNS);
  }

  /** Returns a random element from the given list. */
  static <T> T randomElement(List<T> list) {
    return list.get(RANDOM.nextInt(list.size()));
  }

  /** Generates a random {@link BigDecimal}. */
  BigDecimal randomBigDecimal() {
    return BigDecimal.valueOf(RANDOM.nextDouble());
  }

  /** Generates a random {@link LocalDate}. */
  static LocalDate randomDate() {
    return LocalDate.of(RANDOM.nextInt(200) + 1800, RANDOM.nextInt(12) + 1, RANDOM.nextInt(28) + 1);
  }

  /** Generates a random byte array with a length between 4 and 1024 bytes. */
  static byte[] randomBytes() {
    int size = RANDOM.nextInt(1020) + 4;
    byte[] res = new byte[size];
    RANDOM.nextBytes(res);
    return res;
  }

  /** Some randomly generated nouns that are used to generate random titles. */
  private static final ImmutableList<String> NOUNS =
      ImmutableList.of(
          "apple",
          "banana",
          "cherry",
          "dog",
          "elephant",
          "fish",
          "grass",
          "house",
          "key",
          "lion",
          "monkey",
          "nail",
          "orange",
          "pen",
          "queen",
          "rain",
          "shoe",
          "tree",
          "umbrella",
          "van",
          "whale",
          "xylophone",
          "zebra");

  /** Some randomly generated adjectives that are used to generate random titles. */
  private static final ImmutableList<String> ADJECTIVES =
      ImmutableList.of(
          "able",
          "angelic",
          "artistic",
          "athletic",
          "attractive",
          "autumnal",
          "calm",
          "careful",
          "cheerful",
          "clever",
          "colorful",
          "confident",
          "courageous",
          "creative",
          "curious",
          "daring",
          "determined",
          "different",
          "dreamy",
          "efficient",
          "elegant",
          "energetic",
          "enthusiastic",
          "exciting",
          "expressive",
          "faithful",
          "fantastic",
          "funny",
          "gentle",
          "gifted",
          "great",
          "happy",
          "helpful",
          "honest",
          "hopeful",
          "imaginative",
          "intelligent",
          "interesting",
          "inventive",
          "joyful",
          "kind",
          "knowledgeable",
          "loving",
          "loyal",
          "magnificent",
          "mature",
          "mysterious",
          "natural",
          "nice",
          "optimistic",
          "peaceful",
          "perfect",
          "pleasant",
          "powerful",
          "proud",
          "quick",
          "relaxed",
          "reliable",
          "responsible",
          "romantic",
          "safe",
          "sensitive",
          "sharp",
          "simple",
          "sincere",
          "skillful",
          "smart",
          "sociable",
          "strong",
          "successful",
          "sweet",
          "talented",
          "thankful",
          "thoughtful",
          "unique",
          "upbeat",
          "valuable",
          "victorious",
          "vivacious",
          "warm",
          "wealthy",
          "wise",
          "wonderful",
          "worthy",
          "youthful");
}
