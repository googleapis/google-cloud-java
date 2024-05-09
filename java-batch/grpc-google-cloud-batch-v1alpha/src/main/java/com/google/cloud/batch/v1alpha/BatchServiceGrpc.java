/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.batch.v1alpha;

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
    comments = "Source: google/cloud/batch/v1alpha/batch.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BatchServiceGrpc {

  private BatchServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.batch.v1alpha.BatchService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1alpha.CreateJobRequest, com.google.cloud.batch.v1alpha.Job>
      getCreateJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateJob",
      requestType = com.google.cloud.batch.v1alpha.CreateJobRequest.class,
      responseType = com.google.cloud.batch.v1alpha.Job.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1alpha.CreateJobRequest, com.google.cloud.batch.v1alpha.Job>
      getCreateJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.batch.v1alpha.CreateJobRequest, com.google.cloud.batch.v1alpha.Job>
        getCreateJobMethod;
    if ((getCreateJobMethod = BatchServiceGrpc.getCreateJobMethod) == null) {
      synchronized (BatchServiceGrpc.class) {
        if ((getCreateJobMethod = BatchServiceGrpc.getCreateJobMethod) == null) {
          BatchServiceGrpc.getCreateJobMethod =
              getCreateJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.batch.v1alpha.CreateJobRequest,
                          com.google.cloud.batch.v1alpha.Job>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.batch.v1alpha.CreateJobRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.batch.v1alpha.Job.getDefaultInstance()))
                      .setSchemaDescriptor(new BatchServiceMethodDescriptorSupplier("CreateJob"))
                      .build();
        }
      }
    }
    return getCreateJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1alpha.GetJobRequest, com.google.cloud.batch.v1alpha.Job>
      getGetJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetJob",
      requestType = com.google.cloud.batch.v1alpha.GetJobRequest.class,
      responseType = com.google.cloud.batch.v1alpha.Job.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1alpha.GetJobRequest, com.google.cloud.batch.v1alpha.Job>
      getGetJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.batch.v1alpha.GetJobRequest, com.google.cloud.batch.v1alpha.Job>
        getGetJobMethod;
    if ((getGetJobMethod = BatchServiceGrpc.getGetJobMethod) == null) {
      synchronized (BatchServiceGrpc.class) {
        if ((getGetJobMethod = BatchServiceGrpc.getGetJobMethod) == null) {
          BatchServiceGrpc.getGetJobMethod =
              getGetJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.batch.v1alpha.GetJobRequest,
                          com.google.cloud.batch.v1alpha.Job>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.batch.v1alpha.GetJobRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.batch.v1alpha.Job.getDefaultInstance()))
                      .setSchemaDescriptor(new BatchServiceMethodDescriptorSupplier("GetJob"))
                      .build();
        }
      }
    }
    return getGetJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1alpha.DeleteJobRequest, com.google.longrunning.Operation>
      getDeleteJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteJob",
      requestType = com.google.cloud.batch.v1alpha.DeleteJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1alpha.DeleteJobRequest, com.google.longrunning.Operation>
      getDeleteJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.batch.v1alpha.DeleteJobRequest, com.google.longrunning.Operation>
        getDeleteJobMethod;
    if ((getDeleteJobMethod = BatchServiceGrpc.getDeleteJobMethod) == null) {
      synchronized (BatchServiceGrpc.class) {
        if ((getDeleteJobMethod = BatchServiceGrpc.getDeleteJobMethod) == null) {
          BatchServiceGrpc.getDeleteJobMethod =
              getDeleteJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.batch.v1alpha.DeleteJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.batch.v1alpha.DeleteJobRequest.getDefaultInstance()))
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
          com.google.cloud.batch.v1alpha.UpdateJobRequest, com.google.cloud.batch.v1alpha.Job>
      getUpdateJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateJob",
      requestType = com.google.cloud.batch.v1alpha.UpdateJobRequest.class,
      responseType = com.google.cloud.batch.v1alpha.Job.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1alpha.UpdateJobRequest, com.google.cloud.batch.v1alpha.Job>
      getUpdateJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.batch.v1alpha.UpdateJobRequest, com.google.cloud.batch.v1alpha.Job>
        getUpdateJobMethod;
    if ((getUpdateJobMethod = BatchServiceGrpc.getUpdateJobMethod) == null) {
      synchronized (BatchServiceGrpc.class) {
        if ((getUpdateJobMethod = BatchServiceGrpc.getUpdateJobMethod) == null) {
          BatchServiceGrpc.getUpdateJobMethod =
              getUpdateJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.batch.v1alpha.UpdateJobRequest,
                          com.google.cloud.batch.v1alpha.Job>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.batch.v1alpha.UpdateJobRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.batch.v1alpha.Job.getDefaultInstance()))
                      .setSchemaDescriptor(new BatchServiceMethodDescriptorSupplier("UpdateJob"))
                      .build();
        }
      }
    }
    return getUpdateJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1alpha.ListJobsRequest,
          com.google.cloud.batch.v1alpha.ListJobsResponse>
      getListJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListJobs",
      requestType = com.google.cloud.batch.v1alpha.ListJobsRequest.class,
      responseType = com.google.cloud.batch.v1alpha.ListJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1alpha.ListJobsRequest,
          com.google.cloud.batch.v1alpha.ListJobsResponse>
      getListJobsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.batch.v1alpha.ListJobsRequest,
            com.google.cloud.batch.v1alpha.ListJobsResponse>
        getListJobsMethod;
    if ((getListJobsMethod = BatchServiceGrpc.getListJobsMethod) == null) {
      synchronized (BatchServiceGrpc.class) {
        if ((getListJobsMethod = BatchServiceGrpc.getListJobsMethod) == null) {
          BatchServiceGrpc.getListJobsMethod =
              getListJobsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.batch.v1alpha.ListJobsRequest,
                          com.google.cloud.batch.v1alpha.ListJobsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListJobs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.batch.v1alpha.ListJobsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.batch.v1alpha.ListJobsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new BatchServiceMethodDescriptorSupplier("ListJobs"))
                      .build();
        }
      }
    }
    return getListJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1alpha.GetTaskRequest, com.google.cloud.batch.v1alpha.Task>
      getGetTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTask",
      requestType = com.google.cloud.batch.v1alpha.GetTaskRequest.class,
      responseType = com.google.cloud.batch.v1alpha.Task.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1alpha.GetTaskRequest, com.google.cloud.batch.v1alpha.Task>
      getGetTaskMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.batch.v1alpha.GetTaskRequest, com.google.cloud.batch.v1alpha.Task>
        getGetTaskMethod;
    if ((getGetTaskMethod = BatchServiceGrpc.getGetTaskMethod) == null) {
      synchronized (BatchServiceGrpc.class) {
        if ((getGetTaskMethod = BatchServiceGrpc.getGetTaskMethod) == null) {
          BatchServiceGrpc.getGetTaskMethod =
              getGetTaskMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.batch.v1alpha.GetTaskRequest,
                          com.google.cloud.batch.v1alpha.Task>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTask"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.batch.v1alpha.GetTaskRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.batch.v1alpha.Task.getDefaultInstance()))
                      .setSchemaDescriptor(new BatchServiceMethodDescriptorSupplier("GetTask"))
                      .build();
        }
      }
    }
    return getGetTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1alpha.ListTasksRequest,
          com.google.cloud.batch.v1alpha.ListTasksResponse>
      getListTasksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTasks",
      requestType = com.google.cloud.batch.v1alpha.ListTasksRequest.class,
      responseType = com.google.cloud.batch.v1alpha.ListTasksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1alpha.ListTasksRequest,
          com.google.cloud.batch.v1alpha.ListTasksResponse>
      getListTasksMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.batch.v1alpha.ListTasksRequest,
            com.google.cloud.batch.v1alpha.ListTasksResponse>
        getListTasksMethod;
    if ((getListTasksMethod = BatchServiceGrpc.getListTasksMethod) == null) {
      synchronized (BatchServiceGrpc.class) {
        if ((getListTasksMethod = BatchServiceGrpc.getListTasksMethod) == null) {
          BatchServiceGrpc.getListTasksMethod =
              getListTasksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.batch.v1alpha.ListTasksRequest,
                          com.google.cloud.batch.v1alpha.ListTasksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTasks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.batch.v1alpha.ListTasksRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.batch.v1alpha.ListTasksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new BatchServiceMethodDescriptorSupplier("ListTasks"))
                      .build();
        }
      }
    }
    return getListTasksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1alpha.CreateResourceAllowanceRequest,
          com.google.cloud.batch.v1alpha.ResourceAllowance>
      getCreateResourceAllowanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateResourceAllowance",
      requestType = com.google.cloud.batch.v1alpha.CreateResourceAllowanceRequest.class,
      responseType = com.google.cloud.batch.v1alpha.ResourceAllowance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1alpha.CreateResourceAllowanceRequest,
          com.google.cloud.batch.v1alpha.ResourceAllowance>
      getCreateResourceAllowanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.batch.v1alpha.CreateResourceAllowanceRequest,
            com.google.cloud.batch.v1alpha.ResourceAllowance>
        getCreateResourceAllowanceMethod;
    if ((getCreateResourceAllowanceMethod = BatchServiceGrpc.getCreateResourceAllowanceMethod)
        == null) {
      synchronized (BatchServiceGrpc.class) {
        if ((getCreateResourceAllowanceMethod = BatchServiceGrpc.getCreateResourceAllowanceMethod)
            == null) {
          BatchServiceGrpc.getCreateResourceAllowanceMethod =
              getCreateResourceAllowanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.batch.v1alpha.CreateResourceAllowanceRequest,
                          com.google.cloud.batch.v1alpha.ResourceAllowance>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateResourceAllowance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.batch.v1alpha.CreateResourceAllowanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.batch.v1alpha.ResourceAllowance
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BatchServiceMethodDescriptorSupplier("CreateResourceAllowance"))
                      .build();
        }
      }
    }
    return getCreateResourceAllowanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1alpha.GetResourceAllowanceRequest,
          com.google.cloud.batch.v1alpha.ResourceAllowance>
      getGetResourceAllowanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetResourceAllowance",
      requestType = com.google.cloud.batch.v1alpha.GetResourceAllowanceRequest.class,
      responseType = com.google.cloud.batch.v1alpha.ResourceAllowance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1alpha.GetResourceAllowanceRequest,
          com.google.cloud.batch.v1alpha.ResourceAllowance>
      getGetResourceAllowanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.batch.v1alpha.GetResourceAllowanceRequest,
            com.google.cloud.batch.v1alpha.ResourceAllowance>
        getGetResourceAllowanceMethod;
    if ((getGetResourceAllowanceMethod = BatchServiceGrpc.getGetResourceAllowanceMethod) == null) {
      synchronized (BatchServiceGrpc.class) {
        if ((getGetResourceAllowanceMethod = BatchServiceGrpc.getGetResourceAllowanceMethod)
            == null) {
          BatchServiceGrpc.getGetResourceAllowanceMethod =
              getGetResourceAllowanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.batch.v1alpha.GetResourceAllowanceRequest,
                          com.google.cloud.batch.v1alpha.ResourceAllowance>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetResourceAllowance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.batch.v1alpha.GetResourceAllowanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.batch.v1alpha.ResourceAllowance
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BatchServiceMethodDescriptorSupplier("GetResourceAllowance"))
                      .build();
        }
      }
    }
    return getGetResourceAllowanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1alpha.DeleteResourceAllowanceRequest,
          com.google.longrunning.Operation>
      getDeleteResourceAllowanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteResourceAllowance",
      requestType = com.google.cloud.batch.v1alpha.DeleteResourceAllowanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1alpha.DeleteResourceAllowanceRequest,
          com.google.longrunning.Operation>
      getDeleteResourceAllowanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.batch.v1alpha.DeleteResourceAllowanceRequest,
            com.google.longrunning.Operation>
        getDeleteResourceAllowanceMethod;
    if ((getDeleteResourceAllowanceMethod = BatchServiceGrpc.getDeleteResourceAllowanceMethod)
        == null) {
      synchronized (BatchServiceGrpc.class) {
        if ((getDeleteResourceAllowanceMethod = BatchServiceGrpc.getDeleteResourceAllowanceMethod)
            == null) {
          BatchServiceGrpc.getDeleteResourceAllowanceMethod =
              getDeleteResourceAllowanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.batch.v1alpha.DeleteResourceAllowanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteResourceAllowance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.batch.v1alpha.DeleteResourceAllowanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BatchServiceMethodDescriptorSupplier("DeleteResourceAllowance"))
                      .build();
        }
      }
    }
    return getDeleteResourceAllowanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1alpha.ListResourceAllowancesRequest,
          com.google.cloud.batch.v1alpha.ListResourceAllowancesResponse>
      getListResourceAllowancesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListResourceAllowances",
      requestType = com.google.cloud.batch.v1alpha.ListResourceAllowancesRequest.class,
      responseType = com.google.cloud.batch.v1alpha.ListResourceAllowancesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1alpha.ListResourceAllowancesRequest,
          com.google.cloud.batch.v1alpha.ListResourceAllowancesResponse>
      getListResourceAllowancesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.batch.v1alpha.ListResourceAllowancesRequest,
            com.google.cloud.batch.v1alpha.ListResourceAllowancesResponse>
        getListResourceAllowancesMethod;
    if ((getListResourceAllowancesMethod = BatchServiceGrpc.getListResourceAllowancesMethod)
        == null) {
      synchronized (BatchServiceGrpc.class) {
        if ((getListResourceAllowancesMethod = BatchServiceGrpc.getListResourceAllowancesMethod)
            == null) {
          BatchServiceGrpc.getListResourceAllowancesMethod =
              getListResourceAllowancesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.batch.v1alpha.ListResourceAllowancesRequest,
                          com.google.cloud.batch.v1alpha.ListResourceAllowancesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListResourceAllowances"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.batch.v1alpha.ListResourceAllowancesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.batch.v1alpha.ListResourceAllowancesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BatchServiceMethodDescriptorSupplier("ListResourceAllowances"))
                      .build();
        }
      }
    }
    return getListResourceAllowancesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1alpha.UpdateResourceAllowanceRequest,
          com.google.cloud.batch.v1alpha.ResourceAllowance>
      getUpdateResourceAllowanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateResourceAllowance",
      requestType = com.google.cloud.batch.v1alpha.UpdateResourceAllowanceRequest.class,
      responseType = com.google.cloud.batch.v1alpha.ResourceAllowance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.batch.v1alpha.UpdateResourceAllowanceRequest,
          com.google.cloud.batch.v1alpha.ResourceAllowance>
      getUpdateResourceAllowanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.batch.v1alpha.UpdateResourceAllowanceRequest,
            com.google.cloud.batch.v1alpha.ResourceAllowance>
        getUpdateResourceAllowanceMethod;
    if ((getUpdateResourceAllowanceMethod = BatchServiceGrpc.getUpdateResourceAllowanceMethod)
        == null) {
      synchronized (BatchServiceGrpc.class) {
        if ((getUpdateResourceAllowanceMethod = BatchServiceGrpc.getUpdateResourceAllowanceMethod)
            == null) {
          BatchServiceGrpc.getUpdateResourceAllowanceMethod =
              getUpdateResourceAllowanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.batch.v1alpha.UpdateResourceAllowanceRequest,
                          com.google.cloud.batch.v1alpha.ResourceAllowance>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateResourceAllowance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.batch.v1alpha.UpdateResourceAllowanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.batch.v1alpha.ResourceAllowance
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BatchServiceMethodDescriptorSupplier("UpdateResourceAllowance"))
                      .build();
        }
      }
    }
    return getUpdateResourceAllowanceMethod;
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
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Create a Job.
     * </pre>
     */
    default void createJob(
        com.google.cloud.batch.v1alpha.CreateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.batch.v1alpha.Job> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a Job specified by its resource name.
     * </pre>
     */
    default void getJob(
        com.google.cloud.batch.v1alpha.GetJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.batch.v1alpha.Job> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a Job.
     * </pre>
     */
    default void deleteJob(
        com.google.cloud.batch.v1alpha.DeleteJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a Job.
     * </pre>
     */
    default void updateJob(
        com.google.cloud.batch.v1alpha.UpdateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.batch.v1alpha.Job> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all Jobs for a project within a region.
     * </pre>
     */
    default void listJobs(
        com.google.cloud.batch.v1alpha.ListJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.batch.v1alpha.ListJobsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListJobsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Return a single Task.
     * </pre>
     */
    default void getTask(
        com.google.cloud.batch.v1alpha.GetTaskRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.batch.v1alpha.Task> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTaskMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List Tasks associated with a job.
     * </pre>
     */
    default void listTasks(
        com.google.cloud.batch.v1alpha.ListTasksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.batch.v1alpha.ListTasksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListTasksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a Resource Allowance.
     * </pre>
     */
    default void createResourceAllowance(
        com.google.cloud.batch.v1alpha.CreateResourceAllowanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.batch.v1alpha.ResourceAllowance>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateResourceAllowanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a ResourceAllowance specified by its resource name.
     * </pre>
     */
    default void getResourceAllowance(
        com.google.cloud.batch.v1alpha.GetResourceAllowanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.batch.v1alpha.ResourceAllowance>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetResourceAllowanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a ResourceAllowance.
     * </pre>
     */
    default void deleteResourceAllowance(
        com.google.cloud.batch.v1alpha.DeleteResourceAllowanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteResourceAllowanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all ResourceAllowances for a project within a region.
     * </pre>
     */
    default void listResourceAllowances(
        com.google.cloud.batch.v1alpha.ListResourceAllowancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.batch.v1alpha.ListResourceAllowancesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListResourceAllowancesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a Resource Allowance.
     * </pre>
     */
    default void updateResourceAllowance(
        com.google.cloud.batch.v1alpha.UpdateResourceAllowanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.batch.v1alpha.ResourceAllowance>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateResourceAllowanceMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service BatchService.
   *
   * <pre>
   * Google Batch Service.
   * The service manages user submitted batch jobs and allocates Google Compute
   * Engine VM instances to run the jobs.
   * </pre>
   */
  public abstract static class BatchServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return BatchServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service BatchService.
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
        com.google.cloud.batch.v1alpha.CreateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.batch.v1alpha.Job> responseObserver) {
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
        com.google.cloud.batch.v1alpha.GetJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.batch.v1alpha.Job> responseObserver) {
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
        com.google.cloud.batch.v1alpha.DeleteJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a Job.
     * </pre>
     */
    public void updateJob(
        com.google.cloud.batch.v1alpha.UpdateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.batch.v1alpha.Job> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all Jobs for a project within a region.
     * </pre>
     */
    public void listJobs(
        com.google.cloud.batch.v1alpha.ListJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.batch.v1alpha.ListJobsResponse>
            responseObserver) {
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
        com.google.cloud.batch.v1alpha.GetTaskRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.batch.v1alpha.Task> responseObserver) {
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
        com.google.cloud.batch.v1alpha.ListTasksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.batch.v1alpha.ListTasksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTasksMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a Resource Allowance.
     * </pre>
     */
    public void createResourceAllowance(
        com.google.cloud.batch.v1alpha.CreateResourceAllowanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.batch.v1alpha.ResourceAllowance>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateResourceAllowanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a ResourceAllowance specified by its resource name.
     * </pre>
     */
    public void getResourceAllowance(
        com.google.cloud.batch.v1alpha.GetResourceAllowanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.batch.v1alpha.ResourceAllowance>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetResourceAllowanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a ResourceAllowance.
     * </pre>
     */
    public void deleteResourceAllowance(
        com.google.cloud.batch.v1alpha.DeleteResourceAllowanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteResourceAllowanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all ResourceAllowances for a project within a region.
     * </pre>
     */
    public void listResourceAllowances(
        com.google.cloud.batch.v1alpha.ListResourceAllowancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.batch.v1alpha.ListResourceAllowancesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListResourceAllowancesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a Resource Allowance.
     * </pre>
     */
    public void updateResourceAllowance(
        com.google.cloud.batch.v1alpha.UpdateResourceAllowanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.batch.v1alpha.ResourceAllowance>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateResourceAllowanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service BatchService.
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
    public com.google.cloud.batch.v1alpha.Job createJob(
        com.google.cloud.batch.v1alpha.CreateJobRequest request) {
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
    public com.google.cloud.batch.v1alpha.Job getJob(
        com.google.cloud.batch.v1alpha.GetJobRequest request) {
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
        com.google.cloud.batch.v1alpha.DeleteJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a Job.
     * </pre>
     */
    public com.google.cloud.batch.v1alpha.Job updateJob(
        com.google.cloud.batch.v1alpha.UpdateJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all Jobs for a project within a region.
     * </pre>
     */
    public com.google.cloud.batch.v1alpha.ListJobsResponse listJobs(
        com.google.cloud.batch.v1alpha.ListJobsRequest request) {
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
    public com.google.cloud.batch.v1alpha.Task getTask(
        com.google.cloud.batch.v1alpha.GetTaskRequest request) {
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
    public com.google.cloud.batch.v1alpha.ListTasksResponse listTasks(
        com.google.cloud.batch.v1alpha.ListTasksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTasksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a Resource Allowance.
     * </pre>
     */
    public com.google.cloud.batch.v1alpha.ResourceAllowance createResourceAllowance(
        com.google.cloud.batch.v1alpha.CreateResourceAllowanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateResourceAllowanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a ResourceAllowance specified by its resource name.
     * </pre>
     */
    public com.google.cloud.batch.v1alpha.ResourceAllowance getResourceAllowance(
        com.google.cloud.batch.v1alpha.GetResourceAllowanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetResourceAllowanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a ResourceAllowance.
     * </pre>
     */
    public com.google.longrunning.Operation deleteResourceAllowance(
        com.google.cloud.batch.v1alpha.DeleteResourceAllowanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteResourceAllowanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all ResourceAllowances for a project within a region.
     * </pre>
     */
    public com.google.cloud.batch.v1alpha.ListResourceAllowancesResponse listResourceAllowances(
        com.google.cloud.batch.v1alpha.ListResourceAllowancesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListResourceAllowancesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a Resource Allowance.
     * </pre>
     */
    public com.google.cloud.batch.v1alpha.ResourceAllowance updateResourceAllowance(
        com.google.cloud.batch.v1alpha.UpdateResourceAllowanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateResourceAllowanceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service BatchService.
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
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.batch.v1alpha.Job>
        createJob(com.google.cloud.batch.v1alpha.CreateJobRequest request) {
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
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.batch.v1alpha.Job>
        getJob(com.google.cloud.batch.v1alpha.GetJobRequest request) {
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
        deleteJob(com.google.cloud.batch.v1alpha.DeleteJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a Job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.batch.v1alpha.Job>
        updateJob(com.google.cloud.batch.v1alpha.UpdateJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List all Jobs for a project within a region.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.batch.v1alpha.ListJobsResponse>
        listJobs(com.google.cloud.batch.v1alpha.ListJobsRequest request) {
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
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.batch.v1alpha.Task>
        getTask(com.google.cloud.batch.v1alpha.GetTaskRequest request) {
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
            com.google.cloud.batch.v1alpha.ListTasksResponse>
        listTasks(com.google.cloud.batch.v1alpha.ListTasksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTasksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a Resource Allowance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.batch.v1alpha.ResourceAllowance>
        createResourceAllowance(
            com.google.cloud.batch.v1alpha.CreateResourceAllowanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateResourceAllowanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get a ResourceAllowance specified by its resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.batch.v1alpha.ResourceAllowance>
        getResourceAllowance(com.google.cloud.batch.v1alpha.GetResourceAllowanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetResourceAllowanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a ResourceAllowance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteResourceAllowance(
            com.google.cloud.batch.v1alpha.DeleteResourceAllowanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteResourceAllowanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List all ResourceAllowances for a project within a region.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.batch.v1alpha.ListResourceAllowancesResponse>
        listResourceAllowances(
            com.google.cloud.batch.v1alpha.ListResourceAllowancesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListResourceAllowancesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a Resource Allowance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.batch.v1alpha.ResourceAllowance>
        updateResourceAllowance(
            com.google.cloud.batch.v1alpha.UpdateResourceAllowanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateResourceAllowanceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_JOB = 0;
  private static final int METHODID_GET_JOB = 1;
  private static final int METHODID_DELETE_JOB = 2;
  private static final int METHODID_UPDATE_JOB = 3;
  private static final int METHODID_LIST_JOBS = 4;
  private static final int METHODID_GET_TASK = 5;
  private static final int METHODID_LIST_TASKS = 6;
  private static final int METHODID_CREATE_RESOURCE_ALLOWANCE = 7;
  private static final int METHODID_GET_RESOURCE_ALLOWANCE = 8;
  private static final int METHODID_DELETE_RESOURCE_ALLOWANCE = 9;
  private static final int METHODID_LIST_RESOURCE_ALLOWANCES = 10;
  private static final int METHODID_UPDATE_RESOURCE_ALLOWANCE = 11;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_JOB:
          serviceImpl.createJob(
              (com.google.cloud.batch.v1alpha.CreateJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.batch.v1alpha.Job>) responseObserver);
          break;
        case METHODID_GET_JOB:
          serviceImpl.getJob(
              (com.google.cloud.batch.v1alpha.GetJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.batch.v1alpha.Job>) responseObserver);
          break;
        case METHODID_DELETE_JOB:
          serviceImpl.deleteJob(
              (com.google.cloud.batch.v1alpha.DeleteJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_JOB:
          serviceImpl.updateJob(
              (com.google.cloud.batch.v1alpha.UpdateJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.batch.v1alpha.Job>) responseObserver);
          break;
        case METHODID_LIST_JOBS:
          serviceImpl.listJobs(
              (com.google.cloud.batch.v1alpha.ListJobsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.batch.v1alpha.ListJobsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_TASK:
          serviceImpl.getTask(
              (com.google.cloud.batch.v1alpha.GetTaskRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.batch.v1alpha.Task>) responseObserver);
          break;
        case METHODID_LIST_TASKS:
          serviceImpl.listTasks(
              (com.google.cloud.batch.v1alpha.ListTasksRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.batch.v1alpha.ListTasksResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_RESOURCE_ALLOWANCE:
          serviceImpl.createResourceAllowance(
              (com.google.cloud.batch.v1alpha.CreateResourceAllowanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.batch.v1alpha.ResourceAllowance>)
                  responseObserver);
          break;
        case METHODID_GET_RESOURCE_ALLOWANCE:
          serviceImpl.getResourceAllowance(
              (com.google.cloud.batch.v1alpha.GetResourceAllowanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.batch.v1alpha.ResourceAllowance>)
                  responseObserver);
          break;
        case METHODID_DELETE_RESOURCE_ALLOWANCE:
          serviceImpl.deleteResourceAllowance(
              (com.google.cloud.batch.v1alpha.DeleteResourceAllowanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_RESOURCE_ALLOWANCES:
          serviceImpl.listResourceAllowances(
              (com.google.cloud.batch.v1alpha.ListResourceAllowancesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.batch.v1alpha.ListResourceAllowancesResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_RESOURCE_ALLOWANCE:
          serviceImpl.updateResourceAllowance(
              (com.google.cloud.batch.v1alpha.UpdateResourceAllowanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.batch.v1alpha.ResourceAllowance>)
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getCreateJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.batch.v1alpha.CreateJobRequest,
                    com.google.cloud.batch.v1alpha.Job>(service, METHODID_CREATE_JOB)))
        .addMethod(
            getGetJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.batch.v1alpha.GetJobRequest,
                    com.google.cloud.batch.v1alpha.Job>(service, METHODID_GET_JOB)))
        .addMethod(
            getDeleteJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.batch.v1alpha.DeleteJobRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_JOB)))
        .addMethod(
            getUpdateJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.batch.v1alpha.UpdateJobRequest,
                    com.google.cloud.batch.v1alpha.Job>(service, METHODID_UPDATE_JOB)))
        .addMethod(
            getListJobsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.batch.v1alpha.ListJobsRequest,
                    com.google.cloud.batch.v1alpha.ListJobsResponse>(service, METHODID_LIST_JOBS)))
        .addMethod(
            getGetTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.batch.v1alpha.GetTaskRequest,
                    com.google.cloud.batch.v1alpha.Task>(service, METHODID_GET_TASK)))
        .addMethod(
            getListTasksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.batch.v1alpha.ListTasksRequest,
                    com.google.cloud.batch.v1alpha.ListTasksResponse>(
                    service, METHODID_LIST_TASKS)))
        .addMethod(
            getCreateResourceAllowanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.batch.v1alpha.CreateResourceAllowanceRequest,
                    com.google.cloud.batch.v1alpha.ResourceAllowance>(
                    service, METHODID_CREATE_RESOURCE_ALLOWANCE)))
        .addMethod(
            getGetResourceAllowanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.batch.v1alpha.GetResourceAllowanceRequest,
                    com.google.cloud.batch.v1alpha.ResourceAllowance>(
                    service, METHODID_GET_RESOURCE_ALLOWANCE)))
        .addMethod(
            getDeleteResourceAllowanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.batch.v1alpha.DeleteResourceAllowanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_RESOURCE_ALLOWANCE)))
        .addMethod(
            getListResourceAllowancesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.batch.v1alpha.ListResourceAllowancesRequest,
                    com.google.cloud.batch.v1alpha.ListResourceAllowancesResponse>(
                    service, METHODID_LIST_RESOURCE_ALLOWANCES)))
        .addMethod(
            getUpdateResourceAllowanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.batch.v1alpha.UpdateResourceAllowanceRequest,
                    com.google.cloud.batch.v1alpha.ResourceAllowance>(
                    service, METHODID_UPDATE_RESOURCE_ALLOWANCE)))
        .build();
  }

  private abstract static class BatchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BatchServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.batch.v1alpha.BatchProto.getDescriptor();
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
    private final java.lang.String methodName;

    BatchServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
                      .addMethod(getUpdateJobMethod())
                      .addMethod(getListJobsMethod())
                      .addMethod(getGetTaskMethod())
                      .addMethod(getListTasksMethod())
                      .addMethod(getCreateResourceAllowanceMethod())
                      .addMethod(getGetResourceAllowanceMethod())
                      .addMethod(getDeleteResourceAllowanceMethod())
                      .addMethod(getListResourceAllowancesMethod())
                      .addMethod(getUpdateResourceAllowanceMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
