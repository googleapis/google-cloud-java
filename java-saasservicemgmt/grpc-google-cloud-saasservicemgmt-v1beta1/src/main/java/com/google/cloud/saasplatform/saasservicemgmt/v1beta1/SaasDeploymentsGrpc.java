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
package com.google.cloud.saasplatform.saasservicemgmt.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Manages the deployment of SaaS services.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments =
        "Source: google/cloud/saasplatform/saasservicemgmt/v1beta1/deployments_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SaasDeploymentsGrpc {

  private SaasDeploymentsGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListSaasRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListSaasResponse>
      getListSaasMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSaas",
      requestType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListSaasRequest.class,
      responseType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListSaasResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListSaasRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListSaasResponse>
      getListSaasMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListSaasRequest,
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListSaasResponse>
        getListSaasMethod;
    if ((getListSaasMethod = SaasDeploymentsGrpc.getListSaasMethod) == null) {
      synchronized (SaasDeploymentsGrpc.class) {
        if ((getListSaasMethod = SaasDeploymentsGrpc.getListSaasMethod) == null) {
          SaasDeploymentsGrpc.getListSaasMethod =
              getListSaasMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListSaasRequest,
                          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListSaasResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSaas"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListSaasRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListSaasResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new SaasDeploymentsMethodDescriptorSupplier("ListSaas"))
                      .build();
        }
      }
    }
    return getListSaasMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetSaasRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas>
      getGetSaasMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSaas",
      requestType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetSaasRequest.class,
      responseType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetSaasRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas>
      getGetSaasMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetSaasRequest,
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas>
        getGetSaasMethod;
    if ((getGetSaasMethod = SaasDeploymentsGrpc.getGetSaasMethod) == null) {
      synchronized (SaasDeploymentsGrpc.class) {
        if ((getGetSaasMethod = SaasDeploymentsGrpc.getGetSaasMethod) == null) {
          SaasDeploymentsGrpc.getGetSaasMethod =
              getGetSaasMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetSaasRequest,
                          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSaas"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetSaasRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new SaasDeploymentsMethodDescriptorSupplier("GetSaas"))
                      .build();
        }
      }
    }
    return getGetSaasMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateSaasRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas>
      getCreateSaasMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSaas",
      requestType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateSaasRequest.class,
      responseType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateSaasRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas>
      getCreateSaasMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateSaasRequest,
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas>
        getCreateSaasMethod;
    if ((getCreateSaasMethod = SaasDeploymentsGrpc.getCreateSaasMethod) == null) {
      synchronized (SaasDeploymentsGrpc.class) {
        if ((getCreateSaasMethod = SaasDeploymentsGrpc.getCreateSaasMethod) == null) {
          SaasDeploymentsGrpc.getCreateSaasMethod =
              getCreateSaasMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateSaasRequest,
                          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSaas"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .CreateSaasRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SaasDeploymentsMethodDescriptorSupplier("CreateSaas"))
                      .build();
        }
      }
    }
    return getCreateSaasMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateSaasRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas>
      getUpdateSaasMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSaas",
      requestType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateSaasRequest.class,
      responseType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateSaasRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas>
      getUpdateSaasMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateSaasRequest,
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas>
        getUpdateSaasMethod;
    if ((getUpdateSaasMethod = SaasDeploymentsGrpc.getUpdateSaasMethod) == null) {
      synchronized (SaasDeploymentsGrpc.class) {
        if ((getUpdateSaasMethod = SaasDeploymentsGrpc.getUpdateSaasMethod) == null) {
          SaasDeploymentsGrpc.getUpdateSaasMethod =
              getUpdateSaasMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateSaasRequest,
                          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSaas"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .UpdateSaasRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SaasDeploymentsMethodDescriptorSupplier("UpdateSaas"))
                      .build();
        }
      }
    }
    return getUpdateSaasMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteSaasRequest,
          com.google.protobuf.Empty>
      getDeleteSaasMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSaas",
      requestType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteSaasRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteSaasRequest,
          com.google.protobuf.Empty>
      getDeleteSaasMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteSaasRequest,
            com.google.protobuf.Empty>
        getDeleteSaasMethod;
    if ((getDeleteSaasMethod = SaasDeploymentsGrpc.getDeleteSaasMethod) == null) {
      synchronized (SaasDeploymentsGrpc.class) {
        if ((getDeleteSaasMethod = SaasDeploymentsGrpc.getDeleteSaasMethod) == null) {
          SaasDeploymentsGrpc.getDeleteSaasMethod =
              getDeleteSaasMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteSaasRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSaas"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .DeleteSaasRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SaasDeploymentsMethodDescriptorSupplier("DeleteSaas"))
                      .build();
        }
      }
    }
    return getDeleteSaasMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListTenantsRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListTenantsResponse>
      getListTenantsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTenants",
      requestType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListTenantsRequest.class,
      responseType =
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListTenantsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListTenantsRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListTenantsResponse>
      getListTenantsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListTenantsRequest,
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListTenantsResponse>
        getListTenantsMethod;
    if ((getListTenantsMethod = SaasDeploymentsGrpc.getListTenantsMethod) == null) {
      synchronized (SaasDeploymentsGrpc.class) {
        if ((getListTenantsMethod = SaasDeploymentsGrpc.getListTenantsMethod) == null) {
          SaasDeploymentsGrpc.getListTenantsMethod =
              getListTenantsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListTenantsRequest,
                          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListTenantsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTenants"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .ListTenantsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .ListTenantsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SaasDeploymentsMethodDescriptorSupplier("ListTenants"))
                      .build();
        }
      }
    }
    return getListTenantsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetTenantRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant>
      getGetTenantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTenant",
      requestType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetTenantRequest.class,
      responseType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetTenantRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant>
      getGetTenantMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetTenantRequest,
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant>
        getGetTenantMethod;
    if ((getGetTenantMethod = SaasDeploymentsGrpc.getGetTenantMethod) == null) {
      synchronized (SaasDeploymentsGrpc.class) {
        if ((getGetTenantMethod = SaasDeploymentsGrpc.getGetTenantMethod) == null) {
          SaasDeploymentsGrpc.getGetTenantMethod =
              getGetTenantMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetTenantRequest,
                          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTenant"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetTenantRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new SaasDeploymentsMethodDescriptorSupplier("GetTenant"))
                      .build();
        }
      }
    }
    return getGetTenantMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateTenantRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant>
      getCreateTenantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTenant",
      requestType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateTenantRequest.class,
      responseType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateTenantRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant>
      getCreateTenantMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateTenantRequest,
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant>
        getCreateTenantMethod;
    if ((getCreateTenantMethod = SaasDeploymentsGrpc.getCreateTenantMethod) == null) {
      synchronized (SaasDeploymentsGrpc.class) {
        if ((getCreateTenantMethod = SaasDeploymentsGrpc.getCreateTenantMethod) == null) {
          SaasDeploymentsGrpc.getCreateTenantMethod =
              getCreateTenantMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateTenantRequest,
                          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTenant"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .CreateTenantRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SaasDeploymentsMethodDescriptorSupplier("CreateTenant"))
                      .build();
        }
      }
    }
    return getCreateTenantMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateTenantRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant>
      getUpdateTenantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTenant",
      requestType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateTenantRequest.class,
      responseType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateTenantRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant>
      getUpdateTenantMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateTenantRequest,
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant>
        getUpdateTenantMethod;
    if ((getUpdateTenantMethod = SaasDeploymentsGrpc.getUpdateTenantMethod) == null) {
      synchronized (SaasDeploymentsGrpc.class) {
        if ((getUpdateTenantMethod = SaasDeploymentsGrpc.getUpdateTenantMethod) == null) {
          SaasDeploymentsGrpc.getUpdateTenantMethod =
              getUpdateTenantMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateTenantRequest,
                          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTenant"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .UpdateTenantRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SaasDeploymentsMethodDescriptorSupplier("UpdateTenant"))
                      .build();
        }
      }
    }
    return getUpdateTenantMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteTenantRequest,
          com.google.protobuf.Empty>
      getDeleteTenantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTenant",
      requestType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteTenantRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteTenantRequest,
          com.google.protobuf.Empty>
      getDeleteTenantMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteTenantRequest,
            com.google.protobuf.Empty>
        getDeleteTenantMethod;
    if ((getDeleteTenantMethod = SaasDeploymentsGrpc.getDeleteTenantMethod) == null) {
      synchronized (SaasDeploymentsGrpc.class) {
        if ((getDeleteTenantMethod = SaasDeploymentsGrpc.getDeleteTenantMethod) == null) {
          SaasDeploymentsGrpc.getDeleteTenantMethod =
              getDeleteTenantMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteTenantRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTenant"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .DeleteTenantRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SaasDeploymentsMethodDescriptorSupplier("DeleteTenant"))
                      .build();
        }
      }
    }
    return getDeleteTenantMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitKindsRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitKindsResponse>
      getListUnitKindsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListUnitKinds",
      requestType =
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitKindsRequest.class,
      responseType =
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitKindsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitKindsRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitKindsResponse>
      getListUnitKindsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitKindsRequest,
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitKindsResponse>
        getListUnitKindsMethod;
    if ((getListUnitKindsMethod = SaasDeploymentsGrpc.getListUnitKindsMethod) == null) {
      synchronized (SaasDeploymentsGrpc.class) {
        if ((getListUnitKindsMethod = SaasDeploymentsGrpc.getListUnitKindsMethod) == null) {
          SaasDeploymentsGrpc.getListUnitKindsMethod =
              getListUnitKindsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitKindsRequest,
                          com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                              .ListUnitKindsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListUnitKinds"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .ListUnitKindsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .ListUnitKindsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SaasDeploymentsMethodDescriptorSupplier("ListUnitKinds"))
                      .build();
        }
      }
    }
    return getListUnitKindsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitKindRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind>
      getGetUnitKindMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUnitKind",
      requestType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitKindRequest.class,
      responseType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitKindRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind>
      getGetUnitKindMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitKindRequest,
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind>
        getGetUnitKindMethod;
    if ((getGetUnitKindMethod = SaasDeploymentsGrpc.getGetUnitKindMethod) == null) {
      synchronized (SaasDeploymentsGrpc.class) {
        if ((getGetUnitKindMethod = SaasDeploymentsGrpc.getGetUnitKindMethod) == null) {
          SaasDeploymentsGrpc.getGetUnitKindMethod =
              getGetUnitKindMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitKindRequest,
                          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUnitKind"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .GetUnitKindRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SaasDeploymentsMethodDescriptorSupplier("GetUnitKind"))
                      .build();
        }
      }
    }
    return getGetUnitKindMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitKindRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind>
      getCreateUnitKindMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUnitKind",
      requestType =
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitKindRequest.class,
      responseType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitKindRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind>
      getCreateUnitKindMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitKindRequest,
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind>
        getCreateUnitKindMethod;
    if ((getCreateUnitKindMethod = SaasDeploymentsGrpc.getCreateUnitKindMethod) == null) {
      synchronized (SaasDeploymentsGrpc.class) {
        if ((getCreateUnitKindMethod = SaasDeploymentsGrpc.getCreateUnitKindMethod) == null) {
          SaasDeploymentsGrpc.getCreateUnitKindMethod =
              getCreateUnitKindMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitKindRequest,
                          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateUnitKind"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .CreateUnitKindRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SaasDeploymentsMethodDescriptorSupplier("CreateUnitKind"))
                      .build();
        }
      }
    }
    return getCreateUnitKindMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitKindRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind>
      getUpdateUnitKindMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUnitKind",
      requestType =
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitKindRequest.class,
      responseType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitKindRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind>
      getUpdateUnitKindMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitKindRequest,
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind>
        getUpdateUnitKindMethod;
    if ((getUpdateUnitKindMethod = SaasDeploymentsGrpc.getUpdateUnitKindMethod) == null) {
      synchronized (SaasDeploymentsGrpc.class) {
        if ((getUpdateUnitKindMethod = SaasDeploymentsGrpc.getUpdateUnitKindMethod) == null) {
          SaasDeploymentsGrpc.getUpdateUnitKindMethod =
              getUpdateUnitKindMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitKindRequest,
                          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateUnitKind"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .UpdateUnitKindRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SaasDeploymentsMethodDescriptorSupplier("UpdateUnitKind"))
                      .build();
        }
      }
    }
    return getUpdateUnitKindMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitKindRequest,
          com.google.protobuf.Empty>
      getDeleteUnitKindMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteUnitKind",
      requestType =
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitKindRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitKindRequest,
          com.google.protobuf.Empty>
      getDeleteUnitKindMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitKindRequest,
            com.google.protobuf.Empty>
        getDeleteUnitKindMethod;
    if ((getDeleteUnitKindMethod = SaasDeploymentsGrpc.getDeleteUnitKindMethod) == null) {
      synchronized (SaasDeploymentsGrpc.class) {
        if ((getDeleteUnitKindMethod = SaasDeploymentsGrpc.getDeleteUnitKindMethod) == null) {
          SaasDeploymentsGrpc.getDeleteUnitKindMethod =
              getDeleteUnitKindMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitKindRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteUnitKind"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .DeleteUnitKindRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SaasDeploymentsMethodDescriptorSupplier("DeleteUnitKind"))
                      .build();
        }
      }
    }
    return getDeleteUnitKindMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitsRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitsResponse>
      getListUnitsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListUnits",
      requestType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitsRequest.class,
      responseType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitsRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitsResponse>
      getListUnitsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitsRequest,
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitsResponse>
        getListUnitsMethod;
    if ((getListUnitsMethod = SaasDeploymentsGrpc.getListUnitsMethod) == null) {
      synchronized (SaasDeploymentsGrpc.class) {
        if ((getListUnitsMethod = SaasDeploymentsGrpc.getListUnitsMethod) == null) {
          SaasDeploymentsGrpc.getListUnitsMethod =
              getListUnitsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitsRequest,
                          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListUnits"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .ListUnitsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new SaasDeploymentsMethodDescriptorSupplier("ListUnits"))
                      .build();
        }
      }
    }
    return getListUnitsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit>
      getGetUnitMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUnit",
      requestType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitRequest.class,
      responseType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit>
      getGetUnitMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitRequest,
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit>
        getGetUnitMethod;
    if ((getGetUnitMethod = SaasDeploymentsGrpc.getGetUnitMethod) == null) {
      synchronized (SaasDeploymentsGrpc.class) {
        if ((getGetUnitMethod = SaasDeploymentsGrpc.getGetUnitMethod) == null) {
          SaasDeploymentsGrpc.getGetUnitMethod =
              getGetUnitMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitRequest,
                          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUnit"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new SaasDeploymentsMethodDescriptorSupplier("GetUnit"))
                      .build();
        }
      }
    }
    return getGetUnitMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit>
      getCreateUnitMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUnit",
      requestType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitRequest.class,
      responseType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit>
      getCreateUnitMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitRequest,
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit>
        getCreateUnitMethod;
    if ((getCreateUnitMethod = SaasDeploymentsGrpc.getCreateUnitMethod) == null) {
      synchronized (SaasDeploymentsGrpc.class) {
        if ((getCreateUnitMethod = SaasDeploymentsGrpc.getCreateUnitMethod) == null) {
          SaasDeploymentsGrpc.getCreateUnitMethod =
              getCreateUnitMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitRequest,
                          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateUnit"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .CreateUnitRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SaasDeploymentsMethodDescriptorSupplier("CreateUnit"))
                      .build();
        }
      }
    }
    return getCreateUnitMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit>
      getUpdateUnitMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUnit",
      requestType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitRequest.class,
      responseType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit>
      getUpdateUnitMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitRequest,
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit>
        getUpdateUnitMethod;
    if ((getUpdateUnitMethod = SaasDeploymentsGrpc.getUpdateUnitMethod) == null) {
      synchronized (SaasDeploymentsGrpc.class) {
        if ((getUpdateUnitMethod = SaasDeploymentsGrpc.getUpdateUnitMethod) == null) {
          SaasDeploymentsGrpc.getUpdateUnitMethod =
              getUpdateUnitMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitRequest,
                          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateUnit"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .UpdateUnitRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SaasDeploymentsMethodDescriptorSupplier("UpdateUnit"))
                      .build();
        }
      }
    }
    return getUpdateUnitMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitRequest,
          com.google.protobuf.Empty>
      getDeleteUnitMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteUnit",
      requestType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitRequest,
          com.google.protobuf.Empty>
      getDeleteUnitMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitRequest,
            com.google.protobuf.Empty>
        getDeleteUnitMethod;
    if ((getDeleteUnitMethod = SaasDeploymentsGrpc.getDeleteUnitMethod) == null) {
      synchronized (SaasDeploymentsGrpc.class) {
        if ((getDeleteUnitMethod = SaasDeploymentsGrpc.getDeleteUnitMethod) == null) {
          SaasDeploymentsGrpc.getDeleteUnitMethod =
              getDeleteUnitMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteUnit"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .DeleteUnitRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SaasDeploymentsMethodDescriptorSupplier("DeleteUnit"))
                      .build();
        }
      }
    }
    return getDeleteUnitMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitOperationsRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitOperationsResponse>
      getListUnitOperationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListUnitOperations",
      requestType =
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitOperationsRequest.class,
      responseType =
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitOperationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitOperationsRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitOperationsResponse>
      getListUnitOperationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitOperationsRequest,
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitOperationsResponse>
        getListUnitOperationsMethod;
    if ((getListUnitOperationsMethod = SaasDeploymentsGrpc.getListUnitOperationsMethod) == null) {
      synchronized (SaasDeploymentsGrpc.class) {
        if ((getListUnitOperationsMethod = SaasDeploymentsGrpc.getListUnitOperationsMethod)
            == null) {
          SaasDeploymentsGrpc.getListUnitOperationsMethod =
              getListUnitOperationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                              .ListUnitOperationsRequest,
                          com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                              .ListUnitOperationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListUnitOperations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .ListUnitOperationsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .ListUnitOperationsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SaasDeploymentsMethodDescriptorSupplier("ListUnitOperations"))
                      .build();
        }
      }
    }
    return getListUnitOperationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitOperationRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation>
      getGetUnitOperationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUnitOperation",
      requestType =
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitOperationRequest.class,
      responseType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitOperationRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation>
      getGetUnitOperationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitOperationRequest,
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation>
        getGetUnitOperationMethod;
    if ((getGetUnitOperationMethod = SaasDeploymentsGrpc.getGetUnitOperationMethod) == null) {
      synchronized (SaasDeploymentsGrpc.class) {
        if ((getGetUnitOperationMethod = SaasDeploymentsGrpc.getGetUnitOperationMethod) == null) {
          SaasDeploymentsGrpc.getGetUnitOperationMethod =
              getGetUnitOperationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                              .GetUnitOperationRequest,
                          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUnitOperation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .GetUnitOperationRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SaasDeploymentsMethodDescriptorSupplier("GetUnitOperation"))
                      .build();
        }
      }
    }
    return getGetUnitOperationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitOperationRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation>
      getCreateUnitOperationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUnitOperation",
      requestType =
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitOperationRequest.class,
      responseType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitOperationRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation>
      getCreateUnitOperationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitOperationRequest,
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation>
        getCreateUnitOperationMethod;
    if ((getCreateUnitOperationMethod = SaasDeploymentsGrpc.getCreateUnitOperationMethod) == null) {
      synchronized (SaasDeploymentsGrpc.class) {
        if ((getCreateUnitOperationMethod = SaasDeploymentsGrpc.getCreateUnitOperationMethod)
            == null) {
          SaasDeploymentsGrpc.getCreateUnitOperationMethod =
              getCreateUnitOperationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                              .CreateUnitOperationRequest,
                          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateUnitOperation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .CreateUnitOperationRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SaasDeploymentsMethodDescriptorSupplier("CreateUnitOperation"))
                      .build();
        }
      }
    }
    return getCreateUnitOperationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitOperationRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation>
      getUpdateUnitOperationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUnitOperation",
      requestType =
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitOperationRequest.class,
      responseType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitOperationRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation>
      getUpdateUnitOperationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitOperationRequest,
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation>
        getUpdateUnitOperationMethod;
    if ((getUpdateUnitOperationMethod = SaasDeploymentsGrpc.getUpdateUnitOperationMethod) == null) {
      synchronized (SaasDeploymentsGrpc.class) {
        if ((getUpdateUnitOperationMethod = SaasDeploymentsGrpc.getUpdateUnitOperationMethod)
            == null) {
          SaasDeploymentsGrpc.getUpdateUnitOperationMethod =
              getUpdateUnitOperationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                              .UpdateUnitOperationRequest,
                          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateUnitOperation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .UpdateUnitOperationRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SaasDeploymentsMethodDescriptorSupplier("UpdateUnitOperation"))
                      .build();
        }
      }
    }
    return getUpdateUnitOperationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitOperationRequest,
          com.google.protobuf.Empty>
      getDeleteUnitOperationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteUnitOperation",
      requestType =
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitOperationRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitOperationRequest,
          com.google.protobuf.Empty>
      getDeleteUnitOperationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitOperationRequest,
            com.google.protobuf.Empty>
        getDeleteUnitOperationMethod;
    if ((getDeleteUnitOperationMethod = SaasDeploymentsGrpc.getDeleteUnitOperationMethod) == null) {
      synchronized (SaasDeploymentsGrpc.class) {
        if ((getDeleteUnitOperationMethod = SaasDeploymentsGrpc.getDeleteUnitOperationMethod)
            == null) {
          SaasDeploymentsGrpc.getDeleteUnitOperationMethod =
              getDeleteUnitOperationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                              .DeleteUnitOperationRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteUnitOperation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .DeleteUnitOperationRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SaasDeploymentsMethodDescriptorSupplier("DeleteUnitOperation"))
                      .build();
        }
      }
    }
    return getDeleteUnitOperationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListReleasesRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListReleasesResponse>
      getListReleasesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListReleases",
      requestType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListReleasesRequest.class,
      responseType =
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListReleasesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListReleasesRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListReleasesResponse>
      getListReleasesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListReleasesRequest,
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListReleasesResponse>
        getListReleasesMethod;
    if ((getListReleasesMethod = SaasDeploymentsGrpc.getListReleasesMethod) == null) {
      synchronized (SaasDeploymentsGrpc.class) {
        if ((getListReleasesMethod = SaasDeploymentsGrpc.getListReleasesMethod) == null) {
          SaasDeploymentsGrpc.getListReleasesMethod =
              getListReleasesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListReleasesRequest,
                          com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                              .ListReleasesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListReleases"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .ListReleasesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .ListReleasesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SaasDeploymentsMethodDescriptorSupplier("ListReleases"))
                      .build();
        }
      }
    }
    return getListReleasesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetReleaseRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release>
      getGetReleaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRelease",
      requestType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetReleaseRequest.class,
      responseType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetReleaseRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release>
      getGetReleaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetReleaseRequest,
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release>
        getGetReleaseMethod;
    if ((getGetReleaseMethod = SaasDeploymentsGrpc.getGetReleaseMethod) == null) {
      synchronized (SaasDeploymentsGrpc.class) {
        if ((getGetReleaseMethod = SaasDeploymentsGrpc.getGetReleaseMethod) == null) {
          SaasDeploymentsGrpc.getGetReleaseMethod =
              getGetReleaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetReleaseRequest,
                          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRelease"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .GetReleaseRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SaasDeploymentsMethodDescriptorSupplier("GetRelease"))
                      .build();
        }
      }
    }
    return getGetReleaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateReleaseRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release>
      getCreateReleaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRelease",
      requestType =
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateReleaseRequest.class,
      responseType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateReleaseRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release>
      getCreateReleaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateReleaseRequest,
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release>
        getCreateReleaseMethod;
    if ((getCreateReleaseMethod = SaasDeploymentsGrpc.getCreateReleaseMethod) == null) {
      synchronized (SaasDeploymentsGrpc.class) {
        if ((getCreateReleaseMethod = SaasDeploymentsGrpc.getCreateReleaseMethod) == null) {
          SaasDeploymentsGrpc.getCreateReleaseMethod =
              getCreateReleaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateReleaseRequest,
                          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRelease"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .CreateReleaseRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SaasDeploymentsMethodDescriptorSupplier("CreateRelease"))
                      .build();
        }
      }
    }
    return getCreateReleaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateReleaseRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release>
      getUpdateReleaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateRelease",
      requestType =
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateReleaseRequest.class,
      responseType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateReleaseRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release>
      getUpdateReleaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateReleaseRequest,
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release>
        getUpdateReleaseMethod;
    if ((getUpdateReleaseMethod = SaasDeploymentsGrpc.getUpdateReleaseMethod) == null) {
      synchronized (SaasDeploymentsGrpc.class) {
        if ((getUpdateReleaseMethod = SaasDeploymentsGrpc.getUpdateReleaseMethod) == null) {
          SaasDeploymentsGrpc.getUpdateReleaseMethod =
              getUpdateReleaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateReleaseRequest,
                          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateRelease"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .UpdateReleaseRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SaasDeploymentsMethodDescriptorSupplier("UpdateRelease"))
                      .build();
        }
      }
    }
    return getUpdateReleaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteReleaseRequest,
          com.google.protobuf.Empty>
      getDeleteReleaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRelease",
      requestType =
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteReleaseRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteReleaseRequest,
          com.google.protobuf.Empty>
      getDeleteReleaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteReleaseRequest,
            com.google.protobuf.Empty>
        getDeleteReleaseMethod;
    if ((getDeleteReleaseMethod = SaasDeploymentsGrpc.getDeleteReleaseMethod) == null) {
      synchronized (SaasDeploymentsGrpc.class) {
        if ((getDeleteReleaseMethod = SaasDeploymentsGrpc.getDeleteReleaseMethod) == null) {
          SaasDeploymentsGrpc.getDeleteReleaseMethod =
              getDeleteReleaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteReleaseRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRelease"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .DeleteReleaseRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SaasDeploymentsMethodDescriptorSupplier("DeleteRelease"))
                      .build();
        }
      }
    }
    return getDeleteReleaseMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SaasDeploymentsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SaasDeploymentsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SaasDeploymentsStub>() {
          @java.lang.Override
          public SaasDeploymentsStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SaasDeploymentsStub(channel, callOptions);
          }
        };
    return SaasDeploymentsStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static SaasDeploymentsBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SaasDeploymentsBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SaasDeploymentsBlockingV2Stub>() {
          @java.lang.Override
          public SaasDeploymentsBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SaasDeploymentsBlockingV2Stub(channel, callOptions);
          }
        };
    return SaasDeploymentsBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SaasDeploymentsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SaasDeploymentsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SaasDeploymentsBlockingStub>() {
          @java.lang.Override
          public SaasDeploymentsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SaasDeploymentsBlockingStub(channel, callOptions);
          }
        };
    return SaasDeploymentsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SaasDeploymentsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SaasDeploymentsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SaasDeploymentsFutureStub>() {
          @java.lang.Override
          public SaasDeploymentsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SaasDeploymentsFutureStub(channel, callOptions);
          }
        };
    return SaasDeploymentsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Manages the deployment of SaaS services.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Retrieve a collection of saas.
     * </pre>
     */
    default void listSaas(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListSaasRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListSaasResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListSaasMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single saas.
     * </pre>
     */
    default void getSaas(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetSaasRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSaasMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new saas.
     * </pre>
     */
    default void createSaas(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateSaasRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateSaasMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single saas.
     * </pre>
     */
    default void updateSaas(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateSaasRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateSaasMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single saas.
     * </pre>
     */
    default void deleteSaas(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteSaasRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteSaasMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of tenants.
     * </pre>
     */
    default void listTenants(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListTenantsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListTenantsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListTenantsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single tenant.
     * </pre>
     */
    default void getTenant(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetTenantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTenantMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new tenant.
     * </pre>
     */
    default void createTenant(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateTenantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateTenantMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single tenant.
     * </pre>
     */
    default void updateTenant(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateTenantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateTenantMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single tenant.
     * </pre>
     */
    default void deleteTenant(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteTenantRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteTenantMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of unit kinds.
     * </pre>
     */
    default void listUnitKinds(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitKindsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitKindsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListUnitKindsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single unit kind.
     * </pre>
     */
    default void getUnitKind(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitKindRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetUnitKindMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new unit kind.
     * </pre>
     */
    default void createUnitKind(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitKindRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateUnitKindMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single unit kind.
     * </pre>
     */
    default void updateUnitKind(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitKindRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateUnitKindMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single unit kind.
     * </pre>
     */
    default void deleteUnitKind(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitKindRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteUnitKindMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of units.
     * </pre>
     */
    default void listUnits(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListUnitsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single unit.
     * </pre>
     */
    default void getUnit(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUnitMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new unit.
     * </pre>
     */
    default void createUnit(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateUnitMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single unit.
     * </pre>
     */
    default void updateUnit(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateUnitMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single unit.
     * </pre>
     */
    default void deleteUnit(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteUnitMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of unit operations.
     * </pre>
     */
    default void listUnitOperations(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitOperationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitOperationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListUnitOperationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single unit operation.
     * </pre>
     */
    default void getUnitOperation(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitOperationRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetUnitOperationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new unit operation.
     * </pre>
     */
    default void createUnitOperation(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitOperationRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateUnitOperationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single unit operation.
     * </pre>
     */
    default void updateUnitOperation(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitOperationRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateUnitOperationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single unit operation.
     * </pre>
     */
    default void deleteUnitOperation(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitOperationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteUnitOperationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of releases.
     * </pre>
     */
    default void listReleases(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListReleasesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListReleasesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListReleasesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single release.
     * </pre>
     */
    default void getRelease(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetReleaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetReleaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new release.
     * </pre>
     */
    default void createRelease(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateReleaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateReleaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single release.
     * </pre>
     */
    default void updateRelease(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateReleaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateReleaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single release.
     * </pre>
     */
    default void deleteRelease(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteReleaseRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteReleaseMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SaasDeployments.
   *
   * <pre>
   * Manages the deployment of SaaS services.
   * </pre>
   */
  public abstract static class SaasDeploymentsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SaasDeploymentsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SaasDeployments.
   *
   * <pre>
   * Manages the deployment of SaaS services.
   * </pre>
   */
  public static final class SaasDeploymentsStub
      extends io.grpc.stub.AbstractAsyncStub<SaasDeploymentsStub> {
    private SaasDeploymentsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SaasDeploymentsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SaasDeploymentsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of saas.
     * </pre>
     */
    public void listSaas(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListSaasRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListSaasResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSaasMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single saas.
     * </pre>
     */
    public void getSaas(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetSaasRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSaasMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new saas.
     * </pre>
     */
    public void createSaas(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateSaasRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSaasMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single saas.
     * </pre>
     */
    public void updateSaas(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateSaasRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSaasMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single saas.
     * </pre>
     */
    public void deleteSaas(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteSaasRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSaasMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of tenants.
     * </pre>
     */
    public void listTenants(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListTenantsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListTenantsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTenantsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single tenant.
     * </pre>
     */
    public void getTenant(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetTenantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTenantMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new tenant.
     * </pre>
     */
    public void createTenant(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateTenantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTenantMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single tenant.
     * </pre>
     */
    public void updateTenant(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateTenantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTenantMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single tenant.
     * </pre>
     */
    public void deleteTenant(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteTenantRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTenantMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of unit kinds.
     * </pre>
     */
    public void listUnitKinds(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitKindsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitKindsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListUnitKindsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single unit kind.
     * </pre>
     */
    public void getUnitKind(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitKindRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUnitKindMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new unit kind.
     * </pre>
     */
    public void createUnitKind(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitKindRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateUnitKindMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single unit kind.
     * </pre>
     */
    public void updateUnitKind(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitKindRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateUnitKindMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single unit kind.
     * </pre>
     */
    public void deleteUnitKind(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitKindRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteUnitKindMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of units.
     * </pre>
     */
    public void listUnits(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListUnitsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single unit.
     * </pre>
     */
    public void getUnit(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUnitMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new unit.
     * </pre>
     */
    public void createUnit(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateUnitMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single unit.
     * </pre>
     */
    public void updateUnit(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateUnitMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single unit.
     * </pre>
     */
    public void deleteUnit(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteUnitMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of unit operations.
     * </pre>
     */
    public void listUnitOperations(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitOperationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitOperationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListUnitOperationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single unit operation.
     * </pre>
     */
    public void getUnitOperation(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitOperationRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUnitOperationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new unit operation.
     * </pre>
     */
    public void createUnitOperation(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitOperationRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateUnitOperationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single unit operation.
     * </pre>
     */
    public void updateUnitOperation(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitOperationRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateUnitOperationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single unit operation.
     * </pre>
     */
    public void deleteUnitOperation(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitOperationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteUnitOperationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of releases.
     * </pre>
     */
    public void listReleases(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListReleasesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListReleasesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListReleasesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single release.
     * </pre>
     */
    public void getRelease(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetReleaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetReleaseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new release.
     * </pre>
     */
    public void createRelease(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateReleaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateReleaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single release.
     * </pre>
     */
    public void updateRelease(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateReleaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateReleaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single release.
     * </pre>
     */
    public void deleteRelease(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteReleaseRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteReleaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SaasDeployments.
   *
   * <pre>
   * Manages the deployment of SaaS services.
   * </pre>
   */
  public static final class SaasDeploymentsBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<SaasDeploymentsBlockingV2Stub> {
    private SaasDeploymentsBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SaasDeploymentsBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SaasDeploymentsBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of saas.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListSaasResponse listSaas(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListSaasRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSaasMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single saas.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas getSaas(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetSaasRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSaasMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new saas.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas createSaas(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateSaasRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSaasMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single saas.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas updateSaas(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateSaasRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSaasMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single saas.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSaas(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteSaasRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSaasMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of tenants.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListTenantsResponse listTenants(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListTenantsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTenantsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single tenant.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant getTenant(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetTenantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTenantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new tenant.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant createTenant(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateTenantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTenantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single tenant.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant updateTenant(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateTenantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTenantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single tenant.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTenant(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteTenantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTenantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of unit kinds.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitKindsResponse
        listUnitKinds(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitKindsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUnitKindsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single unit kind.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind getUnitKind(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitKindRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUnitKindMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new unit kind.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind createUnitKind(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitKindRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUnitKindMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single unit kind.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind updateUnitKind(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitKindRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUnitKindMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single unit kind.
     * </pre>
     */
    public com.google.protobuf.Empty deleteUnitKind(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitKindRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteUnitKindMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of units.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitsResponse listUnits(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUnitsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single unit.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit getUnit(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUnitMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new unit.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit createUnit(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUnitMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single unit.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit updateUnit(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUnitMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single unit.
     * </pre>
     */
    public com.google.protobuf.Empty deleteUnit(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteUnitMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of unit operations.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitOperationsResponse
        listUnitOperations(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitOperationsRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUnitOperationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single unit operation.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation getUnitOperation(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitOperationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUnitOperationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new unit operation.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation createUnitOperation(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitOperationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUnitOperationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single unit operation.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation updateUnitOperation(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitOperationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUnitOperationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single unit operation.
     * </pre>
     */
    public com.google.protobuf.Empty deleteUnitOperation(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitOperationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteUnitOperationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of releases.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListReleasesResponse listReleases(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListReleasesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListReleasesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single release.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release getRelease(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetReleaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetReleaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new release.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release createRelease(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateReleaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateReleaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single release.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release updateRelease(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateReleaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateReleaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single release.
     * </pre>
     */
    public com.google.protobuf.Empty deleteRelease(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteReleaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteReleaseMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service SaasDeployments.
   *
   * <pre>
   * Manages the deployment of SaaS services.
   * </pre>
   */
  public static final class SaasDeploymentsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SaasDeploymentsBlockingStub> {
    private SaasDeploymentsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SaasDeploymentsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SaasDeploymentsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of saas.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListSaasResponse listSaas(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListSaasRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSaasMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single saas.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas getSaas(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetSaasRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSaasMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new saas.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas createSaas(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateSaasRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSaasMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single saas.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas updateSaas(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateSaasRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSaasMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single saas.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSaas(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteSaasRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSaasMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of tenants.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListTenantsResponse listTenants(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListTenantsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTenantsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single tenant.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant getTenant(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetTenantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTenantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new tenant.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant createTenant(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateTenantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTenantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single tenant.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant updateTenant(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateTenantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTenantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single tenant.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTenant(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteTenantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTenantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of unit kinds.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitKindsResponse
        listUnitKinds(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitKindsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUnitKindsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single unit kind.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind getUnitKind(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitKindRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUnitKindMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new unit kind.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind createUnitKind(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitKindRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUnitKindMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single unit kind.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind updateUnitKind(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitKindRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUnitKindMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single unit kind.
     * </pre>
     */
    public com.google.protobuf.Empty deleteUnitKind(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitKindRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteUnitKindMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of units.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitsResponse listUnits(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUnitsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single unit.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit getUnit(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUnitMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new unit.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit createUnit(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUnitMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single unit.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit updateUnit(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUnitMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single unit.
     * </pre>
     */
    public com.google.protobuf.Empty deleteUnit(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteUnitMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of unit operations.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitOperationsResponse
        listUnitOperations(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitOperationsRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUnitOperationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single unit operation.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation getUnitOperation(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitOperationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUnitOperationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new unit operation.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation createUnitOperation(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitOperationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUnitOperationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single unit operation.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation updateUnitOperation(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitOperationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUnitOperationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single unit operation.
     * </pre>
     */
    public com.google.protobuf.Empty deleteUnitOperation(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitOperationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteUnitOperationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of releases.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListReleasesResponse listReleases(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListReleasesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListReleasesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single release.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release getRelease(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetReleaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetReleaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new release.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release createRelease(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateReleaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateReleaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single release.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release updateRelease(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateReleaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateReleaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single release.
     * </pre>
     */
    public com.google.protobuf.Empty deleteRelease(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteReleaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteReleaseMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SaasDeployments.
   *
   * <pre>
   * Manages the deployment of SaaS services.
   * </pre>
   */
  public static final class SaasDeploymentsFutureStub
      extends io.grpc.stub.AbstractFutureStub<SaasDeploymentsFutureStub> {
    private SaasDeploymentsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SaasDeploymentsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SaasDeploymentsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of saas.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListSaasResponse>
        listSaas(com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListSaasRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSaasMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single saas.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas>
        getSaas(com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetSaasRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSaasMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new saas.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas>
        createSaas(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateSaasRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSaasMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single saas.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas>
        updateSaas(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateSaasRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSaasMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single saas.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteSaas(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteSaasRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSaasMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of tenants.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListTenantsResponse>
        listTenants(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListTenantsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTenantsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single tenant.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant>
        getTenant(com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetTenantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTenantMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new tenant.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant>
        createTenant(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateTenantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTenantMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single tenant.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant>
        updateTenant(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateTenantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTenantMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single tenant.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteTenant(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteTenantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTenantMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of unit kinds.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitKindsResponse>
        listUnitKinds(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitKindsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListUnitKindsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single unit kind.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind>
        getUnitKind(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitKindRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUnitKindMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new unit kind.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind>
        createUnitKind(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitKindRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateUnitKindMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single unit kind.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind>
        updateUnitKind(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitKindRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateUnitKindMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single unit kind.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteUnitKind(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitKindRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteUnitKindMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of units.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitsResponse>
        listUnits(com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListUnitsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single unit.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit>
        getUnit(com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUnitMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new unit.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit>
        createUnit(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateUnitMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single unit.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit>
        updateUnit(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateUnitMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single unit.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteUnit(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteUnitMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of unit operations.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitOperationsResponse>
        listUnitOperations(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitOperationsRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListUnitOperationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single unit operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation>
        getUnitOperation(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitOperationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUnitOperationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new unit operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation>
        createUnitOperation(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitOperationRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateUnitOperationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single unit operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation>
        updateUnitOperation(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitOperationRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateUnitOperationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single unit operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteUnitOperation(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitOperationRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteUnitOperationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of releases.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListReleasesResponse>
        listReleases(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListReleasesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListReleasesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single release.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release>
        getRelease(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetReleaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetReleaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new release.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release>
        createRelease(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateReleaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateReleaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single release.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release>
        updateRelease(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateReleaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateReleaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single release.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteRelease(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteReleaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteReleaseMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_SAAS = 0;
  private static final int METHODID_GET_SAAS = 1;
  private static final int METHODID_CREATE_SAAS = 2;
  private static final int METHODID_UPDATE_SAAS = 3;
  private static final int METHODID_DELETE_SAAS = 4;
  private static final int METHODID_LIST_TENANTS = 5;
  private static final int METHODID_GET_TENANT = 6;
  private static final int METHODID_CREATE_TENANT = 7;
  private static final int METHODID_UPDATE_TENANT = 8;
  private static final int METHODID_DELETE_TENANT = 9;
  private static final int METHODID_LIST_UNIT_KINDS = 10;
  private static final int METHODID_GET_UNIT_KIND = 11;
  private static final int METHODID_CREATE_UNIT_KIND = 12;
  private static final int METHODID_UPDATE_UNIT_KIND = 13;
  private static final int METHODID_DELETE_UNIT_KIND = 14;
  private static final int METHODID_LIST_UNITS = 15;
  private static final int METHODID_GET_UNIT = 16;
  private static final int METHODID_CREATE_UNIT = 17;
  private static final int METHODID_UPDATE_UNIT = 18;
  private static final int METHODID_DELETE_UNIT = 19;
  private static final int METHODID_LIST_UNIT_OPERATIONS = 20;
  private static final int METHODID_GET_UNIT_OPERATION = 21;
  private static final int METHODID_CREATE_UNIT_OPERATION = 22;
  private static final int METHODID_UPDATE_UNIT_OPERATION = 23;
  private static final int METHODID_DELETE_UNIT_OPERATION = 24;
  private static final int METHODID_LIST_RELEASES = 25;
  private static final int METHODID_GET_RELEASE = 26;
  private static final int METHODID_CREATE_RELEASE = 27;
  private static final int METHODID_UPDATE_RELEASE = 28;
  private static final int METHODID_DELETE_RELEASE = 29;

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
        case METHODID_LIST_SAAS:
          serviceImpl.listSaas(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListSaasRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListSaasResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SAAS:
          serviceImpl.getSaas(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetSaasRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas>)
                  responseObserver);
          break;
        case METHODID_CREATE_SAAS:
          serviceImpl.createSaas(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateSaasRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SAAS:
          serviceImpl.updateSaas(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateSaasRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas>)
                  responseObserver);
          break;
        case METHODID_DELETE_SAAS:
          serviceImpl.deleteSaas(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteSaasRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_TENANTS:
          serviceImpl.listTenants(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListTenantsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListTenantsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_TENANT:
          serviceImpl.getTenant(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetTenantRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant>)
                  responseObserver);
          break;
        case METHODID_CREATE_TENANT:
          serviceImpl.createTenant(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateTenantRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant>)
                  responseObserver);
          break;
        case METHODID_UPDATE_TENANT:
          serviceImpl.updateTenant(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateTenantRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant>)
                  responseObserver);
          break;
        case METHODID_DELETE_TENANT:
          serviceImpl.deleteTenant(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteTenantRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_UNIT_KINDS:
          serviceImpl.listUnitKinds(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitKindsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitKindsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_UNIT_KIND:
          serviceImpl.getUnitKind(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitKindRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind>)
                  responseObserver);
          break;
        case METHODID_CREATE_UNIT_KIND:
          serviceImpl.createUnitKind(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitKindRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind>)
                  responseObserver);
          break;
        case METHODID_UPDATE_UNIT_KIND:
          serviceImpl.updateUnitKind(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitKindRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind>)
                  responseObserver);
          break;
        case METHODID_DELETE_UNIT_KIND:
          serviceImpl.deleteUnitKind(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitKindRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_UNITS:
          serviceImpl.listUnits(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_UNIT:
          serviceImpl.getUnit(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit>)
                  responseObserver);
          break;
        case METHODID_CREATE_UNIT:
          serviceImpl.createUnit(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit>)
                  responseObserver);
          break;
        case METHODID_UPDATE_UNIT:
          serviceImpl.updateUnit(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit>)
                  responseObserver);
          break;
        case METHODID_DELETE_UNIT:
          serviceImpl.deleteUnit(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_UNIT_OPERATIONS:
          serviceImpl.listUnitOperations(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitOperationsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                          .ListUnitOperationsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_UNIT_OPERATION:
          serviceImpl.getUnitOperation(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitOperationRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation>)
                  responseObserver);
          break;
        case METHODID_CREATE_UNIT_OPERATION:
          serviceImpl.createUnitOperation(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitOperationRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation>)
                  responseObserver);
          break;
        case METHODID_UPDATE_UNIT_OPERATION:
          serviceImpl.updateUnitOperation(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitOperationRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation>)
                  responseObserver);
          break;
        case METHODID_DELETE_UNIT_OPERATION:
          serviceImpl.deleteUnitOperation(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitOperationRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_RELEASES:
          serviceImpl.listReleases(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListReleasesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListReleasesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_RELEASE:
          serviceImpl.getRelease(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetReleaseRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release>)
                  responseObserver);
          break;
        case METHODID_CREATE_RELEASE:
          serviceImpl.createRelease(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateReleaseRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release>)
                  responseObserver);
          break;
        case METHODID_UPDATE_RELEASE:
          serviceImpl.updateRelease(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateReleaseRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release>)
                  responseObserver);
          break;
        case METHODID_DELETE_RELEASE:
          serviceImpl.deleteRelease(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteReleaseRequest) request,
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
            getListSaasMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListSaasRequest,
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListSaasResponse>(
                    service, METHODID_LIST_SAAS)))
        .addMethod(
            getGetSaasMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetSaasRequest,
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas>(
                    service, METHODID_GET_SAAS)))
        .addMethod(
            getCreateSaasMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateSaasRequest,
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas>(
                    service, METHODID_CREATE_SAAS)))
        .addMethod(
            getUpdateSaasMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateSaasRequest,
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas>(
                    service, METHODID_UPDATE_SAAS)))
        .addMethod(
            getDeleteSaasMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteSaasRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_SAAS)))
        .addMethod(
            getListTenantsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListTenantsRequest,
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListTenantsResponse>(
                    service, METHODID_LIST_TENANTS)))
        .addMethod(
            getGetTenantMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetTenantRequest,
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant>(
                    service, METHODID_GET_TENANT)))
        .addMethod(
            getCreateTenantMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateTenantRequest,
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant>(
                    service, METHODID_CREATE_TENANT)))
        .addMethod(
            getUpdateTenantMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateTenantRequest,
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant>(
                    service, METHODID_UPDATE_TENANT)))
        .addMethod(
            getDeleteTenantMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteTenantRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_TENANT)))
        .addMethod(
            getListUnitKindsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitKindsRequest,
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitKindsResponse>(
                    service, METHODID_LIST_UNIT_KINDS)))
        .addMethod(
            getGetUnitKindMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitKindRequest,
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind>(
                    service, METHODID_GET_UNIT_KIND)))
        .addMethod(
            getCreateUnitKindMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitKindRequest,
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind>(
                    service, METHODID_CREATE_UNIT_KIND)))
        .addMethod(
            getUpdateUnitKindMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitKindRequest,
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind>(
                    service, METHODID_UPDATE_UNIT_KIND)))
        .addMethod(
            getDeleteUnitKindMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitKindRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_UNIT_KIND)))
        .addMethod(
            getListUnitsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitsRequest,
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitsResponse>(
                    service, METHODID_LIST_UNITS)))
        .addMethod(
            getGetUnitMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitRequest,
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit>(
                    service, METHODID_GET_UNIT)))
        .addMethod(
            getCreateUnitMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitRequest,
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit>(
                    service, METHODID_CREATE_UNIT)))
        .addMethod(
            getUpdateUnitMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitRequest,
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit>(
                    service, METHODID_UPDATE_UNIT)))
        .addMethod(
            getDeleteUnitMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_UNIT)))
        .addMethod(
            getListUnitOperationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitOperationsRequest,
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                        .ListUnitOperationsResponse>(service, METHODID_LIST_UNIT_OPERATIONS)))
        .addMethod(
            getGetUnitOperationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitOperationRequest,
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation>(
                    service, METHODID_GET_UNIT_OPERATION)))
        .addMethod(
            getCreateUnitOperationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                        .CreateUnitOperationRequest,
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation>(
                    service, METHODID_CREATE_UNIT_OPERATION)))
        .addMethod(
            getUpdateUnitOperationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                        .UpdateUnitOperationRequest,
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation>(
                    service, METHODID_UPDATE_UNIT_OPERATION)))
        .addMethod(
            getDeleteUnitOperationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                        .DeleteUnitOperationRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_UNIT_OPERATION)))
        .addMethod(
            getListReleasesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListReleasesRequest,
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListReleasesResponse>(
                    service, METHODID_LIST_RELEASES)))
        .addMethod(
            getGetReleaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetReleaseRequest,
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release>(
                    service, METHODID_GET_RELEASE)))
        .addMethod(
            getCreateReleaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateReleaseRequest,
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release>(
                    service, METHODID_CREATE_RELEASE)))
        .addMethod(
            getUpdateReleaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateReleaseRequest,
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release>(
                    service, METHODID_UPDATE_RELEASE)))
        .addMethod(
            getDeleteReleaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteReleaseRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_RELEASE)))
        .build();
  }

  private abstract static class SaasDeploymentsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SaasDeploymentsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsServiceProto
          .getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SaasDeployments");
    }
  }

  private static final class SaasDeploymentsFileDescriptorSupplier
      extends SaasDeploymentsBaseDescriptorSupplier {
    SaasDeploymentsFileDescriptorSupplier() {}
  }

  private static final class SaasDeploymentsMethodDescriptorSupplier
      extends SaasDeploymentsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SaasDeploymentsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SaasDeploymentsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SaasDeploymentsFileDescriptorSupplier())
                      .addMethod(getListSaasMethod())
                      .addMethod(getGetSaasMethod())
                      .addMethod(getCreateSaasMethod())
                      .addMethod(getUpdateSaasMethod())
                      .addMethod(getDeleteSaasMethod())
                      .addMethod(getListTenantsMethod())
                      .addMethod(getGetTenantMethod())
                      .addMethod(getCreateTenantMethod())
                      .addMethod(getUpdateTenantMethod())
                      .addMethod(getDeleteTenantMethod())
                      .addMethod(getListUnitKindsMethod())
                      .addMethod(getGetUnitKindMethod())
                      .addMethod(getCreateUnitKindMethod())
                      .addMethod(getUpdateUnitKindMethod())
                      .addMethod(getDeleteUnitKindMethod())
                      .addMethod(getListUnitsMethod())
                      .addMethod(getGetUnitMethod())
                      .addMethod(getCreateUnitMethod())
                      .addMethod(getUpdateUnitMethod())
                      .addMethod(getDeleteUnitMethod())
                      .addMethod(getListUnitOperationsMethod())
                      .addMethod(getGetUnitOperationMethod())
                      .addMethod(getCreateUnitOperationMethod())
                      .addMethod(getUpdateUnitOperationMethod())
                      .addMethod(getDeleteUnitOperationMethod())
                      .addMethod(getListReleasesMethod())
                      .addMethod(getGetReleaseMethod())
                      .addMethod(getCreateReleaseMethod())
                      .addMethod(getUpdateReleaseMethod())
                      .addMethod(getDeleteReleaseMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
