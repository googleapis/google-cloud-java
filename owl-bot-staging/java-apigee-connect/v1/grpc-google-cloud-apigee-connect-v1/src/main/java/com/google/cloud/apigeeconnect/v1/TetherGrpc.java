package com.google.cloud.apigeeconnect.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Tether provides a way for the control plane to send HTTP API requests to
 * services in data planes that runs in a remote datacenter without
 * requiring customers to open firewalls on their runtime plane.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/apigeeconnect/v1/tether.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TetherGrpc {

  private TetherGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.apigeeconnect.v1.Tether";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apigeeconnect.v1.EgressResponse,
      com.google.cloud.apigeeconnect.v1.EgressRequest> getEgressMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Egress",
      requestType = com.google.cloud.apigeeconnect.v1.EgressResponse.class,
      responseType = com.google.cloud.apigeeconnect.v1.EgressRequest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.cloud.apigeeconnect.v1.EgressResponse,
      com.google.cloud.apigeeconnect.v1.EgressRequest> getEgressMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apigeeconnect.v1.EgressResponse, com.google.cloud.apigeeconnect.v1.EgressRequest> getEgressMethod;
    if ((getEgressMethod = TetherGrpc.getEgressMethod) == null) {
      synchronized (TetherGrpc.class) {
        if ((getEgressMethod = TetherGrpc.getEgressMethod) == null) {
          TetherGrpc.getEgressMethod = getEgressMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apigeeconnect.v1.EgressResponse, com.google.cloud.apigeeconnect.v1.EgressRequest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Egress"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apigeeconnect.v1.EgressResponse.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apigeeconnect.v1.EgressRequest.getDefaultInstance()))
              .setSchemaDescriptor(new TetherMethodDescriptorSupplier("Egress"))
              .build();
        }
      }
    }
    return getEgressMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TetherStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TetherStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TetherStub>() {
        @java.lang.Override
        public TetherStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TetherStub(channel, callOptions);
        }
      };
    return TetherStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TetherBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TetherBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TetherBlockingStub>() {
        @java.lang.Override
        public TetherBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TetherBlockingStub(channel, callOptions);
        }
      };
    return TetherBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TetherFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TetherFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TetherFutureStub>() {
        @java.lang.Override
        public TetherFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TetherFutureStub(channel, callOptions);
        }
      };
    return TetherFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Tether provides a way for the control plane to send HTTP API requests to
   * services in data planes that runs in a remote datacenter without
   * requiring customers to open firewalls on their runtime plane.
   * </pre>
   */
  public static abstract class TetherImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Egress streams egress requests and responses. Logically, this is not
     * actually a streaming request, but uses streaming as a mechanism to flip
     * the client-server relationship of gRPC so that the server can act as a
     * client.
     * The listener, the RPC server, accepts connections from the dialer,
     * the RPC client.
     * The listener streams http requests and the dialer streams http responses.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.cloud.apigeeconnect.v1.EgressResponse> egress(
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeconnect.v1.EgressRequest> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getEgressMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getEgressMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                com.google.cloud.apigeeconnect.v1.EgressResponse,
                com.google.cloud.apigeeconnect.v1.EgressRequest>(
                  this, METHODID_EGRESS)))
          .build();
    }
  }

  /**
   * <pre>
   * Tether provides a way for the control plane to send HTTP API requests to
   * services in data planes that runs in a remote datacenter without
   * requiring customers to open firewalls on their runtime plane.
   * </pre>
   */
  public static final class TetherStub extends io.grpc.stub.AbstractAsyncStub<TetherStub> {
    private TetherStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TetherStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TetherStub(channel, callOptions);
    }

    /**
     * <pre>
     * Egress streams egress requests and responses. Logically, this is not
     * actually a streaming request, but uses streaming as a mechanism to flip
     * the client-server relationship of gRPC so that the server can act as a
     * client.
     * The listener, the RPC server, accepts connections from the dialer,
     * the RPC client.
     * The listener streams http requests and the dialer streams http responses.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.cloud.apigeeconnect.v1.EgressResponse> egress(
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeconnect.v1.EgressRequest> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getEgressMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Tether provides a way for the control plane to send HTTP API requests to
   * services in data planes that runs in a remote datacenter without
   * requiring customers to open firewalls on their runtime plane.
   * </pre>
   */
  public static final class TetherBlockingStub extends io.grpc.stub.AbstractBlockingStub<TetherBlockingStub> {
    private TetherBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TetherBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TetherBlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   * Tether provides a way for the control plane to send HTTP API requests to
   * services in data planes that runs in a remote datacenter without
   * requiring customers to open firewalls on their runtime plane.
   * </pre>
   */
  public static final class TetherFutureStub extends io.grpc.stub.AbstractFutureStub<TetherFutureStub> {
    private TetherFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TetherFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TetherFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_EGRESS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TetherImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TetherImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_EGRESS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.egress(
              (io.grpc.stub.StreamObserver<com.google.cloud.apigeeconnect.v1.EgressRequest>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TetherBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TetherBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.apigeeconnect.v1.TetherProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Tether");
    }
  }

  private static final class TetherFileDescriptorSupplier
      extends TetherBaseDescriptorSupplier {
    TetherFileDescriptorSupplier() {}
  }

  private static final class TetherMethodDescriptorSupplier
      extends TetherBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TetherMethodDescriptorSupplier(String methodName) {
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
      synchronized (TetherGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TetherFileDescriptorSupplier())
              .addMethod(getEgressMethod())
              .build();
        }
      }
    }
    return result;
  }
}
