package com.google.cloud.scheduler.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 *
 * <pre>
 * The Cloud Scheduler API allows external entities to reliably
 * schedule asynchronous jobs.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/scheduler/v1beta1/cloudscheduler.proto")
public final class CloudSchedulerGrpc {

  private CloudSchedulerGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.scheduler.v1beta1.CloudScheduler";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListJobsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1beta1.ListJobsRequest,
          com.google.cloud.scheduler.v1beta1.ListJobsResponse>
      METHOD_LIST_JOBS = getListJobsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1beta1.ListJobsRequest,
          com.google.cloud.scheduler.v1beta1.ListJobsResponse>
      getListJobsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1beta1.ListJobsRequest,
          com.google.cloud.scheduler.v1beta1.ListJobsResponse>
      getListJobsMethod() {
    return getListJobsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1beta1.ListJobsRequest,
          com.google.cloud.scheduler.v1beta1.ListJobsResponse>
      getListJobsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.scheduler.v1beta1.ListJobsRequest,
            com.google.cloud.scheduler.v1beta1.ListJobsResponse>
        getListJobsMethod;
    if ((getListJobsMethod = CloudSchedulerGrpc.getListJobsMethod) == null) {
      synchronized (CloudSchedulerGrpc.class) {
        if ((getListJobsMethod = CloudSchedulerGrpc.getListJobsMethod) == null) {
          CloudSchedulerGrpc.getListJobsMethod =
              getListJobsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.scheduler.v1beta1.ListJobsRequest,
                          com.google.cloud.scheduler.v1beta1.ListJobsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.scheduler.v1beta1.CloudScheduler", "ListJobs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.scheduler.v1beta1.ListJobsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.scheduler.v1beta1.ListJobsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new CloudSchedulerMethodDescriptorSupplier("ListJobs"))
                      .build();
        }
      }
    }
    return getListJobsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetJobMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1beta1.GetJobRequest, com.google.cloud.scheduler.v1beta1.Job>
      METHOD_GET_JOB = getGetJobMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1beta1.GetJobRequest, com.google.cloud.scheduler.v1beta1.Job>
      getGetJobMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1beta1.GetJobRequest, com.google.cloud.scheduler.v1beta1.Job>
      getGetJobMethod() {
    return getGetJobMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1beta1.GetJobRequest, com.google.cloud.scheduler.v1beta1.Job>
      getGetJobMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.scheduler.v1beta1.GetJobRequest,
            com.google.cloud.scheduler.v1beta1.Job>
        getGetJobMethod;
    if ((getGetJobMethod = CloudSchedulerGrpc.getGetJobMethod) == null) {
      synchronized (CloudSchedulerGrpc.class) {
        if ((getGetJobMethod = CloudSchedulerGrpc.getGetJobMethod) == null) {
          CloudSchedulerGrpc.getGetJobMethod =
              getGetJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.scheduler.v1beta1.GetJobRequest,
                          com.google.cloud.scheduler.v1beta1.Job>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.scheduler.v1beta1.CloudScheduler", "GetJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.scheduler.v1beta1.GetJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.scheduler.v1beta1.Job.getDefaultInstance()))
                      .setSchemaDescriptor(new CloudSchedulerMethodDescriptorSupplier("GetJob"))
                      .build();
        }
      }
    }
    return getGetJobMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateJobMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1beta1.CreateJobRequest,
          com.google.cloud.scheduler.v1beta1.Job>
      METHOD_CREATE_JOB = getCreateJobMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1beta1.CreateJobRequest,
          com.google.cloud.scheduler.v1beta1.Job>
      getCreateJobMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1beta1.CreateJobRequest,
          com.google.cloud.scheduler.v1beta1.Job>
      getCreateJobMethod() {
    return getCreateJobMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1beta1.CreateJobRequest,
          com.google.cloud.scheduler.v1beta1.Job>
      getCreateJobMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.scheduler.v1beta1.CreateJobRequest,
            com.google.cloud.scheduler.v1beta1.Job>
        getCreateJobMethod;
    if ((getCreateJobMethod = CloudSchedulerGrpc.getCreateJobMethod) == null) {
      synchronized (CloudSchedulerGrpc.class) {
        if ((getCreateJobMethod = CloudSchedulerGrpc.getCreateJobMethod) == null) {
          CloudSchedulerGrpc.getCreateJobMethod =
              getCreateJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.scheduler.v1beta1.CreateJobRequest,
                          com.google.cloud.scheduler.v1beta1.Job>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.scheduler.v1beta1.CloudScheduler", "CreateJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.scheduler.v1beta1.CreateJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.scheduler.v1beta1.Job.getDefaultInstance()))
                      .setSchemaDescriptor(new CloudSchedulerMethodDescriptorSupplier("CreateJob"))
                      .build();
        }
      }
    }
    return getCreateJobMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateJobMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1beta1.UpdateJobRequest,
          com.google.cloud.scheduler.v1beta1.Job>
      METHOD_UPDATE_JOB = getUpdateJobMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1beta1.UpdateJobRequest,
          com.google.cloud.scheduler.v1beta1.Job>
      getUpdateJobMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1beta1.UpdateJobRequest,
          com.google.cloud.scheduler.v1beta1.Job>
      getUpdateJobMethod() {
    return getUpdateJobMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1beta1.UpdateJobRequest,
          com.google.cloud.scheduler.v1beta1.Job>
      getUpdateJobMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.scheduler.v1beta1.UpdateJobRequest,
            com.google.cloud.scheduler.v1beta1.Job>
        getUpdateJobMethod;
    if ((getUpdateJobMethod = CloudSchedulerGrpc.getUpdateJobMethod) == null) {
      synchronized (CloudSchedulerGrpc.class) {
        if ((getUpdateJobMethod = CloudSchedulerGrpc.getUpdateJobMethod) == null) {
          CloudSchedulerGrpc.getUpdateJobMethod =
              getUpdateJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.scheduler.v1beta1.UpdateJobRequest,
                          com.google.cloud.scheduler.v1beta1.Job>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.scheduler.v1beta1.CloudScheduler", "UpdateJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.scheduler.v1beta1.UpdateJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.scheduler.v1beta1.Job.getDefaultInstance()))
                      .setSchemaDescriptor(new CloudSchedulerMethodDescriptorSupplier("UpdateJob"))
                      .build();
        }
      }
    }
    return getUpdateJobMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteJobMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1beta1.DeleteJobRequest, com.google.protobuf.Empty>
      METHOD_DELETE_JOB = getDeleteJobMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1beta1.DeleteJobRequest, com.google.protobuf.Empty>
      getDeleteJobMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1beta1.DeleteJobRequest, com.google.protobuf.Empty>
      getDeleteJobMethod() {
    return getDeleteJobMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1beta1.DeleteJobRequest, com.google.protobuf.Empty>
      getDeleteJobMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.scheduler.v1beta1.DeleteJobRequest, com.google.protobuf.Empty>
        getDeleteJobMethod;
    if ((getDeleteJobMethod = CloudSchedulerGrpc.getDeleteJobMethod) == null) {
      synchronized (CloudSchedulerGrpc.class) {
        if ((getDeleteJobMethod = CloudSchedulerGrpc.getDeleteJobMethod) == null) {
          CloudSchedulerGrpc.getDeleteJobMethod =
              getDeleteJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.scheduler.v1beta1.DeleteJobRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.scheduler.v1beta1.CloudScheduler", "DeleteJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.scheduler.v1beta1.DeleteJobRequest
                                  .getDefaultInstance()))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getPauseJobMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1beta1.PauseJobRequest,
          com.google.cloud.scheduler.v1beta1.Job>
      METHOD_PAUSE_JOB = getPauseJobMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1beta1.PauseJobRequest,
          com.google.cloud.scheduler.v1beta1.Job>
      getPauseJobMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1beta1.PauseJobRequest,
          com.google.cloud.scheduler.v1beta1.Job>
      getPauseJobMethod() {
    return getPauseJobMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1beta1.PauseJobRequest,
          com.google.cloud.scheduler.v1beta1.Job>
      getPauseJobMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.scheduler.v1beta1.PauseJobRequest,
            com.google.cloud.scheduler.v1beta1.Job>
        getPauseJobMethod;
    if ((getPauseJobMethod = CloudSchedulerGrpc.getPauseJobMethod) == null) {
      synchronized (CloudSchedulerGrpc.class) {
        if ((getPauseJobMethod = CloudSchedulerGrpc.getPauseJobMethod) == null) {
          CloudSchedulerGrpc.getPauseJobMethod =
              getPauseJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.scheduler.v1beta1.PauseJobRequest,
                          com.google.cloud.scheduler.v1beta1.Job>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.scheduler.v1beta1.CloudScheduler", "PauseJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.scheduler.v1beta1.PauseJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.scheduler.v1beta1.Job.getDefaultInstance()))
                      .setSchemaDescriptor(new CloudSchedulerMethodDescriptorSupplier("PauseJob"))
                      .build();
        }
      }
    }
    return getPauseJobMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getResumeJobMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1beta1.ResumeJobRequest,
          com.google.cloud.scheduler.v1beta1.Job>
      METHOD_RESUME_JOB = getResumeJobMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1beta1.ResumeJobRequest,
          com.google.cloud.scheduler.v1beta1.Job>
      getResumeJobMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1beta1.ResumeJobRequest,
          com.google.cloud.scheduler.v1beta1.Job>
      getResumeJobMethod() {
    return getResumeJobMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1beta1.ResumeJobRequest,
          com.google.cloud.scheduler.v1beta1.Job>
      getResumeJobMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.scheduler.v1beta1.ResumeJobRequest,
            com.google.cloud.scheduler.v1beta1.Job>
        getResumeJobMethod;
    if ((getResumeJobMethod = CloudSchedulerGrpc.getResumeJobMethod) == null) {
      synchronized (CloudSchedulerGrpc.class) {
        if ((getResumeJobMethod = CloudSchedulerGrpc.getResumeJobMethod) == null) {
          CloudSchedulerGrpc.getResumeJobMethod =
              getResumeJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.scheduler.v1beta1.ResumeJobRequest,
                          com.google.cloud.scheduler.v1beta1.Job>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.scheduler.v1beta1.CloudScheduler", "ResumeJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.scheduler.v1beta1.ResumeJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.scheduler.v1beta1.Job.getDefaultInstance()))
                      .setSchemaDescriptor(new CloudSchedulerMethodDescriptorSupplier("ResumeJob"))
                      .build();
        }
      }
    }
    return getResumeJobMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRunJobMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1beta1.RunJobRequest, com.google.cloud.scheduler.v1beta1.Job>
      METHOD_RUN_JOB = getRunJobMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1beta1.RunJobRequest, com.google.cloud.scheduler.v1beta1.Job>
      getRunJobMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1beta1.RunJobRequest, com.google.cloud.scheduler.v1beta1.Job>
      getRunJobMethod() {
    return getRunJobMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.scheduler.v1beta1.RunJobRequest, com.google.cloud.scheduler.v1beta1.Job>
      getRunJobMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.scheduler.v1beta1.RunJobRequest,
            com.google.cloud.scheduler.v1beta1.Job>
        getRunJobMethod;
    if ((getRunJobMethod = CloudSchedulerGrpc.getRunJobMethod) == null) {
      synchronized (CloudSchedulerGrpc.class) {
        if ((getRunJobMethod = CloudSchedulerGrpc.getRunJobMethod) == null) {
          CloudSchedulerGrpc.getRunJobMethod =
              getRunJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.scheduler.v1beta1.RunJobRequest,
                          com.google.cloud.scheduler.v1beta1.Job>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.scheduler.v1beta1.CloudScheduler", "RunJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.scheduler.v1beta1.RunJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.scheduler.v1beta1.Job.getDefaultInstance()))
                      .setSchemaDescriptor(new CloudSchedulerMethodDescriptorSupplier("RunJob"))
                      .build();
        }
      }
    }
    return getRunJobMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static CloudSchedulerStub newStub(io.grpc.Channel channel) {
    return new CloudSchedulerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CloudSchedulerBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new CloudSchedulerBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static CloudSchedulerFutureStub newFutureStub(io.grpc.Channel channel) {
    return new CloudSchedulerFutureStub(channel);
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
        com.google.cloud.scheduler.v1beta1.ListJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1beta1.ListJobsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListJobsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a job.
     * </pre>
     */
    public void getJob(
        com.google.cloud.scheduler.v1beta1.GetJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1beta1.Job> responseObserver) {
      asyncUnimplementedUnaryCall(getGetJobMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a job.
     * </pre>
     */
    public void createJob(
        com.google.cloud.scheduler.v1beta1.CreateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1beta1.Job> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateJobMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a job.
     * If successful, the updated [Job][google.cloud.scheduler.v1beta1.Job] is returned. If the job does
     * not exist, `NOT_FOUND` is returned.
     * If UpdateJob does not successfully return, it is possible for the
     * job to be in an [Job.State.UPDATE_FAILED][google.cloud.scheduler.v1beta1.Job.State.UPDATE_FAILED] state. A job in this state may
     * not be executed. If this happens, retry the UpdateJob request
     * until a successful response is received.
     * </pre>
     */
    public void updateJob(
        com.google.cloud.scheduler.v1beta1.UpdateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1beta1.Job> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateJobMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a job.
     * </pre>
     */
    public void deleteJob(
        com.google.cloud.scheduler.v1beta1.DeleteJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteJobMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Pauses a job.
     * If a job is paused then the system will stop executing the job
     * until it is re-enabled via [ResumeJob][google.cloud.scheduler.v1beta1.CloudScheduler.ResumeJob]. The
     * state of the job is stored in [state][google.cloud.scheduler.v1beta1.Job.state]; if paused it
     * will be set to [Job.State.PAUSED][google.cloud.scheduler.v1beta1.Job.State.PAUSED]. A job must be in [Job.State.ENABLED][google.cloud.scheduler.v1beta1.Job.State.ENABLED]
     * to be paused.
     * </pre>
     */
    public void pauseJob(
        com.google.cloud.scheduler.v1beta1.PauseJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1beta1.Job> responseObserver) {
      asyncUnimplementedUnaryCall(getPauseJobMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resume a job.
     * This method reenables a job after it has been [Job.State.PAUSED][google.cloud.scheduler.v1beta1.Job.State.PAUSED]. The
     * state of a job is stored in [Job.state][google.cloud.scheduler.v1beta1.Job.state]; after calling this method it
     * will be set to [Job.State.ENABLED][google.cloud.scheduler.v1beta1.Job.State.ENABLED]. A job must be in
     * [Job.State.PAUSED][google.cloud.scheduler.v1beta1.Job.State.PAUSED] to be resumed.
     * </pre>
     */
    public void resumeJob(
        com.google.cloud.scheduler.v1beta1.ResumeJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1beta1.Job> responseObserver) {
      asyncUnimplementedUnaryCall(getResumeJobMethodHelper(), responseObserver);
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
        com.google.cloud.scheduler.v1beta1.RunJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1beta1.Job> responseObserver) {
      asyncUnimplementedUnaryCall(getRunJobMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListJobsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.scheduler.v1beta1.ListJobsRequest,
                      com.google.cloud.scheduler.v1beta1.ListJobsResponse>(
                      this, METHODID_LIST_JOBS)))
          .addMethod(
              getGetJobMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.scheduler.v1beta1.GetJobRequest,
                      com.google.cloud.scheduler.v1beta1.Job>(this, METHODID_GET_JOB)))
          .addMethod(
              getCreateJobMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.scheduler.v1beta1.CreateJobRequest,
                      com.google.cloud.scheduler.v1beta1.Job>(this, METHODID_CREATE_JOB)))
          .addMethod(
              getUpdateJobMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.scheduler.v1beta1.UpdateJobRequest,
                      com.google.cloud.scheduler.v1beta1.Job>(this, METHODID_UPDATE_JOB)))
          .addMethod(
              getDeleteJobMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.scheduler.v1beta1.DeleteJobRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_JOB)))
          .addMethod(
              getPauseJobMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.scheduler.v1beta1.PauseJobRequest,
                      com.google.cloud.scheduler.v1beta1.Job>(this, METHODID_PAUSE_JOB)))
          .addMethod(
              getResumeJobMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.scheduler.v1beta1.ResumeJobRequest,
                      com.google.cloud.scheduler.v1beta1.Job>(this, METHODID_RESUME_JOB)))
          .addMethod(
              getRunJobMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.scheduler.v1beta1.RunJobRequest,
                      com.google.cloud.scheduler.v1beta1.Job>(this, METHODID_RUN_JOB)))
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
      extends io.grpc.stub.AbstractStub<CloudSchedulerStub> {
    private CloudSchedulerStub(io.grpc.Channel channel) {
      super(channel);
    }

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
        com.google.cloud.scheduler.v1beta1.ListJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1beta1.ListJobsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListJobsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a job.
     * </pre>
     */
    public void getJob(
        com.google.cloud.scheduler.v1beta1.GetJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1beta1.Job> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetJobMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a job.
     * </pre>
     */
    public void createJob(
        com.google.cloud.scheduler.v1beta1.CreateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1beta1.Job> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateJobMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a job.
     * If successful, the updated [Job][google.cloud.scheduler.v1beta1.Job] is returned. If the job does
     * not exist, `NOT_FOUND` is returned.
     * If UpdateJob does not successfully return, it is possible for the
     * job to be in an [Job.State.UPDATE_FAILED][google.cloud.scheduler.v1beta1.Job.State.UPDATE_FAILED] state. A job in this state may
     * not be executed. If this happens, retry the UpdateJob request
     * until a successful response is received.
     * </pre>
     */
    public void updateJob(
        com.google.cloud.scheduler.v1beta1.UpdateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1beta1.Job> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateJobMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a job.
     * </pre>
     */
    public void deleteJob(
        com.google.cloud.scheduler.v1beta1.DeleteJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteJobMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Pauses a job.
     * If a job is paused then the system will stop executing the job
     * until it is re-enabled via [ResumeJob][google.cloud.scheduler.v1beta1.CloudScheduler.ResumeJob]. The
     * state of the job is stored in [state][google.cloud.scheduler.v1beta1.Job.state]; if paused it
     * will be set to [Job.State.PAUSED][google.cloud.scheduler.v1beta1.Job.State.PAUSED]. A job must be in [Job.State.ENABLED][google.cloud.scheduler.v1beta1.Job.State.ENABLED]
     * to be paused.
     * </pre>
     */
    public void pauseJob(
        com.google.cloud.scheduler.v1beta1.PauseJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1beta1.Job> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPauseJobMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resume a job.
     * This method reenables a job after it has been [Job.State.PAUSED][google.cloud.scheduler.v1beta1.Job.State.PAUSED]. The
     * state of a job is stored in [Job.state][google.cloud.scheduler.v1beta1.Job.state]; after calling this method it
     * will be set to [Job.State.ENABLED][google.cloud.scheduler.v1beta1.Job.State.ENABLED]. A job must be in
     * [Job.State.PAUSED][google.cloud.scheduler.v1beta1.Job.State.PAUSED] to be resumed.
     * </pre>
     */
    public void resumeJob(
        com.google.cloud.scheduler.v1beta1.ResumeJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1beta1.Job> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getResumeJobMethodHelper(), getCallOptions()),
          request,
          responseObserver);
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
        com.google.cloud.scheduler.v1beta1.RunJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1beta1.Job> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRunJobMethodHelper(), getCallOptions()),
          request,
          responseObserver);
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
      extends io.grpc.stub.AbstractStub<CloudSchedulerBlockingStub> {
    private CloudSchedulerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

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
    public com.google.cloud.scheduler.v1beta1.ListJobsResponse listJobs(
        com.google.cloud.scheduler.v1beta1.ListJobsRequest request) {
      return blockingUnaryCall(getChannel(), getListJobsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a job.
     * </pre>
     */
    public com.google.cloud.scheduler.v1beta1.Job getJob(
        com.google.cloud.scheduler.v1beta1.GetJobRequest request) {
      return blockingUnaryCall(getChannel(), getGetJobMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a job.
     * </pre>
     */
    public com.google.cloud.scheduler.v1beta1.Job createJob(
        com.google.cloud.scheduler.v1beta1.CreateJobRequest request) {
      return blockingUnaryCall(getChannel(), getCreateJobMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a job.
     * If successful, the updated [Job][google.cloud.scheduler.v1beta1.Job] is returned. If the job does
     * not exist, `NOT_FOUND` is returned.
     * If UpdateJob does not successfully return, it is possible for the
     * job to be in an [Job.State.UPDATE_FAILED][google.cloud.scheduler.v1beta1.Job.State.UPDATE_FAILED] state. A job in this state may
     * not be executed. If this happens, retry the UpdateJob request
     * until a successful response is received.
     * </pre>
     */
    public com.google.cloud.scheduler.v1beta1.Job updateJob(
        com.google.cloud.scheduler.v1beta1.UpdateJobRequest request) {
      return blockingUnaryCall(getChannel(), getUpdateJobMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a job.
     * </pre>
     */
    public com.google.protobuf.Empty deleteJob(
        com.google.cloud.scheduler.v1beta1.DeleteJobRequest request) {
      return blockingUnaryCall(getChannel(), getDeleteJobMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Pauses a job.
     * If a job is paused then the system will stop executing the job
     * until it is re-enabled via [ResumeJob][google.cloud.scheduler.v1beta1.CloudScheduler.ResumeJob]. The
     * state of the job is stored in [state][google.cloud.scheduler.v1beta1.Job.state]; if paused it
     * will be set to [Job.State.PAUSED][google.cloud.scheduler.v1beta1.Job.State.PAUSED]. A job must be in [Job.State.ENABLED][google.cloud.scheduler.v1beta1.Job.State.ENABLED]
     * to be paused.
     * </pre>
     */
    public com.google.cloud.scheduler.v1beta1.Job pauseJob(
        com.google.cloud.scheduler.v1beta1.PauseJobRequest request) {
      return blockingUnaryCall(getChannel(), getPauseJobMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Resume a job.
     * This method reenables a job after it has been [Job.State.PAUSED][google.cloud.scheduler.v1beta1.Job.State.PAUSED]. The
     * state of a job is stored in [Job.state][google.cloud.scheduler.v1beta1.Job.state]; after calling this method it
     * will be set to [Job.State.ENABLED][google.cloud.scheduler.v1beta1.Job.State.ENABLED]. A job must be in
     * [Job.State.PAUSED][google.cloud.scheduler.v1beta1.Job.State.PAUSED] to be resumed.
     * </pre>
     */
    public com.google.cloud.scheduler.v1beta1.Job resumeJob(
        com.google.cloud.scheduler.v1beta1.ResumeJobRequest request) {
      return blockingUnaryCall(getChannel(), getResumeJobMethodHelper(), getCallOptions(), request);
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
    public com.google.cloud.scheduler.v1beta1.Job runJob(
        com.google.cloud.scheduler.v1beta1.RunJobRequest request) {
      return blockingUnaryCall(getChannel(), getRunJobMethodHelper(), getCallOptions(), request);
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
      extends io.grpc.stub.AbstractStub<CloudSchedulerFutureStub> {
    private CloudSchedulerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

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
            com.google.cloud.scheduler.v1beta1.ListJobsResponse>
        listJobs(com.google.cloud.scheduler.v1beta1.ListJobsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListJobsMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.scheduler.v1beta1.Job>
        getJob(com.google.cloud.scheduler.v1beta1.GetJobRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetJobMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.scheduler.v1beta1.Job>
        createJob(com.google.cloud.scheduler.v1beta1.CreateJobRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateJobMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a job.
     * If successful, the updated [Job][google.cloud.scheduler.v1beta1.Job] is returned. If the job does
     * not exist, `NOT_FOUND` is returned.
     * If UpdateJob does not successfully return, it is possible for the
     * job to be in an [Job.State.UPDATE_FAILED][google.cloud.scheduler.v1beta1.Job.State.UPDATE_FAILED] state. A job in this state may
     * not be executed. If this happens, retry the UpdateJob request
     * until a successful response is received.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.scheduler.v1beta1.Job>
        updateJob(com.google.cloud.scheduler.v1beta1.UpdateJobRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateJobMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteJob(
        com.google.cloud.scheduler.v1beta1.DeleteJobRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteJobMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Pauses a job.
     * If a job is paused then the system will stop executing the job
     * until it is re-enabled via [ResumeJob][google.cloud.scheduler.v1beta1.CloudScheduler.ResumeJob]. The
     * state of the job is stored in [state][google.cloud.scheduler.v1beta1.Job.state]; if paused it
     * will be set to [Job.State.PAUSED][google.cloud.scheduler.v1beta1.Job.State.PAUSED]. A job must be in [Job.State.ENABLED][google.cloud.scheduler.v1beta1.Job.State.ENABLED]
     * to be paused.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.scheduler.v1beta1.Job>
        pauseJob(com.google.cloud.scheduler.v1beta1.PauseJobRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPauseJobMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Resume a job.
     * This method reenables a job after it has been [Job.State.PAUSED][google.cloud.scheduler.v1beta1.Job.State.PAUSED]. The
     * state of a job is stored in [Job.state][google.cloud.scheduler.v1beta1.Job.state]; after calling this method it
     * will be set to [Job.State.ENABLED][google.cloud.scheduler.v1beta1.Job.State.ENABLED]. A job must be in
     * [Job.State.PAUSED][google.cloud.scheduler.v1beta1.Job.State.PAUSED] to be resumed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.scheduler.v1beta1.Job>
        resumeJob(com.google.cloud.scheduler.v1beta1.ResumeJobRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getResumeJobMethodHelper(), getCallOptions()), request);
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
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.scheduler.v1beta1.Job>
        runJob(com.google.cloud.scheduler.v1beta1.RunJobRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRunJobMethodHelper(), getCallOptions()), request);
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
              (com.google.cloud.scheduler.v1beta1.ListJobsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1beta1.ListJobsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_JOB:
          serviceImpl.getJob(
              (com.google.cloud.scheduler.v1beta1.GetJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1beta1.Job>)
                  responseObserver);
          break;
        case METHODID_CREATE_JOB:
          serviceImpl.createJob(
              (com.google.cloud.scheduler.v1beta1.CreateJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1beta1.Job>)
                  responseObserver);
          break;
        case METHODID_UPDATE_JOB:
          serviceImpl.updateJob(
              (com.google.cloud.scheduler.v1beta1.UpdateJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1beta1.Job>)
                  responseObserver);
          break;
        case METHODID_DELETE_JOB:
          serviceImpl.deleteJob(
              (com.google.cloud.scheduler.v1beta1.DeleteJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_PAUSE_JOB:
          serviceImpl.pauseJob(
              (com.google.cloud.scheduler.v1beta1.PauseJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1beta1.Job>)
                  responseObserver);
          break;
        case METHODID_RESUME_JOB:
          serviceImpl.resumeJob(
              (com.google.cloud.scheduler.v1beta1.ResumeJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1beta1.Job>)
                  responseObserver);
          break;
        case METHODID_RUN_JOB:
          serviceImpl.runJob(
              (com.google.cloud.scheduler.v1beta1.RunJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.scheduler.v1beta1.Job>)
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

  private abstract static class CloudSchedulerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CloudSchedulerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.scheduler.v1beta1.SchedulerProto.getDescriptor();
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
                      .addMethod(getListJobsMethodHelper())
                      .addMethod(getGetJobMethodHelper())
                      .addMethod(getCreateJobMethodHelper())
                      .addMethod(getUpdateJobMethodHelper())
                      .addMethod(getDeleteJobMethodHelper())
                      .addMethod(getPauseJobMethodHelper())
                      .addMethod(getResumeJobMethodHelper())
                      .addMethod(getRunJobMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
