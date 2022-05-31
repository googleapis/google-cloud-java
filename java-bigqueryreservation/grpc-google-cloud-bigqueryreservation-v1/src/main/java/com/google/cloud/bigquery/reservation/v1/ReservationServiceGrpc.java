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

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * This API allows users to manage their flat-rate BigQuery reservations.
 * A reservation provides computational resource guarantees, in the form of
 * [slots](https://cloud.google.com/bigquery/docs/slots), to users. A slot is a
 * unit of computational power in BigQuery, and serves as the basic unit of
 * parallelism. In a scan of a multi-partitioned table, a single slot operates
 * on a single partition of the table. A reservation resource exists as a child
 * resource of the admin project and location, e.g.:
 *   `projects/myproject/locations/US/reservations/reservationName`.
 * A capacity commitment is a way to purchase compute capacity for BigQuery jobs
 * (in the form of slots) with some committed period of usage. A capacity
 * commitment resource exists as a child resource of the admin project and
 * location, e.g.:
 *   `projects/myproject/locations/US/capacityCommitments/id`.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/bigquery/reservation/v1/reservation.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ReservationServiceGrpc {

  private ReservationServiceGrpc() {}

  public static final String SERVICE_NAME =
      "google.cloud.bigquery.reservation.v1.ReservationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.CreateReservationRequest,
          com.google.cloud.bigquery.reservation.v1.Reservation>
      getCreateReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateReservation",
      requestType = com.google.cloud.bigquery.reservation.v1.CreateReservationRequest.class,
      responseType = com.google.cloud.bigquery.reservation.v1.Reservation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.CreateReservationRequest,
          com.google.cloud.bigquery.reservation.v1.Reservation>
      getCreateReservationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.reservation.v1.CreateReservationRequest,
            com.google.cloud.bigquery.reservation.v1.Reservation>
        getCreateReservationMethod;
    if ((getCreateReservationMethod = ReservationServiceGrpc.getCreateReservationMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getCreateReservationMethod = ReservationServiceGrpc.getCreateReservationMethod)
            == null) {
          ReservationServiceGrpc.getCreateReservationMethod =
              getCreateReservationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.reservation.v1.CreateReservationRequest,
                          com.google.cloud.bigquery.reservation.v1.Reservation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateReservation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1.CreateReservationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1.Reservation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReservationServiceMethodDescriptorSupplier("CreateReservation"))
                      .build();
        }
      }
    }
    return getCreateReservationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.ListReservationsRequest,
          com.google.cloud.bigquery.reservation.v1.ListReservationsResponse>
      getListReservationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListReservations",
      requestType = com.google.cloud.bigquery.reservation.v1.ListReservationsRequest.class,
      responseType = com.google.cloud.bigquery.reservation.v1.ListReservationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.ListReservationsRequest,
          com.google.cloud.bigquery.reservation.v1.ListReservationsResponse>
      getListReservationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.reservation.v1.ListReservationsRequest,
            com.google.cloud.bigquery.reservation.v1.ListReservationsResponse>
        getListReservationsMethod;
    if ((getListReservationsMethod = ReservationServiceGrpc.getListReservationsMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getListReservationsMethod = ReservationServiceGrpc.getListReservationsMethod)
            == null) {
          ReservationServiceGrpc.getListReservationsMethod =
              getListReservationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.reservation.v1.ListReservationsRequest,
                          com.google.cloud.bigquery.reservation.v1.ListReservationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListReservations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1.ListReservationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1.ListReservationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReservationServiceMethodDescriptorSupplier("ListReservations"))
                      .build();
        }
      }
    }
    return getListReservationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.GetReservationRequest,
          com.google.cloud.bigquery.reservation.v1.Reservation>
      getGetReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReservation",
      requestType = com.google.cloud.bigquery.reservation.v1.GetReservationRequest.class,
      responseType = com.google.cloud.bigquery.reservation.v1.Reservation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.GetReservationRequest,
          com.google.cloud.bigquery.reservation.v1.Reservation>
      getGetReservationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.reservation.v1.GetReservationRequest,
            com.google.cloud.bigquery.reservation.v1.Reservation>
        getGetReservationMethod;
    if ((getGetReservationMethod = ReservationServiceGrpc.getGetReservationMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getGetReservationMethod = ReservationServiceGrpc.getGetReservationMethod) == null) {
          ReservationServiceGrpc.getGetReservationMethod =
              getGetReservationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.reservation.v1.GetReservationRequest,
                          com.google.cloud.bigquery.reservation.v1.Reservation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetReservation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1.GetReservationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1.Reservation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReservationServiceMethodDescriptorSupplier("GetReservation"))
                      .build();
        }
      }
    }
    return getGetReservationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.DeleteReservationRequest,
          com.google.protobuf.Empty>
      getDeleteReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteReservation",
      requestType = com.google.cloud.bigquery.reservation.v1.DeleteReservationRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.DeleteReservationRequest,
          com.google.protobuf.Empty>
      getDeleteReservationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.reservation.v1.DeleteReservationRequest,
            com.google.protobuf.Empty>
        getDeleteReservationMethod;
    if ((getDeleteReservationMethod = ReservationServiceGrpc.getDeleteReservationMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getDeleteReservationMethod = ReservationServiceGrpc.getDeleteReservationMethod)
            == null) {
          ReservationServiceGrpc.getDeleteReservationMethod =
              getDeleteReservationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.reservation.v1.DeleteReservationRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteReservation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1.DeleteReservationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReservationServiceMethodDescriptorSupplier("DeleteReservation"))
                      .build();
        }
      }
    }
    return getDeleteReservationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.UpdateReservationRequest,
          com.google.cloud.bigquery.reservation.v1.Reservation>
      getUpdateReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateReservation",
      requestType = com.google.cloud.bigquery.reservation.v1.UpdateReservationRequest.class,
      responseType = com.google.cloud.bigquery.reservation.v1.Reservation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.UpdateReservationRequest,
          com.google.cloud.bigquery.reservation.v1.Reservation>
      getUpdateReservationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.reservation.v1.UpdateReservationRequest,
            com.google.cloud.bigquery.reservation.v1.Reservation>
        getUpdateReservationMethod;
    if ((getUpdateReservationMethod = ReservationServiceGrpc.getUpdateReservationMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getUpdateReservationMethod = ReservationServiceGrpc.getUpdateReservationMethod)
            == null) {
          ReservationServiceGrpc.getUpdateReservationMethod =
              getUpdateReservationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.reservation.v1.UpdateReservationRequest,
                          com.google.cloud.bigquery.reservation.v1.Reservation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateReservation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1.UpdateReservationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1.Reservation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReservationServiceMethodDescriptorSupplier("UpdateReservation"))
                      .build();
        }
      }
    }
    return getUpdateReservationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.CreateCapacityCommitmentRequest,
          com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
      getCreateCapacityCommitmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCapacityCommitment",
      requestType = com.google.cloud.bigquery.reservation.v1.CreateCapacityCommitmentRequest.class,
      responseType = com.google.cloud.bigquery.reservation.v1.CapacityCommitment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.CreateCapacityCommitmentRequest,
          com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
      getCreateCapacityCommitmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.reservation.v1.CreateCapacityCommitmentRequest,
            com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
        getCreateCapacityCommitmentMethod;
    if ((getCreateCapacityCommitmentMethod =
            ReservationServiceGrpc.getCreateCapacityCommitmentMethod)
        == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getCreateCapacityCommitmentMethod =
                ReservationServiceGrpc.getCreateCapacityCommitmentMethod)
            == null) {
          ReservationServiceGrpc.getCreateCapacityCommitmentMethod =
              getCreateCapacityCommitmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.reservation.v1.CreateCapacityCommitmentRequest,
                          com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateCapacityCommitment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1
                                  .CreateCapacityCommitmentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1.CapacityCommitment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReservationServiceMethodDescriptorSupplier(
                              "CreateCapacityCommitment"))
                      .build();
        }
      }
    }
    return getCreateCapacityCommitmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsRequest,
          com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsResponse>
      getListCapacityCommitmentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCapacityCommitments",
      requestType = com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsRequest.class,
      responseType = com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsRequest,
          com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsResponse>
      getListCapacityCommitmentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsRequest,
            com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsResponse>
        getListCapacityCommitmentsMethod;
    if ((getListCapacityCommitmentsMethod = ReservationServiceGrpc.getListCapacityCommitmentsMethod)
        == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getListCapacityCommitmentsMethod =
                ReservationServiceGrpc.getListCapacityCommitmentsMethod)
            == null) {
          ReservationServiceGrpc.getListCapacityCommitmentsMethod =
              getListCapacityCommitmentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsRequest,
                          com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListCapacityCommitments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1
                                  .ListCapacityCommitmentsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1
                                  .ListCapacityCommitmentsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReservationServiceMethodDescriptorSupplier("ListCapacityCommitments"))
                      .build();
        }
      }
    }
    return getListCapacityCommitmentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.GetCapacityCommitmentRequest,
          com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
      getGetCapacityCommitmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCapacityCommitment",
      requestType = com.google.cloud.bigquery.reservation.v1.GetCapacityCommitmentRequest.class,
      responseType = com.google.cloud.bigquery.reservation.v1.CapacityCommitment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.GetCapacityCommitmentRequest,
          com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
      getGetCapacityCommitmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.reservation.v1.GetCapacityCommitmentRequest,
            com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
        getGetCapacityCommitmentMethod;
    if ((getGetCapacityCommitmentMethod = ReservationServiceGrpc.getGetCapacityCommitmentMethod)
        == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getGetCapacityCommitmentMethod = ReservationServiceGrpc.getGetCapacityCommitmentMethod)
            == null) {
          ReservationServiceGrpc.getGetCapacityCommitmentMethod =
              getGetCapacityCommitmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.reservation.v1.GetCapacityCommitmentRequest,
                          com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetCapacityCommitment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1.GetCapacityCommitmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1.CapacityCommitment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReservationServiceMethodDescriptorSupplier("GetCapacityCommitment"))
                      .build();
        }
      }
    }
    return getGetCapacityCommitmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.DeleteCapacityCommitmentRequest,
          com.google.protobuf.Empty>
      getDeleteCapacityCommitmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCapacityCommitment",
      requestType = com.google.cloud.bigquery.reservation.v1.DeleteCapacityCommitmentRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.DeleteCapacityCommitmentRequest,
          com.google.protobuf.Empty>
      getDeleteCapacityCommitmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.reservation.v1.DeleteCapacityCommitmentRequest,
            com.google.protobuf.Empty>
        getDeleteCapacityCommitmentMethod;
    if ((getDeleteCapacityCommitmentMethod =
            ReservationServiceGrpc.getDeleteCapacityCommitmentMethod)
        == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getDeleteCapacityCommitmentMethod =
                ReservationServiceGrpc.getDeleteCapacityCommitmentMethod)
            == null) {
          ReservationServiceGrpc.getDeleteCapacityCommitmentMethod =
              getDeleteCapacityCommitmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.reservation.v1.DeleteCapacityCommitmentRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteCapacityCommitment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1
                                  .DeleteCapacityCommitmentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReservationServiceMethodDescriptorSupplier(
                              "DeleteCapacityCommitment"))
                      .build();
        }
      }
    }
    return getDeleteCapacityCommitmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.UpdateCapacityCommitmentRequest,
          com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
      getUpdateCapacityCommitmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCapacityCommitment",
      requestType = com.google.cloud.bigquery.reservation.v1.UpdateCapacityCommitmentRequest.class,
      responseType = com.google.cloud.bigquery.reservation.v1.CapacityCommitment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.UpdateCapacityCommitmentRequest,
          com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
      getUpdateCapacityCommitmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.reservation.v1.UpdateCapacityCommitmentRequest,
            com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
        getUpdateCapacityCommitmentMethod;
    if ((getUpdateCapacityCommitmentMethod =
            ReservationServiceGrpc.getUpdateCapacityCommitmentMethod)
        == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getUpdateCapacityCommitmentMethod =
                ReservationServiceGrpc.getUpdateCapacityCommitmentMethod)
            == null) {
          ReservationServiceGrpc.getUpdateCapacityCommitmentMethod =
              getUpdateCapacityCommitmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.reservation.v1.UpdateCapacityCommitmentRequest,
                          com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateCapacityCommitment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1
                                  .UpdateCapacityCommitmentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1.CapacityCommitment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReservationServiceMethodDescriptorSupplier(
                              "UpdateCapacityCommitment"))
                      .build();
        }
      }
    }
    return getUpdateCapacityCommitmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentRequest,
          com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentResponse>
      getSplitCapacityCommitmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SplitCapacityCommitment",
      requestType = com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentRequest.class,
      responseType = com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentRequest,
          com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentResponse>
      getSplitCapacityCommitmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentRequest,
            com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentResponse>
        getSplitCapacityCommitmentMethod;
    if ((getSplitCapacityCommitmentMethod = ReservationServiceGrpc.getSplitCapacityCommitmentMethod)
        == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getSplitCapacityCommitmentMethod =
                ReservationServiceGrpc.getSplitCapacityCommitmentMethod)
            == null) {
          ReservationServiceGrpc.getSplitCapacityCommitmentMethod =
              getSplitCapacityCommitmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentRequest,
                          com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SplitCapacityCommitment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1
                                  .SplitCapacityCommitmentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1
                                  .SplitCapacityCommitmentResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReservationServiceMethodDescriptorSupplier("SplitCapacityCommitment"))
                      .build();
        }
      }
    }
    return getSplitCapacityCommitmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.MergeCapacityCommitmentsRequest,
          com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
      getMergeCapacityCommitmentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MergeCapacityCommitments",
      requestType = com.google.cloud.bigquery.reservation.v1.MergeCapacityCommitmentsRequest.class,
      responseType = com.google.cloud.bigquery.reservation.v1.CapacityCommitment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.MergeCapacityCommitmentsRequest,
          com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
      getMergeCapacityCommitmentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.reservation.v1.MergeCapacityCommitmentsRequest,
            com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
        getMergeCapacityCommitmentsMethod;
    if ((getMergeCapacityCommitmentsMethod =
            ReservationServiceGrpc.getMergeCapacityCommitmentsMethod)
        == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getMergeCapacityCommitmentsMethod =
                ReservationServiceGrpc.getMergeCapacityCommitmentsMethod)
            == null) {
          ReservationServiceGrpc.getMergeCapacityCommitmentsMethod =
              getMergeCapacityCommitmentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.reservation.v1.MergeCapacityCommitmentsRequest,
                          com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "MergeCapacityCommitments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1
                                  .MergeCapacityCommitmentsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1.CapacityCommitment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReservationServiceMethodDescriptorSupplier(
                              "MergeCapacityCommitments"))
                      .build();
        }
      }
    }
    return getMergeCapacityCommitmentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.CreateAssignmentRequest,
          com.google.cloud.bigquery.reservation.v1.Assignment>
      getCreateAssignmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAssignment",
      requestType = com.google.cloud.bigquery.reservation.v1.CreateAssignmentRequest.class,
      responseType = com.google.cloud.bigquery.reservation.v1.Assignment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.CreateAssignmentRequest,
          com.google.cloud.bigquery.reservation.v1.Assignment>
      getCreateAssignmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.reservation.v1.CreateAssignmentRequest,
            com.google.cloud.bigquery.reservation.v1.Assignment>
        getCreateAssignmentMethod;
    if ((getCreateAssignmentMethod = ReservationServiceGrpc.getCreateAssignmentMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getCreateAssignmentMethod = ReservationServiceGrpc.getCreateAssignmentMethod)
            == null) {
          ReservationServiceGrpc.getCreateAssignmentMethod =
              getCreateAssignmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.reservation.v1.CreateAssignmentRequest,
                          com.google.cloud.bigquery.reservation.v1.Assignment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAssignment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1.CreateAssignmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1.Assignment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReservationServiceMethodDescriptorSupplier("CreateAssignment"))
                      .build();
        }
      }
    }
    return getCreateAssignmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.ListAssignmentsRequest,
          com.google.cloud.bigquery.reservation.v1.ListAssignmentsResponse>
      getListAssignmentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAssignments",
      requestType = com.google.cloud.bigquery.reservation.v1.ListAssignmentsRequest.class,
      responseType = com.google.cloud.bigquery.reservation.v1.ListAssignmentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.ListAssignmentsRequest,
          com.google.cloud.bigquery.reservation.v1.ListAssignmentsResponse>
      getListAssignmentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.reservation.v1.ListAssignmentsRequest,
            com.google.cloud.bigquery.reservation.v1.ListAssignmentsResponse>
        getListAssignmentsMethod;
    if ((getListAssignmentsMethod = ReservationServiceGrpc.getListAssignmentsMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getListAssignmentsMethod = ReservationServiceGrpc.getListAssignmentsMethod) == null) {
          ReservationServiceGrpc.getListAssignmentsMethod =
              getListAssignmentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.reservation.v1.ListAssignmentsRequest,
                          com.google.cloud.bigquery.reservation.v1.ListAssignmentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAssignments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1.ListAssignmentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1.ListAssignmentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReservationServiceMethodDescriptorSupplier("ListAssignments"))
                      .build();
        }
      }
    }
    return getListAssignmentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.DeleteAssignmentRequest,
          com.google.protobuf.Empty>
      getDeleteAssignmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAssignment",
      requestType = com.google.cloud.bigquery.reservation.v1.DeleteAssignmentRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.DeleteAssignmentRequest,
          com.google.protobuf.Empty>
      getDeleteAssignmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.reservation.v1.DeleteAssignmentRequest,
            com.google.protobuf.Empty>
        getDeleteAssignmentMethod;
    if ((getDeleteAssignmentMethod = ReservationServiceGrpc.getDeleteAssignmentMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getDeleteAssignmentMethod = ReservationServiceGrpc.getDeleteAssignmentMethod)
            == null) {
          ReservationServiceGrpc.getDeleteAssignmentMethod =
              getDeleteAssignmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.reservation.v1.DeleteAssignmentRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAssignment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1.DeleteAssignmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReservationServiceMethodDescriptorSupplier("DeleteAssignment"))
                      .build();
        }
      }
    }
    return getDeleteAssignmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.SearchAssignmentsRequest,
          com.google.cloud.bigquery.reservation.v1.SearchAssignmentsResponse>
      getSearchAssignmentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchAssignments",
      requestType = com.google.cloud.bigquery.reservation.v1.SearchAssignmentsRequest.class,
      responseType = com.google.cloud.bigquery.reservation.v1.SearchAssignmentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.SearchAssignmentsRequest,
          com.google.cloud.bigquery.reservation.v1.SearchAssignmentsResponse>
      getSearchAssignmentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.reservation.v1.SearchAssignmentsRequest,
            com.google.cloud.bigquery.reservation.v1.SearchAssignmentsResponse>
        getSearchAssignmentsMethod;
    if ((getSearchAssignmentsMethod = ReservationServiceGrpc.getSearchAssignmentsMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getSearchAssignmentsMethod = ReservationServiceGrpc.getSearchAssignmentsMethod)
            == null) {
          ReservationServiceGrpc.getSearchAssignmentsMethod =
              getSearchAssignmentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.reservation.v1.SearchAssignmentsRequest,
                          com.google.cloud.bigquery.reservation.v1.SearchAssignmentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchAssignments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1.SearchAssignmentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1.SearchAssignmentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReservationServiceMethodDescriptorSupplier("SearchAssignments"))
                      .build();
        }
      }
    }
    return getSearchAssignmentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.SearchAllAssignmentsRequest,
          com.google.cloud.bigquery.reservation.v1.SearchAllAssignmentsResponse>
      getSearchAllAssignmentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchAllAssignments",
      requestType = com.google.cloud.bigquery.reservation.v1.SearchAllAssignmentsRequest.class,
      responseType = com.google.cloud.bigquery.reservation.v1.SearchAllAssignmentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.SearchAllAssignmentsRequest,
          com.google.cloud.bigquery.reservation.v1.SearchAllAssignmentsResponse>
      getSearchAllAssignmentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.reservation.v1.SearchAllAssignmentsRequest,
            com.google.cloud.bigquery.reservation.v1.SearchAllAssignmentsResponse>
        getSearchAllAssignmentsMethod;
    if ((getSearchAllAssignmentsMethod = ReservationServiceGrpc.getSearchAllAssignmentsMethod)
        == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getSearchAllAssignmentsMethod = ReservationServiceGrpc.getSearchAllAssignmentsMethod)
            == null) {
          ReservationServiceGrpc.getSearchAllAssignmentsMethod =
              getSearchAllAssignmentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.reservation.v1.SearchAllAssignmentsRequest,
                          com.google.cloud.bigquery.reservation.v1.SearchAllAssignmentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SearchAllAssignments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1.SearchAllAssignmentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1.SearchAllAssignmentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReservationServiceMethodDescriptorSupplier("SearchAllAssignments"))
                      .build();
        }
      }
    }
    return getSearchAllAssignmentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.MoveAssignmentRequest,
          com.google.cloud.bigquery.reservation.v1.Assignment>
      getMoveAssignmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MoveAssignment",
      requestType = com.google.cloud.bigquery.reservation.v1.MoveAssignmentRequest.class,
      responseType = com.google.cloud.bigquery.reservation.v1.Assignment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.MoveAssignmentRequest,
          com.google.cloud.bigquery.reservation.v1.Assignment>
      getMoveAssignmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.reservation.v1.MoveAssignmentRequest,
            com.google.cloud.bigquery.reservation.v1.Assignment>
        getMoveAssignmentMethod;
    if ((getMoveAssignmentMethod = ReservationServiceGrpc.getMoveAssignmentMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getMoveAssignmentMethod = ReservationServiceGrpc.getMoveAssignmentMethod) == null) {
          ReservationServiceGrpc.getMoveAssignmentMethod =
              getMoveAssignmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.reservation.v1.MoveAssignmentRequest,
                          com.google.cloud.bigquery.reservation.v1.Assignment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MoveAssignment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1.MoveAssignmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1.Assignment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReservationServiceMethodDescriptorSupplier("MoveAssignment"))
                      .build();
        }
      }
    }
    return getMoveAssignmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.UpdateAssignmentRequest,
          com.google.cloud.bigquery.reservation.v1.Assignment>
      getUpdateAssignmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAssignment",
      requestType = com.google.cloud.bigquery.reservation.v1.UpdateAssignmentRequest.class,
      responseType = com.google.cloud.bigquery.reservation.v1.Assignment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.UpdateAssignmentRequest,
          com.google.cloud.bigquery.reservation.v1.Assignment>
      getUpdateAssignmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.reservation.v1.UpdateAssignmentRequest,
            com.google.cloud.bigquery.reservation.v1.Assignment>
        getUpdateAssignmentMethod;
    if ((getUpdateAssignmentMethod = ReservationServiceGrpc.getUpdateAssignmentMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getUpdateAssignmentMethod = ReservationServiceGrpc.getUpdateAssignmentMethod)
            == null) {
          ReservationServiceGrpc.getUpdateAssignmentMethod =
              getUpdateAssignmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.reservation.v1.UpdateAssignmentRequest,
                          com.google.cloud.bigquery.reservation.v1.Assignment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAssignment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1.UpdateAssignmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1.Assignment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReservationServiceMethodDescriptorSupplier("UpdateAssignment"))
                      .build();
        }
      }
    }
    return getUpdateAssignmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.GetBiReservationRequest,
          com.google.cloud.bigquery.reservation.v1.BiReservation>
      getGetBiReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBiReservation",
      requestType = com.google.cloud.bigquery.reservation.v1.GetBiReservationRequest.class,
      responseType = com.google.cloud.bigquery.reservation.v1.BiReservation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.GetBiReservationRequest,
          com.google.cloud.bigquery.reservation.v1.BiReservation>
      getGetBiReservationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.reservation.v1.GetBiReservationRequest,
            com.google.cloud.bigquery.reservation.v1.BiReservation>
        getGetBiReservationMethod;
    if ((getGetBiReservationMethod = ReservationServiceGrpc.getGetBiReservationMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getGetBiReservationMethod = ReservationServiceGrpc.getGetBiReservationMethod)
            == null) {
          ReservationServiceGrpc.getGetBiReservationMethod =
              getGetBiReservationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.reservation.v1.GetBiReservationRequest,
                          com.google.cloud.bigquery.reservation.v1.BiReservation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBiReservation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1.GetBiReservationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1.BiReservation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReservationServiceMethodDescriptorSupplier("GetBiReservation"))
                      .build();
        }
      }
    }
    return getGetBiReservationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.UpdateBiReservationRequest,
          com.google.cloud.bigquery.reservation.v1.BiReservation>
      getUpdateBiReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBiReservation",
      requestType = com.google.cloud.bigquery.reservation.v1.UpdateBiReservationRequest.class,
      responseType = com.google.cloud.bigquery.reservation.v1.BiReservation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.reservation.v1.UpdateBiReservationRequest,
          com.google.cloud.bigquery.reservation.v1.BiReservation>
      getUpdateBiReservationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.reservation.v1.UpdateBiReservationRequest,
            com.google.cloud.bigquery.reservation.v1.BiReservation>
        getUpdateBiReservationMethod;
    if ((getUpdateBiReservationMethod = ReservationServiceGrpc.getUpdateBiReservationMethod)
        == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getUpdateBiReservationMethod = ReservationServiceGrpc.getUpdateBiReservationMethod)
            == null) {
          ReservationServiceGrpc.getUpdateBiReservationMethod =
              getUpdateBiReservationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.reservation.v1.UpdateBiReservationRequest,
                          com.google.cloud.bigquery.reservation.v1.BiReservation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateBiReservation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1.UpdateBiReservationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.reservation.v1.BiReservation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReservationServiceMethodDescriptorSupplier("UpdateBiReservation"))
                      .build();
        }
      }
    }
    return getUpdateBiReservationMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ReservationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReservationServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ReservationServiceStub>() {
          @java.lang.Override
          public ReservationServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReservationServiceStub(channel, callOptions);
          }
        };
    return ReservationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReservationServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReservationServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ReservationServiceBlockingStub>() {
          @java.lang.Override
          public ReservationServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReservationServiceBlockingStub(channel, callOptions);
          }
        };
    return ReservationServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ReservationServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReservationServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ReservationServiceFutureStub>() {
          @java.lang.Override
          public ReservationServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReservationServiceFutureStub(channel, callOptions);
          }
        };
    return ReservationServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * This API allows users to manage their flat-rate BigQuery reservations.
   * A reservation provides computational resource guarantees, in the form of
   * [slots](https://cloud.google.com/bigquery/docs/slots), to users. A slot is a
   * unit of computational power in BigQuery, and serves as the basic unit of
   * parallelism. In a scan of a multi-partitioned table, a single slot operates
   * on a single partition of the table. A reservation resource exists as a child
   * resource of the admin project and location, e.g.:
   *   `projects/myproject/locations/US/reservations/reservationName`.
   * A capacity commitment is a way to purchase compute capacity for BigQuery jobs
   * (in the form of slots) with some committed period of usage. A capacity
   * commitment resource exists as a child resource of the admin project and
   * location, e.g.:
   *   `projects/myproject/locations/US/capacityCommitments/id`.
   * </pre>
   */
  public abstract static class ReservationServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a new reservation resource.
     * </pre>
     */
    public void createReservation(
        com.google.cloud.bigquery.reservation.v1.CreateReservationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.Reservation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateReservationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the reservations for the project in the specified location.
     * </pre>
     */
    public void listReservations(
        com.google.cloud.bigquery.reservation.v1.ListReservationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.reservation.v1.ListReservationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListReservationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns information about the reservation.
     * </pre>
     */
    public void getReservation(
        com.google.cloud.bigquery.reservation.v1.GetReservationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.Reservation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetReservationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a reservation.
     * Returns `google.rpc.Code.FAILED_PRECONDITION` when reservation has
     * assignments.
     * </pre>
     */
    public void deleteReservation(
        com.google.cloud.bigquery.reservation.v1.DeleteReservationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteReservationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing reservation resource.
     * </pre>
     */
    public void updateReservation(
        com.google.cloud.bigquery.reservation.v1.UpdateReservationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.Reservation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateReservationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new capacity commitment resource.
     * </pre>
     */
    public void createCapacityCommitment(
        com.google.cloud.bigquery.reservation.v1.CreateCapacityCommitmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCapacityCommitmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the capacity commitments for the admin project.
     * </pre>
     */
    public void listCapacityCommitments(
        com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCapacityCommitmentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns information about the capacity commitment.
     * </pre>
     */
    public void getCapacityCommitment(
        com.google.cloud.bigquery.reservation.v1.GetCapacityCommitmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCapacityCommitmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a capacity commitment. Attempting to delete capacity commitment
     * before its commitment_end_time will fail with the error code
     * `google.rpc.Code.FAILED_PRECONDITION`.
     * </pre>
     */
    public void deleteCapacityCommitment(
        com.google.cloud.bigquery.reservation.v1.DeleteCapacityCommitmentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteCapacityCommitmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing capacity commitment.
     * Only `plan` and `renewal_plan` fields can be updated.
     * Plan can only be changed to a plan of a longer commitment period.
     * Attempting to change to a plan with shorter commitment period will fail
     * with the error code `google.rpc.Code.FAILED_PRECONDITION`.
     * </pre>
     */
    public void updateCapacityCommitment(
        com.google.cloud.bigquery.reservation.v1.UpdateCapacityCommitmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateCapacityCommitmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Splits capacity commitment to two commitments of the same plan and
     * `commitment_end_time`.
     * A common use case is to enable downgrading commitments.
     * For example, in order to downgrade from 10000 slots to 8000, you might
     * split a 10000 capacity commitment into commitments of 2000 and 8000. Then,
     * you delete the first one after the commitment end time passes.
     * </pre>
     */
    public void splitCapacityCommitment(
        com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSplitCapacityCommitmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Merges capacity commitments of the same plan into a single commitment.
     * The resulting capacity commitment has the greater commitment_end_time
     * out of the to-be-merged capacity commitments.
     * Attempting to merge capacity commitments of different plan will fail
     * with the error code `google.rpc.Code.FAILED_PRECONDITION`.
     * </pre>
     */
    public void mergeCapacityCommitments(
        com.google.cloud.bigquery.reservation.v1.MergeCapacityCommitmentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getMergeCapacityCommitmentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an assignment object which allows the given project to submit jobs
     * of a certain type using slots from the specified reservation.
     * Currently a
     * resource (project, folder, organization) can only have one assignment per
     * each (job_type, location) combination, and that reservation will be used
     * for all jobs of the matching type.
     * Different assignments can be created on different levels of the
     * projects, folders or organization hierarchy.  During query execution,
     * the assignment is looked up at the project, folder and organization levels
     * in that order. The first assignment found is applied to the query.
     * When creating assignments, it does not matter if other assignments exist at
     * higher levels.
     * Example:
     * * The organization `organizationA` contains two projects, `project1`
     *   and `project2`.
     * * Assignments for all three entities (`organizationA`, `project1`, and
     *   `project2`) could all be created and mapped to the same or different
     *   reservations.
     * "None" assignments represent an absence of the assignment. Projects
     * assigned to None use on-demand pricing. To create a "None" assignment, use
     * "none" as a reservation_id in the parent. Example parent:
     * `projects/myproject/locations/US/reservations/none`.
     * Returns `google.rpc.Code.PERMISSION_DENIED` if user does not have
     * 'bigquery.admin' permissions on the project using the reservation
     * and the project that owns this reservation.
     * Returns `google.rpc.Code.INVALID_ARGUMENT` when location of the assignment
     * does not match location of the reservation.
     * </pre>
     */
    public void createAssignment(
        com.google.cloud.bigquery.reservation.v1.CreateAssignmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.Assignment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAssignmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists assignments.
     * Only explicitly created assignments will be returned.
     * Example:
     * * Organization `organizationA` contains two projects, `project1` and
     *   `project2`.
     * * Reservation `res1` exists and was created previously.
     * * CreateAssignment was used previously to define the following
     *   associations between entities and reservations: `&lt;organizationA, res1&gt;`
     *   and `&lt;project1, res1&gt;`
     * In this example, ListAssignments will just return the above two assignments
     * for reservation `res1`, and no expansion/merge will happen.
     * The wildcard "-" can be used for
     * reservations in the request. In that case all assignments belongs to the
     * specified project and location will be listed.
     * **Note** "-" cannot be used for projects nor locations.
     * </pre>
     */
    public void listAssignments(
        com.google.cloud.bigquery.reservation.v1.ListAssignmentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.reservation.v1.ListAssignmentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAssignmentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a assignment. No expansion will happen.
     * Example:
     * * Organization `organizationA` contains two projects, `project1` and
     *   `project2`.
     * * Reservation `res1` exists and was created previously.
     * * CreateAssignment was used previously to define the following
     *   associations between entities and reservations: `&lt;organizationA, res1&gt;`
     *   and `&lt;project1, res1&gt;`
     * In this example, deletion of the `&lt;organizationA, res1&gt;` assignment won't
     * affect the other assignment `&lt;project1, res1&gt;`. After said deletion,
     * queries from `project1` will still use `res1` while queries from
     * `project2` will switch to use on-demand mode.
     * </pre>
     */
    public void deleteAssignment(
        com.google.cloud.bigquery.reservation.v1.DeleteAssignmentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAssignmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Looks up assignments for a specified resource for a particular
     * region. If the request is about a project:
     * 1. Assignments created on the project will be returned if they exist.
     * 2. Otherwise assignments created on the closest ancestor will be
     *    returned.
     * 3. Assignments for different JobTypes will all be returned.
     * The same logic applies if the request is about a folder.
     * If the request is about an organization, then assignments created on the
     * organization will be returned (organization doesn't have ancestors).
     * Comparing to ListAssignments, there are some behavior
     * differences:
     * 1. permission on the assignee will be verified in this API.
     * 2. Hierarchy lookup (project-&gt;folder-&gt;organization) happens in this API.
     * 3. Parent here is `projects/&#42;&#47;locations/&#42;`, instead of
     *    `projects/&#42;&#47;locations/&#42;reservations/&#42;`.
     * **Note** "-" cannot be used for projects
     * nor locations.
     * </pre>
     */
    @java.lang.Deprecated
    public void searchAssignments(
        com.google.cloud.bigquery.reservation.v1.SearchAssignmentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.reservation.v1.SearchAssignmentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchAssignmentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Looks up assignments for a specified resource for a particular region.
     * If the request is about a project:
     * 1. Assignments created on the project will be returned if they exist.
     * 2. Otherwise assignments created on the closest ancestor will be
     *    returned.
     * 3. Assignments for different JobTypes will all be returned.
     * The same logic applies if the request is about a folder.
     * If the request is about an organization, then assignments created on the
     * organization will be returned (organization doesn't have ancestors).
     * Comparing to ListAssignments, there are some behavior
     * differences:
     * 1. permission on the assignee will be verified in this API.
     * 2. Hierarchy lookup (project-&gt;folder-&gt;organization) happens in this API.
     * 3. Parent here is `projects/&#42;&#47;locations/&#42;`, instead of
     *    `projects/&#42;&#47;locations/&#42;reservations/&#42;`.
     * </pre>
     */
    public void searchAllAssignments(
        com.google.cloud.bigquery.reservation.v1.SearchAllAssignmentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.reservation.v1.SearchAllAssignmentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchAllAssignmentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Moves an assignment under a new reservation.
     * This differs from removing an existing assignment and recreating a new one
     * by providing a transactional change that ensures an assignee always has an
     * associated reservation.
     * </pre>
     */
    public void moveAssignment(
        com.google.cloud.bigquery.reservation.v1.MoveAssignmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.Assignment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getMoveAssignmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing assignment.
     * Only the `priority` field can be updated.
     * </pre>
     */
    public void updateAssignment(
        com.google.cloud.bigquery.reservation.v1.UpdateAssignmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.Assignment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAssignmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a BI reservation.
     * </pre>
     */
    public void getBiReservation(
        com.google.cloud.bigquery.reservation.v1.GetBiReservationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.BiReservation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetBiReservationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a BI reservation.
     * Only fields specified in the `field_mask` are updated.
     * A singleton BI reservation always exists with default size 0.
     * In order to reserve BI capacity it needs to be updated to an amount
     * greater than 0. In order to release BI capacity reservation size
     * must be set to 0.
     * </pre>
     */
    public void updateBiReservation(
        com.google.cloud.bigquery.reservation.v1.UpdateBiReservationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.BiReservation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateBiReservationMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateReservationMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.CreateReservationRequest,
                      com.google.cloud.bigquery.reservation.v1.Reservation>(
                      this, METHODID_CREATE_RESERVATION)))
          .addMethod(
              getListReservationsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.ListReservationsRequest,
                      com.google.cloud.bigquery.reservation.v1.ListReservationsResponse>(
                      this, METHODID_LIST_RESERVATIONS)))
          .addMethod(
              getGetReservationMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.GetReservationRequest,
                      com.google.cloud.bigquery.reservation.v1.Reservation>(
                      this, METHODID_GET_RESERVATION)))
          .addMethod(
              getDeleteReservationMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.DeleteReservationRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_RESERVATION)))
          .addMethod(
              getUpdateReservationMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.UpdateReservationRequest,
                      com.google.cloud.bigquery.reservation.v1.Reservation>(
                      this, METHODID_UPDATE_RESERVATION)))
          .addMethod(
              getCreateCapacityCommitmentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.CreateCapacityCommitmentRequest,
                      com.google.cloud.bigquery.reservation.v1.CapacityCommitment>(
                      this, METHODID_CREATE_CAPACITY_COMMITMENT)))
          .addMethod(
              getListCapacityCommitmentsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsRequest,
                      com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsResponse>(
                      this, METHODID_LIST_CAPACITY_COMMITMENTS)))
          .addMethod(
              getGetCapacityCommitmentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.GetCapacityCommitmentRequest,
                      com.google.cloud.bigquery.reservation.v1.CapacityCommitment>(
                      this, METHODID_GET_CAPACITY_COMMITMENT)))
          .addMethod(
              getDeleteCapacityCommitmentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.DeleteCapacityCommitmentRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_CAPACITY_COMMITMENT)))
          .addMethod(
              getUpdateCapacityCommitmentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.UpdateCapacityCommitmentRequest,
                      com.google.cloud.bigquery.reservation.v1.CapacityCommitment>(
                      this, METHODID_UPDATE_CAPACITY_COMMITMENT)))
          .addMethod(
              getSplitCapacityCommitmentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentRequest,
                      com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentResponse>(
                      this, METHODID_SPLIT_CAPACITY_COMMITMENT)))
          .addMethod(
              getMergeCapacityCommitmentsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.MergeCapacityCommitmentsRequest,
                      com.google.cloud.bigquery.reservation.v1.CapacityCommitment>(
                      this, METHODID_MERGE_CAPACITY_COMMITMENTS)))
          .addMethod(
              getCreateAssignmentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.CreateAssignmentRequest,
                      com.google.cloud.bigquery.reservation.v1.Assignment>(
                      this, METHODID_CREATE_ASSIGNMENT)))
          .addMethod(
              getListAssignmentsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.ListAssignmentsRequest,
                      com.google.cloud.bigquery.reservation.v1.ListAssignmentsResponse>(
                      this, METHODID_LIST_ASSIGNMENTS)))
          .addMethod(
              getDeleteAssignmentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.DeleteAssignmentRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_ASSIGNMENT)))
          .addMethod(
              getSearchAssignmentsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.SearchAssignmentsRequest,
                      com.google.cloud.bigquery.reservation.v1.SearchAssignmentsResponse>(
                      this, METHODID_SEARCH_ASSIGNMENTS)))
          .addMethod(
              getSearchAllAssignmentsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.SearchAllAssignmentsRequest,
                      com.google.cloud.bigquery.reservation.v1.SearchAllAssignmentsResponse>(
                      this, METHODID_SEARCH_ALL_ASSIGNMENTS)))
          .addMethod(
              getMoveAssignmentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.MoveAssignmentRequest,
                      com.google.cloud.bigquery.reservation.v1.Assignment>(
                      this, METHODID_MOVE_ASSIGNMENT)))
          .addMethod(
              getUpdateAssignmentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.UpdateAssignmentRequest,
                      com.google.cloud.bigquery.reservation.v1.Assignment>(
                      this, METHODID_UPDATE_ASSIGNMENT)))
          .addMethod(
              getGetBiReservationMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.GetBiReservationRequest,
                      com.google.cloud.bigquery.reservation.v1.BiReservation>(
                      this, METHODID_GET_BI_RESERVATION)))
          .addMethod(
              getUpdateBiReservationMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.UpdateBiReservationRequest,
                      com.google.cloud.bigquery.reservation.v1.BiReservation>(
                      this, METHODID_UPDATE_BI_RESERVATION)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * This API allows users to manage their flat-rate BigQuery reservations.
   * A reservation provides computational resource guarantees, in the form of
   * [slots](https://cloud.google.com/bigquery/docs/slots), to users. A slot is a
   * unit of computational power in BigQuery, and serves as the basic unit of
   * parallelism. In a scan of a multi-partitioned table, a single slot operates
   * on a single partition of the table. A reservation resource exists as a child
   * resource of the admin project and location, e.g.:
   *   `projects/myproject/locations/US/reservations/reservationName`.
   * A capacity commitment is a way to purchase compute capacity for BigQuery jobs
   * (in the form of slots) with some committed period of usage. A capacity
   * commitment resource exists as a child resource of the admin project and
   * location, e.g.:
   *   `projects/myproject/locations/US/capacityCommitments/id`.
   * </pre>
   */
  public static final class ReservationServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ReservationServiceStub> {
    private ReservationServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReservationServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new reservation resource.
     * </pre>
     */
    public void createReservation(
        com.google.cloud.bigquery.reservation.v1.CreateReservationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.Reservation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateReservationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the reservations for the project in the specified location.
     * </pre>
     */
    public void listReservations(
        com.google.cloud.bigquery.reservation.v1.ListReservationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.reservation.v1.ListReservationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListReservationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns information about the reservation.
     * </pre>
     */
    public void getReservation(
        com.google.cloud.bigquery.reservation.v1.GetReservationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.Reservation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetReservationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a reservation.
     * Returns `google.rpc.Code.FAILED_PRECONDITION` when reservation has
     * assignments.
     * </pre>
     */
    public void deleteReservation(
        com.google.cloud.bigquery.reservation.v1.DeleteReservationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteReservationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing reservation resource.
     * </pre>
     */
    public void updateReservation(
        com.google.cloud.bigquery.reservation.v1.UpdateReservationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.Reservation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateReservationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new capacity commitment resource.
     * </pre>
     */
    public void createCapacityCommitment(
        com.google.cloud.bigquery.reservation.v1.CreateCapacityCommitmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCapacityCommitmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the capacity commitments for the admin project.
     * </pre>
     */
    public void listCapacityCommitments(
        com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCapacityCommitmentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns information about the capacity commitment.
     * </pre>
     */
    public void getCapacityCommitment(
        com.google.cloud.bigquery.reservation.v1.GetCapacityCommitmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCapacityCommitmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a capacity commitment. Attempting to delete capacity commitment
     * before its commitment_end_time will fail with the error code
     * `google.rpc.Code.FAILED_PRECONDITION`.
     * </pre>
     */
    public void deleteCapacityCommitment(
        com.google.cloud.bigquery.reservation.v1.DeleteCapacityCommitmentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCapacityCommitmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing capacity commitment.
     * Only `plan` and `renewal_plan` fields can be updated.
     * Plan can only be changed to a plan of a longer commitment period.
     * Attempting to change to a plan with shorter commitment period will fail
     * with the error code `google.rpc.Code.FAILED_PRECONDITION`.
     * </pre>
     */
    public void updateCapacityCommitment(
        com.google.cloud.bigquery.reservation.v1.UpdateCapacityCommitmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCapacityCommitmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Splits capacity commitment to two commitments of the same plan and
     * `commitment_end_time`.
     * A common use case is to enable downgrading commitments.
     * For example, in order to downgrade from 10000 slots to 8000, you might
     * split a 10000 capacity commitment into commitments of 2000 and 8000. Then,
     * you delete the first one after the commitment end time passes.
     * </pre>
     */
    public void splitCapacityCommitment(
        com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSplitCapacityCommitmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Merges capacity commitments of the same plan into a single commitment.
     * The resulting capacity commitment has the greater commitment_end_time
     * out of the to-be-merged capacity commitments.
     * Attempting to merge capacity commitments of different plan will fail
     * with the error code `google.rpc.Code.FAILED_PRECONDITION`.
     * </pre>
     */
    public void mergeCapacityCommitments(
        com.google.cloud.bigquery.reservation.v1.MergeCapacityCommitmentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMergeCapacityCommitmentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an assignment object which allows the given project to submit jobs
     * of a certain type using slots from the specified reservation.
     * Currently a
     * resource (project, folder, organization) can only have one assignment per
     * each (job_type, location) combination, and that reservation will be used
     * for all jobs of the matching type.
     * Different assignments can be created on different levels of the
     * projects, folders or organization hierarchy.  During query execution,
     * the assignment is looked up at the project, folder and organization levels
     * in that order. The first assignment found is applied to the query.
     * When creating assignments, it does not matter if other assignments exist at
     * higher levels.
     * Example:
     * * The organization `organizationA` contains two projects, `project1`
     *   and `project2`.
     * * Assignments for all three entities (`organizationA`, `project1`, and
     *   `project2`) could all be created and mapped to the same or different
     *   reservations.
     * "None" assignments represent an absence of the assignment. Projects
     * assigned to None use on-demand pricing. To create a "None" assignment, use
     * "none" as a reservation_id in the parent. Example parent:
     * `projects/myproject/locations/US/reservations/none`.
     * Returns `google.rpc.Code.PERMISSION_DENIED` if user does not have
     * 'bigquery.admin' permissions on the project using the reservation
     * and the project that owns this reservation.
     * Returns `google.rpc.Code.INVALID_ARGUMENT` when location of the assignment
     * does not match location of the reservation.
     * </pre>
     */
    public void createAssignment(
        com.google.cloud.bigquery.reservation.v1.CreateAssignmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.Assignment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAssignmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists assignments.
     * Only explicitly created assignments will be returned.
     * Example:
     * * Organization `organizationA` contains two projects, `project1` and
     *   `project2`.
     * * Reservation `res1` exists and was created previously.
     * * CreateAssignment was used previously to define the following
     *   associations between entities and reservations: `&lt;organizationA, res1&gt;`
     *   and `&lt;project1, res1&gt;`
     * In this example, ListAssignments will just return the above two assignments
     * for reservation `res1`, and no expansion/merge will happen.
     * The wildcard "-" can be used for
     * reservations in the request. In that case all assignments belongs to the
     * specified project and location will be listed.
     * **Note** "-" cannot be used for projects nor locations.
     * </pre>
     */
    public void listAssignments(
        com.google.cloud.bigquery.reservation.v1.ListAssignmentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.reservation.v1.ListAssignmentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAssignmentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a assignment. No expansion will happen.
     * Example:
     * * Organization `organizationA` contains two projects, `project1` and
     *   `project2`.
     * * Reservation `res1` exists and was created previously.
     * * CreateAssignment was used previously to define the following
     *   associations between entities and reservations: `&lt;organizationA, res1&gt;`
     *   and `&lt;project1, res1&gt;`
     * In this example, deletion of the `&lt;organizationA, res1&gt;` assignment won't
     * affect the other assignment `&lt;project1, res1&gt;`. After said deletion,
     * queries from `project1` will still use `res1` while queries from
     * `project2` will switch to use on-demand mode.
     * </pre>
     */
    public void deleteAssignment(
        com.google.cloud.bigquery.reservation.v1.DeleteAssignmentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAssignmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Looks up assignments for a specified resource for a particular
     * region. If the request is about a project:
     * 1. Assignments created on the project will be returned if they exist.
     * 2. Otherwise assignments created on the closest ancestor will be
     *    returned.
     * 3. Assignments for different JobTypes will all be returned.
     * The same logic applies if the request is about a folder.
     * If the request is about an organization, then assignments created on the
     * organization will be returned (organization doesn't have ancestors).
     * Comparing to ListAssignments, there are some behavior
     * differences:
     * 1. permission on the assignee will be verified in this API.
     * 2. Hierarchy lookup (project-&gt;folder-&gt;organization) happens in this API.
     * 3. Parent here is `projects/&#42;&#47;locations/&#42;`, instead of
     *    `projects/&#42;&#47;locations/&#42;reservations/&#42;`.
     * **Note** "-" cannot be used for projects
     * nor locations.
     * </pre>
     */
    @java.lang.Deprecated
    public void searchAssignments(
        com.google.cloud.bigquery.reservation.v1.SearchAssignmentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.reservation.v1.SearchAssignmentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchAssignmentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Looks up assignments for a specified resource for a particular region.
     * If the request is about a project:
     * 1. Assignments created on the project will be returned if they exist.
     * 2. Otherwise assignments created on the closest ancestor will be
     *    returned.
     * 3. Assignments for different JobTypes will all be returned.
     * The same logic applies if the request is about a folder.
     * If the request is about an organization, then assignments created on the
     * organization will be returned (organization doesn't have ancestors).
     * Comparing to ListAssignments, there are some behavior
     * differences:
     * 1. permission on the assignee will be verified in this API.
     * 2. Hierarchy lookup (project-&gt;folder-&gt;organization) happens in this API.
     * 3. Parent here is `projects/&#42;&#47;locations/&#42;`, instead of
     *    `projects/&#42;&#47;locations/&#42;reservations/&#42;`.
     * </pre>
     */
    public void searchAllAssignments(
        com.google.cloud.bigquery.reservation.v1.SearchAllAssignmentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.reservation.v1.SearchAllAssignmentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchAllAssignmentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Moves an assignment under a new reservation.
     * This differs from removing an existing assignment and recreating a new one
     * by providing a transactional change that ensures an assignee always has an
     * associated reservation.
     * </pre>
     */
    public void moveAssignment(
        com.google.cloud.bigquery.reservation.v1.MoveAssignmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.Assignment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMoveAssignmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing assignment.
     * Only the `priority` field can be updated.
     * </pre>
     */
    public void updateAssignment(
        com.google.cloud.bigquery.reservation.v1.UpdateAssignmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.Assignment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAssignmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a BI reservation.
     * </pre>
     */
    public void getBiReservation(
        com.google.cloud.bigquery.reservation.v1.GetBiReservationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.BiReservation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBiReservationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a BI reservation.
     * Only fields specified in the `field_mask` are updated.
     * A singleton BI reservation always exists with default size 0.
     * In order to reserve BI capacity it needs to be updated to an amount
     * greater than 0. In order to release BI capacity reservation size
     * must be set to 0.
     * </pre>
     */
    public void updateBiReservation(
        com.google.cloud.bigquery.reservation.v1.UpdateBiReservationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.BiReservation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateBiReservationMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * This API allows users to manage their flat-rate BigQuery reservations.
   * A reservation provides computational resource guarantees, in the form of
   * [slots](https://cloud.google.com/bigquery/docs/slots), to users. A slot is a
   * unit of computational power in BigQuery, and serves as the basic unit of
   * parallelism. In a scan of a multi-partitioned table, a single slot operates
   * on a single partition of the table. A reservation resource exists as a child
   * resource of the admin project and location, e.g.:
   *   `projects/myproject/locations/US/reservations/reservationName`.
   * A capacity commitment is a way to purchase compute capacity for BigQuery jobs
   * (in the form of slots) with some committed period of usage. A capacity
   * commitment resource exists as a child resource of the admin project and
   * location, e.g.:
   *   `projects/myproject/locations/US/capacityCommitments/id`.
   * </pre>
   */
  public static final class ReservationServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ReservationServiceBlockingStub> {
    private ReservationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReservationServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new reservation resource.
     * </pre>
     */
    public com.google.cloud.bigquery.reservation.v1.Reservation createReservation(
        com.google.cloud.bigquery.reservation.v1.CreateReservationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateReservationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the reservations for the project in the specified location.
     * </pre>
     */
    public com.google.cloud.bigquery.reservation.v1.ListReservationsResponse listReservations(
        com.google.cloud.bigquery.reservation.v1.ListReservationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListReservationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns information about the reservation.
     * </pre>
     */
    public com.google.cloud.bigquery.reservation.v1.Reservation getReservation(
        com.google.cloud.bigquery.reservation.v1.GetReservationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetReservationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a reservation.
     * Returns `google.rpc.Code.FAILED_PRECONDITION` when reservation has
     * assignments.
     * </pre>
     */
    public com.google.protobuf.Empty deleteReservation(
        com.google.cloud.bigquery.reservation.v1.DeleteReservationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteReservationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing reservation resource.
     * </pre>
     */
    public com.google.cloud.bigquery.reservation.v1.Reservation updateReservation(
        com.google.cloud.bigquery.reservation.v1.UpdateReservationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateReservationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new capacity commitment resource.
     * </pre>
     */
    public com.google.cloud.bigquery.reservation.v1.CapacityCommitment createCapacityCommitment(
        com.google.cloud.bigquery.reservation.v1.CreateCapacityCommitmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCapacityCommitmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the capacity commitments for the admin project.
     * </pre>
     */
    public com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsResponse
        listCapacityCommitments(
            com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCapacityCommitmentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns information about the capacity commitment.
     * </pre>
     */
    public com.google.cloud.bigquery.reservation.v1.CapacityCommitment getCapacityCommitment(
        com.google.cloud.bigquery.reservation.v1.GetCapacityCommitmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCapacityCommitmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a capacity commitment. Attempting to delete capacity commitment
     * before its commitment_end_time will fail with the error code
     * `google.rpc.Code.FAILED_PRECONDITION`.
     * </pre>
     */
    public com.google.protobuf.Empty deleteCapacityCommitment(
        com.google.cloud.bigquery.reservation.v1.DeleteCapacityCommitmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCapacityCommitmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing capacity commitment.
     * Only `plan` and `renewal_plan` fields can be updated.
     * Plan can only be changed to a plan of a longer commitment period.
     * Attempting to change to a plan with shorter commitment period will fail
     * with the error code `google.rpc.Code.FAILED_PRECONDITION`.
     * </pre>
     */
    public com.google.cloud.bigquery.reservation.v1.CapacityCommitment updateCapacityCommitment(
        com.google.cloud.bigquery.reservation.v1.UpdateCapacityCommitmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCapacityCommitmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Splits capacity commitment to two commitments of the same plan and
     * `commitment_end_time`.
     * A common use case is to enable downgrading commitments.
     * For example, in order to downgrade from 10000 slots to 8000, you might
     * split a 10000 capacity commitment into commitments of 2000 and 8000. Then,
     * you delete the first one after the commitment end time passes.
     * </pre>
     */
    public com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentResponse
        splitCapacityCommitment(
            com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSplitCapacityCommitmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Merges capacity commitments of the same plan into a single commitment.
     * The resulting capacity commitment has the greater commitment_end_time
     * out of the to-be-merged capacity commitments.
     * Attempting to merge capacity commitments of different plan will fail
     * with the error code `google.rpc.Code.FAILED_PRECONDITION`.
     * </pre>
     */
    public com.google.cloud.bigquery.reservation.v1.CapacityCommitment mergeCapacityCommitments(
        com.google.cloud.bigquery.reservation.v1.MergeCapacityCommitmentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMergeCapacityCommitmentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an assignment object which allows the given project to submit jobs
     * of a certain type using slots from the specified reservation.
     * Currently a
     * resource (project, folder, organization) can only have one assignment per
     * each (job_type, location) combination, and that reservation will be used
     * for all jobs of the matching type.
     * Different assignments can be created on different levels of the
     * projects, folders or organization hierarchy.  During query execution,
     * the assignment is looked up at the project, folder and organization levels
     * in that order. The first assignment found is applied to the query.
     * When creating assignments, it does not matter if other assignments exist at
     * higher levels.
     * Example:
     * * The organization `organizationA` contains two projects, `project1`
     *   and `project2`.
     * * Assignments for all three entities (`organizationA`, `project1`, and
     *   `project2`) could all be created and mapped to the same or different
     *   reservations.
     * "None" assignments represent an absence of the assignment. Projects
     * assigned to None use on-demand pricing. To create a "None" assignment, use
     * "none" as a reservation_id in the parent. Example parent:
     * `projects/myproject/locations/US/reservations/none`.
     * Returns `google.rpc.Code.PERMISSION_DENIED` if user does not have
     * 'bigquery.admin' permissions on the project using the reservation
     * and the project that owns this reservation.
     * Returns `google.rpc.Code.INVALID_ARGUMENT` when location of the assignment
     * does not match location of the reservation.
     * </pre>
     */
    public com.google.cloud.bigquery.reservation.v1.Assignment createAssignment(
        com.google.cloud.bigquery.reservation.v1.CreateAssignmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAssignmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists assignments.
     * Only explicitly created assignments will be returned.
     * Example:
     * * Organization `organizationA` contains two projects, `project1` and
     *   `project2`.
     * * Reservation `res1` exists and was created previously.
     * * CreateAssignment was used previously to define the following
     *   associations between entities and reservations: `&lt;organizationA, res1&gt;`
     *   and `&lt;project1, res1&gt;`
     * In this example, ListAssignments will just return the above two assignments
     * for reservation `res1`, and no expansion/merge will happen.
     * The wildcard "-" can be used for
     * reservations in the request. In that case all assignments belongs to the
     * specified project and location will be listed.
     * **Note** "-" cannot be used for projects nor locations.
     * </pre>
     */
    public com.google.cloud.bigquery.reservation.v1.ListAssignmentsResponse listAssignments(
        com.google.cloud.bigquery.reservation.v1.ListAssignmentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAssignmentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a assignment. No expansion will happen.
     * Example:
     * * Organization `organizationA` contains two projects, `project1` and
     *   `project2`.
     * * Reservation `res1` exists and was created previously.
     * * CreateAssignment was used previously to define the following
     *   associations between entities and reservations: `&lt;organizationA, res1&gt;`
     *   and `&lt;project1, res1&gt;`
     * In this example, deletion of the `&lt;organizationA, res1&gt;` assignment won't
     * affect the other assignment `&lt;project1, res1&gt;`. After said deletion,
     * queries from `project1` will still use `res1` while queries from
     * `project2` will switch to use on-demand mode.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAssignment(
        com.google.cloud.bigquery.reservation.v1.DeleteAssignmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAssignmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Looks up assignments for a specified resource for a particular
     * region. If the request is about a project:
     * 1. Assignments created on the project will be returned if they exist.
     * 2. Otherwise assignments created on the closest ancestor will be
     *    returned.
     * 3. Assignments for different JobTypes will all be returned.
     * The same logic applies if the request is about a folder.
     * If the request is about an organization, then assignments created on the
     * organization will be returned (organization doesn't have ancestors).
     * Comparing to ListAssignments, there are some behavior
     * differences:
     * 1. permission on the assignee will be verified in this API.
     * 2. Hierarchy lookup (project-&gt;folder-&gt;organization) happens in this API.
     * 3. Parent here is `projects/&#42;&#47;locations/&#42;`, instead of
     *    `projects/&#42;&#47;locations/&#42;reservations/&#42;`.
     * **Note** "-" cannot be used for projects
     * nor locations.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.cloud.bigquery.reservation.v1.SearchAssignmentsResponse searchAssignments(
        com.google.cloud.bigquery.reservation.v1.SearchAssignmentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchAssignmentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Looks up assignments for a specified resource for a particular region.
     * If the request is about a project:
     * 1. Assignments created on the project will be returned if they exist.
     * 2. Otherwise assignments created on the closest ancestor will be
     *    returned.
     * 3. Assignments for different JobTypes will all be returned.
     * The same logic applies if the request is about a folder.
     * If the request is about an organization, then assignments created on the
     * organization will be returned (organization doesn't have ancestors).
     * Comparing to ListAssignments, there are some behavior
     * differences:
     * 1. permission on the assignee will be verified in this API.
     * 2. Hierarchy lookup (project-&gt;folder-&gt;organization) happens in this API.
     * 3. Parent here is `projects/&#42;&#47;locations/&#42;`, instead of
     *    `projects/&#42;&#47;locations/&#42;reservations/&#42;`.
     * </pre>
     */
    public com.google.cloud.bigquery.reservation.v1.SearchAllAssignmentsResponse
        searchAllAssignments(
            com.google.cloud.bigquery.reservation.v1.SearchAllAssignmentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchAllAssignmentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Moves an assignment under a new reservation.
     * This differs from removing an existing assignment and recreating a new one
     * by providing a transactional change that ensures an assignee always has an
     * associated reservation.
     * </pre>
     */
    public com.google.cloud.bigquery.reservation.v1.Assignment moveAssignment(
        com.google.cloud.bigquery.reservation.v1.MoveAssignmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMoveAssignmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing assignment.
     * Only the `priority` field can be updated.
     * </pre>
     */
    public com.google.cloud.bigquery.reservation.v1.Assignment updateAssignment(
        com.google.cloud.bigquery.reservation.v1.UpdateAssignmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAssignmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a BI reservation.
     * </pre>
     */
    public com.google.cloud.bigquery.reservation.v1.BiReservation getBiReservation(
        com.google.cloud.bigquery.reservation.v1.GetBiReservationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBiReservationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a BI reservation.
     * Only fields specified in the `field_mask` are updated.
     * A singleton BI reservation always exists with default size 0.
     * In order to reserve BI capacity it needs to be updated to an amount
     * greater than 0. In order to release BI capacity reservation size
     * must be set to 0.
     * </pre>
     */
    public com.google.cloud.bigquery.reservation.v1.BiReservation updateBiReservation(
        com.google.cloud.bigquery.reservation.v1.UpdateBiReservationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBiReservationMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * This API allows users to manage their flat-rate BigQuery reservations.
   * A reservation provides computational resource guarantees, in the form of
   * [slots](https://cloud.google.com/bigquery/docs/slots), to users. A slot is a
   * unit of computational power in BigQuery, and serves as the basic unit of
   * parallelism. In a scan of a multi-partitioned table, a single slot operates
   * on a single partition of the table. A reservation resource exists as a child
   * resource of the admin project and location, e.g.:
   *   `projects/myproject/locations/US/reservations/reservationName`.
   * A capacity commitment is a way to purchase compute capacity for BigQuery jobs
   * (in the form of slots) with some committed period of usage. A capacity
   * commitment resource exists as a child resource of the admin project and
   * location, e.g.:
   *   `projects/myproject/locations/US/capacityCommitments/id`.
   * </pre>
   */
  public static final class ReservationServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ReservationServiceFutureStub> {
    private ReservationServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReservationServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new reservation resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.Reservation>
        createReservation(
            com.google.cloud.bigquery.reservation.v1.CreateReservationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateReservationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the reservations for the project in the specified location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.ListReservationsResponse>
        listReservations(com.google.cloud.bigquery.reservation.v1.ListReservationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListReservationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns information about the reservation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.Reservation>
        getReservation(com.google.cloud.bigquery.reservation.v1.GetReservationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetReservationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a reservation.
     * Returns `google.rpc.Code.FAILED_PRECONDITION` when reservation has
     * assignments.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteReservation(
            com.google.cloud.bigquery.reservation.v1.DeleteReservationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteReservationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing reservation resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.Reservation>
        updateReservation(
            com.google.cloud.bigquery.reservation.v1.UpdateReservationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateReservationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new capacity commitment resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
        createCapacityCommitment(
            com.google.cloud.bigquery.reservation.v1.CreateCapacityCommitmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCapacityCommitmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the capacity commitments for the admin project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsResponse>
        listCapacityCommitments(
            com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCapacityCommitmentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns information about the capacity commitment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
        getCapacityCommitment(
            com.google.cloud.bigquery.reservation.v1.GetCapacityCommitmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCapacityCommitmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a capacity commitment. Attempting to delete capacity commitment
     * before its commitment_end_time will fail with the error code
     * `google.rpc.Code.FAILED_PRECONDITION`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteCapacityCommitment(
            com.google.cloud.bigquery.reservation.v1.DeleteCapacityCommitmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCapacityCommitmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing capacity commitment.
     * Only `plan` and `renewal_plan` fields can be updated.
     * Plan can only be changed to a plan of a longer commitment period.
     * Attempting to change to a plan with shorter commitment period will fail
     * with the error code `google.rpc.Code.FAILED_PRECONDITION`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
        updateCapacityCommitment(
            com.google.cloud.bigquery.reservation.v1.UpdateCapacityCommitmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCapacityCommitmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Splits capacity commitment to two commitments of the same plan and
     * `commitment_end_time`.
     * A common use case is to enable downgrading commitments.
     * For example, in order to downgrade from 10000 slots to 8000, you might
     * split a 10000 capacity commitment into commitments of 2000 and 8000. Then,
     * you delete the first one after the commitment end time passes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentResponse>
        splitCapacityCommitment(
            com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSplitCapacityCommitmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Merges capacity commitments of the same plan into a single commitment.
     * The resulting capacity commitment has the greater commitment_end_time
     * out of the to-be-merged capacity commitments.
     * Attempting to merge capacity commitments of different plan will fail
     * with the error code `google.rpc.Code.FAILED_PRECONDITION`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
        mergeCapacityCommitments(
            com.google.cloud.bigquery.reservation.v1.MergeCapacityCommitmentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMergeCapacityCommitmentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an assignment object which allows the given project to submit jobs
     * of a certain type using slots from the specified reservation.
     * Currently a
     * resource (project, folder, organization) can only have one assignment per
     * each (job_type, location) combination, and that reservation will be used
     * for all jobs of the matching type.
     * Different assignments can be created on different levels of the
     * projects, folders or organization hierarchy.  During query execution,
     * the assignment is looked up at the project, folder and organization levels
     * in that order. The first assignment found is applied to the query.
     * When creating assignments, it does not matter if other assignments exist at
     * higher levels.
     * Example:
     * * The organization `organizationA` contains two projects, `project1`
     *   and `project2`.
     * * Assignments for all three entities (`organizationA`, `project1`, and
     *   `project2`) could all be created and mapped to the same or different
     *   reservations.
     * "None" assignments represent an absence of the assignment. Projects
     * assigned to None use on-demand pricing. To create a "None" assignment, use
     * "none" as a reservation_id in the parent. Example parent:
     * `projects/myproject/locations/US/reservations/none`.
     * Returns `google.rpc.Code.PERMISSION_DENIED` if user does not have
     * 'bigquery.admin' permissions on the project using the reservation
     * and the project that owns this reservation.
     * Returns `google.rpc.Code.INVALID_ARGUMENT` when location of the assignment
     * does not match location of the reservation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.Assignment>
        createAssignment(com.google.cloud.bigquery.reservation.v1.CreateAssignmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAssignmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists assignments.
     * Only explicitly created assignments will be returned.
     * Example:
     * * Organization `organizationA` contains two projects, `project1` and
     *   `project2`.
     * * Reservation `res1` exists and was created previously.
     * * CreateAssignment was used previously to define the following
     *   associations between entities and reservations: `&lt;organizationA, res1&gt;`
     *   and `&lt;project1, res1&gt;`
     * In this example, ListAssignments will just return the above two assignments
     * for reservation `res1`, and no expansion/merge will happen.
     * The wildcard "-" can be used for
     * reservations in the request. In that case all assignments belongs to the
     * specified project and location will be listed.
     * **Note** "-" cannot be used for projects nor locations.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.ListAssignmentsResponse>
        listAssignments(com.google.cloud.bigquery.reservation.v1.ListAssignmentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAssignmentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a assignment. No expansion will happen.
     * Example:
     * * Organization `organizationA` contains two projects, `project1` and
     *   `project2`.
     * * Reservation `res1` exists and was created previously.
     * * CreateAssignment was used previously to define the following
     *   associations between entities and reservations: `&lt;organizationA, res1&gt;`
     *   and `&lt;project1, res1&gt;`
     * In this example, deletion of the `&lt;organizationA, res1&gt;` assignment won't
     * affect the other assignment `&lt;project1, res1&gt;`. After said deletion,
     * queries from `project1` will still use `res1` while queries from
     * `project2` will switch to use on-demand mode.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteAssignment(com.google.cloud.bigquery.reservation.v1.DeleteAssignmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAssignmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Looks up assignments for a specified resource for a particular
     * region. If the request is about a project:
     * 1. Assignments created on the project will be returned if they exist.
     * 2. Otherwise assignments created on the closest ancestor will be
     *    returned.
     * 3. Assignments for different JobTypes will all be returned.
     * The same logic applies if the request is about a folder.
     * If the request is about an organization, then assignments created on the
     * organization will be returned (organization doesn't have ancestors).
     * Comparing to ListAssignments, there are some behavior
     * differences:
     * 1. permission on the assignee will be verified in this API.
     * 2. Hierarchy lookup (project-&gt;folder-&gt;organization) happens in this API.
     * 3. Parent here is `projects/&#42;&#47;locations/&#42;`, instead of
     *    `projects/&#42;&#47;locations/&#42;reservations/&#42;`.
     * **Note** "-" cannot be used for projects
     * nor locations.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.SearchAssignmentsResponse>
        searchAssignments(
            com.google.cloud.bigquery.reservation.v1.SearchAssignmentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchAssignmentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Looks up assignments for a specified resource for a particular region.
     * If the request is about a project:
     * 1. Assignments created on the project will be returned if they exist.
     * 2. Otherwise assignments created on the closest ancestor will be
     *    returned.
     * 3. Assignments for different JobTypes will all be returned.
     * The same logic applies if the request is about a folder.
     * If the request is about an organization, then assignments created on the
     * organization will be returned (organization doesn't have ancestors).
     * Comparing to ListAssignments, there are some behavior
     * differences:
     * 1. permission on the assignee will be verified in this API.
     * 2. Hierarchy lookup (project-&gt;folder-&gt;organization) happens in this API.
     * 3. Parent here is `projects/&#42;&#47;locations/&#42;`, instead of
     *    `projects/&#42;&#47;locations/&#42;reservations/&#42;`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.SearchAllAssignmentsResponse>
        searchAllAssignments(
            com.google.cloud.bigquery.reservation.v1.SearchAllAssignmentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchAllAssignmentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Moves an assignment under a new reservation.
     * This differs from removing an existing assignment and recreating a new one
     * by providing a transactional change that ensures an assignee always has an
     * associated reservation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.Assignment>
        moveAssignment(com.google.cloud.bigquery.reservation.v1.MoveAssignmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMoveAssignmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing assignment.
     * Only the `priority` field can be updated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.Assignment>
        updateAssignment(com.google.cloud.bigquery.reservation.v1.UpdateAssignmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAssignmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a BI reservation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.BiReservation>
        getBiReservation(com.google.cloud.bigquery.reservation.v1.GetBiReservationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBiReservationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a BI reservation.
     * Only fields specified in the `field_mask` are updated.
     * A singleton BI reservation always exists with default size 0.
     * In order to reserve BI capacity it needs to be updated to an amount
     * greater than 0. In order to release BI capacity reservation size
     * must be set to 0.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.BiReservation>
        updateBiReservation(
            com.google.cloud.bigquery.reservation.v1.UpdateBiReservationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBiReservationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_RESERVATION = 0;
  private static final int METHODID_LIST_RESERVATIONS = 1;
  private static final int METHODID_GET_RESERVATION = 2;
  private static final int METHODID_DELETE_RESERVATION = 3;
  private static final int METHODID_UPDATE_RESERVATION = 4;
  private static final int METHODID_CREATE_CAPACITY_COMMITMENT = 5;
  private static final int METHODID_LIST_CAPACITY_COMMITMENTS = 6;
  private static final int METHODID_GET_CAPACITY_COMMITMENT = 7;
  private static final int METHODID_DELETE_CAPACITY_COMMITMENT = 8;
  private static final int METHODID_UPDATE_CAPACITY_COMMITMENT = 9;
  private static final int METHODID_SPLIT_CAPACITY_COMMITMENT = 10;
  private static final int METHODID_MERGE_CAPACITY_COMMITMENTS = 11;
  private static final int METHODID_CREATE_ASSIGNMENT = 12;
  private static final int METHODID_LIST_ASSIGNMENTS = 13;
  private static final int METHODID_DELETE_ASSIGNMENT = 14;
  private static final int METHODID_SEARCH_ASSIGNMENTS = 15;
  private static final int METHODID_SEARCH_ALL_ASSIGNMENTS = 16;
  private static final int METHODID_MOVE_ASSIGNMENT = 17;
  private static final int METHODID_UPDATE_ASSIGNMENT = 18;
  private static final int METHODID_GET_BI_RESERVATION = 19;
  private static final int METHODID_UPDATE_BI_RESERVATION = 20;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ReservationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ReservationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_RESERVATION:
          serviceImpl.createReservation(
              (com.google.cloud.bigquery.reservation.v1.CreateReservationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.Reservation>)
                  responseObserver);
          break;
        case METHODID_LIST_RESERVATIONS:
          serviceImpl.listReservations(
              (com.google.cloud.bigquery.reservation.v1.ListReservationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.reservation.v1.ListReservationsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_RESERVATION:
          serviceImpl.getReservation(
              (com.google.cloud.bigquery.reservation.v1.GetReservationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.Reservation>)
                  responseObserver);
          break;
        case METHODID_DELETE_RESERVATION:
          serviceImpl.deleteReservation(
              (com.google.cloud.bigquery.reservation.v1.DeleteReservationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_RESERVATION:
          serviceImpl.updateReservation(
              (com.google.cloud.bigquery.reservation.v1.UpdateReservationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.Reservation>)
                  responseObserver);
          break;
        case METHODID_CREATE_CAPACITY_COMMITMENT:
          serviceImpl.createCapacityCommitment(
              (com.google.cloud.bigquery.reservation.v1.CreateCapacityCommitmentRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.reservation.v1.CapacityCommitment>)
                  responseObserver);
          break;
        case METHODID_LIST_CAPACITY_COMMITMENTS:
          serviceImpl.listCapacityCommitments(
              (com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CAPACITY_COMMITMENT:
          serviceImpl.getCapacityCommitment(
              (com.google.cloud.bigquery.reservation.v1.GetCapacityCommitmentRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.reservation.v1.CapacityCommitment>)
                  responseObserver);
          break;
        case METHODID_DELETE_CAPACITY_COMMITMENT:
          serviceImpl.deleteCapacityCommitment(
              (com.google.cloud.bigquery.reservation.v1.DeleteCapacityCommitmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_CAPACITY_COMMITMENT:
          serviceImpl.updateCapacityCommitment(
              (com.google.cloud.bigquery.reservation.v1.UpdateCapacityCommitmentRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.reservation.v1.CapacityCommitment>)
                  responseObserver);
          break;
        case METHODID_SPLIT_CAPACITY_COMMITMENT:
          serviceImpl.splitCapacityCommitment(
              (com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentResponse>)
                  responseObserver);
          break;
        case METHODID_MERGE_CAPACITY_COMMITMENTS:
          serviceImpl.mergeCapacityCommitments(
              (com.google.cloud.bigquery.reservation.v1.MergeCapacityCommitmentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.reservation.v1.CapacityCommitment>)
                  responseObserver);
          break;
        case METHODID_CREATE_ASSIGNMENT:
          serviceImpl.createAssignment(
              (com.google.cloud.bigquery.reservation.v1.CreateAssignmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.Assignment>)
                  responseObserver);
          break;
        case METHODID_LIST_ASSIGNMENTS:
          serviceImpl.listAssignments(
              (com.google.cloud.bigquery.reservation.v1.ListAssignmentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.reservation.v1.ListAssignmentsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_ASSIGNMENT:
          serviceImpl.deleteAssignment(
              (com.google.cloud.bigquery.reservation.v1.DeleteAssignmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_SEARCH_ASSIGNMENTS:
          serviceImpl.searchAssignments(
              (com.google.cloud.bigquery.reservation.v1.SearchAssignmentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.reservation.v1.SearchAssignmentsResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_ALL_ASSIGNMENTS:
          serviceImpl.searchAllAssignments(
              (com.google.cloud.bigquery.reservation.v1.SearchAllAssignmentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.reservation.v1.SearchAllAssignmentsResponse>)
                  responseObserver);
          break;
        case METHODID_MOVE_ASSIGNMENT:
          serviceImpl.moveAssignment(
              (com.google.cloud.bigquery.reservation.v1.MoveAssignmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.Assignment>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ASSIGNMENT:
          serviceImpl.updateAssignment(
              (com.google.cloud.bigquery.reservation.v1.UpdateAssignmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.Assignment>)
                  responseObserver);
          break;
        case METHODID_GET_BI_RESERVATION:
          serviceImpl.getBiReservation(
              (com.google.cloud.bigquery.reservation.v1.GetBiReservationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.BiReservation>)
                  responseObserver);
          break;
        case METHODID_UPDATE_BI_RESERVATION:
          serviceImpl.updateBiReservation(
              (com.google.cloud.bigquery.reservation.v1.UpdateBiReservationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.BiReservation>)
                  responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private abstract static class ReservationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReservationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.bigquery.reservation.v1.ReservationProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ReservationService");
    }
  }

  private static final class ReservationServiceFileDescriptorSupplier
      extends ReservationServiceBaseDescriptorSupplier {
    ReservationServiceFileDescriptorSupplier() {}
  }

  private static final class ReservationServiceMethodDescriptorSupplier
      extends ReservationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ReservationServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ReservationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ReservationServiceFileDescriptorSupplier())
                      .addMethod(getCreateReservationMethod())
                      .addMethod(getListReservationsMethod())
                      .addMethod(getGetReservationMethod())
                      .addMethod(getDeleteReservationMethod())
                      .addMethod(getUpdateReservationMethod())
                      .addMethod(getCreateCapacityCommitmentMethod())
                      .addMethod(getListCapacityCommitmentsMethod())
                      .addMethod(getGetCapacityCommitmentMethod())
                      .addMethod(getDeleteCapacityCommitmentMethod())
                      .addMethod(getUpdateCapacityCommitmentMethod())
                      .addMethod(getSplitCapacityCommitmentMethod())
                      .addMethod(getMergeCapacityCommitmentsMethod())
                      .addMethod(getCreateAssignmentMethod())
                      .addMethod(getListAssignmentsMethod())
                      .addMethod(getDeleteAssignmentMethod())
                      .addMethod(getSearchAssignmentsMethod())
                      .addMethod(getSearchAllAssignmentsMethod())
                      .addMethod(getMoveAssignmentMethod())
                      .addMethod(getUpdateAssignmentMethod())
                      .addMethod(getGetBiReservationMethod())
                      .addMethod(getUpdateBiReservationMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
