/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.google.api.core.ApiFunction;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.grpc.gcp.GcpManagedChannelBuilder;
import io.grpc.ManagedChannelBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;

/**
 * Record the performance of both GcpManagedChannel and ManagedChannel when doing SpannerGrpc
 * operations.
 */
final class SpannerClientTestCases {

  private static final Logger logger = Logger.getLogger(SpannerTestCases.class.getName());

  // project: cloudprober-test, use default credentials.
  private static final String INSTANCE_ID = "test-instance";
  private static final String DATABASE_ID = "test-db";
  private static final String LARGE_TABLE = "large_table";
  private static final String TABLE = "users";
  private static final String API_FILE = "spannertest.json";
  private static final int MAX_SIZE_PER_COLUMN = 2621440;
  private static final int NUM_WARMUP = 10;

  // This should be the same as channelpool-maxsize in the ApiConfig JSON file.
  private static final int DEFAULT_CHANNEL_POOL = 4;

  private final boolean isGrpcGcp;
  private final int numOfRpcs;
  private final int numOfThreads;

  private final SpannerOptions spannerOptions;
  private final String colContent;

  SpannerClientTestCases(boolean isGrpcGcp, int payload, int numOfRpcs, int numOfThreads) {
    this.isGrpcGcp = isGrpcGcp;
    this.numOfRpcs = numOfRpcs;
    this.numOfThreads = numOfThreads;

    if (isGrpcGcp) {
      InstantiatingGrpcChannelProvider.Builder channelBuilder =
          InstantiatingGrpcChannelProvider.newBuilder().setPoolSize(DEFAULT_CHANNEL_POOL);
      File configFile =
          new File(SpannerTestCases.class.getClassLoader().getResource(API_FILE).getFile());
      ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> apiFunction =
          (ManagedChannelBuilder builder) ->
              (GcpManagedChannelBuilder.forDelegateBuilder(builder)
                  .withApiConfigJsonFile(configFile));
      channelBuilder = channelBuilder.setPoolSize(1).setChannelConfigurator(apiFunction);
      this.spannerOptions =
          SpannerOptions.newBuilder().setChannelProvider(channelBuilder.build()).build();
    } else {
      this.spannerOptions = SpannerOptions.newBuilder().build();
    }

    int columnBytes = Integer.min(payload, MAX_SIZE_PER_COLUMN);
    if (payload > columnBytes) {
      throw new IllegalStateException(
          "Payload in SpannerClient mode cannot be larger than + " + MAX_SIZE_PER_COLUMN);
    }
    char[] charArray = new char[columnBytes];
    Arrays.fill(charArray, 'z');
    this.colContent = new String(charArray);
  }

  private DatabaseClient getDbClient(Spanner spanner) {
    System.out.println("Project id:" + spannerOptions.getProjectId().toString());
    return spanner.getDatabaseClient(
        DatabaseId.of(spannerOptions.getProjectId(), INSTANCE_ID, DATABASE_ID));
  }

  public void prepareTestData() throws InterruptedException {
    Spanner spanner = spannerOptions.getService();
    DatabaseClient db = getDbClient(spanner);

    try {
      long start = System.currentTimeMillis();
      // Clean the existing data.
      List<Mutation> deletes = new ArrayList<>();
      deletes.add(Mutation.delete(LARGE_TABLE, KeySet.all()));
      db.write(deletes);
      System.out.println(
          String.format(
              "\nDeleted the previous large_table in %d ms.", System.currentTimeMillis() - start));

      List<Mutation> mutations = new ArrayList<>();
      for (int j = 1; j <= numOfThreads; j++) {
        for (int k = 1; k <= numOfRpcs; k++) {
          mutations.add(
              Mutation.newInsertBuilder(LARGE_TABLE)
                  .set("id")
                  .to("SpannerClient-rpc" + k + "thread" + j)
                  .set("data")
                  .to(colContent)
                  .build());
        }
      }
      start = System.currentTimeMillis();
      db.write(mutations);
      System.out.println(
          String.format(
              "\nLarge test table generated in %d ms.", System.currentTimeMillis() - start));
    } finally {
      spanner.close();
    }
  }

