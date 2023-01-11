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
package com.google.cloud.aiplatform.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A service for creating and managing Vertex AI's jobs.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1beta1/job_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class JobServiceGrpc {

  private JobServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.aiplatform.v1beta1.JobService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateCustomJobRequest,
          com.google.cloud.aiplatform.v1beta1.CustomJob>
      getCreateCustomJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCustomJob",
      requestType = com.google.cloud.aiplatform.v1beta1.CreateCustomJobRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.CustomJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateCustomJobRequest,
          com.google.cloud.aiplatform.v1beta1.CustomJob>
      getCreateCustomJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.CreateCustomJobRequest,
            com.google.cloud.aiplatform.v1beta1.CustomJob>
        getCreateCustomJobMethod;
    if ((getCreateCustomJobMethod = JobServiceGrpc.getCreateCustomJobMethod) == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getCreateCustomJobMethod = JobServiceGrpc.getCreateCustomJobMethod) == null) {
          JobServiceGrpc.getCreateCustomJobMethod =
              getCreateCustomJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.CreateCustomJobRequest,
                          com.google.cloud.aiplatform.v1beta1.CustomJob>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCustomJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.CreateCustomJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.CustomJob.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new JobServiceMethodDescriptorSupplier("CreateCustomJob"))
                      .build();
        }
      }
    }
    return getCreateCustomJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetCustomJobRequest,
          com.google.cloud.aiplatform.v1beta1.CustomJob>
      getGetCustomJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCustomJob",
      requestType = com.google.cloud.aiplatform.v1beta1.GetCustomJobRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.CustomJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetCustomJobRequest,
          com.google.cloud.aiplatform.v1beta1.CustomJob>
      getGetCustomJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetCustomJobRequest,
            com.google.cloud.aiplatform.v1beta1.CustomJob>
        getGetCustomJobMethod;
    if ((getGetCustomJobMethod = JobServiceGrpc.getGetCustomJobMethod) == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getGetCustomJobMethod = JobServiceGrpc.getGetCustomJobMethod) == null) {
          JobServiceGrpc.getGetCustomJobMethod =
              getGetCustomJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GetCustomJobRequest,
                          com.google.cloud.aiplatform.v1beta1.CustomJob>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCustomJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.GetCustomJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.CustomJob.getDefaultInstance()))
                      .setSchemaDescriptor(new JobServiceMethodDescriptorSupplier("GetCustomJob"))
                      .build();
        }
      }
    }
    return getGetCustomJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListCustomJobsRequest,
          com.google.cloud.aiplatform.v1beta1.ListCustomJobsResponse>
      getListCustomJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCustomJobs",
      requestType = com.google.cloud.aiplatform.v1beta1.ListCustomJobsRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListCustomJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListCustomJobsRequest,
          com.google.cloud.aiplatform.v1beta1.ListCustomJobsResponse>
      getListCustomJobsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListCustomJobsRequest,
            com.google.cloud.aiplatform.v1beta1.ListCustomJobsResponse>
        getListCustomJobsMethod;
    if ((getListCustomJobsMethod = JobServiceGrpc.getListCustomJobsMethod) == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getListCustomJobsMethod = JobServiceGrpc.getListCustomJobsMethod) == null) {
          JobServiceGrpc.getListCustomJobsMethod =
              getListCustomJobsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ListCustomJobsRequest,
                          com.google.cloud.aiplatform.v1beta1.ListCustomJobsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCustomJobs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListCustomJobsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListCustomJobsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new JobServiceMethodDescriptorSupplier("ListCustomJobs"))
                      .build();
        }
      }
    }
    return getListCustomJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteCustomJobRequest,
          com.google.longrunning.Operation>
      getDeleteCustomJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCustomJob",
      requestType = com.google.cloud.aiplatform.v1beta1.DeleteCustomJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteCustomJobRequest,
          com.google.longrunning.Operation>
      getDeleteCustomJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeleteCustomJobRequest,
            com.google.longrunning.Operation>
        getDeleteCustomJobMethod;
    if ((getDeleteCustomJobMethod = JobServiceGrpc.getDeleteCustomJobMethod) == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getDeleteCustomJobMethod = JobServiceGrpc.getDeleteCustomJobMethod) == null) {
          JobServiceGrpc.getDeleteCustomJobMethod =
              getDeleteCustomJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.DeleteCustomJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCustomJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.DeleteCustomJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new JobServiceMethodDescriptorSupplier("DeleteCustomJob"))
                      .build();
        }
      }
    }
    return getDeleteCustomJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CancelCustomJobRequest, com.google.protobuf.Empty>
      getCancelCustomJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelCustomJob",
      requestType = com.google.cloud.aiplatform.v1beta1.CancelCustomJobRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CancelCustomJobRequest, com.google.protobuf.Empty>
      getCancelCustomJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.CancelCustomJobRequest, com.google.protobuf.Empty>
        getCancelCustomJobMethod;
    if ((getCancelCustomJobMethod = JobServiceGrpc.getCancelCustomJobMethod) == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getCancelCustomJobMethod = JobServiceGrpc.getCancelCustomJobMethod) == null) {
          JobServiceGrpc.getCancelCustomJobMethod =
              getCancelCustomJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.CancelCustomJobRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CancelCustomJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.CancelCustomJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new JobServiceMethodDescriptorSupplier("CancelCustomJob"))
                      .build();
        }
      }
    }
    return getCancelCustomJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateDataLabelingJobRequest,
          com.google.cloud.aiplatform.v1beta1.DataLabelingJob>
      getCreateDataLabelingJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDataLabelingJob",
      requestType = com.google.cloud.aiplatform.v1beta1.CreateDataLabelingJobRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.DataLabelingJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateDataLabelingJobRequest,
          com.google.cloud.aiplatform.v1beta1.DataLabelingJob>
      getCreateDataLabelingJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.CreateDataLabelingJobRequest,
            com.google.cloud.aiplatform.v1beta1.DataLabelingJob>
        getCreateDataLabelingJobMethod;
    if ((getCreateDataLabelingJobMethod = JobServiceGrpc.getCreateDataLabelingJobMethod) == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getCreateDataLabelingJobMethod = JobServiceGrpc.getCreateDataLabelingJobMethod)
            == null) {
          JobServiceGrpc.getCreateDataLabelingJobMethod =
              getCreateDataLabelingJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.CreateDataLabelingJobRequest,
                          com.google.cloud.aiplatform.v1beta1.DataLabelingJob>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateDataLabelingJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.CreateDataLabelingJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.DataLabelingJob
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new JobServiceMethodDescriptorSupplier("CreateDataLabelingJob"))
                      .build();
        }
      }
    }
    return getCreateDataLabelingJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetDataLabelingJobRequest,
          com.google.cloud.aiplatform.v1beta1.DataLabelingJob>
      getGetDataLabelingJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataLabelingJob",
      requestType = com.google.cloud.aiplatform.v1beta1.GetDataLabelingJobRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.DataLabelingJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetDataLabelingJobRequest,
          com.google.cloud.aiplatform.v1beta1.DataLabelingJob>
      getGetDataLabelingJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetDataLabelingJobRequest,
            com.google.cloud.aiplatform.v1beta1.DataLabelingJob>
        getGetDataLabelingJobMethod;
    if ((getGetDataLabelingJobMethod = JobServiceGrpc.getGetDataLabelingJobMethod) == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getGetDataLabelingJobMethod = JobServiceGrpc.getGetDataLabelingJobMethod) == null) {
          JobServiceGrpc.getGetDataLabelingJobMethod =
              getGetDataLabelingJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GetDataLabelingJobRequest,
                          com.google.cloud.aiplatform.v1beta1.DataLabelingJob>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataLabelingJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.GetDataLabelingJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.DataLabelingJob
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new JobServiceMethodDescriptorSupplier("GetDataLabelingJob"))
                      .build();
        }
      }
    }
    return getGetDataLabelingJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListDataLabelingJobsRequest,
          com.google.cloud.aiplatform.v1beta1.ListDataLabelingJobsResponse>
      getListDataLabelingJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDataLabelingJobs",
      requestType = com.google.cloud.aiplatform.v1beta1.ListDataLabelingJobsRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListDataLabelingJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListDataLabelingJobsRequest,
          com.google.cloud.aiplatform.v1beta1.ListDataLabelingJobsResponse>
      getListDataLabelingJobsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListDataLabelingJobsRequest,
            com.google.cloud.aiplatform.v1beta1.ListDataLabelingJobsResponse>
        getListDataLabelingJobsMethod;
    if ((getListDataLabelingJobsMethod = JobServiceGrpc.getListDataLabelingJobsMethod) == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getListDataLabelingJobsMethod = JobServiceGrpc.getListDataLabelingJobsMethod)
            == null) {
          JobServiceGrpc.getListDataLabelingJobsMethod =
              getListDataLabelingJobsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ListDataLabelingJobsRequest,
                          com.google.cloud.aiplatform.v1beta1.ListDataLabelingJobsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListDataLabelingJobs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListDataLabelingJobsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListDataLabelingJobsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new JobServiceMethodDescriptorSupplier("ListDataLabelingJobs"))
                      .build();
        }
      }
    }
    return getListDataLabelingJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteDataLabelingJobRequest,
          com.google.longrunning.Operation>
      getDeleteDataLabelingJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDataLabelingJob",
      requestType = com.google.cloud.aiplatform.v1beta1.DeleteDataLabelingJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteDataLabelingJobRequest,
          com.google.longrunning.Operation>
      getDeleteDataLabelingJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeleteDataLabelingJobRequest,
            com.google.longrunning.Operation>
        getDeleteDataLabelingJobMethod;
    if ((getDeleteDataLabelingJobMethod = JobServiceGrpc.getDeleteDataLabelingJobMethod) == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getDeleteDataLabelingJobMethod = JobServiceGrpc.getDeleteDataLabelingJobMethod)
            == null) {
          JobServiceGrpc.getDeleteDataLabelingJobMethod =
              getDeleteDataLabelingJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.DeleteDataLabelingJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteDataLabelingJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.DeleteDataLabelingJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new JobServiceMethodDescriptorSupplier("DeleteDataLabelingJob"))
                      .build();
        }
      }
    }
    return getDeleteDataLabelingJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CancelDataLabelingJobRequest,
          com.google.protobuf.Empty>
      getCancelDataLabelingJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelDataLabelingJob",
      requestType = com.google.cloud.aiplatform.v1beta1.CancelDataLabelingJobRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CancelDataLabelingJobRequest,
          com.google.protobuf.Empty>
      getCancelDataLabelingJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.CancelDataLabelingJobRequest,
            com.google.protobuf.Empty>
        getCancelDataLabelingJobMethod;
    if ((getCancelDataLabelingJobMethod = JobServiceGrpc.getCancelDataLabelingJobMethod) == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getCancelDataLabelingJobMethod = JobServiceGrpc.getCancelDataLabelingJobMethod)
            == null) {
          JobServiceGrpc.getCancelDataLabelingJobMethod =
              getCancelDataLabelingJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.CancelDataLabelingJobRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CancelDataLabelingJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.CancelDataLabelingJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new JobServiceMethodDescriptorSupplier("CancelDataLabelingJob"))
                      .build();
        }
      }
    }
    return getCancelDataLabelingJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateHyperparameterTuningJobRequest,
          com.google.cloud.aiplatform.v1beta1.HyperparameterTuningJob>
      getCreateHyperparameterTuningJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateHyperparameterTuningJob",
      requestType = com.google.cloud.aiplatform.v1beta1.CreateHyperparameterTuningJobRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.HyperparameterTuningJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateHyperparameterTuningJobRequest,
          com.google.cloud.aiplatform.v1beta1.HyperparameterTuningJob>
      getCreateHyperparameterTuningJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.CreateHyperparameterTuningJobRequest,
            com.google.cloud.aiplatform.v1beta1.HyperparameterTuningJob>
        getCreateHyperparameterTuningJobMethod;
    if ((getCreateHyperparameterTuningJobMethod =
            JobServiceGrpc.getCreateHyperparameterTuningJobMethod)
        == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getCreateHyperparameterTuningJobMethod =
                JobServiceGrpc.getCreateHyperparameterTuningJobMethod)
            == null) {
          JobServiceGrpc.getCreateHyperparameterTuningJobMethod =
              getCreateHyperparameterTuningJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.CreateHyperparameterTuningJobRequest,
                          com.google.cloud.aiplatform.v1beta1.HyperparameterTuningJob>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateHyperparameterTuningJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1
                                  .CreateHyperparameterTuningJobRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.HyperparameterTuningJob
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new JobServiceMethodDescriptorSupplier("CreateHyperparameterTuningJob"))
                      .build();
        }
      }
    }
    return getCreateHyperparameterTuningJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetHyperparameterTuningJobRequest,
          com.google.cloud.aiplatform.v1beta1.HyperparameterTuningJob>
      getGetHyperparameterTuningJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetHyperparameterTuningJob",
      requestType = com.google.cloud.aiplatform.v1beta1.GetHyperparameterTuningJobRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.HyperparameterTuningJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetHyperparameterTuningJobRequest,
          com.google.cloud.aiplatform.v1beta1.HyperparameterTuningJob>
      getGetHyperparameterTuningJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetHyperparameterTuningJobRequest,
            com.google.cloud.aiplatform.v1beta1.HyperparameterTuningJob>
        getGetHyperparameterTuningJobMethod;
    if ((getGetHyperparameterTuningJobMethod = JobServiceGrpc.getGetHyperparameterTuningJobMethod)
        == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getGetHyperparameterTuningJobMethod =
                JobServiceGrpc.getGetHyperparameterTuningJobMethod)
            == null) {
          JobServiceGrpc.getGetHyperparameterTuningJobMethod =
              getGetHyperparameterTuningJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GetHyperparameterTuningJobRequest,
                          com.google.cloud.aiplatform.v1beta1.HyperparameterTuningJob>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetHyperparameterTuningJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.GetHyperparameterTuningJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.HyperparameterTuningJob
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new JobServiceMethodDescriptorSupplier("GetHyperparameterTuningJob"))
                      .build();
        }
      }
    }
    return getGetHyperparameterTuningJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListHyperparameterTuningJobsRequest,
          com.google.cloud.aiplatform.v1beta1.ListHyperparameterTuningJobsResponse>
      getListHyperparameterTuningJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListHyperparameterTuningJobs",
      requestType = com.google.cloud.aiplatform.v1beta1.ListHyperparameterTuningJobsRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListHyperparameterTuningJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListHyperparameterTuningJobsRequest,
          com.google.cloud.aiplatform.v1beta1.ListHyperparameterTuningJobsResponse>
      getListHyperparameterTuningJobsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListHyperparameterTuningJobsRequest,
            com.google.cloud.aiplatform.v1beta1.ListHyperparameterTuningJobsResponse>
        getListHyperparameterTuningJobsMethod;
    if ((getListHyperparameterTuningJobsMethod =
            JobServiceGrpc.getListHyperparameterTuningJobsMethod)
        == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getListHyperparameterTuningJobsMethod =
                JobServiceGrpc.getListHyperparameterTuningJobsMethod)
            == null) {
          JobServiceGrpc.getListHyperparameterTuningJobsMethod =
              getListHyperparameterTuningJobsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ListHyperparameterTuningJobsRequest,
                          com.google.cloud.aiplatform.v1beta1.ListHyperparameterTuningJobsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListHyperparameterTuningJobs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1
                                  .ListHyperparameterTuningJobsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1
                                  .ListHyperparameterTuningJobsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new JobServiceMethodDescriptorSupplier("ListHyperparameterTuningJobs"))
                      .build();
        }
      }
    }
    return getListHyperparameterTuningJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteHyperparameterTuningJobRequest,
          com.google.longrunning.Operation>
      getDeleteHyperparameterTuningJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteHyperparameterTuningJob",
      requestType = com.google.cloud.aiplatform.v1beta1.DeleteHyperparameterTuningJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteHyperparameterTuningJobRequest,
          com.google.longrunning.Operation>
      getDeleteHyperparameterTuningJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeleteHyperparameterTuningJobRequest,
            com.google.longrunning.Operation>
        getDeleteHyperparameterTuningJobMethod;
    if ((getDeleteHyperparameterTuningJobMethod =
            JobServiceGrpc.getDeleteHyperparameterTuningJobMethod)
        == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getDeleteHyperparameterTuningJobMethod =
                JobServiceGrpc.getDeleteHyperparameterTuningJobMethod)
            == null) {
          JobServiceGrpc.getDeleteHyperparameterTuningJobMethod =
              getDeleteHyperparameterTuningJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.DeleteHyperparameterTuningJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteHyperparameterTuningJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1
                                  .DeleteHyperparameterTuningJobRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new JobServiceMethodDescriptorSupplier("DeleteHyperparameterTuningJob"))
                      .build();
        }
      }
    }
    return getDeleteHyperparameterTuningJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CancelHyperparameterTuningJobRequest,
          com.google.protobuf.Empty>
      getCancelHyperparameterTuningJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelHyperparameterTuningJob",
      requestType = com.google.cloud.aiplatform.v1beta1.CancelHyperparameterTuningJobRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CancelHyperparameterTuningJobRequest,
          com.google.protobuf.Empty>
      getCancelHyperparameterTuningJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.CancelHyperparameterTuningJobRequest,
            com.google.protobuf.Empty>
        getCancelHyperparameterTuningJobMethod;
    if ((getCancelHyperparameterTuningJobMethod =
            JobServiceGrpc.getCancelHyperparameterTuningJobMethod)
        == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getCancelHyperparameterTuningJobMethod =
                JobServiceGrpc.getCancelHyperparameterTuningJobMethod)
            == null) {
          JobServiceGrpc.getCancelHyperparameterTuningJobMethod =
              getCancelHyperparameterTuningJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.CancelHyperparameterTuningJobRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CancelHyperparameterTuningJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1
                                  .CancelHyperparameterTuningJobRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new JobServiceMethodDescriptorSupplier("CancelHyperparameterTuningJob"))
                      .build();
        }
      }
    }
    return getCancelHyperparameterTuningJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateBatchPredictionJobRequest,
          com.google.cloud.aiplatform.v1beta1.BatchPredictionJob>
      getCreateBatchPredictionJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBatchPredictionJob",
      requestType = com.google.cloud.aiplatform.v1beta1.CreateBatchPredictionJobRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.BatchPredictionJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateBatchPredictionJobRequest,
          com.google.cloud.aiplatform.v1beta1.BatchPredictionJob>
      getCreateBatchPredictionJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.CreateBatchPredictionJobRequest,
            com.google.cloud.aiplatform.v1beta1.BatchPredictionJob>
        getCreateBatchPredictionJobMethod;
    if ((getCreateBatchPredictionJobMethod = JobServiceGrpc.getCreateBatchPredictionJobMethod)
        == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getCreateBatchPredictionJobMethod = JobServiceGrpc.getCreateBatchPredictionJobMethod)
            == null) {
          JobServiceGrpc.getCreateBatchPredictionJobMethod =
              getCreateBatchPredictionJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.CreateBatchPredictionJobRequest,
                          com.google.cloud.aiplatform.v1beta1.BatchPredictionJob>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateBatchPredictionJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.CreateBatchPredictionJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.BatchPredictionJob
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new JobServiceMethodDescriptorSupplier("CreateBatchPredictionJob"))
                      .build();
        }
      }
    }
    return getCreateBatchPredictionJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetBatchPredictionJobRequest,
          com.google.cloud.aiplatform.v1beta1.BatchPredictionJob>
      getGetBatchPredictionJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBatchPredictionJob",
      requestType = com.google.cloud.aiplatform.v1beta1.GetBatchPredictionJobRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.BatchPredictionJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetBatchPredictionJobRequest,
          com.google.cloud.aiplatform.v1beta1.BatchPredictionJob>
      getGetBatchPredictionJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetBatchPredictionJobRequest,
            com.google.cloud.aiplatform.v1beta1.BatchPredictionJob>
        getGetBatchPredictionJobMethod;
    if ((getGetBatchPredictionJobMethod = JobServiceGrpc.getGetBatchPredictionJobMethod) == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getGetBatchPredictionJobMethod = JobServiceGrpc.getGetBatchPredictionJobMethod)
            == null) {
          JobServiceGrpc.getGetBatchPredictionJobMethod =
              getGetBatchPredictionJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GetBatchPredictionJobRequest,
                          com.google.cloud.aiplatform.v1beta1.BatchPredictionJob>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetBatchPredictionJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.GetBatchPredictionJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.BatchPredictionJob
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new JobServiceMethodDescriptorSupplier("GetBatchPredictionJob"))
                      .build();
        }
      }
    }
    return getGetBatchPredictionJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListBatchPredictionJobsRequest,
          com.google.cloud.aiplatform.v1beta1.ListBatchPredictionJobsResponse>
      getListBatchPredictionJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBatchPredictionJobs",
      requestType = com.google.cloud.aiplatform.v1beta1.ListBatchPredictionJobsRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListBatchPredictionJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListBatchPredictionJobsRequest,
          com.google.cloud.aiplatform.v1beta1.ListBatchPredictionJobsResponse>
      getListBatchPredictionJobsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListBatchPredictionJobsRequest,
            com.google.cloud.aiplatform.v1beta1.ListBatchPredictionJobsResponse>
        getListBatchPredictionJobsMethod;
    if ((getListBatchPredictionJobsMethod = JobServiceGrpc.getListBatchPredictionJobsMethod)
        == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getListBatchPredictionJobsMethod = JobServiceGrpc.getListBatchPredictionJobsMethod)
            == null) {
          JobServiceGrpc.getListBatchPredictionJobsMethod =
              getListBatchPredictionJobsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ListBatchPredictionJobsRequest,
                          com.google.cloud.aiplatform.v1beta1.ListBatchPredictionJobsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListBatchPredictionJobs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListBatchPredictionJobsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListBatchPredictionJobsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new JobServiceMethodDescriptorSupplier("ListBatchPredictionJobs"))
                      .build();
        }
      }
    }
    return getListBatchPredictionJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteBatchPredictionJobRequest,
          com.google.longrunning.Operation>
      getDeleteBatchPredictionJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBatchPredictionJob",
      requestType = com.google.cloud.aiplatform.v1beta1.DeleteBatchPredictionJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteBatchPredictionJobRequest,
          com.google.longrunning.Operation>
      getDeleteBatchPredictionJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeleteBatchPredictionJobRequest,
            com.google.longrunning.Operation>
        getDeleteBatchPredictionJobMethod;
    if ((getDeleteBatchPredictionJobMethod = JobServiceGrpc.getDeleteBatchPredictionJobMethod)
        == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getDeleteBatchPredictionJobMethod = JobServiceGrpc.getDeleteBatchPredictionJobMethod)
            == null) {
          JobServiceGrpc.getDeleteBatchPredictionJobMethod =
              getDeleteBatchPredictionJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.DeleteBatchPredictionJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteBatchPredictionJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.DeleteBatchPredictionJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new JobServiceMethodDescriptorSupplier("DeleteBatchPredictionJob"))
                      .build();
        }
      }
    }
    return getDeleteBatchPredictionJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CancelBatchPredictionJobRequest,
          com.google.protobuf.Empty>
      getCancelBatchPredictionJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelBatchPredictionJob",
      requestType = com.google.cloud.aiplatform.v1beta1.CancelBatchPredictionJobRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CancelBatchPredictionJobRequest,
          com.google.protobuf.Empty>
      getCancelBatchPredictionJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.CancelBatchPredictionJobRequest,
            com.google.protobuf.Empty>
        getCancelBatchPredictionJobMethod;
    if ((getCancelBatchPredictionJobMethod = JobServiceGrpc.getCancelBatchPredictionJobMethod)
        == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getCancelBatchPredictionJobMethod = JobServiceGrpc.getCancelBatchPredictionJobMethod)
            == null) {
          JobServiceGrpc.getCancelBatchPredictionJobMethod =
              getCancelBatchPredictionJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.CancelBatchPredictionJobRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CancelBatchPredictionJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.CancelBatchPredictionJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new JobServiceMethodDescriptorSupplier("CancelBatchPredictionJob"))
                      .build();
        }
      }
    }
    return getCancelBatchPredictionJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateModelDeploymentMonitoringJobRequest,
          com.google.cloud.aiplatform.v1beta1.ModelDeploymentMonitoringJob>
      getCreateModelDeploymentMonitoringJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateModelDeploymentMonitoringJob",
      requestType =
          com.google.cloud.aiplatform.v1beta1.CreateModelDeploymentMonitoringJobRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ModelDeploymentMonitoringJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateModelDeploymentMonitoringJobRequest,
          com.google.cloud.aiplatform.v1beta1.ModelDeploymentMonitoringJob>
      getCreateModelDeploymentMonitoringJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.CreateModelDeploymentMonitoringJobRequest,
            com.google.cloud.aiplatform.v1beta1.ModelDeploymentMonitoringJob>
        getCreateModelDeploymentMonitoringJobMethod;
    if ((getCreateModelDeploymentMonitoringJobMethod =
            JobServiceGrpc.getCreateModelDeploymentMonitoringJobMethod)
        == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getCreateModelDeploymentMonitoringJobMethod =
                JobServiceGrpc.getCreateModelDeploymentMonitoringJobMethod)
            == null) {
          JobServiceGrpc.getCreateModelDeploymentMonitoringJobMethod =
              getCreateModelDeploymentMonitoringJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1
                              .CreateModelDeploymentMonitoringJobRequest,
                          com.google.cloud.aiplatform.v1beta1.ModelDeploymentMonitoringJob>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "CreateModelDeploymentMonitoringJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1
                                  .CreateModelDeploymentMonitoringJobRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ModelDeploymentMonitoringJob
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new JobServiceMethodDescriptorSupplier(
                              "CreateModelDeploymentMonitoringJob"))
                      .build();
        }
      }
    }
    return getCreateModelDeploymentMonitoringJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.SearchModelDeploymentMonitoringStatsAnomaliesRequest,
          com.google.cloud.aiplatform.v1beta1.SearchModelDeploymentMonitoringStatsAnomaliesResponse>
      getSearchModelDeploymentMonitoringStatsAnomaliesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchModelDeploymentMonitoringStatsAnomalies",
      requestType =
          com.google.cloud.aiplatform.v1beta1.SearchModelDeploymentMonitoringStatsAnomaliesRequest
              .class,
      responseType =
          com.google.cloud.aiplatform.v1beta1.SearchModelDeploymentMonitoringStatsAnomaliesResponse
              .class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.SearchModelDeploymentMonitoringStatsAnomaliesRequest,
          com.google.cloud.aiplatform.v1beta1.SearchModelDeploymentMonitoringStatsAnomaliesResponse>
      getSearchModelDeploymentMonitoringStatsAnomaliesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1
                .SearchModelDeploymentMonitoringStatsAnomaliesRequest,
            com.google.cloud.aiplatform.v1beta1
                .SearchModelDeploymentMonitoringStatsAnomaliesResponse>
        getSearchModelDeploymentMonitoringStatsAnomaliesMethod;
    if ((getSearchModelDeploymentMonitoringStatsAnomaliesMethod =
            JobServiceGrpc.getSearchModelDeploymentMonitoringStatsAnomaliesMethod)
        == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getSearchModelDeploymentMonitoringStatsAnomaliesMethod =
                JobServiceGrpc.getSearchModelDeploymentMonitoringStatsAnomaliesMethod)
            == null) {
          JobServiceGrpc.getSearchModelDeploymentMonitoringStatsAnomaliesMethod =
              getSearchModelDeploymentMonitoringStatsAnomaliesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1
                              .SearchModelDeploymentMonitoringStatsAnomaliesRequest,
                          com.google.cloud.aiplatform.v1beta1
                              .SearchModelDeploymentMonitoringStatsAnomaliesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "SearchModelDeploymentMonitoringStatsAnomalies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1
                                  .SearchModelDeploymentMonitoringStatsAnomaliesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1
                                  .SearchModelDeploymentMonitoringStatsAnomaliesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new JobServiceMethodDescriptorSupplier(
                              "SearchModelDeploymentMonitoringStatsAnomalies"))
                      .build();
        }
      }
    }
    return getSearchModelDeploymentMonitoringStatsAnomaliesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetModelDeploymentMonitoringJobRequest,
          com.google.cloud.aiplatform.v1beta1.ModelDeploymentMonitoringJob>
      getGetModelDeploymentMonitoringJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetModelDeploymentMonitoringJob",
      requestType =
          com.google.cloud.aiplatform.v1beta1.GetModelDeploymentMonitoringJobRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ModelDeploymentMonitoringJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetModelDeploymentMonitoringJobRequest,
          com.google.cloud.aiplatform.v1beta1.ModelDeploymentMonitoringJob>
      getGetModelDeploymentMonitoringJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetModelDeploymentMonitoringJobRequest,
            com.google.cloud.aiplatform.v1beta1.ModelDeploymentMonitoringJob>
        getGetModelDeploymentMonitoringJobMethod;
    if ((getGetModelDeploymentMonitoringJobMethod =
            JobServiceGrpc.getGetModelDeploymentMonitoringJobMethod)
        == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getGetModelDeploymentMonitoringJobMethod =
                JobServiceGrpc.getGetModelDeploymentMonitoringJobMethod)
            == null) {
          JobServiceGrpc.getGetModelDeploymentMonitoringJobMethod =
              getGetModelDeploymentMonitoringJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GetModelDeploymentMonitoringJobRequest,
                          com.google.cloud.aiplatform.v1beta1.ModelDeploymentMonitoringJob>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetModelDeploymentMonitoringJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1
                                  .GetModelDeploymentMonitoringJobRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ModelDeploymentMonitoringJob
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new JobServiceMethodDescriptorSupplier("GetModelDeploymentMonitoringJob"))
                      .build();
        }
      }
    }
    return getGetModelDeploymentMonitoringJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListModelDeploymentMonitoringJobsRequest,
          com.google.cloud.aiplatform.v1beta1.ListModelDeploymentMonitoringJobsResponse>
      getListModelDeploymentMonitoringJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListModelDeploymentMonitoringJobs",
      requestType =
          com.google.cloud.aiplatform.v1beta1.ListModelDeploymentMonitoringJobsRequest.class,
      responseType =
          com.google.cloud.aiplatform.v1beta1.ListModelDeploymentMonitoringJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListModelDeploymentMonitoringJobsRequest,
          com.google.cloud.aiplatform.v1beta1.ListModelDeploymentMonitoringJobsResponse>
      getListModelDeploymentMonitoringJobsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListModelDeploymentMonitoringJobsRequest,
            com.google.cloud.aiplatform.v1beta1.ListModelDeploymentMonitoringJobsResponse>
        getListModelDeploymentMonitoringJobsMethod;
    if ((getListModelDeploymentMonitoringJobsMethod =
            JobServiceGrpc.getListModelDeploymentMonitoringJobsMethod)
        == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getListModelDeploymentMonitoringJobsMethod =
                JobServiceGrpc.getListModelDeploymentMonitoringJobsMethod)
            == null) {
          JobServiceGrpc.getListModelDeploymentMonitoringJobsMethod =
              getListModelDeploymentMonitoringJobsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1
                              .ListModelDeploymentMonitoringJobsRequest,
                          com.google.cloud.aiplatform.v1beta1
                              .ListModelDeploymentMonitoringJobsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListModelDeploymentMonitoringJobs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1
                                  .ListModelDeploymentMonitoringJobsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1
                                  .ListModelDeploymentMonitoringJobsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new JobServiceMethodDescriptorSupplier(
                              "ListModelDeploymentMonitoringJobs"))
                      .build();
        }
      }
    }
    return getListModelDeploymentMonitoringJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateModelDeploymentMonitoringJobRequest,
          com.google.longrunning.Operation>
      getUpdateModelDeploymentMonitoringJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateModelDeploymentMonitoringJob",
      requestType =
          com.google.cloud.aiplatform.v1beta1.UpdateModelDeploymentMonitoringJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateModelDeploymentMonitoringJobRequest,
          com.google.longrunning.Operation>
      getUpdateModelDeploymentMonitoringJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.UpdateModelDeploymentMonitoringJobRequest,
            com.google.longrunning.Operation>
        getUpdateModelDeploymentMonitoringJobMethod;
    if ((getUpdateModelDeploymentMonitoringJobMethod =
            JobServiceGrpc.getUpdateModelDeploymentMonitoringJobMethod)
        == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getUpdateModelDeploymentMonitoringJobMethod =
                JobServiceGrpc.getUpdateModelDeploymentMonitoringJobMethod)
            == null) {
          JobServiceGrpc.getUpdateModelDeploymentMonitoringJobMethod =
              getUpdateModelDeploymentMonitoringJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1
                              .UpdateModelDeploymentMonitoringJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "UpdateModelDeploymentMonitoringJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1
                                  .UpdateModelDeploymentMonitoringJobRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new JobServiceMethodDescriptorSupplier(
                              "UpdateModelDeploymentMonitoringJob"))
                      .build();
        }
      }
    }
    return getUpdateModelDeploymentMonitoringJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteModelDeploymentMonitoringJobRequest,
          com.google.longrunning.Operation>
      getDeleteModelDeploymentMonitoringJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteModelDeploymentMonitoringJob",
      requestType =
          com.google.cloud.aiplatform.v1beta1.DeleteModelDeploymentMonitoringJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteModelDeploymentMonitoringJobRequest,
          com.google.longrunning.Operation>
      getDeleteModelDeploymentMonitoringJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeleteModelDeploymentMonitoringJobRequest,
            com.google.longrunning.Operation>
        getDeleteModelDeploymentMonitoringJobMethod;
    if ((getDeleteModelDeploymentMonitoringJobMethod =
            JobServiceGrpc.getDeleteModelDeploymentMonitoringJobMethod)
        == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getDeleteModelDeploymentMonitoringJobMethod =
                JobServiceGrpc.getDeleteModelDeploymentMonitoringJobMethod)
            == null) {
          JobServiceGrpc.getDeleteModelDeploymentMonitoringJobMethod =
              getDeleteModelDeploymentMonitoringJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1
                              .DeleteModelDeploymentMonitoringJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "DeleteModelDeploymentMonitoringJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1
                                  .DeleteModelDeploymentMonitoringJobRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new JobServiceMethodDescriptorSupplier(
                              "DeleteModelDeploymentMonitoringJob"))
                      .build();
        }
      }
    }
    return getDeleteModelDeploymentMonitoringJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.PauseModelDeploymentMonitoringJobRequest,
          com.google.protobuf.Empty>
      getPauseModelDeploymentMonitoringJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PauseModelDeploymentMonitoringJob",
      requestType =
          com.google.cloud.aiplatform.v1beta1.PauseModelDeploymentMonitoringJobRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.PauseModelDeploymentMonitoringJobRequest,
          com.google.protobuf.Empty>
      getPauseModelDeploymentMonitoringJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.PauseModelDeploymentMonitoringJobRequest,
            com.google.protobuf.Empty>
        getPauseModelDeploymentMonitoringJobMethod;
    if ((getPauseModelDeploymentMonitoringJobMethod =
            JobServiceGrpc.getPauseModelDeploymentMonitoringJobMethod)
        == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getPauseModelDeploymentMonitoringJobMethod =
                JobServiceGrpc.getPauseModelDeploymentMonitoringJobMethod)
            == null) {
          JobServiceGrpc.getPauseModelDeploymentMonitoringJobMethod =
              getPauseModelDeploymentMonitoringJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1
                              .PauseModelDeploymentMonitoringJobRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "PauseModelDeploymentMonitoringJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1
                                  .PauseModelDeploymentMonitoringJobRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new JobServiceMethodDescriptorSupplier(
                              "PauseModelDeploymentMonitoringJob"))
                      .build();
        }
      }
    }
    return getPauseModelDeploymentMonitoringJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ResumeModelDeploymentMonitoringJobRequest,
          com.google.protobuf.Empty>
      getResumeModelDeploymentMonitoringJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResumeModelDeploymentMonitoringJob",
      requestType =
          com.google.cloud.aiplatform.v1beta1.ResumeModelDeploymentMonitoringJobRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ResumeModelDeploymentMonitoringJobRequest,
          com.google.protobuf.Empty>
      getResumeModelDeploymentMonitoringJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ResumeModelDeploymentMonitoringJobRequest,
            com.google.protobuf.Empty>
        getResumeModelDeploymentMonitoringJobMethod;
    if ((getResumeModelDeploymentMonitoringJobMethod =
            JobServiceGrpc.getResumeModelDeploymentMonitoringJobMethod)
        == null) {
      synchronized (JobServiceGrpc.class) {
        if ((getResumeModelDeploymentMonitoringJobMethod =
                JobServiceGrpc.getResumeModelDeploymentMonitoringJobMethod)
            == null) {
          JobServiceGrpc.getResumeModelDeploymentMonitoringJobMethod =
              getResumeModelDeploymentMonitoringJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1
                              .ResumeModelDeploymentMonitoringJobRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "ResumeModelDeploymentMonitoringJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1
                                  .ResumeModelDeploymentMonitoringJobRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new JobServiceMethodDescriptorSupplier(
                              "ResumeModelDeploymentMonitoringJob"))
                      .build();
        }
      }
    }
    return getResumeModelDeploymentMonitoringJobMethod;
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
   * A service for creating and managing Vertex AI's jobs.
   * </pre>
   */
  public abstract static class JobServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a CustomJob. A created CustomJob right away
     * will be attempted to be run.
     * </pre>
     */
    public void createCustomJob(
        com.google.cloud.aiplatform.v1beta1.CreateCustomJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.CustomJob>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCustomJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a CustomJob.
     * </pre>
     */
    public void getCustomJob(
        com.google.cloud.aiplatform.v1beta1.GetCustomJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.CustomJob>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCustomJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists CustomJobs in a Location.
     * </pre>
     */
    public void listCustomJobs(
        com.google.cloud.aiplatform.v1beta1.ListCustomJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListCustomJobsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCustomJobsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a CustomJob.
     * </pre>
     */
    public void deleteCustomJob(
        com.google.cloud.aiplatform.v1beta1.DeleteCustomJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteCustomJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels a CustomJob.
     * Starts asynchronous cancellation on the CustomJob. The server
     * makes a best effort to cancel the job, but success is not
     * guaranteed. Clients can use
     * [JobService.GetCustomJob][google.cloud.aiplatform.v1beta1.JobService.GetCustomJob]
     * or other methods to check whether the cancellation succeeded or whether the
     * job completed despite cancellation. On successful cancellation,
     * the CustomJob is not deleted; instead it becomes a job with
     * a [CustomJob.error][google.cloud.aiplatform.v1beta1.CustomJob.error] value
     * with a [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding
     * to `Code.CANCELLED`, and
     * [CustomJob.state][google.cloud.aiplatform.v1beta1.CustomJob.state] is set
     * to `CANCELLED`.
     * </pre>
     */
    public void cancelCustomJob(
        com.google.cloud.aiplatform.v1beta1.CancelCustomJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCancelCustomJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a DataLabelingJob.
     * </pre>
     */
    public void createDataLabelingJob(
        com.google.cloud.aiplatform.v1beta1.CreateDataLabelingJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.DataLabelingJob>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDataLabelingJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a DataLabelingJob.
     * </pre>
     */
    public void getDataLabelingJob(
        com.google.cloud.aiplatform.v1beta1.GetDataLabelingJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.DataLabelingJob>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDataLabelingJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DataLabelingJobs in a Location.
     * </pre>
     */
    public void listDataLabelingJobs(
        com.google.cloud.aiplatform.v1beta1.ListDataLabelingJobsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.ListDataLabelingJobsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDataLabelingJobsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a DataLabelingJob.
     * </pre>
     */
    public void deleteDataLabelingJob(
        com.google.cloud.aiplatform.v1beta1.DeleteDataLabelingJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDataLabelingJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels a DataLabelingJob. Success of cancellation is not guaranteed.
     * </pre>
     */
    public void cancelDataLabelingJob(
        com.google.cloud.aiplatform.v1beta1.CancelDataLabelingJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCancelDataLabelingJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a HyperparameterTuningJob
     * </pre>
     */
    public void createHyperparameterTuningJob(
        com.google.cloud.aiplatform.v1beta1.CreateHyperparameterTuningJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.HyperparameterTuningJob>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateHyperparameterTuningJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a HyperparameterTuningJob
     * </pre>
     */
    public void getHyperparameterTuningJob(
        com.google.cloud.aiplatform.v1beta1.GetHyperparameterTuningJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.HyperparameterTuningJob>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetHyperparameterTuningJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists HyperparameterTuningJobs in a Location.
     * </pre>
     */
    public void listHyperparameterTuningJobs(
        com.google.cloud.aiplatform.v1beta1.ListHyperparameterTuningJobsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.ListHyperparameterTuningJobsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListHyperparameterTuningJobsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a HyperparameterTuningJob.
     * </pre>
     */
    public void deleteHyperparameterTuningJob(
        com.google.cloud.aiplatform.v1beta1.DeleteHyperparameterTuningJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteHyperparameterTuningJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels a HyperparameterTuningJob.
     * Starts asynchronous cancellation on the HyperparameterTuningJob. The server
     * makes a best effort to cancel the job, but success is not
     * guaranteed. Clients can use
     * [JobService.GetHyperparameterTuningJob][google.cloud.aiplatform.v1beta1.JobService.GetHyperparameterTuningJob]
     * or other methods to check whether the cancellation succeeded or whether the
     * job completed despite cancellation. On successful cancellation,
     * the HyperparameterTuningJob is not deleted; instead it becomes a job with
     * a
     * [HyperparameterTuningJob.error][google.cloud.aiplatform.v1beta1.HyperparameterTuningJob.error]
     * value with a [google.rpc.Status.code][google.rpc.Status.code] of 1,
     * corresponding to `Code.CANCELLED`, and
     * [HyperparameterTuningJob.state][google.cloud.aiplatform.v1beta1.HyperparameterTuningJob.state]
     * is set to `CANCELLED`.
     * </pre>
     */
    public void cancelHyperparameterTuningJob(
        com.google.cloud.aiplatform.v1beta1.CancelHyperparameterTuningJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCancelHyperparameterTuningJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a BatchPredictionJob. A BatchPredictionJob once created will
     * right away be attempted to start.
     * </pre>
     */
    public void createBatchPredictionJob(
        com.google.cloud.aiplatform.v1beta1.CreateBatchPredictionJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.BatchPredictionJob>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateBatchPredictionJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a BatchPredictionJob
     * </pre>
     */
    public void getBatchPredictionJob(
        com.google.cloud.aiplatform.v1beta1.GetBatchPredictionJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.BatchPredictionJob>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetBatchPredictionJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists BatchPredictionJobs in a Location.
     * </pre>
     */
    public void listBatchPredictionJobs(
        com.google.cloud.aiplatform.v1beta1.ListBatchPredictionJobsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.ListBatchPredictionJobsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBatchPredictionJobsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a BatchPredictionJob. Can only be called on jobs that already
     * finished.
     * </pre>
     */
    public void deleteBatchPredictionJob(
        com.google.cloud.aiplatform.v1beta1.DeleteBatchPredictionJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteBatchPredictionJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels a BatchPredictionJob.
     * Starts asynchronous cancellation on the BatchPredictionJob. The server
     * makes the best effort to cancel the job, but success is not
     * guaranteed. Clients can use
     * [JobService.GetBatchPredictionJob][google.cloud.aiplatform.v1beta1.JobService.GetBatchPredictionJob]
     * or other methods to check whether the cancellation succeeded or whether the
     * job completed despite cancellation. On a successful cancellation,
     * the BatchPredictionJob is not deleted;instead its
     * [BatchPredictionJob.state][google.cloud.aiplatform.v1beta1.BatchPredictionJob.state]
     * is set to `CANCELLED`. Any files already outputted by the job are not
     * deleted.
     * </pre>
     */
    public void cancelBatchPredictionJob(
        com.google.cloud.aiplatform.v1beta1.CancelBatchPredictionJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCancelBatchPredictionJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a ModelDeploymentMonitoringJob. It will run periodically on a
     * configured interval.
     * </pre>
     */
    public void createModelDeploymentMonitoringJob(
        com.google.cloud.aiplatform.v1beta1.CreateModelDeploymentMonitoringJobRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.ModelDeploymentMonitoringJob>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateModelDeploymentMonitoringJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches Model Monitoring Statistics generated within a given time window.
     * </pre>
     */
    public void searchModelDeploymentMonitoringStatsAnomalies(
        com.google.cloud.aiplatform.v1beta1.SearchModelDeploymentMonitoringStatsAnomaliesRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1
                    .SearchModelDeploymentMonitoringStatsAnomaliesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchModelDeploymentMonitoringStatsAnomaliesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a ModelDeploymentMonitoringJob.
     * </pre>
     */
    public void getModelDeploymentMonitoringJob(
        com.google.cloud.aiplatform.v1beta1.GetModelDeploymentMonitoringJobRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.ModelDeploymentMonitoringJob>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetModelDeploymentMonitoringJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ModelDeploymentMonitoringJobs in a Location.
     * </pre>
     */
    public void listModelDeploymentMonitoringJobs(
        com.google.cloud.aiplatform.v1beta1.ListModelDeploymentMonitoringJobsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.ListModelDeploymentMonitoringJobsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListModelDeploymentMonitoringJobsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a ModelDeploymentMonitoringJob.
     * </pre>
     */
    public void updateModelDeploymentMonitoringJob(
        com.google.cloud.aiplatform.v1beta1.UpdateModelDeploymentMonitoringJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateModelDeploymentMonitoringJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ModelDeploymentMonitoringJob.
     * </pre>
     */
    public void deleteModelDeploymentMonitoringJob(
        com.google.cloud.aiplatform.v1beta1.DeleteModelDeploymentMonitoringJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteModelDeploymentMonitoringJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Pauses a ModelDeploymentMonitoringJob. If the job is running, the server
     * makes a best effort to cancel the job. Will mark
     * [ModelDeploymentMonitoringJob.state][google.cloud.aiplatform.v1beta1.ModelDeploymentMonitoringJob.state]
     * to 'PAUSED'.
     * </pre>
     */
    public void pauseModelDeploymentMonitoringJob(
        com.google.cloud.aiplatform.v1beta1.PauseModelDeploymentMonitoringJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getPauseModelDeploymentMonitoringJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resumes a paused ModelDeploymentMonitoringJob. It will start to run from
     * next scheduled time. A deleted ModelDeploymentMonitoringJob can't be
     * resumed.
     * </pre>
     */
    public void resumeModelDeploymentMonitoringJob(
        com.google.cloud.aiplatform.v1beta1.ResumeModelDeploymentMonitoringJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getResumeModelDeploymentMonitoringJobMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateCustomJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.CreateCustomJobRequest,
                      com.google.cloud.aiplatform.v1beta1.CustomJob>(
                      this, METHODID_CREATE_CUSTOM_JOB)))
          .addMethod(
              getGetCustomJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.GetCustomJobRequest,
                      com.google.cloud.aiplatform.v1beta1.CustomJob>(
                      this, METHODID_GET_CUSTOM_JOB)))
          .addMethod(
              getListCustomJobsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.ListCustomJobsRequest,
                      com.google.cloud.aiplatform.v1beta1.ListCustomJobsResponse>(
                      this, METHODID_LIST_CUSTOM_JOBS)))
          .addMethod(
              getDeleteCustomJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.DeleteCustomJobRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_CUSTOM_JOB)))
          .addMethod(
              getCancelCustomJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.CancelCustomJobRequest,
                      com.google.protobuf.Empty>(this, METHODID_CANCEL_CUSTOM_JOB)))
          .addMethod(
              getCreateDataLabelingJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.CreateDataLabelingJobRequest,
                      com.google.cloud.aiplatform.v1beta1.DataLabelingJob>(
                      this, METHODID_CREATE_DATA_LABELING_JOB)))
          .addMethod(
              getGetDataLabelingJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.GetDataLabelingJobRequest,
                      com.google.cloud.aiplatform.v1beta1.DataLabelingJob>(
                      this, METHODID_GET_DATA_LABELING_JOB)))
          .addMethod(
              getListDataLabelingJobsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.ListDataLabelingJobsRequest,
                      com.google.cloud.aiplatform.v1beta1.ListDataLabelingJobsResponse>(
                      this, METHODID_LIST_DATA_LABELING_JOBS)))
          .addMethod(
              getDeleteDataLabelingJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.DeleteDataLabelingJobRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_DATA_LABELING_JOB)))
          .addMethod(
              getCancelDataLabelingJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.CancelDataLabelingJobRequest,
                      com.google.protobuf.Empty>(this, METHODID_CANCEL_DATA_LABELING_JOB)))
          .addMethod(
              getCreateHyperparameterTuningJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.CreateHyperparameterTuningJobRequest,
                      com.google.cloud.aiplatform.v1beta1.HyperparameterTuningJob>(
                      this, METHODID_CREATE_HYPERPARAMETER_TUNING_JOB)))
          .addMethod(
              getGetHyperparameterTuningJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.GetHyperparameterTuningJobRequest,
                      com.google.cloud.aiplatform.v1beta1.HyperparameterTuningJob>(
                      this, METHODID_GET_HYPERPARAMETER_TUNING_JOB)))
          .addMethod(
              getListHyperparameterTuningJobsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.ListHyperparameterTuningJobsRequest,
                      com.google.cloud.aiplatform.v1beta1.ListHyperparameterTuningJobsResponse>(
                      this, METHODID_LIST_HYPERPARAMETER_TUNING_JOBS)))
          .addMethod(
              getDeleteHyperparameterTuningJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.DeleteHyperparameterTuningJobRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_DELETE_HYPERPARAMETER_TUNING_JOB)))
          .addMethod(
              getCancelHyperparameterTuningJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.CancelHyperparameterTuningJobRequest,
                      com.google.protobuf.Empty>(this, METHODID_CANCEL_HYPERPARAMETER_TUNING_JOB)))
          .addMethod(
              getCreateBatchPredictionJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.CreateBatchPredictionJobRequest,
                      com.google.cloud.aiplatform.v1beta1.BatchPredictionJob>(
                      this, METHODID_CREATE_BATCH_PREDICTION_JOB)))
          .addMethod(
              getGetBatchPredictionJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.GetBatchPredictionJobRequest,
                      com.google.cloud.aiplatform.v1beta1.BatchPredictionJob>(
                      this, METHODID_GET_BATCH_PREDICTION_JOB)))
          .addMethod(
              getListBatchPredictionJobsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.ListBatchPredictionJobsRequest,
                      com.google.cloud.aiplatform.v1beta1.ListBatchPredictionJobsResponse>(
                      this, METHODID_LIST_BATCH_PREDICTION_JOBS)))
          .addMethod(
              getDeleteBatchPredictionJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.DeleteBatchPredictionJobRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_DELETE_BATCH_PREDICTION_JOB)))
          .addMethod(
              getCancelBatchPredictionJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.CancelBatchPredictionJobRequest,
                      com.google.protobuf.Empty>(this, METHODID_CANCEL_BATCH_PREDICTION_JOB)))
          .addMethod(
              getCreateModelDeploymentMonitoringJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.CreateModelDeploymentMonitoringJobRequest,
                      com.google.cloud.aiplatform.v1beta1.ModelDeploymentMonitoringJob>(
                      this, METHODID_CREATE_MODEL_DEPLOYMENT_MONITORING_JOB)))
          .addMethod(
              getSearchModelDeploymentMonitoringStatsAnomaliesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1
                          .SearchModelDeploymentMonitoringStatsAnomaliesRequest,
                      com.google.cloud.aiplatform.v1beta1
                          .SearchModelDeploymentMonitoringStatsAnomaliesResponse>(
                      this, METHODID_SEARCH_MODEL_DEPLOYMENT_MONITORING_STATS_ANOMALIES)))
          .addMethod(
              getGetModelDeploymentMonitoringJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.GetModelDeploymentMonitoringJobRequest,
                      com.google.cloud.aiplatform.v1beta1.ModelDeploymentMonitoringJob>(
                      this, METHODID_GET_MODEL_DEPLOYMENT_MONITORING_JOB)))
          .addMethod(
              getListModelDeploymentMonitoringJobsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.ListModelDeploymentMonitoringJobsRequest,
                      com.google.cloud.aiplatform.v1beta1
                          .ListModelDeploymentMonitoringJobsResponse>(
                      this, METHODID_LIST_MODEL_DEPLOYMENT_MONITORING_JOBS)))
          .addMethod(
              getUpdateModelDeploymentMonitoringJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.UpdateModelDeploymentMonitoringJobRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_UPDATE_MODEL_DEPLOYMENT_MONITORING_JOB)))
          .addMethod(
              getDeleteModelDeploymentMonitoringJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.DeleteModelDeploymentMonitoringJobRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_DELETE_MODEL_DEPLOYMENT_MONITORING_JOB)))
          .addMethod(
              getPauseModelDeploymentMonitoringJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.PauseModelDeploymentMonitoringJobRequest,
                      com.google.protobuf.Empty>(
                      this, METHODID_PAUSE_MODEL_DEPLOYMENT_MONITORING_JOB)))
          .addMethod(
              getResumeModelDeploymentMonitoringJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.ResumeModelDeploymentMonitoringJobRequest,
                      com.google.protobuf.Empty>(
                      this, METHODID_RESUME_MODEL_DEPLOYMENT_MONITORING_JOB)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * A service for creating and managing Vertex AI's jobs.
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
     * Creates a CustomJob. A created CustomJob right away
     * will be attempted to be run.
     * </pre>
     */
    public void createCustomJob(
        com.google.cloud.aiplatform.v1beta1.CreateCustomJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.CustomJob>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCustomJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a CustomJob.
     * </pre>
     */
    public void getCustomJob(
        com.google.cloud.aiplatform.v1beta1.GetCustomJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.CustomJob>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCustomJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists CustomJobs in a Location.
     * </pre>
     */
    public void listCustomJobs(
        com.google.cloud.aiplatform.v1beta1.ListCustomJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListCustomJobsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCustomJobsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a CustomJob.
     * </pre>
     */
    public void deleteCustomJob(
        com.google.cloud.aiplatform.v1beta1.DeleteCustomJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCustomJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels a CustomJob.
     * Starts asynchronous cancellation on the CustomJob. The server
     * makes a best effort to cancel the job, but success is not
     * guaranteed. Clients can use
     * [JobService.GetCustomJob][google.cloud.aiplatform.v1beta1.JobService.GetCustomJob]
     * or other methods to check whether the cancellation succeeded or whether the
     * job completed despite cancellation. On successful cancellation,
     * the CustomJob is not deleted; instead it becomes a job with
     * a [CustomJob.error][google.cloud.aiplatform.v1beta1.CustomJob.error] value
     * with a [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding
     * to `Code.CANCELLED`, and
     * [CustomJob.state][google.cloud.aiplatform.v1beta1.CustomJob.state] is set
     * to `CANCELLED`.
     * </pre>
     */
    public void cancelCustomJob(
        com.google.cloud.aiplatform.v1beta1.CancelCustomJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelCustomJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a DataLabelingJob.
     * </pre>
     */
    public void createDataLabelingJob(
        com.google.cloud.aiplatform.v1beta1.CreateDataLabelingJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.DataLabelingJob>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDataLabelingJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a DataLabelingJob.
     * </pre>
     */
    public void getDataLabelingJob(
        com.google.cloud.aiplatform.v1beta1.GetDataLabelingJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.DataLabelingJob>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataLabelingJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DataLabelingJobs in a Location.
     * </pre>
     */
    public void listDataLabelingJobs(
        com.google.cloud.aiplatform.v1beta1.ListDataLabelingJobsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.ListDataLabelingJobsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDataLabelingJobsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a DataLabelingJob.
     * </pre>
     */
    public void deleteDataLabelingJob(
        com.google.cloud.aiplatform.v1beta1.DeleteDataLabelingJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDataLabelingJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels a DataLabelingJob. Success of cancellation is not guaranteed.
     * </pre>
     */
    public void cancelDataLabelingJob(
        com.google.cloud.aiplatform.v1beta1.CancelDataLabelingJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelDataLabelingJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a HyperparameterTuningJob
     * </pre>
     */
    public void createHyperparameterTuningJob(
        com.google.cloud.aiplatform.v1beta1.CreateHyperparameterTuningJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.HyperparameterTuningJob>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateHyperparameterTuningJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a HyperparameterTuningJob
     * </pre>
     */
    public void getHyperparameterTuningJob(
        com.google.cloud.aiplatform.v1beta1.GetHyperparameterTuningJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.HyperparameterTuningJob>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetHyperparameterTuningJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists HyperparameterTuningJobs in a Location.
     * </pre>
     */
    public void listHyperparameterTuningJobs(
        com.google.cloud.aiplatform.v1beta1.ListHyperparameterTuningJobsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.ListHyperparameterTuningJobsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListHyperparameterTuningJobsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a HyperparameterTuningJob.
     * </pre>
     */
    public void deleteHyperparameterTuningJob(
        com.google.cloud.aiplatform.v1beta1.DeleteHyperparameterTuningJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteHyperparameterTuningJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels a HyperparameterTuningJob.
     * Starts asynchronous cancellation on the HyperparameterTuningJob. The server
     * makes a best effort to cancel the job, but success is not
     * guaranteed. Clients can use
     * [JobService.GetHyperparameterTuningJob][google.cloud.aiplatform.v1beta1.JobService.GetHyperparameterTuningJob]
     * or other methods to check whether the cancellation succeeded or whether the
     * job completed despite cancellation. On successful cancellation,
     * the HyperparameterTuningJob is not deleted; instead it becomes a job with
     * a
     * [HyperparameterTuningJob.error][google.cloud.aiplatform.v1beta1.HyperparameterTuningJob.error]
     * value with a [google.rpc.Status.code][google.rpc.Status.code] of 1,
     * corresponding to `Code.CANCELLED`, and
     * [HyperparameterTuningJob.state][google.cloud.aiplatform.v1beta1.HyperparameterTuningJob.state]
     * is set to `CANCELLED`.
     * </pre>
     */
    public void cancelHyperparameterTuningJob(
        com.google.cloud.aiplatform.v1beta1.CancelHyperparameterTuningJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelHyperparameterTuningJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a BatchPredictionJob. A BatchPredictionJob once created will
     * right away be attempted to start.
     * </pre>
     */
    public void createBatchPredictionJob(
        com.google.cloud.aiplatform.v1beta1.CreateBatchPredictionJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.BatchPredictionJob>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBatchPredictionJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a BatchPredictionJob
     * </pre>
     */
    public void getBatchPredictionJob(
        com.google.cloud.aiplatform.v1beta1.GetBatchPredictionJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.BatchPredictionJob>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBatchPredictionJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists BatchPredictionJobs in a Location.
     * </pre>
     */
    public void listBatchPredictionJobs(
        com.google.cloud.aiplatform.v1beta1.ListBatchPredictionJobsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.ListBatchPredictionJobsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBatchPredictionJobsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a BatchPredictionJob. Can only be called on jobs that already
     * finished.
     * </pre>
     */
    public void deleteBatchPredictionJob(
        com.google.cloud.aiplatform.v1beta1.DeleteBatchPredictionJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteBatchPredictionJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels a BatchPredictionJob.
     * Starts asynchronous cancellation on the BatchPredictionJob. The server
     * makes the best effort to cancel the job, but success is not
     * guaranteed. Clients can use
     * [JobService.GetBatchPredictionJob][google.cloud.aiplatform.v1beta1.JobService.GetBatchPredictionJob]
     * or other methods to check whether the cancellation succeeded or whether the
     * job completed despite cancellation. On a successful cancellation,
     * the BatchPredictionJob is not deleted;instead its
     * [BatchPredictionJob.state][google.cloud.aiplatform.v1beta1.BatchPredictionJob.state]
     * is set to `CANCELLED`. Any files already outputted by the job are not
     * deleted.
     * </pre>
     */
    public void cancelBatchPredictionJob(
        com.google.cloud.aiplatform.v1beta1.CancelBatchPredictionJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelBatchPredictionJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a ModelDeploymentMonitoringJob. It will run periodically on a
     * configured interval.
     * </pre>
     */
    public void createModelDeploymentMonitoringJob(
        com.google.cloud.aiplatform.v1beta1.CreateModelDeploymentMonitoringJobRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.ModelDeploymentMonitoringJob>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateModelDeploymentMonitoringJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches Model Monitoring Statistics generated within a given time window.
     * </pre>
     */
    public void searchModelDeploymentMonitoringStatsAnomalies(
        com.google.cloud.aiplatform.v1beta1.SearchModelDeploymentMonitoringStatsAnomaliesRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1
                    .SearchModelDeploymentMonitoringStatsAnomaliesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(getSearchModelDeploymentMonitoringStatsAnomaliesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a ModelDeploymentMonitoringJob.
     * </pre>
     */
    public void getModelDeploymentMonitoringJob(
        com.google.cloud.aiplatform.v1beta1.GetModelDeploymentMonitoringJobRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.ModelDeploymentMonitoringJob>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetModelDeploymentMonitoringJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ModelDeploymentMonitoringJobs in a Location.
     * </pre>
     */
    public void listModelDeploymentMonitoringJobs(
        com.google.cloud.aiplatform.v1beta1.ListModelDeploymentMonitoringJobsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.ListModelDeploymentMonitoringJobsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListModelDeploymentMonitoringJobsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a ModelDeploymentMonitoringJob.
     * </pre>
     */
    public void updateModelDeploymentMonitoringJob(
        com.google.cloud.aiplatform.v1beta1.UpdateModelDeploymentMonitoringJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateModelDeploymentMonitoringJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ModelDeploymentMonitoringJob.
     * </pre>
     */
    public void deleteModelDeploymentMonitoringJob(
        com.google.cloud.aiplatform.v1beta1.DeleteModelDeploymentMonitoringJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteModelDeploymentMonitoringJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Pauses a ModelDeploymentMonitoringJob. If the job is running, the server
     * makes a best effort to cancel the job. Will mark
     * [ModelDeploymentMonitoringJob.state][google.cloud.aiplatform.v1beta1.ModelDeploymentMonitoringJob.state]
     * to 'PAUSED'.
     * </pre>
     */
    public void pauseModelDeploymentMonitoringJob(
        com.google.cloud.aiplatform.v1beta1.PauseModelDeploymentMonitoringJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPauseModelDeploymentMonitoringJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resumes a paused ModelDeploymentMonitoringJob. It will start to run from
     * next scheduled time. A deleted ModelDeploymentMonitoringJob can't be
     * resumed.
     * </pre>
     */
    public void resumeModelDeploymentMonitoringJob(
        com.google.cloud.aiplatform.v1beta1.ResumeModelDeploymentMonitoringJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResumeModelDeploymentMonitoringJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * A service for creating and managing Vertex AI's jobs.
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
     * Creates a CustomJob. A created CustomJob right away
     * will be attempted to be run.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.CustomJob createCustomJob(
        com.google.cloud.aiplatform.v1beta1.CreateCustomJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCustomJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a CustomJob.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.CustomJob getCustomJob(
        com.google.cloud.aiplatform.v1beta1.GetCustomJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCustomJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists CustomJobs in a Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListCustomJobsResponse listCustomJobs(
        com.google.cloud.aiplatform.v1beta1.ListCustomJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCustomJobsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a CustomJob.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCustomJob(
        com.google.cloud.aiplatform.v1beta1.DeleteCustomJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCustomJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels a CustomJob.
     * Starts asynchronous cancellation on the CustomJob. The server
     * makes a best effort to cancel the job, but success is not
     * guaranteed. Clients can use
     * [JobService.GetCustomJob][google.cloud.aiplatform.v1beta1.JobService.GetCustomJob]
     * or other methods to check whether the cancellation succeeded or whether the
     * job completed despite cancellation. On successful cancellation,
     * the CustomJob is not deleted; instead it becomes a job with
     * a [CustomJob.error][google.cloud.aiplatform.v1beta1.CustomJob.error] value
     * with a [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding
     * to `Code.CANCELLED`, and
     * [CustomJob.state][google.cloud.aiplatform.v1beta1.CustomJob.state] is set
     * to `CANCELLED`.
     * </pre>
     */
    public com.google.protobuf.Empty cancelCustomJob(
        com.google.cloud.aiplatform.v1beta1.CancelCustomJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelCustomJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a DataLabelingJob.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.DataLabelingJob createDataLabelingJob(
        com.google.cloud.aiplatform.v1beta1.CreateDataLabelingJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDataLabelingJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a DataLabelingJob.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.DataLabelingJob getDataLabelingJob(
        com.google.cloud.aiplatform.v1beta1.GetDataLabelingJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataLabelingJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DataLabelingJobs in a Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListDataLabelingJobsResponse listDataLabelingJobs(
        com.google.cloud.aiplatform.v1beta1.ListDataLabelingJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDataLabelingJobsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a DataLabelingJob.
     * </pre>
     */
    public com.google.longrunning.Operation deleteDataLabelingJob(
        com.google.cloud.aiplatform.v1beta1.DeleteDataLabelingJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDataLabelingJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels a DataLabelingJob. Success of cancellation is not guaranteed.
     * </pre>
     */
    public com.google.protobuf.Empty cancelDataLabelingJob(
        com.google.cloud.aiplatform.v1beta1.CancelDataLabelingJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelDataLabelingJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a HyperparameterTuningJob
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.HyperparameterTuningJob
        createHyperparameterTuningJob(
            com.google.cloud.aiplatform.v1beta1.CreateHyperparameterTuningJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateHyperparameterTuningJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a HyperparameterTuningJob
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.HyperparameterTuningJob getHyperparameterTuningJob(
        com.google.cloud.aiplatform.v1beta1.GetHyperparameterTuningJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetHyperparameterTuningJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists HyperparameterTuningJobs in a Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListHyperparameterTuningJobsResponse
        listHyperparameterTuningJobs(
            com.google.cloud.aiplatform.v1beta1.ListHyperparameterTuningJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListHyperparameterTuningJobsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a HyperparameterTuningJob.
     * </pre>
     */
    public com.google.longrunning.Operation deleteHyperparameterTuningJob(
        com.google.cloud.aiplatform.v1beta1.DeleteHyperparameterTuningJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteHyperparameterTuningJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels a HyperparameterTuningJob.
     * Starts asynchronous cancellation on the HyperparameterTuningJob. The server
     * makes a best effort to cancel the job, but success is not
     * guaranteed. Clients can use
     * [JobService.GetHyperparameterTuningJob][google.cloud.aiplatform.v1beta1.JobService.GetHyperparameterTuningJob]
     * or other methods to check whether the cancellation succeeded or whether the
     * job completed despite cancellation. On successful cancellation,
     * the HyperparameterTuningJob is not deleted; instead it becomes a job with
     * a
     * [HyperparameterTuningJob.error][google.cloud.aiplatform.v1beta1.HyperparameterTuningJob.error]
     * value with a [google.rpc.Status.code][google.rpc.Status.code] of 1,
     * corresponding to `Code.CANCELLED`, and
     * [HyperparameterTuningJob.state][google.cloud.aiplatform.v1beta1.HyperparameterTuningJob.state]
     * is set to `CANCELLED`.
     * </pre>
     */
    public com.google.protobuf.Empty cancelHyperparameterTuningJob(
        com.google.cloud.aiplatform.v1beta1.CancelHyperparameterTuningJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelHyperparameterTuningJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a BatchPredictionJob. A BatchPredictionJob once created will
     * right away be attempted to start.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.BatchPredictionJob createBatchPredictionJob(
        com.google.cloud.aiplatform.v1beta1.CreateBatchPredictionJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBatchPredictionJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a BatchPredictionJob
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.BatchPredictionJob getBatchPredictionJob(
        com.google.cloud.aiplatform.v1beta1.GetBatchPredictionJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBatchPredictionJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists BatchPredictionJobs in a Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListBatchPredictionJobsResponse
        listBatchPredictionJobs(
            com.google.cloud.aiplatform.v1beta1.ListBatchPredictionJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBatchPredictionJobsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a BatchPredictionJob. Can only be called on jobs that already
     * finished.
     * </pre>
     */
    public com.google.longrunning.Operation deleteBatchPredictionJob(
        com.google.cloud.aiplatform.v1beta1.DeleteBatchPredictionJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBatchPredictionJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels a BatchPredictionJob.
     * Starts asynchronous cancellation on the BatchPredictionJob. The server
     * makes the best effort to cancel the job, but success is not
     * guaranteed. Clients can use
     * [JobService.GetBatchPredictionJob][google.cloud.aiplatform.v1beta1.JobService.GetBatchPredictionJob]
     * or other methods to check whether the cancellation succeeded or whether the
     * job completed despite cancellation. On a successful cancellation,
     * the BatchPredictionJob is not deleted;instead its
     * [BatchPredictionJob.state][google.cloud.aiplatform.v1beta1.BatchPredictionJob.state]
     * is set to `CANCELLED`. Any files already outputted by the job are not
     * deleted.
     * </pre>
     */
    public com.google.protobuf.Empty cancelBatchPredictionJob(
        com.google.cloud.aiplatform.v1beta1.CancelBatchPredictionJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelBatchPredictionJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a ModelDeploymentMonitoringJob. It will run periodically on a
     * configured interval.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ModelDeploymentMonitoringJob
        createModelDeploymentMonitoringJob(
            com.google.cloud.aiplatform.v1beta1.CreateModelDeploymentMonitoringJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateModelDeploymentMonitoringJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Searches Model Monitoring Statistics generated within a given time window.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.SearchModelDeploymentMonitoringStatsAnomaliesResponse
        searchModelDeploymentMonitoringStatsAnomalies(
            com.google.cloud.aiplatform.v1beta1.SearchModelDeploymentMonitoringStatsAnomaliesRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getSearchModelDeploymentMonitoringStatsAnomaliesMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets a ModelDeploymentMonitoringJob.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ModelDeploymentMonitoringJob
        getModelDeploymentMonitoringJob(
            com.google.cloud.aiplatform.v1beta1.GetModelDeploymentMonitoringJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetModelDeploymentMonitoringJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ModelDeploymentMonitoringJobs in a Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListModelDeploymentMonitoringJobsResponse
        listModelDeploymentMonitoringJobs(
            com.google.cloud.aiplatform.v1beta1.ListModelDeploymentMonitoringJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListModelDeploymentMonitoringJobsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a ModelDeploymentMonitoringJob.
     * </pre>
     */
    public com.google.longrunning.Operation updateModelDeploymentMonitoringJob(
        com.google.cloud.aiplatform.v1beta1.UpdateModelDeploymentMonitoringJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateModelDeploymentMonitoringJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ModelDeploymentMonitoringJob.
     * </pre>
     */
    public com.google.longrunning.Operation deleteModelDeploymentMonitoringJob(
        com.google.cloud.aiplatform.v1beta1.DeleteModelDeploymentMonitoringJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteModelDeploymentMonitoringJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Pauses a ModelDeploymentMonitoringJob. If the job is running, the server
     * makes a best effort to cancel the job. Will mark
     * [ModelDeploymentMonitoringJob.state][google.cloud.aiplatform.v1beta1.ModelDeploymentMonitoringJob.state]
     * to 'PAUSED'.
     * </pre>
     */
    public com.google.protobuf.Empty pauseModelDeploymentMonitoringJob(
        com.google.cloud.aiplatform.v1beta1.PauseModelDeploymentMonitoringJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPauseModelDeploymentMonitoringJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Resumes a paused ModelDeploymentMonitoringJob. It will start to run from
     * next scheduled time. A deleted ModelDeploymentMonitoringJob can't be
     * resumed.
     * </pre>
     */
    public com.google.protobuf.Empty resumeModelDeploymentMonitoringJob(
        com.google.cloud.aiplatform.v1beta1.ResumeModelDeploymentMonitoringJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResumeModelDeploymentMonitoringJobMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * A service for creating and managing Vertex AI's jobs.
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
     * Creates a CustomJob. A created CustomJob right away
     * will be attempted to be run.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.CustomJob>
        createCustomJob(com.google.cloud.aiplatform.v1beta1.CreateCustomJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCustomJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a CustomJob.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.CustomJob>
        getCustomJob(com.google.cloud.aiplatform.v1beta1.GetCustomJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCustomJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists CustomJobs in a Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ListCustomJobsResponse>
        listCustomJobs(com.google.cloud.aiplatform.v1beta1.ListCustomJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCustomJobsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a CustomJob.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteCustomJob(com.google.cloud.aiplatform.v1beta1.DeleteCustomJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCustomJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels a CustomJob.
     * Starts asynchronous cancellation on the CustomJob. The server
     * makes a best effort to cancel the job, but success is not
     * guaranteed. Clients can use
     * [JobService.GetCustomJob][google.cloud.aiplatform.v1beta1.JobService.GetCustomJob]
     * or other methods to check whether the cancellation succeeded or whether the
     * job completed despite cancellation. On successful cancellation,
     * the CustomJob is not deleted; instead it becomes a job with
     * a [CustomJob.error][google.cloud.aiplatform.v1beta1.CustomJob.error] value
     * with a [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding
     * to `Code.CANCELLED`, and
     * [CustomJob.state][google.cloud.aiplatform.v1beta1.CustomJob.state] is set
     * to `CANCELLED`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        cancelCustomJob(com.google.cloud.aiplatform.v1beta1.CancelCustomJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelCustomJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a DataLabelingJob.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.DataLabelingJob>
        createDataLabelingJob(
            com.google.cloud.aiplatform.v1beta1.CreateDataLabelingJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDataLabelingJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a DataLabelingJob.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.DataLabelingJob>
        getDataLabelingJob(com.google.cloud.aiplatform.v1beta1.GetDataLabelingJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataLabelingJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DataLabelingJobs in a Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ListDataLabelingJobsResponse>
        listDataLabelingJobs(
            com.google.cloud.aiplatform.v1beta1.ListDataLabelingJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDataLabelingJobsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a DataLabelingJob.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteDataLabelingJob(
            com.google.cloud.aiplatform.v1beta1.DeleteDataLabelingJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDataLabelingJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels a DataLabelingJob. Success of cancellation is not guaranteed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        cancelDataLabelingJob(
            com.google.cloud.aiplatform.v1beta1.CancelDataLabelingJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelDataLabelingJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a HyperparameterTuningJob
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.HyperparameterTuningJob>
        createHyperparameterTuningJob(
            com.google.cloud.aiplatform.v1beta1.CreateHyperparameterTuningJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateHyperparameterTuningJobMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets a HyperparameterTuningJob
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.HyperparameterTuningJob>
        getHyperparameterTuningJob(
            com.google.cloud.aiplatform.v1beta1.GetHyperparameterTuningJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetHyperparameterTuningJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists HyperparameterTuningJobs in a Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ListHyperparameterTuningJobsResponse>
        listHyperparameterTuningJobs(
            com.google.cloud.aiplatform.v1beta1.ListHyperparameterTuningJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListHyperparameterTuningJobsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a HyperparameterTuningJob.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteHyperparameterTuningJob(
            com.google.cloud.aiplatform.v1beta1.DeleteHyperparameterTuningJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteHyperparameterTuningJobMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Cancels a HyperparameterTuningJob.
     * Starts asynchronous cancellation on the HyperparameterTuningJob. The server
     * makes a best effort to cancel the job, but success is not
     * guaranteed. Clients can use
     * [JobService.GetHyperparameterTuningJob][google.cloud.aiplatform.v1beta1.JobService.GetHyperparameterTuningJob]
     * or other methods to check whether the cancellation succeeded or whether the
     * job completed despite cancellation. On successful cancellation,
     * the HyperparameterTuningJob is not deleted; instead it becomes a job with
     * a
     * [HyperparameterTuningJob.error][google.cloud.aiplatform.v1beta1.HyperparameterTuningJob.error]
     * value with a [google.rpc.Status.code][google.rpc.Status.code] of 1,
     * corresponding to `Code.CANCELLED`, and
     * [HyperparameterTuningJob.state][google.cloud.aiplatform.v1beta1.HyperparameterTuningJob.state]
     * is set to `CANCELLED`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        cancelHyperparameterTuningJob(
            com.google.cloud.aiplatform.v1beta1.CancelHyperparameterTuningJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelHyperparameterTuningJobMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Creates a BatchPredictionJob. A BatchPredictionJob once created will
     * right away be attempted to start.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.BatchPredictionJob>
        createBatchPredictionJob(
            com.google.cloud.aiplatform.v1beta1.CreateBatchPredictionJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBatchPredictionJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a BatchPredictionJob
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.BatchPredictionJob>
        getBatchPredictionJob(
            com.google.cloud.aiplatform.v1beta1.GetBatchPredictionJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBatchPredictionJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists BatchPredictionJobs in a Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ListBatchPredictionJobsResponse>
        listBatchPredictionJobs(
            com.google.cloud.aiplatform.v1beta1.ListBatchPredictionJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBatchPredictionJobsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a BatchPredictionJob. Can only be called on jobs that already
     * finished.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteBatchPredictionJob(
            com.google.cloud.aiplatform.v1beta1.DeleteBatchPredictionJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBatchPredictionJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels a BatchPredictionJob.
     * Starts asynchronous cancellation on the BatchPredictionJob. The server
     * makes the best effort to cancel the job, but success is not
     * guaranteed. Clients can use
     * [JobService.GetBatchPredictionJob][google.cloud.aiplatform.v1beta1.JobService.GetBatchPredictionJob]
     * or other methods to check whether the cancellation succeeded or whether the
     * job completed despite cancellation. On a successful cancellation,
     * the BatchPredictionJob is not deleted;instead its
     * [BatchPredictionJob.state][google.cloud.aiplatform.v1beta1.BatchPredictionJob.state]
     * is set to `CANCELLED`. Any files already outputted by the job are not
     * deleted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        cancelBatchPredictionJob(
            com.google.cloud.aiplatform.v1beta1.CancelBatchPredictionJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelBatchPredictionJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a ModelDeploymentMonitoringJob. It will run periodically on a
     * configured interval.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ModelDeploymentMonitoringJob>
        createModelDeploymentMonitoringJob(
            com.google.cloud.aiplatform.v1beta1.CreateModelDeploymentMonitoringJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateModelDeploymentMonitoringJobMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Searches Model Monitoring Statistics generated within a given time window.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1
                .SearchModelDeploymentMonitoringStatsAnomaliesResponse>
        searchModelDeploymentMonitoringStatsAnomalies(
            com.google.cloud.aiplatform.v1beta1.SearchModelDeploymentMonitoringStatsAnomaliesRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getSearchModelDeploymentMonitoringStatsAnomaliesMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets a ModelDeploymentMonitoringJob.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ModelDeploymentMonitoringJob>
        getModelDeploymentMonitoringJob(
            com.google.cloud.aiplatform.v1beta1.GetModelDeploymentMonitoringJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetModelDeploymentMonitoringJobMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists ModelDeploymentMonitoringJobs in a Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ListModelDeploymentMonitoringJobsResponse>
        listModelDeploymentMonitoringJobs(
            com.google.cloud.aiplatform.v1beta1.ListModelDeploymentMonitoringJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListModelDeploymentMonitoringJobsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Updates a ModelDeploymentMonitoringJob.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateModelDeploymentMonitoringJob(
            com.google.cloud.aiplatform.v1beta1.UpdateModelDeploymentMonitoringJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateModelDeploymentMonitoringJobMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ModelDeploymentMonitoringJob.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteModelDeploymentMonitoringJob(
            com.google.cloud.aiplatform.v1beta1.DeleteModelDeploymentMonitoringJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteModelDeploymentMonitoringJobMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Pauses a ModelDeploymentMonitoringJob. If the job is running, the server
     * makes a best effort to cancel the job. Will mark
     * [ModelDeploymentMonitoringJob.state][google.cloud.aiplatform.v1beta1.ModelDeploymentMonitoringJob.state]
     * to 'PAUSED'.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        pauseModelDeploymentMonitoringJob(
            com.google.cloud.aiplatform.v1beta1.PauseModelDeploymentMonitoringJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPauseModelDeploymentMonitoringJobMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Resumes a paused ModelDeploymentMonitoringJob. It will start to run from
     * next scheduled time. A deleted ModelDeploymentMonitoringJob can't be
     * resumed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        resumeModelDeploymentMonitoringJob(
            com.google.cloud.aiplatform.v1beta1.ResumeModelDeploymentMonitoringJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResumeModelDeploymentMonitoringJobMethod(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_CREATE_CUSTOM_JOB = 0;
  private static final int METHODID_GET_CUSTOM_JOB = 1;
  private static final int METHODID_LIST_CUSTOM_JOBS = 2;
  private static final int METHODID_DELETE_CUSTOM_JOB = 3;
  private static final int METHODID_CANCEL_CUSTOM_JOB = 4;
  private static final int METHODID_CREATE_DATA_LABELING_JOB = 5;
  private static final int METHODID_GET_DATA_LABELING_JOB = 6;
  private static final int METHODID_LIST_DATA_LABELING_JOBS = 7;
  private static final int METHODID_DELETE_DATA_LABELING_JOB = 8;
  private static final int METHODID_CANCEL_DATA_LABELING_JOB = 9;
  private static final int METHODID_CREATE_HYPERPARAMETER_TUNING_JOB = 10;
  private static final int METHODID_GET_HYPERPARAMETER_TUNING_JOB = 11;
  private static final int METHODID_LIST_HYPERPARAMETER_TUNING_JOBS = 12;
  private static final int METHODID_DELETE_HYPERPARAMETER_TUNING_JOB = 13;
  private static final int METHODID_CANCEL_HYPERPARAMETER_TUNING_JOB = 14;
  private static final int METHODID_CREATE_BATCH_PREDICTION_JOB = 15;
  private static final int METHODID_GET_BATCH_PREDICTION_JOB = 16;
  private static final int METHODID_LIST_BATCH_PREDICTION_JOBS = 17;
  private static final int METHODID_DELETE_BATCH_PREDICTION_JOB = 18;
  private static final int METHODID_CANCEL_BATCH_PREDICTION_JOB = 19;
  private static final int METHODID_CREATE_MODEL_DEPLOYMENT_MONITORING_JOB = 20;
  private static final int METHODID_SEARCH_MODEL_DEPLOYMENT_MONITORING_STATS_ANOMALIES = 21;
  private static final int METHODID_GET_MODEL_DEPLOYMENT_MONITORING_JOB = 22;
  private static final int METHODID_LIST_MODEL_DEPLOYMENT_MONITORING_JOBS = 23;
  private static final int METHODID_UPDATE_MODEL_DEPLOYMENT_MONITORING_JOB = 24;
  private static final int METHODID_DELETE_MODEL_DEPLOYMENT_MONITORING_JOB = 25;
  private static final int METHODID_PAUSE_MODEL_DEPLOYMENT_MONITORING_JOB = 26;
  private static final int METHODID_RESUME_MODEL_DEPLOYMENT_MONITORING_JOB = 27;

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
        case METHODID_CREATE_CUSTOM_JOB:
          serviceImpl.createCustomJob(
              (com.google.cloud.aiplatform.v1beta1.CreateCustomJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.CustomJob>)
                  responseObserver);
          break;
        case METHODID_GET_CUSTOM_JOB:
          serviceImpl.getCustomJob(
              (com.google.cloud.aiplatform.v1beta1.GetCustomJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.CustomJob>)
                  responseObserver);
          break;
        case METHODID_LIST_CUSTOM_JOBS:
          serviceImpl.listCustomJobs(
              (com.google.cloud.aiplatform.v1beta1.ListCustomJobsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ListCustomJobsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_CUSTOM_JOB:
          serviceImpl.deleteCustomJob(
              (com.google.cloud.aiplatform.v1beta1.DeleteCustomJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CANCEL_CUSTOM_JOB:
          serviceImpl.cancelCustomJob(
              (com.google.cloud.aiplatform.v1beta1.CancelCustomJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_DATA_LABELING_JOB:
          serviceImpl.createDataLabelingJob(
              (com.google.cloud.aiplatform.v1beta1.CreateDataLabelingJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.DataLabelingJob>)
                  responseObserver);
          break;
        case METHODID_GET_DATA_LABELING_JOB:
          serviceImpl.getDataLabelingJob(
              (com.google.cloud.aiplatform.v1beta1.GetDataLabelingJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.DataLabelingJob>)
                  responseObserver);
          break;
        case METHODID_LIST_DATA_LABELING_JOBS:
          serviceImpl.listDataLabelingJobs(
              (com.google.cloud.aiplatform.v1beta1.ListDataLabelingJobsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ListDataLabelingJobsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_DATA_LABELING_JOB:
          serviceImpl.deleteDataLabelingJob(
              (com.google.cloud.aiplatform.v1beta1.DeleteDataLabelingJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CANCEL_DATA_LABELING_JOB:
          serviceImpl.cancelDataLabelingJob(
              (com.google.cloud.aiplatform.v1beta1.CancelDataLabelingJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_HYPERPARAMETER_TUNING_JOB:
          serviceImpl.createHyperparameterTuningJob(
              (com.google.cloud.aiplatform.v1beta1.CreateHyperparameterTuningJobRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.HyperparameterTuningJob>)
                  responseObserver);
          break;
        case METHODID_GET_HYPERPARAMETER_TUNING_JOB:
          serviceImpl.getHyperparameterTuningJob(
              (com.google.cloud.aiplatform.v1beta1.GetHyperparameterTuningJobRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.HyperparameterTuningJob>)
                  responseObserver);
          break;
        case METHODID_LIST_HYPERPARAMETER_TUNING_JOBS:
          serviceImpl.listHyperparameterTuningJobs(
              (com.google.cloud.aiplatform.v1beta1.ListHyperparameterTuningJobsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ListHyperparameterTuningJobsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_HYPERPARAMETER_TUNING_JOB:
          serviceImpl.deleteHyperparameterTuningJob(
              (com.google.cloud.aiplatform.v1beta1.DeleteHyperparameterTuningJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CANCEL_HYPERPARAMETER_TUNING_JOB:
          serviceImpl.cancelHyperparameterTuningJob(
              (com.google.cloud.aiplatform.v1beta1.CancelHyperparameterTuningJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_BATCH_PREDICTION_JOB:
          serviceImpl.createBatchPredictionJob(
              (com.google.cloud.aiplatform.v1beta1.CreateBatchPredictionJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.BatchPredictionJob>)
                  responseObserver);
          break;
        case METHODID_GET_BATCH_PREDICTION_JOB:
          serviceImpl.getBatchPredictionJob(
              (com.google.cloud.aiplatform.v1beta1.GetBatchPredictionJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.BatchPredictionJob>)
                  responseObserver);
          break;
        case METHODID_LIST_BATCH_PREDICTION_JOBS:
          serviceImpl.listBatchPredictionJobs(
              (com.google.cloud.aiplatform.v1beta1.ListBatchPredictionJobsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ListBatchPredictionJobsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_BATCH_PREDICTION_JOB:
          serviceImpl.deleteBatchPredictionJob(
              (com.google.cloud.aiplatform.v1beta1.DeleteBatchPredictionJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CANCEL_BATCH_PREDICTION_JOB:
          serviceImpl.cancelBatchPredictionJob(
              (com.google.cloud.aiplatform.v1beta1.CancelBatchPredictionJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_MODEL_DEPLOYMENT_MONITORING_JOB:
          serviceImpl.createModelDeploymentMonitoringJob(
              (com.google.cloud.aiplatform.v1beta1.CreateModelDeploymentMonitoringJobRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ModelDeploymentMonitoringJob>)
                  responseObserver);
          break;
        case METHODID_SEARCH_MODEL_DEPLOYMENT_MONITORING_STATS_ANOMALIES:
          serviceImpl.searchModelDeploymentMonitoringStatsAnomalies(
              (com.google.cloud.aiplatform.v1beta1
                      .SearchModelDeploymentMonitoringStatsAnomaliesRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1
                          .SearchModelDeploymentMonitoringStatsAnomaliesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_MODEL_DEPLOYMENT_MONITORING_JOB:
          serviceImpl.getModelDeploymentMonitoringJob(
              (com.google.cloud.aiplatform.v1beta1.GetModelDeploymentMonitoringJobRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ModelDeploymentMonitoringJob>)
                  responseObserver);
          break;
        case METHODID_LIST_MODEL_DEPLOYMENT_MONITORING_JOBS:
          serviceImpl.listModelDeploymentMonitoringJobs(
              (com.google.cloud.aiplatform.v1beta1.ListModelDeploymentMonitoringJobsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1
                          .ListModelDeploymentMonitoringJobsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_MODEL_DEPLOYMENT_MONITORING_JOB:
          serviceImpl.updateModelDeploymentMonitoringJob(
              (com.google.cloud.aiplatform.v1beta1.UpdateModelDeploymentMonitoringJobRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_MODEL_DEPLOYMENT_MONITORING_JOB:
          serviceImpl.deleteModelDeploymentMonitoringJob(
              (com.google.cloud.aiplatform.v1beta1.DeleteModelDeploymentMonitoringJobRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_PAUSE_MODEL_DEPLOYMENT_MONITORING_JOB:
          serviceImpl.pauseModelDeploymentMonitoringJob(
              (com.google.cloud.aiplatform.v1beta1.PauseModelDeploymentMonitoringJobRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_RESUME_MODEL_DEPLOYMENT_MONITORING_JOB:
          serviceImpl.resumeModelDeploymentMonitoringJob(
              (com.google.cloud.aiplatform.v1beta1.ResumeModelDeploymentMonitoringJobRequest)
                  request,
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

  private abstract static class JobServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    JobServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1beta1.JobServiceProto.getDescriptor();
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
                      .addMethod(getCreateCustomJobMethod())
                      .addMethod(getGetCustomJobMethod())
                      .addMethod(getListCustomJobsMethod())
                      .addMethod(getDeleteCustomJobMethod())
                      .addMethod(getCancelCustomJobMethod())
                      .addMethod(getCreateDataLabelingJobMethod())
                      .addMethod(getGetDataLabelingJobMethod())
                      .addMethod(getListDataLabelingJobsMethod())
                      .addMethod(getDeleteDataLabelingJobMethod())
                      .addMethod(getCancelDataLabelingJobMethod())
                      .addMethod(getCreateHyperparameterTuningJobMethod())
                      .addMethod(getGetHyperparameterTuningJobMethod())
                      .addMethod(getListHyperparameterTuningJobsMethod())
                      .addMethod(getDeleteHyperparameterTuningJobMethod())
                      .addMethod(getCancelHyperparameterTuningJobMethod())
                      .addMethod(getCreateBatchPredictionJobMethod())
                      .addMethod(getGetBatchPredictionJobMethod())
                      .addMethod(getListBatchPredictionJobsMethod())
                      .addMethod(getDeleteBatchPredictionJobMethod())
                      .addMethod(getCancelBatchPredictionJobMethod())
                      .addMethod(getCreateModelDeploymentMonitoringJobMethod())
                      .addMethod(getSearchModelDeploymentMonitoringStatsAnomaliesMethod())
                      .addMethod(getGetModelDeploymentMonitoringJobMethod())
                      .addMethod(getListModelDeploymentMonitoringJobsMethod())
                      .addMethod(getUpdateModelDeploymentMonitoringJobMethod())
                      .addMethod(getDeleteModelDeploymentMonitoringJobMethod())
                      .addMethod(getPauseModelDeploymentMonitoringJobMethod())
                      .addMethod(getResumeModelDeploymentMonitoringJobMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
