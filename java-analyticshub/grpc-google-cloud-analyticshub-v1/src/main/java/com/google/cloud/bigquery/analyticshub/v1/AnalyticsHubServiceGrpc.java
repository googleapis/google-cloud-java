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
package com.google.cloud.bigquery.analyticshub.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The `AnalyticsHubService` API facilitates data sharing within and across
 * organizations. It allows data providers to publish listings that reference
 * shared datasets. With Analytics Hub, users can discover and search for
 * listings that they have access to. Subscribers can view and subscribe to
 * listings. When you subscribe to a listing, Analytics Hub creates a linked
 * dataset in your project.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/bigquery/analyticshub/v1/analyticshub.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AnalyticsHubServiceGrpc {

  private AnalyticsHubServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesRequest,
          com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesResponse>
      getListDataExchangesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDataExchanges",
      requestType = com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesRequest.class,
      responseType = com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesRequest,
          com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesResponse>
      getListDataExchangesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesRequest,
            com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesResponse>
        getListDataExchangesMethod;
    if ((getListDataExchangesMethod = AnalyticsHubServiceGrpc.getListDataExchangesMethod) == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getListDataExchangesMethod = AnalyticsHubServiceGrpc.getListDataExchangesMethod)
            == null) {
          AnalyticsHubServiceGrpc.getListDataExchangesMethod =
              getListDataExchangesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesRequest,
                          com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDataExchanges"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsHubServiceMethodDescriptorSupplier("ListDataExchanges"))
                      .build();
        }
      }
    }
    return getListDataExchangesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesRequest,
          com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesResponse>
      getListOrgDataExchangesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListOrgDataExchanges",
      requestType = com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesRequest.class,
      responseType = com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesRequest,
          com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesResponse>
      getListOrgDataExchangesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesRequest,
            com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesResponse>
        getListOrgDataExchangesMethod;
    if ((getListOrgDataExchangesMethod = AnalyticsHubServiceGrpc.getListOrgDataExchangesMethod)
        == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getListOrgDataExchangesMethod = AnalyticsHubServiceGrpc.getListOrgDataExchangesMethod)
            == null) {
          AnalyticsHubServiceGrpc.getListOrgDataExchangesMethod =
              getListOrgDataExchangesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesRequest,
                          com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListOrgDataExchanges"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsHubServiceMethodDescriptorSupplier("ListOrgDataExchanges"))
                      .build();
        }
      }
    }
    return getListOrgDataExchangesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.GetDataExchangeRequest,
          com.google.cloud.bigquery.analyticshub.v1.DataExchange>
      getGetDataExchangeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataExchange",
      requestType = com.google.cloud.bigquery.analyticshub.v1.GetDataExchangeRequest.class,
      responseType = com.google.cloud.bigquery.analyticshub.v1.DataExchange.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.GetDataExchangeRequest,
          com.google.cloud.bigquery.analyticshub.v1.DataExchange>
      getGetDataExchangeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.analyticshub.v1.GetDataExchangeRequest,
            com.google.cloud.bigquery.analyticshub.v1.DataExchange>
        getGetDataExchangeMethod;
    if ((getGetDataExchangeMethod = AnalyticsHubServiceGrpc.getGetDataExchangeMethod) == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getGetDataExchangeMethod = AnalyticsHubServiceGrpc.getGetDataExchangeMethod) == null) {
          AnalyticsHubServiceGrpc.getGetDataExchangeMethod =
              getGetDataExchangeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.analyticshub.v1.GetDataExchangeRequest,
                          com.google.cloud.bigquery.analyticshub.v1.DataExchange>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataExchange"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.GetDataExchangeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.DataExchange
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsHubServiceMethodDescriptorSupplier("GetDataExchange"))
                      .build();
        }
      }
    }
    return getGetDataExchangeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.CreateDataExchangeRequest,
          com.google.cloud.bigquery.analyticshub.v1.DataExchange>
      getCreateDataExchangeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDataExchange",
      requestType = com.google.cloud.bigquery.analyticshub.v1.CreateDataExchangeRequest.class,
      responseType = com.google.cloud.bigquery.analyticshub.v1.DataExchange.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.CreateDataExchangeRequest,
          com.google.cloud.bigquery.analyticshub.v1.DataExchange>
      getCreateDataExchangeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.analyticshub.v1.CreateDataExchangeRequest,
            com.google.cloud.bigquery.analyticshub.v1.DataExchange>
        getCreateDataExchangeMethod;
    if ((getCreateDataExchangeMethod = AnalyticsHubServiceGrpc.getCreateDataExchangeMethod)
        == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getCreateDataExchangeMethod = AnalyticsHubServiceGrpc.getCreateDataExchangeMethod)
            == null) {
          AnalyticsHubServiceGrpc.getCreateDataExchangeMethod =
              getCreateDataExchangeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.analyticshub.v1.CreateDataExchangeRequest,
                          com.google.cloud.bigquery.analyticshub.v1.DataExchange>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDataExchange"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.CreateDataExchangeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.DataExchange
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsHubServiceMethodDescriptorSupplier("CreateDataExchange"))
                      .build();
        }
      }
    }
    return getCreateDataExchangeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.UpdateDataExchangeRequest,
          com.google.cloud.bigquery.analyticshub.v1.DataExchange>
      getUpdateDataExchangeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDataExchange",
      requestType = com.google.cloud.bigquery.analyticshub.v1.UpdateDataExchangeRequest.class,
      responseType = com.google.cloud.bigquery.analyticshub.v1.DataExchange.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.UpdateDataExchangeRequest,
          com.google.cloud.bigquery.analyticshub.v1.DataExchange>
      getUpdateDataExchangeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.analyticshub.v1.UpdateDataExchangeRequest,
            com.google.cloud.bigquery.analyticshub.v1.DataExchange>
        getUpdateDataExchangeMethod;
    if ((getUpdateDataExchangeMethod = AnalyticsHubServiceGrpc.getUpdateDataExchangeMethod)
        == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getUpdateDataExchangeMethod = AnalyticsHubServiceGrpc.getUpdateDataExchangeMethod)
            == null) {
          AnalyticsHubServiceGrpc.getUpdateDataExchangeMethod =
              getUpdateDataExchangeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.analyticshub.v1.UpdateDataExchangeRequest,
                          com.google.cloud.bigquery.analyticshub.v1.DataExchange>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDataExchange"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.UpdateDataExchangeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.DataExchange
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsHubServiceMethodDescriptorSupplier("UpdateDataExchange"))
                      .build();
        }
      }
    }
    return getUpdateDataExchangeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.DeleteDataExchangeRequest,
          com.google.protobuf.Empty>
      getDeleteDataExchangeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDataExchange",
      requestType = com.google.cloud.bigquery.analyticshub.v1.DeleteDataExchangeRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.DeleteDataExchangeRequest,
          com.google.protobuf.Empty>
      getDeleteDataExchangeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.analyticshub.v1.DeleteDataExchangeRequest,
            com.google.protobuf.Empty>
        getDeleteDataExchangeMethod;
    if ((getDeleteDataExchangeMethod = AnalyticsHubServiceGrpc.getDeleteDataExchangeMethod)
        == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getDeleteDataExchangeMethod = AnalyticsHubServiceGrpc.getDeleteDataExchangeMethod)
            == null) {
          AnalyticsHubServiceGrpc.getDeleteDataExchangeMethod =
              getDeleteDataExchangeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.analyticshub.v1.DeleteDataExchangeRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDataExchange"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.DeleteDataExchangeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsHubServiceMethodDescriptorSupplier("DeleteDataExchange"))
                      .build();
        }
      }
    }
    return getDeleteDataExchangeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.ListListingsRequest,
          com.google.cloud.bigquery.analyticshub.v1.ListListingsResponse>
      getListListingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListListings",
      requestType = com.google.cloud.bigquery.analyticshub.v1.ListListingsRequest.class,
      responseType = com.google.cloud.bigquery.analyticshub.v1.ListListingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.ListListingsRequest,
          com.google.cloud.bigquery.analyticshub.v1.ListListingsResponse>
      getListListingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.analyticshub.v1.ListListingsRequest,
            com.google.cloud.bigquery.analyticshub.v1.ListListingsResponse>
        getListListingsMethod;
    if ((getListListingsMethod = AnalyticsHubServiceGrpc.getListListingsMethod) == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getListListingsMethod = AnalyticsHubServiceGrpc.getListListingsMethod) == null) {
          AnalyticsHubServiceGrpc.getListListingsMethod =
              getListListingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.analyticshub.v1.ListListingsRequest,
                          com.google.cloud.bigquery.analyticshub.v1.ListListingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListListings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.ListListingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.ListListingsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsHubServiceMethodDescriptorSupplier("ListListings"))
                      .build();
        }
      }
    }
    return getListListingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.GetListingRequest,
          com.google.cloud.bigquery.analyticshub.v1.Listing>
      getGetListingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetListing",
      requestType = com.google.cloud.bigquery.analyticshub.v1.GetListingRequest.class,
      responseType = com.google.cloud.bigquery.analyticshub.v1.Listing.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.GetListingRequest,
          com.google.cloud.bigquery.analyticshub.v1.Listing>
      getGetListingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.analyticshub.v1.GetListingRequest,
            com.google.cloud.bigquery.analyticshub.v1.Listing>
        getGetListingMethod;
    if ((getGetListingMethod = AnalyticsHubServiceGrpc.getGetListingMethod) == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getGetListingMethod = AnalyticsHubServiceGrpc.getGetListingMethod) == null) {
          AnalyticsHubServiceGrpc.getGetListingMethod =
              getGetListingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.analyticshub.v1.GetListingRequest,
                          com.google.cloud.bigquery.analyticshub.v1.Listing>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetListing"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.GetListingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.Listing
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsHubServiceMethodDescriptorSupplier("GetListing"))
                      .build();
        }
      }
    }
    return getGetListingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.CreateListingRequest,
          com.google.cloud.bigquery.analyticshub.v1.Listing>
      getCreateListingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateListing",
      requestType = com.google.cloud.bigquery.analyticshub.v1.CreateListingRequest.class,
      responseType = com.google.cloud.bigquery.analyticshub.v1.Listing.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.CreateListingRequest,
          com.google.cloud.bigquery.analyticshub.v1.Listing>
      getCreateListingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.analyticshub.v1.CreateListingRequest,
            com.google.cloud.bigquery.analyticshub.v1.Listing>
        getCreateListingMethod;
    if ((getCreateListingMethod = AnalyticsHubServiceGrpc.getCreateListingMethod) == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getCreateListingMethod = AnalyticsHubServiceGrpc.getCreateListingMethod) == null) {
          AnalyticsHubServiceGrpc.getCreateListingMethod =
              getCreateListingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.analyticshub.v1.CreateListingRequest,
                          com.google.cloud.bigquery.analyticshub.v1.Listing>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateListing"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.CreateListingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.Listing
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsHubServiceMethodDescriptorSupplier("CreateListing"))
                      .build();
        }
      }
    }
    return getCreateListingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.UpdateListingRequest,
          com.google.cloud.bigquery.analyticshub.v1.Listing>
      getUpdateListingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateListing",
      requestType = com.google.cloud.bigquery.analyticshub.v1.UpdateListingRequest.class,
      responseType = com.google.cloud.bigquery.analyticshub.v1.Listing.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.UpdateListingRequest,
          com.google.cloud.bigquery.analyticshub.v1.Listing>
      getUpdateListingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.analyticshub.v1.UpdateListingRequest,
            com.google.cloud.bigquery.analyticshub.v1.Listing>
        getUpdateListingMethod;
    if ((getUpdateListingMethod = AnalyticsHubServiceGrpc.getUpdateListingMethod) == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getUpdateListingMethod = AnalyticsHubServiceGrpc.getUpdateListingMethod) == null) {
          AnalyticsHubServiceGrpc.getUpdateListingMethod =
              getUpdateListingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.analyticshub.v1.UpdateListingRequest,
                          com.google.cloud.bigquery.analyticshub.v1.Listing>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateListing"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.UpdateListingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.Listing
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsHubServiceMethodDescriptorSupplier("UpdateListing"))
                      .build();
        }
      }
    }
    return getUpdateListingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.DeleteListingRequest, com.google.protobuf.Empty>
      getDeleteListingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteListing",
      requestType = com.google.cloud.bigquery.analyticshub.v1.DeleteListingRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.DeleteListingRequest, com.google.protobuf.Empty>
      getDeleteListingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.analyticshub.v1.DeleteListingRequest,
            com.google.protobuf.Empty>
        getDeleteListingMethod;
    if ((getDeleteListingMethod = AnalyticsHubServiceGrpc.getDeleteListingMethod) == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getDeleteListingMethod = AnalyticsHubServiceGrpc.getDeleteListingMethod) == null) {
          AnalyticsHubServiceGrpc.getDeleteListingMethod =
              getDeleteListingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.analyticshub.v1.DeleteListingRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteListing"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.DeleteListingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsHubServiceMethodDescriptorSupplier("DeleteListing"))
                      .build();
        }
      }
    }
    return getDeleteListingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.SubscribeListingRequest,
          com.google.cloud.bigquery.analyticshub.v1.SubscribeListingResponse>
      getSubscribeListingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SubscribeListing",
      requestType = com.google.cloud.bigquery.analyticshub.v1.SubscribeListingRequest.class,
      responseType = com.google.cloud.bigquery.analyticshub.v1.SubscribeListingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.SubscribeListingRequest,
          com.google.cloud.bigquery.analyticshub.v1.SubscribeListingResponse>
      getSubscribeListingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.analyticshub.v1.SubscribeListingRequest,
            com.google.cloud.bigquery.analyticshub.v1.SubscribeListingResponse>
        getSubscribeListingMethod;
    if ((getSubscribeListingMethod = AnalyticsHubServiceGrpc.getSubscribeListingMethod) == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getSubscribeListingMethod = AnalyticsHubServiceGrpc.getSubscribeListingMethod)
            == null) {
          AnalyticsHubServiceGrpc.getSubscribeListingMethod =
              getSubscribeListingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.analyticshub.v1.SubscribeListingRequest,
                          com.google.cloud.bigquery.analyticshub.v1.SubscribeListingResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SubscribeListing"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.SubscribeListingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.SubscribeListingResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsHubServiceMethodDescriptorSupplier("SubscribeListing"))
                      .build();
        }
      }
    }
    return getSubscribeListingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.SubscribeDataExchangeRequest,
          com.google.longrunning.Operation>
      getSubscribeDataExchangeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SubscribeDataExchange",
      requestType = com.google.cloud.bigquery.analyticshub.v1.SubscribeDataExchangeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.SubscribeDataExchangeRequest,
          com.google.longrunning.Operation>
      getSubscribeDataExchangeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.analyticshub.v1.SubscribeDataExchangeRequest,
            com.google.longrunning.Operation>
        getSubscribeDataExchangeMethod;
    if ((getSubscribeDataExchangeMethod = AnalyticsHubServiceGrpc.getSubscribeDataExchangeMethod)
        == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getSubscribeDataExchangeMethod =
                AnalyticsHubServiceGrpc.getSubscribeDataExchangeMethod)
            == null) {
          AnalyticsHubServiceGrpc.getSubscribeDataExchangeMethod =
              getSubscribeDataExchangeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.analyticshub.v1.SubscribeDataExchangeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SubscribeDataExchange"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.SubscribeDataExchangeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsHubServiceMethodDescriptorSupplier("SubscribeDataExchange"))
                      .build();
        }
      }
    }
    return getSubscribeDataExchangeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.RefreshSubscriptionRequest,
          com.google.longrunning.Operation>
      getRefreshSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RefreshSubscription",
      requestType = com.google.cloud.bigquery.analyticshub.v1.RefreshSubscriptionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.RefreshSubscriptionRequest,
          com.google.longrunning.Operation>
      getRefreshSubscriptionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.analyticshub.v1.RefreshSubscriptionRequest,
            com.google.longrunning.Operation>
        getRefreshSubscriptionMethod;
    if ((getRefreshSubscriptionMethod = AnalyticsHubServiceGrpc.getRefreshSubscriptionMethod)
        == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getRefreshSubscriptionMethod = AnalyticsHubServiceGrpc.getRefreshSubscriptionMethod)
            == null) {
          AnalyticsHubServiceGrpc.getRefreshSubscriptionMethod =
              getRefreshSubscriptionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.analyticshub.v1.RefreshSubscriptionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RefreshSubscription"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.RefreshSubscriptionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsHubServiceMethodDescriptorSupplier("RefreshSubscription"))
                      .build();
        }
      }
    }
    return getRefreshSubscriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.GetSubscriptionRequest,
          com.google.cloud.bigquery.analyticshub.v1.Subscription>
      getGetSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSubscription",
      requestType = com.google.cloud.bigquery.analyticshub.v1.GetSubscriptionRequest.class,
      responseType = com.google.cloud.bigquery.analyticshub.v1.Subscription.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.GetSubscriptionRequest,
          com.google.cloud.bigquery.analyticshub.v1.Subscription>
      getGetSubscriptionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.analyticshub.v1.GetSubscriptionRequest,
            com.google.cloud.bigquery.analyticshub.v1.Subscription>
        getGetSubscriptionMethod;
    if ((getGetSubscriptionMethod = AnalyticsHubServiceGrpc.getGetSubscriptionMethod) == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getGetSubscriptionMethod = AnalyticsHubServiceGrpc.getGetSubscriptionMethod) == null) {
          AnalyticsHubServiceGrpc.getGetSubscriptionMethod =
              getGetSubscriptionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.analyticshub.v1.GetSubscriptionRequest,
                          com.google.cloud.bigquery.analyticshub.v1.Subscription>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSubscription"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.GetSubscriptionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.Subscription
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsHubServiceMethodDescriptorSupplier("GetSubscription"))
                      .build();
        }
      }
    }
    return getGetSubscriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.ListSubscriptionsRequest,
          com.google.cloud.bigquery.analyticshub.v1.ListSubscriptionsResponse>
      getListSubscriptionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSubscriptions",
      requestType = com.google.cloud.bigquery.analyticshub.v1.ListSubscriptionsRequest.class,
      responseType = com.google.cloud.bigquery.analyticshub.v1.ListSubscriptionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.ListSubscriptionsRequest,
          com.google.cloud.bigquery.analyticshub.v1.ListSubscriptionsResponse>
      getListSubscriptionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.analyticshub.v1.ListSubscriptionsRequest,
            com.google.cloud.bigquery.analyticshub.v1.ListSubscriptionsResponse>
        getListSubscriptionsMethod;
    if ((getListSubscriptionsMethod = AnalyticsHubServiceGrpc.getListSubscriptionsMethod) == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getListSubscriptionsMethod = AnalyticsHubServiceGrpc.getListSubscriptionsMethod)
            == null) {
          AnalyticsHubServiceGrpc.getListSubscriptionsMethod =
              getListSubscriptionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.analyticshub.v1.ListSubscriptionsRequest,
                          com.google.cloud.bigquery.analyticshub.v1.ListSubscriptionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSubscriptions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.ListSubscriptionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.ListSubscriptionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsHubServiceMethodDescriptorSupplier("ListSubscriptions"))
                      .build();
        }
      }
    }
    return getListSubscriptionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.ListSharedResourceSubscriptionsRequest,
          com.google.cloud.bigquery.analyticshub.v1.ListSharedResourceSubscriptionsResponse>
      getListSharedResourceSubscriptionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSharedResourceSubscriptions",
      requestType =
          com.google.cloud.bigquery.analyticshub.v1.ListSharedResourceSubscriptionsRequest.class,
      responseType =
          com.google.cloud.bigquery.analyticshub.v1.ListSharedResourceSubscriptionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.ListSharedResourceSubscriptionsRequest,
          com.google.cloud.bigquery.analyticshub.v1.ListSharedResourceSubscriptionsResponse>
      getListSharedResourceSubscriptionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.analyticshub.v1.ListSharedResourceSubscriptionsRequest,
            com.google.cloud.bigquery.analyticshub.v1.ListSharedResourceSubscriptionsResponse>
        getListSharedResourceSubscriptionsMethod;
    if ((getListSharedResourceSubscriptionsMethod =
            AnalyticsHubServiceGrpc.getListSharedResourceSubscriptionsMethod)
        == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getListSharedResourceSubscriptionsMethod =
                AnalyticsHubServiceGrpc.getListSharedResourceSubscriptionsMethod)
            == null) {
          AnalyticsHubServiceGrpc.getListSharedResourceSubscriptionsMethod =
              getListSharedResourceSubscriptionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.analyticshub.v1
                              .ListSharedResourceSubscriptionsRequest,
                          com.google.cloud.bigquery.analyticshub.v1
                              .ListSharedResourceSubscriptionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListSharedResourceSubscriptions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1
                                  .ListSharedResourceSubscriptionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1
                                  .ListSharedResourceSubscriptionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsHubServiceMethodDescriptorSupplier(
                              "ListSharedResourceSubscriptions"))
                      .build();
        }
      }
    }
    return getListSharedResourceSubscriptionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.RevokeSubscriptionRequest,
          com.google.cloud.bigquery.analyticshub.v1.RevokeSubscriptionResponse>
      getRevokeSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RevokeSubscription",
      requestType = com.google.cloud.bigquery.analyticshub.v1.RevokeSubscriptionRequest.class,
      responseType = com.google.cloud.bigquery.analyticshub.v1.RevokeSubscriptionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.RevokeSubscriptionRequest,
          com.google.cloud.bigquery.analyticshub.v1.RevokeSubscriptionResponse>
      getRevokeSubscriptionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.analyticshub.v1.RevokeSubscriptionRequest,
            com.google.cloud.bigquery.analyticshub.v1.RevokeSubscriptionResponse>
        getRevokeSubscriptionMethod;
    if ((getRevokeSubscriptionMethod = AnalyticsHubServiceGrpc.getRevokeSubscriptionMethod)
        == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getRevokeSubscriptionMethod = AnalyticsHubServiceGrpc.getRevokeSubscriptionMethod)
            == null) {
          AnalyticsHubServiceGrpc.getRevokeSubscriptionMethod =
              getRevokeSubscriptionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.analyticshub.v1.RevokeSubscriptionRequest,
                          com.google.cloud.bigquery.analyticshub.v1.RevokeSubscriptionResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RevokeSubscription"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.RevokeSubscriptionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.RevokeSubscriptionResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsHubServiceMethodDescriptorSupplier("RevokeSubscription"))
                      .build();
        }
      }
    }
    return getRevokeSubscriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.DeleteSubscriptionRequest,
          com.google.longrunning.Operation>
      getDeleteSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSubscription",
      requestType = com.google.cloud.bigquery.analyticshub.v1.DeleteSubscriptionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.DeleteSubscriptionRequest,
          com.google.longrunning.Operation>
      getDeleteSubscriptionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.analyticshub.v1.DeleteSubscriptionRequest,
            com.google.longrunning.Operation>
        getDeleteSubscriptionMethod;
    if ((getDeleteSubscriptionMethod = AnalyticsHubServiceGrpc.getDeleteSubscriptionMethod)
        == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getDeleteSubscriptionMethod = AnalyticsHubServiceGrpc.getDeleteSubscriptionMethod)
            == null) {
          AnalyticsHubServiceGrpc.getDeleteSubscriptionMethod =
              getDeleteSubscriptionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.analyticshub.v1.DeleteSubscriptionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSubscription"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.DeleteSubscriptionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsHubServiceMethodDescriptorSupplier("DeleteSubscription"))
                      .build();
        }
      }
    }
    return getDeleteSubscriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIamPolicy",
      requestType = com.google.iam.v1.GetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
        getGetIamPolicyMethod;
    if ((getGetIamPolicyMethod = AnalyticsHubServiceGrpc.getGetIamPolicyMethod) == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getGetIamPolicyMethod = AnalyticsHubServiceGrpc.getGetIamPolicyMethod) == null) {
          AnalyticsHubServiceGrpc.getGetIamPolicyMethod =
              getGetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsHubServiceMethodDescriptorSupplier("GetIamPolicy"))
                      .build();
        }
      }
    }
    return getGetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetIamPolicy",
      requestType = com.google.iam.v1.SetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
        getSetIamPolicyMethod;
    if ((getSetIamPolicyMethod = AnalyticsHubServiceGrpc.getSetIamPolicyMethod) == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getSetIamPolicyMethod = AnalyticsHubServiceGrpc.getSetIamPolicyMethod) == null) {
          AnalyticsHubServiceGrpc.getSetIamPolicyMethod =
              getSetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsHubServiceMethodDescriptorSupplier("SetIamPolicy"))
                      .build();
        }
      }
    }
    return getSetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestIamPermissions",
      requestType = com.google.iam.v1.TestIamPermissionsRequest.class,
      responseType = com.google.iam.v1.TestIamPermissionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v1.TestIamPermissionsRequest,
            com.google.iam.v1.TestIamPermissionsResponse>
        getTestIamPermissionsMethod;
    if ((getTestIamPermissionsMethod = AnalyticsHubServiceGrpc.getTestIamPermissionsMethod)
        == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getTestIamPermissionsMethod = AnalyticsHubServiceGrpc.getTestIamPermissionsMethod)
            == null) {
          AnalyticsHubServiceGrpc.getTestIamPermissionsMethod =
              getTestIamPermissionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.TestIamPermissionsRequest,
                          com.google.iam.v1.TestIamPermissionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestIamPermissions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsHubServiceMethodDescriptorSupplier("TestIamPermissions"))
                      .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.CreateQueryTemplateRequest,
          com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
      getCreateQueryTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateQueryTemplate",
      requestType = com.google.cloud.bigquery.analyticshub.v1.CreateQueryTemplateRequest.class,
      responseType = com.google.cloud.bigquery.analyticshub.v1.QueryTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.CreateQueryTemplateRequest,
          com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
      getCreateQueryTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.analyticshub.v1.CreateQueryTemplateRequest,
            com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
        getCreateQueryTemplateMethod;
    if ((getCreateQueryTemplateMethod = AnalyticsHubServiceGrpc.getCreateQueryTemplateMethod)
        == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getCreateQueryTemplateMethod = AnalyticsHubServiceGrpc.getCreateQueryTemplateMethod)
            == null) {
          AnalyticsHubServiceGrpc.getCreateQueryTemplateMethod =
              getCreateQueryTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.analyticshub.v1.CreateQueryTemplateRequest,
                          com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateQueryTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.CreateQueryTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.QueryTemplate
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsHubServiceMethodDescriptorSupplier("CreateQueryTemplate"))
                      .build();
        }
      }
    }
    return getCreateQueryTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.GetQueryTemplateRequest,
          com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
      getGetQueryTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetQueryTemplate",
      requestType = com.google.cloud.bigquery.analyticshub.v1.GetQueryTemplateRequest.class,
      responseType = com.google.cloud.bigquery.analyticshub.v1.QueryTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.GetQueryTemplateRequest,
          com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
      getGetQueryTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.analyticshub.v1.GetQueryTemplateRequest,
            com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
        getGetQueryTemplateMethod;
    if ((getGetQueryTemplateMethod = AnalyticsHubServiceGrpc.getGetQueryTemplateMethod) == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getGetQueryTemplateMethod = AnalyticsHubServiceGrpc.getGetQueryTemplateMethod)
            == null) {
          AnalyticsHubServiceGrpc.getGetQueryTemplateMethod =
              getGetQueryTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.analyticshub.v1.GetQueryTemplateRequest,
                          com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetQueryTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.GetQueryTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.QueryTemplate
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsHubServiceMethodDescriptorSupplier("GetQueryTemplate"))
                      .build();
        }
      }
    }
    return getGetQueryTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.ListQueryTemplatesRequest,
          com.google.cloud.bigquery.analyticshub.v1.ListQueryTemplatesResponse>
      getListQueryTemplatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListQueryTemplates",
      requestType = com.google.cloud.bigquery.analyticshub.v1.ListQueryTemplatesRequest.class,
      responseType = com.google.cloud.bigquery.analyticshub.v1.ListQueryTemplatesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.ListQueryTemplatesRequest,
          com.google.cloud.bigquery.analyticshub.v1.ListQueryTemplatesResponse>
      getListQueryTemplatesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.analyticshub.v1.ListQueryTemplatesRequest,
            com.google.cloud.bigquery.analyticshub.v1.ListQueryTemplatesResponse>
        getListQueryTemplatesMethod;
    if ((getListQueryTemplatesMethod = AnalyticsHubServiceGrpc.getListQueryTemplatesMethod)
        == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getListQueryTemplatesMethod = AnalyticsHubServiceGrpc.getListQueryTemplatesMethod)
            == null) {
          AnalyticsHubServiceGrpc.getListQueryTemplatesMethod =
              getListQueryTemplatesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.analyticshub.v1.ListQueryTemplatesRequest,
                          com.google.cloud.bigquery.analyticshub.v1.ListQueryTemplatesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListQueryTemplates"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.ListQueryTemplatesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.ListQueryTemplatesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsHubServiceMethodDescriptorSupplier("ListQueryTemplates"))
                      .build();
        }
      }
    }
    return getListQueryTemplatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.UpdateQueryTemplateRequest,
          com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
      getUpdateQueryTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateQueryTemplate",
      requestType = com.google.cloud.bigquery.analyticshub.v1.UpdateQueryTemplateRequest.class,
      responseType = com.google.cloud.bigquery.analyticshub.v1.QueryTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.UpdateQueryTemplateRequest,
          com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
      getUpdateQueryTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.analyticshub.v1.UpdateQueryTemplateRequest,
            com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
        getUpdateQueryTemplateMethod;
    if ((getUpdateQueryTemplateMethod = AnalyticsHubServiceGrpc.getUpdateQueryTemplateMethod)
        == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getUpdateQueryTemplateMethod = AnalyticsHubServiceGrpc.getUpdateQueryTemplateMethod)
            == null) {
          AnalyticsHubServiceGrpc.getUpdateQueryTemplateMethod =
              getUpdateQueryTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.analyticshub.v1.UpdateQueryTemplateRequest,
                          com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateQueryTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.UpdateQueryTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.QueryTemplate
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsHubServiceMethodDescriptorSupplier("UpdateQueryTemplate"))
                      .build();
        }
      }
    }
    return getUpdateQueryTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.DeleteQueryTemplateRequest,
          com.google.protobuf.Empty>
      getDeleteQueryTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteQueryTemplate",
      requestType = com.google.cloud.bigquery.analyticshub.v1.DeleteQueryTemplateRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.DeleteQueryTemplateRequest,
          com.google.protobuf.Empty>
      getDeleteQueryTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.analyticshub.v1.DeleteQueryTemplateRequest,
            com.google.protobuf.Empty>
        getDeleteQueryTemplateMethod;
    if ((getDeleteQueryTemplateMethod = AnalyticsHubServiceGrpc.getDeleteQueryTemplateMethod)
        == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getDeleteQueryTemplateMethod = AnalyticsHubServiceGrpc.getDeleteQueryTemplateMethod)
            == null) {
          AnalyticsHubServiceGrpc.getDeleteQueryTemplateMethod =
              getDeleteQueryTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.analyticshub.v1.DeleteQueryTemplateRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteQueryTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.DeleteQueryTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsHubServiceMethodDescriptorSupplier("DeleteQueryTemplate"))
                      .build();
        }
      }
    }
    return getDeleteQueryTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.SubmitQueryTemplateRequest,
          com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
      getSubmitQueryTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SubmitQueryTemplate",
      requestType = com.google.cloud.bigquery.analyticshub.v1.SubmitQueryTemplateRequest.class,
      responseType = com.google.cloud.bigquery.analyticshub.v1.QueryTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.SubmitQueryTemplateRequest,
          com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
      getSubmitQueryTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.analyticshub.v1.SubmitQueryTemplateRequest,
            com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
        getSubmitQueryTemplateMethod;
    if ((getSubmitQueryTemplateMethod = AnalyticsHubServiceGrpc.getSubmitQueryTemplateMethod)
        == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getSubmitQueryTemplateMethod = AnalyticsHubServiceGrpc.getSubmitQueryTemplateMethod)
            == null) {
          AnalyticsHubServiceGrpc.getSubmitQueryTemplateMethod =
              getSubmitQueryTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.analyticshub.v1.SubmitQueryTemplateRequest,
                          com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SubmitQueryTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.SubmitQueryTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.QueryTemplate
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsHubServiceMethodDescriptorSupplier("SubmitQueryTemplate"))
                      .build();
        }
      }
    }
    return getSubmitQueryTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.ApproveQueryTemplateRequest,
          com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
      getApproveQueryTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ApproveQueryTemplate",
      requestType = com.google.cloud.bigquery.analyticshub.v1.ApproveQueryTemplateRequest.class,
      responseType = com.google.cloud.bigquery.analyticshub.v1.QueryTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.analyticshub.v1.ApproveQueryTemplateRequest,
          com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
      getApproveQueryTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.analyticshub.v1.ApproveQueryTemplateRequest,
            com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
        getApproveQueryTemplateMethod;
    if ((getApproveQueryTemplateMethod = AnalyticsHubServiceGrpc.getApproveQueryTemplateMethod)
        == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getApproveQueryTemplateMethod = AnalyticsHubServiceGrpc.getApproveQueryTemplateMethod)
            == null) {
          AnalyticsHubServiceGrpc.getApproveQueryTemplateMethod =
              getApproveQueryTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.analyticshub.v1.ApproveQueryTemplateRequest,
                          com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ApproveQueryTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.ApproveQueryTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.analyticshub.v1.QueryTemplate
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsHubServiceMethodDescriptorSupplier("ApproveQueryTemplate"))
                      .build();
        }
      }
    }
    return getApproveQueryTemplateMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AnalyticsHubServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AnalyticsHubServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AnalyticsHubServiceStub>() {
          @java.lang.Override
          public AnalyticsHubServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AnalyticsHubServiceStub(channel, callOptions);
          }
        };
    return AnalyticsHubServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static AnalyticsHubServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AnalyticsHubServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AnalyticsHubServiceBlockingV2Stub>() {
          @java.lang.Override
          public AnalyticsHubServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AnalyticsHubServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return AnalyticsHubServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AnalyticsHubServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AnalyticsHubServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AnalyticsHubServiceBlockingStub>() {
          @java.lang.Override
          public AnalyticsHubServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AnalyticsHubServiceBlockingStub(channel, callOptions);
          }
        };
    return AnalyticsHubServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AnalyticsHubServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AnalyticsHubServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AnalyticsHubServiceFutureStub>() {
          @java.lang.Override
          public AnalyticsHubServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AnalyticsHubServiceFutureStub(channel, callOptions);
          }
        };
    return AnalyticsHubServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The `AnalyticsHubService` API facilitates data sharing within and across
   * organizations. It allows data providers to publish listings that reference
   * shared datasets. With Analytics Hub, users can discover and search for
   * listings that they have access to. Subscribers can view and subscribe to
   * listings. When you subscribe to a listing, Analytics Hub creates a linked
   * dataset in your project.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists all data exchanges in a given project and location.
     * </pre>
     */
    default void listDataExchanges(
        com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDataExchangesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all data exchanges from projects in a given organization and
     * location.
     * </pre>
     */
    default void listOrgDataExchanges(
        com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListOrgDataExchangesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a data exchange.
     * </pre>
     */
    default void getDataExchange(
        com.google.cloud.bigquery.analyticshub.v1.GetDataExchangeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.DataExchange>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDataExchangeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new data exchange.
     * </pre>
     */
    default void createDataExchange(
        com.google.cloud.bigquery.analyticshub.v1.CreateDataExchangeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.DataExchange>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDataExchangeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing data exchange.
     * </pre>
     */
    default void updateDataExchange(
        com.google.cloud.bigquery.analyticshub.v1.UpdateDataExchangeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.DataExchange>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDataExchangeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing data exchange.
     * </pre>
     */
    default void deleteDataExchange(
        com.google.cloud.bigquery.analyticshub.v1.DeleteDataExchangeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDataExchangeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all listings in a given project and location.
     * </pre>
     */
    default void listListings(
        com.google.cloud.bigquery.analyticshub.v1.ListListingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.ListListingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListListingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a listing.
     * </pre>
     */
    default void getListing(
        com.google.cloud.bigquery.analyticshub.v1.GetListingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.Listing>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetListingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new listing.
     * </pre>
     */
    default void createListing(
        com.google.cloud.bigquery.analyticshub.v1.CreateListingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.Listing>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateListingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing listing.
     * </pre>
     */
    default void updateListing(
        com.google.cloud.bigquery.analyticshub.v1.UpdateListingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.Listing>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateListingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a listing.
     * </pre>
     */
    default void deleteListing(
        com.google.cloud.bigquery.analyticshub.v1.DeleteListingRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteListingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Subscribes to a listing.
     * Currently, with Analytics Hub, you can create listings that
     * reference only BigQuery datasets.
     * Upon subscription to a listing for a BigQuery dataset, Analytics Hub
     * creates a linked dataset in the subscriber's project.
     * </pre>
     */
    default void subscribeListing(
        com.google.cloud.bigquery.analyticshub.v1.SubscribeListingRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.analyticshub.v1.SubscribeListingResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSubscribeListingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Subscription to a Data Clean Room. This is a
     * long-running operation as it will create one or more linked datasets.
     * Throws a Bad Request error if the Data Exchange does not contain any
     * listings.
     * </pre>
     */
    default void subscribeDataExchange(
        com.google.cloud.bigquery.analyticshub.v1.SubscribeDataExchangeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSubscribeDataExchangeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Refreshes a Subscription to a Data Exchange. A Data Exchange can become
     * stale when a publisher adds or removes data. This is a long-running
     * operation as it may create many linked datasets.
     * </pre>
     */
    default void refreshSubscription(
        com.google.cloud.bigquery.analyticshub.v1.RefreshSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRefreshSubscriptionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a Subscription.
     * </pre>
     */
    default void getSubscription(
        com.google.cloud.bigquery.analyticshub.v1.GetSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.Subscription>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSubscriptionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all subscriptions in a given project and location.
     * </pre>
     */
    default void listSubscriptions(
        com.google.cloud.bigquery.analyticshub.v1.ListSubscriptionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.analyticshub.v1.ListSubscriptionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSubscriptionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all subscriptions on a given Data Exchange or Listing.
     * </pre>
     */
    default void listSharedResourceSubscriptions(
        com.google.cloud.bigquery.analyticshub.v1.ListSharedResourceSubscriptionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.analyticshub.v1.ListSharedResourceSubscriptionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSharedResourceSubscriptionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Revokes a given subscription.
     * </pre>
     */
    default void revokeSubscription(
        com.google.cloud.bigquery.analyticshub.v1.RevokeSubscriptionRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.analyticshub.v1.RevokeSubscriptionResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRevokeSubscriptionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a subscription.
     * </pre>
     */
    default void deleteSubscription(
        com.google.cloud.bigquery.analyticshub.v1.DeleteSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSubscriptionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM policy.
     * </pre>
     */
    default void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the IAM policy.
     * </pre>
     */
    default void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the permissions that a caller has.
     * </pre>
     */
    default void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getTestIamPermissionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new QueryTemplate
     * </pre>
     */
    default void createQueryTemplate(
        com.google.cloud.bigquery.analyticshub.v1.CreateQueryTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateQueryTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a QueryTemplate
     * </pre>
     */
    default void getQueryTemplate(
        com.google.cloud.bigquery.analyticshub.v1.GetQueryTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetQueryTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all QueryTemplates in a given project and location.
     * </pre>
     */
    default void listQueryTemplates(
        com.google.cloud.bigquery.analyticshub.v1.ListQueryTemplatesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.analyticshub.v1.ListQueryTemplatesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListQueryTemplatesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing QueryTemplate
     * </pre>
     */
    default void updateQueryTemplate(
        com.google.cloud.bigquery.analyticshub.v1.UpdateQueryTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateQueryTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a query template.
     * </pre>
     */
    default void deleteQueryTemplate(
        com.google.cloud.bigquery.analyticshub.v1.DeleteQueryTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteQueryTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Submits a query template for approval.
     * </pre>
     */
    default void submitQueryTemplate(
        com.google.cloud.bigquery.analyticshub.v1.SubmitQueryTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSubmitQueryTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Approves a query template.
     * </pre>
     */
    default void approveQueryTemplate(
        com.google.cloud.bigquery.analyticshub.v1.ApproveQueryTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getApproveQueryTemplateMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AnalyticsHubService.
   *
   * <pre>
   * The `AnalyticsHubService` API facilitates data sharing within and across
   * organizations. It allows data providers to publish listings that reference
   * shared datasets. With Analytics Hub, users can discover and search for
   * listings that they have access to. Subscribers can view and subscribe to
   * listings. When you subscribe to a listing, Analytics Hub creates a linked
   * dataset in your project.
   * </pre>
   */
  public abstract static class AnalyticsHubServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AnalyticsHubServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AnalyticsHubService.
   *
   * <pre>
   * The `AnalyticsHubService` API facilitates data sharing within and across
   * organizations. It allows data providers to publish listings that reference
   * shared datasets. With Analytics Hub, users can discover and search for
   * listings that they have access to. Subscribers can view and subscribe to
   * listings. When you subscribe to a listing, Analytics Hub creates a linked
   * dataset in your project.
   * </pre>
   */
  public static final class AnalyticsHubServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AnalyticsHubServiceStub> {
    private AnalyticsHubServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnalyticsHubServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AnalyticsHubServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all data exchanges in a given project and location.
     * </pre>
     */
    public void listDataExchanges(
        com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDataExchangesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all data exchanges from projects in a given organization and
     * location.
     * </pre>
     */
    public void listOrgDataExchanges(
        com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListOrgDataExchangesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a data exchange.
     * </pre>
     */
    public void getDataExchange(
        com.google.cloud.bigquery.analyticshub.v1.GetDataExchangeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.DataExchange>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataExchangeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new data exchange.
     * </pre>
     */
    public void createDataExchange(
        com.google.cloud.bigquery.analyticshub.v1.CreateDataExchangeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.DataExchange>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDataExchangeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing data exchange.
     * </pre>
     */
    public void updateDataExchange(
        com.google.cloud.bigquery.analyticshub.v1.UpdateDataExchangeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.DataExchange>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDataExchangeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing data exchange.
     * </pre>
     */
    public void deleteDataExchange(
        com.google.cloud.bigquery.analyticshub.v1.DeleteDataExchangeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDataExchangeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all listings in a given project and location.
     * </pre>
     */
    public void listListings(
        com.google.cloud.bigquery.analyticshub.v1.ListListingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.ListListingsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListListingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a listing.
     * </pre>
     */
    public void getListing(
        com.google.cloud.bigquery.analyticshub.v1.GetListingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.Listing>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetListingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new listing.
     * </pre>
     */
    public void createListing(
        com.google.cloud.bigquery.analyticshub.v1.CreateListingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.Listing>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateListingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing listing.
     * </pre>
     */
    public void updateListing(
        com.google.cloud.bigquery.analyticshub.v1.UpdateListingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.Listing>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateListingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a listing.
     * </pre>
     */
    public void deleteListing(
        com.google.cloud.bigquery.analyticshub.v1.DeleteListingRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteListingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Subscribes to a listing.
     * Currently, with Analytics Hub, you can create listings that
     * reference only BigQuery datasets.
     * Upon subscription to a listing for a BigQuery dataset, Analytics Hub
     * creates a linked dataset in the subscriber's project.
     * </pre>
     */
    public void subscribeListing(
        com.google.cloud.bigquery.analyticshub.v1.SubscribeListingRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.analyticshub.v1.SubscribeListingResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSubscribeListingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Subscription to a Data Clean Room. This is a
     * long-running operation as it will create one or more linked datasets.
     * Throws a Bad Request error if the Data Exchange does not contain any
     * listings.
     * </pre>
     */
    public void subscribeDataExchange(
        com.google.cloud.bigquery.analyticshub.v1.SubscribeDataExchangeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSubscribeDataExchangeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Refreshes a Subscription to a Data Exchange. A Data Exchange can become
     * stale when a publisher adds or removes data. This is a long-running
     * operation as it may create many linked datasets.
     * </pre>
     */
    public void refreshSubscription(
        com.google.cloud.bigquery.analyticshub.v1.RefreshSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRefreshSubscriptionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a Subscription.
     * </pre>
     */
    public void getSubscription(
        com.google.cloud.bigquery.analyticshub.v1.GetSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.Subscription>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSubscriptionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all subscriptions in a given project and location.
     * </pre>
     */
    public void listSubscriptions(
        com.google.cloud.bigquery.analyticshub.v1.ListSubscriptionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.analyticshub.v1.ListSubscriptionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSubscriptionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all subscriptions on a given Data Exchange or Listing.
     * </pre>
     */
    public void listSharedResourceSubscriptions(
        com.google.cloud.bigquery.analyticshub.v1.ListSharedResourceSubscriptionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.analyticshub.v1.ListSharedResourceSubscriptionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSharedResourceSubscriptionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Revokes a given subscription.
     * </pre>
     */
    public void revokeSubscription(
        com.google.cloud.bigquery.analyticshub.v1.RevokeSubscriptionRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.analyticshub.v1.RevokeSubscriptionResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRevokeSubscriptionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a subscription.
     * </pre>
     */
    public void deleteSubscription(
        com.google.cloud.bigquery.analyticshub.v1.DeleteSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSubscriptionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM policy.
     * </pre>
     */
    public void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the IAM policy.
     * </pre>
     */
    public void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the permissions that a caller has.
     * </pre>
     */
    public void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new QueryTemplate
     * </pre>
     */
    public void createQueryTemplate(
        com.google.cloud.bigquery.analyticshub.v1.CreateQueryTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateQueryTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a QueryTemplate
     * </pre>
     */
    public void getQueryTemplate(
        com.google.cloud.bigquery.analyticshub.v1.GetQueryTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetQueryTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all QueryTemplates in a given project and location.
     * </pre>
     */
    public void listQueryTemplates(
        com.google.cloud.bigquery.analyticshub.v1.ListQueryTemplatesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.analyticshub.v1.ListQueryTemplatesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListQueryTemplatesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing QueryTemplate
     * </pre>
     */
    public void updateQueryTemplate(
        com.google.cloud.bigquery.analyticshub.v1.UpdateQueryTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateQueryTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a query template.
     * </pre>
     */
    public void deleteQueryTemplate(
        com.google.cloud.bigquery.analyticshub.v1.DeleteQueryTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteQueryTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Submits a query template for approval.
     * </pre>
     */
    public void submitQueryTemplate(
        com.google.cloud.bigquery.analyticshub.v1.SubmitQueryTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSubmitQueryTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Approves a query template.
     * </pre>
     */
    public void approveQueryTemplate(
        com.google.cloud.bigquery.analyticshub.v1.ApproveQueryTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getApproveQueryTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AnalyticsHubService.
   *
   * <pre>
   * The `AnalyticsHubService` API facilitates data sharing within and across
   * organizations. It allows data providers to publish listings that reference
   * shared datasets. With Analytics Hub, users can discover and search for
   * listings that they have access to. Subscribers can view and subscribe to
   * listings. When you subscribe to a listing, Analytics Hub creates a linked
   * dataset in your project.
   * </pre>
   */
  public static final class AnalyticsHubServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<AnalyticsHubServiceBlockingV2Stub> {
    private AnalyticsHubServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnalyticsHubServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AnalyticsHubServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all data exchanges in a given project and location.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesResponse listDataExchanges(
        com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDataExchangesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all data exchanges from projects in a given organization and
     * location.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesResponse
        listOrgDataExchanges(
            com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListOrgDataExchangesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a data exchange.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.DataExchange getDataExchange(
        com.google.cloud.bigquery.analyticshub.v1.GetDataExchangeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataExchangeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new data exchange.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.DataExchange createDataExchange(
        com.google.cloud.bigquery.analyticshub.v1.CreateDataExchangeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDataExchangeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing data exchange.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.DataExchange updateDataExchange(
        com.google.cloud.bigquery.analyticshub.v1.UpdateDataExchangeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDataExchangeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing data exchange.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDataExchange(
        com.google.cloud.bigquery.analyticshub.v1.DeleteDataExchangeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDataExchangeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all listings in a given project and location.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.ListListingsResponse listListings(
        com.google.cloud.bigquery.analyticshub.v1.ListListingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListListingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a listing.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.Listing getListing(
        com.google.cloud.bigquery.analyticshub.v1.GetListingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetListingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new listing.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.Listing createListing(
        com.google.cloud.bigquery.analyticshub.v1.CreateListingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateListingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing listing.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.Listing updateListing(
        com.google.cloud.bigquery.analyticshub.v1.UpdateListingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateListingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a listing.
     * </pre>
     */
    public com.google.protobuf.Empty deleteListing(
        com.google.cloud.bigquery.analyticshub.v1.DeleteListingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteListingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Subscribes to a listing.
     * Currently, with Analytics Hub, you can create listings that
     * reference only BigQuery datasets.
     * Upon subscription to a listing for a BigQuery dataset, Analytics Hub
     * creates a linked dataset in the subscriber's project.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.SubscribeListingResponse subscribeListing(
        com.google.cloud.bigquery.analyticshub.v1.SubscribeListingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSubscribeListingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Subscription to a Data Clean Room. This is a
     * long-running operation as it will create one or more linked datasets.
     * Throws a Bad Request error if the Data Exchange does not contain any
     * listings.
     * </pre>
     */
    public com.google.longrunning.Operation subscribeDataExchange(
        com.google.cloud.bigquery.analyticshub.v1.SubscribeDataExchangeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSubscribeDataExchangeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Refreshes a Subscription to a Data Exchange. A Data Exchange can become
     * stale when a publisher adds or removes data. This is a long-running
     * operation as it may create many linked datasets.
     * </pre>
     */
    public com.google.longrunning.Operation refreshSubscription(
        com.google.cloud.bigquery.analyticshub.v1.RefreshSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRefreshSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a Subscription.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.Subscription getSubscription(
        com.google.cloud.bigquery.analyticshub.v1.GetSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all subscriptions in a given project and location.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.ListSubscriptionsResponse listSubscriptions(
        com.google.cloud.bigquery.analyticshub.v1.ListSubscriptionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSubscriptionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all subscriptions on a given Data Exchange or Listing.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.ListSharedResourceSubscriptionsResponse
        listSharedResourceSubscriptions(
            com.google.cloud.bigquery.analyticshub.v1.ListSharedResourceSubscriptionsRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSharedResourceSubscriptionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Revokes a given subscription.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.RevokeSubscriptionResponse revokeSubscription(
        com.google.cloud.bigquery.analyticshub.v1.RevokeSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRevokeSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a subscription.
     * </pre>
     */
    public com.google.longrunning.Operation deleteSubscription(
        com.google.cloud.bigquery.analyticshub.v1.DeleteSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM policy.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the IAM policy.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the permissions that a caller has.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new QueryTemplate
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.QueryTemplate createQueryTemplate(
        com.google.cloud.bigquery.analyticshub.v1.CreateQueryTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateQueryTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a QueryTemplate
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.QueryTemplate getQueryTemplate(
        com.google.cloud.bigquery.analyticshub.v1.GetQueryTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetQueryTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all QueryTemplates in a given project and location.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.ListQueryTemplatesResponse listQueryTemplates(
        com.google.cloud.bigquery.analyticshub.v1.ListQueryTemplatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListQueryTemplatesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing QueryTemplate
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.QueryTemplate updateQueryTemplate(
        com.google.cloud.bigquery.analyticshub.v1.UpdateQueryTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateQueryTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a query template.
     * </pre>
     */
    public com.google.protobuf.Empty deleteQueryTemplate(
        com.google.cloud.bigquery.analyticshub.v1.DeleteQueryTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteQueryTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Submits a query template for approval.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.QueryTemplate submitQueryTemplate(
        com.google.cloud.bigquery.analyticshub.v1.SubmitQueryTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSubmitQueryTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Approves a query template.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.QueryTemplate approveQueryTemplate(
        com.google.cloud.bigquery.analyticshub.v1.ApproveQueryTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getApproveQueryTemplateMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service AnalyticsHubService.
   *
   * <pre>
   * The `AnalyticsHubService` API facilitates data sharing within and across
   * organizations. It allows data providers to publish listings that reference
   * shared datasets. With Analytics Hub, users can discover and search for
   * listings that they have access to. Subscribers can view and subscribe to
   * listings. When you subscribe to a listing, Analytics Hub creates a linked
   * dataset in your project.
   * </pre>
   */
  public static final class AnalyticsHubServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AnalyticsHubServiceBlockingStub> {
    private AnalyticsHubServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnalyticsHubServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AnalyticsHubServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all data exchanges in a given project and location.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesResponse listDataExchanges(
        com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDataExchangesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all data exchanges from projects in a given organization and
     * location.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesResponse
        listOrgDataExchanges(
            com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListOrgDataExchangesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a data exchange.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.DataExchange getDataExchange(
        com.google.cloud.bigquery.analyticshub.v1.GetDataExchangeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataExchangeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new data exchange.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.DataExchange createDataExchange(
        com.google.cloud.bigquery.analyticshub.v1.CreateDataExchangeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDataExchangeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing data exchange.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.DataExchange updateDataExchange(
        com.google.cloud.bigquery.analyticshub.v1.UpdateDataExchangeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDataExchangeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing data exchange.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDataExchange(
        com.google.cloud.bigquery.analyticshub.v1.DeleteDataExchangeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDataExchangeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all listings in a given project and location.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.ListListingsResponse listListings(
        com.google.cloud.bigquery.analyticshub.v1.ListListingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListListingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a listing.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.Listing getListing(
        com.google.cloud.bigquery.analyticshub.v1.GetListingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetListingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new listing.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.Listing createListing(
        com.google.cloud.bigquery.analyticshub.v1.CreateListingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateListingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing listing.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.Listing updateListing(
        com.google.cloud.bigquery.analyticshub.v1.UpdateListingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateListingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a listing.
     * </pre>
     */
    public com.google.protobuf.Empty deleteListing(
        com.google.cloud.bigquery.analyticshub.v1.DeleteListingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteListingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Subscribes to a listing.
     * Currently, with Analytics Hub, you can create listings that
     * reference only BigQuery datasets.
     * Upon subscription to a listing for a BigQuery dataset, Analytics Hub
     * creates a linked dataset in the subscriber's project.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.SubscribeListingResponse subscribeListing(
        com.google.cloud.bigquery.analyticshub.v1.SubscribeListingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSubscribeListingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Subscription to a Data Clean Room. This is a
     * long-running operation as it will create one or more linked datasets.
     * Throws a Bad Request error if the Data Exchange does not contain any
     * listings.
     * </pre>
     */
    public com.google.longrunning.Operation subscribeDataExchange(
        com.google.cloud.bigquery.analyticshub.v1.SubscribeDataExchangeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSubscribeDataExchangeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Refreshes a Subscription to a Data Exchange. A Data Exchange can become
     * stale when a publisher adds or removes data. This is a long-running
     * operation as it may create many linked datasets.
     * </pre>
     */
    public com.google.longrunning.Operation refreshSubscription(
        com.google.cloud.bigquery.analyticshub.v1.RefreshSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRefreshSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a Subscription.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.Subscription getSubscription(
        com.google.cloud.bigquery.analyticshub.v1.GetSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all subscriptions in a given project and location.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.ListSubscriptionsResponse listSubscriptions(
        com.google.cloud.bigquery.analyticshub.v1.ListSubscriptionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSubscriptionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all subscriptions on a given Data Exchange or Listing.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.ListSharedResourceSubscriptionsResponse
        listSharedResourceSubscriptions(
            com.google.cloud.bigquery.analyticshub.v1.ListSharedResourceSubscriptionsRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSharedResourceSubscriptionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Revokes a given subscription.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.RevokeSubscriptionResponse revokeSubscription(
        com.google.cloud.bigquery.analyticshub.v1.RevokeSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRevokeSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a subscription.
     * </pre>
     */
    public com.google.longrunning.Operation deleteSubscription(
        com.google.cloud.bigquery.analyticshub.v1.DeleteSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM policy.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the IAM policy.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the permissions that a caller has.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new QueryTemplate
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.QueryTemplate createQueryTemplate(
        com.google.cloud.bigquery.analyticshub.v1.CreateQueryTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateQueryTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a QueryTemplate
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.QueryTemplate getQueryTemplate(
        com.google.cloud.bigquery.analyticshub.v1.GetQueryTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetQueryTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all QueryTemplates in a given project and location.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.ListQueryTemplatesResponse listQueryTemplates(
        com.google.cloud.bigquery.analyticshub.v1.ListQueryTemplatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListQueryTemplatesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing QueryTemplate
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.QueryTemplate updateQueryTemplate(
        com.google.cloud.bigquery.analyticshub.v1.UpdateQueryTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateQueryTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a query template.
     * </pre>
     */
    public com.google.protobuf.Empty deleteQueryTemplate(
        com.google.cloud.bigquery.analyticshub.v1.DeleteQueryTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteQueryTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Submits a query template for approval.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.QueryTemplate submitQueryTemplate(
        com.google.cloud.bigquery.analyticshub.v1.SubmitQueryTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSubmitQueryTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Approves a query template.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.QueryTemplate approveQueryTemplate(
        com.google.cloud.bigquery.analyticshub.v1.ApproveQueryTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getApproveQueryTemplateMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AnalyticsHubService.
   *
   * <pre>
   * The `AnalyticsHubService` API facilitates data sharing within and across
   * organizations. It allows data providers to publish listings that reference
   * shared datasets. With Analytics Hub, users can discover and search for
   * listings that they have access to. Subscribers can view and subscribe to
   * listings. When you subscribe to a listing, Analytics Hub creates a linked
   * dataset in your project.
   * </pre>
   */
  public static final class AnalyticsHubServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AnalyticsHubServiceFutureStub> {
    private AnalyticsHubServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnalyticsHubServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AnalyticsHubServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all data exchanges in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesResponse>
        listDataExchanges(
            com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDataExchangesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all data exchanges from projects in a given organization and
     * location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesResponse>
        listOrgDataExchanges(
            com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListOrgDataExchangesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a data exchange.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.analyticshub.v1.DataExchange>
        getDataExchange(com.google.cloud.bigquery.analyticshub.v1.GetDataExchangeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataExchangeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new data exchange.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.analyticshub.v1.DataExchange>
        createDataExchange(
            com.google.cloud.bigquery.analyticshub.v1.CreateDataExchangeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDataExchangeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing data exchange.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.analyticshub.v1.DataExchange>
        updateDataExchange(
            com.google.cloud.bigquery.analyticshub.v1.UpdateDataExchangeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDataExchangeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing data exchange.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteDataExchange(
            com.google.cloud.bigquery.analyticshub.v1.DeleteDataExchangeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDataExchangeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all listings in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.analyticshub.v1.ListListingsResponse>
        listListings(com.google.cloud.bigquery.analyticshub.v1.ListListingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListListingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a listing.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.analyticshub.v1.Listing>
        getListing(com.google.cloud.bigquery.analyticshub.v1.GetListingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetListingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new listing.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.analyticshub.v1.Listing>
        createListing(com.google.cloud.bigquery.analyticshub.v1.CreateListingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateListingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing listing.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.analyticshub.v1.Listing>
        updateListing(com.google.cloud.bigquery.analyticshub.v1.UpdateListingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateListingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a listing.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteListing(com.google.cloud.bigquery.analyticshub.v1.DeleteListingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteListingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Subscribes to a listing.
     * Currently, with Analytics Hub, you can create listings that
     * reference only BigQuery datasets.
     * Upon subscription to a listing for a BigQuery dataset, Analytics Hub
     * creates a linked dataset in the subscriber's project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.analyticshub.v1.SubscribeListingResponse>
        subscribeListing(
            com.google.cloud.bigquery.analyticshub.v1.SubscribeListingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSubscribeListingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Subscription to a Data Clean Room. This is a
     * long-running operation as it will create one or more linked datasets.
     * Throws a Bad Request error if the Data Exchange does not contain any
     * listings.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        subscribeDataExchange(
            com.google.cloud.bigquery.analyticshub.v1.SubscribeDataExchangeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSubscribeDataExchangeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Refreshes a Subscription to a Data Exchange. A Data Exchange can become
     * stale when a publisher adds or removes data. This is a long-running
     * operation as it may create many linked datasets.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        refreshSubscription(
            com.google.cloud.bigquery.analyticshub.v1.RefreshSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRefreshSubscriptionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a Subscription.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.analyticshub.v1.Subscription>
        getSubscription(com.google.cloud.bigquery.analyticshub.v1.GetSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSubscriptionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all subscriptions in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.analyticshub.v1.ListSubscriptionsResponse>
        listSubscriptions(
            com.google.cloud.bigquery.analyticshub.v1.ListSubscriptionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSubscriptionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all subscriptions on a given Data Exchange or Listing.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.analyticshub.v1.ListSharedResourceSubscriptionsResponse>
        listSharedResourceSubscriptions(
            com.google.cloud.bigquery.analyticshub.v1.ListSharedResourceSubscriptionsRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSharedResourceSubscriptionsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Revokes a given subscription.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.analyticshub.v1.RevokeSubscriptionResponse>
        revokeSubscription(
            com.google.cloud.bigquery.analyticshub.v1.RevokeSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRevokeSubscriptionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a subscription.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteSubscription(
            com.google.cloud.bigquery.analyticshub.v1.DeleteSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSubscriptionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the IAM policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the permissions that a caller has.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.iam.v1.TestIamPermissionsResponse>
        testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new QueryTemplate
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
        createQueryTemplate(
            com.google.cloud.bigquery.analyticshub.v1.CreateQueryTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateQueryTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a QueryTemplate
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
        getQueryTemplate(
            com.google.cloud.bigquery.analyticshub.v1.GetQueryTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetQueryTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all QueryTemplates in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.analyticshub.v1.ListQueryTemplatesResponse>
        listQueryTemplates(
            com.google.cloud.bigquery.analyticshub.v1.ListQueryTemplatesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListQueryTemplatesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing QueryTemplate
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
        updateQueryTemplate(
            com.google.cloud.bigquery.analyticshub.v1.UpdateQueryTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateQueryTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a query template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteQueryTemplate(
            com.google.cloud.bigquery.analyticshub.v1.DeleteQueryTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteQueryTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Submits a query template for approval.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
        submitQueryTemplate(
            com.google.cloud.bigquery.analyticshub.v1.SubmitQueryTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSubmitQueryTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Approves a query template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>
        approveQueryTemplate(
            com.google.cloud.bigquery.analyticshub.v1.ApproveQueryTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getApproveQueryTemplateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_DATA_EXCHANGES = 0;
  private static final int METHODID_LIST_ORG_DATA_EXCHANGES = 1;
  private static final int METHODID_GET_DATA_EXCHANGE = 2;
  private static final int METHODID_CREATE_DATA_EXCHANGE = 3;
  private static final int METHODID_UPDATE_DATA_EXCHANGE = 4;
  private static final int METHODID_DELETE_DATA_EXCHANGE = 5;
  private static final int METHODID_LIST_LISTINGS = 6;
  private static final int METHODID_GET_LISTING = 7;
  private static final int METHODID_CREATE_LISTING = 8;
  private static final int METHODID_UPDATE_LISTING = 9;
  private static final int METHODID_DELETE_LISTING = 10;
  private static final int METHODID_SUBSCRIBE_LISTING = 11;
  private static final int METHODID_SUBSCRIBE_DATA_EXCHANGE = 12;
  private static final int METHODID_REFRESH_SUBSCRIPTION = 13;
  private static final int METHODID_GET_SUBSCRIPTION = 14;
  private static final int METHODID_LIST_SUBSCRIPTIONS = 15;
  private static final int METHODID_LIST_SHARED_RESOURCE_SUBSCRIPTIONS = 16;
  private static final int METHODID_REVOKE_SUBSCRIPTION = 17;
  private static final int METHODID_DELETE_SUBSCRIPTION = 18;
  private static final int METHODID_GET_IAM_POLICY = 19;
  private static final int METHODID_SET_IAM_POLICY = 20;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 21;
  private static final int METHODID_CREATE_QUERY_TEMPLATE = 22;
  private static final int METHODID_GET_QUERY_TEMPLATE = 23;
  private static final int METHODID_LIST_QUERY_TEMPLATES = 24;
  private static final int METHODID_UPDATE_QUERY_TEMPLATE = 25;
  private static final int METHODID_DELETE_QUERY_TEMPLATE = 26;
  private static final int METHODID_SUBMIT_QUERY_TEMPLATE = 27;
  private static final int METHODID_APPROVE_QUERY_TEMPLATE = 28;

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
        case METHODID_LIST_DATA_EXCHANGES:
          serviceImpl.listDataExchanges(
              (com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_ORG_DATA_EXCHANGES:
          serviceImpl.listOrgDataExchanges(
              (com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DATA_EXCHANGE:
          serviceImpl.getDataExchange(
              (com.google.cloud.bigquery.analyticshub.v1.GetDataExchangeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.DataExchange>)
                  responseObserver);
          break;
        case METHODID_CREATE_DATA_EXCHANGE:
          serviceImpl.createDataExchange(
              (com.google.cloud.bigquery.analyticshub.v1.CreateDataExchangeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.DataExchange>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DATA_EXCHANGE:
          serviceImpl.updateDataExchange(
              (com.google.cloud.bigquery.analyticshub.v1.UpdateDataExchangeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.DataExchange>)
                  responseObserver);
          break;
        case METHODID_DELETE_DATA_EXCHANGE:
          serviceImpl.deleteDataExchange(
              (com.google.cloud.bigquery.analyticshub.v1.DeleteDataExchangeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_LISTINGS:
          serviceImpl.listListings(
              (com.google.cloud.bigquery.analyticshub.v1.ListListingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.analyticshub.v1.ListListingsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_LISTING:
          serviceImpl.getListing(
              (com.google.cloud.bigquery.analyticshub.v1.GetListingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.Listing>)
                  responseObserver);
          break;
        case METHODID_CREATE_LISTING:
          serviceImpl.createListing(
              (com.google.cloud.bigquery.analyticshub.v1.CreateListingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.Listing>)
                  responseObserver);
          break;
        case METHODID_UPDATE_LISTING:
          serviceImpl.updateListing(
              (com.google.cloud.bigquery.analyticshub.v1.UpdateListingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.Listing>)
                  responseObserver);
          break;
        case METHODID_DELETE_LISTING:
          serviceImpl.deleteListing(
              (com.google.cloud.bigquery.analyticshub.v1.DeleteListingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_SUBSCRIBE_LISTING:
          serviceImpl.subscribeListing(
              (com.google.cloud.bigquery.analyticshub.v1.SubscribeListingRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.analyticshub.v1.SubscribeListingResponse>)
                  responseObserver);
          break;
        case METHODID_SUBSCRIBE_DATA_EXCHANGE:
          serviceImpl.subscribeDataExchange(
              (com.google.cloud.bigquery.analyticshub.v1.SubscribeDataExchangeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_REFRESH_SUBSCRIPTION:
          serviceImpl.refreshSubscription(
              (com.google.cloud.bigquery.analyticshub.v1.RefreshSubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_SUBSCRIPTION:
          serviceImpl.getSubscription(
              (com.google.cloud.bigquery.analyticshub.v1.GetSubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.Subscription>)
                  responseObserver);
          break;
        case METHODID_LIST_SUBSCRIPTIONS:
          serviceImpl.listSubscriptions(
              (com.google.cloud.bigquery.analyticshub.v1.ListSubscriptionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.analyticshub.v1.ListSubscriptionsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_SHARED_RESOURCE_SUBSCRIPTIONS:
          serviceImpl.listSharedResourceSubscriptions(
              (com.google.cloud.bigquery.analyticshub.v1.ListSharedResourceSubscriptionsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.analyticshub.v1
                          .ListSharedResourceSubscriptionsResponse>)
                  responseObserver);
          break;
        case METHODID_REVOKE_SUBSCRIPTION:
          serviceImpl.revokeSubscription(
              (com.google.cloud.bigquery.analyticshub.v1.RevokeSubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.analyticshub.v1.RevokeSubscriptionResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_SUBSCRIPTION:
          serviceImpl.deleteSubscription(
              (com.google.cloud.bigquery.analyticshub.v1.DeleteSubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy(
              (com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_SET_IAM_POLICY:
          serviceImpl.setIamPolicy(
              (com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS:
          serviceImpl.testIamPermissions(
              (com.google.iam.v1.TestIamPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_QUERY_TEMPLATE:
          serviceImpl.createQueryTemplate(
              (com.google.cloud.bigquery.analyticshub.v1.CreateQueryTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>)
                  responseObserver);
          break;
        case METHODID_GET_QUERY_TEMPLATE:
          serviceImpl.getQueryTemplate(
              (com.google.cloud.bigquery.analyticshub.v1.GetQueryTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>)
                  responseObserver);
          break;
        case METHODID_LIST_QUERY_TEMPLATES:
          serviceImpl.listQueryTemplates(
              (com.google.cloud.bigquery.analyticshub.v1.ListQueryTemplatesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.analyticshub.v1.ListQueryTemplatesResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_QUERY_TEMPLATE:
          serviceImpl.updateQueryTemplate(
              (com.google.cloud.bigquery.analyticshub.v1.UpdateQueryTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>)
                  responseObserver);
          break;
        case METHODID_DELETE_QUERY_TEMPLATE:
          serviceImpl.deleteQueryTemplate(
              (com.google.cloud.bigquery.analyticshub.v1.DeleteQueryTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_SUBMIT_QUERY_TEMPLATE:
          serviceImpl.submitQueryTemplate(
              (com.google.cloud.bigquery.analyticshub.v1.SubmitQueryTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>)
                  responseObserver);
          break;
        case METHODID_APPROVE_QUERY_TEMPLATE:
          serviceImpl.approveQueryTemplate(
              (com.google.cloud.bigquery.analyticshub.v1.ApproveQueryTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>)
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
            getListDataExchangesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesRequest,
                    com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesResponse>(
                    service, METHODID_LIST_DATA_EXCHANGES)))
        .addMethod(
            getListOrgDataExchangesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesRequest,
                    com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesResponse>(
                    service, METHODID_LIST_ORG_DATA_EXCHANGES)))
        .addMethod(
            getGetDataExchangeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.analyticshub.v1.GetDataExchangeRequest,
                    com.google.cloud.bigquery.analyticshub.v1.DataExchange>(
                    service, METHODID_GET_DATA_EXCHANGE)))
        .addMethod(
            getCreateDataExchangeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.analyticshub.v1.CreateDataExchangeRequest,
                    com.google.cloud.bigquery.analyticshub.v1.DataExchange>(
                    service, METHODID_CREATE_DATA_EXCHANGE)))
        .addMethod(
            getUpdateDataExchangeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.analyticshub.v1.UpdateDataExchangeRequest,
                    com.google.cloud.bigquery.analyticshub.v1.DataExchange>(
                    service, METHODID_UPDATE_DATA_EXCHANGE)))
        .addMethod(
            getDeleteDataExchangeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.analyticshub.v1.DeleteDataExchangeRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_DATA_EXCHANGE)))
        .addMethod(
            getListListingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.analyticshub.v1.ListListingsRequest,
                    com.google.cloud.bigquery.analyticshub.v1.ListListingsResponse>(
                    service, METHODID_LIST_LISTINGS)))
        .addMethod(
            getGetListingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.analyticshub.v1.GetListingRequest,
                    com.google.cloud.bigquery.analyticshub.v1.Listing>(
                    service, METHODID_GET_LISTING)))
        .addMethod(
            getCreateListingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.analyticshub.v1.CreateListingRequest,
                    com.google.cloud.bigquery.analyticshub.v1.Listing>(
                    service, METHODID_CREATE_LISTING)))
        .addMethod(
            getUpdateListingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.analyticshub.v1.UpdateListingRequest,
                    com.google.cloud.bigquery.analyticshub.v1.Listing>(
                    service, METHODID_UPDATE_LISTING)))
        .addMethod(
            getDeleteListingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.analyticshub.v1.DeleteListingRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_LISTING)))
        .addMethod(
            getSubscribeListingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.analyticshub.v1.SubscribeListingRequest,
                    com.google.cloud.bigquery.analyticshub.v1.SubscribeListingResponse>(
                    service, METHODID_SUBSCRIBE_LISTING)))
        .addMethod(
            getSubscribeDataExchangeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.analyticshub.v1.SubscribeDataExchangeRequest,
                    com.google.longrunning.Operation>(service, METHODID_SUBSCRIBE_DATA_EXCHANGE)))
        .addMethod(
            getRefreshSubscriptionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.analyticshub.v1.RefreshSubscriptionRequest,
                    com.google.longrunning.Operation>(service, METHODID_REFRESH_SUBSCRIPTION)))
        .addMethod(
            getGetSubscriptionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.analyticshub.v1.GetSubscriptionRequest,
                    com.google.cloud.bigquery.analyticshub.v1.Subscription>(
                    service, METHODID_GET_SUBSCRIPTION)))
        .addMethod(
            getListSubscriptionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.analyticshub.v1.ListSubscriptionsRequest,
                    com.google.cloud.bigquery.analyticshub.v1.ListSubscriptionsResponse>(
                    service, METHODID_LIST_SUBSCRIPTIONS)))
        .addMethod(
            getListSharedResourceSubscriptionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.analyticshub.v1
                        .ListSharedResourceSubscriptionsRequest,
                    com.google.cloud.bigquery.analyticshub.v1
                        .ListSharedResourceSubscriptionsResponse>(
                    service, METHODID_LIST_SHARED_RESOURCE_SUBSCRIPTIONS)))
        .addMethod(
            getRevokeSubscriptionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.analyticshub.v1.RevokeSubscriptionRequest,
                    com.google.cloud.bigquery.analyticshub.v1.RevokeSubscriptionResponse>(
                    service, METHODID_REVOKE_SUBSCRIPTION)))
        .addMethod(
            getDeleteSubscriptionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.analyticshub.v1.DeleteSubscriptionRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_SUBSCRIPTION)))
        .addMethod(
            getGetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>(
                    service, METHODID_GET_IAM_POLICY)))
        .addMethod(
            getSetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>(
                    service, METHODID_SET_IAM_POLICY)))
        .addMethod(
            getTestIamPermissionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.iam.v1.TestIamPermissionsRequest,
                    com.google.iam.v1.TestIamPermissionsResponse>(
                    service, METHODID_TEST_IAM_PERMISSIONS)))
        .addMethod(
            getCreateQueryTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.analyticshub.v1.CreateQueryTemplateRequest,
                    com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>(
                    service, METHODID_CREATE_QUERY_TEMPLATE)))
        .addMethod(
            getGetQueryTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.analyticshub.v1.GetQueryTemplateRequest,
                    com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>(
                    service, METHODID_GET_QUERY_TEMPLATE)))
        .addMethod(
            getListQueryTemplatesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.analyticshub.v1.ListQueryTemplatesRequest,
                    com.google.cloud.bigquery.analyticshub.v1.ListQueryTemplatesResponse>(
                    service, METHODID_LIST_QUERY_TEMPLATES)))
        .addMethod(
            getUpdateQueryTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.analyticshub.v1.UpdateQueryTemplateRequest,
                    com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>(
                    service, METHODID_UPDATE_QUERY_TEMPLATE)))
        .addMethod(
            getDeleteQueryTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.analyticshub.v1.DeleteQueryTemplateRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_QUERY_TEMPLATE)))
        .addMethod(
            getSubmitQueryTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.analyticshub.v1.SubmitQueryTemplateRequest,
                    com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>(
                    service, METHODID_SUBMIT_QUERY_TEMPLATE)))
        .addMethod(
            getApproveQueryTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.analyticshub.v1.ApproveQueryTemplateRequest,
                    com.google.cloud.bigquery.analyticshub.v1.QueryTemplate>(
                    service, METHODID_APPROVE_QUERY_TEMPLATE)))
        .build();
  }

  private abstract static class AnalyticsHubServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AnalyticsHubServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.bigquery.analyticshub.v1.AnalyticsHubProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AnalyticsHubService");
    }
  }

  private static final class AnalyticsHubServiceFileDescriptorSupplier
      extends AnalyticsHubServiceBaseDescriptorSupplier {
    AnalyticsHubServiceFileDescriptorSupplier() {}
  }

  private static final class AnalyticsHubServiceMethodDescriptorSupplier
      extends AnalyticsHubServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AnalyticsHubServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AnalyticsHubServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AnalyticsHubServiceFileDescriptorSupplier())
                      .addMethod(getListDataExchangesMethod())
                      .addMethod(getListOrgDataExchangesMethod())
                      .addMethod(getGetDataExchangeMethod())
                      .addMethod(getCreateDataExchangeMethod())
                      .addMethod(getUpdateDataExchangeMethod())
                      .addMethod(getDeleteDataExchangeMethod())
                      .addMethod(getListListingsMethod())
                      .addMethod(getGetListingMethod())
                      .addMethod(getCreateListingMethod())
                      .addMethod(getUpdateListingMethod())
                      .addMethod(getDeleteListingMethod())
                      .addMethod(getSubscribeListingMethod())
                      .addMethod(getSubscribeDataExchangeMethod())
                      .addMethod(getRefreshSubscriptionMethod())
                      .addMethod(getGetSubscriptionMethod())
                      .addMethod(getListSubscriptionsMethod())
                      .addMethod(getListSharedResourceSubscriptionsMethod())
                      .addMethod(getRevokeSubscriptionMethod())
                      .addMethod(getDeleteSubscriptionMethod())
                      .addMethod(getGetIamPolicyMethod())
                      .addMethod(getSetIamPolicyMethod())
                      .addMethod(getTestIamPermissionsMethod())
                      .addMethod(getCreateQueryTemplateMethod())
                      .addMethod(getGetQueryTemplateMethod())
                      .addMethod(getListQueryTemplatesMethod())
                      .addMethod(getUpdateQueryTemplateMethod())
                      .addMethod(getDeleteQueryTemplateMethod())
                      .addMethod(getSubmitQueryTemplateMethod())
                      .addMethod(getApproveQueryTemplateMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
