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

import static com.google.cloud.discoveryengine.v1.DataStoreServiceClient.ListDataStoresPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.discoveryengine.v1.stub.HttpJsonDataStoreServiceStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
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
public class DataStoreServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static DataStoreServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonDataStoreServiceStub.getMethodDescriptors(),
            DataStoreServiceSettings.getDefaultEndpoint());
    DataStoreServiceSettings settings =
        DataStoreServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                DataStoreServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataStoreServiceClient.create(settings);
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
  public void createDataStoreTest() throws Exception {
    DataStore expectedResponse =
        DataStore.newBuilder()
            .setName(
                DataStoreName.ofProjectLocationDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setIndustryVertical(IndustryVertical.forNumber(0))
            .addAllSolutionTypes(new ArrayList<SolutionType>())
            .setDefaultSchemaId("defaultSchemaId1300415485")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartingSchema(Schema.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDataStoreTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
    DataStore dataStore = DataStore.newBuilder().build();
    String dataStoreId = "dataStoreId929489618";

    DataStore actualResponse = client.createDataStoreAsync(parent, dataStore, dataStoreId).get();
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
  public void createDataStoreExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
      DataStore dataStore = DataStore.newBuilder().build();
      String dataStoreId = "dataStoreId929489618";
      client.createDataStoreAsync(parent, dataStore, dataStoreId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createDataStoreTest2() throws Exception {
    DataStore expectedResponse =
        DataStore.newBuilder()
            .setName(
                DataStoreName.ofProjectLocationDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setIndustryVertical(IndustryVertical.forNumber(0))
            .addAllSolutionTypes(new ArrayList<SolutionType>())
            .setDefaultSchemaId("defaultSchemaId1300415485")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartingSchema(Schema.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDataStoreTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    DataStore dataStore = DataStore.newBuilder().build();
    String dataStoreId = "dataStoreId929489618";

    DataStore actualResponse = client.createDataStoreAsync(parent, dataStore, dataStoreId).get();
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
  public void createDataStoreExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      DataStore dataStore = DataStore.newBuilder().build();
      String dataStoreId = "dataStoreId929489618";
      client.createDataStoreAsync(parent, dataStore, dataStoreId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getDataStoreTest() throws Exception {
    DataStore expectedResponse =
        DataStore.newBuilder()
            .setName(
                DataStoreName.ofProjectLocationDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setIndustryVertical(IndustryVertical.forNumber(0))
            .addAllSolutionTypes(new ArrayList<SolutionType>())
            .setDefaultSchemaId("defaultSchemaId1300415485")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartingSchema(Schema.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    DataStoreName name =
        DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");

    DataStore actualResponse = client.getDataStore(name);
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
  public void getDataStoreExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataStoreName name =
          DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
      client.getDataStore(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataStoreTest2() throws Exception {
    DataStore expectedResponse =
        DataStore.newBuilder()
            .setName(
                DataStoreName.ofProjectLocationDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setIndustryVertical(IndustryVertical.forNumber(0))
            .addAllSolutionTypes(new ArrayList<SolutionType>())
            .setDefaultSchemaId("defaultSchemaId1300415485")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartingSchema(Schema.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1036/locations/location-1036/dataStores/dataStore-1036";

    DataStore actualResponse = client.getDataStore(name);
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
  public void getDataStoreExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1036/locations/location-1036/dataStores/dataStore-1036";
      client.getDataStore(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataStoresTest() throws Exception {
    DataStore responsesElement = DataStore.newBuilder().build();
    ListDataStoresResponse expectedResponse =
        ListDataStoresResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataStores(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");

    ListDataStoresPagedResponse pagedListResponse = client.listDataStores(parent);

    List<DataStore> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataStoresList().get(0), resources.get(0));

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
  public void listDataStoresExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
      client.listDataStores(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataStoresTest2() throws Exception {
    DataStore responsesElement = DataStore.newBuilder().build();
    ListDataStoresResponse expectedResponse =
        ListDataStoresResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataStores(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListDataStoresPagedResponse pagedListResponse = client.listDataStores(parent);

    List<DataStore> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataStoresList().get(0), resources.get(0));

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
  public void listDataStoresExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listDataStores(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDataStoreTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDataStoreTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DataStoreName name =
        DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");

    client.deleteDataStoreAsync(name).get();

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
  public void deleteDataStoreExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataStoreName name =
          DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
      client.deleteDataStoreAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteDataStoreTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDataStoreTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-1036/locations/location-1036/dataStores/dataStore-1036";

    client.deleteDataStoreAsync(name).get();

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
  public void deleteDataStoreExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1036/locations/location-1036/dataStores/dataStore-1036";
      client.deleteDataStoreAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateDataStoreTest() throws Exception {
    DataStore expectedResponse =
        DataStore.newBuilder()
            .setName(
                DataStoreName.ofProjectLocationDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setIndustryVertical(IndustryVertical.forNumber(0))
            .addAllSolutionTypes(new ArrayList<SolutionType>())
            .setDefaultSchemaId("defaultSchemaId1300415485")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartingSchema(Schema.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    DataStore dataStore =
        DataStore.newBuilder()
            .setName(
                DataStoreName.ofProjectLocationDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setIndustryVertical(IndustryVertical.forNumber(0))
            .addAllSolutionTypes(new ArrayList<SolutionType>())
            .setDefaultSchemaId("defaultSchemaId1300415485")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartingSchema(Schema.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataStore actualResponse = client.updateDataStore(dataStore, updateMask);
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
  public void updateDataStoreExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataStore dataStore =
          DataStore.newBuilder()
              .setName(
                  DataStoreName.ofProjectLocationDataStoreName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                      .toString())
              .setDisplayName("displayName1714148973")
              .setIndustryVertical(IndustryVertical.forNumber(0))
              .addAllSolutionTypes(new ArrayList<SolutionType>())
              .setDefaultSchemaId("defaultSchemaId1300415485")
              .setCreateTime(Timestamp.newBuilder().build())
              .setStartingSchema(Schema.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDataStore(dataStore, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
