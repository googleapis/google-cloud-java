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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.spanner.v1.stub.HttpJsonSpannerStub;
import com.google.common.collect.Lists;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.ListValue;
import com.google.protobuf.Struct;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import com.google.spanner.v1.BatchCreateSessionsResponse;
import com.google.spanner.v1.CacheUpdate;
import com.google.spanner.v1.CommitResponse;
import com.google.spanner.v1.DatabaseName;
import com.google.spanner.v1.DirectedReadOptions;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteBatchDmlResponse;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.KeySet;
import com.google.spanner.v1.ListSessionsResponse;
import com.google.spanner.v1.MultiplexedSessionPrecommitToken;
import com.google.spanner.v1.Mutation;
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
import com.google.spanner.v1.RoutingHint;
import com.google.spanner.v1.Session;
import com.google.spanner.v1.SessionName;
import com.google.spanner.v1.Transaction;
import com.google.spanner.v1.TransactionOptions;
import com.google.spanner.v1.TransactionSelector;
import com.google.spanner.v1.Type;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class SpannerClientHttpJsonTest {
  private static MockHttpService mockService;
  private static SpannerClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonSpannerStub.getMethodDescriptors(), SpannerSettings.getDefaultEndpoint());
    SpannerSettings settings =
        SpannerSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                SpannerSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SpannerClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
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
    mockService.addResponse(expectedResponse);

    DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");

    Session actualResponse = client.createSession(database);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createSessionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String database = "projects/project-3102/instances/instance-3102/databases/database-3102";

    Session actualResponse = client.createSession(database);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createSessionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String database = "projects/project-3102/instances/instance-3102/databases/database-3102";
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
    mockService.addResponse(expectedResponse);

    DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
    int sessionCount = 185691686;

    BatchCreateSessionsResponse actualResponse = client.batchCreateSessions(database, sessionCount);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchCreateSessionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String database = "projects/project-3102/instances/instance-3102/databases/database-3102";
    int sessionCount = 185691686;

    BatchCreateSessionsResponse actualResponse = client.batchCreateSessions(database, sessionCount);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchCreateSessionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String database = "projects/project-3102/instances/instance-3102/databases/database-3102";
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
    mockService.addResponse(expectedResponse);

    SessionName name = SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]");

    Session actualResponse = client.getSession(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getSessionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-199/instances/instance-199/databases/database-199/sessions/session-199";

    Session actualResponse = client.getSession(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getSessionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-199/instances/instance-199/databases/database-199/sessions/session-199";
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
    mockService.addResponse(expectedResponse);

    DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");

    ListSessionsPagedResponse pagedListResponse = client.listSessions(database);

    List<Session> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSessionsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listSessionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String database = "projects/project-3102/instances/instance-3102/databases/database-3102";

    ListSessionsPagedResponse pagedListResponse = client.listSessions(database);

    List<Session> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSessionsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listSessionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String database = "projects/project-3102/instances/instance-3102/databases/database-3102";
      client.listSessions(database);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSessionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    SessionName name = SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]");

    client.deleteSession(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteSessionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-199/instances/instance-199/databases/database-199/sessions/session-199";

    client.deleteSession(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteSessionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-199/instances/instance-199/databases/database-199/sessions/session-199";
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
    mockService.addResponse(expectedResponse);

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

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void executeSqlExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
  public void executeStreamingSqlTest() throws Exception {}

  @Test
  public void executeStreamingSqlExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);
  }

  @Test
  public void executeBatchDmlTest() throws Exception {
    ExecuteBatchDmlResponse expectedResponse =
        ExecuteBatchDmlResponse.newBuilder()
            .addAllResultSets(new ArrayList<ResultSet>())
            .setStatus(Status.newBuilder().build())
            .setPrecommitToken(MultiplexedSessionPrecommitToken.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

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

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void executeBatchDmlExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

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

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void readExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
  public void streamingReadTest() throws Exception {}

  @Test
  public void streamingReadExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);
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
    mockService.addResponse(expectedResponse);

    SessionName session = SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]");
    TransactionOptions options = TransactionOptions.newBuilder().build();

    Transaction actualResponse = client.beginTransaction(session, options);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void beginTransactionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String session =
        "projects/project-2078/instances/instance-2078/databases/database-2078/sessions/session-2078";
    TransactionOptions options = TransactionOptions.newBuilder().build();

    Transaction actualResponse = client.beginTransaction(session, options);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void beginTransactionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String session =
          "projects/project-2078/instances/instance-2078/databases/database-2078/sessions/session-2078";
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
    mockService.addResponse(expectedResponse);

    SessionName session = SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]");
    ByteString transactionId = ByteString.EMPTY;
    List<Mutation> mutations = new ArrayList<>();

    CommitResponse actualResponse = client.commit(session, transactionId, mutations);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void commitExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    SessionName session = SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]");
    TransactionOptions singleUseTransaction = TransactionOptions.newBuilder().build();
    List<Mutation> mutations = new ArrayList<>();

    CommitResponse actualResponse = client.commit(session, singleUseTransaction, mutations);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void commitExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String session =
        "projects/project-2078/instances/instance-2078/databases/database-2078/sessions/session-2078";
    ByteString transactionId = ByteString.EMPTY;
    List<Mutation> mutations = new ArrayList<>();

    CommitResponse actualResponse = client.commit(session, transactionId, mutations);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void commitExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String session =
          "projects/project-2078/instances/instance-2078/databases/database-2078/sessions/session-2078";
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
    mockService.addResponse(expectedResponse);

    String session =
        "projects/project-2078/instances/instance-2078/databases/database-2078/sessions/session-2078";
    TransactionOptions singleUseTransaction = TransactionOptions.newBuilder().build();
    List<Mutation> mutations = new ArrayList<>();

    CommitResponse actualResponse = client.commit(session, singleUseTransaction, mutations);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void commitExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String session =
          "projects/project-2078/instances/instance-2078/databases/database-2078/sessions/session-2078";
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
    mockService.addResponse(expectedResponse);

    SessionName session = SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]");
    ByteString transactionId = ByteString.EMPTY;

    client.rollback(session, transactionId);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void rollbackExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String session =
        "projects/project-2078/instances/instance-2078/databases/database-2078/sessions/session-2078";
    ByteString transactionId = ByteString.EMPTY;

    client.rollback(session, transactionId);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void rollbackExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String session =
          "projects/project-2078/instances/instance-2078/databases/database-2078/sessions/session-2078";
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
    mockService.addResponse(expectedResponse);

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

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void partitionQueryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

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

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void partitionReadExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
  public void batchWriteTest() throws Exception {}

  @Test
  public void batchWriteExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);
  }
}
