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
package com.google.cloud.chronicle.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * FeedsService contains procedures for managing Chronicle third-party feeds.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class FeedsServiceGrpc {

  private FeedsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.chronicle.v1.FeedsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.FetchServiceAccountForCustomerRequest,
          com.google.cloud.chronicle.v1.FeedServiceAccount>
      getFetchServiceAccountForCustomerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchServiceAccountForCustomer",
      requestType = com.google.cloud.chronicle.v1.FetchServiceAccountForCustomerRequest.class,
      responseType = com.google.cloud.chronicle.v1.FeedServiceAccount.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.FetchServiceAccountForCustomerRequest,
          com.google.cloud.chronicle.v1.FeedServiceAccount>
      getFetchServiceAccountForCustomerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.FetchServiceAccountForCustomerRequest,
            com.google.cloud.chronicle.v1.FeedServiceAccount>
        getFetchServiceAccountForCustomerMethod;
    if ((getFetchServiceAccountForCustomerMethod =
            FeedsServiceGrpc.getFetchServiceAccountForCustomerMethod)
        == null) {
      synchronized (FeedsServiceGrpc.class) {
        if ((getFetchServiceAccountForCustomerMethod =
                FeedsServiceGrpc.getFetchServiceAccountForCustomerMethod)
            == null) {
          FeedsServiceGrpc.getFetchServiceAccountForCustomerMethod =
              getFetchServiceAccountForCustomerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.FetchServiceAccountForCustomerRequest,
                          com.google.cloud.chronicle.v1.FeedServiceAccount>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "FetchServiceAccountForCustomer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.FetchServiceAccountForCustomerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.FeedServiceAccount
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeedsServiceMethodDescriptorSupplier(
                              "FetchServiceAccountForCustomer"))
                      .build();
        }
      }
    }
    return getFetchServiceAccountForCustomerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.CreateFeedRequest, com.google.cloud.chronicle.v1.Feed>
      getCreateFeedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFeed",
      requestType = com.google.cloud.chronicle.v1.CreateFeedRequest.class,
      responseType = com.google.cloud.chronicle.v1.Feed.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.CreateFeedRequest, com.google.cloud.chronicle.v1.Feed>
      getCreateFeedMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.CreateFeedRequest, com.google.cloud.chronicle.v1.Feed>
        getCreateFeedMethod;
    if ((getCreateFeedMethod = FeedsServiceGrpc.getCreateFeedMethod) == null) {
      synchronized (FeedsServiceGrpc.class) {
        if ((getCreateFeedMethod = FeedsServiceGrpc.getCreateFeedMethod) == null) {
          FeedsServiceGrpc.getCreateFeedMethod =
              getCreateFeedMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.CreateFeedRequest,
                          com.google.cloud.chronicle.v1.Feed>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFeed"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.CreateFeedRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.Feed.getDefaultInstance()))
                      .setSchemaDescriptor(new FeedsServiceMethodDescriptorSupplier("CreateFeed"))
                      .build();
        }
      }
    }
    return getCreateFeedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.GetFeedRequest, com.google.cloud.chronicle.v1.Feed>
      getGetFeedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFeed",
      requestType = com.google.cloud.chronicle.v1.GetFeedRequest.class,
      responseType = com.google.cloud.chronicle.v1.Feed.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.GetFeedRequest, com.google.cloud.chronicle.v1.Feed>
      getGetFeedMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.GetFeedRequest, com.google.cloud.chronicle.v1.Feed>
        getGetFeedMethod;
    if ((getGetFeedMethod = FeedsServiceGrpc.getGetFeedMethod) == null) {
      synchronized (FeedsServiceGrpc.class) {
        if ((getGetFeedMethod = FeedsServiceGrpc.getGetFeedMethod) == null) {
          FeedsServiceGrpc.getGetFeedMethod =
              getGetFeedMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.GetFeedRequest,
                          com.google.cloud.chronicle.v1.Feed>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFeed"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.GetFeedRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.Feed.getDefaultInstance()))
                      .setSchemaDescriptor(new FeedsServiceMethodDescriptorSupplier("GetFeed"))
                      .build();
        }
      }
    }
    return getGetFeedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.DeleteFeedRequest, com.google.protobuf.Empty>
      getDeleteFeedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFeed",
      requestType = com.google.cloud.chronicle.v1.DeleteFeedRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.DeleteFeedRequest, com.google.protobuf.Empty>
      getDeleteFeedMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.DeleteFeedRequest, com.google.protobuf.Empty>
        getDeleteFeedMethod;
    if ((getDeleteFeedMethod = FeedsServiceGrpc.getDeleteFeedMethod) == null) {
      synchronized (FeedsServiceGrpc.class) {
        if ((getDeleteFeedMethod = FeedsServiceGrpc.getDeleteFeedMethod) == null) {
          FeedsServiceGrpc.getDeleteFeedMethod =
              getDeleteFeedMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.DeleteFeedRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteFeed"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.DeleteFeedRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new FeedsServiceMethodDescriptorSupplier("DeleteFeed"))
                      .build();
        }
      }
    }
    return getDeleteFeedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.EnableFeedRequest, com.google.cloud.chronicle.v1.Feed>
      getEnableFeedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EnableFeed",
      requestType = com.google.cloud.chronicle.v1.EnableFeedRequest.class,
      responseType = com.google.cloud.chronicle.v1.Feed.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.EnableFeedRequest, com.google.cloud.chronicle.v1.Feed>
      getEnableFeedMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.EnableFeedRequest, com.google.cloud.chronicle.v1.Feed>
        getEnableFeedMethod;
    if ((getEnableFeedMethod = FeedsServiceGrpc.getEnableFeedMethod) == null) {
      synchronized (FeedsServiceGrpc.class) {
        if ((getEnableFeedMethod = FeedsServiceGrpc.getEnableFeedMethod) == null) {
          FeedsServiceGrpc.getEnableFeedMethod =
              getEnableFeedMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.EnableFeedRequest,
                          com.google.cloud.chronicle.v1.Feed>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EnableFeed"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.EnableFeedRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.Feed.getDefaultInstance()))
                      .setSchemaDescriptor(new FeedsServiceMethodDescriptorSupplier("EnableFeed"))
                      .build();
        }
      }
    }
    return getEnableFeedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.DisableFeedRequest, com.google.cloud.chronicle.v1.Feed>
      getDisableFeedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DisableFeed",
      requestType = com.google.cloud.chronicle.v1.DisableFeedRequest.class,
      responseType = com.google.cloud.chronicle.v1.Feed.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.DisableFeedRequest, com.google.cloud.chronicle.v1.Feed>
      getDisableFeedMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.DisableFeedRequest, com.google.cloud.chronicle.v1.Feed>
        getDisableFeedMethod;
    if ((getDisableFeedMethod = FeedsServiceGrpc.getDisableFeedMethod) == null) {
      synchronized (FeedsServiceGrpc.class) {
        if ((getDisableFeedMethod = FeedsServiceGrpc.getDisableFeedMethod) == null) {
          FeedsServiceGrpc.getDisableFeedMethod =
              getDisableFeedMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.DisableFeedRequest,
                          com.google.cloud.chronicle.v1.Feed>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DisableFeed"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.DisableFeedRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.Feed.getDefaultInstance()))
                      .setSchemaDescriptor(new FeedsServiceMethodDescriptorSupplier("DisableFeed"))
                      .build();
        }
      }
    }
    return getDisableFeedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ListFeedsRequest,
          com.google.cloud.chronicle.v1.ListFeedsResponse>
      getListFeedsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFeeds",
      requestType = com.google.cloud.chronicle.v1.ListFeedsRequest.class,
      responseType = com.google.cloud.chronicle.v1.ListFeedsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ListFeedsRequest,
          com.google.cloud.chronicle.v1.ListFeedsResponse>
      getListFeedsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.ListFeedsRequest,
            com.google.cloud.chronicle.v1.ListFeedsResponse>
        getListFeedsMethod;
    if ((getListFeedsMethod = FeedsServiceGrpc.getListFeedsMethod) == null) {
      synchronized (FeedsServiceGrpc.class) {
        if ((getListFeedsMethod = FeedsServiceGrpc.getListFeedsMethod) == null) {
          FeedsServiceGrpc.getListFeedsMethod =
              getListFeedsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.ListFeedsRequest,
                          com.google.cloud.chronicle.v1.ListFeedsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFeeds"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.ListFeedsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.ListFeedsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new FeedsServiceMethodDescriptorSupplier("ListFeeds"))
                      .build();
        }
      }
    }
    return getListFeedsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ListFeedPacksRequest,
          com.google.cloud.chronicle.v1.ListFeedPacksResponse>
      getListFeedPacksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFeedPacks",
      requestType = com.google.cloud.chronicle.v1.ListFeedPacksRequest.class,
      responseType = com.google.cloud.chronicle.v1.ListFeedPacksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ListFeedPacksRequest,
          com.google.cloud.chronicle.v1.ListFeedPacksResponse>
      getListFeedPacksMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.ListFeedPacksRequest,
            com.google.cloud.chronicle.v1.ListFeedPacksResponse>
        getListFeedPacksMethod;
    if ((getListFeedPacksMethod = FeedsServiceGrpc.getListFeedPacksMethod) == null) {
      synchronized (FeedsServiceGrpc.class) {
        if ((getListFeedPacksMethod = FeedsServiceGrpc.getListFeedPacksMethod) == null) {
          FeedsServiceGrpc.getListFeedPacksMethod =
              getListFeedPacksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.ListFeedPacksRequest,
                          com.google.cloud.chronicle.v1.ListFeedPacksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFeedPacks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.ListFeedPacksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.ListFeedPacksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeedsServiceMethodDescriptorSupplier("ListFeedPacks"))
                      .build();
        }
      }
    }
    return getListFeedPacksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.GetFeedPackRequest, com.google.cloud.chronicle.v1.FeedPack>
      getGetFeedPackMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFeedPack",
      requestType = com.google.cloud.chronicle.v1.GetFeedPackRequest.class,
      responseType = com.google.cloud.chronicle.v1.FeedPack.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.GetFeedPackRequest, com.google.cloud.chronicle.v1.FeedPack>
      getGetFeedPackMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.GetFeedPackRequest,
            com.google.cloud.chronicle.v1.FeedPack>
        getGetFeedPackMethod;
    if ((getGetFeedPackMethod = FeedsServiceGrpc.getGetFeedPackMethod) == null) {
      synchronized (FeedsServiceGrpc.class) {
        if ((getGetFeedPackMethod = FeedsServiceGrpc.getGetFeedPackMethod) == null) {
          FeedsServiceGrpc.getGetFeedPackMethod =
              getGetFeedPackMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.GetFeedPackRequest,
                          com.google.cloud.chronicle.v1.FeedPack>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFeedPack"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.GetFeedPackRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.FeedPack.getDefaultInstance()))
                      .setSchemaDescriptor(new FeedsServiceMethodDescriptorSupplier("GetFeedPack"))
                      .build();
        }
      }
    }
    return getGetFeedPackMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.UpdateFeedRequest, com.google.cloud.chronicle.v1.Feed>
      getUpdateFeedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFeed",
      requestType = com.google.cloud.chronicle.v1.UpdateFeedRequest.class,
      responseType = com.google.cloud.chronicle.v1.Feed.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.UpdateFeedRequest, com.google.cloud.chronicle.v1.Feed>
      getUpdateFeedMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.UpdateFeedRequest, com.google.cloud.chronicle.v1.Feed>
        getUpdateFeedMethod;
    if ((getUpdateFeedMethod = FeedsServiceGrpc.getUpdateFeedMethod) == null) {
      synchronized (FeedsServiceGrpc.class) {
        if ((getUpdateFeedMethod = FeedsServiceGrpc.getUpdateFeedMethod) == null) {
          FeedsServiceGrpc.getUpdateFeedMethod =
              getUpdateFeedMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.UpdateFeedRequest,
                          com.google.cloud.chronicle.v1.Feed>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateFeed"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.UpdateFeedRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.Feed.getDefaultInstance()))
                      .setSchemaDescriptor(new FeedsServiceMethodDescriptorSupplier("UpdateFeed"))
                      .build();
        }
      }
    }
    return getUpdateFeedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasRequest,
          com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasResponse>
      getListFeedSourceTypeSchemasMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFeedSourceTypeSchemas",
      requestType = com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasRequest.class,
      responseType = com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasRequest,
          com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasResponse>
      getListFeedSourceTypeSchemasMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasRequest,
            com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasResponse>
        getListFeedSourceTypeSchemasMethod;
    if ((getListFeedSourceTypeSchemasMethod = FeedsServiceGrpc.getListFeedSourceTypeSchemasMethod)
        == null) {
      synchronized (FeedsServiceGrpc.class) {
        if ((getListFeedSourceTypeSchemasMethod =
                FeedsServiceGrpc.getListFeedSourceTypeSchemasMethod)
            == null) {
          FeedsServiceGrpc.getListFeedSourceTypeSchemasMethod =
              getListFeedSourceTypeSchemasMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasRequest,
                          com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListFeedSourceTypeSchemas"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeedsServiceMethodDescriptorSupplier("ListFeedSourceTypeSchemas"))
                      .build();
        }
      }
    }
    return getListFeedSourceTypeSchemasMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ListLogTypeSchemasRequest,
          com.google.cloud.chronicle.v1.ListLogTypeSchemasResponse>
      getListLogTypeSchemasMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListLogTypeSchemas",
      requestType = com.google.cloud.chronicle.v1.ListLogTypeSchemasRequest.class,
      responseType = com.google.cloud.chronicle.v1.ListLogTypeSchemasResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ListLogTypeSchemasRequest,
          com.google.cloud.chronicle.v1.ListLogTypeSchemasResponse>
      getListLogTypeSchemasMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.ListLogTypeSchemasRequest,
            com.google.cloud.chronicle.v1.ListLogTypeSchemasResponse>
        getListLogTypeSchemasMethod;
    if ((getListLogTypeSchemasMethod = FeedsServiceGrpc.getListLogTypeSchemasMethod) == null) {
      synchronized (FeedsServiceGrpc.class) {
        if ((getListLogTypeSchemasMethod = FeedsServiceGrpc.getListLogTypeSchemasMethod) == null) {
          FeedsServiceGrpc.getListLogTypeSchemasMethod =
              getListLogTypeSchemasMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.ListLogTypeSchemasRequest,
                          com.google.cloud.chronicle.v1.ListLogTypeSchemasResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListLogTypeSchemas"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.ListLogTypeSchemasRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.ListLogTypeSchemasResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeedsServiceMethodDescriptorSupplier("ListLogTypeSchemas"))
                      .build();
        }
      }
    }
    return getListLogTypeSchemasMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ImportPushLogsRequest, com.google.api.HttpBody>
      getImportPushLogsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportPushLogs",
      requestType = com.google.cloud.chronicle.v1.ImportPushLogsRequest.class,
      responseType = com.google.api.HttpBody.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ImportPushLogsRequest, com.google.api.HttpBody>
      getImportPushLogsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.ImportPushLogsRequest, com.google.api.HttpBody>
        getImportPushLogsMethod;
    if ((getImportPushLogsMethod = FeedsServiceGrpc.getImportPushLogsMethod) == null) {
      synchronized (FeedsServiceGrpc.class) {
        if ((getImportPushLogsMethod = FeedsServiceGrpc.getImportPushLogsMethod) == null) {
          FeedsServiceGrpc.getImportPushLogsMethod =
              getImportPushLogsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.ImportPushLogsRequest,
                          com.google.api.HttpBody>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportPushLogs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.ImportPushLogsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.api.HttpBody.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeedsServiceMethodDescriptorSupplier("ImportPushLogs"))
                      .build();
        }
      }
    }
    return getImportPushLogsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.GenerateSecretRequest,
          com.google.cloud.chronicle.v1.GenerateSecretResponse>
      getGenerateSecretMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateSecret",
      requestType = com.google.cloud.chronicle.v1.GenerateSecretRequest.class,
      responseType = com.google.cloud.chronicle.v1.GenerateSecretResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.GenerateSecretRequest,
          com.google.cloud.chronicle.v1.GenerateSecretResponse>
      getGenerateSecretMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.GenerateSecretRequest,
            com.google.cloud.chronicle.v1.GenerateSecretResponse>
        getGenerateSecretMethod;
    if ((getGenerateSecretMethod = FeedsServiceGrpc.getGenerateSecretMethod) == null) {
      synchronized (FeedsServiceGrpc.class) {
        if ((getGenerateSecretMethod = FeedsServiceGrpc.getGenerateSecretMethod) == null) {
          FeedsServiceGrpc.getGenerateSecretMethod =
              getGenerateSecretMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.GenerateSecretRequest,
                          com.google.cloud.chronicle.v1.GenerateSecretResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateSecret"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.GenerateSecretRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.GenerateSecretResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeedsServiceMethodDescriptorSupplier("GenerateSecret"))
                      .build();
        }
      }
    }
    return getGenerateSecretMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static FeedsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeedsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FeedsServiceStub>() {
          @java.lang.Override
          public FeedsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FeedsServiceStub(channel, callOptions);
          }
        };
    return FeedsServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static FeedsServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeedsServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FeedsServiceBlockingV2Stub>() {
          @java.lang.Override
          public FeedsServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FeedsServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return FeedsServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FeedsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeedsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FeedsServiceBlockingStub>() {
          @java.lang.Override
          public FeedsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FeedsServiceBlockingStub(channel, callOptions);
          }
        };
    return FeedsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static FeedsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeedsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FeedsServiceFutureStub>() {
          @java.lang.Override
          public FeedsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FeedsServiceFutureStub(channel, callOptions);
          }
        };
    return FeedsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * FeedsService contains procedures for managing Chronicle third-party feeds.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Fetch Chronicle's service account used for ingesting data from Cloud
     * Storage buckets.
     * </pre>
     */
    default void fetchServiceAccountForCustomer(
        com.google.cloud.chronicle.v1.FetchServiceAccountForCustomerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.FeedServiceAccount>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFetchServiceAccountForCustomerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a feed.
     * </pre>
     */
    default void createFeed(
        com.google.cloud.chronicle.v1.CreateFeedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.Feed> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateFeedMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a feed.
     * </pre>
     */
    default void getFeed(
        com.google.cloud.chronicle.v1.GetFeedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.Feed> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFeedMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a feed.
     * </pre>
     */
    default void deleteFeed(
        com.google.cloud.chronicle.v1.DeleteFeedRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteFeedMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Enable feed for ingestion.
     * </pre>
     */
    default void enableFeed(
        com.google.cloud.chronicle.v1.EnableFeedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.Feed> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEnableFeedMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Disable feed for ingestion. Make FeedState ARCHIVED.
     * </pre>
     */
    default void disableFeed(
        com.google.cloud.chronicle.v1.DisableFeedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.Feed> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDisableFeedMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all feeds for the customer.
     * </pre>
     */
    default void listFeeds(
        com.google.cloud.chronicle.v1.ListFeedsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ListFeedsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListFeedsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Packs for which feeds can be configured.
     * </pre>
     */
    default void listFeedPacks(
        com.google.cloud.chronicle.v1.ListFeedPacksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ListFeedPacksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListFeedPacksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a feed pack.
     * </pre>
     */
    default void getFeedPack(
        com.google.cloud.chronicle.v1.GetFeedPackRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.FeedPack> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetFeedPackMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the full feed.
     * </pre>
     */
    default void updateFeed(
        com.google.cloud.chronicle.v1.UpdateFeedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.Feed> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateFeedMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all FeedSourceTypeSchemas.
     * </pre>
     */
    default void listFeedSourceTypeSchemas(
        com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListFeedSourceTypeSchemasMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all LogTypeSchemas compatible with a given
     * FeedSourceType.
     * </pre>
     */
    default void listLogTypeSchemas(
        com.google.cloud.chronicle.v1.ListLogTypeSchemasRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ListLogTypeSchemasResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListLogTypeSchemasMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Import logs coming from https push feeds.
     * All log entries must be valid UTF-8. A single invalid event will cause the
     * entire request to be rejected.
     * </pre>
     */
    default void importPushLogs(
        com.google.cloud.chronicle.v1.ImportPushLogsRequest request,
        io.grpc.stub.StreamObserver<com.google.api.HttpBody> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportPushLogsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates a new secret for https push feeds which do not support jwt
     * tokens. Secrets once generated should be copied and stored in safe place
     * to be used while configuring https push feeds.Please note that you can
     * always generate a new secret again for a feed using this API but it will
     * invalidate the previously generated secret for the feed.
     * </pre>
     */
    default void generateSecret(
        com.google.cloud.chronicle.v1.GenerateSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.GenerateSecretResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateSecretMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service FeedsService.
   *
   * <pre>
   * FeedsService contains procedures for managing Chronicle third-party feeds.
   * </pre>
   */
  public abstract static class FeedsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return FeedsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service FeedsService.
   *
   * <pre>
   * FeedsService contains procedures for managing Chronicle third-party feeds.
   * </pre>
   */
  public static final class FeedsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<FeedsServiceStub> {
    private FeedsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeedsServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeedsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Fetch Chronicle's service account used for ingesting data from Cloud
     * Storage buckets.
     * </pre>
     */
    public void fetchServiceAccountForCustomer(
        com.google.cloud.chronicle.v1.FetchServiceAccountForCustomerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.FeedServiceAccount>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchServiceAccountForCustomerMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a feed.
     * </pre>
     */
    public void createFeed(
        com.google.cloud.chronicle.v1.CreateFeedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.Feed> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFeedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a feed.
     * </pre>
     */
    public void getFeed(
        com.google.cloud.chronicle.v1.GetFeedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.Feed> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFeedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a feed.
     * </pre>
     */
    public void deleteFeed(
        com.google.cloud.chronicle.v1.DeleteFeedRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFeedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Enable feed for ingestion.
     * </pre>
     */
    public void enableFeed(
        com.google.cloud.chronicle.v1.EnableFeedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.Feed> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEnableFeedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Disable feed for ingestion. Make FeedState ARCHIVED.
     * </pre>
     */
    public void disableFeed(
        com.google.cloud.chronicle.v1.DisableFeedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.Feed> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDisableFeedMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all feeds for the customer.
     * </pre>
     */
    public void listFeeds(
        com.google.cloud.chronicle.v1.ListFeedsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ListFeedsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFeedsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Packs for which feeds can be configured.
     * </pre>
     */
    public void listFeedPacks(
        com.google.cloud.chronicle.v1.ListFeedPacksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ListFeedPacksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFeedPacksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a feed pack.
     * </pre>
     */
    public void getFeedPack(
        com.google.cloud.chronicle.v1.GetFeedPackRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.FeedPack> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFeedPackMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the full feed.
     * </pre>
     */
    public void updateFeed(
        com.google.cloud.chronicle.v1.UpdateFeedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.Feed> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFeedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all FeedSourceTypeSchemas.
     * </pre>
     */
    public void listFeedSourceTypeSchemas(
        com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFeedSourceTypeSchemasMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all LogTypeSchemas compatible with a given
     * FeedSourceType.
     * </pre>
     */
    public void listLogTypeSchemas(
        com.google.cloud.chronicle.v1.ListLogTypeSchemasRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ListLogTypeSchemasResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListLogTypeSchemasMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Import logs coming from https push feeds.
     * All log entries must be valid UTF-8. A single invalid event will cause the
     * entire request to be rejected.
     * </pre>
     */
    public void importPushLogs(
        com.google.cloud.chronicle.v1.ImportPushLogsRequest request,
        io.grpc.stub.StreamObserver<com.google.api.HttpBody> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportPushLogsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates a new secret for https push feeds which do not support jwt
     * tokens. Secrets once generated should be copied and stored in safe place
     * to be used while configuring https push feeds.Please note that you can
     * always generate a new secret again for a feed using this API but it will
     * invalidate the previously generated secret for the feed.
     * </pre>
     */
    public void generateSecret(
        com.google.cloud.chronicle.v1.GenerateSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.GenerateSecretResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateSecretMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service FeedsService.
   *
   * <pre>
   * FeedsService contains procedures for managing Chronicle third-party feeds.
   * </pre>
   */
  public static final class FeedsServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<FeedsServiceBlockingV2Stub> {
    private FeedsServiceBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeedsServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeedsServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Fetch Chronicle's service account used for ingesting data from Cloud
     * Storage buckets.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.FeedServiceAccount fetchServiceAccountForCustomer(
        com.google.cloud.chronicle.v1.FetchServiceAccountForCustomerRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getFetchServiceAccountForCustomerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a feed.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.Feed createFeed(
        com.google.cloud.chronicle.v1.CreateFeedRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateFeedMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a feed.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.Feed getFeed(
        com.google.cloud.chronicle.v1.GetFeedRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetFeedMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a feed.
     * </pre>
     */
    public com.google.protobuf.Empty deleteFeed(
        com.google.cloud.chronicle.v1.DeleteFeedRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteFeedMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Enable feed for ingestion.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.Feed enableFeed(
        com.google.cloud.chronicle.v1.EnableFeedRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getEnableFeedMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Disable feed for ingestion. Make FeedState ARCHIVED.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.Feed disableFeed(
        com.google.cloud.chronicle.v1.DisableFeedRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDisableFeedMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all feeds for the customer.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ListFeedsResponse listFeeds(
        com.google.cloud.chronicle.v1.ListFeedsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListFeedsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Packs for which feeds can be configured.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ListFeedPacksResponse listFeedPacks(
        com.google.cloud.chronicle.v1.ListFeedPacksRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListFeedPacksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a feed pack.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.FeedPack getFeedPack(
        com.google.cloud.chronicle.v1.GetFeedPackRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetFeedPackMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the full feed.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.Feed updateFeed(
        com.google.cloud.chronicle.v1.UpdateFeedRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateFeedMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all FeedSourceTypeSchemas.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasResponse
        listFeedSourceTypeSchemas(
            com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListFeedSourceTypeSchemasMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all LogTypeSchemas compatible with a given
     * FeedSourceType.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ListLogTypeSchemasResponse listLogTypeSchemas(
        com.google.cloud.chronicle.v1.ListLogTypeSchemasRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListLogTypeSchemasMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Import logs coming from https push feeds.
     * All log entries must be valid UTF-8. A single invalid event will cause the
     * entire request to be rejected.
     * </pre>
     */
    public com.google.api.HttpBody importPushLogs(
        com.google.cloud.chronicle.v1.ImportPushLogsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getImportPushLogsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generates a new secret for https push feeds which do not support jwt
     * tokens. Secrets once generated should be copied and stored in safe place
     * to be used while configuring https push feeds.Please note that you can
     * always generate a new secret again for a feed using this API but it will
     * invalidate the previously generated secret for the feed.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.GenerateSecretResponse generateSecret(
        com.google.cloud.chronicle.v1.GenerateSecretRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGenerateSecretMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service FeedsService.
   *
   * <pre>
   * FeedsService contains procedures for managing Chronicle third-party feeds.
   * </pre>
   */
  public static final class FeedsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FeedsServiceBlockingStub> {
    private FeedsServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeedsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeedsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Fetch Chronicle's service account used for ingesting data from Cloud
     * Storage buckets.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.FeedServiceAccount fetchServiceAccountForCustomer(
        com.google.cloud.chronicle.v1.FetchServiceAccountForCustomerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchServiceAccountForCustomerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a feed.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.Feed createFeed(
        com.google.cloud.chronicle.v1.CreateFeedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFeedMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a feed.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.Feed getFeed(
        com.google.cloud.chronicle.v1.GetFeedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFeedMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a feed.
     * </pre>
     */
    public com.google.protobuf.Empty deleteFeed(
        com.google.cloud.chronicle.v1.DeleteFeedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFeedMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Enable feed for ingestion.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.Feed enableFeed(
        com.google.cloud.chronicle.v1.EnableFeedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEnableFeedMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Disable feed for ingestion. Make FeedState ARCHIVED.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.Feed disableFeed(
        com.google.cloud.chronicle.v1.DisableFeedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDisableFeedMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all feeds for the customer.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ListFeedsResponse listFeeds(
        com.google.cloud.chronicle.v1.ListFeedsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFeedsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Packs for which feeds can be configured.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ListFeedPacksResponse listFeedPacks(
        com.google.cloud.chronicle.v1.ListFeedPacksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFeedPacksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a feed pack.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.FeedPack getFeedPack(
        com.google.cloud.chronicle.v1.GetFeedPackRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFeedPackMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the full feed.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.Feed updateFeed(
        com.google.cloud.chronicle.v1.UpdateFeedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFeedMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all FeedSourceTypeSchemas.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasResponse
        listFeedSourceTypeSchemas(
            com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFeedSourceTypeSchemasMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all LogTypeSchemas compatible with a given
     * FeedSourceType.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ListLogTypeSchemasResponse listLogTypeSchemas(
        com.google.cloud.chronicle.v1.ListLogTypeSchemasRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListLogTypeSchemasMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Import logs coming from https push feeds.
     * All log entries must be valid UTF-8. A single invalid event will cause the
     * entire request to be rejected.
     * </pre>
     */
    public com.google.api.HttpBody importPushLogs(
        com.google.cloud.chronicle.v1.ImportPushLogsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportPushLogsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generates a new secret for https push feeds which do not support jwt
     * tokens. Secrets once generated should be copied and stored in safe place
     * to be used while configuring https push feeds.Please note that you can
     * always generate a new secret again for a feed using this API but it will
     * invalidate the previously generated secret for the feed.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.GenerateSecretResponse generateSecret(
        com.google.cloud.chronicle.v1.GenerateSecretRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateSecretMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service FeedsService.
   *
   * <pre>
   * FeedsService contains procedures for managing Chronicle third-party feeds.
   * </pre>
   */
  public static final class FeedsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<FeedsServiceFutureStub> {
    private FeedsServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeedsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeedsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Fetch Chronicle's service account used for ingesting data from Cloud
     * Storage buckets.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.FeedServiceAccount>
        fetchServiceAccountForCustomer(
            com.google.cloud.chronicle.v1.FetchServiceAccountForCustomerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchServiceAccountForCustomerMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Creates a feed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.chronicle.v1.Feed>
        createFeed(com.google.cloud.chronicle.v1.CreateFeedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFeedMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a feed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.chronicle.v1.Feed>
        getFeed(com.google.cloud.chronicle.v1.GetFeedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFeedMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a feed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteFeed(
        com.google.cloud.chronicle.v1.DeleteFeedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteFeedMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Enable feed for ingestion.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.chronicle.v1.Feed>
        enableFeed(com.google.cloud.chronicle.v1.EnableFeedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEnableFeedMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Disable feed for ingestion. Make FeedState ARCHIVED.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.chronicle.v1.Feed>
        disableFeed(com.google.cloud.chronicle.v1.DisableFeedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDisableFeedMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all feeds for the customer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.ListFeedsResponse>
        listFeeds(com.google.cloud.chronicle.v1.ListFeedsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFeedsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Packs for which feeds can be configured.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.ListFeedPacksResponse>
        listFeedPacks(com.google.cloud.chronicle.v1.ListFeedPacksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFeedPacksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a feed pack.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.FeedPack>
        getFeedPack(com.google.cloud.chronicle.v1.GetFeedPackRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFeedPackMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the full feed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.chronicle.v1.Feed>
        updateFeed(com.google.cloud.chronicle.v1.UpdateFeedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateFeedMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List all FeedSourceTypeSchemas.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasResponse>
        listFeedSourceTypeSchemas(
            com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFeedSourceTypeSchemasMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List all LogTypeSchemas compatible with a given
     * FeedSourceType.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.ListLogTypeSchemasResponse>
        listLogTypeSchemas(com.google.cloud.chronicle.v1.ListLogTypeSchemasRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListLogTypeSchemasMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Import logs coming from https push feeds.
     * All log entries must be valid UTF-8. A single invalid event will cause the
     * entire request to be rejected.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.HttpBody>
        importPushLogs(com.google.cloud.chronicle.v1.ImportPushLogsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportPushLogsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Generates a new secret for https push feeds which do not support jwt
     * tokens. Secrets once generated should be copied and stored in safe place
     * to be used while configuring https push feeds.Please note that you can
     * always generate a new secret again for a feed using this API but it will
     * invalidate the previously generated secret for the feed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.GenerateSecretResponse>
        generateSecret(com.google.cloud.chronicle.v1.GenerateSecretRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateSecretMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FETCH_SERVICE_ACCOUNT_FOR_CUSTOMER = 0;
  private static final int METHODID_CREATE_FEED = 1;
  private static final int METHODID_GET_FEED = 2;
  private static final int METHODID_DELETE_FEED = 3;
  private static final int METHODID_ENABLE_FEED = 4;
  private static final int METHODID_DISABLE_FEED = 5;
  private static final int METHODID_LIST_FEEDS = 6;
  private static final int METHODID_LIST_FEED_PACKS = 7;
  private static final int METHODID_GET_FEED_PACK = 8;
  private static final int METHODID_UPDATE_FEED = 9;
  private static final int METHODID_LIST_FEED_SOURCE_TYPE_SCHEMAS = 10;
  private static final int METHODID_LIST_LOG_TYPE_SCHEMAS = 11;
  private static final int METHODID_IMPORT_PUSH_LOGS = 12;
  private static final int METHODID_GENERATE_SECRET = 13;

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
        case METHODID_FETCH_SERVICE_ACCOUNT_FOR_CUSTOMER:
          serviceImpl.fetchServiceAccountForCustomer(
              (com.google.cloud.chronicle.v1.FetchServiceAccountForCustomerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.FeedServiceAccount>)
                  responseObserver);
          break;
        case METHODID_CREATE_FEED:
          serviceImpl.createFeed(
              (com.google.cloud.chronicle.v1.CreateFeedRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.Feed>) responseObserver);
          break;
        case METHODID_GET_FEED:
          serviceImpl.getFeed(
              (com.google.cloud.chronicle.v1.GetFeedRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.Feed>) responseObserver);
          break;
        case METHODID_DELETE_FEED:
          serviceImpl.deleteFeed(
              (com.google.cloud.chronicle.v1.DeleteFeedRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_ENABLE_FEED:
          serviceImpl.enableFeed(
              (com.google.cloud.chronicle.v1.EnableFeedRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.Feed>) responseObserver);
          break;
        case METHODID_DISABLE_FEED:
          serviceImpl.disableFeed(
              (com.google.cloud.chronicle.v1.DisableFeedRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.Feed>) responseObserver);
          break;
        case METHODID_LIST_FEEDS:
          serviceImpl.listFeeds(
              (com.google.cloud.chronicle.v1.ListFeedsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ListFeedsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_FEED_PACKS:
          serviceImpl.listFeedPacks(
              (com.google.cloud.chronicle.v1.ListFeedPacksRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ListFeedPacksResponse>)
                  responseObserver);
          break;
        case METHODID_GET_FEED_PACK:
          serviceImpl.getFeedPack(
              (com.google.cloud.chronicle.v1.GetFeedPackRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.FeedPack>)
                  responseObserver);
          break;
        case METHODID_UPDATE_FEED:
          serviceImpl.updateFeed(
              (com.google.cloud.chronicle.v1.UpdateFeedRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.Feed>) responseObserver);
          break;
        case METHODID_LIST_FEED_SOURCE_TYPE_SCHEMAS:
          serviceImpl.listFeedSourceTypeSchemas(
              (com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_LOG_TYPE_SCHEMAS:
          serviceImpl.listLogTypeSchemas(
              (com.google.cloud.chronicle.v1.ListLogTypeSchemasRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.chronicle.v1.ListLogTypeSchemasResponse>)
                  responseObserver);
          break;
        case METHODID_IMPORT_PUSH_LOGS:
          serviceImpl.importPushLogs(
              (com.google.cloud.chronicle.v1.ImportPushLogsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.HttpBody>) responseObserver);
          break;
        case METHODID_GENERATE_SECRET:
          serviceImpl.generateSecret(
              (com.google.cloud.chronicle.v1.GenerateSecretRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.GenerateSecretResponse>)
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
            getFetchServiceAccountForCustomerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.FetchServiceAccountForCustomerRequest,
                    com.google.cloud.chronicle.v1.FeedServiceAccount>(
                    service, METHODID_FETCH_SERVICE_ACCOUNT_FOR_CUSTOMER)))
        .addMethod(
            getCreateFeedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.CreateFeedRequest,
                    com.google.cloud.chronicle.v1.Feed>(service, METHODID_CREATE_FEED)))
        .addMethod(
            getGetFeedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.GetFeedRequest,
                    com.google.cloud.chronicle.v1.Feed>(service, METHODID_GET_FEED)))
        .addMethod(
            getDeleteFeedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.DeleteFeedRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_FEED)))
        .addMethod(
            getEnableFeedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.EnableFeedRequest,
                    com.google.cloud.chronicle.v1.Feed>(service, METHODID_ENABLE_FEED)))
        .addMethod(
            getDisableFeedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.DisableFeedRequest,
                    com.google.cloud.chronicle.v1.Feed>(service, METHODID_DISABLE_FEED)))
        .addMethod(
            getListFeedsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.ListFeedsRequest,
                    com.google.cloud.chronicle.v1.ListFeedsResponse>(service, METHODID_LIST_FEEDS)))
        .addMethod(
            getListFeedPacksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.ListFeedPacksRequest,
                    com.google.cloud.chronicle.v1.ListFeedPacksResponse>(
                    service, METHODID_LIST_FEED_PACKS)))
        .addMethod(
            getGetFeedPackMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.GetFeedPackRequest,
                    com.google.cloud.chronicle.v1.FeedPack>(service, METHODID_GET_FEED_PACK)))
        .addMethod(
            getUpdateFeedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.UpdateFeedRequest,
                    com.google.cloud.chronicle.v1.Feed>(service, METHODID_UPDATE_FEED)))
        .addMethod(
            getListFeedSourceTypeSchemasMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasRequest,
                    com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasResponse>(
                    service, METHODID_LIST_FEED_SOURCE_TYPE_SCHEMAS)))
        .addMethod(
            getListLogTypeSchemasMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.ListLogTypeSchemasRequest,
                    com.google.cloud.chronicle.v1.ListLogTypeSchemasResponse>(
                    service, METHODID_LIST_LOG_TYPE_SCHEMAS)))
        .addMethod(
            getImportPushLogsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.ImportPushLogsRequest, com.google.api.HttpBody>(
                    service, METHODID_IMPORT_PUSH_LOGS)))
        .addMethod(
            getGenerateSecretMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.GenerateSecretRequest,
                    com.google.cloud.chronicle.v1.GenerateSecretResponse>(
                    service, METHODID_GENERATE_SECRET)))
        .build();
  }

  private abstract static class FeedsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FeedsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.chronicle.v1.FeedProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FeedsService");
    }
  }

  private static final class FeedsServiceFileDescriptorSupplier
      extends FeedsServiceBaseDescriptorSupplier {
    FeedsServiceFileDescriptorSupplier() {}
  }

  private static final class FeedsServiceMethodDescriptorSupplier
      extends FeedsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    FeedsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (FeedsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new FeedsServiceFileDescriptorSupplier())
                      .addMethod(getFetchServiceAccountForCustomerMethod())
                      .addMethod(getCreateFeedMethod())
                      .addMethod(getGetFeedMethod())
                      .addMethod(getDeleteFeedMethod())
                      .addMethod(getEnableFeedMethod())
                      .addMethod(getDisableFeedMethod())
                      .addMethod(getListFeedsMethod())
                      .addMethod(getListFeedPacksMethod())
                      .addMethod(getGetFeedPackMethod())
                      .addMethod(getUpdateFeedMethod())
                      .addMethod(getListFeedSourceTypeSchemasMethod())
                      .addMethod(getListLogTypeSchemasMethod())
                      .addMethod(getImportPushLogsMethod())
                      .addMethod(getGenerateSecretMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
