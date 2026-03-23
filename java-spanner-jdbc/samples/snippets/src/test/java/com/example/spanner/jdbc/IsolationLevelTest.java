/*
 * Copyright 2025 Google LLC
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

package com.example.spanner.jdbc;

import static com.example.spanner.jdbc.IsolationLevel.isolationLevel;
import static org.junit.Assume.assumeTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.testcontainers.DockerClientFactory;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.images.PullPolicy;
import org.testcontainers.utility.DockerImageName;

@RunWith(JUnit4.class)
public class IsolationLevelTest {

  private static GenericContainer<?> emulator;

  private static final String PROJECT = "emulator-project";
  private static final String INSTANCE = "my-instance";
  private static final String DATABASE = "my-database";
  private static final Properties PROPERTIES = new Properties();

  @BeforeClass
  public static void setupEmulator() throws Exception {
    assumeTrue("This test requires Docker", DockerClientFactory.instance().isDockerAvailable());

    emulator =
        new GenericContainer<>(DockerImageName.parse("gcr.io/cloud-spanner-emulator/emulator"));
    emulator.withImagePullPolicy(PullPolicy.alwaysPull());
    emulator.addExposedPort(9010);
    emulator.setWaitStrategy(Wait.forListeningPorts(9010));
    emulator.start();

    PROPERTIES.setProperty("endpoint",
        String.format("localhost:%d", emulator.getMappedPort(9010)));
    PROPERTIES.setProperty("autoConfigEmulator", "true");

    String url = String.format(
        "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
        PROJECT, INSTANCE, DATABASE);
    try (Connection connection = DriverManager.getConnection(url, PROPERTIES)) {
      try (Statement statement = connection.createStatement()) {
        statement.addBatch(
            "CREATE TABLE Singers ("
                + "SingerId INT64 PRIMARY KEY, "
                + "FirstName STRING(MAX), "
                + "LastName STRING(MAX), "
                + "Active BOOL)");
        statement.addBatch(
            "CREATE TABLE SingerHistory ("
                + "SingerId INT64, "
                + "Active BOOL, "
                + "CreatedAt TIMESTAMP) "
                + "PRIMARY KEY (SingerId, CreatedAt)");
        statement.executeBatch();
      }
    }
  }

  @AfterClass
  public static void stopEmulator() {
    if (emulator != null) {
      emulator.stop();
    }
  }

  @Test
  public void testIsolationLevel() throws SQLException {
    isolationLevel("emulator-project", "my-instance", "my-database", PROPERTIES);
  }

}
