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

import com.google.api.gax.rpc.ServerStream;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.rpc.Code;
import com.google.spanner.v1.BatchWriteResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Hosts a bunch of utility methods/scripts that can be used while performing benchmarks to load
 * data, report latency metrics, etc.
 *
 * <p>Table schema used here: CREATE TABLE FOO ( id INT64 NOT NULL, BAZ INT64, BAR INT64, ) PRIMARY
 * KEY(id);
 */
@Category(SlowTest.class)
@RunWith(JUnit4.class)
public class BenchmarkingUtilityScripts {

  // TODO(developer): Add your values here for PROJECT_ID, INSTANCE_ID, DATABASE_ID
  // TODO(developer): By default these values are blank and should be replaced before a run.
  private static final String PROJECT_ID = "";
  private static final String INSTANCE_ID = "";
  private static final String DATABASE_ID = "";
  private static final String SERVER_URL = "https://staging-wrenchworks.sandbox.googleapis.com";
  private static DatabaseClient client;
  private static Spanner spanner;

  @BeforeClass
  public static void beforeClass() {
    final SpannerOptions.Builder optionsBuilder =
        SpannerOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setAutoThrottleAdministrativeRequests();
    if (!SERVER_URL.isEmpty()) {
      optionsBuilder.setHost(SERVER_URL);
    }
    final SpannerOptions options = optionsBuilder.build();
    spanner = options.getService();
    client = spanner.getDatabaseClient(DatabaseId.of(PROJECT_ID, INSTANCE_ID, DATABASE_ID));

    // Delete all existing data from the table
    client.write(ImmutableList.of(Mutation.delete("FOO", KeySet.all())));
  }

  @AfterClass
  public static void afterClass() {
    spanner.close();
  }

  /**
   * A utility which bulk inserts 10^6 records into the database in batches. The method assumes that
   * the instance/database/table is already created. It does not perform any admin operations.
   *
   * <p>Table schema used here: CREATE TABLE FOO ( id INT64 NOT NULL, BAZ INT64, BAR INT64, )
   * PRIMARY KEY(id);
   */
  @Test
  public void bulkInsertTestData() {
    int key = 0;
    List<MutationGroup> mutationGroups = new ArrayList<>();
    for (int batch = 0; batch < 100; batch++) {
      List<Mutation> mutations = new LinkedList<>();
      for (int i = 0; i < 10000; i++) {
        mutations.add(
            Mutation.newInsertBuilder("FOO")
                .set("id")
                .to(key)
                .set("BAZ")
                .to(1)
                .set("BAR")
                .to(2)
                .build());
        key++;
      }
      mutationGroups.add(MutationGroup.of(mutations));
    }
    ServerStream<BatchWriteResponse> responses = client.batchWriteAtLeastOnce(mutationGroups);
    for (BatchWriteResponse response : responses) {
      if (response.getStatus().getCode() == Code.OK_VALUE) {
        System.out.printf(
            "Mutation group indexes %s have been applied with commit timestamp %s",
            response.getIndexesList(), response.getCommitTimestamp());
      } else {
        System.out.printf(
            "Mutation group indexes %s could not be applied with error code %s and "
                + "error message %s",
            response.getIndexesList(),
            Code.forNumber(response.getStatus().getCode()),
            response.getStatus().getMessage());
      }
    }
  }

  /** Collects all results from a collection of future objects. */
  public static List<Duration> collectResults(
      final ListeningScheduledExecutorService service,
      final List<ListenableFuture<List<Duration>>> results,
      final int numOperations,
      final Duration timeoutDuration)
      throws Exception {
    service.shutdown();
    if (!service.awaitTermination(timeoutDuration.toMinutes(), TimeUnit.MINUTES)) {
      throw new TimeoutException();
    }
    List<Duration> allResults = new ArrayList<>(numOperations);
    for (Future<List<Duration>> result : results) {
      allResults.addAll(result.get());
    }
    return allResults;
  }
}
