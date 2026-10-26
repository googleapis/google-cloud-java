/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.benchmarking;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.ReadContext;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ReadRequest;
import io.grpc.ManagedChannelBuilder;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StandaloneBenchmarkServerTest {

  @Test
  public void standaloneServerStartsAndServesQueriesWithoutLeakingRequests() throws Exception {
    try (StandaloneBenchmarkServer server = StandaloneBenchmarkServer.start(0, 0)) {
      int spannerPort = server.getSpannerPort();
      int monitoringPort = server.getMonitoringPort();
      assertThat(spannerPort).isGreaterThan(0);
      assertThat(monitoringPort).isGreaterThan(0);

      try (Spanner spanner =
          SpannerOptions.newBuilder()
              .setProjectId("[PROJECT]")
              .setEmulatorHost(null)
              .setCredentials(NoCredentials.getInstance())
              .setChannelConfigurator(
                  builder ->
                      ManagedChannelBuilder.forAddress("0.0.0.0", spannerPort).usePlaintext())
              .build()
              .getService()) {
        DatabaseClient dbClient =
            spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE_ID]", "[DATABASE_ID]"));

        try (ReadContext rc = dbClient.singleUse();
            ResultSet rs = rc.executeQuery(Statement.of("SELECT * FROM [TABLE] WHERE ID = 1"))) {
          assertThat(rs.next()).isTrue();
          assertThat(rs.getLong("id")).isEqualTo(1L);
          assertThat(rs.next()).isFalse();
        }

        try (ReadContext rc = dbClient.singleUse();
            ResultSet rs =
                rc.read("[TABLE]", KeySet.singleKey(Key.of("2")), Arrays.asList("id", "name"))) {
          assertThat(rs.next()).isTrue();
          assertThat(rs.getLong("id")).isEqualTo(1L);
          assertThat(rs.next()).isFalse();
        }
      }

      // Verify recordRequests is disabled so zero requests are retained in heap
      assertThat(server.getMockSpannerService().countRequestsOfType(ExecuteSqlRequest.class))
          .isEqualTo(0);
      assertThat(server.getMockSpannerService().countRequestsOfType(ReadRequest.class))
          .isEqualTo(0);
    }
  }
}
