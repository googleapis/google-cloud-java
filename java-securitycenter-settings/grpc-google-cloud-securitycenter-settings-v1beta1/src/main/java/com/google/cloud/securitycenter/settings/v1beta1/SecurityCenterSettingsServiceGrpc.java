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
package com.google.cloud.securitycenter.settings.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * ## API Overview
 * The SecurityCenterSettingsService is a sub-api of
 * `securitycenter.googleapis.com`. The service provides methods to manage
 * Security Center Settings, and Component Settings for GCP organizations,
 * folders, projects, and clusters.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments =
        "Source: google/cloud/securitycenter/settings/v1beta1/securitycenter_settings_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SecurityCenterSettingsServiceGrpc {

  private SecurityCenterSettingsServiceGrpc() {}

  public static final String SERVICE_NAME =
      "google.cloud.securitycenter.settings.v1beta1.SecurityCenterSettingsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.settings.v1beta1.GetServiceAccountRequest,
          com.google.cloud.securitycenter.settings.v1beta1.ServiceAccount>
      getGetServiceAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetServiceAccount",
      requestType = com.google.cloud.securitycenter.settings.v1beta1.GetServiceAccountRequest.class,
      responseType = com.google.cloud.securitycenter.settings.v1beta1.ServiceAccount.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.settings.v1beta1.GetServiceAccountRequest,
          com.google.cloud.securitycenter.settings.v1beta1.ServiceAccount>
      getGetServiceAccountMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.settings.v1beta1.GetServiceAccountRequest,
            com.google.cloud.securitycenter.settings.v1beta1.ServiceAccount>
        getGetServiceAccountMethod;
    if ((getGetServiceAccountMethod = SecurityCenterSettingsServiceGrpc.getGetServiceAccountMethod)
        == null) {
      synchronized (SecurityCenterSettingsServiceGrpc.class) {
        if ((getGetServiceAccountMethod =
                SecurityCenterSettingsServiceGrpc.getGetServiceAccountMethod)
            == null) {
          SecurityCenterSettingsServiceGrpc.getGetServiceAccountMethod =
              getGetServiceAccountMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.settings.v1beta1.GetServiceAccountRequest,
                          com.google.cloud.securitycenter.settings.v1beta1.ServiceAccount>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetServiceAccount"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.settings.v1beta1
                                  .GetServiceAccountRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.settings.v1beta1.ServiceAccount
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterSettingsServiceMethodDescriptorSupplier(
                              "GetServiceAccount"))
                      .build();
        }
      }
    }
    return getGetServiceAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.settings.v1beta1.GetSettingsRequest,
          com.google.cloud.securitycenter.settings.v1beta1.Settings>
      getGetSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSettings",
      requestType = com.google.cloud.securitycenter.settings.v1beta1.GetSettingsRequest.class,
      responseType = com.google.cloud.securitycenter.settings.v1beta1.Settings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.settings.v1beta1.GetSettingsRequest,
          com.google.cloud.securitycenter.settings.v1beta1.Settings>
      getGetSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.settings.v1beta1.GetSettingsRequest,
            com.google.cloud.securitycenter.settings.v1beta1.Settings>
        getGetSettingsMethod;
    if ((getGetSettingsMethod = SecurityCenterSettingsServiceGrpc.getGetSettingsMethod) == null) {
      synchronized (SecurityCenterSettingsServiceGrpc.class) {
        if ((getGetSettingsMethod = SecurityCenterSettingsServiceGrpc.getGetSettingsMethod)
            == null) {
          SecurityCenterSettingsServiceGrpc.getGetSettingsMethod =
              getGetSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.settings.v1beta1.GetSettingsRequest,
                          com.google.cloud.securitycenter.settings.v1beta1.Settings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.settings.v1beta1.GetSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.settings.v1beta1.Settings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterSettingsServiceMethodDescriptorSupplier("GetSettings"))
                      .build();
        }
      }
    }
    return getGetSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.settings.v1beta1.UpdateSettingsRequest,
          com.google.cloud.securitycenter.settings.v1beta1.Settings>
      getUpdateSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSettings",
      requestType = com.google.cloud.securitycenter.settings.v1beta1.UpdateSettingsRequest.class,
      responseType = com.google.cloud.securitycenter.settings.v1beta1.Settings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.settings.v1beta1.UpdateSettingsRequest,
          com.google.cloud.securitycenter.settings.v1beta1.Settings>
      getUpdateSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.settings.v1beta1.UpdateSettingsRequest,
            com.google.cloud.securitycenter.settings.v1beta1.Settings>
        getUpdateSettingsMethod;
    if ((getUpdateSettingsMethod = SecurityCenterSettingsServiceGrpc.getUpdateSettingsMethod)
        == null) {
      synchronized (SecurityCenterSettingsServiceGrpc.class) {
        if ((getUpdateSettingsMethod = SecurityCenterSettingsServiceGrpc.getUpdateSettingsMethod)
            == null) {
          SecurityCenterSettingsServiceGrpc.getUpdateSettingsMethod =
              getUpdateSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.settings.v1beta1.UpdateSettingsRequest,
                          com.google.cloud.securitycenter.settings.v1beta1.Settings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.settings.v1beta1.UpdateSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.settings.v1beta1.Settings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterSettingsServiceMethodDescriptorSupplier(
                              "UpdateSettings"))
                      .build();
        }
      }
    }
    return getUpdateSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.settings.v1beta1.ResetSettingsRequest,
          com.google.protobuf.Empty>
      getResetSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResetSettings",
      requestType = com.google.cloud.securitycenter.settings.v1beta1.ResetSettingsRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.settings.v1beta1.ResetSettingsRequest,
          com.google.protobuf.Empty>
      getResetSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.settings.v1beta1.ResetSettingsRequest,
            com.google.protobuf.Empty>
        getResetSettingsMethod;
    if ((getResetSettingsMethod = SecurityCenterSettingsServiceGrpc.getResetSettingsMethod)
        == null) {
      synchronized (SecurityCenterSettingsServiceGrpc.class) {
        if ((getResetSettingsMethod = SecurityCenterSettingsServiceGrpc.getResetSettingsMethod)
            == null) {
          SecurityCenterSettingsServiceGrpc.getResetSettingsMethod =
              getResetSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.settings.v1beta1.ResetSettingsRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResetSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.settings.v1beta1.ResetSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterSettingsServiceMethodDescriptorSupplier(
                              "ResetSettings"))
                      .build();
        }
      }
    }
    return getResetSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.settings.v1beta1.BatchGetSettingsRequest,
          com.google.cloud.securitycenter.settings.v1beta1.BatchGetSettingsResponse>
      getBatchGetSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchGetSettings",
      requestType = com.google.cloud.securitycenter.settings.v1beta1.BatchGetSettingsRequest.class,
      responseType =
          com.google.cloud.securitycenter.settings.v1beta1.BatchGetSettingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.settings.v1beta1.BatchGetSettingsRequest,
          com.google.cloud.securitycenter.settings.v1beta1.BatchGetSettingsResponse>
      getBatchGetSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.settings.v1beta1.BatchGetSettingsRequest,
            com.google.cloud.securitycenter.settings.v1beta1.BatchGetSettingsResponse>
        getBatchGetSettingsMethod;
    if ((getBatchGetSettingsMethod = SecurityCenterSettingsServiceGrpc.getBatchGetSettingsMethod)
        == null) {
      synchronized (SecurityCenterSettingsServiceGrpc.class) {
        if ((getBatchGetSettingsMethod =
                SecurityCenterSettingsServiceGrpc.getBatchGetSettingsMethod)
            == null) {
          SecurityCenterSettingsServiceGrpc.getBatchGetSettingsMethod =
              getBatchGetSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.settings.v1beta1.BatchGetSettingsRequest,
                          com.google.cloud.securitycenter.settings.v1beta1.BatchGetSettingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchGetSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.settings.v1beta1
                                  .BatchGetSettingsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.settings.v1beta1
                                  .BatchGetSettingsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterSettingsServiceMethodDescriptorSupplier(
                              "BatchGetSettings"))
                      .build();
        }
      }
    }
    return getBatchGetSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.settings.v1beta1.CalculateEffectiveSettingsRequest,
          com.google.cloud.securitycenter.settings.v1beta1.Settings>
      getCalculateEffectiveSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CalculateEffectiveSettings",
      requestType =
          com.google.cloud.securitycenter.settings.v1beta1.CalculateEffectiveSettingsRequest.class,
      responseType = com.google.cloud.securitycenter.settings.v1beta1.Settings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.settings.v1beta1.CalculateEffectiveSettingsRequest,
          com.google.cloud.securitycenter.settings.v1beta1.Settings>
      getCalculateEffectiveSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.settings.v1beta1.CalculateEffectiveSettingsRequest,
            com.google.cloud.securitycenter.settings.v1beta1.Settings>
        getCalculateEffectiveSettingsMethod;
    if ((getCalculateEffectiveSettingsMethod =
            SecurityCenterSettingsServiceGrpc.getCalculateEffectiveSettingsMethod)
        == null) {
      synchronized (SecurityCenterSettingsServiceGrpc.class) {
        if ((getCalculateEffectiveSettingsMethod =
                SecurityCenterSettingsServiceGrpc.getCalculateEffectiveSettingsMethod)
            == null) {
          SecurityCenterSettingsServiceGrpc.getCalculateEffectiveSettingsMethod =
              getCalculateEffectiveSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.settings.v1beta1
                              .CalculateEffectiveSettingsRequest,
                          com.google.cloud.securitycenter.settings.v1beta1.Settings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CalculateEffectiveSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.settings.v1beta1
                                  .CalculateEffectiveSettingsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.settings.v1beta1.Settings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterSettingsServiceMethodDescriptorSupplier(
                              "CalculateEffectiveSettings"))
                      .build();
        }
      }
    }
    return getCalculateEffectiveSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.settings.v1beta1.BatchCalculateEffectiveSettingsRequest,
          com.google.cloud.securitycenter.settings.v1beta1.BatchCalculateEffectiveSettingsResponse>
      getBatchCalculateEffectiveSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchCalculateEffectiveSettings",
      requestType =
          com.google.cloud.securitycenter.settings.v1beta1.BatchCalculateEffectiveSettingsRequest
              .class,
      responseType =
          com.google.cloud.securitycenter.settings.v1beta1.BatchCalculateEffectiveSettingsResponse
              .class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.settings.v1beta1.BatchCalculateEffectiveSettingsRequest,
          com.google.cloud.securitycenter.settings.v1beta1.BatchCalculateEffectiveSettingsResponse>
      getBatchCalculateEffectiveSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.settings.v1beta1.BatchCalculateEffectiveSettingsRequest,
            com.google.cloud.securitycenter.settings.v1beta1
                .BatchCalculateEffectiveSettingsResponse>
        getBatchCalculateEffectiveSettingsMethod;
    if ((getBatchCalculateEffectiveSettingsMethod =
            SecurityCenterSettingsServiceGrpc.getBatchCalculateEffectiveSettingsMethod)
        == null) {
      synchronized (SecurityCenterSettingsServiceGrpc.class) {
        if ((getBatchCalculateEffectiveSettingsMethod =
                SecurityCenterSettingsServiceGrpc.getBatchCalculateEffectiveSettingsMethod)
            == null) {
          SecurityCenterSettingsServiceGrpc.getBatchCalculateEffectiveSettingsMethod =
              getBatchCalculateEffectiveSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.settings.v1beta1
                              .BatchCalculateEffectiveSettingsRequest,
                          com.google.cloud.securitycenter.settings.v1beta1
                              .BatchCalculateEffectiveSettingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchCalculateEffectiveSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.settings.v1beta1
                                  .BatchCalculateEffectiveSettingsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.settings.v1beta1
                                  .BatchCalculateEffectiveSettingsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterSettingsServiceMethodDescriptorSupplier(
                              "BatchCalculateEffectiveSettings"))
                      .build();
        }
      }
    }
    return getBatchCalculateEffectiveSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.settings.v1beta1.GetComponentSettingsRequest,
          com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings>
      getGetComponentSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetComponentSettings",
      requestType =
          com.google.cloud.securitycenter.settings.v1beta1.GetComponentSettingsRequest.class,
      responseType = com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.settings.v1beta1.GetComponentSettingsRequest,
          com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings>
      getGetComponentSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.settings.v1beta1.GetComponentSettingsRequest,
            com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings>
        getGetComponentSettingsMethod;
    if ((getGetComponentSettingsMethod =
            SecurityCenterSettingsServiceGrpc.getGetComponentSettingsMethod)
        == null) {
      synchronized (SecurityCenterSettingsServiceGrpc.class) {
        if ((getGetComponentSettingsMethod =
                SecurityCenterSettingsServiceGrpc.getGetComponentSettingsMethod)
            == null) {
          SecurityCenterSettingsServiceGrpc.getGetComponentSettingsMethod =
              getGetComponentSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.settings.v1beta1
                              .GetComponentSettingsRequest,
                          com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetComponentSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.settings.v1beta1
                                  .GetComponentSettingsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterSettingsServiceMethodDescriptorSupplier(
                              "GetComponentSettings"))
                      .build();
        }
      }
    }
    return getGetComponentSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.settings.v1beta1.UpdateComponentSettingsRequest,
          com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings>
      getUpdateComponentSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateComponentSettings",
      requestType =
          com.google.cloud.securitycenter.settings.v1beta1.UpdateComponentSettingsRequest.class,
      responseType = com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.settings.v1beta1.UpdateComponentSettingsRequest,
          com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings>
      getUpdateComponentSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.settings.v1beta1.UpdateComponentSettingsRequest,
            com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings>
        getUpdateComponentSettingsMethod;
    if ((getUpdateComponentSettingsMethod =
            SecurityCenterSettingsServiceGrpc.getUpdateComponentSettingsMethod)
        == null) {
      synchronized (SecurityCenterSettingsServiceGrpc.class) {
        if ((getUpdateComponentSettingsMethod =
                SecurityCenterSettingsServiceGrpc.getUpdateComponentSettingsMethod)
            == null) {
          SecurityCenterSettingsServiceGrpc.getUpdateComponentSettingsMethod =
              getUpdateComponentSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.settings.v1beta1
                              .UpdateComponentSettingsRequest,
                          com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateComponentSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.settings.v1beta1
                                  .UpdateComponentSettingsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterSettingsServiceMethodDescriptorSupplier(
                              "UpdateComponentSettings"))
                      .build();
        }
      }
    }
    return getUpdateComponentSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.settings.v1beta1.ResetComponentSettingsRequest,
          com.google.protobuf.Empty>
      getResetComponentSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResetComponentSettings",
      requestType =
          com.google.cloud.securitycenter.settings.v1beta1.ResetComponentSettingsRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.settings.v1beta1.ResetComponentSettingsRequest,
          com.google.protobuf.Empty>
      getResetComponentSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.settings.v1beta1.ResetComponentSettingsRequest,
            com.google.protobuf.Empty>
        getResetComponentSettingsMethod;
    if ((getResetComponentSettingsMethod =
            SecurityCenterSettingsServiceGrpc.getResetComponentSettingsMethod)
        == null) {
      synchronized (SecurityCenterSettingsServiceGrpc.class) {
        if ((getResetComponentSettingsMethod =
                SecurityCenterSettingsServiceGrpc.getResetComponentSettingsMethod)
            == null) {
          SecurityCenterSettingsServiceGrpc.getResetComponentSettingsMethod =
              getResetComponentSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.settings.v1beta1
                              .ResetComponentSettingsRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ResetComponentSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.settings.v1beta1
                                  .ResetComponentSettingsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterSettingsServiceMethodDescriptorSupplier(
                              "ResetComponentSettings"))
                      .build();
        }
      }
    }
    return getResetComponentSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.settings.v1beta1
              .CalculateEffectiveComponentSettingsRequest,
          com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings>
      getCalculateEffectiveComponentSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CalculateEffectiveComponentSettings",
      requestType =
          com.google.cloud.securitycenter.settings.v1beta1
              .CalculateEffectiveComponentSettingsRequest.class,
      responseType = com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.settings.v1beta1
              .CalculateEffectiveComponentSettingsRequest,
          com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings>
      getCalculateEffectiveComponentSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.settings.v1beta1
                .CalculateEffectiveComponentSettingsRequest,
            com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings>
        getCalculateEffectiveComponentSettingsMethod;
    if ((getCalculateEffectiveComponentSettingsMethod =
            SecurityCenterSettingsServiceGrpc.getCalculateEffectiveComponentSettingsMethod)
        == null) {
      synchronized (SecurityCenterSettingsServiceGrpc.class) {
        if ((getCalculateEffectiveComponentSettingsMethod =
                SecurityCenterSettingsServiceGrpc.getCalculateEffectiveComponentSettingsMethod)
            == null) {
          SecurityCenterSettingsServiceGrpc.getCalculateEffectiveComponentSettingsMethod =
              getCalculateEffectiveComponentSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.settings.v1beta1
                              .CalculateEffectiveComponentSettingsRequest,
                          com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "CalculateEffectiveComponentSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.settings.v1beta1
                                  .CalculateEffectiveComponentSettingsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterSettingsServiceMethodDescriptorSupplier(
                              "CalculateEffectiveComponentSettings"))
                      .build();
        }
      }
    }
    return getCalculateEffectiveComponentSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.settings.v1beta1.ListDetectorsRequest,
          com.google.cloud.securitycenter.settings.v1beta1.ListDetectorsResponse>
      getListDetectorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDetectors",
      requestType = com.google.cloud.securitycenter.settings.v1beta1.ListDetectorsRequest.class,
      responseType = com.google.cloud.securitycenter.settings.v1beta1.ListDetectorsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.settings.v1beta1.ListDetectorsRequest,
          com.google.cloud.securitycenter.settings.v1beta1.ListDetectorsResponse>
      getListDetectorsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.settings.v1beta1.ListDetectorsRequest,
            com.google.cloud.securitycenter.settings.v1beta1.ListDetectorsResponse>
        getListDetectorsMethod;
    if ((getListDetectorsMethod = SecurityCenterSettingsServiceGrpc.getListDetectorsMethod)
        == null) {
      synchronized (SecurityCenterSettingsServiceGrpc.class) {
        if ((getListDetectorsMethod = SecurityCenterSettingsServiceGrpc.getListDetectorsMethod)
            == null) {
          SecurityCenterSettingsServiceGrpc.getListDetectorsMethod =
              getListDetectorsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.settings.v1beta1.ListDetectorsRequest,
                          com.google.cloud.securitycenter.settings.v1beta1.ListDetectorsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDetectors"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.settings.v1beta1.ListDetectorsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.settings.v1beta1.ListDetectorsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterSettingsServiceMethodDescriptorSupplier(
                              "ListDetectors"))
                      .build();
        }
      }
    }
    return getListDetectorsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.settings.v1beta1.ListComponentsRequest,
          com.google.cloud.securitycenter.settings.v1beta1.ListComponentsResponse>
      getListComponentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListComponents",
      requestType = com.google.cloud.securitycenter.settings.v1beta1.ListComponentsRequest.class,
      responseType = com.google.cloud.securitycenter.settings.v1beta1.ListComponentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.settings.v1beta1.ListComponentsRequest,
          com.google.cloud.securitycenter.settings.v1beta1.ListComponentsResponse>
      getListComponentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.settings.v1beta1.ListComponentsRequest,
            com.google.cloud.securitycenter.settings.v1beta1.ListComponentsResponse>
        getListComponentsMethod;
    if ((getListComponentsMethod = SecurityCenterSettingsServiceGrpc.getListComponentsMethod)
        == null) {
      synchronized (SecurityCenterSettingsServiceGrpc.class) {
        if ((getListComponentsMethod = SecurityCenterSettingsServiceGrpc.getListComponentsMethod)
            == null) {
          SecurityCenterSettingsServiceGrpc.getListComponentsMethod =
              getListComponentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.settings.v1beta1.ListComponentsRequest,
                          com.google.cloud.securitycenter.settings.v1beta1.ListComponentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListComponents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.settings.v1beta1.ListComponentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.settings.v1beta1
                                  .ListComponentsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterSettingsServiceMethodDescriptorSupplier(
                              "ListComponents"))
                      .build();
        }
      }
    }
    return getListComponentsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SecurityCenterSettingsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecurityCenterSettingsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SecurityCenterSettingsServiceStub>() {
          @java.lang.Override
          public SecurityCenterSettingsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SecurityCenterSettingsServiceStub(channel, callOptions);
          }
        };
    return SecurityCenterSettingsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SecurityCenterSettingsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecurityCenterSettingsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SecurityCenterSettingsServiceBlockingStub>() {
          @java.lang.Override
          public SecurityCenterSettingsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SecurityCenterSettingsServiceBlockingStub(channel, callOptions);
          }
        };
    return SecurityCenterSettingsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SecurityCenterSettingsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecurityCenterSettingsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SecurityCenterSettingsServiceFutureStub>() {
          @java.lang.Override
          public SecurityCenterSettingsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SecurityCenterSettingsServiceFutureStub(channel, callOptions);
          }
        };
    return SecurityCenterSettingsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * ## API Overview
   * The SecurityCenterSettingsService is a sub-api of
   * `securitycenter.googleapis.com`. The service provides methods to manage
   * Security Center Settings, and Component Settings for GCP organizations,
   * folders, projects, and clusters.
   * </pre>
   */
  public abstract static class SecurityCenterSettingsServiceImplBase
      implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Retrieves the organizations service account, if it exists, otherwise it
     * creates the organization service account. This API is idempotent and
     * will only create a service account once. On subsequent calls it will
     * return the previously created service account.  SHA, SCC and CTD Infra
     * Automation will use this SA.  This SA will not have any permissions when
     * created.  The UI will provision this via IAM or the user will using
     * their own internal process. This API only creates SAs on the organization.
     * Folders are not supported and projects will use per-project SAs associated
     * with APIs enabled on a project. This API will be called by the UX
     * onboarding workflow.
     * </pre>
     */
    public void getServiceAccount(
        com.google.cloud.securitycenter.settings.v1beta1.GetServiceAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.settings.v1beta1.ServiceAccount>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetServiceAccountMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the Settings.
     * </pre>
     */
    public void getSettings(
        com.google.cloud.securitycenter.settings.v1beta1.GetSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.settings.v1beta1.Settings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the Settings.
     * </pre>
     */
    public void updateSettings(
        com.google.cloud.securitycenter.settings.v1beta1.UpdateSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.settings.v1beta1.Settings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reset the organization, folder or project's settings and return
     * the settings of just that resource to the default.
     * Settings are present at the organization, folder, project, and cluster
     * levels. Using Reset on a sub-organization level will remove that resource's
     * override and result in the parent's settings being used (eg: if Reset on a
     * cluster, project settings will be used).
     * Using Reset on organization will remove the override that was set and
     * result in default settings being used.
     * </pre>
     */
    public void resetSettings(
        com.google.cloud.securitycenter.settings.v1beta1.ResetSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getResetSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of settings.
     * </pre>
     */
    public void batchGetSettings(
        com.google.cloud.securitycenter.settings.v1beta1.BatchGetSettingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycenter.settings.v1beta1.BatchGetSettingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchGetSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * CalculateEffectiveSettings looks up all of the Security Center
     * Settings resources in the GCP resource hierarchy, and calculates the
     * effective settings on that resource by applying the following rules:
     *  * Settings provided closer to the target resource take precedence over
     *    those further away (e.g. folder will override organization level
     *    settings).
     *  * Product defaults can be overridden at org, folder, project, and cluster
     *  levels.
     *  * Detectors will be filtered out if they belong to a billing tier the
     *  customer
     *    has not configured.
     * </pre>
     */
    public void calculateEffectiveSettings(
        com.google.cloud.securitycenter.settings.v1beta1.CalculateEffectiveSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.settings.v1beta1.Settings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCalculateEffectiveSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of effective settings.
     * </pre>
     */
    public void batchCalculateEffectiveSettings(
        com.google.cloud.securitycenter.settings.v1beta1.BatchCalculateEffectiveSettingsRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycenter.settings.v1beta1
                    .BatchCalculateEffectiveSettingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchCalculateEffectiveSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the Component Settings.
     * </pre>
     */
    public void getComponentSettings(
        com.google.cloud.securitycenter.settings.v1beta1.GetComponentSettingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetComponentSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the Component Settings.
     * </pre>
     */
    public void updateComponentSettings(
        com.google.cloud.securitycenter.settings.v1beta1.UpdateComponentSettingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateComponentSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reset the organization, folder or project's component settings and return
     * the settings to the default. Settings are present at the
     * organization, folder and project levels. Using Reset for a folder or
     * project will remove the override that was set and result in the
     * organization-level settings being used.
     * </pre>
     */
    public void resetComponentSettings(
        com.google.cloud.securitycenter.settings.v1beta1.ResetComponentSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getResetComponentSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the Effective Component Settings.
     * </pre>
     */
    public void calculateEffectiveComponentSettings(
        com.google.cloud.securitycenter.settings.v1beta1.CalculateEffectiveComponentSettingsRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCalculateEffectiveComponentSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an unordered list of available detectors.
     * </pre>
     */
    public void listDetectors(
        com.google.cloud.securitycenter.settings.v1beta1.ListDetectorsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycenter.settings.v1beta1.ListDetectorsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDetectorsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an unordered list of available SCC components.
     * </pre>
     */
    public void listComponents(
        com.google.cloud.securitycenter.settings.v1beta1.ListComponentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycenter.settings.v1beta1.ListComponentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListComponentsMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getGetServiceAccountMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.settings.v1beta1.GetServiceAccountRequest,
                      com.google.cloud.securitycenter.settings.v1beta1.ServiceAccount>(
                      this, METHODID_GET_SERVICE_ACCOUNT)))
          .addMethod(
              getGetSettingsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.settings.v1beta1.GetSettingsRequest,
                      com.google.cloud.securitycenter.settings.v1beta1.Settings>(
                      this, METHODID_GET_SETTINGS)))
          .addMethod(
              getUpdateSettingsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.settings.v1beta1.UpdateSettingsRequest,
                      com.google.cloud.securitycenter.settings.v1beta1.Settings>(
                      this, METHODID_UPDATE_SETTINGS)))
          .addMethod(
              getResetSettingsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.settings.v1beta1.ResetSettingsRequest,
                      com.google.protobuf.Empty>(this, METHODID_RESET_SETTINGS)))
          .addMethod(
              getBatchGetSettingsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.settings.v1beta1.BatchGetSettingsRequest,
                      com.google.cloud.securitycenter.settings.v1beta1.BatchGetSettingsResponse>(
                      this, METHODID_BATCH_GET_SETTINGS)))
          .addMethod(
              getCalculateEffectiveSettingsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.settings.v1beta1
                          .CalculateEffectiveSettingsRequest,
                      com.google.cloud.securitycenter.settings.v1beta1.Settings>(
                      this, METHODID_CALCULATE_EFFECTIVE_SETTINGS)))
          .addMethod(
              getBatchCalculateEffectiveSettingsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.settings.v1beta1
                          .BatchCalculateEffectiveSettingsRequest,
                      com.google.cloud.securitycenter.settings.v1beta1
                          .BatchCalculateEffectiveSettingsResponse>(
                      this, METHODID_BATCH_CALCULATE_EFFECTIVE_SETTINGS)))
          .addMethod(
              getGetComponentSettingsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.settings.v1beta1.GetComponentSettingsRequest,
                      com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings>(
                      this, METHODID_GET_COMPONENT_SETTINGS)))
          .addMethod(
              getUpdateComponentSettingsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.settings.v1beta1
                          .UpdateComponentSettingsRequest,
                      com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings>(
                      this, METHODID_UPDATE_COMPONENT_SETTINGS)))
          .addMethod(
              getResetComponentSettingsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.settings.v1beta1
                          .ResetComponentSettingsRequest,
                      com.google.protobuf.Empty>(this, METHODID_RESET_COMPONENT_SETTINGS)))
          .addMethod(
              getCalculateEffectiveComponentSettingsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.settings.v1beta1
                          .CalculateEffectiveComponentSettingsRequest,
                      com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings>(
                      this, METHODID_CALCULATE_EFFECTIVE_COMPONENT_SETTINGS)))
          .addMethod(
              getListDetectorsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.settings.v1beta1.ListDetectorsRequest,
                      com.google.cloud.securitycenter.settings.v1beta1.ListDetectorsResponse>(
                      this, METHODID_LIST_DETECTORS)))
          .addMethod(
              getListComponentsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.settings.v1beta1.ListComponentsRequest,
                      com.google.cloud.securitycenter.settings.v1beta1.ListComponentsResponse>(
                      this, METHODID_LIST_COMPONENTS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * ## API Overview
   * The SecurityCenterSettingsService is a sub-api of
   * `securitycenter.googleapis.com`. The service provides methods to manage
   * Security Center Settings, and Component Settings for GCP organizations,
   * folders, projects, and clusters.
   * </pre>
   */
  public static final class SecurityCenterSettingsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SecurityCenterSettingsServiceStub> {
    private SecurityCenterSettingsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecurityCenterSettingsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecurityCenterSettingsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the organizations service account, if it exists, otherwise it
     * creates the organization service account. This API is idempotent and
     * will only create a service account once. On subsequent calls it will
     * return the previously created service account.  SHA, SCC and CTD Infra
     * Automation will use this SA.  This SA will not have any permissions when
     * created.  The UI will provision this via IAM or the user will using
     * their own internal process. This API only creates SAs on the organization.
     * Folders are not supported and projects will use per-project SAs associated
     * with APIs enabled on a project. This API will be called by the UX
     * onboarding workflow.
     * </pre>
     */
    public void getServiceAccount(
        com.google.cloud.securitycenter.settings.v1beta1.GetServiceAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.settings.v1beta1.ServiceAccount>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetServiceAccountMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the Settings.
     * </pre>
     */
    public void getSettings(
        com.google.cloud.securitycenter.settings.v1beta1.GetSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.settings.v1beta1.Settings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the Settings.
     * </pre>
     */
    public void updateSettings(
        com.google.cloud.securitycenter.settings.v1beta1.UpdateSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.settings.v1beta1.Settings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reset the organization, folder or project's settings and return
     * the settings of just that resource to the default.
     * Settings are present at the organization, folder, project, and cluster
     * levels. Using Reset on a sub-organization level will remove that resource's
     * override and result in the parent's settings being used (eg: if Reset on a
     * cluster, project settings will be used).
     * Using Reset on organization will remove the override that was set and
     * result in default settings being used.
     * </pre>
     */
    public void resetSettings(
        com.google.cloud.securitycenter.settings.v1beta1.ResetSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResetSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of settings.
     * </pre>
     */
    public void batchGetSettings(
        com.google.cloud.securitycenter.settings.v1beta1.BatchGetSettingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycenter.settings.v1beta1.BatchGetSettingsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchGetSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * CalculateEffectiveSettings looks up all of the Security Center
     * Settings resources in the GCP resource hierarchy, and calculates the
     * effective settings on that resource by applying the following rules:
     *  * Settings provided closer to the target resource take precedence over
     *    those further away (e.g. folder will override organization level
     *    settings).
     *  * Product defaults can be overridden at org, folder, project, and cluster
     *  levels.
     *  * Detectors will be filtered out if they belong to a billing tier the
     *  customer
     *    has not configured.
     * </pre>
     */
    public void calculateEffectiveSettings(
        com.google.cloud.securitycenter.settings.v1beta1.CalculateEffectiveSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.settings.v1beta1.Settings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCalculateEffectiveSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of effective settings.
     * </pre>
     */
    public void batchCalculateEffectiveSettings(
        com.google.cloud.securitycenter.settings.v1beta1.BatchCalculateEffectiveSettingsRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycenter.settings.v1beta1
                    .BatchCalculateEffectiveSettingsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchCalculateEffectiveSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the Component Settings.
     * </pre>
     */
    public void getComponentSettings(
        com.google.cloud.securitycenter.settings.v1beta1.GetComponentSettingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetComponentSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the Component Settings.
     * </pre>
     */
    public void updateComponentSettings(
        com.google.cloud.securitycenter.settings.v1beta1.UpdateComponentSettingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateComponentSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reset the organization, folder or project's component settings and return
     * the settings to the default. Settings are present at the
     * organization, folder and project levels. Using Reset for a folder or
     * project will remove the override that was set and result in the
     * organization-level settings being used.
     * </pre>
     */
    public void resetComponentSettings(
        com.google.cloud.securitycenter.settings.v1beta1.ResetComponentSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResetComponentSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the Effective Component Settings.
     * </pre>
     */
    public void calculateEffectiveComponentSettings(
        com.google.cloud.securitycenter.settings.v1beta1.CalculateEffectiveComponentSettingsRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCalculateEffectiveComponentSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an unordered list of available detectors.
     * </pre>
     */
    public void listDetectors(
        com.google.cloud.securitycenter.settings.v1beta1.ListDetectorsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycenter.settings.v1beta1.ListDetectorsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDetectorsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an unordered list of available SCC components.
     * </pre>
     */
    public void listComponents(
        com.google.cloud.securitycenter.settings.v1beta1.ListComponentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycenter.settings.v1beta1.ListComponentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListComponentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * ## API Overview
   * The SecurityCenterSettingsService is a sub-api of
   * `securitycenter.googleapis.com`. The service provides methods to manage
   * Security Center Settings, and Component Settings for GCP organizations,
   * folders, projects, and clusters.
   * </pre>
   */
  public static final class SecurityCenterSettingsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SecurityCenterSettingsServiceBlockingStub> {
    private SecurityCenterSettingsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecurityCenterSettingsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecurityCenterSettingsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the organizations service account, if it exists, otherwise it
     * creates the organization service account. This API is idempotent and
     * will only create a service account once. On subsequent calls it will
     * return the previously created service account.  SHA, SCC and CTD Infra
     * Automation will use this SA.  This SA will not have any permissions when
     * created.  The UI will provision this via IAM or the user will using
     * their own internal process. This API only creates SAs on the organization.
     * Folders are not supported and projects will use per-project SAs associated
     * with APIs enabled on a project. This API will be called by the UX
     * onboarding workflow.
     * </pre>
     */
    public com.google.cloud.securitycenter.settings.v1beta1.ServiceAccount getServiceAccount(
        com.google.cloud.securitycenter.settings.v1beta1.GetServiceAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServiceAccountMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the Settings.
     * </pre>
     */
    public com.google.cloud.securitycenter.settings.v1beta1.Settings getSettings(
        com.google.cloud.securitycenter.settings.v1beta1.GetSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the Settings.
     * </pre>
     */
    public com.google.cloud.securitycenter.settings.v1beta1.Settings updateSettings(
        com.google.cloud.securitycenter.settings.v1beta1.UpdateSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Reset the organization, folder or project's settings and return
     * the settings of just that resource to the default.
     * Settings are present at the organization, folder, project, and cluster
     * levels. Using Reset on a sub-organization level will remove that resource's
     * override and result in the parent's settings being used (eg: if Reset on a
     * cluster, project settings will be used).
     * Using Reset on organization will remove the override that was set and
     * result in default settings being used.
     * </pre>
     */
    public com.google.protobuf.Empty resetSettings(
        com.google.cloud.securitycenter.settings.v1beta1.ResetSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResetSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of settings.
     * </pre>
     */
    public com.google.cloud.securitycenter.settings.v1beta1.BatchGetSettingsResponse
        batchGetSettings(
            com.google.cloud.securitycenter.settings.v1beta1.BatchGetSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchGetSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * CalculateEffectiveSettings looks up all of the Security Center
     * Settings resources in the GCP resource hierarchy, and calculates the
     * effective settings on that resource by applying the following rules:
     *  * Settings provided closer to the target resource take precedence over
     *    those further away (e.g. folder will override organization level
     *    settings).
     *  * Product defaults can be overridden at org, folder, project, and cluster
     *  levels.
     *  * Detectors will be filtered out if they belong to a billing tier the
     *  customer
     *    has not configured.
     * </pre>
     */
    public com.google.cloud.securitycenter.settings.v1beta1.Settings calculateEffectiveSettings(
        com.google.cloud.securitycenter.settings.v1beta1.CalculateEffectiveSettingsRequest
            request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCalculateEffectiveSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of effective settings.
     * </pre>
     */
    public com.google.cloud.securitycenter.settings.v1beta1.BatchCalculateEffectiveSettingsResponse
        batchCalculateEffectiveSettings(
            com.google.cloud.securitycenter.settings.v1beta1.BatchCalculateEffectiveSettingsRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchCalculateEffectiveSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the Component Settings.
     * </pre>
     */
    public com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings getComponentSettings(
        com.google.cloud.securitycenter.settings.v1beta1.GetComponentSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetComponentSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the Component Settings.
     * </pre>
     */
    public com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings
        updateComponentSettings(
            com.google.cloud.securitycenter.settings.v1beta1.UpdateComponentSettingsRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateComponentSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Reset the organization, folder or project's component settings and return
     * the settings to the default. Settings are present at the
     * organization, folder and project levels. Using Reset for a folder or
     * project will remove the override that was set and result in the
     * organization-level settings being used.
     * </pre>
     */
    public com.google.protobuf.Empty resetComponentSettings(
        com.google.cloud.securitycenter.settings.v1beta1.ResetComponentSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResetComponentSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the Effective Component Settings.
     * </pre>
     */
    public com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings
        calculateEffectiveComponentSettings(
            com.google.cloud.securitycenter.settings.v1beta1
                    .CalculateEffectiveComponentSettingsRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCalculateEffectiveComponentSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an unordered list of available detectors.
     * </pre>
     */
    public com.google.cloud.securitycenter.settings.v1beta1.ListDetectorsResponse listDetectors(
        com.google.cloud.securitycenter.settings.v1beta1.ListDetectorsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDetectorsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an unordered list of available SCC components.
     * </pre>
     */
    public com.google.cloud.securitycenter.settings.v1beta1.ListComponentsResponse listComponents(
        com.google.cloud.securitycenter.settings.v1beta1.ListComponentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListComponentsMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * ## API Overview
   * The SecurityCenterSettingsService is a sub-api of
   * `securitycenter.googleapis.com`. The service provides methods to manage
   * Security Center Settings, and Component Settings for GCP organizations,
   * folders, projects, and clusters.
   * </pre>
   */
  public static final class SecurityCenterSettingsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SecurityCenterSettingsServiceFutureStub> {
    private SecurityCenterSettingsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecurityCenterSettingsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecurityCenterSettingsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the organizations service account, if it exists, otherwise it
     * creates the organization service account. This API is idempotent and
     * will only create a service account once. On subsequent calls it will
     * return the previously created service account.  SHA, SCC and CTD Infra
     * Automation will use this SA.  This SA will not have any permissions when
     * created.  The UI will provision this via IAM or the user will using
     * their own internal process. This API only creates SAs on the organization.
     * Folders are not supported and projects will use per-project SAs associated
     * with APIs enabled on a project. This API will be called by the UX
     * onboarding workflow.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.settings.v1beta1.ServiceAccount>
        getServiceAccount(
            com.google.cloud.securitycenter.settings.v1beta1.GetServiceAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetServiceAccountMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the Settings.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.settings.v1beta1.Settings>
        getSettings(com.google.cloud.securitycenter.settings.v1beta1.GetSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the Settings.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.settings.v1beta1.Settings>
        updateSettings(
            com.google.cloud.securitycenter.settings.v1beta1.UpdateSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Reset the organization, folder or project's settings and return
     * the settings of just that resource to the default.
     * Settings are present at the organization, folder, project, and cluster
     * levels. Using Reset on a sub-organization level will remove that resource's
     * override and result in the parent's settings being used (eg: if Reset on a
     * cluster, project settings will be used).
     * Using Reset on organization will remove the override that was set and
     * result in default settings being used.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        resetSettings(
            com.google.cloud.securitycenter.settings.v1beta1.ResetSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResetSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of settings.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.settings.v1beta1.BatchGetSettingsResponse>
        batchGetSettings(
            com.google.cloud.securitycenter.settings.v1beta1.BatchGetSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchGetSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * CalculateEffectiveSettings looks up all of the Security Center
     * Settings resources in the GCP resource hierarchy, and calculates the
     * effective settings on that resource by applying the following rules:
     *  * Settings provided closer to the target resource take precedence over
     *    those further away (e.g. folder will override organization level
     *    settings).
     *  * Product defaults can be overridden at org, folder, project, and cluster
     *  levels.
     *  * Detectors will be filtered out if they belong to a billing tier the
     *  customer
     *    has not configured.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.settings.v1beta1.Settings>
        calculateEffectiveSettings(
            com.google.cloud.securitycenter.settings.v1beta1.CalculateEffectiveSettingsRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCalculateEffectiveSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of effective settings.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.settings.v1beta1
                .BatchCalculateEffectiveSettingsResponse>
        batchCalculateEffectiveSettings(
            com.google.cloud.securitycenter.settings.v1beta1.BatchCalculateEffectiveSettingsRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchCalculateEffectiveSettingsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets the Component Settings.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings>
        getComponentSettings(
            com.google.cloud.securitycenter.settings.v1beta1.GetComponentSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetComponentSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the Component Settings.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings>
        updateComponentSettings(
            com.google.cloud.securitycenter.settings.v1beta1.UpdateComponentSettingsRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateComponentSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Reset the organization, folder or project's component settings and return
     * the settings to the default. Settings are present at the
     * organization, folder and project levels. Using Reset for a folder or
     * project will remove the override that was set and result in the
     * organization-level settings being used.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        resetComponentSettings(
            com.google.cloud.securitycenter.settings.v1beta1.ResetComponentSettingsRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResetComponentSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the Effective Component Settings.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings>
        calculateEffectiveComponentSettings(
            com.google.cloud.securitycenter.settings.v1beta1
                    .CalculateEffectiveComponentSettingsRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCalculateEffectiveComponentSettingsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an unordered list of available detectors.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.settings.v1beta1.ListDetectorsResponse>
        listDetectors(
            com.google.cloud.securitycenter.settings.v1beta1.ListDetectorsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDetectorsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an unordered list of available SCC components.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.settings.v1beta1.ListComponentsResponse>
        listComponents(
            com.google.cloud.securitycenter.settings.v1beta1.ListComponentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListComponentsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_SERVICE_ACCOUNT = 0;
  private static final int METHODID_GET_SETTINGS = 1;
  private static final int METHODID_UPDATE_SETTINGS = 2;
  private static final int METHODID_RESET_SETTINGS = 3;
  private static final int METHODID_BATCH_GET_SETTINGS = 4;
  private static final int METHODID_CALCULATE_EFFECTIVE_SETTINGS = 5;
  private static final int METHODID_BATCH_CALCULATE_EFFECTIVE_SETTINGS = 6;
  private static final int METHODID_GET_COMPONENT_SETTINGS = 7;
  private static final int METHODID_UPDATE_COMPONENT_SETTINGS = 8;
  private static final int METHODID_RESET_COMPONENT_SETTINGS = 9;
  private static final int METHODID_CALCULATE_EFFECTIVE_COMPONENT_SETTINGS = 10;
  private static final int METHODID_LIST_DETECTORS = 11;
  private static final int METHODID_LIST_COMPONENTS = 12;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SecurityCenterSettingsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SecurityCenterSettingsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_SERVICE_ACCOUNT:
          serviceImpl.getServiceAccount(
              (com.google.cloud.securitycenter.settings.v1beta1.GetServiceAccountRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycenter.settings.v1beta1.ServiceAccount>)
                  responseObserver);
          break;
        case METHODID_GET_SETTINGS:
          serviceImpl.getSettings(
              (com.google.cloud.securitycenter.settings.v1beta1.GetSettingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycenter.settings.v1beta1.Settings>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SETTINGS:
          serviceImpl.updateSettings(
              (com.google.cloud.securitycenter.settings.v1beta1.UpdateSettingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycenter.settings.v1beta1.Settings>)
                  responseObserver);
          break;
        case METHODID_RESET_SETTINGS:
          serviceImpl.resetSettings(
              (com.google.cloud.securitycenter.settings.v1beta1.ResetSettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_BATCH_GET_SETTINGS:
          serviceImpl.batchGetSettings(
              (com.google.cloud.securitycenter.settings.v1beta1.BatchGetSettingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycenter.settings.v1beta1.BatchGetSettingsResponse>)
                  responseObserver);
          break;
        case METHODID_CALCULATE_EFFECTIVE_SETTINGS:
          serviceImpl.calculateEffectiveSettings(
              (com.google.cloud.securitycenter.settings.v1beta1.CalculateEffectiveSettingsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycenter.settings.v1beta1.Settings>)
                  responseObserver);
          break;
        case METHODID_BATCH_CALCULATE_EFFECTIVE_SETTINGS:
          serviceImpl.batchCalculateEffectiveSettings(
              (com.google.cloud.securitycenter.settings.v1beta1
                      .BatchCalculateEffectiveSettingsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycenter.settings.v1beta1
                          .BatchCalculateEffectiveSettingsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_COMPONENT_SETTINGS:
          serviceImpl.getComponentSettings(
              (com.google.cloud.securitycenter.settings.v1beta1.GetComponentSettingsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings>)
                  responseObserver);
          break;
        case METHODID_UPDATE_COMPONENT_SETTINGS:
          serviceImpl.updateComponentSettings(
              (com.google.cloud.securitycenter.settings.v1beta1.UpdateComponentSettingsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings>)
                  responseObserver);
          break;
        case METHODID_RESET_COMPONENT_SETTINGS:
          serviceImpl.resetComponentSettings(
              (com.google.cloud.securitycenter.settings.v1beta1.ResetComponentSettingsRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CALCULATE_EFFECTIVE_COMPONENT_SETTINGS:
          serviceImpl.calculateEffectiveComponentSettings(
              (com.google.cloud.securitycenter.settings.v1beta1
                      .CalculateEffectiveComponentSettingsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings>)
                  responseObserver);
          break;
        case METHODID_LIST_DETECTORS:
          serviceImpl.listDetectors(
              (com.google.cloud.securitycenter.settings.v1beta1.ListDetectorsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycenter.settings.v1beta1.ListDetectorsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_COMPONENTS:
          serviceImpl.listComponents(
              (com.google.cloud.securitycenter.settings.v1beta1.ListComponentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycenter.settings.v1beta1.ListComponentsResponse>)
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

  private abstract static class SecurityCenterSettingsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SecurityCenterSettingsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.securitycenter.settings.v1beta1.SettingsServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SecurityCenterSettingsService");
    }
  }

  private static final class SecurityCenterSettingsServiceFileDescriptorSupplier
      extends SecurityCenterSettingsServiceBaseDescriptorSupplier {
    SecurityCenterSettingsServiceFileDescriptorSupplier() {}
  }

  private static final class SecurityCenterSettingsServiceMethodDescriptorSupplier
      extends SecurityCenterSettingsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SecurityCenterSettingsServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SecurityCenterSettingsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(
                          new SecurityCenterSettingsServiceFileDescriptorSupplier())
                      .addMethod(getGetServiceAccountMethod())
                      .addMethod(getGetSettingsMethod())
                      .addMethod(getUpdateSettingsMethod())
                      .addMethod(getResetSettingsMethod())
                      .addMethod(getBatchGetSettingsMethod())
                      .addMethod(getCalculateEffectiveSettingsMethod())
                      .addMethod(getBatchCalculateEffectiveSettingsMethod())
                      .addMethod(getGetComponentSettingsMethod())
                      .addMethod(getUpdateComponentSettingsMethod())
                      .addMethod(getResetComponentSettingsMethod())
                      .addMethod(getCalculateEffectiveComponentSettingsMethod())
                      .addMethod(getListDetectorsMethod())
                      .addMethod(getListComponentsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
