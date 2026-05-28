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
package com.google.cloud.numberregistry.v1alpha;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The Cloud Number Registry service manages IP address space visibility and
 * tracking. It enables the discovery, organization, and monitoring of IP
 * address ranges across different cloud infrastructure platforms.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class CloudNumberRegistryGrpc {

  private CloudNumberRegistryGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.numberregistry.v1alpha.CloudNumberRegistry";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.ListIpamAdminScopesRequest,
          com.google.cloud.numberregistry.v1alpha.ListIpamAdminScopesResponse>
      getListIpamAdminScopesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListIpamAdminScopes",
      requestType = com.google.cloud.numberregistry.v1alpha.ListIpamAdminScopesRequest.class,
      responseType = com.google.cloud.numberregistry.v1alpha.ListIpamAdminScopesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.ListIpamAdminScopesRequest,
          com.google.cloud.numberregistry.v1alpha.ListIpamAdminScopesResponse>
      getListIpamAdminScopesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.numberregistry.v1alpha.ListIpamAdminScopesRequest,
            com.google.cloud.numberregistry.v1alpha.ListIpamAdminScopesResponse>
        getListIpamAdminScopesMethod;
    if ((getListIpamAdminScopesMethod = CloudNumberRegistryGrpc.getListIpamAdminScopesMethod)
        == null) {
      synchronized (CloudNumberRegistryGrpc.class) {
        if ((getListIpamAdminScopesMethod = CloudNumberRegistryGrpc.getListIpamAdminScopesMethod)
            == null) {
          CloudNumberRegistryGrpc.getListIpamAdminScopesMethod =
              getListIpamAdminScopesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.numberregistry.v1alpha.ListIpamAdminScopesRequest,
                          com.google.cloud.numberregistry.v1alpha.ListIpamAdminScopesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListIpamAdminScopes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.ListIpamAdminScopesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.ListIpamAdminScopesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudNumberRegistryMethodDescriptorSupplier("ListIpamAdminScopes"))
                      .build();
        }
      }
    }
    return getListIpamAdminScopesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.GetIpamAdminScopeRequest,
          com.google.cloud.numberregistry.v1alpha.IpamAdminScope>
      getGetIpamAdminScopeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIpamAdminScope",
      requestType = com.google.cloud.numberregistry.v1alpha.GetIpamAdminScopeRequest.class,
      responseType = com.google.cloud.numberregistry.v1alpha.IpamAdminScope.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.GetIpamAdminScopeRequest,
          com.google.cloud.numberregistry.v1alpha.IpamAdminScope>
      getGetIpamAdminScopeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.numberregistry.v1alpha.GetIpamAdminScopeRequest,
            com.google.cloud.numberregistry.v1alpha.IpamAdminScope>
        getGetIpamAdminScopeMethod;
    if ((getGetIpamAdminScopeMethod = CloudNumberRegistryGrpc.getGetIpamAdminScopeMethod) == null) {
      synchronized (CloudNumberRegistryGrpc.class) {
        if ((getGetIpamAdminScopeMethod = CloudNumberRegistryGrpc.getGetIpamAdminScopeMethod)
            == null) {
          CloudNumberRegistryGrpc.getGetIpamAdminScopeMethod =
              getGetIpamAdminScopeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.numberregistry.v1alpha.GetIpamAdminScopeRequest,
                          com.google.cloud.numberregistry.v1alpha.IpamAdminScope>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIpamAdminScope"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.GetIpamAdminScopeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.IpamAdminScope
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudNumberRegistryMethodDescriptorSupplier("GetIpamAdminScope"))
                      .build();
        }
      }
    }
    return getGetIpamAdminScopeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.CheckAvailabilityIpamAdminScopesRequest,
          com.google.cloud.numberregistry.v1alpha.CheckAvailabilityIpamAdminScopesResponse>
      getCheckAvailabilityIpamAdminScopesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckAvailabilityIpamAdminScopes",
      requestType =
          com.google.cloud.numberregistry.v1alpha.CheckAvailabilityIpamAdminScopesRequest.class,
      responseType =
          com.google.cloud.numberregistry.v1alpha.CheckAvailabilityIpamAdminScopesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.CheckAvailabilityIpamAdminScopesRequest,
          com.google.cloud.numberregistry.v1alpha.CheckAvailabilityIpamAdminScopesResponse>
      getCheckAvailabilityIpamAdminScopesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.numberregistry.v1alpha.CheckAvailabilityIpamAdminScopesRequest,
            com.google.cloud.numberregistry.v1alpha.CheckAvailabilityIpamAdminScopesResponse>
        getCheckAvailabilityIpamAdminScopesMethod;
    if ((getCheckAvailabilityIpamAdminScopesMethod =
            CloudNumberRegistryGrpc.getCheckAvailabilityIpamAdminScopesMethod)
        == null) {
      synchronized (CloudNumberRegistryGrpc.class) {
        if ((getCheckAvailabilityIpamAdminScopesMethod =
                CloudNumberRegistryGrpc.getCheckAvailabilityIpamAdminScopesMethod)
            == null) {
          CloudNumberRegistryGrpc.getCheckAvailabilityIpamAdminScopesMethod =
              getCheckAvailabilityIpamAdminScopesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.numberregistry.v1alpha
                              .CheckAvailabilityIpamAdminScopesRequest,
                          com.google.cloud.numberregistry.v1alpha
                              .CheckAvailabilityIpamAdminScopesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CheckAvailabilityIpamAdminScopes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha
                                  .CheckAvailabilityIpamAdminScopesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha
                                  .CheckAvailabilityIpamAdminScopesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudNumberRegistryMethodDescriptorSupplier(
                              "CheckAvailabilityIpamAdminScopes"))
                      .build();
        }
      }
    }
    return getCheckAvailabilityIpamAdminScopesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.CreateIpamAdminScopeRequest,
          com.google.longrunning.Operation>
      getCreateIpamAdminScopeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateIpamAdminScope",
      requestType = com.google.cloud.numberregistry.v1alpha.CreateIpamAdminScopeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.CreateIpamAdminScopeRequest,
          com.google.longrunning.Operation>
      getCreateIpamAdminScopeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.numberregistry.v1alpha.CreateIpamAdminScopeRequest,
            com.google.longrunning.Operation>
        getCreateIpamAdminScopeMethod;
    if ((getCreateIpamAdminScopeMethod = CloudNumberRegistryGrpc.getCreateIpamAdminScopeMethod)
        == null) {
      synchronized (CloudNumberRegistryGrpc.class) {
        if ((getCreateIpamAdminScopeMethod = CloudNumberRegistryGrpc.getCreateIpamAdminScopeMethod)
            == null) {
          CloudNumberRegistryGrpc.getCreateIpamAdminScopeMethod =
              getCreateIpamAdminScopeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.numberregistry.v1alpha.CreateIpamAdminScopeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateIpamAdminScope"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.CreateIpamAdminScopeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudNumberRegistryMethodDescriptorSupplier("CreateIpamAdminScope"))
                      .build();
        }
      }
    }
    return getCreateIpamAdminScopeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.UpdateIpamAdminScopeRequest,
          com.google.longrunning.Operation>
      getUpdateIpamAdminScopeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateIpamAdminScope",
      requestType = com.google.cloud.numberregistry.v1alpha.UpdateIpamAdminScopeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.UpdateIpamAdminScopeRequest,
          com.google.longrunning.Operation>
      getUpdateIpamAdminScopeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.numberregistry.v1alpha.UpdateIpamAdminScopeRequest,
            com.google.longrunning.Operation>
        getUpdateIpamAdminScopeMethod;
    if ((getUpdateIpamAdminScopeMethod = CloudNumberRegistryGrpc.getUpdateIpamAdminScopeMethod)
        == null) {
      synchronized (CloudNumberRegistryGrpc.class) {
        if ((getUpdateIpamAdminScopeMethod = CloudNumberRegistryGrpc.getUpdateIpamAdminScopeMethod)
            == null) {
          CloudNumberRegistryGrpc.getUpdateIpamAdminScopeMethod =
              getUpdateIpamAdminScopeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.numberregistry.v1alpha.UpdateIpamAdminScopeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateIpamAdminScope"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.UpdateIpamAdminScopeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudNumberRegistryMethodDescriptorSupplier("UpdateIpamAdminScope"))
                      .build();
        }
      }
    }
    return getUpdateIpamAdminScopeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.DeleteIpamAdminScopeRequest,
          com.google.longrunning.Operation>
      getDeleteIpamAdminScopeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteIpamAdminScope",
      requestType = com.google.cloud.numberregistry.v1alpha.DeleteIpamAdminScopeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.DeleteIpamAdminScopeRequest,
          com.google.longrunning.Operation>
      getDeleteIpamAdminScopeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.numberregistry.v1alpha.DeleteIpamAdminScopeRequest,
            com.google.longrunning.Operation>
        getDeleteIpamAdminScopeMethod;
    if ((getDeleteIpamAdminScopeMethod = CloudNumberRegistryGrpc.getDeleteIpamAdminScopeMethod)
        == null) {
      synchronized (CloudNumberRegistryGrpc.class) {
        if ((getDeleteIpamAdminScopeMethod = CloudNumberRegistryGrpc.getDeleteIpamAdminScopeMethod)
            == null) {
          CloudNumberRegistryGrpc.getDeleteIpamAdminScopeMethod =
              getDeleteIpamAdminScopeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.numberregistry.v1alpha.DeleteIpamAdminScopeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteIpamAdminScope"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.DeleteIpamAdminScopeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudNumberRegistryMethodDescriptorSupplier("DeleteIpamAdminScope"))
                      .build();
        }
      }
    }
    return getDeleteIpamAdminScopeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.DisableIpamAdminScopeRequest,
          com.google.longrunning.Operation>
      getDisableIpamAdminScopeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DisableIpamAdminScope",
      requestType = com.google.cloud.numberregistry.v1alpha.DisableIpamAdminScopeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.DisableIpamAdminScopeRequest,
          com.google.longrunning.Operation>
      getDisableIpamAdminScopeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.numberregistry.v1alpha.DisableIpamAdminScopeRequest,
            com.google.longrunning.Operation>
        getDisableIpamAdminScopeMethod;
    if ((getDisableIpamAdminScopeMethod = CloudNumberRegistryGrpc.getDisableIpamAdminScopeMethod)
        == null) {
      synchronized (CloudNumberRegistryGrpc.class) {
        if ((getDisableIpamAdminScopeMethod =
                CloudNumberRegistryGrpc.getDisableIpamAdminScopeMethod)
            == null) {
          CloudNumberRegistryGrpc.getDisableIpamAdminScopeMethod =
              getDisableIpamAdminScopeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.numberregistry.v1alpha.DisableIpamAdminScopeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DisableIpamAdminScope"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.DisableIpamAdminScopeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudNumberRegistryMethodDescriptorSupplier("DisableIpamAdminScope"))
                      .build();
        }
      }
    }
    return getDisableIpamAdminScopeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.CleanupIpamAdminScopeRequest,
          com.google.longrunning.Operation>
      getCleanupIpamAdminScopeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CleanupIpamAdminScope",
      requestType = com.google.cloud.numberregistry.v1alpha.CleanupIpamAdminScopeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.CleanupIpamAdminScopeRequest,
          com.google.longrunning.Operation>
      getCleanupIpamAdminScopeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.numberregistry.v1alpha.CleanupIpamAdminScopeRequest,
            com.google.longrunning.Operation>
        getCleanupIpamAdminScopeMethod;
    if ((getCleanupIpamAdminScopeMethod = CloudNumberRegistryGrpc.getCleanupIpamAdminScopeMethod)
        == null) {
      synchronized (CloudNumberRegistryGrpc.class) {
        if ((getCleanupIpamAdminScopeMethod =
                CloudNumberRegistryGrpc.getCleanupIpamAdminScopeMethod)
            == null) {
          CloudNumberRegistryGrpc.getCleanupIpamAdminScopeMethod =
              getCleanupIpamAdminScopeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.numberregistry.v1alpha.CleanupIpamAdminScopeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CleanupIpamAdminScope"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.CleanupIpamAdminScopeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudNumberRegistryMethodDescriptorSupplier("CleanupIpamAdminScope"))
                      .build();
        }
      }
    }
    return getCleanupIpamAdminScopeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.ListRegistryBooksRequest,
          com.google.cloud.numberregistry.v1alpha.ListRegistryBooksResponse>
      getListRegistryBooksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRegistryBooks",
      requestType = com.google.cloud.numberregistry.v1alpha.ListRegistryBooksRequest.class,
      responseType = com.google.cloud.numberregistry.v1alpha.ListRegistryBooksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.ListRegistryBooksRequest,
          com.google.cloud.numberregistry.v1alpha.ListRegistryBooksResponse>
      getListRegistryBooksMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.numberregistry.v1alpha.ListRegistryBooksRequest,
            com.google.cloud.numberregistry.v1alpha.ListRegistryBooksResponse>
        getListRegistryBooksMethod;
    if ((getListRegistryBooksMethod = CloudNumberRegistryGrpc.getListRegistryBooksMethod) == null) {
      synchronized (CloudNumberRegistryGrpc.class) {
        if ((getListRegistryBooksMethod = CloudNumberRegistryGrpc.getListRegistryBooksMethod)
            == null) {
          CloudNumberRegistryGrpc.getListRegistryBooksMethod =
              getListRegistryBooksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.numberregistry.v1alpha.ListRegistryBooksRequest,
                          com.google.cloud.numberregistry.v1alpha.ListRegistryBooksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRegistryBooks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.ListRegistryBooksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.ListRegistryBooksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudNumberRegistryMethodDescriptorSupplier("ListRegistryBooks"))
                      .build();
        }
      }
    }
    return getListRegistryBooksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.GetRegistryBookRequest,
          com.google.cloud.numberregistry.v1alpha.RegistryBook>
      getGetRegistryBookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRegistryBook",
      requestType = com.google.cloud.numberregistry.v1alpha.GetRegistryBookRequest.class,
      responseType = com.google.cloud.numberregistry.v1alpha.RegistryBook.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.GetRegistryBookRequest,
          com.google.cloud.numberregistry.v1alpha.RegistryBook>
      getGetRegistryBookMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.numberregistry.v1alpha.GetRegistryBookRequest,
            com.google.cloud.numberregistry.v1alpha.RegistryBook>
        getGetRegistryBookMethod;
    if ((getGetRegistryBookMethod = CloudNumberRegistryGrpc.getGetRegistryBookMethod) == null) {
      synchronized (CloudNumberRegistryGrpc.class) {
        if ((getGetRegistryBookMethod = CloudNumberRegistryGrpc.getGetRegistryBookMethod) == null) {
          CloudNumberRegistryGrpc.getGetRegistryBookMethod =
              getGetRegistryBookMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.numberregistry.v1alpha.GetRegistryBookRequest,
                          com.google.cloud.numberregistry.v1alpha.RegistryBook>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRegistryBook"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.GetRegistryBookRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.RegistryBook
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudNumberRegistryMethodDescriptorSupplier("GetRegistryBook"))
                      .build();
        }
      }
    }
    return getGetRegistryBookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.SearchIpResourcesRequest,
          com.google.cloud.numberregistry.v1alpha.SearchIpResourcesResponse>
      getSearchIpResourcesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchIpResources",
      requestType = com.google.cloud.numberregistry.v1alpha.SearchIpResourcesRequest.class,
      responseType = com.google.cloud.numberregistry.v1alpha.SearchIpResourcesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.SearchIpResourcesRequest,
          com.google.cloud.numberregistry.v1alpha.SearchIpResourcesResponse>
      getSearchIpResourcesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.numberregistry.v1alpha.SearchIpResourcesRequest,
            com.google.cloud.numberregistry.v1alpha.SearchIpResourcesResponse>
        getSearchIpResourcesMethod;
    if ((getSearchIpResourcesMethod = CloudNumberRegistryGrpc.getSearchIpResourcesMethod) == null) {
      synchronized (CloudNumberRegistryGrpc.class) {
        if ((getSearchIpResourcesMethod = CloudNumberRegistryGrpc.getSearchIpResourcesMethod)
            == null) {
          CloudNumberRegistryGrpc.getSearchIpResourcesMethod =
              getSearchIpResourcesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.numberregistry.v1alpha.SearchIpResourcesRequest,
                          com.google.cloud.numberregistry.v1alpha.SearchIpResourcesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchIpResources"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.SearchIpResourcesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.SearchIpResourcesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudNumberRegistryMethodDescriptorSupplier("SearchIpResources"))
                      .build();
        }
      }
    }
    return getSearchIpResourcesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.CreateRegistryBookRequest,
          com.google.longrunning.Operation>
      getCreateRegistryBookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRegistryBook",
      requestType = com.google.cloud.numberregistry.v1alpha.CreateRegistryBookRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.CreateRegistryBookRequest,
          com.google.longrunning.Operation>
      getCreateRegistryBookMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.numberregistry.v1alpha.CreateRegistryBookRequest,
            com.google.longrunning.Operation>
        getCreateRegistryBookMethod;
    if ((getCreateRegistryBookMethod = CloudNumberRegistryGrpc.getCreateRegistryBookMethod)
        == null) {
      synchronized (CloudNumberRegistryGrpc.class) {
        if ((getCreateRegistryBookMethod = CloudNumberRegistryGrpc.getCreateRegistryBookMethod)
            == null) {
          CloudNumberRegistryGrpc.getCreateRegistryBookMethod =
              getCreateRegistryBookMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.numberregistry.v1alpha.CreateRegistryBookRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRegistryBook"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.CreateRegistryBookRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudNumberRegistryMethodDescriptorSupplier("CreateRegistryBook"))
                      .build();
        }
      }
    }
    return getCreateRegistryBookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.UpdateRegistryBookRequest,
          com.google.longrunning.Operation>
      getUpdateRegistryBookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateRegistryBook",
      requestType = com.google.cloud.numberregistry.v1alpha.UpdateRegistryBookRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.UpdateRegistryBookRequest,
          com.google.longrunning.Operation>
      getUpdateRegistryBookMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.numberregistry.v1alpha.UpdateRegistryBookRequest,
            com.google.longrunning.Operation>
        getUpdateRegistryBookMethod;
    if ((getUpdateRegistryBookMethod = CloudNumberRegistryGrpc.getUpdateRegistryBookMethod)
        == null) {
      synchronized (CloudNumberRegistryGrpc.class) {
        if ((getUpdateRegistryBookMethod = CloudNumberRegistryGrpc.getUpdateRegistryBookMethod)
            == null) {
          CloudNumberRegistryGrpc.getUpdateRegistryBookMethod =
              getUpdateRegistryBookMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.numberregistry.v1alpha.UpdateRegistryBookRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateRegistryBook"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.UpdateRegistryBookRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudNumberRegistryMethodDescriptorSupplier("UpdateRegistryBook"))
                      .build();
        }
      }
    }
    return getUpdateRegistryBookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.DeleteRegistryBookRequest,
          com.google.longrunning.Operation>
      getDeleteRegistryBookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRegistryBook",
      requestType = com.google.cloud.numberregistry.v1alpha.DeleteRegistryBookRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.DeleteRegistryBookRequest,
          com.google.longrunning.Operation>
      getDeleteRegistryBookMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.numberregistry.v1alpha.DeleteRegistryBookRequest,
            com.google.longrunning.Operation>
        getDeleteRegistryBookMethod;
    if ((getDeleteRegistryBookMethod = CloudNumberRegistryGrpc.getDeleteRegistryBookMethod)
        == null) {
      synchronized (CloudNumberRegistryGrpc.class) {
        if ((getDeleteRegistryBookMethod = CloudNumberRegistryGrpc.getDeleteRegistryBookMethod)
            == null) {
          CloudNumberRegistryGrpc.getDeleteRegistryBookMethod =
              getDeleteRegistryBookMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.numberregistry.v1alpha.DeleteRegistryBookRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRegistryBook"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.DeleteRegistryBookRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudNumberRegistryMethodDescriptorSupplier("DeleteRegistryBook"))
                      .build();
        }
      }
    }
    return getDeleteRegistryBookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.ListRealmsRequest,
          com.google.cloud.numberregistry.v1alpha.ListRealmsResponse>
      getListRealmsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRealms",
      requestType = com.google.cloud.numberregistry.v1alpha.ListRealmsRequest.class,
      responseType = com.google.cloud.numberregistry.v1alpha.ListRealmsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.ListRealmsRequest,
          com.google.cloud.numberregistry.v1alpha.ListRealmsResponse>
      getListRealmsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.numberregistry.v1alpha.ListRealmsRequest,
            com.google.cloud.numberregistry.v1alpha.ListRealmsResponse>
        getListRealmsMethod;
    if ((getListRealmsMethod = CloudNumberRegistryGrpc.getListRealmsMethod) == null) {
      synchronized (CloudNumberRegistryGrpc.class) {
        if ((getListRealmsMethod = CloudNumberRegistryGrpc.getListRealmsMethod) == null) {
          CloudNumberRegistryGrpc.getListRealmsMethod =
              getListRealmsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.numberregistry.v1alpha.ListRealmsRequest,
                          com.google.cloud.numberregistry.v1alpha.ListRealmsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRealms"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.ListRealmsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.ListRealmsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudNumberRegistryMethodDescriptorSupplier("ListRealms"))
                      .build();
        }
      }
    }
    return getListRealmsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.GetRealmRequest,
          com.google.cloud.numberregistry.v1alpha.Realm>
      getGetRealmMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRealm",
      requestType = com.google.cloud.numberregistry.v1alpha.GetRealmRequest.class,
      responseType = com.google.cloud.numberregistry.v1alpha.Realm.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.GetRealmRequest,
          com.google.cloud.numberregistry.v1alpha.Realm>
      getGetRealmMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.numberregistry.v1alpha.GetRealmRequest,
            com.google.cloud.numberregistry.v1alpha.Realm>
        getGetRealmMethod;
    if ((getGetRealmMethod = CloudNumberRegistryGrpc.getGetRealmMethod) == null) {
      synchronized (CloudNumberRegistryGrpc.class) {
        if ((getGetRealmMethod = CloudNumberRegistryGrpc.getGetRealmMethod) == null) {
          CloudNumberRegistryGrpc.getGetRealmMethod =
              getGetRealmMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.numberregistry.v1alpha.GetRealmRequest,
                          com.google.cloud.numberregistry.v1alpha.Realm>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRealm"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.GetRealmRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.Realm.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudNumberRegistryMethodDescriptorSupplier("GetRealm"))
                      .build();
        }
      }
    }
    return getGetRealmMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.CreateRealmRequest,
          com.google.longrunning.Operation>
      getCreateRealmMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRealm",
      requestType = com.google.cloud.numberregistry.v1alpha.CreateRealmRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.CreateRealmRequest,
          com.google.longrunning.Operation>
      getCreateRealmMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.numberregistry.v1alpha.CreateRealmRequest,
            com.google.longrunning.Operation>
        getCreateRealmMethod;
    if ((getCreateRealmMethod = CloudNumberRegistryGrpc.getCreateRealmMethod) == null) {
      synchronized (CloudNumberRegistryGrpc.class) {
        if ((getCreateRealmMethod = CloudNumberRegistryGrpc.getCreateRealmMethod) == null) {
          CloudNumberRegistryGrpc.getCreateRealmMethod =
              getCreateRealmMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.numberregistry.v1alpha.CreateRealmRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRealm"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.CreateRealmRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudNumberRegistryMethodDescriptorSupplier("CreateRealm"))
                      .build();
        }
      }
    }
    return getCreateRealmMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.UpdateRealmRequest,
          com.google.longrunning.Operation>
      getUpdateRealmMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateRealm",
      requestType = com.google.cloud.numberregistry.v1alpha.UpdateRealmRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.UpdateRealmRequest,
          com.google.longrunning.Operation>
      getUpdateRealmMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.numberregistry.v1alpha.UpdateRealmRequest,
            com.google.longrunning.Operation>
        getUpdateRealmMethod;
    if ((getUpdateRealmMethod = CloudNumberRegistryGrpc.getUpdateRealmMethod) == null) {
      synchronized (CloudNumberRegistryGrpc.class) {
        if ((getUpdateRealmMethod = CloudNumberRegistryGrpc.getUpdateRealmMethod) == null) {
          CloudNumberRegistryGrpc.getUpdateRealmMethod =
              getUpdateRealmMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.numberregistry.v1alpha.UpdateRealmRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateRealm"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.UpdateRealmRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudNumberRegistryMethodDescriptorSupplier("UpdateRealm"))
                      .build();
        }
      }
    }
    return getUpdateRealmMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.DeleteRealmRequest,
          com.google.longrunning.Operation>
      getDeleteRealmMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRealm",
      requestType = com.google.cloud.numberregistry.v1alpha.DeleteRealmRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.DeleteRealmRequest,
          com.google.longrunning.Operation>
      getDeleteRealmMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.numberregistry.v1alpha.DeleteRealmRequest,
            com.google.longrunning.Operation>
        getDeleteRealmMethod;
    if ((getDeleteRealmMethod = CloudNumberRegistryGrpc.getDeleteRealmMethod) == null) {
      synchronized (CloudNumberRegistryGrpc.class) {
        if ((getDeleteRealmMethod = CloudNumberRegistryGrpc.getDeleteRealmMethod) == null) {
          CloudNumberRegistryGrpc.getDeleteRealmMethod =
              getDeleteRealmMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.numberregistry.v1alpha.DeleteRealmRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRealm"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.DeleteRealmRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudNumberRegistryMethodDescriptorSupplier("DeleteRealm"))
                      .build();
        }
      }
    }
    return getDeleteRealmMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.ListDiscoveredRangesRequest,
          com.google.cloud.numberregistry.v1alpha.ListDiscoveredRangesResponse>
      getListDiscoveredRangesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDiscoveredRanges",
      requestType = com.google.cloud.numberregistry.v1alpha.ListDiscoveredRangesRequest.class,
      responseType = com.google.cloud.numberregistry.v1alpha.ListDiscoveredRangesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.ListDiscoveredRangesRequest,
          com.google.cloud.numberregistry.v1alpha.ListDiscoveredRangesResponse>
      getListDiscoveredRangesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.numberregistry.v1alpha.ListDiscoveredRangesRequest,
            com.google.cloud.numberregistry.v1alpha.ListDiscoveredRangesResponse>
        getListDiscoveredRangesMethod;
    if ((getListDiscoveredRangesMethod = CloudNumberRegistryGrpc.getListDiscoveredRangesMethod)
        == null) {
      synchronized (CloudNumberRegistryGrpc.class) {
        if ((getListDiscoveredRangesMethod = CloudNumberRegistryGrpc.getListDiscoveredRangesMethod)
            == null) {
          CloudNumberRegistryGrpc.getListDiscoveredRangesMethod =
              getListDiscoveredRangesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.numberregistry.v1alpha.ListDiscoveredRangesRequest,
                          com.google.cloud.numberregistry.v1alpha.ListDiscoveredRangesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListDiscoveredRanges"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.ListDiscoveredRangesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.ListDiscoveredRangesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudNumberRegistryMethodDescriptorSupplier("ListDiscoveredRanges"))
                      .build();
        }
      }
    }
    return getListDiscoveredRangesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.GetDiscoveredRangeRequest,
          com.google.cloud.numberregistry.v1alpha.DiscoveredRange>
      getGetDiscoveredRangeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDiscoveredRange",
      requestType = com.google.cloud.numberregistry.v1alpha.GetDiscoveredRangeRequest.class,
      responseType = com.google.cloud.numberregistry.v1alpha.DiscoveredRange.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.GetDiscoveredRangeRequest,
          com.google.cloud.numberregistry.v1alpha.DiscoveredRange>
      getGetDiscoveredRangeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.numberregistry.v1alpha.GetDiscoveredRangeRequest,
            com.google.cloud.numberregistry.v1alpha.DiscoveredRange>
        getGetDiscoveredRangeMethod;
    if ((getGetDiscoveredRangeMethod = CloudNumberRegistryGrpc.getGetDiscoveredRangeMethod)
        == null) {
      synchronized (CloudNumberRegistryGrpc.class) {
        if ((getGetDiscoveredRangeMethod = CloudNumberRegistryGrpc.getGetDiscoveredRangeMethod)
            == null) {
          CloudNumberRegistryGrpc.getGetDiscoveredRangeMethod =
              getGetDiscoveredRangeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.numberregistry.v1alpha.GetDiscoveredRangeRequest,
                          com.google.cloud.numberregistry.v1alpha.DiscoveredRange>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDiscoveredRange"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.GetDiscoveredRangeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.DiscoveredRange
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudNumberRegistryMethodDescriptorSupplier("GetDiscoveredRange"))
                      .build();
        }
      }
    }
    return getGetDiscoveredRangeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.FindDiscoveredRangeFreeIpRangesRequest,
          com.google.cloud.numberregistry.v1alpha.FindDiscoveredRangeFreeIpRangesResponse>
      getFindDiscoveredRangeFreeIpRangesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindDiscoveredRangeFreeIpRanges",
      requestType =
          com.google.cloud.numberregistry.v1alpha.FindDiscoveredRangeFreeIpRangesRequest.class,
      responseType =
          com.google.cloud.numberregistry.v1alpha.FindDiscoveredRangeFreeIpRangesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.FindDiscoveredRangeFreeIpRangesRequest,
          com.google.cloud.numberregistry.v1alpha.FindDiscoveredRangeFreeIpRangesResponse>
      getFindDiscoveredRangeFreeIpRangesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.numberregistry.v1alpha.FindDiscoveredRangeFreeIpRangesRequest,
            com.google.cloud.numberregistry.v1alpha.FindDiscoveredRangeFreeIpRangesResponse>
        getFindDiscoveredRangeFreeIpRangesMethod;
    if ((getFindDiscoveredRangeFreeIpRangesMethod =
            CloudNumberRegistryGrpc.getFindDiscoveredRangeFreeIpRangesMethod)
        == null) {
      synchronized (CloudNumberRegistryGrpc.class) {
        if ((getFindDiscoveredRangeFreeIpRangesMethod =
                CloudNumberRegistryGrpc.getFindDiscoveredRangeFreeIpRangesMethod)
            == null) {
          CloudNumberRegistryGrpc.getFindDiscoveredRangeFreeIpRangesMethod =
              getFindDiscoveredRangeFreeIpRangesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.numberregistry.v1alpha
                              .FindDiscoveredRangeFreeIpRangesRequest,
                          com.google.cloud.numberregistry.v1alpha
                              .FindDiscoveredRangeFreeIpRangesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "FindDiscoveredRangeFreeIpRanges"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha
                                  .FindDiscoveredRangeFreeIpRangesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha
                                  .FindDiscoveredRangeFreeIpRangesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudNumberRegistryMethodDescriptorSupplier(
                              "FindDiscoveredRangeFreeIpRanges"))
                      .build();
        }
      }
    }
    return getFindDiscoveredRangeFreeIpRangesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.ListCustomRangesRequest,
          com.google.cloud.numberregistry.v1alpha.ListCustomRangesResponse>
      getListCustomRangesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCustomRanges",
      requestType = com.google.cloud.numberregistry.v1alpha.ListCustomRangesRequest.class,
      responseType = com.google.cloud.numberregistry.v1alpha.ListCustomRangesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.ListCustomRangesRequest,
          com.google.cloud.numberregistry.v1alpha.ListCustomRangesResponse>
      getListCustomRangesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.numberregistry.v1alpha.ListCustomRangesRequest,
            com.google.cloud.numberregistry.v1alpha.ListCustomRangesResponse>
        getListCustomRangesMethod;
    if ((getListCustomRangesMethod = CloudNumberRegistryGrpc.getListCustomRangesMethod) == null) {
      synchronized (CloudNumberRegistryGrpc.class) {
        if ((getListCustomRangesMethod = CloudNumberRegistryGrpc.getListCustomRangesMethod)
            == null) {
          CloudNumberRegistryGrpc.getListCustomRangesMethod =
              getListCustomRangesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.numberregistry.v1alpha.ListCustomRangesRequest,
                          com.google.cloud.numberregistry.v1alpha.ListCustomRangesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCustomRanges"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.ListCustomRangesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.ListCustomRangesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudNumberRegistryMethodDescriptorSupplier("ListCustomRanges"))
                      .build();
        }
      }
    }
    return getListCustomRangesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.GetCustomRangeRequest,
          com.google.cloud.numberregistry.v1alpha.CustomRange>
      getGetCustomRangeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCustomRange",
      requestType = com.google.cloud.numberregistry.v1alpha.GetCustomRangeRequest.class,
      responseType = com.google.cloud.numberregistry.v1alpha.CustomRange.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.GetCustomRangeRequest,
          com.google.cloud.numberregistry.v1alpha.CustomRange>
      getGetCustomRangeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.numberregistry.v1alpha.GetCustomRangeRequest,
            com.google.cloud.numberregistry.v1alpha.CustomRange>
        getGetCustomRangeMethod;
    if ((getGetCustomRangeMethod = CloudNumberRegistryGrpc.getGetCustomRangeMethod) == null) {
      synchronized (CloudNumberRegistryGrpc.class) {
        if ((getGetCustomRangeMethod = CloudNumberRegistryGrpc.getGetCustomRangeMethod) == null) {
          CloudNumberRegistryGrpc.getGetCustomRangeMethod =
              getGetCustomRangeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.numberregistry.v1alpha.GetCustomRangeRequest,
                          com.google.cloud.numberregistry.v1alpha.CustomRange>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCustomRange"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.GetCustomRangeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.CustomRange
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudNumberRegistryMethodDescriptorSupplier("GetCustomRange"))
                      .build();
        }
      }
    }
    return getGetCustomRangeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.ShowCustomRangeUtilizationRequest,
          com.google.cloud.numberregistry.v1alpha.ShowCustomRangeUtilizationResponse>
      getShowCustomRangeUtilizationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ShowCustomRangeUtilization",
      requestType = com.google.cloud.numberregistry.v1alpha.ShowCustomRangeUtilizationRequest.class,
      responseType =
          com.google.cloud.numberregistry.v1alpha.ShowCustomRangeUtilizationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.ShowCustomRangeUtilizationRequest,
          com.google.cloud.numberregistry.v1alpha.ShowCustomRangeUtilizationResponse>
      getShowCustomRangeUtilizationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.numberregistry.v1alpha.ShowCustomRangeUtilizationRequest,
            com.google.cloud.numberregistry.v1alpha.ShowCustomRangeUtilizationResponse>
        getShowCustomRangeUtilizationMethod;
    if ((getShowCustomRangeUtilizationMethod =
            CloudNumberRegistryGrpc.getShowCustomRangeUtilizationMethod)
        == null) {
      synchronized (CloudNumberRegistryGrpc.class) {
        if ((getShowCustomRangeUtilizationMethod =
                CloudNumberRegistryGrpc.getShowCustomRangeUtilizationMethod)
            == null) {
          CloudNumberRegistryGrpc.getShowCustomRangeUtilizationMethod =
              getShowCustomRangeUtilizationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.numberregistry.v1alpha.ShowCustomRangeUtilizationRequest,
                          com.google.cloud.numberregistry.v1alpha
                              .ShowCustomRangeUtilizationResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ShowCustomRangeUtilization"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha
                                  .ShowCustomRangeUtilizationRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha
                                  .ShowCustomRangeUtilizationResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudNumberRegistryMethodDescriptorSupplier(
                              "ShowCustomRangeUtilization"))
                      .build();
        }
      }
    }
    return getShowCustomRangeUtilizationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.ShowDiscoveredRangeUtilizationRequest,
          com.google.cloud.numberregistry.v1alpha.ShowDiscoveredRangeUtilizationResponse>
      getShowDiscoveredRangeUtilizationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ShowDiscoveredRangeUtilization",
      requestType =
          com.google.cloud.numberregistry.v1alpha.ShowDiscoveredRangeUtilizationRequest.class,
      responseType =
          com.google.cloud.numberregistry.v1alpha.ShowDiscoveredRangeUtilizationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.ShowDiscoveredRangeUtilizationRequest,
          com.google.cloud.numberregistry.v1alpha.ShowDiscoveredRangeUtilizationResponse>
      getShowDiscoveredRangeUtilizationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.numberregistry.v1alpha.ShowDiscoveredRangeUtilizationRequest,
            com.google.cloud.numberregistry.v1alpha.ShowDiscoveredRangeUtilizationResponse>
        getShowDiscoveredRangeUtilizationMethod;
    if ((getShowDiscoveredRangeUtilizationMethod =
            CloudNumberRegistryGrpc.getShowDiscoveredRangeUtilizationMethod)
        == null) {
      synchronized (CloudNumberRegistryGrpc.class) {
        if ((getShowDiscoveredRangeUtilizationMethod =
                CloudNumberRegistryGrpc.getShowDiscoveredRangeUtilizationMethod)
            == null) {
          CloudNumberRegistryGrpc.getShowDiscoveredRangeUtilizationMethod =
              getShowDiscoveredRangeUtilizationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.numberregistry.v1alpha
                              .ShowDiscoveredRangeUtilizationRequest,
                          com.google.cloud.numberregistry.v1alpha
                              .ShowDiscoveredRangeUtilizationResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ShowDiscoveredRangeUtilization"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha
                                  .ShowDiscoveredRangeUtilizationRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha
                                  .ShowDiscoveredRangeUtilizationResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudNumberRegistryMethodDescriptorSupplier(
                              "ShowDiscoveredRangeUtilization"))
                      .build();
        }
      }
    }
    return getShowDiscoveredRangeUtilizationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.FindCustomRangeFreeIpRangesRequest,
          com.google.cloud.numberregistry.v1alpha.FindCustomRangeFreeIpRangesResponse>
      getFindCustomRangeFreeIpRangesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindCustomRangeFreeIpRanges",
      requestType =
          com.google.cloud.numberregistry.v1alpha.FindCustomRangeFreeIpRangesRequest.class,
      responseType =
          com.google.cloud.numberregistry.v1alpha.FindCustomRangeFreeIpRangesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.FindCustomRangeFreeIpRangesRequest,
          com.google.cloud.numberregistry.v1alpha.FindCustomRangeFreeIpRangesResponse>
      getFindCustomRangeFreeIpRangesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.numberregistry.v1alpha.FindCustomRangeFreeIpRangesRequest,
            com.google.cloud.numberregistry.v1alpha.FindCustomRangeFreeIpRangesResponse>
        getFindCustomRangeFreeIpRangesMethod;
    if ((getFindCustomRangeFreeIpRangesMethod =
            CloudNumberRegistryGrpc.getFindCustomRangeFreeIpRangesMethod)
        == null) {
      synchronized (CloudNumberRegistryGrpc.class) {
        if ((getFindCustomRangeFreeIpRangesMethod =
                CloudNumberRegistryGrpc.getFindCustomRangeFreeIpRangesMethod)
            == null) {
          CloudNumberRegistryGrpc.getFindCustomRangeFreeIpRangesMethod =
              getFindCustomRangeFreeIpRangesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.numberregistry.v1alpha.FindCustomRangeFreeIpRangesRequest,
                          com.google.cloud.numberregistry.v1alpha
                              .FindCustomRangeFreeIpRangesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "FindCustomRangeFreeIpRanges"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha
                                  .FindCustomRangeFreeIpRangesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha
                                  .FindCustomRangeFreeIpRangesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudNumberRegistryMethodDescriptorSupplier(
                              "FindCustomRangeFreeIpRanges"))
                      .build();
        }
      }
    }
    return getFindCustomRangeFreeIpRangesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.CreateCustomRangeRequest,
          com.google.longrunning.Operation>
      getCreateCustomRangeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCustomRange",
      requestType = com.google.cloud.numberregistry.v1alpha.CreateCustomRangeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.CreateCustomRangeRequest,
          com.google.longrunning.Operation>
      getCreateCustomRangeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.numberregistry.v1alpha.CreateCustomRangeRequest,
            com.google.longrunning.Operation>
        getCreateCustomRangeMethod;
    if ((getCreateCustomRangeMethod = CloudNumberRegistryGrpc.getCreateCustomRangeMethod) == null) {
      synchronized (CloudNumberRegistryGrpc.class) {
        if ((getCreateCustomRangeMethod = CloudNumberRegistryGrpc.getCreateCustomRangeMethod)
            == null) {
          CloudNumberRegistryGrpc.getCreateCustomRangeMethod =
              getCreateCustomRangeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.numberregistry.v1alpha.CreateCustomRangeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCustomRange"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.CreateCustomRangeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudNumberRegistryMethodDescriptorSupplier("CreateCustomRange"))
                      .build();
        }
      }
    }
    return getCreateCustomRangeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.UpdateCustomRangeRequest,
          com.google.longrunning.Operation>
      getUpdateCustomRangeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCustomRange",
      requestType = com.google.cloud.numberregistry.v1alpha.UpdateCustomRangeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.UpdateCustomRangeRequest,
          com.google.longrunning.Operation>
      getUpdateCustomRangeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.numberregistry.v1alpha.UpdateCustomRangeRequest,
            com.google.longrunning.Operation>
        getUpdateCustomRangeMethod;
    if ((getUpdateCustomRangeMethod = CloudNumberRegistryGrpc.getUpdateCustomRangeMethod) == null) {
      synchronized (CloudNumberRegistryGrpc.class) {
        if ((getUpdateCustomRangeMethod = CloudNumberRegistryGrpc.getUpdateCustomRangeMethod)
            == null) {
          CloudNumberRegistryGrpc.getUpdateCustomRangeMethod =
              getUpdateCustomRangeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.numberregistry.v1alpha.UpdateCustomRangeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCustomRange"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.UpdateCustomRangeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudNumberRegistryMethodDescriptorSupplier("UpdateCustomRange"))
                      .build();
        }
      }
    }
    return getUpdateCustomRangeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.DeleteCustomRangeRequest,
          com.google.longrunning.Operation>
      getDeleteCustomRangeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCustomRange",
      requestType = com.google.cloud.numberregistry.v1alpha.DeleteCustomRangeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.numberregistry.v1alpha.DeleteCustomRangeRequest,
          com.google.longrunning.Operation>
      getDeleteCustomRangeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.numberregistry.v1alpha.DeleteCustomRangeRequest,
            com.google.longrunning.Operation>
        getDeleteCustomRangeMethod;
    if ((getDeleteCustomRangeMethod = CloudNumberRegistryGrpc.getDeleteCustomRangeMethod) == null) {
      synchronized (CloudNumberRegistryGrpc.class) {
        if ((getDeleteCustomRangeMethod = CloudNumberRegistryGrpc.getDeleteCustomRangeMethod)
            == null) {
          CloudNumberRegistryGrpc.getDeleteCustomRangeMethod =
              getDeleteCustomRangeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.numberregistry.v1alpha.DeleteCustomRangeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCustomRange"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.numberregistry.v1alpha.DeleteCustomRangeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudNumberRegistryMethodDescriptorSupplier("DeleteCustomRange"))
                      .build();
        }
      }
    }
    return getDeleteCustomRangeMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static CloudNumberRegistryStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudNumberRegistryStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudNumberRegistryStub>() {
          @java.lang.Override
          public CloudNumberRegistryStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudNumberRegistryStub(channel, callOptions);
          }
        };
    return CloudNumberRegistryStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static CloudNumberRegistryBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudNumberRegistryBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudNumberRegistryBlockingV2Stub>() {
          @java.lang.Override
          public CloudNumberRegistryBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudNumberRegistryBlockingV2Stub(channel, callOptions);
          }
        };
    return CloudNumberRegistryBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CloudNumberRegistryBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudNumberRegistryBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudNumberRegistryBlockingStub>() {
          @java.lang.Override
          public CloudNumberRegistryBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudNumberRegistryBlockingStub(channel, callOptions);
          }
        };
    return CloudNumberRegistryBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static CloudNumberRegistryFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudNumberRegistryFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudNumberRegistryFutureStub>() {
          @java.lang.Override
          public CloudNumberRegistryFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudNumberRegistryFutureStub(channel, callOptions);
          }
        };
    return CloudNumberRegistryFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The Cloud Number Registry service manages IP address space visibility and
   * tracking. It enables the discovery, organization, and monitoring of IP
   * address ranges across different cloud infrastructure platforms.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists IpamAdminScopes in a given project and location.
     * </pre>
     */
    default void listIpamAdminScopes(
        com.google.cloud.numberregistry.v1alpha.ListIpamAdminScopesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.numberregistry.v1alpha.ListIpamAdminScopesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListIpamAdminScopesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single IpamAdminScope.
     * </pre>
     */
    default void getIpamAdminScope(
        com.google.cloud.numberregistry.v1alpha.GetIpamAdminScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.numberregistry.v1alpha.IpamAdminScope>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetIpamAdminScopeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Checks the availability of IpamAdminScopes in a given project and
     * location.
     * </pre>
     */
    default void checkAvailabilityIpamAdminScopes(
        com.google.cloud.numberregistry.v1alpha.CheckAvailabilityIpamAdminScopesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.numberregistry.v1alpha.CheckAvailabilityIpamAdminScopesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCheckAvailabilityIpamAdminScopesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new IpamAdminScope in a given project and location.
     * </pre>
     */
    default void createIpamAdminScope(
        com.google.cloud.numberregistry.v1alpha.CreateIpamAdminScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateIpamAdminScopeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single IpamAdminScope.
     * </pre>
     */
    default void updateIpamAdminScope(
        com.google.cloud.numberregistry.v1alpha.UpdateIpamAdminScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateIpamAdminScopeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single IpamAdminScope.
     * </pre>
     */
    default void deleteIpamAdminScope(
        com.google.cloud.numberregistry.v1alpha.DeleteIpamAdminScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteIpamAdminScopeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Disables a single IpamAdminScope.
     * </pre>
     */
    default void disableIpamAdminScope(
        com.google.cloud.numberregistry.v1alpha.DisableIpamAdminScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDisableIpamAdminScopeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cleans up a single IpamAdminScope.
     * </pre>
     */
    default void cleanupIpamAdminScope(
        com.google.cloud.numberregistry.v1alpha.CleanupIpamAdminScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCleanupIpamAdminScopeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists RegistryBooks in a given project and location.
     * </pre>
     */
    default void listRegistryBooks(
        com.google.cloud.numberregistry.v1alpha.ListRegistryBooksRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.numberregistry.v1alpha.ListRegistryBooksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRegistryBooksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single RegistryBook.
     * </pre>
     */
    default void getRegistryBook(
        com.google.cloud.numberregistry.v1alpha.GetRegistryBookRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.numberregistry.v1alpha.RegistryBook>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetRegistryBookMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches IP resources in a given RegistryBook.
     * </pre>
     */
    default void searchIpResources(
        com.google.cloud.numberregistry.v1alpha.SearchIpResourcesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.numberregistry.v1alpha.SearchIpResourcesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchIpResourcesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new RegistryBook in a given project and location.
     * </pre>
     */
    default void createRegistryBook(
        com.google.cloud.numberregistry.v1alpha.CreateRegistryBookRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateRegistryBookMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single RegistryBook.
     * </pre>
     */
    default void updateRegistryBook(
        com.google.cloud.numberregistry.v1alpha.UpdateRegistryBookRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateRegistryBookMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single RegistryBook.
     * </pre>
     */
    default void deleteRegistryBook(
        com.google.cloud.numberregistry.v1alpha.DeleteRegistryBookRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteRegistryBookMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Realms in a given project and location.
     * </pre>
     */
    default void listRealms(
        com.google.cloud.numberregistry.v1alpha.ListRealmsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.numberregistry.v1alpha.ListRealmsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListRealmsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Realm.
     * </pre>
     */
    default void getRealm(
        com.google.cloud.numberregistry.v1alpha.GetRealmRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.numberregistry.v1alpha.Realm>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRealmMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Realm in a given project and location.
     * </pre>
     */
    default void createRealm(
        com.google.cloud.numberregistry.v1alpha.CreateRealmRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateRealmMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Realm.
     * </pre>
     */
    default void updateRealm(
        com.google.cloud.numberregistry.v1alpha.UpdateRealmRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateRealmMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Realm.
     * </pre>
     */
    default void deleteRealm(
        com.google.cloud.numberregistry.v1alpha.DeleteRealmRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteRealmMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DiscoveredRanges in a given project and location.
     * </pre>
     */
    default void listDiscoveredRanges(
        com.google.cloud.numberregistry.v1alpha.ListDiscoveredRangesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.numberregistry.v1alpha.ListDiscoveredRangesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDiscoveredRangesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single DiscoveredRange.
     * </pre>
     */
    default void getDiscoveredRange(
        com.google.cloud.numberregistry.v1alpha.GetDiscoveredRangeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.numberregistry.v1alpha.DiscoveredRange>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDiscoveredRangeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Finds free IP ranges in a single DiscoveredRange.
     * </pre>
     */
    default void findDiscoveredRangeFreeIpRanges(
        com.google.cloud.numberregistry.v1alpha.FindDiscoveredRangeFreeIpRangesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.numberregistry.v1alpha.FindDiscoveredRangeFreeIpRangesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFindDiscoveredRangeFreeIpRangesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists CustomRanges in a given project and location.
     * </pre>
     */
    default void listCustomRanges(
        com.google.cloud.numberregistry.v1alpha.ListCustomRangesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.numberregistry.v1alpha.ListCustomRangesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCustomRangesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CustomRange.
     * </pre>
     */
    default void getCustomRange(
        com.google.cloud.numberregistry.v1alpha.GetCustomRangeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.numberregistry.v1alpha.CustomRange>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCustomRangeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a single CustomRange and its utilization.
     * </pre>
     */
    default void showCustomRangeUtilization(
        com.google.cloud.numberregistry.v1alpha.ShowCustomRangeUtilizationRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.numberregistry.v1alpha.ShowCustomRangeUtilizationResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getShowCustomRangeUtilizationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a single DiscoveredRange and its utilization.
     * </pre>
     */
    default void showDiscoveredRangeUtilization(
        com.google.cloud.numberregistry.v1alpha.ShowDiscoveredRangeUtilizationRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.numberregistry.v1alpha.ShowDiscoveredRangeUtilizationResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getShowDiscoveredRangeUtilizationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Finds free IP ranges in a single CustomRange.
     * </pre>
     */
    default void findCustomRangeFreeIpRanges(
        com.google.cloud.numberregistry.v1alpha.FindCustomRangeFreeIpRangesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.numberregistry.v1alpha.FindCustomRangeFreeIpRangesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFindCustomRangeFreeIpRangesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new CustomRange in a given project and location.
     * </pre>
     */
    default void createCustomRange(
        com.google.cloud.numberregistry.v1alpha.CreateCustomRangeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCustomRangeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single CustomRange.
     * </pre>
     */
    default void updateCustomRange(
        com.google.cloud.numberregistry.v1alpha.UpdateCustomRangeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateCustomRangeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single CustomRange.
     * </pre>
     */
    default void deleteCustomRange(
        com.google.cloud.numberregistry.v1alpha.DeleteCustomRangeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteCustomRangeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CloudNumberRegistry.
   *
   * <pre>
   * The Cloud Number Registry service manages IP address space visibility and
   * tracking. It enables the discovery, organization, and monitoring of IP
   * address ranges across different cloud infrastructure platforms.
   * </pre>
   */
  public abstract static class CloudNumberRegistryImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return CloudNumberRegistryGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CloudNumberRegistry.
   *
   * <pre>
   * The Cloud Number Registry service manages IP address space visibility and
   * tracking. It enables the discovery, organization, and monitoring of IP
   * address ranges across different cloud infrastructure platforms.
   * </pre>
   */
  public static final class CloudNumberRegistryStub
      extends io.grpc.stub.AbstractAsyncStub<CloudNumberRegistryStub> {
    private CloudNumberRegistryStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudNumberRegistryStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudNumberRegistryStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists IpamAdminScopes in a given project and location.
     * </pre>
     */
    public void listIpamAdminScopes(
        com.google.cloud.numberregistry.v1alpha.ListIpamAdminScopesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.numberregistry.v1alpha.ListIpamAdminScopesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListIpamAdminScopesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single IpamAdminScope.
     * </pre>
     */
    public void getIpamAdminScope(
        com.google.cloud.numberregistry.v1alpha.GetIpamAdminScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.numberregistry.v1alpha.IpamAdminScope>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIpamAdminScopeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Checks the availability of IpamAdminScopes in a given project and
     * location.
     * </pre>
     */
    public void checkAvailabilityIpamAdminScopes(
        com.google.cloud.numberregistry.v1alpha.CheckAvailabilityIpamAdminScopesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.numberregistry.v1alpha.CheckAvailabilityIpamAdminScopesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckAvailabilityIpamAdminScopesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new IpamAdminScope in a given project and location.
     * </pre>
     */
    public void createIpamAdminScope(
        com.google.cloud.numberregistry.v1alpha.CreateIpamAdminScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateIpamAdminScopeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single IpamAdminScope.
     * </pre>
     */
    public void updateIpamAdminScope(
        com.google.cloud.numberregistry.v1alpha.UpdateIpamAdminScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateIpamAdminScopeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single IpamAdminScope.
     * </pre>
     */
    public void deleteIpamAdminScope(
        com.google.cloud.numberregistry.v1alpha.DeleteIpamAdminScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteIpamAdminScopeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Disables a single IpamAdminScope.
     * </pre>
     */
    public void disableIpamAdminScope(
        com.google.cloud.numberregistry.v1alpha.DisableIpamAdminScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDisableIpamAdminScopeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cleans up a single IpamAdminScope.
     * </pre>
     */
    public void cleanupIpamAdminScope(
        com.google.cloud.numberregistry.v1alpha.CleanupIpamAdminScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCleanupIpamAdminScopeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists RegistryBooks in a given project and location.
     * </pre>
     */
    public void listRegistryBooks(
        com.google.cloud.numberregistry.v1alpha.ListRegistryBooksRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.numberregistry.v1alpha.ListRegistryBooksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRegistryBooksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single RegistryBook.
     * </pre>
     */
    public void getRegistryBook(
        com.google.cloud.numberregistry.v1alpha.GetRegistryBookRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.numberregistry.v1alpha.RegistryBook>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRegistryBookMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches IP resources in a given RegistryBook.
     * </pre>
     */
    public void searchIpResources(
        com.google.cloud.numberregistry.v1alpha.SearchIpResourcesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.numberregistry.v1alpha.SearchIpResourcesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchIpResourcesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new RegistryBook in a given project and location.
     * </pre>
     */
    public void createRegistryBook(
        com.google.cloud.numberregistry.v1alpha.CreateRegistryBookRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRegistryBookMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single RegistryBook.
     * </pre>
     */
    public void updateRegistryBook(
        com.google.cloud.numberregistry.v1alpha.UpdateRegistryBookRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateRegistryBookMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single RegistryBook.
     * </pre>
     */
    public void deleteRegistryBook(
        com.google.cloud.numberregistry.v1alpha.DeleteRegistryBookRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRegistryBookMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Realms in a given project and location.
     * </pre>
     */
    public void listRealms(
        com.google.cloud.numberregistry.v1alpha.ListRealmsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.numberregistry.v1alpha.ListRealmsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRealmsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Realm.
     * </pre>
     */
    public void getRealm(
        com.google.cloud.numberregistry.v1alpha.GetRealmRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.numberregistry.v1alpha.Realm>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRealmMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Realm in a given project and location.
     * </pre>
     */
    public void createRealm(
        com.google.cloud.numberregistry.v1alpha.CreateRealmRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRealmMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Realm.
     * </pre>
     */
    public void updateRealm(
        com.google.cloud.numberregistry.v1alpha.UpdateRealmRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateRealmMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Realm.
     * </pre>
     */
    public void deleteRealm(
        com.google.cloud.numberregistry.v1alpha.DeleteRealmRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRealmMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DiscoveredRanges in a given project and location.
     * </pre>
     */
    public void listDiscoveredRanges(
        com.google.cloud.numberregistry.v1alpha.ListDiscoveredRangesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.numberregistry.v1alpha.ListDiscoveredRangesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDiscoveredRangesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single DiscoveredRange.
     * </pre>
     */
    public void getDiscoveredRange(
        com.google.cloud.numberregistry.v1alpha.GetDiscoveredRangeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.numberregistry.v1alpha.DiscoveredRange>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDiscoveredRangeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Finds free IP ranges in a single DiscoveredRange.
     * </pre>
     */
    public void findDiscoveredRangeFreeIpRanges(
        com.google.cloud.numberregistry.v1alpha.FindDiscoveredRangeFreeIpRangesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.numberregistry.v1alpha.FindDiscoveredRangeFreeIpRangesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindDiscoveredRangeFreeIpRangesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists CustomRanges in a given project and location.
     * </pre>
     */
    public void listCustomRanges(
        com.google.cloud.numberregistry.v1alpha.ListCustomRangesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.numberregistry.v1alpha.ListCustomRangesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCustomRangesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CustomRange.
     * </pre>
     */
    public void getCustomRange(
        com.google.cloud.numberregistry.v1alpha.GetCustomRangeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.numberregistry.v1alpha.CustomRange>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCustomRangeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a single CustomRange and its utilization.
     * </pre>
     */
    public void showCustomRangeUtilization(
        com.google.cloud.numberregistry.v1alpha.ShowCustomRangeUtilizationRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.numberregistry.v1alpha.ShowCustomRangeUtilizationResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getShowCustomRangeUtilizationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a single DiscoveredRange and its utilization.
     * </pre>
     */
    public void showDiscoveredRangeUtilization(
        com.google.cloud.numberregistry.v1alpha.ShowDiscoveredRangeUtilizationRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.numberregistry.v1alpha.ShowDiscoveredRangeUtilizationResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getShowDiscoveredRangeUtilizationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Finds free IP ranges in a single CustomRange.
     * </pre>
     */
    public void findCustomRangeFreeIpRanges(
        com.google.cloud.numberregistry.v1alpha.FindCustomRangeFreeIpRangesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.numberregistry.v1alpha.FindCustomRangeFreeIpRangesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindCustomRangeFreeIpRangesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new CustomRange in a given project and location.
     * </pre>
     */
    public void createCustomRange(
        com.google.cloud.numberregistry.v1alpha.CreateCustomRangeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCustomRangeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single CustomRange.
     * </pre>
     */
    public void updateCustomRange(
        com.google.cloud.numberregistry.v1alpha.UpdateCustomRangeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCustomRangeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single CustomRange.
     * </pre>
     */
    public void deleteCustomRange(
        com.google.cloud.numberregistry.v1alpha.DeleteCustomRangeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCustomRangeMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CloudNumberRegistry.
   *
   * <pre>
   * The Cloud Number Registry service manages IP address space visibility and
   * tracking. It enables the discovery, organization, and monitoring of IP
   * address ranges across different cloud infrastructure platforms.
   * </pre>
   */
  public static final class CloudNumberRegistryBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<CloudNumberRegistryBlockingV2Stub> {
    private CloudNumberRegistryBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudNumberRegistryBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudNumberRegistryBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists IpamAdminScopes in a given project and location.
     * </pre>
     */
    public com.google.cloud.numberregistry.v1alpha.ListIpamAdminScopesResponse listIpamAdminScopes(
        com.google.cloud.numberregistry.v1alpha.ListIpamAdminScopesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListIpamAdminScopesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single IpamAdminScope.
     * </pre>
     */
    public com.google.cloud.numberregistry.v1alpha.IpamAdminScope getIpamAdminScope(
        com.google.cloud.numberregistry.v1alpha.GetIpamAdminScopeRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetIpamAdminScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Checks the availability of IpamAdminScopes in a given project and
     * location.
     * </pre>
     */
    public com.google.cloud.numberregistry.v1alpha.CheckAvailabilityIpamAdminScopesResponse
        checkAvailabilityIpamAdminScopes(
            com.google.cloud.numberregistry.v1alpha.CheckAvailabilityIpamAdminScopesRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCheckAvailabilityIpamAdminScopesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new IpamAdminScope in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createIpamAdminScope(
        com.google.cloud.numberregistry.v1alpha.CreateIpamAdminScopeRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateIpamAdminScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single IpamAdminScope.
     * </pre>
     */
    public com.google.longrunning.Operation updateIpamAdminScope(
        com.google.cloud.numberregistry.v1alpha.UpdateIpamAdminScopeRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateIpamAdminScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single IpamAdminScope.
     * </pre>
     */
    public com.google.longrunning.Operation deleteIpamAdminScope(
        com.google.cloud.numberregistry.v1alpha.DeleteIpamAdminScopeRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteIpamAdminScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Disables a single IpamAdminScope.
     * </pre>
     */
    public com.google.longrunning.Operation disableIpamAdminScope(
        com.google.cloud.numberregistry.v1alpha.DisableIpamAdminScopeRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDisableIpamAdminScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Cleans up a single IpamAdminScope.
     * </pre>
     */
    public com.google.longrunning.Operation cleanupIpamAdminScope(
        com.google.cloud.numberregistry.v1alpha.CleanupIpamAdminScopeRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCleanupIpamAdminScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists RegistryBooks in a given project and location.
     * </pre>
     */
    public com.google.cloud.numberregistry.v1alpha.ListRegistryBooksResponse listRegistryBooks(
        com.google.cloud.numberregistry.v1alpha.ListRegistryBooksRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListRegistryBooksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single RegistryBook.
     * </pre>
     */
    public com.google.cloud.numberregistry.v1alpha.RegistryBook getRegistryBook(
        com.google.cloud.numberregistry.v1alpha.GetRegistryBookRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetRegistryBookMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Searches IP resources in a given RegistryBook.
     * </pre>
     */
    public com.google.cloud.numberregistry.v1alpha.SearchIpResourcesResponse searchIpResources(
        com.google.cloud.numberregistry.v1alpha.SearchIpResourcesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSearchIpResourcesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new RegistryBook in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createRegistryBook(
        com.google.cloud.numberregistry.v1alpha.CreateRegistryBookRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateRegistryBookMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single RegistryBook.
     * </pre>
     */
    public com.google.longrunning.Operation updateRegistryBook(
        com.google.cloud.numberregistry.v1alpha.UpdateRegistryBookRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateRegistryBookMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single RegistryBook.
     * </pre>
     */
    public com.google.longrunning.Operation deleteRegistryBook(
        com.google.cloud.numberregistry.v1alpha.DeleteRegistryBookRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteRegistryBookMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Realms in a given project and location.
     * </pre>
     */
    public com.google.cloud.numberregistry.v1alpha.ListRealmsResponse listRealms(
        com.google.cloud.numberregistry.v1alpha.ListRealmsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListRealmsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Realm.
     * </pre>
     */
    public com.google.cloud.numberregistry.v1alpha.Realm getRealm(
        com.google.cloud.numberregistry.v1alpha.GetRealmRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetRealmMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Realm in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createRealm(
        com.google.cloud.numberregistry.v1alpha.CreateRealmRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateRealmMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Realm.
     * </pre>
     */
    public com.google.longrunning.Operation updateRealm(
        com.google.cloud.numberregistry.v1alpha.UpdateRealmRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateRealmMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Realm.
     * </pre>
     */
    public com.google.longrunning.Operation deleteRealm(
        com.google.cloud.numberregistry.v1alpha.DeleteRealmRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteRealmMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DiscoveredRanges in a given project and location.
     * </pre>
     */
    public com.google.cloud.numberregistry.v1alpha.ListDiscoveredRangesResponse
        listDiscoveredRanges(
            com.google.cloud.numberregistry.v1alpha.ListDiscoveredRangesRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListDiscoveredRangesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single DiscoveredRange.
     * </pre>
     */
    public com.google.cloud.numberregistry.v1alpha.DiscoveredRange getDiscoveredRange(
        com.google.cloud.numberregistry.v1alpha.GetDiscoveredRangeRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetDiscoveredRangeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Finds free IP ranges in a single DiscoveredRange.
     * </pre>
     */
    public com.google.cloud.numberregistry.v1alpha.FindDiscoveredRangeFreeIpRangesResponse
        findDiscoveredRangeFreeIpRanges(
            com.google.cloud.numberregistry.v1alpha.FindDiscoveredRangeFreeIpRangesRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getFindDiscoveredRangeFreeIpRangesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists CustomRanges in a given project and location.
     * </pre>
     */
    public com.google.cloud.numberregistry.v1alpha.ListCustomRangesResponse listCustomRanges(
        com.google.cloud.numberregistry.v1alpha.ListCustomRangesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListCustomRangesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CustomRange.
     * </pre>
     */
    public com.google.cloud.numberregistry.v1alpha.CustomRange getCustomRange(
        com.google.cloud.numberregistry.v1alpha.GetCustomRangeRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetCustomRangeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a single CustomRange and its utilization.
     * </pre>
     */
    public com.google.cloud.numberregistry.v1alpha.ShowCustomRangeUtilizationResponse
        showCustomRangeUtilization(
            com.google.cloud.numberregistry.v1alpha.ShowCustomRangeUtilizationRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getShowCustomRangeUtilizationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a single DiscoveredRange and its utilization.
     * </pre>
     */
    public com.google.cloud.numberregistry.v1alpha.ShowDiscoveredRangeUtilizationResponse
        showDiscoveredRangeUtilization(
            com.google.cloud.numberregistry.v1alpha.ShowDiscoveredRangeUtilizationRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getShowDiscoveredRangeUtilizationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Finds free IP ranges in a single CustomRange.
     * </pre>
     */
    public com.google.cloud.numberregistry.v1alpha.FindCustomRangeFreeIpRangesResponse
        findCustomRangeFreeIpRanges(
            com.google.cloud.numberregistry.v1alpha.FindCustomRangeFreeIpRangesRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getFindCustomRangeFreeIpRangesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new CustomRange in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createCustomRange(
        com.google.cloud.numberregistry.v1alpha.CreateCustomRangeRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateCustomRangeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single CustomRange.
     * </pre>
     */
    public com.google.longrunning.Operation updateCustomRange(
        com.google.cloud.numberregistry.v1alpha.UpdateCustomRangeRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateCustomRangeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single CustomRange.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCustomRange(
        com.google.cloud.numberregistry.v1alpha.DeleteCustomRangeRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteCustomRangeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service CloudNumberRegistry.
   *
   * <pre>
   * The Cloud Number Registry service manages IP address space visibility and
   * tracking. It enables the discovery, organization, and monitoring of IP
   * address ranges across different cloud infrastructure platforms.
   * </pre>
   */
  public static final class CloudNumberRegistryBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CloudNumberRegistryBlockingStub> {
    private CloudNumberRegistryBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudNumberRegistryBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudNumberRegistryBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists IpamAdminScopes in a given project and location.
     * </pre>
     */
    public com.google.cloud.numberregistry.v1alpha.ListIpamAdminScopesResponse listIpamAdminScopes(
        com.google.cloud.numberregistry.v1alpha.ListIpamAdminScopesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListIpamAdminScopesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single IpamAdminScope.
     * </pre>
     */
    public com.google.cloud.numberregistry.v1alpha.IpamAdminScope getIpamAdminScope(
        com.google.cloud.numberregistry.v1alpha.GetIpamAdminScopeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIpamAdminScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Checks the availability of IpamAdminScopes in a given project and
     * location.
     * </pre>
     */
    public com.google.cloud.numberregistry.v1alpha.CheckAvailabilityIpamAdminScopesResponse
        checkAvailabilityIpamAdminScopes(
            com.google.cloud.numberregistry.v1alpha.CheckAvailabilityIpamAdminScopesRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckAvailabilityIpamAdminScopesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new IpamAdminScope in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createIpamAdminScope(
        com.google.cloud.numberregistry.v1alpha.CreateIpamAdminScopeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateIpamAdminScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single IpamAdminScope.
     * </pre>
     */
    public com.google.longrunning.Operation updateIpamAdminScope(
        com.google.cloud.numberregistry.v1alpha.UpdateIpamAdminScopeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateIpamAdminScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single IpamAdminScope.
     * </pre>
     */
    public com.google.longrunning.Operation deleteIpamAdminScope(
        com.google.cloud.numberregistry.v1alpha.DeleteIpamAdminScopeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteIpamAdminScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Disables a single IpamAdminScope.
     * </pre>
     */
    public com.google.longrunning.Operation disableIpamAdminScope(
        com.google.cloud.numberregistry.v1alpha.DisableIpamAdminScopeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDisableIpamAdminScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Cleans up a single IpamAdminScope.
     * </pre>
     */
    public com.google.longrunning.Operation cleanupIpamAdminScope(
        com.google.cloud.numberregistry.v1alpha.CleanupIpamAdminScopeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCleanupIpamAdminScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists RegistryBooks in a given project and location.
     * </pre>
     */
    public com.google.cloud.numberregistry.v1alpha.ListRegistryBooksResponse listRegistryBooks(
        com.google.cloud.numberregistry.v1alpha.ListRegistryBooksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRegistryBooksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single RegistryBook.
     * </pre>
     */
    public com.google.cloud.numberregistry.v1alpha.RegistryBook getRegistryBook(
        com.google.cloud.numberregistry.v1alpha.GetRegistryBookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRegistryBookMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Searches IP resources in a given RegistryBook.
     * </pre>
     */
    public com.google.cloud.numberregistry.v1alpha.SearchIpResourcesResponse searchIpResources(
        com.google.cloud.numberregistry.v1alpha.SearchIpResourcesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchIpResourcesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new RegistryBook in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createRegistryBook(
        com.google.cloud.numberregistry.v1alpha.CreateRegistryBookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRegistryBookMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single RegistryBook.
     * </pre>
     */
    public com.google.longrunning.Operation updateRegistryBook(
        com.google.cloud.numberregistry.v1alpha.UpdateRegistryBookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRegistryBookMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single RegistryBook.
     * </pre>
     */
    public com.google.longrunning.Operation deleteRegistryBook(
        com.google.cloud.numberregistry.v1alpha.DeleteRegistryBookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRegistryBookMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Realms in a given project and location.
     * </pre>
     */
    public com.google.cloud.numberregistry.v1alpha.ListRealmsResponse listRealms(
        com.google.cloud.numberregistry.v1alpha.ListRealmsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRealmsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Realm.
     * </pre>
     */
    public com.google.cloud.numberregistry.v1alpha.Realm getRealm(
        com.google.cloud.numberregistry.v1alpha.GetRealmRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRealmMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Realm in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createRealm(
        com.google.cloud.numberregistry.v1alpha.CreateRealmRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRealmMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Realm.
     * </pre>
     */
    public com.google.longrunning.Operation updateRealm(
        com.google.cloud.numberregistry.v1alpha.UpdateRealmRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRealmMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Realm.
     * </pre>
     */
    public com.google.longrunning.Operation deleteRealm(
        com.google.cloud.numberregistry.v1alpha.DeleteRealmRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRealmMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DiscoveredRanges in a given project and location.
     * </pre>
     */
    public com.google.cloud.numberregistry.v1alpha.ListDiscoveredRangesResponse
        listDiscoveredRanges(
            com.google.cloud.numberregistry.v1alpha.ListDiscoveredRangesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDiscoveredRangesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single DiscoveredRange.
     * </pre>
     */
    public com.google.cloud.numberregistry.v1alpha.DiscoveredRange getDiscoveredRange(
        com.google.cloud.numberregistry.v1alpha.GetDiscoveredRangeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDiscoveredRangeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Finds free IP ranges in a single DiscoveredRange.
     * </pre>
     */
    public com.google.cloud.numberregistry.v1alpha.FindDiscoveredRangeFreeIpRangesResponse
        findDiscoveredRangeFreeIpRanges(
            com.google.cloud.numberregistry.v1alpha.FindDiscoveredRangeFreeIpRangesRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindDiscoveredRangeFreeIpRangesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists CustomRanges in a given project and location.
     * </pre>
     */
    public com.google.cloud.numberregistry.v1alpha.ListCustomRangesResponse listCustomRanges(
        com.google.cloud.numberregistry.v1alpha.ListCustomRangesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCustomRangesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CustomRange.
     * </pre>
     */
    public com.google.cloud.numberregistry.v1alpha.CustomRange getCustomRange(
        com.google.cloud.numberregistry.v1alpha.GetCustomRangeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCustomRangeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a single CustomRange and its utilization.
     * </pre>
     */
    public com.google.cloud.numberregistry.v1alpha.ShowCustomRangeUtilizationResponse
        showCustomRangeUtilization(
            com.google.cloud.numberregistry.v1alpha.ShowCustomRangeUtilizationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getShowCustomRangeUtilizationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a single DiscoveredRange and its utilization.
     * </pre>
     */
    public com.google.cloud.numberregistry.v1alpha.ShowDiscoveredRangeUtilizationResponse
        showDiscoveredRangeUtilization(
            com.google.cloud.numberregistry.v1alpha.ShowDiscoveredRangeUtilizationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getShowDiscoveredRangeUtilizationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Finds free IP ranges in a single CustomRange.
     * </pre>
     */
    public com.google.cloud.numberregistry.v1alpha.FindCustomRangeFreeIpRangesResponse
        findCustomRangeFreeIpRanges(
            com.google.cloud.numberregistry.v1alpha.FindCustomRangeFreeIpRangesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindCustomRangeFreeIpRangesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new CustomRange in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createCustomRange(
        com.google.cloud.numberregistry.v1alpha.CreateCustomRangeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCustomRangeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single CustomRange.
     * </pre>
     */
    public com.google.longrunning.Operation updateCustomRange(
        com.google.cloud.numberregistry.v1alpha.UpdateCustomRangeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCustomRangeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single CustomRange.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCustomRange(
        com.google.cloud.numberregistry.v1alpha.DeleteCustomRangeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCustomRangeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CloudNumberRegistry.
   *
   * <pre>
   * The Cloud Number Registry service manages IP address space visibility and
   * tracking. It enables the discovery, organization, and monitoring of IP
   * address ranges across different cloud infrastructure platforms.
   * </pre>
   */
  public static final class CloudNumberRegistryFutureStub
      extends io.grpc.stub.AbstractFutureStub<CloudNumberRegistryFutureStub> {
    private CloudNumberRegistryFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudNumberRegistryFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudNumberRegistryFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists IpamAdminScopes in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.numberregistry.v1alpha.ListIpamAdminScopesResponse>
        listIpamAdminScopes(
            com.google.cloud.numberregistry.v1alpha.ListIpamAdminScopesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListIpamAdminScopesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single IpamAdminScope.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.numberregistry.v1alpha.IpamAdminScope>
        getIpamAdminScope(
            com.google.cloud.numberregistry.v1alpha.GetIpamAdminScopeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIpamAdminScopeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Checks the availability of IpamAdminScopes in a given project and
     * location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.numberregistry.v1alpha.CheckAvailabilityIpamAdminScopesResponse>
        checkAvailabilityIpamAdminScopes(
            com.google.cloud.numberregistry.v1alpha.CheckAvailabilityIpamAdminScopesRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckAvailabilityIpamAdminScopesMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new IpamAdminScope in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createIpamAdminScope(
            com.google.cloud.numberregistry.v1alpha.CreateIpamAdminScopeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateIpamAdminScopeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single IpamAdminScope.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateIpamAdminScope(
            com.google.cloud.numberregistry.v1alpha.UpdateIpamAdminScopeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateIpamAdminScopeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single IpamAdminScope.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteIpamAdminScope(
            com.google.cloud.numberregistry.v1alpha.DeleteIpamAdminScopeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteIpamAdminScopeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Disables a single IpamAdminScope.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        disableIpamAdminScope(
            com.google.cloud.numberregistry.v1alpha.DisableIpamAdminScopeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDisableIpamAdminScopeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Cleans up a single IpamAdminScope.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        cleanupIpamAdminScope(
            com.google.cloud.numberregistry.v1alpha.CleanupIpamAdminScopeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCleanupIpamAdminScopeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists RegistryBooks in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.numberregistry.v1alpha.ListRegistryBooksResponse>
        listRegistryBooks(
            com.google.cloud.numberregistry.v1alpha.ListRegistryBooksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRegistryBooksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single RegistryBook.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.numberregistry.v1alpha.RegistryBook>
        getRegistryBook(com.google.cloud.numberregistry.v1alpha.GetRegistryBookRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRegistryBookMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Searches IP resources in a given RegistryBook.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.numberregistry.v1alpha.SearchIpResourcesResponse>
        searchIpResources(
            com.google.cloud.numberregistry.v1alpha.SearchIpResourcesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchIpResourcesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new RegistryBook in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createRegistryBook(
            com.google.cloud.numberregistry.v1alpha.CreateRegistryBookRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRegistryBookMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single RegistryBook.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateRegistryBook(
            com.google.cloud.numberregistry.v1alpha.UpdateRegistryBookRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateRegistryBookMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single RegistryBook.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteRegistryBook(
            com.google.cloud.numberregistry.v1alpha.DeleteRegistryBookRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRegistryBookMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Realms in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.numberregistry.v1alpha.ListRealmsResponse>
        listRealms(com.google.cloud.numberregistry.v1alpha.ListRealmsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRealmsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Realm.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.numberregistry.v1alpha.Realm>
        getRealm(com.google.cloud.numberregistry.v1alpha.GetRealmRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRealmMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Realm in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createRealm(com.google.cloud.numberregistry.v1alpha.CreateRealmRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRealmMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Realm.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateRealm(com.google.cloud.numberregistry.v1alpha.UpdateRealmRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateRealmMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Realm.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteRealm(com.google.cloud.numberregistry.v1alpha.DeleteRealmRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRealmMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DiscoveredRanges in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.numberregistry.v1alpha.ListDiscoveredRangesResponse>
        listDiscoveredRanges(
            com.google.cloud.numberregistry.v1alpha.ListDiscoveredRangesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDiscoveredRangesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single DiscoveredRange.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.numberregistry.v1alpha.DiscoveredRange>
        getDiscoveredRange(
            com.google.cloud.numberregistry.v1alpha.GetDiscoveredRangeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDiscoveredRangeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Finds free IP ranges in a single DiscoveredRange.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.numberregistry.v1alpha.FindDiscoveredRangeFreeIpRangesResponse>
        findDiscoveredRangeFreeIpRanges(
            com.google.cloud.numberregistry.v1alpha.FindDiscoveredRangeFreeIpRangesRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindDiscoveredRangeFreeIpRangesMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists CustomRanges in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.numberregistry.v1alpha.ListCustomRangesResponse>
        listCustomRanges(com.google.cloud.numberregistry.v1alpha.ListCustomRangesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCustomRangesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CustomRange.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.numberregistry.v1alpha.CustomRange>
        getCustomRange(com.google.cloud.numberregistry.v1alpha.GetCustomRangeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCustomRangeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a single CustomRange and its utilization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.numberregistry.v1alpha.ShowCustomRangeUtilizationResponse>
        showCustomRangeUtilization(
            com.google.cloud.numberregistry.v1alpha.ShowCustomRangeUtilizationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getShowCustomRangeUtilizationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a single DiscoveredRange and its utilization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.numberregistry.v1alpha.ShowDiscoveredRangeUtilizationResponse>
        showDiscoveredRangeUtilization(
            com.google.cloud.numberregistry.v1alpha.ShowDiscoveredRangeUtilizationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getShowDiscoveredRangeUtilizationMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Finds free IP ranges in a single CustomRange.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.numberregistry.v1alpha.FindCustomRangeFreeIpRangesResponse>
        findCustomRangeFreeIpRanges(
            com.google.cloud.numberregistry.v1alpha.FindCustomRangeFreeIpRangesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindCustomRangeFreeIpRangesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new CustomRange in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createCustomRange(
            com.google.cloud.numberregistry.v1alpha.CreateCustomRangeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCustomRangeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single CustomRange.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateCustomRange(
            com.google.cloud.numberregistry.v1alpha.UpdateCustomRangeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCustomRangeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single CustomRange.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteCustomRange(
            com.google.cloud.numberregistry.v1alpha.DeleteCustomRangeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCustomRangeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_IPAM_ADMIN_SCOPES = 0;
  private static final int METHODID_GET_IPAM_ADMIN_SCOPE = 1;
  private static final int METHODID_CHECK_AVAILABILITY_IPAM_ADMIN_SCOPES = 2;
  private static final int METHODID_CREATE_IPAM_ADMIN_SCOPE = 3;
  private static final int METHODID_UPDATE_IPAM_ADMIN_SCOPE = 4;
  private static final int METHODID_DELETE_IPAM_ADMIN_SCOPE = 5;
  private static final int METHODID_DISABLE_IPAM_ADMIN_SCOPE = 6;
  private static final int METHODID_CLEANUP_IPAM_ADMIN_SCOPE = 7;
  private static final int METHODID_LIST_REGISTRY_BOOKS = 8;
  private static final int METHODID_GET_REGISTRY_BOOK = 9;
  private static final int METHODID_SEARCH_IP_RESOURCES = 10;
  private static final int METHODID_CREATE_REGISTRY_BOOK = 11;
  private static final int METHODID_UPDATE_REGISTRY_BOOK = 12;
  private static final int METHODID_DELETE_REGISTRY_BOOK = 13;
  private static final int METHODID_LIST_REALMS = 14;
  private static final int METHODID_GET_REALM = 15;
  private static final int METHODID_CREATE_REALM = 16;
  private static final int METHODID_UPDATE_REALM = 17;
  private static final int METHODID_DELETE_REALM = 18;
  private static final int METHODID_LIST_DISCOVERED_RANGES = 19;
  private static final int METHODID_GET_DISCOVERED_RANGE = 20;
  private static final int METHODID_FIND_DISCOVERED_RANGE_FREE_IP_RANGES = 21;
  private static final int METHODID_LIST_CUSTOM_RANGES = 22;
  private static final int METHODID_GET_CUSTOM_RANGE = 23;
  private static final int METHODID_SHOW_CUSTOM_RANGE_UTILIZATION = 24;
  private static final int METHODID_SHOW_DISCOVERED_RANGE_UTILIZATION = 25;
  private static final int METHODID_FIND_CUSTOM_RANGE_FREE_IP_RANGES = 26;
  private static final int METHODID_CREATE_CUSTOM_RANGE = 27;
  private static final int METHODID_UPDATE_CUSTOM_RANGE = 28;
  private static final int METHODID_DELETE_CUSTOM_RANGE = 29;

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
        case METHODID_LIST_IPAM_ADMIN_SCOPES:
          serviceImpl.listIpamAdminScopes(
              (com.google.cloud.numberregistry.v1alpha.ListIpamAdminScopesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.numberregistry.v1alpha.ListIpamAdminScopesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_IPAM_ADMIN_SCOPE:
          serviceImpl.getIpamAdminScope(
              (com.google.cloud.numberregistry.v1alpha.GetIpamAdminScopeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.numberregistry.v1alpha.IpamAdminScope>)
                  responseObserver);
          break;
        case METHODID_CHECK_AVAILABILITY_IPAM_ADMIN_SCOPES:
          serviceImpl.checkAvailabilityIpamAdminScopes(
              (com.google.cloud.numberregistry.v1alpha.CheckAvailabilityIpamAdminScopesRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.numberregistry.v1alpha
                          .CheckAvailabilityIpamAdminScopesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_IPAM_ADMIN_SCOPE:
          serviceImpl.createIpamAdminScope(
              (com.google.cloud.numberregistry.v1alpha.CreateIpamAdminScopeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_IPAM_ADMIN_SCOPE:
          serviceImpl.updateIpamAdminScope(
              (com.google.cloud.numberregistry.v1alpha.UpdateIpamAdminScopeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_IPAM_ADMIN_SCOPE:
          serviceImpl.deleteIpamAdminScope(
              (com.google.cloud.numberregistry.v1alpha.DeleteIpamAdminScopeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DISABLE_IPAM_ADMIN_SCOPE:
          serviceImpl.disableIpamAdminScope(
              (com.google.cloud.numberregistry.v1alpha.DisableIpamAdminScopeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CLEANUP_IPAM_ADMIN_SCOPE:
          serviceImpl.cleanupIpamAdminScope(
              (com.google.cloud.numberregistry.v1alpha.CleanupIpamAdminScopeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_REGISTRY_BOOKS:
          serviceImpl.listRegistryBooks(
              (com.google.cloud.numberregistry.v1alpha.ListRegistryBooksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.numberregistry.v1alpha.ListRegistryBooksResponse>)
                  responseObserver);
          break;
        case METHODID_GET_REGISTRY_BOOK:
          serviceImpl.getRegistryBook(
              (com.google.cloud.numberregistry.v1alpha.GetRegistryBookRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.numberregistry.v1alpha.RegistryBook>)
                  responseObserver);
          break;
        case METHODID_SEARCH_IP_RESOURCES:
          serviceImpl.searchIpResources(
              (com.google.cloud.numberregistry.v1alpha.SearchIpResourcesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.numberregistry.v1alpha.SearchIpResourcesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_REGISTRY_BOOK:
          serviceImpl.createRegistryBook(
              (com.google.cloud.numberregistry.v1alpha.CreateRegistryBookRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_REGISTRY_BOOK:
          serviceImpl.updateRegistryBook(
              (com.google.cloud.numberregistry.v1alpha.UpdateRegistryBookRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_REGISTRY_BOOK:
          serviceImpl.deleteRegistryBook(
              (com.google.cloud.numberregistry.v1alpha.DeleteRegistryBookRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_REALMS:
          serviceImpl.listRealms(
              (com.google.cloud.numberregistry.v1alpha.ListRealmsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.numberregistry.v1alpha.ListRealmsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_REALM:
          serviceImpl.getRealm(
              (com.google.cloud.numberregistry.v1alpha.GetRealmRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.numberregistry.v1alpha.Realm>)
                  responseObserver);
          break;
        case METHODID_CREATE_REALM:
          serviceImpl.createRealm(
              (com.google.cloud.numberregistry.v1alpha.CreateRealmRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_REALM:
          serviceImpl.updateRealm(
              (com.google.cloud.numberregistry.v1alpha.UpdateRealmRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_REALM:
          serviceImpl.deleteRealm(
              (com.google.cloud.numberregistry.v1alpha.DeleteRealmRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_DISCOVERED_RANGES:
          serviceImpl.listDiscoveredRanges(
              (com.google.cloud.numberregistry.v1alpha.ListDiscoveredRangesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.numberregistry.v1alpha.ListDiscoveredRangesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DISCOVERED_RANGE:
          serviceImpl.getDiscoveredRange(
              (com.google.cloud.numberregistry.v1alpha.GetDiscoveredRangeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.numberregistry.v1alpha.DiscoveredRange>)
                  responseObserver);
          break;
        case METHODID_FIND_DISCOVERED_RANGE_FREE_IP_RANGES:
          serviceImpl.findDiscoveredRangeFreeIpRanges(
              (com.google.cloud.numberregistry.v1alpha.FindDiscoveredRangeFreeIpRangesRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.numberregistry.v1alpha
                          .FindDiscoveredRangeFreeIpRangesResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_CUSTOM_RANGES:
          serviceImpl.listCustomRanges(
              (com.google.cloud.numberregistry.v1alpha.ListCustomRangesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.numberregistry.v1alpha.ListCustomRangesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CUSTOM_RANGE:
          serviceImpl.getCustomRange(
              (com.google.cloud.numberregistry.v1alpha.GetCustomRangeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.numberregistry.v1alpha.CustomRange>)
                  responseObserver);
          break;
        case METHODID_SHOW_CUSTOM_RANGE_UTILIZATION:
          serviceImpl.showCustomRangeUtilization(
              (com.google.cloud.numberregistry.v1alpha.ShowCustomRangeUtilizationRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.numberregistry.v1alpha.ShowCustomRangeUtilizationResponse>)
                  responseObserver);
          break;
        case METHODID_SHOW_DISCOVERED_RANGE_UTILIZATION:
          serviceImpl.showDiscoveredRangeUtilization(
              (com.google.cloud.numberregistry.v1alpha.ShowDiscoveredRangeUtilizationRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.numberregistry.v1alpha
                          .ShowDiscoveredRangeUtilizationResponse>)
                  responseObserver);
          break;
        case METHODID_FIND_CUSTOM_RANGE_FREE_IP_RANGES:
          serviceImpl.findCustomRangeFreeIpRanges(
              (com.google.cloud.numberregistry.v1alpha.FindCustomRangeFreeIpRangesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.numberregistry.v1alpha.FindCustomRangeFreeIpRangesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_CUSTOM_RANGE:
          serviceImpl.createCustomRange(
              (com.google.cloud.numberregistry.v1alpha.CreateCustomRangeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_CUSTOM_RANGE:
          serviceImpl.updateCustomRange(
              (com.google.cloud.numberregistry.v1alpha.UpdateCustomRangeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CUSTOM_RANGE:
          serviceImpl.deleteCustomRange(
              (com.google.cloud.numberregistry.v1alpha.DeleteCustomRangeRequest) request,
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
            getListIpamAdminScopesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.numberregistry.v1alpha.ListIpamAdminScopesRequest,
                    com.google.cloud.numberregistry.v1alpha.ListIpamAdminScopesResponse>(
                    service, METHODID_LIST_IPAM_ADMIN_SCOPES)))
        .addMethod(
            getGetIpamAdminScopeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.numberregistry.v1alpha.GetIpamAdminScopeRequest,
                    com.google.cloud.numberregistry.v1alpha.IpamAdminScope>(
                    service, METHODID_GET_IPAM_ADMIN_SCOPE)))
        .addMethod(
            getCheckAvailabilityIpamAdminScopesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.numberregistry.v1alpha.CheckAvailabilityIpamAdminScopesRequest,
                    com.google.cloud.numberregistry.v1alpha
                        .CheckAvailabilityIpamAdminScopesResponse>(
                    service, METHODID_CHECK_AVAILABILITY_IPAM_ADMIN_SCOPES)))
        .addMethod(
            getCreateIpamAdminScopeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.numberregistry.v1alpha.CreateIpamAdminScopeRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_IPAM_ADMIN_SCOPE)))
        .addMethod(
            getUpdateIpamAdminScopeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.numberregistry.v1alpha.UpdateIpamAdminScopeRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_IPAM_ADMIN_SCOPE)))
        .addMethod(
            getDeleteIpamAdminScopeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.numberregistry.v1alpha.DeleteIpamAdminScopeRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_IPAM_ADMIN_SCOPE)))
        .addMethod(
            getDisableIpamAdminScopeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.numberregistry.v1alpha.DisableIpamAdminScopeRequest,
                    com.google.longrunning.Operation>(service, METHODID_DISABLE_IPAM_ADMIN_SCOPE)))
        .addMethod(
            getCleanupIpamAdminScopeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.numberregistry.v1alpha.CleanupIpamAdminScopeRequest,
                    com.google.longrunning.Operation>(service, METHODID_CLEANUP_IPAM_ADMIN_SCOPE)))
        .addMethod(
            getListRegistryBooksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.numberregistry.v1alpha.ListRegistryBooksRequest,
                    com.google.cloud.numberregistry.v1alpha.ListRegistryBooksResponse>(
                    service, METHODID_LIST_REGISTRY_BOOKS)))
        .addMethod(
            getGetRegistryBookMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.numberregistry.v1alpha.GetRegistryBookRequest,
                    com.google.cloud.numberregistry.v1alpha.RegistryBook>(
                    service, METHODID_GET_REGISTRY_BOOK)))
        .addMethod(
            getSearchIpResourcesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.numberregistry.v1alpha.SearchIpResourcesRequest,
                    com.google.cloud.numberregistry.v1alpha.SearchIpResourcesResponse>(
                    service, METHODID_SEARCH_IP_RESOURCES)))
        .addMethod(
            getCreateRegistryBookMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.numberregistry.v1alpha.CreateRegistryBookRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_REGISTRY_BOOK)))
        .addMethod(
            getUpdateRegistryBookMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.numberregistry.v1alpha.UpdateRegistryBookRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_REGISTRY_BOOK)))
        .addMethod(
            getDeleteRegistryBookMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.numberregistry.v1alpha.DeleteRegistryBookRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_REGISTRY_BOOK)))
        .addMethod(
            getListRealmsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.numberregistry.v1alpha.ListRealmsRequest,
                    com.google.cloud.numberregistry.v1alpha.ListRealmsResponse>(
                    service, METHODID_LIST_REALMS)))
        .addMethod(
            getGetRealmMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.numberregistry.v1alpha.GetRealmRequest,
                    com.google.cloud.numberregistry.v1alpha.Realm>(service, METHODID_GET_REALM)))
        .addMethod(
            getCreateRealmMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.numberregistry.v1alpha.CreateRealmRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_REALM)))
        .addMethod(
            getUpdateRealmMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.numberregistry.v1alpha.UpdateRealmRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_REALM)))
        .addMethod(
            getDeleteRealmMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.numberregistry.v1alpha.DeleteRealmRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_REALM)))
        .addMethod(
            getListDiscoveredRangesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.numberregistry.v1alpha.ListDiscoveredRangesRequest,
                    com.google.cloud.numberregistry.v1alpha.ListDiscoveredRangesResponse>(
                    service, METHODID_LIST_DISCOVERED_RANGES)))
        .addMethod(
            getGetDiscoveredRangeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.numberregistry.v1alpha.GetDiscoveredRangeRequest,
                    com.google.cloud.numberregistry.v1alpha.DiscoveredRange>(
                    service, METHODID_GET_DISCOVERED_RANGE)))
        .addMethod(
            getFindDiscoveredRangeFreeIpRangesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.numberregistry.v1alpha.FindDiscoveredRangeFreeIpRangesRequest,
                    com.google.cloud.numberregistry.v1alpha
                        .FindDiscoveredRangeFreeIpRangesResponse>(
                    service, METHODID_FIND_DISCOVERED_RANGE_FREE_IP_RANGES)))
        .addMethod(
            getListCustomRangesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.numberregistry.v1alpha.ListCustomRangesRequest,
                    com.google.cloud.numberregistry.v1alpha.ListCustomRangesResponse>(
                    service, METHODID_LIST_CUSTOM_RANGES)))
        .addMethod(
            getGetCustomRangeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.numberregistry.v1alpha.GetCustomRangeRequest,
                    com.google.cloud.numberregistry.v1alpha.CustomRange>(
                    service, METHODID_GET_CUSTOM_RANGE)))
        .addMethod(
            getShowCustomRangeUtilizationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.numberregistry.v1alpha.ShowCustomRangeUtilizationRequest,
                    com.google.cloud.numberregistry.v1alpha.ShowCustomRangeUtilizationResponse>(
                    service, METHODID_SHOW_CUSTOM_RANGE_UTILIZATION)))
        .addMethod(
            getShowDiscoveredRangeUtilizationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.numberregistry.v1alpha.ShowDiscoveredRangeUtilizationRequest,
                    com.google.cloud.numberregistry.v1alpha.ShowDiscoveredRangeUtilizationResponse>(
                    service, METHODID_SHOW_DISCOVERED_RANGE_UTILIZATION)))
        .addMethod(
            getFindCustomRangeFreeIpRangesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.numberregistry.v1alpha.FindCustomRangeFreeIpRangesRequest,
                    com.google.cloud.numberregistry.v1alpha.FindCustomRangeFreeIpRangesResponse>(
                    service, METHODID_FIND_CUSTOM_RANGE_FREE_IP_RANGES)))
        .addMethod(
            getCreateCustomRangeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.numberregistry.v1alpha.CreateCustomRangeRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_CUSTOM_RANGE)))
        .addMethod(
            getUpdateCustomRangeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.numberregistry.v1alpha.UpdateCustomRangeRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_CUSTOM_RANGE)))
        .addMethod(
            getDeleteCustomRangeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.numberregistry.v1alpha.DeleteCustomRangeRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_CUSTOM_RANGE)))
        .build();
  }

  private abstract static class CloudNumberRegistryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CloudNumberRegistryBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.numberregistry.v1alpha.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CloudNumberRegistry");
    }
  }

  private static final class CloudNumberRegistryFileDescriptorSupplier
      extends CloudNumberRegistryBaseDescriptorSupplier {
    CloudNumberRegistryFileDescriptorSupplier() {}
  }

  private static final class CloudNumberRegistryMethodDescriptorSupplier
      extends CloudNumberRegistryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CloudNumberRegistryMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CloudNumberRegistryGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new CloudNumberRegistryFileDescriptorSupplier())
                      .addMethod(getListIpamAdminScopesMethod())
                      .addMethod(getGetIpamAdminScopeMethod())
                      .addMethod(getCheckAvailabilityIpamAdminScopesMethod())
                      .addMethod(getCreateIpamAdminScopeMethod())
                      .addMethod(getUpdateIpamAdminScopeMethod())
                      .addMethod(getDeleteIpamAdminScopeMethod())
                      .addMethod(getDisableIpamAdminScopeMethod())
                      .addMethod(getCleanupIpamAdminScopeMethod())
                      .addMethod(getListRegistryBooksMethod())
                      .addMethod(getGetRegistryBookMethod())
                      .addMethod(getSearchIpResourcesMethod())
                      .addMethod(getCreateRegistryBookMethod())
                      .addMethod(getUpdateRegistryBookMethod())
                      .addMethod(getDeleteRegistryBookMethod())
                      .addMethod(getListRealmsMethod())
                      .addMethod(getGetRealmMethod())
                      .addMethod(getCreateRealmMethod())
                      .addMethod(getUpdateRealmMethod())
                      .addMethod(getDeleteRealmMethod())
                      .addMethod(getListDiscoveredRangesMethod())
                      .addMethod(getGetDiscoveredRangeMethod())
                      .addMethod(getFindDiscoveredRangeFreeIpRangesMethod())
                      .addMethod(getListCustomRangesMethod())
                      .addMethod(getGetCustomRangeMethod())
                      .addMethod(getShowCustomRangeUtilizationMethod())
                      .addMethod(getShowDiscoveredRangeUtilizationMethod())
                      .addMethod(getFindCustomRangeFreeIpRangesMethod())
                      .addMethod(getCreateCustomRangeMethod())
                      .addMethod(getUpdateCustomRangeMethod())
                      .addMethod(getDeleteCustomRangeMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
