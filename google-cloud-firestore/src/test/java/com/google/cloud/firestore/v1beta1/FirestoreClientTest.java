/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.firestore.v1beta1;

import static com.google.cloud.firestore.v1beta1.PagedResponseWrappers.ListCollectionIdsPagedResponse;

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
import com.google.firestore.v1beta1.BatchGetDocumentsRequest;
import com.google.firestore.v1beta1.BatchGetDocumentsResponse;
import com.google.firestore.v1beta1.BeginTransactionRequest;
import com.google.firestore.v1beta1.BeginTransactionResponse;
import com.google.firestore.v1beta1.CommitRequest;
import com.google.firestore.v1beta1.CommitResponse;
import com.google.firestore.v1beta1.DeleteDocumentRequest;
import com.google.firestore.v1beta1.Document;
import com.google.firestore.v1beta1.DocumentMask;
import com.google.firestore.v1beta1.ListCollectionIdsRequest;
import com.google.firestore.v1beta1.ListCollectionIdsResponse;
import com.google.firestore.v1beta1.ListenRequest;
import com.google.firestore.v1beta1.ListenResponse;
import com.google.firestore.v1beta1.RollbackRequest;
import com.google.firestore.v1beta1.RunQueryRequest;
import com.google.firestore.v1beta1.RunQueryResponse;
import com.google.firestore.v1beta1.UpdateDocumentRequest;
import com.google.firestore.v1beta1.Write;
import com.google.firestore.v1beta1.WriteRequest;
import com.google.firestore.v1beta1.WriteResponse;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class FirestoreClientTest {
  private static MockFirestore mockFirestore;
  private static MockServiceHelper serviceHelper;
  private FirestoreClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockFirestore = new MockFirestore();
    serviceHelper =
        new MockServiceHelper("in-process-1", Arrays.<MockGrpcService>asList(mockFirestore));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
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
  @SuppressWarnings("all")
  public void updateDocumentTest() {
    String name = "name3373707";
    Document expectedResponse = Document.newBuilder().setName(name).build();
    mockFirestore.addResponse(expectedResponse);

    Document document = Document.newBuilder().build();
    DocumentMask updateMask = DocumentMask.newBuilder().build();

    Document actualResponse = client.updateDocument(document, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockFirestore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDocumentRequest actualRequest = (UpdateDocumentRequest) actualRequests.get(0);

    Assert.assertEquals(document, actualRequest.getDocument());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateDocumentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockFirestore.addException(exception);

    try {
      Document document = Document.newBuilder().build();
      DocumentMask updateMask = DocumentMask.newBuilder().build();

      client.updateDocument(document, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteDocumentTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockFirestore.addResponse(expectedResponse);

    String formattedName =
        FirestoreClient.formatAnyPathName("[PROJECT]", "[DATABASE]", "[DOCUMENT]", "[ANY_PATH]");

    client.deleteDocument(formattedName);

    List<GeneratedMessageV3> actualRequests = mockFirestore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDocumentRequest actualRequest = (DeleteDocumentRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteDocumentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockFirestore.addException(exception);

    try {
      String formattedName =
          FirestoreClient.formatAnyPathName("[PROJECT]", "[DATABASE]", "[DOCUMENT]", "[ANY_PATH]");

      client.deleteDocument(formattedName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void batchGetDocumentsTest() throws Exception {
    String missing = "missing1069449574";
    ByteString transaction = ByteString.copyFromUtf8("-34");
    BatchGetDocumentsResponse expectedResponse =
        BatchGetDocumentsResponse.newBuilder()
            .setMissing(missing)
            .setTransaction(transaction)
            .build();
    mockFirestore.addResponse(expectedResponse);
    String formattedDatabase = FirestoreClient.formatDatabaseRootName("[PROJECT]", "[DATABASE]");
    List<String> documents = new ArrayList<>();
    BatchGetDocumentsRequest request =
        BatchGetDocumentsRequest.newBuilder()
            .setDatabase(formattedDatabase)
            .addAllDocuments(documents)
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
  @SuppressWarnings("all")
  public void batchGetDocumentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockFirestore.addException(exception);
    String formattedDatabase = FirestoreClient.formatDatabaseRootName("[PROJECT]", "[DATABASE]");
    List<String> documents = new ArrayList<>();
    BatchGetDocumentsRequest request =
        BatchGetDocumentsRequest.newBuilder()
            .setDatabase(formattedDatabase)
            .addAllDocuments(documents)
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
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void beginTransactionTest() {
    ByteString transaction = ByteString.copyFromUtf8("-34");
    BeginTransactionResponse expectedResponse =
        BeginTransactionResponse.newBuilder().setTransaction(transaction).build();
    mockFirestore.addResponse(expectedResponse);

    String formattedDatabase = FirestoreClient.formatDatabaseRootName("[PROJECT]", "[DATABASE]");

    BeginTransactionResponse actualResponse = client.beginTransaction(formattedDatabase);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockFirestore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BeginTransactionRequest actualRequest = (BeginTransactionRequest) actualRequests.get(0);

    Assert.assertEquals(formattedDatabase, actualRequest.getDatabase());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void beginTransactionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockFirestore.addException(exception);

    try {
      String formattedDatabase = FirestoreClient.formatDatabaseRootName("[PROJECT]", "[DATABASE]");

      client.beginTransaction(formattedDatabase);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void commitTest() {
    CommitResponse expectedResponse = CommitResponse.newBuilder().build();
    mockFirestore.addResponse(expectedResponse);

    String formattedDatabase = FirestoreClient.formatDatabaseRootName("[PROJECT]", "[DATABASE]");
    List<Write> writes = new ArrayList<>();

    CommitResponse actualResponse = client.commit(formattedDatabase, writes);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockFirestore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CommitRequest actualRequest = (CommitRequest) actualRequests.get(0);

    Assert.assertEquals(formattedDatabase, actualRequest.getDatabase());
    Assert.assertEquals(writes, actualRequest.getWritesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void commitExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockFirestore.addException(exception);

    try {
      String formattedDatabase = FirestoreClient.formatDatabaseRootName("[PROJECT]", "[DATABASE]");
      List<Write> writes = new ArrayList<>();

      client.commit(formattedDatabase, writes);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void rollbackTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockFirestore.addResponse(expectedResponse);

    String formattedDatabase = FirestoreClient.formatDatabaseRootName("[PROJECT]", "[DATABASE]");
    ByteString transaction = ByteString.copyFromUtf8("-34");

    client.rollback(formattedDatabase, transaction);

    List<GeneratedMessageV3> actualRequests = mockFirestore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RollbackRequest actualRequest = (RollbackRequest) actualRequests.get(0);

    Assert.assertEquals(formattedDatabase, actualRequest.getDatabase());
    Assert.assertEquals(transaction, actualRequest.getTransaction());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void rollbackExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockFirestore.addException(exception);

    try {
      String formattedDatabase = FirestoreClient.formatDatabaseRootName("[PROJECT]", "[DATABASE]");
      ByteString transaction = ByteString.copyFromUtf8("-34");

      client.rollback(formattedDatabase, transaction);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void runQueryTest() throws Exception {
    ByteString transaction = ByteString.copyFromUtf8("-34");
    int skippedResults = 880286183;
    RunQueryResponse expectedResponse =
        RunQueryResponse.newBuilder()
            .setTransaction(transaction)
            .setSkippedResults(skippedResults)
            .build();
    mockFirestore.addResponse(expectedResponse);
    String formattedParent =
        FirestoreClient.formatAnyPathName("[PROJECT]", "[DATABASE]", "[DOCUMENT]", "[ANY_PATH]");
    RunQueryRequest request = RunQueryRequest.newBuilder().setParent(formattedParent).build();

    MockStreamObserver<RunQueryResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<RunQueryRequest, RunQueryResponse> callable = client.runQueryCallable();
    callable.serverStreamingCall(request, responseObserver);

    List<RunQueryResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  @SuppressWarnings("all")
  public void runQueryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockFirestore.addException(exception);
    String formattedParent =
        FirestoreClient.formatAnyPathName("[PROJECT]", "[DATABASE]", "[DOCUMENT]", "[ANY_PATH]");
    RunQueryRequest request = RunQueryRequest.newBuilder().setParent(formattedParent).build();

    MockStreamObserver<RunQueryResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<RunQueryRequest, RunQueryResponse> callable = client.runQueryCallable();
    callable.serverStreamingCall(request, responseObserver);

    try {
      List<RunQueryResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void writeTest() throws Exception {
    String streamId = "streamId-315624902";
    ByteString streamToken = ByteString.copyFromUtf8("122");
    WriteResponse expectedResponse =
        WriteResponse.newBuilder().setStreamId(streamId).setStreamToken(streamToken).build();
    mockFirestore.addResponse(expectedResponse);
    String formattedDatabase = FirestoreClient.formatDatabaseRootName("[PROJECT]", "[DATABASE]");
    WriteRequest request = WriteRequest.newBuilder().setDatabase(formattedDatabase).build();

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
  @SuppressWarnings("all")
  public void writeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockFirestore.addException(exception);
    String formattedDatabase = FirestoreClient.formatDatabaseRootName("[PROJECT]", "[DATABASE]");
    WriteRequest request = WriteRequest.newBuilder().setDatabase(formattedDatabase).build();

    MockStreamObserver<WriteResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<WriteRequest, WriteResponse> callable = client.writeCallable();
    ApiStreamObserver<WriteRequest> requestObserver = callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);

    try {
      List<WriteResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listenTest() throws Exception {
    ListenResponse expectedResponse = ListenResponse.newBuilder().build();
    mockFirestore.addResponse(expectedResponse);
    String formattedDatabase = FirestoreClient.formatDatabaseRootName("[PROJECT]", "[DATABASE]");
    ListenRequest request = ListenRequest.newBuilder().setDatabase(formattedDatabase).build();

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
  @SuppressWarnings("all")
  public void listenExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockFirestore.addException(exception);
    String formattedDatabase = FirestoreClient.formatDatabaseRootName("[PROJECT]", "[DATABASE]");
    ListenRequest request = ListenRequest.newBuilder().setDatabase(formattedDatabase).build();

    MockStreamObserver<ListenResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<ListenRequest, ListenResponse> callable = client.listenCallable();
    ApiStreamObserver<ListenRequest> requestObserver = callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);

    try {
      List<ListenResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listCollectionIdsTest() {
    String nextPageToken = "";
    String collectionIdsElement = "collectionIdsElement1368994900";
    List<String> collectionIds = Arrays.asList(collectionIdsElement);
    ListCollectionIdsResponse expectedResponse =
        ListCollectionIdsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllCollectionIds(collectionIds)
            .build();
    mockFirestore.addResponse(expectedResponse);

    String formattedParent =
        FirestoreClient.formatAnyPathName("[PROJECT]", "[DATABASE]", "[DOCUMENT]", "[ANY_PATH]");

    ListCollectionIdsPagedResponse pagedListResponse = client.listCollectionIds(formattedParent);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCollectionIdsList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockFirestore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCollectionIdsRequest actualRequest = (ListCollectionIdsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listCollectionIdsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockFirestore.addException(exception);

    try {
      String formattedParent =
          FirestoreClient.formatAnyPathName("[PROJECT]", "[DATABASE]", "[DOCUMENT]", "[ANY_PATH]");

      client.listCollectionIds(formattedParent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
