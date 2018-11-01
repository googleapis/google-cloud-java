package com.google.cloud.dataproc.v1beta2;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * The JobController provides methods to manage jobs.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/dataproc/v1beta2/jobs.proto")
public final class JobControllerGrpc {

  private JobControllerGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dataproc.v1beta2.JobController";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSubmitJobMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1beta2.SubmitJobRequest,
      com.google.cloud.dataproc.v1beta2.Job> METHOD_SUBMIT_JOB = getSubmitJobMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1beta2.SubmitJobRequest,
      com.google.cloud.dataproc.v1beta2.Job> getSubmitJobMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1beta2.SubmitJobRequest,
      com.google.cloud.dataproc.v1beta2.Job> getSubmitJobMethod() {
    return getSubmitJobMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1beta2.SubmitJobRequest,
      com.google.cloud.dataproc.v1beta2.Job> getSubmitJobMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1beta2.SubmitJobRequest, com.google.cloud.dataproc.v1beta2.Job> getSubmitJobMethod;
    if ((getSubmitJobMethod = JobControllerGrpc.getSubmitJobMethod) == null) {
      synchronized (JobControllerGrpc.class) {
        if ((getSubmitJobMethod = JobControllerGrpc.getSubmitJobMethod) == null) {
          JobControllerGrpc.getSubmitJobMethod = getSubmitJobMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.dataproc.v1beta2.SubmitJobRequest, com.google.cloud.dataproc.v1beta2.Job>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.dataproc.v1beta2.JobController", "SubmitJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1beta2.SubmitJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1beta2.Job.getDefaultInstance()))
                  .setSchemaDescriptor(new JobControllerMethodDescriptorSupplier("SubmitJob"))
                  .build();
          }
        }
     }
     return getSubmitJobMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetJobMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1beta2.GetJobRequest,
      com.google.cloud.dataproc.v1beta2.Job> METHOD_GET_JOB = getGetJobMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1beta2.GetJobRequest,
      com.google.cloud.dataproc.v1beta2.Job> getGetJobMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1beta2.GetJobRequest,
      com.google.cloud.dataproc.v1beta2.Job> getGetJobMethod() {
    return getGetJobMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1beta2.GetJobRequest,
      com.google.cloud.dataproc.v1beta2.Job> getGetJobMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1beta2.GetJobRequest, com.google.cloud.dataproc.v1beta2.Job> getGetJobMethod;
    if ((getGetJobMethod = JobControllerGrpc.getGetJobMethod) == null) {
      synchronized (JobControllerGrpc.class) {
        if ((getGetJobMethod = JobControllerGrpc.getGetJobMethod) == null) {
          JobControllerGrpc.getGetJobMethod = getGetJobMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.dataproc.v1beta2.GetJobRequest, com.google.cloud.dataproc.v1beta2.Job>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.dataproc.v1beta2.JobController", "GetJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1beta2.GetJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1beta2.Job.getDefaultInstance()))
                  .setSchemaDescriptor(new JobControllerMethodDescriptorSupplier("GetJob"))
                  .build();
          }
        }
     }
     return getGetJobMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListJobsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1beta2.ListJobsRequest,
      com.google.cloud.dataproc.v1beta2.ListJobsResponse> METHOD_LIST_JOBS = getListJobsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1beta2.ListJobsRequest,
      com.google.cloud.dataproc.v1beta2.ListJobsResponse> getListJobsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1beta2.ListJobsRequest,
      com.google.cloud.dataproc.v1beta2.ListJobsResponse> getListJobsMethod() {
    return getListJobsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1beta2.ListJobsRequest,
      com.google.cloud.dataproc.v1beta2.ListJobsResponse> getListJobsMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1beta2.ListJobsRequest, com.google.cloud.dataproc.v1beta2.ListJobsResponse> getListJobsMethod;
    if ((getListJobsMethod = JobControllerGrpc.getListJobsMethod) == null) {
      synchronized (JobControllerGrpc.class) {
        if ((getListJobsMethod = JobControllerGrpc.getListJobsMethod) == null) {
          JobControllerGrpc.getListJobsMethod = getListJobsMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.dataproc.v1beta2.ListJobsRequest, com.google.cloud.dataproc.v1beta2.ListJobsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.dataproc.v1beta2.JobController", "ListJobs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1beta2.ListJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1beta2.ListJobsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new JobControllerMethodDescriptorSupplier("ListJobs"))
                  .build();
          }
        }
     }
     return getListJobsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateJobMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1beta2.UpdateJobRequest,
      com.google.cloud.dataproc.v1beta2.Job> METHOD_UPDATE_JOB = getUpdateJobMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1beta2.UpdateJobRequest,
      com.google.cloud.dataproc.v1beta2.Job> getUpdateJobMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1beta2.UpdateJobRequest,
      com.google.cloud.dataproc.v1beta2.Job> getUpdateJobMethod() {
    return getUpdateJobMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1beta2.UpdateJobRequest,
      com.google.cloud.dataproc.v1beta2.Job> getUpdateJobMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1beta2.UpdateJobRequest, com.google.cloud.dataproc.v1beta2.Job> getUpdateJobMethod;
    if ((getUpdateJobMethod = JobControllerGrpc.getUpdateJobMethod) == null) {
      synchronized (JobControllerGrpc.class) {
        if ((getUpdateJobMethod = JobControllerGrpc.getUpdateJobMethod) == null) {
          JobControllerGrpc.getUpdateJobMethod = getUpdateJobMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.dataproc.v1beta2.UpdateJobRequest, com.google.cloud.dataproc.v1beta2.Job>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.dataproc.v1beta2.JobController", "UpdateJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1beta2.UpdateJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1beta2.Job.getDefaultInstance()))
                  .setSchemaDescriptor(new JobControllerMethodDescriptorSupplier("UpdateJob"))
                  .build();
          }
        }
     }
     return getUpdateJobMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCancelJobMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1beta2.CancelJobRequest,
      com.google.cloud.dataproc.v1beta2.Job> METHOD_CANCEL_JOB = getCancelJobMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1beta2.CancelJobRequest,
      com.google.cloud.dataproc.v1beta2.Job> getCancelJobMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1beta2.CancelJobRequest,
      com.google.cloud.dataproc.v1beta2.Job> getCancelJobMethod() {
    return getCancelJobMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1beta2.CancelJobRequest,
      com.google.cloud.dataproc.v1beta2.Job> getCancelJobMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1beta2.CancelJobRequest, com.google.cloud.dataproc.v1beta2.Job> getCancelJobMethod;
    if ((getCancelJobMethod = JobControllerGrpc.getCancelJobMethod) == null) {
      synchronized (JobControllerGrpc.class) {
        if ((getCancelJobMethod = JobControllerGrpc.getCancelJobMethod) == null) {
          JobControllerGrpc.getCancelJobMethod = getCancelJobMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.dataproc.v1beta2.CancelJobRequest, com.google.cloud.dataproc.v1beta2.Job>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.dataproc.v1beta2.JobController", "CancelJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1beta2.CancelJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1beta2.Job.getDefaultInstance()))
                  .setSchemaDescriptor(new JobControllerMethodDescriptorSupplier("CancelJob"))
                  .build();
          }
        }
     }
     return getCancelJobMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteJobMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1beta2.DeleteJobRequest,
      com.google.protobuf.Empty> METHOD_DELETE_JOB = getDeleteJobMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1beta2.DeleteJobRequest,
      com.google.protobuf.Empty> getDeleteJobMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1beta2.DeleteJobRequest,
      com.google.protobuf.Empty> getDeleteJobMethod() {
    return getDeleteJobMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1beta2.DeleteJobRequest,
      com.google.protobuf.Empty> getDeleteJobMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1beta2.DeleteJobRequest, com.google.protobuf.Empty> getDeleteJobMethod;
    if ((getDeleteJobMethod = JobControllerGrpc.getDeleteJobMethod) == null) {
      synchronized (JobControllerGrpc.class) {
        if ((getDeleteJobMethod = JobControllerGrpc.getDeleteJobMethod) == null) {
          JobControllerGrpc.getDeleteJobMethod = getDeleteJobMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.dataproc.v1beta2.DeleteJobRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.dataproc.v1beta2.JobController", "DeleteJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1beta2.DeleteJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new JobControllerMethodDescriptorSupplier("DeleteJob"))
                  .build();
          }
        }
     }
     return getDeleteJobMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static JobControllerStub newStub(io.grpc.Channel channel) {
    return new JobControllerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static JobControllerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new JobControllerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static JobControllerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new JobControllerFutureStub(channel);
  }

  /**
   * <pre>
   * The JobController provides methods to manage jobs.
   * </pre>
   */
  public static abstract class JobControllerImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Submits a job to a cluster.
     * </pre>
     */
    public void submitJob(com.google.cloud.dataproc.v1beta2.SubmitJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.Job> responseObserver) {
      asyncUnimplementedUnaryCall(getSubmitJobMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Gets the resource representation for a job in a project.
     * </pre>
     */
    public void getJob(com.google.cloud.dataproc.v1beta2.GetJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.Job> responseObserver) {
      asyncUnimplementedUnaryCall(getGetJobMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Lists regions/{region}/jobs in a project.
     * </pre>
     */
    public void listJobs(com.google.cloud.dataproc.v1beta2.ListJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.ListJobsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListJobsMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Updates a job in a project.
     * </pre>
     */
    public void updateJob(com.google.cloud.dataproc.v1beta2.UpdateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.Job> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateJobMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Starts a job cancellation request. To access the job resource
     * after cancellation, call
     * [regions/{region}/jobs.list](/dataproc/docs/reference/rest/v1beta2/projects.regions.jobs/list) or
     * [regions/{region}/jobs.get](/dataproc/docs/reference/rest/v1beta2/projects.regions.jobs/get).
     * </pre>
     */
    public void cancelJob(com.google.cloud.dataproc.v1beta2.CancelJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.Job> responseObserver) {
      asyncUnimplementedUnaryCall(getCancelJobMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the job from the project. If the job is active, the delete fails,
     * and the response returns `FAILED_PRECONDITION`.
     * </pre>
     */
    public void deleteJob(com.google.cloud.dataproc.v1beta2.DeleteJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteJobMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSubmitJobMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataproc.v1beta2.SubmitJobRequest,
                com.google.cloud.dataproc.v1beta2.Job>(
                  this, METHODID_SUBMIT_JOB)))
          .addMethod(
            getGetJobMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataproc.v1beta2.GetJobRequest,
                com.google.cloud.dataproc.v1beta2.Job>(
                  this, METHODID_GET_JOB)))
          .addMethod(
            getListJobsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataproc.v1beta2.ListJobsRequest,
                com.google.cloud.dataproc.v1beta2.ListJobsResponse>(
                  this, METHODID_LIST_JOBS)))
          .addMethod(
            getUpdateJobMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataproc.v1beta2.UpdateJobRequest,
                com.google.cloud.dataproc.v1beta2.Job>(
                  this, METHODID_UPDATE_JOB)))
          .addMethod(
            getCancelJobMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataproc.v1beta2.CancelJobRequest,
                com.google.cloud.dataproc.v1beta2.Job>(
                  this, METHODID_CANCEL_JOB)))
          .addMethod(
            getDeleteJobMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataproc.v1beta2.DeleteJobRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_JOB)))
          .build();
    }
  }

  /**
   * <pre>
   * The JobController provides methods to manage jobs.
   * </pre>
   */
  public static final class JobControllerStub extends io.grpc.stub.AbstractStub<JobControllerStub> {
    private JobControllerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private JobControllerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JobControllerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new JobControllerStub(channel, callOptions);
    }

    /**
     * <pre>
     * Submits a job to a cluster.
     * </pre>
     */
    public void submitJob(com.google.cloud.dataproc.v1beta2.SubmitJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.Job> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSubmitJobMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the resource representation for a job in a project.
     * </pre>
     */
    public void getJob(com.google.cloud.dataproc.v1beta2.GetJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.Job> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetJobMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists regions/{region}/jobs in a project.
     * </pre>
     */
    public void listJobs(com.google.cloud.dataproc.v1beta2.ListJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.ListJobsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListJobsMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a job in a project.
     * </pre>
     */
    public void updateJob(com.google.cloud.dataproc.v1beta2.UpdateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.Job> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateJobMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Starts a job cancellation request. To access the job resource
     * after cancellation, call
     * [regions/{region}/jobs.list](/dataproc/docs/reference/rest/v1beta2/projects.regions.jobs/list) or
     * [regions/{region}/jobs.get](/dataproc/docs/reference/rest/v1beta2/projects.regions.jobs/get).
     * </pre>
     */
    public void cancelJob(com.google.cloud.dataproc.v1beta2.CancelJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.Job> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCancelJobMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the job from the project. If the job is active, the delete fails,
     * and the response returns `FAILED_PRECONDITION`.
     * </pre>
     */
    public void deleteJob(com.google.cloud.dataproc.v1beta2.DeleteJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteJobMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The JobController provides methods to manage jobs.
   * </pre>
   */
  public static final class JobControllerBlockingStub extends io.grpc.stub.AbstractStub<JobControllerBlockingStub> {
    private JobControllerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private JobControllerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JobControllerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new JobControllerBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Submits a job to a cluster.
     * </pre>
     */
    public com.google.cloud.dataproc.v1beta2.Job submitJob(com.google.cloud.dataproc.v1beta2.SubmitJobRequest request) {
      return blockingUnaryCall(
          getChannel(), getSubmitJobMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the resource representation for a job in a project.
     * </pre>
     */
    public com.google.cloud.dataproc.v1beta2.Job getJob(com.google.cloud.dataproc.v1beta2.GetJobRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetJobMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists regions/{region}/jobs in a project.
     * </pre>
     */
    public com.google.cloud.dataproc.v1beta2.ListJobsResponse listJobs(com.google.cloud.dataproc.v1beta2.ListJobsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListJobsMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a job in a project.
     * </pre>
     */
    public com.google.cloud.dataproc.v1beta2.Job updateJob(com.google.cloud.dataproc.v1beta2.UpdateJobRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateJobMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Starts a job cancellation request. To access the job resource
     * after cancellation, call
     * [regions/{region}/jobs.list](/dataproc/docs/reference/rest/v1beta2/projects.regions.jobs/list) or
     * [regions/{region}/jobs.get](/dataproc/docs/reference/rest/v1beta2/projects.regions.jobs/get).
     * </pre>
     */
    public com.google.cloud.dataproc.v1beta2.Job cancelJob(com.google.cloud.dataproc.v1beta2.CancelJobRequest request) {
      return blockingUnaryCall(
          getChannel(), getCancelJobMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the job from the project. If the job is active, the delete fails,
     * and the response returns `FAILED_PRECONDITION`.
     * </pre>
     */
    public com.google.protobuf.Empty deleteJob(com.google.cloud.dataproc.v1beta2.DeleteJobRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteJobMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The JobController provides methods to manage jobs.
   * </pre>
   */
  public static final class JobControllerFutureStub extends io.grpc.stub.AbstractStub<JobControllerFutureStub> {
    private JobControllerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private JobControllerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JobControllerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new JobControllerFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Submits a job to a cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataproc.v1beta2.Job> submitJob(
        com.google.cloud.dataproc.v1beta2.SubmitJobRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSubmitJobMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the resource representation for a job in a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataproc.v1beta2.Job> getJob(
        com.google.cloud.dataproc.v1beta2.GetJobRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetJobMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists regions/{region}/jobs in a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataproc.v1beta2.ListJobsResponse> listJobs(
        com.google.cloud.dataproc.v1beta2.ListJobsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListJobsMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a job in a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataproc.v1beta2.Job> updateJob(
        com.google.cloud.dataproc.v1beta2.UpdateJobRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateJobMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Starts a job cancellation request. To access the job resource
     * after cancellation, call
     * [regions/{region}/jobs.list](/dataproc/docs/reference/rest/v1beta2/projects.regions.jobs/list) or
     * [regions/{region}/jobs.get](/dataproc/docs/reference/rest/v1beta2/projects.regions.jobs/get).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataproc.v1beta2.Job> cancelJob(
        com.google.cloud.dataproc.v1beta2.CancelJobRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCancelJobMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the job from the project. If the job is active, the delete fails,
     * and the response returns `FAILED_PRECONDITION`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteJob(
        com.google.cloud.dataproc.v1beta2.DeleteJobRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteJobMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SUBMIT_JOB = 0;
  private static final int METHODID_GET_JOB = 1;
  private static final int METHODID_LIST_JOBS = 2;
  private static final int METHODID_UPDATE_JOB = 3;
  private static final int METHODID_CANCEL_JOB = 4;
  private static final int METHODID_DELETE_JOB = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final JobControllerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(JobControllerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SUBMIT_JOB:
          serviceImpl.submitJob((com.google.cloud.dataproc.v1beta2.SubmitJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.Job>) responseObserver);
          break;
        case METHODID_GET_JOB:
          serviceImpl.getJob((com.google.cloud.dataproc.v1beta2.GetJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.Job>) responseObserver);
          break;
        case METHODID_LIST_JOBS:
          serviceImpl.listJobs((com.google.cloud.dataproc.v1beta2.ListJobsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.ListJobsResponse>) responseObserver);
          break;
        case METHODID_UPDATE_JOB:
          serviceImpl.updateJob((com.google.cloud.dataproc.v1beta2.UpdateJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.Job>) responseObserver);
          break;
        case METHODID_CANCEL_JOB:
          serviceImpl.cancelJob((com.google.cloud.dataproc.v1beta2.CancelJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.Job>) responseObserver);
          break;
        case METHODID_DELETE_JOB:
          serviceImpl.deleteJob((com.google.cloud.dataproc.v1beta2.DeleteJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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

  private static abstract class JobControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    JobControllerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dataproc.v1beta2.JobsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("JobController");
    }
  }

  private static final class JobControllerFileDescriptorSupplier
      extends JobControllerBaseDescriptorSupplier {
    JobControllerFileDescriptorSupplier() {}
  }

  private static final class JobControllerMethodDescriptorSupplier
      extends JobControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    JobControllerMethodDescriptorSupplier(String methodName) {
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
      synchronized (JobControllerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new JobControllerFileDescriptorSupplier())
              .addMethod(getSubmitJobMethodHelper())
              .addMethod(getGetJobMethodHelper())
              .addMethod(getListJobsMethodHelper())
              .addMethod(getUpdateJobMethodHelper())
              .addMethod(getCancelJobMethodHelper())
              .addMethod(getDeleteJobMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
