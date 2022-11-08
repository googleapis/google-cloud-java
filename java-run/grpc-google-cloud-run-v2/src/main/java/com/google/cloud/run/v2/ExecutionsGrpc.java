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
package com.google.cloud.run.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Cloud Run Execution Control Plane API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/run/v2/execution.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ExecutionsGrpc {

  private ExecutionsGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.run.v2.Executions";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.GetExecutionRequest, com.google.cloud.run.v2.Execution>
      getGetExecutionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetExecution",
      requestType = com.google.cloud.run.v2.GetExecutionRequest.class,
      responseType = com.google.cloud.run.v2.Execution.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.GetExecutionRequest, com.google.cloud.run.v2.Execution>
      getGetExecutionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.run.v2.GetExecutionRequest, com.google.cloud.run.v2.Execution>
        getGetExecutionMethod;
    if ((getGetExecutionMethod = ExecutionsGrpc.getGetExecutionMethod) == null) {
      synchronized (ExecutionsGrpc.class) {
        if ((getGetExecutionMethod = ExecutionsGrpc.getGetExecutionMethod) == null) {
          ExecutionsGrpc.getGetExecutionMethod =
              getGetExecutionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.run.v2.GetExecutionRequest,
                          com.google.cloud.run.v2.Execution>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetExecution"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.GetExecutionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.Execution.getDefaultInstance()))
                      .setSchemaDescriptor(new ExecutionsMethodDescriptorSupplier("GetExecution"))
                      .build();
        }
      }
    }
    return getGetExecutionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.ListExecutionsRequest,
          com.google.cloud.run.v2.ListExecutionsResponse>
      getListExecutionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListExecutions",
      requestType = com.google.cloud.run.v2.ListExecutionsRequest.class,
      responseType = com.google.cloud.run.v2.ListExecutionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.ListExecutionsRequest,
          com.google.cloud.run.v2.ListExecutionsResponse>
      getListExecutionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.run.v2.ListExecutionsRequest,
            com.google.cloud.run.v2.ListExecutionsResponse>
        getListExecutionsMethod;
    if ((getListExecutionsMethod = ExecutionsGrpc.getListExecutionsMethod) == null) {
      synchronized (ExecutionsGrpc.class) {
        if ((getListExecutionsMethod = ExecutionsGrpc.getListExecutionsMethod) == null) {
          ExecutionsGrpc.getListExecutionsMethod =
              getListExecutionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.run.v2.ListExecutionsRequest,
                          com.google.cloud.run.v2.ListExecutionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListExecutions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.ListExecutionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.ListExecutionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new ExecutionsMethodDescriptorSupplier("ListExecutions"))
                      .build();
        }
      }
    }
    return getListExecutionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.DeleteExecutionRequest, com.google.longrunning.Operation>
      getDeleteExecutionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteExecution",
      requestType = com.google.cloud.run.v2.DeleteExecutionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.DeleteExecutionRequest, com.google.longrunning.Operation>
      getDeleteExecutionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.run.v2.DeleteExecutionRequest, com.google.longrunning.Operation>
        getDeleteExecutionMethod;
    if ((getDeleteExecutionMethod = ExecutionsGrpc.getDeleteExecutionMethod) == null) {
      synchronized (ExecutionsGrpc.class) {
        if ((getDeleteExecutionMethod = ExecutionsGrpc.getDeleteExecutionMethod) == null) {
          ExecutionsGrpc.getDeleteExecutionMethod =
              getDeleteExecutionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.run.v2.DeleteExecutionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteExecution"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.DeleteExecutionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ExecutionsMethodDescriptorSupplier("DeleteExecution"))
                      .build();
        }
      }
    }
    return getDeleteExecutionMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ExecutionsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExecutionsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ExecutionsStub>() {
          @java.lang.Override
          public ExecutionsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ExecutionsStub(channel, callOptions);
          }
        };
    return ExecutionsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ExecutionsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExecutionsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ExecutionsBlockingStub>() {
          @java.lang.Override
          public ExecutionsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ExecutionsBlockingStub(channel, callOptions);
          }
        };
    return ExecutionsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ExecutionsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExecutionsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ExecutionsFutureStub>() {
          @java.lang.Override
          public ExecutionsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ExecutionsFutureStub(channel, callOptions);
          }
        };
    return ExecutionsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Cloud Run Execution Control Plane API.
   * </pre>
   */
  public abstract static class ExecutionsImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Gets information about an Execution.
     * </pre>
     */
    public void getExecution(
        com.google.cloud.run.v2.GetExecutionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.run.v2.Execution> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetExecutionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Executions from a Job.
     * </pre>
     */
    public void listExecutions(
        com.google.cloud.run.v2.ListExecutionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.run.v2.ListExecutionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListExecutionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Execution.
     * </pre>
     */
    public void deleteExecution(
        com.google.cloud.run.v2.DeleteExecutionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteExecutionMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getGetExecutionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.run.v2.GetExecutionRequest,
                      com.google.cloud.run.v2.Execution>(this, METHODID_GET_EXECUTION)))
          .addMethod(
              getListExecutionsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.run.v2.ListExecutionsRequest,
                      com.google.cloud.run.v2.ListExecutionsResponse>(
                      this, METHODID_LIST_EXECUTIONS)))
          .addMethod(
              getDeleteExecutionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.run.v2.DeleteExecutionRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_EXECUTION)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Cloud Run Execution Control Plane API.
   * </pre>
   */
  public static final class ExecutionsStub extends io.grpc.stub.AbstractAsyncStub<ExecutionsStub> {
    private ExecutionsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExecutionsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExecutionsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets information about an Execution.
     * </pre>
     */
    public void getExecution(
        com.google.cloud.run.v2.GetExecutionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.run.v2.Execution> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetExecutionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Executions from a Job.
     * </pre>
     */
    public void listExecutions(
        com.google.cloud.run.v2.ListExecutionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.run.v2.ListExecutionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListExecutionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Execution.
     * </pre>
     */
    public void deleteExecution(
        com.google.cloud.run.v2.DeleteExecutionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteExecutionMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Cloud Run Execution Control Plane API.
   * </pre>
   */
  public static final class ExecutionsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ExecutionsBlockingStub> {
    private ExecutionsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExecutionsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExecutionsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets information about an Execution.
     * </pre>
     */
    public com.google.cloud.run.v2.Execution getExecution(
        com.google.cloud.run.v2.GetExecutionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetExecutionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Executions from a Job.
     * </pre>
     */
    public com.google.cloud.run.v2.ListExecutionsResponse listExecutions(
        com.google.cloud.run.v2.ListExecutionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListExecutionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Execution.
     * </pre>
     */
    public com.google.longrunning.Operation deleteExecution(
        com.google.cloud.run.v2.DeleteExecutionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteExecutionMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Cloud Run Execution Control Plane API.
   * </pre>
   */
  public static final class ExecutionsFutureStub
      extends io.grpc.stub.AbstractFutureStub<ExecutionsFutureStub> {
    private ExecutionsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExecutionsFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExecutionsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets information about an Execution.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.run.v2.Execution>
        getExecution(com.google.cloud.run.v2.GetExecutionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetExecutionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Executions from a Job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.run.v2.ListExecutionsResponse>
        listExecutions(com.google.cloud.run.v2.ListExecutionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListExecutionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Execution.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteExecution(com.google.cloud.run.v2.DeleteExecutionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteExecutionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_EXECUTION = 0;
  private static final int METHODID_LIST_EXECUTIONS = 1;
  private static final int METHODID_DELETE_EXECUTION = 2;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ExecutionsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ExecutionsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_EXECUTION:
          serviceImpl.getExecution(
              (com.google.cloud.run.v2.GetExecutionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.run.v2.Execution>) responseObserver);
          break;
        case METHODID_LIST_EXECUTIONS:
          serviceImpl.listExecutions(
              (com.google.cloud.run.v2.ListExecutionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.run.v2.ListExecutionsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_EXECUTION:
          serviceImpl.deleteExecution(
              (com.google.cloud.run.v2.DeleteExecutionRequest) request,
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

  private abstract static class ExecutionsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ExecutionsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.run.v2.ExecutionProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Executions");
    }
  }

  private static final class ExecutionsFileDescriptorSupplier
      extends ExecutionsBaseDescriptorSupplier {
    ExecutionsFileDescriptorSupplier() {}
  }

  private static final class ExecutionsMethodDescriptorSupplier
      extends ExecutionsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ExecutionsMethodDescriptorSupplier(String methodName) {
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
      synchronized (ExecutionsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ExecutionsFileDescriptorSupplier())
                      .addMethod(getGetExecutionMethod())
                      .addMethod(getListExecutionsMethod())
                      .addMethod(getDeleteExecutionMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
