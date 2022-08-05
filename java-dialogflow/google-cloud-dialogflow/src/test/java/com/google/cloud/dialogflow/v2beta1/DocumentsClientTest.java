/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.dialogflow.v2beta1;

import static com.google.cloud.dialogflow.v2beta1.DocumentsClient.ListDocumentsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.DocumentsClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
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
public class DocumentsClientTest {
  private static MockDocuments mockDocuments;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DocumentsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDocuments = new MockDocuments();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockDocuments, mockLocations));
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
    DocumentsSettings settings =
        DocumentsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DocumentsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listDocumentsTest() throws Exception {
    Document responsesElement = Document.newBuilder().build();
    ListDocumentsResponse expectedResponse =
        ListDocumentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDocuments(Arrays.asList(responsesElement))
            .build();
    mockDocuments.addResponse(expectedResponse);

    KnowledgeBaseName parent =
        KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]");

    ListDocumentsPagedResponse pagedListResponse = client.listDocuments(parent);

    List<Document> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDocumentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDocuments.getRequests();
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
    mockDocuments.addException(exception);

    try {
      KnowledgeBaseName parent =
          KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]");
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
    mockDocuments.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDocumentsPagedResponse pagedListResponse = client.listDocuments(parent);

    List<Document> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDocumentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDocuments.getRequests();
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
    mockDocuments.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDocuments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDocumentTest() throws Exception {
    Document expectedResponse =
        Document.newBuilder()
            .setName(
                DocumentName.ofProjectKnowledgeBaseDocumentName(
                        "[PROJECT]", "[KNOWLEDGE_BASE]", "[DOCUMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setMimeType("mimeType-1392120434")
            .addAllKnowledgeTypes(new ArrayList<Document.KnowledgeType>())
            .setEnableAutoReload(true)
            .setLatestReloadStatus(Document.ReloadStatus.newBuilder().build())
            .putAllMetadata(new HashMap<String, String>())
            .build();
    mockDocuments.addResponse(expectedResponse);

    DocumentName name =
        DocumentName.ofProjectKnowledgeBaseDocumentName(
            "[PROJECT]", "[KNOWLEDGE_BASE]", "[DOCUMENT]");

    Document actualResponse = client.getDocument(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocuments.getRequests();
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
    mockDocuments.addException(exception);

    try {
      DocumentName name =
          DocumentName.ofProjectKnowledgeBaseDocumentName(
              "[PROJECT]", "[KNOWLEDGE_BASE]", "[DOCUMENT]");
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
                DocumentName.ofProjectKnowledgeBaseDocumentName(
                        "[PROJECT]", "[KNOWLEDGE_BASE]", "[DOCUMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setMimeType("mimeType-1392120434")
            .addAllKnowledgeTypes(new ArrayList<Document.KnowledgeType>())
            .setEnableAutoReload(true)
            .setLatestReloadStatus(Document.ReloadStatus.newBuilder().build())
            .putAllMetadata(new HashMap<String, String>())
            .build();
    mockDocuments.addResponse(expectedResponse);

    String name = "name3373707";

    Document actualResponse = client.getDocument(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocuments.getRequests();
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
    mockDocuments.addException(exception);

    try {
      String name = "name3373707";
      client.getDocument(name);
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
                DocumentName.ofProjectKnowledgeBaseDocumentName(
                        "[PROJECT]", "[KNOWLEDGE_BASE]", "[DOCUMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setMimeType("mimeType-1392120434")
            .addAllKnowledgeTypes(new ArrayList<Document.KnowledgeType>())
            .setEnableAutoReload(true)
            .setLatestReloadStatus(Document.ReloadStatus.newBuilder().build())
            .putAllMetadata(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDocumentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDocuments.addResponse(resultOperation);

    KnowledgeBaseName parent =
        KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]");
    Document document = Document.newBuilder().build();

    Document actualResponse = client.createDocumentAsync(parent, document).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocuments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDocumentRequest actualRequest = ((CreateDocumentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(document, actualRequest.getDocument());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDocumentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocuments.addException(exception);

    try {
      KnowledgeBaseName parent =
          KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]");
      Document document = Document.newBuilder().build();
      client.createDocumentAsync(parent, document).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createDocumentTest2() throws Exception {
    Document expectedResponse =
        Document.newBuilder()
            .setName(
                DocumentName.ofProjectKnowledgeBaseDocumentName(
                        "[PROJECT]", "[KNOWLEDGE_BASE]", "[DOCUMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setMimeType("mimeType-1392120434")
            .addAllKnowledgeTypes(new ArrayList<Document.KnowledgeType>())
            .setEnableAutoReload(true)
            .setLatestReloadStatus(Document.ReloadStatus.newBuilder().build())
            .putAllMetadata(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDocumentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDocuments.addResponse(resultOperation);

    String parent = "parent-995424086";
    Document document = Document.newBuilder().build();

    Document actualResponse = client.createDocumentAsync(parent, document).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocuments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDocumentRequest actualRequest = ((CreateDocumentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(document, actualRequest.getDocument());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDocumentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocuments.addException(exception);

    try {
      String parent = "parent-995424086";
      Document document = Document.newBuilder().build();
      client.createDocumentAsync(parent, document).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void importDocumentsTest() throws Exception {
    ImportDocumentsResponse expectedResponse =
        ImportDocumentsResponse.newBuilder().addAllWarnings(new ArrayList<Status>()).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importDocumentsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDocuments.addResponse(resultOperation);

    ImportDocumentsRequest request =
        ImportDocumentsRequest.newBuilder()
            .setParent(
                KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]")
                    .toString())
            .setDocumentTemplate(ImportDocumentTemplate.newBuilder().build())
            .setImportGcsCustomMetadata(true)
            .build();

    ImportDocumentsResponse actualResponse = client.importDocumentsAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocuments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportDocumentsRequest actualRequest = ((ImportDocumentsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getGcsSource(), actualRequest.getGcsSource());
    Assert.assertEquals(request.getDocumentTemplate(), actualRequest.getDocumentTemplate());
    Assert.assertEquals(
        request.getImportGcsCustomMetadata(), actualRequest.getImportGcsCustomMetadata());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importDocumentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocuments.addException(exception);

    try {
      ImportDocumentsRequest request =
          ImportDocumentsRequest.newBuilder()
              .setParent(
                  KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]")
                      .toString())
              .setDocumentTemplate(ImportDocumentTemplate.newBuilder().build())
              .setImportGcsCustomMetadata(true)
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
  public void deleteDocumentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDocumentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDocuments.addResponse(resultOperation);

    DocumentName name =
        DocumentName.ofProjectKnowledgeBaseDocumentName(
            "[PROJECT]", "[KNOWLEDGE_BASE]", "[DOCUMENT]");

    client.deleteDocumentAsync(name).get();

    List<AbstractMessage> actualRequests = mockDocuments.getRequests();
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
    mockDocuments.addException(exception);

    try {
      DocumentName name =
          DocumentName.ofProjectKnowledgeBaseDocumentName(
              "[PROJECT]", "[KNOWLEDGE_BASE]", "[DOCUMENT]");
      client.deleteDocumentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDocumentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDocumentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDocuments.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteDocumentAsync(name).get();

    List<AbstractMessage> actualRequests = mockDocuments.getRequests();
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
    mockDocuments.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDocumentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateDocumentTest() throws Exception {
    Document expectedResponse =
        Document.newBuilder()
            .setName(
                DocumentName.ofProjectKnowledgeBaseDocumentName(
                        "[PROJECT]", "[KNOWLEDGE_BASE]", "[DOCUMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setMimeType("mimeType-1392120434")
            .addAllKnowledgeTypes(new ArrayList<Document.KnowledgeType>())
            .setEnableAutoReload(true)
            .setLatestReloadStatus(Document.ReloadStatus.newBuilder().build())
            .putAllMetadata(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDocumentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDocuments.addResponse(resultOperation);

    Document document = Document.newBuilder().build();

    Document actualResponse = client.updateDocumentAsync(document).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocuments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDocumentRequest actualRequest = ((UpdateDocumentRequest) actualRequests.get(0));

    Assert.assertEquals(document, actualRequest.getDocument());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDocumentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocuments.addException(exception);

    try {
      Document document = Document.newBuilder().build();
      client.updateDocumentAsync(document).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateDocumentTest2() throws Exception {
    Document expectedResponse =
        Document.newBuilder()
            .setName(
                DocumentName.ofProjectKnowledgeBaseDocumentName(
                        "[PROJECT]", "[KNOWLEDGE_BASE]", "[DOCUMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setMimeType("mimeType-1392120434")
            .addAllKnowledgeTypes(new ArrayList<Document.KnowledgeType>())
            .setEnableAutoReload(true)
            .setLatestReloadStatus(Document.ReloadStatus.newBuilder().build())
            .putAllMetadata(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDocumentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDocuments.addResponse(resultOperation);

    Document document = Document.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Document actualResponse = client.updateDocumentAsync(document, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocuments.getRequests();
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
  public void updateDocumentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocuments.addException(exception);

    try {
      Document document = Document.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDocumentAsync(document, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void reloadDocumentTest() throws Exception {
    Document expectedResponse =
        Document.newBuilder()
            .setName(
                DocumentName.ofProjectKnowledgeBaseDocumentName(
                        "[PROJECT]", "[KNOWLEDGE_BASE]", "[DOCUMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setMimeType("mimeType-1392120434")
            .addAllKnowledgeTypes(new ArrayList<Document.KnowledgeType>())
            .setEnableAutoReload(true)
            .setLatestReloadStatus(Document.ReloadStatus.newBuilder().build())
            .putAllMetadata(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("reloadDocumentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDocuments.addResponse(resultOperation);

    DocumentName name =
        DocumentName.ofProjectKnowledgeBaseDocumentName(
            "[PROJECT]", "[KNOWLEDGE_BASE]", "[DOCUMENT]");
    GcsSource gcsSource = GcsSource.newBuilder().build();

    Document actualResponse = client.reloadDocumentAsync(name, gcsSource).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocuments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReloadDocumentRequest actualRequest = ((ReloadDocumentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(gcsSource, actualRequest.getGcsSource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void reloadDocumentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocuments.addException(exception);

    try {
      DocumentName name =
          DocumentName.ofProjectKnowledgeBaseDocumentName(
              "[PROJECT]", "[KNOWLEDGE_BASE]", "[DOCUMENT]");
      GcsSource gcsSource = GcsSource.newBuilder().build();
      client.reloadDocumentAsync(name, gcsSource).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void reloadDocumentTest2() throws Exception {
    Document expectedResponse =
        Document.newBuilder()
            .setName(
                DocumentName.ofProjectKnowledgeBaseDocumentName(
                        "[PROJECT]", "[KNOWLEDGE_BASE]", "[DOCUMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setMimeType("mimeType-1392120434")
            .addAllKnowledgeTypes(new ArrayList<Document.KnowledgeType>())
            .setEnableAutoReload(true)
            .setLatestReloadStatus(Document.ReloadStatus.newBuilder().build())
            .putAllMetadata(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("reloadDocumentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDocuments.addResponse(resultOperation);

    String name = "name3373707";
    GcsSource gcsSource = GcsSource.newBuilder().build();

    Document actualResponse = client.reloadDocumentAsync(name, gcsSource).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocuments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReloadDocumentRequest actualRequest = ((ReloadDocumentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(gcsSource, actualRequest.getGcsSource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void reloadDocumentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocuments.addException(exception);

    try {
      String name = "name3373707";
      GcsSource gcsSource = GcsSource.newBuilder().build();
      client.reloadDocumentAsync(name, gcsSource).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listLocationsTest() throws Exception {
    Location responsesElement = Location.newBuilder().build();
    ListLocationsResponse expectedResponse =
        ListLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocations(Arrays.asList(responsesElement))
            .build();
    mockLocations.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("name3373707")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocationsRequest actualRequest = ((ListLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("name3373707")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listLocations(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLocationTest() throws Exception {
    Location expectedResponse =
        Location.newBuilder()
            .setName("name3373707")
            .setLocationId("locationId1541836720")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setMetadata(Any.newBuilder().build())
            .build();
    mockLocations.addResponse(expectedResponse);

    GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLocationRequest actualRequest = ((GetLocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
