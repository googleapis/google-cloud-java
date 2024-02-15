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

package com.google.cloud.datastore.admin.v1;

import static com.google.cloud.datastore.admin.v1.DatastoreAdminClient.ListIndexesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.datastore.admin.v1.stub.HttpJsonDatastoreAdminStub;
import com.google.common.collect.Lists;
import com.google.datastore.admin.v1.CreateIndexRequest;
import com.google.datastore.admin.v1.DeleteIndexRequest;
import com.google.datastore.admin.v1.EntityFilter;
import com.google.datastore.admin.v1.ExportEntitiesResponse;
import com.google.datastore.admin.v1.GetIndexRequest;
import com.google.datastore.admin.v1.Index;
import com.google.datastore.admin.v1.ListIndexesRequest;
import com.google.datastore.admin.v1.ListIndexesResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class DatastoreAdminClientHttpJsonTest {
  private static MockHttpService mockService;
  private static DatastoreAdminClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonDatastoreAdminStub.getMethodDescriptors(),
            DatastoreAdminSettings.getDefaultEndpoint());
    DatastoreAdminSettings settings =
        DatastoreAdminSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                DatastoreAdminSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DatastoreAdminClient.create(settings);
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
  public void exportEntitiesTest() throws Exception {
    ExportEntitiesResponse expectedResponse =
        ExportEntitiesResponse.newBuilder().setOutputUrl("outputUrl-2119300946").build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportEntitiesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String projectId = "projectId-1530";
    Map<String, String> labels = new HashMap<>();
    EntityFilter entityFilter = EntityFilter.newBuilder().build();
    String outputUrlPrefix = "outputUrlPrefix-1132598048";

    ExportEntitiesResponse actualResponse =
        client.exportEntitiesAsync(projectId, labels, entityFilter, outputUrlPrefix).get();
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
  public void exportEntitiesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String projectId = "projectId-1530";
      Map<String, String> labels = new HashMap<>();
      EntityFilter entityFilter = EntityFilter.newBuilder().build();
      String outputUrlPrefix = "outputUrlPrefix-1132598048";
      client.exportEntitiesAsync(projectId, labels, entityFilter, outputUrlPrefix).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void importEntitiesTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importEntitiesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String projectId = "projectId-1530";
    Map<String, String> labels = new HashMap<>();
    String inputUrl = "inputUrl470706501";
    EntityFilter entityFilter = EntityFilter.newBuilder().build();

    client.importEntitiesAsync(projectId, labels, inputUrl, entityFilter).get();

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
  public void importEntitiesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String projectId = "projectId-1530";
      Map<String, String> labels = new HashMap<>();
      String inputUrl = "inputUrl470706501";
      EntityFilter entityFilter = EntityFilter.newBuilder().build();
      client.importEntitiesAsync(projectId, labels, inputUrl, entityFilter).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createIndexTest() throws Exception {
    Index expectedResponse =
        Index.newBuilder()
            .setProjectId("projectId-894832108")
            .setIndexId("indexId1943291277")
            .setKind("kind3292052")
            .addAllProperties(new ArrayList<Index.IndexedProperty>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createIndexTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CreateIndexRequest request =
        CreateIndexRequest.newBuilder()
            .setProjectId("projectId-1530")
            .setIndex(Index.newBuilder().build())
            .build();

    Index actualResponse = client.createIndexAsync(request).get();
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
  public void createIndexExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CreateIndexRequest request =
          CreateIndexRequest.newBuilder()
              .setProjectId("projectId-1530")
              .setIndex(Index.newBuilder().build())
              .build();
      client.createIndexAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteIndexTest() throws Exception {
    Index expectedResponse =
        Index.newBuilder()
            .setProjectId("projectId-894832108")
            .setIndexId("indexId1943291277")
            .setKind("kind3292052")
            .addAllProperties(new ArrayList<Index.IndexedProperty>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteIndexTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DeleteIndexRequest request =
        DeleteIndexRequest.newBuilder()
            .setProjectId("projectId-1530")
            .setIndexId("indexId-7485")
            .build();

    Index actualResponse = client.deleteIndexAsync(request).get();
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
  public void deleteIndexExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeleteIndexRequest request =
          DeleteIndexRequest.newBuilder()
              .setProjectId("projectId-1530")
              .setIndexId("indexId-7485")
              .build();
      client.deleteIndexAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getIndexTest() throws Exception {
    Index expectedResponse =
        Index.newBuilder()
            .setProjectId("projectId-894832108")
            .setIndexId("indexId1943291277")
            .setKind("kind3292052")
            .addAllProperties(new ArrayList<Index.IndexedProperty>())
            .build();
    mockService.addResponse(expectedResponse);

    GetIndexRequest request =
        GetIndexRequest.newBuilder()
            .setProjectId("projectId-1530")
            .setIndexId("indexId-7485")
            .build();

    Index actualResponse = client.getIndex(request);
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
  public void getIndexExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetIndexRequest request =
          GetIndexRequest.newBuilder()
              .setProjectId("projectId-1530")
              .setIndexId("indexId-7485")
              .build();
      client.getIndex(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIndexesTest() throws Exception {
    Index responsesElement = Index.newBuilder().build();
    ListIndexesResponse expectedResponse =
        ListIndexesResponse.newBuilder()
            .setNextPageToken("")
            .addAllIndexes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListIndexesRequest request =
        ListIndexesRequest.newBuilder()
            .setProjectId("projectId-1530")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListIndexesPagedResponse pagedListResponse = client.listIndexes(request);

    List<Index> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIndexesList().get(0), resources.get(0));

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
  public void listIndexesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListIndexesRequest request =
          ListIndexesRequest.newBuilder()
              .setProjectId("projectId-1530")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listIndexes(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
