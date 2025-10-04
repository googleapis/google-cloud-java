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

package com.google.cloud.licensemanager.v1;

import static com.google.cloud.licensemanager.v1.LicenseManagerClient.AggregateUsagePagedResponse;
import static com.google.cloud.licensemanager.v1.LicenseManagerClient.ListConfigurationsPagedResponse;
import static com.google.cloud.licensemanager.v1.LicenseManagerClient.ListInstancesPagedResponse;
import static com.google.cloud.licensemanager.v1.LicenseManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.licensemanager.v1.LicenseManagerClient.ListProductsPagedResponse;

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
public class LicenseManagerClientTest {
  private static MockLicenseManager mockLicenseManager;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private LicenseManagerClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockLicenseManager = new MockLicenseManager();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockLicenseManager, mockLocations));
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
    LicenseManagerSettings settings =
        LicenseManagerSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = LicenseManagerClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listConfigurationsTest() throws Exception {
    Configuration responsesElement = Configuration.newBuilder().build();
    ListConfigurationsResponse expectedResponse =
        ListConfigurationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllConfigurations(Arrays.asList(responsesElement))
            .build();
    mockLicenseManager.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListConfigurationsPagedResponse pagedListResponse = client.listConfigurations(parent);

    List<Configuration> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConfigurationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLicenseManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConfigurationsRequest actualRequest = ((ListConfigurationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConfigurationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseManager.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listConfigurations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConfigurationsTest2() throws Exception {
    Configuration responsesElement = Configuration.newBuilder().build();
    ListConfigurationsResponse expectedResponse =
        ListConfigurationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllConfigurations(Arrays.asList(responsesElement))
            .build();
    mockLicenseManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListConfigurationsPagedResponse pagedListResponse = client.listConfigurations(parent);

    List<Configuration> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConfigurationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLicenseManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConfigurationsRequest actualRequest = ((ListConfigurationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConfigurationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseManager.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listConfigurations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConfigurationTest() throws Exception {
    Configuration expectedResponse =
        Configuration.newBuilder()
            .setName(ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]").toString())
            .setDisplayName("displayName1714148973")
            .setProduct(ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString())
            .setLicenseType(LicenseType.forNumber(0))
            .setCurrentBillingInfo(BillingInfo.newBuilder().build())
            .setNextBillingInfo(BillingInfo.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockLicenseManager.addResponse(expectedResponse);

    ConfigurationName name = ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]");

    Configuration actualResponse = client.getConfiguration(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLicenseManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConfigurationRequest actualRequest = ((GetConfigurationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConfigurationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseManager.addException(exception);

    try {
      ConfigurationName name = ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]");
      client.getConfiguration(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConfigurationTest2() throws Exception {
    Configuration expectedResponse =
        Configuration.newBuilder()
            .setName(ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]").toString())
            .setDisplayName("displayName1714148973")
            .setProduct(ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString())
            .setLicenseType(LicenseType.forNumber(0))
            .setCurrentBillingInfo(BillingInfo.newBuilder().build())
            .setNextBillingInfo(BillingInfo.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockLicenseManager.addResponse(expectedResponse);

    String name = "name3373707";

    Configuration actualResponse = client.getConfiguration(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLicenseManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConfigurationRequest actualRequest = ((GetConfigurationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConfigurationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseManager.addException(exception);

    try {
      String name = "name3373707";
      client.getConfiguration(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createConfigurationTest() throws Exception {
    Configuration expectedResponse =
        Configuration.newBuilder()
            .setName(ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]").toString())
            .setDisplayName("displayName1714148973")
            .setProduct(ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString())
            .setLicenseType(LicenseType.forNumber(0))
            .setCurrentBillingInfo(BillingInfo.newBuilder().build())
            .setNextBillingInfo(BillingInfo.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createConfigurationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLicenseManager.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Configuration configuration = Configuration.newBuilder().build();
    String configurationId = "configurationId1948915889";

    Configuration actualResponse =
        client.createConfigurationAsync(parent, configuration, configurationId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLicenseManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConfigurationRequest actualRequest = ((CreateConfigurationRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(configuration, actualRequest.getConfiguration());
    Assert.assertEquals(configurationId, actualRequest.getConfigurationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createConfigurationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseManager.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Configuration configuration = Configuration.newBuilder().build();
      String configurationId = "configurationId1948915889";
      client.createConfigurationAsync(parent, configuration, configurationId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createConfigurationTest2() throws Exception {
    Configuration expectedResponse =
        Configuration.newBuilder()
            .setName(ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]").toString())
            .setDisplayName("displayName1714148973")
            .setProduct(ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString())
            .setLicenseType(LicenseType.forNumber(0))
            .setCurrentBillingInfo(BillingInfo.newBuilder().build())
            .setNextBillingInfo(BillingInfo.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createConfigurationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLicenseManager.addResponse(resultOperation);

    String parent = "parent-995424086";
    Configuration configuration = Configuration.newBuilder().build();
    String configurationId = "configurationId1948915889";

    Configuration actualResponse =
        client.createConfigurationAsync(parent, configuration, configurationId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLicenseManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConfigurationRequest actualRequest = ((CreateConfigurationRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(configuration, actualRequest.getConfiguration());
    Assert.assertEquals(configurationId, actualRequest.getConfigurationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createConfigurationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseManager.addException(exception);

    try {
      String parent = "parent-995424086";
      Configuration configuration = Configuration.newBuilder().build();
      String configurationId = "configurationId1948915889";
      client.createConfigurationAsync(parent, configuration, configurationId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateConfigurationTest() throws Exception {
    Configuration expectedResponse =
        Configuration.newBuilder()
            .setName(ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]").toString())
            .setDisplayName("displayName1714148973")
            .setProduct(ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString())
            .setLicenseType(LicenseType.forNumber(0))
            .setCurrentBillingInfo(BillingInfo.newBuilder().build())
            .setNextBillingInfo(BillingInfo.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateConfigurationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLicenseManager.addResponse(resultOperation);

    Configuration configuration = Configuration.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Configuration actualResponse = client.updateConfigurationAsync(configuration, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLicenseManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateConfigurationRequest actualRequest = ((UpdateConfigurationRequest) actualRequests.get(0));

    Assert.assertEquals(configuration, actualRequest.getConfiguration());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateConfigurationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseManager.addException(exception);

    try {
      Configuration configuration = Configuration.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateConfigurationAsync(configuration, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteConfigurationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteConfigurationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLicenseManager.addResponse(resultOperation);

    ConfigurationName name = ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]");

    client.deleteConfigurationAsync(name).get();

    List<AbstractMessage> actualRequests = mockLicenseManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteConfigurationRequest actualRequest = ((DeleteConfigurationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteConfigurationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseManager.addException(exception);

    try {
      ConfigurationName name = ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]");
      client.deleteConfigurationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteConfigurationTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteConfigurationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLicenseManager.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteConfigurationAsync(name).get();

    List<AbstractMessage> actualRequests = mockLicenseManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteConfigurationRequest actualRequest = ((DeleteConfigurationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteConfigurationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseManager.addException(exception);

    try {
      String name = "name3373707";
      client.deleteConfigurationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listInstancesTest() throws Exception {
    Instance responsesElement = Instance.newBuilder().build();
    ListInstancesResponse expectedResponse =
        ListInstancesResponse.newBuilder()
            .setNextPageToken("")
            .addAllInstances(Arrays.asList(responsesElement))
            .build();
    mockLicenseManager.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListInstancesPagedResponse pagedListResponse = client.listInstances(parent);

    List<Instance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstancesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLicenseManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInstancesRequest actualRequest = ((ListInstancesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInstancesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseManager.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listInstances(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInstancesTest2() throws Exception {
    Instance responsesElement = Instance.newBuilder().build();
    ListInstancesResponse expectedResponse =
        ListInstancesResponse.newBuilder()
            .setNextPageToken("")
            .addAllInstances(Arrays.asList(responsesElement))
            .build();
    mockLicenseManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListInstancesPagedResponse pagedListResponse = client.listInstances(parent);

    List<Instance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstancesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLicenseManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInstancesRequest actualRequest = ((ListInstancesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInstancesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseManager.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listInstances(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setRegion("region-934795532")
            .putAllProductActivation(new HashMap<String, ActivationState>())
            .setLicenseVersionId("licenseVersionId748496082")
            .setComputeInstance("computeInstance-62629396")
            .build();
    mockLicenseManager.addResponse(expectedResponse);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    Instance actualResponse = client.getInstance(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLicenseManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInstanceRequest actualRequest = ((GetInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseManager.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.getInstance(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInstanceTest2() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setRegion("region-934795532")
            .putAllProductActivation(new HashMap<String, ActivationState>())
            .setLicenseVersionId("licenseVersionId748496082")
            .setComputeInstance("computeInstance-62629396")
            .build();
    mockLicenseManager.addResponse(expectedResponse);

    String name = "name3373707";

    Instance actualResponse = client.getInstance(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLicenseManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInstanceRequest actualRequest = ((GetInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInstanceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseManager.addException(exception);

    try {
      String name = "name3373707";
      client.getInstance(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deactivateConfigurationTest() throws Exception {
    Configuration expectedResponse =
        Configuration.newBuilder()
            .setName(ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]").toString())
            .setDisplayName("displayName1714148973")
            .setProduct(ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString())
            .setLicenseType(LicenseType.forNumber(0))
            .setCurrentBillingInfo(BillingInfo.newBuilder().build())
            .setNextBillingInfo(BillingInfo.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deactivateConfigurationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLicenseManager.addResponse(resultOperation);

    ConfigurationName name = ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]");

    Configuration actualResponse = client.deactivateConfigurationAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLicenseManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeactivateConfigurationRequest actualRequest =
        ((DeactivateConfigurationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deactivateConfigurationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseManager.addException(exception);

    try {
      ConfigurationName name = ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]");
      client.deactivateConfigurationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deactivateConfigurationTest2() throws Exception {
    Configuration expectedResponse =
        Configuration.newBuilder()
            .setName(ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]").toString())
            .setDisplayName("displayName1714148973")
            .setProduct(ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString())
            .setLicenseType(LicenseType.forNumber(0))
            .setCurrentBillingInfo(BillingInfo.newBuilder().build())
            .setNextBillingInfo(BillingInfo.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deactivateConfigurationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLicenseManager.addResponse(resultOperation);

    String name = "name3373707";

    Configuration actualResponse = client.deactivateConfigurationAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLicenseManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeactivateConfigurationRequest actualRequest =
        ((DeactivateConfigurationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deactivateConfigurationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseManager.addException(exception);

    try {
      String name = "name3373707";
      client.deactivateConfigurationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void reactivateConfigurationTest() throws Exception {
    Configuration expectedResponse =
        Configuration.newBuilder()
            .setName(ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]").toString())
            .setDisplayName("displayName1714148973")
            .setProduct(ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString())
            .setLicenseType(LicenseType.forNumber(0))
            .setCurrentBillingInfo(BillingInfo.newBuilder().build())
            .setNextBillingInfo(BillingInfo.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("reactivateConfigurationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLicenseManager.addResponse(resultOperation);

    ConfigurationName name = ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]");

    Configuration actualResponse = client.reactivateConfigurationAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLicenseManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReactivateConfigurationRequest actualRequest =
        ((ReactivateConfigurationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void reactivateConfigurationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseManager.addException(exception);

    try {
      ConfigurationName name = ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]");
      client.reactivateConfigurationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void reactivateConfigurationTest2() throws Exception {
    Configuration expectedResponse =
        Configuration.newBuilder()
            .setName(ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]").toString())
            .setDisplayName("displayName1714148973")
            .setProduct(ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString())
            .setLicenseType(LicenseType.forNumber(0))
            .setCurrentBillingInfo(BillingInfo.newBuilder().build())
            .setNextBillingInfo(BillingInfo.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("reactivateConfigurationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLicenseManager.addResponse(resultOperation);

    String name = "name3373707";

    Configuration actualResponse = client.reactivateConfigurationAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLicenseManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReactivateConfigurationRequest actualRequest =
        ((ReactivateConfigurationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void reactivateConfigurationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseManager.addException(exception);

    try {
      String name = "name3373707";
      client.reactivateConfigurationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void queryConfigurationLicenseUsageTest() throws Exception {
    QueryConfigurationLicenseUsageResponse expectedResponse =
        QueryConfigurationLicenseUsageResponse.newBuilder().build();
    mockLicenseManager.addResponse(expectedResponse);

    ConfigurationName name = ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]");
    Timestamp startTime = Timestamp.newBuilder().build();
    Timestamp endTime = Timestamp.newBuilder().build();

    QueryConfigurationLicenseUsageResponse actualResponse =
        client.queryConfigurationLicenseUsage(name, startTime, endTime);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLicenseManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    QueryConfigurationLicenseUsageRequest actualRequest =
        ((QueryConfigurationLicenseUsageRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(startTime, actualRequest.getStartTime());
    Assert.assertEquals(endTime, actualRequest.getEndTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void queryConfigurationLicenseUsageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseManager.addException(exception);

    try {
      ConfigurationName name = ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]");
      Timestamp startTime = Timestamp.newBuilder().build();
      Timestamp endTime = Timestamp.newBuilder().build();
      client.queryConfigurationLicenseUsage(name, startTime, endTime);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void queryConfigurationLicenseUsageTest2() throws Exception {
    QueryConfigurationLicenseUsageResponse expectedResponse =
        QueryConfigurationLicenseUsageResponse.newBuilder().build();
    mockLicenseManager.addResponse(expectedResponse);

    String name = "name3373707";
    Timestamp startTime = Timestamp.newBuilder().build();
    Timestamp endTime = Timestamp.newBuilder().build();

    QueryConfigurationLicenseUsageResponse actualResponse =
        client.queryConfigurationLicenseUsage(name, startTime, endTime);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLicenseManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    QueryConfigurationLicenseUsageRequest actualRequest =
        ((QueryConfigurationLicenseUsageRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(startTime, actualRequest.getStartTime());
    Assert.assertEquals(endTime, actualRequest.getEndTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void queryConfigurationLicenseUsageExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseManager.addException(exception);

    try {
      String name = "name3373707";
      Timestamp startTime = Timestamp.newBuilder().build();
      Timestamp endTime = Timestamp.newBuilder().build();
      client.queryConfigurationLicenseUsage(name, startTime, endTime);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void aggregateUsageTest() throws Exception {
    Usage responsesElement = Usage.newBuilder().build();
    AggregateUsageResponse expectedResponse =
        AggregateUsageResponse.newBuilder()
            .setNextPageToken("")
            .addAllUsages(Arrays.asList(responsesElement))
            .build();
    mockLicenseManager.addResponse(expectedResponse);

    ConfigurationName name = ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]");
    Timestamp startTime = Timestamp.newBuilder().build();
    Timestamp endTime = Timestamp.newBuilder().build();

    AggregateUsagePagedResponse pagedListResponse = client.aggregateUsage(name, startTime, endTime);

    List<Usage> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUsagesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLicenseManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AggregateUsageRequest actualRequest = ((AggregateUsageRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(startTime, actualRequest.getStartTime());
    Assert.assertEquals(endTime, actualRequest.getEndTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void aggregateUsageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseManager.addException(exception);

    try {
      ConfigurationName name = ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]");
      Timestamp startTime = Timestamp.newBuilder().build();
      Timestamp endTime = Timestamp.newBuilder().build();
      client.aggregateUsage(name, startTime, endTime);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void aggregateUsageTest2() throws Exception {
    Usage responsesElement = Usage.newBuilder().build();
    AggregateUsageResponse expectedResponse =
        AggregateUsageResponse.newBuilder()
            .setNextPageToken("")
            .addAllUsages(Arrays.asList(responsesElement))
            .build();
    mockLicenseManager.addResponse(expectedResponse);

    String name = "name3373707";
    Timestamp startTime = Timestamp.newBuilder().build();
    Timestamp endTime = Timestamp.newBuilder().build();

    AggregateUsagePagedResponse pagedListResponse = client.aggregateUsage(name, startTime, endTime);

    List<Usage> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUsagesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLicenseManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AggregateUsageRequest actualRequest = ((AggregateUsageRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(startTime, actualRequest.getStartTime());
    Assert.assertEquals(endTime, actualRequest.getEndTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void aggregateUsageExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseManager.addException(exception);

    try {
      String name = "name3373707";
      Timestamp startTime = Timestamp.newBuilder().build();
      Timestamp endTime = Timestamp.newBuilder().build();
      client.aggregateUsage(name, startTime, endTime);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProductsTest() throws Exception {
    Product responsesElement = Product.newBuilder().build();
    ListProductsResponse expectedResponse =
        ListProductsResponse.newBuilder()
            .setNextPageToken("")
            .addAllProducts(Arrays.asList(responsesElement))
            .build();
    mockLicenseManager.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListProductsPagedResponse pagedListResponse = client.listProducts(parent);

    List<Product> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProductsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLicenseManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProductsRequest actualRequest = ((ListProductsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listProductsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseManager.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listProducts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProductsTest2() throws Exception {
    Product responsesElement = Product.newBuilder().build();
    ListProductsResponse expectedResponse =
        ListProductsResponse.newBuilder()
            .setNextPageToken("")
            .addAllProducts(Arrays.asList(responsesElement))
            .build();
    mockLicenseManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListProductsPagedResponse pagedListResponse = client.listProducts(parent);

    List<Product> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProductsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLicenseManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProductsRequest actualRequest = ((ListProductsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listProductsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseManager.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listProducts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProductTest() throws Exception {
    Product expectedResponse =
        Product.newBuilder()
            .setName(ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString())
            .setVersion("version351608024")
            .setProductCompany("productCompany816671886")
            .setSku("sku113949")
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .build();
    mockLicenseManager.addResponse(expectedResponse);

    ProductName name = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");

    Product actualResponse = client.getProduct(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLicenseManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProductRequest actualRequest = ((GetProductRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getProductExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseManager.addException(exception);

    try {
      ProductName name = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
      client.getProduct(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProductTest2() throws Exception {
    Product expectedResponse =
        Product.newBuilder()
            .setName(ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString())
            .setVersion("version351608024")
            .setProductCompany("productCompany816671886")
            .setSku("sku113949")
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .build();
    mockLicenseManager.addResponse(expectedResponse);

    String name = "name3373707";

    Product actualResponse = client.getProduct(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLicenseManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProductRequest actualRequest = ((GetProductRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getProductExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseManager.addException(exception);

    try {
      String name = "name3373707";
      client.getProduct(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
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
