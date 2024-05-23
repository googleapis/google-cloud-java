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
 * Service that manages media content + metadata for streaming.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/visionai/v1/warehouse.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class WarehouseGrpc {

  private WarehouseGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.visionai.v1.Warehouse";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateAssetRequest, com.google.cloud.visionai.v1.Asset>
      getCreateAssetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAsset",
      requestType = com.google.cloud.visionai.v1.CreateAssetRequest.class,
      responseType = com.google.cloud.visionai.v1.Asset.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateAssetRequest, com.google.cloud.visionai.v1.Asset>
      getCreateAssetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.CreateAssetRequest, com.google.cloud.visionai.v1.Asset>
        getCreateAssetMethod;
    if ((getCreateAssetMethod = WarehouseGrpc.getCreateAssetMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getCreateAssetMethod = WarehouseGrpc.getCreateAssetMethod) == null) {
          WarehouseGrpc.getCreateAssetMethod =
              getCreateAssetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.CreateAssetRequest,
                          com.google.cloud.visionai.v1.Asset>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAsset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.CreateAssetRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.Asset.getDefaultInstance()))
                      .setSchemaDescriptor(new WarehouseMethodDescriptorSupplier("CreateAsset"))
                      .build();
        }
      }
    }
    return getCreateAssetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateAssetRequest, com.google.cloud.visionai.v1.Asset>
      getUpdateAssetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAsset",
      requestType = com.google.cloud.visionai.v1.UpdateAssetRequest.class,
      responseType = com.google.cloud.visionai.v1.Asset.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateAssetRequest, com.google.cloud.visionai.v1.Asset>
      getUpdateAssetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.UpdateAssetRequest, com.google.cloud.visionai.v1.Asset>
        getUpdateAssetMethod;
    if ((getUpdateAssetMethod = WarehouseGrpc.getUpdateAssetMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getUpdateAssetMethod = WarehouseGrpc.getUpdateAssetMethod) == null) {
          WarehouseGrpc.getUpdateAssetMethod =
              getUpdateAssetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.UpdateAssetRequest,
                          com.google.cloud.visionai.v1.Asset>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAsset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.UpdateAssetRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.Asset.getDefaultInstance()))
                      .setSchemaDescriptor(new WarehouseMethodDescriptorSupplier("UpdateAsset"))
                      .build();
        }
      }
    }
    return getUpdateAssetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetAssetRequest, com.google.cloud.visionai.v1.Asset>
      getGetAssetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAsset",
      requestType = com.google.cloud.visionai.v1.GetAssetRequest.class,
      responseType = com.google.cloud.visionai.v1.Asset.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetAssetRequest, com.google.cloud.visionai.v1.Asset>
      getGetAssetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.GetAssetRequest, com.google.cloud.visionai.v1.Asset>
        getGetAssetMethod;
    if ((getGetAssetMethod = WarehouseGrpc.getGetAssetMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getGetAssetMethod = WarehouseGrpc.getGetAssetMethod) == null) {
          WarehouseGrpc.getGetAssetMethod =
              getGetAssetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.GetAssetRequest,
                          com.google.cloud.visionai.v1.Asset>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAsset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.GetAssetRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.Asset.getDefaultInstance()))
                      .setSchemaDescriptor(new WarehouseMethodDescriptorSupplier("GetAsset"))
                      .build();
        }
      }
    }
    return getGetAssetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListAssetsRequest,
          com.google.cloud.visionai.v1.ListAssetsResponse>
      getListAssetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAssets",
      requestType = com.google.cloud.visionai.v1.ListAssetsRequest.class,
      responseType = com.google.cloud.visionai.v1.ListAssetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListAssetsRequest,
          com.google.cloud.visionai.v1.ListAssetsResponse>
      getListAssetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.ListAssetsRequest,
            com.google.cloud.visionai.v1.ListAssetsResponse>
        getListAssetsMethod;
    if ((getListAssetsMethod = WarehouseGrpc.getListAssetsMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getListAssetsMethod = WarehouseGrpc.getListAssetsMethod) == null) {
          WarehouseGrpc.getListAssetsMethod =
              getListAssetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.ListAssetsRequest,
                          com.google.cloud.visionai.v1.ListAssetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAssets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListAssetsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListAssetsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new WarehouseMethodDescriptorSupplier("ListAssets"))
                      .build();
        }
      }
    }
    return getListAssetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteAssetRequest, com.google.longrunning.Operation>
      getDeleteAssetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAsset",
      requestType = com.google.cloud.visionai.v1.DeleteAssetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteAssetRequest, com.google.longrunning.Operation>
      getDeleteAssetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.DeleteAssetRequest, com.google.longrunning.Operation>
        getDeleteAssetMethod;
    if ((getDeleteAssetMethod = WarehouseGrpc.getDeleteAssetMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getDeleteAssetMethod = WarehouseGrpc.getDeleteAssetMethod) == null) {
          WarehouseGrpc.getDeleteAssetMethod =
              getDeleteAssetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.DeleteAssetRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAsset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.DeleteAssetRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new WarehouseMethodDescriptorSupplier("DeleteAsset"))
                      .build();
        }
      }
    }
    return getDeleteAssetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UploadAssetRequest, com.google.longrunning.Operation>
      getUploadAssetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UploadAsset",
      requestType = com.google.cloud.visionai.v1.UploadAssetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UploadAssetRequest, com.google.longrunning.Operation>
      getUploadAssetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.UploadAssetRequest, com.google.longrunning.Operation>
        getUploadAssetMethod;
    if ((getUploadAssetMethod = WarehouseGrpc.getUploadAssetMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getUploadAssetMethod = WarehouseGrpc.getUploadAssetMethod) == null) {
          WarehouseGrpc.getUploadAssetMethod =
              getUploadAssetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.UploadAssetRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UploadAsset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.UploadAssetRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new WarehouseMethodDescriptorSupplier("UploadAsset"))
                      .build();
        }
      }
    }
    return getUploadAssetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GenerateRetrievalUrlRequest,
          com.google.cloud.visionai.v1.GenerateRetrievalUrlResponse>
      getGenerateRetrievalUrlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateRetrievalUrl",
      requestType = com.google.cloud.visionai.v1.GenerateRetrievalUrlRequest.class,
      responseType = com.google.cloud.visionai.v1.GenerateRetrievalUrlResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GenerateRetrievalUrlRequest,
          com.google.cloud.visionai.v1.GenerateRetrievalUrlResponse>
      getGenerateRetrievalUrlMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.GenerateRetrievalUrlRequest,
            com.google.cloud.visionai.v1.GenerateRetrievalUrlResponse>
        getGenerateRetrievalUrlMethod;
    if ((getGenerateRetrievalUrlMethod = WarehouseGrpc.getGenerateRetrievalUrlMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getGenerateRetrievalUrlMethod = WarehouseGrpc.getGenerateRetrievalUrlMethod) == null) {
          WarehouseGrpc.getGenerateRetrievalUrlMethod =
              getGenerateRetrievalUrlMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.GenerateRetrievalUrlRequest,
                          com.google.cloud.visionai.v1.GenerateRetrievalUrlResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GenerateRetrievalUrl"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.GenerateRetrievalUrlRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.GenerateRetrievalUrlResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WarehouseMethodDescriptorSupplier("GenerateRetrievalUrl"))
                      .build();
        }
      }
    }
    return getGenerateRetrievalUrlMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.AnalyzeAssetRequest, com.google.longrunning.Operation>
      getAnalyzeAssetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AnalyzeAsset",
      requestType = com.google.cloud.visionai.v1.AnalyzeAssetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.AnalyzeAssetRequest, com.google.longrunning.Operation>
      getAnalyzeAssetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.AnalyzeAssetRequest, com.google.longrunning.Operation>
        getAnalyzeAssetMethod;
    if ((getAnalyzeAssetMethod = WarehouseGrpc.getAnalyzeAssetMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getAnalyzeAssetMethod = WarehouseGrpc.getAnalyzeAssetMethod) == null) {
          WarehouseGrpc.getAnalyzeAssetMethod =
              getAnalyzeAssetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.AnalyzeAssetRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AnalyzeAsset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.AnalyzeAssetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new WarehouseMethodDescriptorSupplier("AnalyzeAsset"))
                      .build();
        }
      }
    }
    return getAnalyzeAssetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.IndexAssetRequest, com.google.longrunning.Operation>
      getIndexAssetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "IndexAsset",
      requestType = com.google.cloud.visionai.v1.IndexAssetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.IndexAssetRequest, com.google.longrunning.Operation>
      getIndexAssetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.IndexAssetRequest, com.google.longrunning.Operation>
        getIndexAssetMethod;
    if ((getIndexAssetMethod = WarehouseGrpc.getIndexAssetMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getIndexAssetMethod = WarehouseGrpc.getIndexAssetMethod) == null) {
          WarehouseGrpc.getIndexAssetMethod =
              getIndexAssetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.IndexAssetRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "IndexAsset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.IndexAssetRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new WarehouseMethodDescriptorSupplier("IndexAsset"))
                      .build();
        }
      }
    }
    return getIndexAssetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.RemoveIndexAssetRequest, com.google.longrunning.Operation>
      getRemoveIndexAssetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveIndexAsset",
      requestType = com.google.cloud.visionai.v1.RemoveIndexAssetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.RemoveIndexAssetRequest, com.google.longrunning.Operation>
      getRemoveIndexAssetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.RemoveIndexAssetRequest, com.google.longrunning.Operation>
        getRemoveIndexAssetMethod;
    if ((getRemoveIndexAssetMethod = WarehouseGrpc.getRemoveIndexAssetMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getRemoveIndexAssetMethod = WarehouseGrpc.getRemoveIndexAssetMethod) == null) {
          WarehouseGrpc.getRemoveIndexAssetMethod =
              getRemoveIndexAssetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.RemoveIndexAssetRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RemoveIndexAsset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.RemoveIndexAssetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WarehouseMethodDescriptorSupplier("RemoveIndexAsset"))
                      .build();
        }
      }
    }
    return getRemoveIndexAssetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ViewIndexedAssetsRequest,
          com.google.cloud.visionai.v1.ViewIndexedAssetsResponse>
      getViewIndexedAssetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ViewIndexedAssets",
      requestType = com.google.cloud.visionai.v1.ViewIndexedAssetsRequest.class,
      responseType = com.google.cloud.visionai.v1.ViewIndexedAssetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ViewIndexedAssetsRequest,
          com.google.cloud.visionai.v1.ViewIndexedAssetsResponse>
      getViewIndexedAssetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.ViewIndexedAssetsRequest,
            com.google.cloud.visionai.v1.ViewIndexedAssetsResponse>
        getViewIndexedAssetsMethod;
    if ((getViewIndexedAssetsMethod = WarehouseGrpc.getViewIndexedAssetsMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getViewIndexedAssetsMethod = WarehouseGrpc.getViewIndexedAssetsMethod) == null) {
          WarehouseGrpc.getViewIndexedAssetsMethod =
              getViewIndexedAssetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.ViewIndexedAssetsRequest,
                          com.google.cloud.visionai.v1.ViewIndexedAssetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ViewIndexedAssets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ViewIndexedAssetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ViewIndexedAssetsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WarehouseMethodDescriptorSupplier("ViewIndexedAssets"))
                      .build();
        }
      }
    }
    return getViewIndexedAssetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateIndexRequest, com.google.longrunning.Operation>
      getCreateIndexMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateIndex",
      requestType = com.google.cloud.visionai.v1.CreateIndexRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateIndexRequest, com.google.longrunning.Operation>
      getCreateIndexMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.CreateIndexRequest, com.google.longrunning.Operation>
        getCreateIndexMethod;
    if ((getCreateIndexMethod = WarehouseGrpc.getCreateIndexMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getCreateIndexMethod = WarehouseGrpc.getCreateIndexMethod) == null) {
          WarehouseGrpc.getCreateIndexMethod =
              getCreateIndexMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.CreateIndexRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateIndex"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.CreateIndexRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new WarehouseMethodDescriptorSupplier("CreateIndex"))
                      .build();
        }
      }
    }
    return getCreateIndexMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateIndexRequest, com.google.longrunning.Operation>
      getUpdateIndexMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateIndex",
      requestType = com.google.cloud.visionai.v1.UpdateIndexRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateIndexRequest, com.google.longrunning.Operation>
      getUpdateIndexMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.UpdateIndexRequest, com.google.longrunning.Operation>
        getUpdateIndexMethod;
    if ((getUpdateIndexMethod = WarehouseGrpc.getUpdateIndexMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getUpdateIndexMethod = WarehouseGrpc.getUpdateIndexMethod) == null) {
          WarehouseGrpc.getUpdateIndexMethod =
              getUpdateIndexMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.UpdateIndexRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateIndex"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.UpdateIndexRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new WarehouseMethodDescriptorSupplier("UpdateIndex"))
                      .build();
        }
      }
    }
    return getUpdateIndexMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetIndexRequest, com.google.cloud.visionai.v1.Index>
      getGetIndexMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIndex",
      requestType = com.google.cloud.visionai.v1.GetIndexRequest.class,
      responseType = com.google.cloud.visionai.v1.Index.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetIndexRequest, com.google.cloud.visionai.v1.Index>
      getGetIndexMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.GetIndexRequest, com.google.cloud.visionai.v1.Index>
        getGetIndexMethod;
    if ((getGetIndexMethod = WarehouseGrpc.getGetIndexMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getGetIndexMethod = WarehouseGrpc.getGetIndexMethod) == null) {
          WarehouseGrpc.getGetIndexMethod =
              getGetIndexMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.GetIndexRequest,
                          com.google.cloud.visionai.v1.Index>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIndex"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.GetIndexRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.Index.getDefaultInstance()))
                      .setSchemaDescriptor(new WarehouseMethodDescriptorSupplier("GetIndex"))
                      .build();
        }
      }
    }
    return getGetIndexMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListIndexesRequest,
          com.google.cloud.visionai.v1.ListIndexesResponse>
      getListIndexesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListIndexes",
      requestType = com.google.cloud.visionai.v1.ListIndexesRequest.class,
      responseType = com.google.cloud.visionai.v1.ListIndexesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListIndexesRequest,
          com.google.cloud.visionai.v1.ListIndexesResponse>
      getListIndexesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.ListIndexesRequest,
            com.google.cloud.visionai.v1.ListIndexesResponse>
        getListIndexesMethod;
    if ((getListIndexesMethod = WarehouseGrpc.getListIndexesMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getListIndexesMethod = WarehouseGrpc.getListIndexesMethod) == null) {
          WarehouseGrpc.getListIndexesMethod =
              getListIndexesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.ListIndexesRequest,
                          com.google.cloud.visionai.v1.ListIndexesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListIndexes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListIndexesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListIndexesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new WarehouseMethodDescriptorSupplier("ListIndexes"))
                      .build();
        }
      }
    }
    return getListIndexesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteIndexRequest, com.google.longrunning.Operation>
      getDeleteIndexMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteIndex",
      requestType = com.google.cloud.visionai.v1.DeleteIndexRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteIndexRequest, com.google.longrunning.Operation>
      getDeleteIndexMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.DeleteIndexRequest, com.google.longrunning.Operation>
        getDeleteIndexMethod;
    if ((getDeleteIndexMethod = WarehouseGrpc.getDeleteIndexMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getDeleteIndexMethod = WarehouseGrpc.getDeleteIndexMethod) == null) {
          WarehouseGrpc.getDeleteIndexMethod =
              getDeleteIndexMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.DeleteIndexRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteIndex"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.DeleteIndexRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new WarehouseMethodDescriptorSupplier("DeleteIndex"))
                      .build();
        }
      }
    }
    return getDeleteIndexMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateCorpusRequest, com.google.longrunning.Operation>
      getCreateCorpusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCorpus",
      requestType = com.google.cloud.visionai.v1.CreateCorpusRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateCorpusRequest, com.google.longrunning.Operation>
      getCreateCorpusMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.CreateCorpusRequest, com.google.longrunning.Operation>
        getCreateCorpusMethod;
    if ((getCreateCorpusMethod = WarehouseGrpc.getCreateCorpusMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getCreateCorpusMethod = WarehouseGrpc.getCreateCorpusMethod) == null) {
          WarehouseGrpc.getCreateCorpusMethod =
              getCreateCorpusMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.CreateCorpusRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCorpus"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.CreateCorpusRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new WarehouseMethodDescriptorSupplier("CreateCorpus"))
                      .build();
        }
      }
    }
    return getCreateCorpusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetCorpusRequest, com.google.cloud.visionai.v1.Corpus>
      getGetCorpusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCorpus",
      requestType = com.google.cloud.visionai.v1.GetCorpusRequest.class,
      responseType = com.google.cloud.visionai.v1.Corpus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetCorpusRequest, com.google.cloud.visionai.v1.Corpus>
      getGetCorpusMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.GetCorpusRequest, com.google.cloud.visionai.v1.Corpus>
        getGetCorpusMethod;
    if ((getGetCorpusMethod = WarehouseGrpc.getGetCorpusMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getGetCorpusMethod = WarehouseGrpc.getGetCorpusMethod) == null) {
          WarehouseGrpc.getGetCorpusMethod =
              getGetCorpusMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.GetCorpusRequest,
                          com.google.cloud.visionai.v1.Corpus>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCorpus"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.GetCorpusRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.Corpus.getDefaultInstance()))
                      .setSchemaDescriptor(new WarehouseMethodDescriptorSupplier("GetCorpus"))
                      .build();
        }
      }
    }
    return getGetCorpusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateCorpusRequest, com.google.cloud.visionai.v1.Corpus>
      getUpdateCorpusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCorpus",
      requestType = com.google.cloud.visionai.v1.UpdateCorpusRequest.class,
      responseType = com.google.cloud.visionai.v1.Corpus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateCorpusRequest, com.google.cloud.visionai.v1.Corpus>
      getUpdateCorpusMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.UpdateCorpusRequest, com.google.cloud.visionai.v1.Corpus>
        getUpdateCorpusMethod;
    if ((getUpdateCorpusMethod = WarehouseGrpc.getUpdateCorpusMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getUpdateCorpusMethod = WarehouseGrpc.getUpdateCorpusMethod) == null) {
          WarehouseGrpc.getUpdateCorpusMethod =
              getUpdateCorpusMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.UpdateCorpusRequest,
                          com.google.cloud.visionai.v1.Corpus>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCorpus"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.UpdateCorpusRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.Corpus.getDefaultInstance()))
                      .setSchemaDescriptor(new WarehouseMethodDescriptorSupplier("UpdateCorpus"))
                      .build();
        }
      }
    }
    return getUpdateCorpusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListCorporaRequest,
          com.google.cloud.visionai.v1.ListCorporaResponse>
      getListCorporaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCorpora",
      requestType = com.google.cloud.visionai.v1.ListCorporaRequest.class,
      responseType = com.google.cloud.visionai.v1.ListCorporaResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListCorporaRequest,
          com.google.cloud.visionai.v1.ListCorporaResponse>
      getListCorporaMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.ListCorporaRequest,
            com.google.cloud.visionai.v1.ListCorporaResponse>
        getListCorporaMethod;
    if ((getListCorporaMethod = WarehouseGrpc.getListCorporaMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getListCorporaMethod = WarehouseGrpc.getListCorporaMethod) == null) {
          WarehouseGrpc.getListCorporaMethod =
              getListCorporaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.ListCorporaRequest,
                          com.google.cloud.visionai.v1.ListCorporaResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCorpora"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListCorporaRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListCorporaResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new WarehouseMethodDescriptorSupplier("ListCorpora"))
                      .build();
        }
      }
    }
    return getListCorporaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteCorpusRequest, com.google.protobuf.Empty>
      getDeleteCorpusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCorpus",
      requestType = com.google.cloud.visionai.v1.DeleteCorpusRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteCorpusRequest, com.google.protobuf.Empty>
      getDeleteCorpusMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.DeleteCorpusRequest, com.google.protobuf.Empty>
        getDeleteCorpusMethod;
    if ((getDeleteCorpusMethod = WarehouseGrpc.getDeleteCorpusMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getDeleteCorpusMethod = WarehouseGrpc.getDeleteCorpusMethod) == null) {
          WarehouseGrpc.getDeleteCorpusMethod =
              getDeleteCorpusMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.DeleteCorpusRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCorpus"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.DeleteCorpusRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new WarehouseMethodDescriptorSupplier("DeleteCorpus"))
                      .build();
        }
      }
    }
    return getDeleteCorpusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.AnalyzeCorpusRequest, com.google.longrunning.Operation>
      getAnalyzeCorpusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AnalyzeCorpus",
      requestType = com.google.cloud.visionai.v1.AnalyzeCorpusRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.AnalyzeCorpusRequest, com.google.longrunning.Operation>
      getAnalyzeCorpusMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.AnalyzeCorpusRequest, com.google.longrunning.Operation>
        getAnalyzeCorpusMethod;
    if ((getAnalyzeCorpusMethod = WarehouseGrpc.getAnalyzeCorpusMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getAnalyzeCorpusMethod = WarehouseGrpc.getAnalyzeCorpusMethod) == null) {
          WarehouseGrpc.getAnalyzeCorpusMethod =
              getAnalyzeCorpusMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.AnalyzeCorpusRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AnalyzeCorpus"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.AnalyzeCorpusRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new WarehouseMethodDescriptorSupplier("AnalyzeCorpus"))
                      .build();
        }
      }
    }
    return getAnalyzeCorpusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateDataSchemaRequest,
          com.google.cloud.visionai.v1.DataSchema>
      getCreateDataSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDataSchema",
      requestType = com.google.cloud.visionai.v1.CreateDataSchemaRequest.class,
      responseType = com.google.cloud.visionai.v1.DataSchema.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateDataSchemaRequest,
          com.google.cloud.visionai.v1.DataSchema>
      getCreateDataSchemaMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.CreateDataSchemaRequest,
            com.google.cloud.visionai.v1.DataSchema>
        getCreateDataSchemaMethod;
    if ((getCreateDataSchemaMethod = WarehouseGrpc.getCreateDataSchemaMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getCreateDataSchemaMethod = WarehouseGrpc.getCreateDataSchemaMethod) == null) {
          WarehouseGrpc.getCreateDataSchemaMethod =
              getCreateDataSchemaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.CreateDataSchemaRequest,
                          com.google.cloud.visionai.v1.DataSchema>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDataSchema"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.CreateDataSchemaRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.DataSchema.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WarehouseMethodDescriptorSupplier("CreateDataSchema"))
                      .build();
        }
      }
    }
    return getCreateDataSchemaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateDataSchemaRequest,
          com.google.cloud.visionai.v1.DataSchema>
      getUpdateDataSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDataSchema",
      requestType = com.google.cloud.visionai.v1.UpdateDataSchemaRequest.class,
      responseType = com.google.cloud.visionai.v1.DataSchema.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateDataSchemaRequest,
          com.google.cloud.visionai.v1.DataSchema>
      getUpdateDataSchemaMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.UpdateDataSchemaRequest,
            com.google.cloud.visionai.v1.DataSchema>
        getUpdateDataSchemaMethod;
    if ((getUpdateDataSchemaMethod = WarehouseGrpc.getUpdateDataSchemaMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getUpdateDataSchemaMethod = WarehouseGrpc.getUpdateDataSchemaMethod) == null) {
          WarehouseGrpc.getUpdateDataSchemaMethod =
              getUpdateDataSchemaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.UpdateDataSchemaRequest,
                          com.google.cloud.visionai.v1.DataSchema>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDataSchema"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.UpdateDataSchemaRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.DataSchema.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WarehouseMethodDescriptorSupplier("UpdateDataSchema"))
                      .build();
        }
      }
    }
    return getUpdateDataSchemaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetDataSchemaRequest,
          com.google.cloud.visionai.v1.DataSchema>
      getGetDataSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataSchema",
      requestType = com.google.cloud.visionai.v1.GetDataSchemaRequest.class,
      responseType = com.google.cloud.visionai.v1.DataSchema.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetDataSchemaRequest,
          com.google.cloud.visionai.v1.DataSchema>
      getGetDataSchemaMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.GetDataSchemaRequest,
            com.google.cloud.visionai.v1.DataSchema>
        getGetDataSchemaMethod;
    if ((getGetDataSchemaMethod = WarehouseGrpc.getGetDataSchemaMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getGetDataSchemaMethod = WarehouseGrpc.getGetDataSchemaMethod) == null) {
          WarehouseGrpc.getGetDataSchemaMethod =
              getGetDataSchemaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.GetDataSchemaRequest,
                          com.google.cloud.visionai.v1.DataSchema>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataSchema"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.GetDataSchemaRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.DataSchema.getDefaultInstance()))
                      .setSchemaDescriptor(new WarehouseMethodDescriptorSupplier("GetDataSchema"))
                      .build();
        }
      }
    }
    return getGetDataSchemaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteDataSchemaRequest, com.google.protobuf.Empty>
      getDeleteDataSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDataSchema",
      requestType = com.google.cloud.visionai.v1.DeleteDataSchemaRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteDataSchemaRequest, com.google.protobuf.Empty>
      getDeleteDataSchemaMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.DeleteDataSchemaRequest, com.google.protobuf.Empty>
        getDeleteDataSchemaMethod;
    if ((getDeleteDataSchemaMethod = WarehouseGrpc.getDeleteDataSchemaMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getDeleteDataSchemaMethod = WarehouseGrpc.getDeleteDataSchemaMethod) == null) {
          WarehouseGrpc.getDeleteDataSchemaMethod =
              getDeleteDataSchemaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.DeleteDataSchemaRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDataSchema"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.DeleteDataSchemaRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WarehouseMethodDescriptorSupplier("DeleteDataSchema"))
                      .build();
        }
      }
    }
    return getDeleteDataSchemaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListDataSchemasRequest,
          com.google.cloud.visionai.v1.ListDataSchemasResponse>
      getListDataSchemasMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDataSchemas",
      requestType = com.google.cloud.visionai.v1.ListDataSchemasRequest.class,
      responseType = com.google.cloud.visionai.v1.ListDataSchemasResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListDataSchemasRequest,
          com.google.cloud.visionai.v1.ListDataSchemasResponse>
      getListDataSchemasMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.ListDataSchemasRequest,
            com.google.cloud.visionai.v1.ListDataSchemasResponse>
        getListDataSchemasMethod;
    if ((getListDataSchemasMethod = WarehouseGrpc.getListDataSchemasMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getListDataSchemasMethod = WarehouseGrpc.getListDataSchemasMethod) == null) {
          WarehouseGrpc.getListDataSchemasMethod =
              getListDataSchemasMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.ListDataSchemasRequest,
                          com.google.cloud.visionai.v1.ListDataSchemasResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDataSchemas"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListDataSchemasRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListDataSchemasResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new WarehouseMethodDescriptorSupplier("ListDataSchemas"))
                      .build();
        }
      }
    }
    return getListDataSchemasMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateAnnotationRequest,
          com.google.cloud.visionai.v1.Annotation>
      getCreateAnnotationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAnnotation",
      requestType = com.google.cloud.visionai.v1.CreateAnnotationRequest.class,
      responseType = com.google.cloud.visionai.v1.Annotation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateAnnotationRequest,
          com.google.cloud.visionai.v1.Annotation>
      getCreateAnnotationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.CreateAnnotationRequest,
            com.google.cloud.visionai.v1.Annotation>
        getCreateAnnotationMethod;
    if ((getCreateAnnotationMethod = WarehouseGrpc.getCreateAnnotationMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getCreateAnnotationMethod = WarehouseGrpc.getCreateAnnotationMethod) == null) {
          WarehouseGrpc.getCreateAnnotationMethod =
              getCreateAnnotationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.CreateAnnotationRequest,
                          com.google.cloud.visionai.v1.Annotation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAnnotation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.CreateAnnotationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.Annotation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WarehouseMethodDescriptorSupplier("CreateAnnotation"))
                      .build();
        }
      }
    }
    return getCreateAnnotationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetAnnotationRequest,
          com.google.cloud.visionai.v1.Annotation>
      getGetAnnotationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAnnotation",
      requestType = com.google.cloud.visionai.v1.GetAnnotationRequest.class,
      responseType = com.google.cloud.visionai.v1.Annotation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetAnnotationRequest,
          com.google.cloud.visionai.v1.Annotation>
      getGetAnnotationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.GetAnnotationRequest,
            com.google.cloud.visionai.v1.Annotation>
        getGetAnnotationMethod;
    if ((getGetAnnotationMethod = WarehouseGrpc.getGetAnnotationMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getGetAnnotationMethod = WarehouseGrpc.getGetAnnotationMethod) == null) {
          WarehouseGrpc.getGetAnnotationMethod =
              getGetAnnotationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.GetAnnotationRequest,
                          com.google.cloud.visionai.v1.Annotation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAnnotation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.GetAnnotationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.Annotation.getDefaultInstance()))
                      .setSchemaDescriptor(new WarehouseMethodDescriptorSupplier("GetAnnotation"))
                      .build();
        }
      }
    }
    return getGetAnnotationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListAnnotationsRequest,
          com.google.cloud.visionai.v1.ListAnnotationsResponse>
      getListAnnotationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAnnotations",
      requestType = com.google.cloud.visionai.v1.ListAnnotationsRequest.class,
      responseType = com.google.cloud.visionai.v1.ListAnnotationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListAnnotationsRequest,
          com.google.cloud.visionai.v1.ListAnnotationsResponse>
      getListAnnotationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.ListAnnotationsRequest,
            com.google.cloud.visionai.v1.ListAnnotationsResponse>
        getListAnnotationsMethod;
    if ((getListAnnotationsMethod = WarehouseGrpc.getListAnnotationsMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getListAnnotationsMethod = WarehouseGrpc.getListAnnotationsMethod) == null) {
          WarehouseGrpc.getListAnnotationsMethod =
              getListAnnotationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.ListAnnotationsRequest,
                          com.google.cloud.visionai.v1.ListAnnotationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAnnotations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListAnnotationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListAnnotationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new WarehouseMethodDescriptorSupplier("ListAnnotations"))
                      .build();
        }
      }
    }
    return getListAnnotationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateAnnotationRequest,
          com.google.cloud.visionai.v1.Annotation>
      getUpdateAnnotationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAnnotation",
      requestType = com.google.cloud.visionai.v1.UpdateAnnotationRequest.class,
      responseType = com.google.cloud.visionai.v1.Annotation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateAnnotationRequest,
          com.google.cloud.visionai.v1.Annotation>
      getUpdateAnnotationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.UpdateAnnotationRequest,
            com.google.cloud.visionai.v1.Annotation>
        getUpdateAnnotationMethod;
    if ((getUpdateAnnotationMethod = WarehouseGrpc.getUpdateAnnotationMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getUpdateAnnotationMethod = WarehouseGrpc.getUpdateAnnotationMethod) == null) {
          WarehouseGrpc.getUpdateAnnotationMethod =
              getUpdateAnnotationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.UpdateAnnotationRequest,
                          com.google.cloud.visionai.v1.Annotation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAnnotation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.UpdateAnnotationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.Annotation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WarehouseMethodDescriptorSupplier("UpdateAnnotation"))
                      .build();
        }
      }
    }
    return getUpdateAnnotationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteAnnotationRequest, com.google.protobuf.Empty>
      getDeleteAnnotationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAnnotation",
      requestType = com.google.cloud.visionai.v1.DeleteAnnotationRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteAnnotationRequest, com.google.protobuf.Empty>
      getDeleteAnnotationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.DeleteAnnotationRequest, com.google.protobuf.Empty>
        getDeleteAnnotationMethod;
    if ((getDeleteAnnotationMethod = WarehouseGrpc.getDeleteAnnotationMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getDeleteAnnotationMethod = WarehouseGrpc.getDeleteAnnotationMethod) == null) {
          WarehouseGrpc.getDeleteAnnotationMethod =
              getDeleteAnnotationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.DeleteAnnotationRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAnnotation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.DeleteAnnotationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WarehouseMethodDescriptorSupplier("DeleteAnnotation"))
                      .build();
        }
      }
    }
    return getDeleteAnnotationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.IngestAssetRequest,
          com.google.cloud.visionai.v1.IngestAssetResponse>
      getIngestAssetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "IngestAsset",
      requestType = com.google.cloud.visionai.v1.IngestAssetRequest.class,
      responseType = com.google.cloud.visionai.v1.IngestAssetResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.IngestAssetRequest,
          com.google.cloud.visionai.v1.IngestAssetResponse>
      getIngestAssetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.IngestAssetRequest,
            com.google.cloud.visionai.v1.IngestAssetResponse>
        getIngestAssetMethod;
    if ((getIngestAssetMethod = WarehouseGrpc.getIngestAssetMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getIngestAssetMethod = WarehouseGrpc.getIngestAssetMethod) == null) {
          WarehouseGrpc.getIngestAssetMethod =
              getIngestAssetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.IngestAssetRequest,
                          com.google.cloud.visionai.v1.IngestAssetResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "IngestAsset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.IngestAssetRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.IngestAssetResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new WarehouseMethodDescriptorSupplier("IngestAsset"))
                      .build();
        }
      }
    }
    return getIngestAssetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ClipAssetRequest,
          com.google.cloud.visionai.v1.ClipAssetResponse>
      getClipAssetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ClipAsset",
      requestType = com.google.cloud.visionai.v1.ClipAssetRequest.class,
      responseType = com.google.cloud.visionai.v1.ClipAssetResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ClipAssetRequest,
          com.google.cloud.visionai.v1.ClipAssetResponse>
      getClipAssetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.ClipAssetRequest,
            com.google.cloud.visionai.v1.ClipAssetResponse>
        getClipAssetMethod;
    if ((getClipAssetMethod = WarehouseGrpc.getClipAssetMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getClipAssetMethod = WarehouseGrpc.getClipAssetMethod) == null) {
          WarehouseGrpc.getClipAssetMethod =
              getClipAssetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.ClipAssetRequest,
                          com.google.cloud.visionai.v1.ClipAssetResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ClipAsset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ClipAssetRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ClipAssetResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new WarehouseMethodDescriptorSupplier("ClipAsset"))
                      .build();
        }
      }
    }
    return getClipAssetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GenerateHlsUriRequest,
          com.google.cloud.visionai.v1.GenerateHlsUriResponse>
      getGenerateHlsUriMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateHlsUri",
      requestType = com.google.cloud.visionai.v1.GenerateHlsUriRequest.class,
      responseType = com.google.cloud.visionai.v1.GenerateHlsUriResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GenerateHlsUriRequest,
          com.google.cloud.visionai.v1.GenerateHlsUriResponse>
      getGenerateHlsUriMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.GenerateHlsUriRequest,
            com.google.cloud.visionai.v1.GenerateHlsUriResponse>
        getGenerateHlsUriMethod;
    if ((getGenerateHlsUriMethod = WarehouseGrpc.getGenerateHlsUriMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getGenerateHlsUriMethod = WarehouseGrpc.getGenerateHlsUriMethod) == null) {
          WarehouseGrpc.getGenerateHlsUriMethod =
              getGenerateHlsUriMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.GenerateHlsUriRequest,
                          com.google.cloud.visionai.v1.GenerateHlsUriResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateHlsUri"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.GenerateHlsUriRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.GenerateHlsUriResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new WarehouseMethodDescriptorSupplier("GenerateHlsUri"))
                      .build();
        }
      }
    }
    return getGenerateHlsUriMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ImportAssetsRequest, com.google.longrunning.Operation>
      getImportAssetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportAssets",
      requestType = com.google.cloud.visionai.v1.ImportAssetsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ImportAssetsRequest, com.google.longrunning.Operation>
      getImportAssetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.ImportAssetsRequest, com.google.longrunning.Operation>
        getImportAssetsMethod;
    if ((getImportAssetsMethod = WarehouseGrpc.getImportAssetsMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getImportAssetsMethod = WarehouseGrpc.getImportAssetsMethod) == null) {
          WarehouseGrpc.getImportAssetsMethod =
              getImportAssetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.ImportAssetsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportAssets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ImportAssetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new WarehouseMethodDescriptorSupplier("ImportAssets"))
                      .build();
        }
      }
    }
    return getImportAssetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateSearchConfigRequest,
          com.google.cloud.visionai.v1.SearchConfig>
      getCreateSearchConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSearchConfig",
      requestType = com.google.cloud.visionai.v1.CreateSearchConfigRequest.class,
      responseType = com.google.cloud.visionai.v1.SearchConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateSearchConfigRequest,
          com.google.cloud.visionai.v1.SearchConfig>
      getCreateSearchConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.CreateSearchConfigRequest,
            com.google.cloud.visionai.v1.SearchConfig>
        getCreateSearchConfigMethod;
    if ((getCreateSearchConfigMethod = WarehouseGrpc.getCreateSearchConfigMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getCreateSearchConfigMethod = WarehouseGrpc.getCreateSearchConfigMethod) == null) {
          WarehouseGrpc.getCreateSearchConfigMethod =
              getCreateSearchConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.CreateSearchConfigRequest,
                          com.google.cloud.visionai.v1.SearchConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSearchConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.CreateSearchConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.SearchConfig.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WarehouseMethodDescriptorSupplier("CreateSearchConfig"))
                      .build();
        }
      }
    }
    return getCreateSearchConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateSearchConfigRequest,
          com.google.cloud.visionai.v1.SearchConfig>
      getUpdateSearchConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSearchConfig",
      requestType = com.google.cloud.visionai.v1.UpdateSearchConfigRequest.class,
      responseType = com.google.cloud.visionai.v1.SearchConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateSearchConfigRequest,
          com.google.cloud.visionai.v1.SearchConfig>
      getUpdateSearchConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.UpdateSearchConfigRequest,
            com.google.cloud.visionai.v1.SearchConfig>
        getUpdateSearchConfigMethod;
    if ((getUpdateSearchConfigMethod = WarehouseGrpc.getUpdateSearchConfigMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getUpdateSearchConfigMethod = WarehouseGrpc.getUpdateSearchConfigMethod) == null) {
          WarehouseGrpc.getUpdateSearchConfigMethod =
              getUpdateSearchConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.UpdateSearchConfigRequest,
                          com.google.cloud.visionai.v1.SearchConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSearchConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.UpdateSearchConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.SearchConfig.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WarehouseMethodDescriptorSupplier("UpdateSearchConfig"))
                      .build();
        }
      }
    }
    return getUpdateSearchConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetSearchConfigRequest,
          com.google.cloud.visionai.v1.SearchConfig>
      getGetSearchConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSearchConfig",
      requestType = com.google.cloud.visionai.v1.GetSearchConfigRequest.class,
      responseType = com.google.cloud.visionai.v1.SearchConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetSearchConfigRequest,
          com.google.cloud.visionai.v1.SearchConfig>
      getGetSearchConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.GetSearchConfigRequest,
            com.google.cloud.visionai.v1.SearchConfig>
        getGetSearchConfigMethod;
    if ((getGetSearchConfigMethod = WarehouseGrpc.getGetSearchConfigMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getGetSearchConfigMethod = WarehouseGrpc.getGetSearchConfigMethod) == null) {
          WarehouseGrpc.getGetSearchConfigMethod =
              getGetSearchConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.GetSearchConfigRequest,
                          com.google.cloud.visionai.v1.SearchConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSearchConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.GetSearchConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.SearchConfig.getDefaultInstance()))
                      .setSchemaDescriptor(new WarehouseMethodDescriptorSupplier("GetSearchConfig"))
                      .build();
        }
      }
    }
    return getGetSearchConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteSearchConfigRequest, com.google.protobuf.Empty>
      getDeleteSearchConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSearchConfig",
      requestType = com.google.cloud.visionai.v1.DeleteSearchConfigRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteSearchConfigRequest, com.google.protobuf.Empty>
      getDeleteSearchConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.DeleteSearchConfigRequest, com.google.protobuf.Empty>
        getDeleteSearchConfigMethod;
    if ((getDeleteSearchConfigMethod = WarehouseGrpc.getDeleteSearchConfigMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getDeleteSearchConfigMethod = WarehouseGrpc.getDeleteSearchConfigMethod) == null) {
          WarehouseGrpc.getDeleteSearchConfigMethod =
              getDeleteSearchConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.DeleteSearchConfigRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSearchConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.DeleteSearchConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WarehouseMethodDescriptorSupplier("DeleteSearchConfig"))
                      .build();
        }
      }
    }
    return getDeleteSearchConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListSearchConfigsRequest,
          com.google.cloud.visionai.v1.ListSearchConfigsResponse>
      getListSearchConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSearchConfigs",
      requestType = com.google.cloud.visionai.v1.ListSearchConfigsRequest.class,
      responseType = com.google.cloud.visionai.v1.ListSearchConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListSearchConfigsRequest,
          com.google.cloud.visionai.v1.ListSearchConfigsResponse>
      getListSearchConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.ListSearchConfigsRequest,
            com.google.cloud.visionai.v1.ListSearchConfigsResponse>
        getListSearchConfigsMethod;
    if ((getListSearchConfigsMethod = WarehouseGrpc.getListSearchConfigsMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getListSearchConfigsMethod = WarehouseGrpc.getListSearchConfigsMethod) == null) {
          WarehouseGrpc.getListSearchConfigsMethod =
              getListSearchConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.ListSearchConfigsRequest,
                          com.google.cloud.visionai.v1.ListSearchConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSearchConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListSearchConfigsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListSearchConfigsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WarehouseMethodDescriptorSupplier("ListSearchConfigs"))
                      .build();
        }
      }
    }
    return getListSearchConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateSearchHypernymRequest,
          com.google.cloud.visionai.v1.SearchHypernym>
      getCreateSearchHypernymMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSearchHypernym",
      requestType = com.google.cloud.visionai.v1.CreateSearchHypernymRequest.class,
      responseType = com.google.cloud.visionai.v1.SearchHypernym.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateSearchHypernymRequest,
          com.google.cloud.visionai.v1.SearchHypernym>
      getCreateSearchHypernymMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.CreateSearchHypernymRequest,
            com.google.cloud.visionai.v1.SearchHypernym>
        getCreateSearchHypernymMethod;
    if ((getCreateSearchHypernymMethod = WarehouseGrpc.getCreateSearchHypernymMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getCreateSearchHypernymMethod = WarehouseGrpc.getCreateSearchHypernymMethod) == null) {
          WarehouseGrpc.getCreateSearchHypernymMethod =
              getCreateSearchHypernymMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.CreateSearchHypernymRequest,
                          com.google.cloud.visionai.v1.SearchHypernym>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateSearchHypernym"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.CreateSearchHypernymRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.SearchHypernym.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WarehouseMethodDescriptorSupplier("CreateSearchHypernym"))
                      .build();
        }
      }
    }
    return getCreateSearchHypernymMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateSearchHypernymRequest,
          com.google.cloud.visionai.v1.SearchHypernym>
      getUpdateSearchHypernymMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSearchHypernym",
      requestType = com.google.cloud.visionai.v1.UpdateSearchHypernymRequest.class,
      responseType = com.google.cloud.visionai.v1.SearchHypernym.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateSearchHypernymRequest,
          com.google.cloud.visionai.v1.SearchHypernym>
      getUpdateSearchHypernymMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.UpdateSearchHypernymRequest,
            com.google.cloud.visionai.v1.SearchHypernym>
        getUpdateSearchHypernymMethod;
    if ((getUpdateSearchHypernymMethod = WarehouseGrpc.getUpdateSearchHypernymMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getUpdateSearchHypernymMethod = WarehouseGrpc.getUpdateSearchHypernymMethod) == null) {
          WarehouseGrpc.getUpdateSearchHypernymMethod =
              getUpdateSearchHypernymMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.UpdateSearchHypernymRequest,
                          com.google.cloud.visionai.v1.SearchHypernym>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateSearchHypernym"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.UpdateSearchHypernymRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.SearchHypernym.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WarehouseMethodDescriptorSupplier("UpdateSearchHypernym"))
                      .build();
        }
      }
    }
    return getUpdateSearchHypernymMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetSearchHypernymRequest,
          com.google.cloud.visionai.v1.SearchHypernym>
      getGetSearchHypernymMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSearchHypernym",
      requestType = com.google.cloud.visionai.v1.GetSearchHypernymRequest.class,
      responseType = com.google.cloud.visionai.v1.SearchHypernym.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetSearchHypernymRequest,
          com.google.cloud.visionai.v1.SearchHypernym>
      getGetSearchHypernymMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.GetSearchHypernymRequest,
            com.google.cloud.visionai.v1.SearchHypernym>
        getGetSearchHypernymMethod;
    if ((getGetSearchHypernymMethod = WarehouseGrpc.getGetSearchHypernymMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getGetSearchHypernymMethod = WarehouseGrpc.getGetSearchHypernymMethod) == null) {
          WarehouseGrpc.getGetSearchHypernymMethod =
              getGetSearchHypernymMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.GetSearchHypernymRequest,
                          com.google.cloud.visionai.v1.SearchHypernym>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSearchHypernym"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.GetSearchHypernymRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.SearchHypernym.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WarehouseMethodDescriptorSupplier("GetSearchHypernym"))
                      .build();
        }
      }
    }
    return getGetSearchHypernymMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteSearchHypernymRequest, com.google.protobuf.Empty>
      getDeleteSearchHypernymMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSearchHypernym",
      requestType = com.google.cloud.visionai.v1.DeleteSearchHypernymRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteSearchHypernymRequest, com.google.protobuf.Empty>
      getDeleteSearchHypernymMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.DeleteSearchHypernymRequest, com.google.protobuf.Empty>
        getDeleteSearchHypernymMethod;
    if ((getDeleteSearchHypernymMethod = WarehouseGrpc.getDeleteSearchHypernymMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getDeleteSearchHypernymMethod = WarehouseGrpc.getDeleteSearchHypernymMethod) == null) {
          WarehouseGrpc.getDeleteSearchHypernymMethod =
              getDeleteSearchHypernymMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.DeleteSearchHypernymRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteSearchHypernym"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.DeleteSearchHypernymRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WarehouseMethodDescriptorSupplier("DeleteSearchHypernym"))
                      .build();
        }
      }
    }
    return getDeleteSearchHypernymMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListSearchHypernymsRequest,
          com.google.cloud.visionai.v1.ListSearchHypernymsResponse>
      getListSearchHypernymsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSearchHypernyms",
      requestType = com.google.cloud.visionai.v1.ListSearchHypernymsRequest.class,
      responseType = com.google.cloud.visionai.v1.ListSearchHypernymsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListSearchHypernymsRequest,
          com.google.cloud.visionai.v1.ListSearchHypernymsResponse>
      getListSearchHypernymsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.ListSearchHypernymsRequest,
            com.google.cloud.visionai.v1.ListSearchHypernymsResponse>
        getListSearchHypernymsMethod;
    if ((getListSearchHypernymsMethod = WarehouseGrpc.getListSearchHypernymsMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getListSearchHypernymsMethod = WarehouseGrpc.getListSearchHypernymsMethod) == null) {
          WarehouseGrpc.getListSearchHypernymsMethod =
              getListSearchHypernymsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.ListSearchHypernymsRequest,
                          com.google.cloud.visionai.v1.ListSearchHypernymsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListSearchHypernyms"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListSearchHypernymsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListSearchHypernymsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WarehouseMethodDescriptorSupplier("ListSearchHypernyms"))
                      .build();
        }
      }
    }
    return getListSearchHypernymsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.SearchAssetsRequest,
          com.google.cloud.visionai.v1.SearchAssetsResponse>
      getSearchAssetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchAssets",
      requestType = com.google.cloud.visionai.v1.SearchAssetsRequest.class,
      responseType = com.google.cloud.visionai.v1.SearchAssetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.SearchAssetsRequest,
          com.google.cloud.visionai.v1.SearchAssetsResponse>
      getSearchAssetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.SearchAssetsRequest,
            com.google.cloud.visionai.v1.SearchAssetsResponse>
        getSearchAssetsMethod;
    if ((getSearchAssetsMethod = WarehouseGrpc.getSearchAssetsMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getSearchAssetsMethod = WarehouseGrpc.getSearchAssetsMethod) == null) {
          WarehouseGrpc.getSearchAssetsMethod =
              getSearchAssetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.SearchAssetsRequest,
                          com.google.cloud.visionai.v1.SearchAssetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchAssets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.SearchAssetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.SearchAssetsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new WarehouseMethodDescriptorSupplier("SearchAssets"))
                      .build();
        }
      }
    }
    return getSearchAssetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.SearchIndexEndpointRequest,
          com.google.cloud.visionai.v1.SearchIndexEndpointResponse>
      getSearchIndexEndpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchIndexEndpoint",
      requestType = com.google.cloud.visionai.v1.SearchIndexEndpointRequest.class,
      responseType = com.google.cloud.visionai.v1.SearchIndexEndpointResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.SearchIndexEndpointRequest,
          com.google.cloud.visionai.v1.SearchIndexEndpointResponse>
      getSearchIndexEndpointMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.SearchIndexEndpointRequest,
            com.google.cloud.visionai.v1.SearchIndexEndpointResponse>
        getSearchIndexEndpointMethod;
    if ((getSearchIndexEndpointMethod = WarehouseGrpc.getSearchIndexEndpointMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getSearchIndexEndpointMethod = WarehouseGrpc.getSearchIndexEndpointMethod) == null) {
          WarehouseGrpc.getSearchIndexEndpointMethod =
              getSearchIndexEndpointMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.SearchIndexEndpointRequest,
                          com.google.cloud.visionai.v1.SearchIndexEndpointResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SearchIndexEndpoint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.SearchIndexEndpointRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.SearchIndexEndpointResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WarehouseMethodDescriptorSupplier("SearchIndexEndpoint"))
                      .build();
        }
      }
    }
    return getSearchIndexEndpointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateIndexEndpointRequest, com.google.longrunning.Operation>
      getCreateIndexEndpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateIndexEndpoint",
      requestType = com.google.cloud.visionai.v1.CreateIndexEndpointRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateIndexEndpointRequest, com.google.longrunning.Operation>
      getCreateIndexEndpointMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.CreateIndexEndpointRequest,
            com.google.longrunning.Operation>
        getCreateIndexEndpointMethod;
    if ((getCreateIndexEndpointMethod = WarehouseGrpc.getCreateIndexEndpointMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getCreateIndexEndpointMethod = WarehouseGrpc.getCreateIndexEndpointMethod) == null) {
          WarehouseGrpc.getCreateIndexEndpointMethod =
              getCreateIndexEndpointMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.CreateIndexEndpointRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateIndexEndpoint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.CreateIndexEndpointRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WarehouseMethodDescriptorSupplier("CreateIndexEndpoint"))
                      .build();
        }
      }
    }
    return getCreateIndexEndpointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetIndexEndpointRequest,
          com.google.cloud.visionai.v1.IndexEndpoint>
      getGetIndexEndpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIndexEndpoint",
      requestType = com.google.cloud.visionai.v1.GetIndexEndpointRequest.class,
      responseType = com.google.cloud.visionai.v1.IndexEndpoint.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetIndexEndpointRequest,
          com.google.cloud.visionai.v1.IndexEndpoint>
      getGetIndexEndpointMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.GetIndexEndpointRequest,
            com.google.cloud.visionai.v1.IndexEndpoint>
        getGetIndexEndpointMethod;
    if ((getGetIndexEndpointMethod = WarehouseGrpc.getGetIndexEndpointMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getGetIndexEndpointMethod = WarehouseGrpc.getGetIndexEndpointMethod) == null) {
          WarehouseGrpc.getGetIndexEndpointMethod =
              getGetIndexEndpointMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.GetIndexEndpointRequest,
                          com.google.cloud.visionai.v1.IndexEndpoint>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIndexEndpoint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.GetIndexEndpointRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.IndexEndpoint.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WarehouseMethodDescriptorSupplier("GetIndexEndpoint"))
                      .build();
        }
      }
    }
    return getGetIndexEndpointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListIndexEndpointsRequest,
          com.google.cloud.visionai.v1.ListIndexEndpointsResponse>
      getListIndexEndpointsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListIndexEndpoints",
      requestType = com.google.cloud.visionai.v1.ListIndexEndpointsRequest.class,
      responseType = com.google.cloud.visionai.v1.ListIndexEndpointsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListIndexEndpointsRequest,
          com.google.cloud.visionai.v1.ListIndexEndpointsResponse>
      getListIndexEndpointsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.ListIndexEndpointsRequest,
            com.google.cloud.visionai.v1.ListIndexEndpointsResponse>
        getListIndexEndpointsMethod;
    if ((getListIndexEndpointsMethod = WarehouseGrpc.getListIndexEndpointsMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getListIndexEndpointsMethod = WarehouseGrpc.getListIndexEndpointsMethod) == null) {
          WarehouseGrpc.getListIndexEndpointsMethod =
              getListIndexEndpointsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.ListIndexEndpointsRequest,
                          com.google.cloud.visionai.v1.ListIndexEndpointsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListIndexEndpoints"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListIndexEndpointsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListIndexEndpointsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WarehouseMethodDescriptorSupplier("ListIndexEndpoints"))
                      .build();
        }
      }
    }
    return getListIndexEndpointsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateIndexEndpointRequest, com.google.longrunning.Operation>
      getUpdateIndexEndpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateIndexEndpoint",
      requestType = com.google.cloud.visionai.v1.UpdateIndexEndpointRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateIndexEndpointRequest, com.google.longrunning.Operation>
      getUpdateIndexEndpointMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.UpdateIndexEndpointRequest,
            com.google.longrunning.Operation>
        getUpdateIndexEndpointMethod;
    if ((getUpdateIndexEndpointMethod = WarehouseGrpc.getUpdateIndexEndpointMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getUpdateIndexEndpointMethod = WarehouseGrpc.getUpdateIndexEndpointMethod) == null) {
          WarehouseGrpc.getUpdateIndexEndpointMethod =
              getUpdateIndexEndpointMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.UpdateIndexEndpointRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateIndexEndpoint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.UpdateIndexEndpointRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WarehouseMethodDescriptorSupplier("UpdateIndexEndpoint"))
                      .build();
        }
      }
    }
    return getUpdateIndexEndpointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteIndexEndpointRequest, com.google.longrunning.Operation>
      getDeleteIndexEndpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteIndexEndpoint",
      requestType = com.google.cloud.visionai.v1.DeleteIndexEndpointRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteIndexEndpointRequest, com.google.longrunning.Operation>
      getDeleteIndexEndpointMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.DeleteIndexEndpointRequest,
            com.google.longrunning.Operation>
        getDeleteIndexEndpointMethod;
    if ((getDeleteIndexEndpointMethod = WarehouseGrpc.getDeleteIndexEndpointMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getDeleteIndexEndpointMethod = WarehouseGrpc.getDeleteIndexEndpointMethod) == null) {
          WarehouseGrpc.getDeleteIndexEndpointMethod =
              getDeleteIndexEndpointMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.DeleteIndexEndpointRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteIndexEndpoint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.DeleteIndexEndpointRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WarehouseMethodDescriptorSupplier("DeleteIndexEndpoint"))
                      .build();
        }
      }
    }
    return getDeleteIndexEndpointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeployIndexRequest, com.google.longrunning.Operation>
      getDeployIndexMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeployIndex",
      requestType = com.google.cloud.visionai.v1.DeployIndexRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeployIndexRequest, com.google.longrunning.Operation>
      getDeployIndexMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.DeployIndexRequest, com.google.longrunning.Operation>
        getDeployIndexMethod;
    if ((getDeployIndexMethod = WarehouseGrpc.getDeployIndexMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getDeployIndexMethod = WarehouseGrpc.getDeployIndexMethod) == null) {
          WarehouseGrpc.getDeployIndexMethod =
              getDeployIndexMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.DeployIndexRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeployIndex"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.DeployIndexRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new WarehouseMethodDescriptorSupplier("DeployIndex"))
                      .build();
        }
      }
    }
    return getDeployIndexMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UndeployIndexRequest, com.google.longrunning.Operation>
      getUndeployIndexMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UndeployIndex",
      requestType = com.google.cloud.visionai.v1.UndeployIndexRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UndeployIndexRequest, com.google.longrunning.Operation>
      getUndeployIndexMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.UndeployIndexRequest, com.google.longrunning.Operation>
        getUndeployIndexMethod;
    if ((getUndeployIndexMethod = WarehouseGrpc.getUndeployIndexMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getUndeployIndexMethod = WarehouseGrpc.getUndeployIndexMethod) == null) {
          WarehouseGrpc.getUndeployIndexMethod =
              getUndeployIndexMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.UndeployIndexRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UndeployIndex"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.UndeployIndexRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new WarehouseMethodDescriptorSupplier("UndeployIndex"))
                      .build();
        }
      }
    }
    return getUndeployIndexMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateCollectionRequest, com.google.longrunning.Operation>
      getCreateCollectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCollection",
      requestType = com.google.cloud.visionai.v1.CreateCollectionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateCollectionRequest, com.google.longrunning.Operation>
      getCreateCollectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.CreateCollectionRequest, com.google.longrunning.Operation>
        getCreateCollectionMethod;
    if ((getCreateCollectionMethod = WarehouseGrpc.getCreateCollectionMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getCreateCollectionMethod = WarehouseGrpc.getCreateCollectionMethod) == null) {
          WarehouseGrpc.getCreateCollectionMethod =
              getCreateCollectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.CreateCollectionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCollection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.CreateCollectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WarehouseMethodDescriptorSupplier("CreateCollection"))
                      .build();
        }
      }
    }
    return getCreateCollectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteCollectionRequest, com.google.longrunning.Operation>
      getDeleteCollectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCollection",
      requestType = com.google.cloud.visionai.v1.DeleteCollectionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteCollectionRequest, com.google.longrunning.Operation>
      getDeleteCollectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.DeleteCollectionRequest, com.google.longrunning.Operation>
        getDeleteCollectionMethod;
    if ((getDeleteCollectionMethod = WarehouseGrpc.getDeleteCollectionMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getDeleteCollectionMethod = WarehouseGrpc.getDeleteCollectionMethod) == null) {
          WarehouseGrpc.getDeleteCollectionMethod =
              getDeleteCollectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.DeleteCollectionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCollection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.DeleteCollectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WarehouseMethodDescriptorSupplier("DeleteCollection"))
                      .build();
        }
      }
    }
    return getDeleteCollectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetCollectionRequest,
          com.google.cloud.visionai.v1.Collection>
      getGetCollectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCollection",
      requestType = com.google.cloud.visionai.v1.GetCollectionRequest.class,
      responseType = com.google.cloud.visionai.v1.Collection.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetCollectionRequest,
          com.google.cloud.visionai.v1.Collection>
      getGetCollectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.GetCollectionRequest,
            com.google.cloud.visionai.v1.Collection>
        getGetCollectionMethod;
    if ((getGetCollectionMethod = WarehouseGrpc.getGetCollectionMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getGetCollectionMethod = WarehouseGrpc.getGetCollectionMethod) == null) {
          WarehouseGrpc.getGetCollectionMethod =
              getGetCollectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.GetCollectionRequest,
                          com.google.cloud.visionai.v1.Collection>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCollection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.GetCollectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.Collection.getDefaultInstance()))
                      .setSchemaDescriptor(new WarehouseMethodDescriptorSupplier("GetCollection"))
                      .build();
        }
      }
    }
    return getGetCollectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateCollectionRequest,
          com.google.cloud.visionai.v1.Collection>
      getUpdateCollectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCollection",
      requestType = com.google.cloud.visionai.v1.UpdateCollectionRequest.class,
      responseType = com.google.cloud.visionai.v1.Collection.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateCollectionRequest,
          com.google.cloud.visionai.v1.Collection>
      getUpdateCollectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.UpdateCollectionRequest,
            com.google.cloud.visionai.v1.Collection>
        getUpdateCollectionMethod;
    if ((getUpdateCollectionMethod = WarehouseGrpc.getUpdateCollectionMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getUpdateCollectionMethod = WarehouseGrpc.getUpdateCollectionMethod) == null) {
          WarehouseGrpc.getUpdateCollectionMethod =
              getUpdateCollectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.UpdateCollectionRequest,
                          com.google.cloud.visionai.v1.Collection>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCollection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.UpdateCollectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.Collection.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WarehouseMethodDescriptorSupplier("UpdateCollection"))
                      .build();
        }
      }
    }
    return getUpdateCollectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListCollectionsRequest,
          com.google.cloud.visionai.v1.ListCollectionsResponse>
      getListCollectionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCollections",
      requestType = com.google.cloud.visionai.v1.ListCollectionsRequest.class,
      responseType = com.google.cloud.visionai.v1.ListCollectionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListCollectionsRequest,
          com.google.cloud.visionai.v1.ListCollectionsResponse>
      getListCollectionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.ListCollectionsRequest,
            com.google.cloud.visionai.v1.ListCollectionsResponse>
        getListCollectionsMethod;
    if ((getListCollectionsMethod = WarehouseGrpc.getListCollectionsMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getListCollectionsMethod = WarehouseGrpc.getListCollectionsMethod) == null) {
          WarehouseGrpc.getListCollectionsMethod =
              getListCollectionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.ListCollectionsRequest,
                          com.google.cloud.visionai.v1.ListCollectionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCollections"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListCollectionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListCollectionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new WarehouseMethodDescriptorSupplier("ListCollections"))
                      .build();
        }
      }
    }
    return getListCollectionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.AddCollectionItemRequest,
          com.google.cloud.visionai.v1.AddCollectionItemResponse>
      getAddCollectionItemMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddCollectionItem",
      requestType = com.google.cloud.visionai.v1.AddCollectionItemRequest.class,
      responseType = com.google.cloud.visionai.v1.AddCollectionItemResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.AddCollectionItemRequest,
          com.google.cloud.visionai.v1.AddCollectionItemResponse>
      getAddCollectionItemMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.AddCollectionItemRequest,
            com.google.cloud.visionai.v1.AddCollectionItemResponse>
        getAddCollectionItemMethod;
    if ((getAddCollectionItemMethod = WarehouseGrpc.getAddCollectionItemMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getAddCollectionItemMethod = WarehouseGrpc.getAddCollectionItemMethod) == null) {
          WarehouseGrpc.getAddCollectionItemMethod =
              getAddCollectionItemMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.AddCollectionItemRequest,
                          com.google.cloud.visionai.v1.AddCollectionItemResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddCollectionItem"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.AddCollectionItemRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.AddCollectionItemResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WarehouseMethodDescriptorSupplier("AddCollectionItem"))
                      .build();
        }
      }
    }
    return getAddCollectionItemMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.RemoveCollectionItemRequest,
          com.google.cloud.visionai.v1.RemoveCollectionItemResponse>
      getRemoveCollectionItemMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveCollectionItem",
      requestType = com.google.cloud.visionai.v1.RemoveCollectionItemRequest.class,
      responseType = com.google.cloud.visionai.v1.RemoveCollectionItemResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.RemoveCollectionItemRequest,
          com.google.cloud.visionai.v1.RemoveCollectionItemResponse>
      getRemoveCollectionItemMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.RemoveCollectionItemRequest,
            com.google.cloud.visionai.v1.RemoveCollectionItemResponse>
        getRemoveCollectionItemMethod;
    if ((getRemoveCollectionItemMethod = WarehouseGrpc.getRemoveCollectionItemMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getRemoveCollectionItemMethod = WarehouseGrpc.getRemoveCollectionItemMethod) == null) {
          WarehouseGrpc.getRemoveCollectionItemMethod =
              getRemoveCollectionItemMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.RemoveCollectionItemRequest,
                          com.google.cloud.visionai.v1.RemoveCollectionItemResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RemoveCollectionItem"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.RemoveCollectionItemRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.RemoveCollectionItemResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WarehouseMethodDescriptorSupplier("RemoveCollectionItem"))
                      .build();
        }
      }
    }
    return getRemoveCollectionItemMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ViewCollectionItemsRequest,
          com.google.cloud.visionai.v1.ViewCollectionItemsResponse>
      getViewCollectionItemsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ViewCollectionItems",
      requestType = com.google.cloud.visionai.v1.ViewCollectionItemsRequest.class,
      responseType = com.google.cloud.visionai.v1.ViewCollectionItemsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ViewCollectionItemsRequest,
          com.google.cloud.visionai.v1.ViewCollectionItemsResponse>
      getViewCollectionItemsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.ViewCollectionItemsRequest,
            com.google.cloud.visionai.v1.ViewCollectionItemsResponse>
        getViewCollectionItemsMethod;
    if ((getViewCollectionItemsMethod = WarehouseGrpc.getViewCollectionItemsMethod) == null) {
      synchronized (WarehouseGrpc.class) {
        if ((getViewCollectionItemsMethod = WarehouseGrpc.getViewCollectionItemsMethod) == null) {
          WarehouseGrpc.getViewCollectionItemsMethod =
              getViewCollectionItemsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.ViewCollectionItemsRequest,
                          com.google.cloud.visionai.v1.ViewCollectionItemsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ViewCollectionItems"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ViewCollectionItemsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ViewCollectionItemsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WarehouseMethodDescriptorSupplier("ViewCollectionItems"))
                      .build();
        }
      }
    }
    return getViewCollectionItemsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static WarehouseStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WarehouseStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WarehouseStub>() {
          @java.lang.Override
          public WarehouseStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WarehouseStub(channel, callOptions);
          }
        };
    return WarehouseStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WarehouseBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WarehouseBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WarehouseBlockingStub>() {
          @java.lang.Override
          public WarehouseBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WarehouseBlockingStub(channel, callOptions);
          }
        };
    return WarehouseBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static WarehouseFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WarehouseFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WarehouseFutureStub>() {
          @java.lang.Override
          public WarehouseFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WarehouseFutureStub(channel, callOptions);
          }
        };
    return WarehouseFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service that manages media content + metadata for streaming.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates an asset inside corpus.
     * </pre>
     */
    default void createAsset(
        com.google.cloud.visionai.v1.CreateAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Asset> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAssetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an asset inside corpus.
     * </pre>
     */
    default void updateAsset(
        com.google.cloud.visionai.v1.UpdateAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Asset> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAssetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reads an asset inside corpus.
     * </pre>
     */
    default void getAsset(
        com.google.cloud.visionai.v1.GetAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Asset> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAssetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists an list of assets inside corpus.
     * </pre>
     */
    default void listAssets(
        com.google.cloud.visionai.v1.ListAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListAssetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAssetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes asset inside corpus.
     * </pre>
     */
    default void deleteAsset(
        com.google.cloud.visionai.v1.DeleteAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAssetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Upload asset by specifing the asset Cloud Storage uri.
     * For video warehouse, it requires users who call this API have read access
     * to the cloud storage file. Once it is uploaded, it can be retrieved by
     * GenerateRetrievalUrl API which by default, only can retrieve cloud storage
     * files from the same project of the warehouse. To allow retrieval cloud
     * storage files that are in a separate project, it requires to find the
     * vision ai service account (Go to IAM, check checkbox to show "Include
     * Google-provided role grants", search for "Cloud Vision AI Service Agent")
     * and grant the read access of the cloud storage files to that service
     * account.
     * </pre>
     */
    default void uploadAsset(
        com.google.cloud.visionai.v1.UploadAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUploadAssetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates a signed url for downloading the asset.
     * For video warehouse, please see comment of UploadAsset about how to allow
     * retrieval of cloud storage files in a different project.
     * </pre>
     */
    default void generateRetrievalUrl(
        com.google.cloud.visionai.v1.GenerateRetrievalUrlRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.GenerateRetrievalUrlResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateRetrievalUrlMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Analyze asset to power search capability.
     * </pre>
     */
    default void analyzeAsset(
        com.google.cloud.visionai.v1.AnalyzeAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAnalyzeAssetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Index one asset for search.
     * Supported corpus type: Corpus.Type.VIDEO_ON_DEMAND
     * </pre>
     */
    default void indexAsset(
        com.google.cloud.visionai.v1.IndexAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getIndexAssetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Remove one asset's index data for search.
     * Supported corpus type: Corpus.Type.VIDEO_ON_DEMAND
     * </pre>
     */
    default void removeIndexAsset(
        com.google.cloud.visionai.v1.RemoveIndexAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRemoveIndexAssetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists assets inside an index.
     * </pre>
     */
    default void viewIndexedAssets(
        com.google.cloud.visionai.v1.ViewIndexedAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ViewIndexedAssetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getViewIndexedAssetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an Index under the corpus.
     * </pre>
     */
    default void createIndex(
        com.google.cloud.visionai.v1.CreateIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateIndexMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an Index under the corpus.
     * Users can perform a metadata-only update or trigger a full index rebuild
     * with different update_mask values.
     * </pre>
     */
    default void updateIndex(
        com.google.cloud.visionai.v1.UpdateIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateIndexMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a single Index under a Corpus.
     * </pre>
     */
    default void getIndex(
        com.google.cloud.visionai.v1.GetIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Index> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetIndexMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all Indexes in a given Corpus.
     * </pre>
     */
    default void listIndexes(
        com.google.cloud.visionai.v1.ListIndexesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListIndexesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListIndexesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single Index. In order to delete an index, the caller must
     * make sure that it is not deployed to any index endpoint.
     * </pre>
     */
    default void deleteIndex(
        com.google.cloud.visionai.v1.DeleteIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteIndexMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a corpus inside a project.
     * </pre>
     */
    default void createCorpus(
        com.google.cloud.visionai.v1.CreateCorpusRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCorpusMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets corpus details inside a project.
     * </pre>
     */
    default void getCorpus(
        com.google.cloud.visionai.v1.GetCorpusRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Corpus> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCorpusMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a corpus in a project.
     * </pre>
     */
    default void updateCorpus(
        com.google.cloud.visionai.v1.UpdateCorpusRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Corpus> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateCorpusMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all corpora in a project.
     * </pre>
     */
    default void listCorpora(
        com.google.cloud.visionai.v1.ListCorporaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListCorporaResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCorporaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a corpus only if its empty.
     * Returns empty response.
     * </pre>
     */
    default void deleteCorpus(
        com.google.cloud.visionai.v1.DeleteCorpusRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteCorpusMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Analyzes a corpus.
     * </pre>
     */
    default void analyzeCorpus(
        com.google.cloud.visionai.v1.AnalyzeCorpusRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAnalyzeCorpusMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates data schema inside corpus.
     * </pre>
     */
    default void createDataSchema(
        com.google.cloud.visionai.v1.CreateDataSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.DataSchema> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDataSchemaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates data schema inside corpus.
     * </pre>
     */
    default void updateDataSchema(
        com.google.cloud.visionai.v1.UpdateDataSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.DataSchema> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDataSchemaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets data schema inside corpus.
     * </pre>
     */
    default void getDataSchema(
        com.google.cloud.visionai.v1.GetDataSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.DataSchema> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDataSchemaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes data schema inside corpus.
     * </pre>
     */
    default void deleteDataSchema(
        com.google.cloud.visionai.v1.DeleteDataSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDataSchemaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists a list of data schemas inside corpus.
     * </pre>
     */
    default void listDataSchemas(
        com.google.cloud.visionai.v1.ListDataSchemasRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListDataSchemasResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDataSchemasMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates annotation inside asset.
     * </pre>
     */
    default void createAnnotation(
        com.google.cloud.visionai.v1.CreateAnnotationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Annotation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAnnotationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reads annotation inside asset.
     * </pre>
     */
    default void getAnnotation(
        com.google.cloud.visionai.v1.GetAnnotationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Annotation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAnnotationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists a list of annotations inside asset.
     * </pre>
     */
    default void listAnnotations(
        com.google.cloud.visionai.v1.ListAnnotationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListAnnotationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAnnotationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates annotation inside asset.
     * </pre>
     */
    default void updateAnnotation(
        com.google.cloud.visionai.v1.UpdateAnnotationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Annotation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAnnotationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes annotation inside asset.
     * </pre>
     */
    default void deleteAnnotation(
        com.google.cloud.visionai.v1.DeleteAnnotationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAnnotationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Ingests data for the asset. It is not allowed to ingest a data chunk which
     * is already expired according to TTL.
     * This method is only available via the gRPC API (not HTTP since
     * bi-directional streaming is not supported via HTTP).
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.IngestAssetRequest>
        ingestAsset(
            io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.IngestAssetResponse>
                responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(
          getIngestAssetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates clips for downloading. The api takes in a time range, and
     * generates a clip of the first content available after start_time and
     * before end_time, which may overflow beyond these bounds.
     * Returned clips are truncated if the total size of the clips are larger
     * than 100MB.
     * </pre>
     */
    default void clipAsset(
        com.google.cloud.visionai.v1.ClipAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ClipAssetResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getClipAssetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates a uri for an HLS manifest. The api takes in a collection of time
     * ranges, and generates a URI for an HLS manifest that covers all the
     * requested time ranges.
     * </pre>
     */
    default void generateHlsUri(
        com.google.cloud.visionai.v1.GenerateHlsUriRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.GenerateHlsUriResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateHlsUriMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports assets (images plus annotations) from a meta file on cloud storage.
     * Each row in the meta file is corresponding to an image (specified by a
     * cloud storage uri) and its annotations.
     * </pre>
     */
    default void importAssets(
        com.google.cloud.visionai.v1.ImportAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportAssetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a search configuration inside a corpus.
     * Please follow the rules below to create a valid CreateSearchConfigRequest.
     * --- General Rules ---
     * 1. Request.search_config_id must not be associated with an existing
     *    SearchConfig.
     * 2. Request must contain at least one non-empty search_criteria_property or
     *    facet_property.
     * 3. mapped_fields must not be empty, and must map to existing UGA keys.
     * 4. All mapped_fields must be of the same type.
     * 5. All mapped_fields must share the same granularity.
     * 6. All mapped_fields must share the same semantic SearchConfig match
     *    options.
     * For property-specific rules, please reference the comments for
     * FacetProperty and SearchCriteriaProperty.
     * </pre>
     */
    default void createSearchConfig(
        com.google.cloud.visionai.v1.CreateSearchConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.SearchConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSearchConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a search configuration inside a corpus.
     * Please follow the rules below to create a valid UpdateSearchConfigRequest.
     * --- General Rules ---
     * 1. Request.search_configuration.name must already exist.
     * 2. Request must contain at least one non-empty search_criteria_property or
     * facet_property.
     * 3. mapped_fields must not be empty, and must map to existing UGA keys.
     * 4. All mapped_fields must be of the same type.
     * 5. All mapped_fields must share the same granularity.
     * 6. All mapped_fields must share the same semantic SearchConfig match
     *    options.
     * For property-specific rules, please reference the comments for
     * FacetProperty and SearchCriteriaProperty.
     * </pre>
     */
    default void updateSearchConfig(
        com.google.cloud.visionai.v1.UpdateSearchConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.SearchConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSearchConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a search configuration inside a corpus.
     * </pre>
     */
    default void getSearchConfig(
        com.google.cloud.visionai.v1.GetSearchConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.SearchConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSearchConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a search configuration inside a corpus.
     * For a DeleteSearchConfigRequest to be valid,
     * Request.search_configuration.name must already exist.
     * </pre>
     */
    default void deleteSearchConfig(
        com.google.cloud.visionai.v1.DeleteSearchConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSearchConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all search configurations inside a corpus.
     * </pre>
     */
    default void listSearchConfigs(
        com.google.cloud.visionai.v1.ListSearchConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListSearchConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSearchConfigsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a SearchHypernym inside a corpus.
     * </pre>
     */
    default void createSearchHypernym(
        com.google.cloud.visionai.v1.CreateSearchHypernymRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.SearchHypernym> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSearchHypernymMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a SearchHypernym inside a corpus.
     * </pre>
     */
    default void updateSearchHypernym(
        com.google.cloud.visionai.v1.UpdateSearchHypernymRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.SearchHypernym> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSearchHypernymMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a SearchHypernym inside a corpus.
     * </pre>
     */
    default void getSearchHypernym(
        com.google.cloud.visionai.v1.GetSearchHypernymRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.SearchHypernym> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSearchHypernymMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a SearchHypernym inside a corpus.
     * </pre>
     */
    default void deleteSearchHypernym(
        com.google.cloud.visionai.v1.DeleteSearchHypernymRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSearchHypernymMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists SearchHypernyms inside a corpus.
     * </pre>
     */
    default void listSearchHypernyms(
        com.google.cloud.visionai.v1.ListSearchHypernymsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListSearchHypernymsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSearchHypernymsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Search media asset.
     * </pre>
     */
    default void searchAssets(
        com.google.cloud.visionai.v1.SearchAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.SearchAssetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchAssetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Search a deployed index endpoint (IMAGE corpus type only).
     * </pre>
     */
    default void searchIndexEndpoint(
        com.google.cloud.visionai.v1.SearchIndexEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.SearchIndexEndpointResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchIndexEndpointMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an IndexEndpoint.
     * </pre>
     */
    default void createIndexEndpoint(
        com.google.cloud.visionai.v1.CreateIndexEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateIndexEndpointMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an IndexEndpoint.
     * </pre>
     */
    default void getIndexEndpoint(
        com.google.cloud.visionai.v1.GetIndexEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.IndexEndpoint> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetIndexEndpointMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all IndexEndpoints in a project.
     * </pre>
     */
    default void listIndexEndpoints(
        com.google.cloud.visionai.v1.ListIndexEndpointsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListIndexEndpointsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListIndexEndpointsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an IndexEndpoint.
     * </pre>
     */
    default void updateIndexEndpoint(
        com.google.cloud.visionai.v1.UpdateIndexEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateIndexEndpointMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an IndexEndpoint.
     * </pre>
     */
    default void deleteIndexEndpoint(
        com.google.cloud.visionai.v1.DeleteIndexEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteIndexEndpointMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deploys an Index to IndexEndpoint.
     * </pre>
     */
    default void deployIndex(
        com.google.cloud.visionai.v1.DeployIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeployIndexMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Undeploys an Index from IndexEndpoint.
     * </pre>
     */
    default void undeployIndex(
        com.google.cloud.visionai.v1.UndeployIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUndeployIndexMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a collection.
     * </pre>
     */
    default void createCollection(
        com.google.cloud.visionai.v1.CreateCollectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCollectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a collection.
     * </pre>
     */
    default void deleteCollection(
        com.google.cloud.visionai.v1.DeleteCollectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteCollectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a collection.
     * </pre>
     */
    default void getCollection(
        com.google.cloud.visionai.v1.GetCollectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Collection> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCollectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a collection.
     * </pre>
     */
    default void updateCollection(
        com.google.cloud.visionai.v1.UpdateCollectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Collection> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateCollectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists collections inside a corpus.
     * </pre>
     */
    default void listCollections(
        com.google.cloud.visionai.v1.ListCollectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListCollectionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCollectionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds an item into a Collection.
     * </pre>
     */
    default void addCollectionItem(
        com.google.cloud.visionai.v1.AddCollectionItemRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.AddCollectionItemResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAddCollectionItemMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes an item from a collection.
     * </pre>
     */
    default void removeCollectionItem(
        com.google.cloud.visionai.v1.RemoveCollectionItemRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.RemoveCollectionItemResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRemoveCollectionItemMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * View items inside a collection.
     * </pre>
     */
    default void viewCollectionItems(
        com.google.cloud.visionai.v1.ViewCollectionItemsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ViewCollectionItemsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getViewCollectionItemsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Warehouse.
   *
   * <pre>
   * Service that manages media content + metadata for streaming.
   * </pre>
   */
  public abstract static class WarehouseImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return WarehouseGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Warehouse.
   *
   * <pre>
   * Service that manages media content + metadata for streaming.
   * </pre>
   */
  public static final class WarehouseStub extends io.grpc.stub.AbstractAsyncStub<WarehouseStub> {
    private WarehouseStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WarehouseStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WarehouseStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an asset inside corpus.
     * </pre>
     */
    public void createAsset(
        com.google.cloud.visionai.v1.CreateAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Asset> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAssetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an asset inside corpus.
     * </pre>
     */
    public void updateAsset(
        com.google.cloud.visionai.v1.UpdateAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Asset> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAssetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reads an asset inside corpus.
     * </pre>
     */
    public void getAsset(
        com.google.cloud.visionai.v1.GetAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Asset> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAssetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists an list of assets inside corpus.
     * </pre>
     */
    public void listAssets(
        com.google.cloud.visionai.v1.ListAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListAssetsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAssetsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes asset inside corpus.
     * </pre>
     */
    public void deleteAsset(
        com.google.cloud.visionai.v1.DeleteAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAssetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Upload asset by specifing the asset Cloud Storage uri.
     * For video warehouse, it requires users who call this API have read access
     * to the cloud storage file. Once it is uploaded, it can be retrieved by
     * GenerateRetrievalUrl API which by default, only can retrieve cloud storage
     * files from the same project of the warehouse. To allow retrieval cloud
     * storage files that are in a separate project, it requires to find the
     * vision ai service account (Go to IAM, check checkbox to show "Include
     * Google-provided role grants", search for "Cloud Vision AI Service Agent")
     * and grant the read access of the cloud storage files to that service
     * account.
     * </pre>
     */
    public void uploadAsset(
        com.google.cloud.visionai.v1.UploadAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUploadAssetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates a signed url for downloading the asset.
     * For video warehouse, please see comment of UploadAsset about how to allow
     * retrieval of cloud storage files in a different project.
     * </pre>
     */
    public void generateRetrievalUrl(
        com.google.cloud.visionai.v1.GenerateRetrievalUrlRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.GenerateRetrievalUrlResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateRetrievalUrlMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Analyze asset to power search capability.
     * </pre>
     */
    public void analyzeAsset(
        com.google.cloud.visionai.v1.AnalyzeAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAnalyzeAssetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Index one asset for search.
     * Supported corpus type: Corpus.Type.VIDEO_ON_DEMAND
     * </pre>
     */
    public void indexAsset(
        com.google.cloud.visionai.v1.IndexAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getIndexAssetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Remove one asset's index data for search.
     * Supported corpus type: Corpus.Type.VIDEO_ON_DEMAND
     * </pre>
     */
    public void removeIndexAsset(
        com.google.cloud.visionai.v1.RemoveIndexAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveIndexAssetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists assets inside an index.
     * </pre>
     */
    public void viewIndexedAssets(
        com.google.cloud.visionai.v1.ViewIndexedAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ViewIndexedAssetsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getViewIndexedAssetsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an Index under the corpus.
     * </pre>
     */
    public void createIndex(
        com.google.cloud.visionai.v1.CreateIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateIndexMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an Index under the corpus.
     * Users can perform a metadata-only update or trigger a full index rebuild
     * with different update_mask values.
     * </pre>
     */
    public void updateIndex(
        com.google.cloud.visionai.v1.UpdateIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateIndexMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a single Index under a Corpus.
     * </pre>
     */
    public void getIndex(
        com.google.cloud.visionai.v1.GetIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Index> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIndexMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all Indexes in a given Corpus.
     * </pre>
     */
    public void listIndexes(
        com.google.cloud.visionai.v1.ListIndexesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListIndexesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListIndexesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single Index. In order to delete an index, the caller must
     * make sure that it is not deployed to any index endpoint.
     * </pre>
     */
    public void deleteIndex(
        com.google.cloud.visionai.v1.DeleteIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteIndexMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a corpus inside a project.
     * </pre>
     */
    public void createCorpus(
        com.google.cloud.visionai.v1.CreateCorpusRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCorpusMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets corpus details inside a project.
     * </pre>
     */
    public void getCorpus(
        com.google.cloud.visionai.v1.GetCorpusRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Corpus> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCorpusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a corpus in a project.
     * </pre>
     */
    public void updateCorpus(
        com.google.cloud.visionai.v1.UpdateCorpusRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Corpus> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCorpusMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all corpora in a project.
     * </pre>
     */
    public void listCorpora(
        com.google.cloud.visionai.v1.ListCorporaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListCorporaResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCorporaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a corpus only if its empty.
     * Returns empty response.
     * </pre>
     */
    public void deleteCorpus(
        com.google.cloud.visionai.v1.DeleteCorpusRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCorpusMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Analyzes a corpus.
     * </pre>
     */
    public void analyzeCorpus(
        com.google.cloud.visionai.v1.AnalyzeCorpusRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAnalyzeCorpusMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates data schema inside corpus.
     * </pre>
     */
    public void createDataSchema(
        com.google.cloud.visionai.v1.CreateDataSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.DataSchema> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDataSchemaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates data schema inside corpus.
     * </pre>
     */
    public void updateDataSchema(
        com.google.cloud.visionai.v1.UpdateDataSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.DataSchema> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDataSchemaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets data schema inside corpus.
     * </pre>
     */
    public void getDataSchema(
        com.google.cloud.visionai.v1.GetDataSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.DataSchema> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataSchemaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes data schema inside corpus.
     * </pre>
     */
    public void deleteDataSchema(
        com.google.cloud.visionai.v1.DeleteDataSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDataSchemaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists a list of data schemas inside corpus.
     * </pre>
     */
    public void listDataSchemas(
        com.google.cloud.visionai.v1.ListDataSchemasRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListDataSchemasResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDataSchemasMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates annotation inside asset.
     * </pre>
     */
    public void createAnnotation(
        com.google.cloud.visionai.v1.CreateAnnotationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Annotation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAnnotationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reads annotation inside asset.
     * </pre>
     */
    public void getAnnotation(
        com.google.cloud.visionai.v1.GetAnnotationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Annotation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAnnotationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists a list of annotations inside asset.
     * </pre>
     */
    public void listAnnotations(
        com.google.cloud.visionai.v1.ListAnnotationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListAnnotationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAnnotationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates annotation inside asset.
     * </pre>
     */
    public void updateAnnotation(
        com.google.cloud.visionai.v1.UpdateAnnotationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Annotation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAnnotationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes annotation inside asset.
     * </pre>
     */
    public void deleteAnnotation(
        com.google.cloud.visionai.v1.DeleteAnnotationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAnnotationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Ingests data for the asset. It is not allowed to ingest a data chunk which
     * is already expired according to TTL.
     * This method is only available via the gRPC API (not HTTP since
     * bi-directional streaming is not supported via HTTP).
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.IngestAssetRequest> ingestAsset(
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.IngestAssetResponse>
            responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getIngestAssetMethod(), getCallOptions()), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates clips for downloading. The api takes in a time range, and
     * generates a clip of the first content available after start_time and
     * before end_time, which may overflow beyond these bounds.
     * Returned clips are truncated if the total size of the clips are larger
     * than 100MB.
     * </pre>
     */
    public void clipAsset(
        com.google.cloud.visionai.v1.ClipAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ClipAssetResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getClipAssetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates a uri for an HLS manifest. The api takes in a collection of time
     * ranges, and generates a URI for an HLS manifest that covers all the
     * requested time ranges.
     * </pre>
     */
    public void generateHlsUri(
        com.google.cloud.visionai.v1.GenerateHlsUriRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.GenerateHlsUriResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateHlsUriMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports assets (images plus annotations) from a meta file on cloud storage.
     * Each row in the meta file is corresponding to an image (specified by a
     * cloud storage uri) and its annotations.
     * </pre>
     */
    public void importAssets(
        com.google.cloud.visionai.v1.ImportAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportAssetsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a search configuration inside a corpus.
     * Please follow the rules below to create a valid CreateSearchConfigRequest.
     * --- General Rules ---
     * 1. Request.search_config_id must not be associated with an existing
     *    SearchConfig.
     * 2. Request must contain at least one non-empty search_criteria_property or
     *    facet_property.
     * 3. mapped_fields must not be empty, and must map to existing UGA keys.
     * 4. All mapped_fields must be of the same type.
     * 5. All mapped_fields must share the same granularity.
     * 6. All mapped_fields must share the same semantic SearchConfig match
     *    options.
     * For property-specific rules, please reference the comments for
     * FacetProperty and SearchCriteriaProperty.
     * </pre>
     */
    public void createSearchConfig(
        com.google.cloud.visionai.v1.CreateSearchConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.SearchConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSearchConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a search configuration inside a corpus.
     * Please follow the rules below to create a valid UpdateSearchConfigRequest.
     * --- General Rules ---
     * 1. Request.search_configuration.name must already exist.
     * 2. Request must contain at least one non-empty search_criteria_property or
     * facet_property.
     * 3. mapped_fields must not be empty, and must map to existing UGA keys.
     * 4. All mapped_fields must be of the same type.
     * 5. All mapped_fields must share the same granularity.
     * 6. All mapped_fields must share the same semantic SearchConfig match
     *    options.
     * For property-specific rules, please reference the comments for
     * FacetProperty and SearchCriteriaProperty.
     * </pre>
     */
    public void updateSearchConfig(
        com.google.cloud.visionai.v1.UpdateSearchConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.SearchConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSearchConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a search configuration inside a corpus.
     * </pre>
     */
    public void getSearchConfig(
        com.google.cloud.visionai.v1.GetSearchConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.SearchConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSearchConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a search configuration inside a corpus.
     * For a DeleteSearchConfigRequest to be valid,
     * Request.search_configuration.name must already exist.
     * </pre>
     */
    public void deleteSearchConfig(
        com.google.cloud.visionai.v1.DeleteSearchConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSearchConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all search configurations inside a corpus.
     * </pre>
     */
    public void listSearchConfigs(
        com.google.cloud.visionai.v1.ListSearchConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListSearchConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSearchConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a SearchHypernym inside a corpus.
     * </pre>
     */
    public void createSearchHypernym(
        com.google.cloud.visionai.v1.CreateSearchHypernymRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.SearchHypernym> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSearchHypernymMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a SearchHypernym inside a corpus.
     * </pre>
     */
    public void updateSearchHypernym(
        com.google.cloud.visionai.v1.UpdateSearchHypernymRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.SearchHypernym> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSearchHypernymMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a SearchHypernym inside a corpus.
     * </pre>
     */
    public void getSearchHypernym(
        com.google.cloud.visionai.v1.GetSearchHypernymRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.SearchHypernym> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSearchHypernymMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a SearchHypernym inside a corpus.
     * </pre>
     */
    public void deleteSearchHypernym(
        com.google.cloud.visionai.v1.DeleteSearchHypernymRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSearchHypernymMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists SearchHypernyms inside a corpus.
     * </pre>
     */
    public void listSearchHypernyms(
        com.google.cloud.visionai.v1.ListSearchHypernymsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListSearchHypernymsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSearchHypernymsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Search media asset.
     * </pre>
     */
    public void searchAssets(
        com.google.cloud.visionai.v1.SearchAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.SearchAssetsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchAssetsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Search a deployed index endpoint (IMAGE corpus type only).
     * </pre>
     */
    public void searchIndexEndpoint(
        com.google.cloud.visionai.v1.SearchIndexEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.SearchIndexEndpointResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchIndexEndpointMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an IndexEndpoint.
     * </pre>
     */
    public void createIndexEndpoint(
        com.google.cloud.visionai.v1.CreateIndexEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateIndexEndpointMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an IndexEndpoint.
     * </pre>
     */
    public void getIndexEndpoint(
        com.google.cloud.visionai.v1.GetIndexEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.IndexEndpoint> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIndexEndpointMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all IndexEndpoints in a project.
     * </pre>
     */
    public void listIndexEndpoints(
        com.google.cloud.visionai.v1.ListIndexEndpointsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListIndexEndpointsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListIndexEndpointsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an IndexEndpoint.
     * </pre>
     */
    public void updateIndexEndpoint(
        com.google.cloud.visionai.v1.UpdateIndexEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateIndexEndpointMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an IndexEndpoint.
     * </pre>
     */
    public void deleteIndexEndpoint(
        com.google.cloud.visionai.v1.DeleteIndexEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteIndexEndpointMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deploys an Index to IndexEndpoint.
     * </pre>
     */
    public void deployIndex(
        com.google.cloud.visionai.v1.DeployIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeployIndexMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Undeploys an Index from IndexEndpoint.
     * </pre>
     */
    public void undeployIndex(
        com.google.cloud.visionai.v1.UndeployIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUndeployIndexMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a collection.
     * </pre>
     */
    public void createCollection(
        com.google.cloud.visionai.v1.CreateCollectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCollectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a collection.
     * </pre>
     */
    public void deleteCollection(
        com.google.cloud.visionai.v1.DeleteCollectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCollectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a collection.
     * </pre>
     */
    public void getCollection(
        com.google.cloud.visionai.v1.GetCollectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Collection> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCollectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a collection.
     * </pre>
     */
    public void updateCollection(
        com.google.cloud.visionai.v1.UpdateCollectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Collection> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCollectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists collections inside a corpus.
     * </pre>
     */
    public void listCollections(
        com.google.cloud.visionai.v1.ListCollectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListCollectionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCollectionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds an item into a Collection.
     * </pre>
     */
    public void addCollectionItem(
        com.google.cloud.visionai.v1.AddCollectionItemRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.AddCollectionItemResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddCollectionItemMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes an item from a collection.
     * </pre>
     */
    public void removeCollectionItem(
        com.google.cloud.visionai.v1.RemoveCollectionItemRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.RemoveCollectionItemResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveCollectionItemMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * View items inside a collection.
     * </pre>
     */
    public void viewCollectionItems(
        com.google.cloud.visionai.v1.ViewCollectionItemsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ViewCollectionItemsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getViewCollectionItemsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Warehouse.
   *
   * <pre>
   * Service that manages media content + metadata for streaming.
   * </pre>
   */
  public static final class WarehouseBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<WarehouseBlockingStub> {
    private WarehouseBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WarehouseBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WarehouseBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an asset inside corpus.
     * </pre>
     */
    public com.google.cloud.visionai.v1.Asset createAsset(
        com.google.cloud.visionai.v1.CreateAssetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAssetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an asset inside corpus.
     * </pre>
     */
    public com.google.cloud.visionai.v1.Asset updateAsset(
        com.google.cloud.visionai.v1.UpdateAssetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAssetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Reads an asset inside corpus.
     * </pre>
     */
    public com.google.cloud.visionai.v1.Asset getAsset(
        com.google.cloud.visionai.v1.GetAssetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAssetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists an list of assets inside corpus.
     * </pre>
     */
    public com.google.cloud.visionai.v1.ListAssetsResponse listAssets(
        com.google.cloud.visionai.v1.ListAssetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAssetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes asset inside corpus.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAsset(
        com.google.cloud.visionai.v1.DeleteAssetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAssetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Upload asset by specifing the asset Cloud Storage uri.
     * For video warehouse, it requires users who call this API have read access
     * to the cloud storage file. Once it is uploaded, it can be retrieved by
     * GenerateRetrievalUrl API which by default, only can retrieve cloud storage
     * files from the same project of the warehouse. To allow retrieval cloud
     * storage files that are in a separate project, it requires to find the
     * vision ai service account (Go to IAM, check checkbox to show "Include
     * Google-provided role grants", search for "Cloud Vision AI Service Agent")
     * and grant the read access of the cloud storage files to that service
     * account.
     * </pre>
     */
    public com.google.longrunning.Operation uploadAsset(
        com.google.cloud.visionai.v1.UploadAssetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUploadAssetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generates a signed url for downloading the asset.
     * For video warehouse, please see comment of UploadAsset about how to allow
     * retrieval of cloud storage files in a different project.
     * </pre>
     */
    public com.google.cloud.visionai.v1.GenerateRetrievalUrlResponse generateRetrievalUrl(
        com.google.cloud.visionai.v1.GenerateRetrievalUrlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateRetrievalUrlMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Analyze asset to power search capability.
     * </pre>
     */
    public com.google.longrunning.Operation analyzeAsset(
        com.google.cloud.visionai.v1.AnalyzeAssetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAnalyzeAssetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Index one asset for search.
     * Supported corpus type: Corpus.Type.VIDEO_ON_DEMAND
     * </pre>
     */
    public com.google.longrunning.Operation indexAsset(
        com.google.cloud.visionai.v1.IndexAssetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getIndexAssetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Remove one asset's index data for search.
     * Supported corpus type: Corpus.Type.VIDEO_ON_DEMAND
     * </pre>
     */
    public com.google.longrunning.Operation removeIndexAsset(
        com.google.cloud.visionai.v1.RemoveIndexAssetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveIndexAssetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists assets inside an index.
     * </pre>
     */
    public com.google.cloud.visionai.v1.ViewIndexedAssetsResponse viewIndexedAssets(
        com.google.cloud.visionai.v1.ViewIndexedAssetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getViewIndexedAssetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an Index under the corpus.
     * </pre>
     */
    public com.google.longrunning.Operation createIndex(
        com.google.cloud.visionai.v1.CreateIndexRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateIndexMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an Index under the corpus.
     * Users can perform a metadata-only update or trigger a full index rebuild
     * with different update_mask values.
     * </pre>
     */
    public com.google.longrunning.Operation updateIndex(
        com.google.cloud.visionai.v1.UpdateIndexRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateIndexMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a single Index under a Corpus.
     * </pre>
     */
    public com.google.cloud.visionai.v1.Index getIndex(
        com.google.cloud.visionai.v1.GetIndexRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIndexMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all Indexes in a given Corpus.
     * </pre>
     */
    public com.google.cloud.visionai.v1.ListIndexesResponse listIndexes(
        com.google.cloud.visionai.v1.ListIndexesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListIndexesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single Index. In order to delete an index, the caller must
     * make sure that it is not deployed to any index endpoint.
     * </pre>
     */
    public com.google.longrunning.Operation deleteIndex(
        com.google.cloud.visionai.v1.DeleteIndexRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteIndexMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a corpus inside a project.
     * </pre>
     */
    public com.google.longrunning.Operation createCorpus(
        com.google.cloud.visionai.v1.CreateCorpusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCorpusMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets corpus details inside a project.
     * </pre>
     */
    public com.google.cloud.visionai.v1.Corpus getCorpus(
        com.google.cloud.visionai.v1.GetCorpusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCorpusMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a corpus in a project.
     * </pre>
     */
    public com.google.cloud.visionai.v1.Corpus updateCorpus(
        com.google.cloud.visionai.v1.UpdateCorpusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCorpusMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all corpora in a project.
     * </pre>
     */
    public com.google.cloud.visionai.v1.ListCorporaResponse listCorpora(
        com.google.cloud.visionai.v1.ListCorporaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCorporaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a corpus only if its empty.
     * Returns empty response.
     * </pre>
     */
    public com.google.protobuf.Empty deleteCorpus(
        com.google.cloud.visionai.v1.DeleteCorpusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCorpusMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Analyzes a corpus.
     * </pre>
     */
    public com.google.longrunning.Operation analyzeCorpus(
        com.google.cloud.visionai.v1.AnalyzeCorpusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAnalyzeCorpusMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates data schema inside corpus.
     * </pre>
     */
    public com.google.cloud.visionai.v1.DataSchema createDataSchema(
        com.google.cloud.visionai.v1.CreateDataSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDataSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates data schema inside corpus.
     * </pre>
     */
    public com.google.cloud.visionai.v1.DataSchema updateDataSchema(
        com.google.cloud.visionai.v1.UpdateDataSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDataSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets data schema inside corpus.
     * </pre>
     */
    public com.google.cloud.visionai.v1.DataSchema getDataSchema(
        com.google.cloud.visionai.v1.GetDataSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes data schema inside corpus.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDataSchema(
        com.google.cloud.visionai.v1.DeleteDataSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDataSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists a list of data schemas inside corpus.
     * </pre>
     */
    public com.google.cloud.visionai.v1.ListDataSchemasResponse listDataSchemas(
        com.google.cloud.visionai.v1.ListDataSchemasRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDataSchemasMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates annotation inside asset.
     * </pre>
     */
    public com.google.cloud.visionai.v1.Annotation createAnnotation(
        com.google.cloud.visionai.v1.CreateAnnotationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAnnotationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Reads annotation inside asset.
     * </pre>
     */
    public com.google.cloud.visionai.v1.Annotation getAnnotation(
        com.google.cloud.visionai.v1.GetAnnotationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAnnotationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists a list of annotations inside asset.
     * </pre>
     */
    public com.google.cloud.visionai.v1.ListAnnotationsResponse listAnnotations(
        com.google.cloud.visionai.v1.ListAnnotationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAnnotationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates annotation inside asset.
     * </pre>
     */
    public com.google.cloud.visionai.v1.Annotation updateAnnotation(
        com.google.cloud.visionai.v1.UpdateAnnotationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAnnotationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes annotation inside asset.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAnnotation(
        com.google.cloud.visionai.v1.DeleteAnnotationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAnnotationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generates clips for downloading. The api takes in a time range, and
     * generates a clip of the first content available after start_time and
     * before end_time, which may overflow beyond these bounds.
     * Returned clips are truncated if the total size of the clips are larger
     * than 100MB.
     * </pre>
     */
    public com.google.cloud.visionai.v1.ClipAssetResponse clipAsset(
        com.google.cloud.visionai.v1.ClipAssetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getClipAssetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generates a uri for an HLS manifest. The api takes in a collection of time
     * ranges, and generates a URI for an HLS manifest that covers all the
     * requested time ranges.
     * </pre>
     */
    public com.google.cloud.visionai.v1.GenerateHlsUriResponse generateHlsUri(
        com.google.cloud.visionai.v1.GenerateHlsUriRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateHlsUriMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports assets (images plus annotations) from a meta file on cloud storage.
     * Each row in the meta file is corresponding to an image (specified by a
     * cloud storage uri) and its annotations.
     * </pre>
     */
    public com.google.longrunning.Operation importAssets(
        com.google.cloud.visionai.v1.ImportAssetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportAssetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a search configuration inside a corpus.
     * Please follow the rules below to create a valid CreateSearchConfigRequest.
     * --- General Rules ---
     * 1. Request.search_config_id must not be associated with an existing
     *    SearchConfig.
     * 2. Request must contain at least one non-empty search_criteria_property or
     *    facet_property.
     * 3. mapped_fields must not be empty, and must map to existing UGA keys.
     * 4. All mapped_fields must be of the same type.
     * 5. All mapped_fields must share the same granularity.
     * 6. All mapped_fields must share the same semantic SearchConfig match
     *    options.
     * For property-specific rules, please reference the comments for
     * FacetProperty and SearchCriteriaProperty.
     * </pre>
     */
    public com.google.cloud.visionai.v1.SearchConfig createSearchConfig(
        com.google.cloud.visionai.v1.CreateSearchConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSearchConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a search configuration inside a corpus.
     * Please follow the rules below to create a valid UpdateSearchConfigRequest.
     * --- General Rules ---
     * 1. Request.search_configuration.name must already exist.
     * 2. Request must contain at least one non-empty search_criteria_property or
     * facet_property.
     * 3. mapped_fields must not be empty, and must map to existing UGA keys.
     * 4. All mapped_fields must be of the same type.
     * 5. All mapped_fields must share the same granularity.
     * 6. All mapped_fields must share the same semantic SearchConfig match
     *    options.
     * For property-specific rules, please reference the comments for
     * FacetProperty and SearchCriteriaProperty.
     * </pre>
     */
    public com.google.cloud.visionai.v1.SearchConfig updateSearchConfig(
        com.google.cloud.visionai.v1.UpdateSearchConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSearchConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a search configuration inside a corpus.
     * </pre>
     */
    public com.google.cloud.visionai.v1.SearchConfig getSearchConfig(
        com.google.cloud.visionai.v1.GetSearchConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSearchConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a search configuration inside a corpus.
     * For a DeleteSearchConfigRequest to be valid,
     * Request.search_configuration.name must already exist.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSearchConfig(
        com.google.cloud.visionai.v1.DeleteSearchConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSearchConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all search configurations inside a corpus.
     * </pre>
     */
    public com.google.cloud.visionai.v1.ListSearchConfigsResponse listSearchConfigs(
        com.google.cloud.visionai.v1.ListSearchConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSearchConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a SearchHypernym inside a corpus.
     * </pre>
     */
    public com.google.cloud.visionai.v1.SearchHypernym createSearchHypernym(
        com.google.cloud.visionai.v1.CreateSearchHypernymRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSearchHypernymMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a SearchHypernym inside a corpus.
     * </pre>
     */
    public com.google.cloud.visionai.v1.SearchHypernym updateSearchHypernym(
        com.google.cloud.visionai.v1.UpdateSearchHypernymRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSearchHypernymMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a SearchHypernym inside a corpus.
     * </pre>
     */
    public com.google.cloud.visionai.v1.SearchHypernym getSearchHypernym(
        com.google.cloud.visionai.v1.GetSearchHypernymRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSearchHypernymMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a SearchHypernym inside a corpus.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSearchHypernym(
        com.google.cloud.visionai.v1.DeleteSearchHypernymRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSearchHypernymMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists SearchHypernyms inside a corpus.
     * </pre>
     */
    public com.google.cloud.visionai.v1.ListSearchHypernymsResponse listSearchHypernyms(
        com.google.cloud.visionai.v1.ListSearchHypernymsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSearchHypernymsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Search media asset.
     * </pre>
     */
    public com.google.cloud.visionai.v1.SearchAssetsResponse searchAssets(
        com.google.cloud.visionai.v1.SearchAssetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchAssetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Search a deployed index endpoint (IMAGE corpus type only).
     * </pre>
     */
    public com.google.cloud.visionai.v1.SearchIndexEndpointResponse searchIndexEndpoint(
        com.google.cloud.visionai.v1.SearchIndexEndpointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchIndexEndpointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an IndexEndpoint.
     * </pre>
     */
    public com.google.longrunning.Operation createIndexEndpoint(
        com.google.cloud.visionai.v1.CreateIndexEndpointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateIndexEndpointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an IndexEndpoint.
     * </pre>
     */
    public com.google.cloud.visionai.v1.IndexEndpoint getIndexEndpoint(
        com.google.cloud.visionai.v1.GetIndexEndpointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIndexEndpointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all IndexEndpoints in a project.
     * </pre>
     */
    public com.google.cloud.visionai.v1.ListIndexEndpointsResponse listIndexEndpoints(
        com.google.cloud.visionai.v1.ListIndexEndpointsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListIndexEndpointsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an IndexEndpoint.
     * </pre>
     */
    public com.google.longrunning.Operation updateIndexEndpoint(
        com.google.cloud.visionai.v1.UpdateIndexEndpointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateIndexEndpointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an IndexEndpoint.
     * </pre>
     */
    public com.google.longrunning.Operation deleteIndexEndpoint(
        com.google.cloud.visionai.v1.DeleteIndexEndpointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteIndexEndpointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deploys an Index to IndexEndpoint.
     * </pre>
     */
    public com.google.longrunning.Operation deployIndex(
        com.google.cloud.visionai.v1.DeployIndexRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeployIndexMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Undeploys an Index from IndexEndpoint.
     * </pre>
     */
    public com.google.longrunning.Operation undeployIndex(
        com.google.cloud.visionai.v1.UndeployIndexRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeployIndexMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a collection.
     * </pre>
     */
    public com.google.longrunning.Operation createCollection(
        com.google.cloud.visionai.v1.CreateCollectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCollectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a collection.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCollection(
        com.google.cloud.visionai.v1.DeleteCollectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCollectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a collection.
     * </pre>
     */
    public com.google.cloud.visionai.v1.Collection getCollection(
        com.google.cloud.visionai.v1.GetCollectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCollectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a collection.
     * </pre>
     */
    public com.google.cloud.visionai.v1.Collection updateCollection(
        com.google.cloud.visionai.v1.UpdateCollectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCollectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists collections inside a corpus.
     * </pre>
     */
    public com.google.cloud.visionai.v1.ListCollectionsResponse listCollections(
        com.google.cloud.visionai.v1.ListCollectionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCollectionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds an item into a Collection.
     * </pre>
     */
    public com.google.cloud.visionai.v1.AddCollectionItemResponse addCollectionItem(
        com.google.cloud.visionai.v1.AddCollectionItemRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddCollectionItemMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Removes an item from a collection.
     * </pre>
     */
    public com.google.cloud.visionai.v1.RemoveCollectionItemResponse removeCollectionItem(
        com.google.cloud.visionai.v1.RemoveCollectionItemRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveCollectionItemMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * View items inside a collection.
     * </pre>
     */
    public com.google.cloud.visionai.v1.ViewCollectionItemsResponse viewCollectionItems(
        com.google.cloud.visionai.v1.ViewCollectionItemsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getViewCollectionItemsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Warehouse.
   *
   * <pre>
   * Service that manages media content + metadata for streaming.
   * </pre>
   */
  public static final class WarehouseFutureStub
      extends io.grpc.stub.AbstractFutureStub<WarehouseFutureStub> {
    private WarehouseFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WarehouseFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WarehouseFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an asset inside corpus.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.visionai.v1.Asset>
        createAsset(com.google.cloud.visionai.v1.CreateAssetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAssetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an asset inside corpus.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.visionai.v1.Asset>
        updateAsset(com.google.cloud.visionai.v1.UpdateAssetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAssetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Reads an asset inside corpus.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.visionai.v1.Asset>
        getAsset(com.google.cloud.visionai.v1.GetAssetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAssetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists an list of assets inside corpus.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.ListAssetsResponse>
        listAssets(com.google.cloud.visionai.v1.ListAssetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAssetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes asset inside corpus.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteAsset(com.google.cloud.visionai.v1.DeleteAssetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAssetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Upload asset by specifing the asset Cloud Storage uri.
     * For video warehouse, it requires users who call this API have read access
     * to the cloud storage file. Once it is uploaded, it can be retrieved by
     * GenerateRetrievalUrl API which by default, only can retrieve cloud storage
     * files from the same project of the warehouse. To allow retrieval cloud
     * storage files that are in a separate project, it requires to find the
     * vision ai service account (Go to IAM, check checkbox to show "Include
     * Google-provided role grants", search for "Cloud Vision AI Service Agent")
     * and grant the read access of the cloud storage files to that service
     * account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        uploadAsset(com.google.cloud.visionai.v1.UploadAssetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUploadAssetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Generates a signed url for downloading the asset.
     * For video warehouse, please see comment of UploadAsset about how to allow
     * retrieval of cloud storage files in a different project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.GenerateRetrievalUrlResponse>
        generateRetrievalUrl(com.google.cloud.visionai.v1.GenerateRetrievalUrlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateRetrievalUrlMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Analyze asset to power search capability.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        analyzeAsset(com.google.cloud.visionai.v1.AnalyzeAssetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAnalyzeAssetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Index one asset for search.
     * Supported corpus type: Corpus.Type.VIDEO_ON_DEMAND
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        indexAsset(com.google.cloud.visionai.v1.IndexAssetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getIndexAssetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Remove one asset's index data for search.
     * Supported corpus type: Corpus.Type.VIDEO_ON_DEMAND
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        removeIndexAsset(com.google.cloud.visionai.v1.RemoveIndexAssetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveIndexAssetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists assets inside an index.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.ViewIndexedAssetsResponse>
        viewIndexedAssets(com.google.cloud.visionai.v1.ViewIndexedAssetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getViewIndexedAssetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an Index under the corpus.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createIndex(com.google.cloud.visionai.v1.CreateIndexRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateIndexMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an Index under the corpus.
     * Users can perform a metadata-only update or trigger a full index rebuild
     * with different update_mask values.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateIndex(com.google.cloud.visionai.v1.UpdateIndexRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateIndexMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a single Index under a Corpus.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.visionai.v1.Index>
        getIndex(com.google.cloud.visionai.v1.GetIndexRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIndexMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List all Indexes in a given Corpus.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.ListIndexesResponse>
        listIndexes(com.google.cloud.visionai.v1.ListIndexesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListIndexesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single Index. In order to delete an index, the caller must
     * make sure that it is not deployed to any index endpoint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteIndex(com.google.cloud.visionai.v1.DeleteIndexRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteIndexMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a corpus inside a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createCorpus(com.google.cloud.visionai.v1.CreateCorpusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCorpusMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets corpus details inside a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.visionai.v1.Corpus>
        getCorpus(com.google.cloud.visionai.v1.GetCorpusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCorpusMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a corpus in a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.visionai.v1.Corpus>
        updateCorpus(com.google.cloud.visionai.v1.UpdateCorpusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCorpusMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all corpora in a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.ListCorporaResponse>
        listCorpora(com.google.cloud.visionai.v1.ListCorporaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCorporaMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a corpus only if its empty.
     * Returns empty response.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteCorpus(com.google.cloud.visionai.v1.DeleteCorpusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCorpusMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Analyzes a corpus.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        analyzeCorpus(com.google.cloud.visionai.v1.AnalyzeCorpusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAnalyzeCorpusMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates data schema inside corpus.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.DataSchema>
        createDataSchema(com.google.cloud.visionai.v1.CreateDataSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDataSchemaMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates data schema inside corpus.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.DataSchema>
        updateDataSchema(com.google.cloud.visionai.v1.UpdateDataSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDataSchemaMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets data schema inside corpus.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.DataSchema>
        getDataSchema(com.google.cloud.visionai.v1.GetDataSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataSchemaMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes data schema inside corpus.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteDataSchema(com.google.cloud.visionai.v1.DeleteDataSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDataSchemaMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists a list of data schemas inside corpus.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.ListDataSchemasResponse>
        listDataSchemas(com.google.cloud.visionai.v1.ListDataSchemasRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDataSchemasMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates annotation inside asset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.Annotation>
        createAnnotation(com.google.cloud.visionai.v1.CreateAnnotationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAnnotationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Reads annotation inside asset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.Annotation>
        getAnnotation(com.google.cloud.visionai.v1.GetAnnotationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAnnotationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists a list of annotations inside asset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.ListAnnotationsResponse>
        listAnnotations(com.google.cloud.visionai.v1.ListAnnotationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAnnotationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates annotation inside asset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.Annotation>
        updateAnnotation(com.google.cloud.visionai.v1.UpdateAnnotationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAnnotationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes annotation inside asset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteAnnotation(com.google.cloud.visionai.v1.DeleteAnnotationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAnnotationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Generates clips for downloading. The api takes in a time range, and
     * generates a clip of the first content available after start_time and
     * before end_time, which may overflow beyond these bounds.
     * Returned clips are truncated if the total size of the clips are larger
     * than 100MB.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.ClipAssetResponse>
        clipAsset(com.google.cloud.visionai.v1.ClipAssetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getClipAssetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Generates a uri for an HLS manifest. The api takes in a collection of time
     * ranges, and generates a URI for an HLS manifest that covers all the
     * requested time ranges.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.GenerateHlsUriResponse>
        generateHlsUri(com.google.cloud.visionai.v1.GenerateHlsUriRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateHlsUriMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Imports assets (images plus annotations) from a meta file on cloud storage.
     * Each row in the meta file is corresponding to an image (specified by a
     * cloud storage uri) and its annotations.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importAssets(com.google.cloud.visionai.v1.ImportAssetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportAssetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a search configuration inside a corpus.
     * Please follow the rules below to create a valid CreateSearchConfigRequest.
     * --- General Rules ---
     * 1. Request.search_config_id must not be associated with an existing
     *    SearchConfig.
     * 2. Request must contain at least one non-empty search_criteria_property or
     *    facet_property.
     * 3. mapped_fields must not be empty, and must map to existing UGA keys.
     * 4. All mapped_fields must be of the same type.
     * 5. All mapped_fields must share the same granularity.
     * 6. All mapped_fields must share the same semantic SearchConfig match
     *    options.
     * For property-specific rules, please reference the comments for
     * FacetProperty and SearchCriteriaProperty.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.SearchConfig>
        createSearchConfig(com.google.cloud.visionai.v1.CreateSearchConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSearchConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a search configuration inside a corpus.
     * Please follow the rules below to create a valid UpdateSearchConfigRequest.
     * --- General Rules ---
     * 1. Request.search_configuration.name must already exist.
     * 2. Request must contain at least one non-empty search_criteria_property or
     * facet_property.
     * 3. mapped_fields must not be empty, and must map to existing UGA keys.
     * 4. All mapped_fields must be of the same type.
     * 5. All mapped_fields must share the same granularity.
     * 6. All mapped_fields must share the same semantic SearchConfig match
     *    options.
     * For property-specific rules, please reference the comments for
     * FacetProperty and SearchCriteriaProperty.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.SearchConfig>
        updateSearchConfig(com.google.cloud.visionai.v1.UpdateSearchConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSearchConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a search configuration inside a corpus.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.SearchConfig>
        getSearchConfig(com.google.cloud.visionai.v1.GetSearchConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSearchConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a search configuration inside a corpus.
     * For a DeleteSearchConfigRequest to be valid,
     * Request.search_configuration.name must already exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteSearchConfig(com.google.cloud.visionai.v1.DeleteSearchConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSearchConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all search configurations inside a corpus.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.ListSearchConfigsResponse>
        listSearchConfigs(com.google.cloud.visionai.v1.ListSearchConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSearchConfigsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a SearchHypernym inside a corpus.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.SearchHypernym>
        createSearchHypernym(com.google.cloud.visionai.v1.CreateSearchHypernymRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSearchHypernymMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a SearchHypernym inside a corpus.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.SearchHypernym>
        updateSearchHypernym(com.google.cloud.visionai.v1.UpdateSearchHypernymRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSearchHypernymMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a SearchHypernym inside a corpus.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.SearchHypernym>
        getSearchHypernym(com.google.cloud.visionai.v1.GetSearchHypernymRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSearchHypernymMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a SearchHypernym inside a corpus.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteSearchHypernym(com.google.cloud.visionai.v1.DeleteSearchHypernymRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSearchHypernymMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists SearchHypernyms inside a corpus.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.ListSearchHypernymsResponse>
        listSearchHypernyms(com.google.cloud.visionai.v1.ListSearchHypernymsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSearchHypernymsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Search media asset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.SearchAssetsResponse>
        searchAssets(com.google.cloud.visionai.v1.SearchAssetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchAssetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Search a deployed index endpoint (IMAGE corpus type only).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.SearchIndexEndpointResponse>
        searchIndexEndpoint(com.google.cloud.visionai.v1.SearchIndexEndpointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchIndexEndpointMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an IndexEndpoint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createIndexEndpoint(com.google.cloud.visionai.v1.CreateIndexEndpointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateIndexEndpointMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an IndexEndpoint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.IndexEndpoint>
        getIndexEndpoint(com.google.cloud.visionai.v1.GetIndexEndpointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIndexEndpointMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all IndexEndpoints in a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.ListIndexEndpointsResponse>
        listIndexEndpoints(com.google.cloud.visionai.v1.ListIndexEndpointsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListIndexEndpointsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an IndexEndpoint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateIndexEndpoint(com.google.cloud.visionai.v1.UpdateIndexEndpointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateIndexEndpointMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an IndexEndpoint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteIndexEndpoint(com.google.cloud.visionai.v1.DeleteIndexEndpointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteIndexEndpointMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deploys an Index to IndexEndpoint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deployIndex(com.google.cloud.visionai.v1.DeployIndexRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeployIndexMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Undeploys an Index from IndexEndpoint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        undeployIndex(com.google.cloud.visionai.v1.UndeployIndexRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUndeployIndexMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a collection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createCollection(com.google.cloud.visionai.v1.CreateCollectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCollectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a collection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteCollection(com.google.cloud.visionai.v1.DeleteCollectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCollectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a collection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.Collection>
        getCollection(com.google.cloud.visionai.v1.GetCollectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCollectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a collection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.Collection>
        updateCollection(com.google.cloud.visionai.v1.UpdateCollectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCollectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists collections inside a corpus.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.ListCollectionsResponse>
        listCollections(com.google.cloud.visionai.v1.ListCollectionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCollectionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Adds an item into a Collection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.AddCollectionItemResponse>
        addCollectionItem(com.google.cloud.visionai.v1.AddCollectionItemRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddCollectionItemMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Removes an item from a collection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.RemoveCollectionItemResponse>
        removeCollectionItem(com.google.cloud.visionai.v1.RemoveCollectionItemRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveCollectionItemMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * View items inside a collection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.ViewCollectionItemsResponse>
        viewCollectionItems(com.google.cloud.visionai.v1.ViewCollectionItemsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getViewCollectionItemsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ASSET = 0;
  private static final int METHODID_UPDATE_ASSET = 1;
  private static final int METHODID_GET_ASSET = 2;
  private static final int METHODID_LIST_ASSETS = 3;
  private static final int METHODID_DELETE_ASSET = 4;
  private static final int METHODID_UPLOAD_ASSET = 5;
  private static final int METHODID_GENERATE_RETRIEVAL_URL = 6;
  private static final int METHODID_ANALYZE_ASSET = 7;
  private static final int METHODID_INDEX_ASSET = 8;
  private static final int METHODID_REMOVE_INDEX_ASSET = 9;
  private static final int METHODID_VIEW_INDEXED_ASSETS = 10;
  private static final int METHODID_CREATE_INDEX = 11;
  private static final int METHODID_UPDATE_INDEX = 12;
  private static final int METHODID_GET_INDEX = 13;
  private static final int METHODID_LIST_INDEXES = 14;
  private static final int METHODID_DELETE_INDEX = 15;
  private static final int METHODID_CREATE_CORPUS = 16;
  private static final int METHODID_GET_CORPUS = 17;
  private static final int METHODID_UPDATE_CORPUS = 18;
  private static final int METHODID_LIST_CORPORA = 19;
  private static final int METHODID_DELETE_CORPUS = 20;
  private static final int METHODID_ANALYZE_CORPUS = 21;
  private static final int METHODID_CREATE_DATA_SCHEMA = 22;
  private static final int METHODID_UPDATE_DATA_SCHEMA = 23;
  private static final int METHODID_GET_DATA_SCHEMA = 24;
  private static final int METHODID_DELETE_DATA_SCHEMA = 25;
  private static final int METHODID_LIST_DATA_SCHEMAS = 26;
  private static final int METHODID_CREATE_ANNOTATION = 27;
  private static final int METHODID_GET_ANNOTATION = 28;
  private static final int METHODID_LIST_ANNOTATIONS = 29;
  private static final int METHODID_UPDATE_ANNOTATION = 30;
  private static final int METHODID_DELETE_ANNOTATION = 31;
  private static final int METHODID_CLIP_ASSET = 32;
  private static final int METHODID_GENERATE_HLS_URI = 33;
  private static final int METHODID_IMPORT_ASSETS = 34;
  private static final int METHODID_CREATE_SEARCH_CONFIG = 35;
  private static final int METHODID_UPDATE_SEARCH_CONFIG = 36;
  private static final int METHODID_GET_SEARCH_CONFIG = 37;
  private static final int METHODID_DELETE_SEARCH_CONFIG = 38;
  private static final int METHODID_LIST_SEARCH_CONFIGS = 39;
  private static final int METHODID_CREATE_SEARCH_HYPERNYM = 40;
  private static final int METHODID_UPDATE_SEARCH_HYPERNYM = 41;
  private static final int METHODID_GET_SEARCH_HYPERNYM = 42;
  private static final int METHODID_DELETE_SEARCH_HYPERNYM = 43;
  private static final int METHODID_LIST_SEARCH_HYPERNYMS = 44;
  private static final int METHODID_SEARCH_ASSETS = 45;
  private static final int METHODID_SEARCH_INDEX_ENDPOINT = 46;
  private static final int METHODID_CREATE_INDEX_ENDPOINT = 47;
  private static final int METHODID_GET_INDEX_ENDPOINT = 48;
  private static final int METHODID_LIST_INDEX_ENDPOINTS = 49;
  private static final int METHODID_UPDATE_INDEX_ENDPOINT = 50;
  private static final int METHODID_DELETE_INDEX_ENDPOINT = 51;
  private static final int METHODID_DEPLOY_INDEX = 52;
  private static final int METHODID_UNDEPLOY_INDEX = 53;
  private static final int METHODID_CREATE_COLLECTION = 54;
  private static final int METHODID_DELETE_COLLECTION = 55;
  private static final int METHODID_GET_COLLECTION = 56;
  private static final int METHODID_UPDATE_COLLECTION = 57;
  private static final int METHODID_LIST_COLLECTIONS = 58;
  private static final int METHODID_ADD_COLLECTION_ITEM = 59;
  private static final int METHODID_REMOVE_COLLECTION_ITEM = 60;
  private static final int METHODID_VIEW_COLLECTION_ITEMS = 61;
  private static final int METHODID_INGEST_ASSET = 62;

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
        case METHODID_CREATE_ASSET:
          serviceImpl.createAsset(
              (com.google.cloud.visionai.v1.CreateAssetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Asset>) responseObserver);
          break;
        case METHODID_UPDATE_ASSET:
          serviceImpl.updateAsset(
              (com.google.cloud.visionai.v1.UpdateAssetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Asset>) responseObserver);
          break;
        case METHODID_GET_ASSET:
          serviceImpl.getAsset(
              (com.google.cloud.visionai.v1.GetAssetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Asset>) responseObserver);
          break;
        case METHODID_LIST_ASSETS:
          serviceImpl.listAssets(
              (com.google.cloud.visionai.v1.ListAssetsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListAssetsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_ASSET:
          serviceImpl.deleteAsset(
              (com.google.cloud.visionai.v1.DeleteAssetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPLOAD_ASSET:
          serviceImpl.uploadAsset(
              (com.google.cloud.visionai.v1.UploadAssetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GENERATE_RETRIEVAL_URL:
          serviceImpl.generateRetrievalUrl(
              (com.google.cloud.visionai.v1.GenerateRetrievalUrlRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.visionai.v1.GenerateRetrievalUrlResponse>)
                  responseObserver);
          break;
        case METHODID_ANALYZE_ASSET:
          serviceImpl.analyzeAsset(
              (com.google.cloud.visionai.v1.AnalyzeAssetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_INDEX_ASSET:
          serviceImpl.indexAsset(
              (com.google.cloud.visionai.v1.IndexAssetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_REMOVE_INDEX_ASSET:
          serviceImpl.removeIndexAsset(
              (com.google.cloud.visionai.v1.RemoveIndexAssetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_VIEW_INDEXED_ASSETS:
          serviceImpl.viewIndexedAssets(
              (com.google.cloud.visionai.v1.ViewIndexedAssetsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ViewIndexedAssetsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_INDEX:
          serviceImpl.createIndex(
              (com.google.cloud.visionai.v1.CreateIndexRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_INDEX:
          serviceImpl.updateIndex(
              (com.google.cloud.visionai.v1.UpdateIndexRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_INDEX:
          serviceImpl.getIndex(
              (com.google.cloud.visionai.v1.GetIndexRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Index>) responseObserver);
          break;
        case METHODID_LIST_INDEXES:
          serviceImpl.listIndexes(
              (com.google.cloud.visionai.v1.ListIndexesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListIndexesResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_INDEX:
          serviceImpl.deleteIndex(
              (com.google.cloud.visionai.v1.DeleteIndexRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_CORPUS:
          serviceImpl.createCorpus(
              (com.google.cloud.visionai.v1.CreateCorpusRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_CORPUS:
          serviceImpl.getCorpus(
              (com.google.cloud.visionai.v1.GetCorpusRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Corpus>) responseObserver);
          break;
        case METHODID_UPDATE_CORPUS:
          serviceImpl.updateCorpus(
              (com.google.cloud.visionai.v1.UpdateCorpusRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Corpus>) responseObserver);
          break;
        case METHODID_LIST_CORPORA:
          serviceImpl.listCorpora(
              (com.google.cloud.visionai.v1.ListCorporaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListCorporaResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_CORPUS:
          serviceImpl.deleteCorpus(
              (com.google.cloud.visionai.v1.DeleteCorpusRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_ANALYZE_CORPUS:
          serviceImpl.analyzeCorpus(
              (com.google.cloud.visionai.v1.AnalyzeCorpusRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_DATA_SCHEMA:
          serviceImpl.createDataSchema(
              (com.google.cloud.visionai.v1.CreateDataSchemaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.DataSchema>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DATA_SCHEMA:
          serviceImpl.updateDataSchema(
              (com.google.cloud.visionai.v1.UpdateDataSchemaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.DataSchema>)
                  responseObserver);
          break;
        case METHODID_GET_DATA_SCHEMA:
          serviceImpl.getDataSchema(
              (com.google.cloud.visionai.v1.GetDataSchemaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.DataSchema>)
                  responseObserver);
          break;
        case METHODID_DELETE_DATA_SCHEMA:
          serviceImpl.deleteDataSchema(
              (com.google.cloud.visionai.v1.DeleteDataSchemaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_DATA_SCHEMAS:
          serviceImpl.listDataSchemas(
              (com.google.cloud.visionai.v1.ListDataSchemasRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListDataSchemasResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_ANNOTATION:
          serviceImpl.createAnnotation(
              (com.google.cloud.visionai.v1.CreateAnnotationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Annotation>)
                  responseObserver);
          break;
        case METHODID_GET_ANNOTATION:
          serviceImpl.getAnnotation(
              (com.google.cloud.visionai.v1.GetAnnotationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Annotation>)
                  responseObserver);
          break;
        case METHODID_LIST_ANNOTATIONS:
          serviceImpl.listAnnotations(
              (com.google.cloud.visionai.v1.ListAnnotationsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListAnnotationsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ANNOTATION:
          serviceImpl.updateAnnotation(
              (com.google.cloud.visionai.v1.UpdateAnnotationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Annotation>)
                  responseObserver);
          break;
        case METHODID_DELETE_ANNOTATION:
          serviceImpl.deleteAnnotation(
              (com.google.cloud.visionai.v1.DeleteAnnotationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CLIP_ASSET:
          serviceImpl.clipAsset(
              (com.google.cloud.visionai.v1.ClipAssetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ClipAssetResponse>)
                  responseObserver);
          break;
        case METHODID_GENERATE_HLS_URI:
          serviceImpl.generateHlsUri(
              (com.google.cloud.visionai.v1.GenerateHlsUriRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.GenerateHlsUriResponse>)
                  responseObserver);
          break;
        case METHODID_IMPORT_ASSETS:
          serviceImpl.importAssets(
              (com.google.cloud.visionai.v1.ImportAssetsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_SEARCH_CONFIG:
          serviceImpl.createSearchConfig(
              (com.google.cloud.visionai.v1.CreateSearchConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.SearchConfig>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SEARCH_CONFIG:
          serviceImpl.updateSearchConfig(
              (com.google.cloud.visionai.v1.UpdateSearchConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.SearchConfig>)
                  responseObserver);
          break;
        case METHODID_GET_SEARCH_CONFIG:
          serviceImpl.getSearchConfig(
              (com.google.cloud.visionai.v1.GetSearchConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.SearchConfig>)
                  responseObserver);
          break;
        case METHODID_DELETE_SEARCH_CONFIG:
          serviceImpl.deleteSearchConfig(
              (com.google.cloud.visionai.v1.DeleteSearchConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_SEARCH_CONFIGS:
          serviceImpl.listSearchConfigs(
              (com.google.cloud.visionai.v1.ListSearchConfigsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListSearchConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_SEARCH_HYPERNYM:
          serviceImpl.createSearchHypernym(
              (com.google.cloud.visionai.v1.CreateSearchHypernymRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.SearchHypernym>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SEARCH_HYPERNYM:
          serviceImpl.updateSearchHypernym(
              (com.google.cloud.visionai.v1.UpdateSearchHypernymRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.SearchHypernym>)
                  responseObserver);
          break;
        case METHODID_GET_SEARCH_HYPERNYM:
          serviceImpl.getSearchHypernym(
              (com.google.cloud.visionai.v1.GetSearchHypernymRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.SearchHypernym>)
                  responseObserver);
          break;
        case METHODID_DELETE_SEARCH_HYPERNYM:
          serviceImpl.deleteSearchHypernym(
              (com.google.cloud.visionai.v1.DeleteSearchHypernymRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_SEARCH_HYPERNYMS:
          serviceImpl.listSearchHypernyms(
              (com.google.cloud.visionai.v1.ListSearchHypernymsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.visionai.v1.ListSearchHypernymsResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_ASSETS:
          serviceImpl.searchAssets(
              (com.google.cloud.visionai.v1.SearchAssetsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.SearchAssetsResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_INDEX_ENDPOINT:
          serviceImpl.searchIndexEndpoint(
              (com.google.cloud.visionai.v1.SearchIndexEndpointRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.visionai.v1.SearchIndexEndpointResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_INDEX_ENDPOINT:
          serviceImpl.createIndexEndpoint(
              (com.google.cloud.visionai.v1.CreateIndexEndpointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_INDEX_ENDPOINT:
          serviceImpl.getIndexEndpoint(
              (com.google.cloud.visionai.v1.GetIndexEndpointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.IndexEndpoint>)
                  responseObserver);
          break;
        case METHODID_LIST_INDEX_ENDPOINTS:
          serviceImpl.listIndexEndpoints(
              (com.google.cloud.visionai.v1.ListIndexEndpointsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListIndexEndpointsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_INDEX_ENDPOINT:
          serviceImpl.updateIndexEndpoint(
              (com.google.cloud.visionai.v1.UpdateIndexEndpointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_INDEX_ENDPOINT:
          serviceImpl.deleteIndexEndpoint(
              (com.google.cloud.visionai.v1.DeleteIndexEndpointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DEPLOY_INDEX:
          serviceImpl.deployIndex(
              (com.google.cloud.visionai.v1.DeployIndexRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UNDEPLOY_INDEX:
          serviceImpl.undeployIndex(
              (com.google.cloud.visionai.v1.UndeployIndexRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_COLLECTION:
          serviceImpl.createCollection(
              (com.google.cloud.visionai.v1.CreateCollectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_COLLECTION:
          serviceImpl.deleteCollection(
              (com.google.cloud.visionai.v1.DeleteCollectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_COLLECTION:
          serviceImpl.getCollection(
              (com.google.cloud.visionai.v1.GetCollectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Collection>)
                  responseObserver);
          break;
        case METHODID_UPDATE_COLLECTION:
          serviceImpl.updateCollection(
              (com.google.cloud.visionai.v1.UpdateCollectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Collection>)
                  responseObserver);
          break;
        case METHODID_LIST_COLLECTIONS:
          serviceImpl.listCollections(
              (com.google.cloud.visionai.v1.ListCollectionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListCollectionsResponse>)
                  responseObserver);
          break;
        case METHODID_ADD_COLLECTION_ITEM:
          serviceImpl.addCollectionItem(
              (com.google.cloud.visionai.v1.AddCollectionItemRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.AddCollectionItemResponse>)
                  responseObserver);
          break;
        case METHODID_REMOVE_COLLECTION_ITEM:
          serviceImpl.removeCollectionItem(
              (com.google.cloud.visionai.v1.RemoveCollectionItemRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.visionai.v1.RemoveCollectionItemResponse>)
                  responseObserver);
          break;
        case METHODID_VIEW_COLLECTION_ITEMS:
          serviceImpl.viewCollectionItems(
              (com.google.cloud.visionai.v1.ViewCollectionItemsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.visionai.v1.ViewCollectionItemsResponse>)
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
        case METHODID_INGEST_ASSET:
          return (io.grpc.stub.StreamObserver<Req>)
              serviceImpl.ingestAsset(
                  (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.IngestAssetResponse>)
                      responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getCreateAssetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.CreateAssetRequest,
                    com.google.cloud.visionai.v1.Asset>(service, METHODID_CREATE_ASSET)))
        .addMethod(
            getUpdateAssetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.UpdateAssetRequest,
                    com.google.cloud.visionai.v1.Asset>(service, METHODID_UPDATE_ASSET)))
        .addMethod(
            getGetAssetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.GetAssetRequest,
                    com.google.cloud.visionai.v1.Asset>(service, METHODID_GET_ASSET)))
        .addMethod(
            getListAssetsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.ListAssetsRequest,
                    com.google.cloud.visionai.v1.ListAssetsResponse>(
                    service, METHODID_LIST_ASSETS)))
        .addMethod(
            getDeleteAssetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.DeleteAssetRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_ASSET)))
        .addMethod(
            getUploadAssetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.UploadAssetRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPLOAD_ASSET)))
        .addMethod(
            getGenerateRetrievalUrlMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.GenerateRetrievalUrlRequest,
                    com.google.cloud.visionai.v1.GenerateRetrievalUrlResponse>(
                    service, METHODID_GENERATE_RETRIEVAL_URL)))
        .addMethod(
            getAnalyzeAssetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.AnalyzeAssetRequest,
                    com.google.longrunning.Operation>(service, METHODID_ANALYZE_ASSET)))
        .addMethod(
            getIndexAssetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.IndexAssetRequest,
                    com.google.longrunning.Operation>(service, METHODID_INDEX_ASSET)))
        .addMethod(
            getRemoveIndexAssetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.RemoveIndexAssetRequest,
                    com.google.longrunning.Operation>(service, METHODID_REMOVE_INDEX_ASSET)))
        .addMethod(
            getViewIndexedAssetsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.ViewIndexedAssetsRequest,
                    com.google.cloud.visionai.v1.ViewIndexedAssetsResponse>(
                    service, METHODID_VIEW_INDEXED_ASSETS)))
        .addMethod(
            getCreateIndexMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.CreateIndexRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_INDEX)))
        .addMethod(
            getUpdateIndexMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.UpdateIndexRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_INDEX)))
        .addMethod(
            getGetIndexMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.GetIndexRequest,
                    com.google.cloud.visionai.v1.Index>(service, METHODID_GET_INDEX)))
        .addMethod(
            getListIndexesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.ListIndexesRequest,
                    com.google.cloud.visionai.v1.ListIndexesResponse>(
                    service, METHODID_LIST_INDEXES)))
        .addMethod(
            getDeleteIndexMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.DeleteIndexRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_INDEX)))
        .addMethod(
            getCreateCorpusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.CreateCorpusRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_CORPUS)))
        .addMethod(
            getGetCorpusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.GetCorpusRequest,
                    com.google.cloud.visionai.v1.Corpus>(service, METHODID_GET_CORPUS)))
        .addMethod(
            getUpdateCorpusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.UpdateCorpusRequest,
                    com.google.cloud.visionai.v1.Corpus>(service, METHODID_UPDATE_CORPUS)))
        .addMethod(
            getListCorporaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.ListCorporaRequest,
                    com.google.cloud.visionai.v1.ListCorporaResponse>(
                    service, METHODID_LIST_CORPORA)))
        .addMethod(
            getDeleteCorpusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.DeleteCorpusRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_CORPUS)))
        .addMethod(
            getAnalyzeCorpusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.AnalyzeCorpusRequest,
                    com.google.longrunning.Operation>(service, METHODID_ANALYZE_CORPUS)))
        .addMethod(
            getCreateDataSchemaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.CreateDataSchemaRequest,
                    com.google.cloud.visionai.v1.DataSchema>(service, METHODID_CREATE_DATA_SCHEMA)))
        .addMethod(
            getUpdateDataSchemaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.UpdateDataSchemaRequest,
                    com.google.cloud.visionai.v1.DataSchema>(service, METHODID_UPDATE_DATA_SCHEMA)))
        .addMethod(
            getGetDataSchemaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.GetDataSchemaRequest,
                    com.google.cloud.visionai.v1.DataSchema>(service, METHODID_GET_DATA_SCHEMA)))
        .addMethod(
            getDeleteDataSchemaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.DeleteDataSchemaRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_DATA_SCHEMA)))
        .addMethod(
            getListDataSchemasMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.ListDataSchemasRequest,
                    com.google.cloud.visionai.v1.ListDataSchemasResponse>(
                    service, METHODID_LIST_DATA_SCHEMAS)))
        .addMethod(
            getCreateAnnotationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.CreateAnnotationRequest,
                    com.google.cloud.visionai.v1.Annotation>(service, METHODID_CREATE_ANNOTATION)))
        .addMethod(
            getGetAnnotationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.GetAnnotationRequest,
                    com.google.cloud.visionai.v1.Annotation>(service, METHODID_GET_ANNOTATION)))
        .addMethod(
            getListAnnotationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.ListAnnotationsRequest,
                    com.google.cloud.visionai.v1.ListAnnotationsResponse>(
                    service, METHODID_LIST_ANNOTATIONS)))
        .addMethod(
            getUpdateAnnotationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.UpdateAnnotationRequest,
                    com.google.cloud.visionai.v1.Annotation>(service, METHODID_UPDATE_ANNOTATION)))
        .addMethod(
            getDeleteAnnotationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.DeleteAnnotationRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_ANNOTATION)))
        .addMethod(
            getIngestAssetMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.IngestAssetRequest,
                    com.google.cloud.visionai.v1.IngestAssetResponse>(
                    service, METHODID_INGEST_ASSET)))
        .addMethod(
            getClipAssetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.ClipAssetRequest,
                    com.google.cloud.visionai.v1.ClipAssetResponse>(service, METHODID_CLIP_ASSET)))
        .addMethod(
            getGenerateHlsUriMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.GenerateHlsUriRequest,
                    com.google.cloud.visionai.v1.GenerateHlsUriResponse>(
                    service, METHODID_GENERATE_HLS_URI)))
        .addMethod(
            getImportAssetsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.ImportAssetsRequest,
                    com.google.longrunning.Operation>(service, METHODID_IMPORT_ASSETS)))
        .addMethod(
            getCreateSearchConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.CreateSearchConfigRequest,
                    com.google.cloud.visionai.v1.SearchConfig>(
                    service, METHODID_CREATE_SEARCH_CONFIG)))
        .addMethod(
            getUpdateSearchConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.UpdateSearchConfigRequest,
                    com.google.cloud.visionai.v1.SearchConfig>(
                    service, METHODID_UPDATE_SEARCH_CONFIG)))
        .addMethod(
            getGetSearchConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.GetSearchConfigRequest,
                    com.google.cloud.visionai.v1.SearchConfig>(
                    service, METHODID_GET_SEARCH_CONFIG)))
        .addMethod(
            getDeleteSearchConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.DeleteSearchConfigRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_SEARCH_CONFIG)))
        .addMethod(
            getListSearchConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.ListSearchConfigsRequest,
                    com.google.cloud.visionai.v1.ListSearchConfigsResponse>(
                    service, METHODID_LIST_SEARCH_CONFIGS)))
        .addMethod(
            getCreateSearchHypernymMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.CreateSearchHypernymRequest,
                    com.google.cloud.visionai.v1.SearchHypernym>(
                    service, METHODID_CREATE_SEARCH_HYPERNYM)))
        .addMethod(
            getUpdateSearchHypernymMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.UpdateSearchHypernymRequest,
                    com.google.cloud.visionai.v1.SearchHypernym>(
                    service, METHODID_UPDATE_SEARCH_HYPERNYM)))
        .addMethod(
            getGetSearchHypernymMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.GetSearchHypernymRequest,
                    com.google.cloud.visionai.v1.SearchHypernym>(
                    service, METHODID_GET_SEARCH_HYPERNYM)))
        .addMethod(
            getDeleteSearchHypernymMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.DeleteSearchHypernymRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_SEARCH_HYPERNYM)))
        .addMethod(
            getListSearchHypernymsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.ListSearchHypernymsRequest,
                    com.google.cloud.visionai.v1.ListSearchHypernymsResponse>(
                    service, METHODID_LIST_SEARCH_HYPERNYMS)))
        .addMethod(
            getSearchAssetsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.SearchAssetsRequest,
                    com.google.cloud.visionai.v1.SearchAssetsResponse>(
                    service, METHODID_SEARCH_ASSETS)))
        .addMethod(
            getSearchIndexEndpointMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.SearchIndexEndpointRequest,
                    com.google.cloud.visionai.v1.SearchIndexEndpointResponse>(
                    service, METHODID_SEARCH_INDEX_ENDPOINT)))
        .addMethod(
            getCreateIndexEndpointMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.CreateIndexEndpointRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_INDEX_ENDPOINT)))
        .addMethod(
            getGetIndexEndpointMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.GetIndexEndpointRequest,
                    com.google.cloud.visionai.v1.IndexEndpoint>(
                    service, METHODID_GET_INDEX_ENDPOINT)))
        .addMethod(
            getListIndexEndpointsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.ListIndexEndpointsRequest,
                    com.google.cloud.visionai.v1.ListIndexEndpointsResponse>(
                    service, METHODID_LIST_INDEX_ENDPOINTS)))
        .addMethod(
            getUpdateIndexEndpointMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.UpdateIndexEndpointRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_INDEX_ENDPOINT)))
        .addMethod(
            getDeleteIndexEndpointMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.DeleteIndexEndpointRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_INDEX_ENDPOINT)))
        .addMethod(
            getDeployIndexMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.DeployIndexRequest,
                    com.google.longrunning.Operation>(service, METHODID_DEPLOY_INDEX)))
        .addMethod(
            getUndeployIndexMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.UndeployIndexRequest,
                    com.google.longrunning.Operation>(service, METHODID_UNDEPLOY_INDEX)))
        .addMethod(
            getCreateCollectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.CreateCollectionRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_COLLECTION)))
        .addMethod(
            getDeleteCollectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.DeleteCollectionRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_COLLECTION)))
        .addMethod(
            getGetCollectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.GetCollectionRequest,
                    com.google.cloud.visionai.v1.Collection>(service, METHODID_GET_COLLECTION)))
        .addMethod(
            getUpdateCollectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.UpdateCollectionRequest,
                    com.google.cloud.visionai.v1.Collection>(service, METHODID_UPDATE_COLLECTION)))
        .addMethod(
            getListCollectionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.ListCollectionsRequest,
                    com.google.cloud.visionai.v1.ListCollectionsResponse>(
                    service, METHODID_LIST_COLLECTIONS)))
        .addMethod(
            getAddCollectionItemMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.AddCollectionItemRequest,
                    com.google.cloud.visionai.v1.AddCollectionItemResponse>(
                    service, METHODID_ADD_COLLECTION_ITEM)))
        .addMethod(
            getRemoveCollectionItemMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.RemoveCollectionItemRequest,
                    com.google.cloud.visionai.v1.RemoveCollectionItemResponse>(
                    service, METHODID_REMOVE_COLLECTION_ITEM)))
        .addMethod(
            getViewCollectionItemsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.ViewCollectionItemsRequest,
                    com.google.cloud.visionai.v1.ViewCollectionItemsResponse>(
                    service, METHODID_VIEW_COLLECTION_ITEMS)))
        .build();
  }

  private abstract static class WarehouseBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WarehouseBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.visionai.v1.WarehouseProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Warehouse");
    }
  }

  private static final class WarehouseFileDescriptorSupplier
      extends WarehouseBaseDescriptorSupplier {
    WarehouseFileDescriptorSupplier() {}
  }

  private static final class WarehouseMethodDescriptorSupplier
      extends WarehouseBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    WarehouseMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (WarehouseGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new WarehouseFileDescriptorSupplier())
                      .addMethod(getCreateAssetMethod())
                      .addMethod(getUpdateAssetMethod())
                      .addMethod(getGetAssetMethod())
                      .addMethod(getListAssetsMethod())
                      .addMethod(getDeleteAssetMethod())
                      .addMethod(getUploadAssetMethod())
                      .addMethod(getGenerateRetrievalUrlMethod())
                      .addMethod(getAnalyzeAssetMethod())
                      .addMethod(getIndexAssetMethod())
                      .addMethod(getRemoveIndexAssetMethod())
                      .addMethod(getViewIndexedAssetsMethod())
                      .addMethod(getCreateIndexMethod())
                      .addMethod(getUpdateIndexMethod())
                      .addMethod(getGetIndexMethod())
                      .addMethod(getListIndexesMethod())
                      .addMethod(getDeleteIndexMethod())
                      .addMethod(getCreateCorpusMethod())
                      .addMethod(getGetCorpusMethod())
                      .addMethod(getUpdateCorpusMethod())
                      .addMethod(getListCorporaMethod())
                      .addMethod(getDeleteCorpusMethod())
                      .addMethod(getAnalyzeCorpusMethod())
                      .addMethod(getCreateDataSchemaMethod())
                      .addMethod(getUpdateDataSchemaMethod())
                      .addMethod(getGetDataSchemaMethod())
                      .addMethod(getDeleteDataSchemaMethod())
                      .addMethod(getListDataSchemasMethod())
                      .addMethod(getCreateAnnotationMethod())
                      .addMethod(getGetAnnotationMethod())
                      .addMethod(getListAnnotationsMethod())
                      .addMethod(getUpdateAnnotationMethod())
                      .addMethod(getDeleteAnnotationMethod())
                      .addMethod(getIngestAssetMethod())
                      .addMethod(getClipAssetMethod())
                      .addMethod(getGenerateHlsUriMethod())
                      .addMethod(getImportAssetsMethod())
                      .addMethod(getCreateSearchConfigMethod())
                      .addMethod(getUpdateSearchConfigMethod())
                      .addMethod(getGetSearchConfigMethod())
                      .addMethod(getDeleteSearchConfigMethod())
                      .addMethod(getListSearchConfigsMethod())
                      .addMethod(getCreateSearchHypernymMethod())
                      .addMethod(getUpdateSearchHypernymMethod())
                      .addMethod(getGetSearchHypernymMethod())
                      .addMethod(getDeleteSearchHypernymMethod())
                      .addMethod(getListSearchHypernymsMethod())
                      .addMethod(getSearchAssetsMethod())
                      .addMethod(getSearchIndexEndpointMethod())
                      .addMethod(getCreateIndexEndpointMethod())
                      .addMethod(getGetIndexEndpointMethod())
                      .addMethod(getListIndexEndpointsMethod())
                      .addMethod(getUpdateIndexEndpointMethod())
                      .addMethod(getDeleteIndexEndpointMethod())
                      .addMethod(getDeployIndexMethod())
                      .addMethod(getUndeployIndexMethod())
                      .addMethod(getCreateCollectionMethod())
                      .addMethod(getDeleteCollectionMethod())
                      .addMethod(getGetCollectionMethod())
                      .addMethod(getUpdateCollectionMethod())
                      .addMethod(getListCollectionsMethod())
                      .addMethod(getAddCollectionItemMethod())
                      .addMethod(getRemoveCollectionItemMethod())
                      .addMethod(getViewCollectionItemsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
