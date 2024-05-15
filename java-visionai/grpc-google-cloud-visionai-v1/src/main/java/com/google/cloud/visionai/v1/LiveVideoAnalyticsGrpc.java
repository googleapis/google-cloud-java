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
package com.google.cloud.visionai.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service describing handlers for resources. The service enables clients to run
 * Live Video Analytics (LVA) on the streaming inputs.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/visionai/v1/lva_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LiveVideoAnalyticsGrpc {

  private LiveVideoAnalyticsGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.visionai.v1.LiveVideoAnalytics";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListPublicOperatorsRequest,
          com.google.cloud.visionai.v1.ListPublicOperatorsResponse>
      getListPublicOperatorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPublicOperators",
      requestType = com.google.cloud.visionai.v1.ListPublicOperatorsRequest.class,
      responseType = com.google.cloud.visionai.v1.ListPublicOperatorsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListPublicOperatorsRequest,
          com.google.cloud.visionai.v1.ListPublicOperatorsResponse>
      getListPublicOperatorsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.ListPublicOperatorsRequest,
            com.google.cloud.visionai.v1.ListPublicOperatorsResponse>
        getListPublicOperatorsMethod;
    if ((getListPublicOperatorsMethod = LiveVideoAnalyticsGrpc.getListPublicOperatorsMethod)
        == null) {
      synchronized (LiveVideoAnalyticsGrpc.class) {
        if ((getListPublicOperatorsMethod = LiveVideoAnalyticsGrpc.getListPublicOperatorsMethod)
            == null) {
          LiveVideoAnalyticsGrpc.getListPublicOperatorsMethod =
              getListPublicOperatorsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.ListPublicOperatorsRequest,
                          com.google.cloud.visionai.v1.ListPublicOperatorsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListPublicOperators"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListPublicOperatorsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListPublicOperatorsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LiveVideoAnalyticsMethodDescriptorSupplier("ListPublicOperators"))
                      .build();
        }
      }
    }
    return getListPublicOperatorsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ResolveOperatorInfoRequest,
          com.google.cloud.visionai.v1.ResolveOperatorInfoResponse>
      getResolveOperatorInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResolveOperatorInfo",
      requestType = com.google.cloud.visionai.v1.ResolveOperatorInfoRequest.class,
      responseType = com.google.cloud.visionai.v1.ResolveOperatorInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ResolveOperatorInfoRequest,
          com.google.cloud.visionai.v1.ResolveOperatorInfoResponse>
      getResolveOperatorInfoMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.ResolveOperatorInfoRequest,
            com.google.cloud.visionai.v1.ResolveOperatorInfoResponse>
        getResolveOperatorInfoMethod;
    if ((getResolveOperatorInfoMethod = LiveVideoAnalyticsGrpc.getResolveOperatorInfoMethod)
        == null) {
      synchronized (LiveVideoAnalyticsGrpc.class) {
        if ((getResolveOperatorInfoMethod = LiveVideoAnalyticsGrpc.getResolveOperatorInfoMethod)
            == null) {
          LiveVideoAnalyticsGrpc.getResolveOperatorInfoMethod =
              getResolveOperatorInfoMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.ResolveOperatorInfoRequest,
                          com.google.cloud.visionai.v1.ResolveOperatorInfoResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ResolveOperatorInfo"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ResolveOperatorInfoRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ResolveOperatorInfoResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LiveVideoAnalyticsMethodDescriptorSupplier("ResolveOperatorInfo"))
                      .build();
        }
      }
    }
    return getResolveOperatorInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListOperatorsRequest,
          com.google.cloud.visionai.v1.ListOperatorsResponse>
      getListOperatorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListOperators",
      requestType = com.google.cloud.visionai.v1.ListOperatorsRequest.class,
      responseType = com.google.cloud.visionai.v1.ListOperatorsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListOperatorsRequest,
          com.google.cloud.visionai.v1.ListOperatorsResponse>
      getListOperatorsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.ListOperatorsRequest,
            com.google.cloud.visionai.v1.ListOperatorsResponse>
        getListOperatorsMethod;
    if ((getListOperatorsMethod = LiveVideoAnalyticsGrpc.getListOperatorsMethod) == null) {
      synchronized (LiveVideoAnalyticsGrpc.class) {
        if ((getListOperatorsMethod = LiveVideoAnalyticsGrpc.getListOperatorsMethod) == null) {
          LiveVideoAnalyticsGrpc.getListOperatorsMethod =
              getListOperatorsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.ListOperatorsRequest,
                          com.google.cloud.visionai.v1.ListOperatorsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListOperators"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListOperatorsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListOperatorsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LiveVideoAnalyticsMethodDescriptorSupplier("ListOperators"))
                      .build();
        }
      }
    }
    return getListOperatorsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetOperatorRequest, com.google.cloud.visionai.v1.Operator>
      getGetOperatorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOperator",
      requestType = com.google.cloud.visionai.v1.GetOperatorRequest.class,
      responseType = com.google.cloud.visionai.v1.Operator.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetOperatorRequest, com.google.cloud.visionai.v1.Operator>
      getGetOperatorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.GetOperatorRequest, com.google.cloud.visionai.v1.Operator>
        getGetOperatorMethod;
    if ((getGetOperatorMethod = LiveVideoAnalyticsGrpc.getGetOperatorMethod) == null) {
      synchronized (LiveVideoAnalyticsGrpc.class) {
        if ((getGetOperatorMethod = LiveVideoAnalyticsGrpc.getGetOperatorMethod) == null) {
          LiveVideoAnalyticsGrpc.getGetOperatorMethod =
              getGetOperatorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.GetOperatorRequest,
                          com.google.cloud.visionai.v1.Operator>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetOperator"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.GetOperatorRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.Operator.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LiveVideoAnalyticsMethodDescriptorSupplier("GetOperator"))
                      .build();
        }
      }
    }
    return getGetOperatorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateOperatorRequest, com.google.longrunning.Operation>
      getCreateOperatorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateOperator",
      requestType = com.google.cloud.visionai.v1.CreateOperatorRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateOperatorRequest, com.google.longrunning.Operation>
      getCreateOperatorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.CreateOperatorRequest, com.google.longrunning.Operation>
        getCreateOperatorMethod;
    if ((getCreateOperatorMethod = LiveVideoAnalyticsGrpc.getCreateOperatorMethod) == null) {
      synchronized (LiveVideoAnalyticsGrpc.class) {
        if ((getCreateOperatorMethod = LiveVideoAnalyticsGrpc.getCreateOperatorMethod) == null) {
          LiveVideoAnalyticsGrpc.getCreateOperatorMethod =
              getCreateOperatorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.CreateOperatorRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateOperator"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.CreateOperatorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LiveVideoAnalyticsMethodDescriptorSupplier("CreateOperator"))
                      .build();
        }
      }
    }
    return getCreateOperatorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateOperatorRequest, com.google.longrunning.Operation>
      getUpdateOperatorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateOperator",
      requestType = com.google.cloud.visionai.v1.UpdateOperatorRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateOperatorRequest, com.google.longrunning.Operation>
      getUpdateOperatorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.UpdateOperatorRequest, com.google.longrunning.Operation>
        getUpdateOperatorMethod;
    if ((getUpdateOperatorMethod = LiveVideoAnalyticsGrpc.getUpdateOperatorMethod) == null) {
      synchronized (LiveVideoAnalyticsGrpc.class) {
        if ((getUpdateOperatorMethod = LiveVideoAnalyticsGrpc.getUpdateOperatorMethod) == null) {
          LiveVideoAnalyticsGrpc.getUpdateOperatorMethod =
              getUpdateOperatorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.UpdateOperatorRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateOperator"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.UpdateOperatorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LiveVideoAnalyticsMethodDescriptorSupplier("UpdateOperator"))
                      .build();
        }
      }
    }
    return getUpdateOperatorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteOperatorRequest, com.google.longrunning.Operation>
      getDeleteOperatorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteOperator",
      requestType = com.google.cloud.visionai.v1.DeleteOperatorRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteOperatorRequest, com.google.longrunning.Operation>
      getDeleteOperatorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.DeleteOperatorRequest, com.google.longrunning.Operation>
        getDeleteOperatorMethod;
    if ((getDeleteOperatorMethod = LiveVideoAnalyticsGrpc.getDeleteOperatorMethod) == null) {
      synchronized (LiveVideoAnalyticsGrpc.class) {
        if ((getDeleteOperatorMethod = LiveVideoAnalyticsGrpc.getDeleteOperatorMethod) == null) {
          LiveVideoAnalyticsGrpc.getDeleteOperatorMethod =
              getDeleteOperatorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.DeleteOperatorRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteOperator"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.DeleteOperatorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LiveVideoAnalyticsMethodDescriptorSupplier("DeleteOperator"))
                      .build();
        }
      }
    }
    return getDeleteOperatorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListAnalysesRequest,
          com.google.cloud.visionai.v1.ListAnalysesResponse>
      getListAnalysesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAnalyses",
      requestType = com.google.cloud.visionai.v1.ListAnalysesRequest.class,
      responseType = com.google.cloud.visionai.v1.ListAnalysesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListAnalysesRequest,
          com.google.cloud.visionai.v1.ListAnalysesResponse>
      getListAnalysesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.ListAnalysesRequest,
            com.google.cloud.visionai.v1.ListAnalysesResponse>
        getListAnalysesMethod;
    if ((getListAnalysesMethod = LiveVideoAnalyticsGrpc.getListAnalysesMethod) == null) {
      synchronized (LiveVideoAnalyticsGrpc.class) {
        if ((getListAnalysesMethod = LiveVideoAnalyticsGrpc.getListAnalysesMethod) == null) {
          LiveVideoAnalyticsGrpc.getListAnalysesMethod =
              getListAnalysesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.ListAnalysesRequest,
                          com.google.cloud.visionai.v1.ListAnalysesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAnalyses"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListAnalysesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListAnalysesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LiveVideoAnalyticsMethodDescriptorSupplier("ListAnalyses"))
                      .build();
        }
      }
    }
    return getListAnalysesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetAnalysisRequest, com.google.cloud.visionai.v1.Analysis>
      getGetAnalysisMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAnalysis",
      requestType = com.google.cloud.visionai.v1.GetAnalysisRequest.class,
      responseType = com.google.cloud.visionai.v1.Analysis.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetAnalysisRequest, com.google.cloud.visionai.v1.Analysis>
      getGetAnalysisMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.GetAnalysisRequest, com.google.cloud.visionai.v1.Analysis>
        getGetAnalysisMethod;
    if ((getGetAnalysisMethod = LiveVideoAnalyticsGrpc.getGetAnalysisMethod) == null) {
      synchronized (LiveVideoAnalyticsGrpc.class) {
        if ((getGetAnalysisMethod = LiveVideoAnalyticsGrpc.getGetAnalysisMethod) == null) {
          LiveVideoAnalyticsGrpc.getGetAnalysisMethod =
              getGetAnalysisMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.GetAnalysisRequest,
                          com.google.cloud.visionai.v1.Analysis>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAnalysis"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.GetAnalysisRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.Analysis.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LiveVideoAnalyticsMethodDescriptorSupplier("GetAnalysis"))
                      .build();
        }
      }
    }
    return getGetAnalysisMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateAnalysisRequest, com.google.longrunning.Operation>
      getCreateAnalysisMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAnalysis",
      requestType = com.google.cloud.visionai.v1.CreateAnalysisRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateAnalysisRequest, com.google.longrunning.Operation>
      getCreateAnalysisMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.CreateAnalysisRequest, com.google.longrunning.Operation>
        getCreateAnalysisMethod;
    if ((getCreateAnalysisMethod = LiveVideoAnalyticsGrpc.getCreateAnalysisMethod) == null) {
      synchronized (LiveVideoAnalyticsGrpc.class) {
        if ((getCreateAnalysisMethod = LiveVideoAnalyticsGrpc.getCreateAnalysisMethod) == null) {
          LiveVideoAnalyticsGrpc.getCreateAnalysisMethod =
              getCreateAnalysisMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.CreateAnalysisRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAnalysis"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.CreateAnalysisRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LiveVideoAnalyticsMethodDescriptorSupplier("CreateAnalysis"))
                      .build();
        }
      }
    }
    return getCreateAnalysisMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateAnalysisRequest, com.google.longrunning.Operation>
      getUpdateAnalysisMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAnalysis",
      requestType = com.google.cloud.visionai.v1.UpdateAnalysisRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateAnalysisRequest, com.google.longrunning.Operation>
      getUpdateAnalysisMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.UpdateAnalysisRequest, com.google.longrunning.Operation>
        getUpdateAnalysisMethod;
    if ((getUpdateAnalysisMethod = LiveVideoAnalyticsGrpc.getUpdateAnalysisMethod) == null) {
      synchronized (LiveVideoAnalyticsGrpc.class) {
        if ((getUpdateAnalysisMethod = LiveVideoAnalyticsGrpc.getUpdateAnalysisMethod) == null) {
          LiveVideoAnalyticsGrpc.getUpdateAnalysisMethod =
              getUpdateAnalysisMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.UpdateAnalysisRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAnalysis"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.UpdateAnalysisRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LiveVideoAnalyticsMethodDescriptorSupplier("UpdateAnalysis"))
                      .build();
        }
      }
    }
    return getUpdateAnalysisMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteAnalysisRequest, com.google.longrunning.Operation>
      getDeleteAnalysisMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAnalysis",
      requestType = com.google.cloud.visionai.v1.DeleteAnalysisRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteAnalysisRequest, com.google.longrunning.Operation>
      getDeleteAnalysisMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.DeleteAnalysisRequest, com.google.longrunning.Operation>
        getDeleteAnalysisMethod;
    if ((getDeleteAnalysisMethod = LiveVideoAnalyticsGrpc.getDeleteAnalysisMethod) == null) {
      synchronized (LiveVideoAnalyticsGrpc.class) {
        if ((getDeleteAnalysisMethod = LiveVideoAnalyticsGrpc.getDeleteAnalysisMethod) == null) {
          LiveVideoAnalyticsGrpc.getDeleteAnalysisMethod =
              getDeleteAnalysisMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.DeleteAnalysisRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAnalysis"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.DeleteAnalysisRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LiveVideoAnalyticsMethodDescriptorSupplier("DeleteAnalysis"))
                      .build();
        }
      }
    }
    return getDeleteAnalysisMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListProcessesRequest,
          com.google.cloud.visionai.v1.ListProcessesResponse>
      getListProcessesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListProcesses",
      requestType = com.google.cloud.visionai.v1.ListProcessesRequest.class,
      responseType = com.google.cloud.visionai.v1.ListProcessesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListProcessesRequest,
          com.google.cloud.visionai.v1.ListProcessesResponse>
      getListProcessesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.ListProcessesRequest,
            com.google.cloud.visionai.v1.ListProcessesResponse>
        getListProcessesMethod;
    if ((getListProcessesMethod = LiveVideoAnalyticsGrpc.getListProcessesMethod) == null) {
      synchronized (LiveVideoAnalyticsGrpc.class) {
        if ((getListProcessesMethod = LiveVideoAnalyticsGrpc.getListProcessesMethod) == null) {
          LiveVideoAnalyticsGrpc.getListProcessesMethod =
              getListProcessesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.ListProcessesRequest,
                          com.google.cloud.visionai.v1.ListProcessesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListProcesses"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListProcessesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListProcessesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LiveVideoAnalyticsMethodDescriptorSupplier("ListProcesses"))
                      .build();
        }
      }
    }
    return getListProcessesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetProcessRequest, com.google.cloud.visionai.v1.Process>
      getGetProcessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProcess",
      requestType = com.google.cloud.visionai.v1.GetProcessRequest.class,
      responseType = com.google.cloud.visionai.v1.Process.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetProcessRequest, com.google.cloud.visionai.v1.Process>
      getGetProcessMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.GetProcessRequest, com.google.cloud.visionai.v1.Process>
        getGetProcessMethod;
    if ((getGetProcessMethod = LiveVideoAnalyticsGrpc.getGetProcessMethod) == null) {
      synchronized (LiveVideoAnalyticsGrpc.class) {
        if ((getGetProcessMethod = LiveVideoAnalyticsGrpc.getGetProcessMethod) == null) {
          LiveVideoAnalyticsGrpc.getGetProcessMethod =
              getGetProcessMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.GetProcessRequest,
                          com.google.cloud.visionai.v1.Process>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProcess"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.GetProcessRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.Process.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LiveVideoAnalyticsMethodDescriptorSupplier("GetProcess"))
                      .build();
        }
      }
    }
    return getGetProcessMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateProcessRequest, com.google.longrunning.Operation>
      getCreateProcessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateProcess",
      requestType = com.google.cloud.visionai.v1.CreateProcessRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateProcessRequest, com.google.longrunning.Operation>
      getCreateProcessMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.CreateProcessRequest, com.google.longrunning.Operation>
        getCreateProcessMethod;
    if ((getCreateProcessMethod = LiveVideoAnalyticsGrpc.getCreateProcessMethod) == null) {
      synchronized (LiveVideoAnalyticsGrpc.class) {
        if ((getCreateProcessMethod = LiveVideoAnalyticsGrpc.getCreateProcessMethod) == null) {
          LiveVideoAnalyticsGrpc.getCreateProcessMethod =
              getCreateProcessMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.CreateProcessRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateProcess"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.CreateProcessRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LiveVideoAnalyticsMethodDescriptorSupplier("CreateProcess"))
                      .build();
        }
      }
    }
    return getCreateProcessMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateProcessRequest, com.google.longrunning.Operation>
      getUpdateProcessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateProcess",
      requestType = com.google.cloud.visionai.v1.UpdateProcessRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateProcessRequest, com.google.longrunning.Operation>
      getUpdateProcessMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.UpdateProcessRequest, com.google.longrunning.Operation>
        getUpdateProcessMethod;
    if ((getUpdateProcessMethod = LiveVideoAnalyticsGrpc.getUpdateProcessMethod) == null) {
      synchronized (LiveVideoAnalyticsGrpc.class) {
        if ((getUpdateProcessMethod = LiveVideoAnalyticsGrpc.getUpdateProcessMethod) == null) {
          LiveVideoAnalyticsGrpc.getUpdateProcessMethod =
              getUpdateProcessMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.UpdateProcessRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateProcess"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.UpdateProcessRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LiveVideoAnalyticsMethodDescriptorSupplier("UpdateProcess"))
                      .build();
        }
      }
    }
    return getUpdateProcessMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteProcessRequest, com.google.longrunning.Operation>
      getDeleteProcessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteProcess",
      requestType = com.google.cloud.visionai.v1.DeleteProcessRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteProcessRequest, com.google.longrunning.Operation>
      getDeleteProcessMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.DeleteProcessRequest, com.google.longrunning.Operation>
        getDeleteProcessMethod;
    if ((getDeleteProcessMethod = LiveVideoAnalyticsGrpc.getDeleteProcessMethod) == null) {
      synchronized (LiveVideoAnalyticsGrpc.class) {
        if ((getDeleteProcessMethod = LiveVideoAnalyticsGrpc.getDeleteProcessMethod) == null) {
          LiveVideoAnalyticsGrpc.getDeleteProcessMethod =
              getDeleteProcessMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.DeleteProcessRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteProcess"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.DeleteProcessRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LiveVideoAnalyticsMethodDescriptorSupplier("DeleteProcess"))
                      .build();
        }
      }
    }
    return getDeleteProcessMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.BatchRunProcessRequest, com.google.longrunning.Operation>
      getBatchRunProcessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchRunProcess",
      requestType = com.google.cloud.visionai.v1.BatchRunProcessRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.BatchRunProcessRequest, com.google.longrunning.Operation>
      getBatchRunProcessMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.BatchRunProcessRequest, com.google.longrunning.Operation>
        getBatchRunProcessMethod;
    if ((getBatchRunProcessMethod = LiveVideoAnalyticsGrpc.getBatchRunProcessMethod) == null) {
      synchronized (LiveVideoAnalyticsGrpc.class) {
        if ((getBatchRunProcessMethod = LiveVideoAnalyticsGrpc.getBatchRunProcessMethod) == null) {
          LiveVideoAnalyticsGrpc.getBatchRunProcessMethod =
              getBatchRunProcessMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.BatchRunProcessRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchRunProcess"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.BatchRunProcessRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LiveVideoAnalyticsMethodDescriptorSupplier("BatchRunProcess"))
                      .build();
        }
      }
    }
    return getBatchRunProcessMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static LiveVideoAnalyticsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LiveVideoAnalyticsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LiveVideoAnalyticsStub>() {
          @java.lang.Override
          public LiveVideoAnalyticsStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LiveVideoAnalyticsStub(channel, callOptions);
          }
        };
    return LiveVideoAnalyticsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LiveVideoAnalyticsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LiveVideoAnalyticsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LiveVideoAnalyticsBlockingStub>() {
          @java.lang.Override
          public LiveVideoAnalyticsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LiveVideoAnalyticsBlockingStub(channel, callOptions);
          }
        };
    return LiveVideoAnalyticsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static LiveVideoAnalyticsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LiveVideoAnalyticsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LiveVideoAnalyticsFutureStub>() {
          @java.lang.Override
          public LiveVideoAnalyticsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LiveVideoAnalyticsFutureStub(channel, callOptions);
          }
        };
    return LiveVideoAnalyticsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service describing handlers for resources. The service enables clients to run
   * Live Video Analytics (LVA) on the streaming inputs.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * ListPublicOperators returns all the operators in public registry.
     * </pre>
     */
    default void listPublicOperators(
        com.google.cloud.visionai.v1.ListPublicOperatorsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListPublicOperatorsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPublicOperatorsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * ResolveOperatorInfo returns the operator information based on the request.
     * </pre>
     */
    default void resolveOperatorInfo(
        com.google.cloud.visionai.v1.ResolveOperatorInfoRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ResolveOperatorInfoResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getResolveOperatorInfoMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Operators in a given project and location.
     * </pre>
     */
    default void listOperators(
        com.google.cloud.visionai.v1.ListOperatorsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListOperatorsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListOperatorsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Operator.
     * </pre>
     */
    default void getOperator(
        com.google.cloud.visionai.v1.GetOperatorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Operator> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetOperatorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Operator in a given project and location.
     * </pre>
     */
    default void createOperator(
        com.google.cloud.visionai.v1.CreateOperatorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateOperatorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Operator.
     * </pre>
     */
    default void updateOperator(
        com.google.cloud.visionai.v1.UpdateOperatorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateOperatorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Operator.
     * </pre>
     */
    default void deleteOperator(
        com.google.cloud.visionai.v1.DeleteOperatorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteOperatorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Analyses in a given project and location.
     * </pre>
     */
    default void listAnalyses(
        com.google.cloud.visionai.v1.ListAnalysesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListAnalysesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAnalysesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Analysis.
     * </pre>
     */
    default void getAnalysis(
        com.google.cloud.visionai.v1.GetAnalysisRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Analysis> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAnalysisMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Analysis in a given project and location.
     * </pre>
     */
    default void createAnalysis(
        com.google.cloud.visionai.v1.CreateAnalysisRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAnalysisMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Analysis.
     * </pre>
     */
    default void updateAnalysis(
        com.google.cloud.visionai.v1.UpdateAnalysisRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAnalysisMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Analysis.
     * </pre>
     */
    default void deleteAnalysis(
        com.google.cloud.visionai.v1.DeleteAnalysisRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAnalysisMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Processes in a given project and location.
     * </pre>
     */
    default void listProcesses(
        com.google.cloud.visionai.v1.ListProcessesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListProcessesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListProcessesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Process.
     * </pre>
     */
    default void getProcess(
        com.google.cloud.visionai.v1.GetProcessRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Process> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetProcessMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Process in a given project and location.
     * </pre>
     */
    default void createProcess(
        com.google.cloud.visionai.v1.CreateProcessRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateProcessMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Process.
     * </pre>
     */
    default void updateProcess(
        com.google.cloud.visionai.v1.UpdateProcessRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateProcessMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Process.
     * </pre>
     */
    default void deleteProcess(
        com.google.cloud.visionai.v1.DeleteProcessRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteProcessMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Run all of the processes to "completion". Max time for each process is
     * the LRO time limit.
     * </pre>
     */
    default void batchRunProcess(
        com.google.cloud.visionai.v1.BatchRunProcessRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchRunProcessMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service LiveVideoAnalytics.
   *
   * <pre>
   * Service describing handlers for resources. The service enables clients to run
   * Live Video Analytics (LVA) on the streaming inputs.
   * </pre>
   */
  public abstract static class LiveVideoAnalyticsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return LiveVideoAnalyticsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service LiveVideoAnalytics.
   *
   * <pre>
   * Service describing handlers for resources. The service enables clients to run
   * Live Video Analytics (LVA) on the streaming inputs.
   * </pre>
   */
  public static final class LiveVideoAnalyticsStub
      extends io.grpc.stub.AbstractAsyncStub<LiveVideoAnalyticsStub> {
    private LiveVideoAnalyticsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LiveVideoAnalyticsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LiveVideoAnalyticsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * ListPublicOperators returns all the operators in public registry.
     * </pre>
     */
    public void listPublicOperators(
        com.google.cloud.visionai.v1.ListPublicOperatorsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListPublicOperatorsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPublicOperatorsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * ResolveOperatorInfo returns the operator information based on the request.
     * </pre>
     */
    public void resolveOperatorInfo(
        com.google.cloud.visionai.v1.ResolveOperatorInfoRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ResolveOperatorInfoResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResolveOperatorInfoMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Operators in a given project and location.
     * </pre>
     */
    public void listOperators(
        com.google.cloud.visionai.v1.ListOperatorsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListOperatorsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListOperatorsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Operator.
     * </pre>
     */
    public void getOperator(
        com.google.cloud.visionai.v1.GetOperatorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Operator> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOperatorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Operator in a given project and location.
     * </pre>
     */
    public void createOperator(
        com.google.cloud.visionai.v1.CreateOperatorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateOperatorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Operator.
     * </pre>
     */
    public void updateOperator(
        com.google.cloud.visionai.v1.UpdateOperatorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateOperatorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Operator.
     * </pre>
     */
    public void deleteOperator(
        com.google.cloud.visionai.v1.DeleteOperatorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteOperatorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Analyses in a given project and location.
     * </pre>
     */
    public void listAnalyses(
        com.google.cloud.visionai.v1.ListAnalysesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListAnalysesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAnalysesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Analysis.
     * </pre>
     */
    public void getAnalysis(
        com.google.cloud.visionai.v1.GetAnalysisRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Analysis> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAnalysisMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Analysis in a given project and location.
     * </pre>
     */
    public void createAnalysis(
        com.google.cloud.visionai.v1.CreateAnalysisRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAnalysisMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Analysis.
     * </pre>
     */
    public void updateAnalysis(
        com.google.cloud.visionai.v1.UpdateAnalysisRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAnalysisMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Analysis.
     * </pre>
     */
    public void deleteAnalysis(
        com.google.cloud.visionai.v1.DeleteAnalysisRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAnalysisMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Processes in a given project and location.
     * </pre>
     */
    public void listProcesses(
        com.google.cloud.visionai.v1.ListProcessesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListProcessesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListProcessesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Process.
     * </pre>
     */
    public void getProcess(
        com.google.cloud.visionai.v1.GetProcessRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Process> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProcessMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Process in a given project and location.
     * </pre>
     */
    public void createProcess(
        com.google.cloud.visionai.v1.CreateProcessRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateProcessMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Process.
     * </pre>
     */
    public void updateProcess(
        com.google.cloud.visionai.v1.UpdateProcessRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateProcessMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Process.
     * </pre>
     */
    public void deleteProcess(
        com.google.cloud.visionai.v1.DeleteProcessRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteProcessMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Run all of the processes to "completion". Max time for each process is
     * the LRO time limit.
     * </pre>
     */
    public void batchRunProcess(
        com.google.cloud.visionai.v1.BatchRunProcessRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchRunProcessMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service LiveVideoAnalytics.
   *
   * <pre>
   * Service describing handlers for resources. The service enables clients to run
   * Live Video Analytics (LVA) on the streaming inputs.
   * </pre>
   */
  public static final class LiveVideoAnalyticsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LiveVideoAnalyticsBlockingStub> {
    private LiveVideoAnalyticsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LiveVideoAnalyticsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LiveVideoAnalyticsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * ListPublicOperators returns all the operators in public registry.
     * </pre>
     */
    public com.google.cloud.visionai.v1.ListPublicOperatorsResponse listPublicOperators(
        com.google.cloud.visionai.v1.ListPublicOperatorsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPublicOperatorsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * ResolveOperatorInfo returns the operator information based on the request.
     * </pre>
     */
    public com.google.cloud.visionai.v1.ResolveOperatorInfoResponse resolveOperatorInfo(
        com.google.cloud.visionai.v1.ResolveOperatorInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResolveOperatorInfoMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Operators in a given project and location.
     * </pre>
     */
    public com.google.cloud.visionai.v1.ListOperatorsResponse listOperators(
        com.google.cloud.visionai.v1.ListOperatorsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListOperatorsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Operator.
     * </pre>
     */
    public com.google.cloud.visionai.v1.Operator getOperator(
        com.google.cloud.visionai.v1.GetOperatorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOperatorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Operator in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createOperator(
        com.google.cloud.visionai.v1.CreateOperatorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateOperatorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Operator.
     * </pre>
     */
    public com.google.longrunning.Operation updateOperator(
        com.google.cloud.visionai.v1.UpdateOperatorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateOperatorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Operator.
     * </pre>
     */
    public com.google.longrunning.Operation deleteOperator(
        com.google.cloud.visionai.v1.DeleteOperatorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteOperatorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Analyses in a given project and location.
     * </pre>
     */
    public com.google.cloud.visionai.v1.ListAnalysesResponse listAnalyses(
        com.google.cloud.visionai.v1.ListAnalysesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAnalysesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Analysis.
     * </pre>
     */
    public com.google.cloud.visionai.v1.Analysis getAnalysis(
        com.google.cloud.visionai.v1.GetAnalysisRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAnalysisMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Analysis in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createAnalysis(
        com.google.cloud.visionai.v1.CreateAnalysisRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAnalysisMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Analysis.
     * </pre>
     */
    public com.google.longrunning.Operation updateAnalysis(
        com.google.cloud.visionai.v1.UpdateAnalysisRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAnalysisMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Analysis.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAnalysis(
        com.google.cloud.visionai.v1.DeleteAnalysisRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAnalysisMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Processes in a given project and location.
     * </pre>
     */
    public com.google.cloud.visionai.v1.ListProcessesResponse listProcesses(
        com.google.cloud.visionai.v1.ListProcessesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListProcessesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Process.
     * </pre>
     */
    public com.google.cloud.visionai.v1.Process getProcess(
        com.google.cloud.visionai.v1.GetProcessRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProcessMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Process in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createProcess(
        com.google.cloud.visionai.v1.CreateProcessRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateProcessMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Process.
     * </pre>
     */
    public com.google.longrunning.Operation updateProcess(
        com.google.cloud.visionai.v1.UpdateProcessRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateProcessMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Process.
     * </pre>
     */
    public com.google.longrunning.Operation deleteProcess(
        com.google.cloud.visionai.v1.DeleteProcessRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteProcessMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Run all of the processes to "completion". Max time for each process is
     * the LRO time limit.
     * </pre>
     */
    public com.google.longrunning.Operation batchRunProcess(
        com.google.cloud.visionai.v1.BatchRunProcessRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchRunProcessMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service LiveVideoAnalytics.
   *
   * <pre>
   * Service describing handlers for resources. The service enables clients to run
   * Live Video Analytics (LVA) on the streaming inputs.
   * </pre>
   */
  public static final class LiveVideoAnalyticsFutureStub
      extends io.grpc.stub.AbstractFutureStub<LiveVideoAnalyticsFutureStub> {
    private LiveVideoAnalyticsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LiveVideoAnalyticsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LiveVideoAnalyticsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * ListPublicOperators returns all the operators in public registry.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.ListPublicOperatorsResponse>
        listPublicOperators(com.google.cloud.visionai.v1.ListPublicOperatorsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPublicOperatorsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * ResolveOperatorInfo returns the operator information based on the request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.ResolveOperatorInfoResponse>
        resolveOperatorInfo(com.google.cloud.visionai.v1.ResolveOperatorInfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResolveOperatorInfoMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Operators in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.ListOperatorsResponse>
        listOperators(com.google.cloud.visionai.v1.ListOperatorsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListOperatorsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Operator.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.visionai.v1.Operator>
        getOperator(com.google.cloud.visionai.v1.GetOperatorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOperatorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Operator in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createOperator(com.google.cloud.visionai.v1.CreateOperatorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateOperatorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Operator.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateOperator(com.google.cloud.visionai.v1.UpdateOperatorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateOperatorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Operator.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteOperator(com.google.cloud.visionai.v1.DeleteOperatorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteOperatorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Analyses in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.ListAnalysesResponse>
        listAnalyses(com.google.cloud.visionai.v1.ListAnalysesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAnalysesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Analysis.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.visionai.v1.Analysis>
        getAnalysis(com.google.cloud.visionai.v1.GetAnalysisRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAnalysisMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Analysis in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createAnalysis(com.google.cloud.visionai.v1.CreateAnalysisRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAnalysisMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Analysis.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateAnalysis(com.google.cloud.visionai.v1.UpdateAnalysisRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAnalysisMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Analysis.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteAnalysis(com.google.cloud.visionai.v1.DeleteAnalysisRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAnalysisMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Processes in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.ListProcessesResponse>
        listProcesses(com.google.cloud.visionai.v1.ListProcessesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListProcessesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Process.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.visionai.v1.Process>
        getProcess(com.google.cloud.visionai.v1.GetProcessRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProcessMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Process in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createProcess(com.google.cloud.visionai.v1.CreateProcessRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateProcessMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Process.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateProcess(com.google.cloud.visionai.v1.UpdateProcessRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateProcessMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Process.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteProcess(com.google.cloud.visionai.v1.DeleteProcessRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteProcessMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Run all of the processes to "completion". Max time for each process is
     * the LRO time limit.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchRunProcess(com.google.cloud.visionai.v1.BatchRunProcessRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchRunProcessMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_PUBLIC_OPERATORS = 0;
  private static final int METHODID_RESOLVE_OPERATOR_INFO = 1;
  private static final int METHODID_LIST_OPERATORS = 2;
  private static final int METHODID_GET_OPERATOR = 3;
  private static final int METHODID_CREATE_OPERATOR = 4;
  private static final int METHODID_UPDATE_OPERATOR = 5;
  private static final int METHODID_DELETE_OPERATOR = 6;
  private static final int METHODID_LIST_ANALYSES = 7;
  private static final int METHODID_GET_ANALYSIS = 8;
  private static final int METHODID_CREATE_ANALYSIS = 9;
  private static final int METHODID_UPDATE_ANALYSIS = 10;
  private static final int METHODID_DELETE_ANALYSIS = 11;
  private static final int METHODID_LIST_PROCESSES = 12;
  private static final int METHODID_GET_PROCESS = 13;
  private static final int METHODID_CREATE_PROCESS = 14;
  private static final int METHODID_UPDATE_PROCESS = 15;
  private static final int METHODID_DELETE_PROCESS = 16;
  private static final int METHODID_BATCH_RUN_PROCESS = 17;

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
        case METHODID_LIST_PUBLIC_OPERATORS:
          serviceImpl.listPublicOperators(
              (com.google.cloud.visionai.v1.ListPublicOperatorsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.visionai.v1.ListPublicOperatorsResponse>)
                  responseObserver);
          break;
        case METHODID_RESOLVE_OPERATOR_INFO:
          serviceImpl.resolveOperatorInfo(
              (com.google.cloud.visionai.v1.ResolveOperatorInfoRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.visionai.v1.ResolveOperatorInfoResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_OPERATORS:
          serviceImpl.listOperators(
              (com.google.cloud.visionai.v1.ListOperatorsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListOperatorsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_OPERATOR:
          serviceImpl.getOperator(
              (com.google.cloud.visionai.v1.GetOperatorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Operator>)
                  responseObserver);
          break;
        case METHODID_CREATE_OPERATOR:
          serviceImpl.createOperator(
              (com.google.cloud.visionai.v1.CreateOperatorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_OPERATOR:
          serviceImpl.updateOperator(
              (com.google.cloud.visionai.v1.UpdateOperatorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_OPERATOR:
          serviceImpl.deleteOperator(
              (com.google.cloud.visionai.v1.DeleteOperatorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_ANALYSES:
          serviceImpl.listAnalyses(
              (com.google.cloud.visionai.v1.ListAnalysesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListAnalysesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ANALYSIS:
          serviceImpl.getAnalysis(
              (com.google.cloud.visionai.v1.GetAnalysisRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Analysis>)
                  responseObserver);
          break;
        case METHODID_CREATE_ANALYSIS:
          serviceImpl.createAnalysis(
              (com.google.cloud.visionai.v1.CreateAnalysisRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_ANALYSIS:
          serviceImpl.updateAnalysis(
              (com.google.cloud.visionai.v1.UpdateAnalysisRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ANALYSIS:
          serviceImpl.deleteAnalysis(
              (com.google.cloud.visionai.v1.DeleteAnalysisRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_PROCESSES:
          serviceImpl.listProcesses(
              (com.google.cloud.visionai.v1.ListProcessesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListProcessesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PROCESS:
          serviceImpl.getProcess(
              (com.google.cloud.visionai.v1.GetProcessRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Process>) responseObserver);
          break;
        case METHODID_CREATE_PROCESS:
          serviceImpl.createProcess(
              (com.google.cloud.visionai.v1.CreateProcessRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_PROCESS:
          serviceImpl.updateProcess(
              (com.google.cloud.visionai.v1.UpdateProcessRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_PROCESS:
          serviceImpl.deleteProcess(
              (com.google.cloud.visionai.v1.DeleteProcessRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_BATCH_RUN_PROCESS:
          serviceImpl.batchRunProcess(
              (com.google.cloud.visionai.v1.BatchRunProcessRequest) request,
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
            getListPublicOperatorsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.ListPublicOperatorsRequest,
                    com.google.cloud.visionai.v1.ListPublicOperatorsResponse>(
                    service, METHODID_LIST_PUBLIC_OPERATORS)))
        .addMethod(
            getResolveOperatorInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.ResolveOperatorInfoRequest,
                    com.google.cloud.visionai.v1.ResolveOperatorInfoResponse>(
                    service, METHODID_RESOLVE_OPERATOR_INFO)))
        .addMethod(
            getListOperatorsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.ListOperatorsRequest,
                    com.google.cloud.visionai.v1.ListOperatorsResponse>(
                    service, METHODID_LIST_OPERATORS)))
        .addMethod(
            getGetOperatorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.GetOperatorRequest,
                    com.google.cloud.visionai.v1.Operator>(service, METHODID_GET_OPERATOR)))
        .addMethod(
            getCreateOperatorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.CreateOperatorRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_OPERATOR)))
        .addMethod(
            getUpdateOperatorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.UpdateOperatorRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_OPERATOR)))
        .addMethod(
            getDeleteOperatorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.DeleteOperatorRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_OPERATOR)))
        .addMethod(
            getListAnalysesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.ListAnalysesRequest,
                    com.google.cloud.visionai.v1.ListAnalysesResponse>(
                    service, METHODID_LIST_ANALYSES)))
        .addMethod(
            getGetAnalysisMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.GetAnalysisRequest,
                    com.google.cloud.visionai.v1.Analysis>(service, METHODID_GET_ANALYSIS)))
        .addMethod(
            getCreateAnalysisMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.CreateAnalysisRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_ANALYSIS)))
        .addMethod(
            getUpdateAnalysisMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.UpdateAnalysisRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_ANALYSIS)))
        .addMethod(
            getDeleteAnalysisMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.DeleteAnalysisRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_ANALYSIS)))
        .addMethod(
            getListProcessesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.ListProcessesRequest,
                    com.google.cloud.visionai.v1.ListProcessesResponse>(
                    service, METHODID_LIST_PROCESSES)))
        .addMethod(
            getGetProcessMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.GetProcessRequest,
                    com.google.cloud.visionai.v1.Process>(service, METHODID_GET_PROCESS)))
        .addMethod(
            getCreateProcessMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.CreateProcessRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_PROCESS)))
        .addMethod(
            getUpdateProcessMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.UpdateProcessRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_PROCESS)))
        .addMethod(
            getDeleteProcessMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.DeleteProcessRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_PROCESS)))
        .addMethod(
            getBatchRunProcessMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.BatchRunProcessRequest,
                    com.google.longrunning.Operation>(service, METHODID_BATCH_RUN_PROCESS)))
        .build();
  }

  private abstract static class LiveVideoAnalyticsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LiveVideoAnalyticsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.visionai.v1.LvaServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LiveVideoAnalytics");
    }
  }

  private static final class LiveVideoAnalyticsFileDescriptorSupplier
      extends LiveVideoAnalyticsBaseDescriptorSupplier {
    LiveVideoAnalyticsFileDescriptorSupplier() {}
  }

  private static final class LiveVideoAnalyticsMethodDescriptorSupplier
      extends LiveVideoAnalyticsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    LiveVideoAnalyticsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (LiveVideoAnalyticsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new LiveVideoAnalyticsFileDescriptorSupplier())
                      .addMethod(getListPublicOperatorsMethod())
                      .addMethod(getResolveOperatorInfoMethod())
                      .addMethod(getListOperatorsMethod())
                      .addMethod(getGetOperatorMethod())
                      .addMethod(getCreateOperatorMethod())
                      .addMethod(getUpdateOperatorMethod())
                      .addMethod(getDeleteOperatorMethod())
                      .addMethod(getListAnalysesMethod())
                      .addMethod(getGetAnalysisMethod())
                      .addMethod(getCreateAnalysisMethod())
                      .addMethod(getUpdateAnalysisMethod())
                      .addMethod(getDeleteAnalysisMethod())
                      .addMethod(getListProcessesMethod())
                      .addMethod(getGetProcessMethod())
                      .addMethod(getCreateProcessMethod())
                      .addMethod(getUpdateProcessMethod())
                      .addMethod(getDeleteProcessMethod())
                      .addMethod(getBatchRunProcessMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
