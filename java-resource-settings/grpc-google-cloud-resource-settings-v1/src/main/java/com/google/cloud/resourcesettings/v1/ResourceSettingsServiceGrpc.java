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
package com.google.cloud.resourcesettings.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * An interface to interact with resource settings and setting values throughout
 * the resource hierarchy.
 * Services may surface a number of settings for users to control how their
 * resources behave. Values of settings applied on a given Cloud resource are
 * evaluated hierarchically and inherited by all descendants of that resource.
 * For all requests, returns a `google.rpc.Status` with
 * `google.rpc.Code.PERMISSION_DENIED` if the IAM check fails or the `parent`
 * resource is not in a Cloud Organization.
 * For all requests, returns a `google.rpc.Status` with
 * `google.rpc.Code.INVALID_ARGUMENT` if the request is malformed.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/resourcesettings/v1/resource_settings.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ResourceSettingsServiceGrpc {

  private ResourceSettingsServiceGrpc() {}

  public static final String SERVICE_NAME =
      "google.cloud.resourcesettings.v1.ResourceSettingsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.resourcesettings.v1.ListSettingsRequest,
          com.google.cloud.resourcesettings.v1.ListSettingsResponse>
      getListSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSettings",
      requestType = com.google.cloud.resourcesettings.v1.ListSettingsRequest.class,
      responseType = com.google.cloud.resourcesettings.v1.ListSettingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.resourcesettings.v1.ListSettingsRequest,
          com.google.cloud.resourcesettings.v1.ListSettingsResponse>
      getListSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.resourcesettings.v1.ListSettingsRequest,
            com.google.cloud.resourcesettings.v1.ListSettingsResponse>
        getListSettingsMethod;
    if ((getListSettingsMethod = ResourceSettingsServiceGrpc.getListSettingsMethod) == null) {
      synchronized (ResourceSettingsServiceGrpc.class) {
        if ((getListSettingsMethod = ResourceSettingsServiceGrpc.getListSettingsMethod) == null) {
          ResourceSettingsServiceGrpc.getListSettingsMethod =
              getListSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.resourcesettings.v1.ListSettingsRequest,
                          com.google.cloud.resourcesettings.v1.ListSettingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcesettings.v1.ListSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcesettings.v1.ListSettingsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ResourceSettingsServiceMethodDescriptorSupplier("ListSettings"))
                      .build();
        }
      }
    }
    return getListSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.resourcesettings.v1.GetSettingRequest,
          com.google.cloud.resourcesettings.v1.Setting>
      getGetSettingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSetting",
      requestType = com.google.cloud.resourcesettings.v1.GetSettingRequest.class,
      responseType = com.google.cloud.resourcesettings.v1.Setting.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.resourcesettings.v1.GetSettingRequest,
          com.google.cloud.resourcesettings.v1.Setting>
      getGetSettingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.resourcesettings.v1.GetSettingRequest,
            com.google.cloud.resourcesettings.v1.Setting>
        getGetSettingMethod;
    if ((getGetSettingMethod = ResourceSettingsServiceGrpc.getGetSettingMethod) == null) {
      synchronized (ResourceSettingsServiceGrpc.class) {
        if ((getGetSettingMethod = ResourceSettingsServiceGrpc.getGetSettingMethod) == null) {
          ResourceSettingsServiceGrpc.getGetSettingMethod =
              getGetSettingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.resourcesettings.v1.GetSettingRequest,
                          com.google.cloud.resourcesettings.v1.Setting>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSetting"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcesettings.v1.GetSettingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcesettings.v1.Setting.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ResourceSettingsServiceMethodDescriptorSupplier("GetSetting"))
                      .build();
        }
      }
    }
    return getGetSettingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.resourcesettings.v1.UpdateSettingRequest,
          com.google.cloud.resourcesettings.v1.Setting>
      getUpdateSettingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSetting",
      requestType = com.google.cloud.resourcesettings.v1.UpdateSettingRequest.class,
      responseType = com.google.cloud.resourcesettings.v1.Setting.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.resourcesettings.v1.UpdateSettingRequest,
          com.google.cloud.resourcesettings.v1.Setting>
      getUpdateSettingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.resourcesettings.v1.UpdateSettingRequest,
            com.google.cloud.resourcesettings.v1.Setting>
        getUpdateSettingMethod;
    if ((getUpdateSettingMethod = ResourceSettingsServiceGrpc.getUpdateSettingMethod) == null) {
      synchronized (ResourceSettingsServiceGrpc.class) {
        if ((getUpdateSettingMethod = ResourceSettingsServiceGrpc.getUpdateSettingMethod) == null) {
          ResourceSettingsServiceGrpc.getUpdateSettingMethod =
              getUpdateSettingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.resourcesettings.v1.UpdateSettingRequest,
                          com.google.cloud.resourcesettings.v1.Setting>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSetting"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcesettings.v1.UpdateSettingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcesettings.v1.Setting.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ResourceSettingsServiceMethodDescriptorSupplier("UpdateSetting"))
                      .build();
        }
      }
    }
    return getUpdateSettingMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ResourceSettingsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ResourceSettingsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ResourceSettingsServiceStub>() {
          @java.lang.Override
          public ResourceSettingsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ResourceSettingsServiceStub(channel, callOptions);
          }
        };
    return ResourceSettingsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ResourceSettingsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ResourceSettingsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ResourceSettingsServiceBlockingStub>() {
          @java.lang.Override
          public ResourceSettingsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ResourceSettingsServiceBlockingStub(channel, callOptions);
          }
        };
    return ResourceSettingsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ResourceSettingsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ResourceSettingsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ResourceSettingsServiceFutureStub>() {
          @java.lang.Override
          public ResourceSettingsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ResourceSettingsServiceFutureStub(channel, callOptions);
          }
        };
    return ResourceSettingsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * An interface to interact with resource settings and setting values throughout
   * the resource hierarchy.
   * Services may surface a number of settings for users to control how their
   * resources behave. Values of settings applied on a given Cloud resource are
   * evaluated hierarchically and inherited by all descendants of that resource.
   * For all requests, returns a `google.rpc.Status` with
   * `google.rpc.Code.PERMISSION_DENIED` if the IAM check fails or the `parent`
   * resource is not in a Cloud Organization.
   * For all requests, returns a `google.rpc.Status` with
   * `google.rpc.Code.INVALID_ARGUMENT` if the request is malformed.
   * </pre>
   */
  public abstract static class ResourceSettingsServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Lists all the settings that are available on the Cloud resource `parent`.
     * </pre>
     */
    public void listSettings(
        com.google.cloud.resourcesettings.v1.ListSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcesettings.v1.ListSettingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a setting.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * setting does not exist.
     * </pre>
     */
    public void getSetting(
        com.google.cloud.resourcesettings.v1.GetSettingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcesettings.v1.Setting>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSettingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a setting.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * setting does not exist.
     * Returns a `google.rpc.Status` with `google.rpc.Code.FAILED_PRECONDITION` if
     * the setting is flagged as read only.
     * Returns a `google.rpc.Status` with `google.rpc.Code.ABORTED` if the etag
     * supplied in the request does not match the persisted etag of the setting
     * value.
     * On success, the response will contain only `name`, `local_value` and
     * `etag`.  The `metadata` and `effective_value` cannot be updated through
     * this API.
     * Note: the supplied setting will perform a full overwrite of the
     * `local_value` field.
     * </pre>
     */
    public void updateSetting(
        com.google.cloud.resourcesettings.v1.UpdateSettingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcesettings.v1.Setting>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSettingMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListSettingsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.resourcesettings.v1.ListSettingsRequest,
                      com.google.cloud.resourcesettings.v1.ListSettingsResponse>(
                      this, METHODID_LIST_SETTINGS)))
          .addMethod(
              getGetSettingMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.resourcesettings.v1.GetSettingRequest,
                      com.google.cloud.resourcesettings.v1.Setting>(this, METHODID_GET_SETTING)))
          .addMethod(
              getUpdateSettingMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.resourcesettings.v1.UpdateSettingRequest,
                      com.google.cloud.resourcesettings.v1.Setting>(this, METHODID_UPDATE_SETTING)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * An interface to interact with resource settings and setting values throughout
   * the resource hierarchy.
   * Services may surface a number of settings for users to control how their
   * resources behave. Values of settings applied on a given Cloud resource are
   * evaluated hierarchically and inherited by all descendants of that resource.
   * For all requests, returns a `google.rpc.Status` with
   * `google.rpc.Code.PERMISSION_DENIED` if the IAM check fails or the `parent`
   * resource is not in a Cloud Organization.
   * For all requests, returns a `google.rpc.Status` with
   * `google.rpc.Code.INVALID_ARGUMENT` if the request is malformed.
   * </pre>
   */
  public static final class ResourceSettingsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ResourceSettingsServiceStub> {
    private ResourceSettingsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ResourceSettingsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ResourceSettingsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all the settings that are available on the Cloud resource `parent`.
     * </pre>
     */
    public void listSettings(
        com.google.cloud.resourcesettings.v1.ListSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcesettings.v1.ListSettingsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a setting.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * setting does not exist.
     * </pre>
     */
    public void getSetting(
        com.google.cloud.resourcesettings.v1.GetSettingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcesettings.v1.Setting>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSettingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a setting.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * setting does not exist.
     * Returns a `google.rpc.Status` with `google.rpc.Code.FAILED_PRECONDITION` if
     * the setting is flagged as read only.
     * Returns a `google.rpc.Status` with `google.rpc.Code.ABORTED` if the etag
     * supplied in the request does not match the persisted etag of the setting
     * value.
     * On success, the response will contain only `name`, `local_value` and
     * `etag`.  The `metadata` and `effective_value` cannot be updated through
     * this API.
     * Note: the supplied setting will perform a full overwrite of the
     * `local_value` field.
     * </pre>
     */
    public void updateSetting(
        com.google.cloud.resourcesettings.v1.UpdateSettingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcesettings.v1.Setting>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSettingMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * An interface to interact with resource settings and setting values throughout
   * the resource hierarchy.
   * Services may surface a number of settings for users to control how their
   * resources behave. Values of settings applied on a given Cloud resource are
   * evaluated hierarchically and inherited by all descendants of that resource.
   * For all requests, returns a `google.rpc.Status` with
   * `google.rpc.Code.PERMISSION_DENIED` if the IAM check fails or the `parent`
   * resource is not in a Cloud Organization.
   * For all requests, returns a `google.rpc.Status` with
   * `google.rpc.Code.INVALID_ARGUMENT` if the request is malformed.
   * </pre>
   */
  public static final class ResourceSettingsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ResourceSettingsServiceBlockingStub> {
    private ResourceSettingsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ResourceSettingsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ResourceSettingsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all the settings that are available on the Cloud resource `parent`.
     * </pre>
     */
    public com.google.cloud.resourcesettings.v1.ListSettingsResponse listSettings(
        com.google.cloud.resourcesettings.v1.ListSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a setting.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * setting does not exist.
     * </pre>
     */
    public com.google.cloud.resourcesettings.v1.Setting getSetting(
        com.google.cloud.resourcesettings.v1.GetSettingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSettingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a setting.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * setting does not exist.
     * Returns a `google.rpc.Status` with `google.rpc.Code.FAILED_PRECONDITION` if
     * the setting is flagged as read only.
     * Returns a `google.rpc.Status` with `google.rpc.Code.ABORTED` if the etag
     * supplied in the request does not match the persisted etag of the setting
     * value.
     * On success, the response will contain only `name`, `local_value` and
     * `etag`.  The `metadata` and `effective_value` cannot be updated through
     * this API.
     * Note: the supplied setting will perform a full overwrite of the
     * `local_value` field.
     * </pre>
     */
    public com.google.cloud.resourcesettings.v1.Setting updateSetting(
        com.google.cloud.resourcesettings.v1.UpdateSettingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSettingMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * An interface to interact with resource settings and setting values throughout
   * the resource hierarchy.
   * Services may surface a number of settings for users to control how their
   * resources behave. Values of settings applied on a given Cloud resource are
   * evaluated hierarchically and inherited by all descendants of that resource.
   * For all requests, returns a `google.rpc.Status` with
   * `google.rpc.Code.PERMISSION_DENIED` if the IAM check fails or the `parent`
   * resource is not in a Cloud Organization.
   * For all requests, returns a `google.rpc.Status` with
   * `google.rpc.Code.INVALID_ARGUMENT` if the request is malformed.
   * </pre>
   */
  public static final class ResourceSettingsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ResourceSettingsServiceFutureStub> {
    private ResourceSettingsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ResourceSettingsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ResourceSettingsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all the settings that are available on the Cloud resource `parent`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.resourcesettings.v1.ListSettingsResponse>
        listSettings(com.google.cloud.resourcesettings.v1.ListSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a setting.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * setting does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.resourcesettings.v1.Setting>
        getSetting(com.google.cloud.resourcesettings.v1.GetSettingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSettingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a setting.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * setting does not exist.
     * Returns a `google.rpc.Status` with `google.rpc.Code.FAILED_PRECONDITION` if
     * the setting is flagged as read only.
     * Returns a `google.rpc.Status` with `google.rpc.Code.ABORTED` if the etag
     * supplied in the request does not match the persisted etag of the setting
     * value.
     * On success, the response will contain only `name`, `local_value` and
     * `etag`.  The `metadata` and `effective_value` cannot be updated through
     * this API.
     * Note: the supplied setting will perform a full overwrite of the
     * `local_value` field.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.resourcesettings.v1.Setting>
        updateSetting(com.google.cloud.resourcesettings.v1.UpdateSettingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSettingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_SETTINGS = 0;
  private static final int METHODID_GET_SETTING = 1;
  private static final int METHODID_UPDATE_SETTING = 2;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ResourceSettingsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ResourceSettingsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_SETTINGS:
          serviceImpl.listSettings(
              (com.google.cloud.resourcesettings.v1.ListSettingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.resourcesettings.v1.ListSettingsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SETTING:
          serviceImpl.getSetting(
              (com.google.cloud.resourcesettings.v1.GetSettingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.resourcesettings.v1.Setting>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SETTING:
          serviceImpl.updateSetting(
              (com.google.cloud.resourcesettings.v1.UpdateSettingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.resourcesettings.v1.Setting>)
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

  private abstract static class ResourceSettingsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ResourceSettingsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.resourcesettings.v1.ResourceSettingsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ResourceSettingsService");
    }
  }

  private static final class ResourceSettingsServiceFileDescriptorSupplier
      extends ResourceSettingsServiceBaseDescriptorSupplier {
    ResourceSettingsServiceFileDescriptorSupplier() {}
  }

  private static final class ResourceSettingsServiceMethodDescriptorSupplier
      extends ResourceSettingsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ResourceSettingsServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ResourceSettingsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ResourceSettingsServiceFileDescriptorSupplier())
                      .addMethod(getListSettingsMethod())
                      .addMethod(getGetSettingMethod())
                      .addMethod(getUpdateSettingMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
