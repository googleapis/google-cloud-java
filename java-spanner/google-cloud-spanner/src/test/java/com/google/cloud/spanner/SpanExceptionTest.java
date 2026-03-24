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

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.connection.AbstractMockServerTest;
import io.grpc.ManagedChannelBuilder;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SpanExceptionTest extends AbstractMockServerTest {

  @Test
  public void testReadOnlyTransaction() throws InterruptedException, ExecutionException {
    try (Spanner spanner =
        SpannerOptions.newBuilder()
            .setProjectId("my-project")
            .setHost(String.format("http://localhost:%d", getPort()))
            .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
            .setCredentials(NoCredentials.getInstance())
            .setSessionPoolOption(
                SessionPoolOptions.newBuilder()
                    .setMaxSessions(10)
                    .setAcquireSessionTimeoutDuration(Duration.ofMillis(10))
                    // .setAcquireSessionTimeout(null)
                    .build())
            .build()
            .getService()) {
      DatabaseClient client = spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));

      int numThreads = 25;
      ExecutorService service = Executors.newFixedThreadPool(numThreads);
      ArrayList<Future<Void>> futures = new ArrayList<>(numThreads);
      try (ReadOnlyTransaction readOnlyTransaction = client.readOnlyTransaction()) {
        for (int i = 0; i < numThreads; i++) {
          futures.add(service.submit(() -> executeRandom(readOnlyTransaction)));
        }
        service.shutdown();
        assertTrue(service.awaitTermination(60L, TimeUnit.SECONDS));
        // Verify that all threads finished without any unexpected errors.
        for (Future<Void> future : futures) {
          assertNull(future.get());
        }
      }
    }
  }

  private Void executeRandom(ReadOnlyTransaction readOnlyTransaction) {
    try (ResultSet resultSet = readOnlyTransaction.executeQuery(SELECT_RANDOM_STATEMENT)) {
      while (resultSet.next()) {
        // ignore
      }
    } catch (SpannerException spannerException) {
      if (spannerException.getErrorCode() == ErrorCode.RESOURCE_EXHAUSTED) {
        // This is the expected error code, so ignore.
        return null;
      }
      throw spannerException;
    }
    return null;
  }
}
