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
package com.google.cloud.devicestreaming.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A service for allocating Android devices and interacting with the
 * live-allocated devices.
 * Each Session will wait for available capacity, at a higher
 * priority over Test Execution. When allocated, the session will be exposed
 * through a stream for integration.
 * DirectAccessService is currently available as a preview to select developers.
 * You can register today on behalf of you and your team at
 * https://developer.android.com/studio/preview/android-device-streaming
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/devicestreaming/v1/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DirectAccessServiceGrpc {

  private DirectAccessServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.devicestreaming.v1.DirectAccessService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.devicestreaming.v1.CreateDeviceSessionRequest,
          com.google.cloud.devicestreaming.v1.DeviceSession>
      getCreateDeviceSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDeviceSession",
      requestType = com.google.cloud.devicestreaming.v1.CreateDeviceSessionRequest.class,
      responseType = com.google.cloud.devicestreaming.v1.DeviceSession.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.devicestreaming.v1.CreateDeviceSessionRequest,
          com.google.cloud.devicestreaming.v1.DeviceSession>
      getCreateDeviceSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.devicestreaming.v1.CreateDeviceSessionRequest,
            com.google.cloud.devicestreaming.v1.DeviceSession>
        getCreateDeviceSessionMethod;
    if ((getCreateDeviceSessionMethod = DirectAccessServiceGrpc.getCreateDeviceSessionMethod)
        == null) {
      synchronized (DirectAccessServiceGrpc.class) {
        if ((getCreateDeviceSessionMethod = DirectAccessServiceGrpc.getCreateDeviceSessionMethod)
            == null) {
          DirectAccessServiceGrpc.getCreateDeviceSessionMethod =
              getCreateDeviceSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.devicestreaming.v1.CreateDeviceSessionRequest,
                          com.google.cloud.devicestreaming.v1.DeviceSession>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateDeviceSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.devicestreaming.v1.CreateDeviceSessionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.devicestreaming.v1.DeviceSession
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DirectAccessServiceMethodDescriptorSupplier("CreateDeviceSession"))
                      .build();
        }
      }
    }
    return getCreateDeviceSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.devicestreaming.v1.ListDeviceSessionsRequest,
          com.google.cloud.devicestreaming.v1.ListDeviceSessionsResponse>
      getListDeviceSessionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDeviceSessions",
      requestType = com.google.cloud.devicestreaming.v1.ListDeviceSessionsRequest.class,
      responseType = com.google.cloud.devicestreaming.v1.ListDeviceSessionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.devicestreaming.v1.ListDeviceSessionsRequest,
          com.google.cloud.devicestreaming.v1.ListDeviceSessionsResponse>
      getListDeviceSessionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.devicestreaming.v1.ListDeviceSessionsRequest,
            com.google.cloud.devicestreaming.v1.ListDeviceSessionsResponse>
        getListDeviceSessionsMethod;
    if ((getListDeviceSessionsMethod = DirectAccessServiceGrpc.getListDeviceSessionsMethod)
        == null) {
      synchronized (DirectAccessServiceGrpc.class) {
        if ((getListDeviceSessionsMethod = DirectAccessServiceGrpc.getListDeviceSessionsMethod)
            == null) {
          DirectAccessServiceGrpc.getListDeviceSessionsMethod =
              getListDeviceSessionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.devicestreaming.v1.ListDeviceSessionsRequest,
                          com.google.cloud.devicestreaming.v1.ListDeviceSessionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDeviceSessions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.devicestreaming.v1.ListDeviceSessionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.devicestreaming.v1.ListDeviceSessionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DirectAccessServiceMethodDescriptorSupplier("ListDeviceSessions"))
                      .build();
        }
      }
    }
    return getListDeviceSessionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.devicestreaming.v1.GetDeviceSessionRequest,
          com.google.cloud.devicestreaming.v1.DeviceSession>
      getGetDeviceSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDeviceSession",
      requestType = com.google.cloud.devicestreaming.v1.GetDeviceSessionRequest.class,
      responseType = com.google.cloud.devicestreaming.v1.DeviceSession.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.devicestreaming.v1.GetDeviceSessionRequest,
          com.google.cloud.devicestreaming.v1.DeviceSession>
      getGetDeviceSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.devicestreaming.v1.GetDeviceSessionRequest,
            com.google.cloud.devicestreaming.v1.DeviceSession>
        getGetDeviceSessionMethod;
    if ((getGetDeviceSessionMethod = DirectAccessServiceGrpc.getGetDeviceSessionMethod) == null) {
      synchronized (DirectAccessServiceGrpc.class) {
        if ((getGetDeviceSessionMethod = DirectAccessServiceGrpc.getGetDeviceSessionMethod)
            == null) {
          DirectAccessServiceGrpc.getGetDeviceSessionMethod =
              getGetDeviceSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.devicestreaming.v1.GetDeviceSessionRequest,
                          com.google.cloud.devicestreaming.v1.DeviceSession>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDeviceSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.devicestreaming.v1.GetDeviceSessionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.devicestreaming.v1.DeviceSession
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DirectAccessServiceMethodDescriptorSupplier("GetDeviceSession"))
                      .build();
        }
      }
    }
    return getGetDeviceSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.devicestreaming.v1.CancelDeviceSessionRequest, com.google.protobuf.Empty>
      getCancelDeviceSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelDeviceSession",
      requestType = com.google.cloud.devicestreaming.v1.CancelDeviceSessionRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.devicestreaming.v1.CancelDeviceSessionRequest, com.google.protobuf.Empty>
      getCancelDeviceSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.devicestreaming.v1.CancelDeviceSessionRequest,
            com.google.protobuf.Empty>
        getCancelDeviceSessionMethod;
    if ((getCancelDeviceSessionMethod = DirectAccessServiceGrpc.getCancelDeviceSessionMethod)
        == null) {
      synchronized (DirectAccessServiceGrpc.class) {
        if ((getCancelDeviceSessionMethod = DirectAccessServiceGrpc.getCancelDeviceSessionMethod)
            == null) {
          DirectAccessServiceGrpc.getCancelDeviceSessionMethod =
              getCancelDeviceSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.devicestreaming.v1.CancelDeviceSessionRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CancelDeviceSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.devicestreaming.v1.CancelDeviceSessionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DirectAccessServiceMethodDescriptorSupplier("CancelDeviceSession"))
                      .build();
        }
      }
    }
    return getCancelDeviceSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.devicestreaming.v1.UpdateDeviceSessionRequest,
          com.google.cloud.devicestreaming.v1.DeviceSession>
      getUpdateDeviceSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDeviceSession",
      requestType = com.google.cloud.devicestreaming.v1.UpdateDeviceSessionRequest.class,
      responseType = com.google.cloud.devicestreaming.v1.DeviceSession.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.devicestreaming.v1.UpdateDeviceSessionRequest,
          com.google.cloud.devicestreaming.v1.DeviceSession>
      getUpdateDeviceSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.devicestreaming.v1.UpdateDeviceSessionRequest,
            com.google.cloud.devicestreaming.v1.DeviceSession>
        getUpdateDeviceSessionMethod;
    if ((getUpdateDeviceSessionMethod = DirectAccessServiceGrpc.getUpdateDeviceSessionMethod)
        == null) {
      synchronized (DirectAccessServiceGrpc.class) {
        if ((getUpdateDeviceSessionMethod = DirectAccessServiceGrpc.getUpdateDeviceSessionMethod)
            == null) {
          DirectAccessServiceGrpc.getUpdateDeviceSessionMethod =
              getUpdateDeviceSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.devicestreaming.v1.UpdateDeviceSessionRequest,
                          com.google.cloud.devicestreaming.v1.DeviceSession>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateDeviceSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.devicestreaming.v1.UpdateDeviceSessionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.devicestreaming.v1.DeviceSession
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DirectAccessServiceMethodDescriptorSupplier("UpdateDeviceSession"))
                      .build();
        }
      }
    }
    return getUpdateDeviceSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.devicestreaming.v1.AdbMessage,
          com.google.cloud.devicestreaming.v1.DeviceMessage>
      getAdbConnectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AdbConnect",
      requestType = com.google.cloud.devicestreaming.v1.AdbMessage.class,
      responseType = com.google.cloud.devicestreaming.v1.DeviceMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.devicestreaming.v1.AdbMessage,
          com.google.cloud.devicestreaming.v1.DeviceMessage>
      getAdbConnectMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.devicestreaming.v1.AdbMessage,
            com.google.cloud.devicestreaming.v1.DeviceMessage>
        getAdbConnectMethod;
    if ((getAdbConnectMethod = DirectAccessServiceGrpc.getAdbConnectMethod) == null) {
      synchronized (DirectAccessServiceGrpc.class) {
        if ((getAdbConnectMethod = DirectAccessServiceGrpc.getAdbConnectMethod) == null) {
          DirectAccessServiceGrpc.getAdbConnectMethod =
              getAdbConnectMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.devicestreaming.v1.AdbMessage,
                          com.google.cloud.devicestreaming.v1.DeviceMessage>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AdbConnect"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.devicestreaming.v1.AdbMessage.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.devicestreaming.v1.DeviceMessage
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DirectAccessServiceMethodDescriptorSupplier("AdbConnect"))
                      .build();
        }
      }
    }
    return getAdbConnectMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DirectAccessServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DirectAccessServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DirectAccessServiceStub>() {
          @java.lang.Override
          public DirectAccessServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DirectAccessServiceStub(channel, callOptions);
          }
        };
    return DirectAccessServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static DirectAccessServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DirectAccessServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DirectAccessServiceBlockingV2Stub>() {
          @java.lang.Override
          public DirectAccessServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DirectAccessServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return DirectAccessServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DirectAccessServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DirectAccessServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DirectAccessServiceBlockingStub>() {
          @java.lang.Override
          public DirectAccessServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DirectAccessServiceBlockingStub(channel, callOptions);
          }
        };
    return DirectAccessServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DirectAccessServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DirectAccessServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DirectAccessServiceFutureStub>() {
          @java.lang.Override
          public DirectAccessServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DirectAccessServiceFutureStub(channel, callOptions);
          }
        };
    return DirectAccessServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * A service for allocating Android devices and interacting with the
   * live-allocated devices.
   * Each Session will wait for available capacity, at a higher
   * priority over Test Execution. When allocated, the session will be exposed
   * through a stream for integration.
   * DirectAccessService is currently available as a preview to select developers.
   * You can register today on behalf of you and your team at
   * https://developer.android.com/studio/preview/android-device-streaming
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a DeviceSession.
     * </pre>
     */
    default void createDeviceSession(
        com.google.cloud.devicestreaming.v1.CreateDeviceSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.devicestreaming.v1.DeviceSession>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDeviceSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DeviceSessions owned by the project user.
     * </pre>
     */
    default void listDeviceSessions(
        com.google.cloud.devicestreaming.v1.ListDeviceSessionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.devicestreaming.v1.ListDeviceSessionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDeviceSessionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a DeviceSession, which documents the allocation status and
     * whether the device is allocated. Clients making requests from this API
     * must poll GetDeviceSession.
     * </pre>
     */
    default void getDeviceSession(
        com.google.cloud.devicestreaming.v1.GetDeviceSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.devicestreaming.v1.DeviceSession>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDeviceSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancel a DeviceSession.
     * This RPC changes the DeviceSession to state FINISHED and terminates all
     * connections.
     * Canceled sessions are not deleted and can be retrieved or
     * listed by the user until they expire based on the 28 day deletion policy.
     * </pre>
     */
    default void cancelDeviceSession(
        com.google.cloud.devicestreaming.v1.CancelDeviceSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCancelDeviceSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the current DeviceSession to the fields described by the
     * update_mask.
     * </pre>
     */
    default void updateDeviceSession(
        com.google.cloud.devicestreaming.v1.UpdateDeviceSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.devicestreaming.v1.DeviceSession>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDeviceSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exposes an ADB connection if the device supports ADB.
     * gRPC headers are used to authenticate the Connect RPC, as well as
     * associate to a particular DeviceSession.
     * In particular, the user must specify the "X-Omnilab-Session-Name" header.
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.google.cloud.devicestreaming.v1.AdbMessage> adbConnect(
        io.grpc.stub.StreamObserver<com.google.cloud.devicestreaming.v1.DeviceMessage>
            responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(
          getAdbConnectMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DirectAccessService.
   *
   * <pre>
   * A service for allocating Android devices and interacting with the
   * live-allocated devices.
   * Each Session will wait for available capacity, at a higher
   * priority over Test Execution. When allocated, the session will be exposed
   * through a stream for integration.
   * DirectAccessService is currently available as a preview to select developers.
   * You can register today on behalf of you and your team at
   * https://developer.android.com/studio/preview/android-device-streaming
   * </pre>
   */
  public abstract static class DirectAccessServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DirectAccessServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DirectAccessService.
   *
   * <pre>
   * A service for allocating Android devices and interacting with the
   * live-allocated devices.
   * Each Session will wait for available capacity, at a higher
   * priority over Test Execution. When allocated, the session will be exposed
   * through a stream for integration.
   * DirectAccessService is currently available as a preview to select developers.
   * You can register today on behalf of you and your team at
   * https://developer.android.com/studio/preview/android-device-streaming
   * </pre>
   */
  public static final class DirectAccessServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DirectAccessServiceStub> {
    private DirectAccessServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DirectAccessServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DirectAccessServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a DeviceSession.
     * </pre>
     */
    public void createDeviceSession(
        com.google.cloud.devicestreaming.v1.CreateDeviceSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.devicestreaming.v1.DeviceSession>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDeviceSessionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DeviceSessions owned by the project user.
     * </pre>
     */
    public void listDeviceSessions(
        com.google.cloud.devicestreaming.v1.ListDeviceSessionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.devicestreaming.v1.ListDeviceSessionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDeviceSessionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a DeviceSession, which documents the allocation status and
     * whether the device is allocated. Clients making requests from this API
     * must poll GetDeviceSession.
     * </pre>
     */
    public void getDeviceSession(
        com.google.cloud.devicestreaming.v1.GetDeviceSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.devicestreaming.v1.DeviceSession>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDeviceSessionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancel a DeviceSession.
     * This RPC changes the DeviceSession to state FINISHED and terminates all
     * connections.
     * Canceled sessions are not deleted and can be retrieved or
     * listed by the user until they expire based on the 28 day deletion policy.
     * </pre>
     */
    public void cancelDeviceSession(
        com.google.cloud.devicestreaming.v1.CancelDeviceSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelDeviceSessionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the current DeviceSession to the fields described by the
     * update_mask.
     * </pre>
     */
    public void updateDeviceSession(
        com.google.cloud.devicestreaming.v1.UpdateDeviceSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.devicestreaming.v1.DeviceSession>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDeviceSessionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exposes an ADB connection if the device supports ADB.
     * gRPC headers are used to authenticate the Connect RPC, as well as
     * associate to a particular DeviceSession.
     * In particular, the user must specify the "X-Omnilab-Session-Name" header.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.cloud.devicestreaming.v1.AdbMessage> adbConnect(
        io.grpc.stub.StreamObserver<com.google.cloud.devicestreaming.v1.DeviceMessage>
            responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getAdbConnectMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DirectAccessService.
   *
   * <pre>
   * A service for allocating Android devices and interacting with the
   * live-allocated devices.
   * Each Session will wait for available capacity, at a higher
   * priority over Test Execution. When allocated, the session will be exposed
   * through a stream for integration.
   * DirectAccessService is currently available as a preview to select developers.
   * You can register today on behalf of you and your team at
   * https://developer.android.com/studio/preview/android-device-streaming
   * </pre>
   */
  public static final class DirectAccessServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<DirectAccessServiceBlockingV2Stub> {
    private DirectAccessServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DirectAccessServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DirectAccessServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a DeviceSession.
     * </pre>
     */
    public com.google.cloud.devicestreaming.v1.DeviceSession createDeviceSession(
        com.google.cloud.devicestreaming.v1.CreateDeviceSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDeviceSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DeviceSessions owned by the project user.
     * </pre>
     */
    public com.google.cloud.devicestreaming.v1.ListDeviceSessionsResponse listDeviceSessions(
        com.google.cloud.devicestreaming.v1.ListDeviceSessionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDeviceSessionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a DeviceSession, which documents the allocation status and
     * whether the device is allocated. Clients making requests from this API
     * must poll GetDeviceSession.
     * </pre>
     */
    public com.google.cloud.devicestreaming.v1.DeviceSession getDeviceSession(
        com.google.cloud.devicestreaming.v1.GetDeviceSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDeviceSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Cancel a DeviceSession.
     * This RPC changes the DeviceSession to state FINISHED and terminates all
     * connections.
     * Canceled sessions are not deleted and can be retrieved or
     * listed by the user until they expire based on the 28 day deletion policy.
     * </pre>
     */
    public com.google.protobuf.Empty cancelDeviceSession(
        com.google.cloud.devicestreaming.v1.CancelDeviceSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelDeviceSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the current DeviceSession to the fields described by the
     * update_mask.
     * </pre>
     */
    public com.google.cloud.devicestreaming.v1.DeviceSession updateDeviceSession(
        com.google.cloud.devicestreaming.v1.UpdateDeviceSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDeviceSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exposes an ADB connection if the device supports ADB.
     * gRPC headers are used to authenticate the Connect RPC, as well as
     * associate to a particular DeviceSession.
     * In particular, the user must specify the "X-Omnilab-Session-Name" header.
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<
            com.google.cloud.devicestreaming.v1.AdbMessage,
            com.google.cloud.devicestreaming.v1.DeviceMessage>
        adbConnect() {
      return io.grpc.stub.ClientCalls.blockingBidiStreamingCall(
          getChannel(), getAdbConnectMethod(), getCallOptions());
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service DirectAccessService.
   *
   * <pre>
   * A service for allocating Android devices and interacting with the
   * live-allocated devices.
   * Each Session will wait for available capacity, at a higher
   * priority over Test Execution. When allocated, the session will be exposed
   * through a stream for integration.
   * DirectAccessService is currently available as a preview to select developers.
   * You can register today on behalf of you and your team at
   * https://developer.android.com/studio/preview/android-device-streaming
   * </pre>
   */
  public static final class DirectAccessServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DirectAccessServiceBlockingStub> {
    private DirectAccessServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DirectAccessServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DirectAccessServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a DeviceSession.
     * </pre>
     */
    public com.google.cloud.devicestreaming.v1.DeviceSession createDeviceSession(
        com.google.cloud.devicestreaming.v1.CreateDeviceSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDeviceSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DeviceSessions owned by the project user.
     * </pre>
     */
    public com.google.cloud.devicestreaming.v1.ListDeviceSessionsResponse listDeviceSessions(
        com.google.cloud.devicestreaming.v1.ListDeviceSessionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDeviceSessionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a DeviceSession, which documents the allocation status and
     * whether the device is allocated. Clients making requests from this API
     * must poll GetDeviceSession.
     * </pre>
     */
    public com.google.cloud.devicestreaming.v1.DeviceSession getDeviceSession(
        com.google.cloud.devicestreaming.v1.GetDeviceSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDeviceSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Cancel a DeviceSession.
     * This RPC changes the DeviceSession to state FINISHED and terminates all
     * connections.
     * Canceled sessions are not deleted and can be retrieved or
     * listed by the user until they expire based on the 28 day deletion policy.
     * </pre>
     */
    public com.google.protobuf.Empty cancelDeviceSession(
        com.google.cloud.devicestreaming.v1.CancelDeviceSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelDeviceSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the current DeviceSession to the fields described by the
     * update_mask.
     * </pre>
     */
    public com.google.cloud.devicestreaming.v1.DeviceSession updateDeviceSession(
        com.google.cloud.devicestreaming.v1.UpdateDeviceSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDeviceSessionMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DirectAccessService.
   *
   * <pre>
   * A service for allocating Android devices and interacting with the
   * live-allocated devices.
   * Each Session will wait for available capacity, at a higher
   * priority over Test Execution. When allocated, the session will be exposed
   * through a stream for integration.
   * DirectAccessService is currently available as a preview to select developers.
   * You can register today on behalf of you and your team at
   * https://developer.android.com/studio/preview/android-device-streaming
   * </pre>
   */
  public static final class DirectAccessServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DirectAccessServiceFutureStub> {
    private DirectAccessServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DirectAccessServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DirectAccessServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a DeviceSession.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.devicestreaming.v1.DeviceSession>
        createDeviceSession(
            com.google.cloud.devicestreaming.v1.CreateDeviceSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDeviceSessionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DeviceSessions owned by the project user.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.devicestreaming.v1.ListDeviceSessionsResponse>
        listDeviceSessions(com.google.cloud.devicestreaming.v1.ListDeviceSessionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDeviceSessionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a DeviceSession, which documents the allocation status and
     * whether the device is allocated. Clients making requests from this API
     * must poll GetDeviceSession.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.devicestreaming.v1.DeviceSession>
        getDeviceSession(com.google.cloud.devicestreaming.v1.GetDeviceSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDeviceSessionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Cancel a DeviceSession.
     * This RPC changes the DeviceSession to state FINISHED and terminates all
     * connections.
     * Canceled sessions are not deleted and can be retrieved or
     * listed by the user until they expire based on the 28 day deletion policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        cancelDeviceSession(
            com.google.cloud.devicestreaming.v1.CancelDeviceSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelDeviceSessionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the current DeviceSession to the fields described by the
     * update_mask.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.devicestreaming.v1.DeviceSession>
        updateDeviceSession(
            com.google.cloud.devicestreaming.v1.UpdateDeviceSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDeviceSessionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_DEVICE_SESSION = 0;
  private static final int METHODID_LIST_DEVICE_SESSIONS = 1;
  private static final int METHODID_GET_DEVICE_SESSION = 2;
  private static final int METHODID_CANCEL_DEVICE_SESSION = 3;
  private static final int METHODID_UPDATE_DEVICE_SESSION = 4;
  private static final int METHODID_ADB_CONNECT = 5;

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
        case METHODID_CREATE_DEVICE_SESSION:
          serviceImpl.createDeviceSession(
              (com.google.cloud.devicestreaming.v1.CreateDeviceSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.devicestreaming.v1.DeviceSession>)
                  responseObserver);
          break;
        case METHODID_LIST_DEVICE_SESSIONS:
          serviceImpl.listDeviceSessions(
              (com.google.cloud.devicestreaming.v1.ListDeviceSessionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.devicestreaming.v1.ListDeviceSessionsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DEVICE_SESSION:
          serviceImpl.getDeviceSession(
              (com.google.cloud.devicestreaming.v1.GetDeviceSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.devicestreaming.v1.DeviceSession>)
                  responseObserver);
          break;
        case METHODID_CANCEL_DEVICE_SESSION:
          serviceImpl.cancelDeviceSession(
              (com.google.cloud.devicestreaming.v1.CancelDeviceSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_DEVICE_SESSION:
          serviceImpl.updateDeviceSession(
              (com.google.cloud.devicestreaming.v1.UpdateDeviceSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.devicestreaming.v1.DeviceSession>)
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
        case METHODID_ADB_CONNECT:
          return (io.grpc.stub.StreamObserver<Req>)
              serviceImpl.adbConnect(
                  (io.grpc.stub.StreamObserver<com.google.cloud.devicestreaming.v1.DeviceMessage>)
                      responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getCreateDeviceSessionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.devicestreaming.v1.CreateDeviceSessionRequest,
                    com.google.cloud.devicestreaming.v1.DeviceSession>(
                    service, METHODID_CREATE_DEVICE_SESSION)))
        .addMethod(
            getListDeviceSessionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.devicestreaming.v1.ListDeviceSessionsRequest,
                    com.google.cloud.devicestreaming.v1.ListDeviceSessionsResponse>(
                    service, METHODID_LIST_DEVICE_SESSIONS)))
        .addMethod(
            getGetDeviceSessionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.devicestreaming.v1.GetDeviceSessionRequest,
                    com.google.cloud.devicestreaming.v1.DeviceSession>(
                    service, METHODID_GET_DEVICE_SESSION)))
        .addMethod(
            getCancelDeviceSessionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.devicestreaming.v1.CancelDeviceSessionRequest,
                    com.google.protobuf.Empty>(service, METHODID_CANCEL_DEVICE_SESSION)))
        .addMethod(
            getUpdateDeviceSessionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.devicestreaming.v1.UpdateDeviceSessionRequest,
                    com.google.cloud.devicestreaming.v1.DeviceSession>(
                    service, METHODID_UPDATE_DEVICE_SESSION)))
        .addMethod(
            getAdbConnectMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
                new MethodHandlers<
                    com.google.cloud.devicestreaming.v1.AdbMessage,
                    com.google.cloud.devicestreaming.v1.DeviceMessage>(
                    service, METHODID_ADB_CONNECT)))
        .build();
  }

  private abstract static class DirectAccessServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DirectAccessServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.devicestreaming.v1.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DirectAccessService");
    }
  }

  private static final class DirectAccessServiceFileDescriptorSupplier
      extends DirectAccessServiceBaseDescriptorSupplier {
    DirectAccessServiceFileDescriptorSupplier() {}
  }

  private static final class DirectAccessServiceMethodDescriptorSupplier
      extends DirectAccessServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DirectAccessServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DirectAccessServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DirectAccessServiceFileDescriptorSupplier())
                      .addMethod(getCreateDeviceSessionMethod())
                      .addMethod(getListDeviceSessionsMethod())
                      .addMethod(getGetDeviceSessionMethod())
                      .addMethod(getCancelDeviceSessionMethod())
                      .addMethod(getUpdateDeviceSessionMethod())
                      .addMethod(getAdbConnectMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
