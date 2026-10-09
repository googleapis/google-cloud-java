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
package com.google.cloud.workloadidentity.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service describing handlers for resources
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class WorkloadIdentityGrpc {

  private WorkloadIdentityGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.workloadidentity.v1.WorkloadIdentity";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workloadidentity.v1.GenerateServiceAgentsRequest,
          com.google.longrunning.Operation>
      getGenerateServiceAgentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateServiceAgents",
      requestType = com.google.cloud.workloadidentity.v1.GenerateServiceAgentsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workloadidentity.v1.GenerateServiceAgentsRequest,
          com.google.longrunning.Operation>
      getGenerateServiceAgentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workloadidentity.v1.GenerateServiceAgentsRequest,
            com.google.longrunning.Operation>
        getGenerateServiceAgentsMethod;
    if ((getGenerateServiceAgentsMethod = WorkloadIdentityGrpc.getGenerateServiceAgentsMethod)
        == null) {
      synchronized (WorkloadIdentityGrpc.class) {
        if ((getGenerateServiceAgentsMethod = WorkloadIdentityGrpc.getGenerateServiceAgentsMethod)
            == null) {
          WorkloadIdentityGrpc.getGenerateServiceAgentsMethod =
              getGenerateServiceAgentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workloadidentity.v1.GenerateServiceAgentsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GenerateServiceAgents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workloadidentity.v1.GenerateServiceAgentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkloadIdentityMethodDescriptorSupplier("GenerateServiceAgents"))
                      .build();
        }
      }
    }
    return getGenerateServiceAgentsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static WorkloadIdentityStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkloadIdentityStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WorkloadIdentityStub>() {
          @java.lang.Override
          public WorkloadIdentityStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WorkloadIdentityStub(channel, callOptions);
          }
        };
    return WorkloadIdentityStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static WorkloadIdentityBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkloadIdentityBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WorkloadIdentityBlockingV2Stub>() {
          @java.lang.Override
          public WorkloadIdentityBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WorkloadIdentityBlockingV2Stub(channel, callOptions);
          }
        };
    return WorkloadIdentityBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WorkloadIdentityBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkloadIdentityBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WorkloadIdentityBlockingStub>() {
          @java.lang.Override
          public WorkloadIdentityBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WorkloadIdentityBlockingStub(channel, callOptions);
          }
        };
    return WorkloadIdentityBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static WorkloadIdentityFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkloadIdentityFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WorkloadIdentityFutureStub>() {
          @java.lang.Override
          public WorkloadIdentityFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WorkloadIdentityFutureStub(channel, callOptions);
          }
        };
    return WorkloadIdentityFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates all service agents for a given resource, location and service
     * producer.
     * </pre>
     */
    default void generateServiceAgents(
        com.google.cloud.workloadidentity.v1.GenerateServiceAgentsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateServiceAgentsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service WorkloadIdentity.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public abstract static class WorkloadIdentityImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return WorkloadIdentityGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service WorkloadIdentity.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class WorkloadIdentityStub
      extends io.grpc.stub.AbstractAsyncStub<WorkloadIdentityStub> {
    private WorkloadIdentityStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkloadIdentityStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkloadIdentityStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates all service agents for a given resource, location and service
     * producer.
     * </pre>
     */
    public void generateServiceAgents(
        com.google.cloud.workloadidentity.v1.GenerateServiceAgentsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateServiceAgentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service WorkloadIdentity.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class WorkloadIdentityBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<WorkloadIdentityBlockingV2Stub> {
    private WorkloadIdentityBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkloadIdentityBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkloadIdentityBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates all service agents for a given resource, location and service
     * producer.
     * </pre>
     */
    public com.google.longrunning.Operation generateServiceAgents(
        com.google.cloud.workloadidentity.v1.GenerateServiceAgentsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGenerateServiceAgentsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service WorkloadIdentity.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class WorkloadIdentityBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<WorkloadIdentityBlockingStub> {
    private WorkloadIdentityBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkloadIdentityBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkloadIdentityBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates all service agents for a given resource, location and service
     * producer.
     * </pre>
     */
    public com.google.longrunning.Operation generateServiceAgents(
        com.google.cloud.workloadidentity.v1.GenerateServiceAgentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateServiceAgentsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service WorkloadIdentity.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class WorkloadIdentityFutureStub
      extends io.grpc.stub.AbstractFutureStub<WorkloadIdentityFutureStub> {
    private WorkloadIdentityFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkloadIdentityFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkloadIdentityFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates all service agents for a given resource, location and service
     * producer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        generateServiceAgents(
            com.google.cloud.workloadidentity.v1.GenerateServiceAgentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateServiceAgentsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GENERATE_SERVICE_AGENTS = 0;

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
        case METHODID_GENERATE_SERVICE_AGENTS:
          serviceImpl.generateServiceAgents(
              (com.google.cloud.workloadidentity.v1.GenerateServiceAgentsRequest) request,
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getGenerateServiceAgentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.workloadidentity.v1.GenerateServiceAgentsRequest,
                    com.google.longrunning.Operation>(service, METHODID_GENERATE_SERVICE_AGENTS)))
        .build();
  }

  private abstract static class WorkloadIdentityBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WorkloadIdentityBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.workloadidentity.v1.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WorkloadIdentity");
    }
  }

  private static final class WorkloadIdentityFileDescriptorSupplier
      extends WorkloadIdentityBaseDescriptorSupplier {
    WorkloadIdentityFileDescriptorSupplier() {}
  }

  private static final class WorkloadIdentityMethodDescriptorSupplier
      extends WorkloadIdentityBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    WorkloadIdentityMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (WorkloadIdentityGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new WorkloadIdentityFileDescriptorSupplier())
                      .addMethod(getGenerateServiceAgentsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
