package com.google.dataflow.v1beta3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Provides a method to create and modify Google Cloud Dataflow jobs.
 * A Job is a multi-stage computation graph run by the Cloud Dataflow service.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/dataflow/v1beta3/jobs.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class JobsV1Beta3Grpc {

  private JobsV1Beta3Grpc() {}

  public static final String SERVICE_NAME = "google.dataflow.v1beta3.JobsV1Beta3";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.CreateJobRequest,
      com.google.dataflow.v1beta3.Job> getCreateJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateJob",
      requestType = com.google.dataflow.v1beta3.CreateJobRequest.class,
      responseType = com.google.dataflow.v1beta3.Job.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.CreateJobRequest,
      com.google.dataflow.v1beta3.Job> getCreateJobMethod() {
    io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.CreateJobRequest, com.google.dataflow.v1beta3.Job> getCreateJobMethod;
    if ((getCreateJobMethod = JobsV1Beta3Grpc.getCreateJobMethod) == null) {
      synchronized (JobsV1Beta3Grpc.class) {
        if ((getCreateJobMethod = JobsV1Beta3Grpc.getCreateJobMethod) == null) {
          JobsV1Beta3Grpc.getCreateJobMethod = getCreateJobMethod =
              io.grpc.MethodDescriptor.<com.google.dataflow.v1beta3.CreateJobRequest, com.google.dataflow.v1beta3.Job>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.dataflow.v1beta3.CreateJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.dataflow.v1beta3.Job.getDefaultInstance()))
              .setSchemaDescriptor(new JobsV1Beta3MethodDescriptorSupplier("CreateJob"))
              .build();
        }
      }
    }
    return getCreateJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.GetJobRequest,
      com.google.dataflow.v1beta3.Job> getGetJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetJob",
      requestType = com.google.dataflow.v1beta3.GetJobRequest.class,
      responseType = com.google.dataflow.v1beta3.Job.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.GetJobRequest,
      com.google.dataflow.v1beta3.Job> getGetJobMethod() {
    io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.GetJobRequest, com.google.dataflow.v1beta3.Job> getGetJobMethod;
    if ((getGetJobMethod = JobsV1Beta3Grpc.getGetJobMethod) == null) {
      synchronized (JobsV1Beta3Grpc.class) {
        if ((getGetJobMethod = JobsV1Beta3Grpc.getGetJobMethod) == null) {
          JobsV1Beta3Grpc.getGetJobMethod = getGetJobMethod =
              io.grpc.MethodDescriptor.<com.google.dataflow.v1beta3.GetJobRequest, com.google.dataflow.v1beta3.Job>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.dataflow.v1beta3.GetJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.dataflow.v1beta3.Job.getDefaultInstance()))
              .setSchemaDescriptor(new JobsV1Beta3MethodDescriptorSupplier("GetJob"))
              .build();
        }
      }
    }
    return getGetJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.UpdateJobRequest,
      com.google.dataflow.v1beta3.Job> getUpdateJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateJob",
      requestType = com.google.dataflow.v1beta3.UpdateJobRequest.class,
      responseType = com.google.dataflow.v1beta3.Job.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.UpdateJobRequest,
      com.google.dataflow.v1beta3.Job> getUpdateJobMethod() {
    io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.UpdateJobRequest, com.google.dataflow.v1beta3.Job> getUpdateJobMethod;
    if ((getUpdateJobMethod = JobsV1Beta3Grpc.getUpdateJobMethod) == null) {
      synchronized (JobsV1Beta3Grpc.class) {
        if ((getUpdateJobMethod = JobsV1Beta3Grpc.getUpdateJobMethod) == null) {
          JobsV1Beta3Grpc.getUpdateJobMethod = getUpdateJobMethod =
              io.grpc.MethodDescriptor.<com.google.dataflow.v1beta3.UpdateJobRequest, com.google.dataflow.v1beta3.Job>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.dataflow.v1beta3.UpdateJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.dataflow.v1beta3.Job.getDefaultInstance()))
              .setSchemaDescriptor(new JobsV1Beta3MethodDescriptorSupplier("UpdateJob"))
              .build();
        }
      }
    }
    return getUpdateJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.ListJobsRequest,
      com.google.dataflow.v1beta3.ListJobsResponse> getListJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListJobs",
      requestType = com.google.dataflow.v1beta3.ListJobsRequest.class,
      responseType = com.google.dataflow.v1beta3.ListJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.ListJobsRequest,
      com.google.dataflow.v1beta3.ListJobsResponse> getListJobsMethod() {
    io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.ListJobsRequest, com.google.dataflow.v1beta3.ListJobsResponse> getListJobsMethod;
    if ((getListJobsMethod = JobsV1Beta3Grpc.getListJobsMethod) == null) {
      synchronized (JobsV1Beta3Grpc.class) {
        if ((getListJobsMethod = JobsV1Beta3Grpc.getListJobsMethod) == null) {
          JobsV1Beta3Grpc.getListJobsMethod = getListJobsMethod =
              io.grpc.MethodDescriptor.<com.google.dataflow.v1beta3.ListJobsRequest, com.google.dataflow.v1beta3.ListJobsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListJobs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.dataflow.v1beta3.ListJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.dataflow.v1beta3.ListJobsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new JobsV1Beta3MethodDescriptorSupplier("ListJobs"))
              .build();
        }
      }
    }
    return getListJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.ListJobsRequest,
      com.google.dataflow.v1beta3.ListJobsResponse> getAggregatedListJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AggregatedListJobs",
      requestType = com.google.dataflow.v1beta3.ListJobsRequest.class,
      responseType = com.google.dataflow.v1beta3.ListJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.ListJobsRequest,
      com.google.dataflow.v1beta3.ListJobsResponse> getAggregatedListJobsMethod() {
    io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.ListJobsRequest, com.google.dataflow.v1beta3.ListJobsResponse> getAggregatedListJobsMethod;
    if ((getAggregatedListJobsMethod = JobsV1Beta3Grpc.getAggregatedListJobsMethod) == null) {
      synchronized (JobsV1Beta3Grpc.class) {
        if ((getAggregatedListJobsMethod = JobsV1Beta3Grpc.getAggregatedListJobsMethod) == null) {
          JobsV1Beta3Grpc.getAggregatedListJobsMethod = getAggregatedListJobsMethod =
              io.grpc.MethodDescriptor.<com.google.dataflow.v1beta3.ListJobsRequest, com.google.dataflow.v1beta3.ListJobsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AggregatedListJobs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.dataflow.v1beta3.ListJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.dataflow.v1beta3.ListJobsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new JobsV1Beta3MethodDescriptorSupplier("AggregatedListJobs"))
              .build();
        }
      }
    }
    return getAggregatedListJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.CheckActiveJobsRequest,
      com.google.dataflow.v1beta3.CheckActiveJobsResponse> getCheckActiveJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckActiveJobs",
      requestType = com.google.dataflow.v1beta3.CheckActiveJobsRequest.class,
      responseType = com.google.dataflow.v1beta3.CheckActiveJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.CheckActiveJobsRequest,
      com.google.dataflow.v1beta3.CheckActiveJobsResponse> getCheckActiveJobsMethod() {
    io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.CheckActiveJobsRequest, com.google.dataflow.v1beta3.CheckActiveJobsResponse> getCheckActiveJobsMethod;
    if ((getCheckActiveJobsMethod = JobsV1Beta3Grpc.getCheckActiveJobsMethod) == null) {
      synchronized (JobsV1Beta3Grpc.class) {
        if ((getCheckActiveJobsMethod = JobsV1Beta3Grpc.getCheckActiveJobsMethod) == null) {
          JobsV1Beta3Grpc.getCheckActiveJobsMethod = getCheckActiveJobsMethod =
              io.grpc.MethodDescriptor.<com.google.dataflow.v1beta3.CheckActiveJobsRequest, com.google.dataflow.v1beta3.CheckActiveJobsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CheckActiveJobs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.dataflow.v1beta3.CheckActiveJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.dataflow.v1beta3.CheckActiveJobsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new JobsV1Beta3MethodDescriptorSupplier("CheckActiveJobs"))
              .build();
        }
      }
    }
    return getCheckActiveJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.SnapshotJobRequest,
      com.google.dataflow.v1beta3.Snapshot> getSnapshotJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SnapshotJob",
      requestType = com.google.dataflow.v1beta3.SnapshotJobRequest.class,
      responseType = com.google.dataflow.v1beta3.Snapshot.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.SnapshotJobRequest,
      com.google.dataflow.v1beta3.Snapshot> getSnapshotJobMethod() {
    io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.SnapshotJobRequest, com.google.dataflow.v1beta3.Snapshot> getSnapshotJobMethod;
    if ((getSnapshotJobMethod = JobsV1Beta3Grpc.getSnapshotJobMethod) == null) {
      synchronized (JobsV1Beta3Grpc.class) {
        if ((getSnapshotJobMethod = JobsV1Beta3Grpc.getSnapshotJobMethod) == null) {
          JobsV1Beta3Grpc.getSnapshotJobMethod = getSnapshotJobMethod =
              io.grpc.MethodDescriptor.<com.google.dataflow.v1beta3.SnapshotJobRequest, com.google.dataflow.v1beta3.Snapshot>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SnapshotJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.dataflow.v1beta3.SnapshotJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.dataflow.v1beta3.Snapshot.getDefaultInstance()))
              .setSchemaDescriptor(new JobsV1Beta3MethodDescriptorSupplier("SnapshotJob"))
              .build();
        }
      }
    }
    return getSnapshotJobMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static JobsV1Beta3Stub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JobsV1Beta3Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JobsV1Beta3Stub>() {
        @java.lang.Override
        public JobsV1Beta3Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JobsV1Beta3Stub(channel, callOptions);
        }
      };
    return JobsV1Beta3Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static JobsV1Beta3BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JobsV1Beta3BlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JobsV1Beta3BlockingStub>() {
        @java.lang.Override
        public JobsV1Beta3BlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JobsV1Beta3BlockingStub(channel, callOptions);
        }
      };
    return JobsV1Beta3BlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static JobsV1Beta3FutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JobsV1Beta3FutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JobsV1Beta3FutureStub>() {
        @java.lang.Override
        public JobsV1Beta3FutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JobsV1Beta3FutureStub(channel, callOptions);
        }
      };
    return JobsV1Beta3FutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Provides a method to create and modify Google Cloud Dataflow jobs.
   * A Job is a multi-stage computation graph run by the Cloud Dataflow service.
   * </pre>
   */
  public static abstract class JobsV1Beta3ImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Creates a Cloud Dataflow job.
     * To create a job, we recommend using `projects.locations.jobs.create` with a
     * [regional endpoint]
     * (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
     * `projects.jobs.create` is not recommended, as your job will always start
     * in `us-central1`.
     * </pre>
     */
    public void createJob(com.google.dataflow.v1beta3.CreateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.Job> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateJobMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the state of the specified Cloud Dataflow job.
     * To get the state of a job, we recommend using `projects.locations.jobs.get`
     * with a [regional endpoint]
     * (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
     * `projects.jobs.get` is not recommended, as you can only get the state of
     * jobs that are running in `us-central1`.
     * </pre>
     */
    public void getJob(com.google.dataflow.v1beta3.GetJobRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.Job> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetJobMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the state of an existing Cloud Dataflow job.
     * To update the state of an existing job, we recommend using
     * `projects.locations.jobs.update` with a [regional endpoint]
     * (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
     * `projects.jobs.update` is not recommended, as you can only update the state
     * of jobs that are running in `us-central1`.
     * </pre>
     */
    public void updateJob(com.google.dataflow.v1beta3.UpdateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.Job> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateJobMethod(), responseObserver);
    }

    /**
     * <pre>
     * List the jobs of a project.
     * To list the jobs of a project in a region, we recommend using
     * `projects.locations.jobs.list` with a [regional endpoint]
     * (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). To
     * list the all jobs across all regions, use `projects.jobs.aggregated`. Using
     * `projects.jobs.list` is not recommended, as you can only get the list of
     * jobs that are running in `us-central1`.
     * </pre>
     */
    public void listJobs(com.google.dataflow.v1beta3.ListJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.ListJobsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListJobsMethod(), responseObserver);
    }

    /**
     * <pre>
     * List the jobs of a project across all regions.
     * </pre>
     */
    public void aggregatedListJobs(com.google.dataflow.v1beta3.ListJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.ListJobsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAggregatedListJobsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Check for existence of active jobs in the given project across all regions.
     * </pre>
     */
    public void checkActiveJobs(com.google.dataflow.v1beta3.CheckActiveJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.CheckActiveJobsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCheckActiveJobsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Snapshot the state of a streaming job.
     * </pre>
     */
    public void snapshotJob(com.google.dataflow.v1beta3.SnapshotJobRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.Snapshot> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSnapshotJobMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.dataflow.v1beta3.CreateJobRequest,
                com.google.dataflow.v1beta3.Job>(
                  this, METHODID_CREATE_JOB)))
          .addMethod(
            getGetJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.dataflow.v1beta3.GetJobRequest,
                com.google.dataflow.v1beta3.Job>(
                  this, METHODID_GET_JOB)))
          .addMethod(
            getUpdateJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.dataflow.v1beta3.UpdateJobRequest,
                com.google.dataflow.v1beta3.Job>(
                  this, METHODID_UPDATE_JOB)))
          .addMethod(
            getListJobsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.dataflow.v1beta3.ListJobsRequest,
                com.google.dataflow.v1beta3.ListJobsResponse>(
                  this, METHODID_LIST_JOBS)))
          .addMethod(
            getAggregatedListJobsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.dataflow.v1beta3.ListJobsRequest,
                com.google.dataflow.v1beta3.ListJobsResponse>(
                  this, METHODID_AGGREGATED_LIST_JOBS)))
          .addMethod(
            getCheckActiveJobsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.dataflow.v1beta3.CheckActiveJobsRequest,
                com.google.dataflow.v1beta3.CheckActiveJobsResponse>(
                  this, METHODID_CHECK_ACTIVE_JOBS)))
          .addMethod(
            getSnapshotJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.dataflow.v1beta3.SnapshotJobRequest,
                com.google.dataflow.v1beta3.Snapshot>(
                  this, METHODID_SNAPSHOT_JOB)))
          .build();
    }
  }

  /**
   * <pre>
   * Provides a method to create and modify Google Cloud Dataflow jobs.
   * A Job is a multi-stage computation graph run by the Cloud Dataflow service.
   * </pre>
   */
  public static final class JobsV1Beta3Stub extends io.grpc.stub.AbstractAsyncStub<JobsV1Beta3Stub> {
    private JobsV1Beta3Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JobsV1Beta3Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JobsV1Beta3Stub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a Cloud Dataflow job.
     * To create a job, we recommend using `projects.locations.jobs.create` with a
     * [regional endpoint]
     * (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
     * `projects.jobs.create` is not recommended, as your job will always start
     * in `us-central1`.
     * </pre>
     */
    public void createJob(com.google.dataflow.v1beta3.CreateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.Job> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the state of the specified Cloud Dataflow job.
     * To get the state of a job, we recommend using `projects.locations.jobs.get`
     * with a [regional endpoint]
     * (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
     * `projects.jobs.get` is not recommended, as you can only get the state of
     * jobs that are running in `us-central1`.
     * </pre>
     */
    public void getJob(com.google.dataflow.v1beta3.GetJobRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.Job> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the state of an existing Cloud Dataflow job.
     * To update the state of an existing job, we recommend using
     * `projects.locations.jobs.update` with a [regional endpoint]
     * (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
     * `projects.jobs.update` is not recommended, as you can only update the state
     * of jobs that are running in `us-central1`.
     * </pre>
     */
    public void updateJob(com.google.dataflow.v1beta3.UpdateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.Job> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * List the jobs of a project.
     * To list the jobs of a project in a region, we recommend using
     * `projects.locations.jobs.list` with a [regional endpoint]
     * (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). To
     * list the all jobs across all regions, use `projects.jobs.aggregated`. Using
     * `projects.jobs.list` is not recommended, as you can only get the list of
     * jobs that are running in `us-central1`.
     * </pre>
     */
    public void listJobs(com.google.dataflow.v1beta3.ListJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.ListJobsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListJobsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * List the jobs of a project across all regions.
     * </pre>
     */
    public void aggregatedListJobs(com.google.dataflow.v1beta3.ListJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.ListJobsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAggregatedListJobsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Check for existence of active jobs in the given project across all regions.
     * </pre>
     */
    public void checkActiveJobs(com.google.dataflow.v1beta3.CheckActiveJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.CheckActiveJobsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckActiveJobsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Snapshot the state of a streaming job.
     * </pre>
     */
    public void snapshotJob(com.google.dataflow.v1beta3.SnapshotJobRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.Snapshot> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSnapshotJobMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Provides a method to create and modify Google Cloud Dataflow jobs.
   * A Job is a multi-stage computation graph run by the Cloud Dataflow service.
   * </pre>
   */
  public static final class JobsV1Beta3BlockingStub extends io.grpc.stub.AbstractBlockingStub<JobsV1Beta3BlockingStub> {
    private JobsV1Beta3BlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JobsV1Beta3BlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JobsV1Beta3BlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a Cloud Dataflow job.
     * To create a job, we recommend using `projects.locations.jobs.create` with a
     * [regional endpoint]
     * (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
     * `projects.jobs.create` is not recommended, as your job will always start
     * in `us-central1`.
     * </pre>
     */
    public com.google.dataflow.v1beta3.Job createJob(com.google.dataflow.v1beta3.CreateJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateJobMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the state of the specified Cloud Dataflow job.
     * To get the state of a job, we recommend using `projects.locations.jobs.get`
     * with a [regional endpoint]
     * (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
     * `projects.jobs.get` is not recommended, as you can only get the state of
     * jobs that are running in `us-central1`.
     * </pre>
     */
    public com.google.dataflow.v1beta3.Job getJob(com.google.dataflow.v1beta3.GetJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetJobMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the state of an existing Cloud Dataflow job.
     * To update the state of an existing job, we recommend using
     * `projects.locations.jobs.update` with a [regional endpoint]
     * (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
     * `projects.jobs.update` is not recommended, as you can only update the state
     * of jobs that are running in `us-central1`.
     * </pre>
     */
    public com.google.dataflow.v1beta3.Job updateJob(com.google.dataflow.v1beta3.UpdateJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateJobMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * List the jobs of a project.
     * To list the jobs of a project in a region, we recommend using
     * `projects.locations.jobs.list` with a [regional endpoint]
     * (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). To
     * list the all jobs across all regions, use `projects.jobs.aggregated`. Using
     * `projects.jobs.list` is not recommended, as you can only get the list of
     * jobs that are running in `us-central1`.
     * </pre>
     */
    public com.google.dataflow.v1beta3.ListJobsResponse listJobs(com.google.dataflow.v1beta3.ListJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListJobsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * List the jobs of a project across all regions.
     * </pre>
     */
    public com.google.dataflow.v1beta3.ListJobsResponse aggregatedListJobs(com.google.dataflow.v1beta3.ListJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAggregatedListJobsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Check for existence of active jobs in the given project across all regions.
     * </pre>
     */
    public com.google.dataflow.v1beta3.CheckActiveJobsResponse checkActiveJobs(com.google.dataflow.v1beta3.CheckActiveJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckActiveJobsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Snapshot the state of a streaming job.
     * </pre>
     */
    public com.google.dataflow.v1beta3.Snapshot snapshotJob(com.google.dataflow.v1beta3.SnapshotJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSnapshotJobMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Provides a method to create and modify Google Cloud Dataflow jobs.
   * A Job is a multi-stage computation graph run by the Cloud Dataflow service.
   * </pre>
   */
  public static final class JobsV1Beta3FutureStub extends io.grpc.stub.AbstractFutureStub<JobsV1Beta3FutureStub> {
    private JobsV1Beta3FutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JobsV1Beta3FutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JobsV1Beta3FutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a Cloud Dataflow job.
     * To create a job, we recommend using `projects.locations.jobs.create` with a
     * [regional endpoint]
     * (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
     * `projects.jobs.create` is not recommended, as your job will always start
     * in `us-central1`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.dataflow.v1beta3.Job> createJob(
        com.google.dataflow.v1beta3.CreateJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateJobMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the state of the specified Cloud Dataflow job.
     * To get the state of a job, we recommend using `projects.locations.jobs.get`
     * with a [regional endpoint]
     * (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
     * `projects.jobs.get` is not recommended, as you can only get the state of
     * jobs that are running in `us-central1`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.dataflow.v1beta3.Job> getJob(
        com.google.dataflow.v1beta3.GetJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetJobMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the state of an existing Cloud Dataflow job.
     * To update the state of an existing job, we recommend using
     * `projects.locations.jobs.update` with a [regional endpoint]
     * (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
     * `projects.jobs.update` is not recommended, as you can only update the state
     * of jobs that are running in `us-central1`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.dataflow.v1beta3.Job> updateJob(
        com.google.dataflow.v1beta3.UpdateJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateJobMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * List the jobs of a project.
     * To list the jobs of a project in a region, we recommend using
     * `projects.locations.jobs.list` with a [regional endpoint]
     * (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). To
     * list the all jobs across all regions, use `projects.jobs.aggregated`. Using
     * `projects.jobs.list` is not recommended, as you can only get the list of
     * jobs that are running in `us-central1`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.dataflow.v1beta3.ListJobsResponse> listJobs(
        com.google.dataflow.v1beta3.ListJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListJobsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * List the jobs of a project across all regions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.dataflow.v1beta3.ListJobsResponse> aggregatedListJobs(
        com.google.dataflow.v1beta3.ListJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAggregatedListJobsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Check for existence of active jobs in the given project across all regions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.dataflow.v1beta3.CheckActiveJobsResponse> checkActiveJobs(
        com.google.dataflow.v1beta3.CheckActiveJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckActiveJobsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Snapshot the state of a streaming job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.dataflow.v1beta3.Snapshot> snapshotJob(
        com.google.dataflow.v1beta3.SnapshotJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSnapshotJobMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_JOB = 0;
  private static final int METHODID_GET_JOB = 1;
  private static final int METHODID_UPDATE_JOB = 2;
  private static final int METHODID_LIST_JOBS = 3;
  private static final int METHODID_AGGREGATED_LIST_JOBS = 4;
  private static final int METHODID_CHECK_ACTIVE_JOBS = 5;
  private static final int METHODID_SNAPSHOT_JOB = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final JobsV1Beta3ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(JobsV1Beta3ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_JOB:
          serviceImpl.createJob((com.google.dataflow.v1beta3.CreateJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.Job>) responseObserver);
          break;
        case METHODID_GET_JOB:
          serviceImpl.getJob((com.google.dataflow.v1beta3.GetJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.Job>) responseObserver);
          break;
        case METHODID_UPDATE_JOB:
          serviceImpl.updateJob((com.google.dataflow.v1beta3.UpdateJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.Job>) responseObserver);
          break;
        case METHODID_LIST_JOBS:
          serviceImpl.listJobs((com.google.dataflow.v1beta3.ListJobsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.ListJobsResponse>) responseObserver);
          break;
        case METHODID_AGGREGATED_LIST_JOBS:
          serviceImpl.aggregatedListJobs((com.google.dataflow.v1beta3.ListJobsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.ListJobsResponse>) responseObserver);
          break;
        case METHODID_CHECK_ACTIVE_JOBS:
          serviceImpl.checkActiveJobs((com.google.dataflow.v1beta3.CheckActiveJobsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.CheckActiveJobsResponse>) responseObserver);
          break;
        case METHODID_SNAPSHOT_JOB:
          serviceImpl.snapshotJob((com.google.dataflow.v1beta3.SnapshotJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.Snapshot>) responseObserver);
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

  private static abstract class JobsV1Beta3BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    JobsV1Beta3BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.dataflow.v1beta3.JobsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("JobsV1Beta3");
    }
  }

  private static final class JobsV1Beta3FileDescriptorSupplier
      extends JobsV1Beta3BaseDescriptorSupplier {
    JobsV1Beta3FileDescriptorSupplier() {}
  }

  private static final class JobsV1Beta3MethodDescriptorSupplier
      extends JobsV1Beta3BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    JobsV1Beta3MethodDescriptorSupplier(String methodName) {
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
      synchronized (JobsV1Beta3Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new JobsV1Beta3FileDescriptorSupplier())
              .addMethod(getCreateJobMethod())
              .addMethod(getGetJobMethod())
              .addMethod(getUpdateJobMethod())
              .addMethod(getListJobsMethod())
              .addMethod(getAggregatedListJobsMethod())
              .addMethod(getCheckActiveJobsMethod())
              .addMethod(getSnapshotJobMethod())
              .build();
        }
      }
    }
    return result;
  }
}
