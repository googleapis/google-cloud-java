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
package com.google.cloud.cloudsecuritycompliance.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service describing handlers for config resources
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/cloudsecuritycompliance/v1/config.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ConfigGrpc {

  private ConfigGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.cloudsecuritycompliance.v1.Config";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksRequest,
          com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksResponse>
      getListFrameworksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFrameworks",
      requestType = com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksRequest.class,
      responseType = com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksRequest,
          com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksResponse>
      getListFrameworksMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksRequest,
            com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksResponse>
        getListFrameworksMethod;
    if ((getListFrameworksMethod = ConfigGrpc.getListFrameworksMethod) == null) {
      synchronized (ConfigGrpc.class) {
        if ((getListFrameworksMethod = ConfigGrpc.getListFrameworksMethod) == null) {
          ConfigGrpc.getListFrameworksMethod =
              getListFrameworksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksRequest,
                          com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFrameworks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ConfigMethodDescriptorSupplier("ListFrameworks"))
                      .build();
        }
      }
    }
    return getListFrameworksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkRequest,
          com.google.cloud.cloudsecuritycompliance.v1.Framework>
      getGetFrameworkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFramework",
      requestType = com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkRequest.class,
      responseType = com.google.cloud.cloudsecuritycompliance.v1.Framework.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkRequest,
          com.google.cloud.cloudsecuritycompliance.v1.Framework>
      getGetFrameworkMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkRequest,
            com.google.cloud.cloudsecuritycompliance.v1.Framework>
        getGetFrameworkMethod;
    if ((getGetFrameworkMethod = ConfigGrpc.getGetFrameworkMethod) == null) {
      synchronized (ConfigGrpc.class) {
        if ((getGetFrameworkMethod = ConfigGrpc.getGetFrameworkMethod) == null) {
          ConfigGrpc.getGetFrameworkMethod =
              getGetFrameworkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkRequest,
                          com.google.cloud.cloudsecuritycompliance.v1.Framework>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFramework"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1.Framework
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ConfigMethodDescriptorSupplier("GetFramework"))
                      .build();
        }
      }
    }
    return getGetFrameworkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkRequest,
          com.google.cloud.cloudsecuritycompliance.v1.Framework>
      getCreateFrameworkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFramework",
      requestType = com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkRequest.class,
      responseType = com.google.cloud.cloudsecuritycompliance.v1.Framework.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkRequest,
          com.google.cloud.cloudsecuritycompliance.v1.Framework>
      getCreateFrameworkMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkRequest,
            com.google.cloud.cloudsecuritycompliance.v1.Framework>
        getCreateFrameworkMethod;
    if ((getCreateFrameworkMethod = ConfigGrpc.getCreateFrameworkMethod) == null) {
      synchronized (ConfigGrpc.class) {
        if ((getCreateFrameworkMethod = ConfigGrpc.getCreateFrameworkMethod) == null) {
          ConfigGrpc.getCreateFrameworkMethod =
              getCreateFrameworkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkRequest,
                          com.google.cloud.cloudsecuritycompliance.v1.Framework>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFramework"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1.Framework
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ConfigMethodDescriptorSupplier("CreateFramework"))
                      .build();
        }
      }
    }
    return getCreateFrameworkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.UpdateFrameworkRequest,
          com.google.cloud.cloudsecuritycompliance.v1.Framework>
      getUpdateFrameworkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFramework",
      requestType = com.google.cloud.cloudsecuritycompliance.v1.UpdateFrameworkRequest.class,
      responseType = com.google.cloud.cloudsecuritycompliance.v1.Framework.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.UpdateFrameworkRequest,
          com.google.cloud.cloudsecuritycompliance.v1.Framework>
      getUpdateFrameworkMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.cloudsecuritycompliance.v1.UpdateFrameworkRequest,
            com.google.cloud.cloudsecuritycompliance.v1.Framework>
        getUpdateFrameworkMethod;
    if ((getUpdateFrameworkMethod = ConfigGrpc.getUpdateFrameworkMethod) == null) {
      synchronized (ConfigGrpc.class) {
        if ((getUpdateFrameworkMethod = ConfigGrpc.getUpdateFrameworkMethod) == null) {
          ConfigGrpc.getUpdateFrameworkMethod =
              getUpdateFrameworkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.cloudsecuritycompliance.v1.UpdateFrameworkRequest,
                          com.google.cloud.cloudsecuritycompliance.v1.Framework>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateFramework"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1.UpdateFrameworkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1.Framework
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ConfigMethodDescriptorSupplier("UpdateFramework"))
                      .build();
        }
      }
    }
    return getUpdateFrameworkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.DeleteFrameworkRequest,
          com.google.protobuf.Empty>
      getDeleteFrameworkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFramework",
      requestType = com.google.cloud.cloudsecuritycompliance.v1.DeleteFrameworkRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.DeleteFrameworkRequest,
          com.google.protobuf.Empty>
      getDeleteFrameworkMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.cloudsecuritycompliance.v1.DeleteFrameworkRequest,
            com.google.protobuf.Empty>
        getDeleteFrameworkMethod;
    if ((getDeleteFrameworkMethod = ConfigGrpc.getDeleteFrameworkMethod) == null) {
      synchronized (ConfigGrpc.class) {
        if ((getDeleteFrameworkMethod = ConfigGrpc.getDeleteFrameworkMethod) == null) {
          ConfigGrpc.getDeleteFrameworkMethod =
              getDeleteFrameworkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.cloudsecuritycompliance.v1.DeleteFrameworkRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteFramework"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1.DeleteFrameworkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new ConfigMethodDescriptorSupplier("DeleteFramework"))
                      .build();
        }
      }
    }
    return getDeleteFrameworkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsRequest,
          com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsResponse>
      getListCloudControlsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCloudControls",
      requestType = com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsRequest.class,
      responseType = com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsRequest,
          com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsResponse>
      getListCloudControlsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsRequest,
            com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsResponse>
        getListCloudControlsMethod;
    if ((getListCloudControlsMethod = ConfigGrpc.getListCloudControlsMethod) == null) {
      synchronized (ConfigGrpc.class) {
        if ((getListCloudControlsMethod = ConfigGrpc.getListCloudControlsMethod) == null) {
          ConfigGrpc.getListCloudControlsMethod =
              getListCloudControlsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsRequest,
                          com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCloudControls"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ConfigMethodDescriptorSupplier("ListCloudControls"))
                      .build();
        }
      }
    }
    return getListCloudControlsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.GetCloudControlRequest,
          com.google.cloud.cloudsecuritycompliance.v1.CloudControl>
      getGetCloudControlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCloudControl",
      requestType = com.google.cloud.cloudsecuritycompliance.v1.GetCloudControlRequest.class,
      responseType = com.google.cloud.cloudsecuritycompliance.v1.CloudControl.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.GetCloudControlRequest,
          com.google.cloud.cloudsecuritycompliance.v1.CloudControl>
      getGetCloudControlMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.cloudsecuritycompliance.v1.GetCloudControlRequest,
            com.google.cloud.cloudsecuritycompliance.v1.CloudControl>
        getGetCloudControlMethod;
    if ((getGetCloudControlMethod = ConfigGrpc.getGetCloudControlMethod) == null) {
      synchronized (ConfigGrpc.class) {
        if ((getGetCloudControlMethod = ConfigGrpc.getGetCloudControlMethod) == null) {
          ConfigGrpc.getGetCloudControlMethod =
              getGetCloudControlMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.cloudsecuritycompliance.v1.GetCloudControlRequest,
                          com.google.cloud.cloudsecuritycompliance.v1.CloudControl>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCloudControl"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1.GetCloudControlRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1.CloudControl
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ConfigMethodDescriptorSupplier("GetCloudControl"))
                      .build();
        }
      }
    }
    return getGetCloudControlMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.CreateCloudControlRequest,
          com.google.cloud.cloudsecuritycompliance.v1.CloudControl>
      getCreateCloudControlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCloudControl",
      requestType = com.google.cloud.cloudsecuritycompliance.v1.CreateCloudControlRequest.class,
      responseType = com.google.cloud.cloudsecuritycompliance.v1.CloudControl.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.CreateCloudControlRequest,
          com.google.cloud.cloudsecuritycompliance.v1.CloudControl>
      getCreateCloudControlMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.cloudsecuritycompliance.v1.CreateCloudControlRequest,
            com.google.cloud.cloudsecuritycompliance.v1.CloudControl>
        getCreateCloudControlMethod;
    if ((getCreateCloudControlMethod = ConfigGrpc.getCreateCloudControlMethod) == null) {
      synchronized (ConfigGrpc.class) {
        if ((getCreateCloudControlMethod = ConfigGrpc.getCreateCloudControlMethod) == null) {
          ConfigGrpc.getCreateCloudControlMethod =
              getCreateCloudControlMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.cloudsecuritycompliance.v1.CreateCloudControlRequest,
                          com.google.cloud.cloudsecuritycompliance.v1.CloudControl>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCloudControl"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1.CreateCloudControlRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1.CloudControl
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ConfigMethodDescriptorSupplier("CreateCloudControl"))
                      .build();
        }
      }
    }
    return getCreateCloudControlMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.UpdateCloudControlRequest,
          com.google.cloud.cloudsecuritycompliance.v1.CloudControl>
      getUpdateCloudControlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCloudControl",
      requestType = com.google.cloud.cloudsecuritycompliance.v1.UpdateCloudControlRequest.class,
      responseType = com.google.cloud.cloudsecuritycompliance.v1.CloudControl.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.UpdateCloudControlRequest,
          com.google.cloud.cloudsecuritycompliance.v1.CloudControl>
      getUpdateCloudControlMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.cloudsecuritycompliance.v1.UpdateCloudControlRequest,
            com.google.cloud.cloudsecuritycompliance.v1.CloudControl>
        getUpdateCloudControlMethod;
    if ((getUpdateCloudControlMethod = ConfigGrpc.getUpdateCloudControlMethod) == null) {
      synchronized (ConfigGrpc.class) {
        if ((getUpdateCloudControlMethod = ConfigGrpc.getUpdateCloudControlMethod) == null) {
          ConfigGrpc.getUpdateCloudControlMethod =
              getUpdateCloudControlMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.cloudsecuritycompliance.v1.UpdateCloudControlRequest,
                          com.google.cloud.cloudsecuritycompliance.v1.CloudControl>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCloudControl"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1.UpdateCloudControlRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1.CloudControl
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ConfigMethodDescriptorSupplier("UpdateCloudControl"))
                      .build();
        }
      }
    }
    return getUpdateCloudControlMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.DeleteCloudControlRequest,
          com.google.protobuf.Empty>
      getDeleteCloudControlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCloudControl",
      requestType = com.google.cloud.cloudsecuritycompliance.v1.DeleteCloudControlRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.DeleteCloudControlRequest,
          com.google.protobuf.Empty>
      getDeleteCloudControlMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.cloudsecuritycompliance.v1.DeleteCloudControlRequest,
            com.google.protobuf.Empty>
        getDeleteCloudControlMethod;
    if ((getDeleteCloudControlMethod = ConfigGrpc.getDeleteCloudControlMethod) == null) {
      synchronized (ConfigGrpc.class) {
        if ((getDeleteCloudControlMethod = ConfigGrpc.getDeleteCloudControlMethod) == null) {
          ConfigGrpc.getDeleteCloudControlMethod =
              getDeleteCloudControlMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.cloudsecuritycompliance.v1.DeleteCloudControlRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCloudControl"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1.DeleteCloudControlRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new ConfigMethodDescriptorSupplier("DeleteCloudControl"))
                      .build();
        }
      }
    }
    return getDeleteCloudControlMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ConfigStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConfigStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConfigStub>() {
          @java.lang.Override
          public ConfigStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConfigStub(channel, callOptions);
          }
        };
    return ConfigStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static ConfigBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConfigBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConfigBlockingV2Stub>() {
          @java.lang.Override
          public ConfigBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConfigBlockingV2Stub(channel, callOptions);
          }
        };
    return ConfigBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConfigBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConfigBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConfigBlockingStub>() {
          @java.lang.Override
          public ConfigBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConfigBlockingStub(channel, callOptions);
          }
        };
    return ConfigBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ConfigFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConfigFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConfigFutureStub>() {
          @java.lang.Override
          public ConfigFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConfigFutureStub(channel, callOptions);
          }
        };
    return ConfigFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service describing handlers for config resources
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists Frameworks in a given organization.
     * </pre>
     */
    default void listFrameworks(
        com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListFrameworksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Framework.
     * </pre>
     */
    default void getFramework(
        com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudsecuritycompliance.v1.Framework>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetFrameworkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a single framework for a given resource.
     * </pre>
     */
    default void createFramework(
        com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudsecuritycompliance.v1.Framework>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateFrameworkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a single Framework.
     * </pre>
     */
    default void updateFramework(
        com.google.cloud.cloudsecuritycompliance.v1.UpdateFrameworkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudsecuritycompliance.v1.Framework>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateFrameworkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Framework.
     * </pre>
     */
    default void deleteFramework(
        com.google.cloud.cloudsecuritycompliance.v1.DeleteFrameworkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteFrameworkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists CloudControls in a given organization.
     * </pre>
     */
    default void listCloudControls(
        com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCloudControlsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CloudControl.
     * </pre>
     */
    default void getCloudControl(
        com.google.cloud.cloudsecuritycompliance.v1.GetCloudControlRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudsecuritycompliance.v1.CloudControl>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCloudControlMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a single CloudControl for a given resource.
     * </pre>
     */
    default void createCloudControl(
        com.google.cloud.cloudsecuritycompliance.v1.CreateCloudControlRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudsecuritycompliance.v1.CloudControl>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCloudControlMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a single CloudControl.
     * </pre>
     */
    default void updateCloudControl(
        com.google.cloud.cloudsecuritycompliance.v1.UpdateCloudControlRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudsecuritycompliance.v1.CloudControl>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateCloudControlMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single CloudControl.
     * </pre>
     */
    default void deleteCloudControl(
        com.google.cloud.cloudsecuritycompliance.v1.DeleteCloudControlRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteCloudControlMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Config.
   *
   * <pre>
   * Service describing handlers for config resources
   * </pre>
   */
  public abstract static class ConfigImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ConfigGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Config.
   *
   * <pre>
   * Service describing handlers for config resources
   * </pre>
   */
  public static final class ConfigStub extends io.grpc.stub.AbstractAsyncStub<ConfigStub> {
    private ConfigStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConfigStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Frameworks in a given organization.
     * </pre>
     */
    public void listFrameworks(
        com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFrameworksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Framework.
     * </pre>
     */
    public void getFramework(
        com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudsecuritycompliance.v1.Framework>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFrameworkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a single framework for a given resource.
     * </pre>
     */
    public void createFramework(
        com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudsecuritycompliance.v1.Framework>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFrameworkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a single Framework.
     * </pre>
     */
    public void updateFramework(
        com.google.cloud.cloudsecuritycompliance.v1.UpdateFrameworkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudsecuritycompliance.v1.Framework>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFrameworkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Framework.
     * </pre>
     */
    public void deleteFramework(
        com.google.cloud.cloudsecuritycompliance.v1.DeleteFrameworkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFrameworkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists CloudControls in a given organization.
     * </pre>
     */
    public void listCloudControls(
        com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCloudControlsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CloudControl.
     * </pre>
     */
    public void getCloudControl(
        com.google.cloud.cloudsecuritycompliance.v1.GetCloudControlRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudsecuritycompliance.v1.CloudControl>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCloudControlMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a single CloudControl for a given resource.
     * </pre>
     */
    public void createCloudControl(
        com.google.cloud.cloudsecuritycompliance.v1.CreateCloudControlRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudsecuritycompliance.v1.CloudControl>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCloudControlMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a single CloudControl.
     * </pre>
     */
    public void updateCloudControl(
        com.google.cloud.cloudsecuritycompliance.v1.UpdateCloudControlRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudsecuritycompliance.v1.CloudControl>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCloudControlMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single CloudControl.
     * </pre>
     */
    public void deleteCloudControl(
        com.google.cloud.cloudsecuritycompliance.v1.DeleteCloudControlRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCloudControlMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Config.
   *
   * <pre>
   * Service describing handlers for config resources
   * </pre>
   */
  public static final class ConfigBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<ConfigBlockingV2Stub> {
    private ConfigBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigBlockingV2Stub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConfigBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Frameworks in a given organization.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksResponse listFrameworks(
        com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFrameworksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Framework.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.Framework getFramework(
        com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFrameworkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a single framework for a given resource.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.Framework createFramework(
        com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFrameworkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a single Framework.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.Framework updateFramework(
        com.google.cloud.cloudsecuritycompliance.v1.UpdateFrameworkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFrameworkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Framework.
     * </pre>
     */
    public com.google.protobuf.Empty deleteFramework(
        com.google.cloud.cloudsecuritycompliance.v1.DeleteFrameworkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFrameworkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists CloudControls in a given organization.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsResponse listCloudControls(
        com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCloudControlsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CloudControl.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.CloudControl getCloudControl(
        com.google.cloud.cloudsecuritycompliance.v1.GetCloudControlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCloudControlMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a single CloudControl for a given resource.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.CloudControl createCloudControl(
        com.google.cloud.cloudsecuritycompliance.v1.CreateCloudControlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCloudControlMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a single CloudControl.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.CloudControl updateCloudControl(
        com.google.cloud.cloudsecuritycompliance.v1.UpdateCloudControlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCloudControlMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single CloudControl.
     * </pre>
     */
    public com.google.protobuf.Empty deleteCloudControl(
        com.google.cloud.cloudsecuritycompliance.v1.DeleteCloudControlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCloudControlMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Config.
   *
   * <pre>
   * Service describing handlers for config resources
   * </pre>
   */
  public static final class ConfigBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ConfigBlockingStub> {
    private ConfigBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConfigBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Frameworks in a given organization.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksResponse listFrameworks(
        com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFrameworksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Framework.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.Framework getFramework(
        com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFrameworkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a single framework for a given resource.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.Framework createFramework(
        com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFrameworkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a single Framework.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.Framework updateFramework(
        com.google.cloud.cloudsecuritycompliance.v1.UpdateFrameworkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFrameworkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Framework.
     * </pre>
     */
    public com.google.protobuf.Empty deleteFramework(
        com.google.cloud.cloudsecuritycompliance.v1.DeleteFrameworkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFrameworkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists CloudControls in a given organization.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsResponse listCloudControls(
        com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCloudControlsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CloudControl.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.CloudControl getCloudControl(
        com.google.cloud.cloudsecuritycompliance.v1.GetCloudControlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCloudControlMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a single CloudControl for a given resource.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.CloudControl createCloudControl(
        com.google.cloud.cloudsecuritycompliance.v1.CreateCloudControlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCloudControlMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a single CloudControl.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.CloudControl updateCloudControl(
        com.google.cloud.cloudsecuritycompliance.v1.UpdateCloudControlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCloudControlMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single CloudControl.
     * </pre>
     */
    public com.google.protobuf.Empty deleteCloudControl(
        com.google.cloud.cloudsecuritycompliance.v1.DeleteCloudControlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCloudControlMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Config.
   *
   * <pre>
   * Service describing handlers for config resources
   * </pre>
   */
  public static final class ConfigFutureStub
      extends io.grpc.stub.AbstractFutureStub<ConfigFutureStub> {
    private ConfigFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConfigFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Frameworks in a given organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksResponse>
        listFrameworks(com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFrameworksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Framework.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.cloudsecuritycompliance.v1.Framework>
        getFramework(com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFrameworkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a single framework for a given resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.cloudsecuritycompliance.v1.Framework>
        createFramework(
            com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFrameworkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a single Framework.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.cloudsecuritycompliance.v1.Framework>
        updateFramework(
            com.google.cloud.cloudsecuritycompliance.v1.UpdateFrameworkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateFrameworkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Framework.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteFramework(
            com.google.cloud.cloudsecuritycompliance.v1.DeleteFrameworkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteFrameworkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists CloudControls in a given organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsResponse>
        listCloudControls(
            com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCloudControlsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CloudControl.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.cloudsecuritycompliance.v1.CloudControl>
        getCloudControl(
            com.google.cloud.cloudsecuritycompliance.v1.GetCloudControlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCloudControlMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a single CloudControl for a given resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.cloudsecuritycompliance.v1.CloudControl>
        createCloudControl(
            com.google.cloud.cloudsecuritycompliance.v1.CreateCloudControlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCloudControlMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a single CloudControl.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.cloudsecuritycompliance.v1.CloudControl>
        updateCloudControl(
            com.google.cloud.cloudsecuritycompliance.v1.UpdateCloudControlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCloudControlMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single CloudControl.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteCloudControl(
            com.google.cloud.cloudsecuritycompliance.v1.DeleteCloudControlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCloudControlMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_FRAMEWORKS = 0;
  private static final int METHODID_GET_FRAMEWORK = 1;
  private static final int METHODID_CREATE_FRAMEWORK = 2;
  private static final int METHODID_UPDATE_FRAMEWORK = 3;
  private static final int METHODID_DELETE_FRAMEWORK = 4;
  private static final int METHODID_LIST_CLOUD_CONTROLS = 5;
  private static final int METHODID_GET_CLOUD_CONTROL = 6;
  private static final int METHODID_CREATE_CLOUD_CONTROL = 7;
  private static final int METHODID_UPDATE_CLOUD_CONTROL = 8;
  private static final int METHODID_DELETE_CLOUD_CONTROL = 9;

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
        case METHODID_LIST_FRAMEWORKS:
          serviceImpl.listFrameworks(
              (com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksResponse>)
                  responseObserver);
          break;
        case METHODID_GET_FRAMEWORK:
          serviceImpl.getFramework(
              (com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.cloudsecuritycompliance.v1.Framework>)
                  responseObserver);
          break;
        case METHODID_CREATE_FRAMEWORK:
          serviceImpl.createFramework(
              (com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.cloudsecuritycompliance.v1.Framework>)
                  responseObserver);
          break;
        case METHODID_UPDATE_FRAMEWORK:
          serviceImpl.updateFramework(
              (com.google.cloud.cloudsecuritycompliance.v1.UpdateFrameworkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.cloudsecuritycompliance.v1.Framework>)
                  responseObserver);
          break;
        case METHODID_DELETE_FRAMEWORK:
          serviceImpl.deleteFramework(
              (com.google.cloud.cloudsecuritycompliance.v1.DeleteFrameworkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_CLOUD_CONTROLS:
          serviceImpl.listCloudControls(
              (com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CLOUD_CONTROL:
          serviceImpl.getCloudControl(
              (com.google.cloud.cloudsecuritycompliance.v1.GetCloudControlRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.cloudsecuritycompliance.v1.CloudControl>)
                  responseObserver);
          break;
        case METHODID_CREATE_CLOUD_CONTROL:
          serviceImpl.createCloudControl(
              (com.google.cloud.cloudsecuritycompliance.v1.CreateCloudControlRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.cloudsecuritycompliance.v1.CloudControl>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CLOUD_CONTROL:
          serviceImpl.updateCloudControl(
              (com.google.cloud.cloudsecuritycompliance.v1.UpdateCloudControlRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.cloudsecuritycompliance.v1.CloudControl>)
                  responseObserver);
          break;
        case METHODID_DELETE_CLOUD_CONTROL:
          serviceImpl.deleteCloudControl(
              (com.google.cloud.cloudsecuritycompliance.v1.DeleteCloudControlRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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
            getListFrameworksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksRequest,
                    com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksResponse>(
                    service, METHODID_LIST_FRAMEWORKS)))
        .addMethod(
            getGetFrameworkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkRequest,
                    com.google.cloud.cloudsecuritycompliance.v1.Framework>(
                    service, METHODID_GET_FRAMEWORK)))
        .addMethod(
            getCreateFrameworkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkRequest,
                    com.google.cloud.cloudsecuritycompliance.v1.Framework>(
                    service, METHODID_CREATE_FRAMEWORK)))
        .addMethod(
            getUpdateFrameworkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.cloudsecuritycompliance.v1.UpdateFrameworkRequest,
                    com.google.cloud.cloudsecuritycompliance.v1.Framework>(
                    service, METHODID_UPDATE_FRAMEWORK)))
        .addMethod(
            getDeleteFrameworkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.cloudsecuritycompliance.v1.DeleteFrameworkRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_FRAMEWORK)))
        .addMethod(
            getListCloudControlsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsRequest,
                    com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsResponse>(
                    service, METHODID_LIST_CLOUD_CONTROLS)))
        .addMethod(
            getGetCloudControlMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.cloudsecuritycompliance.v1.GetCloudControlRequest,
                    com.google.cloud.cloudsecuritycompliance.v1.CloudControl>(
                    service, METHODID_GET_CLOUD_CONTROL)))
        .addMethod(
            getCreateCloudControlMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.cloudsecuritycompliance.v1.CreateCloudControlRequest,
                    com.google.cloud.cloudsecuritycompliance.v1.CloudControl>(
                    service, METHODID_CREATE_CLOUD_CONTROL)))
        .addMethod(
            getUpdateCloudControlMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.cloudsecuritycompliance.v1.UpdateCloudControlRequest,
                    com.google.cloud.cloudsecuritycompliance.v1.CloudControl>(
                    service, METHODID_UPDATE_CLOUD_CONTROL)))
        .addMethod(
            getDeleteCloudControlMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.cloudsecuritycompliance.v1.DeleteCloudControlRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_CLOUD_CONTROL)))
        .build();
  }

  private abstract static class ConfigBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConfigBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.cloudsecuritycompliance.v1.ConfigProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Config");
    }
  }

  private static final class ConfigFileDescriptorSupplier extends ConfigBaseDescriptorSupplier {
    ConfigFileDescriptorSupplier() {}
  }

  private static final class ConfigMethodDescriptorSupplier extends ConfigBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ConfigMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ConfigGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ConfigFileDescriptorSupplier())
                      .addMethod(getListFrameworksMethod())
                      .addMethod(getGetFrameworkMethod())
                      .addMethod(getCreateFrameworkMethod())
                      .addMethod(getUpdateFrameworkMethod())
                      .addMethod(getDeleteFrameworkMethod())
                      .addMethod(getListCloudControlsMethod())
                      .addMethod(getGetCloudControlMethod())
                      .addMethod(getCreateCloudControlMethod())
                      .addMethod(getUpdateCloudControlMethod())
                      .addMethod(getDeleteCloudControlMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
