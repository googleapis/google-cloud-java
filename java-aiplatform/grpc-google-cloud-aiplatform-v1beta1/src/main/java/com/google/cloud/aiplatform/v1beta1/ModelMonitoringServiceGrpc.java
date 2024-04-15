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
package com.google.cloud.aiplatform.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A service for creating and managing Vertex AI Model moitoring. This includes
 * `ModelMonitor` resources, `ModelMonitoringJob` resources.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1beta1/model_monitoring_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ModelMonitoringServiceGrpc {

  private ModelMonitoringServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.aiplatform.v1beta1.ModelMonitoringService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateModelMonitorRequest,
          com.google.longrunning.Operation>
      getCreateModelMonitorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateModelMonitor",
      requestType = com.google.cloud.aiplatform.v1beta1.CreateModelMonitorRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateModelMonitorRequest,
          com.google.longrunning.Operation>
      getCreateModelMonitorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.CreateModelMonitorRequest,
            com.google.longrunning.Operation>
        getCreateModelMonitorMethod;
    if ((getCreateModelMonitorMethod = ModelMonitoringServiceGrpc.getCreateModelMonitorMethod)
        == null) {
      synchronized (ModelMonitoringServiceGrpc.class) {
        if ((getCreateModelMonitorMethod = ModelMonitoringServiceGrpc.getCreateModelMonitorMethod)
            == null) {
          ModelMonitoringServiceGrpc.getCreateModelMonitorMethod =
              getCreateModelMonitorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.CreateModelMonitorRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateModelMonitor"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.CreateModelMonitorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ModelMonitoringServiceMethodDescriptorSupplier("CreateModelMonitor"))
                      .build();
        }
      }
    }
    return getCreateModelMonitorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateModelMonitorRequest,
          com.google.longrunning.Operation>
      getUpdateModelMonitorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateModelMonitor",
      requestType = com.google.cloud.aiplatform.v1beta1.UpdateModelMonitorRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateModelMonitorRequest,
          com.google.longrunning.Operation>
      getUpdateModelMonitorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.UpdateModelMonitorRequest,
            com.google.longrunning.Operation>
        getUpdateModelMonitorMethod;
    if ((getUpdateModelMonitorMethod = ModelMonitoringServiceGrpc.getUpdateModelMonitorMethod)
        == null) {
      synchronized (ModelMonitoringServiceGrpc.class) {
        if ((getUpdateModelMonitorMethod = ModelMonitoringServiceGrpc.getUpdateModelMonitorMethod)
            == null) {
          ModelMonitoringServiceGrpc.getUpdateModelMonitorMethod =
              getUpdateModelMonitorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.UpdateModelMonitorRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateModelMonitor"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.UpdateModelMonitorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ModelMonitoringServiceMethodDescriptorSupplier("UpdateModelMonitor"))
                      .build();
        }
      }
    }
    return getUpdateModelMonitorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetModelMonitorRequest,
          com.google.cloud.aiplatform.v1beta1.ModelMonitor>
      getGetModelMonitorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetModelMonitor",
      requestType = com.google.cloud.aiplatform.v1beta1.GetModelMonitorRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ModelMonitor.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetModelMonitorRequest,
          com.google.cloud.aiplatform.v1beta1.ModelMonitor>
      getGetModelMonitorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetModelMonitorRequest,
            com.google.cloud.aiplatform.v1beta1.ModelMonitor>
        getGetModelMonitorMethod;
    if ((getGetModelMonitorMethod = ModelMonitoringServiceGrpc.getGetModelMonitorMethod) == null) {
      synchronized (ModelMonitoringServiceGrpc.class) {
        if ((getGetModelMonitorMethod = ModelMonitoringServiceGrpc.getGetModelMonitorMethod)
            == null) {
          ModelMonitoringServiceGrpc.getGetModelMonitorMethod =
              getGetModelMonitorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GetModelMonitorRequest,
                          com.google.cloud.aiplatform.v1beta1.ModelMonitor>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetModelMonitor"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.GetModelMonitorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ModelMonitor
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ModelMonitoringServiceMethodDescriptorSupplier("GetModelMonitor"))
                      .build();
        }
      }
    }
    return getGetModelMonitorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListModelMonitorsRequest,
          com.google.cloud.aiplatform.v1beta1.ListModelMonitorsResponse>
      getListModelMonitorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListModelMonitors",
      requestType = com.google.cloud.aiplatform.v1beta1.ListModelMonitorsRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListModelMonitorsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListModelMonitorsRequest,
          com.google.cloud.aiplatform.v1beta1.ListModelMonitorsResponse>
      getListModelMonitorsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListModelMonitorsRequest,
            com.google.cloud.aiplatform.v1beta1.ListModelMonitorsResponse>
        getListModelMonitorsMethod;
    if ((getListModelMonitorsMethod = ModelMonitoringServiceGrpc.getListModelMonitorsMethod)
        == null) {
      synchronized (ModelMonitoringServiceGrpc.class) {
        if ((getListModelMonitorsMethod = ModelMonitoringServiceGrpc.getListModelMonitorsMethod)
            == null) {
          ModelMonitoringServiceGrpc.getListModelMonitorsMethod =
              getListModelMonitorsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ListModelMonitorsRequest,
                          com.google.cloud.aiplatform.v1beta1.ListModelMonitorsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListModelMonitors"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListModelMonitorsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListModelMonitorsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ModelMonitoringServiceMethodDescriptorSupplier("ListModelMonitors"))
                      .build();
        }
      }
    }
    return getListModelMonitorsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteModelMonitorRequest,
          com.google.longrunning.Operation>
      getDeleteModelMonitorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteModelMonitor",
      requestType = com.google.cloud.aiplatform.v1beta1.DeleteModelMonitorRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteModelMonitorRequest,
          com.google.longrunning.Operation>
      getDeleteModelMonitorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeleteModelMonitorRequest,
            com.google.longrunning.Operation>
        getDeleteModelMonitorMethod;
    if ((getDeleteModelMonitorMethod = ModelMonitoringServiceGrpc.getDeleteModelMonitorMethod)
        == null) {
      synchronized (ModelMonitoringServiceGrpc.class) {
        if ((getDeleteModelMonitorMethod = ModelMonitoringServiceGrpc.getDeleteModelMonitorMethod)
            == null) {
          ModelMonitoringServiceGrpc.getDeleteModelMonitorMethod =
              getDeleteModelMonitorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.DeleteModelMonitorRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteModelMonitor"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.DeleteModelMonitorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ModelMonitoringServiceMethodDescriptorSupplier("DeleteModelMonitor"))
                      .build();
        }
      }
    }
    return getDeleteModelMonitorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateModelMonitoringJobRequest,
          com.google.cloud.aiplatform.v1beta1.ModelMonitoringJob>
      getCreateModelMonitoringJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateModelMonitoringJob",
      requestType = com.google.cloud.aiplatform.v1beta1.CreateModelMonitoringJobRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ModelMonitoringJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateModelMonitoringJobRequest,
          com.google.cloud.aiplatform.v1beta1.ModelMonitoringJob>
      getCreateModelMonitoringJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.CreateModelMonitoringJobRequest,
            com.google.cloud.aiplatform.v1beta1.ModelMonitoringJob>
        getCreateModelMonitoringJobMethod;
    if ((getCreateModelMonitoringJobMethod =
            ModelMonitoringServiceGrpc.getCreateModelMonitoringJobMethod)
        == null) {
      synchronized (ModelMonitoringServiceGrpc.class) {
        if ((getCreateModelMonitoringJobMethod =
                ModelMonitoringServiceGrpc.getCreateModelMonitoringJobMethod)
            == null) {
          ModelMonitoringServiceGrpc.getCreateModelMonitoringJobMethod =
              getCreateModelMonitoringJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.CreateModelMonitoringJobRequest,
                          com.google.cloud.aiplatform.v1beta1.ModelMonitoringJob>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateModelMonitoringJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.CreateModelMonitoringJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ModelMonitoringJob
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ModelMonitoringServiceMethodDescriptorSupplier(
                              "CreateModelMonitoringJob"))
                      .build();
        }
      }
    }
    return getCreateModelMonitoringJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetModelMonitoringJobRequest,
          com.google.cloud.aiplatform.v1beta1.ModelMonitoringJob>
      getGetModelMonitoringJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetModelMonitoringJob",
      requestType = com.google.cloud.aiplatform.v1beta1.GetModelMonitoringJobRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ModelMonitoringJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetModelMonitoringJobRequest,
          com.google.cloud.aiplatform.v1beta1.ModelMonitoringJob>
      getGetModelMonitoringJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetModelMonitoringJobRequest,
            com.google.cloud.aiplatform.v1beta1.ModelMonitoringJob>
        getGetModelMonitoringJobMethod;
    if ((getGetModelMonitoringJobMethod = ModelMonitoringServiceGrpc.getGetModelMonitoringJobMethod)
        == null) {
      synchronized (ModelMonitoringServiceGrpc.class) {
        if ((getGetModelMonitoringJobMethod =
                ModelMonitoringServiceGrpc.getGetModelMonitoringJobMethod)
            == null) {
          ModelMonitoringServiceGrpc.getGetModelMonitoringJobMethod =
              getGetModelMonitoringJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GetModelMonitoringJobRequest,
                          com.google.cloud.aiplatform.v1beta1.ModelMonitoringJob>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetModelMonitoringJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.GetModelMonitoringJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ModelMonitoringJob
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ModelMonitoringServiceMethodDescriptorSupplier(
                              "GetModelMonitoringJob"))
                      .build();
        }
      }
    }
    return getGetModelMonitoringJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListModelMonitoringJobsRequest,
          com.google.cloud.aiplatform.v1beta1.ListModelMonitoringJobsResponse>
      getListModelMonitoringJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListModelMonitoringJobs",
      requestType = com.google.cloud.aiplatform.v1beta1.ListModelMonitoringJobsRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListModelMonitoringJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListModelMonitoringJobsRequest,
          com.google.cloud.aiplatform.v1beta1.ListModelMonitoringJobsResponse>
      getListModelMonitoringJobsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListModelMonitoringJobsRequest,
            com.google.cloud.aiplatform.v1beta1.ListModelMonitoringJobsResponse>
        getListModelMonitoringJobsMethod;
    if ((getListModelMonitoringJobsMethod =
            ModelMonitoringServiceGrpc.getListModelMonitoringJobsMethod)
        == null) {
      synchronized (ModelMonitoringServiceGrpc.class) {
        if ((getListModelMonitoringJobsMethod =
                ModelMonitoringServiceGrpc.getListModelMonitoringJobsMethod)
            == null) {
          ModelMonitoringServiceGrpc.getListModelMonitoringJobsMethod =
              getListModelMonitoringJobsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ListModelMonitoringJobsRequest,
                          com.google.cloud.aiplatform.v1beta1.ListModelMonitoringJobsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListModelMonitoringJobs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListModelMonitoringJobsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListModelMonitoringJobsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ModelMonitoringServiceMethodDescriptorSupplier(
                              "ListModelMonitoringJobs"))
                      .build();
        }
      }
    }
    return getListModelMonitoringJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteModelMonitoringJobRequest,
          com.google.longrunning.Operation>
      getDeleteModelMonitoringJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteModelMonitoringJob",
      requestType = com.google.cloud.aiplatform.v1beta1.DeleteModelMonitoringJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteModelMonitoringJobRequest,
          com.google.longrunning.Operation>
      getDeleteModelMonitoringJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeleteModelMonitoringJobRequest,
            com.google.longrunning.Operation>
        getDeleteModelMonitoringJobMethod;
    if ((getDeleteModelMonitoringJobMethod =
            ModelMonitoringServiceGrpc.getDeleteModelMonitoringJobMethod)
        == null) {
      synchronized (ModelMonitoringServiceGrpc.class) {
        if ((getDeleteModelMonitoringJobMethod =
                ModelMonitoringServiceGrpc.getDeleteModelMonitoringJobMethod)
            == null) {
          ModelMonitoringServiceGrpc.getDeleteModelMonitoringJobMethod =
              getDeleteModelMonitoringJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.DeleteModelMonitoringJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteModelMonitoringJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.DeleteModelMonitoringJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ModelMonitoringServiceMethodDescriptorSupplier(
                              "DeleteModelMonitoringJob"))
                      .build();
        }
      }
    }
    return getDeleteModelMonitoringJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringStatsRequest,
          com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringStatsResponse>
      getSearchModelMonitoringStatsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchModelMonitoringStats",
      requestType = com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringStatsRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringStatsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringStatsRequest,
          com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringStatsResponse>
      getSearchModelMonitoringStatsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringStatsRequest,
            com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringStatsResponse>
        getSearchModelMonitoringStatsMethod;
    if ((getSearchModelMonitoringStatsMethod =
            ModelMonitoringServiceGrpc.getSearchModelMonitoringStatsMethod)
        == null) {
      synchronized (ModelMonitoringServiceGrpc.class) {
        if ((getSearchModelMonitoringStatsMethod =
                ModelMonitoringServiceGrpc.getSearchModelMonitoringStatsMethod)
            == null) {
          ModelMonitoringServiceGrpc.getSearchModelMonitoringStatsMethod =
              getSearchModelMonitoringStatsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringStatsRequest,
                          com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringStatsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SearchModelMonitoringStats"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringStatsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringStatsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ModelMonitoringServiceMethodDescriptorSupplier(
                              "SearchModelMonitoringStats"))
                      .build();
        }
      }
    }
    return getSearchModelMonitoringStatsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringAlertsRequest,
          com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringAlertsResponse>
      getSearchModelMonitoringAlertsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchModelMonitoringAlerts",
      requestType = com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringAlertsRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringAlertsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringAlertsRequest,
          com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringAlertsResponse>
      getSearchModelMonitoringAlertsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringAlertsRequest,
            com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringAlertsResponse>
        getSearchModelMonitoringAlertsMethod;
    if ((getSearchModelMonitoringAlertsMethod =
            ModelMonitoringServiceGrpc.getSearchModelMonitoringAlertsMethod)
        == null) {
      synchronized (ModelMonitoringServiceGrpc.class) {
        if ((getSearchModelMonitoringAlertsMethod =
                ModelMonitoringServiceGrpc.getSearchModelMonitoringAlertsMethod)
            == null) {
          ModelMonitoringServiceGrpc.getSearchModelMonitoringAlertsMethod =
              getSearchModelMonitoringAlertsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringAlertsRequest,
                          com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringAlertsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SearchModelMonitoringAlerts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringAlertsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1
                                  .SearchModelMonitoringAlertsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ModelMonitoringServiceMethodDescriptorSupplier(
                              "SearchModelMonitoringAlerts"))
                      .build();
        }
      }
    }
    return getSearchModelMonitoringAlertsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ModelMonitoringServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ModelMonitoringServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ModelMonitoringServiceStub>() {
          @java.lang.Override
          public ModelMonitoringServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ModelMonitoringServiceStub(channel, callOptions);
          }
        };
    return ModelMonitoringServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ModelMonitoringServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ModelMonitoringServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ModelMonitoringServiceBlockingStub>() {
          @java.lang.Override
          public ModelMonitoringServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ModelMonitoringServiceBlockingStub(channel, callOptions);
          }
        };
    return ModelMonitoringServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ModelMonitoringServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ModelMonitoringServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ModelMonitoringServiceFutureStub>() {
          @java.lang.Override
          public ModelMonitoringServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ModelMonitoringServiceFutureStub(channel, callOptions);
          }
        };
    return ModelMonitoringServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * A service for creating and managing Vertex AI Model moitoring. This includes
   * `ModelMonitor` resources, `ModelMonitoringJob` resources.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a ModelMonitor.
     * </pre>
     */
    default void createModelMonitor(
        com.google.cloud.aiplatform.v1beta1.CreateModelMonitorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateModelMonitorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a ModelMonitor.
     * </pre>
     */
    default void updateModelMonitor(
        com.google.cloud.aiplatform.v1beta1.UpdateModelMonitorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateModelMonitorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a ModelMonitor.
     * </pre>
     */
    default void getModelMonitor(
        com.google.cloud.aiplatform.v1beta1.GetModelMonitorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ModelMonitor>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetModelMonitorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ModelMonitors in a Location.
     * </pre>
     */
    default void listModelMonitors(
        com.google.cloud.aiplatform.v1beta1.ListModelMonitorsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListModelMonitorsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListModelMonitorsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ModelMonitor.
     * </pre>
     */
    default void deleteModelMonitor(
        com.google.cloud.aiplatform.v1beta1.DeleteModelMonitorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteModelMonitorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a ModelMonitoringJob.
     * </pre>
     */
    default void createModelMonitoringJob(
        com.google.cloud.aiplatform.v1beta1.CreateModelMonitoringJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ModelMonitoringJob>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateModelMonitoringJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a ModelMonitoringJob.
     * </pre>
     */
    default void getModelMonitoringJob(
        com.google.cloud.aiplatform.v1beta1.GetModelMonitoringJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ModelMonitoringJob>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetModelMonitoringJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ModelMonitoringJobs.
     * Callers may choose to read across multiple Monitors as per
     * [AIP-159](https://google.aip.dev/159) by using '-' (the hyphen or dash
     * character) as a wildcard character instead of modelMonitor id in the
     * parent. Format
     * `projects/{project_id}/locations/{location}/moodelMonitors/-/modelMonitoringJobs`
     * </pre>
     */
    default void listModelMonitoringJobs(
        com.google.cloud.aiplatform.v1beta1.ListModelMonitoringJobsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.ListModelMonitoringJobsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListModelMonitoringJobsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ModelMonitoringJob.
     * </pre>
     */
    default void deleteModelMonitoringJob(
        com.google.cloud.aiplatform.v1beta1.DeleteModelMonitoringJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteModelMonitoringJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches Model Monitoring Stats generated within a given time window.
     * </pre>
     */
    default void searchModelMonitoringStats(
        com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringStatsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringStatsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchModelMonitoringStatsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the Model Monitoring alerts.
     * </pre>
     */
    default void searchModelMonitoringAlerts(
        com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringAlertsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringAlertsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchModelMonitoringAlertsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ModelMonitoringService.
   *
   * <pre>
   * A service for creating and managing Vertex AI Model moitoring. This includes
   * `ModelMonitor` resources, `ModelMonitoringJob` resources.
   * </pre>
   */
  public abstract static class ModelMonitoringServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ModelMonitoringServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ModelMonitoringService.
   *
   * <pre>
   * A service for creating and managing Vertex AI Model moitoring. This includes
   * `ModelMonitor` resources, `ModelMonitoringJob` resources.
   * </pre>
   */
  public static final class ModelMonitoringServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ModelMonitoringServiceStub> {
    private ModelMonitoringServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ModelMonitoringServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ModelMonitoringServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a ModelMonitor.
     * </pre>
     */
    public void createModelMonitor(
        com.google.cloud.aiplatform.v1beta1.CreateModelMonitorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateModelMonitorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a ModelMonitor.
     * </pre>
     */
    public void updateModelMonitor(
        com.google.cloud.aiplatform.v1beta1.UpdateModelMonitorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateModelMonitorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a ModelMonitor.
     * </pre>
     */
    public void getModelMonitor(
        com.google.cloud.aiplatform.v1beta1.GetModelMonitorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ModelMonitor>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetModelMonitorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ModelMonitors in a Location.
     * </pre>
     */
    public void listModelMonitors(
        com.google.cloud.aiplatform.v1beta1.ListModelMonitorsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListModelMonitorsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListModelMonitorsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ModelMonitor.
     * </pre>
     */
    public void deleteModelMonitor(
        com.google.cloud.aiplatform.v1beta1.DeleteModelMonitorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteModelMonitorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a ModelMonitoringJob.
     * </pre>
     */
    public void createModelMonitoringJob(
        com.google.cloud.aiplatform.v1beta1.CreateModelMonitoringJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ModelMonitoringJob>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateModelMonitoringJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a ModelMonitoringJob.
     * </pre>
     */
    public void getModelMonitoringJob(
        com.google.cloud.aiplatform.v1beta1.GetModelMonitoringJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ModelMonitoringJob>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetModelMonitoringJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ModelMonitoringJobs.
     * Callers may choose to read across multiple Monitors as per
     * [AIP-159](https://google.aip.dev/159) by using '-' (the hyphen or dash
     * character) as a wildcard character instead of modelMonitor id in the
     * parent. Format
     * `projects/{project_id}/locations/{location}/moodelMonitors/-/modelMonitoringJobs`
     * </pre>
     */
    public void listModelMonitoringJobs(
        com.google.cloud.aiplatform.v1beta1.ListModelMonitoringJobsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.ListModelMonitoringJobsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListModelMonitoringJobsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ModelMonitoringJob.
     * </pre>
     */
    public void deleteModelMonitoringJob(
        com.google.cloud.aiplatform.v1beta1.DeleteModelMonitoringJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteModelMonitoringJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches Model Monitoring Stats generated within a given time window.
     * </pre>
     */
    public void searchModelMonitoringStats(
        com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringStatsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringStatsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchModelMonitoringStatsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the Model Monitoring alerts.
     * </pre>
     */
    public void searchModelMonitoringAlerts(
        com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringAlertsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringAlertsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchModelMonitoringAlertsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ModelMonitoringService.
   *
   * <pre>
   * A service for creating and managing Vertex AI Model moitoring. This includes
   * `ModelMonitor` resources, `ModelMonitoringJob` resources.
   * </pre>
   */
  public static final class ModelMonitoringServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ModelMonitoringServiceBlockingStub> {
    private ModelMonitoringServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ModelMonitoringServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ModelMonitoringServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a ModelMonitor.
     * </pre>
     */
    public com.google.longrunning.Operation createModelMonitor(
        com.google.cloud.aiplatform.v1beta1.CreateModelMonitorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateModelMonitorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a ModelMonitor.
     * </pre>
     */
    public com.google.longrunning.Operation updateModelMonitor(
        com.google.cloud.aiplatform.v1beta1.UpdateModelMonitorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateModelMonitorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a ModelMonitor.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ModelMonitor getModelMonitor(
        com.google.cloud.aiplatform.v1beta1.GetModelMonitorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetModelMonitorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ModelMonitors in a Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListModelMonitorsResponse listModelMonitors(
        com.google.cloud.aiplatform.v1beta1.ListModelMonitorsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListModelMonitorsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ModelMonitor.
     * </pre>
     */
    public com.google.longrunning.Operation deleteModelMonitor(
        com.google.cloud.aiplatform.v1beta1.DeleteModelMonitorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteModelMonitorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a ModelMonitoringJob.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ModelMonitoringJob createModelMonitoringJob(
        com.google.cloud.aiplatform.v1beta1.CreateModelMonitoringJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateModelMonitoringJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a ModelMonitoringJob.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ModelMonitoringJob getModelMonitoringJob(
        com.google.cloud.aiplatform.v1beta1.GetModelMonitoringJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetModelMonitoringJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ModelMonitoringJobs.
     * Callers may choose to read across multiple Monitors as per
     * [AIP-159](https://google.aip.dev/159) by using '-' (the hyphen or dash
     * character) as a wildcard character instead of modelMonitor id in the
     * parent. Format
     * `projects/{project_id}/locations/{location}/moodelMonitors/-/modelMonitoringJobs`
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListModelMonitoringJobsResponse
        listModelMonitoringJobs(
            com.google.cloud.aiplatform.v1beta1.ListModelMonitoringJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListModelMonitoringJobsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ModelMonitoringJob.
     * </pre>
     */
    public com.google.longrunning.Operation deleteModelMonitoringJob(
        com.google.cloud.aiplatform.v1beta1.DeleteModelMonitoringJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteModelMonitoringJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Searches Model Monitoring Stats generated within a given time window.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringStatsResponse
        searchModelMonitoringStats(
            com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringStatsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchModelMonitoringStatsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the Model Monitoring alerts.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringAlertsResponse
        searchModelMonitoringAlerts(
            com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringAlertsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchModelMonitoringAlertsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * ModelMonitoringService.
   *
   * <pre>
   * A service for creating and managing Vertex AI Model moitoring. This includes
   * `ModelMonitor` resources, `ModelMonitoringJob` resources.
   * </pre>
   */
  public static final class ModelMonitoringServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ModelMonitoringServiceFutureStub> {
    private ModelMonitoringServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ModelMonitoringServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ModelMonitoringServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a ModelMonitor.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createModelMonitor(com.google.cloud.aiplatform.v1beta1.CreateModelMonitorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateModelMonitorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a ModelMonitor.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateModelMonitor(com.google.cloud.aiplatform.v1beta1.UpdateModelMonitorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateModelMonitorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a ModelMonitor.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ModelMonitor>
        getModelMonitor(com.google.cloud.aiplatform.v1beta1.GetModelMonitorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetModelMonitorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ModelMonitors in a Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ListModelMonitorsResponse>
        listModelMonitors(com.google.cloud.aiplatform.v1beta1.ListModelMonitorsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListModelMonitorsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ModelMonitor.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteModelMonitor(com.google.cloud.aiplatform.v1beta1.DeleteModelMonitorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteModelMonitorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a ModelMonitoringJob.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ModelMonitoringJob>
        createModelMonitoringJob(
            com.google.cloud.aiplatform.v1beta1.CreateModelMonitoringJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateModelMonitoringJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a ModelMonitoringJob.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ModelMonitoringJob>
        getModelMonitoringJob(
            com.google.cloud.aiplatform.v1beta1.GetModelMonitoringJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetModelMonitoringJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ModelMonitoringJobs.
     * Callers may choose to read across multiple Monitors as per
     * [AIP-159](https://google.aip.dev/159) by using '-' (the hyphen or dash
     * character) as a wildcard character instead of modelMonitor id in the
     * parent. Format
     * `projects/{project_id}/locations/{location}/moodelMonitors/-/modelMonitoringJobs`
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ListModelMonitoringJobsResponse>
        listModelMonitoringJobs(
            com.google.cloud.aiplatform.v1beta1.ListModelMonitoringJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListModelMonitoringJobsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ModelMonitoringJob.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteModelMonitoringJob(
            com.google.cloud.aiplatform.v1beta1.DeleteModelMonitoringJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteModelMonitoringJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Searches Model Monitoring Stats generated within a given time window.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringStatsResponse>
        searchModelMonitoringStats(
            com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringStatsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchModelMonitoringStatsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the Model Monitoring alerts.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringAlertsResponse>
        searchModelMonitoringAlerts(
            com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringAlertsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchModelMonitoringAlertsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_MODEL_MONITOR = 0;
  private static final int METHODID_UPDATE_MODEL_MONITOR = 1;
  private static final int METHODID_GET_MODEL_MONITOR = 2;
  private static final int METHODID_LIST_MODEL_MONITORS = 3;
  private static final int METHODID_DELETE_MODEL_MONITOR = 4;
  private static final int METHODID_CREATE_MODEL_MONITORING_JOB = 5;
  private static final int METHODID_GET_MODEL_MONITORING_JOB = 6;
  private static final int METHODID_LIST_MODEL_MONITORING_JOBS = 7;
  private static final int METHODID_DELETE_MODEL_MONITORING_JOB = 8;
  private static final int METHODID_SEARCH_MODEL_MONITORING_STATS = 9;
  private static final int METHODID_SEARCH_MODEL_MONITORING_ALERTS = 10;

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
        case METHODID_CREATE_MODEL_MONITOR:
          serviceImpl.createModelMonitor(
              (com.google.cloud.aiplatform.v1beta1.CreateModelMonitorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_MODEL_MONITOR:
          serviceImpl.updateModelMonitor(
              (com.google.cloud.aiplatform.v1beta1.UpdateModelMonitorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_MODEL_MONITOR:
          serviceImpl.getModelMonitor(
              (com.google.cloud.aiplatform.v1beta1.GetModelMonitorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ModelMonitor>)
                  responseObserver);
          break;
        case METHODID_LIST_MODEL_MONITORS:
          serviceImpl.listModelMonitors(
              (com.google.cloud.aiplatform.v1beta1.ListModelMonitorsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ListModelMonitorsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_MODEL_MONITOR:
          serviceImpl.deleteModelMonitor(
              (com.google.cloud.aiplatform.v1beta1.DeleteModelMonitorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_MODEL_MONITORING_JOB:
          serviceImpl.createModelMonitoringJob(
              (com.google.cloud.aiplatform.v1beta1.CreateModelMonitoringJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ModelMonitoringJob>)
                  responseObserver);
          break;
        case METHODID_GET_MODEL_MONITORING_JOB:
          serviceImpl.getModelMonitoringJob(
              (com.google.cloud.aiplatform.v1beta1.GetModelMonitoringJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ModelMonitoringJob>)
                  responseObserver);
          break;
        case METHODID_LIST_MODEL_MONITORING_JOBS:
          serviceImpl.listModelMonitoringJobs(
              (com.google.cloud.aiplatform.v1beta1.ListModelMonitoringJobsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ListModelMonitoringJobsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_MODEL_MONITORING_JOB:
          serviceImpl.deleteModelMonitoringJob(
              (com.google.cloud.aiplatform.v1beta1.DeleteModelMonitoringJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_SEARCH_MODEL_MONITORING_STATS:
          serviceImpl.searchModelMonitoringStats(
              (com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringStatsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringStatsResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_MODEL_MONITORING_ALERTS:
          serviceImpl.searchModelMonitoringAlerts(
              (com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringAlertsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringAlertsResponse>)
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
            getCreateModelMonitorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.CreateModelMonitorRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_MODEL_MONITOR)))
        .addMethod(
            getUpdateModelMonitorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.UpdateModelMonitorRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_MODEL_MONITOR)))
        .addMethod(
            getGetModelMonitorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.GetModelMonitorRequest,
                    com.google.cloud.aiplatform.v1beta1.ModelMonitor>(
                    service, METHODID_GET_MODEL_MONITOR)))
        .addMethod(
            getListModelMonitorsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.ListModelMonitorsRequest,
                    com.google.cloud.aiplatform.v1beta1.ListModelMonitorsResponse>(
                    service, METHODID_LIST_MODEL_MONITORS)))
        .addMethod(
            getDeleteModelMonitorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.DeleteModelMonitorRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_MODEL_MONITOR)))
        .addMethod(
            getCreateModelMonitoringJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.CreateModelMonitoringJobRequest,
                    com.google.cloud.aiplatform.v1beta1.ModelMonitoringJob>(
                    service, METHODID_CREATE_MODEL_MONITORING_JOB)))
        .addMethod(
            getGetModelMonitoringJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.GetModelMonitoringJobRequest,
                    com.google.cloud.aiplatform.v1beta1.ModelMonitoringJob>(
                    service, METHODID_GET_MODEL_MONITORING_JOB)))
        .addMethod(
            getListModelMonitoringJobsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.ListModelMonitoringJobsRequest,
                    com.google.cloud.aiplatform.v1beta1.ListModelMonitoringJobsResponse>(
                    service, METHODID_LIST_MODEL_MONITORING_JOBS)))
        .addMethod(
            getDeleteModelMonitoringJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.DeleteModelMonitoringJobRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_MODEL_MONITORING_JOB)))
        .addMethod(
            getSearchModelMonitoringStatsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringStatsRequest,
                    com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringStatsResponse>(
                    service, METHODID_SEARCH_MODEL_MONITORING_STATS)))
        .addMethod(
            getSearchModelMonitoringAlertsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringAlertsRequest,
                    com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringAlertsResponse>(
                    service, METHODID_SEARCH_MODEL_MONITORING_ALERTS)))
        .build();
  }

  private abstract static class ModelMonitoringServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ModelMonitoringServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1beta1.ModelMonitoringServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ModelMonitoringService");
    }
  }

  private static final class ModelMonitoringServiceFileDescriptorSupplier
      extends ModelMonitoringServiceBaseDescriptorSupplier {
    ModelMonitoringServiceFileDescriptorSupplier() {}
  }

  private static final class ModelMonitoringServiceMethodDescriptorSupplier
      extends ModelMonitoringServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ModelMonitoringServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ModelMonitoringServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ModelMonitoringServiceFileDescriptorSupplier())
                      .addMethod(getCreateModelMonitorMethod())
                      .addMethod(getUpdateModelMonitorMethod())
                      .addMethod(getGetModelMonitorMethod())
                      .addMethod(getListModelMonitorsMethod())
                      .addMethod(getDeleteModelMonitorMethod())
                      .addMethod(getCreateModelMonitoringJobMethod())
                      .addMethod(getGetModelMonitoringJobMethod())
                      .addMethod(getListModelMonitoringJobsMethod())
                      .addMethod(getDeleteModelMonitoringJobMethod())
                      .addMethod(getSearchModelMonitoringStatsMethod())
                      .addMethod(getSearchModelMonitoringAlertsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
