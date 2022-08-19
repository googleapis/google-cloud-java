package com.google.appengine.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Manages versions of a service.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/appengine/v1/appengine.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class VersionsGrpc {

  private VersionsGrpc() {}

  public static final String SERVICE_NAME = "google.appengine.v1.Versions";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.appengine.v1.ListVersionsRequest,
      com.google.appengine.v1.ListVersionsResponse> getListVersionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListVersions",
      requestType = com.google.appengine.v1.ListVersionsRequest.class,
      responseType = com.google.appengine.v1.ListVersionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.appengine.v1.ListVersionsRequest,
      com.google.appengine.v1.ListVersionsResponse> getListVersionsMethod() {
    io.grpc.MethodDescriptor<com.google.appengine.v1.ListVersionsRequest, com.google.appengine.v1.ListVersionsResponse> getListVersionsMethod;
    if ((getListVersionsMethod = VersionsGrpc.getListVersionsMethod) == null) {
      synchronized (VersionsGrpc.class) {
        if ((getListVersionsMethod = VersionsGrpc.getListVersionsMethod) == null) {
          VersionsGrpc.getListVersionsMethod = getListVersionsMethod =
              io.grpc.MethodDescriptor.<com.google.appengine.v1.ListVersionsRequest, com.google.appengine.v1.ListVersionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListVersions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.ListVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.ListVersionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new VersionsMethodDescriptorSupplier("ListVersions"))
              .build();
        }
      }
    }
    return getListVersionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.appengine.v1.GetVersionRequest,
      com.google.appengine.v1.Version> getGetVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetVersion",
      requestType = com.google.appengine.v1.GetVersionRequest.class,
      responseType = com.google.appengine.v1.Version.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.appengine.v1.GetVersionRequest,
      com.google.appengine.v1.Version> getGetVersionMethod() {
    io.grpc.MethodDescriptor<com.google.appengine.v1.GetVersionRequest, com.google.appengine.v1.Version> getGetVersionMethod;
    if ((getGetVersionMethod = VersionsGrpc.getGetVersionMethod) == null) {
      synchronized (VersionsGrpc.class) {
        if ((getGetVersionMethod = VersionsGrpc.getGetVersionMethod) == null) {
          VersionsGrpc.getGetVersionMethod = getGetVersionMethod =
              io.grpc.MethodDescriptor.<com.google.appengine.v1.GetVersionRequest, com.google.appengine.v1.Version>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetVersion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.GetVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.Version.getDefaultInstance()))
              .setSchemaDescriptor(new VersionsMethodDescriptorSupplier("GetVersion"))
              .build();
        }
      }
    }
    return getGetVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.appengine.v1.CreateVersionRequest,
      com.google.longrunning.Operation> getCreateVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateVersion",
      requestType = com.google.appengine.v1.CreateVersionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.appengine.v1.CreateVersionRequest,
      com.google.longrunning.Operation> getCreateVersionMethod() {
    io.grpc.MethodDescriptor<com.google.appengine.v1.CreateVersionRequest, com.google.longrunning.Operation> getCreateVersionMethod;
    if ((getCreateVersionMethod = VersionsGrpc.getCreateVersionMethod) == null) {
      synchronized (VersionsGrpc.class) {
        if ((getCreateVersionMethod = VersionsGrpc.getCreateVersionMethod) == null) {
          VersionsGrpc.getCreateVersionMethod = getCreateVersionMethod =
              io.grpc.MethodDescriptor.<com.google.appengine.v1.CreateVersionRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateVersion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.CreateVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new VersionsMethodDescriptorSupplier("CreateVersion"))
              .build();
        }
      }
    }
    return getCreateVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.appengine.v1.UpdateVersionRequest,
      com.google.longrunning.Operation> getUpdateVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateVersion",
      requestType = com.google.appengine.v1.UpdateVersionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.appengine.v1.UpdateVersionRequest,
      com.google.longrunning.Operation> getUpdateVersionMethod() {
    io.grpc.MethodDescriptor<com.google.appengine.v1.UpdateVersionRequest, com.google.longrunning.Operation> getUpdateVersionMethod;
    if ((getUpdateVersionMethod = VersionsGrpc.getUpdateVersionMethod) == null) {
      synchronized (VersionsGrpc.class) {
        if ((getUpdateVersionMethod = VersionsGrpc.getUpdateVersionMethod) == null) {
          VersionsGrpc.getUpdateVersionMethod = getUpdateVersionMethod =
              io.grpc.MethodDescriptor.<com.google.appengine.v1.UpdateVersionRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateVersion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.UpdateVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new VersionsMethodDescriptorSupplier("UpdateVersion"))
              .build();
        }
      }
    }
    return getUpdateVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.appengine.v1.DeleteVersionRequest,
      com.google.longrunning.Operation> getDeleteVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteVersion",
      requestType = com.google.appengine.v1.DeleteVersionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.appengine.v1.DeleteVersionRequest,
      com.google.longrunning.Operation> getDeleteVersionMethod() {
    io.grpc.MethodDescriptor<com.google.appengine.v1.DeleteVersionRequest, com.google.longrunning.Operation> getDeleteVersionMethod;
    if ((getDeleteVersionMethod = VersionsGrpc.getDeleteVersionMethod) == null) {
      synchronized (VersionsGrpc.class) {
        if ((getDeleteVersionMethod = VersionsGrpc.getDeleteVersionMethod) == null) {
          VersionsGrpc.getDeleteVersionMethod = getDeleteVersionMethod =
              io.grpc.MethodDescriptor.<com.google.appengine.v1.DeleteVersionRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteVersion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.DeleteVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new VersionsMethodDescriptorSupplier("DeleteVersion"))
              .build();
        }
      }
    }
    return getDeleteVersionMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static VersionsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VersionsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<VersionsStub>() {
        @java.lang.Override
        public VersionsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new VersionsStub(channel, callOptions);
        }
      };
    return VersionsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static VersionsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VersionsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<VersionsBlockingStub>() {
        @java.lang.Override
        public VersionsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new VersionsBlockingStub(channel, callOptions);
        }
      };
    return VersionsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static VersionsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VersionsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<VersionsFutureStub>() {
        @java.lang.Override
        public VersionsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new VersionsFutureStub(channel, callOptions);
        }
      };
    return VersionsFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Manages versions of a service.
   * </pre>
   */
  public static abstract class VersionsImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists the versions of a service.
     * </pre>
     */
    public void listVersions(com.google.appengine.v1.ListVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.ListVersionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListVersionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the specified Version resource.
     * By default, only a `BASIC_VIEW` will be returned.
     * Specify the `FULL_VIEW` parameter to get the full resource.
     * </pre>
     */
    public void getVersion(com.google.appengine.v1.GetVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.Version> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetVersionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deploys code and resource files to a new version.
     * </pre>
     */
    public void createVersion(com.google.appengine.v1.CreateVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateVersionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the specified Version resource.
     * You can specify the following fields depending on the App Engine
     * environment and type of scaling that the version resource uses:
     * **Standard environment**
     * * [`instance_class`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.instance_class)
     * *automatic scaling* in the standard environment:
     * * [`automatic_scaling.min_idle_instances`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling)
     * * [`automatic_scaling.max_idle_instances`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling)
     * * [`automaticScaling.standard_scheduler_settings.max_instances`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#StandardSchedulerSettings)
     * * [`automaticScaling.standard_scheduler_settings.min_instances`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#StandardSchedulerSettings)
     * * [`automaticScaling.standard_scheduler_settings.target_cpu_utilization`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#StandardSchedulerSettings)
     * * [`automaticScaling.standard_scheduler_settings.target_throughput_utilization`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#StandardSchedulerSettings)
     * *basic scaling* or *manual scaling* in the standard environment:
     * * [`serving_status`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.serving_status)
     * * [`manual_scaling.instances`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#manualscaling)
     * **Flexible environment**
     * * [`serving_status`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.serving_status)
     * *automatic scaling* in the flexible environment:
     * * [`automatic_scaling.min_total_instances`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling)
     * * [`automatic_scaling.max_total_instances`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling)
     * * [`automatic_scaling.cool_down_period_sec`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling)
     * * [`automatic_scaling.cpu_utilization.target_utilization`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling)
     * *manual scaling* in the flexible environment:
     * * [`manual_scaling.instances`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#manualscaling)
     * </pre>
     */
    public void updateVersion(com.google.appengine.v1.UpdateVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateVersionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes an existing Version resource.
     * </pre>
     */
    public void deleteVersion(com.google.appengine.v1.DeleteVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteVersionMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListVersionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.appengine.v1.ListVersionsRequest,
                com.google.appengine.v1.ListVersionsResponse>(
                  this, METHODID_LIST_VERSIONS)))
          .addMethod(
            getGetVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.appengine.v1.GetVersionRequest,
                com.google.appengine.v1.Version>(
                  this, METHODID_GET_VERSION)))
          .addMethod(
            getCreateVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.appengine.v1.CreateVersionRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_VERSION)))
          .addMethod(
            getUpdateVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.appengine.v1.UpdateVersionRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_VERSION)))
          .addMethod(
            getDeleteVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.appengine.v1.DeleteVersionRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_VERSION)))
          .build();
    }
  }

  /**
   * <pre>
   * Manages versions of a service.
   * </pre>
   */
  public static final class VersionsStub extends io.grpc.stub.AbstractAsyncStub<VersionsStub> {
    private VersionsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VersionsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VersionsStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the versions of a service.
     * </pre>
     */
    public void listVersions(com.google.appengine.v1.ListVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.ListVersionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListVersionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the specified Version resource.
     * By default, only a `BASIC_VIEW` will be returned.
     * Specify the `FULL_VIEW` parameter to get the full resource.
     * </pre>
     */
    public void getVersion(com.google.appengine.v1.GetVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.Version> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetVersionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deploys code and resource files to a new version.
     * </pre>
     */
    public void createVersion(com.google.appengine.v1.CreateVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateVersionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the specified Version resource.
     * You can specify the following fields depending on the App Engine
     * environment and type of scaling that the version resource uses:
     * **Standard environment**
     * * [`instance_class`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.instance_class)
     * *automatic scaling* in the standard environment:
     * * [`automatic_scaling.min_idle_instances`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling)
     * * [`automatic_scaling.max_idle_instances`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling)
     * * [`automaticScaling.standard_scheduler_settings.max_instances`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#StandardSchedulerSettings)
     * * [`automaticScaling.standard_scheduler_settings.min_instances`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#StandardSchedulerSettings)
     * * [`automaticScaling.standard_scheduler_settings.target_cpu_utilization`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#StandardSchedulerSettings)
     * * [`automaticScaling.standard_scheduler_settings.target_throughput_utilization`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#StandardSchedulerSettings)
     * *basic scaling* or *manual scaling* in the standard environment:
     * * [`serving_status`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.serving_status)
     * * [`manual_scaling.instances`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#manualscaling)
     * **Flexible environment**
     * * [`serving_status`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.serving_status)
     * *automatic scaling* in the flexible environment:
     * * [`automatic_scaling.min_total_instances`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling)
     * * [`automatic_scaling.max_total_instances`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling)
     * * [`automatic_scaling.cool_down_period_sec`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling)
     * * [`automatic_scaling.cpu_utilization.target_utilization`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling)
     * *manual scaling* in the flexible environment:
     * * [`manual_scaling.instances`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#manualscaling)
     * </pre>
     */
    public void updateVersion(com.google.appengine.v1.UpdateVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateVersionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes an existing Version resource.
     * </pre>
     */
    public void deleteVersion(com.google.appengine.v1.DeleteVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteVersionMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Manages versions of a service.
   * </pre>
   */
  public static final class VersionsBlockingStub extends io.grpc.stub.AbstractBlockingStub<VersionsBlockingStub> {
    private VersionsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VersionsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VersionsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the versions of a service.
     * </pre>
     */
    public com.google.appengine.v1.ListVersionsResponse listVersions(com.google.appengine.v1.ListVersionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListVersionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the specified Version resource.
     * By default, only a `BASIC_VIEW` will be returned.
     * Specify the `FULL_VIEW` parameter to get the full resource.
     * </pre>
     */
    public com.google.appengine.v1.Version getVersion(com.google.appengine.v1.GetVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetVersionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deploys code and resource files to a new version.
     * </pre>
     */
    public com.google.longrunning.Operation createVersion(com.google.appengine.v1.CreateVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateVersionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the specified Version resource.
     * You can specify the following fields depending on the App Engine
     * environment and type of scaling that the version resource uses:
     * **Standard environment**
     * * [`instance_class`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.instance_class)
     * *automatic scaling* in the standard environment:
     * * [`automatic_scaling.min_idle_instances`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling)
     * * [`automatic_scaling.max_idle_instances`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling)
     * * [`automaticScaling.standard_scheduler_settings.max_instances`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#StandardSchedulerSettings)
     * * [`automaticScaling.standard_scheduler_settings.min_instances`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#StandardSchedulerSettings)
     * * [`automaticScaling.standard_scheduler_settings.target_cpu_utilization`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#StandardSchedulerSettings)
     * * [`automaticScaling.standard_scheduler_settings.target_throughput_utilization`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#StandardSchedulerSettings)
     * *basic scaling* or *manual scaling* in the standard environment:
     * * [`serving_status`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.serving_status)
     * * [`manual_scaling.instances`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#manualscaling)
     * **Flexible environment**
     * * [`serving_status`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.serving_status)
     * *automatic scaling* in the flexible environment:
     * * [`automatic_scaling.min_total_instances`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling)
     * * [`automatic_scaling.max_total_instances`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling)
     * * [`automatic_scaling.cool_down_period_sec`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling)
     * * [`automatic_scaling.cpu_utilization.target_utilization`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling)
     * *manual scaling* in the flexible environment:
     * * [`manual_scaling.instances`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#manualscaling)
     * </pre>
     */
    public com.google.longrunning.Operation updateVersion(com.google.appengine.v1.UpdateVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateVersionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes an existing Version resource.
     * </pre>
     */
    public com.google.longrunning.Operation deleteVersion(com.google.appengine.v1.DeleteVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteVersionMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Manages versions of a service.
   * </pre>
   */
  public static final class VersionsFutureStub extends io.grpc.stub.AbstractFutureStub<VersionsFutureStub> {
    private VersionsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VersionsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VersionsFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the versions of a service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.appengine.v1.ListVersionsResponse> listVersions(
        com.google.appengine.v1.ListVersionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListVersionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the specified Version resource.
     * By default, only a `BASIC_VIEW` will be returned.
     * Specify the `FULL_VIEW` parameter to get the full resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.appengine.v1.Version> getVersion(
        com.google.appengine.v1.GetVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetVersionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deploys code and resource files to a new version.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createVersion(
        com.google.appengine.v1.CreateVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateVersionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the specified Version resource.
     * You can specify the following fields depending on the App Engine
     * environment and type of scaling that the version resource uses:
     * **Standard environment**
     * * [`instance_class`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.instance_class)
     * *automatic scaling* in the standard environment:
     * * [`automatic_scaling.min_idle_instances`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling)
     * * [`automatic_scaling.max_idle_instances`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling)
     * * [`automaticScaling.standard_scheduler_settings.max_instances`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#StandardSchedulerSettings)
     * * [`automaticScaling.standard_scheduler_settings.min_instances`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#StandardSchedulerSettings)
     * * [`automaticScaling.standard_scheduler_settings.target_cpu_utilization`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#StandardSchedulerSettings)
     * * [`automaticScaling.standard_scheduler_settings.target_throughput_utilization`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#StandardSchedulerSettings)
     * *basic scaling* or *manual scaling* in the standard environment:
     * * [`serving_status`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.serving_status)
     * * [`manual_scaling.instances`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#manualscaling)
     * **Flexible environment**
     * * [`serving_status`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.serving_status)
     * *automatic scaling* in the flexible environment:
     * * [`automatic_scaling.min_total_instances`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling)
     * * [`automatic_scaling.max_total_instances`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling)
     * * [`automatic_scaling.cool_down_period_sec`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling)
     * * [`automatic_scaling.cpu_utilization.target_utilization`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling)
     * *manual scaling* in the flexible environment:
     * * [`manual_scaling.instances`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#manualscaling)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateVersion(
        com.google.appengine.v1.UpdateVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateVersionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes an existing Version resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteVersion(
        com.google.appengine.v1.DeleteVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteVersionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_VERSIONS = 0;
  private static final int METHODID_GET_VERSION = 1;
  private static final int METHODID_CREATE_VERSION = 2;
  private static final int METHODID_UPDATE_VERSION = 3;
  private static final int METHODID_DELETE_VERSION = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final VersionsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(VersionsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_VERSIONS:
          serviceImpl.listVersions((com.google.appengine.v1.ListVersionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.appengine.v1.ListVersionsResponse>) responseObserver);
          break;
        case METHODID_GET_VERSION:
          serviceImpl.getVersion((com.google.appengine.v1.GetVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.appengine.v1.Version>) responseObserver);
          break;
        case METHODID_CREATE_VERSION:
          serviceImpl.createVersion((com.google.appengine.v1.CreateVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_VERSION:
          serviceImpl.updateVersion((com.google.appengine.v1.UpdateVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_VERSION:
          serviceImpl.deleteVersion((com.google.appengine.v1.DeleteVersionRequest) request,
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

  private static abstract class VersionsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    VersionsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.appengine.v1.AppengineProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Versions");
    }
  }

  private static final class VersionsFileDescriptorSupplier
      extends VersionsBaseDescriptorSupplier {
    VersionsFileDescriptorSupplier() {}
  }

  private static final class VersionsMethodDescriptorSupplier
      extends VersionsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    VersionsMethodDescriptorSupplier(String methodName) {
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
      synchronized (VersionsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new VersionsFileDescriptorSupplier())
              .addMethod(getListVersionsMethod())
              .addMethod(getGetVersionMethod())
              .addMethod(getCreateVersionMethod())
              .addMethod(getUpdateVersionMethod())
              .addMethod(getDeleteVersionMethod())
              .build();
        }
      }
    }
    return result;
  }
}
