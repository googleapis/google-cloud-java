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

package com.google.cloud.configdelivery.v1beta;

import static com.google.cloud.configdelivery.v1beta.ConfigDeliveryClient.ListFleetPackagesPagedResponse;
import static com.google.cloud.configdelivery.v1beta.ConfigDeliveryClient.ListLocationsPagedResponse;
import static com.google.cloud.configdelivery.v1beta.ConfigDeliveryClient.ListReleasesPagedResponse;
import static com.google.cloud.configdelivery.v1beta.ConfigDeliveryClient.ListResourceBundlesPagedResponse;
import static com.google.cloud.configdelivery.v1beta.ConfigDeliveryClient.ListRolloutsPagedResponse;
import static com.google.cloud.configdelivery.v1beta.ConfigDeliveryClient.ListVariantsPagedResponse;

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
import com.google.protobuf.Timestamp;
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
public class ConfigDeliveryClientTest {
  private static MockConfigDelivery mockConfigDelivery;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ConfigDeliveryClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockConfigDelivery = new MockConfigDelivery();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockConfigDelivery, mockLocations));
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
    ConfigDeliverySettings settings =
        ConfigDeliverySettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ConfigDeliveryClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listResourceBundlesTest() throws Exception {
    ResourceBundle responsesElement = ResourceBundle.newBuilder().build();
    ListResourceBundlesResponse expectedResponse =
        ListResourceBundlesResponse.newBuilder()
            .setNextPageToken("")
            .addAllResourceBundles(Arrays.asList(responsesElement))
            .build();
    mockConfigDelivery.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListResourceBundlesPagedResponse pagedListResponse = client.listResourceBundles(parent);

    List<ResourceBundle> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResourceBundlesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListResourceBundlesRequest actualRequest = ((ListResourceBundlesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listResourceBundlesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

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
    mockConfigDelivery.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListResourceBundlesPagedResponse pagedListResponse = client.listResourceBundles(parent);

    List<ResourceBundle> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResourceBundlesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListResourceBundlesRequest actualRequest = ((ListResourceBundlesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listResourceBundlesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockConfigDelivery.addResponse(expectedResponse);

    ResourceBundleName name = ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]");

    ResourceBundle actualResponse = client.getResourceBundle(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetResourceBundleRequest actualRequest = ((GetResourceBundleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getResourceBundleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

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
    mockConfigDelivery.addResponse(expectedResponse);

    String name = "name3373707";

    ResourceBundle actualResponse = client.getResourceBundle(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetResourceBundleRequest actualRequest = ((GetResourceBundleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getResourceBundleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      String name = "name3373707";
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
    mockConfigDelivery.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ResourceBundle resourceBundle = ResourceBundle.newBuilder().build();
    String resourceBundleId = "resourceBundleId1209359211";

    ResourceBundle actualResponse =
        client.createResourceBundleAsync(parent, resourceBundle, resourceBundleId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateResourceBundleRequest actualRequest =
        ((CreateResourceBundleRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(resourceBundle, actualRequest.getResourceBundle());
    Assert.assertEquals(resourceBundleId, actualRequest.getResourceBundleId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createResourceBundleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ResourceBundle resourceBundle = ResourceBundle.newBuilder().build();
      String resourceBundleId = "resourceBundleId1209359211";
      client.createResourceBundleAsync(parent, resourceBundle, resourceBundleId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfigDelivery.addResponse(resultOperation);

    String parent = "parent-995424086";
    ResourceBundle resourceBundle = ResourceBundle.newBuilder().build();
    String resourceBundleId = "resourceBundleId1209359211";

    ResourceBundle actualResponse =
        client.createResourceBundleAsync(parent, resourceBundle, resourceBundleId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateResourceBundleRequest actualRequest =
        ((CreateResourceBundleRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(resourceBundle, actualRequest.getResourceBundle());
    Assert.assertEquals(resourceBundleId, actualRequest.getResourceBundleId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createResourceBundleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      String parent = "parent-995424086";
      ResourceBundle resourceBundle = ResourceBundle.newBuilder().build();
      String resourceBundleId = "resourceBundleId1209359211";
      client.createResourceBundleAsync(parent, resourceBundle, resourceBundleId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfigDelivery.addResponse(resultOperation);

    ResourceBundle resourceBundle = ResourceBundle.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ResourceBundle actualResponse =
        client.updateResourceBundleAsync(resourceBundle, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateResourceBundleRequest actualRequest =
        ((UpdateResourceBundleRequest) actualRequests.get(0));

    Assert.assertEquals(resourceBundle, actualRequest.getResourceBundle());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateResourceBundleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      ResourceBundle resourceBundle = ResourceBundle.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateResourceBundleAsync(resourceBundle, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfigDelivery.addResponse(resultOperation);

    ResourceBundleName name = ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]");

    client.deleteResourceBundleAsync(name).get();

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteResourceBundleRequest actualRequest =
        ((DeleteResourceBundleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteResourceBundleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      ResourceBundleName name =
          ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]");
      client.deleteResourceBundleAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfigDelivery.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteResourceBundleAsync(name).get();

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteResourceBundleRequest actualRequest =
        ((DeleteResourceBundleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteResourceBundleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      String name = "name3373707";
      client.deleteResourceBundleAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfigDelivery.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListFleetPackagesPagedResponse pagedListResponse = client.listFleetPackages(parent);

    List<FleetPackage> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFleetPackagesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFleetPackagesRequest actualRequest = ((ListFleetPackagesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFleetPackagesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

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
    mockConfigDelivery.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListFleetPackagesPagedResponse pagedListResponse = client.listFleetPackages(parent);

    List<FleetPackage> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFleetPackagesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFleetPackagesRequest actualRequest = ((ListFleetPackagesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFleetPackagesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockConfigDelivery.addResponse(expectedResponse);

    FleetPackageName name = FleetPackageName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]");

    FleetPackage actualResponse = client.getFleetPackage(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFleetPackageRequest actualRequest = ((GetFleetPackageRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFleetPackageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

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
    mockConfigDelivery.addResponse(expectedResponse);

    String name = "name3373707";

    FleetPackage actualResponse = client.getFleetPackage(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFleetPackageRequest actualRequest = ((GetFleetPackageRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFleetPackageExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      String name = "name3373707";
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
    mockConfigDelivery.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    FleetPackage fleetPackage = FleetPackage.newBuilder().build();
    String fleetPackageId = "fleetPackageId-115835309";

    FleetPackage actualResponse =
        client.createFleetPackageAsync(parent, fleetPackage, fleetPackageId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFleetPackageRequest actualRequest = ((CreateFleetPackageRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(fleetPackage, actualRequest.getFleetPackage());
    Assert.assertEquals(fleetPackageId, actualRequest.getFleetPackageId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFleetPackageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      FleetPackage fleetPackage = FleetPackage.newBuilder().build();
      String fleetPackageId = "fleetPackageId-115835309";
      client.createFleetPackageAsync(parent, fleetPackage, fleetPackageId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfigDelivery.addResponse(resultOperation);

    String parent = "parent-995424086";
    FleetPackage fleetPackage = FleetPackage.newBuilder().build();
    String fleetPackageId = "fleetPackageId-115835309";

    FleetPackage actualResponse =
        client.createFleetPackageAsync(parent, fleetPackage, fleetPackageId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFleetPackageRequest actualRequest = ((CreateFleetPackageRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(fleetPackage, actualRequest.getFleetPackage());
    Assert.assertEquals(fleetPackageId, actualRequest.getFleetPackageId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFleetPackageExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      String parent = "parent-995424086";
      FleetPackage fleetPackage = FleetPackage.newBuilder().build();
      String fleetPackageId = "fleetPackageId-115835309";
      client.createFleetPackageAsync(parent, fleetPackage, fleetPackageId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfigDelivery.addResponse(resultOperation);

    FleetPackage fleetPackage = FleetPackage.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    FleetPackage actualResponse = client.updateFleetPackageAsync(fleetPackage, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateFleetPackageRequest actualRequest = ((UpdateFleetPackageRequest) actualRequests.get(0));

    Assert.assertEquals(fleetPackage, actualRequest.getFleetPackage());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateFleetPackageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      FleetPackage fleetPackage = FleetPackage.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateFleetPackageAsync(fleetPackage, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfigDelivery.addResponse(resultOperation);

    FleetPackageName name = FleetPackageName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]");

    client.deleteFleetPackageAsync(name).get();

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFleetPackageRequest actualRequest = ((DeleteFleetPackageRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFleetPackageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      FleetPackageName name = FleetPackageName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]");
      client.deleteFleetPackageAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfigDelivery.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteFleetPackageAsync(name).get();

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFleetPackageRequest actualRequest = ((DeleteFleetPackageRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFleetPackageExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      String name = "name3373707";
      client.deleteFleetPackageAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfigDelivery.addResponse(expectedResponse);

    ResourceBundleName parent =
        ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]");

    ListReleasesPagedResponse pagedListResponse = client.listReleases(parent);

    List<Release> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReleasesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListReleasesRequest actualRequest = ((ListReleasesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listReleasesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

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
    mockConfigDelivery.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListReleasesPagedResponse pagedListResponse = client.listReleases(parent);

    List<Release> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReleasesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListReleasesRequest actualRequest = ((ListReleasesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listReleasesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockConfigDelivery.addResponse(expectedResponse);

    ReleaseName name = ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]");

    Release actualResponse = client.getRelease(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetReleaseRequest actualRequest = ((GetReleaseRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getReleaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

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
    mockConfigDelivery.addResponse(expectedResponse);

    String name = "name3373707";

    Release actualResponse = client.getRelease(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetReleaseRequest actualRequest = ((GetReleaseRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getReleaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      String name = "name3373707";
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
    mockConfigDelivery.addResponse(resultOperation);

    ResourceBundleName parent =
        ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]");
    Release release = Release.newBuilder().build();
    String releaseId = "releaseId89607042";

    Release actualResponse = client.createReleaseAsync(parent, release, releaseId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateReleaseRequest actualRequest = ((CreateReleaseRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(release, actualRequest.getRelease());
    Assert.assertEquals(releaseId, actualRequest.getReleaseId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createReleaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      ResourceBundleName parent =
          ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]");
      Release release = Release.newBuilder().build();
      String releaseId = "releaseId89607042";
      client.createReleaseAsync(parent, release, releaseId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfigDelivery.addResponse(resultOperation);

    String parent = "parent-995424086";
    Release release = Release.newBuilder().build();
    String releaseId = "releaseId89607042";

    Release actualResponse = client.createReleaseAsync(parent, release, releaseId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateReleaseRequest actualRequest = ((CreateReleaseRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(release, actualRequest.getRelease());
    Assert.assertEquals(releaseId, actualRequest.getReleaseId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createReleaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      String parent = "parent-995424086";
      Release release = Release.newBuilder().build();
      String releaseId = "releaseId89607042";
      client.createReleaseAsync(parent, release, releaseId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfigDelivery.addResponse(resultOperation);

    Release release = Release.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Release actualResponse = client.updateReleaseAsync(release, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateReleaseRequest actualRequest = ((UpdateReleaseRequest) actualRequests.get(0));

    Assert.assertEquals(release, actualRequest.getRelease());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateReleaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      Release release = Release.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateReleaseAsync(release, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfigDelivery.addResponse(resultOperation);

    ReleaseName name = ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]");

    client.deleteReleaseAsync(name).get();

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteReleaseRequest actualRequest = ((DeleteReleaseRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteReleaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      ReleaseName name =
          ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]");
      client.deleteReleaseAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfigDelivery.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteReleaseAsync(name).get();

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteReleaseRequest actualRequest = ((DeleteReleaseRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteReleaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      String name = "name3373707";
      client.deleteReleaseAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfigDelivery.addResponse(expectedResponse);

    ReleaseName parent =
        ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]");

    ListVariantsPagedResponse pagedListResponse = client.listVariants(parent);

    List<Variant> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVariantsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListVariantsRequest actualRequest = ((ListVariantsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listVariantsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

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
    mockConfigDelivery.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListVariantsPagedResponse pagedListResponse = client.listVariants(parent);

    List<Variant> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVariantsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListVariantsRequest actualRequest = ((ListVariantsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listVariantsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockConfigDelivery.addResponse(expectedResponse);

    VariantName name =
        VariantName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]", "[VARIANT]");

    Variant actualResponse = client.getVariant(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVariantRequest actualRequest = ((GetVariantRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVariantExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

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
    mockConfigDelivery.addResponse(expectedResponse);

    String name = "name3373707";

    Variant actualResponse = client.getVariant(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVariantRequest actualRequest = ((GetVariantRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVariantExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      String name = "name3373707";
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
    mockConfigDelivery.addResponse(resultOperation);

    ReleaseName parent =
        ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]");
    Variant variant = Variant.newBuilder().build();
    String variantId = "variantId-82113408";

    Variant actualResponse = client.createVariantAsync(parent, variant, variantId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateVariantRequest actualRequest = ((CreateVariantRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(variant, actualRequest.getVariant());
    Assert.assertEquals(variantId, actualRequest.getVariantId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createVariantExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      ReleaseName parent =
          ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]");
      Variant variant = Variant.newBuilder().build();
      String variantId = "variantId-82113408";
      client.createVariantAsync(parent, variant, variantId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfigDelivery.addResponse(resultOperation);

    String parent = "parent-995424086";
    Variant variant = Variant.newBuilder().build();
    String variantId = "variantId-82113408";

    Variant actualResponse = client.createVariantAsync(parent, variant, variantId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateVariantRequest actualRequest = ((CreateVariantRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(variant, actualRequest.getVariant());
    Assert.assertEquals(variantId, actualRequest.getVariantId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createVariantExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      String parent = "parent-995424086";
      Variant variant = Variant.newBuilder().build();
      String variantId = "variantId-82113408";
      client.createVariantAsync(parent, variant, variantId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfigDelivery.addResponse(resultOperation);

    Variant variant = Variant.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Variant actualResponse = client.updateVariantAsync(variant, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateVariantRequest actualRequest = ((UpdateVariantRequest) actualRequests.get(0));

    Assert.assertEquals(variant, actualRequest.getVariant());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateVariantExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      Variant variant = Variant.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateVariantAsync(variant, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfigDelivery.addResponse(resultOperation);

    VariantName name =
        VariantName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]", "[VARIANT]");

    client.deleteVariantAsync(name).get();

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteVariantRequest actualRequest = ((DeleteVariantRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteVariantExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      VariantName name =
          VariantName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]", "[VARIANT]");
      client.deleteVariantAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfigDelivery.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteVariantAsync(name).get();

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteVariantRequest actualRequest = ((DeleteVariantRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteVariantExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      String name = "name3373707";
      client.deleteVariantAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfigDelivery.addResponse(expectedResponse);

    FleetPackageName parent = FleetPackageName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]");

    ListRolloutsPagedResponse pagedListResponse = client.listRollouts(parent);

    List<Rollout> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRolloutsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRolloutsRequest actualRequest = ((ListRolloutsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRolloutsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

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
    mockConfigDelivery.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRolloutsPagedResponse pagedListResponse = client.listRollouts(parent);

    List<Rollout> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRolloutsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRolloutsRequest actualRequest = ((ListRolloutsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRolloutsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockConfigDelivery.addResponse(expectedResponse);

    RolloutName name = RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]");

    Rollout actualResponse = client.getRollout(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRolloutRequest actualRequest = ((GetRolloutRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRolloutExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

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
    mockConfigDelivery.addResponse(expectedResponse);

    String name = "name3373707";

    Rollout actualResponse = client.getRollout(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRolloutRequest actualRequest = ((GetRolloutRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRolloutExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      String name = "name3373707";
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
    mockConfigDelivery.addResponse(resultOperation);

    RolloutName name = RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]");

    Rollout actualResponse = client.suspendRolloutAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SuspendRolloutRequest actualRequest = ((SuspendRolloutRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void suspendRolloutExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      RolloutName name = RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]");
      client.suspendRolloutAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfigDelivery.addResponse(resultOperation);

    String name = "name3373707";

    Rollout actualResponse = client.suspendRolloutAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SuspendRolloutRequest actualRequest = ((SuspendRolloutRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void suspendRolloutExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      String name = "name3373707";
      client.suspendRolloutAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfigDelivery.addResponse(resultOperation);

    RolloutName name = RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]");

    Rollout actualResponse = client.resumeRolloutAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResumeRolloutRequest actualRequest = ((ResumeRolloutRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resumeRolloutExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      RolloutName name = RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]");
      client.resumeRolloutAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfigDelivery.addResponse(resultOperation);

    String name = "name3373707";

    Rollout actualResponse = client.resumeRolloutAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResumeRolloutRequest actualRequest = ((ResumeRolloutRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resumeRolloutExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      String name = "name3373707";
      client.resumeRolloutAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfigDelivery.addResponse(resultOperation);

    RolloutName name = RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]");

    Rollout actualResponse = client.abortRolloutAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AbortRolloutRequest actualRequest = ((AbortRolloutRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void abortRolloutExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      RolloutName name = RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]");
      client.abortRolloutAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfigDelivery.addResponse(resultOperation);

    String name = "name3373707";

    Rollout actualResponse = client.abortRolloutAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigDelivery.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AbortRolloutRequest actualRequest = ((AbortRolloutRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void abortRolloutExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigDelivery.addException(exception);

    try {
      String name = "name3373707";
      client.abortRolloutAsync(name).get();
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
