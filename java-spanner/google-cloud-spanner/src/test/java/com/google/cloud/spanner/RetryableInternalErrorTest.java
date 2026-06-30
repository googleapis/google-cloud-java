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

package com.google.cloud.spanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.connection.AbstractMockServerTest;
import com.google.spanner.v1.CreateSessionRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Duration;

@RunWith(JUnit4.class)
public class RetryableInternalErrorTest extends AbstractMockServerTest {
  @Test
  public void testTranslateInternalException() {
    mockSpanner.setCreateSessionExecutionTime(
        SimulatedExecutionTime.ofException(
            Status.INTERNAL
                .withDescription("Authentication backend internal server error. Please retry.")
                .asRuntimeException()));
    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.ofException(
            Status.INTERNAL
                .withDescription("Authentication backend internal server error. Please retry.")
                .asRuntimeException()));

    try (Spanner spanner =
        SpannerOptions.newBuilder()
            .setProjectId("my-project")
            .setHost(String.format("http://localhost:%d", getPort()))
            .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
            .setCredentials(NoCredentials.getInstance())
            .setSessionPoolOption(
                SessionPoolOptions.newBuilder()
                    .setMinSessions(1)
                    .setMaxSessions(1)
                    .setWaitForMinSessions(Duration.ofSeconds(5))
                    .build())
            .build()
            .getService()) {

      DatabaseClient client = spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));
      // Execute a query. This will block until a BatchCreateSessions call has finished and then
      // invoke ExecuteStreamingSql. Both of these RPCs should be retried.
      try (ResultSet resultSet = client.singleUse().executeQuery(SELECT1_STATEMENT)) {
        assertTrue(resultSet.next());
        assertFalse(resultSet.next());
      }
      // Verify that both the CreateSession call and the ExecuteStreamingSql call were
      // retried.
      assertEquals(2, mockSpanner.countRequestsOfType(CreateSessionRequest.class));
      assertEquals(2, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      // Clear the requests before the next test.
      mockSpanner.clearRequests();

      // Execute a DML statement. This uses the ExecuteSql RPC.
      assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      mockSpanner.setExecuteSqlExecutionTime(
          SimulatedExecutionTime.ofException(
              Status.INTERNAL
                  .withDescription("Authentication backend internal server error. Please retry.")
                  .asRuntimeException()));
      assertEquals(
          Long.valueOf(1L),
          client
              .readWriteTransaction()
              .run(transaction -> transaction.executeUpdate(INSERT_STATEMENT)));
      // Verify that also this request was retried.
      assertEquals(2, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    }
  }
}
