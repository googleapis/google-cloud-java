/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.gkeconnect.gateway.v1;


/**
 *
 *
 * <pre>
 * Gateway service is a public API which works as a Kubernetes resource model
 * proxy between end users and registered Kubernetes clusters. Each RPC in this
 * service matches with an HTTP verb. End user will initiate kubectl commands
 * against the Gateway service, and Gateway service will forward user requests
 * to clusters.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/gkeconnect/gateway/v1/gateway.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GatewayServiceGrpc {

  private GatewayServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.gkeconnect.gateway.v1.GatewayService";

  // Static method descriptors that strictly reflect the proto.
  /** Creates a new async stub that supports all call types for the service */
  public static GatewayServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GatewayServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GatewayServiceStub>() {
          @java.lang.Override
          public GatewayServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GatewayServiceStub(channel, callOptions);
          }
        };
    return GatewayServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GatewayServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GatewayServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GatewayServiceBlockingStub>() {
          @java.lang.Override
          public GatewayServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GatewayServiceBlockingStub(channel, callOptions);
          }
        };
    return GatewayServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static GatewayServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GatewayServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GatewayServiceFutureStub>() {
          @java.lang.Override
          public GatewayServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GatewayServiceFutureStub(channel, callOptions);
          }
        };
    return GatewayServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Gateway service is a public API which works as a Kubernetes resource model
   * proxy between end users and registered Kubernetes clusters. Each RPC in this
   * service matches with an HTTP verb. End user will initiate kubectl commands
   * against the Gateway service, and Gateway service will forward user requests
   * to clusters.
   * </pre>
   */
  public interface AsyncService {}

  /**
   * Base class for the server implementation of the service GatewayService.
   *
   * <pre>
   * Gateway service is a public API which works as a Kubernetes resource model
   * proxy between end users and registered Kubernetes clusters. Each RPC in this
   * service matches with an HTTP verb. End user will initiate kubectl commands
   * against the Gateway service, and Gateway service will forward user requests
   * to clusters.
   * </pre>
   */
  public abstract static class GatewayServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return GatewayServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service GatewayService.
   *
   * <pre>
   * Gateway service is a public API which works as a Kubernetes resource model
   * proxy between end users and registered Kubernetes clusters. Each RPC in this
   * service matches with an HTTP verb. End user will initiate kubectl commands
   * against the Gateway service, and Gateway service will forward user requests
   * to clusters.
   * </pre>
   */
  public static final class GatewayServiceStub
      extends io.grpc.stub.AbstractAsyncStub<GatewayServiceStub> {
    private GatewayServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GatewayServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GatewayServiceStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service GatewayService.
   *
   * <pre>
   * Gateway service is a public API which works as a Kubernetes resource model
   * proxy between end users and registered Kubernetes clusters. Each RPC in this
   * service matches with an HTTP verb. End user will initiate kubectl commands
   * against the Gateway service, and Gateway service will forward user requests
   * to clusters.
   * </pre>
   */
  public static final class GatewayServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<GatewayServiceBlockingStub> {
    private GatewayServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GatewayServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GatewayServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service GatewayService.
   *
   * <pre>
   * Gateway service is a public API which works as a Kubernetes resource model
   * proxy between end users and registered Kubernetes clusters. Each RPC in this
   * service matches with an HTTP verb. End user will initiate kubectl commands
   * against the Gateway service, and Gateway service will forward user requests
   * to clusters.
   * </pre>
   */
  public static final class GatewayServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<GatewayServiceFutureStub> {
    private GatewayServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GatewayServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GatewayServiceFutureStub(channel, callOptions);
    }
  }

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
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor()).build();
  }

  private abstract static class GatewayServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GatewayServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.gkeconnect.gateway.v1.GatewayProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GatewayService");
    }
  }

  private static final class GatewayServiceFileDescriptorSupplier
      extends GatewayServiceBaseDescriptorSupplier {
    GatewayServiceFileDescriptorSupplier() {}
  }

  private static final class GatewayServiceMethodDescriptorSupplier
      extends GatewayServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    GatewayServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (GatewayServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new GatewayServiceFileDescriptorSupplier())
                      .build();
        }
      }
    }
    return result;
  }
}
