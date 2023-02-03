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
 * Cloud Run Task Control Plane API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/run/v2/task.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TasksGrpc {

  private TasksGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.run.v2.Tasks";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.GetTaskRequest, com.google.cloud.run.v2.Task>
      getGetTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTask",
      requestType = com.google.cloud.run.v2.GetTaskRequest.class,
      responseType = com.google.cloud.run.v2.Task.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.GetTaskRequest, com.google.cloud.run.v2.Task>
      getGetTaskMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.run.v2.GetTaskRequest, com.google.cloud.run.v2.Task>
        getGetTaskMethod;
    if ((getGetTaskMethod = TasksGrpc.getGetTaskMethod) == null) {
      synchronized (TasksGrpc.class) {
        if ((getGetTaskMethod = TasksGrpc.getGetTaskMethod) == null) {
          TasksGrpc.getGetTaskMethod =
              getGetTaskMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.run.v2.GetTaskRequest, com.google.cloud.run.v2.Task>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTask"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.GetTaskRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.Task.getDefaultInstance()))
                      .setSchemaDescriptor(new TasksMethodDescriptorSupplier("GetTask"))
                      .build();
        }
      }
    }
    return getGetTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.ListTasksRequest, com.google.cloud.run.v2.ListTasksResponse>
      getListTasksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTasks",
      requestType = com.google.cloud.run.v2.ListTasksRequest.class,
      responseType = com.google.cloud.run.v2.ListTasksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.ListTasksRequest, com.google.cloud.run.v2.ListTasksResponse>
      getListTasksMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.run.v2.ListTasksRequest, com.google.cloud.run.v2.ListTasksResponse>
        getListTasksMethod;
    if ((getListTasksMethod = TasksGrpc.getListTasksMethod) == null) {
      synchronized (TasksGrpc.class) {
        if ((getListTasksMethod = TasksGrpc.getListTasksMethod) == null) {
          TasksGrpc.getListTasksMethod =
              getListTasksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.run.v2.ListTasksRequest,
                          com.google.cloud.run.v2.ListTasksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTasks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.ListTasksRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.ListTasksResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new TasksMethodDescriptorSupplier("ListTasks"))
                      .build();
        }
      }
    }
    return getListTasksMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static TasksStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TasksStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TasksStub>() {
          @java.lang.Override
          public TasksStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TasksStub(channel, callOptions);
          }
        };
    return TasksStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TasksBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TasksBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TasksBlockingStub>() {
          @java.lang.Override
          public TasksBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TasksBlockingStub(channel, callOptions);
          }
        };
    return TasksBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static TasksFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TasksFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TasksFutureStub>() {
          @java.lang.Override
          public TasksFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TasksFutureStub(channel, callOptions);
          }
        };
    return TasksFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Cloud Run Task Control Plane API.
   * </pre>
   */
  public abstract static class TasksImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Gets information about a Task.
     * </pre>
     */
    public void getTask(
        com.google.cloud.run.v2.GetTaskRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.run.v2.Task> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTaskMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Tasks from an Execution of a Job.
     * </pre>
     */
    public void listTasks(
        com.google.cloud.run.v2.ListTasksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.run.v2.ListTasksResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListTasksMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getGetTaskMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.run.v2.GetTaskRequest, com.google.cloud.run.v2.Task>(
                      this, METHODID_GET_TASK)))
          .addMethod(
              getListTasksMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.run.v2.ListTasksRequest,
                      com.google.cloud.run.v2.ListTasksResponse>(this, METHODID_LIST_TASKS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Cloud Run Task Control Plane API.
   * </pre>
   */
  public static final class TasksStub extends io.grpc.stub.AbstractAsyncStub<TasksStub> {
    private TasksStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TasksStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TasksStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a Task.
     * </pre>
     */
    public void getTask(
        com.google.cloud.run.v2.GetTaskRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.run.v2.Task> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTaskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Tasks from an Execution of a Job.
     * </pre>
     */
    public void listTasks(
        com.google.cloud.run.v2.ListTasksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.run.v2.ListTasksResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTasksMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Cloud Run Task Control Plane API.
   * </pre>
   */
  public static final class TasksBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TasksBlockingStub> {
    private TasksBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TasksBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TasksBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a Task.
     * </pre>
     */
    public com.google.cloud.run.v2.Task getTask(com.google.cloud.run.v2.GetTaskRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTaskMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Tasks from an Execution of a Job.
     * </pre>
     */
    public com.google.cloud.run.v2.ListTasksResponse listTasks(
        com.google.cloud.run.v2.ListTasksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTasksMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Cloud Run Task Control Plane API.
   * </pre>
   */
  public static final class TasksFutureStub
      extends io.grpc.stub.AbstractFutureStub<TasksFutureStub> {
    private TasksFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TasksFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TasksFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a Task.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.run.v2.Task> getTask(
        com.google.cloud.run.v2.GetTaskRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTaskMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Tasks from an Execution of a Job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.run.v2.ListTasksResponse>
        listTasks(com.google.cloud.run.v2.ListTasksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTasksMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_TASK = 0;
  private static final int METHODID_LIST_TASKS = 1;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TasksImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TasksImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_TASK:
          serviceImpl.getTask(
              (com.google.cloud.run.v2.GetTaskRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.run.v2.Task>) responseObserver);
          break;
        case METHODID_LIST_TASKS:
          serviceImpl.listTasks(
              (com.google.cloud.run.v2.ListTasksRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.run.v2.ListTasksResponse>)
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

  private abstract static class TasksBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TasksBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.run.v2.TaskProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Tasks");
    }
  }

  private static final class TasksFileDescriptorSupplier extends TasksBaseDescriptorSupplier {
    TasksFileDescriptorSupplier() {}
  }

  private static final class TasksMethodDescriptorSupplier extends TasksBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TasksMethodDescriptorSupplier(String methodName) {
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
      synchronized (TasksGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new TasksFileDescriptorSupplier())
                      .addMethod(getGetTaskMethod())
                      .addMethod(getListTasksMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
