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

package com.google.cloud.bigquery.reservation.v1.stub;

import static com.google.cloud.bigquery.reservation.v1.ReservationServiceClient.ListAssignmentsPagedResponse;
import static com.google.cloud.bigquery.reservation.v1.ReservationServiceClient.ListCapacityCommitmentsPagedResponse;
import static com.google.cloud.bigquery.reservation.v1.ReservationServiceClient.ListReservationGroupsPagedResponse;
import static com.google.cloud.bigquery.reservation.v1.ReservationServiceClient.ListReservationsPagedResponse;
import static com.google.cloud.bigquery.reservation.v1.ReservationServiceClient.SearchAllAssignmentsPagedResponse;
import static com.google.cloud.bigquery.reservation.v1.ReservationServiceClient.SearchAssignmentsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.reservation.v1.Assignment;
import com.google.cloud.bigquery.reservation.v1.BiReservation;
import com.google.cloud.bigquery.reservation.v1.CapacityCommitment;
import com.google.cloud.bigquery.reservation.v1.CreateAssignmentRequest;
import com.google.cloud.bigquery.reservation.v1.CreateCapacityCommitmentRequest;
import com.google.cloud.bigquery.reservation.v1.CreateReservationGroupRequest;
import com.google.cloud.bigquery.reservation.v1.CreateReservationRequest;
import com.google.cloud.bigquery.reservation.v1.DeleteAssignmentRequest;
import com.google.cloud.bigquery.reservation.v1.DeleteCapacityCommitmentRequest;
import com.google.cloud.bigquery.reservation.v1.DeleteReservationGroupRequest;
import com.google.cloud.bigquery.reservation.v1.DeleteReservationRequest;
import com.google.cloud.bigquery.reservation.v1.FailoverReservationRequest;
import com.google.cloud.bigquery.reservation.v1.GetBiReservationRequest;
import com.google.cloud.bigquery.reservation.v1.GetCapacityCommitmentRequest;
import com.google.cloud.bigquery.reservation.v1.GetReservationGroupRequest;
import com.google.cloud.bigquery.reservation.v1.GetReservationRequest;
import com.google.cloud.bigquery.reservation.v1.ListAssignmentsRequest;
import com.google.cloud.bigquery.reservation.v1.ListAssignmentsResponse;
import com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsRequest;
import com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsResponse;
import com.google.cloud.bigquery.reservation.v1.ListReservationGroupsRequest;
import com.google.cloud.bigquery.reservation.v1.ListReservationGroupsResponse;
import com.google.cloud.bigquery.reservation.v1.ListReservationsRequest;
import com.google.cloud.bigquery.reservation.v1.ListReservationsResponse;
import com.google.cloud.bigquery.reservation.v1.MergeCapacityCommitmentsRequest;
import com.google.cloud.bigquery.reservation.v1.MoveAssignmentRequest;
import com.google.cloud.bigquery.reservation.v1.Reservation;
import com.google.cloud.bigquery.reservation.v1.ReservationGroup;
import com.google.cloud.bigquery.reservation.v1.SearchAllAssignmentsRequest;
import com.google.cloud.bigquery.reservation.v1.SearchAllAssignmentsResponse;
import com.google.cloud.bigquery.reservation.v1.SearchAssignmentsRequest;
import com.google.cloud.bigquery.reservation.v1.SearchAssignmentsResponse;
import com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentRequest;
import com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentResponse;
import com.google.cloud.bigquery.reservation.v1.UpdateAssignmentRequest;
import com.google.cloud.bigquery.reservation.v1.UpdateBiReservationRequest;
import com.google.cloud.bigquery.reservation.v1.UpdateCapacityCommitmentRequest;
import com.google.cloud.bigquery.reservation.v1.UpdateReservationRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ReservationService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcReservationServiceStub extends ReservationServiceStub {
  private static final MethodDescriptor<CreateReservationRequest, Reservation>
      createReservationMethodDescriptor =
          MethodDescriptor.<CreateReservationRequest, Reservation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/CreateReservation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Reservation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListReservationsRequest, ListReservationsResponse>
      listReservationsMethodDescriptor =
          MethodDescriptor.<ListReservationsRequest, ListReservationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/ListReservations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListReservationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListReservationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetReservationRequest, Reservation>
      getReservationMethodDescriptor =
          MethodDescriptor.<GetReservationRequest, Reservation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/GetReservation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Reservation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteReservationRequest, Empty>
      deleteReservationMethodDescriptor =
          MethodDescriptor.<DeleteReservationRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/DeleteReservation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateReservationRequest, Reservation>
      updateReservationMethodDescriptor =
          MethodDescriptor.<UpdateReservationRequest, Reservation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/UpdateReservation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Reservation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<FailoverReservationRequest, Reservation>
      failoverReservationMethodDescriptor =
          MethodDescriptor.<FailoverReservationRequest, Reservation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/FailoverReservation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FailoverReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Reservation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateCapacityCommitmentRequest, CapacityCommitment>
      createCapacityCommitmentMethodDescriptor =
          MethodDescriptor.<CreateCapacityCommitmentRequest, CapacityCommitment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/CreateCapacityCommitment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCapacityCommitmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CapacityCommitment.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListCapacityCommitmentsRequest, ListCapacityCommitmentsResponse>
      listCapacityCommitmentsMethodDescriptor =
          MethodDescriptor
              .<ListCapacityCommitmentsRequest, ListCapacityCommitmentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/ListCapacityCommitments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCapacityCommitmentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCapacityCommitmentsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetCapacityCommitmentRequest, CapacityCommitment>
      getCapacityCommitmentMethodDescriptor =
          MethodDescriptor.<GetCapacityCommitmentRequest, CapacityCommitment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/GetCapacityCommitment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCapacityCommitmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CapacityCommitment.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteCapacityCommitmentRequest, Empty>
      deleteCapacityCommitmentMethodDescriptor =
          MethodDescriptor.<DeleteCapacityCommitmentRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/DeleteCapacityCommitment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteCapacityCommitmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateCapacityCommitmentRequest, CapacityCommitment>
      updateCapacityCommitmentMethodDescriptor =
          MethodDescriptor.<UpdateCapacityCommitmentRequest, CapacityCommitment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/UpdateCapacityCommitment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCapacityCommitmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CapacityCommitment.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          SplitCapacityCommitmentRequest, SplitCapacityCommitmentResponse>
      splitCapacityCommitmentMethodDescriptor =
          MethodDescriptor
              .<SplitCapacityCommitmentRequest, SplitCapacityCommitmentResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/SplitCapacityCommitment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SplitCapacityCommitmentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SplitCapacityCommitmentResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<MergeCapacityCommitmentsRequest, CapacityCommitment>
      mergeCapacityCommitmentsMethodDescriptor =
          MethodDescriptor.<MergeCapacityCommitmentsRequest, CapacityCommitment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/MergeCapacityCommitments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(MergeCapacityCommitmentsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CapacityCommitment.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateAssignmentRequest, Assignment>
      createAssignmentMethodDescriptor =
          MethodDescriptor.<CreateAssignmentRequest, Assignment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/CreateAssignment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAssignmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Assignment.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListAssignmentsRequest, ListAssignmentsResponse>
      listAssignmentsMethodDescriptor =
          MethodDescriptor.<ListAssignmentsRequest, ListAssignmentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/ListAssignments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAssignmentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAssignmentsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteAssignmentRequest, Empty>
      deleteAssignmentMethodDescriptor =
          MethodDescriptor.<DeleteAssignmentRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/DeleteAssignment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAssignmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SearchAssignmentsRequest, SearchAssignmentsResponse>
      searchAssignmentsMethodDescriptor =
          MethodDescriptor.<SearchAssignmentsRequest, SearchAssignmentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/SearchAssignments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchAssignmentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchAssignmentsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SearchAllAssignmentsRequest, SearchAllAssignmentsResponse>
      searchAllAssignmentsMethodDescriptor =
          MethodDescriptor.<SearchAllAssignmentsRequest, SearchAllAssignmentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/SearchAllAssignments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchAllAssignmentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchAllAssignmentsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<MoveAssignmentRequest, Assignment>
      moveAssignmentMethodDescriptor =
          MethodDescriptor.<MoveAssignmentRequest, Assignment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/MoveAssignment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(MoveAssignmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Assignment.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateAssignmentRequest, Assignment>
      updateAssignmentMethodDescriptor =
          MethodDescriptor.<UpdateAssignmentRequest, Assignment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/UpdateAssignment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAssignmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Assignment.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetBiReservationRequest, BiReservation>
      getBiReservationMethodDescriptor =
          MethodDescriptor.<GetBiReservationRequest, BiReservation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/GetBiReservation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetBiReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BiReservation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateBiReservationRequest, BiReservation>
      updateBiReservationMethodDescriptor =
          MethodDescriptor.<UpdateBiReservationRequest, BiReservation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/UpdateBiReservation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateBiReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BiReservation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.bigquery.reservation.v1.ReservationService/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.bigquery.reservation.v1.ReservationService/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateReservationGroupRequest, ReservationGroup>
      createReservationGroupMethodDescriptor =
          MethodDescriptor.<CreateReservationGroupRequest, ReservationGroup>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/CreateReservationGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateReservationGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ReservationGroup.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetReservationGroupRequest, ReservationGroup>
      getReservationGroupMethodDescriptor =
          MethodDescriptor.<GetReservationGroupRequest, ReservationGroup>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/GetReservationGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetReservationGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ReservationGroup.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteReservationGroupRequest, Empty>
      deleteReservationGroupMethodDescriptor =
          MethodDescriptor.<DeleteReservationGroupRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/DeleteReservationGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteReservationGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListReservationGroupsRequest, ListReservationGroupsResponse>
      listReservationGroupsMethodDescriptor =
          MethodDescriptor.<ListReservationGroupsRequest, ListReservationGroupsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/ListReservationGroups")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListReservationGroupsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListReservationGroupsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<CreateReservationRequest, Reservation> createReservationCallable;
  private final UnaryCallable<ListReservationsRequest, ListReservationsResponse>
      listReservationsCallable;
  private final UnaryCallable<ListReservationsRequest, ListReservationsPagedResponse>
      listReservationsPagedCallable;
  private final UnaryCallable<GetReservationRequest, Reservation> getReservationCallable;
  private final UnaryCallable<DeleteReservationRequest, Empty> deleteReservationCallable;
  private final UnaryCallable<UpdateReservationRequest, Reservation> updateReservationCallable;
  private final UnaryCallable<FailoverReservationRequest, Reservation> failoverReservationCallable;
  private final UnaryCallable<CreateCapacityCommitmentRequest, CapacityCommitment>
      createCapacityCommitmentCallable;
  private final UnaryCallable<ListCapacityCommitmentsRequest, ListCapacityCommitmentsResponse>
      listCapacityCommitmentsCallable;
  private final UnaryCallable<ListCapacityCommitmentsRequest, ListCapacityCommitmentsPagedResponse>
      listCapacityCommitmentsPagedCallable;
  private final UnaryCallable<GetCapacityCommitmentRequest, CapacityCommitment>
      getCapacityCommitmentCallable;
  private final UnaryCallable<DeleteCapacityCommitmentRequest, Empty>
      deleteCapacityCommitmentCallable;
  private final UnaryCallable<UpdateCapacityCommitmentRequest, CapacityCommitment>
      updateCapacityCommitmentCallable;
  private final UnaryCallable<SplitCapacityCommitmentRequest, SplitCapacityCommitmentResponse>
      splitCapacityCommitmentCallable;
  private final UnaryCallable<MergeCapacityCommitmentsRequest, CapacityCommitment>
      mergeCapacityCommitmentsCallable;
  private final UnaryCallable<CreateAssignmentRequest, Assignment> createAssignmentCallable;
  private final UnaryCallable<ListAssignmentsRequest, ListAssignmentsResponse>
      listAssignmentsCallable;
  private final UnaryCallable<ListAssignmentsRequest, ListAssignmentsPagedResponse>
      listAssignmentsPagedCallable;
  private final UnaryCallable<DeleteAssignmentRequest, Empty> deleteAssignmentCallable;
  private final UnaryCallable<SearchAssignmentsRequest, SearchAssignmentsResponse>
      searchAssignmentsCallable;
  private final UnaryCallable<SearchAssignmentsRequest, SearchAssignmentsPagedResponse>
      searchAssignmentsPagedCallable;
  private final UnaryCallable<SearchAllAssignmentsRequest, SearchAllAssignmentsResponse>
      searchAllAssignmentsCallable;
  private final UnaryCallable<SearchAllAssignmentsRequest, SearchAllAssignmentsPagedResponse>
      searchAllAssignmentsPagedCallable;
  private final UnaryCallable<MoveAssignmentRequest, Assignment> moveAssignmentCallable;
  private final UnaryCallable<UpdateAssignmentRequest, Assignment> updateAssignmentCallable;
  private final UnaryCallable<GetBiReservationRequest, BiReservation> getBiReservationCallable;
  private final UnaryCallable<UpdateBiReservationRequest, BiReservation>
      updateBiReservationCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;
  private final UnaryCallable<CreateReservationGroupRequest, ReservationGroup>
      createReservationGroupCallable;
  private final UnaryCallable<GetReservationGroupRequest, ReservationGroup>
      getReservationGroupCallable;
  private final UnaryCallable<DeleteReservationGroupRequest, Empty> deleteReservationGroupCallable;
  private final UnaryCallable<ListReservationGroupsRequest, ListReservationGroupsResponse>
      listReservationGroupsCallable;
  private final UnaryCallable<ListReservationGroupsRequest, ListReservationGroupsPagedResponse>
      listReservationGroupsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcReservationServiceStub create(ReservationServiceStubSettings settings)
      throws IOException {
    return new GrpcReservationServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcReservationServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcReservationServiceStub(
        ReservationServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcReservationServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcReservationServiceStub(
        ReservationServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcReservationServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcReservationServiceStub(
      ReservationServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcReservationServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcReservationServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcReservationServiceStub(
      ReservationServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateReservationRequest, Reservation> createReservationTransportSettings =
        GrpcCallSettings.<CreateReservationRequest, Reservation>newBuilder()
            .setMethodDescriptor(createReservationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListReservationsRequest, ListReservationsResponse>
        listReservationsTransportSettings =
            GrpcCallSettings.<ListReservationsRequest, ListReservationsResponse>newBuilder()
                .setMethodDescriptor(listReservationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetReservationRequest, Reservation> getReservationTransportSettings =
        GrpcCallSettings.<GetReservationRequest, Reservation>newBuilder()
            .setMethodDescriptor(getReservationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteReservationRequest, Empty> deleteReservationTransportSettings =
        GrpcCallSettings.<DeleteReservationRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteReservationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateReservationRequest, Reservation> updateReservationTransportSettings =
        GrpcCallSettings.<UpdateReservationRequest, Reservation>newBuilder()
            .setMethodDescriptor(updateReservationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "reservation.name", String.valueOf(request.getReservation().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<FailoverReservationRequest, Reservation> failoverReservationTransportSettings =
        GrpcCallSettings.<FailoverReservationRequest, Reservation>newBuilder()
            .setMethodDescriptor(failoverReservationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateCapacityCommitmentRequest, CapacityCommitment>
        createCapacityCommitmentTransportSettings =
            GrpcCallSettings.<CreateCapacityCommitmentRequest, CapacityCommitment>newBuilder()
                .setMethodDescriptor(createCapacityCommitmentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListCapacityCommitmentsRequest, ListCapacityCommitmentsResponse>
        listCapacityCommitmentsTransportSettings =
            GrpcCallSettings
                .<ListCapacityCommitmentsRequest, ListCapacityCommitmentsResponse>newBuilder()
                .setMethodDescriptor(listCapacityCommitmentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetCapacityCommitmentRequest, CapacityCommitment>
        getCapacityCommitmentTransportSettings =
            GrpcCallSettings.<GetCapacityCommitmentRequest, CapacityCommitment>newBuilder()
                .setMethodDescriptor(getCapacityCommitmentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteCapacityCommitmentRequest, Empty>
        deleteCapacityCommitmentTransportSettings =
            GrpcCallSettings.<DeleteCapacityCommitmentRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteCapacityCommitmentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateCapacityCommitmentRequest, CapacityCommitment>
        updateCapacityCommitmentTransportSettings =
            GrpcCallSettings.<UpdateCapacityCommitmentRequest, CapacityCommitment>newBuilder()
                .setMethodDescriptor(updateCapacityCommitmentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "capacity_commitment.name",
                          String.valueOf(request.getCapacityCommitment().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<SplitCapacityCommitmentRequest, SplitCapacityCommitmentResponse>
        splitCapacityCommitmentTransportSettings =
            GrpcCallSettings
                .<SplitCapacityCommitmentRequest, SplitCapacityCommitmentResponse>newBuilder()
                .setMethodDescriptor(splitCapacityCommitmentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<MergeCapacityCommitmentsRequest, CapacityCommitment>
        mergeCapacityCommitmentsTransportSettings =
            GrpcCallSettings.<MergeCapacityCommitmentsRequest, CapacityCommitment>newBuilder()
                .setMethodDescriptor(mergeCapacityCommitmentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateAssignmentRequest, Assignment> createAssignmentTransportSettings =
        GrpcCallSettings.<CreateAssignmentRequest, Assignment>newBuilder()
            .setMethodDescriptor(createAssignmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListAssignmentsRequest, ListAssignmentsResponse>
        listAssignmentsTransportSettings =
            GrpcCallSettings.<ListAssignmentsRequest, ListAssignmentsResponse>newBuilder()
                .setMethodDescriptor(listAssignmentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteAssignmentRequest, Empty> deleteAssignmentTransportSettings =
        GrpcCallSettings.<DeleteAssignmentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAssignmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SearchAssignmentsRequest, SearchAssignmentsResponse>
        searchAssignmentsTransportSettings =
            GrpcCallSettings.<SearchAssignmentsRequest, SearchAssignmentsResponse>newBuilder()
                .setMethodDescriptor(searchAssignmentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<SearchAllAssignmentsRequest, SearchAllAssignmentsResponse>
        searchAllAssignmentsTransportSettings =
            GrpcCallSettings.<SearchAllAssignmentsRequest, SearchAllAssignmentsResponse>newBuilder()
                .setMethodDescriptor(searchAllAssignmentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<MoveAssignmentRequest, Assignment> moveAssignmentTransportSettings =
        GrpcCallSettings.<MoveAssignmentRequest, Assignment>newBuilder()
            .setMethodDescriptor(moveAssignmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateAssignmentRequest, Assignment> updateAssignmentTransportSettings =
        GrpcCallSettings.<UpdateAssignmentRequest, Assignment>newBuilder()
            .setMethodDescriptor(updateAssignmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("assignment.name", String.valueOf(request.getAssignment().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetBiReservationRequest, BiReservation> getBiReservationTransportSettings =
        GrpcCallSettings.<GetBiReservationRequest, BiReservation>newBuilder()
            .setMethodDescriptor(getBiReservationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateBiReservationRequest, BiReservation>
        updateBiReservationTransportSettings =
            GrpcCallSettings.<UpdateBiReservationRequest, BiReservation>newBuilder()
                .setMethodDescriptor(updateBiReservationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "bi_reservation.name",
                          String.valueOf(request.getBiReservation().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateReservationGroupRequest, ReservationGroup>
        createReservationGroupTransportSettings =
            GrpcCallSettings.<CreateReservationGroupRequest, ReservationGroup>newBuilder()
                .setMethodDescriptor(createReservationGroupMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetReservationGroupRequest, ReservationGroup>
        getReservationGroupTransportSettings =
            GrpcCallSettings.<GetReservationGroupRequest, ReservationGroup>newBuilder()
                .setMethodDescriptor(getReservationGroupMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteReservationGroupRequest, Empty> deleteReservationGroupTransportSettings =
        GrpcCallSettings.<DeleteReservationGroupRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteReservationGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListReservationGroupsRequest, ListReservationGroupsResponse>
        listReservationGroupsTransportSettings =
            GrpcCallSettings
                .<ListReservationGroupsRequest, ListReservationGroupsResponse>newBuilder()
                .setMethodDescriptor(listReservationGroupsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.createReservationCallable =
        callableFactory.createUnaryCallable(
            createReservationTransportSettings,
            settings.createReservationSettings(),
            clientContext);
    this.listReservationsCallable =
        callableFactory.createUnaryCallable(
            listReservationsTransportSettings, settings.listReservationsSettings(), clientContext);
    this.listReservationsPagedCallable =
        callableFactory.createPagedCallable(
            listReservationsTransportSettings, settings.listReservationsSettings(), clientContext);
    this.getReservationCallable =
        callableFactory.createUnaryCallable(
            getReservationTransportSettings, settings.getReservationSettings(), clientContext);
    this.deleteReservationCallable =
        callableFactory.createUnaryCallable(
            deleteReservationTransportSettings,
            settings.deleteReservationSettings(),
            clientContext);
    this.updateReservationCallable =
        callableFactory.createUnaryCallable(
            updateReservationTransportSettings,
            settings.updateReservationSettings(),
            clientContext);
    this.failoverReservationCallable =
        callableFactory.createUnaryCallable(
            failoverReservationTransportSettings,
            settings.failoverReservationSettings(),
            clientContext);
    this.createCapacityCommitmentCallable =
        callableFactory.createUnaryCallable(
            createCapacityCommitmentTransportSettings,
            settings.createCapacityCommitmentSettings(),
            clientContext);
    this.listCapacityCommitmentsCallable =
        callableFactory.createUnaryCallable(
            listCapacityCommitmentsTransportSettings,
            settings.listCapacityCommitmentsSettings(),
            clientContext);
    this.listCapacityCommitmentsPagedCallable =
        callableFactory.createPagedCallable(
            listCapacityCommitmentsTransportSettings,
            settings.listCapacityCommitmentsSettings(),
            clientContext);
    this.getCapacityCommitmentCallable =
        callableFactory.createUnaryCallable(
            getCapacityCommitmentTransportSettings,
            settings.getCapacityCommitmentSettings(),
            clientContext);
    this.deleteCapacityCommitmentCallable =
        callableFactory.createUnaryCallable(
            deleteCapacityCommitmentTransportSettings,
            settings.deleteCapacityCommitmentSettings(),
            clientContext);
    this.updateCapacityCommitmentCallable =
        callableFactory.createUnaryCallable(
            updateCapacityCommitmentTransportSettings,
            settings.updateCapacityCommitmentSettings(),
            clientContext);
    this.splitCapacityCommitmentCallable =
        callableFactory.createUnaryCallable(
            splitCapacityCommitmentTransportSettings,
            settings.splitCapacityCommitmentSettings(),
            clientContext);
    this.mergeCapacityCommitmentsCallable =
        callableFactory.createUnaryCallable(
            mergeCapacityCommitmentsTransportSettings,
            settings.mergeCapacityCommitmentsSettings(),
            clientContext);
    this.createAssignmentCallable =
        callableFactory.createUnaryCallable(
            createAssignmentTransportSettings, settings.createAssignmentSettings(), clientContext);
    this.listAssignmentsCallable =
        callableFactory.createUnaryCallable(
            listAssignmentsTransportSettings, settings.listAssignmentsSettings(), clientContext);
    this.listAssignmentsPagedCallable =
        callableFactory.createPagedCallable(
            listAssignmentsTransportSettings, settings.listAssignmentsSettings(), clientContext);
    this.deleteAssignmentCallable =
        callableFactory.createUnaryCallable(
            deleteAssignmentTransportSettings, settings.deleteAssignmentSettings(), clientContext);
    this.searchAssignmentsCallable =
        callableFactory.createUnaryCallable(
            searchAssignmentsTransportSettings,
            settings.searchAssignmentsSettings(),
            clientContext);
    this.searchAssignmentsPagedCallable =
        callableFactory.createPagedCallable(
            searchAssignmentsTransportSettings,
            settings.searchAssignmentsSettings(),
            clientContext);
    this.searchAllAssignmentsCallable =
        callableFactory.createUnaryCallable(
            searchAllAssignmentsTransportSettings,
            settings.searchAllAssignmentsSettings(),
            clientContext);
    this.searchAllAssignmentsPagedCallable =
        callableFactory.createPagedCallable(
            searchAllAssignmentsTransportSettings,
            settings.searchAllAssignmentsSettings(),
            clientContext);
    this.moveAssignmentCallable =
        callableFactory.createUnaryCallable(
            moveAssignmentTransportSettings, settings.moveAssignmentSettings(), clientContext);
    this.updateAssignmentCallable =
        callableFactory.createUnaryCallable(
            updateAssignmentTransportSettings, settings.updateAssignmentSettings(), clientContext);
    this.getBiReservationCallable =
        callableFactory.createUnaryCallable(
            getBiReservationTransportSettings, settings.getBiReservationSettings(), clientContext);
    this.updateBiReservationCallable =
        callableFactory.createUnaryCallable(
            updateBiReservationTransportSettings,
            settings.updateBiReservationSettings(),
            clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);
    this.createReservationGroupCallable =
        callableFactory.createUnaryCallable(
            createReservationGroupTransportSettings,
            settings.createReservationGroupSettings(),
            clientContext);
    this.getReservationGroupCallable =
        callableFactory.createUnaryCallable(
            getReservationGroupTransportSettings,
            settings.getReservationGroupSettings(),
            clientContext);
    this.deleteReservationGroupCallable =
        callableFactory.createUnaryCallable(
            deleteReservationGroupTransportSettings,
            settings.deleteReservationGroupSettings(),
            clientContext);
    this.listReservationGroupsCallable =
        callableFactory.createUnaryCallable(
            listReservationGroupsTransportSettings,
            settings.listReservationGroupsSettings(),
            clientContext);
    this.listReservationGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listReservationGroupsTransportSettings,
            settings.listReservationGroupsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateReservationRequest, Reservation> createReservationCallable() {
    return createReservationCallable;
  }

  @Override
  public UnaryCallable<ListReservationsRequest, ListReservationsResponse>
      listReservationsCallable() {
    return listReservationsCallable;
  }

  @Override
  public UnaryCallable<ListReservationsRequest, ListReservationsPagedResponse>
      listReservationsPagedCallable() {
    return listReservationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetReservationRequest, Reservation> getReservationCallable() {
    return getReservationCallable;
  }

  @Override
  public UnaryCallable<DeleteReservationRequest, Empty> deleteReservationCallable() {
    return deleteReservationCallable;
  }

  @Override
  public UnaryCallable<UpdateReservationRequest, Reservation> updateReservationCallable() {
    return updateReservationCallable;
  }

  @Override
  public UnaryCallable<FailoverReservationRequest, Reservation> failoverReservationCallable() {
    return failoverReservationCallable;
  }

  @Override
  public UnaryCallable<CreateCapacityCommitmentRequest, CapacityCommitment>
      createCapacityCommitmentCallable() {
    return createCapacityCommitmentCallable;
  }

  @Override
  public UnaryCallable<ListCapacityCommitmentsRequest, ListCapacityCommitmentsResponse>
      listCapacityCommitmentsCallable() {
    return listCapacityCommitmentsCallable;
  }

  @Override
  public UnaryCallable<ListCapacityCommitmentsRequest, ListCapacityCommitmentsPagedResponse>
      listCapacityCommitmentsPagedCallable() {
    return listCapacityCommitmentsPagedCallable;
  }

  @Override
  public UnaryCallable<GetCapacityCommitmentRequest, CapacityCommitment>
      getCapacityCommitmentCallable() {
    return getCapacityCommitmentCallable;
  }

  @Override
  public UnaryCallable<DeleteCapacityCommitmentRequest, Empty> deleteCapacityCommitmentCallable() {
    return deleteCapacityCommitmentCallable;
  }

  @Override
  public UnaryCallable<UpdateCapacityCommitmentRequest, CapacityCommitment>
      updateCapacityCommitmentCallable() {
    return updateCapacityCommitmentCallable;
  }

  @Override
  public UnaryCallable<SplitCapacityCommitmentRequest, SplitCapacityCommitmentResponse>
      splitCapacityCommitmentCallable() {
    return splitCapacityCommitmentCallable;
  }

  @Override
  public UnaryCallable<MergeCapacityCommitmentsRequest, CapacityCommitment>
      mergeCapacityCommitmentsCallable() {
    return mergeCapacityCommitmentsCallable;
  }

  @Override
  public UnaryCallable<CreateAssignmentRequest, Assignment> createAssignmentCallable() {
    return createAssignmentCallable;
  }

  @Override
  public UnaryCallable<ListAssignmentsRequest, ListAssignmentsResponse> listAssignmentsCallable() {
    return listAssignmentsCallable;
  }

  @Override
  public UnaryCallable<ListAssignmentsRequest, ListAssignmentsPagedResponse>
      listAssignmentsPagedCallable() {
    return listAssignmentsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteAssignmentRequest, Empty> deleteAssignmentCallable() {
    return deleteAssignmentCallable;
  }

  @Override
  public UnaryCallable<SearchAssignmentsRequest, SearchAssignmentsResponse>
      searchAssignmentsCallable() {
    return searchAssignmentsCallable;
  }

  @Override
  public UnaryCallable<SearchAssignmentsRequest, SearchAssignmentsPagedResponse>
      searchAssignmentsPagedCallable() {
    return searchAssignmentsPagedCallable;
  }

  @Override
  public UnaryCallable<SearchAllAssignmentsRequest, SearchAllAssignmentsResponse>
      searchAllAssignmentsCallable() {
    return searchAllAssignmentsCallable;
  }

  @Override
  public UnaryCallable<SearchAllAssignmentsRequest, SearchAllAssignmentsPagedResponse>
      searchAllAssignmentsPagedCallable() {
    return searchAllAssignmentsPagedCallable;
  }

  @Override
  public UnaryCallable<MoveAssignmentRequest, Assignment> moveAssignmentCallable() {
    return moveAssignmentCallable;
  }

  @Override
  public UnaryCallable<UpdateAssignmentRequest, Assignment> updateAssignmentCallable() {
    return updateAssignmentCallable;
  }

  @Override
  public UnaryCallable<GetBiReservationRequest, BiReservation> getBiReservationCallable() {
    return getBiReservationCallable;
  }

  @Override
  public UnaryCallable<UpdateBiReservationRequest, BiReservation> updateBiReservationCallable() {
    return updateBiReservationCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  @Override
  public UnaryCallable<CreateReservationGroupRequest, ReservationGroup>
      createReservationGroupCallable() {
    return createReservationGroupCallable;
  }

  @Override
  public UnaryCallable<GetReservationGroupRequest, ReservationGroup> getReservationGroupCallable() {
    return getReservationGroupCallable;
  }

  @Override
  public UnaryCallable<DeleteReservationGroupRequest, Empty> deleteReservationGroupCallable() {
    return deleteReservationGroupCallable;
  }

  @Override
  public UnaryCallable<ListReservationGroupsRequest, ListReservationGroupsResponse>
      listReservationGroupsCallable() {
    return listReservationGroupsCallable;
  }

  @Override
  public UnaryCallable<ListReservationGroupsRequest, ListReservationGroupsPagedResponse>
      listReservationGroupsPagedCallable() {
    return listReservationGroupsPagedCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
