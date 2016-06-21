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
import com.google.logging.v2.CreateSinkRequest;
import com.google.logging.v2.DeleteSinkRequest;
import com.google.logging.v2.GetSinkRequest;
import com.google.logging.v2.ListSinksRequest;
import com.google.logging.v2.ListSinksResponse;
import com.google.logging.v2.LogSink;
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
  private static final Function<SinkInfo, LogSink> SINK_TO_PB_FUNCTION =
      new Function<SinkInfo, LogSink>() {
        @Override
        public LogSink apply(SinkInfo sinkInfo) {
          return sinkInfo.toPb(PROJECT);
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
    assertTrue(logging.deleteSink("sink"));
  }

  @Test
  public void testDeleteSink_Null() {
    DeleteSinkRequest request = DeleteSinkRequest.newBuilder().setSinkName(SINK_NAME_PB).build();
    Future<Empty> response = Futures.immediateFuture(null);
    EasyMock.expect(loggingRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.service();
    assertFalse(logging.deleteSink("sink"));
  }

  @Test
  public void testDeleteSinkAsync() throws ExecutionException, InterruptedException {
    DeleteSinkRequest request = DeleteSinkRequest.newBuilder().setSinkName(SINK_NAME_PB).build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(loggingRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.service();
    assertTrue(logging.deleteSinkAsync("sink").get());
  }

  @Test
  public void testDeleteSinkAsync_Null() throws ExecutionException, InterruptedException {
    DeleteSinkRequest request = DeleteSinkRequest.newBuilder().setSinkName(SINK_NAME_PB).build();
    Future<Empty> response = Futures.immediateFuture(null);
    EasyMock.expect(loggingRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock);
    logging = options.service();
    assertFalse(logging.deleteSinkAsync("sink").get());
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
}
