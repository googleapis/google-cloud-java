package com.google.cloud.dialogflow.cx.v3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Service for managing [Changelogs][google.cloud.dialogflow.cx.v3.Changelog].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/cx/v3/changelog.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ChangelogsGrpc {

  private ChangelogsGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dialogflow.cx.v3.Changelogs";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.ListChangelogsRequest,
      com.google.cloud.dialogflow.cx.v3.ListChangelogsResponse> getListChangelogsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListChangelogs",
      requestType = com.google.cloud.dialogflow.cx.v3.ListChangelogsRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.ListChangelogsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.ListChangelogsRequest,
      com.google.cloud.dialogflow.cx.v3.ListChangelogsResponse> getListChangelogsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.ListChangelogsRequest, com.google.cloud.dialogflow.cx.v3.ListChangelogsResponse> getListChangelogsMethod;
    if ((getListChangelogsMethod = ChangelogsGrpc.getListChangelogsMethod) == null) {
      synchronized (ChangelogsGrpc.class) {
        if ((getListChangelogsMethod = ChangelogsGrpc.getListChangelogsMethod) == null) {
          ChangelogsGrpc.getListChangelogsMethod = getListChangelogsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3.ListChangelogsRequest, com.google.cloud.dialogflow.cx.v3.ListChangelogsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListChangelogs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3.ListChangelogsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3.ListChangelogsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ChangelogsMethodDescriptorSupplier("ListChangelogs"))
              .build();
        }
      }
    }
    return getListChangelogsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.GetChangelogRequest,
      com.google.cloud.dialogflow.cx.v3.Changelog> getGetChangelogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetChangelog",
      requestType = com.google.cloud.dialogflow.cx.v3.GetChangelogRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.Changelog.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.GetChangelogRequest,
      com.google.cloud.dialogflow.cx.v3.Changelog> getGetChangelogMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.GetChangelogRequest, com.google.cloud.dialogflow.cx.v3.Changelog> getGetChangelogMethod;
    if ((getGetChangelogMethod = ChangelogsGrpc.getGetChangelogMethod) == null) {
      synchronized (ChangelogsGrpc.class) {
        if ((getGetChangelogMethod = ChangelogsGrpc.getGetChangelogMethod) == null) {
          ChangelogsGrpc.getGetChangelogMethod = getGetChangelogMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3.GetChangelogRequest, com.google.cloud.dialogflow.cx.v3.Changelog>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetChangelog"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3.GetChangelogRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3.Changelog.getDefaultInstance()))
              .setSchemaDescriptor(new ChangelogsMethodDescriptorSupplier("GetChangelog"))
              .build();
        }
      }
    }
    return getGetChangelogMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChangelogsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChangelogsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChangelogsStub>() {
        @java.lang.Override
        public ChangelogsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChangelogsStub(channel, callOptions);
        }
      };
    return ChangelogsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChangelogsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChangelogsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChangelogsBlockingStub>() {
        @java.lang.Override
        public ChangelogsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChangelogsBlockingStub(channel, callOptions);
        }
      };
    return ChangelogsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChangelogsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChangelogsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChangelogsFutureStub>() {
        @java.lang.Override
        public ChangelogsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChangelogsFutureStub(channel, callOptions);
        }
      };
    return ChangelogsFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service for managing [Changelogs][google.cloud.dialogflow.cx.v3.Changelog].
   * </pre>
   */
  public static abstract class ChangelogsImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Returns the list of Changelogs.
     * </pre>
     */
    public void listChangelogs(com.google.cloud.dialogflow.cx.v3.ListChangelogsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.ListChangelogsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListChangelogsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Retrieves the specified Changelog.
     * </pre>
     */
    public void getChangelog(com.google.cloud.dialogflow.cx.v3.GetChangelogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Changelog> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetChangelogMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListChangelogsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.cx.v3.ListChangelogsRequest,
                com.google.cloud.dialogflow.cx.v3.ListChangelogsResponse>(
                  this, METHODID_LIST_CHANGELOGS)))
          .addMethod(
            getGetChangelogMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.cx.v3.GetChangelogRequest,
                com.google.cloud.dialogflow.cx.v3.Changelog>(
                  this, METHODID_GET_CHANGELOG)))
          .build();
    }
  }

  /**
   * <pre>
   * Service for managing [Changelogs][google.cloud.dialogflow.cx.v3.Changelog].
   * </pre>
   */
  public static final class ChangelogsStub extends io.grpc.stub.AbstractAsyncStub<ChangelogsStub> {
    private ChangelogsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChangelogsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChangelogsStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns the list of Changelogs.
     * </pre>
     */
    public void listChangelogs(com.google.cloud.dialogflow.cx.v3.ListChangelogsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.ListChangelogsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListChangelogsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves the specified Changelog.
     * </pre>
     */
    public void getChangelog(com.google.cloud.dialogflow.cx.v3.GetChangelogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Changelog> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetChangelogMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service for managing [Changelogs][google.cloud.dialogflow.cx.v3.Changelog].
   * </pre>
   */
  public static final class ChangelogsBlockingStub extends io.grpc.stub.AbstractBlockingStub<ChangelogsBlockingStub> {
    private ChangelogsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChangelogsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChangelogsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns the list of Changelogs.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.ListChangelogsResponse listChangelogs(com.google.cloud.dialogflow.cx.v3.ListChangelogsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListChangelogsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves the specified Changelog.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.Changelog getChangelog(com.google.cloud.dialogflow.cx.v3.GetChangelogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetChangelogMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service for managing [Changelogs][google.cloud.dialogflow.cx.v3.Changelog].
   * </pre>
   */
  public static final class ChangelogsFutureStub extends io.grpc.stub.AbstractFutureStub<ChangelogsFutureStub> {
    private ChangelogsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChangelogsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChangelogsFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns the list of Changelogs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.cx.v3.ListChangelogsResponse> listChangelogs(
        com.google.cloud.dialogflow.cx.v3.ListChangelogsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListChangelogsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves the specified Changelog.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.cx.v3.Changelog> getChangelog(
        com.google.cloud.dialogflow.cx.v3.GetChangelogRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetChangelogMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_CHANGELOGS = 0;
  private static final int METHODID_GET_CHANGELOG = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChangelogsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChangelogsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_CHANGELOGS:
          serviceImpl.listChangelogs((com.google.cloud.dialogflow.cx.v3.ListChangelogsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.ListChangelogsResponse>) responseObserver);
          break;
        case METHODID_GET_CHANGELOG:
          serviceImpl.getChangelog((com.google.cloud.dialogflow.cx.v3.GetChangelogRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Changelog>) responseObserver);
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

  private static abstract class ChangelogsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChangelogsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.cx.v3.ChangelogProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Changelogs");
    }
  }

  private static final class ChangelogsFileDescriptorSupplier
      extends ChangelogsBaseDescriptorSupplier {
    ChangelogsFileDescriptorSupplier() {}
  }

  private static final class ChangelogsMethodDescriptorSupplier
      extends ChangelogsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ChangelogsMethodDescriptorSupplier(String methodName) {
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
      synchronized (ChangelogsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChangelogsFileDescriptorSupplier())
              .addMethod(getListChangelogsMethod())
              .addMethod(getGetChangelogMethod())
              .build();
        }
      }
    }
    return result;
  }
}
