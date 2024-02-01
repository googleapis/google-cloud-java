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

  public static final java.lang.String SERVICE_NAME =
      "google.analytics.admin.v1alpha.AnalyticsAdminService";

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
          com.google.analytics.admin.v1alpha.GetSKAdNetworkConversionValueSchemaRequest,
          com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema>
      getGetSKAdNetworkConversionValueSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSKAdNetworkConversionValueSchema",
      requestType =
          com.google.analytics.admin.v1alpha.GetSKAdNetworkConversionValueSchemaRequest.class,
      responseType = com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetSKAdNetworkConversionValueSchemaRequest,
          com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema>
      getGetSKAdNetworkConversionValueSchemaMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetSKAdNetworkConversionValueSchemaRequest,
            com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema>
        getGetSKAdNetworkConversionValueSchemaMethod;
    if ((getGetSKAdNetworkConversionValueSchemaMethod =
            AnalyticsAdminServiceGrpc.getGetSKAdNetworkConversionValueSchemaMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetSKAdNetworkConversionValueSchemaMethod =
                AnalyticsAdminServiceGrpc.getGetSKAdNetworkConversionValueSchemaMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getGetSKAdNetworkConversionValueSchemaMethod =
              getGetSKAdNetworkConversionValueSchemaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha
                              .GetSKAdNetworkConversionValueSchemaRequest,
                          com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "GetSKAdNetworkConversionValueSchema"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .GetSKAdNetworkConversionValueSchemaRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "GetSKAdNetworkConversionValueSchema"))
                      .build();
        }
      }
    }
    return getGetSKAdNetworkConversionValueSchemaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateSKAdNetworkConversionValueSchemaRequest,
          com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema>
      getCreateSKAdNetworkConversionValueSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSKAdNetworkConversionValueSchema",
      requestType =
          com.google.analytics.admin.v1alpha.CreateSKAdNetworkConversionValueSchemaRequest.class,
      responseType = com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateSKAdNetworkConversionValueSchemaRequest,
          com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema>
      getCreateSKAdNetworkConversionValueSchemaMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.CreateSKAdNetworkConversionValueSchemaRequest,
            com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema>
        getCreateSKAdNetworkConversionValueSchemaMethod;
    if ((getCreateSKAdNetworkConversionValueSchemaMethod =
            AnalyticsAdminServiceGrpc.getCreateSKAdNetworkConversionValueSchemaMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateSKAdNetworkConversionValueSchemaMethod =
                AnalyticsAdminServiceGrpc.getCreateSKAdNetworkConversionValueSchemaMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getCreateSKAdNetworkConversionValueSchemaMethod =
              getCreateSKAdNetworkConversionValueSchemaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha
                              .CreateSKAdNetworkConversionValueSchemaRequest,
                          com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "CreateSKAdNetworkConversionValueSchema"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .CreateSKAdNetworkConversionValueSchemaRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "CreateSKAdNetworkConversionValueSchema"))
                      .build();
        }
      }
    }
    return getCreateSKAdNetworkConversionValueSchemaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteSKAdNetworkConversionValueSchemaRequest,
          com.google.protobuf.Empty>
      getDeleteSKAdNetworkConversionValueSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSKAdNetworkConversionValueSchema",
      requestType =
          com.google.analytics.admin.v1alpha.DeleteSKAdNetworkConversionValueSchemaRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteSKAdNetworkConversionValueSchemaRequest,
          com.google.protobuf.Empty>
      getDeleteSKAdNetworkConversionValueSchemaMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.DeleteSKAdNetworkConversionValueSchemaRequest,
            com.google.protobuf.Empty>
        getDeleteSKAdNetworkConversionValueSchemaMethod;
    if ((getDeleteSKAdNetworkConversionValueSchemaMethod =
            AnalyticsAdminServiceGrpc.getDeleteSKAdNetworkConversionValueSchemaMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeleteSKAdNetworkConversionValueSchemaMethod =
                AnalyticsAdminServiceGrpc.getDeleteSKAdNetworkConversionValueSchemaMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getDeleteSKAdNetworkConversionValueSchemaMethod =
              getDeleteSKAdNetworkConversionValueSchemaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha
                              .DeleteSKAdNetworkConversionValueSchemaRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "DeleteSKAdNetworkConversionValueSchema"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .DeleteSKAdNetworkConversionValueSchemaRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "DeleteSKAdNetworkConversionValueSchema"))
                      .build();
        }
      }
    }
    return getDeleteSKAdNetworkConversionValueSchemaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateSKAdNetworkConversionValueSchemaRequest,
          com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema>
      getUpdateSKAdNetworkConversionValueSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSKAdNetworkConversionValueSchema",
      requestType =
          com.google.analytics.admin.v1alpha.UpdateSKAdNetworkConversionValueSchemaRequest.class,
      responseType = com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateSKAdNetworkConversionValueSchemaRequest,
          com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema>
      getUpdateSKAdNetworkConversionValueSchemaMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.UpdateSKAdNetworkConversionValueSchemaRequest,
            com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema>
        getUpdateSKAdNetworkConversionValueSchemaMethod;
    if ((getUpdateSKAdNetworkConversionValueSchemaMethod =
            AnalyticsAdminServiceGrpc.getUpdateSKAdNetworkConversionValueSchemaMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateSKAdNetworkConversionValueSchemaMethod =
                AnalyticsAdminServiceGrpc.getUpdateSKAdNetworkConversionValueSchemaMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getUpdateSKAdNetworkConversionValueSchemaMethod =
              getUpdateSKAdNetworkConversionValueSchemaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha
                              .UpdateSKAdNetworkConversionValueSchemaRequest,
                          com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "UpdateSKAdNetworkConversionValueSchema"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .UpdateSKAdNetworkConversionValueSchemaRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "UpdateSKAdNetworkConversionValueSchema"))
                      .build();
        }
      }
    }
    return getUpdateSKAdNetworkConversionValueSchemaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListSKAdNetworkConversionValueSchemasRequest,
          com.google.analytics.admin.v1alpha.ListSKAdNetworkConversionValueSchemasResponse>
      getListSKAdNetworkConversionValueSchemasMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSKAdNetworkConversionValueSchemas",
      requestType =
          com.google.analytics.admin.v1alpha.ListSKAdNetworkConversionValueSchemasRequest.class,
      responseType =
          com.google.analytics.admin.v1alpha.ListSKAdNetworkConversionValueSchemasResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListSKAdNetworkConversionValueSchemasRequest,
          com.google.analytics.admin.v1alpha.ListSKAdNetworkConversionValueSchemasResponse>
      getListSKAdNetworkConversionValueSchemasMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListSKAdNetworkConversionValueSchemasRequest,
            com.google.analytics.admin.v1alpha.ListSKAdNetworkConversionValueSchemasResponse>
        getListSKAdNetworkConversionValueSchemasMethod;
    if ((getListSKAdNetworkConversionValueSchemasMethod =
            AnalyticsAdminServiceGrpc.getListSKAdNetworkConversionValueSchemasMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListSKAdNetworkConversionValueSchemasMethod =
                AnalyticsAdminServiceGrpc.getListSKAdNetworkConversionValueSchemasMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getListSKAdNetworkConversionValueSchemasMethod =
              getListSKAdNetworkConversionValueSchemasMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha
                              .ListSKAdNetworkConversionValueSchemasRequest,
                          com.google.analytics.admin.v1alpha
                              .ListSKAdNetworkConversionValueSchemasResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "ListSKAdNetworkConversionValueSchemas"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .ListSKAdNetworkConversionValueSchemasRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .ListSKAdNetworkConversionValueSchemasResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "ListSKAdNetworkConversionValueSchemas"))
                      .build();
        }
      }
    }
    return getListSKAdNetworkConversionValueSchemasMethod;
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
          com.google.analytics.admin.v1alpha.UpdateConversionEventRequest,
          com.google.analytics.admin.v1alpha.ConversionEvent>
      getUpdateConversionEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateConversionEvent",
      requestType = com.google.analytics.admin.v1alpha.UpdateConversionEventRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ConversionEvent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateConversionEventRequest,
          com.google.analytics.admin.v1alpha.ConversionEvent>
      getUpdateConversionEventMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.UpdateConversionEventRequest,
            com.google.analytics.admin.v1alpha.ConversionEvent>
        getUpdateConversionEventMethod;
    if ((getUpdateConversionEventMethod = AnalyticsAdminServiceGrpc.getUpdateConversionEventMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateConversionEventMethod =
                AnalyticsAdminServiceGrpc.getUpdateConversionEventMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getUpdateConversionEventMethod =
              getUpdateConversionEventMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.UpdateConversionEventRequest,
                          com.google.analytics.admin.v1alpha.ConversionEvent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateConversionEvent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UpdateConversionEventRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ConversionEvent
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "UpdateConversionEvent"))
                      .build();
        }
      }
    }
    return getUpdateConversionEventMethod;
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
          com.google.analytics.admin.v1alpha.GetSearchAds360LinkRequest,
          com.google.analytics.admin.v1alpha.SearchAds360Link>
      getGetSearchAds360LinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSearchAds360Link",
      requestType = com.google.analytics.admin.v1alpha.GetSearchAds360LinkRequest.class,
      responseType = com.google.analytics.admin.v1alpha.SearchAds360Link.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetSearchAds360LinkRequest,
          com.google.analytics.admin.v1alpha.SearchAds360Link>
      getGetSearchAds360LinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetSearchAds360LinkRequest,
            com.google.analytics.admin.v1alpha.SearchAds360Link>
        getGetSearchAds360LinkMethod;
    if ((getGetSearchAds360LinkMethod = AnalyticsAdminServiceGrpc.getGetSearchAds360LinkMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetSearchAds360LinkMethod = AnalyticsAdminServiceGrpc.getGetSearchAds360LinkMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getGetSearchAds360LinkMethod =
              getGetSearchAds360LinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetSearchAds360LinkRequest,
                          com.google.analytics.admin.v1alpha.SearchAds360Link>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetSearchAds360Link"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GetSearchAds360LinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.SearchAds360Link
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("GetSearchAds360Link"))
                      .build();
        }
      }
    }
    return getGetSearchAds360LinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListSearchAds360LinksRequest,
          com.google.analytics.admin.v1alpha.ListSearchAds360LinksResponse>
      getListSearchAds360LinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSearchAds360Links",
      requestType = com.google.analytics.admin.v1alpha.ListSearchAds360LinksRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ListSearchAds360LinksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListSearchAds360LinksRequest,
          com.google.analytics.admin.v1alpha.ListSearchAds360LinksResponse>
      getListSearchAds360LinksMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListSearchAds360LinksRequest,
            com.google.analytics.admin.v1alpha.ListSearchAds360LinksResponse>
        getListSearchAds360LinksMethod;
    if ((getListSearchAds360LinksMethod = AnalyticsAdminServiceGrpc.getListSearchAds360LinksMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListSearchAds360LinksMethod =
                AnalyticsAdminServiceGrpc.getListSearchAds360LinksMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getListSearchAds360LinksMethod =
              getListSearchAds360LinksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ListSearchAds360LinksRequest,
                          com.google.analytics.admin.v1alpha.ListSearchAds360LinksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListSearchAds360Links"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListSearchAds360LinksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListSearchAds360LinksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "ListSearchAds360Links"))
                      .build();
        }
      }
    }
    return getListSearchAds360LinksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateSearchAds360LinkRequest,
          com.google.analytics.admin.v1alpha.SearchAds360Link>
      getCreateSearchAds360LinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSearchAds360Link",
      requestType = com.google.analytics.admin.v1alpha.CreateSearchAds360LinkRequest.class,
      responseType = com.google.analytics.admin.v1alpha.SearchAds360Link.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateSearchAds360LinkRequest,
          com.google.analytics.admin.v1alpha.SearchAds360Link>
      getCreateSearchAds360LinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.CreateSearchAds360LinkRequest,
            com.google.analytics.admin.v1alpha.SearchAds360Link>
        getCreateSearchAds360LinkMethod;
    if ((getCreateSearchAds360LinkMethod =
            AnalyticsAdminServiceGrpc.getCreateSearchAds360LinkMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateSearchAds360LinkMethod =
                AnalyticsAdminServiceGrpc.getCreateSearchAds360LinkMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getCreateSearchAds360LinkMethod =
              getCreateSearchAds360LinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.CreateSearchAds360LinkRequest,
                          com.google.analytics.admin.v1alpha.SearchAds360Link>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateSearchAds360Link"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CreateSearchAds360LinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.SearchAds360Link
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "CreateSearchAds360Link"))
                      .build();
        }
      }
    }
    return getCreateSearchAds360LinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteSearchAds360LinkRequest,
          com.google.protobuf.Empty>
      getDeleteSearchAds360LinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSearchAds360Link",
      requestType = com.google.analytics.admin.v1alpha.DeleteSearchAds360LinkRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteSearchAds360LinkRequest,
          com.google.protobuf.Empty>
      getDeleteSearchAds360LinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.DeleteSearchAds360LinkRequest,
            com.google.protobuf.Empty>
        getDeleteSearchAds360LinkMethod;
    if ((getDeleteSearchAds360LinkMethod =
            AnalyticsAdminServiceGrpc.getDeleteSearchAds360LinkMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeleteSearchAds360LinkMethod =
                AnalyticsAdminServiceGrpc.getDeleteSearchAds360LinkMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getDeleteSearchAds360LinkMethod =
              getDeleteSearchAds360LinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.DeleteSearchAds360LinkRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteSearchAds360Link"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DeleteSearchAds360LinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "DeleteSearchAds360Link"))
                      .build();
        }
      }
    }
    return getDeleteSearchAds360LinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateSearchAds360LinkRequest,
          com.google.analytics.admin.v1alpha.SearchAds360Link>
      getUpdateSearchAds360LinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSearchAds360Link",
      requestType = com.google.analytics.admin.v1alpha.UpdateSearchAds360LinkRequest.class,
      responseType = com.google.analytics.admin.v1alpha.SearchAds360Link.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateSearchAds360LinkRequest,
          com.google.analytics.admin.v1alpha.SearchAds360Link>
      getUpdateSearchAds360LinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.UpdateSearchAds360LinkRequest,
            com.google.analytics.admin.v1alpha.SearchAds360Link>
        getUpdateSearchAds360LinkMethod;
    if ((getUpdateSearchAds360LinkMethod =
            AnalyticsAdminServiceGrpc.getUpdateSearchAds360LinkMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateSearchAds360LinkMethod =
                AnalyticsAdminServiceGrpc.getUpdateSearchAds360LinkMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getUpdateSearchAds360LinkMethod =
              getUpdateSearchAds360LinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.UpdateSearchAds360LinkRequest,
                          com.google.analytics.admin.v1alpha.SearchAds360Link>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateSearchAds360Link"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UpdateSearchAds360LinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.SearchAds360Link
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "UpdateSearchAds360Link"))
                      .build();
        }
      }
    }
    return getUpdateSearchAds360LinkMethod;
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateAccessBindingRequest,
          com.google.analytics.admin.v1alpha.AccessBinding>
      getCreateAccessBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAccessBinding",
      requestType = com.google.analytics.admin.v1alpha.CreateAccessBindingRequest.class,
      responseType = com.google.analytics.admin.v1alpha.AccessBinding.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateAccessBindingRequest,
          com.google.analytics.admin.v1alpha.AccessBinding>
      getCreateAccessBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.CreateAccessBindingRequest,
            com.google.analytics.admin.v1alpha.AccessBinding>
        getCreateAccessBindingMethod;
    if ((getCreateAccessBindingMethod = AnalyticsAdminServiceGrpc.getCreateAccessBindingMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateAccessBindingMethod = AnalyticsAdminServiceGrpc.getCreateAccessBindingMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getCreateAccessBindingMethod =
              getCreateAccessBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.CreateAccessBindingRequest,
                          com.google.analytics.admin.v1alpha.AccessBinding>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateAccessBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CreateAccessBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.AccessBinding
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("CreateAccessBinding"))
                      .build();
        }
      }
    }
    return getCreateAccessBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetAccessBindingRequest,
          com.google.analytics.admin.v1alpha.AccessBinding>
      getGetAccessBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccessBinding",
      requestType = com.google.analytics.admin.v1alpha.GetAccessBindingRequest.class,
      responseType = com.google.analytics.admin.v1alpha.AccessBinding.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetAccessBindingRequest,
          com.google.analytics.admin.v1alpha.AccessBinding>
      getGetAccessBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetAccessBindingRequest,
            com.google.analytics.admin.v1alpha.AccessBinding>
        getGetAccessBindingMethod;
    if ((getGetAccessBindingMethod = AnalyticsAdminServiceGrpc.getGetAccessBindingMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetAccessBindingMethod = AnalyticsAdminServiceGrpc.getGetAccessBindingMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getGetAccessBindingMethod =
              getGetAccessBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetAccessBindingRequest,
                          com.google.analytics.admin.v1alpha.AccessBinding>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAccessBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GetAccessBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.AccessBinding
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("GetAccessBinding"))
                      .build();
        }
      }
    }
    return getGetAccessBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateAccessBindingRequest,
          com.google.analytics.admin.v1alpha.AccessBinding>
      getUpdateAccessBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAccessBinding",
      requestType = com.google.analytics.admin.v1alpha.UpdateAccessBindingRequest.class,
      responseType = com.google.analytics.admin.v1alpha.AccessBinding.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateAccessBindingRequest,
          com.google.analytics.admin.v1alpha.AccessBinding>
      getUpdateAccessBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.UpdateAccessBindingRequest,
            com.google.analytics.admin.v1alpha.AccessBinding>
        getUpdateAccessBindingMethod;
    if ((getUpdateAccessBindingMethod = AnalyticsAdminServiceGrpc.getUpdateAccessBindingMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateAccessBindingMethod = AnalyticsAdminServiceGrpc.getUpdateAccessBindingMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getUpdateAccessBindingMethod =
              getUpdateAccessBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.UpdateAccessBindingRequest,
                          com.google.analytics.admin.v1alpha.AccessBinding>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateAccessBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UpdateAccessBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.AccessBinding
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("UpdateAccessBinding"))
                      .build();
        }
      }
    }
    return getUpdateAccessBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteAccessBindingRequest, com.google.protobuf.Empty>
      getDeleteAccessBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAccessBinding",
      requestType = com.google.analytics.admin.v1alpha.DeleteAccessBindingRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteAccessBindingRequest, com.google.protobuf.Empty>
      getDeleteAccessBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.DeleteAccessBindingRequest,
            com.google.protobuf.Empty>
        getDeleteAccessBindingMethod;
    if ((getDeleteAccessBindingMethod = AnalyticsAdminServiceGrpc.getDeleteAccessBindingMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeleteAccessBindingMethod = AnalyticsAdminServiceGrpc.getDeleteAccessBindingMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getDeleteAccessBindingMethod =
              getDeleteAccessBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.DeleteAccessBindingRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteAccessBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DeleteAccessBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("DeleteAccessBinding"))
                      .build();
        }
      }
    }
    return getDeleteAccessBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListAccessBindingsRequest,
          com.google.analytics.admin.v1alpha.ListAccessBindingsResponse>
      getListAccessBindingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAccessBindings",
      requestType = com.google.analytics.admin.v1alpha.ListAccessBindingsRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ListAccessBindingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListAccessBindingsRequest,
          com.google.analytics.admin.v1alpha.ListAccessBindingsResponse>
      getListAccessBindingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListAccessBindingsRequest,
            com.google.analytics.admin.v1alpha.ListAccessBindingsResponse>
        getListAccessBindingsMethod;
    if ((getListAccessBindingsMethod = AnalyticsAdminServiceGrpc.getListAccessBindingsMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListAccessBindingsMethod = AnalyticsAdminServiceGrpc.getListAccessBindingsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getListAccessBindingsMethod =
              getListAccessBindingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ListAccessBindingsRequest,
                          com.google.analytics.admin.v1alpha.ListAccessBindingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAccessBindings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListAccessBindingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListAccessBindingsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("ListAccessBindings"))
                      .build();
        }
      }
    }
    return getListAccessBindingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.BatchCreateAccessBindingsRequest,
          com.google.analytics.admin.v1alpha.BatchCreateAccessBindingsResponse>
      getBatchCreateAccessBindingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchCreateAccessBindings",
      requestType = com.google.analytics.admin.v1alpha.BatchCreateAccessBindingsRequest.class,
      responseType = com.google.analytics.admin.v1alpha.BatchCreateAccessBindingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.BatchCreateAccessBindingsRequest,
          com.google.analytics.admin.v1alpha.BatchCreateAccessBindingsResponse>
      getBatchCreateAccessBindingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.BatchCreateAccessBindingsRequest,
            com.google.analytics.admin.v1alpha.BatchCreateAccessBindingsResponse>
        getBatchCreateAccessBindingsMethod;
    if ((getBatchCreateAccessBindingsMethod =
            AnalyticsAdminServiceGrpc.getBatchCreateAccessBindingsMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getBatchCreateAccessBindingsMethod =
                AnalyticsAdminServiceGrpc.getBatchCreateAccessBindingsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getBatchCreateAccessBindingsMethod =
              getBatchCreateAccessBindingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.BatchCreateAccessBindingsRequest,
                          com.google.analytics.admin.v1alpha.BatchCreateAccessBindingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchCreateAccessBindings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.BatchCreateAccessBindingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.BatchCreateAccessBindingsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "BatchCreateAccessBindings"))
                      .build();
        }
      }
    }
    return getBatchCreateAccessBindingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.BatchGetAccessBindingsRequest,
          com.google.analytics.admin.v1alpha.BatchGetAccessBindingsResponse>
      getBatchGetAccessBindingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchGetAccessBindings",
      requestType = com.google.analytics.admin.v1alpha.BatchGetAccessBindingsRequest.class,
      responseType = com.google.analytics.admin.v1alpha.BatchGetAccessBindingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.BatchGetAccessBindingsRequest,
          com.google.analytics.admin.v1alpha.BatchGetAccessBindingsResponse>
      getBatchGetAccessBindingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.BatchGetAccessBindingsRequest,
            com.google.analytics.admin.v1alpha.BatchGetAccessBindingsResponse>
        getBatchGetAccessBindingsMethod;
    if ((getBatchGetAccessBindingsMethod =
            AnalyticsAdminServiceGrpc.getBatchGetAccessBindingsMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getBatchGetAccessBindingsMethod =
                AnalyticsAdminServiceGrpc.getBatchGetAccessBindingsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getBatchGetAccessBindingsMethod =
              getBatchGetAccessBindingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.BatchGetAccessBindingsRequest,
                          com.google.analytics.admin.v1alpha.BatchGetAccessBindingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchGetAccessBindings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.BatchGetAccessBindingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.BatchGetAccessBindingsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "BatchGetAccessBindings"))
                      .build();
        }
      }
    }
    return getBatchGetAccessBindingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.BatchUpdateAccessBindingsRequest,
          com.google.analytics.admin.v1alpha.BatchUpdateAccessBindingsResponse>
      getBatchUpdateAccessBindingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchUpdateAccessBindings",
      requestType = com.google.analytics.admin.v1alpha.BatchUpdateAccessBindingsRequest.class,
      responseType = com.google.analytics.admin.v1alpha.BatchUpdateAccessBindingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.BatchUpdateAccessBindingsRequest,
          com.google.analytics.admin.v1alpha.BatchUpdateAccessBindingsResponse>
      getBatchUpdateAccessBindingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.BatchUpdateAccessBindingsRequest,
            com.google.analytics.admin.v1alpha.BatchUpdateAccessBindingsResponse>
        getBatchUpdateAccessBindingsMethod;
    if ((getBatchUpdateAccessBindingsMethod =
            AnalyticsAdminServiceGrpc.getBatchUpdateAccessBindingsMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getBatchUpdateAccessBindingsMethod =
                AnalyticsAdminServiceGrpc.getBatchUpdateAccessBindingsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getBatchUpdateAccessBindingsMethod =
              getBatchUpdateAccessBindingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.BatchUpdateAccessBindingsRequest,
                          com.google.analytics.admin.v1alpha.BatchUpdateAccessBindingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchUpdateAccessBindings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.BatchUpdateAccessBindingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.BatchUpdateAccessBindingsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "BatchUpdateAccessBindings"))
                      .build();
        }
      }
    }
    return getBatchUpdateAccessBindingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.BatchDeleteAccessBindingsRequest,
          com.google.protobuf.Empty>
      getBatchDeleteAccessBindingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchDeleteAccessBindings",
      requestType = com.google.analytics.admin.v1alpha.BatchDeleteAccessBindingsRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.BatchDeleteAccessBindingsRequest,
          com.google.protobuf.Empty>
      getBatchDeleteAccessBindingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.BatchDeleteAccessBindingsRequest,
            com.google.protobuf.Empty>
        getBatchDeleteAccessBindingsMethod;
    if ((getBatchDeleteAccessBindingsMethod =
            AnalyticsAdminServiceGrpc.getBatchDeleteAccessBindingsMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getBatchDeleteAccessBindingsMethod =
                AnalyticsAdminServiceGrpc.getBatchDeleteAccessBindingsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getBatchDeleteAccessBindingsMethod =
              getBatchDeleteAccessBindingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.BatchDeleteAccessBindingsRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchDeleteAccessBindings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.BatchDeleteAccessBindingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "BatchDeleteAccessBindings"))
                      .build();
        }
      }
    }
    return getBatchDeleteAccessBindingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetExpandedDataSetRequest,
          com.google.analytics.admin.v1alpha.ExpandedDataSet>
      getGetExpandedDataSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetExpandedDataSet",
      requestType = com.google.analytics.admin.v1alpha.GetExpandedDataSetRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ExpandedDataSet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetExpandedDataSetRequest,
          com.google.analytics.admin.v1alpha.ExpandedDataSet>
      getGetExpandedDataSetMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetExpandedDataSetRequest,
            com.google.analytics.admin.v1alpha.ExpandedDataSet>
        getGetExpandedDataSetMethod;
    if ((getGetExpandedDataSetMethod = AnalyticsAdminServiceGrpc.getGetExpandedDataSetMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetExpandedDataSetMethod = AnalyticsAdminServiceGrpc.getGetExpandedDataSetMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getGetExpandedDataSetMethod =
              getGetExpandedDataSetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetExpandedDataSetRequest,
                          com.google.analytics.admin.v1alpha.ExpandedDataSet>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetExpandedDataSet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GetExpandedDataSetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ExpandedDataSet
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("GetExpandedDataSet"))
                      .build();
        }
      }
    }
    return getGetExpandedDataSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListExpandedDataSetsRequest,
          com.google.analytics.admin.v1alpha.ListExpandedDataSetsResponse>
      getListExpandedDataSetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListExpandedDataSets",
      requestType = com.google.analytics.admin.v1alpha.ListExpandedDataSetsRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ListExpandedDataSetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListExpandedDataSetsRequest,
          com.google.analytics.admin.v1alpha.ListExpandedDataSetsResponse>
      getListExpandedDataSetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListExpandedDataSetsRequest,
            com.google.analytics.admin.v1alpha.ListExpandedDataSetsResponse>
        getListExpandedDataSetsMethod;
    if ((getListExpandedDataSetsMethod = AnalyticsAdminServiceGrpc.getListExpandedDataSetsMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListExpandedDataSetsMethod =
                AnalyticsAdminServiceGrpc.getListExpandedDataSetsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getListExpandedDataSetsMethod =
              getListExpandedDataSetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ListExpandedDataSetsRequest,
                          com.google.analytics.admin.v1alpha.ListExpandedDataSetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListExpandedDataSets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListExpandedDataSetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListExpandedDataSetsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("ListExpandedDataSets"))
                      .build();
        }
      }
    }
    return getListExpandedDataSetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateExpandedDataSetRequest,
          com.google.analytics.admin.v1alpha.ExpandedDataSet>
      getCreateExpandedDataSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateExpandedDataSet",
      requestType = com.google.analytics.admin.v1alpha.CreateExpandedDataSetRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ExpandedDataSet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateExpandedDataSetRequest,
          com.google.analytics.admin.v1alpha.ExpandedDataSet>
      getCreateExpandedDataSetMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.CreateExpandedDataSetRequest,
            com.google.analytics.admin.v1alpha.ExpandedDataSet>
        getCreateExpandedDataSetMethod;
    if ((getCreateExpandedDataSetMethod = AnalyticsAdminServiceGrpc.getCreateExpandedDataSetMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateExpandedDataSetMethod =
                AnalyticsAdminServiceGrpc.getCreateExpandedDataSetMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getCreateExpandedDataSetMethod =
              getCreateExpandedDataSetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.CreateExpandedDataSetRequest,
                          com.google.analytics.admin.v1alpha.ExpandedDataSet>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateExpandedDataSet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CreateExpandedDataSetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ExpandedDataSet
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "CreateExpandedDataSet"))
                      .build();
        }
      }
    }
    return getCreateExpandedDataSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateExpandedDataSetRequest,
          com.google.analytics.admin.v1alpha.ExpandedDataSet>
      getUpdateExpandedDataSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateExpandedDataSet",
      requestType = com.google.analytics.admin.v1alpha.UpdateExpandedDataSetRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ExpandedDataSet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateExpandedDataSetRequest,
          com.google.analytics.admin.v1alpha.ExpandedDataSet>
      getUpdateExpandedDataSetMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.UpdateExpandedDataSetRequest,
            com.google.analytics.admin.v1alpha.ExpandedDataSet>
        getUpdateExpandedDataSetMethod;
    if ((getUpdateExpandedDataSetMethod = AnalyticsAdminServiceGrpc.getUpdateExpandedDataSetMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateExpandedDataSetMethod =
                AnalyticsAdminServiceGrpc.getUpdateExpandedDataSetMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getUpdateExpandedDataSetMethod =
              getUpdateExpandedDataSetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.UpdateExpandedDataSetRequest,
                          com.google.analytics.admin.v1alpha.ExpandedDataSet>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateExpandedDataSet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UpdateExpandedDataSetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ExpandedDataSet
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "UpdateExpandedDataSet"))
                      .build();
        }
      }
    }
    return getUpdateExpandedDataSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteExpandedDataSetRequest,
          com.google.protobuf.Empty>
      getDeleteExpandedDataSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteExpandedDataSet",
      requestType = com.google.analytics.admin.v1alpha.DeleteExpandedDataSetRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteExpandedDataSetRequest,
          com.google.protobuf.Empty>
      getDeleteExpandedDataSetMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.DeleteExpandedDataSetRequest,
            com.google.protobuf.Empty>
        getDeleteExpandedDataSetMethod;
    if ((getDeleteExpandedDataSetMethod = AnalyticsAdminServiceGrpc.getDeleteExpandedDataSetMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeleteExpandedDataSetMethod =
                AnalyticsAdminServiceGrpc.getDeleteExpandedDataSetMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getDeleteExpandedDataSetMethod =
              getDeleteExpandedDataSetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.DeleteExpandedDataSetRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteExpandedDataSet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DeleteExpandedDataSetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "DeleteExpandedDataSet"))
                      .build();
        }
      }
    }
    return getDeleteExpandedDataSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetChannelGroupRequest,
          com.google.analytics.admin.v1alpha.ChannelGroup>
      getGetChannelGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetChannelGroup",
      requestType = com.google.analytics.admin.v1alpha.GetChannelGroupRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ChannelGroup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetChannelGroupRequest,
          com.google.analytics.admin.v1alpha.ChannelGroup>
      getGetChannelGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetChannelGroupRequest,
            com.google.analytics.admin.v1alpha.ChannelGroup>
        getGetChannelGroupMethod;
    if ((getGetChannelGroupMethod = AnalyticsAdminServiceGrpc.getGetChannelGroupMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetChannelGroupMethod = AnalyticsAdminServiceGrpc.getGetChannelGroupMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getGetChannelGroupMethod =
              getGetChannelGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetChannelGroupRequest,
                          com.google.analytics.admin.v1alpha.ChannelGroup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetChannelGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GetChannelGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ChannelGroup.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("GetChannelGroup"))
                      .build();
        }
      }
    }
    return getGetChannelGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListChannelGroupsRequest,
          com.google.analytics.admin.v1alpha.ListChannelGroupsResponse>
      getListChannelGroupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListChannelGroups",
      requestType = com.google.analytics.admin.v1alpha.ListChannelGroupsRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ListChannelGroupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListChannelGroupsRequest,
          com.google.analytics.admin.v1alpha.ListChannelGroupsResponse>
      getListChannelGroupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListChannelGroupsRequest,
            com.google.analytics.admin.v1alpha.ListChannelGroupsResponse>
        getListChannelGroupsMethod;
    if ((getListChannelGroupsMethod = AnalyticsAdminServiceGrpc.getListChannelGroupsMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListChannelGroupsMethod = AnalyticsAdminServiceGrpc.getListChannelGroupsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getListChannelGroupsMethod =
              getListChannelGroupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ListChannelGroupsRequest,
                          com.google.analytics.admin.v1alpha.ListChannelGroupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListChannelGroups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListChannelGroupsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListChannelGroupsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("ListChannelGroups"))
                      .build();
        }
      }
    }
    return getListChannelGroupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateChannelGroupRequest,
          com.google.analytics.admin.v1alpha.ChannelGroup>
      getCreateChannelGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateChannelGroup",
      requestType = com.google.analytics.admin.v1alpha.CreateChannelGroupRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ChannelGroup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateChannelGroupRequest,
          com.google.analytics.admin.v1alpha.ChannelGroup>
      getCreateChannelGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.CreateChannelGroupRequest,
            com.google.analytics.admin.v1alpha.ChannelGroup>
        getCreateChannelGroupMethod;
    if ((getCreateChannelGroupMethod = AnalyticsAdminServiceGrpc.getCreateChannelGroupMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateChannelGroupMethod = AnalyticsAdminServiceGrpc.getCreateChannelGroupMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getCreateChannelGroupMethod =
              getCreateChannelGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.CreateChannelGroupRequest,
                          com.google.analytics.admin.v1alpha.ChannelGroup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateChannelGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CreateChannelGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ChannelGroup.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("CreateChannelGroup"))
                      .build();
        }
      }
    }
    return getCreateChannelGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateChannelGroupRequest,
          com.google.analytics.admin.v1alpha.ChannelGroup>
      getUpdateChannelGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateChannelGroup",
      requestType = com.google.analytics.admin.v1alpha.UpdateChannelGroupRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ChannelGroup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateChannelGroupRequest,
          com.google.analytics.admin.v1alpha.ChannelGroup>
      getUpdateChannelGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.UpdateChannelGroupRequest,
            com.google.analytics.admin.v1alpha.ChannelGroup>
        getUpdateChannelGroupMethod;
    if ((getUpdateChannelGroupMethod = AnalyticsAdminServiceGrpc.getUpdateChannelGroupMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateChannelGroupMethod = AnalyticsAdminServiceGrpc.getUpdateChannelGroupMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getUpdateChannelGroupMethod =
              getUpdateChannelGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.UpdateChannelGroupRequest,
                          com.google.analytics.admin.v1alpha.ChannelGroup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateChannelGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UpdateChannelGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ChannelGroup.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("UpdateChannelGroup"))
                      .build();
        }
      }
    }
    return getUpdateChannelGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteChannelGroupRequest, com.google.protobuf.Empty>
      getDeleteChannelGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteChannelGroup",
      requestType = com.google.analytics.admin.v1alpha.DeleteChannelGroupRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteChannelGroupRequest, com.google.protobuf.Empty>
      getDeleteChannelGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.DeleteChannelGroupRequest, com.google.protobuf.Empty>
        getDeleteChannelGroupMethod;
    if ((getDeleteChannelGroupMethod = AnalyticsAdminServiceGrpc.getDeleteChannelGroupMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeleteChannelGroupMethod = AnalyticsAdminServiceGrpc.getDeleteChannelGroupMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getDeleteChannelGroupMethod =
              getDeleteChannelGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.DeleteChannelGroupRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteChannelGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DeleteChannelGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("DeleteChannelGroup"))
                      .build();
        }
      }
    }
    return getDeleteChannelGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.SetAutomatedGa4ConfigurationOptOutRequest,
          com.google.analytics.admin.v1alpha.SetAutomatedGa4ConfigurationOptOutResponse>
      getSetAutomatedGa4ConfigurationOptOutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetAutomatedGa4ConfigurationOptOut",
      requestType =
          com.google.analytics.admin.v1alpha.SetAutomatedGa4ConfigurationOptOutRequest.class,
      responseType =
          com.google.analytics.admin.v1alpha.SetAutomatedGa4ConfigurationOptOutResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.SetAutomatedGa4ConfigurationOptOutRequest,
          com.google.analytics.admin.v1alpha.SetAutomatedGa4ConfigurationOptOutResponse>
      getSetAutomatedGa4ConfigurationOptOutMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.SetAutomatedGa4ConfigurationOptOutRequest,
            com.google.analytics.admin.v1alpha.SetAutomatedGa4ConfigurationOptOutResponse>
        getSetAutomatedGa4ConfigurationOptOutMethod;
    if ((getSetAutomatedGa4ConfigurationOptOutMethod =
            AnalyticsAdminServiceGrpc.getSetAutomatedGa4ConfigurationOptOutMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getSetAutomatedGa4ConfigurationOptOutMethod =
                AnalyticsAdminServiceGrpc.getSetAutomatedGa4ConfigurationOptOutMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getSetAutomatedGa4ConfigurationOptOutMethod =
              getSetAutomatedGa4ConfigurationOptOutMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha
                              .SetAutomatedGa4ConfigurationOptOutRequest,
                          com.google.analytics.admin.v1alpha
                              .SetAutomatedGa4ConfigurationOptOutResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "SetAutomatedGa4ConfigurationOptOut"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .SetAutomatedGa4ConfigurationOptOutRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .SetAutomatedGa4ConfigurationOptOutResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "SetAutomatedGa4ConfigurationOptOut"))
                      .build();
        }
      }
    }
    return getSetAutomatedGa4ConfigurationOptOutMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.FetchAutomatedGa4ConfigurationOptOutRequest,
          com.google.analytics.admin.v1alpha.FetchAutomatedGa4ConfigurationOptOutResponse>
      getFetchAutomatedGa4ConfigurationOptOutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchAutomatedGa4ConfigurationOptOut",
      requestType =
          com.google.analytics.admin.v1alpha.FetchAutomatedGa4ConfigurationOptOutRequest.class,
      responseType =
          com.google.analytics.admin.v1alpha.FetchAutomatedGa4ConfigurationOptOutResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.FetchAutomatedGa4ConfigurationOptOutRequest,
          com.google.analytics.admin.v1alpha.FetchAutomatedGa4ConfigurationOptOutResponse>
      getFetchAutomatedGa4ConfigurationOptOutMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.FetchAutomatedGa4ConfigurationOptOutRequest,
            com.google.analytics.admin.v1alpha.FetchAutomatedGa4ConfigurationOptOutResponse>
        getFetchAutomatedGa4ConfigurationOptOutMethod;
    if ((getFetchAutomatedGa4ConfigurationOptOutMethod =
            AnalyticsAdminServiceGrpc.getFetchAutomatedGa4ConfigurationOptOutMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getFetchAutomatedGa4ConfigurationOptOutMethod =
                AnalyticsAdminServiceGrpc.getFetchAutomatedGa4ConfigurationOptOutMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getFetchAutomatedGa4ConfigurationOptOutMethod =
              getFetchAutomatedGa4ConfigurationOptOutMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha
                              .FetchAutomatedGa4ConfigurationOptOutRequest,
                          com.google.analytics.admin.v1alpha
                              .FetchAutomatedGa4ConfigurationOptOutResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "FetchAutomatedGa4ConfigurationOptOut"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .FetchAutomatedGa4ConfigurationOptOutRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .FetchAutomatedGa4ConfigurationOptOutResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "FetchAutomatedGa4ConfigurationOptOut"))
                      .build();
        }
      }
    }
    return getFetchAutomatedGa4ConfigurationOptOutMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetBigQueryLinkRequest,
          com.google.analytics.admin.v1alpha.BigQueryLink>
      getGetBigQueryLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBigQueryLink",
      requestType = com.google.analytics.admin.v1alpha.GetBigQueryLinkRequest.class,
      responseType = com.google.analytics.admin.v1alpha.BigQueryLink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetBigQueryLinkRequest,
          com.google.analytics.admin.v1alpha.BigQueryLink>
      getGetBigQueryLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetBigQueryLinkRequest,
            com.google.analytics.admin.v1alpha.BigQueryLink>
        getGetBigQueryLinkMethod;
    if ((getGetBigQueryLinkMethod = AnalyticsAdminServiceGrpc.getGetBigQueryLinkMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetBigQueryLinkMethod = AnalyticsAdminServiceGrpc.getGetBigQueryLinkMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getGetBigQueryLinkMethod =
              getGetBigQueryLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetBigQueryLinkRequest,
                          com.google.analytics.admin.v1alpha.BigQueryLink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBigQueryLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GetBigQueryLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.BigQueryLink.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("GetBigQueryLink"))
                      .build();
        }
      }
    }
    return getGetBigQueryLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListBigQueryLinksRequest,
          com.google.analytics.admin.v1alpha.ListBigQueryLinksResponse>
      getListBigQueryLinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBigQueryLinks",
      requestType = com.google.analytics.admin.v1alpha.ListBigQueryLinksRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ListBigQueryLinksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListBigQueryLinksRequest,
          com.google.analytics.admin.v1alpha.ListBigQueryLinksResponse>
      getListBigQueryLinksMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListBigQueryLinksRequest,
            com.google.analytics.admin.v1alpha.ListBigQueryLinksResponse>
        getListBigQueryLinksMethod;
    if ((getListBigQueryLinksMethod = AnalyticsAdminServiceGrpc.getListBigQueryLinksMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListBigQueryLinksMethod = AnalyticsAdminServiceGrpc.getListBigQueryLinksMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getListBigQueryLinksMethod =
              getListBigQueryLinksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ListBigQueryLinksRequest,
                          com.google.analytics.admin.v1alpha.ListBigQueryLinksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBigQueryLinks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListBigQueryLinksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListBigQueryLinksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("ListBigQueryLinks"))
                      .build();
        }
      }
    }
    return getListBigQueryLinksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetEnhancedMeasurementSettingsRequest,
          com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>
      getGetEnhancedMeasurementSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEnhancedMeasurementSettings",
      requestType = com.google.analytics.admin.v1alpha.GetEnhancedMeasurementSettingsRequest.class,
      responseType = com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetEnhancedMeasurementSettingsRequest,
          com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>
      getGetEnhancedMeasurementSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetEnhancedMeasurementSettingsRequest,
            com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>
        getGetEnhancedMeasurementSettingsMethod;
    if ((getGetEnhancedMeasurementSettingsMethod =
            AnalyticsAdminServiceGrpc.getGetEnhancedMeasurementSettingsMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetEnhancedMeasurementSettingsMethod =
                AnalyticsAdminServiceGrpc.getGetEnhancedMeasurementSettingsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getGetEnhancedMeasurementSettingsMethod =
              getGetEnhancedMeasurementSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetEnhancedMeasurementSettingsRequest,
                          com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetEnhancedMeasurementSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .GetEnhancedMeasurementSettingsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "GetEnhancedMeasurementSettings"))
                      .build();
        }
      }
    }
    return getGetEnhancedMeasurementSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateEnhancedMeasurementSettingsRequest,
          com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>
      getUpdateEnhancedMeasurementSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEnhancedMeasurementSettings",
      requestType =
          com.google.analytics.admin.v1alpha.UpdateEnhancedMeasurementSettingsRequest.class,
      responseType = com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateEnhancedMeasurementSettingsRequest,
          com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>
      getUpdateEnhancedMeasurementSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.UpdateEnhancedMeasurementSettingsRequest,
            com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>
        getUpdateEnhancedMeasurementSettingsMethod;
    if ((getUpdateEnhancedMeasurementSettingsMethod =
            AnalyticsAdminServiceGrpc.getUpdateEnhancedMeasurementSettingsMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateEnhancedMeasurementSettingsMethod =
                AnalyticsAdminServiceGrpc.getUpdateEnhancedMeasurementSettingsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getUpdateEnhancedMeasurementSettingsMethod =
              getUpdateEnhancedMeasurementSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.UpdateEnhancedMeasurementSettingsRequest,
                          com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateEnhancedMeasurementSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .UpdateEnhancedMeasurementSettingsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "UpdateEnhancedMeasurementSettings"))
                      .build();
        }
      }
    }
    return getUpdateEnhancedMeasurementSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateConnectedSiteTagRequest,
          com.google.analytics.admin.v1alpha.CreateConnectedSiteTagResponse>
      getCreateConnectedSiteTagMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateConnectedSiteTag",
      requestType = com.google.analytics.admin.v1alpha.CreateConnectedSiteTagRequest.class,
      responseType = com.google.analytics.admin.v1alpha.CreateConnectedSiteTagResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateConnectedSiteTagRequest,
          com.google.analytics.admin.v1alpha.CreateConnectedSiteTagResponse>
      getCreateConnectedSiteTagMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.CreateConnectedSiteTagRequest,
            com.google.analytics.admin.v1alpha.CreateConnectedSiteTagResponse>
        getCreateConnectedSiteTagMethod;
    if ((getCreateConnectedSiteTagMethod =
            AnalyticsAdminServiceGrpc.getCreateConnectedSiteTagMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateConnectedSiteTagMethod =
                AnalyticsAdminServiceGrpc.getCreateConnectedSiteTagMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getCreateConnectedSiteTagMethod =
              getCreateConnectedSiteTagMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.CreateConnectedSiteTagRequest,
                          com.google.analytics.admin.v1alpha.CreateConnectedSiteTagResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateConnectedSiteTag"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CreateConnectedSiteTagRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CreateConnectedSiteTagResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "CreateConnectedSiteTag"))
                      .build();
        }
      }
    }
    return getCreateConnectedSiteTagMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteConnectedSiteTagRequest,
          com.google.protobuf.Empty>
      getDeleteConnectedSiteTagMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteConnectedSiteTag",
      requestType = com.google.analytics.admin.v1alpha.DeleteConnectedSiteTagRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteConnectedSiteTagRequest,
          com.google.protobuf.Empty>
      getDeleteConnectedSiteTagMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.DeleteConnectedSiteTagRequest,
            com.google.protobuf.Empty>
        getDeleteConnectedSiteTagMethod;
    if ((getDeleteConnectedSiteTagMethod =
            AnalyticsAdminServiceGrpc.getDeleteConnectedSiteTagMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeleteConnectedSiteTagMethod =
                AnalyticsAdminServiceGrpc.getDeleteConnectedSiteTagMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getDeleteConnectedSiteTagMethod =
              getDeleteConnectedSiteTagMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.DeleteConnectedSiteTagRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteConnectedSiteTag"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DeleteConnectedSiteTagRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "DeleteConnectedSiteTag"))
                      .build();
        }
      }
    }
    return getDeleteConnectedSiteTagMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListConnectedSiteTagsRequest,
          com.google.analytics.admin.v1alpha.ListConnectedSiteTagsResponse>
      getListConnectedSiteTagsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListConnectedSiteTags",
      requestType = com.google.analytics.admin.v1alpha.ListConnectedSiteTagsRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ListConnectedSiteTagsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListConnectedSiteTagsRequest,
          com.google.analytics.admin.v1alpha.ListConnectedSiteTagsResponse>
      getListConnectedSiteTagsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListConnectedSiteTagsRequest,
            com.google.analytics.admin.v1alpha.ListConnectedSiteTagsResponse>
        getListConnectedSiteTagsMethod;
    if ((getListConnectedSiteTagsMethod = AnalyticsAdminServiceGrpc.getListConnectedSiteTagsMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListConnectedSiteTagsMethod =
                AnalyticsAdminServiceGrpc.getListConnectedSiteTagsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getListConnectedSiteTagsMethod =
              getListConnectedSiteTagsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ListConnectedSiteTagsRequest,
                          com.google.analytics.admin.v1alpha.ListConnectedSiteTagsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListConnectedSiteTags"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListConnectedSiteTagsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListConnectedSiteTagsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "ListConnectedSiteTags"))
                      .build();
        }
      }
    }
    return getListConnectedSiteTagsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.FetchConnectedGa4PropertyRequest,
          com.google.analytics.admin.v1alpha.FetchConnectedGa4PropertyResponse>
      getFetchConnectedGa4PropertyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchConnectedGa4Property",
      requestType = com.google.analytics.admin.v1alpha.FetchConnectedGa4PropertyRequest.class,
      responseType = com.google.analytics.admin.v1alpha.FetchConnectedGa4PropertyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.FetchConnectedGa4PropertyRequest,
          com.google.analytics.admin.v1alpha.FetchConnectedGa4PropertyResponse>
      getFetchConnectedGa4PropertyMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.FetchConnectedGa4PropertyRequest,
            com.google.analytics.admin.v1alpha.FetchConnectedGa4PropertyResponse>
        getFetchConnectedGa4PropertyMethod;
    if ((getFetchConnectedGa4PropertyMethod =
            AnalyticsAdminServiceGrpc.getFetchConnectedGa4PropertyMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getFetchConnectedGa4PropertyMethod =
                AnalyticsAdminServiceGrpc.getFetchConnectedGa4PropertyMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getFetchConnectedGa4PropertyMethod =
              getFetchConnectedGa4PropertyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.FetchConnectedGa4PropertyRequest,
                          com.google.analytics.admin.v1alpha.FetchConnectedGa4PropertyResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "FetchConnectedGa4Property"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.FetchConnectedGa4PropertyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.FetchConnectedGa4PropertyResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "FetchConnectedGa4Property"))
                      .build();
        }
      }
    }
    return getFetchConnectedGa4PropertyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetAdSenseLinkRequest,
          com.google.analytics.admin.v1alpha.AdSenseLink>
      getGetAdSenseLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAdSenseLink",
      requestType = com.google.analytics.admin.v1alpha.GetAdSenseLinkRequest.class,
      responseType = com.google.analytics.admin.v1alpha.AdSenseLink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetAdSenseLinkRequest,
          com.google.analytics.admin.v1alpha.AdSenseLink>
      getGetAdSenseLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetAdSenseLinkRequest,
            com.google.analytics.admin.v1alpha.AdSenseLink>
        getGetAdSenseLinkMethod;
    if ((getGetAdSenseLinkMethod = AnalyticsAdminServiceGrpc.getGetAdSenseLinkMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetAdSenseLinkMethod = AnalyticsAdminServiceGrpc.getGetAdSenseLinkMethod) == null) {
          AnalyticsAdminServiceGrpc.getGetAdSenseLinkMethod =
              getGetAdSenseLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetAdSenseLinkRequest,
                          com.google.analytics.admin.v1alpha.AdSenseLink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAdSenseLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GetAdSenseLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.AdSenseLink.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("GetAdSenseLink"))
                      .build();
        }
      }
    }
    return getGetAdSenseLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateAdSenseLinkRequest,
          com.google.analytics.admin.v1alpha.AdSenseLink>
      getCreateAdSenseLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAdSenseLink",
      requestType = com.google.analytics.admin.v1alpha.CreateAdSenseLinkRequest.class,
      responseType = com.google.analytics.admin.v1alpha.AdSenseLink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateAdSenseLinkRequest,
          com.google.analytics.admin.v1alpha.AdSenseLink>
      getCreateAdSenseLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.CreateAdSenseLinkRequest,
            com.google.analytics.admin.v1alpha.AdSenseLink>
        getCreateAdSenseLinkMethod;
    if ((getCreateAdSenseLinkMethod = AnalyticsAdminServiceGrpc.getCreateAdSenseLinkMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateAdSenseLinkMethod = AnalyticsAdminServiceGrpc.getCreateAdSenseLinkMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getCreateAdSenseLinkMethod =
              getCreateAdSenseLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.CreateAdSenseLinkRequest,
                          com.google.analytics.admin.v1alpha.AdSenseLink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAdSenseLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CreateAdSenseLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.AdSenseLink.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("CreateAdSenseLink"))
                      .build();
        }
      }
    }
    return getCreateAdSenseLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteAdSenseLinkRequest, com.google.protobuf.Empty>
      getDeleteAdSenseLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAdSenseLink",
      requestType = com.google.analytics.admin.v1alpha.DeleteAdSenseLinkRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteAdSenseLinkRequest, com.google.protobuf.Empty>
      getDeleteAdSenseLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.DeleteAdSenseLinkRequest, com.google.protobuf.Empty>
        getDeleteAdSenseLinkMethod;
    if ((getDeleteAdSenseLinkMethod = AnalyticsAdminServiceGrpc.getDeleteAdSenseLinkMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeleteAdSenseLinkMethod = AnalyticsAdminServiceGrpc.getDeleteAdSenseLinkMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getDeleteAdSenseLinkMethod =
              getDeleteAdSenseLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.DeleteAdSenseLinkRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAdSenseLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DeleteAdSenseLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("DeleteAdSenseLink"))
                      .build();
        }
      }
    }
    return getDeleteAdSenseLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListAdSenseLinksRequest,
          com.google.analytics.admin.v1alpha.ListAdSenseLinksResponse>
      getListAdSenseLinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAdSenseLinks",
      requestType = com.google.analytics.admin.v1alpha.ListAdSenseLinksRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ListAdSenseLinksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListAdSenseLinksRequest,
          com.google.analytics.admin.v1alpha.ListAdSenseLinksResponse>
      getListAdSenseLinksMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListAdSenseLinksRequest,
            com.google.analytics.admin.v1alpha.ListAdSenseLinksResponse>
        getListAdSenseLinksMethod;
    if ((getListAdSenseLinksMethod = AnalyticsAdminServiceGrpc.getListAdSenseLinksMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListAdSenseLinksMethod = AnalyticsAdminServiceGrpc.getListAdSenseLinksMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getListAdSenseLinksMethod =
              getListAdSenseLinksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ListAdSenseLinksRequest,
                          com.google.analytics.admin.v1alpha.ListAdSenseLinksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAdSenseLinks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListAdSenseLinksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListAdSenseLinksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("ListAdSenseLinks"))
                      .build();
        }
      }
    }
    return getListAdSenseLinksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetEventCreateRuleRequest,
          com.google.analytics.admin.v1alpha.EventCreateRule>
      getGetEventCreateRuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEventCreateRule",
      requestType = com.google.analytics.admin.v1alpha.GetEventCreateRuleRequest.class,
      responseType = com.google.analytics.admin.v1alpha.EventCreateRule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetEventCreateRuleRequest,
          com.google.analytics.admin.v1alpha.EventCreateRule>
      getGetEventCreateRuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetEventCreateRuleRequest,
            com.google.analytics.admin.v1alpha.EventCreateRule>
        getGetEventCreateRuleMethod;
    if ((getGetEventCreateRuleMethod = AnalyticsAdminServiceGrpc.getGetEventCreateRuleMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetEventCreateRuleMethod = AnalyticsAdminServiceGrpc.getGetEventCreateRuleMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getGetEventCreateRuleMethod =
              getGetEventCreateRuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetEventCreateRuleRequest,
                          com.google.analytics.admin.v1alpha.EventCreateRule>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEventCreateRule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GetEventCreateRuleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.EventCreateRule
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("GetEventCreateRule"))
                      .build();
        }
      }
    }
    return getGetEventCreateRuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListEventCreateRulesRequest,
          com.google.analytics.admin.v1alpha.ListEventCreateRulesResponse>
      getListEventCreateRulesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEventCreateRules",
      requestType = com.google.analytics.admin.v1alpha.ListEventCreateRulesRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ListEventCreateRulesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListEventCreateRulesRequest,
          com.google.analytics.admin.v1alpha.ListEventCreateRulesResponse>
      getListEventCreateRulesMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListEventCreateRulesRequest,
            com.google.analytics.admin.v1alpha.ListEventCreateRulesResponse>
        getListEventCreateRulesMethod;
    if ((getListEventCreateRulesMethod = AnalyticsAdminServiceGrpc.getListEventCreateRulesMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListEventCreateRulesMethod =
                AnalyticsAdminServiceGrpc.getListEventCreateRulesMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getListEventCreateRulesMethod =
              getListEventCreateRulesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ListEventCreateRulesRequest,
                          com.google.analytics.admin.v1alpha.ListEventCreateRulesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListEventCreateRules"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListEventCreateRulesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListEventCreateRulesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("ListEventCreateRules"))
                      .build();
        }
      }
    }
    return getListEventCreateRulesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateEventCreateRuleRequest,
          com.google.analytics.admin.v1alpha.EventCreateRule>
      getCreateEventCreateRuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEventCreateRule",
      requestType = com.google.analytics.admin.v1alpha.CreateEventCreateRuleRequest.class,
      responseType = com.google.analytics.admin.v1alpha.EventCreateRule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateEventCreateRuleRequest,
          com.google.analytics.admin.v1alpha.EventCreateRule>
      getCreateEventCreateRuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.CreateEventCreateRuleRequest,
            com.google.analytics.admin.v1alpha.EventCreateRule>
        getCreateEventCreateRuleMethod;
    if ((getCreateEventCreateRuleMethod = AnalyticsAdminServiceGrpc.getCreateEventCreateRuleMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateEventCreateRuleMethod =
                AnalyticsAdminServiceGrpc.getCreateEventCreateRuleMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getCreateEventCreateRuleMethod =
              getCreateEventCreateRuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.CreateEventCreateRuleRequest,
                          com.google.analytics.admin.v1alpha.EventCreateRule>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateEventCreateRule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CreateEventCreateRuleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.EventCreateRule
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "CreateEventCreateRule"))
                      .build();
        }
      }
    }
    return getCreateEventCreateRuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateEventCreateRuleRequest,
          com.google.analytics.admin.v1alpha.EventCreateRule>
      getUpdateEventCreateRuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEventCreateRule",
      requestType = com.google.analytics.admin.v1alpha.UpdateEventCreateRuleRequest.class,
      responseType = com.google.analytics.admin.v1alpha.EventCreateRule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateEventCreateRuleRequest,
          com.google.analytics.admin.v1alpha.EventCreateRule>
      getUpdateEventCreateRuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.UpdateEventCreateRuleRequest,
            com.google.analytics.admin.v1alpha.EventCreateRule>
        getUpdateEventCreateRuleMethod;
    if ((getUpdateEventCreateRuleMethod = AnalyticsAdminServiceGrpc.getUpdateEventCreateRuleMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateEventCreateRuleMethod =
                AnalyticsAdminServiceGrpc.getUpdateEventCreateRuleMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getUpdateEventCreateRuleMethod =
              getUpdateEventCreateRuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.UpdateEventCreateRuleRequest,
                          com.google.analytics.admin.v1alpha.EventCreateRule>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateEventCreateRule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UpdateEventCreateRuleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.EventCreateRule
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "UpdateEventCreateRule"))
                      .build();
        }
      }
    }
    return getUpdateEventCreateRuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteEventCreateRuleRequest,
          com.google.protobuf.Empty>
      getDeleteEventCreateRuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEventCreateRule",
      requestType = com.google.analytics.admin.v1alpha.DeleteEventCreateRuleRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteEventCreateRuleRequest,
          com.google.protobuf.Empty>
      getDeleteEventCreateRuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.DeleteEventCreateRuleRequest,
            com.google.protobuf.Empty>
        getDeleteEventCreateRuleMethod;
    if ((getDeleteEventCreateRuleMethod = AnalyticsAdminServiceGrpc.getDeleteEventCreateRuleMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeleteEventCreateRuleMethod =
                AnalyticsAdminServiceGrpc.getDeleteEventCreateRuleMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getDeleteEventCreateRuleMethod =
              getDeleteEventCreateRuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.DeleteEventCreateRuleRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteEventCreateRule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DeleteEventCreateRuleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "DeleteEventCreateRule"))
                      .build();
        }
      }
    }
    return getDeleteEventCreateRuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateDataRedactionSettingsRequest,
          com.google.analytics.admin.v1alpha.DataRedactionSettings>
      getUpdateDataRedactionSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDataRedactionSettings",
      requestType = com.google.analytics.admin.v1alpha.UpdateDataRedactionSettingsRequest.class,
      responseType = com.google.analytics.admin.v1alpha.DataRedactionSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateDataRedactionSettingsRequest,
          com.google.analytics.admin.v1alpha.DataRedactionSettings>
      getUpdateDataRedactionSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.UpdateDataRedactionSettingsRequest,
            com.google.analytics.admin.v1alpha.DataRedactionSettings>
        getUpdateDataRedactionSettingsMethod;
    if ((getUpdateDataRedactionSettingsMethod =
            AnalyticsAdminServiceGrpc.getUpdateDataRedactionSettingsMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateDataRedactionSettingsMethod =
                AnalyticsAdminServiceGrpc.getUpdateDataRedactionSettingsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getUpdateDataRedactionSettingsMethod =
              getUpdateDataRedactionSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.UpdateDataRedactionSettingsRequest,
                          com.google.analytics.admin.v1alpha.DataRedactionSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateDataRedactionSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UpdateDataRedactionSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DataRedactionSettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "UpdateDataRedactionSettings"))
                      .build();
        }
      }
    }
    return getUpdateDataRedactionSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetDataRedactionSettingsRequest,
          com.google.analytics.admin.v1alpha.DataRedactionSettings>
      getGetDataRedactionSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataRedactionSettings",
      requestType = com.google.analytics.admin.v1alpha.GetDataRedactionSettingsRequest.class,
      responseType = com.google.analytics.admin.v1alpha.DataRedactionSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetDataRedactionSettingsRequest,
          com.google.analytics.admin.v1alpha.DataRedactionSettings>
      getGetDataRedactionSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetDataRedactionSettingsRequest,
            com.google.analytics.admin.v1alpha.DataRedactionSettings>
        getGetDataRedactionSettingsMethod;
    if ((getGetDataRedactionSettingsMethod =
            AnalyticsAdminServiceGrpc.getGetDataRedactionSettingsMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetDataRedactionSettingsMethod =
                AnalyticsAdminServiceGrpc.getGetDataRedactionSettingsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getGetDataRedactionSettingsMethod =
              getGetDataRedactionSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetDataRedactionSettingsRequest,
                          com.google.analytics.admin.v1alpha.DataRedactionSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetDataRedactionSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GetDataRedactionSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DataRedactionSettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "GetDataRedactionSettings"))
                      .build();
        }
      }
    }
    return getGetDataRedactionSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetCalculatedMetricRequest,
          com.google.analytics.admin.v1alpha.CalculatedMetric>
      getGetCalculatedMetricMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCalculatedMetric",
      requestType = com.google.analytics.admin.v1alpha.GetCalculatedMetricRequest.class,
      responseType = com.google.analytics.admin.v1alpha.CalculatedMetric.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetCalculatedMetricRequest,
          com.google.analytics.admin.v1alpha.CalculatedMetric>
      getGetCalculatedMetricMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetCalculatedMetricRequest,
            com.google.analytics.admin.v1alpha.CalculatedMetric>
        getGetCalculatedMetricMethod;
    if ((getGetCalculatedMetricMethod = AnalyticsAdminServiceGrpc.getGetCalculatedMetricMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetCalculatedMetricMethod = AnalyticsAdminServiceGrpc.getGetCalculatedMetricMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getGetCalculatedMetricMethod =
              getGetCalculatedMetricMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetCalculatedMetricRequest,
                          com.google.analytics.admin.v1alpha.CalculatedMetric>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetCalculatedMetric"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GetCalculatedMetricRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CalculatedMetric
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("GetCalculatedMetric"))
                      .build();
        }
      }
    }
    return getGetCalculatedMetricMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateCalculatedMetricRequest,
          com.google.analytics.admin.v1alpha.CalculatedMetric>
      getCreateCalculatedMetricMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCalculatedMetric",
      requestType = com.google.analytics.admin.v1alpha.CreateCalculatedMetricRequest.class,
      responseType = com.google.analytics.admin.v1alpha.CalculatedMetric.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateCalculatedMetricRequest,
          com.google.analytics.admin.v1alpha.CalculatedMetric>
      getCreateCalculatedMetricMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.CreateCalculatedMetricRequest,
            com.google.analytics.admin.v1alpha.CalculatedMetric>
        getCreateCalculatedMetricMethod;
    if ((getCreateCalculatedMetricMethod =
            AnalyticsAdminServiceGrpc.getCreateCalculatedMetricMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateCalculatedMetricMethod =
                AnalyticsAdminServiceGrpc.getCreateCalculatedMetricMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getCreateCalculatedMetricMethod =
              getCreateCalculatedMetricMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.CreateCalculatedMetricRequest,
                          com.google.analytics.admin.v1alpha.CalculatedMetric>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateCalculatedMetric"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CreateCalculatedMetricRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CalculatedMetric
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "CreateCalculatedMetric"))
                      .build();
        }
      }
    }
    return getCreateCalculatedMetricMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListCalculatedMetricsRequest,
          com.google.analytics.admin.v1alpha.ListCalculatedMetricsResponse>
      getListCalculatedMetricsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCalculatedMetrics",
      requestType = com.google.analytics.admin.v1alpha.ListCalculatedMetricsRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ListCalculatedMetricsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListCalculatedMetricsRequest,
          com.google.analytics.admin.v1alpha.ListCalculatedMetricsResponse>
      getListCalculatedMetricsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListCalculatedMetricsRequest,
            com.google.analytics.admin.v1alpha.ListCalculatedMetricsResponse>
        getListCalculatedMetricsMethod;
    if ((getListCalculatedMetricsMethod = AnalyticsAdminServiceGrpc.getListCalculatedMetricsMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListCalculatedMetricsMethod =
                AnalyticsAdminServiceGrpc.getListCalculatedMetricsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getListCalculatedMetricsMethod =
              getListCalculatedMetricsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ListCalculatedMetricsRequest,
                          com.google.analytics.admin.v1alpha.ListCalculatedMetricsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListCalculatedMetrics"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListCalculatedMetricsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListCalculatedMetricsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "ListCalculatedMetrics"))
                      .build();
        }
      }
    }
    return getListCalculatedMetricsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateCalculatedMetricRequest,
          com.google.analytics.admin.v1alpha.CalculatedMetric>
      getUpdateCalculatedMetricMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCalculatedMetric",
      requestType = com.google.analytics.admin.v1alpha.UpdateCalculatedMetricRequest.class,
      responseType = com.google.analytics.admin.v1alpha.CalculatedMetric.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateCalculatedMetricRequest,
          com.google.analytics.admin.v1alpha.CalculatedMetric>
      getUpdateCalculatedMetricMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.UpdateCalculatedMetricRequest,
            com.google.analytics.admin.v1alpha.CalculatedMetric>
        getUpdateCalculatedMetricMethod;
    if ((getUpdateCalculatedMetricMethod =
            AnalyticsAdminServiceGrpc.getUpdateCalculatedMetricMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateCalculatedMetricMethod =
                AnalyticsAdminServiceGrpc.getUpdateCalculatedMetricMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getUpdateCalculatedMetricMethod =
              getUpdateCalculatedMetricMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.UpdateCalculatedMetricRequest,
                          com.google.analytics.admin.v1alpha.CalculatedMetric>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateCalculatedMetric"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UpdateCalculatedMetricRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CalculatedMetric
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "UpdateCalculatedMetric"))
                      .build();
        }
      }
    }
    return getUpdateCalculatedMetricMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteCalculatedMetricRequest,
          com.google.protobuf.Empty>
      getDeleteCalculatedMetricMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCalculatedMetric",
      requestType = com.google.analytics.admin.v1alpha.DeleteCalculatedMetricRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteCalculatedMetricRequest,
          com.google.protobuf.Empty>
      getDeleteCalculatedMetricMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.DeleteCalculatedMetricRequest,
            com.google.protobuf.Empty>
        getDeleteCalculatedMetricMethod;
    if ((getDeleteCalculatedMetricMethod =
            AnalyticsAdminServiceGrpc.getDeleteCalculatedMetricMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeleteCalculatedMetricMethod =
                AnalyticsAdminServiceGrpc.getDeleteCalculatedMetricMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getDeleteCalculatedMetricMethod =
              getDeleteCalculatedMetricMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.DeleteCalculatedMetricRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteCalculatedMetric"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DeleteCalculatedMetricRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "DeleteCalculatedMetric"))
                      .build();
        }
      }
    }
    return getDeleteCalculatedMetricMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateRollupPropertyRequest,
          com.google.analytics.admin.v1alpha.CreateRollupPropertyResponse>
      getCreateRollupPropertyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRollupProperty",
      requestType = com.google.analytics.admin.v1alpha.CreateRollupPropertyRequest.class,
      responseType = com.google.analytics.admin.v1alpha.CreateRollupPropertyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateRollupPropertyRequest,
          com.google.analytics.admin.v1alpha.CreateRollupPropertyResponse>
      getCreateRollupPropertyMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.CreateRollupPropertyRequest,
            com.google.analytics.admin.v1alpha.CreateRollupPropertyResponse>
        getCreateRollupPropertyMethod;
    if ((getCreateRollupPropertyMethod = AnalyticsAdminServiceGrpc.getCreateRollupPropertyMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateRollupPropertyMethod =
                AnalyticsAdminServiceGrpc.getCreateRollupPropertyMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getCreateRollupPropertyMethod =
              getCreateRollupPropertyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.CreateRollupPropertyRequest,
                          com.google.analytics.admin.v1alpha.CreateRollupPropertyResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateRollupProperty"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CreateRollupPropertyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CreateRollupPropertyResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("CreateRollupProperty"))
                      .build();
        }
      }
    }
    return getCreateRollupPropertyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetRollupPropertySourceLinkRequest,
          com.google.analytics.admin.v1alpha.RollupPropertySourceLink>
      getGetRollupPropertySourceLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRollupPropertySourceLink",
      requestType = com.google.analytics.admin.v1alpha.GetRollupPropertySourceLinkRequest.class,
      responseType = com.google.analytics.admin.v1alpha.RollupPropertySourceLink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetRollupPropertySourceLinkRequest,
          com.google.analytics.admin.v1alpha.RollupPropertySourceLink>
      getGetRollupPropertySourceLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetRollupPropertySourceLinkRequest,
            com.google.analytics.admin.v1alpha.RollupPropertySourceLink>
        getGetRollupPropertySourceLinkMethod;
    if ((getGetRollupPropertySourceLinkMethod =
            AnalyticsAdminServiceGrpc.getGetRollupPropertySourceLinkMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetRollupPropertySourceLinkMethod =
                AnalyticsAdminServiceGrpc.getGetRollupPropertySourceLinkMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getGetRollupPropertySourceLinkMethod =
              getGetRollupPropertySourceLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetRollupPropertySourceLinkRequest,
                          com.google.analytics.admin.v1alpha.RollupPropertySourceLink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetRollupPropertySourceLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GetRollupPropertySourceLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.RollupPropertySourceLink
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "GetRollupPropertySourceLink"))
                      .build();
        }
      }
    }
    return getGetRollupPropertySourceLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListRollupPropertySourceLinksRequest,
          com.google.analytics.admin.v1alpha.ListRollupPropertySourceLinksResponse>
      getListRollupPropertySourceLinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRollupPropertySourceLinks",
      requestType = com.google.analytics.admin.v1alpha.ListRollupPropertySourceLinksRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ListRollupPropertySourceLinksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListRollupPropertySourceLinksRequest,
          com.google.analytics.admin.v1alpha.ListRollupPropertySourceLinksResponse>
      getListRollupPropertySourceLinksMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListRollupPropertySourceLinksRequest,
            com.google.analytics.admin.v1alpha.ListRollupPropertySourceLinksResponse>
        getListRollupPropertySourceLinksMethod;
    if ((getListRollupPropertySourceLinksMethod =
            AnalyticsAdminServiceGrpc.getListRollupPropertySourceLinksMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListRollupPropertySourceLinksMethod =
                AnalyticsAdminServiceGrpc.getListRollupPropertySourceLinksMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getListRollupPropertySourceLinksMethod =
              getListRollupPropertySourceLinksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ListRollupPropertySourceLinksRequest,
                          com.google.analytics.admin.v1alpha.ListRollupPropertySourceLinksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListRollupPropertySourceLinks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .ListRollupPropertySourceLinksRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .ListRollupPropertySourceLinksResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "ListRollupPropertySourceLinks"))
                      .build();
        }
      }
    }
    return getListRollupPropertySourceLinksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateRollupPropertySourceLinkRequest,
          com.google.analytics.admin.v1alpha.RollupPropertySourceLink>
      getCreateRollupPropertySourceLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRollupPropertySourceLink",
      requestType = com.google.analytics.admin.v1alpha.CreateRollupPropertySourceLinkRequest.class,
      responseType = com.google.analytics.admin.v1alpha.RollupPropertySourceLink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateRollupPropertySourceLinkRequest,
          com.google.analytics.admin.v1alpha.RollupPropertySourceLink>
      getCreateRollupPropertySourceLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.CreateRollupPropertySourceLinkRequest,
            com.google.analytics.admin.v1alpha.RollupPropertySourceLink>
        getCreateRollupPropertySourceLinkMethod;
    if ((getCreateRollupPropertySourceLinkMethod =
            AnalyticsAdminServiceGrpc.getCreateRollupPropertySourceLinkMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateRollupPropertySourceLinkMethod =
                AnalyticsAdminServiceGrpc.getCreateRollupPropertySourceLinkMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getCreateRollupPropertySourceLinkMethod =
              getCreateRollupPropertySourceLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.CreateRollupPropertySourceLinkRequest,
                          com.google.analytics.admin.v1alpha.RollupPropertySourceLink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateRollupPropertySourceLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .CreateRollupPropertySourceLinkRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.RollupPropertySourceLink
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "CreateRollupPropertySourceLink"))
                      .build();
        }
      }
    }
    return getCreateRollupPropertySourceLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteRollupPropertySourceLinkRequest,
          com.google.protobuf.Empty>
      getDeleteRollupPropertySourceLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRollupPropertySourceLink",
      requestType = com.google.analytics.admin.v1alpha.DeleteRollupPropertySourceLinkRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteRollupPropertySourceLinkRequest,
          com.google.protobuf.Empty>
      getDeleteRollupPropertySourceLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.DeleteRollupPropertySourceLinkRequest,
            com.google.protobuf.Empty>
        getDeleteRollupPropertySourceLinkMethod;
    if ((getDeleteRollupPropertySourceLinkMethod =
            AnalyticsAdminServiceGrpc.getDeleteRollupPropertySourceLinkMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeleteRollupPropertySourceLinkMethod =
                AnalyticsAdminServiceGrpc.getDeleteRollupPropertySourceLinkMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getDeleteRollupPropertySourceLinkMethod =
              getDeleteRollupPropertySourceLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.DeleteRollupPropertySourceLinkRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteRollupPropertySourceLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .DeleteRollupPropertySourceLinkRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "DeleteRollupPropertySourceLink"))
                      .build();
        }
      }
    }
    return getDeleteRollupPropertySourceLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateSubpropertyRequest,
          com.google.analytics.admin.v1alpha.CreateSubpropertyResponse>
      getCreateSubpropertyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSubproperty",
      requestType = com.google.analytics.admin.v1alpha.CreateSubpropertyRequest.class,
      responseType = com.google.analytics.admin.v1alpha.CreateSubpropertyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateSubpropertyRequest,
          com.google.analytics.admin.v1alpha.CreateSubpropertyResponse>
      getCreateSubpropertyMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.CreateSubpropertyRequest,
            com.google.analytics.admin.v1alpha.CreateSubpropertyResponse>
        getCreateSubpropertyMethod;
    if ((getCreateSubpropertyMethod = AnalyticsAdminServiceGrpc.getCreateSubpropertyMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateSubpropertyMethod = AnalyticsAdminServiceGrpc.getCreateSubpropertyMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getCreateSubpropertyMethod =
              getCreateSubpropertyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.CreateSubpropertyRequest,
                          com.google.analytics.admin.v1alpha.CreateSubpropertyResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSubproperty"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CreateSubpropertyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CreateSubpropertyResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("CreateSubproperty"))
                      .build();
        }
      }
    }
    return getCreateSubpropertyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateSubpropertyEventFilterRequest,
          com.google.analytics.admin.v1alpha.SubpropertyEventFilter>
      getCreateSubpropertyEventFilterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSubpropertyEventFilter",
      requestType = com.google.analytics.admin.v1alpha.CreateSubpropertyEventFilterRequest.class,
      responseType = com.google.analytics.admin.v1alpha.SubpropertyEventFilter.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateSubpropertyEventFilterRequest,
          com.google.analytics.admin.v1alpha.SubpropertyEventFilter>
      getCreateSubpropertyEventFilterMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.CreateSubpropertyEventFilterRequest,
            com.google.analytics.admin.v1alpha.SubpropertyEventFilter>
        getCreateSubpropertyEventFilterMethod;
    if ((getCreateSubpropertyEventFilterMethod =
            AnalyticsAdminServiceGrpc.getCreateSubpropertyEventFilterMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateSubpropertyEventFilterMethod =
                AnalyticsAdminServiceGrpc.getCreateSubpropertyEventFilterMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getCreateSubpropertyEventFilterMethod =
              getCreateSubpropertyEventFilterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.CreateSubpropertyEventFilterRequest,
                          com.google.analytics.admin.v1alpha.SubpropertyEventFilter>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateSubpropertyEventFilter"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CreateSubpropertyEventFilterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.SubpropertyEventFilter
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "CreateSubpropertyEventFilter"))
                      .build();
        }
      }
    }
    return getCreateSubpropertyEventFilterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetSubpropertyEventFilterRequest,
          com.google.analytics.admin.v1alpha.SubpropertyEventFilter>
      getGetSubpropertyEventFilterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSubpropertyEventFilter",
      requestType = com.google.analytics.admin.v1alpha.GetSubpropertyEventFilterRequest.class,
      responseType = com.google.analytics.admin.v1alpha.SubpropertyEventFilter.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetSubpropertyEventFilterRequest,
          com.google.analytics.admin.v1alpha.SubpropertyEventFilter>
      getGetSubpropertyEventFilterMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetSubpropertyEventFilterRequest,
            com.google.analytics.admin.v1alpha.SubpropertyEventFilter>
        getGetSubpropertyEventFilterMethod;
    if ((getGetSubpropertyEventFilterMethod =
            AnalyticsAdminServiceGrpc.getGetSubpropertyEventFilterMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetSubpropertyEventFilterMethod =
                AnalyticsAdminServiceGrpc.getGetSubpropertyEventFilterMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getGetSubpropertyEventFilterMethod =
              getGetSubpropertyEventFilterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetSubpropertyEventFilterRequest,
                          com.google.analytics.admin.v1alpha.SubpropertyEventFilter>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetSubpropertyEventFilter"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GetSubpropertyEventFilterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.SubpropertyEventFilter
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "GetSubpropertyEventFilter"))
                      .build();
        }
      }
    }
    return getGetSubpropertyEventFilterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListSubpropertyEventFiltersRequest,
          com.google.analytics.admin.v1alpha.ListSubpropertyEventFiltersResponse>
      getListSubpropertyEventFiltersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSubpropertyEventFilters",
      requestType = com.google.analytics.admin.v1alpha.ListSubpropertyEventFiltersRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ListSubpropertyEventFiltersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListSubpropertyEventFiltersRequest,
          com.google.analytics.admin.v1alpha.ListSubpropertyEventFiltersResponse>
      getListSubpropertyEventFiltersMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListSubpropertyEventFiltersRequest,
            com.google.analytics.admin.v1alpha.ListSubpropertyEventFiltersResponse>
        getListSubpropertyEventFiltersMethod;
    if ((getListSubpropertyEventFiltersMethod =
            AnalyticsAdminServiceGrpc.getListSubpropertyEventFiltersMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListSubpropertyEventFiltersMethod =
                AnalyticsAdminServiceGrpc.getListSubpropertyEventFiltersMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getListSubpropertyEventFiltersMethod =
              getListSubpropertyEventFiltersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ListSubpropertyEventFiltersRequest,
                          com.google.analytics.admin.v1alpha.ListSubpropertyEventFiltersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListSubpropertyEventFilters"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListSubpropertyEventFiltersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListSubpropertyEventFiltersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "ListSubpropertyEventFilters"))
                      .build();
        }
      }
    }
    return getListSubpropertyEventFiltersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateSubpropertyEventFilterRequest,
          com.google.analytics.admin.v1alpha.SubpropertyEventFilter>
      getUpdateSubpropertyEventFilterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSubpropertyEventFilter",
      requestType = com.google.analytics.admin.v1alpha.UpdateSubpropertyEventFilterRequest.class,
      responseType = com.google.analytics.admin.v1alpha.SubpropertyEventFilter.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateSubpropertyEventFilterRequest,
          com.google.analytics.admin.v1alpha.SubpropertyEventFilter>
      getUpdateSubpropertyEventFilterMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.UpdateSubpropertyEventFilterRequest,
            com.google.analytics.admin.v1alpha.SubpropertyEventFilter>
        getUpdateSubpropertyEventFilterMethod;
    if ((getUpdateSubpropertyEventFilterMethod =
            AnalyticsAdminServiceGrpc.getUpdateSubpropertyEventFilterMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateSubpropertyEventFilterMethod =
                AnalyticsAdminServiceGrpc.getUpdateSubpropertyEventFilterMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getUpdateSubpropertyEventFilterMethod =
              getUpdateSubpropertyEventFilterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.UpdateSubpropertyEventFilterRequest,
                          com.google.analytics.admin.v1alpha.SubpropertyEventFilter>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateSubpropertyEventFilter"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UpdateSubpropertyEventFilterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.SubpropertyEventFilter
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "UpdateSubpropertyEventFilter"))
                      .build();
        }
      }
    }
    return getUpdateSubpropertyEventFilterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteSubpropertyEventFilterRequest,
          com.google.protobuf.Empty>
      getDeleteSubpropertyEventFilterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSubpropertyEventFilter",
      requestType = com.google.analytics.admin.v1alpha.DeleteSubpropertyEventFilterRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteSubpropertyEventFilterRequest,
          com.google.protobuf.Empty>
      getDeleteSubpropertyEventFilterMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.DeleteSubpropertyEventFilterRequest,
            com.google.protobuf.Empty>
        getDeleteSubpropertyEventFilterMethod;
    if ((getDeleteSubpropertyEventFilterMethod =
            AnalyticsAdminServiceGrpc.getDeleteSubpropertyEventFilterMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeleteSubpropertyEventFilterMethod =
                AnalyticsAdminServiceGrpc.getDeleteSubpropertyEventFilterMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getDeleteSubpropertyEventFilterMethod =
              getDeleteSubpropertyEventFilterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.DeleteSubpropertyEventFilterRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteSubpropertyEventFilter"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DeleteSubpropertyEventFilterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "DeleteSubpropertyEventFilter"))
                      .build();
        }
      }
    }
    return getDeleteSubpropertyEventFilterMethod;
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
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lookup for a single Account.
     * </pre>
     */
    default void getAccount(
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
    default void listAccounts(
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
     * AccessBindings) will be permanently purged.
     * https://support.google.com/analytics/answer/6154772
     * Returns an error if the target is not found.
     * </pre>
     */
    default void deleteAccount(
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
    default void updateAccount(
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
    default void provisionAccountTicket(
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
    default void listAccountSummaries(
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
    default void getProperty(
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
    default void listProperties(
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
    default void createProperty(
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
     * and all child resources (eg: GoogleAdsLinks, Streams, AccessBindings)
     * will be permanently purged.
     * https://support.google.com/analytics/answer/6154772
     * Returns an error if the target is not found, or is not a GA4 Property.
     * </pre>
     */
    default void deleteProperty(
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
    default void updateProperty(
        com.google.analytics.admin.v1alpha.UpdatePropertyRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Property> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdatePropertyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a FirebaseLink.
     * Properties can have at most one FirebaseLink.
     * </pre>
     */
    default void createFirebaseLink(
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
    default void deleteFirebaseLink(
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
    default void listFirebaseLinks(
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
    default void getGlobalSiteTag(
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
    default void createGoogleAdsLink(
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
    default void updateGoogleAdsLink(
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
    default void deleteGoogleAdsLink(
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
    default void listGoogleAdsLinks(
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
    default void getDataSharingSettings(
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
    default void getMeasurementProtocolSecret(
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
    default void listMeasurementProtocolSecrets(
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
    default void createMeasurementProtocolSecret(
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
    default void deleteMeasurementProtocolSecret(
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
    default void updateMeasurementProtocolSecret(
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
     * or through this API) before MeasurementProtocolSecret resources may be
     * created.
     * </pre>
     */
    default void acknowledgeUserDataCollection(
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
     * Looks up a single SKAdNetworkConversionValueSchema.
     * </pre>
     */
    default void getSKAdNetworkConversionValueSchema(
        com.google.analytics.admin.v1alpha.GetSKAdNetworkConversionValueSchemaRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSKAdNetworkConversionValueSchemaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a SKAdNetworkConversionValueSchema.
     * </pre>
     */
    default void createSKAdNetworkConversionValueSchema(
        com.google.analytics.admin.v1alpha.CreateSKAdNetworkConversionValueSchemaRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSKAdNetworkConversionValueSchemaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes target SKAdNetworkConversionValueSchema.
     * </pre>
     */
    default void deleteSKAdNetworkConversionValueSchema(
        com.google.analytics.admin.v1alpha.DeleteSKAdNetworkConversionValueSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSKAdNetworkConversionValueSchemaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a SKAdNetworkConversionValueSchema.
     * </pre>
     */
    default void updateSKAdNetworkConversionValueSchema(
        com.google.analytics.admin.v1alpha.UpdateSKAdNetworkConversionValueSchemaRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSKAdNetworkConversionValueSchemaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists SKAdNetworkConversionValueSchema on a stream.
     * Properties can have at most one SKAdNetworkConversionValueSchema.
     * </pre>
     */
    default void listSKAdNetworkConversionValueSchemas(
        com.google.analytics.admin.v1alpha.ListSKAdNetworkConversionValueSchemasRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.ListSKAdNetworkConversionValueSchemasResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSKAdNetworkConversionValueSchemasMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches through all changes to an account or its children given the
     * specified set of filters.
     * </pre>
     */
    default void searchChangeHistoryEvents(
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
    default void getGoogleSignalsSettings(
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
    default void updateGoogleSignalsSettings(
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
    default void createConversionEvent(
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
     * Updates a conversion event with the specified attributes.
     * </pre>
     */
    default void updateConversionEvent(
        com.google.analytics.admin.v1alpha.UpdateConversionEventRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ConversionEvent>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateConversionEventMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single conversion event.
     * </pre>
     */
    default void getConversionEvent(
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
    default void deleteConversionEvent(
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
    default void listConversionEvents(
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
    default void getDisplayVideo360AdvertiserLink(
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
    default void listDisplayVideo360AdvertiserLinks(
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
    default void createDisplayVideo360AdvertiserLink(
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
    default void deleteDisplayVideo360AdvertiserLink(
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
    default void updateDisplayVideo360AdvertiserLink(
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
    default void getDisplayVideo360AdvertiserLinkProposal(
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
    default void listDisplayVideo360AdvertiserLinkProposals(
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
    default void createDisplayVideo360AdvertiserLinkProposal(
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
    default void deleteDisplayVideo360AdvertiserLinkProposal(
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
    default void approveDisplayVideo360AdvertiserLinkProposal(
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
    default void cancelDisplayVideo360AdvertiserLinkProposal(
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
    default void createCustomDimension(
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
    default void updateCustomDimension(
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
    default void listCustomDimensions(
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
    default void archiveCustomDimension(
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
    default void getCustomDimension(
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
    default void createCustomMetric(
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
    default void updateCustomMetric(
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
    default void listCustomMetrics(
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
    default void archiveCustomMetric(
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
    default void getCustomMetric(
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
    default void getDataRetentionSettings(
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
    default void updateDataRetentionSettings(
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
    default void createDataStream(
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
    default void deleteDataStream(
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
    default void updateDataStream(
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
    default void listDataStreams(
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
    default void getDataStream(
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
     * Default audiences will not show filter definitions.
     * </pre>
     */
    default void getAudience(
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
     * Default audiences will not show filter definitions.
     * </pre>
     */
    default void listAudiences(
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
    default void createAudience(
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
    default void updateAudience(
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
    default void archiveAudience(
        com.google.analytics.admin.v1alpha.ArchiveAudienceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getArchiveAudienceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Look up a single SearchAds360Link
     * </pre>
     */
    default void getSearchAds360Link(
        com.google.analytics.admin.v1alpha.GetSearchAds360LinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.SearchAds360Link>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSearchAds360LinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all SearchAds360Links on a property.
     * </pre>
     */
    default void listSearchAds360Links(
        com.google.analytics.admin.v1alpha.ListSearchAds360LinksRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.ListSearchAds360LinksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSearchAds360LinksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a SearchAds360Link.
     * </pre>
     */
    default void createSearchAds360Link(
        com.google.analytics.admin.v1alpha.CreateSearchAds360LinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.SearchAds360Link>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSearchAds360LinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a SearchAds360Link on a property.
     * </pre>
     */
    default void deleteSearchAds360Link(
        com.google.analytics.admin.v1alpha.DeleteSearchAds360LinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSearchAds360LinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a SearchAds360Link on a property.
     * </pre>
     */
    default void updateSearchAds360Link(
        com.google.analytics.admin.v1alpha.UpdateSearchAds360LinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.SearchAds360Link>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSearchAds360LinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a AttributionSettings singleton.
     * </pre>
     */
    default void getAttributionSettings(
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
    default void updateAttributionSettings(
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
     * Data Access Reports can be requested for a property. Reports may be
     * requested for any property, but dimensions that aren't related to quota can
     * only be requested on Google Analytics 360 properties. This method is only
     * available to Administrators.
     * These data access records include GA4 UI Reporting, GA4 UI Explorations,
     * GA4 Data API, and other products like Firebase &amp; Admob that can retrieve
     * data from Google Analytics through a linkage. These records don't include
     * property configuration changes like adding a stream or changing a
     * property's time zone. For configuration change history, see
     * [searchChangeHistoryEvents](https://developers.google.com/analytics/devguides/config/admin/v1/rest/v1alpha/accounts/searchChangeHistoryEvents).
     * </pre>
     */
    default void runAccessReport(
        com.google.analytics.admin.v1alpha.RunAccessReportRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.RunAccessReportResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRunAccessReportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an access binding on an account or property.
     * </pre>
     */
    default void createAccessBinding(
        com.google.analytics.admin.v1alpha.CreateAccessBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AccessBinding>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAccessBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information about an access binding.
     * </pre>
     */
    default void getAccessBinding(
        com.google.analytics.admin.v1alpha.GetAccessBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AccessBinding>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAccessBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an access binding on an account or property.
     * </pre>
     */
    default void updateAccessBinding(
        com.google.analytics.admin.v1alpha.UpdateAccessBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AccessBinding>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAccessBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an access binding on an account or property.
     * </pre>
     */
    default void deleteAccessBinding(
        com.google.analytics.admin.v1alpha.DeleteAccessBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAccessBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all access bindings on an account or property.
     * </pre>
     */
    default void listAccessBindings(
        com.google.analytics.admin.v1alpha.ListAccessBindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListAccessBindingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAccessBindingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates information about multiple access bindings to an account or
     * property.
     * This method is transactional. If any AccessBinding cannot be created, none
     * of the AccessBindings will be created.
     * </pre>
     */
    default void batchCreateAccessBindings(
        com.google.analytics.admin.v1alpha.BatchCreateAccessBindingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.BatchCreateAccessBindingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchCreateAccessBindingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information about multiple access bindings to an account or property.
     * </pre>
     */
    default void batchGetAccessBindings(
        com.google.analytics.admin.v1alpha.BatchGetAccessBindingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.BatchGetAccessBindingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchGetAccessBindingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates information about multiple access bindings to an account or
     * property.
     * </pre>
     */
    default void batchUpdateAccessBindings(
        com.google.analytics.admin.v1alpha.BatchUpdateAccessBindingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.BatchUpdateAccessBindingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchUpdateAccessBindingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes information about multiple users' links to an account or property.
     * </pre>
     */
    default void batchDeleteAccessBindings(
        com.google.analytics.admin.v1alpha.BatchDeleteAccessBindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchDeleteAccessBindingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single ExpandedDataSet.
     * </pre>
     */
    default void getExpandedDataSet(
        com.google.analytics.admin.v1alpha.GetExpandedDataSetRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ExpandedDataSet>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetExpandedDataSetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ExpandedDataSets on a property.
     * </pre>
     */
    default void listExpandedDataSets(
        com.google.analytics.admin.v1alpha.ListExpandedDataSetsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListExpandedDataSetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListExpandedDataSetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a ExpandedDataSet.
     * </pre>
     */
    default void createExpandedDataSet(
        com.google.analytics.admin.v1alpha.CreateExpandedDataSetRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ExpandedDataSet>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateExpandedDataSetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a ExpandedDataSet on a property.
     * </pre>
     */
    default void updateExpandedDataSet(
        com.google.analytics.admin.v1alpha.UpdateExpandedDataSetRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ExpandedDataSet>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateExpandedDataSetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ExpandedDataSet on a property.
     * </pre>
     */
    default void deleteExpandedDataSet(
        com.google.analytics.admin.v1alpha.DeleteExpandedDataSetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteExpandedDataSetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single ChannelGroup.
     * </pre>
     */
    default void getChannelGroup(
        com.google.analytics.admin.v1alpha.GetChannelGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ChannelGroup>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetChannelGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ChannelGroups on a property.
     * </pre>
     */
    default void listChannelGroups(
        com.google.analytics.admin.v1alpha.ListChannelGroupsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListChannelGroupsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListChannelGroupsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a ChannelGroup.
     * </pre>
     */
    default void createChannelGroup(
        com.google.analytics.admin.v1alpha.CreateChannelGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ChannelGroup>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateChannelGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a ChannelGroup.
     * </pre>
     */
    default void updateChannelGroup(
        com.google.analytics.admin.v1alpha.UpdateChannelGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ChannelGroup>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateChannelGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ChannelGroup on a property.
     * </pre>
     */
    default void deleteChannelGroup(
        com.google.analytics.admin.v1alpha.DeleteChannelGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteChannelGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the opt out status for the automated GA4 setup process for a UA
     * property.
     * Note: this has no effect on GA4 property.
     * </pre>
     */
    default void setAutomatedGa4ConfigurationOptOut(
        com.google.analytics.admin.v1alpha.SetAutomatedGa4ConfigurationOptOutRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.SetAutomatedGa4ConfigurationOptOutResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetAutomatedGa4ConfigurationOptOutMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches the opt out status for the automated GA4 setup process for a UA
     * property.
     * Note: this has no effect on GA4 property.
     * </pre>
     */
    default void fetchAutomatedGa4ConfigurationOptOut(
        com.google.analytics.admin.v1alpha.FetchAutomatedGa4ConfigurationOptOutRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.FetchAutomatedGa4ConfigurationOptOutResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFetchAutomatedGa4ConfigurationOptOutMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single BigQuery Link.
     * </pre>
     */
    default void getBigQueryLink(
        com.google.analytics.admin.v1alpha.GetBigQueryLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.BigQueryLink>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetBigQueryLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists BigQuery Links on a property.
     * </pre>
     */
    default void listBigQueryLinks(
        com.google.analytics.admin.v1alpha.ListBigQueryLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListBigQueryLinksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBigQueryLinksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the enhanced measurement settings for this data stream.
     * Note that the stream must enable enhanced measurement for these settings to
     * take effect.
     * </pre>
     */
    default void getEnhancedMeasurementSettings(
        com.google.analytics.admin.v1alpha.GetEnhancedMeasurementSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEnhancedMeasurementSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the enhanced measurement settings for this data stream.
     * Note that the stream must enable enhanced measurement for these settings to
     * take effect.
     * </pre>
     */
    default void updateEnhancedMeasurementSettings(
        com.google.analytics.admin.v1alpha.UpdateEnhancedMeasurementSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateEnhancedMeasurementSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a connected site tag for a Universal Analytics property. You can
     * create a maximum of 20 connected site tags per property.
     * Note: This API cannot be used on GA4 properties.
     * </pre>
     */
    default void createConnectedSiteTag(
        com.google.analytics.admin.v1alpha.CreateConnectedSiteTagRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.CreateConnectedSiteTagResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateConnectedSiteTagMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a connected site tag for a Universal Analytics property.
     * Note: this has no effect on GA4 properties.
     * </pre>
     */
    default void deleteConnectedSiteTag(
        com.google.analytics.admin.v1alpha.DeleteConnectedSiteTagRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteConnectedSiteTagMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the connected site tags for a Universal Analytics property. A maximum
     * of 20 connected site tags will be returned. Note: this has no effect on GA4
     * property.
     * </pre>
     */
    default void listConnectedSiteTags(
        com.google.analytics.admin.v1alpha.ListConnectedSiteTagsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.ListConnectedSiteTagsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListConnectedSiteTagsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Given a specified UA property, looks up the GA4 property connected to it.
     * Note: this cannot be used with GA4 properties.
     * </pre>
     */
    default void fetchConnectedGa4Property(
        com.google.analytics.admin.v1alpha.FetchConnectedGa4PropertyRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.FetchConnectedGa4PropertyResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFetchConnectedGa4PropertyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Looks up a single AdSenseLink.
     * </pre>
     */
    default void getAdSenseLink(
        com.google.analytics.admin.v1alpha.GetAdSenseLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AdSenseLink>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAdSenseLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an AdSenseLink.
     * </pre>
     */
    default void createAdSenseLink(
        com.google.analytics.admin.v1alpha.CreateAdSenseLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AdSenseLink>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAdSenseLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an AdSenseLink.
     * </pre>
     */
    default void deleteAdSenseLink(
        com.google.analytics.admin.v1alpha.DeleteAdSenseLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAdSenseLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists AdSenseLinks on a property.
     * </pre>
     */
    default void listAdSenseLinks(
        com.google.analytics.admin.v1alpha.ListAdSenseLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListAdSenseLinksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAdSenseLinksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single EventCreateRule.
     * </pre>
     */
    default void getEventCreateRule(
        com.google.analytics.admin.v1alpha.GetEventCreateRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.EventCreateRule>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEventCreateRuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists EventCreateRules on a web data stream.
     * </pre>
     */
    default void listEventCreateRules(
        com.google.analytics.admin.v1alpha.ListEventCreateRulesRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListEventCreateRulesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEventCreateRulesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an EventCreateRule.
     * </pre>
     */
    default void createEventCreateRule(
        com.google.analytics.admin.v1alpha.CreateEventCreateRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.EventCreateRule>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateEventCreateRuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an EventCreateRule.
     * </pre>
     */
    default void updateEventCreateRule(
        com.google.analytics.admin.v1alpha.UpdateEventCreateRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.EventCreateRule>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateEventCreateRuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an EventCreateRule.
     * </pre>
     */
    default void deleteEventCreateRule(
        com.google.analytics.admin.v1alpha.DeleteEventCreateRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteEventCreateRuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a DataRedactionSettings on a property.
     * </pre>
     */
    default void updateDataRedactionSettings(
        com.google.analytics.admin.v1alpha.UpdateDataRedactionSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.DataRedactionSettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDataRedactionSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single DataRedactionSettings.
     * </pre>
     */
    default void getDataRedactionSettings(
        com.google.analytics.admin.v1alpha.GetDataRedactionSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.DataRedactionSettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDataRedactionSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single CalculatedMetric.
     * </pre>
     */
    default void getCalculatedMetric(
        com.google.analytics.admin.v1alpha.GetCalculatedMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.CalculatedMetric>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCalculatedMetricMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a CalculatedMetric.
     * </pre>
     */
    default void createCalculatedMetric(
        com.google.analytics.admin.v1alpha.CreateCalculatedMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.CalculatedMetric>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCalculatedMetricMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists CalculatedMetrics on a property.
     * </pre>
     */
    default void listCalculatedMetrics(
        com.google.analytics.admin.v1alpha.ListCalculatedMetricsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.ListCalculatedMetricsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCalculatedMetricsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a CalculatedMetric on a property.
     * </pre>
     */
    default void updateCalculatedMetric(
        com.google.analytics.admin.v1alpha.UpdateCalculatedMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.CalculatedMetric>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateCalculatedMetricMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a CalculatedMetric on a property.
     * </pre>
     */
    default void deleteCalculatedMetric(
        com.google.analytics.admin.v1alpha.DeleteCalculatedMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteCalculatedMetricMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a roll-up property and all roll-up property source links.
     * </pre>
     */
    default void createRollupProperty(
        com.google.analytics.admin.v1alpha.CreateRollupPropertyRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.CreateRollupPropertyResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateRollupPropertyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single roll-up property source Link.
     * Only roll-up properties can have source links, so this method will throw an
     * error if used on other types of properties.
     * </pre>
     */
    default void getRollupPropertySourceLink(
        com.google.analytics.admin.v1alpha.GetRollupPropertySourceLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.RollupPropertySourceLink>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetRollupPropertySourceLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists roll-up property source Links on a property.
     * Only roll-up properties can have source links, so this method will throw an
     * error if used on other types of properties.
     * </pre>
     */
    default void listRollupPropertySourceLinks(
        com.google.analytics.admin.v1alpha.ListRollupPropertySourceLinksRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.ListRollupPropertySourceLinksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRollupPropertySourceLinksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a roll-up property source link.
     * Only roll-up properties can have source links, so this method will throw an
     * error if used on other types of properties.
     * </pre>
     */
    default void createRollupPropertySourceLink(
        com.google.analytics.admin.v1alpha.CreateRollupPropertySourceLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.RollupPropertySourceLink>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateRollupPropertySourceLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a roll-up property source link.
     * Only roll-up properties can have source links, so this method will throw an
     * error if used on other types of properties.
     * </pre>
     */
    default void deleteRollupPropertySourceLink(
        com.google.analytics.admin.v1alpha.DeleteRollupPropertySourceLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteRollupPropertySourceLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a subproperty and a subproperty event filter that applies to the
     * created subproperty.
     * </pre>
     */
    default void createSubproperty(
        com.google.analytics.admin.v1alpha.CreateSubpropertyRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.CreateSubpropertyResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSubpropertyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a subproperty Event Filter.
     * </pre>
     */
    default void createSubpropertyEventFilter(
        com.google.analytics.admin.v1alpha.CreateSubpropertyEventFilterRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.SubpropertyEventFilter>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSubpropertyEventFilterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single subproperty Event Filter.
     * </pre>
     */
    default void getSubpropertyEventFilter(
        com.google.analytics.admin.v1alpha.GetSubpropertyEventFilterRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.SubpropertyEventFilter>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSubpropertyEventFilterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all subproperty Event Filters on a property.
     * </pre>
     */
    default void listSubpropertyEventFilters(
        com.google.analytics.admin.v1alpha.ListSubpropertyEventFiltersRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.ListSubpropertyEventFiltersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSubpropertyEventFiltersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a subproperty Event Filter.
     * </pre>
     */
    default void updateSubpropertyEventFilter(
        com.google.analytics.admin.v1alpha.UpdateSubpropertyEventFilterRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.SubpropertyEventFilter>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSubpropertyEventFilterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a subproperty event filter.
     * </pre>
     */
    default void deleteSubpropertyEventFilter(
        com.google.analytics.admin.v1alpha.DeleteSubpropertyEventFilterRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSubpropertyEventFilterMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AnalyticsAdminService.
   *
   * <pre>
   * Service Interface for the Analytics Admin API (GA4).
   * </pre>
   */
  public abstract static class AnalyticsAdminServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AnalyticsAdminServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AnalyticsAdminService.
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
     * AccessBindings) will be permanently purged.
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
     * and all child resources (eg: GoogleAdsLinks, Streams, AccessBindings)
     * will be permanently purged.
     * https://support.google.com/analytics/answer/6154772
     * Returns an error if the target is not found, or is not a GA4 Property.
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
     * or through this API) before MeasurementProtocolSecret resources may be
     * created.
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
     * Looks up a single SKAdNetworkConversionValueSchema.
     * </pre>
     */
    public void getSKAdNetworkConversionValueSchema(
        com.google.analytics.admin.v1alpha.GetSKAdNetworkConversionValueSchemaRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSKAdNetworkConversionValueSchemaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a SKAdNetworkConversionValueSchema.
     * </pre>
     */
    public void createSKAdNetworkConversionValueSchema(
        com.google.analytics.admin.v1alpha.CreateSKAdNetworkConversionValueSchemaRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSKAdNetworkConversionValueSchemaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes target SKAdNetworkConversionValueSchema.
     * </pre>
     */
    public void deleteSKAdNetworkConversionValueSchema(
        com.google.analytics.admin.v1alpha.DeleteSKAdNetworkConversionValueSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSKAdNetworkConversionValueSchemaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a SKAdNetworkConversionValueSchema.
     * </pre>
     */
    public void updateSKAdNetworkConversionValueSchema(
        com.google.analytics.admin.v1alpha.UpdateSKAdNetworkConversionValueSchemaRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSKAdNetworkConversionValueSchemaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists SKAdNetworkConversionValueSchema on a stream.
     * Properties can have at most one SKAdNetworkConversionValueSchema.
     * </pre>
     */
    public void listSKAdNetworkConversionValueSchemas(
        com.google.analytics.admin.v1alpha.ListSKAdNetworkConversionValueSchemasRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.ListSKAdNetworkConversionValueSchemasResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSKAdNetworkConversionValueSchemasMethod(), getCallOptions()),
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
     * Updates a conversion event with the specified attributes.
     * </pre>
     */
    public void updateConversionEvent(
        com.google.analytics.admin.v1alpha.UpdateConversionEventRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ConversionEvent>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateConversionEventMethod(), getCallOptions()),
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
     * Default audiences will not show filter definitions.
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
     * Default audiences will not show filter definitions.
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
     * Look up a single SearchAds360Link
     * </pre>
     */
    public void getSearchAds360Link(
        com.google.analytics.admin.v1alpha.GetSearchAds360LinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.SearchAds360Link>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSearchAds360LinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all SearchAds360Links on a property.
     * </pre>
     */
    public void listSearchAds360Links(
        com.google.analytics.admin.v1alpha.ListSearchAds360LinksRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.ListSearchAds360LinksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSearchAds360LinksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a SearchAds360Link.
     * </pre>
     */
    public void createSearchAds360Link(
        com.google.analytics.admin.v1alpha.CreateSearchAds360LinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.SearchAds360Link>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSearchAds360LinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a SearchAds360Link on a property.
     * </pre>
     */
    public void deleteSearchAds360Link(
        com.google.analytics.admin.v1alpha.DeleteSearchAds360LinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSearchAds360LinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a SearchAds360Link on a property.
     * </pre>
     */
    public void updateSearchAds360Link(
        com.google.analytics.admin.v1alpha.UpdateSearchAds360LinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.SearchAds360Link>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSearchAds360LinkMethod(), getCallOptions()),
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
     * Data Access Reports can be requested for a property. Reports may be
     * requested for any property, but dimensions that aren't related to quota can
     * only be requested on Google Analytics 360 properties. This method is only
     * available to Administrators.
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

    /**
     *
     *
     * <pre>
     * Creates an access binding on an account or property.
     * </pre>
     */
    public void createAccessBinding(
        com.google.analytics.admin.v1alpha.CreateAccessBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AccessBinding>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAccessBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information about an access binding.
     * </pre>
     */
    public void getAccessBinding(
        com.google.analytics.admin.v1alpha.GetAccessBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AccessBinding>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAccessBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an access binding on an account or property.
     * </pre>
     */
    public void updateAccessBinding(
        com.google.analytics.admin.v1alpha.UpdateAccessBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AccessBinding>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAccessBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an access binding on an account or property.
     * </pre>
     */
    public void deleteAccessBinding(
        com.google.analytics.admin.v1alpha.DeleteAccessBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAccessBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all access bindings on an account or property.
     * </pre>
     */
    public void listAccessBindings(
        com.google.analytics.admin.v1alpha.ListAccessBindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListAccessBindingsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAccessBindingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates information about multiple access bindings to an account or
     * property.
     * This method is transactional. If any AccessBinding cannot be created, none
     * of the AccessBindings will be created.
     * </pre>
     */
    public void batchCreateAccessBindings(
        com.google.analytics.admin.v1alpha.BatchCreateAccessBindingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.BatchCreateAccessBindingsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchCreateAccessBindingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information about multiple access bindings to an account or property.
     * </pre>
     */
    public void batchGetAccessBindings(
        com.google.analytics.admin.v1alpha.BatchGetAccessBindingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.BatchGetAccessBindingsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchGetAccessBindingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates information about multiple access bindings to an account or
     * property.
     * </pre>
     */
    public void batchUpdateAccessBindings(
        com.google.analytics.admin.v1alpha.BatchUpdateAccessBindingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.BatchUpdateAccessBindingsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchUpdateAccessBindingsMethod(), getCallOptions()),
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
    public void batchDeleteAccessBindings(
        com.google.analytics.admin.v1alpha.BatchDeleteAccessBindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchDeleteAccessBindingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single ExpandedDataSet.
     * </pre>
     */
    public void getExpandedDataSet(
        com.google.analytics.admin.v1alpha.GetExpandedDataSetRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ExpandedDataSet>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetExpandedDataSetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ExpandedDataSets on a property.
     * </pre>
     */
    public void listExpandedDataSets(
        com.google.analytics.admin.v1alpha.ListExpandedDataSetsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListExpandedDataSetsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListExpandedDataSetsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a ExpandedDataSet.
     * </pre>
     */
    public void createExpandedDataSet(
        com.google.analytics.admin.v1alpha.CreateExpandedDataSetRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ExpandedDataSet>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateExpandedDataSetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a ExpandedDataSet on a property.
     * </pre>
     */
    public void updateExpandedDataSet(
        com.google.analytics.admin.v1alpha.UpdateExpandedDataSetRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ExpandedDataSet>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateExpandedDataSetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ExpandedDataSet on a property.
     * </pre>
     */
    public void deleteExpandedDataSet(
        com.google.analytics.admin.v1alpha.DeleteExpandedDataSetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteExpandedDataSetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single ChannelGroup.
     * </pre>
     */
    public void getChannelGroup(
        com.google.analytics.admin.v1alpha.GetChannelGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ChannelGroup>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetChannelGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ChannelGroups on a property.
     * </pre>
     */
    public void listChannelGroups(
        com.google.analytics.admin.v1alpha.ListChannelGroupsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListChannelGroupsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListChannelGroupsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a ChannelGroup.
     * </pre>
     */
    public void createChannelGroup(
        com.google.analytics.admin.v1alpha.CreateChannelGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ChannelGroup>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateChannelGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a ChannelGroup.
     * </pre>
     */
    public void updateChannelGroup(
        com.google.analytics.admin.v1alpha.UpdateChannelGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ChannelGroup>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateChannelGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ChannelGroup on a property.
     * </pre>
     */
    public void deleteChannelGroup(
        com.google.analytics.admin.v1alpha.DeleteChannelGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteChannelGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the opt out status for the automated GA4 setup process for a UA
     * property.
     * Note: this has no effect on GA4 property.
     * </pre>
     */
    public void setAutomatedGa4ConfigurationOptOut(
        com.google.analytics.admin.v1alpha.SetAutomatedGa4ConfigurationOptOutRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.SetAutomatedGa4ConfigurationOptOutResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetAutomatedGa4ConfigurationOptOutMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches the opt out status for the automated GA4 setup process for a UA
     * property.
     * Note: this has no effect on GA4 property.
     * </pre>
     */
    public void fetchAutomatedGa4ConfigurationOptOut(
        com.google.analytics.admin.v1alpha.FetchAutomatedGa4ConfigurationOptOutRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.FetchAutomatedGa4ConfigurationOptOutResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchAutomatedGa4ConfigurationOptOutMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single BigQuery Link.
     * </pre>
     */
    public void getBigQueryLink(
        com.google.analytics.admin.v1alpha.GetBigQueryLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.BigQueryLink>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBigQueryLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists BigQuery Links on a property.
     * </pre>
     */
    public void listBigQueryLinks(
        com.google.analytics.admin.v1alpha.ListBigQueryLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListBigQueryLinksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBigQueryLinksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the enhanced measurement settings for this data stream.
     * Note that the stream must enable enhanced measurement for these settings to
     * take effect.
     * </pre>
     */
    public void getEnhancedMeasurementSettings(
        com.google.analytics.admin.v1alpha.GetEnhancedMeasurementSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEnhancedMeasurementSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the enhanced measurement settings for this data stream.
     * Note that the stream must enable enhanced measurement for these settings to
     * take effect.
     * </pre>
     */
    public void updateEnhancedMeasurementSettings(
        com.google.analytics.admin.v1alpha.UpdateEnhancedMeasurementSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEnhancedMeasurementSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a connected site tag for a Universal Analytics property. You can
     * create a maximum of 20 connected site tags per property.
     * Note: This API cannot be used on GA4 properties.
     * </pre>
     */
    public void createConnectedSiteTag(
        com.google.analytics.admin.v1alpha.CreateConnectedSiteTagRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.CreateConnectedSiteTagResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateConnectedSiteTagMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a connected site tag for a Universal Analytics property.
     * Note: this has no effect on GA4 properties.
     * </pre>
     */
    public void deleteConnectedSiteTag(
        com.google.analytics.admin.v1alpha.DeleteConnectedSiteTagRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteConnectedSiteTagMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the connected site tags for a Universal Analytics property. A maximum
     * of 20 connected site tags will be returned. Note: this has no effect on GA4
     * property.
     * </pre>
     */
    public void listConnectedSiteTags(
        com.google.analytics.admin.v1alpha.ListConnectedSiteTagsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.ListConnectedSiteTagsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListConnectedSiteTagsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Given a specified UA property, looks up the GA4 property connected to it.
     * Note: this cannot be used with GA4 properties.
     * </pre>
     */
    public void fetchConnectedGa4Property(
        com.google.analytics.admin.v1alpha.FetchConnectedGa4PropertyRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.FetchConnectedGa4PropertyResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchConnectedGa4PropertyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Looks up a single AdSenseLink.
     * </pre>
     */
    public void getAdSenseLink(
        com.google.analytics.admin.v1alpha.GetAdSenseLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AdSenseLink>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAdSenseLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an AdSenseLink.
     * </pre>
     */
    public void createAdSenseLink(
        com.google.analytics.admin.v1alpha.CreateAdSenseLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AdSenseLink>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAdSenseLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an AdSenseLink.
     * </pre>
     */
    public void deleteAdSenseLink(
        com.google.analytics.admin.v1alpha.DeleteAdSenseLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAdSenseLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists AdSenseLinks on a property.
     * </pre>
     */
    public void listAdSenseLinks(
        com.google.analytics.admin.v1alpha.ListAdSenseLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListAdSenseLinksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAdSenseLinksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single EventCreateRule.
     * </pre>
     */
    public void getEventCreateRule(
        com.google.analytics.admin.v1alpha.GetEventCreateRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.EventCreateRule>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEventCreateRuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists EventCreateRules on a web data stream.
     * </pre>
     */
    public void listEventCreateRules(
        com.google.analytics.admin.v1alpha.ListEventCreateRulesRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListEventCreateRulesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEventCreateRulesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an EventCreateRule.
     * </pre>
     */
    public void createEventCreateRule(
        com.google.analytics.admin.v1alpha.CreateEventCreateRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.EventCreateRule>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEventCreateRuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an EventCreateRule.
     * </pre>
     */
    public void updateEventCreateRule(
        com.google.analytics.admin.v1alpha.UpdateEventCreateRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.EventCreateRule>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEventCreateRuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an EventCreateRule.
     * </pre>
     */
    public void deleteEventCreateRule(
        com.google.analytics.admin.v1alpha.DeleteEventCreateRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEventCreateRuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a DataRedactionSettings on a property.
     * </pre>
     */
    public void updateDataRedactionSettings(
        com.google.analytics.admin.v1alpha.UpdateDataRedactionSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.DataRedactionSettings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDataRedactionSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single DataRedactionSettings.
     * </pre>
     */
    public void getDataRedactionSettings(
        com.google.analytics.admin.v1alpha.GetDataRedactionSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.DataRedactionSettings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataRedactionSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single CalculatedMetric.
     * </pre>
     */
    public void getCalculatedMetric(
        com.google.analytics.admin.v1alpha.GetCalculatedMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.CalculatedMetric>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCalculatedMetricMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a CalculatedMetric.
     * </pre>
     */
    public void createCalculatedMetric(
        com.google.analytics.admin.v1alpha.CreateCalculatedMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.CalculatedMetric>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCalculatedMetricMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists CalculatedMetrics on a property.
     * </pre>
     */
    public void listCalculatedMetrics(
        com.google.analytics.admin.v1alpha.ListCalculatedMetricsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.ListCalculatedMetricsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCalculatedMetricsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a CalculatedMetric on a property.
     * </pre>
     */
    public void updateCalculatedMetric(
        com.google.analytics.admin.v1alpha.UpdateCalculatedMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.CalculatedMetric>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCalculatedMetricMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a CalculatedMetric on a property.
     * </pre>
     */
    public void deleteCalculatedMetric(
        com.google.analytics.admin.v1alpha.DeleteCalculatedMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCalculatedMetricMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a roll-up property and all roll-up property source links.
     * </pre>
     */
    public void createRollupProperty(
        com.google.analytics.admin.v1alpha.CreateRollupPropertyRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.CreateRollupPropertyResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRollupPropertyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single roll-up property source Link.
     * Only roll-up properties can have source links, so this method will throw an
     * error if used on other types of properties.
     * </pre>
     */
    public void getRollupPropertySourceLink(
        com.google.analytics.admin.v1alpha.GetRollupPropertySourceLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.RollupPropertySourceLink>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRollupPropertySourceLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists roll-up property source Links on a property.
     * Only roll-up properties can have source links, so this method will throw an
     * error if used on other types of properties.
     * </pre>
     */
    public void listRollupPropertySourceLinks(
        com.google.analytics.admin.v1alpha.ListRollupPropertySourceLinksRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.ListRollupPropertySourceLinksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRollupPropertySourceLinksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a roll-up property source link.
     * Only roll-up properties can have source links, so this method will throw an
     * error if used on other types of properties.
     * </pre>
     */
    public void createRollupPropertySourceLink(
        com.google.analytics.admin.v1alpha.CreateRollupPropertySourceLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.RollupPropertySourceLink>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRollupPropertySourceLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a roll-up property source link.
     * Only roll-up properties can have source links, so this method will throw an
     * error if used on other types of properties.
     * </pre>
     */
    public void deleteRollupPropertySourceLink(
        com.google.analytics.admin.v1alpha.DeleteRollupPropertySourceLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRollupPropertySourceLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a subproperty and a subproperty event filter that applies to the
     * created subproperty.
     * </pre>
     */
    public void createSubproperty(
        com.google.analytics.admin.v1alpha.CreateSubpropertyRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.CreateSubpropertyResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSubpropertyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a subproperty Event Filter.
     * </pre>
     */
    public void createSubpropertyEventFilter(
        com.google.analytics.admin.v1alpha.CreateSubpropertyEventFilterRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.SubpropertyEventFilter>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSubpropertyEventFilterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single subproperty Event Filter.
     * </pre>
     */
    public void getSubpropertyEventFilter(
        com.google.analytics.admin.v1alpha.GetSubpropertyEventFilterRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.SubpropertyEventFilter>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSubpropertyEventFilterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all subproperty Event Filters on a property.
     * </pre>
     */
    public void listSubpropertyEventFilters(
        com.google.analytics.admin.v1alpha.ListSubpropertyEventFiltersRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.ListSubpropertyEventFiltersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSubpropertyEventFiltersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a subproperty Event Filter.
     * </pre>
     */
    public void updateSubpropertyEventFilter(
        com.google.analytics.admin.v1alpha.UpdateSubpropertyEventFilterRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.SubpropertyEventFilter>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSubpropertyEventFilterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a subproperty event filter.
     * </pre>
     */
    public void deleteSubpropertyEventFilter(
        com.google.analytics.admin.v1alpha.DeleteSubpropertyEventFilterRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSubpropertyEventFilterMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AnalyticsAdminService.
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
     * AccessBindings) will be permanently purged.
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
     * and all child resources (eg: GoogleAdsLinks, Streams, AccessBindings)
     * will be permanently purged.
     * https://support.google.com/analytics/answer/6154772
     * Returns an error if the target is not found, or is not a GA4 Property.
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
     * or through this API) before MeasurementProtocolSecret resources may be
     * created.
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
     * Looks up a single SKAdNetworkConversionValueSchema.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema
        getSKAdNetworkConversionValueSchema(
            com.google.analytics.admin.v1alpha.GetSKAdNetworkConversionValueSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSKAdNetworkConversionValueSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a SKAdNetworkConversionValueSchema.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema
        createSKAdNetworkConversionValueSchema(
            com.google.analytics.admin.v1alpha.CreateSKAdNetworkConversionValueSchemaRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getCreateSKAdNetworkConversionValueSchemaMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes target SKAdNetworkConversionValueSchema.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSKAdNetworkConversionValueSchema(
        com.google.analytics.admin.v1alpha.DeleteSKAdNetworkConversionValueSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getDeleteSKAdNetworkConversionValueSchemaMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Updates a SKAdNetworkConversionValueSchema.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema
        updateSKAdNetworkConversionValueSchema(
            com.google.analytics.admin.v1alpha.UpdateSKAdNetworkConversionValueSchemaRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getUpdateSKAdNetworkConversionValueSchemaMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists SKAdNetworkConversionValueSchema on a stream.
     * Properties can have at most one SKAdNetworkConversionValueSchema.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListSKAdNetworkConversionValueSchemasResponse
        listSKAdNetworkConversionValueSchemas(
            com.google.analytics.admin.v1alpha.ListSKAdNetworkConversionValueSchemasRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getListSKAdNetworkConversionValueSchemasMethod(),
          getCallOptions(),
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
     * Updates a conversion event with the specified attributes.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ConversionEvent updateConversionEvent(
        com.google.analytics.admin.v1alpha.UpdateConversionEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateConversionEventMethod(), getCallOptions(), request);
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
     * Default audiences will not show filter definitions.
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
     * Default audiences will not show filter definitions.
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
     * Look up a single SearchAds360Link
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.SearchAds360Link getSearchAds360Link(
        com.google.analytics.admin.v1alpha.GetSearchAds360LinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSearchAds360LinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all SearchAds360Links on a property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListSearchAds360LinksResponse listSearchAds360Links(
        com.google.analytics.admin.v1alpha.ListSearchAds360LinksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSearchAds360LinksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a SearchAds360Link.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.SearchAds360Link createSearchAds360Link(
        com.google.analytics.admin.v1alpha.CreateSearchAds360LinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSearchAds360LinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a SearchAds360Link on a property.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSearchAds360Link(
        com.google.analytics.admin.v1alpha.DeleteSearchAds360LinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSearchAds360LinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a SearchAds360Link on a property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.SearchAds360Link updateSearchAds360Link(
        com.google.analytics.admin.v1alpha.UpdateSearchAds360LinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSearchAds360LinkMethod(), getCallOptions(), request);
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
     * Data Access Reports can be requested for a property. Reports may be
     * requested for any property, but dimensions that aren't related to quota can
     * only be requested on Google Analytics 360 properties. This method is only
     * available to Administrators.
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

    /**
     *
     *
     * <pre>
     * Creates an access binding on an account or property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.AccessBinding createAccessBinding(
        com.google.analytics.admin.v1alpha.CreateAccessBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAccessBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about an access binding.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.AccessBinding getAccessBinding(
        com.google.analytics.admin.v1alpha.GetAccessBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAccessBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an access binding on an account or property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.AccessBinding updateAccessBinding(
        com.google.analytics.admin.v1alpha.UpdateAccessBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAccessBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an access binding on an account or property.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAccessBinding(
        com.google.analytics.admin.v1alpha.DeleteAccessBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAccessBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all access bindings on an account or property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListAccessBindingsResponse listAccessBindings(
        com.google.analytics.admin.v1alpha.ListAccessBindingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAccessBindingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates information about multiple access bindings to an account or
     * property.
     * This method is transactional. If any AccessBinding cannot be created, none
     * of the AccessBindings will be created.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.BatchCreateAccessBindingsResponse
        batchCreateAccessBindings(
            com.google.analytics.admin.v1alpha.BatchCreateAccessBindingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchCreateAccessBindingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about multiple access bindings to an account or property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.BatchGetAccessBindingsResponse batchGetAccessBindings(
        com.google.analytics.admin.v1alpha.BatchGetAccessBindingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchGetAccessBindingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates information about multiple access bindings to an account or
     * property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.BatchUpdateAccessBindingsResponse
        batchUpdateAccessBindings(
            com.google.analytics.admin.v1alpha.BatchUpdateAccessBindingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchUpdateAccessBindingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes information about multiple users' links to an account or property.
     * </pre>
     */
    public com.google.protobuf.Empty batchDeleteAccessBindings(
        com.google.analytics.admin.v1alpha.BatchDeleteAccessBindingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchDeleteAccessBindingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single ExpandedDataSet.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ExpandedDataSet getExpandedDataSet(
        com.google.analytics.admin.v1alpha.GetExpandedDataSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetExpandedDataSetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ExpandedDataSets on a property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListExpandedDataSetsResponse listExpandedDataSets(
        com.google.analytics.admin.v1alpha.ListExpandedDataSetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListExpandedDataSetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a ExpandedDataSet.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ExpandedDataSet createExpandedDataSet(
        com.google.analytics.admin.v1alpha.CreateExpandedDataSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateExpandedDataSetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a ExpandedDataSet on a property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ExpandedDataSet updateExpandedDataSet(
        com.google.analytics.admin.v1alpha.UpdateExpandedDataSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateExpandedDataSetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ExpandedDataSet on a property.
     * </pre>
     */
    public com.google.protobuf.Empty deleteExpandedDataSet(
        com.google.analytics.admin.v1alpha.DeleteExpandedDataSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteExpandedDataSetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single ChannelGroup.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ChannelGroup getChannelGroup(
        com.google.analytics.admin.v1alpha.GetChannelGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetChannelGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ChannelGroups on a property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListChannelGroupsResponse listChannelGroups(
        com.google.analytics.admin.v1alpha.ListChannelGroupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListChannelGroupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a ChannelGroup.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ChannelGroup createChannelGroup(
        com.google.analytics.admin.v1alpha.CreateChannelGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateChannelGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a ChannelGroup.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ChannelGroup updateChannelGroup(
        com.google.analytics.admin.v1alpha.UpdateChannelGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateChannelGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ChannelGroup on a property.
     * </pre>
     */
    public com.google.protobuf.Empty deleteChannelGroup(
        com.google.analytics.admin.v1alpha.DeleteChannelGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteChannelGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the opt out status for the automated GA4 setup process for a UA
     * property.
     * Note: this has no effect on GA4 property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.SetAutomatedGa4ConfigurationOptOutResponse
        setAutomatedGa4ConfigurationOptOut(
            com.google.analytics.admin.v1alpha.SetAutomatedGa4ConfigurationOptOutRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetAutomatedGa4ConfigurationOptOutMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches the opt out status for the automated GA4 setup process for a UA
     * property.
     * Note: this has no effect on GA4 property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.FetchAutomatedGa4ConfigurationOptOutResponse
        fetchAutomatedGa4ConfigurationOptOut(
            com.google.analytics.admin.v1alpha.FetchAutomatedGa4ConfigurationOptOutRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchAutomatedGa4ConfigurationOptOutMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single BigQuery Link.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.BigQueryLink getBigQueryLink(
        com.google.analytics.admin.v1alpha.GetBigQueryLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBigQueryLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists BigQuery Links on a property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListBigQueryLinksResponse listBigQueryLinks(
        com.google.analytics.admin.v1alpha.ListBigQueryLinksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBigQueryLinksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the enhanced measurement settings for this data stream.
     * Note that the stream must enable enhanced measurement for these settings to
     * take effect.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings
        getEnhancedMeasurementSettings(
            com.google.analytics.admin.v1alpha.GetEnhancedMeasurementSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEnhancedMeasurementSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the enhanced measurement settings for this data stream.
     * Note that the stream must enable enhanced measurement for these settings to
     * take effect.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings
        updateEnhancedMeasurementSettings(
            com.google.analytics.admin.v1alpha.UpdateEnhancedMeasurementSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEnhancedMeasurementSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a connected site tag for a Universal Analytics property. You can
     * create a maximum of 20 connected site tags per property.
     * Note: This API cannot be used on GA4 properties.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.CreateConnectedSiteTagResponse createConnectedSiteTag(
        com.google.analytics.admin.v1alpha.CreateConnectedSiteTagRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateConnectedSiteTagMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a connected site tag for a Universal Analytics property.
     * Note: this has no effect on GA4 properties.
     * </pre>
     */
    public com.google.protobuf.Empty deleteConnectedSiteTag(
        com.google.analytics.admin.v1alpha.DeleteConnectedSiteTagRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteConnectedSiteTagMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the connected site tags for a Universal Analytics property. A maximum
     * of 20 connected site tags will be returned. Note: this has no effect on GA4
     * property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListConnectedSiteTagsResponse listConnectedSiteTags(
        com.google.analytics.admin.v1alpha.ListConnectedSiteTagsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConnectedSiteTagsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Given a specified UA property, looks up the GA4 property connected to it.
     * Note: this cannot be used with GA4 properties.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.FetchConnectedGa4PropertyResponse
        fetchConnectedGa4Property(
            com.google.analytics.admin.v1alpha.FetchConnectedGa4PropertyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchConnectedGa4PropertyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Looks up a single AdSenseLink.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.AdSenseLink getAdSenseLink(
        com.google.analytics.admin.v1alpha.GetAdSenseLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAdSenseLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an AdSenseLink.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.AdSenseLink createAdSenseLink(
        com.google.analytics.admin.v1alpha.CreateAdSenseLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAdSenseLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an AdSenseLink.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAdSenseLink(
        com.google.analytics.admin.v1alpha.DeleteAdSenseLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAdSenseLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists AdSenseLinks on a property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListAdSenseLinksResponse listAdSenseLinks(
        com.google.analytics.admin.v1alpha.ListAdSenseLinksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAdSenseLinksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single EventCreateRule.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.EventCreateRule getEventCreateRule(
        com.google.analytics.admin.v1alpha.GetEventCreateRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEventCreateRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists EventCreateRules on a web data stream.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListEventCreateRulesResponse listEventCreateRules(
        com.google.analytics.admin.v1alpha.ListEventCreateRulesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEventCreateRulesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an EventCreateRule.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.EventCreateRule createEventCreateRule(
        com.google.analytics.admin.v1alpha.CreateEventCreateRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEventCreateRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an EventCreateRule.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.EventCreateRule updateEventCreateRule(
        com.google.analytics.admin.v1alpha.UpdateEventCreateRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEventCreateRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an EventCreateRule.
     * </pre>
     */
    public com.google.protobuf.Empty deleteEventCreateRule(
        com.google.analytics.admin.v1alpha.DeleteEventCreateRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEventCreateRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a DataRedactionSettings on a property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.DataRedactionSettings updateDataRedactionSettings(
        com.google.analytics.admin.v1alpha.UpdateDataRedactionSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDataRedactionSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single DataRedactionSettings.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.DataRedactionSettings getDataRedactionSettings(
        com.google.analytics.admin.v1alpha.GetDataRedactionSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataRedactionSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single CalculatedMetric.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.CalculatedMetric getCalculatedMetric(
        com.google.analytics.admin.v1alpha.GetCalculatedMetricRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCalculatedMetricMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a CalculatedMetric.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.CalculatedMetric createCalculatedMetric(
        com.google.analytics.admin.v1alpha.CreateCalculatedMetricRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCalculatedMetricMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists CalculatedMetrics on a property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListCalculatedMetricsResponse listCalculatedMetrics(
        com.google.analytics.admin.v1alpha.ListCalculatedMetricsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCalculatedMetricsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a CalculatedMetric on a property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.CalculatedMetric updateCalculatedMetric(
        com.google.analytics.admin.v1alpha.UpdateCalculatedMetricRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCalculatedMetricMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a CalculatedMetric on a property.
     * </pre>
     */
    public com.google.protobuf.Empty deleteCalculatedMetric(
        com.google.analytics.admin.v1alpha.DeleteCalculatedMetricRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCalculatedMetricMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a roll-up property and all roll-up property source links.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.CreateRollupPropertyResponse createRollupProperty(
        com.google.analytics.admin.v1alpha.CreateRollupPropertyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRollupPropertyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single roll-up property source Link.
     * Only roll-up properties can have source links, so this method will throw an
     * error if used on other types of properties.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.RollupPropertySourceLink getRollupPropertySourceLink(
        com.google.analytics.admin.v1alpha.GetRollupPropertySourceLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRollupPropertySourceLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists roll-up property source Links on a property.
     * Only roll-up properties can have source links, so this method will throw an
     * error if used on other types of properties.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListRollupPropertySourceLinksResponse
        listRollupPropertySourceLinks(
            com.google.analytics.admin.v1alpha.ListRollupPropertySourceLinksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRollupPropertySourceLinksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a roll-up property source link.
     * Only roll-up properties can have source links, so this method will throw an
     * error if used on other types of properties.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.RollupPropertySourceLink
        createRollupPropertySourceLink(
            com.google.analytics.admin.v1alpha.CreateRollupPropertySourceLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRollupPropertySourceLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a roll-up property source link.
     * Only roll-up properties can have source links, so this method will throw an
     * error if used on other types of properties.
     * </pre>
     */
    public com.google.protobuf.Empty deleteRollupPropertySourceLink(
        com.google.analytics.admin.v1alpha.DeleteRollupPropertySourceLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRollupPropertySourceLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a subproperty and a subproperty event filter that applies to the
     * created subproperty.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.CreateSubpropertyResponse createSubproperty(
        com.google.analytics.admin.v1alpha.CreateSubpropertyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSubpropertyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a subproperty Event Filter.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.SubpropertyEventFilter createSubpropertyEventFilter(
        com.google.analytics.admin.v1alpha.CreateSubpropertyEventFilterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSubpropertyEventFilterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single subproperty Event Filter.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.SubpropertyEventFilter getSubpropertyEventFilter(
        com.google.analytics.admin.v1alpha.GetSubpropertyEventFilterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSubpropertyEventFilterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all subproperty Event Filters on a property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListSubpropertyEventFiltersResponse
        listSubpropertyEventFilters(
            com.google.analytics.admin.v1alpha.ListSubpropertyEventFiltersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSubpropertyEventFiltersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a subproperty Event Filter.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.SubpropertyEventFilter updateSubpropertyEventFilter(
        com.google.analytics.admin.v1alpha.UpdateSubpropertyEventFilterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSubpropertyEventFilterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a subproperty event filter.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSubpropertyEventFilter(
        com.google.analytics.admin.v1alpha.DeleteSubpropertyEventFilterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSubpropertyEventFilterMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * AnalyticsAdminService.
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
     * AccessBindings) will be permanently purged.
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
     * and all child resources (eg: GoogleAdsLinks, Streams, AccessBindings)
     * will be permanently purged.
     * https://support.google.com/analytics/answer/6154772
     * Returns an error if the target is not found, or is not a GA4 Property.
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
     * or through this API) before MeasurementProtocolSecret resources may be
     * created.
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
     * Looks up a single SKAdNetworkConversionValueSchema.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema>
        getSKAdNetworkConversionValueSchema(
            com.google.analytics.admin.v1alpha.GetSKAdNetworkConversionValueSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSKAdNetworkConversionValueSchemaMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Creates a SKAdNetworkConversionValueSchema.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema>
        createSKAdNetworkConversionValueSchema(
            com.google.analytics.admin.v1alpha.CreateSKAdNetworkConversionValueSchemaRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSKAdNetworkConversionValueSchemaMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes target SKAdNetworkConversionValueSchema.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteSKAdNetworkConversionValueSchema(
            com.google.analytics.admin.v1alpha.DeleteSKAdNetworkConversionValueSchemaRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSKAdNetworkConversionValueSchemaMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Updates a SKAdNetworkConversionValueSchema.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema>
        updateSKAdNetworkConversionValueSchema(
            com.google.analytics.admin.v1alpha.UpdateSKAdNetworkConversionValueSchemaRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSKAdNetworkConversionValueSchemaMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists SKAdNetworkConversionValueSchema on a stream.
     * Properties can have at most one SKAdNetworkConversionValueSchema.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListSKAdNetworkConversionValueSchemasResponse>
        listSKAdNetworkConversionValueSchemas(
            com.google.analytics.admin.v1alpha.ListSKAdNetworkConversionValueSchemasRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSKAdNetworkConversionValueSchemasMethod(), getCallOptions()),
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
     * Updates a conversion event with the specified attributes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ConversionEvent>
        updateConversionEvent(
            com.google.analytics.admin.v1alpha.UpdateConversionEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateConversionEventMethod(), getCallOptions()), request);
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
     * Default audiences will not show filter definitions.
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
     * Default audiences will not show filter definitions.
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
     * Look up a single SearchAds360Link
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.SearchAds360Link>
        getSearchAds360Link(com.google.analytics.admin.v1alpha.GetSearchAds360LinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSearchAds360LinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all SearchAds360Links on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListSearchAds360LinksResponse>
        listSearchAds360Links(
            com.google.analytics.admin.v1alpha.ListSearchAds360LinksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSearchAds360LinksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a SearchAds360Link.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.SearchAds360Link>
        createSearchAds360Link(
            com.google.analytics.admin.v1alpha.CreateSearchAds360LinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSearchAds360LinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a SearchAds360Link on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteSearchAds360Link(
            com.google.analytics.admin.v1alpha.DeleteSearchAds360LinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSearchAds360LinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a SearchAds360Link on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.SearchAds360Link>
        updateSearchAds360Link(
            com.google.analytics.admin.v1alpha.UpdateSearchAds360LinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSearchAds360LinkMethod(), getCallOptions()), request);
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
     * Data Access Reports can be requested for a property. Reports may be
     * requested for any property, but dimensions that aren't related to quota can
     * only be requested on Google Analytics 360 properties. This method is only
     * available to Administrators.
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

    /**
     *
     *
     * <pre>
     * Creates an access binding on an account or property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.AccessBinding>
        createAccessBinding(com.google.analytics.admin.v1alpha.CreateAccessBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAccessBindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about an access binding.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.AccessBinding>
        getAccessBinding(com.google.analytics.admin.v1alpha.GetAccessBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAccessBindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an access binding on an account or property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.AccessBinding>
        updateAccessBinding(com.google.analytics.admin.v1alpha.UpdateAccessBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAccessBindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an access binding on an account or property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteAccessBinding(com.google.analytics.admin.v1alpha.DeleteAccessBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAccessBindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all access bindings on an account or property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListAccessBindingsResponse>
        listAccessBindings(com.google.analytics.admin.v1alpha.ListAccessBindingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAccessBindingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates information about multiple access bindings to an account or
     * property.
     * This method is transactional. If any AccessBinding cannot be created, none
     * of the AccessBindings will be created.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.BatchCreateAccessBindingsResponse>
        batchCreateAccessBindings(
            com.google.analytics.admin.v1alpha.BatchCreateAccessBindingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchCreateAccessBindingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about multiple access bindings to an account or property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.BatchGetAccessBindingsResponse>
        batchGetAccessBindings(
            com.google.analytics.admin.v1alpha.BatchGetAccessBindingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchGetAccessBindingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates information about multiple access bindings to an account or
     * property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.BatchUpdateAccessBindingsResponse>
        batchUpdateAccessBindings(
            com.google.analytics.admin.v1alpha.BatchUpdateAccessBindingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchUpdateAccessBindingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes information about multiple users' links to an account or property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        batchDeleteAccessBindings(
            com.google.analytics.admin.v1alpha.BatchDeleteAccessBindingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchDeleteAccessBindingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single ExpandedDataSet.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ExpandedDataSet>
        getExpandedDataSet(com.google.analytics.admin.v1alpha.GetExpandedDataSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetExpandedDataSetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ExpandedDataSets on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListExpandedDataSetsResponse>
        listExpandedDataSets(
            com.google.analytics.admin.v1alpha.ListExpandedDataSetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListExpandedDataSetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a ExpandedDataSet.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ExpandedDataSet>
        createExpandedDataSet(
            com.google.analytics.admin.v1alpha.CreateExpandedDataSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateExpandedDataSetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a ExpandedDataSet on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ExpandedDataSet>
        updateExpandedDataSet(
            com.google.analytics.admin.v1alpha.UpdateExpandedDataSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateExpandedDataSetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ExpandedDataSet on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteExpandedDataSet(
            com.google.analytics.admin.v1alpha.DeleteExpandedDataSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteExpandedDataSetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single ChannelGroup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ChannelGroup>
        getChannelGroup(com.google.analytics.admin.v1alpha.GetChannelGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetChannelGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ChannelGroups on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListChannelGroupsResponse>
        listChannelGroups(com.google.analytics.admin.v1alpha.ListChannelGroupsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListChannelGroupsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a ChannelGroup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ChannelGroup>
        createChannelGroup(com.google.analytics.admin.v1alpha.CreateChannelGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateChannelGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a ChannelGroup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ChannelGroup>
        updateChannelGroup(com.google.analytics.admin.v1alpha.UpdateChannelGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateChannelGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ChannelGroup on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteChannelGroup(com.google.analytics.admin.v1alpha.DeleteChannelGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteChannelGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the opt out status for the automated GA4 setup process for a UA
     * property.
     * Note: this has no effect on GA4 property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.SetAutomatedGa4ConfigurationOptOutResponse>
        setAutomatedGa4ConfigurationOptOut(
            com.google.analytics.admin.v1alpha.SetAutomatedGa4ConfigurationOptOutRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetAutomatedGa4ConfigurationOptOutMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Fetches the opt out status for the automated GA4 setup process for a UA
     * property.
     * Note: this has no effect on GA4 property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.FetchAutomatedGa4ConfigurationOptOutResponse>
        fetchAutomatedGa4ConfigurationOptOut(
            com.google.analytics.admin.v1alpha.FetchAutomatedGa4ConfigurationOptOutRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchAutomatedGa4ConfigurationOptOutMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single BigQuery Link.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.BigQueryLink>
        getBigQueryLink(com.google.analytics.admin.v1alpha.GetBigQueryLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBigQueryLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists BigQuery Links on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListBigQueryLinksResponse>
        listBigQueryLinks(com.google.analytics.admin.v1alpha.ListBigQueryLinksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBigQueryLinksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the enhanced measurement settings for this data stream.
     * Note that the stream must enable enhanced measurement for these settings to
     * take effect.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>
        getEnhancedMeasurementSettings(
            com.google.analytics.admin.v1alpha.GetEnhancedMeasurementSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEnhancedMeasurementSettingsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Updates the enhanced measurement settings for this data stream.
     * Note that the stream must enable enhanced measurement for these settings to
     * take effect.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>
        updateEnhancedMeasurementSettings(
            com.google.analytics.admin.v1alpha.UpdateEnhancedMeasurementSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEnhancedMeasurementSettingsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Creates a connected site tag for a Universal Analytics property. You can
     * create a maximum of 20 connected site tags per property.
     * Note: This API cannot be used on GA4 properties.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.CreateConnectedSiteTagResponse>
        createConnectedSiteTag(
            com.google.analytics.admin.v1alpha.CreateConnectedSiteTagRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateConnectedSiteTagMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a connected site tag for a Universal Analytics property.
     * Note: this has no effect on GA4 properties.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteConnectedSiteTag(
            com.google.analytics.admin.v1alpha.DeleteConnectedSiteTagRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteConnectedSiteTagMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the connected site tags for a Universal Analytics property. A maximum
     * of 20 connected site tags will be returned. Note: this has no effect on GA4
     * property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListConnectedSiteTagsResponse>
        listConnectedSiteTags(
            com.google.analytics.admin.v1alpha.ListConnectedSiteTagsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListConnectedSiteTagsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Given a specified UA property, looks up the GA4 property connected to it.
     * Note: this cannot be used with GA4 properties.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.FetchConnectedGa4PropertyResponse>
        fetchConnectedGa4Property(
            com.google.analytics.admin.v1alpha.FetchConnectedGa4PropertyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchConnectedGa4PropertyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Looks up a single AdSenseLink.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.AdSenseLink>
        getAdSenseLink(com.google.analytics.admin.v1alpha.GetAdSenseLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAdSenseLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an AdSenseLink.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.AdSenseLink>
        createAdSenseLink(com.google.analytics.admin.v1alpha.CreateAdSenseLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAdSenseLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an AdSenseLink.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteAdSenseLink(com.google.analytics.admin.v1alpha.DeleteAdSenseLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAdSenseLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists AdSenseLinks on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListAdSenseLinksResponse>
        listAdSenseLinks(com.google.analytics.admin.v1alpha.ListAdSenseLinksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAdSenseLinksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single EventCreateRule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.EventCreateRule>
        getEventCreateRule(com.google.analytics.admin.v1alpha.GetEventCreateRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEventCreateRuleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists EventCreateRules on a web data stream.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListEventCreateRulesResponse>
        listEventCreateRules(
            com.google.analytics.admin.v1alpha.ListEventCreateRulesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEventCreateRulesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an EventCreateRule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.EventCreateRule>
        createEventCreateRule(
            com.google.analytics.admin.v1alpha.CreateEventCreateRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEventCreateRuleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an EventCreateRule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.EventCreateRule>
        updateEventCreateRule(
            com.google.analytics.admin.v1alpha.UpdateEventCreateRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEventCreateRuleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an EventCreateRule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteEventCreateRule(
            com.google.analytics.admin.v1alpha.DeleteEventCreateRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEventCreateRuleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a DataRedactionSettings on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.DataRedactionSettings>
        updateDataRedactionSettings(
            com.google.analytics.admin.v1alpha.UpdateDataRedactionSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDataRedactionSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single DataRedactionSettings.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.DataRedactionSettings>
        getDataRedactionSettings(
            com.google.analytics.admin.v1alpha.GetDataRedactionSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataRedactionSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single CalculatedMetric.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.CalculatedMetric>
        getCalculatedMetric(com.google.analytics.admin.v1alpha.GetCalculatedMetricRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCalculatedMetricMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a CalculatedMetric.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.CalculatedMetric>
        createCalculatedMetric(
            com.google.analytics.admin.v1alpha.CreateCalculatedMetricRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCalculatedMetricMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists CalculatedMetrics on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListCalculatedMetricsResponse>
        listCalculatedMetrics(
            com.google.analytics.admin.v1alpha.ListCalculatedMetricsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCalculatedMetricsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a CalculatedMetric on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.CalculatedMetric>
        updateCalculatedMetric(
            com.google.analytics.admin.v1alpha.UpdateCalculatedMetricRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCalculatedMetricMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a CalculatedMetric on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteCalculatedMetric(
            com.google.analytics.admin.v1alpha.DeleteCalculatedMetricRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCalculatedMetricMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a roll-up property and all roll-up property source links.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.CreateRollupPropertyResponse>
        createRollupProperty(
            com.google.analytics.admin.v1alpha.CreateRollupPropertyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRollupPropertyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single roll-up property source Link.
     * Only roll-up properties can have source links, so this method will throw an
     * error if used on other types of properties.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.RollupPropertySourceLink>
        getRollupPropertySourceLink(
            com.google.analytics.admin.v1alpha.GetRollupPropertySourceLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRollupPropertySourceLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists roll-up property source Links on a property.
     * Only roll-up properties can have source links, so this method will throw an
     * error if used on other types of properties.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListRollupPropertySourceLinksResponse>
        listRollupPropertySourceLinks(
            com.google.analytics.admin.v1alpha.ListRollupPropertySourceLinksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRollupPropertySourceLinksMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Creates a roll-up property source link.
     * Only roll-up properties can have source links, so this method will throw an
     * error if used on other types of properties.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.RollupPropertySourceLink>
        createRollupPropertySourceLink(
            com.google.analytics.admin.v1alpha.CreateRollupPropertySourceLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRollupPropertySourceLinkMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a roll-up property source link.
     * Only roll-up properties can have source links, so this method will throw an
     * error if used on other types of properties.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteRollupPropertySourceLink(
            com.google.analytics.admin.v1alpha.DeleteRollupPropertySourceLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRollupPropertySourceLinkMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Create a subproperty and a subproperty event filter that applies to the
     * created subproperty.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.CreateSubpropertyResponse>
        createSubproperty(com.google.analytics.admin.v1alpha.CreateSubpropertyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSubpropertyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a subproperty Event Filter.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.SubpropertyEventFilter>
        createSubpropertyEventFilter(
            com.google.analytics.admin.v1alpha.CreateSubpropertyEventFilterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSubpropertyEventFilterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single subproperty Event Filter.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.SubpropertyEventFilter>
        getSubpropertyEventFilter(
            com.google.analytics.admin.v1alpha.GetSubpropertyEventFilterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSubpropertyEventFilterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List all subproperty Event Filters on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListSubpropertyEventFiltersResponse>
        listSubpropertyEventFilters(
            com.google.analytics.admin.v1alpha.ListSubpropertyEventFiltersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSubpropertyEventFiltersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a subproperty Event Filter.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.SubpropertyEventFilter>
        updateSubpropertyEventFilter(
            com.google.analytics.admin.v1alpha.UpdateSubpropertyEventFilterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSubpropertyEventFilterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a subproperty event filter.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteSubpropertyEventFilter(
            com.google.analytics.admin.v1alpha.DeleteSubpropertyEventFilterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSubpropertyEventFilterMethod(), getCallOptions()), request);
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
  private static final int METHODID_CREATE_FIREBASE_LINK = 11;
  private static final int METHODID_DELETE_FIREBASE_LINK = 12;
  private static final int METHODID_LIST_FIREBASE_LINKS = 13;
  private static final int METHODID_GET_GLOBAL_SITE_TAG = 14;
  private static final int METHODID_CREATE_GOOGLE_ADS_LINK = 15;
  private static final int METHODID_UPDATE_GOOGLE_ADS_LINK = 16;
  private static final int METHODID_DELETE_GOOGLE_ADS_LINK = 17;
  private static final int METHODID_LIST_GOOGLE_ADS_LINKS = 18;
  private static final int METHODID_GET_DATA_SHARING_SETTINGS = 19;
  private static final int METHODID_GET_MEASUREMENT_PROTOCOL_SECRET = 20;
  private static final int METHODID_LIST_MEASUREMENT_PROTOCOL_SECRETS = 21;
  private static final int METHODID_CREATE_MEASUREMENT_PROTOCOL_SECRET = 22;
  private static final int METHODID_DELETE_MEASUREMENT_PROTOCOL_SECRET = 23;
  private static final int METHODID_UPDATE_MEASUREMENT_PROTOCOL_SECRET = 24;
  private static final int METHODID_ACKNOWLEDGE_USER_DATA_COLLECTION = 25;
  private static final int METHODID_GET_SKAD_NETWORK_CONVERSION_VALUE_SCHEMA = 26;
  private static final int METHODID_CREATE_SKAD_NETWORK_CONVERSION_VALUE_SCHEMA = 27;
  private static final int METHODID_DELETE_SKAD_NETWORK_CONVERSION_VALUE_SCHEMA = 28;
  private static final int METHODID_UPDATE_SKAD_NETWORK_CONVERSION_VALUE_SCHEMA = 29;
  private static final int METHODID_LIST_SKAD_NETWORK_CONVERSION_VALUE_SCHEMAS = 30;
  private static final int METHODID_SEARCH_CHANGE_HISTORY_EVENTS = 31;
  private static final int METHODID_GET_GOOGLE_SIGNALS_SETTINGS = 32;
  private static final int METHODID_UPDATE_GOOGLE_SIGNALS_SETTINGS = 33;
  private static final int METHODID_CREATE_CONVERSION_EVENT = 34;
  private static final int METHODID_UPDATE_CONVERSION_EVENT = 35;
  private static final int METHODID_GET_CONVERSION_EVENT = 36;
  private static final int METHODID_DELETE_CONVERSION_EVENT = 37;
  private static final int METHODID_LIST_CONVERSION_EVENTS = 38;
  private static final int METHODID_GET_DISPLAY_VIDEO360ADVERTISER_LINK = 39;
  private static final int METHODID_LIST_DISPLAY_VIDEO360ADVERTISER_LINKS = 40;
  private static final int METHODID_CREATE_DISPLAY_VIDEO360ADVERTISER_LINK = 41;
  private static final int METHODID_DELETE_DISPLAY_VIDEO360ADVERTISER_LINK = 42;
  private static final int METHODID_UPDATE_DISPLAY_VIDEO360ADVERTISER_LINK = 43;
  private static final int METHODID_GET_DISPLAY_VIDEO360ADVERTISER_LINK_PROPOSAL = 44;
  private static final int METHODID_LIST_DISPLAY_VIDEO360ADVERTISER_LINK_PROPOSALS = 45;
  private static final int METHODID_CREATE_DISPLAY_VIDEO360ADVERTISER_LINK_PROPOSAL = 46;
  private static final int METHODID_DELETE_DISPLAY_VIDEO360ADVERTISER_LINK_PROPOSAL = 47;
  private static final int METHODID_APPROVE_DISPLAY_VIDEO360ADVERTISER_LINK_PROPOSAL = 48;
  private static final int METHODID_CANCEL_DISPLAY_VIDEO360ADVERTISER_LINK_PROPOSAL = 49;
  private static final int METHODID_CREATE_CUSTOM_DIMENSION = 50;
  private static final int METHODID_UPDATE_CUSTOM_DIMENSION = 51;
  private static final int METHODID_LIST_CUSTOM_DIMENSIONS = 52;
  private static final int METHODID_ARCHIVE_CUSTOM_DIMENSION = 53;
  private static final int METHODID_GET_CUSTOM_DIMENSION = 54;
  private static final int METHODID_CREATE_CUSTOM_METRIC = 55;
  private static final int METHODID_UPDATE_CUSTOM_METRIC = 56;
  private static final int METHODID_LIST_CUSTOM_METRICS = 57;
  private static final int METHODID_ARCHIVE_CUSTOM_METRIC = 58;
  private static final int METHODID_GET_CUSTOM_METRIC = 59;
  private static final int METHODID_GET_DATA_RETENTION_SETTINGS = 60;
  private static final int METHODID_UPDATE_DATA_RETENTION_SETTINGS = 61;
  private static final int METHODID_CREATE_DATA_STREAM = 62;
  private static final int METHODID_DELETE_DATA_STREAM = 63;
  private static final int METHODID_UPDATE_DATA_STREAM = 64;
  private static final int METHODID_LIST_DATA_STREAMS = 65;
  private static final int METHODID_GET_DATA_STREAM = 66;
  private static final int METHODID_GET_AUDIENCE = 67;
  private static final int METHODID_LIST_AUDIENCES = 68;
  private static final int METHODID_CREATE_AUDIENCE = 69;
  private static final int METHODID_UPDATE_AUDIENCE = 70;
  private static final int METHODID_ARCHIVE_AUDIENCE = 71;
  private static final int METHODID_GET_SEARCH_ADS360LINK = 72;
  private static final int METHODID_LIST_SEARCH_ADS360LINKS = 73;
  private static final int METHODID_CREATE_SEARCH_ADS360LINK = 74;
  private static final int METHODID_DELETE_SEARCH_ADS360LINK = 75;
  private static final int METHODID_UPDATE_SEARCH_ADS360LINK = 76;
  private static final int METHODID_GET_ATTRIBUTION_SETTINGS = 77;
  private static final int METHODID_UPDATE_ATTRIBUTION_SETTINGS = 78;
  private static final int METHODID_RUN_ACCESS_REPORT = 79;
  private static final int METHODID_CREATE_ACCESS_BINDING = 80;
  private static final int METHODID_GET_ACCESS_BINDING = 81;
  private static final int METHODID_UPDATE_ACCESS_BINDING = 82;
  private static final int METHODID_DELETE_ACCESS_BINDING = 83;
  private static final int METHODID_LIST_ACCESS_BINDINGS = 84;
  private static final int METHODID_BATCH_CREATE_ACCESS_BINDINGS = 85;
  private static final int METHODID_BATCH_GET_ACCESS_BINDINGS = 86;
  private static final int METHODID_BATCH_UPDATE_ACCESS_BINDINGS = 87;
  private static final int METHODID_BATCH_DELETE_ACCESS_BINDINGS = 88;
  private static final int METHODID_GET_EXPANDED_DATA_SET = 89;
  private static final int METHODID_LIST_EXPANDED_DATA_SETS = 90;
  private static final int METHODID_CREATE_EXPANDED_DATA_SET = 91;
  private static final int METHODID_UPDATE_EXPANDED_DATA_SET = 92;
  private static final int METHODID_DELETE_EXPANDED_DATA_SET = 93;
  private static final int METHODID_GET_CHANNEL_GROUP = 94;
  private static final int METHODID_LIST_CHANNEL_GROUPS = 95;
  private static final int METHODID_CREATE_CHANNEL_GROUP = 96;
  private static final int METHODID_UPDATE_CHANNEL_GROUP = 97;
  private static final int METHODID_DELETE_CHANNEL_GROUP = 98;
  private static final int METHODID_SET_AUTOMATED_GA4CONFIGURATION_OPT_OUT = 99;
  private static final int METHODID_FETCH_AUTOMATED_GA4CONFIGURATION_OPT_OUT = 100;
  private static final int METHODID_GET_BIG_QUERY_LINK = 101;
  private static final int METHODID_LIST_BIG_QUERY_LINKS = 102;
  private static final int METHODID_GET_ENHANCED_MEASUREMENT_SETTINGS = 103;
  private static final int METHODID_UPDATE_ENHANCED_MEASUREMENT_SETTINGS = 104;
  private static final int METHODID_CREATE_CONNECTED_SITE_TAG = 105;
  private static final int METHODID_DELETE_CONNECTED_SITE_TAG = 106;
  private static final int METHODID_LIST_CONNECTED_SITE_TAGS = 107;
  private static final int METHODID_FETCH_CONNECTED_GA4PROPERTY = 108;
  private static final int METHODID_GET_AD_SENSE_LINK = 109;
  private static final int METHODID_CREATE_AD_SENSE_LINK = 110;
  private static final int METHODID_DELETE_AD_SENSE_LINK = 111;
  private static final int METHODID_LIST_AD_SENSE_LINKS = 112;
  private static final int METHODID_GET_EVENT_CREATE_RULE = 113;
  private static final int METHODID_LIST_EVENT_CREATE_RULES = 114;
  private static final int METHODID_CREATE_EVENT_CREATE_RULE = 115;
  private static final int METHODID_UPDATE_EVENT_CREATE_RULE = 116;
  private static final int METHODID_DELETE_EVENT_CREATE_RULE = 117;
  private static final int METHODID_UPDATE_DATA_REDACTION_SETTINGS = 118;
  private static final int METHODID_GET_DATA_REDACTION_SETTINGS = 119;
  private static final int METHODID_GET_CALCULATED_METRIC = 120;
  private static final int METHODID_CREATE_CALCULATED_METRIC = 121;
  private static final int METHODID_LIST_CALCULATED_METRICS = 122;
  private static final int METHODID_UPDATE_CALCULATED_METRIC = 123;
  private static final int METHODID_DELETE_CALCULATED_METRIC = 124;
  private static final int METHODID_CREATE_ROLLUP_PROPERTY = 125;
  private static final int METHODID_GET_ROLLUP_PROPERTY_SOURCE_LINK = 126;
  private static final int METHODID_LIST_ROLLUP_PROPERTY_SOURCE_LINKS = 127;
  private static final int METHODID_CREATE_ROLLUP_PROPERTY_SOURCE_LINK = 128;
  private static final int METHODID_DELETE_ROLLUP_PROPERTY_SOURCE_LINK = 129;
  private static final int METHODID_CREATE_SUBPROPERTY = 130;
  private static final int METHODID_CREATE_SUBPROPERTY_EVENT_FILTER = 131;
  private static final int METHODID_GET_SUBPROPERTY_EVENT_FILTER = 132;
  private static final int METHODID_LIST_SUBPROPERTY_EVENT_FILTERS = 133;
  private static final int METHODID_UPDATE_SUBPROPERTY_EVENT_FILTER = 134;
  private static final int METHODID_DELETE_SUBPROPERTY_EVENT_FILTER = 135;

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
        case METHODID_GET_SKAD_NETWORK_CONVERSION_VALUE_SCHEMA:
          serviceImpl.getSKAdNetworkConversionValueSchema(
              (com.google.analytics.admin.v1alpha.GetSKAdNetworkConversionValueSchemaRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema>)
                  responseObserver);
          break;
        case METHODID_CREATE_SKAD_NETWORK_CONVERSION_VALUE_SCHEMA:
          serviceImpl.createSKAdNetworkConversionValueSchema(
              (com.google.analytics.admin.v1alpha.CreateSKAdNetworkConversionValueSchemaRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema>)
                  responseObserver);
          break;
        case METHODID_DELETE_SKAD_NETWORK_CONVERSION_VALUE_SCHEMA:
          serviceImpl.deleteSKAdNetworkConversionValueSchema(
              (com.google.analytics.admin.v1alpha.DeleteSKAdNetworkConversionValueSchemaRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_SKAD_NETWORK_CONVERSION_VALUE_SCHEMA:
          serviceImpl.updateSKAdNetworkConversionValueSchema(
              (com.google.analytics.admin.v1alpha.UpdateSKAdNetworkConversionValueSchemaRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema>)
                  responseObserver);
          break;
        case METHODID_LIST_SKAD_NETWORK_CONVERSION_VALUE_SCHEMAS:
          serviceImpl.listSKAdNetworkConversionValueSchemas(
              (com.google.analytics.admin.v1alpha.ListSKAdNetworkConversionValueSchemasRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha
                          .ListSKAdNetworkConversionValueSchemasResponse>)
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
        case METHODID_UPDATE_CONVERSION_EVENT:
          serviceImpl.updateConversionEvent(
              (com.google.analytics.admin.v1alpha.UpdateConversionEventRequest) request,
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
        case METHODID_GET_SEARCH_ADS360LINK:
          serviceImpl.getSearchAds360Link(
              (com.google.analytics.admin.v1alpha.GetSearchAds360LinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.SearchAds360Link>)
                  responseObserver);
          break;
        case METHODID_LIST_SEARCH_ADS360LINKS:
          serviceImpl.listSearchAds360Links(
              (com.google.analytics.admin.v1alpha.ListSearchAds360LinksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.ListSearchAds360LinksResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_SEARCH_ADS360LINK:
          serviceImpl.createSearchAds360Link(
              (com.google.analytics.admin.v1alpha.CreateSearchAds360LinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.SearchAds360Link>)
                  responseObserver);
          break;
        case METHODID_DELETE_SEARCH_ADS360LINK:
          serviceImpl.deleteSearchAds360Link(
              (com.google.analytics.admin.v1alpha.DeleteSearchAds360LinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_SEARCH_ADS360LINK:
          serviceImpl.updateSearchAds360Link(
              (com.google.analytics.admin.v1alpha.UpdateSearchAds360LinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.SearchAds360Link>)
                  responseObserver);
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
        case METHODID_CREATE_ACCESS_BINDING:
          serviceImpl.createAccessBinding(
              (com.google.analytics.admin.v1alpha.CreateAccessBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AccessBinding>)
                  responseObserver);
          break;
        case METHODID_GET_ACCESS_BINDING:
          serviceImpl.getAccessBinding(
              (com.google.analytics.admin.v1alpha.GetAccessBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AccessBinding>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ACCESS_BINDING:
          serviceImpl.updateAccessBinding(
              (com.google.analytics.admin.v1alpha.UpdateAccessBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AccessBinding>)
                  responseObserver);
          break;
        case METHODID_DELETE_ACCESS_BINDING:
          serviceImpl.deleteAccessBinding(
              (com.google.analytics.admin.v1alpha.DeleteAccessBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_ACCESS_BINDINGS:
          serviceImpl.listAccessBindings(
              (com.google.analytics.admin.v1alpha.ListAccessBindingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.ListAccessBindingsResponse>)
                  responseObserver);
          break;
        case METHODID_BATCH_CREATE_ACCESS_BINDINGS:
          serviceImpl.batchCreateAccessBindings(
              (com.google.analytics.admin.v1alpha.BatchCreateAccessBindingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.BatchCreateAccessBindingsResponse>)
                  responseObserver);
          break;
        case METHODID_BATCH_GET_ACCESS_BINDINGS:
          serviceImpl.batchGetAccessBindings(
              (com.google.analytics.admin.v1alpha.BatchGetAccessBindingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.BatchGetAccessBindingsResponse>)
                  responseObserver);
          break;
        case METHODID_BATCH_UPDATE_ACCESS_BINDINGS:
          serviceImpl.batchUpdateAccessBindings(
              (com.google.analytics.admin.v1alpha.BatchUpdateAccessBindingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.BatchUpdateAccessBindingsResponse>)
                  responseObserver);
          break;
        case METHODID_BATCH_DELETE_ACCESS_BINDINGS:
          serviceImpl.batchDeleteAccessBindings(
              (com.google.analytics.admin.v1alpha.BatchDeleteAccessBindingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_EXPANDED_DATA_SET:
          serviceImpl.getExpandedDataSet(
              (com.google.analytics.admin.v1alpha.GetExpandedDataSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ExpandedDataSet>)
                  responseObserver);
          break;
        case METHODID_LIST_EXPANDED_DATA_SETS:
          serviceImpl.listExpandedDataSets(
              (com.google.analytics.admin.v1alpha.ListExpandedDataSetsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.ListExpandedDataSetsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_EXPANDED_DATA_SET:
          serviceImpl.createExpandedDataSet(
              (com.google.analytics.admin.v1alpha.CreateExpandedDataSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ExpandedDataSet>)
                  responseObserver);
          break;
        case METHODID_UPDATE_EXPANDED_DATA_SET:
          serviceImpl.updateExpandedDataSet(
              (com.google.analytics.admin.v1alpha.UpdateExpandedDataSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ExpandedDataSet>)
                  responseObserver);
          break;
        case METHODID_DELETE_EXPANDED_DATA_SET:
          serviceImpl.deleteExpandedDataSet(
              (com.google.analytics.admin.v1alpha.DeleteExpandedDataSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_CHANNEL_GROUP:
          serviceImpl.getChannelGroup(
              (com.google.analytics.admin.v1alpha.GetChannelGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ChannelGroup>)
                  responseObserver);
          break;
        case METHODID_LIST_CHANNEL_GROUPS:
          serviceImpl.listChannelGroups(
              (com.google.analytics.admin.v1alpha.ListChannelGroupsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.ListChannelGroupsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_CHANNEL_GROUP:
          serviceImpl.createChannelGroup(
              (com.google.analytics.admin.v1alpha.CreateChannelGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ChannelGroup>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CHANNEL_GROUP:
          serviceImpl.updateChannelGroup(
              (com.google.analytics.admin.v1alpha.UpdateChannelGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ChannelGroup>)
                  responseObserver);
          break;
        case METHODID_DELETE_CHANNEL_GROUP:
          serviceImpl.deleteChannelGroup(
              (com.google.analytics.admin.v1alpha.DeleteChannelGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_SET_AUTOMATED_GA4CONFIGURATION_OPT_OUT:
          serviceImpl.setAutomatedGa4ConfigurationOptOut(
              (com.google.analytics.admin.v1alpha.SetAutomatedGa4ConfigurationOptOutRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha
                          .SetAutomatedGa4ConfigurationOptOutResponse>)
                  responseObserver);
          break;
        case METHODID_FETCH_AUTOMATED_GA4CONFIGURATION_OPT_OUT:
          serviceImpl.fetchAutomatedGa4ConfigurationOptOut(
              (com.google.analytics.admin.v1alpha.FetchAutomatedGa4ConfigurationOptOutRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha
                          .FetchAutomatedGa4ConfigurationOptOutResponse>)
                  responseObserver);
          break;
        case METHODID_GET_BIG_QUERY_LINK:
          serviceImpl.getBigQueryLink(
              (com.google.analytics.admin.v1alpha.GetBigQueryLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.BigQueryLink>)
                  responseObserver);
          break;
        case METHODID_LIST_BIG_QUERY_LINKS:
          serviceImpl.listBigQueryLinks(
              (com.google.analytics.admin.v1alpha.ListBigQueryLinksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.ListBigQueryLinksResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ENHANCED_MEASUREMENT_SETTINGS:
          serviceImpl.getEnhancedMeasurementSettings(
              (com.google.analytics.admin.v1alpha.GetEnhancedMeasurementSettingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ENHANCED_MEASUREMENT_SETTINGS:
          serviceImpl.updateEnhancedMeasurementSettings(
              (com.google.analytics.admin.v1alpha.UpdateEnhancedMeasurementSettingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>)
                  responseObserver);
          break;
        case METHODID_CREATE_CONNECTED_SITE_TAG:
          serviceImpl.createConnectedSiteTag(
              (com.google.analytics.admin.v1alpha.CreateConnectedSiteTagRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.CreateConnectedSiteTagResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_CONNECTED_SITE_TAG:
          serviceImpl.deleteConnectedSiteTag(
              (com.google.analytics.admin.v1alpha.DeleteConnectedSiteTagRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_CONNECTED_SITE_TAGS:
          serviceImpl.listConnectedSiteTags(
              (com.google.analytics.admin.v1alpha.ListConnectedSiteTagsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.ListConnectedSiteTagsResponse>)
                  responseObserver);
          break;
        case METHODID_FETCH_CONNECTED_GA4PROPERTY:
          serviceImpl.fetchConnectedGa4Property(
              (com.google.analytics.admin.v1alpha.FetchConnectedGa4PropertyRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.FetchConnectedGa4PropertyResponse>)
                  responseObserver);
          break;
        case METHODID_GET_AD_SENSE_LINK:
          serviceImpl.getAdSenseLink(
              (com.google.analytics.admin.v1alpha.GetAdSenseLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AdSenseLink>)
                  responseObserver);
          break;
        case METHODID_CREATE_AD_SENSE_LINK:
          serviceImpl.createAdSenseLink(
              (com.google.analytics.admin.v1alpha.CreateAdSenseLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AdSenseLink>)
                  responseObserver);
          break;
        case METHODID_DELETE_AD_SENSE_LINK:
          serviceImpl.deleteAdSenseLink(
              (com.google.analytics.admin.v1alpha.DeleteAdSenseLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_AD_SENSE_LINKS:
          serviceImpl.listAdSenseLinks(
              (com.google.analytics.admin.v1alpha.ListAdSenseLinksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.ListAdSenseLinksResponse>)
                  responseObserver);
          break;
        case METHODID_GET_EVENT_CREATE_RULE:
          serviceImpl.getEventCreateRule(
              (com.google.analytics.admin.v1alpha.GetEventCreateRuleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.EventCreateRule>)
                  responseObserver);
          break;
        case METHODID_LIST_EVENT_CREATE_RULES:
          serviceImpl.listEventCreateRules(
              (com.google.analytics.admin.v1alpha.ListEventCreateRulesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.ListEventCreateRulesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_EVENT_CREATE_RULE:
          serviceImpl.createEventCreateRule(
              (com.google.analytics.admin.v1alpha.CreateEventCreateRuleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.EventCreateRule>)
                  responseObserver);
          break;
        case METHODID_UPDATE_EVENT_CREATE_RULE:
          serviceImpl.updateEventCreateRule(
              (com.google.analytics.admin.v1alpha.UpdateEventCreateRuleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.EventCreateRule>)
                  responseObserver);
          break;
        case METHODID_DELETE_EVENT_CREATE_RULE:
          serviceImpl.deleteEventCreateRule(
              (com.google.analytics.admin.v1alpha.DeleteEventCreateRuleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_DATA_REDACTION_SETTINGS:
          serviceImpl.updateDataRedactionSettings(
              (com.google.analytics.admin.v1alpha.UpdateDataRedactionSettingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.DataRedactionSettings>)
                  responseObserver);
          break;
        case METHODID_GET_DATA_REDACTION_SETTINGS:
          serviceImpl.getDataRedactionSettings(
              (com.google.analytics.admin.v1alpha.GetDataRedactionSettingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.DataRedactionSettings>)
                  responseObserver);
          break;
        case METHODID_GET_CALCULATED_METRIC:
          serviceImpl.getCalculatedMetric(
              (com.google.analytics.admin.v1alpha.GetCalculatedMetricRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.CalculatedMetric>)
                  responseObserver);
          break;
        case METHODID_CREATE_CALCULATED_METRIC:
          serviceImpl.createCalculatedMetric(
              (com.google.analytics.admin.v1alpha.CreateCalculatedMetricRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.CalculatedMetric>)
                  responseObserver);
          break;
        case METHODID_LIST_CALCULATED_METRICS:
          serviceImpl.listCalculatedMetrics(
              (com.google.analytics.admin.v1alpha.ListCalculatedMetricsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.ListCalculatedMetricsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CALCULATED_METRIC:
          serviceImpl.updateCalculatedMetric(
              (com.google.analytics.admin.v1alpha.UpdateCalculatedMetricRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.CalculatedMetric>)
                  responseObserver);
          break;
        case METHODID_DELETE_CALCULATED_METRIC:
          serviceImpl.deleteCalculatedMetric(
              (com.google.analytics.admin.v1alpha.DeleteCalculatedMetricRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_ROLLUP_PROPERTY:
          serviceImpl.createRollupProperty(
              (com.google.analytics.admin.v1alpha.CreateRollupPropertyRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.CreateRollupPropertyResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ROLLUP_PROPERTY_SOURCE_LINK:
          serviceImpl.getRollupPropertySourceLink(
              (com.google.analytics.admin.v1alpha.GetRollupPropertySourceLinkRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.RollupPropertySourceLink>)
                  responseObserver);
          break;
        case METHODID_LIST_ROLLUP_PROPERTY_SOURCE_LINKS:
          serviceImpl.listRollupPropertySourceLinks(
              (com.google.analytics.admin.v1alpha.ListRollupPropertySourceLinksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.ListRollupPropertySourceLinksResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_ROLLUP_PROPERTY_SOURCE_LINK:
          serviceImpl.createRollupPropertySourceLink(
              (com.google.analytics.admin.v1alpha.CreateRollupPropertySourceLinkRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.RollupPropertySourceLink>)
                  responseObserver);
          break;
        case METHODID_DELETE_ROLLUP_PROPERTY_SOURCE_LINK:
          serviceImpl.deleteRollupPropertySourceLink(
              (com.google.analytics.admin.v1alpha.DeleteRollupPropertySourceLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_SUBPROPERTY:
          serviceImpl.createSubproperty(
              (com.google.analytics.admin.v1alpha.CreateSubpropertyRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.CreateSubpropertyResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_SUBPROPERTY_EVENT_FILTER:
          serviceImpl.createSubpropertyEventFilter(
              (com.google.analytics.admin.v1alpha.CreateSubpropertyEventFilterRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.SubpropertyEventFilter>)
                  responseObserver);
          break;
        case METHODID_GET_SUBPROPERTY_EVENT_FILTER:
          serviceImpl.getSubpropertyEventFilter(
              (com.google.analytics.admin.v1alpha.GetSubpropertyEventFilterRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.SubpropertyEventFilter>)
                  responseObserver);
          break;
        case METHODID_LIST_SUBPROPERTY_EVENT_FILTERS:
          serviceImpl.listSubpropertyEventFilters(
              (com.google.analytics.admin.v1alpha.ListSubpropertyEventFiltersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.ListSubpropertyEventFiltersResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SUBPROPERTY_EVENT_FILTER:
          serviceImpl.updateSubpropertyEventFilter(
              (com.google.analytics.admin.v1alpha.UpdateSubpropertyEventFilterRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.SubpropertyEventFilter>)
                  responseObserver);
          break;
        case METHODID_DELETE_SUBPROPERTY_EVENT_FILTER:
          serviceImpl.deleteSubpropertyEventFilter(
              (com.google.analytics.admin.v1alpha.DeleteSubpropertyEventFilterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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
            getGetAccountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.GetAccountRequest,
                    com.google.analytics.admin.v1alpha.Account>(service, METHODID_GET_ACCOUNT)))
        .addMethod(
            getListAccountsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.ListAccountsRequest,
                    com.google.analytics.admin.v1alpha.ListAccountsResponse>(
                    service, METHODID_LIST_ACCOUNTS)))
        .addMethod(
            getDeleteAccountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.DeleteAccountRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_ACCOUNT)))
        .addMethod(
            getUpdateAccountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.UpdateAccountRequest,
                    com.google.analytics.admin.v1alpha.Account>(service, METHODID_UPDATE_ACCOUNT)))
        .addMethod(
            getProvisionAccountTicketMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.ProvisionAccountTicketRequest,
                    com.google.analytics.admin.v1alpha.ProvisionAccountTicketResponse>(
                    service, METHODID_PROVISION_ACCOUNT_TICKET)))
        .addMethod(
            getListAccountSummariesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.ListAccountSummariesRequest,
                    com.google.analytics.admin.v1alpha.ListAccountSummariesResponse>(
                    service, METHODID_LIST_ACCOUNT_SUMMARIES)))
        .addMethod(
            getGetPropertyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.GetPropertyRequest,
                    com.google.analytics.admin.v1alpha.Property>(service, METHODID_GET_PROPERTY)))
        .addMethod(
            getListPropertiesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.ListPropertiesRequest,
                    com.google.analytics.admin.v1alpha.ListPropertiesResponse>(
                    service, METHODID_LIST_PROPERTIES)))
        .addMethod(
            getCreatePropertyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.CreatePropertyRequest,
                    com.google.analytics.admin.v1alpha.Property>(
                    service, METHODID_CREATE_PROPERTY)))
        .addMethod(
            getDeletePropertyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.DeletePropertyRequest,
                    com.google.analytics.admin.v1alpha.Property>(
                    service, METHODID_DELETE_PROPERTY)))
        .addMethod(
            getUpdatePropertyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.UpdatePropertyRequest,
                    com.google.analytics.admin.v1alpha.Property>(
                    service, METHODID_UPDATE_PROPERTY)))
        .addMethod(
            getCreateFirebaseLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.CreateFirebaseLinkRequest,
                    com.google.analytics.admin.v1alpha.FirebaseLink>(
                    service, METHODID_CREATE_FIREBASE_LINK)))
        .addMethod(
            getDeleteFirebaseLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.DeleteFirebaseLinkRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_FIREBASE_LINK)))
        .addMethod(
            getListFirebaseLinksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.ListFirebaseLinksRequest,
                    com.google.analytics.admin.v1alpha.ListFirebaseLinksResponse>(
                    service, METHODID_LIST_FIREBASE_LINKS)))
        .addMethod(
            getGetGlobalSiteTagMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.GetGlobalSiteTagRequest,
                    com.google.analytics.admin.v1alpha.GlobalSiteTag>(
                    service, METHODID_GET_GLOBAL_SITE_TAG)))
        .addMethod(
            getCreateGoogleAdsLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.CreateGoogleAdsLinkRequest,
                    com.google.analytics.admin.v1alpha.GoogleAdsLink>(
                    service, METHODID_CREATE_GOOGLE_ADS_LINK)))
        .addMethod(
            getUpdateGoogleAdsLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.UpdateGoogleAdsLinkRequest,
                    com.google.analytics.admin.v1alpha.GoogleAdsLink>(
                    service, METHODID_UPDATE_GOOGLE_ADS_LINK)))
        .addMethod(
            getDeleteGoogleAdsLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.DeleteGoogleAdsLinkRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_GOOGLE_ADS_LINK)))
        .addMethod(
            getListGoogleAdsLinksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.ListGoogleAdsLinksRequest,
                    com.google.analytics.admin.v1alpha.ListGoogleAdsLinksResponse>(
                    service, METHODID_LIST_GOOGLE_ADS_LINKS)))
        .addMethod(
            getGetDataSharingSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.GetDataSharingSettingsRequest,
                    com.google.analytics.admin.v1alpha.DataSharingSettings>(
                    service, METHODID_GET_DATA_SHARING_SETTINGS)))
        .addMethod(
            getGetMeasurementProtocolSecretMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.GetMeasurementProtocolSecretRequest,
                    com.google.analytics.admin.v1alpha.MeasurementProtocolSecret>(
                    service, METHODID_GET_MEASUREMENT_PROTOCOL_SECRET)))
        .addMethod(
            getListMeasurementProtocolSecretsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.ListMeasurementProtocolSecretsRequest,
                    com.google.analytics.admin.v1alpha.ListMeasurementProtocolSecretsResponse>(
                    service, METHODID_LIST_MEASUREMENT_PROTOCOL_SECRETS)))
        .addMethod(
            getCreateMeasurementProtocolSecretMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.CreateMeasurementProtocolSecretRequest,
                    com.google.analytics.admin.v1alpha.MeasurementProtocolSecret>(
                    service, METHODID_CREATE_MEASUREMENT_PROTOCOL_SECRET)))
        .addMethod(
            getDeleteMeasurementProtocolSecretMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.DeleteMeasurementProtocolSecretRequest,
                    com.google.protobuf.Empty>(
                    service, METHODID_DELETE_MEASUREMENT_PROTOCOL_SECRET)))
        .addMethod(
            getUpdateMeasurementProtocolSecretMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.UpdateMeasurementProtocolSecretRequest,
                    com.google.analytics.admin.v1alpha.MeasurementProtocolSecret>(
                    service, METHODID_UPDATE_MEASUREMENT_PROTOCOL_SECRET)))
        .addMethod(
            getAcknowledgeUserDataCollectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.AcknowledgeUserDataCollectionRequest,
                    com.google.analytics.admin.v1alpha.AcknowledgeUserDataCollectionResponse>(
                    service, METHODID_ACKNOWLEDGE_USER_DATA_COLLECTION)))
        .addMethod(
            getGetSKAdNetworkConversionValueSchemaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.GetSKAdNetworkConversionValueSchemaRequest,
                    com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema>(
                    service, METHODID_GET_SKAD_NETWORK_CONVERSION_VALUE_SCHEMA)))
        .addMethod(
            getCreateSKAdNetworkConversionValueSchemaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha
                        .CreateSKAdNetworkConversionValueSchemaRequest,
                    com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema>(
                    service, METHODID_CREATE_SKAD_NETWORK_CONVERSION_VALUE_SCHEMA)))
        .addMethod(
            getDeleteSKAdNetworkConversionValueSchemaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha
                        .DeleteSKAdNetworkConversionValueSchemaRequest,
                    com.google.protobuf.Empty>(
                    service, METHODID_DELETE_SKAD_NETWORK_CONVERSION_VALUE_SCHEMA)))
        .addMethod(
            getUpdateSKAdNetworkConversionValueSchemaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha
                        .UpdateSKAdNetworkConversionValueSchemaRequest,
                    com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema>(
                    service, METHODID_UPDATE_SKAD_NETWORK_CONVERSION_VALUE_SCHEMA)))
        .addMethod(
            getListSKAdNetworkConversionValueSchemasMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.ListSKAdNetworkConversionValueSchemasRequest,
                    com.google.analytics.admin.v1alpha
                        .ListSKAdNetworkConversionValueSchemasResponse>(
                    service, METHODID_LIST_SKAD_NETWORK_CONVERSION_VALUE_SCHEMAS)))
        .addMethod(
            getSearchChangeHistoryEventsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.SearchChangeHistoryEventsRequest,
                    com.google.analytics.admin.v1alpha.SearchChangeHistoryEventsResponse>(
                    service, METHODID_SEARCH_CHANGE_HISTORY_EVENTS)))
        .addMethod(
            getGetGoogleSignalsSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.GetGoogleSignalsSettingsRequest,
                    com.google.analytics.admin.v1alpha.GoogleSignalsSettings>(
                    service, METHODID_GET_GOOGLE_SIGNALS_SETTINGS)))
        .addMethod(
            getUpdateGoogleSignalsSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.UpdateGoogleSignalsSettingsRequest,
                    com.google.analytics.admin.v1alpha.GoogleSignalsSettings>(
                    service, METHODID_UPDATE_GOOGLE_SIGNALS_SETTINGS)))
        .addMethod(
            getCreateConversionEventMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.CreateConversionEventRequest,
                    com.google.analytics.admin.v1alpha.ConversionEvent>(
                    service, METHODID_CREATE_CONVERSION_EVENT)))
        .addMethod(
            getUpdateConversionEventMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.UpdateConversionEventRequest,
                    com.google.analytics.admin.v1alpha.ConversionEvent>(
                    service, METHODID_UPDATE_CONVERSION_EVENT)))
        .addMethod(
            getGetConversionEventMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.GetConversionEventRequest,
                    com.google.analytics.admin.v1alpha.ConversionEvent>(
                    service, METHODID_GET_CONVERSION_EVENT)))
        .addMethod(
            getDeleteConversionEventMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.DeleteConversionEventRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_CONVERSION_EVENT)))
        .addMethod(
            getListConversionEventsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.ListConversionEventsRequest,
                    com.google.analytics.admin.v1alpha.ListConversionEventsResponse>(
                    service, METHODID_LIST_CONVERSION_EVENTS)))
        .addMethod(
            getGetDisplayVideo360AdvertiserLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.GetDisplayVideo360AdvertiserLinkRequest,
                    com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink>(
                    service, METHODID_GET_DISPLAY_VIDEO360ADVERTISER_LINK)))
        .addMethod(
            getListDisplayVideo360AdvertiserLinksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinksRequest,
                    com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinksResponse>(
                    service, METHODID_LIST_DISPLAY_VIDEO360ADVERTISER_LINKS)))
        .addMethod(
            getCreateDisplayVideo360AdvertiserLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.CreateDisplayVideo360AdvertiserLinkRequest,
                    com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink>(
                    service, METHODID_CREATE_DISPLAY_VIDEO360ADVERTISER_LINK)))
        .addMethod(
            getDeleteDisplayVideo360AdvertiserLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.DeleteDisplayVideo360AdvertiserLinkRequest,
                    com.google.protobuf.Empty>(
                    service, METHODID_DELETE_DISPLAY_VIDEO360ADVERTISER_LINK)))
        .addMethod(
            getUpdateDisplayVideo360AdvertiserLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.UpdateDisplayVideo360AdvertiserLinkRequest,
                    com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink>(
                    service, METHODID_UPDATE_DISPLAY_VIDEO360ADVERTISER_LINK)))
        .addMethod(
            getGetDisplayVideo360AdvertiserLinkProposalMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha
                        .GetDisplayVideo360AdvertiserLinkProposalRequest,
                    com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal>(
                    service, METHODID_GET_DISPLAY_VIDEO360ADVERTISER_LINK_PROPOSAL)))
        .addMethod(
            getListDisplayVideo360AdvertiserLinkProposalsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha
                        .ListDisplayVideo360AdvertiserLinkProposalsRequest,
                    com.google.analytics.admin.v1alpha
                        .ListDisplayVideo360AdvertiserLinkProposalsResponse>(
                    service, METHODID_LIST_DISPLAY_VIDEO360ADVERTISER_LINK_PROPOSALS)))
        .addMethod(
            getCreateDisplayVideo360AdvertiserLinkProposalMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha
                        .CreateDisplayVideo360AdvertiserLinkProposalRequest,
                    com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal>(
                    service, METHODID_CREATE_DISPLAY_VIDEO360ADVERTISER_LINK_PROPOSAL)))
        .addMethod(
            getDeleteDisplayVideo360AdvertiserLinkProposalMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha
                        .DeleteDisplayVideo360AdvertiserLinkProposalRequest,
                    com.google.protobuf.Empty>(
                    service, METHODID_DELETE_DISPLAY_VIDEO360ADVERTISER_LINK_PROPOSAL)))
        .addMethod(
            getApproveDisplayVideo360AdvertiserLinkProposalMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha
                        .ApproveDisplayVideo360AdvertiserLinkProposalRequest,
                    com.google.analytics.admin.v1alpha
                        .ApproveDisplayVideo360AdvertiserLinkProposalResponse>(
                    service, METHODID_APPROVE_DISPLAY_VIDEO360ADVERTISER_LINK_PROPOSAL)))
        .addMethod(
            getCancelDisplayVideo360AdvertiserLinkProposalMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha
                        .CancelDisplayVideo360AdvertiserLinkProposalRequest,
                    com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal>(
                    service, METHODID_CANCEL_DISPLAY_VIDEO360ADVERTISER_LINK_PROPOSAL)))
        .addMethod(
            getCreateCustomDimensionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.CreateCustomDimensionRequest,
                    com.google.analytics.admin.v1alpha.CustomDimension>(
                    service, METHODID_CREATE_CUSTOM_DIMENSION)))
        .addMethod(
            getUpdateCustomDimensionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.UpdateCustomDimensionRequest,
                    com.google.analytics.admin.v1alpha.CustomDimension>(
                    service, METHODID_UPDATE_CUSTOM_DIMENSION)))
        .addMethod(
            getListCustomDimensionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.ListCustomDimensionsRequest,
                    com.google.analytics.admin.v1alpha.ListCustomDimensionsResponse>(
                    service, METHODID_LIST_CUSTOM_DIMENSIONS)))
        .addMethod(
            getArchiveCustomDimensionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.ArchiveCustomDimensionRequest,
                    com.google.protobuf.Empty>(service, METHODID_ARCHIVE_CUSTOM_DIMENSION)))
        .addMethod(
            getGetCustomDimensionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.GetCustomDimensionRequest,
                    com.google.analytics.admin.v1alpha.CustomDimension>(
                    service, METHODID_GET_CUSTOM_DIMENSION)))
        .addMethod(
            getCreateCustomMetricMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.CreateCustomMetricRequest,
                    com.google.analytics.admin.v1alpha.CustomMetric>(
                    service, METHODID_CREATE_CUSTOM_METRIC)))
        .addMethod(
            getUpdateCustomMetricMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.UpdateCustomMetricRequest,
                    com.google.analytics.admin.v1alpha.CustomMetric>(
                    service, METHODID_UPDATE_CUSTOM_METRIC)))
        .addMethod(
            getListCustomMetricsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.ListCustomMetricsRequest,
                    com.google.analytics.admin.v1alpha.ListCustomMetricsResponse>(
                    service, METHODID_LIST_CUSTOM_METRICS)))
        .addMethod(
            getArchiveCustomMetricMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.ArchiveCustomMetricRequest,
                    com.google.protobuf.Empty>(service, METHODID_ARCHIVE_CUSTOM_METRIC)))
        .addMethod(
            getGetCustomMetricMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.GetCustomMetricRequest,
                    com.google.analytics.admin.v1alpha.CustomMetric>(
                    service, METHODID_GET_CUSTOM_METRIC)))
        .addMethod(
            getGetDataRetentionSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.GetDataRetentionSettingsRequest,
                    com.google.analytics.admin.v1alpha.DataRetentionSettings>(
                    service, METHODID_GET_DATA_RETENTION_SETTINGS)))
        .addMethod(
            getUpdateDataRetentionSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.UpdateDataRetentionSettingsRequest,
                    com.google.analytics.admin.v1alpha.DataRetentionSettings>(
                    service, METHODID_UPDATE_DATA_RETENTION_SETTINGS)))
        .addMethod(
            getCreateDataStreamMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.CreateDataStreamRequest,
                    com.google.analytics.admin.v1alpha.DataStream>(
                    service, METHODID_CREATE_DATA_STREAM)))
        .addMethod(
            getDeleteDataStreamMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.DeleteDataStreamRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_DATA_STREAM)))
        .addMethod(
            getUpdateDataStreamMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.UpdateDataStreamRequest,
                    com.google.analytics.admin.v1alpha.DataStream>(
                    service, METHODID_UPDATE_DATA_STREAM)))
        .addMethod(
            getListDataStreamsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.ListDataStreamsRequest,
                    com.google.analytics.admin.v1alpha.ListDataStreamsResponse>(
                    service, METHODID_LIST_DATA_STREAMS)))
        .addMethod(
            getGetDataStreamMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.GetDataStreamRequest,
                    com.google.analytics.admin.v1alpha.DataStream>(
                    service, METHODID_GET_DATA_STREAM)))
        .addMethod(
            getGetAudienceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.GetAudienceRequest,
                    com.google.analytics.admin.v1alpha.Audience>(service, METHODID_GET_AUDIENCE)))
        .addMethod(
            getListAudiencesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.ListAudiencesRequest,
                    com.google.analytics.admin.v1alpha.ListAudiencesResponse>(
                    service, METHODID_LIST_AUDIENCES)))
        .addMethod(
            getCreateAudienceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.CreateAudienceRequest,
                    com.google.analytics.admin.v1alpha.Audience>(
                    service, METHODID_CREATE_AUDIENCE)))
        .addMethod(
            getUpdateAudienceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.UpdateAudienceRequest,
                    com.google.analytics.admin.v1alpha.Audience>(
                    service, METHODID_UPDATE_AUDIENCE)))
        .addMethod(
            getArchiveAudienceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.ArchiveAudienceRequest,
                    com.google.protobuf.Empty>(service, METHODID_ARCHIVE_AUDIENCE)))
        .addMethod(
            getGetSearchAds360LinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.GetSearchAds360LinkRequest,
                    com.google.analytics.admin.v1alpha.SearchAds360Link>(
                    service, METHODID_GET_SEARCH_ADS360LINK)))
        .addMethod(
            getListSearchAds360LinksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.ListSearchAds360LinksRequest,
                    com.google.analytics.admin.v1alpha.ListSearchAds360LinksResponse>(
                    service, METHODID_LIST_SEARCH_ADS360LINKS)))
        .addMethod(
            getCreateSearchAds360LinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.CreateSearchAds360LinkRequest,
                    com.google.analytics.admin.v1alpha.SearchAds360Link>(
                    service, METHODID_CREATE_SEARCH_ADS360LINK)))
        .addMethod(
            getDeleteSearchAds360LinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.DeleteSearchAds360LinkRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_SEARCH_ADS360LINK)))
        .addMethod(
            getUpdateSearchAds360LinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.UpdateSearchAds360LinkRequest,
                    com.google.analytics.admin.v1alpha.SearchAds360Link>(
                    service, METHODID_UPDATE_SEARCH_ADS360LINK)))
        .addMethod(
            getGetAttributionSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.GetAttributionSettingsRequest,
                    com.google.analytics.admin.v1alpha.AttributionSettings>(
                    service, METHODID_GET_ATTRIBUTION_SETTINGS)))
        .addMethod(
            getUpdateAttributionSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.UpdateAttributionSettingsRequest,
                    com.google.analytics.admin.v1alpha.AttributionSettings>(
                    service, METHODID_UPDATE_ATTRIBUTION_SETTINGS)))
        .addMethod(
            getRunAccessReportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.RunAccessReportRequest,
                    com.google.analytics.admin.v1alpha.RunAccessReportResponse>(
                    service, METHODID_RUN_ACCESS_REPORT)))
        .addMethod(
            getCreateAccessBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.CreateAccessBindingRequest,
                    com.google.analytics.admin.v1alpha.AccessBinding>(
                    service, METHODID_CREATE_ACCESS_BINDING)))
        .addMethod(
            getGetAccessBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.GetAccessBindingRequest,
                    com.google.analytics.admin.v1alpha.AccessBinding>(
                    service, METHODID_GET_ACCESS_BINDING)))
        .addMethod(
            getUpdateAccessBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.UpdateAccessBindingRequest,
                    com.google.analytics.admin.v1alpha.AccessBinding>(
                    service, METHODID_UPDATE_ACCESS_BINDING)))
        .addMethod(
            getDeleteAccessBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.DeleteAccessBindingRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_ACCESS_BINDING)))
        .addMethod(
            getListAccessBindingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.ListAccessBindingsRequest,
                    com.google.analytics.admin.v1alpha.ListAccessBindingsResponse>(
                    service, METHODID_LIST_ACCESS_BINDINGS)))
        .addMethod(
            getBatchCreateAccessBindingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.BatchCreateAccessBindingsRequest,
                    com.google.analytics.admin.v1alpha.BatchCreateAccessBindingsResponse>(
                    service, METHODID_BATCH_CREATE_ACCESS_BINDINGS)))
        .addMethod(
            getBatchGetAccessBindingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.BatchGetAccessBindingsRequest,
                    com.google.analytics.admin.v1alpha.BatchGetAccessBindingsResponse>(
                    service, METHODID_BATCH_GET_ACCESS_BINDINGS)))
        .addMethod(
            getBatchUpdateAccessBindingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.BatchUpdateAccessBindingsRequest,
                    com.google.analytics.admin.v1alpha.BatchUpdateAccessBindingsResponse>(
                    service, METHODID_BATCH_UPDATE_ACCESS_BINDINGS)))
        .addMethod(
            getBatchDeleteAccessBindingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.BatchDeleteAccessBindingsRequest,
                    com.google.protobuf.Empty>(service, METHODID_BATCH_DELETE_ACCESS_BINDINGS)))
        .addMethod(
            getGetExpandedDataSetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.GetExpandedDataSetRequest,
                    com.google.analytics.admin.v1alpha.ExpandedDataSet>(
                    service, METHODID_GET_EXPANDED_DATA_SET)))
        .addMethod(
            getListExpandedDataSetsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.ListExpandedDataSetsRequest,
                    com.google.analytics.admin.v1alpha.ListExpandedDataSetsResponse>(
                    service, METHODID_LIST_EXPANDED_DATA_SETS)))
        .addMethod(
            getCreateExpandedDataSetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.CreateExpandedDataSetRequest,
                    com.google.analytics.admin.v1alpha.ExpandedDataSet>(
                    service, METHODID_CREATE_EXPANDED_DATA_SET)))
        .addMethod(
            getUpdateExpandedDataSetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.UpdateExpandedDataSetRequest,
                    com.google.analytics.admin.v1alpha.ExpandedDataSet>(
                    service, METHODID_UPDATE_EXPANDED_DATA_SET)))
        .addMethod(
            getDeleteExpandedDataSetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.DeleteExpandedDataSetRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_EXPANDED_DATA_SET)))
        .addMethod(
            getGetChannelGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.GetChannelGroupRequest,
                    com.google.analytics.admin.v1alpha.ChannelGroup>(
                    service, METHODID_GET_CHANNEL_GROUP)))
        .addMethod(
            getListChannelGroupsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.ListChannelGroupsRequest,
                    com.google.analytics.admin.v1alpha.ListChannelGroupsResponse>(
                    service, METHODID_LIST_CHANNEL_GROUPS)))
        .addMethod(
            getCreateChannelGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.CreateChannelGroupRequest,
                    com.google.analytics.admin.v1alpha.ChannelGroup>(
                    service, METHODID_CREATE_CHANNEL_GROUP)))
        .addMethod(
            getUpdateChannelGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.UpdateChannelGroupRequest,
                    com.google.analytics.admin.v1alpha.ChannelGroup>(
                    service, METHODID_UPDATE_CHANNEL_GROUP)))
        .addMethod(
            getDeleteChannelGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.DeleteChannelGroupRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_CHANNEL_GROUP)))
        .addMethod(
            getSetAutomatedGa4ConfigurationOptOutMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.SetAutomatedGa4ConfigurationOptOutRequest,
                    com.google.analytics.admin.v1alpha.SetAutomatedGa4ConfigurationOptOutResponse>(
                    service, METHODID_SET_AUTOMATED_GA4CONFIGURATION_OPT_OUT)))
        .addMethod(
            getFetchAutomatedGa4ConfigurationOptOutMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.FetchAutomatedGa4ConfigurationOptOutRequest,
                    com.google.analytics.admin.v1alpha
                        .FetchAutomatedGa4ConfigurationOptOutResponse>(
                    service, METHODID_FETCH_AUTOMATED_GA4CONFIGURATION_OPT_OUT)))
        .addMethod(
            getGetBigQueryLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.GetBigQueryLinkRequest,
                    com.google.analytics.admin.v1alpha.BigQueryLink>(
                    service, METHODID_GET_BIG_QUERY_LINK)))
        .addMethod(
            getListBigQueryLinksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.ListBigQueryLinksRequest,
                    com.google.analytics.admin.v1alpha.ListBigQueryLinksResponse>(
                    service, METHODID_LIST_BIG_QUERY_LINKS)))
        .addMethod(
            getGetEnhancedMeasurementSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.GetEnhancedMeasurementSettingsRequest,
                    com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>(
                    service, METHODID_GET_ENHANCED_MEASUREMENT_SETTINGS)))
        .addMethod(
            getUpdateEnhancedMeasurementSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.UpdateEnhancedMeasurementSettingsRequest,
                    com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>(
                    service, METHODID_UPDATE_ENHANCED_MEASUREMENT_SETTINGS)))
        .addMethod(
            getCreateConnectedSiteTagMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.CreateConnectedSiteTagRequest,
                    com.google.analytics.admin.v1alpha.CreateConnectedSiteTagResponse>(
                    service, METHODID_CREATE_CONNECTED_SITE_TAG)))
        .addMethod(
            getDeleteConnectedSiteTagMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.DeleteConnectedSiteTagRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_CONNECTED_SITE_TAG)))
        .addMethod(
            getListConnectedSiteTagsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.ListConnectedSiteTagsRequest,
                    com.google.analytics.admin.v1alpha.ListConnectedSiteTagsResponse>(
                    service, METHODID_LIST_CONNECTED_SITE_TAGS)))
        .addMethod(
            getFetchConnectedGa4PropertyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.FetchConnectedGa4PropertyRequest,
                    com.google.analytics.admin.v1alpha.FetchConnectedGa4PropertyResponse>(
                    service, METHODID_FETCH_CONNECTED_GA4PROPERTY)))
        .addMethod(
            getGetAdSenseLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.GetAdSenseLinkRequest,
                    com.google.analytics.admin.v1alpha.AdSenseLink>(
                    service, METHODID_GET_AD_SENSE_LINK)))
        .addMethod(
            getCreateAdSenseLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.CreateAdSenseLinkRequest,
                    com.google.analytics.admin.v1alpha.AdSenseLink>(
                    service, METHODID_CREATE_AD_SENSE_LINK)))
        .addMethod(
            getDeleteAdSenseLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.DeleteAdSenseLinkRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_AD_SENSE_LINK)))
        .addMethod(
            getListAdSenseLinksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.ListAdSenseLinksRequest,
                    com.google.analytics.admin.v1alpha.ListAdSenseLinksResponse>(
                    service, METHODID_LIST_AD_SENSE_LINKS)))
        .addMethod(
            getGetEventCreateRuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.GetEventCreateRuleRequest,
                    com.google.analytics.admin.v1alpha.EventCreateRule>(
                    service, METHODID_GET_EVENT_CREATE_RULE)))
        .addMethod(
            getListEventCreateRulesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.ListEventCreateRulesRequest,
                    com.google.analytics.admin.v1alpha.ListEventCreateRulesResponse>(
                    service, METHODID_LIST_EVENT_CREATE_RULES)))
        .addMethod(
            getCreateEventCreateRuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.CreateEventCreateRuleRequest,
                    com.google.analytics.admin.v1alpha.EventCreateRule>(
                    service, METHODID_CREATE_EVENT_CREATE_RULE)))
        .addMethod(
            getUpdateEventCreateRuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.UpdateEventCreateRuleRequest,
                    com.google.analytics.admin.v1alpha.EventCreateRule>(
                    service, METHODID_UPDATE_EVENT_CREATE_RULE)))
        .addMethod(
            getDeleteEventCreateRuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.DeleteEventCreateRuleRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_EVENT_CREATE_RULE)))
        .addMethod(
            getUpdateDataRedactionSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.UpdateDataRedactionSettingsRequest,
                    com.google.analytics.admin.v1alpha.DataRedactionSettings>(
                    service, METHODID_UPDATE_DATA_REDACTION_SETTINGS)))
        .addMethod(
            getGetDataRedactionSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.GetDataRedactionSettingsRequest,
                    com.google.analytics.admin.v1alpha.DataRedactionSettings>(
                    service, METHODID_GET_DATA_REDACTION_SETTINGS)))
        .addMethod(
            getGetCalculatedMetricMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.GetCalculatedMetricRequest,
                    com.google.analytics.admin.v1alpha.CalculatedMetric>(
                    service, METHODID_GET_CALCULATED_METRIC)))
        .addMethod(
            getCreateCalculatedMetricMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.CreateCalculatedMetricRequest,
                    com.google.analytics.admin.v1alpha.CalculatedMetric>(
                    service, METHODID_CREATE_CALCULATED_METRIC)))
        .addMethod(
            getListCalculatedMetricsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.ListCalculatedMetricsRequest,
                    com.google.analytics.admin.v1alpha.ListCalculatedMetricsResponse>(
                    service, METHODID_LIST_CALCULATED_METRICS)))
        .addMethod(
            getUpdateCalculatedMetricMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.UpdateCalculatedMetricRequest,
                    com.google.analytics.admin.v1alpha.CalculatedMetric>(
                    service, METHODID_UPDATE_CALCULATED_METRIC)))
        .addMethod(
            getDeleteCalculatedMetricMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.DeleteCalculatedMetricRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_CALCULATED_METRIC)))
        .addMethod(
            getCreateRollupPropertyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.CreateRollupPropertyRequest,
                    com.google.analytics.admin.v1alpha.CreateRollupPropertyResponse>(
                    service, METHODID_CREATE_ROLLUP_PROPERTY)))
        .addMethod(
            getGetRollupPropertySourceLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.GetRollupPropertySourceLinkRequest,
                    com.google.analytics.admin.v1alpha.RollupPropertySourceLink>(
                    service, METHODID_GET_ROLLUP_PROPERTY_SOURCE_LINK)))
        .addMethod(
            getListRollupPropertySourceLinksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.ListRollupPropertySourceLinksRequest,
                    com.google.analytics.admin.v1alpha.ListRollupPropertySourceLinksResponse>(
                    service, METHODID_LIST_ROLLUP_PROPERTY_SOURCE_LINKS)))
        .addMethod(
            getCreateRollupPropertySourceLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.CreateRollupPropertySourceLinkRequest,
                    com.google.analytics.admin.v1alpha.RollupPropertySourceLink>(
                    service, METHODID_CREATE_ROLLUP_PROPERTY_SOURCE_LINK)))
        .addMethod(
            getDeleteRollupPropertySourceLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.DeleteRollupPropertySourceLinkRequest,
                    com.google.protobuf.Empty>(
                    service, METHODID_DELETE_ROLLUP_PROPERTY_SOURCE_LINK)))
        .addMethod(
            getCreateSubpropertyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.CreateSubpropertyRequest,
                    com.google.analytics.admin.v1alpha.CreateSubpropertyResponse>(
                    service, METHODID_CREATE_SUBPROPERTY)))
        .addMethod(
            getCreateSubpropertyEventFilterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.CreateSubpropertyEventFilterRequest,
                    com.google.analytics.admin.v1alpha.SubpropertyEventFilter>(
                    service, METHODID_CREATE_SUBPROPERTY_EVENT_FILTER)))
        .addMethod(
            getGetSubpropertyEventFilterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.GetSubpropertyEventFilterRequest,
                    com.google.analytics.admin.v1alpha.SubpropertyEventFilter>(
                    service, METHODID_GET_SUBPROPERTY_EVENT_FILTER)))
        .addMethod(
            getListSubpropertyEventFiltersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.ListSubpropertyEventFiltersRequest,
                    com.google.analytics.admin.v1alpha.ListSubpropertyEventFiltersResponse>(
                    service, METHODID_LIST_SUBPROPERTY_EVENT_FILTERS)))
        .addMethod(
            getUpdateSubpropertyEventFilterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.UpdateSubpropertyEventFilterRequest,
                    com.google.analytics.admin.v1alpha.SubpropertyEventFilter>(
                    service, METHODID_UPDATE_SUBPROPERTY_EVENT_FILTER)))
        .addMethod(
            getDeleteSubpropertyEventFilterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1alpha.DeleteSubpropertyEventFilterRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_SUBPROPERTY_EVENT_FILTER)))
        .build();
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
    private final java.lang.String methodName;

    AnalyticsAdminServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
                      .addMethod(getGetSKAdNetworkConversionValueSchemaMethod())
                      .addMethod(getCreateSKAdNetworkConversionValueSchemaMethod())
                      .addMethod(getDeleteSKAdNetworkConversionValueSchemaMethod())
                      .addMethod(getUpdateSKAdNetworkConversionValueSchemaMethod())
                      .addMethod(getListSKAdNetworkConversionValueSchemasMethod())
                      .addMethod(getSearchChangeHistoryEventsMethod())
                      .addMethod(getGetGoogleSignalsSettingsMethod())
                      .addMethod(getUpdateGoogleSignalsSettingsMethod())
                      .addMethod(getCreateConversionEventMethod())
                      .addMethod(getUpdateConversionEventMethod())
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
                      .addMethod(getGetSearchAds360LinkMethod())
                      .addMethod(getListSearchAds360LinksMethod())
                      .addMethod(getCreateSearchAds360LinkMethod())
                      .addMethod(getDeleteSearchAds360LinkMethod())
                      .addMethod(getUpdateSearchAds360LinkMethod())
                      .addMethod(getGetAttributionSettingsMethod())
                      .addMethod(getUpdateAttributionSettingsMethod())
                      .addMethod(getRunAccessReportMethod())
                      .addMethod(getCreateAccessBindingMethod())
                      .addMethod(getGetAccessBindingMethod())
                      .addMethod(getUpdateAccessBindingMethod())
                      .addMethod(getDeleteAccessBindingMethod())
                      .addMethod(getListAccessBindingsMethod())
                      .addMethod(getBatchCreateAccessBindingsMethod())
                      .addMethod(getBatchGetAccessBindingsMethod())
                      .addMethod(getBatchUpdateAccessBindingsMethod())
                      .addMethod(getBatchDeleteAccessBindingsMethod())
                      .addMethod(getGetExpandedDataSetMethod())
                      .addMethod(getListExpandedDataSetsMethod())
                      .addMethod(getCreateExpandedDataSetMethod())
                      .addMethod(getUpdateExpandedDataSetMethod())
                      .addMethod(getDeleteExpandedDataSetMethod())
                      .addMethod(getGetChannelGroupMethod())
                      .addMethod(getListChannelGroupsMethod())
                      .addMethod(getCreateChannelGroupMethod())
                      .addMethod(getUpdateChannelGroupMethod())
                      .addMethod(getDeleteChannelGroupMethod())
                      .addMethod(getSetAutomatedGa4ConfigurationOptOutMethod())
                      .addMethod(getFetchAutomatedGa4ConfigurationOptOutMethod())
                      .addMethod(getGetBigQueryLinkMethod())
                      .addMethod(getListBigQueryLinksMethod())
                      .addMethod(getGetEnhancedMeasurementSettingsMethod())
                      .addMethod(getUpdateEnhancedMeasurementSettingsMethod())
                      .addMethod(getCreateConnectedSiteTagMethod())
                      .addMethod(getDeleteConnectedSiteTagMethod())
                      .addMethod(getListConnectedSiteTagsMethod())
                      .addMethod(getFetchConnectedGa4PropertyMethod())
                      .addMethod(getGetAdSenseLinkMethod())
                      .addMethod(getCreateAdSenseLinkMethod())
                      .addMethod(getDeleteAdSenseLinkMethod())
                      .addMethod(getListAdSenseLinksMethod())
                      .addMethod(getGetEventCreateRuleMethod())
                      .addMethod(getListEventCreateRulesMethod())
                      .addMethod(getCreateEventCreateRuleMethod())
                      .addMethod(getUpdateEventCreateRuleMethod())
                      .addMethod(getDeleteEventCreateRuleMethod())
                      .addMethod(getUpdateDataRedactionSettingsMethod())
                      .addMethod(getGetDataRedactionSettingsMethod())
                      .addMethod(getGetCalculatedMetricMethod())
                      .addMethod(getCreateCalculatedMetricMethod())
                      .addMethod(getListCalculatedMetricsMethod())
                      .addMethod(getUpdateCalculatedMetricMethod())
                      .addMethod(getDeleteCalculatedMetricMethod())
                      .addMethod(getCreateRollupPropertyMethod())
                      .addMethod(getGetRollupPropertySourceLinkMethod())
                      .addMethod(getListRollupPropertySourceLinksMethod())
                      .addMethod(getCreateRollupPropertySourceLinkMethod())
                      .addMethod(getDeleteRollupPropertySourceLinkMethod())
                      .addMethod(getCreateSubpropertyMethod())
                      .addMethod(getCreateSubpropertyEventFilterMethod())
                      .addMethod(getGetSubpropertyEventFilterMethod())
                      .addMethod(getListSubpropertyEventFiltersMethod())
                      .addMethod(getUpdateSubpropertyEventFilterMethod())
                      .addMethod(getDeleteSubpropertyEventFilterMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
