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
package com.google.cloud.asset.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Asset service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/asset/v1/asset_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AssetServiceGrpc {

  private AssetServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.asset.v1.AssetService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.ExportAssetsRequest, com.google.longrunning.Operation>
      getExportAssetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportAssets",
      requestType = com.google.cloud.asset.v1.ExportAssetsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.ExportAssetsRequest, com.google.longrunning.Operation>
      getExportAssetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.asset.v1.ExportAssetsRequest, com.google.longrunning.Operation>
        getExportAssetsMethod;
    if ((getExportAssetsMethod = AssetServiceGrpc.getExportAssetsMethod) == null) {
      synchronized (AssetServiceGrpc.class) {
        if ((getExportAssetsMethod = AssetServiceGrpc.getExportAssetsMethod) == null) {
          AssetServiceGrpc.getExportAssetsMethod =
              getExportAssetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.asset.v1.ExportAssetsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportAssets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.ExportAssetsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AssetServiceMethodDescriptorSupplier("ExportAssets"))
                      .build();
        }
      }
    }
    return getExportAssetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.ListAssetsRequest, com.google.cloud.asset.v1.ListAssetsResponse>
      getListAssetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAssets",
      requestType = com.google.cloud.asset.v1.ListAssetsRequest.class,
      responseType = com.google.cloud.asset.v1.ListAssetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.ListAssetsRequest, com.google.cloud.asset.v1.ListAssetsResponse>
      getListAssetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.asset.v1.ListAssetsRequest,
            com.google.cloud.asset.v1.ListAssetsResponse>
        getListAssetsMethod;
    if ((getListAssetsMethod = AssetServiceGrpc.getListAssetsMethod) == null) {
      synchronized (AssetServiceGrpc.class) {
        if ((getListAssetsMethod = AssetServiceGrpc.getListAssetsMethod) == null) {
          AssetServiceGrpc.getListAssetsMethod =
              getListAssetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.asset.v1.ListAssetsRequest,
                          com.google.cloud.asset.v1.ListAssetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAssets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.ListAssetsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.ListAssetsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new AssetServiceMethodDescriptorSupplier("ListAssets"))
                      .build();
        }
      }
    }
    return getListAssetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.BatchGetAssetsHistoryRequest,
          com.google.cloud.asset.v1.BatchGetAssetsHistoryResponse>
      getBatchGetAssetsHistoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchGetAssetsHistory",
      requestType = com.google.cloud.asset.v1.BatchGetAssetsHistoryRequest.class,
      responseType = com.google.cloud.asset.v1.BatchGetAssetsHistoryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.BatchGetAssetsHistoryRequest,
          com.google.cloud.asset.v1.BatchGetAssetsHistoryResponse>
      getBatchGetAssetsHistoryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.asset.v1.BatchGetAssetsHistoryRequest,
            com.google.cloud.asset.v1.BatchGetAssetsHistoryResponse>
        getBatchGetAssetsHistoryMethod;
    if ((getBatchGetAssetsHistoryMethod = AssetServiceGrpc.getBatchGetAssetsHistoryMethod)
        == null) {
      synchronized (AssetServiceGrpc.class) {
        if ((getBatchGetAssetsHistoryMethod = AssetServiceGrpc.getBatchGetAssetsHistoryMethod)
            == null) {
          AssetServiceGrpc.getBatchGetAssetsHistoryMethod =
              getBatchGetAssetsHistoryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.asset.v1.BatchGetAssetsHistoryRequest,
                          com.google.cloud.asset.v1.BatchGetAssetsHistoryResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchGetAssetsHistory"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.BatchGetAssetsHistoryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.BatchGetAssetsHistoryResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssetServiceMethodDescriptorSupplier("BatchGetAssetsHistory"))
                      .build();
        }
      }
    }
    return getBatchGetAssetsHistoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.CreateFeedRequest, com.google.cloud.asset.v1.Feed>
      getCreateFeedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFeed",
      requestType = com.google.cloud.asset.v1.CreateFeedRequest.class,
      responseType = com.google.cloud.asset.v1.Feed.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.CreateFeedRequest, com.google.cloud.asset.v1.Feed>
      getCreateFeedMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.asset.v1.CreateFeedRequest, com.google.cloud.asset.v1.Feed>
        getCreateFeedMethod;
    if ((getCreateFeedMethod = AssetServiceGrpc.getCreateFeedMethod) == null) {
      synchronized (AssetServiceGrpc.class) {
        if ((getCreateFeedMethod = AssetServiceGrpc.getCreateFeedMethod) == null) {
          AssetServiceGrpc.getCreateFeedMethod =
              getCreateFeedMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.asset.v1.CreateFeedRequest, com.google.cloud.asset.v1.Feed>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFeed"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.CreateFeedRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.Feed.getDefaultInstance()))
                      .setSchemaDescriptor(new AssetServiceMethodDescriptorSupplier("CreateFeed"))
                      .build();
        }
      }
    }
    return getCreateFeedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.GetFeedRequest, com.google.cloud.asset.v1.Feed>
      getGetFeedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFeed",
      requestType = com.google.cloud.asset.v1.GetFeedRequest.class,
      responseType = com.google.cloud.asset.v1.Feed.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.GetFeedRequest, com.google.cloud.asset.v1.Feed>
      getGetFeedMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.asset.v1.GetFeedRequest, com.google.cloud.asset.v1.Feed>
        getGetFeedMethod;
    if ((getGetFeedMethod = AssetServiceGrpc.getGetFeedMethod) == null) {
      synchronized (AssetServiceGrpc.class) {
        if ((getGetFeedMethod = AssetServiceGrpc.getGetFeedMethod) == null) {
          AssetServiceGrpc.getGetFeedMethod =
              getGetFeedMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.asset.v1.GetFeedRequest, com.google.cloud.asset.v1.Feed>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFeed"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.GetFeedRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.Feed.getDefaultInstance()))
                      .setSchemaDescriptor(new AssetServiceMethodDescriptorSupplier("GetFeed"))
                      .build();
        }
      }
    }
    return getGetFeedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.ListFeedsRequest, com.google.cloud.asset.v1.ListFeedsResponse>
      getListFeedsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFeeds",
      requestType = com.google.cloud.asset.v1.ListFeedsRequest.class,
      responseType = com.google.cloud.asset.v1.ListFeedsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.ListFeedsRequest, com.google.cloud.asset.v1.ListFeedsResponse>
      getListFeedsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.asset.v1.ListFeedsRequest, com.google.cloud.asset.v1.ListFeedsResponse>
        getListFeedsMethod;
    if ((getListFeedsMethod = AssetServiceGrpc.getListFeedsMethod) == null) {
      synchronized (AssetServiceGrpc.class) {
        if ((getListFeedsMethod = AssetServiceGrpc.getListFeedsMethod) == null) {
          AssetServiceGrpc.getListFeedsMethod =
              getListFeedsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.asset.v1.ListFeedsRequest,
                          com.google.cloud.asset.v1.ListFeedsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFeeds"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.ListFeedsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.ListFeedsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new AssetServiceMethodDescriptorSupplier("ListFeeds"))
                      .build();
        }
      }
    }
    return getListFeedsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.UpdateFeedRequest, com.google.cloud.asset.v1.Feed>
      getUpdateFeedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFeed",
      requestType = com.google.cloud.asset.v1.UpdateFeedRequest.class,
      responseType = com.google.cloud.asset.v1.Feed.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.UpdateFeedRequest, com.google.cloud.asset.v1.Feed>
      getUpdateFeedMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.asset.v1.UpdateFeedRequest, com.google.cloud.asset.v1.Feed>
        getUpdateFeedMethod;
    if ((getUpdateFeedMethod = AssetServiceGrpc.getUpdateFeedMethod) == null) {
      synchronized (AssetServiceGrpc.class) {
        if ((getUpdateFeedMethod = AssetServiceGrpc.getUpdateFeedMethod) == null) {
          AssetServiceGrpc.getUpdateFeedMethod =
              getUpdateFeedMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.asset.v1.UpdateFeedRequest, com.google.cloud.asset.v1.Feed>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateFeed"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.UpdateFeedRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.Feed.getDefaultInstance()))
                      .setSchemaDescriptor(new AssetServiceMethodDescriptorSupplier("UpdateFeed"))
                      .build();
        }
      }
    }
    return getUpdateFeedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.DeleteFeedRequest, com.google.protobuf.Empty>
      getDeleteFeedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFeed",
      requestType = com.google.cloud.asset.v1.DeleteFeedRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.DeleteFeedRequest, com.google.protobuf.Empty>
      getDeleteFeedMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.asset.v1.DeleteFeedRequest, com.google.protobuf.Empty>
        getDeleteFeedMethod;
    if ((getDeleteFeedMethod = AssetServiceGrpc.getDeleteFeedMethod) == null) {
      synchronized (AssetServiceGrpc.class) {
        if ((getDeleteFeedMethod = AssetServiceGrpc.getDeleteFeedMethod) == null) {
          AssetServiceGrpc.getDeleteFeedMethod =
              getDeleteFeedMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.asset.v1.DeleteFeedRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteFeed"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.DeleteFeedRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new AssetServiceMethodDescriptorSupplier("DeleteFeed"))
                      .build();
        }
      }
    }
    return getDeleteFeedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.SearchAllResourcesRequest,
          com.google.cloud.asset.v1.SearchAllResourcesResponse>
      getSearchAllResourcesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchAllResources",
      requestType = com.google.cloud.asset.v1.SearchAllResourcesRequest.class,
      responseType = com.google.cloud.asset.v1.SearchAllResourcesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.SearchAllResourcesRequest,
          com.google.cloud.asset.v1.SearchAllResourcesResponse>
      getSearchAllResourcesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.asset.v1.SearchAllResourcesRequest,
            com.google.cloud.asset.v1.SearchAllResourcesResponse>
        getSearchAllResourcesMethod;
    if ((getSearchAllResourcesMethod = AssetServiceGrpc.getSearchAllResourcesMethod) == null) {
      synchronized (AssetServiceGrpc.class) {
        if ((getSearchAllResourcesMethod = AssetServiceGrpc.getSearchAllResourcesMethod) == null) {
          AssetServiceGrpc.getSearchAllResourcesMethod =
              getSearchAllResourcesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.asset.v1.SearchAllResourcesRequest,
                          com.google.cloud.asset.v1.SearchAllResourcesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchAllResources"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.SearchAllResourcesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.SearchAllResourcesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssetServiceMethodDescriptorSupplier("SearchAllResources"))
                      .build();
        }
      }
    }
    return getSearchAllResourcesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.SearchAllIamPoliciesRequest,
          com.google.cloud.asset.v1.SearchAllIamPoliciesResponse>
      getSearchAllIamPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchAllIamPolicies",
      requestType = com.google.cloud.asset.v1.SearchAllIamPoliciesRequest.class,
      responseType = com.google.cloud.asset.v1.SearchAllIamPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.SearchAllIamPoliciesRequest,
          com.google.cloud.asset.v1.SearchAllIamPoliciesResponse>
      getSearchAllIamPoliciesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.asset.v1.SearchAllIamPoliciesRequest,
            com.google.cloud.asset.v1.SearchAllIamPoliciesResponse>
        getSearchAllIamPoliciesMethod;
    if ((getSearchAllIamPoliciesMethod = AssetServiceGrpc.getSearchAllIamPoliciesMethod) == null) {
      synchronized (AssetServiceGrpc.class) {
        if ((getSearchAllIamPoliciesMethod = AssetServiceGrpc.getSearchAllIamPoliciesMethod)
            == null) {
          AssetServiceGrpc.getSearchAllIamPoliciesMethod =
              getSearchAllIamPoliciesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.asset.v1.SearchAllIamPoliciesRequest,
                          com.google.cloud.asset.v1.SearchAllIamPoliciesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SearchAllIamPolicies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.SearchAllIamPoliciesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.SearchAllIamPoliciesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssetServiceMethodDescriptorSupplier("SearchAllIamPolicies"))
                      .build();
        }
      }
    }
    return getSearchAllIamPoliciesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.AnalyzeIamPolicyRequest,
          com.google.cloud.asset.v1.AnalyzeIamPolicyResponse>
      getAnalyzeIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AnalyzeIamPolicy",
      requestType = com.google.cloud.asset.v1.AnalyzeIamPolicyRequest.class,
      responseType = com.google.cloud.asset.v1.AnalyzeIamPolicyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.AnalyzeIamPolicyRequest,
          com.google.cloud.asset.v1.AnalyzeIamPolicyResponse>
      getAnalyzeIamPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.asset.v1.AnalyzeIamPolicyRequest,
            com.google.cloud.asset.v1.AnalyzeIamPolicyResponse>
        getAnalyzeIamPolicyMethod;
    if ((getAnalyzeIamPolicyMethod = AssetServiceGrpc.getAnalyzeIamPolicyMethod) == null) {
      synchronized (AssetServiceGrpc.class) {
        if ((getAnalyzeIamPolicyMethod = AssetServiceGrpc.getAnalyzeIamPolicyMethod) == null) {
          AssetServiceGrpc.getAnalyzeIamPolicyMethod =
              getAnalyzeIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.asset.v1.AnalyzeIamPolicyRequest,
                          com.google.cloud.asset.v1.AnalyzeIamPolicyResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AnalyzeIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.AnalyzeIamPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.AnalyzeIamPolicyResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssetServiceMethodDescriptorSupplier("AnalyzeIamPolicy"))
                      .build();
        }
      }
    }
    return getAnalyzeIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.AnalyzeIamPolicyLongrunningRequest,
          com.google.longrunning.Operation>
      getAnalyzeIamPolicyLongrunningMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AnalyzeIamPolicyLongrunning",
      requestType = com.google.cloud.asset.v1.AnalyzeIamPolicyLongrunningRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.AnalyzeIamPolicyLongrunningRequest,
          com.google.longrunning.Operation>
      getAnalyzeIamPolicyLongrunningMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.asset.v1.AnalyzeIamPolicyLongrunningRequest,
            com.google.longrunning.Operation>
        getAnalyzeIamPolicyLongrunningMethod;
    if ((getAnalyzeIamPolicyLongrunningMethod =
            AssetServiceGrpc.getAnalyzeIamPolicyLongrunningMethod)
        == null) {
      synchronized (AssetServiceGrpc.class) {
        if ((getAnalyzeIamPolicyLongrunningMethod =
                AssetServiceGrpc.getAnalyzeIamPolicyLongrunningMethod)
            == null) {
          AssetServiceGrpc.getAnalyzeIamPolicyLongrunningMethod =
              getAnalyzeIamPolicyLongrunningMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.asset.v1.AnalyzeIamPolicyLongrunningRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "AnalyzeIamPolicyLongrunning"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.AnalyzeIamPolicyLongrunningRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssetServiceMethodDescriptorSupplier("AnalyzeIamPolicyLongrunning"))
                      .build();
        }
      }
    }
    return getAnalyzeIamPolicyLongrunningMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.AnalyzeMoveRequest,
          com.google.cloud.asset.v1.AnalyzeMoveResponse>
      getAnalyzeMoveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AnalyzeMove",
      requestType = com.google.cloud.asset.v1.AnalyzeMoveRequest.class,
      responseType = com.google.cloud.asset.v1.AnalyzeMoveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.AnalyzeMoveRequest,
          com.google.cloud.asset.v1.AnalyzeMoveResponse>
      getAnalyzeMoveMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.asset.v1.AnalyzeMoveRequest,
            com.google.cloud.asset.v1.AnalyzeMoveResponse>
        getAnalyzeMoveMethod;
    if ((getAnalyzeMoveMethod = AssetServiceGrpc.getAnalyzeMoveMethod) == null) {
      synchronized (AssetServiceGrpc.class) {
        if ((getAnalyzeMoveMethod = AssetServiceGrpc.getAnalyzeMoveMethod) == null) {
          AssetServiceGrpc.getAnalyzeMoveMethod =
              getAnalyzeMoveMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.asset.v1.AnalyzeMoveRequest,
                          com.google.cloud.asset.v1.AnalyzeMoveResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AnalyzeMove"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.AnalyzeMoveRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.AnalyzeMoveResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new AssetServiceMethodDescriptorSupplier("AnalyzeMove"))
                      .build();
        }
      }
    }
    return getAnalyzeMoveMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.QueryAssetsRequest,
          com.google.cloud.asset.v1.QueryAssetsResponse>
      getQueryAssetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryAssets",
      requestType = com.google.cloud.asset.v1.QueryAssetsRequest.class,
      responseType = com.google.cloud.asset.v1.QueryAssetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.QueryAssetsRequest,
          com.google.cloud.asset.v1.QueryAssetsResponse>
      getQueryAssetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.asset.v1.QueryAssetsRequest,
            com.google.cloud.asset.v1.QueryAssetsResponse>
        getQueryAssetsMethod;
    if ((getQueryAssetsMethod = AssetServiceGrpc.getQueryAssetsMethod) == null) {
      synchronized (AssetServiceGrpc.class) {
        if ((getQueryAssetsMethod = AssetServiceGrpc.getQueryAssetsMethod) == null) {
          AssetServiceGrpc.getQueryAssetsMethod =
              getQueryAssetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.asset.v1.QueryAssetsRequest,
                          com.google.cloud.asset.v1.QueryAssetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QueryAssets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.QueryAssetsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.QueryAssetsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new AssetServiceMethodDescriptorSupplier("QueryAssets"))
                      .build();
        }
      }
    }
    return getQueryAssetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.CreateSavedQueryRequest, com.google.cloud.asset.v1.SavedQuery>
      getCreateSavedQueryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSavedQuery",
      requestType = com.google.cloud.asset.v1.CreateSavedQueryRequest.class,
      responseType = com.google.cloud.asset.v1.SavedQuery.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.CreateSavedQueryRequest, com.google.cloud.asset.v1.SavedQuery>
      getCreateSavedQueryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.asset.v1.CreateSavedQueryRequest, com.google.cloud.asset.v1.SavedQuery>
        getCreateSavedQueryMethod;
    if ((getCreateSavedQueryMethod = AssetServiceGrpc.getCreateSavedQueryMethod) == null) {
      synchronized (AssetServiceGrpc.class) {
        if ((getCreateSavedQueryMethod = AssetServiceGrpc.getCreateSavedQueryMethod) == null) {
          AssetServiceGrpc.getCreateSavedQueryMethod =
              getCreateSavedQueryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.asset.v1.CreateSavedQueryRequest,
                          com.google.cloud.asset.v1.SavedQuery>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSavedQuery"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.CreateSavedQueryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.SavedQuery.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssetServiceMethodDescriptorSupplier("CreateSavedQuery"))
                      .build();
        }
      }
    }
    return getCreateSavedQueryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.GetSavedQueryRequest, com.google.cloud.asset.v1.SavedQuery>
      getGetSavedQueryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSavedQuery",
      requestType = com.google.cloud.asset.v1.GetSavedQueryRequest.class,
      responseType = com.google.cloud.asset.v1.SavedQuery.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.GetSavedQueryRequest, com.google.cloud.asset.v1.SavedQuery>
      getGetSavedQueryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.asset.v1.GetSavedQueryRequest, com.google.cloud.asset.v1.SavedQuery>
        getGetSavedQueryMethod;
    if ((getGetSavedQueryMethod = AssetServiceGrpc.getGetSavedQueryMethod) == null) {
      synchronized (AssetServiceGrpc.class) {
        if ((getGetSavedQueryMethod = AssetServiceGrpc.getGetSavedQueryMethod) == null) {
          AssetServiceGrpc.getGetSavedQueryMethod =
              getGetSavedQueryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.asset.v1.GetSavedQueryRequest,
                          com.google.cloud.asset.v1.SavedQuery>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSavedQuery"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.GetSavedQueryRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.SavedQuery.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssetServiceMethodDescriptorSupplier("GetSavedQuery"))
                      .build();
        }
      }
    }
    return getGetSavedQueryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.ListSavedQueriesRequest,
          com.google.cloud.asset.v1.ListSavedQueriesResponse>
      getListSavedQueriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSavedQueries",
      requestType = com.google.cloud.asset.v1.ListSavedQueriesRequest.class,
      responseType = com.google.cloud.asset.v1.ListSavedQueriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.ListSavedQueriesRequest,
          com.google.cloud.asset.v1.ListSavedQueriesResponse>
      getListSavedQueriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.asset.v1.ListSavedQueriesRequest,
            com.google.cloud.asset.v1.ListSavedQueriesResponse>
        getListSavedQueriesMethod;
    if ((getListSavedQueriesMethod = AssetServiceGrpc.getListSavedQueriesMethod) == null) {
      synchronized (AssetServiceGrpc.class) {
        if ((getListSavedQueriesMethod = AssetServiceGrpc.getListSavedQueriesMethod) == null) {
          AssetServiceGrpc.getListSavedQueriesMethod =
              getListSavedQueriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.asset.v1.ListSavedQueriesRequest,
                          com.google.cloud.asset.v1.ListSavedQueriesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSavedQueries"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.ListSavedQueriesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.ListSavedQueriesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssetServiceMethodDescriptorSupplier("ListSavedQueries"))
                      .build();
        }
      }
    }
    return getListSavedQueriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.UpdateSavedQueryRequest, com.google.cloud.asset.v1.SavedQuery>
      getUpdateSavedQueryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSavedQuery",
      requestType = com.google.cloud.asset.v1.UpdateSavedQueryRequest.class,
      responseType = com.google.cloud.asset.v1.SavedQuery.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.UpdateSavedQueryRequest, com.google.cloud.asset.v1.SavedQuery>
      getUpdateSavedQueryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.asset.v1.UpdateSavedQueryRequest, com.google.cloud.asset.v1.SavedQuery>
        getUpdateSavedQueryMethod;
    if ((getUpdateSavedQueryMethod = AssetServiceGrpc.getUpdateSavedQueryMethod) == null) {
      synchronized (AssetServiceGrpc.class) {
        if ((getUpdateSavedQueryMethod = AssetServiceGrpc.getUpdateSavedQueryMethod) == null) {
          AssetServiceGrpc.getUpdateSavedQueryMethod =
              getUpdateSavedQueryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.asset.v1.UpdateSavedQueryRequest,
                          com.google.cloud.asset.v1.SavedQuery>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSavedQuery"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.UpdateSavedQueryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.SavedQuery.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssetServiceMethodDescriptorSupplier("UpdateSavedQuery"))
                      .build();
        }
      }
    }
    return getUpdateSavedQueryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.DeleteSavedQueryRequest, com.google.protobuf.Empty>
      getDeleteSavedQueryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSavedQuery",
      requestType = com.google.cloud.asset.v1.DeleteSavedQueryRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.DeleteSavedQueryRequest, com.google.protobuf.Empty>
      getDeleteSavedQueryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.asset.v1.DeleteSavedQueryRequest, com.google.protobuf.Empty>
        getDeleteSavedQueryMethod;
    if ((getDeleteSavedQueryMethod = AssetServiceGrpc.getDeleteSavedQueryMethod) == null) {
      synchronized (AssetServiceGrpc.class) {
        if ((getDeleteSavedQueryMethod = AssetServiceGrpc.getDeleteSavedQueryMethod) == null) {
          AssetServiceGrpc.getDeleteSavedQueryMethod =
              getDeleteSavedQueryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.asset.v1.DeleteSavedQueryRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSavedQuery"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.DeleteSavedQueryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssetServiceMethodDescriptorSupplier("DeleteSavedQuery"))
                      .build();
        }
      }
    }
    return getDeleteSavedQueryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.BatchGetEffectiveIamPoliciesRequest,
          com.google.cloud.asset.v1.BatchGetEffectiveIamPoliciesResponse>
      getBatchGetEffectiveIamPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchGetEffectiveIamPolicies",
      requestType = com.google.cloud.asset.v1.BatchGetEffectiveIamPoliciesRequest.class,
      responseType = com.google.cloud.asset.v1.BatchGetEffectiveIamPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1.BatchGetEffectiveIamPoliciesRequest,
          com.google.cloud.asset.v1.BatchGetEffectiveIamPoliciesResponse>
      getBatchGetEffectiveIamPoliciesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.asset.v1.BatchGetEffectiveIamPoliciesRequest,
            com.google.cloud.asset.v1.BatchGetEffectiveIamPoliciesResponse>
        getBatchGetEffectiveIamPoliciesMethod;
    if ((getBatchGetEffectiveIamPoliciesMethod =
            AssetServiceGrpc.getBatchGetEffectiveIamPoliciesMethod)
        == null) {
      synchronized (AssetServiceGrpc.class) {
        if ((getBatchGetEffectiveIamPoliciesMethod =
                AssetServiceGrpc.getBatchGetEffectiveIamPoliciesMethod)
            == null) {
          AssetServiceGrpc.getBatchGetEffectiveIamPoliciesMethod =
              getBatchGetEffectiveIamPoliciesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.asset.v1.BatchGetEffectiveIamPoliciesRequest,
                          com.google.cloud.asset.v1.BatchGetEffectiveIamPoliciesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchGetEffectiveIamPolicies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.BatchGetEffectiveIamPoliciesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1.BatchGetEffectiveIamPoliciesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssetServiceMethodDescriptorSupplier("BatchGetEffectiveIamPolicies"))
                      .build();
        }
      }
    }
    return getBatchGetEffectiveIamPoliciesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AssetServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AssetServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AssetServiceStub>() {
          @java.lang.Override
          public AssetServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AssetServiceStub(channel, callOptions);
          }
        };
    return AssetServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AssetServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AssetServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AssetServiceBlockingStub>() {
          @java.lang.Override
          public AssetServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AssetServiceBlockingStub(channel, callOptions);
          }
        };
    return AssetServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AssetServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AssetServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AssetServiceFutureStub>() {
          @java.lang.Override
          public AssetServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AssetServiceFutureStub(channel, callOptions);
          }
        };
    return AssetServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Asset service definition.
   * </pre>
   */
  public abstract static class AssetServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Exports assets with time and resource types to a given Cloud Storage
     * location/BigQuery table. For Cloud Storage location destinations, the
     * output format is newline-delimited JSON. Each line represents a
     * [google.cloud.asset.v1.Asset][google.cloud.asset.v1.Asset] in the JSON format; for BigQuery table
     * destinations, the output table stores the fields in asset Protobuf as
     * columns. This API implements the [google.longrunning.Operation][google.longrunning.Operation] API,
     * which allows you to keep track of the export. We recommend intervals of at
     * least 2 seconds with exponential retry to poll the export operation result.
     * For regular-size resource parent, the export operation usually finishes
     * within 5 minutes.
     * </pre>
     */
    public void exportAssets(
        com.google.cloud.asset.v1.ExportAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExportAssetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists assets with time and resource types and returns paged results in
     * response.
     * </pre>
     */
    public void listAssets(
        com.google.cloud.asset.v1.ListAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.ListAssetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAssetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Batch gets the update history of assets that overlap a time window.
     * For IAM_POLICY content, this API outputs history when the asset and its
     * attached IAM POLICY both exist. This can create gaps in the output history.
     * Otherwise, this API outputs history with asset in both non-delete or
     * deleted status.
     * If a specified asset does not exist, this API returns an INVALID_ARGUMENT
     * error.
     * </pre>
     */
    public void batchGetAssetsHistory(
        com.google.cloud.asset.v1.BatchGetAssetsHistoryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.BatchGetAssetsHistoryResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchGetAssetsHistoryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a feed in a parent project/folder/organization to listen to its
     * asset updates.
     * </pre>
     */
    public void createFeed(
        com.google.cloud.asset.v1.CreateFeedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.Feed> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateFeedMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about an asset feed.
     * </pre>
     */
    public void getFeed(
        com.google.cloud.asset.v1.GetFeedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.Feed> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFeedMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all asset feeds in a parent project/folder/organization.
     * </pre>
     */
    public void listFeeds(
        com.google.cloud.asset.v1.ListFeedsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.ListFeedsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListFeedsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an asset feed configuration.
     * </pre>
     */
    public void updateFeed(
        com.google.cloud.asset.v1.UpdateFeedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.Feed> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateFeedMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an asset feed.
     * </pre>
     */
    public void deleteFeed(
        com.google.cloud.asset.v1.DeleteFeedRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteFeedMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches all Cloud resources within the specified scope, such as a project,
     * folder, or organization. The caller must be granted the
     * `cloudasset.assets.searchAllResources` permission on the desired scope,
     * otherwise the request will be rejected.
     * </pre>
     */
    public void searchAllResources(
        com.google.cloud.asset.v1.SearchAllResourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.SearchAllResourcesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchAllResourcesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches all IAM policies within the specified scope, such as a project,
     * folder, or organization. The caller must be granted the
     * `cloudasset.assets.searchAllIamPolicies` permission on the desired scope,
     * otherwise the request will be rejected.
     * </pre>
     */
    public void searchAllIamPolicies(
        com.google.cloud.asset.v1.SearchAllIamPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.SearchAllIamPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchAllIamPoliciesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Analyzes IAM policies to answer which identities have what accesses on
     * which resources.
     * </pre>
     */
    public void analyzeIamPolicy(
        com.google.cloud.asset.v1.AnalyzeIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.AnalyzeIamPolicyResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAnalyzeIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Analyzes IAM policies asynchronously to answer which identities have what
     * accesses on which resources, and writes the analysis results to a Google
     * Cloud Storage or a BigQuery destination. For Cloud Storage destination, the
     * output format is the JSON format that represents a
     * [AnalyzeIamPolicyResponse][google.cloud.asset.v1.AnalyzeIamPolicyResponse]. This method implements the
     * [google.longrunning.Operation][google.longrunning.Operation], which allows you to track the operation
     * status. We recommend intervals of at least 2 seconds with exponential
     * backoff retry to poll the operation result. The metadata contains the
     * metadata for the long-running operation.
     * </pre>
     */
    public void analyzeIamPolicyLongrunning(
        com.google.cloud.asset.v1.AnalyzeIamPolicyLongrunningRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAnalyzeIamPolicyLongrunningMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Analyze moving a resource to a specified destination without kicking off
     * the actual move. The analysis is best effort depending on the user's
     * permissions of viewing different hierarchical policies and configurations.
     * The policies and configuration are subject to change before the actual
     * resource migration takes place.
     * </pre>
     */
    public void analyzeMove(
        com.google.cloud.asset.v1.AnalyzeMoveRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.AnalyzeMoveResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAnalyzeMoveMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Issue a job that queries assets using a SQL statement compatible with
     * [BigQuery Standard
     * SQL](http://cloud/bigquery/docs/reference/standard-sql/enabling-standard-sql).
     * If the query execution finishes within timeout and there's no pagination,
     * the full query results will be returned in the `QueryAssetsResponse`.
     * Otherwise, full query results can be obtained by issuing extra requests
     * with the `job_reference` from the a previous `QueryAssets` call.
     * Note, the query result has approximately 10 GB limitation enforced by
     * BigQuery
     * https://cloud.google.com/bigquery/docs/best-practices-performance-output,
     * queries return larger results will result in errors.
     * </pre>
     */
    public void queryAssets(
        com.google.cloud.asset.v1.QueryAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.QueryAssetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getQueryAssetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a saved query in a parent project/folder/organization.
     * </pre>
     */
    public void createSavedQuery(
        com.google.cloud.asset.v1.CreateSavedQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.SavedQuery> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSavedQueryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a saved query.
     * </pre>
     */
    public void getSavedQuery(
        com.google.cloud.asset.v1.GetSavedQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.SavedQuery> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSavedQueryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all saved queries in a parent project/folder/organization.
     * </pre>
     */
    public void listSavedQueries(
        com.google.cloud.asset.v1.ListSavedQueriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.ListSavedQueriesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSavedQueriesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a saved query.
     * </pre>
     */
    public void updateSavedQuery(
        com.google.cloud.asset.v1.UpdateSavedQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.SavedQuery> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSavedQueryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a saved query.
     * </pre>
     */
    public void deleteSavedQuery(
        com.google.cloud.asset.v1.DeleteSavedQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSavedQueryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets effective IAM policies for a batch of resources.
     * </pre>
     */
    public void batchGetEffectiveIamPolicies(
        com.google.cloud.asset.v1.BatchGetEffectiveIamPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.BatchGetEffectiveIamPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchGetEffectiveIamPoliciesMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getExportAssetsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.asset.v1.ExportAssetsRequest,
                      com.google.longrunning.Operation>(this, METHODID_EXPORT_ASSETS)))
          .addMethod(
              getListAssetsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.asset.v1.ListAssetsRequest,
                      com.google.cloud.asset.v1.ListAssetsResponse>(this, METHODID_LIST_ASSETS)))
          .addMethod(
              getBatchGetAssetsHistoryMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.asset.v1.BatchGetAssetsHistoryRequest,
                      com.google.cloud.asset.v1.BatchGetAssetsHistoryResponse>(
                      this, METHODID_BATCH_GET_ASSETS_HISTORY)))
          .addMethod(
              getCreateFeedMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.asset.v1.CreateFeedRequest, com.google.cloud.asset.v1.Feed>(
                      this, METHODID_CREATE_FEED)))
          .addMethod(
              getGetFeedMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.asset.v1.GetFeedRequest, com.google.cloud.asset.v1.Feed>(
                      this, METHODID_GET_FEED)))
          .addMethod(
              getListFeedsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.asset.v1.ListFeedsRequest,
                      com.google.cloud.asset.v1.ListFeedsResponse>(this, METHODID_LIST_FEEDS)))
          .addMethod(
              getUpdateFeedMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.asset.v1.UpdateFeedRequest, com.google.cloud.asset.v1.Feed>(
                      this, METHODID_UPDATE_FEED)))
          .addMethod(
              getDeleteFeedMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.asset.v1.DeleteFeedRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_FEED)))
          .addMethod(
              getSearchAllResourcesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.asset.v1.SearchAllResourcesRequest,
                      com.google.cloud.asset.v1.SearchAllResourcesResponse>(
                      this, METHODID_SEARCH_ALL_RESOURCES)))
          .addMethod(
              getSearchAllIamPoliciesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.asset.v1.SearchAllIamPoliciesRequest,
                      com.google.cloud.asset.v1.SearchAllIamPoliciesResponse>(
                      this, METHODID_SEARCH_ALL_IAM_POLICIES)))
          .addMethod(
              getAnalyzeIamPolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.asset.v1.AnalyzeIamPolicyRequest,
                      com.google.cloud.asset.v1.AnalyzeIamPolicyResponse>(
                      this, METHODID_ANALYZE_IAM_POLICY)))
          .addMethod(
              getAnalyzeIamPolicyLongrunningMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.asset.v1.AnalyzeIamPolicyLongrunningRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_ANALYZE_IAM_POLICY_LONGRUNNING)))
          .addMethod(
              getAnalyzeMoveMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.asset.v1.AnalyzeMoveRequest,
                      com.google.cloud.asset.v1.AnalyzeMoveResponse>(this, METHODID_ANALYZE_MOVE)))
          .addMethod(
              getQueryAssetsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.asset.v1.QueryAssetsRequest,
                      com.google.cloud.asset.v1.QueryAssetsResponse>(this, METHODID_QUERY_ASSETS)))
          .addMethod(
              getCreateSavedQueryMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.asset.v1.CreateSavedQueryRequest,
                      com.google.cloud.asset.v1.SavedQuery>(this, METHODID_CREATE_SAVED_QUERY)))
          .addMethod(
              getGetSavedQueryMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.asset.v1.GetSavedQueryRequest,
                      com.google.cloud.asset.v1.SavedQuery>(this, METHODID_GET_SAVED_QUERY)))
          .addMethod(
              getListSavedQueriesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.asset.v1.ListSavedQueriesRequest,
                      com.google.cloud.asset.v1.ListSavedQueriesResponse>(
                      this, METHODID_LIST_SAVED_QUERIES)))
          .addMethod(
              getUpdateSavedQueryMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.asset.v1.UpdateSavedQueryRequest,
                      com.google.cloud.asset.v1.SavedQuery>(this, METHODID_UPDATE_SAVED_QUERY)))
          .addMethod(
              getDeleteSavedQueryMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.asset.v1.DeleteSavedQueryRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_SAVED_QUERY)))
          .addMethod(
              getBatchGetEffectiveIamPoliciesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.asset.v1.BatchGetEffectiveIamPoliciesRequest,
                      com.google.cloud.asset.v1.BatchGetEffectiveIamPoliciesResponse>(
                      this, METHODID_BATCH_GET_EFFECTIVE_IAM_POLICIES)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Asset service definition.
   * </pre>
   */
  public static final class AssetServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AssetServiceStub> {
    private AssetServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AssetServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AssetServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Exports assets with time and resource types to a given Cloud Storage
     * location/BigQuery table. For Cloud Storage location destinations, the
     * output format is newline-delimited JSON. Each line represents a
     * [google.cloud.asset.v1.Asset][google.cloud.asset.v1.Asset] in the JSON format; for BigQuery table
     * destinations, the output table stores the fields in asset Protobuf as
     * columns. This API implements the [google.longrunning.Operation][google.longrunning.Operation] API,
     * which allows you to keep track of the export. We recommend intervals of at
     * least 2 seconds with exponential retry to poll the export operation result.
     * For regular-size resource parent, the export operation usually finishes
     * within 5 minutes.
     * </pre>
     */
    public void exportAssets(
        com.google.cloud.asset.v1.ExportAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportAssetsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists assets with time and resource types and returns paged results in
     * response.
     * </pre>
     */
    public void listAssets(
        com.google.cloud.asset.v1.ListAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.ListAssetsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAssetsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Batch gets the update history of assets that overlap a time window.
     * For IAM_POLICY content, this API outputs history when the asset and its
     * attached IAM POLICY both exist. This can create gaps in the output history.
     * Otherwise, this API outputs history with asset in both non-delete or
     * deleted status.
     * If a specified asset does not exist, this API returns an INVALID_ARGUMENT
     * error.
     * </pre>
     */
    public void batchGetAssetsHistory(
        com.google.cloud.asset.v1.BatchGetAssetsHistoryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.BatchGetAssetsHistoryResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchGetAssetsHistoryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a feed in a parent project/folder/organization to listen to its
     * asset updates.
     * </pre>
     */
    public void createFeed(
        com.google.cloud.asset.v1.CreateFeedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.Feed> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFeedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about an asset feed.
     * </pre>
     */
    public void getFeed(
        com.google.cloud.asset.v1.GetFeedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.Feed> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFeedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all asset feeds in a parent project/folder/organization.
     * </pre>
     */
    public void listFeeds(
        com.google.cloud.asset.v1.ListFeedsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.ListFeedsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFeedsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an asset feed configuration.
     * </pre>
     */
    public void updateFeed(
        com.google.cloud.asset.v1.UpdateFeedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.Feed> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFeedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an asset feed.
     * </pre>
     */
    public void deleteFeed(
        com.google.cloud.asset.v1.DeleteFeedRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFeedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches all Cloud resources within the specified scope, such as a project,
     * folder, or organization. The caller must be granted the
     * `cloudasset.assets.searchAllResources` permission on the desired scope,
     * otherwise the request will be rejected.
     * </pre>
     */
    public void searchAllResources(
        com.google.cloud.asset.v1.SearchAllResourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.SearchAllResourcesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchAllResourcesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches all IAM policies within the specified scope, such as a project,
     * folder, or organization. The caller must be granted the
     * `cloudasset.assets.searchAllIamPolicies` permission on the desired scope,
     * otherwise the request will be rejected.
     * </pre>
     */
    public void searchAllIamPolicies(
        com.google.cloud.asset.v1.SearchAllIamPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.SearchAllIamPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchAllIamPoliciesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Analyzes IAM policies to answer which identities have what accesses on
     * which resources.
     * </pre>
     */
    public void analyzeIamPolicy(
        com.google.cloud.asset.v1.AnalyzeIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.AnalyzeIamPolicyResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAnalyzeIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Analyzes IAM policies asynchronously to answer which identities have what
     * accesses on which resources, and writes the analysis results to a Google
     * Cloud Storage or a BigQuery destination. For Cloud Storage destination, the
     * output format is the JSON format that represents a
     * [AnalyzeIamPolicyResponse][google.cloud.asset.v1.AnalyzeIamPolicyResponse]. This method implements the
     * [google.longrunning.Operation][google.longrunning.Operation], which allows you to track the operation
     * status. We recommend intervals of at least 2 seconds with exponential
     * backoff retry to poll the operation result. The metadata contains the
     * metadata for the long-running operation.
     * </pre>
     */
    public void analyzeIamPolicyLongrunning(
        com.google.cloud.asset.v1.AnalyzeIamPolicyLongrunningRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAnalyzeIamPolicyLongrunningMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Analyze moving a resource to a specified destination without kicking off
     * the actual move. The analysis is best effort depending on the user's
     * permissions of viewing different hierarchical policies and configurations.
     * The policies and configuration are subject to change before the actual
     * resource migration takes place.
     * </pre>
     */
    public void analyzeMove(
        com.google.cloud.asset.v1.AnalyzeMoveRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.AnalyzeMoveResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAnalyzeMoveMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Issue a job that queries assets using a SQL statement compatible with
     * [BigQuery Standard
     * SQL](http://cloud/bigquery/docs/reference/standard-sql/enabling-standard-sql).
     * If the query execution finishes within timeout and there's no pagination,
     * the full query results will be returned in the `QueryAssetsResponse`.
     * Otherwise, full query results can be obtained by issuing extra requests
     * with the `job_reference` from the a previous `QueryAssets` call.
     * Note, the query result has approximately 10 GB limitation enforced by
     * BigQuery
     * https://cloud.google.com/bigquery/docs/best-practices-performance-output,
     * queries return larger results will result in errors.
     * </pre>
     */
    public void queryAssets(
        com.google.cloud.asset.v1.QueryAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.QueryAssetsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQueryAssetsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a saved query in a parent project/folder/organization.
     * </pre>
     */
    public void createSavedQuery(
        com.google.cloud.asset.v1.CreateSavedQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.SavedQuery> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSavedQueryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a saved query.
     * </pre>
     */
    public void getSavedQuery(
        com.google.cloud.asset.v1.GetSavedQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.SavedQuery> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSavedQueryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all saved queries in a parent project/folder/organization.
     * </pre>
     */
    public void listSavedQueries(
        com.google.cloud.asset.v1.ListSavedQueriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.ListSavedQueriesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSavedQueriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a saved query.
     * </pre>
     */
    public void updateSavedQuery(
        com.google.cloud.asset.v1.UpdateSavedQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.SavedQuery> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSavedQueryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a saved query.
     * </pre>
     */
    public void deleteSavedQuery(
        com.google.cloud.asset.v1.DeleteSavedQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSavedQueryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets effective IAM policies for a batch of resources.
     * </pre>
     */
    public void batchGetEffectiveIamPolicies(
        com.google.cloud.asset.v1.BatchGetEffectiveIamPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.BatchGetEffectiveIamPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchGetEffectiveIamPoliciesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Asset service definition.
   * </pre>
   */
  public static final class AssetServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AssetServiceBlockingStub> {
    private AssetServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AssetServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AssetServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Exports assets with time and resource types to a given Cloud Storage
     * location/BigQuery table. For Cloud Storage location destinations, the
     * output format is newline-delimited JSON. Each line represents a
     * [google.cloud.asset.v1.Asset][google.cloud.asset.v1.Asset] in the JSON format; for BigQuery table
     * destinations, the output table stores the fields in asset Protobuf as
     * columns. This API implements the [google.longrunning.Operation][google.longrunning.Operation] API,
     * which allows you to keep track of the export. We recommend intervals of at
     * least 2 seconds with exponential retry to poll the export operation result.
     * For regular-size resource parent, the export operation usually finishes
     * within 5 minutes.
     * </pre>
     */
    public com.google.longrunning.Operation exportAssets(
        com.google.cloud.asset.v1.ExportAssetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportAssetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists assets with time and resource types and returns paged results in
     * response.
     * </pre>
     */
    public com.google.cloud.asset.v1.ListAssetsResponse listAssets(
        com.google.cloud.asset.v1.ListAssetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAssetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Batch gets the update history of assets that overlap a time window.
     * For IAM_POLICY content, this API outputs history when the asset and its
     * attached IAM POLICY both exist. This can create gaps in the output history.
     * Otherwise, this API outputs history with asset in both non-delete or
     * deleted status.
     * If a specified asset does not exist, this API returns an INVALID_ARGUMENT
     * error.
     * </pre>
     */
    public com.google.cloud.asset.v1.BatchGetAssetsHistoryResponse batchGetAssetsHistory(
        com.google.cloud.asset.v1.BatchGetAssetsHistoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchGetAssetsHistoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a feed in a parent project/folder/organization to listen to its
     * asset updates.
     * </pre>
     */
    public com.google.cloud.asset.v1.Feed createFeed(
        com.google.cloud.asset.v1.CreateFeedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFeedMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about an asset feed.
     * </pre>
     */
    public com.google.cloud.asset.v1.Feed getFeed(
        com.google.cloud.asset.v1.GetFeedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFeedMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all asset feeds in a parent project/folder/organization.
     * </pre>
     */
    public com.google.cloud.asset.v1.ListFeedsResponse listFeeds(
        com.google.cloud.asset.v1.ListFeedsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFeedsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an asset feed configuration.
     * </pre>
     */
    public com.google.cloud.asset.v1.Feed updateFeed(
        com.google.cloud.asset.v1.UpdateFeedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFeedMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an asset feed.
     * </pre>
     */
    public com.google.protobuf.Empty deleteFeed(
        com.google.cloud.asset.v1.DeleteFeedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFeedMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Searches all Cloud resources within the specified scope, such as a project,
     * folder, or organization. The caller must be granted the
     * `cloudasset.assets.searchAllResources` permission on the desired scope,
     * otherwise the request will be rejected.
     * </pre>
     */
    public com.google.cloud.asset.v1.SearchAllResourcesResponse searchAllResources(
        com.google.cloud.asset.v1.SearchAllResourcesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchAllResourcesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Searches all IAM policies within the specified scope, such as a project,
     * folder, or organization. The caller must be granted the
     * `cloudasset.assets.searchAllIamPolicies` permission on the desired scope,
     * otherwise the request will be rejected.
     * </pre>
     */
    public com.google.cloud.asset.v1.SearchAllIamPoliciesResponse searchAllIamPolicies(
        com.google.cloud.asset.v1.SearchAllIamPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchAllIamPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Analyzes IAM policies to answer which identities have what accesses on
     * which resources.
     * </pre>
     */
    public com.google.cloud.asset.v1.AnalyzeIamPolicyResponse analyzeIamPolicy(
        com.google.cloud.asset.v1.AnalyzeIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAnalyzeIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Analyzes IAM policies asynchronously to answer which identities have what
     * accesses on which resources, and writes the analysis results to a Google
     * Cloud Storage or a BigQuery destination. For Cloud Storage destination, the
     * output format is the JSON format that represents a
     * [AnalyzeIamPolicyResponse][google.cloud.asset.v1.AnalyzeIamPolicyResponse]. This method implements the
     * [google.longrunning.Operation][google.longrunning.Operation], which allows you to track the operation
     * status. We recommend intervals of at least 2 seconds with exponential
     * backoff retry to poll the operation result. The metadata contains the
     * metadata for the long-running operation.
     * </pre>
     */
    public com.google.longrunning.Operation analyzeIamPolicyLongrunning(
        com.google.cloud.asset.v1.AnalyzeIamPolicyLongrunningRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAnalyzeIamPolicyLongrunningMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Analyze moving a resource to a specified destination without kicking off
     * the actual move. The analysis is best effort depending on the user's
     * permissions of viewing different hierarchical policies and configurations.
     * The policies and configuration are subject to change before the actual
     * resource migration takes place.
     * </pre>
     */
    public com.google.cloud.asset.v1.AnalyzeMoveResponse analyzeMove(
        com.google.cloud.asset.v1.AnalyzeMoveRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAnalyzeMoveMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Issue a job that queries assets using a SQL statement compatible with
     * [BigQuery Standard
     * SQL](http://cloud/bigquery/docs/reference/standard-sql/enabling-standard-sql).
     * If the query execution finishes within timeout and there's no pagination,
     * the full query results will be returned in the `QueryAssetsResponse`.
     * Otherwise, full query results can be obtained by issuing extra requests
     * with the `job_reference` from the a previous `QueryAssets` call.
     * Note, the query result has approximately 10 GB limitation enforced by
     * BigQuery
     * https://cloud.google.com/bigquery/docs/best-practices-performance-output,
     * queries return larger results will result in errors.
     * </pre>
     */
    public com.google.cloud.asset.v1.QueryAssetsResponse queryAssets(
        com.google.cloud.asset.v1.QueryAssetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryAssetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a saved query in a parent project/folder/organization.
     * </pre>
     */
    public com.google.cloud.asset.v1.SavedQuery createSavedQuery(
        com.google.cloud.asset.v1.CreateSavedQueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSavedQueryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a saved query.
     * </pre>
     */
    public com.google.cloud.asset.v1.SavedQuery getSavedQuery(
        com.google.cloud.asset.v1.GetSavedQueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSavedQueryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all saved queries in a parent project/folder/organization.
     * </pre>
     */
    public com.google.cloud.asset.v1.ListSavedQueriesResponse listSavedQueries(
        com.google.cloud.asset.v1.ListSavedQueriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSavedQueriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a saved query.
     * </pre>
     */
    public com.google.cloud.asset.v1.SavedQuery updateSavedQuery(
        com.google.cloud.asset.v1.UpdateSavedQueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSavedQueryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a saved query.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSavedQuery(
        com.google.cloud.asset.v1.DeleteSavedQueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSavedQueryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets effective IAM policies for a batch of resources.
     * </pre>
     */
    public com.google.cloud.asset.v1.BatchGetEffectiveIamPoliciesResponse
        batchGetEffectiveIamPolicies(
            com.google.cloud.asset.v1.BatchGetEffectiveIamPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchGetEffectiveIamPoliciesMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Asset service definition.
   * </pre>
   */
  public static final class AssetServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AssetServiceFutureStub> {
    private AssetServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AssetServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AssetServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Exports assets with time and resource types to a given Cloud Storage
     * location/BigQuery table. For Cloud Storage location destinations, the
     * output format is newline-delimited JSON. Each line represents a
     * [google.cloud.asset.v1.Asset][google.cloud.asset.v1.Asset] in the JSON format; for BigQuery table
     * destinations, the output table stores the fields in asset Protobuf as
     * columns. This API implements the [google.longrunning.Operation][google.longrunning.Operation] API,
     * which allows you to keep track of the export. We recommend intervals of at
     * least 2 seconds with exponential retry to poll the export operation result.
     * For regular-size resource parent, the export operation usually finishes
     * within 5 minutes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportAssets(com.google.cloud.asset.v1.ExportAssetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportAssetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists assets with time and resource types and returns paged results in
     * response.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.asset.v1.ListAssetsResponse>
        listAssets(com.google.cloud.asset.v1.ListAssetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAssetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Batch gets the update history of assets that overlap a time window.
     * For IAM_POLICY content, this API outputs history when the asset and its
     * attached IAM POLICY both exist. This can create gaps in the output history.
     * Otherwise, this API outputs history with asset in both non-delete or
     * deleted status.
     * If a specified asset does not exist, this API returns an INVALID_ARGUMENT
     * error.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.asset.v1.BatchGetAssetsHistoryResponse>
        batchGetAssetsHistory(com.google.cloud.asset.v1.BatchGetAssetsHistoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchGetAssetsHistoryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a feed in a parent project/folder/organization to listen to its
     * asset updates.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.asset.v1.Feed>
        createFeed(com.google.cloud.asset.v1.CreateFeedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFeedMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about an asset feed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.asset.v1.Feed>
        getFeed(com.google.cloud.asset.v1.GetFeedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFeedMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all asset feeds in a parent project/folder/organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.asset.v1.ListFeedsResponse>
        listFeeds(com.google.cloud.asset.v1.ListFeedsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFeedsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an asset feed configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.asset.v1.Feed>
        updateFeed(com.google.cloud.asset.v1.UpdateFeedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateFeedMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an asset feed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteFeed(
        com.google.cloud.asset.v1.DeleteFeedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteFeedMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Searches all Cloud resources within the specified scope, such as a project,
     * folder, or organization. The caller must be granted the
     * `cloudasset.assets.searchAllResources` permission on the desired scope,
     * otherwise the request will be rejected.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.asset.v1.SearchAllResourcesResponse>
        searchAllResources(com.google.cloud.asset.v1.SearchAllResourcesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchAllResourcesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Searches all IAM policies within the specified scope, such as a project,
     * folder, or organization. The caller must be granted the
     * `cloudasset.assets.searchAllIamPolicies` permission on the desired scope,
     * otherwise the request will be rejected.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.asset.v1.SearchAllIamPoliciesResponse>
        searchAllIamPolicies(com.google.cloud.asset.v1.SearchAllIamPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchAllIamPoliciesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Analyzes IAM policies to answer which identities have what accesses on
     * which resources.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.asset.v1.AnalyzeIamPolicyResponse>
        analyzeIamPolicy(com.google.cloud.asset.v1.AnalyzeIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAnalyzeIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Analyzes IAM policies asynchronously to answer which identities have what
     * accesses on which resources, and writes the analysis results to a Google
     * Cloud Storage or a BigQuery destination. For Cloud Storage destination, the
     * output format is the JSON format that represents a
     * [AnalyzeIamPolicyResponse][google.cloud.asset.v1.AnalyzeIamPolicyResponse]. This method implements the
     * [google.longrunning.Operation][google.longrunning.Operation], which allows you to track the operation
     * status. We recommend intervals of at least 2 seconds with exponential
     * backoff retry to poll the operation result. The metadata contains the
     * metadata for the long-running operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        analyzeIamPolicyLongrunning(
            com.google.cloud.asset.v1.AnalyzeIamPolicyLongrunningRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAnalyzeIamPolicyLongrunningMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Analyze moving a resource to a specified destination without kicking off
     * the actual move. The analysis is best effort depending on the user's
     * permissions of viewing different hierarchical policies and configurations.
     * The policies and configuration are subject to change before the actual
     * resource migration takes place.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.asset.v1.AnalyzeMoveResponse>
        analyzeMove(com.google.cloud.asset.v1.AnalyzeMoveRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAnalyzeMoveMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Issue a job that queries assets using a SQL statement compatible with
     * [BigQuery Standard
     * SQL](http://cloud/bigquery/docs/reference/standard-sql/enabling-standard-sql).
     * If the query execution finishes within timeout and there's no pagination,
     * the full query results will be returned in the `QueryAssetsResponse`.
     * Otherwise, full query results can be obtained by issuing extra requests
     * with the `job_reference` from the a previous `QueryAssets` call.
     * Note, the query result has approximately 10 GB limitation enforced by
     * BigQuery
     * https://cloud.google.com/bigquery/docs/best-practices-performance-output,
     * queries return larger results will result in errors.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.asset.v1.QueryAssetsResponse>
        queryAssets(com.google.cloud.asset.v1.QueryAssetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQueryAssetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a saved query in a parent project/folder/organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.asset.v1.SavedQuery>
        createSavedQuery(com.google.cloud.asset.v1.CreateSavedQueryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSavedQueryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a saved query.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.asset.v1.SavedQuery>
        getSavedQuery(com.google.cloud.asset.v1.GetSavedQueryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSavedQueryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all saved queries in a parent project/folder/organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.asset.v1.ListSavedQueriesResponse>
        listSavedQueries(com.google.cloud.asset.v1.ListSavedQueriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSavedQueriesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a saved query.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.asset.v1.SavedQuery>
        updateSavedQuery(com.google.cloud.asset.v1.UpdateSavedQueryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSavedQueryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a saved query.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteSavedQuery(com.google.cloud.asset.v1.DeleteSavedQueryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSavedQueryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets effective IAM policies for a batch of resources.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.asset.v1.BatchGetEffectiveIamPoliciesResponse>
        batchGetEffectiveIamPolicies(
            com.google.cloud.asset.v1.BatchGetEffectiveIamPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchGetEffectiveIamPoliciesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_EXPORT_ASSETS = 0;
  private static final int METHODID_LIST_ASSETS = 1;
  private static final int METHODID_BATCH_GET_ASSETS_HISTORY = 2;
  private static final int METHODID_CREATE_FEED = 3;
  private static final int METHODID_GET_FEED = 4;
  private static final int METHODID_LIST_FEEDS = 5;
  private static final int METHODID_UPDATE_FEED = 6;
  private static final int METHODID_DELETE_FEED = 7;
  private static final int METHODID_SEARCH_ALL_RESOURCES = 8;
  private static final int METHODID_SEARCH_ALL_IAM_POLICIES = 9;
  private static final int METHODID_ANALYZE_IAM_POLICY = 10;
  private static final int METHODID_ANALYZE_IAM_POLICY_LONGRUNNING = 11;
  private static final int METHODID_ANALYZE_MOVE = 12;
  private static final int METHODID_QUERY_ASSETS = 13;
  private static final int METHODID_CREATE_SAVED_QUERY = 14;
  private static final int METHODID_GET_SAVED_QUERY = 15;
  private static final int METHODID_LIST_SAVED_QUERIES = 16;
  private static final int METHODID_UPDATE_SAVED_QUERY = 17;
  private static final int METHODID_DELETE_SAVED_QUERY = 18;
  private static final int METHODID_BATCH_GET_EFFECTIVE_IAM_POLICIES = 19;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AssetServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AssetServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_EXPORT_ASSETS:
          serviceImpl.exportAssets(
              (com.google.cloud.asset.v1.ExportAssetsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_ASSETS:
          serviceImpl.listAssets(
              (com.google.cloud.asset.v1.ListAssetsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.ListAssetsResponse>)
                  responseObserver);
          break;
        case METHODID_BATCH_GET_ASSETS_HISTORY:
          serviceImpl.batchGetAssetsHistory(
              (com.google.cloud.asset.v1.BatchGetAssetsHistoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.BatchGetAssetsHistoryResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_FEED:
          serviceImpl.createFeed(
              (com.google.cloud.asset.v1.CreateFeedRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.Feed>) responseObserver);
          break;
        case METHODID_GET_FEED:
          serviceImpl.getFeed(
              (com.google.cloud.asset.v1.GetFeedRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.Feed>) responseObserver);
          break;
        case METHODID_LIST_FEEDS:
          serviceImpl.listFeeds(
              (com.google.cloud.asset.v1.ListFeedsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.ListFeedsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_FEED:
          serviceImpl.updateFeed(
              (com.google.cloud.asset.v1.UpdateFeedRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.Feed>) responseObserver);
          break;
        case METHODID_DELETE_FEED:
          serviceImpl.deleteFeed(
              (com.google.cloud.asset.v1.DeleteFeedRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_SEARCH_ALL_RESOURCES:
          serviceImpl.searchAllResources(
              (com.google.cloud.asset.v1.SearchAllResourcesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.SearchAllResourcesResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_ALL_IAM_POLICIES:
          serviceImpl.searchAllIamPolicies(
              (com.google.cloud.asset.v1.SearchAllIamPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.SearchAllIamPoliciesResponse>)
                  responseObserver);
          break;
        case METHODID_ANALYZE_IAM_POLICY:
          serviceImpl.analyzeIamPolicy(
              (com.google.cloud.asset.v1.AnalyzeIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.AnalyzeIamPolicyResponse>)
                  responseObserver);
          break;
        case METHODID_ANALYZE_IAM_POLICY_LONGRUNNING:
          serviceImpl.analyzeIamPolicyLongrunning(
              (com.google.cloud.asset.v1.AnalyzeIamPolicyLongrunningRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_ANALYZE_MOVE:
          serviceImpl.analyzeMove(
              (com.google.cloud.asset.v1.AnalyzeMoveRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.AnalyzeMoveResponse>)
                  responseObserver);
          break;
        case METHODID_QUERY_ASSETS:
          serviceImpl.queryAssets(
              (com.google.cloud.asset.v1.QueryAssetsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.QueryAssetsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_SAVED_QUERY:
          serviceImpl.createSavedQuery(
              (com.google.cloud.asset.v1.CreateSavedQueryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.SavedQuery>) responseObserver);
          break;
        case METHODID_GET_SAVED_QUERY:
          serviceImpl.getSavedQuery(
              (com.google.cloud.asset.v1.GetSavedQueryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.SavedQuery>) responseObserver);
          break;
        case METHODID_LIST_SAVED_QUERIES:
          serviceImpl.listSavedQueries(
              (com.google.cloud.asset.v1.ListSavedQueriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.ListSavedQueriesResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SAVED_QUERY:
          serviceImpl.updateSavedQuery(
              (com.google.cloud.asset.v1.UpdateSavedQueryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.asset.v1.SavedQuery>) responseObserver);
          break;
        case METHODID_DELETE_SAVED_QUERY:
          serviceImpl.deleteSavedQuery(
              (com.google.cloud.asset.v1.DeleteSavedQueryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_BATCH_GET_EFFECTIVE_IAM_POLICIES:
          serviceImpl.batchGetEffectiveIamPolicies(
              (com.google.cloud.asset.v1.BatchGetEffectiveIamPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.asset.v1.BatchGetEffectiveIamPoliciesResponse>)
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

  private abstract static class AssetServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AssetServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.asset.v1.AssetServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AssetService");
    }
  }

  private static final class AssetServiceFileDescriptorSupplier
      extends AssetServiceBaseDescriptorSupplier {
    AssetServiceFileDescriptorSupplier() {}
  }

  private static final class AssetServiceMethodDescriptorSupplier
      extends AssetServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AssetServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AssetServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AssetServiceFileDescriptorSupplier())
                      .addMethod(getExportAssetsMethod())
                      .addMethod(getListAssetsMethod())
                      .addMethod(getBatchGetAssetsHistoryMethod())
                      .addMethod(getCreateFeedMethod())
                      .addMethod(getGetFeedMethod())
                      .addMethod(getListFeedsMethod())
                      .addMethod(getUpdateFeedMethod())
                      .addMethod(getDeleteFeedMethod())
                      .addMethod(getSearchAllResourcesMethod())
                      .addMethod(getSearchAllIamPoliciesMethod())
                      .addMethod(getAnalyzeIamPolicyMethod())
                      .addMethod(getAnalyzeIamPolicyLongrunningMethod())
                      .addMethod(getAnalyzeMoveMethod())
                      .addMethod(getQueryAssetsMethod())
                      .addMethod(getCreateSavedQueryMethod())
                      .addMethod(getGetSavedQueryMethod())
                      .addMethod(getListSavedQueriesMethod())
                      .addMethod(getUpdateSavedQueryMethod())
                      .addMethod(getDeleteSavedQueryMethod())
                      .addMethod(getBatchGetEffectiveIamPoliciesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
