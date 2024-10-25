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
package com.google.cloud.gdchardwaremanagement.v1alpha;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The GDC Hardware Management service.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/gdchardwaremanagement/v1alpha/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GDCHardwareManagementGrpc {

  private GDCHardwareManagementGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.ListOrdersRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.ListOrdersResponse>
      getListOrdersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListOrders",
      requestType = com.google.cloud.gdchardwaremanagement.v1alpha.ListOrdersRequest.class,
      responseType = com.google.cloud.gdchardwaremanagement.v1alpha.ListOrdersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.ListOrdersRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.ListOrdersResponse>
      getListOrdersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.ListOrdersRequest,
            com.google.cloud.gdchardwaremanagement.v1alpha.ListOrdersResponse>
        getListOrdersMethod;
    if ((getListOrdersMethod = GDCHardwareManagementGrpc.getListOrdersMethod) == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getListOrdersMethod = GDCHardwareManagementGrpc.getListOrdersMethod) == null) {
          GDCHardwareManagementGrpc.getListOrdersMethod =
              getListOrdersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.ListOrdersRequest,
                          com.google.cloud.gdchardwaremanagement.v1alpha.ListOrdersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListOrders"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.ListOrdersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.ListOrdersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("ListOrders"))
                      .build();
        }
      }
    }
    return getListOrdersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.GetOrderRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.Order>
      getGetOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOrder",
      requestType = com.google.cloud.gdchardwaremanagement.v1alpha.GetOrderRequest.class,
      responseType = com.google.cloud.gdchardwaremanagement.v1alpha.Order.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.GetOrderRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.Order>
      getGetOrderMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.GetOrderRequest,
            com.google.cloud.gdchardwaremanagement.v1alpha.Order>
        getGetOrderMethod;
    if ((getGetOrderMethod = GDCHardwareManagementGrpc.getGetOrderMethod) == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getGetOrderMethod = GDCHardwareManagementGrpc.getGetOrderMethod) == null) {
          GDCHardwareManagementGrpc.getGetOrderMethod =
              getGetOrderMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.GetOrderRequest,
                          com.google.cloud.gdchardwaremanagement.v1alpha.Order>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetOrder"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.GetOrderRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.Order
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("GetOrder"))
                      .build();
        }
      }
    }
    return getGetOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.CreateOrderRequest,
          com.google.longrunning.Operation>
      getCreateOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateOrder",
      requestType = com.google.cloud.gdchardwaremanagement.v1alpha.CreateOrderRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.CreateOrderRequest,
          com.google.longrunning.Operation>
      getCreateOrderMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.CreateOrderRequest,
            com.google.longrunning.Operation>
        getCreateOrderMethod;
    if ((getCreateOrderMethod = GDCHardwareManagementGrpc.getCreateOrderMethod) == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getCreateOrderMethod = GDCHardwareManagementGrpc.getCreateOrderMethod) == null) {
          GDCHardwareManagementGrpc.getCreateOrderMethod =
              getCreateOrderMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.CreateOrderRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateOrder"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.CreateOrderRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("CreateOrder"))
                      .build();
        }
      }
    }
    return getCreateOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.UpdateOrderRequest,
          com.google.longrunning.Operation>
      getUpdateOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateOrder",
      requestType = com.google.cloud.gdchardwaremanagement.v1alpha.UpdateOrderRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.UpdateOrderRequest,
          com.google.longrunning.Operation>
      getUpdateOrderMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.UpdateOrderRequest,
            com.google.longrunning.Operation>
        getUpdateOrderMethod;
    if ((getUpdateOrderMethod = GDCHardwareManagementGrpc.getUpdateOrderMethod) == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getUpdateOrderMethod = GDCHardwareManagementGrpc.getUpdateOrderMethod) == null) {
          GDCHardwareManagementGrpc.getUpdateOrderMethod =
              getUpdateOrderMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.UpdateOrderRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateOrder"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.UpdateOrderRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("UpdateOrder"))
                      .build();
        }
      }
    }
    return getUpdateOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.DeleteOrderRequest,
          com.google.longrunning.Operation>
      getDeleteOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteOrder",
      requestType = com.google.cloud.gdchardwaremanagement.v1alpha.DeleteOrderRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.DeleteOrderRequest,
          com.google.longrunning.Operation>
      getDeleteOrderMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.DeleteOrderRequest,
            com.google.longrunning.Operation>
        getDeleteOrderMethod;
    if ((getDeleteOrderMethod = GDCHardwareManagementGrpc.getDeleteOrderMethod) == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getDeleteOrderMethod = GDCHardwareManagementGrpc.getDeleteOrderMethod) == null) {
          GDCHardwareManagementGrpc.getDeleteOrderMethod =
              getDeleteOrderMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.DeleteOrderRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteOrder"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.DeleteOrderRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("DeleteOrder"))
                      .build();
        }
      }
    }
    return getDeleteOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.SubmitOrderRequest,
          com.google.longrunning.Operation>
      getSubmitOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SubmitOrder",
      requestType = com.google.cloud.gdchardwaremanagement.v1alpha.SubmitOrderRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.SubmitOrderRequest,
          com.google.longrunning.Operation>
      getSubmitOrderMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.SubmitOrderRequest,
            com.google.longrunning.Operation>
        getSubmitOrderMethod;
    if ((getSubmitOrderMethod = GDCHardwareManagementGrpc.getSubmitOrderMethod) == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getSubmitOrderMethod = GDCHardwareManagementGrpc.getSubmitOrderMethod) == null) {
          GDCHardwareManagementGrpc.getSubmitOrderMethod =
              getSubmitOrderMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.SubmitOrderRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SubmitOrder"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.SubmitOrderRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("SubmitOrder"))
                      .build();
        }
      }
    }
    return getSubmitOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.ListSitesRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.ListSitesResponse>
      getListSitesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSites",
      requestType = com.google.cloud.gdchardwaremanagement.v1alpha.ListSitesRequest.class,
      responseType = com.google.cloud.gdchardwaremanagement.v1alpha.ListSitesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.ListSitesRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.ListSitesResponse>
      getListSitesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.ListSitesRequest,
            com.google.cloud.gdchardwaremanagement.v1alpha.ListSitesResponse>
        getListSitesMethod;
    if ((getListSitesMethod = GDCHardwareManagementGrpc.getListSitesMethod) == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getListSitesMethod = GDCHardwareManagementGrpc.getListSitesMethod) == null) {
          GDCHardwareManagementGrpc.getListSitesMethod =
              getListSitesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.ListSitesRequest,
                          com.google.cloud.gdchardwaremanagement.v1alpha.ListSitesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSites"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.ListSitesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.ListSitesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("ListSites"))
                      .build();
        }
      }
    }
    return getListSitesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.GetSiteRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.Site>
      getGetSiteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSite",
      requestType = com.google.cloud.gdchardwaremanagement.v1alpha.GetSiteRequest.class,
      responseType = com.google.cloud.gdchardwaremanagement.v1alpha.Site.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.GetSiteRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.Site>
      getGetSiteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.GetSiteRequest,
            com.google.cloud.gdchardwaremanagement.v1alpha.Site>
        getGetSiteMethod;
    if ((getGetSiteMethod = GDCHardwareManagementGrpc.getGetSiteMethod) == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getGetSiteMethod = GDCHardwareManagementGrpc.getGetSiteMethod) == null) {
          GDCHardwareManagementGrpc.getGetSiteMethod =
              getGetSiteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.GetSiteRequest,
                          com.google.cloud.gdchardwaremanagement.v1alpha.Site>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSite"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.GetSiteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.Site
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("GetSite"))
                      .build();
        }
      }
    }
    return getGetSiteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.CreateSiteRequest,
          com.google.longrunning.Operation>
      getCreateSiteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSite",
      requestType = com.google.cloud.gdchardwaremanagement.v1alpha.CreateSiteRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.CreateSiteRequest,
          com.google.longrunning.Operation>
      getCreateSiteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.CreateSiteRequest,
            com.google.longrunning.Operation>
        getCreateSiteMethod;
    if ((getCreateSiteMethod = GDCHardwareManagementGrpc.getCreateSiteMethod) == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getCreateSiteMethod = GDCHardwareManagementGrpc.getCreateSiteMethod) == null) {
          GDCHardwareManagementGrpc.getCreateSiteMethod =
              getCreateSiteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.CreateSiteRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSite"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.CreateSiteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("CreateSite"))
                      .build();
        }
      }
    }
    return getCreateSiteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.UpdateSiteRequest,
          com.google.longrunning.Operation>
      getUpdateSiteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSite",
      requestType = com.google.cloud.gdchardwaremanagement.v1alpha.UpdateSiteRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.UpdateSiteRequest,
          com.google.longrunning.Operation>
      getUpdateSiteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.UpdateSiteRequest,
            com.google.longrunning.Operation>
        getUpdateSiteMethod;
    if ((getUpdateSiteMethod = GDCHardwareManagementGrpc.getUpdateSiteMethod) == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getUpdateSiteMethod = GDCHardwareManagementGrpc.getUpdateSiteMethod) == null) {
          GDCHardwareManagementGrpc.getUpdateSiteMethod =
              getUpdateSiteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.UpdateSiteRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSite"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.UpdateSiteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("UpdateSite"))
                      .build();
        }
      }
    }
    return getUpdateSiteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.DeleteSiteRequest,
          com.google.longrunning.Operation>
      getDeleteSiteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSite",
      requestType = com.google.cloud.gdchardwaremanagement.v1alpha.DeleteSiteRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.DeleteSiteRequest,
          com.google.longrunning.Operation>
      getDeleteSiteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.DeleteSiteRequest,
            com.google.longrunning.Operation>
        getDeleteSiteMethod;
    if ((getDeleteSiteMethod = GDCHardwareManagementGrpc.getDeleteSiteMethod) == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getDeleteSiteMethod = GDCHardwareManagementGrpc.getDeleteSiteMethod) == null) {
          GDCHardwareManagementGrpc.getDeleteSiteMethod =
              getDeleteSiteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.DeleteSiteRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSite"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.DeleteSiteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("DeleteSite"))
                      .build();
        }
      }
    }
    return getDeleteSiteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareGroupsRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareGroupsResponse>
      getListHardwareGroupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListHardwareGroups",
      requestType = com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareGroupsRequest.class,
      responseType =
          com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareGroupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareGroupsRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareGroupsResponse>
      getListHardwareGroupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareGroupsRequest,
            com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareGroupsResponse>
        getListHardwareGroupsMethod;
    if ((getListHardwareGroupsMethod = GDCHardwareManagementGrpc.getListHardwareGroupsMethod)
        == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getListHardwareGroupsMethod = GDCHardwareManagementGrpc.getListHardwareGroupsMethod)
            == null) {
          GDCHardwareManagementGrpc.getListHardwareGroupsMethod =
              getListHardwareGroupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareGroupsRequest,
                          com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareGroupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListHardwareGroups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha
                                  .ListHardwareGroupsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha
                                  .ListHardwareGroupsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("ListHardwareGroups"))
                      .build();
        }
      }
    }
    return getListHardwareGroupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.GetHardwareGroupRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.HardwareGroup>
      getGetHardwareGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetHardwareGroup",
      requestType = com.google.cloud.gdchardwaremanagement.v1alpha.GetHardwareGroupRequest.class,
      responseType = com.google.cloud.gdchardwaremanagement.v1alpha.HardwareGroup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.GetHardwareGroupRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.HardwareGroup>
      getGetHardwareGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.GetHardwareGroupRequest,
            com.google.cloud.gdchardwaremanagement.v1alpha.HardwareGroup>
        getGetHardwareGroupMethod;
    if ((getGetHardwareGroupMethod = GDCHardwareManagementGrpc.getGetHardwareGroupMethod) == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getGetHardwareGroupMethod = GDCHardwareManagementGrpc.getGetHardwareGroupMethod)
            == null) {
          GDCHardwareManagementGrpc.getGetHardwareGroupMethod =
              getGetHardwareGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.GetHardwareGroupRequest,
                          com.google.cloud.gdchardwaremanagement.v1alpha.HardwareGroup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetHardwareGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.GetHardwareGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.HardwareGroup
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("GetHardwareGroup"))
                      .build();
        }
      }
    }
    return getGetHardwareGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.CreateHardwareGroupRequest,
          com.google.longrunning.Operation>
      getCreateHardwareGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateHardwareGroup",
      requestType = com.google.cloud.gdchardwaremanagement.v1alpha.CreateHardwareGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.CreateHardwareGroupRequest,
          com.google.longrunning.Operation>
      getCreateHardwareGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.CreateHardwareGroupRequest,
            com.google.longrunning.Operation>
        getCreateHardwareGroupMethod;
    if ((getCreateHardwareGroupMethod = GDCHardwareManagementGrpc.getCreateHardwareGroupMethod)
        == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getCreateHardwareGroupMethod = GDCHardwareManagementGrpc.getCreateHardwareGroupMethod)
            == null) {
          GDCHardwareManagementGrpc.getCreateHardwareGroupMethod =
              getCreateHardwareGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.CreateHardwareGroupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateHardwareGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha
                                  .CreateHardwareGroupRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("CreateHardwareGroup"))
                      .build();
        }
      }
    }
    return getCreateHardwareGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.UpdateHardwareGroupRequest,
          com.google.longrunning.Operation>
      getUpdateHardwareGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateHardwareGroup",
      requestType = com.google.cloud.gdchardwaremanagement.v1alpha.UpdateHardwareGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.UpdateHardwareGroupRequest,
          com.google.longrunning.Operation>
      getUpdateHardwareGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.UpdateHardwareGroupRequest,
            com.google.longrunning.Operation>
        getUpdateHardwareGroupMethod;
    if ((getUpdateHardwareGroupMethod = GDCHardwareManagementGrpc.getUpdateHardwareGroupMethod)
        == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getUpdateHardwareGroupMethod = GDCHardwareManagementGrpc.getUpdateHardwareGroupMethod)
            == null) {
          GDCHardwareManagementGrpc.getUpdateHardwareGroupMethod =
              getUpdateHardwareGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.UpdateHardwareGroupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateHardwareGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha
                                  .UpdateHardwareGroupRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("UpdateHardwareGroup"))
                      .build();
        }
      }
    }
    return getUpdateHardwareGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.DeleteHardwareGroupRequest,
          com.google.longrunning.Operation>
      getDeleteHardwareGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteHardwareGroup",
      requestType = com.google.cloud.gdchardwaremanagement.v1alpha.DeleteHardwareGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.DeleteHardwareGroupRequest,
          com.google.longrunning.Operation>
      getDeleteHardwareGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.DeleteHardwareGroupRequest,
            com.google.longrunning.Operation>
        getDeleteHardwareGroupMethod;
    if ((getDeleteHardwareGroupMethod = GDCHardwareManagementGrpc.getDeleteHardwareGroupMethod)
        == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getDeleteHardwareGroupMethod = GDCHardwareManagementGrpc.getDeleteHardwareGroupMethod)
            == null) {
          GDCHardwareManagementGrpc.getDeleteHardwareGroupMethod =
              getDeleteHardwareGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.DeleteHardwareGroupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteHardwareGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha
                                  .DeleteHardwareGroupRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("DeleteHardwareGroup"))
                      .build();
        }
      }
    }
    return getDeleteHardwareGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareResponse>
      getListHardwareMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListHardware",
      requestType = com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareRequest.class,
      responseType = com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareResponse>
      getListHardwareMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareRequest,
            com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareResponse>
        getListHardwareMethod;
    if ((getListHardwareMethod = GDCHardwareManagementGrpc.getListHardwareMethod) == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getListHardwareMethod = GDCHardwareManagementGrpc.getListHardwareMethod) == null) {
          GDCHardwareManagementGrpc.getListHardwareMethod =
              getListHardwareMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareRequest,
                          com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListHardware"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("ListHardware"))
                      .build();
        }
      }
    }
    return getListHardwareMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.GetHardwareRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.Hardware>
      getGetHardwareMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetHardware",
      requestType = com.google.cloud.gdchardwaremanagement.v1alpha.GetHardwareRequest.class,
      responseType = com.google.cloud.gdchardwaremanagement.v1alpha.Hardware.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.GetHardwareRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.Hardware>
      getGetHardwareMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.GetHardwareRequest,
            com.google.cloud.gdchardwaremanagement.v1alpha.Hardware>
        getGetHardwareMethod;
    if ((getGetHardwareMethod = GDCHardwareManagementGrpc.getGetHardwareMethod) == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getGetHardwareMethod = GDCHardwareManagementGrpc.getGetHardwareMethod) == null) {
          GDCHardwareManagementGrpc.getGetHardwareMethod =
              getGetHardwareMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.GetHardwareRequest,
                          com.google.cloud.gdchardwaremanagement.v1alpha.Hardware>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetHardware"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.GetHardwareRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.Hardware
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("GetHardware"))
                      .build();
        }
      }
    }
    return getGetHardwareMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.CreateHardwareRequest,
          com.google.longrunning.Operation>
      getCreateHardwareMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateHardware",
      requestType = com.google.cloud.gdchardwaremanagement.v1alpha.CreateHardwareRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.CreateHardwareRequest,
          com.google.longrunning.Operation>
      getCreateHardwareMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.CreateHardwareRequest,
            com.google.longrunning.Operation>
        getCreateHardwareMethod;
    if ((getCreateHardwareMethod = GDCHardwareManagementGrpc.getCreateHardwareMethod) == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getCreateHardwareMethod = GDCHardwareManagementGrpc.getCreateHardwareMethod) == null) {
          GDCHardwareManagementGrpc.getCreateHardwareMethod =
              getCreateHardwareMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.CreateHardwareRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateHardware"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.CreateHardwareRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("CreateHardware"))
                      .build();
        }
      }
    }
    return getCreateHardwareMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.UpdateHardwareRequest,
          com.google.longrunning.Operation>
      getUpdateHardwareMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateHardware",
      requestType = com.google.cloud.gdchardwaremanagement.v1alpha.UpdateHardwareRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.UpdateHardwareRequest,
          com.google.longrunning.Operation>
      getUpdateHardwareMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.UpdateHardwareRequest,
            com.google.longrunning.Operation>
        getUpdateHardwareMethod;
    if ((getUpdateHardwareMethod = GDCHardwareManagementGrpc.getUpdateHardwareMethod) == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getUpdateHardwareMethod = GDCHardwareManagementGrpc.getUpdateHardwareMethod) == null) {
          GDCHardwareManagementGrpc.getUpdateHardwareMethod =
              getUpdateHardwareMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.UpdateHardwareRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateHardware"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.UpdateHardwareRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("UpdateHardware"))
                      .build();
        }
      }
    }
    return getUpdateHardwareMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.DeleteHardwareRequest,
          com.google.longrunning.Operation>
      getDeleteHardwareMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteHardware",
      requestType = com.google.cloud.gdchardwaremanagement.v1alpha.DeleteHardwareRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.DeleteHardwareRequest,
          com.google.longrunning.Operation>
      getDeleteHardwareMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.DeleteHardwareRequest,
            com.google.longrunning.Operation>
        getDeleteHardwareMethod;
    if ((getDeleteHardwareMethod = GDCHardwareManagementGrpc.getDeleteHardwareMethod) == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getDeleteHardwareMethod = GDCHardwareManagementGrpc.getDeleteHardwareMethod) == null) {
          GDCHardwareManagementGrpc.getDeleteHardwareMethod =
              getDeleteHardwareMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.DeleteHardwareRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteHardware"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.DeleteHardwareRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("DeleteHardware"))
                      .build();
        }
      }
    }
    return getDeleteHardwareMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.ListCommentsRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.ListCommentsResponse>
      getListCommentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListComments",
      requestType = com.google.cloud.gdchardwaremanagement.v1alpha.ListCommentsRequest.class,
      responseType = com.google.cloud.gdchardwaremanagement.v1alpha.ListCommentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.ListCommentsRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.ListCommentsResponse>
      getListCommentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.ListCommentsRequest,
            com.google.cloud.gdchardwaremanagement.v1alpha.ListCommentsResponse>
        getListCommentsMethod;
    if ((getListCommentsMethod = GDCHardwareManagementGrpc.getListCommentsMethod) == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getListCommentsMethod = GDCHardwareManagementGrpc.getListCommentsMethod) == null) {
          GDCHardwareManagementGrpc.getListCommentsMethod =
              getListCommentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.ListCommentsRequest,
                          com.google.cloud.gdchardwaremanagement.v1alpha.ListCommentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListComments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.ListCommentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.ListCommentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("ListComments"))
                      .build();
        }
      }
    }
    return getListCommentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.GetCommentRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.Comment>
      getGetCommentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetComment",
      requestType = com.google.cloud.gdchardwaremanagement.v1alpha.GetCommentRequest.class,
      responseType = com.google.cloud.gdchardwaremanagement.v1alpha.Comment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.GetCommentRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.Comment>
      getGetCommentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.GetCommentRequest,
            com.google.cloud.gdchardwaremanagement.v1alpha.Comment>
        getGetCommentMethod;
    if ((getGetCommentMethod = GDCHardwareManagementGrpc.getGetCommentMethod) == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getGetCommentMethod = GDCHardwareManagementGrpc.getGetCommentMethod) == null) {
          GDCHardwareManagementGrpc.getGetCommentMethod =
              getGetCommentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.GetCommentRequest,
                          com.google.cloud.gdchardwaremanagement.v1alpha.Comment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetComment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.GetCommentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.Comment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("GetComment"))
                      .build();
        }
      }
    }
    return getGetCommentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.CreateCommentRequest,
          com.google.longrunning.Operation>
      getCreateCommentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateComment",
      requestType = com.google.cloud.gdchardwaremanagement.v1alpha.CreateCommentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.CreateCommentRequest,
          com.google.longrunning.Operation>
      getCreateCommentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.CreateCommentRequest,
            com.google.longrunning.Operation>
        getCreateCommentMethod;
    if ((getCreateCommentMethod = GDCHardwareManagementGrpc.getCreateCommentMethod) == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getCreateCommentMethod = GDCHardwareManagementGrpc.getCreateCommentMethod) == null) {
          GDCHardwareManagementGrpc.getCreateCommentMethod =
              getCreateCommentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.CreateCommentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateComment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.CreateCommentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("CreateComment"))
                      .build();
        }
      }
    }
    return getCreateCommentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.RecordActionOnCommentRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.Comment>
      getRecordActionOnCommentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RecordActionOnComment",
      requestType =
          com.google.cloud.gdchardwaremanagement.v1alpha.RecordActionOnCommentRequest.class,
      responseType = com.google.cloud.gdchardwaremanagement.v1alpha.Comment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.RecordActionOnCommentRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.Comment>
      getRecordActionOnCommentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.RecordActionOnCommentRequest,
            com.google.cloud.gdchardwaremanagement.v1alpha.Comment>
        getRecordActionOnCommentMethod;
    if ((getRecordActionOnCommentMethod = GDCHardwareManagementGrpc.getRecordActionOnCommentMethod)
        == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getRecordActionOnCommentMethod =
                GDCHardwareManagementGrpc.getRecordActionOnCommentMethod)
            == null) {
          GDCHardwareManagementGrpc.getRecordActionOnCommentMethod =
              getRecordActionOnCommentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.RecordActionOnCommentRequest,
                          com.google.cloud.gdchardwaremanagement.v1alpha.Comment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RecordActionOnComment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha
                                  .RecordActionOnCommentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.Comment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier(
                              "RecordActionOnComment"))
                      .build();
        }
      }
    }
    return getRecordActionOnCommentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.ListChangeLogEntriesRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.ListChangeLogEntriesResponse>
      getListChangeLogEntriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListChangeLogEntries",
      requestType =
          com.google.cloud.gdchardwaremanagement.v1alpha.ListChangeLogEntriesRequest.class,
      responseType =
          com.google.cloud.gdchardwaremanagement.v1alpha.ListChangeLogEntriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.ListChangeLogEntriesRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.ListChangeLogEntriesResponse>
      getListChangeLogEntriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.ListChangeLogEntriesRequest,
            com.google.cloud.gdchardwaremanagement.v1alpha.ListChangeLogEntriesResponse>
        getListChangeLogEntriesMethod;
    if ((getListChangeLogEntriesMethod = GDCHardwareManagementGrpc.getListChangeLogEntriesMethod)
        == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getListChangeLogEntriesMethod =
                GDCHardwareManagementGrpc.getListChangeLogEntriesMethod)
            == null) {
          GDCHardwareManagementGrpc.getListChangeLogEntriesMethod =
              getListChangeLogEntriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.ListChangeLogEntriesRequest,
                          com.google.cloud.gdchardwaremanagement.v1alpha
                              .ListChangeLogEntriesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListChangeLogEntries"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha
                                  .ListChangeLogEntriesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha
                                  .ListChangeLogEntriesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("ListChangeLogEntries"))
                      .build();
        }
      }
    }
    return getListChangeLogEntriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.GetChangeLogEntryRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.ChangeLogEntry>
      getGetChangeLogEntryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetChangeLogEntry",
      requestType = com.google.cloud.gdchardwaremanagement.v1alpha.GetChangeLogEntryRequest.class,
      responseType = com.google.cloud.gdchardwaremanagement.v1alpha.ChangeLogEntry.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.GetChangeLogEntryRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.ChangeLogEntry>
      getGetChangeLogEntryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.GetChangeLogEntryRequest,
            com.google.cloud.gdchardwaremanagement.v1alpha.ChangeLogEntry>
        getGetChangeLogEntryMethod;
    if ((getGetChangeLogEntryMethod = GDCHardwareManagementGrpc.getGetChangeLogEntryMethod)
        == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getGetChangeLogEntryMethod = GDCHardwareManagementGrpc.getGetChangeLogEntryMethod)
            == null) {
          GDCHardwareManagementGrpc.getGetChangeLogEntryMethod =
              getGetChangeLogEntryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.GetChangeLogEntryRequest,
                          com.google.cloud.gdchardwaremanagement.v1alpha.ChangeLogEntry>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetChangeLogEntry"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha
                                  .GetChangeLogEntryRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.ChangeLogEntry
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("GetChangeLogEntry"))
                      .build();
        }
      }
    }
    return getGetChangeLogEntryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.ListSkusRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.ListSkusResponse>
      getListSkusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSkus",
      requestType = com.google.cloud.gdchardwaremanagement.v1alpha.ListSkusRequest.class,
      responseType = com.google.cloud.gdchardwaremanagement.v1alpha.ListSkusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.ListSkusRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.ListSkusResponse>
      getListSkusMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.ListSkusRequest,
            com.google.cloud.gdchardwaremanagement.v1alpha.ListSkusResponse>
        getListSkusMethod;
    if ((getListSkusMethod = GDCHardwareManagementGrpc.getListSkusMethod) == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getListSkusMethod = GDCHardwareManagementGrpc.getListSkusMethod) == null) {
          GDCHardwareManagementGrpc.getListSkusMethod =
              getListSkusMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.ListSkusRequest,
                          com.google.cloud.gdchardwaremanagement.v1alpha.ListSkusResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSkus"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.ListSkusRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.ListSkusResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("ListSkus"))
                      .build();
        }
      }
    }
    return getListSkusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.GetSkuRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.Sku>
      getGetSkuMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSku",
      requestType = com.google.cloud.gdchardwaremanagement.v1alpha.GetSkuRequest.class,
      responseType = com.google.cloud.gdchardwaremanagement.v1alpha.Sku.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.GetSkuRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.Sku>
      getGetSkuMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.GetSkuRequest,
            com.google.cloud.gdchardwaremanagement.v1alpha.Sku>
        getGetSkuMethod;
    if ((getGetSkuMethod = GDCHardwareManagementGrpc.getGetSkuMethod) == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getGetSkuMethod = GDCHardwareManagementGrpc.getGetSkuMethod) == null) {
          GDCHardwareManagementGrpc.getGetSkuMethod =
              getGetSkuMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.GetSkuRequest,
                          com.google.cloud.gdchardwaremanagement.v1alpha.Sku>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSku"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.GetSkuRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.Sku
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("GetSku"))
                      .build();
        }
      }
    }
    return getGetSkuMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.ListZonesRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.ListZonesResponse>
      getListZonesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListZones",
      requestType = com.google.cloud.gdchardwaremanagement.v1alpha.ListZonesRequest.class,
      responseType = com.google.cloud.gdchardwaremanagement.v1alpha.ListZonesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.ListZonesRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.ListZonesResponse>
      getListZonesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.ListZonesRequest,
            com.google.cloud.gdchardwaremanagement.v1alpha.ListZonesResponse>
        getListZonesMethod;
    if ((getListZonesMethod = GDCHardwareManagementGrpc.getListZonesMethod) == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getListZonesMethod = GDCHardwareManagementGrpc.getListZonesMethod) == null) {
          GDCHardwareManagementGrpc.getListZonesMethod =
              getListZonesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.ListZonesRequest,
                          com.google.cloud.gdchardwaremanagement.v1alpha.ListZonesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListZones"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.ListZonesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.ListZonesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("ListZones"))
                      .build();
        }
      }
    }
    return getListZonesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.GetZoneRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.Zone>
      getGetZoneMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetZone",
      requestType = com.google.cloud.gdchardwaremanagement.v1alpha.GetZoneRequest.class,
      responseType = com.google.cloud.gdchardwaremanagement.v1alpha.Zone.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.GetZoneRequest,
          com.google.cloud.gdchardwaremanagement.v1alpha.Zone>
      getGetZoneMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.GetZoneRequest,
            com.google.cloud.gdchardwaremanagement.v1alpha.Zone>
        getGetZoneMethod;
    if ((getGetZoneMethod = GDCHardwareManagementGrpc.getGetZoneMethod) == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getGetZoneMethod = GDCHardwareManagementGrpc.getGetZoneMethod) == null) {
          GDCHardwareManagementGrpc.getGetZoneMethod =
              getGetZoneMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.GetZoneRequest,
                          com.google.cloud.gdchardwaremanagement.v1alpha.Zone>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetZone"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.GetZoneRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.Zone
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("GetZone"))
                      .build();
        }
      }
    }
    return getGetZoneMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.CreateZoneRequest,
          com.google.longrunning.Operation>
      getCreateZoneMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateZone",
      requestType = com.google.cloud.gdchardwaremanagement.v1alpha.CreateZoneRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.CreateZoneRequest,
          com.google.longrunning.Operation>
      getCreateZoneMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.CreateZoneRequest,
            com.google.longrunning.Operation>
        getCreateZoneMethod;
    if ((getCreateZoneMethod = GDCHardwareManagementGrpc.getCreateZoneMethod) == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getCreateZoneMethod = GDCHardwareManagementGrpc.getCreateZoneMethod) == null) {
          GDCHardwareManagementGrpc.getCreateZoneMethod =
              getCreateZoneMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.CreateZoneRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateZone"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.CreateZoneRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("CreateZone"))
                      .build();
        }
      }
    }
    return getCreateZoneMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.UpdateZoneRequest,
          com.google.longrunning.Operation>
      getUpdateZoneMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateZone",
      requestType = com.google.cloud.gdchardwaremanagement.v1alpha.UpdateZoneRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.UpdateZoneRequest,
          com.google.longrunning.Operation>
      getUpdateZoneMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.UpdateZoneRequest,
            com.google.longrunning.Operation>
        getUpdateZoneMethod;
    if ((getUpdateZoneMethod = GDCHardwareManagementGrpc.getUpdateZoneMethod) == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getUpdateZoneMethod = GDCHardwareManagementGrpc.getUpdateZoneMethod) == null) {
          GDCHardwareManagementGrpc.getUpdateZoneMethod =
              getUpdateZoneMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.UpdateZoneRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateZone"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.UpdateZoneRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("UpdateZone"))
                      .build();
        }
      }
    }
    return getUpdateZoneMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.DeleteZoneRequest,
          com.google.longrunning.Operation>
      getDeleteZoneMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteZone",
      requestType = com.google.cloud.gdchardwaremanagement.v1alpha.DeleteZoneRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.DeleteZoneRequest,
          com.google.longrunning.Operation>
      getDeleteZoneMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.DeleteZoneRequest,
            com.google.longrunning.Operation>
        getDeleteZoneMethod;
    if ((getDeleteZoneMethod = GDCHardwareManagementGrpc.getDeleteZoneMethod) == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getDeleteZoneMethod = GDCHardwareManagementGrpc.getDeleteZoneMethod) == null) {
          GDCHardwareManagementGrpc.getDeleteZoneMethod =
              getDeleteZoneMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.DeleteZoneRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteZone"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.DeleteZoneRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("DeleteZone"))
                      .build();
        }
      }
    }
    return getDeleteZoneMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.SignalZoneStateRequest,
          com.google.longrunning.Operation>
      getSignalZoneStateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SignalZoneState",
      requestType = com.google.cloud.gdchardwaremanagement.v1alpha.SignalZoneStateRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gdchardwaremanagement.v1alpha.SignalZoneStateRequest,
          com.google.longrunning.Operation>
      getSignalZoneStateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gdchardwaremanagement.v1alpha.SignalZoneStateRequest,
            com.google.longrunning.Operation>
        getSignalZoneStateMethod;
    if ((getSignalZoneStateMethod = GDCHardwareManagementGrpc.getSignalZoneStateMethod) == null) {
      synchronized (GDCHardwareManagementGrpc.class) {
        if ((getSignalZoneStateMethod = GDCHardwareManagementGrpc.getSignalZoneStateMethod)
            == null) {
          GDCHardwareManagementGrpc.getSignalZoneStateMethod =
              getSignalZoneStateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gdchardwaremanagement.v1alpha.SignalZoneStateRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SignalZoneState"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gdchardwaremanagement.v1alpha.SignalZoneStateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GDCHardwareManagementMethodDescriptorSupplier("SignalZoneState"))
                      .build();
        }
      }
    }
    return getSignalZoneStateMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static GDCHardwareManagementStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GDCHardwareManagementStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GDCHardwareManagementStub>() {
          @java.lang.Override
          public GDCHardwareManagementStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GDCHardwareManagementStub(channel, callOptions);
          }
        };
    return GDCHardwareManagementStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GDCHardwareManagementBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GDCHardwareManagementBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GDCHardwareManagementBlockingStub>() {
          @java.lang.Override
          public GDCHardwareManagementBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GDCHardwareManagementBlockingStub(channel, callOptions);
          }
        };
    return GDCHardwareManagementBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static GDCHardwareManagementFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GDCHardwareManagementFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GDCHardwareManagementFutureStub>() {
          @java.lang.Override
          public GDCHardwareManagementFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GDCHardwareManagementFutureStub(channel, callOptions);
          }
        };
    return GDCHardwareManagementFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The GDC Hardware Management service.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists orders in a given project and location.
     * </pre>
     */
    default void listOrders(
        com.google.cloud.gdchardwaremanagement.v1alpha.ListOrdersRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gdchardwaremanagement.v1alpha.ListOrdersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListOrdersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of an order.
     * </pre>
     */
    default void getOrder(
        com.google.cloud.gdchardwaremanagement.v1alpha.GetOrderRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gdchardwaremanagement.v1alpha.Order>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetOrderMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new order in a given project and location.
     * </pre>
     */
    default void createOrder(
        com.google.cloud.gdchardwaremanagement.v1alpha.CreateOrderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateOrderMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of an order.
     * </pre>
     */
    default void updateOrder(
        com.google.cloud.gdchardwaremanagement.v1alpha.UpdateOrderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateOrderMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an order.
     * </pre>
     */
    default void deleteOrder(
        com.google.cloud.gdchardwaremanagement.v1alpha.DeleteOrderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteOrderMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Submits an order.
     * </pre>
     */
    default void submitOrder(
        com.google.cloud.gdchardwaremanagement.v1alpha.SubmitOrderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSubmitOrderMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists sites in a given project and location.
     * </pre>
     */
    default void listSites(
        com.google.cloud.gdchardwaremanagement.v1alpha.ListSitesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gdchardwaremanagement.v1alpha.ListSitesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListSitesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a site.
     * </pre>
     */
    default void getSite(
        com.google.cloud.gdchardwaremanagement.v1alpha.GetSiteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gdchardwaremanagement.v1alpha.Site>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSiteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new site in a given project and location.
     * </pre>
     */
    default void createSite(
        com.google.cloud.gdchardwaremanagement.v1alpha.CreateSiteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateSiteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a site.
     * </pre>
     */
    default void updateSite(
        com.google.cloud.gdchardwaremanagement.v1alpha.UpdateSiteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateSiteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a site.
     * </pre>
     */
    default void deleteSite(
        com.google.cloud.gdchardwaremanagement.v1alpha.DeleteSiteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteSiteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists hardware groups in a given order.
     * </pre>
     */
    default void listHardwareGroups(
        com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareGroupsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareGroupsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListHardwareGroupsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a hardware group.
     * </pre>
     */
    default void getHardwareGroup(
        com.google.cloud.gdchardwaremanagement.v1alpha.GetHardwareGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gdchardwaremanagement.v1alpha.HardwareGroup>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetHardwareGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new hardware group in a given order.
     * </pre>
     */
    default void createHardwareGroup(
        com.google.cloud.gdchardwaremanagement.v1alpha.CreateHardwareGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateHardwareGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a hardware group.
     * </pre>
     */
    default void updateHardwareGroup(
        com.google.cloud.gdchardwaremanagement.v1alpha.UpdateHardwareGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateHardwareGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a hardware group.
     * </pre>
     */
    default void deleteHardwareGroup(
        com.google.cloud.gdchardwaremanagement.v1alpha.DeleteHardwareGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteHardwareGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists hardware in a given project and location.
     * </pre>
     */
    default void listHardware(
        com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListHardwareMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets hardware details.
     * </pre>
     */
    default void getHardware(
        com.google.cloud.gdchardwaremanagement.v1alpha.GetHardwareRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gdchardwaremanagement.v1alpha.Hardware>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetHardwareMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates new hardware in a given project and location.
     * </pre>
     */
    default void createHardware(
        com.google.cloud.gdchardwaremanagement.v1alpha.CreateHardwareRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateHardwareMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates hardware parameters.
     * </pre>
     */
    default void updateHardware(
        com.google.cloud.gdchardwaremanagement.v1alpha.UpdateHardwareRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateHardwareMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes hardware.
     * </pre>
     */
    default void deleteHardware(
        com.google.cloud.gdchardwaremanagement.v1alpha.DeleteHardwareRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteHardwareMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the comments on an order.
     * </pre>
     */
    default void listComments(
        com.google.cloud.gdchardwaremanagement.v1alpha.ListCommentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gdchardwaremanagement.v1alpha.ListCommentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCommentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the content of a comment.
     * </pre>
     */
    default void getComment(
        com.google.cloud.gdchardwaremanagement.v1alpha.GetCommentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gdchardwaremanagement.v1alpha.Comment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCommentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new comment on an order.
     * </pre>
     */
    default void createComment(
        com.google.cloud.gdchardwaremanagement.v1alpha.CreateCommentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCommentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Record Action on a Comment. If the Action specified in the request is READ,
     * the viewed time in the comment is set to the time the request was received.
     * If the comment is already marked as read, subsequent calls will be ignored.
     * If the Action is UNREAD, the viewed time is cleared from the comment.
     * </pre>
     */
    default void recordActionOnComment(
        com.google.cloud.gdchardwaremanagement.v1alpha.RecordActionOnCommentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gdchardwaremanagement.v1alpha.Comment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRecordActionOnCommentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the changes made to an order.
     * </pre>
     */
    default void listChangeLogEntries(
        com.google.cloud.gdchardwaremanagement.v1alpha.ListChangeLogEntriesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gdchardwaremanagement.v1alpha.ListChangeLogEntriesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListChangeLogEntriesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a change to an order.
     * </pre>
     */
    default void getChangeLogEntry(
        com.google.cloud.gdchardwaremanagement.v1alpha.GetChangeLogEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gdchardwaremanagement.v1alpha.ChangeLogEntry>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetChangeLogEntryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists SKUs for a given project and location.
     * </pre>
     */
    default void listSkus(
        com.google.cloud.gdchardwaremanagement.v1alpha.ListSkusRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gdchardwaremanagement.v1alpha.ListSkusResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListSkusMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of an SKU.
     * </pre>
     */
    default void getSku(
        com.google.cloud.gdchardwaremanagement.v1alpha.GetSkuRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gdchardwaremanagement.v1alpha.Sku>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSkuMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists zones in a given project and location.
     * </pre>
     */
    default void listZones(
        com.google.cloud.gdchardwaremanagement.v1alpha.ListZonesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gdchardwaremanagement.v1alpha.ListZonesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListZonesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a zone.
     * </pre>
     */
    default void getZone(
        com.google.cloud.gdchardwaremanagement.v1alpha.GetZoneRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gdchardwaremanagement.v1alpha.Zone>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetZoneMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new zone in a given project and location.
     * </pre>
     */
    default void createZone(
        com.google.cloud.gdchardwaremanagement.v1alpha.CreateZoneRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateZoneMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a zone.
     * </pre>
     */
    default void updateZone(
        com.google.cloud.gdchardwaremanagement.v1alpha.UpdateZoneRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateZoneMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a zone.
     * </pre>
     */
    default void deleteZone(
        com.google.cloud.gdchardwaremanagement.v1alpha.DeleteZoneRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteZoneMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Signals the state of a zone.
     * </pre>
     */
    default void signalZoneState(
        com.google.cloud.gdchardwaremanagement.v1alpha.SignalZoneStateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSignalZoneStateMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service GDCHardwareManagement.
   *
   * <pre>
   * The GDC Hardware Management service.
   * </pre>
   */
  public abstract static class GDCHardwareManagementImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return GDCHardwareManagementGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service GDCHardwareManagement.
   *
   * <pre>
   * The GDC Hardware Management service.
   * </pre>
   */
  public static final class GDCHardwareManagementStub
      extends io.grpc.stub.AbstractAsyncStub<GDCHardwareManagementStub> {
    private GDCHardwareManagementStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GDCHardwareManagementStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GDCHardwareManagementStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists orders in a given project and location.
     * </pre>
     */
    public void listOrders(
        com.google.cloud.gdchardwaremanagement.v1alpha.ListOrdersRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gdchardwaremanagement.v1alpha.ListOrdersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListOrdersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of an order.
     * </pre>
     */
    public void getOrder(
        com.google.cloud.gdchardwaremanagement.v1alpha.GetOrderRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gdchardwaremanagement.v1alpha.Order>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOrderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new order in a given project and location.
     * </pre>
     */
    public void createOrder(
        com.google.cloud.gdchardwaremanagement.v1alpha.CreateOrderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateOrderMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of an order.
     * </pre>
     */
    public void updateOrder(
        com.google.cloud.gdchardwaremanagement.v1alpha.UpdateOrderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateOrderMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an order.
     * </pre>
     */
    public void deleteOrder(
        com.google.cloud.gdchardwaremanagement.v1alpha.DeleteOrderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteOrderMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Submits an order.
     * </pre>
     */
    public void submitOrder(
        com.google.cloud.gdchardwaremanagement.v1alpha.SubmitOrderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSubmitOrderMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists sites in a given project and location.
     * </pre>
     */
    public void listSites(
        com.google.cloud.gdchardwaremanagement.v1alpha.ListSitesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gdchardwaremanagement.v1alpha.ListSitesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSitesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a site.
     * </pre>
     */
    public void getSite(
        com.google.cloud.gdchardwaremanagement.v1alpha.GetSiteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gdchardwaremanagement.v1alpha.Site>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSiteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new site in a given project and location.
     * </pre>
     */
    public void createSite(
        com.google.cloud.gdchardwaremanagement.v1alpha.CreateSiteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSiteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a site.
     * </pre>
     */
    public void updateSite(
        com.google.cloud.gdchardwaremanagement.v1alpha.UpdateSiteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSiteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a site.
     * </pre>
     */
    public void deleteSite(
        com.google.cloud.gdchardwaremanagement.v1alpha.DeleteSiteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSiteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists hardware groups in a given order.
     * </pre>
     */
    public void listHardwareGroups(
        com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareGroupsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareGroupsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListHardwareGroupsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a hardware group.
     * </pre>
     */
    public void getHardwareGroup(
        com.google.cloud.gdchardwaremanagement.v1alpha.GetHardwareGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gdchardwaremanagement.v1alpha.HardwareGroup>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetHardwareGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new hardware group in a given order.
     * </pre>
     */
    public void createHardwareGroup(
        com.google.cloud.gdchardwaremanagement.v1alpha.CreateHardwareGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateHardwareGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a hardware group.
     * </pre>
     */
    public void updateHardwareGroup(
        com.google.cloud.gdchardwaremanagement.v1alpha.UpdateHardwareGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateHardwareGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a hardware group.
     * </pre>
     */
    public void deleteHardwareGroup(
        com.google.cloud.gdchardwaremanagement.v1alpha.DeleteHardwareGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteHardwareGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists hardware in a given project and location.
     * </pre>
     */
    public void listHardware(
        com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListHardwareMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets hardware details.
     * </pre>
     */
    public void getHardware(
        com.google.cloud.gdchardwaremanagement.v1alpha.GetHardwareRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gdchardwaremanagement.v1alpha.Hardware>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetHardwareMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates new hardware in a given project and location.
     * </pre>
     */
    public void createHardware(
        com.google.cloud.gdchardwaremanagement.v1alpha.CreateHardwareRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateHardwareMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates hardware parameters.
     * </pre>
     */
    public void updateHardware(
        com.google.cloud.gdchardwaremanagement.v1alpha.UpdateHardwareRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateHardwareMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes hardware.
     * </pre>
     */
    public void deleteHardware(
        com.google.cloud.gdchardwaremanagement.v1alpha.DeleteHardwareRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteHardwareMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the comments on an order.
     * </pre>
     */
    public void listComments(
        com.google.cloud.gdchardwaremanagement.v1alpha.ListCommentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gdchardwaremanagement.v1alpha.ListCommentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCommentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the content of a comment.
     * </pre>
     */
    public void getComment(
        com.google.cloud.gdchardwaremanagement.v1alpha.GetCommentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gdchardwaremanagement.v1alpha.Comment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCommentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new comment on an order.
     * </pre>
     */
    public void createComment(
        com.google.cloud.gdchardwaremanagement.v1alpha.CreateCommentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCommentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Record Action on a Comment. If the Action specified in the request is READ,
     * the viewed time in the comment is set to the time the request was received.
     * If the comment is already marked as read, subsequent calls will be ignored.
     * If the Action is UNREAD, the viewed time is cleared from the comment.
     * </pre>
     */
    public void recordActionOnComment(
        com.google.cloud.gdchardwaremanagement.v1alpha.RecordActionOnCommentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gdchardwaremanagement.v1alpha.Comment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRecordActionOnCommentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the changes made to an order.
     * </pre>
     */
    public void listChangeLogEntries(
        com.google.cloud.gdchardwaremanagement.v1alpha.ListChangeLogEntriesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gdchardwaremanagement.v1alpha.ListChangeLogEntriesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListChangeLogEntriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a change to an order.
     * </pre>
     */
    public void getChangeLogEntry(
        com.google.cloud.gdchardwaremanagement.v1alpha.GetChangeLogEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gdchardwaremanagement.v1alpha.ChangeLogEntry>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetChangeLogEntryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists SKUs for a given project and location.
     * </pre>
     */
    public void listSkus(
        com.google.cloud.gdchardwaremanagement.v1alpha.ListSkusRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gdchardwaremanagement.v1alpha.ListSkusResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSkusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of an SKU.
     * </pre>
     */
    public void getSku(
        com.google.cloud.gdchardwaremanagement.v1alpha.GetSkuRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gdchardwaremanagement.v1alpha.Sku>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSkuMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists zones in a given project and location.
     * </pre>
     */
    public void listZones(
        com.google.cloud.gdchardwaremanagement.v1alpha.ListZonesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gdchardwaremanagement.v1alpha.ListZonesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListZonesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a zone.
     * </pre>
     */
    public void getZone(
        com.google.cloud.gdchardwaremanagement.v1alpha.GetZoneRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gdchardwaremanagement.v1alpha.Zone>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetZoneMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new zone in a given project and location.
     * </pre>
     */
    public void createZone(
        com.google.cloud.gdchardwaremanagement.v1alpha.CreateZoneRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateZoneMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a zone.
     * </pre>
     */
    public void updateZone(
        com.google.cloud.gdchardwaremanagement.v1alpha.UpdateZoneRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateZoneMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a zone.
     * </pre>
     */
    public void deleteZone(
        com.google.cloud.gdchardwaremanagement.v1alpha.DeleteZoneRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteZoneMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Signals the state of a zone.
     * </pre>
     */
    public void signalZoneState(
        com.google.cloud.gdchardwaremanagement.v1alpha.SignalZoneStateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSignalZoneStateMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service GDCHardwareManagement.
   *
   * <pre>
   * The GDC Hardware Management service.
   * </pre>
   */
  public static final class GDCHardwareManagementBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<GDCHardwareManagementBlockingStub> {
    private GDCHardwareManagementBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GDCHardwareManagementBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GDCHardwareManagementBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists orders in a given project and location.
     * </pre>
     */
    public com.google.cloud.gdchardwaremanagement.v1alpha.ListOrdersResponse listOrders(
        com.google.cloud.gdchardwaremanagement.v1alpha.ListOrdersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListOrdersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of an order.
     * </pre>
     */
    public com.google.cloud.gdchardwaremanagement.v1alpha.Order getOrder(
        com.google.cloud.gdchardwaremanagement.v1alpha.GetOrderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOrderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new order in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createOrder(
        com.google.cloud.gdchardwaremanagement.v1alpha.CreateOrderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateOrderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of an order.
     * </pre>
     */
    public com.google.longrunning.Operation updateOrder(
        com.google.cloud.gdchardwaremanagement.v1alpha.UpdateOrderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateOrderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an order.
     * </pre>
     */
    public com.google.longrunning.Operation deleteOrder(
        com.google.cloud.gdchardwaremanagement.v1alpha.DeleteOrderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteOrderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Submits an order.
     * </pre>
     */
    public com.google.longrunning.Operation submitOrder(
        com.google.cloud.gdchardwaremanagement.v1alpha.SubmitOrderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSubmitOrderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists sites in a given project and location.
     * </pre>
     */
    public com.google.cloud.gdchardwaremanagement.v1alpha.ListSitesResponse listSites(
        com.google.cloud.gdchardwaremanagement.v1alpha.ListSitesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSitesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a site.
     * </pre>
     */
    public com.google.cloud.gdchardwaremanagement.v1alpha.Site getSite(
        com.google.cloud.gdchardwaremanagement.v1alpha.GetSiteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSiteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new site in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createSite(
        com.google.cloud.gdchardwaremanagement.v1alpha.CreateSiteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSiteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a site.
     * </pre>
     */
    public com.google.longrunning.Operation updateSite(
        com.google.cloud.gdchardwaremanagement.v1alpha.UpdateSiteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSiteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a site.
     * </pre>
     */
    public com.google.longrunning.Operation deleteSite(
        com.google.cloud.gdchardwaremanagement.v1alpha.DeleteSiteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSiteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists hardware groups in a given order.
     * </pre>
     */
    public com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareGroupsResponse
        listHardwareGroups(
            com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareGroupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListHardwareGroupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a hardware group.
     * </pre>
     */
    public com.google.cloud.gdchardwaremanagement.v1alpha.HardwareGroup getHardwareGroup(
        com.google.cloud.gdchardwaremanagement.v1alpha.GetHardwareGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetHardwareGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new hardware group in a given order.
     * </pre>
     */
    public com.google.longrunning.Operation createHardwareGroup(
        com.google.cloud.gdchardwaremanagement.v1alpha.CreateHardwareGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateHardwareGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a hardware group.
     * </pre>
     */
    public com.google.longrunning.Operation updateHardwareGroup(
        com.google.cloud.gdchardwaremanagement.v1alpha.UpdateHardwareGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateHardwareGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a hardware group.
     * </pre>
     */
    public com.google.longrunning.Operation deleteHardwareGroup(
        com.google.cloud.gdchardwaremanagement.v1alpha.DeleteHardwareGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteHardwareGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists hardware in a given project and location.
     * </pre>
     */
    public com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareResponse listHardware(
        com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListHardwareMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets hardware details.
     * </pre>
     */
    public com.google.cloud.gdchardwaremanagement.v1alpha.Hardware getHardware(
        com.google.cloud.gdchardwaremanagement.v1alpha.GetHardwareRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetHardwareMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates new hardware in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createHardware(
        com.google.cloud.gdchardwaremanagement.v1alpha.CreateHardwareRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateHardwareMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates hardware parameters.
     * </pre>
     */
    public com.google.longrunning.Operation updateHardware(
        com.google.cloud.gdchardwaremanagement.v1alpha.UpdateHardwareRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateHardwareMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes hardware.
     * </pre>
     */
    public com.google.longrunning.Operation deleteHardware(
        com.google.cloud.gdchardwaremanagement.v1alpha.DeleteHardwareRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteHardwareMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the comments on an order.
     * </pre>
     */
    public com.google.cloud.gdchardwaremanagement.v1alpha.ListCommentsResponse listComments(
        com.google.cloud.gdchardwaremanagement.v1alpha.ListCommentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCommentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the content of a comment.
     * </pre>
     */
    public com.google.cloud.gdchardwaremanagement.v1alpha.Comment getComment(
        com.google.cloud.gdchardwaremanagement.v1alpha.GetCommentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCommentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new comment on an order.
     * </pre>
     */
    public com.google.longrunning.Operation createComment(
        com.google.cloud.gdchardwaremanagement.v1alpha.CreateCommentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCommentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Record Action on a Comment. If the Action specified in the request is READ,
     * the viewed time in the comment is set to the time the request was received.
     * If the comment is already marked as read, subsequent calls will be ignored.
     * If the Action is UNREAD, the viewed time is cleared from the comment.
     * </pre>
     */
    public com.google.cloud.gdchardwaremanagement.v1alpha.Comment recordActionOnComment(
        com.google.cloud.gdchardwaremanagement.v1alpha.RecordActionOnCommentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRecordActionOnCommentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the changes made to an order.
     * </pre>
     */
    public com.google.cloud.gdchardwaremanagement.v1alpha.ListChangeLogEntriesResponse
        listChangeLogEntries(
            com.google.cloud.gdchardwaremanagement.v1alpha.ListChangeLogEntriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListChangeLogEntriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a change to an order.
     * </pre>
     */
    public com.google.cloud.gdchardwaremanagement.v1alpha.ChangeLogEntry getChangeLogEntry(
        com.google.cloud.gdchardwaremanagement.v1alpha.GetChangeLogEntryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetChangeLogEntryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists SKUs for a given project and location.
     * </pre>
     */
    public com.google.cloud.gdchardwaremanagement.v1alpha.ListSkusResponse listSkus(
        com.google.cloud.gdchardwaremanagement.v1alpha.ListSkusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSkusMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of an SKU.
     * </pre>
     */
    public com.google.cloud.gdchardwaremanagement.v1alpha.Sku getSku(
        com.google.cloud.gdchardwaremanagement.v1alpha.GetSkuRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSkuMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists zones in a given project and location.
     * </pre>
     */
    public com.google.cloud.gdchardwaremanagement.v1alpha.ListZonesResponse listZones(
        com.google.cloud.gdchardwaremanagement.v1alpha.ListZonesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListZonesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a zone.
     * </pre>
     */
    public com.google.cloud.gdchardwaremanagement.v1alpha.Zone getZone(
        com.google.cloud.gdchardwaremanagement.v1alpha.GetZoneRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetZoneMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new zone in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createZone(
        com.google.cloud.gdchardwaremanagement.v1alpha.CreateZoneRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateZoneMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a zone.
     * </pre>
     */
    public com.google.longrunning.Operation updateZone(
        com.google.cloud.gdchardwaremanagement.v1alpha.UpdateZoneRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateZoneMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a zone.
     * </pre>
     */
    public com.google.longrunning.Operation deleteZone(
        com.google.cloud.gdchardwaremanagement.v1alpha.DeleteZoneRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteZoneMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Signals the state of a zone.
     * </pre>
     */
    public com.google.longrunning.Operation signalZoneState(
        com.google.cloud.gdchardwaremanagement.v1alpha.SignalZoneStateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSignalZoneStateMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * GDCHardwareManagement.
   *
   * <pre>
   * The GDC Hardware Management service.
   * </pre>
   */
  public static final class GDCHardwareManagementFutureStub
      extends io.grpc.stub.AbstractFutureStub<GDCHardwareManagementFutureStub> {
    private GDCHardwareManagementFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GDCHardwareManagementFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GDCHardwareManagementFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists orders in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gdchardwaremanagement.v1alpha.ListOrdersResponse>
        listOrders(com.google.cloud.gdchardwaremanagement.v1alpha.ListOrdersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListOrdersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of an order.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gdchardwaremanagement.v1alpha.Order>
        getOrder(com.google.cloud.gdchardwaremanagement.v1alpha.GetOrderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOrderMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new order in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createOrder(com.google.cloud.gdchardwaremanagement.v1alpha.CreateOrderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateOrderMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of an order.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateOrder(com.google.cloud.gdchardwaremanagement.v1alpha.UpdateOrderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateOrderMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an order.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteOrder(com.google.cloud.gdchardwaremanagement.v1alpha.DeleteOrderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteOrderMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Submits an order.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        submitOrder(com.google.cloud.gdchardwaremanagement.v1alpha.SubmitOrderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSubmitOrderMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists sites in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gdchardwaremanagement.v1alpha.ListSitesResponse>
        listSites(com.google.cloud.gdchardwaremanagement.v1alpha.ListSitesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSitesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a site.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gdchardwaremanagement.v1alpha.Site>
        getSite(com.google.cloud.gdchardwaremanagement.v1alpha.GetSiteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSiteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new site in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createSite(com.google.cloud.gdchardwaremanagement.v1alpha.CreateSiteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSiteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a site.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateSite(com.google.cloud.gdchardwaremanagement.v1alpha.UpdateSiteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSiteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a site.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteSite(com.google.cloud.gdchardwaremanagement.v1alpha.DeleteSiteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSiteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists hardware groups in a given order.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareGroupsResponse>
        listHardwareGroups(
            com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareGroupsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListHardwareGroupsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a hardware group.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gdchardwaremanagement.v1alpha.HardwareGroup>
        getHardwareGroup(
            com.google.cloud.gdchardwaremanagement.v1alpha.GetHardwareGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetHardwareGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new hardware group in a given order.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createHardwareGroup(
            com.google.cloud.gdchardwaremanagement.v1alpha.CreateHardwareGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateHardwareGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a hardware group.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateHardwareGroup(
            com.google.cloud.gdchardwaremanagement.v1alpha.UpdateHardwareGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateHardwareGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a hardware group.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteHardwareGroup(
            com.google.cloud.gdchardwaremanagement.v1alpha.DeleteHardwareGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteHardwareGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists hardware in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareResponse>
        listHardware(com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListHardwareMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets hardware details.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gdchardwaremanagement.v1alpha.Hardware>
        getHardware(com.google.cloud.gdchardwaremanagement.v1alpha.GetHardwareRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetHardwareMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates new hardware in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createHardware(
            com.google.cloud.gdchardwaremanagement.v1alpha.CreateHardwareRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateHardwareMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates hardware parameters.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateHardware(
            com.google.cloud.gdchardwaremanagement.v1alpha.UpdateHardwareRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateHardwareMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes hardware.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteHardware(
            com.google.cloud.gdchardwaremanagement.v1alpha.DeleteHardwareRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteHardwareMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the comments on an order.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gdchardwaremanagement.v1alpha.ListCommentsResponse>
        listComments(com.google.cloud.gdchardwaremanagement.v1alpha.ListCommentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCommentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the content of a comment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gdchardwaremanagement.v1alpha.Comment>
        getComment(com.google.cloud.gdchardwaremanagement.v1alpha.GetCommentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCommentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new comment on an order.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createComment(com.google.cloud.gdchardwaremanagement.v1alpha.CreateCommentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCommentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Record Action on a Comment. If the Action specified in the request is READ,
     * the viewed time in the comment is set to the time the request was received.
     * If the comment is already marked as read, subsequent calls will be ignored.
     * If the Action is UNREAD, the viewed time is cleared from the comment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gdchardwaremanagement.v1alpha.Comment>
        recordActionOnComment(
            com.google.cloud.gdchardwaremanagement.v1alpha.RecordActionOnCommentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRecordActionOnCommentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the changes made to an order.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gdchardwaremanagement.v1alpha.ListChangeLogEntriesResponse>
        listChangeLogEntries(
            com.google.cloud.gdchardwaremanagement.v1alpha.ListChangeLogEntriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListChangeLogEntriesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a change to an order.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gdchardwaremanagement.v1alpha.ChangeLogEntry>
        getChangeLogEntry(
            com.google.cloud.gdchardwaremanagement.v1alpha.GetChangeLogEntryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetChangeLogEntryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists SKUs for a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gdchardwaremanagement.v1alpha.ListSkusResponse>
        listSkus(com.google.cloud.gdchardwaremanagement.v1alpha.ListSkusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSkusMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of an SKU.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gdchardwaremanagement.v1alpha.Sku>
        getSku(com.google.cloud.gdchardwaremanagement.v1alpha.GetSkuRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSkuMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists zones in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gdchardwaremanagement.v1alpha.ListZonesResponse>
        listZones(com.google.cloud.gdchardwaremanagement.v1alpha.ListZonesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListZonesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a zone.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gdchardwaremanagement.v1alpha.Zone>
        getZone(com.google.cloud.gdchardwaremanagement.v1alpha.GetZoneRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetZoneMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new zone in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createZone(com.google.cloud.gdchardwaremanagement.v1alpha.CreateZoneRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateZoneMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a zone.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateZone(com.google.cloud.gdchardwaremanagement.v1alpha.UpdateZoneRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateZoneMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a zone.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteZone(com.google.cloud.gdchardwaremanagement.v1alpha.DeleteZoneRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteZoneMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Signals the state of a zone.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        signalZoneState(
            com.google.cloud.gdchardwaremanagement.v1alpha.SignalZoneStateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSignalZoneStateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_ORDERS = 0;
  private static final int METHODID_GET_ORDER = 1;
  private static final int METHODID_CREATE_ORDER = 2;
  private static final int METHODID_UPDATE_ORDER = 3;
  private static final int METHODID_DELETE_ORDER = 4;
  private static final int METHODID_SUBMIT_ORDER = 5;
  private static final int METHODID_LIST_SITES = 6;
  private static final int METHODID_GET_SITE = 7;
  private static final int METHODID_CREATE_SITE = 8;
  private static final int METHODID_UPDATE_SITE = 9;
  private static final int METHODID_DELETE_SITE = 10;
  private static final int METHODID_LIST_HARDWARE_GROUPS = 11;
  private static final int METHODID_GET_HARDWARE_GROUP = 12;
  private static final int METHODID_CREATE_HARDWARE_GROUP = 13;
  private static final int METHODID_UPDATE_HARDWARE_GROUP = 14;
  private static final int METHODID_DELETE_HARDWARE_GROUP = 15;
  private static final int METHODID_LIST_HARDWARE = 16;
  private static final int METHODID_GET_HARDWARE = 17;
  private static final int METHODID_CREATE_HARDWARE = 18;
  private static final int METHODID_UPDATE_HARDWARE = 19;
  private static final int METHODID_DELETE_HARDWARE = 20;
  private static final int METHODID_LIST_COMMENTS = 21;
  private static final int METHODID_GET_COMMENT = 22;
  private static final int METHODID_CREATE_COMMENT = 23;
  private static final int METHODID_RECORD_ACTION_ON_COMMENT = 24;
  private static final int METHODID_LIST_CHANGE_LOG_ENTRIES = 25;
  private static final int METHODID_GET_CHANGE_LOG_ENTRY = 26;
  private static final int METHODID_LIST_SKUS = 27;
  private static final int METHODID_GET_SKU = 28;
  private static final int METHODID_LIST_ZONES = 29;
  private static final int METHODID_GET_ZONE = 30;
  private static final int METHODID_CREATE_ZONE = 31;
  private static final int METHODID_UPDATE_ZONE = 32;
  private static final int METHODID_DELETE_ZONE = 33;
  private static final int METHODID_SIGNAL_ZONE_STATE = 34;

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
        case METHODID_LIST_ORDERS:
          serviceImpl.listOrders(
              (com.google.cloud.gdchardwaremanagement.v1alpha.ListOrdersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gdchardwaremanagement.v1alpha.ListOrdersResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ORDER:
          serviceImpl.getOrder(
              (com.google.cloud.gdchardwaremanagement.v1alpha.GetOrderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gdchardwaremanagement.v1alpha.Order>)
                  responseObserver);
          break;
        case METHODID_CREATE_ORDER:
          serviceImpl.createOrder(
              (com.google.cloud.gdchardwaremanagement.v1alpha.CreateOrderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_ORDER:
          serviceImpl.updateOrder(
              (com.google.cloud.gdchardwaremanagement.v1alpha.UpdateOrderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ORDER:
          serviceImpl.deleteOrder(
              (com.google.cloud.gdchardwaremanagement.v1alpha.DeleteOrderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_SUBMIT_ORDER:
          serviceImpl.submitOrder(
              (com.google.cloud.gdchardwaremanagement.v1alpha.SubmitOrderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_SITES:
          serviceImpl.listSites(
              (com.google.cloud.gdchardwaremanagement.v1alpha.ListSitesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gdchardwaremanagement.v1alpha.ListSitesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SITE:
          serviceImpl.getSite(
              (com.google.cloud.gdchardwaremanagement.v1alpha.GetSiteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gdchardwaremanagement.v1alpha.Site>)
                  responseObserver);
          break;
        case METHODID_CREATE_SITE:
          serviceImpl.createSite(
              (com.google.cloud.gdchardwaremanagement.v1alpha.CreateSiteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_SITE:
          serviceImpl.updateSite(
              (com.google.cloud.gdchardwaremanagement.v1alpha.UpdateSiteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SITE:
          serviceImpl.deleteSite(
              (com.google.cloud.gdchardwaremanagement.v1alpha.DeleteSiteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_HARDWARE_GROUPS:
          serviceImpl.listHardwareGroups(
              (com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareGroupsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareGroupsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_HARDWARE_GROUP:
          serviceImpl.getHardwareGroup(
              (com.google.cloud.gdchardwaremanagement.v1alpha.GetHardwareGroupRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gdchardwaremanagement.v1alpha.HardwareGroup>)
                  responseObserver);
          break;
        case METHODID_CREATE_HARDWARE_GROUP:
          serviceImpl.createHardwareGroup(
              (com.google.cloud.gdchardwaremanagement.v1alpha.CreateHardwareGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_HARDWARE_GROUP:
          serviceImpl.updateHardwareGroup(
              (com.google.cloud.gdchardwaremanagement.v1alpha.UpdateHardwareGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_HARDWARE_GROUP:
          serviceImpl.deleteHardwareGroup(
              (com.google.cloud.gdchardwaremanagement.v1alpha.DeleteHardwareGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_HARDWARE:
          serviceImpl.listHardware(
              (com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareResponse>)
                  responseObserver);
          break;
        case METHODID_GET_HARDWARE:
          serviceImpl.getHardware(
              (com.google.cloud.gdchardwaremanagement.v1alpha.GetHardwareRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gdchardwaremanagement.v1alpha.Hardware>)
                  responseObserver);
          break;
        case METHODID_CREATE_HARDWARE:
          serviceImpl.createHardware(
              (com.google.cloud.gdchardwaremanagement.v1alpha.CreateHardwareRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_HARDWARE:
          serviceImpl.updateHardware(
              (com.google.cloud.gdchardwaremanagement.v1alpha.UpdateHardwareRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_HARDWARE:
          serviceImpl.deleteHardware(
              (com.google.cloud.gdchardwaremanagement.v1alpha.DeleteHardwareRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_COMMENTS:
          serviceImpl.listComments(
              (com.google.cloud.gdchardwaremanagement.v1alpha.ListCommentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gdchardwaremanagement.v1alpha.ListCommentsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_COMMENT:
          serviceImpl.getComment(
              (com.google.cloud.gdchardwaremanagement.v1alpha.GetCommentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gdchardwaremanagement.v1alpha.Comment>)
                  responseObserver);
          break;
        case METHODID_CREATE_COMMENT:
          serviceImpl.createComment(
              (com.google.cloud.gdchardwaremanagement.v1alpha.CreateCommentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RECORD_ACTION_ON_COMMENT:
          serviceImpl.recordActionOnComment(
              (com.google.cloud.gdchardwaremanagement.v1alpha.RecordActionOnCommentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gdchardwaremanagement.v1alpha.Comment>)
                  responseObserver);
          break;
        case METHODID_LIST_CHANGE_LOG_ENTRIES:
          serviceImpl.listChangeLogEntries(
              (com.google.cloud.gdchardwaremanagement.v1alpha.ListChangeLogEntriesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gdchardwaremanagement.v1alpha.ListChangeLogEntriesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CHANGE_LOG_ENTRY:
          serviceImpl.getChangeLogEntry(
              (com.google.cloud.gdchardwaremanagement.v1alpha.GetChangeLogEntryRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gdchardwaremanagement.v1alpha.ChangeLogEntry>)
                  responseObserver);
          break;
        case METHODID_LIST_SKUS:
          serviceImpl.listSkus(
              (com.google.cloud.gdchardwaremanagement.v1alpha.ListSkusRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gdchardwaremanagement.v1alpha.ListSkusResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SKU:
          serviceImpl.getSku(
              (com.google.cloud.gdchardwaremanagement.v1alpha.GetSkuRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gdchardwaremanagement.v1alpha.Sku>)
                  responseObserver);
          break;
        case METHODID_LIST_ZONES:
          serviceImpl.listZones(
              (com.google.cloud.gdchardwaremanagement.v1alpha.ListZonesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gdchardwaremanagement.v1alpha.ListZonesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ZONE:
          serviceImpl.getZone(
              (com.google.cloud.gdchardwaremanagement.v1alpha.GetZoneRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gdchardwaremanagement.v1alpha.Zone>)
                  responseObserver);
          break;
        case METHODID_CREATE_ZONE:
          serviceImpl.createZone(
              (com.google.cloud.gdchardwaremanagement.v1alpha.CreateZoneRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_ZONE:
          serviceImpl.updateZone(
              (com.google.cloud.gdchardwaremanagement.v1alpha.UpdateZoneRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ZONE:
          serviceImpl.deleteZone(
              (com.google.cloud.gdchardwaremanagement.v1alpha.DeleteZoneRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_SIGNAL_ZONE_STATE:
          serviceImpl.signalZoneState(
              (com.google.cloud.gdchardwaremanagement.v1alpha.SignalZoneStateRequest) request,
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
            getListOrdersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.ListOrdersRequest,
                    com.google.cloud.gdchardwaremanagement.v1alpha.ListOrdersResponse>(
                    service, METHODID_LIST_ORDERS)))
        .addMethod(
            getGetOrderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.GetOrderRequest,
                    com.google.cloud.gdchardwaremanagement.v1alpha.Order>(
                    service, METHODID_GET_ORDER)))
        .addMethod(
            getCreateOrderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.CreateOrderRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_ORDER)))
        .addMethod(
            getUpdateOrderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.UpdateOrderRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_ORDER)))
        .addMethod(
            getDeleteOrderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.DeleteOrderRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_ORDER)))
        .addMethod(
            getSubmitOrderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.SubmitOrderRequest,
                    com.google.longrunning.Operation>(service, METHODID_SUBMIT_ORDER)))
        .addMethod(
            getListSitesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.ListSitesRequest,
                    com.google.cloud.gdchardwaremanagement.v1alpha.ListSitesResponse>(
                    service, METHODID_LIST_SITES)))
        .addMethod(
            getGetSiteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.GetSiteRequest,
                    com.google.cloud.gdchardwaremanagement.v1alpha.Site>(
                    service, METHODID_GET_SITE)))
        .addMethod(
            getCreateSiteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.CreateSiteRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_SITE)))
        .addMethod(
            getUpdateSiteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.UpdateSiteRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_SITE)))
        .addMethod(
            getDeleteSiteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.DeleteSiteRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_SITE)))
        .addMethod(
            getListHardwareGroupsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareGroupsRequest,
                    com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareGroupsResponse>(
                    service, METHODID_LIST_HARDWARE_GROUPS)))
        .addMethod(
            getGetHardwareGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.GetHardwareGroupRequest,
                    com.google.cloud.gdchardwaremanagement.v1alpha.HardwareGroup>(
                    service, METHODID_GET_HARDWARE_GROUP)))
        .addMethod(
            getCreateHardwareGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.CreateHardwareGroupRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_HARDWARE_GROUP)))
        .addMethod(
            getUpdateHardwareGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.UpdateHardwareGroupRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_HARDWARE_GROUP)))
        .addMethod(
            getDeleteHardwareGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.DeleteHardwareGroupRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_HARDWARE_GROUP)))
        .addMethod(
            getListHardwareMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareRequest,
                    com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareResponse>(
                    service, METHODID_LIST_HARDWARE)))
        .addMethod(
            getGetHardwareMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.GetHardwareRequest,
                    com.google.cloud.gdchardwaremanagement.v1alpha.Hardware>(
                    service, METHODID_GET_HARDWARE)))
        .addMethod(
            getCreateHardwareMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.CreateHardwareRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_HARDWARE)))
        .addMethod(
            getUpdateHardwareMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.UpdateHardwareRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_HARDWARE)))
        .addMethod(
            getDeleteHardwareMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.DeleteHardwareRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_HARDWARE)))
        .addMethod(
            getListCommentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.ListCommentsRequest,
                    com.google.cloud.gdchardwaremanagement.v1alpha.ListCommentsResponse>(
                    service, METHODID_LIST_COMMENTS)))
        .addMethod(
            getGetCommentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.GetCommentRequest,
                    com.google.cloud.gdchardwaremanagement.v1alpha.Comment>(
                    service, METHODID_GET_COMMENT)))
        .addMethod(
            getCreateCommentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.CreateCommentRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_COMMENT)))
        .addMethod(
            getRecordActionOnCommentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.RecordActionOnCommentRequest,
                    com.google.cloud.gdchardwaremanagement.v1alpha.Comment>(
                    service, METHODID_RECORD_ACTION_ON_COMMENT)))
        .addMethod(
            getListChangeLogEntriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.ListChangeLogEntriesRequest,
                    com.google.cloud.gdchardwaremanagement.v1alpha.ListChangeLogEntriesResponse>(
                    service, METHODID_LIST_CHANGE_LOG_ENTRIES)))
        .addMethod(
            getGetChangeLogEntryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.GetChangeLogEntryRequest,
                    com.google.cloud.gdchardwaremanagement.v1alpha.ChangeLogEntry>(
                    service, METHODID_GET_CHANGE_LOG_ENTRY)))
        .addMethod(
            getListSkusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.ListSkusRequest,
                    com.google.cloud.gdchardwaremanagement.v1alpha.ListSkusResponse>(
                    service, METHODID_LIST_SKUS)))
        .addMethod(
            getGetSkuMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.GetSkuRequest,
                    com.google.cloud.gdchardwaremanagement.v1alpha.Sku>(service, METHODID_GET_SKU)))
        .addMethod(
            getListZonesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.ListZonesRequest,
                    com.google.cloud.gdchardwaremanagement.v1alpha.ListZonesResponse>(
                    service, METHODID_LIST_ZONES)))
        .addMethod(
            getGetZoneMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.GetZoneRequest,
                    com.google.cloud.gdchardwaremanagement.v1alpha.Zone>(
                    service, METHODID_GET_ZONE)))
        .addMethod(
            getCreateZoneMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.CreateZoneRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_ZONE)))
        .addMethod(
            getUpdateZoneMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.UpdateZoneRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_ZONE)))
        .addMethod(
            getDeleteZoneMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.DeleteZoneRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_ZONE)))
        .addMethod(
            getSignalZoneStateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gdchardwaremanagement.v1alpha.SignalZoneStateRequest,
                    com.google.longrunning.Operation>(service, METHODID_SIGNAL_ZONE_STATE)))
        .build();
  }

  private abstract static class GDCHardwareManagementBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GDCHardwareManagementBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.gdchardwaremanagement.v1alpha.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GDCHardwareManagement");
    }
  }

  private static final class GDCHardwareManagementFileDescriptorSupplier
      extends GDCHardwareManagementBaseDescriptorSupplier {
    GDCHardwareManagementFileDescriptorSupplier() {}
  }

  private static final class GDCHardwareManagementMethodDescriptorSupplier
      extends GDCHardwareManagementBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    GDCHardwareManagementMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (GDCHardwareManagementGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new GDCHardwareManagementFileDescriptorSupplier())
                      .addMethod(getListOrdersMethod())
                      .addMethod(getGetOrderMethod())
                      .addMethod(getCreateOrderMethod())
                      .addMethod(getUpdateOrderMethod())
                      .addMethod(getDeleteOrderMethod())
                      .addMethod(getSubmitOrderMethod())
                      .addMethod(getListSitesMethod())
                      .addMethod(getGetSiteMethod())
                      .addMethod(getCreateSiteMethod())
                      .addMethod(getUpdateSiteMethod())
                      .addMethod(getDeleteSiteMethod())
                      .addMethod(getListHardwareGroupsMethod())
                      .addMethod(getGetHardwareGroupMethod())
                      .addMethod(getCreateHardwareGroupMethod())
                      .addMethod(getUpdateHardwareGroupMethod())
                      .addMethod(getDeleteHardwareGroupMethod())
                      .addMethod(getListHardwareMethod())
                      .addMethod(getGetHardwareMethod())
                      .addMethod(getCreateHardwareMethod())
                      .addMethod(getUpdateHardwareMethod())
                      .addMethod(getDeleteHardwareMethod())
                      .addMethod(getListCommentsMethod())
                      .addMethod(getGetCommentMethod())
                      .addMethod(getCreateCommentMethod())
                      .addMethod(getRecordActionOnCommentMethod())
                      .addMethod(getListChangeLogEntriesMethod())
                      .addMethod(getGetChangeLogEntryMethod())
                      .addMethod(getListSkusMethod())
                      .addMethod(getGetSkuMethod())
                      .addMethod(getListZonesMethod())
                      .addMethod(getGetZoneMethod())
                      .addMethod(getCreateZoneMethod())
                      .addMethod(getUpdateZoneMethod())
                      .addMethod(getDeleteZoneMethod())
                      .addMethod(getSignalZoneStateMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
