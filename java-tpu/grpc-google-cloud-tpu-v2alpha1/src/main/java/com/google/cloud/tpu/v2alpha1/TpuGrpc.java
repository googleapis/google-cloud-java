/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.tpu.v2alpha1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Manages TPU nodes and other resources
 * TPU API v2alpha1
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/tpu/v2alpha1/cloud_tpu.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TpuGrpc {

  private TpuGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.tpu.v2alpha1.Tpu";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.ListNodesRequest,
          com.google.cloud.tpu.v2alpha1.ListNodesResponse>
      getListNodesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListNodes",
      requestType = com.google.cloud.tpu.v2alpha1.ListNodesRequest.class,
      responseType = com.google.cloud.tpu.v2alpha1.ListNodesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.ListNodesRequest,
          com.google.cloud.tpu.v2alpha1.ListNodesResponse>
      getListNodesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.tpu.v2alpha1.ListNodesRequest,
            com.google.cloud.tpu.v2alpha1.ListNodesResponse>
        getListNodesMethod;
    if ((getListNodesMethod = TpuGrpc.getListNodesMethod) == null) {
      synchronized (TpuGrpc.class) {
        if ((getListNodesMethod = TpuGrpc.getListNodesMethod) == null) {
          TpuGrpc.getListNodesMethod =
              getListNodesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.tpu.v2alpha1.ListNodesRequest,
                          com.google.cloud.tpu.v2alpha1.ListNodesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListNodes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.tpu.v2alpha1.ListNodesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.tpu.v2alpha1.ListNodesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new TpuMethodDescriptorSupplier("ListNodes"))
                      .build();
        }
      }
    }
    return getListNodesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.GetNodeRequest, com.google.cloud.tpu.v2alpha1.Node>
      getGetNodeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNode",
      requestType = com.google.cloud.tpu.v2alpha1.GetNodeRequest.class,
      responseType = com.google.cloud.tpu.v2alpha1.Node.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.GetNodeRequest, com.google.cloud.tpu.v2alpha1.Node>
      getGetNodeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.tpu.v2alpha1.GetNodeRequest, com.google.cloud.tpu.v2alpha1.Node>
        getGetNodeMethod;
    if ((getGetNodeMethod = TpuGrpc.getGetNodeMethod) == null) {
      synchronized (TpuGrpc.class) {
        if ((getGetNodeMethod = TpuGrpc.getGetNodeMethod) == null) {
          TpuGrpc.getGetNodeMethod =
              getGetNodeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.tpu.v2alpha1.GetNodeRequest,
                          com.google.cloud.tpu.v2alpha1.Node>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNode"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.tpu.v2alpha1.GetNodeRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.tpu.v2alpha1.Node.getDefaultInstance()))
                      .setSchemaDescriptor(new TpuMethodDescriptorSupplier("GetNode"))
                      .build();
        }
      }
    }
    return getGetNodeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.CreateNodeRequest, com.google.longrunning.Operation>
      getCreateNodeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateNode",
      requestType = com.google.cloud.tpu.v2alpha1.CreateNodeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.CreateNodeRequest, com.google.longrunning.Operation>
      getCreateNodeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.tpu.v2alpha1.CreateNodeRequest, com.google.longrunning.Operation>
        getCreateNodeMethod;
    if ((getCreateNodeMethod = TpuGrpc.getCreateNodeMethod) == null) {
      synchronized (TpuGrpc.class) {
        if ((getCreateNodeMethod = TpuGrpc.getCreateNodeMethod) == null) {
          TpuGrpc.getCreateNodeMethod =
              getCreateNodeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.tpu.v2alpha1.CreateNodeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateNode"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.tpu.v2alpha1.CreateNodeRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new TpuMethodDescriptorSupplier("CreateNode"))
                      .build();
        }
      }
    }
    return getCreateNodeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.DeleteNodeRequest, com.google.longrunning.Operation>
      getDeleteNodeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteNode",
      requestType = com.google.cloud.tpu.v2alpha1.DeleteNodeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.DeleteNodeRequest, com.google.longrunning.Operation>
      getDeleteNodeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.tpu.v2alpha1.DeleteNodeRequest, com.google.longrunning.Operation>
        getDeleteNodeMethod;
    if ((getDeleteNodeMethod = TpuGrpc.getDeleteNodeMethod) == null) {
      synchronized (TpuGrpc.class) {
        if ((getDeleteNodeMethod = TpuGrpc.getDeleteNodeMethod) == null) {
          TpuGrpc.getDeleteNodeMethod =
              getDeleteNodeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.tpu.v2alpha1.DeleteNodeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteNode"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.tpu.v2alpha1.DeleteNodeRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new TpuMethodDescriptorSupplier("DeleteNode"))
                      .build();
        }
      }
    }
    return getDeleteNodeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.StopNodeRequest, com.google.longrunning.Operation>
      getStopNodeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopNode",
      requestType = com.google.cloud.tpu.v2alpha1.StopNodeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.StopNodeRequest, com.google.longrunning.Operation>
      getStopNodeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.tpu.v2alpha1.StopNodeRequest, com.google.longrunning.Operation>
        getStopNodeMethod;
    if ((getStopNodeMethod = TpuGrpc.getStopNodeMethod) == null) {
      synchronized (TpuGrpc.class) {
        if ((getStopNodeMethod = TpuGrpc.getStopNodeMethod) == null) {
          TpuGrpc.getStopNodeMethod =
              getStopNodeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.tpu.v2alpha1.StopNodeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopNode"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.tpu.v2alpha1.StopNodeRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new TpuMethodDescriptorSupplier("StopNode"))
                      .build();
        }
      }
    }
    return getStopNodeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.StartNodeRequest, com.google.longrunning.Operation>
      getStartNodeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartNode",
      requestType = com.google.cloud.tpu.v2alpha1.StartNodeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.StartNodeRequest, com.google.longrunning.Operation>
      getStartNodeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.tpu.v2alpha1.StartNodeRequest, com.google.longrunning.Operation>
        getStartNodeMethod;
    if ((getStartNodeMethod = TpuGrpc.getStartNodeMethod) == null) {
      synchronized (TpuGrpc.class) {
        if ((getStartNodeMethod = TpuGrpc.getStartNodeMethod) == null) {
          TpuGrpc.getStartNodeMethod =
              getStartNodeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.tpu.v2alpha1.StartNodeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartNode"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.tpu.v2alpha1.StartNodeRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new TpuMethodDescriptorSupplier("StartNode"))
                      .build();
        }
      }
    }
    return getStartNodeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.UpdateNodeRequest, com.google.longrunning.Operation>
      getUpdateNodeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateNode",
      requestType = com.google.cloud.tpu.v2alpha1.UpdateNodeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.UpdateNodeRequest, com.google.longrunning.Operation>
      getUpdateNodeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.tpu.v2alpha1.UpdateNodeRequest, com.google.longrunning.Operation>
        getUpdateNodeMethod;
    if ((getUpdateNodeMethod = TpuGrpc.getUpdateNodeMethod) == null) {
      synchronized (TpuGrpc.class) {
        if ((getUpdateNodeMethod = TpuGrpc.getUpdateNodeMethod) == null) {
          TpuGrpc.getUpdateNodeMethod =
              getUpdateNodeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.tpu.v2alpha1.UpdateNodeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateNode"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.tpu.v2alpha1.UpdateNodeRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new TpuMethodDescriptorSupplier("UpdateNode"))
                      .build();
        }
      }
    }
    return getUpdateNodeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.PerformMaintenanceRequest, com.google.longrunning.Operation>
      getPerformMaintenanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PerformMaintenance",
      requestType = com.google.cloud.tpu.v2alpha1.PerformMaintenanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.PerformMaintenanceRequest, com.google.longrunning.Operation>
      getPerformMaintenanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.tpu.v2alpha1.PerformMaintenanceRequest,
            com.google.longrunning.Operation>
        getPerformMaintenanceMethod;
    if ((getPerformMaintenanceMethod = TpuGrpc.getPerformMaintenanceMethod) == null) {
      synchronized (TpuGrpc.class) {
        if ((getPerformMaintenanceMethod = TpuGrpc.getPerformMaintenanceMethod) == null) {
          TpuGrpc.getPerformMaintenanceMethod =
              getPerformMaintenanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.tpu.v2alpha1.PerformMaintenanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PerformMaintenance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.tpu.v2alpha1.PerformMaintenanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new TpuMethodDescriptorSupplier("PerformMaintenance"))
                      .build();
        }
      }
    }
    return getPerformMaintenanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.ListQueuedResourcesRequest,
          com.google.cloud.tpu.v2alpha1.ListQueuedResourcesResponse>
      getListQueuedResourcesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListQueuedResources",
      requestType = com.google.cloud.tpu.v2alpha1.ListQueuedResourcesRequest.class,
      responseType = com.google.cloud.tpu.v2alpha1.ListQueuedResourcesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.ListQueuedResourcesRequest,
          com.google.cloud.tpu.v2alpha1.ListQueuedResourcesResponse>
      getListQueuedResourcesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.tpu.v2alpha1.ListQueuedResourcesRequest,
            com.google.cloud.tpu.v2alpha1.ListQueuedResourcesResponse>
        getListQueuedResourcesMethod;
    if ((getListQueuedResourcesMethod = TpuGrpc.getListQueuedResourcesMethod) == null) {
      synchronized (TpuGrpc.class) {
        if ((getListQueuedResourcesMethod = TpuGrpc.getListQueuedResourcesMethod) == null) {
          TpuGrpc.getListQueuedResourcesMethod =
              getListQueuedResourcesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.tpu.v2alpha1.ListQueuedResourcesRequest,
                          com.google.cloud.tpu.v2alpha1.ListQueuedResourcesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListQueuedResources"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.tpu.v2alpha1.ListQueuedResourcesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.tpu.v2alpha1.ListQueuedResourcesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new TpuMethodDescriptorSupplier("ListQueuedResources"))
                      .build();
        }
      }
    }
    return getListQueuedResourcesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.GetQueuedResourceRequest,
          com.google.cloud.tpu.v2alpha1.QueuedResource>
      getGetQueuedResourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetQueuedResource",
      requestType = com.google.cloud.tpu.v2alpha1.GetQueuedResourceRequest.class,
      responseType = com.google.cloud.tpu.v2alpha1.QueuedResource.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.GetQueuedResourceRequest,
          com.google.cloud.tpu.v2alpha1.QueuedResource>
      getGetQueuedResourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.tpu.v2alpha1.GetQueuedResourceRequest,
            com.google.cloud.tpu.v2alpha1.QueuedResource>
        getGetQueuedResourceMethod;
    if ((getGetQueuedResourceMethod = TpuGrpc.getGetQueuedResourceMethod) == null) {
      synchronized (TpuGrpc.class) {
        if ((getGetQueuedResourceMethod = TpuGrpc.getGetQueuedResourceMethod) == null) {
          TpuGrpc.getGetQueuedResourceMethod =
              getGetQueuedResourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.tpu.v2alpha1.GetQueuedResourceRequest,
                          com.google.cloud.tpu.v2alpha1.QueuedResource>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetQueuedResource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.tpu.v2alpha1.GetQueuedResourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.tpu.v2alpha1.QueuedResource.getDefaultInstance()))
                      .setSchemaDescriptor(new TpuMethodDescriptorSupplier("GetQueuedResource"))
                      .build();
        }
      }
    }
    return getGetQueuedResourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.CreateQueuedResourceRequest,
          com.google.longrunning.Operation>
      getCreateQueuedResourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateQueuedResource",
      requestType = com.google.cloud.tpu.v2alpha1.CreateQueuedResourceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.CreateQueuedResourceRequest,
          com.google.longrunning.Operation>
      getCreateQueuedResourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.tpu.v2alpha1.CreateQueuedResourceRequest,
            com.google.longrunning.Operation>
        getCreateQueuedResourceMethod;
    if ((getCreateQueuedResourceMethod = TpuGrpc.getCreateQueuedResourceMethod) == null) {
      synchronized (TpuGrpc.class) {
        if ((getCreateQueuedResourceMethod = TpuGrpc.getCreateQueuedResourceMethod) == null) {
          TpuGrpc.getCreateQueuedResourceMethod =
              getCreateQueuedResourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.tpu.v2alpha1.CreateQueuedResourceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateQueuedResource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.tpu.v2alpha1.CreateQueuedResourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new TpuMethodDescriptorSupplier("CreateQueuedResource"))
                      .build();
        }
      }
    }
    return getCreateQueuedResourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.DeleteQueuedResourceRequest,
          com.google.longrunning.Operation>
      getDeleteQueuedResourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteQueuedResource",
      requestType = com.google.cloud.tpu.v2alpha1.DeleteQueuedResourceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.DeleteQueuedResourceRequest,
          com.google.longrunning.Operation>
      getDeleteQueuedResourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.tpu.v2alpha1.DeleteQueuedResourceRequest,
            com.google.longrunning.Operation>
        getDeleteQueuedResourceMethod;
    if ((getDeleteQueuedResourceMethod = TpuGrpc.getDeleteQueuedResourceMethod) == null) {
      synchronized (TpuGrpc.class) {
        if ((getDeleteQueuedResourceMethod = TpuGrpc.getDeleteQueuedResourceMethod) == null) {
          TpuGrpc.getDeleteQueuedResourceMethod =
              getDeleteQueuedResourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.tpu.v2alpha1.DeleteQueuedResourceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteQueuedResource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.tpu.v2alpha1.DeleteQueuedResourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new TpuMethodDescriptorSupplier("DeleteQueuedResource"))
                      .build();
        }
      }
    }
    return getDeleteQueuedResourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.ResetQueuedResourceRequest,
          com.google.longrunning.Operation>
      getResetQueuedResourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResetQueuedResource",
      requestType = com.google.cloud.tpu.v2alpha1.ResetQueuedResourceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.ResetQueuedResourceRequest,
          com.google.longrunning.Operation>
      getResetQueuedResourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.tpu.v2alpha1.ResetQueuedResourceRequest,
            com.google.longrunning.Operation>
        getResetQueuedResourceMethod;
    if ((getResetQueuedResourceMethod = TpuGrpc.getResetQueuedResourceMethod) == null) {
      synchronized (TpuGrpc.class) {
        if ((getResetQueuedResourceMethod = TpuGrpc.getResetQueuedResourceMethod) == null) {
          TpuGrpc.getResetQueuedResourceMethod =
              getResetQueuedResourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.tpu.v2alpha1.ResetQueuedResourceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ResetQueuedResource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.tpu.v2alpha1.ResetQueuedResourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new TpuMethodDescriptorSupplier("ResetQueuedResource"))
                      .build();
        }
      }
    }
    return getResetQueuedResourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.PerformMaintenanceQueuedResourceRequest,
          com.google.longrunning.Operation>
      getPerformMaintenanceQueuedResourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PerformMaintenanceQueuedResource",
      requestType = com.google.cloud.tpu.v2alpha1.PerformMaintenanceQueuedResourceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.PerformMaintenanceQueuedResourceRequest,
          com.google.longrunning.Operation>
      getPerformMaintenanceQueuedResourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.tpu.v2alpha1.PerformMaintenanceQueuedResourceRequest,
            com.google.longrunning.Operation>
        getPerformMaintenanceQueuedResourceMethod;
    if ((getPerformMaintenanceQueuedResourceMethod =
            TpuGrpc.getPerformMaintenanceQueuedResourceMethod)
        == null) {
      synchronized (TpuGrpc.class) {
        if ((getPerformMaintenanceQueuedResourceMethod =
                TpuGrpc.getPerformMaintenanceQueuedResourceMethod)
            == null) {
          TpuGrpc.getPerformMaintenanceQueuedResourceMethod =
              getPerformMaintenanceQueuedResourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.tpu.v2alpha1.PerformMaintenanceQueuedResourceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "PerformMaintenanceQueuedResource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.tpu.v2alpha1.PerformMaintenanceQueuedResourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TpuMethodDescriptorSupplier("PerformMaintenanceQueuedResource"))
                      .build();
        }
      }
    }
    return getPerformMaintenanceQueuedResourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.GenerateServiceIdentityRequest,
          com.google.cloud.tpu.v2alpha1.GenerateServiceIdentityResponse>
      getGenerateServiceIdentityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateServiceIdentity",
      requestType = com.google.cloud.tpu.v2alpha1.GenerateServiceIdentityRequest.class,
      responseType = com.google.cloud.tpu.v2alpha1.GenerateServiceIdentityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.GenerateServiceIdentityRequest,
          com.google.cloud.tpu.v2alpha1.GenerateServiceIdentityResponse>
      getGenerateServiceIdentityMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.tpu.v2alpha1.GenerateServiceIdentityRequest,
            com.google.cloud.tpu.v2alpha1.GenerateServiceIdentityResponse>
        getGenerateServiceIdentityMethod;
    if ((getGenerateServiceIdentityMethod = TpuGrpc.getGenerateServiceIdentityMethod) == null) {
      synchronized (TpuGrpc.class) {
        if ((getGenerateServiceIdentityMethod = TpuGrpc.getGenerateServiceIdentityMethod) == null) {
          TpuGrpc.getGenerateServiceIdentityMethod =
              getGenerateServiceIdentityMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.tpu.v2alpha1.GenerateServiceIdentityRequest,
                          com.google.cloud.tpu.v2alpha1.GenerateServiceIdentityResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GenerateServiceIdentity"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.tpu.v2alpha1.GenerateServiceIdentityRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.tpu.v2alpha1.GenerateServiceIdentityResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TpuMethodDescriptorSupplier("GenerateServiceIdentity"))
                      .build();
        }
      }
    }
    return getGenerateServiceIdentityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.ListAcceleratorTypesRequest,
          com.google.cloud.tpu.v2alpha1.ListAcceleratorTypesResponse>
      getListAcceleratorTypesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAcceleratorTypes",
      requestType = com.google.cloud.tpu.v2alpha1.ListAcceleratorTypesRequest.class,
      responseType = com.google.cloud.tpu.v2alpha1.ListAcceleratorTypesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.ListAcceleratorTypesRequest,
          com.google.cloud.tpu.v2alpha1.ListAcceleratorTypesResponse>
      getListAcceleratorTypesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.tpu.v2alpha1.ListAcceleratorTypesRequest,
            com.google.cloud.tpu.v2alpha1.ListAcceleratorTypesResponse>
        getListAcceleratorTypesMethod;
    if ((getListAcceleratorTypesMethod = TpuGrpc.getListAcceleratorTypesMethod) == null) {
      synchronized (TpuGrpc.class) {
        if ((getListAcceleratorTypesMethod = TpuGrpc.getListAcceleratorTypesMethod) == null) {
          TpuGrpc.getListAcceleratorTypesMethod =
              getListAcceleratorTypesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.tpu.v2alpha1.ListAcceleratorTypesRequest,
                          com.google.cloud.tpu.v2alpha1.ListAcceleratorTypesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAcceleratorTypes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.tpu.v2alpha1.ListAcceleratorTypesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.tpu.v2alpha1.ListAcceleratorTypesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new TpuMethodDescriptorSupplier("ListAcceleratorTypes"))
                      .build();
        }
      }
    }
    return getListAcceleratorTypesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.GetAcceleratorTypeRequest,
          com.google.cloud.tpu.v2alpha1.AcceleratorType>
      getGetAcceleratorTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAcceleratorType",
      requestType = com.google.cloud.tpu.v2alpha1.GetAcceleratorTypeRequest.class,
      responseType = com.google.cloud.tpu.v2alpha1.AcceleratorType.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.GetAcceleratorTypeRequest,
          com.google.cloud.tpu.v2alpha1.AcceleratorType>
      getGetAcceleratorTypeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.tpu.v2alpha1.GetAcceleratorTypeRequest,
            com.google.cloud.tpu.v2alpha1.AcceleratorType>
        getGetAcceleratorTypeMethod;
    if ((getGetAcceleratorTypeMethod = TpuGrpc.getGetAcceleratorTypeMethod) == null) {
      synchronized (TpuGrpc.class) {
        if ((getGetAcceleratorTypeMethod = TpuGrpc.getGetAcceleratorTypeMethod) == null) {
          TpuGrpc.getGetAcceleratorTypeMethod =
              getGetAcceleratorTypeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.tpu.v2alpha1.GetAcceleratorTypeRequest,
                          com.google.cloud.tpu.v2alpha1.AcceleratorType>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAcceleratorType"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.tpu.v2alpha1.GetAcceleratorTypeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.tpu.v2alpha1.AcceleratorType.getDefaultInstance()))
                      .setSchemaDescriptor(new TpuMethodDescriptorSupplier("GetAcceleratorType"))
                      .build();
        }
      }
    }
    return getGetAcceleratorTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.ListRuntimeVersionsRequest,
          com.google.cloud.tpu.v2alpha1.ListRuntimeVersionsResponse>
      getListRuntimeVersionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRuntimeVersions",
      requestType = com.google.cloud.tpu.v2alpha1.ListRuntimeVersionsRequest.class,
      responseType = com.google.cloud.tpu.v2alpha1.ListRuntimeVersionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.ListRuntimeVersionsRequest,
          com.google.cloud.tpu.v2alpha1.ListRuntimeVersionsResponse>
      getListRuntimeVersionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.tpu.v2alpha1.ListRuntimeVersionsRequest,
            com.google.cloud.tpu.v2alpha1.ListRuntimeVersionsResponse>
        getListRuntimeVersionsMethod;
    if ((getListRuntimeVersionsMethod = TpuGrpc.getListRuntimeVersionsMethod) == null) {
      synchronized (TpuGrpc.class) {
        if ((getListRuntimeVersionsMethod = TpuGrpc.getListRuntimeVersionsMethod) == null) {
          TpuGrpc.getListRuntimeVersionsMethod =
              getListRuntimeVersionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.tpu.v2alpha1.ListRuntimeVersionsRequest,
                          com.google.cloud.tpu.v2alpha1.ListRuntimeVersionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListRuntimeVersions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.tpu.v2alpha1.ListRuntimeVersionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.tpu.v2alpha1.ListRuntimeVersionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new TpuMethodDescriptorSupplier("ListRuntimeVersions"))
                      .build();
        }
      }
    }
    return getListRuntimeVersionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.GetRuntimeVersionRequest,
          com.google.cloud.tpu.v2alpha1.RuntimeVersion>
      getGetRuntimeVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRuntimeVersion",
      requestType = com.google.cloud.tpu.v2alpha1.GetRuntimeVersionRequest.class,
      responseType = com.google.cloud.tpu.v2alpha1.RuntimeVersion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.GetRuntimeVersionRequest,
          com.google.cloud.tpu.v2alpha1.RuntimeVersion>
      getGetRuntimeVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.tpu.v2alpha1.GetRuntimeVersionRequest,
            com.google.cloud.tpu.v2alpha1.RuntimeVersion>
        getGetRuntimeVersionMethod;
    if ((getGetRuntimeVersionMethod = TpuGrpc.getGetRuntimeVersionMethod) == null) {
      synchronized (TpuGrpc.class) {
        if ((getGetRuntimeVersionMethod = TpuGrpc.getGetRuntimeVersionMethod) == null) {
          TpuGrpc.getGetRuntimeVersionMethod =
              getGetRuntimeVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.tpu.v2alpha1.GetRuntimeVersionRequest,
                          com.google.cloud.tpu.v2alpha1.RuntimeVersion>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRuntimeVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.tpu.v2alpha1.GetRuntimeVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.tpu.v2alpha1.RuntimeVersion.getDefaultInstance()))
                      .setSchemaDescriptor(new TpuMethodDescriptorSupplier("GetRuntimeVersion"))
                      .build();
        }
      }
    }
    return getGetRuntimeVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.GetGuestAttributesRequest,
          com.google.cloud.tpu.v2alpha1.GetGuestAttributesResponse>
      getGetGuestAttributesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGuestAttributes",
      requestType = com.google.cloud.tpu.v2alpha1.GetGuestAttributesRequest.class,
      responseType = com.google.cloud.tpu.v2alpha1.GetGuestAttributesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.GetGuestAttributesRequest,
          com.google.cloud.tpu.v2alpha1.GetGuestAttributesResponse>
      getGetGuestAttributesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.tpu.v2alpha1.GetGuestAttributesRequest,
            com.google.cloud.tpu.v2alpha1.GetGuestAttributesResponse>
        getGetGuestAttributesMethod;
    if ((getGetGuestAttributesMethod = TpuGrpc.getGetGuestAttributesMethod) == null) {
      synchronized (TpuGrpc.class) {
        if ((getGetGuestAttributesMethod = TpuGrpc.getGetGuestAttributesMethod) == null) {
          TpuGrpc.getGetGuestAttributesMethod =
              getGetGuestAttributesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.tpu.v2alpha1.GetGuestAttributesRequest,
                          com.google.cloud.tpu.v2alpha1.GetGuestAttributesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetGuestAttributes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.tpu.v2alpha1.GetGuestAttributesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.tpu.v2alpha1.GetGuestAttributesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new TpuMethodDescriptorSupplier("GetGuestAttributes"))
                      .build();
        }
      }
    }
    return getGetGuestAttributesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.ListReservationsRequest,
          com.google.cloud.tpu.v2alpha1.ListReservationsResponse>
      getListReservationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListReservations",
      requestType = com.google.cloud.tpu.v2alpha1.ListReservationsRequest.class,
      responseType = com.google.cloud.tpu.v2alpha1.ListReservationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.ListReservationsRequest,
          com.google.cloud.tpu.v2alpha1.ListReservationsResponse>
      getListReservationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.tpu.v2alpha1.ListReservationsRequest,
            com.google.cloud.tpu.v2alpha1.ListReservationsResponse>
        getListReservationsMethod;
    if ((getListReservationsMethod = TpuGrpc.getListReservationsMethod) == null) {
      synchronized (TpuGrpc.class) {
        if ((getListReservationsMethod = TpuGrpc.getListReservationsMethod) == null) {
          TpuGrpc.getListReservationsMethod =
              getListReservationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.tpu.v2alpha1.ListReservationsRequest,
                          com.google.cloud.tpu.v2alpha1.ListReservationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListReservations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.tpu.v2alpha1.ListReservationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.tpu.v2alpha1.ListReservationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new TpuMethodDescriptorSupplier("ListReservations"))
                      .build();
        }
      }
    }
    return getListReservationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.SimulateMaintenanceEventRequest,
          com.google.longrunning.Operation>
      getSimulateMaintenanceEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SimulateMaintenanceEvent",
      requestType = com.google.cloud.tpu.v2alpha1.SimulateMaintenanceEventRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.tpu.v2alpha1.SimulateMaintenanceEventRequest,
          com.google.longrunning.Operation>
      getSimulateMaintenanceEventMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.tpu.v2alpha1.SimulateMaintenanceEventRequest,
            com.google.longrunning.Operation>
        getSimulateMaintenanceEventMethod;
    if ((getSimulateMaintenanceEventMethod = TpuGrpc.getSimulateMaintenanceEventMethod) == null) {
      synchronized (TpuGrpc.class) {
        if ((getSimulateMaintenanceEventMethod = TpuGrpc.getSimulateMaintenanceEventMethod)
            == null) {
          TpuGrpc.getSimulateMaintenanceEventMethod =
              getSimulateMaintenanceEventMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.tpu.v2alpha1.SimulateMaintenanceEventRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SimulateMaintenanceEvent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.tpu.v2alpha1.SimulateMaintenanceEventRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TpuMethodDescriptorSupplier("SimulateMaintenanceEvent"))
                      .build();
        }
      }
    }
    return getSimulateMaintenanceEventMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static TpuStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TpuStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TpuStub>() {
          @java.lang.Override
          public TpuStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TpuStub(channel, callOptions);
          }
        };
    return TpuStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TpuBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TpuBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TpuBlockingStub>() {
          @java.lang.Override
          public TpuBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TpuBlockingStub(channel, callOptions);
          }
        };
    return TpuBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static TpuFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TpuFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TpuFutureStub>() {
          @java.lang.Override
          public TpuFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TpuFutureStub(channel, callOptions);
          }
        };
    return TpuFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Manages TPU nodes and other resources
   * TPU API v2alpha1
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists nodes.
     * </pre>
     */
    default void listNodes(
        com.google.cloud.tpu.v2alpha1.ListNodesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v2alpha1.ListNodesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListNodesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a node.
     * </pre>
     */
    default void getNode(
        com.google.cloud.tpu.v2alpha1.GetNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v2alpha1.Node> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetNodeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a node.
     * </pre>
     */
    default void createNode(
        com.google.cloud.tpu.v2alpha1.CreateNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateNodeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a node.
     * </pre>
     */
    default void deleteNode(
        com.google.cloud.tpu.v2alpha1.DeleteNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteNodeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Stops a node. This operation is only available with single TPU nodes.
     * </pre>
     */
    default void stopNode(
        com.google.cloud.tpu.v2alpha1.StopNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStopNodeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts a node.
     * </pre>
     */
    default void startNode(
        com.google.cloud.tpu.v2alpha1.StartNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartNodeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the configurations of a node.
     * </pre>
     */
    default void updateNode(
        com.google.cloud.tpu.v2alpha1.UpdateNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateNodeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Perform manual maintenance on a node.
     * </pre>
     */
    default void performMaintenance(
        com.google.cloud.tpu.v2alpha1.PerformMaintenanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getPerformMaintenanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists queued resources.
     * </pre>
     */
    default void listQueuedResources(
        com.google.cloud.tpu.v2alpha1.ListQueuedResourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v2alpha1.ListQueuedResourcesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListQueuedResourcesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a queued resource.
     * </pre>
     */
    default void getQueuedResource(
        com.google.cloud.tpu.v2alpha1.GetQueuedResourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v2alpha1.QueuedResource>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetQueuedResourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a QueuedResource TPU instance.
     * </pre>
     */
    default void createQueuedResource(
        com.google.cloud.tpu.v2alpha1.CreateQueuedResourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateQueuedResourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a QueuedResource TPU instance.
     * </pre>
     */
    default void deleteQueuedResource(
        com.google.cloud.tpu.v2alpha1.DeleteQueuedResourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteQueuedResourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resets a QueuedResource TPU instance
     * </pre>
     */
    default void resetQueuedResource(
        com.google.cloud.tpu.v2alpha1.ResetQueuedResourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getResetQueuedResourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Perform manual maintenance on specific nodes of a QueuedResource.
     * </pre>
     */
    default void performMaintenanceQueuedResource(
        com.google.cloud.tpu.v2alpha1.PerformMaintenanceQueuedResourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getPerformMaintenanceQueuedResourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates the Cloud TPU service identity for the project.
     * </pre>
     */
    default void generateServiceIdentity(
        com.google.cloud.tpu.v2alpha1.GenerateServiceIdentityRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v2alpha1.GenerateServiceIdentityResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateServiceIdentityMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists accelerator types supported by this API.
     * </pre>
     */
    default void listAcceleratorTypes(
        com.google.cloud.tpu.v2alpha1.ListAcceleratorTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v2alpha1.ListAcceleratorTypesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAcceleratorTypesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets AcceleratorType.
     * </pre>
     */
    default void getAcceleratorType(
        com.google.cloud.tpu.v2alpha1.GetAcceleratorTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v2alpha1.AcceleratorType>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAcceleratorTypeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists runtime versions supported by this API.
     * </pre>
     */
    default void listRuntimeVersions(
        com.google.cloud.tpu.v2alpha1.ListRuntimeVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v2alpha1.ListRuntimeVersionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRuntimeVersionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a runtime version.
     * </pre>
     */
    default void getRuntimeVersion(
        com.google.cloud.tpu.v2alpha1.GetRuntimeVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v2alpha1.RuntimeVersion>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetRuntimeVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the guest attributes for the node.
     * </pre>
     */
    default void getGuestAttributes(
        com.google.cloud.tpu.v2alpha1.GetGuestAttributesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v2alpha1.GetGuestAttributesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetGuestAttributesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the reservations for the given project in the given location.
     * </pre>
     */
    default void listReservations(
        com.google.cloud.tpu.v2alpha1.ListReservationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v2alpha1.ListReservationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListReservationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Simulates a maintenance event.
     * </pre>
     */
    default void simulateMaintenanceEvent(
        com.google.cloud.tpu.v2alpha1.SimulateMaintenanceEventRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSimulateMaintenanceEventMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Tpu.
   *
   * <pre>
   * Manages TPU nodes and other resources
   * TPU API v2alpha1
   * </pre>
   */
  public abstract static class TpuImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return TpuGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Tpu.
   *
   * <pre>
   * Manages TPU nodes and other resources
   * TPU API v2alpha1
   * </pre>
   */
  public static final class TpuStub extends io.grpc.stub.AbstractAsyncStub<TpuStub> {
    private TpuStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TpuStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TpuStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists nodes.
     * </pre>
     */
    public void listNodes(
        com.google.cloud.tpu.v2alpha1.ListNodesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v2alpha1.ListNodesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListNodesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a node.
     * </pre>
     */
    public void getNode(
        com.google.cloud.tpu.v2alpha1.GetNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v2alpha1.Node> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNodeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a node.
     * </pre>
     */
    public void createNode(
        com.google.cloud.tpu.v2alpha1.CreateNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateNodeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a node.
     * </pre>
     */
    public void deleteNode(
        com.google.cloud.tpu.v2alpha1.DeleteNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteNodeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Stops a node. This operation is only available with single TPU nodes.
     * </pre>
     */
    public void stopNode(
        com.google.cloud.tpu.v2alpha1.StopNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopNodeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts a node.
     * </pre>
     */
    public void startNode(
        com.google.cloud.tpu.v2alpha1.StartNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartNodeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the configurations of a node.
     * </pre>
     */
    public void updateNode(
        com.google.cloud.tpu.v2alpha1.UpdateNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateNodeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Perform manual maintenance on a node.
     * </pre>
     */
    public void performMaintenance(
        com.google.cloud.tpu.v2alpha1.PerformMaintenanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPerformMaintenanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists queued resources.
     * </pre>
     */
    public void listQueuedResources(
        com.google.cloud.tpu.v2alpha1.ListQueuedResourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v2alpha1.ListQueuedResourcesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListQueuedResourcesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a queued resource.
     * </pre>
     */
    public void getQueuedResource(
        com.google.cloud.tpu.v2alpha1.GetQueuedResourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v2alpha1.QueuedResource>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetQueuedResourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a QueuedResource TPU instance.
     * </pre>
     */
    public void createQueuedResource(
        com.google.cloud.tpu.v2alpha1.CreateQueuedResourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateQueuedResourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a QueuedResource TPU instance.
     * </pre>
     */
    public void deleteQueuedResource(
        com.google.cloud.tpu.v2alpha1.DeleteQueuedResourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteQueuedResourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resets a QueuedResource TPU instance
     * </pre>
     */
    public void resetQueuedResource(
        com.google.cloud.tpu.v2alpha1.ResetQueuedResourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResetQueuedResourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Perform manual maintenance on specific nodes of a QueuedResource.
     * </pre>
     */
    public void performMaintenanceQueuedResource(
        com.google.cloud.tpu.v2alpha1.PerformMaintenanceQueuedResourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPerformMaintenanceQueuedResourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates the Cloud TPU service identity for the project.
     * </pre>
     */
    public void generateServiceIdentity(
        com.google.cloud.tpu.v2alpha1.GenerateServiceIdentityRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v2alpha1.GenerateServiceIdentityResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateServiceIdentityMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists accelerator types supported by this API.
     * </pre>
     */
    public void listAcceleratorTypes(
        com.google.cloud.tpu.v2alpha1.ListAcceleratorTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v2alpha1.ListAcceleratorTypesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAcceleratorTypesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets AcceleratorType.
     * </pre>
     */
    public void getAcceleratorType(
        com.google.cloud.tpu.v2alpha1.GetAcceleratorTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v2alpha1.AcceleratorType>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAcceleratorTypeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists runtime versions supported by this API.
     * </pre>
     */
    public void listRuntimeVersions(
        com.google.cloud.tpu.v2alpha1.ListRuntimeVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v2alpha1.ListRuntimeVersionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRuntimeVersionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a runtime version.
     * </pre>
     */
    public void getRuntimeVersion(
        com.google.cloud.tpu.v2alpha1.GetRuntimeVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v2alpha1.RuntimeVersion>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRuntimeVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the guest attributes for the node.
     * </pre>
     */
    public void getGuestAttributes(
        com.google.cloud.tpu.v2alpha1.GetGuestAttributesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v2alpha1.GetGuestAttributesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGuestAttributesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the reservations for the given project in the given location.
     * </pre>
     */
    public void listReservations(
        com.google.cloud.tpu.v2alpha1.ListReservationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v2alpha1.ListReservationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListReservationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Simulates a maintenance event.
     * </pre>
     */
    public void simulateMaintenanceEvent(
        com.google.cloud.tpu.v2alpha1.SimulateMaintenanceEventRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSimulateMaintenanceEventMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Tpu.
   *
   * <pre>
   * Manages TPU nodes and other resources
   * TPU API v2alpha1
   * </pre>
   */
  public static final class TpuBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TpuBlockingStub> {
    private TpuBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TpuBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TpuBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists nodes.
     * </pre>
     */
    public com.google.cloud.tpu.v2alpha1.ListNodesResponse listNodes(
        com.google.cloud.tpu.v2alpha1.ListNodesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListNodesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a node.
     * </pre>
     */
    public com.google.cloud.tpu.v2alpha1.Node getNode(
        com.google.cloud.tpu.v2alpha1.GetNodeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNodeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a node.
     * </pre>
     */
    public com.google.longrunning.Operation createNode(
        com.google.cloud.tpu.v2alpha1.CreateNodeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateNodeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a node.
     * </pre>
     */
    public com.google.longrunning.Operation deleteNode(
        com.google.cloud.tpu.v2alpha1.DeleteNodeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteNodeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Stops a node. This operation is only available with single TPU nodes.
     * </pre>
     */
    public com.google.longrunning.Operation stopNode(
        com.google.cloud.tpu.v2alpha1.StopNodeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopNodeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Starts a node.
     * </pre>
     */
    public com.google.longrunning.Operation startNode(
        com.google.cloud.tpu.v2alpha1.StartNodeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartNodeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the configurations of a node.
     * </pre>
     */
    public com.google.longrunning.Operation updateNode(
        com.google.cloud.tpu.v2alpha1.UpdateNodeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateNodeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Perform manual maintenance on a node.
     * </pre>
     */
    public com.google.longrunning.Operation performMaintenance(
        com.google.cloud.tpu.v2alpha1.PerformMaintenanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPerformMaintenanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists queued resources.
     * </pre>
     */
    public com.google.cloud.tpu.v2alpha1.ListQueuedResourcesResponse listQueuedResources(
        com.google.cloud.tpu.v2alpha1.ListQueuedResourcesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListQueuedResourcesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a queued resource.
     * </pre>
     */
    public com.google.cloud.tpu.v2alpha1.QueuedResource getQueuedResource(
        com.google.cloud.tpu.v2alpha1.GetQueuedResourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetQueuedResourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a QueuedResource TPU instance.
     * </pre>
     */
    public com.google.longrunning.Operation createQueuedResource(
        com.google.cloud.tpu.v2alpha1.CreateQueuedResourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateQueuedResourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a QueuedResource TPU instance.
     * </pre>
     */
    public com.google.longrunning.Operation deleteQueuedResource(
        com.google.cloud.tpu.v2alpha1.DeleteQueuedResourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteQueuedResourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Resets a QueuedResource TPU instance
     * </pre>
     */
    public com.google.longrunning.Operation resetQueuedResource(
        com.google.cloud.tpu.v2alpha1.ResetQueuedResourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResetQueuedResourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Perform manual maintenance on specific nodes of a QueuedResource.
     * </pre>
     */
    public com.google.longrunning.Operation performMaintenanceQueuedResource(
        com.google.cloud.tpu.v2alpha1.PerformMaintenanceQueuedResourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPerformMaintenanceQueuedResourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generates the Cloud TPU service identity for the project.
     * </pre>
     */
    public com.google.cloud.tpu.v2alpha1.GenerateServiceIdentityResponse generateServiceIdentity(
        com.google.cloud.tpu.v2alpha1.GenerateServiceIdentityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateServiceIdentityMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists accelerator types supported by this API.
     * </pre>
     */
    public com.google.cloud.tpu.v2alpha1.ListAcceleratorTypesResponse listAcceleratorTypes(
        com.google.cloud.tpu.v2alpha1.ListAcceleratorTypesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAcceleratorTypesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets AcceleratorType.
     * </pre>
     */
    public com.google.cloud.tpu.v2alpha1.AcceleratorType getAcceleratorType(
        com.google.cloud.tpu.v2alpha1.GetAcceleratorTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAcceleratorTypeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists runtime versions supported by this API.
     * </pre>
     */
    public com.google.cloud.tpu.v2alpha1.ListRuntimeVersionsResponse listRuntimeVersions(
        com.google.cloud.tpu.v2alpha1.ListRuntimeVersionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRuntimeVersionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a runtime version.
     * </pre>
     */
    public com.google.cloud.tpu.v2alpha1.RuntimeVersion getRuntimeVersion(
        com.google.cloud.tpu.v2alpha1.GetRuntimeVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRuntimeVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the guest attributes for the node.
     * </pre>
     */
    public com.google.cloud.tpu.v2alpha1.GetGuestAttributesResponse getGuestAttributes(
        com.google.cloud.tpu.v2alpha1.GetGuestAttributesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGuestAttributesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the reservations for the given project in the given location.
     * </pre>
     */
    public com.google.cloud.tpu.v2alpha1.ListReservationsResponse listReservations(
        com.google.cloud.tpu.v2alpha1.ListReservationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListReservationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Simulates a maintenance event.
     * </pre>
     */
    public com.google.longrunning.Operation simulateMaintenanceEvent(
        com.google.cloud.tpu.v2alpha1.SimulateMaintenanceEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSimulateMaintenanceEventMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Tpu.
   *
   * <pre>
   * Manages TPU nodes and other resources
   * TPU API v2alpha1
   * </pre>
   */
  public static final class TpuFutureStub extends io.grpc.stub.AbstractFutureStub<TpuFutureStub> {
    private TpuFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TpuFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TpuFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists nodes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.tpu.v2alpha1.ListNodesResponse>
        listNodes(com.google.cloud.tpu.v2alpha1.ListNodesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListNodesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a node.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.tpu.v2alpha1.Node>
        getNode(com.google.cloud.tpu.v2alpha1.GetNodeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNodeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a node.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createNode(com.google.cloud.tpu.v2alpha1.CreateNodeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateNodeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a node.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteNode(com.google.cloud.tpu.v2alpha1.DeleteNodeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteNodeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Stops a node. This operation is only available with single TPU nodes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        stopNode(com.google.cloud.tpu.v2alpha1.StopNodeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopNodeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Starts a node.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        startNode(com.google.cloud.tpu.v2alpha1.StartNodeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartNodeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the configurations of a node.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateNode(com.google.cloud.tpu.v2alpha1.UpdateNodeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateNodeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Perform manual maintenance on a node.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        performMaintenance(com.google.cloud.tpu.v2alpha1.PerformMaintenanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPerformMaintenanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists queued resources.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.tpu.v2alpha1.ListQueuedResourcesResponse>
        listQueuedResources(com.google.cloud.tpu.v2alpha1.ListQueuedResourcesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListQueuedResourcesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a queued resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.tpu.v2alpha1.QueuedResource>
        getQueuedResource(com.google.cloud.tpu.v2alpha1.GetQueuedResourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetQueuedResourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a QueuedResource TPU instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createQueuedResource(com.google.cloud.tpu.v2alpha1.CreateQueuedResourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateQueuedResourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a QueuedResource TPU instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteQueuedResource(com.google.cloud.tpu.v2alpha1.DeleteQueuedResourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteQueuedResourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Resets a QueuedResource TPU instance
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        resetQueuedResource(com.google.cloud.tpu.v2alpha1.ResetQueuedResourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResetQueuedResourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Perform manual maintenance on specific nodes of a QueuedResource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        performMaintenanceQueuedResource(
            com.google.cloud.tpu.v2alpha1.PerformMaintenanceQueuedResourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPerformMaintenanceQueuedResourceMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Generates the Cloud TPU service identity for the project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.tpu.v2alpha1.GenerateServiceIdentityResponse>
        generateServiceIdentity(
            com.google.cloud.tpu.v2alpha1.GenerateServiceIdentityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateServiceIdentityMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists accelerator types supported by this API.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.tpu.v2alpha1.ListAcceleratorTypesResponse>
        listAcceleratorTypes(com.google.cloud.tpu.v2alpha1.ListAcceleratorTypesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAcceleratorTypesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets AcceleratorType.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.tpu.v2alpha1.AcceleratorType>
        getAcceleratorType(com.google.cloud.tpu.v2alpha1.GetAcceleratorTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAcceleratorTypeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists runtime versions supported by this API.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.tpu.v2alpha1.ListRuntimeVersionsResponse>
        listRuntimeVersions(com.google.cloud.tpu.v2alpha1.ListRuntimeVersionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRuntimeVersionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a runtime version.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.tpu.v2alpha1.RuntimeVersion>
        getRuntimeVersion(com.google.cloud.tpu.v2alpha1.GetRuntimeVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRuntimeVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the guest attributes for the node.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.tpu.v2alpha1.GetGuestAttributesResponse>
        getGuestAttributes(com.google.cloud.tpu.v2alpha1.GetGuestAttributesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGuestAttributesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the reservations for the given project in the given location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.tpu.v2alpha1.ListReservationsResponse>
        listReservations(com.google.cloud.tpu.v2alpha1.ListReservationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListReservationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Simulates a maintenance event.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        simulateMaintenanceEvent(
            com.google.cloud.tpu.v2alpha1.SimulateMaintenanceEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSimulateMaintenanceEventMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_NODES = 0;
  private static final int METHODID_GET_NODE = 1;
  private static final int METHODID_CREATE_NODE = 2;
  private static final int METHODID_DELETE_NODE = 3;
  private static final int METHODID_STOP_NODE = 4;
  private static final int METHODID_START_NODE = 5;
  private static final int METHODID_UPDATE_NODE = 6;
  private static final int METHODID_PERFORM_MAINTENANCE = 7;
  private static final int METHODID_LIST_QUEUED_RESOURCES = 8;
  private static final int METHODID_GET_QUEUED_RESOURCE = 9;
  private static final int METHODID_CREATE_QUEUED_RESOURCE = 10;
  private static final int METHODID_DELETE_QUEUED_RESOURCE = 11;
  private static final int METHODID_RESET_QUEUED_RESOURCE = 12;
  private static final int METHODID_PERFORM_MAINTENANCE_QUEUED_RESOURCE = 13;
  private static final int METHODID_GENERATE_SERVICE_IDENTITY = 14;
  private static final int METHODID_LIST_ACCELERATOR_TYPES = 15;
  private static final int METHODID_GET_ACCELERATOR_TYPE = 16;
  private static final int METHODID_LIST_RUNTIME_VERSIONS = 17;
  private static final int METHODID_GET_RUNTIME_VERSION = 18;
  private static final int METHODID_GET_GUEST_ATTRIBUTES = 19;
  private static final int METHODID_LIST_RESERVATIONS = 20;
  private static final int METHODID_SIMULATE_MAINTENANCE_EVENT = 21;

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
        case METHODID_LIST_NODES:
          serviceImpl.listNodes(
              (com.google.cloud.tpu.v2alpha1.ListNodesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.tpu.v2alpha1.ListNodesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_NODE:
          serviceImpl.getNode(
              (com.google.cloud.tpu.v2alpha1.GetNodeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.tpu.v2alpha1.Node>) responseObserver);
          break;
        case METHODID_CREATE_NODE:
          serviceImpl.createNode(
              (com.google.cloud.tpu.v2alpha1.CreateNodeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_NODE:
          serviceImpl.deleteNode(
              (com.google.cloud.tpu.v2alpha1.DeleteNodeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_STOP_NODE:
          serviceImpl.stopNode(
              (com.google.cloud.tpu.v2alpha1.StopNodeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_START_NODE:
          serviceImpl.startNode(
              (com.google.cloud.tpu.v2alpha1.StartNodeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_NODE:
          serviceImpl.updateNode(
              (com.google.cloud.tpu.v2alpha1.UpdateNodeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_PERFORM_MAINTENANCE:
          serviceImpl.performMaintenance(
              (com.google.cloud.tpu.v2alpha1.PerformMaintenanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_QUEUED_RESOURCES:
          serviceImpl.listQueuedResources(
              (com.google.cloud.tpu.v2alpha1.ListQueuedResourcesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.tpu.v2alpha1.ListQueuedResourcesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_QUEUED_RESOURCE:
          serviceImpl.getQueuedResource(
              (com.google.cloud.tpu.v2alpha1.GetQueuedResourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.tpu.v2alpha1.QueuedResource>)
                  responseObserver);
          break;
        case METHODID_CREATE_QUEUED_RESOURCE:
          serviceImpl.createQueuedResource(
              (com.google.cloud.tpu.v2alpha1.CreateQueuedResourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_QUEUED_RESOURCE:
          serviceImpl.deleteQueuedResource(
              (com.google.cloud.tpu.v2alpha1.DeleteQueuedResourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RESET_QUEUED_RESOURCE:
          serviceImpl.resetQueuedResource(
              (com.google.cloud.tpu.v2alpha1.ResetQueuedResourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_PERFORM_MAINTENANCE_QUEUED_RESOURCE:
          serviceImpl.performMaintenanceQueuedResource(
              (com.google.cloud.tpu.v2alpha1.PerformMaintenanceQueuedResourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GENERATE_SERVICE_IDENTITY:
          serviceImpl.generateServiceIdentity(
              (com.google.cloud.tpu.v2alpha1.GenerateServiceIdentityRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.tpu.v2alpha1.GenerateServiceIdentityResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_ACCELERATOR_TYPES:
          serviceImpl.listAcceleratorTypes(
              (com.google.cloud.tpu.v2alpha1.ListAcceleratorTypesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.tpu.v2alpha1.ListAcceleratorTypesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ACCELERATOR_TYPE:
          serviceImpl.getAcceleratorType(
              (com.google.cloud.tpu.v2alpha1.GetAcceleratorTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.tpu.v2alpha1.AcceleratorType>)
                  responseObserver);
          break;
        case METHODID_LIST_RUNTIME_VERSIONS:
          serviceImpl.listRuntimeVersions(
              (com.google.cloud.tpu.v2alpha1.ListRuntimeVersionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.tpu.v2alpha1.ListRuntimeVersionsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_RUNTIME_VERSION:
          serviceImpl.getRuntimeVersion(
              (com.google.cloud.tpu.v2alpha1.GetRuntimeVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.tpu.v2alpha1.RuntimeVersion>)
                  responseObserver);
          break;
        case METHODID_GET_GUEST_ATTRIBUTES:
          serviceImpl.getGuestAttributes(
              (com.google.cloud.tpu.v2alpha1.GetGuestAttributesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.tpu.v2alpha1.GetGuestAttributesResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_RESERVATIONS:
          serviceImpl.listReservations(
              (com.google.cloud.tpu.v2alpha1.ListReservationsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.tpu.v2alpha1.ListReservationsResponse>)
                  responseObserver);
          break;
        case METHODID_SIMULATE_MAINTENANCE_EVENT:
          serviceImpl.simulateMaintenanceEvent(
              (com.google.cloud.tpu.v2alpha1.SimulateMaintenanceEventRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
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
            getListNodesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.tpu.v2alpha1.ListNodesRequest,
                    com.google.cloud.tpu.v2alpha1.ListNodesResponse>(service, METHODID_LIST_NODES)))
        .addMethod(
            getGetNodeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.tpu.v2alpha1.GetNodeRequest,
                    com.google.cloud.tpu.v2alpha1.Node>(service, METHODID_GET_NODE)))
        .addMethod(
            getCreateNodeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.tpu.v2alpha1.CreateNodeRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_NODE)))
        .addMethod(
            getDeleteNodeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.tpu.v2alpha1.DeleteNodeRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_NODE)))
        .addMethod(
            getStopNodeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.tpu.v2alpha1.StopNodeRequest,
                    com.google.longrunning.Operation>(service, METHODID_STOP_NODE)))
        .addMethod(
            getStartNodeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.tpu.v2alpha1.StartNodeRequest,
                    com.google.longrunning.Operation>(service, METHODID_START_NODE)))
        .addMethod(
            getUpdateNodeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.tpu.v2alpha1.UpdateNodeRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_NODE)))
        .addMethod(
            getPerformMaintenanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.tpu.v2alpha1.PerformMaintenanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_PERFORM_MAINTENANCE)))
        .addMethod(
            getListQueuedResourcesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.tpu.v2alpha1.ListQueuedResourcesRequest,
                    com.google.cloud.tpu.v2alpha1.ListQueuedResourcesResponse>(
                    service, METHODID_LIST_QUEUED_RESOURCES)))
        .addMethod(
            getGetQueuedResourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.tpu.v2alpha1.GetQueuedResourceRequest,
                    com.google.cloud.tpu.v2alpha1.QueuedResource>(
                    service, METHODID_GET_QUEUED_RESOURCE)))
        .addMethod(
            getCreateQueuedResourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.tpu.v2alpha1.CreateQueuedResourceRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_QUEUED_RESOURCE)))
        .addMethod(
            getDeleteQueuedResourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.tpu.v2alpha1.DeleteQueuedResourceRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_QUEUED_RESOURCE)))
        .addMethod(
            getResetQueuedResourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.tpu.v2alpha1.ResetQueuedResourceRequest,
                    com.google.longrunning.Operation>(service, METHODID_RESET_QUEUED_RESOURCE)))
        .addMethod(
            getPerformMaintenanceQueuedResourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.tpu.v2alpha1.PerformMaintenanceQueuedResourceRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_PERFORM_MAINTENANCE_QUEUED_RESOURCE)))
        .addMethod(
            getGenerateServiceIdentityMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.tpu.v2alpha1.GenerateServiceIdentityRequest,
                    com.google.cloud.tpu.v2alpha1.GenerateServiceIdentityResponse>(
                    service, METHODID_GENERATE_SERVICE_IDENTITY)))
        .addMethod(
            getListAcceleratorTypesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.tpu.v2alpha1.ListAcceleratorTypesRequest,
                    com.google.cloud.tpu.v2alpha1.ListAcceleratorTypesResponse>(
                    service, METHODID_LIST_ACCELERATOR_TYPES)))
        .addMethod(
            getGetAcceleratorTypeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.tpu.v2alpha1.GetAcceleratorTypeRequest,
                    com.google.cloud.tpu.v2alpha1.AcceleratorType>(
                    service, METHODID_GET_ACCELERATOR_TYPE)))
        .addMethod(
            getListRuntimeVersionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.tpu.v2alpha1.ListRuntimeVersionsRequest,
                    com.google.cloud.tpu.v2alpha1.ListRuntimeVersionsResponse>(
                    service, METHODID_LIST_RUNTIME_VERSIONS)))
        .addMethod(
            getGetRuntimeVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.tpu.v2alpha1.GetRuntimeVersionRequest,
                    com.google.cloud.tpu.v2alpha1.RuntimeVersion>(
                    service, METHODID_GET_RUNTIME_VERSION)))
        .addMethod(
            getGetGuestAttributesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.tpu.v2alpha1.GetGuestAttributesRequest,
                    com.google.cloud.tpu.v2alpha1.GetGuestAttributesResponse>(
                    service, METHODID_GET_GUEST_ATTRIBUTES)))
        .addMethod(
            getListReservationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.tpu.v2alpha1.ListReservationsRequest,
                    com.google.cloud.tpu.v2alpha1.ListReservationsResponse>(
                    service, METHODID_LIST_RESERVATIONS)))
        .addMethod(
            getSimulateMaintenanceEventMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.tpu.v2alpha1.SimulateMaintenanceEventRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_SIMULATE_MAINTENANCE_EVENT)))
        .build();
  }

  private abstract static class TpuBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TpuBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.tpu.v2alpha1.CloudTpuProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Tpu");
    }
  }

  private static final class TpuFileDescriptorSupplier extends TpuBaseDescriptorSupplier {
    TpuFileDescriptorSupplier() {}
  }

  private static final class TpuMethodDescriptorSupplier extends TpuBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    TpuMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (TpuGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new TpuFileDescriptorSupplier())
                      .addMethod(getListNodesMethod())
                      .addMethod(getGetNodeMethod())
                      .addMethod(getCreateNodeMethod())
                      .addMethod(getDeleteNodeMethod())
                      .addMethod(getStopNodeMethod())
                      .addMethod(getStartNodeMethod())
                      .addMethod(getUpdateNodeMethod())
                      .addMethod(getPerformMaintenanceMethod())
                      .addMethod(getListQueuedResourcesMethod())
                      .addMethod(getGetQueuedResourceMethod())
                      .addMethod(getCreateQueuedResourceMethod())
                      .addMethod(getDeleteQueuedResourceMethod())
                      .addMethod(getResetQueuedResourceMethod())
                      .addMethod(getPerformMaintenanceQueuedResourceMethod())
                      .addMethod(getGenerateServiceIdentityMethod())
                      .addMethod(getListAcceleratorTypesMethod())
                      .addMethod(getGetAcceleratorTypeMethod())
                      .addMethod(getListRuntimeVersionsMethod())
                      .addMethod(getGetRuntimeVersionMethod())
                      .addMethod(getGetGuestAttributesMethod())
                      .addMethod(getListReservationsMethod())
                      .addMethod(getSimulateMaintenanceEventMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
