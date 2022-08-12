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
package com.google.dataflow.v1beta3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Provides a service for Flex templates. This feature is not ready yet.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/dataflow/v1beta3/templates.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FlexTemplatesServiceGrpc {

  private FlexTemplatesServiceGrpc() {}

  public static final String SERVICE_NAME = "google.dataflow.v1beta3.FlexTemplatesService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.dataflow.v1beta3.LaunchFlexTemplateRequest,
          com.google.dataflow.v1beta3.LaunchFlexTemplateResponse>
      getLaunchFlexTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LaunchFlexTemplate",
      requestType = com.google.dataflow.v1beta3.LaunchFlexTemplateRequest.class,
      responseType = com.google.dataflow.v1beta3.LaunchFlexTemplateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.dataflow.v1beta3.LaunchFlexTemplateRequest,
          com.google.dataflow.v1beta3.LaunchFlexTemplateResponse>
      getLaunchFlexTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.dataflow.v1beta3.LaunchFlexTemplateRequest,
            com.google.dataflow.v1beta3.LaunchFlexTemplateResponse>
        getLaunchFlexTemplateMethod;
    if ((getLaunchFlexTemplateMethod = FlexTemplatesServiceGrpc.getLaunchFlexTemplateMethod)
        == null) {
      synchronized (FlexTemplatesServiceGrpc.class) {
        if ((getLaunchFlexTemplateMethod = FlexTemplatesServiceGrpc.getLaunchFlexTemplateMethod)
            == null) {
          FlexTemplatesServiceGrpc.getLaunchFlexTemplateMethod =
              getLaunchFlexTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.dataflow.v1beta3.LaunchFlexTemplateRequest,
                          com.google.dataflow.v1beta3.LaunchFlexTemplateResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LaunchFlexTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.dataflow.v1beta3.LaunchFlexTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.dataflow.v1beta3.LaunchFlexTemplateResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FlexTemplatesServiceMethodDescriptorSupplier("LaunchFlexTemplate"))
                      .build();
        }
      }
    }
    return getLaunchFlexTemplateMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static FlexTemplatesServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FlexTemplatesServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FlexTemplatesServiceStub>() {
          @java.lang.Override
          public FlexTemplatesServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FlexTemplatesServiceStub(channel, callOptions);
          }
        };
    return FlexTemplatesServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FlexTemplatesServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FlexTemplatesServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FlexTemplatesServiceBlockingStub>() {
          @java.lang.Override
          public FlexTemplatesServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FlexTemplatesServiceBlockingStub(channel, callOptions);
          }
        };
    return FlexTemplatesServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static FlexTemplatesServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FlexTemplatesServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FlexTemplatesServiceFutureStub>() {
          @java.lang.Override
          public FlexTemplatesServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FlexTemplatesServiceFutureStub(channel, callOptions);
          }
        };
    return FlexTemplatesServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Provides a service for Flex templates. This feature is not ready yet.
   * </pre>
   */
  public abstract static class FlexTemplatesServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Launch a job with a FlexTemplate.
     * </pre>
     */
    public void launchFlexTemplate(
        com.google.dataflow.v1beta3.LaunchFlexTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.LaunchFlexTemplateResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getLaunchFlexTemplateMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getLaunchFlexTemplateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.dataflow.v1beta3.LaunchFlexTemplateRequest,
                      com.google.dataflow.v1beta3.LaunchFlexTemplateResponse>(
                      this, METHODID_LAUNCH_FLEX_TEMPLATE)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Provides a service for Flex templates. This feature is not ready yet.
   * </pre>
   */
  public static final class FlexTemplatesServiceStub
      extends io.grpc.stub.AbstractAsyncStub<FlexTemplatesServiceStub> {
    private FlexTemplatesServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FlexTemplatesServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FlexTemplatesServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Launch a job with a FlexTemplate.
     * </pre>
     */
    public void launchFlexTemplate(
        com.google.dataflow.v1beta3.LaunchFlexTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.LaunchFlexTemplateResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLaunchFlexTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Provides a service for Flex templates. This feature is not ready yet.
   * </pre>
   */
  public static final class FlexTemplatesServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FlexTemplatesServiceBlockingStub> {
    private FlexTemplatesServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FlexTemplatesServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FlexTemplatesServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Launch a job with a FlexTemplate.
     * </pre>
     */
    public com.google.dataflow.v1beta3.LaunchFlexTemplateResponse launchFlexTemplate(
        com.google.dataflow.v1beta3.LaunchFlexTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLaunchFlexTemplateMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Provides a service for Flex templates. This feature is not ready yet.
   * </pre>
   */
  public static final class FlexTemplatesServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<FlexTemplatesServiceFutureStub> {
    private FlexTemplatesServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FlexTemplatesServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FlexTemplatesServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Launch a job with a FlexTemplate.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.dataflow.v1beta3.LaunchFlexTemplateResponse>
        launchFlexTemplate(com.google.dataflow.v1beta3.LaunchFlexTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLaunchFlexTemplateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LAUNCH_FLEX_TEMPLATE = 0;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FlexTemplatesServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FlexTemplatesServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LAUNCH_FLEX_TEMPLATE:
          serviceImpl.launchFlexTemplate(
              (com.google.dataflow.v1beta3.LaunchFlexTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.LaunchFlexTemplateResponse>)
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

  private abstract static class FlexTemplatesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FlexTemplatesServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.dataflow.v1beta3.TemplatesProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FlexTemplatesService");
    }
  }

  private static final class FlexTemplatesServiceFileDescriptorSupplier
      extends FlexTemplatesServiceBaseDescriptorSupplier {
    FlexTemplatesServiceFileDescriptorSupplier() {}
  }

  private static final class FlexTemplatesServiceMethodDescriptorSupplier
      extends FlexTemplatesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FlexTemplatesServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (FlexTemplatesServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new FlexTemplatesServiceFileDescriptorSupplier())
                      .addMethod(getLaunchFlexTemplateMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
