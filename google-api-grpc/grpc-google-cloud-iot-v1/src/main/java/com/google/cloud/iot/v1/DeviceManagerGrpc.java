package com.google.cloud.iot.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Internet of Things (IoT) service. Securely connect and manage IoT devices.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/iot/v1/device_manager.proto")
public final class DeviceManagerGrpc {

  private DeviceManagerGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.iot.v1.DeviceManager";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateDeviceRegistryMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.iot.v1.CreateDeviceRegistryRequest,
      com.google.cloud.iot.v1.DeviceRegistry> METHOD_CREATE_DEVICE_REGISTRY = getCreateDeviceRegistryMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.iot.v1.CreateDeviceRegistryRequest,
      com.google.cloud.iot.v1.DeviceRegistry> getCreateDeviceRegistryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.iot.v1.CreateDeviceRegistryRequest,
      com.google.cloud.iot.v1.DeviceRegistry> getCreateDeviceRegistryMethod() {
    return getCreateDeviceRegistryMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.iot.v1.CreateDeviceRegistryRequest,
      com.google.cloud.iot.v1.DeviceRegistry> getCreateDeviceRegistryMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.iot.v1.CreateDeviceRegistryRequest, com.google.cloud.iot.v1.DeviceRegistry> getCreateDeviceRegistryMethod;
    if ((getCreateDeviceRegistryMethod = DeviceManagerGrpc.getCreateDeviceRegistryMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getCreateDeviceRegistryMethod = DeviceManagerGrpc.getCreateDeviceRegistryMethod) == null) {
          DeviceManagerGrpc.getCreateDeviceRegistryMethod = getCreateDeviceRegistryMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.iot.v1.CreateDeviceRegistryRequest, com.google.cloud.iot.v1.DeviceRegistry>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.iot.v1.DeviceManager", "CreateDeviceRegistry"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iot.v1.CreateDeviceRegistryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iot.v1.DeviceRegistry.getDefaultInstance()))
                  .setSchemaDescriptor(new DeviceManagerMethodDescriptorSupplier("CreateDeviceRegistry"))
                  .build();
          }
        }
     }
     return getCreateDeviceRegistryMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetDeviceRegistryMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.iot.v1.GetDeviceRegistryRequest,
      com.google.cloud.iot.v1.DeviceRegistry> METHOD_GET_DEVICE_REGISTRY = getGetDeviceRegistryMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.iot.v1.GetDeviceRegistryRequest,
      com.google.cloud.iot.v1.DeviceRegistry> getGetDeviceRegistryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.iot.v1.GetDeviceRegistryRequest,
      com.google.cloud.iot.v1.DeviceRegistry> getGetDeviceRegistryMethod() {
    return getGetDeviceRegistryMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.iot.v1.GetDeviceRegistryRequest,
      com.google.cloud.iot.v1.DeviceRegistry> getGetDeviceRegistryMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.iot.v1.GetDeviceRegistryRequest, com.google.cloud.iot.v1.DeviceRegistry> getGetDeviceRegistryMethod;
    if ((getGetDeviceRegistryMethod = DeviceManagerGrpc.getGetDeviceRegistryMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getGetDeviceRegistryMethod = DeviceManagerGrpc.getGetDeviceRegistryMethod) == null) {
          DeviceManagerGrpc.getGetDeviceRegistryMethod = getGetDeviceRegistryMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.iot.v1.GetDeviceRegistryRequest, com.google.cloud.iot.v1.DeviceRegistry>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.iot.v1.DeviceManager", "GetDeviceRegistry"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iot.v1.GetDeviceRegistryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iot.v1.DeviceRegistry.getDefaultInstance()))
                  .setSchemaDescriptor(new DeviceManagerMethodDescriptorSupplier("GetDeviceRegistry"))
                  .build();
          }
        }
     }
     return getGetDeviceRegistryMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateDeviceRegistryMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.iot.v1.UpdateDeviceRegistryRequest,
      com.google.cloud.iot.v1.DeviceRegistry> METHOD_UPDATE_DEVICE_REGISTRY = getUpdateDeviceRegistryMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.iot.v1.UpdateDeviceRegistryRequest,
      com.google.cloud.iot.v1.DeviceRegistry> getUpdateDeviceRegistryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.iot.v1.UpdateDeviceRegistryRequest,
      com.google.cloud.iot.v1.DeviceRegistry> getUpdateDeviceRegistryMethod() {
    return getUpdateDeviceRegistryMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.iot.v1.UpdateDeviceRegistryRequest,
      com.google.cloud.iot.v1.DeviceRegistry> getUpdateDeviceRegistryMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.iot.v1.UpdateDeviceRegistryRequest, com.google.cloud.iot.v1.DeviceRegistry> getUpdateDeviceRegistryMethod;
    if ((getUpdateDeviceRegistryMethod = DeviceManagerGrpc.getUpdateDeviceRegistryMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getUpdateDeviceRegistryMethod = DeviceManagerGrpc.getUpdateDeviceRegistryMethod) == null) {
          DeviceManagerGrpc.getUpdateDeviceRegistryMethod = getUpdateDeviceRegistryMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.iot.v1.UpdateDeviceRegistryRequest, com.google.cloud.iot.v1.DeviceRegistry>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.iot.v1.DeviceManager", "UpdateDeviceRegistry"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iot.v1.UpdateDeviceRegistryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iot.v1.DeviceRegistry.getDefaultInstance()))
                  .setSchemaDescriptor(new DeviceManagerMethodDescriptorSupplier("UpdateDeviceRegistry"))
                  .build();
          }
        }
     }
     return getUpdateDeviceRegistryMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteDeviceRegistryMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.iot.v1.DeleteDeviceRegistryRequest,
      com.google.protobuf.Empty> METHOD_DELETE_DEVICE_REGISTRY = getDeleteDeviceRegistryMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.iot.v1.DeleteDeviceRegistryRequest,
      com.google.protobuf.Empty> getDeleteDeviceRegistryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.iot.v1.DeleteDeviceRegistryRequest,
      com.google.protobuf.Empty> getDeleteDeviceRegistryMethod() {
    return getDeleteDeviceRegistryMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.iot.v1.DeleteDeviceRegistryRequest,
      com.google.protobuf.Empty> getDeleteDeviceRegistryMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.iot.v1.DeleteDeviceRegistryRequest, com.google.protobuf.Empty> getDeleteDeviceRegistryMethod;
    if ((getDeleteDeviceRegistryMethod = DeviceManagerGrpc.getDeleteDeviceRegistryMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getDeleteDeviceRegistryMethod = DeviceManagerGrpc.getDeleteDeviceRegistryMethod) == null) {
          DeviceManagerGrpc.getDeleteDeviceRegistryMethod = getDeleteDeviceRegistryMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.iot.v1.DeleteDeviceRegistryRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.iot.v1.DeviceManager", "DeleteDeviceRegistry"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iot.v1.DeleteDeviceRegistryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new DeviceManagerMethodDescriptorSupplier("DeleteDeviceRegistry"))
                  .build();
          }
        }
     }
     return getDeleteDeviceRegistryMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListDeviceRegistriesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.iot.v1.ListDeviceRegistriesRequest,
      com.google.cloud.iot.v1.ListDeviceRegistriesResponse> METHOD_LIST_DEVICE_REGISTRIES = getListDeviceRegistriesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.iot.v1.ListDeviceRegistriesRequest,
      com.google.cloud.iot.v1.ListDeviceRegistriesResponse> getListDeviceRegistriesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.iot.v1.ListDeviceRegistriesRequest,
      com.google.cloud.iot.v1.ListDeviceRegistriesResponse> getListDeviceRegistriesMethod() {
    return getListDeviceRegistriesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.iot.v1.ListDeviceRegistriesRequest,
      com.google.cloud.iot.v1.ListDeviceRegistriesResponse> getListDeviceRegistriesMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.iot.v1.ListDeviceRegistriesRequest, com.google.cloud.iot.v1.ListDeviceRegistriesResponse> getListDeviceRegistriesMethod;
    if ((getListDeviceRegistriesMethod = DeviceManagerGrpc.getListDeviceRegistriesMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getListDeviceRegistriesMethod = DeviceManagerGrpc.getListDeviceRegistriesMethod) == null) {
          DeviceManagerGrpc.getListDeviceRegistriesMethod = getListDeviceRegistriesMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.iot.v1.ListDeviceRegistriesRequest, com.google.cloud.iot.v1.ListDeviceRegistriesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.iot.v1.DeviceManager", "ListDeviceRegistries"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iot.v1.ListDeviceRegistriesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iot.v1.ListDeviceRegistriesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DeviceManagerMethodDescriptorSupplier("ListDeviceRegistries"))
                  .build();
          }
        }
     }
     return getListDeviceRegistriesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateDeviceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.iot.v1.CreateDeviceRequest,
      com.google.cloud.iot.v1.Device> METHOD_CREATE_DEVICE = getCreateDeviceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.iot.v1.CreateDeviceRequest,
      com.google.cloud.iot.v1.Device> getCreateDeviceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.iot.v1.CreateDeviceRequest,
      com.google.cloud.iot.v1.Device> getCreateDeviceMethod() {
    return getCreateDeviceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.iot.v1.CreateDeviceRequest,
      com.google.cloud.iot.v1.Device> getCreateDeviceMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.iot.v1.CreateDeviceRequest, com.google.cloud.iot.v1.Device> getCreateDeviceMethod;
    if ((getCreateDeviceMethod = DeviceManagerGrpc.getCreateDeviceMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getCreateDeviceMethod = DeviceManagerGrpc.getCreateDeviceMethod) == null) {
          DeviceManagerGrpc.getCreateDeviceMethod = getCreateDeviceMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.iot.v1.CreateDeviceRequest, com.google.cloud.iot.v1.Device>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.iot.v1.DeviceManager", "CreateDevice"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iot.v1.CreateDeviceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iot.v1.Device.getDefaultInstance()))
                  .setSchemaDescriptor(new DeviceManagerMethodDescriptorSupplier("CreateDevice"))
                  .build();
          }
        }
     }
     return getCreateDeviceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetDeviceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.iot.v1.GetDeviceRequest,
      com.google.cloud.iot.v1.Device> METHOD_GET_DEVICE = getGetDeviceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.iot.v1.GetDeviceRequest,
      com.google.cloud.iot.v1.Device> getGetDeviceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.iot.v1.GetDeviceRequest,
      com.google.cloud.iot.v1.Device> getGetDeviceMethod() {
    return getGetDeviceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.iot.v1.GetDeviceRequest,
      com.google.cloud.iot.v1.Device> getGetDeviceMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.iot.v1.GetDeviceRequest, com.google.cloud.iot.v1.Device> getGetDeviceMethod;
    if ((getGetDeviceMethod = DeviceManagerGrpc.getGetDeviceMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getGetDeviceMethod = DeviceManagerGrpc.getGetDeviceMethod) == null) {
          DeviceManagerGrpc.getGetDeviceMethod = getGetDeviceMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.iot.v1.GetDeviceRequest, com.google.cloud.iot.v1.Device>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.iot.v1.DeviceManager", "GetDevice"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iot.v1.GetDeviceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iot.v1.Device.getDefaultInstance()))
                  .setSchemaDescriptor(new DeviceManagerMethodDescriptorSupplier("GetDevice"))
                  .build();
          }
        }
     }
     return getGetDeviceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateDeviceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.iot.v1.UpdateDeviceRequest,
      com.google.cloud.iot.v1.Device> METHOD_UPDATE_DEVICE = getUpdateDeviceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.iot.v1.UpdateDeviceRequest,
      com.google.cloud.iot.v1.Device> getUpdateDeviceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.iot.v1.UpdateDeviceRequest,
      com.google.cloud.iot.v1.Device> getUpdateDeviceMethod() {
    return getUpdateDeviceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.iot.v1.UpdateDeviceRequest,
      com.google.cloud.iot.v1.Device> getUpdateDeviceMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.iot.v1.UpdateDeviceRequest, com.google.cloud.iot.v1.Device> getUpdateDeviceMethod;
    if ((getUpdateDeviceMethod = DeviceManagerGrpc.getUpdateDeviceMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getUpdateDeviceMethod = DeviceManagerGrpc.getUpdateDeviceMethod) == null) {
          DeviceManagerGrpc.getUpdateDeviceMethod = getUpdateDeviceMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.iot.v1.UpdateDeviceRequest, com.google.cloud.iot.v1.Device>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.iot.v1.DeviceManager", "UpdateDevice"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iot.v1.UpdateDeviceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iot.v1.Device.getDefaultInstance()))
                  .setSchemaDescriptor(new DeviceManagerMethodDescriptorSupplier("UpdateDevice"))
                  .build();
          }
        }
     }
     return getUpdateDeviceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteDeviceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.iot.v1.DeleteDeviceRequest,
      com.google.protobuf.Empty> METHOD_DELETE_DEVICE = getDeleteDeviceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.iot.v1.DeleteDeviceRequest,
      com.google.protobuf.Empty> getDeleteDeviceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.iot.v1.DeleteDeviceRequest,
      com.google.protobuf.Empty> getDeleteDeviceMethod() {
    return getDeleteDeviceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.iot.v1.DeleteDeviceRequest,
      com.google.protobuf.Empty> getDeleteDeviceMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.iot.v1.DeleteDeviceRequest, com.google.protobuf.Empty> getDeleteDeviceMethod;
    if ((getDeleteDeviceMethod = DeviceManagerGrpc.getDeleteDeviceMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getDeleteDeviceMethod = DeviceManagerGrpc.getDeleteDeviceMethod) == null) {
          DeviceManagerGrpc.getDeleteDeviceMethod = getDeleteDeviceMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.iot.v1.DeleteDeviceRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.iot.v1.DeviceManager", "DeleteDevice"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iot.v1.DeleteDeviceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new DeviceManagerMethodDescriptorSupplier("DeleteDevice"))
                  .build();
          }
        }
     }
     return getDeleteDeviceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListDevicesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.iot.v1.ListDevicesRequest,
      com.google.cloud.iot.v1.ListDevicesResponse> METHOD_LIST_DEVICES = getListDevicesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.iot.v1.ListDevicesRequest,
      com.google.cloud.iot.v1.ListDevicesResponse> getListDevicesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.iot.v1.ListDevicesRequest,
      com.google.cloud.iot.v1.ListDevicesResponse> getListDevicesMethod() {
    return getListDevicesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.iot.v1.ListDevicesRequest,
      com.google.cloud.iot.v1.ListDevicesResponse> getListDevicesMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.iot.v1.ListDevicesRequest, com.google.cloud.iot.v1.ListDevicesResponse> getListDevicesMethod;
    if ((getListDevicesMethod = DeviceManagerGrpc.getListDevicesMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getListDevicesMethod = DeviceManagerGrpc.getListDevicesMethod) == null) {
          DeviceManagerGrpc.getListDevicesMethod = getListDevicesMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.iot.v1.ListDevicesRequest, com.google.cloud.iot.v1.ListDevicesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.iot.v1.DeviceManager", "ListDevices"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iot.v1.ListDevicesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iot.v1.ListDevicesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DeviceManagerMethodDescriptorSupplier("ListDevices"))
                  .build();
          }
        }
     }
     return getListDevicesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getModifyCloudToDeviceConfigMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.iot.v1.ModifyCloudToDeviceConfigRequest,
      com.google.cloud.iot.v1.DeviceConfig> METHOD_MODIFY_CLOUD_TO_DEVICE_CONFIG = getModifyCloudToDeviceConfigMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.iot.v1.ModifyCloudToDeviceConfigRequest,
      com.google.cloud.iot.v1.DeviceConfig> getModifyCloudToDeviceConfigMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.iot.v1.ModifyCloudToDeviceConfigRequest,
      com.google.cloud.iot.v1.DeviceConfig> getModifyCloudToDeviceConfigMethod() {
    return getModifyCloudToDeviceConfigMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.iot.v1.ModifyCloudToDeviceConfigRequest,
      com.google.cloud.iot.v1.DeviceConfig> getModifyCloudToDeviceConfigMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.iot.v1.ModifyCloudToDeviceConfigRequest, com.google.cloud.iot.v1.DeviceConfig> getModifyCloudToDeviceConfigMethod;
    if ((getModifyCloudToDeviceConfigMethod = DeviceManagerGrpc.getModifyCloudToDeviceConfigMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getModifyCloudToDeviceConfigMethod = DeviceManagerGrpc.getModifyCloudToDeviceConfigMethod) == null) {
          DeviceManagerGrpc.getModifyCloudToDeviceConfigMethod = getModifyCloudToDeviceConfigMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.iot.v1.ModifyCloudToDeviceConfigRequest, com.google.cloud.iot.v1.DeviceConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.iot.v1.DeviceManager", "ModifyCloudToDeviceConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iot.v1.ModifyCloudToDeviceConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iot.v1.DeviceConfig.getDefaultInstance()))
                  .setSchemaDescriptor(new DeviceManagerMethodDescriptorSupplier("ModifyCloudToDeviceConfig"))
                  .build();
          }
        }
     }
     return getModifyCloudToDeviceConfigMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListDeviceConfigVersionsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.iot.v1.ListDeviceConfigVersionsRequest,
      com.google.cloud.iot.v1.ListDeviceConfigVersionsResponse> METHOD_LIST_DEVICE_CONFIG_VERSIONS = getListDeviceConfigVersionsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.iot.v1.ListDeviceConfigVersionsRequest,
      com.google.cloud.iot.v1.ListDeviceConfigVersionsResponse> getListDeviceConfigVersionsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.iot.v1.ListDeviceConfigVersionsRequest,
      com.google.cloud.iot.v1.ListDeviceConfigVersionsResponse> getListDeviceConfigVersionsMethod() {
    return getListDeviceConfigVersionsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.iot.v1.ListDeviceConfigVersionsRequest,
      com.google.cloud.iot.v1.ListDeviceConfigVersionsResponse> getListDeviceConfigVersionsMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.iot.v1.ListDeviceConfigVersionsRequest, com.google.cloud.iot.v1.ListDeviceConfigVersionsResponse> getListDeviceConfigVersionsMethod;
    if ((getListDeviceConfigVersionsMethod = DeviceManagerGrpc.getListDeviceConfigVersionsMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getListDeviceConfigVersionsMethod = DeviceManagerGrpc.getListDeviceConfigVersionsMethod) == null) {
          DeviceManagerGrpc.getListDeviceConfigVersionsMethod = getListDeviceConfigVersionsMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.iot.v1.ListDeviceConfigVersionsRequest, com.google.cloud.iot.v1.ListDeviceConfigVersionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.iot.v1.DeviceManager", "ListDeviceConfigVersions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iot.v1.ListDeviceConfigVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iot.v1.ListDeviceConfigVersionsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DeviceManagerMethodDescriptorSupplier("ListDeviceConfigVersions"))
                  .build();
          }
        }
     }
     return getListDeviceConfigVersionsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListDeviceStatesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.iot.v1.ListDeviceStatesRequest,
      com.google.cloud.iot.v1.ListDeviceStatesResponse> METHOD_LIST_DEVICE_STATES = getListDeviceStatesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.iot.v1.ListDeviceStatesRequest,
      com.google.cloud.iot.v1.ListDeviceStatesResponse> getListDeviceStatesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.iot.v1.ListDeviceStatesRequest,
      com.google.cloud.iot.v1.ListDeviceStatesResponse> getListDeviceStatesMethod() {
    return getListDeviceStatesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.iot.v1.ListDeviceStatesRequest,
      com.google.cloud.iot.v1.ListDeviceStatesResponse> getListDeviceStatesMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.iot.v1.ListDeviceStatesRequest, com.google.cloud.iot.v1.ListDeviceStatesResponse> getListDeviceStatesMethod;
    if ((getListDeviceStatesMethod = DeviceManagerGrpc.getListDeviceStatesMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getListDeviceStatesMethod = DeviceManagerGrpc.getListDeviceStatesMethod) == null) {
          DeviceManagerGrpc.getListDeviceStatesMethod = getListDeviceStatesMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.iot.v1.ListDeviceStatesRequest, com.google.cloud.iot.v1.ListDeviceStatesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.iot.v1.DeviceManager", "ListDeviceStates"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iot.v1.ListDeviceStatesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iot.v1.ListDeviceStatesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DeviceManagerMethodDescriptorSupplier("ListDeviceStates"))
                  .build();
          }
        }
     }
     return getListDeviceStatesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSetIamPolicyMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> METHOD_SET_IAM_POLICY = getSetIamPolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> getSetIamPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> getSetIamPolicyMethod() {
    return getSetIamPolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> getSetIamPolicyMethodHelper() {
    io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy> getSetIamPolicyMethod;
    if ((getSetIamPolicyMethod = DeviceManagerGrpc.getSetIamPolicyMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getSetIamPolicyMethod = DeviceManagerGrpc.getSetIamPolicyMethod) == null) {
          DeviceManagerGrpc.getSetIamPolicyMethod = getSetIamPolicyMethod = 
              io.grpc.MethodDescriptor.<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.iot.v1.DeviceManager", "SetIamPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.Policy.getDefaultInstance()))
                  .setSchemaDescriptor(new DeviceManagerMethodDescriptorSupplier("SetIamPolicy"))
                  .build();
          }
        }
     }
     return getSetIamPolicyMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetIamPolicyMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> METHOD_GET_IAM_POLICY = getGetIamPolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> getGetIamPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> getGetIamPolicyMethod() {
    return getGetIamPolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> getGetIamPolicyMethodHelper() {
    io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy> getGetIamPolicyMethod;
    if ((getGetIamPolicyMethod = DeviceManagerGrpc.getGetIamPolicyMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getGetIamPolicyMethod = DeviceManagerGrpc.getGetIamPolicyMethod) == null) {
          DeviceManagerGrpc.getGetIamPolicyMethod = getGetIamPolicyMethod = 
              io.grpc.MethodDescriptor.<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.iot.v1.DeviceManager", "GetIamPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.Policy.getDefaultInstance()))
                  .setSchemaDescriptor(new DeviceManagerMethodDescriptorSupplier("GetIamPolicy"))
                  .build();
          }
        }
     }
     return getGetIamPolicyMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getTestIamPermissionsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> METHOD_TEST_IAM_PERMISSIONS = getTestIamPermissionsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod() {
    return getTestIamPermissionsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethodHelper() {
    io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod;
    if ((getTestIamPermissionsMethod = DeviceManagerGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getTestIamPermissionsMethod = DeviceManagerGrpc.getTestIamPermissionsMethod) == null) {
          DeviceManagerGrpc.getTestIamPermissionsMethod = getTestIamPermissionsMethod = 
              io.grpc.MethodDescriptor.<com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.iot.v1.DeviceManager", "TestIamPermissions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DeviceManagerMethodDescriptorSupplier("TestIamPermissions"))
                  .build();
          }
        }
     }
     return getTestIamPermissionsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSendCommandToDeviceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.iot.v1.SendCommandToDeviceRequest,
      com.google.cloud.iot.v1.SendCommandToDeviceResponse> METHOD_SEND_COMMAND_TO_DEVICE = getSendCommandToDeviceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.iot.v1.SendCommandToDeviceRequest,
      com.google.cloud.iot.v1.SendCommandToDeviceResponse> getSendCommandToDeviceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.iot.v1.SendCommandToDeviceRequest,
      com.google.cloud.iot.v1.SendCommandToDeviceResponse> getSendCommandToDeviceMethod() {
    return getSendCommandToDeviceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.iot.v1.SendCommandToDeviceRequest,
      com.google.cloud.iot.v1.SendCommandToDeviceResponse> getSendCommandToDeviceMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.iot.v1.SendCommandToDeviceRequest, com.google.cloud.iot.v1.SendCommandToDeviceResponse> getSendCommandToDeviceMethod;
    if ((getSendCommandToDeviceMethod = DeviceManagerGrpc.getSendCommandToDeviceMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getSendCommandToDeviceMethod = DeviceManagerGrpc.getSendCommandToDeviceMethod) == null) {
          DeviceManagerGrpc.getSendCommandToDeviceMethod = getSendCommandToDeviceMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.iot.v1.SendCommandToDeviceRequest, com.google.cloud.iot.v1.SendCommandToDeviceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.iot.v1.DeviceManager", "SendCommandToDevice"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iot.v1.SendCommandToDeviceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iot.v1.SendCommandToDeviceResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DeviceManagerMethodDescriptorSupplier("SendCommandToDevice"))
                  .build();
          }
        }
     }
     return getSendCommandToDeviceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBindDeviceToGatewayMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.iot.v1.BindDeviceToGatewayRequest,
      com.google.cloud.iot.v1.BindDeviceToGatewayResponse> METHOD_BIND_DEVICE_TO_GATEWAY = getBindDeviceToGatewayMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.iot.v1.BindDeviceToGatewayRequest,
      com.google.cloud.iot.v1.BindDeviceToGatewayResponse> getBindDeviceToGatewayMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.iot.v1.BindDeviceToGatewayRequest,
      com.google.cloud.iot.v1.BindDeviceToGatewayResponse> getBindDeviceToGatewayMethod() {
    return getBindDeviceToGatewayMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.iot.v1.BindDeviceToGatewayRequest,
      com.google.cloud.iot.v1.BindDeviceToGatewayResponse> getBindDeviceToGatewayMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.iot.v1.BindDeviceToGatewayRequest, com.google.cloud.iot.v1.BindDeviceToGatewayResponse> getBindDeviceToGatewayMethod;
    if ((getBindDeviceToGatewayMethod = DeviceManagerGrpc.getBindDeviceToGatewayMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getBindDeviceToGatewayMethod = DeviceManagerGrpc.getBindDeviceToGatewayMethod) == null) {
          DeviceManagerGrpc.getBindDeviceToGatewayMethod = getBindDeviceToGatewayMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.iot.v1.BindDeviceToGatewayRequest, com.google.cloud.iot.v1.BindDeviceToGatewayResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.iot.v1.DeviceManager", "BindDeviceToGateway"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iot.v1.BindDeviceToGatewayRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iot.v1.BindDeviceToGatewayResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DeviceManagerMethodDescriptorSupplier("BindDeviceToGateway"))
                  .build();
          }
        }
     }
     return getBindDeviceToGatewayMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUnbindDeviceFromGatewayMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.iot.v1.UnbindDeviceFromGatewayRequest,
      com.google.cloud.iot.v1.UnbindDeviceFromGatewayResponse> METHOD_UNBIND_DEVICE_FROM_GATEWAY = getUnbindDeviceFromGatewayMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.iot.v1.UnbindDeviceFromGatewayRequest,
      com.google.cloud.iot.v1.UnbindDeviceFromGatewayResponse> getUnbindDeviceFromGatewayMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.iot.v1.UnbindDeviceFromGatewayRequest,
      com.google.cloud.iot.v1.UnbindDeviceFromGatewayResponse> getUnbindDeviceFromGatewayMethod() {
    return getUnbindDeviceFromGatewayMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.iot.v1.UnbindDeviceFromGatewayRequest,
      com.google.cloud.iot.v1.UnbindDeviceFromGatewayResponse> getUnbindDeviceFromGatewayMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.iot.v1.UnbindDeviceFromGatewayRequest, com.google.cloud.iot.v1.UnbindDeviceFromGatewayResponse> getUnbindDeviceFromGatewayMethod;
    if ((getUnbindDeviceFromGatewayMethod = DeviceManagerGrpc.getUnbindDeviceFromGatewayMethod) == null) {
      synchronized (DeviceManagerGrpc.class) {
        if ((getUnbindDeviceFromGatewayMethod = DeviceManagerGrpc.getUnbindDeviceFromGatewayMethod) == null) {
          DeviceManagerGrpc.getUnbindDeviceFromGatewayMethod = getUnbindDeviceFromGatewayMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.iot.v1.UnbindDeviceFromGatewayRequest, com.google.cloud.iot.v1.UnbindDeviceFromGatewayResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.iot.v1.DeviceManager", "UnbindDeviceFromGateway"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iot.v1.UnbindDeviceFromGatewayRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iot.v1.UnbindDeviceFromGatewayResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DeviceManagerMethodDescriptorSupplier("UnbindDeviceFromGateway"))
                  .build();
          }
        }
     }
     return getUnbindDeviceFromGatewayMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DeviceManagerStub newStub(io.grpc.Channel channel) {
    return new DeviceManagerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DeviceManagerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DeviceManagerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DeviceManagerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DeviceManagerFutureStub(channel);
  }

  /**
   * <pre>
   * Internet of Things (IoT) service. Securely connect and manage IoT devices.
   * </pre>
   */
  public static abstract class DeviceManagerImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Creates a device registry that contains devices.
     * </pre>
     */
    public void createDeviceRegistry(com.google.cloud.iot.v1.CreateDeviceRegistryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.DeviceRegistry> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateDeviceRegistryMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Gets a device registry configuration.
     * </pre>
     */
    public void getDeviceRegistry(com.google.cloud.iot.v1.GetDeviceRegistryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.DeviceRegistry> responseObserver) {
      asyncUnimplementedUnaryCall(getGetDeviceRegistryMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Updates a device registry configuration.
     * </pre>
     */
    public void updateDeviceRegistry(com.google.cloud.iot.v1.UpdateDeviceRegistryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.DeviceRegistry> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateDeviceRegistryMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a device registry configuration.
     * </pre>
     */
    public void deleteDeviceRegistry(com.google.cloud.iot.v1.DeleteDeviceRegistryRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteDeviceRegistryMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Lists device registries.
     * </pre>
     */
    public void listDeviceRegistries(com.google.cloud.iot.v1.ListDeviceRegistriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.ListDeviceRegistriesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListDeviceRegistriesMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Creates a device in a device registry.
     * </pre>
     */
    public void createDevice(com.google.cloud.iot.v1.CreateDeviceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.Device> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateDeviceMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Gets details about a device.
     * </pre>
     */
    public void getDevice(com.google.cloud.iot.v1.GetDeviceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.Device> responseObserver) {
      asyncUnimplementedUnaryCall(getGetDeviceMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Updates a device.
     * </pre>
     */
    public void updateDevice(com.google.cloud.iot.v1.UpdateDeviceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.Device> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateDeviceMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a device.
     * </pre>
     */
    public void deleteDevice(com.google.cloud.iot.v1.DeleteDeviceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteDeviceMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * List devices in a device registry.
     * </pre>
     */
    public void listDevices(com.google.cloud.iot.v1.ListDevicesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.ListDevicesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListDevicesMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Modifies the configuration for the device, which is eventually sent from
     * the Cloud IoT Core servers. Returns the modified configuration version and
     * its metadata.
     * </pre>
     */
    public void modifyCloudToDeviceConfig(com.google.cloud.iot.v1.ModifyCloudToDeviceConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.DeviceConfig> responseObserver) {
      asyncUnimplementedUnaryCall(getModifyCloudToDeviceConfigMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Lists the last few versions of the device configuration in descending
     * order (i.e.: newest first).
     * </pre>
     */
    public void listDeviceConfigVersions(com.google.cloud.iot.v1.ListDeviceConfigVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.ListDeviceConfigVersionsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListDeviceConfigVersionsMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Lists the last few versions of the device state in descending order (i.e.:
     * newest first).
     * </pre>
     */
    public void listDeviceStates(com.google.cloud.iot.v1.ListDeviceStatesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.ListDeviceStatesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListDeviceStatesMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Sets the access control policy on the specified resource. Replaces any
     * existing policy.
     * </pre>
     */
    public void setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnimplementedUnaryCall(getSetIamPolicyMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Gets the access control policy for a resource.
     * Returns an empty policy if the resource exists and does not have a policy
     * set.
     * </pre>
     */
    public void getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnimplementedUnaryCall(getGetIamPolicyMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Returns permissions that a caller has on the specified resource.
     * If the resource does not exist, this will return an empty set of
     * permissions, not a NOT_FOUND error.
     * </pre>
     */
    public void testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getTestIamPermissionsMethodHelper(), responseObserver);
    }

    /**
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
    public void sendCommandToDevice(com.google.cloud.iot.v1.SendCommandToDeviceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.SendCommandToDeviceResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSendCommandToDeviceMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Associates the device with the gateway.
     * </pre>
     */
    public void bindDeviceToGateway(com.google.cloud.iot.v1.BindDeviceToGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.BindDeviceToGatewayResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getBindDeviceToGatewayMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the association between the device and the gateway.
     * </pre>
     */
    public void unbindDeviceFromGateway(com.google.cloud.iot.v1.UnbindDeviceFromGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.UnbindDeviceFromGatewayResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUnbindDeviceFromGatewayMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateDeviceRegistryMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.iot.v1.CreateDeviceRegistryRequest,
                com.google.cloud.iot.v1.DeviceRegistry>(
                  this, METHODID_CREATE_DEVICE_REGISTRY)))
          .addMethod(
            getGetDeviceRegistryMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.iot.v1.GetDeviceRegistryRequest,
                com.google.cloud.iot.v1.DeviceRegistry>(
                  this, METHODID_GET_DEVICE_REGISTRY)))
          .addMethod(
            getUpdateDeviceRegistryMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.iot.v1.UpdateDeviceRegistryRequest,
                com.google.cloud.iot.v1.DeviceRegistry>(
                  this, METHODID_UPDATE_DEVICE_REGISTRY)))
          .addMethod(
            getDeleteDeviceRegistryMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.iot.v1.DeleteDeviceRegistryRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_DEVICE_REGISTRY)))
          .addMethod(
            getListDeviceRegistriesMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.iot.v1.ListDeviceRegistriesRequest,
                com.google.cloud.iot.v1.ListDeviceRegistriesResponse>(
                  this, METHODID_LIST_DEVICE_REGISTRIES)))
          .addMethod(
            getCreateDeviceMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.iot.v1.CreateDeviceRequest,
                com.google.cloud.iot.v1.Device>(
                  this, METHODID_CREATE_DEVICE)))
          .addMethod(
            getGetDeviceMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.iot.v1.GetDeviceRequest,
                com.google.cloud.iot.v1.Device>(
                  this, METHODID_GET_DEVICE)))
          .addMethod(
            getUpdateDeviceMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.iot.v1.UpdateDeviceRequest,
                com.google.cloud.iot.v1.Device>(
                  this, METHODID_UPDATE_DEVICE)))
          .addMethod(
            getDeleteDeviceMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.iot.v1.DeleteDeviceRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_DEVICE)))
          .addMethod(
            getListDevicesMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.iot.v1.ListDevicesRequest,
                com.google.cloud.iot.v1.ListDevicesResponse>(
                  this, METHODID_LIST_DEVICES)))
          .addMethod(
            getModifyCloudToDeviceConfigMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.iot.v1.ModifyCloudToDeviceConfigRequest,
                com.google.cloud.iot.v1.DeviceConfig>(
                  this, METHODID_MODIFY_CLOUD_TO_DEVICE_CONFIG)))
          .addMethod(
            getListDeviceConfigVersionsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.iot.v1.ListDeviceConfigVersionsRequest,
                com.google.cloud.iot.v1.ListDeviceConfigVersionsResponse>(
                  this, METHODID_LIST_DEVICE_CONFIG_VERSIONS)))
          .addMethod(
            getListDeviceStatesMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.iot.v1.ListDeviceStatesRequest,
                com.google.cloud.iot.v1.ListDeviceStatesResponse>(
                  this, METHODID_LIST_DEVICE_STATES)))
          .addMethod(
            getSetIamPolicyMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.SetIamPolicyRequest,
                com.google.iam.v1.Policy>(
                  this, METHODID_SET_IAM_POLICY)))
          .addMethod(
            getGetIamPolicyMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.GetIamPolicyRequest,
                com.google.iam.v1.Policy>(
                  this, METHODID_GET_IAM_POLICY)))
          .addMethod(
            getTestIamPermissionsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.TestIamPermissionsRequest,
                com.google.iam.v1.TestIamPermissionsResponse>(
                  this, METHODID_TEST_IAM_PERMISSIONS)))
          .addMethod(
            getSendCommandToDeviceMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.iot.v1.SendCommandToDeviceRequest,
                com.google.cloud.iot.v1.SendCommandToDeviceResponse>(
                  this, METHODID_SEND_COMMAND_TO_DEVICE)))
          .addMethod(
            getBindDeviceToGatewayMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.iot.v1.BindDeviceToGatewayRequest,
                com.google.cloud.iot.v1.BindDeviceToGatewayResponse>(
                  this, METHODID_BIND_DEVICE_TO_GATEWAY)))
          .addMethod(
            getUnbindDeviceFromGatewayMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.iot.v1.UnbindDeviceFromGatewayRequest,
                com.google.cloud.iot.v1.UnbindDeviceFromGatewayResponse>(
                  this, METHODID_UNBIND_DEVICE_FROM_GATEWAY)))
          .build();
    }
  }

  /**
   * <pre>
   * Internet of Things (IoT) service. Securely connect and manage IoT devices.
   * </pre>
   */
  public static final class DeviceManagerStub extends io.grpc.stub.AbstractStub<DeviceManagerStub> {
    private DeviceManagerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DeviceManagerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeviceManagerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DeviceManagerStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a device registry that contains devices.
     * </pre>
     */
    public void createDeviceRegistry(com.google.cloud.iot.v1.CreateDeviceRegistryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.DeviceRegistry> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateDeviceRegistryMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a device registry configuration.
     * </pre>
     */
    public void getDeviceRegistry(com.google.cloud.iot.v1.GetDeviceRegistryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.DeviceRegistry> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetDeviceRegistryMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a device registry configuration.
     * </pre>
     */
    public void updateDeviceRegistry(com.google.cloud.iot.v1.UpdateDeviceRegistryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.DeviceRegistry> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateDeviceRegistryMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a device registry configuration.
     * </pre>
     */
    public void deleteDeviceRegistry(com.google.cloud.iot.v1.DeleteDeviceRegistryRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteDeviceRegistryMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists device registries.
     * </pre>
     */
    public void listDeviceRegistries(com.google.cloud.iot.v1.ListDeviceRegistriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.ListDeviceRegistriesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListDeviceRegistriesMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a device in a device registry.
     * </pre>
     */
    public void createDevice(com.google.cloud.iot.v1.CreateDeviceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.Device> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateDeviceMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details about a device.
     * </pre>
     */
    public void getDevice(com.google.cloud.iot.v1.GetDeviceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.Device> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetDeviceMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a device.
     * </pre>
     */
    public void updateDevice(com.google.cloud.iot.v1.UpdateDeviceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.Device> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateDeviceMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a device.
     * </pre>
     */
    public void deleteDevice(com.google.cloud.iot.v1.DeleteDeviceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteDeviceMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * List devices in a device registry.
     * </pre>
     */
    public void listDevices(com.google.cloud.iot.v1.ListDevicesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.ListDevicesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListDevicesMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Modifies the configuration for the device, which is eventually sent from
     * the Cloud IoT Core servers. Returns the modified configuration version and
     * its metadata.
     * </pre>
     */
    public void modifyCloudToDeviceConfig(com.google.cloud.iot.v1.ModifyCloudToDeviceConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.DeviceConfig> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getModifyCloudToDeviceConfigMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists the last few versions of the device configuration in descending
     * order (i.e.: newest first).
     * </pre>
     */
    public void listDeviceConfigVersions(com.google.cloud.iot.v1.ListDeviceConfigVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.ListDeviceConfigVersionsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListDeviceConfigVersionsMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists the last few versions of the device state in descending order (i.e.:
     * newest first).
     * </pre>
     */
    public void listDeviceStates(com.google.cloud.iot.v1.ListDeviceStatesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.ListDeviceStatesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListDeviceStatesMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Sets the access control policy on the specified resource. Replaces any
     * existing policy.
     * </pre>
     */
    public void setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the access control policy for a resource.
     * Returns an empty policy if the resource exists and does not have a policy
     * set.
     * </pre>
     */
    public void getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns permissions that a caller has on the specified resource.
     * If the resource does not exist, this will return an empty set of
     * permissions, not a NOT_FOUND error.
     * </pre>
     */
    public void testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
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
    public void sendCommandToDevice(com.google.cloud.iot.v1.SendCommandToDeviceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.SendCommandToDeviceResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendCommandToDeviceMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Associates the device with the gateway.
     * </pre>
     */
    public void bindDeviceToGateway(com.google.cloud.iot.v1.BindDeviceToGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.BindDeviceToGatewayResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBindDeviceToGatewayMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the association between the device and the gateway.
     * </pre>
     */
    public void unbindDeviceFromGateway(com.google.cloud.iot.v1.UnbindDeviceFromGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.UnbindDeviceFromGatewayResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUnbindDeviceFromGatewayMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Internet of Things (IoT) service. Securely connect and manage IoT devices.
   * </pre>
   */
  public static final class DeviceManagerBlockingStub extends io.grpc.stub.AbstractStub<DeviceManagerBlockingStub> {
    private DeviceManagerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DeviceManagerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeviceManagerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DeviceManagerBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a device registry that contains devices.
     * </pre>
     */
    public com.google.cloud.iot.v1.DeviceRegistry createDeviceRegistry(com.google.cloud.iot.v1.CreateDeviceRegistryRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateDeviceRegistryMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a device registry configuration.
     * </pre>
     */
    public com.google.cloud.iot.v1.DeviceRegistry getDeviceRegistry(com.google.cloud.iot.v1.GetDeviceRegistryRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetDeviceRegistryMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a device registry configuration.
     * </pre>
     */
    public com.google.cloud.iot.v1.DeviceRegistry updateDeviceRegistry(com.google.cloud.iot.v1.UpdateDeviceRegistryRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateDeviceRegistryMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a device registry configuration.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDeviceRegistry(com.google.cloud.iot.v1.DeleteDeviceRegistryRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteDeviceRegistryMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists device registries.
     * </pre>
     */
    public com.google.cloud.iot.v1.ListDeviceRegistriesResponse listDeviceRegistries(com.google.cloud.iot.v1.ListDeviceRegistriesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListDeviceRegistriesMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a device in a device registry.
     * </pre>
     */
    public com.google.cloud.iot.v1.Device createDevice(com.google.cloud.iot.v1.CreateDeviceRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateDeviceMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details about a device.
     * </pre>
     */
    public com.google.cloud.iot.v1.Device getDevice(com.google.cloud.iot.v1.GetDeviceRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetDeviceMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a device.
     * </pre>
     */
    public com.google.cloud.iot.v1.Device updateDevice(com.google.cloud.iot.v1.UpdateDeviceRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateDeviceMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a device.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDevice(com.google.cloud.iot.v1.DeleteDeviceRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteDeviceMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * List devices in a device registry.
     * </pre>
     */
    public com.google.cloud.iot.v1.ListDevicesResponse listDevices(com.google.cloud.iot.v1.ListDevicesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListDevicesMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Modifies the configuration for the device, which is eventually sent from
     * the Cloud IoT Core servers. Returns the modified configuration version and
     * its metadata.
     * </pre>
     */
    public com.google.cloud.iot.v1.DeviceConfig modifyCloudToDeviceConfig(com.google.cloud.iot.v1.ModifyCloudToDeviceConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getModifyCloudToDeviceConfigMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists the last few versions of the device configuration in descending
     * order (i.e.: newest first).
     * </pre>
     */
    public com.google.cloud.iot.v1.ListDeviceConfigVersionsResponse listDeviceConfigVersions(com.google.cloud.iot.v1.ListDeviceConfigVersionsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListDeviceConfigVersionsMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists the last few versions of the device state in descending order (i.e.:
     * newest first).
     * </pre>
     */
    public com.google.cloud.iot.v1.ListDeviceStatesResponse listDeviceStates(com.google.cloud.iot.v1.ListDeviceStatesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListDeviceStatesMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Sets the access control policy on the specified resource. Replaces any
     * existing policy.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetIamPolicyMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the access control policy for a resource.
     * Returns an empty policy if the resource exists and does not have a policy
     * set.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetIamPolicyMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns permissions that a caller has on the specified resource.
     * If the resource does not exist, this will return an empty set of
     * permissions, not a NOT_FOUND error.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethodHelper(), getCallOptions(), request);
    }

    /**
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
    public com.google.cloud.iot.v1.SendCommandToDeviceResponse sendCommandToDevice(com.google.cloud.iot.v1.SendCommandToDeviceRequest request) {
      return blockingUnaryCall(
          getChannel(), getSendCommandToDeviceMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Associates the device with the gateway.
     * </pre>
     */
    public com.google.cloud.iot.v1.BindDeviceToGatewayResponse bindDeviceToGateway(com.google.cloud.iot.v1.BindDeviceToGatewayRequest request) {
      return blockingUnaryCall(
          getChannel(), getBindDeviceToGatewayMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the association between the device and the gateway.
     * </pre>
     */
    public com.google.cloud.iot.v1.UnbindDeviceFromGatewayResponse unbindDeviceFromGateway(com.google.cloud.iot.v1.UnbindDeviceFromGatewayRequest request) {
      return blockingUnaryCall(
          getChannel(), getUnbindDeviceFromGatewayMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Internet of Things (IoT) service. Securely connect and manage IoT devices.
   * </pre>
   */
  public static final class DeviceManagerFutureStub extends io.grpc.stub.AbstractStub<DeviceManagerFutureStub> {
    private DeviceManagerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DeviceManagerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeviceManagerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DeviceManagerFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a device registry that contains devices.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.iot.v1.DeviceRegistry> createDeviceRegistry(
        com.google.cloud.iot.v1.CreateDeviceRegistryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateDeviceRegistryMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a device registry configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.iot.v1.DeviceRegistry> getDeviceRegistry(
        com.google.cloud.iot.v1.GetDeviceRegistryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetDeviceRegistryMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a device registry configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.iot.v1.DeviceRegistry> updateDeviceRegistry(
        com.google.cloud.iot.v1.UpdateDeviceRegistryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateDeviceRegistryMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a device registry configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteDeviceRegistry(
        com.google.cloud.iot.v1.DeleteDeviceRegistryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteDeviceRegistryMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists device registries.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.iot.v1.ListDeviceRegistriesResponse> listDeviceRegistries(
        com.google.cloud.iot.v1.ListDeviceRegistriesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListDeviceRegistriesMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a device in a device registry.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.iot.v1.Device> createDevice(
        com.google.cloud.iot.v1.CreateDeviceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateDeviceMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details about a device.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.iot.v1.Device> getDevice(
        com.google.cloud.iot.v1.GetDeviceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetDeviceMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a device.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.iot.v1.Device> updateDevice(
        com.google.cloud.iot.v1.UpdateDeviceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateDeviceMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a device.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteDevice(
        com.google.cloud.iot.v1.DeleteDeviceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteDeviceMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * List devices in a device registry.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.iot.v1.ListDevicesResponse> listDevices(
        com.google.cloud.iot.v1.ListDevicesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListDevicesMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Modifies the configuration for the device, which is eventually sent from
     * the Cloud IoT Core servers. Returns the modified configuration version and
     * its metadata.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.iot.v1.DeviceConfig> modifyCloudToDeviceConfig(
        com.google.cloud.iot.v1.ModifyCloudToDeviceConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getModifyCloudToDeviceConfigMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists the last few versions of the device configuration in descending
     * order (i.e.: newest first).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.iot.v1.ListDeviceConfigVersionsResponse> listDeviceConfigVersions(
        com.google.cloud.iot.v1.ListDeviceConfigVersionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListDeviceConfigVersionsMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists the last few versions of the device state in descending order (i.e.:
     * newest first).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.iot.v1.ListDeviceStatesResponse> listDeviceStates(
        com.google.cloud.iot.v1.ListDeviceStatesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListDeviceStatesMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Sets the access control policy on the specified resource. Replaces any
     * existing policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy> setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the access control policy for a resource.
     * Returns an empty policy if the resource exists and does not have a policy
     * set.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy> getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns permissions that a caller has on the specified resource.
     * If the resource does not exist, this will return an empty set of
     * permissions, not a NOT_FOUND error.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.TestIamPermissionsResponse> testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethodHelper(), getCallOptions()), request);
    }

    /**
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
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.iot.v1.SendCommandToDeviceResponse> sendCommandToDevice(
        com.google.cloud.iot.v1.SendCommandToDeviceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSendCommandToDeviceMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Associates the device with the gateway.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.iot.v1.BindDeviceToGatewayResponse> bindDeviceToGateway(
        com.google.cloud.iot.v1.BindDeviceToGatewayRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBindDeviceToGatewayMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the association between the device and the gateway.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.iot.v1.UnbindDeviceFromGatewayResponse> unbindDeviceFromGateway(
        com.google.cloud.iot.v1.UnbindDeviceFromGatewayRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUnbindDeviceFromGatewayMethodHelper(), getCallOptions()), request);
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

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
          serviceImpl.createDeviceRegistry((com.google.cloud.iot.v1.CreateDeviceRegistryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.DeviceRegistry>) responseObserver);
          break;
        case METHODID_GET_DEVICE_REGISTRY:
          serviceImpl.getDeviceRegistry((com.google.cloud.iot.v1.GetDeviceRegistryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.DeviceRegistry>) responseObserver);
          break;
        case METHODID_UPDATE_DEVICE_REGISTRY:
          serviceImpl.updateDeviceRegistry((com.google.cloud.iot.v1.UpdateDeviceRegistryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.DeviceRegistry>) responseObserver);
          break;
        case METHODID_DELETE_DEVICE_REGISTRY:
          serviceImpl.deleteDeviceRegistry((com.google.cloud.iot.v1.DeleteDeviceRegistryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_DEVICE_REGISTRIES:
          serviceImpl.listDeviceRegistries((com.google.cloud.iot.v1.ListDeviceRegistriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.ListDeviceRegistriesResponse>) responseObserver);
          break;
        case METHODID_CREATE_DEVICE:
          serviceImpl.createDevice((com.google.cloud.iot.v1.CreateDeviceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.Device>) responseObserver);
          break;
        case METHODID_GET_DEVICE:
          serviceImpl.getDevice((com.google.cloud.iot.v1.GetDeviceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.Device>) responseObserver);
          break;
        case METHODID_UPDATE_DEVICE:
          serviceImpl.updateDevice((com.google.cloud.iot.v1.UpdateDeviceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.Device>) responseObserver);
          break;
        case METHODID_DELETE_DEVICE:
          serviceImpl.deleteDevice((com.google.cloud.iot.v1.DeleteDeviceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_DEVICES:
          serviceImpl.listDevices((com.google.cloud.iot.v1.ListDevicesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.ListDevicesResponse>) responseObserver);
          break;
        case METHODID_MODIFY_CLOUD_TO_DEVICE_CONFIG:
          serviceImpl.modifyCloudToDeviceConfig((com.google.cloud.iot.v1.ModifyCloudToDeviceConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.DeviceConfig>) responseObserver);
          break;
        case METHODID_LIST_DEVICE_CONFIG_VERSIONS:
          serviceImpl.listDeviceConfigVersions((com.google.cloud.iot.v1.ListDeviceConfigVersionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.ListDeviceConfigVersionsResponse>) responseObserver);
          break;
        case METHODID_LIST_DEVICE_STATES:
          serviceImpl.listDeviceStates((com.google.cloud.iot.v1.ListDeviceStatesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.ListDeviceStatesResponse>) responseObserver);
          break;
        case METHODID_SET_IAM_POLICY:
          serviceImpl.setIamPolicy((com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy((com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS:
          serviceImpl.testIamPermissions((com.google.iam.v1.TestIamPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>) responseObserver);
          break;
        case METHODID_SEND_COMMAND_TO_DEVICE:
          serviceImpl.sendCommandToDevice((com.google.cloud.iot.v1.SendCommandToDeviceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.SendCommandToDeviceResponse>) responseObserver);
          break;
        case METHODID_BIND_DEVICE_TO_GATEWAY:
          serviceImpl.bindDeviceToGateway((com.google.cloud.iot.v1.BindDeviceToGatewayRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.BindDeviceToGatewayResponse>) responseObserver);
          break;
        case METHODID_UNBIND_DEVICE_FROM_GATEWAY:
          serviceImpl.unbindDeviceFromGateway((com.google.cloud.iot.v1.UnbindDeviceFromGatewayRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iot.v1.UnbindDeviceFromGatewayResponse>) responseObserver);
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

  private static abstract class DeviceManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
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
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DeviceManagerFileDescriptorSupplier())
              .addMethod(getCreateDeviceRegistryMethodHelper())
              .addMethod(getGetDeviceRegistryMethodHelper())
              .addMethod(getUpdateDeviceRegistryMethodHelper())
              .addMethod(getDeleteDeviceRegistryMethodHelper())
              .addMethod(getListDeviceRegistriesMethodHelper())
              .addMethod(getCreateDeviceMethodHelper())
              .addMethod(getGetDeviceMethodHelper())
              .addMethod(getUpdateDeviceMethodHelper())
              .addMethod(getDeleteDeviceMethodHelper())
              .addMethod(getListDevicesMethodHelper())
              .addMethod(getModifyCloudToDeviceConfigMethodHelper())
              .addMethod(getListDeviceConfigVersionsMethodHelper())
              .addMethod(getListDeviceStatesMethodHelper())
              .addMethod(getSetIamPolicyMethodHelper())
              .addMethod(getGetIamPolicyMethodHelper())
              .addMethod(getTestIamPermissionsMethodHelper())
              .addMethod(getSendCommandToDeviceMethodHelper())
              .addMethod(getBindDeviceToGatewayMethodHelper())
              .addMethod(getUnbindDeviceFromGatewayMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
