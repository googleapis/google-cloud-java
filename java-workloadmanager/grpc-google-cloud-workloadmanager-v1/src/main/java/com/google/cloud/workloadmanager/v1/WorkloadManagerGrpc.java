/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.workloadmanager.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The Workload Manager provides various tools to deploy, validate and observe
 * your workloads running on Google Cloud.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class WorkloadManagerGrpc {

  private WorkloadManagerGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.workloadmanager.v1.WorkloadManager";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workloadmanager.v1.ListEvaluationsRequest,
          com.google.cloud.workloadmanager.v1.ListEvaluationsResponse>
      getListEvaluationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEvaluations",
      requestType = com.google.cloud.workloadmanager.v1.ListEvaluationsRequest.class,
      responseType = com.google.cloud.workloadmanager.v1.ListEvaluationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workloadmanager.v1.ListEvaluationsRequest,
          com.google.cloud.workloadmanager.v1.ListEvaluationsResponse>
      getListEvaluationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workloadmanager.v1.ListEvaluationsRequest,
            com.google.cloud.workloadmanager.v1.ListEvaluationsResponse>
        getListEvaluationsMethod;
    if ((getListEvaluationsMethod = WorkloadManagerGrpc.getListEvaluationsMethod) == null) {
      synchronized (WorkloadManagerGrpc.class) {
        if ((getListEvaluationsMethod = WorkloadManagerGrpc.getListEvaluationsMethod) == null) {
          WorkloadManagerGrpc.getListEvaluationsMethod =
              getListEvaluationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workloadmanager.v1.ListEvaluationsRequest,
                          com.google.cloud.workloadmanager.v1.ListEvaluationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEvaluations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workloadmanager.v1.ListEvaluationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workloadmanager.v1.ListEvaluationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkloadManagerMethodDescriptorSupplier("ListEvaluations"))
                      .build();
        }
      }
    }
    return getListEvaluationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workloadmanager.v1.GetEvaluationRequest,
          com.google.cloud.workloadmanager.v1.Evaluation>
      getGetEvaluationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEvaluation",
      requestType = com.google.cloud.workloadmanager.v1.GetEvaluationRequest.class,
      responseType = com.google.cloud.workloadmanager.v1.Evaluation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workloadmanager.v1.GetEvaluationRequest,
          com.google.cloud.workloadmanager.v1.Evaluation>
      getGetEvaluationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workloadmanager.v1.GetEvaluationRequest,
            com.google.cloud.workloadmanager.v1.Evaluation>
        getGetEvaluationMethod;
    if ((getGetEvaluationMethod = WorkloadManagerGrpc.getGetEvaluationMethod) == null) {
      synchronized (WorkloadManagerGrpc.class) {
        if ((getGetEvaluationMethod = WorkloadManagerGrpc.getGetEvaluationMethod) == null) {
          WorkloadManagerGrpc.getGetEvaluationMethod =
              getGetEvaluationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workloadmanager.v1.GetEvaluationRequest,
                          com.google.cloud.workloadmanager.v1.Evaluation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEvaluation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workloadmanager.v1.GetEvaluationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workloadmanager.v1.Evaluation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkloadManagerMethodDescriptorSupplier("GetEvaluation"))
                      .build();
        }
      }
    }
    return getGetEvaluationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workloadmanager.v1.CreateEvaluationRequest,
          com.google.longrunning.Operation>
      getCreateEvaluationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEvaluation",
      requestType = com.google.cloud.workloadmanager.v1.CreateEvaluationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workloadmanager.v1.CreateEvaluationRequest,
          com.google.longrunning.Operation>
      getCreateEvaluationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workloadmanager.v1.CreateEvaluationRequest,
            com.google.longrunning.Operation>
        getCreateEvaluationMethod;
    if ((getCreateEvaluationMethod = WorkloadManagerGrpc.getCreateEvaluationMethod) == null) {
      synchronized (WorkloadManagerGrpc.class) {
        if ((getCreateEvaluationMethod = WorkloadManagerGrpc.getCreateEvaluationMethod) == null) {
          WorkloadManagerGrpc.getCreateEvaluationMethod =
              getCreateEvaluationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workloadmanager.v1.CreateEvaluationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateEvaluation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workloadmanager.v1.CreateEvaluationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkloadManagerMethodDescriptorSupplier("CreateEvaluation"))
                      .build();
        }
      }
    }
    return getCreateEvaluationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workloadmanager.v1.UpdateEvaluationRequest,
          com.google.longrunning.Operation>
      getUpdateEvaluationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEvaluation",
      requestType = com.google.cloud.workloadmanager.v1.UpdateEvaluationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workloadmanager.v1.UpdateEvaluationRequest,
          com.google.longrunning.Operation>
      getUpdateEvaluationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workloadmanager.v1.UpdateEvaluationRequest,
            com.google.longrunning.Operation>
        getUpdateEvaluationMethod;
    if ((getUpdateEvaluationMethod = WorkloadManagerGrpc.getUpdateEvaluationMethod) == null) {
      synchronized (WorkloadManagerGrpc.class) {
        if ((getUpdateEvaluationMethod = WorkloadManagerGrpc.getUpdateEvaluationMethod) == null) {
          WorkloadManagerGrpc.getUpdateEvaluationMethod =
              getUpdateEvaluationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workloadmanager.v1.UpdateEvaluationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateEvaluation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workloadmanager.v1.UpdateEvaluationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkloadManagerMethodDescriptorSupplier("UpdateEvaluation"))
                      .build();
        }
      }
    }
    return getUpdateEvaluationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workloadmanager.v1.DeleteEvaluationRequest,
          com.google.longrunning.Operation>
      getDeleteEvaluationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEvaluation",
      requestType = com.google.cloud.workloadmanager.v1.DeleteEvaluationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workloadmanager.v1.DeleteEvaluationRequest,
          com.google.longrunning.Operation>
      getDeleteEvaluationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workloadmanager.v1.DeleteEvaluationRequest,
            com.google.longrunning.Operation>
        getDeleteEvaluationMethod;
    if ((getDeleteEvaluationMethod = WorkloadManagerGrpc.getDeleteEvaluationMethod) == null) {
      synchronized (WorkloadManagerGrpc.class) {
        if ((getDeleteEvaluationMethod = WorkloadManagerGrpc.getDeleteEvaluationMethod) == null) {
          WorkloadManagerGrpc.getDeleteEvaluationMethod =
              getDeleteEvaluationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workloadmanager.v1.DeleteEvaluationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteEvaluation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workloadmanager.v1.DeleteEvaluationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkloadManagerMethodDescriptorSupplier("DeleteEvaluation"))
                      .build();
        }
      }
    }
    return getDeleteEvaluationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workloadmanager.v1.ListExecutionsRequest,
          com.google.cloud.workloadmanager.v1.ListExecutionsResponse>
      getListExecutionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListExecutions",
      requestType = com.google.cloud.workloadmanager.v1.ListExecutionsRequest.class,
      responseType = com.google.cloud.workloadmanager.v1.ListExecutionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workloadmanager.v1.ListExecutionsRequest,
          com.google.cloud.workloadmanager.v1.ListExecutionsResponse>
      getListExecutionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workloadmanager.v1.ListExecutionsRequest,
            com.google.cloud.workloadmanager.v1.ListExecutionsResponse>
        getListExecutionsMethod;
    if ((getListExecutionsMethod = WorkloadManagerGrpc.getListExecutionsMethod) == null) {
      synchronized (WorkloadManagerGrpc.class) {
        if ((getListExecutionsMethod = WorkloadManagerGrpc.getListExecutionsMethod) == null) {
          WorkloadManagerGrpc.getListExecutionsMethod =
              getListExecutionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workloadmanager.v1.ListExecutionsRequest,
                          com.google.cloud.workloadmanager.v1.ListExecutionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListExecutions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workloadmanager.v1.ListExecutionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workloadmanager.v1.ListExecutionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkloadManagerMethodDescriptorSupplier("ListExecutions"))
                      .build();
        }
      }
    }
    return getListExecutionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workloadmanager.v1.GetExecutionRequest,
          com.google.cloud.workloadmanager.v1.Execution>
      getGetExecutionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetExecution",
      requestType = com.google.cloud.workloadmanager.v1.GetExecutionRequest.class,
      responseType = com.google.cloud.workloadmanager.v1.Execution.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workloadmanager.v1.GetExecutionRequest,
          com.google.cloud.workloadmanager.v1.Execution>
      getGetExecutionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workloadmanager.v1.GetExecutionRequest,
            com.google.cloud.workloadmanager.v1.Execution>
        getGetExecutionMethod;
    if ((getGetExecutionMethod = WorkloadManagerGrpc.getGetExecutionMethod) == null) {
      synchronized (WorkloadManagerGrpc.class) {
        if ((getGetExecutionMethod = WorkloadManagerGrpc.getGetExecutionMethod) == null) {
          WorkloadManagerGrpc.getGetExecutionMethod =
              getGetExecutionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workloadmanager.v1.GetExecutionRequest,
                          com.google.cloud.workloadmanager.v1.Execution>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetExecution"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workloadmanager.v1.GetExecutionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workloadmanager.v1.Execution.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkloadManagerMethodDescriptorSupplier("GetExecution"))
                      .build();
        }
      }
    }
    return getGetExecutionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workloadmanager.v1.RunEvaluationRequest,
          com.google.longrunning.Operation>
      getRunEvaluationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RunEvaluation",
      requestType = com.google.cloud.workloadmanager.v1.RunEvaluationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workloadmanager.v1.RunEvaluationRequest,
          com.google.longrunning.Operation>
      getRunEvaluationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workloadmanager.v1.RunEvaluationRequest,
            com.google.longrunning.Operation>
        getRunEvaluationMethod;
    if ((getRunEvaluationMethod = WorkloadManagerGrpc.getRunEvaluationMethod) == null) {
      synchronized (WorkloadManagerGrpc.class) {
        if ((getRunEvaluationMethod = WorkloadManagerGrpc.getRunEvaluationMethod) == null) {
          WorkloadManagerGrpc.getRunEvaluationMethod =
              getRunEvaluationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workloadmanager.v1.RunEvaluationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RunEvaluation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workloadmanager.v1.RunEvaluationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkloadManagerMethodDescriptorSupplier("RunEvaluation"))
                      .build();
        }
      }
    }
    return getRunEvaluationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workloadmanager.v1.DeleteExecutionRequest,
          com.google.longrunning.Operation>
      getDeleteExecutionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteExecution",
      requestType = com.google.cloud.workloadmanager.v1.DeleteExecutionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workloadmanager.v1.DeleteExecutionRequest,
          com.google.longrunning.Operation>
      getDeleteExecutionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workloadmanager.v1.DeleteExecutionRequest,
            com.google.longrunning.Operation>
        getDeleteExecutionMethod;
    if ((getDeleteExecutionMethod = WorkloadManagerGrpc.getDeleteExecutionMethod) == null) {
      synchronized (WorkloadManagerGrpc.class) {
        if ((getDeleteExecutionMethod = WorkloadManagerGrpc.getDeleteExecutionMethod) == null) {
          WorkloadManagerGrpc.getDeleteExecutionMethod =
              getDeleteExecutionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workloadmanager.v1.DeleteExecutionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteExecution"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workloadmanager.v1.DeleteExecutionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkloadManagerMethodDescriptorSupplier("DeleteExecution"))
                      .build();
        }
      }
    }
    return getDeleteExecutionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workloadmanager.v1.ListExecutionResultsRequest,
          com.google.cloud.workloadmanager.v1.ListExecutionResultsResponse>
      getListExecutionResultsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListExecutionResults",
      requestType = com.google.cloud.workloadmanager.v1.ListExecutionResultsRequest.class,
      responseType = com.google.cloud.workloadmanager.v1.ListExecutionResultsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workloadmanager.v1.ListExecutionResultsRequest,
          com.google.cloud.workloadmanager.v1.ListExecutionResultsResponse>
      getListExecutionResultsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workloadmanager.v1.ListExecutionResultsRequest,
            com.google.cloud.workloadmanager.v1.ListExecutionResultsResponse>
        getListExecutionResultsMethod;
    if ((getListExecutionResultsMethod = WorkloadManagerGrpc.getListExecutionResultsMethod)
        == null) {
      synchronized (WorkloadManagerGrpc.class) {
        if ((getListExecutionResultsMethod = WorkloadManagerGrpc.getListExecutionResultsMethod)
            == null) {
          WorkloadManagerGrpc.getListExecutionResultsMethod =
              getListExecutionResultsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workloadmanager.v1.ListExecutionResultsRequest,
                          com.google.cloud.workloadmanager.v1.ListExecutionResultsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListExecutionResults"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workloadmanager.v1.ListExecutionResultsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workloadmanager.v1.ListExecutionResultsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkloadManagerMethodDescriptorSupplier("ListExecutionResults"))
                      .build();
        }
      }
    }
    return getListExecutionResultsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workloadmanager.v1.ListRulesRequest,
          com.google.cloud.workloadmanager.v1.ListRulesResponse>
      getListRulesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRules",
      requestType = com.google.cloud.workloadmanager.v1.ListRulesRequest.class,
      responseType = com.google.cloud.workloadmanager.v1.ListRulesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workloadmanager.v1.ListRulesRequest,
          com.google.cloud.workloadmanager.v1.ListRulesResponse>
      getListRulesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workloadmanager.v1.ListRulesRequest,
            com.google.cloud.workloadmanager.v1.ListRulesResponse>
        getListRulesMethod;
    if ((getListRulesMethod = WorkloadManagerGrpc.getListRulesMethod) == null) {
      synchronized (WorkloadManagerGrpc.class) {
        if ((getListRulesMethod = WorkloadManagerGrpc.getListRulesMethod) == null) {
          WorkloadManagerGrpc.getListRulesMethod =
              getListRulesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workloadmanager.v1.ListRulesRequest,
                          com.google.cloud.workloadmanager.v1.ListRulesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRules"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workloadmanager.v1.ListRulesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workloadmanager.v1.ListRulesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new WorkloadManagerMethodDescriptorSupplier("ListRules"))
                      .build();
        }
      }
    }
    return getListRulesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workloadmanager.v1.ListScannedResourcesRequest,
          com.google.cloud.workloadmanager.v1.ListScannedResourcesResponse>
      getListScannedResourcesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListScannedResources",
      requestType = com.google.cloud.workloadmanager.v1.ListScannedResourcesRequest.class,
      responseType = com.google.cloud.workloadmanager.v1.ListScannedResourcesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workloadmanager.v1.ListScannedResourcesRequest,
          com.google.cloud.workloadmanager.v1.ListScannedResourcesResponse>
      getListScannedResourcesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workloadmanager.v1.ListScannedResourcesRequest,
            com.google.cloud.workloadmanager.v1.ListScannedResourcesResponse>
        getListScannedResourcesMethod;
    if ((getListScannedResourcesMethod = WorkloadManagerGrpc.getListScannedResourcesMethod)
        == null) {
      synchronized (WorkloadManagerGrpc.class) {
        if ((getListScannedResourcesMethod = WorkloadManagerGrpc.getListScannedResourcesMethod)
            == null) {
          WorkloadManagerGrpc.getListScannedResourcesMethod =
              getListScannedResourcesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workloadmanager.v1.ListScannedResourcesRequest,
                          com.google.cloud.workloadmanager.v1.ListScannedResourcesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListScannedResources"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workloadmanager.v1.ListScannedResourcesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workloadmanager.v1.ListScannedResourcesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkloadManagerMethodDescriptorSupplier("ListScannedResources"))
                      .build();
        }
      }
    }
    return getListScannedResourcesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static WorkloadManagerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkloadManagerStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WorkloadManagerStub>() {
          @java.lang.Override
          public WorkloadManagerStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WorkloadManagerStub(channel, callOptions);
          }
        };
    return WorkloadManagerStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static WorkloadManagerBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkloadManagerBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WorkloadManagerBlockingV2Stub>() {
          @java.lang.Override
          public WorkloadManagerBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WorkloadManagerBlockingV2Stub(channel, callOptions);
          }
        };
    return WorkloadManagerBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WorkloadManagerBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkloadManagerBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WorkloadManagerBlockingStub>() {
          @java.lang.Override
          public WorkloadManagerBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WorkloadManagerBlockingStub(channel, callOptions);
          }
        };
    return WorkloadManagerBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static WorkloadManagerFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkloadManagerFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WorkloadManagerFutureStub>() {
          @java.lang.Override
          public WorkloadManagerFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WorkloadManagerFutureStub(channel, callOptions);
          }
        };
    return WorkloadManagerFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The Workload Manager provides various tools to deploy, validate and observe
   * your workloads running on Google Cloud.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists Evaluations in a given project and location.
     * </pre>
     */
    default void listEvaluations(
        com.google.cloud.workloadmanager.v1.ListEvaluationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workloadmanager.v1.ListEvaluationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEvaluationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Evaluation.
     * </pre>
     */
    default void getEvaluation(
        com.google.cloud.workloadmanager.v1.GetEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workloadmanager.v1.Evaluation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEvaluationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Evaluation in a given project and location.
     * </pre>
     */
    default void createEvaluation(
        com.google.cloud.workloadmanager.v1.CreateEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateEvaluationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Evaluation.
     * </pre>
     */
    default void updateEvaluation(
        com.google.cloud.workloadmanager.v1.UpdateEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateEvaluationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Evaluation.
     * </pre>
     */
    default void deleteEvaluation(
        com.google.cloud.workloadmanager.v1.DeleteEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteEvaluationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Executions in a given project and location.
     * </pre>
     */
    default void listExecutions(
        com.google.cloud.workloadmanager.v1.ListExecutionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workloadmanager.v1.ListExecutionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListExecutionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Execution.
     * </pre>
     */
    default void getExecution(
        com.google.cloud.workloadmanager.v1.GetExecutionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workloadmanager.v1.Execution>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetExecutionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Execution in a given project and location.
     * </pre>
     */
    default void runEvaluation(
        com.google.cloud.workloadmanager.v1.RunEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRunEvaluationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Execution.
     * </pre>
     */
    default void deleteExecution(
        com.google.cloud.workloadmanager.v1.DeleteExecutionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteExecutionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the result of a single evaluation.
     * </pre>
     */
    default void listExecutionResults(
        com.google.cloud.workloadmanager.v1.ListExecutionResultsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.workloadmanager.v1.ListExecutionResultsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListExecutionResultsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists rules in a given project.
     * </pre>
     */
    default void listRules(
        com.google.cloud.workloadmanager.v1.ListRulesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workloadmanager.v1.ListRulesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListRulesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all scanned resources for a single Execution.
     * </pre>
     */
    default void listScannedResources(
        com.google.cloud.workloadmanager.v1.ListScannedResourcesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.workloadmanager.v1.ListScannedResourcesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListScannedResourcesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service WorkloadManager.
   *
   * <pre>
   * The Workload Manager provides various tools to deploy, validate and observe
   * your workloads running on Google Cloud.
   * </pre>
   */
  public abstract static class WorkloadManagerImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return WorkloadManagerGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service WorkloadManager.
   *
   * <pre>
   * The Workload Manager provides various tools to deploy, validate and observe
   * your workloads running on Google Cloud.
   * </pre>
   */
  public static final class WorkloadManagerStub
      extends io.grpc.stub.AbstractAsyncStub<WorkloadManagerStub> {
    private WorkloadManagerStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkloadManagerStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkloadManagerStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Evaluations in a given project and location.
     * </pre>
     */
    public void listEvaluations(
        com.google.cloud.workloadmanager.v1.ListEvaluationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workloadmanager.v1.ListEvaluationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEvaluationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Evaluation.
     * </pre>
     */
    public void getEvaluation(
        com.google.cloud.workloadmanager.v1.GetEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workloadmanager.v1.Evaluation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEvaluationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Evaluation in a given project and location.
     * </pre>
     */
    public void createEvaluation(
        com.google.cloud.workloadmanager.v1.CreateEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEvaluationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Evaluation.
     * </pre>
     */
    public void updateEvaluation(
        com.google.cloud.workloadmanager.v1.UpdateEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEvaluationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Evaluation.
     * </pre>
     */
    public void deleteEvaluation(
        com.google.cloud.workloadmanager.v1.DeleteEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEvaluationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Executions in a given project and location.
     * </pre>
     */
    public void listExecutions(
        com.google.cloud.workloadmanager.v1.ListExecutionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workloadmanager.v1.ListExecutionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListExecutionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Execution.
     * </pre>
     */
    public void getExecution(
        com.google.cloud.workloadmanager.v1.GetExecutionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workloadmanager.v1.Execution>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetExecutionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Execution in a given project and location.
     * </pre>
     */
    public void runEvaluation(
        com.google.cloud.workloadmanager.v1.RunEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRunEvaluationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Execution.
     * </pre>
     */
    public void deleteExecution(
        com.google.cloud.workloadmanager.v1.DeleteExecutionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteExecutionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the result of a single evaluation.
     * </pre>
     */
    public void listExecutionResults(
        com.google.cloud.workloadmanager.v1.ListExecutionResultsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.workloadmanager.v1.ListExecutionResultsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListExecutionResultsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists rules in a given project.
     * </pre>
     */
    public void listRules(
        com.google.cloud.workloadmanager.v1.ListRulesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workloadmanager.v1.ListRulesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRulesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all scanned resources for a single Execution.
     * </pre>
     */
    public void listScannedResources(
        com.google.cloud.workloadmanager.v1.ListScannedResourcesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.workloadmanager.v1.ListScannedResourcesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListScannedResourcesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service WorkloadManager.
   *
   * <pre>
   * The Workload Manager provides various tools to deploy, validate and observe
   * your workloads running on Google Cloud.
   * </pre>
   */
  public static final class WorkloadManagerBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<WorkloadManagerBlockingV2Stub> {
    private WorkloadManagerBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkloadManagerBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkloadManagerBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Evaluations in a given project and location.
     * </pre>
     */
    public com.google.cloud.workloadmanager.v1.ListEvaluationsResponse listEvaluations(
        com.google.cloud.workloadmanager.v1.ListEvaluationsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListEvaluationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Evaluation.
     * </pre>
     */
    public com.google.cloud.workloadmanager.v1.Evaluation getEvaluation(
        com.google.cloud.workloadmanager.v1.GetEvaluationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetEvaluationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Evaluation in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createEvaluation(
        com.google.cloud.workloadmanager.v1.CreateEvaluationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateEvaluationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Evaluation.
     * </pre>
     */
    public com.google.longrunning.Operation updateEvaluation(
        com.google.cloud.workloadmanager.v1.UpdateEvaluationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateEvaluationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Evaluation.
     * </pre>
     */
    public com.google.longrunning.Operation deleteEvaluation(
        com.google.cloud.workloadmanager.v1.DeleteEvaluationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteEvaluationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Executions in a given project and location.
     * </pre>
     */
    public com.google.cloud.workloadmanager.v1.ListExecutionsResponse listExecutions(
        com.google.cloud.workloadmanager.v1.ListExecutionsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListExecutionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Execution.
     * </pre>
     */
    public com.google.cloud.workloadmanager.v1.Execution getExecution(
        com.google.cloud.workloadmanager.v1.GetExecutionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetExecutionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Execution in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation runEvaluation(
        com.google.cloud.workloadmanager.v1.RunEvaluationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRunEvaluationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Execution.
     * </pre>
     */
    public com.google.longrunning.Operation deleteExecution(
        com.google.cloud.workloadmanager.v1.DeleteExecutionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteExecutionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the result of a single evaluation.
     * </pre>
     */
    public com.google.cloud.workloadmanager.v1.ListExecutionResultsResponse listExecutionResults(
        com.google.cloud.workloadmanager.v1.ListExecutionResultsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListExecutionResultsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists rules in a given project.
     * </pre>
     */
    public com.google.cloud.workloadmanager.v1.ListRulesResponse listRules(
        com.google.cloud.workloadmanager.v1.ListRulesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListRulesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all scanned resources for a single Execution.
     * </pre>
     */
    public com.google.cloud.workloadmanager.v1.ListScannedResourcesResponse listScannedResources(
        com.google.cloud.workloadmanager.v1.ListScannedResourcesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListScannedResourcesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service WorkloadManager.
   *
   * <pre>
   * The Workload Manager provides various tools to deploy, validate and observe
   * your workloads running on Google Cloud.
   * </pre>
   */
  public static final class WorkloadManagerBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<WorkloadManagerBlockingStub> {
    private WorkloadManagerBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkloadManagerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkloadManagerBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Evaluations in a given project and location.
     * </pre>
     */
    public com.google.cloud.workloadmanager.v1.ListEvaluationsResponse listEvaluations(
        com.google.cloud.workloadmanager.v1.ListEvaluationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEvaluationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Evaluation.
     * </pre>
     */
    public com.google.cloud.workloadmanager.v1.Evaluation getEvaluation(
        com.google.cloud.workloadmanager.v1.GetEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEvaluationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Evaluation in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createEvaluation(
        com.google.cloud.workloadmanager.v1.CreateEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEvaluationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Evaluation.
     * </pre>
     */
    public com.google.longrunning.Operation updateEvaluation(
        com.google.cloud.workloadmanager.v1.UpdateEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEvaluationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Evaluation.
     * </pre>
     */
    public com.google.longrunning.Operation deleteEvaluation(
        com.google.cloud.workloadmanager.v1.DeleteEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEvaluationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Executions in a given project and location.
     * </pre>
     */
    public com.google.cloud.workloadmanager.v1.ListExecutionsResponse listExecutions(
        com.google.cloud.workloadmanager.v1.ListExecutionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListExecutionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Execution.
     * </pre>
     */
    public com.google.cloud.workloadmanager.v1.Execution getExecution(
        com.google.cloud.workloadmanager.v1.GetExecutionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetExecutionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Execution in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation runEvaluation(
        com.google.cloud.workloadmanager.v1.RunEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRunEvaluationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Execution.
     * </pre>
     */
    public com.google.longrunning.Operation deleteExecution(
        com.google.cloud.workloadmanager.v1.DeleteExecutionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteExecutionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the result of a single evaluation.
     * </pre>
     */
    public com.google.cloud.workloadmanager.v1.ListExecutionResultsResponse listExecutionResults(
        com.google.cloud.workloadmanager.v1.ListExecutionResultsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListExecutionResultsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists rules in a given project.
     * </pre>
     */
    public com.google.cloud.workloadmanager.v1.ListRulesResponse listRules(
        com.google.cloud.workloadmanager.v1.ListRulesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRulesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all scanned resources for a single Execution.
     * </pre>
     */
    public com.google.cloud.workloadmanager.v1.ListScannedResourcesResponse listScannedResources(
        com.google.cloud.workloadmanager.v1.ListScannedResourcesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListScannedResourcesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service WorkloadManager.
   *
   * <pre>
   * The Workload Manager provides various tools to deploy, validate and observe
   * your workloads running on Google Cloud.
   * </pre>
   */
  public static final class WorkloadManagerFutureStub
      extends io.grpc.stub.AbstractFutureStub<WorkloadManagerFutureStub> {
    private WorkloadManagerFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkloadManagerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkloadManagerFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Evaluations in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.workloadmanager.v1.ListEvaluationsResponse>
        listEvaluations(com.google.cloud.workloadmanager.v1.ListEvaluationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEvaluationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Evaluation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.workloadmanager.v1.Evaluation>
        getEvaluation(com.google.cloud.workloadmanager.v1.GetEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEvaluationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Evaluation in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createEvaluation(com.google.cloud.workloadmanager.v1.CreateEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEvaluationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Evaluation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateEvaluation(com.google.cloud.workloadmanager.v1.UpdateEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEvaluationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Evaluation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteEvaluation(com.google.cloud.workloadmanager.v1.DeleteEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEvaluationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Executions in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.workloadmanager.v1.ListExecutionsResponse>
        listExecutions(com.google.cloud.workloadmanager.v1.ListExecutionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListExecutionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Execution.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.workloadmanager.v1.Execution>
        getExecution(com.google.cloud.workloadmanager.v1.GetExecutionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetExecutionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Execution in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        runEvaluation(com.google.cloud.workloadmanager.v1.RunEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRunEvaluationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Execution.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteExecution(com.google.cloud.workloadmanager.v1.DeleteExecutionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteExecutionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the result of a single evaluation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.workloadmanager.v1.ListExecutionResultsResponse>
        listExecutionResults(
            com.google.cloud.workloadmanager.v1.ListExecutionResultsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListExecutionResultsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists rules in a given project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.workloadmanager.v1.ListRulesResponse>
        listRules(com.google.cloud.workloadmanager.v1.ListRulesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRulesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List all scanned resources for a single Execution.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.workloadmanager.v1.ListScannedResourcesResponse>
        listScannedResources(
            com.google.cloud.workloadmanager.v1.ListScannedResourcesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListScannedResourcesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_EVALUATIONS = 0;
  private static final int METHODID_GET_EVALUATION = 1;
  private static final int METHODID_CREATE_EVALUATION = 2;
  private static final int METHODID_UPDATE_EVALUATION = 3;
  private static final int METHODID_DELETE_EVALUATION = 4;
  private static final int METHODID_LIST_EXECUTIONS = 5;
  private static final int METHODID_GET_EXECUTION = 6;
  private static final int METHODID_RUN_EVALUATION = 7;
  private static final int METHODID_DELETE_EXECUTION = 8;
  private static final int METHODID_LIST_EXECUTION_RESULTS = 9;
  private static final int METHODID_LIST_RULES = 10;
  private static final int METHODID_LIST_SCANNED_RESOURCES = 11;

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
        case METHODID_LIST_EVALUATIONS:
          serviceImpl.listEvaluations(
              (com.google.cloud.workloadmanager.v1.ListEvaluationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.workloadmanager.v1.ListEvaluationsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_EVALUATION:
          serviceImpl.getEvaluation(
              (com.google.cloud.workloadmanager.v1.GetEvaluationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.workloadmanager.v1.Evaluation>)
                  responseObserver);
          break;
        case METHODID_CREATE_EVALUATION:
          serviceImpl.createEvaluation(
              (com.google.cloud.workloadmanager.v1.CreateEvaluationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_EVALUATION:
          serviceImpl.updateEvaluation(
              (com.google.cloud.workloadmanager.v1.UpdateEvaluationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_EVALUATION:
          serviceImpl.deleteEvaluation(
              (com.google.cloud.workloadmanager.v1.DeleteEvaluationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_EXECUTIONS:
          serviceImpl.listExecutions(
              (com.google.cloud.workloadmanager.v1.ListExecutionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.workloadmanager.v1.ListExecutionsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_EXECUTION:
          serviceImpl.getExecution(
              (com.google.cloud.workloadmanager.v1.GetExecutionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.workloadmanager.v1.Execution>)
                  responseObserver);
          break;
        case METHODID_RUN_EVALUATION:
          serviceImpl.runEvaluation(
              (com.google.cloud.workloadmanager.v1.RunEvaluationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_EXECUTION:
          serviceImpl.deleteExecution(
              (com.google.cloud.workloadmanager.v1.DeleteExecutionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_EXECUTION_RESULTS:
          serviceImpl.listExecutionResults(
              (com.google.cloud.workloadmanager.v1.ListExecutionResultsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.workloadmanager.v1.ListExecutionResultsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_RULES:
          serviceImpl.listRules(
              (com.google.cloud.workloadmanager.v1.ListRulesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.workloadmanager.v1.ListRulesResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_SCANNED_RESOURCES:
          serviceImpl.listScannedResources(
              (com.google.cloud.workloadmanager.v1.ListScannedResourcesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.workloadmanager.v1.ListScannedResourcesResponse>)
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
            getListEvaluationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.workloadmanager.v1.ListEvaluationsRequest,
                    com.google.cloud.workloadmanager.v1.ListEvaluationsResponse>(
                    service, METHODID_LIST_EVALUATIONS)))
        .addMethod(
            getGetEvaluationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.workloadmanager.v1.GetEvaluationRequest,
                    com.google.cloud.workloadmanager.v1.Evaluation>(
                    service, METHODID_GET_EVALUATION)))
        .addMethod(
            getCreateEvaluationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.workloadmanager.v1.CreateEvaluationRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_EVALUATION)))
        .addMethod(
            getUpdateEvaluationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.workloadmanager.v1.UpdateEvaluationRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_EVALUATION)))
        .addMethod(
            getDeleteEvaluationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.workloadmanager.v1.DeleteEvaluationRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_EVALUATION)))
        .addMethod(
            getListExecutionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.workloadmanager.v1.ListExecutionsRequest,
                    com.google.cloud.workloadmanager.v1.ListExecutionsResponse>(
                    service, METHODID_LIST_EXECUTIONS)))
        .addMethod(
            getGetExecutionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.workloadmanager.v1.GetExecutionRequest,
                    com.google.cloud.workloadmanager.v1.Execution>(
                    service, METHODID_GET_EXECUTION)))
        .addMethod(
            getRunEvaluationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.workloadmanager.v1.RunEvaluationRequest,
                    com.google.longrunning.Operation>(service, METHODID_RUN_EVALUATION)))
        .addMethod(
            getDeleteExecutionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.workloadmanager.v1.DeleteExecutionRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_EXECUTION)))
        .addMethod(
            getListExecutionResultsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.workloadmanager.v1.ListExecutionResultsRequest,
                    com.google.cloud.workloadmanager.v1.ListExecutionResultsResponse>(
                    service, METHODID_LIST_EXECUTION_RESULTS)))
        .addMethod(
            getListRulesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.workloadmanager.v1.ListRulesRequest,
                    com.google.cloud.workloadmanager.v1.ListRulesResponse>(
                    service, METHODID_LIST_RULES)))
        .addMethod(
            getListScannedResourcesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.workloadmanager.v1.ListScannedResourcesRequest,
                    com.google.cloud.workloadmanager.v1.ListScannedResourcesResponse>(
                    service, METHODID_LIST_SCANNED_RESOURCES)))
        .build();
  }

  private abstract static class WorkloadManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WorkloadManagerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.workloadmanager.v1.WorkloadManagerServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WorkloadManager");
    }
  }

  private static final class WorkloadManagerFileDescriptorSupplier
      extends WorkloadManagerBaseDescriptorSupplier {
    WorkloadManagerFileDescriptorSupplier() {}
  }

  private static final class WorkloadManagerMethodDescriptorSupplier
      extends WorkloadManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    WorkloadManagerMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (WorkloadManagerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new WorkloadManagerFileDescriptorSupplier())
                      .addMethod(getListEvaluationsMethod())
                      .addMethod(getGetEvaluationMethod())
                      .addMethod(getCreateEvaluationMethod())
                      .addMethod(getUpdateEvaluationMethod())
                      .addMethod(getDeleteEvaluationMethod())
                      .addMethod(getListExecutionsMethod())
                      .addMethod(getGetExecutionMethod())
                      .addMethod(getRunEvaluationMethod())
                      .addMethod(getDeleteExecutionMethod())
                      .addMethod(getListExecutionResultsMethod())
                      .addMethod(getListRulesMethod())
                      .addMethod(getListScannedResourcesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
