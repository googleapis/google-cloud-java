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

package com.google.cloud.firestore.v1;

import static com.google.cloud.firestore.v1.FirestoreClient.ListCollectionIdsPagedResponse;
import static com.google.cloud.firestore.v1.FirestoreClient.ListDocumentsPagedResponse;
import static com.google.cloud.firestore.v1.FirestoreClient.PartitionQueryPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.grpc.testing.MockStreamObserver;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.firestore.v1.AggregationResult;
import com.google.firestore.v1.BatchGetDocumentsRequest;
import com.google.firestore.v1.BatchGetDocumentsResponse;
import com.google.firestore.v1.BatchWriteRequest;
import com.google.firestore.v1.BatchWriteResponse;
import com.google.firestore.v1.BeginTransactionRequest;
import com.google.firestore.v1.BeginTransactionResponse;
import com.google.firestore.v1.CommitRequest;
import com.google.firestore.v1.CommitResponse;
import com.google.firestore.v1.CreateDocumentRequest;
import com.google.firestore.v1.Cursor;
import com.google.firestore.v1.DeleteDocumentRequest;
import com.google.firestore.v1.Document;
import com.google.firestore.v1.DocumentMask;
import com.google.firestore.v1.ExecutePipelineRequest;
import com.google.firestore.v1.ExecutePipelineResponse;
import com.google.firestore.v1.ExplainMetrics;
import com.google.firestore.v1.ExplainOptions;
import com.google.firestore.v1.ExplainStats;
import com.google.firestore.v1.GetDocumentRequest;
import com.google.firestore.v1.ListCollectionIdsRequest;
import com.google.firestore.v1.ListCollectionIdsResponse;
import com.google.firestore.v1.ListDocumentsRequest;
import com.google.firestore.v1.ListDocumentsResponse;
import com.google.firestore.v1.ListenRequest;
import com.google.firestore.v1.ListenResponse;
import com.google.firestore.v1.PartitionQueryRequest;
import com.google.firestore.v1.PartitionQueryResponse;
import com.google.firestore.v1.RollbackRequest;
import com.google.firestore.v1.RunAggregationQueryRequest;
import com.google.firestore.v1.RunAggregationQueryResponse;
import com.google.firestore.v1.RunQueryRequest;
import com.google.firestore.v1.RunQueryResponse;
import com.google.firestore.v1.UpdateDocumentRequest;
import com.google.firestore.v1.Value;
import com.google.firestore.v1.Write;
import com.google.firestore.v1.WriteRequest;
import com.google.firestore.v1.WriteResponse;
import com.google.firestore.v1.WriteResult;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
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
public class FirestoreClientTest {
  private static MockFirestore mockFirestore;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private FirestoreClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockFirestore = new MockFirestore();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockFirestore, mockLocations));
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
    FirestoreSettings settings =
        FirestoreSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = FirestoreClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getDocumentTest() throws Exception {
    Document expectedResponse =
        Document.newBuilder()
            .setName("name3373707")
            .putAllFields(new HashMap<String, Value>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockFirestore.addResponse(expectedResponse);

    GetDocumentRequest request =
        GetDocumentRequest.newBuilder()
            .setName("name3373707")
            .setMask(DocumentMask.newBuilder().build())
            .build();

    Document actualResponse = client.getDocument(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDocumentRequest actualRequest = ((GetDocumentRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getMask(), actualRequest.getMask());
    Assert.assertEquals(request.getTransaction(), actualRequest.getTransaction());
    Assert.assertEquals(request.getReadTime(), actualRequest.getReadTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDocumentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestore.addException(exception);

    try {
      GetDocumentRequest request =
          GetDocumentRequest.newBuilder()
              .setName("name3373707")
              .setMask(DocumentMask.newBuilder().build())
              .build();
      client.getDocument(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDocumentsTest() throws Exception {
    Document responsesElement = Document.newBuilder().build();
    ListDocumentsResponse expectedResponse =
        ListDocumentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDocuments(Arrays.asList(responsesElement))
            .build();
    mockFirestore.addResponse(expectedResponse);

    ListDocumentsRequest request =
        ListDocumentsRequest.newBuilder()
            .setParent("parent-995424086")
            .setCollectionId("collectionId1636075609")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setOrderBy("orderBy-1207110587")
            .setMask(DocumentMask.newBuilder().build())
            .setShowMissing(true)
            .build();

    ListDocumentsPagedResponse pagedListResponse = client.listDocuments(request);

    List<Document> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDocumentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFirestore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDocumentsRequest actualRequest = ((ListDocumentsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getCollectionId(), actualRequest.getCollectionId());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getOrderBy(), actualRequest.getOrderBy());
    Assert.assertEquals(request.getMask(), actualRequest.getMask());
    Assert.assertEquals(request.getTransaction(), actualRequest.getTransaction());
    Assert.assertEquals(request.getReadTime(), actualRequest.getReadTime());
    Assert.assertEquals(request.getShowMissing(), actualRequest.getShowMissing());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDocumentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestore.addException(exception);

    try {
      ListDocumentsRequest request =
          ListDocumentsRequest.newBuilder()
              .setParent("parent-995424086")
              .setCollectionId("collectionId1636075609")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setOrderBy("orderBy-1207110587")
              .setMask(DocumentMask.newBuilder().build())
              .setShowMissing(true)
              .build();
      client.listDocuments(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDocumentTest() throws Exception {
    Document expectedResponse =
        Document.newBuilder()
            .setName("name3373707")
            .putAllFields(new HashMap<String, Value>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockFirestore.addResponse(expectedResponse);

    Document document = Document.newBuilder().build();
    DocumentMask updateMask = DocumentMask.newBuilder().build();

    Document actualResponse = client.updateDocument(document, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDocumentRequest actualRequest = ((UpdateDocumentRequest) actualRequests.get(0));

    Assert.assertEquals(document, actualRequest.getDocument());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDocumentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestore.addException(exception);

    try {
      Document document = Document.newBuilder().build();
      DocumentMask updateMask = DocumentMask.newBuilder().build();
      client.updateDocument(document, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDocumentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockFirestore.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteDocument(name);

    List<AbstractMessage> actualRequests = mockFirestore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDocumentRequest actualRequest = ((DeleteDocumentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDocumentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestore.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDocument(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchGetDocumentsTest() throws Exception {
    BatchGetDocumentsResponse expectedResponse =
        BatchGetDocumentsResponse.newBuilder()
            .setTransaction(ByteString.EMPTY)
            .setReadTime(Timestamp.newBuilder().build())
            .build();
    mockFirestore.addResponse(expectedResponse);
    BatchGetDocumentsRequest request =
        BatchGetDocumentsRequest.newBuilder()
            .setDatabase("database1789464955")
            .addAllDocuments(new ArrayList<String>())
            .setMask(DocumentMask.newBuilder().build())
            .build();

    MockStreamObserver<BatchGetDocumentsResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<BatchGetDocumentsRequest, BatchGetDocumentsResponse> callable =
        client.batchGetDocumentsCallable();
    callable.serverStreamingCall(request, responseObserver);

    List<BatchGetDocumentsResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void batchGetDocumentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestore.addException(exception);
    BatchGetDocumentsRequest request =
        BatchGetDocumentsRequest.newBuilder()
            .setDatabase("database1789464955")
            .addAllDocuments(new ArrayList<String>())
            .setMask(DocumentMask.newBuilder().build())
            .build();

    MockStreamObserver<BatchGetDocumentsResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<BatchGetDocumentsRequest, BatchGetDocumentsResponse> callable =
        client.batchGetDocumentsCallable();
    callable.serverStreamingCall(request, responseObserver);

    try {
      List<BatchGetDocumentsResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void beginTransactionTest() throws Exception {
    BeginTransactionResponse expectedResponse =
        BeginTransactionResponse.newBuilder().setTransaction(ByteString.EMPTY).build();
    mockFirestore.addResponse(expectedResponse);

    String database = "database1789464955";

    BeginTransactionResponse actualResponse = client.beginTransaction(database);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BeginTransactionRequest actualRequest = ((BeginTransactionRequest) actualRequests.get(0));

    Assert.assertEquals(database, actualRequest.getDatabase());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void beginTransactionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestore.addException(exception);

    try {
      String database = "database1789464955";
      client.beginTransaction(database);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void commitTest() throws Exception {
    CommitResponse expectedResponse =
        CommitResponse.newBuilder()
            .addAllWriteResults(new ArrayList<WriteResult>())
            .setCommitTime(Timestamp.newBuilder().build())
            .build();
    mockFirestore.addResponse(expectedResponse);

    String database = "database1789464955";
    List<Write> writes = new ArrayList<>();

    CommitResponse actualResponse = client.commit(database, writes);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CommitRequest actualRequest = ((CommitRequest) actualRequests.get(0));

    Assert.assertEquals(database, actualRequest.getDatabase());
    Assert.assertEquals(writes, actualRequest.getWritesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void commitExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestore.addException(exception);

    try {
      String database = "database1789464955";
      List<Write> writes = new ArrayList<>();
      client.commit(database, writes);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void rollbackTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockFirestore.addResponse(expectedResponse);

    String database = "database1789464955";
    ByteString transaction = ByteString.EMPTY;

    client.rollback(database, transaction);

    List<AbstractMessage> actualRequests = mockFirestore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RollbackRequest actualRequest = ((RollbackRequest) actualRequests.get(0));

    Assert.assertEquals(database, actualRequest.getDatabase());
    Assert.assertEquals(transaction, actualRequest.getTransaction());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void rollbackExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestore.addException(exception);

    try {
      String database = "database1789464955";
      ByteString transaction = ByteString.EMPTY;
      client.rollback(database, transaction);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void runQueryTest() throws Exception {
    RunQueryResponse expectedResponse =
        RunQueryResponse.newBuilder()
            .setTransaction(ByteString.EMPTY)
            .setDocument(Document.newBuilder().build())
            .setReadTime(Timestamp.newBuilder().build())
            .setSkippedResults(880286183)
            .setExplainMetrics(ExplainMetrics.newBuilder().build())
            .build();
    mockFirestore.addResponse(expectedResponse);
    RunQueryRequest request =
        RunQueryRequest.newBuilder()
            .setParent("parent-995424086")
            .setExplainOptions(ExplainOptions.newBuilder().build())
            .build();

    MockStreamObserver<RunQueryResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<RunQueryRequest, RunQueryResponse> callable = client.runQueryCallable();
    callable.serverStreamingCall(request, responseObserver);

    List<RunQueryResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void runQueryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestore.addException(exception);
    RunQueryRequest request =
        RunQueryRequest.newBuilder()
            .setParent("parent-995424086")
            .setExplainOptions(ExplainOptions.newBuilder().build())
            .build();

    MockStreamObserver<RunQueryResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<RunQueryRequest, RunQueryResponse> callable = client.runQueryCallable();
    callable.serverStreamingCall(request, responseObserver);

    try {
      List<RunQueryResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void executePipelineTest() throws Exception {
    ExecutePipelineResponse expectedResponse =
        ExecutePipelineResponse.newBuilder()
            .setTransaction(ByteString.EMPTY)
            .addAllResults(new ArrayList<Document>())
            .setExecutionTime(Timestamp.newBuilder().build())
            .setExplainStats(ExplainStats.newBuilder().build())
            .build();
    mockFirestore.addResponse(expectedResponse);
    ExecutePipelineRequest request =
        ExecutePipelineRequest.newBuilder().setDatabase("database1789464955").build();

    MockStreamObserver<ExecutePipelineResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ExecutePipelineRequest, ExecutePipelineResponse> callable =
        client.executePipelineCallable();
    callable.serverStreamingCall(request, responseObserver);

    List<ExecutePipelineResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void executePipelineExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestore.addException(exception);
    ExecutePipelineRequest request =
        ExecutePipelineRequest.newBuilder().setDatabase("database1789464955").build();

    MockStreamObserver<ExecutePipelineResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ExecutePipelineRequest, ExecutePipelineResponse> callable =
        client.executePipelineCallable();
    callable.serverStreamingCall(request, responseObserver);

    try {
      List<ExecutePipelineResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void runAggregationQueryTest() throws Exception {
    RunAggregationQueryResponse expectedResponse =
        RunAggregationQueryResponse.newBuilder()
            .setResult(AggregationResult.newBuilder().build())
            .setTransaction(ByteString.EMPTY)
            .setReadTime(Timestamp.newBuilder().build())
            .setExplainMetrics(ExplainMetrics.newBuilder().build())
            .build();
    mockFirestore.addResponse(expectedResponse);
    RunAggregationQueryRequest request =
        RunAggregationQueryRequest.newBuilder()
            .setParent("parent-995424086")
            .setExplainOptions(ExplainOptions.newBuilder().build())
            .build();

    MockStreamObserver<RunAggregationQueryResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<RunAggregationQueryRequest, RunAggregationQueryResponse> callable =
        client.runAggregationQueryCallable();
    callable.serverStreamingCall(request, responseObserver);

    List<RunAggregationQueryResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void runAggregationQueryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestore.addException(exception);
    RunAggregationQueryRequest request =
        RunAggregationQueryRequest.newBuilder()
            .setParent("parent-995424086")
            .setExplainOptions(ExplainOptions.newBuilder().build())
            .build();

    MockStreamObserver<RunAggregationQueryResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<RunAggregationQueryRequest, RunAggregationQueryResponse> callable =
        client.runAggregationQueryCallable();
    callable.serverStreamingCall(request, responseObserver);

    try {
      List<RunAggregationQueryResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void partitionQueryTest() throws Exception {
    Cursor responsesElement = Cursor.newBuilder().build();
    PartitionQueryResponse expectedResponse =
        PartitionQueryResponse.newBuilder()
            .setNextPageToken("")
            .addAllPartitions(Arrays.asList(responsesElement))
            .build();
    mockFirestore.addResponse(expectedResponse);

    PartitionQueryRequest request =
        PartitionQueryRequest.newBuilder()
            .setParent("parent-995424086")
            .setPartitionCount(-1738969222)
            .setPageToken("pageToken873572522")
            .setPageSize(883849137)
            .build();

    PartitionQueryPagedResponse pagedListResponse = client.partitionQuery(request);

    List<Cursor> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPartitionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFirestore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PartitionQueryRequest actualRequest = ((PartitionQueryRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getStructuredQuery(), actualRequest.getStructuredQuery());
    Assert.assertEquals(request.getPartitionCount(), actualRequest.getPartitionCount());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getReadTime(), actualRequest.getReadTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void partitionQueryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestore.addException(exception);

    try {
      PartitionQueryRequest request =
          PartitionQueryRequest.newBuilder()
              .setParent("parent-995424086")
              .setPartitionCount(-1738969222)
              .setPageToken("pageToken873572522")
              .setPageSize(883849137)
              .build();
      client.partitionQuery(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void writeTest() throws Exception {
    WriteResponse expectedResponse =
        WriteResponse.newBuilder()
            .setStreamId("streamId1790933179")
            .setStreamToken(ByteString.EMPTY)
            .addAllWriteResults(new ArrayList<WriteResult>())
            .setCommitTime(Timestamp.newBuilder().build())
            .build();
    mockFirestore.addResponse(expectedResponse);
    WriteRequest request =
        WriteRequest.newBuilder()
            .setDatabase("database1789464955")
            .setStreamId("streamId1790933179")
            .addAllWrites(new ArrayList<Write>())
            .setStreamToken(ByteString.EMPTY)
            .putAllLabels(new HashMap<String, String>())
            .build();

    MockStreamObserver<WriteResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<WriteRequest, WriteResponse> callable = client.writeCallable();
    ApiStreamObserver<WriteRequest> requestObserver = callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);
    requestObserver.onCompleted();

    List<WriteResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void writeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestore.addException(exception);
    WriteRequest request =
        WriteRequest.newBuilder()
            .setDatabase("database1789464955")
            .setStreamId("streamId1790933179")
            .addAllWrites(new ArrayList<Write>())
            .setStreamToken(ByteString.EMPTY)
            .putAllLabels(new HashMap<String, String>())
            .build();

    MockStreamObserver<WriteResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<WriteRequest, WriteResponse> callable = client.writeCallable();
    ApiStreamObserver<WriteRequest> requestObserver = callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);

    try {
      List<WriteResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listenTest() throws Exception {
    ListenResponse expectedResponse = ListenResponse.newBuilder().build();
    mockFirestore.addResponse(expectedResponse);
    ListenRequest request =
        ListenRequest.newBuilder()
            .setDatabase("database1789464955")
            .putAllLabels(new HashMap<String, String>())
            .build();

    MockStreamObserver<ListenResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<ListenRequest, ListenResponse> callable = client.listenCallable();
    ApiStreamObserver<ListenRequest> requestObserver = callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);
    requestObserver.onCompleted();

    List<ListenResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void listenExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestore.addException(exception);
    ListenRequest request =
        ListenRequest.newBuilder()
            .setDatabase("database1789464955")
            .putAllLabels(new HashMap<String, String>())
            .build();

    MockStreamObserver<ListenResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<ListenRequest, ListenResponse> callable = client.listenCallable();
    ApiStreamObserver<ListenRequest> requestObserver = callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);

    try {
      List<ListenResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listCollectionIdsTest() throws Exception {
    String responsesElement = "responsesElement-318365110";
    ListCollectionIdsResponse expectedResponse =
        ListCollectionIdsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCollectionIds(Arrays.asList(responsesElement))
            .build();
    mockFirestore.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCollectionIdsPagedResponse pagedListResponse = client.listCollectionIds(parent);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCollectionIdsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFirestore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCollectionIdsRequest actualRequest = ((ListCollectionIdsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCollectionIdsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestore.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listCollectionIds(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchWriteTest() throws Exception {
    BatchWriteResponse expectedResponse =
        BatchWriteResponse.newBuilder()
            .addAllWriteResults(new ArrayList<WriteResult>())
            .addAllStatus(new ArrayList<Status>())
            .build();
    mockFirestore.addResponse(expectedResponse);

    BatchWriteRequest request =
        BatchWriteRequest.newBuilder()
            .setDatabase("database1789464955")
            .addAllWrites(new ArrayList<Write>())
            .putAllLabels(new HashMap<String, String>())
            .build();

    BatchWriteResponse actualResponse = client.batchWrite(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchWriteRequest actualRequest = ((BatchWriteRequest) actualRequests.get(0));

    Assert.assertEquals(request.getDatabase(), actualRequest.getDatabase());
    Assert.assertEquals(request.getWritesList(), actualRequest.getWritesList());
    Assert.assertEquals(request.getLabelsMap(), actualRequest.getLabelsMap());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchWriteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestore.addException(exception);

    try {
      BatchWriteRequest request =
          BatchWriteRequest.newBuilder()
              .setDatabase("database1789464955")
              .addAllWrites(new ArrayList<Write>())
              .putAllLabels(new HashMap<String, String>())
              .build();
      client.batchWrite(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDocumentTest() throws Exception {
    Document expectedResponse =
        Document.newBuilder()
            .setName("name3373707")
            .putAllFields(new HashMap<String, Value>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockFirestore.addResponse(expectedResponse);

    CreateDocumentRequest request =
        CreateDocumentRequest.newBuilder()
            .setParent("parent-995424086")
            .setCollectionId("collectionId1636075609")
            .setDocumentId("documentId-814940266")
            .setDocument(Document.newBuilder().build())
            .setMask(DocumentMask.newBuilder().build())
            .build();

    Document actualResponse = client.createDocument(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDocumentRequest actualRequest = ((CreateDocumentRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getCollectionId(), actualRequest.getCollectionId());
    Assert.assertEquals(request.getDocumentId(), actualRequest.getDocumentId());
    Assert.assertEquals(request.getDocument(), actualRequest.getDocument());
    Assert.assertEquals(request.getMask(), actualRequest.getMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDocumentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestore.addException(exception);

    try {
      CreateDocumentRequest request =
          CreateDocumentRequest.newBuilder()
              .setParent("parent-995424086")
              .setCollectionId("collectionId1636075609")
              .setDocumentId("documentId-814940266")
              .setDocument(Document.newBuilder().build())
              .setMask(DocumentMask.newBuilder().build())
              .build();
      client.createDocument(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
