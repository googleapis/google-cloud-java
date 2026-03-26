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
package com.google.cloud.jdbc.quickperf;

import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.cloud.spanner.connection.SpannerPool;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import javax.annotation.Nonnull;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.utility.DockerImageName;

public class AppTest {

  private static final String TEST_FILE = "src/test/resources/testfile.json";

  private static GenericContainer<?> emulator;

  private static final String projectId = "test";
  private static final String instanceId = "test";
  private static final String databaseId = "quickperftest";

  @BeforeClass
  public static void setup() throws Exception {
    System.out.println("Starting Emulator");
    emulator =
        new GenericContainer<>(
                DockerImageName.parse("gcr.io/cloud-spanner-emulator/emulator:latest"))
            .withExposedPorts(9010)
            .waitingFor(Wait.forListeningPort());

    emulator.start();
    System.out.println("Finished starting Emulator");

    List<String> ddlList =
        Arrays.asList(
            "CREATE TABLE GroupMgmt ("
                + "group_id INT64,"
                + "grpname STRING(MAX),"
                + ") PRIMARY KEY(group_id)",
            "CREATE TABLE Users ("
                + "user_id INT64,"
                + "name STRING(MAX),"
                + ") PRIMARY KEY(user_id)",
            "CREATE TABLE membership ("
                + "user_id INT64,"
                + "group_id INT64,"
                + "enrolled TIMESTAMP NOT NULL OPTIONS ("
                + " allow_commit_timestamp = true"
                + "),"
                + ") PRIMARY KEY(user_id, group_id)");
    try (Connection connection = createConnection();
        Statement statement = connection.createStatement()) {
      for (String ddl : ddlList) {
        statement.addBatch(ddl);
      }
      statement.executeBatch();
    }
    // create test file
    ProjectConfig projectConfig = createProjectConfig();

    // Write the JSON to a file
    ObjectMapper mapper = new ObjectMapper();
    mapper.enable(SerializationFeature.INDENT_OUTPUT);
    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

    File file = new File(TEST_FILE);
    mapper.writeValue(file, projectConfig);
  }

  @Nonnull
  private static ProjectConfig createProjectConfig() {
    ProjectConfig projectConfig = new ProjectConfig();
    projectConfig.setProject(projectId);
    projectConfig.setInstance(instanceId);
    projectConfig.setDatabase(databaseId);
    projectConfig.setThreads(1);
    projectConfig.setIterations(1000);
    projectConfig.setQuery("INSERT INTO Users (user_id, name) VALUES(?,?)");
    projectConfig.setWriteMetricToFile(false);
    projectConfig.setIsEmulator(true);

    QueryParam param1 = new QueryParam(1, "#i");
    QueryParam param2 = new QueryParam(2, "#s");
    projectConfig.setQueryParams(Arrays.asList(param1, param2));
    return projectConfig;
  }

  @AfterClass
  public static void cleanup() throws IOException {
    // Close all Spanner connections.
    SpannerPool.closeSpannerPool();

    // Write an empty test file
    Path path = Paths.get(TEST_FILE);
    Files.newBufferedWriter(path, TRUNCATE_EXISTING).close();

    // Stop the emulator.
    emulator.stop();
  }

  private static Connection createConnection() throws SQLException {
    String url =
        String.format(
            "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s?autoConfigEmulator=true",
            projectId, instanceId, databaseId);
    Properties properties = new Properties();
    properties.put("endpoint", "localhost:" + emulator.getMappedPort(9010));
    return DriverManager.getConnection(url, properties);
  }

  @Test
  public void testRunApplication() throws Exception {

    System.setProperty("spanner.emulator", "true");
    System.setProperty("spanner.host", "localhost:" + emulator.getMappedPort(9010));
    SpringApplication.run(AppTest.class).close();

    String[] userConfig = {"-c" + TEST_FILE};
    QuickPerf.main(userConfig);

    try (Connection connection = createConnection()) {
      testQuery(connection, "SELECT count(*) FROM Users", 1000);
    }
  }

  private void testQuery(Connection connection, String query, int expected) throws SQLException {
    try (Statement statement = connection.createStatement()) {
      boolean hasResults = statement.execute(query);
      assertTrue(hasResults);

      ResultSet rs = statement.getResultSet();
      while (rs.next()) {
        int value = rs.getInt(1);
        assertEquals(expected, value);
      }
    }
  }
}
