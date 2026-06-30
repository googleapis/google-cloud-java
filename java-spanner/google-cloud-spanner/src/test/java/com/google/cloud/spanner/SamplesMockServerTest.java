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

package com.google.cloud.spanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import java.time.Duration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for samples that use an in-mem mock server instead of running on real Cloud Spanner. */
@RunWith(JUnit4.class)
public class SamplesMockServerTest extends AbstractMockServerTest {

  @Test
  public void testSampleRetrySettings() {
    String sql =
        "INSERT INTO Singers (SingerId, FirstName, LastName)\n"
            + "VALUES (20, 'George', 'Washington')";
    mockSpanner.putStatementResult(StatementResult.update(Statement.of(sql), 1L));

    SpannerOptions.Builder builder =
        SpannerOptions.newBuilder()
            .setProjectId("p")
            .setCredentials(NoCredentials.getInstance())
            .setChannelProvider(channelProvider);
    // Set a timeout value for the ExecuteSql RPC that is so low that it will always be triggered.
    // This should cause the RPC to fail with a DEADLINE_EXCEEDED error.
    builder
        .getSpannerStubSettingsBuilder()
        .executeSqlSettings()
        .setRetryableCodes(StatusCode.Code.UNAVAILABLE)
        .setRetrySettings(
            RetrySettings.newBuilder()
                .setInitialRetryDelayDuration(Duration.ofMillis(500))
                .setMaxRetryDelayDuration(Duration.ofSeconds(16))
                .setRetryDelayMultiplier(1.5)
                .setInitialRpcTimeoutDuration(Duration.ofNanos(1L))
                .setMaxRpcTimeoutDuration(Duration.ofNanos(1L))
                .setRpcTimeoutMultiplier(1.0)
                .setTotalTimeoutDuration(Duration.ofNanos(1L))
                .build());
    // Create a Spanner client using the custom retry and timeout settings.
    try (Spanner spanner = builder.build().getService()) {
      DatabaseClient client = spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));
      SpannerException exception =
          assertThrows(
              SpannerException.class,
              () ->
                  client
                      .readWriteTransaction()
                      .run(transaction -> transaction.executeUpdate(Statement.of(sql))));
      assertEquals(ErrorCode.DEADLINE_EXCEEDED, exception.getErrorCode());
    }
  }
}
