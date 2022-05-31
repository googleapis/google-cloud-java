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
package com.google.cloud.iot.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Internet of Things (IoT) service. Securely connect and manage IoT devices.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/iot/v1/device_manager.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DeviceManagerGrpc {

  private DeviceManagerGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.iot.v1.DeviceManager";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iot.v1.CreateDeviceRegistryRequest,
          com.google.cloud.iot.v1.DeviceRegistry>
      getCreateDeviceRegistryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDeviceRegistry",
      requestType = com.google.cloud.iot.v1.CreateDeviceRegistryRequest.class,
      responseType = com.google.cloud.iot.v1.DeviceRegistry.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iot.v1.CreateDeviceRegistryRequest,
          com.google.cloud.iot.v1.DeviceRegistry>
      getCreateDeviceRegistryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.iot.v1.CreateDeviceRegistryRequest,
            com.google.cloud.iot.v1.DeviceRegistry>
        getCreateDeviceRegistryMethod;
    if ((getCreateDeviceRegistryMethod = DeviceManagerGrpc.getCreateDeviceRegistryMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getCreateDeviceRegistryMethod = DeviceManagerGrpc.getCreateDeviceRegistryMethod)
            == null) {
          DeviceManagerGrpc.getCreateDeviceRegistryMethod =
              getCreateDeviceRegistryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iot.v1.CreateDeviceRegistryRequest,
                          com.google.cloud.iot.v1.DeviceRegistry>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateDeviceRegistry"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iot.v1.CreateDeviceRegistryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iot.v1.DeviceRegistry.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeviceManagerMethodDescriptorSupplier("CreateDeviceRegistry"))
                      .build();
        }
      }
    }
    return getCreateDeviceRegistryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iot.v1.GetDeviceRegistryRequest, com.google.cloud.iot.v1.DeviceRegistry>
      getGetDeviceRegistryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDeviceRegistry",
      requestType = com.google.cloud.iot.v1.GetDeviceRegistryRequest.class,
      responseType = com.google.cloud.iot.v1.DeviceRegistry.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iot.v1.GetDeviceRegistryRequest, com.google.cloud.iot.v1.DeviceRegistry>
      getGetDeviceRegistryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.iot.v1.GetDeviceRegistryRequest,
            com.google.cloud.iot.v1.DeviceRegistry>
        getGetDeviceRegistryMethod;
    if ((getGetDeviceRegistryMethod = DeviceManagerGrpc.getGetDeviceRegistryMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getGetDeviceRegistryMethod = DeviceManagerGrpc.getGetDeviceRegistryMethod) == null) {
          DeviceManagerGrpc.getGetDeviceRegistryMethod =
              getGetDeviceRegistryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iot.v1.GetDeviceRegistryRequest,
                          com.google.cloud.iot.v1.DeviceRegistry>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDeviceRegistry"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iot.v1.GetDeviceRegistryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iot.v1.DeviceRegistry.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeviceManagerMethodDescriptorSupplier("GetDeviceRegistry"))
                      .build();
        }
      }
    }
    return getGetDeviceRegistryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iot.v1.UpdateDeviceRegistryRequest,
          com.google.cloud.iot.v1.DeviceRegistry>
      getUpdateDeviceRegistryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDeviceRegistry",
      requestType = com.google.cloud.iot.v1.UpdateDeviceRegistryRequest.class,
      responseType = com.google.cloud.iot.v1.DeviceRegistry.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iot.v1.UpdateDeviceRegistryRequest,
          com.google.cloud.iot.v1.DeviceRegistry>
      getUpdateDeviceRegistryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.iot.v1.UpdateDeviceRegistryRequest,
            com.google.cloud.iot.v1.DeviceRegistry>
        getUpdateDeviceRegistryMethod;
    if ((getUpdateDeviceRegistryMethod = DeviceManagerGrpc.getUpdateDeviceRegistryMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getUpdateDeviceRegistryMethod = DeviceManagerGrpc.getUpdateDeviceRegistryMethod)
            == null) {
          DeviceManagerGrpc.getUpdateDeviceRegistryMethod =
              getUpdateDeviceRegistryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iot.v1.UpdateDeviceRegistryRequest,
                          com.google.cloud.iot.v1.DeviceRegistry>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateDeviceRegistry"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iot.v1.UpdateDeviceRegistryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iot.v1.DeviceRegistry.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeviceManagerMethodDescriptorSupplier("UpdateDeviceRegistry"))
                      .build();
        }
      }
    }
    return getUpdateDeviceRegistryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iot.v1.DeleteDeviceRegistryRequest, com.google.protobuf.Empty>
      getDeleteDeviceRegistryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDeviceRegistry",
      requestType = com.google.cloud.iot.v1.DeleteDeviceRegistryRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iot.v1.DeleteDeviceRegistryRequest, com.google.protobuf.Empty>
      getDeleteDeviceRegistryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.iot.v1.DeleteDeviceRegistryRequest, com.google.protobuf.Empty>
        getDeleteDeviceRegistryMethod;
    if ((getDeleteDeviceRegistryMethod = DeviceManagerGrpc.getDeleteDeviceRegistryMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getDeleteDeviceRegistryMethod = DeviceManagerGrpc.getDeleteDeviceRegistryMethod)
            == null) {
          DeviceManagerGrpc.getDeleteDeviceRegistryMethod =
              getDeleteDeviceRegistryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iot.v1.DeleteDeviceRegistryRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteDeviceRegistry"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iot.v1.DeleteDeviceRegistryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeviceManagerMethodDescriptorSupplier("DeleteDeviceRegistry"))
                      .build();
        }
      }
    }
    return getDeleteDeviceRegistryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iot.v1.ListDeviceRegistriesRequest,
          com.google.cloud.iot.v1.ListDeviceRegistriesResponse>
      getListDeviceRegistriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDeviceRegistries",
      requestType = com.google.cloud.iot.v1.ListDeviceRegistriesRequest.class,
      responseType = com.google.cloud.iot.v1.ListDeviceRegistriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iot.v1.ListDeviceRegistriesRequest,
          com.google.cloud.iot.v1.ListDeviceRegistriesResponse>
      getListDeviceRegistriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.iot.v1.ListDeviceRegistriesRequest,
            com.google.cloud.iot.v1.ListDeviceRegistriesResponse>
        getListDeviceRegistriesMethod;
    if ((getListDeviceRegistriesMethod = DeviceManagerGrpc.getListDeviceRegistriesMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getListDeviceRegistriesMethod = DeviceManagerGrpc.getListDeviceRegistriesMethod)
            == null) {
          DeviceManagerGrpc.getListDeviceRegistriesMethod =
              getListDeviceRegistriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iot.v1.ListDeviceRegistriesRequest,
                          com.google.cloud.iot.v1.ListDeviceRegistriesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListDeviceRegistries"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iot.v1.ListDeviceRegistriesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iot.v1.ListDeviceRegistriesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeviceManagerMethodDescriptorSupplier("ListDeviceRegistries"))
                      .build();
        }
      }
    }
    return getListDeviceRegistriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iot.v1.CreateDeviceRequest, com.google.cloud.iot.v1.Device>
      getCreateDeviceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDevice",
      requestType = com.google.cloud.iot.v1.CreateDeviceRequest.class,
      responseType = com.google.cloud.iot.v1.Device.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iot.v1.CreateDeviceRequest, com.google.cloud.iot.v1.Device>
      getCreateDeviceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.iot.v1.CreateDeviceRequest, com.google.cloud.iot.v1.Device>
        getCreateDeviceMethod;
    if ((getCreateDeviceMethod = DeviceManagerGrpc.getCreateDeviceMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getCreateDeviceMethod = DeviceManagerGrpc.getCreateDeviceMethod) == null) {
          DeviceManagerGrpc.getCreateDeviceMethod =
              getCreateDeviceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iot.v1.CreateDeviceRequest, com.google.cloud.iot.v1.Device>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDevice"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iot.v1.CreateDeviceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iot.v1.Device.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeviceManagerMethodDescriptorSupplier("CreateDevice"))
                      .build();
        }
      }
    }
    return getCreateDeviceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iot.v1.GetDeviceRequest, com.google.cloud.iot.v1.Device>
      getGetDeviceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDevice",
      requestType = com.google.cloud.iot.v1.GetDeviceRequest.class,
      responseType = com.google.cloud.iot.v1.Device.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iot.v1.GetDeviceRequest, com.google.cloud.iot.v1.Device>
      getGetDeviceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.iot.v1.GetDeviceRequest, com.google.cloud.iot.v1.Device>
        getGetDeviceMethod;
    if ((getGetDeviceMethod = DeviceManagerGrpc.getGetDeviceMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getGetDeviceMethod = DeviceManagerGrpc.getGetDeviceMethod) == null) {
          DeviceManagerGrpc.getGetDeviceMethod =
              getGetDeviceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iot.v1.GetDeviceRequest, com.google.cloud.iot.v1.Device>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDevice"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iot.v1.GetDeviceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iot.v1.Device.getDefaultInstance()))
                      .setSchemaDescriptor(new DeviceManagerMethodDescriptorSupplier("GetDevice"))
                      .build();
        }
      }
    }
    return getGetDeviceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iot.v1.UpdateDeviceRequest, com.google.cloud.iot.v1.Device>
      getUpdateDeviceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDevice",
      requestType = com.google.cloud.iot.v1.UpdateDeviceRequest.class,
      responseType = com.google.cloud.iot.v1.Device.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iot.v1.UpdateDeviceRequest, com.google.cloud.iot.v1.Device>
      getUpdateDeviceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.iot.v1.UpdateDeviceRequest, com.google.cloud.iot.v1.Device>
        getUpdateDeviceMethod;
    if ((getUpdateDeviceMethod = DeviceManagerGrpc.getUpdateDeviceMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getUpdateDeviceMethod = DeviceManagerGrpc.getUpdateDeviceMethod) == null) {
          DeviceManagerGrpc.getUpdateDeviceMethod =
              getUpdateDeviceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iot.v1.UpdateDeviceRequest, com.google.cloud.iot.v1.Device>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDevice"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iot.v1.UpdateDeviceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iot.v1.Device.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeviceManagerMethodDescriptorSupplier("UpdateDevice"))
                      .build();
        }
      }
    }
    return getUpdateDeviceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iot.v1.DeleteDeviceRequest, com.google.protobuf.Empty>
      getDeleteDeviceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDevice",
      requestType = com.google.cloud.iot.v1.DeleteDeviceRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iot.v1.DeleteDeviceRequest, com.google.protobuf.Empty>
      getDeleteDeviceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.iot.v1.DeleteDeviceRequest, com.google.protobuf.Empty>
        getDeleteDeviceMethod;
    if ((getDeleteDeviceMethod = DeviceManagerGrpc.getDeleteDeviceMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getDeleteDeviceMethod = DeviceManagerGrpc.getDeleteDeviceMethod) == null) {
          DeviceManagerGrpc.getDeleteDeviceMethod =
              getDeleteDeviceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iot.v1.DeleteDeviceRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDevice"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iot.v1.DeleteDeviceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeviceManagerMethodDescriptorSupplier("DeleteDevice"))
                      .build();
        }
      }
    }
    return getDeleteDeviceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iot.v1.ListDevicesRequest, com.google.cloud.iot.v1.ListDevicesResponse>
      getListDevicesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDevices",
      requestType = com.google.cloud.iot.v1.ListDevicesRequest.class,
      responseType = com.google.cloud.iot.v1.ListDevicesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iot.v1.ListDevicesRequest, com.google.cloud.iot.v1.ListDevicesResponse>
      getListDevicesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.iot.v1.ListDevicesRequest, com.google.cloud.iot.v1.ListDevicesResponse>
        getListDevicesMethod;
    if ((getListDevicesMethod = DeviceManagerGrpc.getListDevicesMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getListDevicesMethod = DeviceManagerGrpc.getListDevicesMethod) == null) {
          DeviceManagerGrpc.getListDevicesMethod =
              getListDevicesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iot.v1.ListDevicesRequest,
                          com.google.cloud.iot.v1.ListDevicesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDevices"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iot.v1.ListDevicesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iot.v1.ListDevicesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new DeviceManagerMethodDescriptorSupplier("ListDevices"))
                      .build();
        }
      }
    }
    return getListDevicesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iot.v1.ModifyCloudToDeviceConfigRequest,
          com.google.cloud.iot.v1.DeviceConfig>
      getModifyCloudToDeviceConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ModifyCloudToDeviceConfig",
      requestType = com.google.cloud.iot.v1.ModifyCloudToDeviceConfigRequest.class,
      responseType = com.google.cloud.iot.v1.DeviceConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iot.v1.ModifyCloudToDeviceConfigRequest,
          com.google.cloud.iot.v1.DeviceConfig>
      getModifyCloudToDeviceConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.iot.v1.ModifyCloudToDeviceConfigRequest,
            com.google.cloud.iot.v1.DeviceConfig>
        getModifyCloudToDeviceConfigMethod;
    if ((getModifyCloudToDeviceConfigMethod = DeviceManagerGrpc.getModifyCloudToDeviceConfigMethod)
        == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getModifyCloudToDeviceConfigMethod =
                DeviceManagerGrpc.getModifyCloudToDeviceConfigMethod)
            == null) {
          DeviceManagerGrpc.getModifyCloudToDeviceConfigMethod =
              getModifyCloudToDeviceConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iot.v1.ModifyCloudToDeviceConfigRequest,
                          com.google.cloud.iot.v1.DeviceConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ModifyCloudToDeviceConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iot.v1.ModifyCloudToDeviceConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iot.v1.DeviceConfig.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeviceManagerMethodDescriptorSupplier("ModifyCloudToDeviceConfig"))
                      .build();
        }
      }
    }
    return getModifyCloudToDeviceConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iot.v1.ListDeviceConfigVersionsRequest,
          com.google.cloud.iot.v1.ListDeviceConfigVersionsResponse>
      getListDeviceConfigVersionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDeviceConfigVersions",
      requestType = com.google.cloud.iot.v1.ListDeviceConfigVersionsRequest.class,
      responseType = com.google.cloud.iot.v1.ListDeviceConfigVersionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iot.v1.ListDeviceConfigVersionsRequest,
          com.google.cloud.iot.v1.ListDeviceConfigVersionsResponse>
      getListDeviceConfigVersionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.iot.v1.ListDeviceConfigVersionsRequest,
            com.google.cloud.iot.v1.ListDeviceConfigVersionsResponse>
        getListDeviceConfigVersionsMethod;
    if ((getListDeviceConfigVersionsMethod = DeviceManagerGrpc.getListDeviceConfigVersionsMethod)
        == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getListDeviceConfigVersionsMethod =
                DeviceManagerGrpc.getListDeviceConfigVersionsMethod)
            == null) {
          DeviceManagerGrpc.getListDeviceConfigVersionsMethod =
              getListDeviceConfigVersionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iot.v1.ListDeviceConfigVersionsRequest,
                          com.google.cloud.iot.v1.ListDeviceConfigVersionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListDeviceConfigVersions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iot.v1.ListDeviceConfigVersionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iot.v1.ListDeviceConfigVersionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeviceManagerMethodDescriptorSupplier("ListDeviceConfigVersions"))
                      .build();
        }
      }
    }
    return getListDeviceConfigVersionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iot.v1.ListDeviceStatesRequest,
          com.google.cloud.iot.v1.ListDeviceStatesResponse>
      getListDeviceStatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDeviceStates",
      requestType = com.google.cloud.iot.v1.ListDeviceStatesRequest.class,
      responseType = com.google.cloud.iot.v1.ListDeviceStatesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iot.v1.ListDeviceStatesRequest,
          com.google.cloud.iot.v1.ListDeviceStatesResponse>
      getListDeviceStatesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.iot.v1.ListDeviceStatesRequest,
            com.google.cloud.iot.v1.ListDeviceStatesResponse>
        getListDeviceStatesMethod;
    if ((getListDeviceStatesMethod = DeviceManagerGrpc.getListDeviceStatesMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getListDeviceStatesMethod = DeviceManagerGrpc.getListDeviceStatesMethod) == null) {
          DeviceManagerGrpc.getListDeviceStatesMethod =
              getListDeviceStatesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iot.v1.ListDeviceStatesRequest,
                          com.google.cloud.iot.v1.ListDeviceStatesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDeviceStates"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iot.v1.ListDeviceStatesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iot.v1.ListDeviceStatesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeviceManagerMethodDescriptorSupplier("ListDeviceStates"))
                      .build();
        }
      }
    }
    return getListDeviceStatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetIamPolicy",
      requestType = com.google.iam.v1.SetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
        getSetIamPolicyMethod;
    if ((getSetIamPolicyMethod = DeviceManagerGrpc.getSetIamPolicyMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getSetIamPolicyMethod = DeviceManagerGrpc.getSetIamPolicyMethod) == null) {
          DeviceManagerGrpc.getSetIamPolicyMethod =
              getSetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeviceManagerMethodDescriptorSupplier("SetIamPolicy"))
                      .build();
        }
      }
    }
    return getSetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIamPolicy",
      requestType = com.google.iam.v1.GetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
        getGetIamPolicyMethod;
    if ((getGetIamPolicyMethod = DeviceManagerGrpc.getGetIamPolicyMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getGetIamPolicyMethod = DeviceManagerGrpc.getGetIamPolicyMethod) == null) {
          DeviceManagerGrpc.getGetIamPolicyMethod =
              getGetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeviceManagerMethodDescriptorSupplier("GetIamPolicy"))
                      .build();
        }
      }
    }
    return getGetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestIamPermissions",
      requestType = com.google.iam.v1.TestIamPermissionsRequest.class,
      responseType = com.google.iam.v1.TestIamPermissionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v1.TestIamPermissionsRequest,
            com.google.iam.v1.TestIamPermissionsResponse>
        getTestIamPermissionsMethod;
    if ((getTestIamPermissionsMethod = DeviceManagerGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getTestIamPermissionsMethod = DeviceManagerGrpc.getTestIamPermissionsMethod) == null) {
          DeviceManagerGrpc.getTestIamPermissionsMethod =
              getTestIamPermissionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.TestIamPermissionsRequest,
                          com.google.iam.v1.TestIamPermissionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestIamPermissions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeviceManagerMethodDescriptorSupplier("TestIamPermissions"))
                      .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iot.v1.SendCommandToDeviceRequest,
          com.google.cloud.iot.v1.SendCommandToDeviceResponse>
      getSendCommandToDeviceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendCommandToDevice",
      requestType = com.google.cloud.iot.v1.SendCommandToDeviceRequest.class,
      responseType = com.google.cloud.iot.v1.SendCommandToDeviceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iot.v1.SendCommandToDeviceRequest,
          com.google.cloud.iot.v1.SendCommandToDeviceResponse>
      getSendCommandToDeviceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.iot.v1.SendCommandToDeviceRequest,
            com.google.cloud.iot.v1.SendCommandToDeviceResponse>
        getSendCommandToDeviceMethod;
    if ((getSendCommandToDeviceMethod = DeviceManagerGrpc.getSendCommandToDeviceMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getSendCommandToDeviceMethod = DeviceManagerGrpc.getSendCommandToDeviceMethod)
            == null) {
          DeviceManagerGrpc.getSendCommandToDeviceMethod =
              getSendCommandToDeviceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iot.v1.SendCommandToDeviceRequest,
                          com.google.cloud.iot.v1.SendCommandToDeviceResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SendCommandToDevice"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iot.v1.SendCommandToDeviceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iot.v1.SendCommandToDeviceResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeviceManagerMethodDescriptorSupplier("SendCommandToDevice"))
                      .build();
        }
      }
    }
    return getSendCommandToDeviceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iot.v1.BindDeviceToGatewayRequest,
          com.google.cloud.iot.v1.BindDeviceToGatewayResponse>
      getBindDeviceToGatewayMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BindDeviceToGateway",
      requestType = com.google.cloud.iot.v1.BindDeviceToGatewayRequest.class,
      responseType = com.google.cloud.iot.v1.BindDeviceToGatewayResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iot.v1.BindDeviceToGatewayRequest,
          com.google.cloud.iot.v1.BindDeviceToGatewayResponse>
      getBindDeviceToGatewayMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.iot.v1.BindDeviceToGatewayRequest,
            com.google.cloud.iot.v1.BindDeviceToGatewayResponse>
        getBindDeviceToGatewayMethod;
    if ((getBindDeviceToGatewayMethod = DeviceManagerGrpc.getBindDeviceToGatewayMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getBindDeviceToGatewayMethod = DeviceManagerGrpc.getBindDeviceToGatewayMethod)
            == null) {
          DeviceManagerGrpc.getBindDeviceToGatewayMethod =
              getBindDeviceToGatewayMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iot.v1.BindDeviceToGatewayRequest,
                          com.google.cloud.iot.v1.BindDeviceToGatewayResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BindDeviceToGateway"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iot.v1.BindDeviceToGatewayRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iot.v1.BindDeviceToGatewayResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeviceManagerMethodDescriptorSupplier("BindDeviceToGateway"))
                      .build();
        }
      }
    }
    return getBindDeviceToGatewayMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iot.v1.UnbindDeviceFromGatewayRequest,
          com.google.cloud.iot.v1.UnbindDeviceFromGatewayResponse>
      getUnbindDeviceFromGatewayMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UnbindDeviceFromGateway",
      requestType = com.google.cloud.iot.v1.UnbindDeviceFromGatewayRequest.class,
      responseType = com.google.cloud.iot.v1.UnbindDeviceFromGatewayResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iot.v1.UnbindDeviceFromGatewayRequest,
          com.google.cloud.iot.v1.UnbindDeviceFromGatewayResponse>
      getUnbindDeviceFromGatewayMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.iot.v1.UnbindDeviceFromGatewayRequest,
            com.google.cloud.iot.v1.UnbindDeviceFromGatewayResponse>
        getUnbindDeviceFromGatewayMethod;
    if ((getUnbindDeviceFromGatewayMethod = DeviceManagerGrpc.getUnbindDeviceFromGatewayMethod)
        == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getUnbindDeviceFromGatewayMethod = DeviceManagerGrpc.getUnbindDeviceFromGatewayMethod)
            == null) {
          DeviceManagerGrpc.getUnbindDeviceFromGatewayMethod =
              getUnbindDeviceFromGatewayMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iot.v1.UnbindDeviceFromGatewayRequest,
                          com.google.cloud.iot.v1.UnbindDeviceFromGatewayResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UnbindDeviceFromGateway"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iot.v1.UnbindDeviceFromGatewayRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iot.v1.UnbindDeviceFromGatewayResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeviceManagerMethodDescriptorSupplier("UnbindDeviceFromGateway"))
                      .build();
        }
      }
    }
    return getUnbindDeviceFromGatewayMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DeviceManagerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeviceManagerStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DeviceManagerStub>() {
          @java.lang.Override
          public DeviceManagerStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DeviceManagerStub(channel, callOptions);
          }
        };
    return DeviceManagerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DeviceManagerBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeviceManagerBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DeviceManagerBlockingStub>() {
          @java.lang.Override
          public DeviceManagerBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DeviceManagerBlockingStub(channel, callOptions);
          }
        };
    return DeviceManagerBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DeviceManagerFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeviceManagerFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DeviceManagerFutureStub>() {
          @java.lang.Override
          public DeviceManagerFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DeviceManagerFutureStub(channel, callOptions);
          }
        };
    return DeviceManagerFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Internet of Things (IoT) service. Securely connect and manage IoT devices.
   * </pre>
   */
  public abstract static class DeviceManagerImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a device registry that contains devices.
     * </pre>
     */
    public void createDeviceRegistry(
        com.google.cloud.iot.v1.CreateDeviceRegistryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.DeviceRegistry> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDeviceRegistryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a device registry configuration.
     * </pre>
     */
    public void getDeviceRegistry(
        com.google.cloud.iot.v1.GetDeviceRegistryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.DeviceRegistry> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDeviceRegistryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a device registry configuration.
     * </pre>
     */
    public void updateDeviceRegistry(
        com.google.cloud.iot.v1.UpdateDeviceRegistryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.DeviceRegistry> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDeviceRegistryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a device registry configuration.
     * </pre>
     */
    public void deleteDeviceRegistry(
        com.google.cloud.iot.v1.DeleteDeviceRegistryRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDeviceRegistryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists device registries.
     * </pre>
     */
    public void listDeviceRegistries(
        com.google.cloud.iot.v1.ListDeviceRegistriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.ListDeviceRegistriesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDeviceRegistriesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a device in a device registry.
     * </pre>
     */
    public void createDevice(
        com.google.cloud.iot.v1.CreateDeviceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.Device> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDeviceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a device.
     * </pre>
     */
    public void getDevice(
        com.google.cloud.iot.v1.GetDeviceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.Device> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDeviceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a device.
     * </pre>
     */
    public void updateDevice(
        com.google.cloud.iot.v1.UpdateDeviceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.Device> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDeviceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a device.
     * </pre>
     */
    public void deleteDevice(
        com.google.cloud.iot.v1.DeleteDeviceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDeviceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List devices in a device registry.
     * </pre>
     */
    public void listDevices(
        com.google.cloud.iot.v1.ListDevicesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.ListDevicesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDevicesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Modifies the configuration for the device, which is eventually sent from
     * the Cloud IoT Core servers. Returns the modified configuration version and
     * its metadata.
     * </pre>
     */
    public void modifyCloudToDeviceConfig(
        com.google.cloud.iot.v1.ModifyCloudToDeviceConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.DeviceConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getModifyCloudToDeviceConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the last few versions of the device configuration in descending
     * order (i.e.: newest first).
     * </pre>
     */
    public void listDeviceConfigVersions(
        com.google.cloud.iot.v1.ListDeviceConfigVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.ListDeviceConfigVersionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDeviceConfigVersionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the last few versions of the device state in descending order (i.e.:
     * newest first).
     * </pre>
     */
    public void listDeviceStates(
        com.google.cloud.iot.v1.ListDeviceStatesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.ListDeviceStatesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDeviceStatesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on the specified resource. Replaces any
     * existing policy.
     * </pre>
     */
    public void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a resource.
     * Returns an empty policy if the resource exists and does not have a policy
     * set.
     * </pre>
     */
    public void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that a caller has on the specified resource.
     * If the resource does not exist, this will return an empty set of
     * permissions, not a NOT_FOUND error.
     * </pre>
     */
    public void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getTestIamPermissionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sends a command to the specified device. In order for a device to be able
     * to receive commands, it must:
     * 1) be connected to Cloud IoT Core using the MQTT protocol, and
     * 2) be subscribed to the group of MQTT topics specified by
     *    /devices/{device-id}/commands/#. This subscription will receive commands
     *    at the top-level topic /devices/{device-id}/commands as well as commands
     *    for subfolders, like /devices/{device-id}/commands/subfolder.
     *    Note that subscribing to specific subfolders is not supported.
     * If the command could not be delivered to the device, this method will
     * return an error; in particular, if the device is not subscribed, this
     * method will return FAILED_PRECONDITION. Otherwise, this method will
     * return OK. If the subscription is QoS 1, at least once delivery will be
     * guaranteed; for QoS 0, no acknowledgment will be expected from the device.
     * </pre>
     */
    public void sendCommandToDevice(
        com.google.cloud.iot.v1.SendCommandToDeviceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.SendCommandToDeviceResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSendCommandToDeviceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Associates the device with the gateway.
     * </pre>
     */
    public void bindDeviceToGateway(
        com.google.cloud.iot.v1.BindDeviceToGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.BindDeviceToGatewayResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBindDeviceToGatewayMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the association between the device and the gateway.
     * </pre>
     */
    public void unbindDeviceFromGateway(
        com.google.cloud.iot.v1.UnbindDeviceFromGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.UnbindDeviceFromGatewayResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUnbindDeviceFromGatewayMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateDeviceRegistryMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.iot.v1.CreateDeviceRegistryRequest,
                      com.google.cloud.iot.v1.DeviceRegistry>(
                      this, METHODID_CREATE_DEVICE_REGISTRY)))
          .addMethod(
              getGetDeviceRegistryMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.iot.v1.GetDeviceRegistryRequest,
                      com.google.cloud.iot.v1.DeviceRegistry>(this, METHODID_GET_DEVICE_REGISTRY)))
          .addMethod(
              getUpdateDeviceRegistryMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.iot.v1.UpdateDeviceRegistryRequest,
                      com.google.cloud.iot.v1.DeviceRegistry>(
                      this, METHODID_UPDATE_DEVICE_REGISTRY)))
          .addMethod(
              getDeleteDeviceRegistryMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.iot.v1.DeleteDeviceRegistryRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_DEVICE_REGISTRY)))
          .addMethod(
              getListDeviceRegistriesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.iot.v1.ListDeviceRegistriesRequest,
                      com.google.cloud.iot.v1.ListDeviceRegistriesResponse>(
                      this, METHODID_LIST_DEVICE_REGISTRIES)))
          .addMethod(
              getCreateDeviceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.iot.v1.CreateDeviceRequest, com.google.cloud.iot.v1.Device>(
                      this, METHODID_CREATE_DEVICE)))
          .addMethod(
              getGetDeviceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.iot.v1.GetDeviceRequest, com.google.cloud.iot.v1.Device>(
                      this, METHODID_GET_DEVICE)))
          .addMethod(
              getUpdateDeviceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.iot.v1.UpdateDeviceRequest, com.google.cloud.iot.v1.Device>(
                      this, METHODID_UPDATE_DEVICE)))
          .addMethod(
              getDeleteDeviceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.iot.v1.DeleteDeviceRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_DEVICE)))
          .addMethod(
              getListDevicesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.iot.v1.ListDevicesRequest,
                      com.google.cloud.iot.v1.ListDevicesResponse>(this, METHODID_LIST_DEVICES)))
          .addMethod(
              getModifyCloudToDeviceConfigMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.iot.v1.ModifyCloudToDeviceConfigRequest,
                      com.google.cloud.iot.v1.DeviceConfig>(
                      this, METHODID_MODIFY_CLOUD_TO_DEVICE_CONFIG)))
          .addMethod(
              getListDeviceConfigVersionsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.iot.v1.ListDeviceConfigVersionsRequest,
                      com.google.cloud.iot.v1.ListDeviceConfigVersionsResponse>(
                      this, METHODID_LIST_DEVICE_CONFIG_VERSIONS)))
          .addMethod(
              getListDeviceStatesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.iot.v1.ListDeviceStatesRequest,
                      com.google.cloud.iot.v1.ListDeviceStatesResponse>(
                      this, METHODID_LIST_DEVICE_STATES)))
          .addMethod(
              getSetIamPolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>(
                      this, METHODID_SET_IAM_POLICY)))
          .addMethod(
              getGetIamPolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>(
                      this, METHODID_GET_IAM_POLICY)))
          .addMethod(
              getTestIamPermissionsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.TestIamPermissionsRequest,
                      com.google.iam.v1.TestIamPermissionsResponse>(
                      this, METHODID_TEST_IAM_PERMISSIONS)))
          .addMethod(
              getSendCommandToDeviceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.iot.v1.SendCommandToDeviceRequest,
                      com.google.cloud.iot.v1.SendCommandToDeviceResponse>(
                      this, METHODID_SEND_COMMAND_TO_DEVICE)))
          .addMethod(
              getBindDeviceToGatewayMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.iot.v1.BindDeviceToGatewayRequest,
                      com.google.cloud.iot.v1.BindDeviceToGatewayResponse>(
                      this, METHODID_BIND_DEVICE_TO_GATEWAY)))
          .addMethod(
              getUnbindDeviceFromGatewayMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.iot.v1.UnbindDeviceFromGatewayRequest,
                      com.google.cloud.iot.v1.UnbindDeviceFromGatewayResponse>(
                      this, METHODID_UNBIND_DEVICE_FROM_GATEWAY)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Internet of Things (IoT) service. Securely connect and manage IoT devices.
   * </pre>
   */
  public static final class DeviceManagerStub
      extends io.grpc.stub.AbstractAsyncStub<DeviceManagerStub> {
    private DeviceManagerStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeviceManagerStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeviceManagerStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a device registry that contains devices.
     * </pre>
     */
    public void createDeviceRegistry(
        com.google.cloud.iot.v1.CreateDeviceRegistryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.DeviceRegistry> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDeviceRegistryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a device registry configuration.
     * </pre>
     */
    public void getDeviceRegistry(
        com.google.cloud.iot.v1.GetDeviceRegistryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.DeviceRegistry> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDeviceRegistryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a device registry configuration.
     * </pre>
     */
    public void updateDeviceRegistry(
        com.google.cloud.iot.v1.UpdateDeviceRegistryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.DeviceRegistry> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDeviceRegistryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a device registry configuration.
     * </pre>
     */
    public void deleteDeviceRegistry(
        com.google.cloud.iot.v1.DeleteDeviceRegistryRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDeviceRegistryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists device registries.
     * </pre>
     */
    public void listDeviceRegistries(
        com.google.cloud.iot.v1.ListDeviceRegistriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.ListDeviceRegistriesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDeviceRegistriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a device in a device registry.
     * </pre>
     */
    public void createDevice(
        com.google.cloud.iot.v1.CreateDeviceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.Device> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDeviceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a device.
     * </pre>
     */
    public void getDevice(
        com.google.cloud.iot.v1.GetDeviceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.Device> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDeviceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a device.
     * </pre>
     */
    public void updateDevice(
        com.google.cloud.iot.v1.UpdateDeviceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.Device> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDeviceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a device.
     * </pre>
     */
    public void deleteDevice(
        com.google.cloud.iot.v1.DeleteDeviceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDeviceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List devices in a device registry.
     * </pre>
     */
    public void listDevices(
        com.google.cloud.iot.v1.ListDevicesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.ListDevicesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDevicesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Modifies the configuration for the device, which is eventually sent from
     * the Cloud IoT Core servers. Returns the modified configuration version and
     * its metadata.
     * </pre>
     */
    public void modifyCloudToDeviceConfig(
        com.google.cloud.iot.v1.ModifyCloudToDeviceConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.DeviceConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getModifyCloudToDeviceConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the last few versions of the device configuration in descending
     * order (i.e.: newest first).
     * </pre>
     */
    public void listDeviceConfigVersions(
        com.google.cloud.iot.v1.ListDeviceConfigVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.ListDeviceConfigVersionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDeviceConfigVersionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the last few versions of the device state in descending order (i.e.:
     * newest first).
     * </pre>
     */
    public void listDeviceStates(
        com.google.cloud.iot.v1.ListDeviceStatesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.ListDeviceStatesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDeviceStatesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on the specified resource. Replaces any
     * existing policy.
     * </pre>
     */
    public void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a resource.
     * Returns an empty policy if the resource exists and does not have a policy
     * set.
     * </pre>
     */
    public void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that a caller has on the specified resource.
     * If the resource does not exist, this will return an empty set of
     * permissions, not a NOT_FOUND error.
     * </pre>
     */
    public void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sends a command to the specified device. In order for a device to be able
     * to receive commands, it must:
     * 1) be connected to Cloud IoT Core using the MQTT protocol, and
     * 2) be subscribed to the group of MQTT topics specified by
     *    /devices/{device-id}/commands/#. This subscription will receive commands
     *    at the top-level topic /devices/{device-id}/commands as well as commands
     *    for subfolders, like /devices/{device-id}/commands/subfolder.
     *    Note that subscribing to specific subfolders is not supported.
     * If the command could not be delivered to the device, this method will
     * return an error; in particular, if the device is not subscribed, this
     * method will return FAILED_PRECONDITION. Otherwise, this method will
     * return OK. If the subscription is QoS 1, at least once delivery will be
     * guaranteed; for QoS 0, no acknowledgment will be expected from the device.
     * </pre>
     */
    public void sendCommandToDevice(
        com.google.cloud.iot.v1.SendCommandToDeviceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.SendCommandToDeviceResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendCommandToDeviceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Associates the device with the gateway.
     * </pre>
     */
    public void bindDeviceToGateway(
        com.google.cloud.iot.v1.BindDeviceToGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.BindDeviceToGatewayResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBindDeviceToGatewayMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the association between the device and the gateway.
     * </pre>
     */
    public void unbindDeviceFromGateway(
        com.google.cloud.iot.v1.UnbindDeviceFromGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.UnbindDeviceFromGatewayResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUnbindDeviceFromGatewayMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Internet of Things (IoT) service. Securely connect and manage IoT devices.
   * </pre>
   */
  public static final class DeviceManagerBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DeviceManagerBlockingStub> {
    private DeviceManagerBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeviceManagerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeviceManagerBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a device registry that contains devices.
     * </pre>
     */
    public com.google.cloud.iot.v1.DeviceRegistry createDeviceRegistry(
        com.google.cloud.iot.v1.CreateDeviceRegistryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDeviceRegistryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a device registry configuration.
     * </pre>
     */
    public com.google.cloud.iot.v1.DeviceRegistry getDeviceRegistry(
        com.google.cloud.iot.v1.GetDeviceRegistryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDeviceRegistryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a device registry configuration.
     * </pre>
     */
    public com.google.cloud.iot.v1.DeviceRegistry updateDeviceRegistry(
        com.google.cloud.iot.v1.UpdateDeviceRegistryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDeviceRegistryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a device registry configuration.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDeviceRegistry(
        com.google.cloud.iot.v1.DeleteDeviceRegistryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDeviceRegistryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists device registries.
     * </pre>
     */
    public com.google.cloud.iot.v1.ListDeviceRegistriesResponse listDeviceRegistries(
        com.google.cloud.iot.v1.ListDeviceRegistriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDeviceRegistriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a device in a device registry.
     * </pre>
     */
    public com.google.cloud.iot.v1.Device createDevice(
        com.google.cloud.iot.v1.CreateDeviceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDeviceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a device.
     * </pre>
     */
    public com.google.cloud.iot.v1.Device getDevice(
        com.google.cloud.iot.v1.GetDeviceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDeviceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a device.
     * </pre>
     */
    public com.google.cloud.iot.v1.Device updateDevice(
        com.google.cloud.iot.v1.UpdateDeviceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDeviceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a device.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDevice(
        com.google.cloud.iot.v1.DeleteDeviceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDeviceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List devices in a device registry.
     * </pre>
     */
    public com.google.cloud.iot.v1.ListDevicesResponse listDevices(
        com.google.cloud.iot.v1.ListDevicesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDevicesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Modifies the configuration for the device, which is eventually sent from
     * the Cloud IoT Core servers. Returns the modified configuration version and
     * its metadata.
     * </pre>
     */
    public com.google.cloud.iot.v1.DeviceConfig modifyCloudToDeviceConfig(
        com.google.cloud.iot.v1.ModifyCloudToDeviceConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getModifyCloudToDeviceConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the last few versions of the device configuration in descending
     * order (i.e.: newest first).
     * </pre>
     */
    public com.google.cloud.iot.v1.ListDeviceConfigVersionsResponse listDeviceConfigVersions(
        com.google.cloud.iot.v1.ListDeviceConfigVersionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDeviceConfigVersionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the last few versions of the device state in descending order (i.e.:
     * newest first).
     * </pre>
     */
    public com.google.cloud.iot.v1.ListDeviceStatesResponse listDeviceStates(
        com.google.cloud.iot.v1.ListDeviceStatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDeviceStatesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on the specified resource. Replaces any
     * existing policy.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a resource.
     * Returns an empty policy if the resource exists and does not have a policy
     * set.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that a caller has on the specified resource.
     * If the resource does not exist, this will return an empty set of
     * permissions, not a NOT_FOUND error.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sends a command to the specified device. In order for a device to be able
     * to receive commands, it must:
     * 1) be connected to Cloud IoT Core using the MQTT protocol, and
     * 2) be subscribed to the group of MQTT topics specified by
     *    /devices/{device-id}/commands/#. This subscription will receive commands
     *    at the top-level topic /devices/{device-id}/commands as well as commands
     *    for subfolders, like /devices/{device-id}/commands/subfolder.
     *    Note that subscribing to specific subfolders is not supported.
     * If the command could not be delivered to the device, this method will
     * return an error; in particular, if the device is not subscribed, this
     * method will return FAILED_PRECONDITION. Otherwise, this method will
     * return OK. If the subscription is QoS 1, at least once delivery will be
     * guaranteed; for QoS 0, no acknowledgment will be expected from the device.
     * </pre>
     */
    public com.google.cloud.iot.v1.SendCommandToDeviceResponse sendCommandToDevice(
        com.google.cloud.iot.v1.SendCommandToDeviceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendCommandToDeviceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Associates the device with the gateway.
     * </pre>
     */
    public com.google.cloud.iot.v1.BindDeviceToGatewayResponse bindDeviceToGateway(
        com.google.cloud.iot.v1.BindDeviceToGatewayRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBindDeviceToGatewayMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the association between the device and the gateway.
     * </pre>
     */
    public com.google.cloud.iot.v1.UnbindDeviceFromGatewayResponse unbindDeviceFromGateway(
        com.google.cloud.iot.v1.UnbindDeviceFromGatewayRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnbindDeviceFromGatewayMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Internet of Things (IoT) service. Securely connect and manage IoT devices.
   * </pre>
   */
  public static final class DeviceManagerFutureStub
      extends io.grpc.stub.AbstractFutureStub<DeviceManagerFutureStub> {
    private DeviceManagerFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeviceManagerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeviceManagerFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a device registry that contains devices.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.iot.v1.DeviceRegistry>
        createDeviceRegistry(com.google.cloud.iot.v1.CreateDeviceRegistryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDeviceRegistryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a device registry configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.iot.v1.DeviceRegistry>
        getDeviceRegistry(com.google.cloud.iot.v1.GetDeviceRegistryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDeviceRegistryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a device registry configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.iot.v1.DeviceRegistry>
        updateDeviceRegistry(com.google.cloud.iot.v1.UpdateDeviceRegistryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDeviceRegistryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a device registry configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteDeviceRegistry(com.google.cloud.iot.v1.DeleteDeviceRegistryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDeviceRegistryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists device registries.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.iot.v1.ListDeviceRegistriesResponse>
        listDeviceRegistries(com.google.cloud.iot.v1.ListDeviceRegistriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDeviceRegistriesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a device in a device registry.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.iot.v1.Device>
        createDevice(com.google.cloud.iot.v1.CreateDeviceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDeviceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a device.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.iot.v1.Device>
        getDevice(com.google.cloud.iot.v1.GetDeviceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDeviceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a device.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.iot.v1.Device>
        updateDevice(com.google.cloud.iot.v1.UpdateDeviceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDeviceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a device.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteDevice(com.google.cloud.iot.v1.DeleteDeviceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDeviceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List devices in a device registry.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.iot.v1.ListDevicesResponse>
        listDevices(com.google.cloud.iot.v1.ListDevicesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDevicesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Modifies the configuration for the device, which is eventually sent from
     * the Cloud IoT Core servers. Returns the modified configuration version and
     * its metadata.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.iot.v1.DeviceConfig>
        modifyCloudToDeviceConfig(
            com.google.cloud.iot.v1.ModifyCloudToDeviceConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getModifyCloudToDeviceConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the last few versions of the device configuration in descending
     * order (i.e.: newest first).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.iot.v1.ListDeviceConfigVersionsResponse>
        listDeviceConfigVersions(com.google.cloud.iot.v1.ListDeviceConfigVersionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDeviceConfigVersionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the last few versions of the device state in descending order (i.e.:
     * newest first).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.iot.v1.ListDeviceStatesResponse>
        listDeviceStates(com.google.cloud.iot.v1.ListDeviceStatesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDeviceStatesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on the specified resource. Replaces any
     * existing policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a resource.
     * Returns an empty policy if the resource exists and does not have a policy
     * set.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that a caller has on the specified resource.
     * If the resource does not exist, this will return an empty set of
     * permissions, not a NOT_FOUND error.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.iam.v1.TestIamPermissionsResponse>
        testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sends a command to the specified device. In order for a device to be able
     * to receive commands, it must:
     * 1) be connected to Cloud IoT Core using the MQTT protocol, and
     * 2) be subscribed to the group of MQTT topics specified by
     *    /devices/{device-id}/commands/#. This subscription will receive commands
     *    at the top-level topic /devices/{device-id}/commands as well as commands
     *    for subfolders, like /devices/{device-id}/commands/subfolder.
     *    Note that subscribing to specific subfolders is not supported.
     * If the command could not be delivered to the device, this method will
     * return an error; in particular, if the device is not subscribed, this
     * method will return FAILED_PRECONDITION. Otherwise, this method will
     * return OK. If the subscription is QoS 1, at least once delivery will be
     * guaranteed; for QoS 0, no acknowledgment will be expected from the device.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.iot.v1.SendCommandToDeviceResponse>
        sendCommandToDevice(com.google.cloud.iot.v1.SendCommandToDeviceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendCommandToDeviceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Associates the device with the gateway.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.iot.v1.BindDeviceToGatewayResponse>
        bindDeviceToGateway(com.google.cloud.iot.v1.BindDeviceToGatewayRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBindDeviceToGatewayMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the association between the device and the gateway.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.iot.v1.UnbindDeviceFromGatewayResponse>
        unbindDeviceFromGateway(com.google.cloud.iot.v1.UnbindDeviceFromGatewayRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUnbindDeviceFromGatewayMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_DEVICE_REGISTRY = 0;
  private static final int METHODID_GET_DEVICE_REGISTRY = 1;
  private static final int METHODID_UPDATE_DEVICE_REGISTRY = 2;
  private static final int METHODID_DELETE_DEVICE_REGISTRY = 3;
  private static final int METHODID_LIST_DEVICE_REGISTRIES = 4;
  private static final int METHODID_CREATE_DEVICE = 5;
  private static final int METHODID_GET_DEVICE = 6;
  private static final int METHODID_UPDATE_DEVICE = 7;
  private static final int METHODID_DELETE_DEVICE = 8;
  private static final int METHODID_LIST_DEVICES = 9;
  private static final int METHODID_MODIFY_CLOUD_TO_DEVICE_CONFIG = 10;
  private static final int METHODID_LIST_DEVICE_CONFIG_VERSIONS = 11;
  private static final int METHODID_LIST_DEVICE_STATES = 12;
  private static final int METHODID_SET_IAM_POLICY = 13;
  private static final int METHODID_GET_IAM_POLICY = 14;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 15;
  private static final int METHODID_SEND_COMMAND_TO_DEVICE = 16;
  private static final int METHODID_BIND_DEVICE_TO_GATEWAY = 17;
  private static final int METHODID_UNBIND_DEVICE_FROM_GATEWAY = 18;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DeviceManagerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DeviceManagerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_DEVICE_REGISTRY:
          serviceImpl.createDeviceRegistry(
              (com.google.cloud.iot.v1.CreateDeviceRegistryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.DeviceRegistry>)
                  responseObserver);
          break;
        case METHODID_GET_DEVICE_REGISTRY:
          serviceImpl.getDeviceRegistry(
              (com.google.cloud.iot.v1.GetDeviceRegistryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.DeviceRegistry>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DEVICE_REGISTRY:
          serviceImpl.updateDeviceRegistry(
              (com.google.cloud.iot.v1.UpdateDeviceRegistryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.DeviceRegistry>)
                  responseObserver);
          break;
        case METHODID_DELETE_DEVICE_REGISTRY:
          serviceImpl.deleteDeviceRegistry(
              (com.google.cloud.iot.v1.DeleteDeviceRegistryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_DEVICE_REGISTRIES:
          serviceImpl.listDeviceRegistries(
              (com.google.cloud.iot.v1.ListDeviceRegistriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.ListDeviceRegistriesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_DEVICE:
          serviceImpl.createDevice(
              (com.google.cloud.iot.v1.CreateDeviceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.Device>) responseObserver);
          break;
        case METHODID_GET_DEVICE:
          serviceImpl.getDevice(
              (com.google.cloud.iot.v1.GetDeviceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.Device>) responseObserver);
          break;
        case METHODID_UPDATE_DEVICE:
          serviceImpl.updateDevice(
              (com.google.cloud.iot.v1.UpdateDeviceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.Device>) responseObserver);
          break;
        case METHODID_DELETE_DEVICE:
          serviceImpl.deleteDevice(
              (com.google.cloud.iot.v1.DeleteDeviceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_DEVICES:
          serviceImpl.listDevices(
              (com.google.cloud.iot.v1.ListDevicesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.ListDevicesResponse>)
                  responseObserver);
          break;
        case METHODID_MODIFY_CLOUD_TO_DEVICE_CONFIG:
          serviceImpl.modifyCloudToDeviceConfig(
              (com.google.cloud.iot.v1.ModifyCloudToDeviceConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.DeviceConfig>) responseObserver);
          break;
        case METHODID_LIST_DEVICE_CONFIG_VERSIONS:
          serviceImpl.listDeviceConfigVersions(
              (com.google.cloud.iot.v1.ListDeviceConfigVersionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.iot.v1.ListDeviceConfigVersionsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_DEVICE_STATES:
          serviceImpl.listDeviceStates(
              (com.google.cloud.iot.v1.ListDeviceStatesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.ListDeviceStatesResponse>)
                  responseObserver);
          break;
        case METHODID_SET_IAM_POLICY:
          serviceImpl.setIamPolicy(
              (com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy(
              (com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS:
          serviceImpl.testIamPermissions(
              (com.google.iam.v1.TestIamPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>)
                  responseObserver);
          break;
        case METHODID_SEND_COMMAND_TO_DEVICE:
          serviceImpl.sendCommandToDevice(
              (com.google.cloud.iot.v1.SendCommandToDeviceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.SendCommandToDeviceResponse>)
                  responseObserver);
          break;
        case METHODID_BIND_DEVICE_TO_GATEWAY:
          serviceImpl.bindDeviceToGateway(
              (com.google.cloud.iot.v1.BindDeviceToGatewayRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.BindDeviceToGatewayResponse>)
                  responseObserver);
          break;
        case METHODID_UNBIND_DEVICE_FROM_GATEWAY:
          serviceImpl.unbindDeviceFromGateway(
              (com.google.cloud.iot.v1.UnbindDeviceFromGatewayRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.UnbindDeviceFromGatewayResponse>)
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

  private abstract static class DeviceManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DeviceManagerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.iot.v1.DeviceManagerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DeviceManager");
    }
  }

  private static final class DeviceManagerFileDescriptorSupplier
      extends DeviceManagerBaseDescriptorSupplier {
    DeviceManagerFileDescriptorSupplier() {}
  }

  private static final class DeviceManagerMethodDescriptorSupplier
      extends DeviceManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DeviceManagerMethodDescriptorSupplier(String methodName) {
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
      synchronized (DeviceManagerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DeviceManagerFileDescriptorSupplier())
                      .addMethod(getCreateDeviceRegistryMethod())
                      .addMethod(getGetDeviceRegistryMethod())
                      .addMethod(getUpdateDeviceRegistryMethod())
                      .addMethod(getDeleteDeviceRegistryMethod())
                      .addMethod(getListDeviceRegistriesMethod())
                      .addMethod(getCreateDeviceMethod())
                      .addMethod(getGetDeviceMethod())
                      .addMethod(getUpdateDeviceMethod())
                      .addMethod(getDeleteDeviceMethod())
                      .addMethod(getListDevicesMethod())
                      .addMethod(getModifyCloudToDeviceConfigMethod())
                      .addMethod(getListDeviceConfigVersionsMethod())
                      .addMethod(getListDeviceStatesMethod())
                      .addMethod(getSetIamPolicyMethod())
                      .addMethod(getGetIamPolicyMethod())
                      .addMethod(getTestIamPermissionsMethod())
                      .addMethod(getSendCommandToDeviceMethod())
                      .addMethod(getBindDeviceToGatewayMethod())
                      .addMethod(getUnbindDeviceFromGatewayMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
