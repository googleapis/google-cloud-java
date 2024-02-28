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
package com.google.cloud.securitycentermanagement.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service describing handlers for resources
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/securitycentermanagement/v1/security_center_management.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SecurityCenterManagementGrpc {

  private SecurityCenterManagementGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.securitycentermanagement.v1.SecurityCenterManagement";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1
              .ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
          com.google.cloud.securitycentermanagement.v1
              .ListEffectiveSecurityHealthAnalyticsCustomModulesResponse>
      getListEffectiveSecurityHealthAnalyticsCustomModulesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEffectiveSecurityHealthAnalyticsCustomModules",
      requestType =
          com.google.cloud.securitycentermanagement.v1
              .ListEffectiveSecurityHealthAnalyticsCustomModulesRequest.class,
      responseType =
          com.google.cloud.securitycentermanagement.v1
              .ListEffectiveSecurityHealthAnalyticsCustomModulesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1
              .ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
          com.google.cloud.securitycentermanagement.v1
              .ListEffectiveSecurityHealthAnalyticsCustomModulesResponse>
      getListEffectiveSecurityHealthAnalyticsCustomModulesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycentermanagement.v1
                .ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
            com.google.cloud.securitycentermanagement.v1
                .ListEffectiveSecurityHealthAnalyticsCustomModulesResponse>
        getListEffectiveSecurityHealthAnalyticsCustomModulesMethod;
    if ((getListEffectiveSecurityHealthAnalyticsCustomModulesMethod =
            SecurityCenterManagementGrpc.getListEffectiveSecurityHealthAnalyticsCustomModulesMethod)
        == null) {
      synchronized (SecurityCenterManagementGrpc.class) {
        if ((getListEffectiveSecurityHealthAnalyticsCustomModulesMethod =
                SecurityCenterManagementGrpc
                    .getListEffectiveSecurityHealthAnalyticsCustomModulesMethod)
            == null) {
          SecurityCenterManagementGrpc.getListEffectiveSecurityHealthAnalyticsCustomModulesMethod =
              getListEffectiveSecurityHealthAnalyticsCustomModulesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycentermanagement.v1
                              .ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
                          com.google.cloud.securitycentermanagement.v1
                              .ListEffectiveSecurityHealthAnalyticsCustomModulesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "ListEffectiveSecurityHealthAnalyticsCustomModules"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .ListEffectiveSecurityHealthAnalyticsCustomModulesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .ListEffectiveSecurityHealthAnalyticsCustomModulesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterManagementMethodDescriptorSupplier(
                              "ListEffectiveSecurityHealthAnalyticsCustomModules"))
                      .build();
        }
      }
    }
    return getListEffectiveSecurityHealthAnalyticsCustomModulesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1
              .GetEffectiveSecurityHealthAnalyticsCustomModuleRequest,
          com.google.cloud.securitycentermanagement.v1.EffectiveSecurityHealthAnalyticsCustomModule>
      getGetEffectiveSecurityHealthAnalyticsCustomModuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEffectiveSecurityHealthAnalyticsCustomModule",
      requestType =
          com.google.cloud.securitycentermanagement.v1
              .GetEffectiveSecurityHealthAnalyticsCustomModuleRequest.class,
      responseType =
          com.google.cloud.securitycentermanagement.v1.EffectiveSecurityHealthAnalyticsCustomModule
              .class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1
              .GetEffectiveSecurityHealthAnalyticsCustomModuleRequest,
          com.google.cloud.securitycentermanagement.v1.EffectiveSecurityHealthAnalyticsCustomModule>
      getGetEffectiveSecurityHealthAnalyticsCustomModuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycentermanagement.v1
                .GetEffectiveSecurityHealthAnalyticsCustomModuleRequest,
            com.google.cloud.securitycentermanagement.v1
                .EffectiveSecurityHealthAnalyticsCustomModule>
        getGetEffectiveSecurityHealthAnalyticsCustomModuleMethod;
    if ((getGetEffectiveSecurityHealthAnalyticsCustomModuleMethod =
            SecurityCenterManagementGrpc.getGetEffectiveSecurityHealthAnalyticsCustomModuleMethod)
        == null) {
      synchronized (SecurityCenterManagementGrpc.class) {
        if ((getGetEffectiveSecurityHealthAnalyticsCustomModuleMethod =
                SecurityCenterManagementGrpc
                    .getGetEffectiveSecurityHealthAnalyticsCustomModuleMethod)
            == null) {
          SecurityCenterManagementGrpc.getGetEffectiveSecurityHealthAnalyticsCustomModuleMethod =
              getGetEffectiveSecurityHealthAnalyticsCustomModuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycentermanagement.v1
                              .GetEffectiveSecurityHealthAnalyticsCustomModuleRequest,
                          com.google.cloud.securitycentermanagement.v1
                              .EffectiveSecurityHealthAnalyticsCustomModule>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "GetEffectiveSecurityHealthAnalyticsCustomModule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .GetEffectiveSecurityHealthAnalyticsCustomModuleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .EffectiveSecurityHealthAnalyticsCustomModule
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterManagementMethodDescriptorSupplier(
                              "GetEffectiveSecurityHealthAnalyticsCustomModule"))
                      .build();
        }
      }
    }
    return getGetEffectiveSecurityHealthAnalyticsCustomModuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1
              .ListSecurityHealthAnalyticsCustomModulesRequest,
          com.google.cloud.securitycentermanagement.v1
              .ListSecurityHealthAnalyticsCustomModulesResponse>
      getListSecurityHealthAnalyticsCustomModulesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSecurityHealthAnalyticsCustomModules",
      requestType =
          com.google.cloud.securitycentermanagement.v1
              .ListSecurityHealthAnalyticsCustomModulesRequest.class,
      responseType =
          com.google.cloud.securitycentermanagement.v1
              .ListSecurityHealthAnalyticsCustomModulesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1
              .ListSecurityHealthAnalyticsCustomModulesRequest,
          com.google.cloud.securitycentermanagement.v1
              .ListSecurityHealthAnalyticsCustomModulesResponse>
      getListSecurityHealthAnalyticsCustomModulesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycentermanagement.v1
                .ListSecurityHealthAnalyticsCustomModulesRequest,
            com.google.cloud.securitycentermanagement.v1
                .ListSecurityHealthAnalyticsCustomModulesResponse>
        getListSecurityHealthAnalyticsCustomModulesMethod;
    if ((getListSecurityHealthAnalyticsCustomModulesMethod =
            SecurityCenterManagementGrpc.getListSecurityHealthAnalyticsCustomModulesMethod)
        == null) {
      synchronized (SecurityCenterManagementGrpc.class) {
        if ((getListSecurityHealthAnalyticsCustomModulesMethod =
                SecurityCenterManagementGrpc.getListSecurityHealthAnalyticsCustomModulesMethod)
            == null) {
          SecurityCenterManagementGrpc.getListSecurityHealthAnalyticsCustomModulesMethod =
              getListSecurityHealthAnalyticsCustomModulesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycentermanagement.v1
                              .ListSecurityHealthAnalyticsCustomModulesRequest,
                          com.google.cloud.securitycentermanagement.v1
                              .ListSecurityHealthAnalyticsCustomModulesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "ListSecurityHealthAnalyticsCustomModules"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .ListSecurityHealthAnalyticsCustomModulesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .ListSecurityHealthAnalyticsCustomModulesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterManagementMethodDescriptorSupplier(
                              "ListSecurityHealthAnalyticsCustomModules"))
                      .build();
        }
      }
    }
    return getListSecurityHealthAnalyticsCustomModulesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1
              .ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
          com.google.cloud.securitycentermanagement.v1
              .ListDescendantSecurityHealthAnalyticsCustomModulesResponse>
      getListDescendantSecurityHealthAnalyticsCustomModulesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDescendantSecurityHealthAnalyticsCustomModules",
      requestType =
          com.google.cloud.securitycentermanagement.v1
              .ListDescendantSecurityHealthAnalyticsCustomModulesRequest.class,
      responseType =
          com.google.cloud.securitycentermanagement.v1
              .ListDescendantSecurityHealthAnalyticsCustomModulesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1
              .ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
          com.google.cloud.securitycentermanagement.v1
              .ListDescendantSecurityHealthAnalyticsCustomModulesResponse>
      getListDescendantSecurityHealthAnalyticsCustomModulesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycentermanagement.v1
                .ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
            com.google.cloud.securitycentermanagement.v1
                .ListDescendantSecurityHealthAnalyticsCustomModulesResponse>
        getListDescendantSecurityHealthAnalyticsCustomModulesMethod;
    if ((getListDescendantSecurityHealthAnalyticsCustomModulesMethod =
            SecurityCenterManagementGrpc
                .getListDescendantSecurityHealthAnalyticsCustomModulesMethod)
        == null) {
      synchronized (SecurityCenterManagementGrpc.class) {
        if ((getListDescendantSecurityHealthAnalyticsCustomModulesMethod =
                SecurityCenterManagementGrpc
                    .getListDescendantSecurityHealthAnalyticsCustomModulesMethod)
            == null) {
          SecurityCenterManagementGrpc.getListDescendantSecurityHealthAnalyticsCustomModulesMethod =
              getListDescendantSecurityHealthAnalyticsCustomModulesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycentermanagement.v1
                              .ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
                          com.google.cloud.securitycentermanagement.v1
                              .ListDescendantSecurityHealthAnalyticsCustomModulesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "ListDescendantSecurityHealthAnalyticsCustomModules"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .ListDescendantSecurityHealthAnalyticsCustomModulesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .ListDescendantSecurityHealthAnalyticsCustomModulesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterManagementMethodDescriptorSupplier(
                              "ListDescendantSecurityHealthAnalyticsCustomModules"))
                      .build();
        }
      }
    }
    return getListDescendantSecurityHealthAnalyticsCustomModulesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1
              .GetSecurityHealthAnalyticsCustomModuleRequest,
          com.google.cloud.securitycentermanagement.v1.SecurityHealthAnalyticsCustomModule>
      getGetSecurityHealthAnalyticsCustomModuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSecurityHealthAnalyticsCustomModule",
      requestType =
          com.google.cloud.securitycentermanagement.v1.GetSecurityHealthAnalyticsCustomModuleRequest
              .class,
      responseType =
          com.google.cloud.securitycentermanagement.v1.SecurityHealthAnalyticsCustomModule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1
              .GetSecurityHealthAnalyticsCustomModuleRequest,
          com.google.cloud.securitycentermanagement.v1.SecurityHealthAnalyticsCustomModule>
      getGetSecurityHealthAnalyticsCustomModuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycentermanagement.v1
                .GetSecurityHealthAnalyticsCustomModuleRequest,
            com.google.cloud.securitycentermanagement.v1.SecurityHealthAnalyticsCustomModule>
        getGetSecurityHealthAnalyticsCustomModuleMethod;
    if ((getGetSecurityHealthAnalyticsCustomModuleMethod =
            SecurityCenterManagementGrpc.getGetSecurityHealthAnalyticsCustomModuleMethod)
        == null) {
      synchronized (SecurityCenterManagementGrpc.class) {
        if ((getGetSecurityHealthAnalyticsCustomModuleMethod =
                SecurityCenterManagementGrpc.getGetSecurityHealthAnalyticsCustomModuleMethod)
            == null) {
          SecurityCenterManagementGrpc.getGetSecurityHealthAnalyticsCustomModuleMethod =
              getGetSecurityHealthAnalyticsCustomModuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycentermanagement.v1
                              .GetSecurityHealthAnalyticsCustomModuleRequest,
                          com.google.cloud.securitycentermanagement.v1
                              .SecurityHealthAnalyticsCustomModule>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "GetSecurityHealthAnalyticsCustomModule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .GetSecurityHealthAnalyticsCustomModuleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .SecurityHealthAnalyticsCustomModule.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterManagementMethodDescriptorSupplier(
                              "GetSecurityHealthAnalyticsCustomModule"))
                      .build();
        }
      }
    }
    return getGetSecurityHealthAnalyticsCustomModuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1
              .CreateSecurityHealthAnalyticsCustomModuleRequest,
          com.google.cloud.securitycentermanagement.v1.SecurityHealthAnalyticsCustomModule>
      getCreateSecurityHealthAnalyticsCustomModuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSecurityHealthAnalyticsCustomModule",
      requestType =
          com.google.cloud.securitycentermanagement.v1
              .CreateSecurityHealthAnalyticsCustomModuleRequest.class,
      responseType =
          com.google.cloud.securitycentermanagement.v1.SecurityHealthAnalyticsCustomModule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1
              .CreateSecurityHealthAnalyticsCustomModuleRequest,
          com.google.cloud.securitycentermanagement.v1.SecurityHealthAnalyticsCustomModule>
      getCreateSecurityHealthAnalyticsCustomModuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycentermanagement.v1
                .CreateSecurityHealthAnalyticsCustomModuleRequest,
            com.google.cloud.securitycentermanagement.v1.SecurityHealthAnalyticsCustomModule>
        getCreateSecurityHealthAnalyticsCustomModuleMethod;
    if ((getCreateSecurityHealthAnalyticsCustomModuleMethod =
            SecurityCenterManagementGrpc.getCreateSecurityHealthAnalyticsCustomModuleMethod)
        == null) {
      synchronized (SecurityCenterManagementGrpc.class) {
        if ((getCreateSecurityHealthAnalyticsCustomModuleMethod =
                SecurityCenterManagementGrpc.getCreateSecurityHealthAnalyticsCustomModuleMethod)
            == null) {
          SecurityCenterManagementGrpc.getCreateSecurityHealthAnalyticsCustomModuleMethod =
              getCreateSecurityHealthAnalyticsCustomModuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycentermanagement.v1
                              .CreateSecurityHealthAnalyticsCustomModuleRequest,
                          com.google.cloud.securitycentermanagement.v1
                              .SecurityHealthAnalyticsCustomModule>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "CreateSecurityHealthAnalyticsCustomModule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .CreateSecurityHealthAnalyticsCustomModuleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .SecurityHealthAnalyticsCustomModule.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterManagementMethodDescriptorSupplier(
                              "CreateSecurityHealthAnalyticsCustomModule"))
                      .build();
        }
      }
    }
    return getCreateSecurityHealthAnalyticsCustomModuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1
              .UpdateSecurityHealthAnalyticsCustomModuleRequest,
          com.google.cloud.securitycentermanagement.v1.SecurityHealthAnalyticsCustomModule>
      getUpdateSecurityHealthAnalyticsCustomModuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSecurityHealthAnalyticsCustomModule",
      requestType =
          com.google.cloud.securitycentermanagement.v1
              .UpdateSecurityHealthAnalyticsCustomModuleRequest.class,
      responseType =
          com.google.cloud.securitycentermanagement.v1.SecurityHealthAnalyticsCustomModule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1
              .UpdateSecurityHealthAnalyticsCustomModuleRequest,
          com.google.cloud.securitycentermanagement.v1.SecurityHealthAnalyticsCustomModule>
      getUpdateSecurityHealthAnalyticsCustomModuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycentermanagement.v1
                .UpdateSecurityHealthAnalyticsCustomModuleRequest,
            com.google.cloud.securitycentermanagement.v1.SecurityHealthAnalyticsCustomModule>
        getUpdateSecurityHealthAnalyticsCustomModuleMethod;
    if ((getUpdateSecurityHealthAnalyticsCustomModuleMethod =
            SecurityCenterManagementGrpc.getUpdateSecurityHealthAnalyticsCustomModuleMethod)
        == null) {
      synchronized (SecurityCenterManagementGrpc.class) {
        if ((getUpdateSecurityHealthAnalyticsCustomModuleMethod =
                SecurityCenterManagementGrpc.getUpdateSecurityHealthAnalyticsCustomModuleMethod)
            == null) {
          SecurityCenterManagementGrpc.getUpdateSecurityHealthAnalyticsCustomModuleMethod =
              getUpdateSecurityHealthAnalyticsCustomModuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycentermanagement.v1
                              .UpdateSecurityHealthAnalyticsCustomModuleRequest,
                          com.google.cloud.securitycentermanagement.v1
                              .SecurityHealthAnalyticsCustomModule>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "UpdateSecurityHealthAnalyticsCustomModule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .UpdateSecurityHealthAnalyticsCustomModuleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .SecurityHealthAnalyticsCustomModule.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterManagementMethodDescriptorSupplier(
                              "UpdateSecurityHealthAnalyticsCustomModule"))
                      .build();
        }
      }
    }
    return getUpdateSecurityHealthAnalyticsCustomModuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1
              .DeleteSecurityHealthAnalyticsCustomModuleRequest,
          com.google.protobuf.Empty>
      getDeleteSecurityHealthAnalyticsCustomModuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSecurityHealthAnalyticsCustomModule",
      requestType =
          com.google.cloud.securitycentermanagement.v1
              .DeleteSecurityHealthAnalyticsCustomModuleRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1
              .DeleteSecurityHealthAnalyticsCustomModuleRequest,
          com.google.protobuf.Empty>
      getDeleteSecurityHealthAnalyticsCustomModuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycentermanagement.v1
                .DeleteSecurityHealthAnalyticsCustomModuleRequest,
            com.google.protobuf.Empty>
        getDeleteSecurityHealthAnalyticsCustomModuleMethod;
    if ((getDeleteSecurityHealthAnalyticsCustomModuleMethod =
            SecurityCenterManagementGrpc.getDeleteSecurityHealthAnalyticsCustomModuleMethod)
        == null) {
      synchronized (SecurityCenterManagementGrpc.class) {
        if ((getDeleteSecurityHealthAnalyticsCustomModuleMethod =
                SecurityCenterManagementGrpc.getDeleteSecurityHealthAnalyticsCustomModuleMethod)
            == null) {
          SecurityCenterManagementGrpc.getDeleteSecurityHealthAnalyticsCustomModuleMethod =
              getDeleteSecurityHealthAnalyticsCustomModuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycentermanagement.v1
                              .DeleteSecurityHealthAnalyticsCustomModuleRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "DeleteSecurityHealthAnalyticsCustomModule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .DeleteSecurityHealthAnalyticsCustomModuleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterManagementMethodDescriptorSupplier(
                              "DeleteSecurityHealthAnalyticsCustomModule"))
                      .build();
        }
      }
    }
    return getDeleteSecurityHealthAnalyticsCustomModuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1
              .SimulateSecurityHealthAnalyticsCustomModuleRequest,
          com.google.cloud.securitycentermanagement.v1
              .SimulateSecurityHealthAnalyticsCustomModuleResponse>
      getSimulateSecurityHealthAnalyticsCustomModuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SimulateSecurityHealthAnalyticsCustomModule",
      requestType =
          com.google.cloud.securitycentermanagement.v1
              .SimulateSecurityHealthAnalyticsCustomModuleRequest.class,
      responseType =
          com.google.cloud.securitycentermanagement.v1
              .SimulateSecurityHealthAnalyticsCustomModuleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1
              .SimulateSecurityHealthAnalyticsCustomModuleRequest,
          com.google.cloud.securitycentermanagement.v1
              .SimulateSecurityHealthAnalyticsCustomModuleResponse>
      getSimulateSecurityHealthAnalyticsCustomModuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycentermanagement.v1
                .SimulateSecurityHealthAnalyticsCustomModuleRequest,
            com.google.cloud.securitycentermanagement.v1
                .SimulateSecurityHealthAnalyticsCustomModuleResponse>
        getSimulateSecurityHealthAnalyticsCustomModuleMethod;
    if ((getSimulateSecurityHealthAnalyticsCustomModuleMethod =
            SecurityCenterManagementGrpc.getSimulateSecurityHealthAnalyticsCustomModuleMethod)
        == null) {
      synchronized (SecurityCenterManagementGrpc.class) {
        if ((getSimulateSecurityHealthAnalyticsCustomModuleMethod =
                SecurityCenterManagementGrpc.getSimulateSecurityHealthAnalyticsCustomModuleMethod)
            == null) {
          SecurityCenterManagementGrpc.getSimulateSecurityHealthAnalyticsCustomModuleMethod =
              getSimulateSecurityHealthAnalyticsCustomModuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycentermanagement.v1
                              .SimulateSecurityHealthAnalyticsCustomModuleRequest,
                          com.google.cloud.securitycentermanagement.v1
                              .SimulateSecurityHealthAnalyticsCustomModuleResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "SimulateSecurityHealthAnalyticsCustomModule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .SimulateSecurityHealthAnalyticsCustomModuleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .SimulateSecurityHealthAnalyticsCustomModuleResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterManagementMethodDescriptorSupplier(
                              "SimulateSecurityHealthAnalyticsCustomModule"))
                      .build();
        }
      }
    }
    return getSimulateSecurityHealthAnalyticsCustomModuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1
              .ListEffectiveEventThreatDetectionCustomModulesRequest,
          com.google.cloud.securitycentermanagement.v1
              .ListEffectiveEventThreatDetectionCustomModulesResponse>
      getListEffectiveEventThreatDetectionCustomModulesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEffectiveEventThreatDetectionCustomModules",
      requestType =
          com.google.cloud.securitycentermanagement.v1
              .ListEffectiveEventThreatDetectionCustomModulesRequest.class,
      responseType =
          com.google.cloud.securitycentermanagement.v1
              .ListEffectiveEventThreatDetectionCustomModulesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1
              .ListEffectiveEventThreatDetectionCustomModulesRequest,
          com.google.cloud.securitycentermanagement.v1
              .ListEffectiveEventThreatDetectionCustomModulesResponse>
      getListEffectiveEventThreatDetectionCustomModulesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycentermanagement.v1
                .ListEffectiveEventThreatDetectionCustomModulesRequest,
            com.google.cloud.securitycentermanagement.v1
                .ListEffectiveEventThreatDetectionCustomModulesResponse>
        getListEffectiveEventThreatDetectionCustomModulesMethod;
    if ((getListEffectiveEventThreatDetectionCustomModulesMethod =
            SecurityCenterManagementGrpc.getListEffectiveEventThreatDetectionCustomModulesMethod)
        == null) {
      synchronized (SecurityCenterManagementGrpc.class) {
        if ((getListEffectiveEventThreatDetectionCustomModulesMethod =
                SecurityCenterManagementGrpc
                    .getListEffectiveEventThreatDetectionCustomModulesMethod)
            == null) {
          SecurityCenterManagementGrpc.getListEffectiveEventThreatDetectionCustomModulesMethod =
              getListEffectiveEventThreatDetectionCustomModulesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycentermanagement.v1
                              .ListEffectiveEventThreatDetectionCustomModulesRequest,
                          com.google.cloud.securitycentermanagement.v1
                              .ListEffectiveEventThreatDetectionCustomModulesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "ListEffectiveEventThreatDetectionCustomModules"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .ListEffectiveEventThreatDetectionCustomModulesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .ListEffectiveEventThreatDetectionCustomModulesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterManagementMethodDescriptorSupplier(
                              "ListEffectiveEventThreatDetectionCustomModules"))
                      .build();
        }
      }
    }
    return getListEffectiveEventThreatDetectionCustomModulesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1
              .GetEffectiveEventThreatDetectionCustomModuleRequest,
          com.google.cloud.securitycentermanagement.v1.EffectiveEventThreatDetectionCustomModule>
      getGetEffectiveEventThreatDetectionCustomModuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEffectiveEventThreatDetectionCustomModule",
      requestType =
          com.google.cloud.securitycentermanagement.v1
              .GetEffectiveEventThreatDetectionCustomModuleRequest.class,
      responseType =
          com.google.cloud.securitycentermanagement.v1.EffectiveEventThreatDetectionCustomModule
              .class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1
              .GetEffectiveEventThreatDetectionCustomModuleRequest,
          com.google.cloud.securitycentermanagement.v1.EffectiveEventThreatDetectionCustomModule>
      getGetEffectiveEventThreatDetectionCustomModuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycentermanagement.v1
                .GetEffectiveEventThreatDetectionCustomModuleRequest,
            com.google.cloud.securitycentermanagement.v1.EffectiveEventThreatDetectionCustomModule>
        getGetEffectiveEventThreatDetectionCustomModuleMethod;
    if ((getGetEffectiveEventThreatDetectionCustomModuleMethod =
            SecurityCenterManagementGrpc.getGetEffectiveEventThreatDetectionCustomModuleMethod)
        == null) {
      synchronized (SecurityCenterManagementGrpc.class) {
        if ((getGetEffectiveEventThreatDetectionCustomModuleMethod =
                SecurityCenterManagementGrpc.getGetEffectiveEventThreatDetectionCustomModuleMethod)
            == null) {
          SecurityCenterManagementGrpc.getGetEffectiveEventThreatDetectionCustomModuleMethod =
              getGetEffectiveEventThreatDetectionCustomModuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycentermanagement.v1
                              .GetEffectiveEventThreatDetectionCustomModuleRequest,
                          com.google.cloud.securitycentermanagement.v1
                              .EffectiveEventThreatDetectionCustomModule>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "GetEffectiveEventThreatDetectionCustomModule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .GetEffectiveEventThreatDetectionCustomModuleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .EffectiveEventThreatDetectionCustomModule.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterManagementMethodDescriptorSupplier(
                              "GetEffectiveEventThreatDetectionCustomModule"))
                      .build();
        }
      }
    }
    return getGetEffectiveEventThreatDetectionCustomModuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1.ListEventThreatDetectionCustomModulesRequest,
          com.google.cloud.securitycentermanagement.v1
              .ListEventThreatDetectionCustomModulesResponse>
      getListEventThreatDetectionCustomModulesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEventThreatDetectionCustomModules",
      requestType =
          com.google.cloud.securitycentermanagement.v1.ListEventThreatDetectionCustomModulesRequest
              .class,
      responseType =
          com.google.cloud.securitycentermanagement.v1.ListEventThreatDetectionCustomModulesResponse
              .class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1.ListEventThreatDetectionCustomModulesRequest,
          com.google.cloud.securitycentermanagement.v1
              .ListEventThreatDetectionCustomModulesResponse>
      getListEventThreatDetectionCustomModulesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycentermanagement.v1
                .ListEventThreatDetectionCustomModulesRequest,
            com.google.cloud.securitycentermanagement.v1
                .ListEventThreatDetectionCustomModulesResponse>
        getListEventThreatDetectionCustomModulesMethod;
    if ((getListEventThreatDetectionCustomModulesMethod =
            SecurityCenterManagementGrpc.getListEventThreatDetectionCustomModulesMethod)
        == null) {
      synchronized (SecurityCenterManagementGrpc.class) {
        if ((getListEventThreatDetectionCustomModulesMethod =
                SecurityCenterManagementGrpc.getListEventThreatDetectionCustomModulesMethod)
            == null) {
          SecurityCenterManagementGrpc.getListEventThreatDetectionCustomModulesMethod =
              getListEventThreatDetectionCustomModulesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycentermanagement.v1
                              .ListEventThreatDetectionCustomModulesRequest,
                          com.google.cloud.securitycentermanagement.v1
                              .ListEventThreatDetectionCustomModulesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "ListEventThreatDetectionCustomModules"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .ListEventThreatDetectionCustomModulesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .ListEventThreatDetectionCustomModulesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterManagementMethodDescriptorSupplier(
                              "ListEventThreatDetectionCustomModules"))
                      .build();
        }
      }
    }
    return getListEventThreatDetectionCustomModulesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1
              .ListDescendantEventThreatDetectionCustomModulesRequest,
          com.google.cloud.securitycentermanagement.v1
              .ListDescendantEventThreatDetectionCustomModulesResponse>
      getListDescendantEventThreatDetectionCustomModulesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDescendantEventThreatDetectionCustomModules",
      requestType =
          com.google.cloud.securitycentermanagement.v1
              .ListDescendantEventThreatDetectionCustomModulesRequest.class,
      responseType =
          com.google.cloud.securitycentermanagement.v1
              .ListDescendantEventThreatDetectionCustomModulesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1
              .ListDescendantEventThreatDetectionCustomModulesRequest,
          com.google.cloud.securitycentermanagement.v1
              .ListDescendantEventThreatDetectionCustomModulesResponse>
      getListDescendantEventThreatDetectionCustomModulesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycentermanagement.v1
                .ListDescendantEventThreatDetectionCustomModulesRequest,
            com.google.cloud.securitycentermanagement.v1
                .ListDescendantEventThreatDetectionCustomModulesResponse>
        getListDescendantEventThreatDetectionCustomModulesMethod;
    if ((getListDescendantEventThreatDetectionCustomModulesMethod =
            SecurityCenterManagementGrpc.getListDescendantEventThreatDetectionCustomModulesMethod)
        == null) {
      synchronized (SecurityCenterManagementGrpc.class) {
        if ((getListDescendantEventThreatDetectionCustomModulesMethod =
                SecurityCenterManagementGrpc
                    .getListDescendantEventThreatDetectionCustomModulesMethod)
            == null) {
          SecurityCenterManagementGrpc.getListDescendantEventThreatDetectionCustomModulesMethod =
              getListDescendantEventThreatDetectionCustomModulesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycentermanagement.v1
                              .ListDescendantEventThreatDetectionCustomModulesRequest,
                          com.google.cloud.securitycentermanagement.v1
                              .ListDescendantEventThreatDetectionCustomModulesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "ListDescendantEventThreatDetectionCustomModules"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .ListDescendantEventThreatDetectionCustomModulesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .ListDescendantEventThreatDetectionCustomModulesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterManagementMethodDescriptorSupplier(
                              "ListDescendantEventThreatDetectionCustomModules"))
                      .build();
        }
      }
    }
    return getListDescendantEventThreatDetectionCustomModulesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1.GetEventThreatDetectionCustomModuleRequest,
          com.google.cloud.securitycentermanagement.v1.EventThreatDetectionCustomModule>
      getGetEventThreatDetectionCustomModuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEventThreatDetectionCustomModule",
      requestType =
          com.google.cloud.securitycentermanagement.v1.GetEventThreatDetectionCustomModuleRequest
              .class,
      responseType =
          com.google.cloud.securitycentermanagement.v1.EventThreatDetectionCustomModule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1.GetEventThreatDetectionCustomModuleRequest,
          com.google.cloud.securitycentermanagement.v1.EventThreatDetectionCustomModule>
      getGetEventThreatDetectionCustomModuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycentermanagement.v1.GetEventThreatDetectionCustomModuleRequest,
            com.google.cloud.securitycentermanagement.v1.EventThreatDetectionCustomModule>
        getGetEventThreatDetectionCustomModuleMethod;
    if ((getGetEventThreatDetectionCustomModuleMethod =
            SecurityCenterManagementGrpc.getGetEventThreatDetectionCustomModuleMethod)
        == null) {
      synchronized (SecurityCenterManagementGrpc.class) {
        if ((getGetEventThreatDetectionCustomModuleMethod =
                SecurityCenterManagementGrpc.getGetEventThreatDetectionCustomModuleMethod)
            == null) {
          SecurityCenterManagementGrpc.getGetEventThreatDetectionCustomModuleMethod =
              getGetEventThreatDetectionCustomModuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycentermanagement.v1
                              .GetEventThreatDetectionCustomModuleRequest,
                          com.google.cloud.securitycentermanagement.v1
                              .EventThreatDetectionCustomModule>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "GetEventThreatDetectionCustomModule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .GetEventThreatDetectionCustomModuleRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .EventThreatDetectionCustomModule.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterManagementMethodDescriptorSupplier(
                              "GetEventThreatDetectionCustomModule"))
                      .build();
        }
      }
    }
    return getGetEventThreatDetectionCustomModuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1
              .CreateEventThreatDetectionCustomModuleRequest,
          com.google.cloud.securitycentermanagement.v1.EventThreatDetectionCustomModule>
      getCreateEventThreatDetectionCustomModuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEventThreatDetectionCustomModule",
      requestType =
          com.google.cloud.securitycentermanagement.v1.CreateEventThreatDetectionCustomModuleRequest
              .class,
      responseType =
          com.google.cloud.securitycentermanagement.v1.EventThreatDetectionCustomModule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1
              .CreateEventThreatDetectionCustomModuleRequest,
          com.google.cloud.securitycentermanagement.v1.EventThreatDetectionCustomModule>
      getCreateEventThreatDetectionCustomModuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycentermanagement.v1
                .CreateEventThreatDetectionCustomModuleRequest,
            com.google.cloud.securitycentermanagement.v1.EventThreatDetectionCustomModule>
        getCreateEventThreatDetectionCustomModuleMethod;
    if ((getCreateEventThreatDetectionCustomModuleMethod =
            SecurityCenterManagementGrpc.getCreateEventThreatDetectionCustomModuleMethod)
        == null) {
      synchronized (SecurityCenterManagementGrpc.class) {
        if ((getCreateEventThreatDetectionCustomModuleMethod =
                SecurityCenterManagementGrpc.getCreateEventThreatDetectionCustomModuleMethod)
            == null) {
          SecurityCenterManagementGrpc.getCreateEventThreatDetectionCustomModuleMethod =
              getCreateEventThreatDetectionCustomModuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycentermanagement.v1
                              .CreateEventThreatDetectionCustomModuleRequest,
                          com.google.cloud.securitycentermanagement.v1
                              .EventThreatDetectionCustomModule>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "CreateEventThreatDetectionCustomModule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .CreateEventThreatDetectionCustomModuleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .EventThreatDetectionCustomModule.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterManagementMethodDescriptorSupplier(
                              "CreateEventThreatDetectionCustomModule"))
                      .build();
        }
      }
    }
    return getCreateEventThreatDetectionCustomModuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1
              .UpdateEventThreatDetectionCustomModuleRequest,
          com.google.cloud.securitycentermanagement.v1.EventThreatDetectionCustomModule>
      getUpdateEventThreatDetectionCustomModuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEventThreatDetectionCustomModule",
      requestType =
          com.google.cloud.securitycentermanagement.v1.UpdateEventThreatDetectionCustomModuleRequest
              .class,
      responseType =
          com.google.cloud.securitycentermanagement.v1.EventThreatDetectionCustomModule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1
              .UpdateEventThreatDetectionCustomModuleRequest,
          com.google.cloud.securitycentermanagement.v1.EventThreatDetectionCustomModule>
      getUpdateEventThreatDetectionCustomModuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycentermanagement.v1
                .UpdateEventThreatDetectionCustomModuleRequest,
            com.google.cloud.securitycentermanagement.v1.EventThreatDetectionCustomModule>
        getUpdateEventThreatDetectionCustomModuleMethod;
    if ((getUpdateEventThreatDetectionCustomModuleMethod =
            SecurityCenterManagementGrpc.getUpdateEventThreatDetectionCustomModuleMethod)
        == null) {
      synchronized (SecurityCenterManagementGrpc.class) {
        if ((getUpdateEventThreatDetectionCustomModuleMethod =
                SecurityCenterManagementGrpc.getUpdateEventThreatDetectionCustomModuleMethod)
            == null) {
          SecurityCenterManagementGrpc.getUpdateEventThreatDetectionCustomModuleMethod =
              getUpdateEventThreatDetectionCustomModuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycentermanagement.v1
                              .UpdateEventThreatDetectionCustomModuleRequest,
                          com.google.cloud.securitycentermanagement.v1
                              .EventThreatDetectionCustomModule>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "UpdateEventThreatDetectionCustomModule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .UpdateEventThreatDetectionCustomModuleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .EventThreatDetectionCustomModule.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterManagementMethodDescriptorSupplier(
                              "UpdateEventThreatDetectionCustomModule"))
                      .build();
        }
      }
    }
    return getUpdateEventThreatDetectionCustomModuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1
              .DeleteEventThreatDetectionCustomModuleRequest,
          com.google.protobuf.Empty>
      getDeleteEventThreatDetectionCustomModuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEventThreatDetectionCustomModule",
      requestType =
          com.google.cloud.securitycentermanagement.v1.DeleteEventThreatDetectionCustomModuleRequest
              .class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1
              .DeleteEventThreatDetectionCustomModuleRequest,
          com.google.protobuf.Empty>
      getDeleteEventThreatDetectionCustomModuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycentermanagement.v1
                .DeleteEventThreatDetectionCustomModuleRequest,
            com.google.protobuf.Empty>
        getDeleteEventThreatDetectionCustomModuleMethod;
    if ((getDeleteEventThreatDetectionCustomModuleMethod =
            SecurityCenterManagementGrpc.getDeleteEventThreatDetectionCustomModuleMethod)
        == null) {
      synchronized (SecurityCenterManagementGrpc.class) {
        if ((getDeleteEventThreatDetectionCustomModuleMethod =
                SecurityCenterManagementGrpc.getDeleteEventThreatDetectionCustomModuleMethod)
            == null) {
          SecurityCenterManagementGrpc.getDeleteEventThreatDetectionCustomModuleMethod =
              getDeleteEventThreatDetectionCustomModuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycentermanagement.v1
                              .DeleteEventThreatDetectionCustomModuleRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "DeleteEventThreatDetectionCustomModule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .DeleteEventThreatDetectionCustomModuleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterManagementMethodDescriptorSupplier(
                              "DeleteEventThreatDetectionCustomModule"))
                      .build();
        }
      }
    }
    return getDeleteEventThreatDetectionCustomModuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1
              .ValidateEventThreatDetectionCustomModuleRequest,
          com.google.cloud.securitycentermanagement.v1
              .ValidateEventThreatDetectionCustomModuleResponse>
      getValidateEventThreatDetectionCustomModuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ValidateEventThreatDetectionCustomModule",
      requestType =
          com.google.cloud.securitycentermanagement.v1
              .ValidateEventThreatDetectionCustomModuleRequest.class,
      responseType =
          com.google.cloud.securitycentermanagement.v1
              .ValidateEventThreatDetectionCustomModuleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycentermanagement.v1
              .ValidateEventThreatDetectionCustomModuleRequest,
          com.google.cloud.securitycentermanagement.v1
              .ValidateEventThreatDetectionCustomModuleResponse>
      getValidateEventThreatDetectionCustomModuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycentermanagement.v1
                .ValidateEventThreatDetectionCustomModuleRequest,
            com.google.cloud.securitycentermanagement.v1
                .ValidateEventThreatDetectionCustomModuleResponse>
        getValidateEventThreatDetectionCustomModuleMethod;
    if ((getValidateEventThreatDetectionCustomModuleMethod =
            SecurityCenterManagementGrpc.getValidateEventThreatDetectionCustomModuleMethod)
        == null) {
      synchronized (SecurityCenterManagementGrpc.class) {
        if ((getValidateEventThreatDetectionCustomModuleMethod =
                SecurityCenterManagementGrpc.getValidateEventThreatDetectionCustomModuleMethod)
            == null) {
          SecurityCenterManagementGrpc.getValidateEventThreatDetectionCustomModuleMethod =
              getValidateEventThreatDetectionCustomModuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycentermanagement.v1
                              .ValidateEventThreatDetectionCustomModuleRequest,
                          com.google.cloud.securitycentermanagement.v1
                              .ValidateEventThreatDetectionCustomModuleResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "ValidateEventThreatDetectionCustomModule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .ValidateEventThreatDetectionCustomModuleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycentermanagement.v1
                                  .ValidateEventThreatDetectionCustomModuleResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterManagementMethodDescriptorSupplier(
                              "ValidateEventThreatDetectionCustomModule"))
                      .build();
        }
      }
    }
    return getValidateEventThreatDetectionCustomModuleMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SecurityCenterManagementStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecurityCenterManagementStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SecurityCenterManagementStub>() {
          @java.lang.Override
          public SecurityCenterManagementStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SecurityCenterManagementStub(channel, callOptions);
          }
        };
    return SecurityCenterManagementStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SecurityCenterManagementBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecurityCenterManagementBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SecurityCenterManagementBlockingStub>() {
          @java.lang.Override
          public SecurityCenterManagementBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SecurityCenterManagementBlockingStub(channel, callOptions);
          }
        };
    return SecurityCenterManagementBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SecurityCenterManagementFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecurityCenterManagementFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SecurityCenterManagementFutureStub>() {
          @java.lang.Override
          public SecurityCenterManagementFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SecurityCenterManagementFutureStub(channel, callOptions);
          }
        };
    return SecurityCenterManagementFutureStub.newStub(factory, channel);
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
     * Returns a list of all EffectiveSecurityHealthAnalyticsCustomModules for the
     * given parent. This includes resident modules defined at the scope of the
     * parent, and inherited modules, inherited from CRM ancestors (no
     * descendants).
     * </pre>
     */
    default void listEffectiveSecurityHealthAnalyticsCustomModules(
        com.google.cloud.securitycentermanagement.v1
                .ListEffectiveSecurityHealthAnalyticsCustomModulesRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycentermanagement.v1
                    .ListEffectiveSecurityHealthAnalyticsCustomModulesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEffectiveSecurityHealthAnalyticsCustomModulesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single EffectiveSecurityHealthAnalyticsCustomModule.
     * </pre>
     */
    default void getEffectiveSecurityHealthAnalyticsCustomModule(
        com.google.cloud.securitycentermanagement.v1
                .GetEffectiveSecurityHealthAnalyticsCustomModuleRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycentermanagement.v1
                    .EffectiveSecurityHealthAnalyticsCustomModule>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEffectiveSecurityHealthAnalyticsCustomModuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of all SecurityHealthAnalyticsCustomModules for the given
     * parent. This includes resident modules defined at the scope of the parent,
     * and inherited modules, inherited from CRM ancestors (no descendants).
     * </pre>
     */
    default void listSecurityHealthAnalyticsCustomModules(
        com.google.cloud.securitycentermanagement.v1.ListSecurityHealthAnalyticsCustomModulesRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycentermanagement.v1
                    .ListSecurityHealthAnalyticsCustomModulesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSecurityHealthAnalyticsCustomModulesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of all resident SecurityHealthAnalyticsCustomModules under
     * the given CRM parent and all of the parent's CRM descendants.
     * </pre>
     */
    default void listDescendantSecurityHealthAnalyticsCustomModules(
        com.google.cloud.securitycentermanagement.v1
                .ListDescendantSecurityHealthAnalyticsCustomModulesRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycentermanagement.v1
                    .ListDescendantSecurityHealthAnalyticsCustomModulesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDescendantSecurityHealthAnalyticsCustomModulesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a SecurityHealthAnalyticsCustomModule.
     * </pre>
     */
    default void getSecurityHealthAnalyticsCustomModule(
        com.google.cloud.securitycentermanagement.v1.GetSecurityHealthAnalyticsCustomModuleRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycentermanagement.v1.SecurityHealthAnalyticsCustomModule>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSecurityHealthAnalyticsCustomModuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a resident SecurityHealthAnalyticsCustomModule at the scope of the
     * given CRM parent, and also creates inherited
     * SecurityHealthAnalyticsCustomModules for all CRM descendants of the given
     * parent. These modules are enabled by default.
     * </pre>
     */
    default void createSecurityHealthAnalyticsCustomModule(
        com.google.cloud.securitycentermanagement.v1
                .CreateSecurityHealthAnalyticsCustomModuleRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycentermanagement.v1.SecurityHealthAnalyticsCustomModule>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSecurityHealthAnalyticsCustomModuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the SecurityHealthAnalyticsCustomModule under the given name based
     * on the given update mask. Updating the enablement state is supported on
     * both resident and inherited modules (though resident modules cannot have an
     * enablement state of "inherited"). Updating the display name and custom
     * config of a module is supported on resident modules only.
     * </pre>
     */
    default void updateSecurityHealthAnalyticsCustomModule(
        com.google.cloud.securitycentermanagement.v1
                .UpdateSecurityHealthAnalyticsCustomModuleRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycentermanagement.v1.SecurityHealthAnalyticsCustomModule>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSecurityHealthAnalyticsCustomModuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified SecurityHealthAnalyticsCustomModule and all of its
     * descendants in the CRM hierarchy. This method is only supported for
     * resident custom modules.
     * </pre>
     */
    default void deleteSecurityHealthAnalyticsCustomModule(
        com.google.cloud.securitycentermanagement.v1
                .DeleteSecurityHealthAnalyticsCustomModuleRequest
            request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSecurityHealthAnalyticsCustomModuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Simulates a given SecurityHealthAnalyticsCustomModule and Resource.
     * </pre>
     */
    default void simulateSecurityHealthAnalyticsCustomModule(
        com.google.cloud.securitycentermanagement.v1
                .SimulateSecurityHealthAnalyticsCustomModuleRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycentermanagement.v1
                    .SimulateSecurityHealthAnalyticsCustomModuleResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSimulateSecurityHealthAnalyticsCustomModuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all effective Event Threat Detection custom modules for the
     * given parent. This includes resident modules defined at the scope of the
     * parent along with modules inherited from its ancestors.
     * </pre>
     */
    default void listEffectiveEventThreatDetectionCustomModules(
        com.google.cloud.securitycentermanagement.v1
                .ListEffectiveEventThreatDetectionCustomModulesRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycentermanagement.v1
                    .ListEffectiveEventThreatDetectionCustomModulesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEffectiveEventThreatDetectionCustomModulesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an effective ETD custom module. Retrieves the effective module at the
     * given level. The difference between an EffectiveCustomModule and a
     * CustomModule is that the fields for an EffectiveCustomModule are computed
     * from ancestors if needed. For example, the enablement_state for a
     * CustomModule can be either ENABLED, DISABLED, or INHERITED. Where as the
     * enablement_state for an EffectiveCustomModule is always computed to ENABLED
     * or DISABLED (the effective enablement_state).
     * </pre>
     */
    default void getEffectiveEventThreatDetectionCustomModule(
        com.google.cloud.securitycentermanagement.v1
                .GetEffectiveEventThreatDetectionCustomModuleRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycentermanagement.v1
                    .EffectiveEventThreatDetectionCustomModule>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEffectiveEventThreatDetectionCustomModuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all Event Threat Detection custom modules for the given
     * Resource Manager parent. This includes resident modules defined at the
     * scope of the parent along with modules inherited from ancestors.
     * </pre>
     */
    default void listEventThreatDetectionCustomModules(
        com.google.cloud.securitycentermanagement.v1.ListEventThreatDetectionCustomModulesRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycentermanagement.v1
                    .ListEventThreatDetectionCustomModulesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEventThreatDetectionCustomModulesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all resident Event Threat Detection custom modules under the
     * given Resource Manager parent and its descendants.
     * </pre>
     */
    default void listDescendantEventThreatDetectionCustomModules(
        com.google.cloud.securitycentermanagement.v1
                .ListDescendantEventThreatDetectionCustomModulesRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycentermanagement.v1
                    .ListDescendantEventThreatDetectionCustomModulesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDescendantEventThreatDetectionCustomModulesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an Event Threat Detection custom module.
     * </pre>
     */
    default void getEventThreatDetectionCustomModule(
        com.google.cloud.securitycentermanagement.v1.GetEventThreatDetectionCustomModuleRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycentermanagement.v1.EventThreatDetectionCustomModule>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEventThreatDetectionCustomModuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a resident Event Threat Detection custom module at the scope of the
     * given Resource Manager parent, and also creates inherited custom modules
     * for all descendants of the given parent. These modules are enabled by
     * default.
     * </pre>
     */
    default void createEventThreatDetectionCustomModule(
        com.google.cloud.securitycentermanagement.v1.CreateEventThreatDetectionCustomModuleRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycentermanagement.v1.EventThreatDetectionCustomModule>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateEventThreatDetectionCustomModuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the Event Threat Detection custom module with the given name based
     * on the given update mask. Updating the enablement state is supported for
     * both resident and inherited modules (though resident modules cannot have an
     * enablement state of "inherited"). Updating the display name or
     * configuration of a module is supported for resident modules only. The type
     * of a module cannot be changed.
     * </pre>
     */
    default void updateEventThreatDetectionCustomModule(
        com.google.cloud.securitycentermanagement.v1.UpdateEventThreatDetectionCustomModuleRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycentermanagement.v1.EventThreatDetectionCustomModule>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateEventThreatDetectionCustomModuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified Event Threat Detection custom module and all of its
     * descendants in the Resource Manager hierarchy. This method is only
     * supported for resident custom modules.
     * </pre>
     */
    default void deleteEventThreatDetectionCustomModule(
        com.google.cloud.securitycentermanagement.v1.DeleteEventThreatDetectionCustomModuleRequest
            request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteEventThreatDetectionCustomModuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Validates the given Event Threat Detection custom module.
     * </pre>
     */
    default void validateEventThreatDetectionCustomModule(
        com.google.cloud.securitycentermanagement.v1.ValidateEventThreatDetectionCustomModuleRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycentermanagement.v1
                    .ValidateEventThreatDetectionCustomModuleResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getValidateEventThreatDetectionCustomModuleMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SecurityCenterManagement.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public abstract static class SecurityCenterManagementImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SecurityCenterManagementGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SecurityCenterManagement.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class SecurityCenterManagementStub
      extends io.grpc.stub.AbstractAsyncStub<SecurityCenterManagementStub> {
    private SecurityCenterManagementStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecurityCenterManagementStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecurityCenterManagementStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of all EffectiveSecurityHealthAnalyticsCustomModules for the
     * given parent. This includes resident modules defined at the scope of the
     * parent, and inherited modules, inherited from CRM ancestors (no
     * descendants).
     * </pre>
     */
    public void listEffectiveSecurityHealthAnalyticsCustomModules(
        com.google.cloud.securitycentermanagement.v1
                .ListEffectiveSecurityHealthAnalyticsCustomModulesRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycentermanagement.v1
                    .ListEffectiveSecurityHealthAnalyticsCustomModulesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(
                  getListEffectiveSecurityHealthAnalyticsCustomModulesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single EffectiveSecurityHealthAnalyticsCustomModule.
     * </pre>
     */
    public void getEffectiveSecurityHealthAnalyticsCustomModule(
        com.google.cloud.securitycentermanagement.v1
                .GetEffectiveSecurityHealthAnalyticsCustomModuleRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycentermanagement.v1
                    .EffectiveSecurityHealthAnalyticsCustomModule>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(
                  getGetEffectiveSecurityHealthAnalyticsCustomModuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of all SecurityHealthAnalyticsCustomModules for the given
     * parent. This includes resident modules defined at the scope of the parent,
     * and inherited modules, inherited from CRM ancestors (no descendants).
     * </pre>
     */
    public void listSecurityHealthAnalyticsCustomModules(
        com.google.cloud.securitycentermanagement.v1.ListSecurityHealthAnalyticsCustomModulesRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycentermanagement.v1
                    .ListSecurityHealthAnalyticsCustomModulesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(getListSecurityHealthAnalyticsCustomModulesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of all resident SecurityHealthAnalyticsCustomModules under
     * the given CRM parent and all of the parent's CRM descendants.
     * </pre>
     */
    public void listDescendantSecurityHealthAnalyticsCustomModules(
        com.google.cloud.securitycentermanagement.v1
                .ListDescendantSecurityHealthAnalyticsCustomModulesRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycentermanagement.v1
                    .ListDescendantSecurityHealthAnalyticsCustomModulesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(
                  getListDescendantSecurityHealthAnalyticsCustomModulesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a SecurityHealthAnalyticsCustomModule.
     * </pre>
     */
    public void getSecurityHealthAnalyticsCustomModule(
        com.google.cloud.securitycentermanagement.v1.GetSecurityHealthAnalyticsCustomModuleRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycentermanagement.v1.SecurityHealthAnalyticsCustomModule>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSecurityHealthAnalyticsCustomModuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a resident SecurityHealthAnalyticsCustomModule at the scope of the
     * given CRM parent, and also creates inherited
     * SecurityHealthAnalyticsCustomModules for all CRM descendants of the given
     * parent. These modules are enabled by default.
     * </pre>
     */
    public void createSecurityHealthAnalyticsCustomModule(
        com.google.cloud.securitycentermanagement.v1
                .CreateSecurityHealthAnalyticsCustomModuleRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycentermanagement.v1.SecurityHealthAnalyticsCustomModule>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(getCreateSecurityHealthAnalyticsCustomModuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the SecurityHealthAnalyticsCustomModule under the given name based
     * on the given update mask. Updating the enablement state is supported on
     * both resident and inherited modules (though resident modules cannot have an
     * enablement state of "inherited"). Updating the display name and custom
     * config of a module is supported on resident modules only.
     * </pre>
     */
    public void updateSecurityHealthAnalyticsCustomModule(
        com.google.cloud.securitycentermanagement.v1
                .UpdateSecurityHealthAnalyticsCustomModuleRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycentermanagement.v1.SecurityHealthAnalyticsCustomModule>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(getUpdateSecurityHealthAnalyticsCustomModuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified SecurityHealthAnalyticsCustomModule and all of its
     * descendants in the CRM hierarchy. This method is only supported for
     * resident custom modules.
     * </pre>
     */
    public void deleteSecurityHealthAnalyticsCustomModule(
        com.google.cloud.securitycentermanagement.v1
                .DeleteSecurityHealthAnalyticsCustomModuleRequest
            request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(getDeleteSecurityHealthAnalyticsCustomModuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Simulates a given SecurityHealthAnalyticsCustomModule and Resource.
     * </pre>
     */
    public void simulateSecurityHealthAnalyticsCustomModule(
        com.google.cloud.securitycentermanagement.v1
                .SimulateSecurityHealthAnalyticsCustomModuleRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycentermanagement.v1
                    .SimulateSecurityHealthAnalyticsCustomModuleResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(getSimulateSecurityHealthAnalyticsCustomModuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all effective Event Threat Detection custom modules for the
     * given parent. This includes resident modules defined at the scope of the
     * parent along with modules inherited from its ancestors.
     * </pre>
     */
    public void listEffectiveEventThreatDetectionCustomModules(
        com.google.cloud.securitycentermanagement.v1
                .ListEffectiveEventThreatDetectionCustomModulesRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycentermanagement.v1
                    .ListEffectiveEventThreatDetectionCustomModulesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(getListEffectiveEventThreatDetectionCustomModulesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an effective ETD custom module. Retrieves the effective module at the
     * given level. The difference between an EffectiveCustomModule and a
     * CustomModule is that the fields for an EffectiveCustomModule are computed
     * from ancestors if needed. For example, the enablement_state for a
     * CustomModule can be either ENABLED, DISABLED, or INHERITED. Where as the
     * enablement_state for an EffectiveCustomModule is always computed to ENABLED
     * or DISABLED (the effective enablement_state).
     * </pre>
     */
    public void getEffectiveEventThreatDetectionCustomModule(
        com.google.cloud.securitycentermanagement.v1
                .GetEffectiveEventThreatDetectionCustomModuleRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycentermanagement.v1
                    .EffectiveEventThreatDetectionCustomModule>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(getGetEffectiveEventThreatDetectionCustomModuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all Event Threat Detection custom modules for the given
     * Resource Manager parent. This includes resident modules defined at the
     * scope of the parent along with modules inherited from ancestors.
     * </pre>
     */
    public void listEventThreatDetectionCustomModules(
        com.google.cloud.securitycentermanagement.v1.ListEventThreatDetectionCustomModulesRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycentermanagement.v1
                    .ListEventThreatDetectionCustomModulesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEventThreatDetectionCustomModulesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all resident Event Threat Detection custom modules under the
     * given Resource Manager parent and its descendants.
     * </pre>
     */
    public void listDescendantEventThreatDetectionCustomModules(
        com.google.cloud.securitycentermanagement.v1
                .ListDescendantEventThreatDetectionCustomModulesRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycentermanagement.v1
                    .ListDescendantEventThreatDetectionCustomModulesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(
                  getListDescendantEventThreatDetectionCustomModulesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an Event Threat Detection custom module.
     * </pre>
     */
    public void getEventThreatDetectionCustomModule(
        com.google.cloud.securitycentermanagement.v1.GetEventThreatDetectionCustomModuleRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycentermanagement.v1.EventThreatDetectionCustomModule>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEventThreatDetectionCustomModuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a resident Event Threat Detection custom module at the scope of the
     * given Resource Manager parent, and also creates inherited custom modules
     * for all descendants of the given parent. These modules are enabled by
     * default.
     * </pre>
     */
    public void createEventThreatDetectionCustomModule(
        com.google.cloud.securitycentermanagement.v1.CreateEventThreatDetectionCustomModuleRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycentermanagement.v1.EventThreatDetectionCustomModule>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEventThreatDetectionCustomModuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the Event Threat Detection custom module with the given name based
     * on the given update mask. Updating the enablement state is supported for
     * both resident and inherited modules (though resident modules cannot have an
     * enablement state of "inherited"). Updating the display name or
     * configuration of a module is supported for resident modules only. The type
     * of a module cannot be changed.
     * </pre>
     */
    public void updateEventThreatDetectionCustomModule(
        com.google.cloud.securitycentermanagement.v1.UpdateEventThreatDetectionCustomModuleRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycentermanagement.v1.EventThreatDetectionCustomModule>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEventThreatDetectionCustomModuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified Event Threat Detection custom module and all of its
     * descendants in the Resource Manager hierarchy. This method is only
     * supported for resident custom modules.
     * </pre>
     */
    public void deleteEventThreatDetectionCustomModule(
        com.google.cloud.securitycentermanagement.v1.DeleteEventThreatDetectionCustomModuleRequest
            request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEventThreatDetectionCustomModuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Validates the given Event Threat Detection custom module.
     * </pre>
     */
    public void validateEventThreatDetectionCustomModule(
        com.google.cloud.securitycentermanagement.v1.ValidateEventThreatDetectionCustomModuleRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycentermanagement.v1
                    .ValidateEventThreatDetectionCustomModuleResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(getValidateEventThreatDetectionCustomModuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SecurityCenterManagement.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class SecurityCenterManagementBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SecurityCenterManagementBlockingStub> {
    private SecurityCenterManagementBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecurityCenterManagementBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecurityCenterManagementBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of all EffectiveSecurityHealthAnalyticsCustomModules for the
     * given parent. This includes resident modules defined at the scope of the
     * parent, and inherited modules, inherited from CRM ancestors (no
     * descendants).
     * </pre>
     */
    public com.google.cloud.securitycentermanagement.v1
            .ListEffectiveSecurityHealthAnalyticsCustomModulesResponse
        listEffectiveSecurityHealthAnalyticsCustomModules(
            com.google.cloud.securitycentermanagement.v1
                    .ListEffectiveSecurityHealthAnalyticsCustomModulesRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getListEffectiveSecurityHealthAnalyticsCustomModulesMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single EffectiveSecurityHealthAnalyticsCustomModule.
     * </pre>
     */
    public com.google.cloud.securitycentermanagement.v1.EffectiveSecurityHealthAnalyticsCustomModule
        getEffectiveSecurityHealthAnalyticsCustomModule(
            com.google.cloud.securitycentermanagement.v1
                    .GetEffectiveSecurityHealthAnalyticsCustomModuleRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getGetEffectiveSecurityHealthAnalyticsCustomModuleMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of all SecurityHealthAnalyticsCustomModules for the given
     * parent. This includes resident modules defined at the scope of the parent,
     * and inherited modules, inherited from CRM ancestors (no descendants).
     * </pre>
     */
    public com.google.cloud.securitycentermanagement.v1
            .ListSecurityHealthAnalyticsCustomModulesResponse
        listSecurityHealthAnalyticsCustomModules(
            com.google.cloud.securitycentermanagement.v1
                    .ListSecurityHealthAnalyticsCustomModulesRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getListSecurityHealthAnalyticsCustomModulesMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of all resident SecurityHealthAnalyticsCustomModules under
     * the given CRM parent and all of the parent's CRM descendants.
     * </pre>
     */
    public com.google.cloud.securitycentermanagement.v1
            .ListDescendantSecurityHealthAnalyticsCustomModulesResponse
        listDescendantSecurityHealthAnalyticsCustomModules(
            com.google.cloud.securitycentermanagement.v1
                    .ListDescendantSecurityHealthAnalyticsCustomModulesRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getListDescendantSecurityHealthAnalyticsCustomModulesMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a SecurityHealthAnalyticsCustomModule.
     * </pre>
     */
    public com.google.cloud.securitycentermanagement.v1.SecurityHealthAnalyticsCustomModule
        getSecurityHealthAnalyticsCustomModule(
            com.google.cloud.securitycentermanagement.v1
                    .GetSecurityHealthAnalyticsCustomModuleRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getGetSecurityHealthAnalyticsCustomModuleMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Creates a resident SecurityHealthAnalyticsCustomModule at the scope of the
     * given CRM parent, and also creates inherited
     * SecurityHealthAnalyticsCustomModules for all CRM descendants of the given
     * parent. These modules are enabled by default.
     * </pre>
     */
    public com.google.cloud.securitycentermanagement.v1.SecurityHealthAnalyticsCustomModule
        createSecurityHealthAnalyticsCustomModule(
            com.google.cloud.securitycentermanagement.v1
                    .CreateSecurityHealthAnalyticsCustomModuleRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getCreateSecurityHealthAnalyticsCustomModuleMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Updates the SecurityHealthAnalyticsCustomModule under the given name based
     * on the given update mask. Updating the enablement state is supported on
     * both resident and inherited modules (though resident modules cannot have an
     * enablement state of "inherited"). Updating the display name and custom
     * config of a module is supported on resident modules only.
     * </pre>
     */
    public com.google.cloud.securitycentermanagement.v1.SecurityHealthAnalyticsCustomModule
        updateSecurityHealthAnalyticsCustomModule(
            com.google.cloud.securitycentermanagement.v1
                    .UpdateSecurityHealthAnalyticsCustomModuleRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getUpdateSecurityHealthAnalyticsCustomModuleMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified SecurityHealthAnalyticsCustomModule and all of its
     * descendants in the CRM hierarchy. This method is only supported for
     * resident custom modules.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSecurityHealthAnalyticsCustomModule(
        com.google.cloud.securitycentermanagement.v1
                .DeleteSecurityHealthAnalyticsCustomModuleRequest
            request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getDeleteSecurityHealthAnalyticsCustomModuleMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Simulates a given SecurityHealthAnalyticsCustomModule and Resource.
     * </pre>
     */
    public com.google.cloud.securitycentermanagement.v1
            .SimulateSecurityHealthAnalyticsCustomModuleResponse
        simulateSecurityHealthAnalyticsCustomModule(
            com.google.cloud.securitycentermanagement.v1
                    .SimulateSecurityHealthAnalyticsCustomModuleRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getSimulateSecurityHealthAnalyticsCustomModuleMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists all effective Event Threat Detection custom modules for the
     * given parent. This includes resident modules defined at the scope of the
     * parent along with modules inherited from its ancestors.
     * </pre>
     */
    public com.google.cloud.securitycentermanagement.v1
            .ListEffectiveEventThreatDetectionCustomModulesResponse
        listEffectiveEventThreatDetectionCustomModules(
            com.google.cloud.securitycentermanagement.v1
                    .ListEffectiveEventThreatDetectionCustomModulesRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getListEffectiveEventThreatDetectionCustomModulesMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets an effective ETD custom module. Retrieves the effective module at the
     * given level. The difference between an EffectiveCustomModule and a
     * CustomModule is that the fields for an EffectiveCustomModule are computed
     * from ancestors if needed. For example, the enablement_state for a
     * CustomModule can be either ENABLED, DISABLED, or INHERITED. Where as the
     * enablement_state for an EffectiveCustomModule is always computed to ENABLED
     * or DISABLED (the effective enablement_state).
     * </pre>
     */
    public com.google.cloud.securitycentermanagement.v1.EffectiveEventThreatDetectionCustomModule
        getEffectiveEventThreatDetectionCustomModule(
            com.google.cloud.securitycentermanagement.v1
                    .GetEffectiveEventThreatDetectionCustomModuleRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getGetEffectiveEventThreatDetectionCustomModuleMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists all Event Threat Detection custom modules for the given
     * Resource Manager parent. This includes resident modules defined at the
     * scope of the parent along with modules inherited from ancestors.
     * </pre>
     */
    public com.google.cloud.securitycentermanagement.v1
            .ListEventThreatDetectionCustomModulesResponse
        listEventThreatDetectionCustomModules(
            com.google.cloud.securitycentermanagement.v1
                    .ListEventThreatDetectionCustomModulesRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getListEventThreatDetectionCustomModulesMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists all resident Event Threat Detection custom modules under the
     * given Resource Manager parent and its descendants.
     * </pre>
     */
    public com.google.cloud.securitycentermanagement.v1
            .ListDescendantEventThreatDetectionCustomModulesResponse
        listDescendantEventThreatDetectionCustomModules(
            com.google.cloud.securitycentermanagement.v1
                    .ListDescendantEventThreatDetectionCustomModulesRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getListDescendantEventThreatDetectionCustomModulesMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets an Event Threat Detection custom module.
     * </pre>
     */
    public com.google.cloud.securitycentermanagement.v1.EventThreatDetectionCustomModule
        getEventThreatDetectionCustomModule(
            com.google.cloud.securitycentermanagement.v1.GetEventThreatDetectionCustomModuleRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEventThreatDetectionCustomModuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a resident Event Threat Detection custom module at the scope of the
     * given Resource Manager parent, and also creates inherited custom modules
     * for all descendants of the given parent. These modules are enabled by
     * default.
     * </pre>
     */
    public com.google.cloud.securitycentermanagement.v1.EventThreatDetectionCustomModule
        createEventThreatDetectionCustomModule(
            com.google.cloud.securitycentermanagement.v1
                    .CreateEventThreatDetectionCustomModuleRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getCreateEventThreatDetectionCustomModuleMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Updates the Event Threat Detection custom module with the given name based
     * on the given update mask. Updating the enablement state is supported for
     * both resident and inherited modules (though resident modules cannot have an
     * enablement state of "inherited"). Updating the display name or
     * configuration of a module is supported for resident modules only. The type
     * of a module cannot be changed.
     * </pre>
     */
    public com.google.cloud.securitycentermanagement.v1.EventThreatDetectionCustomModule
        updateEventThreatDetectionCustomModule(
            com.google.cloud.securitycentermanagement.v1
                    .UpdateEventThreatDetectionCustomModuleRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getUpdateEventThreatDetectionCustomModuleMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified Event Threat Detection custom module and all of its
     * descendants in the Resource Manager hierarchy. This method is only
     * supported for resident custom modules.
     * </pre>
     */
    public com.google.protobuf.Empty deleteEventThreatDetectionCustomModule(
        com.google.cloud.securitycentermanagement.v1.DeleteEventThreatDetectionCustomModuleRequest
            request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getDeleteEventThreatDetectionCustomModuleMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Validates the given Event Threat Detection custom module.
     * </pre>
     */
    public com.google.cloud.securitycentermanagement.v1
            .ValidateEventThreatDetectionCustomModuleResponse
        validateEventThreatDetectionCustomModule(
            com.google.cloud.securitycentermanagement.v1
                    .ValidateEventThreatDetectionCustomModuleRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getValidateEventThreatDetectionCustomModuleMethod(),
          getCallOptions(),
          request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * SecurityCenterManagement.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class SecurityCenterManagementFutureStub
      extends io.grpc.stub.AbstractFutureStub<SecurityCenterManagementFutureStub> {
    private SecurityCenterManagementFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecurityCenterManagementFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecurityCenterManagementFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of all EffectiveSecurityHealthAnalyticsCustomModules for the
     * given parent. This includes resident modules defined at the scope of the
     * parent, and inherited modules, inherited from CRM ancestors (no
     * descendants).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycentermanagement.v1
                .ListEffectiveSecurityHealthAnalyticsCustomModulesResponse>
        listEffectiveSecurityHealthAnalyticsCustomModules(
            com.google.cloud.securitycentermanagement.v1
                    .ListEffectiveSecurityHealthAnalyticsCustomModulesRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(
                  getListEffectiveSecurityHealthAnalyticsCustomModulesMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single EffectiveSecurityHealthAnalyticsCustomModule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycentermanagement.v1
                .EffectiveSecurityHealthAnalyticsCustomModule>
        getEffectiveSecurityHealthAnalyticsCustomModule(
            com.google.cloud.securitycentermanagement.v1
                    .GetEffectiveSecurityHealthAnalyticsCustomModuleRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(
                  getGetEffectiveSecurityHealthAnalyticsCustomModuleMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of all SecurityHealthAnalyticsCustomModules for the given
     * parent. This includes resident modules defined at the scope of the parent,
     * and inherited modules, inherited from CRM ancestors (no descendants).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycentermanagement.v1
                .ListSecurityHealthAnalyticsCustomModulesResponse>
        listSecurityHealthAnalyticsCustomModules(
            com.google.cloud.securitycentermanagement.v1
                    .ListSecurityHealthAnalyticsCustomModulesRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getListSecurityHealthAnalyticsCustomModulesMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of all resident SecurityHealthAnalyticsCustomModules under
     * the given CRM parent and all of the parent's CRM descendants.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycentermanagement.v1
                .ListDescendantSecurityHealthAnalyticsCustomModulesResponse>
        listDescendantSecurityHealthAnalyticsCustomModules(
            com.google.cloud.securitycentermanagement.v1
                    .ListDescendantSecurityHealthAnalyticsCustomModulesRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(
                  getListDescendantSecurityHealthAnalyticsCustomModulesMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a SecurityHealthAnalyticsCustomModule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycentermanagement.v1.SecurityHealthAnalyticsCustomModule>
        getSecurityHealthAnalyticsCustomModule(
            com.google.cloud.securitycentermanagement.v1
                    .GetSecurityHealthAnalyticsCustomModuleRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSecurityHealthAnalyticsCustomModuleMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Creates a resident SecurityHealthAnalyticsCustomModule at the scope of the
     * given CRM parent, and also creates inherited
     * SecurityHealthAnalyticsCustomModules for all CRM descendants of the given
     * parent. These modules are enabled by default.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycentermanagement.v1.SecurityHealthAnalyticsCustomModule>
        createSecurityHealthAnalyticsCustomModule(
            com.google.cloud.securitycentermanagement.v1
                    .CreateSecurityHealthAnalyticsCustomModuleRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getCreateSecurityHealthAnalyticsCustomModuleMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Updates the SecurityHealthAnalyticsCustomModule under the given name based
     * on the given update mask. Updating the enablement state is supported on
     * both resident and inherited modules (though resident modules cannot have an
     * enablement state of "inherited"). Updating the display name and custom
     * config of a module is supported on resident modules only.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycentermanagement.v1.SecurityHealthAnalyticsCustomModule>
        updateSecurityHealthAnalyticsCustomModule(
            com.google.cloud.securitycentermanagement.v1
                    .UpdateSecurityHealthAnalyticsCustomModuleRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getUpdateSecurityHealthAnalyticsCustomModuleMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified SecurityHealthAnalyticsCustomModule and all of its
     * descendants in the CRM hierarchy. This method is only supported for
     * resident custom modules.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteSecurityHealthAnalyticsCustomModule(
            com.google.cloud.securitycentermanagement.v1
                    .DeleteSecurityHealthAnalyticsCustomModuleRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getDeleteSecurityHealthAnalyticsCustomModuleMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Simulates a given SecurityHealthAnalyticsCustomModule and Resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycentermanagement.v1
                .SimulateSecurityHealthAnalyticsCustomModuleResponse>
        simulateSecurityHealthAnalyticsCustomModule(
            com.google.cloud.securitycentermanagement.v1
                    .SimulateSecurityHealthAnalyticsCustomModuleRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getSimulateSecurityHealthAnalyticsCustomModuleMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists all effective Event Threat Detection custom modules for the
     * given parent. This includes resident modules defined at the scope of the
     * parent along with modules inherited from its ancestors.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycentermanagement.v1
                .ListEffectiveEventThreatDetectionCustomModulesResponse>
        listEffectiveEventThreatDetectionCustomModules(
            com.google.cloud.securitycentermanagement.v1
                    .ListEffectiveEventThreatDetectionCustomModulesRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getListEffectiveEventThreatDetectionCustomModulesMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets an effective ETD custom module. Retrieves the effective module at the
     * given level. The difference between an EffectiveCustomModule and a
     * CustomModule is that the fields for an EffectiveCustomModule are computed
     * from ancestors if needed. For example, the enablement_state for a
     * CustomModule can be either ENABLED, DISABLED, or INHERITED. Where as the
     * enablement_state for an EffectiveCustomModule is always computed to ENABLED
     * or DISABLED (the effective enablement_state).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycentermanagement.v1.EffectiveEventThreatDetectionCustomModule>
        getEffectiveEventThreatDetectionCustomModule(
            com.google.cloud.securitycentermanagement.v1
                    .GetEffectiveEventThreatDetectionCustomModuleRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getGetEffectiveEventThreatDetectionCustomModuleMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists all Event Threat Detection custom modules for the given
     * Resource Manager parent. This includes resident modules defined at the
     * scope of the parent along with modules inherited from ancestors.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycentermanagement.v1
                .ListEventThreatDetectionCustomModulesResponse>
        listEventThreatDetectionCustomModules(
            com.google.cloud.securitycentermanagement.v1
                    .ListEventThreatDetectionCustomModulesRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEventThreatDetectionCustomModulesMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists all resident Event Threat Detection custom modules under the
     * given Resource Manager parent and its descendants.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycentermanagement.v1
                .ListDescendantEventThreatDetectionCustomModulesResponse>
        listDescendantEventThreatDetectionCustomModules(
            com.google.cloud.securitycentermanagement.v1
                    .ListDescendantEventThreatDetectionCustomModulesRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(
                  getListDescendantEventThreatDetectionCustomModulesMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets an Event Threat Detection custom module.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycentermanagement.v1.EventThreatDetectionCustomModule>
        getEventThreatDetectionCustomModule(
            com.google.cloud.securitycentermanagement.v1.GetEventThreatDetectionCustomModuleRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEventThreatDetectionCustomModuleMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Creates a resident Event Threat Detection custom module at the scope of the
     * given Resource Manager parent, and also creates inherited custom modules
     * for all descendants of the given parent. These modules are enabled by
     * default.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycentermanagement.v1.EventThreatDetectionCustomModule>
        createEventThreatDetectionCustomModule(
            com.google.cloud.securitycentermanagement.v1
                    .CreateEventThreatDetectionCustomModuleRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEventThreatDetectionCustomModuleMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Updates the Event Threat Detection custom module with the given name based
     * on the given update mask. Updating the enablement state is supported for
     * both resident and inherited modules (though resident modules cannot have an
     * enablement state of "inherited"). Updating the display name or
     * configuration of a module is supported for resident modules only. The type
     * of a module cannot be changed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycentermanagement.v1.EventThreatDetectionCustomModule>
        updateEventThreatDetectionCustomModule(
            com.google.cloud.securitycentermanagement.v1
                    .UpdateEventThreatDetectionCustomModuleRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEventThreatDetectionCustomModuleMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified Event Threat Detection custom module and all of its
     * descendants in the Resource Manager hierarchy. This method is only
     * supported for resident custom modules.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteEventThreatDetectionCustomModule(
            com.google.cloud.securitycentermanagement.v1
                    .DeleteEventThreatDetectionCustomModuleRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEventThreatDetectionCustomModuleMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Validates the given Event Threat Detection custom module.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycentermanagement.v1
                .ValidateEventThreatDetectionCustomModuleResponse>
        validateEventThreatDetectionCustomModule(
            com.google.cloud.securitycentermanagement.v1
                    .ValidateEventThreatDetectionCustomModuleRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getValidateEventThreatDetectionCustomModuleMethod(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_LIST_EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULES = 0;
  private static final int METHODID_GET_EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE = 1;
  private static final int METHODID_LIST_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULES = 2;
  private static final int METHODID_LIST_DESCENDANT_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULES = 3;
  private static final int METHODID_GET_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE = 4;
  private static final int METHODID_CREATE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE = 5;
  private static final int METHODID_UPDATE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE = 6;
  private static final int METHODID_DELETE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE = 7;
  private static final int METHODID_SIMULATE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE = 8;
  private static final int METHODID_LIST_EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULES = 9;
  private static final int METHODID_GET_EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULE = 10;
  private static final int METHODID_LIST_EVENT_THREAT_DETECTION_CUSTOM_MODULES = 11;
  private static final int METHODID_LIST_DESCENDANT_EVENT_THREAT_DETECTION_CUSTOM_MODULES = 12;
  private static final int METHODID_GET_EVENT_THREAT_DETECTION_CUSTOM_MODULE = 13;
  private static final int METHODID_CREATE_EVENT_THREAT_DETECTION_CUSTOM_MODULE = 14;
  private static final int METHODID_UPDATE_EVENT_THREAT_DETECTION_CUSTOM_MODULE = 15;
  private static final int METHODID_DELETE_EVENT_THREAT_DETECTION_CUSTOM_MODULE = 16;
  private static final int METHODID_VALIDATE_EVENT_THREAT_DETECTION_CUSTOM_MODULE = 17;

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
        case METHODID_LIST_EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULES:
          serviceImpl.listEffectiveSecurityHealthAnalyticsCustomModules(
              (com.google.cloud.securitycentermanagement.v1
                      .ListEffectiveSecurityHealthAnalyticsCustomModulesRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycentermanagement.v1
                          .ListEffectiveSecurityHealthAnalyticsCustomModulesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE:
          serviceImpl.getEffectiveSecurityHealthAnalyticsCustomModule(
              (com.google.cloud.securitycentermanagement.v1
                      .GetEffectiveSecurityHealthAnalyticsCustomModuleRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycentermanagement.v1
                          .EffectiveSecurityHealthAnalyticsCustomModule>)
                  responseObserver);
          break;
        case METHODID_LIST_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULES:
          serviceImpl.listSecurityHealthAnalyticsCustomModules(
              (com.google.cloud.securitycentermanagement.v1
                      .ListSecurityHealthAnalyticsCustomModulesRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycentermanagement.v1
                          .ListSecurityHealthAnalyticsCustomModulesResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_DESCENDANT_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULES:
          serviceImpl.listDescendantSecurityHealthAnalyticsCustomModules(
              (com.google.cloud.securitycentermanagement.v1
                      .ListDescendantSecurityHealthAnalyticsCustomModulesRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycentermanagement.v1
                          .ListDescendantSecurityHealthAnalyticsCustomModulesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE:
          serviceImpl.getSecurityHealthAnalyticsCustomModule(
              (com.google.cloud.securitycentermanagement.v1
                      .GetSecurityHealthAnalyticsCustomModuleRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycentermanagement.v1
                          .SecurityHealthAnalyticsCustomModule>)
                  responseObserver);
          break;
        case METHODID_CREATE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE:
          serviceImpl.createSecurityHealthAnalyticsCustomModule(
              (com.google.cloud.securitycentermanagement.v1
                      .CreateSecurityHealthAnalyticsCustomModuleRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycentermanagement.v1
                          .SecurityHealthAnalyticsCustomModule>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE:
          serviceImpl.updateSecurityHealthAnalyticsCustomModule(
              (com.google.cloud.securitycentermanagement.v1
                      .UpdateSecurityHealthAnalyticsCustomModuleRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycentermanagement.v1
                          .SecurityHealthAnalyticsCustomModule>)
                  responseObserver);
          break;
        case METHODID_DELETE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE:
          serviceImpl.deleteSecurityHealthAnalyticsCustomModule(
              (com.google.cloud.securitycentermanagement.v1
                      .DeleteSecurityHealthAnalyticsCustomModuleRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_SIMULATE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE:
          serviceImpl.simulateSecurityHealthAnalyticsCustomModule(
              (com.google.cloud.securitycentermanagement.v1
                      .SimulateSecurityHealthAnalyticsCustomModuleRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycentermanagement.v1
                          .SimulateSecurityHealthAnalyticsCustomModuleResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULES:
          serviceImpl.listEffectiveEventThreatDetectionCustomModules(
              (com.google.cloud.securitycentermanagement.v1
                      .ListEffectiveEventThreatDetectionCustomModulesRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycentermanagement.v1
                          .ListEffectiveEventThreatDetectionCustomModulesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULE:
          serviceImpl.getEffectiveEventThreatDetectionCustomModule(
              (com.google.cloud.securitycentermanagement.v1
                      .GetEffectiveEventThreatDetectionCustomModuleRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycentermanagement.v1
                          .EffectiveEventThreatDetectionCustomModule>)
                  responseObserver);
          break;
        case METHODID_LIST_EVENT_THREAT_DETECTION_CUSTOM_MODULES:
          serviceImpl.listEventThreatDetectionCustomModules(
              (com.google.cloud.securitycentermanagement.v1
                      .ListEventThreatDetectionCustomModulesRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycentermanagement.v1
                          .ListEventThreatDetectionCustomModulesResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_DESCENDANT_EVENT_THREAT_DETECTION_CUSTOM_MODULES:
          serviceImpl.listDescendantEventThreatDetectionCustomModules(
              (com.google.cloud.securitycentermanagement.v1
                      .ListDescendantEventThreatDetectionCustomModulesRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycentermanagement.v1
                          .ListDescendantEventThreatDetectionCustomModulesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_EVENT_THREAT_DETECTION_CUSTOM_MODULE:
          serviceImpl.getEventThreatDetectionCustomModule(
              (com.google.cloud.securitycentermanagement.v1
                      .GetEventThreatDetectionCustomModuleRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycentermanagement.v1
                          .EventThreatDetectionCustomModule>)
                  responseObserver);
          break;
        case METHODID_CREATE_EVENT_THREAT_DETECTION_CUSTOM_MODULE:
          serviceImpl.createEventThreatDetectionCustomModule(
              (com.google.cloud.securitycentermanagement.v1
                      .CreateEventThreatDetectionCustomModuleRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycentermanagement.v1
                          .EventThreatDetectionCustomModule>)
                  responseObserver);
          break;
        case METHODID_UPDATE_EVENT_THREAT_DETECTION_CUSTOM_MODULE:
          serviceImpl.updateEventThreatDetectionCustomModule(
              (com.google.cloud.securitycentermanagement.v1
                      .UpdateEventThreatDetectionCustomModuleRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycentermanagement.v1
                          .EventThreatDetectionCustomModule>)
                  responseObserver);
          break;
        case METHODID_DELETE_EVENT_THREAT_DETECTION_CUSTOM_MODULE:
          serviceImpl.deleteEventThreatDetectionCustomModule(
              (com.google.cloud.securitycentermanagement.v1
                      .DeleteEventThreatDetectionCustomModuleRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_VALIDATE_EVENT_THREAT_DETECTION_CUSTOM_MODULE:
          serviceImpl.validateEventThreatDetectionCustomModule(
              (com.google.cloud.securitycentermanagement.v1
                      .ValidateEventThreatDetectionCustomModuleRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycentermanagement.v1
                          .ValidateEventThreatDetectionCustomModuleResponse>)
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
            getListEffectiveSecurityHealthAnalyticsCustomModulesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycentermanagement.v1
                        .ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
                    com.google.cloud.securitycentermanagement.v1
                        .ListEffectiveSecurityHealthAnalyticsCustomModulesResponse>(
                    service, METHODID_LIST_EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULES)))
        .addMethod(
            getGetEffectiveSecurityHealthAnalyticsCustomModuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycentermanagement.v1
                        .GetEffectiveSecurityHealthAnalyticsCustomModuleRequest,
                    com.google.cloud.securitycentermanagement.v1
                        .EffectiveSecurityHealthAnalyticsCustomModule>(
                    service, METHODID_GET_EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE)))
        .addMethod(
            getListSecurityHealthAnalyticsCustomModulesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycentermanagement.v1
                        .ListSecurityHealthAnalyticsCustomModulesRequest,
                    com.google.cloud.securitycentermanagement.v1
                        .ListSecurityHealthAnalyticsCustomModulesResponse>(
                    service, METHODID_LIST_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULES)))
        .addMethod(
            getListDescendantSecurityHealthAnalyticsCustomModulesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycentermanagement.v1
                        .ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
                    com.google.cloud.securitycentermanagement.v1
                        .ListDescendantSecurityHealthAnalyticsCustomModulesResponse>(
                    service, METHODID_LIST_DESCENDANT_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULES)))
        .addMethod(
            getGetSecurityHealthAnalyticsCustomModuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycentermanagement.v1
                        .GetSecurityHealthAnalyticsCustomModuleRequest,
                    com.google.cloud.securitycentermanagement.v1
                        .SecurityHealthAnalyticsCustomModule>(
                    service, METHODID_GET_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE)))
        .addMethod(
            getCreateSecurityHealthAnalyticsCustomModuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycentermanagement.v1
                        .CreateSecurityHealthAnalyticsCustomModuleRequest,
                    com.google.cloud.securitycentermanagement.v1
                        .SecurityHealthAnalyticsCustomModule>(
                    service, METHODID_CREATE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE)))
        .addMethod(
            getUpdateSecurityHealthAnalyticsCustomModuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycentermanagement.v1
                        .UpdateSecurityHealthAnalyticsCustomModuleRequest,
                    com.google.cloud.securitycentermanagement.v1
                        .SecurityHealthAnalyticsCustomModule>(
                    service, METHODID_UPDATE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE)))
        .addMethod(
            getDeleteSecurityHealthAnalyticsCustomModuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycentermanagement.v1
                        .DeleteSecurityHealthAnalyticsCustomModuleRequest,
                    com.google.protobuf.Empty>(
                    service, METHODID_DELETE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE)))
        .addMethod(
            getSimulateSecurityHealthAnalyticsCustomModuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycentermanagement.v1
                        .SimulateSecurityHealthAnalyticsCustomModuleRequest,
                    com.google.cloud.securitycentermanagement.v1
                        .SimulateSecurityHealthAnalyticsCustomModuleResponse>(
                    service, METHODID_SIMULATE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE)))
        .addMethod(
            getListEffectiveEventThreatDetectionCustomModulesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycentermanagement.v1
                        .ListEffectiveEventThreatDetectionCustomModulesRequest,
                    com.google.cloud.securitycentermanagement.v1
                        .ListEffectiveEventThreatDetectionCustomModulesResponse>(
                    service, METHODID_LIST_EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULES)))
        .addMethod(
            getGetEffectiveEventThreatDetectionCustomModuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycentermanagement.v1
                        .GetEffectiveEventThreatDetectionCustomModuleRequest,
                    com.google.cloud.securitycentermanagement.v1
                        .EffectiveEventThreatDetectionCustomModule>(
                    service, METHODID_GET_EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULE)))
        .addMethod(
            getListEventThreatDetectionCustomModulesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycentermanagement.v1
                        .ListEventThreatDetectionCustomModulesRequest,
                    com.google.cloud.securitycentermanagement.v1
                        .ListEventThreatDetectionCustomModulesResponse>(
                    service, METHODID_LIST_EVENT_THREAT_DETECTION_CUSTOM_MODULES)))
        .addMethod(
            getListDescendantEventThreatDetectionCustomModulesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycentermanagement.v1
                        .ListDescendantEventThreatDetectionCustomModulesRequest,
                    com.google.cloud.securitycentermanagement.v1
                        .ListDescendantEventThreatDetectionCustomModulesResponse>(
                    service, METHODID_LIST_DESCENDANT_EVENT_THREAT_DETECTION_CUSTOM_MODULES)))
        .addMethod(
            getGetEventThreatDetectionCustomModuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycentermanagement.v1
                        .GetEventThreatDetectionCustomModuleRequest,
                    com.google.cloud.securitycentermanagement.v1.EventThreatDetectionCustomModule>(
                    service, METHODID_GET_EVENT_THREAT_DETECTION_CUSTOM_MODULE)))
        .addMethod(
            getCreateEventThreatDetectionCustomModuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycentermanagement.v1
                        .CreateEventThreatDetectionCustomModuleRequest,
                    com.google.cloud.securitycentermanagement.v1.EventThreatDetectionCustomModule>(
                    service, METHODID_CREATE_EVENT_THREAT_DETECTION_CUSTOM_MODULE)))
        .addMethod(
            getUpdateEventThreatDetectionCustomModuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycentermanagement.v1
                        .UpdateEventThreatDetectionCustomModuleRequest,
                    com.google.cloud.securitycentermanagement.v1.EventThreatDetectionCustomModule>(
                    service, METHODID_UPDATE_EVENT_THREAT_DETECTION_CUSTOM_MODULE)))
        .addMethod(
            getDeleteEventThreatDetectionCustomModuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycentermanagement.v1
                        .DeleteEventThreatDetectionCustomModuleRequest,
                    com.google.protobuf.Empty>(
                    service, METHODID_DELETE_EVENT_THREAT_DETECTION_CUSTOM_MODULE)))
        .addMethod(
            getValidateEventThreatDetectionCustomModuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycentermanagement.v1
                        .ValidateEventThreatDetectionCustomModuleRequest,
                    com.google.cloud.securitycentermanagement.v1
                        .ValidateEventThreatDetectionCustomModuleResponse>(
                    service, METHODID_VALIDATE_EVENT_THREAT_DETECTION_CUSTOM_MODULE)))
        .build();
  }

  private abstract static class SecurityCenterManagementBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SecurityCenterManagementBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementProto
          .getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SecurityCenterManagement");
    }
  }

  private static final class SecurityCenterManagementFileDescriptorSupplier
      extends SecurityCenterManagementBaseDescriptorSupplier {
    SecurityCenterManagementFileDescriptorSupplier() {}
  }

  private static final class SecurityCenterManagementMethodDescriptorSupplier
      extends SecurityCenterManagementBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SecurityCenterManagementMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SecurityCenterManagementGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SecurityCenterManagementFileDescriptorSupplier())
                      .addMethod(getListEffectiveSecurityHealthAnalyticsCustomModulesMethod())
                      .addMethod(getGetEffectiveSecurityHealthAnalyticsCustomModuleMethod())
                      .addMethod(getListSecurityHealthAnalyticsCustomModulesMethod())
                      .addMethod(getListDescendantSecurityHealthAnalyticsCustomModulesMethod())
                      .addMethod(getGetSecurityHealthAnalyticsCustomModuleMethod())
                      .addMethod(getCreateSecurityHealthAnalyticsCustomModuleMethod())
                      .addMethod(getUpdateSecurityHealthAnalyticsCustomModuleMethod())
                      .addMethod(getDeleteSecurityHealthAnalyticsCustomModuleMethod())
                      .addMethod(getSimulateSecurityHealthAnalyticsCustomModuleMethod())
                      .addMethod(getListEffectiveEventThreatDetectionCustomModulesMethod())
                      .addMethod(getGetEffectiveEventThreatDetectionCustomModuleMethod())
                      .addMethod(getListEventThreatDetectionCustomModulesMethod())
                      .addMethod(getListDescendantEventThreatDetectionCustomModulesMethod())
                      .addMethod(getGetEventThreatDetectionCustomModuleMethod())
                      .addMethod(getCreateEventThreatDetectionCustomModuleMethod())
                      .addMethod(getUpdateEventThreatDetectionCustomModuleMethod())
                      .addMethod(getDeleteEventThreatDetectionCustomModuleMethod())
                      .addMethod(getValidateEventThreatDetectionCustomModuleMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
