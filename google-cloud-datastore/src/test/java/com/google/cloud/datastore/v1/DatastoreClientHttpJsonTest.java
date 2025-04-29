/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.datastore.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.datastore.v1.stub.HttpJsonDatastoreStub;
import com.google.datastore.v1.AggregationQuery;
import com.google.datastore.v1.AggregationResultBatch;
import com.google.datastore.v1.AllocateIdsResponse;
import com.google.datastore.v1.BeginTransactionResponse;
import com.google.datastore.v1.CommitRequest;
import com.google.datastore.v1.CommitResponse;
import com.google.datastore.v1.EntityResult;
import com.google.datastore.v1.ExplainMetrics;
import com.google.datastore.v1.ExplainOptions;
import com.google.datastore.v1.Key;
import com.google.datastore.v1.LookupResponse;
import com.google.datastore.v1.Mutation;
import com.google.datastore.v1.MutationResult;
import com.google.datastore.v1.PartitionId;
import com.google.datastore.v1.PropertyMask;
import com.google.datastore.v1.Query;
import com.google.datastore.v1.QueryResultBatch;
import com.google.datastore.v1.ReadOptions;
import com.google.datastore.v1.ReserveIdsResponse;
import com.google.datastore.v1.RollbackResponse;
import com.google.datastore.v1.RunAggregationQueryRequest;
import com.google.datastore.v1.RunAggregationQueryResponse;
import com.google.datastore.v1.RunQueryRequest;
import com.google.datastore.v1.RunQueryResponse;
import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class DatastoreClientHttpJsonTest {
  private static MockHttpService mockService;
  private static DatastoreClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonDatastoreStub.getMethodDescriptors(), DatastoreSettings.getDefaultEndpoint());
    DatastoreSettings settings =
        DatastoreSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                DatastoreSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DatastoreClient.create(settings);
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
  public void lookupTest() throws Exception {
    LookupResponse expectedResponse =
        LookupResponse.newBuilder()
            .addAllFound(new ArrayList<EntityResult>())
            .addAllMissing(new ArrayList<EntityResult>())
            .addAllDeferred(new ArrayList<Key>())
            .setTransaction(ByteString.EMPTY)
            .setReadTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-1530";
    ReadOptions readOptions = ReadOptions.newBuilder().build();
    List<Key> keys = new ArrayList<>();

    LookupResponse actualResponse = client.lookup(projectId, readOptions, keys);
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
  public void lookupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String projectId = "projectId-1530";
      ReadOptions readOptions = ReadOptions.newBuilder().build();
      List<Key> keys = new ArrayList<>();
      client.lookup(projectId, readOptions, keys);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void runQueryTest() throws Exception {
    RunQueryResponse expectedResponse =
        RunQueryResponse.newBuilder()
            .setBatch(QueryResultBatch.newBuilder().build())
            .setQuery(Query.newBuilder().build())
            .setTransaction(ByteString.EMPTY)
            .setExplainMetrics(ExplainMetrics.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    RunQueryRequest request =
        RunQueryRequest.newBuilder()
            .setProjectId("projectId-1530")
            .setDatabaseId("databaseId1688905718")
            .setPartitionId(PartitionId.newBuilder().build())
            .setReadOptions(ReadOptions.newBuilder().build())
            .setPropertyMask(PropertyMask.newBuilder().build())
            .setExplainOptions(ExplainOptions.newBuilder().build())
            .build();

    RunQueryResponse actualResponse = client.runQuery(request);
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
  public void runQueryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RunQueryRequest request =
          RunQueryRequest.newBuilder()
              .setProjectId("projectId-1530")
              .setDatabaseId("databaseId1688905718")
              .setPartitionId(PartitionId.newBuilder().build())
              .setReadOptions(ReadOptions.newBuilder().build())
              .setPropertyMask(PropertyMask.newBuilder().build())
              .setExplainOptions(ExplainOptions.newBuilder().build())
              .build();
      client.runQuery(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void runAggregationQueryTest() throws Exception {
    RunAggregationQueryResponse expectedResponse =
        RunAggregationQueryResponse.newBuilder()
            .setBatch(AggregationResultBatch.newBuilder().build())
            .setQuery(AggregationQuery.newBuilder().build())
            .setTransaction(ByteString.EMPTY)
            .setExplainMetrics(ExplainMetrics.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    RunAggregationQueryRequest request =
        RunAggregationQueryRequest.newBuilder()
            .setProjectId("projectId-1530")
            .setDatabaseId("databaseId1688905718")
            .setPartitionId(PartitionId.newBuilder().build())
            .setReadOptions(ReadOptions.newBuilder().build())
            .setExplainOptions(ExplainOptions.newBuilder().build())
            .build();

    RunAggregationQueryResponse actualResponse = client.runAggregationQuery(request);
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
  public void runAggregationQueryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RunAggregationQueryRequest request =
          RunAggregationQueryRequest.newBuilder()
              .setProjectId("projectId-1530")
              .setDatabaseId("databaseId1688905718")
              .setPartitionId(PartitionId.newBuilder().build())
              .setReadOptions(ReadOptions.newBuilder().build())
              .setExplainOptions(ExplainOptions.newBuilder().build())
              .build();
      client.runAggregationQuery(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void beginTransactionTest() throws Exception {
    BeginTransactionResponse expectedResponse =
        BeginTransactionResponse.newBuilder().setTransaction(ByteString.EMPTY).build();
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-1530";

    BeginTransactionResponse actualResponse = client.beginTransaction(projectId);
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
      String projectId = "projectId-1530";
      client.beginTransaction(projectId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void commitTest() throws Exception {
    CommitResponse expectedResponse =
        CommitResponse.newBuilder()
            .addAllMutationResults(new ArrayList<MutationResult>())
            .setIndexUpdates(-1425228195)
            .setCommitTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-1530";
    CommitRequest.Mode mode = CommitRequest.Mode.forNumber(0);
    List<Mutation> mutations = new ArrayList<>();

    CommitResponse actualResponse = client.commit(projectId, mode, mutations);
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
      String projectId = "projectId-1530";
      CommitRequest.Mode mode = CommitRequest.Mode.forNumber(0);
      List<Mutation> mutations = new ArrayList<>();
      client.commit(projectId, mode, mutations);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void commitTest2() throws Exception {
    CommitResponse expectedResponse =
        CommitResponse.newBuilder()
            .addAllMutationResults(new ArrayList<MutationResult>())
            .setIndexUpdates(-1425228195)
            .setCommitTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-1530";
    CommitRequest.Mode mode = CommitRequest.Mode.forNumber(0);
    ByteString transaction = ByteString.EMPTY;
    List<Mutation> mutations = new ArrayList<>();

    CommitResponse actualResponse = client.commit(projectId, mode, transaction, mutations);
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
      String projectId = "projectId-1530";
      CommitRequest.Mode mode = CommitRequest.Mode.forNumber(0);
      ByteString transaction = ByteString.EMPTY;
      List<Mutation> mutations = new ArrayList<>();
      client.commit(projectId, mode, transaction, mutations);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void rollbackTest() throws Exception {
    RollbackResponse expectedResponse = RollbackResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-1530";
    ByteString transaction = ByteString.EMPTY;

    RollbackResponse actualResponse = client.rollback(projectId, transaction);
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
  public void rollbackExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String projectId = "projectId-1530";
      ByteString transaction = ByteString.EMPTY;
      client.rollback(projectId, transaction);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void allocateIdsTest() throws Exception {
    AllocateIdsResponse expectedResponse =
        AllocateIdsResponse.newBuilder().addAllKeys(new ArrayList<Key>()).build();
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-1530";
    List<Key> keys = new ArrayList<>();

    AllocateIdsResponse actualResponse = client.allocateIds(projectId, keys);
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
  public void allocateIdsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String projectId = "projectId-1530";
      List<Key> keys = new ArrayList<>();
      client.allocateIds(projectId, keys);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void reserveIdsTest() throws Exception {
    ReserveIdsResponse expectedResponse = ReserveIdsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-1530";
    List<Key> keys = new ArrayList<>();

    ReserveIdsResponse actualResponse = client.reserveIds(projectId, keys);
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
  public void reserveIdsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String projectId = "projectId-1530";
      List<Key> keys = new ArrayList<>();
      client.reserveIds(projectId, keys);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
