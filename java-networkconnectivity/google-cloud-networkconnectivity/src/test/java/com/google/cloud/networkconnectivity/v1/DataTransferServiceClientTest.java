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

package com.google.cloud.networkconnectivity.v1;

import static com.google.cloud.networkconnectivity.v1.DataTransferServiceClient.ListDestinationsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.DataTransferServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.DataTransferServiceClient.ListMulticloudDataTransferConfigsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.DataTransferServiceClient.ListMulticloudDataTransferSupportedServicesPagedResponse;

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
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
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
public class DataTransferServiceClientTest {
  private static MockDataTransferService mockDataTransferService;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DataTransferServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDataTransferService = new MockDataTransferService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockDataTransferService, mockLocations, mockIAMPolicy));
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
    DataTransferServiceSettings settings =
        DataTransferServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataTransferServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listMulticloudDataTransferConfigsTest() throws Exception {
    MulticloudDataTransferConfig responsesElement =
        MulticloudDataTransferConfig.newBuilder().build();
    ListMulticloudDataTransferConfigsResponse expectedResponse =
        ListMulticloudDataTransferConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMulticloudDataTransferConfigs(Arrays.asList(responsesElement))
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListMulticloudDataTransferConfigsPagedResponse pagedListResponse =
        client.listMulticloudDataTransferConfigs(parent);

    List<MulticloudDataTransferConfig> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getMulticloudDataTransferConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMulticloudDataTransferConfigsRequest actualRequest =
        ((ListMulticloudDataTransferConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMulticloudDataTransferConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listMulticloudDataTransferConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMulticloudDataTransferConfigsTest2() throws Exception {
    MulticloudDataTransferConfig responsesElement =
        MulticloudDataTransferConfig.newBuilder().build();
    ListMulticloudDataTransferConfigsResponse expectedResponse =
        ListMulticloudDataTransferConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMulticloudDataTransferConfigs(Arrays.asList(responsesElement))
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMulticloudDataTransferConfigsPagedResponse pagedListResponse =
        client.listMulticloudDataTransferConfigs(parent);

    List<MulticloudDataTransferConfig> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getMulticloudDataTransferConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMulticloudDataTransferConfigsRequest actualRequest =
        ((ListMulticloudDataTransferConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMulticloudDataTransferConfigsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMulticloudDataTransferConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMulticloudDataTransferConfigTest() throws Exception {
    MulticloudDataTransferConfig expectedResponse =
        MulticloudDataTransferConfig.newBuilder()
            .setName(
                MulticloudDataTransferConfigName.of(
                        "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
            .setDestinationsCount(-1276771723)
            .setDestinationsActiveCount(-331520400)
            .putAllServices(new HashMap<String, StateTimeline>())
            .setUid("uid115792")
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    MulticloudDataTransferConfigName name =
        MulticloudDataTransferConfigName.of(
            "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]");

    MulticloudDataTransferConfig actualResponse = client.getMulticloudDataTransferConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMulticloudDataTransferConfigRequest actualRequest =
        ((GetMulticloudDataTransferConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMulticloudDataTransferConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      MulticloudDataTransferConfigName name =
          MulticloudDataTransferConfigName.of(
              "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]");
      client.getMulticloudDataTransferConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMulticloudDataTransferConfigTest2() throws Exception {
    MulticloudDataTransferConfig expectedResponse =
        MulticloudDataTransferConfig.newBuilder()
            .setName(
                MulticloudDataTransferConfigName.of(
                        "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
            .setDestinationsCount(-1276771723)
            .setDestinationsActiveCount(-331520400)
            .putAllServices(new HashMap<String, StateTimeline>())
            .setUid("uid115792")
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    String name = "name3373707";

    MulticloudDataTransferConfig actualResponse = client.getMulticloudDataTransferConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMulticloudDataTransferConfigRequest actualRequest =
        ((GetMulticloudDataTransferConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMulticloudDataTransferConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      String name = "name3373707";
      client.getMulticloudDataTransferConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMulticloudDataTransferConfigTest() throws Exception {
    MulticloudDataTransferConfig expectedResponse =
        MulticloudDataTransferConfig.newBuilder()
            .setName(
                MulticloudDataTransferConfigName.of(
                        "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
            .setDestinationsCount(-1276771723)
            .setDestinationsActiveCount(-331520400)
            .putAllServices(new HashMap<String, StateTimeline>())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMulticloudDataTransferConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataTransferService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    MulticloudDataTransferConfig multicloudDataTransferConfig =
        MulticloudDataTransferConfig.newBuilder().build();
    String multicloudDataTransferConfigId = "multicloudDataTransferConfigId-1067608178";

    MulticloudDataTransferConfig actualResponse =
        client
            .createMulticloudDataTransferConfigAsync(
                parent, multicloudDataTransferConfig, multicloudDataTransferConfigId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMulticloudDataTransferConfigRequest actualRequest =
        ((CreateMulticloudDataTransferConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(
        multicloudDataTransferConfig, actualRequest.getMulticloudDataTransferConfig());
    Assert.assertEquals(
        multicloudDataTransferConfigId, actualRequest.getMulticloudDataTransferConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMulticloudDataTransferConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      MulticloudDataTransferConfig multicloudDataTransferConfig =
          MulticloudDataTransferConfig.newBuilder().build();
      String multicloudDataTransferConfigId = "multicloudDataTransferConfigId-1067608178";
      client
          .createMulticloudDataTransferConfigAsync(
              parent, multicloudDataTransferConfig, multicloudDataTransferConfigId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createMulticloudDataTransferConfigTest2() throws Exception {
    MulticloudDataTransferConfig expectedResponse =
        MulticloudDataTransferConfig.newBuilder()
            .setName(
                MulticloudDataTransferConfigName.of(
                        "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
            .setDestinationsCount(-1276771723)
            .setDestinationsActiveCount(-331520400)
            .putAllServices(new HashMap<String, StateTimeline>())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMulticloudDataTransferConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataTransferService.addResponse(resultOperation);

    String parent = "parent-995424086";
    MulticloudDataTransferConfig multicloudDataTransferConfig =
        MulticloudDataTransferConfig.newBuilder().build();
    String multicloudDataTransferConfigId = "multicloudDataTransferConfigId-1067608178";

    MulticloudDataTransferConfig actualResponse =
        client
            .createMulticloudDataTransferConfigAsync(
                parent, multicloudDataTransferConfig, multicloudDataTransferConfigId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMulticloudDataTransferConfigRequest actualRequest =
        ((CreateMulticloudDataTransferConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(
        multicloudDataTransferConfig, actualRequest.getMulticloudDataTransferConfig());
    Assert.assertEquals(
        multicloudDataTransferConfigId, actualRequest.getMulticloudDataTransferConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMulticloudDataTransferConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      String parent = "parent-995424086";
      MulticloudDataTransferConfig multicloudDataTransferConfig =
          MulticloudDataTransferConfig.newBuilder().build();
      String multicloudDataTransferConfigId = "multicloudDataTransferConfigId-1067608178";
      client
          .createMulticloudDataTransferConfigAsync(
              parent, multicloudDataTransferConfig, multicloudDataTransferConfigId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateMulticloudDataTransferConfigTest() throws Exception {
    MulticloudDataTransferConfig expectedResponse =
        MulticloudDataTransferConfig.newBuilder()
            .setName(
                MulticloudDataTransferConfigName.of(
                        "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
            .setDestinationsCount(-1276771723)
            .setDestinationsActiveCount(-331520400)
            .putAllServices(new HashMap<String, StateTimeline>())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateMulticloudDataTransferConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataTransferService.addResponse(resultOperation);

    MulticloudDataTransferConfig multicloudDataTransferConfig =
        MulticloudDataTransferConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    MulticloudDataTransferConfig actualResponse =
        client
            .updateMulticloudDataTransferConfigAsync(multicloudDataTransferConfig, updateMask)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateMulticloudDataTransferConfigRequest actualRequest =
        ((UpdateMulticloudDataTransferConfigRequest) actualRequests.get(0));

    Assert.assertEquals(
        multicloudDataTransferConfig, actualRequest.getMulticloudDataTransferConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateMulticloudDataTransferConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      MulticloudDataTransferConfig multicloudDataTransferConfig =
          MulticloudDataTransferConfig.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client
          .updateMulticloudDataTransferConfigAsync(multicloudDataTransferConfig, updateMask)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteMulticloudDataTransferConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteMulticloudDataTransferConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataTransferService.addResponse(resultOperation);

    MulticloudDataTransferConfigName name =
        MulticloudDataTransferConfigName.of(
            "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]");

    client.deleteMulticloudDataTransferConfigAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMulticloudDataTransferConfigRequest actualRequest =
        ((DeleteMulticloudDataTransferConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMulticloudDataTransferConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      MulticloudDataTransferConfigName name =
          MulticloudDataTransferConfigName.of(
              "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]");
      client.deleteMulticloudDataTransferConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteMulticloudDataTransferConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteMulticloudDataTransferConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataTransferService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteMulticloudDataTransferConfigAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMulticloudDataTransferConfigRequest actualRequest =
        ((DeleteMulticloudDataTransferConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMulticloudDataTransferConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteMulticloudDataTransferConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listDestinationsTest() throws Exception {
    Destination responsesElement = Destination.newBuilder().build();
    ListDestinationsResponse expectedResponse =
        ListDestinationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDestinations(Arrays.asList(responsesElement))
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    MulticloudDataTransferConfigName parent =
        MulticloudDataTransferConfigName.of(
            "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]");

    ListDestinationsPagedResponse pagedListResponse = client.listDestinations(parent);

    List<Destination> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDestinationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDestinationsRequest actualRequest = ((ListDestinationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDestinationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      MulticloudDataTransferConfigName parent =
          MulticloudDataTransferConfigName.of(
              "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]");
      client.listDestinations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDestinationsTest2() throws Exception {
    Destination responsesElement = Destination.newBuilder().build();
    ListDestinationsResponse expectedResponse =
        ListDestinationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDestinations(Arrays.asList(responsesElement))
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDestinationsPagedResponse pagedListResponse = client.listDestinations(parent);

    List<Destination> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDestinationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDestinationsRequest actualRequest = ((ListDestinationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDestinationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDestinations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDestinationTest() throws Exception {
    Destination expectedResponse =
        Destination.newBuilder()
            .setName(
                DestinationName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[MULTICLOUD_DATA_TRANSFER_CONFIG]",
                        "[DESTINATION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
            .setIpPrefix("ipPrefix1326379673")
            .addAllEndpoints(new ArrayList<Destination.DestinationEndpoint>())
            .setStateTimeline(StateTimeline.newBuilder().build())
            .setUid("uid115792")
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    DestinationName name =
        DestinationName.of(
            "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]", "[DESTINATION]");

    Destination actualResponse = client.getDestination(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDestinationRequest actualRequest = ((GetDestinationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDestinationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      DestinationName name =
          DestinationName.of(
              "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]", "[DESTINATION]");
      client.getDestination(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDestinationTest2() throws Exception {
    Destination expectedResponse =
        Destination.newBuilder()
            .setName(
                DestinationName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[MULTICLOUD_DATA_TRANSFER_CONFIG]",
                        "[DESTINATION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
            .setIpPrefix("ipPrefix1326379673")
            .addAllEndpoints(new ArrayList<Destination.DestinationEndpoint>())
            .setStateTimeline(StateTimeline.newBuilder().build())
            .setUid("uid115792")
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    String name = "name3373707";

    Destination actualResponse = client.getDestination(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDestinationRequest actualRequest = ((GetDestinationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDestinationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      String name = "name3373707";
      client.getDestination(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDestinationTest() throws Exception {
    Destination expectedResponse =
        Destination.newBuilder()
            .setName(
                DestinationName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[MULTICLOUD_DATA_TRANSFER_CONFIG]",
                        "[DESTINATION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
            .setIpPrefix("ipPrefix1326379673")
            .addAllEndpoints(new ArrayList<Destination.DestinationEndpoint>())
            .setStateTimeline(StateTimeline.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDestinationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataTransferService.addResponse(resultOperation);

    MulticloudDataTransferConfigName parent =
        MulticloudDataTransferConfigName.of(
            "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]");
    Destination destination = Destination.newBuilder().build();
    String destinationId = "destinationId306545097";

    Destination actualResponse =
        client.createDestinationAsync(parent, destination, destinationId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDestinationRequest actualRequest = ((CreateDestinationRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(destination, actualRequest.getDestination());
    Assert.assertEquals(destinationId, actualRequest.getDestinationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDestinationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      MulticloudDataTransferConfigName parent =
          MulticloudDataTransferConfigName.of(
              "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]");
      Destination destination = Destination.newBuilder().build();
      String destinationId = "destinationId306545097";
      client.createDestinationAsync(parent, destination, destinationId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createDestinationTest2() throws Exception {
    Destination expectedResponse =
        Destination.newBuilder()
            .setName(
                DestinationName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[MULTICLOUD_DATA_TRANSFER_CONFIG]",
                        "[DESTINATION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
            .setIpPrefix("ipPrefix1326379673")
            .addAllEndpoints(new ArrayList<Destination.DestinationEndpoint>())
            .setStateTimeline(StateTimeline.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDestinationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataTransferService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Destination destination = Destination.newBuilder().build();
    String destinationId = "destinationId306545097";

    Destination actualResponse =
        client.createDestinationAsync(parent, destination, destinationId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDestinationRequest actualRequest = ((CreateDestinationRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(destination, actualRequest.getDestination());
    Assert.assertEquals(destinationId, actualRequest.getDestinationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDestinationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      String parent = "parent-995424086";
      Destination destination = Destination.newBuilder().build();
      String destinationId = "destinationId306545097";
      client.createDestinationAsync(parent, destination, destinationId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateDestinationTest() throws Exception {
    Destination expectedResponse =
        Destination.newBuilder()
            .setName(
                DestinationName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[MULTICLOUD_DATA_TRANSFER_CONFIG]",
                        "[DESTINATION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
            .setIpPrefix("ipPrefix1326379673")
            .addAllEndpoints(new ArrayList<Destination.DestinationEndpoint>())
            .setStateTimeline(StateTimeline.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDestinationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataTransferService.addResponse(resultOperation);

    Destination destination = Destination.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Destination actualResponse = client.updateDestinationAsync(destination, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDestinationRequest actualRequest = ((UpdateDestinationRequest) actualRequests.get(0));

    Assert.assertEquals(destination, actualRequest.getDestination());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDestinationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      Destination destination = Destination.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDestinationAsync(destination, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDestinationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDestinationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataTransferService.addResponse(resultOperation);

    DestinationName name =
        DestinationName.of(
            "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]", "[DESTINATION]");

    client.deleteDestinationAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDestinationRequest actualRequest = ((DeleteDestinationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDestinationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      DestinationName name =
          DestinationName.of(
              "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]", "[DESTINATION]");
      client.deleteDestinationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDestinationTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDestinationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataTransferService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteDestinationAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDestinationRequest actualRequest = ((DeleteDestinationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDestinationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDestinationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getMulticloudDataTransferSupportedServiceTest() throws Exception {
    MulticloudDataTransferSupportedService expectedResponse =
        MulticloudDataTransferSupportedService.newBuilder()
            .setName(
                MulticloudDataTransferSupportedServiceName.of(
                        "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_SUPPORTED_SERVICE]")
                    .toString())
            .addAllServiceConfigs(new ArrayList<ServiceConfig>())
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    MulticloudDataTransferSupportedServiceName name =
        MulticloudDataTransferSupportedServiceName.of(
            "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_SUPPORTED_SERVICE]");

    MulticloudDataTransferSupportedService actualResponse =
        client.getMulticloudDataTransferSupportedService(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMulticloudDataTransferSupportedServiceRequest actualRequest =
        ((GetMulticloudDataTransferSupportedServiceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMulticloudDataTransferSupportedServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      MulticloudDataTransferSupportedServiceName name =
          MulticloudDataTransferSupportedServiceName.of(
              "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_SUPPORTED_SERVICE]");
      client.getMulticloudDataTransferSupportedService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMulticloudDataTransferSupportedServiceTest2() throws Exception {
    MulticloudDataTransferSupportedService expectedResponse =
        MulticloudDataTransferSupportedService.newBuilder()
            .setName(
                MulticloudDataTransferSupportedServiceName.of(
                        "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_SUPPORTED_SERVICE]")
                    .toString())
            .addAllServiceConfigs(new ArrayList<ServiceConfig>())
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    String name = "name3373707";

    MulticloudDataTransferSupportedService actualResponse =
        client.getMulticloudDataTransferSupportedService(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMulticloudDataTransferSupportedServiceRequest actualRequest =
        ((GetMulticloudDataTransferSupportedServiceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMulticloudDataTransferSupportedServiceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      String name = "name3373707";
      client.getMulticloudDataTransferSupportedService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMulticloudDataTransferSupportedServicesTest() throws Exception {
    MulticloudDataTransferSupportedService responsesElement =
        MulticloudDataTransferSupportedService.newBuilder().build();
    ListMulticloudDataTransferSupportedServicesResponse expectedResponse =
        ListMulticloudDataTransferSupportedServicesResponse.newBuilder()
            .setNextPageToken("")
            .addAllMulticloudDataTransferSupportedServices(Arrays.asList(responsesElement))
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListMulticloudDataTransferSupportedServicesPagedResponse pagedListResponse =
        client.listMulticloudDataTransferSupportedServices(parent);

    List<MulticloudDataTransferSupportedService> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getMulticloudDataTransferSupportedServicesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMulticloudDataTransferSupportedServicesRequest actualRequest =
        ((ListMulticloudDataTransferSupportedServicesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMulticloudDataTransferSupportedServicesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listMulticloudDataTransferSupportedServices(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMulticloudDataTransferSupportedServicesTest2() throws Exception {
    MulticloudDataTransferSupportedService responsesElement =
        MulticloudDataTransferSupportedService.newBuilder().build();
    ListMulticloudDataTransferSupportedServicesResponse expectedResponse =
        ListMulticloudDataTransferSupportedServicesResponse.newBuilder()
            .setNextPageToken("")
            .addAllMulticloudDataTransferSupportedServices(Arrays.asList(responsesElement))
            .build();
    mockDataTransferService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMulticloudDataTransferSupportedServicesPagedResponse pagedListResponse =
        client.listMulticloudDataTransferSupportedServices(parent);

    List<MulticloudDataTransferSupportedService> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getMulticloudDataTransferSupportedServicesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataTransferService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMulticloudDataTransferSupportedServicesRequest actualRequest =
        ((ListMulticloudDataTransferSupportedServicesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMulticloudDataTransferSupportedServicesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTransferService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMulticloudDataTransferSupportedServices(parent);
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

  @Test
  public void setIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAMPolicy.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPolicy(), actualRequest.getPolicy());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
              .setPolicy(Policy.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.setIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAMPolicy.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getOptions(), actualRequest.getOptions());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
              .setOptions(GetPolicyOptions.newBuilder().build())
              .build();
      client.getIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockIAMPolicy.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPermissionsList(), actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
