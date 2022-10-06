package com.google.dataflow.v1beta3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Provides methods to manage snapshots of Google Cloud Dataflow jobs.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/dataflow/v1beta3/snapshots.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SnapshotsV1Beta3Grpc {

  private SnapshotsV1Beta3Grpc() {}

  public static final String SERVICE_NAME = "google.dataflow.v1beta3.SnapshotsV1Beta3";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.GetSnapshotRequest,
      com.google.dataflow.v1beta3.Snapshot> getGetSnapshotMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSnapshot",
      requestType = com.google.dataflow.v1beta3.GetSnapshotRequest.class,
      responseType = com.google.dataflow.v1beta3.Snapshot.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.GetSnapshotRequest,
      com.google.dataflow.v1beta3.Snapshot> getGetSnapshotMethod() {
    io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.GetSnapshotRequest, com.google.dataflow.v1beta3.Snapshot> getGetSnapshotMethod;
    if ((getGetSnapshotMethod = SnapshotsV1Beta3Grpc.getGetSnapshotMethod) == null) {
      synchronized (SnapshotsV1Beta3Grpc.class) {
        if ((getGetSnapshotMethod = SnapshotsV1Beta3Grpc.getGetSnapshotMethod) == null) {
          SnapshotsV1Beta3Grpc.getGetSnapshotMethod = getGetSnapshotMethod =
              io.grpc.MethodDescriptor.<com.google.dataflow.v1beta3.GetSnapshotRequest, com.google.dataflow.v1beta3.Snapshot>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSnapshot"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.dataflow.v1beta3.GetSnapshotRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.dataflow.v1beta3.Snapshot.getDefaultInstance()))
              .setSchemaDescriptor(new SnapshotsV1Beta3MethodDescriptorSupplier("GetSnapshot"))
              .build();
        }
      }
    }
    return getGetSnapshotMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.DeleteSnapshotRequest,
      com.google.dataflow.v1beta3.DeleteSnapshotResponse> getDeleteSnapshotMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSnapshot",
      requestType = com.google.dataflow.v1beta3.DeleteSnapshotRequest.class,
      responseType = com.google.dataflow.v1beta3.DeleteSnapshotResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.DeleteSnapshotRequest,
      com.google.dataflow.v1beta3.DeleteSnapshotResponse> getDeleteSnapshotMethod() {
    io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.DeleteSnapshotRequest, com.google.dataflow.v1beta3.DeleteSnapshotResponse> getDeleteSnapshotMethod;
    if ((getDeleteSnapshotMethod = SnapshotsV1Beta3Grpc.getDeleteSnapshotMethod) == null) {
      synchronized (SnapshotsV1Beta3Grpc.class) {
        if ((getDeleteSnapshotMethod = SnapshotsV1Beta3Grpc.getDeleteSnapshotMethod) == null) {
          SnapshotsV1Beta3Grpc.getDeleteSnapshotMethod = getDeleteSnapshotMethod =
              io.grpc.MethodDescriptor.<com.google.dataflow.v1beta3.DeleteSnapshotRequest, com.google.dataflow.v1beta3.DeleteSnapshotResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSnapshot"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.dataflow.v1beta3.DeleteSnapshotRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.dataflow.v1beta3.DeleteSnapshotResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SnapshotsV1Beta3MethodDescriptorSupplier("DeleteSnapshot"))
              .build();
        }
      }
    }
    return getDeleteSnapshotMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.ListSnapshotsRequest,
      com.google.dataflow.v1beta3.ListSnapshotsResponse> getListSnapshotsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSnapshots",
      requestType = com.google.dataflow.v1beta3.ListSnapshotsRequest.class,
      responseType = com.google.dataflow.v1beta3.ListSnapshotsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.ListSnapshotsRequest,
      com.google.dataflow.v1beta3.ListSnapshotsResponse> getListSnapshotsMethod() {
    io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.ListSnapshotsRequest, com.google.dataflow.v1beta3.ListSnapshotsResponse> getListSnapshotsMethod;
    if ((getListSnapshotsMethod = SnapshotsV1Beta3Grpc.getListSnapshotsMethod) == null) {
      synchronized (SnapshotsV1Beta3Grpc.class) {
        if ((getListSnapshotsMethod = SnapshotsV1Beta3Grpc.getListSnapshotsMethod) == null) {
          SnapshotsV1Beta3Grpc.getListSnapshotsMethod = getListSnapshotsMethod =
              io.grpc.MethodDescriptor.<com.google.dataflow.v1beta3.ListSnapshotsRequest, com.google.dataflow.v1beta3.ListSnapshotsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSnapshots"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.dataflow.v1beta3.ListSnapshotsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.dataflow.v1beta3.ListSnapshotsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SnapshotsV1Beta3MethodDescriptorSupplier("ListSnapshots"))
              .build();
        }
      }
    }
    return getListSnapshotsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SnapshotsV1Beta3Stub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SnapshotsV1Beta3Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SnapshotsV1Beta3Stub>() {
        @java.lang.Override
        public SnapshotsV1Beta3Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SnapshotsV1Beta3Stub(channel, callOptions);
        }
      };
    return SnapshotsV1Beta3Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SnapshotsV1Beta3BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SnapshotsV1Beta3BlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SnapshotsV1Beta3BlockingStub>() {
        @java.lang.Override
        public SnapshotsV1Beta3BlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SnapshotsV1Beta3BlockingStub(channel, callOptions);
        }
      };
    return SnapshotsV1Beta3BlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SnapshotsV1Beta3FutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SnapshotsV1Beta3FutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SnapshotsV1Beta3FutureStub>() {
        @java.lang.Override
        public SnapshotsV1Beta3FutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SnapshotsV1Beta3FutureStub(channel, callOptions);
        }
      };
    return SnapshotsV1Beta3FutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Provides methods to manage snapshots of Google Cloud Dataflow jobs.
   * </pre>
   */
  public static abstract class SnapshotsV1Beta3ImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Gets information about a snapshot.
     * </pre>
     */
    public void getSnapshot(com.google.dataflow.v1beta3.GetSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.Snapshot> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSnapshotMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a snapshot.
     * </pre>
     */
    public void deleteSnapshot(com.google.dataflow.v1beta3.DeleteSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.DeleteSnapshotResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteSnapshotMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists snapshots.
     * </pre>
     */
    public void listSnapshots(com.google.dataflow.v1beta3.ListSnapshotsRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.ListSnapshotsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListSnapshotsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetSnapshotMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.dataflow.v1beta3.GetSnapshotRequest,
                com.google.dataflow.v1beta3.Snapshot>(
                  this, METHODID_GET_SNAPSHOT)))
          .addMethod(
            getDeleteSnapshotMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.dataflow.v1beta3.DeleteSnapshotRequest,
                com.google.dataflow.v1beta3.DeleteSnapshotResponse>(
                  this, METHODID_DELETE_SNAPSHOT)))
          .addMethod(
            getListSnapshotsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.dataflow.v1beta3.ListSnapshotsRequest,
                com.google.dataflow.v1beta3.ListSnapshotsResponse>(
                  this, METHODID_LIST_SNAPSHOTS)))
          .build();
    }
  }

  /**
   * <pre>
   * Provides methods to manage snapshots of Google Cloud Dataflow jobs.
   * </pre>
   */
  public static final class SnapshotsV1Beta3Stub extends io.grpc.stub.AbstractAsyncStub<SnapshotsV1Beta3Stub> {
    private SnapshotsV1Beta3Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SnapshotsV1Beta3Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SnapshotsV1Beta3Stub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets information about a snapshot.
     * </pre>
     */
    public void getSnapshot(com.google.dataflow.v1beta3.GetSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.Snapshot> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSnapshotMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a snapshot.
     * </pre>
     */
    public void deleteSnapshot(com.google.dataflow.v1beta3.DeleteSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.DeleteSnapshotResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSnapshotMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists snapshots.
     * </pre>
     */
    public void listSnapshots(com.google.dataflow.v1beta3.ListSnapshotsRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.ListSnapshotsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSnapshotsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Provides methods to manage snapshots of Google Cloud Dataflow jobs.
   * </pre>
   */
  public static final class SnapshotsV1Beta3BlockingStub extends io.grpc.stub.AbstractBlockingStub<SnapshotsV1Beta3BlockingStub> {
    private SnapshotsV1Beta3BlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SnapshotsV1Beta3BlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SnapshotsV1Beta3BlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets information about a snapshot.
     * </pre>
     */
    public com.google.dataflow.v1beta3.Snapshot getSnapshot(com.google.dataflow.v1beta3.GetSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSnapshotMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a snapshot.
     * </pre>
     */
    public com.google.dataflow.v1beta3.DeleteSnapshotResponse deleteSnapshot(com.google.dataflow.v1beta3.DeleteSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSnapshotMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists snapshots.
     * </pre>
     */
    public com.google.dataflow.v1beta3.ListSnapshotsResponse listSnapshots(com.google.dataflow.v1beta3.ListSnapshotsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSnapshotsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Provides methods to manage snapshots of Google Cloud Dataflow jobs.
   * </pre>
   */
  public static final class SnapshotsV1Beta3FutureStub extends io.grpc.stub.AbstractFutureStub<SnapshotsV1Beta3FutureStub> {
    private SnapshotsV1Beta3FutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SnapshotsV1Beta3FutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SnapshotsV1Beta3FutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets information about a snapshot.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.dataflow.v1beta3.Snapshot> getSnapshot(
        com.google.dataflow.v1beta3.GetSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSnapshotMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a snapshot.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.dataflow.v1beta3.DeleteSnapshotResponse> deleteSnapshot(
        com.google.dataflow.v1beta3.DeleteSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSnapshotMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists snapshots.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.dataflow.v1beta3.ListSnapshotsResponse> listSnapshots(
        com.google.dataflow.v1beta3.ListSnapshotsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSnapshotsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_SNAPSHOT = 0;
  private static final int METHODID_DELETE_SNAPSHOT = 1;
  private static final int METHODID_LIST_SNAPSHOTS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SnapshotsV1Beta3ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SnapshotsV1Beta3ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_SNAPSHOT:
          serviceImpl.getSnapshot((com.google.dataflow.v1beta3.GetSnapshotRequest) request,
              (io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.Snapshot>) responseObserver);
          break;
        case METHODID_DELETE_SNAPSHOT:
          serviceImpl.deleteSnapshot((com.google.dataflow.v1beta3.DeleteSnapshotRequest) request,
              (io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.DeleteSnapshotResponse>) responseObserver);
          break;
        case METHODID_LIST_SNAPSHOTS:
          serviceImpl.listSnapshots((com.google.dataflow.v1beta3.ListSnapshotsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.ListSnapshotsResponse>) responseObserver);
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

  private static abstract class SnapshotsV1Beta3BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SnapshotsV1Beta3BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.dataflow.v1beta3.SnapshotsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SnapshotsV1Beta3");
    }
  }

  private static final class SnapshotsV1Beta3FileDescriptorSupplier
      extends SnapshotsV1Beta3BaseDescriptorSupplier {
    SnapshotsV1Beta3FileDescriptorSupplier() {}
  }

  private static final class SnapshotsV1Beta3MethodDescriptorSupplier
      extends SnapshotsV1Beta3BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SnapshotsV1Beta3MethodDescriptorSupplier(String methodName) {
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
      synchronized (SnapshotsV1Beta3Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SnapshotsV1Beta3FileDescriptorSupplier())
              .addMethod(getGetSnapshotMethod())
              .addMethod(getDeleteSnapshotMethod())
              .addMethod(getListSnapshotsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
