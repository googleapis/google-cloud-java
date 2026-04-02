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

package com.google.cloud.spanner.connection;

import static org.junit.Assert.assertEquals;

import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Statement;
import com.google.spanner.v1.ExecuteSqlRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class QueryOptionsTest extends AbstractMockServerTest {

  @Test
  public void testUseOptimizerVersionFromConnectionUrl() {
    try (Connection connection = createConnection(";optimizerVersion=10")) {
      Repeat.twice(
          () -> {
            executeSelect1AndConsumeResults(connection);

            assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
            ExecuteSqlRequest request =
                mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
            assertEquals("10", request.getQueryOptions().getOptimizerVersion());

            mockSpanner.clearRequests();
          });
    }
  }

  @Test
  public void testUseOptimizerVersionFromStatement() {
    try (Connection connection = createConnection()) {
      connection.execute(Statement.of("set optimizer_version='7'"));

      Repeat.twice(
          () -> {
            executeSelect1AndConsumeResults(connection);

            assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
            ExecuteSqlRequest request =
                mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
            assertEquals("7", request.getQueryOptions().getOptimizerVersion());

            mockSpanner.clearRequests();
          });
    }
  }

  private void executeSelect1AndConsumeResults(Connection connection) {
    try (ResultSet resultSet = connection.executeQuery(SELECT1_STATEMENT)) {
      //noinspection StatementWithEmptyBody
      while (resultSet.next()) {
        // ignore
      }
    }
  }
}
