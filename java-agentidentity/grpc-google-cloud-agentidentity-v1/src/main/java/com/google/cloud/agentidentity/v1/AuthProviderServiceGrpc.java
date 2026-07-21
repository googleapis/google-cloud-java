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
package com.google.cloud.agentidentity.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service describing handlers for resources
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class AuthProviderServiceGrpc {

  private AuthProviderServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.agentidentity.v1.AuthProviderService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentidentity.v1.ListAuthProvidersRequest,
          com.google.cloud.agentidentity.v1.ListAuthProvidersResponse>
      getListAuthProvidersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAuthProviders",
      requestType = com.google.cloud.agentidentity.v1.ListAuthProvidersRequest.class,
      responseType = com.google.cloud.agentidentity.v1.ListAuthProvidersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentidentity.v1.ListAuthProvidersRequest,
          com.google.cloud.agentidentity.v1.ListAuthProvidersResponse>
      getListAuthProvidersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentidentity.v1.ListAuthProvidersRequest,
            com.google.cloud.agentidentity.v1.ListAuthProvidersResponse>
        getListAuthProvidersMethod;
    if ((getListAuthProvidersMethod = AuthProviderServiceGrpc.getListAuthProvidersMethod) == null) {
      synchronized (AuthProviderServiceGrpc.class) {
        if ((getListAuthProvidersMethod = AuthProviderServiceGrpc.getListAuthProvidersMethod)
            == null) {
          AuthProviderServiceGrpc.getListAuthProvidersMethod =
              getListAuthProvidersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentidentity.v1.ListAuthProvidersRequest,
                          com.google.cloud.agentidentity.v1.ListAuthProvidersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAuthProviders"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentidentity.v1.ListAuthProvidersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentidentity.v1.ListAuthProvidersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AuthProviderServiceMethodDescriptorSupplier("ListAuthProviders"))
                      .build();
        }
      }
    }
    return getListAuthProvidersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentidentity.v1.GetAuthProviderRequest,
          com.google.cloud.agentidentity.v1.AuthProvider>
      getGetAuthProviderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAuthProvider",
      requestType = com.google.cloud.agentidentity.v1.GetAuthProviderRequest.class,
      responseType = com.google.cloud.agentidentity.v1.AuthProvider.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentidentity.v1.GetAuthProviderRequest,
          com.google.cloud.agentidentity.v1.AuthProvider>
      getGetAuthProviderMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentidentity.v1.GetAuthProviderRequest,
            com.google.cloud.agentidentity.v1.AuthProvider>
        getGetAuthProviderMethod;
    if ((getGetAuthProviderMethod = AuthProviderServiceGrpc.getGetAuthProviderMethod) == null) {
      synchronized (AuthProviderServiceGrpc.class) {
        if ((getGetAuthProviderMethod = AuthProviderServiceGrpc.getGetAuthProviderMethod) == null) {
          AuthProviderServiceGrpc.getGetAuthProviderMethod =
              getGetAuthProviderMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentidentity.v1.GetAuthProviderRequest,
                          com.google.cloud.agentidentity.v1.AuthProvider>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAuthProvider"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentidentity.v1.GetAuthProviderRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentidentity.v1.AuthProvider.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AuthProviderServiceMethodDescriptorSupplier("GetAuthProvider"))
                      .build();
        }
      }
    }
    return getGetAuthProviderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentidentity.v1.CreateAuthProviderRequest,
          com.google.cloud.agentidentity.v1.AuthProvider>
      getCreateAuthProviderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAuthProvider",
      requestType = com.google.cloud.agentidentity.v1.CreateAuthProviderRequest.class,
      responseType = com.google.cloud.agentidentity.v1.AuthProvider.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentidentity.v1.CreateAuthProviderRequest,
          com.google.cloud.agentidentity.v1.AuthProvider>
      getCreateAuthProviderMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentidentity.v1.CreateAuthProviderRequest,
            com.google.cloud.agentidentity.v1.AuthProvider>
        getCreateAuthProviderMethod;
    if ((getCreateAuthProviderMethod = AuthProviderServiceGrpc.getCreateAuthProviderMethod)
        == null) {
      synchronized (AuthProviderServiceGrpc.class) {
        if ((getCreateAuthProviderMethod = AuthProviderServiceGrpc.getCreateAuthProviderMethod)
            == null) {
          AuthProviderServiceGrpc.getCreateAuthProviderMethod =
              getCreateAuthProviderMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentidentity.v1.CreateAuthProviderRequest,
                          com.google.cloud.agentidentity.v1.AuthProvider>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAuthProvider"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentidentity.v1.CreateAuthProviderRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentidentity.v1.AuthProvider.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AuthProviderServiceMethodDescriptorSupplier("CreateAuthProvider"))
                      .build();
        }
      }
    }
    return getCreateAuthProviderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentidentity.v1.UpdateAuthProviderRequest,
          com.google.cloud.agentidentity.v1.AuthProvider>
      getUpdateAuthProviderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAuthProvider",
      requestType = com.google.cloud.agentidentity.v1.UpdateAuthProviderRequest.class,
      responseType = com.google.cloud.agentidentity.v1.AuthProvider.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentidentity.v1.UpdateAuthProviderRequest,
          com.google.cloud.agentidentity.v1.AuthProvider>
      getUpdateAuthProviderMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentidentity.v1.UpdateAuthProviderRequest,
            com.google.cloud.agentidentity.v1.AuthProvider>
        getUpdateAuthProviderMethod;
    if ((getUpdateAuthProviderMethod = AuthProviderServiceGrpc.getUpdateAuthProviderMethod)
        == null) {
      synchronized (AuthProviderServiceGrpc.class) {
        if ((getUpdateAuthProviderMethod = AuthProviderServiceGrpc.getUpdateAuthProviderMethod)
            == null) {
          AuthProviderServiceGrpc.getUpdateAuthProviderMethod =
              getUpdateAuthProviderMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentidentity.v1.UpdateAuthProviderRequest,
                          com.google.cloud.agentidentity.v1.AuthProvider>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAuthProvider"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentidentity.v1.UpdateAuthProviderRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentidentity.v1.AuthProvider.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AuthProviderServiceMethodDescriptorSupplier("UpdateAuthProvider"))
                      .build();
        }
      }
    }
    return getUpdateAuthProviderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentidentity.v1.DeleteAuthProviderRequest, com.google.protobuf.Empty>
      getDeleteAuthProviderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAuthProvider",
      requestType = com.google.cloud.agentidentity.v1.DeleteAuthProviderRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentidentity.v1.DeleteAuthProviderRequest, com.google.protobuf.Empty>
      getDeleteAuthProviderMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentidentity.v1.DeleteAuthProviderRequest, com.google.protobuf.Empty>
        getDeleteAuthProviderMethod;
    if ((getDeleteAuthProviderMethod = AuthProviderServiceGrpc.getDeleteAuthProviderMethod)
        == null) {
      synchronized (AuthProviderServiceGrpc.class) {
        if ((getDeleteAuthProviderMethod = AuthProviderServiceGrpc.getDeleteAuthProviderMethod)
            == null) {
          AuthProviderServiceGrpc.getDeleteAuthProviderMethod =
              getDeleteAuthProviderMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentidentity.v1.DeleteAuthProviderRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAuthProvider"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentidentity.v1.DeleteAuthProviderRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AuthProviderServiceMethodDescriptorSupplier("DeleteAuthProvider"))
                      .build();
        }
      }
    }
    return getDeleteAuthProviderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentidentity.v1.UndeleteAuthProviderRequest,
          com.google.cloud.agentidentity.v1.AuthProvider>
      getUndeleteAuthProviderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UndeleteAuthProvider",
      requestType = com.google.cloud.agentidentity.v1.UndeleteAuthProviderRequest.class,
      responseType = com.google.cloud.agentidentity.v1.AuthProvider.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentidentity.v1.UndeleteAuthProviderRequest,
          com.google.cloud.agentidentity.v1.AuthProvider>
      getUndeleteAuthProviderMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentidentity.v1.UndeleteAuthProviderRequest,
            com.google.cloud.agentidentity.v1.AuthProvider>
        getUndeleteAuthProviderMethod;
    if ((getUndeleteAuthProviderMethod = AuthProviderServiceGrpc.getUndeleteAuthProviderMethod)
        == null) {
      synchronized (AuthProviderServiceGrpc.class) {
        if ((getUndeleteAuthProviderMethod = AuthProviderServiceGrpc.getUndeleteAuthProviderMethod)
            == null) {
          AuthProviderServiceGrpc.getUndeleteAuthProviderMethod =
              getUndeleteAuthProviderMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentidentity.v1.UndeleteAuthProviderRequest,
                          com.google.cloud.agentidentity.v1.AuthProvider>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UndeleteAuthProvider"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentidentity.v1.UndeleteAuthProviderRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentidentity.v1.AuthProvider.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AuthProviderServiceMethodDescriptorSupplier("UndeleteAuthProvider"))
                      .build();
        }
      }
    }
    return getUndeleteAuthProviderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentidentity.v1.QueryAuthProvidersRequest,
          com.google.cloud.agentidentity.v1.QueryAuthProvidersResponse>
      getQueryAuthProvidersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryAuthProviders",
      requestType = com.google.cloud.agentidentity.v1.QueryAuthProvidersRequest.class,
      responseType = com.google.cloud.agentidentity.v1.QueryAuthProvidersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentidentity.v1.QueryAuthProvidersRequest,
          com.google.cloud.agentidentity.v1.QueryAuthProvidersResponse>
      getQueryAuthProvidersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentidentity.v1.QueryAuthProvidersRequest,
            com.google.cloud.agentidentity.v1.QueryAuthProvidersResponse>
        getQueryAuthProvidersMethod;
    if ((getQueryAuthProvidersMethod = AuthProviderServiceGrpc.getQueryAuthProvidersMethod)
        == null) {
      synchronized (AuthProviderServiceGrpc.class) {
        if ((getQueryAuthProvidersMethod = AuthProviderServiceGrpc.getQueryAuthProvidersMethod)
            == null) {
          AuthProviderServiceGrpc.getQueryAuthProvidersMethod =
              getQueryAuthProvidersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentidentity.v1.QueryAuthProvidersRequest,
                          com.google.cloud.agentidentity.v1.QueryAuthProvidersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QueryAuthProviders"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentidentity.v1.QueryAuthProvidersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentidentity.v1.QueryAuthProvidersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AuthProviderServiceMethodDescriptorSupplier("QueryAuthProviders"))
                      .build();
        }
      }
    }
    return getQueryAuthProvidersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentidentity.v1.QueryWorkloadsRequest,
          com.google.cloud.agentidentity.v1.QueryWorkloadsResponse>
      getQueryWorkloadsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryWorkloads",
      requestType = com.google.cloud.agentidentity.v1.QueryWorkloadsRequest.class,
      responseType = com.google.cloud.agentidentity.v1.QueryWorkloadsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentidentity.v1.QueryWorkloadsRequest,
          com.google.cloud.agentidentity.v1.QueryWorkloadsResponse>
      getQueryWorkloadsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentidentity.v1.QueryWorkloadsRequest,
            com.google.cloud.agentidentity.v1.QueryWorkloadsResponse>
        getQueryWorkloadsMethod;
    if ((getQueryWorkloadsMethod = AuthProviderServiceGrpc.getQueryWorkloadsMethod) == null) {
      synchronized (AuthProviderServiceGrpc.class) {
        if ((getQueryWorkloadsMethod = AuthProviderServiceGrpc.getQueryWorkloadsMethod) == null) {
          AuthProviderServiceGrpc.getQueryWorkloadsMethod =
              getQueryWorkloadsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentidentity.v1.QueryWorkloadsRequest,
                          com.google.cloud.agentidentity.v1.QueryWorkloadsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QueryWorkloads"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentidentity.v1.QueryWorkloadsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentidentity.v1.QueryWorkloadsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AuthProviderServiceMethodDescriptorSupplier("QueryWorkloads"))
                      .build();
        }
      }
    }
    return getQueryWorkloadsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentidentity.v1.ListAuthorizationsRequest,
          com.google.cloud.agentidentity.v1.ListAuthorizationsResponse>
      getListAuthorizationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAuthorizations",
      requestType = com.google.cloud.agentidentity.v1.ListAuthorizationsRequest.class,
      responseType = com.google.cloud.agentidentity.v1.ListAuthorizationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentidentity.v1.ListAuthorizationsRequest,
          com.google.cloud.agentidentity.v1.ListAuthorizationsResponse>
      getListAuthorizationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentidentity.v1.ListAuthorizationsRequest,
            com.google.cloud.agentidentity.v1.ListAuthorizationsResponse>
        getListAuthorizationsMethod;
    if ((getListAuthorizationsMethod = AuthProviderServiceGrpc.getListAuthorizationsMethod)
        == null) {
      synchronized (AuthProviderServiceGrpc.class) {
        if ((getListAuthorizationsMethod = AuthProviderServiceGrpc.getListAuthorizationsMethod)
            == null) {
          AuthProviderServiceGrpc.getListAuthorizationsMethod =
              getListAuthorizationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentidentity.v1.ListAuthorizationsRequest,
                          com.google.cloud.agentidentity.v1.ListAuthorizationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAuthorizations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentidentity.v1.ListAuthorizationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentidentity.v1.ListAuthorizationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AuthProviderServiceMethodDescriptorSupplier("ListAuthorizations"))
                      .build();
        }
      }
    }
    return getListAuthorizationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentidentity.v1.GetAuthorizationRequest,
          com.google.cloud.agentidentity.v1.Authorization>
      getGetAuthorizationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAuthorization",
      requestType = com.google.cloud.agentidentity.v1.GetAuthorizationRequest.class,
      responseType = com.google.cloud.agentidentity.v1.Authorization.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentidentity.v1.GetAuthorizationRequest,
          com.google.cloud.agentidentity.v1.Authorization>
      getGetAuthorizationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentidentity.v1.GetAuthorizationRequest,
            com.google.cloud.agentidentity.v1.Authorization>
        getGetAuthorizationMethod;
    if ((getGetAuthorizationMethod = AuthProviderServiceGrpc.getGetAuthorizationMethod) == null) {
      synchronized (AuthProviderServiceGrpc.class) {
        if ((getGetAuthorizationMethod = AuthProviderServiceGrpc.getGetAuthorizationMethod)
            == null) {
          AuthProviderServiceGrpc.getGetAuthorizationMethod =
              getGetAuthorizationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentidentity.v1.GetAuthorizationRequest,
                          com.google.cloud.agentidentity.v1.Authorization>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAuthorization"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentidentity.v1.GetAuthorizationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentidentity.v1.Authorization.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AuthProviderServiceMethodDescriptorSupplier("GetAuthorization"))
                      .build();
        }
      }
    }
    return getGetAuthorizationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentidentity.v1.DeleteAuthorizationRequest, com.google.protobuf.Empty>
      getDeleteAuthorizationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAuthorization",
      requestType = com.google.cloud.agentidentity.v1.DeleteAuthorizationRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentidentity.v1.DeleteAuthorizationRequest, com.google.protobuf.Empty>
      getDeleteAuthorizationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentidentity.v1.DeleteAuthorizationRequest, com.google.protobuf.Empty>
        getDeleteAuthorizationMethod;
    if ((getDeleteAuthorizationMethod = AuthProviderServiceGrpc.getDeleteAuthorizationMethod)
        == null) {
      synchronized (AuthProviderServiceGrpc.class) {
        if ((getDeleteAuthorizationMethod = AuthProviderServiceGrpc.getDeleteAuthorizationMethod)
            == null) {
          AuthProviderServiceGrpc.getDeleteAuthorizationMethod =
              getDeleteAuthorizationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentidentity.v1.DeleteAuthorizationRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteAuthorization"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentidentity.v1.DeleteAuthorizationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AuthProviderServiceMethodDescriptorSupplier("DeleteAuthorization"))
                      .build();
        }
      }
    }
    return getDeleteAuthorizationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentidentity.v1.ListAccessSummariesRequest,
          com.google.cloud.agentidentity.v1.ListAccessSummariesResponse>
      getListAccessSummariesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAccessSummaries",
      requestType = com.google.cloud.agentidentity.v1.ListAccessSummariesRequest.class,
      responseType = com.google.cloud.agentidentity.v1.ListAccessSummariesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentidentity.v1.ListAccessSummariesRequest,
          com.google.cloud.agentidentity.v1.ListAccessSummariesResponse>
      getListAccessSummariesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentidentity.v1.ListAccessSummariesRequest,
            com.google.cloud.agentidentity.v1.ListAccessSummariesResponse>
        getListAccessSummariesMethod;
    if ((getListAccessSummariesMethod = AuthProviderServiceGrpc.getListAccessSummariesMethod)
        == null) {
      synchronized (AuthProviderServiceGrpc.class) {
        if ((getListAccessSummariesMethod = AuthProviderServiceGrpc.getListAccessSummariesMethod)
            == null) {
          AuthProviderServiceGrpc.getListAccessSummariesMethod =
              getListAccessSummariesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentidentity.v1.ListAccessSummariesRequest,
                          com.google.cloud.agentidentity.v1.ListAccessSummariesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAccessSummaries"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentidentity.v1.ListAccessSummariesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentidentity.v1.ListAccessSummariesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AuthProviderServiceMethodDescriptorSupplier("ListAccessSummaries"))
                      .build();
        }
      }
    }
    return getListAccessSummariesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentidentity.v1.GetAccessSummaryRequest,
          com.google.cloud.agentidentity.v1.AccessSummary>
      getGetAccessSummaryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccessSummary",
      requestType = com.google.cloud.agentidentity.v1.GetAccessSummaryRequest.class,
      responseType = com.google.cloud.agentidentity.v1.AccessSummary.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentidentity.v1.GetAccessSummaryRequest,
          com.google.cloud.agentidentity.v1.AccessSummary>
      getGetAccessSummaryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentidentity.v1.GetAccessSummaryRequest,
            com.google.cloud.agentidentity.v1.AccessSummary>
        getGetAccessSummaryMethod;
    if ((getGetAccessSummaryMethod = AuthProviderServiceGrpc.getGetAccessSummaryMethod) == null) {
      synchronized (AuthProviderServiceGrpc.class) {
        if ((getGetAccessSummaryMethod = AuthProviderServiceGrpc.getGetAccessSummaryMethod)
            == null) {
          AuthProviderServiceGrpc.getGetAccessSummaryMethod =
              getGetAccessSummaryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentidentity.v1.GetAccessSummaryRequest,
                          com.google.cloud.agentidentity.v1.AccessSummary>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAccessSummary"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentidentity.v1.GetAccessSummaryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentidentity.v1.AccessSummary.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AuthProviderServiceMethodDescriptorSupplier("GetAccessSummary"))
                      .build();
        }
      }
    }
    return getGetAccessSummaryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentidentity.v1.RevokeAuthorizationRequest,
          com.google.cloud.agentidentity.v1.RevokeAuthorizationResponse>
      getRevokeAuthorizationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RevokeAuthorization",
      requestType = com.google.cloud.agentidentity.v1.RevokeAuthorizationRequest.class,
      responseType = com.google.cloud.agentidentity.v1.RevokeAuthorizationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentidentity.v1.RevokeAuthorizationRequest,
          com.google.cloud.agentidentity.v1.RevokeAuthorizationResponse>
      getRevokeAuthorizationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentidentity.v1.RevokeAuthorizationRequest,
            com.google.cloud.agentidentity.v1.RevokeAuthorizationResponse>
        getRevokeAuthorizationMethod;
    if ((getRevokeAuthorizationMethod = AuthProviderServiceGrpc.getRevokeAuthorizationMethod)
        == null) {
      synchronized (AuthProviderServiceGrpc.class) {
        if ((getRevokeAuthorizationMethod = AuthProviderServiceGrpc.getRevokeAuthorizationMethod)
            == null) {
          AuthProviderServiceGrpc.getRevokeAuthorizationMethod =
              getRevokeAuthorizationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentidentity.v1.RevokeAuthorizationRequest,
                          com.google.cloud.agentidentity.v1.RevokeAuthorizationResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RevokeAuthorization"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentidentity.v1.RevokeAuthorizationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentidentity.v1.RevokeAuthorizationResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AuthProviderServiceMethodDescriptorSupplier("RevokeAuthorization"))
                      .build();
        }
      }
    }
    return getRevokeAuthorizationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentidentity.v1.EnableAuthProviderRequest,
          com.google.cloud.agentidentity.v1.AuthProvider>
      getEnableAuthProviderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EnableAuthProvider",
      requestType = com.google.cloud.agentidentity.v1.EnableAuthProviderRequest.class,
      responseType = com.google.cloud.agentidentity.v1.AuthProvider.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentidentity.v1.EnableAuthProviderRequest,
          com.google.cloud.agentidentity.v1.AuthProvider>
      getEnableAuthProviderMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentidentity.v1.EnableAuthProviderRequest,
            com.google.cloud.agentidentity.v1.AuthProvider>
        getEnableAuthProviderMethod;
    if ((getEnableAuthProviderMethod = AuthProviderServiceGrpc.getEnableAuthProviderMethod)
        == null) {
      synchronized (AuthProviderServiceGrpc.class) {
        if ((getEnableAuthProviderMethod = AuthProviderServiceGrpc.getEnableAuthProviderMethod)
            == null) {
          AuthProviderServiceGrpc.getEnableAuthProviderMethod =
              getEnableAuthProviderMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentidentity.v1.EnableAuthProviderRequest,
                          com.google.cloud.agentidentity.v1.AuthProvider>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EnableAuthProvider"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentidentity.v1.EnableAuthProviderRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentidentity.v1.AuthProvider.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AuthProviderServiceMethodDescriptorSupplier("EnableAuthProvider"))
                      .build();
        }
      }
    }
    return getEnableAuthProviderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentidentity.v1.DisableAuthProviderRequest,
          com.google.cloud.agentidentity.v1.AuthProvider>
      getDisableAuthProviderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DisableAuthProvider",
      requestType = com.google.cloud.agentidentity.v1.DisableAuthProviderRequest.class,
      responseType = com.google.cloud.agentidentity.v1.AuthProvider.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentidentity.v1.DisableAuthProviderRequest,
          com.google.cloud.agentidentity.v1.AuthProvider>
      getDisableAuthProviderMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentidentity.v1.DisableAuthProviderRequest,
            com.google.cloud.agentidentity.v1.AuthProvider>
        getDisableAuthProviderMethod;
    if ((getDisableAuthProviderMethod = AuthProviderServiceGrpc.getDisableAuthProviderMethod)
        == null) {
      synchronized (AuthProviderServiceGrpc.class) {
        if ((getDisableAuthProviderMethod = AuthProviderServiceGrpc.getDisableAuthProviderMethod)
            == null) {
          AuthProviderServiceGrpc.getDisableAuthProviderMethod =
              getDisableAuthProviderMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentidentity.v1.DisableAuthProviderRequest,
                          com.google.cloud.agentidentity.v1.AuthProvider>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DisableAuthProvider"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentidentity.v1.DisableAuthProviderRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentidentity.v1.AuthProvider.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AuthProviderServiceMethodDescriptorSupplier("DisableAuthProvider"))
                      .build();
        }
      }
    }
    return getDisableAuthProviderMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AuthProviderServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthProviderServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AuthProviderServiceStub>() {
          @java.lang.Override
          public AuthProviderServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AuthProviderServiceStub(channel, callOptions);
          }
        };
    return AuthProviderServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static AuthProviderServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthProviderServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AuthProviderServiceBlockingV2Stub>() {
          @java.lang.Override
          public AuthProviderServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AuthProviderServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return AuthProviderServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AuthProviderServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthProviderServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AuthProviderServiceBlockingStub>() {
          @java.lang.Override
          public AuthProviderServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AuthProviderServiceBlockingStub(channel, callOptions);
          }
        };
    return AuthProviderServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AuthProviderServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthProviderServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AuthProviderServiceFutureStub>() {
          @java.lang.Override
          public AuthProviderServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AuthProviderServiceFutureStub(channel, callOptions);
          }
        };
    return AuthProviderServiceFutureStub.newStub(factory, channel);
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
     * Lists AuthProviders in a given project and location.
     * </pre>
     */
    default void listAuthProviders(
        com.google.cloud.agentidentity.v1.ListAuthProvidersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.ListAuthProvidersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAuthProvidersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AuthProvider.
     * </pre>
     */
    default void getAuthProvider(
        com.google.cloud.agentidentity.v1.GetAuthProviderRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.AuthProvider>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAuthProviderMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new AuthProvider in a given project and location.
     * </pre>
     */
    default void createAuthProvider(
        com.google.cloud.agentidentity.v1.CreateAuthProviderRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.AuthProvider>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAuthProviderMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single AuthProvider.
     * </pre>
     */
    default void updateAuthProvider(
        com.google.cloud.agentidentity.v1.UpdateAuthProviderRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.AuthProvider>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAuthProviderMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single AuthProvider.
     * </pre>
     */
    default void deleteAuthProvider(
        com.google.cloud.agentidentity.v1.DeleteAuthProviderRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAuthProviderMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Undeletes a single AuthProvider.
     * </pre>
     */
    default void undeleteAuthProvider(
        com.google.cloud.agentidentity.v1.UndeleteAuthProviderRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.AuthProvider>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUndeleteAuthProviderMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Queries what all auth_providers are used by a given workload_id.
     * </pre>
     */
    default void queryAuthProviders(
        com.google.cloud.agentidentity.v1.QueryAuthProvidersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.QueryAuthProvidersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getQueryAuthProvidersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Queries what all workloads are using a given auth_provider.
     * </pre>
     */
    default void queryWorkloads(
        com.google.cloud.agentidentity.v1.QueryWorkloadsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.QueryWorkloadsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getQueryWorkloadsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Authorizations in a given project and location.
     * </pre>
     */
    default void listAuthorizations(
        com.google.cloud.agentidentity.v1.ListAuthorizationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.ListAuthorizationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAuthorizationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Authorization.
     * </pre>
     */
    default void getAuthorization(
        com.google.cloud.agentidentity.v1.GetAuthorizationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.Authorization>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAuthorizationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Authorization.
     * </pre>
     */
    default void deleteAuthorization(
        com.google.cloud.agentidentity.v1.DeleteAuthorizationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAuthorizationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists AccessSummaries in a given project and location.
     * Supported Filters:
     * - `workload_id`: Filter by the SPIFFE ID of the agent.
     *   Example: `workload_id="spiffe://example.com/ns/default/sa/my-agent"`
     * </pre>
     */
    default void listAccessSummaries(
        com.google.cloud.agentidentity.v1.ListAccessSummariesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.ListAccessSummariesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAccessSummariesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AccessSummary.
     * </pre>
     */
    default void getAccessSummary(
        com.google.cloud.agentidentity.v1.GetAccessSummaryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.AccessSummary>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAccessSummaryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Revokes all authorizations for a specific user on an AuthProvider.
     * This deletes all authorization records associated with the user and
     * AuthProvider, effectively revoking access across all agents.
     * </pre>
     */
    default void revokeAuthorization(
        com.google.cloud.agentidentity.v1.RevokeAuthorizationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.RevokeAuthorizationResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRevokeAuthorizationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Enables a single AuthProvider.
     * </pre>
     */
    default void enableAuthProvider(
        com.google.cloud.agentidentity.v1.EnableAuthProviderRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.AuthProvider>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getEnableAuthProviderMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Disables a single AuthProvider.
     * </pre>
     */
    default void disableAuthProvider(
        com.google.cloud.agentidentity.v1.DisableAuthProviderRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.AuthProvider>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDisableAuthProviderMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AuthProviderService.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public abstract static class AuthProviderServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AuthProviderServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AuthProviderService.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class AuthProviderServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AuthProviderServiceStub> {
    private AuthProviderServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthProviderServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthProviderServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists AuthProviders in a given project and location.
     * </pre>
     */
    public void listAuthProviders(
        com.google.cloud.agentidentity.v1.ListAuthProvidersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.ListAuthProvidersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAuthProvidersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AuthProvider.
     * </pre>
     */
    public void getAuthProvider(
        com.google.cloud.agentidentity.v1.GetAuthProviderRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.AuthProvider>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAuthProviderMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new AuthProvider in a given project and location.
     * </pre>
     */
    public void createAuthProvider(
        com.google.cloud.agentidentity.v1.CreateAuthProviderRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.AuthProvider>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAuthProviderMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single AuthProvider.
     * </pre>
     */
    public void updateAuthProvider(
        com.google.cloud.agentidentity.v1.UpdateAuthProviderRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.AuthProvider>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAuthProviderMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single AuthProvider.
     * </pre>
     */
    public void deleteAuthProvider(
        com.google.cloud.agentidentity.v1.DeleteAuthProviderRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAuthProviderMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Undeletes a single AuthProvider.
     * </pre>
     */
    public void undeleteAuthProvider(
        com.google.cloud.agentidentity.v1.UndeleteAuthProviderRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.AuthProvider>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUndeleteAuthProviderMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Queries what all auth_providers are used by a given workload_id.
     * </pre>
     */
    public void queryAuthProviders(
        com.google.cloud.agentidentity.v1.QueryAuthProvidersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.QueryAuthProvidersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQueryAuthProvidersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Queries what all workloads are using a given auth_provider.
     * </pre>
     */
    public void queryWorkloads(
        com.google.cloud.agentidentity.v1.QueryWorkloadsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.QueryWorkloadsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQueryWorkloadsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Authorizations in a given project and location.
     * </pre>
     */
    public void listAuthorizations(
        com.google.cloud.agentidentity.v1.ListAuthorizationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.ListAuthorizationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAuthorizationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Authorization.
     * </pre>
     */
    public void getAuthorization(
        com.google.cloud.agentidentity.v1.GetAuthorizationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.Authorization>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAuthorizationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Authorization.
     * </pre>
     */
    public void deleteAuthorization(
        com.google.cloud.agentidentity.v1.DeleteAuthorizationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAuthorizationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists AccessSummaries in a given project and location.
     * Supported Filters:
     * - `workload_id`: Filter by the SPIFFE ID of the agent.
     *   Example: `workload_id="spiffe://example.com/ns/default/sa/my-agent"`
     * </pre>
     */
    public void listAccessSummaries(
        com.google.cloud.agentidentity.v1.ListAccessSummariesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.ListAccessSummariesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAccessSummariesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AccessSummary.
     * </pre>
     */
    public void getAccessSummary(
        com.google.cloud.agentidentity.v1.GetAccessSummaryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.AccessSummary>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAccessSummaryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Revokes all authorizations for a specific user on an AuthProvider.
     * This deletes all authorization records associated with the user and
     * AuthProvider, effectively revoking access across all agents.
     * </pre>
     */
    public void revokeAuthorization(
        com.google.cloud.agentidentity.v1.RevokeAuthorizationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.RevokeAuthorizationResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRevokeAuthorizationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Enables a single AuthProvider.
     * </pre>
     */
    public void enableAuthProvider(
        com.google.cloud.agentidentity.v1.EnableAuthProviderRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.AuthProvider>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEnableAuthProviderMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Disables a single AuthProvider.
     * </pre>
     */
    public void disableAuthProvider(
        com.google.cloud.agentidentity.v1.DisableAuthProviderRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.AuthProvider>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDisableAuthProviderMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AuthProviderService.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class AuthProviderServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<AuthProviderServiceBlockingV2Stub> {
    private AuthProviderServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthProviderServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthProviderServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists AuthProviders in a given project and location.
     * </pre>
     */
    public com.google.cloud.agentidentity.v1.ListAuthProvidersResponse listAuthProviders(
        com.google.cloud.agentidentity.v1.ListAuthProvidersRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListAuthProvidersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AuthProvider.
     * </pre>
     */
    public com.google.cloud.agentidentity.v1.AuthProvider getAuthProvider(
        com.google.cloud.agentidentity.v1.GetAuthProviderRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetAuthProviderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new AuthProvider in a given project and location.
     * </pre>
     */
    public com.google.cloud.agentidentity.v1.AuthProvider createAuthProvider(
        com.google.cloud.agentidentity.v1.CreateAuthProviderRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateAuthProviderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single AuthProvider.
     * </pre>
     */
    public com.google.cloud.agentidentity.v1.AuthProvider updateAuthProvider(
        com.google.cloud.agentidentity.v1.UpdateAuthProviderRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateAuthProviderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single AuthProvider.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAuthProvider(
        com.google.cloud.agentidentity.v1.DeleteAuthProviderRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteAuthProviderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Undeletes a single AuthProvider.
     * </pre>
     */
    public com.google.cloud.agentidentity.v1.AuthProvider undeleteAuthProvider(
        com.google.cloud.agentidentity.v1.UndeleteAuthProviderRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUndeleteAuthProviderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Queries what all auth_providers are used by a given workload_id.
     * </pre>
     */
    public com.google.cloud.agentidentity.v1.QueryAuthProvidersResponse queryAuthProviders(
        com.google.cloud.agentidentity.v1.QueryAuthProvidersRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getQueryAuthProvidersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Queries what all workloads are using a given auth_provider.
     * </pre>
     */
    public com.google.cloud.agentidentity.v1.QueryWorkloadsResponse queryWorkloads(
        com.google.cloud.agentidentity.v1.QueryWorkloadsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getQueryWorkloadsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Authorizations in a given project and location.
     * </pre>
     */
    public com.google.cloud.agentidentity.v1.ListAuthorizationsResponse listAuthorizations(
        com.google.cloud.agentidentity.v1.ListAuthorizationsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListAuthorizationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Authorization.
     * </pre>
     */
    public com.google.cloud.agentidentity.v1.Authorization getAuthorization(
        com.google.cloud.agentidentity.v1.GetAuthorizationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetAuthorizationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Authorization.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAuthorization(
        com.google.cloud.agentidentity.v1.DeleteAuthorizationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteAuthorizationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists AccessSummaries in a given project and location.
     * Supported Filters:
     * - `workload_id`: Filter by the SPIFFE ID of the agent.
     *   Example: `workload_id="spiffe://example.com/ns/default/sa/my-agent"`
     * </pre>
     */
    public com.google.cloud.agentidentity.v1.ListAccessSummariesResponse listAccessSummaries(
        com.google.cloud.agentidentity.v1.ListAccessSummariesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListAccessSummariesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AccessSummary.
     * </pre>
     */
    public com.google.cloud.agentidentity.v1.AccessSummary getAccessSummary(
        com.google.cloud.agentidentity.v1.GetAccessSummaryRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetAccessSummaryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Revokes all authorizations for a specific user on an AuthProvider.
     * This deletes all authorization records associated with the user and
     * AuthProvider, effectively revoking access across all agents.
     * </pre>
     */
    public com.google.cloud.agentidentity.v1.RevokeAuthorizationResponse revokeAuthorization(
        com.google.cloud.agentidentity.v1.RevokeAuthorizationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRevokeAuthorizationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Enables a single AuthProvider.
     * </pre>
     */
    public com.google.cloud.agentidentity.v1.AuthProvider enableAuthProvider(
        com.google.cloud.agentidentity.v1.EnableAuthProviderRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getEnableAuthProviderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Disables a single AuthProvider.
     * </pre>
     */
    public com.google.cloud.agentidentity.v1.AuthProvider disableAuthProvider(
        com.google.cloud.agentidentity.v1.DisableAuthProviderRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDisableAuthProviderMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service AuthProviderService.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class AuthProviderServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AuthProviderServiceBlockingStub> {
    private AuthProviderServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthProviderServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthProviderServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists AuthProviders in a given project and location.
     * </pre>
     */
    public com.google.cloud.agentidentity.v1.ListAuthProvidersResponse listAuthProviders(
        com.google.cloud.agentidentity.v1.ListAuthProvidersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAuthProvidersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AuthProvider.
     * </pre>
     */
    public com.google.cloud.agentidentity.v1.AuthProvider getAuthProvider(
        com.google.cloud.agentidentity.v1.GetAuthProviderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAuthProviderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new AuthProvider in a given project and location.
     * </pre>
     */
    public com.google.cloud.agentidentity.v1.AuthProvider createAuthProvider(
        com.google.cloud.agentidentity.v1.CreateAuthProviderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAuthProviderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single AuthProvider.
     * </pre>
     */
    public com.google.cloud.agentidentity.v1.AuthProvider updateAuthProvider(
        com.google.cloud.agentidentity.v1.UpdateAuthProviderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAuthProviderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single AuthProvider.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAuthProvider(
        com.google.cloud.agentidentity.v1.DeleteAuthProviderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAuthProviderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Undeletes a single AuthProvider.
     * </pre>
     */
    public com.google.cloud.agentidentity.v1.AuthProvider undeleteAuthProvider(
        com.google.cloud.agentidentity.v1.UndeleteAuthProviderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeleteAuthProviderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Queries what all auth_providers are used by a given workload_id.
     * </pre>
     */
    public com.google.cloud.agentidentity.v1.QueryAuthProvidersResponse queryAuthProviders(
        com.google.cloud.agentidentity.v1.QueryAuthProvidersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryAuthProvidersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Queries what all workloads are using a given auth_provider.
     * </pre>
     */
    public com.google.cloud.agentidentity.v1.QueryWorkloadsResponse queryWorkloads(
        com.google.cloud.agentidentity.v1.QueryWorkloadsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryWorkloadsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Authorizations in a given project and location.
     * </pre>
     */
    public com.google.cloud.agentidentity.v1.ListAuthorizationsResponse listAuthorizations(
        com.google.cloud.agentidentity.v1.ListAuthorizationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAuthorizationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Authorization.
     * </pre>
     */
    public com.google.cloud.agentidentity.v1.Authorization getAuthorization(
        com.google.cloud.agentidentity.v1.GetAuthorizationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAuthorizationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Authorization.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAuthorization(
        com.google.cloud.agentidentity.v1.DeleteAuthorizationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAuthorizationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists AccessSummaries in a given project and location.
     * Supported Filters:
     * - `workload_id`: Filter by the SPIFFE ID of the agent.
     *   Example: `workload_id="spiffe://example.com/ns/default/sa/my-agent"`
     * </pre>
     */
    public com.google.cloud.agentidentity.v1.ListAccessSummariesResponse listAccessSummaries(
        com.google.cloud.agentidentity.v1.ListAccessSummariesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAccessSummariesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AccessSummary.
     * </pre>
     */
    public com.google.cloud.agentidentity.v1.AccessSummary getAccessSummary(
        com.google.cloud.agentidentity.v1.GetAccessSummaryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAccessSummaryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Revokes all authorizations for a specific user on an AuthProvider.
     * This deletes all authorization records associated with the user and
     * AuthProvider, effectively revoking access across all agents.
     * </pre>
     */
    public com.google.cloud.agentidentity.v1.RevokeAuthorizationResponse revokeAuthorization(
        com.google.cloud.agentidentity.v1.RevokeAuthorizationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRevokeAuthorizationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Enables a single AuthProvider.
     * </pre>
     */
    public com.google.cloud.agentidentity.v1.AuthProvider enableAuthProvider(
        com.google.cloud.agentidentity.v1.EnableAuthProviderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEnableAuthProviderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Disables a single AuthProvider.
     * </pre>
     */
    public com.google.cloud.agentidentity.v1.AuthProvider disableAuthProvider(
        com.google.cloud.agentidentity.v1.DisableAuthProviderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDisableAuthProviderMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AuthProviderService.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class AuthProviderServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AuthProviderServiceFutureStub> {
    private AuthProviderServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthProviderServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthProviderServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists AuthProviders in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentidentity.v1.ListAuthProvidersResponse>
        listAuthProviders(com.google.cloud.agentidentity.v1.ListAuthProvidersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAuthProvidersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AuthProvider.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentidentity.v1.AuthProvider>
        getAuthProvider(com.google.cloud.agentidentity.v1.GetAuthProviderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAuthProviderMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new AuthProvider in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentidentity.v1.AuthProvider>
        createAuthProvider(com.google.cloud.agentidentity.v1.CreateAuthProviderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAuthProviderMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single AuthProvider.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentidentity.v1.AuthProvider>
        updateAuthProvider(com.google.cloud.agentidentity.v1.UpdateAuthProviderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAuthProviderMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single AuthProvider.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteAuthProvider(com.google.cloud.agentidentity.v1.DeleteAuthProviderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAuthProviderMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Undeletes a single AuthProvider.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentidentity.v1.AuthProvider>
        undeleteAuthProvider(
            com.google.cloud.agentidentity.v1.UndeleteAuthProviderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUndeleteAuthProviderMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Queries what all auth_providers are used by a given workload_id.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentidentity.v1.QueryAuthProvidersResponse>
        queryAuthProviders(com.google.cloud.agentidentity.v1.QueryAuthProvidersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQueryAuthProvidersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Queries what all workloads are using a given auth_provider.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentidentity.v1.QueryWorkloadsResponse>
        queryWorkloads(com.google.cloud.agentidentity.v1.QueryWorkloadsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQueryWorkloadsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Authorizations in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentidentity.v1.ListAuthorizationsResponse>
        listAuthorizations(com.google.cloud.agentidentity.v1.ListAuthorizationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAuthorizationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Authorization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentidentity.v1.Authorization>
        getAuthorization(com.google.cloud.agentidentity.v1.GetAuthorizationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAuthorizationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Authorization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteAuthorization(com.google.cloud.agentidentity.v1.DeleteAuthorizationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAuthorizationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists AccessSummaries in a given project and location.
     * Supported Filters:
     * - `workload_id`: Filter by the SPIFFE ID of the agent.
     *   Example: `workload_id="spiffe://example.com/ns/default/sa/my-agent"`
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentidentity.v1.ListAccessSummariesResponse>
        listAccessSummaries(com.google.cloud.agentidentity.v1.ListAccessSummariesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAccessSummariesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AccessSummary.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentidentity.v1.AccessSummary>
        getAccessSummary(com.google.cloud.agentidentity.v1.GetAccessSummaryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAccessSummaryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Revokes all authorizations for a specific user on an AuthProvider.
     * This deletes all authorization records associated with the user and
     * AuthProvider, effectively revoking access across all agents.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentidentity.v1.RevokeAuthorizationResponse>
        revokeAuthorization(com.google.cloud.agentidentity.v1.RevokeAuthorizationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRevokeAuthorizationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Enables a single AuthProvider.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentidentity.v1.AuthProvider>
        enableAuthProvider(com.google.cloud.agentidentity.v1.EnableAuthProviderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEnableAuthProviderMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Disables a single AuthProvider.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentidentity.v1.AuthProvider>
        disableAuthProvider(com.google.cloud.agentidentity.v1.DisableAuthProviderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDisableAuthProviderMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_AUTH_PROVIDERS = 0;
  private static final int METHODID_GET_AUTH_PROVIDER = 1;
  private static final int METHODID_CREATE_AUTH_PROVIDER = 2;
  private static final int METHODID_UPDATE_AUTH_PROVIDER = 3;
  private static final int METHODID_DELETE_AUTH_PROVIDER = 4;
  private static final int METHODID_UNDELETE_AUTH_PROVIDER = 5;
  private static final int METHODID_QUERY_AUTH_PROVIDERS = 6;
  private static final int METHODID_QUERY_WORKLOADS = 7;
  private static final int METHODID_LIST_AUTHORIZATIONS = 8;
  private static final int METHODID_GET_AUTHORIZATION = 9;
  private static final int METHODID_DELETE_AUTHORIZATION = 10;
  private static final int METHODID_LIST_ACCESS_SUMMARIES = 11;
  private static final int METHODID_GET_ACCESS_SUMMARY = 12;
  private static final int METHODID_REVOKE_AUTHORIZATION = 13;
  private static final int METHODID_ENABLE_AUTH_PROVIDER = 14;
  private static final int METHODID_DISABLE_AUTH_PROVIDER = 15;

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
        case METHODID_LIST_AUTH_PROVIDERS:
          serviceImpl.listAuthProviders(
              (com.google.cloud.agentidentity.v1.ListAuthProvidersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.agentidentity.v1.ListAuthProvidersResponse>)
                  responseObserver);
          break;
        case METHODID_GET_AUTH_PROVIDER:
          serviceImpl.getAuthProvider(
              (com.google.cloud.agentidentity.v1.GetAuthProviderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.AuthProvider>)
                  responseObserver);
          break;
        case METHODID_CREATE_AUTH_PROVIDER:
          serviceImpl.createAuthProvider(
              (com.google.cloud.agentidentity.v1.CreateAuthProviderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.AuthProvider>)
                  responseObserver);
          break;
        case METHODID_UPDATE_AUTH_PROVIDER:
          serviceImpl.updateAuthProvider(
              (com.google.cloud.agentidentity.v1.UpdateAuthProviderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.AuthProvider>)
                  responseObserver);
          break;
        case METHODID_DELETE_AUTH_PROVIDER:
          serviceImpl.deleteAuthProvider(
              (com.google.cloud.agentidentity.v1.DeleteAuthProviderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UNDELETE_AUTH_PROVIDER:
          serviceImpl.undeleteAuthProvider(
              (com.google.cloud.agentidentity.v1.UndeleteAuthProviderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.AuthProvider>)
                  responseObserver);
          break;
        case METHODID_QUERY_AUTH_PROVIDERS:
          serviceImpl.queryAuthProviders(
              (com.google.cloud.agentidentity.v1.QueryAuthProvidersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.agentidentity.v1.QueryAuthProvidersResponse>)
                  responseObserver);
          break;
        case METHODID_QUERY_WORKLOADS:
          serviceImpl.queryWorkloads(
              (com.google.cloud.agentidentity.v1.QueryWorkloadsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.agentidentity.v1.QueryWorkloadsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_AUTHORIZATIONS:
          serviceImpl.listAuthorizations(
              (com.google.cloud.agentidentity.v1.ListAuthorizationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.agentidentity.v1.ListAuthorizationsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_AUTHORIZATION:
          serviceImpl.getAuthorization(
              (com.google.cloud.agentidentity.v1.GetAuthorizationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.Authorization>)
                  responseObserver);
          break;
        case METHODID_DELETE_AUTHORIZATION:
          serviceImpl.deleteAuthorization(
              (com.google.cloud.agentidentity.v1.DeleteAuthorizationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_ACCESS_SUMMARIES:
          serviceImpl.listAccessSummaries(
              (com.google.cloud.agentidentity.v1.ListAccessSummariesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.agentidentity.v1.ListAccessSummariesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ACCESS_SUMMARY:
          serviceImpl.getAccessSummary(
              (com.google.cloud.agentidentity.v1.GetAccessSummaryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.AccessSummary>)
                  responseObserver);
          break;
        case METHODID_REVOKE_AUTHORIZATION:
          serviceImpl.revokeAuthorization(
              (com.google.cloud.agentidentity.v1.RevokeAuthorizationRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.agentidentity.v1.RevokeAuthorizationResponse>)
                  responseObserver);
          break;
        case METHODID_ENABLE_AUTH_PROVIDER:
          serviceImpl.enableAuthProvider(
              (com.google.cloud.agentidentity.v1.EnableAuthProviderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.AuthProvider>)
                  responseObserver);
          break;
        case METHODID_DISABLE_AUTH_PROVIDER:
          serviceImpl.disableAuthProvider(
              (com.google.cloud.agentidentity.v1.DisableAuthProviderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.agentidentity.v1.AuthProvider>)
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
            getListAuthProvidersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentidentity.v1.ListAuthProvidersRequest,
                    com.google.cloud.agentidentity.v1.ListAuthProvidersResponse>(
                    service, METHODID_LIST_AUTH_PROVIDERS)))
        .addMethod(
            getGetAuthProviderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentidentity.v1.GetAuthProviderRequest,
                    com.google.cloud.agentidentity.v1.AuthProvider>(
                    service, METHODID_GET_AUTH_PROVIDER)))
        .addMethod(
            getCreateAuthProviderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentidentity.v1.CreateAuthProviderRequest,
                    com.google.cloud.agentidentity.v1.AuthProvider>(
                    service, METHODID_CREATE_AUTH_PROVIDER)))
        .addMethod(
            getUpdateAuthProviderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentidentity.v1.UpdateAuthProviderRequest,
                    com.google.cloud.agentidentity.v1.AuthProvider>(
                    service, METHODID_UPDATE_AUTH_PROVIDER)))
        .addMethod(
            getDeleteAuthProviderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentidentity.v1.DeleteAuthProviderRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_AUTH_PROVIDER)))
        .addMethod(
            getUndeleteAuthProviderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentidentity.v1.UndeleteAuthProviderRequest,
                    com.google.cloud.agentidentity.v1.AuthProvider>(
                    service, METHODID_UNDELETE_AUTH_PROVIDER)))
        .addMethod(
            getQueryAuthProvidersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentidentity.v1.QueryAuthProvidersRequest,
                    com.google.cloud.agentidentity.v1.QueryAuthProvidersResponse>(
                    service, METHODID_QUERY_AUTH_PROVIDERS)))
        .addMethod(
            getQueryWorkloadsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentidentity.v1.QueryWorkloadsRequest,
                    com.google.cloud.agentidentity.v1.QueryWorkloadsResponse>(
                    service, METHODID_QUERY_WORKLOADS)))
        .addMethod(
            getListAuthorizationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentidentity.v1.ListAuthorizationsRequest,
                    com.google.cloud.agentidentity.v1.ListAuthorizationsResponse>(
                    service, METHODID_LIST_AUTHORIZATIONS)))
        .addMethod(
            getGetAuthorizationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentidentity.v1.GetAuthorizationRequest,
                    com.google.cloud.agentidentity.v1.Authorization>(
                    service, METHODID_GET_AUTHORIZATION)))
        .addMethod(
            getDeleteAuthorizationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentidentity.v1.DeleteAuthorizationRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_AUTHORIZATION)))
        .addMethod(
            getListAccessSummariesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentidentity.v1.ListAccessSummariesRequest,
                    com.google.cloud.agentidentity.v1.ListAccessSummariesResponse>(
                    service, METHODID_LIST_ACCESS_SUMMARIES)))
        .addMethod(
            getGetAccessSummaryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentidentity.v1.GetAccessSummaryRequest,
                    com.google.cloud.agentidentity.v1.AccessSummary>(
                    service, METHODID_GET_ACCESS_SUMMARY)))
        .addMethod(
            getRevokeAuthorizationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentidentity.v1.RevokeAuthorizationRequest,
                    com.google.cloud.agentidentity.v1.RevokeAuthorizationResponse>(
                    service, METHODID_REVOKE_AUTHORIZATION)))
        .addMethod(
            getEnableAuthProviderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentidentity.v1.EnableAuthProviderRequest,
                    com.google.cloud.agentidentity.v1.AuthProvider>(
                    service, METHODID_ENABLE_AUTH_PROVIDER)))
        .addMethod(
            getDisableAuthProviderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentidentity.v1.DisableAuthProviderRequest,
                    com.google.cloud.agentidentity.v1.AuthProvider>(
                    service, METHODID_DISABLE_AUTH_PROVIDER)))
        .build();
  }

  private abstract static class AuthProviderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AuthProviderServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.agentidentity.v1.AuthProviderServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AuthProviderService");
    }
  }

  private static final class AuthProviderServiceFileDescriptorSupplier
      extends AuthProviderServiceBaseDescriptorSupplier {
    AuthProviderServiceFileDescriptorSupplier() {}
  }

  private static final class AuthProviderServiceMethodDescriptorSupplier
      extends AuthProviderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AuthProviderServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AuthProviderServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AuthProviderServiceFileDescriptorSupplier())
                      .addMethod(getListAuthProvidersMethod())
                      .addMethod(getGetAuthProviderMethod())
                      .addMethod(getCreateAuthProviderMethod())
                      .addMethod(getUpdateAuthProviderMethod())
                      .addMethod(getDeleteAuthProviderMethod())
                      .addMethod(getUndeleteAuthProviderMethod())
                      .addMethod(getQueryAuthProvidersMethod())
                      .addMethod(getQueryWorkloadsMethod())
                      .addMethod(getListAuthorizationsMethod())
                      .addMethod(getGetAuthorizationMethod())
                      .addMethod(getDeleteAuthorizationMethod())
                      .addMethod(getListAccessSummariesMethod())
                      .addMethod(getGetAccessSummaryMethod())
                      .addMethod(getRevokeAuthorizationMethod())
                      .addMethod(getEnableAuthProviderMethod())
                      .addMethod(getDisableAuthProviderMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
