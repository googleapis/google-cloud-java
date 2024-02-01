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
package com.google.cloud.telcoautomation.v1alpha1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * TelcoAutomation Service manages the control plane cluster a.k.a.
 * Orchestration Cluster (GKE cluster with config controller) of TNA. It also
 * exposes blueprint APIs which manages the lifecycle of blueprints that control
 * the infrastructure setup (e.g GDCE clusters) and deployment of network
 * functions.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/telcoautomation/v1alpha1/telcoautomation.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TelcoAutomationGrpc {

  private TelcoAutomationGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.telcoautomation.v1alpha1.TelcoAutomation";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.ListOrchestrationClustersRequest,
          com.google.cloud.telcoautomation.v1alpha1.ListOrchestrationClustersResponse>
      getListOrchestrationClustersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListOrchestrationClusters",
      requestType =
          com.google.cloud.telcoautomation.v1alpha1.ListOrchestrationClustersRequest.class,
      responseType =
          com.google.cloud.telcoautomation.v1alpha1.ListOrchestrationClustersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.ListOrchestrationClustersRequest,
          com.google.cloud.telcoautomation.v1alpha1.ListOrchestrationClustersResponse>
      getListOrchestrationClustersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.ListOrchestrationClustersRequest,
            com.google.cloud.telcoautomation.v1alpha1.ListOrchestrationClustersResponse>
        getListOrchestrationClustersMethod;
    if ((getListOrchestrationClustersMethod =
            TelcoAutomationGrpc.getListOrchestrationClustersMethod)
        == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getListOrchestrationClustersMethod =
                TelcoAutomationGrpc.getListOrchestrationClustersMethod)
            == null) {
          TelcoAutomationGrpc.getListOrchestrationClustersMethod =
              getListOrchestrationClustersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.ListOrchestrationClustersRequest,
                          com.google.cloud.telcoautomation.v1alpha1
                              .ListOrchestrationClustersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListOrchestrationClusters"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1
                                  .ListOrchestrationClustersRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1
                                  .ListOrchestrationClustersResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("ListOrchestrationClusters"))
                      .build();
        }
      }
    }
    return getListOrchestrationClustersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.GetOrchestrationClusterRequest,
          com.google.cloud.telcoautomation.v1alpha1.OrchestrationCluster>
      getGetOrchestrationClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOrchestrationCluster",
      requestType = com.google.cloud.telcoautomation.v1alpha1.GetOrchestrationClusterRequest.class,
      responseType = com.google.cloud.telcoautomation.v1alpha1.OrchestrationCluster.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.GetOrchestrationClusterRequest,
          com.google.cloud.telcoautomation.v1alpha1.OrchestrationCluster>
      getGetOrchestrationClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.GetOrchestrationClusterRequest,
            com.google.cloud.telcoautomation.v1alpha1.OrchestrationCluster>
        getGetOrchestrationClusterMethod;
    if ((getGetOrchestrationClusterMethod = TelcoAutomationGrpc.getGetOrchestrationClusterMethod)
        == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getGetOrchestrationClusterMethod =
                TelcoAutomationGrpc.getGetOrchestrationClusterMethod)
            == null) {
          TelcoAutomationGrpc.getGetOrchestrationClusterMethod =
              getGetOrchestrationClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.GetOrchestrationClusterRequest,
                          com.google.cloud.telcoautomation.v1alpha1.OrchestrationCluster>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetOrchestrationCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1
                                  .GetOrchestrationClusterRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.OrchestrationCluster
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("GetOrchestrationCluster"))
                      .build();
        }
      }
    }
    return getGetOrchestrationClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.CreateOrchestrationClusterRequest,
          com.google.longrunning.Operation>
      getCreateOrchestrationClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateOrchestrationCluster",
      requestType =
          com.google.cloud.telcoautomation.v1alpha1.CreateOrchestrationClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.CreateOrchestrationClusterRequest,
          com.google.longrunning.Operation>
      getCreateOrchestrationClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.CreateOrchestrationClusterRequest,
            com.google.longrunning.Operation>
        getCreateOrchestrationClusterMethod;
    if ((getCreateOrchestrationClusterMethod =
            TelcoAutomationGrpc.getCreateOrchestrationClusterMethod)
        == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getCreateOrchestrationClusterMethod =
                TelcoAutomationGrpc.getCreateOrchestrationClusterMethod)
            == null) {
          TelcoAutomationGrpc.getCreateOrchestrationClusterMethod =
              getCreateOrchestrationClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.CreateOrchestrationClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateOrchestrationCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1
                                  .CreateOrchestrationClusterRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("CreateOrchestrationCluster"))
                      .build();
        }
      }
    }
    return getCreateOrchestrationClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.DeleteOrchestrationClusterRequest,
          com.google.longrunning.Operation>
      getDeleteOrchestrationClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteOrchestrationCluster",
      requestType =
          com.google.cloud.telcoautomation.v1alpha1.DeleteOrchestrationClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.DeleteOrchestrationClusterRequest,
          com.google.longrunning.Operation>
      getDeleteOrchestrationClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.DeleteOrchestrationClusterRequest,
            com.google.longrunning.Operation>
        getDeleteOrchestrationClusterMethod;
    if ((getDeleteOrchestrationClusterMethod =
            TelcoAutomationGrpc.getDeleteOrchestrationClusterMethod)
        == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getDeleteOrchestrationClusterMethod =
                TelcoAutomationGrpc.getDeleteOrchestrationClusterMethod)
            == null) {
          TelcoAutomationGrpc.getDeleteOrchestrationClusterMethod =
              getDeleteOrchestrationClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.DeleteOrchestrationClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteOrchestrationCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1
                                  .DeleteOrchestrationClusterRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("DeleteOrchestrationCluster"))
                      .build();
        }
      }
    }
    return getDeleteOrchestrationClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.ListEdgeSlmsRequest,
          com.google.cloud.telcoautomation.v1alpha1.ListEdgeSlmsResponse>
      getListEdgeSlmsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEdgeSlms",
      requestType = com.google.cloud.telcoautomation.v1alpha1.ListEdgeSlmsRequest.class,
      responseType = com.google.cloud.telcoautomation.v1alpha1.ListEdgeSlmsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.ListEdgeSlmsRequest,
          com.google.cloud.telcoautomation.v1alpha1.ListEdgeSlmsResponse>
      getListEdgeSlmsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.ListEdgeSlmsRequest,
            com.google.cloud.telcoautomation.v1alpha1.ListEdgeSlmsResponse>
        getListEdgeSlmsMethod;
    if ((getListEdgeSlmsMethod = TelcoAutomationGrpc.getListEdgeSlmsMethod) == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getListEdgeSlmsMethod = TelcoAutomationGrpc.getListEdgeSlmsMethod) == null) {
          TelcoAutomationGrpc.getListEdgeSlmsMethod =
              getListEdgeSlmsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.ListEdgeSlmsRequest,
                          com.google.cloud.telcoautomation.v1alpha1.ListEdgeSlmsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEdgeSlms"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.ListEdgeSlmsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.ListEdgeSlmsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("ListEdgeSlms"))
                      .build();
        }
      }
    }
    return getListEdgeSlmsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.GetEdgeSlmRequest,
          com.google.cloud.telcoautomation.v1alpha1.EdgeSlm>
      getGetEdgeSlmMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEdgeSlm",
      requestType = com.google.cloud.telcoautomation.v1alpha1.GetEdgeSlmRequest.class,
      responseType = com.google.cloud.telcoautomation.v1alpha1.EdgeSlm.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.GetEdgeSlmRequest,
          com.google.cloud.telcoautomation.v1alpha1.EdgeSlm>
      getGetEdgeSlmMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.GetEdgeSlmRequest,
            com.google.cloud.telcoautomation.v1alpha1.EdgeSlm>
        getGetEdgeSlmMethod;
    if ((getGetEdgeSlmMethod = TelcoAutomationGrpc.getGetEdgeSlmMethod) == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getGetEdgeSlmMethod = TelcoAutomationGrpc.getGetEdgeSlmMethod) == null) {
          TelcoAutomationGrpc.getGetEdgeSlmMethod =
              getGetEdgeSlmMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.GetEdgeSlmRequest,
                          com.google.cloud.telcoautomation.v1alpha1.EdgeSlm>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEdgeSlm"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.GetEdgeSlmRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.EdgeSlm
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("GetEdgeSlm"))
                      .build();
        }
      }
    }
    return getGetEdgeSlmMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.CreateEdgeSlmRequest,
          com.google.longrunning.Operation>
      getCreateEdgeSlmMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEdgeSlm",
      requestType = com.google.cloud.telcoautomation.v1alpha1.CreateEdgeSlmRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.CreateEdgeSlmRequest,
          com.google.longrunning.Operation>
      getCreateEdgeSlmMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.CreateEdgeSlmRequest,
            com.google.longrunning.Operation>
        getCreateEdgeSlmMethod;
    if ((getCreateEdgeSlmMethod = TelcoAutomationGrpc.getCreateEdgeSlmMethod) == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getCreateEdgeSlmMethod = TelcoAutomationGrpc.getCreateEdgeSlmMethod) == null) {
          TelcoAutomationGrpc.getCreateEdgeSlmMethod =
              getCreateEdgeSlmMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.CreateEdgeSlmRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateEdgeSlm"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.CreateEdgeSlmRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("CreateEdgeSlm"))
                      .build();
        }
      }
    }
    return getCreateEdgeSlmMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.DeleteEdgeSlmRequest,
          com.google.longrunning.Operation>
      getDeleteEdgeSlmMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEdgeSlm",
      requestType = com.google.cloud.telcoautomation.v1alpha1.DeleteEdgeSlmRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.DeleteEdgeSlmRequest,
          com.google.longrunning.Operation>
      getDeleteEdgeSlmMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.DeleteEdgeSlmRequest,
            com.google.longrunning.Operation>
        getDeleteEdgeSlmMethod;
    if ((getDeleteEdgeSlmMethod = TelcoAutomationGrpc.getDeleteEdgeSlmMethod) == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getDeleteEdgeSlmMethod = TelcoAutomationGrpc.getDeleteEdgeSlmMethod) == null) {
          TelcoAutomationGrpc.getDeleteEdgeSlmMethod =
              getDeleteEdgeSlmMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.DeleteEdgeSlmRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteEdgeSlm"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.DeleteEdgeSlmRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("DeleteEdgeSlm"))
                      .build();
        }
      }
    }
    return getDeleteEdgeSlmMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.CreateBlueprintRequest,
          com.google.cloud.telcoautomation.v1alpha1.Blueprint>
      getCreateBlueprintMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBlueprint",
      requestType = com.google.cloud.telcoautomation.v1alpha1.CreateBlueprintRequest.class,
      responseType = com.google.cloud.telcoautomation.v1alpha1.Blueprint.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.CreateBlueprintRequest,
          com.google.cloud.telcoautomation.v1alpha1.Blueprint>
      getCreateBlueprintMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.CreateBlueprintRequest,
            com.google.cloud.telcoautomation.v1alpha1.Blueprint>
        getCreateBlueprintMethod;
    if ((getCreateBlueprintMethod = TelcoAutomationGrpc.getCreateBlueprintMethod) == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getCreateBlueprintMethod = TelcoAutomationGrpc.getCreateBlueprintMethod) == null) {
          TelcoAutomationGrpc.getCreateBlueprintMethod =
              getCreateBlueprintMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.CreateBlueprintRequest,
                          com.google.cloud.telcoautomation.v1alpha1.Blueprint>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBlueprint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.CreateBlueprintRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.Blueprint
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("CreateBlueprint"))
                      .build();
        }
      }
    }
    return getCreateBlueprintMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.UpdateBlueprintRequest,
          com.google.cloud.telcoautomation.v1alpha1.Blueprint>
      getUpdateBlueprintMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBlueprint",
      requestType = com.google.cloud.telcoautomation.v1alpha1.UpdateBlueprintRequest.class,
      responseType = com.google.cloud.telcoautomation.v1alpha1.Blueprint.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.UpdateBlueprintRequest,
          com.google.cloud.telcoautomation.v1alpha1.Blueprint>
      getUpdateBlueprintMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.UpdateBlueprintRequest,
            com.google.cloud.telcoautomation.v1alpha1.Blueprint>
        getUpdateBlueprintMethod;
    if ((getUpdateBlueprintMethod = TelcoAutomationGrpc.getUpdateBlueprintMethod) == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getUpdateBlueprintMethod = TelcoAutomationGrpc.getUpdateBlueprintMethod) == null) {
          TelcoAutomationGrpc.getUpdateBlueprintMethod =
              getUpdateBlueprintMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.UpdateBlueprintRequest,
                          com.google.cloud.telcoautomation.v1alpha1.Blueprint>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateBlueprint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.UpdateBlueprintRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.Blueprint
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("UpdateBlueprint"))
                      .build();
        }
      }
    }
    return getUpdateBlueprintMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.GetBlueprintRequest,
          com.google.cloud.telcoautomation.v1alpha1.Blueprint>
      getGetBlueprintMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBlueprint",
      requestType = com.google.cloud.telcoautomation.v1alpha1.GetBlueprintRequest.class,
      responseType = com.google.cloud.telcoautomation.v1alpha1.Blueprint.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.GetBlueprintRequest,
          com.google.cloud.telcoautomation.v1alpha1.Blueprint>
      getGetBlueprintMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.GetBlueprintRequest,
            com.google.cloud.telcoautomation.v1alpha1.Blueprint>
        getGetBlueprintMethod;
    if ((getGetBlueprintMethod = TelcoAutomationGrpc.getGetBlueprintMethod) == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getGetBlueprintMethod = TelcoAutomationGrpc.getGetBlueprintMethod) == null) {
          TelcoAutomationGrpc.getGetBlueprintMethod =
              getGetBlueprintMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.GetBlueprintRequest,
                          com.google.cloud.telcoautomation.v1alpha1.Blueprint>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBlueprint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.GetBlueprintRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.Blueprint
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("GetBlueprint"))
                      .build();
        }
      }
    }
    return getGetBlueprintMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.DeleteBlueprintRequest,
          com.google.protobuf.Empty>
      getDeleteBlueprintMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBlueprint",
      requestType = com.google.cloud.telcoautomation.v1alpha1.DeleteBlueprintRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.DeleteBlueprintRequest,
          com.google.protobuf.Empty>
      getDeleteBlueprintMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.DeleteBlueprintRequest,
            com.google.protobuf.Empty>
        getDeleteBlueprintMethod;
    if ((getDeleteBlueprintMethod = TelcoAutomationGrpc.getDeleteBlueprintMethod) == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getDeleteBlueprintMethod = TelcoAutomationGrpc.getDeleteBlueprintMethod) == null) {
          TelcoAutomationGrpc.getDeleteBlueprintMethod =
              getDeleteBlueprintMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.DeleteBlueprintRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBlueprint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.DeleteBlueprintRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("DeleteBlueprint"))
                      .build();
        }
      }
    }
    return getDeleteBlueprintMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.ListBlueprintsRequest,
          com.google.cloud.telcoautomation.v1alpha1.ListBlueprintsResponse>
      getListBlueprintsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBlueprints",
      requestType = com.google.cloud.telcoautomation.v1alpha1.ListBlueprintsRequest.class,
      responseType = com.google.cloud.telcoautomation.v1alpha1.ListBlueprintsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.ListBlueprintsRequest,
          com.google.cloud.telcoautomation.v1alpha1.ListBlueprintsResponse>
      getListBlueprintsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.ListBlueprintsRequest,
            com.google.cloud.telcoautomation.v1alpha1.ListBlueprintsResponse>
        getListBlueprintsMethod;
    if ((getListBlueprintsMethod = TelcoAutomationGrpc.getListBlueprintsMethod) == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getListBlueprintsMethod = TelcoAutomationGrpc.getListBlueprintsMethod) == null) {
          TelcoAutomationGrpc.getListBlueprintsMethod =
              getListBlueprintsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.ListBlueprintsRequest,
                          com.google.cloud.telcoautomation.v1alpha1.ListBlueprintsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBlueprints"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.ListBlueprintsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.ListBlueprintsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("ListBlueprints"))
                      .build();
        }
      }
    }
    return getListBlueprintsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.ApproveBlueprintRequest,
          com.google.cloud.telcoautomation.v1alpha1.Blueprint>
      getApproveBlueprintMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ApproveBlueprint",
      requestType = com.google.cloud.telcoautomation.v1alpha1.ApproveBlueprintRequest.class,
      responseType = com.google.cloud.telcoautomation.v1alpha1.Blueprint.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.ApproveBlueprintRequest,
          com.google.cloud.telcoautomation.v1alpha1.Blueprint>
      getApproveBlueprintMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.ApproveBlueprintRequest,
            com.google.cloud.telcoautomation.v1alpha1.Blueprint>
        getApproveBlueprintMethod;
    if ((getApproveBlueprintMethod = TelcoAutomationGrpc.getApproveBlueprintMethod) == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getApproveBlueprintMethod = TelcoAutomationGrpc.getApproveBlueprintMethod) == null) {
          TelcoAutomationGrpc.getApproveBlueprintMethod =
              getApproveBlueprintMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.ApproveBlueprintRequest,
                          com.google.cloud.telcoautomation.v1alpha1.Blueprint>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ApproveBlueprint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.ApproveBlueprintRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.Blueprint
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("ApproveBlueprint"))
                      .build();
        }
      }
    }
    return getApproveBlueprintMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.ProposeBlueprintRequest,
          com.google.cloud.telcoautomation.v1alpha1.Blueprint>
      getProposeBlueprintMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProposeBlueprint",
      requestType = com.google.cloud.telcoautomation.v1alpha1.ProposeBlueprintRequest.class,
      responseType = com.google.cloud.telcoautomation.v1alpha1.Blueprint.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.ProposeBlueprintRequest,
          com.google.cloud.telcoautomation.v1alpha1.Blueprint>
      getProposeBlueprintMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.ProposeBlueprintRequest,
            com.google.cloud.telcoautomation.v1alpha1.Blueprint>
        getProposeBlueprintMethod;
    if ((getProposeBlueprintMethod = TelcoAutomationGrpc.getProposeBlueprintMethod) == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getProposeBlueprintMethod = TelcoAutomationGrpc.getProposeBlueprintMethod) == null) {
          TelcoAutomationGrpc.getProposeBlueprintMethod =
              getProposeBlueprintMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.ProposeBlueprintRequest,
                          com.google.cloud.telcoautomation.v1alpha1.Blueprint>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ProposeBlueprint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.ProposeBlueprintRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.Blueprint
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("ProposeBlueprint"))
                      .build();
        }
      }
    }
    return getProposeBlueprintMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.RejectBlueprintRequest,
          com.google.cloud.telcoautomation.v1alpha1.Blueprint>
      getRejectBlueprintMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RejectBlueprint",
      requestType = com.google.cloud.telcoautomation.v1alpha1.RejectBlueprintRequest.class,
      responseType = com.google.cloud.telcoautomation.v1alpha1.Blueprint.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.RejectBlueprintRequest,
          com.google.cloud.telcoautomation.v1alpha1.Blueprint>
      getRejectBlueprintMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.RejectBlueprintRequest,
            com.google.cloud.telcoautomation.v1alpha1.Blueprint>
        getRejectBlueprintMethod;
    if ((getRejectBlueprintMethod = TelcoAutomationGrpc.getRejectBlueprintMethod) == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getRejectBlueprintMethod = TelcoAutomationGrpc.getRejectBlueprintMethod) == null) {
          TelcoAutomationGrpc.getRejectBlueprintMethod =
              getRejectBlueprintMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.RejectBlueprintRequest,
                          com.google.cloud.telcoautomation.v1alpha1.Blueprint>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RejectBlueprint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.RejectBlueprintRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.Blueprint
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("RejectBlueprint"))
                      .build();
        }
      }
    }
    return getRejectBlueprintMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.ListBlueprintRevisionsRequest,
          com.google.cloud.telcoautomation.v1alpha1.ListBlueprintRevisionsResponse>
      getListBlueprintRevisionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBlueprintRevisions",
      requestType = com.google.cloud.telcoautomation.v1alpha1.ListBlueprintRevisionsRequest.class,
      responseType = com.google.cloud.telcoautomation.v1alpha1.ListBlueprintRevisionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.ListBlueprintRevisionsRequest,
          com.google.cloud.telcoautomation.v1alpha1.ListBlueprintRevisionsResponse>
      getListBlueprintRevisionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.ListBlueprintRevisionsRequest,
            com.google.cloud.telcoautomation.v1alpha1.ListBlueprintRevisionsResponse>
        getListBlueprintRevisionsMethod;
    if ((getListBlueprintRevisionsMethod = TelcoAutomationGrpc.getListBlueprintRevisionsMethod)
        == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getListBlueprintRevisionsMethod = TelcoAutomationGrpc.getListBlueprintRevisionsMethod)
            == null) {
          TelcoAutomationGrpc.getListBlueprintRevisionsMethod =
              getListBlueprintRevisionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.ListBlueprintRevisionsRequest,
                          com.google.cloud.telcoautomation.v1alpha1.ListBlueprintRevisionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListBlueprintRevisions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1
                                  .ListBlueprintRevisionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1
                                  .ListBlueprintRevisionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("ListBlueprintRevisions"))
                      .build();
        }
      }
    }
    return getListBlueprintRevisionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.SearchBlueprintRevisionsRequest,
          com.google.cloud.telcoautomation.v1alpha1.SearchBlueprintRevisionsResponse>
      getSearchBlueprintRevisionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchBlueprintRevisions",
      requestType = com.google.cloud.telcoautomation.v1alpha1.SearchBlueprintRevisionsRequest.class,
      responseType =
          com.google.cloud.telcoautomation.v1alpha1.SearchBlueprintRevisionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.SearchBlueprintRevisionsRequest,
          com.google.cloud.telcoautomation.v1alpha1.SearchBlueprintRevisionsResponse>
      getSearchBlueprintRevisionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.SearchBlueprintRevisionsRequest,
            com.google.cloud.telcoautomation.v1alpha1.SearchBlueprintRevisionsResponse>
        getSearchBlueprintRevisionsMethod;
    if ((getSearchBlueprintRevisionsMethod = TelcoAutomationGrpc.getSearchBlueprintRevisionsMethod)
        == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getSearchBlueprintRevisionsMethod =
                TelcoAutomationGrpc.getSearchBlueprintRevisionsMethod)
            == null) {
          TelcoAutomationGrpc.getSearchBlueprintRevisionsMethod =
              getSearchBlueprintRevisionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.SearchBlueprintRevisionsRequest,
                          com.google.cloud.telcoautomation.v1alpha1
                              .SearchBlueprintRevisionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SearchBlueprintRevisions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1
                                  .SearchBlueprintRevisionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1
                                  .SearchBlueprintRevisionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("SearchBlueprintRevisions"))
                      .build();
        }
      }
    }
    return getSearchBlueprintRevisionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.SearchDeploymentRevisionsRequest,
          com.google.cloud.telcoautomation.v1alpha1.SearchDeploymentRevisionsResponse>
      getSearchDeploymentRevisionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchDeploymentRevisions",
      requestType =
          com.google.cloud.telcoautomation.v1alpha1.SearchDeploymentRevisionsRequest.class,
      responseType =
          com.google.cloud.telcoautomation.v1alpha1.SearchDeploymentRevisionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.SearchDeploymentRevisionsRequest,
          com.google.cloud.telcoautomation.v1alpha1.SearchDeploymentRevisionsResponse>
      getSearchDeploymentRevisionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.SearchDeploymentRevisionsRequest,
            com.google.cloud.telcoautomation.v1alpha1.SearchDeploymentRevisionsResponse>
        getSearchDeploymentRevisionsMethod;
    if ((getSearchDeploymentRevisionsMethod =
            TelcoAutomationGrpc.getSearchDeploymentRevisionsMethod)
        == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getSearchDeploymentRevisionsMethod =
                TelcoAutomationGrpc.getSearchDeploymentRevisionsMethod)
            == null) {
          TelcoAutomationGrpc.getSearchDeploymentRevisionsMethod =
              getSearchDeploymentRevisionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.SearchDeploymentRevisionsRequest,
                          com.google.cloud.telcoautomation.v1alpha1
                              .SearchDeploymentRevisionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SearchDeploymentRevisions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1
                                  .SearchDeploymentRevisionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1
                                  .SearchDeploymentRevisionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("SearchDeploymentRevisions"))
                      .build();
        }
      }
    }
    return getSearchDeploymentRevisionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.DiscardBlueprintChangesRequest,
          com.google.cloud.telcoautomation.v1alpha1.DiscardBlueprintChangesResponse>
      getDiscardBlueprintChangesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DiscardBlueprintChanges",
      requestType = com.google.cloud.telcoautomation.v1alpha1.DiscardBlueprintChangesRequest.class,
      responseType =
          com.google.cloud.telcoautomation.v1alpha1.DiscardBlueprintChangesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.DiscardBlueprintChangesRequest,
          com.google.cloud.telcoautomation.v1alpha1.DiscardBlueprintChangesResponse>
      getDiscardBlueprintChangesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.DiscardBlueprintChangesRequest,
            com.google.cloud.telcoautomation.v1alpha1.DiscardBlueprintChangesResponse>
        getDiscardBlueprintChangesMethod;
    if ((getDiscardBlueprintChangesMethod = TelcoAutomationGrpc.getDiscardBlueprintChangesMethod)
        == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getDiscardBlueprintChangesMethod =
                TelcoAutomationGrpc.getDiscardBlueprintChangesMethod)
            == null) {
          TelcoAutomationGrpc.getDiscardBlueprintChangesMethod =
              getDiscardBlueprintChangesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.DiscardBlueprintChangesRequest,
                          com.google.cloud.telcoautomation.v1alpha1.DiscardBlueprintChangesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DiscardBlueprintChanges"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1
                                  .DiscardBlueprintChangesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1
                                  .DiscardBlueprintChangesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("DiscardBlueprintChanges"))
                      .build();
        }
      }
    }
    return getDiscardBlueprintChangesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.ListPublicBlueprintsRequest,
          com.google.cloud.telcoautomation.v1alpha1.ListPublicBlueprintsResponse>
      getListPublicBlueprintsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPublicBlueprints",
      requestType = com.google.cloud.telcoautomation.v1alpha1.ListPublicBlueprintsRequest.class,
      responseType = com.google.cloud.telcoautomation.v1alpha1.ListPublicBlueprintsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.ListPublicBlueprintsRequest,
          com.google.cloud.telcoautomation.v1alpha1.ListPublicBlueprintsResponse>
      getListPublicBlueprintsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.ListPublicBlueprintsRequest,
            com.google.cloud.telcoautomation.v1alpha1.ListPublicBlueprintsResponse>
        getListPublicBlueprintsMethod;
    if ((getListPublicBlueprintsMethod = TelcoAutomationGrpc.getListPublicBlueprintsMethod)
        == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getListPublicBlueprintsMethod = TelcoAutomationGrpc.getListPublicBlueprintsMethod)
            == null) {
          TelcoAutomationGrpc.getListPublicBlueprintsMethod =
              getListPublicBlueprintsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.ListPublicBlueprintsRequest,
                          com.google.cloud.telcoautomation.v1alpha1.ListPublicBlueprintsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListPublicBlueprints"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.ListPublicBlueprintsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.ListPublicBlueprintsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("ListPublicBlueprints"))
                      .build();
        }
      }
    }
    return getListPublicBlueprintsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.GetPublicBlueprintRequest,
          com.google.cloud.telcoautomation.v1alpha1.PublicBlueprint>
      getGetPublicBlueprintMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPublicBlueprint",
      requestType = com.google.cloud.telcoautomation.v1alpha1.GetPublicBlueprintRequest.class,
      responseType = com.google.cloud.telcoautomation.v1alpha1.PublicBlueprint.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.GetPublicBlueprintRequest,
          com.google.cloud.telcoautomation.v1alpha1.PublicBlueprint>
      getGetPublicBlueprintMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.GetPublicBlueprintRequest,
            com.google.cloud.telcoautomation.v1alpha1.PublicBlueprint>
        getGetPublicBlueprintMethod;
    if ((getGetPublicBlueprintMethod = TelcoAutomationGrpc.getGetPublicBlueprintMethod) == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getGetPublicBlueprintMethod = TelcoAutomationGrpc.getGetPublicBlueprintMethod)
            == null) {
          TelcoAutomationGrpc.getGetPublicBlueprintMethod =
              getGetPublicBlueprintMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.GetPublicBlueprintRequest,
                          com.google.cloud.telcoautomation.v1alpha1.PublicBlueprint>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPublicBlueprint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.GetPublicBlueprintRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.PublicBlueprint
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("GetPublicBlueprint"))
                      .build();
        }
      }
    }
    return getGetPublicBlueprintMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.CreateDeploymentRequest,
          com.google.cloud.telcoautomation.v1alpha1.Deployment>
      getCreateDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDeployment",
      requestType = com.google.cloud.telcoautomation.v1alpha1.CreateDeploymentRequest.class,
      responseType = com.google.cloud.telcoautomation.v1alpha1.Deployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.CreateDeploymentRequest,
          com.google.cloud.telcoautomation.v1alpha1.Deployment>
      getCreateDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.CreateDeploymentRequest,
            com.google.cloud.telcoautomation.v1alpha1.Deployment>
        getCreateDeploymentMethod;
    if ((getCreateDeploymentMethod = TelcoAutomationGrpc.getCreateDeploymentMethod) == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getCreateDeploymentMethod = TelcoAutomationGrpc.getCreateDeploymentMethod) == null) {
          TelcoAutomationGrpc.getCreateDeploymentMethod =
              getCreateDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.CreateDeploymentRequest,
                          com.google.cloud.telcoautomation.v1alpha1.Deployment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.CreateDeploymentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.Deployment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("CreateDeployment"))
                      .build();
        }
      }
    }
    return getCreateDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.UpdateDeploymentRequest,
          com.google.cloud.telcoautomation.v1alpha1.Deployment>
      getUpdateDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDeployment",
      requestType = com.google.cloud.telcoautomation.v1alpha1.UpdateDeploymentRequest.class,
      responseType = com.google.cloud.telcoautomation.v1alpha1.Deployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.UpdateDeploymentRequest,
          com.google.cloud.telcoautomation.v1alpha1.Deployment>
      getUpdateDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.UpdateDeploymentRequest,
            com.google.cloud.telcoautomation.v1alpha1.Deployment>
        getUpdateDeploymentMethod;
    if ((getUpdateDeploymentMethod = TelcoAutomationGrpc.getUpdateDeploymentMethod) == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getUpdateDeploymentMethod = TelcoAutomationGrpc.getUpdateDeploymentMethod) == null) {
          TelcoAutomationGrpc.getUpdateDeploymentMethod =
              getUpdateDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.UpdateDeploymentRequest,
                          com.google.cloud.telcoautomation.v1alpha1.Deployment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.UpdateDeploymentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.Deployment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("UpdateDeployment"))
                      .build();
        }
      }
    }
    return getUpdateDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.GetDeploymentRequest,
          com.google.cloud.telcoautomation.v1alpha1.Deployment>
      getGetDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDeployment",
      requestType = com.google.cloud.telcoautomation.v1alpha1.GetDeploymentRequest.class,
      responseType = com.google.cloud.telcoautomation.v1alpha1.Deployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.GetDeploymentRequest,
          com.google.cloud.telcoautomation.v1alpha1.Deployment>
      getGetDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.GetDeploymentRequest,
            com.google.cloud.telcoautomation.v1alpha1.Deployment>
        getGetDeploymentMethod;
    if ((getGetDeploymentMethod = TelcoAutomationGrpc.getGetDeploymentMethod) == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getGetDeploymentMethod = TelcoAutomationGrpc.getGetDeploymentMethod) == null) {
          TelcoAutomationGrpc.getGetDeploymentMethod =
              getGetDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.GetDeploymentRequest,
                          com.google.cloud.telcoautomation.v1alpha1.Deployment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.GetDeploymentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.Deployment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("GetDeployment"))
                      .build();
        }
      }
    }
    return getGetDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.RemoveDeploymentRequest,
          com.google.protobuf.Empty>
      getRemoveDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveDeployment",
      requestType = com.google.cloud.telcoautomation.v1alpha1.RemoveDeploymentRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.RemoveDeploymentRequest,
          com.google.protobuf.Empty>
      getRemoveDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.RemoveDeploymentRequest,
            com.google.protobuf.Empty>
        getRemoveDeploymentMethod;
    if ((getRemoveDeploymentMethod = TelcoAutomationGrpc.getRemoveDeploymentMethod) == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getRemoveDeploymentMethod = TelcoAutomationGrpc.getRemoveDeploymentMethod) == null) {
          TelcoAutomationGrpc.getRemoveDeploymentMethod =
              getRemoveDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.RemoveDeploymentRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RemoveDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.RemoveDeploymentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("RemoveDeployment"))
                      .build();
        }
      }
    }
    return getRemoveDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.ListDeploymentsRequest,
          com.google.cloud.telcoautomation.v1alpha1.ListDeploymentsResponse>
      getListDeploymentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDeployments",
      requestType = com.google.cloud.telcoautomation.v1alpha1.ListDeploymentsRequest.class,
      responseType = com.google.cloud.telcoautomation.v1alpha1.ListDeploymentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.ListDeploymentsRequest,
          com.google.cloud.telcoautomation.v1alpha1.ListDeploymentsResponse>
      getListDeploymentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.ListDeploymentsRequest,
            com.google.cloud.telcoautomation.v1alpha1.ListDeploymentsResponse>
        getListDeploymentsMethod;
    if ((getListDeploymentsMethod = TelcoAutomationGrpc.getListDeploymentsMethod) == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getListDeploymentsMethod = TelcoAutomationGrpc.getListDeploymentsMethod) == null) {
          TelcoAutomationGrpc.getListDeploymentsMethod =
              getListDeploymentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.ListDeploymentsRequest,
                          com.google.cloud.telcoautomation.v1alpha1.ListDeploymentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDeployments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.ListDeploymentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.ListDeploymentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("ListDeployments"))
                      .build();
        }
      }
    }
    return getListDeploymentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.ListDeploymentRevisionsRequest,
          com.google.cloud.telcoautomation.v1alpha1.ListDeploymentRevisionsResponse>
      getListDeploymentRevisionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDeploymentRevisions",
      requestType = com.google.cloud.telcoautomation.v1alpha1.ListDeploymentRevisionsRequest.class,
      responseType =
          com.google.cloud.telcoautomation.v1alpha1.ListDeploymentRevisionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.ListDeploymentRevisionsRequest,
          com.google.cloud.telcoautomation.v1alpha1.ListDeploymentRevisionsResponse>
      getListDeploymentRevisionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.ListDeploymentRevisionsRequest,
            com.google.cloud.telcoautomation.v1alpha1.ListDeploymentRevisionsResponse>
        getListDeploymentRevisionsMethod;
    if ((getListDeploymentRevisionsMethod = TelcoAutomationGrpc.getListDeploymentRevisionsMethod)
        == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getListDeploymentRevisionsMethod =
                TelcoAutomationGrpc.getListDeploymentRevisionsMethod)
            == null) {
          TelcoAutomationGrpc.getListDeploymentRevisionsMethod =
              getListDeploymentRevisionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.ListDeploymentRevisionsRequest,
                          com.google.cloud.telcoautomation.v1alpha1.ListDeploymentRevisionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListDeploymentRevisions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1
                                  .ListDeploymentRevisionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1
                                  .ListDeploymentRevisionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("ListDeploymentRevisions"))
                      .build();
        }
      }
    }
    return getListDeploymentRevisionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.DiscardDeploymentChangesRequest,
          com.google.cloud.telcoautomation.v1alpha1.DiscardDeploymentChangesResponse>
      getDiscardDeploymentChangesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DiscardDeploymentChanges",
      requestType = com.google.cloud.telcoautomation.v1alpha1.DiscardDeploymentChangesRequest.class,
      responseType =
          com.google.cloud.telcoautomation.v1alpha1.DiscardDeploymentChangesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.DiscardDeploymentChangesRequest,
          com.google.cloud.telcoautomation.v1alpha1.DiscardDeploymentChangesResponse>
      getDiscardDeploymentChangesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.DiscardDeploymentChangesRequest,
            com.google.cloud.telcoautomation.v1alpha1.DiscardDeploymentChangesResponse>
        getDiscardDeploymentChangesMethod;
    if ((getDiscardDeploymentChangesMethod = TelcoAutomationGrpc.getDiscardDeploymentChangesMethod)
        == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getDiscardDeploymentChangesMethod =
                TelcoAutomationGrpc.getDiscardDeploymentChangesMethod)
            == null) {
          TelcoAutomationGrpc.getDiscardDeploymentChangesMethod =
              getDiscardDeploymentChangesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.DiscardDeploymentChangesRequest,
                          com.google.cloud.telcoautomation.v1alpha1
                              .DiscardDeploymentChangesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DiscardDeploymentChanges"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1
                                  .DiscardDeploymentChangesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1
                                  .DiscardDeploymentChangesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("DiscardDeploymentChanges"))
                      .build();
        }
      }
    }
    return getDiscardDeploymentChangesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.ApplyDeploymentRequest,
          com.google.cloud.telcoautomation.v1alpha1.Deployment>
      getApplyDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ApplyDeployment",
      requestType = com.google.cloud.telcoautomation.v1alpha1.ApplyDeploymentRequest.class,
      responseType = com.google.cloud.telcoautomation.v1alpha1.Deployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.ApplyDeploymentRequest,
          com.google.cloud.telcoautomation.v1alpha1.Deployment>
      getApplyDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.ApplyDeploymentRequest,
            com.google.cloud.telcoautomation.v1alpha1.Deployment>
        getApplyDeploymentMethod;
    if ((getApplyDeploymentMethod = TelcoAutomationGrpc.getApplyDeploymentMethod) == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getApplyDeploymentMethod = TelcoAutomationGrpc.getApplyDeploymentMethod) == null) {
          TelcoAutomationGrpc.getApplyDeploymentMethod =
              getApplyDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.ApplyDeploymentRequest,
                          com.google.cloud.telcoautomation.v1alpha1.Deployment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ApplyDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.ApplyDeploymentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.Deployment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("ApplyDeployment"))
                      .build();
        }
      }
    }
    return getApplyDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.ComputeDeploymentStatusRequest,
          com.google.cloud.telcoautomation.v1alpha1.ComputeDeploymentStatusResponse>
      getComputeDeploymentStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ComputeDeploymentStatus",
      requestType = com.google.cloud.telcoautomation.v1alpha1.ComputeDeploymentStatusRequest.class,
      responseType =
          com.google.cloud.telcoautomation.v1alpha1.ComputeDeploymentStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.ComputeDeploymentStatusRequest,
          com.google.cloud.telcoautomation.v1alpha1.ComputeDeploymentStatusResponse>
      getComputeDeploymentStatusMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.ComputeDeploymentStatusRequest,
            com.google.cloud.telcoautomation.v1alpha1.ComputeDeploymentStatusResponse>
        getComputeDeploymentStatusMethod;
    if ((getComputeDeploymentStatusMethod = TelcoAutomationGrpc.getComputeDeploymentStatusMethod)
        == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getComputeDeploymentStatusMethod =
                TelcoAutomationGrpc.getComputeDeploymentStatusMethod)
            == null) {
          TelcoAutomationGrpc.getComputeDeploymentStatusMethod =
              getComputeDeploymentStatusMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.ComputeDeploymentStatusRequest,
                          com.google.cloud.telcoautomation.v1alpha1.ComputeDeploymentStatusResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ComputeDeploymentStatus"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1
                                  .ComputeDeploymentStatusRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1
                                  .ComputeDeploymentStatusResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("ComputeDeploymentStatus"))
                      .build();
        }
      }
    }
    return getComputeDeploymentStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.RollbackDeploymentRequest,
          com.google.cloud.telcoautomation.v1alpha1.Deployment>
      getRollbackDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RollbackDeployment",
      requestType = com.google.cloud.telcoautomation.v1alpha1.RollbackDeploymentRequest.class,
      responseType = com.google.cloud.telcoautomation.v1alpha1.Deployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.RollbackDeploymentRequest,
          com.google.cloud.telcoautomation.v1alpha1.Deployment>
      getRollbackDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.RollbackDeploymentRequest,
            com.google.cloud.telcoautomation.v1alpha1.Deployment>
        getRollbackDeploymentMethod;
    if ((getRollbackDeploymentMethod = TelcoAutomationGrpc.getRollbackDeploymentMethod) == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getRollbackDeploymentMethod = TelcoAutomationGrpc.getRollbackDeploymentMethod)
            == null) {
          TelcoAutomationGrpc.getRollbackDeploymentMethod =
              getRollbackDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.RollbackDeploymentRequest,
                          com.google.cloud.telcoautomation.v1alpha1.Deployment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RollbackDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.RollbackDeploymentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.Deployment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("RollbackDeployment"))
                      .build();
        }
      }
    }
    return getRollbackDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.GetHydratedDeploymentRequest,
          com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment>
      getGetHydratedDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetHydratedDeployment",
      requestType = com.google.cloud.telcoautomation.v1alpha1.GetHydratedDeploymentRequest.class,
      responseType = com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.GetHydratedDeploymentRequest,
          com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment>
      getGetHydratedDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.GetHydratedDeploymentRequest,
            com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment>
        getGetHydratedDeploymentMethod;
    if ((getGetHydratedDeploymentMethod = TelcoAutomationGrpc.getGetHydratedDeploymentMethod)
        == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getGetHydratedDeploymentMethod = TelcoAutomationGrpc.getGetHydratedDeploymentMethod)
            == null) {
          TelcoAutomationGrpc.getGetHydratedDeploymentMethod =
              getGetHydratedDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.GetHydratedDeploymentRequest,
                          com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetHydratedDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.GetHydratedDeploymentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("GetHydratedDeployment"))
                      .build();
        }
      }
    }
    return getGetHydratedDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.ListHydratedDeploymentsRequest,
          com.google.cloud.telcoautomation.v1alpha1.ListHydratedDeploymentsResponse>
      getListHydratedDeploymentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListHydratedDeployments",
      requestType = com.google.cloud.telcoautomation.v1alpha1.ListHydratedDeploymentsRequest.class,
      responseType =
          com.google.cloud.telcoautomation.v1alpha1.ListHydratedDeploymentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.ListHydratedDeploymentsRequest,
          com.google.cloud.telcoautomation.v1alpha1.ListHydratedDeploymentsResponse>
      getListHydratedDeploymentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.ListHydratedDeploymentsRequest,
            com.google.cloud.telcoautomation.v1alpha1.ListHydratedDeploymentsResponse>
        getListHydratedDeploymentsMethod;
    if ((getListHydratedDeploymentsMethod = TelcoAutomationGrpc.getListHydratedDeploymentsMethod)
        == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getListHydratedDeploymentsMethod =
                TelcoAutomationGrpc.getListHydratedDeploymentsMethod)
            == null) {
          TelcoAutomationGrpc.getListHydratedDeploymentsMethod =
              getListHydratedDeploymentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.ListHydratedDeploymentsRequest,
                          com.google.cloud.telcoautomation.v1alpha1.ListHydratedDeploymentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListHydratedDeployments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1
                                  .ListHydratedDeploymentsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1
                                  .ListHydratedDeploymentsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("ListHydratedDeployments"))
                      .build();
        }
      }
    }
    return getListHydratedDeploymentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.UpdateHydratedDeploymentRequest,
          com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment>
      getUpdateHydratedDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateHydratedDeployment",
      requestType = com.google.cloud.telcoautomation.v1alpha1.UpdateHydratedDeploymentRequest.class,
      responseType = com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.UpdateHydratedDeploymentRequest,
          com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment>
      getUpdateHydratedDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.UpdateHydratedDeploymentRequest,
            com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment>
        getUpdateHydratedDeploymentMethod;
    if ((getUpdateHydratedDeploymentMethod = TelcoAutomationGrpc.getUpdateHydratedDeploymentMethod)
        == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getUpdateHydratedDeploymentMethod =
                TelcoAutomationGrpc.getUpdateHydratedDeploymentMethod)
            == null) {
          TelcoAutomationGrpc.getUpdateHydratedDeploymentMethod =
              getUpdateHydratedDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.UpdateHydratedDeploymentRequest,
                          com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateHydratedDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1
                                  .UpdateHydratedDeploymentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("UpdateHydratedDeployment"))
                      .build();
        }
      }
    }
    return getUpdateHydratedDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.ApplyHydratedDeploymentRequest,
          com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment>
      getApplyHydratedDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ApplyHydratedDeployment",
      requestType = com.google.cloud.telcoautomation.v1alpha1.ApplyHydratedDeploymentRequest.class,
      responseType = com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.telcoautomation.v1alpha1.ApplyHydratedDeploymentRequest,
          com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment>
      getApplyHydratedDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.telcoautomation.v1alpha1.ApplyHydratedDeploymentRequest,
            com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment>
        getApplyHydratedDeploymentMethod;
    if ((getApplyHydratedDeploymentMethod = TelcoAutomationGrpc.getApplyHydratedDeploymentMethod)
        == null) {
      synchronized (TelcoAutomationGrpc.class) {
        if ((getApplyHydratedDeploymentMethod =
                TelcoAutomationGrpc.getApplyHydratedDeploymentMethod)
            == null) {
          TelcoAutomationGrpc.getApplyHydratedDeploymentMethod =
              getApplyHydratedDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.telcoautomation.v1alpha1.ApplyHydratedDeploymentRequest,
                          com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ApplyHydratedDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1
                                  .ApplyHydratedDeploymentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TelcoAutomationMethodDescriptorSupplier("ApplyHydratedDeployment"))
                      .build();
        }
      }
    }
    return getApplyHydratedDeploymentMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static TelcoAutomationStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TelcoAutomationStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TelcoAutomationStub>() {
          @java.lang.Override
          public TelcoAutomationStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TelcoAutomationStub(channel, callOptions);
          }
        };
    return TelcoAutomationStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TelcoAutomationBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TelcoAutomationBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TelcoAutomationBlockingStub>() {
          @java.lang.Override
          public TelcoAutomationBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TelcoAutomationBlockingStub(channel, callOptions);
          }
        };
    return TelcoAutomationBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static TelcoAutomationFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TelcoAutomationFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TelcoAutomationFutureStub>() {
          @java.lang.Override
          public TelcoAutomationFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TelcoAutomationFutureStub(channel, callOptions);
          }
        };
    return TelcoAutomationFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * TelcoAutomation Service manages the control plane cluster a.k.a.
   * Orchestration Cluster (GKE cluster with config controller) of TNA. It also
   * exposes blueprint APIs which manages the lifecycle of blueprints that control
   * the infrastructure setup (e.g GDCE clusters) and deployment of network
   * functions.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists OrchestrationClusters in a given project and location.
     * </pre>
     */
    default void listOrchestrationClusters(
        com.google.cloud.telcoautomation.v1alpha1.ListOrchestrationClustersRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.telcoautomation.v1alpha1.ListOrchestrationClustersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListOrchestrationClustersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single OrchestrationCluster.
     * </pre>
     */
    default void getOrchestrationCluster(
        com.google.cloud.telcoautomation.v1alpha1.GetOrchestrationClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.OrchestrationCluster>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetOrchestrationClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new OrchestrationCluster in a given project and location.
     * </pre>
     */
    default void createOrchestrationCluster(
        com.google.cloud.telcoautomation.v1alpha1.CreateOrchestrationClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateOrchestrationClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single OrchestrationCluster.
     * </pre>
     */
    default void deleteOrchestrationCluster(
        com.google.cloud.telcoautomation.v1alpha1.DeleteOrchestrationClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteOrchestrationClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists EdgeSlms in a given project and location.
     * </pre>
     */
    default void listEdgeSlms(
        com.google.cloud.telcoautomation.v1alpha1.ListEdgeSlmsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.ListEdgeSlmsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEdgeSlmsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single EdgeSlm.
     * </pre>
     */
    default void getEdgeSlm(
        com.google.cloud.telcoautomation.v1alpha1.GetEdgeSlmRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.EdgeSlm>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetEdgeSlmMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new EdgeSlm in a given project and location.
     * </pre>
     */
    default void createEdgeSlm(
        com.google.cloud.telcoautomation.v1alpha1.CreateEdgeSlmRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateEdgeSlmMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single EdgeSlm.
     * </pre>
     */
    default void deleteEdgeSlm(
        com.google.cloud.telcoautomation.v1alpha1.DeleteEdgeSlmRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteEdgeSlmMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a blueprint.
     * </pre>
     */
    default void createBlueprint(
        com.google.cloud.telcoautomation.v1alpha1.CreateBlueprintRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.Blueprint>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateBlueprintMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a blueprint.
     * </pre>
     */
    default void updateBlueprint(
        com.google.cloud.telcoautomation.v1alpha1.UpdateBlueprintRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.Blueprint>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateBlueprintMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested blueprint.
     * </pre>
     */
    default void getBlueprint(
        com.google.cloud.telcoautomation.v1alpha1.GetBlueprintRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.Blueprint>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetBlueprintMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a blueprint and all its revisions.
     * </pre>
     */
    default void deleteBlueprint(
        com.google.cloud.telcoautomation.v1alpha1.DeleteBlueprintRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteBlueprintMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all blueprints.
     * </pre>
     */
    default void listBlueprints(
        com.google.cloud.telcoautomation.v1alpha1.ListBlueprintsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.telcoautomation.v1alpha1.ListBlueprintsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBlueprintsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Approves a blueprint and commits a new revision.
     * </pre>
     */
    default void approveBlueprint(
        com.google.cloud.telcoautomation.v1alpha1.ApproveBlueprintRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.Blueprint>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getApproveBlueprintMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Proposes a blueprint for approval of changes.
     * </pre>
     */
    default void proposeBlueprint(
        com.google.cloud.telcoautomation.v1alpha1.ProposeBlueprintRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.Blueprint>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getProposeBlueprintMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Rejects a blueprint revision proposal and flips it back to Draft state.
     * </pre>
     */
    default void rejectBlueprint(
        com.google.cloud.telcoautomation.v1alpha1.RejectBlueprintRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.Blueprint>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRejectBlueprintMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List blueprint revisions of a given blueprint.
     * </pre>
     */
    default void listBlueprintRevisions(
        com.google.cloud.telcoautomation.v1alpha1.ListBlueprintRevisionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.telcoautomation.v1alpha1.ListBlueprintRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBlueprintRevisionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches across blueprint revisions.
     * </pre>
     */
    default void searchBlueprintRevisions(
        com.google.cloud.telcoautomation.v1alpha1.SearchBlueprintRevisionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.telcoautomation.v1alpha1.SearchBlueprintRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchBlueprintRevisionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches across deployment revisions.
     * </pre>
     */
    default void searchDeploymentRevisions(
        com.google.cloud.telcoautomation.v1alpha1.SearchDeploymentRevisionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.telcoautomation.v1alpha1.SearchDeploymentRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchDeploymentRevisionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Discards the changes in a blueprint and reverts the blueprint to the last
     * approved blueprint revision. No changes take place if a blueprint does not
     * have revisions.
     * </pre>
     */
    default void discardBlueprintChanges(
        com.google.cloud.telcoautomation.v1alpha1.DiscardBlueprintChangesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.telcoautomation.v1alpha1.DiscardBlueprintChangesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDiscardBlueprintChangesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the blueprints in TNA's public catalog. Default page size = 20,
     * Max Page Size = 100.
     * </pre>
     */
    default void listPublicBlueprints(
        com.google.cloud.telcoautomation.v1alpha1.ListPublicBlueprintsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.telcoautomation.v1alpha1.ListPublicBlueprintsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPublicBlueprintsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested public blueprint.
     * </pre>
     */
    default void getPublicBlueprint(
        com.google.cloud.telcoautomation.v1alpha1.GetPublicBlueprintRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.PublicBlueprint>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetPublicBlueprintMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a deployment.
     * </pre>
     */
    default void createDeployment(
        com.google.cloud.telcoautomation.v1alpha1.CreateDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.Deployment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a deployment.
     * </pre>
     */
    default void updateDeployment(
        com.google.cloud.telcoautomation.v1alpha1.UpdateDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.Deployment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested deployment.
     * </pre>
     */
    default void getDeployment(
        com.google.cloud.telcoautomation.v1alpha1.GetDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.Deployment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes the deployment by marking it as DELETING. Post which deployment and
     * it's revisions gets deleted.
     * </pre>
     */
    default void removeDeployment(
        com.google.cloud.telcoautomation.v1alpha1.RemoveDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRemoveDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all deployments.
     * </pre>
     */
    default void listDeployments(
        com.google.cloud.telcoautomation.v1alpha1.ListDeploymentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.telcoautomation.v1alpha1.ListDeploymentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDeploymentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List deployment revisions of a given deployment.
     * </pre>
     */
    default void listDeploymentRevisions(
        com.google.cloud.telcoautomation.v1alpha1.ListDeploymentRevisionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.telcoautomation.v1alpha1.ListDeploymentRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDeploymentRevisionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Discards the changes in a deployment and reverts the deployment to the last
     * approved deployment revision. No changes take place if a deployment does
     * not have revisions.
     * </pre>
     */
    default void discardDeploymentChanges(
        com.google.cloud.telcoautomation.v1alpha1.DiscardDeploymentChangesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.telcoautomation.v1alpha1.DiscardDeploymentChangesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDiscardDeploymentChangesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Applies the deployment's YAML files to the parent orchestration cluster.
     * </pre>
     */
    default void applyDeployment(
        com.google.cloud.telcoautomation.v1alpha1.ApplyDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.Deployment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getApplyDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested deployment status.
     * </pre>
     */
    default void computeDeploymentStatus(
        com.google.cloud.telcoautomation.v1alpha1.ComputeDeploymentStatusRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.telcoautomation.v1alpha1.ComputeDeploymentStatusResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getComputeDeploymentStatusMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Rollback the active deployment to the given past approved deployment
     * revision.
     * </pre>
     */
    default void rollbackDeployment(
        com.google.cloud.telcoautomation.v1alpha1.RollbackDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.Deployment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRollbackDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested hydrated deployment.
     * </pre>
     */
    default void getHydratedDeployment(
        com.google.cloud.telcoautomation.v1alpha1.GetHydratedDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetHydratedDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all hydrated deployments present under a deployment.
     * </pre>
     */
    default void listHydratedDeployments(
        com.google.cloud.telcoautomation.v1alpha1.ListHydratedDeploymentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.telcoautomation.v1alpha1.ListHydratedDeploymentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListHydratedDeploymentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a hydrated deployment.
     * </pre>
     */
    default void updateHydratedDeployment(
        com.google.cloud.telcoautomation.v1alpha1.UpdateHydratedDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateHydratedDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Applies a hydrated deployment to a workload cluster.
     * </pre>
     */
    default void applyHydratedDeployment(
        com.google.cloud.telcoautomation.v1alpha1.ApplyHydratedDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getApplyHydratedDeploymentMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service TelcoAutomation.
   *
   * <pre>
   * TelcoAutomation Service manages the control plane cluster a.k.a.
   * Orchestration Cluster (GKE cluster with config controller) of TNA. It also
   * exposes blueprint APIs which manages the lifecycle of blueprints that control
   * the infrastructure setup (e.g GDCE clusters) and deployment of network
   * functions.
   * </pre>
   */
  public abstract static class TelcoAutomationImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return TelcoAutomationGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service TelcoAutomation.
   *
   * <pre>
   * TelcoAutomation Service manages the control plane cluster a.k.a.
   * Orchestration Cluster (GKE cluster with config controller) of TNA. It also
   * exposes blueprint APIs which manages the lifecycle of blueprints that control
   * the infrastructure setup (e.g GDCE clusters) and deployment of network
   * functions.
   * </pre>
   */
  public static final class TelcoAutomationStub
      extends io.grpc.stub.AbstractAsyncStub<TelcoAutomationStub> {
    private TelcoAutomationStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TelcoAutomationStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TelcoAutomationStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists OrchestrationClusters in a given project and location.
     * </pre>
     */
    public void listOrchestrationClusters(
        com.google.cloud.telcoautomation.v1alpha1.ListOrchestrationClustersRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.telcoautomation.v1alpha1.ListOrchestrationClustersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListOrchestrationClustersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single OrchestrationCluster.
     * </pre>
     */
    public void getOrchestrationCluster(
        com.google.cloud.telcoautomation.v1alpha1.GetOrchestrationClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.OrchestrationCluster>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOrchestrationClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new OrchestrationCluster in a given project and location.
     * </pre>
     */
    public void createOrchestrationCluster(
        com.google.cloud.telcoautomation.v1alpha1.CreateOrchestrationClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateOrchestrationClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single OrchestrationCluster.
     * </pre>
     */
    public void deleteOrchestrationCluster(
        com.google.cloud.telcoautomation.v1alpha1.DeleteOrchestrationClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteOrchestrationClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists EdgeSlms in a given project and location.
     * </pre>
     */
    public void listEdgeSlms(
        com.google.cloud.telcoautomation.v1alpha1.ListEdgeSlmsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.ListEdgeSlmsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEdgeSlmsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single EdgeSlm.
     * </pre>
     */
    public void getEdgeSlm(
        com.google.cloud.telcoautomation.v1alpha1.GetEdgeSlmRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.EdgeSlm>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEdgeSlmMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new EdgeSlm in a given project and location.
     * </pre>
     */
    public void createEdgeSlm(
        com.google.cloud.telcoautomation.v1alpha1.CreateEdgeSlmRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEdgeSlmMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single EdgeSlm.
     * </pre>
     */
    public void deleteEdgeSlm(
        com.google.cloud.telcoautomation.v1alpha1.DeleteEdgeSlmRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEdgeSlmMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a blueprint.
     * </pre>
     */
    public void createBlueprint(
        com.google.cloud.telcoautomation.v1alpha1.CreateBlueprintRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.Blueprint>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBlueprintMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a blueprint.
     * </pre>
     */
    public void updateBlueprint(
        com.google.cloud.telcoautomation.v1alpha1.UpdateBlueprintRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.Blueprint>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateBlueprintMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested blueprint.
     * </pre>
     */
    public void getBlueprint(
        com.google.cloud.telcoautomation.v1alpha1.GetBlueprintRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.Blueprint>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBlueprintMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a blueprint and all its revisions.
     * </pre>
     */
    public void deleteBlueprint(
        com.google.cloud.telcoautomation.v1alpha1.DeleteBlueprintRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteBlueprintMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all blueprints.
     * </pre>
     */
    public void listBlueprints(
        com.google.cloud.telcoautomation.v1alpha1.ListBlueprintsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.telcoautomation.v1alpha1.ListBlueprintsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBlueprintsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Approves a blueprint and commits a new revision.
     * </pre>
     */
    public void approveBlueprint(
        com.google.cloud.telcoautomation.v1alpha1.ApproveBlueprintRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.Blueprint>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getApproveBlueprintMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Proposes a blueprint for approval of changes.
     * </pre>
     */
    public void proposeBlueprint(
        com.google.cloud.telcoautomation.v1alpha1.ProposeBlueprintRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.Blueprint>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getProposeBlueprintMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Rejects a blueprint revision proposal and flips it back to Draft state.
     * </pre>
     */
    public void rejectBlueprint(
        com.google.cloud.telcoautomation.v1alpha1.RejectBlueprintRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.Blueprint>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRejectBlueprintMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List blueprint revisions of a given blueprint.
     * </pre>
     */
    public void listBlueprintRevisions(
        com.google.cloud.telcoautomation.v1alpha1.ListBlueprintRevisionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.telcoautomation.v1alpha1.ListBlueprintRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBlueprintRevisionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches across blueprint revisions.
     * </pre>
     */
    public void searchBlueprintRevisions(
        com.google.cloud.telcoautomation.v1alpha1.SearchBlueprintRevisionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.telcoautomation.v1alpha1.SearchBlueprintRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchBlueprintRevisionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches across deployment revisions.
     * </pre>
     */
    public void searchDeploymentRevisions(
        com.google.cloud.telcoautomation.v1alpha1.SearchDeploymentRevisionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.telcoautomation.v1alpha1.SearchDeploymentRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchDeploymentRevisionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Discards the changes in a blueprint and reverts the blueprint to the last
     * approved blueprint revision. No changes take place if a blueprint does not
     * have revisions.
     * </pre>
     */
    public void discardBlueprintChanges(
        com.google.cloud.telcoautomation.v1alpha1.DiscardBlueprintChangesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.telcoautomation.v1alpha1.DiscardBlueprintChangesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDiscardBlueprintChangesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the blueprints in TNA's public catalog. Default page size = 20,
     * Max Page Size = 100.
     * </pre>
     */
    public void listPublicBlueprints(
        com.google.cloud.telcoautomation.v1alpha1.ListPublicBlueprintsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.telcoautomation.v1alpha1.ListPublicBlueprintsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPublicBlueprintsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested public blueprint.
     * </pre>
     */
    public void getPublicBlueprint(
        com.google.cloud.telcoautomation.v1alpha1.GetPublicBlueprintRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.PublicBlueprint>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPublicBlueprintMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a deployment.
     * </pre>
     */
    public void createDeployment(
        com.google.cloud.telcoautomation.v1alpha1.CreateDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.Deployment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a deployment.
     * </pre>
     */
    public void updateDeployment(
        com.google.cloud.telcoautomation.v1alpha1.UpdateDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.Deployment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested deployment.
     * </pre>
     */
    public void getDeployment(
        com.google.cloud.telcoautomation.v1alpha1.GetDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.Deployment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes the deployment by marking it as DELETING. Post which deployment and
     * it's revisions gets deleted.
     * </pre>
     */
    public void removeDeployment(
        com.google.cloud.telcoautomation.v1alpha1.RemoveDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all deployments.
     * </pre>
     */
    public void listDeployments(
        com.google.cloud.telcoautomation.v1alpha1.ListDeploymentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.telcoautomation.v1alpha1.ListDeploymentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDeploymentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List deployment revisions of a given deployment.
     * </pre>
     */
    public void listDeploymentRevisions(
        com.google.cloud.telcoautomation.v1alpha1.ListDeploymentRevisionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.telcoautomation.v1alpha1.ListDeploymentRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDeploymentRevisionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Discards the changes in a deployment and reverts the deployment to the last
     * approved deployment revision. No changes take place if a deployment does
     * not have revisions.
     * </pre>
     */
    public void discardDeploymentChanges(
        com.google.cloud.telcoautomation.v1alpha1.DiscardDeploymentChangesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.telcoautomation.v1alpha1.DiscardDeploymentChangesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDiscardDeploymentChangesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Applies the deployment's YAML files to the parent orchestration cluster.
     * </pre>
     */
    public void applyDeployment(
        com.google.cloud.telcoautomation.v1alpha1.ApplyDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.Deployment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getApplyDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested deployment status.
     * </pre>
     */
    public void computeDeploymentStatus(
        com.google.cloud.telcoautomation.v1alpha1.ComputeDeploymentStatusRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.telcoautomation.v1alpha1.ComputeDeploymentStatusResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getComputeDeploymentStatusMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Rollback the active deployment to the given past approved deployment
     * revision.
     * </pre>
     */
    public void rollbackDeployment(
        com.google.cloud.telcoautomation.v1alpha1.RollbackDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.Deployment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRollbackDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested hydrated deployment.
     * </pre>
     */
    public void getHydratedDeployment(
        com.google.cloud.telcoautomation.v1alpha1.GetHydratedDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetHydratedDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all hydrated deployments present under a deployment.
     * </pre>
     */
    public void listHydratedDeployments(
        com.google.cloud.telcoautomation.v1alpha1.ListHydratedDeploymentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.telcoautomation.v1alpha1.ListHydratedDeploymentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListHydratedDeploymentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a hydrated deployment.
     * </pre>
     */
    public void updateHydratedDeployment(
        com.google.cloud.telcoautomation.v1alpha1.UpdateHydratedDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateHydratedDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Applies a hydrated deployment to a workload cluster.
     * </pre>
     */
    public void applyHydratedDeployment(
        com.google.cloud.telcoautomation.v1alpha1.ApplyHydratedDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getApplyHydratedDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service TelcoAutomation.
   *
   * <pre>
   * TelcoAutomation Service manages the control plane cluster a.k.a.
   * Orchestration Cluster (GKE cluster with config controller) of TNA. It also
   * exposes blueprint APIs which manages the lifecycle of blueprints that control
   * the infrastructure setup (e.g GDCE clusters) and deployment of network
   * functions.
   * </pre>
   */
  public static final class TelcoAutomationBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TelcoAutomationBlockingStub> {
    private TelcoAutomationBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TelcoAutomationBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TelcoAutomationBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists OrchestrationClusters in a given project and location.
     * </pre>
     */
    public com.google.cloud.telcoautomation.v1alpha1.ListOrchestrationClustersResponse
        listOrchestrationClusters(
            com.google.cloud.telcoautomation.v1alpha1.ListOrchestrationClustersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListOrchestrationClustersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single OrchestrationCluster.
     * </pre>
     */
    public com.google.cloud.telcoautomation.v1alpha1.OrchestrationCluster getOrchestrationCluster(
        com.google.cloud.telcoautomation.v1alpha1.GetOrchestrationClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOrchestrationClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new OrchestrationCluster in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createOrchestrationCluster(
        com.google.cloud.telcoautomation.v1alpha1.CreateOrchestrationClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateOrchestrationClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single OrchestrationCluster.
     * </pre>
     */
    public com.google.longrunning.Operation deleteOrchestrationCluster(
        com.google.cloud.telcoautomation.v1alpha1.DeleteOrchestrationClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteOrchestrationClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists EdgeSlms in a given project and location.
     * </pre>
     */
    public com.google.cloud.telcoautomation.v1alpha1.ListEdgeSlmsResponse listEdgeSlms(
        com.google.cloud.telcoautomation.v1alpha1.ListEdgeSlmsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEdgeSlmsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single EdgeSlm.
     * </pre>
     */
    public com.google.cloud.telcoautomation.v1alpha1.EdgeSlm getEdgeSlm(
        com.google.cloud.telcoautomation.v1alpha1.GetEdgeSlmRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEdgeSlmMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new EdgeSlm in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createEdgeSlm(
        com.google.cloud.telcoautomation.v1alpha1.CreateEdgeSlmRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEdgeSlmMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single EdgeSlm.
     * </pre>
     */
    public com.google.longrunning.Operation deleteEdgeSlm(
        com.google.cloud.telcoautomation.v1alpha1.DeleteEdgeSlmRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEdgeSlmMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a blueprint.
     * </pre>
     */
    public com.google.cloud.telcoautomation.v1alpha1.Blueprint createBlueprint(
        com.google.cloud.telcoautomation.v1alpha1.CreateBlueprintRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBlueprintMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a blueprint.
     * </pre>
     */
    public com.google.cloud.telcoautomation.v1alpha1.Blueprint updateBlueprint(
        com.google.cloud.telcoautomation.v1alpha1.UpdateBlueprintRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBlueprintMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested blueprint.
     * </pre>
     */
    public com.google.cloud.telcoautomation.v1alpha1.Blueprint getBlueprint(
        com.google.cloud.telcoautomation.v1alpha1.GetBlueprintRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBlueprintMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a blueprint and all its revisions.
     * </pre>
     */
    public com.google.protobuf.Empty deleteBlueprint(
        com.google.cloud.telcoautomation.v1alpha1.DeleteBlueprintRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBlueprintMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all blueprints.
     * </pre>
     */
    public com.google.cloud.telcoautomation.v1alpha1.ListBlueprintsResponse listBlueprints(
        com.google.cloud.telcoautomation.v1alpha1.ListBlueprintsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBlueprintsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Approves a blueprint and commits a new revision.
     * </pre>
     */
    public com.google.cloud.telcoautomation.v1alpha1.Blueprint approveBlueprint(
        com.google.cloud.telcoautomation.v1alpha1.ApproveBlueprintRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getApproveBlueprintMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Proposes a blueprint for approval of changes.
     * </pre>
     */
    public com.google.cloud.telcoautomation.v1alpha1.Blueprint proposeBlueprint(
        com.google.cloud.telcoautomation.v1alpha1.ProposeBlueprintRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getProposeBlueprintMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Rejects a blueprint revision proposal and flips it back to Draft state.
     * </pre>
     */
    public com.google.cloud.telcoautomation.v1alpha1.Blueprint rejectBlueprint(
        com.google.cloud.telcoautomation.v1alpha1.RejectBlueprintRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRejectBlueprintMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List blueprint revisions of a given blueprint.
     * </pre>
     */
    public com.google.cloud.telcoautomation.v1alpha1.ListBlueprintRevisionsResponse
        listBlueprintRevisions(
            com.google.cloud.telcoautomation.v1alpha1.ListBlueprintRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBlueprintRevisionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Searches across blueprint revisions.
     * </pre>
     */
    public com.google.cloud.telcoautomation.v1alpha1.SearchBlueprintRevisionsResponse
        searchBlueprintRevisions(
            com.google.cloud.telcoautomation.v1alpha1.SearchBlueprintRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchBlueprintRevisionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Searches across deployment revisions.
     * </pre>
     */
    public com.google.cloud.telcoautomation.v1alpha1.SearchDeploymentRevisionsResponse
        searchDeploymentRevisions(
            com.google.cloud.telcoautomation.v1alpha1.SearchDeploymentRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchDeploymentRevisionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Discards the changes in a blueprint and reverts the blueprint to the last
     * approved blueprint revision. No changes take place if a blueprint does not
     * have revisions.
     * </pre>
     */
    public com.google.cloud.telcoautomation.v1alpha1.DiscardBlueprintChangesResponse
        discardBlueprintChanges(
            com.google.cloud.telcoautomation.v1alpha1.DiscardBlueprintChangesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDiscardBlueprintChangesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the blueprints in TNA's public catalog. Default page size = 20,
     * Max Page Size = 100.
     * </pre>
     */
    public com.google.cloud.telcoautomation.v1alpha1.ListPublicBlueprintsResponse
        listPublicBlueprints(
            com.google.cloud.telcoautomation.v1alpha1.ListPublicBlueprintsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPublicBlueprintsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested public blueprint.
     * </pre>
     */
    public com.google.cloud.telcoautomation.v1alpha1.PublicBlueprint getPublicBlueprint(
        com.google.cloud.telcoautomation.v1alpha1.GetPublicBlueprintRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPublicBlueprintMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a deployment.
     * </pre>
     */
    public com.google.cloud.telcoautomation.v1alpha1.Deployment createDeployment(
        com.google.cloud.telcoautomation.v1alpha1.CreateDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a deployment.
     * </pre>
     */
    public com.google.cloud.telcoautomation.v1alpha1.Deployment updateDeployment(
        com.google.cloud.telcoautomation.v1alpha1.UpdateDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested deployment.
     * </pre>
     */
    public com.google.cloud.telcoautomation.v1alpha1.Deployment getDeployment(
        com.google.cloud.telcoautomation.v1alpha1.GetDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Removes the deployment by marking it as DELETING. Post which deployment and
     * it's revisions gets deleted.
     * </pre>
     */
    public com.google.protobuf.Empty removeDeployment(
        com.google.cloud.telcoautomation.v1alpha1.RemoveDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all deployments.
     * </pre>
     */
    public com.google.cloud.telcoautomation.v1alpha1.ListDeploymentsResponse listDeployments(
        com.google.cloud.telcoautomation.v1alpha1.ListDeploymentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDeploymentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List deployment revisions of a given deployment.
     * </pre>
     */
    public com.google.cloud.telcoautomation.v1alpha1.ListDeploymentRevisionsResponse
        listDeploymentRevisions(
            com.google.cloud.telcoautomation.v1alpha1.ListDeploymentRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDeploymentRevisionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Discards the changes in a deployment and reverts the deployment to the last
     * approved deployment revision. No changes take place if a deployment does
     * not have revisions.
     * </pre>
     */
    public com.google.cloud.telcoautomation.v1alpha1.DiscardDeploymentChangesResponse
        discardDeploymentChanges(
            com.google.cloud.telcoautomation.v1alpha1.DiscardDeploymentChangesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDiscardDeploymentChangesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Applies the deployment's YAML files to the parent orchestration cluster.
     * </pre>
     */
    public com.google.cloud.telcoautomation.v1alpha1.Deployment applyDeployment(
        com.google.cloud.telcoautomation.v1alpha1.ApplyDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getApplyDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested deployment status.
     * </pre>
     */
    public com.google.cloud.telcoautomation.v1alpha1.ComputeDeploymentStatusResponse
        computeDeploymentStatus(
            com.google.cloud.telcoautomation.v1alpha1.ComputeDeploymentStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getComputeDeploymentStatusMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Rollback the active deployment to the given past approved deployment
     * revision.
     * </pre>
     */
    public com.google.cloud.telcoautomation.v1alpha1.Deployment rollbackDeployment(
        com.google.cloud.telcoautomation.v1alpha1.RollbackDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRollbackDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested hydrated deployment.
     * </pre>
     */
    public com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment getHydratedDeployment(
        com.google.cloud.telcoautomation.v1alpha1.GetHydratedDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetHydratedDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all hydrated deployments present under a deployment.
     * </pre>
     */
    public com.google.cloud.telcoautomation.v1alpha1.ListHydratedDeploymentsResponse
        listHydratedDeployments(
            com.google.cloud.telcoautomation.v1alpha1.ListHydratedDeploymentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListHydratedDeploymentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a hydrated deployment.
     * </pre>
     */
    public com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment updateHydratedDeployment(
        com.google.cloud.telcoautomation.v1alpha1.UpdateHydratedDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateHydratedDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Applies a hydrated deployment to a workload cluster.
     * </pre>
     */
    public com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment applyHydratedDeployment(
        com.google.cloud.telcoautomation.v1alpha1.ApplyHydratedDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getApplyHydratedDeploymentMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service TelcoAutomation.
   *
   * <pre>
   * TelcoAutomation Service manages the control plane cluster a.k.a.
   * Orchestration Cluster (GKE cluster with config controller) of TNA. It also
   * exposes blueprint APIs which manages the lifecycle of blueprints that control
   * the infrastructure setup (e.g GDCE clusters) and deployment of network
   * functions.
   * </pre>
   */
  public static final class TelcoAutomationFutureStub
      extends io.grpc.stub.AbstractFutureStub<TelcoAutomationFutureStub> {
    private TelcoAutomationFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TelcoAutomationFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TelcoAutomationFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists OrchestrationClusters in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.telcoautomation.v1alpha1.ListOrchestrationClustersResponse>
        listOrchestrationClusters(
            com.google.cloud.telcoautomation.v1alpha1.ListOrchestrationClustersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListOrchestrationClustersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single OrchestrationCluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.telcoautomation.v1alpha1.OrchestrationCluster>
        getOrchestrationCluster(
            com.google.cloud.telcoautomation.v1alpha1.GetOrchestrationClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOrchestrationClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new OrchestrationCluster in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createOrchestrationCluster(
            com.google.cloud.telcoautomation.v1alpha1.CreateOrchestrationClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateOrchestrationClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single OrchestrationCluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteOrchestrationCluster(
            com.google.cloud.telcoautomation.v1alpha1.DeleteOrchestrationClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteOrchestrationClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists EdgeSlms in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.telcoautomation.v1alpha1.ListEdgeSlmsResponse>
        listEdgeSlms(com.google.cloud.telcoautomation.v1alpha1.ListEdgeSlmsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEdgeSlmsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single EdgeSlm.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.telcoautomation.v1alpha1.EdgeSlm>
        getEdgeSlm(com.google.cloud.telcoautomation.v1alpha1.GetEdgeSlmRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEdgeSlmMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new EdgeSlm in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createEdgeSlm(com.google.cloud.telcoautomation.v1alpha1.CreateEdgeSlmRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEdgeSlmMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single EdgeSlm.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteEdgeSlm(com.google.cloud.telcoautomation.v1alpha1.DeleteEdgeSlmRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEdgeSlmMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a blueprint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.telcoautomation.v1alpha1.Blueprint>
        createBlueprint(com.google.cloud.telcoautomation.v1alpha1.CreateBlueprintRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBlueprintMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a blueprint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.telcoautomation.v1alpha1.Blueprint>
        updateBlueprint(com.google.cloud.telcoautomation.v1alpha1.UpdateBlueprintRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBlueprintMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested blueprint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.telcoautomation.v1alpha1.Blueprint>
        getBlueprint(com.google.cloud.telcoautomation.v1alpha1.GetBlueprintRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBlueprintMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a blueprint and all its revisions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteBlueprint(com.google.cloud.telcoautomation.v1alpha1.DeleteBlueprintRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBlueprintMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List all blueprints.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.telcoautomation.v1alpha1.ListBlueprintsResponse>
        listBlueprints(com.google.cloud.telcoautomation.v1alpha1.ListBlueprintsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBlueprintsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Approves a blueprint and commits a new revision.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.telcoautomation.v1alpha1.Blueprint>
        approveBlueprint(
            com.google.cloud.telcoautomation.v1alpha1.ApproveBlueprintRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getApproveBlueprintMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Proposes a blueprint for approval of changes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.telcoautomation.v1alpha1.Blueprint>
        proposeBlueprint(
            com.google.cloud.telcoautomation.v1alpha1.ProposeBlueprintRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getProposeBlueprintMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Rejects a blueprint revision proposal and flips it back to Draft state.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.telcoautomation.v1alpha1.Blueprint>
        rejectBlueprint(com.google.cloud.telcoautomation.v1alpha1.RejectBlueprintRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRejectBlueprintMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List blueprint revisions of a given blueprint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.telcoautomation.v1alpha1.ListBlueprintRevisionsResponse>
        listBlueprintRevisions(
            com.google.cloud.telcoautomation.v1alpha1.ListBlueprintRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBlueprintRevisionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Searches across blueprint revisions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.telcoautomation.v1alpha1.SearchBlueprintRevisionsResponse>
        searchBlueprintRevisions(
            com.google.cloud.telcoautomation.v1alpha1.SearchBlueprintRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchBlueprintRevisionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Searches across deployment revisions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.telcoautomation.v1alpha1.SearchDeploymentRevisionsResponse>
        searchDeploymentRevisions(
            com.google.cloud.telcoautomation.v1alpha1.SearchDeploymentRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchDeploymentRevisionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Discards the changes in a blueprint and reverts the blueprint to the last
     * approved blueprint revision. No changes take place if a blueprint does not
     * have revisions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.telcoautomation.v1alpha1.DiscardBlueprintChangesResponse>
        discardBlueprintChanges(
            com.google.cloud.telcoautomation.v1alpha1.DiscardBlueprintChangesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDiscardBlueprintChangesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the blueprints in TNA's public catalog. Default page size = 20,
     * Max Page Size = 100.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.telcoautomation.v1alpha1.ListPublicBlueprintsResponse>
        listPublicBlueprints(
            com.google.cloud.telcoautomation.v1alpha1.ListPublicBlueprintsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPublicBlueprintsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested public blueprint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.telcoautomation.v1alpha1.PublicBlueprint>
        getPublicBlueprint(
            com.google.cloud.telcoautomation.v1alpha1.GetPublicBlueprintRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPublicBlueprintMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a deployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.telcoautomation.v1alpha1.Deployment>
        createDeployment(
            com.google.cloud.telcoautomation.v1alpha1.CreateDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDeploymentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a deployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.telcoautomation.v1alpha1.Deployment>
        updateDeployment(
            com.google.cloud.telcoautomation.v1alpha1.UpdateDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDeploymentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested deployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.telcoautomation.v1alpha1.Deployment>
        getDeployment(com.google.cloud.telcoautomation.v1alpha1.GetDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDeploymentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Removes the deployment by marking it as DELETING. Post which deployment and
     * it's revisions gets deleted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        removeDeployment(
            com.google.cloud.telcoautomation.v1alpha1.RemoveDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveDeploymentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List all deployments.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.telcoautomation.v1alpha1.ListDeploymentsResponse>
        listDeployments(com.google.cloud.telcoautomation.v1alpha1.ListDeploymentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDeploymentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List deployment revisions of a given deployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.telcoautomation.v1alpha1.ListDeploymentRevisionsResponse>
        listDeploymentRevisions(
            com.google.cloud.telcoautomation.v1alpha1.ListDeploymentRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDeploymentRevisionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Discards the changes in a deployment and reverts the deployment to the last
     * approved deployment revision. No changes take place if a deployment does
     * not have revisions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.telcoautomation.v1alpha1.DiscardDeploymentChangesResponse>
        discardDeploymentChanges(
            com.google.cloud.telcoautomation.v1alpha1.DiscardDeploymentChangesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDiscardDeploymentChangesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Applies the deployment's YAML files to the parent orchestration cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.telcoautomation.v1alpha1.Deployment>
        applyDeployment(com.google.cloud.telcoautomation.v1alpha1.ApplyDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getApplyDeploymentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested deployment status.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.telcoautomation.v1alpha1.ComputeDeploymentStatusResponse>
        computeDeploymentStatus(
            com.google.cloud.telcoautomation.v1alpha1.ComputeDeploymentStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getComputeDeploymentStatusMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Rollback the active deployment to the given past approved deployment
     * revision.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.telcoautomation.v1alpha1.Deployment>
        rollbackDeployment(
            com.google.cloud.telcoautomation.v1alpha1.RollbackDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRollbackDeploymentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested hydrated deployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment>
        getHydratedDeployment(
            com.google.cloud.telcoautomation.v1alpha1.GetHydratedDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetHydratedDeploymentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List all hydrated deployments present under a deployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.telcoautomation.v1alpha1.ListHydratedDeploymentsResponse>
        listHydratedDeployments(
            com.google.cloud.telcoautomation.v1alpha1.ListHydratedDeploymentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListHydratedDeploymentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a hydrated deployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment>
        updateHydratedDeployment(
            com.google.cloud.telcoautomation.v1alpha1.UpdateHydratedDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateHydratedDeploymentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Applies a hydrated deployment to a workload cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment>
        applyHydratedDeployment(
            com.google.cloud.telcoautomation.v1alpha1.ApplyHydratedDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getApplyHydratedDeploymentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_ORCHESTRATION_CLUSTERS = 0;
  private static final int METHODID_GET_ORCHESTRATION_CLUSTER = 1;
  private static final int METHODID_CREATE_ORCHESTRATION_CLUSTER = 2;
  private static final int METHODID_DELETE_ORCHESTRATION_CLUSTER = 3;
  private static final int METHODID_LIST_EDGE_SLMS = 4;
  private static final int METHODID_GET_EDGE_SLM = 5;
  private static final int METHODID_CREATE_EDGE_SLM = 6;
  private static final int METHODID_DELETE_EDGE_SLM = 7;
  private static final int METHODID_CREATE_BLUEPRINT = 8;
  private static final int METHODID_UPDATE_BLUEPRINT = 9;
  private static final int METHODID_GET_BLUEPRINT = 10;
  private static final int METHODID_DELETE_BLUEPRINT = 11;
  private static final int METHODID_LIST_BLUEPRINTS = 12;
  private static final int METHODID_APPROVE_BLUEPRINT = 13;
  private static final int METHODID_PROPOSE_BLUEPRINT = 14;
  private static final int METHODID_REJECT_BLUEPRINT = 15;
  private static final int METHODID_LIST_BLUEPRINT_REVISIONS = 16;
  private static final int METHODID_SEARCH_BLUEPRINT_REVISIONS = 17;
  private static final int METHODID_SEARCH_DEPLOYMENT_REVISIONS = 18;
  private static final int METHODID_DISCARD_BLUEPRINT_CHANGES = 19;
  private static final int METHODID_LIST_PUBLIC_BLUEPRINTS = 20;
  private static final int METHODID_GET_PUBLIC_BLUEPRINT = 21;
  private static final int METHODID_CREATE_DEPLOYMENT = 22;
  private static final int METHODID_UPDATE_DEPLOYMENT = 23;
  private static final int METHODID_GET_DEPLOYMENT = 24;
  private static final int METHODID_REMOVE_DEPLOYMENT = 25;
  private static final int METHODID_LIST_DEPLOYMENTS = 26;
  private static final int METHODID_LIST_DEPLOYMENT_REVISIONS = 27;
  private static final int METHODID_DISCARD_DEPLOYMENT_CHANGES = 28;
  private static final int METHODID_APPLY_DEPLOYMENT = 29;
  private static final int METHODID_COMPUTE_DEPLOYMENT_STATUS = 30;
  private static final int METHODID_ROLLBACK_DEPLOYMENT = 31;
  private static final int METHODID_GET_HYDRATED_DEPLOYMENT = 32;
  private static final int METHODID_LIST_HYDRATED_DEPLOYMENTS = 33;
  private static final int METHODID_UPDATE_HYDRATED_DEPLOYMENT = 34;
  private static final int METHODID_APPLY_HYDRATED_DEPLOYMENT = 35;

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
        case METHODID_LIST_ORCHESTRATION_CLUSTERS:
          serviceImpl.listOrchestrationClusters(
              (com.google.cloud.telcoautomation.v1alpha1.ListOrchestrationClustersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.telcoautomation.v1alpha1.ListOrchestrationClustersResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ORCHESTRATION_CLUSTER:
          serviceImpl.getOrchestrationCluster(
              (com.google.cloud.telcoautomation.v1alpha1.GetOrchestrationClusterRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.telcoautomation.v1alpha1.OrchestrationCluster>)
                  responseObserver);
          break;
        case METHODID_CREATE_ORCHESTRATION_CLUSTER:
          serviceImpl.createOrchestrationCluster(
              (com.google.cloud.telcoautomation.v1alpha1.CreateOrchestrationClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ORCHESTRATION_CLUSTER:
          serviceImpl.deleteOrchestrationCluster(
              (com.google.cloud.telcoautomation.v1alpha1.DeleteOrchestrationClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_EDGE_SLMS:
          serviceImpl.listEdgeSlms(
              (com.google.cloud.telcoautomation.v1alpha1.ListEdgeSlmsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.telcoautomation.v1alpha1.ListEdgeSlmsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_EDGE_SLM:
          serviceImpl.getEdgeSlm(
              (com.google.cloud.telcoautomation.v1alpha1.GetEdgeSlmRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.EdgeSlm>)
                  responseObserver);
          break;
        case METHODID_CREATE_EDGE_SLM:
          serviceImpl.createEdgeSlm(
              (com.google.cloud.telcoautomation.v1alpha1.CreateEdgeSlmRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_EDGE_SLM:
          serviceImpl.deleteEdgeSlm(
              (com.google.cloud.telcoautomation.v1alpha1.DeleteEdgeSlmRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_BLUEPRINT:
          serviceImpl.createBlueprint(
              (com.google.cloud.telcoautomation.v1alpha1.CreateBlueprintRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.Blueprint>)
                  responseObserver);
          break;
        case METHODID_UPDATE_BLUEPRINT:
          serviceImpl.updateBlueprint(
              (com.google.cloud.telcoautomation.v1alpha1.UpdateBlueprintRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.Blueprint>)
                  responseObserver);
          break;
        case METHODID_GET_BLUEPRINT:
          serviceImpl.getBlueprint(
              (com.google.cloud.telcoautomation.v1alpha1.GetBlueprintRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.Blueprint>)
                  responseObserver);
          break;
        case METHODID_DELETE_BLUEPRINT:
          serviceImpl.deleteBlueprint(
              (com.google.cloud.telcoautomation.v1alpha1.DeleteBlueprintRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_BLUEPRINTS:
          serviceImpl.listBlueprints(
              (com.google.cloud.telcoautomation.v1alpha1.ListBlueprintsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.telcoautomation.v1alpha1.ListBlueprintsResponse>)
                  responseObserver);
          break;
        case METHODID_APPROVE_BLUEPRINT:
          serviceImpl.approveBlueprint(
              (com.google.cloud.telcoautomation.v1alpha1.ApproveBlueprintRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.Blueprint>)
                  responseObserver);
          break;
        case METHODID_PROPOSE_BLUEPRINT:
          serviceImpl.proposeBlueprint(
              (com.google.cloud.telcoautomation.v1alpha1.ProposeBlueprintRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.Blueprint>)
                  responseObserver);
          break;
        case METHODID_REJECT_BLUEPRINT:
          serviceImpl.rejectBlueprint(
              (com.google.cloud.telcoautomation.v1alpha1.RejectBlueprintRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.Blueprint>)
                  responseObserver);
          break;
        case METHODID_LIST_BLUEPRINT_REVISIONS:
          serviceImpl.listBlueprintRevisions(
              (com.google.cloud.telcoautomation.v1alpha1.ListBlueprintRevisionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.telcoautomation.v1alpha1.ListBlueprintRevisionsResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_BLUEPRINT_REVISIONS:
          serviceImpl.searchBlueprintRevisions(
              (com.google.cloud.telcoautomation.v1alpha1.SearchBlueprintRevisionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.telcoautomation.v1alpha1.SearchBlueprintRevisionsResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_DEPLOYMENT_REVISIONS:
          serviceImpl.searchDeploymentRevisions(
              (com.google.cloud.telcoautomation.v1alpha1.SearchDeploymentRevisionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.telcoautomation.v1alpha1.SearchDeploymentRevisionsResponse>)
                  responseObserver);
          break;
        case METHODID_DISCARD_BLUEPRINT_CHANGES:
          serviceImpl.discardBlueprintChanges(
              (com.google.cloud.telcoautomation.v1alpha1.DiscardBlueprintChangesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.telcoautomation.v1alpha1.DiscardBlueprintChangesResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_PUBLIC_BLUEPRINTS:
          serviceImpl.listPublicBlueprints(
              (com.google.cloud.telcoautomation.v1alpha1.ListPublicBlueprintsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.telcoautomation.v1alpha1.ListPublicBlueprintsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PUBLIC_BLUEPRINT:
          serviceImpl.getPublicBlueprint(
              (com.google.cloud.telcoautomation.v1alpha1.GetPublicBlueprintRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.telcoautomation.v1alpha1.PublicBlueprint>)
                  responseObserver);
          break;
        case METHODID_CREATE_DEPLOYMENT:
          serviceImpl.createDeployment(
              (com.google.cloud.telcoautomation.v1alpha1.CreateDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.Deployment>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DEPLOYMENT:
          serviceImpl.updateDeployment(
              (com.google.cloud.telcoautomation.v1alpha1.UpdateDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.Deployment>)
                  responseObserver);
          break;
        case METHODID_GET_DEPLOYMENT:
          serviceImpl.getDeployment(
              (com.google.cloud.telcoautomation.v1alpha1.GetDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.Deployment>)
                  responseObserver);
          break;
        case METHODID_REMOVE_DEPLOYMENT:
          serviceImpl.removeDeployment(
              (com.google.cloud.telcoautomation.v1alpha1.RemoveDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_DEPLOYMENTS:
          serviceImpl.listDeployments(
              (com.google.cloud.telcoautomation.v1alpha1.ListDeploymentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.telcoautomation.v1alpha1.ListDeploymentsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_DEPLOYMENT_REVISIONS:
          serviceImpl.listDeploymentRevisions(
              (com.google.cloud.telcoautomation.v1alpha1.ListDeploymentRevisionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.telcoautomation.v1alpha1.ListDeploymentRevisionsResponse>)
                  responseObserver);
          break;
        case METHODID_DISCARD_DEPLOYMENT_CHANGES:
          serviceImpl.discardDeploymentChanges(
              (com.google.cloud.telcoautomation.v1alpha1.DiscardDeploymentChangesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.telcoautomation.v1alpha1.DiscardDeploymentChangesResponse>)
                  responseObserver);
          break;
        case METHODID_APPLY_DEPLOYMENT:
          serviceImpl.applyDeployment(
              (com.google.cloud.telcoautomation.v1alpha1.ApplyDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.Deployment>)
                  responseObserver);
          break;
        case METHODID_COMPUTE_DEPLOYMENT_STATUS:
          serviceImpl.computeDeploymentStatus(
              (com.google.cloud.telcoautomation.v1alpha1.ComputeDeploymentStatusRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.telcoautomation.v1alpha1.ComputeDeploymentStatusResponse>)
                  responseObserver);
          break;
        case METHODID_ROLLBACK_DEPLOYMENT:
          serviceImpl.rollbackDeployment(
              (com.google.cloud.telcoautomation.v1alpha1.RollbackDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.telcoautomation.v1alpha1.Deployment>)
                  responseObserver);
          break;
        case METHODID_GET_HYDRATED_DEPLOYMENT:
          serviceImpl.getHydratedDeployment(
              (com.google.cloud.telcoautomation.v1alpha1.GetHydratedDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment>)
                  responseObserver);
          break;
        case METHODID_LIST_HYDRATED_DEPLOYMENTS:
          serviceImpl.listHydratedDeployments(
              (com.google.cloud.telcoautomation.v1alpha1.ListHydratedDeploymentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.telcoautomation.v1alpha1.ListHydratedDeploymentsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_HYDRATED_DEPLOYMENT:
          serviceImpl.updateHydratedDeployment(
              (com.google.cloud.telcoautomation.v1alpha1.UpdateHydratedDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment>)
                  responseObserver);
          break;
        case METHODID_APPLY_HYDRATED_DEPLOYMENT:
          serviceImpl.applyHydratedDeployment(
              (com.google.cloud.telcoautomation.v1alpha1.ApplyHydratedDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment>)
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
            getListOrchestrationClustersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.ListOrchestrationClustersRequest,
                    com.google.cloud.telcoautomation.v1alpha1.ListOrchestrationClustersResponse>(
                    service, METHODID_LIST_ORCHESTRATION_CLUSTERS)))
        .addMethod(
            getGetOrchestrationClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.GetOrchestrationClusterRequest,
                    com.google.cloud.telcoautomation.v1alpha1.OrchestrationCluster>(
                    service, METHODID_GET_ORCHESTRATION_CLUSTER)))
        .addMethod(
            getCreateOrchestrationClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.CreateOrchestrationClusterRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_ORCHESTRATION_CLUSTER)))
        .addMethod(
            getDeleteOrchestrationClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.DeleteOrchestrationClusterRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_ORCHESTRATION_CLUSTER)))
        .addMethod(
            getListEdgeSlmsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.ListEdgeSlmsRequest,
                    com.google.cloud.telcoautomation.v1alpha1.ListEdgeSlmsResponse>(
                    service, METHODID_LIST_EDGE_SLMS)))
        .addMethod(
            getGetEdgeSlmMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.GetEdgeSlmRequest,
                    com.google.cloud.telcoautomation.v1alpha1.EdgeSlm>(
                    service, METHODID_GET_EDGE_SLM)))
        .addMethod(
            getCreateEdgeSlmMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.CreateEdgeSlmRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_EDGE_SLM)))
        .addMethod(
            getDeleteEdgeSlmMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.DeleteEdgeSlmRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_EDGE_SLM)))
        .addMethod(
            getCreateBlueprintMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.CreateBlueprintRequest,
                    com.google.cloud.telcoautomation.v1alpha1.Blueprint>(
                    service, METHODID_CREATE_BLUEPRINT)))
        .addMethod(
            getUpdateBlueprintMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.UpdateBlueprintRequest,
                    com.google.cloud.telcoautomation.v1alpha1.Blueprint>(
                    service, METHODID_UPDATE_BLUEPRINT)))
        .addMethod(
            getGetBlueprintMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.GetBlueprintRequest,
                    com.google.cloud.telcoautomation.v1alpha1.Blueprint>(
                    service, METHODID_GET_BLUEPRINT)))
        .addMethod(
            getDeleteBlueprintMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.DeleteBlueprintRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_BLUEPRINT)))
        .addMethod(
            getListBlueprintsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.ListBlueprintsRequest,
                    com.google.cloud.telcoautomation.v1alpha1.ListBlueprintsResponse>(
                    service, METHODID_LIST_BLUEPRINTS)))
        .addMethod(
            getApproveBlueprintMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.ApproveBlueprintRequest,
                    com.google.cloud.telcoautomation.v1alpha1.Blueprint>(
                    service, METHODID_APPROVE_BLUEPRINT)))
        .addMethod(
            getProposeBlueprintMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.ProposeBlueprintRequest,
                    com.google.cloud.telcoautomation.v1alpha1.Blueprint>(
                    service, METHODID_PROPOSE_BLUEPRINT)))
        .addMethod(
            getRejectBlueprintMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.RejectBlueprintRequest,
                    com.google.cloud.telcoautomation.v1alpha1.Blueprint>(
                    service, METHODID_REJECT_BLUEPRINT)))
        .addMethod(
            getListBlueprintRevisionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.ListBlueprintRevisionsRequest,
                    com.google.cloud.telcoautomation.v1alpha1.ListBlueprintRevisionsResponse>(
                    service, METHODID_LIST_BLUEPRINT_REVISIONS)))
        .addMethod(
            getSearchBlueprintRevisionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.SearchBlueprintRevisionsRequest,
                    com.google.cloud.telcoautomation.v1alpha1.SearchBlueprintRevisionsResponse>(
                    service, METHODID_SEARCH_BLUEPRINT_REVISIONS)))
        .addMethod(
            getSearchDeploymentRevisionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.SearchDeploymentRevisionsRequest,
                    com.google.cloud.telcoautomation.v1alpha1.SearchDeploymentRevisionsResponse>(
                    service, METHODID_SEARCH_DEPLOYMENT_REVISIONS)))
        .addMethod(
            getDiscardBlueprintChangesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.DiscardBlueprintChangesRequest,
                    com.google.cloud.telcoautomation.v1alpha1.DiscardBlueprintChangesResponse>(
                    service, METHODID_DISCARD_BLUEPRINT_CHANGES)))
        .addMethod(
            getListPublicBlueprintsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.ListPublicBlueprintsRequest,
                    com.google.cloud.telcoautomation.v1alpha1.ListPublicBlueprintsResponse>(
                    service, METHODID_LIST_PUBLIC_BLUEPRINTS)))
        .addMethod(
            getGetPublicBlueprintMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.GetPublicBlueprintRequest,
                    com.google.cloud.telcoautomation.v1alpha1.PublicBlueprint>(
                    service, METHODID_GET_PUBLIC_BLUEPRINT)))
        .addMethod(
            getCreateDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.CreateDeploymentRequest,
                    com.google.cloud.telcoautomation.v1alpha1.Deployment>(
                    service, METHODID_CREATE_DEPLOYMENT)))
        .addMethod(
            getUpdateDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.UpdateDeploymentRequest,
                    com.google.cloud.telcoautomation.v1alpha1.Deployment>(
                    service, METHODID_UPDATE_DEPLOYMENT)))
        .addMethod(
            getGetDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.GetDeploymentRequest,
                    com.google.cloud.telcoautomation.v1alpha1.Deployment>(
                    service, METHODID_GET_DEPLOYMENT)))
        .addMethod(
            getRemoveDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.RemoveDeploymentRequest,
                    com.google.protobuf.Empty>(service, METHODID_REMOVE_DEPLOYMENT)))
        .addMethod(
            getListDeploymentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.ListDeploymentsRequest,
                    com.google.cloud.telcoautomation.v1alpha1.ListDeploymentsResponse>(
                    service, METHODID_LIST_DEPLOYMENTS)))
        .addMethod(
            getListDeploymentRevisionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.ListDeploymentRevisionsRequest,
                    com.google.cloud.telcoautomation.v1alpha1.ListDeploymentRevisionsResponse>(
                    service, METHODID_LIST_DEPLOYMENT_REVISIONS)))
        .addMethod(
            getDiscardDeploymentChangesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.DiscardDeploymentChangesRequest,
                    com.google.cloud.telcoautomation.v1alpha1.DiscardDeploymentChangesResponse>(
                    service, METHODID_DISCARD_DEPLOYMENT_CHANGES)))
        .addMethod(
            getApplyDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.ApplyDeploymentRequest,
                    com.google.cloud.telcoautomation.v1alpha1.Deployment>(
                    service, METHODID_APPLY_DEPLOYMENT)))
        .addMethod(
            getComputeDeploymentStatusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.ComputeDeploymentStatusRequest,
                    com.google.cloud.telcoautomation.v1alpha1.ComputeDeploymentStatusResponse>(
                    service, METHODID_COMPUTE_DEPLOYMENT_STATUS)))
        .addMethod(
            getRollbackDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.RollbackDeploymentRequest,
                    com.google.cloud.telcoautomation.v1alpha1.Deployment>(
                    service, METHODID_ROLLBACK_DEPLOYMENT)))
        .addMethod(
            getGetHydratedDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.GetHydratedDeploymentRequest,
                    com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment>(
                    service, METHODID_GET_HYDRATED_DEPLOYMENT)))
        .addMethod(
            getListHydratedDeploymentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.ListHydratedDeploymentsRequest,
                    com.google.cloud.telcoautomation.v1alpha1.ListHydratedDeploymentsResponse>(
                    service, METHODID_LIST_HYDRATED_DEPLOYMENTS)))
        .addMethod(
            getUpdateHydratedDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.UpdateHydratedDeploymentRequest,
                    com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment>(
                    service, METHODID_UPDATE_HYDRATED_DEPLOYMENT)))
        .addMethod(
            getApplyHydratedDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.telcoautomation.v1alpha1.ApplyHydratedDeploymentRequest,
                    com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment>(
                    service, METHODID_APPLY_HYDRATED_DEPLOYMENT)))
        .build();
  }

  private abstract static class TelcoAutomationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TelcoAutomationBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.telcoautomation.v1alpha1.TelcoautomationProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TelcoAutomation");
    }
  }

  private static final class TelcoAutomationFileDescriptorSupplier
      extends TelcoAutomationBaseDescriptorSupplier {
    TelcoAutomationFileDescriptorSupplier() {}
  }

  private static final class TelcoAutomationMethodDescriptorSupplier
      extends TelcoAutomationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    TelcoAutomationMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (TelcoAutomationGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new TelcoAutomationFileDescriptorSupplier())
                      .addMethod(getListOrchestrationClustersMethod())
                      .addMethod(getGetOrchestrationClusterMethod())
                      .addMethod(getCreateOrchestrationClusterMethod())
                      .addMethod(getDeleteOrchestrationClusterMethod())
                      .addMethod(getListEdgeSlmsMethod())
                      .addMethod(getGetEdgeSlmMethod())
                      .addMethod(getCreateEdgeSlmMethod())
                      .addMethod(getDeleteEdgeSlmMethod())
                      .addMethod(getCreateBlueprintMethod())
                      .addMethod(getUpdateBlueprintMethod())
                      .addMethod(getGetBlueprintMethod())
                      .addMethod(getDeleteBlueprintMethod())
                      .addMethod(getListBlueprintsMethod())
                      .addMethod(getApproveBlueprintMethod())
                      .addMethod(getProposeBlueprintMethod())
                      .addMethod(getRejectBlueprintMethod())
                      .addMethod(getListBlueprintRevisionsMethod())
                      .addMethod(getSearchBlueprintRevisionsMethod())
                      .addMethod(getSearchDeploymentRevisionsMethod())
                      .addMethod(getDiscardBlueprintChangesMethod())
                      .addMethod(getListPublicBlueprintsMethod())
                      .addMethod(getGetPublicBlueprintMethod())
                      .addMethod(getCreateDeploymentMethod())
                      .addMethod(getUpdateDeploymentMethod())
                      .addMethod(getGetDeploymentMethod())
                      .addMethod(getRemoveDeploymentMethod())
                      .addMethod(getListDeploymentsMethod())
                      .addMethod(getListDeploymentRevisionsMethod())
                      .addMethod(getDiscardDeploymentChangesMethod())
                      .addMethod(getApplyDeploymentMethod())
                      .addMethod(getComputeDeploymentStatusMethod())
                      .addMethod(getRollbackDeploymentMethod())
                      .addMethod(getGetHydratedDeploymentMethod())
                      .addMethod(getListHydratedDeploymentsMethod())
                      .addMethod(getUpdateHydratedDeploymentMethod())
                      .addMethod(getApplyHydratedDeploymentMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
