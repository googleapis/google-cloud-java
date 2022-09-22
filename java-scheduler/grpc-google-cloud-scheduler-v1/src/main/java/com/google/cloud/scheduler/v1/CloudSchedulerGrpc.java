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
package com.google.cloud.scheduler.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The Cloud Scheduler API allows external entities to reliably
 * schedule asynchronous jobs.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/scheduler/v1/cloudscheduler.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CloudSchedulerGrpc {

  private CloudSchedulerGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.scheduler.v1.CloudScheduler";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1.ListJobsRequest,
          com.google.cloud.scheduler.v1.ListJobsResponse>
      getListJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListJobs",
      requestType = com.google.cloud.scheduler.v1.ListJobsRequest.class,
      responseType = com.google.cloud.scheduler.v1.ListJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1.ListJobsRequest,
          com.google.cloud.scheduler.v1.ListJobsResponse>
      getListJobsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.scheduler.v1.ListJobsRequest,
            com.google.cloud.scheduler.v1.ListJobsResponse>
        getListJobsMethod;
    if ((getListJobsMethod = CloudSchedulerGrpc.getListJobsMethod) == null) {
      synchronized (CloudSchedulerGrpc.class) {
        if ((getListJobsMethod = CloudSchedulerGrpc.getListJobsMethod) == null) {
          CloudSchedulerGrpc.getListJobsMethod =
              getListJobsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.scheduler.v1.ListJobsRequest,
                          com.google.cloud.scheduler.v1.ListJobsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListJobs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.scheduler.v1.ListJobsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.scheduler.v1.ListJobsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new CloudSchedulerMethodDescriptorSupplier("ListJobs"))
                      .build();
        }
      }
    }
    return getListJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1.GetJobRequest, com.google.cloud.scheduler.v1.Job>
      getGetJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetJob",
      requestType = com.google.cloud.scheduler.v1.GetJobRequest.class,
      responseType = com.google.cloud.scheduler.v1.Job.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1.GetJobRequest, com.google.cloud.scheduler.v1.Job>
      getGetJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.scheduler.v1.GetJobRequest, com.google.cloud.scheduler.v1.Job>
        getGetJobMethod;
    if ((getGetJobMethod = CloudSchedulerGrpc.getGetJobMethod) == null) {
      synchronized (CloudSchedulerGrpc.class) {
        if ((getGetJobMethod = CloudSchedulerGrpc.getGetJobMethod) == null) {
          CloudSchedulerGrpc.getGetJobMethod =
              getGetJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.scheduler.v1.GetJobRequest,
                          com.google.cloud.scheduler.v1.Job>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.scheduler.v1.GetJobRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.scheduler.v1.Job.getDefaultInstance()))
                      .setSchemaDescriptor(new CloudSchedulerMethodDescriptorSupplier("GetJob"))
                      .build();
        }
      }
    }
    return getGetJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1.CreateJobRequest, com.google.cloud.scheduler.v1.Job>
      getCreateJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateJob",
      requestType = com.google.cloud.scheduler.v1.CreateJobRequest.class,
      responseType = com.google.cloud.scheduler.v1.Job.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1.CreateJobRequest, com.google.cloud.scheduler.v1.Job>
      getCreateJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.scheduler.v1.CreateJobRequest, com.google.cloud.scheduler.v1.Job>
        getCreateJobMethod;
    if ((getCreateJobMethod = CloudSchedulerGrpc.getCreateJobMethod) == null) {
      synchronized (CloudSchedulerGrpc.class) {
        if ((getCreateJobMethod = CloudSchedulerGrpc.getCreateJobMethod) == null) {
          CloudSchedulerGrpc.getCreateJobMethod =
              getCreateJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.scheduler.v1.CreateJobRequest,
                          com.google.cloud.scheduler.v1.Job>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.scheduler.v1.CreateJobRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.scheduler.v1.Job.getDefaultInstance()))
                      .setSchemaDescriptor(new CloudSchedulerMethodDescriptorSupplier("CreateJob"))
                      .build();
        }
      }
    }
    return getCreateJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1.UpdateJobRequest, com.google.cloud.scheduler.v1.Job>
      getUpdateJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateJob",
      requestType = com.google.cloud.scheduler.v1.UpdateJobRequest.class,
      responseType = com.google.cloud.scheduler.v1.Job.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1.UpdateJobRequest, com.google.cloud.scheduler.v1.Job>
      getUpdateJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.scheduler.v1.UpdateJobRequest, com.google.cloud.scheduler.v1.Job>
        getUpdateJobMethod;
    if ((getUpdateJobMethod = CloudSchedulerGrpc.getUpdateJobMethod) == null) {
      synchronized (CloudSchedulerGrpc.class) {
        if ((getUpdateJobMethod = CloudSchedulerGrpc.getUpdateJobMethod) == null) {
          CloudSchedulerGrpc.getUpdateJobMethod =
              getUpdateJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.scheduler.v1.UpdateJobRequest,
                          com.google.cloud.scheduler.v1.Job>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.scheduler.v1.UpdateJobRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.scheduler.v1.Job.getDefaultInstance()))
                      .setSchemaDescriptor(new CloudSchedulerMethodDescriptorSupplier("UpdateJob"))
                      .build();
        }
      }
    }
    return getUpdateJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1.DeleteJobRequest, com.google.protobuf.Empty>
      getDeleteJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteJob",
      requestType = com.google.cloud.scheduler.v1.DeleteJobRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1.DeleteJobRequest, com.google.protobuf.Empty>
      getDeleteJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.scheduler.v1.DeleteJobRequest, com.google.protobuf.Empty>
        getDeleteJobMethod;
    if ((getDeleteJobMethod = CloudSchedulerGrpc.getDeleteJobMethod) == null) {
      synchronized (CloudSchedulerGrpc.class) {
        if ((getDeleteJobMethod = CloudSchedulerGrpc.getDeleteJobMethod) == null) {
          CloudSchedulerGrpc.getDeleteJobMethod =
              getDeleteJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.scheduler.v1.DeleteJobRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.scheduler.v1.DeleteJobRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new CloudSchedulerMethodDescriptorSupplier("DeleteJob"))
                      .build();
        }
      }
    }
    return getDeleteJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1.PauseJobRequest, com.google.cloud.scheduler.v1.Job>
      getPauseJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PauseJob",
      requestType = com.google.cloud.scheduler.v1.PauseJobRequest.class,
      responseType = com.google.cloud.scheduler.v1.Job.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1.PauseJobRequest, com.google.cloud.scheduler.v1.Job>
      getPauseJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.scheduler.v1.PauseJobRequest, com.google.cloud.scheduler.v1.Job>
        getPauseJobMethod;
    if ((getPauseJobMethod = CloudSchedulerGrpc.getPauseJobMethod) == null) {
      synchronized (CloudSchedulerGrpc.class) {
        if ((getPauseJobMethod = CloudSchedulerGrpc.getPauseJobMethod) == null) {
          CloudSchedulerGrpc.getPauseJobMethod =
              getPauseJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.scheduler.v1.PauseJobRequest,
                          com.google.cloud.scheduler.v1.Job>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PauseJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.scheduler.v1.PauseJobRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.scheduler.v1.Job.getDefaultInstance()))
                      .setSchemaDescriptor(new CloudSchedulerMethodDescriptorSupplier("PauseJob"))
                      .build();
        }
      }
    }
    return getPauseJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1.ResumeJobRequest, com.google.cloud.scheduler.v1.Job>
      getResumeJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResumeJob",
      requestType = com.google.cloud.scheduler.v1.ResumeJobRequest.class,
      responseType = com.google.cloud.scheduler.v1.Job.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1.ResumeJobRequest, com.google.cloud.scheduler.v1.Job>
      getResumeJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.scheduler.v1.ResumeJobRequest, com.google.cloud.scheduler.v1.Job>
        getResumeJobMethod;
    if ((getResumeJobMethod = CloudSchedulerGrpc.getResumeJobMethod) == null) {
      synchronized (CloudSchedulerGrpc.class) {
        if ((getResumeJobMethod = CloudSchedulerGrpc.getResumeJobMethod) == null) {
          CloudSchedulerGrpc.getResumeJobMethod =
              getResumeJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.scheduler.v1.ResumeJobRequest,
                          com.google.cloud.scheduler.v1.Job>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResumeJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.scheduler.v1.ResumeJobRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.scheduler.v1.Job.getDefaultInstance()))
                      .setSchemaDescriptor(new CloudSchedulerMethodDescriptorSupplier("ResumeJob"))
                      .build();
        }
      }
    }
    return getResumeJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1.RunJobRequest, com.google.cloud.scheduler.v1.Job>
      getRunJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RunJob",
      requestType = com.google.cloud.scheduler.v1.RunJobRequest.class,
      responseType = com.google.cloud.scheduler.v1.Job.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1.RunJobRequest, com.google.cloud.scheduler.v1.Job>
      getRunJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.scheduler.v1.RunJobRequest, com.google.cloud.scheduler.v1.Job>
        getRunJobMethod;
    if ((getRunJobMethod = CloudSchedulerGrpc.getRunJobMethod) == null) {
      synchronized (CloudSchedulerGrpc.class) {
        if ((getRunJobMethod = CloudSchedulerGrpc.getRunJobMethod) == null) {
          CloudSchedulerGrpc.getRunJobMethod =
              getRunJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.scheduler.v1.RunJobRequest,
                          com.google.cloud.scheduler.v1.Job>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RunJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.scheduler.v1.RunJobRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.scheduler.v1.Job.getDefaultInstance()))
                      .setSchemaDescriptor(new CloudSchedulerMethodDescriptorSupplier("RunJob"))
                      .build();
        }
      }
    }
    return getRunJobMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static CloudSchedulerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudSchedulerStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudSchedulerStub>() {
          @java.lang.Override
          public CloudSchedulerStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudSchedulerStub(channel, callOptions);
          }
        };
    return CloudSchedulerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CloudSchedulerBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudSchedulerBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudSchedulerBlockingStub>() {
          @java.lang.Override
          public CloudSchedulerBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudSchedulerBlockingStub(channel, callOptions);
          }
        };
    return CloudSchedulerBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static CloudSchedulerFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudSchedulerFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudSchedulerFutureStub>() {
          @java.lang.Override
          public CloudSchedulerFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudSchedulerFutureStub(channel, callOptions);
          }
        };
    return CloudSchedulerFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The Cloud Scheduler API allows external entities to reliably
   * schedule asynchronous jobs.
   * </pre>
   */
  public abstract static class CloudSchedulerImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Lists jobs.
     * </pre>
     */
    public void listJobs(
        com.google.cloud.scheduler.v1.ListJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1.ListJobsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListJobsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a job.
     * </pre>
     */
    public void getJob(
        com.google.cloud.scheduler.v1.GetJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1.Job> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a job.
     * </pre>
     */
    public void createJob(
        com.google.cloud.scheduler.v1.CreateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1.Job> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a job.
     * If successful, the updated [Job][google.cloud.scheduler.v1.Job] is returned. If the job does
     * not exist, `NOT_FOUND` is returned.
     * If UpdateJob does not successfully return, it is possible for the
     * job to be in an [Job.State.UPDATE_FAILED][google.cloud.scheduler.v1.Job.State.UPDATE_FAILED] state. A job in this state may
     * not be executed. If this happens, retry the UpdateJob request
     * until a successful response is received.
     * </pre>
     */
    public void updateJob(
        com.google.cloud.scheduler.v1.UpdateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1.Job> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a job.
     * </pre>
     */
    public void deleteJob(
        com.google.cloud.scheduler.v1.DeleteJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Pauses a job.
     * If a job is paused then the system will stop executing the job
     * until it is re-enabled via [ResumeJob][google.cloud.scheduler.v1.CloudScheduler.ResumeJob]. The
     * state of the job is stored in [state][google.cloud.scheduler.v1.Job.state]; if paused it
     * will be set to [Job.State.PAUSED][google.cloud.scheduler.v1.Job.State.PAUSED]. A job must be in [Job.State.ENABLED][google.cloud.scheduler.v1.Job.State.ENABLED]
     * to be paused.
     * </pre>
     */
    public void pauseJob(
        com.google.cloud.scheduler.v1.PauseJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1.Job> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPauseJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resume a job.
     * This method reenables a job after it has been [Job.State.PAUSED][google.cloud.scheduler.v1.Job.State.PAUSED]. The
     * state of a job is stored in [Job.state][google.cloud.scheduler.v1.Job.state]; after calling this method it
     * will be set to [Job.State.ENABLED][google.cloud.scheduler.v1.Job.State.ENABLED]. A job must be in
     * [Job.State.PAUSED][google.cloud.scheduler.v1.Job.State.PAUSED] to be resumed.
     * </pre>
     */
    public void resumeJob(
        com.google.cloud.scheduler.v1.ResumeJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1.Job> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getResumeJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Forces a job to run now.
     * When this method is called, Cloud Scheduler will dispatch the job, even
     * if the job is already running.
     * </pre>
     */
    public void runJob(
        com.google.cloud.scheduler.v1.RunJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1.Job> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRunJobMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListJobsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.scheduler.v1.ListJobsRequest,
                      com.google.cloud.scheduler.v1.ListJobsResponse>(this, METHODID_LIST_JOBS)))
          .addMethod(
              getGetJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.scheduler.v1.GetJobRequest,
                      com.google.cloud.scheduler.v1.Job>(this, METHODID_GET_JOB)))
          .addMethod(
              getCreateJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.scheduler.v1.CreateJobRequest,
                      com.google.cloud.scheduler.v1.Job>(this, METHODID_CREATE_JOB)))
          .addMethod(
              getUpdateJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.scheduler.v1.UpdateJobRequest,
                      com.google.cloud.scheduler.v1.Job>(this, METHODID_UPDATE_JOB)))
          .addMethod(
              getDeleteJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.scheduler.v1.DeleteJobRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_JOB)))
          .addMethod(
              getPauseJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.scheduler.v1.PauseJobRequest,
                      com.google.cloud.scheduler.v1.Job>(this, METHODID_PAUSE_JOB)))
          .addMethod(
              getResumeJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.scheduler.v1.ResumeJobRequest,
                      com.google.cloud.scheduler.v1.Job>(this, METHODID_RESUME_JOB)))
          .addMethod(
              getRunJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.scheduler.v1.RunJobRequest,
                      com.google.cloud.scheduler.v1.Job>(this, METHODID_RUN_JOB)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * The Cloud Scheduler API allows external entities to reliably
   * schedule asynchronous jobs.
   * </pre>
   */
  public static final class CloudSchedulerStub
      extends io.grpc.stub.AbstractAsyncStub<CloudSchedulerStub> {
    private CloudSchedulerStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudSchedulerStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudSchedulerStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists jobs.
     * </pre>
     */
    public void listJobs(
        com.google.cloud.scheduler.v1.ListJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1.ListJobsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListJobsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a job.
     * </pre>
     */
    public void getJob(
        com.google.cloud.scheduler.v1.GetJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1.Job> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a job.
     * </pre>
     */
    public void createJob(
        com.google.cloud.scheduler.v1.CreateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1.Job> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a job.
     * If successful, the updated [Job][google.cloud.scheduler.v1.Job] is returned. If the job does
     * not exist, `NOT_FOUND` is returned.
     * If UpdateJob does not successfully return, it is possible for the
     * job to be in an [Job.State.UPDATE_FAILED][google.cloud.scheduler.v1.Job.State.UPDATE_FAILED] state. A job in this state may
     * not be executed. If this happens, retry the UpdateJob request
     * until a successful response is received.
     * </pre>
     */
    public void updateJob(
        com.google.cloud.scheduler.v1.UpdateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1.Job> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a job.
     * </pre>
     */
    public void deleteJob(
        com.google.cloud.scheduler.v1.DeleteJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Pauses a job.
     * If a job is paused then the system will stop executing the job
     * until it is re-enabled via [ResumeJob][google.cloud.scheduler.v1.CloudScheduler.ResumeJob]. The
     * state of the job is stored in [state][google.cloud.scheduler.v1.Job.state]; if paused it
     * will be set to [Job.State.PAUSED][google.cloud.scheduler.v1.Job.State.PAUSED]. A job must be in [Job.State.ENABLED][google.cloud.scheduler.v1.Job.State.ENABLED]
     * to be paused.
     * </pre>
     */
    public void pauseJob(
        com.google.cloud.scheduler.v1.PauseJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1.Job> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPauseJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resume a job.
     * This method reenables a job after it has been [Job.State.PAUSED][google.cloud.scheduler.v1.Job.State.PAUSED]. The
     * state of a job is stored in [Job.state][google.cloud.scheduler.v1.Job.state]; after calling this method it
     * will be set to [Job.State.ENABLED][google.cloud.scheduler.v1.Job.State.ENABLED]. A job must be in
     * [Job.State.PAUSED][google.cloud.scheduler.v1.Job.State.PAUSED] to be resumed.
     * </pre>
     */
    public void resumeJob(
        com.google.cloud.scheduler.v1.ResumeJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1.Job> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResumeJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Forces a job to run now.
     * When this method is called, Cloud Scheduler will dispatch the job, even
     * if the job is already running.
     * </pre>
     */
    public void runJob(
        com.google.cloud.scheduler.v1.RunJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1.Job> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRunJobMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * The Cloud Scheduler API allows external entities to reliably
   * schedule asynchronous jobs.
   * </pre>
   */
  public static final class CloudSchedulerBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CloudSchedulerBlockingStub> {
    private CloudSchedulerBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudSchedulerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudSchedulerBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists jobs.
     * </pre>
     */
    public com.google.cloud.scheduler.v1.ListJobsResponse listJobs(
        com.google.cloud.scheduler.v1.ListJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListJobsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a job.
     * </pre>
     */
    public com.google.cloud.scheduler.v1.Job getJob(
        com.google.cloud.scheduler.v1.GetJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a job.
     * </pre>
     */
    public com.google.cloud.scheduler.v1.Job createJob(
        com.google.cloud.scheduler.v1.CreateJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a job.
     * If successful, the updated [Job][google.cloud.scheduler.v1.Job] is returned. If the job does
     * not exist, `NOT_FOUND` is returned.
     * If UpdateJob does not successfully return, it is possible for the
     * job to be in an [Job.State.UPDATE_FAILED][google.cloud.scheduler.v1.Job.State.UPDATE_FAILED] state. A job in this state may
     * not be executed. If this happens, retry the UpdateJob request
     * until a successful response is received.
     * </pre>
     */
    public com.google.cloud.scheduler.v1.Job updateJob(
        com.google.cloud.scheduler.v1.UpdateJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a job.
     * </pre>
     */
    public com.google.protobuf.Empty deleteJob(
        com.google.cloud.scheduler.v1.DeleteJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Pauses a job.
     * If a job is paused then the system will stop executing the job
     * until it is re-enabled via [ResumeJob][google.cloud.scheduler.v1.CloudScheduler.ResumeJob]. The
     * state of the job is stored in [state][google.cloud.scheduler.v1.Job.state]; if paused it
     * will be set to [Job.State.PAUSED][google.cloud.scheduler.v1.Job.State.PAUSED]. A job must be in [Job.State.ENABLED][google.cloud.scheduler.v1.Job.State.ENABLED]
     * to be paused.
     * </pre>
     */
    public com.google.cloud.scheduler.v1.Job pauseJob(
        com.google.cloud.scheduler.v1.PauseJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPauseJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Resume a job.
     * This method reenables a job after it has been [Job.State.PAUSED][google.cloud.scheduler.v1.Job.State.PAUSED]. The
     * state of a job is stored in [Job.state][google.cloud.scheduler.v1.Job.state]; after calling this method it
     * will be set to [Job.State.ENABLED][google.cloud.scheduler.v1.Job.State.ENABLED]. A job must be in
     * [Job.State.PAUSED][google.cloud.scheduler.v1.Job.State.PAUSED] to be resumed.
     * </pre>
     */
    public com.google.cloud.scheduler.v1.Job resumeJob(
        com.google.cloud.scheduler.v1.ResumeJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResumeJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Forces a job to run now.
     * When this method is called, Cloud Scheduler will dispatch the job, even
     * if the job is already running.
     * </pre>
     */
    public com.google.cloud.scheduler.v1.Job runJob(
        com.google.cloud.scheduler.v1.RunJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRunJobMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * The Cloud Scheduler API allows external entities to reliably
   * schedule asynchronous jobs.
   * </pre>
   */
  public static final class CloudSchedulerFutureStub
      extends io.grpc.stub.AbstractFutureStub<CloudSchedulerFutureStub> {
    private CloudSchedulerFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudSchedulerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudSchedulerFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists jobs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.scheduler.v1.ListJobsResponse>
        listJobs(com.google.cloud.scheduler.v1.ListJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListJobsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.scheduler.v1.Job>
        getJob(com.google.cloud.scheduler.v1.GetJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.scheduler.v1.Job>
        createJob(com.google.cloud.scheduler.v1.CreateJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a job.
     * If successful, the updated [Job][google.cloud.scheduler.v1.Job] is returned. If the job does
     * not exist, `NOT_FOUND` is returned.
     * If UpdateJob does not successfully return, it is possible for the
     * job to be in an [Job.State.UPDATE_FAILED][google.cloud.scheduler.v1.Job.State.UPDATE_FAILED] state. A job in this state may
     * not be executed. If this happens, retry the UpdateJob request
     * until a successful response is received.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.scheduler.v1.Job>
        updateJob(com.google.cloud.scheduler.v1.UpdateJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteJob(
        com.google.cloud.scheduler.v1.DeleteJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Pauses a job.
     * If a job is paused then the system will stop executing the job
     * until it is re-enabled via [ResumeJob][google.cloud.scheduler.v1.CloudScheduler.ResumeJob]. The
     * state of the job is stored in [state][google.cloud.scheduler.v1.Job.state]; if paused it
     * will be set to [Job.State.PAUSED][google.cloud.scheduler.v1.Job.State.PAUSED]. A job must be in [Job.State.ENABLED][google.cloud.scheduler.v1.Job.State.ENABLED]
     * to be paused.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.scheduler.v1.Job>
        pauseJob(com.google.cloud.scheduler.v1.PauseJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPauseJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Resume a job.
     * This method reenables a job after it has been [Job.State.PAUSED][google.cloud.scheduler.v1.Job.State.PAUSED]. The
     * state of a job is stored in [Job.state][google.cloud.scheduler.v1.Job.state]; after calling this method it
     * will be set to [Job.State.ENABLED][google.cloud.scheduler.v1.Job.State.ENABLED]. A job must be in
     * [Job.State.PAUSED][google.cloud.scheduler.v1.Job.State.PAUSED] to be resumed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.scheduler.v1.Job>
        resumeJob(com.google.cloud.scheduler.v1.ResumeJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResumeJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Forces a job to run now.
     * When this method is called, Cloud Scheduler will dispatch the job, even
     * if the job is already running.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.scheduler.v1.Job>
        runJob(com.google.cloud.scheduler.v1.RunJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRunJobMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_JOBS = 0;
  private static final int METHODID_GET_JOB = 1;
  private static final int METHODID_CREATE_JOB = 2;
  private static final int METHODID_UPDATE_JOB = 3;
  private static final int METHODID_DELETE_JOB = 4;
  private static final int METHODID_PAUSE_JOB = 5;
  private static final int METHODID_RESUME_JOB = 6;
  private static final int METHODID_RUN_JOB = 7;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CloudSchedulerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CloudSchedulerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_JOBS:
          serviceImpl.listJobs(
              (com.google.cloud.scheduler.v1.ListJobsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1.ListJobsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_JOB:
          serviceImpl.getJob(
              (com.google.cloud.scheduler.v1.GetJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1.Job>) responseObserver);
          break;
        case METHODID_CREATE_JOB:
          serviceImpl.createJob(
              (com.google.cloud.scheduler.v1.CreateJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1.Job>) responseObserver);
          break;
        case METHODID_UPDATE_JOB:
          serviceImpl.updateJob(
              (com.google.cloud.scheduler.v1.UpdateJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1.Job>) responseObserver);
          break;
        case METHODID_DELETE_JOB:
          serviceImpl.deleteJob(
              (com.google.cloud.scheduler.v1.DeleteJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_PAUSE_JOB:
          serviceImpl.pauseJob(
              (com.google.cloud.scheduler.v1.PauseJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1.Job>) responseObserver);
          break;
        case METHODID_RESUME_JOB:
          serviceImpl.resumeJob(
              (com.google.cloud.scheduler.v1.ResumeJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1.Job>) responseObserver);
          break;
        case METHODID_RUN_JOB:
          serviceImpl.runJob(
              (com.google.cloud.scheduler.v1.RunJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1.Job>) responseObserver);
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

  private abstract static class CloudSchedulerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CloudSchedulerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.scheduler.v1.SchedulerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CloudScheduler");
    }
  }

  private static final class CloudSchedulerFileDescriptorSupplier
      extends CloudSchedulerBaseDescriptorSupplier {
    CloudSchedulerFileDescriptorSupplier() {}
  }

  private static final class CloudSchedulerMethodDescriptorSupplier
      extends CloudSchedulerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CloudSchedulerMethodDescriptorSupplier(String methodName) {
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
      synchronized (CloudSchedulerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new CloudSchedulerFileDescriptorSupplier())
                      .addMethod(getListJobsMethod())
                      .addMethod(getGetJobMethod())
                      .addMethod(getCreateJobMethod())
                      .addMethod(getUpdateJobMethod())
                      .addMethod(getDeleteJobMethod())
                      .addMethod(getPauseJobMethod())
                      .addMethod(getResumeJobMethod())
                      .addMethod(getRunJobMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
