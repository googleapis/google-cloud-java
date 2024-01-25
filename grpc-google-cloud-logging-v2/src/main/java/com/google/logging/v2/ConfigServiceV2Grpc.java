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
package com.google.logging.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for configuring sinks used to route log entries.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/logging/v2/logging_config.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ConfigServiceV2Grpc {

  private ConfigServiceV2Grpc() {}

  public static final java.lang.String SERVICE_NAME = "google.logging.v2.ConfigServiceV2";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.ListBucketsRequest, com.google.logging.v2.ListBucketsResponse>
      getListBucketsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBuckets",
      requestType = com.google.logging.v2.ListBucketsRequest.class,
      responseType = com.google.logging.v2.ListBucketsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.ListBucketsRequest, com.google.logging.v2.ListBucketsResponse>
      getListBucketsMethod() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.ListBucketsRequest, com.google.logging.v2.ListBucketsResponse>
        getListBucketsMethod;
    if ((getListBucketsMethod = ConfigServiceV2Grpc.getListBucketsMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getListBucketsMethod = ConfigServiceV2Grpc.getListBucketsMethod) == null) {
          ConfigServiceV2Grpc.getListBucketsMethod =
              getListBucketsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.ListBucketsRequest,
                          com.google.logging.v2.ListBucketsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBuckets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.ListBucketsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.ListBucketsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigServiceV2MethodDescriptorSupplier("ListBuckets"))
                      .build();
        }
      }
    }
    return getListBucketsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.GetBucketRequest, com.google.logging.v2.LogBucket>
      getGetBucketMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBucket",
      requestType = com.google.logging.v2.GetBucketRequest.class,
      responseType = com.google.logging.v2.LogBucket.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.GetBucketRequest, com.google.logging.v2.LogBucket>
      getGetBucketMethod() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.GetBucketRequest, com.google.logging.v2.LogBucket>
        getGetBucketMethod;
    if ((getGetBucketMethod = ConfigServiceV2Grpc.getGetBucketMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getGetBucketMethod = ConfigServiceV2Grpc.getGetBucketMethod) == null) {
          ConfigServiceV2Grpc.getGetBucketMethod =
              getGetBucketMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.GetBucketRequest, com.google.logging.v2.LogBucket>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBucket"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.GetBucketRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.LogBucket.getDefaultInstance()))
                      .setSchemaDescriptor(new ConfigServiceV2MethodDescriptorSupplier("GetBucket"))
                      .build();
        }
      }
    }
    return getGetBucketMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.CreateBucketRequest, com.google.longrunning.Operation>
      getCreateBucketAsyncMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBucketAsync",
      requestType = com.google.logging.v2.CreateBucketRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.CreateBucketRequest, com.google.longrunning.Operation>
      getCreateBucketAsyncMethod() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.CreateBucketRequest, com.google.longrunning.Operation>
        getCreateBucketAsyncMethod;
    if ((getCreateBucketAsyncMethod = ConfigServiceV2Grpc.getCreateBucketAsyncMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getCreateBucketAsyncMethod = ConfigServiceV2Grpc.getCreateBucketAsyncMethod) == null) {
          ConfigServiceV2Grpc.getCreateBucketAsyncMethod =
              getCreateBucketAsyncMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.CreateBucketRequest, com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBucketAsync"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.CreateBucketRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigServiceV2MethodDescriptorSupplier("CreateBucketAsync"))
                      .build();
        }
      }
    }
    return getCreateBucketAsyncMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.UpdateBucketRequest, com.google.longrunning.Operation>
      getUpdateBucketAsyncMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBucketAsync",
      requestType = com.google.logging.v2.UpdateBucketRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.UpdateBucketRequest, com.google.longrunning.Operation>
      getUpdateBucketAsyncMethod() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.UpdateBucketRequest, com.google.longrunning.Operation>
        getUpdateBucketAsyncMethod;
    if ((getUpdateBucketAsyncMethod = ConfigServiceV2Grpc.getUpdateBucketAsyncMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getUpdateBucketAsyncMethod = ConfigServiceV2Grpc.getUpdateBucketAsyncMethod) == null) {
          ConfigServiceV2Grpc.getUpdateBucketAsyncMethod =
              getUpdateBucketAsyncMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.UpdateBucketRequest, com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateBucketAsync"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.UpdateBucketRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigServiceV2MethodDescriptorSupplier("UpdateBucketAsync"))
                      .build();
        }
      }
    }
    return getUpdateBucketAsyncMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.CreateBucketRequest, com.google.logging.v2.LogBucket>
      getCreateBucketMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBucket",
      requestType = com.google.logging.v2.CreateBucketRequest.class,
      responseType = com.google.logging.v2.LogBucket.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.CreateBucketRequest, com.google.logging.v2.LogBucket>
      getCreateBucketMethod() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.CreateBucketRequest, com.google.logging.v2.LogBucket>
        getCreateBucketMethod;
    if ((getCreateBucketMethod = ConfigServiceV2Grpc.getCreateBucketMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getCreateBucketMethod = ConfigServiceV2Grpc.getCreateBucketMethod) == null) {
          ConfigServiceV2Grpc.getCreateBucketMethod =
              getCreateBucketMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.CreateBucketRequest, com.google.logging.v2.LogBucket>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBucket"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.CreateBucketRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.LogBucket.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigServiceV2MethodDescriptorSupplier("CreateBucket"))
                      .build();
        }
      }
    }
    return getCreateBucketMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.UpdateBucketRequest, com.google.logging.v2.LogBucket>
      getUpdateBucketMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBucket",
      requestType = com.google.logging.v2.UpdateBucketRequest.class,
      responseType = com.google.logging.v2.LogBucket.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.UpdateBucketRequest, com.google.logging.v2.LogBucket>
      getUpdateBucketMethod() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.UpdateBucketRequest, com.google.logging.v2.LogBucket>
        getUpdateBucketMethod;
    if ((getUpdateBucketMethod = ConfigServiceV2Grpc.getUpdateBucketMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getUpdateBucketMethod = ConfigServiceV2Grpc.getUpdateBucketMethod) == null) {
          ConfigServiceV2Grpc.getUpdateBucketMethod =
              getUpdateBucketMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.UpdateBucketRequest, com.google.logging.v2.LogBucket>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateBucket"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.UpdateBucketRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.LogBucket.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigServiceV2MethodDescriptorSupplier("UpdateBucket"))
                      .build();
        }
      }
    }
    return getUpdateBucketMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.DeleteBucketRequest, com.google.protobuf.Empty>
      getDeleteBucketMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBucket",
      requestType = com.google.logging.v2.DeleteBucketRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.DeleteBucketRequest, com.google.protobuf.Empty>
      getDeleteBucketMethod() {
    io.grpc.MethodDescriptor<com.google.logging.v2.DeleteBucketRequest, com.google.protobuf.Empty>
        getDeleteBucketMethod;
    if ((getDeleteBucketMethod = ConfigServiceV2Grpc.getDeleteBucketMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getDeleteBucketMethod = ConfigServiceV2Grpc.getDeleteBucketMethod) == null) {
          ConfigServiceV2Grpc.getDeleteBucketMethod =
              getDeleteBucketMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.DeleteBucketRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBucket"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.DeleteBucketRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigServiceV2MethodDescriptorSupplier("DeleteBucket"))
                      .build();
        }
      }
    }
    return getDeleteBucketMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.UndeleteBucketRequest, com.google.protobuf.Empty>
      getUndeleteBucketMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UndeleteBucket",
      requestType = com.google.logging.v2.UndeleteBucketRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.UndeleteBucketRequest, com.google.protobuf.Empty>
      getUndeleteBucketMethod() {
    io.grpc.MethodDescriptor<com.google.logging.v2.UndeleteBucketRequest, com.google.protobuf.Empty>
        getUndeleteBucketMethod;
    if ((getUndeleteBucketMethod = ConfigServiceV2Grpc.getUndeleteBucketMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getUndeleteBucketMethod = ConfigServiceV2Grpc.getUndeleteBucketMethod) == null) {
          ConfigServiceV2Grpc.getUndeleteBucketMethod =
              getUndeleteBucketMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.UndeleteBucketRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UndeleteBucket"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.UndeleteBucketRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigServiceV2MethodDescriptorSupplier("UndeleteBucket"))
                      .build();
        }
      }
    }
    return getUndeleteBucketMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.ListViewsRequest, com.google.logging.v2.ListViewsResponse>
      getListViewsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListViews",
      requestType = com.google.logging.v2.ListViewsRequest.class,
      responseType = com.google.logging.v2.ListViewsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.ListViewsRequest, com.google.logging.v2.ListViewsResponse>
      getListViewsMethod() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.ListViewsRequest, com.google.logging.v2.ListViewsResponse>
        getListViewsMethod;
    if ((getListViewsMethod = ConfigServiceV2Grpc.getListViewsMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getListViewsMethod = ConfigServiceV2Grpc.getListViewsMethod) == null) {
          ConfigServiceV2Grpc.getListViewsMethod =
              getListViewsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.ListViewsRequest,
                          com.google.logging.v2.ListViewsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListViews"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.ListViewsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.ListViewsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new ConfigServiceV2MethodDescriptorSupplier("ListViews"))
                      .build();
        }
      }
    }
    return getListViewsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.GetViewRequest, com.google.logging.v2.LogView>
      getGetViewMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetView",
      requestType = com.google.logging.v2.GetViewRequest.class,
      responseType = com.google.logging.v2.LogView.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.GetViewRequest, com.google.logging.v2.LogView>
      getGetViewMethod() {
    io.grpc.MethodDescriptor<com.google.logging.v2.GetViewRequest, com.google.logging.v2.LogView>
        getGetViewMethod;
    if ((getGetViewMethod = ConfigServiceV2Grpc.getGetViewMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getGetViewMethod = ConfigServiceV2Grpc.getGetViewMethod) == null) {
          ConfigServiceV2Grpc.getGetViewMethod =
              getGetViewMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.GetViewRequest, com.google.logging.v2.LogView>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetView"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.GetViewRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.LogView.getDefaultInstance()))
                      .setSchemaDescriptor(new ConfigServiceV2MethodDescriptorSupplier("GetView"))
                      .build();
        }
      }
    }
    return getGetViewMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.CreateViewRequest, com.google.logging.v2.LogView>
      getCreateViewMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateView",
      requestType = com.google.logging.v2.CreateViewRequest.class,
      responseType = com.google.logging.v2.LogView.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.CreateViewRequest, com.google.logging.v2.LogView>
      getCreateViewMethod() {
    io.grpc.MethodDescriptor<com.google.logging.v2.CreateViewRequest, com.google.logging.v2.LogView>
        getCreateViewMethod;
    if ((getCreateViewMethod = ConfigServiceV2Grpc.getCreateViewMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getCreateViewMethod = ConfigServiceV2Grpc.getCreateViewMethod) == null) {
          ConfigServiceV2Grpc.getCreateViewMethod =
              getCreateViewMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.CreateViewRequest, com.google.logging.v2.LogView>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateView"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.CreateViewRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.LogView.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigServiceV2MethodDescriptorSupplier("CreateView"))
                      .build();
        }
      }
    }
    return getCreateViewMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.UpdateViewRequest, com.google.logging.v2.LogView>
      getUpdateViewMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateView",
      requestType = com.google.logging.v2.UpdateViewRequest.class,
      responseType = com.google.logging.v2.LogView.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.UpdateViewRequest, com.google.logging.v2.LogView>
      getUpdateViewMethod() {
    io.grpc.MethodDescriptor<com.google.logging.v2.UpdateViewRequest, com.google.logging.v2.LogView>
        getUpdateViewMethod;
    if ((getUpdateViewMethod = ConfigServiceV2Grpc.getUpdateViewMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getUpdateViewMethod = ConfigServiceV2Grpc.getUpdateViewMethod) == null) {
          ConfigServiceV2Grpc.getUpdateViewMethod =
              getUpdateViewMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.UpdateViewRequest, com.google.logging.v2.LogView>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateView"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.UpdateViewRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.LogView.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigServiceV2MethodDescriptorSupplier("UpdateView"))
                      .build();
        }
      }
    }
    return getUpdateViewMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.DeleteViewRequest, com.google.protobuf.Empty>
      getDeleteViewMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteView",
      requestType = com.google.logging.v2.DeleteViewRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.DeleteViewRequest, com.google.protobuf.Empty>
      getDeleteViewMethod() {
    io.grpc.MethodDescriptor<com.google.logging.v2.DeleteViewRequest, com.google.protobuf.Empty>
        getDeleteViewMethod;
    if ((getDeleteViewMethod = ConfigServiceV2Grpc.getDeleteViewMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getDeleteViewMethod = ConfigServiceV2Grpc.getDeleteViewMethod) == null) {
          ConfigServiceV2Grpc.getDeleteViewMethod =
              getDeleteViewMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.DeleteViewRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteView"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.DeleteViewRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigServiceV2MethodDescriptorSupplier("DeleteView"))
                      .build();
        }
      }
    }
    return getDeleteViewMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.ListSinksRequest, com.google.logging.v2.ListSinksResponse>
      getListSinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSinks",
      requestType = com.google.logging.v2.ListSinksRequest.class,
      responseType = com.google.logging.v2.ListSinksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.ListSinksRequest, com.google.logging.v2.ListSinksResponse>
      getListSinksMethod() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.ListSinksRequest, com.google.logging.v2.ListSinksResponse>
        getListSinksMethod;
    if ((getListSinksMethod = ConfigServiceV2Grpc.getListSinksMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getListSinksMethod = ConfigServiceV2Grpc.getListSinksMethod) == null) {
          ConfigServiceV2Grpc.getListSinksMethod =
              getListSinksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.ListSinksRequest,
                          com.google.logging.v2.ListSinksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSinks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.ListSinksRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.ListSinksResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new ConfigServiceV2MethodDescriptorSupplier("ListSinks"))
                      .build();
        }
      }
    }
    return getListSinksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.GetSinkRequest, com.google.logging.v2.LogSink>
      getGetSinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSink",
      requestType = com.google.logging.v2.GetSinkRequest.class,
      responseType = com.google.logging.v2.LogSink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.GetSinkRequest, com.google.logging.v2.LogSink>
      getGetSinkMethod() {
    io.grpc.MethodDescriptor<com.google.logging.v2.GetSinkRequest, com.google.logging.v2.LogSink>
        getGetSinkMethod;
    if ((getGetSinkMethod = ConfigServiceV2Grpc.getGetSinkMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getGetSinkMethod = ConfigServiceV2Grpc.getGetSinkMethod) == null) {
          ConfigServiceV2Grpc.getGetSinkMethod =
              getGetSinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.GetSinkRequest, com.google.logging.v2.LogSink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.GetSinkRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.LogSink.getDefaultInstance()))
                      .setSchemaDescriptor(new ConfigServiceV2MethodDescriptorSupplier("GetSink"))
                      .build();
        }
      }
    }
    return getGetSinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.CreateSinkRequest, com.google.logging.v2.LogSink>
      getCreateSinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSink",
      requestType = com.google.logging.v2.CreateSinkRequest.class,
      responseType = com.google.logging.v2.LogSink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.CreateSinkRequest, com.google.logging.v2.LogSink>
      getCreateSinkMethod() {
    io.grpc.MethodDescriptor<com.google.logging.v2.CreateSinkRequest, com.google.logging.v2.LogSink>
        getCreateSinkMethod;
    if ((getCreateSinkMethod = ConfigServiceV2Grpc.getCreateSinkMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getCreateSinkMethod = ConfigServiceV2Grpc.getCreateSinkMethod) == null) {
          ConfigServiceV2Grpc.getCreateSinkMethod =
              getCreateSinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.CreateSinkRequest, com.google.logging.v2.LogSink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.CreateSinkRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.LogSink.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigServiceV2MethodDescriptorSupplier("CreateSink"))
                      .build();
        }
      }
    }
    return getCreateSinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.UpdateSinkRequest, com.google.logging.v2.LogSink>
      getUpdateSinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSink",
      requestType = com.google.logging.v2.UpdateSinkRequest.class,
      responseType = com.google.logging.v2.LogSink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.UpdateSinkRequest, com.google.logging.v2.LogSink>
      getUpdateSinkMethod() {
    io.grpc.MethodDescriptor<com.google.logging.v2.UpdateSinkRequest, com.google.logging.v2.LogSink>
        getUpdateSinkMethod;
    if ((getUpdateSinkMethod = ConfigServiceV2Grpc.getUpdateSinkMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getUpdateSinkMethod = ConfigServiceV2Grpc.getUpdateSinkMethod) == null) {
          ConfigServiceV2Grpc.getUpdateSinkMethod =
              getUpdateSinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.UpdateSinkRequest, com.google.logging.v2.LogSink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.UpdateSinkRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.LogSink.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigServiceV2MethodDescriptorSupplier("UpdateSink"))
                      .build();
        }
      }
    }
    return getUpdateSinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.DeleteSinkRequest, com.google.protobuf.Empty>
      getDeleteSinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSink",
      requestType = com.google.logging.v2.DeleteSinkRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.DeleteSinkRequest, com.google.protobuf.Empty>
      getDeleteSinkMethod() {
    io.grpc.MethodDescriptor<com.google.logging.v2.DeleteSinkRequest, com.google.protobuf.Empty>
        getDeleteSinkMethod;
    if ((getDeleteSinkMethod = ConfigServiceV2Grpc.getDeleteSinkMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getDeleteSinkMethod = ConfigServiceV2Grpc.getDeleteSinkMethod) == null) {
          ConfigServiceV2Grpc.getDeleteSinkMethod =
              getDeleteSinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.DeleteSinkRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.DeleteSinkRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigServiceV2MethodDescriptorSupplier("DeleteSink"))
                      .build();
        }
      }
    }
    return getDeleteSinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.CreateLinkRequest, com.google.longrunning.Operation>
      getCreateLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateLink",
      requestType = com.google.logging.v2.CreateLinkRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.CreateLinkRequest, com.google.longrunning.Operation>
      getCreateLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.CreateLinkRequest, com.google.longrunning.Operation>
        getCreateLinkMethod;
    if ((getCreateLinkMethod = ConfigServiceV2Grpc.getCreateLinkMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getCreateLinkMethod = ConfigServiceV2Grpc.getCreateLinkMethod) == null) {
          ConfigServiceV2Grpc.getCreateLinkMethod =
              getCreateLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.CreateLinkRequest, com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.CreateLinkRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigServiceV2MethodDescriptorSupplier("CreateLink"))
                      .build();
        }
      }
    }
    return getCreateLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.DeleteLinkRequest, com.google.longrunning.Operation>
      getDeleteLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteLink",
      requestType = com.google.logging.v2.DeleteLinkRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.DeleteLinkRequest, com.google.longrunning.Operation>
      getDeleteLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.DeleteLinkRequest, com.google.longrunning.Operation>
        getDeleteLinkMethod;
    if ((getDeleteLinkMethod = ConfigServiceV2Grpc.getDeleteLinkMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getDeleteLinkMethod = ConfigServiceV2Grpc.getDeleteLinkMethod) == null) {
          ConfigServiceV2Grpc.getDeleteLinkMethod =
              getDeleteLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.DeleteLinkRequest, com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.DeleteLinkRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigServiceV2MethodDescriptorSupplier("DeleteLink"))
                      .build();
        }
      }
    }
    return getDeleteLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.ListLinksRequest, com.google.logging.v2.ListLinksResponse>
      getListLinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListLinks",
      requestType = com.google.logging.v2.ListLinksRequest.class,
      responseType = com.google.logging.v2.ListLinksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.ListLinksRequest, com.google.logging.v2.ListLinksResponse>
      getListLinksMethod() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.ListLinksRequest, com.google.logging.v2.ListLinksResponse>
        getListLinksMethod;
    if ((getListLinksMethod = ConfigServiceV2Grpc.getListLinksMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getListLinksMethod = ConfigServiceV2Grpc.getListLinksMethod) == null) {
          ConfigServiceV2Grpc.getListLinksMethod =
              getListLinksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.ListLinksRequest,
                          com.google.logging.v2.ListLinksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListLinks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.ListLinksRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.ListLinksResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new ConfigServiceV2MethodDescriptorSupplier("ListLinks"))
                      .build();
        }
      }
    }
    return getListLinksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.GetLinkRequest, com.google.logging.v2.Link>
      getGetLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLink",
      requestType = com.google.logging.v2.GetLinkRequest.class,
      responseType = com.google.logging.v2.Link.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.GetLinkRequest, com.google.logging.v2.Link>
      getGetLinkMethod() {
    io.grpc.MethodDescriptor<com.google.logging.v2.GetLinkRequest, com.google.logging.v2.Link>
        getGetLinkMethod;
    if ((getGetLinkMethod = ConfigServiceV2Grpc.getGetLinkMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getGetLinkMethod = ConfigServiceV2Grpc.getGetLinkMethod) == null) {
          ConfigServiceV2Grpc.getGetLinkMethod =
              getGetLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.GetLinkRequest, com.google.logging.v2.Link>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.GetLinkRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.Link.getDefaultInstance()))
                      .setSchemaDescriptor(new ConfigServiceV2MethodDescriptorSupplier("GetLink"))
                      .build();
        }
      }
    }
    return getGetLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.ListExclusionsRequest, com.google.logging.v2.ListExclusionsResponse>
      getListExclusionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListExclusions",
      requestType = com.google.logging.v2.ListExclusionsRequest.class,
      responseType = com.google.logging.v2.ListExclusionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.ListExclusionsRequest, com.google.logging.v2.ListExclusionsResponse>
      getListExclusionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.ListExclusionsRequest,
            com.google.logging.v2.ListExclusionsResponse>
        getListExclusionsMethod;
    if ((getListExclusionsMethod = ConfigServiceV2Grpc.getListExclusionsMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getListExclusionsMethod = ConfigServiceV2Grpc.getListExclusionsMethod) == null) {
          ConfigServiceV2Grpc.getListExclusionsMethod =
              getListExclusionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.ListExclusionsRequest,
                          com.google.logging.v2.ListExclusionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListExclusions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.ListExclusionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.ListExclusionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigServiceV2MethodDescriptorSupplier("ListExclusions"))
                      .build();
        }
      }
    }
    return getListExclusionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.GetExclusionRequest, com.google.logging.v2.LogExclusion>
      getGetExclusionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetExclusion",
      requestType = com.google.logging.v2.GetExclusionRequest.class,
      responseType = com.google.logging.v2.LogExclusion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.GetExclusionRequest, com.google.logging.v2.LogExclusion>
      getGetExclusionMethod() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.GetExclusionRequest, com.google.logging.v2.LogExclusion>
        getGetExclusionMethod;
    if ((getGetExclusionMethod = ConfigServiceV2Grpc.getGetExclusionMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getGetExclusionMethod = ConfigServiceV2Grpc.getGetExclusionMethod) == null) {
          ConfigServiceV2Grpc.getGetExclusionMethod =
              getGetExclusionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.GetExclusionRequest,
                          com.google.logging.v2.LogExclusion>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetExclusion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.GetExclusionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.LogExclusion.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigServiceV2MethodDescriptorSupplier("GetExclusion"))
                      .build();
        }
      }
    }
    return getGetExclusionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.CreateExclusionRequest, com.google.logging.v2.LogExclusion>
      getCreateExclusionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateExclusion",
      requestType = com.google.logging.v2.CreateExclusionRequest.class,
      responseType = com.google.logging.v2.LogExclusion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.CreateExclusionRequest, com.google.logging.v2.LogExclusion>
      getCreateExclusionMethod() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.CreateExclusionRequest, com.google.logging.v2.LogExclusion>
        getCreateExclusionMethod;
    if ((getCreateExclusionMethod = ConfigServiceV2Grpc.getCreateExclusionMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getCreateExclusionMethod = ConfigServiceV2Grpc.getCreateExclusionMethod) == null) {
          ConfigServiceV2Grpc.getCreateExclusionMethod =
              getCreateExclusionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.CreateExclusionRequest,
                          com.google.logging.v2.LogExclusion>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateExclusion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.CreateExclusionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.LogExclusion.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigServiceV2MethodDescriptorSupplier("CreateExclusion"))
                      .build();
        }
      }
    }
    return getCreateExclusionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.UpdateExclusionRequest, com.google.logging.v2.LogExclusion>
      getUpdateExclusionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateExclusion",
      requestType = com.google.logging.v2.UpdateExclusionRequest.class,
      responseType = com.google.logging.v2.LogExclusion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.UpdateExclusionRequest, com.google.logging.v2.LogExclusion>
      getUpdateExclusionMethod() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.UpdateExclusionRequest, com.google.logging.v2.LogExclusion>
        getUpdateExclusionMethod;
    if ((getUpdateExclusionMethod = ConfigServiceV2Grpc.getUpdateExclusionMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getUpdateExclusionMethod = ConfigServiceV2Grpc.getUpdateExclusionMethod) == null) {
          ConfigServiceV2Grpc.getUpdateExclusionMethod =
              getUpdateExclusionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.UpdateExclusionRequest,
                          com.google.logging.v2.LogExclusion>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateExclusion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.UpdateExclusionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.LogExclusion.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigServiceV2MethodDescriptorSupplier("UpdateExclusion"))
                      .build();
        }
      }
    }
    return getUpdateExclusionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.DeleteExclusionRequest, com.google.protobuf.Empty>
      getDeleteExclusionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteExclusion",
      requestType = com.google.logging.v2.DeleteExclusionRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.DeleteExclusionRequest, com.google.protobuf.Empty>
      getDeleteExclusionMethod() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.DeleteExclusionRequest, com.google.protobuf.Empty>
        getDeleteExclusionMethod;
    if ((getDeleteExclusionMethod = ConfigServiceV2Grpc.getDeleteExclusionMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getDeleteExclusionMethod = ConfigServiceV2Grpc.getDeleteExclusionMethod) == null) {
          ConfigServiceV2Grpc.getDeleteExclusionMethod =
              getDeleteExclusionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.DeleteExclusionRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteExclusion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.DeleteExclusionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigServiceV2MethodDescriptorSupplier("DeleteExclusion"))
                      .build();
        }
      }
    }
    return getDeleteExclusionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.GetCmekSettingsRequest, com.google.logging.v2.CmekSettings>
      getGetCmekSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCmekSettings",
      requestType = com.google.logging.v2.GetCmekSettingsRequest.class,
      responseType = com.google.logging.v2.CmekSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.GetCmekSettingsRequest, com.google.logging.v2.CmekSettings>
      getGetCmekSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.GetCmekSettingsRequest, com.google.logging.v2.CmekSettings>
        getGetCmekSettingsMethod;
    if ((getGetCmekSettingsMethod = ConfigServiceV2Grpc.getGetCmekSettingsMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getGetCmekSettingsMethod = ConfigServiceV2Grpc.getGetCmekSettingsMethod) == null) {
          ConfigServiceV2Grpc.getGetCmekSettingsMethod =
              getGetCmekSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.GetCmekSettingsRequest,
                          com.google.logging.v2.CmekSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCmekSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.GetCmekSettingsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.CmekSettings.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigServiceV2MethodDescriptorSupplier("GetCmekSettings"))
                      .build();
        }
      }
    }
    return getGetCmekSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.UpdateCmekSettingsRequest, com.google.logging.v2.CmekSettings>
      getUpdateCmekSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCmekSettings",
      requestType = com.google.logging.v2.UpdateCmekSettingsRequest.class,
      responseType = com.google.logging.v2.CmekSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.UpdateCmekSettingsRequest, com.google.logging.v2.CmekSettings>
      getUpdateCmekSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.UpdateCmekSettingsRequest, com.google.logging.v2.CmekSettings>
        getUpdateCmekSettingsMethod;
    if ((getUpdateCmekSettingsMethod = ConfigServiceV2Grpc.getUpdateCmekSettingsMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getUpdateCmekSettingsMethod = ConfigServiceV2Grpc.getUpdateCmekSettingsMethod)
            == null) {
          ConfigServiceV2Grpc.getUpdateCmekSettingsMethod =
              getUpdateCmekSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.UpdateCmekSettingsRequest,
                          com.google.logging.v2.CmekSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCmekSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.UpdateCmekSettingsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.CmekSettings.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigServiceV2MethodDescriptorSupplier("UpdateCmekSettings"))
                      .build();
        }
      }
    }
    return getUpdateCmekSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.GetSettingsRequest, com.google.logging.v2.Settings>
      getGetSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSettings",
      requestType = com.google.logging.v2.GetSettingsRequest.class,
      responseType = com.google.logging.v2.Settings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.GetSettingsRequest, com.google.logging.v2.Settings>
      getGetSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.GetSettingsRequest, com.google.logging.v2.Settings>
        getGetSettingsMethod;
    if ((getGetSettingsMethod = ConfigServiceV2Grpc.getGetSettingsMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getGetSettingsMethod = ConfigServiceV2Grpc.getGetSettingsMethod) == null) {
          ConfigServiceV2Grpc.getGetSettingsMethod =
              getGetSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.GetSettingsRequest, com.google.logging.v2.Settings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.GetSettingsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.Settings.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigServiceV2MethodDescriptorSupplier("GetSettings"))
                      .build();
        }
      }
    }
    return getGetSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.UpdateSettingsRequest, com.google.logging.v2.Settings>
      getUpdateSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSettings",
      requestType = com.google.logging.v2.UpdateSettingsRequest.class,
      responseType = com.google.logging.v2.Settings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.UpdateSettingsRequest, com.google.logging.v2.Settings>
      getUpdateSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.UpdateSettingsRequest, com.google.logging.v2.Settings>
        getUpdateSettingsMethod;
    if ((getUpdateSettingsMethod = ConfigServiceV2Grpc.getUpdateSettingsMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getUpdateSettingsMethod = ConfigServiceV2Grpc.getUpdateSettingsMethod) == null) {
          ConfigServiceV2Grpc.getUpdateSettingsMethod =
              getUpdateSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.UpdateSettingsRequest, com.google.logging.v2.Settings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.UpdateSettingsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.Settings.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigServiceV2MethodDescriptorSupplier("UpdateSettings"))
                      .build();
        }
      }
    }
    return getUpdateSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.CopyLogEntriesRequest, com.google.longrunning.Operation>
      getCopyLogEntriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CopyLogEntries",
      requestType = com.google.logging.v2.CopyLogEntriesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.CopyLogEntriesRequest, com.google.longrunning.Operation>
      getCopyLogEntriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.CopyLogEntriesRequest, com.google.longrunning.Operation>
        getCopyLogEntriesMethod;
    if ((getCopyLogEntriesMethod = ConfigServiceV2Grpc.getCopyLogEntriesMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getCopyLogEntriesMethod = ConfigServiceV2Grpc.getCopyLogEntriesMethod) == null) {
          ConfigServiceV2Grpc.getCopyLogEntriesMethod =
              getCopyLogEntriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.CopyLogEntriesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CopyLogEntries"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.CopyLogEntriesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigServiceV2MethodDescriptorSupplier("CopyLogEntries"))
                      .build();
        }
      }
    }
    return getCopyLogEntriesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ConfigServiceV2Stub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConfigServiceV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConfigServiceV2Stub>() {
          @java.lang.Override
          public ConfigServiceV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConfigServiceV2Stub(channel, callOptions);
          }
        };
    return ConfigServiceV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConfigServiceV2BlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConfigServiceV2BlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConfigServiceV2BlockingStub>() {
          @java.lang.Override
          public ConfigServiceV2BlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConfigServiceV2BlockingStub(channel, callOptions);
          }
        };
    return ConfigServiceV2BlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ConfigServiceV2FutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConfigServiceV2FutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConfigServiceV2FutureStub>() {
          @java.lang.Override
          public ConfigServiceV2FutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConfigServiceV2FutureStub(channel, callOptions);
          }
        };
    return ConfigServiceV2FutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for configuring sinks used to route log entries.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists log buckets.
     * </pre>
     */
    default void listBuckets(
        com.google.logging.v2.ListBucketsRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListBucketsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBucketsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a log bucket.
     * </pre>
     */
    default void getBucket(
        com.google.logging.v2.GetBucketRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogBucket> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBucketMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a log bucket asynchronously that can be used to store log entries.
     * After a bucket has been created, the bucket's location cannot be changed.
     * </pre>
     */
    default void createBucketAsync(
        com.google.logging.v2.CreateBucketRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateBucketAsyncMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a log bucket asynchronously.
     * If the bucket has a `lifecycle_state` of `DELETE_REQUESTED`, then
     * `FAILED_PRECONDITION` will be returned.
     * After a bucket has been created, the bucket's location cannot be changed.
     * </pre>
     */
    default void updateBucketAsync(
        com.google.logging.v2.UpdateBucketRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateBucketAsyncMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a log bucket that can be used to store log entries. After a bucket
     * has been created, the bucket's location cannot be changed.
     * </pre>
     */
    default void createBucket(
        com.google.logging.v2.CreateBucketRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogBucket> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateBucketMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a log bucket.
     * If the bucket has a `lifecycle_state` of `DELETE_REQUESTED`, then
     * `FAILED_PRECONDITION` will be returned.
     * After a bucket has been created, the bucket's location cannot be changed.
     * </pre>
     */
    default void updateBucket(
        com.google.logging.v2.UpdateBucketRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogBucket> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateBucketMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a log bucket.
     * Changes the bucket's `lifecycle_state` to the `DELETE_REQUESTED` state.
     * After 7 days, the bucket will be purged and all log entries in the bucket
     * will be permanently deleted.
     * </pre>
     */
    default void deleteBucket(
        com.google.logging.v2.DeleteBucketRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteBucketMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Undeletes a log bucket. A bucket that has been deleted can be undeleted
     * within the grace period of 7 days.
     * </pre>
     */
    default void undeleteBucket(
        com.google.logging.v2.UndeleteBucketRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUndeleteBucketMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists views on a log bucket.
     * </pre>
     */
    default void listViews(
        com.google.logging.v2.ListViewsRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListViewsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListViewsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a view on a log bucket..
     * </pre>
     */
    default void getView(
        com.google.logging.v2.GetViewRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogView> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetViewMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a view over log entries in a log bucket. A bucket may contain a
     * maximum of 30 views.
     * </pre>
     */
    default void createView(
        com.google.logging.v2.CreateViewRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogView> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateViewMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a view on a log bucket. This method replaces the following fields
     * in the existing view with values from the new view: `filter`.
     * If an `UNAVAILABLE` error is returned, this indicates that system is not in
     * a state where it can update the view. If this occurs, please try again in a
     * few minutes.
     * </pre>
     */
    default void updateView(
        com.google.logging.v2.UpdateViewRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogView> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateViewMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a view on a log bucket.
     * If an `UNAVAILABLE` error is returned, this indicates that system is not in
     * a state where it can delete the view. If this occurs, please try again in a
     * few minutes.
     * </pre>
     */
    default void deleteView(
        com.google.logging.v2.DeleteViewRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteViewMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists sinks.
     * </pre>
     */
    default void listSinks(
        com.google.logging.v2.ListSinksRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListSinksResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListSinksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a sink.
     * </pre>
     */
    default void getSink(
        com.google.logging.v2.GetSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogSink> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a sink that exports specified log entries to a destination. The
     * export of newly-ingested log entries begins immediately, unless the sink's
     * `writer_identity` is not permitted to write to the destination. A sink can
     * export log entries only from the resource owning the sink.
     * </pre>
     */
    default void createSink(
        com.google.logging.v2.CreateSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogSink> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateSinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a sink. This method replaces the following fields in the existing
     * sink with values from the new sink: `destination`, and `filter`.
     * The updated sink might also have a new `writer_identity`; see the
     * `unique_writer_identity` field.
     * </pre>
     */
    default void updateSink(
        com.google.logging.v2.UpdateSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogSink> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateSinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a sink. If the sink has a unique `writer_identity`, then that
     * service account is also deleted.
     * </pre>
     */
    default void deleteSink(
        com.google.logging.v2.DeleteSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteSinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Asynchronously creates a linked dataset in BigQuery which makes it possible
     * to use BigQuery to read the logs stored in the log bucket. A log bucket may
     * currently only contain one link.
     * </pre>
     */
    default void createLink(
        com.google.logging.v2.CreateLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a link. This will also delete the corresponding BigQuery linked
     * dataset.
     * </pre>
     */
    default void deleteLink(
        com.google.logging.v2.DeleteLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists links.
     * </pre>
     */
    default void listLinks(
        com.google.logging.v2.ListLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListLinksResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListLinksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a link.
     * </pre>
     */
    default void getLink(
        com.google.logging.v2.GetLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.Link> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the exclusions on the _Default sink in a parent resource.
     * </pre>
     */
    default void listExclusions(
        com.google.logging.v2.ListExclusionsRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListExclusionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListExclusionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the description of an exclusion in the _Default sink.
     * </pre>
     */
    default void getExclusion(
        com.google.logging.v2.GetExclusionRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogExclusion> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetExclusionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new exclusion in the _Default sink in a specified parent
     * resource. Only log entries belonging to that resource can be excluded. You
     * can have up to 10 exclusions in a resource.
     * </pre>
     */
    default void createExclusion(
        com.google.logging.v2.CreateExclusionRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogExclusion> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateExclusionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Changes one or more properties of an existing exclusion in the _Default
     * sink.
     * </pre>
     */
    default void updateExclusion(
        com.google.logging.v2.UpdateExclusionRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogExclusion> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateExclusionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an exclusion in the _Default sink.
     * </pre>
     */
    default void deleteExclusion(
        com.google.logging.v2.DeleteExclusionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteExclusionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the Logging CMEK settings for the given resource.
     * Note: CMEK for the Log Router can be configured for Google Cloud projects,
     * folders, organizations and billing accounts. Once configured for an
     * organization, it applies to all projects and folders in the Google Cloud
     * organization.
     * See [Enabling CMEK for Log
     * Router](https://cloud.google.com/logging/docs/routing/managed-encryption)
     * for more information.
     * </pre>
     */
    default void getCmekSettings(
        com.google.logging.v2.GetCmekSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.CmekSettings> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCmekSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the Log Router CMEK settings for the given resource.
     * Note: CMEK for the Log Router can currently only be configured for Google
     * Cloud organizations. Once configured, it applies to all projects and
     * folders in the Google Cloud organization.
     * [UpdateCmekSettings][google.logging.v2.ConfigServiceV2.UpdateCmekSettings]
     * will fail if 1) `kms_key_name` is invalid, or 2) the associated service
     * account does not have the required
     * `roles/cloudkms.cryptoKeyEncrypterDecrypter` role assigned for the key, or
     * 3) access to the key is disabled.
     * See [Enabling CMEK for Log
     * Router](https://cloud.google.com/logging/docs/routing/managed-encryption)
     * for more information.
     * </pre>
     */
    default void updateCmekSettings(
        com.google.logging.v2.UpdateCmekSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.CmekSettings> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateCmekSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the Log Router settings for the given resource.
     * Note: Settings for the Log Router can be get for Google Cloud projects,
     * folders, organizations and billing accounts. Currently it can only be
     * configured for organizations. Once configured for an organization, it
     * applies to all projects and folders in the Google Cloud organization.
     * See [Enabling CMEK for Log
     * Router](https://cloud.google.com/logging/docs/routing/managed-encryption)
     * for more information.
     * </pre>
     */
    default void getSettings(
        com.google.logging.v2.GetSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.Settings> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the Log Router settings for the given resource.
     * Note: Settings for the Log Router can currently only be configured for
     * Google Cloud organizations. Once configured, it applies to all projects and
     * folders in the Google Cloud organization.
     * [UpdateSettings][google.logging.v2.ConfigServiceV2.UpdateSettings]
     * will fail if 1) `kms_key_name` is invalid, or 2) the associated service
     * account does not have the required
     * `roles/cloudkms.cryptoKeyEncrypterDecrypter` role assigned for the key, or
     * 3) access to the key is disabled. 4) `location_id` is not supported by
     * Logging. 5) `location_id` violate OrgPolicy.
     * See [Enabling CMEK for Log
     * Router](https://cloud.google.com/logging/docs/routing/managed-encryption)
     * for more information.
     * </pre>
     */
    default void updateSettings(
        com.google.logging.v2.UpdateSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.Settings> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Copies a set of log entries from a log bucket to a Cloud Storage bucket.
     * </pre>
     */
    default void copyLogEntries(
        com.google.logging.v2.CopyLogEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCopyLogEntriesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ConfigServiceV2.
   *
   * <pre>
   * Service for configuring sinks used to route log entries.
   * </pre>
   */
  public abstract static class ConfigServiceV2ImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ConfigServiceV2Grpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ConfigServiceV2.
   *
   * <pre>
   * Service for configuring sinks used to route log entries.
   * </pre>
   */
  public static final class ConfigServiceV2Stub
      extends io.grpc.stub.AbstractAsyncStub<ConfigServiceV2Stub> {
    private ConfigServiceV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigServiceV2Stub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConfigServiceV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists log buckets.
     * </pre>
     */
    public void listBuckets(
        com.google.logging.v2.ListBucketsRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListBucketsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBucketsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a log bucket.
     * </pre>
     */
    public void getBucket(
        com.google.logging.v2.GetBucketRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogBucket> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBucketMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a log bucket asynchronously that can be used to store log entries.
     * After a bucket has been created, the bucket's location cannot be changed.
     * </pre>
     */
    public void createBucketAsync(
        com.google.logging.v2.CreateBucketRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBucketAsyncMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a log bucket asynchronously.
     * If the bucket has a `lifecycle_state` of `DELETE_REQUESTED`, then
     * `FAILED_PRECONDITION` will be returned.
     * After a bucket has been created, the bucket's location cannot be changed.
     * </pre>
     */
    public void updateBucketAsync(
        com.google.logging.v2.UpdateBucketRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateBucketAsyncMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a log bucket that can be used to store log entries. After a bucket
     * has been created, the bucket's location cannot be changed.
     * </pre>
     */
    public void createBucket(
        com.google.logging.v2.CreateBucketRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogBucket> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBucketMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a log bucket.
     * If the bucket has a `lifecycle_state` of `DELETE_REQUESTED`, then
     * `FAILED_PRECONDITION` will be returned.
     * After a bucket has been created, the bucket's location cannot be changed.
     * </pre>
     */
    public void updateBucket(
        com.google.logging.v2.UpdateBucketRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogBucket> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateBucketMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a log bucket.
     * Changes the bucket's `lifecycle_state` to the `DELETE_REQUESTED` state.
     * After 7 days, the bucket will be purged and all log entries in the bucket
     * will be permanently deleted.
     * </pre>
     */
    public void deleteBucket(
        com.google.logging.v2.DeleteBucketRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteBucketMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Undeletes a log bucket. A bucket that has been deleted can be undeleted
     * within the grace period of 7 days.
     * </pre>
     */
    public void undeleteBucket(
        com.google.logging.v2.UndeleteBucketRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUndeleteBucketMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists views on a log bucket.
     * </pre>
     */
    public void listViews(
        com.google.logging.v2.ListViewsRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListViewsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListViewsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a view on a log bucket..
     * </pre>
     */
    public void getView(
        com.google.logging.v2.GetViewRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogView> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetViewMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a view over log entries in a log bucket. A bucket may contain a
     * maximum of 30 views.
     * </pre>
     */
    public void createView(
        com.google.logging.v2.CreateViewRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogView> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateViewMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a view on a log bucket. This method replaces the following fields
     * in the existing view with values from the new view: `filter`.
     * If an `UNAVAILABLE` error is returned, this indicates that system is not in
     * a state where it can update the view. If this occurs, please try again in a
     * few minutes.
     * </pre>
     */
    public void updateView(
        com.google.logging.v2.UpdateViewRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogView> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateViewMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a view on a log bucket.
     * If an `UNAVAILABLE` error is returned, this indicates that system is not in
     * a state where it can delete the view. If this occurs, please try again in a
     * few minutes.
     * </pre>
     */
    public void deleteView(
        com.google.logging.v2.DeleteViewRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteViewMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists sinks.
     * </pre>
     */
    public void listSinks(
        com.google.logging.v2.ListSinksRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListSinksResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSinksMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a sink.
     * </pre>
     */
    public void getSink(
        com.google.logging.v2.GetSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogSink> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSinkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a sink that exports specified log entries to a destination. The
     * export of newly-ingested log entries begins immediately, unless the sink's
     * `writer_identity` is not permitted to write to the destination. A sink can
     * export log entries only from the resource owning the sink.
     * </pre>
     */
    public void createSink(
        com.google.logging.v2.CreateSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogSink> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSinkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a sink. This method replaces the following fields in the existing
     * sink with values from the new sink: `destination`, and `filter`.
     * The updated sink might also have a new `writer_identity`; see the
     * `unique_writer_identity` field.
     * </pre>
     */
    public void updateSink(
        com.google.logging.v2.UpdateSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogSink> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSinkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a sink. If the sink has a unique `writer_identity`, then that
     * service account is also deleted.
     * </pre>
     */
    public void deleteSink(
        com.google.logging.v2.DeleteSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSinkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Asynchronously creates a linked dataset in BigQuery which makes it possible
     * to use BigQuery to read the logs stored in the log bucket. A log bucket may
     * currently only contain one link.
     * </pre>
     */
    public void createLink(
        com.google.logging.v2.CreateLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateLinkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a link. This will also delete the corresponding BigQuery linked
     * dataset.
     * </pre>
     */
    public void deleteLink(
        com.google.logging.v2.DeleteLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteLinkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists links.
     * </pre>
     */
    public void listLinks(
        com.google.logging.v2.ListLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListLinksResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListLinksMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a link.
     * </pre>
     */
    public void getLink(
        com.google.logging.v2.GetLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.Link> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLinkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the exclusions on the _Default sink in a parent resource.
     * </pre>
     */
    public void listExclusions(
        com.google.logging.v2.ListExclusionsRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListExclusionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListExclusionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the description of an exclusion in the _Default sink.
     * </pre>
     */
    public void getExclusion(
        com.google.logging.v2.GetExclusionRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogExclusion> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetExclusionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new exclusion in the _Default sink in a specified parent
     * resource. Only log entries belonging to that resource can be excluded. You
     * can have up to 10 exclusions in a resource.
     * </pre>
     */
    public void createExclusion(
        com.google.logging.v2.CreateExclusionRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogExclusion> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateExclusionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Changes one or more properties of an existing exclusion in the _Default
     * sink.
     * </pre>
     */
    public void updateExclusion(
        com.google.logging.v2.UpdateExclusionRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogExclusion> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateExclusionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an exclusion in the _Default sink.
     * </pre>
     */
    public void deleteExclusion(
        com.google.logging.v2.DeleteExclusionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteExclusionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the Logging CMEK settings for the given resource.
     * Note: CMEK for the Log Router can be configured for Google Cloud projects,
     * folders, organizations and billing accounts. Once configured for an
     * organization, it applies to all projects and folders in the Google Cloud
     * organization.
     * See [Enabling CMEK for Log
     * Router](https://cloud.google.com/logging/docs/routing/managed-encryption)
     * for more information.
     * </pre>
     */
    public void getCmekSettings(
        com.google.logging.v2.GetCmekSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.CmekSettings> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCmekSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the Log Router CMEK settings for the given resource.
     * Note: CMEK for the Log Router can currently only be configured for Google
     * Cloud organizations. Once configured, it applies to all projects and
     * folders in the Google Cloud organization.
     * [UpdateCmekSettings][google.logging.v2.ConfigServiceV2.UpdateCmekSettings]
     * will fail if 1) `kms_key_name` is invalid, or 2) the associated service
     * account does not have the required
     * `roles/cloudkms.cryptoKeyEncrypterDecrypter` role assigned for the key, or
     * 3) access to the key is disabled.
     * See [Enabling CMEK for Log
     * Router](https://cloud.google.com/logging/docs/routing/managed-encryption)
     * for more information.
     * </pre>
     */
    public void updateCmekSettings(
        com.google.logging.v2.UpdateCmekSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.CmekSettings> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCmekSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the Log Router settings for the given resource.
     * Note: Settings for the Log Router can be get for Google Cloud projects,
     * folders, organizations and billing accounts. Currently it can only be
     * configured for organizations. Once configured for an organization, it
     * applies to all projects and folders in the Google Cloud organization.
     * See [Enabling CMEK for Log
     * Router](https://cloud.google.com/logging/docs/routing/managed-encryption)
     * for more information.
     * </pre>
     */
    public void getSettings(
        com.google.logging.v2.GetSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.Settings> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the Log Router settings for the given resource.
     * Note: Settings for the Log Router can currently only be configured for
     * Google Cloud organizations. Once configured, it applies to all projects and
     * folders in the Google Cloud organization.
     * [UpdateSettings][google.logging.v2.ConfigServiceV2.UpdateSettings]
     * will fail if 1) `kms_key_name` is invalid, or 2) the associated service
     * account does not have the required
     * `roles/cloudkms.cryptoKeyEncrypterDecrypter` role assigned for the key, or
     * 3) access to the key is disabled. 4) `location_id` is not supported by
     * Logging. 5) `location_id` violate OrgPolicy.
     * See [Enabling CMEK for Log
     * Router](https://cloud.google.com/logging/docs/routing/managed-encryption)
     * for more information.
     * </pre>
     */
    public void updateSettings(
        com.google.logging.v2.UpdateSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.Settings> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Copies a set of log entries from a log bucket to a Cloud Storage bucket.
     * </pre>
     */
    public void copyLogEntries(
        com.google.logging.v2.CopyLogEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCopyLogEntriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ConfigServiceV2.
   *
   * <pre>
   * Service for configuring sinks used to route log entries.
   * </pre>
   */
  public static final class ConfigServiceV2BlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ConfigServiceV2BlockingStub> {
    private ConfigServiceV2BlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigServiceV2BlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConfigServiceV2BlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists log buckets.
     * </pre>
     */
    public com.google.logging.v2.ListBucketsResponse listBuckets(
        com.google.logging.v2.ListBucketsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBucketsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a log bucket.
     * </pre>
     */
    public com.google.logging.v2.LogBucket getBucket(
        com.google.logging.v2.GetBucketRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBucketMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a log bucket asynchronously that can be used to store log entries.
     * After a bucket has been created, the bucket's location cannot be changed.
     * </pre>
     */
    public com.google.longrunning.Operation createBucketAsync(
        com.google.logging.v2.CreateBucketRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBucketAsyncMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a log bucket asynchronously.
     * If the bucket has a `lifecycle_state` of `DELETE_REQUESTED`, then
     * `FAILED_PRECONDITION` will be returned.
     * After a bucket has been created, the bucket's location cannot be changed.
     * </pre>
     */
    public com.google.longrunning.Operation updateBucketAsync(
        com.google.logging.v2.UpdateBucketRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBucketAsyncMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a log bucket that can be used to store log entries. After a bucket
     * has been created, the bucket's location cannot be changed.
     * </pre>
     */
    public com.google.logging.v2.LogBucket createBucket(
        com.google.logging.v2.CreateBucketRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBucketMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a log bucket.
     * If the bucket has a `lifecycle_state` of `DELETE_REQUESTED`, then
     * `FAILED_PRECONDITION` will be returned.
     * After a bucket has been created, the bucket's location cannot be changed.
     * </pre>
     */
    public com.google.logging.v2.LogBucket updateBucket(
        com.google.logging.v2.UpdateBucketRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBucketMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a log bucket.
     * Changes the bucket's `lifecycle_state` to the `DELETE_REQUESTED` state.
     * After 7 days, the bucket will be purged and all log entries in the bucket
     * will be permanently deleted.
     * </pre>
     */
    public com.google.protobuf.Empty deleteBucket(
        com.google.logging.v2.DeleteBucketRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBucketMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Undeletes a log bucket. A bucket that has been deleted can be undeleted
     * within the grace period of 7 days.
     * </pre>
     */
    public com.google.protobuf.Empty undeleteBucket(
        com.google.logging.v2.UndeleteBucketRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeleteBucketMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists views on a log bucket.
     * </pre>
     */
    public com.google.logging.v2.ListViewsResponse listViews(
        com.google.logging.v2.ListViewsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListViewsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a view on a log bucket..
     * </pre>
     */
    public com.google.logging.v2.LogView getView(com.google.logging.v2.GetViewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetViewMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a view over log entries in a log bucket. A bucket may contain a
     * maximum of 30 views.
     * </pre>
     */
    public com.google.logging.v2.LogView createView(
        com.google.logging.v2.CreateViewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateViewMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a view on a log bucket. This method replaces the following fields
     * in the existing view with values from the new view: `filter`.
     * If an `UNAVAILABLE` error is returned, this indicates that system is not in
     * a state where it can update the view. If this occurs, please try again in a
     * few minutes.
     * </pre>
     */
    public com.google.logging.v2.LogView updateView(
        com.google.logging.v2.UpdateViewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateViewMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a view on a log bucket.
     * If an `UNAVAILABLE` error is returned, this indicates that system is not in
     * a state where it can delete the view. If this occurs, please try again in a
     * few minutes.
     * </pre>
     */
    public com.google.protobuf.Empty deleteView(com.google.logging.v2.DeleteViewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteViewMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists sinks.
     * </pre>
     */
    public com.google.logging.v2.ListSinksResponse listSinks(
        com.google.logging.v2.ListSinksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSinksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a sink.
     * </pre>
     */
    public com.google.logging.v2.LogSink getSink(com.google.logging.v2.GetSinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a sink that exports specified log entries to a destination. The
     * export of newly-ingested log entries begins immediately, unless the sink's
     * `writer_identity` is not permitted to write to the destination. A sink can
     * export log entries only from the resource owning the sink.
     * </pre>
     */
    public com.google.logging.v2.LogSink createSink(
        com.google.logging.v2.CreateSinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a sink. This method replaces the following fields in the existing
     * sink with values from the new sink: `destination`, and `filter`.
     * The updated sink might also have a new `writer_identity`; see the
     * `unique_writer_identity` field.
     * </pre>
     */
    public com.google.logging.v2.LogSink updateSink(
        com.google.logging.v2.UpdateSinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a sink. If the sink has a unique `writer_identity`, then that
     * service account is also deleted.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSink(com.google.logging.v2.DeleteSinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Asynchronously creates a linked dataset in BigQuery which makes it possible
     * to use BigQuery to read the logs stored in the log bucket. A log bucket may
     * currently only contain one link.
     * </pre>
     */
    public com.google.longrunning.Operation createLink(
        com.google.logging.v2.CreateLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a link. This will also delete the corresponding BigQuery linked
     * dataset.
     * </pre>
     */
    public com.google.longrunning.Operation deleteLink(
        com.google.logging.v2.DeleteLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists links.
     * </pre>
     */
    public com.google.logging.v2.ListLinksResponse listLinks(
        com.google.logging.v2.ListLinksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListLinksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a link.
     * </pre>
     */
    public com.google.logging.v2.Link getLink(com.google.logging.v2.GetLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the exclusions on the _Default sink in a parent resource.
     * </pre>
     */
    public com.google.logging.v2.ListExclusionsResponse listExclusions(
        com.google.logging.v2.ListExclusionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListExclusionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the description of an exclusion in the _Default sink.
     * </pre>
     */
    public com.google.logging.v2.LogExclusion getExclusion(
        com.google.logging.v2.GetExclusionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetExclusionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new exclusion in the _Default sink in a specified parent
     * resource. Only log entries belonging to that resource can be excluded. You
     * can have up to 10 exclusions in a resource.
     * </pre>
     */
    public com.google.logging.v2.LogExclusion createExclusion(
        com.google.logging.v2.CreateExclusionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateExclusionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Changes one or more properties of an existing exclusion in the _Default
     * sink.
     * </pre>
     */
    public com.google.logging.v2.LogExclusion updateExclusion(
        com.google.logging.v2.UpdateExclusionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateExclusionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an exclusion in the _Default sink.
     * </pre>
     */
    public com.google.protobuf.Empty deleteExclusion(
        com.google.logging.v2.DeleteExclusionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteExclusionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the Logging CMEK settings for the given resource.
     * Note: CMEK for the Log Router can be configured for Google Cloud projects,
     * folders, organizations and billing accounts. Once configured for an
     * organization, it applies to all projects and folders in the Google Cloud
     * organization.
     * See [Enabling CMEK for Log
     * Router](https://cloud.google.com/logging/docs/routing/managed-encryption)
     * for more information.
     * </pre>
     */
    public com.google.logging.v2.CmekSettings getCmekSettings(
        com.google.logging.v2.GetCmekSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCmekSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the Log Router CMEK settings for the given resource.
     * Note: CMEK for the Log Router can currently only be configured for Google
     * Cloud organizations. Once configured, it applies to all projects and
     * folders in the Google Cloud organization.
     * [UpdateCmekSettings][google.logging.v2.ConfigServiceV2.UpdateCmekSettings]
     * will fail if 1) `kms_key_name` is invalid, or 2) the associated service
     * account does not have the required
     * `roles/cloudkms.cryptoKeyEncrypterDecrypter` role assigned for the key, or
     * 3) access to the key is disabled.
     * See [Enabling CMEK for Log
     * Router](https://cloud.google.com/logging/docs/routing/managed-encryption)
     * for more information.
     * </pre>
     */
    public com.google.logging.v2.CmekSettings updateCmekSettings(
        com.google.logging.v2.UpdateCmekSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCmekSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the Log Router settings for the given resource.
     * Note: Settings for the Log Router can be get for Google Cloud projects,
     * folders, organizations and billing accounts. Currently it can only be
     * configured for organizations. Once configured for an organization, it
     * applies to all projects and folders in the Google Cloud organization.
     * See [Enabling CMEK for Log
     * Router](https://cloud.google.com/logging/docs/routing/managed-encryption)
     * for more information.
     * </pre>
     */
    public com.google.logging.v2.Settings getSettings(
        com.google.logging.v2.GetSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the Log Router settings for the given resource.
     * Note: Settings for the Log Router can currently only be configured for
     * Google Cloud organizations. Once configured, it applies to all projects and
     * folders in the Google Cloud organization.
     * [UpdateSettings][google.logging.v2.ConfigServiceV2.UpdateSettings]
     * will fail if 1) `kms_key_name` is invalid, or 2) the associated service
     * account does not have the required
     * `roles/cloudkms.cryptoKeyEncrypterDecrypter` role assigned for the key, or
     * 3) access to the key is disabled. 4) `location_id` is not supported by
     * Logging. 5) `location_id` violate OrgPolicy.
     * See [Enabling CMEK for Log
     * Router](https://cloud.google.com/logging/docs/routing/managed-encryption)
     * for more information.
     * </pre>
     */
    public com.google.logging.v2.Settings updateSettings(
        com.google.logging.v2.UpdateSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Copies a set of log entries from a log bucket to a Cloud Storage bucket.
     * </pre>
     */
    public com.google.longrunning.Operation copyLogEntries(
        com.google.logging.v2.CopyLogEntriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCopyLogEntriesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ConfigServiceV2.
   *
   * <pre>
   * Service for configuring sinks used to route log entries.
   * </pre>
   */
  public static final class ConfigServiceV2FutureStub
      extends io.grpc.stub.AbstractFutureStub<ConfigServiceV2FutureStub> {
    private ConfigServiceV2FutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigServiceV2FutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConfigServiceV2FutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists log buckets.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.logging.v2.ListBucketsResponse>
        listBuckets(com.google.logging.v2.ListBucketsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBucketsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a log bucket.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.LogBucket>
        getBucket(com.google.logging.v2.GetBucketRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBucketMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a log bucket asynchronously that can be used to store log entries.
     * After a bucket has been created, the bucket's location cannot be changed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createBucketAsync(com.google.logging.v2.CreateBucketRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBucketAsyncMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a log bucket asynchronously.
     * If the bucket has a `lifecycle_state` of `DELETE_REQUESTED`, then
     * `FAILED_PRECONDITION` will be returned.
     * After a bucket has been created, the bucket's location cannot be changed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateBucketAsync(com.google.logging.v2.UpdateBucketRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBucketAsyncMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a log bucket that can be used to store log entries. After a bucket
     * has been created, the bucket's location cannot be changed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.LogBucket>
        createBucket(com.google.logging.v2.CreateBucketRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBucketMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a log bucket.
     * If the bucket has a `lifecycle_state` of `DELETE_REQUESTED`, then
     * `FAILED_PRECONDITION` will be returned.
     * After a bucket has been created, the bucket's location cannot be changed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.LogBucket>
        updateBucket(com.google.logging.v2.UpdateBucketRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBucketMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a log bucket.
     * Changes the bucket's `lifecycle_state` to the `DELETE_REQUESTED` state.
     * After 7 days, the bucket will be purged and all log entries in the bucket
     * will be permanently deleted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteBucket(com.google.logging.v2.DeleteBucketRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBucketMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Undeletes a log bucket. A bucket that has been deleted can be undeleted
     * within the grace period of 7 days.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        undeleteBucket(com.google.logging.v2.UndeleteBucketRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUndeleteBucketMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists views on a log bucket.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.logging.v2.ListViewsResponse>
        listViews(com.google.logging.v2.ListViewsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListViewsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a view on a log bucket..
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.LogView>
        getView(com.google.logging.v2.GetViewRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetViewMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a view over log entries in a log bucket. A bucket may contain a
     * maximum of 30 views.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.LogView>
        createView(com.google.logging.v2.CreateViewRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateViewMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a view on a log bucket. This method replaces the following fields
     * in the existing view with values from the new view: `filter`.
     * If an `UNAVAILABLE` error is returned, this indicates that system is not in
     * a state where it can update the view. If this occurs, please try again in a
     * few minutes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.LogView>
        updateView(com.google.logging.v2.UpdateViewRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateViewMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a view on a log bucket.
     * If an `UNAVAILABLE` error is returned, this indicates that system is not in
     * a state where it can delete the view. If this occurs, please try again in a
     * few minutes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteView(
        com.google.logging.v2.DeleteViewRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteViewMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists sinks.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.logging.v2.ListSinksResponse>
        listSinks(com.google.logging.v2.ListSinksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSinksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a sink.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.LogSink>
        getSink(com.google.logging.v2.GetSinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a sink that exports specified log entries to a destination. The
     * export of newly-ingested log entries begins immediately, unless the sink's
     * `writer_identity` is not permitted to write to the destination. A sink can
     * export log entries only from the resource owning the sink.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.LogSink>
        createSink(com.google.logging.v2.CreateSinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a sink. This method replaces the following fields in the existing
     * sink with values from the new sink: `destination`, and `filter`.
     * The updated sink might also have a new `writer_identity`; see the
     * `unique_writer_identity` field.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.LogSink>
        updateSink(com.google.logging.v2.UpdateSinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a sink. If the sink has a unique `writer_identity`, then that
     * service account is also deleted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteSink(
        com.google.logging.v2.DeleteSinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Asynchronously creates a linked dataset in BigQuery which makes it possible
     * to use BigQuery to read the logs stored in the log bucket. A log bucket may
     * currently only contain one link.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createLink(com.google.logging.v2.CreateLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a link. This will also delete the corresponding BigQuery linked
     * dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteLink(com.google.logging.v2.DeleteLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists links.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.logging.v2.ListLinksResponse>
        listLinks(com.google.logging.v2.ListLinksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListLinksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a link.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.Link> getLink(
        com.google.logging.v2.GetLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the exclusions on the _Default sink in a parent resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.logging.v2.ListExclusionsResponse>
        listExclusions(com.google.logging.v2.ListExclusionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListExclusionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the description of an exclusion in the _Default sink.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.LogExclusion>
        getExclusion(com.google.logging.v2.GetExclusionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetExclusionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new exclusion in the _Default sink in a specified parent
     * resource. Only log entries belonging to that resource can be excluded. You
     * can have up to 10 exclusions in a resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.LogExclusion>
        createExclusion(com.google.logging.v2.CreateExclusionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateExclusionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Changes one or more properties of an existing exclusion in the _Default
     * sink.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.LogExclusion>
        updateExclusion(com.google.logging.v2.UpdateExclusionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateExclusionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an exclusion in the _Default sink.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteExclusion(com.google.logging.v2.DeleteExclusionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteExclusionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the Logging CMEK settings for the given resource.
     * Note: CMEK for the Log Router can be configured for Google Cloud projects,
     * folders, organizations and billing accounts. Once configured for an
     * organization, it applies to all projects and folders in the Google Cloud
     * organization.
     * See [Enabling CMEK for Log
     * Router](https://cloud.google.com/logging/docs/routing/managed-encryption)
     * for more information.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.CmekSettings>
        getCmekSettings(com.google.logging.v2.GetCmekSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCmekSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the Log Router CMEK settings for the given resource.
     * Note: CMEK for the Log Router can currently only be configured for Google
     * Cloud organizations. Once configured, it applies to all projects and
     * folders in the Google Cloud organization.
     * [UpdateCmekSettings][google.logging.v2.ConfigServiceV2.UpdateCmekSettings]
     * will fail if 1) `kms_key_name` is invalid, or 2) the associated service
     * account does not have the required
     * `roles/cloudkms.cryptoKeyEncrypterDecrypter` role assigned for the key, or
     * 3) access to the key is disabled.
     * See [Enabling CMEK for Log
     * Router](https://cloud.google.com/logging/docs/routing/managed-encryption)
     * for more information.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.CmekSettings>
        updateCmekSettings(com.google.logging.v2.UpdateCmekSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCmekSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the Log Router settings for the given resource.
     * Note: Settings for the Log Router can be get for Google Cloud projects,
     * folders, organizations and billing accounts. Currently it can only be
     * configured for organizations. Once configured for an organization, it
     * applies to all projects and folders in the Google Cloud organization.
     * See [Enabling CMEK for Log
     * Router](https://cloud.google.com/logging/docs/routing/managed-encryption)
     * for more information.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.Settings>
        getSettings(com.google.logging.v2.GetSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the Log Router settings for the given resource.
     * Note: Settings for the Log Router can currently only be configured for
     * Google Cloud organizations. Once configured, it applies to all projects and
     * folders in the Google Cloud organization.
     * [UpdateSettings][google.logging.v2.ConfigServiceV2.UpdateSettings]
     * will fail if 1) `kms_key_name` is invalid, or 2) the associated service
     * account does not have the required
     * `roles/cloudkms.cryptoKeyEncrypterDecrypter` role assigned for the key, or
     * 3) access to the key is disabled. 4) `location_id` is not supported by
     * Logging. 5) `location_id` violate OrgPolicy.
     * See [Enabling CMEK for Log
     * Router](https://cloud.google.com/logging/docs/routing/managed-encryption)
     * for more information.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.Settings>
        updateSettings(com.google.logging.v2.UpdateSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Copies a set of log entries from a log bucket to a Cloud Storage bucket.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        copyLogEntries(com.google.logging.v2.CopyLogEntriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCopyLogEntriesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_BUCKETS = 0;
  private static final int METHODID_GET_BUCKET = 1;
  private static final int METHODID_CREATE_BUCKET_ASYNC = 2;
  private static final int METHODID_UPDATE_BUCKET_ASYNC = 3;
  private static final int METHODID_CREATE_BUCKET = 4;
  private static final int METHODID_UPDATE_BUCKET = 5;
  private static final int METHODID_DELETE_BUCKET = 6;
  private static final int METHODID_UNDELETE_BUCKET = 7;
  private static final int METHODID_LIST_VIEWS = 8;
  private static final int METHODID_GET_VIEW = 9;
  private static final int METHODID_CREATE_VIEW = 10;
  private static final int METHODID_UPDATE_VIEW = 11;
  private static final int METHODID_DELETE_VIEW = 12;
  private static final int METHODID_LIST_SINKS = 13;
  private static final int METHODID_GET_SINK = 14;
  private static final int METHODID_CREATE_SINK = 15;
  private static final int METHODID_UPDATE_SINK = 16;
  private static final int METHODID_DELETE_SINK = 17;
  private static final int METHODID_CREATE_LINK = 18;
  private static final int METHODID_DELETE_LINK = 19;
  private static final int METHODID_LIST_LINKS = 20;
  private static final int METHODID_GET_LINK = 21;
  private static final int METHODID_LIST_EXCLUSIONS = 22;
  private static final int METHODID_GET_EXCLUSION = 23;
  private static final int METHODID_CREATE_EXCLUSION = 24;
  private static final int METHODID_UPDATE_EXCLUSION = 25;
  private static final int METHODID_DELETE_EXCLUSION = 26;
  private static final int METHODID_GET_CMEK_SETTINGS = 27;
  private static final int METHODID_UPDATE_CMEK_SETTINGS = 28;
  private static final int METHODID_GET_SETTINGS = 29;
  private static final int METHODID_UPDATE_SETTINGS = 30;
  private static final int METHODID_COPY_LOG_ENTRIES = 31;

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
        case METHODID_LIST_BUCKETS:
          serviceImpl.listBuckets(
              (com.google.logging.v2.ListBucketsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.ListBucketsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_BUCKET:
          serviceImpl.getBucket(
              (com.google.logging.v2.GetBucketRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.LogBucket>) responseObserver);
          break;
        case METHODID_CREATE_BUCKET_ASYNC:
          serviceImpl.createBucketAsync(
              (com.google.logging.v2.CreateBucketRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_BUCKET_ASYNC:
          serviceImpl.updateBucketAsync(
              (com.google.logging.v2.UpdateBucketRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_BUCKET:
          serviceImpl.createBucket(
              (com.google.logging.v2.CreateBucketRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.LogBucket>) responseObserver);
          break;
        case METHODID_UPDATE_BUCKET:
          serviceImpl.updateBucket(
              (com.google.logging.v2.UpdateBucketRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.LogBucket>) responseObserver);
          break;
        case METHODID_DELETE_BUCKET:
          serviceImpl.deleteBucket(
              (com.google.logging.v2.DeleteBucketRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UNDELETE_BUCKET:
          serviceImpl.undeleteBucket(
              (com.google.logging.v2.UndeleteBucketRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_VIEWS:
          serviceImpl.listViews(
              (com.google.logging.v2.ListViewsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.ListViewsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_VIEW:
          serviceImpl.getView(
              (com.google.logging.v2.GetViewRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.LogView>) responseObserver);
          break;
        case METHODID_CREATE_VIEW:
          serviceImpl.createView(
              (com.google.logging.v2.CreateViewRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.LogView>) responseObserver);
          break;
        case METHODID_UPDATE_VIEW:
          serviceImpl.updateView(
              (com.google.logging.v2.UpdateViewRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.LogView>) responseObserver);
          break;
        case METHODID_DELETE_VIEW:
          serviceImpl.deleteView(
              (com.google.logging.v2.DeleteViewRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_SINKS:
          serviceImpl.listSinks(
              (com.google.logging.v2.ListSinksRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.ListSinksResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SINK:
          serviceImpl.getSink(
              (com.google.logging.v2.GetSinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.LogSink>) responseObserver);
          break;
        case METHODID_CREATE_SINK:
          serviceImpl.createSink(
              (com.google.logging.v2.CreateSinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.LogSink>) responseObserver);
          break;
        case METHODID_UPDATE_SINK:
          serviceImpl.updateSink(
              (com.google.logging.v2.UpdateSinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.LogSink>) responseObserver);
          break;
        case METHODID_DELETE_SINK:
          serviceImpl.deleteSink(
              (com.google.logging.v2.DeleteSinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_LINK:
          serviceImpl.createLink(
              (com.google.logging.v2.CreateLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_LINK:
          serviceImpl.deleteLink(
              (com.google.logging.v2.DeleteLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_LINKS:
          serviceImpl.listLinks(
              (com.google.logging.v2.ListLinksRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.ListLinksResponse>)
                  responseObserver);
          break;
        case METHODID_GET_LINK:
          serviceImpl.getLink(
              (com.google.logging.v2.GetLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.Link>) responseObserver);
          break;
        case METHODID_LIST_EXCLUSIONS:
          serviceImpl.listExclusions(
              (com.google.logging.v2.ListExclusionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.ListExclusionsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_EXCLUSION:
          serviceImpl.getExclusion(
              (com.google.logging.v2.GetExclusionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.LogExclusion>) responseObserver);
          break;
        case METHODID_CREATE_EXCLUSION:
          serviceImpl.createExclusion(
              (com.google.logging.v2.CreateExclusionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.LogExclusion>) responseObserver);
          break;
        case METHODID_UPDATE_EXCLUSION:
          serviceImpl.updateExclusion(
              (com.google.logging.v2.UpdateExclusionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.LogExclusion>) responseObserver);
          break;
        case METHODID_DELETE_EXCLUSION:
          serviceImpl.deleteExclusion(
              (com.google.logging.v2.DeleteExclusionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_CMEK_SETTINGS:
          serviceImpl.getCmekSettings(
              (com.google.logging.v2.GetCmekSettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.CmekSettings>) responseObserver);
          break;
        case METHODID_UPDATE_CMEK_SETTINGS:
          serviceImpl.updateCmekSettings(
              (com.google.logging.v2.UpdateCmekSettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.CmekSettings>) responseObserver);
          break;
        case METHODID_GET_SETTINGS:
          serviceImpl.getSettings(
              (com.google.logging.v2.GetSettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.Settings>) responseObserver);
          break;
        case METHODID_UPDATE_SETTINGS:
          serviceImpl.updateSettings(
              (com.google.logging.v2.UpdateSettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.Settings>) responseObserver);
          break;
        case METHODID_COPY_LOG_ENTRIES:
          serviceImpl.copyLogEntries(
              (com.google.logging.v2.CopyLogEntriesRequest) request,
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
            getListBucketsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.ListBucketsRequest,
                    com.google.logging.v2.ListBucketsResponse>(service, METHODID_LIST_BUCKETS)))
        .addMethod(
            getGetBucketMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.GetBucketRequest, com.google.logging.v2.LogBucket>(
                    service, METHODID_GET_BUCKET)))
        .addMethod(
            getCreateBucketAsyncMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.CreateBucketRequest, com.google.longrunning.Operation>(
                    service, METHODID_CREATE_BUCKET_ASYNC)))
        .addMethod(
            getUpdateBucketAsyncMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.UpdateBucketRequest, com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_BUCKET_ASYNC)))
        .addMethod(
            getCreateBucketMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.CreateBucketRequest, com.google.logging.v2.LogBucket>(
                    service, METHODID_CREATE_BUCKET)))
        .addMethod(
            getUpdateBucketMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.UpdateBucketRequest, com.google.logging.v2.LogBucket>(
                    service, METHODID_UPDATE_BUCKET)))
        .addMethod(
            getDeleteBucketMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.DeleteBucketRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_BUCKET)))
        .addMethod(
            getUndeleteBucketMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.UndeleteBucketRequest, com.google.protobuf.Empty>(
                    service, METHODID_UNDELETE_BUCKET)))
        .addMethod(
            getListViewsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.ListViewsRequest,
                    com.google.logging.v2.ListViewsResponse>(service, METHODID_LIST_VIEWS)))
        .addMethod(
            getGetViewMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.GetViewRequest, com.google.logging.v2.LogView>(
                    service, METHODID_GET_VIEW)))
        .addMethod(
            getCreateViewMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.CreateViewRequest, com.google.logging.v2.LogView>(
                    service, METHODID_CREATE_VIEW)))
        .addMethod(
            getUpdateViewMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.UpdateViewRequest, com.google.logging.v2.LogView>(
                    service, METHODID_UPDATE_VIEW)))
        .addMethod(
            getDeleteViewMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.DeleteViewRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_VIEW)))
        .addMethod(
            getListSinksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.ListSinksRequest,
                    com.google.logging.v2.ListSinksResponse>(service, METHODID_LIST_SINKS)))
        .addMethod(
            getGetSinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.GetSinkRequest, com.google.logging.v2.LogSink>(
                    service, METHODID_GET_SINK)))
        .addMethod(
            getCreateSinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.CreateSinkRequest, com.google.logging.v2.LogSink>(
                    service, METHODID_CREATE_SINK)))
        .addMethod(
            getUpdateSinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.UpdateSinkRequest, com.google.logging.v2.LogSink>(
                    service, METHODID_UPDATE_SINK)))
        .addMethod(
            getDeleteSinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.DeleteSinkRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_SINK)))
        .addMethod(
            getCreateLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.CreateLinkRequest, com.google.longrunning.Operation>(
                    service, METHODID_CREATE_LINK)))
        .addMethod(
            getDeleteLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.DeleteLinkRequest, com.google.longrunning.Operation>(
                    service, METHODID_DELETE_LINK)))
        .addMethod(
            getListLinksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.ListLinksRequest,
                    com.google.logging.v2.ListLinksResponse>(service, METHODID_LIST_LINKS)))
        .addMethod(
            getGetLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.GetLinkRequest, com.google.logging.v2.Link>(
                    service, METHODID_GET_LINK)))
        .addMethod(
            getListExclusionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.ListExclusionsRequest,
                    com.google.logging.v2.ListExclusionsResponse>(
                    service, METHODID_LIST_EXCLUSIONS)))
        .addMethod(
            getGetExclusionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.GetExclusionRequest, com.google.logging.v2.LogExclusion>(
                    service, METHODID_GET_EXCLUSION)))
        .addMethod(
            getCreateExclusionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.CreateExclusionRequest,
                    com.google.logging.v2.LogExclusion>(service, METHODID_CREATE_EXCLUSION)))
        .addMethod(
            getUpdateExclusionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.UpdateExclusionRequest,
                    com.google.logging.v2.LogExclusion>(service, METHODID_UPDATE_EXCLUSION)))
        .addMethod(
            getDeleteExclusionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.DeleteExclusionRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_EXCLUSION)))
        .addMethod(
            getGetCmekSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.GetCmekSettingsRequest,
                    com.google.logging.v2.CmekSettings>(service, METHODID_GET_CMEK_SETTINGS)))
        .addMethod(
            getUpdateCmekSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.UpdateCmekSettingsRequest,
                    com.google.logging.v2.CmekSettings>(service, METHODID_UPDATE_CMEK_SETTINGS)))
        .addMethod(
            getGetSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.GetSettingsRequest, com.google.logging.v2.Settings>(
                    service, METHODID_GET_SETTINGS)))
        .addMethod(
            getUpdateSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.UpdateSettingsRequest, com.google.logging.v2.Settings>(
                    service, METHODID_UPDATE_SETTINGS)))
        .addMethod(
            getCopyLogEntriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.CopyLogEntriesRequest, com.google.longrunning.Operation>(
                    service, METHODID_COPY_LOG_ENTRIES)))
        .build();
  }

  private abstract static class ConfigServiceV2BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConfigServiceV2BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.logging.v2.LoggingConfigProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ConfigServiceV2");
    }
  }

  private static final class ConfigServiceV2FileDescriptorSupplier
      extends ConfigServiceV2BaseDescriptorSupplier {
    ConfigServiceV2FileDescriptorSupplier() {}
  }

  private static final class ConfigServiceV2MethodDescriptorSupplier
      extends ConfigServiceV2BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ConfigServiceV2MethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ConfigServiceV2Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ConfigServiceV2FileDescriptorSupplier())
                      .addMethod(getListBucketsMethod())
                      .addMethod(getGetBucketMethod())
                      .addMethod(getCreateBucketAsyncMethod())
                      .addMethod(getUpdateBucketAsyncMethod())
                      .addMethod(getCreateBucketMethod())
                      .addMethod(getUpdateBucketMethod())
                      .addMethod(getDeleteBucketMethod())
                      .addMethod(getUndeleteBucketMethod())
                      .addMethod(getListViewsMethod())
                      .addMethod(getGetViewMethod())
                      .addMethod(getCreateViewMethod())
                      .addMethod(getUpdateViewMethod())
                      .addMethod(getDeleteViewMethod())
                      .addMethod(getListSinksMethod())
                      .addMethod(getGetSinkMethod())
                      .addMethod(getCreateSinkMethod())
                      .addMethod(getUpdateSinkMethod())
                      .addMethod(getDeleteSinkMethod())
                      .addMethod(getCreateLinkMethod())
                      .addMethod(getDeleteLinkMethod())
                      .addMethod(getListLinksMethod())
                      .addMethod(getGetLinkMethod())
                      .addMethod(getListExclusionsMethod())
                      .addMethod(getGetExclusionMethod())
                      .addMethod(getCreateExclusionMethod())
                      .addMethod(getUpdateExclusionMethod())
                      .addMethod(getDeleteExclusionMethod())
                      .addMethod(getGetCmekSettingsMethod())
                      .addMethod(getUpdateCmekSettingsMethod())
                      .addMethod(getGetSettingsMethod())
                      .addMethod(getUpdateSettingsMethod())
                      .addMethod(getCopyLogEntriesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
