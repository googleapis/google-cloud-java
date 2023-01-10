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

package com.google.cloud.contentwarehouse.v1;

import static com.google.cloud.contentwarehouse.v1.DocumentServiceClient.SearchDocumentsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.iam.v1.Policy;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
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
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DocumentServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDocumentService = new MockDocumentService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockDocumentService));
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
  public void createDocumentTest() throws Exception {
    CreateDocumentResponse expectedResponse =
        CreateDocumentResponse.newBuilder()
            .setDocument(Document.newBuilder().build())
            .setRuleEngineOutput(RuleEngineOutput.newBuilder().build())
            .setMetadata(ResponseMetadata.newBuilder().build())
            .build();
    mockDocumentService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Document document = Document.newBuilder().build();

    CreateDocumentResponse actualResponse = client.createDocument(parent, document);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentService.getRequests();
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
    mockDocumentService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Document document = Document.newBuilder().build();
      client.createDocument(parent, document);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDocumentTest2() throws Exception {
    CreateDocumentResponse expectedResponse =
        CreateDocumentResponse.newBuilder()
            .setDocument(Document.newBuilder().build())
            .setRuleEngineOutput(RuleEngineOutput.newBuilder().build())
            .setMetadata(ResponseMetadata.newBuilder().build())
            .build();
    mockDocumentService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Document document = Document.newBuilder().build();

    CreateDocumentResponse actualResponse = client.createDocument(parent, document);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentService.getRequests();
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
    mockDocumentService.addException(exception);

    try {
      String parent = "parent-995424086";
      Document document = Document.newBuilder().build();
      client.createDocument(parent, document);
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
                DocumentName.ofProjectLocationDocumentName("[PROJECT]", "[LOCATION]", "[DOCUMENT]")
                    .toString())
            .setReferenceId("referenceId-16211514")
            .setDisplayName("displayName1714148973")
            .setTitle("title110371416")
            .setDisplayUri("displayUri-914528950")
            .setDocumentSchemaName(
                DocumentSchemaName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT_SCHEMA]").toString())
            .setStructuredContentUri("structuredContentUri-1039251868")
            .addAllProperties(new ArrayList<Property>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setRawDocumentFileType(RawDocumentFileType.forNumber(0))
            .setAsyncEnabled(true)
            .setTextExtractionDisabled(true)
            .setCreator("creator1028554796")
            .setUpdater("updater-234430263")
            .build();
    mockDocumentService.addResponse(expectedResponse);

    DocumentName name =
        DocumentName.ofProjectLocationDocumentName("[PROJECT]", "[LOCATION]", "[DOCUMENT]");

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
          DocumentName.ofProjectLocationDocumentName("[PROJECT]", "[LOCATION]", "[DOCUMENT]");
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
                DocumentName.ofProjectLocationDocumentName("[PROJECT]", "[LOCATION]", "[DOCUMENT]")
                    .toString())
            .setReferenceId("referenceId-16211514")
            .setDisplayName("displayName1714148973")
            .setTitle("title110371416")
            .setDisplayUri("displayUri-914528950")
            .setDocumentSchemaName(
                DocumentSchemaName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT_SCHEMA]").toString())
            .setStructuredContentUri("structuredContentUri-1039251868")
            .addAllProperties(new ArrayList<Property>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setRawDocumentFileType(RawDocumentFileType.forNumber(0))
            .setAsyncEnabled(true)
            .setTextExtractionDisabled(true)
            .setCreator("creator1028554796")
            .setUpdater("updater-234430263")
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
  public void updateDocumentTest() throws Exception {
    UpdateDocumentResponse expectedResponse =
        UpdateDocumentResponse.newBuilder()
            .setDocument(Document.newBuilder().build())
            .setRuleEngineOutput(RuleEngineOutput.newBuilder().build())
            .setMetadata(ResponseMetadata.newBuilder().build())
            .build();
    mockDocumentService.addResponse(expectedResponse);

    DocumentName name =
        DocumentName.ofProjectLocationDocumentName("[PROJECT]", "[LOCATION]", "[DOCUMENT]");
    Document document = Document.newBuilder().build();

    UpdateDocumentResponse actualResponse = client.updateDocument(name, document);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDocumentRequest actualRequest = ((UpdateDocumentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(document, actualRequest.getDocument());
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
      DocumentName name =
          DocumentName.ofProjectLocationDocumentName("[PROJECT]", "[LOCATION]", "[DOCUMENT]");
      Document document = Document.newBuilder().build();
      client.updateDocument(name, document);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDocumentTest2() throws Exception {
    UpdateDocumentResponse expectedResponse =
        UpdateDocumentResponse.newBuilder()
            .setDocument(Document.newBuilder().build())
            .setRuleEngineOutput(RuleEngineOutput.newBuilder().build())
            .setMetadata(ResponseMetadata.newBuilder().build())
            .build();
    mockDocumentService.addResponse(expectedResponse);

    String name = "name3373707";
    Document document = Document.newBuilder().build();

    UpdateDocumentResponse actualResponse = client.updateDocument(name, document);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDocumentRequest actualRequest = ((UpdateDocumentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(document, actualRequest.getDocument());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDocumentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentService.addException(exception);

    try {
      String name = "name3373707";
      Document document = Document.newBuilder().build();
      client.updateDocument(name, document);
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
        DocumentName.ofProjectLocationDocumentName("[PROJECT]", "[LOCATION]", "[DOCUMENT]");

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
          DocumentName.ofProjectLocationDocumentName("[PROJECT]", "[LOCATION]", "[DOCUMENT]");
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
  public void searchDocumentsTest() throws Exception {
    SearchDocumentsResponse.MatchingDocument responsesElement =
        SearchDocumentsResponse.MatchingDocument.newBuilder().build();
    SearchDocumentsResponse expectedResponse =
        SearchDocumentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMatchingDocuments(Arrays.asList(responsesElement))
            .build();
    mockDocumentService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    SearchDocumentsPagedResponse pagedListResponse = client.searchDocuments(parent);

    List<SearchDocumentsResponse.MatchingDocument> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMatchingDocumentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDocumentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchDocumentsRequest actualRequest = ((SearchDocumentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchDocumentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.searchDocuments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchDocumentsTest2() throws Exception {
    SearchDocumentsResponse.MatchingDocument responsesElement =
        SearchDocumentsResponse.MatchingDocument.newBuilder().build();
    SearchDocumentsResponse expectedResponse =
        SearchDocumentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMatchingDocuments(Arrays.asList(responsesElement))
            .build();
    mockDocumentService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    SearchDocumentsPagedResponse pagedListResponse = client.searchDocuments(parent);

    List<SearchDocumentsResponse.MatchingDocument> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMatchingDocumentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDocumentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchDocumentsRequest actualRequest = ((SearchDocumentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchDocumentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.searchDocuments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchAclTest() throws Exception {
    FetchAclResponse expectedResponse =
        FetchAclResponse.newBuilder()
            .setPolicy(Policy.newBuilder().build())
            .setMetadata(ResponseMetadata.newBuilder().build())
            .build();
    mockDocumentService.addResponse(expectedResponse);

    String resource = "resource-341064690";

    FetchAclResponse actualResponse = client.fetchAcl(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchAclRequest actualRequest = ((FetchAclRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchAclExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentService.addException(exception);

    try {
      String resource = "resource-341064690";
      client.fetchAcl(resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setAclTest() throws Exception {
    SetAclResponse expectedResponse =
        SetAclResponse.newBuilder()
            .setPolicy(Policy.newBuilder().build())
            .setMetadata(ResponseMetadata.newBuilder().build())
            .build();
    mockDocumentService.addResponse(expectedResponse);

    String resource = "resource-341064690";
    Policy policy = Policy.newBuilder().build();

    SetAclResponse actualResponse = client.setAcl(resource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetAclRequest actualRequest = ((SetAclRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setAclExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentService.addException(exception);

    try {
      String resource = "resource-341064690";
      Policy policy = Policy.newBuilder().build();
      client.setAcl(resource, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
