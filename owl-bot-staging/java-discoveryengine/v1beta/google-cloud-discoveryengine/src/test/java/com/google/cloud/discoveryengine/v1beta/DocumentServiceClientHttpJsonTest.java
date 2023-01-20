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

package com.google.cloud.discoveryengine.v1beta;

import static com.google.cloud.discoveryengine.v1beta.DocumentServiceClient.ListDocumentsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.discoveryengine.v1beta.stub.HttpJsonDocumentServiceStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.rpc.Status;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
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
  public void getDocumentTest() throws Exception {
    Document expectedResponse =
        Document.newBuilder()
            .setName(
                DocumentName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]")
                    .toString())
            .setId("id3355")
            .setSchemaId("schemaId-697673060")
            .setParentDocumentId("parentDocumentId1990105056")
            .build();
    mockService.addResponse(expectedResponse);

    DocumentName name =
        DocumentName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]");

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
          DocumentName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]");
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
                DocumentName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]")
                    .toString())
            .setId("id3355")
            .setSchemaId("schemaId-697673060")
            .setParentDocumentId("parentDocumentId1990105056")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2446/locations/location-2446/dataStores/dataStore-2446/branches/branche-2446/documents/document-2446";

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
      String name =
          "projects/project-2446/locations/location-2446/dataStores/dataStore-2446/branches/branche-2446/documents/document-2446";
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
    mockService.addResponse(expectedResponse);

    BranchName parent = BranchName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]");

    ListDocumentsPagedResponse pagedListResponse = client.listDocuments(parent);

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
      BranchName parent = BranchName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]");
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
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-3187/locations/location-3187/dataStores/dataStore-3187/branches/branche-3187";

    ListDocumentsPagedResponse pagedListResponse = client.listDocuments(parent);

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
  public void listDocumentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-3187/locations/location-3187/dataStores/dataStore-3187/branches/branche-3187";
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
                DocumentName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]")
                    .toString())
            .setId("id3355")
            .setSchemaId("schemaId-697673060")
            .setParentDocumentId("parentDocumentId1990105056")
            .build();
    mockService.addResponse(expectedResponse);

    BranchName parent = BranchName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]");
    Document document = Document.newBuilder().build();
    String documentId = "documentId-814940266";

    Document actualResponse = client.createDocument(parent, document, documentId);
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
      BranchName parent = BranchName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]");
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
                DocumentName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]")
                    .toString())
            .setId("id3355")
            .setSchemaId("schemaId-697673060")
            .setParentDocumentId("parentDocumentId1990105056")
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-3187/locations/location-3187/dataStores/dataStore-3187/branches/branche-3187";
    Document document = Document.newBuilder().build();
    String documentId = "documentId-814940266";

    Document actualResponse = client.createDocument(parent, document, documentId);
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
      String parent =
          "projects/project-3187/locations/location-3187/dataStores/dataStore-3187/branches/branche-3187";
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
                DocumentName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]")
                    .toString())
            .setId("id3355")
            .setSchemaId("schemaId-697673060")
            .setParentDocumentId("parentDocumentId1990105056")
            .build();
    mockService.addResponse(expectedResponse);

    UpdateDocumentRequest request =
        UpdateDocumentRequest.newBuilder()
            .setDocument(
                Document.newBuilder()
                    .setName(
                        DocumentName.of(
                                "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]")
                            .toString())
                    .setId("id3355")
                    .setSchemaId("schemaId-697673060")
                    .setParentDocumentId("parentDocumentId1990105056")
                    .build())
            .setAllowMissing(true)
            .build();

    Document actualResponse = client.updateDocument(request);
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
      UpdateDocumentRequest request =
          UpdateDocumentRequest.newBuilder()
              .setDocument(
                  Document.newBuilder()
                      .setName(
                          DocumentName.of(
                                  "[PROJECT]",
                                  "[LOCATION]",
                                  "[DATA_STORE]",
                                  "[BRANCH]",
                                  "[DOCUMENT]")
                              .toString())
                      .setId("id3355")
                      .setSchemaId("schemaId-697673060")
                      .setParentDocumentId("parentDocumentId1990105056")
                      .build())
              .setAllowMissing(true)
              .build();
      client.updateDocument(request);
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
        DocumentName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]");

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
          DocumentName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]");
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

    String name =
        "projects/project-2446/locations/location-2446/dataStores/dataStore-2446/branches/branche-2446/documents/document-2446";

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
      String name =
          "projects/project-2446/locations/location-2446/dataStores/dataStore-2446/branches/branche-2446/documents/document-2446";
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
    mockService.addResponse(resultOperation);

    ImportDocumentsRequest request =
        ImportDocumentsRequest.newBuilder()
            .setParent(
                BranchName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]").toString())
            .setErrorConfig(ImportErrorConfig.newBuilder().build())
            .build();

    ImportDocumentsResponse actualResponse = client.importDocumentsAsync(request).get();
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
  public void importDocumentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ImportDocumentsRequest request =
          ImportDocumentsRequest.newBuilder()
              .setParent(
                  BranchName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]").toString())
              .setErrorConfig(ImportErrorConfig.newBuilder().build())
              .build();
      client.importDocumentsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
