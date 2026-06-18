/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.chronicle.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * RuleExecutionErrorService contains endpoints related to rule execution
 * errors.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class RuleExecutionErrorServiceGrpc {

  private RuleExecutionErrorServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.chronicle.v1.RuleExecutionErrorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ListRuleExecutionErrorsRequest,
          com.google.cloud.chronicle.v1.ListRuleExecutionErrorsResponse>
      getListRuleExecutionErrorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRuleExecutionErrors",
      requestType = com.google.cloud.chronicle.v1.ListRuleExecutionErrorsRequest.class,
      responseType = com.google.cloud.chronicle.v1.ListRuleExecutionErrorsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ListRuleExecutionErrorsRequest,
          com.google.cloud.chronicle.v1.ListRuleExecutionErrorsResponse>
      getListRuleExecutionErrorsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.ListRuleExecutionErrorsRequest,
            com.google.cloud.chronicle.v1.ListRuleExecutionErrorsResponse>
        getListRuleExecutionErrorsMethod;
    if ((getListRuleExecutionErrorsMethod =
            RuleExecutionErrorServiceGrpc.getListRuleExecutionErrorsMethod)
        == null) {
      synchronized (RuleExecutionErrorServiceGrpc.class) {
        if ((getListRuleExecutionErrorsMethod =
                RuleExecutionErrorServiceGrpc.getListRuleExecutionErrorsMethod)
            == null) {
          RuleExecutionErrorServiceGrpc.getListRuleExecutionErrorsMethod =
              getListRuleExecutionErrorsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.ListRuleExecutionErrorsRequest,
                          com.google.cloud.chronicle.v1.ListRuleExecutionErrorsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListRuleExecutionErrors"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.ListRuleExecutionErrorsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.ListRuleExecutionErrorsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RuleExecutionErrorServiceMethodDescriptorSupplier(
                              "ListRuleExecutionErrors"))
                      .build();
        }
      }
    }
    return getListRuleExecutionErrorsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static RuleExecutionErrorServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RuleExecutionErrorServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RuleExecutionErrorServiceStub>() {
          @java.lang.Override
          public RuleExecutionErrorServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RuleExecutionErrorServiceStub(channel, callOptions);
          }
        };
    return RuleExecutionErrorServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static RuleExecutionErrorServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RuleExecutionErrorServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RuleExecutionErrorServiceBlockingV2Stub>() {
          @java.lang.Override
          public RuleExecutionErrorServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RuleExecutionErrorServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return RuleExecutionErrorServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RuleExecutionErrorServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RuleExecutionErrorServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RuleExecutionErrorServiceBlockingStub>() {
          @java.lang.Override
          public RuleExecutionErrorServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RuleExecutionErrorServiceBlockingStub(channel, callOptions);
          }
        };
    return RuleExecutionErrorServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static RuleExecutionErrorServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RuleExecutionErrorServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RuleExecutionErrorServiceFutureStub>() {
          @java.lang.Override
          public RuleExecutionErrorServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RuleExecutionErrorServiceFutureStub(channel, callOptions);
          }
        };
    return RuleExecutionErrorServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * RuleExecutionErrorService contains endpoints related to rule execution
   * errors.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists rule execution errors.
     * </pre>
     */
    default void listRuleExecutionErrors(
        com.google.cloud.chronicle.v1.ListRuleExecutionErrorsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ListRuleExecutionErrorsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRuleExecutionErrorsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service RuleExecutionErrorService.
   *
   * <pre>
   * RuleExecutionErrorService contains endpoints related to rule execution
   * errors.
   * </pre>
   */
  public abstract static class RuleExecutionErrorServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return RuleExecutionErrorServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service RuleExecutionErrorService.
   *
   * <pre>
   * RuleExecutionErrorService contains endpoints related to rule execution
   * errors.
   * </pre>
   */
  public static final class RuleExecutionErrorServiceStub
      extends io.grpc.stub.AbstractAsyncStub<RuleExecutionErrorServiceStub> {
    private RuleExecutionErrorServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RuleExecutionErrorServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RuleExecutionErrorServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists rule execution errors.
     * </pre>
     */
    public void listRuleExecutionErrors(
        com.google.cloud.chronicle.v1.ListRuleExecutionErrorsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ListRuleExecutionErrorsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRuleExecutionErrorsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service RuleExecutionErrorService.
   *
   * <pre>
   * RuleExecutionErrorService contains endpoints related to rule execution
   * errors.
   * </pre>
   */
  public static final class RuleExecutionErrorServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<RuleExecutionErrorServiceBlockingV2Stub> {
    private RuleExecutionErrorServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RuleExecutionErrorServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RuleExecutionErrorServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists rule execution errors.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ListRuleExecutionErrorsResponse listRuleExecutionErrors(
        com.google.cloud.chronicle.v1.ListRuleExecutionErrorsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListRuleExecutionErrorsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service
   * RuleExecutionErrorService.
   *
   * <pre>
   * RuleExecutionErrorService contains endpoints related to rule execution
   * errors.
   * </pre>
   */
  public static final class RuleExecutionErrorServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RuleExecutionErrorServiceBlockingStub> {
    private RuleExecutionErrorServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RuleExecutionErrorServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RuleExecutionErrorServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists rule execution errors.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ListRuleExecutionErrorsResponse listRuleExecutionErrors(
        com.google.cloud.chronicle.v1.ListRuleExecutionErrorsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRuleExecutionErrorsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * RuleExecutionErrorService.
   *
   * <pre>
   * RuleExecutionErrorService contains endpoints related to rule execution
   * errors.
   * </pre>
   */
  public static final class RuleExecutionErrorServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<RuleExecutionErrorServiceFutureStub> {
    private RuleExecutionErrorServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RuleExecutionErrorServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RuleExecutionErrorServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists rule execution errors.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.ListRuleExecutionErrorsResponse>
        listRuleExecutionErrors(
            com.google.cloud.chronicle.v1.ListRuleExecutionErrorsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRuleExecutionErrorsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_RULE_EXECUTION_ERRORS = 0;

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
        case METHODID_LIST_RULE_EXECUTION_ERRORS:
          serviceImpl.listRuleExecutionErrors(
              (com.google.cloud.chronicle.v1.ListRuleExecutionErrorsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.chronicle.v1.ListRuleExecutionErrorsResponse>)
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getListRuleExecutionErrorsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.ListRuleExecutionErrorsRequest,
                    com.google.cloud.chronicle.v1.ListRuleExecutionErrorsResponse>(
                    service, METHODID_LIST_RULE_EXECUTION_ERRORS)))
        .build();
  }

  private abstract static class RuleExecutionErrorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RuleExecutionErrorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.chronicle.v1.RuleExecutionErrorProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RuleExecutionErrorService");
    }
  }

  private static final class RuleExecutionErrorServiceFileDescriptorSupplier
      extends RuleExecutionErrorServiceBaseDescriptorSupplier {
    RuleExecutionErrorServiceFileDescriptorSupplier() {}
  }

  private static final class RuleExecutionErrorServiceMethodDescriptorSupplier
      extends RuleExecutionErrorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    RuleExecutionErrorServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (RuleExecutionErrorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new RuleExecutionErrorServiceFileDescriptorSupplier())
                      .addMethod(getListRuleExecutionErrorsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
