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
package com.google.analytics.admin.v1alpha;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service Interface for the Analytics Admin API (GA4).
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/analytics/admin/v1alpha/analytics_admin.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AnalyticsAdminServiceGrpc {

  private AnalyticsAdminServiceGrpc() {}

  public static final String SERVICE_NAME = "google.analytics.admin.v1alpha.AnalyticsAdminService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetAccountRequest,
          com.google.analytics.admin.v1alpha.Account>
      getGetAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccount",
      requestType = com.google.analytics.admin.v1alpha.GetAccountRequest.class,
      responseType = com.google.analytics.admin.v1alpha.Account.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetAccountRequest,
          com.google.analytics.admin.v1alpha.Account>
      getGetAccountMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetAccountRequest,
            com.google.analytics.admin.v1alpha.Account>
        getGetAccountMethod;
    if ((getGetAccountMethod = AnalyticsAdminServiceGrpc.getGetAccountMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetAccountMethod = AnalyticsAdminServiceGrpc.getGetAccountMethod) == null) {
          AnalyticsAdminServiceGrpc.getGetAccountMethod =
              getGetAccountMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetAccountRequest,
                          com.google.analytics.admin.v1alpha.Account>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAccount"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GetAccountRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.Account.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("GetAccount"))
                      .build();
        }
      }
    }
    return getGetAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListAccountsRequest,
          com.google.analytics.admin.v1alpha.ListAccountsResponse>
      getListAccountsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAccounts",
      requestType = com.google.analytics.admin.v1alpha.ListAccountsRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ListAccountsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListAccountsRequest,
          com.google.analytics.admin.v1alpha.ListAccountsResponse>
      getListAccountsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListAccountsRequest,
            com.google.analytics.admin.v1alpha.ListAccountsResponse>
        getListAccountsMethod;
    if ((getListAccountsMethod = AnalyticsAdminServiceGrpc.getListAccountsMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListAccountsMethod = AnalyticsAdminServiceGrpc.getListAccountsMethod) == null) {
          AnalyticsAdminServiceGrpc.getListAccountsMethod =
              getListAccountsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ListAccountsRequest,
                          com.google.analytics.admin.v1alpha.ListAccountsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAccounts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListAccountsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListAccountsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("ListAccounts"))
                      .build();
        }
      }
    }
    return getListAccountsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteAccountRequest, com.google.protobuf.Empty>
      getDeleteAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAccount",
      requestType = com.google.analytics.admin.v1alpha.DeleteAccountRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteAccountRequest, com.google.protobuf.Empty>
      getDeleteAccountMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.DeleteAccountRequest, com.google.protobuf.Empty>
        getDeleteAccountMethod;
    if ((getDeleteAccountMethod = AnalyticsAdminServiceGrpc.getDeleteAccountMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeleteAccountMethod = AnalyticsAdminServiceGrpc.getDeleteAccountMethod) == null) {
          AnalyticsAdminServiceGrpc.getDeleteAccountMethod =
              getDeleteAccountMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.DeleteAccountRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAccount"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DeleteAccountRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("DeleteAccount"))
                      .build();
        }
      }
    }
    return getDeleteAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateAccountRequest,
          com.google.analytics.admin.v1alpha.Account>
      getUpdateAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAccount",
      requestType = com.google.analytics.admin.v1alpha.UpdateAccountRequest.class,
      responseType = com.google.analytics.admin.v1alpha.Account.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateAccountRequest,
          com.google.analytics.admin.v1alpha.Account>
      getUpdateAccountMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.UpdateAccountRequest,
            com.google.analytics.admin.v1alpha.Account>
        getUpdateAccountMethod;
    if ((getUpdateAccountMethod = AnalyticsAdminServiceGrpc.getUpdateAccountMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateAccountMethod = AnalyticsAdminServiceGrpc.getUpdateAccountMethod) == null) {
          AnalyticsAdminServiceGrpc.getUpdateAccountMethod =
              getUpdateAccountMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.UpdateAccountRequest,
                          com.google.analytics.admin.v1alpha.Account>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAccount"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UpdateAccountRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.Account.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("UpdateAccount"))
                      .build();
        }
      }
    }
    return getUpdateAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ProvisionAccountTicketRequest,
          com.google.analytics.admin.v1alpha.ProvisionAccountTicketResponse>
      getProvisionAccountTicketMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProvisionAccountTicket",
      requestType = com.google.analytics.admin.v1alpha.ProvisionAccountTicketRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ProvisionAccountTicketResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ProvisionAccountTicketRequest,
          com.google.analytics.admin.v1alpha.ProvisionAccountTicketResponse>
      getProvisionAccountTicketMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ProvisionAccountTicketRequest,
            com.google.analytics.admin.v1alpha.ProvisionAccountTicketResponse>
        getProvisionAccountTicketMethod;
    if ((getProvisionAccountTicketMethod =
            AnalyticsAdminServiceGrpc.getProvisionAccountTicketMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getProvisionAccountTicketMethod =
                AnalyticsAdminServiceGrpc.getProvisionAccountTicketMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getProvisionAccountTicketMethod =
              getProvisionAccountTicketMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ProvisionAccountTicketRequest,
                          com.google.analytics.admin.v1alpha.ProvisionAccountTicketResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ProvisionAccountTicket"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ProvisionAccountTicketRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ProvisionAccountTicketResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "ProvisionAccountTicket"))
                      .build();
        }
      }
    }
    return getProvisionAccountTicketMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListAccountSummariesRequest,
          com.google.analytics.admin.v1alpha.ListAccountSummariesResponse>
      getListAccountSummariesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAccountSummaries",
      requestType = com.google.analytics.admin.v1alpha.ListAccountSummariesRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ListAccountSummariesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListAccountSummariesRequest,
          com.google.analytics.admin.v1alpha.ListAccountSummariesResponse>
      getListAccountSummariesMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListAccountSummariesRequest,
            com.google.analytics.admin.v1alpha.ListAccountSummariesResponse>
        getListAccountSummariesMethod;
    if ((getListAccountSummariesMethod = AnalyticsAdminServiceGrpc.getListAccountSummariesMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListAccountSummariesMethod =
                AnalyticsAdminServiceGrpc.getListAccountSummariesMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getListAccountSummariesMethod =
              getListAccountSummariesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ListAccountSummariesRequest,
                          com.google.analytics.admin.v1alpha.ListAccountSummariesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAccountSummaries"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListAccountSummariesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListAccountSummariesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("ListAccountSummaries"))
                      .build();
        }
      }
    }
    return getListAccountSummariesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetPropertyRequest,
          com.google.analytics.admin.v1alpha.Property>
      getGetPropertyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProperty",
      requestType = com.google.analytics.admin.v1alpha.GetPropertyRequest.class,
      responseType = com.google.analytics.admin.v1alpha.Property.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetPropertyRequest,
          com.google.analytics.admin.v1alpha.Property>
      getGetPropertyMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetPropertyRequest,
            com.google.analytics.admin.v1alpha.Property>
        getGetPropertyMethod;
    if ((getGetPropertyMethod = AnalyticsAdminServiceGrpc.getGetPropertyMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetPropertyMethod = AnalyticsAdminServiceGrpc.getGetPropertyMethod) == null) {
          AnalyticsAdminServiceGrpc.getGetPropertyMethod =
              getGetPropertyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetPropertyRequest,
                          com.google.analytics.admin.v1alpha.Property>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProperty"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GetPropertyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.Property.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("GetProperty"))
                      .build();
        }
      }
    }
    return getGetPropertyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListPropertiesRequest,
          com.google.analytics.admin.v1alpha.ListPropertiesResponse>
      getListPropertiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListProperties",
      requestType = com.google.analytics.admin.v1alpha.ListPropertiesRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ListPropertiesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListPropertiesRequest,
          com.google.analytics.admin.v1alpha.ListPropertiesResponse>
      getListPropertiesMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListPropertiesRequest,
            com.google.analytics.admin.v1alpha.ListPropertiesResponse>
        getListPropertiesMethod;
    if ((getListPropertiesMethod = AnalyticsAdminServiceGrpc.getListPropertiesMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListPropertiesMethod = AnalyticsAdminServiceGrpc.getListPropertiesMethod) == null) {
          AnalyticsAdminServiceGrpc.getListPropertiesMethod =
              getListPropertiesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ListPropertiesRequest,
                          com.google.analytics.admin.v1alpha.ListPropertiesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListProperties"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListPropertiesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListPropertiesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("ListProperties"))
                      .build();
        }
      }
    }
    return getListPropertiesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreatePropertyRequest,
          com.google.analytics.admin.v1alpha.Property>
      getCreatePropertyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateProperty",
      requestType = com.google.analytics.admin.v1alpha.CreatePropertyRequest.class,
      responseType = com.google.analytics.admin.v1alpha.Property.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreatePropertyRequest,
          com.google.analytics.admin.v1alpha.Property>
      getCreatePropertyMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.CreatePropertyRequest,
            com.google.analytics.admin.v1alpha.Property>
        getCreatePropertyMethod;
    if ((getCreatePropertyMethod = AnalyticsAdminServiceGrpc.getCreatePropertyMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreatePropertyMethod = AnalyticsAdminServiceGrpc.getCreatePropertyMethod) == null) {
          AnalyticsAdminServiceGrpc.getCreatePropertyMethod =
              getCreatePropertyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.CreatePropertyRequest,
                          com.google.analytics.admin.v1alpha.Property>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateProperty"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CreatePropertyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.Property.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("CreateProperty"))
                      .build();
        }
      }
    }
    return getCreatePropertyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeletePropertyRequest,
          com.google.analytics.admin.v1alpha.Property>
      getDeletePropertyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteProperty",
      requestType = com.google.analytics.admin.v1alpha.DeletePropertyRequest.class,
      responseType = com.google.analytics.admin.v1alpha.Property.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeletePropertyRequest,
          com.google.analytics.admin.v1alpha.Property>
      getDeletePropertyMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.DeletePropertyRequest,
            com.google.analytics.admin.v1alpha.Property>
        getDeletePropertyMethod;
    if ((getDeletePropertyMethod = AnalyticsAdminServiceGrpc.getDeletePropertyMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeletePropertyMethod = AnalyticsAdminServiceGrpc.getDeletePropertyMethod) == null) {
          AnalyticsAdminServiceGrpc.getDeletePropertyMethod =
              getDeletePropertyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.DeletePropertyRequest,
                          com.google.analytics.admin.v1alpha.Property>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteProperty"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DeletePropertyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.Property.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("DeleteProperty"))
                      .build();
        }
      }
    }
    return getDeletePropertyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdatePropertyRequest,
          com.google.analytics.admin.v1alpha.Property>
      getUpdatePropertyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateProperty",
      requestType = com.google.analytics.admin.v1alpha.UpdatePropertyRequest.class,
      responseType = com.google.analytics.admin.v1alpha.Property.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdatePropertyRequest,
          com.google.analytics.admin.v1alpha.Property>
      getUpdatePropertyMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.UpdatePropertyRequest,
            com.google.analytics.admin.v1alpha.Property>
        getUpdatePropertyMethod;
    if ((getUpdatePropertyMethod = AnalyticsAdminServiceGrpc.getUpdatePropertyMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdatePropertyMethod = AnalyticsAdminServiceGrpc.getUpdatePropertyMethod) == null) {
          AnalyticsAdminServiceGrpc.getUpdatePropertyMethod =
              getUpdatePropertyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.UpdatePropertyRequest,
                          com.google.analytics.admin.v1alpha.Property>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateProperty"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UpdatePropertyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.Property.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("UpdateProperty"))
                      .build();
        }
      }
    }
    return getUpdatePropertyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetUserLinkRequest,
          com.google.analytics.admin.v1alpha.UserLink>
      getGetUserLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserLink",
      requestType = com.google.analytics.admin.v1alpha.GetUserLinkRequest.class,
      responseType = com.google.analytics.admin.v1alpha.UserLink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetUserLinkRequest,
          com.google.analytics.admin.v1alpha.UserLink>
      getGetUserLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetUserLinkRequest,
            com.google.analytics.admin.v1alpha.UserLink>
        getGetUserLinkMethod;
    if ((getGetUserLinkMethod = AnalyticsAdminServiceGrpc.getGetUserLinkMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetUserLinkMethod = AnalyticsAdminServiceGrpc.getGetUserLinkMethod) == null) {
          AnalyticsAdminServiceGrpc.getGetUserLinkMethod =
              getGetUserLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetUserLinkRequest,
                          com.google.analytics.admin.v1alpha.UserLink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUserLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GetUserLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UserLink.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("GetUserLink"))
                      .build();
        }
      }
    }
    return getGetUserLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.BatchGetUserLinksRequest,
          com.google.analytics.admin.v1alpha.BatchGetUserLinksResponse>
      getBatchGetUserLinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchGetUserLinks",
      requestType = com.google.analytics.admin.v1alpha.BatchGetUserLinksRequest.class,
      responseType = com.google.analytics.admin.v1alpha.BatchGetUserLinksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.BatchGetUserLinksRequest,
          com.google.analytics.admin.v1alpha.BatchGetUserLinksResponse>
      getBatchGetUserLinksMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.BatchGetUserLinksRequest,
            com.google.analytics.admin.v1alpha.BatchGetUserLinksResponse>
        getBatchGetUserLinksMethod;
    if ((getBatchGetUserLinksMethod = AnalyticsAdminServiceGrpc.getBatchGetUserLinksMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getBatchGetUserLinksMethod = AnalyticsAdminServiceGrpc.getBatchGetUserLinksMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getBatchGetUserLinksMethod =
              getBatchGetUserLinksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.BatchGetUserLinksRequest,
                          com.google.analytics.admin.v1alpha.BatchGetUserLinksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchGetUserLinks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.BatchGetUserLinksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.BatchGetUserLinksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("BatchGetUserLinks"))
                      .build();
        }
      }
    }
    return getBatchGetUserLinksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListUserLinksRequest,
          com.google.analytics.admin.v1alpha.ListUserLinksResponse>
      getListUserLinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListUserLinks",
      requestType = com.google.analytics.admin.v1alpha.ListUserLinksRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ListUserLinksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListUserLinksRequest,
          com.google.analytics.admin.v1alpha.ListUserLinksResponse>
      getListUserLinksMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListUserLinksRequest,
            com.google.analytics.admin.v1alpha.ListUserLinksResponse>
        getListUserLinksMethod;
    if ((getListUserLinksMethod = AnalyticsAdminServiceGrpc.getListUserLinksMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListUserLinksMethod = AnalyticsAdminServiceGrpc.getListUserLinksMethod) == null) {
          AnalyticsAdminServiceGrpc.getListUserLinksMethod =
              getListUserLinksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ListUserLinksRequest,
                          com.google.analytics.admin.v1alpha.ListUserLinksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListUserLinks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListUserLinksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListUserLinksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("ListUserLinks"))
                      .build();
        }
      }
    }
    return getListUserLinksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.AuditUserLinksRequest,
          com.google.analytics.admin.v1alpha.AuditUserLinksResponse>
      getAuditUserLinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AuditUserLinks",
      requestType = com.google.analytics.admin.v1alpha.AuditUserLinksRequest.class,
      responseType = com.google.analytics.admin.v1alpha.AuditUserLinksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.AuditUserLinksRequest,
          com.google.analytics.admin.v1alpha.AuditUserLinksResponse>
      getAuditUserLinksMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.AuditUserLinksRequest,
            com.google.analytics.admin.v1alpha.AuditUserLinksResponse>
        getAuditUserLinksMethod;
    if ((getAuditUserLinksMethod = AnalyticsAdminServiceGrpc.getAuditUserLinksMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getAuditUserLinksMethod = AnalyticsAdminServiceGrpc.getAuditUserLinksMethod) == null) {
          AnalyticsAdminServiceGrpc.getAuditUserLinksMethod =
              getAuditUserLinksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.AuditUserLinksRequest,
                          com.google.analytics.admin.v1alpha.AuditUserLinksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AuditUserLinks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.AuditUserLinksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.AuditUserLinksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("AuditUserLinks"))
                      .build();
        }
      }
    }
    return getAuditUserLinksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateUserLinkRequest,
          com.google.analytics.admin.v1alpha.UserLink>
      getCreateUserLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUserLink",
      requestType = com.google.analytics.admin.v1alpha.CreateUserLinkRequest.class,
      responseType = com.google.analytics.admin.v1alpha.UserLink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateUserLinkRequest,
          com.google.analytics.admin.v1alpha.UserLink>
      getCreateUserLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.CreateUserLinkRequest,
            com.google.analytics.admin.v1alpha.UserLink>
        getCreateUserLinkMethod;
    if ((getCreateUserLinkMethod = AnalyticsAdminServiceGrpc.getCreateUserLinkMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateUserLinkMethod = AnalyticsAdminServiceGrpc.getCreateUserLinkMethod) == null) {
          AnalyticsAdminServiceGrpc.getCreateUserLinkMethod =
              getCreateUserLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.CreateUserLinkRequest,
                          com.google.analytics.admin.v1alpha.UserLink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateUserLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CreateUserLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UserLink.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("CreateUserLink"))
                      .build();
        }
      }
    }
    return getCreateUserLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.BatchCreateUserLinksRequest,
          com.google.analytics.admin.v1alpha.BatchCreateUserLinksResponse>
      getBatchCreateUserLinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchCreateUserLinks",
      requestType = com.google.analytics.admin.v1alpha.BatchCreateUserLinksRequest.class,
      responseType = com.google.analytics.admin.v1alpha.BatchCreateUserLinksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.BatchCreateUserLinksRequest,
          com.google.analytics.admin.v1alpha.BatchCreateUserLinksResponse>
      getBatchCreateUserLinksMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.BatchCreateUserLinksRequest,
            com.google.analytics.admin.v1alpha.BatchCreateUserLinksResponse>
        getBatchCreateUserLinksMethod;
    if ((getBatchCreateUserLinksMethod = AnalyticsAdminServiceGrpc.getBatchCreateUserLinksMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getBatchCreateUserLinksMethod =
                AnalyticsAdminServiceGrpc.getBatchCreateUserLinksMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getBatchCreateUserLinksMethod =
              getBatchCreateUserLinksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.BatchCreateUserLinksRequest,
                          com.google.analytics.admin.v1alpha.BatchCreateUserLinksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchCreateUserLinks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.BatchCreateUserLinksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.BatchCreateUserLinksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("BatchCreateUserLinks"))
                      .build();
        }
      }
    }
    return getBatchCreateUserLinksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateUserLinkRequest,
          com.google.analytics.admin.v1alpha.UserLink>
      getUpdateUserLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUserLink",
      requestType = com.google.analytics.admin.v1alpha.UpdateUserLinkRequest.class,
      responseType = com.google.analytics.admin.v1alpha.UserLink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateUserLinkRequest,
          com.google.analytics.admin.v1alpha.UserLink>
      getUpdateUserLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.UpdateUserLinkRequest,
            com.google.analytics.admin.v1alpha.UserLink>
        getUpdateUserLinkMethod;
    if ((getUpdateUserLinkMethod = AnalyticsAdminServiceGrpc.getUpdateUserLinkMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateUserLinkMethod = AnalyticsAdminServiceGrpc.getUpdateUserLinkMethod) == null) {
          AnalyticsAdminServiceGrpc.getUpdateUserLinkMethod =
              getUpdateUserLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.UpdateUserLinkRequest,
                          com.google.analytics.admin.v1alpha.UserLink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateUserLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UpdateUserLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UserLink.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("UpdateUserLink"))
                      .build();
        }
      }
    }
    return getUpdateUserLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.BatchUpdateUserLinksRequest,
          com.google.analytics.admin.v1alpha.BatchUpdateUserLinksResponse>
      getBatchUpdateUserLinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchUpdateUserLinks",
      requestType = com.google.analytics.admin.v1alpha.BatchUpdateUserLinksRequest.class,
      responseType = com.google.analytics.admin.v1alpha.BatchUpdateUserLinksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.BatchUpdateUserLinksRequest,
          com.google.analytics.admin.v1alpha.BatchUpdateUserLinksResponse>
      getBatchUpdateUserLinksMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.BatchUpdateUserLinksRequest,
            com.google.analytics.admin.v1alpha.BatchUpdateUserLinksResponse>
        getBatchUpdateUserLinksMethod;
    if ((getBatchUpdateUserLinksMethod = AnalyticsAdminServiceGrpc.getBatchUpdateUserLinksMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getBatchUpdateUserLinksMethod =
                AnalyticsAdminServiceGrpc.getBatchUpdateUserLinksMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getBatchUpdateUserLinksMethod =
              getBatchUpdateUserLinksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.BatchUpdateUserLinksRequest,
                          com.google.analytics.admin.v1alpha.BatchUpdateUserLinksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchUpdateUserLinks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.BatchUpdateUserLinksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.BatchUpdateUserLinksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("BatchUpdateUserLinks"))
                      .build();
        }
      }
    }
    return getBatchUpdateUserLinksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteUserLinkRequest, com.google.protobuf.Empty>
      getDeleteUserLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteUserLink",
      requestType = com.google.analytics.admin.v1alpha.DeleteUserLinkRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteUserLinkRequest, com.google.protobuf.Empty>
      getDeleteUserLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.DeleteUserLinkRequest, com.google.protobuf.Empty>
        getDeleteUserLinkMethod;
    if ((getDeleteUserLinkMethod = AnalyticsAdminServiceGrpc.getDeleteUserLinkMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeleteUserLinkMethod = AnalyticsAdminServiceGrpc.getDeleteUserLinkMethod) == null) {
          AnalyticsAdminServiceGrpc.getDeleteUserLinkMethod =
              getDeleteUserLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.DeleteUserLinkRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteUserLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DeleteUserLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("DeleteUserLink"))
                      .build();
        }
      }
    }
    return getDeleteUserLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.BatchDeleteUserLinksRequest, com.google.protobuf.Empty>
      getBatchDeleteUserLinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchDeleteUserLinks",
      requestType = com.google.analytics.admin.v1alpha.BatchDeleteUserLinksRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.BatchDeleteUserLinksRequest, com.google.protobuf.Empty>
      getBatchDeleteUserLinksMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.BatchDeleteUserLinksRequest,
            com.google.protobuf.Empty>
        getBatchDeleteUserLinksMethod;
    if ((getBatchDeleteUserLinksMethod = AnalyticsAdminServiceGrpc.getBatchDeleteUserLinksMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getBatchDeleteUserLinksMethod =
                AnalyticsAdminServiceGrpc.getBatchDeleteUserLinksMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getBatchDeleteUserLinksMethod =
              getBatchDeleteUserLinksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.BatchDeleteUserLinksRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchDeleteUserLinks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.BatchDeleteUserLinksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("BatchDeleteUserLinks"))
                      .build();
        }
      }
    }
    return getBatchDeleteUserLinksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateFirebaseLinkRequest,
          com.google.analytics.admin.v1alpha.FirebaseLink>
      getCreateFirebaseLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFirebaseLink",
      requestType = com.google.analytics.admin.v1alpha.CreateFirebaseLinkRequest.class,
      responseType = com.google.analytics.admin.v1alpha.FirebaseLink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateFirebaseLinkRequest,
          com.google.analytics.admin.v1alpha.FirebaseLink>
      getCreateFirebaseLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.CreateFirebaseLinkRequest,
            com.google.analytics.admin.v1alpha.FirebaseLink>
        getCreateFirebaseLinkMethod;
    if ((getCreateFirebaseLinkMethod = AnalyticsAdminServiceGrpc.getCreateFirebaseLinkMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateFirebaseLinkMethod = AnalyticsAdminServiceGrpc.getCreateFirebaseLinkMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getCreateFirebaseLinkMethod =
              getCreateFirebaseLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.CreateFirebaseLinkRequest,
                          com.google.analytics.admin.v1alpha.FirebaseLink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFirebaseLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CreateFirebaseLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.FirebaseLink.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("CreateFirebaseLink"))
                      .build();
        }
      }
    }
    return getCreateFirebaseLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteFirebaseLinkRequest, com.google.protobuf.Empty>
      getDeleteFirebaseLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFirebaseLink",
      requestType = com.google.analytics.admin.v1alpha.DeleteFirebaseLinkRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteFirebaseLinkRequest, com.google.protobuf.Empty>
      getDeleteFirebaseLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.DeleteFirebaseLinkRequest, com.google.protobuf.Empty>
        getDeleteFirebaseLinkMethod;
    if ((getDeleteFirebaseLinkMethod = AnalyticsAdminServiceGrpc.getDeleteFirebaseLinkMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeleteFirebaseLinkMethod = AnalyticsAdminServiceGrpc.getDeleteFirebaseLinkMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getDeleteFirebaseLinkMethod =
              getDeleteFirebaseLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.DeleteFirebaseLinkRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteFirebaseLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DeleteFirebaseLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("DeleteFirebaseLink"))
                      .build();
        }
      }
    }
    return getDeleteFirebaseLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListFirebaseLinksRequest,
          com.google.analytics.admin.v1alpha.ListFirebaseLinksResponse>
      getListFirebaseLinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFirebaseLinks",
      requestType = com.google.analytics.admin.v1alpha.ListFirebaseLinksRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ListFirebaseLinksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListFirebaseLinksRequest,
          com.google.analytics.admin.v1alpha.ListFirebaseLinksResponse>
      getListFirebaseLinksMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListFirebaseLinksRequest,
            com.google.analytics.admin.v1alpha.ListFirebaseLinksResponse>
        getListFirebaseLinksMethod;
    if ((getListFirebaseLinksMethod = AnalyticsAdminServiceGrpc.getListFirebaseLinksMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListFirebaseLinksMethod = AnalyticsAdminServiceGrpc.getListFirebaseLinksMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getListFirebaseLinksMethod =
              getListFirebaseLinksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ListFirebaseLinksRequest,
                          com.google.analytics.admin.v1alpha.ListFirebaseLinksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFirebaseLinks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListFirebaseLinksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListFirebaseLinksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("ListFirebaseLinks"))
                      .build();
        }
      }
    }
    return getListFirebaseLinksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetGlobalSiteTagRequest,
          com.google.analytics.admin.v1alpha.GlobalSiteTag>
      getGetGlobalSiteTagMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGlobalSiteTag",
      requestType = com.google.analytics.admin.v1alpha.GetGlobalSiteTagRequest.class,
      responseType = com.google.analytics.admin.v1alpha.GlobalSiteTag.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetGlobalSiteTagRequest,
          com.google.analytics.admin.v1alpha.GlobalSiteTag>
      getGetGlobalSiteTagMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetGlobalSiteTagRequest,
            com.google.analytics.admin.v1alpha.GlobalSiteTag>
        getGetGlobalSiteTagMethod;
    if ((getGetGlobalSiteTagMethod = AnalyticsAdminServiceGrpc.getGetGlobalSiteTagMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetGlobalSiteTagMethod = AnalyticsAdminServiceGrpc.getGetGlobalSiteTagMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getGetGlobalSiteTagMethod =
              getGetGlobalSiteTagMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetGlobalSiteTagRequest,
                          com.google.analytics.admin.v1alpha.GlobalSiteTag>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetGlobalSiteTag"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GetGlobalSiteTagRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GlobalSiteTag
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("GetGlobalSiteTag"))
                      .build();
        }
      }
    }
    return getGetGlobalSiteTagMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateGoogleAdsLinkRequest,
          com.google.analytics.admin.v1alpha.GoogleAdsLink>
      getCreateGoogleAdsLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateGoogleAdsLink",
      requestType = com.google.analytics.admin.v1alpha.CreateGoogleAdsLinkRequest.class,
      responseType = com.google.analytics.admin.v1alpha.GoogleAdsLink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateGoogleAdsLinkRequest,
          com.google.analytics.admin.v1alpha.GoogleAdsLink>
      getCreateGoogleAdsLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.CreateGoogleAdsLinkRequest,
            com.google.analytics.admin.v1alpha.GoogleAdsLink>
        getCreateGoogleAdsLinkMethod;
    if ((getCreateGoogleAdsLinkMethod = AnalyticsAdminServiceGrpc.getCreateGoogleAdsLinkMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateGoogleAdsLinkMethod = AnalyticsAdminServiceGrpc.getCreateGoogleAdsLinkMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getCreateGoogleAdsLinkMethod =
              getCreateGoogleAdsLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.CreateGoogleAdsLinkRequest,
                          com.google.analytics.admin.v1alpha.GoogleAdsLink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateGoogleAdsLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CreateGoogleAdsLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GoogleAdsLink
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("CreateGoogleAdsLink"))
                      .build();
        }
      }
    }
    return getCreateGoogleAdsLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateGoogleAdsLinkRequest,
          com.google.analytics.admin.v1alpha.GoogleAdsLink>
      getUpdateGoogleAdsLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateGoogleAdsLink",
      requestType = com.google.analytics.admin.v1alpha.UpdateGoogleAdsLinkRequest.class,
      responseType = com.google.analytics.admin.v1alpha.GoogleAdsLink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateGoogleAdsLinkRequest,
          com.google.analytics.admin.v1alpha.GoogleAdsLink>
      getUpdateGoogleAdsLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.UpdateGoogleAdsLinkRequest,
            com.google.analytics.admin.v1alpha.GoogleAdsLink>
        getUpdateGoogleAdsLinkMethod;
    if ((getUpdateGoogleAdsLinkMethod = AnalyticsAdminServiceGrpc.getUpdateGoogleAdsLinkMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateGoogleAdsLinkMethod = AnalyticsAdminServiceGrpc.getUpdateGoogleAdsLinkMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getUpdateGoogleAdsLinkMethod =
              getUpdateGoogleAdsLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.UpdateGoogleAdsLinkRequest,
                          com.google.analytics.admin.v1alpha.GoogleAdsLink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateGoogleAdsLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UpdateGoogleAdsLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GoogleAdsLink
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("UpdateGoogleAdsLink"))
                      .build();
        }
      }
    }
    return getUpdateGoogleAdsLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteGoogleAdsLinkRequest, com.google.protobuf.Empty>
      getDeleteGoogleAdsLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteGoogleAdsLink",
      requestType = com.google.analytics.admin.v1alpha.DeleteGoogleAdsLinkRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteGoogleAdsLinkRequest, com.google.protobuf.Empty>
      getDeleteGoogleAdsLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.DeleteGoogleAdsLinkRequest,
            com.google.protobuf.Empty>
        getDeleteGoogleAdsLinkMethod;
    if ((getDeleteGoogleAdsLinkMethod = AnalyticsAdminServiceGrpc.getDeleteGoogleAdsLinkMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeleteGoogleAdsLinkMethod = AnalyticsAdminServiceGrpc.getDeleteGoogleAdsLinkMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getDeleteGoogleAdsLinkMethod =
              getDeleteGoogleAdsLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.DeleteGoogleAdsLinkRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteGoogleAdsLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DeleteGoogleAdsLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("DeleteGoogleAdsLink"))
                      .build();
        }
      }
    }
    return getDeleteGoogleAdsLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListGoogleAdsLinksRequest,
          com.google.analytics.admin.v1alpha.ListGoogleAdsLinksResponse>
      getListGoogleAdsLinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListGoogleAdsLinks",
      requestType = com.google.analytics.admin.v1alpha.ListGoogleAdsLinksRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ListGoogleAdsLinksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListGoogleAdsLinksRequest,
          com.google.analytics.admin.v1alpha.ListGoogleAdsLinksResponse>
      getListGoogleAdsLinksMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListGoogleAdsLinksRequest,
            com.google.analytics.admin.v1alpha.ListGoogleAdsLinksResponse>
        getListGoogleAdsLinksMethod;
    if ((getListGoogleAdsLinksMethod = AnalyticsAdminServiceGrpc.getListGoogleAdsLinksMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListGoogleAdsLinksMethod = AnalyticsAdminServiceGrpc.getListGoogleAdsLinksMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getListGoogleAdsLinksMethod =
              getListGoogleAdsLinksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ListGoogleAdsLinksRequest,
                          com.google.analytics.admin.v1alpha.ListGoogleAdsLinksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListGoogleAdsLinks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListGoogleAdsLinksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListGoogleAdsLinksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("ListGoogleAdsLinks"))
                      .build();
        }
      }
    }
    return getListGoogleAdsLinksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetDataSharingSettingsRequest,
          com.google.analytics.admin.v1alpha.DataSharingSettings>
      getGetDataSharingSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataSharingSettings",
      requestType = com.google.analytics.admin.v1alpha.GetDataSharingSettingsRequest.class,
      responseType = com.google.analytics.admin.v1alpha.DataSharingSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetDataSharingSettingsRequest,
          com.google.analytics.admin.v1alpha.DataSharingSettings>
      getGetDataSharingSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetDataSharingSettingsRequest,
            com.google.analytics.admin.v1alpha.DataSharingSettings>
        getGetDataSharingSettingsMethod;
    if ((getGetDataSharingSettingsMethod =
            AnalyticsAdminServiceGrpc.getGetDataSharingSettingsMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetDataSharingSettingsMethod =
                AnalyticsAdminServiceGrpc.getGetDataSharingSettingsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getGetDataSharingSettingsMethod =
              getGetDataSharingSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetDataSharingSettingsRequest,
                          com.google.analytics.admin.v1alpha.DataSharingSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetDataSharingSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GetDataSharingSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DataSharingSettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "GetDataSharingSettings"))
                      .build();
        }
      }
    }
    return getGetDataSharingSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetMeasurementProtocolSecretRequest,
          com.google.analytics.admin.v1alpha.MeasurementProtocolSecret>
      getGetMeasurementProtocolSecretMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMeasurementProtocolSecret",
      requestType = com.google.analytics.admin.v1alpha.GetMeasurementProtocolSecretRequest.class,
      responseType = com.google.analytics.admin.v1alpha.MeasurementProtocolSecret.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetMeasurementProtocolSecretRequest,
          com.google.analytics.admin.v1alpha.MeasurementProtocolSecret>
      getGetMeasurementProtocolSecretMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetMeasurementProtocolSecretRequest,
            com.google.analytics.admin.v1alpha.MeasurementProtocolSecret>
        getGetMeasurementProtocolSecretMethod;
    if ((getGetMeasurementProtocolSecretMethod =
            AnalyticsAdminServiceGrpc.getGetMeasurementProtocolSecretMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetMeasurementProtocolSecretMethod =
                AnalyticsAdminServiceGrpc.getGetMeasurementProtocolSecretMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getGetMeasurementProtocolSecretMethod =
              getGetMeasurementProtocolSecretMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetMeasurementProtocolSecretRequest,
                          com.google.analytics.admin.v1alpha.MeasurementProtocolSecret>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetMeasurementProtocolSecret"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GetMeasurementProtocolSecretRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.MeasurementProtocolSecret
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "GetMeasurementProtocolSecret"))
                      .build();
        }
      }
    }
    return getGetMeasurementProtocolSecretMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListMeasurementProtocolSecretsRequest,
          com.google.analytics.admin.v1alpha.ListMeasurementProtocolSecretsResponse>
      getListMeasurementProtocolSecretsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMeasurementProtocolSecrets",
      requestType = com.google.analytics.admin.v1alpha.ListMeasurementProtocolSecretsRequest.class,
      responseType =
          com.google.analytics.admin.v1alpha.ListMeasurementProtocolSecretsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListMeasurementProtocolSecretsRequest,
          com.google.analytics.admin.v1alpha.ListMeasurementProtocolSecretsResponse>
      getListMeasurementProtocolSecretsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListMeasurementProtocolSecretsRequest,
            com.google.analytics.admin.v1alpha.ListMeasurementProtocolSecretsResponse>
        getListMeasurementProtocolSecretsMethod;
    if ((getListMeasurementProtocolSecretsMethod =
            AnalyticsAdminServiceGrpc.getListMeasurementProtocolSecretsMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListMeasurementProtocolSecretsMethod =
                AnalyticsAdminServiceGrpc.getListMeasurementProtocolSecretsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getListMeasurementProtocolSecretsMethod =
              getListMeasurementProtocolSecretsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ListMeasurementProtocolSecretsRequest,
                          com.google.analytics.admin.v1alpha.ListMeasurementProtocolSecretsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListMeasurementProtocolSecrets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .ListMeasurementProtocolSecretsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .ListMeasurementProtocolSecretsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "ListMeasurementProtocolSecrets"))
                      .build();
        }
      }
    }
    return getListMeasurementProtocolSecretsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateMeasurementProtocolSecretRequest,
          com.google.analytics.admin.v1alpha.MeasurementProtocolSecret>
      getCreateMeasurementProtocolSecretMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMeasurementProtocolSecret",
      requestType = com.google.analytics.admin.v1alpha.CreateMeasurementProtocolSecretRequest.class,
      responseType = com.google.analytics.admin.v1alpha.MeasurementProtocolSecret.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateMeasurementProtocolSecretRequest,
          com.google.analytics.admin.v1alpha.MeasurementProtocolSecret>
      getCreateMeasurementProtocolSecretMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.CreateMeasurementProtocolSecretRequest,
            com.google.analytics.admin.v1alpha.MeasurementProtocolSecret>
        getCreateMeasurementProtocolSecretMethod;
    if ((getCreateMeasurementProtocolSecretMethod =
            AnalyticsAdminServiceGrpc.getCreateMeasurementProtocolSecretMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateMeasurementProtocolSecretMethod =
                AnalyticsAdminServiceGrpc.getCreateMeasurementProtocolSecretMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getCreateMeasurementProtocolSecretMethod =
              getCreateMeasurementProtocolSecretMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.CreateMeasurementProtocolSecretRequest,
                          com.google.analytics.admin.v1alpha.MeasurementProtocolSecret>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateMeasurementProtocolSecret"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .CreateMeasurementProtocolSecretRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.MeasurementProtocolSecret
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "CreateMeasurementProtocolSecret"))
                      .build();
        }
      }
    }
    return getCreateMeasurementProtocolSecretMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteMeasurementProtocolSecretRequest,
          com.google.protobuf.Empty>
      getDeleteMeasurementProtocolSecretMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMeasurementProtocolSecret",
      requestType = com.google.analytics.admin.v1alpha.DeleteMeasurementProtocolSecretRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteMeasurementProtocolSecretRequest,
          com.google.protobuf.Empty>
      getDeleteMeasurementProtocolSecretMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.DeleteMeasurementProtocolSecretRequest,
            com.google.protobuf.Empty>
        getDeleteMeasurementProtocolSecretMethod;
    if ((getDeleteMeasurementProtocolSecretMethod =
            AnalyticsAdminServiceGrpc.getDeleteMeasurementProtocolSecretMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeleteMeasurementProtocolSecretMethod =
                AnalyticsAdminServiceGrpc.getDeleteMeasurementProtocolSecretMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getDeleteMeasurementProtocolSecretMethod =
              getDeleteMeasurementProtocolSecretMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.DeleteMeasurementProtocolSecretRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteMeasurementProtocolSecret"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .DeleteMeasurementProtocolSecretRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "DeleteMeasurementProtocolSecret"))
                      .build();
        }
      }
    }
    return getDeleteMeasurementProtocolSecretMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateMeasurementProtocolSecretRequest,
          com.google.analytics.admin.v1alpha.MeasurementProtocolSecret>
      getUpdateMeasurementProtocolSecretMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateMeasurementProtocolSecret",
      requestType = com.google.analytics.admin.v1alpha.UpdateMeasurementProtocolSecretRequest.class,
      responseType = com.google.analytics.admin.v1alpha.MeasurementProtocolSecret.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateMeasurementProtocolSecretRequest,
          com.google.analytics.admin.v1alpha.MeasurementProtocolSecret>
      getUpdateMeasurementProtocolSecretMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.UpdateMeasurementProtocolSecretRequest,
            com.google.analytics.admin.v1alpha.MeasurementProtocolSecret>
        getUpdateMeasurementProtocolSecretMethod;
    if ((getUpdateMeasurementProtocolSecretMethod =
            AnalyticsAdminServiceGrpc.getUpdateMeasurementProtocolSecretMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateMeasurementProtocolSecretMethod =
                AnalyticsAdminServiceGrpc.getUpdateMeasurementProtocolSecretMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getUpdateMeasurementProtocolSecretMethod =
              getUpdateMeasurementProtocolSecretMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.UpdateMeasurementProtocolSecretRequest,
                          com.google.analytics.admin.v1alpha.MeasurementProtocolSecret>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateMeasurementProtocolSecret"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .UpdateMeasurementProtocolSecretRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.MeasurementProtocolSecret
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "UpdateMeasurementProtocolSecret"))
                      .build();
        }
      }
    }
    return getUpdateMeasurementProtocolSecretMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.AcknowledgeUserDataCollectionRequest,
          com.google.analytics.admin.v1alpha.AcknowledgeUserDataCollectionResponse>
      getAcknowledgeUserDataCollectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AcknowledgeUserDataCollection",
      requestType = com.google.analytics.admin.v1alpha.AcknowledgeUserDataCollectionRequest.class,
      responseType = com.google.analytics.admin.v1alpha.AcknowledgeUserDataCollectionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.AcknowledgeUserDataCollectionRequest,
          com.google.analytics.admin.v1alpha.AcknowledgeUserDataCollectionResponse>
      getAcknowledgeUserDataCollectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.AcknowledgeUserDataCollectionRequest,
            com.google.analytics.admin.v1alpha.AcknowledgeUserDataCollectionResponse>
        getAcknowledgeUserDataCollectionMethod;
    if ((getAcknowledgeUserDataCollectionMethod =
            AnalyticsAdminServiceGrpc.getAcknowledgeUserDataCollectionMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getAcknowledgeUserDataCollectionMethod =
                AnalyticsAdminServiceGrpc.getAcknowledgeUserDataCollectionMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getAcknowledgeUserDataCollectionMethod =
              getAcknowledgeUserDataCollectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.AcknowledgeUserDataCollectionRequest,
                          com.google.analytics.admin.v1alpha.AcknowledgeUserDataCollectionResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "AcknowledgeUserDataCollection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .AcknowledgeUserDataCollectionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .AcknowledgeUserDataCollectionResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "AcknowledgeUserDataCollection"))
                      .build();
        }
      }
    }
    return getAcknowledgeUserDataCollectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.SearchChangeHistoryEventsRequest,
          com.google.analytics.admin.v1alpha.SearchChangeHistoryEventsResponse>
      getSearchChangeHistoryEventsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchChangeHistoryEvents",
      requestType = com.google.analytics.admin.v1alpha.SearchChangeHistoryEventsRequest.class,
      responseType = com.google.analytics.admin.v1alpha.SearchChangeHistoryEventsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.SearchChangeHistoryEventsRequest,
          com.google.analytics.admin.v1alpha.SearchChangeHistoryEventsResponse>
      getSearchChangeHistoryEventsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.SearchChangeHistoryEventsRequest,
            com.google.analytics.admin.v1alpha.SearchChangeHistoryEventsResponse>
        getSearchChangeHistoryEventsMethod;
    if ((getSearchChangeHistoryEventsMethod =
            AnalyticsAdminServiceGrpc.getSearchChangeHistoryEventsMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getSearchChangeHistoryEventsMethod =
                AnalyticsAdminServiceGrpc.getSearchChangeHistoryEventsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getSearchChangeHistoryEventsMethod =
              getSearchChangeHistoryEventsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.SearchChangeHistoryEventsRequest,
                          com.google.analytics.admin.v1alpha.SearchChangeHistoryEventsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SearchChangeHistoryEvents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.SearchChangeHistoryEventsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.SearchChangeHistoryEventsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "SearchChangeHistoryEvents"))
                      .build();
        }
      }
    }
    return getSearchChangeHistoryEventsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetGoogleSignalsSettingsRequest,
          com.google.analytics.admin.v1alpha.GoogleSignalsSettings>
      getGetGoogleSignalsSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGoogleSignalsSettings",
      requestType = com.google.analytics.admin.v1alpha.GetGoogleSignalsSettingsRequest.class,
      responseType = com.google.analytics.admin.v1alpha.GoogleSignalsSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetGoogleSignalsSettingsRequest,
          com.google.analytics.admin.v1alpha.GoogleSignalsSettings>
      getGetGoogleSignalsSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetGoogleSignalsSettingsRequest,
            com.google.analytics.admin.v1alpha.GoogleSignalsSettings>
        getGetGoogleSignalsSettingsMethod;
    if ((getGetGoogleSignalsSettingsMethod =
            AnalyticsAdminServiceGrpc.getGetGoogleSignalsSettingsMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetGoogleSignalsSettingsMethod =
                AnalyticsAdminServiceGrpc.getGetGoogleSignalsSettingsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getGetGoogleSignalsSettingsMethod =
              getGetGoogleSignalsSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetGoogleSignalsSettingsRequest,
                          com.google.analytics.admin.v1alpha.GoogleSignalsSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetGoogleSignalsSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GetGoogleSignalsSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GoogleSignalsSettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "GetGoogleSignalsSettings"))
                      .build();
        }
      }
    }
    return getGetGoogleSignalsSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateGoogleSignalsSettingsRequest,
          com.google.analytics.admin.v1alpha.GoogleSignalsSettings>
      getUpdateGoogleSignalsSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateGoogleSignalsSettings",
      requestType = com.google.analytics.admin.v1alpha.UpdateGoogleSignalsSettingsRequest.class,
      responseType = com.google.analytics.admin.v1alpha.GoogleSignalsSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateGoogleSignalsSettingsRequest,
          com.google.analytics.admin.v1alpha.GoogleSignalsSettings>
      getUpdateGoogleSignalsSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.UpdateGoogleSignalsSettingsRequest,
            com.google.analytics.admin.v1alpha.GoogleSignalsSettings>
        getUpdateGoogleSignalsSettingsMethod;
    if ((getUpdateGoogleSignalsSettingsMethod =
            AnalyticsAdminServiceGrpc.getUpdateGoogleSignalsSettingsMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateGoogleSignalsSettingsMethod =
                AnalyticsAdminServiceGrpc.getUpdateGoogleSignalsSettingsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getUpdateGoogleSignalsSettingsMethod =
              getUpdateGoogleSignalsSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.UpdateGoogleSignalsSettingsRequest,
                          com.google.analytics.admin.v1alpha.GoogleSignalsSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateGoogleSignalsSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UpdateGoogleSignalsSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GoogleSignalsSettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "UpdateGoogleSignalsSettings"))
                      .build();
        }
      }
    }
    return getUpdateGoogleSignalsSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateConversionEventRequest,
          com.google.analytics.admin.v1alpha.ConversionEvent>
      getCreateConversionEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateConversionEvent",
      requestType = com.google.analytics.admin.v1alpha.CreateConversionEventRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ConversionEvent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateConversionEventRequest,
          com.google.analytics.admin.v1alpha.ConversionEvent>
      getCreateConversionEventMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.CreateConversionEventRequest,
            com.google.analytics.admin.v1alpha.ConversionEvent>
        getCreateConversionEventMethod;
    if ((getCreateConversionEventMethod = AnalyticsAdminServiceGrpc.getCreateConversionEventMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateConversionEventMethod =
                AnalyticsAdminServiceGrpc.getCreateConversionEventMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getCreateConversionEventMethod =
              getCreateConversionEventMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.CreateConversionEventRequest,
                          com.google.analytics.admin.v1alpha.ConversionEvent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateConversionEvent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CreateConversionEventRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ConversionEvent
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "CreateConversionEvent"))
                      .build();
        }
      }
    }
    return getCreateConversionEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetConversionEventRequest,
          com.google.analytics.admin.v1alpha.ConversionEvent>
      getGetConversionEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConversionEvent",
      requestType = com.google.analytics.admin.v1alpha.GetConversionEventRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ConversionEvent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetConversionEventRequest,
          com.google.analytics.admin.v1alpha.ConversionEvent>
      getGetConversionEventMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetConversionEventRequest,
            com.google.analytics.admin.v1alpha.ConversionEvent>
        getGetConversionEventMethod;
    if ((getGetConversionEventMethod = AnalyticsAdminServiceGrpc.getGetConversionEventMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetConversionEventMethod = AnalyticsAdminServiceGrpc.getGetConversionEventMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getGetConversionEventMethod =
              getGetConversionEventMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetConversionEventRequest,
                          com.google.analytics.admin.v1alpha.ConversionEvent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetConversionEvent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GetConversionEventRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ConversionEvent
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("GetConversionEvent"))
                      .build();
        }
      }
    }
    return getGetConversionEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteConversionEventRequest,
          com.google.protobuf.Empty>
      getDeleteConversionEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteConversionEvent",
      requestType = com.google.analytics.admin.v1alpha.DeleteConversionEventRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteConversionEventRequest,
          com.google.protobuf.Empty>
      getDeleteConversionEventMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.DeleteConversionEventRequest,
            com.google.protobuf.Empty>
        getDeleteConversionEventMethod;
    if ((getDeleteConversionEventMethod = AnalyticsAdminServiceGrpc.getDeleteConversionEventMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeleteConversionEventMethod =
                AnalyticsAdminServiceGrpc.getDeleteConversionEventMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getDeleteConversionEventMethod =
              getDeleteConversionEventMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.DeleteConversionEventRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteConversionEvent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DeleteConversionEventRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "DeleteConversionEvent"))
                      .build();
        }
      }
    }
    return getDeleteConversionEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListConversionEventsRequest,
          com.google.analytics.admin.v1alpha.ListConversionEventsResponse>
      getListConversionEventsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListConversionEvents",
      requestType = com.google.analytics.admin.v1alpha.ListConversionEventsRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ListConversionEventsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListConversionEventsRequest,
          com.google.analytics.admin.v1alpha.ListConversionEventsResponse>
      getListConversionEventsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListConversionEventsRequest,
            com.google.analytics.admin.v1alpha.ListConversionEventsResponse>
        getListConversionEventsMethod;
    if ((getListConversionEventsMethod = AnalyticsAdminServiceGrpc.getListConversionEventsMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListConversionEventsMethod =
                AnalyticsAdminServiceGrpc.getListConversionEventsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getListConversionEventsMethod =
              getListConversionEventsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ListConversionEventsRequest,
                          com.google.analytics.admin.v1alpha.ListConversionEventsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListConversionEvents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListConversionEventsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListConversionEventsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("ListConversionEvents"))
                      .build();
        }
      }
    }
    return getListConversionEventsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetDisplayVideo360AdvertiserLinkRequest,
          com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink>
      getGetDisplayVideo360AdvertiserLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDisplayVideo360AdvertiserLink",
      requestType =
          com.google.analytics.admin.v1alpha.GetDisplayVideo360AdvertiserLinkRequest.class,
      responseType = com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetDisplayVideo360AdvertiserLinkRequest,
          com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink>
      getGetDisplayVideo360AdvertiserLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetDisplayVideo360AdvertiserLinkRequest,
            com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink>
        getGetDisplayVideo360AdvertiserLinkMethod;
    if ((getGetDisplayVideo360AdvertiserLinkMethod =
            AnalyticsAdminServiceGrpc.getGetDisplayVideo360AdvertiserLinkMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetDisplayVideo360AdvertiserLinkMethod =
                AnalyticsAdminServiceGrpc.getGetDisplayVideo360AdvertiserLinkMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getGetDisplayVideo360AdvertiserLinkMethod =
              getGetDisplayVideo360AdvertiserLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetDisplayVideo360AdvertiserLinkRequest,
                          com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetDisplayVideo360AdvertiserLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .GetDisplayVideo360AdvertiserLinkRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "GetDisplayVideo360AdvertiserLink"))
                      .build();
        }
      }
    }
    return getGetDisplayVideo360AdvertiserLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinksRequest,
          com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinksResponse>
      getListDisplayVideo360AdvertiserLinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDisplayVideo360AdvertiserLinks",
      requestType =
          com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinksRequest.class,
      responseType =
          com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinksRequest,
          com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinksResponse>
      getListDisplayVideo360AdvertiserLinksMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinksRequest,
            com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinksResponse>
        getListDisplayVideo360AdvertiserLinksMethod;
    if ((getListDisplayVideo360AdvertiserLinksMethod =
            AnalyticsAdminServiceGrpc.getListDisplayVideo360AdvertiserLinksMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListDisplayVideo360AdvertiserLinksMethod =
                AnalyticsAdminServiceGrpc.getListDisplayVideo360AdvertiserLinksMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getListDisplayVideo360AdvertiserLinksMethod =
              getListDisplayVideo360AdvertiserLinksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha
                              .ListDisplayVideo360AdvertiserLinksRequest,
                          com.google.analytics.admin.v1alpha
                              .ListDisplayVideo360AdvertiserLinksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "ListDisplayVideo360AdvertiserLinks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .ListDisplayVideo360AdvertiserLinksRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .ListDisplayVideo360AdvertiserLinksResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "ListDisplayVideo360AdvertiserLinks"))
                      .build();
        }
      }
    }
    return getListDisplayVideo360AdvertiserLinksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateDisplayVideo360AdvertiserLinkRequest,
          com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink>
      getCreateDisplayVideo360AdvertiserLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDisplayVideo360AdvertiserLink",
      requestType =
          com.google.analytics.admin.v1alpha.CreateDisplayVideo360AdvertiserLinkRequest.class,
      responseType = com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateDisplayVideo360AdvertiserLinkRequest,
          com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink>
      getCreateDisplayVideo360AdvertiserLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.CreateDisplayVideo360AdvertiserLinkRequest,
            com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink>
        getCreateDisplayVideo360AdvertiserLinkMethod;
    if ((getCreateDisplayVideo360AdvertiserLinkMethod =
            AnalyticsAdminServiceGrpc.getCreateDisplayVideo360AdvertiserLinkMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateDisplayVideo360AdvertiserLinkMethod =
                AnalyticsAdminServiceGrpc.getCreateDisplayVideo360AdvertiserLinkMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getCreateDisplayVideo360AdvertiserLinkMethod =
              getCreateDisplayVideo360AdvertiserLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha
                              .CreateDisplayVideo360AdvertiserLinkRequest,
                          com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "CreateDisplayVideo360AdvertiserLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .CreateDisplayVideo360AdvertiserLinkRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "CreateDisplayVideo360AdvertiserLink"))
                      .build();
        }
      }
    }
    return getCreateDisplayVideo360AdvertiserLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteDisplayVideo360AdvertiserLinkRequest,
          com.google.protobuf.Empty>
      getDeleteDisplayVideo360AdvertiserLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDisplayVideo360AdvertiserLink",
      requestType =
          com.google.analytics.admin.v1alpha.DeleteDisplayVideo360AdvertiserLinkRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteDisplayVideo360AdvertiserLinkRequest,
          com.google.protobuf.Empty>
      getDeleteDisplayVideo360AdvertiserLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.DeleteDisplayVideo360AdvertiserLinkRequest,
            com.google.protobuf.Empty>
        getDeleteDisplayVideo360AdvertiserLinkMethod;
    if ((getDeleteDisplayVideo360AdvertiserLinkMethod =
            AnalyticsAdminServiceGrpc.getDeleteDisplayVideo360AdvertiserLinkMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeleteDisplayVideo360AdvertiserLinkMethod =
                AnalyticsAdminServiceGrpc.getDeleteDisplayVideo360AdvertiserLinkMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getDeleteDisplayVideo360AdvertiserLinkMethod =
              getDeleteDisplayVideo360AdvertiserLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha
                              .DeleteDisplayVideo360AdvertiserLinkRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "DeleteDisplayVideo360AdvertiserLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .DeleteDisplayVideo360AdvertiserLinkRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "DeleteDisplayVideo360AdvertiserLink"))
                      .build();
        }
      }
    }
    return getDeleteDisplayVideo360AdvertiserLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateDisplayVideo360AdvertiserLinkRequest,
          com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink>
      getUpdateDisplayVideo360AdvertiserLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDisplayVideo360AdvertiserLink",
      requestType =
          com.google.analytics.admin.v1alpha.UpdateDisplayVideo360AdvertiserLinkRequest.class,
      responseType = com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateDisplayVideo360AdvertiserLinkRequest,
          com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink>
      getUpdateDisplayVideo360AdvertiserLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.UpdateDisplayVideo360AdvertiserLinkRequest,
            com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink>
        getUpdateDisplayVideo360AdvertiserLinkMethod;
    if ((getUpdateDisplayVideo360AdvertiserLinkMethod =
            AnalyticsAdminServiceGrpc.getUpdateDisplayVideo360AdvertiserLinkMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateDisplayVideo360AdvertiserLinkMethod =
                AnalyticsAdminServiceGrpc.getUpdateDisplayVideo360AdvertiserLinkMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getUpdateDisplayVideo360AdvertiserLinkMethod =
              getUpdateDisplayVideo360AdvertiserLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha
                              .UpdateDisplayVideo360AdvertiserLinkRequest,
                          com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "UpdateDisplayVideo360AdvertiserLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .UpdateDisplayVideo360AdvertiserLinkRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "UpdateDisplayVideo360AdvertiserLink"))
                      .build();
        }
      }
    }
    return getUpdateDisplayVideo360AdvertiserLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetDisplayVideo360AdvertiserLinkProposalRequest,
          com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal>
      getGetDisplayVideo360AdvertiserLinkProposalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDisplayVideo360AdvertiserLinkProposal",
      requestType =
          com.google.analytics.admin.v1alpha.GetDisplayVideo360AdvertiserLinkProposalRequest.class,
      responseType = com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetDisplayVideo360AdvertiserLinkProposalRequest,
          com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal>
      getGetDisplayVideo360AdvertiserLinkProposalMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetDisplayVideo360AdvertiserLinkProposalRequest,
            com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal>
        getGetDisplayVideo360AdvertiserLinkProposalMethod;
    if ((getGetDisplayVideo360AdvertiserLinkProposalMethod =
            AnalyticsAdminServiceGrpc.getGetDisplayVideo360AdvertiserLinkProposalMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetDisplayVideo360AdvertiserLinkProposalMethod =
                AnalyticsAdminServiceGrpc.getGetDisplayVideo360AdvertiserLinkProposalMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getGetDisplayVideo360AdvertiserLinkProposalMethod =
              getGetDisplayVideo360AdvertiserLinkProposalMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha
                              .GetDisplayVideo360AdvertiserLinkProposalRequest,
                          com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "GetDisplayVideo360AdvertiserLinkProposal"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .GetDisplayVideo360AdvertiserLinkProposalRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .DisplayVideo360AdvertiserLinkProposal.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "GetDisplayVideo360AdvertiserLinkProposal"))
                      .build();
        }
      }
    }
    return getGetDisplayVideo360AdvertiserLinkProposalMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinkProposalsRequest,
          com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinkProposalsResponse>
      getListDisplayVideo360AdvertiserLinkProposalsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDisplayVideo360AdvertiserLinkProposals",
      requestType =
          com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinkProposalsRequest
              .class,
      responseType =
          com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinkProposalsResponse
              .class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinkProposalsRequest,
          com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinkProposalsResponse>
      getListDisplayVideo360AdvertiserLinkProposalsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinkProposalsRequest,
            com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinkProposalsResponse>
        getListDisplayVideo360AdvertiserLinkProposalsMethod;
    if ((getListDisplayVideo360AdvertiserLinkProposalsMethod =
            AnalyticsAdminServiceGrpc.getListDisplayVideo360AdvertiserLinkProposalsMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListDisplayVideo360AdvertiserLinkProposalsMethod =
                AnalyticsAdminServiceGrpc.getListDisplayVideo360AdvertiserLinkProposalsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getListDisplayVideo360AdvertiserLinkProposalsMethod =
              getListDisplayVideo360AdvertiserLinkProposalsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha
                              .ListDisplayVideo360AdvertiserLinkProposalsRequest,
                          com.google.analytics.admin.v1alpha
                              .ListDisplayVideo360AdvertiserLinkProposalsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "ListDisplayVideo360AdvertiserLinkProposals"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .ListDisplayVideo360AdvertiserLinkProposalsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .ListDisplayVideo360AdvertiserLinkProposalsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "ListDisplayVideo360AdvertiserLinkProposals"))
                      .build();
        }
      }
    }
    return getListDisplayVideo360AdvertiserLinkProposalsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateDisplayVideo360AdvertiserLinkProposalRequest,
          com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal>
      getCreateDisplayVideo360AdvertiserLinkProposalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDisplayVideo360AdvertiserLinkProposal",
      requestType =
          com.google.analytics.admin.v1alpha.CreateDisplayVideo360AdvertiserLinkProposalRequest
              .class,
      responseType = com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateDisplayVideo360AdvertiserLinkProposalRequest,
          com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal>
      getCreateDisplayVideo360AdvertiserLinkProposalMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.CreateDisplayVideo360AdvertiserLinkProposalRequest,
            com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal>
        getCreateDisplayVideo360AdvertiserLinkProposalMethod;
    if ((getCreateDisplayVideo360AdvertiserLinkProposalMethod =
            AnalyticsAdminServiceGrpc.getCreateDisplayVideo360AdvertiserLinkProposalMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateDisplayVideo360AdvertiserLinkProposalMethod =
                AnalyticsAdminServiceGrpc.getCreateDisplayVideo360AdvertiserLinkProposalMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getCreateDisplayVideo360AdvertiserLinkProposalMethod =
              getCreateDisplayVideo360AdvertiserLinkProposalMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha
                              .CreateDisplayVideo360AdvertiserLinkProposalRequest,
                          com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "CreateDisplayVideo360AdvertiserLinkProposal"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .CreateDisplayVideo360AdvertiserLinkProposalRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .DisplayVideo360AdvertiserLinkProposal.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "CreateDisplayVideo360AdvertiserLinkProposal"))
                      .build();
        }
      }
    }
    return getCreateDisplayVideo360AdvertiserLinkProposalMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteDisplayVideo360AdvertiserLinkProposalRequest,
          com.google.protobuf.Empty>
      getDeleteDisplayVideo360AdvertiserLinkProposalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDisplayVideo360AdvertiserLinkProposal",
      requestType =
          com.google.analytics.admin.v1alpha.DeleteDisplayVideo360AdvertiserLinkProposalRequest
              .class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteDisplayVideo360AdvertiserLinkProposalRequest,
          com.google.protobuf.Empty>
      getDeleteDisplayVideo360AdvertiserLinkProposalMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.DeleteDisplayVideo360AdvertiserLinkProposalRequest,
            com.google.protobuf.Empty>
        getDeleteDisplayVideo360AdvertiserLinkProposalMethod;
    if ((getDeleteDisplayVideo360AdvertiserLinkProposalMethod =
            AnalyticsAdminServiceGrpc.getDeleteDisplayVideo360AdvertiserLinkProposalMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeleteDisplayVideo360AdvertiserLinkProposalMethod =
                AnalyticsAdminServiceGrpc.getDeleteDisplayVideo360AdvertiserLinkProposalMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getDeleteDisplayVideo360AdvertiserLinkProposalMethod =
              getDeleteDisplayVideo360AdvertiserLinkProposalMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha
                              .DeleteDisplayVideo360AdvertiserLinkProposalRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "DeleteDisplayVideo360AdvertiserLinkProposal"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .DeleteDisplayVideo360AdvertiserLinkProposalRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "DeleteDisplayVideo360AdvertiserLinkProposal"))
                      .build();
        }
      }
    }
    return getDeleteDisplayVideo360AdvertiserLinkProposalMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ApproveDisplayVideo360AdvertiserLinkProposalRequest,
          com.google.analytics.admin.v1alpha.ApproveDisplayVideo360AdvertiserLinkProposalResponse>
      getApproveDisplayVideo360AdvertiserLinkProposalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ApproveDisplayVideo360AdvertiserLinkProposal",
      requestType =
          com.google.analytics.admin.v1alpha.ApproveDisplayVideo360AdvertiserLinkProposalRequest
              .class,
      responseType =
          com.google.analytics.admin.v1alpha.ApproveDisplayVideo360AdvertiserLinkProposalResponse
              .class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ApproveDisplayVideo360AdvertiserLinkProposalRequest,
          com.google.analytics.admin.v1alpha.ApproveDisplayVideo360AdvertiserLinkProposalResponse>
      getApproveDisplayVideo360AdvertiserLinkProposalMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ApproveDisplayVideo360AdvertiserLinkProposalRequest,
            com.google.analytics.admin.v1alpha.ApproveDisplayVideo360AdvertiserLinkProposalResponse>
        getApproveDisplayVideo360AdvertiserLinkProposalMethod;
    if ((getApproveDisplayVideo360AdvertiserLinkProposalMethod =
            AnalyticsAdminServiceGrpc.getApproveDisplayVideo360AdvertiserLinkProposalMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getApproveDisplayVideo360AdvertiserLinkProposalMethod =
                AnalyticsAdminServiceGrpc.getApproveDisplayVideo360AdvertiserLinkProposalMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getApproveDisplayVideo360AdvertiserLinkProposalMethod =
              getApproveDisplayVideo360AdvertiserLinkProposalMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha
                              .ApproveDisplayVideo360AdvertiserLinkProposalRequest,
                          com.google.analytics.admin.v1alpha
                              .ApproveDisplayVideo360AdvertiserLinkProposalResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "ApproveDisplayVideo360AdvertiserLinkProposal"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .ApproveDisplayVideo360AdvertiserLinkProposalRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .ApproveDisplayVideo360AdvertiserLinkProposalResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "ApproveDisplayVideo360AdvertiserLinkProposal"))
                      .build();
        }
      }
    }
    return getApproveDisplayVideo360AdvertiserLinkProposalMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CancelDisplayVideo360AdvertiserLinkProposalRequest,
          com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal>
      getCancelDisplayVideo360AdvertiserLinkProposalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelDisplayVideo360AdvertiserLinkProposal",
      requestType =
          com.google.analytics.admin.v1alpha.CancelDisplayVideo360AdvertiserLinkProposalRequest
              .class,
      responseType = com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CancelDisplayVideo360AdvertiserLinkProposalRequest,
          com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal>
      getCancelDisplayVideo360AdvertiserLinkProposalMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.CancelDisplayVideo360AdvertiserLinkProposalRequest,
            com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal>
        getCancelDisplayVideo360AdvertiserLinkProposalMethod;
    if ((getCancelDisplayVideo360AdvertiserLinkProposalMethod =
            AnalyticsAdminServiceGrpc.getCancelDisplayVideo360AdvertiserLinkProposalMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCancelDisplayVideo360AdvertiserLinkProposalMethod =
                AnalyticsAdminServiceGrpc.getCancelDisplayVideo360AdvertiserLinkProposalMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getCancelDisplayVideo360AdvertiserLinkProposalMethod =
              getCancelDisplayVideo360AdvertiserLinkProposalMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha
                              .CancelDisplayVideo360AdvertiserLinkProposalRequest,
                          com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "CancelDisplayVideo360AdvertiserLinkProposal"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .CancelDisplayVideo360AdvertiserLinkProposalRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .DisplayVideo360AdvertiserLinkProposal.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "CancelDisplayVideo360AdvertiserLinkProposal"))
                      .build();
        }
      }
    }
    return getCancelDisplayVideo360AdvertiserLinkProposalMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateCustomDimensionRequest,
          com.google.analytics.admin.v1alpha.CustomDimension>
      getCreateCustomDimensionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCustomDimension",
      requestType = com.google.analytics.admin.v1alpha.CreateCustomDimensionRequest.class,
      responseType = com.google.analytics.admin.v1alpha.CustomDimension.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateCustomDimensionRequest,
          com.google.analytics.admin.v1alpha.CustomDimension>
      getCreateCustomDimensionMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.CreateCustomDimensionRequest,
            com.google.analytics.admin.v1alpha.CustomDimension>
        getCreateCustomDimensionMethod;
    if ((getCreateCustomDimensionMethod = AnalyticsAdminServiceGrpc.getCreateCustomDimensionMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateCustomDimensionMethod =
                AnalyticsAdminServiceGrpc.getCreateCustomDimensionMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getCreateCustomDimensionMethod =
              getCreateCustomDimensionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.CreateCustomDimensionRequest,
                          com.google.analytics.admin.v1alpha.CustomDimension>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateCustomDimension"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CreateCustomDimensionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CustomDimension
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "CreateCustomDimension"))
                      .build();
        }
      }
    }
    return getCreateCustomDimensionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateCustomDimensionRequest,
          com.google.analytics.admin.v1alpha.CustomDimension>
      getUpdateCustomDimensionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCustomDimension",
      requestType = com.google.analytics.admin.v1alpha.UpdateCustomDimensionRequest.class,
      responseType = com.google.analytics.admin.v1alpha.CustomDimension.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateCustomDimensionRequest,
          com.google.analytics.admin.v1alpha.CustomDimension>
      getUpdateCustomDimensionMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.UpdateCustomDimensionRequest,
            com.google.analytics.admin.v1alpha.CustomDimension>
        getUpdateCustomDimensionMethod;
    if ((getUpdateCustomDimensionMethod = AnalyticsAdminServiceGrpc.getUpdateCustomDimensionMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateCustomDimensionMethod =
                AnalyticsAdminServiceGrpc.getUpdateCustomDimensionMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getUpdateCustomDimensionMethod =
              getUpdateCustomDimensionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.UpdateCustomDimensionRequest,
                          com.google.analytics.admin.v1alpha.CustomDimension>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateCustomDimension"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UpdateCustomDimensionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CustomDimension
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "UpdateCustomDimension"))
                      .build();
        }
      }
    }
    return getUpdateCustomDimensionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListCustomDimensionsRequest,
          com.google.analytics.admin.v1alpha.ListCustomDimensionsResponse>
      getListCustomDimensionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCustomDimensions",
      requestType = com.google.analytics.admin.v1alpha.ListCustomDimensionsRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ListCustomDimensionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListCustomDimensionsRequest,
          com.google.analytics.admin.v1alpha.ListCustomDimensionsResponse>
      getListCustomDimensionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListCustomDimensionsRequest,
            com.google.analytics.admin.v1alpha.ListCustomDimensionsResponse>
        getListCustomDimensionsMethod;
    if ((getListCustomDimensionsMethod = AnalyticsAdminServiceGrpc.getListCustomDimensionsMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListCustomDimensionsMethod =
                AnalyticsAdminServiceGrpc.getListCustomDimensionsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getListCustomDimensionsMethod =
              getListCustomDimensionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ListCustomDimensionsRequest,
                          com.google.analytics.admin.v1alpha.ListCustomDimensionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListCustomDimensions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListCustomDimensionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListCustomDimensionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("ListCustomDimensions"))
                      .build();
        }
      }
    }
    return getListCustomDimensionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ArchiveCustomDimensionRequest,
          com.google.protobuf.Empty>
      getArchiveCustomDimensionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ArchiveCustomDimension",
      requestType = com.google.analytics.admin.v1alpha.ArchiveCustomDimensionRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ArchiveCustomDimensionRequest,
          com.google.protobuf.Empty>
      getArchiveCustomDimensionMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ArchiveCustomDimensionRequest,
            com.google.protobuf.Empty>
        getArchiveCustomDimensionMethod;
    if ((getArchiveCustomDimensionMethod =
            AnalyticsAdminServiceGrpc.getArchiveCustomDimensionMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getArchiveCustomDimensionMethod =
                AnalyticsAdminServiceGrpc.getArchiveCustomDimensionMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getArchiveCustomDimensionMethod =
              getArchiveCustomDimensionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ArchiveCustomDimensionRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ArchiveCustomDimension"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ArchiveCustomDimensionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "ArchiveCustomDimension"))
                      .build();
        }
      }
    }
    return getArchiveCustomDimensionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetCustomDimensionRequest,
          com.google.analytics.admin.v1alpha.CustomDimension>
      getGetCustomDimensionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCustomDimension",
      requestType = com.google.analytics.admin.v1alpha.GetCustomDimensionRequest.class,
      responseType = com.google.analytics.admin.v1alpha.CustomDimension.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetCustomDimensionRequest,
          com.google.analytics.admin.v1alpha.CustomDimension>
      getGetCustomDimensionMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetCustomDimensionRequest,
            com.google.analytics.admin.v1alpha.CustomDimension>
        getGetCustomDimensionMethod;
    if ((getGetCustomDimensionMethod = AnalyticsAdminServiceGrpc.getGetCustomDimensionMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetCustomDimensionMethod = AnalyticsAdminServiceGrpc.getGetCustomDimensionMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getGetCustomDimensionMethod =
              getGetCustomDimensionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetCustomDimensionRequest,
                          com.google.analytics.admin.v1alpha.CustomDimension>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCustomDimension"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GetCustomDimensionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CustomDimension
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("GetCustomDimension"))
                      .build();
        }
      }
    }
    return getGetCustomDimensionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateCustomMetricRequest,
          com.google.analytics.admin.v1alpha.CustomMetric>
      getCreateCustomMetricMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCustomMetric",
      requestType = com.google.analytics.admin.v1alpha.CreateCustomMetricRequest.class,
      responseType = com.google.analytics.admin.v1alpha.CustomMetric.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateCustomMetricRequest,
          com.google.analytics.admin.v1alpha.CustomMetric>
      getCreateCustomMetricMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.CreateCustomMetricRequest,
            com.google.analytics.admin.v1alpha.CustomMetric>
        getCreateCustomMetricMethod;
    if ((getCreateCustomMetricMethod = AnalyticsAdminServiceGrpc.getCreateCustomMetricMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateCustomMetricMethod = AnalyticsAdminServiceGrpc.getCreateCustomMetricMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getCreateCustomMetricMethod =
              getCreateCustomMetricMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.CreateCustomMetricRequest,
                          com.google.analytics.admin.v1alpha.CustomMetric>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCustomMetric"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CreateCustomMetricRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CustomMetric.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("CreateCustomMetric"))
                      .build();
        }
      }
    }
    return getCreateCustomMetricMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateCustomMetricRequest,
          com.google.analytics.admin.v1alpha.CustomMetric>
      getUpdateCustomMetricMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCustomMetric",
      requestType = com.google.analytics.admin.v1alpha.UpdateCustomMetricRequest.class,
      responseType = com.google.analytics.admin.v1alpha.CustomMetric.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateCustomMetricRequest,
          com.google.analytics.admin.v1alpha.CustomMetric>
      getUpdateCustomMetricMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.UpdateCustomMetricRequest,
            com.google.analytics.admin.v1alpha.CustomMetric>
        getUpdateCustomMetricMethod;
    if ((getUpdateCustomMetricMethod = AnalyticsAdminServiceGrpc.getUpdateCustomMetricMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateCustomMetricMethod = AnalyticsAdminServiceGrpc.getUpdateCustomMetricMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getUpdateCustomMetricMethod =
              getUpdateCustomMetricMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.UpdateCustomMetricRequest,
                          com.google.analytics.admin.v1alpha.CustomMetric>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCustomMetric"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UpdateCustomMetricRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CustomMetric.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("UpdateCustomMetric"))
                      .build();
        }
      }
    }
    return getUpdateCustomMetricMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListCustomMetricsRequest,
          com.google.analytics.admin.v1alpha.ListCustomMetricsResponse>
      getListCustomMetricsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCustomMetrics",
      requestType = com.google.analytics.admin.v1alpha.ListCustomMetricsRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ListCustomMetricsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListCustomMetricsRequest,
          com.google.analytics.admin.v1alpha.ListCustomMetricsResponse>
      getListCustomMetricsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListCustomMetricsRequest,
            com.google.analytics.admin.v1alpha.ListCustomMetricsResponse>
        getListCustomMetricsMethod;
    if ((getListCustomMetricsMethod = AnalyticsAdminServiceGrpc.getListCustomMetricsMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListCustomMetricsMethod = AnalyticsAdminServiceGrpc.getListCustomMetricsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getListCustomMetricsMethod =
              getListCustomMetricsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ListCustomMetricsRequest,
                          com.google.analytics.admin.v1alpha.ListCustomMetricsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCustomMetrics"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListCustomMetricsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListCustomMetricsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("ListCustomMetrics"))
                      .build();
        }
      }
    }
    return getListCustomMetricsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ArchiveCustomMetricRequest, com.google.protobuf.Empty>
      getArchiveCustomMetricMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ArchiveCustomMetric",
      requestType = com.google.analytics.admin.v1alpha.ArchiveCustomMetricRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ArchiveCustomMetricRequest, com.google.protobuf.Empty>
      getArchiveCustomMetricMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ArchiveCustomMetricRequest,
            com.google.protobuf.Empty>
        getArchiveCustomMetricMethod;
    if ((getArchiveCustomMetricMethod = AnalyticsAdminServiceGrpc.getArchiveCustomMetricMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getArchiveCustomMetricMethod = AnalyticsAdminServiceGrpc.getArchiveCustomMetricMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getArchiveCustomMetricMethod =
              getArchiveCustomMetricMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ArchiveCustomMetricRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ArchiveCustomMetric"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ArchiveCustomMetricRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("ArchiveCustomMetric"))
                      .build();
        }
      }
    }
    return getArchiveCustomMetricMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetCustomMetricRequest,
          com.google.analytics.admin.v1alpha.CustomMetric>
      getGetCustomMetricMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCustomMetric",
      requestType = com.google.analytics.admin.v1alpha.GetCustomMetricRequest.class,
      responseType = com.google.analytics.admin.v1alpha.CustomMetric.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetCustomMetricRequest,
          com.google.analytics.admin.v1alpha.CustomMetric>
      getGetCustomMetricMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetCustomMetricRequest,
            com.google.analytics.admin.v1alpha.CustomMetric>
        getGetCustomMetricMethod;
    if ((getGetCustomMetricMethod = AnalyticsAdminServiceGrpc.getGetCustomMetricMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetCustomMetricMethod = AnalyticsAdminServiceGrpc.getGetCustomMetricMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getGetCustomMetricMethod =
              getGetCustomMetricMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetCustomMetricRequest,
                          com.google.analytics.admin.v1alpha.CustomMetric>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCustomMetric"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GetCustomMetricRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CustomMetric.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("GetCustomMetric"))
                      .build();
        }
      }
    }
    return getGetCustomMetricMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetDataRetentionSettingsRequest,
          com.google.analytics.admin.v1alpha.DataRetentionSettings>
      getGetDataRetentionSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataRetentionSettings",
      requestType = com.google.analytics.admin.v1alpha.GetDataRetentionSettingsRequest.class,
      responseType = com.google.analytics.admin.v1alpha.DataRetentionSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetDataRetentionSettingsRequest,
          com.google.analytics.admin.v1alpha.DataRetentionSettings>
      getGetDataRetentionSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetDataRetentionSettingsRequest,
            com.google.analytics.admin.v1alpha.DataRetentionSettings>
        getGetDataRetentionSettingsMethod;
    if ((getGetDataRetentionSettingsMethod =
            AnalyticsAdminServiceGrpc.getGetDataRetentionSettingsMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetDataRetentionSettingsMethod =
                AnalyticsAdminServiceGrpc.getGetDataRetentionSettingsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getGetDataRetentionSettingsMethod =
              getGetDataRetentionSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetDataRetentionSettingsRequest,
                          com.google.analytics.admin.v1alpha.DataRetentionSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetDataRetentionSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GetDataRetentionSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DataRetentionSettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "GetDataRetentionSettings"))
                      .build();
        }
      }
    }
    return getGetDataRetentionSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateDataRetentionSettingsRequest,
          com.google.analytics.admin.v1alpha.DataRetentionSettings>
      getUpdateDataRetentionSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDataRetentionSettings",
      requestType = com.google.analytics.admin.v1alpha.UpdateDataRetentionSettingsRequest.class,
      responseType = com.google.analytics.admin.v1alpha.DataRetentionSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateDataRetentionSettingsRequest,
          com.google.analytics.admin.v1alpha.DataRetentionSettings>
      getUpdateDataRetentionSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.UpdateDataRetentionSettingsRequest,
            com.google.analytics.admin.v1alpha.DataRetentionSettings>
        getUpdateDataRetentionSettingsMethod;
    if ((getUpdateDataRetentionSettingsMethod =
            AnalyticsAdminServiceGrpc.getUpdateDataRetentionSettingsMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateDataRetentionSettingsMethod =
                AnalyticsAdminServiceGrpc.getUpdateDataRetentionSettingsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getUpdateDataRetentionSettingsMethod =
              getUpdateDataRetentionSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.UpdateDataRetentionSettingsRequest,
                          com.google.analytics.admin.v1alpha.DataRetentionSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateDataRetentionSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UpdateDataRetentionSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DataRetentionSettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "UpdateDataRetentionSettings"))
                      .build();
        }
      }
    }
    return getUpdateDataRetentionSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateDataStreamRequest,
          com.google.analytics.admin.v1alpha.DataStream>
      getCreateDataStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDataStream",
      requestType = com.google.analytics.admin.v1alpha.CreateDataStreamRequest.class,
      responseType = com.google.analytics.admin.v1alpha.DataStream.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateDataStreamRequest,
          com.google.analytics.admin.v1alpha.DataStream>
      getCreateDataStreamMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.CreateDataStreamRequest,
            com.google.analytics.admin.v1alpha.DataStream>
        getCreateDataStreamMethod;
    if ((getCreateDataStreamMethod = AnalyticsAdminServiceGrpc.getCreateDataStreamMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateDataStreamMethod = AnalyticsAdminServiceGrpc.getCreateDataStreamMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getCreateDataStreamMethod =
              getCreateDataStreamMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.CreateDataStreamRequest,
                          com.google.analytics.admin.v1alpha.DataStream>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDataStream"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CreateDataStreamRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DataStream.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("CreateDataStream"))
                      .build();
        }
      }
    }
    return getCreateDataStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteDataStreamRequest, com.google.protobuf.Empty>
      getDeleteDataStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDataStream",
      requestType = com.google.analytics.admin.v1alpha.DeleteDataStreamRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteDataStreamRequest, com.google.protobuf.Empty>
      getDeleteDataStreamMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.DeleteDataStreamRequest, com.google.protobuf.Empty>
        getDeleteDataStreamMethod;
    if ((getDeleteDataStreamMethod = AnalyticsAdminServiceGrpc.getDeleteDataStreamMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeleteDataStreamMethod = AnalyticsAdminServiceGrpc.getDeleteDataStreamMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getDeleteDataStreamMethod =
              getDeleteDataStreamMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.DeleteDataStreamRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDataStream"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DeleteDataStreamRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("DeleteDataStream"))
                      .build();
        }
      }
    }
    return getDeleteDataStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateDataStreamRequest,
          com.google.analytics.admin.v1alpha.DataStream>
      getUpdateDataStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDataStream",
      requestType = com.google.analytics.admin.v1alpha.UpdateDataStreamRequest.class,
      responseType = com.google.analytics.admin.v1alpha.DataStream.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateDataStreamRequest,
          com.google.analytics.admin.v1alpha.DataStream>
      getUpdateDataStreamMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.UpdateDataStreamRequest,
            com.google.analytics.admin.v1alpha.DataStream>
        getUpdateDataStreamMethod;
    if ((getUpdateDataStreamMethod = AnalyticsAdminServiceGrpc.getUpdateDataStreamMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateDataStreamMethod = AnalyticsAdminServiceGrpc.getUpdateDataStreamMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getUpdateDataStreamMethod =
              getUpdateDataStreamMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.UpdateDataStreamRequest,
                          com.google.analytics.admin.v1alpha.DataStream>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDataStream"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UpdateDataStreamRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DataStream.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("UpdateDataStream"))
                      .build();
        }
      }
    }
    return getUpdateDataStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListDataStreamsRequest,
          com.google.analytics.admin.v1alpha.ListDataStreamsResponse>
      getListDataStreamsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDataStreams",
      requestType = com.google.analytics.admin.v1alpha.ListDataStreamsRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ListDataStreamsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListDataStreamsRequest,
          com.google.analytics.admin.v1alpha.ListDataStreamsResponse>
      getListDataStreamsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListDataStreamsRequest,
            com.google.analytics.admin.v1alpha.ListDataStreamsResponse>
        getListDataStreamsMethod;
    if ((getListDataStreamsMethod = AnalyticsAdminServiceGrpc.getListDataStreamsMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListDataStreamsMethod = AnalyticsAdminServiceGrpc.getListDataStreamsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getListDataStreamsMethod =
              getListDataStreamsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ListDataStreamsRequest,
                          com.google.analytics.admin.v1alpha.ListDataStreamsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDataStreams"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListDataStreamsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListDataStreamsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("ListDataStreams"))
                      .build();
        }
      }
    }
    return getListDataStreamsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetDataStreamRequest,
          com.google.analytics.admin.v1alpha.DataStream>
      getGetDataStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataStream",
      requestType = com.google.analytics.admin.v1alpha.GetDataStreamRequest.class,
      responseType = com.google.analytics.admin.v1alpha.DataStream.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetDataStreamRequest,
          com.google.analytics.admin.v1alpha.DataStream>
      getGetDataStreamMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetDataStreamRequest,
            com.google.analytics.admin.v1alpha.DataStream>
        getGetDataStreamMethod;
    if ((getGetDataStreamMethod = AnalyticsAdminServiceGrpc.getGetDataStreamMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetDataStreamMethod = AnalyticsAdminServiceGrpc.getGetDataStreamMethod) == null) {
          AnalyticsAdminServiceGrpc.getGetDataStreamMethod =
              getGetDataStreamMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetDataStreamRequest,
                          com.google.analytics.admin.v1alpha.DataStream>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataStream"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GetDataStreamRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DataStream.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("GetDataStream"))
                      .build();
        }
      }
    }
    return getGetDataStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetAudienceRequest,
          com.google.analytics.admin.v1alpha.Audience>
      getGetAudienceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAudience",
      requestType = com.google.analytics.admin.v1alpha.GetAudienceRequest.class,
      responseType = com.google.analytics.admin.v1alpha.Audience.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetAudienceRequest,
          com.google.analytics.admin.v1alpha.Audience>
      getGetAudienceMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetAudienceRequest,
            com.google.analytics.admin.v1alpha.Audience>
        getGetAudienceMethod;
    if ((getGetAudienceMethod = AnalyticsAdminServiceGrpc.getGetAudienceMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetAudienceMethod = AnalyticsAdminServiceGrpc.getGetAudienceMethod) == null) {
          AnalyticsAdminServiceGrpc.getGetAudienceMethod =
              getGetAudienceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetAudienceRequest,
                          com.google.analytics.admin.v1alpha.Audience>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAudience"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GetAudienceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.Audience.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("GetAudience"))
                      .build();
        }
      }
    }
    return getGetAudienceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListAudiencesRequest,
          com.google.analytics.admin.v1alpha.ListAudiencesResponse>
      getListAudiencesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAudiences",
      requestType = com.google.analytics.admin.v1alpha.ListAudiencesRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ListAudiencesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListAudiencesRequest,
          com.google.analytics.admin.v1alpha.ListAudiencesResponse>
      getListAudiencesMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListAudiencesRequest,
            com.google.analytics.admin.v1alpha.ListAudiencesResponse>
        getListAudiencesMethod;
    if ((getListAudiencesMethod = AnalyticsAdminServiceGrpc.getListAudiencesMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListAudiencesMethod = AnalyticsAdminServiceGrpc.getListAudiencesMethod) == null) {
          AnalyticsAdminServiceGrpc.getListAudiencesMethod =
              getListAudiencesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ListAudiencesRequest,
                          com.google.analytics.admin.v1alpha.ListAudiencesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAudiences"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListAudiencesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListAudiencesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("ListAudiences"))
                      .build();
        }
      }
    }
    return getListAudiencesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateAudienceRequest,
          com.google.analytics.admin.v1alpha.Audience>
      getCreateAudienceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAudience",
      requestType = com.google.analytics.admin.v1alpha.CreateAudienceRequest.class,
      responseType = com.google.analytics.admin.v1alpha.Audience.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateAudienceRequest,
          com.google.analytics.admin.v1alpha.Audience>
      getCreateAudienceMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.CreateAudienceRequest,
            com.google.analytics.admin.v1alpha.Audience>
        getCreateAudienceMethod;
    if ((getCreateAudienceMethod = AnalyticsAdminServiceGrpc.getCreateAudienceMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateAudienceMethod = AnalyticsAdminServiceGrpc.getCreateAudienceMethod) == null) {
          AnalyticsAdminServiceGrpc.getCreateAudienceMethod =
              getCreateAudienceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.CreateAudienceRequest,
                          com.google.analytics.admin.v1alpha.Audience>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAudience"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CreateAudienceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.Audience.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("CreateAudience"))
                      .build();
        }
      }
    }
    return getCreateAudienceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateAudienceRequest,
          com.google.analytics.admin.v1alpha.Audience>
      getUpdateAudienceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAudience",
      requestType = com.google.analytics.admin.v1alpha.UpdateAudienceRequest.class,
      responseType = com.google.analytics.admin.v1alpha.Audience.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateAudienceRequest,
          com.google.analytics.admin.v1alpha.Audience>
      getUpdateAudienceMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.UpdateAudienceRequest,
            com.google.analytics.admin.v1alpha.Audience>
        getUpdateAudienceMethod;
    if ((getUpdateAudienceMethod = AnalyticsAdminServiceGrpc.getUpdateAudienceMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateAudienceMethod = AnalyticsAdminServiceGrpc.getUpdateAudienceMethod) == null) {
          AnalyticsAdminServiceGrpc.getUpdateAudienceMethod =
              getUpdateAudienceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.UpdateAudienceRequest,
                          com.google.analytics.admin.v1alpha.Audience>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAudience"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UpdateAudienceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.Audience.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("UpdateAudience"))
                      .build();
        }
      }
    }
    return getUpdateAudienceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ArchiveAudienceRequest, com.google.protobuf.Empty>
      getArchiveAudienceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ArchiveAudience",
      requestType = com.google.analytics.admin.v1alpha.ArchiveAudienceRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ArchiveAudienceRequest, com.google.protobuf.Empty>
      getArchiveAudienceMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ArchiveAudienceRequest, com.google.protobuf.Empty>
        getArchiveAudienceMethod;
    if ((getArchiveAudienceMethod = AnalyticsAdminServiceGrpc.getArchiveAudienceMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getArchiveAudienceMethod = AnalyticsAdminServiceGrpc.getArchiveAudienceMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getArchiveAudienceMethod =
              getArchiveAudienceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ArchiveAudienceRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ArchiveAudience"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ArchiveAudienceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("ArchiveAudience"))
                      .build();
        }
      }
    }
    return getArchiveAudienceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetAttributionSettingsRequest,
          com.google.analytics.admin.v1alpha.AttributionSettings>
      getGetAttributionSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAttributionSettings",
      requestType = com.google.analytics.admin.v1alpha.GetAttributionSettingsRequest.class,
      responseType = com.google.analytics.admin.v1alpha.AttributionSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetAttributionSettingsRequest,
          com.google.analytics.admin.v1alpha.AttributionSettings>
      getGetAttributionSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetAttributionSettingsRequest,
            com.google.analytics.admin.v1alpha.AttributionSettings>
        getGetAttributionSettingsMethod;
    if ((getGetAttributionSettingsMethod =
            AnalyticsAdminServiceGrpc.getGetAttributionSettingsMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetAttributionSettingsMethod =
                AnalyticsAdminServiceGrpc.getGetAttributionSettingsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getGetAttributionSettingsMethod =
              getGetAttributionSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetAttributionSettingsRequest,
                          com.google.analytics.admin.v1alpha.AttributionSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetAttributionSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GetAttributionSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.AttributionSettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "GetAttributionSettings"))
                      .build();
        }
      }
    }
    return getGetAttributionSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateAttributionSettingsRequest,
          com.google.analytics.admin.v1alpha.AttributionSettings>
      getUpdateAttributionSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAttributionSettings",
      requestType = com.google.analytics.admin.v1alpha.UpdateAttributionSettingsRequest.class,
      responseType = com.google.analytics.admin.v1alpha.AttributionSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateAttributionSettingsRequest,
          com.google.analytics.admin.v1alpha.AttributionSettings>
      getUpdateAttributionSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.UpdateAttributionSettingsRequest,
            com.google.analytics.admin.v1alpha.AttributionSettings>
        getUpdateAttributionSettingsMethod;
    if ((getUpdateAttributionSettingsMethod =
            AnalyticsAdminServiceGrpc.getUpdateAttributionSettingsMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateAttributionSettingsMethod =
                AnalyticsAdminServiceGrpc.getUpdateAttributionSettingsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getUpdateAttributionSettingsMethod =
              getUpdateAttributionSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.UpdateAttributionSettingsRequest,
                          com.google.analytics.admin.v1alpha.AttributionSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateAttributionSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UpdateAttributionSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.AttributionSettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "UpdateAttributionSettings"))
                      .build();
        }
      }
    }
    return getUpdateAttributionSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.RunAccessReportRequest,
          com.google.analytics.admin.v1alpha.RunAccessReportResponse>
      getRunAccessReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RunAccessReport",
      requestType = com.google.analytics.admin.v1alpha.RunAccessReportRequest.class,
      responseType = com.google.analytics.admin.v1alpha.RunAccessReportResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.RunAccessReportRequest,
          com.google.analytics.admin.v1alpha.RunAccessReportResponse>
      getRunAccessReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.RunAccessReportRequest,
            com.google.analytics.admin.v1alpha.RunAccessReportResponse>
        getRunAccessReportMethod;
    if ((getRunAccessReportMethod = AnalyticsAdminServiceGrpc.getRunAccessReportMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getRunAccessReportMethod = AnalyticsAdminServiceGrpc.getRunAccessReportMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getRunAccessReportMethod =
              getRunAccessReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.RunAccessReportRequest,
                          com.google.analytics.admin.v1alpha.RunAccessReportResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RunAccessReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.RunAccessReportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.RunAccessReportResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("RunAccessReport"))
                      .build();
        }
      }
    }
    return getRunAccessReportMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AnalyticsAdminServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AnalyticsAdminServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AnalyticsAdminServiceStub>() {
          @java.lang.Override
          public AnalyticsAdminServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AnalyticsAdminServiceStub(channel, callOptions);
          }
        };
    return AnalyticsAdminServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AnalyticsAdminServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AnalyticsAdminServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AnalyticsAdminServiceBlockingStub>() {
          @java.lang.Override
          public AnalyticsAdminServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AnalyticsAdminServiceBlockingStub(channel, callOptions);
          }
        };
    return AnalyticsAdminServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AnalyticsAdminServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AnalyticsAdminServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AnalyticsAdminServiceFutureStub>() {
          @java.lang.Override
          public AnalyticsAdminServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AnalyticsAdminServiceFutureStub(channel, callOptions);
          }
        };
    return AnalyticsAdminServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service Interface for the Analytics Admin API (GA4).
   * </pre>
   */
  public abstract static class AnalyticsAdminServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Lookup for a single Account.
     * </pre>
     */
    public void getAccount(
        com.google.analytics.admin.v1alpha.GetAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Account> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAccountMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns all accounts accessible by the caller.
     * Note that these accounts might not currently have GA4 properties.
     * Soft-deleted (ie: "trashed") accounts are excluded by default.
     * Returns an empty list if no relevant accounts are found.
     * </pre>
     */
    public void listAccounts(
        com.google.analytics.admin.v1alpha.ListAccountsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListAccountsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAccountsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Marks target Account as soft-deleted (ie: "trashed") and returns it.
     * This API does not have a method to restore soft-deleted accounts.
     * However, they can be restored using the Trash Can UI.
     * If the accounts are not restored before the expiration time, the account
     * and all child resources (eg: Properties, GoogleAdsLinks, Streams,
     * UserLinks) will be permanently purged.
     * https://support.google.com/analytics/answer/6154772
     * Returns an error if the target is not found.
     * </pre>
     */
    public void deleteAccount(
        com.google.analytics.admin.v1alpha.DeleteAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAccountMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an account.
     * </pre>
     */
    public void updateAccount(
        com.google.analytics.admin.v1alpha.UpdateAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Account> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAccountMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Requests a ticket for creating an account.
     * </pre>
     */
    public void provisionAccountTicket(
        com.google.analytics.admin.v1alpha.ProvisionAccountTicketRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.ProvisionAccountTicketResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getProvisionAccountTicketMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns summaries of all accounts accessible by the caller.
     * </pre>
     */
    public void listAccountSummaries(
        com.google.analytics.admin.v1alpha.ListAccountSummariesRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListAccountSummariesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAccountSummariesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single "GA4" Property.
     * </pre>
     */
    public void getProperty(
        com.google.analytics.admin.v1alpha.GetPropertyRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Property> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetPropertyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns child Properties under the specified parent Account.
     * Only "GA4" properties will be returned.
     * Properties will be excluded if the caller does not have access.
     * Soft-deleted (ie: "trashed") properties are excluded by default.
     * Returns an empty list if no relevant properties are found.
     * </pre>
     */
    public void listProperties(
        com.google.analytics.admin.v1alpha.ListPropertiesRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListPropertiesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPropertiesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an "GA4" property with the specified location and attributes.
     * </pre>
     */
    public void createProperty(
        com.google.analytics.admin.v1alpha.CreatePropertyRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Property> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreatePropertyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Marks target Property as soft-deleted (ie: "trashed") and returns it.
     * This API does not have a method to restore soft-deleted properties.
     * However, they can be restored using the Trash Can UI.
     * If the properties are not restored before the expiration time, the Property
     * and all child resources (eg: GoogleAdsLinks, Streams, UserLinks)
     * will be permanently purged.
     * https://support.google.com/analytics/answer/6154772
     * Returns an error if the target is not found, or is not an GA4 Property.
     * </pre>
     */
    public void deleteProperty(
        com.google.analytics.admin.v1alpha.DeletePropertyRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Property> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeletePropertyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a property.
     * </pre>
     */
    public void updateProperty(
        com.google.analytics.admin.v1alpha.UpdatePropertyRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Property> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdatePropertyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a user's link to an account or property.
     * </pre>
     */
    public void getUserLink(
        com.google.analytics.admin.v1alpha.GetUserLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.UserLink> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetUserLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information about multiple users' links to an account or property.
     * </pre>
     */
    public void batchGetUserLinks(
        com.google.analytics.admin.v1alpha.BatchGetUserLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.BatchGetUserLinksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchGetUserLinksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all user links on an account or property.
     * </pre>
     */
    public void listUserLinks(
        com.google.analytics.admin.v1alpha.ListUserLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListUserLinksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListUserLinksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all user links on an account or property, including implicit ones
     * that come from effective permissions granted by groups or organization
     * admin roles.
     * If a returned user link does not have direct permissions, they cannot
     * be removed from the account or property directly with the DeleteUserLink
     * command. They have to be removed from the group/etc that gives them
     * permissions, which is currently only usable/discoverable in the GA or GMP
     * UIs.
     * </pre>
     */
    public void auditUserLinks(
        com.google.analytics.admin.v1alpha.AuditUserLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AuditUserLinksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAuditUserLinksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a user link on an account or property.
     * If the user with the specified email already has permissions on the
     * account or property, then the user's existing permissions will be unioned
     * with the permissions specified in the new UserLink.
     * </pre>
     */
    public void createUserLink(
        com.google.analytics.admin.v1alpha.CreateUserLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.UserLink> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateUserLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates information about multiple users' links to an account or property.
     * This method is transactional. If any UserLink cannot be created, none of
     * the UserLinks will be created.
     * </pre>
     */
    public void batchCreateUserLinks(
        com.google.analytics.admin.v1alpha.BatchCreateUserLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.BatchCreateUserLinksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchCreateUserLinksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a user link on an account or property.
     * </pre>
     */
    public void updateUserLink(
        com.google.analytics.admin.v1alpha.UpdateUserLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.UserLink> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateUserLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates information about multiple users' links to an account or property.
     * </pre>
     */
    public void batchUpdateUserLinks(
        com.google.analytics.admin.v1alpha.BatchUpdateUserLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.BatchUpdateUserLinksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchUpdateUserLinksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a user link on an account or property.
     * </pre>
     */
    public void deleteUserLink(
        com.google.analytics.admin.v1alpha.DeleteUserLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteUserLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes information about multiple users' links to an account or property.
     * </pre>
     */
    public void batchDeleteUserLinks(
        com.google.analytics.admin.v1alpha.BatchDeleteUserLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchDeleteUserLinksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a FirebaseLink.
     * Properties can have at most one FirebaseLink.
     * </pre>
     */
    public void createFirebaseLink(
        com.google.analytics.admin.v1alpha.CreateFirebaseLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.FirebaseLink>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateFirebaseLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a FirebaseLink on a property
     * </pre>
     */
    public void deleteFirebaseLink(
        com.google.analytics.admin.v1alpha.DeleteFirebaseLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteFirebaseLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists FirebaseLinks on a property.
     * Properties can have at most one FirebaseLink.
     * </pre>
     */
    public void listFirebaseLinks(
        com.google.analytics.admin.v1alpha.ListFirebaseLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListFirebaseLinksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListFirebaseLinksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the Site Tag for the specified web stream.
     * Site Tags are immutable singletons.
     * </pre>
     */
    public void getGlobalSiteTag(
        com.google.analytics.admin.v1alpha.GetGlobalSiteTagRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.GlobalSiteTag>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetGlobalSiteTagMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a GoogleAdsLink.
     * </pre>
     */
    public void createGoogleAdsLink(
        com.google.analytics.admin.v1alpha.CreateGoogleAdsLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.GoogleAdsLink>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateGoogleAdsLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a GoogleAdsLink on a property
     * </pre>
     */
    public void updateGoogleAdsLink(
        com.google.analytics.admin.v1alpha.UpdateGoogleAdsLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.GoogleAdsLink>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateGoogleAdsLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a GoogleAdsLink on a property
     * </pre>
     */
    public void deleteGoogleAdsLink(
        com.google.analytics.admin.v1alpha.DeleteGoogleAdsLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteGoogleAdsLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists GoogleAdsLinks on a property.
     * </pre>
     */
    public void listGoogleAdsLinks(
        com.google.analytics.admin.v1alpha.ListGoogleAdsLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListGoogleAdsLinksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListGoogleAdsLinksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get data sharing settings on an account.
     * Data sharing settings are singletons.
     * </pre>
     */
    public void getDataSharingSettings(
        com.google.analytics.admin.v1alpha.GetDataSharingSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.DataSharingSettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDataSharingSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single "GA4" MeasurementProtocolSecret.
     * </pre>
     */
    public void getMeasurementProtocolSecret(
        com.google.analytics.admin.v1alpha.GetMeasurementProtocolSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.MeasurementProtocolSecret>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetMeasurementProtocolSecretMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns child MeasurementProtocolSecrets under the specified parent
     * Property.
     * </pre>
     */
    public void listMeasurementProtocolSecrets(
        com.google.analytics.admin.v1alpha.ListMeasurementProtocolSecretsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.ListMeasurementProtocolSecretsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMeasurementProtocolSecretsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a measurement protocol secret.
     * </pre>
     */
    public void createMeasurementProtocolSecret(
        com.google.analytics.admin.v1alpha.CreateMeasurementProtocolSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.MeasurementProtocolSecret>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateMeasurementProtocolSecretMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes target MeasurementProtocolSecret.
     * </pre>
     */
    public void deleteMeasurementProtocolSecret(
        com.google.analytics.admin.v1alpha.DeleteMeasurementProtocolSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteMeasurementProtocolSecretMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a measurement protocol secret.
     * </pre>
     */
    public void updateMeasurementProtocolSecret(
        com.google.analytics.admin.v1alpha.UpdateMeasurementProtocolSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.MeasurementProtocolSecret>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateMeasurementProtocolSecretMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Acknowledges the terms of user data collection for the specified property.
     * This acknowledgement must be completed (either in the Google Analytics UI
     * or via this API) before MeasurementProtocolSecret resources may be created.
     * </pre>
     */
    public void acknowledgeUserDataCollection(
        com.google.analytics.admin.v1alpha.AcknowledgeUserDataCollectionRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.AcknowledgeUserDataCollectionResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAcknowledgeUserDataCollectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches through all changes to an account or its children given the
     * specified set of filters.
     * </pre>
     */
    public void searchChangeHistoryEvents(
        com.google.analytics.admin.v1alpha.SearchChangeHistoryEventsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.SearchChangeHistoryEventsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchChangeHistoryEventsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for Google Signals settings for a property.
     * </pre>
     */
    public void getGoogleSignalsSettings(
        com.google.analytics.admin.v1alpha.GetGoogleSignalsSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.GoogleSignalsSettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetGoogleSignalsSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates Google Signals settings for a property.
     * </pre>
     */
    public void updateGoogleSignalsSettings(
        com.google.analytics.admin.v1alpha.UpdateGoogleSignalsSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.GoogleSignalsSettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateGoogleSignalsSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a conversion event with the specified attributes.
     * </pre>
     */
    public void createConversionEvent(
        com.google.analytics.admin.v1alpha.CreateConversionEventRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ConversionEvent>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateConversionEventMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single conversion event.
     * </pre>
     */
    public void getConversionEvent(
        com.google.analytics.admin.v1alpha.GetConversionEventRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ConversionEvent>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetConversionEventMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a conversion event in a property.
     * </pre>
     */
    public void deleteConversionEvent(
        com.google.analytics.admin.v1alpha.DeleteConversionEventRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteConversionEventMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of conversion events in the specified parent property.
     * Returns an empty list if no conversion events are found.
     * </pre>
     */
    public void listConversionEvents(
        com.google.analytics.admin.v1alpha.ListConversionEventsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListConversionEventsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListConversionEventsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Look up a single DisplayVideo360AdvertiserLink
     * </pre>
     */
    public void getDisplayVideo360AdvertiserLink(
        com.google.analytics.admin.v1alpha.GetDisplayVideo360AdvertiserLinkRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDisplayVideo360AdvertiserLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all DisplayVideo360AdvertiserLinks on a property.
     * </pre>
     */
    public void listDisplayVideo360AdvertiserLinks(
        com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinksRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDisplayVideo360AdvertiserLinksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a DisplayVideo360AdvertiserLink.
     * This can only be utilized by users who have proper authorization both on
     * the Google Analytics property and on the Display &amp; Video 360 advertiser.
     * Users who do not have access to the Display &amp; Video 360 advertiser should
     * instead seek to create a DisplayVideo360LinkProposal.
     * </pre>
     */
    public void createDisplayVideo360AdvertiserLink(
        com.google.analytics.admin.v1alpha.CreateDisplayVideo360AdvertiserLinkRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDisplayVideo360AdvertiserLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a DisplayVideo360AdvertiserLink on a property.
     * </pre>
     */
    public void deleteDisplayVideo360AdvertiserLink(
        com.google.analytics.admin.v1alpha.DeleteDisplayVideo360AdvertiserLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDisplayVideo360AdvertiserLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a DisplayVideo360AdvertiserLink on a property.
     * </pre>
     */
    public void updateDisplayVideo360AdvertiserLink(
        com.google.analytics.admin.v1alpha.UpdateDisplayVideo360AdvertiserLinkRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDisplayVideo360AdvertiserLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single DisplayVideo360AdvertiserLinkProposal.
     * </pre>
     */
    public void getDisplayVideo360AdvertiserLinkProposal(
        com.google.analytics.admin.v1alpha.GetDisplayVideo360AdvertiserLinkProposalRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDisplayVideo360AdvertiserLinkProposalMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DisplayVideo360AdvertiserLinkProposals on a property.
     * </pre>
     */
    public void listDisplayVideo360AdvertiserLinkProposals(
        com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinkProposalsRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha
                    .ListDisplayVideo360AdvertiserLinkProposalsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDisplayVideo360AdvertiserLinkProposalsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a DisplayVideo360AdvertiserLinkProposal.
     * </pre>
     */
    public void createDisplayVideo360AdvertiserLinkProposal(
        com.google.analytics.admin.v1alpha.CreateDisplayVideo360AdvertiserLinkProposalRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDisplayVideo360AdvertiserLinkProposalMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a DisplayVideo360AdvertiserLinkProposal on a property.
     * This can only be used on cancelled proposals.
     * </pre>
     */
    public void deleteDisplayVideo360AdvertiserLinkProposal(
        com.google.analytics.admin.v1alpha.DeleteDisplayVideo360AdvertiserLinkProposalRequest
            request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDisplayVideo360AdvertiserLinkProposalMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Approves a DisplayVideo360AdvertiserLinkProposal.
     * The DisplayVideo360AdvertiserLinkProposal will be deleted and a new
     * DisplayVideo360AdvertiserLink will be created.
     * </pre>
     */
    public void approveDisplayVideo360AdvertiserLinkProposal(
        com.google.analytics.admin.v1alpha.ApproveDisplayVideo360AdvertiserLinkProposalRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha
                    .ApproveDisplayVideo360AdvertiserLinkProposalResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getApproveDisplayVideo360AdvertiserLinkProposalMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels a DisplayVideo360AdvertiserLinkProposal.
     * Cancelling can mean either:
     * - Declining a proposal initiated from Display &amp; Video 360
     * - Withdrawing a proposal initiated from Google Analytics
     * After being cancelled, a proposal will eventually be deleted automatically.
     * </pre>
     */
    public void cancelDisplayVideo360AdvertiserLinkProposal(
        com.google.analytics.admin.v1alpha.CancelDisplayVideo360AdvertiserLinkProposalRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCancelDisplayVideo360AdvertiserLinkProposalMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a CustomDimension.
     * </pre>
     */
    public void createCustomDimension(
        com.google.analytics.admin.v1alpha.CreateCustomDimensionRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.CustomDimension>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCustomDimensionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a CustomDimension on a property.
     * </pre>
     */
    public void updateCustomDimension(
        com.google.analytics.admin.v1alpha.UpdateCustomDimensionRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.CustomDimension>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateCustomDimensionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists CustomDimensions on a property.
     * </pre>
     */
    public void listCustomDimensions(
        com.google.analytics.admin.v1alpha.ListCustomDimensionsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListCustomDimensionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCustomDimensionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Archives a CustomDimension on a property.
     * </pre>
     */
    public void archiveCustomDimension(
        com.google.analytics.admin.v1alpha.ArchiveCustomDimensionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getArchiveCustomDimensionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single CustomDimension.
     * </pre>
     */
    public void getCustomDimension(
        com.google.analytics.admin.v1alpha.GetCustomDimensionRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.CustomDimension>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCustomDimensionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a CustomMetric.
     * </pre>
     */
    public void createCustomMetric(
        com.google.analytics.admin.v1alpha.CreateCustomMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.CustomMetric>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCustomMetricMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a CustomMetric on a property.
     * </pre>
     */
    public void updateCustomMetric(
        com.google.analytics.admin.v1alpha.UpdateCustomMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.CustomMetric>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateCustomMetricMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists CustomMetrics on a property.
     * </pre>
     */
    public void listCustomMetrics(
        com.google.analytics.admin.v1alpha.ListCustomMetricsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListCustomMetricsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCustomMetricsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Archives a CustomMetric on a property.
     * </pre>
     */
    public void archiveCustomMetric(
        com.google.analytics.admin.v1alpha.ArchiveCustomMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getArchiveCustomMetricMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single CustomMetric.
     * </pre>
     */
    public void getCustomMetric(
        com.google.analytics.admin.v1alpha.GetCustomMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.CustomMetric>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCustomMetricMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the singleton data retention settings for this property.
     * </pre>
     */
    public void getDataRetentionSettings(
        com.google.analytics.admin.v1alpha.GetDataRetentionSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.DataRetentionSettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDataRetentionSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the singleton data retention settings for this property.
     * </pre>
     */
    public void updateDataRetentionSettings(
        com.google.analytics.admin.v1alpha.UpdateDataRetentionSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.DataRetentionSettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDataRetentionSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a DataStream.
     * </pre>
     */
    public void createDataStream(
        com.google.analytics.admin.v1alpha.CreateDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.DataStream>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDataStreamMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a DataStream on a property.
     * </pre>
     */
    public void deleteDataStream(
        com.google.analytics.admin.v1alpha.DeleteDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDataStreamMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a DataStream on a property.
     * </pre>
     */
    public void updateDataStream(
        com.google.analytics.admin.v1alpha.UpdateDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.DataStream>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDataStreamMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DataStreams on a property.
     * </pre>
     */
    public void listDataStreams(
        com.google.analytics.admin.v1alpha.ListDataStreamsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListDataStreamsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDataStreamsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single DataStream.
     * </pre>
     */
    public void getDataStream(
        com.google.analytics.admin.v1alpha.GetDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.DataStream>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDataStreamMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single Audience.
     * Audiences created before 2020 may not be supported.
     * </pre>
     */
    public void getAudience(
        com.google.analytics.admin.v1alpha.GetAudienceRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Audience> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAudienceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Audiences on a property.
     * Audiences created before 2020 may not be supported.
     * </pre>
     */
    public void listAudiences(
        com.google.analytics.admin.v1alpha.ListAudiencesRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListAudiencesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAudiencesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an Audience.
     * </pre>
     */
    public void createAudience(
        com.google.analytics.admin.v1alpha.CreateAudienceRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Audience> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAudienceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an Audience on a property.
     * </pre>
     */
    public void updateAudience(
        com.google.analytics.admin.v1alpha.UpdateAudienceRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Audience> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAudienceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Archives an Audience on a property.
     * </pre>
     */
    public void archiveAudience(
        com.google.analytics.admin.v1alpha.ArchiveAudienceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getArchiveAudienceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a AttributionSettings singleton.
     * </pre>
     */
    public void getAttributionSettings(
        com.google.analytics.admin.v1alpha.GetAttributionSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AttributionSettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAttributionSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates attribution settings on a property.
     * </pre>
     */
    public void updateAttributionSettings(
        com.google.analytics.admin.v1alpha.UpdateAttributionSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AttributionSettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAttributionSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a customized report of data access records. The report provides
     * records of each time a user reads Google Analytics reporting data. Access
     * records are retained for up to 2 years.
     * Data Access Reports can be requested for a property. The property must be
     * in Google Analytics 360. This method is only available to Administrators.
     * These data access records include GA4 UI Reporting, GA4 UI Explorations,
     * GA4 Data API, and other products like Firebase &amp; Admob that can retrieve
     * data from Google Analytics through a linkage. These records don't include
     * property configuration changes like adding a stream or changing a
     * property's time zone. For configuration change history, see
     * [searchChangeHistoryEvents](https://developers.google.com/analytics/devguides/config/admin/v1/rest/v1alpha/accounts/searchChangeHistoryEvents).
     * </pre>
     */
    public void runAccessReport(
        com.google.analytics.admin.v1alpha.RunAccessReportRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.RunAccessReportResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRunAccessReportMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getGetAccountMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.GetAccountRequest,
                      com.google.analytics.admin.v1alpha.Account>(this, METHODID_GET_ACCOUNT)))
          .addMethod(
              getListAccountsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.ListAccountsRequest,
                      com.google.analytics.admin.v1alpha.ListAccountsResponse>(
                      this, METHODID_LIST_ACCOUNTS)))
          .addMethod(
              getDeleteAccountMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.DeleteAccountRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_ACCOUNT)))
          .addMethod(
              getUpdateAccountMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.UpdateAccountRequest,
                      com.google.analytics.admin.v1alpha.Account>(this, METHODID_UPDATE_ACCOUNT)))
          .addMethod(
              getProvisionAccountTicketMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.ProvisionAccountTicketRequest,
                      com.google.analytics.admin.v1alpha.ProvisionAccountTicketResponse>(
                      this, METHODID_PROVISION_ACCOUNT_TICKET)))
          .addMethod(
              getListAccountSummariesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.ListAccountSummariesRequest,
                      com.google.analytics.admin.v1alpha.ListAccountSummariesResponse>(
                      this, METHODID_LIST_ACCOUNT_SUMMARIES)))
          .addMethod(
              getGetPropertyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.GetPropertyRequest,
                      com.google.analytics.admin.v1alpha.Property>(this, METHODID_GET_PROPERTY)))
          .addMethod(
              getListPropertiesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.ListPropertiesRequest,
                      com.google.analytics.admin.v1alpha.ListPropertiesResponse>(
                      this, METHODID_LIST_PROPERTIES)))
          .addMethod(
              getCreatePropertyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.CreatePropertyRequest,
                      com.google.analytics.admin.v1alpha.Property>(this, METHODID_CREATE_PROPERTY)))
          .addMethod(
              getDeletePropertyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.DeletePropertyRequest,
                      com.google.analytics.admin.v1alpha.Property>(this, METHODID_DELETE_PROPERTY)))
          .addMethod(
              getUpdatePropertyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.UpdatePropertyRequest,
                      com.google.analytics.admin.v1alpha.Property>(this, METHODID_UPDATE_PROPERTY)))
          .addMethod(
              getGetUserLinkMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.GetUserLinkRequest,
                      com.google.analytics.admin.v1alpha.UserLink>(this, METHODID_GET_USER_LINK)))
          .addMethod(
              getBatchGetUserLinksMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.BatchGetUserLinksRequest,
                      com.google.analytics.admin.v1alpha.BatchGetUserLinksResponse>(
                      this, METHODID_BATCH_GET_USER_LINKS)))
          .addMethod(
              getListUserLinksMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.ListUserLinksRequest,
                      com.google.analytics.admin.v1alpha.ListUserLinksResponse>(
                      this, METHODID_LIST_USER_LINKS)))
          .addMethod(
              getAuditUserLinksMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.AuditUserLinksRequest,
                      com.google.analytics.admin.v1alpha.AuditUserLinksResponse>(
                      this, METHODID_AUDIT_USER_LINKS)))
          .addMethod(
              getCreateUserLinkMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.CreateUserLinkRequest,
                      com.google.analytics.admin.v1alpha.UserLink>(
                      this, METHODID_CREATE_USER_LINK)))
          .addMethod(
              getBatchCreateUserLinksMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.BatchCreateUserLinksRequest,
                      com.google.analytics.admin.v1alpha.BatchCreateUserLinksResponse>(
                      this, METHODID_BATCH_CREATE_USER_LINKS)))
          .addMethod(
              getUpdateUserLinkMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.UpdateUserLinkRequest,
                      com.google.analytics.admin.v1alpha.UserLink>(
                      this, METHODID_UPDATE_USER_LINK)))
          .addMethod(
              getBatchUpdateUserLinksMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.BatchUpdateUserLinksRequest,
                      com.google.analytics.admin.v1alpha.BatchUpdateUserLinksResponse>(
                      this, METHODID_BATCH_UPDATE_USER_LINKS)))
          .addMethod(
              getDeleteUserLinkMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.DeleteUserLinkRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_USER_LINK)))
          .addMethod(
              getBatchDeleteUserLinksMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.BatchDeleteUserLinksRequest,
                      com.google.protobuf.Empty>(this, METHODID_BATCH_DELETE_USER_LINKS)))
          .addMethod(
              getCreateFirebaseLinkMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.CreateFirebaseLinkRequest,
                      com.google.analytics.admin.v1alpha.FirebaseLink>(
                      this, METHODID_CREATE_FIREBASE_LINK)))
          .addMethod(
              getDeleteFirebaseLinkMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.DeleteFirebaseLinkRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_FIREBASE_LINK)))
          .addMethod(
              getListFirebaseLinksMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.ListFirebaseLinksRequest,
                      com.google.analytics.admin.v1alpha.ListFirebaseLinksResponse>(
                      this, METHODID_LIST_FIREBASE_LINKS)))
          .addMethod(
              getGetGlobalSiteTagMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.GetGlobalSiteTagRequest,
                      com.google.analytics.admin.v1alpha.GlobalSiteTag>(
                      this, METHODID_GET_GLOBAL_SITE_TAG)))
          .addMethod(
              getCreateGoogleAdsLinkMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.CreateGoogleAdsLinkRequest,
                      com.google.analytics.admin.v1alpha.GoogleAdsLink>(
                      this, METHODID_CREATE_GOOGLE_ADS_LINK)))
          .addMethod(
              getUpdateGoogleAdsLinkMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.UpdateGoogleAdsLinkRequest,
                      com.google.analytics.admin.v1alpha.GoogleAdsLink>(
                      this, METHODID_UPDATE_GOOGLE_ADS_LINK)))
          .addMethod(
              getDeleteGoogleAdsLinkMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.DeleteGoogleAdsLinkRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_GOOGLE_ADS_LINK)))
          .addMethod(
              getListGoogleAdsLinksMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.ListGoogleAdsLinksRequest,
                      com.google.analytics.admin.v1alpha.ListGoogleAdsLinksResponse>(
                      this, METHODID_LIST_GOOGLE_ADS_LINKS)))
          .addMethod(
              getGetDataSharingSettingsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.GetDataSharingSettingsRequest,
                      com.google.analytics.admin.v1alpha.DataSharingSettings>(
                      this, METHODID_GET_DATA_SHARING_SETTINGS)))
          .addMethod(
              getGetMeasurementProtocolSecretMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.GetMeasurementProtocolSecretRequest,
                      com.google.analytics.admin.v1alpha.MeasurementProtocolSecret>(
                      this, METHODID_GET_MEASUREMENT_PROTOCOL_SECRET)))
          .addMethod(
              getListMeasurementProtocolSecretsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.ListMeasurementProtocolSecretsRequest,
                      com.google.analytics.admin.v1alpha.ListMeasurementProtocolSecretsResponse>(
                      this, METHODID_LIST_MEASUREMENT_PROTOCOL_SECRETS)))
          .addMethod(
              getCreateMeasurementProtocolSecretMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.CreateMeasurementProtocolSecretRequest,
                      com.google.analytics.admin.v1alpha.MeasurementProtocolSecret>(
                      this, METHODID_CREATE_MEASUREMENT_PROTOCOL_SECRET)))
          .addMethod(
              getDeleteMeasurementProtocolSecretMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.DeleteMeasurementProtocolSecretRequest,
                      com.google.protobuf.Empty>(
                      this, METHODID_DELETE_MEASUREMENT_PROTOCOL_SECRET)))
          .addMethod(
              getUpdateMeasurementProtocolSecretMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.UpdateMeasurementProtocolSecretRequest,
                      com.google.analytics.admin.v1alpha.MeasurementProtocolSecret>(
                      this, METHODID_UPDATE_MEASUREMENT_PROTOCOL_SECRET)))
          .addMethod(
              getAcknowledgeUserDataCollectionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.AcknowledgeUserDataCollectionRequest,
                      com.google.analytics.admin.v1alpha.AcknowledgeUserDataCollectionResponse>(
                      this, METHODID_ACKNOWLEDGE_USER_DATA_COLLECTION)))
          .addMethod(
              getSearchChangeHistoryEventsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.SearchChangeHistoryEventsRequest,
                      com.google.analytics.admin.v1alpha.SearchChangeHistoryEventsResponse>(
                      this, METHODID_SEARCH_CHANGE_HISTORY_EVENTS)))
          .addMethod(
              getGetGoogleSignalsSettingsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.GetGoogleSignalsSettingsRequest,
                      com.google.analytics.admin.v1alpha.GoogleSignalsSettings>(
                      this, METHODID_GET_GOOGLE_SIGNALS_SETTINGS)))
          .addMethod(
              getUpdateGoogleSignalsSettingsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.UpdateGoogleSignalsSettingsRequest,
                      com.google.analytics.admin.v1alpha.GoogleSignalsSettings>(
                      this, METHODID_UPDATE_GOOGLE_SIGNALS_SETTINGS)))
          .addMethod(
              getCreateConversionEventMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.CreateConversionEventRequest,
                      com.google.analytics.admin.v1alpha.ConversionEvent>(
                      this, METHODID_CREATE_CONVERSION_EVENT)))
          .addMethod(
              getGetConversionEventMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.GetConversionEventRequest,
                      com.google.analytics.admin.v1alpha.ConversionEvent>(
                      this, METHODID_GET_CONVERSION_EVENT)))
          .addMethod(
              getDeleteConversionEventMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.DeleteConversionEventRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_CONVERSION_EVENT)))
          .addMethod(
              getListConversionEventsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.ListConversionEventsRequest,
                      com.google.analytics.admin.v1alpha.ListConversionEventsResponse>(
                      this, METHODID_LIST_CONVERSION_EVENTS)))
          .addMethod(
              getGetDisplayVideo360AdvertiserLinkMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.GetDisplayVideo360AdvertiserLinkRequest,
                      com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink>(
                      this, METHODID_GET_DISPLAY_VIDEO360ADVERTISER_LINK)))
          .addMethod(
              getListDisplayVideo360AdvertiserLinksMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinksRequest,
                      com.google.analytics.admin.v1alpha
                          .ListDisplayVideo360AdvertiserLinksResponse>(
                      this, METHODID_LIST_DISPLAY_VIDEO360ADVERTISER_LINKS)))
          .addMethod(
              getCreateDisplayVideo360AdvertiserLinkMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.CreateDisplayVideo360AdvertiserLinkRequest,
                      com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink>(
                      this, METHODID_CREATE_DISPLAY_VIDEO360ADVERTISER_LINK)))
          .addMethod(
              getDeleteDisplayVideo360AdvertiserLinkMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.DeleteDisplayVideo360AdvertiserLinkRequest,
                      com.google.protobuf.Empty>(
                      this, METHODID_DELETE_DISPLAY_VIDEO360ADVERTISER_LINK)))
          .addMethod(
              getUpdateDisplayVideo360AdvertiserLinkMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.UpdateDisplayVideo360AdvertiserLinkRequest,
                      com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink>(
                      this, METHODID_UPDATE_DISPLAY_VIDEO360ADVERTISER_LINK)))
          .addMethod(
              getGetDisplayVideo360AdvertiserLinkProposalMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha
                          .GetDisplayVideo360AdvertiserLinkProposalRequest,
                      com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal>(
                      this, METHODID_GET_DISPLAY_VIDEO360ADVERTISER_LINK_PROPOSAL)))
          .addMethod(
              getListDisplayVideo360AdvertiserLinkProposalsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha
                          .ListDisplayVideo360AdvertiserLinkProposalsRequest,
                      com.google.analytics.admin.v1alpha
                          .ListDisplayVideo360AdvertiserLinkProposalsResponse>(
                      this, METHODID_LIST_DISPLAY_VIDEO360ADVERTISER_LINK_PROPOSALS)))
          .addMethod(
              getCreateDisplayVideo360AdvertiserLinkProposalMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha
                          .CreateDisplayVideo360AdvertiserLinkProposalRequest,
                      com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal>(
                      this, METHODID_CREATE_DISPLAY_VIDEO360ADVERTISER_LINK_PROPOSAL)))
          .addMethod(
              getDeleteDisplayVideo360AdvertiserLinkProposalMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha
                          .DeleteDisplayVideo360AdvertiserLinkProposalRequest,
                      com.google.protobuf.Empty>(
                      this, METHODID_DELETE_DISPLAY_VIDEO360ADVERTISER_LINK_PROPOSAL)))
          .addMethod(
              getApproveDisplayVideo360AdvertiserLinkProposalMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha
                          .ApproveDisplayVideo360AdvertiserLinkProposalRequest,
                      com.google.analytics.admin.v1alpha
                          .ApproveDisplayVideo360AdvertiserLinkProposalResponse>(
                      this, METHODID_APPROVE_DISPLAY_VIDEO360ADVERTISER_LINK_PROPOSAL)))
          .addMethod(
              getCancelDisplayVideo360AdvertiserLinkProposalMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha
                          .CancelDisplayVideo360AdvertiserLinkProposalRequest,
                      com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal>(
                      this, METHODID_CANCEL_DISPLAY_VIDEO360ADVERTISER_LINK_PROPOSAL)))
          .addMethod(
              getCreateCustomDimensionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.CreateCustomDimensionRequest,
                      com.google.analytics.admin.v1alpha.CustomDimension>(
                      this, METHODID_CREATE_CUSTOM_DIMENSION)))
          .addMethod(
              getUpdateCustomDimensionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.UpdateCustomDimensionRequest,
                      com.google.analytics.admin.v1alpha.CustomDimension>(
                      this, METHODID_UPDATE_CUSTOM_DIMENSION)))
          .addMethod(
              getListCustomDimensionsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.ListCustomDimensionsRequest,
                      com.google.analytics.admin.v1alpha.ListCustomDimensionsResponse>(
                      this, METHODID_LIST_CUSTOM_DIMENSIONS)))
          .addMethod(
              getArchiveCustomDimensionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.ArchiveCustomDimensionRequest,
                      com.google.protobuf.Empty>(this, METHODID_ARCHIVE_CUSTOM_DIMENSION)))
          .addMethod(
              getGetCustomDimensionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.GetCustomDimensionRequest,
                      com.google.analytics.admin.v1alpha.CustomDimension>(
                      this, METHODID_GET_CUSTOM_DIMENSION)))
          .addMethod(
              getCreateCustomMetricMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.CreateCustomMetricRequest,
                      com.google.analytics.admin.v1alpha.CustomMetric>(
                      this, METHODID_CREATE_CUSTOM_METRIC)))
          .addMethod(
              getUpdateCustomMetricMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.UpdateCustomMetricRequest,
                      com.google.analytics.admin.v1alpha.CustomMetric>(
                      this, METHODID_UPDATE_CUSTOM_METRIC)))
          .addMethod(
              getListCustomMetricsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.ListCustomMetricsRequest,
                      com.google.analytics.admin.v1alpha.ListCustomMetricsResponse>(
                      this, METHODID_LIST_CUSTOM_METRICS)))
          .addMethod(
              getArchiveCustomMetricMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.ArchiveCustomMetricRequest,
                      com.google.protobuf.Empty>(this, METHODID_ARCHIVE_CUSTOM_METRIC)))
          .addMethod(
              getGetCustomMetricMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.GetCustomMetricRequest,
                      com.google.analytics.admin.v1alpha.CustomMetric>(
                      this, METHODID_GET_CUSTOM_METRIC)))
          .addMethod(
              getGetDataRetentionSettingsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.GetDataRetentionSettingsRequest,
                      com.google.analytics.admin.v1alpha.DataRetentionSettings>(
                      this, METHODID_GET_DATA_RETENTION_SETTINGS)))
          .addMethod(
              getUpdateDataRetentionSettingsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.UpdateDataRetentionSettingsRequest,
                      com.google.analytics.admin.v1alpha.DataRetentionSettings>(
                      this, METHODID_UPDATE_DATA_RETENTION_SETTINGS)))
          .addMethod(
              getCreateDataStreamMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.CreateDataStreamRequest,
                      com.google.analytics.admin.v1alpha.DataStream>(
                      this, METHODID_CREATE_DATA_STREAM)))
          .addMethod(
              getDeleteDataStreamMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.DeleteDataStreamRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_DATA_STREAM)))
          .addMethod(
              getUpdateDataStreamMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.UpdateDataStreamRequest,
                      com.google.analytics.admin.v1alpha.DataStream>(
                      this, METHODID_UPDATE_DATA_STREAM)))
          .addMethod(
              getListDataStreamsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.ListDataStreamsRequest,
                      com.google.analytics.admin.v1alpha.ListDataStreamsResponse>(
                      this, METHODID_LIST_DATA_STREAMS)))
          .addMethod(
              getGetDataStreamMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.GetDataStreamRequest,
                      com.google.analytics.admin.v1alpha.DataStream>(
                      this, METHODID_GET_DATA_STREAM)))
          .addMethod(
              getGetAudienceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.GetAudienceRequest,
                      com.google.analytics.admin.v1alpha.Audience>(this, METHODID_GET_AUDIENCE)))
          .addMethod(
              getListAudiencesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.ListAudiencesRequest,
                      com.google.analytics.admin.v1alpha.ListAudiencesResponse>(
                      this, METHODID_LIST_AUDIENCES)))
          .addMethod(
              getCreateAudienceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.CreateAudienceRequest,
                      com.google.analytics.admin.v1alpha.Audience>(this, METHODID_CREATE_AUDIENCE)))
          .addMethod(
              getUpdateAudienceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.UpdateAudienceRequest,
                      com.google.analytics.admin.v1alpha.Audience>(this, METHODID_UPDATE_AUDIENCE)))
          .addMethod(
              getArchiveAudienceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.ArchiveAudienceRequest,
                      com.google.protobuf.Empty>(this, METHODID_ARCHIVE_AUDIENCE)))
          .addMethod(
              getGetAttributionSettingsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.GetAttributionSettingsRequest,
                      com.google.analytics.admin.v1alpha.AttributionSettings>(
                      this, METHODID_GET_ATTRIBUTION_SETTINGS)))
          .addMethod(
              getUpdateAttributionSettingsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.UpdateAttributionSettingsRequest,
                      com.google.analytics.admin.v1alpha.AttributionSettings>(
                      this, METHODID_UPDATE_ATTRIBUTION_SETTINGS)))
          .addMethod(
              getRunAccessReportMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.RunAccessReportRequest,
                      com.google.analytics.admin.v1alpha.RunAccessReportResponse>(
                      this, METHODID_RUN_ACCESS_REPORT)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service Interface for the Analytics Admin API (GA4).
   * </pre>
   */
  public static final class AnalyticsAdminServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AnalyticsAdminServiceStub> {
    private AnalyticsAdminServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnalyticsAdminServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AnalyticsAdminServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single Account.
     * </pre>
     */
    public void getAccount(
        com.google.analytics.admin.v1alpha.GetAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Account> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns all accounts accessible by the caller.
     * Note that these accounts might not currently have GA4 properties.
     * Soft-deleted (ie: "trashed") accounts are excluded by default.
     * Returns an empty list if no relevant accounts are found.
     * </pre>
     */
    public void listAccounts(
        com.google.analytics.admin.v1alpha.ListAccountsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListAccountsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAccountsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Marks target Account as soft-deleted (ie: "trashed") and returns it.
     * This API does not have a method to restore soft-deleted accounts.
     * However, they can be restored using the Trash Can UI.
     * If the accounts are not restored before the expiration time, the account
     * and all child resources (eg: Properties, GoogleAdsLinks, Streams,
     * UserLinks) will be permanently purged.
     * https://support.google.com/analytics/answer/6154772
     * Returns an error if the target is not found.
     * </pre>
     */
    public void deleteAccount(
        com.google.analytics.admin.v1alpha.DeleteAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAccountMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an account.
     * </pre>
     */
    public void updateAccount(
        com.google.analytics.admin.v1alpha.UpdateAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Account> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAccountMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Requests a ticket for creating an account.
     * </pre>
     */
    public void provisionAccountTicket(
        com.google.analytics.admin.v1alpha.ProvisionAccountTicketRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.ProvisionAccountTicketResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getProvisionAccountTicketMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns summaries of all accounts accessible by the caller.
     * </pre>
     */
    public void listAccountSummaries(
        com.google.analytics.admin.v1alpha.ListAccountSummariesRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListAccountSummariesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAccountSummariesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single "GA4" Property.
     * </pre>
     */
    public void getProperty(
        com.google.analytics.admin.v1alpha.GetPropertyRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Property> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPropertyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns child Properties under the specified parent Account.
     * Only "GA4" properties will be returned.
     * Properties will be excluded if the caller does not have access.
     * Soft-deleted (ie: "trashed") properties are excluded by default.
     * Returns an empty list if no relevant properties are found.
     * </pre>
     */
    public void listProperties(
        com.google.analytics.admin.v1alpha.ListPropertiesRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListPropertiesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPropertiesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an "GA4" property with the specified location and attributes.
     * </pre>
     */
    public void createProperty(
        com.google.analytics.admin.v1alpha.CreatePropertyRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Property> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePropertyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Marks target Property as soft-deleted (ie: "trashed") and returns it.
     * This API does not have a method to restore soft-deleted properties.
     * However, they can be restored using the Trash Can UI.
     * If the properties are not restored before the expiration time, the Property
     * and all child resources (eg: GoogleAdsLinks, Streams, UserLinks)
     * will be permanently purged.
     * https://support.google.com/analytics/answer/6154772
     * Returns an error if the target is not found, or is not an GA4 Property.
     * </pre>
     */
    public void deleteProperty(
        com.google.analytics.admin.v1alpha.DeletePropertyRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Property> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePropertyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a property.
     * </pre>
     */
    public void updateProperty(
        com.google.analytics.admin.v1alpha.UpdatePropertyRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Property> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePropertyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a user's link to an account or property.
     * </pre>
     */
    public void getUserLink(
        com.google.analytics.admin.v1alpha.GetUserLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.UserLink> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information about multiple users' links to an account or property.
     * </pre>
     */
    public void batchGetUserLinks(
        com.google.analytics.admin.v1alpha.BatchGetUserLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.BatchGetUserLinksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchGetUserLinksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all user links on an account or property.
     * </pre>
     */
    public void listUserLinks(
        com.google.analytics.admin.v1alpha.ListUserLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListUserLinksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListUserLinksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all user links on an account or property, including implicit ones
     * that come from effective permissions granted by groups or organization
     * admin roles.
     * If a returned user link does not have direct permissions, they cannot
     * be removed from the account or property directly with the DeleteUserLink
     * command. They have to be removed from the group/etc that gives them
     * permissions, which is currently only usable/discoverable in the GA or GMP
     * UIs.
     * </pre>
     */
    public void auditUserLinks(
        com.google.analytics.admin.v1alpha.AuditUserLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AuditUserLinksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAuditUserLinksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a user link on an account or property.
     * If the user with the specified email already has permissions on the
     * account or property, then the user's existing permissions will be unioned
     * with the permissions specified in the new UserLink.
     * </pre>
     */
    public void createUserLink(
        com.google.analytics.admin.v1alpha.CreateUserLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.UserLink> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateUserLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates information about multiple users' links to an account or property.
     * This method is transactional. If any UserLink cannot be created, none of
     * the UserLinks will be created.
     * </pre>
     */
    public void batchCreateUserLinks(
        com.google.analytics.admin.v1alpha.BatchCreateUserLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.BatchCreateUserLinksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchCreateUserLinksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a user link on an account or property.
     * </pre>
     */
    public void updateUserLink(
        com.google.analytics.admin.v1alpha.UpdateUserLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.UserLink> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateUserLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates information about multiple users' links to an account or property.
     * </pre>
     */
    public void batchUpdateUserLinks(
        com.google.analytics.admin.v1alpha.BatchUpdateUserLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.BatchUpdateUserLinksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchUpdateUserLinksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a user link on an account or property.
     * </pre>
     */
    public void deleteUserLink(
        com.google.analytics.admin.v1alpha.DeleteUserLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteUserLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes information about multiple users' links to an account or property.
     * </pre>
     */
    public void batchDeleteUserLinks(
        com.google.analytics.admin.v1alpha.BatchDeleteUserLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchDeleteUserLinksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a FirebaseLink.
     * Properties can have at most one FirebaseLink.
     * </pre>
     */
    public void createFirebaseLink(
        com.google.analytics.admin.v1alpha.CreateFirebaseLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.FirebaseLink>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFirebaseLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a FirebaseLink on a property
     * </pre>
     */
    public void deleteFirebaseLink(
        com.google.analytics.admin.v1alpha.DeleteFirebaseLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFirebaseLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists FirebaseLinks on a property.
     * Properties can have at most one FirebaseLink.
     * </pre>
     */
    public void listFirebaseLinks(
        com.google.analytics.admin.v1alpha.ListFirebaseLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListFirebaseLinksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFirebaseLinksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the Site Tag for the specified web stream.
     * Site Tags are immutable singletons.
     * </pre>
     */
    public void getGlobalSiteTag(
        com.google.analytics.admin.v1alpha.GetGlobalSiteTagRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.GlobalSiteTag>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGlobalSiteTagMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a GoogleAdsLink.
     * </pre>
     */
    public void createGoogleAdsLink(
        com.google.analytics.admin.v1alpha.CreateGoogleAdsLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.GoogleAdsLink>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateGoogleAdsLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a GoogleAdsLink on a property
     * </pre>
     */
    public void updateGoogleAdsLink(
        com.google.analytics.admin.v1alpha.UpdateGoogleAdsLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.GoogleAdsLink>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateGoogleAdsLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a GoogleAdsLink on a property
     * </pre>
     */
    public void deleteGoogleAdsLink(
        com.google.analytics.admin.v1alpha.DeleteGoogleAdsLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteGoogleAdsLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists GoogleAdsLinks on a property.
     * </pre>
     */
    public void listGoogleAdsLinks(
        com.google.analytics.admin.v1alpha.ListGoogleAdsLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListGoogleAdsLinksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListGoogleAdsLinksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get data sharing settings on an account.
     * Data sharing settings are singletons.
     * </pre>
     */
    public void getDataSharingSettings(
        com.google.analytics.admin.v1alpha.GetDataSharingSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.DataSharingSettings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataSharingSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single "GA4" MeasurementProtocolSecret.
     * </pre>
     */
    public void getMeasurementProtocolSecret(
        com.google.analytics.admin.v1alpha.GetMeasurementProtocolSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.MeasurementProtocolSecret>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMeasurementProtocolSecretMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns child MeasurementProtocolSecrets under the specified parent
     * Property.
     * </pre>
     */
    public void listMeasurementProtocolSecrets(
        com.google.analytics.admin.v1alpha.ListMeasurementProtocolSecretsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.ListMeasurementProtocolSecretsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMeasurementProtocolSecretsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a measurement protocol secret.
     * </pre>
     */
    public void createMeasurementProtocolSecret(
        com.google.analytics.admin.v1alpha.CreateMeasurementProtocolSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.MeasurementProtocolSecret>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMeasurementProtocolSecretMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes target MeasurementProtocolSecret.
     * </pre>
     */
    public void deleteMeasurementProtocolSecret(
        com.google.analytics.admin.v1alpha.DeleteMeasurementProtocolSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMeasurementProtocolSecretMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a measurement protocol secret.
     * </pre>
     */
    public void updateMeasurementProtocolSecret(
        com.google.analytics.admin.v1alpha.UpdateMeasurementProtocolSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.MeasurementProtocolSecret>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMeasurementProtocolSecretMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Acknowledges the terms of user data collection for the specified property.
     * This acknowledgement must be completed (either in the Google Analytics UI
     * or via this API) before MeasurementProtocolSecret resources may be created.
     * </pre>
     */
    public void acknowledgeUserDataCollection(
        com.google.analytics.admin.v1alpha.AcknowledgeUserDataCollectionRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.AcknowledgeUserDataCollectionResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAcknowledgeUserDataCollectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches through all changes to an account or its children given the
     * specified set of filters.
     * </pre>
     */
    public void searchChangeHistoryEvents(
        com.google.analytics.admin.v1alpha.SearchChangeHistoryEventsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.SearchChangeHistoryEventsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchChangeHistoryEventsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for Google Signals settings for a property.
     * </pre>
     */
    public void getGoogleSignalsSettings(
        com.google.analytics.admin.v1alpha.GetGoogleSignalsSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.GoogleSignalsSettings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGoogleSignalsSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates Google Signals settings for a property.
     * </pre>
     */
    public void updateGoogleSignalsSettings(
        com.google.analytics.admin.v1alpha.UpdateGoogleSignalsSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.GoogleSignalsSettings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateGoogleSignalsSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a conversion event with the specified attributes.
     * </pre>
     */
    public void createConversionEvent(
        com.google.analytics.admin.v1alpha.CreateConversionEventRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ConversionEvent>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateConversionEventMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single conversion event.
     * </pre>
     */
    public void getConversionEvent(
        com.google.analytics.admin.v1alpha.GetConversionEventRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ConversionEvent>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetConversionEventMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a conversion event in a property.
     * </pre>
     */
    public void deleteConversionEvent(
        com.google.analytics.admin.v1alpha.DeleteConversionEventRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteConversionEventMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of conversion events in the specified parent property.
     * Returns an empty list if no conversion events are found.
     * </pre>
     */
    public void listConversionEvents(
        com.google.analytics.admin.v1alpha.ListConversionEventsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListConversionEventsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListConversionEventsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Look up a single DisplayVideo360AdvertiserLink
     * </pre>
     */
    public void getDisplayVideo360AdvertiserLink(
        com.google.analytics.admin.v1alpha.GetDisplayVideo360AdvertiserLinkRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDisplayVideo360AdvertiserLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all DisplayVideo360AdvertiserLinks on a property.
     * </pre>
     */
    public void listDisplayVideo360AdvertiserLinks(
        com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinksRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDisplayVideo360AdvertiserLinksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a DisplayVideo360AdvertiserLink.
     * This can only be utilized by users who have proper authorization both on
     * the Google Analytics property and on the Display &amp; Video 360 advertiser.
     * Users who do not have access to the Display &amp; Video 360 advertiser should
     * instead seek to create a DisplayVideo360LinkProposal.
     * </pre>
     */
    public void createDisplayVideo360AdvertiserLink(
        com.google.analytics.admin.v1alpha.CreateDisplayVideo360AdvertiserLinkRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDisplayVideo360AdvertiserLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a DisplayVideo360AdvertiserLink on a property.
     * </pre>
     */
    public void deleteDisplayVideo360AdvertiserLink(
        com.google.analytics.admin.v1alpha.DeleteDisplayVideo360AdvertiserLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDisplayVideo360AdvertiserLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a DisplayVideo360AdvertiserLink on a property.
     * </pre>
     */
    public void updateDisplayVideo360AdvertiserLink(
        com.google.analytics.admin.v1alpha.UpdateDisplayVideo360AdvertiserLinkRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDisplayVideo360AdvertiserLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single DisplayVideo360AdvertiserLinkProposal.
     * </pre>
     */
    public void getDisplayVideo360AdvertiserLinkProposal(
        com.google.analytics.admin.v1alpha.GetDisplayVideo360AdvertiserLinkProposalRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(getGetDisplayVideo360AdvertiserLinkProposalMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DisplayVideo360AdvertiserLinkProposals on a property.
     * </pre>
     */
    public void listDisplayVideo360AdvertiserLinkProposals(
        com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinkProposalsRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha
                    .ListDisplayVideo360AdvertiserLinkProposalsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(getListDisplayVideo360AdvertiserLinkProposalsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a DisplayVideo360AdvertiserLinkProposal.
     * </pre>
     */
    public void createDisplayVideo360AdvertiserLinkProposal(
        com.google.analytics.admin.v1alpha.CreateDisplayVideo360AdvertiserLinkProposalRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(getCreateDisplayVideo360AdvertiserLinkProposalMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a DisplayVideo360AdvertiserLinkProposal on a property.
     * This can only be used on cancelled proposals.
     * </pre>
     */
    public void deleteDisplayVideo360AdvertiserLinkProposal(
        com.google.analytics.admin.v1alpha.DeleteDisplayVideo360AdvertiserLinkProposalRequest
            request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(getDeleteDisplayVideo360AdvertiserLinkProposalMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Approves a DisplayVideo360AdvertiserLinkProposal.
     * The DisplayVideo360AdvertiserLinkProposal will be deleted and a new
     * DisplayVideo360AdvertiserLink will be created.
     * </pre>
     */
    public void approveDisplayVideo360AdvertiserLinkProposal(
        com.google.analytics.admin.v1alpha.ApproveDisplayVideo360AdvertiserLinkProposalRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha
                    .ApproveDisplayVideo360AdvertiserLinkProposalResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(getApproveDisplayVideo360AdvertiserLinkProposalMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels a DisplayVideo360AdvertiserLinkProposal.
     * Cancelling can mean either:
     * - Declining a proposal initiated from Display &amp; Video 360
     * - Withdrawing a proposal initiated from Google Analytics
     * After being cancelled, a proposal will eventually be deleted automatically.
     * </pre>
     */
    public void cancelDisplayVideo360AdvertiserLinkProposal(
        com.google.analytics.admin.v1alpha.CancelDisplayVideo360AdvertiserLinkProposalRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(getCancelDisplayVideo360AdvertiserLinkProposalMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a CustomDimension.
     * </pre>
     */
    public void createCustomDimension(
        com.google.analytics.admin.v1alpha.CreateCustomDimensionRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.CustomDimension>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCustomDimensionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a CustomDimension on a property.
     * </pre>
     */
    public void updateCustomDimension(
        com.google.analytics.admin.v1alpha.UpdateCustomDimensionRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.CustomDimension>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCustomDimensionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists CustomDimensions on a property.
     * </pre>
     */
    public void listCustomDimensions(
        com.google.analytics.admin.v1alpha.ListCustomDimensionsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListCustomDimensionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCustomDimensionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Archives a CustomDimension on a property.
     * </pre>
     */
    public void archiveCustomDimension(
        com.google.analytics.admin.v1alpha.ArchiveCustomDimensionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getArchiveCustomDimensionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single CustomDimension.
     * </pre>
     */
    public void getCustomDimension(
        com.google.analytics.admin.v1alpha.GetCustomDimensionRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.CustomDimension>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCustomDimensionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a CustomMetric.
     * </pre>
     */
    public void createCustomMetric(
        com.google.analytics.admin.v1alpha.CreateCustomMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.CustomMetric>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCustomMetricMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a CustomMetric on a property.
     * </pre>
     */
    public void updateCustomMetric(
        com.google.analytics.admin.v1alpha.UpdateCustomMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.CustomMetric>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCustomMetricMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists CustomMetrics on a property.
     * </pre>
     */
    public void listCustomMetrics(
        com.google.analytics.admin.v1alpha.ListCustomMetricsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListCustomMetricsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCustomMetricsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Archives a CustomMetric on a property.
     * </pre>
     */
    public void archiveCustomMetric(
        com.google.analytics.admin.v1alpha.ArchiveCustomMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getArchiveCustomMetricMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single CustomMetric.
     * </pre>
     */
    public void getCustomMetric(
        com.google.analytics.admin.v1alpha.GetCustomMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.CustomMetric>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCustomMetricMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the singleton data retention settings for this property.
     * </pre>
     */
    public void getDataRetentionSettings(
        com.google.analytics.admin.v1alpha.GetDataRetentionSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.DataRetentionSettings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataRetentionSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the singleton data retention settings for this property.
     * </pre>
     */
    public void updateDataRetentionSettings(
        com.google.analytics.admin.v1alpha.UpdateDataRetentionSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.DataRetentionSettings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDataRetentionSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a DataStream.
     * </pre>
     */
    public void createDataStream(
        com.google.analytics.admin.v1alpha.CreateDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.DataStream>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDataStreamMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a DataStream on a property.
     * </pre>
     */
    public void deleteDataStream(
        com.google.analytics.admin.v1alpha.DeleteDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDataStreamMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a DataStream on a property.
     * </pre>
     */
    public void updateDataStream(
        com.google.analytics.admin.v1alpha.UpdateDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.DataStream>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDataStreamMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DataStreams on a property.
     * </pre>
     */
    public void listDataStreams(
        com.google.analytics.admin.v1alpha.ListDataStreamsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListDataStreamsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDataStreamsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single DataStream.
     * </pre>
     */
    public void getDataStream(
        com.google.analytics.admin.v1alpha.GetDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.DataStream>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataStreamMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single Audience.
     * Audiences created before 2020 may not be supported.
     * </pre>
     */
    public void getAudience(
        com.google.analytics.admin.v1alpha.GetAudienceRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Audience> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAudienceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Audiences on a property.
     * Audiences created before 2020 may not be supported.
     * </pre>
     */
    public void listAudiences(
        com.google.analytics.admin.v1alpha.ListAudiencesRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListAudiencesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAudiencesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an Audience.
     * </pre>
     */
    public void createAudience(
        com.google.analytics.admin.v1alpha.CreateAudienceRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Audience> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAudienceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an Audience on a property.
     * </pre>
     */
    public void updateAudience(
        com.google.analytics.admin.v1alpha.UpdateAudienceRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Audience> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAudienceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Archives an Audience on a property.
     * </pre>
     */
    public void archiveAudience(
        com.google.analytics.admin.v1alpha.ArchiveAudienceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getArchiveAudienceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a AttributionSettings singleton.
     * </pre>
     */
    public void getAttributionSettings(
        com.google.analytics.admin.v1alpha.GetAttributionSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AttributionSettings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAttributionSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates attribution settings on a property.
     * </pre>
     */
    public void updateAttributionSettings(
        com.google.analytics.admin.v1alpha.UpdateAttributionSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AttributionSettings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAttributionSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a customized report of data access records. The report provides
     * records of each time a user reads Google Analytics reporting data. Access
     * records are retained for up to 2 years.
     * Data Access Reports can be requested for a property. The property must be
     * in Google Analytics 360. This method is only available to Administrators.
     * These data access records include GA4 UI Reporting, GA4 UI Explorations,
     * GA4 Data API, and other products like Firebase &amp; Admob that can retrieve
     * data from Google Analytics through a linkage. These records don't include
     * property configuration changes like adding a stream or changing a
     * property's time zone. For configuration change history, see
     * [searchChangeHistoryEvents](https://developers.google.com/analytics/devguides/config/admin/v1/rest/v1alpha/accounts/searchChangeHistoryEvents).
     * </pre>
     */
    public void runAccessReport(
        com.google.analytics.admin.v1alpha.RunAccessReportRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.RunAccessReportResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRunAccessReportMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service Interface for the Analytics Admin API (GA4).
   * </pre>
   */
  public static final class AnalyticsAdminServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AnalyticsAdminServiceBlockingStub> {
    private AnalyticsAdminServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnalyticsAdminServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AnalyticsAdminServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single Account.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.Account getAccount(
        com.google.analytics.admin.v1alpha.GetAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAccountMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns all accounts accessible by the caller.
     * Note that these accounts might not currently have GA4 properties.
     * Soft-deleted (ie: "trashed") accounts are excluded by default.
     * Returns an empty list if no relevant accounts are found.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListAccountsResponse listAccounts(
        com.google.analytics.admin.v1alpha.ListAccountsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAccountsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Marks target Account as soft-deleted (ie: "trashed") and returns it.
     * This API does not have a method to restore soft-deleted accounts.
     * However, they can be restored using the Trash Can UI.
     * If the accounts are not restored before the expiration time, the account
     * and all child resources (eg: Properties, GoogleAdsLinks, Streams,
     * UserLinks) will be permanently purged.
     * https://support.google.com/analytics/answer/6154772
     * Returns an error if the target is not found.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAccount(
        com.google.analytics.admin.v1alpha.DeleteAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAccountMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an account.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.Account updateAccount(
        com.google.analytics.admin.v1alpha.UpdateAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAccountMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Requests a ticket for creating an account.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ProvisionAccountTicketResponse provisionAccountTicket(
        com.google.analytics.admin.v1alpha.ProvisionAccountTicketRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getProvisionAccountTicketMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns summaries of all accounts accessible by the caller.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListAccountSummariesResponse listAccountSummaries(
        com.google.analytics.admin.v1alpha.ListAccountSummariesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAccountSummariesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single "GA4" Property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.Property getProperty(
        com.google.analytics.admin.v1alpha.GetPropertyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPropertyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns child Properties under the specified parent Account.
     * Only "GA4" properties will be returned.
     * Properties will be excluded if the caller does not have access.
     * Soft-deleted (ie: "trashed") properties are excluded by default.
     * Returns an empty list if no relevant properties are found.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListPropertiesResponse listProperties(
        com.google.analytics.admin.v1alpha.ListPropertiesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPropertiesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an "GA4" property with the specified location and attributes.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.Property createProperty(
        com.google.analytics.admin.v1alpha.CreatePropertyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePropertyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Marks target Property as soft-deleted (ie: "trashed") and returns it.
     * This API does not have a method to restore soft-deleted properties.
     * However, they can be restored using the Trash Can UI.
     * If the properties are not restored before the expiration time, the Property
     * and all child resources (eg: GoogleAdsLinks, Streams, UserLinks)
     * will be permanently purged.
     * https://support.google.com/analytics/answer/6154772
     * Returns an error if the target is not found, or is not an GA4 Property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.Property deleteProperty(
        com.google.analytics.admin.v1alpha.DeletePropertyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePropertyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.Property updateProperty(
        com.google.analytics.admin.v1alpha.UpdatePropertyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePropertyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a user's link to an account or property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.UserLink getUserLink(
        com.google.analytics.admin.v1alpha.GetUserLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about multiple users' links to an account or property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.BatchGetUserLinksResponse batchGetUserLinks(
        com.google.analytics.admin.v1alpha.BatchGetUserLinksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchGetUserLinksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all user links on an account or property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListUserLinksResponse listUserLinks(
        com.google.analytics.admin.v1alpha.ListUserLinksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUserLinksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all user links on an account or property, including implicit ones
     * that come from effective permissions granted by groups or organization
     * admin roles.
     * If a returned user link does not have direct permissions, they cannot
     * be removed from the account or property directly with the DeleteUserLink
     * command. They have to be removed from the group/etc that gives them
     * permissions, which is currently only usable/discoverable in the GA or GMP
     * UIs.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.AuditUserLinksResponse auditUserLinks(
        com.google.analytics.admin.v1alpha.AuditUserLinksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAuditUserLinksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a user link on an account or property.
     * If the user with the specified email already has permissions on the
     * account or property, then the user's existing permissions will be unioned
     * with the permissions specified in the new UserLink.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.UserLink createUserLink(
        com.google.analytics.admin.v1alpha.CreateUserLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUserLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates information about multiple users' links to an account or property.
     * This method is transactional. If any UserLink cannot be created, none of
     * the UserLinks will be created.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.BatchCreateUserLinksResponse batchCreateUserLinks(
        com.google.analytics.admin.v1alpha.BatchCreateUserLinksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchCreateUserLinksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a user link on an account or property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.UserLink updateUserLink(
        com.google.analytics.admin.v1alpha.UpdateUserLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUserLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates information about multiple users' links to an account or property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.BatchUpdateUserLinksResponse batchUpdateUserLinks(
        com.google.analytics.admin.v1alpha.BatchUpdateUserLinksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchUpdateUserLinksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a user link on an account or property.
     * </pre>
     */
    public com.google.protobuf.Empty deleteUserLink(
        com.google.analytics.admin.v1alpha.DeleteUserLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteUserLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes information about multiple users' links to an account or property.
     * </pre>
     */
    public com.google.protobuf.Empty batchDeleteUserLinks(
        com.google.analytics.admin.v1alpha.BatchDeleteUserLinksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchDeleteUserLinksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a FirebaseLink.
     * Properties can have at most one FirebaseLink.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.FirebaseLink createFirebaseLink(
        com.google.analytics.admin.v1alpha.CreateFirebaseLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFirebaseLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a FirebaseLink on a property
     * </pre>
     */
    public com.google.protobuf.Empty deleteFirebaseLink(
        com.google.analytics.admin.v1alpha.DeleteFirebaseLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFirebaseLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists FirebaseLinks on a property.
     * Properties can have at most one FirebaseLink.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListFirebaseLinksResponse listFirebaseLinks(
        com.google.analytics.admin.v1alpha.ListFirebaseLinksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFirebaseLinksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the Site Tag for the specified web stream.
     * Site Tags are immutable singletons.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.GlobalSiteTag getGlobalSiteTag(
        com.google.analytics.admin.v1alpha.GetGlobalSiteTagRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGlobalSiteTagMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a GoogleAdsLink.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.GoogleAdsLink createGoogleAdsLink(
        com.google.analytics.admin.v1alpha.CreateGoogleAdsLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateGoogleAdsLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a GoogleAdsLink on a property
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.GoogleAdsLink updateGoogleAdsLink(
        com.google.analytics.admin.v1alpha.UpdateGoogleAdsLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateGoogleAdsLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a GoogleAdsLink on a property
     * </pre>
     */
    public com.google.protobuf.Empty deleteGoogleAdsLink(
        com.google.analytics.admin.v1alpha.DeleteGoogleAdsLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteGoogleAdsLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists GoogleAdsLinks on a property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListGoogleAdsLinksResponse listGoogleAdsLinks(
        com.google.analytics.admin.v1alpha.ListGoogleAdsLinksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGoogleAdsLinksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get data sharing settings on an account.
     * Data sharing settings are singletons.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.DataSharingSettings getDataSharingSettings(
        com.google.analytics.admin.v1alpha.GetDataSharingSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataSharingSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single "GA4" MeasurementProtocolSecret.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.MeasurementProtocolSecret
        getMeasurementProtocolSecret(
            com.google.analytics.admin.v1alpha.GetMeasurementProtocolSecretRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMeasurementProtocolSecretMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns child MeasurementProtocolSecrets under the specified parent
     * Property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListMeasurementProtocolSecretsResponse
        listMeasurementProtocolSecrets(
            com.google.analytics.admin.v1alpha.ListMeasurementProtocolSecretsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMeasurementProtocolSecretsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a measurement protocol secret.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.MeasurementProtocolSecret
        createMeasurementProtocolSecret(
            com.google.analytics.admin.v1alpha.CreateMeasurementProtocolSecretRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMeasurementProtocolSecretMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes target MeasurementProtocolSecret.
     * </pre>
     */
    public com.google.protobuf.Empty deleteMeasurementProtocolSecret(
        com.google.analytics.admin.v1alpha.DeleteMeasurementProtocolSecretRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMeasurementProtocolSecretMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a measurement protocol secret.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.MeasurementProtocolSecret
        updateMeasurementProtocolSecret(
            com.google.analytics.admin.v1alpha.UpdateMeasurementProtocolSecretRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMeasurementProtocolSecretMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Acknowledges the terms of user data collection for the specified property.
     * This acknowledgement must be completed (either in the Google Analytics UI
     * or via this API) before MeasurementProtocolSecret resources may be created.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.AcknowledgeUserDataCollectionResponse
        acknowledgeUserDataCollection(
            com.google.analytics.admin.v1alpha.AcknowledgeUserDataCollectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAcknowledgeUserDataCollectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Searches through all changes to an account or its children given the
     * specified set of filters.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.SearchChangeHistoryEventsResponse
        searchChangeHistoryEvents(
            com.google.analytics.admin.v1alpha.SearchChangeHistoryEventsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchChangeHistoryEventsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for Google Signals settings for a property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.GoogleSignalsSettings getGoogleSignalsSettings(
        com.google.analytics.admin.v1alpha.GetGoogleSignalsSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGoogleSignalsSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates Google Signals settings for a property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.GoogleSignalsSettings updateGoogleSignalsSettings(
        com.google.analytics.admin.v1alpha.UpdateGoogleSignalsSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateGoogleSignalsSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a conversion event with the specified attributes.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ConversionEvent createConversionEvent(
        com.google.analytics.admin.v1alpha.CreateConversionEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateConversionEventMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single conversion event.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ConversionEvent getConversionEvent(
        com.google.analytics.admin.v1alpha.GetConversionEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConversionEventMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a conversion event in a property.
     * </pre>
     */
    public com.google.protobuf.Empty deleteConversionEvent(
        com.google.analytics.admin.v1alpha.DeleteConversionEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteConversionEventMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of conversion events in the specified parent property.
     * Returns an empty list if no conversion events are found.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListConversionEventsResponse listConversionEvents(
        com.google.analytics.admin.v1alpha.ListConversionEventsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConversionEventsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Look up a single DisplayVideo360AdvertiserLink
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink
        getDisplayVideo360AdvertiserLink(
            com.google.analytics.admin.v1alpha.GetDisplayVideo360AdvertiserLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDisplayVideo360AdvertiserLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all DisplayVideo360AdvertiserLinks on a property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinksResponse
        listDisplayVideo360AdvertiserLinks(
            com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDisplayVideo360AdvertiserLinksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a DisplayVideo360AdvertiserLink.
     * This can only be utilized by users who have proper authorization both on
     * the Google Analytics property and on the Display &amp; Video 360 advertiser.
     * Users who do not have access to the Display &amp; Video 360 advertiser should
     * instead seek to create a DisplayVideo360LinkProposal.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink
        createDisplayVideo360AdvertiserLink(
            com.google.analytics.admin.v1alpha.CreateDisplayVideo360AdvertiserLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDisplayVideo360AdvertiserLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a DisplayVideo360AdvertiserLink on a property.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDisplayVideo360AdvertiserLink(
        com.google.analytics.admin.v1alpha.DeleteDisplayVideo360AdvertiserLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDisplayVideo360AdvertiserLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a DisplayVideo360AdvertiserLink on a property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink
        updateDisplayVideo360AdvertiserLink(
            com.google.analytics.admin.v1alpha.UpdateDisplayVideo360AdvertiserLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDisplayVideo360AdvertiserLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single DisplayVideo360AdvertiserLinkProposal.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal
        getDisplayVideo360AdvertiserLinkProposal(
            com.google.analytics.admin.v1alpha.GetDisplayVideo360AdvertiserLinkProposalRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getGetDisplayVideo360AdvertiserLinkProposalMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists DisplayVideo360AdvertiserLinkProposals on a property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinkProposalsResponse
        listDisplayVideo360AdvertiserLinkProposals(
            com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinkProposalsRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getListDisplayVideo360AdvertiserLinkProposalsMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Creates a DisplayVideo360AdvertiserLinkProposal.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal
        createDisplayVideo360AdvertiserLinkProposal(
            com.google.analytics.admin.v1alpha.CreateDisplayVideo360AdvertiserLinkProposalRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getCreateDisplayVideo360AdvertiserLinkProposalMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a DisplayVideo360AdvertiserLinkProposal on a property.
     * This can only be used on cancelled proposals.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDisplayVideo360AdvertiserLinkProposal(
        com.google.analytics.admin.v1alpha.DeleteDisplayVideo360AdvertiserLinkProposalRequest
            request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getDeleteDisplayVideo360AdvertiserLinkProposalMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Approves a DisplayVideo360AdvertiserLinkProposal.
     * The DisplayVideo360AdvertiserLinkProposal will be deleted and a new
     * DisplayVideo360AdvertiserLink will be created.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ApproveDisplayVideo360AdvertiserLinkProposalResponse
        approveDisplayVideo360AdvertiserLinkProposal(
            com.google.analytics.admin.v1alpha.ApproveDisplayVideo360AdvertiserLinkProposalRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getApproveDisplayVideo360AdvertiserLinkProposalMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Cancels a DisplayVideo360AdvertiserLinkProposal.
     * Cancelling can mean either:
     * - Declining a proposal initiated from Display &amp; Video 360
     * - Withdrawing a proposal initiated from Google Analytics
     * After being cancelled, a proposal will eventually be deleted automatically.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal
        cancelDisplayVideo360AdvertiserLinkProposal(
            com.google.analytics.admin.v1alpha.CancelDisplayVideo360AdvertiserLinkProposalRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getCancelDisplayVideo360AdvertiserLinkProposalMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Creates a CustomDimension.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.CustomDimension createCustomDimension(
        com.google.analytics.admin.v1alpha.CreateCustomDimensionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCustomDimensionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a CustomDimension on a property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.CustomDimension updateCustomDimension(
        com.google.analytics.admin.v1alpha.UpdateCustomDimensionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCustomDimensionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists CustomDimensions on a property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListCustomDimensionsResponse listCustomDimensions(
        com.google.analytics.admin.v1alpha.ListCustomDimensionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCustomDimensionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Archives a CustomDimension on a property.
     * </pre>
     */
    public com.google.protobuf.Empty archiveCustomDimension(
        com.google.analytics.admin.v1alpha.ArchiveCustomDimensionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getArchiveCustomDimensionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single CustomDimension.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.CustomDimension getCustomDimension(
        com.google.analytics.admin.v1alpha.GetCustomDimensionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCustomDimensionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a CustomMetric.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.CustomMetric createCustomMetric(
        com.google.analytics.admin.v1alpha.CreateCustomMetricRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCustomMetricMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a CustomMetric on a property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.CustomMetric updateCustomMetric(
        com.google.analytics.admin.v1alpha.UpdateCustomMetricRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCustomMetricMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists CustomMetrics on a property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListCustomMetricsResponse listCustomMetrics(
        com.google.analytics.admin.v1alpha.ListCustomMetricsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCustomMetricsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Archives a CustomMetric on a property.
     * </pre>
     */
    public com.google.protobuf.Empty archiveCustomMetric(
        com.google.analytics.admin.v1alpha.ArchiveCustomMetricRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getArchiveCustomMetricMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single CustomMetric.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.CustomMetric getCustomMetric(
        com.google.analytics.admin.v1alpha.GetCustomMetricRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCustomMetricMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the singleton data retention settings for this property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.DataRetentionSettings getDataRetentionSettings(
        com.google.analytics.admin.v1alpha.GetDataRetentionSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataRetentionSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the singleton data retention settings for this property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.DataRetentionSettings updateDataRetentionSettings(
        com.google.analytics.admin.v1alpha.UpdateDataRetentionSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDataRetentionSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a DataStream.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.DataStream createDataStream(
        com.google.analytics.admin.v1alpha.CreateDataStreamRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDataStreamMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a DataStream on a property.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDataStream(
        com.google.analytics.admin.v1alpha.DeleteDataStreamRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDataStreamMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a DataStream on a property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.DataStream updateDataStream(
        com.google.analytics.admin.v1alpha.UpdateDataStreamRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDataStreamMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DataStreams on a property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListDataStreamsResponse listDataStreams(
        com.google.analytics.admin.v1alpha.ListDataStreamsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDataStreamsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single DataStream.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.DataStream getDataStream(
        com.google.analytics.admin.v1alpha.GetDataStreamRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataStreamMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single Audience.
     * Audiences created before 2020 may not be supported.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.Audience getAudience(
        com.google.analytics.admin.v1alpha.GetAudienceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAudienceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Audiences on a property.
     * Audiences created before 2020 may not be supported.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListAudiencesResponse listAudiences(
        com.google.analytics.admin.v1alpha.ListAudiencesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAudiencesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an Audience.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.Audience createAudience(
        com.google.analytics.admin.v1alpha.CreateAudienceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAudienceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an Audience on a property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.Audience updateAudience(
        com.google.analytics.admin.v1alpha.UpdateAudienceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAudienceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Archives an Audience on a property.
     * </pre>
     */
    public com.google.protobuf.Empty archiveAudience(
        com.google.analytics.admin.v1alpha.ArchiveAudienceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getArchiveAudienceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a AttributionSettings singleton.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.AttributionSettings getAttributionSettings(
        com.google.analytics.admin.v1alpha.GetAttributionSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAttributionSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates attribution settings on a property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.AttributionSettings updateAttributionSettings(
        com.google.analytics.admin.v1alpha.UpdateAttributionSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAttributionSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a customized report of data access records. The report provides
     * records of each time a user reads Google Analytics reporting data. Access
     * records are retained for up to 2 years.
     * Data Access Reports can be requested for a property. The property must be
     * in Google Analytics 360. This method is only available to Administrators.
     * These data access records include GA4 UI Reporting, GA4 UI Explorations,
     * GA4 Data API, and other products like Firebase &amp; Admob that can retrieve
     * data from Google Analytics through a linkage. These records don't include
     * property configuration changes like adding a stream or changing a
     * property's time zone. For configuration change history, see
     * [searchChangeHistoryEvents](https://developers.google.com/analytics/devguides/config/admin/v1/rest/v1alpha/accounts/searchChangeHistoryEvents).
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.RunAccessReportResponse runAccessReport(
        com.google.analytics.admin.v1alpha.RunAccessReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRunAccessReportMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service Interface for the Analytics Admin API (GA4).
   * </pre>
   */
  public static final class AnalyticsAdminServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AnalyticsAdminServiceFutureStub> {
    private AnalyticsAdminServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnalyticsAdminServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AnalyticsAdminServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single Account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.Account>
        getAccount(com.google.analytics.admin.v1alpha.GetAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAccountMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns all accounts accessible by the caller.
     * Note that these accounts might not currently have GA4 properties.
     * Soft-deleted (ie: "trashed") accounts are excluded by default.
     * Returns an empty list if no relevant accounts are found.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListAccountsResponse>
        listAccounts(com.google.analytics.admin.v1alpha.ListAccountsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAccountsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Marks target Account as soft-deleted (ie: "trashed") and returns it.
     * This API does not have a method to restore soft-deleted accounts.
     * However, they can be restored using the Trash Can UI.
     * If the accounts are not restored before the expiration time, the account
     * and all child resources (eg: Properties, GoogleAdsLinks, Streams,
     * UserLinks) will be permanently purged.
     * https://support.google.com/analytics/answer/6154772
     * Returns an error if the target is not found.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteAccount(com.google.analytics.admin.v1alpha.DeleteAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAccountMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.Account>
        updateAccount(com.google.analytics.admin.v1alpha.UpdateAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAccountMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Requests a ticket for creating an account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ProvisionAccountTicketResponse>
        provisionAccountTicket(
            com.google.analytics.admin.v1alpha.ProvisionAccountTicketRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getProvisionAccountTicketMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns summaries of all accounts accessible by the caller.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListAccountSummariesResponse>
        listAccountSummaries(
            com.google.analytics.admin.v1alpha.ListAccountSummariesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAccountSummariesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single "GA4" Property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.Property>
        getProperty(com.google.analytics.admin.v1alpha.GetPropertyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPropertyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns child Properties under the specified parent Account.
     * Only "GA4" properties will be returned.
     * Properties will be excluded if the caller does not have access.
     * Soft-deleted (ie: "trashed") properties are excluded by default.
     * Returns an empty list if no relevant properties are found.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListPropertiesResponse>
        listProperties(com.google.analytics.admin.v1alpha.ListPropertiesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPropertiesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an "GA4" property with the specified location and attributes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.Property>
        createProperty(com.google.analytics.admin.v1alpha.CreatePropertyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePropertyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Marks target Property as soft-deleted (ie: "trashed") and returns it.
     * This API does not have a method to restore soft-deleted properties.
     * However, they can be restored using the Trash Can UI.
     * If the properties are not restored before the expiration time, the Property
     * and all child resources (eg: GoogleAdsLinks, Streams, UserLinks)
     * will be permanently purged.
     * https://support.google.com/analytics/answer/6154772
     * Returns an error if the target is not found, or is not an GA4 Property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.Property>
        deleteProperty(com.google.analytics.admin.v1alpha.DeletePropertyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePropertyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.Property>
        updateProperty(com.google.analytics.admin.v1alpha.UpdatePropertyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePropertyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a user's link to an account or property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.UserLink>
        getUserLink(com.google.analytics.admin.v1alpha.GetUserLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about multiple users' links to an account or property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.BatchGetUserLinksResponse>
        batchGetUserLinks(com.google.analytics.admin.v1alpha.BatchGetUserLinksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchGetUserLinksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all user links on an account or property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListUserLinksResponse>
        listUserLinks(com.google.analytics.admin.v1alpha.ListUserLinksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListUserLinksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all user links on an account or property, including implicit ones
     * that come from effective permissions granted by groups or organization
     * admin roles.
     * If a returned user link does not have direct permissions, they cannot
     * be removed from the account or property directly with the DeleteUserLink
     * command. They have to be removed from the group/etc that gives them
     * permissions, which is currently only usable/discoverable in the GA or GMP
     * UIs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.AuditUserLinksResponse>
        auditUserLinks(com.google.analytics.admin.v1alpha.AuditUserLinksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAuditUserLinksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a user link on an account or property.
     * If the user with the specified email already has permissions on the
     * account or property, then the user's existing permissions will be unioned
     * with the permissions specified in the new UserLink.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.UserLink>
        createUserLink(com.google.analytics.admin.v1alpha.CreateUserLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateUserLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates information about multiple users' links to an account or property.
     * This method is transactional. If any UserLink cannot be created, none of
     * the UserLinks will be created.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.BatchCreateUserLinksResponse>
        batchCreateUserLinks(
            com.google.analytics.admin.v1alpha.BatchCreateUserLinksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchCreateUserLinksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a user link on an account or property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.UserLink>
        updateUserLink(com.google.analytics.admin.v1alpha.UpdateUserLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateUserLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates information about multiple users' links to an account or property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.BatchUpdateUserLinksResponse>
        batchUpdateUserLinks(
            com.google.analytics.admin.v1alpha.BatchUpdateUserLinksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchUpdateUserLinksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a user link on an account or property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteUserLink(com.google.analytics.admin.v1alpha.DeleteUserLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteUserLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes information about multiple users' links to an account or property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        batchDeleteUserLinks(
            com.google.analytics.admin.v1alpha.BatchDeleteUserLinksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchDeleteUserLinksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a FirebaseLink.
     * Properties can have at most one FirebaseLink.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.FirebaseLink>
        createFirebaseLink(com.google.analytics.admin.v1alpha.CreateFirebaseLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFirebaseLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a FirebaseLink on a property
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteFirebaseLink(com.google.analytics.admin.v1alpha.DeleteFirebaseLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteFirebaseLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists FirebaseLinks on a property.
     * Properties can have at most one FirebaseLink.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListFirebaseLinksResponse>
        listFirebaseLinks(com.google.analytics.admin.v1alpha.ListFirebaseLinksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFirebaseLinksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the Site Tag for the specified web stream.
     * Site Tags are immutable singletons.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.GlobalSiteTag>
        getGlobalSiteTag(com.google.analytics.admin.v1alpha.GetGlobalSiteTagRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGlobalSiteTagMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a GoogleAdsLink.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.GoogleAdsLink>
        createGoogleAdsLink(com.google.analytics.admin.v1alpha.CreateGoogleAdsLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateGoogleAdsLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a GoogleAdsLink on a property
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.GoogleAdsLink>
        updateGoogleAdsLink(com.google.analytics.admin.v1alpha.UpdateGoogleAdsLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateGoogleAdsLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a GoogleAdsLink on a property
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteGoogleAdsLink(com.google.analytics.admin.v1alpha.DeleteGoogleAdsLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteGoogleAdsLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists GoogleAdsLinks on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListGoogleAdsLinksResponse>
        listGoogleAdsLinks(com.google.analytics.admin.v1alpha.ListGoogleAdsLinksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListGoogleAdsLinksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get data sharing settings on an account.
     * Data sharing settings are singletons.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.DataSharingSettings>
        getDataSharingSettings(
            com.google.analytics.admin.v1alpha.GetDataSharingSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataSharingSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single "GA4" MeasurementProtocolSecret.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.MeasurementProtocolSecret>
        getMeasurementProtocolSecret(
            com.google.analytics.admin.v1alpha.GetMeasurementProtocolSecretRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMeasurementProtocolSecretMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns child MeasurementProtocolSecrets under the specified parent
     * Property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListMeasurementProtocolSecretsResponse>
        listMeasurementProtocolSecrets(
            com.google.analytics.admin.v1alpha.ListMeasurementProtocolSecretsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMeasurementProtocolSecretsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Creates a measurement protocol secret.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.MeasurementProtocolSecret>
        createMeasurementProtocolSecret(
            com.google.analytics.admin.v1alpha.CreateMeasurementProtocolSecretRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMeasurementProtocolSecretMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes target MeasurementProtocolSecret.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteMeasurementProtocolSecret(
            com.google.analytics.admin.v1alpha.DeleteMeasurementProtocolSecretRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMeasurementProtocolSecretMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Updates a measurement protocol secret.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.MeasurementProtocolSecret>
        updateMeasurementProtocolSecret(
            com.google.analytics.admin.v1alpha.UpdateMeasurementProtocolSecretRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMeasurementProtocolSecretMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Acknowledges the terms of user data collection for the specified property.
     * This acknowledgement must be completed (either in the Google Analytics UI
     * or via this API) before MeasurementProtocolSecret resources may be created.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.AcknowledgeUserDataCollectionResponse>
        acknowledgeUserDataCollection(
            com.google.analytics.admin.v1alpha.AcknowledgeUserDataCollectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAcknowledgeUserDataCollectionMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Searches through all changes to an account or its children given the
     * specified set of filters.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.SearchChangeHistoryEventsResponse>
        searchChangeHistoryEvents(
            com.google.analytics.admin.v1alpha.SearchChangeHistoryEventsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchChangeHistoryEventsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for Google Signals settings for a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.GoogleSignalsSettings>
        getGoogleSignalsSettings(
            com.google.analytics.admin.v1alpha.GetGoogleSignalsSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGoogleSignalsSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates Google Signals settings for a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.GoogleSignalsSettings>
        updateGoogleSignalsSettings(
            com.google.analytics.admin.v1alpha.UpdateGoogleSignalsSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateGoogleSignalsSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a conversion event with the specified attributes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ConversionEvent>
        createConversionEvent(
            com.google.analytics.admin.v1alpha.CreateConversionEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateConversionEventMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single conversion event.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ConversionEvent>
        getConversionEvent(com.google.analytics.admin.v1alpha.GetConversionEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetConversionEventMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a conversion event in a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteConversionEvent(
            com.google.analytics.admin.v1alpha.DeleteConversionEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteConversionEventMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of conversion events in the specified parent property.
     * Returns an empty list if no conversion events are found.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListConversionEventsResponse>
        listConversionEvents(
            com.google.analytics.admin.v1alpha.ListConversionEventsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListConversionEventsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Look up a single DisplayVideo360AdvertiserLink
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink>
        getDisplayVideo360AdvertiserLink(
            com.google.analytics.admin.v1alpha.GetDisplayVideo360AdvertiserLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDisplayVideo360AdvertiserLinkMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists all DisplayVideo360AdvertiserLinks on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinksResponse>
        listDisplayVideo360AdvertiserLinks(
            com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDisplayVideo360AdvertiserLinksMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Creates a DisplayVideo360AdvertiserLink.
     * This can only be utilized by users who have proper authorization both on
     * the Google Analytics property and on the Display &amp; Video 360 advertiser.
     * Users who do not have access to the Display &amp; Video 360 advertiser should
     * instead seek to create a DisplayVideo360LinkProposal.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink>
        createDisplayVideo360AdvertiserLink(
            com.google.analytics.admin.v1alpha.CreateDisplayVideo360AdvertiserLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDisplayVideo360AdvertiserLinkMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a DisplayVideo360AdvertiserLink on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteDisplayVideo360AdvertiserLink(
            com.google.analytics.admin.v1alpha.DeleteDisplayVideo360AdvertiserLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDisplayVideo360AdvertiserLinkMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Updates a DisplayVideo360AdvertiserLink on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink>
        updateDisplayVideo360AdvertiserLink(
            com.google.analytics.admin.v1alpha.UpdateDisplayVideo360AdvertiserLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDisplayVideo360AdvertiserLinkMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single DisplayVideo360AdvertiserLinkProposal.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal>
        getDisplayVideo360AdvertiserLinkProposal(
            com.google.analytics.admin.v1alpha.GetDisplayVideo360AdvertiserLinkProposalRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getGetDisplayVideo360AdvertiserLinkProposalMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists DisplayVideo360AdvertiserLinkProposals on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinkProposalsResponse>
        listDisplayVideo360AdvertiserLinkProposals(
            com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinkProposalsRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getListDisplayVideo360AdvertiserLinkProposalsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Creates a DisplayVideo360AdvertiserLinkProposal.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal>
        createDisplayVideo360AdvertiserLinkProposal(
            com.google.analytics.admin.v1alpha.CreateDisplayVideo360AdvertiserLinkProposalRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getCreateDisplayVideo360AdvertiserLinkProposalMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a DisplayVideo360AdvertiserLinkProposal on a property.
     * This can only be used on cancelled proposals.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteDisplayVideo360AdvertiserLinkProposal(
            com.google.analytics.admin.v1alpha.DeleteDisplayVideo360AdvertiserLinkProposalRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getDeleteDisplayVideo360AdvertiserLinkProposalMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Approves a DisplayVideo360AdvertiserLinkProposal.
     * The DisplayVideo360AdvertiserLinkProposal will be deleted and a new
     * DisplayVideo360AdvertiserLink will be created.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ApproveDisplayVideo360AdvertiserLinkProposalResponse>
        approveDisplayVideo360AdvertiserLinkProposal(
            com.google.analytics.admin.v1alpha.ApproveDisplayVideo360AdvertiserLinkProposalRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getApproveDisplayVideo360AdvertiserLinkProposalMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Cancels a DisplayVideo360AdvertiserLinkProposal.
     * Cancelling can mean either:
     * - Declining a proposal initiated from Display &amp; Video 360
     * - Withdrawing a proposal initiated from Google Analytics
     * After being cancelled, a proposal will eventually be deleted automatically.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal>
        cancelDisplayVideo360AdvertiserLinkProposal(
            com.google.analytics.admin.v1alpha.CancelDisplayVideo360AdvertiserLinkProposalRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getCancelDisplayVideo360AdvertiserLinkProposalMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Creates a CustomDimension.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.CustomDimension>
        createCustomDimension(
            com.google.analytics.admin.v1alpha.CreateCustomDimensionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCustomDimensionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a CustomDimension on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.CustomDimension>
        updateCustomDimension(
            com.google.analytics.admin.v1alpha.UpdateCustomDimensionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCustomDimensionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists CustomDimensions on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListCustomDimensionsResponse>
        listCustomDimensions(
            com.google.analytics.admin.v1alpha.ListCustomDimensionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCustomDimensionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Archives a CustomDimension on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        archiveCustomDimension(
            com.google.analytics.admin.v1alpha.ArchiveCustomDimensionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getArchiveCustomDimensionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single CustomDimension.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.CustomDimension>
        getCustomDimension(com.google.analytics.admin.v1alpha.GetCustomDimensionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCustomDimensionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a CustomMetric.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.CustomMetric>
        createCustomMetric(com.google.analytics.admin.v1alpha.CreateCustomMetricRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCustomMetricMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a CustomMetric on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.CustomMetric>
        updateCustomMetric(com.google.analytics.admin.v1alpha.UpdateCustomMetricRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCustomMetricMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists CustomMetrics on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListCustomMetricsResponse>
        listCustomMetrics(com.google.analytics.admin.v1alpha.ListCustomMetricsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCustomMetricsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Archives a CustomMetric on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        archiveCustomMetric(com.google.analytics.admin.v1alpha.ArchiveCustomMetricRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getArchiveCustomMetricMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single CustomMetric.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.CustomMetric>
        getCustomMetric(com.google.analytics.admin.v1alpha.GetCustomMetricRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCustomMetricMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the singleton data retention settings for this property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.DataRetentionSettings>
        getDataRetentionSettings(
            com.google.analytics.admin.v1alpha.GetDataRetentionSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataRetentionSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the singleton data retention settings for this property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.DataRetentionSettings>
        updateDataRetentionSettings(
            com.google.analytics.admin.v1alpha.UpdateDataRetentionSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDataRetentionSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a DataStream.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.DataStream>
        createDataStream(com.google.analytics.admin.v1alpha.CreateDataStreamRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDataStreamMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a DataStream on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteDataStream(com.google.analytics.admin.v1alpha.DeleteDataStreamRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDataStreamMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a DataStream on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.DataStream>
        updateDataStream(com.google.analytics.admin.v1alpha.UpdateDataStreamRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDataStreamMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DataStreams on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListDataStreamsResponse>
        listDataStreams(com.google.analytics.admin.v1alpha.ListDataStreamsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDataStreamsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single DataStream.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.DataStream>
        getDataStream(com.google.analytics.admin.v1alpha.GetDataStreamRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataStreamMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single Audience.
     * Audiences created before 2020 may not be supported.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.Audience>
        getAudience(com.google.analytics.admin.v1alpha.GetAudienceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAudienceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Audiences on a property.
     * Audiences created before 2020 may not be supported.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListAudiencesResponse>
        listAudiences(com.google.analytics.admin.v1alpha.ListAudiencesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAudiencesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an Audience.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.Audience>
        createAudience(com.google.analytics.admin.v1alpha.CreateAudienceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAudienceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an Audience on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.Audience>
        updateAudience(com.google.analytics.admin.v1alpha.UpdateAudienceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAudienceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Archives an Audience on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        archiveAudience(com.google.analytics.admin.v1alpha.ArchiveAudienceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getArchiveAudienceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a AttributionSettings singleton.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.AttributionSettings>
        getAttributionSettings(
            com.google.analytics.admin.v1alpha.GetAttributionSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAttributionSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates attribution settings on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.AttributionSettings>
        updateAttributionSettings(
            com.google.analytics.admin.v1alpha.UpdateAttributionSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAttributionSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a customized report of data access records. The report provides
     * records of each time a user reads Google Analytics reporting data. Access
     * records are retained for up to 2 years.
     * Data Access Reports can be requested for a property. The property must be
     * in Google Analytics 360. This method is only available to Administrators.
     * These data access records include GA4 UI Reporting, GA4 UI Explorations,
     * GA4 Data API, and other products like Firebase &amp; Admob that can retrieve
     * data from Google Analytics through a linkage. These records don't include
     * property configuration changes like adding a stream or changing a
     * property's time zone. For configuration change history, see
     * [searchChangeHistoryEvents](https://developers.google.com/analytics/devguides/config/admin/v1/rest/v1alpha/accounts/searchChangeHistoryEvents).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.RunAccessReportResponse>
        runAccessReport(com.google.analytics.admin.v1alpha.RunAccessReportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRunAccessReportMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ACCOUNT = 0;
  private static final int METHODID_LIST_ACCOUNTS = 1;
  private static final int METHODID_DELETE_ACCOUNT = 2;
  private static final int METHODID_UPDATE_ACCOUNT = 3;
  private static final int METHODID_PROVISION_ACCOUNT_TICKET = 4;
  private static final int METHODID_LIST_ACCOUNT_SUMMARIES = 5;
  private static final int METHODID_GET_PROPERTY = 6;
  private static final int METHODID_LIST_PROPERTIES = 7;
  private static final int METHODID_CREATE_PROPERTY = 8;
  private static final int METHODID_DELETE_PROPERTY = 9;
  private static final int METHODID_UPDATE_PROPERTY = 10;
  private static final int METHODID_GET_USER_LINK = 11;
  private static final int METHODID_BATCH_GET_USER_LINKS = 12;
  private static final int METHODID_LIST_USER_LINKS = 13;
  private static final int METHODID_AUDIT_USER_LINKS = 14;
  private static final int METHODID_CREATE_USER_LINK = 15;
  private static final int METHODID_BATCH_CREATE_USER_LINKS = 16;
  private static final int METHODID_UPDATE_USER_LINK = 17;
  private static final int METHODID_BATCH_UPDATE_USER_LINKS = 18;
  private static final int METHODID_DELETE_USER_LINK = 19;
  private static final int METHODID_BATCH_DELETE_USER_LINKS = 20;
  private static final int METHODID_CREATE_FIREBASE_LINK = 21;
  private static final int METHODID_DELETE_FIREBASE_LINK = 22;
  private static final int METHODID_LIST_FIREBASE_LINKS = 23;
  private static final int METHODID_GET_GLOBAL_SITE_TAG = 24;
  private static final int METHODID_CREATE_GOOGLE_ADS_LINK = 25;
  private static final int METHODID_UPDATE_GOOGLE_ADS_LINK = 26;
  private static final int METHODID_DELETE_GOOGLE_ADS_LINK = 27;
  private static final int METHODID_LIST_GOOGLE_ADS_LINKS = 28;
  private static final int METHODID_GET_DATA_SHARING_SETTINGS = 29;
  private static final int METHODID_GET_MEASUREMENT_PROTOCOL_SECRET = 30;
  private static final int METHODID_LIST_MEASUREMENT_PROTOCOL_SECRETS = 31;
  private static final int METHODID_CREATE_MEASUREMENT_PROTOCOL_SECRET = 32;
  private static final int METHODID_DELETE_MEASUREMENT_PROTOCOL_SECRET = 33;
  private static final int METHODID_UPDATE_MEASUREMENT_PROTOCOL_SECRET = 34;
  private static final int METHODID_ACKNOWLEDGE_USER_DATA_COLLECTION = 35;
  private static final int METHODID_SEARCH_CHANGE_HISTORY_EVENTS = 36;
  private static final int METHODID_GET_GOOGLE_SIGNALS_SETTINGS = 37;
  private static final int METHODID_UPDATE_GOOGLE_SIGNALS_SETTINGS = 38;
  private static final int METHODID_CREATE_CONVERSION_EVENT = 39;
  private static final int METHODID_GET_CONVERSION_EVENT = 40;
  private static final int METHODID_DELETE_CONVERSION_EVENT = 41;
  private static final int METHODID_LIST_CONVERSION_EVENTS = 42;
  private static final int METHODID_GET_DISPLAY_VIDEO360ADVERTISER_LINK = 43;
  private static final int METHODID_LIST_DISPLAY_VIDEO360ADVERTISER_LINKS = 44;
  private static final int METHODID_CREATE_DISPLAY_VIDEO360ADVERTISER_LINK = 45;
  private static final int METHODID_DELETE_DISPLAY_VIDEO360ADVERTISER_LINK = 46;
  private static final int METHODID_UPDATE_DISPLAY_VIDEO360ADVERTISER_LINK = 47;
  private static final int METHODID_GET_DISPLAY_VIDEO360ADVERTISER_LINK_PROPOSAL = 48;
  private static final int METHODID_LIST_DISPLAY_VIDEO360ADVERTISER_LINK_PROPOSALS = 49;
  private static final int METHODID_CREATE_DISPLAY_VIDEO360ADVERTISER_LINK_PROPOSAL = 50;
  private static final int METHODID_DELETE_DISPLAY_VIDEO360ADVERTISER_LINK_PROPOSAL = 51;
  private static final int METHODID_APPROVE_DISPLAY_VIDEO360ADVERTISER_LINK_PROPOSAL = 52;
  private static final int METHODID_CANCEL_DISPLAY_VIDEO360ADVERTISER_LINK_PROPOSAL = 53;
  private static final int METHODID_CREATE_CUSTOM_DIMENSION = 54;
  private static final int METHODID_UPDATE_CUSTOM_DIMENSION = 55;
  private static final int METHODID_LIST_CUSTOM_DIMENSIONS = 56;
  private static final int METHODID_ARCHIVE_CUSTOM_DIMENSION = 57;
  private static final int METHODID_GET_CUSTOM_DIMENSION = 58;
  private static final int METHODID_CREATE_CUSTOM_METRIC = 59;
  private static final int METHODID_UPDATE_CUSTOM_METRIC = 60;
  private static final int METHODID_LIST_CUSTOM_METRICS = 61;
  private static final int METHODID_ARCHIVE_CUSTOM_METRIC = 62;
  private static final int METHODID_GET_CUSTOM_METRIC = 63;
  private static final int METHODID_GET_DATA_RETENTION_SETTINGS = 64;
  private static final int METHODID_UPDATE_DATA_RETENTION_SETTINGS = 65;
  private static final int METHODID_CREATE_DATA_STREAM = 66;
  private static final int METHODID_DELETE_DATA_STREAM = 67;
  private static final int METHODID_UPDATE_DATA_STREAM = 68;
  private static final int METHODID_LIST_DATA_STREAMS = 69;
  private static final int METHODID_GET_DATA_STREAM = 70;
  private static final int METHODID_GET_AUDIENCE = 71;
  private static final int METHODID_LIST_AUDIENCES = 72;
  private static final int METHODID_CREATE_AUDIENCE = 73;
  private static final int METHODID_UPDATE_AUDIENCE = 74;
  private static final int METHODID_ARCHIVE_AUDIENCE = 75;
  private static final int METHODID_GET_ATTRIBUTION_SETTINGS = 76;
  private static final int METHODID_UPDATE_ATTRIBUTION_SETTINGS = 77;
  private static final int METHODID_RUN_ACCESS_REPORT = 78;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AnalyticsAdminServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AnalyticsAdminServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ACCOUNT:
          serviceImpl.getAccount(
              (com.google.analytics.admin.v1alpha.GetAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Account>)
                  responseObserver);
          break;
        case METHODID_LIST_ACCOUNTS:
          serviceImpl.listAccounts(
              (com.google.analytics.admin.v1alpha.ListAccountsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListAccountsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_ACCOUNT:
          serviceImpl.deleteAccount(
              (com.google.analytics.admin.v1alpha.DeleteAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_ACCOUNT:
          serviceImpl.updateAccount(
              (com.google.analytics.admin.v1alpha.UpdateAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Account>)
                  responseObserver);
          break;
        case METHODID_PROVISION_ACCOUNT_TICKET:
          serviceImpl.provisionAccountTicket(
              (com.google.analytics.admin.v1alpha.ProvisionAccountTicketRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.ProvisionAccountTicketResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_ACCOUNT_SUMMARIES:
          serviceImpl.listAccountSummaries(
              (com.google.analytics.admin.v1alpha.ListAccountSummariesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.ListAccountSummariesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PROPERTY:
          serviceImpl.getProperty(
              (com.google.analytics.admin.v1alpha.GetPropertyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Property>)
                  responseObserver);
          break;
        case METHODID_LIST_PROPERTIES:
          serviceImpl.listProperties(
              (com.google.analytics.admin.v1alpha.ListPropertiesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.ListPropertiesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_PROPERTY:
          serviceImpl.createProperty(
              (com.google.analytics.admin.v1alpha.CreatePropertyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Property>)
                  responseObserver);
          break;
        case METHODID_DELETE_PROPERTY:
          serviceImpl.deleteProperty(
              (com.google.analytics.admin.v1alpha.DeletePropertyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Property>)
                  responseObserver);
          break;
        case METHODID_UPDATE_PROPERTY:
          serviceImpl.updateProperty(
              (com.google.analytics.admin.v1alpha.UpdatePropertyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Property>)
                  responseObserver);
          break;
        case METHODID_GET_USER_LINK:
          serviceImpl.getUserLink(
              (com.google.analytics.admin.v1alpha.GetUserLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.UserLink>)
                  responseObserver);
          break;
        case METHODID_BATCH_GET_USER_LINKS:
          serviceImpl.batchGetUserLinks(
              (com.google.analytics.admin.v1alpha.BatchGetUserLinksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.BatchGetUserLinksResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_USER_LINKS:
          serviceImpl.listUserLinks(
              (com.google.analytics.admin.v1alpha.ListUserLinksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.ListUserLinksResponse>)
                  responseObserver);
          break;
        case METHODID_AUDIT_USER_LINKS:
          serviceImpl.auditUserLinks(
              (com.google.analytics.admin.v1alpha.AuditUserLinksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.AuditUserLinksResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_USER_LINK:
          serviceImpl.createUserLink(
              (com.google.analytics.admin.v1alpha.CreateUserLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.UserLink>)
                  responseObserver);
          break;
        case METHODID_BATCH_CREATE_USER_LINKS:
          serviceImpl.batchCreateUserLinks(
              (com.google.analytics.admin.v1alpha.BatchCreateUserLinksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.BatchCreateUserLinksResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_USER_LINK:
          serviceImpl.updateUserLink(
              (com.google.analytics.admin.v1alpha.UpdateUserLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.UserLink>)
                  responseObserver);
          break;
        case METHODID_BATCH_UPDATE_USER_LINKS:
          serviceImpl.batchUpdateUserLinks(
              (com.google.analytics.admin.v1alpha.BatchUpdateUserLinksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.BatchUpdateUserLinksResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_USER_LINK:
          serviceImpl.deleteUserLink(
              (com.google.analytics.admin.v1alpha.DeleteUserLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_BATCH_DELETE_USER_LINKS:
          serviceImpl.batchDeleteUserLinks(
              (com.google.analytics.admin.v1alpha.BatchDeleteUserLinksRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_FIREBASE_LINK:
          serviceImpl.createFirebaseLink(
              (com.google.analytics.admin.v1alpha.CreateFirebaseLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.FirebaseLink>)
                  responseObserver);
          break;
        case METHODID_DELETE_FIREBASE_LINK:
          serviceImpl.deleteFirebaseLink(
              (com.google.analytics.admin.v1alpha.DeleteFirebaseLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_FIREBASE_LINKS:
          serviceImpl.listFirebaseLinks(
              (com.google.analytics.admin.v1alpha.ListFirebaseLinksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.ListFirebaseLinksResponse>)
                  responseObserver);
          break;
        case METHODID_GET_GLOBAL_SITE_TAG:
          serviceImpl.getGlobalSiteTag(
              (com.google.analytics.admin.v1alpha.GetGlobalSiteTagRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.GlobalSiteTag>)
                  responseObserver);
          break;
        case METHODID_CREATE_GOOGLE_ADS_LINK:
          serviceImpl.createGoogleAdsLink(
              (com.google.analytics.admin.v1alpha.CreateGoogleAdsLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.GoogleAdsLink>)
                  responseObserver);
          break;
        case METHODID_UPDATE_GOOGLE_ADS_LINK:
          serviceImpl.updateGoogleAdsLink(
              (com.google.analytics.admin.v1alpha.UpdateGoogleAdsLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.GoogleAdsLink>)
                  responseObserver);
          break;
        case METHODID_DELETE_GOOGLE_ADS_LINK:
          serviceImpl.deleteGoogleAdsLink(
              (com.google.analytics.admin.v1alpha.DeleteGoogleAdsLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_GOOGLE_ADS_LINKS:
          serviceImpl.listGoogleAdsLinks(
              (com.google.analytics.admin.v1alpha.ListGoogleAdsLinksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.ListGoogleAdsLinksResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DATA_SHARING_SETTINGS:
          serviceImpl.getDataSharingSettings(
              (com.google.analytics.admin.v1alpha.GetDataSharingSettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.DataSharingSettings>)
                  responseObserver);
          break;
        case METHODID_GET_MEASUREMENT_PROTOCOL_SECRET:
          serviceImpl.getMeasurementProtocolSecret(
              (com.google.analytics.admin.v1alpha.GetMeasurementProtocolSecretRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.MeasurementProtocolSecret>)
                  responseObserver);
          break;
        case METHODID_LIST_MEASUREMENT_PROTOCOL_SECRETS:
          serviceImpl.listMeasurementProtocolSecrets(
              (com.google.analytics.admin.v1alpha.ListMeasurementProtocolSecretsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.ListMeasurementProtocolSecretsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_MEASUREMENT_PROTOCOL_SECRET:
          serviceImpl.createMeasurementProtocolSecret(
              (com.google.analytics.admin.v1alpha.CreateMeasurementProtocolSecretRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.MeasurementProtocolSecret>)
                  responseObserver);
          break;
        case METHODID_DELETE_MEASUREMENT_PROTOCOL_SECRET:
          serviceImpl.deleteMeasurementProtocolSecret(
              (com.google.analytics.admin.v1alpha.DeleteMeasurementProtocolSecretRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_MEASUREMENT_PROTOCOL_SECRET:
          serviceImpl.updateMeasurementProtocolSecret(
              (com.google.analytics.admin.v1alpha.UpdateMeasurementProtocolSecretRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.MeasurementProtocolSecret>)
                  responseObserver);
          break;
        case METHODID_ACKNOWLEDGE_USER_DATA_COLLECTION:
          serviceImpl.acknowledgeUserDataCollection(
              (com.google.analytics.admin.v1alpha.AcknowledgeUserDataCollectionRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.AcknowledgeUserDataCollectionResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_CHANGE_HISTORY_EVENTS:
          serviceImpl.searchChangeHistoryEvents(
              (com.google.analytics.admin.v1alpha.SearchChangeHistoryEventsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.SearchChangeHistoryEventsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_GOOGLE_SIGNALS_SETTINGS:
          serviceImpl.getGoogleSignalsSettings(
              (com.google.analytics.admin.v1alpha.GetGoogleSignalsSettingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.GoogleSignalsSettings>)
                  responseObserver);
          break;
        case METHODID_UPDATE_GOOGLE_SIGNALS_SETTINGS:
          serviceImpl.updateGoogleSignalsSettings(
              (com.google.analytics.admin.v1alpha.UpdateGoogleSignalsSettingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.GoogleSignalsSettings>)
                  responseObserver);
          break;
        case METHODID_CREATE_CONVERSION_EVENT:
          serviceImpl.createConversionEvent(
              (com.google.analytics.admin.v1alpha.CreateConversionEventRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ConversionEvent>)
                  responseObserver);
          break;
        case METHODID_GET_CONVERSION_EVENT:
          serviceImpl.getConversionEvent(
              (com.google.analytics.admin.v1alpha.GetConversionEventRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ConversionEvent>)
                  responseObserver);
          break;
        case METHODID_DELETE_CONVERSION_EVENT:
          serviceImpl.deleteConversionEvent(
              (com.google.analytics.admin.v1alpha.DeleteConversionEventRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_CONVERSION_EVENTS:
          serviceImpl.listConversionEvents(
              (com.google.analytics.admin.v1alpha.ListConversionEventsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.ListConversionEventsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DISPLAY_VIDEO360ADVERTISER_LINK:
          serviceImpl.getDisplayVideo360AdvertiserLink(
              (com.google.analytics.admin.v1alpha.GetDisplayVideo360AdvertiserLinkRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink>)
                  responseObserver);
          break;
        case METHODID_LIST_DISPLAY_VIDEO360ADVERTISER_LINKS:
          serviceImpl.listDisplayVideo360AdvertiserLinks(
              (com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinksRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha
                          .ListDisplayVideo360AdvertiserLinksResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_DISPLAY_VIDEO360ADVERTISER_LINK:
          serviceImpl.createDisplayVideo360AdvertiserLink(
              (com.google.analytics.admin.v1alpha.CreateDisplayVideo360AdvertiserLinkRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink>)
                  responseObserver);
          break;
        case METHODID_DELETE_DISPLAY_VIDEO360ADVERTISER_LINK:
          serviceImpl.deleteDisplayVideo360AdvertiserLink(
              (com.google.analytics.admin.v1alpha.DeleteDisplayVideo360AdvertiserLinkRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_DISPLAY_VIDEO360ADVERTISER_LINK:
          serviceImpl.updateDisplayVideo360AdvertiserLink(
              (com.google.analytics.admin.v1alpha.UpdateDisplayVideo360AdvertiserLinkRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink>)
                  responseObserver);
          break;
        case METHODID_GET_DISPLAY_VIDEO360ADVERTISER_LINK_PROPOSAL:
          serviceImpl.getDisplayVideo360AdvertiserLinkProposal(
              (com.google.analytics.admin.v1alpha.GetDisplayVideo360AdvertiserLinkProposalRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal>)
                  responseObserver);
          break;
        case METHODID_LIST_DISPLAY_VIDEO360ADVERTISER_LINK_PROPOSALS:
          serviceImpl.listDisplayVideo360AdvertiserLinkProposals(
              (com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinkProposalsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha
                          .ListDisplayVideo360AdvertiserLinkProposalsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_DISPLAY_VIDEO360ADVERTISER_LINK_PROPOSAL:
          serviceImpl.createDisplayVideo360AdvertiserLinkProposal(
              (com.google.analytics.admin.v1alpha
                      .CreateDisplayVideo360AdvertiserLinkProposalRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal>)
                  responseObserver);
          break;
        case METHODID_DELETE_DISPLAY_VIDEO360ADVERTISER_LINK_PROPOSAL:
          serviceImpl.deleteDisplayVideo360AdvertiserLinkProposal(
              (com.google.analytics.admin.v1alpha
                      .DeleteDisplayVideo360AdvertiserLinkProposalRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_APPROVE_DISPLAY_VIDEO360ADVERTISER_LINK_PROPOSAL:
          serviceImpl.approveDisplayVideo360AdvertiserLinkProposal(
              (com.google.analytics.admin.v1alpha
                      .ApproveDisplayVideo360AdvertiserLinkProposalRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha
                          .ApproveDisplayVideo360AdvertiserLinkProposalResponse>)
                  responseObserver);
          break;
        case METHODID_CANCEL_DISPLAY_VIDEO360ADVERTISER_LINK_PROPOSAL:
          serviceImpl.cancelDisplayVideo360AdvertiserLinkProposal(
              (com.google.analytics.admin.v1alpha
                      .CancelDisplayVideo360AdvertiserLinkProposalRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal>)
                  responseObserver);
          break;
        case METHODID_CREATE_CUSTOM_DIMENSION:
          serviceImpl.createCustomDimension(
              (com.google.analytics.admin.v1alpha.CreateCustomDimensionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.CustomDimension>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CUSTOM_DIMENSION:
          serviceImpl.updateCustomDimension(
              (com.google.analytics.admin.v1alpha.UpdateCustomDimensionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.CustomDimension>)
                  responseObserver);
          break;
        case METHODID_LIST_CUSTOM_DIMENSIONS:
          serviceImpl.listCustomDimensions(
              (com.google.analytics.admin.v1alpha.ListCustomDimensionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.ListCustomDimensionsResponse>)
                  responseObserver);
          break;
        case METHODID_ARCHIVE_CUSTOM_DIMENSION:
          serviceImpl.archiveCustomDimension(
              (com.google.analytics.admin.v1alpha.ArchiveCustomDimensionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_CUSTOM_DIMENSION:
          serviceImpl.getCustomDimension(
              (com.google.analytics.admin.v1alpha.GetCustomDimensionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.CustomDimension>)
                  responseObserver);
          break;
        case METHODID_CREATE_CUSTOM_METRIC:
          serviceImpl.createCustomMetric(
              (com.google.analytics.admin.v1alpha.CreateCustomMetricRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.CustomMetric>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CUSTOM_METRIC:
          serviceImpl.updateCustomMetric(
              (com.google.analytics.admin.v1alpha.UpdateCustomMetricRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.CustomMetric>)
                  responseObserver);
          break;
        case METHODID_LIST_CUSTOM_METRICS:
          serviceImpl.listCustomMetrics(
              (com.google.analytics.admin.v1alpha.ListCustomMetricsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.ListCustomMetricsResponse>)
                  responseObserver);
          break;
        case METHODID_ARCHIVE_CUSTOM_METRIC:
          serviceImpl.archiveCustomMetric(
              (com.google.analytics.admin.v1alpha.ArchiveCustomMetricRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_CUSTOM_METRIC:
          serviceImpl.getCustomMetric(
              (com.google.analytics.admin.v1alpha.GetCustomMetricRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.CustomMetric>)
                  responseObserver);
          break;
        case METHODID_GET_DATA_RETENTION_SETTINGS:
          serviceImpl.getDataRetentionSettings(
              (com.google.analytics.admin.v1alpha.GetDataRetentionSettingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.DataRetentionSettings>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DATA_RETENTION_SETTINGS:
          serviceImpl.updateDataRetentionSettings(
              (com.google.analytics.admin.v1alpha.UpdateDataRetentionSettingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.DataRetentionSettings>)
                  responseObserver);
          break;
        case METHODID_CREATE_DATA_STREAM:
          serviceImpl.createDataStream(
              (com.google.analytics.admin.v1alpha.CreateDataStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.DataStream>)
                  responseObserver);
          break;
        case METHODID_DELETE_DATA_STREAM:
          serviceImpl.deleteDataStream(
              (com.google.analytics.admin.v1alpha.DeleteDataStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_DATA_STREAM:
          serviceImpl.updateDataStream(
              (com.google.analytics.admin.v1alpha.UpdateDataStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.DataStream>)
                  responseObserver);
          break;
        case METHODID_LIST_DATA_STREAMS:
          serviceImpl.listDataStreams(
              (com.google.analytics.admin.v1alpha.ListDataStreamsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.ListDataStreamsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DATA_STREAM:
          serviceImpl.getDataStream(
              (com.google.analytics.admin.v1alpha.GetDataStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.DataStream>)
                  responseObserver);
          break;
        case METHODID_GET_AUDIENCE:
          serviceImpl.getAudience(
              (com.google.analytics.admin.v1alpha.GetAudienceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Audience>)
                  responseObserver);
          break;
        case METHODID_LIST_AUDIENCES:
          serviceImpl.listAudiences(
              (com.google.analytics.admin.v1alpha.ListAudiencesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.ListAudiencesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_AUDIENCE:
          serviceImpl.createAudience(
              (com.google.analytics.admin.v1alpha.CreateAudienceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Audience>)
                  responseObserver);
          break;
        case METHODID_UPDATE_AUDIENCE:
          serviceImpl.updateAudience(
              (com.google.analytics.admin.v1alpha.UpdateAudienceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Audience>)
                  responseObserver);
          break;
        case METHODID_ARCHIVE_AUDIENCE:
          serviceImpl.archiveAudience(
              (com.google.analytics.admin.v1alpha.ArchiveAudienceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_ATTRIBUTION_SETTINGS:
          serviceImpl.getAttributionSettings(
              (com.google.analytics.admin.v1alpha.GetAttributionSettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AttributionSettings>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ATTRIBUTION_SETTINGS:
          serviceImpl.updateAttributionSettings(
              (com.google.analytics.admin.v1alpha.UpdateAttributionSettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AttributionSettings>)
                  responseObserver);
          break;
        case METHODID_RUN_ACCESS_REPORT:
          serviceImpl.runAccessReport(
              (com.google.analytics.admin.v1alpha.RunAccessReportRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.RunAccessReportResponse>)
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

  private abstract static class AnalyticsAdminServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AnalyticsAdminServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.analytics.admin.v1alpha.AnalyticsAdminProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AnalyticsAdminService");
    }
  }

  private static final class AnalyticsAdminServiceFileDescriptorSupplier
      extends AnalyticsAdminServiceBaseDescriptorSupplier {
    AnalyticsAdminServiceFileDescriptorSupplier() {}
  }

  private static final class AnalyticsAdminServiceMethodDescriptorSupplier
      extends AnalyticsAdminServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AnalyticsAdminServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AnalyticsAdminServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AnalyticsAdminServiceFileDescriptorSupplier())
                      .addMethod(getGetAccountMethod())
                      .addMethod(getListAccountsMethod())
                      .addMethod(getDeleteAccountMethod())
                      .addMethod(getUpdateAccountMethod())
                      .addMethod(getProvisionAccountTicketMethod())
                      .addMethod(getListAccountSummariesMethod())
                      .addMethod(getGetPropertyMethod())
                      .addMethod(getListPropertiesMethod())
                      .addMethod(getCreatePropertyMethod())
                      .addMethod(getDeletePropertyMethod())
                      .addMethod(getUpdatePropertyMethod())
                      .addMethod(getGetUserLinkMethod())
                      .addMethod(getBatchGetUserLinksMethod())
                      .addMethod(getListUserLinksMethod())
                      .addMethod(getAuditUserLinksMethod())
                      .addMethod(getCreateUserLinkMethod())
                      .addMethod(getBatchCreateUserLinksMethod())
                      .addMethod(getUpdateUserLinkMethod())
                      .addMethod(getBatchUpdateUserLinksMethod())
                      .addMethod(getDeleteUserLinkMethod())
                      .addMethod(getBatchDeleteUserLinksMethod())
                      .addMethod(getCreateFirebaseLinkMethod())
                      .addMethod(getDeleteFirebaseLinkMethod())
                      .addMethod(getListFirebaseLinksMethod())
                      .addMethod(getGetGlobalSiteTagMethod())
                      .addMethod(getCreateGoogleAdsLinkMethod())
                      .addMethod(getUpdateGoogleAdsLinkMethod())
                      .addMethod(getDeleteGoogleAdsLinkMethod())
                      .addMethod(getListGoogleAdsLinksMethod())
                      .addMethod(getGetDataSharingSettingsMethod())
                      .addMethod(getGetMeasurementProtocolSecretMethod())
                      .addMethod(getListMeasurementProtocolSecretsMethod())
                      .addMethod(getCreateMeasurementProtocolSecretMethod())
                      .addMethod(getDeleteMeasurementProtocolSecretMethod())
                      .addMethod(getUpdateMeasurementProtocolSecretMethod())
                      .addMethod(getAcknowledgeUserDataCollectionMethod())
                      .addMethod(getSearchChangeHistoryEventsMethod())
                      .addMethod(getGetGoogleSignalsSettingsMethod())
                      .addMethod(getUpdateGoogleSignalsSettingsMethod())
                      .addMethod(getCreateConversionEventMethod())
                      .addMethod(getGetConversionEventMethod())
                      .addMethod(getDeleteConversionEventMethod())
                      .addMethod(getListConversionEventsMethod())
                      .addMethod(getGetDisplayVideo360AdvertiserLinkMethod())
                      .addMethod(getListDisplayVideo360AdvertiserLinksMethod())
                      .addMethod(getCreateDisplayVideo360AdvertiserLinkMethod())
                      .addMethod(getDeleteDisplayVideo360AdvertiserLinkMethod())
                      .addMethod(getUpdateDisplayVideo360AdvertiserLinkMethod())
                      .addMethod(getGetDisplayVideo360AdvertiserLinkProposalMethod())
                      .addMethod(getListDisplayVideo360AdvertiserLinkProposalsMethod())
                      .addMethod(getCreateDisplayVideo360AdvertiserLinkProposalMethod())
                      .addMethod(getDeleteDisplayVideo360AdvertiserLinkProposalMethod())
                      .addMethod(getApproveDisplayVideo360AdvertiserLinkProposalMethod())
                      .addMethod(getCancelDisplayVideo360AdvertiserLinkProposalMethod())
                      .addMethod(getCreateCustomDimensionMethod())
                      .addMethod(getUpdateCustomDimensionMethod())
                      .addMethod(getListCustomDimensionsMethod())
                      .addMethod(getArchiveCustomDimensionMethod())
                      .addMethod(getGetCustomDimensionMethod())
                      .addMethod(getCreateCustomMetricMethod())
                      .addMethod(getUpdateCustomMetricMethod())
                      .addMethod(getListCustomMetricsMethod())
                      .addMethod(getArchiveCustomMetricMethod())
                      .addMethod(getGetCustomMetricMethod())
                      .addMethod(getGetDataRetentionSettingsMethod())
                      .addMethod(getUpdateDataRetentionSettingsMethod())
                      .addMethod(getCreateDataStreamMethod())
                      .addMethod(getDeleteDataStreamMethod())
                      .addMethod(getUpdateDataStreamMethod())
                      .addMethod(getListDataStreamsMethod())
                      .addMethod(getGetDataStreamMethod())
                      .addMethod(getGetAudienceMethod())
                      .addMethod(getListAudiencesMethod())
                      .addMethod(getCreateAudienceMethod())
                      .addMethod(getUpdateAudienceMethod())
                      .addMethod(getArchiveAudienceMethod())
                      .addMethod(getGetAttributionSettingsMethod())
                      .addMethod(getUpdateAttributionSettingsMethod())
                      .addMethod(getRunAccessReportMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
