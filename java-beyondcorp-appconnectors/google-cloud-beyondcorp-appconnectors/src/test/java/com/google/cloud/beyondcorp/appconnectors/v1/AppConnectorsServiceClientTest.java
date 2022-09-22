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

package com.google.cloud.beyondcorp.appconnectors.v1;

import static com.google.cloud.beyondcorp.appconnectors.v1.AppConnectorsServiceClient.ListAppConnectorsPagedResponse;
import static com.google.cloud.beyondcorp.appconnectors.v1.AppConnectorsServiceClient.ListLocationsPagedResponse;

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
public class AppConnectorsServiceClientTest {
  private static MockAppConnectorsService mockAppConnectorsService;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AppConnectorsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAppConnectorsService = new MockAppConnectorsService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockAppConnectorsService, mockLocations, mockIAMPolicy));
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
    AppConnectorsServiceSettings settings =
        AppConnectorsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AppConnectorsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listAppConnectorsTest() throws Exception {
    AppConnector responsesElement = AppConnector.newBuilder().build();
    ListAppConnectorsResponse expectedResponse =
        ListAppConnectorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAppConnectors(Arrays.asList(responsesElement))
            .build();
    mockAppConnectorsService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAppConnectorsPagedResponse pagedListResponse = client.listAppConnectors(parent);

    List<AppConnector> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAppConnectorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAppConnectorsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAppConnectorsRequest actualRequest = ((ListAppConnectorsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAppConnectorsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppConnectorsService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAppConnectors(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAppConnectorsTest2() throws Exception {
    AppConnector responsesElement = AppConnector.newBuilder().build();
    ListAppConnectorsResponse expectedResponse =
        ListAppConnectorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAppConnectors(Arrays.asList(responsesElement))
            .build();
    mockAppConnectorsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAppConnectorsPagedResponse pagedListResponse = client.listAppConnectors(parent);

    List<AppConnector> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAppConnectorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAppConnectorsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAppConnectorsRequest actualRequest = ((ListAppConnectorsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAppConnectorsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppConnectorsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAppConnectors(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAppConnectorTest() throws Exception {
    AppConnector expectedResponse =
        AppConnector.newBuilder()
            .setName(AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setPrincipalInfo(AppConnector.PrincipalInfo.newBuilder().build())
            .setResourceInfo(ResourceInfo.newBuilder().build())
            .build();
    mockAppConnectorsService.addResponse(expectedResponse);

    AppConnectorName name = AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]");

    AppConnector actualResponse = client.getAppConnector(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppConnectorsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAppConnectorRequest actualRequest = ((GetAppConnectorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAppConnectorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppConnectorsService.addException(exception);

    try {
      AppConnectorName name = AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]");
      client.getAppConnector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAppConnectorTest2() throws Exception {
    AppConnector expectedResponse =
        AppConnector.newBuilder()
            .setName(AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setPrincipalInfo(AppConnector.PrincipalInfo.newBuilder().build())
            .setResourceInfo(ResourceInfo.newBuilder().build())
            .build();
    mockAppConnectorsService.addResponse(expectedResponse);

    String name = "name3373707";

    AppConnector actualResponse = client.getAppConnector(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppConnectorsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAppConnectorRequest actualRequest = ((GetAppConnectorRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAppConnectorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppConnectorsService.addException(exception);

    try {
      String name = "name3373707";
      client.getAppConnector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAppConnectorTest() throws Exception {
    AppConnector expectedResponse =
        AppConnector.newBuilder()
            .setName(AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setPrincipalInfo(AppConnector.PrincipalInfo.newBuilder().build())
            .setResourceInfo(ResourceInfo.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAppConnectorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppConnectorsService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    AppConnector appConnector = AppConnector.newBuilder().build();
    String appConnectorId = "appConnectorId374103399";

    AppConnector actualResponse =
        client.createAppConnectorAsync(parent, appConnector, appConnectorId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppConnectorsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAppConnectorRequest actualRequest = ((CreateAppConnectorRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(appConnector, actualRequest.getAppConnector());
    Assert.assertEquals(appConnectorId, actualRequest.getAppConnectorId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAppConnectorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppConnectorsService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      AppConnector appConnector = AppConnector.newBuilder().build();
      String appConnectorId = "appConnectorId374103399";
      client.createAppConnectorAsync(parent, appConnector, appConnectorId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createAppConnectorTest2() throws Exception {
    AppConnector expectedResponse =
        AppConnector.newBuilder()
            .setName(AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setPrincipalInfo(AppConnector.PrincipalInfo.newBuilder().build())
            .setResourceInfo(ResourceInfo.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAppConnectorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppConnectorsService.addResponse(resultOperation);

    String parent = "parent-995424086";
    AppConnector appConnector = AppConnector.newBuilder().build();
    String appConnectorId = "appConnectorId374103399";

    AppConnector actualResponse =
        client.createAppConnectorAsync(parent, appConnector, appConnectorId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppConnectorsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAppConnectorRequest actualRequest = ((CreateAppConnectorRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(appConnector, actualRequest.getAppConnector());
    Assert.assertEquals(appConnectorId, actualRequest.getAppConnectorId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAppConnectorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppConnectorsService.addException(exception);

    try {
      String parent = "parent-995424086";
      AppConnector appConnector = AppConnector.newBuilder().build();
      String appConnectorId = "appConnectorId374103399";
      client.createAppConnectorAsync(parent, appConnector, appConnectorId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateAppConnectorTest() throws Exception {
    AppConnector expectedResponse =
        AppConnector.newBuilder()
            .setName(AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setPrincipalInfo(AppConnector.PrincipalInfo.newBuilder().build())
            .setResourceInfo(ResourceInfo.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateAppConnectorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppConnectorsService.addResponse(resultOperation);

    AppConnector appConnector = AppConnector.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AppConnector actualResponse = client.updateAppConnectorAsync(appConnector, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppConnectorsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAppConnectorRequest actualRequest = ((UpdateAppConnectorRequest) actualRequests.get(0));

    Assert.assertEquals(appConnector, actualRequest.getAppConnector());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAppConnectorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppConnectorsService.addException(exception);

    try {
      AppConnector appConnector = AppConnector.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAppConnectorAsync(appConnector, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteAppConnectorTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAppConnectorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppConnectorsService.addResponse(resultOperation);

    AppConnectorName name = AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]");

    client.deleteAppConnectorAsync(name).get();

    List<AbstractMessage> actualRequests = mockAppConnectorsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAppConnectorRequest actualRequest = ((DeleteAppConnectorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAppConnectorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppConnectorsService.addException(exception);

    try {
      AppConnectorName name = AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]");
      client.deleteAppConnectorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteAppConnectorTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAppConnectorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppConnectorsService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteAppConnectorAsync(name).get();

    List<AbstractMessage> actualRequests = mockAppConnectorsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAppConnectorRequest actualRequest = ((DeleteAppConnectorRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAppConnectorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppConnectorsService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAppConnectorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void reportStatusTest() throws Exception {
    AppConnector expectedResponse =
        AppConnector.newBuilder()
            .setName(AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setPrincipalInfo(AppConnector.PrincipalInfo.newBuilder().build())
            .setResourceInfo(ResourceInfo.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("reportStatusTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppConnectorsService.addResponse(resultOperation);

    AppConnectorName appConnector =
        AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]");
    ResourceInfo resourceInfo = ResourceInfo.newBuilder().build();

    AppConnector actualResponse = client.reportStatusAsync(appConnector, resourceInfo).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppConnectorsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReportStatusRequest actualRequest = ((ReportStatusRequest) actualRequests.get(0));

    Assert.assertEquals(appConnector.toString(), actualRequest.getAppConnector());
    Assert.assertEquals(resourceInfo, actualRequest.getResourceInfo());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void reportStatusExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppConnectorsService.addException(exception);

    try {
      AppConnectorName appConnector =
          AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]");
      ResourceInfo resourceInfo = ResourceInfo.newBuilder().build();
      client.reportStatusAsync(appConnector, resourceInfo).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void reportStatusTest2() throws Exception {
    AppConnector expectedResponse =
        AppConnector.newBuilder()
            .setName(AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setPrincipalInfo(AppConnector.PrincipalInfo.newBuilder().build())
            .setResourceInfo(ResourceInfo.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("reportStatusTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppConnectorsService.addResponse(resultOperation);

    String appConnector = "appConnector1131114284";
    ResourceInfo resourceInfo = ResourceInfo.newBuilder().build();

    AppConnector actualResponse = client.reportStatusAsync(appConnector, resourceInfo).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppConnectorsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReportStatusRequest actualRequest = ((ReportStatusRequest) actualRequests.get(0));

    Assert.assertEquals(appConnector, actualRequest.getAppConnector());
    Assert.assertEquals(resourceInfo, actualRequest.getResourceInfo());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void reportStatusExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppConnectorsService.addException(exception);

    try {
      String appConnector = "appConnector1131114284";
      ResourceInfo resourceInfo = ResourceInfo.newBuilder().build();
      client.reportStatusAsync(appConnector, resourceInfo).get();
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
            .setResource(
                AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]").toString())
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
              .setResource(
                  AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]").toString())
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
            .setResource(
                AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]").toString())
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
              .setResource(
                  AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]").toString())
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
            .setResource(
                AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]").toString())
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
              .setResource(
                  AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
