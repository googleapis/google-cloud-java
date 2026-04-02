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
package com.google.cloud.networksecurity.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Network Security API provides resources to configure authentication and
 * authorization policies. Refer to per API resource documentation for more
 * information.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class NetworkSecurityGrpc {

  private NetworkSecurityGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.networksecurity.v1.NetworkSecurity";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesRequest,
          com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesResponse>
      getListAuthorizationPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAuthorizationPolicies",
      requestType = com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesRequest.class,
      responseType = com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesRequest,
          com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesResponse>
      getListAuthorizationPoliciesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesRequest,
            com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesResponse>
        getListAuthorizationPoliciesMethod;
    if ((getListAuthorizationPoliciesMethod =
            NetworkSecurityGrpc.getListAuthorizationPoliciesMethod)
        == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getListAuthorizationPoliciesMethod =
                NetworkSecurityGrpc.getListAuthorizationPoliciesMethod)
            == null) {
          NetworkSecurityGrpc.getListAuthorizationPoliciesMethod =
              getListAuthorizationPoliciesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesRequest,
                          com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAuthorizationPolicies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier("ListAuthorizationPolicies"))
                      .build();
        }
      }
    }
    return getListAuthorizationPoliciesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetAuthorizationPolicyRequest,
          com.google.cloud.networksecurity.v1.AuthorizationPolicy>
      getGetAuthorizationPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAuthorizationPolicy",
      requestType = com.google.cloud.networksecurity.v1.GetAuthorizationPolicyRequest.class,
      responseType = com.google.cloud.networksecurity.v1.AuthorizationPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetAuthorizationPolicyRequest,
          com.google.cloud.networksecurity.v1.AuthorizationPolicy>
      getGetAuthorizationPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.GetAuthorizationPolicyRequest,
            com.google.cloud.networksecurity.v1.AuthorizationPolicy>
        getGetAuthorizationPolicyMethod;
    if ((getGetAuthorizationPolicyMethod = NetworkSecurityGrpc.getGetAuthorizationPolicyMethod)
        == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getGetAuthorizationPolicyMethod = NetworkSecurityGrpc.getGetAuthorizationPolicyMethod)
            == null) {
          NetworkSecurityGrpc.getGetAuthorizationPolicyMethod =
              getGetAuthorizationPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.GetAuthorizationPolicyRequest,
                          com.google.cloud.networksecurity.v1.AuthorizationPolicy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetAuthorizationPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.GetAuthorizationPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.AuthorizationPolicy
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier("GetAuthorizationPolicy"))
                      .build();
        }
      }
    }
    return getGetAuthorizationPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateAuthorizationPolicyRequest,
          com.google.longrunning.Operation>
      getCreateAuthorizationPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAuthorizationPolicy",
      requestType = com.google.cloud.networksecurity.v1.CreateAuthorizationPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateAuthorizationPolicyRequest,
          com.google.longrunning.Operation>
      getCreateAuthorizationPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.CreateAuthorizationPolicyRequest,
            com.google.longrunning.Operation>
        getCreateAuthorizationPolicyMethod;
    if ((getCreateAuthorizationPolicyMethod =
            NetworkSecurityGrpc.getCreateAuthorizationPolicyMethod)
        == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getCreateAuthorizationPolicyMethod =
                NetworkSecurityGrpc.getCreateAuthorizationPolicyMethod)
            == null) {
          NetworkSecurityGrpc.getCreateAuthorizationPolicyMethod =
              getCreateAuthorizationPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.CreateAuthorizationPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateAuthorizationPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.CreateAuthorizationPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier("CreateAuthorizationPolicy"))
                      .build();
        }
      }
    }
    return getCreateAuthorizationPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateAuthorizationPolicyRequest,
          com.google.longrunning.Operation>
      getUpdateAuthorizationPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAuthorizationPolicy",
      requestType = com.google.cloud.networksecurity.v1.UpdateAuthorizationPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateAuthorizationPolicyRequest,
          com.google.longrunning.Operation>
      getUpdateAuthorizationPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.UpdateAuthorizationPolicyRequest,
            com.google.longrunning.Operation>
        getUpdateAuthorizationPolicyMethod;
    if ((getUpdateAuthorizationPolicyMethod =
            NetworkSecurityGrpc.getUpdateAuthorizationPolicyMethod)
        == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getUpdateAuthorizationPolicyMethod =
                NetworkSecurityGrpc.getUpdateAuthorizationPolicyMethod)
            == null) {
          NetworkSecurityGrpc.getUpdateAuthorizationPolicyMethod =
              getUpdateAuthorizationPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.UpdateAuthorizationPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateAuthorizationPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.UpdateAuthorizationPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier("UpdateAuthorizationPolicy"))
                      .build();
        }
      }
    }
    return getUpdateAuthorizationPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteAuthorizationPolicyRequest,
          com.google.longrunning.Operation>
      getDeleteAuthorizationPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAuthorizationPolicy",
      requestType = com.google.cloud.networksecurity.v1.DeleteAuthorizationPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteAuthorizationPolicyRequest,
          com.google.longrunning.Operation>
      getDeleteAuthorizationPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.DeleteAuthorizationPolicyRequest,
            com.google.longrunning.Operation>
        getDeleteAuthorizationPolicyMethod;
    if ((getDeleteAuthorizationPolicyMethod =
            NetworkSecurityGrpc.getDeleteAuthorizationPolicyMethod)
        == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getDeleteAuthorizationPolicyMethod =
                NetworkSecurityGrpc.getDeleteAuthorizationPolicyMethod)
            == null) {
          NetworkSecurityGrpc.getDeleteAuthorizationPolicyMethod =
              getDeleteAuthorizationPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.DeleteAuthorizationPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteAuthorizationPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.DeleteAuthorizationPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier("DeleteAuthorizationPolicy"))
                      .build();
        }
      }
    }
    return getDeleteAuthorizationPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListBackendAuthenticationConfigsRequest,
          com.google.cloud.networksecurity.v1.ListBackendAuthenticationConfigsResponse>
      getListBackendAuthenticationConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBackendAuthenticationConfigs",
      requestType =
          com.google.cloud.networksecurity.v1.ListBackendAuthenticationConfigsRequest.class,
      responseType =
          com.google.cloud.networksecurity.v1.ListBackendAuthenticationConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListBackendAuthenticationConfigsRequest,
          com.google.cloud.networksecurity.v1.ListBackendAuthenticationConfigsResponse>
      getListBackendAuthenticationConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.ListBackendAuthenticationConfigsRequest,
            com.google.cloud.networksecurity.v1.ListBackendAuthenticationConfigsResponse>
        getListBackendAuthenticationConfigsMethod;
    if ((getListBackendAuthenticationConfigsMethod =
            NetworkSecurityGrpc.getListBackendAuthenticationConfigsMethod)
        == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getListBackendAuthenticationConfigsMethod =
                NetworkSecurityGrpc.getListBackendAuthenticationConfigsMethod)
            == null) {
          NetworkSecurityGrpc.getListBackendAuthenticationConfigsMethod =
              getListBackendAuthenticationConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.ListBackendAuthenticationConfigsRequest,
                          com.google.cloud.networksecurity.v1
                              .ListBackendAuthenticationConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListBackendAuthenticationConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .ListBackendAuthenticationConfigsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .ListBackendAuthenticationConfigsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier(
                              "ListBackendAuthenticationConfigs"))
                      .build();
        }
      }
    }
    return getListBackendAuthenticationConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetBackendAuthenticationConfigRequest,
          com.google.cloud.networksecurity.v1.BackendAuthenticationConfig>
      getGetBackendAuthenticationConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBackendAuthenticationConfig",
      requestType = com.google.cloud.networksecurity.v1.GetBackendAuthenticationConfigRequest.class,
      responseType = com.google.cloud.networksecurity.v1.BackendAuthenticationConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetBackendAuthenticationConfigRequest,
          com.google.cloud.networksecurity.v1.BackendAuthenticationConfig>
      getGetBackendAuthenticationConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.GetBackendAuthenticationConfigRequest,
            com.google.cloud.networksecurity.v1.BackendAuthenticationConfig>
        getGetBackendAuthenticationConfigMethod;
    if ((getGetBackendAuthenticationConfigMethod =
            NetworkSecurityGrpc.getGetBackendAuthenticationConfigMethod)
        == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getGetBackendAuthenticationConfigMethod =
                NetworkSecurityGrpc.getGetBackendAuthenticationConfigMethod)
            == null) {
          NetworkSecurityGrpc.getGetBackendAuthenticationConfigMethod =
              getGetBackendAuthenticationConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.GetBackendAuthenticationConfigRequest,
                          com.google.cloud.networksecurity.v1.BackendAuthenticationConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetBackendAuthenticationConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .GetBackendAuthenticationConfigRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.BackendAuthenticationConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier(
                              "GetBackendAuthenticationConfig"))
                      .build();
        }
      }
    }
    return getGetBackendAuthenticationConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateBackendAuthenticationConfigRequest,
          com.google.longrunning.Operation>
      getCreateBackendAuthenticationConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBackendAuthenticationConfig",
      requestType =
          com.google.cloud.networksecurity.v1.CreateBackendAuthenticationConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateBackendAuthenticationConfigRequest,
          com.google.longrunning.Operation>
      getCreateBackendAuthenticationConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.CreateBackendAuthenticationConfigRequest,
            com.google.longrunning.Operation>
        getCreateBackendAuthenticationConfigMethod;
    if ((getCreateBackendAuthenticationConfigMethod =
            NetworkSecurityGrpc.getCreateBackendAuthenticationConfigMethod)
        == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getCreateBackendAuthenticationConfigMethod =
                NetworkSecurityGrpc.getCreateBackendAuthenticationConfigMethod)
            == null) {
          NetworkSecurityGrpc.getCreateBackendAuthenticationConfigMethod =
              getCreateBackendAuthenticationConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1
                              .CreateBackendAuthenticationConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateBackendAuthenticationConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .CreateBackendAuthenticationConfigRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier(
                              "CreateBackendAuthenticationConfig"))
                      .build();
        }
      }
    }
    return getCreateBackendAuthenticationConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateBackendAuthenticationConfigRequest,
          com.google.longrunning.Operation>
      getUpdateBackendAuthenticationConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBackendAuthenticationConfig",
      requestType =
          com.google.cloud.networksecurity.v1.UpdateBackendAuthenticationConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateBackendAuthenticationConfigRequest,
          com.google.longrunning.Operation>
      getUpdateBackendAuthenticationConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.UpdateBackendAuthenticationConfigRequest,
            com.google.longrunning.Operation>
        getUpdateBackendAuthenticationConfigMethod;
    if ((getUpdateBackendAuthenticationConfigMethod =
            NetworkSecurityGrpc.getUpdateBackendAuthenticationConfigMethod)
        == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getUpdateBackendAuthenticationConfigMethod =
                NetworkSecurityGrpc.getUpdateBackendAuthenticationConfigMethod)
            == null) {
          NetworkSecurityGrpc.getUpdateBackendAuthenticationConfigMethod =
              getUpdateBackendAuthenticationConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1
                              .UpdateBackendAuthenticationConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateBackendAuthenticationConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .UpdateBackendAuthenticationConfigRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier(
                              "UpdateBackendAuthenticationConfig"))
                      .build();
        }
      }
    }
    return getUpdateBackendAuthenticationConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteBackendAuthenticationConfigRequest,
          com.google.longrunning.Operation>
      getDeleteBackendAuthenticationConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBackendAuthenticationConfig",
      requestType =
          com.google.cloud.networksecurity.v1.DeleteBackendAuthenticationConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteBackendAuthenticationConfigRequest,
          com.google.longrunning.Operation>
      getDeleteBackendAuthenticationConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.DeleteBackendAuthenticationConfigRequest,
            com.google.longrunning.Operation>
        getDeleteBackendAuthenticationConfigMethod;
    if ((getDeleteBackendAuthenticationConfigMethod =
            NetworkSecurityGrpc.getDeleteBackendAuthenticationConfigMethod)
        == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getDeleteBackendAuthenticationConfigMethod =
                NetworkSecurityGrpc.getDeleteBackendAuthenticationConfigMethod)
            == null) {
          NetworkSecurityGrpc.getDeleteBackendAuthenticationConfigMethod =
              getDeleteBackendAuthenticationConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1
                              .DeleteBackendAuthenticationConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteBackendAuthenticationConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .DeleteBackendAuthenticationConfigRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier(
                              "DeleteBackendAuthenticationConfig"))
                      .build();
        }
      }
    }
    return getDeleteBackendAuthenticationConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListServerTlsPoliciesRequest,
          com.google.cloud.networksecurity.v1.ListServerTlsPoliciesResponse>
      getListServerTlsPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListServerTlsPolicies",
      requestType = com.google.cloud.networksecurity.v1.ListServerTlsPoliciesRequest.class,
      responseType = com.google.cloud.networksecurity.v1.ListServerTlsPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListServerTlsPoliciesRequest,
          com.google.cloud.networksecurity.v1.ListServerTlsPoliciesResponse>
      getListServerTlsPoliciesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.ListServerTlsPoliciesRequest,
            com.google.cloud.networksecurity.v1.ListServerTlsPoliciesResponse>
        getListServerTlsPoliciesMethod;
    if ((getListServerTlsPoliciesMethod = NetworkSecurityGrpc.getListServerTlsPoliciesMethod)
        == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getListServerTlsPoliciesMethod = NetworkSecurityGrpc.getListServerTlsPoliciesMethod)
            == null) {
          NetworkSecurityGrpc.getListServerTlsPoliciesMethod =
              getListServerTlsPoliciesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.ListServerTlsPoliciesRequest,
                          com.google.cloud.networksecurity.v1.ListServerTlsPoliciesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListServerTlsPolicies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ListServerTlsPoliciesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ListServerTlsPoliciesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier("ListServerTlsPolicies"))
                      .build();
        }
      }
    }
    return getListServerTlsPoliciesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetServerTlsPolicyRequest,
          com.google.cloud.networksecurity.v1.ServerTlsPolicy>
      getGetServerTlsPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetServerTlsPolicy",
      requestType = com.google.cloud.networksecurity.v1.GetServerTlsPolicyRequest.class,
      responseType = com.google.cloud.networksecurity.v1.ServerTlsPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetServerTlsPolicyRequest,
          com.google.cloud.networksecurity.v1.ServerTlsPolicy>
      getGetServerTlsPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.GetServerTlsPolicyRequest,
            com.google.cloud.networksecurity.v1.ServerTlsPolicy>
        getGetServerTlsPolicyMethod;
    if ((getGetServerTlsPolicyMethod = NetworkSecurityGrpc.getGetServerTlsPolicyMethod) == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getGetServerTlsPolicyMethod = NetworkSecurityGrpc.getGetServerTlsPolicyMethod)
            == null) {
          NetworkSecurityGrpc.getGetServerTlsPolicyMethod =
              getGetServerTlsPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.GetServerTlsPolicyRequest,
                          com.google.cloud.networksecurity.v1.ServerTlsPolicy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetServerTlsPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.GetServerTlsPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ServerTlsPolicy
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier("GetServerTlsPolicy"))
                      .build();
        }
      }
    }
    return getGetServerTlsPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateServerTlsPolicyRequest,
          com.google.longrunning.Operation>
      getCreateServerTlsPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateServerTlsPolicy",
      requestType = com.google.cloud.networksecurity.v1.CreateServerTlsPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateServerTlsPolicyRequest,
          com.google.longrunning.Operation>
      getCreateServerTlsPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.CreateServerTlsPolicyRequest,
            com.google.longrunning.Operation>
        getCreateServerTlsPolicyMethod;
    if ((getCreateServerTlsPolicyMethod = NetworkSecurityGrpc.getCreateServerTlsPolicyMethod)
        == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getCreateServerTlsPolicyMethod = NetworkSecurityGrpc.getCreateServerTlsPolicyMethod)
            == null) {
          NetworkSecurityGrpc.getCreateServerTlsPolicyMethod =
              getCreateServerTlsPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.CreateServerTlsPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateServerTlsPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.CreateServerTlsPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier("CreateServerTlsPolicy"))
                      .build();
        }
      }
    }
    return getCreateServerTlsPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateServerTlsPolicyRequest,
          com.google.longrunning.Operation>
      getUpdateServerTlsPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateServerTlsPolicy",
      requestType = com.google.cloud.networksecurity.v1.UpdateServerTlsPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateServerTlsPolicyRequest,
          com.google.longrunning.Operation>
      getUpdateServerTlsPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.UpdateServerTlsPolicyRequest,
            com.google.longrunning.Operation>
        getUpdateServerTlsPolicyMethod;
    if ((getUpdateServerTlsPolicyMethod = NetworkSecurityGrpc.getUpdateServerTlsPolicyMethod)
        == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getUpdateServerTlsPolicyMethod = NetworkSecurityGrpc.getUpdateServerTlsPolicyMethod)
            == null) {
          NetworkSecurityGrpc.getUpdateServerTlsPolicyMethod =
              getUpdateServerTlsPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.UpdateServerTlsPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateServerTlsPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.UpdateServerTlsPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier("UpdateServerTlsPolicy"))
                      .build();
        }
      }
    }
    return getUpdateServerTlsPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteServerTlsPolicyRequest,
          com.google.longrunning.Operation>
      getDeleteServerTlsPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteServerTlsPolicy",
      requestType = com.google.cloud.networksecurity.v1.DeleteServerTlsPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteServerTlsPolicyRequest,
          com.google.longrunning.Operation>
      getDeleteServerTlsPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.DeleteServerTlsPolicyRequest,
            com.google.longrunning.Operation>
        getDeleteServerTlsPolicyMethod;
    if ((getDeleteServerTlsPolicyMethod = NetworkSecurityGrpc.getDeleteServerTlsPolicyMethod)
        == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getDeleteServerTlsPolicyMethod = NetworkSecurityGrpc.getDeleteServerTlsPolicyMethod)
            == null) {
          NetworkSecurityGrpc.getDeleteServerTlsPolicyMethod =
              getDeleteServerTlsPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.DeleteServerTlsPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteServerTlsPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.DeleteServerTlsPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier("DeleteServerTlsPolicy"))
                      .build();
        }
      }
    }
    return getDeleteServerTlsPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListClientTlsPoliciesRequest,
          com.google.cloud.networksecurity.v1.ListClientTlsPoliciesResponse>
      getListClientTlsPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListClientTlsPolicies",
      requestType = com.google.cloud.networksecurity.v1.ListClientTlsPoliciesRequest.class,
      responseType = com.google.cloud.networksecurity.v1.ListClientTlsPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListClientTlsPoliciesRequest,
          com.google.cloud.networksecurity.v1.ListClientTlsPoliciesResponse>
      getListClientTlsPoliciesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.ListClientTlsPoliciesRequest,
            com.google.cloud.networksecurity.v1.ListClientTlsPoliciesResponse>
        getListClientTlsPoliciesMethod;
    if ((getListClientTlsPoliciesMethod = NetworkSecurityGrpc.getListClientTlsPoliciesMethod)
        == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getListClientTlsPoliciesMethod = NetworkSecurityGrpc.getListClientTlsPoliciesMethod)
            == null) {
          NetworkSecurityGrpc.getListClientTlsPoliciesMethod =
              getListClientTlsPoliciesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.ListClientTlsPoliciesRequest,
                          com.google.cloud.networksecurity.v1.ListClientTlsPoliciesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListClientTlsPolicies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ListClientTlsPoliciesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ListClientTlsPoliciesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier("ListClientTlsPolicies"))
                      .build();
        }
      }
    }
    return getListClientTlsPoliciesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetClientTlsPolicyRequest,
          com.google.cloud.networksecurity.v1.ClientTlsPolicy>
      getGetClientTlsPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetClientTlsPolicy",
      requestType = com.google.cloud.networksecurity.v1.GetClientTlsPolicyRequest.class,
      responseType = com.google.cloud.networksecurity.v1.ClientTlsPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetClientTlsPolicyRequest,
          com.google.cloud.networksecurity.v1.ClientTlsPolicy>
      getGetClientTlsPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.GetClientTlsPolicyRequest,
            com.google.cloud.networksecurity.v1.ClientTlsPolicy>
        getGetClientTlsPolicyMethod;
    if ((getGetClientTlsPolicyMethod = NetworkSecurityGrpc.getGetClientTlsPolicyMethod) == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getGetClientTlsPolicyMethod = NetworkSecurityGrpc.getGetClientTlsPolicyMethod)
            == null) {
          NetworkSecurityGrpc.getGetClientTlsPolicyMethod =
              getGetClientTlsPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.GetClientTlsPolicyRequest,
                          com.google.cloud.networksecurity.v1.ClientTlsPolicy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetClientTlsPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.GetClientTlsPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ClientTlsPolicy
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier("GetClientTlsPolicy"))
                      .build();
        }
      }
    }
    return getGetClientTlsPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateClientTlsPolicyRequest,
          com.google.longrunning.Operation>
      getCreateClientTlsPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateClientTlsPolicy",
      requestType = com.google.cloud.networksecurity.v1.CreateClientTlsPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateClientTlsPolicyRequest,
          com.google.longrunning.Operation>
      getCreateClientTlsPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.CreateClientTlsPolicyRequest,
            com.google.longrunning.Operation>
        getCreateClientTlsPolicyMethod;
    if ((getCreateClientTlsPolicyMethod = NetworkSecurityGrpc.getCreateClientTlsPolicyMethod)
        == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getCreateClientTlsPolicyMethod = NetworkSecurityGrpc.getCreateClientTlsPolicyMethod)
            == null) {
          NetworkSecurityGrpc.getCreateClientTlsPolicyMethod =
              getCreateClientTlsPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.CreateClientTlsPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateClientTlsPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.CreateClientTlsPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier("CreateClientTlsPolicy"))
                      .build();
        }
      }
    }
    return getCreateClientTlsPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateClientTlsPolicyRequest,
          com.google.longrunning.Operation>
      getUpdateClientTlsPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateClientTlsPolicy",
      requestType = com.google.cloud.networksecurity.v1.UpdateClientTlsPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateClientTlsPolicyRequest,
          com.google.longrunning.Operation>
      getUpdateClientTlsPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.UpdateClientTlsPolicyRequest,
            com.google.longrunning.Operation>
        getUpdateClientTlsPolicyMethod;
    if ((getUpdateClientTlsPolicyMethod = NetworkSecurityGrpc.getUpdateClientTlsPolicyMethod)
        == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getUpdateClientTlsPolicyMethod = NetworkSecurityGrpc.getUpdateClientTlsPolicyMethod)
            == null) {
          NetworkSecurityGrpc.getUpdateClientTlsPolicyMethod =
              getUpdateClientTlsPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.UpdateClientTlsPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateClientTlsPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.UpdateClientTlsPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier("UpdateClientTlsPolicy"))
                      .build();
        }
      }
    }
    return getUpdateClientTlsPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteClientTlsPolicyRequest,
          com.google.longrunning.Operation>
      getDeleteClientTlsPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteClientTlsPolicy",
      requestType = com.google.cloud.networksecurity.v1.DeleteClientTlsPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteClientTlsPolicyRequest,
          com.google.longrunning.Operation>
      getDeleteClientTlsPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.DeleteClientTlsPolicyRequest,
            com.google.longrunning.Operation>
        getDeleteClientTlsPolicyMethod;
    if ((getDeleteClientTlsPolicyMethod = NetworkSecurityGrpc.getDeleteClientTlsPolicyMethod)
        == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getDeleteClientTlsPolicyMethod = NetworkSecurityGrpc.getDeleteClientTlsPolicyMethod)
            == null) {
          NetworkSecurityGrpc.getDeleteClientTlsPolicyMethod =
              getDeleteClientTlsPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.DeleteClientTlsPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteClientTlsPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.DeleteClientTlsPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier("DeleteClientTlsPolicy"))
                      .build();
        }
      }
    }
    return getDeleteClientTlsPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListGatewaySecurityPoliciesRequest,
          com.google.cloud.networksecurity.v1.ListGatewaySecurityPoliciesResponse>
      getListGatewaySecurityPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListGatewaySecurityPolicies",
      requestType = com.google.cloud.networksecurity.v1.ListGatewaySecurityPoliciesRequest.class,
      responseType = com.google.cloud.networksecurity.v1.ListGatewaySecurityPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListGatewaySecurityPoliciesRequest,
          com.google.cloud.networksecurity.v1.ListGatewaySecurityPoliciesResponse>
      getListGatewaySecurityPoliciesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.ListGatewaySecurityPoliciesRequest,
            com.google.cloud.networksecurity.v1.ListGatewaySecurityPoliciesResponse>
        getListGatewaySecurityPoliciesMethod;
    if ((getListGatewaySecurityPoliciesMethod =
            NetworkSecurityGrpc.getListGatewaySecurityPoliciesMethod)
        == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getListGatewaySecurityPoliciesMethod =
                NetworkSecurityGrpc.getListGatewaySecurityPoliciesMethod)
            == null) {
          NetworkSecurityGrpc.getListGatewaySecurityPoliciesMethod =
              getListGatewaySecurityPoliciesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.ListGatewaySecurityPoliciesRequest,
                          com.google.cloud.networksecurity.v1.ListGatewaySecurityPoliciesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListGatewaySecurityPolicies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ListGatewaySecurityPoliciesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .ListGatewaySecurityPoliciesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier(
                              "ListGatewaySecurityPolicies"))
                      .build();
        }
      }
    }
    return getListGatewaySecurityPoliciesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetGatewaySecurityPolicyRequest,
          com.google.cloud.networksecurity.v1.GatewaySecurityPolicy>
      getGetGatewaySecurityPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGatewaySecurityPolicy",
      requestType = com.google.cloud.networksecurity.v1.GetGatewaySecurityPolicyRequest.class,
      responseType = com.google.cloud.networksecurity.v1.GatewaySecurityPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetGatewaySecurityPolicyRequest,
          com.google.cloud.networksecurity.v1.GatewaySecurityPolicy>
      getGetGatewaySecurityPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.GetGatewaySecurityPolicyRequest,
            com.google.cloud.networksecurity.v1.GatewaySecurityPolicy>
        getGetGatewaySecurityPolicyMethod;
    if ((getGetGatewaySecurityPolicyMethod = NetworkSecurityGrpc.getGetGatewaySecurityPolicyMethod)
        == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getGetGatewaySecurityPolicyMethod =
                NetworkSecurityGrpc.getGetGatewaySecurityPolicyMethod)
            == null) {
          NetworkSecurityGrpc.getGetGatewaySecurityPolicyMethod =
              getGetGatewaySecurityPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.GetGatewaySecurityPolicyRequest,
                          com.google.cloud.networksecurity.v1.GatewaySecurityPolicy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetGatewaySecurityPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.GetGatewaySecurityPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.GatewaySecurityPolicy
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier("GetGatewaySecurityPolicy"))
                      .build();
        }
      }
    }
    return getGetGatewaySecurityPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateGatewaySecurityPolicyRequest,
          com.google.longrunning.Operation>
      getCreateGatewaySecurityPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateGatewaySecurityPolicy",
      requestType = com.google.cloud.networksecurity.v1.CreateGatewaySecurityPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateGatewaySecurityPolicyRequest,
          com.google.longrunning.Operation>
      getCreateGatewaySecurityPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.CreateGatewaySecurityPolicyRequest,
            com.google.longrunning.Operation>
        getCreateGatewaySecurityPolicyMethod;
    if ((getCreateGatewaySecurityPolicyMethod =
            NetworkSecurityGrpc.getCreateGatewaySecurityPolicyMethod)
        == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getCreateGatewaySecurityPolicyMethod =
                NetworkSecurityGrpc.getCreateGatewaySecurityPolicyMethod)
            == null) {
          NetworkSecurityGrpc.getCreateGatewaySecurityPolicyMethod =
              getCreateGatewaySecurityPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.CreateGatewaySecurityPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateGatewaySecurityPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.CreateGatewaySecurityPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier(
                              "CreateGatewaySecurityPolicy"))
                      .build();
        }
      }
    }
    return getCreateGatewaySecurityPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateGatewaySecurityPolicyRequest,
          com.google.longrunning.Operation>
      getUpdateGatewaySecurityPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateGatewaySecurityPolicy",
      requestType = com.google.cloud.networksecurity.v1.UpdateGatewaySecurityPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateGatewaySecurityPolicyRequest,
          com.google.longrunning.Operation>
      getUpdateGatewaySecurityPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.UpdateGatewaySecurityPolicyRequest,
            com.google.longrunning.Operation>
        getUpdateGatewaySecurityPolicyMethod;
    if ((getUpdateGatewaySecurityPolicyMethod =
            NetworkSecurityGrpc.getUpdateGatewaySecurityPolicyMethod)
        == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getUpdateGatewaySecurityPolicyMethod =
                NetworkSecurityGrpc.getUpdateGatewaySecurityPolicyMethod)
            == null) {
          NetworkSecurityGrpc.getUpdateGatewaySecurityPolicyMethod =
              getUpdateGatewaySecurityPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.UpdateGatewaySecurityPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateGatewaySecurityPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.UpdateGatewaySecurityPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier(
                              "UpdateGatewaySecurityPolicy"))
                      .build();
        }
      }
    }
    return getUpdateGatewaySecurityPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteGatewaySecurityPolicyRequest,
          com.google.longrunning.Operation>
      getDeleteGatewaySecurityPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteGatewaySecurityPolicy",
      requestType = com.google.cloud.networksecurity.v1.DeleteGatewaySecurityPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteGatewaySecurityPolicyRequest,
          com.google.longrunning.Operation>
      getDeleteGatewaySecurityPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.DeleteGatewaySecurityPolicyRequest,
            com.google.longrunning.Operation>
        getDeleteGatewaySecurityPolicyMethod;
    if ((getDeleteGatewaySecurityPolicyMethod =
            NetworkSecurityGrpc.getDeleteGatewaySecurityPolicyMethod)
        == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getDeleteGatewaySecurityPolicyMethod =
                NetworkSecurityGrpc.getDeleteGatewaySecurityPolicyMethod)
            == null) {
          NetworkSecurityGrpc.getDeleteGatewaySecurityPolicyMethod =
              getDeleteGatewaySecurityPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.DeleteGatewaySecurityPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteGatewaySecurityPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.DeleteGatewaySecurityPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier(
                              "DeleteGatewaySecurityPolicy"))
                      .build();
        }
      }
    }
    return getDeleteGatewaySecurityPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListGatewaySecurityPolicyRulesRequest,
          com.google.cloud.networksecurity.v1.ListGatewaySecurityPolicyRulesResponse>
      getListGatewaySecurityPolicyRulesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListGatewaySecurityPolicyRules",
      requestType = com.google.cloud.networksecurity.v1.ListGatewaySecurityPolicyRulesRequest.class,
      responseType =
          com.google.cloud.networksecurity.v1.ListGatewaySecurityPolicyRulesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListGatewaySecurityPolicyRulesRequest,
          com.google.cloud.networksecurity.v1.ListGatewaySecurityPolicyRulesResponse>
      getListGatewaySecurityPolicyRulesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.ListGatewaySecurityPolicyRulesRequest,
            com.google.cloud.networksecurity.v1.ListGatewaySecurityPolicyRulesResponse>
        getListGatewaySecurityPolicyRulesMethod;
    if ((getListGatewaySecurityPolicyRulesMethod =
            NetworkSecurityGrpc.getListGatewaySecurityPolicyRulesMethod)
        == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getListGatewaySecurityPolicyRulesMethod =
                NetworkSecurityGrpc.getListGatewaySecurityPolicyRulesMethod)
            == null) {
          NetworkSecurityGrpc.getListGatewaySecurityPolicyRulesMethod =
              getListGatewaySecurityPolicyRulesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.ListGatewaySecurityPolicyRulesRequest,
                          com.google.cloud.networksecurity.v1
                              .ListGatewaySecurityPolicyRulesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListGatewaySecurityPolicyRules"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .ListGatewaySecurityPolicyRulesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .ListGatewaySecurityPolicyRulesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier(
                              "ListGatewaySecurityPolicyRules"))
                      .build();
        }
      }
    }
    return getListGatewaySecurityPolicyRulesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetGatewaySecurityPolicyRuleRequest,
          com.google.cloud.networksecurity.v1.GatewaySecurityPolicyRule>
      getGetGatewaySecurityPolicyRuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGatewaySecurityPolicyRule",
      requestType = com.google.cloud.networksecurity.v1.GetGatewaySecurityPolicyRuleRequest.class,
      responseType = com.google.cloud.networksecurity.v1.GatewaySecurityPolicyRule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetGatewaySecurityPolicyRuleRequest,
          com.google.cloud.networksecurity.v1.GatewaySecurityPolicyRule>
      getGetGatewaySecurityPolicyRuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.GetGatewaySecurityPolicyRuleRequest,
            com.google.cloud.networksecurity.v1.GatewaySecurityPolicyRule>
        getGetGatewaySecurityPolicyRuleMethod;
    if ((getGetGatewaySecurityPolicyRuleMethod =
            NetworkSecurityGrpc.getGetGatewaySecurityPolicyRuleMethod)
        == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getGetGatewaySecurityPolicyRuleMethod =
                NetworkSecurityGrpc.getGetGatewaySecurityPolicyRuleMethod)
            == null) {
          NetworkSecurityGrpc.getGetGatewaySecurityPolicyRuleMethod =
              getGetGatewaySecurityPolicyRuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.GetGatewaySecurityPolicyRuleRequest,
                          com.google.cloud.networksecurity.v1.GatewaySecurityPolicyRule>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetGatewaySecurityPolicyRule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .GetGatewaySecurityPolicyRuleRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.GatewaySecurityPolicyRule
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier(
                              "GetGatewaySecurityPolicyRule"))
                      .build();
        }
      }
    }
    return getGetGatewaySecurityPolicyRuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateGatewaySecurityPolicyRuleRequest,
          com.google.longrunning.Operation>
      getCreateGatewaySecurityPolicyRuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateGatewaySecurityPolicyRule",
      requestType =
          com.google.cloud.networksecurity.v1.CreateGatewaySecurityPolicyRuleRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateGatewaySecurityPolicyRuleRequest,
          com.google.longrunning.Operation>
      getCreateGatewaySecurityPolicyRuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.CreateGatewaySecurityPolicyRuleRequest,
            com.google.longrunning.Operation>
        getCreateGatewaySecurityPolicyRuleMethod;
    if ((getCreateGatewaySecurityPolicyRuleMethod =
            NetworkSecurityGrpc.getCreateGatewaySecurityPolicyRuleMethod)
        == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getCreateGatewaySecurityPolicyRuleMethod =
                NetworkSecurityGrpc.getCreateGatewaySecurityPolicyRuleMethod)
            == null) {
          NetworkSecurityGrpc.getCreateGatewaySecurityPolicyRuleMethod =
              getCreateGatewaySecurityPolicyRuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.CreateGatewaySecurityPolicyRuleRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateGatewaySecurityPolicyRule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .CreateGatewaySecurityPolicyRuleRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier(
                              "CreateGatewaySecurityPolicyRule"))
                      .build();
        }
      }
    }
    return getCreateGatewaySecurityPolicyRuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateGatewaySecurityPolicyRuleRequest,
          com.google.longrunning.Operation>
      getUpdateGatewaySecurityPolicyRuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateGatewaySecurityPolicyRule",
      requestType =
          com.google.cloud.networksecurity.v1.UpdateGatewaySecurityPolicyRuleRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateGatewaySecurityPolicyRuleRequest,
          com.google.longrunning.Operation>
      getUpdateGatewaySecurityPolicyRuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.UpdateGatewaySecurityPolicyRuleRequest,
            com.google.longrunning.Operation>
        getUpdateGatewaySecurityPolicyRuleMethod;
    if ((getUpdateGatewaySecurityPolicyRuleMethod =
            NetworkSecurityGrpc.getUpdateGatewaySecurityPolicyRuleMethod)
        == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getUpdateGatewaySecurityPolicyRuleMethod =
                NetworkSecurityGrpc.getUpdateGatewaySecurityPolicyRuleMethod)
            == null) {
          NetworkSecurityGrpc.getUpdateGatewaySecurityPolicyRuleMethod =
              getUpdateGatewaySecurityPolicyRuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.UpdateGatewaySecurityPolicyRuleRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateGatewaySecurityPolicyRule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .UpdateGatewaySecurityPolicyRuleRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier(
                              "UpdateGatewaySecurityPolicyRule"))
                      .build();
        }
      }
    }
    return getUpdateGatewaySecurityPolicyRuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteGatewaySecurityPolicyRuleRequest,
          com.google.longrunning.Operation>
      getDeleteGatewaySecurityPolicyRuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteGatewaySecurityPolicyRule",
      requestType =
          com.google.cloud.networksecurity.v1.DeleteGatewaySecurityPolicyRuleRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteGatewaySecurityPolicyRuleRequest,
          com.google.longrunning.Operation>
      getDeleteGatewaySecurityPolicyRuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.DeleteGatewaySecurityPolicyRuleRequest,
            com.google.longrunning.Operation>
        getDeleteGatewaySecurityPolicyRuleMethod;
    if ((getDeleteGatewaySecurityPolicyRuleMethod =
            NetworkSecurityGrpc.getDeleteGatewaySecurityPolicyRuleMethod)
        == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getDeleteGatewaySecurityPolicyRuleMethod =
                NetworkSecurityGrpc.getDeleteGatewaySecurityPolicyRuleMethod)
            == null) {
          NetworkSecurityGrpc.getDeleteGatewaySecurityPolicyRuleMethod =
              getDeleteGatewaySecurityPolicyRuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.DeleteGatewaySecurityPolicyRuleRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteGatewaySecurityPolicyRule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .DeleteGatewaySecurityPolicyRuleRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier(
                              "DeleteGatewaySecurityPolicyRule"))
                      .build();
        }
      }
    }
    return getDeleteGatewaySecurityPolicyRuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListUrlListsRequest,
          com.google.cloud.networksecurity.v1.ListUrlListsResponse>
      getListUrlListsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListUrlLists",
      requestType = com.google.cloud.networksecurity.v1.ListUrlListsRequest.class,
      responseType = com.google.cloud.networksecurity.v1.ListUrlListsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListUrlListsRequest,
          com.google.cloud.networksecurity.v1.ListUrlListsResponse>
      getListUrlListsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.ListUrlListsRequest,
            com.google.cloud.networksecurity.v1.ListUrlListsResponse>
        getListUrlListsMethod;
    if ((getListUrlListsMethod = NetworkSecurityGrpc.getListUrlListsMethod) == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getListUrlListsMethod = NetworkSecurityGrpc.getListUrlListsMethod) == null) {
          NetworkSecurityGrpc.getListUrlListsMethod =
              getListUrlListsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.ListUrlListsRequest,
                          com.google.cloud.networksecurity.v1.ListUrlListsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListUrlLists"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ListUrlListsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ListUrlListsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier("ListUrlLists"))
                      .build();
        }
      }
    }
    return getListUrlListsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetUrlListRequest,
          com.google.cloud.networksecurity.v1.UrlList>
      getGetUrlListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUrlList",
      requestType = com.google.cloud.networksecurity.v1.GetUrlListRequest.class,
      responseType = com.google.cloud.networksecurity.v1.UrlList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetUrlListRequest,
          com.google.cloud.networksecurity.v1.UrlList>
      getGetUrlListMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.GetUrlListRequest,
            com.google.cloud.networksecurity.v1.UrlList>
        getGetUrlListMethod;
    if ((getGetUrlListMethod = NetworkSecurityGrpc.getGetUrlListMethod) == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getGetUrlListMethod = NetworkSecurityGrpc.getGetUrlListMethod) == null) {
          NetworkSecurityGrpc.getGetUrlListMethod =
              getGetUrlListMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.GetUrlListRequest,
                          com.google.cloud.networksecurity.v1.UrlList>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUrlList"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.GetUrlListRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.UrlList.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier("GetUrlList"))
                      .build();
        }
      }
    }
    return getGetUrlListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateUrlListRequest,
          com.google.longrunning.Operation>
      getCreateUrlListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUrlList",
      requestType = com.google.cloud.networksecurity.v1.CreateUrlListRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateUrlListRequest,
          com.google.longrunning.Operation>
      getCreateUrlListMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.CreateUrlListRequest,
            com.google.longrunning.Operation>
        getCreateUrlListMethod;
    if ((getCreateUrlListMethod = NetworkSecurityGrpc.getCreateUrlListMethod) == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getCreateUrlListMethod = NetworkSecurityGrpc.getCreateUrlListMethod) == null) {
          NetworkSecurityGrpc.getCreateUrlListMethod =
              getCreateUrlListMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.CreateUrlListRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateUrlList"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.CreateUrlListRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier("CreateUrlList"))
                      .build();
        }
      }
    }
    return getCreateUrlListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateUrlListRequest,
          com.google.longrunning.Operation>
      getUpdateUrlListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUrlList",
      requestType = com.google.cloud.networksecurity.v1.UpdateUrlListRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateUrlListRequest,
          com.google.longrunning.Operation>
      getUpdateUrlListMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.UpdateUrlListRequest,
            com.google.longrunning.Operation>
        getUpdateUrlListMethod;
    if ((getUpdateUrlListMethod = NetworkSecurityGrpc.getUpdateUrlListMethod) == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getUpdateUrlListMethod = NetworkSecurityGrpc.getUpdateUrlListMethod) == null) {
          NetworkSecurityGrpc.getUpdateUrlListMethod =
              getUpdateUrlListMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.UpdateUrlListRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateUrlList"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.UpdateUrlListRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier("UpdateUrlList"))
                      .build();
        }
      }
    }
    return getUpdateUrlListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteUrlListRequest,
          com.google.longrunning.Operation>
      getDeleteUrlListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteUrlList",
      requestType = com.google.cloud.networksecurity.v1.DeleteUrlListRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteUrlListRequest,
          com.google.longrunning.Operation>
      getDeleteUrlListMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.DeleteUrlListRequest,
            com.google.longrunning.Operation>
        getDeleteUrlListMethod;
    if ((getDeleteUrlListMethod = NetworkSecurityGrpc.getDeleteUrlListMethod) == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getDeleteUrlListMethod = NetworkSecurityGrpc.getDeleteUrlListMethod) == null) {
          NetworkSecurityGrpc.getDeleteUrlListMethod =
              getDeleteUrlListMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.DeleteUrlListRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteUrlList"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.DeleteUrlListRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier("DeleteUrlList"))
                      .build();
        }
      }
    }
    return getDeleteUrlListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListTlsInspectionPoliciesRequest,
          com.google.cloud.networksecurity.v1.ListTlsInspectionPoliciesResponse>
      getListTlsInspectionPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTlsInspectionPolicies",
      requestType = com.google.cloud.networksecurity.v1.ListTlsInspectionPoliciesRequest.class,
      responseType = com.google.cloud.networksecurity.v1.ListTlsInspectionPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListTlsInspectionPoliciesRequest,
          com.google.cloud.networksecurity.v1.ListTlsInspectionPoliciesResponse>
      getListTlsInspectionPoliciesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.ListTlsInspectionPoliciesRequest,
            com.google.cloud.networksecurity.v1.ListTlsInspectionPoliciesResponse>
        getListTlsInspectionPoliciesMethod;
    if ((getListTlsInspectionPoliciesMethod =
            NetworkSecurityGrpc.getListTlsInspectionPoliciesMethod)
        == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getListTlsInspectionPoliciesMethod =
                NetworkSecurityGrpc.getListTlsInspectionPoliciesMethod)
            == null) {
          NetworkSecurityGrpc.getListTlsInspectionPoliciesMethod =
              getListTlsInspectionPoliciesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.ListTlsInspectionPoliciesRequest,
                          com.google.cloud.networksecurity.v1.ListTlsInspectionPoliciesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListTlsInspectionPolicies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ListTlsInspectionPoliciesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ListTlsInspectionPoliciesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier("ListTlsInspectionPolicies"))
                      .build();
        }
      }
    }
    return getListTlsInspectionPoliciesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetTlsInspectionPolicyRequest,
          com.google.cloud.networksecurity.v1.TlsInspectionPolicy>
      getGetTlsInspectionPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTlsInspectionPolicy",
      requestType = com.google.cloud.networksecurity.v1.GetTlsInspectionPolicyRequest.class,
      responseType = com.google.cloud.networksecurity.v1.TlsInspectionPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetTlsInspectionPolicyRequest,
          com.google.cloud.networksecurity.v1.TlsInspectionPolicy>
      getGetTlsInspectionPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.GetTlsInspectionPolicyRequest,
            com.google.cloud.networksecurity.v1.TlsInspectionPolicy>
        getGetTlsInspectionPolicyMethod;
    if ((getGetTlsInspectionPolicyMethod = NetworkSecurityGrpc.getGetTlsInspectionPolicyMethod)
        == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getGetTlsInspectionPolicyMethod = NetworkSecurityGrpc.getGetTlsInspectionPolicyMethod)
            == null) {
          NetworkSecurityGrpc.getGetTlsInspectionPolicyMethod =
              getGetTlsInspectionPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.GetTlsInspectionPolicyRequest,
                          com.google.cloud.networksecurity.v1.TlsInspectionPolicy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetTlsInspectionPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.GetTlsInspectionPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.TlsInspectionPolicy
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier("GetTlsInspectionPolicy"))
                      .build();
        }
      }
    }
    return getGetTlsInspectionPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateTlsInspectionPolicyRequest,
          com.google.longrunning.Operation>
      getCreateTlsInspectionPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTlsInspectionPolicy",
      requestType = com.google.cloud.networksecurity.v1.CreateTlsInspectionPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateTlsInspectionPolicyRequest,
          com.google.longrunning.Operation>
      getCreateTlsInspectionPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.CreateTlsInspectionPolicyRequest,
            com.google.longrunning.Operation>
        getCreateTlsInspectionPolicyMethod;
    if ((getCreateTlsInspectionPolicyMethod =
            NetworkSecurityGrpc.getCreateTlsInspectionPolicyMethod)
        == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getCreateTlsInspectionPolicyMethod =
                NetworkSecurityGrpc.getCreateTlsInspectionPolicyMethod)
            == null) {
          NetworkSecurityGrpc.getCreateTlsInspectionPolicyMethod =
              getCreateTlsInspectionPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.CreateTlsInspectionPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateTlsInspectionPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.CreateTlsInspectionPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier("CreateTlsInspectionPolicy"))
                      .build();
        }
      }
    }
    return getCreateTlsInspectionPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateTlsInspectionPolicyRequest,
          com.google.longrunning.Operation>
      getUpdateTlsInspectionPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTlsInspectionPolicy",
      requestType = com.google.cloud.networksecurity.v1.UpdateTlsInspectionPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateTlsInspectionPolicyRequest,
          com.google.longrunning.Operation>
      getUpdateTlsInspectionPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.UpdateTlsInspectionPolicyRequest,
            com.google.longrunning.Operation>
        getUpdateTlsInspectionPolicyMethod;
    if ((getUpdateTlsInspectionPolicyMethod =
            NetworkSecurityGrpc.getUpdateTlsInspectionPolicyMethod)
        == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getUpdateTlsInspectionPolicyMethod =
                NetworkSecurityGrpc.getUpdateTlsInspectionPolicyMethod)
            == null) {
          NetworkSecurityGrpc.getUpdateTlsInspectionPolicyMethod =
              getUpdateTlsInspectionPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.UpdateTlsInspectionPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateTlsInspectionPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.UpdateTlsInspectionPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier("UpdateTlsInspectionPolicy"))
                      .build();
        }
      }
    }
    return getUpdateTlsInspectionPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteTlsInspectionPolicyRequest,
          com.google.longrunning.Operation>
      getDeleteTlsInspectionPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTlsInspectionPolicy",
      requestType = com.google.cloud.networksecurity.v1.DeleteTlsInspectionPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteTlsInspectionPolicyRequest,
          com.google.longrunning.Operation>
      getDeleteTlsInspectionPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.DeleteTlsInspectionPolicyRequest,
            com.google.longrunning.Operation>
        getDeleteTlsInspectionPolicyMethod;
    if ((getDeleteTlsInspectionPolicyMethod =
            NetworkSecurityGrpc.getDeleteTlsInspectionPolicyMethod)
        == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getDeleteTlsInspectionPolicyMethod =
                NetworkSecurityGrpc.getDeleteTlsInspectionPolicyMethod)
            == null) {
          NetworkSecurityGrpc.getDeleteTlsInspectionPolicyMethod =
              getDeleteTlsInspectionPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.DeleteTlsInspectionPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteTlsInspectionPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.DeleteTlsInspectionPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier("DeleteTlsInspectionPolicy"))
                      .build();
        }
      }
    }
    return getDeleteTlsInspectionPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListAuthzPoliciesRequest,
          com.google.cloud.networksecurity.v1.ListAuthzPoliciesResponse>
      getListAuthzPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAuthzPolicies",
      requestType = com.google.cloud.networksecurity.v1.ListAuthzPoliciesRequest.class,
      responseType = com.google.cloud.networksecurity.v1.ListAuthzPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListAuthzPoliciesRequest,
          com.google.cloud.networksecurity.v1.ListAuthzPoliciesResponse>
      getListAuthzPoliciesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.ListAuthzPoliciesRequest,
            com.google.cloud.networksecurity.v1.ListAuthzPoliciesResponse>
        getListAuthzPoliciesMethod;
    if ((getListAuthzPoliciesMethod = NetworkSecurityGrpc.getListAuthzPoliciesMethod) == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getListAuthzPoliciesMethod = NetworkSecurityGrpc.getListAuthzPoliciesMethod) == null) {
          NetworkSecurityGrpc.getListAuthzPoliciesMethod =
              getListAuthzPoliciesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.ListAuthzPoliciesRequest,
                          com.google.cloud.networksecurity.v1.ListAuthzPoliciesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAuthzPolicies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ListAuthzPoliciesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ListAuthzPoliciesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier("ListAuthzPolicies"))
                      .build();
        }
      }
    }
    return getListAuthzPoliciesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetAuthzPolicyRequest,
          com.google.cloud.networksecurity.v1.AuthzPolicy>
      getGetAuthzPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAuthzPolicy",
      requestType = com.google.cloud.networksecurity.v1.GetAuthzPolicyRequest.class,
      responseType = com.google.cloud.networksecurity.v1.AuthzPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetAuthzPolicyRequest,
          com.google.cloud.networksecurity.v1.AuthzPolicy>
      getGetAuthzPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.GetAuthzPolicyRequest,
            com.google.cloud.networksecurity.v1.AuthzPolicy>
        getGetAuthzPolicyMethod;
    if ((getGetAuthzPolicyMethod = NetworkSecurityGrpc.getGetAuthzPolicyMethod) == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getGetAuthzPolicyMethod = NetworkSecurityGrpc.getGetAuthzPolicyMethod) == null) {
          NetworkSecurityGrpc.getGetAuthzPolicyMethod =
              getGetAuthzPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.GetAuthzPolicyRequest,
                          com.google.cloud.networksecurity.v1.AuthzPolicy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAuthzPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.GetAuthzPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.AuthzPolicy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier("GetAuthzPolicy"))
                      .build();
        }
      }
    }
    return getGetAuthzPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateAuthzPolicyRequest,
          com.google.longrunning.Operation>
      getCreateAuthzPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAuthzPolicy",
      requestType = com.google.cloud.networksecurity.v1.CreateAuthzPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateAuthzPolicyRequest,
          com.google.longrunning.Operation>
      getCreateAuthzPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.CreateAuthzPolicyRequest,
            com.google.longrunning.Operation>
        getCreateAuthzPolicyMethod;
    if ((getCreateAuthzPolicyMethod = NetworkSecurityGrpc.getCreateAuthzPolicyMethod) == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getCreateAuthzPolicyMethod = NetworkSecurityGrpc.getCreateAuthzPolicyMethod) == null) {
          NetworkSecurityGrpc.getCreateAuthzPolicyMethod =
              getCreateAuthzPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.CreateAuthzPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAuthzPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.CreateAuthzPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier("CreateAuthzPolicy"))
                      .build();
        }
      }
    }
    return getCreateAuthzPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateAuthzPolicyRequest,
          com.google.longrunning.Operation>
      getUpdateAuthzPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAuthzPolicy",
      requestType = com.google.cloud.networksecurity.v1.UpdateAuthzPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateAuthzPolicyRequest,
          com.google.longrunning.Operation>
      getUpdateAuthzPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.UpdateAuthzPolicyRequest,
            com.google.longrunning.Operation>
        getUpdateAuthzPolicyMethod;
    if ((getUpdateAuthzPolicyMethod = NetworkSecurityGrpc.getUpdateAuthzPolicyMethod) == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getUpdateAuthzPolicyMethod = NetworkSecurityGrpc.getUpdateAuthzPolicyMethod) == null) {
          NetworkSecurityGrpc.getUpdateAuthzPolicyMethod =
              getUpdateAuthzPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.UpdateAuthzPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAuthzPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.UpdateAuthzPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier("UpdateAuthzPolicy"))
                      .build();
        }
      }
    }
    return getUpdateAuthzPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteAuthzPolicyRequest,
          com.google.longrunning.Operation>
      getDeleteAuthzPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAuthzPolicy",
      requestType = com.google.cloud.networksecurity.v1.DeleteAuthzPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteAuthzPolicyRequest,
          com.google.longrunning.Operation>
      getDeleteAuthzPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.DeleteAuthzPolicyRequest,
            com.google.longrunning.Operation>
        getDeleteAuthzPolicyMethod;
    if ((getDeleteAuthzPolicyMethod = NetworkSecurityGrpc.getDeleteAuthzPolicyMethod) == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getDeleteAuthzPolicyMethod = NetworkSecurityGrpc.getDeleteAuthzPolicyMethod) == null) {
          NetworkSecurityGrpc.getDeleteAuthzPolicyMethod =
              getDeleteAuthzPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.DeleteAuthzPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAuthzPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.DeleteAuthzPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkSecurityMethodDescriptorSupplier("DeleteAuthzPolicy"))
                      .build();
        }
      }
    }
    return getDeleteAuthzPolicyMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static NetworkSecurityStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NetworkSecurityStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<NetworkSecurityStub>() {
          @java.lang.Override
          public NetworkSecurityStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new NetworkSecurityStub(channel, callOptions);
          }
        };
    return NetworkSecurityStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static NetworkSecurityBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NetworkSecurityBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<NetworkSecurityBlockingV2Stub>() {
          @java.lang.Override
          public NetworkSecurityBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new NetworkSecurityBlockingV2Stub(channel, callOptions);
          }
        };
    return NetworkSecurityBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NetworkSecurityBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NetworkSecurityBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<NetworkSecurityBlockingStub>() {
          @java.lang.Override
          public NetworkSecurityBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new NetworkSecurityBlockingStub(channel, callOptions);
          }
        };
    return NetworkSecurityBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static NetworkSecurityFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NetworkSecurityFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<NetworkSecurityFutureStub>() {
          @java.lang.Override
          public NetworkSecurityFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new NetworkSecurityFutureStub(channel, callOptions);
          }
        };
    return NetworkSecurityFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Network Security API provides resources to configure authentication and
   * authorization policies. Refer to per API resource documentation for more
   * information.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists AuthorizationPolicies in a given project and location.
     * </pre>
     */
    default void listAuthorizationPolicies(
        com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAuthorizationPoliciesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AuthorizationPolicy.
     * </pre>
     */
    default void getAuthorizationPolicy(
        com.google.cloud.networksecurity.v1.GetAuthorizationPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.AuthorizationPolicy>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAuthorizationPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new AuthorizationPolicy in a given project and location.
     * </pre>
     */
    default void createAuthorizationPolicy(
        com.google.cloud.networksecurity.v1.CreateAuthorizationPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAuthorizationPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single AuthorizationPolicy.
     * </pre>
     */
    default void updateAuthorizationPolicy(
        com.google.cloud.networksecurity.v1.UpdateAuthorizationPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAuthorizationPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single AuthorizationPolicy.
     * </pre>
     */
    default void deleteAuthorizationPolicy(
        com.google.cloud.networksecurity.v1.DeleteAuthorizationPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAuthorizationPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists BackendAuthenticationConfigs in a given project and location.
     * </pre>
     */
    default void listBackendAuthenticationConfigs(
        com.google.cloud.networksecurity.v1.ListBackendAuthenticationConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListBackendAuthenticationConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBackendAuthenticationConfigsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single BackendAuthenticationConfig to
     * BackendAuthenticationConfig.
     * </pre>
     */
    default void getBackendAuthenticationConfig(
        com.google.cloud.networksecurity.v1.GetBackendAuthenticationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.BackendAuthenticationConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetBackendAuthenticationConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new BackendAuthenticationConfig in a given project and location.
     * </pre>
     */
    default void createBackendAuthenticationConfig(
        com.google.cloud.networksecurity.v1.CreateBackendAuthenticationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateBackendAuthenticationConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single BackendAuthenticationConfig to
     * BackendAuthenticationConfig.
     * </pre>
     */
    default void updateBackendAuthenticationConfig(
        com.google.cloud.networksecurity.v1.UpdateBackendAuthenticationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateBackendAuthenticationConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single BackendAuthenticationConfig to
     * BackendAuthenticationConfig.
     * </pre>
     */
    default void deleteBackendAuthenticationConfig(
        com.google.cloud.networksecurity.v1.DeleteBackendAuthenticationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteBackendAuthenticationConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ServerTlsPolicies in a given project and location.
     * </pre>
     */
    default void listServerTlsPolicies(
        com.google.cloud.networksecurity.v1.ListServerTlsPoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListServerTlsPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListServerTlsPoliciesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ServerTlsPolicy.
     * </pre>
     */
    default void getServerTlsPolicy(
        com.google.cloud.networksecurity.v1.GetServerTlsPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.ServerTlsPolicy>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetServerTlsPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ServerTlsPolicy in a given project and location.
     * </pre>
     */
    default void createServerTlsPolicy(
        com.google.cloud.networksecurity.v1.CreateServerTlsPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateServerTlsPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ServerTlsPolicy.
     * </pre>
     */
    default void updateServerTlsPolicy(
        com.google.cloud.networksecurity.v1.UpdateServerTlsPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateServerTlsPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ServerTlsPolicy.
     * </pre>
     */
    default void deleteServerTlsPolicy(
        com.google.cloud.networksecurity.v1.DeleteServerTlsPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteServerTlsPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ClientTlsPolicies in a given project and location.
     * </pre>
     */
    default void listClientTlsPolicies(
        com.google.cloud.networksecurity.v1.ListClientTlsPoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListClientTlsPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListClientTlsPoliciesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ClientTlsPolicy.
     * </pre>
     */
    default void getClientTlsPolicy(
        com.google.cloud.networksecurity.v1.GetClientTlsPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.ClientTlsPolicy>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetClientTlsPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ClientTlsPolicy in a given project and location.
     * </pre>
     */
    default void createClientTlsPolicy(
        com.google.cloud.networksecurity.v1.CreateClientTlsPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateClientTlsPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ClientTlsPolicy.
     * </pre>
     */
    default void updateClientTlsPolicy(
        com.google.cloud.networksecurity.v1.UpdateClientTlsPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateClientTlsPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ClientTlsPolicy.
     * </pre>
     */
    default void deleteClientTlsPolicy(
        com.google.cloud.networksecurity.v1.DeleteClientTlsPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteClientTlsPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists GatewaySecurityPolicies in a given project and location.
     * </pre>
     */
    default void listGatewaySecurityPolicies(
        com.google.cloud.networksecurity.v1.ListGatewaySecurityPoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListGatewaySecurityPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListGatewaySecurityPoliciesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single GatewaySecurityPolicy.
     * </pre>
     */
    default void getGatewaySecurityPolicy(
        com.google.cloud.networksecurity.v1.GetGatewaySecurityPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.GatewaySecurityPolicy>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetGatewaySecurityPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new GatewaySecurityPolicy in a given project and location.
     * </pre>
     */
    default void createGatewaySecurityPolicy(
        com.google.cloud.networksecurity.v1.CreateGatewaySecurityPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateGatewaySecurityPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single GatewaySecurityPolicy.
     * </pre>
     */
    default void updateGatewaySecurityPolicy(
        com.google.cloud.networksecurity.v1.UpdateGatewaySecurityPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateGatewaySecurityPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single GatewaySecurityPolicy.
     * </pre>
     */
    default void deleteGatewaySecurityPolicy(
        com.google.cloud.networksecurity.v1.DeleteGatewaySecurityPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteGatewaySecurityPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists GatewaySecurityPolicyRules in a given project and location.
     * </pre>
     */
    default void listGatewaySecurityPolicyRules(
        com.google.cloud.networksecurity.v1.ListGatewaySecurityPolicyRulesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListGatewaySecurityPolicyRulesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListGatewaySecurityPolicyRulesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single GatewaySecurityPolicyRule.
     * </pre>
     */
    default void getGatewaySecurityPolicyRule(
        com.google.cloud.networksecurity.v1.GetGatewaySecurityPolicyRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.GatewaySecurityPolicyRule>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetGatewaySecurityPolicyRuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new GatewaySecurityPolicy in a given project and location.
     * </pre>
     */
    default void createGatewaySecurityPolicyRule(
        com.google.cloud.networksecurity.v1.CreateGatewaySecurityPolicyRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateGatewaySecurityPolicyRuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single GatewaySecurityPolicyRule.
     * </pre>
     */
    default void updateGatewaySecurityPolicyRule(
        com.google.cloud.networksecurity.v1.UpdateGatewaySecurityPolicyRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateGatewaySecurityPolicyRuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single GatewaySecurityPolicyRule.
     * </pre>
     */
    default void deleteGatewaySecurityPolicyRule(
        com.google.cloud.networksecurity.v1.DeleteGatewaySecurityPolicyRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteGatewaySecurityPolicyRuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists UrlLists in a given project and location.
     * </pre>
     */
    default void listUrlLists(
        com.google.cloud.networksecurity.v1.ListUrlListsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.ListUrlListsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListUrlListsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single UrlList.
     * </pre>
     */
    default void getUrlList(
        com.google.cloud.networksecurity.v1.GetUrlListRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.UrlList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUrlListMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new UrlList in a given project and location.
     * </pre>
     */
    default void createUrlList(
        com.google.cloud.networksecurity.v1.CreateUrlListRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateUrlListMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single UrlList.
     * </pre>
     */
    default void updateUrlList(
        com.google.cloud.networksecurity.v1.UpdateUrlListRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateUrlListMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single UrlList.
     * </pre>
     */
    default void deleteUrlList(
        com.google.cloud.networksecurity.v1.DeleteUrlListRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteUrlListMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists TlsInspectionPolicies in a given project and location.
     * </pre>
     */
    default void listTlsInspectionPolicies(
        com.google.cloud.networksecurity.v1.ListTlsInspectionPoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListTlsInspectionPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListTlsInspectionPoliciesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single TlsInspectionPolicy.
     * </pre>
     */
    default void getTlsInspectionPolicy(
        com.google.cloud.networksecurity.v1.GetTlsInspectionPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.TlsInspectionPolicy>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetTlsInspectionPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TlsInspectionPolicy in a given project and location.
     * </pre>
     */
    default void createTlsInspectionPolicy(
        com.google.cloud.networksecurity.v1.CreateTlsInspectionPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateTlsInspectionPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single TlsInspectionPolicy.
     * </pre>
     */
    default void updateTlsInspectionPolicy(
        com.google.cloud.networksecurity.v1.UpdateTlsInspectionPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateTlsInspectionPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single TlsInspectionPolicy.
     * </pre>
     */
    default void deleteTlsInspectionPolicy(
        com.google.cloud.networksecurity.v1.DeleteTlsInspectionPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteTlsInspectionPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists AuthzPolicies in a given project and location.
     * </pre>
     */
    default void listAuthzPolicies(
        com.google.cloud.networksecurity.v1.ListAuthzPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.ListAuthzPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAuthzPoliciesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AuthzPolicy.
     * </pre>
     */
    default void getAuthzPolicy(
        com.google.cloud.networksecurity.v1.GetAuthzPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.AuthzPolicy>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAuthzPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new AuthzPolicy in a given project and location.
     * </pre>
     */
    default void createAuthzPolicy(
        com.google.cloud.networksecurity.v1.CreateAuthzPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAuthzPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single AuthzPolicy.
     * </pre>
     */
    default void updateAuthzPolicy(
        com.google.cloud.networksecurity.v1.UpdateAuthzPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAuthzPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single AuthzPolicy.
     * </pre>
     */
    default void deleteAuthzPolicy(
        com.google.cloud.networksecurity.v1.DeleteAuthzPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAuthzPolicyMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service NetworkSecurity.
   *
   * <pre>
   * Network Security API provides resources to configure authentication and
   * authorization policies. Refer to per API resource documentation for more
   * information.
   * </pre>
   */
  public abstract static class NetworkSecurityImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return NetworkSecurityGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service NetworkSecurity.
   *
   * <pre>
   * Network Security API provides resources to configure authentication and
   * authorization policies. Refer to per API resource documentation for more
   * information.
   * </pre>
   */
  public static final class NetworkSecurityStub
      extends io.grpc.stub.AbstractAsyncStub<NetworkSecurityStub> {
    private NetworkSecurityStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NetworkSecurityStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NetworkSecurityStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists AuthorizationPolicies in a given project and location.
     * </pre>
     */
    public void listAuthorizationPolicies(
        com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAuthorizationPoliciesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AuthorizationPolicy.
     * </pre>
     */
    public void getAuthorizationPolicy(
        com.google.cloud.networksecurity.v1.GetAuthorizationPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.AuthorizationPolicy>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAuthorizationPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new AuthorizationPolicy in a given project and location.
     * </pre>
     */
    public void createAuthorizationPolicy(
        com.google.cloud.networksecurity.v1.CreateAuthorizationPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAuthorizationPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single AuthorizationPolicy.
     * </pre>
     */
    public void updateAuthorizationPolicy(
        com.google.cloud.networksecurity.v1.UpdateAuthorizationPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAuthorizationPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single AuthorizationPolicy.
     * </pre>
     */
    public void deleteAuthorizationPolicy(
        com.google.cloud.networksecurity.v1.DeleteAuthorizationPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAuthorizationPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists BackendAuthenticationConfigs in a given project and location.
     * </pre>
     */
    public void listBackendAuthenticationConfigs(
        com.google.cloud.networksecurity.v1.ListBackendAuthenticationConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListBackendAuthenticationConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBackendAuthenticationConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single BackendAuthenticationConfig to
     * BackendAuthenticationConfig.
     * </pre>
     */
    public void getBackendAuthenticationConfig(
        com.google.cloud.networksecurity.v1.GetBackendAuthenticationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.BackendAuthenticationConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBackendAuthenticationConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new BackendAuthenticationConfig in a given project and location.
     * </pre>
     */
    public void createBackendAuthenticationConfig(
        com.google.cloud.networksecurity.v1.CreateBackendAuthenticationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBackendAuthenticationConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single BackendAuthenticationConfig to
     * BackendAuthenticationConfig.
     * </pre>
     */
    public void updateBackendAuthenticationConfig(
        com.google.cloud.networksecurity.v1.UpdateBackendAuthenticationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateBackendAuthenticationConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single BackendAuthenticationConfig to
     * BackendAuthenticationConfig.
     * </pre>
     */
    public void deleteBackendAuthenticationConfig(
        com.google.cloud.networksecurity.v1.DeleteBackendAuthenticationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteBackendAuthenticationConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ServerTlsPolicies in a given project and location.
     * </pre>
     */
    public void listServerTlsPolicies(
        com.google.cloud.networksecurity.v1.ListServerTlsPoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListServerTlsPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListServerTlsPoliciesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ServerTlsPolicy.
     * </pre>
     */
    public void getServerTlsPolicy(
        com.google.cloud.networksecurity.v1.GetServerTlsPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.ServerTlsPolicy>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetServerTlsPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ServerTlsPolicy in a given project and location.
     * </pre>
     */
    public void createServerTlsPolicy(
        com.google.cloud.networksecurity.v1.CreateServerTlsPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateServerTlsPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ServerTlsPolicy.
     * </pre>
     */
    public void updateServerTlsPolicy(
        com.google.cloud.networksecurity.v1.UpdateServerTlsPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateServerTlsPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ServerTlsPolicy.
     * </pre>
     */
    public void deleteServerTlsPolicy(
        com.google.cloud.networksecurity.v1.DeleteServerTlsPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteServerTlsPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ClientTlsPolicies in a given project and location.
     * </pre>
     */
    public void listClientTlsPolicies(
        com.google.cloud.networksecurity.v1.ListClientTlsPoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListClientTlsPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListClientTlsPoliciesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ClientTlsPolicy.
     * </pre>
     */
    public void getClientTlsPolicy(
        com.google.cloud.networksecurity.v1.GetClientTlsPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.ClientTlsPolicy>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetClientTlsPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ClientTlsPolicy in a given project and location.
     * </pre>
     */
    public void createClientTlsPolicy(
        com.google.cloud.networksecurity.v1.CreateClientTlsPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateClientTlsPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ClientTlsPolicy.
     * </pre>
     */
    public void updateClientTlsPolicy(
        com.google.cloud.networksecurity.v1.UpdateClientTlsPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateClientTlsPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ClientTlsPolicy.
     * </pre>
     */
    public void deleteClientTlsPolicy(
        com.google.cloud.networksecurity.v1.DeleteClientTlsPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteClientTlsPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists GatewaySecurityPolicies in a given project and location.
     * </pre>
     */
    public void listGatewaySecurityPolicies(
        com.google.cloud.networksecurity.v1.ListGatewaySecurityPoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListGatewaySecurityPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListGatewaySecurityPoliciesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single GatewaySecurityPolicy.
     * </pre>
     */
    public void getGatewaySecurityPolicy(
        com.google.cloud.networksecurity.v1.GetGatewaySecurityPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.GatewaySecurityPolicy>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGatewaySecurityPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new GatewaySecurityPolicy in a given project and location.
     * </pre>
     */
    public void createGatewaySecurityPolicy(
        com.google.cloud.networksecurity.v1.CreateGatewaySecurityPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateGatewaySecurityPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single GatewaySecurityPolicy.
     * </pre>
     */
    public void updateGatewaySecurityPolicy(
        com.google.cloud.networksecurity.v1.UpdateGatewaySecurityPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateGatewaySecurityPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single GatewaySecurityPolicy.
     * </pre>
     */
    public void deleteGatewaySecurityPolicy(
        com.google.cloud.networksecurity.v1.DeleteGatewaySecurityPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteGatewaySecurityPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists GatewaySecurityPolicyRules in a given project and location.
     * </pre>
     */
    public void listGatewaySecurityPolicyRules(
        com.google.cloud.networksecurity.v1.ListGatewaySecurityPolicyRulesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListGatewaySecurityPolicyRulesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListGatewaySecurityPolicyRulesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single GatewaySecurityPolicyRule.
     * </pre>
     */
    public void getGatewaySecurityPolicyRule(
        com.google.cloud.networksecurity.v1.GetGatewaySecurityPolicyRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.GatewaySecurityPolicyRule>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGatewaySecurityPolicyRuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new GatewaySecurityPolicy in a given project and location.
     * </pre>
     */
    public void createGatewaySecurityPolicyRule(
        com.google.cloud.networksecurity.v1.CreateGatewaySecurityPolicyRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateGatewaySecurityPolicyRuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single GatewaySecurityPolicyRule.
     * </pre>
     */
    public void updateGatewaySecurityPolicyRule(
        com.google.cloud.networksecurity.v1.UpdateGatewaySecurityPolicyRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateGatewaySecurityPolicyRuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single GatewaySecurityPolicyRule.
     * </pre>
     */
    public void deleteGatewaySecurityPolicyRule(
        com.google.cloud.networksecurity.v1.DeleteGatewaySecurityPolicyRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteGatewaySecurityPolicyRuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists UrlLists in a given project and location.
     * </pre>
     */
    public void listUrlLists(
        com.google.cloud.networksecurity.v1.ListUrlListsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.ListUrlListsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListUrlListsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single UrlList.
     * </pre>
     */
    public void getUrlList(
        com.google.cloud.networksecurity.v1.GetUrlListRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.UrlList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUrlListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new UrlList in a given project and location.
     * </pre>
     */
    public void createUrlList(
        com.google.cloud.networksecurity.v1.CreateUrlListRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateUrlListMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single UrlList.
     * </pre>
     */
    public void updateUrlList(
        com.google.cloud.networksecurity.v1.UpdateUrlListRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateUrlListMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single UrlList.
     * </pre>
     */
    public void deleteUrlList(
        com.google.cloud.networksecurity.v1.DeleteUrlListRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteUrlListMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists TlsInspectionPolicies in a given project and location.
     * </pre>
     */
    public void listTlsInspectionPolicies(
        com.google.cloud.networksecurity.v1.ListTlsInspectionPoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListTlsInspectionPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTlsInspectionPoliciesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single TlsInspectionPolicy.
     * </pre>
     */
    public void getTlsInspectionPolicy(
        com.google.cloud.networksecurity.v1.GetTlsInspectionPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.TlsInspectionPolicy>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTlsInspectionPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TlsInspectionPolicy in a given project and location.
     * </pre>
     */
    public void createTlsInspectionPolicy(
        com.google.cloud.networksecurity.v1.CreateTlsInspectionPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTlsInspectionPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single TlsInspectionPolicy.
     * </pre>
     */
    public void updateTlsInspectionPolicy(
        com.google.cloud.networksecurity.v1.UpdateTlsInspectionPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTlsInspectionPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single TlsInspectionPolicy.
     * </pre>
     */
    public void deleteTlsInspectionPolicy(
        com.google.cloud.networksecurity.v1.DeleteTlsInspectionPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTlsInspectionPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists AuthzPolicies in a given project and location.
     * </pre>
     */
    public void listAuthzPolicies(
        com.google.cloud.networksecurity.v1.ListAuthzPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.ListAuthzPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAuthzPoliciesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AuthzPolicy.
     * </pre>
     */
    public void getAuthzPolicy(
        com.google.cloud.networksecurity.v1.GetAuthzPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.AuthzPolicy>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAuthzPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new AuthzPolicy in a given project and location.
     * </pre>
     */
    public void createAuthzPolicy(
        com.google.cloud.networksecurity.v1.CreateAuthzPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAuthzPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single AuthzPolicy.
     * </pre>
     */
    public void updateAuthzPolicy(
        com.google.cloud.networksecurity.v1.UpdateAuthzPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAuthzPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single AuthzPolicy.
     * </pre>
     */
    public void deleteAuthzPolicy(
        com.google.cloud.networksecurity.v1.DeleteAuthzPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAuthzPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service NetworkSecurity.
   *
   * <pre>
   * Network Security API provides resources to configure authentication and
   * authorization policies. Refer to per API resource documentation for more
   * information.
   * </pre>
   */
  public static final class NetworkSecurityBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<NetworkSecurityBlockingV2Stub> {
    private NetworkSecurityBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NetworkSecurityBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NetworkSecurityBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists AuthorizationPolicies in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesResponse
        listAuthorizationPolicies(
            com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListAuthorizationPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AuthorizationPolicy.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.AuthorizationPolicy getAuthorizationPolicy(
        com.google.cloud.networksecurity.v1.GetAuthorizationPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetAuthorizationPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new AuthorizationPolicy in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createAuthorizationPolicy(
        com.google.cloud.networksecurity.v1.CreateAuthorizationPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateAuthorizationPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single AuthorizationPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation updateAuthorizationPolicy(
        com.google.cloud.networksecurity.v1.UpdateAuthorizationPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateAuthorizationPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single AuthorizationPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAuthorizationPolicy(
        com.google.cloud.networksecurity.v1.DeleteAuthorizationPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteAuthorizationPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists BackendAuthenticationConfigs in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListBackendAuthenticationConfigsResponse
        listBackendAuthenticationConfigs(
            com.google.cloud.networksecurity.v1.ListBackendAuthenticationConfigsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListBackendAuthenticationConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single BackendAuthenticationConfig to
     * BackendAuthenticationConfig.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.BackendAuthenticationConfig
        getBackendAuthenticationConfig(
            com.google.cloud.networksecurity.v1.GetBackendAuthenticationConfigRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetBackendAuthenticationConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new BackendAuthenticationConfig in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createBackendAuthenticationConfig(
        com.google.cloud.networksecurity.v1.CreateBackendAuthenticationConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateBackendAuthenticationConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single BackendAuthenticationConfig to
     * BackendAuthenticationConfig.
     * </pre>
     */
    public com.google.longrunning.Operation updateBackendAuthenticationConfig(
        com.google.cloud.networksecurity.v1.UpdateBackendAuthenticationConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateBackendAuthenticationConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single BackendAuthenticationConfig to
     * BackendAuthenticationConfig.
     * </pre>
     */
    public com.google.longrunning.Operation deleteBackendAuthenticationConfig(
        com.google.cloud.networksecurity.v1.DeleteBackendAuthenticationConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteBackendAuthenticationConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ServerTlsPolicies in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListServerTlsPoliciesResponse listServerTlsPolicies(
        com.google.cloud.networksecurity.v1.ListServerTlsPoliciesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListServerTlsPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ServerTlsPolicy.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ServerTlsPolicy getServerTlsPolicy(
        com.google.cloud.networksecurity.v1.GetServerTlsPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetServerTlsPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ServerTlsPolicy in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createServerTlsPolicy(
        com.google.cloud.networksecurity.v1.CreateServerTlsPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateServerTlsPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ServerTlsPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation updateServerTlsPolicy(
        com.google.cloud.networksecurity.v1.UpdateServerTlsPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateServerTlsPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ServerTlsPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation deleteServerTlsPolicy(
        com.google.cloud.networksecurity.v1.DeleteServerTlsPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteServerTlsPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ClientTlsPolicies in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListClientTlsPoliciesResponse listClientTlsPolicies(
        com.google.cloud.networksecurity.v1.ListClientTlsPoliciesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListClientTlsPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ClientTlsPolicy.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ClientTlsPolicy getClientTlsPolicy(
        com.google.cloud.networksecurity.v1.GetClientTlsPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetClientTlsPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ClientTlsPolicy in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createClientTlsPolicy(
        com.google.cloud.networksecurity.v1.CreateClientTlsPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateClientTlsPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ClientTlsPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation updateClientTlsPolicy(
        com.google.cloud.networksecurity.v1.UpdateClientTlsPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateClientTlsPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ClientTlsPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation deleteClientTlsPolicy(
        com.google.cloud.networksecurity.v1.DeleteClientTlsPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteClientTlsPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists GatewaySecurityPolicies in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListGatewaySecurityPoliciesResponse
        listGatewaySecurityPolicies(
            com.google.cloud.networksecurity.v1.ListGatewaySecurityPoliciesRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListGatewaySecurityPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single GatewaySecurityPolicy.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.GatewaySecurityPolicy getGatewaySecurityPolicy(
        com.google.cloud.networksecurity.v1.GetGatewaySecurityPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetGatewaySecurityPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new GatewaySecurityPolicy in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createGatewaySecurityPolicy(
        com.google.cloud.networksecurity.v1.CreateGatewaySecurityPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateGatewaySecurityPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single GatewaySecurityPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation updateGatewaySecurityPolicy(
        com.google.cloud.networksecurity.v1.UpdateGatewaySecurityPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateGatewaySecurityPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single GatewaySecurityPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation deleteGatewaySecurityPolicy(
        com.google.cloud.networksecurity.v1.DeleteGatewaySecurityPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteGatewaySecurityPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists GatewaySecurityPolicyRules in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListGatewaySecurityPolicyRulesResponse
        listGatewaySecurityPolicyRules(
            com.google.cloud.networksecurity.v1.ListGatewaySecurityPolicyRulesRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListGatewaySecurityPolicyRulesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single GatewaySecurityPolicyRule.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.GatewaySecurityPolicyRule
        getGatewaySecurityPolicyRule(
            com.google.cloud.networksecurity.v1.GetGatewaySecurityPolicyRuleRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetGatewaySecurityPolicyRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new GatewaySecurityPolicy in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createGatewaySecurityPolicyRule(
        com.google.cloud.networksecurity.v1.CreateGatewaySecurityPolicyRuleRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateGatewaySecurityPolicyRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single GatewaySecurityPolicyRule.
     * </pre>
     */
    public com.google.longrunning.Operation updateGatewaySecurityPolicyRule(
        com.google.cloud.networksecurity.v1.UpdateGatewaySecurityPolicyRuleRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateGatewaySecurityPolicyRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single GatewaySecurityPolicyRule.
     * </pre>
     */
    public com.google.longrunning.Operation deleteGatewaySecurityPolicyRule(
        com.google.cloud.networksecurity.v1.DeleteGatewaySecurityPolicyRuleRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteGatewaySecurityPolicyRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists UrlLists in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListUrlListsResponse listUrlLists(
        com.google.cloud.networksecurity.v1.ListUrlListsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListUrlListsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single UrlList.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.UrlList getUrlList(
        com.google.cloud.networksecurity.v1.GetUrlListRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetUrlListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new UrlList in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createUrlList(
        com.google.cloud.networksecurity.v1.CreateUrlListRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateUrlListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single UrlList.
     * </pre>
     */
    public com.google.longrunning.Operation updateUrlList(
        com.google.cloud.networksecurity.v1.UpdateUrlListRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateUrlListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single UrlList.
     * </pre>
     */
    public com.google.longrunning.Operation deleteUrlList(
        com.google.cloud.networksecurity.v1.DeleteUrlListRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteUrlListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists TlsInspectionPolicies in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListTlsInspectionPoliciesResponse
        listTlsInspectionPolicies(
            com.google.cloud.networksecurity.v1.ListTlsInspectionPoliciesRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListTlsInspectionPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single TlsInspectionPolicy.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.TlsInspectionPolicy getTlsInspectionPolicy(
        com.google.cloud.networksecurity.v1.GetTlsInspectionPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetTlsInspectionPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TlsInspectionPolicy in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createTlsInspectionPolicy(
        com.google.cloud.networksecurity.v1.CreateTlsInspectionPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateTlsInspectionPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single TlsInspectionPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation updateTlsInspectionPolicy(
        com.google.cloud.networksecurity.v1.UpdateTlsInspectionPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateTlsInspectionPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single TlsInspectionPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation deleteTlsInspectionPolicy(
        com.google.cloud.networksecurity.v1.DeleteTlsInspectionPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteTlsInspectionPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists AuthzPolicies in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListAuthzPoliciesResponse listAuthzPolicies(
        com.google.cloud.networksecurity.v1.ListAuthzPoliciesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListAuthzPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AuthzPolicy.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.AuthzPolicy getAuthzPolicy(
        com.google.cloud.networksecurity.v1.GetAuthzPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetAuthzPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new AuthzPolicy in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createAuthzPolicy(
        com.google.cloud.networksecurity.v1.CreateAuthzPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateAuthzPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single AuthzPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation updateAuthzPolicy(
        com.google.cloud.networksecurity.v1.UpdateAuthzPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateAuthzPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single AuthzPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAuthzPolicy(
        com.google.cloud.networksecurity.v1.DeleteAuthzPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteAuthzPolicyMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service NetworkSecurity.
   *
   * <pre>
   * Network Security API provides resources to configure authentication and
   * authorization policies. Refer to per API resource documentation for more
   * information.
   * </pre>
   */
  public static final class NetworkSecurityBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<NetworkSecurityBlockingStub> {
    private NetworkSecurityBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NetworkSecurityBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NetworkSecurityBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists AuthorizationPolicies in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesResponse
        listAuthorizationPolicies(
            com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAuthorizationPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AuthorizationPolicy.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.AuthorizationPolicy getAuthorizationPolicy(
        com.google.cloud.networksecurity.v1.GetAuthorizationPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAuthorizationPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new AuthorizationPolicy in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createAuthorizationPolicy(
        com.google.cloud.networksecurity.v1.CreateAuthorizationPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAuthorizationPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single AuthorizationPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation updateAuthorizationPolicy(
        com.google.cloud.networksecurity.v1.UpdateAuthorizationPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAuthorizationPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single AuthorizationPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAuthorizationPolicy(
        com.google.cloud.networksecurity.v1.DeleteAuthorizationPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAuthorizationPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists BackendAuthenticationConfigs in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListBackendAuthenticationConfigsResponse
        listBackendAuthenticationConfigs(
            com.google.cloud.networksecurity.v1.ListBackendAuthenticationConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBackendAuthenticationConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single BackendAuthenticationConfig to
     * BackendAuthenticationConfig.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.BackendAuthenticationConfig
        getBackendAuthenticationConfig(
            com.google.cloud.networksecurity.v1.GetBackendAuthenticationConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBackendAuthenticationConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new BackendAuthenticationConfig in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createBackendAuthenticationConfig(
        com.google.cloud.networksecurity.v1.CreateBackendAuthenticationConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBackendAuthenticationConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single BackendAuthenticationConfig to
     * BackendAuthenticationConfig.
     * </pre>
     */
    public com.google.longrunning.Operation updateBackendAuthenticationConfig(
        com.google.cloud.networksecurity.v1.UpdateBackendAuthenticationConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBackendAuthenticationConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single BackendAuthenticationConfig to
     * BackendAuthenticationConfig.
     * </pre>
     */
    public com.google.longrunning.Operation deleteBackendAuthenticationConfig(
        com.google.cloud.networksecurity.v1.DeleteBackendAuthenticationConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBackendAuthenticationConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ServerTlsPolicies in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListServerTlsPoliciesResponse listServerTlsPolicies(
        com.google.cloud.networksecurity.v1.ListServerTlsPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServerTlsPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ServerTlsPolicy.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ServerTlsPolicy getServerTlsPolicy(
        com.google.cloud.networksecurity.v1.GetServerTlsPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServerTlsPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ServerTlsPolicy in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createServerTlsPolicy(
        com.google.cloud.networksecurity.v1.CreateServerTlsPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateServerTlsPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ServerTlsPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation updateServerTlsPolicy(
        com.google.cloud.networksecurity.v1.UpdateServerTlsPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateServerTlsPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ServerTlsPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation deleteServerTlsPolicy(
        com.google.cloud.networksecurity.v1.DeleteServerTlsPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteServerTlsPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ClientTlsPolicies in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListClientTlsPoliciesResponse listClientTlsPolicies(
        com.google.cloud.networksecurity.v1.ListClientTlsPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListClientTlsPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ClientTlsPolicy.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ClientTlsPolicy getClientTlsPolicy(
        com.google.cloud.networksecurity.v1.GetClientTlsPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetClientTlsPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ClientTlsPolicy in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createClientTlsPolicy(
        com.google.cloud.networksecurity.v1.CreateClientTlsPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateClientTlsPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ClientTlsPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation updateClientTlsPolicy(
        com.google.cloud.networksecurity.v1.UpdateClientTlsPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateClientTlsPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ClientTlsPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation deleteClientTlsPolicy(
        com.google.cloud.networksecurity.v1.DeleteClientTlsPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteClientTlsPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists GatewaySecurityPolicies in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListGatewaySecurityPoliciesResponse
        listGatewaySecurityPolicies(
            com.google.cloud.networksecurity.v1.ListGatewaySecurityPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGatewaySecurityPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single GatewaySecurityPolicy.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.GatewaySecurityPolicy getGatewaySecurityPolicy(
        com.google.cloud.networksecurity.v1.GetGatewaySecurityPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGatewaySecurityPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new GatewaySecurityPolicy in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createGatewaySecurityPolicy(
        com.google.cloud.networksecurity.v1.CreateGatewaySecurityPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateGatewaySecurityPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single GatewaySecurityPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation updateGatewaySecurityPolicy(
        com.google.cloud.networksecurity.v1.UpdateGatewaySecurityPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateGatewaySecurityPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single GatewaySecurityPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation deleteGatewaySecurityPolicy(
        com.google.cloud.networksecurity.v1.DeleteGatewaySecurityPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteGatewaySecurityPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists GatewaySecurityPolicyRules in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListGatewaySecurityPolicyRulesResponse
        listGatewaySecurityPolicyRules(
            com.google.cloud.networksecurity.v1.ListGatewaySecurityPolicyRulesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGatewaySecurityPolicyRulesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single GatewaySecurityPolicyRule.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.GatewaySecurityPolicyRule
        getGatewaySecurityPolicyRule(
            com.google.cloud.networksecurity.v1.GetGatewaySecurityPolicyRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGatewaySecurityPolicyRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new GatewaySecurityPolicy in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createGatewaySecurityPolicyRule(
        com.google.cloud.networksecurity.v1.CreateGatewaySecurityPolicyRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateGatewaySecurityPolicyRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single GatewaySecurityPolicyRule.
     * </pre>
     */
    public com.google.longrunning.Operation updateGatewaySecurityPolicyRule(
        com.google.cloud.networksecurity.v1.UpdateGatewaySecurityPolicyRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateGatewaySecurityPolicyRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single GatewaySecurityPolicyRule.
     * </pre>
     */
    public com.google.longrunning.Operation deleteGatewaySecurityPolicyRule(
        com.google.cloud.networksecurity.v1.DeleteGatewaySecurityPolicyRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteGatewaySecurityPolicyRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists UrlLists in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListUrlListsResponse listUrlLists(
        com.google.cloud.networksecurity.v1.ListUrlListsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUrlListsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single UrlList.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.UrlList getUrlList(
        com.google.cloud.networksecurity.v1.GetUrlListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUrlListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new UrlList in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createUrlList(
        com.google.cloud.networksecurity.v1.CreateUrlListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUrlListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single UrlList.
     * </pre>
     */
    public com.google.longrunning.Operation updateUrlList(
        com.google.cloud.networksecurity.v1.UpdateUrlListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUrlListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single UrlList.
     * </pre>
     */
    public com.google.longrunning.Operation deleteUrlList(
        com.google.cloud.networksecurity.v1.DeleteUrlListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteUrlListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists TlsInspectionPolicies in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListTlsInspectionPoliciesResponse
        listTlsInspectionPolicies(
            com.google.cloud.networksecurity.v1.ListTlsInspectionPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTlsInspectionPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single TlsInspectionPolicy.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.TlsInspectionPolicy getTlsInspectionPolicy(
        com.google.cloud.networksecurity.v1.GetTlsInspectionPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTlsInspectionPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TlsInspectionPolicy in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createTlsInspectionPolicy(
        com.google.cloud.networksecurity.v1.CreateTlsInspectionPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTlsInspectionPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single TlsInspectionPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation updateTlsInspectionPolicy(
        com.google.cloud.networksecurity.v1.UpdateTlsInspectionPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTlsInspectionPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single TlsInspectionPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation deleteTlsInspectionPolicy(
        com.google.cloud.networksecurity.v1.DeleteTlsInspectionPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTlsInspectionPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists AuthzPolicies in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListAuthzPoliciesResponse listAuthzPolicies(
        com.google.cloud.networksecurity.v1.ListAuthzPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAuthzPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AuthzPolicy.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.AuthzPolicy getAuthzPolicy(
        com.google.cloud.networksecurity.v1.GetAuthzPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAuthzPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new AuthzPolicy in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createAuthzPolicy(
        com.google.cloud.networksecurity.v1.CreateAuthzPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAuthzPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single AuthzPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation updateAuthzPolicy(
        com.google.cloud.networksecurity.v1.UpdateAuthzPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAuthzPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single AuthzPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAuthzPolicy(
        com.google.cloud.networksecurity.v1.DeleteAuthzPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAuthzPolicyMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service NetworkSecurity.
   *
   * <pre>
   * Network Security API provides resources to configure authentication and
   * authorization policies. Refer to per API resource documentation for more
   * information.
   * </pre>
   */
  public static final class NetworkSecurityFutureStub
      extends io.grpc.stub.AbstractFutureStub<NetworkSecurityFutureStub> {
    private NetworkSecurityFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NetworkSecurityFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NetworkSecurityFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists AuthorizationPolicies in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesResponse>
        listAuthorizationPolicies(
            com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAuthorizationPoliciesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AuthorizationPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.AuthorizationPolicy>
        getAuthorizationPolicy(
            com.google.cloud.networksecurity.v1.GetAuthorizationPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAuthorizationPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new AuthorizationPolicy in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createAuthorizationPolicy(
            com.google.cloud.networksecurity.v1.CreateAuthorizationPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAuthorizationPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single AuthorizationPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateAuthorizationPolicy(
            com.google.cloud.networksecurity.v1.UpdateAuthorizationPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAuthorizationPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single AuthorizationPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteAuthorizationPolicy(
            com.google.cloud.networksecurity.v1.DeleteAuthorizationPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAuthorizationPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists BackendAuthenticationConfigs in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.ListBackendAuthenticationConfigsResponse>
        listBackendAuthenticationConfigs(
            com.google.cloud.networksecurity.v1.ListBackendAuthenticationConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBackendAuthenticationConfigsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single BackendAuthenticationConfig to
     * BackendAuthenticationConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.BackendAuthenticationConfig>
        getBackendAuthenticationConfig(
            com.google.cloud.networksecurity.v1.GetBackendAuthenticationConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBackendAuthenticationConfigMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new BackendAuthenticationConfig in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createBackendAuthenticationConfig(
            com.google.cloud.networksecurity.v1.CreateBackendAuthenticationConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBackendAuthenticationConfigMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single BackendAuthenticationConfig to
     * BackendAuthenticationConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateBackendAuthenticationConfig(
            com.google.cloud.networksecurity.v1.UpdateBackendAuthenticationConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBackendAuthenticationConfigMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single BackendAuthenticationConfig to
     * BackendAuthenticationConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteBackendAuthenticationConfig(
            com.google.cloud.networksecurity.v1.DeleteBackendAuthenticationConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBackendAuthenticationConfigMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists ServerTlsPolicies in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.ListServerTlsPoliciesResponse>
        listServerTlsPolicies(
            com.google.cloud.networksecurity.v1.ListServerTlsPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListServerTlsPoliciesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ServerTlsPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.ServerTlsPolicy>
        getServerTlsPolicy(com.google.cloud.networksecurity.v1.GetServerTlsPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetServerTlsPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ServerTlsPolicy in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createServerTlsPolicy(
            com.google.cloud.networksecurity.v1.CreateServerTlsPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateServerTlsPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ServerTlsPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateServerTlsPolicy(
            com.google.cloud.networksecurity.v1.UpdateServerTlsPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateServerTlsPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ServerTlsPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteServerTlsPolicy(
            com.google.cloud.networksecurity.v1.DeleteServerTlsPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteServerTlsPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ClientTlsPolicies in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.ListClientTlsPoliciesResponse>
        listClientTlsPolicies(
            com.google.cloud.networksecurity.v1.ListClientTlsPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListClientTlsPoliciesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ClientTlsPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.ClientTlsPolicy>
        getClientTlsPolicy(com.google.cloud.networksecurity.v1.GetClientTlsPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetClientTlsPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ClientTlsPolicy in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createClientTlsPolicy(
            com.google.cloud.networksecurity.v1.CreateClientTlsPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateClientTlsPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ClientTlsPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateClientTlsPolicy(
            com.google.cloud.networksecurity.v1.UpdateClientTlsPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateClientTlsPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ClientTlsPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteClientTlsPolicy(
            com.google.cloud.networksecurity.v1.DeleteClientTlsPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteClientTlsPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists GatewaySecurityPolicies in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.ListGatewaySecurityPoliciesResponse>
        listGatewaySecurityPolicies(
            com.google.cloud.networksecurity.v1.ListGatewaySecurityPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListGatewaySecurityPoliciesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single GatewaySecurityPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.GatewaySecurityPolicy>
        getGatewaySecurityPolicy(
            com.google.cloud.networksecurity.v1.GetGatewaySecurityPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGatewaySecurityPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new GatewaySecurityPolicy in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createGatewaySecurityPolicy(
            com.google.cloud.networksecurity.v1.CreateGatewaySecurityPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateGatewaySecurityPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single GatewaySecurityPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateGatewaySecurityPolicy(
            com.google.cloud.networksecurity.v1.UpdateGatewaySecurityPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateGatewaySecurityPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single GatewaySecurityPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteGatewaySecurityPolicy(
            com.google.cloud.networksecurity.v1.DeleteGatewaySecurityPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteGatewaySecurityPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists GatewaySecurityPolicyRules in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.ListGatewaySecurityPolicyRulesResponse>
        listGatewaySecurityPolicyRules(
            com.google.cloud.networksecurity.v1.ListGatewaySecurityPolicyRulesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListGatewaySecurityPolicyRulesMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single GatewaySecurityPolicyRule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.GatewaySecurityPolicyRule>
        getGatewaySecurityPolicyRule(
            com.google.cloud.networksecurity.v1.GetGatewaySecurityPolicyRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGatewaySecurityPolicyRuleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new GatewaySecurityPolicy in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createGatewaySecurityPolicyRule(
            com.google.cloud.networksecurity.v1.CreateGatewaySecurityPolicyRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateGatewaySecurityPolicyRuleMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single GatewaySecurityPolicyRule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateGatewaySecurityPolicyRule(
            com.google.cloud.networksecurity.v1.UpdateGatewaySecurityPolicyRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateGatewaySecurityPolicyRuleMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single GatewaySecurityPolicyRule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteGatewaySecurityPolicyRule(
            com.google.cloud.networksecurity.v1.DeleteGatewaySecurityPolicyRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteGatewaySecurityPolicyRuleMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists UrlLists in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.ListUrlListsResponse>
        listUrlLists(com.google.cloud.networksecurity.v1.ListUrlListsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListUrlListsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single UrlList.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.UrlList>
        getUrlList(com.google.cloud.networksecurity.v1.GetUrlListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUrlListMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new UrlList in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createUrlList(com.google.cloud.networksecurity.v1.CreateUrlListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateUrlListMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single UrlList.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateUrlList(com.google.cloud.networksecurity.v1.UpdateUrlListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateUrlListMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single UrlList.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteUrlList(com.google.cloud.networksecurity.v1.DeleteUrlListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteUrlListMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists TlsInspectionPolicies in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.ListTlsInspectionPoliciesResponse>
        listTlsInspectionPolicies(
            com.google.cloud.networksecurity.v1.ListTlsInspectionPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTlsInspectionPoliciesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single TlsInspectionPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.TlsInspectionPolicy>
        getTlsInspectionPolicy(
            com.google.cloud.networksecurity.v1.GetTlsInspectionPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTlsInspectionPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TlsInspectionPolicy in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createTlsInspectionPolicy(
            com.google.cloud.networksecurity.v1.CreateTlsInspectionPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTlsInspectionPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single TlsInspectionPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateTlsInspectionPolicy(
            com.google.cloud.networksecurity.v1.UpdateTlsInspectionPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTlsInspectionPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single TlsInspectionPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteTlsInspectionPolicy(
            com.google.cloud.networksecurity.v1.DeleteTlsInspectionPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTlsInspectionPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists AuthzPolicies in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.ListAuthzPoliciesResponse>
        listAuthzPolicies(com.google.cloud.networksecurity.v1.ListAuthzPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAuthzPoliciesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AuthzPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.AuthzPolicy>
        getAuthzPolicy(com.google.cloud.networksecurity.v1.GetAuthzPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAuthzPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new AuthzPolicy in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createAuthzPolicy(com.google.cloud.networksecurity.v1.CreateAuthzPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAuthzPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single AuthzPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateAuthzPolicy(com.google.cloud.networksecurity.v1.UpdateAuthzPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAuthzPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single AuthzPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteAuthzPolicy(com.google.cloud.networksecurity.v1.DeleteAuthzPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAuthzPolicyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_AUTHORIZATION_POLICIES = 0;
  private static final int METHODID_GET_AUTHORIZATION_POLICY = 1;
  private static final int METHODID_CREATE_AUTHORIZATION_POLICY = 2;
  private static final int METHODID_UPDATE_AUTHORIZATION_POLICY = 3;
  private static final int METHODID_DELETE_AUTHORIZATION_POLICY = 4;
  private static final int METHODID_LIST_BACKEND_AUTHENTICATION_CONFIGS = 5;
  private static final int METHODID_GET_BACKEND_AUTHENTICATION_CONFIG = 6;
  private static final int METHODID_CREATE_BACKEND_AUTHENTICATION_CONFIG = 7;
  private static final int METHODID_UPDATE_BACKEND_AUTHENTICATION_CONFIG = 8;
  private static final int METHODID_DELETE_BACKEND_AUTHENTICATION_CONFIG = 9;
  private static final int METHODID_LIST_SERVER_TLS_POLICIES = 10;
  private static final int METHODID_GET_SERVER_TLS_POLICY = 11;
  private static final int METHODID_CREATE_SERVER_TLS_POLICY = 12;
  private static final int METHODID_UPDATE_SERVER_TLS_POLICY = 13;
  private static final int METHODID_DELETE_SERVER_TLS_POLICY = 14;
  private static final int METHODID_LIST_CLIENT_TLS_POLICIES = 15;
  private static final int METHODID_GET_CLIENT_TLS_POLICY = 16;
  private static final int METHODID_CREATE_CLIENT_TLS_POLICY = 17;
  private static final int METHODID_UPDATE_CLIENT_TLS_POLICY = 18;
  private static final int METHODID_DELETE_CLIENT_TLS_POLICY = 19;
  private static final int METHODID_LIST_GATEWAY_SECURITY_POLICIES = 20;
  private static final int METHODID_GET_GATEWAY_SECURITY_POLICY = 21;
  private static final int METHODID_CREATE_GATEWAY_SECURITY_POLICY = 22;
  private static final int METHODID_UPDATE_GATEWAY_SECURITY_POLICY = 23;
  private static final int METHODID_DELETE_GATEWAY_SECURITY_POLICY = 24;
  private static final int METHODID_LIST_GATEWAY_SECURITY_POLICY_RULES = 25;
  private static final int METHODID_GET_GATEWAY_SECURITY_POLICY_RULE = 26;
  private static final int METHODID_CREATE_GATEWAY_SECURITY_POLICY_RULE = 27;
  private static final int METHODID_UPDATE_GATEWAY_SECURITY_POLICY_RULE = 28;
  private static final int METHODID_DELETE_GATEWAY_SECURITY_POLICY_RULE = 29;
  private static final int METHODID_LIST_URL_LISTS = 30;
  private static final int METHODID_GET_URL_LIST = 31;
  private static final int METHODID_CREATE_URL_LIST = 32;
  private static final int METHODID_UPDATE_URL_LIST = 33;
  private static final int METHODID_DELETE_URL_LIST = 34;
  private static final int METHODID_LIST_TLS_INSPECTION_POLICIES = 35;
  private static final int METHODID_GET_TLS_INSPECTION_POLICY = 36;
  private static final int METHODID_CREATE_TLS_INSPECTION_POLICY = 37;
  private static final int METHODID_UPDATE_TLS_INSPECTION_POLICY = 38;
  private static final int METHODID_DELETE_TLS_INSPECTION_POLICY = 39;
  private static final int METHODID_LIST_AUTHZ_POLICIES = 40;
  private static final int METHODID_GET_AUTHZ_POLICY = 41;
  private static final int METHODID_CREATE_AUTHZ_POLICY = 42;
  private static final int METHODID_UPDATE_AUTHZ_POLICY = 43;
  private static final int METHODID_DELETE_AUTHZ_POLICY = 44;

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
        case METHODID_LIST_AUTHORIZATION_POLICIES:
          serviceImpl.listAuthorizationPolicies(
              (com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_AUTHORIZATION_POLICY:
          serviceImpl.getAuthorizationPolicy(
              (com.google.cloud.networksecurity.v1.GetAuthorizationPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.AuthorizationPolicy>)
                  responseObserver);
          break;
        case METHODID_CREATE_AUTHORIZATION_POLICY:
          serviceImpl.createAuthorizationPolicy(
              (com.google.cloud.networksecurity.v1.CreateAuthorizationPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_AUTHORIZATION_POLICY:
          serviceImpl.updateAuthorizationPolicy(
              (com.google.cloud.networksecurity.v1.UpdateAuthorizationPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_AUTHORIZATION_POLICY:
          serviceImpl.deleteAuthorizationPolicy(
              (com.google.cloud.networksecurity.v1.DeleteAuthorizationPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_BACKEND_AUTHENTICATION_CONFIGS:
          serviceImpl.listBackendAuthenticationConfigs(
              (com.google.cloud.networksecurity.v1.ListBackendAuthenticationConfigsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.ListBackendAuthenticationConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_BACKEND_AUTHENTICATION_CONFIG:
          serviceImpl.getBackendAuthenticationConfig(
              (com.google.cloud.networksecurity.v1.GetBackendAuthenticationConfigRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.BackendAuthenticationConfig>)
                  responseObserver);
          break;
        case METHODID_CREATE_BACKEND_AUTHENTICATION_CONFIG:
          serviceImpl.createBackendAuthenticationConfig(
              (com.google.cloud.networksecurity.v1.CreateBackendAuthenticationConfigRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_BACKEND_AUTHENTICATION_CONFIG:
          serviceImpl.updateBackendAuthenticationConfig(
              (com.google.cloud.networksecurity.v1.UpdateBackendAuthenticationConfigRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_BACKEND_AUTHENTICATION_CONFIG:
          serviceImpl.deleteBackendAuthenticationConfig(
              (com.google.cloud.networksecurity.v1.DeleteBackendAuthenticationConfigRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_SERVER_TLS_POLICIES:
          serviceImpl.listServerTlsPolicies(
              (com.google.cloud.networksecurity.v1.ListServerTlsPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.ListServerTlsPoliciesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SERVER_TLS_POLICY:
          serviceImpl.getServerTlsPolicy(
              (com.google.cloud.networksecurity.v1.GetServerTlsPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.ServerTlsPolicy>)
                  responseObserver);
          break;
        case METHODID_CREATE_SERVER_TLS_POLICY:
          serviceImpl.createServerTlsPolicy(
              (com.google.cloud.networksecurity.v1.CreateServerTlsPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_SERVER_TLS_POLICY:
          serviceImpl.updateServerTlsPolicy(
              (com.google.cloud.networksecurity.v1.UpdateServerTlsPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SERVER_TLS_POLICY:
          serviceImpl.deleteServerTlsPolicy(
              (com.google.cloud.networksecurity.v1.DeleteServerTlsPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_CLIENT_TLS_POLICIES:
          serviceImpl.listClientTlsPolicies(
              (com.google.cloud.networksecurity.v1.ListClientTlsPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.ListClientTlsPoliciesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CLIENT_TLS_POLICY:
          serviceImpl.getClientTlsPolicy(
              (com.google.cloud.networksecurity.v1.GetClientTlsPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.ClientTlsPolicy>)
                  responseObserver);
          break;
        case METHODID_CREATE_CLIENT_TLS_POLICY:
          serviceImpl.createClientTlsPolicy(
              (com.google.cloud.networksecurity.v1.CreateClientTlsPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_CLIENT_TLS_POLICY:
          serviceImpl.updateClientTlsPolicy(
              (com.google.cloud.networksecurity.v1.UpdateClientTlsPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CLIENT_TLS_POLICY:
          serviceImpl.deleteClientTlsPolicy(
              (com.google.cloud.networksecurity.v1.DeleteClientTlsPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_GATEWAY_SECURITY_POLICIES:
          serviceImpl.listGatewaySecurityPolicies(
              (com.google.cloud.networksecurity.v1.ListGatewaySecurityPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.ListGatewaySecurityPoliciesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_GATEWAY_SECURITY_POLICY:
          serviceImpl.getGatewaySecurityPolicy(
              (com.google.cloud.networksecurity.v1.GetGatewaySecurityPolicyRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.GatewaySecurityPolicy>)
                  responseObserver);
          break;
        case METHODID_CREATE_GATEWAY_SECURITY_POLICY:
          serviceImpl.createGatewaySecurityPolicy(
              (com.google.cloud.networksecurity.v1.CreateGatewaySecurityPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_GATEWAY_SECURITY_POLICY:
          serviceImpl.updateGatewaySecurityPolicy(
              (com.google.cloud.networksecurity.v1.UpdateGatewaySecurityPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_GATEWAY_SECURITY_POLICY:
          serviceImpl.deleteGatewaySecurityPolicy(
              (com.google.cloud.networksecurity.v1.DeleteGatewaySecurityPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_GATEWAY_SECURITY_POLICY_RULES:
          serviceImpl.listGatewaySecurityPolicyRules(
              (com.google.cloud.networksecurity.v1.ListGatewaySecurityPolicyRulesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.ListGatewaySecurityPolicyRulesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_GATEWAY_SECURITY_POLICY_RULE:
          serviceImpl.getGatewaySecurityPolicyRule(
              (com.google.cloud.networksecurity.v1.GetGatewaySecurityPolicyRuleRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.GatewaySecurityPolicyRule>)
                  responseObserver);
          break;
        case METHODID_CREATE_GATEWAY_SECURITY_POLICY_RULE:
          serviceImpl.createGatewaySecurityPolicyRule(
              (com.google.cloud.networksecurity.v1.CreateGatewaySecurityPolicyRuleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_GATEWAY_SECURITY_POLICY_RULE:
          serviceImpl.updateGatewaySecurityPolicyRule(
              (com.google.cloud.networksecurity.v1.UpdateGatewaySecurityPolicyRuleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_GATEWAY_SECURITY_POLICY_RULE:
          serviceImpl.deleteGatewaySecurityPolicyRule(
              (com.google.cloud.networksecurity.v1.DeleteGatewaySecurityPolicyRuleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_URL_LISTS:
          serviceImpl.listUrlLists(
              (com.google.cloud.networksecurity.v1.ListUrlListsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.ListUrlListsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_URL_LIST:
          serviceImpl.getUrlList(
              (com.google.cloud.networksecurity.v1.GetUrlListRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.UrlList>)
                  responseObserver);
          break;
        case METHODID_CREATE_URL_LIST:
          serviceImpl.createUrlList(
              (com.google.cloud.networksecurity.v1.CreateUrlListRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_URL_LIST:
          serviceImpl.updateUrlList(
              (com.google.cloud.networksecurity.v1.UpdateUrlListRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_URL_LIST:
          serviceImpl.deleteUrlList(
              (com.google.cloud.networksecurity.v1.DeleteUrlListRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_TLS_INSPECTION_POLICIES:
          serviceImpl.listTlsInspectionPolicies(
              (com.google.cloud.networksecurity.v1.ListTlsInspectionPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.ListTlsInspectionPoliciesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_TLS_INSPECTION_POLICY:
          serviceImpl.getTlsInspectionPolicy(
              (com.google.cloud.networksecurity.v1.GetTlsInspectionPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.TlsInspectionPolicy>)
                  responseObserver);
          break;
        case METHODID_CREATE_TLS_INSPECTION_POLICY:
          serviceImpl.createTlsInspectionPolicy(
              (com.google.cloud.networksecurity.v1.CreateTlsInspectionPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_TLS_INSPECTION_POLICY:
          serviceImpl.updateTlsInspectionPolicy(
              (com.google.cloud.networksecurity.v1.UpdateTlsInspectionPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_TLS_INSPECTION_POLICY:
          serviceImpl.deleteTlsInspectionPolicy(
              (com.google.cloud.networksecurity.v1.DeleteTlsInspectionPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_AUTHZ_POLICIES:
          serviceImpl.listAuthzPolicies(
              (com.google.cloud.networksecurity.v1.ListAuthzPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.ListAuthzPoliciesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_AUTHZ_POLICY:
          serviceImpl.getAuthzPolicy(
              (com.google.cloud.networksecurity.v1.GetAuthzPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.AuthzPolicy>)
                  responseObserver);
          break;
        case METHODID_CREATE_AUTHZ_POLICY:
          serviceImpl.createAuthzPolicy(
              (com.google.cloud.networksecurity.v1.CreateAuthzPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_AUTHZ_POLICY:
          serviceImpl.updateAuthzPolicy(
              (com.google.cloud.networksecurity.v1.UpdateAuthzPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_AUTHZ_POLICY:
          serviceImpl.deleteAuthzPolicy(
              (com.google.cloud.networksecurity.v1.DeleteAuthzPolicyRequest) request,
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
            getListAuthorizationPoliciesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesRequest,
                    com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesResponse>(
                    service, METHODID_LIST_AUTHORIZATION_POLICIES)))
        .addMethod(
            getGetAuthorizationPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.GetAuthorizationPolicyRequest,
                    com.google.cloud.networksecurity.v1.AuthorizationPolicy>(
                    service, METHODID_GET_AUTHORIZATION_POLICY)))
        .addMethod(
            getCreateAuthorizationPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.CreateAuthorizationPolicyRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_AUTHORIZATION_POLICY)))
        .addMethod(
            getUpdateAuthorizationPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.UpdateAuthorizationPolicyRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_AUTHORIZATION_POLICY)))
        .addMethod(
            getDeleteAuthorizationPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.DeleteAuthorizationPolicyRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_AUTHORIZATION_POLICY)))
        .addMethod(
            getListBackendAuthenticationConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.ListBackendAuthenticationConfigsRequest,
                    com.google.cloud.networksecurity.v1.ListBackendAuthenticationConfigsResponse>(
                    service, METHODID_LIST_BACKEND_AUTHENTICATION_CONFIGS)))
        .addMethod(
            getGetBackendAuthenticationConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.GetBackendAuthenticationConfigRequest,
                    com.google.cloud.networksecurity.v1.BackendAuthenticationConfig>(
                    service, METHODID_GET_BACKEND_AUTHENTICATION_CONFIG)))
        .addMethod(
            getCreateBackendAuthenticationConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.CreateBackendAuthenticationConfigRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_BACKEND_AUTHENTICATION_CONFIG)))
        .addMethod(
            getUpdateBackendAuthenticationConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.UpdateBackendAuthenticationConfigRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_BACKEND_AUTHENTICATION_CONFIG)))
        .addMethod(
            getDeleteBackendAuthenticationConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.DeleteBackendAuthenticationConfigRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_BACKEND_AUTHENTICATION_CONFIG)))
        .addMethod(
            getListServerTlsPoliciesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.ListServerTlsPoliciesRequest,
                    com.google.cloud.networksecurity.v1.ListServerTlsPoliciesResponse>(
                    service, METHODID_LIST_SERVER_TLS_POLICIES)))
        .addMethod(
            getGetServerTlsPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.GetServerTlsPolicyRequest,
                    com.google.cloud.networksecurity.v1.ServerTlsPolicy>(
                    service, METHODID_GET_SERVER_TLS_POLICY)))
        .addMethod(
            getCreateServerTlsPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.CreateServerTlsPolicyRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_SERVER_TLS_POLICY)))
        .addMethod(
            getUpdateServerTlsPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.UpdateServerTlsPolicyRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_SERVER_TLS_POLICY)))
        .addMethod(
            getDeleteServerTlsPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.DeleteServerTlsPolicyRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_SERVER_TLS_POLICY)))
        .addMethod(
            getListClientTlsPoliciesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.ListClientTlsPoliciesRequest,
                    com.google.cloud.networksecurity.v1.ListClientTlsPoliciesResponse>(
                    service, METHODID_LIST_CLIENT_TLS_POLICIES)))
        .addMethod(
            getGetClientTlsPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.GetClientTlsPolicyRequest,
                    com.google.cloud.networksecurity.v1.ClientTlsPolicy>(
                    service, METHODID_GET_CLIENT_TLS_POLICY)))
        .addMethod(
            getCreateClientTlsPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.CreateClientTlsPolicyRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_CLIENT_TLS_POLICY)))
        .addMethod(
            getUpdateClientTlsPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.UpdateClientTlsPolicyRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_CLIENT_TLS_POLICY)))
        .addMethod(
            getDeleteClientTlsPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.DeleteClientTlsPolicyRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_CLIENT_TLS_POLICY)))
        .addMethod(
            getListGatewaySecurityPoliciesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.ListGatewaySecurityPoliciesRequest,
                    com.google.cloud.networksecurity.v1.ListGatewaySecurityPoliciesResponse>(
                    service, METHODID_LIST_GATEWAY_SECURITY_POLICIES)))
        .addMethod(
            getGetGatewaySecurityPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.GetGatewaySecurityPolicyRequest,
                    com.google.cloud.networksecurity.v1.GatewaySecurityPolicy>(
                    service, METHODID_GET_GATEWAY_SECURITY_POLICY)))
        .addMethod(
            getCreateGatewaySecurityPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.CreateGatewaySecurityPolicyRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_GATEWAY_SECURITY_POLICY)))
        .addMethod(
            getUpdateGatewaySecurityPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.UpdateGatewaySecurityPolicyRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_GATEWAY_SECURITY_POLICY)))
        .addMethod(
            getDeleteGatewaySecurityPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.DeleteGatewaySecurityPolicyRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_GATEWAY_SECURITY_POLICY)))
        .addMethod(
            getListGatewaySecurityPolicyRulesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.ListGatewaySecurityPolicyRulesRequest,
                    com.google.cloud.networksecurity.v1.ListGatewaySecurityPolicyRulesResponse>(
                    service, METHODID_LIST_GATEWAY_SECURITY_POLICY_RULES)))
        .addMethod(
            getGetGatewaySecurityPolicyRuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.GetGatewaySecurityPolicyRuleRequest,
                    com.google.cloud.networksecurity.v1.GatewaySecurityPolicyRule>(
                    service, METHODID_GET_GATEWAY_SECURITY_POLICY_RULE)))
        .addMethod(
            getCreateGatewaySecurityPolicyRuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.CreateGatewaySecurityPolicyRuleRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_GATEWAY_SECURITY_POLICY_RULE)))
        .addMethod(
            getUpdateGatewaySecurityPolicyRuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.UpdateGatewaySecurityPolicyRuleRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_GATEWAY_SECURITY_POLICY_RULE)))
        .addMethod(
            getDeleteGatewaySecurityPolicyRuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.DeleteGatewaySecurityPolicyRuleRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_GATEWAY_SECURITY_POLICY_RULE)))
        .addMethod(
            getListUrlListsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.ListUrlListsRequest,
                    com.google.cloud.networksecurity.v1.ListUrlListsResponse>(
                    service, METHODID_LIST_URL_LISTS)))
        .addMethod(
            getGetUrlListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.GetUrlListRequest,
                    com.google.cloud.networksecurity.v1.UrlList>(service, METHODID_GET_URL_LIST)))
        .addMethod(
            getCreateUrlListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.CreateUrlListRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_URL_LIST)))
        .addMethod(
            getUpdateUrlListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.UpdateUrlListRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_URL_LIST)))
        .addMethod(
            getDeleteUrlListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.DeleteUrlListRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_URL_LIST)))
        .addMethod(
            getListTlsInspectionPoliciesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.ListTlsInspectionPoliciesRequest,
                    com.google.cloud.networksecurity.v1.ListTlsInspectionPoliciesResponse>(
                    service, METHODID_LIST_TLS_INSPECTION_POLICIES)))
        .addMethod(
            getGetTlsInspectionPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.GetTlsInspectionPolicyRequest,
                    com.google.cloud.networksecurity.v1.TlsInspectionPolicy>(
                    service, METHODID_GET_TLS_INSPECTION_POLICY)))
        .addMethod(
            getCreateTlsInspectionPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.CreateTlsInspectionPolicyRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_TLS_INSPECTION_POLICY)))
        .addMethod(
            getUpdateTlsInspectionPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.UpdateTlsInspectionPolicyRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_TLS_INSPECTION_POLICY)))
        .addMethod(
            getDeleteTlsInspectionPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.DeleteTlsInspectionPolicyRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_TLS_INSPECTION_POLICY)))
        .addMethod(
            getListAuthzPoliciesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.ListAuthzPoliciesRequest,
                    com.google.cloud.networksecurity.v1.ListAuthzPoliciesResponse>(
                    service, METHODID_LIST_AUTHZ_POLICIES)))
        .addMethod(
            getGetAuthzPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.GetAuthzPolicyRequest,
                    com.google.cloud.networksecurity.v1.AuthzPolicy>(
                    service, METHODID_GET_AUTHZ_POLICY)))
        .addMethod(
            getCreateAuthzPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.CreateAuthzPolicyRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_AUTHZ_POLICY)))
        .addMethod(
            getUpdateAuthzPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.UpdateAuthzPolicyRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_AUTHZ_POLICY)))
        .addMethod(
            getDeleteAuthzPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.DeleteAuthzPolicyRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_AUTHZ_POLICY)))
        .build();
  }

  private abstract static class NetworkSecurityBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NetworkSecurityBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.networksecurity.v1.NetworkSecurityOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("NetworkSecurity");
    }
  }

  private static final class NetworkSecurityFileDescriptorSupplier
      extends NetworkSecurityBaseDescriptorSupplier {
    NetworkSecurityFileDescriptorSupplier() {}
  }

  private static final class NetworkSecurityMethodDescriptorSupplier
      extends NetworkSecurityBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    NetworkSecurityMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (NetworkSecurityGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new NetworkSecurityFileDescriptorSupplier())
                      .addMethod(getListAuthorizationPoliciesMethod())
                      .addMethod(getGetAuthorizationPolicyMethod())
                      .addMethod(getCreateAuthorizationPolicyMethod())
                      .addMethod(getUpdateAuthorizationPolicyMethod())
                      .addMethod(getDeleteAuthorizationPolicyMethod())
                      .addMethod(getListBackendAuthenticationConfigsMethod())
                      .addMethod(getGetBackendAuthenticationConfigMethod())
                      .addMethod(getCreateBackendAuthenticationConfigMethod())
                      .addMethod(getUpdateBackendAuthenticationConfigMethod())
                      .addMethod(getDeleteBackendAuthenticationConfigMethod())
                      .addMethod(getListServerTlsPoliciesMethod())
                      .addMethod(getGetServerTlsPolicyMethod())
                      .addMethod(getCreateServerTlsPolicyMethod())
                      .addMethod(getUpdateServerTlsPolicyMethod())
                      .addMethod(getDeleteServerTlsPolicyMethod())
                      .addMethod(getListClientTlsPoliciesMethod())
                      .addMethod(getGetClientTlsPolicyMethod())
                      .addMethod(getCreateClientTlsPolicyMethod())
                      .addMethod(getUpdateClientTlsPolicyMethod())
                      .addMethod(getDeleteClientTlsPolicyMethod())
                      .addMethod(getListGatewaySecurityPoliciesMethod())
                      .addMethod(getGetGatewaySecurityPolicyMethod())
                      .addMethod(getCreateGatewaySecurityPolicyMethod())
                      .addMethod(getUpdateGatewaySecurityPolicyMethod())
                      .addMethod(getDeleteGatewaySecurityPolicyMethod())
                      .addMethod(getListGatewaySecurityPolicyRulesMethod())
                      .addMethod(getGetGatewaySecurityPolicyRuleMethod())
                      .addMethod(getCreateGatewaySecurityPolicyRuleMethod())
                      .addMethod(getUpdateGatewaySecurityPolicyRuleMethod())
                      .addMethod(getDeleteGatewaySecurityPolicyRuleMethod())
                      .addMethod(getListUrlListsMethod())
                      .addMethod(getGetUrlListMethod())
                      .addMethod(getCreateUrlListMethod())
                      .addMethod(getUpdateUrlListMethod())
                      .addMethod(getDeleteUrlListMethod())
                      .addMethod(getListTlsInspectionPoliciesMethod())
                      .addMethod(getGetTlsInspectionPolicyMethod())
                      .addMethod(getCreateTlsInspectionPolicyMethod())
                      .addMethod(getUpdateTlsInspectionPolicyMethod())
                      .addMethod(getDeleteTlsInspectionPolicyMethod())
                      .addMethod(getListAuthzPoliciesMethod())
                      .addMethod(getGetAuthzPolicyMethod())
                      .addMethod(getCreateAuthzPolicyMethod())
                      .addMethod(getUpdateAuthzPolicyMethod())
                      .addMethod(getDeleteAuthzPolicyMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
