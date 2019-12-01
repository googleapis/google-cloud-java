/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.spanner.jdbc.tester;

import com.google.cloud.spanner.jdbc.SpannerPool;
import io.grpc.Server;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests that the shaded Spanner JDBC jar is able to open a connection and execute a query. */
@RunWith(JUnit4.class)
public class JdbcTest {

  @Ignore("enable when single jar is available in repository")
  @Test
  public void testConnect() throws IOException, SQLException, InterruptedException {
    // Start an in-mem mock Spanner server.
    Server server = MockServer.startMockServer();
    // Create a JDBC connection with the mock server.
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner://localhost:%d/projects/%s/instances/%s/databases/%s;usePlainText=true",
                server.getPort(), "test-project", "test-instance", "test-database"))) {
      try (ResultSet rs = connection.createStatement().executeQuery("SELECT 1")) {
        while (rs.next()) {}
      }
    } finally {
      SpannerPool.closeSpannerPool();
      server.shutdown();
      server.awaitTermination();
    }
  }
}
