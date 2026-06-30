/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.spanner.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import com.google.cloud.spanner.connection.SpannerPool;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.testcontainers.DockerClientFactory;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.utility.DockerImageName;

@RunWith(JUnit4.class)
public class ConcurrentTransactionOnEmulatorTest {
  private static GenericContainer<?> emulator;

  private static Properties properties;

  @BeforeClass
  public static void startEmulator() {
    boolean dockerAvailable = false;
    try {
      dockerAvailable = DockerClientFactory.instance().isDockerAvailable();
    } catch (Exception ignore) {
      // Ignore, and just skip the test.
    }
    assumeTrue(dockerAvailable);

    emulator =
        new GenericContainer<>(
                DockerImageName.parse("gcr.io/cloud-spanner-emulator/emulator:latest"))
            .withExposedPorts(9010)
            .waitingFor(Wait.forLogMessage(".*gRPC server listening at.*\\n", 1));
    emulator.start();
    properties = new Properties();
    properties.setProperty("autoConfigEmulator", "true");
    properties.setProperty(
        "endpoint", String.format("%s:%d", emulator.getHost(), emulator.getMappedPort(9010)));
  }

  @AfterClass
  public static void cleanup() {
    SpannerPool.closeSpannerPool();
    if (emulator != null) {
      emulator.stop();
    }
  }

  @Test
  public void testRunConcurrentTransactions() throws SQLException {
    String connectionUrl =
        String.format(
            "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
            "emulator-project", "test-instance", "test-database");
    try (Connection connection1 = DriverManager.getConnection(connectionUrl, properties);
        Connection connection2 = DriverManager.getConnection(connectionUrl, properties)) {
      // Create a test table.
      connection1
          .createStatement()
          .execute("create table test (id int64, value string(max)) primary key (id)");

      // Put both connections into autoCommit=false mode and verify that both connections can run
      // a transaction using a single thread.
      connection1.setAutoCommit(false);
      connection2.setAutoCommit(false);

      connection1.createStatement().executeUpdate("insert into test (id, value) values (1, 'One')");
      connection2.createStatement().executeUpdate("insert into test (id, value) values (2, 'Two')");
      connection1.commit();
      connection2.commit();

      // Verify that both transactions succeeded.
      connection1.setAutoCommit(true);
      try (ResultSet resultSet =
          connection1.createStatement().executeQuery("select * from test order by id")) {
        assertTrue(resultSet.next());
        assertEquals("One", resultSet.getString("value"));
        assertTrue(resultSet.next());
        assertEquals("Two", resultSet.getString("value"));
        assertFalse(resultSet.next());
      }
    }
  }
}
