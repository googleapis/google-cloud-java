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

package com.google.cloud.configdelivery.v1;

import static com.google.cloud.configdelivery.v1.ConfigDeliveryClient.ListFleetPackagesPagedResponse;
import static com.google.cloud.configdelivery.v1.ConfigDeliveryClient.ListLocationsPagedResponse;
import static com.google.cloud.configdelivery.v1.ConfigDeliveryClient.ListReleasesPagedResponse;
import static com.google.cloud.configdelivery.v1.ConfigDeliveryClient.ListResourceBundlesPagedResponse;
import static com.google.cloud.configdelivery.v1.ConfigDeliveryClient.ListRolloutsPagedResponse;
import static com.google.cloud.configdelivery.v1.ConfigDeliveryClient.ListVariantsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.configdelivery.v1.stub.HttpJsonConfigDeliveryStub;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
public class ConfigDeliveryClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ConfigDeliveryClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonConfigDeliveryStub.getMethodDescriptors(),
            ConfigDeliverySettings.getDefaultEndpoint());
    ConfigDeliverySettings settings =
        ConfigDeliverySettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ConfigDeliverySettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ConfigDeliveryClient.create(settings);
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
  public void listResourceBundlesTest() throws Exception {
    ResourceBundle responsesElement = ResourceBundle.newBuilder().build();
    ListResourceBundlesResponse expectedResponse =
        ListResourceBundlesResponse.newBuilder()
            .setNextPageToken("")
            .addAllResourceBundles(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListResourceBundlesPagedResponse pagedListResponse = client.listResourceBundles(parent);

    List<ResourceBundle> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResourceBundlesList().get(0), resources.get(0));

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
  public void listResourceBundlesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listResourceBundles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listResourceBundlesTest2() throws Exception {
    ResourceBundle responsesElement = ResourceBundle.newBuilder().build();
    ListResourceBundlesResponse expectedResponse =
        ListResourceBundlesResponse.newBuilder()
            .setNextPageToken("")
            .addAllResourceBundles(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListResourceBundlesPagedResponse pagedListResponse = client.listResourceBundles(parent);

    List<ResourceBundle> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResourceBundlesList().get(0), resources.get(0));

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
  public void listResourceBundlesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listResourceBundles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getResourceBundleTest() throws Exception {
    ResourceBundle expectedResponse =
        ResourceBundle.newBuilder()
            .setName(
                ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .build();
    mockService.addResponse(expectedResponse);

    ResourceBundleName name = ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]");

    ResourceBundle actualResponse = client.getResourceBundle(name);
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
  public void getResourceBundleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ResourceBundleName name =
          ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]");
      client.getResourceBundle(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getResourceBundleTest2() throws Exception {
    ResourceBundle expectedResponse =
        ResourceBundle.newBuilder()
            .setName(
                ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3769/locations/location-3769/resourceBundles/resourceBundle-3769";

    ResourceBundle actualResponse = client.getResourceBundle(name);
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
  public void getResourceBundleExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3769/locations/location-3769/resourceBundles/resourceBundle-3769";
      client.getResourceBundle(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createResourceBundleTest() throws Exception {
    ResourceBundle expectedResponse =
        ResourceBundle.newBuilder()
            .setName(
                ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createResourceBundleTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ResourceBundle resourceBundle = ResourceBundle.newBuilder().build();
    String resourceBundleId = "resourceBundleId1209359211";

    ResourceBundle actualResponse =
        client.createResourceBundleAsync(parent, resourceBundle, resourceBundleId).get();
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
  public void createResourceBundleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ResourceBundle resourceBundle = ResourceBundle.newBuilder().build();
      String resourceBundleId = "resourceBundleId1209359211";
      client.createResourceBundleAsync(parent, resourceBundle, resourceBundleId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createResourceBundleTest2() throws Exception {
    ResourceBundle expectedResponse =
        ResourceBundle.newBuilder()
            .setName(
                ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createResourceBundleTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    ResourceBundle resourceBundle = ResourceBundle.newBuilder().build();
    String resourceBundleId = "resourceBundleId1209359211";

    ResourceBundle actualResponse =
        client.createResourceBundleAsync(parent, resourceBundle, resourceBundleId).get();
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
  public void createResourceBundleExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      ResourceBundle resourceBundle = ResourceBundle.newBuilder().build();
      String resourceBundleId = "resourceBundleId1209359211";
      client.createResourceBundleAsync(parent, resourceBundle, resourceBundleId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateResourceBundleTest() throws Exception {
    ResourceBundle expectedResponse =
        ResourceBundle.newBuilder()
            .setName(
                ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateResourceBundleTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ResourceBundle resourceBundle =
        ResourceBundle.newBuilder()
            .setName(
                ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ResourceBundle actualResponse =
        client.updateResourceBundleAsync(resourceBundle, updateMask).get();
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
  public void updateResourceBundleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ResourceBundle resourceBundle =
          ResourceBundle.newBuilder()
              .setName(
                  ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]").toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setDescription("description-1724546052")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateResourceBundleAsync(resourceBundle, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteResourceBundleTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteResourceBundleTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ResourceBundleName name = ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]");

    client.deleteResourceBundleAsync(name).get();

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
  public void deleteResourceBundleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ResourceBundleName name =
          ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]");
      client.deleteResourceBundleAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteResourceBundleTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteResourceBundleTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-3769/locations/location-3769/resourceBundles/resourceBundle-3769";

    client.deleteResourceBundleAsync(name).get();

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
  public void deleteResourceBundleExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3769/locations/location-3769/resourceBundles/resourceBundle-3769";
      client.deleteResourceBundleAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listFleetPackagesTest() throws Exception {
    FleetPackage responsesElement = FleetPackage.newBuilder().build();
    ListFleetPackagesResponse expectedResponse =
        ListFleetPackagesResponse.newBuilder()
            .setNextPageToken("")
            .addAllFleetPackages(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListFleetPackagesPagedResponse pagedListResponse = client.listFleetPackages(parent);

    List<FleetPackage> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFleetPackagesList().get(0), resources.get(0));

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
  public void listFleetPackagesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listFleetPackages(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFleetPackagesTest2() throws Exception {
    FleetPackage responsesElement = FleetPackage.newBuilder().build();
    ListFleetPackagesResponse expectedResponse =
        ListFleetPackagesResponse.newBuilder()
            .setNextPageToken("")
            .addAllFleetPackages(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListFleetPackagesPagedResponse pagedListResponse = client.listFleetPackages(parent);

    List<FleetPackage> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFleetPackagesList().get(0), resources.get(0));

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
  public void listFleetPackagesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listFleetPackages(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFleetPackageTest() throws Exception {
    FleetPackage expectedResponse =
        FleetPackage.newBuilder()
            .setName(FleetPackageName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setResourceBundleSelector(FleetPackage.ResourceBundleSelector.newBuilder().build())
            .setTarget(FleetPackage.Target.newBuilder().build())
            .setRolloutStrategy(RolloutStrategy.newBuilder().build())
            .setVariantSelector(FleetPackage.VariantSelector.newBuilder().build())
            .setInfo(FleetPackageInfo.newBuilder().build())
            .setDeletionPropagationPolicy(DeletionPropagationPolicy.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    FleetPackageName name = FleetPackageName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]");

    FleetPackage actualResponse = client.getFleetPackage(name);
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
  public void getFleetPackageExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FleetPackageName name = FleetPackageName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]");
      client.getFleetPackage(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFleetPackageTest2() throws Exception {
    FleetPackage expectedResponse =
        FleetPackage.newBuilder()
            .setName(FleetPackageName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setResourceBundleSelector(FleetPackage.ResourceBundleSelector.newBuilder().build())
            .setTarget(FleetPackage.Target.newBuilder().build())
            .setRolloutStrategy(RolloutStrategy.newBuilder().build())
            .setVariantSelector(FleetPackage.VariantSelector.newBuilder().build())
            .setInfo(FleetPackageInfo.newBuilder().build())
            .setDeletionPropagationPolicy(DeletionPropagationPolicy.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-5919/locations/location-5919/fleetPackages/fleetPackage-5919";

    FleetPackage actualResponse = client.getFleetPackage(name);
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
  public void getFleetPackageExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-5919/locations/location-5919/fleetPackages/fleetPackage-5919";
      client.getFleetPackage(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createFleetPackageTest() throws Exception {
    FleetPackage expectedResponse =
        FleetPackage.newBuilder()
            .setName(FleetPackageName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setResourceBundleSelector(FleetPackage.ResourceBundleSelector.newBuilder().build())
            .setTarget(FleetPackage.Target.newBuilder().build())
            .setRolloutStrategy(RolloutStrategy.newBuilder().build())
            .setVariantSelector(FleetPackage.VariantSelector.newBuilder().build())
            .setInfo(FleetPackageInfo.newBuilder().build())
            .setDeletionPropagationPolicy(DeletionPropagationPolicy.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFleetPackageTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    FleetPackage fleetPackage = FleetPackage.newBuilder().build();
    String fleetPackageId = "fleetPackageId-115835309";

    FleetPackage actualResponse =
        client.createFleetPackageAsync(parent, fleetPackage, fleetPackageId).get();
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
  public void createFleetPackageExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      FleetPackage fleetPackage = FleetPackage.newBuilder().build();
      String fleetPackageId = "fleetPackageId-115835309";
      client.createFleetPackageAsync(parent, fleetPackage, fleetPackageId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createFleetPackageTest2() throws Exception {
    FleetPackage expectedResponse =
        FleetPackage.newBuilder()
            .setName(FleetPackageName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setResourceBundleSelector(FleetPackage.ResourceBundleSelector.newBuilder().build())
            .setTarget(FleetPackage.Target.newBuilder().build())
            .setRolloutStrategy(RolloutStrategy.newBuilder().build())
            .setVariantSelector(FleetPackage.VariantSelector.newBuilder().build())
            .setInfo(FleetPackageInfo.newBuilder().build())
            .setDeletionPropagationPolicy(DeletionPropagationPolicy.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFleetPackageTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    FleetPackage fleetPackage = FleetPackage.newBuilder().build();
    String fleetPackageId = "fleetPackageId-115835309";

    FleetPackage actualResponse =
        client.createFleetPackageAsync(parent, fleetPackage, fleetPackageId).get();
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
  public void createFleetPackageExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      FleetPackage fleetPackage = FleetPackage.newBuilder().build();
      String fleetPackageId = "fleetPackageId-115835309";
      client.createFleetPackageAsync(parent, fleetPackage, fleetPackageId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateFleetPackageTest() throws Exception {
    FleetPackage expectedResponse =
        FleetPackage.newBuilder()
            .setName(FleetPackageName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setResourceBundleSelector(FleetPackage.ResourceBundleSelector.newBuilder().build())
            .setTarget(FleetPackage.Target.newBuilder().build())
            .setRolloutStrategy(RolloutStrategy.newBuilder().build())
            .setVariantSelector(FleetPackage.VariantSelector.newBuilder().build())
            .setInfo(FleetPackageInfo.newBuilder().build())
            .setDeletionPropagationPolicy(DeletionPropagationPolicy.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateFleetPackageTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    FleetPackage fleetPackage =
        FleetPackage.newBuilder()
            .setName(FleetPackageName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setResourceBundleSelector(FleetPackage.ResourceBundleSelector.newBuilder().build())
            .setTarget(FleetPackage.Target.newBuilder().build())
            .setRolloutStrategy(RolloutStrategy.newBuilder().build())
            .setVariantSelector(FleetPackage.VariantSelector.newBuilder().build())
            .setInfo(FleetPackageInfo.newBuilder().build())
            .setDeletionPropagationPolicy(DeletionPropagationPolicy.forNumber(0))
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    FleetPackage actualResponse = client.updateFleetPackageAsync(fleetPackage, updateMask).get();
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
  public void updateFleetPackageExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FleetPackage fleetPackage =
          FleetPackage.newBuilder()
              .setName(FleetPackageName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]").toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setResourceBundleSelector(FleetPackage.ResourceBundleSelector.newBuilder().build())
              .setTarget(FleetPackage.Target.newBuilder().build())
              .setRolloutStrategy(RolloutStrategy.newBuilder().build())
              .setVariantSelector(FleetPackage.VariantSelector.newBuilder().build())
              .setInfo(FleetPackageInfo.newBuilder().build())
              .setDeletionPropagationPolicy(DeletionPropagationPolicy.forNumber(0))
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateFleetPackageAsync(fleetPackage, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteFleetPackageTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteFleetPackageTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    FleetPackageName name = FleetPackageName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]");

    client.deleteFleetPackageAsync(name).get();

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
  public void deleteFleetPackageExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FleetPackageName name = FleetPackageName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]");
      client.deleteFleetPackageAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteFleetPackageTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteFleetPackageTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-5919/locations/location-5919/fleetPackages/fleetPackage-5919";

    client.deleteFleetPackageAsync(name).get();

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
  public void deleteFleetPackageExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-5919/locations/location-5919/fleetPackages/fleetPackage-5919";
      client.deleteFleetPackageAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listReleasesTest() throws Exception {
    Release responsesElement = Release.newBuilder().build();
    ListReleasesResponse expectedResponse =
        ListReleasesResponse.newBuilder()
            .setNextPageToken("")
            .addAllReleases(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ResourceBundleName parent =
        ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]");

    ListReleasesPagedResponse pagedListResponse = client.listReleases(parent);

    List<Release> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReleasesList().get(0), resources.get(0));

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
  public void listReleasesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ResourceBundleName parent =
          ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]");
      client.listReleases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listReleasesTest2() throws Exception {
    Release responsesElement = Release.newBuilder().build();
    ListReleasesResponse expectedResponse =
        ListReleasesResponse.newBuilder()
            .setNextPageToken("")
            .addAllReleases(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-1464/locations/location-1464/resourceBundles/resourceBundle-1464";

    ListReleasesPagedResponse pagedListResponse = client.listReleases(parent);

    List<Release> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReleasesList().get(0), resources.get(0));

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
  public void listReleasesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-1464/locations/location-1464/resourceBundles/resourceBundle-1464";
      client.listReleases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getReleaseTest() throws Exception {
    Release expectedResponse =
        Release.newBuilder()
            .setName(
                ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setVersion("version351608024")
            .setPublishTime(Timestamp.newBuilder().build())
            .setInfo(ReleaseInfo.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ReleaseName name = ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]");

    Release actualResponse = client.getRelease(name);
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
  public void getReleaseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ReleaseName name =
          ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]");
      client.getRelease(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getReleaseTest2() throws Exception {
    Release expectedResponse =
        Release.newBuilder()
            .setName(
                ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setVersion("version351608024")
            .setPublishTime(Timestamp.newBuilder().build())
            .setInfo(ReleaseInfo.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9123/locations/location-9123/resourceBundles/resourceBundle-9123/releases/release-9123";

    Release actualResponse = client.getRelease(name);
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
  public void getReleaseExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9123/locations/location-9123/resourceBundles/resourceBundle-9123/releases/release-9123";
      client.getRelease(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createReleaseTest() throws Exception {
    Release expectedResponse =
        Release.newBuilder()
            .setName(
                ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setVersion("version351608024")
            .setPublishTime(Timestamp.newBuilder().build())
            .setInfo(ReleaseInfo.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createReleaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ResourceBundleName parent =
        ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]");
    Release release = Release.newBuilder().build();
    String releaseId = "releaseId89607042";

    Release actualResponse = client.createReleaseAsync(parent, release, releaseId).get();
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
  public void createReleaseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ResourceBundleName parent =
          ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]");
      Release release = Release.newBuilder().build();
      String releaseId = "releaseId89607042";
      client.createReleaseAsync(parent, release, releaseId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createReleaseTest2() throws Exception {
    Release expectedResponse =
        Release.newBuilder()
            .setName(
                ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setVersion("version351608024")
            .setPublishTime(Timestamp.newBuilder().build())
            .setInfo(ReleaseInfo.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createReleaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent =
        "projects/project-1464/locations/location-1464/resourceBundles/resourceBundle-1464";
    Release release = Release.newBuilder().build();
    String releaseId = "releaseId89607042";

    Release actualResponse = client.createReleaseAsync(parent, release, releaseId).get();
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
  public void createReleaseExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-1464/locations/location-1464/resourceBundles/resourceBundle-1464";
      Release release = Release.newBuilder().build();
      String releaseId = "releaseId89607042";
      client.createReleaseAsync(parent, release, releaseId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateReleaseTest() throws Exception {
    Release expectedResponse =
        Release.newBuilder()
            .setName(
                ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setVersion("version351608024")
            .setPublishTime(Timestamp.newBuilder().build())
            .setInfo(ReleaseInfo.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateReleaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Release release =
        Release.newBuilder()
            .setName(
                ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setVersion("version351608024")
            .setPublishTime(Timestamp.newBuilder().build())
            .setInfo(ReleaseInfo.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Release actualResponse = client.updateReleaseAsync(release, updateMask).get();
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
  public void updateReleaseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Release release =
          Release.newBuilder()
              .setName(
                  ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]")
                      .toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setVersion("version351608024")
              .setPublishTime(Timestamp.newBuilder().build())
              .setInfo(ReleaseInfo.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateReleaseAsync(release, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteReleaseTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteReleaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ReleaseName name = ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]");

    client.deleteReleaseAsync(name).get();

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
  public void deleteReleaseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ReleaseName name =
          ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]");
      client.deleteReleaseAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteReleaseTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteReleaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-9123/locations/location-9123/resourceBundles/resourceBundle-9123/releases/release-9123";

    client.deleteReleaseAsync(name).get();

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
  public void deleteReleaseExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9123/locations/location-9123/resourceBundles/resourceBundle-9123/releases/release-9123";
      client.deleteReleaseAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listVariantsTest() throws Exception {
    Variant responsesElement = Variant.newBuilder().build();
    ListVariantsResponse expectedResponse =
        ListVariantsResponse.newBuilder()
            .setNextPageToken("")
            .addAllVariants(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ReleaseName parent =
        ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]");

    ListVariantsPagedResponse pagedListResponse = client.listVariants(parent);

    List<Variant> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVariantsList().get(0), resources.get(0));

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
  public void listVariantsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ReleaseName parent =
          ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]");
      client.listVariants(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listVariantsTest2() throws Exception {
    Variant responsesElement = Variant.newBuilder().build();
    ListVariantsResponse expectedResponse =
        ListVariantsResponse.newBuilder()
            .setNextPageToken("")
            .addAllVariants(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-7922/locations/location-7922/resourceBundles/resourceBundle-7922/releases/release-7922";

    ListVariantsPagedResponse pagedListResponse = client.listVariants(parent);

    List<Variant> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVariantsList().get(0), resources.get(0));

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
  public void listVariantsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-7922/locations/location-7922/resourceBundles/resourceBundle-7922/releases/release-7922";
      client.listVariants(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVariantTest() throws Exception {
    Variant expectedResponse =
        Variant.newBuilder()
            .putAllLabels(new HashMap<String, String>())
            .addAllResources(new ArrayList<String>())
            .setName(
                VariantName.of(
                        "[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]", "[VARIANT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    VariantName name =
        VariantName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]", "[VARIANT]");

    Variant actualResponse = client.getVariant(name);
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
  public void getVariantExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      VariantName name =
          VariantName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]", "[VARIANT]");
      client.getVariant(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVariantTest2() throws Exception {
    Variant expectedResponse =
        Variant.newBuilder()
            .putAllLabels(new HashMap<String, String>())
            .addAllResources(new ArrayList<String>())
            .setName(
                VariantName.of(
                        "[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]", "[VARIANT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-8891/locations/location-8891/resourceBundles/resourceBundle-8891/releases/release-8891/variants/variant-8891";

    Variant actualResponse = client.getVariant(name);
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
  public void getVariantExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8891/locations/location-8891/resourceBundles/resourceBundle-8891/releases/release-8891/variants/variant-8891";
      client.getVariant(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createVariantTest() throws Exception {
    Variant expectedResponse =
        Variant.newBuilder()
            .putAllLabels(new HashMap<String, String>())
            .addAllResources(new ArrayList<String>())
            .setName(
                VariantName.of(
                        "[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]", "[VARIANT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createVariantTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ReleaseName parent =
        ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]");
    Variant variant = Variant.newBuilder().build();
    String variantId = "variantId-82113408";

    Variant actualResponse = client.createVariantAsync(parent, variant, variantId).get();
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
  public void createVariantExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ReleaseName parent =
          ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]");
      Variant variant = Variant.newBuilder().build();
      String variantId = "variantId-82113408";
      client.createVariantAsync(parent, variant, variantId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createVariantTest2() throws Exception {
    Variant expectedResponse =
        Variant.newBuilder()
            .putAllLabels(new HashMap<String, String>())
            .addAllResources(new ArrayList<String>())
            .setName(
                VariantName.of(
                        "[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]", "[VARIANT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createVariantTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent =
        "projects/project-7922/locations/location-7922/resourceBundles/resourceBundle-7922/releases/release-7922";
    Variant variant = Variant.newBuilder().build();
    String variantId = "variantId-82113408";

    Variant actualResponse = client.createVariantAsync(parent, variant, variantId).get();
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
  public void createVariantExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-7922/locations/location-7922/resourceBundles/resourceBundle-7922/releases/release-7922";
      Variant variant = Variant.newBuilder().build();
      String variantId = "variantId-82113408";
      client.createVariantAsync(parent, variant, variantId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateVariantTest() throws Exception {
    Variant expectedResponse =
        Variant.newBuilder()
            .putAllLabels(new HashMap<String, String>())
            .addAllResources(new ArrayList<String>())
            .setName(
                VariantName.of(
                        "[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]", "[VARIANT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateVariantTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Variant variant =
        Variant.newBuilder()
            .putAllLabels(new HashMap<String, String>())
            .addAllResources(new ArrayList<String>())
            .setName(
                VariantName.of(
                        "[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]", "[VARIANT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Variant actualResponse = client.updateVariantAsync(variant, updateMask).get();
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
  public void updateVariantExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Variant variant =
          Variant.newBuilder()
              .putAllLabels(new HashMap<String, String>())
              .addAllResources(new ArrayList<String>())
              .setName(
                  VariantName.of(
                          "[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]", "[VARIANT]")
                      .toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateVariantAsync(variant, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteVariantTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteVariantTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    VariantName name =
        VariantName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]", "[VARIANT]");

    client.deleteVariantAsync(name).get();

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
  public void deleteVariantExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      VariantName name =
          VariantName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]", "[VARIANT]");
      client.deleteVariantAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteVariantTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteVariantTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-8891/locations/location-8891/resourceBundles/resourceBundle-8891/releases/release-8891/variants/variant-8891";

    client.deleteVariantAsync(name).get();

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
  public void deleteVariantExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8891/locations/location-8891/resourceBundles/resourceBundle-8891/releases/release-8891/variants/variant-8891";
      client.deleteVariantAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listRolloutsTest() throws Exception {
    Rollout responsesElement = Rollout.newBuilder().build();
    ListRolloutsResponse expectedResponse =
        ListRolloutsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRollouts(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    FleetPackageName parent = FleetPackageName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]");

    ListRolloutsPagedResponse pagedListResponse = client.listRollouts(parent);

    List<Rollout> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRolloutsList().get(0), resources.get(0));

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
  public void listRolloutsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FleetPackageName parent = FleetPackageName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]");
      client.listRollouts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRolloutsTest2() throws Exception {
    Rollout responsesElement = Rollout.newBuilder().build();
    ListRolloutsResponse expectedResponse =
        ListRolloutsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRollouts(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5472/locations/location-5472/fleetPackages/fleetPackage-5472";

    ListRolloutsPagedResponse pagedListResponse = client.listRollouts(parent);

    List<Rollout> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRolloutsList().get(0), resources.get(0));

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
  public void listRolloutsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-5472/locations/location-5472/fleetPackages/fleetPackage-5472";
      client.listRollouts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRolloutTest() throws Exception {
    Rollout expectedResponse =
        Rollout.newBuilder()
            .setName(
                RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]")
                    .toString())
            .setRelease(
                ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]")
                    .toString())
            .setRolloutStrategy(RolloutStrategy.newBuilder().build())
            .setInfo(RolloutInfo.newBuilder().build())
            .setDeletionPropagationPolicy(DeletionPropagationPolicy.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    RolloutName name = RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]");

    Rollout actualResponse = client.getRollout(name);
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
  public void getRolloutExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RolloutName name = RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]");
      client.getRollout(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRolloutTest2() throws Exception {
    Rollout expectedResponse =
        Rollout.newBuilder()
            .setName(
                RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]")
                    .toString())
            .setRelease(
                ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]")
                    .toString())
            .setRolloutStrategy(RolloutStrategy.newBuilder().build())
            .setInfo(RolloutInfo.newBuilder().build())
            .setDeletionPropagationPolicy(DeletionPropagationPolicy.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1349/locations/location-1349/fleetPackages/fleetPackage-1349/rollouts/rollout-1349";

    Rollout actualResponse = client.getRollout(name);
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
  public void getRolloutExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1349/locations/location-1349/fleetPackages/fleetPackage-1349/rollouts/rollout-1349";
      client.getRollout(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void suspendRolloutTest() throws Exception {
    Rollout expectedResponse =
        Rollout.newBuilder()
            .setName(
                RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]")
                    .toString())
            .setRelease(
                ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]")
                    .toString())
            .setRolloutStrategy(RolloutStrategy.newBuilder().build())
            .setInfo(RolloutInfo.newBuilder().build())
            .setDeletionPropagationPolicy(DeletionPropagationPolicy.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("suspendRolloutTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    RolloutName name = RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]");

    Rollout actualResponse = client.suspendRolloutAsync(name).get();
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
  public void suspendRolloutExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RolloutName name = RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]");
      client.suspendRolloutAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void suspendRolloutTest2() throws Exception {
    Rollout expectedResponse =
        Rollout.newBuilder()
            .setName(
                RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]")
                    .toString())
            .setRelease(
                ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]")
                    .toString())
            .setRolloutStrategy(RolloutStrategy.newBuilder().build())
            .setInfo(RolloutInfo.newBuilder().build())
            .setDeletionPropagationPolicy(DeletionPropagationPolicy.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("suspendRolloutTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-1349/locations/location-1349/fleetPackages/fleetPackage-1349/rollouts/rollout-1349";

    Rollout actualResponse = client.suspendRolloutAsync(name).get();
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
  public void suspendRolloutExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1349/locations/location-1349/fleetPackages/fleetPackage-1349/rollouts/rollout-1349";
      client.suspendRolloutAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void resumeRolloutTest() throws Exception {
    Rollout expectedResponse =
        Rollout.newBuilder()
            .setName(
                RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]")
                    .toString())
            .setRelease(
                ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]")
                    .toString())
            .setRolloutStrategy(RolloutStrategy.newBuilder().build())
            .setInfo(RolloutInfo.newBuilder().build())
            .setDeletionPropagationPolicy(DeletionPropagationPolicy.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("resumeRolloutTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    RolloutName name = RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]");

    Rollout actualResponse = client.resumeRolloutAsync(name).get();
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
  public void resumeRolloutExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RolloutName name = RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]");
      client.resumeRolloutAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void resumeRolloutTest2() throws Exception {
    Rollout expectedResponse =
        Rollout.newBuilder()
            .setName(
                RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]")
                    .toString())
            .setRelease(
                ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]")
                    .toString())
            .setRolloutStrategy(RolloutStrategy.newBuilder().build())
            .setInfo(RolloutInfo.newBuilder().build())
            .setDeletionPropagationPolicy(DeletionPropagationPolicy.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("resumeRolloutTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-1349/locations/location-1349/fleetPackages/fleetPackage-1349/rollouts/rollout-1349";

    Rollout actualResponse = client.resumeRolloutAsync(name).get();
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
  public void resumeRolloutExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1349/locations/location-1349/fleetPackages/fleetPackage-1349/rollouts/rollout-1349";
      client.resumeRolloutAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void abortRolloutTest() throws Exception {
    Rollout expectedResponse =
        Rollout.newBuilder()
            .setName(
                RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]")
                    .toString())
            .setRelease(
                ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]")
                    .toString())
            .setRolloutStrategy(RolloutStrategy.newBuilder().build())
            .setInfo(RolloutInfo.newBuilder().build())
            .setDeletionPropagationPolicy(DeletionPropagationPolicy.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("abortRolloutTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    RolloutName name = RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]");

    Rollout actualResponse = client.abortRolloutAsync(name).get();
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
  public void abortRolloutExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RolloutName name = RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]");
      client.abortRolloutAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void abortRolloutTest2() throws Exception {
    Rollout expectedResponse =
        Rollout.newBuilder()
            .setName(
                RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]")
                    .toString())
            .setRelease(
                ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]")
                    .toString())
            .setRolloutStrategy(RolloutStrategy.newBuilder().build())
            .setInfo(RolloutInfo.newBuilder().build())
            .setDeletionPropagationPolicy(DeletionPropagationPolicy.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("abortRolloutTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-1349/locations/location-1349/fleetPackages/fleetPackage-1349/rollouts/rollout-1349";

    Rollout actualResponse = client.abortRolloutAsync(name).get();
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
  public void abortRolloutExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1349/locations/location-1349/fleetPackages/fleetPackage-1349/rollouts/rollout-1349";
      client.abortRolloutAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("projects/project-3664")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

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
  public void listLocationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("projects/project-3664")
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
    mockService.addResponse(expectedResponse);

    GetLocationRequest request =
        GetLocationRequest.newBuilder()
            .setName("projects/project-9062/locations/location-9062")
            .build();

    Location actualResponse = client.getLocation(request);
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
  public void getLocationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetLocationRequest request =
          GetLocationRequest.newBuilder()
              .setName("projects/project-9062/locations/location-9062")
              .build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
