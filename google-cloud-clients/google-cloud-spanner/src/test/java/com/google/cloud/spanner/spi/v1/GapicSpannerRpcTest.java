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

package com.google.cloud.spanner.spi.v1;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.google.api.core.ApiFunction;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.InstanceAdminClient;
import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.admin.database.v1.MockDatabaseAdminImpl;
import com.google.cloud.spanner.admin.instance.v1.MockInstanceAdminImpl;
import com.google.protobuf.ListValue;
import com.google.spanner.admin.database.v1.Database;
import com.google.spanner.admin.database.v1.DatabaseName;
import com.google.spanner.admin.instance.v1.Instance;
import com.google.spanner.admin.instance.v1.InstanceConfigName;
import com.google.spanner.admin.instance.v1.InstanceName;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.TypeCode;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.regex.Pattern;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests that opening and closing multiple Spanner instances does not leak any threads. */
@RunWith(JUnit4.class)
public class GapicSpannerRpcTest {
  private static final Statement SELECT1AND2 =
      Statement.of("SELECT 1 AS COL1 UNION ALL SELECT 2 AS COL1");
  private static final ResultSetMetadata SELECT1AND2_METADATA =
      ResultSetMetadata.newBuilder()
          .setRowType(
              StructType.newBuilder()
                  .addFields(
                      Field.newBuilder()
                          .setName("COL1")
                          .setType(
                              com.google.spanner.v1.Type.newBuilder()
                                  .setCode(TypeCode.INT64)
                                  .build())
                          .build())
                  .build())
          .build();
  private static final com.google.spanner.v1.ResultSet SELECT1_RESULTSET =
      com.google.spanner.v1.ResultSet.newBuilder()
          .addRows(
              ListValue.newBuilder()
                  .addValues(com.google.protobuf.Value.newBuilder().setStringValue("1").build())
                  .build())
          .addRows(
              ListValue.newBuilder()
                  .addValues(com.google.protobuf.Value.newBuilder().setStringValue("2").build())
                  .build())
          .setMetadata(SELECT1AND2_METADATA)
          .build();
  private MockSpannerServiceImpl mockSpanner;
  private MockInstanceAdminImpl mockInstanceAdmin;
  private MockDatabaseAdminImpl mockDatabaseAdmin;
  private Server server;
  private InetSocketAddress address;

  @Before
  public void startServer() throws IOException {
    mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0D); // We don't want any unpredictable aborted transactions.
    mockSpanner.putStatementResult(StatementResult.query(SELECT1AND2, SELECT1_RESULTSET));

