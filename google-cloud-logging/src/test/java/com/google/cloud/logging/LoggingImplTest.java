/*
 * Copyright 2016 Google LLC
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

import static com.google.cloud.logging.SinkInfo.VersionFormat;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.paging.AsyncPage;
import com.google.api.gax.paging.Page;
import com.google.cloud.MonitoredResource;
import com.google.cloud.MonitoredResourceDescriptor;
import com.google.cloud.ServiceOptions;
import com.google.cloud.logging.Logging.EntryListOption;
import com.google.cloud.logging.Logging.ListOption;
import com.google.cloud.logging.Logging.SortingField;
import com.google.cloud.logging.Logging.WriteOption;
import com.google.cloud.logging.Payload.StringPayload;
import com.google.cloud.logging.SinkInfo.Destination;
import com.google.cloud.logging.spi.LoggingRpcFactory;
import com.google.cloud.logging.spi.v2.LoggingRpc;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.logging.v2.CreateLogMetricRequest;
import com.google.logging.v2.CreateSinkRequest;
import com.google.logging.v2.DeleteLogMetricRequest;
import com.google.logging.v2.DeleteLogRequest;
import com.google.logging.v2.DeleteSinkRequest;
import com.google.logging.v2.GetLogMetricRequest;
import com.google.logging.v2.GetSinkRequest;
import com.google.logging.v2.ListLogEntriesRequest;
import com.google.logging.v2.ListLogEntriesResponse;
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
import com.google.logging.v2.WriteLogEntriesRequest;
import com.google.logging.v2.WriteLogEntriesResponse;
import com.google.protobuf.Empty;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LoggingImplTest {

  private static final String PROJECT = "project";
  private static final String PROJECT_PB = "projects/" + PROJECT;
  private static final String SINK_NAME = "sink";
  private static final SinkInfo SINK_INFO =
      SinkInfo.newBuilder(SINK_NAME, Destination.BucketDestination.of("bucket"))
          .setVersionFormat(VersionFormat.V2)
          .build();
  private static final String SINK_NAME_PB = "projects/" + PROJECT + "/sinks/" + SINK_NAME;
  private static final String METRIC_NAME = "metric";
  private static final String METRIC_NAME_PB = "projects/" + PROJECT + "/metrics/" + METRIC_NAME;
  private static final String FILTER = "logName=projects/my-projectid/logs/syslog";
  private static final String DESCRIPTION = "description";
  private static final MetricInfo METRIC_INFO =
      MetricInfo.newBuilder(METRIC_NAME, FILTER).setDescription(DESCRIPTION).build();
  private static final com.google.api.MonitoredResourceDescriptor DESCRIPTOR_PB =
      com.google.api.MonitoredResourceDescriptor.getDefaultInstance();
  private static final MonitoredResourceDescriptor DESCRIPTOR =
      MonitoredResourceDescriptor.fromPb(DESCRIPTOR_PB);
  private static final String LOG_NAME = "log";
  private static final String LOG_NAME_PB = "projects/" + PROJECT + "/logs/" + LOG_NAME;
  private static final MonitoredResource MONITORED_RESOURCE =
      MonitoredResource.newBuilder("global").addLabel("project-id", PROJECT).build();
  private static final LogEntry LOG_ENTRY1 =
      LogEntry.newBuilder(StringPayload.of("entry1"))
          .setLogName(LOG_NAME)
          .setResource(MONITORED_RESOURCE)
          .build();
  private static final LogEntry LOG_ENTRY2 =
      LogEntry.newBuilder(StringPayload.of("entry2"))
          .setLogName(LOG_NAME)
          .setResource(MONITORED_RESOURCE)
          .build();
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
  private static final Function<
          MonitoredResourceDescriptor, com.google.api.MonitoredResourceDescriptor>
      DESCRIPTOR_TO_PB_FUNCTION =
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

  @Rule public ExpectedException thrown = ExpectedException.none();

  @Before
  public void setUp() {
    rpcFactoryMock = EasyMock.createStrictMock(LoggingRpcFactory.class);
    loggingRpcMock = EasyMock.createStrictMock(LoggingRpc.class);
    EasyMock.expect(rpcFactoryMock.create(EasyMock.anyObject(LoggingOptions.class)))
        .andReturn(loggingRpcMock);
    options =
        LoggingOptions.newBuilder()
            .setProjectId(PROJECT)
            .setServiceRpcFactory(rpcFactoryMock)
            .setRetrySettings(ServiceOptions.getNoRetrySettings())
            .build();
  }

  @After
  public void tearDown() {
    EasyMock.verify(rpcFactoryMock, loggingRpcMock);
  }

  @Test
  public void testGetOptions() {
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    assertSame(options, options.getService().getOptions());
  }

  @Test
  public void testCreateSink() {
    LogSink sinkPb = SINK_INFO.toPb(PROJECT);
    ApiFuture<LogSink> response = ApiFutures.immediateFuture(sinkPb);
    CreateSinkRequest request =
        CreateSinkRequest.newBuilder().setParent(PROJECT_PB).setSink(sinkPb).build();
    EasyMock.expect(loggingRpcMock.create(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    Sink sink = logging.create(SINK_INFO);
    assertEquals(new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)), sink);
  }

  @Test
  public void testCreateSinkAsync() throws ExecutionException, InterruptedException {
    LogSink sinkPb = SINK_INFO.toPb(PROJECT);
    ApiFuture<LogSink> response = ApiFutures.immediateFuture(sinkPb);
    CreateSinkRequest request =
        CreateSinkRequest.newBuilder().setParent(PROJECT_PB).setSink(sinkPb).build();
    EasyMock.expect(loggingRpcMock.create(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    Sink sink = logging.createAsync(SINK_INFO).get();
    assertEquals(new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)), sink);
  }

  @Test
  public void testUpdateSink() {
    LogSink sinkPb = SINK_INFO.toPb(PROJECT);
    ApiFuture<LogSink> response = ApiFutures.immediateFuture(sinkPb);
    UpdateSinkRequest request =
        UpdateSinkRequest.newBuilder().setSinkName(SINK_NAME_PB).setSink(sinkPb).build();
    EasyMock.expect(loggingRpcMock.update(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    Sink sink = logging.update(SINK_INFO);
    assertEquals(new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)), sink);
  }

  @Test
  public void testUpdateSinkAsync() throws ExecutionException, InterruptedException {
    LogSink sinkPb = SINK_INFO.toPb(PROJECT);
    ApiFuture<LogSink> response = ApiFutures.immediateFuture(sinkPb);
    UpdateSinkRequest request =
        UpdateSinkRequest.newBuilder().setSinkName(SINK_NAME_PB).setSink(sinkPb).build();
    EasyMock.expect(loggingRpcMock.update(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    Sink sink = logging.updateAsync(SINK_INFO).get();
    assertEquals(new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)), sink);
  }

  @Test
  public void testGetSink() {
    LogSink sinkPb = SINK_INFO.toPb(PROJECT);
    ApiFuture<LogSink> response = ApiFutures.immediateFuture(sinkPb);
    GetSinkRequest request = GetSinkRequest.newBuilder().setSinkName(SINK_NAME_PB).build();
    EasyMock.expect(loggingRpcMock.get(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    Sink sink = logging.getSink(SINK_NAME);
    assertEquals(new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)), sink);
  }

  @Test
  public void testGetSink_Null() {
    ApiFuture<LogSink> response = ApiFutures.immediateFuture(null);
    GetSinkRequest request = GetSinkRequest.newBuilder().setSinkName(SINK_NAME_PB).build();
    EasyMock.expect(loggingRpcMock.get(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    assertNull(logging.getSink(SINK_NAME));
  }

  @Test
  public void testGetSinkAsync() throws ExecutionException, InterruptedException {
    LogSink sinkPb = SINK_INFO.toPb(PROJECT);
    ApiFuture<LogSink> response = ApiFutures.immediateFuture(sinkPb);
    GetSinkRequest request = GetSinkRequest.newBuilder().setSinkName(SINK_NAME_PB).build();
    EasyMock.expect(loggingRpcMock.get(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    Sink sink = logging.getSinkAsync(SINK_NAME).get();
    assertEquals(new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)), sink);
  }

  @Test
  public void testGetSinkAsync_Null() throws ExecutionException, InterruptedException {
    ApiFuture<LogSink> response = ApiFutures.immediateFuture(null);
    GetSinkRequest request = GetSinkRequest.newBuilder().setSinkName(SINK_NAME_PB).build();
    EasyMock.expect(loggingRpcMock.get(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    assertNull(logging.getSinkAsync(SINK_NAME).get());
  }

  @Test
  public void testDeleteSink() {
    DeleteSinkRequest request = DeleteSinkRequest.newBuilder().setSinkName(SINK_NAME_PB).build();
    ApiFuture<Empty> response = ApiFutures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(loggingRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    assertTrue(logging.deleteSink(SINK_NAME));
  }

  @Test
  public void testDeleteSink_Null() {
    DeleteSinkRequest request = DeleteSinkRequest.newBuilder().setSinkName(SINK_NAME_PB).build();
    ApiFuture<Empty> response = ApiFutures.immediateFuture(null);
    EasyMock.expect(loggingRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    assertFalse(logging.deleteSink(SINK_NAME));
  }

  @Test
  public void testDeleteSinkAsync() throws ExecutionException, InterruptedException {
    DeleteSinkRequest request = DeleteSinkRequest.newBuilder().setSinkName(SINK_NAME_PB).build();
    ApiFuture<Empty> response = ApiFutures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(loggingRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    assertTrue(logging.deleteSinkAsync(SINK_NAME).get());
  }

  @Test
  public void testDeleteSinkAsync_Null() throws ExecutionException, InterruptedException {
    DeleteSinkRequest request = DeleteSinkRequest.newBuilder().setSinkName(SINK_NAME_PB).build();
    ApiFuture<Empty> response = ApiFutures.immediateFuture(null);
    EasyMock.expect(loggingRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    assertFalse(logging.deleteSinkAsync(SINK_NAME).get());
  }

  @Test
  public void testListSinks() {
    String cursor = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.getService();
    ListSinksRequest request = ListSinksRequest.newBuilder().setParent(PROJECT_PB).build();
    List<Sink> sinkList =
        ImmutableList.of(
            new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)),
            new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)));
    ListSinksResponse response =
        ListSinksResponse.newBuilder()
            .setNextPageToken(cursor)
            .addAllSinks(Lists.transform(sinkList, SINK_TO_PB_FUNCTION))
            .build();
    ApiFuture<ListSinksResponse> futureResponse = ApiFutures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    Page<Sink> page = logging.listSinks();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(sinkList.toArray(), Iterables.toArray(page.getValues(), Sink.class));
  }

  @Test
  public void testListSinksNextPage() {
    String cursor1 = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.getService();
    ListSinksRequest request1 = ListSinksRequest.newBuilder().setParent(PROJECT_PB).build();
    ListSinksRequest request2 =
        ListSinksRequest.newBuilder().setParent(PROJECT_PB).setPageToken(cursor1).build();
    List<Sink> sinkList1 =
        ImmutableList.of(
            new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)),
            new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)));
    List<Sink> sinkList2 = ImmutableList.of(new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)));
    ListSinksResponse response1 =
        ListSinksResponse.newBuilder()
            .setNextPageToken(cursor1)
            .addAllSinks(Lists.transform(sinkList1, SINK_TO_PB_FUNCTION))
            .build();
    String cursor2 = "nextCursor";
    ListSinksResponse response2 =
        ListSinksResponse.newBuilder()
            .setNextPageToken(cursor2)
            .addAllSinks(Lists.transform(sinkList2, SINK_TO_PB_FUNCTION))
            .build();
    ApiFuture<ListSinksResponse> futureResponse1 = ApiFutures.immediateFuture(response1);
    ApiFuture<ListSinksResponse> futureResponse2 = ApiFutures.immediateFuture(response2);
    EasyMock.expect(loggingRpcMock.list(request1)).andReturn(futureResponse1);
    EasyMock.expect(loggingRpcMock.list(request2)).andReturn(futureResponse2);
    EasyMock.replay(loggingRpcMock);
    Page<Sink> page = logging.listSinks();
    assertEquals(cursor1, page.getNextPageToken());
    assertArrayEquals(sinkList1.toArray(), Iterables.toArray(page.getValues(), Sink.class));
    page = page.getNextPage();
    assertEquals(cursor2, page.getNextPageToken());
    assertArrayEquals(sinkList2.toArray(), Iterables.toArray(page.getValues(), Sink.class));
  }

  @Test
  public void testListSinksEmpty() {
    EasyMock.replay(rpcFactoryMock);
    logging = options.getService();
    ListSinksRequest request = ListSinksRequest.newBuilder().setParent(PROJECT_PB).build();
    List<Sink> sinkList = ImmutableList.of();
    ListSinksResponse response =
        ListSinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllSinks(Lists.transform(sinkList, SINK_TO_PB_FUNCTION))
            .build();
    ApiFuture<ListSinksResponse> futureResponse = ApiFutures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    Page<Sink> page = logging.listSinks();
    assertNull(page.getNextPageToken());
    assertNull(page.getNextPage());
    assertArrayEquals(sinkList.toArray(), Iterables.toArray(page.getValues(), Sink.class));
  }

  @Test
  public void testListSinksWithOptions() {
    String cursor = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.getService();
    ListSinksRequest request =
        ListSinksRequest.newBuilder()
            .setPageToken(cursor)
            .setPageSize(42)
            .setParent(PROJECT_PB)
            .build();
    List<Sink> sinkList =
        ImmutableList.of(
            new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)),
            new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)));
    ListSinksResponse response =
        ListSinksResponse.newBuilder()
            .setNextPageToken(cursor)
            .addAllSinks(Lists.transform(sinkList, SINK_TO_PB_FUNCTION))
            .build();
    ApiFuture<ListSinksResponse> futureResponse = ApiFutures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    Page<Sink> page = logging.listSinks(ListOption.pageSize(42), ListOption.pageToken(cursor));
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(sinkList.toArray(), Iterables.toArray(page.getValues(), Sink.class));
  }

  @Test
  public void testListSinksAsync() throws ExecutionException, InterruptedException {
    String cursor = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.getService();
    ListSinksRequest request = ListSinksRequest.newBuilder().setParent(PROJECT_PB).build();
    List<Sink> sinkList =
        ImmutableList.of(
            new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)),
            new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)));
    ListSinksResponse response =
        ListSinksResponse.newBuilder()
            .setNextPageToken(cursor)
            .addAllSinks(Lists.transform(sinkList, SINK_TO_PB_FUNCTION))
            .build();
    ApiFuture<ListSinksResponse> futureResponse = ApiFutures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    AsyncPage<Sink> page = logging.listSinksAsync().get();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(sinkList.toArray(), Iterables.toArray(page.getValues(), Sink.class));
  }

  @Test
  public void testListSinksAsyncNextPage() throws ExecutionException, InterruptedException {
    String cursor1 = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.getService();
    ListSinksRequest request1 = ListSinksRequest.newBuilder().setParent(PROJECT_PB).build();
    ListSinksRequest request2 =
        ListSinksRequest.newBuilder().setParent(PROJECT_PB).setPageToken(cursor1).build();
    List<Sink> sinkList1 =
        ImmutableList.of(
            new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)),
            new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)));
    List<Sink> sinkList2 = ImmutableList.of(new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)));
    ListSinksResponse response1 =
        ListSinksResponse.newBuilder()
            .setNextPageToken(cursor1)
            .addAllSinks(Lists.transform(sinkList1, SINK_TO_PB_FUNCTION))
            .build();
    String cursor2 = "nextCursor";
    ListSinksResponse response2 =
        ListSinksResponse.newBuilder()
            .setNextPageToken(cursor2)
            .addAllSinks(Lists.transform(sinkList2, SINK_TO_PB_FUNCTION))
            .build();
    ApiFuture<ListSinksResponse> futureResponse1 = ApiFutures.immediateFuture(response1);
    ApiFuture<ListSinksResponse> futureResponse2 = ApiFutures.immediateFuture(response2);
    EasyMock.expect(loggingRpcMock.list(request1)).andReturn(futureResponse1);
    EasyMock.expect(loggingRpcMock.list(request2)).andReturn(futureResponse2);
    EasyMock.replay(loggingRpcMock);
    AsyncPage<Sink> page = logging.listSinksAsync().get();
    assertEquals(cursor1, page.getNextPageToken());
    assertArrayEquals(sinkList1.toArray(), Iterables.toArray(page.getValues(), Sink.class));
    page = page.getNextPageAsync().get();
    assertEquals(cursor2, page.getNextPageToken());
    assertArrayEquals(sinkList2.toArray(), Iterables.toArray(page.getValues(), Sink.class));
  }

  @Test
  public void testListSinksAsyncEmpty() throws ExecutionException, InterruptedException {
    EasyMock.replay(rpcFactoryMock);
    logging = options.getService();
    ListSinksRequest request = ListSinksRequest.newBuilder().setParent(PROJECT_PB).build();
    List<Sink> sinkList = ImmutableList.of();
    ListSinksResponse response =
        ListSinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllSinks(Lists.transform(sinkList, SINK_TO_PB_FUNCTION))
            .build();
    ApiFuture<ListSinksResponse> futureResponse = ApiFutures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    AsyncPage<Sink> page = logging.listSinksAsync().get();
    assertNull(page.getNextPageToken());
    assertNull(page.getNextPage());
    assertArrayEquals(sinkList.toArray(), Iterables.toArray(page.getValues(), Sink.class));
  }

  @Test
  public void testListSinksWithOptionsAsync() throws ExecutionException, InterruptedException {
    String cursor = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.getService();
    ListSinksRequest request =
        ListSinksRequest.newBuilder()
            .setPageToken(cursor)
            .setPageSize(42)
            .setParent(PROJECT_PB)
            .build();
    List<Sink> sinkList =
        ImmutableList.of(
            new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)),
            new Sink(logging, new SinkInfo.BuilderImpl(SINK_INFO)));
    ListSinksResponse response =
        ListSinksResponse.newBuilder()
            .setNextPageToken(cursor)
            .addAllSinks(Lists.transform(sinkList, SINK_TO_PB_FUNCTION))
            .build();
    ApiFuture<ListSinksResponse> futureResponse = ApiFutures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    AsyncPage<Sink> page =
        logging.listSinksAsync(ListOption.pageSize(42), ListOption.pageToken(cursor)).get();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(sinkList.toArray(), Iterables.toArray(page.getValues(), Sink.class));
  }

  @Test
  public void testCreateMetric() {
    LogMetric metricPb = METRIC_INFO.toPb();
    ApiFuture<LogMetric> response = ApiFutures.immediateFuture(metricPb);
    CreateLogMetricRequest request =
        CreateLogMetricRequest.newBuilder().setParent(PROJECT_PB).setMetric(metricPb).build();
    EasyMock.expect(loggingRpcMock.create(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    Metric metric = logging.create(METRIC_INFO);
    assertEquals(new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)), metric);
  }

  @Test
  public void testCreateMetricAsync() throws ExecutionException, InterruptedException {
    LogMetric metricPb = METRIC_INFO.toPb();
    ApiFuture<LogMetric> response = ApiFutures.immediateFuture(metricPb);
    CreateLogMetricRequest request =
        CreateLogMetricRequest.newBuilder().setParent(PROJECT_PB).setMetric(metricPb).build();
    EasyMock.expect(loggingRpcMock.create(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    Metric metric = logging.createAsync(METRIC_INFO).get();
    assertEquals(new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)), metric);
  }

  @Test
  public void testUpdateMetric() {
    LogMetric sinkPb = METRIC_INFO.toPb();
    ApiFuture<LogMetric> response = ApiFutures.immediateFuture(sinkPb);
    UpdateLogMetricRequest request =
        UpdateLogMetricRequest.newBuilder().setMetricName(METRIC_NAME_PB).setMetric(sinkPb).build();
    EasyMock.expect(loggingRpcMock.update(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    Metric sink = logging.update(METRIC_INFO);
    assertEquals(new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)), sink);
  }

  @Test
  public void testUpdateMetricAsync() throws ExecutionException, InterruptedException {
    LogMetric sinkPb = METRIC_INFO.toPb();
    ApiFuture<LogMetric> response = ApiFutures.immediateFuture(sinkPb);
    UpdateLogMetricRequest request =
        UpdateLogMetricRequest.newBuilder().setMetricName(METRIC_NAME_PB).setMetric(sinkPb).build();
    EasyMock.expect(loggingRpcMock.update(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    Metric sink = logging.updateAsync(METRIC_INFO).get();
    assertEquals(new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)), sink);
  }

  @Test
  public void testGetMetric() {
    LogMetric sinkPb = METRIC_INFO.toPb();
    ApiFuture<LogMetric> response = ApiFutures.immediateFuture(sinkPb);
    GetLogMetricRequest request =
        GetLogMetricRequest.newBuilder().setMetricName(METRIC_NAME_PB).build();
    EasyMock.expect(loggingRpcMock.get(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    Metric sink = logging.getMetric(METRIC_NAME);
    assertEquals(new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)), sink);
  }

  @Test
  public void testGetMetric_Null() {
    ApiFuture<LogMetric> response = ApiFutures.immediateFuture(null);
    GetLogMetricRequest request =
        GetLogMetricRequest.newBuilder().setMetricName(METRIC_NAME_PB).build();
    EasyMock.expect(loggingRpcMock.get(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    assertNull(logging.getMetric(METRIC_NAME));
  }

  @Test
  public void testGetMetricAsync() throws ExecutionException, InterruptedException {
    LogMetric sinkPb = METRIC_INFO.toPb();
    ApiFuture<LogMetric> response = ApiFutures.immediateFuture(sinkPb);
    GetLogMetricRequest request =
        GetLogMetricRequest.newBuilder().setMetricName(METRIC_NAME_PB).build();
    EasyMock.expect(loggingRpcMock.get(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    Metric sink = logging.getMetricAsync(METRIC_NAME).get();
    assertEquals(new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)), sink);
  }

  @Test
  public void testGetMetricAsync_Null() throws ExecutionException, InterruptedException {
    ApiFuture<LogMetric> response = ApiFutures.immediateFuture(null);
    GetLogMetricRequest request =
        GetLogMetricRequest.newBuilder().setMetricName(METRIC_NAME_PB).build();
    EasyMock.expect(loggingRpcMock.get(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    assertNull(logging.getMetricAsync(METRIC_NAME).get());
  }

  @Test
  public void testDeleteMetric() {
    DeleteLogMetricRequest request =
        DeleteLogMetricRequest.newBuilder().setMetricName(METRIC_NAME_PB).build();
    ApiFuture<Empty> response = ApiFutures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(loggingRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    assertTrue(logging.deleteMetric(METRIC_NAME));
  }

  @Test
  public void testDeleteMetric_Null() {
    DeleteLogMetricRequest request =
        DeleteLogMetricRequest.newBuilder().setMetricName(METRIC_NAME_PB).build();
    ApiFuture<Empty> response = ApiFutures.immediateFuture(null);
    EasyMock.expect(loggingRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    assertFalse(logging.deleteMetric(METRIC_NAME));
  }

  @Test
  public void testDeleteMetricAsync() throws ExecutionException, InterruptedException {
    DeleteLogMetricRequest request =
        DeleteLogMetricRequest.newBuilder().setMetricName(METRIC_NAME_PB).build();
    ApiFuture<Empty> response = ApiFutures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(loggingRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    assertTrue(logging.deleteMetricAsync(METRIC_NAME).get());
  }

  @Test
  public void testDeleteMetricAsync_Null() throws ExecutionException, InterruptedException {
    DeleteLogMetricRequest request =
        DeleteLogMetricRequest.newBuilder().setMetricName(METRIC_NAME_PB).build();
    ApiFuture<Empty> response = ApiFutures.immediateFuture(null);
    EasyMock.expect(loggingRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    assertFalse(logging.deleteMetricAsync(METRIC_NAME).get());
  }

  @Test
  public void testListMetrics() {
    String cursor = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.getService();
    ListLogMetricsRequest request =
        ListLogMetricsRequest.newBuilder().setParent(PROJECT_PB).build();
    List<Metric> sinkList =
        ImmutableList.of(
            new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)),
            new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)));
    ListLogMetricsResponse response =
        ListLogMetricsResponse.newBuilder()
            .setNextPageToken(cursor)
            .addAllMetrics(Lists.transform(sinkList, METRIC_TO_PB_FUNCTION))
            .build();
    ApiFuture<ListLogMetricsResponse> futureResponse = ApiFutures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    Page<Metric> page = logging.listMetrics();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(sinkList.toArray(), Iterables.toArray(page.getValues(), Metric.class));
  }

  @Test
  public void testListMetricsNextPage() {
    String cursor1 = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.getService();
    ListLogMetricsRequest request1 =
        ListLogMetricsRequest.newBuilder().setParent(PROJECT_PB).build();
    ListLogMetricsRequest request2 =
        ListLogMetricsRequest.newBuilder().setParent(PROJECT_PB).setPageToken(cursor1).build();
    List<Metric> sinkList1 =
        ImmutableList.of(
            new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)),
            new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)));
    List<Metric> sinkList2 =
        ImmutableList.of(new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)));
    ListLogMetricsResponse response1 =
        ListLogMetricsResponse.newBuilder()
            .setNextPageToken(cursor1)
            .addAllMetrics(Lists.transform(sinkList1, METRIC_TO_PB_FUNCTION))
            .build();
    String cursor2 = "nextCursor";
    ListLogMetricsResponse response2 =
        ListLogMetricsResponse.newBuilder()
            .setNextPageToken(cursor2)
            .addAllMetrics(Lists.transform(sinkList2, METRIC_TO_PB_FUNCTION))
            .build();
    ApiFuture<ListLogMetricsResponse> futureResponse1 = ApiFutures.immediateFuture(response1);
    ApiFuture<ListLogMetricsResponse> futureResponse2 = ApiFutures.immediateFuture(response2);
    EasyMock.expect(loggingRpcMock.list(request1)).andReturn(futureResponse1);
    EasyMock.expect(loggingRpcMock.list(request2)).andReturn(futureResponse2);
    EasyMock.replay(loggingRpcMock);
    Page<Metric> page = logging.listMetrics();
    assertEquals(cursor1, page.getNextPageToken());
    assertArrayEquals(sinkList1.toArray(), Iterables.toArray(page.getValues(), Metric.class));
    page = page.getNextPage();
    assertEquals(cursor2, page.getNextPageToken());
    assertArrayEquals(sinkList2.toArray(), Iterables.toArray(page.getValues(), Metric.class));
  }

  @Test
  public void testListMetricsEmpty() {
    EasyMock.replay(rpcFactoryMock);
    logging = options.getService();
    ListLogMetricsRequest request =
        ListLogMetricsRequest.newBuilder().setParent(PROJECT_PB).build();
    List<Metric> sinkList = ImmutableList.of();
    ListLogMetricsResponse response =
        ListLogMetricsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMetrics(Lists.transform(sinkList, METRIC_TO_PB_FUNCTION))
            .build();
    ApiFuture<ListLogMetricsResponse> futureResponse = ApiFutures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    Page<Metric> page = logging.listMetrics();
    assertNull(page.getNextPageToken());
    assertNull(page.getNextPage());
    assertArrayEquals(sinkList.toArray(), Iterables.toArray(page.getValues(), Metric.class));
  }

  @Test
  public void testListMetricsWithOptions() {
    String cursor = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.getService();
    ListLogMetricsRequest request =
        ListLogMetricsRequest.newBuilder()
            .setPageToken(cursor)
            .setPageSize(42)
            .setParent(PROJECT_PB)
            .build();
    List<Metric> sinkList =
        ImmutableList.of(
            new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)),
            new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)));
    ListLogMetricsResponse response =
        ListLogMetricsResponse.newBuilder()
            .setNextPageToken(cursor)
            .addAllMetrics(Lists.transform(sinkList, METRIC_TO_PB_FUNCTION))
            .build();
    ApiFuture<ListLogMetricsResponse> futureResponse = ApiFutures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    Page<Metric> page = logging.listMetrics(ListOption.pageSize(42), ListOption.pageToken(cursor));
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(sinkList.toArray(), Iterables.toArray(page.getValues(), Metric.class));
  }

  @Test
  public void testListMetricsAsync() throws ExecutionException, InterruptedException {
    String cursor = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.getService();
    ListLogMetricsRequest request =
        ListLogMetricsRequest.newBuilder().setParent(PROJECT_PB).build();
    List<Metric> sinkList =
        ImmutableList.of(
            new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)),
            new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)));
    ListLogMetricsResponse response =
        ListLogMetricsResponse.newBuilder()
            .setNextPageToken(cursor)
            .addAllMetrics(Lists.transform(sinkList, METRIC_TO_PB_FUNCTION))
            .build();
    ApiFuture<ListLogMetricsResponse> futureResponse = ApiFutures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    AsyncPage<Metric> page = logging.listMetricsAsync().get();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(sinkList.toArray(), Iterables.toArray(page.getValues(), Metric.class));
  }

  @Test
  public void testListMetricsAsyncNextPage() throws ExecutionException, InterruptedException {
    String cursor1 = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.getService();
    ListLogMetricsRequest request1 =
        ListLogMetricsRequest.newBuilder().setParent(PROJECT_PB).build();
    ListLogMetricsRequest request2 =
        ListLogMetricsRequest.newBuilder().setParent(PROJECT_PB).setPageToken(cursor1).build();
    List<Metric> sinkList1 =
        ImmutableList.of(
            new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)),
            new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)));
    List<Metric> sinkList2 =
        ImmutableList.of(new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)));
    ListLogMetricsResponse response1 =
        ListLogMetricsResponse.newBuilder()
            .setNextPageToken(cursor1)
            .addAllMetrics(Lists.transform(sinkList1, METRIC_TO_PB_FUNCTION))
            .build();
    String cursor2 = "nextCursor";
    ListLogMetricsResponse response2 =
        ListLogMetricsResponse.newBuilder()
            .setNextPageToken(cursor2)
            .addAllMetrics(Lists.transform(sinkList2, METRIC_TO_PB_FUNCTION))
            .build();
    ApiFuture<ListLogMetricsResponse> futureResponse1 = ApiFutures.immediateFuture(response1);
    ApiFuture<ListLogMetricsResponse> futureResponse2 = ApiFutures.immediateFuture(response2);
    EasyMock.expect(loggingRpcMock.list(request1)).andReturn(futureResponse1);
    EasyMock.expect(loggingRpcMock.list(request2)).andReturn(futureResponse2);
    EasyMock.replay(loggingRpcMock);
    AsyncPage<Metric> page = logging.listMetricsAsync().get();
    assertEquals(cursor1, page.getNextPageToken());
    assertArrayEquals(sinkList1.toArray(), Iterables.toArray(page.getValues(), Metric.class));
    page = page.getNextPageAsync().get();
    assertEquals(cursor2, page.getNextPageToken());
    assertArrayEquals(sinkList2.toArray(), Iterables.toArray(page.getValues(), Metric.class));
  }

  @Test
  public void testListMetricsAsyncEmpty() throws ExecutionException, InterruptedException {
    EasyMock.replay(rpcFactoryMock);
    logging = options.getService();
    ListLogMetricsRequest request =
        ListLogMetricsRequest.newBuilder().setParent(PROJECT_PB).build();
    List<Metric> sinkList = ImmutableList.of();
    ListLogMetricsResponse response =
        ListLogMetricsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMetrics(Lists.transform(sinkList, METRIC_TO_PB_FUNCTION))
            .build();
    ApiFuture<ListLogMetricsResponse> futureResponse = ApiFutures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    AsyncPage<Metric> page = logging.listMetricsAsync().get();
    assertNull(page.getNextPageToken());
    assertNull(page.getNextPage());
    assertArrayEquals(sinkList.toArray(), Iterables.toArray(page.getValues(), Metric.class));
  }

  @Test
  public void testListMetricsWithOptionsAsync() throws ExecutionException, InterruptedException {
    String cursor = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.getService();
    ListLogMetricsRequest request =
        ListLogMetricsRequest.newBuilder()
            .setPageToken(cursor)
            .setPageSize(42)
            .setParent(PROJECT_PB)
            .build();
    List<Metric> sinkList =
        ImmutableList.of(
            new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)),
            new Metric(logging, new MetricInfo.BuilderImpl(METRIC_INFO)));
    ListLogMetricsResponse response =
        ListLogMetricsResponse.newBuilder()
            .setNextPageToken(cursor)
            .addAllMetrics(Lists.transform(sinkList, METRIC_TO_PB_FUNCTION))
            .build();
    ApiFuture<ListLogMetricsResponse> futureResponse = ApiFutures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    AsyncPage<Metric> page =
        logging.listMetricsAsync(ListOption.pageSize(42), ListOption.pageToken(cursor)).get();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(sinkList.toArray(), Iterables.toArray(page.getValues(), Metric.class));
  }

  @Test
  public void testListResourceDescriptor() {
    String cursor = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.getService();
    ListMonitoredResourceDescriptorsRequest request =
        ListMonitoredResourceDescriptorsRequest.newBuilder().build();
    List<MonitoredResourceDescriptor> descriptorList = ImmutableList.of(DESCRIPTOR, DESCRIPTOR);
    ListMonitoredResourceDescriptorsResponse response =
        ListMonitoredResourceDescriptorsResponse.newBuilder()
            .setNextPageToken(cursor)
            .addAllResourceDescriptors(Lists.transform(descriptorList, DESCRIPTOR_TO_PB_FUNCTION))
            .build();
    ApiFuture<ListMonitoredResourceDescriptorsResponse> futureResponse =
        ApiFutures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    Page<MonitoredResourceDescriptor> page = logging.listMonitoredResourceDescriptors();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(
        descriptorList.toArray(),
        Iterables.toArray(page.getValues(), MonitoredResourceDescriptor.class));
  }

  @Test
  public void testListResourceDescriptorNextPage() {
    String cursor1 = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.getService();
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
    ApiFuture<ListMonitoredResourceDescriptorsResponse> futureResponse1 =
        ApiFutures.immediateFuture(response1);
    ApiFuture<ListMonitoredResourceDescriptorsResponse> futureResponse2 =
        ApiFutures.immediateFuture(response2);
    EasyMock.expect(loggingRpcMock.list(request1)).andReturn(futureResponse1);
    EasyMock.expect(loggingRpcMock.list(request2)).andReturn(futureResponse2);
    EasyMock.replay(loggingRpcMock);
    Page<MonitoredResourceDescriptor> page = logging.listMonitoredResourceDescriptors();
    assertEquals(cursor1, page.getNextPageToken());
    assertArrayEquals(
        descriptorList1.toArray(),
        Iterables.toArray(page.getValues(), MonitoredResourceDescriptor.class));
    page = page.getNextPage();
    assertEquals(cursor2, page.getNextPageToken());
    assertArrayEquals(
        descriptorList2.toArray(),
        Iterables.toArray(page.getValues(), MonitoredResourceDescriptor.class));
  }

  @Test
  public void testListResourceDescriptorEmpty() {
    EasyMock.replay(rpcFactoryMock);
    logging = options.getService();
    ListMonitoredResourceDescriptorsRequest request =
        ListMonitoredResourceDescriptorsRequest.newBuilder().build();
    List<MonitoredResourceDescriptor> descriptorList = ImmutableList.of();
    ListMonitoredResourceDescriptorsResponse response =
        ListMonitoredResourceDescriptorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllResourceDescriptors(Lists.transform(descriptorList, DESCRIPTOR_TO_PB_FUNCTION))
            .build();
    ApiFuture<ListMonitoredResourceDescriptorsResponse> futureResponse =
        ApiFutures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    Page<MonitoredResourceDescriptor> page = logging.listMonitoredResourceDescriptors();
    assertNull(page.getNextPageToken());
    assertNull(page.getNextPage());
    assertArrayEquals(
        descriptorList.toArray(),
        Iterables.toArray(page.getValues(), MonitoredResourceDescriptor.class));
  }

  @Test
  public void testListResourceDescriptorWithOptions() {
    String cursor = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.getService();
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
    ApiFuture<ListMonitoredResourceDescriptorsResponse> futureResponse =
        ApiFutures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    Page<MonitoredResourceDescriptor> page =
        logging.listMonitoredResourceDescriptors(
            ListOption.pageSize(42), ListOption.pageToken(cursor));
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(
        descriptorList.toArray(),
        Iterables.toArray(page.getValues(), MonitoredResourceDescriptor.class));
  }

  @Test
  public void testListResourceDescriptorAsync() throws ExecutionException, InterruptedException {
    String cursor = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.getService();
    ListMonitoredResourceDescriptorsRequest request =
        ListMonitoredResourceDescriptorsRequest.newBuilder().build();
    List<MonitoredResourceDescriptor> descriptorList = ImmutableList.of(DESCRIPTOR, DESCRIPTOR);
    ListMonitoredResourceDescriptorsResponse response =
        ListMonitoredResourceDescriptorsResponse.newBuilder()
            .setNextPageToken(cursor)
            .addAllResourceDescriptors(Lists.transform(descriptorList, DESCRIPTOR_TO_PB_FUNCTION))
            .build();
    ApiFuture<ListMonitoredResourceDescriptorsResponse> futureResponse =
        ApiFutures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    AsyncPage<MonitoredResourceDescriptor> page =
        logging.listMonitoredResourceDescriptorsAsync().get();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(
        descriptorList.toArray(),
        Iterables.toArray(page.getValues(), MonitoredResourceDescriptor.class));
  }

  @Test
  public void testListResourceDescriptorAsyncNextPage()
      throws ExecutionException, InterruptedException {
    String cursor1 = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.getService();
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
    ApiFuture<ListMonitoredResourceDescriptorsResponse> futureResponse1 =
        ApiFutures.immediateFuture(response1);
    ApiFuture<ListMonitoredResourceDescriptorsResponse> futureResponse2 =
        ApiFutures.immediateFuture(response2);
    EasyMock.expect(loggingRpcMock.list(request1)).andReturn(futureResponse1);
    EasyMock.expect(loggingRpcMock.list(request2)).andReturn(futureResponse2);
    EasyMock.replay(loggingRpcMock);
    AsyncPage<MonitoredResourceDescriptor> page =
        logging.listMonitoredResourceDescriptorsAsync().get();
    assertEquals(cursor1, page.getNextPageToken());
    assertArrayEquals(
        descriptorList1.toArray(),
        Iterables.toArray(page.getValues(), MonitoredResourceDescriptor.class));
    page = page.getNextPageAsync().get();
    assertEquals(cursor2, page.getNextPageToken());
    assertArrayEquals(
        descriptorList2.toArray(),
        Iterables.toArray(page.getValues(), MonitoredResourceDescriptor.class));
  }

  @Test
  public void testListResourceDescriptorAsyncEmpty()
      throws ExecutionException, InterruptedException {
    EasyMock.replay(rpcFactoryMock);
    logging = options.getService();
    ListMonitoredResourceDescriptorsRequest request =
        ListMonitoredResourceDescriptorsRequest.newBuilder().build();
    List<MonitoredResourceDescriptor> descriptorList = ImmutableList.of();
    ListMonitoredResourceDescriptorsResponse response =
        ListMonitoredResourceDescriptorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllResourceDescriptors(Lists.transform(descriptorList, DESCRIPTOR_TO_PB_FUNCTION))
            .build();
    ApiFuture<ListMonitoredResourceDescriptorsResponse> futureResponse =
        ApiFutures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    AsyncPage<MonitoredResourceDescriptor> page =
        logging.listMonitoredResourceDescriptorsAsync().get();
    assertNull(page.getNextPageToken());
    assertNull(page.getNextPage());
    assertArrayEquals(
        descriptorList.toArray(),
        Iterables.toArray(page.getValues(), MonitoredResourceDescriptor.class));
  }

  @Test
  public void testListResourceDescriptorAsyncWithOptions()
      throws ExecutionException, InterruptedException {
    String cursor = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.getService();
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
    ApiFuture<ListMonitoredResourceDescriptorsResponse> futureResponse =
        ApiFutures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    AsyncPage<MonitoredResourceDescriptor> page =
        logging
            .listMonitoredResourceDescriptorsAsync(
                ListOption.pageSize(42), ListOption.pageToken(cursor))
            .get();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(
        descriptorList.toArray(),
        Iterables.toArray(page.getValues(), MonitoredResourceDescriptor.class));
  }

  @Test
  public void testDeleteLog() {
    DeleteLogRequest request = DeleteLogRequest.newBuilder().setLogName(LOG_NAME_PB).build();
    ApiFuture<Empty> response = ApiFutures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(loggingRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    assertTrue(logging.deleteLog(LOG_NAME));
  }

  @Test
  public void testDeleteLog_Null() {
    DeleteLogRequest request = DeleteLogRequest.newBuilder().setLogName(LOG_NAME_PB).build();
    EasyMock.expect(loggingRpcMock.delete(request))
        .andReturn(ApiFutures.<Empty>immediateFuture(null));
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    assertFalse(logging.deleteLog(LOG_NAME));
  }

  @Test
  public void testDeleteLogAync() throws ExecutionException, InterruptedException {
    DeleteLogRequest request = DeleteLogRequest.newBuilder().setLogName(LOG_NAME_PB).build();
    ApiFuture<Empty> response = ApiFutures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(loggingRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    assertTrue(logging.deleteLogAsync(LOG_NAME).get());
  }

  @Test
  public void testDeleteLogAsync_Null() throws ExecutionException, InterruptedException {
    DeleteLogRequest request = DeleteLogRequest.newBuilder().setLogName(LOG_NAME_PB).build();
    EasyMock.expect(loggingRpcMock.delete(request))
        .andReturn(ApiFutures.<Empty>immediateFuture(null));
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    assertFalse(logging.deleteLogAsync(LOG_NAME).get());
  }

  @Test
  public void testWriteLogEntries() {
    WriteLogEntriesRequest request =
        WriteLogEntriesRequest.newBuilder()
            .addAllEntries(
                Iterables.transform(
                    ImmutableList.of(LOG_ENTRY1, LOG_ENTRY2), LogEntry.toPbFunction(PROJECT)))
            .build();
    WriteLogEntriesResponse response = WriteLogEntriesResponse.newBuilder().build();
    EasyMock.expect(loggingRpcMock.write(request)).andReturn(ApiFutures.immediateFuture(response));
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    logging.write(ImmutableList.of(LOG_ENTRY1, LOG_ENTRY2));
    assertEquals(0, ((LoggingImpl) logging).getNumPendingWrites());
  }

  @Test
  public void testWriteLogEntriesDoesnotEnableFlushByDefault() {
    WriteLogEntriesRequest request =
        WriteLogEntriesRequest.newBuilder()
            .addAllEntries(
                Iterables.transform(
                    ImmutableList.of(
                        LOG_ENTRY1, LOG_ENTRY2.toBuilder().setSeverity(Severity.EMERGENCY).build()),
                    LogEntry.toPbFunction(PROJECT)))
            .build();
    ApiFuture<WriteLogEntriesResponse> apiFuture = SettableApiFuture.create();
    EasyMock.expect(loggingRpcMock.write(request)).andReturn(apiFuture);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    logging.write(
        ImmutableList.of(
            LOG_ENTRY1, LOG_ENTRY2.toBuilder().setSeverity(Severity.EMERGENCY).build()));
  }

  @Test
  public void testWriteLogEntriesWithSeverityFlushEnabled() {
    WriteLogEntriesRequest request =
        WriteLogEntriesRequest.newBuilder()
            .addAllEntries(
                Iterables.transform(
                    ImmutableList.of(LOG_ENTRY1, LOG_ENTRY2), LogEntry.toPbFunction(PROJECT)))
            .build();
    WriteLogEntriesResponse response = WriteLogEntriesResponse.newBuilder().build();
    EasyMock.expect(loggingRpcMock.write(request)).andReturn(ApiFutures.immediateFuture(response));
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    logging.setFlushSeverity(Severity.DEFAULT);
    logging.write(ImmutableList.of(LOG_ENTRY1, LOG_ENTRY2));
  }

  @Test
  public void testWriteLogEntriesWithOptions() {
    Map<String, String> labels = ImmutableMap.of("key", "value");
    WriteLogEntriesRequest request =
        WriteLogEntriesRequest.newBuilder()
            .putAllLabels(labels)
            .setLogName(LOG_NAME_PB)
            .setResource(MONITORED_RESOURCE.toPb())
            .addAllEntries(
                Iterables.transform(
                    ImmutableList.of(LOG_ENTRY1, LOG_ENTRY2), LogEntry.toPbFunction(PROJECT)))
            .build();
    WriteLogEntriesResponse response = WriteLogEntriesResponse.newBuilder().build();
    EasyMock.expect(loggingRpcMock.write(request)).andReturn(ApiFutures.immediateFuture(response));
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    logging.write(
        ImmutableList.of(LOG_ENTRY1, LOG_ENTRY2),
        WriteOption.logName(LOG_NAME),
        WriteOption.resource(MONITORED_RESOURCE),
        WriteOption.labels(labels));
  }

  @Test
  public void testWriteLogEntriesAsync() throws ExecutionException, InterruptedException {
    WriteLogEntriesRequest request =
        WriteLogEntriesRequest.newBuilder()
            .addAllEntries(
                Iterables.transform(
                    ImmutableList.of(LOG_ENTRY1, LOG_ENTRY2), LogEntry.toPbFunction(PROJECT)))
            .build();
    WriteLogEntriesResponse response = WriteLogEntriesResponse.newBuilder().build();
    EasyMock.expect(loggingRpcMock.write(request)).andReturn(ApiFutures.immediateFuture(response));
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    logging.write(ImmutableList.of(LOG_ENTRY1, LOG_ENTRY2));
    logging.flush();
  }

  @Test
  public void testWriteLogEntriesAsyncWithOptions() {
    Map<String, String> labels = ImmutableMap.of("key", "value");
    WriteLogEntriesRequest request =
        WriteLogEntriesRequest.newBuilder()
            .putAllLabels(labels)
            .setLogName(LOG_NAME_PB)
            .setResource(MONITORED_RESOURCE.toPb())
            .addAllEntries(
                Iterables.transform(
                    ImmutableList.of(LOG_ENTRY1, LOG_ENTRY2), LogEntry.toPbFunction(PROJECT)))
            .build();
    WriteLogEntriesResponse response = WriteLogEntriesResponse.newBuilder().build();
    EasyMock.expect(loggingRpcMock.write(request)).andReturn(ApiFutures.immediateFuture(response));
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.getService();
    logging.write(
        ImmutableList.of(LOG_ENTRY1, LOG_ENTRY2),
        WriteOption.logName(LOG_NAME),
        WriteOption.resource(MONITORED_RESOURCE),
        WriteOption.labels(labels));
    logging.flush();
  }

  @Test
  public void testListLogEntries() {
    String cursor = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.getService();
    ListLogEntriesRequest request =
        ListLogEntriesRequest.newBuilder().addResourceNames(PROJECT_PB).build();
    List<LogEntry> entriesList = ImmutableList.of(LOG_ENTRY1, LOG_ENTRY2);
    ListLogEntriesResponse response =
        ListLogEntriesResponse.newBuilder()
            .setNextPageToken(cursor)
            .addAllEntries(Lists.transform(entriesList, LogEntry.toPbFunction(PROJECT)))
            .build();
    ApiFuture<ListLogEntriesResponse> futureResponse = ApiFutures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    Page<LogEntry> page = logging.listLogEntries();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(entriesList.toArray(), Iterables.toArray(page.getValues(), LogEntry.class));
  }

  @Test
  public void testListLogEntriesNextPage() throws ExecutionException, InterruptedException {
    String cursor1 = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.getService();
    ListLogEntriesRequest request1 =
        ListLogEntriesRequest.newBuilder().addResourceNames(PROJECT_PB).build();
    ListLogEntriesRequest request2 =
        ListLogEntriesRequest.newBuilder()
            .addResourceNames(PROJECT_PB)
            .setPageToken(cursor1)
            .build();
    List<LogEntry> descriptorList1 = ImmutableList.of(LOG_ENTRY1, LOG_ENTRY2);
    List<LogEntry> descriptorList2 = ImmutableList.of(LOG_ENTRY1);
    ListLogEntriesResponse response1 =
        ListLogEntriesResponse.newBuilder()
            .setNextPageToken(cursor1)
            .addAllEntries(Lists.transform(descriptorList1, LogEntry.toPbFunction(PROJECT)))
            .build();
    String cursor2 = "nextCursor";
    ListLogEntriesResponse response2 =
        ListLogEntriesResponse.newBuilder()
            .setNextPageToken(cursor2)
            .addAllEntries(Lists.transform(descriptorList2, LogEntry.toPbFunction(PROJECT)))
            .build();
    ApiFuture<ListLogEntriesResponse> futureResponse1 = ApiFutures.immediateFuture(response1);
    ApiFuture<ListLogEntriesResponse> futureResponse2 = ApiFutures.immediateFuture(response2);
    EasyMock.expect(loggingRpcMock.list(request1)).andReturn(futureResponse1);
    EasyMock.expect(loggingRpcMock.list(request2)).andReturn(futureResponse2);
    EasyMock.replay(loggingRpcMock);
    AsyncPage<LogEntry> page = logging.listLogEntriesAsync().get();
    assertEquals(cursor1, page.getNextPageToken());
    assertArrayEquals(
        descriptorList1.toArray(), Iterables.toArray(page.getValues(), LogEntry.class));
    page = page.getNextPageAsync().get();
    assertEquals(cursor2, page.getNextPageToken());
    assertArrayEquals(
        descriptorList2.toArray(), Iterables.toArray(page.getValues(), LogEntry.class));
  }

  @Test
  public void testListLogEntriesEmpty() {
    String cursor = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.getService();
    ListLogEntriesRequest request =
        ListLogEntriesRequest.newBuilder().addResourceNames(PROJECT_PB).build();
    List<LogEntry> entriesList = ImmutableList.of();
    ListLogEntriesResponse response =
        ListLogEntriesResponse.newBuilder()
            .setNextPageToken(cursor)
            .addAllEntries(Lists.transform(entriesList, LogEntry.toPbFunction(PROJECT)))
            .build();
    ApiFuture<ListLogEntriesResponse> futureResponse = ApiFutures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    Page<LogEntry> page = logging.listLogEntries();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(entriesList.toArray(), Iterables.toArray(page.getValues(), LogEntry.class));
  }

  @Test
  public void testListLogEntriesWithOptions() {
    String cursor = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.getService();
    ListLogEntriesRequest request =
        ListLogEntriesRequest.newBuilder()
            .addResourceNames(PROJECT_PB)
            .setOrderBy("timestamp desc")
            .setFilter("logName:syslog")
            .build();
    List<LogEntry> entriesList = ImmutableList.of(LOG_ENTRY1, LOG_ENTRY2);
    ListLogEntriesResponse response =
        ListLogEntriesResponse.newBuilder()
            .setNextPageToken(cursor)
            .addAllEntries(Lists.transform(entriesList, LogEntry.toPbFunction(PROJECT)))
            .build();
    ApiFuture<ListLogEntriesResponse> futureResponse = ApiFutures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    Page<LogEntry> page =
        logging.listLogEntries(
            EntryListOption.filter("logName:syslog"),
            EntryListOption.sortOrder(SortingField.TIMESTAMP, Logging.SortingOrder.DESCENDING));
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(entriesList.toArray(), Iterables.toArray(page.getValues(), LogEntry.class));
  }

  @Test
  public void testListLogEntriesAsync() throws ExecutionException, InterruptedException {
    String cursor = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.getService();
    ListLogEntriesRequest request =
        ListLogEntriesRequest.newBuilder().addResourceNames(PROJECT_PB).build();
    List<LogEntry> entriesList = ImmutableList.of(LOG_ENTRY1, LOG_ENTRY2);
    ListLogEntriesResponse response =
        ListLogEntriesResponse.newBuilder()
            .setNextPageToken(cursor)
            .addAllEntries(Lists.transform(entriesList, LogEntry.toPbFunction(PROJECT)))
            .build();
    ApiFuture<ListLogEntriesResponse> futureResponse = ApiFutures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    AsyncPage<LogEntry> page = logging.listLogEntriesAsync().get();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(entriesList.toArray(), Iterables.toArray(page.getValues(), LogEntry.class));
  }

  @Test
  public void testListLogEntriesAsyncNextPage() {
    String cursor1 = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.getService();
    ListLogEntriesRequest request1 =
        ListLogEntriesRequest.newBuilder().addResourceNames(PROJECT_PB).build();
    ListLogEntriesRequest request2 =
        ListLogEntriesRequest.newBuilder()
            .addResourceNames(PROJECT_PB)
            .setPageToken(cursor1)
            .build();
    List<LogEntry> descriptorList1 = ImmutableList.of(LOG_ENTRY1, LOG_ENTRY2);
    List<LogEntry> descriptorList2 = ImmutableList.of(LOG_ENTRY1);
    ListLogEntriesResponse response1 =
        ListLogEntriesResponse.newBuilder()
            .setNextPageToken(cursor1)
            .addAllEntries(Lists.transform(descriptorList1, LogEntry.toPbFunction(PROJECT)))
            .build();
    String cursor2 = "nextCursor";
    ListLogEntriesResponse response2 =
        ListLogEntriesResponse.newBuilder()
            .setNextPageToken(cursor2)
            .addAllEntries(Lists.transform(descriptorList2, LogEntry.toPbFunction(PROJECT)))
            .build();
    ApiFuture<ListLogEntriesResponse> futureResponse1 = ApiFutures.immediateFuture(response1);
    ApiFuture<ListLogEntriesResponse> futureResponse2 = ApiFutures.immediateFuture(response2);
    EasyMock.expect(loggingRpcMock.list(request1)).andReturn(futureResponse1);
    EasyMock.expect(loggingRpcMock.list(request2)).andReturn(futureResponse2);
    EasyMock.replay(loggingRpcMock);
    Page<LogEntry> page = logging.listLogEntries();
    assertEquals(cursor1, page.getNextPageToken());
    assertArrayEquals(
        descriptorList1.toArray(), Iterables.toArray(page.getValues(), LogEntry.class));
    page = page.getNextPage();
    assertEquals(cursor2, page.getNextPageToken());
    assertArrayEquals(
        descriptorList2.toArray(), Iterables.toArray(page.getValues(), LogEntry.class));
  }

  @Test
  public void testListLogEntriesAyncEmpty() throws ExecutionException, InterruptedException {
    String cursor = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.getService();
    ListLogEntriesRequest request =
        ListLogEntriesRequest.newBuilder().addResourceNames(PROJECT_PB).build();
    List<LogEntry> entriesList = ImmutableList.of();
    ListLogEntriesResponse response =
        ListLogEntriesResponse.newBuilder()
            .setNextPageToken(cursor)
            .addAllEntries(Lists.transform(entriesList, LogEntry.toPbFunction(PROJECT)))
            .build();
    ApiFuture<ListLogEntriesResponse> futureResponse = ApiFutures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    AsyncPage<LogEntry> page = logging.listLogEntriesAsync().get();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(entriesList.toArray(), Iterables.toArray(page.getValues(), LogEntry.class));
  }

  @Test
  public void testListLogEntriesAsyncWithOptions() throws ExecutionException, InterruptedException {
    String cursor = "cursor";
    EasyMock.replay(rpcFactoryMock);
    logging = options.getService();
    ListLogEntriesRequest request =
        ListLogEntriesRequest.newBuilder()
            .addResourceNames(PROJECT_PB)
            .setOrderBy("timestamp desc")
            .setFilter("logName:syslog")
            .build();
    List<LogEntry> entriesList = ImmutableList.of(LOG_ENTRY1, LOG_ENTRY2);
    ListLogEntriesResponse response =
        ListLogEntriesResponse.newBuilder()
            .setNextPageToken(cursor)
            .addAllEntries(Lists.transform(entriesList, LogEntry.toPbFunction(PROJECT)))
            .build();
    ApiFuture<ListLogEntriesResponse> futureResponse = ApiFutures.immediateFuture(response);
    EasyMock.expect(loggingRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(loggingRpcMock);
    AsyncPage<LogEntry> page =
        logging
            .listLogEntriesAsync(
                EntryListOption.filter("logName:syslog"),
                EntryListOption.sortOrder(SortingField.TIMESTAMP, Logging.SortingOrder.DESCENDING))
            .get();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(entriesList.toArray(), Iterables.toArray(page.getValues(), LogEntry.class));
  }

  @Test
  public void testFlush() throws InterruptedException {
    SettableApiFuture<WriteLogEntriesResponse> mockRpcResponse = SettableApiFuture.create();
    replay(rpcFactoryMock);
    logging = options.getService();
    WriteLogEntriesRequest request =
        WriteLogEntriesRequest.newBuilder()
            .addAllEntries(
                Iterables.transform(
                    ImmutableList.of(LOG_ENTRY1, LOG_ENTRY2), LogEntry.toPbFunction(PROJECT)))
            .build();
    EasyMock.expect(loggingRpcMock.write(request)).andReturn(mockRpcResponse);
    EasyMock.replay(loggingRpcMock);
    // no messages, nothing to flush.
    logging.flush();

    // send a message
    logging.write(ImmutableList.of(LOG_ENTRY1, LOG_ENTRY2));
    Thread flushWaiter =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                logging.flush();
              }
            });
    flushWaiter.start();

    // flushWaiter should be waiting for mockRpc to complete.
    flushWaiter.join(1000);
    assertTrue(flushWaiter.isAlive());

    // With the RPC completed, flush should return, and the thread should terminate.
    mockRpcResponse.set(null);
    flushWaiter.join(1000);
    assertFalse(flushWaiter.isAlive());
  }

  @Test
  public void testFlushStress() throws InterruptedException {
    SettableApiFuture<WriteLogEntriesResponse> mockRpcResponse = SettableApiFuture.create();
    mockRpcResponse.set(null);
    replay(rpcFactoryMock);
    logging = options.getService();
    WriteLogEntriesRequest request =
        WriteLogEntriesRequest.newBuilder()
            .addAllEntries(
                Iterables.transform(ImmutableList.of(LOG_ENTRY1), LogEntry.toPbFunction(PROJECT)))
            .build();

    Thread[] threads = new Thread[100];
    EasyMock.expect(loggingRpcMock.write(request)).andReturn(mockRpcResponse).times(threads.length);
    EasyMock.replay(loggingRpcMock);

    // log and flush concurrently in many threads to trigger a ConcurrentModificationException
    final AtomicInteger exceptions = new AtomicInteger(0);
    for (int i = 0; i < threads.length; i++) {
      threads[i] =
          new Thread() {
            @Override
            public void run() {
              try {
                logging.write(ImmutableList.of(LOG_ENTRY1));
                logging.flush();
              } catch (Exception ex) {
                exceptions.incrementAndGet();
              }
            }
          };
      threads[i].start();
    }
    for (int i = 0; i < threads.length; i++) {
      threads[i].join();
    }
    assertSame(0, exceptions.get());
  }
}
