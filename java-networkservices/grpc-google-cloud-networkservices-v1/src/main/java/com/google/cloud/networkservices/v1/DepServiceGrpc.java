/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.networkservices.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service describing handlers for resources.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/networkservices/v1/dep.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DepServiceGrpc {

  private DepServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.networkservices.v1.DepService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.ListLbTrafficExtensionsRequest,
          com.google.cloud.networkservices.v1.ListLbTrafficExtensionsResponse>
      getListLbTrafficExtensionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListLbTrafficExtensions",
      requestType = com.google.cloud.networkservices.v1.ListLbTrafficExtensionsRequest.class,
      responseType = com.google.cloud.networkservices.v1.ListLbTrafficExtensionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.ListLbTrafficExtensionsRequest,
          com.google.cloud.networkservices.v1.ListLbTrafficExtensionsResponse>
      getListLbTrafficExtensionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.ListLbTrafficExtensionsRequest,
            com.google.cloud.networkservices.v1.ListLbTrafficExtensionsResponse>
        getListLbTrafficExtensionsMethod;
    if ((getListLbTrafficExtensionsMethod = DepServiceGrpc.getListLbTrafficExtensionsMethod)
        == null) {
      synchronized (DepServiceGrpc.class) {
        if ((getListLbTrafficExtensionsMethod = DepServiceGrpc.getListLbTrafficExtensionsMethod)
            == null) {
          DepServiceGrpc.getListLbTrafficExtensionsMethod =
              getListLbTrafficExtensionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.ListLbTrafficExtensionsRequest,
                          com.google.cloud.networkservices.v1.ListLbTrafficExtensionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListLbTrafficExtensions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.ListLbTrafficExtensionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.ListLbTrafficExtensionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DepServiceMethodDescriptorSupplier("ListLbTrafficExtensions"))
                      .build();
        }
      }
    }
    return getListLbTrafficExtensionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.GetLbTrafficExtensionRequest,
          com.google.cloud.networkservices.v1.LbTrafficExtension>
      getGetLbTrafficExtensionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLbTrafficExtension",
      requestType = com.google.cloud.networkservices.v1.GetLbTrafficExtensionRequest.class,
      responseType = com.google.cloud.networkservices.v1.LbTrafficExtension.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.GetLbTrafficExtensionRequest,
          com.google.cloud.networkservices.v1.LbTrafficExtension>
      getGetLbTrafficExtensionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.GetLbTrafficExtensionRequest,
            com.google.cloud.networkservices.v1.LbTrafficExtension>
        getGetLbTrafficExtensionMethod;
    if ((getGetLbTrafficExtensionMethod = DepServiceGrpc.getGetLbTrafficExtensionMethod) == null) {
      synchronized (DepServiceGrpc.class) {
        if ((getGetLbTrafficExtensionMethod = DepServiceGrpc.getGetLbTrafficExtensionMethod)
            == null) {
          DepServiceGrpc.getGetLbTrafficExtensionMethod =
              getGetLbTrafficExtensionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.GetLbTrafficExtensionRequest,
                          com.google.cloud.networkservices.v1.LbTrafficExtension>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetLbTrafficExtension"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.GetLbTrafficExtensionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.LbTrafficExtension
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DepServiceMethodDescriptorSupplier("GetLbTrafficExtension"))
                      .build();
        }
      }
    }
    return getGetLbTrafficExtensionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.CreateLbTrafficExtensionRequest,
          com.google.longrunning.Operation>
      getCreateLbTrafficExtensionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateLbTrafficExtension",
      requestType = com.google.cloud.networkservices.v1.CreateLbTrafficExtensionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.CreateLbTrafficExtensionRequest,
          com.google.longrunning.Operation>
      getCreateLbTrafficExtensionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.CreateLbTrafficExtensionRequest,
            com.google.longrunning.Operation>
        getCreateLbTrafficExtensionMethod;
    if ((getCreateLbTrafficExtensionMethod = DepServiceGrpc.getCreateLbTrafficExtensionMethod)
        == null) {
      synchronized (DepServiceGrpc.class) {
        if ((getCreateLbTrafficExtensionMethod = DepServiceGrpc.getCreateLbTrafficExtensionMethod)
            == null) {
          DepServiceGrpc.getCreateLbTrafficExtensionMethod =
              getCreateLbTrafficExtensionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.CreateLbTrafficExtensionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateLbTrafficExtension"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.CreateLbTrafficExtensionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DepServiceMethodDescriptorSupplier("CreateLbTrafficExtension"))
                      .build();
        }
      }
    }
    return getCreateLbTrafficExtensionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.UpdateLbTrafficExtensionRequest,
          com.google.longrunning.Operation>
      getUpdateLbTrafficExtensionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateLbTrafficExtension",
      requestType = com.google.cloud.networkservices.v1.UpdateLbTrafficExtensionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.UpdateLbTrafficExtensionRequest,
          com.google.longrunning.Operation>
      getUpdateLbTrafficExtensionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.UpdateLbTrafficExtensionRequest,
            com.google.longrunning.Operation>
        getUpdateLbTrafficExtensionMethod;
    if ((getUpdateLbTrafficExtensionMethod = DepServiceGrpc.getUpdateLbTrafficExtensionMethod)
        == null) {
      synchronized (DepServiceGrpc.class) {
        if ((getUpdateLbTrafficExtensionMethod = DepServiceGrpc.getUpdateLbTrafficExtensionMethod)
            == null) {
          DepServiceGrpc.getUpdateLbTrafficExtensionMethod =
              getUpdateLbTrafficExtensionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.UpdateLbTrafficExtensionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateLbTrafficExtension"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.UpdateLbTrafficExtensionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DepServiceMethodDescriptorSupplier("UpdateLbTrafficExtension"))
                      .build();
        }
      }
    }
    return getUpdateLbTrafficExtensionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.DeleteLbTrafficExtensionRequest,
          com.google.longrunning.Operation>
      getDeleteLbTrafficExtensionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteLbTrafficExtension",
      requestType = com.google.cloud.networkservices.v1.DeleteLbTrafficExtensionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.DeleteLbTrafficExtensionRequest,
          com.google.longrunning.Operation>
      getDeleteLbTrafficExtensionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.DeleteLbTrafficExtensionRequest,
            com.google.longrunning.Operation>
        getDeleteLbTrafficExtensionMethod;
    if ((getDeleteLbTrafficExtensionMethod = DepServiceGrpc.getDeleteLbTrafficExtensionMethod)
        == null) {
      synchronized (DepServiceGrpc.class) {
        if ((getDeleteLbTrafficExtensionMethod = DepServiceGrpc.getDeleteLbTrafficExtensionMethod)
            == null) {
          DepServiceGrpc.getDeleteLbTrafficExtensionMethod =
              getDeleteLbTrafficExtensionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.DeleteLbTrafficExtensionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteLbTrafficExtension"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.DeleteLbTrafficExtensionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DepServiceMethodDescriptorSupplier("DeleteLbTrafficExtension"))
                      .build();
        }
      }
    }
    return getDeleteLbTrafficExtensionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.ListLbRouteExtensionsRequest,
          com.google.cloud.networkservices.v1.ListLbRouteExtensionsResponse>
      getListLbRouteExtensionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListLbRouteExtensions",
      requestType = com.google.cloud.networkservices.v1.ListLbRouteExtensionsRequest.class,
      responseType = com.google.cloud.networkservices.v1.ListLbRouteExtensionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.ListLbRouteExtensionsRequest,
          com.google.cloud.networkservices.v1.ListLbRouteExtensionsResponse>
      getListLbRouteExtensionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.ListLbRouteExtensionsRequest,
            com.google.cloud.networkservices.v1.ListLbRouteExtensionsResponse>
        getListLbRouteExtensionsMethod;
    if ((getListLbRouteExtensionsMethod = DepServiceGrpc.getListLbRouteExtensionsMethod) == null) {
      synchronized (DepServiceGrpc.class) {
        if ((getListLbRouteExtensionsMethod = DepServiceGrpc.getListLbRouteExtensionsMethod)
            == null) {
          DepServiceGrpc.getListLbRouteExtensionsMethod =
              getListLbRouteExtensionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.ListLbRouteExtensionsRequest,
                          com.google.cloud.networkservices.v1.ListLbRouteExtensionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListLbRouteExtensions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.ListLbRouteExtensionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.ListLbRouteExtensionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DepServiceMethodDescriptorSupplier("ListLbRouteExtensions"))
                      .build();
        }
      }
    }
    return getListLbRouteExtensionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.GetLbRouteExtensionRequest,
          com.google.cloud.networkservices.v1.LbRouteExtension>
      getGetLbRouteExtensionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLbRouteExtension",
      requestType = com.google.cloud.networkservices.v1.GetLbRouteExtensionRequest.class,
      responseType = com.google.cloud.networkservices.v1.LbRouteExtension.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.GetLbRouteExtensionRequest,
          com.google.cloud.networkservices.v1.LbRouteExtension>
      getGetLbRouteExtensionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.GetLbRouteExtensionRequest,
            com.google.cloud.networkservices.v1.LbRouteExtension>
        getGetLbRouteExtensionMethod;
    if ((getGetLbRouteExtensionMethod = DepServiceGrpc.getGetLbRouteExtensionMethod) == null) {
      synchronized (DepServiceGrpc.class) {
        if ((getGetLbRouteExtensionMethod = DepServiceGrpc.getGetLbRouteExtensionMethod) == null) {
          DepServiceGrpc.getGetLbRouteExtensionMethod =
              getGetLbRouteExtensionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.GetLbRouteExtensionRequest,
                          com.google.cloud.networkservices.v1.LbRouteExtension>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetLbRouteExtension"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.GetLbRouteExtensionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.LbRouteExtension
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DepServiceMethodDescriptorSupplier("GetLbRouteExtension"))
                      .build();
        }
      }
    }
    return getGetLbRouteExtensionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.CreateLbRouteExtensionRequest,
          com.google.longrunning.Operation>
      getCreateLbRouteExtensionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateLbRouteExtension",
      requestType = com.google.cloud.networkservices.v1.CreateLbRouteExtensionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.CreateLbRouteExtensionRequest,
          com.google.longrunning.Operation>
      getCreateLbRouteExtensionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.CreateLbRouteExtensionRequest,
            com.google.longrunning.Operation>
        getCreateLbRouteExtensionMethod;
    if ((getCreateLbRouteExtensionMethod = DepServiceGrpc.getCreateLbRouteExtensionMethod)
        == null) {
      synchronized (DepServiceGrpc.class) {
        if ((getCreateLbRouteExtensionMethod = DepServiceGrpc.getCreateLbRouteExtensionMethod)
            == null) {
          DepServiceGrpc.getCreateLbRouteExtensionMethod =
              getCreateLbRouteExtensionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.CreateLbRouteExtensionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateLbRouteExtension"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.CreateLbRouteExtensionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DepServiceMethodDescriptorSupplier("CreateLbRouteExtension"))
                      .build();
        }
      }
    }
    return getCreateLbRouteExtensionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.UpdateLbRouteExtensionRequest,
          com.google.longrunning.Operation>
      getUpdateLbRouteExtensionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateLbRouteExtension",
      requestType = com.google.cloud.networkservices.v1.UpdateLbRouteExtensionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.UpdateLbRouteExtensionRequest,
          com.google.longrunning.Operation>
      getUpdateLbRouteExtensionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.UpdateLbRouteExtensionRequest,
            com.google.longrunning.Operation>
        getUpdateLbRouteExtensionMethod;
    if ((getUpdateLbRouteExtensionMethod = DepServiceGrpc.getUpdateLbRouteExtensionMethod)
        == null) {
      synchronized (DepServiceGrpc.class) {
        if ((getUpdateLbRouteExtensionMethod = DepServiceGrpc.getUpdateLbRouteExtensionMethod)
            == null) {
          DepServiceGrpc.getUpdateLbRouteExtensionMethod =
              getUpdateLbRouteExtensionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.UpdateLbRouteExtensionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateLbRouteExtension"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.UpdateLbRouteExtensionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DepServiceMethodDescriptorSupplier("UpdateLbRouteExtension"))
                      .build();
        }
      }
    }
    return getUpdateLbRouteExtensionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.DeleteLbRouteExtensionRequest,
          com.google.longrunning.Operation>
      getDeleteLbRouteExtensionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteLbRouteExtension",
      requestType = com.google.cloud.networkservices.v1.DeleteLbRouteExtensionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.DeleteLbRouteExtensionRequest,
          com.google.longrunning.Operation>
      getDeleteLbRouteExtensionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.DeleteLbRouteExtensionRequest,
            com.google.longrunning.Operation>
        getDeleteLbRouteExtensionMethod;
    if ((getDeleteLbRouteExtensionMethod = DepServiceGrpc.getDeleteLbRouteExtensionMethod)
        == null) {
      synchronized (DepServiceGrpc.class) {
        if ((getDeleteLbRouteExtensionMethod = DepServiceGrpc.getDeleteLbRouteExtensionMethod)
            == null) {
          DepServiceGrpc.getDeleteLbRouteExtensionMethod =
              getDeleteLbRouteExtensionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.DeleteLbRouteExtensionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteLbRouteExtension"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.DeleteLbRouteExtensionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DepServiceMethodDescriptorSupplier("DeleteLbRouteExtension"))
                      .build();
        }
      }
    }
    return getDeleteLbRouteExtensionMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DepServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DepServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DepServiceStub>() {
          @java.lang.Override
          public DepServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DepServiceStub(channel, callOptions);
          }
        };
    return DepServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DepServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DepServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DepServiceBlockingStub>() {
          @java.lang.Override
          public DepServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DepServiceBlockingStub(channel, callOptions);
          }
        };
    return DepServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DepServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DepServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DepServiceFutureStub>() {
          @java.lang.Override
          public DepServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DepServiceFutureStub(channel, callOptions);
          }
        };
    return DepServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service describing handlers for resources.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists `LbTrafficExtension` resources in a given project and location.
     * </pre>
     */
    default void listLbTrafficExtensions(
        com.google.cloud.networkservices.v1.ListLbTrafficExtensionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkservices.v1.ListLbTrafficExtensionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListLbTrafficExtensionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified `LbTrafficExtension` resource.
     * </pre>
     */
    default void getLbTrafficExtension(
        com.google.cloud.networkservices.v1.GetLbTrafficExtensionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.LbTrafficExtension>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetLbTrafficExtensionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new `LbTrafficExtension` resource in a given project and
     * location.
     * </pre>
     */
    default void createLbTrafficExtension(
        com.google.cloud.networkservices.v1.CreateLbTrafficExtensionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateLbTrafficExtensionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of the specified `LbTrafficExtension` resource.
     * </pre>
     */
    default void updateLbTrafficExtension(
        com.google.cloud.networkservices.v1.UpdateLbTrafficExtensionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateLbTrafficExtensionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified `LbTrafficExtension` resource.
     * </pre>
     */
    default void deleteLbTrafficExtension(
        com.google.cloud.networkservices.v1.DeleteLbTrafficExtensionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteLbTrafficExtensionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists `LbRouteExtension` resources in a given project and location.
     * </pre>
     */
    default void listLbRouteExtensions(
        com.google.cloud.networkservices.v1.ListLbRouteExtensionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkservices.v1.ListLbRouteExtensionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListLbRouteExtensionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified `LbRouteExtension` resource.
     * </pre>
     */
    default void getLbRouteExtension(
        com.google.cloud.networkservices.v1.GetLbRouteExtensionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.LbRouteExtension>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetLbRouteExtensionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new `LbRouteExtension` resource in a given project and location.
     * </pre>
     */
    default void createLbRouteExtension(
        com.google.cloud.networkservices.v1.CreateLbRouteExtensionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateLbRouteExtensionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of the specified `LbRouteExtension` resource.
     * </pre>
     */
    default void updateLbRouteExtension(
        com.google.cloud.networkservices.v1.UpdateLbRouteExtensionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateLbRouteExtensionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified `LbRouteExtension` resource.
     * </pre>
     */
    default void deleteLbRouteExtension(
        com.google.cloud.networkservices.v1.DeleteLbRouteExtensionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteLbRouteExtensionMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DepService.
   *
   * <pre>
   * Service describing handlers for resources.
   * </pre>
   */
  public abstract static class DepServiceImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DepServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DepService.
   *
   * <pre>
   * Service describing handlers for resources.
   * </pre>
   */
  public static final class DepServiceStub extends io.grpc.stub.AbstractAsyncStub<DepServiceStub> {
    private DepServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DepServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DepServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists `LbTrafficExtension` resources in a given project and location.
     * </pre>
     */
    public void listLbTrafficExtensions(
        com.google.cloud.networkservices.v1.ListLbTrafficExtensionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkservices.v1.ListLbTrafficExtensionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListLbTrafficExtensionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified `LbTrafficExtension` resource.
     * </pre>
     */
    public void getLbTrafficExtension(
        com.google.cloud.networkservices.v1.GetLbTrafficExtensionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.LbTrafficExtension>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLbTrafficExtensionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new `LbTrafficExtension` resource in a given project and
     * location.
     * </pre>
     */
    public void createLbTrafficExtension(
        com.google.cloud.networkservices.v1.CreateLbTrafficExtensionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateLbTrafficExtensionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of the specified `LbTrafficExtension` resource.
     * </pre>
     */
    public void updateLbTrafficExtension(
        com.google.cloud.networkservices.v1.UpdateLbTrafficExtensionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateLbTrafficExtensionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified `LbTrafficExtension` resource.
     * </pre>
     */
    public void deleteLbTrafficExtension(
        com.google.cloud.networkservices.v1.DeleteLbTrafficExtensionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteLbTrafficExtensionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists `LbRouteExtension` resources in a given project and location.
     * </pre>
     */
    public void listLbRouteExtensions(
        com.google.cloud.networkservices.v1.ListLbRouteExtensionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkservices.v1.ListLbRouteExtensionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListLbRouteExtensionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified `LbRouteExtension` resource.
     * </pre>
     */
    public void getLbRouteExtension(
        com.google.cloud.networkservices.v1.GetLbRouteExtensionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.LbRouteExtension>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLbRouteExtensionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new `LbRouteExtension` resource in a given project and location.
     * </pre>
     */
    public void createLbRouteExtension(
        com.google.cloud.networkservices.v1.CreateLbRouteExtensionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateLbRouteExtensionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of the specified `LbRouteExtension` resource.
     * </pre>
     */
    public void updateLbRouteExtension(
        com.google.cloud.networkservices.v1.UpdateLbRouteExtensionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateLbRouteExtensionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified `LbRouteExtension` resource.
     * </pre>
     */
    public void deleteLbRouteExtension(
        com.google.cloud.networkservices.v1.DeleteLbRouteExtensionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteLbRouteExtensionMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DepService.
   *
   * <pre>
   * Service describing handlers for resources.
   * </pre>
   */
  public static final class DepServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DepServiceBlockingStub> {
    private DepServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DepServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DepServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists `LbTrafficExtension` resources in a given project and location.
     * </pre>
     */
    public com.google.cloud.networkservices.v1.ListLbTrafficExtensionsResponse
        listLbTrafficExtensions(
            com.google.cloud.networkservices.v1.ListLbTrafficExtensionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListLbTrafficExtensionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified `LbTrafficExtension` resource.
     * </pre>
     */
    public com.google.cloud.networkservices.v1.LbTrafficExtension getLbTrafficExtension(
        com.google.cloud.networkservices.v1.GetLbTrafficExtensionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLbTrafficExtensionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new `LbTrafficExtension` resource in a given project and
     * location.
     * </pre>
     */
    public com.google.longrunning.Operation createLbTrafficExtension(
        com.google.cloud.networkservices.v1.CreateLbTrafficExtensionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateLbTrafficExtensionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of the specified `LbTrafficExtension` resource.
     * </pre>
     */
    public com.google.longrunning.Operation updateLbTrafficExtension(
        com.google.cloud.networkservices.v1.UpdateLbTrafficExtensionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateLbTrafficExtensionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified `LbTrafficExtension` resource.
     * </pre>
     */
    public com.google.longrunning.Operation deleteLbTrafficExtension(
        com.google.cloud.networkservices.v1.DeleteLbTrafficExtensionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteLbTrafficExtensionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists `LbRouteExtension` resources in a given project and location.
     * </pre>
     */
    public com.google.cloud.networkservices.v1.ListLbRouteExtensionsResponse listLbRouteExtensions(
        com.google.cloud.networkservices.v1.ListLbRouteExtensionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListLbRouteExtensionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified `LbRouteExtension` resource.
     * </pre>
     */
    public com.google.cloud.networkservices.v1.LbRouteExtension getLbRouteExtension(
        com.google.cloud.networkservices.v1.GetLbRouteExtensionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLbRouteExtensionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new `LbRouteExtension` resource in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createLbRouteExtension(
        com.google.cloud.networkservices.v1.CreateLbRouteExtensionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateLbRouteExtensionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of the specified `LbRouteExtension` resource.
     * </pre>
     */
    public com.google.longrunning.Operation updateLbRouteExtension(
        com.google.cloud.networkservices.v1.UpdateLbRouteExtensionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateLbRouteExtensionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified `LbRouteExtension` resource.
     * </pre>
     */
    public com.google.longrunning.Operation deleteLbRouteExtension(
        com.google.cloud.networkservices.v1.DeleteLbRouteExtensionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteLbRouteExtensionMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DepService.
   *
   * <pre>
   * Service describing handlers for resources.
   * </pre>
   */
  public static final class DepServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DepServiceFutureStub> {
    private DepServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DepServiceFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DepServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists `LbTrafficExtension` resources in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkservices.v1.ListLbTrafficExtensionsResponse>
        listLbTrafficExtensions(
            com.google.cloud.networkservices.v1.ListLbTrafficExtensionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListLbTrafficExtensionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified `LbTrafficExtension` resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkservices.v1.LbTrafficExtension>
        getLbTrafficExtension(
            com.google.cloud.networkservices.v1.GetLbTrafficExtensionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLbTrafficExtensionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new `LbTrafficExtension` resource in a given project and
     * location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createLbTrafficExtension(
            com.google.cloud.networkservices.v1.CreateLbTrafficExtensionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateLbTrafficExtensionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of the specified `LbTrafficExtension` resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateLbTrafficExtension(
            com.google.cloud.networkservices.v1.UpdateLbTrafficExtensionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateLbTrafficExtensionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified `LbTrafficExtension` resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteLbTrafficExtension(
            com.google.cloud.networkservices.v1.DeleteLbTrafficExtensionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteLbTrafficExtensionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists `LbRouteExtension` resources in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkservices.v1.ListLbRouteExtensionsResponse>
        listLbRouteExtensions(
            com.google.cloud.networkservices.v1.ListLbRouteExtensionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListLbRouteExtensionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified `LbRouteExtension` resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkservices.v1.LbRouteExtension>
        getLbRouteExtension(
            com.google.cloud.networkservices.v1.GetLbRouteExtensionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLbRouteExtensionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new `LbRouteExtension` resource in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createLbRouteExtension(
            com.google.cloud.networkservices.v1.CreateLbRouteExtensionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateLbRouteExtensionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of the specified `LbRouteExtension` resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateLbRouteExtension(
            com.google.cloud.networkservices.v1.UpdateLbRouteExtensionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateLbRouteExtensionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified `LbRouteExtension` resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteLbRouteExtension(
            com.google.cloud.networkservices.v1.DeleteLbRouteExtensionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteLbRouteExtensionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_LB_TRAFFIC_EXTENSIONS = 0;
  private static final int METHODID_GET_LB_TRAFFIC_EXTENSION = 1;
  private static final int METHODID_CREATE_LB_TRAFFIC_EXTENSION = 2;
  private static final int METHODID_UPDATE_LB_TRAFFIC_EXTENSION = 3;
  private static final int METHODID_DELETE_LB_TRAFFIC_EXTENSION = 4;
  private static final int METHODID_LIST_LB_ROUTE_EXTENSIONS = 5;
  private static final int METHODID_GET_LB_ROUTE_EXTENSION = 6;
  private static final int METHODID_CREATE_LB_ROUTE_EXTENSION = 7;
  private static final int METHODID_UPDATE_LB_ROUTE_EXTENSION = 8;
  private static final int METHODID_DELETE_LB_ROUTE_EXTENSION = 9;

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
        case METHODID_LIST_LB_TRAFFIC_EXTENSIONS:
          serviceImpl.listLbTrafficExtensions(
              (com.google.cloud.networkservices.v1.ListLbTrafficExtensionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkservices.v1.ListLbTrafficExtensionsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_LB_TRAFFIC_EXTENSION:
          serviceImpl.getLbTrafficExtension(
              (com.google.cloud.networkservices.v1.GetLbTrafficExtensionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.LbTrafficExtension>)
                  responseObserver);
          break;
        case METHODID_CREATE_LB_TRAFFIC_EXTENSION:
          serviceImpl.createLbTrafficExtension(
              (com.google.cloud.networkservices.v1.CreateLbTrafficExtensionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_LB_TRAFFIC_EXTENSION:
          serviceImpl.updateLbTrafficExtension(
              (com.google.cloud.networkservices.v1.UpdateLbTrafficExtensionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_LB_TRAFFIC_EXTENSION:
          serviceImpl.deleteLbTrafficExtension(
              (com.google.cloud.networkservices.v1.DeleteLbTrafficExtensionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_LB_ROUTE_EXTENSIONS:
          serviceImpl.listLbRouteExtensions(
              (com.google.cloud.networkservices.v1.ListLbRouteExtensionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkservices.v1.ListLbRouteExtensionsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_LB_ROUTE_EXTENSION:
          serviceImpl.getLbRouteExtension(
              (com.google.cloud.networkservices.v1.GetLbRouteExtensionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.LbRouteExtension>)
                  responseObserver);
          break;
        case METHODID_CREATE_LB_ROUTE_EXTENSION:
          serviceImpl.createLbRouteExtension(
              (com.google.cloud.networkservices.v1.CreateLbRouteExtensionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_LB_ROUTE_EXTENSION:
          serviceImpl.updateLbRouteExtension(
              (com.google.cloud.networkservices.v1.UpdateLbRouteExtensionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_LB_ROUTE_EXTENSION:
          serviceImpl.deleteLbRouteExtension(
              (com.google.cloud.networkservices.v1.DeleteLbRouteExtensionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
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
            getListLbTrafficExtensionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.ListLbTrafficExtensionsRequest,
                    com.google.cloud.networkservices.v1.ListLbTrafficExtensionsResponse>(
                    service, METHODID_LIST_LB_TRAFFIC_EXTENSIONS)))
        .addMethod(
            getGetLbTrafficExtensionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.GetLbTrafficExtensionRequest,
                    com.google.cloud.networkservices.v1.LbTrafficExtension>(
                    service, METHODID_GET_LB_TRAFFIC_EXTENSION)))
        .addMethod(
            getCreateLbTrafficExtensionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.CreateLbTrafficExtensionRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_LB_TRAFFIC_EXTENSION)))
        .addMethod(
            getUpdateLbTrafficExtensionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.UpdateLbTrafficExtensionRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_LB_TRAFFIC_EXTENSION)))
        .addMethod(
            getDeleteLbTrafficExtensionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.DeleteLbTrafficExtensionRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_LB_TRAFFIC_EXTENSION)))
        .addMethod(
            getListLbRouteExtensionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.ListLbRouteExtensionsRequest,
                    com.google.cloud.networkservices.v1.ListLbRouteExtensionsResponse>(
                    service, METHODID_LIST_LB_ROUTE_EXTENSIONS)))
        .addMethod(
            getGetLbRouteExtensionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.GetLbRouteExtensionRequest,
                    com.google.cloud.networkservices.v1.LbRouteExtension>(
                    service, METHODID_GET_LB_ROUTE_EXTENSION)))
        .addMethod(
            getCreateLbRouteExtensionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.CreateLbRouteExtensionRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_LB_ROUTE_EXTENSION)))
        .addMethod(
            getUpdateLbRouteExtensionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.UpdateLbRouteExtensionRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_LB_ROUTE_EXTENSION)))
        .addMethod(
            getDeleteLbRouteExtensionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.DeleteLbRouteExtensionRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_LB_ROUTE_EXTENSION)))
        .build();
  }

  private abstract static class DepServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DepServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.networkservices.v1.DepProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DepService");
    }
  }

  private static final class DepServiceFileDescriptorSupplier
      extends DepServiceBaseDescriptorSupplier {
    DepServiceFileDescriptorSupplier() {}
  }

  private static final class DepServiceMethodDescriptorSupplier
      extends DepServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DepServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DepServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DepServiceFileDescriptorSupplier())
                      .addMethod(getListLbTrafficExtensionsMethod())
                      .addMethod(getGetLbTrafficExtensionMethod())
                      .addMethod(getCreateLbTrafficExtensionMethod())
                      .addMethod(getUpdateLbTrafficExtensionMethod())
                      .addMethod(getDeleteLbTrafficExtensionMethod())
                      .addMethod(getListLbRouteExtensionsMethod())
                      .addMethod(getGetLbRouteExtensionMethod())
                      .addMethod(getCreateLbRouteExtensionMethod())
                      .addMethod(getUpdateLbRouteExtensionMethod())
                      .addMethod(getDeleteLbRouteExtensionMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