  public void testUpdateData() throws InterruptedException {
    Spanner spanner = spannerOptions.getService();
    DatabaseClient db = getDbClient(spanner);
    System.out.println("\nTestUpdateData");
    try {
      // Warm ups.
      updateDataOneThread(db, 1, null);
      Func func = (int thread, List<Long> result) -> updateDataOneThread(db, thread, result);
      runTest(func);
    } finally {
      spanner.close();
    }
  }

  public void testRead() throws InterruptedException {
    Spanner spanner = spannerOptions.getService();
    DatabaseClient db = getDbClient(spanner);
    System.out.println("\nTestRead");
    try {
      // Warm ups.
      readOneThread(db, 1, null);
      Func func = (int thread, List<Long> result) -> readOneThread(db, thread, result);
      runTest(func);
    } finally {
      spanner.close();
    }
  }

  public void readOneThread(DatabaseClient db, int thread, List<Long> result) {
    for (int i = 0; i < numOfRpcs; i++) {
      int lineCount = 0;
      long start = System.currentTimeMillis();
      try (ResultSet resultSet =
          db.singleUse().read(LARGE_TABLE, KeySet.all(), Arrays.asList("id", "data", "rpc"))) {
        while (resultSet.next()) {
          lineCount++;
        }
      }
      if (result != null) {
        result.add(System.currentTimeMillis() - start);
      }
      if (lineCount != numOfRpcs * numOfThreads) {
        System.out.println("WARNING: Imcomplete data.");
      }
    }
  }

  private void updateDataOneThread(DatabaseClient db, int thread, List<Long> result) {
    for (int i = 1; i <= numOfRpcs; i++) {
      List<Mutation> mutations = new ArrayList<>();
      mutations.add(
          Mutation.newUpdateBuilder("LARGE_TABLE")
              .set("id")
              .to("SpannerClient-rpc" + i + "thread" + thread)
              .set("data")
              .to(colContent)
              .set("rpc")
              .to(i)
              .build());
      long start = System.currentTimeMillis();
      db.write(mutations);
      if (result != null) {
        result.add(System.currentTimeMillis() - start);
      }
    }
  }

  private void runTest(Func func) throws InterruptedException {
    List<Long> result = new CopyOnWriteArrayList<>();
    List<Thread> threads = new ArrayList<>();
    if (numOfThreads > 1) {
      for (int t = 0; t < numOfThreads; t++) {
        final int threadNum = t + 1;
        threads.add(new Thread(() -> func.operate(threadNum, result)));
      }
    }
    long start = System.currentTimeMillis();
    if (numOfThreads > 1) {
      for (Thread t : threads) {
        t.start();
      }
    } else {
      func.operate(1, result);
    }

    for (Thread t : threads) {
      t.join();
    }
    // Waiting for all responses.
    while (result.size() < numOfRpcs * numOfThreads) {}

    // Summerize the result.
    long dur = System.currentTimeMillis() - start;
    int numOfChannels = 1;
    Collections.sort(result);
    System.out.println(
        String.format(
            "Number of threads: %d\t "
                + "Number of Channels: %d\t"
                + "Total number of RPC's: %d\n"
                + "\t\tAvg"
                + "\tMin"
                + "\tMed"
                + "\tp90"
                + "\tp99"
                + "\tp100"
                + "\tQPS\n"
                + "  Time(ms)\t%d\t%d\t%d\t%d\t%d\t%d\t%f",
            numOfThreads,
            numOfChannels,
            numOfThreads * numOfRpcs,
            result.stream().mapToLong(Long::longValue).sum() / result.size(),
            result.get(0),
            result.get((int) (result.size() * 0.5)),
            result.get((int) (result.size() * 0.9)),
            result.get((int) (result.size() * 0.99)),
            result.get(result.size() - 1),
            numOfRpcs * numOfThreads / (double) dur));
  }

  private interface Func {
    void operate(int thread, List<Long> result);
  }
}
