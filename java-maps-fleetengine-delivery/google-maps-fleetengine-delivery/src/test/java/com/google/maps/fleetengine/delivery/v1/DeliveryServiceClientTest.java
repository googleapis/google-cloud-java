/*
 * Copyright 2023 Google LLC
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

package google.maps.fleetengine.delivery.v1;

import static google.maps.fleetengine.delivery.v1.DeliveryServiceClient.ListDeliveryVehiclesPagedResponse;
import static google.maps.fleetengine.delivery.v1.DeliveryServiceClient.ListTasksPagedResponse;
import static google.maps.fleetengine.delivery.v1.DeliveryServiceClient.SearchTasksPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Int32Value;
import com.google.protobuf.Timestamp;
import com.google.type.LatLng;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class DeliveryServiceClientTest {
  private static MockDeliveryService mockDeliveryService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DeliveryServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDeliveryService = new MockDeliveryService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockDeliveryService));
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
    DeliveryServiceSettings settings =
        DeliveryServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DeliveryServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createDeliveryVehicleTest() throws Exception {
    DeliveryVehicle expectedResponse =
        DeliveryVehicle.newBuilder()
            .setName(DeliveryVehicleName.of("[PROVIDER]", "[VEHICLE]").toString())
            .setLastLocation(DeliveryVehicleLocation.newBuilder().build())
            .setNavigationStatus(DeliveryVehicleNavigationStatus.forNumber(0))
            .setCurrentRouteSegment(ByteString.EMPTY)
            .setCurrentRouteSegmentEndPoint(LatLng.newBuilder().build())
            .setRemainingDistanceMeters(Int32Value.newBuilder().build())
            .setRemainingDuration(Duration.newBuilder().build())
            .addAllRemainingVehicleJourneySegments(new ArrayList<VehicleJourneySegment>())
            .addAllAttributes(new ArrayList<DeliveryVehicleAttribute>())
            .build();
    mockDeliveryService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    DeliveryVehicle deliveryVehicle = DeliveryVehicle.newBuilder().build();
    String deliveryVehicleId = "deliveryVehicleId-861424685";

    DeliveryVehicle actualResponse =
        client.createDeliveryVehicle(parent, deliveryVehicle, deliveryVehicleId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeliveryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDeliveryVehicleRequest actualRequest =
        ((CreateDeliveryVehicleRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(deliveryVehicle, actualRequest.getDeliveryVehicle());
    Assert.assertEquals(deliveryVehicleId, actualRequest.getDeliveryVehicleId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDeliveryVehicleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeliveryService.addException(exception);

    try {
      String parent = "parent-995424086";
      DeliveryVehicle deliveryVehicle = DeliveryVehicle.newBuilder().build();
      String deliveryVehicleId = "deliveryVehicleId-861424685";
      client.createDeliveryVehicle(parent, deliveryVehicle, deliveryVehicleId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDeliveryVehicleTest() throws Exception {
    DeliveryVehicle expectedResponse =
        DeliveryVehicle.newBuilder()
            .setName(DeliveryVehicleName.of("[PROVIDER]", "[VEHICLE]").toString())
            .setLastLocation(DeliveryVehicleLocation.newBuilder().build())
            .setNavigationStatus(DeliveryVehicleNavigationStatus.forNumber(0))
            .setCurrentRouteSegment(ByteString.EMPTY)
            .setCurrentRouteSegmentEndPoint(LatLng.newBuilder().build())
            .setRemainingDistanceMeters(Int32Value.newBuilder().build())
            .setRemainingDuration(Duration.newBuilder().build())
            .addAllRemainingVehicleJourneySegments(new ArrayList<VehicleJourneySegment>())
            .addAllAttributes(new ArrayList<DeliveryVehicleAttribute>())
            .build();
    mockDeliveryService.addResponse(expectedResponse);

    DeliveryVehicleName name = DeliveryVehicleName.of("[PROVIDER]", "[VEHICLE]");

    DeliveryVehicle actualResponse = client.getDeliveryVehicle(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeliveryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDeliveryVehicleRequest actualRequest = ((GetDeliveryVehicleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDeliveryVehicleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeliveryService.addException(exception);

    try {
      DeliveryVehicleName name = DeliveryVehicleName.of("[PROVIDER]", "[VEHICLE]");
      client.getDeliveryVehicle(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDeliveryVehicleTest2() throws Exception {
    DeliveryVehicle expectedResponse =
        DeliveryVehicle.newBuilder()
            .setName(DeliveryVehicleName.of("[PROVIDER]", "[VEHICLE]").toString())
            .setLastLocation(DeliveryVehicleLocation.newBuilder().build())
            .setNavigationStatus(DeliveryVehicleNavigationStatus.forNumber(0))
            .setCurrentRouteSegment(ByteString.EMPTY)
            .setCurrentRouteSegmentEndPoint(LatLng.newBuilder().build())
            .setRemainingDistanceMeters(Int32Value.newBuilder().build())
            .setRemainingDuration(Duration.newBuilder().build())
            .addAllRemainingVehicleJourneySegments(new ArrayList<VehicleJourneySegment>())
            .addAllAttributes(new ArrayList<DeliveryVehicleAttribute>())
            .build();
    mockDeliveryService.addResponse(expectedResponse);

    String name = "name3373707";

    DeliveryVehicle actualResponse = client.getDeliveryVehicle(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeliveryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDeliveryVehicleRequest actualRequest = ((GetDeliveryVehicleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDeliveryVehicleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeliveryService.addException(exception);

    try {
      String name = "name3373707";
      client.getDeliveryVehicle(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDeliveryVehicleTest() throws Exception {
    DeliveryVehicle expectedResponse =
        DeliveryVehicle.newBuilder()
            .setName(DeliveryVehicleName.of("[PROVIDER]", "[VEHICLE]").toString())
            .setLastLocation(DeliveryVehicleLocation.newBuilder().build())
            .setNavigationStatus(DeliveryVehicleNavigationStatus.forNumber(0))
            .setCurrentRouteSegment(ByteString.EMPTY)
            .setCurrentRouteSegmentEndPoint(LatLng.newBuilder().build())
            .setRemainingDistanceMeters(Int32Value.newBuilder().build())
            .setRemainingDuration(Duration.newBuilder().build())
            .addAllRemainingVehicleJourneySegments(new ArrayList<VehicleJourneySegment>())
            .addAllAttributes(new ArrayList<DeliveryVehicleAttribute>())
            .build();
    mockDeliveryService.addResponse(expectedResponse);

    DeliveryVehicle deliveryVehicle = DeliveryVehicle.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DeliveryVehicle actualResponse = client.updateDeliveryVehicle(deliveryVehicle, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeliveryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDeliveryVehicleRequest actualRequest =
        ((UpdateDeliveryVehicleRequest) actualRequests.get(0));

    Assert.assertEquals(deliveryVehicle, actualRequest.getDeliveryVehicle());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDeliveryVehicleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeliveryService.addException(exception);

    try {
      DeliveryVehicle deliveryVehicle = DeliveryVehicle.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDeliveryVehicle(deliveryVehicle, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateTasksTest() throws Exception {
    BatchCreateTasksResponse expectedResponse =
        BatchCreateTasksResponse.newBuilder().addAllTasks(new ArrayList<Task>()).build();
    mockDeliveryService.addResponse(expectedResponse);

    BatchCreateTasksRequest request =
        BatchCreateTasksRequest.newBuilder()
            .setHeader(DeliveryRequestHeader.newBuilder().build())
            .setParent(ProviderName.of("[PROVIDER]").toString())
            .addAllRequests(new ArrayList<CreateTaskRequest>())
            .build();

    BatchCreateTasksResponse actualResponse = client.batchCreateTasks(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeliveryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateTasksRequest actualRequest = ((BatchCreateTasksRequest) actualRequests.get(0));

    Assert.assertEquals(request.getHeader(), actualRequest.getHeader());
    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getRequestsList(), actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchCreateTasksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeliveryService.addException(exception);

    try {
      BatchCreateTasksRequest request =
          BatchCreateTasksRequest.newBuilder()
              .setHeader(DeliveryRequestHeader.newBuilder().build())
              .setParent(ProviderName.of("[PROVIDER]").toString())
              .addAllRequests(new ArrayList<CreateTaskRequest>())
              .build();
      client.batchCreateTasks(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTaskTest() throws Exception {
    Task expectedResponse =
        Task.newBuilder()
            .setName(TaskName.of("[PROVIDER]", "[TASK]").toString())
            .setTaskOutcomeTime(Timestamp.newBuilder().build())
            .setTaskOutcomeLocation(LocationInfo.newBuilder().build())
            .setTrackingId("trackingId1168987698")
            .setDeliveryVehicleId("deliveryVehicleId-861424685")
            .setPlannedLocation(LocationInfo.newBuilder().build())
            .setTaskDuration(Duration.newBuilder().build())
            .setTargetTimeWindow(TimeWindow.newBuilder().build())
            .setJourneySharingInfo(Task.JourneySharingInfo.newBuilder().build())
            .setTaskTrackingViewConfig(TaskTrackingViewConfig.newBuilder().build())
            .addAllAttributes(new ArrayList<TaskAttribute>())
            .build();
    mockDeliveryService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Task task = Task.newBuilder().build();
    String taskId = "taskId-880873088";

    Task actualResponse = client.createTask(parent, task, taskId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeliveryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTaskRequest actualRequest = ((CreateTaskRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(task, actualRequest.getTask());
    Assert.assertEquals(taskId, actualRequest.getTaskId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTaskExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeliveryService.addException(exception);

    try {
      String parent = "parent-995424086";
      Task task = Task.newBuilder().build();
      String taskId = "taskId-880873088";
      client.createTask(parent, task, taskId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTaskTest() throws Exception {
    Task expectedResponse =
        Task.newBuilder()
            .setName(TaskName.of("[PROVIDER]", "[TASK]").toString())
            .setTaskOutcomeTime(Timestamp.newBuilder().build())
            .setTaskOutcomeLocation(LocationInfo.newBuilder().build())
            .setTrackingId("trackingId1168987698")
            .setDeliveryVehicleId("deliveryVehicleId-861424685")
            .setPlannedLocation(LocationInfo.newBuilder().build())
            .setTaskDuration(Duration.newBuilder().build())
            .setTargetTimeWindow(TimeWindow.newBuilder().build())
            .setJourneySharingInfo(Task.JourneySharingInfo.newBuilder().build())
            .setTaskTrackingViewConfig(TaskTrackingViewConfig.newBuilder().build())
            .addAllAttributes(new ArrayList<TaskAttribute>())
            .build();
    mockDeliveryService.addResponse(expectedResponse);

    TaskName name = TaskName.of("[PROVIDER]", "[TASK]");

    Task actualResponse = client.getTask(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeliveryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTaskRequest actualRequest = ((GetTaskRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTaskExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeliveryService.addException(exception);

    try {
      TaskName name = TaskName.of("[PROVIDER]", "[TASK]");
      client.getTask(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTaskTest2() throws Exception {
    Task expectedResponse =
        Task.newBuilder()
            .setName(TaskName.of("[PROVIDER]", "[TASK]").toString())
            .setTaskOutcomeTime(Timestamp.newBuilder().build())
            .setTaskOutcomeLocation(LocationInfo.newBuilder().build())
            .setTrackingId("trackingId1168987698")
            .setDeliveryVehicleId("deliveryVehicleId-861424685")
            .setPlannedLocation(LocationInfo.newBuilder().build())
            .setTaskDuration(Duration.newBuilder().build())
            .setTargetTimeWindow(TimeWindow.newBuilder().build())
            .setJourneySharingInfo(Task.JourneySharingInfo.newBuilder().build())
            .setTaskTrackingViewConfig(TaskTrackingViewConfig.newBuilder().build())
            .addAllAttributes(new ArrayList<TaskAttribute>())
            .build();
    mockDeliveryService.addResponse(expectedResponse);

    String name = "name3373707";

    Task actualResponse = client.getTask(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeliveryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTaskRequest actualRequest = ((GetTaskRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTaskExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeliveryService.addException(exception);

    try {
      String name = "name3373707";
      client.getTask(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchTasksTest() throws Exception {
    Task responsesElement = Task.newBuilder().build();
    SearchTasksResponse expectedResponse =
        SearchTasksResponse.newBuilder()
            .setNextPageToken("")
            .addAllTasks(Arrays.asList(responsesElement))
            .build();
    mockDeliveryService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    SearchTasksPagedResponse pagedListResponse = client.searchTasks(parent);

    List<Task> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTasksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDeliveryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchTasksRequest actualRequest = ((SearchTasksRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchTasksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeliveryService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.searchTasks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTaskTest() throws Exception {
    Task expectedResponse =
        Task.newBuilder()
            .setName(TaskName.of("[PROVIDER]", "[TASK]").toString())
            .setTaskOutcomeTime(Timestamp.newBuilder().build())
            .setTaskOutcomeLocation(LocationInfo.newBuilder().build())
            .setTrackingId("trackingId1168987698")
            .setDeliveryVehicleId("deliveryVehicleId-861424685")
            .setPlannedLocation(LocationInfo.newBuilder().build())
            .setTaskDuration(Duration.newBuilder().build())
            .setTargetTimeWindow(TimeWindow.newBuilder().build())
            .setJourneySharingInfo(Task.JourneySharingInfo.newBuilder().build())
            .setTaskTrackingViewConfig(TaskTrackingViewConfig.newBuilder().build())
            .addAllAttributes(new ArrayList<TaskAttribute>())
            .build();
    mockDeliveryService.addResponse(expectedResponse);

    Task task = Task.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Task actualResponse = client.updateTask(task, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeliveryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTaskRequest actualRequest = ((UpdateTaskRequest) actualRequests.get(0));

    Assert.assertEquals(task, actualRequest.getTask());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTaskExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeliveryService.addException(exception);

    try {
      Task task = Task.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTask(task, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTasksTest() throws Exception {
    Task responsesElement = Task.newBuilder().build();
    ListTasksResponse expectedResponse =
        ListTasksResponse.newBuilder()
            .setNextPageToken("")
            .addAllTasks(Arrays.asList(responsesElement))
            .build();
    mockDeliveryService.addResponse(expectedResponse);

    ProviderName parent = ProviderName.of("[PROVIDER]");

    ListTasksPagedResponse pagedListResponse = client.listTasks(parent);

    List<Task> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTasksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDeliveryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTasksRequest actualRequest = ((ListTasksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTasksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeliveryService.addException(exception);

    try {
      ProviderName parent = ProviderName.of("[PROVIDER]");
      client.listTasks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTasksTest2() throws Exception {
    Task responsesElement = Task.newBuilder().build();
    ListTasksResponse expectedResponse =
        ListTasksResponse.newBuilder()
            .setNextPageToken("")
            .addAllTasks(Arrays.asList(responsesElement))
            .build();
    mockDeliveryService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTasksPagedResponse pagedListResponse = client.listTasks(parent);

    List<Task> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTasksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDeliveryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTasksRequest actualRequest = ((ListTasksRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTasksExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeliveryService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTasks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTaskTrackingInfoTest() throws Exception {
    TaskTrackingInfo expectedResponse =
        TaskTrackingInfo.newBuilder()
            .setName(TaskTrackingInfoName.of("[PROVIDER]", "[TRACKING]").toString())
            .setTrackingId("trackingId1168987698")
            .setVehicleLocation(DeliveryVehicleLocation.newBuilder().build())
            .addAllRoutePolylinePoints(new ArrayList<LatLng>())
            .setRemainingStopCount(Int32Value.newBuilder().build())
            .setRemainingDrivingDistanceMeters(Int32Value.newBuilder().build())
            .setEstimatedArrivalTime(Timestamp.newBuilder().build())
            .setEstimatedTaskCompletionTime(Timestamp.newBuilder().build())
            .setTaskOutcomeTime(Timestamp.newBuilder().build())
            .setPlannedLocation(LocationInfo.newBuilder().build())
            .setTargetTimeWindow(TimeWindow.newBuilder().build())
            .addAllAttributes(new ArrayList<TaskAttribute>())
            .build();
    mockDeliveryService.addResponse(expectedResponse);

    TaskTrackingInfoName name = TaskTrackingInfoName.of("[PROVIDER]", "[TRACKING]");

    TaskTrackingInfo actualResponse = client.getTaskTrackingInfo(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeliveryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTaskTrackingInfoRequest actualRequest = ((GetTaskTrackingInfoRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTaskTrackingInfoExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeliveryService.addException(exception);

    try {
      TaskTrackingInfoName name = TaskTrackingInfoName.of("[PROVIDER]", "[TRACKING]");
      client.getTaskTrackingInfo(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTaskTrackingInfoTest2() throws Exception {
    TaskTrackingInfo expectedResponse =
        TaskTrackingInfo.newBuilder()
            .setName(TaskTrackingInfoName.of("[PROVIDER]", "[TRACKING]").toString())
            .setTrackingId("trackingId1168987698")
            .setVehicleLocation(DeliveryVehicleLocation.newBuilder().build())
            .addAllRoutePolylinePoints(new ArrayList<LatLng>())
            .setRemainingStopCount(Int32Value.newBuilder().build())
            .setRemainingDrivingDistanceMeters(Int32Value.newBuilder().build())
            .setEstimatedArrivalTime(Timestamp.newBuilder().build())
            .setEstimatedTaskCompletionTime(Timestamp.newBuilder().build())
            .setTaskOutcomeTime(Timestamp.newBuilder().build())
            .setPlannedLocation(LocationInfo.newBuilder().build())
            .setTargetTimeWindow(TimeWindow.newBuilder().build())
            .addAllAttributes(new ArrayList<TaskAttribute>())
            .build();
    mockDeliveryService.addResponse(expectedResponse);

    String name = "name3373707";

    TaskTrackingInfo actualResponse = client.getTaskTrackingInfo(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeliveryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTaskTrackingInfoRequest actualRequest = ((GetTaskTrackingInfoRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTaskTrackingInfoExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeliveryService.addException(exception);

    try {
      String name = "name3373707";
      client.getTaskTrackingInfo(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDeliveryVehiclesTest() throws Exception {
    DeliveryVehicle responsesElement = DeliveryVehicle.newBuilder().build();
    ListDeliveryVehiclesResponse expectedResponse =
        ListDeliveryVehiclesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDeliveryVehicles(Arrays.asList(responsesElement))
            .build();
    mockDeliveryService.addResponse(expectedResponse);

    ProviderName parent = ProviderName.of("[PROVIDER]");

    ListDeliveryVehiclesPagedResponse pagedListResponse = client.listDeliveryVehicles(parent);

    List<DeliveryVehicle> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeliveryVehiclesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDeliveryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDeliveryVehiclesRequest actualRequest =
        ((ListDeliveryVehiclesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDeliveryVehiclesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeliveryService.addException(exception);

    try {
      ProviderName parent = ProviderName.of("[PROVIDER]");
      client.listDeliveryVehicles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDeliveryVehiclesTest2() throws Exception {
    DeliveryVehicle responsesElement = DeliveryVehicle.newBuilder().build();
    ListDeliveryVehiclesResponse expectedResponse =
        ListDeliveryVehiclesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDeliveryVehicles(Arrays.asList(responsesElement))
            .build();
    mockDeliveryService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDeliveryVehiclesPagedResponse pagedListResponse = client.listDeliveryVehicles(parent);

    List<DeliveryVehicle> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeliveryVehiclesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDeliveryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDeliveryVehiclesRequest actualRequest =
        ((ListDeliveryVehiclesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDeliveryVehiclesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeliveryService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDeliveryVehicles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
