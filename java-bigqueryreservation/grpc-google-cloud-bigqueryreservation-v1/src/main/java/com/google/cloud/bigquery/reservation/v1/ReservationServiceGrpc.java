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
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/** */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/bigquery/reservation/v1/reservation.proto")
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

  /** */
  public abstract static class ReservationServiceImplBase implements io.grpc.BindableService {

    /** */
    public void createReservation(
        com.google.cloud.bigquery.reservation.v1.CreateReservationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.Reservation>
            responseObserver) {
      asyncUnimplementedUnaryCall(getCreateReservationMethod(), responseObserver);
    }

    /** */
    public void listReservations(
        com.google.cloud.bigquery.reservation.v1.ListReservationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.reservation.v1.ListReservationsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListReservationsMethod(), responseObserver);
    }

    /** */
    public void getReservation(
        com.google.cloud.bigquery.reservation.v1.GetReservationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.Reservation>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetReservationMethod(), responseObserver);
    }

    /** */
    public void deleteReservation(
        com.google.cloud.bigquery.reservation.v1.DeleteReservationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteReservationMethod(), responseObserver);
    }

    /** */
    public void updateReservation(
        com.google.cloud.bigquery.reservation.v1.UpdateReservationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.Reservation>
            responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateReservationMethod(), responseObserver);
    }

    /** */
    public void createCapacityCommitment(
        com.google.cloud.bigquery.reservation.v1.CreateCapacityCommitmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
            responseObserver) {
      asyncUnimplementedUnaryCall(getCreateCapacityCommitmentMethod(), responseObserver);
    }

    /** */
    public void listCapacityCommitments(
        com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListCapacityCommitmentsMethod(), responseObserver);
    }

    /** */
    public void getCapacityCommitment(
        com.google.cloud.bigquery.reservation.v1.GetCapacityCommitmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetCapacityCommitmentMethod(), responseObserver);
    }

    /** */
    public void deleteCapacityCommitment(
        com.google.cloud.bigquery.reservation.v1.DeleteCapacityCommitmentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteCapacityCommitmentMethod(), responseObserver);
    }

    /** */
    public void updateCapacityCommitment(
        com.google.cloud.bigquery.reservation.v1.UpdateCapacityCommitmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
            responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateCapacityCommitmentMethod(), responseObserver);
    }

    /** */
    public void splitCapacityCommitment(
        com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getSplitCapacityCommitmentMethod(), responseObserver);
    }

    /** */
    public void mergeCapacityCommitments(
        com.google.cloud.bigquery.reservation.v1.MergeCapacityCommitmentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
            responseObserver) {
      asyncUnimplementedUnaryCall(getMergeCapacityCommitmentsMethod(), responseObserver);
    }

    /** */
    public void createAssignment(
        com.google.cloud.bigquery.reservation.v1.CreateAssignmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.Assignment>
            responseObserver) {
      asyncUnimplementedUnaryCall(getCreateAssignmentMethod(), responseObserver);
    }

    /** */
    public void listAssignments(
        com.google.cloud.bigquery.reservation.v1.ListAssignmentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.reservation.v1.ListAssignmentsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListAssignmentsMethod(), responseObserver);
    }

    /** */
    public void deleteAssignment(
        com.google.cloud.bigquery.reservation.v1.DeleteAssignmentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteAssignmentMethod(), responseObserver);
    }

    /** */
    public void searchAssignments(
        com.google.cloud.bigquery.reservation.v1.SearchAssignmentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.reservation.v1.SearchAssignmentsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getSearchAssignmentsMethod(), responseObserver);
    }

    /** */
    public void moveAssignment(
        com.google.cloud.bigquery.reservation.v1.MoveAssignmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.Assignment>
            responseObserver) {
      asyncUnimplementedUnaryCall(getMoveAssignmentMethod(), responseObserver);
    }

    /** */
    public void getBiReservation(
        com.google.cloud.bigquery.reservation.v1.GetBiReservationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.BiReservation>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetBiReservationMethod(), responseObserver);
    }

    /** */
    public void updateBiReservation(
        com.google.cloud.bigquery.reservation.v1.UpdateBiReservationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.BiReservation>
            responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateBiReservationMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateReservationMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.CreateReservationRequest,
                      com.google.cloud.bigquery.reservation.v1.Reservation>(
                      this, METHODID_CREATE_RESERVATION)))
          .addMethod(
              getListReservationsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.ListReservationsRequest,
                      com.google.cloud.bigquery.reservation.v1.ListReservationsResponse>(
                      this, METHODID_LIST_RESERVATIONS)))
          .addMethod(
              getGetReservationMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.GetReservationRequest,
                      com.google.cloud.bigquery.reservation.v1.Reservation>(
                      this, METHODID_GET_RESERVATION)))
          .addMethod(
              getDeleteReservationMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.DeleteReservationRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_RESERVATION)))
          .addMethod(
              getUpdateReservationMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.UpdateReservationRequest,
                      com.google.cloud.bigquery.reservation.v1.Reservation>(
                      this, METHODID_UPDATE_RESERVATION)))
          .addMethod(
              getCreateCapacityCommitmentMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.CreateCapacityCommitmentRequest,
                      com.google.cloud.bigquery.reservation.v1.CapacityCommitment>(
                      this, METHODID_CREATE_CAPACITY_COMMITMENT)))
          .addMethod(
              getListCapacityCommitmentsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsRequest,
                      com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsResponse>(
                      this, METHODID_LIST_CAPACITY_COMMITMENTS)))
          .addMethod(
              getGetCapacityCommitmentMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.GetCapacityCommitmentRequest,
                      com.google.cloud.bigquery.reservation.v1.CapacityCommitment>(
                      this, METHODID_GET_CAPACITY_COMMITMENT)))
          .addMethod(
              getDeleteCapacityCommitmentMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.DeleteCapacityCommitmentRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_CAPACITY_COMMITMENT)))
          .addMethod(
              getUpdateCapacityCommitmentMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.UpdateCapacityCommitmentRequest,
                      com.google.cloud.bigquery.reservation.v1.CapacityCommitment>(
                      this, METHODID_UPDATE_CAPACITY_COMMITMENT)))
          .addMethod(
              getSplitCapacityCommitmentMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentRequest,
                      com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentResponse>(
                      this, METHODID_SPLIT_CAPACITY_COMMITMENT)))
          .addMethod(
              getMergeCapacityCommitmentsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.MergeCapacityCommitmentsRequest,
                      com.google.cloud.bigquery.reservation.v1.CapacityCommitment>(
                      this, METHODID_MERGE_CAPACITY_COMMITMENTS)))
          .addMethod(
              getCreateAssignmentMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.CreateAssignmentRequest,
                      com.google.cloud.bigquery.reservation.v1.Assignment>(
                      this, METHODID_CREATE_ASSIGNMENT)))
          .addMethod(
              getListAssignmentsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.ListAssignmentsRequest,
                      com.google.cloud.bigquery.reservation.v1.ListAssignmentsResponse>(
                      this, METHODID_LIST_ASSIGNMENTS)))
          .addMethod(
              getDeleteAssignmentMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.DeleteAssignmentRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_ASSIGNMENT)))
          .addMethod(
              getSearchAssignmentsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.SearchAssignmentsRequest,
                      com.google.cloud.bigquery.reservation.v1.SearchAssignmentsResponse>(
                      this, METHODID_SEARCH_ASSIGNMENTS)))
          .addMethod(
              getMoveAssignmentMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.MoveAssignmentRequest,
                      com.google.cloud.bigquery.reservation.v1.Assignment>(
                      this, METHODID_MOVE_ASSIGNMENT)))
          .addMethod(
              getGetBiReservationMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.GetBiReservationRequest,
                      com.google.cloud.bigquery.reservation.v1.BiReservation>(
                      this, METHODID_GET_BI_RESERVATION)))
          .addMethod(
              getUpdateBiReservationMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.reservation.v1.UpdateBiReservationRequest,
                      com.google.cloud.bigquery.reservation.v1.BiReservation>(
                      this, METHODID_UPDATE_BI_RESERVATION)))
          .build();
    }
  }

  /** */
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

    /** */
    public void createReservation(
        com.google.cloud.bigquery.reservation.v1.CreateReservationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.Reservation>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateReservationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void listReservations(
        com.google.cloud.bigquery.reservation.v1.ListReservationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.reservation.v1.ListReservationsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListReservationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void getReservation(
        com.google.cloud.bigquery.reservation.v1.GetReservationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.Reservation>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetReservationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void deleteReservation(
        com.google.cloud.bigquery.reservation.v1.DeleteReservationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteReservationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void updateReservation(
        com.google.cloud.bigquery.reservation.v1.UpdateReservationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.Reservation>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateReservationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void createCapacityCommitment(
        com.google.cloud.bigquery.reservation.v1.CreateCapacityCommitmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateCapacityCommitmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void listCapacityCommitments(
        com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListCapacityCommitmentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void getCapacityCommitment(
        com.google.cloud.bigquery.reservation.v1.GetCapacityCommitmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCapacityCommitmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void deleteCapacityCommitment(
        com.google.cloud.bigquery.reservation.v1.DeleteCapacityCommitmentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteCapacityCommitmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void updateCapacityCommitment(
        com.google.cloud.bigquery.reservation.v1.UpdateCapacityCommitmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateCapacityCommitmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void splitCapacityCommitment(
        com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSplitCapacityCommitmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void mergeCapacityCommitments(
        com.google.cloud.bigquery.reservation.v1.MergeCapacityCommitmentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMergeCapacityCommitmentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void createAssignment(
        com.google.cloud.bigquery.reservation.v1.CreateAssignmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.Assignment>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateAssignmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void listAssignments(
        com.google.cloud.bigquery.reservation.v1.ListAssignmentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.reservation.v1.ListAssignmentsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListAssignmentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void deleteAssignment(
        com.google.cloud.bigquery.reservation.v1.DeleteAssignmentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteAssignmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void searchAssignments(
        com.google.cloud.bigquery.reservation.v1.SearchAssignmentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.reservation.v1.SearchAssignmentsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSearchAssignmentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void moveAssignment(
        com.google.cloud.bigquery.reservation.v1.MoveAssignmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.Assignment>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMoveAssignmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void getBiReservation(
        com.google.cloud.bigquery.reservation.v1.GetBiReservationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.BiReservation>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetBiReservationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void updateBiReservation(
        com.google.cloud.bigquery.reservation.v1.UpdateBiReservationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.reservation.v1.BiReservation>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateBiReservationMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /** */
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

    /** */
    public com.google.cloud.bigquery.reservation.v1.Reservation createReservation(
        com.google.cloud.bigquery.reservation.v1.CreateReservationRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateReservationMethod(), getCallOptions(), request);
    }

    /** */
    public com.google.cloud.bigquery.reservation.v1.ListReservationsResponse listReservations(
        com.google.cloud.bigquery.reservation.v1.ListReservationsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListReservationsMethod(), getCallOptions(), request);
    }

    /** */
    public com.google.cloud.bigquery.reservation.v1.Reservation getReservation(
        com.google.cloud.bigquery.reservation.v1.GetReservationRequest request) {
      return blockingUnaryCall(getChannel(), getGetReservationMethod(), getCallOptions(), request);
    }

    /** */
    public com.google.protobuf.Empty deleteReservation(
        com.google.cloud.bigquery.reservation.v1.DeleteReservationRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteReservationMethod(), getCallOptions(), request);
    }

    /** */
    public com.google.cloud.bigquery.reservation.v1.Reservation updateReservation(
        com.google.cloud.bigquery.reservation.v1.UpdateReservationRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateReservationMethod(), getCallOptions(), request);
    }

    /** */
    public com.google.cloud.bigquery.reservation.v1.CapacityCommitment createCapacityCommitment(
        com.google.cloud.bigquery.reservation.v1.CreateCapacityCommitmentRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateCapacityCommitmentMethod(), getCallOptions(), request);
    }

    /** */
    public com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsResponse
        listCapacityCommitments(
            com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListCapacityCommitmentsMethod(), getCallOptions(), request);
    }

    /** */
    public com.google.cloud.bigquery.reservation.v1.CapacityCommitment getCapacityCommitment(
        com.google.cloud.bigquery.reservation.v1.GetCapacityCommitmentRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetCapacityCommitmentMethod(), getCallOptions(), request);
    }

    /** */
    public com.google.protobuf.Empty deleteCapacityCommitment(
        com.google.cloud.bigquery.reservation.v1.DeleteCapacityCommitmentRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteCapacityCommitmentMethod(), getCallOptions(), request);
    }

    /** */
    public com.google.cloud.bigquery.reservation.v1.CapacityCommitment updateCapacityCommitment(
        com.google.cloud.bigquery.reservation.v1.UpdateCapacityCommitmentRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateCapacityCommitmentMethod(), getCallOptions(), request);
    }

    /** */
    public com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentResponse
        splitCapacityCommitment(
            com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentRequest request) {
      return blockingUnaryCall(
          getChannel(), getSplitCapacityCommitmentMethod(), getCallOptions(), request);
    }

    /** */
    public com.google.cloud.bigquery.reservation.v1.CapacityCommitment mergeCapacityCommitments(
        com.google.cloud.bigquery.reservation.v1.MergeCapacityCommitmentsRequest request) {
      return blockingUnaryCall(
          getChannel(), getMergeCapacityCommitmentsMethod(), getCallOptions(), request);
    }

    /** */
    public com.google.cloud.bigquery.reservation.v1.Assignment createAssignment(
        com.google.cloud.bigquery.reservation.v1.CreateAssignmentRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateAssignmentMethod(), getCallOptions(), request);
    }

    /** */
    public com.google.cloud.bigquery.reservation.v1.ListAssignmentsResponse listAssignments(
        com.google.cloud.bigquery.reservation.v1.ListAssignmentsRequest request) {
      return blockingUnaryCall(getChannel(), getListAssignmentsMethod(), getCallOptions(), request);
    }

    /** */
    public com.google.protobuf.Empty deleteAssignment(
        com.google.cloud.bigquery.reservation.v1.DeleteAssignmentRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteAssignmentMethod(), getCallOptions(), request);
    }

    /** */
    public com.google.cloud.bigquery.reservation.v1.SearchAssignmentsResponse searchAssignments(
        com.google.cloud.bigquery.reservation.v1.SearchAssignmentsRequest request) {
      return blockingUnaryCall(
          getChannel(), getSearchAssignmentsMethod(), getCallOptions(), request);
    }

    /** */
    public com.google.cloud.bigquery.reservation.v1.Assignment moveAssignment(
        com.google.cloud.bigquery.reservation.v1.MoveAssignmentRequest request) {
      return blockingUnaryCall(getChannel(), getMoveAssignmentMethod(), getCallOptions(), request);
    }

    /** */
    public com.google.cloud.bigquery.reservation.v1.BiReservation getBiReservation(
        com.google.cloud.bigquery.reservation.v1.GetBiReservationRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetBiReservationMethod(), getCallOptions(), request);
    }

    /** */
    public com.google.cloud.bigquery.reservation.v1.BiReservation updateBiReservation(
        com.google.cloud.bigquery.reservation.v1.UpdateBiReservationRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateBiReservationMethod(), getCallOptions(), request);
    }
  }

  /** */
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

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.Reservation>
        createReservation(
            com.google.cloud.bigquery.reservation.v1.CreateReservationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateReservationMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.ListReservationsResponse>
        listReservations(com.google.cloud.bigquery.reservation.v1.ListReservationsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListReservationsMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.Reservation>
        getReservation(com.google.cloud.bigquery.reservation.v1.GetReservationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetReservationMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteReservation(
            com.google.cloud.bigquery.reservation.v1.DeleteReservationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteReservationMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.Reservation>
        updateReservation(
            com.google.cloud.bigquery.reservation.v1.UpdateReservationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateReservationMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
        createCapacityCommitment(
            com.google.cloud.bigquery.reservation.v1.CreateCapacityCommitmentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateCapacityCommitmentMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsResponse>
        listCapacityCommitments(
            com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListCapacityCommitmentsMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
        getCapacityCommitment(
            com.google.cloud.bigquery.reservation.v1.GetCapacityCommitmentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCapacityCommitmentMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteCapacityCommitment(
            com.google.cloud.bigquery.reservation.v1.DeleteCapacityCommitmentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteCapacityCommitmentMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
        updateCapacityCommitment(
            com.google.cloud.bigquery.reservation.v1.UpdateCapacityCommitmentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateCapacityCommitmentMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentResponse>
        splitCapacityCommitment(
            com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSplitCapacityCommitmentMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.CapacityCommitment>
        mergeCapacityCommitments(
            com.google.cloud.bigquery.reservation.v1.MergeCapacityCommitmentsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getMergeCapacityCommitmentsMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.Assignment>
        createAssignment(com.google.cloud.bigquery.reservation.v1.CreateAssignmentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateAssignmentMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.ListAssignmentsResponse>
        listAssignments(com.google.cloud.bigquery.reservation.v1.ListAssignmentsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListAssignmentsMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteAssignment(com.google.cloud.bigquery.reservation.v1.DeleteAssignmentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteAssignmentMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.SearchAssignmentsResponse>
        searchAssignments(
            com.google.cloud.bigquery.reservation.v1.SearchAssignmentsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSearchAssignmentsMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.Assignment>
        moveAssignment(com.google.cloud.bigquery.reservation.v1.MoveAssignmentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getMoveAssignmentMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.BiReservation>
        getBiReservation(com.google.cloud.bigquery.reservation.v1.GetBiReservationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetBiReservationMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.reservation.v1.BiReservation>
        updateBiReservation(
            com.google.cloud.bigquery.reservation.v1.UpdateBiReservationRequest request) {
      return futureUnaryCall(
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
  private static final int METHODID_MOVE_ASSIGNMENT = 16;
  private static final int METHODID_GET_BI_RESERVATION = 17;
  private static final int METHODID_UPDATE_BI_RESERVATION = 18;

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
        case METHODID_MOVE_ASSIGNMENT:
          serviceImpl.moveAssignment(
              (com.google.cloud.bigquery.reservation.v1.MoveAssignmentRequest) request,
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
                      .addMethod(getMoveAssignmentMethod())
                      .addMethod(getGetBiReservationMethod())
                      .addMethod(getUpdateBiReservationMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
