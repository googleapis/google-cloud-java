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
package com.google.devtools.cloudprofiler.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Manage the collection of continuous profiling data provided by profiling
 * agents running in the cloud or by an offline provider of profiling data.
 * General guidelines:
 * * Profiles for a single deployment must be created in ascending time order.
 * * Profiles can be created in either online or offline mode, see below.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/devtools/cloudprofiler/v2/profiler.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ProfilerServiceGrpc {

  private ProfilerServiceGrpc() {}

  public static final String SERVICE_NAME = "google.devtools.cloudprofiler.v2.ProfilerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.cloudprofiler.v2.CreateProfileRequest,
          com.google.devtools.cloudprofiler.v2.Profile>
      getCreateProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateProfile",
      requestType = com.google.devtools.cloudprofiler.v2.CreateProfileRequest.class,
      responseType = com.google.devtools.cloudprofiler.v2.Profile.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.cloudprofiler.v2.CreateProfileRequest,
          com.google.devtools.cloudprofiler.v2.Profile>
      getCreateProfileMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.cloudprofiler.v2.CreateProfileRequest,
            com.google.devtools.cloudprofiler.v2.Profile>
        getCreateProfileMethod;
    if ((getCreateProfileMethod = ProfilerServiceGrpc.getCreateProfileMethod) == null) {
      synchronized (ProfilerServiceGrpc.class) {
        if ((getCreateProfileMethod = ProfilerServiceGrpc.getCreateProfileMethod) == null) {
          ProfilerServiceGrpc.getCreateProfileMethod =
              getCreateProfileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.cloudprofiler.v2.CreateProfileRequest,
                          com.google.devtools.cloudprofiler.v2.Profile>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateProfile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.cloudprofiler.v2.CreateProfileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.cloudprofiler.v2.Profile.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProfilerServiceMethodDescriptorSupplier("CreateProfile"))
                      .build();
        }
      }
    }
    return getCreateProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.cloudprofiler.v2.CreateOfflineProfileRequest,
          com.google.devtools.cloudprofiler.v2.Profile>
      getCreateOfflineProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateOfflineProfile",
      requestType = com.google.devtools.cloudprofiler.v2.CreateOfflineProfileRequest.class,
      responseType = com.google.devtools.cloudprofiler.v2.Profile.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.cloudprofiler.v2.CreateOfflineProfileRequest,
          com.google.devtools.cloudprofiler.v2.Profile>
      getCreateOfflineProfileMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.cloudprofiler.v2.CreateOfflineProfileRequest,
            com.google.devtools.cloudprofiler.v2.Profile>
        getCreateOfflineProfileMethod;
    if ((getCreateOfflineProfileMethod = ProfilerServiceGrpc.getCreateOfflineProfileMethod)
        == null) {
      synchronized (ProfilerServiceGrpc.class) {
        if ((getCreateOfflineProfileMethod = ProfilerServiceGrpc.getCreateOfflineProfileMethod)
            == null) {
          ProfilerServiceGrpc.getCreateOfflineProfileMethod =
              getCreateOfflineProfileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.cloudprofiler.v2.CreateOfflineProfileRequest,
                          com.google.devtools.cloudprofiler.v2.Profile>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateOfflineProfile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.cloudprofiler.v2.CreateOfflineProfileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.cloudprofiler.v2.Profile.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProfilerServiceMethodDescriptorSupplier("CreateOfflineProfile"))
                      .build();
        }
      }
    }
    return getCreateOfflineProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.cloudprofiler.v2.UpdateProfileRequest,
          com.google.devtools.cloudprofiler.v2.Profile>
      getUpdateProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateProfile",
      requestType = com.google.devtools.cloudprofiler.v2.UpdateProfileRequest.class,
      responseType = com.google.devtools.cloudprofiler.v2.Profile.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.cloudprofiler.v2.UpdateProfileRequest,
          com.google.devtools.cloudprofiler.v2.Profile>
      getUpdateProfileMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.cloudprofiler.v2.UpdateProfileRequest,
            com.google.devtools.cloudprofiler.v2.Profile>
        getUpdateProfileMethod;
    if ((getUpdateProfileMethod = ProfilerServiceGrpc.getUpdateProfileMethod) == null) {
      synchronized (ProfilerServiceGrpc.class) {
        if ((getUpdateProfileMethod = ProfilerServiceGrpc.getUpdateProfileMethod) == null) {
          ProfilerServiceGrpc.getUpdateProfileMethod =
              getUpdateProfileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.cloudprofiler.v2.UpdateProfileRequest,
                          com.google.devtools.cloudprofiler.v2.Profile>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateProfile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.cloudprofiler.v2.UpdateProfileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.cloudprofiler.v2.Profile.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProfilerServiceMethodDescriptorSupplier("UpdateProfile"))
                      .build();
        }
      }
    }
    return getUpdateProfileMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ProfilerServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProfilerServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProfilerServiceStub>() {
          @java.lang.Override
          public ProfilerServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProfilerServiceStub(channel, callOptions);
          }
        };
    return ProfilerServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProfilerServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProfilerServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProfilerServiceBlockingStub>() {
          @java.lang.Override
          public ProfilerServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProfilerServiceBlockingStub(channel, callOptions);
          }
        };
    return ProfilerServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ProfilerServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProfilerServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProfilerServiceFutureStub>() {
          @java.lang.Override
          public ProfilerServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProfilerServiceFutureStub(channel, callOptions);
          }
        };
    return ProfilerServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Manage the collection of continuous profiling data provided by profiling
   * agents running in the cloud or by an offline provider of profiling data.
   * General guidelines:
   * * Profiles for a single deployment must be created in ascending time order.
   * * Profiles can be created in either online or offline mode, see below.
   * </pre>
   */
  public abstract static class ProfilerServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * CreateProfile creates a new profile resource in the online mode.
     * The server ensures that the new profiles are created at a constant rate per
     * deployment, so the creation request may hang for some time until the next
     * profile session is available.
     * The request may fail with ABORTED error if the creation is not available
     * within ~1m, the response will indicate the duration of the backoff the
     * client should take before attempting creating a profile again. The backoff
     * duration is returned in google.rpc.RetryInfo extension on the response
     * status. To a gRPC client, the extension will be return as a
     * binary-serialized proto in the trailing metadata item named
     * "google.rpc.retryinfo-bin".
     * </pre>
     */
    public void createProfile(
        com.google.devtools.cloudprofiler.v2.CreateProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.cloudprofiler.v2.Profile>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateProfileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * CreateOfflineProfile creates a new profile resource in the offline mode.
     * The client provides the profile to create along with the profile bytes, the
     * server records it.
     * </pre>
     */
    public void createOfflineProfile(
        com.google.devtools.cloudprofiler.v2.CreateOfflineProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.cloudprofiler.v2.Profile>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateOfflineProfileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * UpdateProfile updates the profile bytes and labels on the profile resource
     * created in the online mode. Updating the bytes for profiles created in the
     * offline mode is currently not supported: the profile content must be
     * provided at the time of the profile creation.
     * </pre>
     */
    public void updateProfile(
        com.google.devtools.cloudprofiler.v2.UpdateProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.cloudprofiler.v2.Profile>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateProfileMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateProfileMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.cloudprofiler.v2.CreateProfileRequest,
                      com.google.devtools.cloudprofiler.v2.Profile>(this, METHODID_CREATE_PROFILE)))
          .addMethod(
              getCreateOfflineProfileMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.cloudprofiler.v2.CreateOfflineProfileRequest,
                      com.google.devtools.cloudprofiler.v2.Profile>(
                      this, METHODID_CREATE_OFFLINE_PROFILE)))
          .addMethod(
              getUpdateProfileMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.cloudprofiler.v2.UpdateProfileRequest,
                      com.google.devtools.cloudprofiler.v2.Profile>(this, METHODID_UPDATE_PROFILE)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Manage the collection of continuous profiling data provided by profiling
   * agents running in the cloud or by an offline provider of profiling data.
   * General guidelines:
   * * Profiles for a single deployment must be created in ascending time order.
   * * Profiles can be created in either online or offline mode, see below.
   * </pre>
   */
  public static final class ProfilerServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ProfilerServiceStub> {
    private ProfilerServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProfilerServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProfilerServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * CreateProfile creates a new profile resource in the online mode.
     * The server ensures that the new profiles are created at a constant rate per
     * deployment, so the creation request may hang for some time until the next
     * profile session is available.
     * The request may fail with ABORTED error if the creation is not available
     * within ~1m, the response will indicate the duration of the backoff the
     * client should take before attempting creating a profile again. The backoff
     * duration is returned in google.rpc.RetryInfo extension on the response
     * status. To a gRPC client, the extension will be return as a
     * binary-serialized proto in the trailing metadata item named
     * "google.rpc.retryinfo-bin".
     * </pre>
     */
    public void createProfile(
        com.google.devtools.cloudprofiler.v2.CreateProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.cloudprofiler.v2.Profile>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateProfileMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * CreateOfflineProfile creates a new profile resource in the offline mode.
     * The client provides the profile to create along with the profile bytes, the
     * server records it.
     * </pre>
     */
    public void createOfflineProfile(
        com.google.devtools.cloudprofiler.v2.CreateOfflineProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.cloudprofiler.v2.Profile>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateOfflineProfileMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * UpdateProfile updates the profile bytes and labels on the profile resource
     * created in the online mode. Updating the bytes for profiles created in the
     * offline mode is currently not supported: the profile content must be
     * provided at the time of the profile creation.
     * </pre>
     */
    public void updateProfile(
        com.google.devtools.cloudprofiler.v2.UpdateProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.cloudprofiler.v2.Profile>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateProfileMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Manage the collection of continuous profiling data provided by profiling
   * agents running in the cloud or by an offline provider of profiling data.
   * General guidelines:
   * * Profiles for a single deployment must be created in ascending time order.
   * * Profiles can be created in either online or offline mode, see below.
   * </pre>
   */
  public static final class ProfilerServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ProfilerServiceBlockingStub> {
    private ProfilerServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProfilerServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProfilerServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * CreateProfile creates a new profile resource in the online mode.
     * The server ensures that the new profiles are created at a constant rate per
     * deployment, so the creation request may hang for some time until the next
     * profile session is available.
     * The request may fail with ABORTED error if the creation is not available
     * within ~1m, the response will indicate the duration of the backoff the
     * client should take before attempting creating a profile again. The backoff
     * duration is returned in google.rpc.RetryInfo extension on the response
     * status. To a gRPC client, the extension will be return as a
     * binary-serialized proto in the trailing metadata item named
     * "google.rpc.retryinfo-bin".
     * </pre>
     */
    public com.google.devtools.cloudprofiler.v2.Profile createProfile(
        com.google.devtools.cloudprofiler.v2.CreateProfileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateProfileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * CreateOfflineProfile creates a new profile resource in the offline mode.
     * The client provides the profile to create along with the profile bytes, the
     * server records it.
     * </pre>
     */
    public com.google.devtools.cloudprofiler.v2.Profile createOfflineProfile(
        com.google.devtools.cloudprofiler.v2.CreateOfflineProfileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateOfflineProfileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * UpdateProfile updates the profile bytes and labels on the profile resource
     * created in the online mode. Updating the bytes for profiles created in the
     * offline mode is currently not supported: the profile content must be
     * provided at the time of the profile creation.
     * </pre>
     */
    public com.google.devtools.cloudprofiler.v2.Profile updateProfile(
        com.google.devtools.cloudprofiler.v2.UpdateProfileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateProfileMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Manage the collection of continuous profiling data provided by profiling
   * agents running in the cloud or by an offline provider of profiling data.
   * General guidelines:
   * * Profiles for a single deployment must be created in ascending time order.
   * * Profiles can be created in either online or offline mode, see below.
   * </pre>
   */
  public static final class ProfilerServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ProfilerServiceFutureStub> {
    private ProfilerServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProfilerServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProfilerServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * CreateProfile creates a new profile resource in the online mode.
     * The server ensures that the new profiles are created at a constant rate per
     * deployment, so the creation request may hang for some time until the next
     * profile session is available.
     * The request may fail with ABORTED error if the creation is not available
     * within ~1m, the response will indicate the duration of the backoff the
     * client should take before attempting creating a profile again. The backoff
     * duration is returned in google.rpc.RetryInfo extension on the response
     * status. To a gRPC client, the extension will be return as a
     * binary-serialized proto in the trailing metadata item named
     * "google.rpc.retryinfo-bin".
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.cloudprofiler.v2.Profile>
        createProfile(com.google.devtools.cloudprofiler.v2.CreateProfileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateProfileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * CreateOfflineProfile creates a new profile resource in the offline mode.
     * The client provides the profile to create along with the profile bytes, the
     * server records it.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.cloudprofiler.v2.Profile>
        createOfflineProfile(
            com.google.devtools.cloudprofiler.v2.CreateOfflineProfileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateOfflineProfileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * UpdateProfile updates the profile bytes and labels on the profile resource
     * created in the online mode. Updating the bytes for profiles created in the
     * offline mode is currently not supported: the profile content must be
     * provided at the time of the profile creation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.cloudprofiler.v2.Profile>
        updateProfile(com.google.devtools.cloudprofiler.v2.UpdateProfileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateProfileMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_PROFILE = 0;
  private static final int METHODID_CREATE_OFFLINE_PROFILE = 1;
  private static final int METHODID_UPDATE_PROFILE = 2;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProfilerServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProfilerServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_PROFILE:
          serviceImpl.createProfile(
              (com.google.devtools.cloudprofiler.v2.CreateProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.cloudprofiler.v2.Profile>)
                  responseObserver);
          break;
        case METHODID_CREATE_OFFLINE_PROFILE:
          serviceImpl.createOfflineProfile(
              (com.google.devtools.cloudprofiler.v2.CreateOfflineProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.cloudprofiler.v2.Profile>)
                  responseObserver);
          break;
        case METHODID_UPDATE_PROFILE:
          serviceImpl.updateProfile(
              (com.google.devtools.cloudprofiler.v2.UpdateProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.cloudprofiler.v2.Profile>)
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

  private abstract static class ProfilerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProfilerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.devtools.cloudprofiler.v2.ProfilerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProfilerService");
    }
  }

  private static final class ProfilerServiceFileDescriptorSupplier
      extends ProfilerServiceBaseDescriptorSupplier {
    ProfilerServiceFileDescriptorSupplier() {}
  }

  private static final class ProfilerServiceMethodDescriptorSupplier
      extends ProfilerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProfilerServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ProfilerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ProfilerServiceFileDescriptorSupplier())
                      .addMethod(getCreateProfileMethod())
                      .addMethod(getCreateOfflineProfileMethod())
                      .addMethod(getUpdateProfileMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
