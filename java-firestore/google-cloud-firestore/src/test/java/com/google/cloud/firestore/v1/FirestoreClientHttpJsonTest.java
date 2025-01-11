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

package com.google.cloud.firestore.v1;

import static com.google.cloud.firestore.v1.FirestoreClient.ListCollectionIdsPagedResponse;
import static com.google.cloud.firestore.v1.FirestoreClient.ListDocumentsPagedResponse;
import static com.google.cloud.firestore.v1.FirestoreClient.PartitionQueryPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.firestore.v1.stub.HttpJsonFirestoreStub;
import com.google.common.collect.Lists;
import com.google.firestore.v1.BatchWriteRequest;
import com.google.firestore.v1.BatchWriteResponse;
import com.google.firestore.v1.BeginTransactionResponse;
import com.google.firestore.v1.CommitResponse;
import com.google.firestore.v1.CreateDocumentRequest;
import com.google.firestore.v1.Cursor;
import com.google.firestore.v1.Document;
import com.google.firestore.v1.DocumentMask;
import com.google.firestore.v1.GetDocumentRequest;
import com.google.firestore.v1.ListCollectionIdsResponse;
import com.google.firestore.v1.ListDocumentsRequest;
import com.google.firestore.v1.ListDocumentsResponse;
import com.google.firestore.v1.PartitionQueryRequest;
import com.google.firestore.v1.PartitionQueryResponse;
import com.google.firestore.v1.Value;
import com.google.firestore.v1.Write;
import com.google.firestore.v1.WriteResult;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
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
public class FirestoreClientHttpJsonTest {
  private static MockHttpService mockService;
  private static FirestoreClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonFirestoreStub.getMethodDescriptors(), FirestoreSettings.getDefaultEndpoint());
    FirestoreSettings settings =
        FirestoreSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                FirestoreSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = FirestoreClient.create(settings);
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
  public void getDocumentTest() throws Exception {
    Document expectedResponse =
        Document.newBuilder()
            .setName("name3373707")
            .putAllFields(new HashMap<String, Value>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    GetDocumentRequest request =
        GetDocumentRequest.newBuilder()
            .setName(
                "projects/project-615/databases/database-615/documents/document-615/document-615")
            .setMask(DocumentMask.newBuilder().build())
            .build();

    Document actualResponse = client.getDocument(request);
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
  public void getDocumentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetDocumentRequest request =
          GetDocumentRequest.newBuilder()
              .setName(
                  "projects/project-615/databases/database-615/documents/document-615/document-615")
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
    mockService.addResponse(expectedResponse);

    ListDocumentsRequest request =
        ListDocumentsRequest.newBuilder()
            .setParent(
                "projects/project-6440/databases/database-6440/documents/document-6440/document-6440")
            .setCollectionId("collectionId-3631")
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
  public void listDocumentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListDocumentsRequest request =
          ListDocumentsRequest.newBuilder()
              .setParent(
                  "projects/project-6440/databases/database-6440/documents/document-6440/document-6440")
              .setCollectionId("collectionId-3631")
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
    mockService.addResponse(expectedResponse);

    Document document =
        Document.newBuilder()
            .setName(
                "projects/project-615/databases/database-615/documents/document-615/document-615")
            .putAllFields(new HashMap<String, Value>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    DocumentMask updateMask = DocumentMask.newBuilder().build();

    Document actualResponse = client.updateDocument(document, updateMask);
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
  public void updateDocumentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Document document =
          Document.newBuilder()
              .setName(
                  "projects/project-615/databases/database-615/documents/document-615/document-615")
              .putAllFields(new HashMap<String, Value>())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .build();
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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-615/databases/database-615/documents/document-615/document-615";

    client.deleteDocument(name);

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
  public void deleteDocumentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-615/databases/database-615/documents/document-615/document-615";
      client.deleteDocument(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchGetDocumentsTest() throws Exception {}

  @Test
  public void batchGetDocumentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);
  }

  @Test
  public void beginTransactionTest() throws Exception {
    BeginTransactionResponse expectedResponse =
        BeginTransactionResponse.newBuilder().setTransaction(ByteString.EMPTY).build();
    mockService.addResponse(expectedResponse);

    String database = "projects/project-4060/databases/database-4060";

    BeginTransactionResponse actualResponse = client.beginTransaction(database);
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
      String database = "projects/project-4060/databases/database-4060";
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
    mockService.addResponse(expectedResponse);

    String database = "projects/project-4060/databases/database-4060";
    List<Write> writes = new ArrayList<>();

    CommitResponse actualResponse = client.commit(database, writes);
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
      String database = "projects/project-4060/databases/database-4060";
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
    mockService.addResponse(expectedResponse);

    String database = "projects/project-4060/databases/database-4060";
    ByteString transaction = ByteString.EMPTY;

    client.rollback(database, transaction);

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
      String database = "projects/project-4060/databases/database-4060";
      ByteString transaction = ByteString.EMPTY;
      client.rollback(database, transaction);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void runQueryTest() throws Exception {}

  @Test
  public void runQueryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);
  }

  @Test
  public void runAggregationQueryTest() throws Exception {}

  @Test
  public void runAggregationQueryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);
  }

  @Test
  public void partitionQueryTest() throws Exception {
    Cursor responsesElement = Cursor.newBuilder().build();
    PartitionQueryResponse expectedResponse =
        PartitionQueryResponse.newBuilder()
            .setNextPageToken("")
            .addAllPartitions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    PartitionQueryRequest request =
        PartitionQueryRequest.newBuilder()
            .setParent("projects/project-9316/databases/database-9316/documents")
            .setPartitionCount(-1738969222)
            .setPageToken("pageToken873572522")
            .setPageSize(883849137)
            .build();

    PartitionQueryPagedResponse pagedListResponse = client.partitionQuery(request);

    List<Cursor> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPartitionsList().get(0), resources.get(0));

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
              .setParent("projects/project-9316/databases/database-9316/documents")
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
  public void writeUnsupportedMethodTest() throws Exception {
    // The write() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }

  @Test
  public void listenUnsupportedMethodTest() throws Exception {
    // The listen() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }

  @Test
  public void listCollectionIdsTest() throws Exception {
    String responsesElement = "responsesElement-318365110";
    ListCollectionIdsResponse expectedResponse =
        ListCollectionIdsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCollectionIds(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-9316/databases/database-9316/documents";

    ListCollectionIdsPagedResponse pagedListResponse = client.listCollectionIds(parent);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCollectionIdsList().get(0), resources.get(0));

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
  public void listCollectionIdsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-9316/databases/database-9316/documents";
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
    mockService.addResponse(expectedResponse);

    BatchWriteRequest request =
        BatchWriteRequest.newBuilder()
            .setDatabase("projects/project-4060/databases/database-4060")
            .addAllWrites(new ArrayList<Write>())
            .putAllLabels(new HashMap<String, String>())
            .build();

    BatchWriteResponse actualResponse = client.batchWrite(request);
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
  public void batchWriteExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BatchWriteRequest request =
          BatchWriteRequest.newBuilder()
              .setDatabase("projects/project-4060/databases/database-4060")
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
    mockService.addResponse(expectedResponse);

    CreateDocumentRequest request =
        CreateDocumentRequest.newBuilder()
            .setParent("projects/project-2701/databases/database-2701/documents/document-2701")
            .setCollectionId("collectionId-3631")
            .setDocumentId("documentId-814940266")
            .setDocument(Document.newBuilder().build())
            .setMask(DocumentMask.newBuilder().build())
            .build();

    Document actualResponse = client.createDocument(request);
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
  public void createDocumentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CreateDocumentRequest request =
          CreateDocumentRequest.newBuilder()
              .setParent("projects/project-2701/databases/database-2701/documents/document-2701")
              .setCollectionId("collectionId-3631")
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
