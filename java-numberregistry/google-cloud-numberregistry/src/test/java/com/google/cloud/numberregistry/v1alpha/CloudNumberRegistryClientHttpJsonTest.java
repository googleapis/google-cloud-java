/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.numberregistry.v1alpha;

import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.ListCustomRangesPagedResponse;
import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.ListDiscoveredRangesPagedResponse;
import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.ListIpamAdminScopesPagedResponse;
import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.ListRealmsPagedResponse;
import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.ListRegistryBooksPagedResponse;
import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.SearchIpResourcesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.numberregistry.v1alpha.stub.HttpJsonCloudNumberRegistryStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class CloudNumberRegistryClientHttpJsonTest {
  private static MockHttpService mockService;
  private static CloudNumberRegistryClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonCloudNumberRegistryStub.getMethodDescriptors(),
            CloudNumberRegistrySettings.getDefaultEndpoint());
    CloudNumberRegistrySettings settings =
        CloudNumberRegistrySettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                CloudNumberRegistrySettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CloudNumberRegistryClient.create(settings);
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
  public void listIpamAdminScopesTest() throws Exception {
    IpamAdminScope responsesElement = IpamAdminScope.newBuilder().build();
    ListIpamAdminScopesResponse expectedResponse =
        ListIpamAdminScopesResponse.newBuilder()
            .setNextPageToken("")
            .addAllIpamAdminScopes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListIpamAdminScopesPagedResponse pagedListResponse = client.listIpamAdminScopes(parent);

    List<IpamAdminScope> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIpamAdminScopesList().get(0), resources.get(0));

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
  public void listIpamAdminScopesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listIpamAdminScopes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIpamAdminScopesTest2() throws Exception {
    IpamAdminScope responsesElement = IpamAdminScope.newBuilder().build();
    ListIpamAdminScopesResponse expectedResponse =
        ListIpamAdminScopesResponse.newBuilder()
            .setNextPageToken("")
            .addAllIpamAdminScopes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListIpamAdminScopesPagedResponse pagedListResponse = client.listIpamAdminScopes(parent);

    List<IpamAdminScope> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIpamAdminScopesList().get(0), resources.get(0));

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
  public void listIpamAdminScopesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listIpamAdminScopes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIpamAdminScopeTest() throws Exception {
    IpamAdminScope expectedResponse =
        IpamAdminScope.newBuilder()
            .setName(
                IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString())
            .addAllEnabledAddonPlatforms(new ArrayList<IpamAdminScope.AddOnPlatform>())
            .addAllScopes(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    IpamAdminScopeName name =
        IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]");

    IpamAdminScope actualResponse = client.getIpamAdminScope(name);
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
  public void getIpamAdminScopeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IpamAdminScopeName name =
          IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]");
      client.getIpamAdminScope(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIpamAdminScopeTest2() throws Exception {
    IpamAdminScope expectedResponse =
        IpamAdminScope.newBuilder()
            .setName(
                IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString())
            .addAllEnabledAddonPlatforms(new ArrayList<IpamAdminScope.AddOnPlatform>())
            .addAllScopes(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-8033/locations/location-8033/ipamAdminScopes/ipamAdminScope-8033";

    IpamAdminScope actualResponse = client.getIpamAdminScope(name);
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
  public void getIpamAdminScopeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8033/locations/location-8033/ipamAdminScopes/ipamAdminScope-8033";
      client.getIpamAdminScope(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void checkAvailabilityIpamAdminScopesTest() throws Exception {
    CheckAvailabilityIpamAdminScopesResponse expectedResponse =
        CheckAvailabilityIpamAdminScopesResponse.newBuilder()
            .addAllScopeAvailabilities(new ArrayList<IpamAdminScopeAvailability>())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    List<String> scopes = new ArrayList<>();

    CheckAvailabilityIpamAdminScopesResponse actualResponse =
        client.checkAvailabilityIpamAdminScopes(parent, scopes);
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
  public void checkAvailabilityIpamAdminScopesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      List<String> scopes = new ArrayList<>();
      client.checkAvailabilityIpamAdminScopes(parent, scopes);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void checkAvailabilityIpamAdminScopesTest2() throws Exception {
    CheckAvailabilityIpamAdminScopesResponse expectedResponse =
        CheckAvailabilityIpamAdminScopesResponse.newBuilder()
            .addAllScopeAvailabilities(new ArrayList<IpamAdminScopeAvailability>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    List<String> scopes = new ArrayList<>();

    CheckAvailabilityIpamAdminScopesResponse actualResponse =
        client.checkAvailabilityIpamAdminScopes(parent, scopes);
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
  public void checkAvailabilityIpamAdminScopesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      List<String> scopes = new ArrayList<>();
      client.checkAvailabilityIpamAdminScopes(parent, scopes);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createIpamAdminScopeTest() throws Exception {
    IpamAdminScope expectedResponse =
        IpamAdminScope.newBuilder()
            .setName(
                IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString())
            .addAllEnabledAddonPlatforms(new ArrayList<IpamAdminScope.AddOnPlatform>())
            .addAllScopes(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createIpamAdminScopeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    IpamAdminScope ipamAdminScope = IpamAdminScope.newBuilder().build();
    String ipamAdminScopeId = "ipamAdminScopeId1628703603";

    IpamAdminScope actualResponse =
        client.createIpamAdminScopeAsync(parent, ipamAdminScope, ipamAdminScopeId).get();
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
  public void createIpamAdminScopeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      IpamAdminScope ipamAdminScope = IpamAdminScope.newBuilder().build();
      String ipamAdminScopeId = "ipamAdminScopeId1628703603";
      client.createIpamAdminScopeAsync(parent, ipamAdminScope, ipamAdminScopeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createIpamAdminScopeTest2() throws Exception {
    IpamAdminScope expectedResponse =
        IpamAdminScope.newBuilder()
            .setName(
                IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString())
            .addAllEnabledAddonPlatforms(new ArrayList<IpamAdminScope.AddOnPlatform>())
            .addAllScopes(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createIpamAdminScopeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    IpamAdminScope ipamAdminScope = IpamAdminScope.newBuilder().build();
    String ipamAdminScopeId = "ipamAdminScopeId1628703603";

    IpamAdminScope actualResponse =
        client.createIpamAdminScopeAsync(parent, ipamAdminScope, ipamAdminScopeId).get();
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
  public void createIpamAdminScopeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      IpamAdminScope ipamAdminScope = IpamAdminScope.newBuilder().build();
      String ipamAdminScopeId = "ipamAdminScopeId1628703603";
      client.createIpamAdminScopeAsync(parent, ipamAdminScope, ipamAdminScopeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateIpamAdminScopeTest() throws Exception {
    IpamAdminScope expectedResponse =
        IpamAdminScope.newBuilder()
            .setName(
                IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString())
            .addAllEnabledAddonPlatforms(new ArrayList<IpamAdminScope.AddOnPlatform>())
            .addAllScopes(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateIpamAdminScopeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    IpamAdminScope ipamAdminScope =
        IpamAdminScope.newBuilder()
            .setName(
                IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString())
            .addAllEnabledAddonPlatforms(new ArrayList<IpamAdminScope.AddOnPlatform>())
            .addAllScopes(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    IpamAdminScope actualResponse =
        client.updateIpamAdminScopeAsync(ipamAdminScope, updateMask).get();
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
  public void updateIpamAdminScopeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IpamAdminScope ipamAdminScope =
          IpamAdminScope.newBuilder()
              .setName(
                  IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString())
              .addAllEnabledAddonPlatforms(new ArrayList<IpamAdminScope.AddOnPlatform>())
              .addAllScopes(new ArrayList<String>())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateIpamAdminScopeAsync(ipamAdminScope, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteIpamAdminScopeTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteIpamAdminScopeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    IpamAdminScopeName name =
        IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]");

    client.deleteIpamAdminScopeAsync(name).get();

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
  public void deleteIpamAdminScopeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IpamAdminScopeName name =
          IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]");
      client.deleteIpamAdminScopeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteIpamAdminScopeTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteIpamAdminScopeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-8033/locations/location-8033/ipamAdminScopes/ipamAdminScope-8033";

    client.deleteIpamAdminScopeAsync(name).get();

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
  public void deleteIpamAdminScopeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8033/locations/location-8033/ipamAdminScopes/ipamAdminScope-8033";
      client.deleteIpamAdminScopeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void disableIpamAdminScopeTest() throws Exception {
    IpamAdminScope expectedResponse =
        IpamAdminScope.newBuilder()
            .setName(
                IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString())
            .addAllEnabledAddonPlatforms(new ArrayList<IpamAdminScope.AddOnPlatform>())
            .addAllScopes(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("disableIpamAdminScopeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    IpamAdminScopeName name =
        IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]");

    IpamAdminScope actualResponse = client.disableIpamAdminScopeAsync(name).get();
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
  public void disableIpamAdminScopeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IpamAdminScopeName name =
          IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]");
      client.disableIpamAdminScopeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void disableIpamAdminScopeTest2() throws Exception {
    IpamAdminScope expectedResponse =
        IpamAdminScope.newBuilder()
            .setName(
                IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString())
            .addAllEnabledAddonPlatforms(new ArrayList<IpamAdminScope.AddOnPlatform>())
            .addAllScopes(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("disableIpamAdminScopeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-8033/locations/location-8033/ipamAdminScopes/ipamAdminScope-8033";

    IpamAdminScope actualResponse = client.disableIpamAdminScopeAsync(name).get();
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
  public void disableIpamAdminScopeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8033/locations/location-8033/ipamAdminScopes/ipamAdminScope-8033";
      client.disableIpamAdminScopeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void cleanupIpamAdminScopeTest() throws Exception {
    IpamAdminScope expectedResponse =
        IpamAdminScope.newBuilder()
            .setName(
                IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString())
            .addAllEnabledAddonPlatforms(new ArrayList<IpamAdminScope.AddOnPlatform>())
            .addAllScopes(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("cleanupIpamAdminScopeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    IpamAdminScopeName name =
        IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]");

    IpamAdminScope actualResponse = client.cleanupIpamAdminScopeAsync(name).get();
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
  public void cleanupIpamAdminScopeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IpamAdminScopeName name =
          IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]");
      client.cleanupIpamAdminScopeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void cleanupIpamAdminScopeTest2() throws Exception {
    IpamAdminScope expectedResponse =
        IpamAdminScope.newBuilder()
            .setName(
                IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString())
            .addAllEnabledAddonPlatforms(new ArrayList<IpamAdminScope.AddOnPlatform>())
            .addAllScopes(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("cleanupIpamAdminScopeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-8033/locations/location-8033/ipamAdminScopes/ipamAdminScope-8033";

    IpamAdminScope actualResponse = client.cleanupIpamAdminScopeAsync(name).get();
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
  public void cleanupIpamAdminScopeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8033/locations/location-8033/ipamAdminScopes/ipamAdminScope-8033";
      client.cleanupIpamAdminScopeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listRegistryBooksTest() throws Exception {
    RegistryBook responsesElement = RegistryBook.newBuilder().build();
    ListRegistryBooksResponse expectedResponse =
        ListRegistryBooksResponse.newBuilder()
            .setNextPageToken("")
            .addAllRegistryBooks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListRegistryBooksPagedResponse pagedListResponse = client.listRegistryBooks(parent);

    List<RegistryBook> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRegistryBooksList().get(0), resources.get(0));

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
  public void listRegistryBooksExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listRegistryBooks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRegistryBooksTest2() throws Exception {
    RegistryBook responsesElement = RegistryBook.newBuilder().build();
    ListRegistryBooksResponse expectedResponse =
        ListRegistryBooksResponse.newBuilder()
            .setNextPageToken("")
            .addAllRegistryBooks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListRegistryBooksPagedResponse pagedListResponse = client.listRegistryBooks(parent);

    List<RegistryBook> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRegistryBooksList().get(0), resources.get(0));

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
  public void listRegistryBooksExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listRegistryBooks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRegistryBookTest() throws Exception {
    RegistryBook expectedResponse =
        RegistryBook.newBuilder()
            .setName(RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllClaimedScopes(new ArrayList<String>())
            .setIsDefault(true)
            .setAggregatedData(RegistryBook.AggregatedData.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    RegistryBookName name = RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]");

    RegistryBook actualResponse = client.getRegistryBook(name);
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
  public void getRegistryBookExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RegistryBookName name = RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]");
      client.getRegistryBook(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRegistryBookTest2() throws Exception {
    RegistryBook expectedResponse =
        RegistryBook.newBuilder()
            .setName(RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllClaimedScopes(new ArrayList<String>())
            .setIsDefault(true)
            .setAggregatedData(RegistryBook.AggregatedData.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-3699/locations/location-3699/registryBooks/registryBook-3699";

    RegistryBook actualResponse = client.getRegistryBook(name);
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
  public void getRegistryBookExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3699/locations/location-3699/registryBooks/registryBook-3699";
      client.getRegistryBook(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchIpResourcesTest() throws Exception {
    Range responsesElement = Range.newBuilder().build();
    SearchIpResourcesResponse expectedResponse =
        SearchIpResourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllRanges(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    RegistryBookName name = RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]");

    SearchIpResourcesPagedResponse pagedListResponse = client.searchIpResources(name);

    List<Range> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRangesList().get(0), resources.get(0));

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
  public void searchIpResourcesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RegistryBookName name = RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]");
      client.searchIpResources(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchIpResourcesTest2() throws Exception {
    Range responsesElement = Range.newBuilder().build();
    SearchIpResourcesResponse expectedResponse =
        SearchIpResourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllRanges(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-3699/locations/location-3699/registryBooks/registryBook-3699";

    SearchIpResourcesPagedResponse pagedListResponse = client.searchIpResources(name);

    List<Range> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRangesList().get(0), resources.get(0));

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
  public void searchIpResourcesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3699/locations/location-3699/registryBooks/registryBook-3699";
      client.searchIpResources(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createRegistryBookTest() throws Exception {
    RegistryBook expectedResponse =
        RegistryBook.newBuilder()
            .setName(RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllClaimedScopes(new ArrayList<String>())
            .setIsDefault(true)
            .setAggregatedData(RegistryBook.AggregatedData.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createRegistryBookTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    RegistryBook registryBook = RegistryBook.newBuilder().build();
    String registryBookId = "registryBookId2126801025";

    RegistryBook actualResponse =
        client.createRegistryBookAsync(parent, registryBook, registryBookId).get();
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
  public void createRegistryBookExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      RegistryBook registryBook = RegistryBook.newBuilder().build();
      String registryBookId = "registryBookId2126801025";
      client.createRegistryBookAsync(parent, registryBook, registryBookId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createRegistryBookTest2() throws Exception {
    RegistryBook expectedResponse =
        RegistryBook.newBuilder()
            .setName(RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllClaimedScopes(new ArrayList<String>())
            .setIsDefault(true)
            .setAggregatedData(RegistryBook.AggregatedData.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createRegistryBookTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    RegistryBook registryBook = RegistryBook.newBuilder().build();
    String registryBookId = "registryBookId2126801025";

    RegistryBook actualResponse =
        client.createRegistryBookAsync(parent, registryBook, registryBookId).get();
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
  public void createRegistryBookExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      RegistryBook registryBook = RegistryBook.newBuilder().build();
      String registryBookId = "registryBookId2126801025";
      client.createRegistryBookAsync(parent, registryBook, registryBookId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateRegistryBookTest() throws Exception {
    RegistryBook expectedResponse =
        RegistryBook.newBuilder()
            .setName(RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllClaimedScopes(new ArrayList<String>())
            .setIsDefault(true)
            .setAggregatedData(RegistryBook.AggregatedData.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateRegistryBookTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    RegistryBook registryBook =
        RegistryBook.newBuilder()
            .setName(RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllClaimedScopes(new ArrayList<String>())
            .setIsDefault(true)
            .setAggregatedData(RegistryBook.AggregatedData.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    RegistryBook actualResponse = client.updateRegistryBookAsync(registryBook, updateMask).get();
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
  public void updateRegistryBookExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RegistryBook registryBook =
          RegistryBook.newBuilder()
              .setName(RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .addAllClaimedScopes(new ArrayList<String>())
              .setIsDefault(true)
              .setAggregatedData(RegistryBook.AggregatedData.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateRegistryBookAsync(registryBook, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteRegistryBookTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRegistryBookTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    RegistryBookName name = RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]");

    client.deleteRegistryBookAsync(name).get();

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
  public void deleteRegistryBookExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RegistryBookName name = RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]");
      client.deleteRegistryBookAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteRegistryBookTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRegistryBookTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-3699/locations/location-3699/registryBooks/registryBook-3699";

    client.deleteRegistryBookAsync(name).get();

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
  public void deleteRegistryBookExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3699/locations/location-3699/registryBooks/registryBook-3699";
      client.deleteRegistryBookAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listRealmsTest() throws Exception {
    Realm responsesElement = Realm.newBuilder().build();
    ListRealmsResponse expectedResponse =
        ListRealmsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRealms(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListRealmsPagedResponse pagedListResponse = client.listRealms(parent);

    List<Realm> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRealmsList().get(0), resources.get(0));

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
  public void listRealmsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listRealms(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRealmsTest2() throws Exception {
    Realm responsesElement = Realm.newBuilder().build();
    ListRealmsResponse expectedResponse =
        ListRealmsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRealms(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListRealmsPagedResponse pagedListResponse = client.listRealms(parent);

    List<Realm> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRealmsList().get(0), resources.get(0));

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
  public void listRealmsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listRealms(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRealmTest() throws Exception {
    Realm expectedResponse =
        Realm.newBuilder()
            .setName(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
            .setRegistryBook(
                RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString())
            .setDiscoveryMetadata(DiscoveryMetadata.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setIpVersion(IpVersion.forNumber(0))
            .setAggregatedData(Realm.RealmAggregatedData.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    RealmName name = RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]");

    Realm actualResponse = client.getRealm(name);
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
  public void getRealmExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RealmName name = RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]");
      client.getRealm(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRealmTest2() throws Exception {
    Realm expectedResponse =
        Realm.newBuilder()
            .setName(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
            .setRegistryBook(
                RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString())
            .setDiscoveryMetadata(DiscoveryMetadata.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setIpVersion(IpVersion.forNumber(0))
            .setAggregatedData(Realm.RealmAggregatedData.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9444/locations/location-9444/realms/realm-9444";

    Realm actualResponse = client.getRealm(name);
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
  public void getRealmExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9444/locations/location-9444/realms/realm-9444";
      client.getRealm(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createRealmTest() throws Exception {
    Realm expectedResponse =
        Realm.newBuilder()
            .setName(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
            .setRegistryBook(
                RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString())
            .setDiscoveryMetadata(DiscoveryMetadata.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setIpVersion(IpVersion.forNumber(0))
            .setAggregatedData(Realm.RealmAggregatedData.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createRealmTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Realm realm = Realm.newBuilder().build();
    String realmId = "realmId1080654858";

    Realm actualResponse = client.createRealmAsync(parent, realm, realmId).get();
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
  public void createRealmExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Realm realm = Realm.newBuilder().build();
      String realmId = "realmId1080654858";
      client.createRealmAsync(parent, realm, realmId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createRealmTest2() throws Exception {
    Realm expectedResponse =
        Realm.newBuilder()
            .setName(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
            .setRegistryBook(
                RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString())
            .setDiscoveryMetadata(DiscoveryMetadata.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setIpVersion(IpVersion.forNumber(0))
            .setAggregatedData(Realm.RealmAggregatedData.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createRealmTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Realm realm = Realm.newBuilder().build();
    String realmId = "realmId1080654858";

    Realm actualResponse = client.createRealmAsync(parent, realm, realmId).get();
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
  public void createRealmExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Realm realm = Realm.newBuilder().build();
      String realmId = "realmId1080654858";
      client.createRealmAsync(parent, realm, realmId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateRealmTest() throws Exception {
    Realm expectedResponse =
        Realm.newBuilder()
            .setName(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
            .setRegistryBook(
                RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString())
            .setDiscoveryMetadata(DiscoveryMetadata.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setIpVersion(IpVersion.forNumber(0))
            .setAggregatedData(Realm.RealmAggregatedData.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateRealmTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Realm realm =
        Realm.newBuilder()
            .setName(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
            .setRegistryBook(
                RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString())
            .setDiscoveryMetadata(DiscoveryMetadata.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setIpVersion(IpVersion.forNumber(0))
            .setAggregatedData(Realm.RealmAggregatedData.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Realm actualResponse = client.updateRealmAsync(realm, updateMask).get();
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
  public void updateRealmExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Realm realm =
          Realm.newBuilder()
              .setName(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
              .setRegistryBook(
                  RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString())
              .setDiscoveryMetadata(DiscoveryMetadata.newBuilder().build())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setIpVersion(IpVersion.forNumber(0))
              .setAggregatedData(Realm.RealmAggregatedData.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateRealmAsync(realm, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteRealmTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRealmTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    RealmName name = RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]");

    client.deleteRealmAsync(name).get();

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
  public void deleteRealmExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RealmName name = RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]");
      client.deleteRealmAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteRealmTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRealmTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-9444/locations/location-9444/realms/realm-9444";

    client.deleteRealmAsync(name).get();

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
  public void deleteRealmExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9444/locations/location-9444/realms/realm-9444";
      client.deleteRealmAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listDiscoveredRangesTest() throws Exception {
    DiscoveredRange responsesElement = DiscoveredRange.newBuilder().build();
    ListDiscoveredRangesResponse expectedResponse =
        ListDiscoveredRangesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDiscoveredRanges(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDiscoveredRangesPagedResponse pagedListResponse = client.listDiscoveredRanges(parent);

    List<DiscoveredRange> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDiscoveredRangesList().get(0), resources.get(0));

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
  public void listDiscoveredRangesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDiscoveredRanges(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDiscoveredRangesTest2() throws Exception {
    DiscoveredRange responsesElement = DiscoveredRange.newBuilder().build();
    ListDiscoveredRangesResponse expectedResponse =
        ListDiscoveredRangesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDiscoveredRanges(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListDiscoveredRangesPagedResponse pagedListResponse = client.listDiscoveredRanges(parent);

    List<DiscoveredRange> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDiscoveredRangesList().get(0), resources.get(0));

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
  public void listDiscoveredRangesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listDiscoveredRanges(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDiscoveredRangeTest() throws Exception {
    DiscoveredRange expectedResponse =
        DiscoveredRange.newBuilder()
            .setName(
                DiscoveredRangeName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_RANGE]").toString())
            .setRealm(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
            .setParentRange(
                DiscoveredRangeName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_RANGE]").toString())
            .setRegistryBook("registryBook-1329628986")
            .setDescription("description-1724546052")
            .setDiscoveryMetadata(DiscoveryMetadata.newBuilder().build())
            .addAllAttributes(new ArrayList<Attribute>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setChildCidrOverlapAllowed(true)
            .build();
    mockService.addResponse(expectedResponse);

    DiscoveredRangeName name =
        DiscoveredRangeName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_RANGE]");

    DiscoveredRange actualResponse = client.getDiscoveredRange(name);
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
  public void getDiscoveredRangeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DiscoveredRangeName name =
          DiscoveredRangeName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_RANGE]");
      client.getDiscoveredRange(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDiscoveredRangeTest2() throws Exception {
    DiscoveredRange expectedResponse =
        DiscoveredRange.newBuilder()
            .setName(
                DiscoveredRangeName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_RANGE]").toString())
            .setRealm(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
            .setParentRange(
                DiscoveredRangeName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_RANGE]").toString())
            .setRegistryBook("registryBook-1329628986")
            .setDescription("description-1724546052")
            .setDiscoveryMetadata(DiscoveryMetadata.newBuilder().build())
            .addAllAttributes(new ArrayList<Attribute>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setChildCidrOverlapAllowed(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1762/locations/location-1762/discoveredRanges/discoveredRange-1762";

    DiscoveredRange actualResponse = client.getDiscoveredRange(name);
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
  public void getDiscoveredRangeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1762/locations/location-1762/discoveredRanges/discoveredRange-1762";
      client.getDiscoveredRange(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void findDiscoveredRangeFreeIpRangesTest() throws Exception {
    FindDiscoveredRangeFreeIpRangesResponse expectedResponse =
        FindDiscoveredRangeFreeIpRangesResponse.newBuilder()
            .addAllFreeIpCidrRanges(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    DiscoveredRangeName name =
        DiscoveredRangeName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_RANGE]");
    int cidrPrefixLength = -954389592;

    FindDiscoveredRangeFreeIpRangesResponse actualResponse =
        client.findDiscoveredRangeFreeIpRanges(name, cidrPrefixLength);
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
  public void findDiscoveredRangeFreeIpRangesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DiscoveredRangeName name =
          DiscoveredRangeName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_RANGE]");
      int cidrPrefixLength = -954389592;
      client.findDiscoveredRangeFreeIpRanges(name, cidrPrefixLength);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void findDiscoveredRangeFreeIpRangesTest2() throws Exception {
    FindDiscoveredRangeFreeIpRangesResponse expectedResponse =
        FindDiscoveredRangeFreeIpRangesResponse.newBuilder()
            .addAllFreeIpCidrRanges(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1762/locations/location-1762/discoveredRanges/discoveredRange-1762";
    int cidrPrefixLength = -954389592;

    FindDiscoveredRangeFreeIpRangesResponse actualResponse =
        client.findDiscoveredRangeFreeIpRanges(name, cidrPrefixLength);
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
  public void findDiscoveredRangeFreeIpRangesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1762/locations/location-1762/discoveredRanges/discoveredRange-1762";
      int cidrPrefixLength = -954389592;
      client.findDiscoveredRangeFreeIpRanges(name, cidrPrefixLength);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCustomRangesTest() throws Exception {
    CustomRange responsesElement = CustomRange.newBuilder().build();
    ListCustomRangesResponse expectedResponse =
        ListCustomRangesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCustomRanges(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListCustomRangesPagedResponse pagedListResponse = client.listCustomRanges(parent);

    List<CustomRange> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCustomRangesList().get(0), resources.get(0));

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
  public void listCustomRangesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listCustomRanges(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCustomRangesTest2() throws Exception {
    CustomRange responsesElement = CustomRange.newBuilder().build();
    ListCustomRangesResponse expectedResponse =
        ListCustomRangesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCustomRanges(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListCustomRangesPagedResponse pagedListResponse = client.listCustomRanges(parent);

    List<CustomRange> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCustomRangesList().get(0), resources.get(0));

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
  public void listCustomRangesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listCustomRanges(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCustomRangeTest() throws Exception {
    CustomRange expectedResponse =
        CustomRange.newBuilder()
            .setName(CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString())
            .setRealm(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
            .setParentRange(
                CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString())
            .setRegistryBook("registryBook-1329628986")
            .addAllAttributes(new ArrayList<Attribute>())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    CustomRangeName name = CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]");

    CustomRange actualResponse = client.getCustomRange(name);
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
  public void getCustomRangeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CustomRangeName name = CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]");
      client.getCustomRange(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCustomRangeTest2() throws Exception {
    CustomRange expectedResponse =
        CustomRange.newBuilder()
            .setName(CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString())
            .setRealm(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
            .setParentRange(
                CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString())
            .setRegistryBook("registryBook-1329628986")
            .addAllAttributes(new ArrayList<Attribute>())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-3303/locations/location-3303/customRanges/customRange-3303";

    CustomRange actualResponse = client.getCustomRange(name);
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
  public void getCustomRangeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3303/locations/location-3303/customRanges/customRange-3303";
      client.getCustomRange(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void showCustomRangeUtilizationTest() throws Exception {
    ShowCustomRangeUtilizationResponse expectedResponse =
        ShowCustomRangeUtilizationResponse.newBuilder()
            .setCustomRange(CustomRange.newBuilder().build())
            .setRangeUtilization(RangeUtilization.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    CustomRangeName name = CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]");

    ShowCustomRangeUtilizationResponse actualResponse = client.showCustomRangeUtilization(name);
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
  public void showCustomRangeUtilizationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CustomRangeName name = CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]");
      client.showCustomRangeUtilization(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void showCustomRangeUtilizationTest2() throws Exception {
    ShowCustomRangeUtilizationResponse expectedResponse =
        ShowCustomRangeUtilizationResponse.newBuilder()
            .setCustomRange(CustomRange.newBuilder().build())
            .setRangeUtilization(RangeUtilization.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-3303/locations/location-3303/customRanges/customRange-3303";

    ShowCustomRangeUtilizationResponse actualResponse = client.showCustomRangeUtilization(name);
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
  public void showCustomRangeUtilizationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3303/locations/location-3303/customRanges/customRange-3303";
      client.showCustomRangeUtilization(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void showDiscoveredRangeUtilizationTest() throws Exception {
    ShowDiscoveredRangeUtilizationResponse expectedResponse =
        ShowDiscoveredRangeUtilizationResponse.newBuilder()
            .setDiscoveredRange(DiscoveredRange.newBuilder().build())
            .setRangeUtilization(RangeUtilization.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    DiscoveredRangeName name =
        DiscoveredRangeName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_RANGE]");

    ShowDiscoveredRangeUtilizationResponse actualResponse =
        client.showDiscoveredRangeUtilization(name);
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
  public void showDiscoveredRangeUtilizationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DiscoveredRangeName name =
          DiscoveredRangeName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_RANGE]");
      client.showDiscoveredRangeUtilization(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void showDiscoveredRangeUtilizationTest2() throws Exception {
    ShowDiscoveredRangeUtilizationResponse expectedResponse =
        ShowDiscoveredRangeUtilizationResponse.newBuilder()
            .setDiscoveredRange(DiscoveredRange.newBuilder().build())
            .setRangeUtilization(RangeUtilization.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1762/locations/location-1762/discoveredRanges/discoveredRange-1762";

    ShowDiscoveredRangeUtilizationResponse actualResponse =
        client.showDiscoveredRangeUtilization(name);
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
  public void showDiscoveredRangeUtilizationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1762/locations/location-1762/discoveredRanges/discoveredRange-1762";
      client.showDiscoveredRangeUtilization(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void findCustomRangeFreeIpRangesTest() throws Exception {
    FindCustomRangeFreeIpRangesResponse expectedResponse =
        FindCustomRangeFreeIpRangesResponse.newBuilder()
            .addAllFreeIpCidrRanges(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    CustomRangeName name = CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]");
    int cidrPrefixLength = -954389592;

    FindCustomRangeFreeIpRangesResponse actualResponse =
        client.findCustomRangeFreeIpRanges(name, cidrPrefixLength);
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
  public void findCustomRangeFreeIpRangesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CustomRangeName name = CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]");
      int cidrPrefixLength = -954389592;
      client.findCustomRangeFreeIpRanges(name, cidrPrefixLength);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void findCustomRangeFreeIpRangesTest2() throws Exception {
    FindCustomRangeFreeIpRangesResponse expectedResponse =
        FindCustomRangeFreeIpRangesResponse.newBuilder()
            .addAllFreeIpCidrRanges(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-3303/locations/location-3303/customRanges/customRange-3303";
    int cidrPrefixLength = -954389592;

    FindCustomRangeFreeIpRangesResponse actualResponse =
        client.findCustomRangeFreeIpRanges(name, cidrPrefixLength);
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
  public void findCustomRangeFreeIpRangesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3303/locations/location-3303/customRanges/customRange-3303";
      int cidrPrefixLength = -954389592;
      client.findCustomRangeFreeIpRanges(name, cidrPrefixLength);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCustomRangeTest() throws Exception {
    CustomRange expectedResponse =
        CustomRange.newBuilder()
            .setName(CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString())
            .setRealm(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
            .setParentRange(
                CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString())
            .setRegistryBook("registryBook-1329628986")
            .addAllAttributes(new ArrayList<Attribute>())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCustomRangeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    CustomRange customRange = CustomRange.newBuilder().build();
    String customRangeId = "customRangeId1995399815";

    CustomRange actualResponse =
        client.createCustomRangeAsync(parent, customRange, customRangeId).get();
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
  public void createCustomRangeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      CustomRange customRange = CustomRange.newBuilder().build();
      String customRangeId = "customRangeId1995399815";
      client.createCustomRangeAsync(parent, customRange, customRangeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createCustomRangeTest2() throws Exception {
    CustomRange expectedResponse =
        CustomRange.newBuilder()
            .setName(CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString())
            .setRealm(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
            .setParentRange(
                CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString())
            .setRegistryBook("registryBook-1329628986")
            .addAllAttributes(new ArrayList<Attribute>())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCustomRangeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    CustomRange customRange = CustomRange.newBuilder().build();
    String customRangeId = "customRangeId1995399815";

    CustomRange actualResponse =
        client.createCustomRangeAsync(parent, customRange, customRangeId).get();
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
  public void createCustomRangeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      CustomRange customRange = CustomRange.newBuilder().build();
      String customRangeId = "customRangeId1995399815";
      client.createCustomRangeAsync(parent, customRange, customRangeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateCustomRangeTest() throws Exception {
    CustomRange expectedResponse =
        CustomRange.newBuilder()
            .setName(CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString())
            .setRealm(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
            .setParentRange(
                CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString())
            .setRegistryBook("registryBook-1329628986")
            .addAllAttributes(new ArrayList<Attribute>())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateCustomRangeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CustomRange customRange =
        CustomRange.newBuilder()
            .setName(CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString())
            .setRealm(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
            .setParentRange(
                CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString())
            .setRegistryBook("registryBook-1329628986")
            .addAllAttributes(new ArrayList<Attribute>())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CustomRange actualResponse = client.updateCustomRangeAsync(customRange, updateMask).get();
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
  public void updateCustomRangeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CustomRange customRange =
          CustomRange.newBuilder()
              .setName(CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString())
              .setRealm(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
              .setParentRange(
                  CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString())
              .setRegistryBook("registryBook-1329628986")
              .addAllAttributes(new ArrayList<Attribute>())
              .setDescription("description-1724546052")
              .putAllLabels(new HashMap<String, String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCustomRangeAsync(customRange, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteCustomRangeTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCustomRangeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CustomRangeName name = CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]");

    client.deleteCustomRangeAsync(name).get();

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
  public void deleteCustomRangeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CustomRangeName name = CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]");
      client.deleteCustomRangeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteCustomRangeTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCustomRangeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-3303/locations/location-3303/customRanges/customRange-3303";

    client.deleteCustomRangeAsync(name).get();

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
  public void deleteCustomRangeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3303/locations/location-3303/customRanges/customRange-3303";
      client.deleteCustomRangeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
