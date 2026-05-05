/*
 * Copyright 2026 Google LLC
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
package com.google.devicesandservices.health.v4;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Health Profile Service
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class HealthProfileServiceGrpc {

  private HealthProfileServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.devicesandservices.health.v4.HealthProfileService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.GetProfileRequest,
          com.google.devicesandservices.health.v4.Profile>
      getGetProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProfile",
      requestType = com.google.devicesandservices.health.v4.GetProfileRequest.class,
      responseType = com.google.devicesandservices.health.v4.Profile.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.GetProfileRequest,
          com.google.devicesandservices.health.v4.Profile>
      getGetProfileMethod() {
    io.grpc.MethodDescriptor<
            com.google.devicesandservices.health.v4.GetProfileRequest,
            com.google.devicesandservices.health.v4.Profile>
        getGetProfileMethod;
    if ((getGetProfileMethod = HealthProfileServiceGrpc.getGetProfileMethod) == null) {
      synchronized (HealthProfileServiceGrpc.class) {
        if ((getGetProfileMethod = HealthProfileServiceGrpc.getGetProfileMethod) == null) {
          HealthProfileServiceGrpc.getGetProfileMethod =
              getGetProfileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devicesandservices.health.v4.GetProfileRequest,
                          com.google.devicesandservices.health.v4.Profile>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProfile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.GetProfileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.Profile.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HealthProfileServiceMethodDescriptorSupplier("GetProfile"))
                      .build();
        }
      }
    }
    return getGetProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.UpdateProfileRequest,
          com.google.devicesandservices.health.v4.Profile>
      getUpdateProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateProfile",
      requestType = com.google.devicesandservices.health.v4.UpdateProfileRequest.class,
      responseType = com.google.devicesandservices.health.v4.Profile.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.UpdateProfileRequest,
          com.google.devicesandservices.health.v4.Profile>
      getUpdateProfileMethod() {
    io.grpc.MethodDescriptor<
            com.google.devicesandservices.health.v4.UpdateProfileRequest,
            com.google.devicesandservices.health.v4.Profile>
        getUpdateProfileMethod;
    if ((getUpdateProfileMethod = HealthProfileServiceGrpc.getUpdateProfileMethod) == null) {
      synchronized (HealthProfileServiceGrpc.class) {
        if ((getUpdateProfileMethod = HealthProfileServiceGrpc.getUpdateProfileMethod) == null) {
          HealthProfileServiceGrpc.getUpdateProfileMethod =
              getUpdateProfileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devicesandservices.health.v4.UpdateProfileRequest,
                          com.google.devicesandservices.health.v4.Profile>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateProfile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.UpdateProfileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.Profile.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HealthProfileServiceMethodDescriptorSupplier("UpdateProfile"))
                      .build();
        }
      }
    }
    return getUpdateProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.GetSettingsRequest,
          com.google.devicesandservices.health.v4.Settings>
      getGetSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSettings",
      requestType = com.google.devicesandservices.health.v4.GetSettingsRequest.class,
      responseType = com.google.devicesandservices.health.v4.Settings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.GetSettingsRequest,
          com.google.devicesandservices.health.v4.Settings>
      getGetSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.devicesandservices.health.v4.GetSettingsRequest,
            com.google.devicesandservices.health.v4.Settings>
        getGetSettingsMethod;
    if ((getGetSettingsMethod = HealthProfileServiceGrpc.getGetSettingsMethod) == null) {
      synchronized (HealthProfileServiceGrpc.class) {
        if ((getGetSettingsMethod = HealthProfileServiceGrpc.getGetSettingsMethod) == null) {
          HealthProfileServiceGrpc.getGetSettingsMethod =
              getGetSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devicesandservices.health.v4.GetSettingsRequest,
                          com.google.devicesandservices.health.v4.Settings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.GetSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.Settings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HealthProfileServiceMethodDescriptorSupplier("GetSettings"))
                      .build();
        }
      }
    }
    return getGetSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.UpdateSettingsRequest,
          com.google.devicesandservices.health.v4.Settings>
      getUpdateSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSettings",
      requestType = com.google.devicesandservices.health.v4.UpdateSettingsRequest.class,
      responseType = com.google.devicesandservices.health.v4.Settings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.UpdateSettingsRequest,
          com.google.devicesandservices.health.v4.Settings>
      getUpdateSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.devicesandservices.health.v4.UpdateSettingsRequest,
            com.google.devicesandservices.health.v4.Settings>
        getUpdateSettingsMethod;
    if ((getUpdateSettingsMethod = HealthProfileServiceGrpc.getUpdateSettingsMethod) == null) {
      synchronized (HealthProfileServiceGrpc.class) {
        if ((getUpdateSettingsMethod = HealthProfileServiceGrpc.getUpdateSettingsMethod) == null) {
          HealthProfileServiceGrpc.getUpdateSettingsMethod =
              getUpdateSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devicesandservices.health.v4.UpdateSettingsRequest,
                          com.google.devicesandservices.health.v4.Settings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.UpdateSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.Settings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HealthProfileServiceMethodDescriptorSupplier("UpdateSettings"))
                      .build();
        }
      }
    }
    return getUpdateSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.GetIdentityRequest,
          com.google.devicesandservices.health.v4.Identity>
      getGetIdentityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIdentity",
      requestType = com.google.devicesandservices.health.v4.GetIdentityRequest.class,
      responseType = com.google.devicesandservices.health.v4.Identity.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.GetIdentityRequest,
          com.google.devicesandservices.health.v4.Identity>
      getGetIdentityMethod() {
    io.grpc.MethodDescriptor<
            com.google.devicesandservices.health.v4.GetIdentityRequest,
            com.google.devicesandservices.health.v4.Identity>
        getGetIdentityMethod;
    if ((getGetIdentityMethod = HealthProfileServiceGrpc.getGetIdentityMethod) == null) {
      synchronized (HealthProfileServiceGrpc.class) {
        if ((getGetIdentityMethod = HealthProfileServiceGrpc.getGetIdentityMethod) == null) {
          HealthProfileServiceGrpc.getGetIdentityMethod =
              getGetIdentityMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devicesandservices.health.v4.GetIdentityRequest,
                          com.google.devicesandservices.health.v4.Identity>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIdentity"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.GetIdentityRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.Identity
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HealthProfileServiceMethodDescriptorSupplier("GetIdentity"))
                      .build();
        }
      }
    }
    return getGetIdentityMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static HealthProfileServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HealthProfileServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<HealthProfileServiceStub>() {
          @java.lang.Override
          public HealthProfileServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new HealthProfileServiceStub(channel, callOptions);
          }
        };
    return HealthProfileServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static HealthProfileServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HealthProfileServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<HealthProfileServiceBlockingV2Stub>() {
          @java.lang.Override
          public HealthProfileServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new HealthProfileServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return HealthProfileServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HealthProfileServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HealthProfileServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<HealthProfileServiceBlockingStub>() {
          @java.lang.Override
          public HealthProfileServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new HealthProfileServiceBlockingStub(channel, callOptions);
          }
        };
    return HealthProfileServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static HealthProfileServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HealthProfileServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<HealthProfileServiceFutureStub>() {
          @java.lang.Override
          public HealthProfileServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new HealthProfileServiceFutureStub(channel, callOptions);
          }
        };
    return HealthProfileServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Health Profile Service
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Returns user Profile details.
     * </pre>
     */
    default void getProfile(
        com.google.devicesandservices.health.v4.GetProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.devicesandservices.health.v4.Profile>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetProfileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the user's profile details.
     * </pre>
     */
    default void updateProfile(
        com.google.devicesandservices.health.v4.UpdateProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.devicesandservices.health.v4.Profile>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateProfileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns user settings details.
     * </pre>
     */
    default void getSettings(
        com.google.devicesandservices.health.v4.GetSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.devicesandservices.health.v4.Settings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the user's settings details.
     * </pre>
     */
    default void updateSettings(
        com.google.devicesandservices.health.v4.UpdateSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.devicesandservices.health.v4.Settings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the user's identity.
     * It includes the legacy Fitbit user ID and the Google user ID and it can be
     * used by migrating clients to map identifiers between the two systems.
     * </pre>
     */
    default void getIdentity(
        com.google.devicesandservices.health.v4.GetIdentityRequest request,
        io.grpc.stub.StreamObserver<com.google.devicesandservices.health.v4.Identity>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetIdentityMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service HealthProfileService.
   *
   * <pre>
   * Health Profile Service
   * </pre>
   */
  public abstract static class HealthProfileServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return HealthProfileServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service HealthProfileService.
   *
   * <pre>
   * Health Profile Service
   * </pre>
   */
  public static final class HealthProfileServiceStub
      extends io.grpc.stub.AbstractAsyncStub<HealthProfileServiceStub> {
    private HealthProfileServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HealthProfileServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HealthProfileServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns user Profile details.
     * </pre>
     */
    public void getProfile(
        com.google.devicesandservices.health.v4.GetProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.devicesandservices.health.v4.Profile>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProfileMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the user's profile details.
     * </pre>
     */
    public void updateProfile(
        com.google.devicesandservices.health.v4.UpdateProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.devicesandservices.health.v4.Profile>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateProfileMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns user settings details.
     * </pre>
     */
    public void getSettings(
        com.google.devicesandservices.health.v4.GetSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.devicesandservices.health.v4.Settings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the user's settings details.
     * </pre>
     */
    public void updateSettings(
        com.google.devicesandservices.health.v4.UpdateSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.devicesandservices.health.v4.Settings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the user's identity.
     * It includes the legacy Fitbit user ID and the Google user ID and it can be
     * used by migrating clients to map identifiers between the two systems.
     * </pre>
     */
    public void getIdentity(
        com.google.devicesandservices.health.v4.GetIdentityRequest request,
        io.grpc.stub.StreamObserver<com.google.devicesandservices.health.v4.Identity>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIdentityMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service HealthProfileService.
   *
   * <pre>
   * Health Profile Service
   * </pre>
   */
  public static final class HealthProfileServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<HealthProfileServiceBlockingV2Stub> {
    private HealthProfileServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HealthProfileServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HealthProfileServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns user Profile details.
     * </pre>
     */
    public com.google.devicesandservices.health.v4.Profile getProfile(
        com.google.devicesandservices.health.v4.GetProfileRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetProfileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the user's profile details.
     * </pre>
     */
    public com.google.devicesandservices.health.v4.Profile updateProfile(
        com.google.devicesandservices.health.v4.UpdateProfileRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateProfileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns user settings details.
     * </pre>
     */
    public com.google.devicesandservices.health.v4.Settings getSettings(
        com.google.devicesandservices.health.v4.GetSettingsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the user's settings details.
     * </pre>
     */
    public com.google.devicesandservices.health.v4.Settings updateSettings(
        com.google.devicesandservices.health.v4.UpdateSettingsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the user's identity.
     * It includes the legacy Fitbit user ID and the Google user ID and it can be
     * used by migrating clients to map identifiers between the two systems.
     * </pre>
     */
    public com.google.devicesandservices.health.v4.Identity getIdentity(
        com.google.devicesandservices.health.v4.GetIdentityRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetIdentityMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service HealthProfileService.
   *
   * <pre>
   * Health Profile Service
   * </pre>
   */
  public static final class HealthProfileServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<HealthProfileServiceBlockingStub> {
    private HealthProfileServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HealthProfileServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HealthProfileServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns user Profile details.
     * </pre>
     */
    public com.google.devicesandservices.health.v4.Profile getProfile(
        com.google.devicesandservices.health.v4.GetProfileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProfileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the user's profile details.
     * </pre>
     */
    public com.google.devicesandservices.health.v4.Profile updateProfile(
        com.google.devicesandservices.health.v4.UpdateProfileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateProfileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns user settings details.
     * </pre>
     */
    public com.google.devicesandservices.health.v4.Settings getSettings(
        com.google.devicesandservices.health.v4.GetSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the user's settings details.
     * </pre>
     */
    public com.google.devicesandservices.health.v4.Settings updateSettings(
        com.google.devicesandservices.health.v4.UpdateSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the user's identity.
     * It includes the legacy Fitbit user ID and the Google user ID and it can be
     * used by migrating clients to map identifiers between the two systems.
     * </pre>
     */
    public com.google.devicesandservices.health.v4.Identity getIdentity(
        com.google.devicesandservices.health.v4.GetIdentityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIdentityMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service HealthProfileService.
   *
   * <pre>
   * Health Profile Service
   * </pre>
   */
  public static final class HealthProfileServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<HealthProfileServiceFutureStub> {
    private HealthProfileServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HealthProfileServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HealthProfileServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns user Profile details.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devicesandservices.health.v4.Profile>
        getProfile(com.google.devicesandservices.health.v4.GetProfileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProfileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the user's profile details.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devicesandservices.health.v4.Profile>
        updateProfile(com.google.devicesandservices.health.v4.UpdateProfileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateProfileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns user settings details.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devicesandservices.health.v4.Settings>
        getSettings(com.google.devicesandservices.health.v4.GetSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the user's settings details.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devicesandservices.health.v4.Settings>
        updateSettings(com.google.devicesandservices.health.v4.UpdateSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the user's identity.
     * It includes the legacy Fitbit user ID and the Google user ID and it can be
     * used by migrating clients to map identifiers between the two systems.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devicesandservices.health.v4.Identity>
        getIdentity(com.google.devicesandservices.health.v4.GetIdentityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIdentityMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PROFILE = 0;
  private static final int METHODID_UPDATE_PROFILE = 1;
  private static final int METHODID_GET_SETTINGS = 2;
  private static final int METHODID_UPDATE_SETTINGS = 3;
  private static final int METHODID_GET_IDENTITY = 4;

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
        case METHODID_GET_PROFILE:
          serviceImpl.getProfile(
              (com.google.devicesandservices.health.v4.GetProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devicesandservices.health.v4.Profile>)
                  responseObserver);
          break;
        case METHODID_UPDATE_PROFILE:
          serviceImpl.updateProfile(
              (com.google.devicesandservices.health.v4.UpdateProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devicesandservices.health.v4.Profile>)
                  responseObserver);
          break;
        case METHODID_GET_SETTINGS:
          serviceImpl.getSettings(
              (com.google.devicesandservices.health.v4.GetSettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devicesandservices.health.v4.Settings>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SETTINGS:
          serviceImpl.updateSettings(
              (com.google.devicesandservices.health.v4.UpdateSettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devicesandservices.health.v4.Settings>)
                  responseObserver);
          break;
        case METHODID_GET_IDENTITY:
          serviceImpl.getIdentity(
              (com.google.devicesandservices.health.v4.GetIdentityRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devicesandservices.health.v4.Identity>)
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
            getGetProfileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devicesandservices.health.v4.GetProfileRequest,
                    com.google.devicesandservices.health.v4.Profile>(
                    service, METHODID_GET_PROFILE)))
        .addMethod(
            getUpdateProfileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devicesandservices.health.v4.UpdateProfileRequest,
                    com.google.devicesandservices.health.v4.Profile>(
                    service, METHODID_UPDATE_PROFILE)))
        .addMethod(
            getGetSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devicesandservices.health.v4.GetSettingsRequest,
                    com.google.devicesandservices.health.v4.Settings>(
                    service, METHODID_GET_SETTINGS)))
        .addMethod(
            getUpdateSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devicesandservices.health.v4.UpdateSettingsRequest,
                    com.google.devicesandservices.health.v4.Settings>(
                    service, METHODID_UPDATE_SETTINGS)))
        .addMethod(
            getGetIdentityMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devicesandservices.health.v4.GetIdentityRequest,
                    com.google.devicesandservices.health.v4.Identity>(
                    service, METHODID_GET_IDENTITY)))
        .build();
  }

  private abstract static class HealthProfileServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HealthProfileServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.devicesandservices.health.v4.HealthProfileProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HealthProfileService");
    }
  }

  private static final class HealthProfileServiceFileDescriptorSupplier
      extends HealthProfileServiceBaseDescriptorSupplier {
    HealthProfileServiceFileDescriptorSupplier() {}
  }

  private static final class HealthProfileServiceMethodDescriptorSupplier
      extends HealthProfileServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    HealthProfileServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (HealthProfileServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new HealthProfileServiceFileDescriptorSupplier())
                      .addMethod(getGetProfileMethod())
                      .addMethod(getUpdateProfileMethod())
                      .addMethod(getGetSettingsMethod())
                      .addMethod(getUpdateSettingsMethod())
                      .addMethod(getGetIdentityMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
