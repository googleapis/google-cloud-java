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
package com.google.cloud.iap.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * APIs for Identity-Aware Proxy Admin configurations.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/iap/v1/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class IdentityAwareProxyAdminServiceGrpc {

  private IdentityAwareProxyAdminServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.iap.v1.IdentityAwareProxyAdminService";

  // Static method descriptors that strictly reflect the proto.
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
    if ((getSetIamPolicyMethod = IdentityAwareProxyAdminServiceGrpc.getSetIamPolicyMethod)
        == null) {
      synchronized (IdentityAwareProxyAdminServiceGrpc.class) {
        if ((getSetIamPolicyMethod = IdentityAwareProxyAdminServiceGrpc.getSetIamPolicyMethod)
            == null) {
          IdentityAwareProxyAdminServiceGrpc.getSetIamPolicyMethod =
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
                          new IdentityAwareProxyAdminServiceMethodDescriptorSupplier(
                              "SetIamPolicy"))
                      .build();
        }
      }
    }
    return getSetIamPolicyMethod;
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
    if ((getGetIamPolicyMethod = IdentityAwareProxyAdminServiceGrpc.getGetIamPolicyMethod)
        == null) {
      synchronized (IdentityAwareProxyAdminServiceGrpc.class) {
        if ((getGetIamPolicyMethod = IdentityAwareProxyAdminServiceGrpc.getGetIamPolicyMethod)
            == null) {
          IdentityAwareProxyAdminServiceGrpc.getGetIamPolicyMethod =
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
                          new IdentityAwareProxyAdminServiceMethodDescriptorSupplier(
                              "GetIamPolicy"))
                      .build();
        }
      }
    }
    return getGetIamPolicyMethod;
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
    if ((getTestIamPermissionsMethod =
            IdentityAwareProxyAdminServiceGrpc.getTestIamPermissionsMethod)
        == null) {
      synchronized (IdentityAwareProxyAdminServiceGrpc.class) {
        if ((getTestIamPermissionsMethod =
                IdentityAwareProxyAdminServiceGrpc.getTestIamPermissionsMethod)
            == null) {
          IdentityAwareProxyAdminServiceGrpc.getTestIamPermissionsMethod =
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
                          new IdentityAwareProxyAdminServiceMethodDescriptorSupplier(
                              "TestIamPermissions"))
                      .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iap.v1.GetIapSettingsRequest, com.google.cloud.iap.v1.IapSettings>
      getGetIapSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIapSettings",
      requestType = com.google.cloud.iap.v1.GetIapSettingsRequest.class,
      responseType = com.google.cloud.iap.v1.IapSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iap.v1.GetIapSettingsRequest, com.google.cloud.iap.v1.IapSettings>
      getGetIapSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.iap.v1.GetIapSettingsRequest, com.google.cloud.iap.v1.IapSettings>
        getGetIapSettingsMethod;
    if ((getGetIapSettingsMethod = IdentityAwareProxyAdminServiceGrpc.getGetIapSettingsMethod)
        == null) {
      synchronized (IdentityAwareProxyAdminServiceGrpc.class) {
        if ((getGetIapSettingsMethod = IdentityAwareProxyAdminServiceGrpc.getGetIapSettingsMethod)
            == null) {
          IdentityAwareProxyAdminServiceGrpc.getGetIapSettingsMethod =
              getGetIapSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iap.v1.GetIapSettingsRequest,
                          com.google.cloud.iap.v1.IapSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIapSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iap.v1.GetIapSettingsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iap.v1.IapSettings.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IdentityAwareProxyAdminServiceMethodDescriptorSupplier(
                              "GetIapSettings"))
                      .build();
        }
      }
    }
    return getGetIapSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iap.v1.UpdateIapSettingsRequest, com.google.cloud.iap.v1.IapSettings>
      getUpdateIapSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateIapSettings",
      requestType = com.google.cloud.iap.v1.UpdateIapSettingsRequest.class,
      responseType = com.google.cloud.iap.v1.IapSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iap.v1.UpdateIapSettingsRequest, com.google.cloud.iap.v1.IapSettings>
      getUpdateIapSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.iap.v1.UpdateIapSettingsRequest, com.google.cloud.iap.v1.IapSettings>
        getUpdateIapSettingsMethod;
    if ((getUpdateIapSettingsMethod = IdentityAwareProxyAdminServiceGrpc.getUpdateIapSettingsMethod)
        == null) {
      synchronized (IdentityAwareProxyAdminServiceGrpc.class) {
        if ((getUpdateIapSettingsMethod =
                IdentityAwareProxyAdminServiceGrpc.getUpdateIapSettingsMethod)
            == null) {
          IdentityAwareProxyAdminServiceGrpc.getUpdateIapSettingsMethod =
              getUpdateIapSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iap.v1.UpdateIapSettingsRequest,
                          com.google.cloud.iap.v1.IapSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateIapSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iap.v1.UpdateIapSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iap.v1.IapSettings.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IdentityAwareProxyAdminServiceMethodDescriptorSupplier(
                              "UpdateIapSettings"))
                      .build();
        }
      }
    }
    return getUpdateIapSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iap.v1.ListTunnelDestGroupsRequest,
          com.google.cloud.iap.v1.ListTunnelDestGroupsResponse>
      getListTunnelDestGroupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTunnelDestGroups",
      requestType = com.google.cloud.iap.v1.ListTunnelDestGroupsRequest.class,
      responseType = com.google.cloud.iap.v1.ListTunnelDestGroupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iap.v1.ListTunnelDestGroupsRequest,
          com.google.cloud.iap.v1.ListTunnelDestGroupsResponse>
      getListTunnelDestGroupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.iap.v1.ListTunnelDestGroupsRequest,
            com.google.cloud.iap.v1.ListTunnelDestGroupsResponse>
        getListTunnelDestGroupsMethod;
    if ((getListTunnelDestGroupsMethod =
            IdentityAwareProxyAdminServiceGrpc.getListTunnelDestGroupsMethod)
        == null) {
      synchronized (IdentityAwareProxyAdminServiceGrpc.class) {
        if ((getListTunnelDestGroupsMethod =
                IdentityAwareProxyAdminServiceGrpc.getListTunnelDestGroupsMethod)
            == null) {
          IdentityAwareProxyAdminServiceGrpc.getListTunnelDestGroupsMethod =
              getListTunnelDestGroupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iap.v1.ListTunnelDestGroupsRequest,
                          com.google.cloud.iap.v1.ListTunnelDestGroupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListTunnelDestGroups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iap.v1.ListTunnelDestGroupsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iap.v1.ListTunnelDestGroupsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IdentityAwareProxyAdminServiceMethodDescriptorSupplier(
                              "ListTunnelDestGroups"))
                      .build();
        }
      }
    }
    return getListTunnelDestGroupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iap.v1.CreateTunnelDestGroupRequest,
          com.google.cloud.iap.v1.TunnelDestGroup>
      getCreateTunnelDestGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTunnelDestGroup",
      requestType = com.google.cloud.iap.v1.CreateTunnelDestGroupRequest.class,
      responseType = com.google.cloud.iap.v1.TunnelDestGroup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iap.v1.CreateTunnelDestGroupRequest,
          com.google.cloud.iap.v1.TunnelDestGroup>
      getCreateTunnelDestGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.iap.v1.CreateTunnelDestGroupRequest,
            com.google.cloud.iap.v1.TunnelDestGroup>
        getCreateTunnelDestGroupMethod;
    if ((getCreateTunnelDestGroupMethod =
            IdentityAwareProxyAdminServiceGrpc.getCreateTunnelDestGroupMethod)
        == null) {
      synchronized (IdentityAwareProxyAdminServiceGrpc.class) {
        if ((getCreateTunnelDestGroupMethod =
                IdentityAwareProxyAdminServiceGrpc.getCreateTunnelDestGroupMethod)
            == null) {
          IdentityAwareProxyAdminServiceGrpc.getCreateTunnelDestGroupMethod =
              getCreateTunnelDestGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iap.v1.CreateTunnelDestGroupRequest,
                          com.google.cloud.iap.v1.TunnelDestGroup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateTunnelDestGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iap.v1.CreateTunnelDestGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iap.v1.TunnelDestGroup.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IdentityAwareProxyAdminServiceMethodDescriptorSupplier(
                              "CreateTunnelDestGroup"))
                      .build();
        }
      }
    }
    return getCreateTunnelDestGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iap.v1.GetTunnelDestGroupRequest,
          com.google.cloud.iap.v1.TunnelDestGroup>
      getGetTunnelDestGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTunnelDestGroup",
      requestType = com.google.cloud.iap.v1.GetTunnelDestGroupRequest.class,
      responseType = com.google.cloud.iap.v1.TunnelDestGroup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iap.v1.GetTunnelDestGroupRequest,
          com.google.cloud.iap.v1.TunnelDestGroup>
      getGetTunnelDestGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.iap.v1.GetTunnelDestGroupRequest,
            com.google.cloud.iap.v1.TunnelDestGroup>
        getGetTunnelDestGroupMethod;
    if ((getGetTunnelDestGroupMethod =
            IdentityAwareProxyAdminServiceGrpc.getGetTunnelDestGroupMethod)
        == null) {
      synchronized (IdentityAwareProxyAdminServiceGrpc.class) {
        if ((getGetTunnelDestGroupMethod =
                IdentityAwareProxyAdminServiceGrpc.getGetTunnelDestGroupMethod)
            == null) {
          IdentityAwareProxyAdminServiceGrpc.getGetTunnelDestGroupMethod =
              getGetTunnelDestGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iap.v1.GetTunnelDestGroupRequest,
                          com.google.cloud.iap.v1.TunnelDestGroup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTunnelDestGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iap.v1.GetTunnelDestGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iap.v1.TunnelDestGroup.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IdentityAwareProxyAdminServiceMethodDescriptorSupplier(
                              "GetTunnelDestGroup"))
                      .build();
        }
      }
    }
    return getGetTunnelDestGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iap.v1.DeleteTunnelDestGroupRequest, com.google.protobuf.Empty>
      getDeleteTunnelDestGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTunnelDestGroup",
      requestType = com.google.cloud.iap.v1.DeleteTunnelDestGroupRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iap.v1.DeleteTunnelDestGroupRequest, com.google.protobuf.Empty>
      getDeleteTunnelDestGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.iap.v1.DeleteTunnelDestGroupRequest, com.google.protobuf.Empty>
        getDeleteTunnelDestGroupMethod;
    if ((getDeleteTunnelDestGroupMethod =
            IdentityAwareProxyAdminServiceGrpc.getDeleteTunnelDestGroupMethod)
        == null) {
      synchronized (IdentityAwareProxyAdminServiceGrpc.class) {
        if ((getDeleteTunnelDestGroupMethod =
                IdentityAwareProxyAdminServiceGrpc.getDeleteTunnelDestGroupMethod)
            == null) {
          IdentityAwareProxyAdminServiceGrpc.getDeleteTunnelDestGroupMethod =
              getDeleteTunnelDestGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iap.v1.DeleteTunnelDestGroupRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteTunnelDestGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iap.v1.DeleteTunnelDestGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IdentityAwareProxyAdminServiceMethodDescriptorSupplier(
                              "DeleteTunnelDestGroup"))
                      .build();
        }
      }
    }
    return getDeleteTunnelDestGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iap.v1.UpdateTunnelDestGroupRequest,
          com.google.cloud.iap.v1.TunnelDestGroup>
      getUpdateTunnelDestGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTunnelDestGroup",
      requestType = com.google.cloud.iap.v1.UpdateTunnelDestGroupRequest.class,
      responseType = com.google.cloud.iap.v1.TunnelDestGroup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iap.v1.UpdateTunnelDestGroupRequest,
          com.google.cloud.iap.v1.TunnelDestGroup>
      getUpdateTunnelDestGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.iap.v1.UpdateTunnelDestGroupRequest,
            com.google.cloud.iap.v1.TunnelDestGroup>
        getUpdateTunnelDestGroupMethod;
    if ((getUpdateTunnelDestGroupMethod =
            IdentityAwareProxyAdminServiceGrpc.getUpdateTunnelDestGroupMethod)
        == null) {
      synchronized (IdentityAwareProxyAdminServiceGrpc.class) {
        if ((getUpdateTunnelDestGroupMethod =
                IdentityAwareProxyAdminServiceGrpc.getUpdateTunnelDestGroupMethod)
            == null) {
          IdentityAwareProxyAdminServiceGrpc.getUpdateTunnelDestGroupMethod =
              getUpdateTunnelDestGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iap.v1.UpdateTunnelDestGroupRequest,
                          com.google.cloud.iap.v1.TunnelDestGroup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateTunnelDestGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iap.v1.UpdateTunnelDestGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iap.v1.TunnelDestGroup.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IdentityAwareProxyAdminServiceMethodDescriptorSupplier(
                              "UpdateTunnelDestGroup"))
                      .build();
        }
      }
    }
    return getUpdateTunnelDestGroupMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static IdentityAwareProxyAdminServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IdentityAwareProxyAdminServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IdentityAwareProxyAdminServiceStub>() {
          @java.lang.Override
          public IdentityAwareProxyAdminServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IdentityAwareProxyAdminServiceStub(channel, callOptions);
          }
        };
    return IdentityAwareProxyAdminServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IdentityAwareProxyAdminServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IdentityAwareProxyAdminServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IdentityAwareProxyAdminServiceBlockingStub>() {
          @java.lang.Override
          public IdentityAwareProxyAdminServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IdentityAwareProxyAdminServiceBlockingStub(channel, callOptions);
          }
        };
    return IdentityAwareProxyAdminServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static IdentityAwareProxyAdminServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IdentityAwareProxyAdminServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IdentityAwareProxyAdminServiceFutureStub>() {
          @java.lang.Override
          public IdentityAwareProxyAdminServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IdentityAwareProxyAdminServiceFutureStub(channel, callOptions);
          }
        };
    return IdentityAwareProxyAdminServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * APIs for Identity-Aware Proxy Admin configurations.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Sets the access control policy for an Identity-Aware Proxy protected
     * resource. Replaces any existing policy.
     * More information about managing access via IAP can be found at:
     * https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api
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
     * Gets the access control policy for an Identity-Aware Proxy protected
     * resource.
     * More information about managing access via IAP can be found at:
     * https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api
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
     * Returns permissions that a caller has on the Identity-Aware Proxy protected
     * resource.
     * More information about managing access via IAP can be found at:
     * https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api
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
     * Gets the IAP settings on a particular IAP protected resource.
     * </pre>
     */
    default void getIapSettings(
        com.google.cloud.iap.v1.GetIapSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.IapSettings> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetIapSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the IAP settings on a particular IAP protected resource. It
     * replaces all fields unless the `update_mask` is set.
     * </pre>
     */
    default void updateIapSettings(
        com.google.cloud.iap.v1.UpdateIapSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.IapSettings> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateIapSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the existing TunnelDestGroups. To group across all locations, use a
     * `-` as the location ID. For example:
     * `/v1/projects/123/iap_tunnel/locations/-/destGroups`
     * </pre>
     */
    default void listTunnelDestGroups(
        com.google.cloud.iap.v1.ListTunnelDestGroupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.ListTunnelDestGroupsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListTunnelDestGroupsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TunnelDestGroup.
     * </pre>
     */
    default void createTunnelDestGroup(
        com.google.cloud.iap.v1.CreateTunnelDestGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.TunnelDestGroup> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateTunnelDestGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an existing TunnelDestGroup.
     * </pre>
     */
    default void getTunnelDestGroup(
        com.google.cloud.iap.v1.GetTunnelDestGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.TunnelDestGroup> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetTunnelDestGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a TunnelDestGroup.
     * </pre>
     */
    default void deleteTunnelDestGroup(
        com.google.cloud.iap.v1.DeleteTunnelDestGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteTunnelDestGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a TunnelDestGroup.
     * </pre>
     */
    default void updateTunnelDestGroup(
        com.google.cloud.iap.v1.UpdateTunnelDestGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.TunnelDestGroup> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateTunnelDestGroupMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service IdentityAwareProxyAdminService.
   *
   * <pre>
   * APIs for Identity-Aware Proxy Admin configurations.
   * </pre>
   */
  public abstract static class IdentityAwareProxyAdminServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return IdentityAwareProxyAdminServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service IdentityAwareProxyAdminService.
   *
   * <pre>
   * APIs for Identity-Aware Proxy Admin configurations.
   * </pre>
   */
  public static final class IdentityAwareProxyAdminServiceStub
      extends io.grpc.stub.AbstractAsyncStub<IdentityAwareProxyAdminServiceStub> {
    private IdentityAwareProxyAdminServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IdentityAwareProxyAdminServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IdentityAwareProxyAdminServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy for an Identity-Aware Proxy protected
     * resource. Replaces any existing policy.
     * More information about managing access via IAP can be found at:
     * https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api
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
     * Gets the access control policy for an Identity-Aware Proxy protected
     * resource.
     * More information about managing access via IAP can be found at:
     * https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api
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
     * Returns permissions that a caller has on the Identity-Aware Proxy protected
     * resource.
     * More information about managing access via IAP can be found at:
     * https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api
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
     * Gets the IAP settings on a particular IAP protected resource.
     * </pre>
     */
    public void getIapSettings(
        com.google.cloud.iap.v1.GetIapSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.IapSettings> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIapSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the IAP settings on a particular IAP protected resource. It
     * replaces all fields unless the `update_mask` is set.
     * </pre>
     */
    public void updateIapSettings(
        com.google.cloud.iap.v1.UpdateIapSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.IapSettings> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateIapSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the existing TunnelDestGroups. To group across all locations, use a
     * `-` as the location ID. For example:
     * `/v1/projects/123/iap_tunnel/locations/-/destGroups`
     * </pre>
     */
    public void listTunnelDestGroups(
        com.google.cloud.iap.v1.ListTunnelDestGroupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.ListTunnelDestGroupsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTunnelDestGroupsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TunnelDestGroup.
     * </pre>
     */
    public void createTunnelDestGroup(
        com.google.cloud.iap.v1.CreateTunnelDestGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.TunnelDestGroup> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTunnelDestGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an existing TunnelDestGroup.
     * </pre>
     */
    public void getTunnelDestGroup(
        com.google.cloud.iap.v1.GetTunnelDestGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.TunnelDestGroup> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTunnelDestGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a TunnelDestGroup.
     * </pre>
     */
    public void deleteTunnelDestGroup(
        com.google.cloud.iap.v1.DeleteTunnelDestGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTunnelDestGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a TunnelDestGroup.
     * </pre>
     */
    public void updateTunnelDestGroup(
        com.google.cloud.iap.v1.UpdateTunnelDestGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.TunnelDestGroup> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTunnelDestGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service IdentityAwareProxyAdminService.
   *
   * <pre>
   * APIs for Identity-Aware Proxy Admin configurations.
   * </pre>
   */
  public static final class IdentityAwareProxyAdminServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<IdentityAwareProxyAdminServiceBlockingStub> {
    private IdentityAwareProxyAdminServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IdentityAwareProxyAdminServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IdentityAwareProxyAdminServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy for an Identity-Aware Proxy protected
     * resource. Replaces any existing policy.
     * More information about managing access via IAP can be found at:
     * https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api
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
     * Gets the access control policy for an Identity-Aware Proxy protected
     * resource.
     * More information about managing access via IAP can be found at:
     * https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api
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
     * Returns permissions that a caller has on the Identity-Aware Proxy protected
     * resource.
     * More information about managing access via IAP can be found at:
     * https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api
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
     * Gets the IAP settings on a particular IAP protected resource.
     * </pre>
     */
    public com.google.cloud.iap.v1.IapSettings getIapSettings(
        com.google.cloud.iap.v1.GetIapSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIapSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the IAP settings on a particular IAP protected resource. It
     * replaces all fields unless the `update_mask` is set.
     * </pre>
     */
    public com.google.cloud.iap.v1.IapSettings updateIapSettings(
        com.google.cloud.iap.v1.UpdateIapSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateIapSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the existing TunnelDestGroups. To group across all locations, use a
     * `-` as the location ID. For example:
     * `/v1/projects/123/iap_tunnel/locations/-/destGroups`
     * </pre>
     */
    public com.google.cloud.iap.v1.ListTunnelDestGroupsResponse listTunnelDestGroups(
        com.google.cloud.iap.v1.ListTunnelDestGroupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTunnelDestGroupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TunnelDestGroup.
     * </pre>
     */
    public com.google.cloud.iap.v1.TunnelDestGroup createTunnelDestGroup(
        com.google.cloud.iap.v1.CreateTunnelDestGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTunnelDestGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an existing TunnelDestGroup.
     * </pre>
     */
    public com.google.cloud.iap.v1.TunnelDestGroup getTunnelDestGroup(
        com.google.cloud.iap.v1.GetTunnelDestGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTunnelDestGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a TunnelDestGroup.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTunnelDestGroup(
        com.google.cloud.iap.v1.DeleteTunnelDestGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTunnelDestGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a TunnelDestGroup.
     * </pre>
     */
    public com.google.cloud.iap.v1.TunnelDestGroup updateTunnelDestGroup(
        com.google.cloud.iap.v1.UpdateTunnelDestGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTunnelDestGroupMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * IdentityAwareProxyAdminService.
   *
   * <pre>
   * APIs for Identity-Aware Proxy Admin configurations.
   * </pre>
   */
  public static final class IdentityAwareProxyAdminServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<IdentityAwareProxyAdminServiceFutureStub> {
    private IdentityAwareProxyAdminServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IdentityAwareProxyAdminServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IdentityAwareProxyAdminServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy for an Identity-Aware Proxy protected
     * resource. Replaces any existing policy.
     * More information about managing access via IAP can be found at:
     * https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api
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
     * Gets the access control policy for an Identity-Aware Proxy protected
     * resource.
     * More information about managing access via IAP can be found at:
     * https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api
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
     * Returns permissions that a caller has on the Identity-Aware Proxy protected
     * resource.
     * More information about managing access via IAP can be found at:
     * https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api
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
     * Gets the IAP settings on a particular IAP protected resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.iap.v1.IapSettings>
        getIapSettings(com.google.cloud.iap.v1.GetIapSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIapSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the IAP settings on a particular IAP protected resource. It
     * replaces all fields unless the `update_mask` is set.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.iap.v1.IapSettings>
        updateIapSettings(com.google.cloud.iap.v1.UpdateIapSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateIapSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the existing TunnelDestGroups. To group across all locations, use a
     * `-` as the location ID. For example:
     * `/v1/projects/123/iap_tunnel/locations/-/destGroups`
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.iap.v1.ListTunnelDestGroupsResponse>
        listTunnelDestGroups(com.google.cloud.iap.v1.ListTunnelDestGroupsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTunnelDestGroupsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TunnelDestGroup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.iap.v1.TunnelDestGroup>
        createTunnelDestGroup(com.google.cloud.iap.v1.CreateTunnelDestGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTunnelDestGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an existing TunnelDestGroup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.iap.v1.TunnelDestGroup>
        getTunnelDestGroup(com.google.cloud.iap.v1.GetTunnelDestGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTunnelDestGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a TunnelDestGroup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteTunnelDestGroup(com.google.cloud.iap.v1.DeleteTunnelDestGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTunnelDestGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a TunnelDestGroup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.iap.v1.TunnelDestGroup>
        updateTunnelDestGroup(com.google.cloud.iap.v1.UpdateTunnelDestGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTunnelDestGroupMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_IAM_POLICY = 0;
  private static final int METHODID_GET_IAM_POLICY = 1;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 2;
  private static final int METHODID_GET_IAP_SETTINGS = 3;
  private static final int METHODID_UPDATE_IAP_SETTINGS = 4;
  private static final int METHODID_LIST_TUNNEL_DEST_GROUPS = 5;
  private static final int METHODID_CREATE_TUNNEL_DEST_GROUP = 6;
  private static final int METHODID_GET_TUNNEL_DEST_GROUP = 7;
  private static final int METHODID_DELETE_TUNNEL_DEST_GROUP = 8;
  private static final int METHODID_UPDATE_TUNNEL_DEST_GROUP = 9;

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
        case METHODID_SET_IAM_POLICY:
          serviceImpl.setIamPolicy(
              (com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy(
              (com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS:
          serviceImpl.testIamPermissions(
              (com.google.iam.v1.TestIamPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_IAP_SETTINGS:
          serviceImpl.getIapSettings(
              (com.google.cloud.iap.v1.GetIapSettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.IapSettings>) responseObserver);
          break;
        case METHODID_UPDATE_IAP_SETTINGS:
          serviceImpl.updateIapSettings(
              (com.google.cloud.iap.v1.UpdateIapSettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.IapSettings>) responseObserver);
          break;
        case METHODID_LIST_TUNNEL_DEST_GROUPS:
          serviceImpl.listTunnelDestGroups(
              (com.google.cloud.iap.v1.ListTunnelDestGroupsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.ListTunnelDestGroupsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_TUNNEL_DEST_GROUP:
          serviceImpl.createTunnelDestGroup(
              (com.google.cloud.iap.v1.CreateTunnelDestGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.TunnelDestGroup>)
                  responseObserver);
          break;
        case METHODID_GET_TUNNEL_DEST_GROUP:
          serviceImpl.getTunnelDestGroup(
              (com.google.cloud.iap.v1.GetTunnelDestGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.TunnelDestGroup>)
                  responseObserver);
          break;
        case METHODID_DELETE_TUNNEL_DEST_GROUP:
          serviceImpl.deleteTunnelDestGroup(
              (com.google.cloud.iap.v1.DeleteTunnelDestGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_TUNNEL_DEST_GROUP:
          serviceImpl.updateTunnelDestGroup(
              (com.google.cloud.iap.v1.UpdateTunnelDestGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.TunnelDestGroup>)
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
            getSetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>(
                    service, METHODID_SET_IAM_POLICY)))
        .addMethod(
            getGetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>(
                    service, METHODID_GET_IAM_POLICY)))
        .addMethod(
            getTestIamPermissionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.iam.v1.TestIamPermissionsRequest,
                    com.google.iam.v1.TestIamPermissionsResponse>(
                    service, METHODID_TEST_IAM_PERMISSIONS)))
        .addMethod(
            getGetIapSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.iap.v1.GetIapSettingsRequest,
                    com.google.cloud.iap.v1.IapSettings>(service, METHODID_GET_IAP_SETTINGS)))
        .addMethod(
            getUpdateIapSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.iap.v1.UpdateIapSettingsRequest,
                    com.google.cloud.iap.v1.IapSettings>(service, METHODID_UPDATE_IAP_SETTINGS)))
        .addMethod(
            getListTunnelDestGroupsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.iap.v1.ListTunnelDestGroupsRequest,
                    com.google.cloud.iap.v1.ListTunnelDestGroupsResponse>(
                    service, METHODID_LIST_TUNNEL_DEST_GROUPS)))
        .addMethod(
            getCreateTunnelDestGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.iap.v1.CreateTunnelDestGroupRequest,
                    com.google.cloud.iap.v1.TunnelDestGroup>(
                    service, METHODID_CREATE_TUNNEL_DEST_GROUP)))
        .addMethod(
            getGetTunnelDestGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.iap.v1.GetTunnelDestGroupRequest,
                    com.google.cloud.iap.v1.TunnelDestGroup>(
                    service, METHODID_GET_TUNNEL_DEST_GROUP)))
        .addMethod(
            getDeleteTunnelDestGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.iap.v1.DeleteTunnelDestGroupRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_TUNNEL_DEST_GROUP)))
        .addMethod(
            getUpdateTunnelDestGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.iap.v1.UpdateTunnelDestGroupRequest,
                    com.google.cloud.iap.v1.TunnelDestGroup>(
                    service, METHODID_UPDATE_TUNNEL_DEST_GROUP)))
        .build();
  }

  private abstract static class IdentityAwareProxyAdminServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    IdentityAwareProxyAdminServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.iap.v1.Service.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("IdentityAwareProxyAdminService");
    }
  }

  private static final class IdentityAwareProxyAdminServiceFileDescriptorSupplier
      extends IdentityAwareProxyAdminServiceBaseDescriptorSupplier {
    IdentityAwareProxyAdminServiceFileDescriptorSupplier() {}
  }

  private static final class IdentityAwareProxyAdminServiceMethodDescriptorSupplier
      extends IdentityAwareProxyAdminServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    IdentityAwareProxyAdminServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (IdentityAwareProxyAdminServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(
                          new IdentityAwareProxyAdminServiceFileDescriptorSupplier())
                      .addMethod(getSetIamPolicyMethod())
                      .addMethod(getGetIamPolicyMethod())
                      .addMethod(getTestIamPermissionsMethod())
                      .addMethod(getGetIapSettingsMethod())
                      .addMethod(getUpdateIapSettingsMethod())
                      .addMethod(getListTunnelDestGroupsMethod())
                      .addMethod(getCreateTunnelDestGroupMethod())
                      .addMethod(getGetTunnelDestGroupMethod())
                      .addMethod(getDeleteTunnelDestGroupMethod())
                      .addMethod(getUpdateTunnelDestGroupMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
