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
package com.google.analytics.admin.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service Interface for the Google Analytics Admin API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/analytics/admin/v1beta/analytics_admin.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AnalyticsAdminServiceGrpc {

  private AnalyticsAdminServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.analytics.admin.v1beta.AnalyticsAdminService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.GetAccountRequest,
          com.google.analytics.admin.v1beta.Account>
      getGetAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccount",
      requestType = com.google.analytics.admin.v1beta.GetAccountRequest.class,
      responseType = com.google.analytics.admin.v1beta.Account.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.GetAccountRequest,
          com.google.analytics.admin.v1beta.Account>
      getGetAccountMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.GetAccountRequest,
            com.google.analytics.admin.v1beta.Account>
        getGetAccountMethod;
    if ((getGetAccountMethod = AnalyticsAdminServiceGrpc.getGetAccountMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetAccountMethod = AnalyticsAdminServiceGrpc.getGetAccountMethod) == null) {
          AnalyticsAdminServiceGrpc.getGetAccountMethod =
              getGetAccountMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.GetAccountRequest,
                          com.google.analytics.admin.v1beta.Account>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAccount"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.GetAccountRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.Account.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("GetAccount"))
                      .build();
        }
      }
    }
    return getGetAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.ListAccountsRequest,
          com.google.analytics.admin.v1beta.ListAccountsResponse>
      getListAccountsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAccounts",
      requestType = com.google.analytics.admin.v1beta.ListAccountsRequest.class,
      responseType = com.google.analytics.admin.v1beta.ListAccountsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.ListAccountsRequest,
          com.google.analytics.admin.v1beta.ListAccountsResponse>
      getListAccountsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.ListAccountsRequest,
            com.google.analytics.admin.v1beta.ListAccountsResponse>
        getListAccountsMethod;
    if ((getListAccountsMethod = AnalyticsAdminServiceGrpc.getListAccountsMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListAccountsMethod = AnalyticsAdminServiceGrpc.getListAccountsMethod) == null) {
          AnalyticsAdminServiceGrpc.getListAccountsMethod =
              getListAccountsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.ListAccountsRequest,
                          com.google.analytics.admin.v1beta.ListAccountsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAccounts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.ListAccountsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.ListAccountsResponse
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
          com.google.analytics.admin.v1beta.DeleteAccountRequest, com.google.protobuf.Empty>
      getDeleteAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAccount",
      requestType = com.google.analytics.admin.v1beta.DeleteAccountRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.DeleteAccountRequest, com.google.protobuf.Empty>
      getDeleteAccountMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.DeleteAccountRequest, com.google.protobuf.Empty>
        getDeleteAccountMethod;
    if ((getDeleteAccountMethod = AnalyticsAdminServiceGrpc.getDeleteAccountMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeleteAccountMethod = AnalyticsAdminServiceGrpc.getDeleteAccountMethod) == null) {
          AnalyticsAdminServiceGrpc.getDeleteAccountMethod =
              getDeleteAccountMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.DeleteAccountRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAccount"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.DeleteAccountRequest
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
          com.google.analytics.admin.v1beta.UpdateAccountRequest,
          com.google.analytics.admin.v1beta.Account>
      getUpdateAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAccount",
      requestType = com.google.analytics.admin.v1beta.UpdateAccountRequest.class,
      responseType = com.google.analytics.admin.v1beta.Account.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.UpdateAccountRequest,
          com.google.analytics.admin.v1beta.Account>
      getUpdateAccountMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.UpdateAccountRequest,
            com.google.analytics.admin.v1beta.Account>
        getUpdateAccountMethod;
    if ((getUpdateAccountMethod = AnalyticsAdminServiceGrpc.getUpdateAccountMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateAccountMethod = AnalyticsAdminServiceGrpc.getUpdateAccountMethod) == null) {
          AnalyticsAdminServiceGrpc.getUpdateAccountMethod =
              getUpdateAccountMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.UpdateAccountRequest,
                          com.google.analytics.admin.v1beta.Account>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAccount"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.UpdateAccountRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.Account.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("UpdateAccount"))
                      .build();
        }
      }
    }
    return getUpdateAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.ProvisionAccountTicketRequest,
          com.google.analytics.admin.v1beta.ProvisionAccountTicketResponse>
      getProvisionAccountTicketMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProvisionAccountTicket",
      requestType = com.google.analytics.admin.v1beta.ProvisionAccountTicketRequest.class,
      responseType = com.google.analytics.admin.v1beta.ProvisionAccountTicketResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.ProvisionAccountTicketRequest,
          com.google.analytics.admin.v1beta.ProvisionAccountTicketResponse>
      getProvisionAccountTicketMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.ProvisionAccountTicketRequest,
            com.google.analytics.admin.v1beta.ProvisionAccountTicketResponse>
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
                      .<com.google.analytics.admin.v1beta.ProvisionAccountTicketRequest,
                          com.google.analytics.admin.v1beta.ProvisionAccountTicketResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ProvisionAccountTicket"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.ProvisionAccountTicketRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.ProvisionAccountTicketResponse
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
          com.google.analytics.admin.v1beta.ListAccountSummariesRequest,
          com.google.analytics.admin.v1beta.ListAccountSummariesResponse>
      getListAccountSummariesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAccountSummaries",
      requestType = com.google.analytics.admin.v1beta.ListAccountSummariesRequest.class,
      responseType = com.google.analytics.admin.v1beta.ListAccountSummariesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.ListAccountSummariesRequest,
          com.google.analytics.admin.v1beta.ListAccountSummariesResponse>
      getListAccountSummariesMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.ListAccountSummariesRequest,
            com.google.analytics.admin.v1beta.ListAccountSummariesResponse>
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
                      .<com.google.analytics.admin.v1beta.ListAccountSummariesRequest,
                          com.google.analytics.admin.v1beta.ListAccountSummariesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAccountSummaries"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.ListAccountSummariesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.ListAccountSummariesResponse
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
          com.google.analytics.admin.v1beta.GetPropertyRequest,
          com.google.analytics.admin.v1beta.Property>
      getGetPropertyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProperty",
      requestType = com.google.analytics.admin.v1beta.GetPropertyRequest.class,
      responseType = com.google.analytics.admin.v1beta.Property.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.GetPropertyRequest,
          com.google.analytics.admin.v1beta.Property>
      getGetPropertyMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.GetPropertyRequest,
            com.google.analytics.admin.v1beta.Property>
        getGetPropertyMethod;
    if ((getGetPropertyMethod = AnalyticsAdminServiceGrpc.getGetPropertyMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetPropertyMethod = AnalyticsAdminServiceGrpc.getGetPropertyMethod) == null) {
          AnalyticsAdminServiceGrpc.getGetPropertyMethod =
              getGetPropertyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.GetPropertyRequest,
                          com.google.analytics.admin.v1beta.Property>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProperty"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.GetPropertyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.Property.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("GetProperty"))
                      .build();
        }
      }
    }
    return getGetPropertyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.ListPropertiesRequest,
          com.google.analytics.admin.v1beta.ListPropertiesResponse>
      getListPropertiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListProperties",
      requestType = com.google.analytics.admin.v1beta.ListPropertiesRequest.class,
      responseType = com.google.analytics.admin.v1beta.ListPropertiesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.ListPropertiesRequest,
          com.google.analytics.admin.v1beta.ListPropertiesResponse>
      getListPropertiesMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.ListPropertiesRequest,
            com.google.analytics.admin.v1beta.ListPropertiesResponse>
        getListPropertiesMethod;
    if ((getListPropertiesMethod = AnalyticsAdminServiceGrpc.getListPropertiesMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListPropertiesMethod = AnalyticsAdminServiceGrpc.getListPropertiesMethod) == null) {
          AnalyticsAdminServiceGrpc.getListPropertiesMethod =
              getListPropertiesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.ListPropertiesRequest,
                          com.google.analytics.admin.v1beta.ListPropertiesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListProperties"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.ListPropertiesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.ListPropertiesResponse
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
          com.google.analytics.admin.v1beta.CreatePropertyRequest,
          com.google.analytics.admin.v1beta.Property>
      getCreatePropertyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateProperty",
      requestType = com.google.analytics.admin.v1beta.CreatePropertyRequest.class,
      responseType = com.google.analytics.admin.v1beta.Property.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.CreatePropertyRequest,
          com.google.analytics.admin.v1beta.Property>
      getCreatePropertyMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.CreatePropertyRequest,
            com.google.analytics.admin.v1beta.Property>
        getCreatePropertyMethod;
    if ((getCreatePropertyMethod = AnalyticsAdminServiceGrpc.getCreatePropertyMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreatePropertyMethod = AnalyticsAdminServiceGrpc.getCreatePropertyMethod) == null) {
          AnalyticsAdminServiceGrpc.getCreatePropertyMethod =
              getCreatePropertyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.CreatePropertyRequest,
                          com.google.analytics.admin.v1beta.Property>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateProperty"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.CreatePropertyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.Property.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("CreateProperty"))
                      .build();
        }
      }
    }
    return getCreatePropertyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.DeletePropertyRequest,
          com.google.analytics.admin.v1beta.Property>
      getDeletePropertyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteProperty",
      requestType = com.google.analytics.admin.v1beta.DeletePropertyRequest.class,
      responseType = com.google.analytics.admin.v1beta.Property.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.DeletePropertyRequest,
          com.google.analytics.admin.v1beta.Property>
      getDeletePropertyMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.DeletePropertyRequest,
            com.google.analytics.admin.v1beta.Property>
        getDeletePropertyMethod;
    if ((getDeletePropertyMethod = AnalyticsAdminServiceGrpc.getDeletePropertyMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeletePropertyMethod = AnalyticsAdminServiceGrpc.getDeletePropertyMethod) == null) {
          AnalyticsAdminServiceGrpc.getDeletePropertyMethod =
              getDeletePropertyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.DeletePropertyRequest,
                          com.google.analytics.admin.v1beta.Property>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteProperty"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.DeletePropertyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.Property.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("DeleteProperty"))
                      .build();
        }
      }
    }
    return getDeletePropertyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.UpdatePropertyRequest,
          com.google.analytics.admin.v1beta.Property>
      getUpdatePropertyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateProperty",
      requestType = com.google.analytics.admin.v1beta.UpdatePropertyRequest.class,
      responseType = com.google.analytics.admin.v1beta.Property.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.UpdatePropertyRequest,
          com.google.analytics.admin.v1beta.Property>
      getUpdatePropertyMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.UpdatePropertyRequest,
            com.google.analytics.admin.v1beta.Property>
        getUpdatePropertyMethod;
    if ((getUpdatePropertyMethod = AnalyticsAdminServiceGrpc.getUpdatePropertyMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdatePropertyMethod = AnalyticsAdminServiceGrpc.getUpdatePropertyMethod) == null) {
          AnalyticsAdminServiceGrpc.getUpdatePropertyMethod =
              getUpdatePropertyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.UpdatePropertyRequest,
                          com.google.analytics.admin.v1beta.Property>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateProperty"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.UpdatePropertyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.Property.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("UpdateProperty"))
                      .build();
        }
      }
    }
    return getUpdatePropertyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.CreateFirebaseLinkRequest,
          com.google.analytics.admin.v1beta.FirebaseLink>
      getCreateFirebaseLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFirebaseLink",
      requestType = com.google.analytics.admin.v1beta.CreateFirebaseLinkRequest.class,
      responseType = com.google.analytics.admin.v1beta.FirebaseLink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.CreateFirebaseLinkRequest,
          com.google.analytics.admin.v1beta.FirebaseLink>
      getCreateFirebaseLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.CreateFirebaseLinkRequest,
            com.google.analytics.admin.v1beta.FirebaseLink>
        getCreateFirebaseLinkMethod;
    if ((getCreateFirebaseLinkMethod = AnalyticsAdminServiceGrpc.getCreateFirebaseLinkMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateFirebaseLinkMethod = AnalyticsAdminServiceGrpc.getCreateFirebaseLinkMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getCreateFirebaseLinkMethod =
              getCreateFirebaseLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.CreateFirebaseLinkRequest,
                          com.google.analytics.admin.v1beta.FirebaseLink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFirebaseLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.CreateFirebaseLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.FirebaseLink.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("CreateFirebaseLink"))
                      .build();
        }
      }
    }
    return getCreateFirebaseLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.DeleteFirebaseLinkRequest, com.google.protobuf.Empty>
      getDeleteFirebaseLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFirebaseLink",
      requestType = com.google.analytics.admin.v1beta.DeleteFirebaseLinkRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.DeleteFirebaseLinkRequest, com.google.protobuf.Empty>
      getDeleteFirebaseLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.DeleteFirebaseLinkRequest, com.google.protobuf.Empty>
        getDeleteFirebaseLinkMethod;
    if ((getDeleteFirebaseLinkMethod = AnalyticsAdminServiceGrpc.getDeleteFirebaseLinkMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeleteFirebaseLinkMethod = AnalyticsAdminServiceGrpc.getDeleteFirebaseLinkMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getDeleteFirebaseLinkMethod =
              getDeleteFirebaseLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.DeleteFirebaseLinkRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteFirebaseLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.DeleteFirebaseLinkRequest
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
          com.google.analytics.admin.v1beta.ListFirebaseLinksRequest,
          com.google.analytics.admin.v1beta.ListFirebaseLinksResponse>
      getListFirebaseLinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFirebaseLinks",
      requestType = com.google.analytics.admin.v1beta.ListFirebaseLinksRequest.class,
      responseType = com.google.analytics.admin.v1beta.ListFirebaseLinksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.ListFirebaseLinksRequest,
          com.google.analytics.admin.v1beta.ListFirebaseLinksResponse>
      getListFirebaseLinksMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.ListFirebaseLinksRequest,
            com.google.analytics.admin.v1beta.ListFirebaseLinksResponse>
        getListFirebaseLinksMethod;
    if ((getListFirebaseLinksMethod = AnalyticsAdminServiceGrpc.getListFirebaseLinksMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListFirebaseLinksMethod = AnalyticsAdminServiceGrpc.getListFirebaseLinksMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getListFirebaseLinksMethod =
              getListFirebaseLinksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.ListFirebaseLinksRequest,
                          com.google.analytics.admin.v1beta.ListFirebaseLinksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFirebaseLinks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.ListFirebaseLinksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.ListFirebaseLinksResponse
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
          com.google.analytics.admin.v1beta.CreateGoogleAdsLinkRequest,
          com.google.analytics.admin.v1beta.GoogleAdsLink>
      getCreateGoogleAdsLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateGoogleAdsLink",
      requestType = com.google.analytics.admin.v1beta.CreateGoogleAdsLinkRequest.class,
      responseType = com.google.analytics.admin.v1beta.GoogleAdsLink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.CreateGoogleAdsLinkRequest,
          com.google.analytics.admin.v1beta.GoogleAdsLink>
      getCreateGoogleAdsLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.CreateGoogleAdsLinkRequest,
            com.google.analytics.admin.v1beta.GoogleAdsLink>
        getCreateGoogleAdsLinkMethod;
    if ((getCreateGoogleAdsLinkMethod = AnalyticsAdminServiceGrpc.getCreateGoogleAdsLinkMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateGoogleAdsLinkMethod = AnalyticsAdminServiceGrpc.getCreateGoogleAdsLinkMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getCreateGoogleAdsLinkMethod =
              getCreateGoogleAdsLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.CreateGoogleAdsLinkRequest,
                          com.google.analytics.admin.v1beta.GoogleAdsLink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateGoogleAdsLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.CreateGoogleAdsLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.GoogleAdsLink.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("CreateGoogleAdsLink"))
                      .build();
        }
      }
    }
    return getCreateGoogleAdsLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.UpdateGoogleAdsLinkRequest,
          com.google.analytics.admin.v1beta.GoogleAdsLink>
      getUpdateGoogleAdsLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateGoogleAdsLink",
      requestType = com.google.analytics.admin.v1beta.UpdateGoogleAdsLinkRequest.class,
      responseType = com.google.analytics.admin.v1beta.GoogleAdsLink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.UpdateGoogleAdsLinkRequest,
          com.google.analytics.admin.v1beta.GoogleAdsLink>
      getUpdateGoogleAdsLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.UpdateGoogleAdsLinkRequest,
            com.google.analytics.admin.v1beta.GoogleAdsLink>
        getUpdateGoogleAdsLinkMethod;
    if ((getUpdateGoogleAdsLinkMethod = AnalyticsAdminServiceGrpc.getUpdateGoogleAdsLinkMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateGoogleAdsLinkMethod = AnalyticsAdminServiceGrpc.getUpdateGoogleAdsLinkMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getUpdateGoogleAdsLinkMethod =
              getUpdateGoogleAdsLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.UpdateGoogleAdsLinkRequest,
                          com.google.analytics.admin.v1beta.GoogleAdsLink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateGoogleAdsLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.UpdateGoogleAdsLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.GoogleAdsLink.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("UpdateGoogleAdsLink"))
                      .build();
        }
      }
    }
    return getUpdateGoogleAdsLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.DeleteGoogleAdsLinkRequest, com.google.protobuf.Empty>
      getDeleteGoogleAdsLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteGoogleAdsLink",
      requestType = com.google.analytics.admin.v1beta.DeleteGoogleAdsLinkRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.DeleteGoogleAdsLinkRequest, com.google.protobuf.Empty>
      getDeleteGoogleAdsLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.DeleteGoogleAdsLinkRequest, com.google.protobuf.Empty>
        getDeleteGoogleAdsLinkMethod;
    if ((getDeleteGoogleAdsLinkMethod = AnalyticsAdminServiceGrpc.getDeleteGoogleAdsLinkMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeleteGoogleAdsLinkMethod = AnalyticsAdminServiceGrpc.getDeleteGoogleAdsLinkMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getDeleteGoogleAdsLinkMethod =
              getDeleteGoogleAdsLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.DeleteGoogleAdsLinkRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteGoogleAdsLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.DeleteGoogleAdsLinkRequest
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
          com.google.analytics.admin.v1beta.ListGoogleAdsLinksRequest,
          com.google.analytics.admin.v1beta.ListGoogleAdsLinksResponse>
      getListGoogleAdsLinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListGoogleAdsLinks",
      requestType = com.google.analytics.admin.v1beta.ListGoogleAdsLinksRequest.class,
      responseType = com.google.analytics.admin.v1beta.ListGoogleAdsLinksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.ListGoogleAdsLinksRequest,
          com.google.analytics.admin.v1beta.ListGoogleAdsLinksResponse>
      getListGoogleAdsLinksMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.ListGoogleAdsLinksRequest,
            com.google.analytics.admin.v1beta.ListGoogleAdsLinksResponse>
        getListGoogleAdsLinksMethod;
    if ((getListGoogleAdsLinksMethod = AnalyticsAdminServiceGrpc.getListGoogleAdsLinksMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListGoogleAdsLinksMethod = AnalyticsAdminServiceGrpc.getListGoogleAdsLinksMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getListGoogleAdsLinksMethod =
              getListGoogleAdsLinksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.ListGoogleAdsLinksRequest,
                          com.google.analytics.admin.v1beta.ListGoogleAdsLinksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListGoogleAdsLinks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.ListGoogleAdsLinksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.ListGoogleAdsLinksResponse
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
          com.google.analytics.admin.v1beta.GetDataSharingSettingsRequest,
          com.google.analytics.admin.v1beta.DataSharingSettings>
      getGetDataSharingSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataSharingSettings",
      requestType = com.google.analytics.admin.v1beta.GetDataSharingSettingsRequest.class,
      responseType = com.google.analytics.admin.v1beta.DataSharingSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.GetDataSharingSettingsRequest,
          com.google.analytics.admin.v1beta.DataSharingSettings>
      getGetDataSharingSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.GetDataSharingSettingsRequest,
            com.google.analytics.admin.v1beta.DataSharingSettings>
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
                      .<com.google.analytics.admin.v1beta.GetDataSharingSettingsRequest,
                          com.google.analytics.admin.v1beta.DataSharingSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetDataSharingSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.GetDataSharingSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.DataSharingSettings
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
          com.google.analytics.admin.v1beta.GetMeasurementProtocolSecretRequest,
          com.google.analytics.admin.v1beta.MeasurementProtocolSecret>
      getGetMeasurementProtocolSecretMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMeasurementProtocolSecret",
      requestType = com.google.analytics.admin.v1beta.GetMeasurementProtocolSecretRequest.class,
      responseType = com.google.analytics.admin.v1beta.MeasurementProtocolSecret.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.GetMeasurementProtocolSecretRequest,
          com.google.analytics.admin.v1beta.MeasurementProtocolSecret>
      getGetMeasurementProtocolSecretMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.GetMeasurementProtocolSecretRequest,
            com.google.analytics.admin.v1beta.MeasurementProtocolSecret>
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
                      .<com.google.analytics.admin.v1beta.GetMeasurementProtocolSecretRequest,
                          com.google.analytics.admin.v1beta.MeasurementProtocolSecret>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetMeasurementProtocolSecret"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.GetMeasurementProtocolSecretRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.MeasurementProtocolSecret
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
          com.google.analytics.admin.v1beta.ListMeasurementProtocolSecretsRequest,
          com.google.analytics.admin.v1beta.ListMeasurementProtocolSecretsResponse>
      getListMeasurementProtocolSecretsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMeasurementProtocolSecrets",
      requestType = com.google.analytics.admin.v1beta.ListMeasurementProtocolSecretsRequest.class,
      responseType = com.google.analytics.admin.v1beta.ListMeasurementProtocolSecretsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.ListMeasurementProtocolSecretsRequest,
          com.google.analytics.admin.v1beta.ListMeasurementProtocolSecretsResponse>
      getListMeasurementProtocolSecretsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.ListMeasurementProtocolSecretsRequest,
            com.google.analytics.admin.v1beta.ListMeasurementProtocolSecretsResponse>
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
                      .<com.google.analytics.admin.v1beta.ListMeasurementProtocolSecretsRequest,
                          com.google.analytics.admin.v1beta.ListMeasurementProtocolSecretsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListMeasurementProtocolSecrets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta
                                  .ListMeasurementProtocolSecretsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta
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
          com.google.analytics.admin.v1beta.CreateMeasurementProtocolSecretRequest,
          com.google.analytics.admin.v1beta.MeasurementProtocolSecret>
      getCreateMeasurementProtocolSecretMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMeasurementProtocolSecret",
      requestType = com.google.analytics.admin.v1beta.CreateMeasurementProtocolSecretRequest.class,
      responseType = com.google.analytics.admin.v1beta.MeasurementProtocolSecret.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.CreateMeasurementProtocolSecretRequest,
          com.google.analytics.admin.v1beta.MeasurementProtocolSecret>
      getCreateMeasurementProtocolSecretMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.CreateMeasurementProtocolSecretRequest,
            com.google.analytics.admin.v1beta.MeasurementProtocolSecret>
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
                      .<com.google.analytics.admin.v1beta.CreateMeasurementProtocolSecretRequest,
                          com.google.analytics.admin.v1beta.MeasurementProtocolSecret>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateMeasurementProtocolSecret"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta
                                  .CreateMeasurementProtocolSecretRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.MeasurementProtocolSecret
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
          com.google.analytics.admin.v1beta.DeleteMeasurementProtocolSecretRequest,
          com.google.protobuf.Empty>
      getDeleteMeasurementProtocolSecretMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMeasurementProtocolSecret",
      requestType = com.google.analytics.admin.v1beta.DeleteMeasurementProtocolSecretRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.DeleteMeasurementProtocolSecretRequest,
          com.google.protobuf.Empty>
      getDeleteMeasurementProtocolSecretMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.DeleteMeasurementProtocolSecretRequest,
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
                      .<com.google.analytics.admin.v1beta.DeleteMeasurementProtocolSecretRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteMeasurementProtocolSecret"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta
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
          com.google.analytics.admin.v1beta.UpdateMeasurementProtocolSecretRequest,
          com.google.analytics.admin.v1beta.MeasurementProtocolSecret>
      getUpdateMeasurementProtocolSecretMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateMeasurementProtocolSecret",
      requestType = com.google.analytics.admin.v1beta.UpdateMeasurementProtocolSecretRequest.class,
      responseType = com.google.analytics.admin.v1beta.MeasurementProtocolSecret.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.UpdateMeasurementProtocolSecretRequest,
          com.google.analytics.admin.v1beta.MeasurementProtocolSecret>
      getUpdateMeasurementProtocolSecretMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.UpdateMeasurementProtocolSecretRequest,
            com.google.analytics.admin.v1beta.MeasurementProtocolSecret>
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
                      .<com.google.analytics.admin.v1beta.UpdateMeasurementProtocolSecretRequest,
                          com.google.analytics.admin.v1beta.MeasurementProtocolSecret>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateMeasurementProtocolSecret"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta
                                  .UpdateMeasurementProtocolSecretRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.MeasurementProtocolSecret
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
          com.google.analytics.admin.v1beta.AcknowledgeUserDataCollectionRequest,
          com.google.analytics.admin.v1beta.AcknowledgeUserDataCollectionResponse>
      getAcknowledgeUserDataCollectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AcknowledgeUserDataCollection",
      requestType = com.google.analytics.admin.v1beta.AcknowledgeUserDataCollectionRequest.class,
      responseType = com.google.analytics.admin.v1beta.AcknowledgeUserDataCollectionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.AcknowledgeUserDataCollectionRequest,
          com.google.analytics.admin.v1beta.AcknowledgeUserDataCollectionResponse>
      getAcknowledgeUserDataCollectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.AcknowledgeUserDataCollectionRequest,
            com.google.analytics.admin.v1beta.AcknowledgeUserDataCollectionResponse>
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
                      .<com.google.analytics.admin.v1beta.AcknowledgeUserDataCollectionRequest,
                          com.google.analytics.admin.v1beta.AcknowledgeUserDataCollectionResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "AcknowledgeUserDataCollection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.AcknowledgeUserDataCollectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta
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
          com.google.analytics.admin.v1beta.SearchChangeHistoryEventsRequest,
          com.google.analytics.admin.v1beta.SearchChangeHistoryEventsResponse>
      getSearchChangeHistoryEventsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchChangeHistoryEvents",
      requestType = com.google.analytics.admin.v1beta.SearchChangeHistoryEventsRequest.class,
      responseType = com.google.analytics.admin.v1beta.SearchChangeHistoryEventsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.SearchChangeHistoryEventsRequest,
          com.google.analytics.admin.v1beta.SearchChangeHistoryEventsResponse>
      getSearchChangeHistoryEventsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.SearchChangeHistoryEventsRequest,
            com.google.analytics.admin.v1beta.SearchChangeHistoryEventsResponse>
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
                      .<com.google.analytics.admin.v1beta.SearchChangeHistoryEventsRequest,
                          com.google.analytics.admin.v1beta.SearchChangeHistoryEventsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SearchChangeHistoryEvents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.SearchChangeHistoryEventsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.SearchChangeHistoryEventsResponse
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
          com.google.analytics.admin.v1beta.CreateConversionEventRequest,
          com.google.analytics.admin.v1beta.ConversionEvent>
      getCreateConversionEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateConversionEvent",
      requestType = com.google.analytics.admin.v1beta.CreateConversionEventRequest.class,
      responseType = com.google.analytics.admin.v1beta.ConversionEvent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.CreateConversionEventRequest,
          com.google.analytics.admin.v1beta.ConversionEvent>
      getCreateConversionEventMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.CreateConversionEventRequest,
            com.google.analytics.admin.v1beta.ConversionEvent>
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
                      .<com.google.analytics.admin.v1beta.CreateConversionEventRequest,
                          com.google.analytics.admin.v1beta.ConversionEvent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateConversionEvent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.CreateConversionEventRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.ConversionEvent
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
          com.google.analytics.admin.v1beta.UpdateConversionEventRequest,
          com.google.analytics.admin.v1beta.ConversionEvent>
      getUpdateConversionEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateConversionEvent",
      requestType = com.google.analytics.admin.v1beta.UpdateConversionEventRequest.class,
      responseType = com.google.analytics.admin.v1beta.ConversionEvent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.UpdateConversionEventRequest,
          com.google.analytics.admin.v1beta.ConversionEvent>
      getUpdateConversionEventMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.UpdateConversionEventRequest,
            com.google.analytics.admin.v1beta.ConversionEvent>
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
                      .<com.google.analytics.admin.v1beta.UpdateConversionEventRequest,
                          com.google.analytics.admin.v1beta.ConversionEvent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateConversionEvent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.UpdateConversionEventRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.ConversionEvent
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
          com.google.analytics.admin.v1beta.GetConversionEventRequest,
          com.google.analytics.admin.v1beta.ConversionEvent>
      getGetConversionEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConversionEvent",
      requestType = com.google.analytics.admin.v1beta.GetConversionEventRequest.class,
      responseType = com.google.analytics.admin.v1beta.ConversionEvent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.GetConversionEventRequest,
          com.google.analytics.admin.v1beta.ConversionEvent>
      getGetConversionEventMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.GetConversionEventRequest,
            com.google.analytics.admin.v1beta.ConversionEvent>
        getGetConversionEventMethod;
    if ((getGetConversionEventMethod = AnalyticsAdminServiceGrpc.getGetConversionEventMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetConversionEventMethod = AnalyticsAdminServiceGrpc.getGetConversionEventMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getGetConversionEventMethod =
              getGetConversionEventMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.GetConversionEventRequest,
                          com.google.analytics.admin.v1beta.ConversionEvent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetConversionEvent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.GetConversionEventRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.ConversionEvent
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
          com.google.analytics.admin.v1beta.DeleteConversionEventRequest, com.google.protobuf.Empty>
      getDeleteConversionEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteConversionEvent",
      requestType = com.google.analytics.admin.v1beta.DeleteConversionEventRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.DeleteConversionEventRequest, com.google.protobuf.Empty>
      getDeleteConversionEventMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.DeleteConversionEventRequest,
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
                      .<com.google.analytics.admin.v1beta.DeleteConversionEventRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteConversionEvent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.DeleteConversionEventRequest
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
          com.google.analytics.admin.v1beta.ListConversionEventsRequest,
          com.google.analytics.admin.v1beta.ListConversionEventsResponse>
      getListConversionEventsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListConversionEvents",
      requestType = com.google.analytics.admin.v1beta.ListConversionEventsRequest.class,
      responseType = com.google.analytics.admin.v1beta.ListConversionEventsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.ListConversionEventsRequest,
          com.google.analytics.admin.v1beta.ListConversionEventsResponse>
      getListConversionEventsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.ListConversionEventsRequest,
            com.google.analytics.admin.v1beta.ListConversionEventsResponse>
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
                      .<com.google.analytics.admin.v1beta.ListConversionEventsRequest,
                          com.google.analytics.admin.v1beta.ListConversionEventsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListConversionEvents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.ListConversionEventsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.ListConversionEventsResponse
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
          com.google.analytics.admin.v1beta.CreateKeyEventRequest,
          com.google.analytics.admin.v1beta.KeyEvent>
      getCreateKeyEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateKeyEvent",
      requestType = com.google.analytics.admin.v1beta.CreateKeyEventRequest.class,
      responseType = com.google.analytics.admin.v1beta.KeyEvent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.CreateKeyEventRequest,
          com.google.analytics.admin.v1beta.KeyEvent>
      getCreateKeyEventMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.CreateKeyEventRequest,
            com.google.analytics.admin.v1beta.KeyEvent>
        getCreateKeyEventMethod;
    if ((getCreateKeyEventMethod = AnalyticsAdminServiceGrpc.getCreateKeyEventMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateKeyEventMethod = AnalyticsAdminServiceGrpc.getCreateKeyEventMethod) == null) {
          AnalyticsAdminServiceGrpc.getCreateKeyEventMethod =
              getCreateKeyEventMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.CreateKeyEventRequest,
                          com.google.analytics.admin.v1beta.KeyEvent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateKeyEvent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.CreateKeyEventRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.KeyEvent.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("CreateKeyEvent"))
                      .build();
        }
      }
    }
    return getCreateKeyEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.UpdateKeyEventRequest,
          com.google.analytics.admin.v1beta.KeyEvent>
      getUpdateKeyEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateKeyEvent",
      requestType = com.google.analytics.admin.v1beta.UpdateKeyEventRequest.class,
      responseType = com.google.analytics.admin.v1beta.KeyEvent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.UpdateKeyEventRequest,
          com.google.analytics.admin.v1beta.KeyEvent>
      getUpdateKeyEventMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.UpdateKeyEventRequest,
            com.google.analytics.admin.v1beta.KeyEvent>
        getUpdateKeyEventMethod;
    if ((getUpdateKeyEventMethod = AnalyticsAdminServiceGrpc.getUpdateKeyEventMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateKeyEventMethod = AnalyticsAdminServiceGrpc.getUpdateKeyEventMethod) == null) {
          AnalyticsAdminServiceGrpc.getUpdateKeyEventMethod =
              getUpdateKeyEventMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.UpdateKeyEventRequest,
                          com.google.analytics.admin.v1beta.KeyEvent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateKeyEvent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.UpdateKeyEventRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.KeyEvent.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("UpdateKeyEvent"))
                      .build();
        }
      }
    }
    return getUpdateKeyEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.GetKeyEventRequest,
          com.google.analytics.admin.v1beta.KeyEvent>
      getGetKeyEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetKeyEvent",
      requestType = com.google.analytics.admin.v1beta.GetKeyEventRequest.class,
      responseType = com.google.analytics.admin.v1beta.KeyEvent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.GetKeyEventRequest,
          com.google.analytics.admin.v1beta.KeyEvent>
      getGetKeyEventMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.GetKeyEventRequest,
            com.google.analytics.admin.v1beta.KeyEvent>
        getGetKeyEventMethod;
    if ((getGetKeyEventMethod = AnalyticsAdminServiceGrpc.getGetKeyEventMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetKeyEventMethod = AnalyticsAdminServiceGrpc.getGetKeyEventMethod) == null) {
          AnalyticsAdminServiceGrpc.getGetKeyEventMethod =
              getGetKeyEventMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.GetKeyEventRequest,
                          com.google.analytics.admin.v1beta.KeyEvent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetKeyEvent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.GetKeyEventRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.KeyEvent.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("GetKeyEvent"))
                      .build();
        }
      }
    }
    return getGetKeyEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.DeleteKeyEventRequest, com.google.protobuf.Empty>
      getDeleteKeyEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteKeyEvent",
      requestType = com.google.analytics.admin.v1beta.DeleteKeyEventRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.DeleteKeyEventRequest, com.google.protobuf.Empty>
      getDeleteKeyEventMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.DeleteKeyEventRequest, com.google.protobuf.Empty>
        getDeleteKeyEventMethod;
    if ((getDeleteKeyEventMethod = AnalyticsAdminServiceGrpc.getDeleteKeyEventMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeleteKeyEventMethod = AnalyticsAdminServiceGrpc.getDeleteKeyEventMethod) == null) {
          AnalyticsAdminServiceGrpc.getDeleteKeyEventMethod =
              getDeleteKeyEventMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.DeleteKeyEventRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteKeyEvent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.DeleteKeyEventRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("DeleteKeyEvent"))
                      .build();
        }
      }
    }
    return getDeleteKeyEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.ListKeyEventsRequest,
          com.google.analytics.admin.v1beta.ListKeyEventsResponse>
      getListKeyEventsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListKeyEvents",
      requestType = com.google.analytics.admin.v1beta.ListKeyEventsRequest.class,
      responseType = com.google.analytics.admin.v1beta.ListKeyEventsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.ListKeyEventsRequest,
          com.google.analytics.admin.v1beta.ListKeyEventsResponse>
      getListKeyEventsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.ListKeyEventsRequest,
            com.google.analytics.admin.v1beta.ListKeyEventsResponse>
        getListKeyEventsMethod;
    if ((getListKeyEventsMethod = AnalyticsAdminServiceGrpc.getListKeyEventsMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListKeyEventsMethod = AnalyticsAdminServiceGrpc.getListKeyEventsMethod) == null) {
          AnalyticsAdminServiceGrpc.getListKeyEventsMethod =
              getListKeyEventsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.ListKeyEventsRequest,
                          com.google.analytics.admin.v1beta.ListKeyEventsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListKeyEvents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.ListKeyEventsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.ListKeyEventsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("ListKeyEvents"))
                      .build();
        }
      }
    }
    return getListKeyEventsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.CreateCustomDimensionRequest,
          com.google.analytics.admin.v1beta.CustomDimension>
      getCreateCustomDimensionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCustomDimension",
      requestType = com.google.analytics.admin.v1beta.CreateCustomDimensionRequest.class,
      responseType = com.google.analytics.admin.v1beta.CustomDimension.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.CreateCustomDimensionRequest,
          com.google.analytics.admin.v1beta.CustomDimension>
      getCreateCustomDimensionMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.CreateCustomDimensionRequest,
            com.google.analytics.admin.v1beta.CustomDimension>
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
                      .<com.google.analytics.admin.v1beta.CreateCustomDimensionRequest,
                          com.google.analytics.admin.v1beta.CustomDimension>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateCustomDimension"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.CreateCustomDimensionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.CustomDimension
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
          com.google.analytics.admin.v1beta.UpdateCustomDimensionRequest,
          com.google.analytics.admin.v1beta.CustomDimension>
      getUpdateCustomDimensionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCustomDimension",
      requestType = com.google.analytics.admin.v1beta.UpdateCustomDimensionRequest.class,
      responseType = com.google.analytics.admin.v1beta.CustomDimension.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.UpdateCustomDimensionRequest,
          com.google.analytics.admin.v1beta.CustomDimension>
      getUpdateCustomDimensionMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.UpdateCustomDimensionRequest,
            com.google.analytics.admin.v1beta.CustomDimension>
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
                      .<com.google.analytics.admin.v1beta.UpdateCustomDimensionRequest,
                          com.google.analytics.admin.v1beta.CustomDimension>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateCustomDimension"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.UpdateCustomDimensionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.CustomDimension
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
          com.google.analytics.admin.v1beta.ListCustomDimensionsRequest,
          com.google.analytics.admin.v1beta.ListCustomDimensionsResponse>
      getListCustomDimensionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCustomDimensions",
      requestType = com.google.analytics.admin.v1beta.ListCustomDimensionsRequest.class,
      responseType = com.google.analytics.admin.v1beta.ListCustomDimensionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.ListCustomDimensionsRequest,
          com.google.analytics.admin.v1beta.ListCustomDimensionsResponse>
      getListCustomDimensionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.ListCustomDimensionsRequest,
            com.google.analytics.admin.v1beta.ListCustomDimensionsResponse>
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
                      .<com.google.analytics.admin.v1beta.ListCustomDimensionsRequest,
                          com.google.analytics.admin.v1beta.ListCustomDimensionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListCustomDimensions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.ListCustomDimensionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.ListCustomDimensionsResponse
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
          com.google.analytics.admin.v1beta.ArchiveCustomDimensionRequest,
          com.google.protobuf.Empty>
      getArchiveCustomDimensionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ArchiveCustomDimension",
      requestType = com.google.analytics.admin.v1beta.ArchiveCustomDimensionRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.ArchiveCustomDimensionRequest,
          com.google.protobuf.Empty>
      getArchiveCustomDimensionMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.ArchiveCustomDimensionRequest,
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
                      .<com.google.analytics.admin.v1beta.ArchiveCustomDimensionRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ArchiveCustomDimension"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.ArchiveCustomDimensionRequest
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
          com.google.analytics.admin.v1beta.GetCustomDimensionRequest,
          com.google.analytics.admin.v1beta.CustomDimension>
      getGetCustomDimensionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCustomDimension",
      requestType = com.google.analytics.admin.v1beta.GetCustomDimensionRequest.class,
      responseType = com.google.analytics.admin.v1beta.CustomDimension.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.GetCustomDimensionRequest,
          com.google.analytics.admin.v1beta.CustomDimension>
      getGetCustomDimensionMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.GetCustomDimensionRequest,
            com.google.analytics.admin.v1beta.CustomDimension>
        getGetCustomDimensionMethod;
    if ((getGetCustomDimensionMethod = AnalyticsAdminServiceGrpc.getGetCustomDimensionMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetCustomDimensionMethod = AnalyticsAdminServiceGrpc.getGetCustomDimensionMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getGetCustomDimensionMethod =
              getGetCustomDimensionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.GetCustomDimensionRequest,
                          com.google.analytics.admin.v1beta.CustomDimension>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCustomDimension"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.GetCustomDimensionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.CustomDimension
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
          com.google.analytics.admin.v1beta.CreateCustomMetricRequest,
          com.google.analytics.admin.v1beta.CustomMetric>
      getCreateCustomMetricMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCustomMetric",
      requestType = com.google.analytics.admin.v1beta.CreateCustomMetricRequest.class,
      responseType = com.google.analytics.admin.v1beta.CustomMetric.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.CreateCustomMetricRequest,
          com.google.analytics.admin.v1beta.CustomMetric>
      getCreateCustomMetricMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.CreateCustomMetricRequest,
            com.google.analytics.admin.v1beta.CustomMetric>
        getCreateCustomMetricMethod;
    if ((getCreateCustomMetricMethod = AnalyticsAdminServiceGrpc.getCreateCustomMetricMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateCustomMetricMethod = AnalyticsAdminServiceGrpc.getCreateCustomMetricMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getCreateCustomMetricMethod =
              getCreateCustomMetricMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.CreateCustomMetricRequest,
                          com.google.analytics.admin.v1beta.CustomMetric>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCustomMetric"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.CreateCustomMetricRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.CustomMetric.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("CreateCustomMetric"))
                      .build();
        }
      }
    }
    return getCreateCustomMetricMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.UpdateCustomMetricRequest,
          com.google.analytics.admin.v1beta.CustomMetric>
      getUpdateCustomMetricMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCustomMetric",
      requestType = com.google.analytics.admin.v1beta.UpdateCustomMetricRequest.class,
      responseType = com.google.analytics.admin.v1beta.CustomMetric.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.UpdateCustomMetricRequest,
          com.google.analytics.admin.v1beta.CustomMetric>
      getUpdateCustomMetricMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.UpdateCustomMetricRequest,
            com.google.analytics.admin.v1beta.CustomMetric>
        getUpdateCustomMetricMethod;
    if ((getUpdateCustomMetricMethod = AnalyticsAdminServiceGrpc.getUpdateCustomMetricMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateCustomMetricMethod = AnalyticsAdminServiceGrpc.getUpdateCustomMetricMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getUpdateCustomMetricMethod =
              getUpdateCustomMetricMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.UpdateCustomMetricRequest,
                          com.google.analytics.admin.v1beta.CustomMetric>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCustomMetric"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.UpdateCustomMetricRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.CustomMetric.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("UpdateCustomMetric"))
                      .build();
        }
      }
    }
    return getUpdateCustomMetricMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.ListCustomMetricsRequest,
          com.google.analytics.admin.v1beta.ListCustomMetricsResponse>
      getListCustomMetricsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCustomMetrics",
      requestType = com.google.analytics.admin.v1beta.ListCustomMetricsRequest.class,
      responseType = com.google.analytics.admin.v1beta.ListCustomMetricsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.ListCustomMetricsRequest,
          com.google.analytics.admin.v1beta.ListCustomMetricsResponse>
      getListCustomMetricsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.ListCustomMetricsRequest,
            com.google.analytics.admin.v1beta.ListCustomMetricsResponse>
        getListCustomMetricsMethod;
    if ((getListCustomMetricsMethod = AnalyticsAdminServiceGrpc.getListCustomMetricsMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListCustomMetricsMethod = AnalyticsAdminServiceGrpc.getListCustomMetricsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getListCustomMetricsMethod =
              getListCustomMetricsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.ListCustomMetricsRequest,
                          com.google.analytics.admin.v1beta.ListCustomMetricsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCustomMetrics"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.ListCustomMetricsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.ListCustomMetricsResponse
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
          com.google.analytics.admin.v1beta.ArchiveCustomMetricRequest, com.google.protobuf.Empty>
      getArchiveCustomMetricMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ArchiveCustomMetric",
      requestType = com.google.analytics.admin.v1beta.ArchiveCustomMetricRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.ArchiveCustomMetricRequest, com.google.protobuf.Empty>
      getArchiveCustomMetricMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.ArchiveCustomMetricRequest, com.google.protobuf.Empty>
        getArchiveCustomMetricMethod;
    if ((getArchiveCustomMetricMethod = AnalyticsAdminServiceGrpc.getArchiveCustomMetricMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getArchiveCustomMetricMethod = AnalyticsAdminServiceGrpc.getArchiveCustomMetricMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getArchiveCustomMetricMethod =
              getArchiveCustomMetricMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.ArchiveCustomMetricRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ArchiveCustomMetric"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.ArchiveCustomMetricRequest
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
          com.google.analytics.admin.v1beta.GetCustomMetricRequest,
          com.google.analytics.admin.v1beta.CustomMetric>
      getGetCustomMetricMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCustomMetric",
      requestType = com.google.analytics.admin.v1beta.GetCustomMetricRequest.class,
      responseType = com.google.analytics.admin.v1beta.CustomMetric.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.GetCustomMetricRequest,
          com.google.analytics.admin.v1beta.CustomMetric>
      getGetCustomMetricMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.GetCustomMetricRequest,
            com.google.analytics.admin.v1beta.CustomMetric>
        getGetCustomMetricMethod;
    if ((getGetCustomMetricMethod = AnalyticsAdminServiceGrpc.getGetCustomMetricMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetCustomMetricMethod = AnalyticsAdminServiceGrpc.getGetCustomMetricMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getGetCustomMetricMethod =
              getGetCustomMetricMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.GetCustomMetricRequest,
                          com.google.analytics.admin.v1beta.CustomMetric>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCustomMetric"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.GetCustomMetricRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.CustomMetric.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("GetCustomMetric"))
                      .build();
        }
      }
    }
    return getGetCustomMetricMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.GetDataRetentionSettingsRequest,
          com.google.analytics.admin.v1beta.DataRetentionSettings>
      getGetDataRetentionSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataRetentionSettings",
      requestType = com.google.analytics.admin.v1beta.GetDataRetentionSettingsRequest.class,
      responseType = com.google.analytics.admin.v1beta.DataRetentionSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.GetDataRetentionSettingsRequest,
          com.google.analytics.admin.v1beta.DataRetentionSettings>
      getGetDataRetentionSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.GetDataRetentionSettingsRequest,
            com.google.analytics.admin.v1beta.DataRetentionSettings>
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
                      .<com.google.analytics.admin.v1beta.GetDataRetentionSettingsRequest,
                          com.google.analytics.admin.v1beta.DataRetentionSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetDataRetentionSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.GetDataRetentionSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.DataRetentionSettings
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
          com.google.analytics.admin.v1beta.UpdateDataRetentionSettingsRequest,
          com.google.analytics.admin.v1beta.DataRetentionSettings>
      getUpdateDataRetentionSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDataRetentionSettings",
      requestType = com.google.analytics.admin.v1beta.UpdateDataRetentionSettingsRequest.class,
      responseType = com.google.analytics.admin.v1beta.DataRetentionSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.UpdateDataRetentionSettingsRequest,
          com.google.analytics.admin.v1beta.DataRetentionSettings>
      getUpdateDataRetentionSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.UpdateDataRetentionSettingsRequest,
            com.google.analytics.admin.v1beta.DataRetentionSettings>
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
                      .<com.google.analytics.admin.v1beta.UpdateDataRetentionSettingsRequest,
                          com.google.analytics.admin.v1beta.DataRetentionSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateDataRetentionSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.UpdateDataRetentionSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.DataRetentionSettings
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
          com.google.analytics.admin.v1beta.CreateDataStreamRequest,
          com.google.analytics.admin.v1beta.DataStream>
      getCreateDataStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDataStream",
      requestType = com.google.analytics.admin.v1beta.CreateDataStreamRequest.class,
      responseType = com.google.analytics.admin.v1beta.DataStream.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.CreateDataStreamRequest,
          com.google.analytics.admin.v1beta.DataStream>
      getCreateDataStreamMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.CreateDataStreamRequest,
            com.google.analytics.admin.v1beta.DataStream>
        getCreateDataStreamMethod;
    if ((getCreateDataStreamMethod = AnalyticsAdminServiceGrpc.getCreateDataStreamMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateDataStreamMethod = AnalyticsAdminServiceGrpc.getCreateDataStreamMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getCreateDataStreamMethod =
              getCreateDataStreamMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.CreateDataStreamRequest,
                          com.google.analytics.admin.v1beta.DataStream>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDataStream"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.CreateDataStreamRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.DataStream.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("CreateDataStream"))
                      .build();
        }
      }
    }
    return getCreateDataStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.DeleteDataStreamRequest, com.google.protobuf.Empty>
      getDeleteDataStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDataStream",
      requestType = com.google.analytics.admin.v1beta.DeleteDataStreamRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.DeleteDataStreamRequest, com.google.protobuf.Empty>
      getDeleteDataStreamMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.DeleteDataStreamRequest, com.google.protobuf.Empty>
        getDeleteDataStreamMethod;
    if ((getDeleteDataStreamMethod = AnalyticsAdminServiceGrpc.getDeleteDataStreamMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeleteDataStreamMethod = AnalyticsAdminServiceGrpc.getDeleteDataStreamMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getDeleteDataStreamMethod =
              getDeleteDataStreamMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.DeleteDataStreamRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDataStream"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.DeleteDataStreamRequest
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
          com.google.analytics.admin.v1beta.UpdateDataStreamRequest,
          com.google.analytics.admin.v1beta.DataStream>
      getUpdateDataStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDataStream",
      requestType = com.google.analytics.admin.v1beta.UpdateDataStreamRequest.class,
      responseType = com.google.analytics.admin.v1beta.DataStream.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.UpdateDataStreamRequest,
          com.google.analytics.admin.v1beta.DataStream>
      getUpdateDataStreamMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.UpdateDataStreamRequest,
            com.google.analytics.admin.v1beta.DataStream>
        getUpdateDataStreamMethod;
    if ((getUpdateDataStreamMethod = AnalyticsAdminServiceGrpc.getUpdateDataStreamMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateDataStreamMethod = AnalyticsAdminServiceGrpc.getUpdateDataStreamMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getUpdateDataStreamMethod =
              getUpdateDataStreamMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.UpdateDataStreamRequest,
                          com.google.analytics.admin.v1beta.DataStream>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDataStream"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.UpdateDataStreamRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.DataStream.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("UpdateDataStream"))
                      .build();
        }
      }
    }
    return getUpdateDataStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.ListDataStreamsRequest,
          com.google.analytics.admin.v1beta.ListDataStreamsResponse>
      getListDataStreamsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDataStreams",
      requestType = com.google.analytics.admin.v1beta.ListDataStreamsRequest.class,
      responseType = com.google.analytics.admin.v1beta.ListDataStreamsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.ListDataStreamsRequest,
          com.google.analytics.admin.v1beta.ListDataStreamsResponse>
      getListDataStreamsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.ListDataStreamsRequest,
            com.google.analytics.admin.v1beta.ListDataStreamsResponse>
        getListDataStreamsMethod;
    if ((getListDataStreamsMethod = AnalyticsAdminServiceGrpc.getListDataStreamsMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListDataStreamsMethod = AnalyticsAdminServiceGrpc.getListDataStreamsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getListDataStreamsMethod =
              getListDataStreamsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.ListDataStreamsRequest,
                          com.google.analytics.admin.v1beta.ListDataStreamsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDataStreams"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.ListDataStreamsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.ListDataStreamsResponse
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
          com.google.analytics.admin.v1beta.GetDataStreamRequest,
          com.google.analytics.admin.v1beta.DataStream>
      getGetDataStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataStream",
      requestType = com.google.analytics.admin.v1beta.GetDataStreamRequest.class,
      responseType = com.google.analytics.admin.v1beta.DataStream.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.GetDataStreamRequest,
          com.google.analytics.admin.v1beta.DataStream>
      getGetDataStreamMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.GetDataStreamRequest,
            com.google.analytics.admin.v1beta.DataStream>
        getGetDataStreamMethod;
    if ((getGetDataStreamMethod = AnalyticsAdminServiceGrpc.getGetDataStreamMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetDataStreamMethod = AnalyticsAdminServiceGrpc.getGetDataStreamMethod) == null) {
          AnalyticsAdminServiceGrpc.getGetDataStreamMethod =
              getGetDataStreamMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.GetDataStreamRequest,
                          com.google.analytics.admin.v1beta.DataStream>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataStream"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.GetDataStreamRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.DataStream.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("GetDataStream"))
                      .build();
        }
      }
    }
    return getGetDataStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.RunAccessReportRequest,
          com.google.analytics.admin.v1beta.RunAccessReportResponse>
      getRunAccessReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RunAccessReport",
      requestType = com.google.analytics.admin.v1beta.RunAccessReportRequest.class,
      responseType = com.google.analytics.admin.v1beta.RunAccessReportResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1beta.RunAccessReportRequest,
          com.google.analytics.admin.v1beta.RunAccessReportResponse>
      getRunAccessReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1beta.RunAccessReportRequest,
            com.google.analytics.admin.v1beta.RunAccessReportResponse>
        getRunAccessReportMethod;
    if ((getRunAccessReportMethod = AnalyticsAdminServiceGrpc.getRunAccessReportMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getRunAccessReportMethod = AnalyticsAdminServiceGrpc.getRunAccessReportMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getRunAccessReportMethod =
              getRunAccessReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1beta.RunAccessReportRequest,
                          com.google.analytics.admin.v1beta.RunAccessReportResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RunAccessReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.RunAccessReportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1beta.RunAccessReportResponse
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
   * Service Interface for the Google Analytics Admin API.
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
        com.google.analytics.admin.v1beta.GetAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.Account> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAccountMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns all accounts accessible by the caller.
     * Note that these accounts might not currently have GA properties.
     * Soft-deleted (ie: "trashed") accounts are excluded by default.
     * Returns an empty list if no relevant accounts are found.
     * </pre>
     */
    default void listAccounts(
        com.google.analytics.admin.v1beta.ListAccountsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.ListAccountsResponse>
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
        com.google.analytics.admin.v1beta.DeleteAccountRequest request,
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
        com.google.analytics.admin.v1beta.UpdateAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.Account> responseObserver) {
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
        com.google.analytics.admin.v1beta.ProvisionAccountTicketRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1beta.ProvisionAccountTicketResponse>
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
        com.google.analytics.admin.v1beta.ListAccountSummariesRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.ListAccountSummariesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAccountSummariesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single GA Property.
     * </pre>
     */
    default void getProperty(
        com.google.analytics.admin.v1beta.GetPropertyRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.Property> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetPropertyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns child Properties under the specified parent Account.
     * Properties will be excluded if the caller does not have access.
     * Soft-deleted (ie: "trashed") properties are excluded by default.
     * Returns an empty list if no relevant properties are found.
     * </pre>
     */
    default void listProperties(
        com.google.analytics.admin.v1beta.ListPropertiesRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.ListPropertiesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPropertiesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Google Analytics property with the specified location and
     * attributes.
     * </pre>
     */
    default void createProperty(
        com.google.analytics.admin.v1beta.CreatePropertyRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.Property> responseObserver) {
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
     * Returns an error if the target is not found.
     * </pre>
     */
    default void deleteProperty(
        com.google.analytics.admin.v1beta.DeletePropertyRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.Property> responseObserver) {
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
        com.google.analytics.admin.v1beta.UpdatePropertyRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.Property> responseObserver) {
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
        com.google.analytics.admin.v1beta.CreateFirebaseLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.FirebaseLink>
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
        com.google.analytics.admin.v1beta.DeleteFirebaseLinkRequest request,
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
        com.google.analytics.admin.v1beta.ListFirebaseLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.ListFirebaseLinksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListFirebaseLinksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a GoogleAdsLink.
     * </pre>
     */
    default void createGoogleAdsLink(
        com.google.analytics.admin.v1beta.CreateGoogleAdsLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.GoogleAdsLink>
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
        com.google.analytics.admin.v1beta.UpdateGoogleAdsLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.GoogleAdsLink>
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
        com.google.analytics.admin.v1beta.DeleteGoogleAdsLinkRequest request,
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
        com.google.analytics.admin.v1beta.ListGoogleAdsLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.ListGoogleAdsLinksResponse>
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
        com.google.analytics.admin.v1beta.GetDataSharingSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.DataSharingSettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDataSharingSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single MeasurementProtocolSecret.
     * </pre>
     */
    default void getMeasurementProtocolSecret(
        com.google.analytics.admin.v1beta.GetMeasurementProtocolSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.MeasurementProtocolSecret>
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
        com.google.analytics.admin.v1beta.ListMeasurementProtocolSecretsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1beta.ListMeasurementProtocolSecretsResponse>
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
        com.google.analytics.admin.v1beta.CreateMeasurementProtocolSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.MeasurementProtocolSecret>
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
        com.google.analytics.admin.v1beta.DeleteMeasurementProtocolSecretRequest request,
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
        com.google.analytics.admin.v1beta.UpdateMeasurementProtocolSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.MeasurementProtocolSecret>
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
        com.google.analytics.admin.v1beta.AcknowledgeUserDataCollectionRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1beta.AcknowledgeUserDataCollectionResponse>
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
     * Only returns the subset of changes supported by the API. The UI may return
     * additional changes.
     * </pre>
     */
    default void searchChangeHistoryEvents(
        com.google.analytics.admin.v1beta.SearchChangeHistoryEventsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1beta.SearchChangeHistoryEventsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchChangeHistoryEventsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use `CreateKeyEvent` instead.
     * Creates a conversion event with the specified attributes.
     * </pre>
     */
    @java.lang.Deprecated
    default void createConversionEvent(
        com.google.analytics.admin.v1beta.CreateConversionEventRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.ConversionEvent>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateConversionEventMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use `UpdateKeyEvent` instead.
     * Updates a conversion event with the specified attributes.
     * </pre>
     */
    @java.lang.Deprecated
    default void updateConversionEvent(
        com.google.analytics.admin.v1beta.UpdateConversionEventRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.ConversionEvent>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateConversionEventMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use `GetKeyEvent` instead.
     * Retrieve a single conversion event.
     * </pre>
     */
    @java.lang.Deprecated
    default void getConversionEvent(
        com.google.analytics.admin.v1beta.GetConversionEventRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.ConversionEvent>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetConversionEventMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use `DeleteKeyEvent` instead.
     * Deletes a conversion event in a property.
     * </pre>
     */
    @java.lang.Deprecated
    default void deleteConversionEvent(
        com.google.analytics.admin.v1beta.DeleteConversionEventRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteConversionEventMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use `ListKeyEvents` instead.
     * Returns a list of conversion events in the specified parent property.
     * Returns an empty list if no conversion events are found.
     * </pre>
     */
    @java.lang.Deprecated
    default void listConversionEvents(
        com.google.analytics.admin.v1beta.ListConversionEventsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.ListConversionEventsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListConversionEventsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Key Event.
     * </pre>
     */
    default void createKeyEvent(
        com.google.analytics.admin.v1beta.CreateKeyEventRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.KeyEvent> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateKeyEventMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a Key Event.
     * </pre>
     */
    default void updateKeyEvent(
        com.google.analytics.admin.v1beta.UpdateKeyEventRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.KeyEvent> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateKeyEventMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single Key Event.
     * </pre>
     */
    default void getKeyEvent(
        com.google.analytics.admin.v1beta.GetKeyEventRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.KeyEvent> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetKeyEventMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Key Event.
     * </pre>
     */
    default void deleteKeyEvent(
        com.google.analytics.admin.v1beta.DeleteKeyEventRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteKeyEventMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of Key Events in the specified parent property.
     * Returns an empty list if no Key Events are found.
     * </pre>
     */
    default void listKeyEvents(
        com.google.analytics.admin.v1beta.ListKeyEventsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.ListKeyEventsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListKeyEventsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a CustomDimension.
     * </pre>
     */
    default void createCustomDimension(
        com.google.analytics.admin.v1beta.CreateCustomDimensionRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.CustomDimension>
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
        com.google.analytics.admin.v1beta.UpdateCustomDimensionRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.CustomDimension>
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
        com.google.analytics.admin.v1beta.ListCustomDimensionsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.ListCustomDimensionsResponse>
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
        com.google.analytics.admin.v1beta.ArchiveCustomDimensionRequest request,
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
        com.google.analytics.admin.v1beta.GetCustomDimensionRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.CustomDimension>
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
        com.google.analytics.admin.v1beta.CreateCustomMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.CustomMetric>
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
        com.google.analytics.admin.v1beta.UpdateCustomMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.CustomMetric>
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
        com.google.analytics.admin.v1beta.ListCustomMetricsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.ListCustomMetricsResponse>
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
        com.google.analytics.admin.v1beta.ArchiveCustomMetricRequest request,
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
        com.google.analytics.admin.v1beta.GetCustomMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.CustomMetric>
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
        com.google.analytics.admin.v1beta.GetDataRetentionSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.DataRetentionSettings>
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
        com.google.analytics.admin.v1beta.UpdateDataRetentionSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.DataRetentionSettings>
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
        com.google.analytics.admin.v1beta.CreateDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.DataStream>
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
        com.google.analytics.admin.v1beta.DeleteDataStreamRequest request,
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
        com.google.analytics.admin.v1beta.UpdateDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.DataStream>
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
        com.google.analytics.admin.v1beta.ListDataStreamsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.ListDataStreamsResponse>
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
        com.google.analytics.admin.v1beta.GetDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.DataStream>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDataStreamMethod(), responseObserver);
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
     * These data access records include GA UI Reporting, GA UI Explorations,
     * GA Data API, and other products like Firebase &amp; Admob that can retrieve
     * data from Google Analytics through a linkage. These records don't include
     * property configuration changes like adding a stream or changing a
     * property's time zone. For configuration change history, see
     * [searchChangeHistoryEvents](https://developers.google.com/analytics/devguides/config/admin/v1/rest/v1alpha/accounts/searchChangeHistoryEvents).
     * To give your feedback on this API, complete the [Google Analytics Access
     * Reports
     * feedback](https://docs.google.com/forms/d/e/1FAIpQLSdmEBUrMzAEdiEKk5TV5dEHvDUZDRlgWYdQdAeSdtR4hVjEhw/viewform)
     * form.
     * </pre>
     */
    default void runAccessReport(
        com.google.analytics.admin.v1beta.RunAccessReportRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.RunAccessReportResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRunAccessReportMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AnalyticsAdminService.
   *
   * <pre>
   * Service Interface for the Google Analytics Admin API.
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
   * Service Interface for the Google Analytics Admin API.
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
        com.google.analytics.admin.v1beta.GetAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.Account> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns all accounts accessible by the caller.
     * Note that these accounts might not currently have GA properties.
     * Soft-deleted (ie: "trashed") accounts are excluded by default.
     * Returns an empty list if no relevant accounts are found.
     * </pre>
     */
    public void listAccounts(
        com.google.analytics.admin.v1beta.ListAccountsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.ListAccountsResponse>
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
        com.google.analytics.admin.v1beta.DeleteAccountRequest request,
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
        com.google.analytics.admin.v1beta.UpdateAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.Account> responseObserver) {
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
        com.google.analytics.admin.v1beta.ProvisionAccountTicketRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1beta.ProvisionAccountTicketResponse>
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
        com.google.analytics.admin.v1beta.ListAccountSummariesRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.ListAccountSummariesResponse>
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
     * Lookup for a single GA Property.
     * </pre>
     */
    public void getProperty(
        com.google.analytics.admin.v1beta.GetPropertyRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.Property> responseObserver) {
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
     * Properties will be excluded if the caller does not have access.
     * Soft-deleted (ie: "trashed") properties are excluded by default.
     * Returns an empty list if no relevant properties are found.
     * </pre>
     */
    public void listProperties(
        com.google.analytics.admin.v1beta.ListPropertiesRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.ListPropertiesResponse>
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
     * Creates a Google Analytics property with the specified location and
     * attributes.
     * </pre>
     */
    public void createProperty(
        com.google.analytics.admin.v1beta.CreatePropertyRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.Property> responseObserver) {
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
     * Returns an error if the target is not found.
     * </pre>
     */
    public void deleteProperty(
        com.google.analytics.admin.v1beta.DeletePropertyRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.Property> responseObserver) {
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
        com.google.analytics.admin.v1beta.UpdatePropertyRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.Property> responseObserver) {
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
        com.google.analytics.admin.v1beta.CreateFirebaseLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.FirebaseLink>
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
        com.google.analytics.admin.v1beta.DeleteFirebaseLinkRequest request,
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
        com.google.analytics.admin.v1beta.ListFirebaseLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.ListFirebaseLinksResponse>
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
     * Creates a GoogleAdsLink.
     * </pre>
     */
    public void createGoogleAdsLink(
        com.google.analytics.admin.v1beta.CreateGoogleAdsLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.GoogleAdsLink>
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
        com.google.analytics.admin.v1beta.UpdateGoogleAdsLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.GoogleAdsLink>
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
        com.google.analytics.admin.v1beta.DeleteGoogleAdsLinkRequest request,
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
        com.google.analytics.admin.v1beta.ListGoogleAdsLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.ListGoogleAdsLinksResponse>
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
        com.google.analytics.admin.v1beta.GetDataSharingSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.DataSharingSettings>
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
     * Lookup for a single MeasurementProtocolSecret.
     * </pre>
     */
    public void getMeasurementProtocolSecret(
        com.google.analytics.admin.v1beta.GetMeasurementProtocolSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.MeasurementProtocolSecret>
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
        com.google.analytics.admin.v1beta.ListMeasurementProtocolSecretsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1beta.ListMeasurementProtocolSecretsResponse>
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
        com.google.analytics.admin.v1beta.CreateMeasurementProtocolSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.MeasurementProtocolSecret>
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
        com.google.analytics.admin.v1beta.DeleteMeasurementProtocolSecretRequest request,
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
        com.google.analytics.admin.v1beta.UpdateMeasurementProtocolSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.MeasurementProtocolSecret>
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
        com.google.analytics.admin.v1beta.AcknowledgeUserDataCollectionRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1beta.AcknowledgeUserDataCollectionResponse>
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
     * Only returns the subset of changes supported by the API. The UI may return
     * additional changes.
     * </pre>
     */
    public void searchChangeHistoryEvents(
        com.google.analytics.admin.v1beta.SearchChangeHistoryEventsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1beta.SearchChangeHistoryEventsResponse>
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
     * Deprecated: Use `CreateKeyEvent` instead.
     * Creates a conversion event with the specified attributes.
     * </pre>
     */
    @java.lang.Deprecated
    public void createConversionEvent(
        com.google.analytics.admin.v1beta.CreateConversionEventRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.ConversionEvent>
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
     * Deprecated: Use `UpdateKeyEvent` instead.
     * Updates a conversion event with the specified attributes.
     * </pre>
     */
    @java.lang.Deprecated
    public void updateConversionEvent(
        com.google.analytics.admin.v1beta.UpdateConversionEventRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.ConversionEvent>
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
     * Deprecated: Use `GetKeyEvent` instead.
     * Retrieve a single conversion event.
     * </pre>
     */
    @java.lang.Deprecated
    public void getConversionEvent(
        com.google.analytics.admin.v1beta.GetConversionEventRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.ConversionEvent>
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
     * Deprecated: Use `DeleteKeyEvent` instead.
     * Deletes a conversion event in a property.
     * </pre>
     */
    @java.lang.Deprecated
    public void deleteConversionEvent(
        com.google.analytics.admin.v1beta.DeleteConversionEventRequest request,
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
     * Deprecated: Use `ListKeyEvents` instead.
     * Returns a list of conversion events in the specified parent property.
     * Returns an empty list if no conversion events are found.
     * </pre>
     */
    @java.lang.Deprecated
    public void listConversionEvents(
        com.google.analytics.admin.v1beta.ListConversionEventsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.ListConversionEventsResponse>
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
     * Creates a Key Event.
     * </pre>
     */
    public void createKeyEvent(
        com.google.analytics.admin.v1beta.CreateKeyEventRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.KeyEvent> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateKeyEventMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a Key Event.
     * </pre>
     */
    public void updateKeyEvent(
        com.google.analytics.admin.v1beta.UpdateKeyEventRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.KeyEvent> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateKeyEventMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single Key Event.
     * </pre>
     */
    public void getKeyEvent(
        com.google.analytics.admin.v1beta.GetKeyEventRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.KeyEvent> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetKeyEventMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Key Event.
     * </pre>
     */
    public void deleteKeyEvent(
        com.google.analytics.admin.v1beta.DeleteKeyEventRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteKeyEventMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of Key Events in the specified parent property.
     * Returns an empty list if no Key Events are found.
     * </pre>
     */
    public void listKeyEvents(
        com.google.analytics.admin.v1beta.ListKeyEventsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.ListKeyEventsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListKeyEventsMethod(), getCallOptions()),
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
        com.google.analytics.admin.v1beta.CreateCustomDimensionRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.CustomDimension>
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
        com.google.analytics.admin.v1beta.UpdateCustomDimensionRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.CustomDimension>
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
        com.google.analytics.admin.v1beta.ListCustomDimensionsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.ListCustomDimensionsResponse>
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
        com.google.analytics.admin.v1beta.ArchiveCustomDimensionRequest request,
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
        com.google.analytics.admin.v1beta.GetCustomDimensionRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.CustomDimension>
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
        com.google.analytics.admin.v1beta.CreateCustomMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.CustomMetric>
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
        com.google.analytics.admin.v1beta.UpdateCustomMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.CustomMetric>
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
        com.google.analytics.admin.v1beta.ListCustomMetricsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.ListCustomMetricsResponse>
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
        com.google.analytics.admin.v1beta.ArchiveCustomMetricRequest request,
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
        com.google.analytics.admin.v1beta.GetCustomMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.CustomMetric>
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
        com.google.analytics.admin.v1beta.GetDataRetentionSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.DataRetentionSettings>
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
        com.google.analytics.admin.v1beta.UpdateDataRetentionSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.DataRetentionSettings>
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
        com.google.analytics.admin.v1beta.CreateDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.DataStream>
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
        com.google.analytics.admin.v1beta.DeleteDataStreamRequest request,
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
        com.google.analytics.admin.v1beta.UpdateDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.DataStream>
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
        com.google.analytics.admin.v1beta.ListDataStreamsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.ListDataStreamsResponse>
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
        com.google.analytics.admin.v1beta.GetDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.DataStream>
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
     * Returns a customized report of data access records. The report provides
     * records of each time a user reads Google Analytics reporting data. Access
     * records are retained for up to 2 years.
     * Data Access Reports can be requested for a property. Reports may be
     * requested for any property, but dimensions that aren't related to quota can
     * only be requested on Google Analytics 360 properties. This method is only
     * available to Administrators.
     * These data access records include GA UI Reporting, GA UI Explorations,
     * GA Data API, and other products like Firebase &amp; Admob that can retrieve
     * data from Google Analytics through a linkage. These records don't include
     * property configuration changes like adding a stream or changing a
     * property's time zone. For configuration change history, see
     * [searchChangeHistoryEvents](https://developers.google.com/analytics/devguides/config/admin/v1/rest/v1alpha/accounts/searchChangeHistoryEvents).
     * To give your feedback on this API, complete the [Google Analytics Access
     * Reports
     * feedback](https://docs.google.com/forms/d/e/1FAIpQLSdmEBUrMzAEdiEKk5TV5dEHvDUZDRlgWYdQdAeSdtR4hVjEhw/viewform)
     * form.
     * </pre>
     */
    public void runAccessReport(
        com.google.analytics.admin.v1beta.RunAccessReportRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.RunAccessReportResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRunAccessReportMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AnalyticsAdminService.
   *
   * <pre>
   * Service Interface for the Google Analytics Admin API.
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
    public com.google.analytics.admin.v1beta.Account getAccount(
        com.google.analytics.admin.v1beta.GetAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAccountMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns all accounts accessible by the caller.
     * Note that these accounts might not currently have GA properties.
     * Soft-deleted (ie: "trashed") accounts are excluded by default.
     * Returns an empty list if no relevant accounts are found.
     * </pre>
     */
    public com.google.analytics.admin.v1beta.ListAccountsResponse listAccounts(
        com.google.analytics.admin.v1beta.ListAccountsRequest request) {
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
        com.google.analytics.admin.v1beta.DeleteAccountRequest request) {
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
    public com.google.analytics.admin.v1beta.Account updateAccount(
        com.google.analytics.admin.v1beta.UpdateAccountRequest request) {
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
    public com.google.analytics.admin.v1beta.ProvisionAccountTicketResponse provisionAccountTicket(
        com.google.analytics.admin.v1beta.ProvisionAccountTicketRequest request) {
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
    public com.google.analytics.admin.v1beta.ListAccountSummariesResponse listAccountSummaries(
        com.google.analytics.admin.v1beta.ListAccountSummariesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAccountSummariesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single GA Property.
     * </pre>
     */
    public com.google.analytics.admin.v1beta.Property getProperty(
        com.google.analytics.admin.v1beta.GetPropertyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPropertyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns child Properties under the specified parent Account.
     * Properties will be excluded if the caller does not have access.
     * Soft-deleted (ie: "trashed") properties are excluded by default.
     * Returns an empty list if no relevant properties are found.
     * </pre>
     */
    public com.google.analytics.admin.v1beta.ListPropertiesResponse listProperties(
        com.google.analytics.admin.v1beta.ListPropertiesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPropertiesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Google Analytics property with the specified location and
     * attributes.
     * </pre>
     */
    public com.google.analytics.admin.v1beta.Property createProperty(
        com.google.analytics.admin.v1beta.CreatePropertyRequest request) {
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
     * Returns an error if the target is not found.
     * </pre>
     */
    public com.google.analytics.admin.v1beta.Property deleteProperty(
        com.google.analytics.admin.v1beta.DeletePropertyRequest request) {
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
    public com.google.analytics.admin.v1beta.Property updateProperty(
        com.google.analytics.admin.v1beta.UpdatePropertyRequest request) {
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
    public com.google.analytics.admin.v1beta.FirebaseLink createFirebaseLink(
        com.google.analytics.admin.v1beta.CreateFirebaseLinkRequest request) {
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
        com.google.analytics.admin.v1beta.DeleteFirebaseLinkRequest request) {
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
    public com.google.analytics.admin.v1beta.ListFirebaseLinksResponse listFirebaseLinks(
        com.google.analytics.admin.v1beta.ListFirebaseLinksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFirebaseLinksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a GoogleAdsLink.
     * </pre>
     */
    public com.google.analytics.admin.v1beta.GoogleAdsLink createGoogleAdsLink(
        com.google.analytics.admin.v1beta.CreateGoogleAdsLinkRequest request) {
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
    public com.google.analytics.admin.v1beta.GoogleAdsLink updateGoogleAdsLink(
        com.google.analytics.admin.v1beta.UpdateGoogleAdsLinkRequest request) {
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
        com.google.analytics.admin.v1beta.DeleteGoogleAdsLinkRequest request) {
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
    public com.google.analytics.admin.v1beta.ListGoogleAdsLinksResponse listGoogleAdsLinks(
        com.google.analytics.admin.v1beta.ListGoogleAdsLinksRequest request) {
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
    public com.google.analytics.admin.v1beta.DataSharingSettings getDataSharingSettings(
        com.google.analytics.admin.v1beta.GetDataSharingSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataSharingSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single MeasurementProtocolSecret.
     * </pre>
     */
    public com.google.analytics.admin.v1beta.MeasurementProtocolSecret getMeasurementProtocolSecret(
        com.google.analytics.admin.v1beta.GetMeasurementProtocolSecretRequest request) {
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
    public com.google.analytics.admin.v1beta.ListMeasurementProtocolSecretsResponse
        listMeasurementProtocolSecrets(
            com.google.analytics.admin.v1beta.ListMeasurementProtocolSecretsRequest request) {
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
    public com.google.analytics.admin.v1beta.MeasurementProtocolSecret
        createMeasurementProtocolSecret(
            com.google.analytics.admin.v1beta.CreateMeasurementProtocolSecretRequest request) {
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
        com.google.analytics.admin.v1beta.DeleteMeasurementProtocolSecretRequest request) {
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
    public com.google.analytics.admin.v1beta.MeasurementProtocolSecret
        updateMeasurementProtocolSecret(
            com.google.analytics.admin.v1beta.UpdateMeasurementProtocolSecretRequest request) {
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
    public com.google.analytics.admin.v1beta.AcknowledgeUserDataCollectionResponse
        acknowledgeUserDataCollection(
            com.google.analytics.admin.v1beta.AcknowledgeUserDataCollectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAcknowledgeUserDataCollectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Searches through all changes to an account or its children given the
     * specified set of filters.
     * Only returns the subset of changes supported by the API. The UI may return
     * additional changes.
     * </pre>
     */
    public com.google.analytics.admin.v1beta.SearchChangeHistoryEventsResponse
        searchChangeHistoryEvents(
            com.google.analytics.admin.v1beta.SearchChangeHistoryEventsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchChangeHistoryEventsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use `CreateKeyEvent` instead.
     * Creates a conversion event with the specified attributes.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.analytics.admin.v1beta.ConversionEvent createConversionEvent(
        com.google.analytics.admin.v1beta.CreateConversionEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateConversionEventMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use `UpdateKeyEvent` instead.
     * Updates a conversion event with the specified attributes.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.analytics.admin.v1beta.ConversionEvent updateConversionEvent(
        com.google.analytics.admin.v1beta.UpdateConversionEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateConversionEventMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use `GetKeyEvent` instead.
     * Retrieve a single conversion event.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.analytics.admin.v1beta.ConversionEvent getConversionEvent(
        com.google.analytics.admin.v1beta.GetConversionEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConversionEventMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use `DeleteKeyEvent` instead.
     * Deletes a conversion event in a property.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.protobuf.Empty deleteConversionEvent(
        com.google.analytics.admin.v1beta.DeleteConversionEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteConversionEventMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use `ListKeyEvents` instead.
     * Returns a list of conversion events in the specified parent property.
     * Returns an empty list if no conversion events are found.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.analytics.admin.v1beta.ListConversionEventsResponse listConversionEvents(
        com.google.analytics.admin.v1beta.ListConversionEventsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConversionEventsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Key Event.
     * </pre>
     */
    public com.google.analytics.admin.v1beta.KeyEvent createKeyEvent(
        com.google.analytics.admin.v1beta.CreateKeyEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateKeyEventMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Key Event.
     * </pre>
     */
    public com.google.analytics.admin.v1beta.KeyEvent updateKeyEvent(
        com.google.analytics.admin.v1beta.UpdateKeyEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateKeyEventMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single Key Event.
     * </pre>
     */
    public com.google.analytics.admin.v1beta.KeyEvent getKeyEvent(
        com.google.analytics.admin.v1beta.GetKeyEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetKeyEventMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Key Event.
     * </pre>
     */
    public com.google.protobuf.Empty deleteKeyEvent(
        com.google.analytics.admin.v1beta.DeleteKeyEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteKeyEventMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of Key Events in the specified parent property.
     * Returns an empty list if no Key Events are found.
     * </pre>
     */
    public com.google.analytics.admin.v1beta.ListKeyEventsResponse listKeyEvents(
        com.google.analytics.admin.v1beta.ListKeyEventsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListKeyEventsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a CustomDimension.
     * </pre>
     */
    public com.google.analytics.admin.v1beta.CustomDimension createCustomDimension(
        com.google.analytics.admin.v1beta.CreateCustomDimensionRequest request) {
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
    public com.google.analytics.admin.v1beta.CustomDimension updateCustomDimension(
        com.google.analytics.admin.v1beta.UpdateCustomDimensionRequest request) {
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
    public com.google.analytics.admin.v1beta.ListCustomDimensionsResponse listCustomDimensions(
        com.google.analytics.admin.v1beta.ListCustomDimensionsRequest request) {
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
        com.google.analytics.admin.v1beta.ArchiveCustomDimensionRequest request) {
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
    public com.google.analytics.admin.v1beta.CustomDimension getCustomDimension(
        com.google.analytics.admin.v1beta.GetCustomDimensionRequest request) {
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
    public com.google.analytics.admin.v1beta.CustomMetric createCustomMetric(
        com.google.analytics.admin.v1beta.CreateCustomMetricRequest request) {
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
    public com.google.analytics.admin.v1beta.CustomMetric updateCustomMetric(
        com.google.analytics.admin.v1beta.UpdateCustomMetricRequest request) {
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
    public com.google.analytics.admin.v1beta.ListCustomMetricsResponse listCustomMetrics(
        com.google.analytics.admin.v1beta.ListCustomMetricsRequest request) {
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
        com.google.analytics.admin.v1beta.ArchiveCustomMetricRequest request) {
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
    public com.google.analytics.admin.v1beta.CustomMetric getCustomMetric(
        com.google.analytics.admin.v1beta.GetCustomMetricRequest request) {
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
    public com.google.analytics.admin.v1beta.DataRetentionSettings getDataRetentionSettings(
        com.google.analytics.admin.v1beta.GetDataRetentionSettingsRequest request) {
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
    public com.google.analytics.admin.v1beta.DataRetentionSettings updateDataRetentionSettings(
        com.google.analytics.admin.v1beta.UpdateDataRetentionSettingsRequest request) {
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
    public com.google.analytics.admin.v1beta.DataStream createDataStream(
        com.google.analytics.admin.v1beta.CreateDataStreamRequest request) {
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
        com.google.analytics.admin.v1beta.DeleteDataStreamRequest request) {
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
    public com.google.analytics.admin.v1beta.DataStream updateDataStream(
        com.google.analytics.admin.v1beta.UpdateDataStreamRequest request) {
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
    public com.google.analytics.admin.v1beta.ListDataStreamsResponse listDataStreams(
        com.google.analytics.admin.v1beta.ListDataStreamsRequest request) {
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
    public com.google.analytics.admin.v1beta.DataStream getDataStream(
        com.google.analytics.admin.v1beta.GetDataStreamRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataStreamMethod(), getCallOptions(), request);
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
     * These data access records include GA UI Reporting, GA UI Explorations,
     * GA Data API, and other products like Firebase &amp; Admob that can retrieve
     * data from Google Analytics through a linkage. These records don't include
     * property configuration changes like adding a stream or changing a
     * property's time zone. For configuration change history, see
     * [searchChangeHistoryEvents](https://developers.google.com/analytics/devguides/config/admin/v1/rest/v1alpha/accounts/searchChangeHistoryEvents).
     * To give your feedback on this API, complete the [Google Analytics Access
     * Reports
     * feedback](https://docs.google.com/forms/d/e/1FAIpQLSdmEBUrMzAEdiEKk5TV5dEHvDUZDRlgWYdQdAeSdtR4hVjEhw/viewform)
     * form.
     * </pre>
     */
    public com.google.analytics.admin.v1beta.RunAccessReportResponse runAccessReport(
        com.google.analytics.admin.v1beta.RunAccessReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRunAccessReportMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * AnalyticsAdminService.
   *
   * <pre>
   * Service Interface for the Google Analytics Admin API.
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
            com.google.analytics.admin.v1beta.Account>
        getAccount(com.google.analytics.admin.v1beta.GetAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAccountMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns all accounts accessible by the caller.
     * Note that these accounts might not currently have GA properties.
     * Soft-deleted (ie: "trashed") accounts are excluded by default.
     * Returns an empty list if no relevant accounts are found.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1beta.ListAccountsResponse>
        listAccounts(com.google.analytics.admin.v1beta.ListAccountsRequest request) {
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
        deleteAccount(com.google.analytics.admin.v1beta.DeleteAccountRequest request) {
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
            com.google.analytics.admin.v1beta.Account>
        updateAccount(com.google.analytics.admin.v1beta.UpdateAccountRequest request) {
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
            com.google.analytics.admin.v1beta.ProvisionAccountTicketResponse>
        provisionAccountTicket(
            com.google.analytics.admin.v1beta.ProvisionAccountTicketRequest request) {
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
            com.google.analytics.admin.v1beta.ListAccountSummariesResponse>
        listAccountSummaries(
            com.google.analytics.admin.v1beta.ListAccountSummariesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAccountSummariesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single GA Property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1beta.Property>
        getProperty(com.google.analytics.admin.v1beta.GetPropertyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPropertyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns child Properties under the specified parent Account.
     * Properties will be excluded if the caller does not have access.
     * Soft-deleted (ie: "trashed") properties are excluded by default.
     * Returns an empty list if no relevant properties are found.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1beta.ListPropertiesResponse>
        listProperties(com.google.analytics.admin.v1beta.ListPropertiesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPropertiesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Google Analytics property with the specified location and
     * attributes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1beta.Property>
        createProperty(com.google.analytics.admin.v1beta.CreatePropertyRequest request) {
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
     * Returns an error if the target is not found.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1beta.Property>
        deleteProperty(com.google.analytics.admin.v1beta.DeletePropertyRequest request) {
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
            com.google.analytics.admin.v1beta.Property>
        updateProperty(com.google.analytics.admin.v1beta.UpdatePropertyRequest request) {
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
            com.google.analytics.admin.v1beta.FirebaseLink>
        createFirebaseLink(com.google.analytics.admin.v1beta.CreateFirebaseLinkRequest request) {
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
        deleteFirebaseLink(com.google.analytics.admin.v1beta.DeleteFirebaseLinkRequest request) {
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
            com.google.analytics.admin.v1beta.ListFirebaseLinksResponse>
        listFirebaseLinks(com.google.analytics.admin.v1beta.ListFirebaseLinksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFirebaseLinksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a GoogleAdsLink.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1beta.GoogleAdsLink>
        createGoogleAdsLink(com.google.analytics.admin.v1beta.CreateGoogleAdsLinkRequest request) {
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
            com.google.analytics.admin.v1beta.GoogleAdsLink>
        updateGoogleAdsLink(com.google.analytics.admin.v1beta.UpdateGoogleAdsLinkRequest request) {
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
        deleteGoogleAdsLink(com.google.analytics.admin.v1beta.DeleteGoogleAdsLinkRequest request) {
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
            com.google.analytics.admin.v1beta.ListGoogleAdsLinksResponse>
        listGoogleAdsLinks(com.google.analytics.admin.v1beta.ListGoogleAdsLinksRequest request) {
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
            com.google.analytics.admin.v1beta.DataSharingSettings>
        getDataSharingSettings(
            com.google.analytics.admin.v1beta.GetDataSharingSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataSharingSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single MeasurementProtocolSecret.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1beta.MeasurementProtocolSecret>
        getMeasurementProtocolSecret(
            com.google.analytics.admin.v1beta.GetMeasurementProtocolSecretRequest request) {
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
            com.google.analytics.admin.v1beta.ListMeasurementProtocolSecretsResponse>
        listMeasurementProtocolSecrets(
            com.google.analytics.admin.v1beta.ListMeasurementProtocolSecretsRequest request) {
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
            com.google.analytics.admin.v1beta.MeasurementProtocolSecret>
        createMeasurementProtocolSecret(
            com.google.analytics.admin.v1beta.CreateMeasurementProtocolSecretRequest request) {
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
            com.google.analytics.admin.v1beta.DeleteMeasurementProtocolSecretRequest request) {
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
            com.google.analytics.admin.v1beta.MeasurementProtocolSecret>
        updateMeasurementProtocolSecret(
            com.google.analytics.admin.v1beta.UpdateMeasurementProtocolSecretRequest request) {
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
            com.google.analytics.admin.v1beta.AcknowledgeUserDataCollectionResponse>
        acknowledgeUserDataCollection(
            com.google.analytics.admin.v1beta.AcknowledgeUserDataCollectionRequest request) {
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
     * Only returns the subset of changes supported by the API. The UI may return
     * additional changes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1beta.SearchChangeHistoryEventsResponse>
        searchChangeHistoryEvents(
            com.google.analytics.admin.v1beta.SearchChangeHistoryEventsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchChangeHistoryEventsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use `CreateKeyEvent` instead.
     * Creates a conversion event with the specified attributes.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1beta.ConversionEvent>
        createConversionEvent(
            com.google.analytics.admin.v1beta.CreateConversionEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateConversionEventMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use `UpdateKeyEvent` instead.
     * Updates a conversion event with the specified attributes.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1beta.ConversionEvent>
        updateConversionEvent(
            com.google.analytics.admin.v1beta.UpdateConversionEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateConversionEventMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use `GetKeyEvent` instead.
     * Retrieve a single conversion event.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1beta.ConversionEvent>
        getConversionEvent(com.google.analytics.admin.v1beta.GetConversionEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetConversionEventMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use `DeleteKeyEvent` instead.
     * Deletes a conversion event in a property.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteConversionEvent(
            com.google.analytics.admin.v1beta.DeleteConversionEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteConversionEventMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use `ListKeyEvents` instead.
     * Returns a list of conversion events in the specified parent property.
     * Returns an empty list if no conversion events are found.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1beta.ListConversionEventsResponse>
        listConversionEvents(
            com.google.analytics.admin.v1beta.ListConversionEventsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListConversionEventsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Key Event.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1beta.KeyEvent>
        createKeyEvent(com.google.analytics.admin.v1beta.CreateKeyEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateKeyEventMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Key Event.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1beta.KeyEvent>
        updateKeyEvent(com.google.analytics.admin.v1beta.UpdateKeyEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateKeyEventMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single Key Event.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1beta.KeyEvent>
        getKeyEvent(com.google.analytics.admin.v1beta.GetKeyEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetKeyEventMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Key Event.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteKeyEvent(com.google.analytics.admin.v1beta.DeleteKeyEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteKeyEventMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of Key Events in the specified parent property.
     * Returns an empty list if no Key Events are found.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1beta.ListKeyEventsResponse>
        listKeyEvents(com.google.analytics.admin.v1beta.ListKeyEventsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListKeyEventsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a CustomDimension.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1beta.CustomDimension>
        createCustomDimension(
            com.google.analytics.admin.v1beta.CreateCustomDimensionRequest request) {
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
            com.google.analytics.admin.v1beta.CustomDimension>
        updateCustomDimension(
            com.google.analytics.admin.v1beta.UpdateCustomDimensionRequest request) {
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
            com.google.analytics.admin.v1beta.ListCustomDimensionsResponse>
        listCustomDimensions(
            com.google.analytics.admin.v1beta.ListCustomDimensionsRequest request) {
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
            com.google.analytics.admin.v1beta.ArchiveCustomDimensionRequest request) {
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
            com.google.analytics.admin.v1beta.CustomDimension>
        getCustomDimension(com.google.analytics.admin.v1beta.GetCustomDimensionRequest request) {
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
            com.google.analytics.admin.v1beta.CustomMetric>
        createCustomMetric(com.google.analytics.admin.v1beta.CreateCustomMetricRequest request) {
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
            com.google.analytics.admin.v1beta.CustomMetric>
        updateCustomMetric(com.google.analytics.admin.v1beta.UpdateCustomMetricRequest request) {
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
            com.google.analytics.admin.v1beta.ListCustomMetricsResponse>
        listCustomMetrics(com.google.analytics.admin.v1beta.ListCustomMetricsRequest request) {
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
        archiveCustomMetric(com.google.analytics.admin.v1beta.ArchiveCustomMetricRequest request) {
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
            com.google.analytics.admin.v1beta.CustomMetric>
        getCustomMetric(com.google.analytics.admin.v1beta.GetCustomMetricRequest request) {
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
            com.google.analytics.admin.v1beta.DataRetentionSettings>
        getDataRetentionSettings(
            com.google.analytics.admin.v1beta.GetDataRetentionSettingsRequest request) {
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
            com.google.analytics.admin.v1beta.DataRetentionSettings>
        updateDataRetentionSettings(
            com.google.analytics.admin.v1beta.UpdateDataRetentionSettingsRequest request) {
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
            com.google.analytics.admin.v1beta.DataStream>
        createDataStream(com.google.analytics.admin.v1beta.CreateDataStreamRequest request) {
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
        deleteDataStream(com.google.analytics.admin.v1beta.DeleteDataStreamRequest request) {
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
            com.google.analytics.admin.v1beta.DataStream>
        updateDataStream(com.google.analytics.admin.v1beta.UpdateDataStreamRequest request) {
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
            com.google.analytics.admin.v1beta.ListDataStreamsResponse>
        listDataStreams(com.google.analytics.admin.v1beta.ListDataStreamsRequest request) {
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
            com.google.analytics.admin.v1beta.DataStream>
        getDataStream(com.google.analytics.admin.v1beta.GetDataStreamRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataStreamMethod(), getCallOptions()), request);
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
     * These data access records include GA UI Reporting, GA UI Explorations,
     * GA Data API, and other products like Firebase &amp; Admob that can retrieve
     * data from Google Analytics through a linkage. These records don't include
     * property configuration changes like adding a stream or changing a
     * property's time zone. For configuration change history, see
     * [searchChangeHistoryEvents](https://developers.google.com/analytics/devguides/config/admin/v1/rest/v1alpha/accounts/searchChangeHistoryEvents).
     * To give your feedback on this API, complete the [Google Analytics Access
     * Reports
     * feedback](https://docs.google.com/forms/d/e/1FAIpQLSdmEBUrMzAEdiEKk5TV5dEHvDUZDRlgWYdQdAeSdtR4hVjEhw/viewform)
     * form.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1beta.RunAccessReportResponse>
        runAccessReport(com.google.analytics.admin.v1beta.RunAccessReportRequest request) {
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
  private static final int METHODID_CREATE_FIREBASE_LINK = 11;
  private static final int METHODID_DELETE_FIREBASE_LINK = 12;
  private static final int METHODID_LIST_FIREBASE_LINKS = 13;
  private static final int METHODID_CREATE_GOOGLE_ADS_LINK = 14;
  private static final int METHODID_UPDATE_GOOGLE_ADS_LINK = 15;
  private static final int METHODID_DELETE_GOOGLE_ADS_LINK = 16;
  private static final int METHODID_LIST_GOOGLE_ADS_LINKS = 17;
  private static final int METHODID_GET_DATA_SHARING_SETTINGS = 18;
  private static final int METHODID_GET_MEASUREMENT_PROTOCOL_SECRET = 19;
  private static final int METHODID_LIST_MEASUREMENT_PROTOCOL_SECRETS = 20;
  private static final int METHODID_CREATE_MEASUREMENT_PROTOCOL_SECRET = 21;
  private static final int METHODID_DELETE_MEASUREMENT_PROTOCOL_SECRET = 22;
  private static final int METHODID_UPDATE_MEASUREMENT_PROTOCOL_SECRET = 23;
  private static final int METHODID_ACKNOWLEDGE_USER_DATA_COLLECTION = 24;
  private static final int METHODID_SEARCH_CHANGE_HISTORY_EVENTS = 25;
  private static final int METHODID_CREATE_CONVERSION_EVENT = 26;
  private static final int METHODID_UPDATE_CONVERSION_EVENT = 27;
  private static final int METHODID_GET_CONVERSION_EVENT = 28;
  private static final int METHODID_DELETE_CONVERSION_EVENT = 29;
  private static final int METHODID_LIST_CONVERSION_EVENTS = 30;
  private static final int METHODID_CREATE_KEY_EVENT = 31;
  private static final int METHODID_UPDATE_KEY_EVENT = 32;
  private static final int METHODID_GET_KEY_EVENT = 33;
  private static final int METHODID_DELETE_KEY_EVENT = 34;
  private static final int METHODID_LIST_KEY_EVENTS = 35;
  private static final int METHODID_CREATE_CUSTOM_DIMENSION = 36;
  private static final int METHODID_UPDATE_CUSTOM_DIMENSION = 37;
  private static final int METHODID_LIST_CUSTOM_DIMENSIONS = 38;
  private static final int METHODID_ARCHIVE_CUSTOM_DIMENSION = 39;
  private static final int METHODID_GET_CUSTOM_DIMENSION = 40;
  private static final int METHODID_CREATE_CUSTOM_METRIC = 41;
  private static final int METHODID_UPDATE_CUSTOM_METRIC = 42;
  private static final int METHODID_LIST_CUSTOM_METRICS = 43;
  private static final int METHODID_ARCHIVE_CUSTOM_METRIC = 44;
  private static final int METHODID_GET_CUSTOM_METRIC = 45;
  private static final int METHODID_GET_DATA_RETENTION_SETTINGS = 46;
  private static final int METHODID_UPDATE_DATA_RETENTION_SETTINGS = 47;
  private static final int METHODID_CREATE_DATA_STREAM = 48;
  private static final int METHODID_DELETE_DATA_STREAM = 49;
  private static final int METHODID_UPDATE_DATA_STREAM = 50;
  private static final int METHODID_LIST_DATA_STREAMS = 51;
  private static final int METHODID_GET_DATA_STREAM = 52;
  private static final int METHODID_RUN_ACCESS_REPORT = 53;

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
              (com.google.analytics.admin.v1beta.GetAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.Account>)
                  responseObserver);
          break;
        case METHODID_LIST_ACCOUNTS:
          serviceImpl.listAccounts(
              (com.google.analytics.admin.v1beta.ListAccountsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.ListAccountsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_ACCOUNT:
          serviceImpl.deleteAccount(
              (com.google.analytics.admin.v1beta.DeleteAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_ACCOUNT:
          serviceImpl.updateAccount(
              (com.google.analytics.admin.v1beta.UpdateAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.Account>)
                  responseObserver);
          break;
        case METHODID_PROVISION_ACCOUNT_TICKET:
          serviceImpl.provisionAccountTicket(
              (com.google.analytics.admin.v1beta.ProvisionAccountTicketRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1beta.ProvisionAccountTicketResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_ACCOUNT_SUMMARIES:
          serviceImpl.listAccountSummaries(
              (com.google.analytics.admin.v1beta.ListAccountSummariesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1beta.ListAccountSummariesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PROPERTY:
          serviceImpl.getProperty(
              (com.google.analytics.admin.v1beta.GetPropertyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.Property>)
                  responseObserver);
          break;
        case METHODID_LIST_PROPERTIES:
          serviceImpl.listProperties(
              (com.google.analytics.admin.v1beta.ListPropertiesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1beta.ListPropertiesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_PROPERTY:
          serviceImpl.createProperty(
              (com.google.analytics.admin.v1beta.CreatePropertyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.Property>)
                  responseObserver);
          break;
        case METHODID_DELETE_PROPERTY:
          serviceImpl.deleteProperty(
              (com.google.analytics.admin.v1beta.DeletePropertyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.Property>)
                  responseObserver);
          break;
        case METHODID_UPDATE_PROPERTY:
          serviceImpl.updateProperty(
              (com.google.analytics.admin.v1beta.UpdatePropertyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.Property>)
                  responseObserver);
          break;
        case METHODID_CREATE_FIREBASE_LINK:
          serviceImpl.createFirebaseLink(
              (com.google.analytics.admin.v1beta.CreateFirebaseLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.FirebaseLink>)
                  responseObserver);
          break;
        case METHODID_DELETE_FIREBASE_LINK:
          serviceImpl.deleteFirebaseLink(
              (com.google.analytics.admin.v1beta.DeleteFirebaseLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_FIREBASE_LINKS:
          serviceImpl.listFirebaseLinks(
              (com.google.analytics.admin.v1beta.ListFirebaseLinksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1beta.ListFirebaseLinksResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_GOOGLE_ADS_LINK:
          serviceImpl.createGoogleAdsLink(
              (com.google.analytics.admin.v1beta.CreateGoogleAdsLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.GoogleAdsLink>)
                  responseObserver);
          break;
        case METHODID_UPDATE_GOOGLE_ADS_LINK:
          serviceImpl.updateGoogleAdsLink(
              (com.google.analytics.admin.v1beta.UpdateGoogleAdsLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.GoogleAdsLink>)
                  responseObserver);
          break;
        case METHODID_DELETE_GOOGLE_ADS_LINK:
          serviceImpl.deleteGoogleAdsLink(
              (com.google.analytics.admin.v1beta.DeleteGoogleAdsLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_GOOGLE_ADS_LINKS:
          serviceImpl.listGoogleAdsLinks(
              (com.google.analytics.admin.v1beta.ListGoogleAdsLinksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1beta.ListGoogleAdsLinksResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DATA_SHARING_SETTINGS:
          serviceImpl.getDataSharingSettings(
              (com.google.analytics.admin.v1beta.GetDataSharingSettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.DataSharingSettings>)
                  responseObserver);
          break;
        case METHODID_GET_MEASUREMENT_PROTOCOL_SECRET:
          serviceImpl.getMeasurementProtocolSecret(
              (com.google.analytics.admin.v1beta.GetMeasurementProtocolSecretRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1beta.MeasurementProtocolSecret>)
                  responseObserver);
          break;
        case METHODID_LIST_MEASUREMENT_PROTOCOL_SECRETS:
          serviceImpl.listMeasurementProtocolSecrets(
              (com.google.analytics.admin.v1beta.ListMeasurementProtocolSecretsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1beta.ListMeasurementProtocolSecretsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_MEASUREMENT_PROTOCOL_SECRET:
          serviceImpl.createMeasurementProtocolSecret(
              (com.google.analytics.admin.v1beta.CreateMeasurementProtocolSecretRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1beta.MeasurementProtocolSecret>)
                  responseObserver);
          break;
        case METHODID_DELETE_MEASUREMENT_PROTOCOL_SECRET:
          serviceImpl.deleteMeasurementProtocolSecret(
              (com.google.analytics.admin.v1beta.DeleteMeasurementProtocolSecretRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_MEASUREMENT_PROTOCOL_SECRET:
          serviceImpl.updateMeasurementProtocolSecret(
              (com.google.analytics.admin.v1beta.UpdateMeasurementProtocolSecretRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1beta.MeasurementProtocolSecret>)
                  responseObserver);
          break;
        case METHODID_ACKNOWLEDGE_USER_DATA_COLLECTION:
          serviceImpl.acknowledgeUserDataCollection(
              (com.google.analytics.admin.v1beta.AcknowledgeUserDataCollectionRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1beta.AcknowledgeUserDataCollectionResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_CHANGE_HISTORY_EVENTS:
          serviceImpl.searchChangeHistoryEvents(
              (com.google.analytics.admin.v1beta.SearchChangeHistoryEventsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1beta.SearchChangeHistoryEventsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_CONVERSION_EVENT:
          serviceImpl.createConversionEvent(
              (com.google.analytics.admin.v1beta.CreateConversionEventRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.ConversionEvent>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CONVERSION_EVENT:
          serviceImpl.updateConversionEvent(
              (com.google.analytics.admin.v1beta.UpdateConversionEventRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.ConversionEvent>)
                  responseObserver);
          break;
        case METHODID_GET_CONVERSION_EVENT:
          serviceImpl.getConversionEvent(
              (com.google.analytics.admin.v1beta.GetConversionEventRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.ConversionEvent>)
                  responseObserver);
          break;
        case METHODID_DELETE_CONVERSION_EVENT:
          serviceImpl.deleteConversionEvent(
              (com.google.analytics.admin.v1beta.DeleteConversionEventRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_CONVERSION_EVENTS:
          serviceImpl.listConversionEvents(
              (com.google.analytics.admin.v1beta.ListConversionEventsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1beta.ListConversionEventsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_KEY_EVENT:
          serviceImpl.createKeyEvent(
              (com.google.analytics.admin.v1beta.CreateKeyEventRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.KeyEvent>)
                  responseObserver);
          break;
        case METHODID_UPDATE_KEY_EVENT:
          serviceImpl.updateKeyEvent(
              (com.google.analytics.admin.v1beta.UpdateKeyEventRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.KeyEvent>)
                  responseObserver);
          break;
        case METHODID_GET_KEY_EVENT:
          serviceImpl.getKeyEvent(
              (com.google.analytics.admin.v1beta.GetKeyEventRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.KeyEvent>)
                  responseObserver);
          break;
        case METHODID_DELETE_KEY_EVENT:
          serviceImpl.deleteKeyEvent(
              (com.google.analytics.admin.v1beta.DeleteKeyEventRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_KEY_EVENTS:
          serviceImpl.listKeyEvents(
              (com.google.analytics.admin.v1beta.ListKeyEventsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.ListKeyEventsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_CUSTOM_DIMENSION:
          serviceImpl.createCustomDimension(
              (com.google.analytics.admin.v1beta.CreateCustomDimensionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.CustomDimension>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CUSTOM_DIMENSION:
          serviceImpl.updateCustomDimension(
              (com.google.analytics.admin.v1beta.UpdateCustomDimensionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.CustomDimension>)
                  responseObserver);
          break;
        case METHODID_LIST_CUSTOM_DIMENSIONS:
          serviceImpl.listCustomDimensions(
              (com.google.analytics.admin.v1beta.ListCustomDimensionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1beta.ListCustomDimensionsResponse>)
                  responseObserver);
          break;
        case METHODID_ARCHIVE_CUSTOM_DIMENSION:
          serviceImpl.archiveCustomDimension(
              (com.google.analytics.admin.v1beta.ArchiveCustomDimensionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_CUSTOM_DIMENSION:
          serviceImpl.getCustomDimension(
              (com.google.analytics.admin.v1beta.GetCustomDimensionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.CustomDimension>)
                  responseObserver);
          break;
        case METHODID_CREATE_CUSTOM_METRIC:
          serviceImpl.createCustomMetric(
              (com.google.analytics.admin.v1beta.CreateCustomMetricRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.CustomMetric>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CUSTOM_METRIC:
          serviceImpl.updateCustomMetric(
              (com.google.analytics.admin.v1beta.UpdateCustomMetricRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.CustomMetric>)
                  responseObserver);
          break;
        case METHODID_LIST_CUSTOM_METRICS:
          serviceImpl.listCustomMetrics(
              (com.google.analytics.admin.v1beta.ListCustomMetricsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1beta.ListCustomMetricsResponse>)
                  responseObserver);
          break;
        case METHODID_ARCHIVE_CUSTOM_METRIC:
          serviceImpl.archiveCustomMetric(
              (com.google.analytics.admin.v1beta.ArchiveCustomMetricRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_CUSTOM_METRIC:
          serviceImpl.getCustomMetric(
              (com.google.analytics.admin.v1beta.GetCustomMetricRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.CustomMetric>)
                  responseObserver);
          break;
        case METHODID_GET_DATA_RETENTION_SETTINGS:
          serviceImpl.getDataRetentionSettings(
              (com.google.analytics.admin.v1beta.GetDataRetentionSettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.DataRetentionSettings>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DATA_RETENTION_SETTINGS:
          serviceImpl.updateDataRetentionSettings(
              (com.google.analytics.admin.v1beta.UpdateDataRetentionSettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.DataRetentionSettings>)
                  responseObserver);
          break;
        case METHODID_CREATE_DATA_STREAM:
          serviceImpl.createDataStream(
              (com.google.analytics.admin.v1beta.CreateDataStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.DataStream>)
                  responseObserver);
          break;
        case METHODID_DELETE_DATA_STREAM:
          serviceImpl.deleteDataStream(
              (com.google.analytics.admin.v1beta.DeleteDataStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_DATA_STREAM:
          serviceImpl.updateDataStream(
              (com.google.analytics.admin.v1beta.UpdateDataStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.DataStream>)
                  responseObserver);
          break;
        case METHODID_LIST_DATA_STREAMS:
          serviceImpl.listDataStreams(
              (com.google.analytics.admin.v1beta.ListDataStreamsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1beta.ListDataStreamsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DATA_STREAM:
          serviceImpl.getDataStream(
              (com.google.analytics.admin.v1beta.GetDataStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1beta.DataStream>)
                  responseObserver);
          break;
        case METHODID_RUN_ACCESS_REPORT:
          serviceImpl.runAccessReport(
              (com.google.analytics.admin.v1beta.RunAccessReportRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1beta.RunAccessReportResponse>)
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
            getGetAccountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.GetAccountRequest,
                    com.google.analytics.admin.v1beta.Account>(service, METHODID_GET_ACCOUNT)))
        .addMethod(
            getListAccountsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.ListAccountsRequest,
                    com.google.analytics.admin.v1beta.ListAccountsResponse>(
                    service, METHODID_LIST_ACCOUNTS)))
        .addMethod(
            getDeleteAccountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.DeleteAccountRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_ACCOUNT)))
        .addMethod(
            getUpdateAccountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.UpdateAccountRequest,
                    com.google.analytics.admin.v1beta.Account>(service, METHODID_UPDATE_ACCOUNT)))
        .addMethod(
            getProvisionAccountTicketMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.ProvisionAccountTicketRequest,
                    com.google.analytics.admin.v1beta.ProvisionAccountTicketResponse>(
                    service, METHODID_PROVISION_ACCOUNT_TICKET)))
        .addMethod(
            getListAccountSummariesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.ListAccountSummariesRequest,
                    com.google.analytics.admin.v1beta.ListAccountSummariesResponse>(
                    service, METHODID_LIST_ACCOUNT_SUMMARIES)))
        .addMethod(
            getGetPropertyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.GetPropertyRequest,
                    com.google.analytics.admin.v1beta.Property>(service, METHODID_GET_PROPERTY)))
        .addMethod(
            getListPropertiesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.ListPropertiesRequest,
                    com.google.analytics.admin.v1beta.ListPropertiesResponse>(
                    service, METHODID_LIST_PROPERTIES)))
        .addMethod(
            getCreatePropertyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.CreatePropertyRequest,
                    com.google.analytics.admin.v1beta.Property>(service, METHODID_CREATE_PROPERTY)))
        .addMethod(
            getDeletePropertyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.DeletePropertyRequest,
                    com.google.analytics.admin.v1beta.Property>(service, METHODID_DELETE_PROPERTY)))
        .addMethod(
            getUpdatePropertyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.UpdatePropertyRequest,
                    com.google.analytics.admin.v1beta.Property>(service, METHODID_UPDATE_PROPERTY)))
        .addMethod(
            getCreateFirebaseLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.CreateFirebaseLinkRequest,
                    com.google.analytics.admin.v1beta.FirebaseLink>(
                    service, METHODID_CREATE_FIREBASE_LINK)))
        .addMethod(
            getDeleteFirebaseLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.DeleteFirebaseLinkRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_FIREBASE_LINK)))
        .addMethod(
            getListFirebaseLinksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.ListFirebaseLinksRequest,
                    com.google.analytics.admin.v1beta.ListFirebaseLinksResponse>(
                    service, METHODID_LIST_FIREBASE_LINKS)))
        .addMethod(
            getCreateGoogleAdsLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.CreateGoogleAdsLinkRequest,
                    com.google.analytics.admin.v1beta.GoogleAdsLink>(
                    service, METHODID_CREATE_GOOGLE_ADS_LINK)))
        .addMethod(
            getUpdateGoogleAdsLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.UpdateGoogleAdsLinkRequest,
                    com.google.analytics.admin.v1beta.GoogleAdsLink>(
                    service, METHODID_UPDATE_GOOGLE_ADS_LINK)))
        .addMethod(
            getDeleteGoogleAdsLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.DeleteGoogleAdsLinkRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_GOOGLE_ADS_LINK)))
        .addMethod(
            getListGoogleAdsLinksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.ListGoogleAdsLinksRequest,
                    com.google.analytics.admin.v1beta.ListGoogleAdsLinksResponse>(
                    service, METHODID_LIST_GOOGLE_ADS_LINKS)))
        .addMethod(
            getGetDataSharingSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.GetDataSharingSettingsRequest,
                    com.google.analytics.admin.v1beta.DataSharingSettings>(
                    service, METHODID_GET_DATA_SHARING_SETTINGS)))
        .addMethod(
            getGetMeasurementProtocolSecretMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.GetMeasurementProtocolSecretRequest,
                    com.google.analytics.admin.v1beta.MeasurementProtocolSecret>(
                    service, METHODID_GET_MEASUREMENT_PROTOCOL_SECRET)))
        .addMethod(
            getListMeasurementProtocolSecretsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.ListMeasurementProtocolSecretsRequest,
                    com.google.analytics.admin.v1beta.ListMeasurementProtocolSecretsResponse>(
                    service, METHODID_LIST_MEASUREMENT_PROTOCOL_SECRETS)))
        .addMethod(
            getCreateMeasurementProtocolSecretMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.CreateMeasurementProtocolSecretRequest,
                    com.google.analytics.admin.v1beta.MeasurementProtocolSecret>(
                    service, METHODID_CREATE_MEASUREMENT_PROTOCOL_SECRET)))
        .addMethod(
            getDeleteMeasurementProtocolSecretMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.DeleteMeasurementProtocolSecretRequest,
                    com.google.protobuf.Empty>(
                    service, METHODID_DELETE_MEASUREMENT_PROTOCOL_SECRET)))
        .addMethod(
            getUpdateMeasurementProtocolSecretMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.UpdateMeasurementProtocolSecretRequest,
                    com.google.analytics.admin.v1beta.MeasurementProtocolSecret>(
                    service, METHODID_UPDATE_MEASUREMENT_PROTOCOL_SECRET)))
        .addMethod(
            getAcknowledgeUserDataCollectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.AcknowledgeUserDataCollectionRequest,
                    com.google.analytics.admin.v1beta.AcknowledgeUserDataCollectionResponse>(
                    service, METHODID_ACKNOWLEDGE_USER_DATA_COLLECTION)))
        .addMethod(
            getSearchChangeHistoryEventsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.SearchChangeHistoryEventsRequest,
                    com.google.analytics.admin.v1beta.SearchChangeHistoryEventsResponse>(
                    service, METHODID_SEARCH_CHANGE_HISTORY_EVENTS)))
        .addMethod(
            getCreateConversionEventMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.CreateConversionEventRequest,
                    com.google.analytics.admin.v1beta.ConversionEvent>(
                    service, METHODID_CREATE_CONVERSION_EVENT)))
        .addMethod(
            getUpdateConversionEventMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.UpdateConversionEventRequest,
                    com.google.analytics.admin.v1beta.ConversionEvent>(
                    service, METHODID_UPDATE_CONVERSION_EVENT)))
        .addMethod(
            getGetConversionEventMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.GetConversionEventRequest,
                    com.google.analytics.admin.v1beta.ConversionEvent>(
                    service, METHODID_GET_CONVERSION_EVENT)))
        .addMethod(
            getDeleteConversionEventMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.DeleteConversionEventRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_CONVERSION_EVENT)))
        .addMethod(
            getListConversionEventsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.ListConversionEventsRequest,
                    com.google.analytics.admin.v1beta.ListConversionEventsResponse>(
                    service, METHODID_LIST_CONVERSION_EVENTS)))
        .addMethod(
            getCreateKeyEventMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.CreateKeyEventRequest,
                    com.google.analytics.admin.v1beta.KeyEvent>(
                    service, METHODID_CREATE_KEY_EVENT)))
        .addMethod(
            getUpdateKeyEventMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.UpdateKeyEventRequest,
                    com.google.analytics.admin.v1beta.KeyEvent>(
                    service, METHODID_UPDATE_KEY_EVENT)))
        .addMethod(
            getGetKeyEventMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.GetKeyEventRequest,
                    com.google.analytics.admin.v1beta.KeyEvent>(service, METHODID_GET_KEY_EVENT)))
        .addMethod(
            getDeleteKeyEventMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.DeleteKeyEventRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_KEY_EVENT)))
        .addMethod(
            getListKeyEventsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.ListKeyEventsRequest,
                    com.google.analytics.admin.v1beta.ListKeyEventsResponse>(
                    service, METHODID_LIST_KEY_EVENTS)))
        .addMethod(
            getCreateCustomDimensionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.CreateCustomDimensionRequest,
                    com.google.analytics.admin.v1beta.CustomDimension>(
                    service, METHODID_CREATE_CUSTOM_DIMENSION)))
        .addMethod(
            getUpdateCustomDimensionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.UpdateCustomDimensionRequest,
                    com.google.analytics.admin.v1beta.CustomDimension>(
                    service, METHODID_UPDATE_CUSTOM_DIMENSION)))
        .addMethod(
            getListCustomDimensionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.ListCustomDimensionsRequest,
                    com.google.analytics.admin.v1beta.ListCustomDimensionsResponse>(
                    service, METHODID_LIST_CUSTOM_DIMENSIONS)))
        .addMethod(
            getArchiveCustomDimensionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.ArchiveCustomDimensionRequest,
                    com.google.protobuf.Empty>(service, METHODID_ARCHIVE_CUSTOM_DIMENSION)))
        .addMethod(
            getGetCustomDimensionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.GetCustomDimensionRequest,
                    com.google.analytics.admin.v1beta.CustomDimension>(
                    service, METHODID_GET_CUSTOM_DIMENSION)))
        .addMethod(
            getCreateCustomMetricMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.CreateCustomMetricRequest,
                    com.google.analytics.admin.v1beta.CustomMetric>(
                    service, METHODID_CREATE_CUSTOM_METRIC)))
        .addMethod(
            getUpdateCustomMetricMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.UpdateCustomMetricRequest,
                    com.google.analytics.admin.v1beta.CustomMetric>(
                    service, METHODID_UPDATE_CUSTOM_METRIC)))
        .addMethod(
            getListCustomMetricsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.ListCustomMetricsRequest,
                    com.google.analytics.admin.v1beta.ListCustomMetricsResponse>(
                    service, METHODID_LIST_CUSTOM_METRICS)))
        .addMethod(
            getArchiveCustomMetricMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.ArchiveCustomMetricRequest,
                    com.google.protobuf.Empty>(service, METHODID_ARCHIVE_CUSTOM_METRIC)))
        .addMethod(
            getGetCustomMetricMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.GetCustomMetricRequest,
                    com.google.analytics.admin.v1beta.CustomMetric>(
                    service, METHODID_GET_CUSTOM_METRIC)))
        .addMethod(
            getGetDataRetentionSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.GetDataRetentionSettingsRequest,
                    com.google.analytics.admin.v1beta.DataRetentionSettings>(
                    service, METHODID_GET_DATA_RETENTION_SETTINGS)))
        .addMethod(
            getUpdateDataRetentionSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.UpdateDataRetentionSettingsRequest,
                    com.google.analytics.admin.v1beta.DataRetentionSettings>(
                    service, METHODID_UPDATE_DATA_RETENTION_SETTINGS)))
        .addMethod(
            getCreateDataStreamMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.CreateDataStreamRequest,
                    com.google.analytics.admin.v1beta.DataStream>(
                    service, METHODID_CREATE_DATA_STREAM)))
        .addMethod(
            getDeleteDataStreamMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.DeleteDataStreamRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_DATA_STREAM)))
        .addMethod(
            getUpdateDataStreamMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.UpdateDataStreamRequest,
                    com.google.analytics.admin.v1beta.DataStream>(
                    service, METHODID_UPDATE_DATA_STREAM)))
        .addMethod(
            getListDataStreamsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.ListDataStreamsRequest,
                    com.google.analytics.admin.v1beta.ListDataStreamsResponse>(
                    service, METHODID_LIST_DATA_STREAMS)))
        .addMethod(
            getGetDataStreamMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.GetDataStreamRequest,
                    com.google.analytics.admin.v1beta.DataStream>(
                    service, METHODID_GET_DATA_STREAM)))
        .addMethod(
            getRunAccessReportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.admin.v1beta.RunAccessReportRequest,
                    com.google.analytics.admin.v1beta.RunAccessReportResponse>(
                    service, METHODID_RUN_ACCESS_REPORT)))
        .build();
  }

  private abstract static class AnalyticsAdminServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AnalyticsAdminServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.analytics.admin.v1beta.AnalyticsAdminProto.getDescriptor();
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
                      .addMethod(getCreateConversionEventMethod())
                      .addMethod(getUpdateConversionEventMethod())
                      .addMethod(getGetConversionEventMethod())
                      .addMethod(getDeleteConversionEventMethod())
                      .addMethod(getListConversionEventsMethod())
                      .addMethod(getCreateKeyEventMethod())
                      .addMethod(getUpdateKeyEventMethod())
                      .addMethod(getGetKeyEventMethod())
                      .addMethod(getDeleteKeyEventMethod())
                      .addMethod(getListKeyEventsMethod())
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
                      .addMethod(getRunAccessReportMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
