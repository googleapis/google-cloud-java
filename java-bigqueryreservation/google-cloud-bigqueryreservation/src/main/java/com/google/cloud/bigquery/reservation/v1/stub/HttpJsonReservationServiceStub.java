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

import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
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
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the ReservationService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonReservationServiceStub extends ReservationServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateReservationRequest, Reservation>
      createReservationMethodDescriptor =
          ApiMethodDescriptor.<CreateReservationRequest, Reservation>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/CreateReservation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateReservationRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/reservations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReservationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReservationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "reservationId", request.getReservationId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("reservation", request.getReservation(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Reservation>newBuilder()
                      .setDefaultInstance(Reservation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListReservationsRequest, ListReservationsResponse>
      listReservationsMethodDescriptor =
          ApiMethodDescriptor.<ListReservationsRequest, ListReservationsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/ListReservations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListReservationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/reservations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListReservationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListReservationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListReservationsResponse>newBuilder()
                      .setDefaultInstance(ListReservationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetReservationRequest, Reservation>
      getReservationMethodDescriptor =
          ApiMethodDescriptor.<GetReservationRequest, Reservation>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/GetReservation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetReservationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/reservations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetReservationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetReservationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Reservation>newBuilder()
                      .setDefaultInstance(Reservation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteReservationRequest, Empty>
      deleteReservationMethodDescriptor =
          ApiMethodDescriptor.<DeleteReservationRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/DeleteReservation")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteReservationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/reservations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteReservationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteReservationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateReservationRequest, Reservation>
      updateReservationMethodDescriptor =
          ApiMethodDescriptor.<UpdateReservationRequest, Reservation>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/UpdateReservation")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateReservationRequest>newBuilder()
                      .setPath(
                          "/v1/{reservation.name=projects/*/locations/*/reservations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateReservationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "reservation.name", request.getReservation().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateReservationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("reservation", request.getReservation(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Reservation>newBuilder()
                      .setDefaultInstance(Reservation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<FailoverReservationRequest, Reservation>
      failoverReservationMethodDescriptor =
          ApiMethodDescriptor.<FailoverReservationRequest, Reservation>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/FailoverReservation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FailoverReservationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/reservations/*}:failoverReservation",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FailoverReservationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FailoverReservationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Reservation>newBuilder()
                      .setDefaultInstance(Reservation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateCapacityCommitmentRequest, CapacityCommitment>
      createCapacityCommitmentMethodDescriptor =
          ApiMethodDescriptor.<CreateCapacityCommitmentRequest, CapacityCommitment>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/CreateCapacityCommitment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCapacityCommitmentRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/capacityCommitments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCapacityCommitmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCapacityCommitmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "capacityCommitmentId", request.getCapacityCommitmentId());
                            serializer.putQueryParam(
                                fields,
                                "enforceSingleAdminProjectPerOrg",
                                request.getEnforceSingleAdminProjectPerOrg());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "capacityCommitment", request.getCapacityCommitment(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CapacityCommitment>newBuilder()
                      .setDefaultInstance(CapacityCommitment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListCapacityCommitmentsRequest, ListCapacityCommitmentsResponse>
      listCapacityCommitmentsMethodDescriptor =
          ApiMethodDescriptor
              .<ListCapacityCommitmentsRequest, ListCapacityCommitmentsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/ListCapacityCommitments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCapacityCommitmentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/capacityCommitments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCapacityCommitmentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCapacityCommitmentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCapacityCommitmentsResponse>newBuilder()
                      .setDefaultInstance(ListCapacityCommitmentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetCapacityCommitmentRequest, CapacityCommitment>
      getCapacityCommitmentMethodDescriptor =
          ApiMethodDescriptor.<GetCapacityCommitmentRequest, CapacityCommitment>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/GetCapacityCommitment")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCapacityCommitmentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/capacityCommitments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCapacityCommitmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCapacityCommitmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CapacityCommitment>newBuilder()
                      .setDefaultInstance(CapacityCommitment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteCapacityCommitmentRequest, Empty>
      deleteCapacityCommitmentMethodDescriptor =
          ApiMethodDescriptor.<DeleteCapacityCommitmentRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/DeleteCapacityCommitment")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteCapacityCommitmentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/capacityCommitments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCapacityCommitmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCapacityCommitmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateCapacityCommitmentRequest, CapacityCommitment>
      updateCapacityCommitmentMethodDescriptor =
          ApiMethodDescriptor.<UpdateCapacityCommitmentRequest, CapacityCommitment>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/UpdateCapacityCommitment")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCapacityCommitmentRequest>newBuilder()
                      .setPath(
                          "/v1/{capacityCommitment.name=projects/*/locations/*/capacityCommitments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCapacityCommitmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "capacityCommitment.name",
                                request.getCapacityCommitment().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCapacityCommitmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "capacityCommitment", request.getCapacityCommitment(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CapacityCommitment>newBuilder()
                      .setDefaultInstance(CapacityCommitment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          SplitCapacityCommitmentRequest, SplitCapacityCommitmentResponse>
      splitCapacityCommitmentMethodDescriptor =
          ApiMethodDescriptor
              .<SplitCapacityCommitmentRequest, SplitCapacityCommitmentResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/SplitCapacityCommitment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SplitCapacityCommitmentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/capacityCommitments/*}:split",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SplitCapacityCommitmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SplitCapacityCommitmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SplitCapacityCommitmentResponse>newBuilder()
                      .setDefaultInstance(SplitCapacityCommitmentResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<MergeCapacityCommitmentsRequest, CapacityCommitment>
      mergeCapacityCommitmentsMethodDescriptor =
          ApiMethodDescriptor.<MergeCapacityCommitmentsRequest, CapacityCommitment>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/MergeCapacityCommitments")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<MergeCapacityCommitmentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/capacityCommitments:merge",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<MergeCapacityCommitmentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<MergeCapacityCommitmentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CapacityCommitment>newBuilder()
                      .setDefaultInstance(CapacityCommitment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateAssignmentRequest, Assignment>
      createAssignmentMethodDescriptor =
          ApiMethodDescriptor.<CreateAssignmentRequest, Assignment>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/CreateAssignment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAssignmentRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/reservations/*}/assignments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAssignmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAssignmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "assignmentId", request.getAssignmentId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("assignment", request.getAssignment(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Assignment>newBuilder()
                      .setDefaultInstance(Assignment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListAssignmentsRequest, ListAssignmentsResponse>
      listAssignmentsMethodDescriptor =
          ApiMethodDescriptor.<ListAssignmentsRequest, ListAssignmentsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/ListAssignments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAssignmentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/reservations/*}/assignments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAssignmentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAssignmentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAssignmentsResponse>newBuilder()
                      .setDefaultInstance(ListAssignmentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteAssignmentRequest, Empty>
      deleteAssignmentMethodDescriptor =
          ApiMethodDescriptor.<DeleteAssignmentRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/DeleteAssignment")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAssignmentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/reservations/*/assignments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAssignmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAssignmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SearchAssignmentsRequest, SearchAssignmentsResponse>
      searchAssignmentsMethodDescriptor =
          ApiMethodDescriptor.<SearchAssignmentsRequest, SearchAssignmentsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/SearchAssignments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchAssignmentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}:searchAssignments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchAssignmentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchAssignmentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "query", request.getQuery());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchAssignmentsResponse>newBuilder()
                      .setDefaultInstance(SearchAssignmentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          SearchAllAssignmentsRequest, SearchAllAssignmentsResponse>
      searchAllAssignmentsMethodDescriptor =
          ApiMethodDescriptor
              .<SearchAllAssignmentsRequest, SearchAllAssignmentsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/SearchAllAssignments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchAllAssignmentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}:searchAllAssignments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchAllAssignmentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchAllAssignmentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "query", request.getQuery());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchAllAssignmentsResponse>newBuilder()
                      .setDefaultInstance(SearchAllAssignmentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<MoveAssignmentRequest, Assignment>
      moveAssignmentMethodDescriptor =
          ApiMethodDescriptor.<MoveAssignmentRequest, Assignment>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/MoveAssignment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<MoveAssignmentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/reservations/*/assignments/*}:move",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<MoveAssignmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<MoveAssignmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Assignment>newBuilder()
                      .setDefaultInstance(Assignment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateAssignmentRequest, Assignment>
      updateAssignmentMethodDescriptor =
          ApiMethodDescriptor.<UpdateAssignmentRequest, Assignment>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/UpdateAssignment")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAssignmentRequest>newBuilder()
                      .setPath(
                          "/v1/{assignment.name=projects/*/locations/*/reservations/*/assignments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAssignmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "assignment.name", request.getAssignment().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAssignmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("assignment", request.getAssignment(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Assignment>newBuilder()
                      .setDefaultInstance(Assignment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetBiReservationRequest, BiReservation>
      getBiReservationMethodDescriptor =
          ApiMethodDescriptor.<GetBiReservationRequest, BiReservation>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/GetBiReservation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetBiReservationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/biReservation}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetBiReservationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetBiReservationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BiReservation>newBuilder()
                      .setDefaultInstance(BiReservation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateBiReservationRequest, BiReservation>
      updateBiReservationMethodDescriptor =
          ApiMethodDescriptor.<UpdateBiReservationRequest, BiReservation>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/UpdateBiReservation")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateBiReservationRequest>newBuilder()
                      .setPath(
                          "/v1/{biReservation.name=projects/*/locations/*/biReservation}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBiReservationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "biReservation.name", request.getBiReservation().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBiReservationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("biReservation", request.getBiReservation(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BiReservation>newBuilder()
                      .setDefaultInstance(BiReservation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/GetIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/reservations/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/reservations/*/assignments/*}:getIamPolicy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "options", request.getOptions());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/reservations/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/reservations/*/assignments/*}:setIamPolicy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/reservations/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/reservations/*/assignments/*}:testIamPermissions")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestIamPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestIamPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateReservationGroupRequest, ReservationGroup>
      createReservationGroupMethodDescriptor =
          ApiMethodDescriptor.<CreateReservationGroupRequest, ReservationGroup>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/CreateReservationGroup")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateReservationGroupRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/reservationGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReservationGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReservationGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "reservationGroupId", request.getReservationGroupId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("reservationGroup", request.getReservationGroup(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReservationGroup>newBuilder()
                      .setDefaultInstance(ReservationGroup.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetReservationGroupRequest, ReservationGroup>
      getReservationGroupMethodDescriptor =
          ApiMethodDescriptor.<GetReservationGroupRequest, ReservationGroup>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/GetReservationGroup")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetReservationGroupRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/reservationGroups/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetReservationGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetReservationGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReservationGroup>newBuilder()
                      .setDefaultInstance(ReservationGroup.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteReservationGroupRequest, Empty>
      deleteReservationGroupMethodDescriptor =
          ApiMethodDescriptor.<DeleteReservationGroupRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/DeleteReservationGroup")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteReservationGroupRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/reservationGroups/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteReservationGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteReservationGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListReservationGroupsRequest, ListReservationGroupsResponse>
      listReservationGroupsMethodDescriptor =
          ApiMethodDescriptor
              .<ListReservationGroupsRequest, ListReservationGroupsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.reservation.v1.ReservationService/ListReservationGroups")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListReservationGroupsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/reservationGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListReservationGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListReservationGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListReservationGroupsResponse>newBuilder()
                      .setDefaultInstance(ListReservationGroupsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonReservationServiceStub create(ReservationServiceStubSettings settings)
      throws IOException {
    return new HttpJsonReservationServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonReservationServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonReservationServiceStub(
        ReservationServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonReservationServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonReservationServiceStub(
        ReservationServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonReservationServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonReservationServiceStub(
      ReservationServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonReservationServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonReservationServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonReservationServiceStub(
      ReservationServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateReservationRequest, Reservation> createReservationTransportSettings =
        HttpJsonCallSettings.<CreateReservationRequest, Reservation>newBuilder()
            .setMethodDescriptor(createReservationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListReservationsRequest, ListReservationsResponse>
        listReservationsTransportSettings =
            HttpJsonCallSettings.<ListReservationsRequest, ListReservationsResponse>newBuilder()
                .setMethodDescriptor(listReservationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetReservationRequest, Reservation> getReservationTransportSettings =
        HttpJsonCallSettings.<GetReservationRequest, Reservation>newBuilder()
            .setMethodDescriptor(getReservationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteReservationRequest, Empty> deleteReservationTransportSettings =
        HttpJsonCallSettings.<DeleteReservationRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteReservationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateReservationRequest, Reservation> updateReservationTransportSettings =
        HttpJsonCallSettings.<UpdateReservationRequest, Reservation>newBuilder()
            .setMethodDescriptor(updateReservationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "reservation.name", String.valueOf(request.getReservation().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<FailoverReservationRequest, Reservation>
        failoverReservationTransportSettings =
            HttpJsonCallSettings.<FailoverReservationRequest, Reservation>newBuilder()
                .setMethodDescriptor(failoverReservationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateCapacityCommitmentRequest, CapacityCommitment>
        createCapacityCommitmentTransportSettings =
            HttpJsonCallSettings.<CreateCapacityCommitmentRequest, CapacityCommitment>newBuilder()
                .setMethodDescriptor(createCapacityCommitmentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListCapacityCommitmentsRequest, ListCapacityCommitmentsResponse>
        listCapacityCommitmentsTransportSettings =
            HttpJsonCallSettings
                .<ListCapacityCommitmentsRequest, ListCapacityCommitmentsResponse>newBuilder()
                .setMethodDescriptor(listCapacityCommitmentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetCapacityCommitmentRequest, CapacityCommitment>
        getCapacityCommitmentTransportSettings =
            HttpJsonCallSettings.<GetCapacityCommitmentRequest, CapacityCommitment>newBuilder()
                .setMethodDescriptor(getCapacityCommitmentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteCapacityCommitmentRequest, Empty>
        deleteCapacityCommitmentTransportSettings =
            HttpJsonCallSettings.<DeleteCapacityCommitmentRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteCapacityCommitmentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateCapacityCommitmentRequest, CapacityCommitment>
        updateCapacityCommitmentTransportSettings =
            HttpJsonCallSettings.<UpdateCapacityCommitmentRequest, CapacityCommitment>newBuilder()
                .setMethodDescriptor(updateCapacityCommitmentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "capacity_commitment.name",
                          String.valueOf(request.getCapacityCommitment().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<SplitCapacityCommitmentRequest, SplitCapacityCommitmentResponse>
        splitCapacityCommitmentTransportSettings =
            HttpJsonCallSettings
                .<SplitCapacityCommitmentRequest, SplitCapacityCommitmentResponse>newBuilder()
                .setMethodDescriptor(splitCapacityCommitmentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<MergeCapacityCommitmentsRequest, CapacityCommitment>
        mergeCapacityCommitmentsTransportSettings =
            HttpJsonCallSettings.<MergeCapacityCommitmentsRequest, CapacityCommitment>newBuilder()
                .setMethodDescriptor(mergeCapacityCommitmentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateAssignmentRequest, Assignment> createAssignmentTransportSettings =
        HttpJsonCallSettings.<CreateAssignmentRequest, Assignment>newBuilder()
            .setMethodDescriptor(createAssignmentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListAssignmentsRequest, ListAssignmentsResponse>
        listAssignmentsTransportSettings =
            HttpJsonCallSettings.<ListAssignmentsRequest, ListAssignmentsResponse>newBuilder()
                .setMethodDescriptor(listAssignmentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteAssignmentRequest, Empty> deleteAssignmentTransportSettings =
        HttpJsonCallSettings.<DeleteAssignmentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAssignmentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SearchAssignmentsRequest, SearchAssignmentsResponse>
        searchAssignmentsTransportSettings =
            HttpJsonCallSettings.<SearchAssignmentsRequest, SearchAssignmentsResponse>newBuilder()
                .setMethodDescriptor(searchAssignmentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<SearchAllAssignmentsRequest, SearchAllAssignmentsResponse>
        searchAllAssignmentsTransportSettings =
            HttpJsonCallSettings
                .<SearchAllAssignmentsRequest, SearchAllAssignmentsResponse>newBuilder()
                .setMethodDescriptor(searchAllAssignmentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<MoveAssignmentRequest, Assignment> moveAssignmentTransportSettings =
        HttpJsonCallSettings.<MoveAssignmentRequest, Assignment>newBuilder()
            .setMethodDescriptor(moveAssignmentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateAssignmentRequest, Assignment> updateAssignmentTransportSettings =
        HttpJsonCallSettings.<UpdateAssignmentRequest, Assignment>newBuilder()
            .setMethodDescriptor(updateAssignmentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("assignment.name", String.valueOf(request.getAssignment().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetBiReservationRequest, BiReservation> getBiReservationTransportSettings =
        HttpJsonCallSettings.<GetBiReservationRequest, BiReservation>newBuilder()
            .setMethodDescriptor(getBiReservationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateBiReservationRequest, BiReservation>
        updateBiReservationTransportSettings =
            HttpJsonCallSettings.<UpdateBiReservationRequest, BiReservation>newBuilder()
                .setMethodDescriptor(updateBiReservationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "bi_reservation.name",
                          String.valueOf(request.getBiReservation().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateReservationGroupRequest, ReservationGroup>
        createReservationGroupTransportSettings =
            HttpJsonCallSettings.<CreateReservationGroupRequest, ReservationGroup>newBuilder()
                .setMethodDescriptor(createReservationGroupMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetReservationGroupRequest, ReservationGroup>
        getReservationGroupTransportSettings =
            HttpJsonCallSettings.<GetReservationGroupRequest, ReservationGroup>newBuilder()
                .setMethodDescriptor(getReservationGroupMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteReservationGroupRequest, Empty>
        deleteReservationGroupTransportSettings =
            HttpJsonCallSettings.<DeleteReservationGroupRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteReservationGroupMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListReservationGroupsRequest, ListReservationGroupsResponse>
        listReservationGroupsTransportSettings =
            HttpJsonCallSettings
                .<ListReservationGroupsRequest, ListReservationGroupsResponse>newBuilder()
                .setMethodDescriptor(listReservationGroupsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createReservationMethodDescriptor);
    methodDescriptors.add(listReservationsMethodDescriptor);
    methodDescriptors.add(getReservationMethodDescriptor);
    methodDescriptors.add(deleteReservationMethodDescriptor);
    methodDescriptors.add(updateReservationMethodDescriptor);
    methodDescriptors.add(failoverReservationMethodDescriptor);
    methodDescriptors.add(createCapacityCommitmentMethodDescriptor);
    methodDescriptors.add(listCapacityCommitmentsMethodDescriptor);
    methodDescriptors.add(getCapacityCommitmentMethodDescriptor);
    methodDescriptors.add(deleteCapacityCommitmentMethodDescriptor);
    methodDescriptors.add(updateCapacityCommitmentMethodDescriptor);
    methodDescriptors.add(splitCapacityCommitmentMethodDescriptor);
    methodDescriptors.add(mergeCapacityCommitmentsMethodDescriptor);
    methodDescriptors.add(createAssignmentMethodDescriptor);
    methodDescriptors.add(listAssignmentsMethodDescriptor);
    methodDescriptors.add(deleteAssignmentMethodDescriptor);
    methodDescriptors.add(searchAssignmentsMethodDescriptor);
    methodDescriptors.add(searchAllAssignmentsMethodDescriptor);
    methodDescriptors.add(moveAssignmentMethodDescriptor);
    methodDescriptors.add(updateAssignmentMethodDescriptor);
    methodDescriptors.add(getBiReservationMethodDescriptor);
    methodDescriptors.add(updateBiReservationMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    methodDescriptors.add(createReservationGroupMethodDescriptor);
    methodDescriptors.add(getReservationGroupMethodDescriptor);
    methodDescriptors.add(deleteReservationGroupMethodDescriptor);
    methodDescriptors.add(listReservationGroupsMethodDescriptor);
    return methodDescriptors;
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
