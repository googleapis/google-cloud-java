package com.google.cloud.talent.v4beta1;

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
 * A service handles job management, including job CRUD, enumeration and search.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/talent/v4beta1/job_service.proto")
public final class JobServiceGrpc {

  private JobServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.talent.v4beta1.JobService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateJobMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.CreateJobRequest, com.google.cloud.talent.v4beta1.Job>
      METHOD_CREATE_JOB = getCreateJobMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.CreateJobRequest, com.google.cloud.talent.v4beta1.Job>
      getCreateJobMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.CreateJobRequest, com.google.cloud.talent.v4beta1.Job>
      getCreateJobMethod() {
    return getCreateJobMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.CreateJobRequest, com.google.cloud.talent.v4beta1.Job>
      getCreateJobMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.CreateJobRequest, com.google.cloud.talent.v4beta1.Job>
        getCreateJobMethod;
    if ((getCreateJobMethod = JobServiceGrpc.getCreateJobMethod) == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getCreateJobMethod = JobServiceGrpc.getCreateJobMethod) == null) {
          JobServiceGrpc.getCreateJobMethod =
              getCreateJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.CreateJobRequest,
                          com.google.cloud.talent.v4beta1.Job>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.talent.v4beta1.JobService", "CreateJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.CreateJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.Job.getDefaultInstance()))
                      .setSchemaDescriptor(new JobServiceMethodDescriptorSupplier("CreateJob"))
                      .build();
        }
      }
    }
    return getCreateJobMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetJobMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.GetJobRequest, com.google.cloud.talent.v4beta1.Job>
      METHOD_GET_JOB = getGetJobMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.GetJobRequest, com.google.cloud.talent.v4beta1.Job>
      getGetJobMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.GetJobRequest, com.google.cloud.talent.v4beta1.Job>
      getGetJobMethod() {
    return getGetJobMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.GetJobRequest, com.google.cloud.talent.v4beta1.Job>
      getGetJobMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.GetJobRequest, com.google.cloud.talent.v4beta1.Job>
        getGetJobMethod;
    if ((getGetJobMethod = JobServiceGrpc.getGetJobMethod) == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getGetJobMethod = JobServiceGrpc.getGetJobMethod) == null) {
          JobServiceGrpc.getGetJobMethod =
              getGetJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.GetJobRequest,
                          com.google.cloud.talent.v4beta1.Job>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.talent.v4beta1.JobService", "GetJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.GetJobRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.Job.getDefaultInstance()))
                      .setSchemaDescriptor(new JobServiceMethodDescriptorSupplier("GetJob"))
                      .build();
        }
      }
    }
    return getGetJobMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateJobMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.UpdateJobRequest, com.google.cloud.talent.v4beta1.Job>
      METHOD_UPDATE_JOB = getUpdateJobMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.UpdateJobRequest, com.google.cloud.talent.v4beta1.Job>
      getUpdateJobMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.UpdateJobRequest, com.google.cloud.talent.v4beta1.Job>
      getUpdateJobMethod() {
    return getUpdateJobMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.UpdateJobRequest, com.google.cloud.talent.v4beta1.Job>
      getUpdateJobMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.UpdateJobRequest, com.google.cloud.talent.v4beta1.Job>
        getUpdateJobMethod;
    if ((getUpdateJobMethod = JobServiceGrpc.getUpdateJobMethod) == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getUpdateJobMethod = JobServiceGrpc.getUpdateJobMethod) == null) {
          JobServiceGrpc.getUpdateJobMethod =
              getUpdateJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.UpdateJobRequest,
                          com.google.cloud.talent.v4beta1.Job>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.talent.v4beta1.JobService", "UpdateJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.UpdateJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.Job.getDefaultInstance()))
                      .setSchemaDescriptor(new JobServiceMethodDescriptorSupplier("UpdateJob"))
                      .build();
        }
      }
    }
    return getUpdateJobMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteJobMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.DeleteJobRequest, com.google.protobuf.Empty>
      METHOD_DELETE_JOB = getDeleteJobMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.DeleteJobRequest, com.google.protobuf.Empty>
      getDeleteJobMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.DeleteJobRequest, com.google.protobuf.Empty>
      getDeleteJobMethod() {
    return getDeleteJobMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.DeleteJobRequest, com.google.protobuf.Empty>
      getDeleteJobMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.DeleteJobRequest, com.google.protobuf.Empty>
        getDeleteJobMethod;
    if ((getDeleteJobMethod = JobServiceGrpc.getDeleteJobMethod) == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getDeleteJobMethod = JobServiceGrpc.getDeleteJobMethod) == null) {
          JobServiceGrpc.getDeleteJobMethod =
              getDeleteJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.DeleteJobRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.talent.v4beta1.JobService", "DeleteJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.DeleteJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new JobServiceMethodDescriptorSupplier("DeleteJob"))
                      .build();
        }
      }
    }
    return getDeleteJobMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListJobsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.ListJobsRequest,
          com.google.cloud.talent.v4beta1.ListJobsResponse>
      METHOD_LIST_JOBS = getListJobsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.ListJobsRequest,
          com.google.cloud.talent.v4beta1.ListJobsResponse>
      getListJobsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.ListJobsRequest,
          com.google.cloud.talent.v4beta1.ListJobsResponse>
      getListJobsMethod() {
    return getListJobsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.ListJobsRequest,
          com.google.cloud.talent.v4beta1.ListJobsResponse>
      getListJobsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.ListJobsRequest,
            com.google.cloud.talent.v4beta1.ListJobsResponse>
        getListJobsMethod;
    if ((getListJobsMethod = JobServiceGrpc.getListJobsMethod) == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getListJobsMethod = JobServiceGrpc.getListJobsMethod) == null) {
          JobServiceGrpc.getListJobsMethod =
              getListJobsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.ListJobsRequest,
                          com.google.cloud.talent.v4beta1.ListJobsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.talent.v4beta1.JobService", "ListJobs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.ListJobsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.ListJobsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new JobServiceMethodDescriptorSupplier("ListJobs"))
                      .build();
        }
      }
    }
    return getListJobsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBatchDeleteJobsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.BatchDeleteJobsRequest, com.google.protobuf.Empty>
      METHOD_BATCH_DELETE_JOBS = getBatchDeleteJobsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.BatchDeleteJobsRequest, com.google.protobuf.Empty>
      getBatchDeleteJobsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.BatchDeleteJobsRequest, com.google.protobuf.Empty>
      getBatchDeleteJobsMethod() {
    return getBatchDeleteJobsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.BatchDeleteJobsRequest, com.google.protobuf.Empty>
      getBatchDeleteJobsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.BatchDeleteJobsRequest, com.google.protobuf.Empty>
        getBatchDeleteJobsMethod;
    if ((getBatchDeleteJobsMethod = JobServiceGrpc.getBatchDeleteJobsMethod) == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getBatchDeleteJobsMethod = JobServiceGrpc.getBatchDeleteJobsMethod) == null) {
          JobServiceGrpc.getBatchDeleteJobsMethod =
              getBatchDeleteJobsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.BatchDeleteJobsRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.talent.v4beta1.JobService", "BatchDeleteJobs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.BatchDeleteJobsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new JobServiceMethodDescriptorSupplier("BatchDeleteJobs"))
                      .build();
        }
      }
    }
    return getBatchDeleteJobsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSearchJobsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.SearchJobsRequest,
          com.google.cloud.talent.v4beta1.SearchJobsResponse>
      METHOD_SEARCH_JOBS = getSearchJobsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.SearchJobsRequest,
          com.google.cloud.talent.v4beta1.SearchJobsResponse>
      getSearchJobsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.SearchJobsRequest,
          com.google.cloud.talent.v4beta1.SearchJobsResponse>
      getSearchJobsMethod() {
    return getSearchJobsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.SearchJobsRequest,
          com.google.cloud.talent.v4beta1.SearchJobsResponse>
      getSearchJobsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.SearchJobsRequest,
            com.google.cloud.talent.v4beta1.SearchJobsResponse>
        getSearchJobsMethod;
    if ((getSearchJobsMethod = JobServiceGrpc.getSearchJobsMethod) == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getSearchJobsMethod = JobServiceGrpc.getSearchJobsMethod) == null) {
          JobServiceGrpc.getSearchJobsMethod =
              getSearchJobsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.SearchJobsRequest,
                          com.google.cloud.talent.v4beta1.SearchJobsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.talent.v4beta1.JobService", "SearchJobs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.SearchJobsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.SearchJobsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new JobServiceMethodDescriptorSupplier("SearchJobs"))
                      .build();
        }
      }
    }
    return getSearchJobsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSearchJobsForAlertMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.SearchJobsRequest,
          com.google.cloud.talent.v4beta1.SearchJobsResponse>
      METHOD_SEARCH_JOBS_FOR_ALERT = getSearchJobsForAlertMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.SearchJobsRequest,
          com.google.cloud.talent.v4beta1.SearchJobsResponse>
      getSearchJobsForAlertMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.SearchJobsRequest,
          com.google.cloud.talent.v4beta1.SearchJobsResponse>
      getSearchJobsForAlertMethod() {
    return getSearchJobsForAlertMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.SearchJobsRequest,
          com.google.cloud.talent.v4beta1.SearchJobsResponse>
      getSearchJobsForAlertMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.SearchJobsRequest,
            com.google.cloud.talent.v4beta1.SearchJobsResponse>
        getSearchJobsForAlertMethod;
    if ((getSearchJobsForAlertMethod = JobServiceGrpc.getSearchJobsForAlertMethod) == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getSearchJobsForAlertMethod = JobServiceGrpc.getSearchJobsForAlertMethod) == null) {
          JobServiceGrpc.getSearchJobsForAlertMethod =
              getSearchJobsForAlertMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.SearchJobsRequest,
                          com.google.cloud.talent.v4beta1.SearchJobsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.talent.v4beta1.JobService", "SearchJobsForAlert"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.SearchJobsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.SearchJobsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new JobServiceMethodDescriptorSupplier("SearchJobsForAlert"))
                      .build();
        }
      }
    }
    return getSearchJobsForAlertMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static JobServiceStub newStub(io.grpc.Channel channel) {
    return new JobServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static JobServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new JobServiceBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static JobServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    return new JobServiceFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * A service handles job management, including job CRUD, enumeration and search.
   * </pre>
   */
  public abstract static class JobServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a new job.
     * Typically, the job becomes searchable within 10 seconds, but it may take
     * up to 5 minutes.
     * </pre>
     */
    public void createJob(
        com.google.cloud.talent.v4beta1.CreateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Job> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateJobMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified job, whose status is OPEN or recently EXPIRED
     * within the last 90 days.
     * </pre>
     */
    public void getJob(
        com.google.cloud.talent.v4beta1.GetJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Job> responseObserver) {
      asyncUnimplementedUnaryCall(getGetJobMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates specified job.
     * Typically, updated contents become visible in search results within 10
     * seconds, but it may take up to 5 minutes.
     * </pre>
     */
    public void updateJob(
        com.google.cloud.talent.v4beta1.UpdateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Job> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateJobMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified job.
     * Typically, the job becomes unsearchable within 10 seconds, but it may take
     * up to 5 minutes.
     * </pre>
     */
    public void deleteJob(
        com.google.cloud.talent.v4beta1.DeleteJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteJobMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists jobs by filter.
     * </pre>
     */
    public void listJobs(
        com.google.cloud.talent.v4beta1.ListJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.ListJobsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListJobsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a list of [Job][google.cloud.talent.v4beta1.Job]s by filter.
     * </pre>
     */
    public void batchDeleteJobs(
        com.google.cloud.talent.v4beta1.BatchDeleteJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getBatchDeleteJobsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches for jobs using the provided
     * [SearchJobsRequest][google.cloud.talent.v4beta1.SearchJobsRequest].
     * This call constrains the
     * [visibility][google.cloud.talent.v4beta1.Job.visibility] of jobs present in
     * the database, and only returns jobs that the caller has permission to
     * search against.
     * </pre>
     */
    public void searchJobs(
        com.google.cloud.talent.v4beta1.SearchJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.SearchJobsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getSearchJobsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches for jobs using the provided
     * [SearchJobsRequest][google.cloud.talent.v4beta1.SearchJobsRequest].
     * This API call is intended for the use case of targeting passive job
     * seekers (for example, job seekers who have signed up to receive email
     * alerts about potential job opportunities), and has different algorithmic
     * adjustments that are targeted to passive job seekers.
     * This call constrains the
     * [visibility][google.cloud.talent.v4beta1.Job.visibility] of jobs present in
     * the database, and only returns jobs the caller has permission to search
     * against.
     * </pre>
     */
    public void searchJobsForAlert(
        com.google.cloud.talent.v4beta1.SearchJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.SearchJobsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getSearchJobsForAlertMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateJobMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.CreateJobRequest,
                      com.google.cloud.talent.v4beta1.Job>(this, METHODID_CREATE_JOB)))
          .addMethod(
              getGetJobMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.GetJobRequest,
                      com.google.cloud.talent.v4beta1.Job>(this, METHODID_GET_JOB)))
          .addMethod(
              getUpdateJobMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.UpdateJobRequest,
                      com.google.cloud.talent.v4beta1.Job>(this, METHODID_UPDATE_JOB)))
          .addMethod(
              getDeleteJobMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.DeleteJobRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_JOB)))
          .addMethod(
              getListJobsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.ListJobsRequest,
                      com.google.cloud.talent.v4beta1.ListJobsResponse>(this, METHODID_LIST_JOBS)))
          .addMethod(
              getBatchDeleteJobsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.BatchDeleteJobsRequest,
                      com.google.protobuf.Empty>(this, METHODID_BATCH_DELETE_JOBS)))
          .addMethod(
              getSearchJobsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.SearchJobsRequest,
                      com.google.cloud.talent.v4beta1.SearchJobsResponse>(
                      this, METHODID_SEARCH_JOBS)))
          .addMethod(
              getSearchJobsForAlertMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.SearchJobsRequest,
                      com.google.cloud.talent.v4beta1.SearchJobsResponse>(
                      this, METHODID_SEARCH_JOBS_FOR_ALERT)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * A service handles job management, including job CRUD, enumeration and search.
   * </pre>
   */
  public static final class JobServiceStub extends io.grpc.stub.AbstractStub<JobServiceStub> {
    private JobServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private JobServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JobServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JobServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new job.
     * Typically, the job becomes searchable within 10 seconds, but it may take
     * up to 5 minutes.
     * </pre>
     */
    public void createJob(
        com.google.cloud.talent.v4beta1.CreateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Job> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateJobMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified job, whose status is OPEN or recently EXPIRED
     * within the last 90 days.
     * </pre>
     */
    public void getJob(
        com.google.cloud.talent.v4beta1.GetJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Job> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetJobMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates specified job.
     * Typically, updated contents become visible in search results within 10
     * seconds, but it may take up to 5 minutes.
     * </pre>
     */
    public void updateJob(
        com.google.cloud.talent.v4beta1.UpdateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Job> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateJobMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified job.
     * Typically, the job becomes unsearchable within 10 seconds, but it may take
     * up to 5 minutes.
     * </pre>
     */
    public void deleteJob(
        com.google.cloud.talent.v4beta1.DeleteJobRequest request,
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
     * Lists jobs by filter.
     * </pre>
     */
    public void listJobs(
        com.google.cloud.talent.v4beta1.ListJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.ListJobsResponse>
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
     * Deletes a list of [Job][google.cloud.talent.v4beta1.Job]s by filter.
     * </pre>
     */
    public void batchDeleteJobs(
        com.google.cloud.talent.v4beta1.BatchDeleteJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBatchDeleteJobsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches for jobs using the provided
     * [SearchJobsRequest][google.cloud.talent.v4beta1.SearchJobsRequest].
     * This call constrains the
     * [visibility][google.cloud.talent.v4beta1.Job.visibility] of jobs present in
     * the database, and only returns jobs that the caller has permission to
     * search against.
     * </pre>
     */
    public void searchJobs(
        com.google.cloud.talent.v4beta1.SearchJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.SearchJobsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSearchJobsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches for jobs using the provided
     * [SearchJobsRequest][google.cloud.talent.v4beta1.SearchJobsRequest].
     * This API call is intended for the use case of targeting passive job
     * seekers (for example, job seekers who have signed up to receive email
     * alerts about potential job opportunities), and has different algorithmic
     * adjustments that are targeted to passive job seekers.
     * This call constrains the
     * [visibility][google.cloud.talent.v4beta1.Job.visibility] of jobs present in
     * the database, and only returns jobs the caller has permission to search
     * against.
     * </pre>
     */
    public void searchJobsForAlert(
        com.google.cloud.talent.v4beta1.SearchJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.SearchJobsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSearchJobsForAlertMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * A service handles job management, including job CRUD, enumeration and search.
   * </pre>
   */
  public static final class JobServiceBlockingStub
      extends io.grpc.stub.AbstractStub<JobServiceBlockingStub> {
    private JobServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private JobServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JobServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JobServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new job.
     * Typically, the job becomes searchable within 10 seconds, but it may take
     * up to 5 minutes.
     * </pre>
     */
    public com.google.cloud.talent.v4beta1.Job createJob(
        com.google.cloud.talent.v4beta1.CreateJobRequest request) {
      return blockingUnaryCall(getChannel(), getCreateJobMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified job, whose status is OPEN or recently EXPIRED
     * within the last 90 days.
     * </pre>
     */
    public com.google.cloud.talent.v4beta1.Job getJob(
        com.google.cloud.talent.v4beta1.GetJobRequest request) {
      return blockingUnaryCall(getChannel(), getGetJobMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates specified job.
     * Typically, updated contents become visible in search results within 10
     * seconds, but it may take up to 5 minutes.
     * </pre>
     */
    public com.google.cloud.talent.v4beta1.Job updateJob(
        com.google.cloud.talent.v4beta1.UpdateJobRequest request) {
      return blockingUnaryCall(getChannel(), getUpdateJobMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified job.
     * Typically, the job becomes unsearchable within 10 seconds, but it may take
     * up to 5 minutes.
     * </pre>
     */
    public com.google.protobuf.Empty deleteJob(
        com.google.cloud.talent.v4beta1.DeleteJobRequest request) {
      return blockingUnaryCall(getChannel(), getDeleteJobMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists jobs by filter.
     * </pre>
     */
    public com.google.cloud.talent.v4beta1.ListJobsResponse listJobs(
        com.google.cloud.talent.v4beta1.ListJobsRequest request) {
      return blockingUnaryCall(getChannel(), getListJobsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a list of [Job][google.cloud.talent.v4beta1.Job]s by filter.
     * </pre>
     */
    public com.google.protobuf.Empty batchDeleteJobs(
        com.google.cloud.talent.v4beta1.BatchDeleteJobsRequest request) {
      return blockingUnaryCall(
          getChannel(), getBatchDeleteJobsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Searches for jobs using the provided
     * [SearchJobsRequest][google.cloud.talent.v4beta1.SearchJobsRequest].
     * This call constrains the
     * [visibility][google.cloud.talent.v4beta1.Job.visibility] of jobs present in
     * the database, and only returns jobs that the caller has permission to
     * search against.
     * </pre>
     */
    public com.google.cloud.talent.v4beta1.SearchJobsResponse searchJobs(
        com.google.cloud.talent.v4beta1.SearchJobsRequest request) {
      return blockingUnaryCall(
          getChannel(), getSearchJobsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Searches for jobs using the provided
     * [SearchJobsRequest][google.cloud.talent.v4beta1.SearchJobsRequest].
     * This API call is intended for the use case of targeting passive job
     * seekers (for example, job seekers who have signed up to receive email
     * alerts about potential job opportunities), and has different algorithmic
     * adjustments that are targeted to passive job seekers.
     * This call constrains the
     * [visibility][google.cloud.talent.v4beta1.Job.visibility] of jobs present in
     * the database, and only returns jobs the caller has permission to search
     * against.
     * </pre>
     */
    public com.google.cloud.talent.v4beta1.SearchJobsResponse searchJobsForAlert(
        com.google.cloud.talent.v4beta1.SearchJobsRequest request) {
      return blockingUnaryCall(
          getChannel(), getSearchJobsForAlertMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * A service handles job management, including job CRUD, enumeration and search.
   * </pre>
   */
  public static final class JobServiceFutureStub
      extends io.grpc.stub.AbstractStub<JobServiceFutureStub> {
    private JobServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private JobServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JobServiceFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JobServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new job.
     * Typically, the job becomes searchable within 10 seconds, but it may take
     * up to 5 minutes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.talent.v4beta1.Job>
        createJob(com.google.cloud.talent.v4beta1.CreateJobRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateJobMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified job, whose status is OPEN or recently EXPIRED
     * within the last 90 days.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.talent.v4beta1.Job>
        getJob(com.google.cloud.talent.v4beta1.GetJobRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetJobMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates specified job.
     * Typically, updated contents become visible in search results within 10
     * seconds, but it may take up to 5 minutes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.talent.v4beta1.Job>
        updateJob(com.google.cloud.talent.v4beta1.UpdateJobRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateJobMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified job.
     * Typically, the job becomes unsearchable within 10 seconds, but it may take
     * up to 5 minutes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteJob(
        com.google.cloud.talent.v4beta1.DeleteJobRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteJobMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists jobs by filter.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.talent.v4beta1.ListJobsResponse>
        listJobs(com.google.cloud.talent.v4beta1.ListJobsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListJobsMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a list of [Job][google.cloud.talent.v4beta1.Job]s by filter.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        batchDeleteJobs(com.google.cloud.talent.v4beta1.BatchDeleteJobsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBatchDeleteJobsMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Searches for jobs using the provided
     * [SearchJobsRequest][google.cloud.talent.v4beta1.SearchJobsRequest].
     * This call constrains the
     * [visibility][google.cloud.talent.v4beta1.Job.visibility] of jobs present in
     * the database, and only returns jobs that the caller has permission to
     * search against.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.talent.v4beta1.SearchJobsResponse>
        searchJobs(com.google.cloud.talent.v4beta1.SearchJobsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSearchJobsMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Searches for jobs using the provided
     * [SearchJobsRequest][google.cloud.talent.v4beta1.SearchJobsRequest].
     * This API call is intended for the use case of targeting passive job
     * seekers (for example, job seekers who have signed up to receive email
     * alerts about potential job opportunities), and has different algorithmic
     * adjustments that are targeted to passive job seekers.
     * This call constrains the
     * [visibility][google.cloud.talent.v4beta1.Job.visibility] of jobs present in
     * the database, and only returns jobs the caller has permission to search
     * against.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.talent.v4beta1.SearchJobsResponse>
        searchJobsForAlert(com.google.cloud.talent.v4beta1.SearchJobsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSearchJobsForAlertMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_JOB = 0;
  private static final int METHODID_GET_JOB = 1;
  private static final int METHODID_UPDATE_JOB = 2;
  private static final int METHODID_DELETE_JOB = 3;
  private static final int METHODID_LIST_JOBS = 4;
  private static final int METHODID_BATCH_DELETE_JOBS = 5;
  private static final int METHODID_SEARCH_JOBS = 6;
  private static final int METHODID_SEARCH_JOBS_FOR_ALERT = 7;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final JobServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(JobServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_JOB:
          serviceImpl.createJob(
              (com.google.cloud.talent.v4beta1.CreateJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Job>) responseObserver);
          break;
        case METHODID_GET_JOB:
          serviceImpl.getJob(
              (com.google.cloud.talent.v4beta1.GetJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Job>) responseObserver);
          break;
        case METHODID_UPDATE_JOB:
          serviceImpl.updateJob(
              (com.google.cloud.talent.v4beta1.UpdateJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Job>) responseObserver);
          break;
        case METHODID_DELETE_JOB:
          serviceImpl.deleteJob(
              (com.google.cloud.talent.v4beta1.DeleteJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_JOBS:
          serviceImpl.listJobs(
              (com.google.cloud.talent.v4beta1.ListJobsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.ListJobsResponse>)
                  responseObserver);
          break;
        case METHODID_BATCH_DELETE_JOBS:
          serviceImpl.batchDeleteJobs(
              (com.google.cloud.talent.v4beta1.BatchDeleteJobsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_SEARCH_JOBS:
          serviceImpl.searchJobs(
              (com.google.cloud.talent.v4beta1.SearchJobsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.SearchJobsResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_JOBS_FOR_ALERT:
          serviceImpl.searchJobsForAlert(
              (com.google.cloud.talent.v4beta1.SearchJobsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.SearchJobsResponse>)
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

  private abstract static class JobServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    JobServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.talent.v4beta1.JobServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("JobService");
    }
  }

  private static final class JobServiceFileDescriptorSupplier
      extends JobServiceBaseDescriptorSupplier {
    JobServiceFileDescriptorSupplier() {}
  }

  private static final class JobServiceMethodDescriptorSupplier
      extends JobServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    JobServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (JobServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new JobServiceFileDescriptorSupplier())
                      .addMethod(getCreateJobMethodHelper())
                      .addMethod(getGetJobMethodHelper())
                      .addMethod(getUpdateJobMethodHelper())
                      .addMethod(getDeleteJobMethodHelper())
                      .addMethod(getListJobsMethodHelper())
                      .addMethod(getBatchDeleteJobsMethodHelper())
                      .addMethod(getSearchJobsMethodHelper())
                      .addMethod(getSearchJobsForAlertMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
