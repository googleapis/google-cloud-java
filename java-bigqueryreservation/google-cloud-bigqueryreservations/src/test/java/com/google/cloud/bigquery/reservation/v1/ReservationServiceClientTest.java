/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigquery.reservation.v1;

import static com.google.cloud.bigquery.reservation.v1.ReservationServiceClient.ListAssignmentsPagedResponse;
import static com.google.cloud.bigquery.reservation.v1.ReservationServiceClient.ListCapacityCommitmentsPagedResponse;
import static com.google.cloud.bigquery.reservation.v1.ReservationServiceClient.ListReservationsPagedResponse;
import static com.google.cloud.bigquery.reservation.v1.ReservationServiceClient.SearchAssignmentsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class ReservationServiceClientTest {
  private static MockReservationService mockReservationService;
  private static MockServiceHelper serviceHelper;
  private ReservationServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockReservationService = new MockReservationService();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockReservationService));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
    ReservationServiceSettings settings =
        ReservationServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ReservationServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void deleteReservationTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockReservationService.addResponse(expectedResponse);

    ReservationName name = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");

    client.deleteReservation(name);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteReservationRequest actualRequest = (DeleteReservationRequest) actualRequests.get(0);

    Assert.assertEquals(name, ReservationName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteReservationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      ReservationName name = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");

      client.deleteReservation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteCapacityCommitmentTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockReservationService.addResponse(expectedResponse);

    CapacityCommitmentName name =
        CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]");

    client.deleteCapacityCommitment(name);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCapacityCommitmentRequest actualRequest =
        (DeleteCapacityCommitmentRequest) actualRequests.get(0);

    Assert.assertEquals(name, CapacityCommitmentName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteCapacityCommitmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      CapacityCommitmentName name =
          CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]");

      client.deleteCapacityCommitment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteAssignmentTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockReservationService.addResponse(expectedResponse);

    AssignmentName name =
        AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]");

    client.deleteAssignment(name);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAssignmentRequest actualRequest = (DeleteAssignmentRequest) actualRequests.get(0);

    Assert.assertEquals(name, AssignmentName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteAssignmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      AssignmentName name =
          AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]");

      client.deleteAssignment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createReservationTest() {
    ReservationName name = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
    long slotCapacity = 1516717605L;
    boolean ignoreIdleSlots = false;
    Reservation expectedResponse =
        Reservation.newBuilder()
            .setName(name.toString())
            .setSlotCapacity(slotCapacity)
            .setIgnoreIdleSlots(ignoreIdleSlots)
            .build();
    mockReservationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Reservation reservation = Reservation.newBuilder().build();
    String reservationId = "reservationId266209902";

    Reservation actualResponse = client.createReservation(parent, reservation, reservationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateReservationRequest actualRequest = (CreateReservationRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(reservation, actualRequest.getReservation());
    Assert.assertEquals(reservationId, actualRequest.getReservationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createReservationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Reservation reservation = Reservation.newBuilder().build();
      String reservationId = "reservationId266209902";

      client.createReservation(parent, reservation, reservationId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listReservationsTest() {
    String nextPageToken = "";
    Reservation reservationsElement = Reservation.newBuilder().build();
    List<Reservation> reservations = Arrays.asList(reservationsElement);
    ListReservationsResponse expectedResponse =
        ListReservationsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllReservations(reservations)
            .build();
    mockReservationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListReservationsPagedResponse pagedListResponse = client.listReservations(parent);

    List<Reservation> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReservationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListReservationsRequest actualRequest = (ListReservationsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listReservationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

      client.listReservations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getReservationTest() {
    ReservationName name2 = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
    long slotCapacity = 1516717605L;
    boolean ignoreIdleSlots = false;
    Reservation expectedResponse =
        Reservation.newBuilder()
            .setName(name2.toString())
            .setSlotCapacity(slotCapacity)
            .setIgnoreIdleSlots(ignoreIdleSlots)
            .build();
    mockReservationService.addResponse(expectedResponse);

    ReservationName name = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");

    Reservation actualResponse = client.getReservation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetReservationRequest actualRequest = (GetReservationRequest) actualRequests.get(0);

    Assert.assertEquals(name, ReservationName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getReservationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      ReservationName name = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");

      client.getReservation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateReservationTest() {
    ReservationName name = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
    long slotCapacity = 1516717605L;
    boolean ignoreIdleSlots = false;
    Reservation expectedResponse =
        Reservation.newBuilder()
            .setName(name.toString())
            .setSlotCapacity(slotCapacity)
            .setIgnoreIdleSlots(ignoreIdleSlots)
            .build();
    mockReservationService.addResponse(expectedResponse);

    Reservation reservation = Reservation.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Reservation actualResponse = client.updateReservation(reservation, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateReservationRequest actualRequest = (UpdateReservationRequest) actualRequests.get(0);

    Assert.assertEquals(reservation, actualRequest.getReservation());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateReservationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      Reservation reservation = Reservation.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateReservation(reservation, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createCapacityCommitmentTest() {
    CapacityCommitmentName name =
        CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]");
    long slotCount = 191518834L;
    CapacityCommitment expectedResponse =
        CapacityCommitment.newBuilder().setName(name.toString()).setSlotCount(slotCount).build();
    mockReservationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    CapacityCommitment capacityCommitment = CapacityCommitment.newBuilder().build();

    CapacityCommitment actualResponse = client.createCapacityCommitment(parent, capacityCommitment);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCapacityCommitmentRequest actualRequest =
        (CreateCapacityCommitmentRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(capacityCommitment, actualRequest.getCapacityCommitment());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createCapacityCommitmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      CapacityCommitment capacityCommitment = CapacityCommitment.newBuilder().build();

      client.createCapacityCommitment(parent, capacityCommitment);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listCapacityCommitmentsTest() {
    String nextPageToken = "";
    CapacityCommitment capacityCommitmentsElement = CapacityCommitment.newBuilder().build();
    List<CapacityCommitment> capacityCommitments = Arrays.asList(capacityCommitmentsElement);
    ListCapacityCommitmentsResponse expectedResponse =
        ListCapacityCommitmentsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllCapacityCommitments(capacityCommitments)
            .build();
    mockReservationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListCapacityCommitmentsPagedResponse pagedListResponse = client.listCapacityCommitments(parent);

    List<CapacityCommitment> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCapacityCommitmentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCapacityCommitmentsRequest actualRequest =
        (ListCapacityCommitmentsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listCapacityCommitmentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

      client.listCapacityCommitments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getCapacityCommitmentTest() {
    CapacityCommitmentName name2 =
        CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]");
    long slotCount = 191518834L;
    CapacityCommitment expectedResponse =
        CapacityCommitment.newBuilder().setName(name2.toString()).setSlotCount(slotCount).build();
    mockReservationService.addResponse(expectedResponse);

    CapacityCommitmentName name =
        CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]");

    CapacityCommitment actualResponse = client.getCapacityCommitment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCapacityCommitmentRequest actualRequest =
        (GetCapacityCommitmentRequest) actualRequests.get(0);

    Assert.assertEquals(name, CapacityCommitmentName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getCapacityCommitmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      CapacityCommitmentName name =
          CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]");

      client.getCapacityCommitment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateCapacityCommitmentTest() {
    CapacityCommitmentName name =
        CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]");
    long slotCount = 191518834L;
    CapacityCommitment expectedResponse =
        CapacityCommitment.newBuilder().setName(name.toString()).setSlotCount(slotCount).build();
    mockReservationService.addResponse(expectedResponse);

    CapacityCommitment capacityCommitment = CapacityCommitment.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CapacityCommitment actualResponse =
        client.updateCapacityCommitment(capacityCommitment, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCapacityCommitmentRequest actualRequest =
        (UpdateCapacityCommitmentRequest) actualRequests.get(0);

    Assert.assertEquals(capacityCommitment, actualRequest.getCapacityCommitment());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateCapacityCommitmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      CapacityCommitment capacityCommitment = CapacityCommitment.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateCapacityCommitment(capacityCommitment, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void splitCapacityCommitmentTest() {
    SplitCapacityCommitmentResponse expectedResponse =
        SplitCapacityCommitmentResponse.newBuilder().build();
    mockReservationService.addResponse(expectedResponse);

    CapacityCommitmentName name =
        CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]");
    long slotCount = 191518834L;

    SplitCapacityCommitmentResponse actualResponse =
        client.splitCapacityCommitment(name, slotCount);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SplitCapacityCommitmentRequest actualRequest =
        (SplitCapacityCommitmentRequest) actualRequests.get(0);

    Assert.assertEquals(name, CapacityCommitmentName.parse(actualRequest.getName()));
    Assert.assertEquals(slotCount, actualRequest.getSlotCount());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void splitCapacityCommitmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      CapacityCommitmentName name =
          CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]");
      long slotCount = 191518834L;

      client.splitCapacityCommitment(name, slotCount);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void mergeCapacityCommitmentsTest() {
    CapacityCommitmentName name =
        CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]");
    long slotCount = 191518834L;
    CapacityCommitment expectedResponse =
        CapacityCommitment.newBuilder().setName(name.toString()).setSlotCount(slotCount).build();
    mockReservationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    List<String> capacityCommitmentIds = new ArrayList<>();

    CapacityCommitment actualResponse =
        client.mergeCapacityCommitments(parent, capacityCommitmentIds);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MergeCapacityCommitmentsRequest actualRequest =
        (MergeCapacityCommitmentsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(capacityCommitmentIds, actualRequest.getCapacityCommitmentIdsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void mergeCapacityCommitmentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      List<String> capacityCommitmentIds = new ArrayList<>();

      client.mergeCapacityCommitments(parent, capacityCommitmentIds);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createAssignmentTest() {
    AssignmentName name =
        AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]");
    String assignee = "assignee-369881649";
    Assignment expectedResponse =
        Assignment.newBuilder().setName(name.toString()).setAssignee(assignee).build();
    mockReservationService.addResponse(expectedResponse);

    ReservationName parent = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
    Assignment assignment = Assignment.newBuilder().build();

    Assignment actualResponse = client.createAssignment(parent, assignment);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAssignmentRequest actualRequest = (CreateAssignmentRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ReservationName.parse(actualRequest.getParent()));
    Assert.assertEquals(assignment, actualRequest.getAssignment());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createAssignmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      ReservationName parent = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
      Assignment assignment = Assignment.newBuilder().build();

      client.createAssignment(parent, assignment);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listAssignmentsTest() {
    String nextPageToken = "";
    Assignment assignmentsElement = Assignment.newBuilder().build();
    List<Assignment> assignments = Arrays.asList(assignmentsElement);
    ListAssignmentsResponse expectedResponse =
        ListAssignmentsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllAssignments(assignments)
            .build();
    mockReservationService.addResponse(expectedResponse);

    ReservationName parent = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");

    ListAssignmentsPagedResponse pagedListResponse = client.listAssignments(parent);

    List<Assignment> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAssignmentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAssignmentsRequest actualRequest = (ListAssignmentsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ReservationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listAssignmentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      ReservationName parent = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");

      client.listAssignments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void searchAssignmentsTest() {
    String nextPageToken = "";
    Assignment assignmentsElement = Assignment.newBuilder().build();
    List<Assignment> assignments = Arrays.asList(assignmentsElement);
    SearchAssignmentsResponse expectedResponse =
        SearchAssignmentsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllAssignments(assignments)
            .build();
    mockReservationService.addResponse(expectedResponse);

    ReservationName parent = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
    String query = "query107944136";

    SearchAssignmentsPagedResponse pagedListResponse = client.searchAssignments(parent, query);

    List<Assignment> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAssignmentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchAssignmentsRequest actualRequest = (SearchAssignmentsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ReservationName.parse(actualRequest.getParent()));
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void searchAssignmentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      ReservationName parent = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
      String query = "query107944136";

      client.searchAssignments(parent, query);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void moveAssignmentTest() {
    AssignmentName name2 =
        AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]");
    String assignee = "assignee-369881649";
    Assignment expectedResponse =
        Assignment.newBuilder().setName(name2.toString()).setAssignee(assignee).build();
    mockReservationService.addResponse(expectedResponse);

    AssignmentName name =
        AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]");
    String destinationId = "destinationId912984812";

    Assignment actualResponse = client.moveAssignment(name, destinationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MoveAssignmentRequest actualRequest = (MoveAssignmentRequest) actualRequests.get(0);

    Assert.assertEquals(name, AssignmentName.parse(actualRequest.getName()));
    Assert.assertEquals(destinationId, actualRequest.getDestinationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void moveAssignmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      AssignmentName name =
          AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]");
      String destinationId = "destinationId912984812";

      client.moveAssignment(name, destinationId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getBiReservationTest() {
    BiReservationName name2 = BiReservationName.of("[PROJECT]", "[LOCATION]");
    long size = 3530753L;
    BiReservation expectedResponse =
        BiReservation.newBuilder().setName(name2.toString()).setSize(size).build();
    mockReservationService.addResponse(expectedResponse);

    BiReservationName name = BiReservationName.of("[PROJECT]", "[LOCATION]");

    BiReservation actualResponse = client.getBiReservation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBiReservationRequest actualRequest = (GetBiReservationRequest) actualRequests.get(0);

    Assert.assertEquals(name, BiReservationName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getBiReservationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      BiReservationName name = BiReservationName.of("[PROJECT]", "[LOCATION]");

      client.getBiReservation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateBiReservationTest() {
    BiReservationName name = BiReservationName.of("[PROJECT]", "[LOCATION]");
    long size = 3530753L;
    BiReservation expectedResponse =
        BiReservation.newBuilder().setName(name.toString()).setSize(size).build();
    mockReservationService.addResponse(expectedResponse);

    BiReservation biReservation = BiReservation.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    BiReservation actualResponse = client.updateBiReservation(biReservation, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBiReservationRequest actualRequest = (UpdateBiReservationRequest) actualRequests.get(0);

    Assert.assertEquals(biReservation, actualRequest.getBiReservation());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateBiReservationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      BiReservation biReservation = BiReservation.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateBiReservation(biReservation, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
