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
package com.google.cloud.batch.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Google Batch Service.
 * The service manages user submitted batch jobs and allocates Google Compute
 * Engine VM instances to run the jobs.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/batch/v1/batch.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BatchServiceGrpc {

  private BatchServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.batch.v1.BatchService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1.CreateJobRequest, com.google.cloud.batch.v1.Job>
      getCreateJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateJob",
      requestType = com.google.cloud.batch.v1.CreateJobRequest.class,
      responseType = com.google.cloud.batch.v1.Job.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1.CreateJobRequest, com.google.cloud.batch.v1.Job>
      getCreateJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.batch.v1.CreateJobRequest, com.google.cloud.batch.v1.Job>
        getCreateJobMethod;
    if ((getCreateJobMethod = BatchServiceGrpc.getCreateJobMethod) == null) {
      synchronized (BatchServiceGrpc.class) {
        if ((getCreateJobMethod = BatchServiceGrpc.getCreateJobMethod) == null) {
          BatchServiceGrpc.getCreateJobMethod =
              getCreateJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.batch.v1.CreateJobRequest, com.google.cloud.batch.v1.Job>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.batch.v1.CreateJobRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.batch.v1.Job.getDefaultInstance()))
                      .setSchemaDescriptor(new BatchServiceMethodDescriptorSupplier("CreateJob"))
                      .build();
        }
      }
    }
    return getCreateJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1.GetJobRequest, com.google.cloud.batch.v1.Job>
      getGetJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetJob",
      requestType = com.google.cloud.batch.v1.GetJobRequest.class,
      responseType = com.google.cloud.batch.v1.Job.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1.GetJobRequest, com.google.cloud.batch.v1.Job>
      getGetJobMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.batch.v1.GetJobRequest, com.google.cloud.batch.v1.Job>
        getGetJobMethod;
    if ((getGetJobMethod = BatchServiceGrpc.getGetJobMethod) == null) {
      synchronized (BatchServiceGrpc.class) {
        if ((getGetJobMethod = BatchServiceGrpc.getGetJobMethod) == null) {
          BatchServiceGrpc.getGetJobMethod =
              getGetJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.batch.v1.GetJobRequest, com.google.cloud.batch.v1.Job>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.batch.v1.GetJobRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.batch.v1.Job.getDefaultInstance()))
                      .setSchemaDescriptor(new BatchServiceMethodDescriptorSupplier("GetJob"))
                      .build();
        }
      }
    }
    return getGetJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1.DeleteJobRequest, com.google.longrunning.Operation>
      getDeleteJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteJob",
      requestType = com.google.cloud.batch.v1.DeleteJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1.DeleteJobRequest, com.google.longrunning.Operation>
      getDeleteJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.batch.v1.DeleteJobRequest, com.google.longrunning.Operation>
        getDeleteJobMethod;
    if ((getDeleteJobMethod = BatchServiceGrpc.getDeleteJobMethod) == null) {
      synchronized (BatchServiceGrpc.class) {
        if ((getDeleteJobMethod = BatchServiceGrpc.getDeleteJobMethod) == null) {
          BatchServiceGrpc.getDeleteJobMethod =
              getDeleteJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.batch.v1.DeleteJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.batch.v1.DeleteJobRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new BatchServiceMethodDescriptorSupplier("DeleteJob"))
                      .build();
        }
      }
    }
    return getDeleteJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1.ListJobsRequest, com.google.cloud.batch.v1.ListJobsResponse>
      getListJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListJobs",
      requestType = com.google.cloud.batch.v1.ListJobsRequest.class,
      responseType = com.google.cloud.batch.v1.ListJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1.ListJobsRequest, com.google.cloud.batch.v1.ListJobsResponse>
      getListJobsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.batch.v1.ListJobsRequest, com.google.cloud.batch.v1.ListJobsResponse>
        getListJobsMethod;
    if ((getListJobsMethod = BatchServiceGrpc.getListJobsMethod) == null) {
      synchronized (BatchServiceGrpc.class) {
        if ((getListJobsMethod = BatchServiceGrpc.getListJobsMethod) == null) {
          BatchServiceGrpc.getListJobsMethod =
              getListJobsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.batch.v1.ListJobsRequest,
                          com.google.cloud.batch.v1.ListJobsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListJobs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.batch.v1.ListJobsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.batch.v1.ListJobsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new BatchServiceMethodDescriptorSupplier("ListJobs"))
                      .build();
        }
      }
    }
    return getListJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1.GetTaskRequest, com.google.cloud.batch.v1.Task>
      getGetTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTask",
      requestType = com.google.cloud.batch.v1.GetTaskRequest.class,
      responseType = com.google.cloud.batch.v1.Task.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1.GetTaskRequest, com.google.cloud.batch.v1.Task>
      getGetTaskMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.batch.v1.GetTaskRequest, com.google.cloud.batch.v1.Task>
        getGetTaskMethod;
    if ((getGetTaskMethod = BatchServiceGrpc.getGetTaskMethod) == null) {
      synchronized (BatchServiceGrpc.class) {
        if ((getGetTaskMethod = BatchServiceGrpc.getGetTaskMethod) == null) {
          BatchServiceGrpc.getGetTaskMethod =
              getGetTaskMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.batch.v1.GetTaskRequest, com.google.cloud.batch.v1.Task>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTask"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.batch.v1.GetTaskRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.batch.v1.Task.getDefaultInstance()))
                      .setSchemaDescriptor(new BatchServiceMethodDescriptorSupplier("GetTask"))
                      .build();
        }
      }
    }
    return getGetTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1.ListTasksRequest, com.google.cloud.batch.v1.ListTasksResponse>
      getListTasksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTasks",
      requestType = com.google.cloud.batch.v1.ListTasksRequest.class,
      responseType = com.google.cloud.batch.v1.ListTasksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1.ListTasksRequest, com.google.cloud.batch.v1.ListTasksResponse>
      getListTasksMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.batch.v1.ListTasksRequest, com.google.cloud.batch.v1.ListTasksResponse>
        getListTasksMethod;
    if ((getListTasksMethod = BatchServiceGrpc.getListTasksMethod) == null) {
      synchronized (BatchServiceGrpc.class) {
        if ((getListTasksMethod = BatchServiceGrpc.getListTasksMethod) == null) {
          BatchServiceGrpc.getListTasksMethod =
              getListTasksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.batch.v1.ListTasksRequest,
                          com.google.cloud.batch.v1.ListTasksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTasks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.batch.v1.ListTasksRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.batch.v1.ListTasksResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new BatchServiceMethodDescriptorSupplier("ListTasks"))
                      .build();
        }
      }
    }
    return getListTasksMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static BatchServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BatchServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BatchServiceStub>() {
          @java.lang.Override
          public BatchServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BatchServiceStub(channel, callOptions);
          }
        };
    return BatchServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BatchServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BatchServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BatchServiceBlockingStub>() {
          @java.lang.Override
          public BatchServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BatchServiceBlockingStub(channel, callOptions);
          }
        };
    return BatchServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static BatchServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BatchServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BatchServiceFutureStub>() {
          @java.lang.Override
          public BatchServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BatchServiceFutureStub(channel, callOptions);
          }
        };
    return BatchServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Google Batch Service.
   * The service manages user submitted batch jobs and allocates Google Compute
   * Engine VM instances to run the jobs.
   * </pre>
   */
  public abstract static class BatchServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Create a Job.
     * </pre>
     */
    public void createJob(
        com.google.cloud.batch.v1.CreateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.batch.v1.Job> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a Job specified by its resource name.
     * </pre>
     */
    public void getJob(
        com.google.cloud.batch.v1.GetJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.batch.v1.Job> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a Job.
     * </pre>
     */
    public void deleteJob(
        com.google.cloud.batch.v1.DeleteJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all Jobs for a project within a region.
     * </pre>
     */
    public void listJobs(
        com.google.cloud.batch.v1.ListJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.batch.v1.ListJobsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListJobsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Return a single Task.
     * </pre>
     */
    public void getTask(
        com.google.cloud.batch.v1.GetTaskRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.batch.v1.Task> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTaskMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List Tasks associated with a job.
     * </pre>
     */
    public void listTasks(
        com.google.cloud.batch.v1.ListTasksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.batch.v1.ListTasksResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListTasksMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.batch.v1.CreateJobRequest, com.google.cloud.batch.v1.Job>(
                      this, METHODID_CREATE_JOB)))
          .addMethod(
              getGetJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.batch.v1.GetJobRequest, com.google.cloud.batch.v1.Job>(
                      this, METHODID_GET_JOB)))
          .addMethod(
              getDeleteJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.batch.v1.DeleteJobRequest, com.google.longrunning.Operation>(
                      this, METHODID_DELETE_JOB)))
          .addMethod(
              getListJobsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.batch.v1.ListJobsRequest,
                      com.google.cloud.batch.v1.ListJobsResponse>(this, METHODID_LIST_JOBS)))
          .addMethod(
              getGetTaskMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.batch.v1.GetTaskRequest, com.google.cloud.batch.v1.Task>(
                      this, METHODID_GET_TASK)))
          .addMethod(
              getListTasksMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.batch.v1.ListTasksRequest,
                      com.google.cloud.batch.v1.ListTasksResponse>(this, METHODID_LIST_TASKS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Google Batch Service.
   * The service manages user submitted batch jobs and allocates Google Compute
   * Engine VM instances to run the jobs.
   * </pre>
   */
  public static final class BatchServiceStub
      extends io.grpc.stub.AbstractAsyncStub<BatchServiceStub> {
    private BatchServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BatchServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BatchServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a Job.
     * </pre>
     */
    public void createJob(
        com.google.cloud.batch.v1.CreateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.batch.v1.Job> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a Job specified by its resource name.
     * </pre>
     */
    public void getJob(
        com.google.cloud.batch.v1.GetJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.batch.v1.Job> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a Job.
     * </pre>
     */
    public void deleteJob(
        com.google.cloud.batch.v1.DeleteJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all Jobs for a project within a region.
     * </pre>
     */
    public void listJobs(
        com.google.cloud.batch.v1.ListJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.batch.v1.ListJobsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListJobsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Return a single Task.
     * </pre>
     */
    public void getTask(
        com.google.cloud.batch.v1.GetTaskRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.batch.v1.Task> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTaskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List Tasks associated with a job.
     * </pre>
     */
    public void listTasks(
        com.google.cloud.batch.v1.ListTasksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.batch.v1.ListTasksResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTasksMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Google Batch Service.
   * The service manages user submitted batch jobs and allocates Google Compute
   * Engine VM instances to run the jobs.
   * </pre>
   */
  public static final class BatchServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<BatchServiceBlockingStub> {
    private BatchServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BatchServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BatchServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a Job.
     * </pre>
     */
    public com.google.cloud.batch.v1.Job createJob(
        com.google.cloud.batch.v1.CreateJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a Job specified by its resource name.
     * </pre>
     */
    public com.google.cloud.batch.v1.Job getJob(com.google.cloud.batch.v1.GetJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a Job.
     * </pre>
     */
    public com.google.longrunning.Operation deleteJob(
        com.google.cloud.batch.v1.DeleteJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all Jobs for a project within a region.
     * </pre>
     */
    public com.google.cloud.batch.v1.ListJobsResponse listJobs(
        com.google.cloud.batch.v1.ListJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListJobsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Return a single Task.
     * </pre>
     */
    public com.google.cloud.batch.v1.Task getTask(
        com.google.cloud.batch.v1.GetTaskRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTaskMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List Tasks associated with a job.
     * </pre>
     */
    public com.google.cloud.batch.v1.ListTasksResponse listTasks(
        com.google.cloud.batch.v1.ListTasksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTasksMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Google Batch Service.
   * The service manages user submitted batch jobs and allocates Google Compute
   * Engine VM instances to run the jobs.
   * </pre>
   */
  public static final class BatchServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<BatchServiceFutureStub> {
    private BatchServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BatchServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BatchServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a Job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.batch.v1.Job>
        createJob(com.google.cloud.batch.v1.CreateJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get a Job specified by its resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.batch.v1.Job> getJob(
        com.google.cloud.batch.v1.GetJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a Job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteJob(com.google.cloud.batch.v1.DeleteJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List all Jobs for a project within a region.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.batch.v1.ListJobsResponse>
        listJobs(com.google.cloud.batch.v1.ListJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListJobsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Return a single Task.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.batch.v1.Task>
        getTask(com.google.cloud.batch.v1.GetTaskRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTaskMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List Tasks associated with a job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.batch.v1.ListTasksResponse>
        listTasks(com.google.cloud.batch.v1.ListTasksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTasksMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_JOB = 0;
  private static final int METHODID_GET_JOB = 1;
  private static final int METHODID_DELETE_JOB = 2;
  private static final int METHODID_LIST_JOBS = 3;
  private static final int METHODID_GET_TASK = 4;
  private static final int METHODID_LIST_TASKS = 5;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BatchServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BatchServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_JOB:
          serviceImpl.createJob(
              (com.google.cloud.batch.v1.CreateJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.batch.v1.Job>) responseObserver);
          break;
        case METHODID_GET_JOB:
          serviceImpl.getJob(
              (com.google.cloud.batch.v1.GetJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.batch.v1.Job>) responseObserver);
          break;
        case METHODID_DELETE_JOB:
          serviceImpl.deleteJob(
              (com.google.cloud.batch.v1.DeleteJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_JOBS:
          serviceImpl.listJobs(
              (com.google.cloud.batch.v1.ListJobsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.batch.v1.ListJobsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_TASK:
          serviceImpl.getTask(
              (com.google.cloud.batch.v1.GetTaskRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.batch.v1.Task>) responseObserver);
          break;
        case METHODID_LIST_TASKS:
          serviceImpl.listTasks(
              (com.google.cloud.batch.v1.ListTasksRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.batch.v1.ListTasksResponse>)
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

  private abstract static class BatchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BatchServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.batch.v1.BatchProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BatchService");
    }
  }

  private static final class BatchServiceFileDescriptorSupplier
      extends BatchServiceBaseDescriptorSupplier {
    BatchServiceFileDescriptorSupplier() {}
  }

  private static final class BatchServiceMethodDescriptorSupplier
      extends BatchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BatchServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BatchServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new BatchServiceFileDescriptorSupplier())
                      .addMethod(getCreateJobMethod())
                      .addMethod(getGetJobMethod())
                      .addMethod(getDeleteJobMethod())
                      .addMethod(getListJobsMethod())
                      .addMethod(getGetTaskMethod())
                      .addMethod(getListTasksMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
