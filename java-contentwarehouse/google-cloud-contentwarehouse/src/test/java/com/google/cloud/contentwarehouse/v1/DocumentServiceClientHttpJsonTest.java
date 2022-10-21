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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.contentwarehouse.v1.stub.HttpJsonDocumentServiceStub;
import com.google.common.collect.Lists;
import com.google.iam.v1.Policy;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class DocumentServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static DocumentServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonDocumentServiceStub.getMethodDescriptors(),
            DocumentServiceSettings.getDefaultEndpoint());
    DocumentServiceSettings settings =
        DocumentServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                DocumentServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DocumentServiceClient.create(settings);
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
  public void createDocumentTest() throws Exception {
    CreateDocumentResponse expectedResponse =
        CreateDocumentResponse.newBuilder()
            .setDocument(Document.newBuilder().build())
            .setRuleEngineOutput(RuleEngineOutput.newBuilder().build())
            .setMetadata(ResponseMetadata.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Document document = Document.newBuilder().build();

    CreateDocumentResponse actualResponse = client.createDocument(parent, document);
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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    Document document = Document.newBuilder().build();

    CreateDocumentResponse actualResponse = client.createDocument(parent, document);
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
  public void createDocumentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    DocumentName name =
        DocumentName.ofProjectLocationDocumentName("[PROJECT]", "[LOCATION]", "[DOCUMENT]");

    Document actualResponse = client.getDocument(name);
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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-5698/locations/location-5698/documents/document-5698";

    Document actualResponse = client.getDocument(name);
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
  public void getDocumentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-5698/locations/location-5698/documents/document-5698";
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
    mockService.addResponse(expectedResponse);

    DocumentName name =
        DocumentName.ofProjectLocationDocumentName("[PROJECT]", "[LOCATION]", "[DOCUMENT]");
    Document document = Document.newBuilder().build();

    UpdateDocumentResponse actualResponse = client.updateDocument(name, document);
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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-5698/locations/location-5698/documents/document-5698";
    Document document = Document.newBuilder().build();

    UpdateDocumentResponse actualResponse = client.updateDocument(name, document);
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
  public void updateDocumentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-5698/locations/location-5698/documents/document-5698";
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
    mockService.addResponse(expectedResponse);

    DocumentName name =
        DocumentName.ofProjectLocationDocumentName("[PROJECT]", "[LOCATION]", "[DOCUMENT]");

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-5698/locations/location-5698/documents/document-5698";

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
  public void deleteDocumentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-5698/locations/location-5698/documents/document-5698";
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    SearchDocumentsPagedResponse pagedListResponse = client.searchDocuments(parent);

    List<SearchDocumentsResponse.MatchingDocument> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMatchingDocumentsList().get(0), resources.get(0));

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
  public void searchDocumentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    SearchDocumentsPagedResponse pagedListResponse = client.searchDocuments(parent);

    List<SearchDocumentsResponse.MatchingDocument> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMatchingDocumentsList().get(0), resources.get(0));

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
  public void searchDocumentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    String resource = "projects/project-5313/locations/location-5313/documents/document-5313";

    FetchAclResponse actualResponse = client.fetchAcl(resource);
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
  public void fetchAclExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String resource = "projects/project-5313/locations/location-5313/documents/document-5313";
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
    mockService.addResponse(expectedResponse);

    String resource = "projects/project-5313/locations/location-5313/documents/document-5313";
    Policy policy = Policy.newBuilder().build();

    SetAclResponse actualResponse = client.setAcl(resource, policy);
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
  public void setAclExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String resource = "projects/project-5313/locations/location-5313/documents/document-5313";
      Policy policy = Policy.newBuilder().build();
      client.setAcl(resource, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