    mockInstanceAdmin = new MockInstanceAdminImpl();
    mockDatabaseAdmin = new MockDatabaseAdminImpl();
    address = new InetSocketAddress("localhost", 0);
    server =
        NettyServerBuilder.forAddress(address)
            .addService(mockSpanner)
            .addService(mockInstanceAdmin)
            .addService(mockDatabaseAdmin)
            .build()
            .start();
  }

  @After
  public void stopServer() {
    server.shutdown();
  }

  private static final int NUMBER_OF_TEST_RUNS = 2;
  private static final int NUM_CHANNELS = 4;
  private static final Pattern GAX_THREAD_NAME = Pattern.compile("Gax-[0-9]+");
  private static final int MAX_MESSAGE_SIZE = 100 * 1024 * 1024;
  private static final int MAX_METADATA_SIZE = 32 * 1024; // bytes

  @Test
  public void testCloseAllThreadsWhenClosingSpanner() throws InterruptedException {
    for (int i = 0; i < NUMBER_OF_TEST_RUNS; i++) {
      // Get the base number of Gax threads.
      int prevThreadNumber = -1;
      int currentThreadNumber = getNumberOfGaxThreads();
      int originalNumberOfThreads = currentThreadNumber;
      // Create Spanner instance.
      SpannerOptions options = createSpannerOptions();
      Spanner spanner = options.getService();
      // Get a database client and do a query. This should initiate threads for the Spanner service.
      DatabaseClient client =
          spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
      try (ResultSet rs = client.singleUse().executeQuery(SELECT1AND2)) {
        while (rs.next()) {
          // Do nothing, just consume the result set.
        }
      }
      // Check the number of threads after the query. Doing a request should initialize a thread
      // pool
      // for the underlying SpannerClient.
      prevThreadNumber = currentThreadNumber;
      currentThreadNumber = getNumberOfGaxThreads();
      assertThat(
          String.format(
              "current number of thread is not greater than previous number of threads. current: %d, prev: %d, run: %d",
              currentThreadNumber, prevThreadNumber, i),
          currentThreadNumber > prevThreadNumber,
          is(true));

      // Then do a request to the InstanceAdmin service and check the number of threads.
      //  Doing a request should initialize a thread pool
      // for the underlying InstanceAdminClient.
      mockGetInstanceResponse();
      InstanceAdminClient instanceAdminClient = spanner.getInstanceAdminClient();
      instanceAdminClient.getInstance("projects/[PROJECT]/instances/[INSTANCE]");
      prevThreadNumber = currentThreadNumber;
      currentThreadNumber = getNumberOfGaxThreads();
      assertThat(currentThreadNumber > prevThreadNumber, is(true));

      // Then do a request to the DatabaseAdmin service and check the number of threads.
      // Doing a request should initialize a thread pool
      // for the underlying DatabaseAdminClient.
      mockGetDatabaseResponse();
      DatabaseAdminClient databaseAdminClient = spanner.getDatabaseAdminClient();
      databaseAdminClient.getDatabase("projects/[PROJECT]/instances/[INSTANCE]", "[DATABASE]");
      prevThreadNumber = currentThreadNumber;
      currentThreadNumber = getNumberOfGaxThreads();
      assertThat(currentThreadNumber > prevThreadNumber, is(true));

      // Now close the Spanner instance and check whether the threads are shutdown or not.
      spanner.close();
      // Wait a little to allow the threads to actually shutdown.
      Thread.sleep(500L);
      Runtime.getRuntime().gc();
      // The number of threads should drop to the original number of threads.
      assertThat(getNumberOfGaxThreads(), is(equalTo(originalNumberOfThreads)));
    }
  }

  private SpannerOptions createSpannerOptions() {
    String endpoint = address.getHostString() + ":" + server.getPort();
    @SuppressWarnings("rawtypes")
    TransportChannelProvider channelProvider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setChannelConfigurator(
                new ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder>() {
                  @Override
                  public ManagedChannelBuilder apply(ManagedChannelBuilder input) {
                    input.usePlaintext();
                    return input;
                  }
                })
            // Do not set an ExecutorProvider on the ChannelProvider
            .setEndpoint(endpoint)
            .setMaxInboundMessageSize(MAX_MESSAGE_SIZE)
            .setMaxInboundMetadataSize(MAX_METADATA_SIZE)
            .setPoolSize(NUM_CHANNELS)
            .build();

    return SpannerOptions.newBuilder()
        .setProjectId("[PROJECT]")
        .setChannelProvider(channelProvider)
        .setCredentials(NoCredentials.getInstance())
        .build();
  }

  private int getNumberOfGaxThreads() {
    ThreadGroup group = Thread.currentThread().getThreadGroup();
    while (group.getParent() != null) {
      group = group.getParent();
    }
    Thread[] threads = new Thread[100 * NUMBER_OF_TEST_RUNS];
    int numberOfThreads = group.enumerate(threads);
    int res = 0;
    for (int i = 0; i < numberOfThreads; i++) {
      if (GAX_THREAD_NAME.matcher(threads[i].getName()).matches()) {
        res++;
      }
    }
    return res;
  }

  private void mockGetInstanceResponse() {
    InstanceName name2 = InstanceName.of("[PROJECT]", "[INSTANCE]");
    InstanceConfigName config = InstanceConfigName.of("[PROJECT]", "[INSTANCE_CONFIG]");
    String displayName = "displayName1615086568";
    int nodeCount = 1539922066;
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(name2.toString())
            .setConfig(config.toString())
            .setDisplayName(displayName)
            .setNodeCount(nodeCount)
            .build();
    mockInstanceAdmin.addResponse(expectedResponse);
  }

  private void mockGetDatabaseResponse() {
    DatabaseName name2 = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
    Database expectedResponse = Database.newBuilder().setName(name2.toString()).build();
    mockDatabaseAdmin.addResponse(expectedResponse);
  }
}
