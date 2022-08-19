package com.google.appengine.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Manages instances of a version.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/appengine/v1/appengine.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class InstancesGrpc {

  private InstancesGrpc() {}

  public static final String SERVICE_NAME = "google.appengine.v1.Instances";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.appengine.v1.ListInstancesRequest,
      com.google.appengine.v1.ListInstancesResponse> getListInstancesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInstances",
      requestType = com.google.appengine.v1.ListInstancesRequest.class,
      responseType = com.google.appengine.v1.ListInstancesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.appengine.v1.ListInstancesRequest,
      com.google.appengine.v1.ListInstancesResponse> getListInstancesMethod() {
    io.grpc.MethodDescriptor<com.google.appengine.v1.ListInstancesRequest, com.google.appengine.v1.ListInstancesResponse> getListInstancesMethod;
    if ((getListInstancesMethod = InstancesGrpc.getListInstancesMethod) == null) {
      synchronized (InstancesGrpc.class) {
        if ((getListInstancesMethod = InstancesGrpc.getListInstancesMethod) == null) {
          InstancesGrpc.getListInstancesMethod = getListInstancesMethod =
              io.grpc.MethodDescriptor.<com.google.appengine.v1.ListInstancesRequest, com.google.appengine.v1.ListInstancesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListInstances"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.ListInstancesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.ListInstancesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InstancesMethodDescriptorSupplier("ListInstances"))
              .build();
        }
      }
    }
    return getListInstancesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.appengine.v1.GetInstanceRequest,
      com.google.appengine.v1.Instance> getGetInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInstance",
      requestType = com.google.appengine.v1.GetInstanceRequest.class,
      responseType = com.google.appengine.v1.Instance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.appengine.v1.GetInstanceRequest,
      com.google.appengine.v1.Instance> getGetInstanceMethod() {
    io.grpc.MethodDescriptor<com.google.appengine.v1.GetInstanceRequest, com.google.appengine.v1.Instance> getGetInstanceMethod;
    if ((getGetInstanceMethod = InstancesGrpc.getGetInstanceMethod) == null) {
      synchronized (InstancesGrpc.class) {
        if ((getGetInstanceMethod = InstancesGrpc.getGetInstanceMethod) == null) {
          InstancesGrpc.getGetInstanceMethod = getGetInstanceMethod =
              io.grpc.MethodDescriptor.<com.google.appengine.v1.GetInstanceRequest, com.google.appengine.v1.Instance>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.GetInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.Instance.getDefaultInstance()))
              .setSchemaDescriptor(new InstancesMethodDescriptorSupplier("GetInstance"))
              .build();
        }
      }
    }
    return getGetInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.appengine.v1.DeleteInstanceRequest,
      com.google.longrunning.Operation> getDeleteInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteInstance",
      requestType = com.google.appengine.v1.DeleteInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.appengine.v1.DeleteInstanceRequest,
      com.google.longrunning.Operation> getDeleteInstanceMethod() {
    io.grpc.MethodDescriptor<com.google.appengine.v1.DeleteInstanceRequest, com.google.longrunning.Operation> getDeleteInstanceMethod;
    if ((getDeleteInstanceMethod = InstancesGrpc.getDeleteInstanceMethod) == null) {
      synchronized (InstancesGrpc.class) {
        if ((getDeleteInstanceMethod = InstancesGrpc.getDeleteInstanceMethod) == null) {
          InstancesGrpc.getDeleteInstanceMethod = getDeleteInstanceMethod =
              io.grpc.MethodDescriptor.<com.google.appengine.v1.DeleteInstanceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.DeleteInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new InstancesMethodDescriptorSupplier("DeleteInstance"))
              .build();
        }
      }
    }
    return getDeleteInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.appengine.v1.DebugInstanceRequest,
      com.google.longrunning.Operation> getDebugInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DebugInstance",
      requestType = com.google.appengine.v1.DebugInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.appengine.v1.DebugInstanceRequest,
      com.google.longrunning.Operation> getDebugInstanceMethod() {
    io.grpc.MethodDescriptor<com.google.appengine.v1.DebugInstanceRequest, com.google.longrunning.Operation> getDebugInstanceMethod;
    if ((getDebugInstanceMethod = InstancesGrpc.getDebugInstanceMethod) == null) {
      synchronized (InstancesGrpc.class) {
        if ((getDebugInstanceMethod = InstancesGrpc.getDebugInstanceMethod) == null) {
          InstancesGrpc.getDebugInstanceMethod = getDebugInstanceMethod =
              io.grpc.MethodDescriptor.<com.google.appengine.v1.DebugInstanceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DebugInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.DebugInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new InstancesMethodDescriptorSupplier("DebugInstance"))
              .build();
        }
      }
    }
    return getDebugInstanceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static InstancesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InstancesStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<InstancesStub>() {
        @java.lang.Override
        public InstancesStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new InstancesStub(channel, callOptions);
        }
      };
    return InstancesStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static InstancesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InstancesBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<InstancesBlockingStub>() {
        @java.lang.Override
        public InstancesBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new InstancesBlockingStub(channel, callOptions);
        }
      };
    return InstancesBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static InstancesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InstancesFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<InstancesFutureStub>() {
        @java.lang.Override
        public InstancesFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new InstancesFutureStub(channel, callOptions);
        }
      };
    return InstancesFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Manages instances of a version.
   * </pre>
   */
  public static abstract class InstancesImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists the instances of a version.
     * Tip: To aggregate details about instances over time, see the
     * [Stackdriver Monitoring API](https://cloud.google.com/monitoring/api/ref_v3/rest/v3/projects.timeSeries/list).
     * </pre>
     */
    public void listInstances(com.google.appengine.v1.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.ListInstancesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListInstancesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets instance information.
     * </pre>
     */
    public void getInstance(com.google.appengine.v1.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.Instance> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetInstanceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Stops a running instance.
     * The instance might be automatically recreated based on the scaling settings
     * of the version. For more information, see "How Instances are Managed"
     * ([standard environment](https://cloud.google.com/appengine/docs/standard/python/how-instances-are-managed) |
     * [flexible environment](https://cloud.google.com/appengine/docs/flexible/python/how-instances-are-managed)).
     * To ensure that instances are not re-created and avoid getting billed, you
     * can stop all instances within the target version by changing the serving
     * status of the version to `STOPPED` with the
     * [`apps.services.versions.patch`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions/patch)
     * method.
     * </pre>
     */
    public void deleteInstance(com.google.appengine.v1.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteInstanceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Enables debugging on a VM instance. This allows you to use the SSH
     * command to connect to the virtual machine where the instance lives.
     * While in "debug mode", the instance continues to serve live traffic.
     * You should delete the instance when you are done debugging and then
     * allow the system to take over and determine if another instance
     * should be started.
     * Only applicable for instances in App Engine flexible environment.
     * </pre>
     */
    public void debugInstance(com.google.appengine.v1.DebugInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDebugInstanceMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListInstancesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.appengine.v1.ListInstancesRequest,
                com.google.appengine.v1.ListInstancesResponse>(
                  this, METHODID_LIST_INSTANCES)))
          .addMethod(
            getGetInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.appengine.v1.GetInstanceRequest,
                com.google.appengine.v1.Instance>(
                  this, METHODID_GET_INSTANCE)))
          .addMethod(
            getDeleteInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.appengine.v1.DeleteInstanceRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_INSTANCE)))
          .addMethod(
            getDebugInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.appengine.v1.DebugInstanceRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DEBUG_INSTANCE)))
          .build();
    }
  }

  /**
   * <pre>
   * Manages instances of a version.
   * </pre>
   */
  public static final class InstancesStub extends io.grpc.stub.AbstractAsyncStub<InstancesStub> {
    private InstancesStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InstancesStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InstancesStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the instances of a version.
     * Tip: To aggregate details about instances over time, see the
     * [Stackdriver Monitoring API](https://cloud.google.com/monitoring/api/ref_v3/rest/v3/projects.timeSeries/list).
     * </pre>
     */
    public void listInstances(com.google.appengine.v1.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.ListInstancesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListInstancesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets instance information.
     * </pre>
     */
    public void getInstance(com.google.appengine.v1.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.Instance> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Stops a running instance.
     * The instance might be automatically recreated based on the scaling settings
     * of the version. For more information, see "How Instances are Managed"
     * ([standard environment](https://cloud.google.com/appengine/docs/standard/python/how-instances-are-managed) |
     * [flexible environment](https://cloud.google.com/appengine/docs/flexible/python/how-instances-are-managed)).
     * To ensure that instances are not re-created and avoid getting billed, you
     * can stop all instances within the target version by changing the serving
     * status of the version to `STOPPED` with the
     * [`apps.services.versions.patch`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions/patch)
     * method.
     * </pre>
     */
    public void deleteInstance(com.google.appengine.v1.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteInstanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Enables debugging on a VM instance. This allows you to use the SSH
     * command to connect to the virtual machine where the instance lives.
     * While in "debug mode", the instance continues to serve live traffic.
     * You should delete the instance when you are done debugging and then
     * allow the system to take over and determine if another instance
     * should be started.
     * Only applicable for instances in App Engine flexible environment.
     * </pre>
     */
    public void debugInstance(com.google.appengine.v1.DebugInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDebugInstanceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Manages instances of a version.
   * </pre>
   */
  public static final class InstancesBlockingStub extends io.grpc.stub.AbstractBlockingStub<InstancesBlockingStub> {
    private InstancesBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InstancesBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InstancesBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the instances of a version.
     * Tip: To aggregate details about instances over time, see the
     * [Stackdriver Monitoring API](https://cloud.google.com/monitoring/api/ref_v3/rest/v3/projects.timeSeries/list).
     * </pre>
     */
    public com.google.appengine.v1.ListInstancesResponse listInstances(com.google.appengine.v1.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInstancesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets instance information.
     * </pre>
     */
    public com.google.appengine.v1.Instance getInstance(com.google.appengine.v1.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInstanceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Stops a running instance.
     * The instance might be automatically recreated based on the scaling settings
     * of the version. For more information, see "How Instances are Managed"
     * ([standard environment](https://cloud.google.com/appengine/docs/standard/python/how-instances-are-managed) |
     * [flexible environment](https://cloud.google.com/appengine/docs/flexible/python/how-instances-are-managed)).
     * To ensure that instances are not re-created and avoid getting billed, you
     * can stop all instances within the target version by changing the serving
     * status of the version to `STOPPED` with the
     * [`apps.services.versions.patch`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions/patch)
     * method.
     * </pre>
     */
    public com.google.longrunning.Operation deleteInstance(com.google.appengine.v1.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteInstanceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Enables debugging on a VM instance. This allows you to use the SSH
     * command to connect to the virtual machine where the instance lives.
     * While in "debug mode", the instance continues to serve live traffic.
     * You should delete the instance when you are done debugging and then
     * allow the system to take over and determine if another instance
     * should be started.
     * Only applicable for instances in App Engine flexible environment.
     * </pre>
     */
    public com.google.longrunning.Operation debugInstance(com.google.appengine.v1.DebugInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDebugInstanceMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Manages instances of a version.
   * </pre>
   */
  public static final class InstancesFutureStub extends io.grpc.stub.AbstractFutureStub<InstancesFutureStub> {
    private InstancesFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InstancesFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InstancesFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the instances of a version.
     * Tip: To aggregate details about instances over time, see the
     * [Stackdriver Monitoring API](https://cloud.google.com/monitoring/api/ref_v3/rest/v3/projects.timeSeries/list).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.appengine.v1.ListInstancesResponse> listInstances(
        com.google.appengine.v1.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListInstancesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets instance information.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.appengine.v1.Instance> getInstance(
        com.google.appengine.v1.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Stops a running instance.
     * The instance might be automatically recreated based on the scaling settings
     * of the version. For more information, see "How Instances are Managed"
     * ([standard environment](https://cloud.google.com/appengine/docs/standard/python/how-instances-are-managed) |
     * [flexible environment](https://cloud.google.com/appengine/docs/flexible/python/how-instances-are-managed)).
     * To ensure that instances are not re-created and avoid getting billed, you
     * can stop all instances within the target version by changing the serving
     * status of the version to `STOPPED` with the
     * [`apps.services.versions.patch`](https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions/patch)
     * method.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteInstance(
        com.google.appengine.v1.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteInstanceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Enables debugging on a VM instance. This allows you to use the SSH
     * command to connect to the virtual machine where the instance lives.
     * While in "debug mode", the instance continues to serve live traffic.
     * You should delete the instance when you are done debugging and then
     * allow the system to take over and determine if another instance
     * should be started.
     * Only applicable for instances in App Engine flexible environment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> debugInstance(
        com.google.appengine.v1.DebugInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDebugInstanceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_INSTANCES = 0;
  private static final int METHODID_GET_INSTANCE = 1;
  private static final int METHODID_DELETE_INSTANCE = 2;
  private static final int METHODID_DEBUG_INSTANCE = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final InstancesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(InstancesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_INSTANCES:
          serviceImpl.listInstances((com.google.appengine.v1.ListInstancesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.appengine.v1.ListInstancesResponse>) responseObserver);
          break;
        case METHODID_GET_INSTANCE:
          serviceImpl.getInstance((com.google.appengine.v1.GetInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.appengine.v1.Instance>) responseObserver);
          break;
        case METHODID_DELETE_INSTANCE:
          serviceImpl.deleteInstance((com.google.appengine.v1.DeleteInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DEBUG_INSTANCE:
          serviceImpl.debugInstance((com.google.appengine.v1.DebugInstanceRequest) request,
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

  private static abstract class InstancesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    InstancesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.appengine.v1.AppengineProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Instances");
    }
  }

  private static final class InstancesFileDescriptorSupplier
      extends InstancesBaseDescriptorSupplier {
    InstancesFileDescriptorSupplier() {}
  }

  private static final class InstancesMethodDescriptorSupplier
      extends InstancesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    InstancesMethodDescriptorSupplier(String methodName) {
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
      synchronized (InstancesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new InstancesFileDescriptorSupplier())
              .addMethod(getListInstancesMethod())
              .addMethod(getGetInstanceMethod())
              .addMethod(getDeleteInstanceMethod())
              .addMethod(getDebugInstanceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
