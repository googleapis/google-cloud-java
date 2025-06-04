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

package com.google.cloud.discoveryengine.v1;

import static com.google.cloud.discoveryengine.v1.IdentityMappingStoreServiceClient.ListIdentityMappingStoresPagedResponse;
import static com.google.cloud.discoveryengine.v1.IdentityMappingStoreServiceClient.ListIdentityMappingsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.discoveryengine.v1.stub.HttpJsonIdentityMappingStoreServiceStub;
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
public class IdentityMappingStoreServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static IdentityMappingStoreServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonIdentityMappingStoreServiceStub.getMethodDescriptors(),
            IdentityMappingStoreServiceSettings.getDefaultEndpoint());
    IdentityMappingStoreServiceSettings settings =
        IdentityMappingStoreServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                IdentityMappingStoreServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = IdentityMappingStoreServiceClient.create(settings);
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
  public void createIdentityMappingStoreTest() throws Exception {
    IdentityMappingStore expectedResponse =
        IdentityMappingStore.newBuilder()
            .setName(
                IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
                    .toString())
            .setKmsKeyName("kmsKeyName412586233")
            .setCmekConfig(CmekConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    IdentityMappingStore identityMappingStore = IdentityMappingStore.newBuilder().build();
    String identityMappingStoreId = "identityMappingStoreId677904780";

    IdentityMappingStore actualResponse =
        client.createIdentityMappingStore(parent, identityMappingStore, identityMappingStoreId);
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
  public void createIdentityMappingStoreExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      IdentityMappingStore identityMappingStore = IdentityMappingStore.newBuilder().build();
      String identityMappingStoreId = "identityMappingStoreId677904780";
      client.createIdentityMappingStore(parent, identityMappingStore, identityMappingStoreId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createIdentityMappingStoreTest2() throws Exception {
    IdentityMappingStore expectedResponse =
        IdentityMappingStore.newBuilder()
            .setName(
                IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
                    .toString())
            .setKmsKeyName("kmsKeyName412586233")
            .setCmekConfig(CmekConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    IdentityMappingStore identityMappingStore = IdentityMappingStore.newBuilder().build();
    String identityMappingStoreId = "identityMappingStoreId677904780";

    IdentityMappingStore actualResponse =
        client.createIdentityMappingStore(parent, identityMappingStore, identityMappingStoreId);
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
  public void createIdentityMappingStoreExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      IdentityMappingStore identityMappingStore = IdentityMappingStore.newBuilder().build();
      String identityMappingStoreId = "identityMappingStoreId677904780";
      client.createIdentityMappingStore(parent, identityMappingStore, identityMappingStoreId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIdentityMappingStoreTest() throws Exception {
    IdentityMappingStore expectedResponse =
        IdentityMappingStore.newBuilder()
            .setName(
                IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
                    .toString())
            .setKmsKeyName("kmsKeyName412586233")
            .setCmekConfig(CmekConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    IdentityMappingStoreName name =
        IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]");

    IdentityMappingStore actualResponse = client.getIdentityMappingStore(name);
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
  public void getIdentityMappingStoreExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IdentityMappingStoreName name =
          IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]");
      client.getIdentityMappingStore(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIdentityMappingStoreTest2() throws Exception {
    IdentityMappingStore expectedResponse =
        IdentityMappingStore.newBuilder()
            .setName(
                IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
                    .toString())
            .setKmsKeyName("kmsKeyName412586233")
            .setCmekConfig(CmekConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7736/locations/location-7736/identityMappingStores/identityMappingStore-7736";

    IdentityMappingStore actualResponse = client.getIdentityMappingStore(name);
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
  public void getIdentityMappingStoreExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7736/locations/location-7736/identityMappingStores/identityMappingStore-7736";
      client.getIdentityMappingStore(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteIdentityMappingStoreTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteIdentityMappingStoreTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    IdentityMappingStoreName name =
        IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]");

    client.deleteIdentityMappingStoreAsync(name).get();

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
  public void deleteIdentityMappingStoreExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IdentityMappingStoreName name =
          IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]");
      client.deleteIdentityMappingStoreAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteIdentityMappingStoreTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteIdentityMappingStoreTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-7736/locations/location-7736/identityMappingStores/identityMappingStore-7736";

    client.deleteIdentityMappingStoreAsync(name).get();

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
  public void deleteIdentityMappingStoreExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7736/locations/location-7736/identityMappingStores/identityMappingStore-7736";
      client.deleteIdentityMappingStoreAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void importIdentityMappingsTest() throws Exception {
    ImportIdentityMappingsResponse expectedResponse =
        ImportIdentityMappingsResponse.newBuilder()
            .addAllErrorSamples(new ArrayList<Status>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importIdentityMappingsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ImportIdentityMappingsRequest request =
        ImportIdentityMappingsRequest.newBuilder()
            .setIdentityMappingStore(
                IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
                    .toString())
            .build();

    ImportIdentityMappingsResponse actualResponse =
        client.importIdentityMappingsAsync(request).get();
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
  public void importIdentityMappingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ImportIdentityMappingsRequest request =
          ImportIdentityMappingsRequest.newBuilder()
              .setIdentityMappingStore(
                  IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
                      .toString())
              .build();
      client.importIdentityMappingsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void purgeIdentityMappingsTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("purgeIdentityMappingsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    PurgeIdentityMappingsRequest request =
        PurgeIdentityMappingsRequest.newBuilder()
            .setIdentityMappingStore(
                IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
                    .toString())
            .setFilter("filter-1274492040")
            .setForce(true)
            .build();

    client.purgeIdentityMappingsAsync(request).get();

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
  public void purgeIdentityMappingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PurgeIdentityMappingsRequest request =
          PurgeIdentityMappingsRequest.newBuilder()
              .setIdentityMappingStore(
                  IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
                      .toString())
              .setFilter("filter-1274492040")
              .setForce(true)
              .build();
      client.purgeIdentityMappingsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listIdentityMappingsTest() throws Exception {
    IdentityMappingEntry responsesElement = IdentityMappingEntry.newBuilder().build();
    ListIdentityMappingsResponse expectedResponse =
        ListIdentityMappingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllIdentityMappingEntries(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListIdentityMappingsRequest request =
        ListIdentityMappingsRequest.newBuilder()
            .setIdentityMappingStore(
                IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
                    .toString())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListIdentityMappingsPagedResponse pagedListResponse = client.listIdentityMappings(request);

    List<IdentityMappingEntry> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIdentityMappingEntriesList().get(0), resources.get(0));

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
  public void listIdentityMappingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListIdentityMappingsRequest request =
          ListIdentityMappingsRequest.newBuilder()
              .setIdentityMappingStore(
                  IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
                      .toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listIdentityMappings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIdentityMappingStoresTest() throws Exception {
    IdentityMappingStore responsesElement = IdentityMappingStore.newBuilder().build();
    ListIdentityMappingStoresResponse expectedResponse =
        ListIdentityMappingStoresResponse.newBuilder()
            .setNextPageToken("")
            .addAllIdentityMappingStores(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListIdentityMappingStoresPagedResponse pagedListResponse =
        client.listIdentityMappingStores(parent);

    List<IdentityMappingStore> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIdentityMappingStoresList().get(0), resources.get(0));

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
  public void listIdentityMappingStoresExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listIdentityMappingStores(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIdentityMappingStoresTest2() throws Exception {
    IdentityMappingStore responsesElement = IdentityMappingStore.newBuilder().build();
    ListIdentityMappingStoresResponse expectedResponse =
        ListIdentityMappingStoresResponse.newBuilder()
            .setNextPageToken("")
            .addAllIdentityMappingStores(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListIdentityMappingStoresPagedResponse pagedListResponse =
        client.listIdentityMappingStores(parent);

    List<IdentityMappingStore> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIdentityMappingStoresList().get(0), resources.get(0));

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
  public void listIdentityMappingStoresExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listIdentityMappingStores(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
