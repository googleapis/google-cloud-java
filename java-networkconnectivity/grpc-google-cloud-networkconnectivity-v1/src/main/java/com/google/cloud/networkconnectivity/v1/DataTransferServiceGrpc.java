/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.networkconnectivity.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * DataTransferService is the service for the Data Transfer API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/networkconnectivity/v1/data_transfer.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DataTransferServiceGrpc {

  private DataTransferServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.networkconnectivity.v1.DataTransferService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferConfigsRequest,
          com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferConfigsResponse>
      getListMulticloudDataTransferConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMulticloudDataTransferConfigs",
      requestType =
          com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferConfigsRequest.class,
      responseType =
          com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferConfigsRequest,
          com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferConfigsResponse>
      getListMulticloudDataTransferConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferConfigsRequest,
            com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferConfigsResponse>
        getListMulticloudDataTransferConfigsMethod;
    if ((getListMulticloudDataTransferConfigsMethod =
            DataTransferServiceGrpc.getListMulticloudDataTransferConfigsMethod)
        == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getListMulticloudDataTransferConfigsMethod =
                DataTransferServiceGrpc.getListMulticloudDataTransferConfigsMethod)
            == null) {
          DataTransferServiceGrpc.getListMulticloudDataTransferConfigsMethod =
              getListMulticloudDataTransferConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1
                              .ListMulticloudDataTransferConfigsRequest,
                          com.google.cloud.networkconnectivity.v1
                              .ListMulticloudDataTransferConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListMulticloudDataTransferConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1
                                  .ListMulticloudDataTransferConfigsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1
                                  .ListMulticloudDataTransferConfigsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTransferServiceMethodDescriptorSupplier(
                              "ListMulticloudDataTransferConfigs"))
                      .build();
        }
      }
    }
    return getListMulticloudDataTransferConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.GetMulticloudDataTransferConfigRequest,
          com.google.cloud.networkconnectivity.v1.MulticloudDataTransferConfig>
      getGetMulticloudDataTransferConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMulticloudDataTransferConfig",
      requestType =
          com.google.cloud.networkconnectivity.v1.GetMulticloudDataTransferConfigRequest.class,
      responseType = com.google.cloud.networkconnectivity.v1.MulticloudDataTransferConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.GetMulticloudDataTransferConfigRequest,
          com.google.cloud.networkconnectivity.v1.MulticloudDataTransferConfig>
      getGetMulticloudDataTransferConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.GetMulticloudDataTransferConfigRequest,
            com.google.cloud.networkconnectivity.v1.MulticloudDataTransferConfig>
        getGetMulticloudDataTransferConfigMethod;
    if ((getGetMulticloudDataTransferConfigMethod =
            DataTransferServiceGrpc.getGetMulticloudDataTransferConfigMethod)
        == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getGetMulticloudDataTransferConfigMethod =
                DataTransferServiceGrpc.getGetMulticloudDataTransferConfigMethod)
            == null) {
          DataTransferServiceGrpc.getGetMulticloudDataTransferConfigMethod =
              getGetMulticloudDataTransferConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1
                              .GetMulticloudDataTransferConfigRequest,
                          com.google.cloud.networkconnectivity.v1.MulticloudDataTransferConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetMulticloudDataTransferConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1
                                  .GetMulticloudDataTransferConfigRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1.MulticloudDataTransferConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTransferServiceMethodDescriptorSupplier(
                              "GetMulticloudDataTransferConfig"))
                      .build();
        }
      }
    }
    return getGetMulticloudDataTransferConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.CreateMulticloudDataTransferConfigRequest,
          com.google.longrunning.Operation>
      getCreateMulticloudDataTransferConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMulticloudDataTransferConfig",
      requestType =
          com.google.cloud.networkconnectivity.v1.CreateMulticloudDataTransferConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.CreateMulticloudDataTransferConfigRequest,
          com.google.longrunning.Operation>
      getCreateMulticloudDataTransferConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.CreateMulticloudDataTransferConfigRequest,
            com.google.longrunning.Operation>
        getCreateMulticloudDataTransferConfigMethod;
    if ((getCreateMulticloudDataTransferConfigMethod =
            DataTransferServiceGrpc.getCreateMulticloudDataTransferConfigMethod)
        == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getCreateMulticloudDataTransferConfigMethod =
                DataTransferServiceGrpc.getCreateMulticloudDataTransferConfigMethod)
            == null) {
          DataTransferServiceGrpc.getCreateMulticloudDataTransferConfigMethod =
              getCreateMulticloudDataTransferConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1
                              .CreateMulticloudDataTransferConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "CreateMulticloudDataTransferConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1
                                  .CreateMulticloudDataTransferConfigRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTransferServiceMethodDescriptorSupplier(
                              "CreateMulticloudDataTransferConfig"))
                      .build();
        }
      }
    }
    return getCreateMulticloudDataTransferConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.UpdateMulticloudDataTransferConfigRequest,
          com.google.longrunning.Operation>
      getUpdateMulticloudDataTransferConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateMulticloudDataTransferConfig",
      requestType =
          com.google.cloud.networkconnectivity.v1.UpdateMulticloudDataTransferConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.UpdateMulticloudDataTransferConfigRequest,
          com.google.longrunning.Operation>
      getUpdateMulticloudDataTransferConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.UpdateMulticloudDataTransferConfigRequest,
            com.google.longrunning.Operation>
        getUpdateMulticloudDataTransferConfigMethod;
    if ((getUpdateMulticloudDataTransferConfigMethod =
            DataTransferServiceGrpc.getUpdateMulticloudDataTransferConfigMethod)
        == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getUpdateMulticloudDataTransferConfigMethod =
                DataTransferServiceGrpc.getUpdateMulticloudDataTransferConfigMethod)
            == null) {
          DataTransferServiceGrpc.getUpdateMulticloudDataTransferConfigMethod =
              getUpdateMulticloudDataTransferConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1
                              .UpdateMulticloudDataTransferConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "UpdateMulticloudDataTransferConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1
                                  .UpdateMulticloudDataTransferConfigRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTransferServiceMethodDescriptorSupplier(
                              "UpdateMulticloudDataTransferConfig"))
                      .build();
        }
      }
    }
    return getUpdateMulticloudDataTransferConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.DeleteMulticloudDataTransferConfigRequest,
          com.google.longrunning.Operation>
      getDeleteMulticloudDataTransferConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMulticloudDataTransferConfig",
      requestType =
          com.google.cloud.networkconnectivity.v1.DeleteMulticloudDataTransferConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.DeleteMulticloudDataTransferConfigRequest,
          com.google.longrunning.Operation>
      getDeleteMulticloudDataTransferConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.DeleteMulticloudDataTransferConfigRequest,
            com.google.longrunning.Operation>
        getDeleteMulticloudDataTransferConfigMethod;
    if ((getDeleteMulticloudDataTransferConfigMethod =
            DataTransferServiceGrpc.getDeleteMulticloudDataTransferConfigMethod)
        == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getDeleteMulticloudDataTransferConfigMethod =
                DataTransferServiceGrpc.getDeleteMulticloudDataTransferConfigMethod)
            == null) {
          DataTransferServiceGrpc.getDeleteMulticloudDataTransferConfigMethod =
              getDeleteMulticloudDataTransferConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1
                              .DeleteMulticloudDataTransferConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "DeleteMulticloudDataTransferConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1
                                  .DeleteMulticloudDataTransferConfigRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTransferServiceMethodDescriptorSupplier(
                              "DeleteMulticloudDataTransferConfig"))
                      .build();
        }
      }
    }
    return getDeleteMulticloudDataTransferConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.ListDestinationsRequest,
          com.google.cloud.networkconnectivity.v1.ListDestinationsResponse>
      getListDestinationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDestinations",
      requestType = com.google.cloud.networkconnectivity.v1.ListDestinationsRequest.class,
      responseType = com.google.cloud.networkconnectivity.v1.ListDestinationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.ListDestinationsRequest,
          com.google.cloud.networkconnectivity.v1.ListDestinationsResponse>
      getListDestinationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.ListDestinationsRequest,
            com.google.cloud.networkconnectivity.v1.ListDestinationsResponse>
        getListDestinationsMethod;
    if ((getListDestinationsMethod = DataTransferServiceGrpc.getListDestinationsMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getListDestinationsMethod = DataTransferServiceGrpc.getListDestinationsMethod)
            == null) {
          DataTransferServiceGrpc.getListDestinationsMethod =
              getListDestinationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1.ListDestinationsRequest,
                          com.google.cloud.networkconnectivity.v1.ListDestinationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDestinations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1.ListDestinationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1.ListDestinationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTransferServiceMethodDescriptorSupplier("ListDestinations"))
                      .build();
        }
      }
    }
    return getListDestinationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.GetDestinationRequest,
          com.google.cloud.networkconnectivity.v1.Destination>
      getGetDestinationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDestination",
      requestType = com.google.cloud.networkconnectivity.v1.GetDestinationRequest.class,
      responseType = com.google.cloud.networkconnectivity.v1.Destination.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.GetDestinationRequest,
          com.google.cloud.networkconnectivity.v1.Destination>
      getGetDestinationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.GetDestinationRequest,
            com.google.cloud.networkconnectivity.v1.Destination>
        getGetDestinationMethod;
    if ((getGetDestinationMethod = DataTransferServiceGrpc.getGetDestinationMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getGetDestinationMethod = DataTransferServiceGrpc.getGetDestinationMethod) == null) {
          DataTransferServiceGrpc.getGetDestinationMethod =
              getGetDestinationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1.GetDestinationRequest,
                          com.google.cloud.networkconnectivity.v1.Destination>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDestination"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1.GetDestinationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1.Destination
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTransferServiceMethodDescriptorSupplier("GetDestination"))
                      .build();
        }
      }
    }
    return getGetDestinationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.CreateDestinationRequest,
          com.google.longrunning.Operation>
      getCreateDestinationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDestination",
      requestType = com.google.cloud.networkconnectivity.v1.CreateDestinationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.CreateDestinationRequest,
          com.google.longrunning.Operation>
      getCreateDestinationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.CreateDestinationRequest,
            com.google.longrunning.Operation>
        getCreateDestinationMethod;
    if ((getCreateDestinationMethod = DataTransferServiceGrpc.getCreateDestinationMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getCreateDestinationMethod = DataTransferServiceGrpc.getCreateDestinationMethod)
            == null) {
          DataTransferServiceGrpc.getCreateDestinationMethod =
              getCreateDestinationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1.CreateDestinationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDestination"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1.CreateDestinationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTransferServiceMethodDescriptorSupplier("CreateDestination"))
                      .build();
        }
      }
    }
    return getCreateDestinationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.UpdateDestinationRequest,
          com.google.longrunning.Operation>
      getUpdateDestinationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDestination",
      requestType = com.google.cloud.networkconnectivity.v1.UpdateDestinationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.UpdateDestinationRequest,
          com.google.longrunning.Operation>
      getUpdateDestinationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.UpdateDestinationRequest,
            com.google.longrunning.Operation>
        getUpdateDestinationMethod;
    if ((getUpdateDestinationMethod = DataTransferServiceGrpc.getUpdateDestinationMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getUpdateDestinationMethod = DataTransferServiceGrpc.getUpdateDestinationMethod)
            == null) {
          DataTransferServiceGrpc.getUpdateDestinationMethod =
              getUpdateDestinationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1.UpdateDestinationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDestination"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1.UpdateDestinationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTransferServiceMethodDescriptorSupplier("UpdateDestination"))
                      .build();
        }
      }
    }
    return getUpdateDestinationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.DeleteDestinationRequest,
          com.google.longrunning.Operation>
      getDeleteDestinationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDestination",
      requestType = com.google.cloud.networkconnectivity.v1.DeleteDestinationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.DeleteDestinationRequest,
          com.google.longrunning.Operation>
      getDeleteDestinationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.DeleteDestinationRequest,
            com.google.longrunning.Operation>
        getDeleteDestinationMethod;
    if ((getDeleteDestinationMethod = DataTransferServiceGrpc.getDeleteDestinationMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getDeleteDestinationMethod = DataTransferServiceGrpc.getDeleteDestinationMethod)
            == null) {
          DataTransferServiceGrpc.getDeleteDestinationMethod =
              getDeleteDestinationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1.DeleteDestinationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDestination"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1.DeleteDestinationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTransferServiceMethodDescriptorSupplier("DeleteDestination"))
                      .build();
        }
      }
    }
    return getDeleteDestinationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.GetMulticloudDataTransferSupportedServiceRequest,
          com.google.cloud.networkconnectivity.v1.MulticloudDataTransferSupportedService>
      getGetMulticloudDataTransferSupportedServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMulticloudDataTransferSupportedService",
      requestType =
          com.google.cloud.networkconnectivity.v1.GetMulticloudDataTransferSupportedServiceRequest
              .class,
      responseType =
          com.google.cloud.networkconnectivity.v1.MulticloudDataTransferSupportedService.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.GetMulticloudDataTransferSupportedServiceRequest,
          com.google.cloud.networkconnectivity.v1.MulticloudDataTransferSupportedService>
      getGetMulticloudDataTransferSupportedServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1
                .GetMulticloudDataTransferSupportedServiceRequest,
            com.google.cloud.networkconnectivity.v1.MulticloudDataTransferSupportedService>
        getGetMulticloudDataTransferSupportedServiceMethod;
    if ((getGetMulticloudDataTransferSupportedServiceMethod =
            DataTransferServiceGrpc.getGetMulticloudDataTransferSupportedServiceMethod)
        == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getGetMulticloudDataTransferSupportedServiceMethod =
                DataTransferServiceGrpc.getGetMulticloudDataTransferSupportedServiceMethod)
            == null) {
          DataTransferServiceGrpc.getGetMulticloudDataTransferSupportedServiceMethod =
              getGetMulticloudDataTransferSupportedServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1
                              .GetMulticloudDataTransferSupportedServiceRequest,
                          com.google.cloud.networkconnectivity.v1
                              .MulticloudDataTransferSupportedService>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "GetMulticloudDataTransferSupportedService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1
                                  .GetMulticloudDataTransferSupportedServiceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1
                                  .MulticloudDataTransferSupportedService.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTransferServiceMethodDescriptorSupplier(
                              "GetMulticloudDataTransferSupportedService"))
                      .build();
        }
      }
    }
    return getGetMulticloudDataTransferSupportedServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1
              .ListMulticloudDataTransferSupportedServicesRequest,
          com.google.cloud.networkconnectivity.v1
              .ListMulticloudDataTransferSupportedServicesResponse>
      getListMulticloudDataTransferSupportedServicesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMulticloudDataTransferSupportedServices",
      requestType =
          com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferSupportedServicesRequest
              .class,
      responseType =
          com.google.cloud.networkconnectivity.v1
              .ListMulticloudDataTransferSupportedServicesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1
              .ListMulticloudDataTransferSupportedServicesRequest,
          com.google.cloud.networkconnectivity.v1
              .ListMulticloudDataTransferSupportedServicesResponse>
      getListMulticloudDataTransferSupportedServicesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1
                .ListMulticloudDataTransferSupportedServicesRequest,
            com.google.cloud.networkconnectivity.v1
                .ListMulticloudDataTransferSupportedServicesResponse>
        getListMulticloudDataTransferSupportedServicesMethod;
    if ((getListMulticloudDataTransferSupportedServicesMethod =
            DataTransferServiceGrpc.getListMulticloudDataTransferSupportedServicesMethod)
        == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getListMulticloudDataTransferSupportedServicesMethod =
                DataTransferServiceGrpc.getListMulticloudDataTransferSupportedServicesMethod)
            == null) {
          DataTransferServiceGrpc.getListMulticloudDataTransferSupportedServicesMethod =
              getListMulticloudDataTransferSupportedServicesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1
                              .ListMulticloudDataTransferSupportedServicesRequest,
                          com.google.cloud.networkconnectivity.v1
                              .ListMulticloudDataTransferSupportedServicesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "ListMulticloudDataTransferSupportedServices"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1
                                  .ListMulticloudDataTransferSupportedServicesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1
                                  .ListMulticloudDataTransferSupportedServicesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTransferServiceMethodDescriptorSupplier(
                              "ListMulticloudDataTransferSupportedServices"))
                      .build();
        }
      }
    }
    return getListMulticloudDataTransferSupportedServicesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DataTransferServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataTransferServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataTransferServiceStub>() {
          @java.lang.Override
          public DataTransferServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataTransferServiceStub(channel, callOptions);
          }
        };
    return DataTransferServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static DataTransferServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataTransferServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataTransferServiceBlockingV2Stub>() {
          @java.lang.Override
          public DataTransferServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataTransferServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return DataTransferServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataTransferServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataTransferServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataTransferServiceBlockingStub>() {
          @java.lang.Override
          public DataTransferServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataTransferServiceBlockingStub(channel, callOptions);
          }
        };
    return DataTransferServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DataTransferServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataTransferServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataTransferServiceFutureStub>() {
          @java.lang.Override
          public DataTransferServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataTransferServiceFutureStub(channel, callOptions);
          }
        };
    return DataTransferServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * DataTransferService is the service for the Data Transfer API.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists the `MulticloudDataTransferConfig` resources in a specified project
     * and location.
     * </pre>
     */
    default void listMulticloudDataTransferConfigs(
        com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMulticloudDataTransferConfigsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a `MulticloudDataTransferConfig` resource.
     * </pre>
     */
    default void getMulticloudDataTransferConfig(
        com.google.cloud.networkconnectivity.v1.GetMulticloudDataTransferConfigRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1.MulticloudDataTransferConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetMulticloudDataTransferConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a `MulticloudDataTransferConfig` resource in a specified project
     * and location.
     * </pre>
     */
    default void createMulticloudDataTransferConfig(
        com.google.cloud.networkconnectivity.v1.CreateMulticloudDataTransferConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateMulticloudDataTransferConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a `MulticloudDataTransferConfig` resource in a specified project
     * and location.
     * </pre>
     */
    default void updateMulticloudDataTransferConfig(
        com.google.cloud.networkconnectivity.v1.UpdateMulticloudDataTransferConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateMulticloudDataTransferConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `MulticloudDataTransferConfig` resource.
     * </pre>
     */
    default void deleteMulticloudDataTransferConfig(
        com.google.cloud.networkconnectivity.v1.DeleteMulticloudDataTransferConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteMulticloudDataTransferConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the `Destination` resources in a specified project and location.
     * </pre>
     */
    default void listDestinations(
        com.google.cloud.networkconnectivity.v1.ListDestinationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1.ListDestinationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDestinationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a `Destination` resource.
     * </pre>
     */
    default void getDestination(
        com.google.cloud.networkconnectivity.v1.GetDestinationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1.Destination>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDestinationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a `Destination` resource in a specified project and location.
     * </pre>
     */
    default void createDestination(
        com.google.cloud.networkconnectivity.v1.CreateDestinationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDestinationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a `Destination` resource in a specified project and location.
     * </pre>
     */
    default void updateDestination(
        com.google.cloud.networkconnectivity.v1.UpdateDestinationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDestinationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `Destination` resource.
     * </pre>
     */
    default void deleteDestination(
        com.google.cloud.networkconnectivity.v1.DeleteDestinationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDestinationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a service that is supported for Data Transfer
     * Essentials.
     * </pre>
     */
    default void getMulticloudDataTransferSupportedService(
        com.google.cloud.networkconnectivity.v1.GetMulticloudDataTransferSupportedServiceRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1.MulticloudDataTransferSupportedService>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetMulticloudDataTransferSupportedServiceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the services in the project for a region that are supported for
     * Data Transfer Essentials.
     * </pre>
     */
    default void listMulticloudDataTransferSupportedServices(
        com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferSupportedServicesRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1
                    .ListMulticloudDataTransferSupportedServicesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMulticloudDataTransferSupportedServicesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DataTransferService.
   *
   * <pre>
   * DataTransferService is the service for the Data Transfer API.
   * </pre>
   */
  public abstract static class DataTransferServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DataTransferServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DataTransferService.
   *
   * <pre>
   * DataTransferService is the service for the Data Transfer API.
   * </pre>
   */
  public static final class DataTransferServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DataTransferServiceStub> {
    private DataTransferServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataTransferServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataTransferServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the `MulticloudDataTransferConfig` resources in a specified project
     * and location.
     * </pre>
     */
    public void listMulticloudDataTransferConfigs(
        com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMulticloudDataTransferConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a `MulticloudDataTransferConfig` resource.
     * </pre>
     */
    public void getMulticloudDataTransferConfig(
        com.google.cloud.networkconnectivity.v1.GetMulticloudDataTransferConfigRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1.MulticloudDataTransferConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMulticloudDataTransferConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a `MulticloudDataTransferConfig` resource in a specified project
     * and location.
     * </pre>
     */
    public void createMulticloudDataTransferConfig(
        com.google.cloud.networkconnectivity.v1.CreateMulticloudDataTransferConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMulticloudDataTransferConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a `MulticloudDataTransferConfig` resource in a specified project
     * and location.
     * </pre>
     */
    public void updateMulticloudDataTransferConfig(
        com.google.cloud.networkconnectivity.v1.UpdateMulticloudDataTransferConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMulticloudDataTransferConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `MulticloudDataTransferConfig` resource.
     * </pre>
     */
    public void deleteMulticloudDataTransferConfig(
        com.google.cloud.networkconnectivity.v1.DeleteMulticloudDataTransferConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMulticloudDataTransferConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the `Destination` resources in a specified project and location.
     * </pre>
     */
    public void listDestinations(
        com.google.cloud.networkconnectivity.v1.ListDestinationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1.ListDestinationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDestinationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a `Destination` resource.
     * </pre>
     */
    public void getDestination(
        com.google.cloud.networkconnectivity.v1.GetDestinationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1.Destination>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDestinationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a `Destination` resource in a specified project and location.
     * </pre>
     */
    public void createDestination(
        com.google.cloud.networkconnectivity.v1.CreateDestinationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDestinationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a `Destination` resource in a specified project and location.
     * </pre>
     */
    public void updateDestination(
        com.google.cloud.networkconnectivity.v1.UpdateDestinationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDestinationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `Destination` resource.
     * </pre>
     */
    public void deleteDestination(
        com.google.cloud.networkconnectivity.v1.DeleteDestinationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDestinationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a service that is supported for Data Transfer
     * Essentials.
     * </pre>
     */
    public void getMulticloudDataTransferSupportedService(
        com.google.cloud.networkconnectivity.v1.GetMulticloudDataTransferSupportedServiceRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1.MulticloudDataTransferSupportedService>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(getGetMulticloudDataTransferSupportedServiceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the services in the project for a region that are supported for
     * Data Transfer Essentials.
     * </pre>
     */
    public void listMulticloudDataTransferSupportedServices(
        com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferSupportedServicesRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1
                    .ListMulticloudDataTransferSupportedServicesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(getListMulticloudDataTransferSupportedServicesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DataTransferService.
   *
   * <pre>
   * DataTransferService is the service for the Data Transfer API.
   * </pre>
   */
  public static final class DataTransferServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<DataTransferServiceBlockingV2Stub> {
    private DataTransferServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataTransferServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataTransferServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the `MulticloudDataTransferConfig` resources in a specified project
     * and location.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferConfigsResponse
        listMulticloudDataTransferConfigs(
            com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferConfigsRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMulticloudDataTransferConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a `MulticloudDataTransferConfig` resource.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1.MulticloudDataTransferConfig
        getMulticloudDataTransferConfig(
            com.google.cloud.networkconnectivity.v1.GetMulticloudDataTransferConfigRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMulticloudDataTransferConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a `MulticloudDataTransferConfig` resource in a specified project
     * and location.
     * </pre>
     */
    public com.google.longrunning.Operation createMulticloudDataTransferConfig(
        com.google.cloud.networkconnectivity.v1.CreateMulticloudDataTransferConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMulticloudDataTransferConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a `MulticloudDataTransferConfig` resource in a specified project
     * and location.
     * </pre>
     */
    public com.google.longrunning.Operation updateMulticloudDataTransferConfig(
        com.google.cloud.networkconnectivity.v1.UpdateMulticloudDataTransferConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMulticloudDataTransferConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `MulticloudDataTransferConfig` resource.
     * </pre>
     */
    public com.google.longrunning.Operation deleteMulticloudDataTransferConfig(
        com.google.cloud.networkconnectivity.v1.DeleteMulticloudDataTransferConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMulticloudDataTransferConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the `Destination` resources in a specified project and location.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1.ListDestinationsResponse listDestinations(
        com.google.cloud.networkconnectivity.v1.ListDestinationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDestinationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a `Destination` resource.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1.Destination getDestination(
        com.google.cloud.networkconnectivity.v1.GetDestinationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDestinationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a `Destination` resource in a specified project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createDestination(
        com.google.cloud.networkconnectivity.v1.CreateDestinationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDestinationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a `Destination` resource in a specified project and location.
     * </pre>
     */
    public com.google.longrunning.Operation updateDestination(
        com.google.cloud.networkconnectivity.v1.UpdateDestinationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDestinationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `Destination` resource.
     * </pre>
     */
    public com.google.longrunning.Operation deleteDestination(
        com.google.cloud.networkconnectivity.v1.DeleteDestinationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDestinationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a service that is supported for Data Transfer
     * Essentials.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1.MulticloudDataTransferSupportedService
        getMulticloudDataTransferSupportedService(
            com.google.cloud.networkconnectivity.v1.GetMulticloudDataTransferSupportedServiceRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getGetMulticloudDataTransferSupportedServiceMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists the services in the project for a region that are supported for
     * Data Transfer Essentials.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1
            .ListMulticloudDataTransferSupportedServicesResponse
        listMulticloudDataTransferSupportedServices(
            com.google.cloud.networkconnectivity.v1
                    .ListMulticloudDataTransferSupportedServicesRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getListMulticloudDataTransferSupportedServicesMethod(),
          getCallOptions(),
          request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service DataTransferService.
   *
   * <pre>
   * DataTransferService is the service for the Data Transfer API.
   * </pre>
   */
  public static final class DataTransferServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DataTransferServiceBlockingStub> {
    private DataTransferServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataTransferServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataTransferServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the `MulticloudDataTransferConfig` resources in a specified project
     * and location.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferConfigsResponse
        listMulticloudDataTransferConfigs(
            com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferConfigsRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMulticloudDataTransferConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a `MulticloudDataTransferConfig` resource.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1.MulticloudDataTransferConfig
        getMulticloudDataTransferConfig(
            com.google.cloud.networkconnectivity.v1.GetMulticloudDataTransferConfigRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMulticloudDataTransferConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a `MulticloudDataTransferConfig` resource in a specified project
     * and location.
     * </pre>
     */
    public com.google.longrunning.Operation createMulticloudDataTransferConfig(
        com.google.cloud.networkconnectivity.v1.CreateMulticloudDataTransferConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMulticloudDataTransferConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a `MulticloudDataTransferConfig` resource in a specified project
     * and location.
     * </pre>
     */
    public com.google.longrunning.Operation updateMulticloudDataTransferConfig(
        com.google.cloud.networkconnectivity.v1.UpdateMulticloudDataTransferConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMulticloudDataTransferConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `MulticloudDataTransferConfig` resource.
     * </pre>
     */
    public com.google.longrunning.Operation deleteMulticloudDataTransferConfig(
        com.google.cloud.networkconnectivity.v1.DeleteMulticloudDataTransferConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMulticloudDataTransferConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the `Destination` resources in a specified project and location.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1.ListDestinationsResponse listDestinations(
        com.google.cloud.networkconnectivity.v1.ListDestinationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDestinationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a `Destination` resource.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1.Destination getDestination(
        com.google.cloud.networkconnectivity.v1.GetDestinationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDestinationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a `Destination` resource in a specified project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createDestination(
        com.google.cloud.networkconnectivity.v1.CreateDestinationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDestinationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a `Destination` resource in a specified project and location.
     * </pre>
     */
    public com.google.longrunning.Operation updateDestination(
        com.google.cloud.networkconnectivity.v1.UpdateDestinationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDestinationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `Destination` resource.
     * </pre>
     */
    public com.google.longrunning.Operation deleteDestination(
        com.google.cloud.networkconnectivity.v1.DeleteDestinationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDestinationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a service that is supported for Data Transfer
     * Essentials.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1.MulticloudDataTransferSupportedService
        getMulticloudDataTransferSupportedService(
            com.google.cloud.networkconnectivity.v1.GetMulticloudDataTransferSupportedServiceRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getGetMulticloudDataTransferSupportedServiceMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists the services in the project for a region that are supported for
     * Data Transfer Essentials.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1
            .ListMulticloudDataTransferSupportedServicesResponse
        listMulticloudDataTransferSupportedServices(
            com.google.cloud.networkconnectivity.v1
                    .ListMulticloudDataTransferSupportedServicesRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getListMulticloudDataTransferSupportedServicesMethod(),
          getCallOptions(),
          request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DataTransferService.
   *
   * <pre>
   * DataTransferService is the service for the Data Transfer API.
   * </pre>
   */
  public static final class DataTransferServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DataTransferServiceFutureStub> {
    private DataTransferServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataTransferServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataTransferServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the `MulticloudDataTransferConfig` resources in a specified project
     * and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferConfigsResponse>
        listMulticloudDataTransferConfigs(
            com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferConfigsRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMulticloudDataTransferConfigsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a `MulticloudDataTransferConfig` resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1.MulticloudDataTransferConfig>
        getMulticloudDataTransferConfig(
            com.google.cloud.networkconnectivity.v1.GetMulticloudDataTransferConfigRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMulticloudDataTransferConfigMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Creates a `MulticloudDataTransferConfig` resource in a specified project
     * and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createMulticloudDataTransferConfig(
            com.google.cloud.networkconnectivity.v1.CreateMulticloudDataTransferConfigRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMulticloudDataTransferConfigMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Updates a `MulticloudDataTransferConfig` resource in a specified project
     * and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateMulticloudDataTransferConfig(
            com.google.cloud.networkconnectivity.v1.UpdateMulticloudDataTransferConfigRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMulticloudDataTransferConfigMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `MulticloudDataTransferConfig` resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteMulticloudDataTransferConfig(
            com.google.cloud.networkconnectivity.v1.DeleteMulticloudDataTransferConfigRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMulticloudDataTransferConfigMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists the `Destination` resources in a specified project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1.ListDestinationsResponse>
        listDestinations(com.google.cloud.networkconnectivity.v1.ListDestinationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDestinationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a `Destination` resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1.Destination>
        getDestination(com.google.cloud.networkconnectivity.v1.GetDestinationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDestinationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a `Destination` resource in a specified project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createDestination(
            com.google.cloud.networkconnectivity.v1.CreateDestinationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDestinationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a `Destination` resource in a specified project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateDestination(
            com.google.cloud.networkconnectivity.v1.UpdateDestinationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDestinationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `Destination` resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteDestination(
            com.google.cloud.networkconnectivity.v1.DeleteDestinationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDestinationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a service that is supported for Data Transfer
     * Essentials.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1.MulticloudDataTransferSupportedService>
        getMulticloudDataTransferSupportedService(
            com.google.cloud.networkconnectivity.v1.GetMulticloudDataTransferSupportedServiceRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getGetMulticloudDataTransferSupportedServiceMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists the services in the project for a region that are supported for
     * Data Transfer Essentials.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1
                .ListMulticloudDataTransferSupportedServicesResponse>
        listMulticloudDataTransferSupportedServices(
            com.google.cloud.networkconnectivity.v1
                    .ListMulticloudDataTransferSupportedServicesRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getListMulticloudDataTransferSupportedServicesMethod(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_LIST_MULTICLOUD_DATA_TRANSFER_CONFIGS = 0;
  private static final int METHODID_GET_MULTICLOUD_DATA_TRANSFER_CONFIG = 1;
  private static final int METHODID_CREATE_MULTICLOUD_DATA_TRANSFER_CONFIG = 2;
  private static final int METHODID_UPDATE_MULTICLOUD_DATA_TRANSFER_CONFIG = 3;
  private static final int METHODID_DELETE_MULTICLOUD_DATA_TRANSFER_CONFIG = 4;
  private static final int METHODID_LIST_DESTINATIONS = 5;
  private static final int METHODID_GET_DESTINATION = 6;
  private static final int METHODID_CREATE_DESTINATION = 7;
  private static final int METHODID_UPDATE_DESTINATION = 8;
  private static final int METHODID_DELETE_DESTINATION = 9;
  private static final int METHODID_GET_MULTICLOUD_DATA_TRANSFER_SUPPORTED_SERVICE = 10;
  private static final int METHODID_LIST_MULTICLOUD_DATA_TRANSFER_SUPPORTED_SERVICES = 11;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_MULTICLOUD_DATA_TRANSFER_CONFIGS:
          serviceImpl.listMulticloudDataTransferConfigs(
              (com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferConfigsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkconnectivity.v1
                          .ListMulticloudDataTransferConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_MULTICLOUD_DATA_TRANSFER_CONFIG:
          serviceImpl.getMulticloudDataTransferConfig(
              (com.google.cloud.networkconnectivity.v1.GetMulticloudDataTransferConfigRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkconnectivity.v1.MulticloudDataTransferConfig>)
                  responseObserver);
          break;
        case METHODID_CREATE_MULTICLOUD_DATA_TRANSFER_CONFIG:
          serviceImpl.createMulticloudDataTransferConfig(
              (com.google.cloud.networkconnectivity.v1.CreateMulticloudDataTransferConfigRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_MULTICLOUD_DATA_TRANSFER_CONFIG:
          serviceImpl.updateMulticloudDataTransferConfig(
              (com.google.cloud.networkconnectivity.v1.UpdateMulticloudDataTransferConfigRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_MULTICLOUD_DATA_TRANSFER_CONFIG:
          serviceImpl.deleteMulticloudDataTransferConfig(
              (com.google.cloud.networkconnectivity.v1.DeleteMulticloudDataTransferConfigRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_DESTINATIONS:
          serviceImpl.listDestinations(
              (com.google.cloud.networkconnectivity.v1.ListDestinationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkconnectivity.v1.ListDestinationsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DESTINATION:
          serviceImpl.getDestination(
              (com.google.cloud.networkconnectivity.v1.GetDestinationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1.Destination>)
                  responseObserver);
          break;
        case METHODID_CREATE_DESTINATION:
          serviceImpl.createDestination(
              (com.google.cloud.networkconnectivity.v1.CreateDestinationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_DESTINATION:
          serviceImpl.updateDestination(
              (com.google.cloud.networkconnectivity.v1.UpdateDestinationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_DESTINATION:
          serviceImpl.deleteDestination(
              (com.google.cloud.networkconnectivity.v1.DeleteDestinationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_MULTICLOUD_DATA_TRANSFER_SUPPORTED_SERVICE:
          serviceImpl.getMulticloudDataTransferSupportedService(
              (com.google.cloud.networkconnectivity.v1
                      .GetMulticloudDataTransferSupportedServiceRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkconnectivity.v1
                          .MulticloudDataTransferSupportedService>)
                  responseObserver);
          break;
        case METHODID_LIST_MULTICLOUD_DATA_TRANSFER_SUPPORTED_SERVICES:
          serviceImpl.listMulticloudDataTransferSupportedServices(
              (com.google.cloud.networkconnectivity.v1
                      .ListMulticloudDataTransferSupportedServicesRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkconnectivity.v1
                          .ListMulticloudDataTransferSupportedServicesResponse>)
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getListMulticloudDataTransferConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1
                        .ListMulticloudDataTransferConfigsRequest,
                    com.google.cloud.networkconnectivity.v1
                        .ListMulticloudDataTransferConfigsResponse>(
                    service, METHODID_LIST_MULTICLOUD_DATA_TRANSFER_CONFIGS)))
        .addMethod(
            getGetMulticloudDataTransferConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1.GetMulticloudDataTransferConfigRequest,
                    com.google.cloud.networkconnectivity.v1.MulticloudDataTransferConfig>(
                    service, METHODID_GET_MULTICLOUD_DATA_TRANSFER_CONFIG)))
        .addMethod(
            getCreateMulticloudDataTransferConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1
                        .CreateMulticloudDataTransferConfigRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_MULTICLOUD_DATA_TRANSFER_CONFIG)))
        .addMethod(
            getUpdateMulticloudDataTransferConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1
                        .UpdateMulticloudDataTransferConfigRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_MULTICLOUD_DATA_TRANSFER_CONFIG)))
        .addMethod(
            getDeleteMulticloudDataTransferConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1
                        .DeleteMulticloudDataTransferConfigRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_MULTICLOUD_DATA_TRANSFER_CONFIG)))
        .addMethod(
            getListDestinationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1.ListDestinationsRequest,
                    com.google.cloud.networkconnectivity.v1.ListDestinationsResponse>(
                    service, METHODID_LIST_DESTINATIONS)))
        .addMethod(
            getGetDestinationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1.GetDestinationRequest,
                    com.google.cloud.networkconnectivity.v1.Destination>(
                    service, METHODID_GET_DESTINATION)))
        .addMethod(
            getCreateDestinationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1.CreateDestinationRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_DESTINATION)))
        .addMethod(
            getUpdateDestinationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1.UpdateDestinationRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_DESTINATION)))
        .addMethod(
            getDeleteDestinationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1.DeleteDestinationRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_DESTINATION)))
        .addMethod(
            getGetMulticloudDataTransferSupportedServiceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1
                        .GetMulticloudDataTransferSupportedServiceRequest,
                    com.google.cloud.networkconnectivity.v1.MulticloudDataTransferSupportedService>(
                    service, METHODID_GET_MULTICLOUD_DATA_TRANSFER_SUPPORTED_SERVICE)))
        .addMethod(
            getListMulticloudDataTransferSupportedServicesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1
                        .ListMulticloudDataTransferSupportedServicesRequest,
                    com.google.cloud.networkconnectivity.v1
                        .ListMulticloudDataTransferSupportedServicesResponse>(
                    service, METHODID_LIST_MULTICLOUD_DATA_TRANSFER_SUPPORTED_SERVICES)))
        .build();
  }

  private abstract static class DataTransferServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataTransferServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.networkconnectivity.v1.DataTransferProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataTransferService");
    }
  }

  private static final class DataTransferServiceFileDescriptorSupplier
      extends DataTransferServiceBaseDescriptorSupplier {
    DataTransferServiceFileDescriptorSupplier() {}
  }

  private static final class DataTransferServiceMethodDescriptorSupplier
      extends DataTransferServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DataTransferServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DataTransferServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DataTransferServiceFileDescriptorSupplier())
                      .addMethod(getListMulticloudDataTransferConfigsMethod())
                      .addMethod(getGetMulticloudDataTransferConfigMethod())
                      .addMethod(getCreateMulticloudDataTransferConfigMethod())
                      .addMethod(getUpdateMulticloudDataTransferConfigMethod())
                      .addMethod(getDeleteMulticloudDataTransferConfigMethod())
                      .addMethod(getListDestinationsMethod())
                      .addMethod(getGetDestinationMethod())
                      .addMethod(getCreateDestinationMethod())
                      .addMethod(getUpdateDestinationMethod())
                      .addMethod(getDeleteDestinationMethod())
                      .addMethod(getGetMulticloudDataTransferSupportedServiceMethod())
                      .addMethod(getListMulticloudDataTransferSupportedServicesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
