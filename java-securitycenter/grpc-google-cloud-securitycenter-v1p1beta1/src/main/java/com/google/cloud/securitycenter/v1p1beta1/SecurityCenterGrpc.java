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
package com.google.cloud.securitycenter.v1p1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * V1p1Beta1 APIs for Security Center service.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/securitycenter/v1p1beta1/securitycenter_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SecurityCenterGrpc {

  private SecurityCenterGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.securitycenter.v1p1beta1.SecurityCenter";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.CreateSourceRequest,
          com.google.cloud.securitycenter.v1p1beta1.Source>
      getCreateSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSource",
      requestType = com.google.cloud.securitycenter.v1p1beta1.CreateSourceRequest.class,
      responseType = com.google.cloud.securitycenter.v1p1beta1.Source.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.CreateSourceRequest,
          com.google.cloud.securitycenter.v1p1beta1.Source>
      getCreateSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1p1beta1.CreateSourceRequest,
            com.google.cloud.securitycenter.v1p1beta1.Source>
        getCreateSourceMethod;
    if ((getCreateSourceMethod = SecurityCenterGrpc.getCreateSourceMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getCreateSourceMethod = SecurityCenterGrpc.getCreateSourceMethod) == null) {
          SecurityCenterGrpc.getCreateSourceMethod =
              getCreateSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1p1beta1.CreateSourceRequest,
                          com.google.cloud.securitycenter.v1p1beta1.Source>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1.CreateSourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1.Source
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("CreateSource"))
                      .build();
        }
      }
    }
    return getCreateSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.CreateFindingRequest,
          com.google.cloud.securitycenter.v1p1beta1.Finding>
      getCreateFindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFinding",
      requestType = com.google.cloud.securitycenter.v1p1beta1.CreateFindingRequest.class,
      responseType = com.google.cloud.securitycenter.v1p1beta1.Finding.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.CreateFindingRequest,
          com.google.cloud.securitycenter.v1p1beta1.Finding>
      getCreateFindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1p1beta1.CreateFindingRequest,
            com.google.cloud.securitycenter.v1p1beta1.Finding>
        getCreateFindingMethod;
    if ((getCreateFindingMethod = SecurityCenterGrpc.getCreateFindingMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getCreateFindingMethod = SecurityCenterGrpc.getCreateFindingMethod) == null) {
          SecurityCenterGrpc.getCreateFindingMethod =
              getCreateFindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1p1beta1.CreateFindingRequest,
                          com.google.cloud.securitycenter.v1p1beta1.Finding>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1.CreateFindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1.Finding
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("CreateFinding"))
                      .build();
        }
      }
    }
    return getCreateFindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.CreateNotificationConfigRequest,
          com.google.cloud.securitycenter.v1p1beta1.NotificationConfig>
      getCreateNotificationConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateNotificationConfig",
      requestType = com.google.cloud.securitycenter.v1p1beta1.CreateNotificationConfigRequest.class,
      responseType = com.google.cloud.securitycenter.v1p1beta1.NotificationConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.CreateNotificationConfigRequest,
          com.google.cloud.securitycenter.v1p1beta1.NotificationConfig>
      getCreateNotificationConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1p1beta1.CreateNotificationConfigRequest,
            com.google.cloud.securitycenter.v1p1beta1.NotificationConfig>
        getCreateNotificationConfigMethod;
    if ((getCreateNotificationConfigMethod = SecurityCenterGrpc.getCreateNotificationConfigMethod)
        == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getCreateNotificationConfigMethod =
                SecurityCenterGrpc.getCreateNotificationConfigMethod)
            == null) {
          SecurityCenterGrpc.getCreateNotificationConfigMethod =
              getCreateNotificationConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1p1beta1.CreateNotificationConfigRequest,
                          com.google.cloud.securitycenter.v1p1beta1.NotificationConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateNotificationConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1
                                  .CreateNotificationConfigRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1.NotificationConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("CreateNotificationConfig"))
                      .build();
        }
      }
    }
    return getCreateNotificationConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.DeleteNotificationConfigRequest,
          com.google.protobuf.Empty>
      getDeleteNotificationConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteNotificationConfig",
      requestType = com.google.cloud.securitycenter.v1p1beta1.DeleteNotificationConfigRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.DeleteNotificationConfigRequest,
          com.google.protobuf.Empty>
      getDeleteNotificationConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1p1beta1.DeleteNotificationConfigRequest,
            com.google.protobuf.Empty>
        getDeleteNotificationConfigMethod;
    if ((getDeleteNotificationConfigMethod = SecurityCenterGrpc.getDeleteNotificationConfigMethod)
        == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getDeleteNotificationConfigMethod =
                SecurityCenterGrpc.getDeleteNotificationConfigMethod)
            == null) {
          SecurityCenterGrpc.getDeleteNotificationConfigMethod =
              getDeleteNotificationConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1p1beta1.DeleteNotificationConfigRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteNotificationConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1
                                  .DeleteNotificationConfigRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("DeleteNotificationConfig"))
                      .build();
        }
      }
    }
    return getDeleteNotificationConfigMethod;
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
    if ((getGetIamPolicyMethod = SecurityCenterGrpc.getGetIamPolicyMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getGetIamPolicyMethod = SecurityCenterGrpc.getGetIamPolicyMethod) == null) {
          SecurityCenterGrpc.getGetIamPolicyMethod =
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
                          new SecurityCenterMethodDescriptorSupplier("GetIamPolicy"))
                      .build();
        }
      }
    }
    return getGetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.GetNotificationConfigRequest,
          com.google.cloud.securitycenter.v1p1beta1.NotificationConfig>
      getGetNotificationConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNotificationConfig",
      requestType = com.google.cloud.securitycenter.v1p1beta1.GetNotificationConfigRequest.class,
      responseType = com.google.cloud.securitycenter.v1p1beta1.NotificationConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.GetNotificationConfigRequest,
          com.google.cloud.securitycenter.v1p1beta1.NotificationConfig>
      getGetNotificationConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1p1beta1.GetNotificationConfigRequest,
            com.google.cloud.securitycenter.v1p1beta1.NotificationConfig>
        getGetNotificationConfigMethod;
    if ((getGetNotificationConfigMethod = SecurityCenterGrpc.getGetNotificationConfigMethod)
        == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getGetNotificationConfigMethod = SecurityCenterGrpc.getGetNotificationConfigMethod)
            == null) {
          SecurityCenterGrpc.getGetNotificationConfigMethod =
              getGetNotificationConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1p1beta1.GetNotificationConfigRequest,
                          com.google.cloud.securitycenter.v1p1beta1.NotificationConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetNotificationConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1.GetNotificationConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1.NotificationConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("GetNotificationConfig"))
                      .build();
        }
      }
    }
    return getGetNotificationConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.GetOrganizationSettingsRequest,
          com.google.cloud.securitycenter.v1p1beta1.OrganizationSettings>
      getGetOrganizationSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOrganizationSettings",
      requestType = com.google.cloud.securitycenter.v1p1beta1.GetOrganizationSettingsRequest.class,
      responseType = com.google.cloud.securitycenter.v1p1beta1.OrganizationSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.GetOrganizationSettingsRequest,
          com.google.cloud.securitycenter.v1p1beta1.OrganizationSettings>
      getGetOrganizationSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1p1beta1.GetOrganizationSettingsRequest,
            com.google.cloud.securitycenter.v1p1beta1.OrganizationSettings>
        getGetOrganizationSettingsMethod;
    if ((getGetOrganizationSettingsMethod = SecurityCenterGrpc.getGetOrganizationSettingsMethod)
        == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getGetOrganizationSettingsMethod = SecurityCenterGrpc.getGetOrganizationSettingsMethod)
            == null) {
          SecurityCenterGrpc.getGetOrganizationSettingsMethod =
              getGetOrganizationSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1p1beta1.GetOrganizationSettingsRequest,
                          com.google.cloud.securitycenter.v1p1beta1.OrganizationSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetOrganizationSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1
                                  .GetOrganizationSettingsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1.OrganizationSettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("GetOrganizationSettings"))
                      .build();
        }
      }
    }
    return getGetOrganizationSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.GetSourceRequest,
          com.google.cloud.securitycenter.v1p1beta1.Source>
      getGetSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSource",
      requestType = com.google.cloud.securitycenter.v1p1beta1.GetSourceRequest.class,
      responseType = com.google.cloud.securitycenter.v1p1beta1.Source.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.GetSourceRequest,
          com.google.cloud.securitycenter.v1p1beta1.Source>
      getGetSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1p1beta1.GetSourceRequest,
            com.google.cloud.securitycenter.v1p1beta1.Source>
        getGetSourceMethod;
    if ((getGetSourceMethod = SecurityCenterGrpc.getGetSourceMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getGetSourceMethod = SecurityCenterGrpc.getGetSourceMethod) == null) {
          SecurityCenterGrpc.getGetSourceMethod =
              getGetSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1p1beta1.GetSourceRequest,
                          com.google.cloud.securitycenter.v1p1beta1.Source>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1.GetSourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1.Source
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("GetSource"))
                      .build();
        }
      }
    }
    return getGetSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.GroupAssetsRequest,
          com.google.cloud.securitycenter.v1p1beta1.GroupAssetsResponse>
      getGroupAssetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GroupAssets",
      requestType = com.google.cloud.securitycenter.v1p1beta1.GroupAssetsRequest.class,
      responseType = com.google.cloud.securitycenter.v1p1beta1.GroupAssetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.GroupAssetsRequest,
          com.google.cloud.securitycenter.v1p1beta1.GroupAssetsResponse>
      getGroupAssetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1p1beta1.GroupAssetsRequest,
            com.google.cloud.securitycenter.v1p1beta1.GroupAssetsResponse>
        getGroupAssetsMethod;
    if ((getGroupAssetsMethod = SecurityCenterGrpc.getGroupAssetsMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getGroupAssetsMethod = SecurityCenterGrpc.getGroupAssetsMethod) == null) {
          SecurityCenterGrpc.getGroupAssetsMethod =
              getGroupAssetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1p1beta1.GroupAssetsRequest,
                          com.google.cloud.securitycenter.v1p1beta1.GroupAssetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GroupAssets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1.GroupAssetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1.GroupAssetsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("GroupAssets"))
                      .build();
        }
      }
    }
    return getGroupAssetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.GroupFindingsRequest,
          com.google.cloud.securitycenter.v1p1beta1.GroupFindingsResponse>
      getGroupFindingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GroupFindings",
      requestType = com.google.cloud.securitycenter.v1p1beta1.GroupFindingsRequest.class,
      responseType = com.google.cloud.securitycenter.v1p1beta1.GroupFindingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.GroupFindingsRequest,
          com.google.cloud.securitycenter.v1p1beta1.GroupFindingsResponse>
      getGroupFindingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1p1beta1.GroupFindingsRequest,
            com.google.cloud.securitycenter.v1p1beta1.GroupFindingsResponse>
        getGroupFindingsMethod;
    if ((getGroupFindingsMethod = SecurityCenterGrpc.getGroupFindingsMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getGroupFindingsMethod = SecurityCenterGrpc.getGroupFindingsMethod) == null) {
          SecurityCenterGrpc.getGroupFindingsMethod =
              getGroupFindingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1p1beta1.GroupFindingsRequest,
                          com.google.cloud.securitycenter.v1p1beta1.GroupFindingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GroupFindings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1.GroupFindingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1.GroupFindingsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("GroupFindings"))
                      .build();
        }
      }
    }
    return getGroupFindingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.ListAssetsRequest,
          com.google.cloud.securitycenter.v1p1beta1.ListAssetsResponse>
      getListAssetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAssets",
      requestType = com.google.cloud.securitycenter.v1p1beta1.ListAssetsRequest.class,
      responseType = com.google.cloud.securitycenter.v1p1beta1.ListAssetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.ListAssetsRequest,
          com.google.cloud.securitycenter.v1p1beta1.ListAssetsResponse>
      getListAssetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1p1beta1.ListAssetsRequest,
            com.google.cloud.securitycenter.v1p1beta1.ListAssetsResponse>
        getListAssetsMethod;
    if ((getListAssetsMethod = SecurityCenterGrpc.getListAssetsMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getListAssetsMethod = SecurityCenterGrpc.getListAssetsMethod) == null) {
          SecurityCenterGrpc.getListAssetsMethod =
              getListAssetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1p1beta1.ListAssetsRequest,
                          com.google.cloud.securitycenter.v1p1beta1.ListAssetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAssets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1.ListAssetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1.ListAssetsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("ListAssets"))
                      .build();
        }
      }
    }
    return getListAssetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.ListFindingsRequest,
          com.google.cloud.securitycenter.v1p1beta1.ListFindingsResponse>
      getListFindingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFindings",
      requestType = com.google.cloud.securitycenter.v1p1beta1.ListFindingsRequest.class,
      responseType = com.google.cloud.securitycenter.v1p1beta1.ListFindingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.ListFindingsRequest,
          com.google.cloud.securitycenter.v1p1beta1.ListFindingsResponse>
      getListFindingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1p1beta1.ListFindingsRequest,
            com.google.cloud.securitycenter.v1p1beta1.ListFindingsResponse>
        getListFindingsMethod;
    if ((getListFindingsMethod = SecurityCenterGrpc.getListFindingsMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getListFindingsMethod = SecurityCenterGrpc.getListFindingsMethod) == null) {
          SecurityCenterGrpc.getListFindingsMethod =
              getListFindingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1p1beta1.ListFindingsRequest,
                          com.google.cloud.securitycenter.v1p1beta1.ListFindingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFindings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1.ListFindingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1.ListFindingsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("ListFindings"))
                      .build();
        }
      }
    }
    return getListFindingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.ListNotificationConfigsRequest,
          com.google.cloud.securitycenter.v1p1beta1.ListNotificationConfigsResponse>
      getListNotificationConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListNotificationConfigs",
      requestType = com.google.cloud.securitycenter.v1p1beta1.ListNotificationConfigsRequest.class,
      responseType =
          com.google.cloud.securitycenter.v1p1beta1.ListNotificationConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.ListNotificationConfigsRequest,
          com.google.cloud.securitycenter.v1p1beta1.ListNotificationConfigsResponse>
      getListNotificationConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1p1beta1.ListNotificationConfigsRequest,
            com.google.cloud.securitycenter.v1p1beta1.ListNotificationConfigsResponse>
        getListNotificationConfigsMethod;
    if ((getListNotificationConfigsMethod = SecurityCenterGrpc.getListNotificationConfigsMethod)
        == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getListNotificationConfigsMethod = SecurityCenterGrpc.getListNotificationConfigsMethod)
            == null) {
          SecurityCenterGrpc.getListNotificationConfigsMethod =
              getListNotificationConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1p1beta1.ListNotificationConfigsRequest,
                          com.google.cloud.securitycenter.v1p1beta1.ListNotificationConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListNotificationConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1
                                  .ListNotificationConfigsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1
                                  .ListNotificationConfigsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("ListNotificationConfigs"))
                      .build();
        }
      }
    }
    return getListNotificationConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.ListSourcesRequest,
          com.google.cloud.securitycenter.v1p1beta1.ListSourcesResponse>
      getListSourcesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSources",
      requestType = com.google.cloud.securitycenter.v1p1beta1.ListSourcesRequest.class,
      responseType = com.google.cloud.securitycenter.v1p1beta1.ListSourcesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.ListSourcesRequest,
          com.google.cloud.securitycenter.v1p1beta1.ListSourcesResponse>
      getListSourcesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1p1beta1.ListSourcesRequest,
            com.google.cloud.securitycenter.v1p1beta1.ListSourcesResponse>
        getListSourcesMethod;
    if ((getListSourcesMethod = SecurityCenterGrpc.getListSourcesMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getListSourcesMethod = SecurityCenterGrpc.getListSourcesMethod) == null) {
          SecurityCenterGrpc.getListSourcesMethod =
              getListSourcesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1p1beta1.ListSourcesRequest,
                          com.google.cloud.securitycenter.v1p1beta1.ListSourcesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSources"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1.ListSourcesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1.ListSourcesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("ListSources"))
                      .build();
        }
      }
    }
    return getListSourcesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.RunAssetDiscoveryRequest,
          com.google.longrunning.Operation>
      getRunAssetDiscoveryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RunAssetDiscovery",
      requestType = com.google.cloud.securitycenter.v1p1beta1.RunAssetDiscoveryRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.RunAssetDiscoveryRequest,
          com.google.longrunning.Operation>
      getRunAssetDiscoveryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1p1beta1.RunAssetDiscoveryRequest,
            com.google.longrunning.Operation>
        getRunAssetDiscoveryMethod;
    if ((getRunAssetDiscoveryMethod = SecurityCenterGrpc.getRunAssetDiscoveryMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getRunAssetDiscoveryMethod = SecurityCenterGrpc.getRunAssetDiscoveryMethod) == null) {
          SecurityCenterGrpc.getRunAssetDiscoveryMethod =
              getRunAssetDiscoveryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1p1beta1.RunAssetDiscoveryRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RunAssetDiscovery"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1.RunAssetDiscoveryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("RunAssetDiscovery"))
                      .build();
        }
      }
    }
    return getRunAssetDiscoveryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.SetFindingStateRequest,
          com.google.cloud.securitycenter.v1p1beta1.Finding>
      getSetFindingStateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetFindingState",
      requestType = com.google.cloud.securitycenter.v1p1beta1.SetFindingStateRequest.class,
      responseType = com.google.cloud.securitycenter.v1p1beta1.Finding.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.SetFindingStateRequest,
          com.google.cloud.securitycenter.v1p1beta1.Finding>
      getSetFindingStateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1p1beta1.SetFindingStateRequest,
            com.google.cloud.securitycenter.v1p1beta1.Finding>
        getSetFindingStateMethod;
    if ((getSetFindingStateMethod = SecurityCenterGrpc.getSetFindingStateMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getSetFindingStateMethod = SecurityCenterGrpc.getSetFindingStateMethod) == null) {
          SecurityCenterGrpc.getSetFindingStateMethod =
              getSetFindingStateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1p1beta1.SetFindingStateRequest,
                          com.google.cloud.securitycenter.v1p1beta1.Finding>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetFindingState"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1.SetFindingStateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1.Finding
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("SetFindingState"))
                      .build();
        }
      }
    }
    return getSetFindingStateMethod;
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
    if ((getSetIamPolicyMethod = SecurityCenterGrpc.getSetIamPolicyMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getSetIamPolicyMethod = SecurityCenterGrpc.getSetIamPolicyMethod) == null) {
          SecurityCenterGrpc.getSetIamPolicyMethod =
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
                          new SecurityCenterMethodDescriptorSupplier("SetIamPolicy"))
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
    if ((getTestIamPermissionsMethod = SecurityCenterGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getTestIamPermissionsMethod = SecurityCenterGrpc.getTestIamPermissionsMethod)
            == null) {
          SecurityCenterGrpc.getTestIamPermissionsMethod =
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
                          new SecurityCenterMethodDescriptorSupplier("TestIamPermissions"))
                      .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.UpdateFindingRequest,
          com.google.cloud.securitycenter.v1p1beta1.Finding>
      getUpdateFindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFinding",
      requestType = com.google.cloud.securitycenter.v1p1beta1.UpdateFindingRequest.class,
      responseType = com.google.cloud.securitycenter.v1p1beta1.Finding.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.UpdateFindingRequest,
          com.google.cloud.securitycenter.v1p1beta1.Finding>
      getUpdateFindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1p1beta1.UpdateFindingRequest,
            com.google.cloud.securitycenter.v1p1beta1.Finding>
        getUpdateFindingMethod;
    if ((getUpdateFindingMethod = SecurityCenterGrpc.getUpdateFindingMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getUpdateFindingMethod = SecurityCenterGrpc.getUpdateFindingMethod) == null) {
          SecurityCenterGrpc.getUpdateFindingMethod =
              getUpdateFindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1p1beta1.UpdateFindingRequest,
                          com.google.cloud.securitycenter.v1p1beta1.Finding>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateFinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1.UpdateFindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1.Finding
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("UpdateFinding"))
                      .build();
        }
      }
    }
    return getUpdateFindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.UpdateNotificationConfigRequest,
          com.google.cloud.securitycenter.v1p1beta1.NotificationConfig>
      getUpdateNotificationConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateNotificationConfig",
      requestType = com.google.cloud.securitycenter.v1p1beta1.UpdateNotificationConfigRequest.class,
      responseType = com.google.cloud.securitycenter.v1p1beta1.NotificationConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.UpdateNotificationConfigRequest,
          com.google.cloud.securitycenter.v1p1beta1.NotificationConfig>
      getUpdateNotificationConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1p1beta1.UpdateNotificationConfigRequest,
            com.google.cloud.securitycenter.v1p1beta1.NotificationConfig>
        getUpdateNotificationConfigMethod;
    if ((getUpdateNotificationConfigMethod = SecurityCenterGrpc.getUpdateNotificationConfigMethod)
        == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getUpdateNotificationConfigMethod =
                SecurityCenterGrpc.getUpdateNotificationConfigMethod)
            == null) {
          SecurityCenterGrpc.getUpdateNotificationConfigMethod =
              getUpdateNotificationConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1p1beta1.UpdateNotificationConfigRequest,
                          com.google.cloud.securitycenter.v1p1beta1.NotificationConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateNotificationConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1
                                  .UpdateNotificationConfigRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1.NotificationConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("UpdateNotificationConfig"))
                      .build();
        }
      }
    }
    return getUpdateNotificationConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.UpdateOrganizationSettingsRequest,
          com.google.cloud.securitycenter.v1p1beta1.OrganizationSettings>
      getUpdateOrganizationSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateOrganizationSettings",
      requestType =
          com.google.cloud.securitycenter.v1p1beta1.UpdateOrganizationSettingsRequest.class,
      responseType = com.google.cloud.securitycenter.v1p1beta1.OrganizationSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.UpdateOrganizationSettingsRequest,
          com.google.cloud.securitycenter.v1p1beta1.OrganizationSettings>
      getUpdateOrganizationSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1p1beta1.UpdateOrganizationSettingsRequest,
            com.google.cloud.securitycenter.v1p1beta1.OrganizationSettings>
        getUpdateOrganizationSettingsMethod;
    if ((getUpdateOrganizationSettingsMethod =
            SecurityCenterGrpc.getUpdateOrganizationSettingsMethod)
        == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getUpdateOrganizationSettingsMethod =
                SecurityCenterGrpc.getUpdateOrganizationSettingsMethod)
            == null) {
          SecurityCenterGrpc.getUpdateOrganizationSettingsMethod =
              getUpdateOrganizationSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1p1beta1.UpdateOrganizationSettingsRequest,
                          com.google.cloud.securitycenter.v1p1beta1.OrganizationSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateOrganizationSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1
                                  .UpdateOrganizationSettingsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1.OrganizationSettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("UpdateOrganizationSettings"))
                      .build();
        }
      }
    }
    return getUpdateOrganizationSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.UpdateSourceRequest,
          com.google.cloud.securitycenter.v1p1beta1.Source>
      getUpdateSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSource",
      requestType = com.google.cloud.securitycenter.v1p1beta1.UpdateSourceRequest.class,
      responseType = com.google.cloud.securitycenter.v1p1beta1.Source.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.UpdateSourceRequest,
          com.google.cloud.securitycenter.v1p1beta1.Source>
      getUpdateSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1p1beta1.UpdateSourceRequest,
            com.google.cloud.securitycenter.v1p1beta1.Source>
        getUpdateSourceMethod;
    if ((getUpdateSourceMethod = SecurityCenterGrpc.getUpdateSourceMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getUpdateSourceMethod = SecurityCenterGrpc.getUpdateSourceMethod) == null) {
          SecurityCenterGrpc.getUpdateSourceMethod =
              getUpdateSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1p1beta1.UpdateSourceRequest,
                          com.google.cloud.securitycenter.v1p1beta1.Source>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1.UpdateSourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1.Source
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("UpdateSource"))
                      .build();
        }
      }
    }
    return getUpdateSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.UpdateSecurityMarksRequest,
          com.google.cloud.securitycenter.v1p1beta1.SecurityMarks>
      getUpdateSecurityMarksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSecurityMarks",
      requestType = com.google.cloud.securitycenter.v1p1beta1.UpdateSecurityMarksRequest.class,
      responseType = com.google.cloud.securitycenter.v1p1beta1.SecurityMarks.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1p1beta1.UpdateSecurityMarksRequest,
          com.google.cloud.securitycenter.v1p1beta1.SecurityMarks>
      getUpdateSecurityMarksMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1p1beta1.UpdateSecurityMarksRequest,
            com.google.cloud.securitycenter.v1p1beta1.SecurityMarks>
        getUpdateSecurityMarksMethod;
    if ((getUpdateSecurityMarksMethod = SecurityCenterGrpc.getUpdateSecurityMarksMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getUpdateSecurityMarksMethod = SecurityCenterGrpc.getUpdateSecurityMarksMethod)
            == null) {
          SecurityCenterGrpc.getUpdateSecurityMarksMethod =
              getUpdateSecurityMarksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1p1beta1.UpdateSecurityMarksRequest,
                          com.google.cloud.securitycenter.v1p1beta1.SecurityMarks>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateSecurityMarks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1.UpdateSecurityMarksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1p1beta1.SecurityMarks
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("UpdateSecurityMarks"))
                      .build();
        }
      }
    }
    return getUpdateSecurityMarksMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SecurityCenterStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecurityCenterStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SecurityCenterStub>() {
          @java.lang.Override
          public SecurityCenterStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SecurityCenterStub(channel, callOptions);
          }
        };
    return SecurityCenterStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SecurityCenterBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecurityCenterBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SecurityCenterBlockingStub>() {
          @java.lang.Override
          public SecurityCenterBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SecurityCenterBlockingStub(channel, callOptions);
          }
        };
    return SecurityCenterBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SecurityCenterFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecurityCenterFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SecurityCenterFutureStub>() {
          @java.lang.Override
          public SecurityCenterFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SecurityCenterFutureStub(channel, callOptions);
          }
        };
    return SecurityCenterFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * V1p1Beta1 APIs for Security Center service.
   * </pre>
   */
  public abstract static class SecurityCenterImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a source.
     * </pre>
     */
    public void createSource(
        com.google.cloud.securitycenter.v1p1beta1.CreateSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.Source>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a finding. The corresponding source must exist for finding
     * creation to succeed.
     * </pre>
     */
    public void createFinding(
        com.google.cloud.securitycenter.v1p1beta1.CreateFindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.Finding>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateFindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a notification config.
     * </pre>
     */
    public void createNotificationConfig(
        com.google.cloud.securitycenter.v1p1beta1.CreateNotificationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.NotificationConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateNotificationConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a notification config.
     * </pre>
     */
    public void deleteNotificationConfig(
        com.google.cloud.securitycenter.v1p1beta1.DeleteNotificationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteNotificationConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy on the specified Source.
     * </pre>
     */
    public void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a notification config.
     * </pre>
     */
    public void getNotificationConfig(
        com.google.cloud.securitycenter.v1p1beta1.GetNotificationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.NotificationConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetNotificationConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the settings for an organization.
     * </pre>
     */
    public void getOrganizationSettings(
        com.google.cloud.securitycenter.v1p1beta1.GetOrganizationSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.OrganizationSettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetOrganizationSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a source.
     * </pre>
     */
    public void getSource(
        com.google.cloud.securitycenter.v1p1beta1.GetSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.Source>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Filters an organization's assets and  groups them by their specified
     * properties.
     * </pre>
     */
    public void groupAssets(
        com.google.cloud.securitycenter.v1p1beta1.GroupAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.GroupAssetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGroupAssetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Filters an organization or source's findings and  groups them by their
     * specified properties.
     * To group across all sources provide a `-` as the source id.
     * Example: /v1/organizations/{organization_id}/sources/-/findings,
     * /v1/folders/{folder_id}/sources/-/findings,
     * /v1/projects/{project_id}/sources/-/findings
     * </pre>
     */
    public void groupFindings(
        com.google.cloud.securitycenter.v1p1beta1.GroupFindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.GroupFindingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGroupFindingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists an organization's assets.
     * </pre>
     */
    public void listAssets(
        com.google.cloud.securitycenter.v1p1beta1.ListAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.ListAssetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAssetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists an organization or source's findings.
     * To list across all sources provide a `-` as the source id.
     * Example: /v1p1beta1/organizations/{organization_id}/sources/-/findings
     * </pre>
     */
    public void listFindings(
        com.google.cloud.securitycenter.v1p1beta1.ListFindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.ListFindingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListFindingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists notification configs.
     * </pre>
     */
    public void listNotificationConfigs(
        com.google.cloud.securitycenter.v1p1beta1.ListNotificationConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycenter.v1p1beta1.ListNotificationConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListNotificationConfigsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all sources belonging to an organization.
     * </pre>
     */
    public void listSources(
        com.google.cloud.securitycenter.v1p1beta1.ListSourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.ListSourcesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSourcesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Runs asset discovery. The discovery is tracked with a long-running
     * operation.
     * This API can only be called with limited frequency for an organization. If
     * it is called too frequently the caller will receive a TOO_MANY_REQUESTS
     * error.
     * </pre>
     */
    public void runAssetDiscovery(
        com.google.cloud.securitycenter.v1p1beta1.RunAssetDiscoveryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRunAssetDiscoveryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the state of a finding.
     * </pre>
     */
    public void setFindingState(
        com.google.cloud.securitycenter.v1p1beta1.SetFindingStateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.Finding>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetFindingStateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on the specified Source.
     * </pre>
     */
    public void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the permissions that a caller has on the specified source.
     * </pre>
     */
    public void testIamPermissions(
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
     * Creates or updates a finding. The corresponding source must exist for a
     * finding creation to succeed.
     * </pre>
     */
    public void updateFinding(
        com.google.cloud.securitycenter.v1p1beta1.UpdateFindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.Finding>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateFindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a notification config. The following update
     * fields are allowed: description, pubsub_topic, streaming_config.filter
     * </pre>
     */
    public void updateNotificationConfig(
        com.google.cloud.securitycenter.v1p1beta1.UpdateNotificationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.NotificationConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateNotificationConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an organization's settings.
     * </pre>
     */
    public void updateOrganizationSettings(
        com.google.cloud.securitycenter.v1p1beta1.UpdateOrganizationSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.OrganizationSettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateOrganizationSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a source.
     * </pre>
     */
    public void updateSource(
        com.google.cloud.securitycenter.v1p1beta1.UpdateSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.Source>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates security marks.
     * </pre>
     */
    public void updateSecurityMarks(
        com.google.cloud.securitycenter.v1p1beta1.UpdateSecurityMarksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.SecurityMarks>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSecurityMarksMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateSourceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1p1beta1.CreateSourceRequest,
                      com.google.cloud.securitycenter.v1p1beta1.Source>(
                      this, METHODID_CREATE_SOURCE)))
          .addMethod(
              getCreateFindingMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1p1beta1.CreateFindingRequest,
                      com.google.cloud.securitycenter.v1p1beta1.Finding>(
                      this, METHODID_CREATE_FINDING)))
          .addMethod(
              getCreateNotificationConfigMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1p1beta1.CreateNotificationConfigRequest,
                      com.google.cloud.securitycenter.v1p1beta1.NotificationConfig>(
                      this, METHODID_CREATE_NOTIFICATION_CONFIG)))
          .addMethod(
              getDeleteNotificationConfigMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1p1beta1.DeleteNotificationConfigRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_NOTIFICATION_CONFIG)))
          .addMethod(
              getGetIamPolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>(
                      this, METHODID_GET_IAM_POLICY)))
          .addMethod(
              getGetNotificationConfigMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1p1beta1.GetNotificationConfigRequest,
                      com.google.cloud.securitycenter.v1p1beta1.NotificationConfig>(
                      this, METHODID_GET_NOTIFICATION_CONFIG)))
          .addMethod(
              getGetOrganizationSettingsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1p1beta1.GetOrganizationSettingsRequest,
                      com.google.cloud.securitycenter.v1p1beta1.OrganizationSettings>(
                      this, METHODID_GET_ORGANIZATION_SETTINGS)))
          .addMethod(
              getGetSourceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1p1beta1.GetSourceRequest,
                      com.google.cloud.securitycenter.v1p1beta1.Source>(this, METHODID_GET_SOURCE)))
          .addMethod(
              getGroupAssetsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1p1beta1.GroupAssetsRequest,
                      com.google.cloud.securitycenter.v1p1beta1.GroupAssetsResponse>(
                      this, METHODID_GROUP_ASSETS)))
          .addMethod(
              getGroupFindingsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1p1beta1.GroupFindingsRequest,
                      com.google.cloud.securitycenter.v1p1beta1.GroupFindingsResponse>(
                      this, METHODID_GROUP_FINDINGS)))
          .addMethod(
              getListAssetsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1p1beta1.ListAssetsRequest,
                      com.google.cloud.securitycenter.v1p1beta1.ListAssetsResponse>(
                      this, METHODID_LIST_ASSETS)))
          .addMethod(
              getListFindingsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1p1beta1.ListFindingsRequest,
                      com.google.cloud.securitycenter.v1p1beta1.ListFindingsResponse>(
                      this, METHODID_LIST_FINDINGS)))
          .addMethod(
              getListNotificationConfigsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1p1beta1.ListNotificationConfigsRequest,
                      com.google.cloud.securitycenter.v1p1beta1.ListNotificationConfigsResponse>(
                      this, METHODID_LIST_NOTIFICATION_CONFIGS)))
          .addMethod(
              getListSourcesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1p1beta1.ListSourcesRequest,
                      com.google.cloud.securitycenter.v1p1beta1.ListSourcesResponse>(
                      this, METHODID_LIST_SOURCES)))
          .addMethod(
              getRunAssetDiscoveryMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1p1beta1.RunAssetDiscoveryRequest,
                      com.google.longrunning.Operation>(this, METHODID_RUN_ASSET_DISCOVERY)))
          .addMethod(
              getSetFindingStateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1p1beta1.SetFindingStateRequest,
                      com.google.cloud.securitycenter.v1p1beta1.Finding>(
                      this, METHODID_SET_FINDING_STATE)))
          .addMethod(
              getSetIamPolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>(
                      this, METHODID_SET_IAM_POLICY)))
          .addMethod(
              getTestIamPermissionsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.TestIamPermissionsRequest,
                      com.google.iam.v1.TestIamPermissionsResponse>(
                      this, METHODID_TEST_IAM_PERMISSIONS)))
          .addMethod(
              getUpdateFindingMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1p1beta1.UpdateFindingRequest,
                      com.google.cloud.securitycenter.v1p1beta1.Finding>(
                      this, METHODID_UPDATE_FINDING)))
          .addMethod(
              getUpdateNotificationConfigMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1p1beta1.UpdateNotificationConfigRequest,
                      com.google.cloud.securitycenter.v1p1beta1.NotificationConfig>(
                      this, METHODID_UPDATE_NOTIFICATION_CONFIG)))
          .addMethod(
              getUpdateOrganizationSettingsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1p1beta1.UpdateOrganizationSettingsRequest,
                      com.google.cloud.securitycenter.v1p1beta1.OrganizationSettings>(
                      this, METHODID_UPDATE_ORGANIZATION_SETTINGS)))
          .addMethod(
              getUpdateSourceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1p1beta1.UpdateSourceRequest,
                      com.google.cloud.securitycenter.v1p1beta1.Source>(
                      this, METHODID_UPDATE_SOURCE)))
          .addMethod(
              getUpdateSecurityMarksMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1p1beta1.UpdateSecurityMarksRequest,
                      com.google.cloud.securitycenter.v1p1beta1.SecurityMarks>(
                      this, METHODID_UPDATE_SECURITY_MARKS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * V1p1Beta1 APIs for Security Center service.
   * </pre>
   */
  public static final class SecurityCenterStub
      extends io.grpc.stub.AbstractAsyncStub<SecurityCenterStub> {
    private SecurityCenterStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecurityCenterStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecurityCenterStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a source.
     * </pre>
     */
    public void createSource(
        com.google.cloud.securitycenter.v1p1beta1.CreateSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.Source>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a finding. The corresponding source must exist for finding
     * creation to succeed.
     * </pre>
     */
    public void createFinding(
        com.google.cloud.securitycenter.v1p1beta1.CreateFindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.Finding>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a notification config.
     * </pre>
     */
    public void createNotificationConfig(
        com.google.cloud.securitycenter.v1p1beta1.CreateNotificationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.NotificationConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateNotificationConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a notification config.
     * </pre>
     */
    public void deleteNotificationConfig(
        com.google.cloud.securitycenter.v1p1beta1.DeleteNotificationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteNotificationConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy on the specified Source.
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
     * Gets a notification config.
     * </pre>
     */
    public void getNotificationConfig(
        com.google.cloud.securitycenter.v1p1beta1.GetNotificationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.NotificationConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNotificationConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the settings for an organization.
     * </pre>
     */
    public void getOrganizationSettings(
        com.google.cloud.securitycenter.v1p1beta1.GetOrganizationSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.OrganizationSettings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOrganizationSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a source.
     * </pre>
     */
    public void getSource(
        com.google.cloud.securitycenter.v1p1beta1.GetSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.Source>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSourceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Filters an organization's assets and  groups them by their specified
     * properties.
     * </pre>
     */
    public void groupAssets(
        com.google.cloud.securitycenter.v1p1beta1.GroupAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.GroupAssetsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGroupAssetsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Filters an organization or source's findings and  groups them by their
     * specified properties.
     * To group across all sources provide a `-` as the source id.
     * Example: /v1/organizations/{organization_id}/sources/-/findings,
     * /v1/folders/{folder_id}/sources/-/findings,
     * /v1/projects/{project_id}/sources/-/findings
     * </pre>
     */
    public void groupFindings(
        com.google.cloud.securitycenter.v1p1beta1.GroupFindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.GroupFindingsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGroupFindingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists an organization's assets.
     * </pre>
     */
    public void listAssets(
        com.google.cloud.securitycenter.v1p1beta1.ListAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.ListAssetsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAssetsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists an organization or source's findings.
     * To list across all sources provide a `-` as the source id.
     * Example: /v1p1beta1/organizations/{organization_id}/sources/-/findings
     * </pre>
     */
    public void listFindings(
        com.google.cloud.securitycenter.v1p1beta1.ListFindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.ListFindingsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFindingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists notification configs.
     * </pre>
     */
    public void listNotificationConfigs(
        com.google.cloud.securitycenter.v1p1beta1.ListNotificationConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycenter.v1p1beta1.ListNotificationConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListNotificationConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all sources belonging to an organization.
     * </pre>
     */
    public void listSources(
        com.google.cloud.securitycenter.v1p1beta1.ListSourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.ListSourcesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSourcesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Runs asset discovery. The discovery is tracked with a long-running
     * operation.
     * This API can only be called with limited frequency for an organization. If
     * it is called too frequently the caller will receive a TOO_MANY_REQUESTS
     * error.
     * </pre>
     */
    public void runAssetDiscovery(
        com.google.cloud.securitycenter.v1p1beta1.RunAssetDiscoveryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRunAssetDiscoveryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the state of a finding.
     * </pre>
     */
    public void setFindingState(
        com.google.cloud.securitycenter.v1p1beta1.SetFindingStateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.Finding>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetFindingStateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on the specified Source.
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
     * Returns the permissions that a caller has on the specified source.
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
     * Creates or updates a finding. The corresponding source must exist for a
     * finding creation to succeed.
     * </pre>
     */
    public void updateFinding(
        com.google.cloud.securitycenter.v1p1beta1.UpdateFindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.Finding>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a notification config. The following update
     * fields are allowed: description, pubsub_topic, streaming_config.filter
     * </pre>
     */
    public void updateNotificationConfig(
        com.google.cloud.securitycenter.v1p1beta1.UpdateNotificationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.NotificationConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateNotificationConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an organization's settings.
     * </pre>
     */
    public void updateOrganizationSettings(
        com.google.cloud.securitycenter.v1p1beta1.UpdateOrganizationSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.OrganizationSettings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateOrganizationSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a source.
     * </pre>
     */
    public void updateSource(
        com.google.cloud.securitycenter.v1p1beta1.UpdateSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.Source>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates security marks.
     * </pre>
     */
    public void updateSecurityMarks(
        com.google.cloud.securitycenter.v1p1beta1.UpdateSecurityMarksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.SecurityMarks>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSecurityMarksMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * V1p1Beta1 APIs for Security Center service.
   * </pre>
   */
  public static final class SecurityCenterBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SecurityCenterBlockingStub> {
    private SecurityCenterBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecurityCenterBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecurityCenterBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a source.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1p1beta1.Source createSource(
        com.google.cloud.securitycenter.v1p1beta1.CreateSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a finding. The corresponding source must exist for finding
     * creation to succeed.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1p1beta1.Finding createFinding(
        com.google.cloud.securitycenter.v1p1beta1.CreateFindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a notification config.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1p1beta1.NotificationConfig createNotificationConfig(
        com.google.cloud.securitycenter.v1p1beta1.CreateNotificationConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateNotificationConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a notification config.
     * </pre>
     */
    public com.google.protobuf.Empty deleteNotificationConfig(
        com.google.cloud.securitycenter.v1p1beta1.DeleteNotificationConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteNotificationConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy on the specified Source.
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
     * Gets a notification config.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1p1beta1.NotificationConfig getNotificationConfig(
        com.google.cloud.securitycenter.v1p1beta1.GetNotificationConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNotificationConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the settings for an organization.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1p1beta1.OrganizationSettings getOrganizationSettings(
        com.google.cloud.securitycenter.v1p1beta1.GetOrganizationSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOrganizationSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a source.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1p1beta1.Source getSource(
        com.google.cloud.securitycenter.v1p1beta1.GetSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Filters an organization's assets and  groups them by their specified
     * properties.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1p1beta1.GroupAssetsResponse groupAssets(
        com.google.cloud.securitycenter.v1p1beta1.GroupAssetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGroupAssetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Filters an organization or source's findings and  groups them by their
     * specified properties.
     * To group across all sources provide a `-` as the source id.
     * Example: /v1/organizations/{organization_id}/sources/-/findings,
     * /v1/folders/{folder_id}/sources/-/findings,
     * /v1/projects/{project_id}/sources/-/findings
     * </pre>
     */
    public com.google.cloud.securitycenter.v1p1beta1.GroupFindingsResponse groupFindings(
        com.google.cloud.securitycenter.v1p1beta1.GroupFindingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGroupFindingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists an organization's assets.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1p1beta1.ListAssetsResponse listAssets(
        com.google.cloud.securitycenter.v1p1beta1.ListAssetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAssetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists an organization or source's findings.
     * To list across all sources provide a `-` as the source id.
     * Example: /v1p1beta1/organizations/{organization_id}/sources/-/findings
     * </pre>
     */
    public com.google.cloud.securitycenter.v1p1beta1.ListFindingsResponse listFindings(
        com.google.cloud.securitycenter.v1p1beta1.ListFindingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFindingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists notification configs.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1p1beta1.ListNotificationConfigsResponse
        listNotificationConfigs(
            com.google.cloud.securitycenter.v1p1beta1.ListNotificationConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListNotificationConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all sources belonging to an organization.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1p1beta1.ListSourcesResponse listSources(
        com.google.cloud.securitycenter.v1p1beta1.ListSourcesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSourcesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Runs asset discovery. The discovery is tracked with a long-running
     * operation.
     * This API can only be called with limited frequency for an organization. If
     * it is called too frequently the caller will receive a TOO_MANY_REQUESTS
     * error.
     * </pre>
     */
    public com.google.longrunning.Operation runAssetDiscovery(
        com.google.cloud.securitycenter.v1p1beta1.RunAssetDiscoveryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRunAssetDiscoveryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the state of a finding.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1p1beta1.Finding setFindingState(
        com.google.cloud.securitycenter.v1p1beta1.SetFindingStateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetFindingStateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on the specified Source.
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
     * Returns the permissions that a caller has on the specified source.
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
     * Creates or updates a finding. The corresponding source must exist for a
     * finding creation to succeed.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1p1beta1.Finding updateFinding(
        com.google.cloud.securitycenter.v1p1beta1.UpdateFindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a notification config. The following update
     * fields are allowed: description, pubsub_topic, streaming_config.filter
     * </pre>
     */
    public com.google.cloud.securitycenter.v1p1beta1.NotificationConfig updateNotificationConfig(
        com.google.cloud.securitycenter.v1p1beta1.UpdateNotificationConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateNotificationConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an organization's settings.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1p1beta1.OrganizationSettings
        updateOrganizationSettings(
            com.google.cloud.securitycenter.v1p1beta1.UpdateOrganizationSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateOrganizationSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a source.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1p1beta1.Source updateSource(
        com.google.cloud.securitycenter.v1p1beta1.UpdateSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates security marks.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1p1beta1.SecurityMarks updateSecurityMarks(
        com.google.cloud.securitycenter.v1p1beta1.UpdateSecurityMarksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSecurityMarksMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * V1p1Beta1 APIs for Security Center service.
   * </pre>
   */
  public static final class SecurityCenterFutureStub
      extends io.grpc.stub.AbstractFutureStub<SecurityCenterFutureStub> {
    private SecurityCenterFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecurityCenterFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecurityCenterFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v1p1beta1.Source>
        createSource(com.google.cloud.securitycenter.v1p1beta1.CreateSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a finding. The corresponding source must exist for finding
     * creation to succeed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v1p1beta1.Finding>
        createFinding(com.google.cloud.securitycenter.v1p1beta1.CreateFindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a notification config.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v1p1beta1.NotificationConfig>
        createNotificationConfig(
            com.google.cloud.securitycenter.v1p1beta1.CreateNotificationConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateNotificationConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a notification config.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteNotificationConfig(
            com.google.cloud.securitycenter.v1p1beta1.DeleteNotificationConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteNotificationConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy on the specified Source.
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
     * Gets a notification config.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v1p1beta1.NotificationConfig>
        getNotificationConfig(
            com.google.cloud.securitycenter.v1p1beta1.GetNotificationConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNotificationConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the settings for an organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v1p1beta1.OrganizationSettings>
        getOrganizationSettings(
            com.google.cloud.securitycenter.v1p1beta1.GetOrganizationSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOrganizationSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v1p1beta1.Source>
        getSource(com.google.cloud.securitycenter.v1p1beta1.GetSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Filters an organization's assets and  groups them by their specified
     * properties.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v1p1beta1.GroupAssetsResponse>
        groupAssets(com.google.cloud.securitycenter.v1p1beta1.GroupAssetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGroupAssetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Filters an organization or source's findings and  groups them by their
     * specified properties.
     * To group across all sources provide a `-` as the source id.
     * Example: /v1/organizations/{organization_id}/sources/-/findings,
     * /v1/folders/{folder_id}/sources/-/findings,
     * /v1/projects/{project_id}/sources/-/findings
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v1p1beta1.GroupFindingsResponse>
        groupFindings(com.google.cloud.securitycenter.v1p1beta1.GroupFindingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGroupFindingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists an organization's assets.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v1p1beta1.ListAssetsResponse>
        listAssets(com.google.cloud.securitycenter.v1p1beta1.ListAssetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAssetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists an organization or source's findings.
     * To list across all sources provide a `-` as the source id.
     * Example: /v1p1beta1/organizations/{organization_id}/sources/-/findings
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v1p1beta1.ListFindingsResponse>
        listFindings(com.google.cloud.securitycenter.v1p1beta1.ListFindingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFindingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists notification configs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v1p1beta1.ListNotificationConfigsResponse>
        listNotificationConfigs(
            com.google.cloud.securitycenter.v1p1beta1.ListNotificationConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListNotificationConfigsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all sources belonging to an organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v1p1beta1.ListSourcesResponse>
        listSources(com.google.cloud.securitycenter.v1p1beta1.ListSourcesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSourcesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Runs asset discovery. The discovery is tracked with a long-running
     * operation.
     * This API can only be called with limited frequency for an organization. If
     * it is called too frequently the caller will receive a TOO_MANY_REQUESTS
     * error.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        runAssetDiscovery(
            com.google.cloud.securitycenter.v1p1beta1.RunAssetDiscoveryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRunAssetDiscoveryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the state of a finding.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v1p1beta1.Finding>
        setFindingState(com.google.cloud.securitycenter.v1p1beta1.SetFindingStateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetFindingStateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on the specified Source.
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
     * Returns the permissions that a caller has on the specified source.
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
     * Creates or updates a finding. The corresponding source must exist for a
     * finding creation to succeed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v1p1beta1.Finding>
        updateFinding(com.google.cloud.securitycenter.v1p1beta1.UpdateFindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateFindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a notification config. The following update
     * fields are allowed: description, pubsub_topic, streaming_config.filter
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v1p1beta1.NotificationConfig>
        updateNotificationConfig(
            com.google.cloud.securitycenter.v1p1beta1.UpdateNotificationConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateNotificationConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an organization's settings.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v1p1beta1.OrganizationSettings>
        updateOrganizationSettings(
            com.google.cloud.securitycenter.v1p1beta1.UpdateOrganizationSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateOrganizationSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v1p1beta1.Source>
        updateSource(com.google.cloud.securitycenter.v1p1beta1.UpdateSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates security marks.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v1p1beta1.SecurityMarks>
        updateSecurityMarks(
            com.google.cloud.securitycenter.v1p1beta1.UpdateSecurityMarksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSecurityMarksMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SOURCE = 0;
  private static final int METHODID_CREATE_FINDING = 1;
  private static final int METHODID_CREATE_NOTIFICATION_CONFIG = 2;
  private static final int METHODID_DELETE_NOTIFICATION_CONFIG = 3;
  private static final int METHODID_GET_IAM_POLICY = 4;
  private static final int METHODID_GET_NOTIFICATION_CONFIG = 5;
  private static final int METHODID_GET_ORGANIZATION_SETTINGS = 6;
  private static final int METHODID_GET_SOURCE = 7;
  private static final int METHODID_GROUP_ASSETS = 8;
  private static final int METHODID_GROUP_FINDINGS = 9;
  private static final int METHODID_LIST_ASSETS = 10;
  private static final int METHODID_LIST_FINDINGS = 11;
  private static final int METHODID_LIST_NOTIFICATION_CONFIGS = 12;
  private static final int METHODID_LIST_SOURCES = 13;
  private static final int METHODID_RUN_ASSET_DISCOVERY = 14;
  private static final int METHODID_SET_FINDING_STATE = 15;
  private static final int METHODID_SET_IAM_POLICY = 16;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 17;
  private static final int METHODID_UPDATE_FINDING = 18;
  private static final int METHODID_UPDATE_NOTIFICATION_CONFIG = 19;
  private static final int METHODID_UPDATE_ORGANIZATION_SETTINGS = 20;
  private static final int METHODID_UPDATE_SOURCE = 21;
  private static final int METHODID_UPDATE_SECURITY_MARKS = 22;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SecurityCenterImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SecurityCenterImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_SOURCE:
          serviceImpl.createSource(
              (com.google.cloud.securitycenter.v1p1beta1.CreateSourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.Source>)
                  responseObserver);
          break;
        case METHODID_CREATE_FINDING:
          serviceImpl.createFinding(
              (com.google.cloud.securitycenter.v1p1beta1.CreateFindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.Finding>)
                  responseObserver);
          break;
        case METHODID_CREATE_NOTIFICATION_CONFIG:
          serviceImpl.createNotificationConfig(
              (com.google.cloud.securitycenter.v1p1beta1.CreateNotificationConfigRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycenter.v1p1beta1.NotificationConfig>)
                  responseObserver);
          break;
        case METHODID_DELETE_NOTIFICATION_CONFIG:
          serviceImpl.deleteNotificationConfig(
              (com.google.cloud.securitycenter.v1p1beta1.DeleteNotificationConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy(
              (com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_GET_NOTIFICATION_CONFIG:
          serviceImpl.getNotificationConfig(
              (com.google.cloud.securitycenter.v1p1beta1.GetNotificationConfigRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycenter.v1p1beta1.NotificationConfig>)
                  responseObserver);
          break;
        case METHODID_GET_ORGANIZATION_SETTINGS:
          serviceImpl.getOrganizationSettings(
              (com.google.cloud.securitycenter.v1p1beta1.GetOrganizationSettingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycenter.v1p1beta1.OrganizationSettings>)
                  responseObserver);
          break;
        case METHODID_GET_SOURCE:
          serviceImpl.getSource(
              (com.google.cloud.securitycenter.v1p1beta1.GetSourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.Source>)
                  responseObserver);
          break;
        case METHODID_GROUP_ASSETS:
          serviceImpl.groupAssets(
              (com.google.cloud.securitycenter.v1p1beta1.GroupAssetsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycenter.v1p1beta1.GroupAssetsResponse>)
                  responseObserver);
          break;
        case METHODID_GROUP_FINDINGS:
          serviceImpl.groupFindings(
              (com.google.cloud.securitycenter.v1p1beta1.GroupFindingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycenter.v1p1beta1.GroupFindingsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_ASSETS:
          serviceImpl.listAssets(
              (com.google.cloud.securitycenter.v1p1beta1.ListAssetsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycenter.v1p1beta1.ListAssetsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_FINDINGS:
          serviceImpl.listFindings(
              (com.google.cloud.securitycenter.v1p1beta1.ListFindingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycenter.v1p1beta1.ListFindingsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_NOTIFICATION_CONFIGS:
          serviceImpl.listNotificationConfigs(
              (com.google.cloud.securitycenter.v1p1beta1.ListNotificationConfigsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycenter.v1p1beta1.ListNotificationConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_SOURCES:
          serviceImpl.listSources(
              (com.google.cloud.securitycenter.v1p1beta1.ListSourcesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycenter.v1p1beta1.ListSourcesResponse>)
                  responseObserver);
          break;
        case METHODID_RUN_ASSET_DISCOVERY:
          serviceImpl.runAssetDiscovery(
              (com.google.cloud.securitycenter.v1p1beta1.RunAssetDiscoveryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_SET_FINDING_STATE:
          serviceImpl.setFindingState(
              (com.google.cloud.securitycenter.v1p1beta1.SetFindingStateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.Finding>)
                  responseObserver);
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
        case METHODID_UPDATE_FINDING:
          serviceImpl.updateFinding(
              (com.google.cloud.securitycenter.v1p1beta1.UpdateFindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.Finding>)
                  responseObserver);
          break;
        case METHODID_UPDATE_NOTIFICATION_CONFIG:
          serviceImpl.updateNotificationConfig(
              (com.google.cloud.securitycenter.v1p1beta1.UpdateNotificationConfigRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycenter.v1p1beta1.NotificationConfig>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ORGANIZATION_SETTINGS:
          serviceImpl.updateOrganizationSettings(
              (com.google.cloud.securitycenter.v1p1beta1.UpdateOrganizationSettingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycenter.v1p1beta1.OrganizationSettings>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SOURCE:
          serviceImpl.updateSource(
              (com.google.cloud.securitycenter.v1p1beta1.UpdateSourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.Source>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SECURITY_MARKS:
          serviceImpl.updateSecurityMarks(
              (com.google.cloud.securitycenter.v1p1beta1.UpdateSecurityMarksRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1p1beta1.SecurityMarks>)
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

  private abstract static class SecurityCenterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SecurityCenterBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.securitycenter.v1p1beta1.SecuritycenterService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SecurityCenter");
    }
  }

  private static final class SecurityCenterFileDescriptorSupplier
      extends SecurityCenterBaseDescriptorSupplier {
    SecurityCenterFileDescriptorSupplier() {}
  }

  private static final class SecurityCenterMethodDescriptorSupplier
      extends SecurityCenterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SecurityCenterMethodDescriptorSupplier(String methodName) {
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
      synchronized (SecurityCenterGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SecurityCenterFileDescriptorSupplier())
                      .addMethod(getCreateSourceMethod())
                      .addMethod(getCreateFindingMethod())
                      .addMethod(getCreateNotificationConfigMethod())
                      .addMethod(getDeleteNotificationConfigMethod())
                      .addMethod(getGetIamPolicyMethod())
                      .addMethod(getGetNotificationConfigMethod())
                      .addMethod(getGetOrganizationSettingsMethod())
                      .addMethod(getGetSourceMethod())
                      .addMethod(getGroupAssetsMethod())
                      .addMethod(getGroupFindingsMethod())
                      .addMethod(getListAssetsMethod())
                      .addMethod(getListFindingsMethod())
                      .addMethod(getListNotificationConfigsMethod())
                      .addMethod(getListSourcesMethod())
                      .addMethod(getRunAssetDiscoveryMethod())
                      .addMethod(getSetFindingStateMethod())
                      .addMethod(getSetIamPolicyMethod())
                      .addMethod(getTestIamPermissionsMethod())
                      .addMethod(getUpdateFindingMethod())
                      .addMethod(getUpdateNotificationConfigMethod())
                      .addMethod(getUpdateOrganizationSettingsMethod())
                      .addMethod(getUpdateSourceMethod())
                      .addMethod(getUpdateSecurityMarksMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
