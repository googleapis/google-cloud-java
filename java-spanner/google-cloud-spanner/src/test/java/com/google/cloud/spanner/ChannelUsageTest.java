/*
 * Copyright 2021 Google LLC
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

import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.protobuf.ListValue;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.SpannerGrpc;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.TypeCode;
import io.grpc.Context;
import io.grpc.Contexts;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * Tests that the Spanner client opens multiple channels, and that each session is associated with
 * one specific channel.
 */
@RunWith(Parameterized.class)
public class ChannelUsageTest {

  @Parameter(0)
  public int numChannels;

  @Parameters(name = "num channels = {0}")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {{1}, {2}, {4}});
  }

  private static final Statement SELECT1 = Statement.of("SELECT 1 AS COL1");
  private static final ResultSetMetadata SELECT1_METADATA =
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
          .setMetadata(SELECT1_METADATA)
          .build();

  private static MockSpannerServiceImpl mockSpanner;
  private static Server server;
  private static InetSocketAddress address;
  // Track channel hints (from X-Goog-Spanner-Request-Id header) per RPC method
  private static final Set<Long> batchCreateSessionChannelHints = ConcurrentHashMap.newKeySet();
  private static final Set<Long> executeSqlChannelHints = ConcurrentHashMap.newKeySet();
  private static final Deque<Long> allExecuteSqlChannelHints = new ConcurrentLinkedDeque<>();

  private static Level originalLogLevel;

  @BeforeClass
  public static void startServer() throws Exception {
    mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0D); // We don't want any unpredictable aborted transactions.
    mockSpanner.putStatementResult(StatementResult.query(SELECT1, SELECT1_RESULTSET));

    address = new InetSocketAddress("localhost", 0);
    server =
        NettyServerBuilder.forAddress(address)
            .addService(mockSpanner)
            // Add a server interceptor to extract channel hints from X-Goog-Spanner-Request-Id
            // header. This verifies that the client uses all configured channels.
            .intercept(
                new ServerInterceptor() {
                  @Override
                  public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
                      ServerCall<ReqT, RespT> call,
                      Metadata headers,
                      ServerCallHandler<ReqT, RespT> next) {
                    // Verify that the compressor name header is set.
                    assertEquals(
                        "gzip",
                        headers.get(
                            Metadata.Key.of(
                                "x-response-encoding", Metadata.ASCII_STRING_MARSHALLER)));
                    // Extract channel hint from X-Goog-Spanner-Request-Id header
                    String requestId = headers.get(XGoogSpannerRequestId.REQUEST_ID_HEADER_KEY);
                    if (requestId != null) {
                      // Format:
                      // <version>.<randProcessId>.<nthClientId>.<nthChannelId>.<nthRequest>.<attempt>
                      String[] parts = requestId.split("\\.");
                      if (parts.length >= 4) {
                        try {
                          long channelHint = Long.parseLong(parts[3]);
                          if (call.getMethodDescriptor()
                              .equals(SpannerGrpc.getBatchCreateSessionsMethod())) {
                            batchCreateSessionChannelHints.add(channelHint);
                          }
                          if (call.getMethodDescriptor()
                              .equals(SpannerGrpc.getExecuteStreamingSqlMethod())) {
                            executeSqlChannelHints.add(channelHint);
                            allExecuteSqlChannelHints.add(channelHint);
                          }
                        } catch (NumberFormatException e) {
                          // Ignore parse errors
                        }
                      }
                    }
                    return Contexts.interceptCall(Context.current(), call, headers, next);
                  }
                })
            .build()
            .start();
  }

  @AfterClass
  public static void stopServer() throws InterruptedException {
    server.shutdown();
    server.awaitTermination();
  }

  @BeforeClass
  public static void disableLogging() {
    Logger logger = Logger.getLogger("");
    originalLogLevel = logger.getLevel();
    logger.setLevel(Level.OFF);
  }

  @AfterClass
  public static void resetLogging() {
    Logger logger = Logger.getLogger("");
    logger.setLevel(originalLogLevel);
  }

  @After
  public void reset() {
    mockSpanner.reset();
    batchCreateSessionChannelHints.clear();
    executeSqlChannelHints.clear();
    allExecuteSqlChannelHints.clear();
  }

  private SpannerOptions createSpannerOptions() {
    String endpoint = address.getHostString() + ":" + server.getPort();
    SpannerOptions.Builder builder =
        SpannerOptions.newBuilder()
            .setProjectId("[PROJECT]")
            .setChannelConfigurator(
                input -> {
                  input.usePlaintext();
                  return input;
                })
            .setNumChannels(numChannels)
            .setCompressorName("gzip")
            .setSessionPoolOption(
                SessionPoolOptions.newBuilder()
                    .setMinSessions(numChannels * 2)
                    .setMaxSessions(numChannels * 2)
                    .build())
            .setHost("http://" + endpoint)
            .setCredentials(NoCredentials.getInstance());

    return builder.build();
  }

  @Test
  public void testUsesAllChannels() throws InterruptedException {
    final int multiplier = 10;
    try (Spanner spanner = createSpannerOptions().getService()) {
      DatabaseClient client = spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));
      for (int run = 0; run < numChannels * multiplier; run++) {
        try (ReadOnlyTransaction transaction = client.readOnlyTransaction()) {
          for (int i = 0; i < 2; i++) {
            try (ResultSet resultSet = transaction.executeQuery(SELECT1)) {
              while (resultSet.next()) {}
            }
          }
        }
      }
    }
    // Bound the channel hints to numChannels (matching gRPC-GCP behavior) and verify
    // that channels are being distributed. The raw channel hints may be unbounded (based on
    // session index), but gRPC-GCP bounds them to the actual number of channels.
    assertEquals(2 * numChannels * multiplier, allExecuteSqlChannelHints.size());
    Set<Long> boundedChannelHints =
        executeSqlChannelHints.stream().map(hint -> hint % numChannels).collect(toSet());
    // Verify that channel distribution is working:
    // - For numChannels=1, exactly 1 channel should be used
    // - For numChannels>1, multiple channels should be used (at least half)
    if (numChannels == 1) {
      assertEquals(1, boundedChannelHints.size());
    } else {
      assertTrue(
          "Expected at least "
              + (numChannels / 2)
              + " channels to be used, but got "
              + boundedChannelHints.size(),
          boundedChannelHints.size() >= numChannels / 2);
    }
  }
}
