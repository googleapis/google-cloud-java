/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.logging;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.cloud.AsyncPage;
import com.google.cloud.MonitoredResourceDescriptor;
import com.google.cloud.Page;
import com.google.cloud.RetryParams;
import com.google.cloud.logging.Logging.ListOption;
import com.google.cloud.logging.SinkInfo.Destination;
import com.google.cloud.logging.spi.LoggingRpc;
import com.google.cloud.logging.spi.LoggingRpcFactory;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.logging.v2.CreateLogMetricRequest;
import com.google.logging.v2.CreateSinkRequest;
import com.google.logging.v2.DeleteLogMetricRequest;
import com.google.logging.v2.DeleteLogRequest;
import com.google.logging.v2.DeleteSinkRequest;
import com.google.logging.v2.GetLogMetricRequest;
import com.google.logging.v2.GetSinkRequest;
import com.google.logging.v2.ListLogMetricsRequest;
import com.google.logging.v2.ListLogMetricsResponse;
import com.google.logging.v2.ListMonitoredResourceDescriptorsRequest;
import com.google.logging.v2.ListMonitoredResourceDescriptorsResponse;
import com.google.logging.v2.ListSinksRequest;
import com.google.logging.v2.ListSinksResponse;
import com.google.logging.v2.LogMetric;
import com.google.logging.v2.LogSink;
import com.google.logging.v2.UpdateLogMetricRequest;
import com.google.logging.v2.UpdateSinkRequest;
import com.google.protobuf.Empty;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class LoggingImplTest {

  private static final String PROJECT = "project";
  private static final String PROJECT_PB = "projects/" + PROJECT;
  private static final String SINK_NAME = "sink";
  private static final SinkInfo SINK_INFO =
      SinkInfo.of(SINK_NAME, Destination.BucketDestination.of("bucket"));
  private static final String SINK_NAME_PB = "projects/" + PROJECT + "/sinks/" + SINK_NAME;
  private static final String METRIC_NAME = "metric";
  private static final String METRIC_NAME_PB = "projects/" + PROJECT + "/metrics/" + METRIC_NAME;
  private static final String FILTER = "logName=projects/my-projectid/logs/syslog";
  private static final String DESCRIPTION = "description";
  private static final MetricInfo METRIC_INFO = MetricInfo.builder(METRIC_NAME, FILTER)
      .description(DESCRIPTION)
      .build();
  private static final com.google.api.MonitoredResourceDescriptor DESCRIPTOR_PB =
      com.google.api.MonitoredResourceDescriptor.getDefaultInstance();
  private static final MonitoredResourceDescriptor DESCRIPTOR =
      MonitoredResourceDescriptor.fromPb(DESCRIPTOR_PB);
  private static final String LOG_NAME = "log";
  private static final String LOG_NAME_PB = "projects/" + PROJECT + "/logs/" + LOG_NAME;
  private static final Function<SinkInfo, LogSink> SINK_TO_PB_FUNCTION =
      new Function<SinkInfo, LogSink>() {
        @Override
        public LogSink apply(SinkInfo sinkInfo) {
          return sinkInfo.toPb(PROJECT);
        }
      };
  private static final Function<MetricInfo, LogMetric> METRIC_TO_PB_FUNCTION =
      new Function<MetricInfo, LogMetric>() {
        @Override
        public LogMetric apply(MetricInfo metricInfo) {
          return metricInfo.toPb();
        }
      };
  private static final Function<MonitoredResourceDescriptor,
      com.google.api.MonitoredResourceDescriptor> DESCRIPTOR_TO_PB_FUNCTION =
      new Function<MonitoredResourceDescriptor, com.google.api.MonitoredResourceDescriptor>() {
        @Override
        public com.google.api.MonitoredResourceDescriptor apply(
            MonitoredResourceDescriptor descriptor) {
          return descriptor.toPb();
        }
      };

  private LoggingOptions options;
  private LoggingRpcFactory rpcFactoryMock;
  private LoggingRpc loggingRpcMock;
  private Logging logging;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Before
  public void setUp() {
    rpcFactoryMock = EasyMock.createStrictMock(LoggingRpcFactory.class);
    loggingRpcMock = EasyMock.createStrictMock(LoggingRpc.class);
    EasyMock.expect(rpcFactoryMock.create(EasyMock.anyObject(LoggingOptions.class)))
        .andReturn(loggingRpcMock);
    options = LoggingOptions.builder()
        .projectId(PROJECT)
        .serviceRpcFactory(rpcFactoryMock)
        .retryParams(RetryParams.noRetries())
        .build();
  }

  @After
  public void tearDown() {
    EasyMock.verify(rpcFactoryMock, loggingRpcMock);
  }

  @Test
  public void testGetOptions() {
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    assertSame(options, options.service().options());
  }

  @Test
  public void testCreateSink() {
    LogSink sinkPb = SINK_INFO.toPb(PROJECT);
    Future<LogSink> response = Futures.immediateFuture(sinkPb);
    CreateSinkRequest request = CreateSinkRequest.newBuilder()
        .setProjectName(PROJECT_PB)
        .setSink(sinkPb)
        .build();
    EasyMock.expect(loggingRpcMock.create(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.service();
    Sink sink = logging.create(SINK_INFO);
    assertEquals(new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)), sink);
  }

  @Test
  public void testCreateSinkAsync() throws ExecutionException, InterruptedException {
    LogSink sinkPb = SINK_INFO.toPb(PROJECT);
    Future<LogSink> response = Futures.immediateFuture(sinkPb);
    CreateSinkRequest request = CreateSinkRequest.newBuilder()
        .setProjectName(PROJECT_PB)
        .setSink(sinkPb)
        .build();
    EasyMock.expect(loggingRpcMock.create(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.service();
    Sink sink = logging.createAsync(SINK_INFO).get();
    assertEquals(new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)), sink);
  }

  @Test
  public void testUpdateSink() {
    LogSink sinkPb = SINK_INFO.toPb(PROJECT);
    Future<LogSink> response = Futures.immediateFuture(sinkPb);
    UpdateSinkRequest request = UpdateSinkRequest.newBuilder()
        .setSinkName(SINK_NAME_PB)
        .setSink(sinkPb)
        .build();
    EasyMock.expect(loggingRpcMock.update(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.service();
    Sink sink = logging.update(SINK_INFO);
    assertEquals(new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)), sink);
  }

  @Test
  public void testUpdateSinkAsync() throws ExecutionException, InterruptedException {
    LogSink sinkPb = SINK_INFO.toPb(PROJECT);
    Future<LogSink> response = Futures.immediateFuture(sinkPb);
    UpdateSinkRequest request = UpdateSinkRequest.newBuilder()
        .setSinkName(SINK_NAME_PB)
        .setSink(sinkPb)
        .build();
    EasyMock.expect(loggingRpcMock.update(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.service();
    Sink sink = logging.updateAsync(SINK_INFO).get();
    assertEquals(new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)), sink);
  }

  @Test
  public void testGetSink() {
    LogSink sinkPb = SINK_INFO.toPb(PROJECT);
    Future<LogSink> response = Futures.immediateFuture(sinkPb);
    GetSinkRequest request = GetSinkRequest.newBuilder().setSinkName(SINK_NAME_PB).build();
    EasyMock.expect(loggingRpcMock.get(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.service();
    Sink sink = logging.getSink(SINK_NAME);
    assertEquals(new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)), sink);
  }

  @Test
  public void testGetSink_Null() {
    Future<LogSink> response = Futures.immediateFuture(null);
    GetSinkRequest request = GetSinkRequest.newBuilder().setSinkName(SINK_NAME_PB).build();
    EasyMock.expect(loggingRpcMock.get(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.service();
    assertNull(logging.getSink(SINK_NAME));
  }

  @Test
  public void testGetSinkAsync() throws ExecutionException, InterruptedException {
    LogSink sinkPb = SINK_INFO.toPb(PROJECT);
    Future<LogSink> response = Futures.immediateFuture(sinkPb);
    GetSinkRequest request = GetSinkRequest.newBuilder().setSinkName(SINK_NAME_PB).build();
    EasyMock.expect(loggingRpcMock.get(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.service();
    Sink sink = logging.getSinkAsync(SINK_NAME).get();
    assertEquals(new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)), sink);
  }

  @Test
  public void testGetSinkAsync_Null() throws ExecutionException, InterruptedException {
    Future<LogSink> response = Futures.immediateFuture(null);
    GetSinkRequest request = GetSinkRequest.newBuilder().setSinkName(SINK_NAME_PB).build();
    EasyMock.expect(loggingRpcMock.get(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.service();
    assertNull(logging.getSinkAsync(SINK_NAME).get());
  }

  @Test
  public void testDeleteSink() {
    DeleteSinkRequest request = DeleteSinkRequest.newBuilder().setSinkName(SINK_NAME_PB).build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(loggingRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.service();
    assertTrue(logging.deleteSink(SINK_NAME));
  }

  @Test
  public void testDeleteSink_Null() {
    DeleteSinkRequest request = DeleteSinkRequest.newBuilder().setSinkName(SINK_NAME_PB).build();
    Future<Empty> response = Futures.immediateFuture(null);
    EasyMock.expect(loggingRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.service();
    assertFalse(logging.deleteSink(SINK_NAME));
  }

  @Test
  public void testDeleteSinkAsync() throws ExecutionException, InterruptedException {
    DeleteSinkRequest request = DeleteSinkRequest.newBuilder().setSinkName(SINK_NAME_PB).build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(loggingRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.service();
    assertTrue(logging.deleteSinkAsync(SINK_NAME).get());
  }

  @Test
  public void testDeleteSinkAsync_Null() throws ExecutionException, InterruptedException {
    DeleteSinkRequest request = DeleteSinkRequest.newBuilder().setSinkName(SINK_NAME_PB).build();
    Future<Empty> response = Futures.immediateFuture(null);
    EasyMock.expect(loggingRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.service();
    assertFalse(logging.deleteSinkAsync(SINK_NAME).get());
  }

  @Test
  public void testListSinks() {
    String cursor = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.service();
    ListSinksRequest request = ListSinksRequest.newBuilder().setProjectName(PROJECT_PB).build();
    List<Sink> sinkList = ImmutableList.of(
        new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)),
        new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)));
    ListSinksResponse response = ListSinksResponse.newBuilder()
        .setNextPageToken(cursor)
        .addAllSinks(Lists.transform(sinkList, SINK_TO_PB_FUNCTION))
        .build();
    Future<ListSinksResponse> futureResponse = Futures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    Page<Sink> page = logging.listSinks();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(sinkList.toArray(), Iterables.toArray(page.values(), Sink.class));
  }

  @Test
  public void testListSinksNextPage() {
    String cursor1 = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.service();
    ListSinksRequest request1 = ListSinksRequest.newBuilder().setProjectName(PROJECT_PB).build();
    ListSinksRequest request2 = ListSinksRequest.newBuilder()
        .setProjectName(PROJECT_PB)
        .setPageToken(cursor1)
        .build();
    List<Sink> sinkList1 = ImmutableList.of(
        new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)),
        new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)));
    List<Sink> sinkList2 = ImmutableList.of(
        new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)));
    ListSinksResponse response1 = ListSinksResponse.newBuilder()
        .setNextPageToken(cursor1)
        .addAllSinks(Lists.transform(sinkList1, SINK_TO_PB_FUNCTION))
        .build();
    String cursor2 = "nextCursor";
    ListSinksResponse response2 = ListSinksResponse.newBuilder()
        .setNextPageToken(cursor2)
        .addAllSinks(Lists.transform(sinkList2, SINK_TO_PB_FUNCTION))
        .build();
    Future<ListSinksResponse> futureResponse1 = Futures.immediateFuture(response1);
    Future<ListSinksResponse> futureResponse2 = Futures.immediateFuture(response2);
    EasyMock.expect(loggingRpcMock.list(request1)).andReturn(futureResponse1);
    EasyMock.expect(loggingRpcMock.list(request2)).andReturn(futureResponse2);
    EasyMock.replay(loggingRpcMock);
    Page<Sink> page = logging.listSinks();
    assertEquals(cursor1, page.nextPageCursor());
    assertArrayEquals(sinkList1.toArray(), Iterables.toArray(page.values(), Sink.class));
    page = page.nextPage();
    assertEquals(cursor2, page.nextPageCursor());
    assertArrayEquals(sinkList2.toArray(), Iterables.toArray(page.values(), Sink.class));
  }

  @Test
  public void testListSinksEmpty() {
    EasyMock.replay(rpcFactoryMock);
    logging = options.service();
    ListSinksRequest request = ListSinksRequest.newBuilder().setProjectName(PROJECT_PB).build();
    List<Sink> sinkList = ImmutableList.of();
    ListSinksResponse response = ListSinksResponse.newBuilder()
        .setNextPageToken("")
        .addAllSinks(Lists.transform(sinkList, SINK_TO_PB_FUNCTION))
        .build();
    Future<ListSinksResponse> futureResponse = Futures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    Page<Sink> page = logging.listSinks();
    assertNull(page.nextPageCursor());
    assertNull(page.nextPage());
    assertArrayEquals(sinkList.toArray(), Iterables.toArray(page.values(), Sink.class));
  }

  @Test
  public void testListSinksWithOptions() {
    String cursor = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.service();
    ListSinksRequest request = ListSinksRequest.newBuilder()
        .setPageToken(cursor)
        .setPageSize(42)
        .setProjectName(PROJECT_PB)
        .build();
    List<Sink> sinkList = ImmutableList.of(
        new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)),
        new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)));
    ListSinksResponse response = ListSinksResponse.newBuilder()
        .setNextPageToken(cursor)
        .addAllSinks(Lists.transform(sinkList, SINK_TO_PB_FUNCTION))
        .build();
    Future<ListSinksResponse> futureResponse = Futures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    Page<Sink> page = logging.listSinks(ListOption.pageSize(42), ListOption.pageToken(cursor));
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(sinkList.toArray(), Iterables.toArray(page.values(), Sink.class));
  }

  @Test
  public void testListSinksAsync() throws ExecutionException, InterruptedException {
    String cursor = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.service();
    ListSinksRequest request = ListSinksRequest.newBuilder().setProjectName(PROJECT_PB).build();
    List<Sink> sinkList = ImmutableList.of(
        new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)),
        new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)));
    ListSinksResponse response = ListSinksResponse.newBuilder()
        .setNextPageToken(cursor)
        .addAllSinks(Lists.transform(sinkList, SINK_TO_PB_FUNCTION))
        .build();
    Future<ListSinksResponse> futureResponse = Futures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    AsyncPage<Sink> page = logging.listSinksAsync().get();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(sinkList.toArray(), Iterables.toArray(page.values(), Sink.class));
  }

  @Test
  public void testListSinksAsyncNextPage() throws ExecutionException, InterruptedException {
    String cursor1 = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.service();
    ListSinksRequest request1 = ListSinksRequest.newBuilder().setProjectName(PROJECT_PB).build();
    ListSinksRequest request2 = ListSinksRequest.newBuilder()
        .setProjectName(PROJECT_PB)
        .setPageToken(cursor1)
        .build();
    List<Sink> sinkList1 = ImmutableList.of(
        new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)),
        new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)));
    List<Sink> sinkList2 = ImmutableList.of(
        new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)));
    ListSinksResponse response1 = ListSinksResponse.newBuilder()
        .setNextPageToken(cursor1)
        .addAllSinks(Lists.transform(sinkList1, SINK_TO_PB_FUNCTION))
        .build();
    String cursor2 = "nextCursor";
    ListSinksResponse response2 = ListSinksResponse.newBuilder()
        .setNextPageToken(cursor2)
        .addAllSinks(Lists.transform(sinkList2, SINK_TO_PB_FUNCTION))
        .build();
    Future<ListSinksResponse> futureResponse1 = Futures.immediateFuture(response1);
    Future<ListSinksResponse> futureResponse2 = Futures.immediateFuture(response2);
    EasyMock.expect(loggingRpcMock.list(request1)).andReturn(futureResponse1);
    EasyMock.expect(loggingRpcMock.list(request2)).andReturn(futureResponse2);
    EasyMock.replay(loggingRpcMock);
    AsyncPage<Sink> page = logging.listSinksAsync().get();
    assertEquals(cursor1, page.nextPageCursor());
    assertArrayEquals(sinkList1.toArray(), Iterables.toArray(page.values(), Sink.class));
    page = page.nextPageAsync().get();
    assertEquals(cursor2, page.nextPageCursor());
    assertArrayEquals(sinkList2.toArray(), Iterables.toArray(page.values(), Sink.class));
  }

  @Test
  public void testListSinksAsyncEmpty() throws ExecutionException, InterruptedException {
    EasyMock.replay(rpcFactoryMock);
    logging = options.service();
    ListSinksRequest request = ListSinksRequest.newBuilder().setProjectName(PROJECT_PB).build();
    List<Sink> sinkList = ImmutableList.of();
    ListSinksResponse response = ListSinksResponse.newBuilder()
        .setNextPageToken("")
        .addAllSinks(Lists.transform(sinkList, SINK_TO_PB_FUNCTION))
        .build();
    Future<ListSinksResponse> futureResponse = Futures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    AsyncPage<Sink> page = logging.listSinksAsync().get();
    assertNull(page.nextPageCursor());
    assertNull(page.nextPage());
    assertArrayEquals(sinkList.toArray(), Iterables.toArray(page.values(), Sink.class));
  }

  @Test
  public void testListSinksWithOptionsAsync() throws ExecutionException, InterruptedException {
    String cursor = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.service();
    ListSinksRequest request = ListSinksRequest.newBuilder()
        .setPageToken(cursor)
        .setPageSize(42)
        .setProjectName(PROJECT_PB)
        .build();
    List<Sink> sinkList = ImmutableList.of(
        new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)),
        new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)));
    ListSinksResponse response = ListSinksResponse.newBuilder()
        .setNextPageToken(cursor)
        .addAllSinks(Lists.transform(sinkList, SINK_TO_PB_FUNCTION))
        .build();
    Future<ListSinksResponse> futureResponse = Futures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    AsyncPage<Sink> page =
        logging.listSinksAsync(ListOption.pageSize(42), ListOption.pageToken(cursor)).get();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(sinkList.toArray(), Iterables.toArray(page.values(), Sink.class));
  }

  @Test
  public void testCreateMetric() {
    LogMetric metricPb = METRIC_INFO.toPb();
    Future<LogMetric> response = Futures.immediateFuture(metricPb);
    CreateLogMetricRequest request = CreateLogMetricRequest.newBuilder()
        .setProjectName(PROJECT_PB)
        .setMetric(metricPb)
        .build();
    EasyMock.expect(loggingRpcMock.create(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.service();
    Metric metric = logging.create(METRIC_INFO);
    assertEquals(new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)), metric);
  }

  @Test
  public void testCreateMetricAsync() throws ExecutionException, InterruptedException {
    LogMetric metricPb = METRIC_INFO.toPb();
    Future<LogMetric> response = Futures.immediateFuture(metricPb);
    CreateLogMetricRequest request = CreateLogMetricRequest.newBuilder()
        .setProjectName(PROJECT_PB)
        .setMetric(metricPb)
        .build();
    EasyMock.expect(loggingRpcMock.create(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.service();
    Metric metric = logging.createAsync(METRIC_INFO).get();
    assertEquals(new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)), metric);
  }

  @Test
  public void testUpdateMetric() {
    LogMetric sinkPb = METRIC_INFO.toPb();
    Future<LogMetric> response = Futures.immediateFuture(sinkPb);
    UpdateLogMetricRequest request = UpdateLogMetricRequest.newBuilder()
        .setMetricName(METRIC_NAME_PB)
        .setMetric(sinkPb)
        .build();
    EasyMock.expect(loggingRpcMock.update(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.service();
    Metric sink = logging.update(METRIC_INFO);
    assertEquals(new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)), sink);
  }

  @Test
  public void testUpdateMetricAsync() throws ExecutionException, InterruptedException {
    LogMetric sinkPb = METRIC_INFO.toPb();
    Future<LogMetric> response = Futures.immediateFuture(sinkPb);
    UpdateLogMetricRequest request = UpdateLogMetricRequest.newBuilder()
        .setMetricName(METRIC_NAME_PB)
        .setMetric(sinkPb)
        .build();
    EasyMock.expect(loggingRpcMock.update(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.service();
    Metric sink = logging.updateAsync(METRIC_INFO).get();
    assertEquals(new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)), sink);
  }

  @Test
  public void testGetMetric() {
    LogMetric sinkPb = METRIC_INFO.toPb();
    Future<LogMetric> response = Futures.immediateFuture(sinkPb);
    GetLogMetricRequest request =
        GetLogMetricRequest.newBuilder().setMetricName(METRIC_NAME_PB).build();
    EasyMock.expect(loggingRpcMock.get(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.service();
    Metric sink = logging.getMetric(METRIC_NAME);
    assertEquals(new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)), sink);
  }

  @Test
  public void testGetMetric_Null() {
    Future<LogMetric> response = Futures.immediateFuture(null);
    GetLogMetricRequest request =
        GetLogMetricRequest.newBuilder().setMetricName(METRIC_NAME_PB).build();
    EasyMock.expect(loggingRpcMock.get(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.service();
    assertNull(logging.getMetric(METRIC_NAME));
  }

  @Test
  public void testGetMetricAsync() throws ExecutionException, InterruptedException {
    LogMetric sinkPb = METRIC_INFO.toPb();
    Future<LogMetric> response = Futures.immediateFuture(sinkPb);
    GetLogMetricRequest request =
        GetLogMetricRequest.newBuilder().setMetricName(METRIC_NAME_PB).build();
    EasyMock.expect(loggingRpcMock.get(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.service();
    Metric sink = logging.getMetricAsync(METRIC_NAME).get();
    assertEquals(new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)), sink);
  }

  @Test
  public void testGetMetricAsync_Null() throws ExecutionException, InterruptedException {
    Future<LogMetric> response = Futures.immediateFuture(null);
    GetLogMetricRequest request =
        GetLogMetricRequest.newBuilder().setMetricName(METRIC_NAME_PB).build();
    EasyMock.expect(loggingRpcMock.get(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.service();
    assertNull(logging.getMetricAsync(METRIC_NAME).get());
  }

  @Test
  public void testDeleteMetric() {
    DeleteLogMetricRequest request =
        DeleteLogMetricRequest.newBuilder().setMetricName(METRIC_NAME_PB).build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(loggingRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.service();
    assertTrue(logging.deleteMetric(METRIC_NAME));
  }

  @Test
  public void testDeleteMetric_Null() {
    DeleteLogMetricRequest request =
        DeleteLogMetricRequest.newBuilder().setMetricName(METRIC_NAME_PB).build();
    Future<Empty> response = Futures.immediateFuture(null);
    EasyMock.expect(loggingRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.service();
    assertFalse(logging.deleteMetric(METRIC_NAME));
  }

  @Test
  public void testDeleteMetricAsync() throws ExecutionException, InterruptedException {
    DeleteLogMetricRequest request =
        DeleteLogMetricRequest.newBuilder().setMetricName(METRIC_NAME_PB).build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(loggingRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.service();
    assertTrue(logging.deleteMetricAsync(METRIC_NAME).get());
  }

  @Test
  public void testDeleteMetricAsync_Null() throws ExecutionException, InterruptedException {
    DeleteLogMetricRequest request =
        DeleteLogMetricRequest.newBuilder().setMetricName(METRIC_NAME_PB).build();
    Future<Empty> response = Futures.immediateFuture(null);
    EasyMock.expect(loggingRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.service();
    assertFalse(logging.deleteMetricAsync(METRIC_NAME).get());
  }

  @Test
  public void testListMetrics() {
    String cursor = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.service();
    ListLogMetricsRequest request =
        ListLogMetricsRequest.newBuilder().setProjectName(PROJECT_PB).build();
    List<Metric> sinkList = ImmutableList.of(
        new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)),
        new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)));
    ListLogMetricsResponse response = ListLogMetricsResponse.newBuilder()
        .setNextPageToken(cursor)
        .addAllMetrics(Lists.transform(sinkList, METRIC_TO_PB_FUNCTION))
        .build();
    Future<ListLogMetricsResponse> futureResponse = Futures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    Page<Metric> page = logging.listMetrics();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(sinkList.toArray(), Iterables.toArray(page.values(), Metric.class));
  }

  @Test
  public void testListMetricsNextPage() {
    String cursor1 = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.service();
    ListLogMetricsRequest request1 =
        ListLogMetricsRequest.newBuilder().setProjectName(PROJECT_PB).build();
    ListLogMetricsRequest request2 = ListLogMetricsRequest.newBuilder()
        .setProjectName(PROJECT_PB)
        .setPageToken(cursor1)
        .build();
    List<Metric> sinkList1 = ImmutableList.of(
        new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)),
        new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)));
    List<Metric> sinkList2 = ImmutableList.of(
        new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)));
    ListLogMetricsResponse response1 = ListLogMetricsResponse.newBuilder()
        .setNextPageToken(cursor1)
        .addAllMetrics(Lists.transform(sinkList1, METRIC_TO_PB_FUNCTION))
        .build();
    String cursor2 = "nextCursor";
    ListLogMetricsResponse response2 = ListLogMetricsResponse.newBuilder()
        .setNextPageToken(cursor2)
        .addAllMetrics(Lists.transform(sinkList2, METRIC_TO_PB_FUNCTION))
        .build();
    Future<ListLogMetricsResponse> futureResponse1 = Futures.immediateFuture(response1);
    Future<ListLogMetricsResponse> futureResponse2 = Futures.immediateFuture(response2);
    EasyMock.expect(loggingRpcMock.list(request1)).andReturn(futureResponse1);
    EasyMock.expect(loggingRpcMock.list(request2)).andReturn(futureResponse2);
    EasyMock.replay(loggingRpcMock);
    Page<Metric> page = logging.listMetrics();
    assertEquals(cursor1, page.nextPageCursor());
    assertArrayEquals(sinkList1.toArray(), Iterables.toArray(page.values(), Metric.class));
    page = page.nextPage();
    assertEquals(cursor2, page.nextPageCursor());
    assertArrayEquals(sinkList2.toArray(), Iterables.toArray(page.values(), Metric.class));
  }

  @Test
  public void testListMetricsEmpty() {
    EasyMock.replay(rpcFactoryMock);
    logging = options.service();
    ListLogMetricsRequest request =
        ListLogMetricsRequest.newBuilder().setProjectName(PROJECT_PB).build();
    List<Metric> sinkList = ImmutableList.of();
    ListLogMetricsResponse response = ListLogMetricsResponse.newBuilder()
        .setNextPageToken("")
        .addAllMetrics(Lists.transform(sinkList, METRIC_TO_PB_FUNCTION))
        .build();
    Future<ListLogMetricsResponse> futureResponse = Futures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    Page<Metric> page = logging.listMetrics();
    assertNull(page.nextPageCursor());
    assertNull(page.nextPage());
    assertArrayEquals(sinkList.toArray(), Iterables.toArray(page.values(), Metric.class));
  }

  @Test
  public void testListMetricsWithOptions() {
    String cursor = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.service();
    ListLogMetricsRequest request = ListLogMetricsRequest.newBuilder()
        .setPageToken(cursor)
        .setPageSize(42)
        .setProjectName(PROJECT_PB)
        .build();
    List<Metric> sinkList = ImmutableList.of(
        new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)),
        new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)));
    ListLogMetricsResponse response = ListLogMetricsResponse.newBuilder()
        .setNextPageToken(cursor)
        .addAllMetrics(Lists.transform(sinkList, METRIC_TO_PB_FUNCTION))
        .build();
    Future<ListLogMetricsResponse> futureResponse = Futures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    Page<Metric> page = logging.listMetrics(ListOption.pageSize(42), ListOption.pageToken(cursor));
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(sinkList.toArray(), Iterables.toArray(page.values(), Metric.class));
  }

  @Test
  public void testListMetricsAsync() throws ExecutionException, InterruptedException {
    String cursor = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.service();
    ListLogMetricsRequest request =
        ListLogMetricsRequest.newBuilder().setProjectName(PROJECT_PB).build();
    List<Metric> sinkList = ImmutableList.of(
        new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)),
        new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)));
    ListLogMetricsResponse response = ListLogMetricsResponse.newBuilder()
        .setNextPageToken(cursor)
        .addAllMetrics(Lists.transform(sinkList, METRIC_TO_PB_FUNCTION))
        .build();
    Future<ListLogMetricsResponse> futureResponse = Futures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    AsyncPage<Metric> page = logging.listMetricsAsync().get();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(sinkList.toArray(), Iterables.toArray(page.values(), Metric.class));
  }

  @Test
  public void testListMetricsAsyncNextPage() throws ExecutionException, InterruptedException {
    String cursor1 = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.service();
    ListLogMetricsRequest request1 =
        ListLogMetricsRequest.newBuilder().setProjectName(PROJECT_PB).build();
    ListLogMetricsRequest request2 = ListLogMetricsRequest.newBuilder()
        .setProjectName(PROJECT_PB)
        .setPageToken(cursor1)
        .build();
    List<Metric> sinkList1 = ImmutableList.of(
        new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)),
        new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)));
    List<Metric> sinkList2 = ImmutableList.of(
        new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)));
    ListLogMetricsResponse response1 = ListLogMetricsResponse.newBuilder()
        .setNextPageToken(cursor1)
        .addAllMetrics(Lists.transform(sinkList1, METRIC_TO_PB_FUNCTION))
        .build();
    String cursor2 = "nextCursor";
    ListLogMetricsResponse response2 = ListLogMetricsResponse.newBuilder()
        .setNextPageToken(cursor2)
        .addAllMetrics(Lists.transform(sinkList2, METRIC_TO_PB_FUNCTION))
        .build();
    Future<ListLogMetricsResponse> futureResponse1 = Futures.immediateFuture(response1);
    Future<ListLogMetricsResponse> futureResponse2 = Futures.immediateFuture(response2);
    EasyMock.expect(loggingRpcMock.list(request1)).andReturn(futureResponse1);
    EasyMock.expect(loggingRpcMock.list(request2)).andReturn(futureResponse2);
    EasyMock.replay(loggingRpcMock);
    AsyncPage<Metric> page = logging.listMetricsAsync().get();
    assertEquals(cursor1, page.nextPageCursor());
    assertArrayEquals(sinkList1.toArray(), Iterables.toArray(page.values(), Metric.class));
    page = page.nextPageAsync().get();
    assertEquals(cursor2, page.nextPageCursor());
    assertArrayEquals(sinkList2.toArray(), Iterables.toArray(page.values(), Metric.class));
  }

  @Test
  public void testListMetricsAsyncEmpty() throws ExecutionException, InterruptedException {
    EasyMock.replay(rpcFactoryMock);
    logging = options.service();
    ListLogMetricsRequest request =
        ListLogMetricsRequest.newBuilder().setProjectName(PROJECT_PB).build();
    List<Metric> sinkList = ImmutableList.of();
    ListLogMetricsResponse response = ListLogMetricsResponse.newBuilder()
        .setNextPageToken("")
        .addAllMetrics(Lists.transform(sinkList, METRIC_TO_PB_FUNCTION))
        .build();
    Future<ListLogMetricsResponse> futureResponse = Futures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    AsyncPage<Metric> page = logging.listMetricsAsync().get();
    assertNull(page.nextPageCursor());
    assertNull(page.nextPage());
    assertArrayEquals(sinkList.toArray(), Iterables.toArray(page.values(), Metric.class));
  }

  @Test
  public void testListMetricsWithOptionsAsync() throws ExecutionException, InterruptedException {
    String cursor = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.service();
    ListLogMetricsRequest request = ListLogMetricsRequest.newBuilder()
        .setPageToken(cursor)
        .setPageSize(42)
        .setProjectName(PROJECT_PB)
        .build();
    List<Metric> sinkList = ImmutableList.of(
        new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)),
        new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)));
    ListLogMetricsResponse response = ListLogMetricsResponse.newBuilder()
        .setNextPageToken(cursor)
        .addAllMetrics(Lists.transform(sinkList, METRIC_TO_PB_FUNCTION))
        .build();
    Future<ListLogMetricsResponse> futureResponse = Futures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    AsyncPage<Metric> page =
        logging.listMetricsAsync(ListOption.pageSize(42), ListOption.pageToken(cursor)).get();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(sinkList.toArray(), Iterables.toArray(page.values(), Metric.class));
  }

  @Test
  public void testListResourceDescriptor() {
    String cursor = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.service();
    ListMonitoredResourceDescriptorsRequest request =
        ListMonitoredResourceDescriptorsRequest.newBuilder().build();
    List<MonitoredResourceDescriptor> descriptorList = ImmutableList.of(DESCRIPTOR, DESCRIPTOR);
    ListMonitoredResourceDescriptorsResponse response =
        ListMonitoredResourceDescriptorsResponse.newBuilder()
            .setNextPageToken(cursor)
            .addAllResourceDescriptors(Lists.transform(descriptorList, DESCRIPTOR_TO_PB_FUNCTION))
        .build();
    Future<ListMonitoredResourceDescriptorsResponse> futureResponse =
        Futures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    Page<MonitoredResourceDescriptor> page = logging.listMonitoredResourceDescriptors();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(descriptorList.toArray(),
        Iterables.toArray(page.values(), MonitoredResourceDescriptor.class));
  }

  @Test
  public void testListResourceDescriptorNextPage() {
    String cursor1 = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.service();
    ListMonitoredResourceDescriptorsRequest request1 =
        ListMonitoredResourceDescriptorsRequest.newBuilder().build();
    ListMonitoredResourceDescriptorsRequest request2 =
        ListMonitoredResourceDescriptorsRequest.newBuilder().setPageToken(cursor1).build();
    List<MonitoredResourceDescriptor> descriptorList1 = ImmutableList.of(DESCRIPTOR, DESCRIPTOR);
    List<MonitoredResourceDescriptor> descriptorList2 = ImmutableList.of(DESCRIPTOR);
    ListMonitoredResourceDescriptorsResponse response1 =
        ListMonitoredResourceDescriptorsResponse.newBuilder()
            .setNextPageToken(cursor1)
            .addAllResourceDescriptors(Lists.transform(descriptorList1, DESCRIPTOR_TO_PB_FUNCTION))
            .build();
    String cursor2 = "nextCursor";
    ListMonitoredResourceDescriptorsResponse response2 =
        ListMonitoredResourceDescriptorsResponse.newBuilder()
            .setNextPageToken(cursor2)
            .addAllResourceDescriptors(Lists.transform(descriptorList2, DESCRIPTOR_TO_PB_FUNCTION))
            .build();
    Future<ListMonitoredResourceDescriptorsResponse> futureResponse1 =
        Futures.immediateFuture(response1);
    Future<ListMonitoredResourceDescriptorsResponse> futureResponse2 =
        Futures.immediateFuture(response2);
    EasyMock.expect(loggingRpcMock.list(request1)).andReturn(futureResponse1);
    EasyMock.expect(loggingRpcMock.list(request2)).andReturn(futureResponse2);
    EasyMock.replay(loggingRpcMock);
    Page<MonitoredResourceDescriptor> page = logging.listMonitoredResourceDescriptors();
    assertEquals(cursor1, page.nextPageCursor());
    assertArrayEquals(descriptorList1.toArray(), Iterables.toArray(page.values(),
        MonitoredResourceDescriptor.class));
    page = page.nextPage();
    assertEquals(cursor2, page.nextPageCursor());
    assertArrayEquals(descriptorList2.toArray(),
        Iterables.toArray(page.values(), MonitoredResourceDescriptor.class));
  }

  @Test
  public void testListResourceDescriptorEmpty() {
    EasyMock.replay(rpcFactoryMock);
    logging = options.service();
    ListMonitoredResourceDescriptorsRequest request =
        ListMonitoredResourceDescriptorsRequest.newBuilder().build();
    List<MonitoredResourceDescriptor> descriptorList = ImmutableList.of();
    ListMonitoredResourceDescriptorsResponse response =
        ListMonitoredResourceDescriptorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllResourceDescriptors(Lists.transform(descriptorList, DESCRIPTOR_TO_PB_FUNCTION))
            .build();
    Future<ListMonitoredResourceDescriptorsResponse> futureResponse =
        Futures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    Page<MonitoredResourceDescriptor> page = logging.listMonitoredResourceDescriptors();
    assertNull(page.nextPageCursor());
    assertNull(page.nextPage());
    assertArrayEquals(descriptorList.toArray(),
        Iterables.toArray(page.values(), MonitoredResourceDescriptor.class));
  }

  @Test
  public void testListResourceDescriptorWithOptions() {
    String cursor = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.service();
    ListMonitoredResourceDescriptorsRequest request =
        ListMonitoredResourceDescriptorsRequest.newBuilder()
            .setPageToken(cursor)
            .setPageSize(42)
            .build();
    List<MonitoredResourceDescriptor> descriptorList = ImmutableList.of(DESCRIPTOR, DESCRIPTOR);
    ListMonitoredResourceDescriptorsResponse response =
        ListMonitoredResourceDescriptorsResponse.newBuilder()
            .setNextPageToken(cursor)
            .addAllResourceDescriptors(Lists.transform(descriptorList, DESCRIPTOR_TO_PB_FUNCTION))
            .build();
    Future<ListMonitoredResourceDescriptorsResponse> futureResponse =
        Futures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    Page<MonitoredResourceDescriptor> page = logging.listMonitoredResourceDescriptors(
        ListOption.pageSize(42), ListOption.pageToken(cursor));
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(descriptorList.toArray(),
        Iterables.toArray(page.values(), MonitoredResourceDescriptor.class));
  }

  @Test
  public void testListResourceDescriptorAsync() throws ExecutionException, InterruptedException {
    String cursor = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.service();
    ListMonitoredResourceDescriptorsRequest request =
        ListMonitoredResourceDescriptorsRequest.newBuilder().build();
    List<MonitoredResourceDescriptor> descriptorList = ImmutableList.of(DESCRIPTOR, DESCRIPTOR);
    ListMonitoredResourceDescriptorsResponse response =
        ListMonitoredResourceDescriptorsResponse.newBuilder()
            .setNextPageToken(cursor)
            .addAllResourceDescriptors(Lists.transform(descriptorList, DESCRIPTOR_TO_PB_FUNCTION))
            .build();
    Future<ListMonitoredResourceDescriptorsResponse> futureResponse =
        Futures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    AsyncPage<MonitoredResourceDescriptor> page =
        logging.listMonitoredResourceDescriptorsAsync().get();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(descriptorList.toArray(),
        Iterables.toArray(page.values(), MonitoredResourceDescriptor.class));
  }

  @Test
  public void testListResourceDescriptorAsyncNextPage() throws ExecutionException, InterruptedException {
    String cursor1 = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.service();
    ListMonitoredResourceDescriptorsRequest request1 =
        ListMonitoredResourceDescriptorsRequest.newBuilder().build();
    ListMonitoredResourceDescriptorsRequest request2 =
        ListMonitoredResourceDescriptorsRequest.newBuilder().setPageToken(cursor1).build();
    List<MonitoredResourceDescriptor> descriptorList1 = ImmutableList.of(DESCRIPTOR, DESCRIPTOR);
    List<MonitoredResourceDescriptor> descriptorList2 = ImmutableList.of(DESCRIPTOR);
    ListMonitoredResourceDescriptorsResponse response1 =
        ListMonitoredResourceDescriptorsResponse.newBuilder()
            .setNextPageToken(cursor1)
            .addAllResourceDescriptors(Lists.transform(descriptorList1, DESCRIPTOR_TO_PB_FUNCTION))
            .build();
    String cursor2 = "nextCursor";
    ListMonitoredResourceDescriptorsResponse response2 =
        ListMonitoredResourceDescriptorsResponse.newBuilder()
            .setNextPageToken(cursor2)
            .addAllResourceDescriptors(Lists.transform(descriptorList2, DESCRIPTOR_TO_PB_FUNCTION))
            .build();
    Future<ListMonitoredResourceDescriptorsResponse> futureResponse1 =
        Futures.immediateFuture(response1);
    Future<ListMonitoredResourceDescriptorsResponse> futureResponse2 =
        Futures.immediateFuture(response2);
    EasyMock.expect(loggingRpcMock.list(request1)).andReturn(futureResponse1);
    EasyMock.expect(loggingRpcMock.list(request2)).andReturn(futureResponse2);
    EasyMock.replay(loggingRpcMock);
    AsyncPage<MonitoredResourceDescriptor> page =
        logging.listMonitoredResourceDescriptorsAsync().get();
    assertEquals(cursor1, page.nextPageCursor());
    assertArrayEquals(descriptorList1.toArray(), Iterables.toArray(page.values(),
        MonitoredResourceDescriptor.class));
    page = page.nextPageAsync().get();
    assertEquals(cursor2, page.nextPageCursor());
    assertArrayEquals(descriptorList2.toArray(),
        Iterables.toArray(page.values(), MonitoredResourceDescriptor.class));
  }

  @Test
  public void testListResourceDescriptorAsyncEmpty()
      throws ExecutionException, InterruptedException {
    EasyMock.replay(rpcFactoryMock);
    logging = options.service();
    ListMonitoredResourceDescriptorsRequest request =
        ListMonitoredResourceDescriptorsRequest.newBuilder().build();
    List<MonitoredResourceDescriptor> descriptorList = ImmutableList.of();
    ListMonitoredResourceDescriptorsResponse response =
        ListMonitoredResourceDescriptorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllResourceDescriptors(Lists.transform(descriptorList, DESCRIPTOR_TO_PB_FUNCTION))
            .build();
    Future<ListMonitoredResourceDescriptorsResponse> futureResponse =
        Futures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    AsyncPage<MonitoredResourceDescriptor> page =
        logging.listMonitoredResourceDescriptorsAsync().get();
    assertNull(page.nextPageCursor());
    assertNull(page.nextPage());
    assertArrayEquals(descriptorList.toArray(),
        Iterables.toArray(page.values(), MonitoredResourceDescriptor.class));
  }

  @Test
  public void testListResourceDescriptorAsyncWithOptions()
      throws ExecutionException, InterruptedException {
    String cursor = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.service();
    ListMonitoredResourceDescriptorsRequest request =
        ListMonitoredResourceDescriptorsRequest.newBuilder()
            .setPageToken(cursor)
            .setPageSize(42)
            .build();
    List<MonitoredResourceDescriptor> descriptorList = ImmutableList.of(DESCRIPTOR, DESCRIPTOR);
    ListMonitoredResourceDescriptorsResponse response =
        ListMonitoredResourceDescriptorsResponse.newBuilder()
            .setNextPageToken(cursor)
            .addAllResourceDescriptors(Lists.transform(descriptorList, DESCRIPTOR_TO_PB_FUNCTION))
            .build();
    Future<ListMonitoredResourceDescriptorsResponse> futureResponse =
        Futures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    AsyncPage<MonitoredResourceDescriptor> page = logging.listMonitoredResourceDescriptorsAsync(
        ListOption.pageSize(42), ListOption.pageToken(cursor)).get();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(descriptorList.toArray(),
        Iterables.toArray(page.values(), MonitoredResourceDescriptor.class));
  }

  @Test
  public void testDeleteLog() {
    DeleteLogRequest request = DeleteLogRequest.newBuilder().setLogName(LOG_NAME_PB).build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(loggingRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.service();
    assertTrue(logging.deleteLog(LOG_NAME));
  }

  @Test
  public void testDeleteLog_Null() {
    DeleteLogRequest request = DeleteLogRequest.newBuilder().setLogName(LOG_NAME_PB).build();
    EasyMock.expect(loggingRpcMock.delete(request)).andReturn(Futures.<Empty>immediateFuture(null));
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.service();
    assertFalse(logging.deleteLog(LOG_NAME));
  }

  @Test
  public void testDeleteLogAync() throws ExecutionException, InterruptedException {
    DeleteLogRequest request = DeleteLogRequest.newBuilder().setLogName(LOG_NAME_PB).build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(loggingRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.service();
    assertTrue(logging.deleteLogAsync(LOG_NAME).get());
  }

  @Test
  public void testDeleteLogAsync_Null() throws ExecutionException, InterruptedException {
    DeleteLogRequest request = DeleteLogRequest.newBuilder().setLogName(LOG_NAME_PB).build();
    EasyMock.expect(loggingRpcMock.delete(request)).andReturn(Futures.<Empty>immediateFuture(null));
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.service();
    assertFalse(logging.deleteLogAsync(LOG_NAME).get());
  }
}
