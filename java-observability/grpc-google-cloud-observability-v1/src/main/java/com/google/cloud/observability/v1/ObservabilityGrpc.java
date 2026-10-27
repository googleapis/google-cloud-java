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
package com.google.cloud.observability.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service describing handlers for resources
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class ObservabilityGrpc {

  private ObservabilityGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.observability.v1.Observability";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.GetScopeRequest,
          com.google.cloud.observability.v1.Scope>
      getGetScopeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetScope",
      requestType = com.google.cloud.observability.v1.GetScopeRequest.class,
      responseType = com.google.cloud.observability.v1.Scope.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.GetScopeRequest,
          com.google.cloud.observability.v1.Scope>
      getGetScopeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.observability.v1.GetScopeRequest,
            com.google.cloud.observability.v1.Scope>
        getGetScopeMethod;
    if ((getGetScopeMethod = ObservabilityGrpc.getGetScopeMethod) == null) {
      synchronized (ObservabilityGrpc.class) {
        if ((getGetScopeMethod = ObservabilityGrpc.getGetScopeMethod) == null) {
          ObservabilityGrpc.getGetScopeMethod =
              getGetScopeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.observability.v1.GetScopeRequest,
                          com.google.cloud.observability.v1.Scope>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetScope"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.GetScopeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.Scope.getDefaultInstance()))
                      .setSchemaDescriptor(new ObservabilityMethodDescriptorSupplier("GetScope"))
                      .build();
        }
      }
    }
    return getGetScopeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.UpdateScopeRequest,
          com.google.cloud.observability.v1.Scope>
      getUpdateScopeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateScope",
      requestType = com.google.cloud.observability.v1.UpdateScopeRequest.class,
      responseType = com.google.cloud.observability.v1.Scope.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.UpdateScopeRequest,
          com.google.cloud.observability.v1.Scope>
      getUpdateScopeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.observability.v1.UpdateScopeRequest,
            com.google.cloud.observability.v1.Scope>
        getUpdateScopeMethod;
    if ((getUpdateScopeMethod = ObservabilityGrpc.getUpdateScopeMethod) == null) {
      synchronized (ObservabilityGrpc.class) {
        if ((getUpdateScopeMethod = ObservabilityGrpc.getUpdateScopeMethod) == null) {
          ObservabilityGrpc.getUpdateScopeMethod =
              getUpdateScopeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.observability.v1.UpdateScopeRequest,
                          com.google.cloud.observability.v1.Scope>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateScope"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.UpdateScopeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.Scope.getDefaultInstance()))
                      .setSchemaDescriptor(new ObservabilityMethodDescriptorSupplier("UpdateScope"))
                      .build();
        }
      }
    }
    return getUpdateScopeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.GetBucketRequest,
          com.google.cloud.observability.v1.Bucket>
      getGetBucketMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBucket",
      requestType = com.google.cloud.observability.v1.GetBucketRequest.class,
      responseType = com.google.cloud.observability.v1.Bucket.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.GetBucketRequest,
          com.google.cloud.observability.v1.Bucket>
      getGetBucketMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.observability.v1.GetBucketRequest,
            com.google.cloud.observability.v1.Bucket>
        getGetBucketMethod;
    if ((getGetBucketMethod = ObservabilityGrpc.getGetBucketMethod) == null) {
      synchronized (ObservabilityGrpc.class) {
        if ((getGetBucketMethod = ObservabilityGrpc.getGetBucketMethod) == null) {
          ObservabilityGrpc.getGetBucketMethod =
              getGetBucketMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.observability.v1.GetBucketRequest,
                          com.google.cloud.observability.v1.Bucket>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBucket"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.GetBucketRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.Bucket.getDefaultInstance()))
                      .setSchemaDescriptor(new ObservabilityMethodDescriptorSupplier("GetBucket"))
                      .build();
        }
      }
    }
    return getGetBucketMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.ListBucketsRequest,
          com.google.cloud.observability.v1.ListBucketsResponse>
      getListBucketsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBuckets",
      requestType = com.google.cloud.observability.v1.ListBucketsRequest.class,
      responseType = com.google.cloud.observability.v1.ListBucketsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.ListBucketsRequest,
          com.google.cloud.observability.v1.ListBucketsResponse>
      getListBucketsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.observability.v1.ListBucketsRequest,
            com.google.cloud.observability.v1.ListBucketsResponse>
        getListBucketsMethod;
    if ((getListBucketsMethod = ObservabilityGrpc.getListBucketsMethod) == null) {
      synchronized (ObservabilityGrpc.class) {
        if ((getListBucketsMethod = ObservabilityGrpc.getListBucketsMethod) == null) {
          ObservabilityGrpc.getListBucketsMethod =
              getListBucketsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.observability.v1.ListBucketsRequest,
                          com.google.cloud.observability.v1.ListBucketsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBuckets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.ListBucketsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.ListBucketsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ObservabilityMethodDescriptorSupplier("ListBuckets"))
                      .build();
        }
      }
    }
    return getListBucketsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.CreateBucketRequest, com.google.longrunning.Operation>
      getCreateBucketMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBucket",
      requestType = com.google.cloud.observability.v1.CreateBucketRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.CreateBucketRequest, com.google.longrunning.Operation>
      getCreateBucketMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.observability.v1.CreateBucketRequest, com.google.longrunning.Operation>
        getCreateBucketMethod;
    if ((getCreateBucketMethod = ObservabilityGrpc.getCreateBucketMethod) == null) {
      synchronized (ObservabilityGrpc.class) {
        if ((getCreateBucketMethod = ObservabilityGrpc.getCreateBucketMethod) == null) {
          ObservabilityGrpc.getCreateBucketMethod =
              getCreateBucketMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.observability.v1.CreateBucketRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBucket"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.CreateBucketRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ObservabilityMethodDescriptorSupplier("CreateBucket"))
                      .build();
        }
      }
    }
    return getCreateBucketMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.UpdateBucketRequest, com.google.longrunning.Operation>
      getUpdateBucketMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBucket",
      requestType = com.google.cloud.observability.v1.UpdateBucketRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.UpdateBucketRequest, com.google.longrunning.Operation>
      getUpdateBucketMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.observability.v1.UpdateBucketRequest, com.google.longrunning.Operation>
        getUpdateBucketMethod;
    if ((getUpdateBucketMethod = ObservabilityGrpc.getUpdateBucketMethod) == null) {
      synchronized (ObservabilityGrpc.class) {
        if ((getUpdateBucketMethod = ObservabilityGrpc.getUpdateBucketMethod) == null) {
          ObservabilityGrpc.getUpdateBucketMethod =
              getUpdateBucketMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.observability.v1.UpdateBucketRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateBucket"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.UpdateBucketRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ObservabilityMethodDescriptorSupplier("UpdateBucket"))
                      .build();
        }
      }
    }
    return getUpdateBucketMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.GetDatasetRequest,
          com.google.cloud.observability.v1.Dataset>
      getGetDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataset",
      requestType = com.google.cloud.observability.v1.GetDatasetRequest.class,
      responseType = com.google.cloud.observability.v1.Dataset.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.GetDatasetRequest,
          com.google.cloud.observability.v1.Dataset>
      getGetDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.observability.v1.GetDatasetRequest,
            com.google.cloud.observability.v1.Dataset>
        getGetDatasetMethod;
    if ((getGetDatasetMethod = ObservabilityGrpc.getGetDatasetMethod) == null) {
      synchronized (ObservabilityGrpc.class) {
        if ((getGetDatasetMethod = ObservabilityGrpc.getGetDatasetMethod) == null) {
          ObservabilityGrpc.getGetDatasetMethod =
              getGetDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.observability.v1.GetDatasetRequest,
                          com.google.cloud.observability.v1.Dataset>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.GetDatasetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.Dataset.getDefaultInstance()))
                      .setSchemaDescriptor(new ObservabilityMethodDescriptorSupplier("GetDataset"))
                      .build();
        }
      }
    }
    return getGetDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.ListDatasetsRequest,
          com.google.cloud.observability.v1.ListDatasetsResponse>
      getListDatasetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDatasets",
      requestType = com.google.cloud.observability.v1.ListDatasetsRequest.class,
      responseType = com.google.cloud.observability.v1.ListDatasetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.ListDatasetsRequest,
          com.google.cloud.observability.v1.ListDatasetsResponse>
      getListDatasetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.observability.v1.ListDatasetsRequest,
            com.google.cloud.observability.v1.ListDatasetsResponse>
        getListDatasetsMethod;
    if ((getListDatasetsMethod = ObservabilityGrpc.getListDatasetsMethod) == null) {
      synchronized (ObservabilityGrpc.class) {
        if ((getListDatasetsMethod = ObservabilityGrpc.getListDatasetsMethod) == null) {
          ObservabilityGrpc.getListDatasetsMethod =
              getListDatasetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.observability.v1.ListDatasetsRequest,
                          com.google.cloud.observability.v1.ListDatasetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDatasets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.ListDatasetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.ListDatasetsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ObservabilityMethodDescriptorSupplier("ListDatasets"))
                      .build();
        }
      }
    }
    return getListDatasetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.GetViewRequest, com.google.cloud.observability.v1.View>
      getGetViewMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetView",
      requestType = com.google.cloud.observability.v1.GetViewRequest.class,
      responseType = com.google.cloud.observability.v1.View.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.GetViewRequest, com.google.cloud.observability.v1.View>
      getGetViewMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.observability.v1.GetViewRequest,
            com.google.cloud.observability.v1.View>
        getGetViewMethod;
    if ((getGetViewMethod = ObservabilityGrpc.getGetViewMethod) == null) {
      synchronized (ObservabilityGrpc.class) {
        if ((getGetViewMethod = ObservabilityGrpc.getGetViewMethod) == null) {
          ObservabilityGrpc.getGetViewMethod =
              getGetViewMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.observability.v1.GetViewRequest,
                          com.google.cloud.observability.v1.View>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetView"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.GetViewRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.View.getDefaultInstance()))
                      .setSchemaDescriptor(new ObservabilityMethodDescriptorSupplier("GetView"))
                      .build();
        }
      }
    }
    return getGetViewMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.ListViewsRequest,
          com.google.cloud.observability.v1.ListViewsResponse>
      getListViewsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListViews",
      requestType = com.google.cloud.observability.v1.ListViewsRequest.class,
      responseType = com.google.cloud.observability.v1.ListViewsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.ListViewsRequest,
          com.google.cloud.observability.v1.ListViewsResponse>
      getListViewsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.observability.v1.ListViewsRequest,
            com.google.cloud.observability.v1.ListViewsResponse>
        getListViewsMethod;
    if ((getListViewsMethod = ObservabilityGrpc.getListViewsMethod) == null) {
      synchronized (ObservabilityGrpc.class) {
        if ((getListViewsMethod = ObservabilityGrpc.getListViewsMethod) == null) {
          ObservabilityGrpc.getListViewsMethod =
              getListViewsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.observability.v1.ListViewsRequest,
                          com.google.cloud.observability.v1.ListViewsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListViews"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.ListViewsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.ListViewsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ObservabilityMethodDescriptorSupplier("ListViews"))
                      .build();
        }
      }
    }
    return getListViewsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.GetLinkRequest, com.google.cloud.observability.v1.Link>
      getGetLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLink",
      requestType = com.google.cloud.observability.v1.GetLinkRequest.class,
      responseType = com.google.cloud.observability.v1.Link.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.GetLinkRequest, com.google.cloud.observability.v1.Link>
      getGetLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.observability.v1.GetLinkRequest,
            com.google.cloud.observability.v1.Link>
        getGetLinkMethod;
    if ((getGetLinkMethod = ObservabilityGrpc.getGetLinkMethod) == null) {
      synchronized (ObservabilityGrpc.class) {
        if ((getGetLinkMethod = ObservabilityGrpc.getGetLinkMethod) == null) {
          ObservabilityGrpc.getGetLinkMethod =
              getGetLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.observability.v1.GetLinkRequest,
                          com.google.cloud.observability.v1.Link>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.GetLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.Link.getDefaultInstance()))
                      .setSchemaDescriptor(new ObservabilityMethodDescriptorSupplier("GetLink"))
                      .build();
        }
      }
    }
    return getGetLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.ListLinksRequest,
          com.google.cloud.observability.v1.ListLinksResponse>
      getListLinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListLinks",
      requestType = com.google.cloud.observability.v1.ListLinksRequest.class,
      responseType = com.google.cloud.observability.v1.ListLinksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.ListLinksRequest,
          com.google.cloud.observability.v1.ListLinksResponse>
      getListLinksMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.observability.v1.ListLinksRequest,
            com.google.cloud.observability.v1.ListLinksResponse>
        getListLinksMethod;
    if ((getListLinksMethod = ObservabilityGrpc.getListLinksMethod) == null) {
      synchronized (ObservabilityGrpc.class) {
        if ((getListLinksMethod = ObservabilityGrpc.getListLinksMethod) == null) {
          ObservabilityGrpc.getListLinksMethod =
              getListLinksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.observability.v1.ListLinksRequest,
                          com.google.cloud.observability.v1.ListLinksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListLinks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.ListLinksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.ListLinksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ObservabilityMethodDescriptorSupplier("ListLinks"))
                      .build();
        }
      }
    }
    return getListLinksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.CreateLinkRequest, com.google.longrunning.Operation>
      getCreateLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateLink",
      requestType = com.google.cloud.observability.v1.CreateLinkRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.CreateLinkRequest, com.google.longrunning.Operation>
      getCreateLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.observability.v1.CreateLinkRequest, com.google.longrunning.Operation>
        getCreateLinkMethod;
    if ((getCreateLinkMethod = ObservabilityGrpc.getCreateLinkMethod) == null) {
      synchronized (ObservabilityGrpc.class) {
        if ((getCreateLinkMethod = ObservabilityGrpc.getCreateLinkMethod) == null) {
          ObservabilityGrpc.getCreateLinkMethod =
              getCreateLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.observability.v1.CreateLinkRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.CreateLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new ObservabilityMethodDescriptorSupplier("CreateLink"))
                      .build();
        }
      }
    }
    return getCreateLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.UpdateLinkRequest, com.google.longrunning.Operation>
      getUpdateLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateLink",
      requestType = com.google.cloud.observability.v1.UpdateLinkRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.UpdateLinkRequest, com.google.longrunning.Operation>
      getUpdateLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.observability.v1.UpdateLinkRequest, com.google.longrunning.Operation>
        getUpdateLinkMethod;
    if ((getUpdateLinkMethod = ObservabilityGrpc.getUpdateLinkMethod) == null) {
      synchronized (ObservabilityGrpc.class) {
        if ((getUpdateLinkMethod = ObservabilityGrpc.getUpdateLinkMethod) == null) {
          ObservabilityGrpc.getUpdateLinkMethod =
              getUpdateLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.observability.v1.UpdateLinkRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.UpdateLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new ObservabilityMethodDescriptorSupplier("UpdateLink"))
                      .build();
        }
      }
    }
    return getUpdateLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.DeleteLinkRequest, com.google.longrunning.Operation>
      getDeleteLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteLink",
      requestType = com.google.cloud.observability.v1.DeleteLinkRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.DeleteLinkRequest, com.google.longrunning.Operation>
      getDeleteLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.observability.v1.DeleteLinkRequest, com.google.longrunning.Operation>
        getDeleteLinkMethod;
    if ((getDeleteLinkMethod = ObservabilityGrpc.getDeleteLinkMethod) == null) {
      synchronized (ObservabilityGrpc.class) {
        if ((getDeleteLinkMethod = ObservabilityGrpc.getDeleteLinkMethod) == null) {
          ObservabilityGrpc.getDeleteLinkMethod =
              getDeleteLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.observability.v1.DeleteLinkRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.DeleteLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new ObservabilityMethodDescriptorSupplier("DeleteLink"))
                      .build();
        }
      }
    }
    return getDeleteLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.GetTraceScopeRequest,
          com.google.cloud.observability.v1.TraceScope>
      getGetTraceScopeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTraceScope",
      requestType = com.google.cloud.observability.v1.GetTraceScopeRequest.class,
      responseType = com.google.cloud.observability.v1.TraceScope.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.GetTraceScopeRequest,
          com.google.cloud.observability.v1.TraceScope>
      getGetTraceScopeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.observability.v1.GetTraceScopeRequest,
            com.google.cloud.observability.v1.TraceScope>
        getGetTraceScopeMethod;
    if ((getGetTraceScopeMethod = ObservabilityGrpc.getGetTraceScopeMethod) == null) {
      synchronized (ObservabilityGrpc.class) {
        if ((getGetTraceScopeMethod = ObservabilityGrpc.getGetTraceScopeMethod) == null) {
          ObservabilityGrpc.getGetTraceScopeMethod =
              getGetTraceScopeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.observability.v1.GetTraceScopeRequest,
                          com.google.cloud.observability.v1.TraceScope>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTraceScope"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.GetTraceScopeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.TraceScope.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ObservabilityMethodDescriptorSupplier("GetTraceScope"))
                      .build();
        }
      }
    }
    return getGetTraceScopeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.ListTraceScopesRequest,
          com.google.cloud.observability.v1.ListTraceScopesResponse>
      getListTraceScopesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTraceScopes",
      requestType = com.google.cloud.observability.v1.ListTraceScopesRequest.class,
      responseType = com.google.cloud.observability.v1.ListTraceScopesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.ListTraceScopesRequest,
          com.google.cloud.observability.v1.ListTraceScopesResponse>
      getListTraceScopesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.observability.v1.ListTraceScopesRequest,
            com.google.cloud.observability.v1.ListTraceScopesResponse>
        getListTraceScopesMethod;
    if ((getListTraceScopesMethod = ObservabilityGrpc.getListTraceScopesMethod) == null) {
      synchronized (ObservabilityGrpc.class) {
        if ((getListTraceScopesMethod = ObservabilityGrpc.getListTraceScopesMethod) == null) {
          ObservabilityGrpc.getListTraceScopesMethod =
              getListTraceScopesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.observability.v1.ListTraceScopesRequest,
                          com.google.cloud.observability.v1.ListTraceScopesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTraceScopes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.ListTraceScopesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.ListTraceScopesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ObservabilityMethodDescriptorSupplier("ListTraceScopes"))
                      .build();
        }
      }
    }
    return getListTraceScopesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.CreateTraceScopeRequest,
          com.google.cloud.observability.v1.TraceScope>
      getCreateTraceScopeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTraceScope",
      requestType = com.google.cloud.observability.v1.CreateTraceScopeRequest.class,
      responseType = com.google.cloud.observability.v1.TraceScope.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.CreateTraceScopeRequest,
          com.google.cloud.observability.v1.TraceScope>
      getCreateTraceScopeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.observability.v1.CreateTraceScopeRequest,
            com.google.cloud.observability.v1.TraceScope>
        getCreateTraceScopeMethod;
    if ((getCreateTraceScopeMethod = ObservabilityGrpc.getCreateTraceScopeMethod) == null) {
      synchronized (ObservabilityGrpc.class) {
        if ((getCreateTraceScopeMethod = ObservabilityGrpc.getCreateTraceScopeMethod) == null) {
          ObservabilityGrpc.getCreateTraceScopeMethod =
              getCreateTraceScopeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.observability.v1.CreateTraceScopeRequest,
                          com.google.cloud.observability.v1.TraceScope>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTraceScope"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.CreateTraceScopeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.TraceScope.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ObservabilityMethodDescriptorSupplier("CreateTraceScope"))
                      .build();
        }
      }
    }
    return getCreateTraceScopeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.UpdateTraceScopeRequest,
          com.google.cloud.observability.v1.TraceScope>
      getUpdateTraceScopeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTraceScope",
      requestType = com.google.cloud.observability.v1.UpdateTraceScopeRequest.class,
      responseType = com.google.cloud.observability.v1.TraceScope.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.UpdateTraceScopeRequest,
          com.google.cloud.observability.v1.TraceScope>
      getUpdateTraceScopeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.observability.v1.UpdateTraceScopeRequest,
            com.google.cloud.observability.v1.TraceScope>
        getUpdateTraceScopeMethod;
    if ((getUpdateTraceScopeMethod = ObservabilityGrpc.getUpdateTraceScopeMethod) == null) {
      synchronized (ObservabilityGrpc.class) {
        if ((getUpdateTraceScopeMethod = ObservabilityGrpc.getUpdateTraceScopeMethod) == null) {
          ObservabilityGrpc.getUpdateTraceScopeMethod =
              getUpdateTraceScopeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.observability.v1.UpdateTraceScopeRequest,
                          com.google.cloud.observability.v1.TraceScope>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTraceScope"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.UpdateTraceScopeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.TraceScope.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ObservabilityMethodDescriptorSupplier("UpdateTraceScope"))
                      .build();
        }
      }
    }
    return getUpdateTraceScopeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.DeleteTraceScopeRequest, com.google.protobuf.Empty>
      getDeleteTraceScopeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTraceScope",
      requestType = com.google.cloud.observability.v1.DeleteTraceScopeRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.DeleteTraceScopeRequest, com.google.protobuf.Empty>
      getDeleteTraceScopeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.observability.v1.DeleteTraceScopeRequest, com.google.protobuf.Empty>
        getDeleteTraceScopeMethod;
    if ((getDeleteTraceScopeMethod = ObservabilityGrpc.getDeleteTraceScopeMethod) == null) {
      synchronized (ObservabilityGrpc.class) {
        if ((getDeleteTraceScopeMethod = ObservabilityGrpc.getDeleteTraceScopeMethod) == null) {
          ObservabilityGrpc.getDeleteTraceScopeMethod =
              getDeleteTraceScopeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.observability.v1.DeleteTraceScopeRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTraceScope"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.DeleteTraceScopeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ObservabilityMethodDescriptorSupplier("DeleteTraceScope"))
                      .build();
        }
      }
    }
    return getDeleteTraceScopeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.GetSettingsRequest,
          com.google.cloud.observability.v1.Settings>
      getGetSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSettings",
      requestType = com.google.cloud.observability.v1.GetSettingsRequest.class,
      responseType = com.google.cloud.observability.v1.Settings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.GetSettingsRequest,
          com.google.cloud.observability.v1.Settings>
      getGetSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.observability.v1.GetSettingsRequest,
            com.google.cloud.observability.v1.Settings>
        getGetSettingsMethod;
    if ((getGetSettingsMethod = ObservabilityGrpc.getGetSettingsMethod) == null) {
      synchronized (ObservabilityGrpc.class) {
        if ((getGetSettingsMethod = ObservabilityGrpc.getGetSettingsMethod) == null) {
          ObservabilityGrpc.getGetSettingsMethod =
              getGetSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.observability.v1.GetSettingsRequest,
                          com.google.cloud.observability.v1.Settings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.GetSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.Settings.getDefaultInstance()))
                      .setSchemaDescriptor(new ObservabilityMethodDescriptorSupplier("GetSettings"))
                      .build();
        }
      }
    }
    return getGetSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.UpdateSettingsRequest, com.google.longrunning.Operation>
      getUpdateSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSettings",
      requestType = com.google.cloud.observability.v1.UpdateSettingsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.observability.v1.UpdateSettingsRequest, com.google.longrunning.Operation>
      getUpdateSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.observability.v1.UpdateSettingsRequest,
            com.google.longrunning.Operation>
        getUpdateSettingsMethod;
    if ((getUpdateSettingsMethod = ObservabilityGrpc.getUpdateSettingsMethod) == null) {
      synchronized (ObservabilityGrpc.class) {
        if ((getUpdateSettingsMethod = ObservabilityGrpc.getUpdateSettingsMethod) == null) {
          ObservabilityGrpc.getUpdateSettingsMethod =
              getUpdateSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.observability.v1.UpdateSettingsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.observability.v1.UpdateSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ObservabilityMethodDescriptorSupplier("UpdateSettings"))
                      .build();
        }
      }
    }
    return getUpdateSettingsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ObservabilityStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ObservabilityStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ObservabilityStub>() {
          @java.lang.Override
          public ObservabilityStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ObservabilityStub(channel, callOptions);
          }
        };
    return ObservabilityStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static ObservabilityBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ObservabilityBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ObservabilityBlockingV2Stub>() {
          @java.lang.Override
          public ObservabilityBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ObservabilityBlockingV2Stub(channel, callOptions);
          }
        };
    return ObservabilityBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ObservabilityBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ObservabilityBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ObservabilityBlockingStub>() {
          @java.lang.Override
          public ObservabilityBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ObservabilityBlockingStub(channel, callOptions);
          }
        };
    return ObservabilityBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ObservabilityFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ObservabilityFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ObservabilityFutureStub>() {
          @java.lang.Override
          public ObservabilityFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ObservabilityFutureStub(channel, callOptions);
          }
        };
    return ObservabilityFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Gets details of a single Scope.
     * </pre>
     */
    default void getScope(
        com.google.cloud.observability.v1.GetScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.Scope> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetScopeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Scope.
     * </pre>
     */
    default void updateScope(
        com.google.cloud.observability.v1.UpdateScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.Scope> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateScopeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get bucket resource.
     * </pre>
     */
    default void getBucket(
        com.google.cloud.observability.v1.GetBucketRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.Bucket> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBucketMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List buckets of a project in a particular location.
     * </pre>
     */
    default void listBuckets(
        com.google.cloud.observability.v1.ListBucketsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.ListBucketsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBucketsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new bucket.
     * </pre>
     */
    default void createBucket(
        com.google.cloud.observability.v1.CreateBucketRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateBucketMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a bucket.
     * </pre>
     */
    default void updateBucket(
        com.google.cloud.observability.v1.UpdateBucketRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateBucketMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a dataset.
     * </pre>
     */
    default void getDataset(
        com.google.cloud.observability.v1.GetDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.Dataset> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDatasetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List datasets of a bucket.
     * </pre>
     */
    default void listDatasets(
        com.google.cloud.observability.v1.ListDatasetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.ListDatasetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDatasetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a view.
     * </pre>
     */
    default void getView(
        com.google.cloud.observability.v1.GetViewRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.View> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetViewMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List views of a dataset.
     * </pre>
     */
    default void listViews(
        com.google.cloud.observability.v1.ListViewsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.ListViewsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListViewsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a link.
     * </pre>
     */
    default void getLink(
        com.google.cloud.observability.v1.GetLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.Link> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List links of a dataset.
     * </pre>
     */
    default void listLinks(
        com.google.cloud.observability.v1.ListLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.ListLinksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListLinksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new link.
     * </pre>
     */
    default void createLink(
        com.google.cloud.observability.v1.CreateLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a link.
     * </pre>
     */
    default void updateLink(
        com.google.cloud.observability.v1.UpdateLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a link.
     * </pre>
     */
    default void deleteLink(
        com.google.cloud.observability.v1.DeleteLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get TraceScope resource.
     * </pre>
     */
    default void getTraceScope(
        com.google.cloud.observability.v1.GetTraceScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.TraceScope>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetTraceScopeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List TraceScopes of a project in a particular location.
     * </pre>
     */
    default void listTraceScopes(
        com.google.cloud.observability.v1.ListTraceScopesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.ListTraceScopesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListTraceScopesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new TraceScope.
     * </pre>
     */
    default void createTraceScope(
        com.google.cloud.observability.v1.CreateTraceScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.TraceScope>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateTraceScopeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a TraceScope.
     * </pre>
     */
    default void updateTraceScope(
        com.google.cloud.observability.v1.UpdateTraceScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.TraceScope>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateTraceScopeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a TraceScope.
     * </pre>
     */
    default void deleteTraceScope(
        com.google.cloud.observability.v1.DeleteTraceScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteTraceScopeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get Settings
     * </pre>
     */
    default void getSettings(
        com.google.cloud.observability.v1.GetSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.Settings> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update Settings
     * </pre>
     */
    default void updateSettings(
        com.google.cloud.observability.v1.UpdateSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSettingsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Observability.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public abstract static class ObservabilityImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ObservabilityGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Observability.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class ObservabilityStub
      extends io.grpc.stub.AbstractAsyncStub<ObservabilityStub> {
    private ObservabilityStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ObservabilityStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ObservabilityStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Scope.
     * </pre>
     */
    public void getScope(
        com.google.cloud.observability.v1.GetScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.Scope> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetScopeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Scope.
     * </pre>
     */
    public void updateScope(
        com.google.cloud.observability.v1.UpdateScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.Scope> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateScopeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get bucket resource.
     * </pre>
     */
    public void getBucket(
        com.google.cloud.observability.v1.GetBucketRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.Bucket> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBucketMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List buckets of a project in a particular location.
     * </pre>
     */
    public void listBuckets(
        com.google.cloud.observability.v1.ListBucketsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.ListBucketsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBucketsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new bucket.
     * </pre>
     */
    public void createBucket(
        com.google.cloud.observability.v1.CreateBucketRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBucketMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a bucket.
     * </pre>
     */
    public void updateBucket(
        com.google.cloud.observability.v1.UpdateBucketRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateBucketMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a dataset.
     * </pre>
     */
    public void getDataset(
        com.google.cloud.observability.v1.GetDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.Dataset> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDatasetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List datasets of a bucket.
     * </pre>
     */
    public void listDatasets(
        com.google.cloud.observability.v1.ListDatasetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.ListDatasetsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDatasetsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a view.
     * </pre>
     */
    public void getView(
        com.google.cloud.observability.v1.GetViewRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.View> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetViewMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List views of a dataset.
     * </pre>
     */
    public void listViews(
        com.google.cloud.observability.v1.ListViewsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.ListViewsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListViewsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a link.
     * </pre>
     */
    public void getLink(
        com.google.cloud.observability.v1.GetLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.Link> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLinkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List links of a dataset.
     * </pre>
     */
    public void listLinks(
        com.google.cloud.observability.v1.ListLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.ListLinksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListLinksMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new link.
     * </pre>
     */
    public void createLink(
        com.google.cloud.observability.v1.CreateLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateLinkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a link.
     * </pre>
     */
    public void updateLink(
        com.google.cloud.observability.v1.UpdateLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateLinkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a link.
     * </pre>
     */
    public void deleteLink(
        com.google.cloud.observability.v1.DeleteLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteLinkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get TraceScope resource.
     * </pre>
     */
    public void getTraceScope(
        com.google.cloud.observability.v1.GetTraceScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.TraceScope>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTraceScopeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List TraceScopes of a project in a particular location.
     * </pre>
     */
    public void listTraceScopes(
        com.google.cloud.observability.v1.ListTraceScopesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.ListTraceScopesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTraceScopesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new TraceScope.
     * </pre>
     */
    public void createTraceScope(
        com.google.cloud.observability.v1.CreateTraceScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.TraceScope>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTraceScopeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a TraceScope.
     * </pre>
     */
    public void updateTraceScope(
        com.google.cloud.observability.v1.UpdateTraceScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.TraceScope>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTraceScopeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a TraceScope.
     * </pre>
     */
    public void deleteTraceScope(
        com.google.cloud.observability.v1.DeleteTraceScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTraceScopeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get Settings
     * </pre>
     */
    public void getSettings(
        com.google.cloud.observability.v1.GetSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.Settings> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update Settings
     * </pre>
     */
    public void updateSettings(
        com.google.cloud.observability.v1.UpdateSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Observability.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class ObservabilityBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<ObservabilityBlockingV2Stub> {
    private ObservabilityBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ObservabilityBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ObservabilityBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Scope.
     * </pre>
     */
    public com.google.cloud.observability.v1.Scope getScope(
        com.google.cloud.observability.v1.GetScopeRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Scope.
     * </pre>
     */
    public com.google.cloud.observability.v1.Scope updateScope(
        com.google.cloud.observability.v1.UpdateScopeRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get bucket resource.
     * </pre>
     */
    public com.google.cloud.observability.v1.Bucket getBucket(
        com.google.cloud.observability.v1.GetBucketRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetBucketMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List buckets of a project in a particular location.
     * </pre>
     */
    public com.google.cloud.observability.v1.ListBucketsResponse listBuckets(
        com.google.cloud.observability.v1.ListBucketsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListBucketsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new bucket.
     * </pre>
     */
    public com.google.longrunning.Operation createBucket(
        com.google.cloud.observability.v1.CreateBucketRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateBucketMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a bucket.
     * </pre>
     */
    public com.google.longrunning.Operation updateBucket(
        com.google.cloud.observability.v1.UpdateBucketRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateBucketMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a dataset.
     * </pre>
     */
    public com.google.cloud.observability.v1.Dataset getDataset(
        com.google.cloud.observability.v1.GetDatasetRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List datasets of a bucket.
     * </pre>
     */
    public com.google.cloud.observability.v1.ListDatasetsResponse listDatasets(
        com.google.cloud.observability.v1.ListDatasetsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListDatasetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a view.
     * </pre>
     */
    public com.google.cloud.observability.v1.View getView(
        com.google.cloud.observability.v1.GetViewRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetViewMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List views of a dataset.
     * </pre>
     */
    public com.google.cloud.observability.v1.ListViewsResponse listViews(
        com.google.cloud.observability.v1.ListViewsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListViewsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a link.
     * </pre>
     */
    public com.google.cloud.observability.v1.Link getLink(
        com.google.cloud.observability.v1.GetLinkRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List links of a dataset.
     * </pre>
     */
    public com.google.cloud.observability.v1.ListLinksResponse listLinks(
        com.google.cloud.observability.v1.ListLinksRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListLinksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new link.
     * </pre>
     */
    public com.google.longrunning.Operation createLink(
        com.google.cloud.observability.v1.CreateLinkRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a link.
     * </pre>
     */
    public com.google.longrunning.Operation updateLink(
        com.google.cloud.observability.v1.UpdateLinkRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a link.
     * </pre>
     */
    public com.google.longrunning.Operation deleteLink(
        com.google.cloud.observability.v1.DeleteLinkRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get TraceScope resource.
     * </pre>
     */
    public com.google.cloud.observability.v1.TraceScope getTraceScope(
        com.google.cloud.observability.v1.GetTraceScopeRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetTraceScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List TraceScopes of a project in a particular location.
     * </pre>
     */
    public com.google.cloud.observability.v1.ListTraceScopesResponse listTraceScopes(
        com.google.cloud.observability.v1.ListTraceScopesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListTraceScopesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new TraceScope.
     * </pre>
     */
    public com.google.cloud.observability.v1.TraceScope createTraceScope(
        com.google.cloud.observability.v1.CreateTraceScopeRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateTraceScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a TraceScope.
     * </pre>
     */
    public com.google.cloud.observability.v1.TraceScope updateTraceScope(
        com.google.cloud.observability.v1.UpdateTraceScopeRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateTraceScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a TraceScope.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTraceScope(
        com.google.cloud.observability.v1.DeleteTraceScopeRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteTraceScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get Settings
     * </pre>
     */
    public com.google.cloud.observability.v1.Settings getSettings(
        com.google.cloud.observability.v1.GetSettingsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update Settings
     * </pre>
     */
    public com.google.longrunning.Operation updateSettings(
        com.google.cloud.observability.v1.UpdateSettingsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateSettingsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Observability.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class ObservabilityBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ObservabilityBlockingStub> {
    private ObservabilityBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ObservabilityBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ObservabilityBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Scope.
     * </pre>
     */
    public com.google.cloud.observability.v1.Scope getScope(
        com.google.cloud.observability.v1.GetScopeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Scope.
     * </pre>
     */
    public com.google.cloud.observability.v1.Scope updateScope(
        com.google.cloud.observability.v1.UpdateScopeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get bucket resource.
     * </pre>
     */
    public com.google.cloud.observability.v1.Bucket getBucket(
        com.google.cloud.observability.v1.GetBucketRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBucketMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List buckets of a project in a particular location.
     * </pre>
     */
    public com.google.cloud.observability.v1.ListBucketsResponse listBuckets(
        com.google.cloud.observability.v1.ListBucketsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBucketsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new bucket.
     * </pre>
     */
    public com.google.longrunning.Operation createBucket(
        com.google.cloud.observability.v1.CreateBucketRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBucketMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a bucket.
     * </pre>
     */
    public com.google.longrunning.Operation updateBucket(
        com.google.cloud.observability.v1.UpdateBucketRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBucketMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a dataset.
     * </pre>
     */
    public com.google.cloud.observability.v1.Dataset getDataset(
        com.google.cloud.observability.v1.GetDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List datasets of a bucket.
     * </pre>
     */
    public com.google.cloud.observability.v1.ListDatasetsResponse listDatasets(
        com.google.cloud.observability.v1.ListDatasetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDatasetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a view.
     * </pre>
     */
    public com.google.cloud.observability.v1.View getView(
        com.google.cloud.observability.v1.GetViewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetViewMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List views of a dataset.
     * </pre>
     */
    public com.google.cloud.observability.v1.ListViewsResponse listViews(
        com.google.cloud.observability.v1.ListViewsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListViewsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a link.
     * </pre>
     */
    public com.google.cloud.observability.v1.Link getLink(
        com.google.cloud.observability.v1.GetLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List links of a dataset.
     * </pre>
     */
    public com.google.cloud.observability.v1.ListLinksResponse listLinks(
        com.google.cloud.observability.v1.ListLinksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListLinksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new link.
     * </pre>
     */
    public com.google.longrunning.Operation createLink(
        com.google.cloud.observability.v1.CreateLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a link.
     * </pre>
     */
    public com.google.longrunning.Operation updateLink(
        com.google.cloud.observability.v1.UpdateLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a link.
     * </pre>
     */
    public com.google.longrunning.Operation deleteLink(
        com.google.cloud.observability.v1.DeleteLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get TraceScope resource.
     * </pre>
     */
    public com.google.cloud.observability.v1.TraceScope getTraceScope(
        com.google.cloud.observability.v1.GetTraceScopeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTraceScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List TraceScopes of a project in a particular location.
     * </pre>
     */
    public com.google.cloud.observability.v1.ListTraceScopesResponse listTraceScopes(
        com.google.cloud.observability.v1.ListTraceScopesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTraceScopesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new TraceScope.
     * </pre>
     */
    public com.google.cloud.observability.v1.TraceScope createTraceScope(
        com.google.cloud.observability.v1.CreateTraceScopeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTraceScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a TraceScope.
     * </pre>
     */
    public com.google.cloud.observability.v1.TraceScope updateTraceScope(
        com.google.cloud.observability.v1.UpdateTraceScopeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTraceScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a TraceScope.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTraceScope(
        com.google.cloud.observability.v1.DeleteTraceScopeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTraceScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get Settings
     * </pre>
     */
    public com.google.cloud.observability.v1.Settings getSettings(
        com.google.cloud.observability.v1.GetSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update Settings
     * </pre>
     */
    public com.google.longrunning.Operation updateSettings(
        com.google.cloud.observability.v1.UpdateSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSettingsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Observability.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class ObservabilityFutureStub
      extends io.grpc.stub.AbstractFutureStub<ObservabilityFutureStub> {
    private ObservabilityFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ObservabilityFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ObservabilityFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Scope.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.observability.v1.Scope>
        getScope(com.google.cloud.observability.v1.GetScopeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetScopeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Scope.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.observability.v1.Scope>
        updateScope(com.google.cloud.observability.v1.UpdateScopeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateScopeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get bucket resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.observability.v1.Bucket>
        getBucket(com.google.cloud.observability.v1.GetBucketRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBucketMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List buckets of a project in a particular location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.observability.v1.ListBucketsResponse>
        listBuckets(com.google.cloud.observability.v1.ListBucketsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBucketsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new bucket.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createBucket(com.google.cloud.observability.v1.CreateBucketRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBucketMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a bucket.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateBucket(com.google.cloud.observability.v1.UpdateBucketRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBucketMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get a dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.observability.v1.Dataset>
        getDataset(com.google.cloud.observability.v1.GetDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDatasetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List datasets of a bucket.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.observability.v1.ListDatasetsResponse>
        listDatasets(com.google.cloud.observability.v1.ListDatasetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDatasetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get a view.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.observability.v1.View>
        getView(com.google.cloud.observability.v1.GetViewRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetViewMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List views of a dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.observability.v1.ListViewsResponse>
        listViews(com.google.cloud.observability.v1.ListViewsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListViewsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get a link.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.observability.v1.Link>
        getLink(com.google.cloud.observability.v1.GetLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List links of a dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.observability.v1.ListLinksResponse>
        listLinks(com.google.cloud.observability.v1.ListLinksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListLinksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new link.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createLink(com.google.cloud.observability.v1.CreateLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a link.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateLink(com.google.cloud.observability.v1.UpdateLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a link.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteLink(com.google.cloud.observability.v1.DeleteLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get TraceScope resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.observability.v1.TraceScope>
        getTraceScope(com.google.cloud.observability.v1.GetTraceScopeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTraceScopeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List TraceScopes of a project in a particular location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.observability.v1.ListTraceScopesResponse>
        listTraceScopes(com.google.cloud.observability.v1.ListTraceScopesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTraceScopesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new TraceScope.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.observability.v1.TraceScope>
        createTraceScope(com.google.cloud.observability.v1.CreateTraceScopeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTraceScopeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a TraceScope.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.observability.v1.TraceScope>
        updateTraceScope(com.google.cloud.observability.v1.UpdateTraceScopeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTraceScopeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a TraceScope.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteTraceScope(com.google.cloud.observability.v1.DeleteTraceScopeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTraceScopeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get Settings
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.observability.v1.Settings>
        getSettings(com.google.cloud.observability.v1.GetSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update Settings
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateSettings(com.google.cloud.observability.v1.UpdateSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSettingsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_SCOPE = 0;
  private static final int METHODID_UPDATE_SCOPE = 1;
  private static final int METHODID_GET_BUCKET = 2;
  private static final int METHODID_LIST_BUCKETS = 3;
  private static final int METHODID_CREATE_BUCKET = 4;
  private static final int METHODID_UPDATE_BUCKET = 5;
  private static final int METHODID_GET_DATASET = 6;
  private static final int METHODID_LIST_DATASETS = 7;
  private static final int METHODID_GET_VIEW = 8;
  private static final int METHODID_LIST_VIEWS = 9;
  private static final int METHODID_GET_LINK = 10;
  private static final int METHODID_LIST_LINKS = 11;
  private static final int METHODID_CREATE_LINK = 12;
  private static final int METHODID_UPDATE_LINK = 13;
  private static final int METHODID_DELETE_LINK = 14;
  private static final int METHODID_GET_TRACE_SCOPE = 15;
  private static final int METHODID_LIST_TRACE_SCOPES = 16;
  private static final int METHODID_CREATE_TRACE_SCOPE = 17;
  private static final int METHODID_UPDATE_TRACE_SCOPE = 18;
  private static final int METHODID_DELETE_TRACE_SCOPE = 19;
  private static final int METHODID_GET_SETTINGS = 20;
  private static final int METHODID_UPDATE_SETTINGS = 21;

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
        case METHODID_GET_SCOPE:
          serviceImpl.getScope(
              (com.google.cloud.observability.v1.GetScopeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.Scope>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SCOPE:
          serviceImpl.updateScope(
              (com.google.cloud.observability.v1.UpdateScopeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.Scope>)
                  responseObserver);
          break;
        case METHODID_GET_BUCKET:
          serviceImpl.getBucket(
              (com.google.cloud.observability.v1.GetBucketRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.Bucket>)
                  responseObserver);
          break;
        case METHODID_LIST_BUCKETS:
          serviceImpl.listBuckets(
              (com.google.cloud.observability.v1.ListBucketsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.ListBucketsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_BUCKET:
          serviceImpl.createBucket(
              (com.google.cloud.observability.v1.CreateBucketRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_BUCKET:
          serviceImpl.updateBucket(
              (com.google.cloud.observability.v1.UpdateBucketRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_DATASET:
          serviceImpl.getDataset(
              (com.google.cloud.observability.v1.GetDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.Dataset>)
                  responseObserver);
          break;
        case METHODID_LIST_DATASETS:
          serviceImpl.listDatasets(
              (com.google.cloud.observability.v1.ListDatasetsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.ListDatasetsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_VIEW:
          serviceImpl.getView(
              (com.google.cloud.observability.v1.GetViewRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.View>)
                  responseObserver);
          break;
        case METHODID_LIST_VIEWS:
          serviceImpl.listViews(
              (com.google.cloud.observability.v1.ListViewsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.ListViewsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_LINK:
          serviceImpl.getLink(
              (com.google.cloud.observability.v1.GetLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.Link>)
                  responseObserver);
          break;
        case METHODID_LIST_LINKS:
          serviceImpl.listLinks(
              (com.google.cloud.observability.v1.ListLinksRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.ListLinksResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_LINK:
          serviceImpl.createLink(
              (com.google.cloud.observability.v1.CreateLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_LINK:
          serviceImpl.updateLink(
              (com.google.cloud.observability.v1.UpdateLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_LINK:
          serviceImpl.deleteLink(
              (com.google.cloud.observability.v1.DeleteLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_TRACE_SCOPE:
          serviceImpl.getTraceScope(
              (com.google.cloud.observability.v1.GetTraceScopeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.TraceScope>)
                  responseObserver);
          break;
        case METHODID_LIST_TRACE_SCOPES:
          serviceImpl.listTraceScopes(
              (com.google.cloud.observability.v1.ListTraceScopesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.observability.v1.ListTraceScopesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_TRACE_SCOPE:
          serviceImpl.createTraceScope(
              (com.google.cloud.observability.v1.CreateTraceScopeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.TraceScope>)
                  responseObserver);
          break;
        case METHODID_UPDATE_TRACE_SCOPE:
          serviceImpl.updateTraceScope(
              (com.google.cloud.observability.v1.UpdateTraceScopeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.TraceScope>)
                  responseObserver);
          break;
        case METHODID_DELETE_TRACE_SCOPE:
          serviceImpl.deleteTraceScope(
              (com.google.cloud.observability.v1.DeleteTraceScopeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_SETTINGS:
          serviceImpl.getSettings(
              (com.google.cloud.observability.v1.GetSettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.observability.v1.Settings>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SETTINGS:
          serviceImpl.updateSettings(
              (com.google.cloud.observability.v1.UpdateSettingsRequest) request,
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
            getGetScopeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.observability.v1.GetScopeRequest,
                    com.google.cloud.observability.v1.Scope>(service, METHODID_GET_SCOPE)))
        .addMethod(
            getUpdateScopeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.observability.v1.UpdateScopeRequest,
                    com.google.cloud.observability.v1.Scope>(service, METHODID_UPDATE_SCOPE)))
        .addMethod(
            getGetBucketMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.observability.v1.GetBucketRequest,
                    com.google.cloud.observability.v1.Bucket>(service, METHODID_GET_BUCKET)))
        .addMethod(
            getListBucketsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.observability.v1.ListBucketsRequest,
                    com.google.cloud.observability.v1.ListBucketsResponse>(
                    service, METHODID_LIST_BUCKETS)))
        .addMethod(
            getCreateBucketMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.observability.v1.CreateBucketRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_BUCKET)))
        .addMethod(
            getUpdateBucketMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.observability.v1.UpdateBucketRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_BUCKET)))
        .addMethod(
            getGetDatasetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.observability.v1.GetDatasetRequest,
                    com.google.cloud.observability.v1.Dataset>(service, METHODID_GET_DATASET)))
        .addMethod(
            getListDatasetsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.observability.v1.ListDatasetsRequest,
                    com.google.cloud.observability.v1.ListDatasetsResponse>(
                    service, METHODID_LIST_DATASETS)))
        .addMethod(
            getGetViewMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.observability.v1.GetViewRequest,
                    com.google.cloud.observability.v1.View>(service, METHODID_GET_VIEW)))
        .addMethod(
            getListViewsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.observability.v1.ListViewsRequest,
                    com.google.cloud.observability.v1.ListViewsResponse>(
                    service, METHODID_LIST_VIEWS)))
        .addMethod(
            getGetLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.observability.v1.GetLinkRequest,
                    com.google.cloud.observability.v1.Link>(service, METHODID_GET_LINK)))
        .addMethod(
            getListLinksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.observability.v1.ListLinksRequest,
                    com.google.cloud.observability.v1.ListLinksResponse>(
                    service, METHODID_LIST_LINKS)))
        .addMethod(
            getCreateLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.observability.v1.CreateLinkRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_LINK)))
        .addMethod(
            getUpdateLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.observability.v1.UpdateLinkRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_LINK)))
        .addMethod(
            getDeleteLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.observability.v1.DeleteLinkRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_LINK)))
        .addMethod(
            getGetTraceScopeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.observability.v1.GetTraceScopeRequest,
                    com.google.cloud.observability.v1.TraceScope>(
                    service, METHODID_GET_TRACE_SCOPE)))
        .addMethod(
            getListTraceScopesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.observability.v1.ListTraceScopesRequest,
                    com.google.cloud.observability.v1.ListTraceScopesResponse>(
                    service, METHODID_LIST_TRACE_SCOPES)))
        .addMethod(
            getCreateTraceScopeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.observability.v1.CreateTraceScopeRequest,
                    com.google.cloud.observability.v1.TraceScope>(
                    service, METHODID_CREATE_TRACE_SCOPE)))
        .addMethod(
            getUpdateTraceScopeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.observability.v1.UpdateTraceScopeRequest,
                    com.google.cloud.observability.v1.TraceScope>(
                    service, METHODID_UPDATE_TRACE_SCOPE)))
        .addMethod(
            getDeleteTraceScopeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.observability.v1.DeleteTraceScopeRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_TRACE_SCOPE)))
        .addMethod(
            getGetSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.observability.v1.GetSettingsRequest,
                    com.google.cloud.observability.v1.Settings>(service, METHODID_GET_SETTINGS)))
        .addMethod(
            getUpdateSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.observability.v1.UpdateSettingsRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_SETTINGS)))
        .build();
  }

  private abstract static class ObservabilityBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ObservabilityBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.observability.v1.ObservabilityProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Observability");
    }
  }

  private static final class ObservabilityFileDescriptorSupplier
      extends ObservabilityBaseDescriptorSupplier {
    ObservabilityFileDescriptorSupplier() {}
  }

  private static final class ObservabilityMethodDescriptorSupplier
      extends ObservabilityBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ObservabilityMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ObservabilityGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ObservabilityFileDescriptorSupplier())
                      .addMethod(getGetScopeMethod())
                      .addMethod(getUpdateScopeMethod())
                      .addMethod(getGetBucketMethod())
                      .addMethod(getListBucketsMethod())
                      .addMethod(getCreateBucketMethod())
                      .addMethod(getUpdateBucketMethod())
                      .addMethod(getGetDatasetMethod())
                      .addMethod(getListDatasetsMethod())
                      .addMethod(getGetViewMethod())
                      .addMethod(getListViewsMethod())
                      .addMethod(getGetLinkMethod())
                      .addMethod(getListLinksMethod())
                      .addMethod(getCreateLinkMethod())
                      .addMethod(getUpdateLinkMethod())
                      .addMethod(getDeleteLinkMethod())
                      .addMethod(getGetTraceScopeMethod())
                      .addMethod(getListTraceScopesMethod())
                      .addMethod(getCreateTraceScopeMethod())
                      .addMethod(getUpdateTraceScopeMethod())
                      .addMethod(getDeleteTraceScopeMethod())
                      .addMethod(getGetSettingsMethod())
                      .addMethod(getUpdateSettingsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
