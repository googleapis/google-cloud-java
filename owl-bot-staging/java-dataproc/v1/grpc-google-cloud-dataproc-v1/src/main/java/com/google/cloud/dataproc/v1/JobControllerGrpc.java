package com.google.cloud.dataproc.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The JobController provides methods to manage jobs.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dataproc/v1/jobs.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class JobControllerGrpc {

  private JobControllerGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dataproc.v1.JobController";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.SubmitJobRequest,
      com.google.cloud.dataproc.v1.Job> getSubmitJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SubmitJob",
      requestType = com.google.cloud.dataproc.v1.SubmitJobRequest.class,
      responseType = com.google.cloud.dataproc.v1.Job.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.SubmitJobRequest,
      com.google.cloud.dataproc.v1.Job> getSubmitJobMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.SubmitJobRequest, com.google.cloud.dataproc.v1.Job> getSubmitJobMethod;
    if ((getSubmitJobMethod = JobControllerGrpc.getSubmitJobMethod) == null) {
      synchronized (JobControllerGrpc.class) {
        if ((getSubmitJobMethod = JobControllerGrpc.getSubmitJobMethod) == null) {
          JobControllerGrpc.getSubmitJobMethod = getSubmitJobMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataproc.v1.SubmitJobRequest, com.google.cloud.dataproc.v1.Job>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SubmitJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.SubmitJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.Job.getDefaultInstance()))
              .setSchemaDescriptor(new JobControllerMethodDescriptorSupplier("SubmitJob"))
              .build();
        }
      }
    }
    return getSubmitJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.SubmitJobRequest,
      com.google.longrunning.Operation> getSubmitJobAsOperationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SubmitJobAsOperation",
      requestType = com.google.cloud.dataproc.v1.SubmitJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.SubmitJobRequest,
      com.google.longrunning.Operation> getSubmitJobAsOperationMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.SubmitJobRequest, com.google.longrunning.Operation> getSubmitJobAsOperationMethod;
    if ((getSubmitJobAsOperationMethod = JobControllerGrpc.getSubmitJobAsOperationMethod) == null) {
      synchronized (JobControllerGrpc.class) {
        if ((getSubmitJobAsOperationMethod = JobControllerGrpc.getSubmitJobAsOperationMethod) == null) {
          JobControllerGrpc.getSubmitJobAsOperationMethod = getSubmitJobAsOperationMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataproc.v1.SubmitJobRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SubmitJobAsOperation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.SubmitJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new JobControllerMethodDescriptorSupplier("SubmitJobAsOperation"))
              .build();
        }
      }
    }
    return getSubmitJobAsOperationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.GetJobRequest,
      com.google.cloud.dataproc.v1.Job> getGetJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetJob",
      requestType = com.google.cloud.dataproc.v1.GetJobRequest.class,
      responseType = com.google.cloud.dataproc.v1.Job.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.GetJobRequest,
      com.google.cloud.dataproc.v1.Job> getGetJobMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.GetJobRequest, com.google.cloud.dataproc.v1.Job> getGetJobMethod;
    if ((getGetJobMethod = JobControllerGrpc.getGetJobMethod) == null) {
      synchronized (JobControllerGrpc.class) {
        if ((getGetJobMethod = JobControllerGrpc.getGetJobMethod) == null) {
          JobControllerGrpc.getGetJobMethod = getGetJobMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataproc.v1.GetJobRequest, com.google.cloud.dataproc.v1.Job>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.GetJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.Job.getDefaultInstance()))
              .setSchemaDescriptor(new JobControllerMethodDescriptorSupplier("GetJob"))
              .build();
        }
      }
    }
    return getGetJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.ListJobsRequest,
      com.google.cloud.dataproc.v1.ListJobsResponse> getListJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListJobs",
      requestType = com.google.cloud.dataproc.v1.ListJobsRequest.class,
      responseType = com.google.cloud.dataproc.v1.ListJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.ListJobsRequest,
      com.google.cloud.dataproc.v1.ListJobsResponse> getListJobsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.ListJobsRequest, com.google.cloud.dataproc.v1.ListJobsResponse> getListJobsMethod;
    if ((getListJobsMethod = JobControllerGrpc.getListJobsMethod) == null) {
      synchronized (JobControllerGrpc.class) {
        if ((getListJobsMethod = JobControllerGrpc.getListJobsMethod) == null) {
          JobControllerGrpc.getListJobsMethod = getListJobsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataproc.v1.ListJobsRequest, com.google.cloud.dataproc.v1.ListJobsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListJobs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.ListJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.ListJobsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new JobControllerMethodDescriptorSupplier("ListJobs"))
              .build();
        }
      }
    }
    return getListJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.UpdateJobRequest,
      com.google.cloud.dataproc.v1.Job> getUpdateJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateJob",
      requestType = com.google.cloud.dataproc.v1.UpdateJobRequest.class,
      responseType = com.google.cloud.dataproc.v1.Job.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.UpdateJobRequest,
      com.google.cloud.dataproc.v1.Job> getUpdateJobMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.UpdateJobRequest, com.google.cloud.dataproc.v1.Job> getUpdateJobMethod;
    if ((getUpdateJobMethod = JobControllerGrpc.getUpdateJobMethod) == null) {
      synchronized (JobControllerGrpc.class) {
        if ((getUpdateJobMethod = JobControllerGrpc.getUpdateJobMethod) == null) {
          JobControllerGrpc.getUpdateJobMethod = getUpdateJobMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataproc.v1.UpdateJobRequest, com.google.cloud.dataproc.v1.Job>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.UpdateJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.Job.getDefaultInstance()))
              .setSchemaDescriptor(new JobControllerMethodDescriptorSupplier("UpdateJob"))
              .build();
        }
      }
    }
    return getUpdateJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.CancelJobRequest,
      com.google.cloud.dataproc.v1.Job> getCancelJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelJob",
      requestType = com.google.cloud.dataproc.v1.CancelJobRequest.class,
      responseType = com.google.cloud.dataproc.v1.Job.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.CancelJobRequest,
      com.google.cloud.dataproc.v1.Job> getCancelJobMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.CancelJobRequest, com.google.cloud.dataproc.v1.Job> getCancelJobMethod;
    if ((getCancelJobMethod = JobControllerGrpc.getCancelJobMethod) == null) {
      synchronized (JobControllerGrpc.class) {
        if ((getCancelJobMethod = JobControllerGrpc.getCancelJobMethod) == null) {
          JobControllerGrpc.getCancelJobMethod = getCancelJobMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataproc.v1.CancelJobRequest, com.google.cloud.dataproc.v1.Job>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CancelJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.CancelJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.Job.getDefaultInstance()))
              .setSchemaDescriptor(new JobControllerMethodDescriptorSupplier("CancelJob"))
              .build();
        }
      }
    }
    return getCancelJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.DeleteJobRequest,
      com.google.protobuf.Empty> getDeleteJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteJob",
      requestType = com.google.cloud.dataproc.v1.DeleteJobRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.DeleteJobRequest,
      com.google.protobuf.Empty> getDeleteJobMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.DeleteJobRequest, com.google.protobuf.Empty> getDeleteJobMethod;
    if ((getDeleteJobMethod = JobControllerGrpc.getDeleteJobMethod) == null) {
      synchronized (JobControllerGrpc.class) {
        if ((getDeleteJobMethod = JobControllerGrpc.getDeleteJobMethod) == null) {
          JobControllerGrpc.getDeleteJobMethod = getDeleteJobMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataproc.v1.DeleteJobRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.DeleteJobRequest.getDefaultInstance()))
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
    io.grpc.stub.AbstractStub.StubFactory<JobControllerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JobControllerStub>() {
        @java.lang.Override
        public JobControllerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JobControllerStub(channel, callOptions);
        }
      };
    return JobControllerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static JobControllerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JobControllerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JobControllerBlockingStub>() {
        @java.lang.Override
        public JobControllerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JobControllerBlockingStub(channel, callOptions);
        }
      };
    return JobControllerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static JobControllerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JobControllerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JobControllerFutureStub>() {
        @java.lang.Override
        public JobControllerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JobControllerFutureStub(channel, callOptions);
        }
      };
    return JobControllerFutureStub.newStub(factory, channel);
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
    public void submitJob(com.google.cloud.dataproc.v1.SubmitJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.Job> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSubmitJobMethod(), responseObserver);
    }

    /**
     * <pre>
     * Submits job to a cluster.
     * </pre>
     */
    public void submitJobAsOperation(com.google.cloud.dataproc.v1.SubmitJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSubmitJobAsOperationMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the resource representation for a job in a project.
     * </pre>
     */
    public void getJob(com.google.cloud.dataproc.v1.GetJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.Job> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetJobMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists regions/{region}/jobs in a project.
     * </pre>
     */
    public void listJobs(com.google.cloud.dataproc.v1.ListJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.ListJobsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListJobsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a job in a project.
     * </pre>
     */
    public void updateJob(com.google.cloud.dataproc.v1.UpdateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.Job> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateJobMethod(), responseObserver);
    }

    /**
     * <pre>
     * Starts a job cancellation request. To access the job resource
     * after cancellation, call
     * [regions/{region}/jobs.list](https://cloud.google.com/dataproc/docs/reference/rest/v1/projects.regions.jobs/list)
     * or
     * [regions/{region}/jobs.get](https://cloud.google.com/dataproc/docs/reference/rest/v1/projects.regions.jobs/get).
     * </pre>
     */
    public void cancelJob(com.google.cloud.dataproc.v1.CancelJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.Job> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCancelJobMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the job from the project. If the job is active, the delete fails,
     * and the response returns `FAILED_PRECONDITION`.
     * </pre>
     */
    public void deleteJob(com.google.cloud.dataproc.v1.DeleteJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteJobMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSubmitJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataproc.v1.SubmitJobRequest,
                com.google.cloud.dataproc.v1.Job>(
                  this, METHODID_SUBMIT_JOB)))
          .addMethod(
            getSubmitJobAsOperationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataproc.v1.SubmitJobRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_SUBMIT_JOB_AS_OPERATION)))
          .addMethod(
            getGetJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataproc.v1.GetJobRequest,
                com.google.cloud.dataproc.v1.Job>(
                  this, METHODID_GET_JOB)))
          .addMethod(
            getListJobsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataproc.v1.ListJobsRequest,
                com.google.cloud.dataproc.v1.ListJobsResponse>(
                  this, METHODID_LIST_JOBS)))
          .addMethod(
            getUpdateJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataproc.v1.UpdateJobRequest,
                com.google.cloud.dataproc.v1.Job>(
                  this, METHODID_UPDATE_JOB)))
          .addMethod(
            getCancelJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataproc.v1.CancelJobRequest,
                com.google.cloud.dataproc.v1.Job>(
                  this, METHODID_CANCEL_JOB)))
          .addMethod(
            getDeleteJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataproc.v1.DeleteJobRequest,
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
  public static final class JobControllerStub extends io.grpc.stub.AbstractAsyncStub<JobControllerStub> {
    private JobControllerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JobControllerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JobControllerStub(channel, callOptions);
    }

    /**
     * <pre>
     * Submits a job to a cluster.
     * </pre>
     */
    public void submitJob(com.google.cloud.dataproc.v1.SubmitJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.Job> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSubmitJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Submits job to a cluster.
     * </pre>
     */
    public void submitJobAsOperation(com.google.cloud.dataproc.v1.SubmitJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSubmitJobAsOperationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the resource representation for a job in a project.
     * </pre>
     */
    public void getJob(com.google.cloud.dataproc.v1.GetJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.Job> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists regions/{region}/jobs in a project.
     * </pre>
     */
    public void listJobs(com.google.cloud.dataproc.v1.ListJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.ListJobsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListJobsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a job in a project.
     * </pre>
     */
    public void updateJob(com.google.cloud.dataproc.v1.UpdateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.Job> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Starts a job cancellation request. To access the job resource
     * after cancellation, call
     * [regions/{region}/jobs.list](https://cloud.google.com/dataproc/docs/reference/rest/v1/projects.regions.jobs/list)
     * or
     * [regions/{region}/jobs.get](https://cloud.google.com/dataproc/docs/reference/rest/v1/projects.regions.jobs/get).
     * </pre>
     */
    public void cancelJob(com.google.cloud.dataproc.v1.CancelJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.Job> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the job from the project. If the job is active, the delete fails,
     * and the response returns `FAILED_PRECONDITION`.
     * </pre>
     */
    public void deleteJob(com.google.cloud.dataproc.v1.DeleteJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteJobMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The JobController provides methods to manage jobs.
   * </pre>
   */
  public static final class JobControllerBlockingStub extends io.grpc.stub.AbstractBlockingStub<JobControllerBlockingStub> {
    private JobControllerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JobControllerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JobControllerBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Submits a job to a cluster.
     * </pre>
     */
    public com.google.cloud.dataproc.v1.Job submitJob(com.google.cloud.dataproc.v1.SubmitJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSubmitJobMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Submits job to a cluster.
     * </pre>
     */
    public com.google.longrunning.Operation submitJobAsOperation(com.google.cloud.dataproc.v1.SubmitJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSubmitJobAsOperationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the resource representation for a job in a project.
     * </pre>
     */
    public com.google.cloud.dataproc.v1.Job getJob(com.google.cloud.dataproc.v1.GetJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetJobMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists regions/{region}/jobs in a project.
     * </pre>
     */
    public com.google.cloud.dataproc.v1.ListJobsResponse listJobs(com.google.cloud.dataproc.v1.ListJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListJobsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a job in a project.
     * </pre>
     */
    public com.google.cloud.dataproc.v1.Job updateJob(com.google.cloud.dataproc.v1.UpdateJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateJobMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Starts a job cancellation request. To access the job resource
     * after cancellation, call
     * [regions/{region}/jobs.list](https://cloud.google.com/dataproc/docs/reference/rest/v1/projects.regions.jobs/list)
     * or
     * [regions/{region}/jobs.get](https://cloud.google.com/dataproc/docs/reference/rest/v1/projects.regions.jobs/get).
     * </pre>
     */
    public com.google.cloud.dataproc.v1.Job cancelJob(com.google.cloud.dataproc.v1.CancelJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelJobMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the job from the project. If the job is active, the delete fails,
     * and the response returns `FAILED_PRECONDITION`.
     * </pre>
     */
    public com.google.protobuf.Empty deleteJob(com.google.cloud.dataproc.v1.DeleteJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteJobMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The JobController provides methods to manage jobs.
   * </pre>
   */
  public static final class JobControllerFutureStub extends io.grpc.stub.AbstractFutureStub<JobControllerFutureStub> {
    private JobControllerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JobControllerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JobControllerFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Submits a job to a cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataproc.v1.Job> submitJob(
        com.google.cloud.dataproc.v1.SubmitJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSubmitJobMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Submits job to a cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> submitJobAsOperation(
        com.google.cloud.dataproc.v1.SubmitJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSubmitJobAsOperationMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the resource representation for a job in a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataproc.v1.Job> getJob(
        com.google.cloud.dataproc.v1.GetJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetJobMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists regions/{region}/jobs in a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataproc.v1.ListJobsResponse> listJobs(
        com.google.cloud.dataproc.v1.ListJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListJobsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a job in a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataproc.v1.Job> updateJob(
        com.google.cloud.dataproc.v1.UpdateJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateJobMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Starts a job cancellation request. To access the job resource
     * after cancellation, call
     * [regions/{region}/jobs.list](https://cloud.google.com/dataproc/docs/reference/rest/v1/projects.regions.jobs/list)
     * or
     * [regions/{region}/jobs.get](https://cloud.google.com/dataproc/docs/reference/rest/v1/projects.regions.jobs/get).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataproc.v1.Job> cancelJob(
        com.google.cloud.dataproc.v1.CancelJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelJobMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the job from the project. If the job is active, the delete fails,
     * and the response returns `FAILED_PRECONDITION`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteJob(
        com.google.cloud.dataproc.v1.DeleteJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteJobMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SUBMIT_JOB = 0;
  private static final int METHODID_SUBMIT_JOB_AS_OPERATION = 1;
  private static final int METHODID_GET_JOB = 2;
  private static final int METHODID_LIST_JOBS = 3;
  private static final int METHODID_UPDATE_JOB = 4;
  private static final int METHODID_CANCEL_JOB = 5;
  private static final int METHODID_DELETE_JOB = 6;

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
          serviceImpl.submitJob((com.google.cloud.dataproc.v1.SubmitJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.Job>) responseObserver);
          break;
        case METHODID_SUBMIT_JOB_AS_OPERATION:
          serviceImpl.submitJobAsOperation((com.google.cloud.dataproc.v1.SubmitJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_JOB:
          serviceImpl.getJob((com.google.cloud.dataproc.v1.GetJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.Job>) responseObserver);
          break;
        case METHODID_LIST_JOBS:
          serviceImpl.listJobs((com.google.cloud.dataproc.v1.ListJobsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.ListJobsResponse>) responseObserver);
          break;
        case METHODID_UPDATE_JOB:
          serviceImpl.updateJob((com.google.cloud.dataproc.v1.UpdateJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.Job>) responseObserver);
          break;
        case METHODID_CANCEL_JOB:
          serviceImpl.cancelJob((com.google.cloud.dataproc.v1.CancelJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.Job>) responseObserver);
          break;
        case METHODID_DELETE_JOB:
          serviceImpl.deleteJob((com.google.cloud.dataproc.v1.DeleteJobRequest) request,
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
      return com.google.cloud.dataproc.v1.JobsProto.getDescriptor();
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
              .addMethod(getSubmitJobMethod())
              .addMethod(getSubmitJobAsOperationMethod())
              .addMethod(getGetJobMethod())
              .addMethod(getListJobsMethod())
              .addMethod(getUpdateJobMethod())
              .addMethod(getCancelJobMethod())
              .addMethod(getDeleteJobMethod())
              .build();
        }
      }
    }
    return result;
  }
}
