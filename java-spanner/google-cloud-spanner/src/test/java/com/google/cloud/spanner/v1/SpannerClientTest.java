/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.spanner.v1;

import static com.google.cloud.spanner.v1.SpannerClient.ListSessionsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.grpc.testing.MockStreamObserver;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.ListValue;
import com.google.protobuf.Struct;
import com.google.protobuf.Timestamp;
import com.google.protobuf.Value;
import com.google.rpc.Status;
import com.google.spanner.v1.BatchCreateSessionsRequest;
import com.google.spanner.v1.BatchCreateSessionsResponse;
import com.google.spanner.v1.BatchWriteRequest;
import com.google.spanner.v1.BatchWriteResponse;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CacheUpdate;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.CommitResponse;
import com.google.spanner.v1.CreateSessionRequest;
import com.google.spanner.v1.DatabaseName;
import com.google.spanner.v1.DeleteSessionRequest;
import com.google.spanner.v1.DirectedReadOptions;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteBatchDmlResponse;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.GetSessionRequest;
import com.google.spanner.v1.KeySet;
import com.google.spanner.v1.ListSessionsRequest;
import com.google.spanner.v1.ListSessionsResponse;
import com.google.spanner.v1.MultiplexedSessionPrecommitToken;
import com.google.spanner.v1.Mutation;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.Partition;
import com.google.spanner.v1.PartitionOptions;
import com.google.spanner.v1.PartitionQueryRequest;
import com.google.spanner.v1.PartitionReadRequest;
import com.google.spanner.v1.PartitionResponse;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.RequestOptions;
import com.google.spanner.v1.ResultSet;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.ResultSetStats;
import com.google.spanner.v1.RollbackRequest;
import com.google.spanner.v1.RoutingHint;
import com.google.spanner.v1.Session;
import com.google.spanner.v1.SessionName;
import com.google.spanner.v1.Transaction;
import com.google.spanner.v1.TransactionOptions;
import com.google.spanner.v1.TransactionSelector;
import com.google.spanner.v1.Type;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class SpannerClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockSpanner mockSpanner;
  private LocalChannelProvider channelProvider;
  private SpannerClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSpanner = new MockSpanner();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockSpanner));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
    SpannerSettings settings =
        SpannerSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SpannerClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createSessionTest() throws Exception {
    Session expectedResponse =
        Session.newBuilder()
            .setName(
                SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]").toString())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setApproximateLastUseTime(Timestamp.newBuilder().build())
            .setCreatorRole("creatorRole-190742846")
            .setMultiplexed(true)
            .build();
    mockSpanner.addResponse(expectedResponse);

    DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");

    Session actualResponse = client.createSession(database);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSessionRequest actualRequest = ((CreateSessionRequest) actualRequests.get(0));

    Assert.assertEquals(database.toString(), actualRequest.getDatabase());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSessionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpanner.addException(exception);

    try {
      DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
      client.createSession(database);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSessionTest2() throws Exception {
    Session expectedResponse =
        Session.newBuilder()
            .setName(
                SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]").toString())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setApproximateLastUseTime(Timestamp.newBuilder().build())
            .setCreatorRole("creatorRole-190742846")
            .setMultiplexed(true)
            .build();
    mockSpanner.addResponse(expectedResponse);

    String database = "database1789464955";

    Session actualResponse = client.createSession(database);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSessionRequest actualRequest = ((CreateSessionRequest) actualRequests.get(0));

    Assert.assertEquals(database, actualRequest.getDatabase());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSessionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpanner.addException(exception);

    try {
      String database = "database1789464955";
      client.createSession(database);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateSessionsTest() throws Exception {
    BatchCreateSessionsResponse expectedResponse =
        BatchCreateSessionsResponse.newBuilder().addAllSession(new ArrayList<Session>()).build();
    mockSpanner.addResponse(expectedResponse);

    DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
    int sessionCount = 185691686;

    BatchCreateSessionsResponse actualResponse = client.batchCreateSessions(database, sessionCount);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateSessionsRequest actualRequest = ((BatchCreateSessionsRequest) actualRequests.get(0));

    Assert.assertEquals(database.toString(), actualRequest.getDatabase());
    Assert.assertEquals(sessionCount, actualRequest.getSessionCount());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchCreateSessionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpanner.addException(exception);

    try {
      DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
      int sessionCount = 185691686;
      client.batchCreateSessions(database, sessionCount);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateSessionsTest2() throws Exception {
    BatchCreateSessionsResponse expectedResponse =
        BatchCreateSessionsResponse.newBuilder().addAllSession(new ArrayList<Session>()).build();
    mockSpanner.addResponse(expectedResponse);

    String database = "database1789464955";
    int sessionCount = 185691686;

    BatchCreateSessionsResponse actualResponse = client.batchCreateSessions(database, sessionCount);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateSessionsRequest actualRequest = ((BatchCreateSessionsRequest) actualRequests.get(0));

    Assert.assertEquals(database, actualRequest.getDatabase());
    Assert.assertEquals(sessionCount, actualRequest.getSessionCount());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchCreateSessionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpanner.addException(exception);

    try {
      String database = "database1789464955";
      int sessionCount = 185691686;
      client.batchCreateSessions(database, sessionCount);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSessionTest() throws Exception {
    Session expectedResponse =
        Session.newBuilder()
            .setName(
                SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]").toString())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setApproximateLastUseTime(Timestamp.newBuilder().build())
            .setCreatorRole("creatorRole-190742846")
            .setMultiplexed(true)
            .build();
    mockSpanner.addResponse(expectedResponse);

    SessionName name = SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]");

    Session actualResponse = client.getSession(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSessionRequest actualRequest = ((GetSessionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSessionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpanner.addException(exception);

    try {
      SessionName name = SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]");
      client.getSession(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSessionTest2() throws Exception {
    Session expectedResponse =
        Session.newBuilder()
            .setName(
                SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]").toString())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setApproximateLastUseTime(Timestamp.newBuilder().build())
            .setCreatorRole("creatorRole-190742846")
            .setMultiplexed(true)
            .build();
    mockSpanner.addResponse(expectedResponse);

    String name = "name3373707";

    Session actualResponse = client.getSession(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSessionRequest actualRequest = ((GetSessionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSessionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpanner.addException(exception);

    try {
      String name = "name3373707";
      client.getSession(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSessionsTest() throws Exception {
    Session responsesElement = Session.newBuilder().build();
    ListSessionsResponse expectedResponse =
        ListSessionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSessions(Arrays.asList(responsesElement))
            .build();
    mockSpanner.addResponse(expectedResponse);

    DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");

    ListSessionsPagedResponse pagedListResponse = client.listSessions(database);

    List<Session> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSessionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSpanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSessionsRequest actualRequest = ((ListSessionsRequest) actualRequests.get(0));

    Assert.assertEquals(database.toString(), actualRequest.getDatabase());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSessionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpanner.addException(exception);

    try {
      DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
      client.listSessions(database);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSessionsTest2() throws Exception {
    Session responsesElement = Session.newBuilder().build();
    ListSessionsResponse expectedResponse =
        ListSessionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSessions(Arrays.asList(responsesElement))
            .build();
    mockSpanner.addResponse(expectedResponse);

    String database = "database1789464955";

    ListSessionsPagedResponse pagedListResponse = client.listSessions(database);

    List<Session> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSessionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSpanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSessionsRequest actualRequest = ((ListSessionsRequest) actualRequests.get(0));

    Assert.assertEquals(database, actualRequest.getDatabase());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSessionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpanner.addException(exception);

    try {
      String database = "database1789464955";
      client.listSessions(database);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSessionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSpanner.addResponse(expectedResponse);

    SessionName name = SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]");

    client.deleteSession(name);

    List<AbstractMessage> actualRequests = mockSpanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSessionRequest actualRequest = ((DeleteSessionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSessionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpanner.addException(exception);

    try {
      SessionName name = SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]");
      client.deleteSession(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSessionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSpanner.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteSession(name);

    List<AbstractMessage> actualRequests = mockSpanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSessionRequest actualRequest = ((DeleteSessionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSessionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpanner.addException(exception);

    try {
      String name = "name3373707";
      client.deleteSession(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void executeSqlTest() throws Exception {
    ResultSet expectedResponse =
        ResultSet.newBuilder()
            .setMetadata(ResultSetMetadata.newBuilder().build())
            .addAllRows(new ArrayList<ListValue>())
            .setStats(ResultSetStats.newBuilder().build())
            .setPrecommitToken(MultiplexedSessionPrecommitToken.newBuilder().build())
            .setCacheUpdate(CacheUpdate.newBuilder().build())
            .build();
    mockSpanner.addResponse(expectedResponse);

    ExecuteSqlRequest request =
        ExecuteSqlRequest.newBuilder()
            .setSession(
                SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]").toString())
            .setTransaction(TransactionSelector.newBuilder().build())
            .setSql("sql114126")
            .setParams(Struct.newBuilder().build())
            .putAllParamTypes(new HashMap<String, Type>())
            .setResumeToken(ByteString.EMPTY)
            .setPartitionToken(ByteString.EMPTY)
            .setSeqno(109325920)
            .setQueryOptions(ExecuteSqlRequest.QueryOptions.newBuilder().build())
            .setRequestOptions(RequestOptions.newBuilder().build())
            .setDirectedReadOptions(DirectedReadOptions.newBuilder().build())
            .setDataBoostEnabled(true)
            .setLastStatement(true)
            .setRoutingHint(RoutingHint.newBuilder().build())
            .build();

    ResultSet actualResponse = client.executeSql(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExecuteSqlRequest actualRequest = ((ExecuteSqlRequest) actualRequests.get(0));

    Assert.assertEquals(request.getSession(), actualRequest.getSession());
    Assert.assertEquals(request.getTransaction(), actualRequest.getTransaction());
    Assert.assertEquals(request.getSql(), actualRequest.getSql());
    Assert.assertEquals(request.getParams(), actualRequest.getParams());
    Assert.assertEquals(request.getParamTypesMap(), actualRequest.getParamTypesMap());
    Assert.assertEquals(request.getResumeToken(), actualRequest.getResumeToken());
    Assert.assertEquals(request.getQueryMode(), actualRequest.getQueryMode());
    Assert.assertEquals(request.getPartitionToken(), actualRequest.getPartitionToken());
    Assert.assertEquals(request.getSeqno(), actualRequest.getSeqno());
    Assert.assertEquals(request.getQueryOptions(), actualRequest.getQueryOptions());
    Assert.assertEquals(request.getRequestOptions(), actualRequest.getRequestOptions());
    Assert.assertEquals(request.getDirectedReadOptions(), actualRequest.getDirectedReadOptions());
    Assert.assertEquals(request.getDataBoostEnabled(), actualRequest.getDataBoostEnabled());
    Assert.assertEquals(request.getLastStatement(), actualRequest.getLastStatement());
    Assert.assertEquals(request.getRoutingHint(), actualRequest.getRoutingHint());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void executeSqlExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpanner.addException(exception);

    try {
      ExecuteSqlRequest request =
          ExecuteSqlRequest.newBuilder()
              .setSession(
                  SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]").toString())
              .setTransaction(TransactionSelector.newBuilder().build())
              .setSql("sql114126")
              .setParams(Struct.newBuilder().build())
              .putAllParamTypes(new HashMap<String, Type>())
              .setResumeToken(ByteString.EMPTY)
              .setPartitionToken(ByteString.EMPTY)
              .setSeqno(109325920)
              .setQueryOptions(ExecuteSqlRequest.QueryOptions.newBuilder().build())
              .setRequestOptions(RequestOptions.newBuilder().build())
              .setDirectedReadOptions(DirectedReadOptions.newBuilder().build())
              .setDataBoostEnabled(true)
              .setLastStatement(true)
              .setRoutingHint(RoutingHint.newBuilder().build())
              .build();
      client.executeSql(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void executeStreamingSqlTest() throws Exception {
    PartialResultSet expectedResponse =
        PartialResultSet.newBuilder()
            .setMetadata(ResultSetMetadata.newBuilder().build())
            .addAllValues(new ArrayList<Value>())
            .setChunkedValue(true)
            .setResumeToken(ByteString.EMPTY)
            .setStats(ResultSetStats.newBuilder().build())
            .setPrecommitToken(MultiplexedSessionPrecommitToken.newBuilder().build())
            .setLast(true)
            .setCacheUpdate(CacheUpdate.newBuilder().build())
            .build();
    mockSpanner.addResponse(expectedResponse);
    ExecuteSqlRequest request =
        ExecuteSqlRequest.newBuilder()
            .setSession(
                SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]").toString())
            .setTransaction(TransactionSelector.newBuilder().build())
            .setSql("sql114126")
            .setParams(Struct.newBuilder().build())
            .putAllParamTypes(new HashMap<String, Type>())
            .setResumeToken(ByteString.EMPTY)
            .setPartitionToken(ByteString.EMPTY)
            .setSeqno(109325920)
            .setQueryOptions(ExecuteSqlRequest.QueryOptions.newBuilder().build())
            .setRequestOptions(RequestOptions.newBuilder().build())
            .setDirectedReadOptions(DirectedReadOptions.newBuilder().build())
            .setDataBoostEnabled(true)
            .setLastStatement(true)
            .setRoutingHint(RoutingHint.newBuilder().build())
            .build();

    MockStreamObserver<PartialResultSet> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ExecuteSqlRequest, PartialResultSet> callable =
        client.executeStreamingSqlCallable();
    callable.serverStreamingCall(request, responseObserver);

    List<PartialResultSet> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void executeStreamingSqlExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpanner.addException(exception);
    ExecuteSqlRequest request =
        ExecuteSqlRequest.newBuilder()
            .setSession(
                SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]").toString())
            .setTransaction(TransactionSelector.newBuilder().build())
            .setSql("sql114126")
            .setParams(Struct.newBuilder().build())
            .putAllParamTypes(new HashMap<String, Type>())
            .setResumeToken(ByteString.EMPTY)
            .setPartitionToken(ByteString.EMPTY)
            .setSeqno(109325920)
            .setQueryOptions(ExecuteSqlRequest.QueryOptions.newBuilder().build())
            .setRequestOptions(RequestOptions.newBuilder().build())
            .setDirectedReadOptions(DirectedReadOptions.newBuilder().build())
            .setDataBoostEnabled(true)
            .setLastStatement(true)
            .setRoutingHint(RoutingHint.newBuilder().build())
            .build();

    MockStreamObserver<PartialResultSet> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ExecuteSqlRequest, PartialResultSet> callable =
        client.executeStreamingSqlCallable();
    callable.serverStreamingCall(request, responseObserver);

    try {
      List<PartialResultSet> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void executeBatchDmlTest() throws Exception {
    ExecuteBatchDmlResponse expectedResponse =
        ExecuteBatchDmlResponse.newBuilder()
            .addAllResultSets(new ArrayList<ResultSet>())
            .setStatus(Status.newBuilder().build())
            .setPrecommitToken(MultiplexedSessionPrecommitToken.newBuilder().build())
            .build();
    mockSpanner.addResponse(expectedResponse);

    ExecuteBatchDmlRequest request =
        ExecuteBatchDmlRequest.newBuilder()
            .setSession(
                SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]").toString())
            .setTransaction(TransactionSelector.newBuilder().build())
            .addAllStatements(new ArrayList<ExecuteBatchDmlRequest.Statement>())
            .setSeqno(109325920)
            .setRequestOptions(RequestOptions.newBuilder().build())
            .setLastStatements(true)
            .build();

    ExecuteBatchDmlResponse actualResponse = client.executeBatchDml(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExecuteBatchDmlRequest actualRequest = ((ExecuteBatchDmlRequest) actualRequests.get(0));

    Assert.assertEquals(request.getSession(), actualRequest.getSession());
    Assert.assertEquals(request.getTransaction(), actualRequest.getTransaction());
    Assert.assertEquals(request.getStatementsList(), actualRequest.getStatementsList());
    Assert.assertEquals(request.getSeqno(), actualRequest.getSeqno());
    Assert.assertEquals(request.getRequestOptions(), actualRequest.getRequestOptions());
    Assert.assertEquals(request.getLastStatements(), actualRequest.getLastStatements());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void executeBatchDmlExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpanner.addException(exception);

    try {
      ExecuteBatchDmlRequest request =
          ExecuteBatchDmlRequest.newBuilder()
              .setSession(
                  SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]").toString())
              .setTransaction(TransactionSelector.newBuilder().build())
              .addAllStatements(new ArrayList<ExecuteBatchDmlRequest.Statement>())
              .setSeqno(109325920)
              .setRequestOptions(RequestOptions.newBuilder().build())
              .setLastStatements(true)
              .build();
      client.executeBatchDml(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void readTest() throws Exception {
    ResultSet expectedResponse =
        ResultSet.newBuilder()
            .setMetadata(ResultSetMetadata.newBuilder().build())
            .addAllRows(new ArrayList<ListValue>())
            .setStats(ResultSetStats.newBuilder().build())
            .setPrecommitToken(MultiplexedSessionPrecommitToken.newBuilder().build())
            .setCacheUpdate(CacheUpdate.newBuilder().build())
            .build();
    mockSpanner.addResponse(expectedResponse);

    ReadRequest request =
        ReadRequest.newBuilder()
            .setSession(
                SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]").toString())
            .setTransaction(TransactionSelector.newBuilder().build())
            .setTable("table110115790")
            .setIndex("index100346066")
            .addAllColumns(new ArrayList<String>())
            .setKeySet(KeySet.newBuilder().build())
            .setLimit(102976443)
            .setResumeToken(ByteString.EMPTY)
            .setPartitionToken(ByteString.EMPTY)
            .setRequestOptions(RequestOptions.newBuilder().build())
            .setDirectedReadOptions(DirectedReadOptions.newBuilder().build())
            .setDataBoostEnabled(true)
            .setRoutingHint(RoutingHint.newBuilder().build())
            .build();

    ResultSet actualResponse = client.read(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReadRequest actualRequest = ((ReadRequest) actualRequests.get(0));

    Assert.assertEquals(request.getSession(), actualRequest.getSession());
    Assert.assertEquals(request.getTransaction(), actualRequest.getTransaction());
    Assert.assertEquals(request.getTable(), actualRequest.getTable());
    Assert.assertEquals(request.getIndex(), actualRequest.getIndex());
    Assert.assertEquals(request.getColumnsList(), actualRequest.getColumnsList());
    Assert.assertEquals(request.getKeySet(), actualRequest.getKeySet());
    Assert.assertEquals(request.getLimit(), actualRequest.getLimit());
    Assert.assertEquals(request.getResumeToken(), actualRequest.getResumeToken());
    Assert.assertEquals(request.getPartitionToken(), actualRequest.getPartitionToken());
    Assert.assertEquals(request.getRequestOptions(), actualRequest.getRequestOptions());
    Assert.assertEquals(request.getDirectedReadOptions(), actualRequest.getDirectedReadOptions());
    Assert.assertEquals(request.getDataBoostEnabled(), actualRequest.getDataBoostEnabled());
    Assert.assertEquals(request.getOrderBy(), actualRequest.getOrderBy());
    Assert.assertEquals(request.getLockHint(), actualRequest.getLockHint());
    Assert.assertEquals(request.getRoutingHint(), actualRequest.getRoutingHint());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void readExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpanner.addException(exception);

    try {
      ReadRequest request =
          ReadRequest.newBuilder()
              .setSession(
                  SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]").toString())
              .setTransaction(TransactionSelector.newBuilder().build())
              .setTable("table110115790")
              .setIndex("index100346066")
              .addAllColumns(new ArrayList<String>())
              .setKeySet(KeySet.newBuilder().build())
              .setLimit(102976443)
              .setResumeToken(ByteString.EMPTY)
              .setPartitionToken(ByteString.EMPTY)
              .setRequestOptions(RequestOptions.newBuilder().build())
              .setDirectedReadOptions(DirectedReadOptions.newBuilder().build())
              .setDataBoostEnabled(true)
              .setRoutingHint(RoutingHint.newBuilder().build())
              .build();
      client.read(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void streamingReadTest() throws Exception {
    PartialResultSet expectedResponse =
        PartialResultSet.newBuilder()
            .setMetadata(ResultSetMetadata.newBuilder().build())
            .addAllValues(new ArrayList<Value>())
            .setChunkedValue(true)
            .setResumeToken(ByteString.EMPTY)
            .setStats(ResultSetStats.newBuilder().build())
            .setPrecommitToken(MultiplexedSessionPrecommitToken.newBuilder().build())
            .setLast(true)
            .setCacheUpdate(CacheUpdate.newBuilder().build())
            .build();
    mockSpanner.addResponse(expectedResponse);
    ReadRequest request =
        ReadRequest.newBuilder()
            .setSession(
                SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]").toString())
            .setTransaction(TransactionSelector.newBuilder().build())
            .setTable("table110115790")
            .setIndex("index100346066")
            .addAllColumns(new ArrayList<String>())
            .setKeySet(KeySet.newBuilder().build())
            .setLimit(102976443)
            .setResumeToken(ByteString.EMPTY)
            .setPartitionToken(ByteString.EMPTY)
            .setRequestOptions(RequestOptions.newBuilder().build())
            .setDirectedReadOptions(DirectedReadOptions.newBuilder().build())
            .setDataBoostEnabled(true)
            .setRoutingHint(RoutingHint.newBuilder().build())
            .build();

    MockStreamObserver<PartialResultSet> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ReadRequest, PartialResultSet> callable =
        client.streamingReadCallable();
    callable.serverStreamingCall(request, responseObserver);

    List<PartialResultSet> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void streamingReadExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpanner.addException(exception);
    ReadRequest request =
        ReadRequest.newBuilder()
            .setSession(
                SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]").toString())
            .setTransaction(TransactionSelector.newBuilder().build())
            .setTable("table110115790")
            .setIndex("index100346066")
            .addAllColumns(new ArrayList<String>())
            .setKeySet(KeySet.newBuilder().build())
            .setLimit(102976443)
            .setResumeToken(ByteString.EMPTY)
            .setPartitionToken(ByteString.EMPTY)
            .setRequestOptions(RequestOptions.newBuilder().build())
            .setDirectedReadOptions(DirectedReadOptions.newBuilder().build())
            .setDataBoostEnabled(true)
            .setRoutingHint(RoutingHint.newBuilder().build())
            .build();

    MockStreamObserver<PartialResultSet> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ReadRequest, PartialResultSet> callable =
        client.streamingReadCallable();
    callable.serverStreamingCall(request, responseObserver);

    try {
      List<PartialResultSet> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void beginTransactionTest() throws Exception {
    Transaction expectedResponse =
        Transaction.newBuilder()
            .setId(ByteString.EMPTY)
            .setReadTimestamp(Timestamp.newBuilder().build())
            .setPrecommitToken(MultiplexedSessionPrecommitToken.newBuilder().build())
            .setCacheUpdate(CacheUpdate.newBuilder().build())
            .build();
    mockSpanner.addResponse(expectedResponse);

    SessionName session = SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]");
    TransactionOptions options = TransactionOptions.newBuilder().build();

    Transaction actualResponse = client.beginTransaction(session, options);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BeginTransactionRequest actualRequest = ((BeginTransactionRequest) actualRequests.get(0));

    Assert.assertEquals(session.toString(), actualRequest.getSession());
    Assert.assertEquals(options, actualRequest.getOptions());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void beginTransactionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpanner.addException(exception);

    try {
      SessionName session = SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]");
      TransactionOptions options = TransactionOptions.newBuilder().build();
      client.beginTransaction(session, options);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void beginTransactionTest2() throws Exception {
    Transaction expectedResponse =
        Transaction.newBuilder()
            .setId(ByteString.EMPTY)
            .setReadTimestamp(Timestamp.newBuilder().build())
            .setPrecommitToken(MultiplexedSessionPrecommitToken.newBuilder().build())
            .setCacheUpdate(CacheUpdate.newBuilder().build())
            .build();
    mockSpanner.addResponse(expectedResponse);

    String session = "session1984987798";
    TransactionOptions options = TransactionOptions.newBuilder().build();

    Transaction actualResponse = client.beginTransaction(session, options);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BeginTransactionRequest actualRequest = ((BeginTransactionRequest) actualRequests.get(0));

    Assert.assertEquals(session, actualRequest.getSession());
    Assert.assertEquals(options, actualRequest.getOptions());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void beginTransactionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpanner.addException(exception);

    try {
      String session = "session1984987798";
      TransactionOptions options = TransactionOptions.newBuilder().build();
      client.beginTransaction(session, options);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void commitTest() throws Exception {
    CommitResponse expectedResponse =
        CommitResponse.newBuilder()
            .setCommitTimestamp(Timestamp.newBuilder().build())
            .setCommitStats(CommitResponse.CommitStats.newBuilder().build())
            .setSnapshotTimestamp(Timestamp.newBuilder().build())
            .setCacheUpdate(CacheUpdate.newBuilder().build())
            .build();
    mockSpanner.addResponse(expectedResponse);

    SessionName session = SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]");
    ByteString transactionId = ByteString.EMPTY;
    List<Mutation> mutations = new ArrayList<>();

    CommitResponse actualResponse = client.commit(session, transactionId, mutations);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CommitRequest actualRequest = ((CommitRequest) actualRequests.get(0));

    Assert.assertEquals(session.toString(), actualRequest.getSession());
    Assert.assertEquals(transactionId, actualRequest.getTransactionId());
    Assert.assertEquals(mutations, actualRequest.getMutationsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void commitExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpanner.addException(exception);

    try {
      SessionName session = SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]");
      ByteString transactionId = ByteString.EMPTY;
      List<Mutation> mutations = new ArrayList<>();
      client.commit(session, transactionId, mutations);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void commitTest2() throws Exception {
    CommitResponse expectedResponse =
        CommitResponse.newBuilder()
            .setCommitTimestamp(Timestamp.newBuilder().build())
            .setCommitStats(CommitResponse.CommitStats.newBuilder().build())
            .setSnapshotTimestamp(Timestamp.newBuilder().build())
            .setCacheUpdate(CacheUpdate.newBuilder().build())
            .build();
    mockSpanner.addResponse(expectedResponse);

    SessionName session = SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]");
    TransactionOptions singleUseTransaction = TransactionOptions.newBuilder().build();
    List<Mutation> mutations = new ArrayList<>();

    CommitResponse actualResponse = client.commit(session, singleUseTransaction, mutations);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CommitRequest actualRequest = ((CommitRequest) actualRequests.get(0));

    Assert.assertEquals(session.toString(), actualRequest.getSession());
    Assert.assertEquals(singleUseTransaction, actualRequest.getSingleUseTransaction());
    Assert.assertEquals(mutations, actualRequest.getMutationsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void commitExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpanner.addException(exception);

    try {
      SessionName session = SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]");
      TransactionOptions singleUseTransaction = TransactionOptions.newBuilder().build();
      List<Mutation> mutations = new ArrayList<>();
      client.commit(session, singleUseTransaction, mutations);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void commitTest3() throws Exception {
    CommitResponse expectedResponse =
        CommitResponse.newBuilder()
            .setCommitTimestamp(Timestamp.newBuilder().build())
            .setCommitStats(CommitResponse.CommitStats.newBuilder().build())
            .setSnapshotTimestamp(Timestamp.newBuilder().build())
            .setCacheUpdate(CacheUpdate.newBuilder().build())
            .build();
    mockSpanner.addResponse(expectedResponse);

    String session = "session1984987798";
    ByteString transactionId = ByteString.EMPTY;
    List<Mutation> mutations = new ArrayList<>();

    CommitResponse actualResponse = client.commit(session, transactionId, mutations);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CommitRequest actualRequest = ((CommitRequest) actualRequests.get(0));

    Assert.assertEquals(session, actualRequest.getSession());
    Assert.assertEquals(transactionId, actualRequest.getTransactionId());
    Assert.assertEquals(mutations, actualRequest.getMutationsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void commitExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpanner.addException(exception);

    try {
      String session = "session1984987798";
      ByteString transactionId = ByteString.EMPTY;
      List<Mutation> mutations = new ArrayList<>();
      client.commit(session, transactionId, mutations);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void commitTest4() throws Exception {
    CommitResponse expectedResponse =
        CommitResponse.newBuilder()
            .setCommitTimestamp(Timestamp.newBuilder().build())
            .setCommitStats(CommitResponse.CommitStats.newBuilder().build())
            .setSnapshotTimestamp(Timestamp.newBuilder().build())
            .setCacheUpdate(CacheUpdate.newBuilder().build())
            .build();
    mockSpanner.addResponse(expectedResponse);

    String session = "session1984987798";
    TransactionOptions singleUseTransaction = TransactionOptions.newBuilder().build();
    List<Mutation> mutations = new ArrayList<>();

    CommitResponse actualResponse = client.commit(session, singleUseTransaction, mutations);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CommitRequest actualRequest = ((CommitRequest) actualRequests.get(0));

    Assert.assertEquals(session, actualRequest.getSession());
    Assert.assertEquals(singleUseTransaction, actualRequest.getSingleUseTransaction());
    Assert.assertEquals(mutations, actualRequest.getMutationsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void commitExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpanner.addException(exception);

    try {
      String session = "session1984987798";
      TransactionOptions singleUseTransaction = TransactionOptions.newBuilder().build();
      List<Mutation> mutations = new ArrayList<>();
      client.commit(session, singleUseTransaction, mutations);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void rollbackTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSpanner.addResponse(expectedResponse);

    SessionName session = SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]");
    ByteString transactionId = ByteString.EMPTY;

    client.rollback(session, transactionId);

    List<AbstractMessage> actualRequests = mockSpanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RollbackRequest actualRequest = ((RollbackRequest) actualRequests.get(0));

    Assert.assertEquals(session.toString(), actualRequest.getSession());
    Assert.assertEquals(transactionId, actualRequest.getTransactionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void rollbackExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpanner.addException(exception);

    try {
      SessionName session = SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]");
      ByteString transactionId = ByteString.EMPTY;
      client.rollback(session, transactionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void rollbackTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSpanner.addResponse(expectedResponse);

    String session = "session1984987798";
    ByteString transactionId = ByteString.EMPTY;

    client.rollback(session, transactionId);

    List<AbstractMessage> actualRequests = mockSpanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RollbackRequest actualRequest = ((RollbackRequest) actualRequests.get(0));

    Assert.assertEquals(session, actualRequest.getSession());
    Assert.assertEquals(transactionId, actualRequest.getTransactionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void rollbackExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpanner.addException(exception);

    try {
      String session = "session1984987798";
      ByteString transactionId = ByteString.EMPTY;
      client.rollback(session, transactionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void partitionQueryTest() throws Exception {
    PartitionResponse expectedResponse =
        PartitionResponse.newBuilder()
            .addAllPartitions(new ArrayList<Partition>())
            .setTransaction(Transaction.newBuilder().build())
            .build();
    mockSpanner.addResponse(expectedResponse);

    PartitionQueryRequest request =
        PartitionQueryRequest.newBuilder()
            .setSession(
                SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]").toString())
            .setTransaction(TransactionSelector.newBuilder().build())
            .setSql("sql114126")
            .setParams(Struct.newBuilder().build())
            .putAllParamTypes(new HashMap<String, Type>())
            .setPartitionOptions(PartitionOptions.newBuilder().build())
            .build();

    PartitionResponse actualResponse = client.partitionQuery(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PartitionQueryRequest actualRequest = ((PartitionQueryRequest) actualRequests.get(0));

    Assert.assertEquals(request.getSession(), actualRequest.getSession());
    Assert.assertEquals(request.getTransaction(), actualRequest.getTransaction());
    Assert.assertEquals(request.getSql(), actualRequest.getSql());
    Assert.assertEquals(request.getParams(), actualRequest.getParams());
    Assert.assertEquals(request.getParamTypesMap(), actualRequest.getParamTypesMap());
    Assert.assertEquals(request.getPartitionOptions(), actualRequest.getPartitionOptions());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void partitionQueryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpanner.addException(exception);

    try {
      PartitionQueryRequest request =
          PartitionQueryRequest.newBuilder()
              .setSession(
                  SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]").toString())
              .setTransaction(TransactionSelector.newBuilder().build())
              .setSql("sql114126")
              .setParams(Struct.newBuilder().build())
              .putAllParamTypes(new HashMap<String, Type>())
              .setPartitionOptions(PartitionOptions.newBuilder().build())
              .build();
      client.partitionQuery(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void partitionReadTest() throws Exception {
    PartitionResponse expectedResponse =
        PartitionResponse.newBuilder()
            .addAllPartitions(new ArrayList<Partition>())
            .setTransaction(Transaction.newBuilder().build())
            .build();
    mockSpanner.addResponse(expectedResponse);

    PartitionReadRequest request =
        PartitionReadRequest.newBuilder()
            .setSession(
                SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]").toString())
            .setTransaction(TransactionSelector.newBuilder().build())
            .setTable("table110115790")
            .setIndex("index100346066")
            .addAllColumns(new ArrayList<String>())
            .setKeySet(KeySet.newBuilder().build())
            .setPartitionOptions(PartitionOptions.newBuilder().build())
            .build();

    PartitionResponse actualResponse = client.partitionRead(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PartitionReadRequest actualRequest = ((PartitionReadRequest) actualRequests.get(0));

    Assert.assertEquals(request.getSession(), actualRequest.getSession());
    Assert.assertEquals(request.getTransaction(), actualRequest.getTransaction());
    Assert.assertEquals(request.getTable(), actualRequest.getTable());
    Assert.assertEquals(request.getIndex(), actualRequest.getIndex());
    Assert.assertEquals(request.getColumnsList(), actualRequest.getColumnsList());
    Assert.assertEquals(request.getKeySet(), actualRequest.getKeySet());
    Assert.assertEquals(request.getPartitionOptions(), actualRequest.getPartitionOptions());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void partitionReadExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpanner.addException(exception);

    try {
      PartitionReadRequest request =
          PartitionReadRequest.newBuilder()
              .setSession(
                  SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]").toString())
              .setTransaction(TransactionSelector.newBuilder().build())
              .setTable("table110115790")
              .setIndex("index100346066")
              .addAllColumns(new ArrayList<String>())
              .setKeySet(KeySet.newBuilder().build())
              .setPartitionOptions(PartitionOptions.newBuilder().build())
              .build();
      client.partitionRead(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchWriteTest() throws Exception {
    BatchWriteResponse expectedResponse =
        BatchWriteResponse.newBuilder()
            .addAllIndexes(new ArrayList<Integer>())
            .setStatus(Status.newBuilder().build())
            .setCommitTimestamp(Timestamp.newBuilder().build())
            .build();
    mockSpanner.addResponse(expectedResponse);
    BatchWriteRequest request =
        BatchWriteRequest.newBuilder()
            .setSession(
                SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]").toString())
            .setRequestOptions(RequestOptions.newBuilder().build())
            .addAllMutationGroups(new ArrayList<BatchWriteRequest.MutationGroup>())
            .setExcludeTxnFromChangeStreams(true)
            .build();

    MockStreamObserver<BatchWriteResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        client.batchWriteCallable();
    callable.serverStreamingCall(request, responseObserver);

    List<BatchWriteResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void batchWriteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpanner.addException(exception);
    BatchWriteRequest request =
        BatchWriteRequest.newBuilder()
            .setSession(
                SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]").toString())
            .setRequestOptions(RequestOptions.newBuilder().build())
            .addAllMutationGroups(new ArrayList<BatchWriteRequest.MutationGroup>())
            .setExcludeTxnFromChangeStreams(true)
            .build();

    MockStreamObserver<BatchWriteResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        client.batchWriteCallable();
    callable.serverStreamingCall(request, responseObserver);

    try {
      List<BatchWriteResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
