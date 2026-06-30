/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.spanner.spi.v1;

import static org.junit.Assert.assertEquals;

import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import com.google.protobuf.ListValue;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.TypeCode;
import io.grpc.ForwardingServerCall;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SpannerRpcMetricsTest {

  private static MockSpannerServiceImpl mockSpanner;
  private static Server server;
  private static InetSocketAddress address;
  private static Spanner spannerWithOpenTelemetry;
  private static DatabaseClient databaseClient;
  private static final Map<SpannerRpc.Option, Object> optionsMap = new HashMap<>();
  private static MockSpannerServiceImpl mockSpannerNoHeader;
  private static Server serverNoHeader;
  private static InetSocketAddress addressNoHeader;
  private static Spanner spannerNoHeaderNoOpenTelemetry;
  private static DatabaseClient databaseClientNoHeader;
  private static String instanceId = "fake-instance";
  private static String databaseId = "fake-database";
  private static String noHeaderdatabaseId = "fake-database-1";
  private static String projectId = "fake-project";
  private static AtomicInteger fakeServerTiming = new AtomicInteger(new Random().nextInt(1000) + 1);
  private static final Statement SELECT1AND2 =
      Statement.of("SELECT 1 AS COL1 UNION ALL SELECT 2 AS COL1");
  private static final ResultSetMetadata SELECT1AND2_METADATA =
      ResultSetMetadata.newBuilder()
          .setRowType(
              StructType.newBuilder()
                  .addFields(
                      StructType.Field.newBuilder()
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
  private static final Statement UPDATE_FOO_STATEMENT =
      Statement.of("UPDATE FOO SET BAR=1 WHERE BAZ=2");

  private static InMemoryMetricReader inMemoryMetricReader;

  private static InMemoryMetricReader inMemoryMetricReaderInjected;

  @BeforeClass
  public static void startServer() throws Exception {
    SpannerOptions.enableOpenTelemetryMetrics();
    mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0D); // We don't want any unpredictable aborted transactions.
    mockSpanner.putStatementResult(
        MockSpannerServiceImpl.StatementResult.query(SELECT1AND2, SELECT1_RESULTSET));
    mockSpanner.putStatementResult(
        MockSpannerServiceImpl.StatementResult.update(UPDATE_FOO_STATEMENT, 1L));
    address = new InetSocketAddress("localhost", 0);
    server =
        NettyServerBuilder.forAddress(address)
            .addService(mockSpanner)
            .intercept(
                new ServerInterceptor() {
                  @Override
                  public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
                      ServerCall<ReqT, RespT> serverCall,
                      Metadata headers,
                      ServerCallHandler<ReqT, RespT> serverCallHandler) {
                    return serverCallHandler.startCall(
                        new ForwardingServerCall.SimpleForwardingServerCall<ReqT, RespT>(
                            serverCall) {
                          @Override
                          public void sendHeaders(Metadata headers) {
                            headers.put(
                                Metadata.Key.of("server-timing", Metadata.ASCII_STRING_MARSHALLER),
                                String.format("gfet4t7; dur=%d", fakeServerTiming.get()));
                            super.sendHeaders(headers);
                          }
                        },
                        headers);
                  }
                })
            .build()
            .start();
    optionsMap.put(SpannerRpc.Option.CHANNEL_HINT, 1L);
    inMemoryMetricReader = InMemoryMetricReader.create();
    SdkMeterProvider sdkMeterProvider =
        SdkMeterProvider.builder().registerMetricReader(inMemoryMetricReader).build();
    GlobalOpenTelemetry.resetForTest();
    OpenTelemetrySdk.builder().setMeterProvider(sdkMeterProvider).buildAndRegisterGlobal();

    inMemoryMetricReaderInjected = InMemoryMetricReader.create();
    SdkMeterProvider sdkMeterProviderInjected =
        SdkMeterProvider.builder().registerMetricReader(inMemoryMetricReaderInjected).build();

    OpenTelemetry openTelemetry =
        OpenTelemetrySdk.builder().setMeterProvider(sdkMeterProviderInjected).build();

    spannerWithOpenTelemetry =
        createSpannerOptionsWithOpenTelemetry(address, server, openTelemetry).getService();
    databaseClient =
        spannerWithOpenTelemetry.getDatabaseClient(
            DatabaseId.of(projectId, instanceId, databaseId));

    mockSpannerNoHeader = new MockSpannerServiceImpl();
    mockSpannerNoHeader.setAbortProbability(0.0D);
    mockSpannerNoHeader.putStatementResult(
        MockSpannerServiceImpl.StatementResult.query(SELECT1AND2, SELECT1_RESULTSET));
    mockSpannerNoHeader.putStatementResult(
        MockSpannerServiceImpl.StatementResult.update(UPDATE_FOO_STATEMENT, 1L));
    addressNoHeader = new InetSocketAddress("localhost", 0);
    serverNoHeader =
        NettyServerBuilder.forAddress(addressNoHeader)
            .addService(mockSpannerNoHeader)
            .build()
            .start();
    spannerNoHeaderNoOpenTelemetry =
        createSpannerOptions(addressNoHeader, serverNoHeader).getService();
    databaseClientNoHeader =
        spannerNoHeaderNoOpenTelemetry.getDatabaseClient(
            DatabaseId.of(projectId, instanceId, noHeaderdatabaseId));
  }

  @AfterClass
  public static void stopServer() throws InterruptedException {
    if (spannerWithOpenTelemetry != null) {
      spannerWithOpenTelemetry.close();
      server.shutdown();
      server.awaitTermination();
    }

    if (spannerNoHeaderNoOpenTelemetry != null) {
      spannerNoHeaderNoOpenTelemetry.close();
      serverNoHeader.shutdown();
      serverNoHeader.awaitTermination();
    }
  }

  @After
  public void reset() {
    mockSpanner.reset();
    mockSpannerNoHeader.reset();
  }

  @Test
  public void testGfeLatencyExecuteSqlWithInjectedOpenTelemetry() throws InterruptedException {
    databaseClient
        .readWriteTransaction()
        .run(transaction -> transaction.executeUpdate(UPDATE_FOO_STATEMENT));

    double latency =
        getGfeLatencyMetric(
            getMetricData("spanner/gfe_latency", inMemoryMetricReaderInjected),
            "google.spanner.v1.Spanner/ExecuteSql");
    assertEquals(fakeServerTiming.get(), latency, 0);
  }

  @Test
  public void testGfeMissingHeaderExecuteSqlWithGlobalOpenTelemetry() throws InterruptedException {
    databaseClient
        .readWriteTransaction()
        .run(transaction -> transaction.executeUpdate(UPDATE_FOO_STATEMENT));
    long count =
        getHeaderLatencyMetric(
            getMetricData("spanner/gfe_header_missing_count", inMemoryMetricReaderInjected),
            "google.spanner.v1.Spanner/Commit",
            databaseId);
    assertEquals(0, count);

    databaseClientNoHeader
        .readWriteTransaction()
        .run(transaction -> transaction.executeUpdate(UPDATE_FOO_STATEMENT));
    long count1 =
        getHeaderLatencyMetric(
            getMetricData("spanner/gfe_header_missing_count", inMemoryMetricReader),
            "google.spanner.v1.Spanner/Commit",
            noHeaderdatabaseId);
    assertEquals(1, count1);
  }

  private static SpannerOptions createSpannerOptionsWithOpenTelemetry(
      InetSocketAddress address, Server server, OpenTelemetry openTelemetry) {

    String endpoint = address.getHostString() + ":" + server.getPort();
    return SpannerOptions.newBuilder()
        .setProjectId("[PROJECT]")
        .setChannelConfigurator(
            input -> {
              input.usePlaintext();
              return input;
            })
        .setHost("http://" + endpoint)
        .setCredentials(NoCredentials.getInstance())
        .setOpenTelemetry(openTelemetry)
        .build();
  }

  private static SpannerOptions createSpannerOptions(InetSocketAddress address, Server server) {

    String endpoint = address.getHostString() + ":" + server.getPort();
    return SpannerOptions.newBuilder()
        .setProjectId("[PROJECT]")
        .setChannelConfigurator(
            input -> {
              input.usePlaintext();
              return input;
            })
        .setHost("http://" + endpoint)
        .setCredentials(NoCredentials.getInstance())
        .build();
  }

  private long getHeaderLatencyMetric(MetricData metricData, String methodName, String databaseId) {
    return metricData.getLongSumData().getPoints().stream()
        .filter(
            x ->
                x.getAttributes().asMap().containsValue(methodName)
                    && x.getAttributes().asMap().containsValue(databaseId))
        .findFirst()
        .get()
        .getValue();
  }

  private double getGfeLatencyMetric(MetricData metricData, String methodName) {
    return metricData.getHistogramData().getPoints().stream()
        .filter(x -> x.getAttributes().asMap().containsValue(methodName))
        .findFirst()
        .get()
        .getMax();
  }

  private MetricData getMetricData(String metricName, InMemoryMetricReader inMemoryMetricReader) {
    Collection<MetricData> metricDataCollection = inMemoryMetricReader.collectAllMetrics();
    Collection<MetricData> metricDataFiltered =
        metricDataCollection.stream()
            .filter(x -> x.getName().equals(metricName))
            .collect(Collectors.toList());
    return metricDataFiltered.stream().findFirst().get();
  }
}
