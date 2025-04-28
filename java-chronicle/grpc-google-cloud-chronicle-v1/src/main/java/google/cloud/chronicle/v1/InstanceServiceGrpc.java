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
package google.cloud.chronicle.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * InstanceService provides the entry interface for the Chronicle API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/chronicle/v1/instance.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class InstanceServiceGrpc {

  private InstanceServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.chronicle.v1.InstanceService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.GetInstanceRequest, google.cloud.chronicle.v1.Instance>
      getGetInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInstance",
      requestType = google.cloud.chronicle.v1.GetInstanceRequest.class,
      responseType = google.cloud.chronicle.v1.Instance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.GetInstanceRequest, google.cloud.chronicle.v1.Instance>
      getGetInstanceMethod() {
    io.grpc.MethodDescriptor<
            google.cloud.chronicle.v1.GetInstanceRequest, google.cloud.chronicle.v1.Instance>
        getGetInstanceMethod;
    if ((getGetInstanceMethod = InstanceServiceGrpc.getGetInstanceMethod) == null) {
      synchronized (InstanceServiceGrpc.class) {
        if ((getGetInstanceMethod = InstanceServiceGrpc.getGetInstanceMethod) == null) {
          InstanceServiceGrpc.getGetInstanceMethod =
              getGetInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<google.cloud.chronicle.v1.GetInstanceRequest,
                          google.cloud.chronicle.v1.Instance>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.GetInstanceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.Instance.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new InstanceServiceMethodDescriptorSupplier("GetInstance"))
                      .build();
        }
      }
    }
    return getGetInstanceMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static InstanceServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InstanceServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<InstanceServiceStub>() {
          @java.lang.Override
          public InstanceServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new InstanceServiceStub(channel, callOptions);
          }
        };
    return InstanceServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static InstanceServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InstanceServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<InstanceServiceBlockingStub>() {
          @java.lang.Override
          public InstanceServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new InstanceServiceBlockingStub(channel, callOptions);
          }
        };
    return InstanceServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static InstanceServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InstanceServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<InstanceServiceFutureStub>() {
          @java.lang.Override
          public InstanceServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new InstanceServiceFutureStub(channel, callOptions);
          }
        };
    return InstanceServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * InstanceService provides the entry interface for the Chronicle API.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Gets a Instance.
     * </pre>
     */
    default void getInstance(
        google.cloud.chronicle.v1.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.Instance> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetInstanceMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service InstanceService.
   *
   * <pre>
   * InstanceService provides the entry interface for the Chronicle API.
   * </pre>
   */
  public abstract static class InstanceServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return InstanceServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service InstanceService.
   *
   * <pre>
   * InstanceService provides the entry interface for the Chronicle API.
   * </pre>
   */
  public static final class InstanceServiceStub
      extends io.grpc.stub.AbstractAsyncStub<InstanceServiceStub> {
    private InstanceServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InstanceServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InstanceServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a Instance.
     * </pre>
     */
    public void getInstance(
        google.cloud.chronicle.v1.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.Instance> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service InstanceService.
   *
   * <pre>
   * InstanceService provides the entry interface for the Chronicle API.
   * </pre>
   */
  public static final class InstanceServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<InstanceServiceBlockingStub> {
    private InstanceServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InstanceServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InstanceServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a Instance.
     * </pre>
     */
    public google.cloud.chronicle.v1.Instance getInstance(
        google.cloud.chronicle.v1.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInstanceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service InstanceService.
   *
   * <pre>
   * InstanceService provides the entry interface for the Chronicle API.
   * </pre>
   */
  public static final class InstanceServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<InstanceServiceFutureStub> {
    private InstanceServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InstanceServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InstanceServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<google.cloud.chronicle.v1.Instance>
        getInstance(google.cloud.chronicle.v1.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_INSTANCE = 0;

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
        case METHODID_GET_INSTANCE:
          serviceImpl.getInstance(
              (google.cloud.chronicle.v1.GetInstanceRequest) request,
              (io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.Instance>) responseObserver);
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
            getGetInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.cloud.chronicle.v1.GetInstanceRequest,
                    google.cloud.chronicle.v1.Instance>(service, METHODID_GET_INSTANCE)))
        .build();
  }

  private abstract static class InstanceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    InstanceServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return google.cloud.chronicle.v1.InstanceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("InstanceService");
    }
  }

  private static final class InstanceServiceFileDescriptorSupplier
      extends InstanceServiceBaseDescriptorSupplier {
    InstanceServiceFileDescriptorSupplier() {}
  }

  private static final class InstanceServiceMethodDescriptorSupplier
      extends InstanceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    InstanceServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (InstanceServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new InstanceServiceFileDescriptorSupplier())
                      .addMethod(getGetInstanceMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
