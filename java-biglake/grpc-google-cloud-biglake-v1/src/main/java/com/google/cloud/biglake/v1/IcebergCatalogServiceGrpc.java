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
package com.google.cloud.biglake.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Iceberg Catalog Service API: this implements the open-source Iceberg REST
 * Catalog API.
 * See the API definition here:
 * https://github.com/apache/iceberg/blob/main/open-api/rest-catalog-open-api.yaml
 * The API is defined as OpenAPI 3.1.1 spec.
 * Currently we only support the following methods:
 * - GetConfig/GetIcebergCatalogConfig
 * - ListIcebergNamespaces
 * - CheckIcebergNamespaceExists
 * - GetIcebergNamespace
 * - CreateIcebergNamespace (only supports single level)
 * - DeleteIcebergNamespace
 * - UpdateIcebergNamespace properties
 * - ListTableIdentifiers
 * - CreateIcebergTable
 * - DeleteIcebergTable
 * - GetIcebergTable
 * - UpdateIcebergTable (CommitTable)
 * - LoadIcebergTableCredentials
 * - RegisterTable
 * Users are required to provided the `X-Goog-User-Project` header with the
 * project id or number which can be different from the bucket project id.
 * That project will be charged for the API calls and the calling user must have
 * access to that project. The caller must have `serviceusage.services.use`
 * permission on the project.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/biglake/v1/iceberg_rest_catalog.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class IcebergCatalogServiceGrpc {

  private IcebergCatalogServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.biglake.v1.IcebergCatalogService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.GetIcebergCatalogConfigRequest,
          com.google.cloud.biglake.v1.IcebergCatalogConfig>
      getGetIcebergCatalogConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIcebergCatalogConfig",
      requestType = com.google.cloud.biglake.v1.GetIcebergCatalogConfigRequest.class,
      responseType = com.google.cloud.biglake.v1.IcebergCatalogConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.GetIcebergCatalogConfigRequest,
          com.google.cloud.biglake.v1.IcebergCatalogConfig>
      getGetIcebergCatalogConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.v1.GetIcebergCatalogConfigRequest,
            com.google.cloud.biglake.v1.IcebergCatalogConfig>
        getGetIcebergCatalogConfigMethod;
    if ((getGetIcebergCatalogConfigMethod =
            IcebergCatalogServiceGrpc.getGetIcebergCatalogConfigMethod)
        == null) {
      synchronized (IcebergCatalogServiceGrpc.class) {
        if ((getGetIcebergCatalogConfigMethod =
                IcebergCatalogServiceGrpc.getGetIcebergCatalogConfigMethod)
            == null) {
          IcebergCatalogServiceGrpc.getGetIcebergCatalogConfigMethod =
              getGetIcebergCatalogConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.v1.GetIcebergCatalogConfigRequest,
                          com.google.cloud.biglake.v1.IcebergCatalogConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetIcebergCatalogConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.v1.GetIcebergCatalogConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.v1.IcebergCatalogConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IcebergCatalogServiceMethodDescriptorSupplier(
                              "GetIcebergCatalogConfig"))
                      .build();
        }
      }
    }
    return getGetIcebergCatalogConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.ListIcebergNamespacesRequest,
          com.google.cloud.biglake.v1.ListIcebergNamespacesResponse>
      getListIcebergNamespacesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListIcebergNamespaces",
      requestType = com.google.cloud.biglake.v1.ListIcebergNamespacesRequest.class,
      responseType = com.google.cloud.biglake.v1.ListIcebergNamespacesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.ListIcebergNamespacesRequest,
          com.google.cloud.biglake.v1.ListIcebergNamespacesResponse>
      getListIcebergNamespacesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.v1.ListIcebergNamespacesRequest,
            com.google.cloud.biglake.v1.ListIcebergNamespacesResponse>
        getListIcebergNamespacesMethod;
    if ((getListIcebergNamespacesMethod = IcebergCatalogServiceGrpc.getListIcebergNamespacesMethod)
        == null) {
      synchronized (IcebergCatalogServiceGrpc.class) {
        if ((getListIcebergNamespacesMethod =
                IcebergCatalogServiceGrpc.getListIcebergNamespacesMethod)
            == null) {
          IcebergCatalogServiceGrpc.getListIcebergNamespacesMethod =
              getListIcebergNamespacesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.v1.ListIcebergNamespacesRequest,
                          com.google.cloud.biglake.v1.ListIcebergNamespacesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListIcebergNamespaces"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.v1.ListIcebergNamespacesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.v1.ListIcebergNamespacesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IcebergCatalogServiceMethodDescriptorSupplier(
                              "ListIcebergNamespaces"))
                      .build();
        }
      }
    }
    return getListIcebergNamespacesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.GetIcebergNamespaceRequest, com.google.protobuf.Empty>
      getCheckIcebergNamespaceExistsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckIcebergNamespaceExists",
      requestType = com.google.cloud.biglake.v1.GetIcebergNamespaceRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.GetIcebergNamespaceRequest, com.google.protobuf.Empty>
      getCheckIcebergNamespaceExistsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.v1.GetIcebergNamespaceRequest, com.google.protobuf.Empty>
        getCheckIcebergNamespaceExistsMethod;
    if ((getCheckIcebergNamespaceExistsMethod =
            IcebergCatalogServiceGrpc.getCheckIcebergNamespaceExistsMethod)
        == null) {
      synchronized (IcebergCatalogServiceGrpc.class) {
        if ((getCheckIcebergNamespaceExistsMethod =
                IcebergCatalogServiceGrpc.getCheckIcebergNamespaceExistsMethod)
            == null) {
          IcebergCatalogServiceGrpc.getCheckIcebergNamespaceExistsMethod =
              getCheckIcebergNamespaceExistsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.v1.GetIcebergNamespaceRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CheckIcebergNamespaceExists"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.v1.GetIcebergNamespaceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IcebergCatalogServiceMethodDescriptorSupplier(
                              "CheckIcebergNamespaceExists"))
                      .build();
        }
      }
    }
    return getCheckIcebergNamespaceExistsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.GetIcebergNamespaceRequest,
          com.google.cloud.biglake.v1.IcebergNamespace>
      getGetIcebergNamespaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIcebergNamespace",
      requestType = com.google.cloud.biglake.v1.GetIcebergNamespaceRequest.class,
      responseType = com.google.cloud.biglake.v1.IcebergNamespace.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.GetIcebergNamespaceRequest,
          com.google.cloud.biglake.v1.IcebergNamespace>
      getGetIcebergNamespaceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.v1.GetIcebergNamespaceRequest,
            com.google.cloud.biglake.v1.IcebergNamespace>
        getGetIcebergNamespaceMethod;
    if ((getGetIcebergNamespaceMethod = IcebergCatalogServiceGrpc.getGetIcebergNamespaceMethod)
        == null) {
      synchronized (IcebergCatalogServiceGrpc.class) {
        if ((getGetIcebergNamespaceMethod = IcebergCatalogServiceGrpc.getGetIcebergNamespaceMethod)
            == null) {
          IcebergCatalogServiceGrpc.getGetIcebergNamespaceMethod =
              getGetIcebergNamespaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.v1.GetIcebergNamespaceRequest,
                          com.google.cloud.biglake.v1.IcebergNamespace>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetIcebergNamespace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.v1.GetIcebergNamespaceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.v1.IcebergNamespace.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IcebergCatalogServiceMethodDescriptorSupplier("GetIcebergNamespace"))
                      .build();
        }
      }
    }
    return getGetIcebergNamespaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.CreateIcebergNamespaceRequest,
          com.google.cloud.biglake.v1.IcebergNamespace>
      getCreateIcebergNamespaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateIcebergNamespace",
      requestType = com.google.cloud.biglake.v1.CreateIcebergNamespaceRequest.class,
      responseType = com.google.cloud.biglake.v1.IcebergNamespace.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.CreateIcebergNamespaceRequest,
          com.google.cloud.biglake.v1.IcebergNamespace>
      getCreateIcebergNamespaceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.v1.CreateIcebergNamespaceRequest,
            com.google.cloud.biglake.v1.IcebergNamespace>
        getCreateIcebergNamespaceMethod;
    if ((getCreateIcebergNamespaceMethod =
            IcebergCatalogServiceGrpc.getCreateIcebergNamespaceMethod)
        == null) {
      synchronized (IcebergCatalogServiceGrpc.class) {
        if ((getCreateIcebergNamespaceMethod =
                IcebergCatalogServiceGrpc.getCreateIcebergNamespaceMethod)
            == null) {
          IcebergCatalogServiceGrpc.getCreateIcebergNamespaceMethod =
              getCreateIcebergNamespaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.v1.CreateIcebergNamespaceRequest,
                          com.google.cloud.biglake.v1.IcebergNamespace>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateIcebergNamespace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.v1.CreateIcebergNamespaceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.v1.IcebergNamespace.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IcebergCatalogServiceMethodDescriptorSupplier(
                              "CreateIcebergNamespace"))
                      .build();
        }
      }
    }
    return getCreateIcebergNamespaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.DeleteIcebergNamespaceRequest, com.google.protobuf.Empty>
      getDeleteIcebergNamespaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteIcebergNamespace",
      requestType = com.google.cloud.biglake.v1.DeleteIcebergNamespaceRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.DeleteIcebergNamespaceRequest, com.google.protobuf.Empty>
      getDeleteIcebergNamespaceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.v1.DeleteIcebergNamespaceRequest, com.google.protobuf.Empty>
        getDeleteIcebergNamespaceMethod;
    if ((getDeleteIcebergNamespaceMethod =
            IcebergCatalogServiceGrpc.getDeleteIcebergNamespaceMethod)
        == null) {
      synchronized (IcebergCatalogServiceGrpc.class) {
        if ((getDeleteIcebergNamespaceMethod =
                IcebergCatalogServiceGrpc.getDeleteIcebergNamespaceMethod)
            == null) {
          IcebergCatalogServiceGrpc.getDeleteIcebergNamespaceMethod =
              getDeleteIcebergNamespaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.v1.DeleteIcebergNamespaceRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteIcebergNamespace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.v1.DeleteIcebergNamespaceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IcebergCatalogServiceMethodDescriptorSupplier(
                              "DeleteIcebergNamespace"))
                      .build();
        }
      }
    }
    return getDeleteIcebergNamespaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.UpdateIcebergNamespaceRequest,
          com.google.cloud.biglake.v1.UpdateIcebergNamespaceResponse>
      getUpdateIcebergNamespaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateIcebergNamespace",
      requestType = com.google.cloud.biglake.v1.UpdateIcebergNamespaceRequest.class,
      responseType = com.google.cloud.biglake.v1.UpdateIcebergNamespaceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.UpdateIcebergNamespaceRequest,
          com.google.cloud.biglake.v1.UpdateIcebergNamespaceResponse>
      getUpdateIcebergNamespaceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.v1.UpdateIcebergNamespaceRequest,
            com.google.cloud.biglake.v1.UpdateIcebergNamespaceResponse>
        getUpdateIcebergNamespaceMethod;
    if ((getUpdateIcebergNamespaceMethod =
            IcebergCatalogServiceGrpc.getUpdateIcebergNamespaceMethod)
        == null) {
      synchronized (IcebergCatalogServiceGrpc.class) {
        if ((getUpdateIcebergNamespaceMethod =
                IcebergCatalogServiceGrpc.getUpdateIcebergNamespaceMethod)
            == null) {
          IcebergCatalogServiceGrpc.getUpdateIcebergNamespaceMethod =
              getUpdateIcebergNamespaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.v1.UpdateIcebergNamespaceRequest,
                          com.google.cloud.biglake.v1.UpdateIcebergNamespaceResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateIcebergNamespace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.v1.UpdateIcebergNamespaceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.v1.UpdateIcebergNamespaceResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IcebergCatalogServiceMethodDescriptorSupplier(
                              "UpdateIcebergNamespace"))
                      .build();
        }
      }
    }
    return getUpdateIcebergNamespaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.ListIcebergTableIdentifiersRequest,
          com.google.cloud.biglake.v1.ListIcebergTableIdentifiersResponse>
      getListIcebergTableIdentifiersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListIcebergTableIdentifiers",
      requestType = com.google.cloud.biglake.v1.ListIcebergTableIdentifiersRequest.class,
      responseType = com.google.cloud.biglake.v1.ListIcebergTableIdentifiersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.ListIcebergTableIdentifiersRequest,
          com.google.cloud.biglake.v1.ListIcebergTableIdentifiersResponse>
      getListIcebergTableIdentifiersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.v1.ListIcebergTableIdentifiersRequest,
            com.google.cloud.biglake.v1.ListIcebergTableIdentifiersResponse>
        getListIcebergTableIdentifiersMethod;
    if ((getListIcebergTableIdentifiersMethod =
            IcebergCatalogServiceGrpc.getListIcebergTableIdentifiersMethod)
        == null) {
      synchronized (IcebergCatalogServiceGrpc.class) {
        if ((getListIcebergTableIdentifiersMethod =
                IcebergCatalogServiceGrpc.getListIcebergTableIdentifiersMethod)
            == null) {
          IcebergCatalogServiceGrpc.getListIcebergTableIdentifiersMethod =
              getListIcebergTableIdentifiersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.v1.ListIcebergTableIdentifiersRequest,
                          com.google.cloud.biglake.v1.ListIcebergTableIdentifiersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListIcebergTableIdentifiers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.v1.ListIcebergTableIdentifiersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.v1.ListIcebergTableIdentifiersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IcebergCatalogServiceMethodDescriptorSupplier(
                              "ListIcebergTableIdentifiers"))
                      .build();
        }
      }
    }
    return getListIcebergTableIdentifiersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.CreateIcebergTableRequest, com.google.api.HttpBody>
      getCreateIcebergTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateIcebergTable",
      requestType = com.google.cloud.biglake.v1.CreateIcebergTableRequest.class,
      responseType = com.google.api.HttpBody.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.CreateIcebergTableRequest, com.google.api.HttpBody>
      getCreateIcebergTableMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.v1.CreateIcebergTableRequest, com.google.api.HttpBody>
        getCreateIcebergTableMethod;
    if ((getCreateIcebergTableMethod = IcebergCatalogServiceGrpc.getCreateIcebergTableMethod)
        == null) {
      synchronized (IcebergCatalogServiceGrpc.class) {
        if ((getCreateIcebergTableMethod = IcebergCatalogServiceGrpc.getCreateIcebergTableMethod)
            == null) {
          IcebergCatalogServiceGrpc.getCreateIcebergTableMethod =
              getCreateIcebergTableMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.v1.CreateIcebergTableRequest,
                          com.google.api.HttpBody>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateIcebergTable"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.v1.CreateIcebergTableRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.api.HttpBody.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IcebergCatalogServiceMethodDescriptorSupplier("CreateIcebergTable"))
                      .build();
        }
      }
    }
    return getCreateIcebergTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.GetIcebergTableRequest, com.google.protobuf.Empty>
      getCheckIcebergTableExistsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckIcebergTableExists",
      requestType = com.google.cloud.biglake.v1.GetIcebergTableRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.GetIcebergTableRequest, com.google.protobuf.Empty>
      getCheckIcebergTableExistsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.v1.GetIcebergTableRequest, com.google.protobuf.Empty>
        getCheckIcebergTableExistsMethod;
    if ((getCheckIcebergTableExistsMethod =
            IcebergCatalogServiceGrpc.getCheckIcebergTableExistsMethod)
        == null) {
      synchronized (IcebergCatalogServiceGrpc.class) {
        if ((getCheckIcebergTableExistsMethod =
                IcebergCatalogServiceGrpc.getCheckIcebergTableExistsMethod)
            == null) {
          IcebergCatalogServiceGrpc.getCheckIcebergTableExistsMethod =
              getCheckIcebergTableExistsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.v1.GetIcebergTableRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CheckIcebergTableExists"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.v1.GetIcebergTableRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IcebergCatalogServiceMethodDescriptorSupplier(
                              "CheckIcebergTableExists"))
                      .build();
        }
      }
    }
    return getCheckIcebergTableExistsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.DeleteIcebergTableRequest, com.google.protobuf.Empty>
      getDeleteIcebergTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteIcebergTable",
      requestType = com.google.cloud.biglake.v1.DeleteIcebergTableRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.DeleteIcebergTableRequest, com.google.protobuf.Empty>
      getDeleteIcebergTableMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.v1.DeleteIcebergTableRequest, com.google.protobuf.Empty>
        getDeleteIcebergTableMethod;
    if ((getDeleteIcebergTableMethod = IcebergCatalogServiceGrpc.getDeleteIcebergTableMethod)
        == null) {
      synchronized (IcebergCatalogServiceGrpc.class) {
        if ((getDeleteIcebergTableMethod = IcebergCatalogServiceGrpc.getDeleteIcebergTableMethod)
            == null) {
          IcebergCatalogServiceGrpc.getDeleteIcebergTableMethod =
              getDeleteIcebergTableMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.v1.DeleteIcebergTableRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteIcebergTable"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.v1.DeleteIcebergTableRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IcebergCatalogServiceMethodDescriptorSupplier("DeleteIcebergTable"))
                      .build();
        }
      }
    }
    return getDeleteIcebergTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.GetIcebergTableRequest, com.google.api.HttpBody>
      getGetIcebergTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIcebergTable",
      requestType = com.google.cloud.biglake.v1.GetIcebergTableRequest.class,
      responseType = com.google.api.HttpBody.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.GetIcebergTableRequest, com.google.api.HttpBody>
      getGetIcebergTableMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.v1.GetIcebergTableRequest, com.google.api.HttpBody>
        getGetIcebergTableMethod;
    if ((getGetIcebergTableMethod = IcebergCatalogServiceGrpc.getGetIcebergTableMethod) == null) {
      synchronized (IcebergCatalogServiceGrpc.class) {
        if ((getGetIcebergTableMethod = IcebergCatalogServiceGrpc.getGetIcebergTableMethod)
            == null) {
          IcebergCatalogServiceGrpc.getGetIcebergTableMethod =
              getGetIcebergTableMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.v1.GetIcebergTableRequest, com.google.api.HttpBody>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIcebergTable"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.v1.GetIcebergTableRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.api.HttpBody.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IcebergCatalogServiceMethodDescriptorSupplier("GetIcebergTable"))
                      .build();
        }
      }
    }
    return getGetIcebergTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.GetIcebergTableRequest,
          com.google.cloud.biglake.v1.LoadIcebergTableCredentialsResponse>
      getLoadIcebergTableCredentialsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LoadIcebergTableCredentials",
      requestType = com.google.cloud.biglake.v1.GetIcebergTableRequest.class,
      responseType = com.google.cloud.biglake.v1.LoadIcebergTableCredentialsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.GetIcebergTableRequest,
          com.google.cloud.biglake.v1.LoadIcebergTableCredentialsResponse>
      getLoadIcebergTableCredentialsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.v1.GetIcebergTableRequest,
            com.google.cloud.biglake.v1.LoadIcebergTableCredentialsResponse>
        getLoadIcebergTableCredentialsMethod;
    if ((getLoadIcebergTableCredentialsMethod =
            IcebergCatalogServiceGrpc.getLoadIcebergTableCredentialsMethod)
        == null) {
      synchronized (IcebergCatalogServiceGrpc.class) {
        if ((getLoadIcebergTableCredentialsMethod =
                IcebergCatalogServiceGrpc.getLoadIcebergTableCredentialsMethod)
            == null) {
          IcebergCatalogServiceGrpc.getLoadIcebergTableCredentialsMethod =
              getLoadIcebergTableCredentialsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.v1.GetIcebergTableRequest,
                          com.google.cloud.biglake.v1.LoadIcebergTableCredentialsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "LoadIcebergTableCredentials"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.v1.GetIcebergTableRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.v1.LoadIcebergTableCredentialsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IcebergCatalogServiceMethodDescriptorSupplier(
                              "LoadIcebergTableCredentials"))
                      .build();
        }
      }
    }
    return getLoadIcebergTableCredentialsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.UpdateIcebergTableRequest, com.google.api.HttpBody>
      getUpdateIcebergTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateIcebergTable",
      requestType = com.google.cloud.biglake.v1.UpdateIcebergTableRequest.class,
      responseType = com.google.api.HttpBody.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.UpdateIcebergTableRequest, com.google.api.HttpBody>
      getUpdateIcebergTableMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.v1.UpdateIcebergTableRequest, com.google.api.HttpBody>
        getUpdateIcebergTableMethod;
    if ((getUpdateIcebergTableMethod = IcebergCatalogServiceGrpc.getUpdateIcebergTableMethod)
        == null) {
      synchronized (IcebergCatalogServiceGrpc.class) {
        if ((getUpdateIcebergTableMethod = IcebergCatalogServiceGrpc.getUpdateIcebergTableMethod)
            == null) {
          IcebergCatalogServiceGrpc.getUpdateIcebergTableMethod =
              getUpdateIcebergTableMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.v1.UpdateIcebergTableRequest,
                          com.google.api.HttpBody>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateIcebergTable"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.v1.UpdateIcebergTableRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.api.HttpBody.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IcebergCatalogServiceMethodDescriptorSupplier("UpdateIcebergTable"))
                      .build();
        }
      }
    }
    return getUpdateIcebergTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.RegisterIcebergTableRequest, com.google.api.HttpBody>
      getRegisterIcebergTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RegisterIcebergTable",
      requestType = com.google.cloud.biglake.v1.RegisterIcebergTableRequest.class,
      responseType = com.google.api.HttpBody.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.RegisterIcebergTableRequest, com.google.api.HttpBody>
      getRegisterIcebergTableMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.v1.RegisterIcebergTableRequest, com.google.api.HttpBody>
        getRegisterIcebergTableMethod;
    if ((getRegisterIcebergTableMethod = IcebergCatalogServiceGrpc.getRegisterIcebergTableMethod)
        == null) {
      synchronized (IcebergCatalogServiceGrpc.class) {
        if ((getRegisterIcebergTableMethod =
                IcebergCatalogServiceGrpc.getRegisterIcebergTableMethod)
            == null) {
          IcebergCatalogServiceGrpc.getRegisterIcebergTableMethod =
              getRegisterIcebergTableMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.v1.RegisterIcebergTableRequest,
                          com.google.api.HttpBody>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RegisterIcebergTable"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.v1.RegisterIcebergTableRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.api.HttpBody.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IcebergCatalogServiceMethodDescriptorSupplier("RegisterIcebergTable"))
                      .build();
        }
      }
    }
    return getRegisterIcebergTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.GetIcebergCatalogRequest,
          com.google.cloud.biglake.v1.IcebergCatalog>
      getGetIcebergCatalogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIcebergCatalog",
      requestType = com.google.cloud.biglake.v1.GetIcebergCatalogRequest.class,
      responseType = com.google.cloud.biglake.v1.IcebergCatalog.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.GetIcebergCatalogRequest,
          com.google.cloud.biglake.v1.IcebergCatalog>
      getGetIcebergCatalogMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.v1.GetIcebergCatalogRequest,
            com.google.cloud.biglake.v1.IcebergCatalog>
        getGetIcebergCatalogMethod;
    if ((getGetIcebergCatalogMethod = IcebergCatalogServiceGrpc.getGetIcebergCatalogMethod)
        == null) {
      synchronized (IcebergCatalogServiceGrpc.class) {
        if ((getGetIcebergCatalogMethod = IcebergCatalogServiceGrpc.getGetIcebergCatalogMethod)
            == null) {
          IcebergCatalogServiceGrpc.getGetIcebergCatalogMethod =
              getGetIcebergCatalogMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.v1.GetIcebergCatalogRequest,
                          com.google.cloud.biglake.v1.IcebergCatalog>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIcebergCatalog"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.v1.GetIcebergCatalogRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.v1.IcebergCatalog.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IcebergCatalogServiceMethodDescriptorSupplier("GetIcebergCatalog"))
                      .build();
        }
      }
    }
    return getGetIcebergCatalogMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.ListIcebergCatalogsRequest,
          com.google.cloud.biglake.v1.ListIcebergCatalogsResponse>
      getListIcebergCatalogsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListIcebergCatalogs",
      requestType = com.google.cloud.biglake.v1.ListIcebergCatalogsRequest.class,
      responseType = com.google.cloud.biglake.v1.ListIcebergCatalogsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.ListIcebergCatalogsRequest,
          com.google.cloud.biglake.v1.ListIcebergCatalogsResponse>
      getListIcebergCatalogsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.v1.ListIcebergCatalogsRequest,
            com.google.cloud.biglake.v1.ListIcebergCatalogsResponse>
        getListIcebergCatalogsMethod;
    if ((getListIcebergCatalogsMethod = IcebergCatalogServiceGrpc.getListIcebergCatalogsMethod)
        == null) {
      synchronized (IcebergCatalogServiceGrpc.class) {
        if ((getListIcebergCatalogsMethod = IcebergCatalogServiceGrpc.getListIcebergCatalogsMethod)
            == null) {
          IcebergCatalogServiceGrpc.getListIcebergCatalogsMethod =
              getListIcebergCatalogsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.v1.ListIcebergCatalogsRequest,
                          com.google.cloud.biglake.v1.ListIcebergCatalogsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListIcebergCatalogs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.v1.ListIcebergCatalogsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.v1.ListIcebergCatalogsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IcebergCatalogServiceMethodDescriptorSupplier("ListIcebergCatalogs"))
                      .build();
        }
      }
    }
    return getListIcebergCatalogsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.DeleteIcebergCatalogRequest, com.google.protobuf.Empty>
      getDeleteIcebergCatalogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteIcebergCatalog",
      requestType = com.google.cloud.biglake.v1.DeleteIcebergCatalogRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.DeleteIcebergCatalogRequest, com.google.protobuf.Empty>
      getDeleteIcebergCatalogMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.v1.DeleteIcebergCatalogRequest, com.google.protobuf.Empty>
        getDeleteIcebergCatalogMethod;
    if ((getDeleteIcebergCatalogMethod = IcebergCatalogServiceGrpc.getDeleteIcebergCatalogMethod)
        == null) {
      synchronized (IcebergCatalogServiceGrpc.class) {
        if ((getDeleteIcebergCatalogMethod =
                IcebergCatalogServiceGrpc.getDeleteIcebergCatalogMethod)
            == null) {
          IcebergCatalogServiceGrpc.getDeleteIcebergCatalogMethod =
              getDeleteIcebergCatalogMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.v1.DeleteIcebergCatalogRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteIcebergCatalog"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.v1.DeleteIcebergCatalogRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IcebergCatalogServiceMethodDescriptorSupplier("DeleteIcebergCatalog"))
                      .build();
        }
      }
    }
    return getDeleteIcebergCatalogMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.UpdateIcebergCatalogRequest,
          com.google.cloud.biglake.v1.IcebergCatalog>
      getUpdateIcebergCatalogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateIcebergCatalog",
      requestType = com.google.cloud.biglake.v1.UpdateIcebergCatalogRequest.class,
      responseType = com.google.cloud.biglake.v1.IcebergCatalog.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.UpdateIcebergCatalogRequest,
          com.google.cloud.biglake.v1.IcebergCatalog>
      getUpdateIcebergCatalogMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.v1.UpdateIcebergCatalogRequest,
            com.google.cloud.biglake.v1.IcebergCatalog>
        getUpdateIcebergCatalogMethod;
    if ((getUpdateIcebergCatalogMethod = IcebergCatalogServiceGrpc.getUpdateIcebergCatalogMethod)
        == null) {
      synchronized (IcebergCatalogServiceGrpc.class) {
        if ((getUpdateIcebergCatalogMethod =
                IcebergCatalogServiceGrpc.getUpdateIcebergCatalogMethod)
            == null) {
          IcebergCatalogServiceGrpc.getUpdateIcebergCatalogMethod =
              getUpdateIcebergCatalogMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.v1.UpdateIcebergCatalogRequest,
                          com.google.cloud.biglake.v1.IcebergCatalog>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateIcebergCatalog"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.v1.UpdateIcebergCatalogRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.v1.IcebergCatalog.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IcebergCatalogServiceMethodDescriptorSupplier("UpdateIcebergCatalog"))
                      .build();
        }
      }
    }
    return getUpdateIcebergCatalogMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.CreateIcebergCatalogRequest,
          com.google.cloud.biglake.v1.IcebergCatalog>
      getCreateIcebergCatalogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateIcebergCatalog",
      requestType = com.google.cloud.biglake.v1.CreateIcebergCatalogRequest.class,
      responseType = com.google.cloud.biglake.v1.IcebergCatalog.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.CreateIcebergCatalogRequest,
          com.google.cloud.biglake.v1.IcebergCatalog>
      getCreateIcebergCatalogMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.v1.CreateIcebergCatalogRequest,
            com.google.cloud.biglake.v1.IcebergCatalog>
        getCreateIcebergCatalogMethod;
    if ((getCreateIcebergCatalogMethod = IcebergCatalogServiceGrpc.getCreateIcebergCatalogMethod)
        == null) {
      synchronized (IcebergCatalogServiceGrpc.class) {
        if ((getCreateIcebergCatalogMethod =
                IcebergCatalogServiceGrpc.getCreateIcebergCatalogMethod)
            == null) {
          IcebergCatalogServiceGrpc.getCreateIcebergCatalogMethod =
              getCreateIcebergCatalogMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.v1.CreateIcebergCatalogRequest,
                          com.google.cloud.biglake.v1.IcebergCatalog>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateIcebergCatalog"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.v1.CreateIcebergCatalogRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.v1.IcebergCatalog.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IcebergCatalogServiceMethodDescriptorSupplier("CreateIcebergCatalog"))
                      .build();
        }
      }
    }
    return getCreateIcebergCatalogMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.FailoverIcebergCatalogRequest,
          com.google.cloud.biglake.v1.FailoverIcebergCatalogResponse>
      getFailoverIcebergCatalogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FailoverIcebergCatalog",
      requestType = com.google.cloud.biglake.v1.FailoverIcebergCatalogRequest.class,
      responseType = com.google.cloud.biglake.v1.FailoverIcebergCatalogResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.v1.FailoverIcebergCatalogRequest,
          com.google.cloud.biglake.v1.FailoverIcebergCatalogResponse>
      getFailoverIcebergCatalogMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.v1.FailoverIcebergCatalogRequest,
            com.google.cloud.biglake.v1.FailoverIcebergCatalogResponse>
        getFailoverIcebergCatalogMethod;
    if ((getFailoverIcebergCatalogMethod =
            IcebergCatalogServiceGrpc.getFailoverIcebergCatalogMethod)
        == null) {
      synchronized (IcebergCatalogServiceGrpc.class) {
        if ((getFailoverIcebergCatalogMethod =
                IcebergCatalogServiceGrpc.getFailoverIcebergCatalogMethod)
            == null) {
          IcebergCatalogServiceGrpc.getFailoverIcebergCatalogMethod =
              getFailoverIcebergCatalogMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.v1.FailoverIcebergCatalogRequest,
                          com.google.cloud.biglake.v1.FailoverIcebergCatalogResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "FailoverIcebergCatalog"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.v1.FailoverIcebergCatalogRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.v1.FailoverIcebergCatalogResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IcebergCatalogServiceMethodDescriptorSupplier(
                              "FailoverIcebergCatalog"))
                      .build();
        }
      }
    }
    return getFailoverIcebergCatalogMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static IcebergCatalogServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IcebergCatalogServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IcebergCatalogServiceStub>() {
          @java.lang.Override
          public IcebergCatalogServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IcebergCatalogServiceStub(channel, callOptions);
          }
        };
    return IcebergCatalogServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static IcebergCatalogServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IcebergCatalogServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IcebergCatalogServiceBlockingV2Stub>() {
          @java.lang.Override
          public IcebergCatalogServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IcebergCatalogServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return IcebergCatalogServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IcebergCatalogServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IcebergCatalogServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IcebergCatalogServiceBlockingStub>() {
          @java.lang.Override
          public IcebergCatalogServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IcebergCatalogServiceBlockingStub(channel, callOptions);
          }
        };
    return IcebergCatalogServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static IcebergCatalogServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IcebergCatalogServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IcebergCatalogServiceFutureStub>() {
          @java.lang.Override
          public IcebergCatalogServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IcebergCatalogServiceFutureStub(channel, callOptions);
          }
        };
    return IcebergCatalogServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Iceberg Catalog Service API: this implements the open-source Iceberg REST
   * Catalog API.
   * See the API definition here:
   * https://github.com/apache/iceberg/blob/main/open-api/rest-catalog-open-api.yaml
   * The API is defined as OpenAPI 3.1.1 spec.
   * Currently we only support the following methods:
   * - GetConfig/GetIcebergCatalogConfig
   * - ListIcebergNamespaces
   * - CheckIcebergNamespaceExists
   * - GetIcebergNamespace
   * - CreateIcebergNamespace (only supports single level)
   * - DeleteIcebergNamespace
   * - UpdateIcebergNamespace properties
   * - ListTableIdentifiers
   * - CreateIcebergTable
   * - DeleteIcebergTable
   * - GetIcebergTable
   * - UpdateIcebergTable (CommitTable)
   * - LoadIcebergTableCredentials
   * - RegisterTable
   * Users are required to provided the `X-Goog-User-Project` header with the
   * project id or number which can be different from the bucket project id.
   * That project will be charged for the API calls and the calling user must have
   * access to that project. The caller must have `serviceusage.services.use`
   * permission on the project.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * GetIcebergCatalogConfig lists all catalog configuration settings. Most
     * importantly it contains the optional `endpoints` field which lists what
     * methods this catalog supports, since we are not supporting all the methods
     * right now.
     * It returns all the methods defined in this service (subject to project
     * config allowlisting).
     * This is not a GCP resource.
     * </pre>
     */
    default void getIcebergCatalogConfig(
        com.google.cloud.biglake.v1.GetIcebergCatalogConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.v1.IcebergCatalogConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetIcebergCatalogConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Iceberg namespaces in the catalog. We only support one level of
     * nesting for namespaces.
     * </pre>
     */
    default void listIcebergNamespaces(
        com.google.cloud.biglake.v1.ListIcebergNamespacesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.v1.ListIcebergNamespacesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListIcebergNamespacesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns 204 if the namespace exists, 404 otherwise.
     * </pre>
     */
    default void checkIcebergNamespaceExists(
        com.google.cloud.biglake.v1.GetIcebergNamespaceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCheckIcebergNamespaceExistsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an Iceberg namespace in the catalog (or checks if it exists, if the
     * method is HEAD).
     * </pre>
     */
    default void getIcebergNamespace(
        com.google.cloud.biglake.v1.GetIcebergNamespaceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.v1.IcebergNamespace>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetIcebergNamespaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a namespace in the catalog.
     * </pre>
     */
    default void createIcebergNamespace(
        com.google.cloud.biglake.v1.CreateIcebergNamespaceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.v1.IcebergNamespace>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateIcebergNamespaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns 204, not 200 on success.
     * </pre>
     */
    default void deleteIcebergNamespace(
        com.google.cloud.biglake.v1.DeleteIcebergNamespaceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteIcebergNamespaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates namespace properties.
     * </pre>
     */
    default void updateIcebergNamespace(
        com.google.cloud.biglake.v1.UpdateIcebergNamespaceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.v1.UpdateIcebergNamespaceResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateIcebergNamespaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists table identifiers (not *tables*) in the namespace.
     * </pre>
     */
    default void listIcebergTableIdentifiers(
        com.google.cloud.biglake.v1.ListIcebergTableIdentifiersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.v1.ListIcebergTableIdentifiersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListIcebergTableIdentifiersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a table in the namespace.
     * </pre>
     */
    default void createIcebergTable(
        com.google.cloud.biglake.v1.CreateIcebergTableRequest request,
        io.grpc.stub.StreamObserver<com.google.api.HttpBody> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateIcebergTableMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns 204 if the table exists, 404 otherwise. This is a `HEAD` HTTP
     * method.
     * </pre>
     */
    default void checkIcebergTableExists(
        com.google.cloud.biglake.v1.GetIcebergTableRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCheckIcebergTableExistsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a table in the namespace.
     * </pre>
     */
    default void deleteIcebergTable(
        com.google.cloud.biglake.v1.DeleteIcebergTableRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteIcebergTableMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a table in the namespace.
     * </pre>
     */
    default void getIcebergTable(
        com.google.cloud.biglake.v1.GetIcebergTableRequest request,
        io.grpc.stub.StreamObserver<com.google.api.HttpBody> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetIcebergTableMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Loads credentials for a table in the namespace.
     * </pre>
     */
    default void loadIcebergTableCredentials(
        com.google.cloud.biglake.v1.GetIcebergTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.v1.LoadIcebergTableCredentialsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getLoadIcebergTableCredentialsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This is CommitTable Iceberg API, which maps to `UpdateIcebergTable` in the
     * Google API nomenclature.
     * </pre>
     */
    default void updateIcebergTable(
        com.google.cloud.biglake.v1.UpdateIcebergTableRequest request,
        io.grpc.stub.StreamObserver<com.google.api.HttpBody> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateIcebergTableMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Register a table using given metadata file location.
     * </pre>
     */
    default void registerIcebergTable(
        com.google.cloud.biglake.v1.RegisterIcebergTableRequest request,
        io.grpc.stub.StreamObserver<com.google.api.HttpBody> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRegisterIcebergTableMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the Iceberg REST Catalog configuration options.
     * </pre>
     */
    default void getIcebergCatalog(
        com.google.cloud.biglake.v1.GetIcebergCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.v1.IcebergCatalog> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetIcebergCatalogMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the Iceberg REST Catalogs.
     * </pre>
     */
    default void listIcebergCatalogs(
        com.google.cloud.biglake.v1.ListIcebergCatalogsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.v1.ListIcebergCatalogsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListIcebergCatalogsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the Iceberg REST Catalog.
     * Delete does not delete a catalog that has contents -- at least one
     * namespace.
     * Delete is not supported for all catalog types.
     * </pre>
     */
    default void deleteIcebergCatalog(
        com.google.cloud.biglake.v1.DeleteIcebergCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteIcebergCatalogMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update the Iceberg REST Catalog configuration options.
     * </pre>
     */
    default void updateIcebergCatalog(
        com.google.cloud.biglake.v1.UpdateIcebergCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.v1.IcebergCatalog> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateIcebergCatalogMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates the Iceberg REST Catalog.
     * Currently only supports Google Cloud Storage Bucket catalogs.
     * Google Cloud Storage Bucket catalog id is the bucket for which the
     * catalog is created (e.g. `my-catalog` for `gs://my-catalog`).
     * If the bucket does not exist, of the caller does not have bucket metadata
     * permissions, the catalog will not be created.
     * </pre>
     */
    default void createIcebergCatalog(
        com.google.cloud.biglake.v1.CreateIcebergCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.v1.IcebergCatalog> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateIcebergCatalogMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Failover the catalog to a new primary replica region.
     * </pre>
     */
    default void failoverIcebergCatalog(
        com.google.cloud.biglake.v1.FailoverIcebergCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.v1.FailoverIcebergCatalogResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFailoverIcebergCatalogMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service IcebergCatalogService.
   *
   * <pre>
   * Iceberg Catalog Service API: this implements the open-source Iceberg REST
   * Catalog API.
   * See the API definition here:
   * https://github.com/apache/iceberg/blob/main/open-api/rest-catalog-open-api.yaml
   * The API is defined as OpenAPI 3.1.1 spec.
   * Currently we only support the following methods:
   * - GetConfig/GetIcebergCatalogConfig
   * - ListIcebergNamespaces
   * - CheckIcebergNamespaceExists
   * - GetIcebergNamespace
   * - CreateIcebergNamespace (only supports single level)
   * - DeleteIcebergNamespace
   * - UpdateIcebergNamespace properties
   * - ListTableIdentifiers
   * - CreateIcebergTable
   * - DeleteIcebergTable
   * - GetIcebergTable
   * - UpdateIcebergTable (CommitTable)
   * - LoadIcebergTableCredentials
   * - RegisterTable
   * Users are required to provided the `X-Goog-User-Project` header with the
   * project id or number which can be different from the bucket project id.
   * That project will be charged for the API calls and the calling user must have
   * access to that project. The caller must have `serviceusage.services.use`
   * permission on the project.
   * </pre>
   */
  public abstract static class IcebergCatalogServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return IcebergCatalogServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service IcebergCatalogService.
   *
   * <pre>
   * Iceberg Catalog Service API: this implements the open-source Iceberg REST
   * Catalog API.
   * See the API definition here:
   * https://github.com/apache/iceberg/blob/main/open-api/rest-catalog-open-api.yaml
   * The API is defined as OpenAPI 3.1.1 spec.
   * Currently we only support the following methods:
   * - GetConfig/GetIcebergCatalogConfig
   * - ListIcebergNamespaces
   * - CheckIcebergNamespaceExists
   * - GetIcebergNamespace
   * - CreateIcebergNamespace (only supports single level)
   * - DeleteIcebergNamespace
   * - UpdateIcebergNamespace properties
   * - ListTableIdentifiers
   * - CreateIcebergTable
   * - DeleteIcebergTable
   * - GetIcebergTable
   * - UpdateIcebergTable (CommitTable)
   * - LoadIcebergTableCredentials
   * - RegisterTable
   * Users are required to provided the `X-Goog-User-Project` header with the
   * project id or number which can be different from the bucket project id.
   * That project will be charged for the API calls and the calling user must have
   * access to that project. The caller must have `serviceusage.services.use`
   * permission on the project.
   * </pre>
   */
  public static final class IcebergCatalogServiceStub
      extends io.grpc.stub.AbstractAsyncStub<IcebergCatalogServiceStub> {
    private IcebergCatalogServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IcebergCatalogServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IcebergCatalogServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * GetIcebergCatalogConfig lists all catalog configuration settings. Most
     * importantly it contains the optional `endpoints` field which lists what
     * methods this catalog supports, since we are not supporting all the methods
     * right now.
     * It returns all the methods defined in this service (subject to project
     * config allowlisting).
     * This is not a GCP resource.
     * </pre>
     */
    public void getIcebergCatalogConfig(
        com.google.cloud.biglake.v1.GetIcebergCatalogConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.v1.IcebergCatalogConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIcebergCatalogConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Iceberg namespaces in the catalog. We only support one level of
     * nesting for namespaces.
     * </pre>
     */
    public void listIcebergNamespaces(
        com.google.cloud.biglake.v1.ListIcebergNamespacesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.v1.ListIcebergNamespacesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListIcebergNamespacesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns 204 if the namespace exists, 404 otherwise.
     * </pre>
     */
    public void checkIcebergNamespaceExists(
        com.google.cloud.biglake.v1.GetIcebergNamespaceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckIcebergNamespaceExistsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an Iceberg namespace in the catalog (or checks if it exists, if the
     * method is HEAD).
     * </pre>
     */
    public void getIcebergNamespace(
        com.google.cloud.biglake.v1.GetIcebergNamespaceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.v1.IcebergNamespace>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIcebergNamespaceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a namespace in the catalog.
     * </pre>
     */
    public void createIcebergNamespace(
        com.google.cloud.biglake.v1.CreateIcebergNamespaceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.v1.IcebergNamespace>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateIcebergNamespaceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns 204, not 200 on success.
     * </pre>
     */
    public void deleteIcebergNamespace(
        com.google.cloud.biglake.v1.DeleteIcebergNamespaceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteIcebergNamespaceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates namespace properties.
     * </pre>
     */
    public void updateIcebergNamespace(
        com.google.cloud.biglake.v1.UpdateIcebergNamespaceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.v1.UpdateIcebergNamespaceResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateIcebergNamespaceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists table identifiers (not *tables*) in the namespace.
     * </pre>
     */
    public void listIcebergTableIdentifiers(
        com.google.cloud.biglake.v1.ListIcebergTableIdentifiersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.v1.ListIcebergTableIdentifiersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListIcebergTableIdentifiersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a table in the namespace.
     * </pre>
     */
    public void createIcebergTable(
        com.google.cloud.biglake.v1.CreateIcebergTableRequest request,
        io.grpc.stub.StreamObserver<com.google.api.HttpBody> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateIcebergTableMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns 204 if the table exists, 404 otherwise. This is a `HEAD` HTTP
     * method.
     * </pre>
     */
    public void checkIcebergTableExists(
        com.google.cloud.biglake.v1.GetIcebergTableRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckIcebergTableExistsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a table in the namespace.
     * </pre>
     */
    public void deleteIcebergTable(
        com.google.cloud.biglake.v1.DeleteIcebergTableRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteIcebergTableMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a table in the namespace.
     * </pre>
     */
    public void getIcebergTable(
        com.google.cloud.biglake.v1.GetIcebergTableRequest request,
        io.grpc.stub.StreamObserver<com.google.api.HttpBody> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIcebergTableMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Loads credentials for a table in the namespace.
     * </pre>
     */
    public void loadIcebergTableCredentials(
        com.google.cloud.biglake.v1.GetIcebergTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.v1.LoadIcebergTableCredentialsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLoadIcebergTableCredentialsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This is CommitTable Iceberg API, which maps to `UpdateIcebergTable` in the
     * Google API nomenclature.
     * </pre>
     */
    public void updateIcebergTable(
        com.google.cloud.biglake.v1.UpdateIcebergTableRequest request,
        io.grpc.stub.StreamObserver<com.google.api.HttpBody> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateIcebergTableMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Register a table using given metadata file location.
     * </pre>
     */
    public void registerIcebergTable(
        com.google.cloud.biglake.v1.RegisterIcebergTableRequest request,
        io.grpc.stub.StreamObserver<com.google.api.HttpBody> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRegisterIcebergTableMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the Iceberg REST Catalog configuration options.
     * </pre>
     */
    public void getIcebergCatalog(
        com.google.cloud.biglake.v1.GetIcebergCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.v1.IcebergCatalog> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIcebergCatalogMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the Iceberg REST Catalogs.
     * </pre>
     */
    public void listIcebergCatalogs(
        com.google.cloud.biglake.v1.ListIcebergCatalogsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.v1.ListIcebergCatalogsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListIcebergCatalogsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the Iceberg REST Catalog.
     * Delete does not delete a catalog that has contents -- at least one
     * namespace.
     * Delete is not supported for all catalog types.
     * </pre>
     */
    public void deleteIcebergCatalog(
        com.google.cloud.biglake.v1.DeleteIcebergCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteIcebergCatalogMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update the Iceberg REST Catalog configuration options.
     * </pre>
     */
    public void updateIcebergCatalog(
        com.google.cloud.biglake.v1.UpdateIcebergCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.v1.IcebergCatalog> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateIcebergCatalogMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates the Iceberg REST Catalog.
     * Currently only supports Google Cloud Storage Bucket catalogs.
     * Google Cloud Storage Bucket catalog id is the bucket for which the
     * catalog is created (e.g. `my-catalog` for `gs://my-catalog`).
     * If the bucket does not exist, of the caller does not have bucket metadata
     * permissions, the catalog will not be created.
     * </pre>
     */
    public void createIcebergCatalog(
        com.google.cloud.biglake.v1.CreateIcebergCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.v1.IcebergCatalog> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateIcebergCatalogMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Failover the catalog to a new primary replica region.
     * </pre>
     */
    public void failoverIcebergCatalog(
        com.google.cloud.biglake.v1.FailoverIcebergCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.v1.FailoverIcebergCatalogResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFailoverIcebergCatalogMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service IcebergCatalogService.
   *
   * <pre>
   * Iceberg Catalog Service API: this implements the open-source Iceberg REST
   * Catalog API.
   * See the API definition here:
   * https://github.com/apache/iceberg/blob/main/open-api/rest-catalog-open-api.yaml
   * The API is defined as OpenAPI 3.1.1 spec.
   * Currently we only support the following methods:
   * - GetConfig/GetIcebergCatalogConfig
   * - ListIcebergNamespaces
   * - CheckIcebergNamespaceExists
   * - GetIcebergNamespace
   * - CreateIcebergNamespace (only supports single level)
   * - DeleteIcebergNamespace
   * - UpdateIcebergNamespace properties
   * - ListTableIdentifiers
   * - CreateIcebergTable
   * - DeleteIcebergTable
   * - GetIcebergTable
   * - UpdateIcebergTable (CommitTable)
   * - LoadIcebergTableCredentials
   * - RegisterTable
   * Users are required to provided the `X-Goog-User-Project` header with the
   * project id or number which can be different from the bucket project id.
   * That project will be charged for the API calls and the calling user must have
   * access to that project. The caller must have `serviceusage.services.use`
   * permission on the project.
   * </pre>
   */
  public static final class IcebergCatalogServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<IcebergCatalogServiceBlockingV2Stub> {
    private IcebergCatalogServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IcebergCatalogServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IcebergCatalogServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * GetIcebergCatalogConfig lists all catalog configuration settings. Most
     * importantly it contains the optional `endpoints` field which lists what
     * methods this catalog supports, since we are not supporting all the methods
     * right now.
     * It returns all the methods defined in this service (subject to project
     * config allowlisting).
     * This is not a GCP resource.
     * </pre>
     */
    public com.google.cloud.biglake.v1.IcebergCatalogConfig getIcebergCatalogConfig(
        com.google.cloud.biglake.v1.GetIcebergCatalogConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIcebergCatalogConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Iceberg namespaces in the catalog. We only support one level of
     * nesting for namespaces.
     * </pre>
     */
    public com.google.cloud.biglake.v1.ListIcebergNamespacesResponse listIcebergNamespaces(
        com.google.cloud.biglake.v1.ListIcebergNamespacesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListIcebergNamespacesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns 204 if the namespace exists, 404 otherwise.
     * </pre>
     */
    public com.google.protobuf.Empty checkIcebergNamespaceExists(
        com.google.cloud.biglake.v1.GetIcebergNamespaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckIcebergNamespaceExistsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an Iceberg namespace in the catalog (or checks if it exists, if the
     * method is HEAD).
     * </pre>
     */
    public com.google.cloud.biglake.v1.IcebergNamespace getIcebergNamespace(
        com.google.cloud.biglake.v1.GetIcebergNamespaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIcebergNamespaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a namespace in the catalog.
     * </pre>
     */
    public com.google.cloud.biglake.v1.IcebergNamespace createIcebergNamespace(
        com.google.cloud.biglake.v1.CreateIcebergNamespaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateIcebergNamespaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns 204, not 200 on success.
     * </pre>
     */
    public com.google.protobuf.Empty deleteIcebergNamespace(
        com.google.cloud.biglake.v1.DeleteIcebergNamespaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteIcebergNamespaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates namespace properties.
     * </pre>
     */
    public com.google.cloud.biglake.v1.UpdateIcebergNamespaceResponse updateIcebergNamespace(
        com.google.cloud.biglake.v1.UpdateIcebergNamespaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateIcebergNamespaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists table identifiers (not *tables*) in the namespace.
     * </pre>
     */
    public com.google.cloud.biglake.v1.ListIcebergTableIdentifiersResponse
        listIcebergTableIdentifiers(
            com.google.cloud.biglake.v1.ListIcebergTableIdentifiersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListIcebergTableIdentifiersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a table in the namespace.
     * </pre>
     */
    public com.google.api.HttpBody createIcebergTable(
        com.google.cloud.biglake.v1.CreateIcebergTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateIcebergTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns 204 if the table exists, 404 otherwise. This is a `HEAD` HTTP
     * method.
     * </pre>
     */
    public com.google.protobuf.Empty checkIcebergTableExists(
        com.google.cloud.biglake.v1.GetIcebergTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckIcebergTableExistsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a table in the namespace.
     * </pre>
     */
    public com.google.protobuf.Empty deleteIcebergTable(
        com.google.cloud.biglake.v1.DeleteIcebergTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteIcebergTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a table in the namespace.
     * </pre>
     */
    public com.google.api.HttpBody getIcebergTable(
        com.google.cloud.biglake.v1.GetIcebergTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIcebergTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Loads credentials for a table in the namespace.
     * </pre>
     */
    public com.google.cloud.biglake.v1.LoadIcebergTableCredentialsResponse
        loadIcebergTableCredentials(com.google.cloud.biglake.v1.GetIcebergTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLoadIcebergTableCredentialsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * This is CommitTable Iceberg API, which maps to `UpdateIcebergTable` in the
     * Google API nomenclature.
     * </pre>
     */
    public com.google.api.HttpBody updateIcebergTable(
        com.google.cloud.biglake.v1.UpdateIcebergTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateIcebergTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Register a table using given metadata file location.
     * </pre>
     */
    public com.google.api.HttpBody registerIcebergTable(
        com.google.cloud.biglake.v1.RegisterIcebergTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRegisterIcebergTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the Iceberg REST Catalog configuration options.
     * </pre>
     */
    public com.google.cloud.biglake.v1.IcebergCatalog getIcebergCatalog(
        com.google.cloud.biglake.v1.GetIcebergCatalogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIcebergCatalogMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the Iceberg REST Catalogs.
     * </pre>
     */
    public com.google.cloud.biglake.v1.ListIcebergCatalogsResponse listIcebergCatalogs(
        com.google.cloud.biglake.v1.ListIcebergCatalogsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListIcebergCatalogsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the Iceberg REST Catalog.
     * Delete does not delete a catalog that has contents -- at least one
     * namespace.
     * Delete is not supported for all catalog types.
     * </pre>
     */
    public com.google.protobuf.Empty deleteIcebergCatalog(
        com.google.cloud.biglake.v1.DeleteIcebergCatalogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteIcebergCatalogMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update the Iceberg REST Catalog configuration options.
     * </pre>
     */
    public com.google.cloud.biglake.v1.IcebergCatalog updateIcebergCatalog(
        com.google.cloud.biglake.v1.UpdateIcebergCatalogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateIcebergCatalogMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates the Iceberg REST Catalog.
     * Currently only supports Google Cloud Storage Bucket catalogs.
     * Google Cloud Storage Bucket catalog id is the bucket for which the
     * catalog is created (e.g. `my-catalog` for `gs://my-catalog`).
     * If the bucket does not exist, of the caller does not have bucket metadata
     * permissions, the catalog will not be created.
     * </pre>
     */
    public com.google.cloud.biglake.v1.IcebergCatalog createIcebergCatalog(
        com.google.cloud.biglake.v1.CreateIcebergCatalogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateIcebergCatalogMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Failover the catalog to a new primary replica region.
     * </pre>
     */
    public com.google.cloud.biglake.v1.FailoverIcebergCatalogResponse failoverIcebergCatalog(
        com.google.cloud.biglake.v1.FailoverIcebergCatalogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFailoverIcebergCatalogMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service IcebergCatalogService.
   *
   * <pre>
   * Iceberg Catalog Service API: this implements the open-source Iceberg REST
   * Catalog API.
   * See the API definition here:
   * https://github.com/apache/iceberg/blob/main/open-api/rest-catalog-open-api.yaml
   * The API is defined as OpenAPI 3.1.1 spec.
   * Currently we only support the following methods:
   * - GetConfig/GetIcebergCatalogConfig
   * - ListIcebergNamespaces
   * - CheckIcebergNamespaceExists
   * - GetIcebergNamespace
   * - CreateIcebergNamespace (only supports single level)
   * - DeleteIcebergNamespace
   * - UpdateIcebergNamespace properties
   * - ListTableIdentifiers
   * - CreateIcebergTable
   * - DeleteIcebergTable
   * - GetIcebergTable
   * - UpdateIcebergTable (CommitTable)
   * - LoadIcebergTableCredentials
   * - RegisterTable
   * Users are required to provided the `X-Goog-User-Project` header with the
   * project id or number which can be different from the bucket project id.
   * That project will be charged for the API calls and the calling user must have
   * access to that project. The caller must have `serviceusage.services.use`
   * permission on the project.
   * </pre>
   */
  public static final class IcebergCatalogServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<IcebergCatalogServiceBlockingStub> {
    private IcebergCatalogServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IcebergCatalogServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IcebergCatalogServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * GetIcebergCatalogConfig lists all catalog configuration settings. Most
     * importantly it contains the optional `endpoints` field which lists what
     * methods this catalog supports, since we are not supporting all the methods
     * right now.
     * It returns all the methods defined in this service (subject to project
     * config allowlisting).
     * This is not a GCP resource.
     * </pre>
     */
    public com.google.cloud.biglake.v1.IcebergCatalogConfig getIcebergCatalogConfig(
        com.google.cloud.biglake.v1.GetIcebergCatalogConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIcebergCatalogConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Iceberg namespaces in the catalog. We only support one level of
     * nesting for namespaces.
     * </pre>
     */
    public com.google.cloud.biglake.v1.ListIcebergNamespacesResponse listIcebergNamespaces(
        com.google.cloud.biglake.v1.ListIcebergNamespacesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListIcebergNamespacesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns 204 if the namespace exists, 404 otherwise.
     * </pre>
     */
    public com.google.protobuf.Empty checkIcebergNamespaceExists(
        com.google.cloud.biglake.v1.GetIcebergNamespaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckIcebergNamespaceExistsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an Iceberg namespace in the catalog (or checks if it exists, if the
     * method is HEAD).
     * </pre>
     */
    public com.google.cloud.biglake.v1.IcebergNamespace getIcebergNamespace(
        com.google.cloud.biglake.v1.GetIcebergNamespaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIcebergNamespaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a namespace in the catalog.
     * </pre>
     */
    public com.google.cloud.biglake.v1.IcebergNamespace createIcebergNamespace(
        com.google.cloud.biglake.v1.CreateIcebergNamespaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateIcebergNamespaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns 204, not 200 on success.
     * </pre>
     */
    public com.google.protobuf.Empty deleteIcebergNamespace(
        com.google.cloud.biglake.v1.DeleteIcebergNamespaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteIcebergNamespaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates namespace properties.
     * </pre>
     */
    public com.google.cloud.biglake.v1.UpdateIcebergNamespaceResponse updateIcebergNamespace(
        com.google.cloud.biglake.v1.UpdateIcebergNamespaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateIcebergNamespaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists table identifiers (not *tables*) in the namespace.
     * </pre>
     */
    public com.google.cloud.biglake.v1.ListIcebergTableIdentifiersResponse
        listIcebergTableIdentifiers(
            com.google.cloud.biglake.v1.ListIcebergTableIdentifiersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListIcebergTableIdentifiersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a table in the namespace.
     * </pre>
     */
    public com.google.api.HttpBody createIcebergTable(
        com.google.cloud.biglake.v1.CreateIcebergTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateIcebergTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns 204 if the table exists, 404 otherwise. This is a `HEAD` HTTP
     * method.
     * </pre>
     */
    public com.google.protobuf.Empty checkIcebergTableExists(
        com.google.cloud.biglake.v1.GetIcebergTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckIcebergTableExistsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a table in the namespace.
     * </pre>
     */
    public com.google.protobuf.Empty deleteIcebergTable(
        com.google.cloud.biglake.v1.DeleteIcebergTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteIcebergTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a table in the namespace.
     * </pre>
     */
    public com.google.api.HttpBody getIcebergTable(
        com.google.cloud.biglake.v1.GetIcebergTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIcebergTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Loads credentials for a table in the namespace.
     * </pre>
     */
    public com.google.cloud.biglake.v1.LoadIcebergTableCredentialsResponse
        loadIcebergTableCredentials(com.google.cloud.biglake.v1.GetIcebergTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLoadIcebergTableCredentialsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * This is CommitTable Iceberg API, which maps to `UpdateIcebergTable` in the
     * Google API nomenclature.
     * </pre>
     */
    public com.google.api.HttpBody updateIcebergTable(
        com.google.cloud.biglake.v1.UpdateIcebergTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateIcebergTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Register a table using given metadata file location.
     * </pre>
     */
    public com.google.api.HttpBody registerIcebergTable(
        com.google.cloud.biglake.v1.RegisterIcebergTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRegisterIcebergTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the Iceberg REST Catalog configuration options.
     * </pre>
     */
    public com.google.cloud.biglake.v1.IcebergCatalog getIcebergCatalog(
        com.google.cloud.biglake.v1.GetIcebergCatalogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIcebergCatalogMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the Iceberg REST Catalogs.
     * </pre>
     */
    public com.google.cloud.biglake.v1.ListIcebergCatalogsResponse listIcebergCatalogs(
        com.google.cloud.biglake.v1.ListIcebergCatalogsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListIcebergCatalogsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the Iceberg REST Catalog.
     * Delete does not delete a catalog that has contents -- at least one
     * namespace.
     * Delete is not supported for all catalog types.
     * </pre>
     */
    public com.google.protobuf.Empty deleteIcebergCatalog(
        com.google.cloud.biglake.v1.DeleteIcebergCatalogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteIcebergCatalogMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update the Iceberg REST Catalog configuration options.
     * </pre>
     */
    public com.google.cloud.biglake.v1.IcebergCatalog updateIcebergCatalog(
        com.google.cloud.biglake.v1.UpdateIcebergCatalogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateIcebergCatalogMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates the Iceberg REST Catalog.
     * Currently only supports Google Cloud Storage Bucket catalogs.
     * Google Cloud Storage Bucket catalog id is the bucket for which the
     * catalog is created (e.g. `my-catalog` for `gs://my-catalog`).
     * If the bucket does not exist, of the caller does not have bucket metadata
     * permissions, the catalog will not be created.
     * </pre>
     */
    public com.google.cloud.biglake.v1.IcebergCatalog createIcebergCatalog(
        com.google.cloud.biglake.v1.CreateIcebergCatalogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateIcebergCatalogMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Failover the catalog to a new primary replica region.
     * </pre>
     */
    public com.google.cloud.biglake.v1.FailoverIcebergCatalogResponse failoverIcebergCatalog(
        com.google.cloud.biglake.v1.FailoverIcebergCatalogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFailoverIcebergCatalogMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * IcebergCatalogService.
   *
   * <pre>
   * Iceberg Catalog Service API: this implements the open-source Iceberg REST
   * Catalog API.
   * See the API definition here:
   * https://github.com/apache/iceberg/blob/main/open-api/rest-catalog-open-api.yaml
   * The API is defined as OpenAPI 3.1.1 spec.
   * Currently we only support the following methods:
   * - GetConfig/GetIcebergCatalogConfig
   * - ListIcebergNamespaces
   * - CheckIcebergNamespaceExists
   * - GetIcebergNamespace
   * - CreateIcebergNamespace (only supports single level)
   * - DeleteIcebergNamespace
   * - UpdateIcebergNamespace properties
   * - ListTableIdentifiers
   * - CreateIcebergTable
   * - DeleteIcebergTable
   * - GetIcebergTable
   * - UpdateIcebergTable (CommitTable)
   * - LoadIcebergTableCredentials
   * - RegisterTable
   * Users are required to provided the `X-Goog-User-Project` header with the
   * project id or number which can be different from the bucket project id.
   * That project will be charged for the API calls and the calling user must have
   * access to that project. The caller must have `serviceusage.services.use`
   * permission on the project.
   * </pre>
   */
  public static final class IcebergCatalogServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<IcebergCatalogServiceFutureStub> {
    private IcebergCatalogServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IcebergCatalogServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IcebergCatalogServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * GetIcebergCatalogConfig lists all catalog configuration settings. Most
     * importantly it contains the optional `endpoints` field which lists what
     * methods this catalog supports, since we are not supporting all the methods
     * right now.
     * It returns all the methods defined in this service (subject to project
     * config allowlisting).
     * This is not a GCP resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.biglake.v1.IcebergCatalogConfig>
        getIcebergCatalogConfig(
            com.google.cloud.biglake.v1.GetIcebergCatalogConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIcebergCatalogConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Iceberg namespaces in the catalog. We only support one level of
     * nesting for namespaces.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.biglake.v1.ListIcebergNamespacesResponse>
        listIcebergNamespaces(com.google.cloud.biglake.v1.ListIcebergNamespacesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListIcebergNamespacesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns 204 if the namespace exists, 404 otherwise.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        checkIcebergNamespaceExists(
            com.google.cloud.biglake.v1.GetIcebergNamespaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckIcebergNamespaceExistsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an Iceberg namespace in the catalog (or checks if it exists, if the
     * method is HEAD).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.biglake.v1.IcebergNamespace>
        getIcebergNamespace(com.google.cloud.biglake.v1.GetIcebergNamespaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIcebergNamespaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a namespace in the catalog.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.biglake.v1.IcebergNamespace>
        createIcebergNamespace(com.google.cloud.biglake.v1.CreateIcebergNamespaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateIcebergNamespaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns 204, not 200 on success.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteIcebergNamespace(com.google.cloud.biglake.v1.DeleteIcebergNamespaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteIcebergNamespaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates namespace properties.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.biglake.v1.UpdateIcebergNamespaceResponse>
        updateIcebergNamespace(com.google.cloud.biglake.v1.UpdateIcebergNamespaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateIcebergNamespaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists table identifiers (not *tables*) in the namespace.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.biglake.v1.ListIcebergTableIdentifiersResponse>
        listIcebergTableIdentifiers(
            com.google.cloud.biglake.v1.ListIcebergTableIdentifiersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListIcebergTableIdentifiersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a table in the namespace.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.HttpBody>
        createIcebergTable(com.google.cloud.biglake.v1.CreateIcebergTableRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateIcebergTableMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns 204 if the table exists, 404 otherwise. This is a `HEAD` HTTP
     * method.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        checkIcebergTableExists(com.google.cloud.biglake.v1.GetIcebergTableRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckIcebergTableExistsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a table in the namespace.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteIcebergTable(com.google.cloud.biglake.v1.DeleteIcebergTableRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteIcebergTableMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a table in the namespace.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.HttpBody>
        getIcebergTable(com.google.cloud.biglake.v1.GetIcebergTableRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIcebergTableMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Loads credentials for a table in the namespace.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.biglake.v1.LoadIcebergTableCredentialsResponse>
        loadIcebergTableCredentials(com.google.cloud.biglake.v1.GetIcebergTableRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLoadIcebergTableCredentialsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * This is CommitTable Iceberg API, which maps to `UpdateIcebergTable` in the
     * Google API nomenclature.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.HttpBody>
        updateIcebergTable(com.google.cloud.biglake.v1.UpdateIcebergTableRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateIcebergTableMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Register a table using given metadata file location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.HttpBody>
        registerIcebergTable(com.google.cloud.biglake.v1.RegisterIcebergTableRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRegisterIcebergTableMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the Iceberg REST Catalog configuration options.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.biglake.v1.IcebergCatalog>
        getIcebergCatalog(com.google.cloud.biglake.v1.GetIcebergCatalogRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIcebergCatalogMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the Iceberg REST Catalogs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.biglake.v1.ListIcebergCatalogsResponse>
        listIcebergCatalogs(com.google.cloud.biglake.v1.ListIcebergCatalogsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListIcebergCatalogsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the Iceberg REST Catalog.
     * Delete does not delete a catalog that has contents -- at least one
     * namespace.
     * Delete is not supported for all catalog types.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteIcebergCatalog(com.google.cloud.biglake.v1.DeleteIcebergCatalogRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteIcebergCatalogMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update the Iceberg REST Catalog configuration options.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.biglake.v1.IcebergCatalog>
        updateIcebergCatalog(com.google.cloud.biglake.v1.UpdateIcebergCatalogRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateIcebergCatalogMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates the Iceberg REST Catalog.
     * Currently only supports Google Cloud Storage Bucket catalogs.
     * Google Cloud Storage Bucket catalog id is the bucket for which the
     * catalog is created (e.g. `my-catalog` for `gs://my-catalog`).
     * If the bucket does not exist, of the caller does not have bucket metadata
     * permissions, the catalog will not be created.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.biglake.v1.IcebergCatalog>
        createIcebergCatalog(com.google.cloud.biglake.v1.CreateIcebergCatalogRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateIcebergCatalogMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Failover the catalog to a new primary replica region.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.biglake.v1.FailoverIcebergCatalogResponse>
        failoverIcebergCatalog(com.google.cloud.biglake.v1.FailoverIcebergCatalogRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFailoverIcebergCatalogMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ICEBERG_CATALOG_CONFIG = 0;
  private static final int METHODID_LIST_ICEBERG_NAMESPACES = 1;
  private static final int METHODID_CHECK_ICEBERG_NAMESPACE_EXISTS = 2;
  private static final int METHODID_GET_ICEBERG_NAMESPACE = 3;
  private static final int METHODID_CREATE_ICEBERG_NAMESPACE = 4;
  private static final int METHODID_DELETE_ICEBERG_NAMESPACE = 5;
  private static final int METHODID_UPDATE_ICEBERG_NAMESPACE = 6;
  private static final int METHODID_LIST_ICEBERG_TABLE_IDENTIFIERS = 7;
  private static final int METHODID_CREATE_ICEBERG_TABLE = 8;
  private static final int METHODID_CHECK_ICEBERG_TABLE_EXISTS = 9;
  private static final int METHODID_DELETE_ICEBERG_TABLE = 10;
  private static final int METHODID_GET_ICEBERG_TABLE = 11;
  private static final int METHODID_LOAD_ICEBERG_TABLE_CREDENTIALS = 12;
  private static final int METHODID_UPDATE_ICEBERG_TABLE = 13;
  private static final int METHODID_REGISTER_ICEBERG_TABLE = 14;
  private static final int METHODID_GET_ICEBERG_CATALOG = 15;
  private static final int METHODID_LIST_ICEBERG_CATALOGS = 16;
  private static final int METHODID_DELETE_ICEBERG_CATALOG = 17;
  private static final int METHODID_UPDATE_ICEBERG_CATALOG = 18;
  private static final int METHODID_CREATE_ICEBERG_CATALOG = 19;
  private static final int METHODID_FAILOVER_ICEBERG_CATALOG = 20;

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
        case METHODID_GET_ICEBERG_CATALOG_CONFIG:
          serviceImpl.getIcebergCatalogConfig(
              (com.google.cloud.biglake.v1.GetIcebergCatalogConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.biglake.v1.IcebergCatalogConfig>)
                  responseObserver);
          break;
        case METHODID_LIST_ICEBERG_NAMESPACES:
          serviceImpl.listIcebergNamespaces(
              (com.google.cloud.biglake.v1.ListIcebergNamespacesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.biglake.v1.ListIcebergNamespacesResponse>)
                  responseObserver);
          break;
        case METHODID_CHECK_ICEBERG_NAMESPACE_EXISTS:
          serviceImpl.checkIcebergNamespaceExists(
              (com.google.cloud.biglake.v1.GetIcebergNamespaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_ICEBERG_NAMESPACE:
          serviceImpl.getIcebergNamespace(
              (com.google.cloud.biglake.v1.GetIcebergNamespaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.biglake.v1.IcebergNamespace>)
                  responseObserver);
          break;
        case METHODID_CREATE_ICEBERG_NAMESPACE:
          serviceImpl.createIcebergNamespace(
              (com.google.cloud.biglake.v1.CreateIcebergNamespaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.biglake.v1.IcebergNamespace>)
                  responseObserver);
          break;
        case METHODID_DELETE_ICEBERG_NAMESPACE:
          serviceImpl.deleteIcebergNamespace(
              (com.google.cloud.biglake.v1.DeleteIcebergNamespaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_ICEBERG_NAMESPACE:
          serviceImpl.updateIcebergNamespace(
              (com.google.cloud.biglake.v1.UpdateIcebergNamespaceRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.biglake.v1.UpdateIcebergNamespaceResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_ICEBERG_TABLE_IDENTIFIERS:
          serviceImpl.listIcebergTableIdentifiers(
              (com.google.cloud.biglake.v1.ListIcebergTableIdentifiersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.biglake.v1.ListIcebergTableIdentifiersResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_ICEBERG_TABLE:
          serviceImpl.createIcebergTable(
              (com.google.cloud.biglake.v1.CreateIcebergTableRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.HttpBody>) responseObserver);
          break;
        case METHODID_CHECK_ICEBERG_TABLE_EXISTS:
          serviceImpl.checkIcebergTableExists(
              (com.google.cloud.biglake.v1.GetIcebergTableRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_DELETE_ICEBERG_TABLE:
          serviceImpl.deleteIcebergTable(
              (com.google.cloud.biglake.v1.DeleteIcebergTableRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_ICEBERG_TABLE:
          serviceImpl.getIcebergTable(
              (com.google.cloud.biglake.v1.GetIcebergTableRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.HttpBody>) responseObserver);
          break;
        case METHODID_LOAD_ICEBERG_TABLE_CREDENTIALS:
          serviceImpl.loadIcebergTableCredentials(
              (com.google.cloud.biglake.v1.GetIcebergTableRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.biglake.v1.LoadIcebergTableCredentialsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ICEBERG_TABLE:
          serviceImpl.updateIcebergTable(
              (com.google.cloud.biglake.v1.UpdateIcebergTableRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.HttpBody>) responseObserver);
          break;
        case METHODID_REGISTER_ICEBERG_TABLE:
          serviceImpl.registerIcebergTable(
              (com.google.cloud.biglake.v1.RegisterIcebergTableRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.HttpBody>) responseObserver);
          break;
        case METHODID_GET_ICEBERG_CATALOG:
          serviceImpl.getIcebergCatalog(
              (com.google.cloud.biglake.v1.GetIcebergCatalogRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.biglake.v1.IcebergCatalog>)
                  responseObserver);
          break;
        case METHODID_LIST_ICEBERG_CATALOGS:
          serviceImpl.listIcebergCatalogs(
              (com.google.cloud.biglake.v1.ListIcebergCatalogsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.biglake.v1.ListIcebergCatalogsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_ICEBERG_CATALOG:
          serviceImpl.deleteIcebergCatalog(
              (com.google.cloud.biglake.v1.DeleteIcebergCatalogRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_ICEBERG_CATALOG:
          serviceImpl.updateIcebergCatalog(
              (com.google.cloud.biglake.v1.UpdateIcebergCatalogRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.biglake.v1.IcebergCatalog>)
                  responseObserver);
          break;
        case METHODID_CREATE_ICEBERG_CATALOG:
          serviceImpl.createIcebergCatalog(
              (com.google.cloud.biglake.v1.CreateIcebergCatalogRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.biglake.v1.IcebergCatalog>)
                  responseObserver);
          break;
        case METHODID_FAILOVER_ICEBERG_CATALOG:
          serviceImpl.failoverIcebergCatalog(
              (com.google.cloud.biglake.v1.FailoverIcebergCatalogRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.biglake.v1.FailoverIcebergCatalogResponse>)
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
            getGetIcebergCatalogConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.v1.GetIcebergCatalogConfigRequest,
                    com.google.cloud.biglake.v1.IcebergCatalogConfig>(
                    service, METHODID_GET_ICEBERG_CATALOG_CONFIG)))
        .addMethod(
            getListIcebergNamespacesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.v1.ListIcebergNamespacesRequest,
                    com.google.cloud.biglake.v1.ListIcebergNamespacesResponse>(
                    service, METHODID_LIST_ICEBERG_NAMESPACES)))
        .addMethod(
            getCheckIcebergNamespaceExistsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.v1.GetIcebergNamespaceRequest,
                    com.google.protobuf.Empty>(service, METHODID_CHECK_ICEBERG_NAMESPACE_EXISTS)))
        .addMethod(
            getGetIcebergNamespaceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.v1.GetIcebergNamespaceRequest,
                    com.google.cloud.biglake.v1.IcebergNamespace>(
                    service, METHODID_GET_ICEBERG_NAMESPACE)))
        .addMethod(
            getCreateIcebergNamespaceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.v1.CreateIcebergNamespaceRequest,
                    com.google.cloud.biglake.v1.IcebergNamespace>(
                    service, METHODID_CREATE_ICEBERG_NAMESPACE)))
        .addMethod(
            getDeleteIcebergNamespaceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.v1.DeleteIcebergNamespaceRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_ICEBERG_NAMESPACE)))
        .addMethod(
            getUpdateIcebergNamespaceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.v1.UpdateIcebergNamespaceRequest,
                    com.google.cloud.biglake.v1.UpdateIcebergNamespaceResponse>(
                    service, METHODID_UPDATE_ICEBERG_NAMESPACE)))
        .addMethod(
            getListIcebergTableIdentifiersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.v1.ListIcebergTableIdentifiersRequest,
                    com.google.cloud.biglake.v1.ListIcebergTableIdentifiersResponse>(
                    service, METHODID_LIST_ICEBERG_TABLE_IDENTIFIERS)))
        .addMethod(
            getCreateIcebergTableMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.v1.CreateIcebergTableRequest, com.google.api.HttpBody>(
                    service, METHODID_CREATE_ICEBERG_TABLE)))
        .addMethod(
            getCheckIcebergTableExistsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.v1.GetIcebergTableRequest, com.google.protobuf.Empty>(
                    service, METHODID_CHECK_ICEBERG_TABLE_EXISTS)))
        .addMethod(
            getDeleteIcebergTableMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.v1.DeleteIcebergTableRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_ICEBERG_TABLE)))
        .addMethod(
            getGetIcebergTableMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.v1.GetIcebergTableRequest, com.google.api.HttpBody>(
                    service, METHODID_GET_ICEBERG_TABLE)))
        .addMethod(
            getLoadIcebergTableCredentialsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.v1.GetIcebergTableRequest,
                    com.google.cloud.biglake.v1.LoadIcebergTableCredentialsResponse>(
                    service, METHODID_LOAD_ICEBERG_TABLE_CREDENTIALS)))
        .addMethod(
            getUpdateIcebergTableMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.v1.UpdateIcebergTableRequest, com.google.api.HttpBody>(
                    service, METHODID_UPDATE_ICEBERG_TABLE)))
        .addMethod(
            getRegisterIcebergTableMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.v1.RegisterIcebergTableRequest,
                    com.google.api.HttpBody>(service, METHODID_REGISTER_ICEBERG_TABLE)))
        .addMethod(
            getGetIcebergCatalogMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.v1.GetIcebergCatalogRequest,
                    com.google.cloud.biglake.v1.IcebergCatalog>(
                    service, METHODID_GET_ICEBERG_CATALOG)))
        .addMethod(
            getListIcebergCatalogsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.v1.ListIcebergCatalogsRequest,
                    com.google.cloud.biglake.v1.ListIcebergCatalogsResponse>(
                    service, METHODID_LIST_ICEBERG_CATALOGS)))
        .addMethod(
            getDeleteIcebergCatalogMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.v1.DeleteIcebergCatalogRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_ICEBERG_CATALOG)))
        .addMethod(
            getUpdateIcebergCatalogMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.v1.UpdateIcebergCatalogRequest,
                    com.google.cloud.biglake.v1.IcebergCatalog>(
                    service, METHODID_UPDATE_ICEBERG_CATALOG)))
        .addMethod(
            getCreateIcebergCatalogMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.v1.CreateIcebergCatalogRequest,
                    com.google.cloud.biglake.v1.IcebergCatalog>(
                    service, METHODID_CREATE_ICEBERG_CATALOG)))
        .addMethod(
            getFailoverIcebergCatalogMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.v1.FailoverIcebergCatalogRequest,
                    com.google.cloud.biglake.v1.FailoverIcebergCatalogResponse>(
                    service, METHODID_FAILOVER_ICEBERG_CATALOG)))
        .build();
  }

  private abstract static class IcebergCatalogServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    IcebergCatalogServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.biglake.v1.IcebergRestCatalogProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("IcebergCatalogService");
    }
  }

  private static final class IcebergCatalogServiceFileDescriptorSupplier
      extends IcebergCatalogServiceBaseDescriptorSupplier {
    IcebergCatalogServiceFileDescriptorSupplier() {}
  }

  private static final class IcebergCatalogServiceMethodDescriptorSupplier
      extends IcebergCatalogServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    IcebergCatalogServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (IcebergCatalogServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new IcebergCatalogServiceFileDescriptorSupplier())
                      .addMethod(getGetIcebergCatalogConfigMethod())
                      .addMethod(getListIcebergNamespacesMethod())
                      .addMethod(getCheckIcebergNamespaceExistsMethod())
                      .addMethod(getGetIcebergNamespaceMethod())
                      .addMethod(getCreateIcebergNamespaceMethod())
                      .addMethod(getDeleteIcebergNamespaceMethod())
                      .addMethod(getUpdateIcebergNamespaceMethod())
                      .addMethod(getListIcebergTableIdentifiersMethod())
                      .addMethod(getCreateIcebergTableMethod())
                      .addMethod(getCheckIcebergTableExistsMethod())
                      .addMethod(getDeleteIcebergTableMethod())
                      .addMethod(getGetIcebergTableMethod())
                      .addMethod(getLoadIcebergTableCredentialsMethod())
                      .addMethod(getUpdateIcebergTableMethod())
                      .addMethod(getRegisterIcebergTableMethod())
                      .addMethod(getGetIcebergCatalogMethod())
                      .addMethod(getListIcebergCatalogsMethod())
                      .addMethod(getDeleteIcebergCatalogMethod())
                      .addMethod(getUpdateIcebergCatalogMethod())
                      .addMethod(getCreateIcebergCatalogMethod())
                      .addMethod(getFailoverIcebergCatalogMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
