/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.discoveryengine.v1;

import static com.google.cloud.discoveryengine.v1.DocumentServiceClient.ListDocumentsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Struct;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class DocumentServiceClientTest {
  private static MockDocumentService mockDocumentService;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DocumentServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDocumentService = new MockDocumentService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockDocumentService, mockLocations));
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
    DocumentServiceSettings settings =
        DocumentServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DocumentServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getDocumentTest() throws Exception {
    Document expectedResponse =
        Document.newBuilder()
            .setName(
                DocumentName.ofProjectLocationDataStoreBranchDocumentName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]")
                    .toString())
            .setId("id3355")
            .setSchemaId("schemaId-697673060")
            .setContent(Document.Content.newBuilder().build())
            .setParentDocumentId("parentDocumentId1990105056")
            .setDerivedStructData(Struct.newBuilder().build())
            .setIndexTime(Timestamp.newBuilder().build())
            .build();
    mockDocumentService.addResponse(expectedResponse);

    DocumentName name =
        DocumentName.ofProjectLocationDataStoreBranchDocumentName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]");

    Document actualResponse = client.getDocument(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDocumentRequest actualRequest = ((GetDocumentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDocumentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentService.addException(exception);

    try {
      DocumentName name =
          DocumentName.ofProjectLocationDataStoreBranchDocumentName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]");
      client.getDocument(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDocumentTest2() throws Exception {
    Document expectedResponse =
        Document.newBuilder()
            .setName(
                DocumentName.ofProjectLocationDataStoreBranchDocumentName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]")
                    .toString())
            .setId("id3355")
            .setSchemaId("schemaId-697673060")
            .setContent(Document.Content.newBuilder().build())
            .setParentDocumentId("parentDocumentId1990105056")
            .setDerivedStructData(Struct.newBuilder().build())
            .setIndexTime(Timestamp.newBuilder().build())
            .build();
    mockDocumentService.addResponse(expectedResponse);

    String name = "name3373707";

    Document actualResponse = client.getDocument(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDocumentRequest actualRequest = ((GetDocumentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDocumentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentService.addException(exception);

    try {
      String name = "name3373707";
      client.getDocument(name);
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
    mockDocumentService.addResponse(expectedResponse);

    BranchName parent =
        BranchName.ofProjectLocationDataStoreBranchName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]");

    ListDocumentsPagedResponse pagedListResponse = client.listDocuments(parent);

    List<Document> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDocumentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDocumentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDocumentsRequest actualRequest = ((ListDocumentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDocumentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentService.addException(exception);

    try {
      BranchName parent =
          BranchName.ofProjectLocationDataStoreBranchName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]");
      client.listDocuments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDocumentsTest2() throws Exception {
    Document responsesElement = Document.newBuilder().build();
    ListDocumentsResponse expectedResponse =
        ListDocumentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDocuments(Arrays.asList(responsesElement))
            .build();
    mockDocumentService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDocumentsPagedResponse pagedListResponse = client.listDocuments(parent);

    List<Document> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDocumentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDocumentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDocumentsRequest actualRequest = ((ListDocumentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDocumentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDocuments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDocumentTest() throws Exception {
    Document expectedResponse =
        Document.newBuilder()
            .setName(
                DocumentName.ofProjectLocationDataStoreBranchDocumentName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]")
                    .toString())
            .setId("id3355")
            .setSchemaId("schemaId-697673060")
            .setContent(Document.Content.newBuilder().build())
            .setParentDocumentId("parentDocumentId1990105056")
            .setDerivedStructData(Struct.newBuilder().build())
            .setIndexTime(Timestamp.newBuilder().build())
            .build();
    mockDocumentService.addResponse(expectedResponse);

    BranchName parent =
        BranchName.ofProjectLocationDataStoreBranchName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]");
    Document document = Document.newBuilder().build();
    String documentId = "documentId-814940266";

    Document actualResponse = client.createDocument(parent, document, documentId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDocumentRequest actualRequest = ((CreateDocumentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(document, actualRequest.getDocument());
    Assert.assertEquals(documentId, actualRequest.getDocumentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDocumentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentService.addException(exception);

    try {
      BranchName parent =
          BranchName.ofProjectLocationDataStoreBranchName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]");
      Document document = Document.newBuilder().build();
      String documentId = "documentId-814940266";
      client.createDocument(parent, document, documentId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDocumentTest2() throws Exception {
    Document expectedResponse =
        Document.newBuilder()
            .setName(
                DocumentName.ofProjectLocationDataStoreBranchDocumentName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]")
                    .toString())
            .setId("id3355")
            .setSchemaId("schemaId-697673060")
            .setContent(Document.Content.newBuilder().build())
            .setParentDocumentId("parentDocumentId1990105056")
            .setDerivedStructData(Struct.newBuilder().build())
            .setIndexTime(Timestamp.newBuilder().build())
            .build();
    mockDocumentService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Document document = Document.newBuilder().build();
    String documentId = "documentId-814940266";

    Document actualResponse = client.createDocument(parent, document, documentId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDocumentRequest actualRequest = ((CreateDocumentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(document, actualRequest.getDocument());
    Assert.assertEquals(documentId, actualRequest.getDocumentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDocumentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentService.addException(exception);

    try {
      String parent = "parent-995424086";
      Document document = Document.newBuilder().build();
      String documentId = "documentId-814940266";
      client.createDocument(parent, document, documentId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDocumentTest() throws Exception {
    Document expectedResponse =
        Document.newBuilder()
            .setName(
                DocumentName.ofProjectLocationDataStoreBranchDocumentName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]")
                    .toString())
            .setId("id3355")
            .setSchemaId("schemaId-697673060")
            .setContent(Document.Content.newBuilder().build())
            .setParentDocumentId("parentDocumentId1990105056")
            .setDerivedStructData(Struct.newBuilder().build())
            .setIndexTime(Timestamp.newBuilder().build())
            .build();
    mockDocumentService.addResponse(expectedResponse);

    Document document = Document.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Document actualResponse = client.updateDocument(document, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentService.getRequests();
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
    mockDocumentService.addException(exception);

    try {
      Document document = Document.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDocument(document, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDocumentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDocumentService.addResponse(expectedResponse);

    DocumentName name =
        DocumentName.ofProjectLocationDataStoreBranchDocumentName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]");

    client.deleteDocument(name);

    List<AbstractMessage> actualRequests = mockDocumentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDocumentRequest actualRequest = ((DeleteDocumentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDocumentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentService.addException(exception);

    try {
      DocumentName name =
          DocumentName.ofProjectLocationDataStoreBranchDocumentName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]");
      client.deleteDocument(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDocumentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDocumentService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteDocument(name);

    List<AbstractMessage> actualRequests = mockDocumentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDocumentRequest actualRequest = ((DeleteDocumentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDocumentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDocument(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importDocumentsTest() throws Exception {
    ImportDocumentsResponse expectedResponse =
        ImportDocumentsResponse.newBuilder()
            .addAllErrorSamples(new ArrayList<Status>())
            .setErrorConfig(ImportErrorConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importDocumentsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDocumentService.addResponse(resultOperation);

    ImportDocumentsRequest request =
        ImportDocumentsRequest.newBuilder()
            .setParent(
                BranchName.ofProjectLocationDataStoreBranchName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
                    .toString())
            .setErrorConfig(ImportErrorConfig.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .setAutoGenerateIds(true)
            .setIdField("idField1629396127")
            .build();

    ImportDocumentsResponse actualResponse = client.importDocumentsAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportDocumentsRequest actualRequest = ((ImportDocumentsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInlineSource(), actualRequest.getInlineSource());
    Assert.assertEquals(request.getGcsSource(), actualRequest.getGcsSource());
    Assert.assertEquals(request.getBigquerySource(), actualRequest.getBigquerySource());
    Assert.assertEquals(request.getFhirStoreSource(), actualRequest.getFhirStoreSource());
    Assert.assertEquals(request.getSpannerSource(), actualRequest.getSpannerSource());
    Assert.assertEquals(request.getCloudSqlSource(), actualRequest.getCloudSqlSource());
    Assert.assertEquals(request.getFirestoreSource(), actualRequest.getFirestoreSource());
    Assert.assertEquals(request.getBigtableSource(), actualRequest.getBigtableSource());
    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getErrorConfig(), actualRequest.getErrorConfig());
    Assert.assertEquals(request.getReconciliationMode(), actualRequest.getReconciliationMode());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertEquals(request.getAutoGenerateIds(), actualRequest.getAutoGenerateIds());
    Assert.assertEquals(request.getIdField(), actualRequest.getIdField());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importDocumentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentService.addException(exception);

    try {
      ImportDocumentsRequest request =
          ImportDocumentsRequest.newBuilder()
              .setParent(
                  BranchName.ofProjectLocationDataStoreBranchName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
                      .toString())
              .setErrorConfig(ImportErrorConfig.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .setAutoGenerateIds(true)
              .setIdField("idField1629396127")
              .build();
      client.importDocumentsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void purgeDocumentsTest() throws Exception {
    PurgeDocumentsResponse expectedResponse =
        PurgeDocumentsResponse.newBuilder()
            .setPurgeCount(575305851)
            .addAllPurgeSample(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("purgeDocumentsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDocumentService.addResponse(resultOperation);

    PurgeDocumentsRequest request =
        PurgeDocumentsRequest.newBuilder()
            .setParent(
                BranchName.ofProjectLocationDataStoreBranchName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
                    .toString())
            .setFilter("filter-1274492040")
            .setForce(true)
            .build();

    PurgeDocumentsResponse actualResponse = client.purgeDocumentsAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PurgeDocumentsRequest actualRequest = ((PurgeDocumentsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getForce(), actualRequest.getForce());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void purgeDocumentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentService.addException(exception);

    try {
      PurgeDocumentsRequest request =
          PurgeDocumentsRequest.newBuilder()
              .setParent(
                  BranchName.ofProjectLocationDataStoreBranchName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
                      .toString())
              .setFilter("filter-1274492040")
              .setForce(true)
              .build();
      client.purgeDocumentsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
