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

package com.google.cloud.spanner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.google.api.core.ApiFunction;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
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
  private enum ChannelOption {
    WITH_EXECUTOR,
    WITHOUT_EXECUTOR;
  }

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

  private static final int NUM_CHANNELS = 4;
  private static final Pattern GAX_THREAD_NAME = Pattern.compile("Gax-[0-9]+");
  private static final int MAX_MESSAGE_SIZE = 100 * 1024 * 1024;
  private static final int MAX_METADATA_SIZE = 32 * 1024; // bytes

  /**
   * This test should not leak any threads as it does not set any executor on the channel provider.
   */
  @Test
  public void testNumberOfThreadsWithoutExecutorOnChannelProvider() {
    testLeakedThreads(ChannelOption.WITHOUT_EXECUTOR, false);
  }

  /**
   * This test shows how setting an executor on the channel provider will leak the created threads
   * after the {@link Spanner} instance is closed.
   */
  @Test
  public void testNumberOfThreadsWithExecutorOnChannelProvider() {
    testLeakedThreads(ChannelOption.WITH_EXECUTOR, true);
  }

  private void testLeakedThreads(ChannelOption channelOption, boolean expectLeakedThreads) {
    int expectedNumberOfThreads = 0;
    for (int i = 0; i < 2; i++) {
      // Get the base number of Gax threads.
      int originalThreadNumber = checkNumberOfGaxThreads(-1);
      SpannerOptions options = createSpannerOptions(channelOption);
      Spanner spanner = options.getService();
      // Get a database client and do a query. This should initiate threads for the Spanner service.
      DatabaseClient client =
          spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
      try (ResultSet rs = client.singleUse().executeQuery(SELECT1AND2)) {
        while (rs.next()) {
          // Do nothing, just consume the result set.
        }
      }
      // Check the number of threads after the query.
      if (expectLeakedThreads) {
        expectedNumberOfThreads += NUM_CHANNELS;
      } else {
        expectedNumberOfThreads = originalThreadNumber + NUM_CHANNELS;
      }
      assertThat(
          checkNumberOfGaxThreads(expectedNumberOfThreads), is(equalTo(expectedNumberOfThreads)));

      // Then do a request to the InstanceAdmin service and check the number of threads.
      mockGetInstanceResponse();
      InstanceAdminClient instanceAdminClient = spanner.getInstanceAdminClient();
      instanceAdminClient.getInstance("projects/[PROJECT]/instances/[INSTANCE]");
      if (expectLeakedThreads) {
        expectedNumberOfThreads += NUM_CHANNELS;
      } else {
        expectedNumberOfThreads = originalThreadNumber + 2 * NUM_CHANNELS;
      }
      assertThat(
          checkNumberOfGaxThreads(expectedNumberOfThreads), is(equalTo(expectedNumberOfThreads)));

      // Then do a request to the DatabaseAdmin service and check the number of threads.
      mockGetDatabaseResponse();
      DatabaseAdminClient databaseAdminClient = spanner.getDatabaseAdminClient();
      databaseAdminClient.getDatabase("projects/[PROJECT]/instances/[INSTANCE]", "[DATABASE]");
      if (expectLeakedThreads) {
        expectedNumberOfThreads += NUM_CHANNELS;
      } else {
        expectedNumberOfThreads = originalThreadNumber + 3 * NUM_CHANNELS;
      }
      assertThat(
          checkNumberOfGaxThreads(expectedNumberOfThreads), is(equalTo(expectedNumberOfThreads)));

      // Now close the Spanner instance and check whether the threads are shutdown or not.
      spanner.close();
      if (!expectLeakedThreads) {
        expectedNumberOfThreads = originalThreadNumber;
      }
      assertThat(
          checkNumberOfGaxThreads(expectedNumberOfThreads), is(equalTo(expectedNumberOfThreads)));
    }
  }

  private SpannerOptions createSpannerOptions(ChannelOption channelOption) {
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
            .setExecutorProvider(
                channelOption == ChannelOption.WITH_EXECUTOR
                    ? InstantiatingExecutorProvider.newBuilder().build()
                    : null)
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

  private int checkNumberOfGaxThreads(int expected) {
    final int MAX_LOOPS = 15;
    int loops = 0;
    while (true) {
      ThreadGroup group = Thread.currentThread().getThreadGroup();
      while (group.getParent() != null) {
        group = group.getParent();
      }
      Thread[] threads = new Thread[500];
      int numberOfThreads = group.enumerate(threads);
      int res = 0;
      for (int i = 0; i < numberOfThreads; i++) {
        if (GAX_THREAD_NAME.matcher(threads[i].getName()).matches()) {
          res++;
        }
      }
      // It could take some time before the threads are actually shutdown, so it could be that we
      // need to wait a little and try again.
      if (expected > -1) {
        if (res == expected) {
          return res;
        } else {
          if (loops > MAX_LOOPS) {
            return res;
          }
          loops++;
          try {
            Thread.sleep(loops * 50L);
          } catch (InterruptedException e) {
            return res;
          }
        }
      } else {
        return res;
      }
    }
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
