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

package com.google.cloud.bigquery.reservation.v1;

import static com.google.cloud.bigquery.reservation.v1.ReservationServiceClient.ListAssignmentsPagedResponse;
import static com.google.cloud.bigquery.reservation.v1.ReservationServiceClient.ListCapacityCommitmentsPagedResponse;
import static com.google.cloud.bigquery.reservation.v1.ReservationServiceClient.ListReservationsPagedResponse;
import static com.google.cloud.bigquery.reservation.v1.ReservationServiceClient.SearchAllAssignmentsPagedResponse;
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
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
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
public class ReservationServiceClientTest {
  private static MockReservationService mockReservationService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ReservationServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockReservationService = new MockReservationService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockReservationService));
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
  public void createReservationTest() throws Exception {
    Reservation expectedResponse =
        Reservation.newBuilder()
            .setName(ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]").toString())
            .setSlotCapacity(-1516717605)
            .setIgnoreIdleSlots(true)
            .setConcurrency(1476186003)
            .setCreationTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMultiRegionAuxiliary(true)
            .build();
    mockReservationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Reservation reservation = Reservation.newBuilder().build();
    String reservationId = "reservationId1116965383";

    Reservation actualResponse = client.createReservation(parent, reservation, reservationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateReservationRequest actualRequest = ((CreateReservationRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(reservation, actualRequest.getReservation());
    Assert.assertEquals(reservationId, actualRequest.getReservationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createReservationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Reservation reservation = Reservation.newBuilder().build();
      String reservationId = "reservationId1116965383";
      client.createReservation(parent, reservation, reservationId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createReservationTest2() throws Exception {
    Reservation expectedResponse =
        Reservation.newBuilder()
            .setName(ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]").toString())
            .setSlotCapacity(-1516717605)
            .setIgnoreIdleSlots(true)
            .setConcurrency(1476186003)
            .setCreationTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMultiRegionAuxiliary(true)
            .build();
    mockReservationService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Reservation reservation = Reservation.newBuilder().build();
    String reservationId = "reservationId1116965383";

    Reservation actualResponse = client.createReservation(parent, reservation, reservationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateReservationRequest actualRequest = ((CreateReservationRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(reservation, actualRequest.getReservation());
    Assert.assertEquals(reservationId, actualRequest.getReservationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createReservationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      String parent = "parent-995424086";
      Reservation reservation = Reservation.newBuilder().build();
      String reservationId = "reservationId1116965383";
      client.createReservation(parent, reservation, reservationId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listReservationsTest() throws Exception {
    Reservation responsesElement = Reservation.newBuilder().build();
    ListReservationsResponse expectedResponse =
        ListReservationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllReservations(Arrays.asList(responsesElement))
            .build();
    mockReservationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListReservationsPagedResponse pagedListResponse = client.listReservations(parent);

    List<Reservation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReservationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListReservationsRequest actualRequest = ((ListReservationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listReservationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listReservations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listReservationsTest2() throws Exception {
    Reservation responsesElement = Reservation.newBuilder().build();
    ListReservationsResponse expectedResponse =
        ListReservationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllReservations(Arrays.asList(responsesElement))
            .build();
    mockReservationService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListReservationsPagedResponse pagedListResponse = client.listReservations(parent);

    List<Reservation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReservationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListReservationsRequest actualRequest = ((ListReservationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listReservationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listReservations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getReservationTest() throws Exception {
    Reservation expectedResponse =
        Reservation.newBuilder()
            .setName(ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]").toString())
            .setSlotCapacity(-1516717605)
            .setIgnoreIdleSlots(true)
            .setConcurrency(1476186003)
            .setCreationTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMultiRegionAuxiliary(true)
            .build();
    mockReservationService.addResponse(expectedResponse);

    ReservationName name = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");

    Reservation actualResponse = client.getReservation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetReservationRequest actualRequest = ((GetReservationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getReservationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      ReservationName name = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
      client.getReservation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getReservationTest2() throws Exception {
    Reservation expectedResponse =
        Reservation.newBuilder()
            .setName(ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]").toString())
            .setSlotCapacity(-1516717605)
            .setIgnoreIdleSlots(true)
            .setConcurrency(1476186003)
            .setCreationTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMultiRegionAuxiliary(true)
            .build();
    mockReservationService.addResponse(expectedResponse);

    String name = "name3373707";

    Reservation actualResponse = client.getReservation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetReservationRequest actualRequest = ((GetReservationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getReservationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      String name = "name3373707";
      client.getReservation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteReservationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockReservationService.addResponse(expectedResponse);

    ReservationName name = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");

    client.deleteReservation(name);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteReservationRequest actualRequest = ((DeleteReservationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteReservationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      ReservationName name = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
      client.deleteReservation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteReservationTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockReservationService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteReservation(name);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteReservationRequest actualRequest = ((DeleteReservationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteReservationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteReservation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateReservationTest() throws Exception {
    Reservation expectedResponse =
        Reservation.newBuilder()
            .setName(ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]").toString())
            .setSlotCapacity(-1516717605)
            .setIgnoreIdleSlots(true)
            .setConcurrency(1476186003)
            .setCreationTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMultiRegionAuxiliary(true)
            .build();
    mockReservationService.addResponse(expectedResponse);

    Reservation reservation = Reservation.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Reservation actualResponse = client.updateReservation(reservation, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateReservationRequest actualRequest = ((UpdateReservationRequest) actualRequests.get(0));

    Assert.assertEquals(reservation, actualRequest.getReservation());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateReservationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      Reservation reservation = Reservation.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateReservation(reservation, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCapacityCommitmentTest() throws Exception {
    CapacityCommitment expectedResponse =
        CapacityCommitment.newBuilder()
            .setName(
                CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]")
                    .toString())
            .setSlotCount(-191518834)
            .setCommitmentStartTime(Timestamp.newBuilder().build())
            .setCommitmentEndTime(Timestamp.newBuilder().build())
            .setFailureStatus(Status.newBuilder().build())
            .setMultiRegionAuxiliary(true)
            .build();
    mockReservationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    CapacityCommitment capacityCommitment = CapacityCommitment.newBuilder().build();

    CapacityCommitment actualResponse = client.createCapacityCommitment(parent, capacityCommitment);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCapacityCommitmentRequest actualRequest =
        ((CreateCapacityCommitmentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(capacityCommitment, actualRequest.getCapacityCommitment());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCapacityCommitmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      CapacityCommitment capacityCommitment = CapacityCommitment.newBuilder().build();
      client.createCapacityCommitment(parent, capacityCommitment);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCapacityCommitmentTest2() throws Exception {
    CapacityCommitment expectedResponse =
        CapacityCommitment.newBuilder()
            .setName(
                CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]")
                    .toString())
            .setSlotCount(-191518834)
            .setCommitmentStartTime(Timestamp.newBuilder().build())
            .setCommitmentEndTime(Timestamp.newBuilder().build())
            .setFailureStatus(Status.newBuilder().build())
            .setMultiRegionAuxiliary(true)
            .build();
    mockReservationService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    CapacityCommitment capacityCommitment = CapacityCommitment.newBuilder().build();

    CapacityCommitment actualResponse = client.createCapacityCommitment(parent, capacityCommitment);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCapacityCommitmentRequest actualRequest =
        ((CreateCapacityCommitmentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(capacityCommitment, actualRequest.getCapacityCommitment());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCapacityCommitmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      String parent = "parent-995424086";
      CapacityCommitment capacityCommitment = CapacityCommitment.newBuilder().build();
      client.createCapacityCommitment(parent, capacityCommitment);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCapacityCommitmentsTest() throws Exception {
    CapacityCommitment responsesElement = CapacityCommitment.newBuilder().build();
    ListCapacityCommitmentsResponse expectedResponse =
        ListCapacityCommitmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCapacityCommitments(Arrays.asList(responsesElement))
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
        ((ListCapacityCommitmentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCapacityCommitmentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listCapacityCommitments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCapacityCommitmentsTest2() throws Exception {
    CapacityCommitment responsesElement = CapacityCommitment.newBuilder().build();
    ListCapacityCommitmentsResponse expectedResponse =
        ListCapacityCommitmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCapacityCommitments(Arrays.asList(responsesElement))
            .build();
    mockReservationService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCapacityCommitmentsPagedResponse pagedListResponse = client.listCapacityCommitments(parent);

    List<CapacityCommitment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCapacityCommitmentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCapacityCommitmentsRequest actualRequest =
        ((ListCapacityCommitmentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCapacityCommitmentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listCapacityCommitments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCapacityCommitmentTest() throws Exception {
    CapacityCommitment expectedResponse =
        CapacityCommitment.newBuilder()
            .setName(
                CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]")
                    .toString())
            .setSlotCount(-191518834)
            .setCommitmentStartTime(Timestamp.newBuilder().build())
            .setCommitmentEndTime(Timestamp.newBuilder().build())
            .setFailureStatus(Status.newBuilder().build())
            .setMultiRegionAuxiliary(true)
            .build();
    mockReservationService.addResponse(expectedResponse);

    CapacityCommitmentName name =
        CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]");

    CapacityCommitment actualResponse = client.getCapacityCommitment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCapacityCommitmentRequest actualRequest =
        ((GetCapacityCommitmentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCapacityCommitmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      CapacityCommitmentName name =
          CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]");
      client.getCapacityCommitment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCapacityCommitmentTest2() throws Exception {
    CapacityCommitment expectedResponse =
        CapacityCommitment.newBuilder()
            .setName(
                CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]")
                    .toString())
            .setSlotCount(-191518834)
            .setCommitmentStartTime(Timestamp.newBuilder().build())
            .setCommitmentEndTime(Timestamp.newBuilder().build())
            .setFailureStatus(Status.newBuilder().build())
            .setMultiRegionAuxiliary(true)
            .build();
    mockReservationService.addResponse(expectedResponse);

    String name = "name3373707";

    CapacityCommitment actualResponse = client.getCapacityCommitment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCapacityCommitmentRequest actualRequest =
        ((GetCapacityCommitmentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCapacityCommitmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      String name = "name3373707";
      client.getCapacityCommitment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCapacityCommitmentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockReservationService.addResponse(expectedResponse);

    CapacityCommitmentName name =
        CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]");

    client.deleteCapacityCommitment(name);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCapacityCommitmentRequest actualRequest =
        ((DeleteCapacityCommitmentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCapacityCommitmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      CapacityCommitmentName name =
          CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]");
      client.deleteCapacityCommitment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCapacityCommitmentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockReservationService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteCapacityCommitment(name);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCapacityCommitmentRequest actualRequest =
        ((DeleteCapacityCommitmentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCapacityCommitmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteCapacityCommitment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCapacityCommitmentTest() throws Exception {
    CapacityCommitment expectedResponse =
        CapacityCommitment.newBuilder()
            .setName(
                CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]")
                    .toString())
            .setSlotCount(-191518834)
            .setCommitmentStartTime(Timestamp.newBuilder().build())
            .setCommitmentEndTime(Timestamp.newBuilder().build())
            .setFailureStatus(Status.newBuilder().build())
            .setMultiRegionAuxiliary(true)
            .build();
    mockReservationService.addResponse(expectedResponse);

    CapacityCommitment capacityCommitment = CapacityCommitment.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CapacityCommitment actualResponse =
        client.updateCapacityCommitment(capacityCommitment, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCapacityCommitmentRequest actualRequest =
        ((UpdateCapacityCommitmentRequest) actualRequests.get(0));

    Assert.assertEquals(capacityCommitment, actualRequest.getCapacityCommitment());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateCapacityCommitmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      CapacityCommitment capacityCommitment = CapacityCommitment.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCapacityCommitment(capacityCommitment, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void splitCapacityCommitmentTest() throws Exception {
    SplitCapacityCommitmentResponse expectedResponse =
        SplitCapacityCommitmentResponse.newBuilder()
            .setFirst(CapacityCommitment.newBuilder().build())
            .setSecond(CapacityCommitment.newBuilder().build())
            .build();
    mockReservationService.addResponse(expectedResponse);

    CapacityCommitmentName name =
        CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]");
    long slotCount = -191518834;

    SplitCapacityCommitmentResponse actualResponse =
        client.splitCapacityCommitment(name, slotCount);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SplitCapacityCommitmentRequest actualRequest =
        ((SplitCapacityCommitmentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(slotCount, actualRequest.getSlotCount());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void splitCapacityCommitmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      CapacityCommitmentName name =
          CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]");
      long slotCount = -191518834;
      client.splitCapacityCommitment(name, slotCount);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void splitCapacityCommitmentTest2() throws Exception {
    SplitCapacityCommitmentResponse expectedResponse =
        SplitCapacityCommitmentResponse.newBuilder()
            .setFirst(CapacityCommitment.newBuilder().build())
            .setSecond(CapacityCommitment.newBuilder().build())
            .build();
    mockReservationService.addResponse(expectedResponse);

    String name = "name3373707";
    long slotCount = -191518834;

    SplitCapacityCommitmentResponse actualResponse =
        client.splitCapacityCommitment(name, slotCount);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SplitCapacityCommitmentRequest actualRequest =
        ((SplitCapacityCommitmentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(slotCount, actualRequest.getSlotCount());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void splitCapacityCommitmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      String name = "name3373707";
      long slotCount = -191518834;
      client.splitCapacityCommitment(name, slotCount);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void mergeCapacityCommitmentsTest() throws Exception {
    CapacityCommitment expectedResponse =
        CapacityCommitment.newBuilder()
            .setName(
                CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]")
                    .toString())
            .setSlotCount(-191518834)
            .setCommitmentStartTime(Timestamp.newBuilder().build())
            .setCommitmentEndTime(Timestamp.newBuilder().build())
            .setFailureStatus(Status.newBuilder().build())
            .setMultiRegionAuxiliary(true)
            .build();
    mockReservationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    List<String> capacityCommitmentIds = new ArrayList<>();

    CapacityCommitment actualResponse =
        client.mergeCapacityCommitments(parent, capacityCommitmentIds);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MergeCapacityCommitmentsRequest actualRequest =
        ((MergeCapacityCommitmentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(capacityCommitmentIds, actualRequest.getCapacityCommitmentIdsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void mergeCapacityCommitmentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      List<String> capacityCommitmentIds = new ArrayList<>();
      client.mergeCapacityCommitments(parent, capacityCommitmentIds);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void mergeCapacityCommitmentsTest2() throws Exception {
    CapacityCommitment expectedResponse =
        CapacityCommitment.newBuilder()
            .setName(
                CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]")
                    .toString())
            .setSlotCount(-191518834)
            .setCommitmentStartTime(Timestamp.newBuilder().build())
            .setCommitmentEndTime(Timestamp.newBuilder().build())
            .setFailureStatus(Status.newBuilder().build())
            .setMultiRegionAuxiliary(true)
            .build();
    mockReservationService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    List<String> capacityCommitmentIds = new ArrayList<>();

    CapacityCommitment actualResponse =
        client.mergeCapacityCommitments(parent, capacityCommitmentIds);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MergeCapacityCommitmentsRequest actualRequest =
        ((MergeCapacityCommitmentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(capacityCommitmentIds, actualRequest.getCapacityCommitmentIdsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void mergeCapacityCommitmentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      String parent = "parent-995424086";
      List<String> capacityCommitmentIds = new ArrayList<>();
      client.mergeCapacityCommitments(parent, capacityCommitmentIds);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAssignmentTest() throws Exception {
    Assignment expectedResponse =
        Assignment.newBuilder()
            .setName(
                AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]")
                    .toString())
            .setAssignee("assignee-369881649")
            .build();
    mockReservationService.addResponse(expectedResponse);

    ReservationName parent = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
    Assignment assignment = Assignment.newBuilder().build();

    Assignment actualResponse = client.createAssignment(parent, assignment);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAssignmentRequest actualRequest = ((CreateAssignmentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(assignment, actualRequest.getAssignment());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAssignmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      ReservationName parent = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
      Assignment assignment = Assignment.newBuilder().build();
      client.createAssignment(parent, assignment);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAssignmentTest2() throws Exception {
    Assignment expectedResponse =
        Assignment.newBuilder()
            .setName(
                AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]")
                    .toString())
            .setAssignee("assignee-369881649")
            .build();
    mockReservationService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Assignment assignment = Assignment.newBuilder().build();

    Assignment actualResponse = client.createAssignment(parent, assignment);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAssignmentRequest actualRequest = ((CreateAssignmentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(assignment, actualRequest.getAssignment());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAssignmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      String parent = "parent-995424086";
      Assignment assignment = Assignment.newBuilder().build();
      client.createAssignment(parent, assignment);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAssignmentsTest() throws Exception {
    Assignment responsesElement = Assignment.newBuilder().build();
    ListAssignmentsResponse expectedResponse =
        ListAssignmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAssignments(Arrays.asList(responsesElement))
            .build();
    mockReservationService.addResponse(expectedResponse);

    ReservationName parent = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");

    ListAssignmentsPagedResponse pagedListResponse = client.listAssignments(parent);

    List<Assignment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAssignmentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAssignmentsRequest actualRequest = ((ListAssignmentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAssignmentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      ReservationName parent = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
      client.listAssignments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAssignmentsTest2() throws Exception {
    Assignment responsesElement = Assignment.newBuilder().build();
    ListAssignmentsResponse expectedResponse =
        ListAssignmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAssignments(Arrays.asList(responsesElement))
            .build();
    mockReservationService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAssignmentsPagedResponse pagedListResponse = client.listAssignments(parent);

    List<Assignment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAssignmentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAssignmentsRequest actualRequest = ((ListAssignmentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAssignmentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAssignments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAssignmentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockReservationService.addResponse(expectedResponse);

    AssignmentName name =
        AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]");

    client.deleteAssignment(name);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAssignmentRequest actualRequest = ((DeleteAssignmentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAssignmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      AssignmentName name =
          AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]");
      client.deleteAssignment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAssignmentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockReservationService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteAssignment(name);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAssignmentRequest actualRequest = ((DeleteAssignmentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAssignmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAssignment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchAssignmentsTest() throws Exception {
    Assignment responsesElement = Assignment.newBuilder().build();
    SearchAssignmentsResponse expectedResponse =
        SearchAssignmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAssignments(Arrays.asList(responsesElement))
            .build();
    mockReservationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String query = "query107944136";

    SearchAssignmentsPagedResponse pagedListResponse = client.searchAssignments(parent, query);

    List<Assignment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAssignmentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchAssignmentsRequest actualRequest = ((SearchAssignmentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchAssignmentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String query = "query107944136";
      client.searchAssignments(parent, query);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchAssignmentsTest2() throws Exception {
    Assignment responsesElement = Assignment.newBuilder().build();
    SearchAssignmentsResponse expectedResponse =
        SearchAssignmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAssignments(Arrays.asList(responsesElement))
            .build();
    mockReservationService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String query = "query107944136";

    SearchAssignmentsPagedResponse pagedListResponse = client.searchAssignments(parent, query);

    List<Assignment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAssignmentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchAssignmentsRequest actualRequest = ((SearchAssignmentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchAssignmentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      String parent = "parent-995424086";
      String query = "query107944136";
      client.searchAssignments(parent, query);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchAllAssignmentsTest() throws Exception {
    Assignment responsesElement = Assignment.newBuilder().build();
    SearchAllAssignmentsResponse expectedResponse =
        SearchAllAssignmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAssignments(Arrays.asList(responsesElement))
            .build();
    mockReservationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String query = "query107944136";

    SearchAllAssignmentsPagedResponse pagedListResponse =
        client.searchAllAssignments(parent, query);

    List<Assignment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAssignmentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchAllAssignmentsRequest actualRequest =
        ((SearchAllAssignmentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchAllAssignmentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String query = "query107944136";
      client.searchAllAssignments(parent, query);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchAllAssignmentsTest2() throws Exception {
    Assignment responsesElement = Assignment.newBuilder().build();
    SearchAllAssignmentsResponse expectedResponse =
        SearchAllAssignmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAssignments(Arrays.asList(responsesElement))
            .build();
    mockReservationService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String query = "query107944136";

    SearchAllAssignmentsPagedResponse pagedListResponse =
        client.searchAllAssignments(parent, query);

    List<Assignment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAssignmentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchAllAssignmentsRequest actualRequest =
        ((SearchAllAssignmentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchAllAssignmentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      String parent = "parent-995424086";
      String query = "query107944136";
      client.searchAllAssignments(parent, query);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void moveAssignmentTest() throws Exception {
    Assignment expectedResponse =
        Assignment.newBuilder()
            .setName(
                AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]")
                    .toString())
            .setAssignee("assignee-369881649")
            .build();
    mockReservationService.addResponse(expectedResponse);

    AssignmentName name =
        AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]");
    ReservationName destinationId = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");

    Assignment actualResponse = client.moveAssignment(name, destinationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MoveAssignmentRequest actualRequest = ((MoveAssignmentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(destinationId.toString(), actualRequest.getDestinationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void moveAssignmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      AssignmentName name =
          AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]");
      ReservationName destinationId =
          ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
      client.moveAssignment(name, destinationId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void moveAssignmentTest2() throws Exception {
    Assignment expectedResponse =
        Assignment.newBuilder()
            .setName(
                AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]")
                    .toString())
            .setAssignee("assignee-369881649")
            .build();
    mockReservationService.addResponse(expectedResponse);

    AssignmentName name =
        AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]");
    String destinationId = "destinationId306545097";

    Assignment actualResponse = client.moveAssignment(name, destinationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MoveAssignmentRequest actualRequest = ((MoveAssignmentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(destinationId, actualRequest.getDestinationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void moveAssignmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      AssignmentName name =
          AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]");
      String destinationId = "destinationId306545097";
      client.moveAssignment(name, destinationId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void moveAssignmentTest3() throws Exception {
    Assignment expectedResponse =
        Assignment.newBuilder()
            .setName(
                AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]")
                    .toString())
            .setAssignee("assignee-369881649")
            .build();
    mockReservationService.addResponse(expectedResponse);

    String name = "name3373707";
    ReservationName destinationId = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");

    Assignment actualResponse = client.moveAssignment(name, destinationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MoveAssignmentRequest actualRequest = ((MoveAssignmentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(destinationId.toString(), actualRequest.getDestinationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void moveAssignmentExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      String name = "name3373707";
      ReservationName destinationId =
          ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
      client.moveAssignment(name, destinationId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void moveAssignmentTest4() throws Exception {
    Assignment expectedResponse =
        Assignment.newBuilder()
            .setName(
                AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]")
                    .toString())
            .setAssignee("assignee-369881649")
            .build();
    mockReservationService.addResponse(expectedResponse);

    String name = "name3373707";
    String destinationId = "destinationId306545097";

    Assignment actualResponse = client.moveAssignment(name, destinationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MoveAssignmentRequest actualRequest = ((MoveAssignmentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(destinationId, actualRequest.getDestinationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void moveAssignmentExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      String name = "name3373707";
      String destinationId = "destinationId306545097";
      client.moveAssignment(name, destinationId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAssignmentTest() throws Exception {
    Assignment expectedResponse =
        Assignment.newBuilder()
            .setName(
                AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]")
                    .toString())
            .setAssignee("assignee-369881649")
            .build();
    mockReservationService.addResponse(expectedResponse);

    Assignment assignment = Assignment.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Assignment actualResponse = client.updateAssignment(assignment, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAssignmentRequest actualRequest = ((UpdateAssignmentRequest) actualRequests.get(0));

    Assert.assertEquals(assignment, actualRequest.getAssignment());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAssignmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      Assignment assignment = Assignment.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAssignment(assignment, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBiReservationTest() throws Exception {
    BiReservation expectedResponse =
        BiReservation.newBuilder()
            .setName(BiReservationName.of("[PROJECT]", "[LOCATION]").toString())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSize(3530753)
            .addAllPreferredTables(new ArrayList<TableReference>())
            .build();
    mockReservationService.addResponse(expectedResponse);

    BiReservationName name = BiReservationName.of("[PROJECT]", "[LOCATION]");

    BiReservation actualResponse = client.getBiReservation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBiReservationRequest actualRequest = ((GetBiReservationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBiReservationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      BiReservationName name = BiReservationName.of("[PROJECT]", "[LOCATION]");
      client.getBiReservation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBiReservationTest2() throws Exception {
    BiReservation expectedResponse =
        BiReservation.newBuilder()
            .setName(BiReservationName.of("[PROJECT]", "[LOCATION]").toString())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSize(3530753)
            .addAllPreferredTables(new ArrayList<TableReference>())
            .build();
    mockReservationService.addResponse(expectedResponse);

    String name = "name3373707";

    BiReservation actualResponse = client.getBiReservation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBiReservationRequest actualRequest = ((GetBiReservationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBiReservationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      String name = "name3373707";
      client.getBiReservation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateBiReservationTest() throws Exception {
    BiReservation expectedResponse =
        BiReservation.newBuilder()
            .setName(BiReservationName.of("[PROJECT]", "[LOCATION]").toString())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSize(3530753)
            .addAllPreferredTables(new ArrayList<TableReference>())
            .build();
    mockReservationService.addResponse(expectedResponse);

    BiReservation biReservation = BiReservation.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    BiReservation actualResponse = client.updateBiReservation(biReservation, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReservationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBiReservationRequest actualRequest = ((UpdateBiReservationRequest) actualRequests.get(0));

    Assert.assertEquals(biReservation, actualRequest.getBiReservation());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateBiReservationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReservationService.addException(exception);

    try {
      BiReservation biReservation = BiReservation.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBiReservation(biReservation, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
