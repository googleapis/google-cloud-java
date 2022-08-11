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
package com.google.cloud.talent.v4beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A service handles job management, including job CRUD, enumeration and search.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/talent/v4beta1/job_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class JobServiceGrpc {

  private JobServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.talent.v4beta1.JobService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.CreateJobRequest, com.google.cloud.talent.v4beta1.Job>
      getCreateJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateJob",
      requestType = com.google.cloud.talent.v4beta1.CreateJobRequest.class,
      responseType = com.google.cloud.talent.v4beta1.Job.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.CreateJobRequest, com.google.cloud.talent.v4beta1.Job>
      getCreateJobMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateJob"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.BatchCreateJobsRequest, com.google.longrunning.Operation>
      getBatchCreateJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchCreateJobs",
      requestType = com.google.cloud.talent.v4beta1.BatchCreateJobsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.BatchCreateJobsRequest, com.google.longrunning.Operation>
      getBatchCreateJobsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.BatchCreateJobsRequest,
            com.google.longrunning.Operation>
        getBatchCreateJobsMethod;
    if ((getBatchCreateJobsMethod = JobServiceGrpc.getBatchCreateJobsMethod) == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getBatchCreateJobsMethod = JobServiceGrpc.getBatchCreateJobsMethod) == null) {
          JobServiceGrpc.getBatchCreateJobsMethod =
              getBatchCreateJobsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.BatchCreateJobsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchCreateJobs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.BatchCreateJobsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new JobServiceMethodDescriptorSupplier("BatchCreateJobs"))
                      .build();
        }
      }
    }
    return getBatchCreateJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.GetJobRequest, com.google.cloud.talent.v4beta1.Job>
      getGetJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetJob",
      requestType = com.google.cloud.talent.v4beta1.GetJobRequest.class,
      responseType = com.google.cloud.talent.v4beta1.Job.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.GetJobRequest, com.google.cloud.talent.v4beta1.Job>
      getGetJobMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetJob"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.UpdateJobRequest, com.google.cloud.talent.v4beta1.Job>
      getUpdateJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateJob",
      requestType = com.google.cloud.talent.v4beta1.UpdateJobRequest.class,
      responseType = com.google.cloud.talent.v4beta1.Job.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.UpdateJobRequest, com.google.cloud.talent.v4beta1.Job>
      getUpdateJobMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateJob"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.BatchUpdateJobsRequest, com.google.longrunning.Operation>
      getBatchUpdateJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchUpdateJobs",
      requestType = com.google.cloud.talent.v4beta1.BatchUpdateJobsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.BatchUpdateJobsRequest, com.google.longrunning.Operation>
      getBatchUpdateJobsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.BatchUpdateJobsRequest,
            com.google.longrunning.Operation>
        getBatchUpdateJobsMethod;
    if ((getBatchUpdateJobsMethod = JobServiceGrpc.getBatchUpdateJobsMethod) == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getBatchUpdateJobsMethod = JobServiceGrpc.getBatchUpdateJobsMethod) == null) {
          JobServiceGrpc.getBatchUpdateJobsMethod =
              getBatchUpdateJobsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.BatchUpdateJobsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchUpdateJobs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.BatchUpdateJobsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new JobServiceMethodDescriptorSupplier("BatchUpdateJobs"))
                      .build();
        }
      }
    }
    return getBatchUpdateJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.DeleteJobRequest, com.google.protobuf.Empty>
      getDeleteJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteJob",
      requestType = com.google.cloud.talent.v4beta1.DeleteJobRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.DeleteJobRequest, com.google.protobuf.Empty>
      getDeleteJobMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteJob"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.BatchDeleteJobsRequest, com.google.protobuf.Empty>
      getBatchDeleteJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchDeleteJobs",
      requestType = com.google.cloud.talent.v4beta1.BatchDeleteJobsRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.BatchDeleteJobsRequest, com.google.protobuf.Empty>
      getBatchDeleteJobsMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchDeleteJobs"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.ListJobsRequest,
          com.google.cloud.talent.v4beta1.ListJobsResponse>
      getListJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListJobs",
      requestType = com.google.cloud.talent.v4beta1.ListJobsRequest.class,
      responseType = com.google.cloud.talent.v4beta1.ListJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.ListJobsRequest,
          com.google.cloud.talent.v4beta1.ListJobsResponse>
      getListJobsMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListJobs"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.SearchJobsRequest,
          com.google.cloud.talent.v4beta1.SearchJobsResponse>
      getSearchJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchJobs",
      requestType = com.google.cloud.talent.v4beta1.SearchJobsRequest.class,
      responseType = com.google.cloud.talent.v4beta1.SearchJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.SearchJobsRequest,
          com.google.cloud.talent.v4beta1.SearchJobsResponse>
      getSearchJobsMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchJobs"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.SearchJobsRequest,
          com.google.cloud.talent.v4beta1.SearchJobsResponse>
      getSearchJobsForAlertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchJobsForAlert",
      requestType = com.google.cloud.talent.v4beta1.SearchJobsRequest.class,
      responseType = com.google.cloud.talent.v4beta1.SearchJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.SearchJobsRequest,
          com.google.cloud.talent.v4beta1.SearchJobsResponse>
      getSearchJobsForAlertMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchJobsForAlert"))
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
    io.grpc.stub.AbstractStub.StubFactory<JobServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<JobServiceStub>() {
          @java.lang.Override
          public JobServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new JobServiceStub(channel, callOptions);
          }
        };
    return JobServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static JobServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JobServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<JobServiceBlockingStub>() {
          @java.lang.Override
          public JobServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new JobServiceBlockingStub(channel, callOptions);
          }
        };
    return JobServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static JobServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JobServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<JobServiceFutureStub>() {
          @java.lang.Override
          public JobServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new JobServiceFutureStub(channel, callOptions);
          }
        };
    return JobServiceFutureStub.newStub(factory, channel);
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
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Begins executing a batch create jobs operation.
     * </pre>
     */
    public void batchCreateJobs(
        com.google.cloud.talent.v4beta1.BatchCreateJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchCreateJobsMethod(), responseObserver);
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
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetJobMethod(), responseObserver);
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
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Begins executing a batch update jobs operation.
     * </pre>
     */
    public void batchUpdateJobs(
        com.google.cloud.talent.v4beta1.BatchUpdateJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchUpdateJobsMethod(), responseObserver);
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
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteJobMethod(), responseObserver);
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
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchDeleteJobsMethod(), responseObserver);
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
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListJobsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches for jobs using the provided [SearchJobsRequest][google.cloud.talent.v4beta1.SearchJobsRequest].
     * This call constrains the [visibility][google.cloud.talent.v4beta1.Job.visibility] of jobs
     * present in the database, and only returns jobs that the caller has
     * permission to search against.
     * </pre>
     */
    public void searchJobs(
        com.google.cloud.talent.v4beta1.SearchJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.SearchJobsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSearchJobsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches for jobs using the provided [SearchJobsRequest][google.cloud.talent.v4beta1.SearchJobsRequest].
     * This API call is intended for the use case of targeting passive job
     * seekers (for example, job seekers who have signed up to receive email
     * alerts about potential job opportunities), and has different algorithmic
     * adjustments that are targeted to passive job seekers.
     * This call constrains the [visibility][google.cloud.talent.v4beta1.Job.visibility] of jobs
     * present in the database, and only returns jobs the caller has
     * permission to search against.
     * </pre>
     */
    public void searchJobsForAlert(
        com.google.cloud.talent.v4beta1.SearchJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.SearchJobsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchJobsForAlertMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.CreateJobRequest,
                      com.google.cloud.talent.v4beta1.Job>(this, METHODID_CREATE_JOB)))
          .addMethod(
              getBatchCreateJobsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.BatchCreateJobsRequest,
                      com.google.longrunning.Operation>(this, METHODID_BATCH_CREATE_JOBS)))
          .addMethod(
              getGetJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.GetJobRequest,
                      com.google.cloud.talent.v4beta1.Job>(this, METHODID_GET_JOB)))
          .addMethod(
              getUpdateJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.UpdateJobRequest,
                      com.google.cloud.talent.v4beta1.Job>(this, METHODID_UPDATE_JOB)))
          .addMethod(
              getBatchUpdateJobsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.BatchUpdateJobsRequest,
                      com.google.longrunning.Operation>(this, METHODID_BATCH_UPDATE_JOBS)))
          .addMethod(
              getDeleteJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.DeleteJobRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_JOB)))
          .addMethod(
              getBatchDeleteJobsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.BatchDeleteJobsRequest,
                      com.google.protobuf.Empty>(this, METHODID_BATCH_DELETE_JOBS)))
          .addMethod(
              getListJobsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.ListJobsRequest,
                      com.google.cloud.talent.v4beta1.ListJobsResponse>(this, METHODID_LIST_JOBS)))
          .addMethod(
              getSearchJobsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.SearchJobsRequest,
                      com.google.cloud.talent.v4beta1.SearchJobsResponse>(
                      this, METHODID_SEARCH_JOBS)))
          .addMethod(
              getSearchJobsForAlertMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
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
  public static final class JobServiceStub extends io.grpc.stub.AbstractAsyncStub<JobServiceStub> {
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
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Begins executing a batch create jobs operation.
     * </pre>
     */
    public void batchCreateJobs(
        com.google.cloud.talent.v4beta1.BatchCreateJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchCreateJobsMethod(), getCallOptions()),
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
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetJobMethod(), getCallOptions()), request, responseObserver);
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
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Begins executing a batch update jobs operation.
     * </pre>
     */
    public void batchUpdateJobs(
        com.google.cloud.talent.v4beta1.BatchUpdateJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchUpdateJobsMethod(), getCallOptions()),
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
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteJobMethod(), getCallOptions()), request, responseObserver);
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
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchDeleteJobsMethod(), getCallOptions()),
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
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListJobsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches for jobs using the provided [SearchJobsRequest][google.cloud.talent.v4beta1.SearchJobsRequest].
     * This call constrains the [visibility][google.cloud.talent.v4beta1.Job.visibility] of jobs
     * present in the database, and only returns jobs that the caller has
     * permission to search against.
     * </pre>
     */
    public void searchJobs(
        com.google.cloud.talent.v4beta1.SearchJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.SearchJobsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchJobsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches for jobs using the provided [SearchJobsRequest][google.cloud.talent.v4beta1.SearchJobsRequest].
     * This API call is intended for the use case of targeting passive job
     * seekers (for example, job seekers who have signed up to receive email
     * alerts about potential job opportunities), and has different algorithmic
     * adjustments that are targeted to passive job seekers.
     * This call constrains the [visibility][google.cloud.talent.v4beta1.Job.visibility] of jobs
     * present in the database, and only returns jobs the caller has
     * permission to search against.
     * </pre>
     */
    public void searchJobsForAlert(
        com.google.cloud.talent.v4beta1.SearchJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.SearchJobsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchJobsForAlertMethod(), getCallOptions()),
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
      extends io.grpc.stub.AbstractBlockingStub<JobServiceBlockingStub> {
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
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Begins executing a batch create jobs operation.
     * </pre>
     */
    public com.google.longrunning.Operation batchCreateJobs(
        com.google.cloud.talent.v4beta1.BatchCreateJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchCreateJobsMethod(), getCallOptions(), request);
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
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetJobMethod(), getCallOptions(), request);
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
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Begins executing a batch update jobs operation.
     * </pre>
     */
    public com.google.longrunning.Operation batchUpdateJobs(
        com.google.cloud.talent.v4beta1.BatchUpdateJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchUpdateJobsMethod(), getCallOptions(), request);
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
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteJobMethod(), getCallOptions(), request);
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
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchDeleteJobsMethod(), getCallOptions(), request);
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
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListJobsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Searches for jobs using the provided [SearchJobsRequest][google.cloud.talent.v4beta1.SearchJobsRequest].
     * This call constrains the [visibility][google.cloud.talent.v4beta1.Job.visibility] of jobs
     * present in the database, and only returns jobs that the caller has
     * permission to search against.
     * </pre>
     */
    public com.google.cloud.talent.v4beta1.SearchJobsResponse searchJobs(
        com.google.cloud.talent.v4beta1.SearchJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchJobsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Searches for jobs using the provided [SearchJobsRequest][google.cloud.talent.v4beta1.SearchJobsRequest].
     * This API call is intended for the use case of targeting passive job
     * seekers (for example, job seekers who have signed up to receive email
     * alerts about potential job opportunities), and has different algorithmic
     * adjustments that are targeted to passive job seekers.
     * This call constrains the [visibility][google.cloud.talent.v4beta1.Job.visibility] of jobs
     * present in the database, and only returns jobs the caller has
     * permission to search against.
     * </pre>
     */
    public com.google.cloud.talent.v4beta1.SearchJobsResponse searchJobsForAlert(
        com.google.cloud.talent.v4beta1.SearchJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchJobsForAlertMethod(), getCallOptions(), request);
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
      extends io.grpc.stub.AbstractFutureStub<JobServiceFutureStub> {
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
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Begins executing a batch create jobs operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchCreateJobs(com.google.cloud.talent.v4beta1.BatchCreateJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchCreateJobsMethod(), getCallOptions()), request);
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
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetJobMethod(), getCallOptions()), request);
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
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Begins executing a batch update jobs operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchUpdateJobs(com.google.cloud.talent.v4beta1.BatchUpdateJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchUpdateJobsMethod(), getCallOptions()), request);
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
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteJobMethod(), getCallOptions()), request);
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
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchDeleteJobsMethod(), getCallOptions()), request);
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
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListJobsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Searches for jobs using the provided [SearchJobsRequest][google.cloud.talent.v4beta1.SearchJobsRequest].
     * This call constrains the [visibility][google.cloud.talent.v4beta1.Job.visibility] of jobs
     * present in the database, and only returns jobs that the caller has
     * permission to search against.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.talent.v4beta1.SearchJobsResponse>
        searchJobs(com.google.cloud.talent.v4beta1.SearchJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchJobsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Searches for jobs using the provided [SearchJobsRequest][google.cloud.talent.v4beta1.SearchJobsRequest].
     * This API call is intended for the use case of targeting passive job
     * seekers (for example, job seekers who have signed up to receive email
     * alerts about potential job opportunities), and has different algorithmic
     * adjustments that are targeted to passive job seekers.
     * This call constrains the [visibility][google.cloud.talent.v4beta1.Job.visibility] of jobs
     * present in the database, and only returns jobs the caller has
     * permission to search against.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.talent.v4beta1.SearchJobsResponse>
        searchJobsForAlert(com.google.cloud.talent.v4beta1.SearchJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchJobsForAlertMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_JOB = 0;
  private static final int METHODID_BATCH_CREATE_JOBS = 1;
  private static final int METHODID_GET_JOB = 2;
  private static final int METHODID_UPDATE_JOB = 3;
  private static final int METHODID_BATCH_UPDATE_JOBS = 4;
  private static final int METHODID_DELETE_JOB = 5;
  private static final int METHODID_BATCH_DELETE_JOBS = 6;
  private static final int METHODID_LIST_JOBS = 7;
  private static final int METHODID_SEARCH_JOBS = 8;
  private static final int METHODID_SEARCH_JOBS_FOR_ALERT = 9;

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
        case METHODID_BATCH_CREATE_JOBS:
          serviceImpl.batchCreateJobs(
              (com.google.cloud.talent.v4beta1.BatchCreateJobsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
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
        case METHODID_BATCH_UPDATE_JOBS:
          serviceImpl.batchUpdateJobs(
              (com.google.cloud.talent.v4beta1.BatchUpdateJobsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_JOB:
          serviceImpl.deleteJob(
              (com.google.cloud.talent.v4beta1.DeleteJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_BATCH_DELETE_JOBS:
          serviceImpl.batchDeleteJobs(
              (com.google.cloud.talent.v4beta1.BatchDeleteJobsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_JOBS:
          serviceImpl.listJobs(
              (com.google.cloud.talent.v4beta1.ListJobsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.ListJobsResponse>)
                  responseObserver);
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
                      .addMethod(getCreateJobMethod())
                      .addMethod(getBatchCreateJobsMethod())
                      .addMethod(getGetJobMethod())
                      .addMethod(getUpdateJobMethod())
                      .addMethod(getBatchUpdateJobsMethod())
                      .addMethod(getDeleteJobMethod())
                      .addMethod(getBatchDeleteJobsMethod())
                      .addMethod(getListJobsMethod())
                      .addMethod(getSearchJobsMethod())
                      .addMethod(getSearchJobsForAlertMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
