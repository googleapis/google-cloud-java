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
package com.google.cloud.apihub.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * This service provides all methods related to the API hub.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/apihub/v1/apihub_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ApiHubGrpc {

  private ApiHubGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.apihub.v1.ApiHub";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.CreateApiRequest, com.google.cloud.apihub.v1.Api>
      getCreateApiMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateApi",
      requestType = com.google.cloud.apihub.v1.CreateApiRequest.class,
      responseType = com.google.cloud.apihub.v1.Api.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.CreateApiRequest, com.google.cloud.apihub.v1.Api>
      getCreateApiMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.CreateApiRequest, com.google.cloud.apihub.v1.Api>
        getCreateApiMethod;
    if ((getCreateApiMethod = ApiHubGrpc.getCreateApiMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getCreateApiMethod = ApiHubGrpc.getCreateApiMethod) == null) {
          ApiHubGrpc.getCreateApiMethod =
              getCreateApiMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.CreateApiRequest, com.google.cloud.apihub.v1.Api>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateApi"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.CreateApiRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.Api.getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("CreateApi"))
                      .build();
        }
      }
    }
    return getCreateApiMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.GetApiRequest, com.google.cloud.apihub.v1.Api>
      getGetApiMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetApi",
      requestType = com.google.cloud.apihub.v1.GetApiRequest.class,
      responseType = com.google.cloud.apihub.v1.Api.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.GetApiRequest, com.google.cloud.apihub.v1.Api>
      getGetApiMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.GetApiRequest, com.google.cloud.apihub.v1.Api>
        getGetApiMethod;
    if ((getGetApiMethod = ApiHubGrpc.getGetApiMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getGetApiMethod = ApiHubGrpc.getGetApiMethod) == null) {
          ApiHubGrpc.getGetApiMethod =
              getGetApiMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.GetApiRequest, com.google.cloud.apihub.v1.Api>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetApi"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.GetApiRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.Api.getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("GetApi"))
                      .build();
        }
      }
    }
    return getGetApiMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.ListApisRequest, com.google.cloud.apihub.v1.ListApisResponse>
      getListApisMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListApis",
      requestType = com.google.cloud.apihub.v1.ListApisRequest.class,
      responseType = com.google.cloud.apihub.v1.ListApisResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.ListApisRequest, com.google.cloud.apihub.v1.ListApisResponse>
      getListApisMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.ListApisRequest, com.google.cloud.apihub.v1.ListApisResponse>
        getListApisMethod;
    if ((getListApisMethod = ApiHubGrpc.getListApisMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getListApisMethod = ApiHubGrpc.getListApisMethod) == null) {
          ApiHubGrpc.getListApisMethod =
              getListApisMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.ListApisRequest,
                          com.google.cloud.apihub.v1.ListApisResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListApis"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.ListApisRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.ListApisResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("ListApis"))
                      .build();
        }
      }
    }
    return getListApisMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.UpdateApiRequest, com.google.cloud.apihub.v1.Api>
      getUpdateApiMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateApi",
      requestType = com.google.cloud.apihub.v1.UpdateApiRequest.class,
      responseType = com.google.cloud.apihub.v1.Api.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.UpdateApiRequest, com.google.cloud.apihub.v1.Api>
      getUpdateApiMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.UpdateApiRequest, com.google.cloud.apihub.v1.Api>
        getUpdateApiMethod;
    if ((getUpdateApiMethod = ApiHubGrpc.getUpdateApiMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getUpdateApiMethod = ApiHubGrpc.getUpdateApiMethod) == null) {
          ApiHubGrpc.getUpdateApiMethod =
              getUpdateApiMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.UpdateApiRequest, com.google.cloud.apihub.v1.Api>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateApi"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.UpdateApiRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.Api.getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("UpdateApi"))
                      .build();
        }
      }
    }
    return getUpdateApiMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.DeleteApiRequest, com.google.protobuf.Empty>
      getDeleteApiMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteApi",
      requestType = com.google.cloud.apihub.v1.DeleteApiRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.DeleteApiRequest, com.google.protobuf.Empty>
      getDeleteApiMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apihub.v1.DeleteApiRequest, com.google.protobuf.Empty>
        getDeleteApiMethod;
    if ((getDeleteApiMethod = ApiHubGrpc.getDeleteApiMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getDeleteApiMethod = ApiHubGrpc.getDeleteApiMethod) == null) {
          ApiHubGrpc.getDeleteApiMethod =
              getDeleteApiMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.DeleteApiRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteApi"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.DeleteApiRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("DeleteApi"))
                      .build();
        }
      }
    }
    return getDeleteApiMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.CreateVersionRequest, com.google.cloud.apihub.v1.Version>
      getCreateVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateVersion",
      requestType = com.google.cloud.apihub.v1.CreateVersionRequest.class,
      responseType = com.google.cloud.apihub.v1.Version.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.CreateVersionRequest, com.google.cloud.apihub.v1.Version>
      getCreateVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.CreateVersionRequest, com.google.cloud.apihub.v1.Version>
        getCreateVersionMethod;
    if ((getCreateVersionMethod = ApiHubGrpc.getCreateVersionMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getCreateVersionMethod = ApiHubGrpc.getCreateVersionMethod) == null) {
          ApiHubGrpc.getCreateVersionMethod =
              getCreateVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.CreateVersionRequest,
                          com.google.cloud.apihub.v1.Version>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.CreateVersionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.Version.getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("CreateVersion"))
                      .build();
        }
      }
    }
    return getCreateVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.GetVersionRequest, com.google.cloud.apihub.v1.Version>
      getGetVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetVersion",
      requestType = com.google.cloud.apihub.v1.GetVersionRequest.class,
      responseType = com.google.cloud.apihub.v1.Version.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.GetVersionRequest, com.google.cloud.apihub.v1.Version>
      getGetVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.GetVersionRequest, com.google.cloud.apihub.v1.Version>
        getGetVersionMethod;
    if ((getGetVersionMethod = ApiHubGrpc.getGetVersionMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getGetVersionMethod = ApiHubGrpc.getGetVersionMethod) == null) {
          ApiHubGrpc.getGetVersionMethod =
              getGetVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.GetVersionRequest,
                          com.google.cloud.apihub.v1.Version>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.GetVersionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.Version.getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("GetVersion"))
                      .build();
        }
      }
    }
    return getGetVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.ListVersionsRequest,
          com.google.cloud.apihub.v1.ListVersionsResponse>
      getListVersionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListVersions",
      requestType = com.google.cloud.apihub.v1.ListVersionsRequest.class,
      responseType = com.google.cloud.apihub.v1.ListVersionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.ListVersionsRequest,
          com.google.cloud.apihub.v1.ListVersionsResponse>
      getListVersionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.ListVersionsRequest,
            com.google.cloud.apihub.v1.ListVersionsResponse>
        getListVersionsMethod;
    if ((getListVersionsMethod = ApiHubGrpc.getListVersionsMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getListVersionsMethod = ApiHubGrpc.getListVersionsMethod) == null) {
          ApiHubGrpc.getListVersionsMethod =
              getListVersionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.ListVersionsRequest,
                          com.google.cloud.apihub.v1.ListVersionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListVersions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.ListVersionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.ListVersionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("ListVersions"))
                      .build();
        }
      }
    }
    return getListVersionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.UpdateVersionRequest, com.google.cloud.apihub.v1.Version>
      getUpdateVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateVersion",
      requestType = com.google.cloud.apihub.v1.UpdateVersionRequest.class,
      responseType = com.google.cloud.apihub.v1.Version.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.UpdateVersionRequest, com.google.cloud.apihub.v1.Version>
      getUpdateVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.UpdateVersionRequest, com.google.cloud.apihub.v1.Version>
        getUpdateVersionMethod;
    if ((getUpdateVersionMethod = ApiHubGrpc.getUpdateVersionMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getUpdateVersionMethod = ApiHubGrpc.getUpdateVersionMethod) == null) {
          ApiHubGrpc.getUpdateVersionMethod =
              getUpdateVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.UpdateVersionRequest,
                          com.google.cloud.apihub.v1.Version>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.UpdateVersionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.Version.getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("UpdateVersion"))
                      .build();
        }
      }
    }
    return getUpdateVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.DeleteVersionRequest, com.google.protobuf.Empty>
      getDeleteVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteVersion",
      requestType = com.google.cloud.apihub.v1.DeleteVersionRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.DeleteVersionRequest, com.google.protobuf.Empty>
      getDeleteVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.DeleteVersionRequest, com.google.protobuf.Empty>
        getDeleteVersionMethod;
    if ((getDeleteVersionMethod = ApiHubGrpc.getDeleteVersionMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getDeleteVersionMethod = ApiHubGrpc.getDeleteVersionMethod) == null) {
          ApiHubGrpc.getDeleteVersionMethod =
              getDeleteVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.DeleteVersionRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.DeleteVersionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("DeleteVersion"))
                      .build();
        }
      }
    }
    return getDeleteVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.CreateSpecRequest, com.google.cloud.apihub.v1.Spec>
      getCreateSpecMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSpec",
      requestType = com.google.cloud.apihub.v1.CreateSpecRequest.class,
      responseType = com.google.cloud.apihub.v1.Spec.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.CreateSpecRequest, com.google.cloud.apihub.v1.Spec>
      getCreateSpecMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.CreateSpecRequest, com.google.cloud.apihub.v1.Spec>
        getCreateSpecMethod;
    if ((getCreateSpecMethod = ApiHubGrpc.getCreateSpecMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getCreateSpecMethod = ApiHubGrpc.getCreateSpecMethod) == null) {
          ApiHubGrpc.getCreateSpecMethod =
              getCreateSpecMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.CreateSpecRequest,
                          com.google.cloud.apihub.v1.Spec>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSpec"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.CreateSpecRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.Spec.getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("CreateSpec"))
                      .build();
        }
      }
    }
    return getCreateSpecMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.GetSpecRequest, com.google.cloud.apihub.v1.Spec>
      getGetSpecMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSpec",
      requestType = com.google.cloud.apihub.v1.GetSpecRequest.class,
      responseType = com.google.cloud.apihub.v1.Spec.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.GetSpecRequest, com.google.cloud.apihub.v1.Spec>
      getGetSpecMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.GetSpecRequest, com.google.cloud.apihub.v1.Spec>
        getGetSpecMethod;
    if ((getGetSpecMethod = ApiHubGrpc.getGetSpecMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getGetSpecMethod = ApiHubGrpc.getGetSpecMethod) == null) {
          ApiHubGrpc.getGetSpecMethod =
              getGetSpecMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.GetSpecRequest, com.google.cloud.apihub.v1.Spec>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSpec"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.GetSpecRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.Spec.getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("GetSpec"))
                      .build();
        }
      }
    }
    return getGetSpecMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.GetSpecContentsRequest,
          com.google.cloud.apihub.v1.SpecContents>
      getGetSpecContentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSpecContents",
      requestType = com.google.cloud.apihub.v1.GetSpecContentsRequest.class,
      responseType = com.google.cloud.apihub.v1.SpecContents.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.GetSpecContentsRequest,
          com.google.cloud.apihub.v1.SpecContents>
      getGetSpecContentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.GetSpecContentsRequest,
            com.google.cloud.apihub.v1.SpecContents>
        getGetSpecContentsMethod;
    if ((getGetSpecContentsMethod = ApiHubGrpc.getGetSpecContentsMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getGetSpecContentsMethod = ApiHubGrpc.getGetSpecContentsMethod) == null) {
          ApiHubGrpc.getGetSpecContentsMethod =
              getGetSpecContentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.GetSpecContentsRequest,
                          com.google.cloud.apihub.v1.SpecContents>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSpecContents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.GetSpecContentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.SpecContents.getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("GetSpecContents"))
                      .build();
        }
      }
    }
    return getGetSpecContentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.ListSpecsRequest, com.google.cloud.apihub.v1.ListSpecsResponse>
      getListSpecsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSpecs",
      requestType = com.google.cloud.apihub.v1.ListSpecsRequest.class,
      responseType = com.google.cloud.apihub.v1.ListSpecsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.ListSpecsRequest, com.google.cloud.apihub.v1.ListSpecsResponse>
      getListSpecsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.ListSpecsRequest,
            com.google.cloud.apihub.v1.ListSpecsResponse>
        getListSpecsMethod;
    if ((getListSpecsMethod = ApiHubGrpc.getListSpecsMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getListSpecsMethod = ApiHubGrpc.getListSpecsMethod) == null) {
          ApiHubGrpc.getListSpecsMethod =
              getListSpecsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.ListSpecsRequest,
                          com.google.cloud.apihub.v1.ListSpecsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSpecs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.ListSpecsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.ListSpecsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("ListSpecs"))
                      .build();
        }
      }
    }
    return getListSpecsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.UpdateSpecRequest, com.google.cloud.apihub.v1.Spec>
      getUpdateSpecMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSpec",
      requestType = com.google.cloud.apihub.v1.UpdateSpecRequest.class,
      responseType = com.google.cloud.apihub.v1.Spec.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.UpdateSpecRequest, com.google.cloud.apihub.v1.Spec>
      getUpdateSpecMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.UpdateSpecRequest, com.google.cloud.apihub.v1.Spec>
        getUpdateSpecMethod;
    if ((getUpdateSpecMethod = ApiHubGrpc.getUpdateSpecMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getUpdateSpecMethod = ApiHubGrpc.getUpdateSpecMethod) == null) {
          ApiHubGrpc.getUpdateSpecMethod =
              getUpdateSpecMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.UpdateSpecRequest,
                          com.google.cloud.apihub.v1.Spec>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSpec"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.UpdateSpecRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.Spec.getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("UpdateSpec"))
                      .build();
        }
      }
    }
    return getUpdateSpecMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.DeleteSpecRequest, com.google.protobuf.Empty>
      getDeleteSpecMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSpec",
      requestType = com.google.cloud.apihub.v1.DeleteSpecRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.DeleteSpecRequest, com.google.protobuf.Empty>
      getDeleteSpecMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.DeleteSpecRequest, com.google.protobuf.Empty>
        getDeleteSpecMethod;
    if ((getDeleteSpecMethod = ApiHubGrpc.getDeleteSpecMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getDeleteSpecMethod = ApiHubGrpc.getDeleteSpecMethod) == null) {
          ApiHubGrpc.getDeleteSpecMethod =
              getDeleteSpecMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.DeleteSpecRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSpec"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.DeleteSpecRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("DeleteSpec"))
                      .build();
        }
      }
    }
    return getDeleteSpecMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.GetApiOperationRequest,
          com.google.cloud.apihub.v1.ApiOperation>
      getGetApiOperationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetApiOperation",
      requestType = com.google.cloud.apihub.v1.GetApiOperationRequest.class,
      responseType = com.google.cloud.apihub.v1.ApiOperation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.GetApiOperationRequest,
          com.google.cloud.apihub.v1.ApiOperation>
      getGetApiOperationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.GetApiOperationRequest,
            com.google.cloud.apihub.v1.ApiOperation>
        getGetApiOperationMethod;
    if ((getGetApiOperationMethod = ApiHubGrpc.getGetApiOperationMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getGetApiOperationMethod = ApiHubGrpc.getGetApiOperationMethod) == null) {
          ApiHubGrpc.getGetApiOperationMethod =
              getGetApiOperationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.GetApiOperationRequest,
                          com.google.cloud.apihub.v1.ApiOperation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetApiOperation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.GetApiOperationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.ApiOperation.getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("GetApiOperation"))
                      .build();
        }
      }
    }
    return getGetApiOperationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.ListApiOperationsRequest,
          com.google.cloud.apihub.v1.ListApiOperationsResponse>
      getListApiOperationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListApiOperations",
      requestType = com.google.cloud.apihub.v1.ListApiOperationsRequest.class,
      responseType = com.google.cloud.apihub.v1.ListApiOperationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.ListApiOperationsRequest,
          com.google.cloud.apihub.v1.ListApiOperationsResponse>
      getListApiOperationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.ListApiOperationsRequest,
            com.google.cloud.apihub.v1.ListApiOperationsResponse>
        getListApiOperationsMethod;
    if ((getListApiOperationsMethod = ApiHubGrpc.getListApiOperationsMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getListApiOperationsMethod = ApiHubGrpc.getListApiOperationsMethod) == null) {
          ApiHubGrpc.getListApiOperationsMethod =
              getListApiOperationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.ListApiOperationsRequest,
                          com.google.cloud.apihub.v1.ListApiOperationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListApiOperations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.ListApiOperationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.ListApiOperationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("ListApiOperations"))
                      .build();
        }
      }
    }
    return getListApiOperationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.GetDefinitionRequest, com.google.cloud.apihub.v1.Definition>
      getGetDefinitionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDefinition",
      requestType = com.google.cloud.apihub.v1.GetDefinitionRequest.class,
      responseType = com.google.cloud.apihub.v1.Definition.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.GetDefinitionRequest, com.google.cloud.apihub.v1.Definition>
      getGetDefinitionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.GetDefinitionRequest, com.google.cloud.apihub.v1.Definition>
        getGetDefinitionMethod;
    if ((getGetDefinitionMethod = ApiHubGrpc.getGetDefinitionMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getGetDefinitionMethod = ApiHubGrpc.getGetDefinitionMethod) == null) {
          ApiHubGrpc.getGetDefinitionMethod =
              getGetDefinitionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.GetDefinitionRequest,
                          com.google.cloud.apihub.v1.Definition>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDefinition"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.GetDefinitionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.Definition.getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("GetDefinition"))
                      .build();
        }
      }
    }
    return getGetDefinitionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.CreateDeploymentRequest, com.google.cloud.apihub.v1.Deployment>
      getCreateDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDeployment",
      requestType = com.google.cloud.apihub.v1.CreateDeploymentRequest.class,
      responseType = com.google.cloud.apihub.v1.Deployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.CreateDeploymentRequest, com.google.cloud.apihub.v1.Deployment>
      getCreateDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.CreateDeploymentRequest,
            com.google.cloud.apihub.v1.Deployment>
        getCreateDeploymentMethod;
    if ((getCreateDeploymentMethod = ApiHubGrpc.getCreateDeploymentMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getCreateDeploymentMethod = ApiHubGrpc.getCreateDeploymentMethod) == null) {
          ApiHubGrpc.getCreateDeploymentMethod =
              getCreateDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.CreateDeploymentRequest,
                          com.google.cloud.apihub.v1.Deployment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.CreateDeploymentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.Deployment.getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("CreateDeployment"))
                      .build();
        }
      }
    }
    return getCreateDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.GetDeploymentRequest, com.google.cloud.apihub.v1.Deployment>
      getGetDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDeployment",
      requestType = com.google.cloud.apihub.v1.GetDeploymentRequest.class,
      responseType = com.google.cloud.apihub.v1.Deployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.GetDeploymentRequest, com.google.cloud.apihub.v1.Deployment>
      getGetDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.GetDeploymentRequest, com.google.cloud.apihub.v1.Deployment>
        getGetDeploymentMethod;
    if ((getGetDeploymentMethod = ApiHubGrpc.getGetDeploymentMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getGetDeploymentMethod = ApiHubGrpc.getGetDeploymentMethod) == null) {
          ApiHubGrpc.getGetDeploymentMethod =
              getGetDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.GetDeploymentRequest,
                          com.google.cloud.apihub.v1.Deployment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.GetDeploymentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.Deployment.getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("GetDeployment"))
                      .build();
        }
      }
    }
    return getGetDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.ListDeploymentsRequest,
          com.google.cloud.apihub.v1.ListDeploymentsResponse>
      getListDeploymentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDeployments",
      requestType = com.google.cloud.apihub.v1.ListDeploymentsRequest.class,
      responseType = com.google.cloud.apihub.v1.ListDeploymentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.ListDeploymentsRequest,
          com.google.cloud.apihub.v1.ListDeploymentsResponse>
      getListDeploymentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.ListDeploymentsRequest,
            com.google.cloud.apihub.v1.ListDeploymentsResponse>
        getListDeploymentsMethod;
    if ((getListDeploymentsMethod = ApiHubGrpc.getListDeploymentsMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getListDeploymentsMethod = ApiHubGrpc.getListDeploymentsMethod) == null) {
          ApiHubGrpc.getListDeploymentsMethod =
              getListDeploymentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.ListDeploymentsRequest,
                          com.google.cloud.apihub.v1.ListDeploymentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDeployments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.ListDeploymentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.ListDeploymentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("ListDeployments"))
                      .build();
        }
      }
    }
    return getListDeploymentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.UpdateDeploymentRequest, com.google.cloud.apihub.v1.Deployment>
      getUpdateDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDeployment",
      requestType = com.google.cloud.apihub.v1.UpdateDeploymentRequest.class,
      responseType = com.google.cloud.apihub.v1.Deployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.UpdateDeploymentRequest, com.google.cloud.apihub.v1.Deployment>
      getUpdateDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.UpdateDeploymentRequest,
            com.google.cloud.apihub.v1.Deployment>
        getUpdateDeploymentMethod;
    if ((getUpdateDeploymentMethod = ApiHubGrpc.getUpdateDeploymentMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getUpdateDeploymentMethod = ApiHubGrpc.getUpdateDeploymentMethod) == null) {
          ApiHubGrpc.getUpdateDeploymentMethod =
              getUpdateDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.UpdateDeploymentRequest,
                          com.google.cloud.apihub.v1.Deployment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.UpdateDeploymentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.Deployment.getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("UpdateDeployment"))
                      .build();
        }
      }
    }
    return getUpdateDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.DeleteDeploymentRequest, com.google.protobuf.Empty>
      getDeleteDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDeployment",
      requestType = com.google.cloud.apihub.v1.DeleteDeploymentRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.DeleteDeploymentRequest, com.google.protobuf.Empty>
      getDeleteDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.DeleteDeploymentRequest, com.google.protobuf.Empty>
        getDeleteDeploymentMethod;
    if ((getDeleteDeploymentMethod = ApiHubGrpc.getDeleteDeploymentMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getDeleteDeploymentMethod = ApiHubGrpc.getDeleteDeploymentMethod) == null) {
          ApiHubGrpc.getDeleteDeploymentMethod =
              getDeleteDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.DeleteDeploymentRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.DeleteDeploymentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("DeleteDeployment"))
                      .build();
        }
      }
    }
    return getDeleteDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.CreateAttributeRequest, com.google.cloud.apihub.v1.Attribute>
      getCreateAttributeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAttribute",
      requestType = com.google.cloud.apihub.v1.CreateAttributeRequest.class,
      responseType = com.google.cloud.apihub.v1.Attribute.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.CreateAttributeRequest, com.google.cloud.apihub.v1.Attribute>
      getCreateAttributeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.CreateAttributeRequest, com.google.cloud.apihub.v1.Attribute>
        getCreateAttributeMethod;
    if ((getCreateAttributeMethod = ApiHubGrpc.getCreateAttributeMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getCreateAttributeMethod = ApiHubGrpc.getCreateAttributeMethod) == null) {
          ApiHubGrpc.getCreateAttributeMethod =
              getCreateAttributeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.CreateAttributeRequest,
                          com.google.cloud.apihub.v1.Attribute>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAttribute"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.CreateAttributeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.Attribute.getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("CreateAttribute"))
                      .build();
        }
      }
    }
    return getCreateAttributeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.GetAttributeRequest, com.google.cloud.apihub.v1.Attribute>
      getGetAttributeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAttribute",
      requestType = com.google.cloud.apihub.v1.GetAttributeRequest.class,
      responseType = com.google.cloud.apihub.v1.Attribute.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.GetAttributeRequest, com.google.cloud.apihub.v1.Attribute>
      getGetAttributeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.GetAttributeRequest, com.google.cloud.apihub.v1.Attribute>
        getGetAttributeMethod;
    if ((getGetAttributeMethod = ApiHubGrpc.getGetAttributeMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getGetAttributeMethod = ApiHubGrpc.getGetAttributeMethod) == null) {
          ApiHubGrpc.getGetAttributeMethod =
              getGetAttributeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.GetAttributeRequest,
                          com.google.cloud.apihub.v1.Attribute>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAttribute"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.GetAttributeRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.Attribute.getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("GetAttribute"))
                      .build();
        }
      }
    }
    return getGetAttributeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.UpdateAttributeRequest, com.google.cloud.apihub.v1.Attribute>
      getUpdateAttributeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAttribute",
      requestType = com.google.cloud.apihub.v1.UpdateAttributeRequest.class,
      responseType = com.google.cloud.apihub.v1.Attribute.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.UpdateAttributeRequest, com.google.cloud.apihub.v1.Attribute>
      getUpdateAttributeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.UpdateAttributeRequest, com.google.cloud.apihub.v1.Attribute>
        getUpdateAttributeMethod;
    if ((getUpdateAttributeMethod = ApiHubGrpc.getUpdateAttributeMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getUpdateAttributeMethod = ApiHubGrpc.getUpdateAttributeMethod) == null) {
          ApiHubGrpc.getUpdateAttributeMethod =
              getUpdateAttributeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.UpdateAttributeRequest,
                          com.google.cloud.apihub.v1.Attribute>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAttribute"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.UpdateAttributeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.Attribute.getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("UpdateAttribute"))
                      .build();
        }
      }
    }
    return getUpdateAttributeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.DeleteAttributeRequest, com.google.protobuf.Empty>
      getDeleteAttributeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAttribute",
      requestType = com.google.cloud.apihub.v1.DeleteAttributeRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.DeleteAttributeRequest, com.google.protobuf.Empty>
      getDeleteAttributeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.DeleteAttributeRequest, com.google.protobuf.Empty>
        getDeleteAttributeMethod;
    if ((getDeleteAttributeMethod = ApiHubGrpc.getDeleteAttributeMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getDeleteAttributeMethod = ApiHubGrpc.getDeleteAttributeMethod) == null) {
          ApiHubGrpc.getDeleteAttributeMethod =
              getDeleteAttributeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.DeleteAttributeRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAttribute"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.DeleteAttributeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("DeleteAttribute"))
                      .build();
        }
      }
    }
    return getDeleteAttributeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.ListAttributesRequest,
          com.google.cloud.apihub.v1.ListAttributesResponse>
      getListAttributesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAttributes",
      requestType = com.google.cloud.apihub.v1.ListAttributesRequest.class,
      responseType = com.google.cloud.apihub.v1.ListAttributesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.ListAttributesRequest,
          com.google.cloud.apihub.v1.ListAttributesResponse>
      getListAttributesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.ListAttributesRequest,
            com.google.cloud.apihub.v1.ListAttributesResponse>
        getListAttributesMethod;
    if ((getListAttributesMethod = ApiHubGrpc.getListAttributesMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getListAttributesMethod = ApiHubGrpc.getListAttributesMethod) == null) {
          ApiHubGrpc.getListAttributesMethod =
              getListAttributesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.ListAttributesRequest,
                          com.google.cloud.apihub.v1.ListAttributesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAttributes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.ListAttributesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.ListAttributesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("ListAttributes"))
                      .build();
        }
      }
    }
    return getListAttributesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.SearchResourcesRequest,
          com.google.cloud.apihub.v1.SearchResourcesResponse>
      getSearchResourcesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchResources",
      requestType = com.google.cloud.apihub.v1.SearchResourcesRequest.class,
      responseType = com.google.cloud.apihub.v1.SearchResourcesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.SearchResourcesRequest,
          com.google.cloud.apihub.v1.SearchResourcesResponse>
      getSearchResourcesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.SearchResourcesRequest,
            com.google.cloud.apihub.v1.SearchResourcesResponse>
        getSearchResourcesMethod;
    if ((getSearchResourcesMethod = ApiHubGrpc.getSearchResourcesMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getSearchResourcesMethod = ApiHubGrpc.getSearchResourcesMethod) == null) {
          ApiHubGrpc.getSearchResourcesMethod =
              getSearchResourcesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.SearchResourcesRequest,
                          com.google.cloud.apihub.v1.SearchResourcesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchResources"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.SearchResourcesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.SearchResourcesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("SearchResources"))
                      .build();
        }
      }
    }
    return getSearchResourcesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.CreateExternalApiRequest,
          com.google.cloud.apihub.v1.ExternalApi>
      getCreateExternalApiMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateExternalApi",
      requestType = com.google.cloud.apihub.v1.CreateExternalApiRequest.class,
      responseType = com.google.cloud.apihub.v1.ExternalApi.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.CreateExternalApiRequest,
          com.google.cloud.apihub.v1.ExternalApi>
      getCreateExternalApiMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.CreateExternalApiRequest,
            com.google.cloud.apihub.v1.ExternalApi>
        getCreateExternalApiMethod;
    if ((getCreateExternalApiMethod = ApiHubGrpc.getCreateExternalApiMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getCreateExternalApiMethod = ApiHubGrpc.getCreateExternalApiMethod) == null) {
          ApiHubGrpc.getCreateExternalApiMethod =
              getCreateExternalApiMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.CreateExternalApiRequest,
                          com.google.cloud.apihub.v1.ExternalApi>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateExternalApi"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.CreateExternalApiRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.ExternalApi.getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("CreateExternalApi"))
                      .build();
        }
      }
    }
    return getCreateExternalApiMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.GetExternalApiRequest, com.google.cloud.apihub.v1.ExternalApi>
      getGetExternalApiMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetExternalApi",
      requestType = com.google.cloud.apihub.v1.GetExternalApiRequest.class,
      responseType = com.google.cloud.apihub.v1.ExternalApi.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.GetExternalApiRequest, com.google.cloud.apihub.v1.ExternalApi>
      getGetExternalApiMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.GetExternalApiRequest,
            com.google.cloud.apihub.v1.ExternalApi>
        getGetExternalApiMethod;
    if ((getGetExternalApiMethod = ApiHubGrpc.getGetExternalApiMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getGetExternalApiMethod = ApiHubGrpc.getGetExternalApiMethod) == null) {
          ApiHubGrpc.getGetExternalApiMethod =
              getGetExternalApiMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.GetExternalApiRequest,
                          com.google.cloud.apihub.v1.ExternalApi>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetExternalApi"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.GetExternalApiRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.ExternalApi.getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("GetExternalApi"))
                      .build();
        }
      }
    }
    return getGetExternalApiMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.UpdateExternalApiRequest,
          com.google.cloud.apihub.v1.ExternalApi>
      getUpdateExternalApiMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateExternalApi",
      requestType = com.google.cloud.apihub.v1.UpdateExternalApiRequest.class,
      responseType = com.google.cloud.apihub.v1.ExternalApi.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.UpdateExternalApiRequest,
          com.google.cloud.apihub.v1.ExternalApi>
      getUpdateExternalApiMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.UpdateExternalApiRequest,
            com.google.cloud.apihub.v1.ExternalApi>
        getUpdateExternalApiMethod;
    if ((getUpdateExternalApiMethod = ApiHubGrpc.getUpdateExternalApiMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getUpdateExternalApiMethod = ApiHubGrpc.getUpdateExternalApiMethod) == null) {
          ApiHubGrpc.getUpdateExternalApiMethod =
              getUpdateExternalApiMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.UpdateExternalApiRequest,
                          com.google.cloud.apihub.v1.ExternalApi>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateExternalApi"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.UpdateExternalApiRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.ExternalApi.getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("UpdateExternalApi"))
                      .build();
        }
      }
    }
    return getUpdateExternalApiMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.DeleteExternalApiRequest, com.google.protobuf.Empty>
      getDeleteExternalApiMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteExternalApi",
      requestType = com.google.cloud.apihub.v1.DeleteExternalApiRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.DeleteExternalApiRequest, com.google.protobuf.Empty>
      getDeleteExternalApiMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.DeleteExternalApiRequest, com.google.protobuf.Empty>
        getDeleteExternalApiMethod;
    if ((getDeleteExternalApiMethod = ApiHubGrpc.getDeleteExternalApiMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getDeleteExternalApiMethod = ApiHubGrpc.getDeleteExternalApiMethod) == null) {
          ApiHubGrpc.getDeleteExternalApiMethod =
              getDeleteExternalApiMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.DeleteExternalApiRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteExternalApi"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.DeleteExternalApiRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("DeleteExternalApi"))
                      .build();
        }
      }
    }
    return getDeleteExternalApiMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.ListExternalApisRequest,
          com.google.cloud.apihub.v1.ListExternalApisResponse>
      getListExternalApisMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListExternalApis",
      requestType = com.google.cloud.apihub.v1.ListExternalApisRequest.class,
      responseType = com.google.cloud.apihub.v1.ListExternalApisResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.ListExternalApisRequest,
          com.google.cloud.apihub.v1.ListExternalApisResponse>
      getListExternalApisMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.ListExternalApisRequest,
            com.google.cloud.apihub.v1.ListExternalApisResponse>
        getListExternalApisMethod;
    if ((getListExternalApisMethod = ApiHubGrpc.getListExternalApisMethod) == null) {
      synchronized (ApiHubGrpc.class) {
        if ((getListExternalApisMethod = ApiHubGrpc.getListExternalApisMethod) == null) {
          ApiHubGrpc.getListExternalApisMethod =
              getListExternalApisMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.ListExternalApisRequest,
                          com.google.cloud.apihub.v1.ListExternalApisResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListExternalApis"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.ListExternalApisRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.ListExternalApisResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubMethodDescriptorSupplier("ListExternalApis"))
                      .build();
        }
      }
    }
    return getListExternalApisMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ApiHubStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ApiHubStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ApiHubStub>() {
          @java.lang.Override
          public ApiHubStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ApiHubStub(channel, callOptions);
          }
        };
    return ApiHubStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ApiHubBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ApiHubBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ApiHubBlockingStub>() {
          @java.lang.Override
          public ApiHubBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ApiHubBlockingStub(channel, callOptions);
          }
        };
    return ApiHubBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ApiHubFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ApiHubFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ApiHubFutureStub>() {
          @java.lang.Override
          public ApiHubFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ApiHubFutureStub(channel, callOptions);
          }
        };
    return ApiHubFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * This service provides all methods related to the API hub.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Create an API resource in the API hub.
     * Once an API resource is created, versions can be added to it.
     * </pre>
     */
    default void createApi(
        com.google.cloud.apihub.v1.CreateApiRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Api> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateApiMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get API resource details including the API versions contained in it.
     * </pre>
     */
    default void getApi(
        com.google.cloud.apihub.v1.GetApiRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Api> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetApiMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List API resources in the API hub.
     * </pre>
     */
    default void listApis(
        com.google.cloud.apihub.v1.ListApisRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ListApisResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListApisMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update an API resource in the API hub. The following fields in the
     * [API][] can be updated:
     * * [display_name][google.cloud.apihub.v1.Api.display_name]
     * * [description][google.cloud.apihub.v1.Api.description]
     * * [owner][google.cloud.apihub.v1.Api.owner]
     * * [documentation][google.cloud.apihub.v1.Api.documentation]
     * * [target_user][google.cloud.apihub.v1.Api.target_user]
     * * [team][google.cloud.apihub.v1.Api.team]
     * * [business_unit][google.cloud.apihub.v1.Api.business_unit]
     * * [maturity_level][google.cloud.apihub.v1.Api.maturity_level]
     * * [attributes][google.cloud.apihub.v1.Api.attributes]
     * The
     * [update_mask][google.cloud.apihub.v1.UpdateApiRequest.update_mask]
     * should be used to specify the fields being updated.
     * Updating the owner field requires complete owner message
     * and updates both owner and email fields.
     * </pre>
     */
    default void updateApi(
        com.google.cloud.apihub.v1.UpdateApiRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Api> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateApiMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete an API resource in the API hub. API can only be deleted if all
     * underlying versions are deleted.
     * </pre>
     */
    default void deleteApi(
        com.google.cloud.apihub.v1.DeleteApiRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteApiMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create an API version for an API resource in the API hub.
     * </pre>
     */
    default void createVersion(
        com.google.cloud.apihub.v1.CreateVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Version> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get details about the API version of an API resource. This will include
     * information about the specs and operations present in the API
     * version as well as the deployments linked to it.
     * </pre>
     */
    default void getVersion(
        com.google.cloud.apihub.v1.GetVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Version> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List API versions of an API resource in the API hub.
     * </pre>
     */
    default void listVersions(
        com.google.cloud.apihub.v1.ListVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ListVersionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListVersionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update API version. The following fields in the
     * [version][google.cloud.apihub.v1.Version] can be updated currently:
     * * [display_name][google.cloud.apihub.v1.Version.display_name]
     * * [description][google.cloud.apihub.v1.Version.description]
     * * [documentation][google.cloud.apihub.v1.Version.documentation]
     * * [deployments][google.cloud.apihub.v1.Version.deployments]
     * * [lifecycle][google.cloud.apihub.v1.Version.lifecycle]
     * * [compliance][google.cloud.apihub.v1.Version.compliance]
     * * [accreditation][google.cloud.apihub.v1.Version.accreditation]
     * * [attributes][google.cloud.apihub.v1.Version.attributes]
     * The
     * [update_mask][google.cloud.apihub.v1.UpdateVersionRequest.update_mask]
     * should be used to specify the fields being updated.
     * </pre>
     */
    default void updateVersion(
        com.google.cloud.apihub.v1.UpdateVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Version> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete an API version. Version can only be deleted if all underlying specs,
     * operations, definitions and linked deployments are deleted.
     * </pre>
     */
    default void deleteVersion(
        com.google.cloud.apihub.v1.DeleteVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Add a spec to an API version in the API hub.
     * Multiple specs can be added to an API version.
     * Note, while adding a spec, at least one of `contents` or `source_uri` must
     * be provided. If `contents` is provided, then `spec_type` must also be
     * provided.
     * On adding a spec with contents to the version, the operations present in it
     * will be added to the version.Note that the file contents in the spec should
     * be of the same type as defined in the
     * `projects/{project}/locations/{location}/attributes/system-spec-type`
     * attribute associated with spec resource. Note that specs of various types
     * can be uploaded, however parsing of details is supported for OpenAPI spec
     * currently.
     * In order to access the information parsed from the spec, use the
     * [GetSpec][google.cloud.apihub.v1.ApiHub.GetSpec] method.
     * In order to access the raw contents for a particular spec, use the
     * [GetSpecContents][google.cloud.apihub.v1.ApiHub.GetSpecContents] method.
     * In order to access the operations parsed from the spec, use the
     * [ListAPIOperations][google.cloud.apihub.v1.ApiHub.ListApiOperations]
     * method.
     * </pre>
     */
    default void createSpec(
        com.google.cloud.apihub.v1.CreateSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Spec> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateSpecMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get details about the information parsed from a spec.
     * Note that this method does not return the raw spec contents.
     * Use [GetSpecContents][google.cloud.apihub.v1.ApiHub.GetSpecContents] method
     * to retrieve the same.
     * </pre>
     */
    default void getSpec(
        com.google.cloud.apihub.v1.GetSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Spec> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSpecMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get spec contents.
     * </pre>
     */
    default void getSpecContents(
        com.google.cloud.apihub.v1.GetSpecContentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.SpecContents> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSpecContentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List specs corresponding to a particular API resource.
     * </pre>
     */
    default void listSpecs(
        com.google.cloud.apihub.v1.ListSpecsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ListSpecsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListSpecsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update spec. The following fields in the
     * [spec][google.cloud.apihub.v1.Spec] can be updated:
     * * [display_name][google.cloud.apihub.v1.Spec.display_name]
     * * [source_uri][google.cloud.apihub.v1.Spec.source_uri]
     * * [lint_response][google.cloud.apihub.v1.Spec.lint_response]
     * * [attributes][google.cloud.apihub.v1.Spec.attributes]
     * * [contents][google.cloud.apihub.v1.Spec.contents]
     * * [spec_type][google.cloud.apihub.v1.Spec.spec_type]
     * In case of an OAS spec, updating spec contents can lead to:
     * 1. Creation, deletion and update of operations.
     * 2. Creation, deletion and update of definitions.
     * 3. Update of other info parsed out from the new spec.
     * In case of contents or source_uri being present in update mask, spec_type
     * must also be present. Also, spec_type can not be present in update mask if
     * contents or source_uri is not present.
     * The
     * [update_mask][google.cloud.apihub.v1.UpdateSpecRequest.update_mask]
     * should be used to specify the fields being updated.
     * </pre>
     */
    default void updateSpec(
        com.google.cloud.apihub.v1.UpdateSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Spec> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateSpecMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a spec.
     * Deleting a spec will also delete the associated operations from the
     * version.
     * </pre>
     */
    default void deleteSpec(
        com.google.cloud.apihub.v1.DeleteSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteSpecMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get details about a particular operation in API version.
     * </pre>
     */
    default void getApiOperation(
        com.google.cloud.apihub.v1.GetApiOperationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ApiOperation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetApiOperationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List operations in an API version.
     * </pre>
     */
    default void listApiOperations(
        com.google.cloud.apihub.v1.ListApiOperationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ListApiOperationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListApiOperationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get details about a definition in an API version.
     * </pre>
     */
    default void getDefinition(
        com.google.cloud.apihub.v1.GetDefinitionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Definition> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDefinitionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a deployment resource in the API hub.
     * Once a deployment resource is created, it can be associated with API
     * versions.
     * </pre>
     */
    default void createDeployment(
        com.google.cloud.apihub.v1.CreateDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Deployment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get details about a deployment and the API versions linked to it.
     * </pre>
     */
    default void getDeployment(
        com.google.cloud.apihub.v1.GetDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Deployment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List deployment resources in the API hub.
     * </pre>
     */
    default void listDeployments(
        com.google.cloud.apihub.v1.ListDeploymentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ListDeploymentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDeploymentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a deployment resource in the API hub. The following fields in the
     * [deployment resource][google.cloud.apihub.v1.Deployment] can be
     * updated:
     * * [display_name][google.cloud.apihub.v1.Deployment.display_name]
     * * [description][google.cloud.apihub.v1.Deployment.description]
     * * [documentation][google.cloud.apihub.v1.Deployment.documentation]
     * * [deployment_type][google.cloud.apihub.v1.Deployment.deployment_type]
     * * [resource_uri][google.cloud.apihub.v1.Deployment.resource_uri]
     * * [endpoints][google.cloud.apihub.v1.Deployment.endpoints]
     * * [slo][google.cloud.apihub.v1.Deployment.slo]
     * * [environment][google.cloud.apihub.v1.Deployment.environment]
     * * [attributes][google.cloud.apihub.v1.Deployment.attributes]
     * The
     * [update_mask][google.cloud.apihub.v1.UpdateDeploymentRequest.update_mask]
     * should be used to specify the fields being updated.
     * </pre>
     */
    default void updateDeployment(
        com.google.cloud.apihub.v1.UpdateDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Deployment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a deployment resource in the API hub.
     * </pre>
     */
    default void deleteDeployment(
        com.google.cloud.apihub.v1.DeleteDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a user defined attribute.
     * Certain pre defined attributes are already created by the API hub. These
     * attributes will have type as `SYSTEM_DEFINED` and can be listed via
     * [ListAttributes][google.cloud.apihub.v1.ApiHub.ListAttributes] method.
     * Allowed values for the same can be updated via
     * [UpdateAttribute][google.cloud.apihub.v1.ApiHub.UpdateAttribute] method.
     * </pre>
     */
    default void createAttribute(
        com.google.cloud.apihub.v1.CreateAttributeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Attribute> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAttributeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get details about the attribute.
     * </pre>
     */
    default void getAttribute(
        com.google.cloud.apihub.v1.GetAttributeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Attribute> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAttributeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update the attribute.  The following fields in the
     * [Attribute resource][google.cloud.apihub.v1.Attribute] can be updated:
     * * [display_name][google.cloud.apihub.v1.Attribute.display_name]
     * The display name can be updated for user defined attributes only.
     * * [description][google.cloud.apihub.v1.Attribute.description]
     * The description can be updated for user defined attributes only.
     * * [allowed_values][google.cloud.apihub.v1.Attribute.allowed_values]
     * To update the list of allowed values, clients need to use the fetched list
     * of allowed values and add or remove values to or from the same list.
     * The mutable allowed values can be updated for both user defined and System
     * defined attributes. The immutable allowed values cannot be updated or
     * deleted. The updated list of allowed values cannot be empty. If an allowed
     * value that is already used by some resource's attribute is deleted, then
     * the association between the resource and the attribute value will also be
     * deleted.
     * * [cardinality][google.cloud.apihub.v1.Attribute.cardinality]
     * The cardinality can be updated for user defined attributes only.
     * Cardinality can only be increased during an update.
     * The
     * [update_mask][google.cloud.apihub.v1.UpdateAttributeRequest.update_mask]
     * should be used to specify the fields being updated.
     * </pre>
     */
    default void updateAttribute(
        com.google.cloud.apihub.v1.UpdateAttributeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Attribute> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAttributeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete an attribute.
     * Note: System defined attributes cannot be deleted. All
     * associations of the attribute being deleted with any API hub resource will
     * also get deleted.
     * </pre>
     */
    default void deleteAttribute(
        com.google.cloud.apihub.v1.DeleteAttributeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAttributeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all attributes.
     * </pre>
     */
    default void listAttributes(
        com.google.cloud.apihub.v1.ListAttributesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ListAttributesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAttributesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Search across API-Hub resources.
     * </pre>
     */
    default void searchResources(
        com.google.cloud.apihub.v1.SearchResourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.SearchResourcesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchResourcesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create an External API resource in the API hub.
     * </pre>
     */
    default void createExternalApi(
        com.google.cloud.apihub.v1.CreateExternalApiRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ExternalApi> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateExternalApiMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get details about an External API resource in the API hub.
     * </pre>
     */
    default void getExternalApi(
        com.google.cloud.apihub.v1.GetExternalApiRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ExternalApi> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetExternalApiMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update an External API resource in the API hub. The following fields can be
     * updated:
     * * [display_name][google.cloud.apihub.v1.ExternalApi.display_name]
     * * [description][google.cloud.apihub.v1.ExternalApi.description]
     * * [documentation][google.cloud.apihub.v1.ExternalApi.documentation]
     * * [endpoints][google.cloud.apihub.v1.ExternalApi.endpoints]
     * * [paths][google.cloud.apihub.v1.ExternalApi.paths]
     * The
     * [update_mask][google.cloud.apihub.v1.UpdateExternalApiRequest.update_mask]
     * should be used to specify the fields being updated.
     * </pre>
     */
    default void updateExternalApi(
        com.google.cloud.apihub.v1.UpdateExternalApiRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ExternalApi> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateExternalApiMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete an External API resource in the API hub.
     * </pre>
     */
    default void deleteExternalApi(
        com.google.cloud.apihub.v1.DeleteExternalApiRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteExternalApiMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List External API resources in the API hub.
     * </pre>
     */
    default void listExternalApis(
        com.google.cloud.apihub.v1.ListExternalApisRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ListExternalApisResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListExternalApisMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ApiHub.
   *
   * <pre>
   * This service provides all methods related to the API hub.
   * </pre>
   */
  public abstract static class ApiHubImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ApiHubGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ApiHub.
   *
   * <pre>
   * This service provides all methods related to the API hub.
   * </pre>
   */
  public static final class ApiHubStub extends io.grpc.stub.AbstractAsyncStub<ApiHubStub> {
    private ApiHubStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ApiHubStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ApiHubStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create an API resource in the API hub.
     * Once an API resource is created, versions can be added to it.
     * </pre>
     */
    public void createApi(
        com.google.cloud.apihub.v1.CreateApiRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Api> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateApiMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get API resource details including the API versions contained in it.
     * </pre>
     */
    public void getApi(
        com.google.cloud.apihub.v1.GetApiRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Api> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetApiMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List API resources in the API hub.
     * </pre>
     */
    public void listApis(
        com.google.cloud.apihub.v1.ListApisRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ListApisResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListApisMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update an API resource in the API hub. The following fields in the
     * [API][] can be updated:
     * * [display_name][google.cloud.apihub.v1.Api.display_name]
     * * [description][google.cloud.apihub.v1.Api.description]
     * * [owner][google.cloud.apihub.v1.Api.owner]
     * * [documentation][google.cloud.apihub.v1.Api.documentation]
     * * [target_user][google.cloud.apihub.v1.Api.target_user]
     * * [team][google.cloud.apihub.v1.Api.team]
     * * [business_unit][google.cloud.apihub.v1.Api.business_unit]
     * * [maturity_level][google.cloud.apihub.v1.Api.maturity_level]
     * * [attributes][google.cloud.apihub.v1.Api.attributes]
     * The
     * [update_mask][google.cloud.apihub.v1.UpdateApiRequest.update_mask]
     * should be used to specify the fields being updated.
     * Updating the owner field requires complete owner message
     * and updates both owner and email fields.
     * </pre>
     */
    public void updateApi(
        com.google.cloud.apihub.v1.UpdateApiRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Api> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateApiMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete an API resource in the API hub. API can only be deleted if all
     * underlying versions are deleted.
     * </pre>
     */
    public void deleteApi(
        com.google.cloud.apihub.v1.DeleteApiRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteApiMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create an API version for an API resource in the API hub.
     * </pre>
     */
    public void createVersion(
        com.google.cloud.apihub.v1.CreateVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Version> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get details about the API version of an API resource. This will include
     * information about the specs and operations present in the API
     * version as well as the deployments linked to it.
     * </pre>
     */
    public void getVersion(
        com.google.cloud.apihub.v1.GetVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Version> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetVersionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List API versions of an API resource in the API hub.
     * </pre>
     */
    public void listVersions(
        com.google.cloud.apihub.v1.ListVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ListVersionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListVersionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update API version. The following fields in the
     * [version][google.cloud.apihub.v1.Version] can be updated currently:
     * * [display_name][google.cloud.apihub.v1.Version.display_name]
     * * [description][google.cloud.apihub.v1.Version.description]
     * * [documentation][google.cloud.apihub.v1.Version.documentation]
     * * [deployments][google.cloud.apihub.v1.Version.deployments]
     * * [lifecycle][google.cloud.apihub.v1.Version.lifecycle]
     * * [compliance][google.cloud.apihub.v1.Version.compliance]
     * * [accreditation][google.cloud.apihub.v1.Version.accreditation]
     * * [attributes][google.cloud.apihub.v1.Version.attributes]
     * The
     * [update_mask][google.cloud.apihub.v1.UpdateVersionRequest.update_mask]
     * should be used to specify the fields being updated.
     * </pre>
     */
    public void updateVersion(
        com.google.cloud.apihub.v1.UpdateVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Version> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete an API version. Version can only be deleted if all underlying specs,
     * operations, definitions and linked deployments are deleted.
     * </pre>
     */
    public void deleteVersion(
        com.google.cloud.apihub.v1.DeleteVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Add a spec to an API version in the API hub.
     * Multiple specs can be added to an API version.
     * Note, while adding a spec, at least one of `contents` or `source_uri` must
     * be provided. If `contents` is provided, then `spec_type` must also be
     * provided.
     * On adding a spec with contents to the version, the operations present in it
     * will be added to the version.Note that the file contents in the spec should
     * be of the same type as defined in the
     * `projects/{project}/locations/{location}/attributes/system-spec-type`
     * attribute associated with spec resource. Note that specs of various types
     * can be uploaded, however parsing of details is supported for OpenAPI spec
     * currently.
     * In order to access the information parsed from the spec, use the
     * [GetSpec][google.cloud.apihub.v1.ApiHub.GetSpec] method.
     * In order to access the raw contents for a particular spec, use the
     * [GetSpecContents][google.cloud.apihub.v1.ApiHub.GetSpecContents] method.
     * In order to access the operations parsed from the spec, use the
     * [ListAPIOperations][google.cloud.apihub.v1.ApiHub.ListApiOperations]
     * method.
     * </pre>
     */
    public void createSpec(
        com.google.cloud.apihub.v1.CreateSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Spec> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSpecMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get details about the information parsed from a spec.
     * Note that this method does not return the raw spec contents.
     * Use [GetSpecContents][google.cloud.apihub.v1.ApiHub.GetSpecContents] method
     * to retrieve the same.
     * </pre>
     */
    public void getSpec(
        com.google.cloud.apihub.v1.GetSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Spec> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSpecMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get spec contents.
     * </pre>
     */
    public void getSpecContents(
        com.google.cloud.apihub.v1.GetSpecContentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.SpecContents> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSpecContentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List specs corresponding to a particular API resource.
     * </pre>
     */
    public void listSpecs(
        com.google.cloud.apihub.v1.ListSpecsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ListSpecsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSpecsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update spec. The following fields in the
     * [spec][google.cloud.apihub.v1.Spec] can be updated:
     * * [display_name][google.cloud.apihub.v1.Spec.display_name]
     * * [source_uri][google.cloud.apihub.v1.Spec.source_uri]
     * * [lint_response][google.cloud.apihub.v1.Spec.lint_response]
     * * [attributes][google.cloud.apihub.v1.Spec.attributes]
     * * [contents][google.cloud.apihub.v1.Spec.contents]
     * * [spec_type][google.cloud.apihub.v1.Spec.spec_type]
     * In case of an OAS spec, updating spec contents can lead to:
     * 1. Creation, deletion and update of operations.
     * 2. Creation, deletion and update of definitions.
     * 3. Update of other info parsed out from the new spec.
     * In case of contents or source_uri being present in update mask, spec_type
     * must also be present. Also, spec_type can not be present in update mask if
     * contents or source_uri is not present.
     * The
     * [update_mask][google.cloud.apihub.v1.UpdateSpecRequest.update_mask]
     * should be used to specify the fields being updated.
     * </pre>
     */
    public void updateSpec(
        com.google.cloud.apihub.v1.UpdateSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Spec> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSpecMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a spec.
     * Deleting a spec will also delete the associated operations from the
     * version.
     * </pre>
     */
    public void deleteSpec(
        com.google.cloud.apihub.v1.DeleteSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSpecMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get details about a particular operation in API version.
     * </pre>
     */
    public void getApiOperation(
        com.google.cloud.apihub.v1.GetApiOperationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ApiOperation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetApiOperationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List operations in an API version.
     * </pre>
     */
    public void listApiOperations(
        com.google.cloud.apihub.v1.ListApiOperationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ListApiOperationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListApiOperationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get details about a definition in an API version.
     * </pre>
     */
    public void getDefinition(
        com.google.cloud.apihub.v1.GetDefinitionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Definition> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDefinitionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a deployment resource in the API hub.
     * Once a deployment resource is created, it can be associated with API
     * versions.
     * </pre>
     */
    public void createDeployment(
        com.google.cloud.apihub.v1.CreateDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Deployment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get details about a deployment and the API versions linked to it.
     * </pre>
     */
    public void getDeployment(
        com.google.cloud.apihub.v1.GetDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Deployment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List deployment resources in the API hub.
     * </pre>
     */
    public void listDeployments(
        com.google.cloud.apihub.v1.ListDeploymentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ListDeploymentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDeploymentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a deployment resource in the API hub. The following fields in the
     * [deployment resource][google.cloud.apihub.v1.Deployment] can be
     * updated:
     * * [display_name][google.cloud.apihub.v1.Deployment.display_name]
     * * [description][google.cloud.apihub.v1.Deployment.description]
     * * [documentation][google.cloud.apihub.v1.Deployment.documentation]
     * * [deployment_type][google.cloud.apihub.v1.Deployment.deployment_type]
     * * [resource_uri][google.cloud.apihub.v1.Deployment.resource_uri]
     * * [endpoints][google.cloud.apihub.v1.Deployment.endpoints]
     * * [slo][google.cloud.apihub.v1.Deployment.slo]
     * * [environment][google.cloud.apihub.v1.Deployment.environment]
     * * [attributes][google.cloud.apihub.v1.Deployment.attributes]
     * The
     * [update_mask][google.cloud.apihub.v1.UpdateDeploymentRequest.update_mask]
     * should be used to specify the fields being updated.
     * </pre>
     */
    public void updateDeployment(
        com.google.cloud.apihub.v1.UpdateDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Deployment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a deployment resource in the API hub.
     * </pre>
     */
    public void deleteDeployment(
        com.google.cloud.apihub.v1.DeleteDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a user defined attribute.
     * Certain pre defined attributes are already created by the API hub. These
     * attributes will have type as `SYSTEM_DEFINED` and can be listed via
     * [ListAttributes][google.cloud.apihub.v1.ApiHub.ListAttributes] method.
     * Allowed values for the same can be updated via
     * [UpdateAttribute][google.cloud.apihub.v1.ApiHub.UpdateAttribute] method.
     * </pre>
     */
    public void createAttribute(
        com.google.cloud.apihub.v1.CreateAttributeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Attribute> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAttributeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get details about the attribute.
     * </pre>
     */
    public void getAttribute(
        com.google.cloud.apihub.v1.GetAttributeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Attribute> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAttributeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update the attribute.  The following fields in the
     * [Attribute resource][google.cloud.apihub.v1.Attribute] can be updated:
     * * [display_name][google.cloud.apihub.v1.Attribute.display_name]
     * The display name can be updated for user defined attributes only.
     * * [description][google.cloud.apihub.v1.Attribute.description]
     * The description can be updated for user defined attributes only.
     * * [allowed_values][google.cloud.apihub.v1.Attribute.allowed_values]
     * To update the list of allowed values, clients need to use the fetched list
     * of allowed values and add or remove values to or from the same list.
     * The mutable allowed values can be updated for both user defined and System
     * defined attributes. The immutable allowed values cannot be updated or
     * deleted. The updated list of allowed values cannot be empty. If an allowed
     * value that is already used by some resource's attribute is deleted, then
     * the association between the resource and the attribute value will also be
     * deleted.
     * * [cardinality][google.cloud.apihub.v1.Attribute.cardinality]
     * The cardinality can be updated for user defined attributes only.
     * Cardinality can only be increased during an update.
     * The
     * [update_mask][google.cloud.apihub.v1.UpdateAttributeRequest.update_mask]
     * should be used to specify the fields being updated.
     * </pre>
     */
    public void updateAttribute(
        com.google.cloud.apihub.v1.UpdateAttributeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Attribute> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAttributeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete an attribute.
     * Note: System defined attributes cannot be deleted. All
     * associations of the attribute being deleted with any API hub resource will
     * also get deleted.
     * </pre>
     */
    public void deleteAttribute(
        com.google.cloud.apihub.v1.DeleteAttributeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAttributeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all attributes.
     * </pre>
     */
    public void listAttributes(
        com.google.cloud.apihub.v1.ListAttributesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ListAttributesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAttributesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Search across API-Hub resources.
     * </pre>
     */
    public void searchResources(
        com.google.cloud.apihub.v1.SearchResourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.SearchResourcesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchResourcesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create an External API resource in the API hub.
     * </pre>
     */
    public void createExternalApi(
        com.google.cloud.apihub.v1.CreateExternalApiRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ExternalApi> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateExternalApiMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get details about an External API resource in the API hub.
     * </pre>
     */
    public void getExternalApi(
        com.google.cloud.apihub.v1.GetExternalApiRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ExternalApi> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetExternalApiMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update an External API resource in the API hub. The following fields can be
     * updated:
     * * [display_name][google.cloud.apihub.v1.ExternalApi.display_name]
     * * [description][google.cloud.apihub.v1.ExternalApi.description]
     * * [documentation][google.cloud.apihub.v1.ExternalApi.documentation]
     * * [endpoints][google.cloud.apihub.v1.ExternalApi.endpoints]
     * * [paths][google.cloud.apihub.v1.ExternalApi.paths]
     * The
     * [update_mask][google.cloud.apihub.v1.UpdateExternalApiRequest.update_mask]
     * should be used to specify the fields being updated.
     * </pre>
     */
    public void updateExternalApi(
        com.google.cloud.apihub.v1.UpdateExternalApiRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ExternalApi> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateExternalApiMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete an External API resource in the API hub.
     * </pre>
     */
    public void deleteExternalApi(
        com.google.cloud.apihub.v1.DeleteExternalApiRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteExternalApiMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List External API resources in the API hub.
     * </pre>
     */
    public void listExternalApis(
        com.google.cloud.apihub.v1.ListExternalApisRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ListExternalApisResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListExternalApisMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ApiHub.
   *
   * <pre>
   * This service provides all methods related to the API hub.
   * </pre>
   */
  public static final class ApiHubBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ApiHubBlockingStub> {
    private ApiHubBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ApiHubBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ApiHubBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create an API resource in the API hub.
     * Once an API resource is created, versions can be added to it.
     * </pre>
     */
    public com.google.cloud.apihub.v1.Api createApi(
        com.google.cloud.apihub.v1.CreateApiRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateApiMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get API resource details including the API versions contained in it.
     * </pre>
     */
    public com.google.cloud.apihub.v1.Api getApi(com.google.cloud.apihub.v1.GetApiRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetApiMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List API resources in the API hub.
     * </pre>
     */
    public com.google.cloud.apihub.v1.ListApisResponse listApis(
        com.google.cloud.apihub.v1.ListApisRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListApisMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update an API resource in the API hub. The following fields in the
     * [API][] can be updated:
     * * [display_name][google.cloud.apihub.v1.Api.display_name]
     * * [description][google.cloud.apihub.v1.Api.description]
     * * [owner][google.cloud.apihub.v1.Api.owner]
     * * [documentation][google.cloud.apihub.v1.Api.documentation]
     * * [target_user][google.cloud.apihub.v1.Api.target_user]
     * * [team][google.cloud.apihub.v1.Api.team]
     * * [business_unit][google.cloud.apihub.v1.Api.business_unit]
     * * [maturity_level][google.cloud.apihub.v1.Api.maturity_level]
     * * [attributes][google.cloud.apihub.v1.Api.attributes]
     * The
     * [update_mask][google.cloud.apihub.v1.UpdateApiRequest.update_mask]
     * should be used to specify the fields being updated.
     * Updating the owner field requires complete owner message
     * and updates both owner and email fields.
     * </pre>
     */
    public com.google.cloud.apihub.v1.Api updateApi(
        com.google.cloud.apihub.v1.UpdateApiRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateApiMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete an API resource in the API hub. API can only be deleted if all
     * underlying versions are deleted.
     * </pre>
     */
    public com.google.protobuf.Empty deleteApi(
        com.google.cloud.apihub.v1.DeleteApiRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteApiMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create an API version for an API resource in the API hub.
     * </pre>
     */
    public com.google.cloud.apihub.v1.Version createVersion(
        com.google.cloud.apihub.v1.CreateVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get details about the API version of an API resource. This will include
     * information about the specs and operations present in the API
     * version as well as the deployments linked to it.
     * </pre>
     */
    public com.google.cloud.apihub.v1.Version getVersion(
        com.google.cloud.apihub.v1.GetVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List API versions of an API resource in the API hub.
     * </pre>
     */
    public com.google.cloud.apihub.v1.ListVersionsResponse listVersions(
        com.google.cloud.apihub.v1.ListVersionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListVersionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update API version. The following fields in the
     * [version][google.cloud.apihub.v1.Version] can be updated currently:
     * * [display_name][google.cloud.apihub.v1.Version.display_name]
     * * [description][google.cloud.apihub.v1.Version.description]
     * * [documentation][google.cloud.apihub.v1.Version.documentation]
     * * [deployments][google.cloud.apihub.v1.Version.deployments]
     * * [lifecycle][google.cloud.apihub.v1.Version.lifecycle]
     * * [compliance][google.cloud.apihub.v1.Version.compliance]
     * * [accreditation][google.cloud.apihub.v1.Version.accreditation]
     * * [attributes][google.cloud.apihub.v1.Version.attributes]
     * The
     * [update_mask][google.cloud.apihub.v1.UpdateVersionRequest.update_mask]
     * should be used to specify the fields being updated.
     * </pre>
     */
    public com.google.cloud.apihub.v1.Version updateVersion(
        com.google.cloud.apihub.v1.UpdateVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete an API version. Version can only be deleted if all underlying specs,
     * operations, definitions and linked deployments are deleted.
     * </pre>
     */
    public com.google.protobuf.Empty deleteVersion(
        com.google.cloud.apihub.v1.DeleteVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Add a spec to an API version in the API hub.
     * Multiple specs can be added to an API version.
     * Note, while adding a spec, at least one of `contents` or `source_uri` must
     * be provided. If `contents` is provided, then `spec_type` must also be
     * provided.
     * On adding a spec with contents to the version, the operations present in it
     * will be added to the version.Note that the file contents in the spec should
     * be of the same type as defined in the
     * `projects/{project}/locations/{location}/attributes/system-spec-type`
     * attribute associated with spec resource. Note that specs of various types
     * can be uploaded, however parsing of details is supported for OpenAPI spec
     * currently.
     * In order to access the information parsed from the spec, use the
     * [GetSpec][google.cloud.apihub.v1.ApiHub.GetSpec] method.
     * In order to access the raw contents for a particular spec, use the
     * [GetSpecContents][google.cloud.apihub.v1.ApiHub.GetSpecContents] method.
     * In order to access the operations parsed from the spec, use the
     * [ListAPIOperations][google.cloud.apihub.v1.ApiHub.ListApiOperations]
     * method.
     * </pre>
     */
    public com.google.cloud.apihub.v1.Spec createSpec(
        com.google.cloud.apihub.v1.CreateSpecRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSpecMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get details about the information parsed from a spec.
     * Note that this method does not return the raw spec contents.
     * Use [GetSpecContents][google.cloud.apihub.v1.ApiHub.GetSpecContents] method
     * to retrieve the same.
     * </pre>
     */
    public com.google.cloud.apihub.v1.Spec getSpec(
        com.google.cloud.apihub.v1.GetSpecRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSpecMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get spec contents.
     * </pre>
     */
    public com.google.cloud.apihub.v1.SpecContents getSpecContents(
        com.google.cloud.apihub.v1.GetSpecContentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSpecContentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List specs corresponding to a particular API resource.
     * </pre>
     */
    public com.google.cloud.apihub.v1.ListSpecsResponse listSpecs(
        com.google.cloud.apihub.v1.ListSpecsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSpecsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update spec. The following fields in the
     * [spec][google.cloud.apihub.v1.Spec] can be updated:
     * * [display_name][google.cloud.apihub.v1.Spec.display_name]
     * * [source_uri][google.cloud.apihub.v1.Spec.source_uri]
     * * [lint_response][google.cloud.apihub.v1.Spec.lint_response]
     * * [attributes][google.cloud.apihub.v1.Spec.attributes]
     * * [contents][google.cloud.apihub.v1.Spec.contents]
     * * [spec_type][google.cloud.apihub.v1.Spec.spec_type]
     * In case of an OAS spec, updating spec contents can lead to:
     * 1. Creation, deletion and update of operations.
     * 2. Creation, deletion and update of definitions.
     * 3. Update of other info parsed out from the new spec.
     * In case of contents or source_uri being present in update mask, spec_type
     * must also be present. Also, spec_type can not be present in update mask if
     * contents or source_uri is not present.
     * The
     * [update_mask][google.cloud.apihub.v1.UpdateSpecRequest.update_mask]
     * should be used to specify the fields being updated.
     * </pre>
     */
    public com.google.cloud.apihub.v1.Spec updateSpec(
        com.google.cloud.apihub.v1.UpdateSpecRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSpecMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a spec.
     * Deleting a spec will also delete the associated operations from the
     * version.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSpec(
        com.google.cloud.apihub.v1.DeleteSpecRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSpecMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get details about a particular operation in API version.
     * </pre>
     */
    public com.google.cloud.apihub.v1.ApiOperation getApiOperation(
        com.google.cloud.apihub.v1.GetApiOperationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetApiOperationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List operations in an API version.
     * </pre>
     */
    public com.google.cloud.apihub.v1.ListApiOperationsResponse listApiOperations(
        com.google.cloud.apihub.v1.ListApiOperationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListApiOperationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get details about a definition in an API version.
     * </pre>
     */
    public com.google.cloud.apihub.v1.Definition getDefinition(
        com.google.cloud.apihub.v1.GetDefinitionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDefinitionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a deployment resource in the API hub.
     * Once a deployment resource is created, it can be associated with API
     * versions.
     * </pre>
     */
    public com.google.cloud.apihub.v1.Deployment createDeployment(
        com.google.cloud.apihub.v1.CreateDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get details about a deployment and the API versions linked to it.
     * </pre>
     */
    public com.google.cloud.apihub.v1.Deployment getDeployment(
        com.google.cloud.apihub.v1.GetDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List deployment resources in the API hub.
     * </pre>
     */
    public com.google.cloud.apihub.v1.ListDeploymentsResponse listDeployments(
        com.google.cloud.apihub.v1.ListDeploymentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDeploymentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a deployment resource in the API hub. The following fields in the
     * [deployment resource][google.cloud.apihub.v1.Deployment] can be
     * updated:
     * * [display_name][google.cloud.apihub.v1.Deployment.display_name]
     * * [description][google.cloud.apihub.v1.Deployment.description]
     * * [documentation][google.cloud.apihub.v1.Deployment.documentation]
     * * [deployment_type][google.cloud.apihub.v1.Deployment.deployment_type]
     * * [resource_uri][google.cloud.apihub.v1.Deployment.resource_uri]
     * * [endpoints][google.cloud.apihub.v1.Deployment.endpoints]
     * * [slo][google.cloud.apihub.v1.Deployment.slo]
     * * [environment][google.cloud.apihub.v1.Deployment.environment]
     * * [attributes][google.cloud.apihub.v1.Deployment.attributes]
     * The
     * [update_mask][google.cloud.apihub.v1.UpdateDeploymentRequest.update_mask]
     * should be used to specify the fields being updated.
     * </pre>
     */
    public com.google.cloud.apihub.v1.Deployment updateDeployment(
        com.google.cloud.apihub.v1.UpdateDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a deployment resource in the API hub.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDeployment(
        com.google.cloud.apihub.v1.DeleteDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a user defined attribute.
     * Certain pre defined attributes are already created by the API hub. These
     * attributes will have type as `SYSTEM_DEFINED` and can be listed via
     * [ListAttributes][google.cloud.apihub.v1.ApiHub.ListAttributes] method.
     * Allowed values for the same can be updated via
     * [UpdateAttribute][google.cloud.apihub.v1.ApiHub.UpdateAttribute] method.
     * </pre>
     */
    public com.google.cloud.apihub.v1.Attribute createAttribute(
        com.google.cloud.apihub.v1.CreateAttributeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAttributeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get details about the attribute.
     * </pre>
     */
    public com.google.cloud.apihub.v1.Attribute getAttribute(
        com.google.cloud.apihub.v1.GetAttributeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAttributeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update the attribute.  The following fields in the
     * [Attribute resource][google.cloud.apihub.v1.Attribute] can be updated:
     * * [display_name][google.cloud.apihub.v1.Attribute.display_name]
     * The display name can be updated for user defined attributes only.
     * * [description][google.cloud.apihub.v1.Attribute.description]
     * The description can be updated for user defined attributes only.
     * * [allowed_values][google.cloud.apihub.v1.Attribute.allowed_values]
     * To update the list of allowed values, clients need to use the fetched list
     * of allowed values and add or remove values to or from the same list.
     * The mutable allowed values can be updated for both user defined and System
     * defined attributes. The immutable allowed values cannot be updated or
     * deleted. The updated list of allowed values cannot be empty. If an allowed
     * value that is already used by some resource's attribute is deleted, then
     * the association between the resource and the attribute value will also be
     * deleted.
     * * [cardinality][google.cloud.apihub.v1.Attribute.cardinality]
     * The cardinality can be updated for user defined attributes only.
     * Cardinality can only be increased during an update.
     * The
     * [update_mask][google.cloud.apihub.v1.UpdateAttributeRequest.update_mask]
     * should be used to specify the fields being updated.
     * </pre>
     */
    public com.google.cloud.apihub.v1.Attribute updateAttribute(
        com.google.cloud.apihub.v1.UpdateAttributeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAttributeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete an attribute.
     * Note: System defined attributes cannot be deleted. All
     * associations of the attribute being deleted with any API hub resource will
     * also get deleted.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAttribute(
        com.google.cloud.apihub.v1.DeleteAttributeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAttributeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all attributes.
     * </pre>
     */
    public com.google.cloud.apihub.v1.ListAttributesResponse listAttributes(
        com.google.cloud.apihub.v1.ListAttributesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAttributesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Search across API-Hub resources.
     * </pre>
     */
    public com.google.cloud.apihub.v1.SearchResourcesResponse searchResources(
        com.google.cloud.apihub.v1.SearchResourcesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchResourcesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create an External API resource in the API hub.
     * </pre>
     */
    public com.google.cloud.apihub.v1.ExternalApi createExternalApi(
        com.google.cloud.apihub.v1.CreateExternalApiRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateExternalApiMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get details about an External API resource in the API hub.
     * </pre>
     */
    public com.google.cloud.apihub.v1.ExternalApi getExternalApi(
        com.google.cloud.apihub.v1.GetExternalApiRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetExternalApiMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update an External API resource in the API hub. The following fields can be
     * updated:
     * * [display_name][google.cloud.apihub.v1.ExternalApi.display_name]
     * * [description][google.cloud.apihub.v1.ExternalApi.description]
     * * [documentation][google.cloud.apihub.v1.ExternalApi.documentation]
     * * [endpoints][google.cloud.apihub.v1.ExternalApi.endpoints]
     * * [paths][google.cloud.apihub.v1.ExternalApi.paths]
     * The
     * [update_mask][google.cloud.apihub.v1.UpdateExternalApiRequest.update_mask]
     * should be used to specify the fields being updated.
     * </pre>
     */
    public com.google.cloud.apihub.v1.ExternalApi updateExternalApi(
        com.google.cloud.apihub.v1.UpdateExternalApiRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateExternalApiMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete an External API resource in the API hub.
     * </pre>
     */
    public com.google.protobuf.Empty deleteExternalApi(
        com.google.cloud.apihub.v1.DeleteExternalApiRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteExternalApiMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List External API resources in the API hub.
     * </pre>
     */
    public com.google.cloud.apihub.v1.ListExternalApisResponse listExternalApis(
        com.google.cloud.apihub.v1.ListExternalApisRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListExternalApisMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ApiHub.
   *
   * <pre>
   * This service provides all methods related to the API hub.
   * </pre>
   */
  public static final class ApiHubFutureStub
      extends io.grpc.stub.AbstractFutureStub<ApiHubFutureStub> {
    private ApiHubFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ApiHubFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ApiHubFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create an API resource in the API hub.
     * Once an API resource is created, versions can be added to it.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apihub.v1.Api>
        createApi(com.google.cloud.apihub.v1.CreateApiRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateApiMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get API resource details including the API versions contained in it.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apihub.v1.Api>
        getApi(com.google.cloud.apihub.v1.GetApiRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetApiMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List API resources in the API hub.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apihub.v1.ListApisResponse>
        listApis(com.google.cloud.apihub.v1.ListApisRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListApisMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update an API resource in the API hub. The following fields in the
     * [API][] can be updated:
     * * [display_name][google.cloud.apihub.v1.Api.display_name]
     * * [description][google.cloud.apihub.v1.Api.description]
     * * [owner][google.cloud.apihub.v1.Api.owner]
     * * [documentation][google.cloud.apihub.v1.Api.documentation]
     * * [target_user][google.cloud.apihub.v1.Api.target_user]
     * * [team][google.cloud.apihub.v1.Api.team]
     * * [business_unit][google.cloud.apihub.v1.Api.business_unit]
     * * [maturity_level][google.cloud.apihub.v1.Api.maturity_level]
     * * [attributes][google.cloud.apihub.v1.Api.attributes]
     * The
     * [update_mask][google.cloud.apihub.v1.UpdateApiRequest.update_mask]
     * should be used to specify the fields being updated.
     * Updating the owner field requires complete owner message
     * and updates both owner and email fields.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apihub.v1.Api>
        updateApi(com.google.cloud.apihub.v1.UpdateApiRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateApiMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete an API resource in the API hub. API can only be deleted if all
     * underlying versions are deleted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteApi(
        com.google.cloud.apihub.v1.DeleteApiRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteApiMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create an API version for an API resource in the API hub.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apihub.v1.Version>
        createVersion(com.google.cloud.apihub.v1.CreateVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get details about the API version of an API resource. This will include
     * information about the specs and operations present in the API
     * version as well as the deployments linked to it.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apihub.v1.Version>
        getVersion(com.google.cloud.apihub.v1.GetVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List API versions of an API resource in the API hub.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apihub.v1.ListVersionsResponse>
        listVersions(com.google.cloud.apihub.v1.ListVersionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListVersionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update API version. The following fields in the
     * [version][google.cloud.apihub.v1.Version] can be updated currently:
     * * [display_name][google.cloud.apihub.v1.Version.display_name]
     * * [description][google.cloud.apihub.v1.Version.description]
     * * [documentation][google.cloud.apihub.v1.Version.documentation]
     * * [deployments][google.cloud.apihub.v1.Version.deployments]
     * * [lifecycle][google.cloud.apihub.v1.Version.lifecycle]
     * * [compliance][google.cloud.apihub.v1.Version.compliance]
     * * [accreditation][google.cloud.apihub.v1.Version.accreditation]
     * * [attributes][google.cloud.apihub.v1.Version.attributes]
     * The
     * [update_mask][google.cloud.apihub.v1.UpdateVersionRequest.update_mask]
     * should be used to specify the fields being updated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apihub.v1.Version>
        updateVersion(com.google.cloud.apihub.v1.UpdateVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete an API version. Version can only be deleted if all underlying specs,
     * operations, definitions and linked deployments are deleted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteVersion(com.google.cloud.apihub.v1.DeleteVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Add a spec to an API version in the API hub.
     * Multiple specs can be added to an API version.
     * Note, while adding a spec, at least one of `contents` or `source_uri` must
     * be provided. If `contents` is provided, then `spec_type` must also be
     * provided.
     * On adding a spec with contents to the version, the operations present in it
     * will be added to the version.Note that the file contents in the spec should
     * be of the same type as defined in the
     * `projects/{project}/locations/{location}/attributes/system-spec-type`
     * attribute associated with spec resource. Note that specs of various types
     * can be uploaded, however parsing of details is supported for OpenAPI spec
     * currently.
     * In order to access the information parsed from the spec, use the
     * [GetSpec][google.cloud.apihub.v1.ApiHub.GetSpec] method.
     * In order to access the raw contents for a particular spec, use the
     * [GetSpecContents][google.cloud.apihub.v1.ApiHub.GetSpecContents] method.
     * In order to access the operations parsed from the spec, use the
     * [ListAPIOperations][google.cloud.apihub.v1.ApiHub.ListApiOperations]
     * method.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apihub.v1.Spec>
        createSpec(com.google.cloud.apihub.v1.CreateSpecRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSpecMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get details about the information parsed from a spec.
     * Note that this method does not return the raw spec contents.
     * Use [GetSpecContents][google.cloud.apihub.v1.ApiHub.GetSpecContents] method
     * to retrieve the same.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apihub.v1.Spec>
        getSpec(com.google.cloud.apihub.v1.GetSpecRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSpecMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get spec contents.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apihub.v1.SpecContents>
        getSpecContents(com.google.cloud.apihub.v1.GetSpecContentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSpecContentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List specs corresponding to a particular API resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apihub.v1.ListSpecsResponse>
        listSpecs(com.google.cloud.apihub.v1.ListSpecsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSpecsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update spec. The following fields in the
     * [spec][google.cloud.apihub.v1.Spec] can be updated:
     * * [display_name][google.cloud.apihub.v1.Spec.display_name]
     * * [source_uri][google.cloud.apihub.v1.Spec.source_uri]
     * * [lint_response][google.cloud.apihub.v1.Spec.lint_response]
     * * [attributes][google.cloud.apihub.v1.Spec.attributes]
     * * [contents][google.cloud.apihub.v1.Spec.contents]
     * * [spec_type][google.cloud.apihub.v1.Spec.spec_type]
     * In case of an OAS spec, updating spec contents can lead to:
     * 1. Creation, deletion and update of operations.
     * 2. Creation, deletion and update of definitions.
     * 3. Update of other info parsed out from the new spec.
     * In case of contents or source_uri being present in update mask, spec_type
     * must also be present. Also, spec_type can not be present in update mask if
     * contents or source_uri is not present.
     * The
     * [update_mask][google.cloud.apihub.v1.UpdateSpecRequest.update_mask]
     * should be used to specify the fields being updated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apihub.v1.Spec>
        updateSpec(com.google.cloud.apihub.v1.UpdateSpecRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSpecMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a spec.
     * Deleting a spec will also delete the associated operations from the
     * version.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteSpec(
        com.google.cloud.apihub.v1.DeleteSpecRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSpecMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get details about a particular operation in API version.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apihub.v1.ApiOperation>
        getApiOperation(com.google.cloud.apihub.v1.GetApiOperationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetApiOperationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List operations in an API version.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apihub.v1.ListApiOperationsResponse>
        listApiOperations(com.google.cloud.apihub.v1.ListApiOperationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListApiOperationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get details about a definition in an API version.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apihub.v1.Definition>
        getDefinition(com.google.cloud.apihub.v1.GetDefinitionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDefinitionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a deployment resource in the API hub.
     * Once a deployment resource is created, it can be associated with API
     * versions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apihub.v1.Deployment>
        createDeployment(com.google.cloud.apihub.v1.CreateDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDeploymentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get details about a deployment and the API versions linked to it.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apihub.v1.Deployment>
        getDeployment(com.google.cloud.apihub.v1.GetDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDeploymentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List deployment resources in the API hub.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apihub.v1.ListDeploymentsResponse>
        listDeployments(com.google.cloud.apihub.v1.ListDeploymentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDeploymentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a deployment resource in the API hub. The following fields in the
     * [deployment resource][google.cloud.apihub.v1.Deployment] can be
     * updated:
     * * [display_name][google.cloud.apihub.v1.Deployment.display_name]
     * * [description][google.cloud.apihub.v1.Deployment.description]
     * * [documentation][google.cloud.apihub.v1.Deployment.documentation]
     * * [deployment_type][google.cloud.apihub.v1.Deployment.deployment_type]
     * * [resource_uri][google.cloud.apihub.v1.Deployment.resource_uri]
     * * [endpoints][google.cloud.apihub.v1.Deployment.endpoints]
     * * [slo][google.cloud.apihub.v1.Deployment.slo]
     * * [environment][google.cloud.apihub.v1.Deployment.environment]
     * * [attributes][google.cloud.apihub.v1.Deployment.attributes]
     * The
     * [update_mask][google.cloud.apihub.v1.UpdateDeploymentRequest.update_mask]
     * should be used to specify the fields being updated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apihub.v1.Deployment>
        updateDeployment(com.google.cloud.apihub.v1.UpdateDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDeploymentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a deployment resource in the API hub.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteDeployment(com.google.cloud.apihub.v1.DeleteDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDeploymentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a user defined attribute.
     * Certain pre defined attributes are already created by the API hub. These
     * attributes will have type as `SYSTEM_DEFINED` and can be listed via
     * [ListAttributes][google.cloud.apihub.v1.ApiHub.ListAttributes] method.
     * Allowed values for the same can be updated via
     * [UpdateAttribute][google.cloud.apihub.v1.ApiHub.UpdateAttribute] method.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apihub.v1.Attribute>
        createAttribute(com.google.cloud.apihub.v1.CreateAttributeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAttributeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get details about the attribute.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apihub.v1.Attribute>
        getAttribute(com.google.cloud.apihub.v1.GetAttributeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAttributeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update the attribute.  The following fields in the
     * [Attribute resource][google.cloud.apihub.v1.Attribute] can be updated:
     * * [display_name][google.cloud.apihub.v1.Attribute.display_name]
     * The display name can be updated for user defined attributes only.
     * * [description][google.cloud.apihub.v1.Attribute.description]
     * The description can be updated for user defined attributes only.
     * * [allowed_values][google.cloud.apihub.v1.Attribute.allowed_values]
     * To update the list of allowed values, clients need to use the fetched list
     * of allowed values and add or remove values to or from the same list.
     * The mutable allowed values can be updated for both user defined and System
     * defined attributes. The immutable allowed values cannot be updated or
     * deleted. The updated list of allowed values cannot be empty. If an allowed
     * value that is already used by some resource's attribute is deleted, then
     * the association between the resource and the attribute value will also be
     * deleted.
     * * [cardinality][google.cloud.apihub.v1.Attribute.cardinality]
     * The cardinality can be updated for user defined attributes only.
     * Cardinality can only be increased during an update.
     * The
     * [update_mask][google.cloud.apihub.v1.UpdateAttributeRequest.update_mask]
     * should be used to specify the fields being updated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apihub.v1.Attribute>
        updateAttribute(com.google.cloud.apihub.v1.UpdateAttributeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAttributeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete an attribute.
     * Note: System defined attributes cannot be deleted. All
     * associations of the attribute being deleted with any API hub resource will
     * also get deleted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteAttribute(com.google.cloud.apihub.v1.DeleteAttributeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAttributeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List all attributes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apihub.v1.ListAttributesResponse>
        listAttributes(com.google.cloud.apihub.v1.ListAttributesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAttributesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Search across API-Hub resources.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apihub.v1.SearchResourcesResponse>
        searchResources(com.google.cloud.apihub.v1.SearchResourcesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchResourcesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create an External API resource in the API hub.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apihub.v1.ExternalApi>
        createExternalApi(com.google.cloud.apihub.v1.CreateExternalApiRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateExternalApiMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get details about an External API resource in the API hub.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apihub.v1.ExternalApi>
        getExternalApi(com.google.cloud.apihub.v1.GetExternalApiRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetExternalApiMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update an External API resource in the API hub. The following fields can be
     * updated:
     * * [display_name][google.cloud.apihub.v1.ExternalApi.display_name]
     * * [description][google.cloud.apihub.v1.ExternalApi.description]
     * * [documentation][google.cloud.apihub.v1.ExternalApi.documentation]
     * * [endpoints][google.cloud.apihub.v1.ExternalApi.endpoints]
     * * [paths][google.cloud.apihub.v1.ExternalApi.paths]
     * The
     * [update_mask][google.cloud.apihub.v1.UpdateExternalApiRequest.update_mask]
     * should be used to specify the fields being updated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apihub.v1.ExternalApi>
        updateExternalApi(com.google.cloud.apihub.v1.UpdateExternalApiRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateExternalApiMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete an External API resource in the API hub.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteExternalApi(com.google.cloud.apihub.v1.DeleteExternalApiRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteExternalApiMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List External API resources in the API hub.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apihub.v1.ListExternalApisResponse>
        listExternalApis(com.google.cloud.apihub.v1.ListExternalApisRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListExternalApisMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_API = 0;
  private static final int METHODID_GET_API = 1;
  private static final int METHODID_LIST_APIS = 2;
  private static final int METHODID_UPDATE_API = 3;
  private static final int METHODID_DELETE_API = 4;
  private static final int METHODID_CREATE_VERSION = 5;
  private static final int METHODID_GET_VERSION = 6;
  private static final int METHODID_LIST_VERSIONS = 7;
  private static final int METHODID_UPDATE_VERSION = 8;
  private static final int METHODID_DELETE_VERSION = 9;
  private static final int METHODID_CREATE_SPEC = 10;
  private static final int METHODID_GET_SPEC = 11;
  private static final int METHODID_GET_SPEC_CONTENTS = 12;
  private static final int METHODID_LIST_SPECS = 13;
  private static final int METHODID_UPDATE_SPEC = 14;
  private static final int METHODID_DELETE_SPEC = 15;
  private static final int METHODID_GET_API_OPERATION = 16;
  private static final int METHODID_LIST_API_OPERATIONS = 17;
  private static final int METHODID_GET_DEFINITION = 18;
  private static final int METHODID_CREATE_DEPLOYMENT = 19;
  private static final int METHODID_GET_DEPLOYMENT = 20;
  private static final int METHODID_LIST_DEPLOYMENTS = 21;
  private static final int METHODID_UPDATE_DEPLOYMENT = 22;
  private static final int METHODID_DELETE_DEPLOYMENT = 23;
  private static final int METHODID_CREATE_ATTRIBUTE = 24;
  private static final int METHODID_GET_ATTRIBUTE = 25;
  private static final int METHODID_UPDATE_ATTRIBUTE = 26;
  private static final int METHODID_DELETE_ATTRIBUTE = 27;
  private static final int METHODID_LIST_ATTRIBUTES = 28;
  private static final int METHODID_SEARCH_RESOURCES = 29;
  private static final int METHODID_CREATE_EXTERNAL_API = 30;
  private static final int METHODID_GET_EXTERNAL_API = 31;
  private static final int METHODID_UPDATE_EXTERNAL_API = 32;
  private static final int METHODID_DELETE_EXTERNAL_API = 33;
  private static final int METHODID_LIST_EXTERNAL_APIS = 34;

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
        case METHODID_CREATE_API:
          serviceImpl.createApi(
              (com.google.cloud.apihub.v1.CreateApiRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Api>) responseObserver);
          break;
        case METHODID_GET_API:
          serviceImpl.getApi(
              (com.google.cloud.apihub.v1.GetApiRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Api>) responseObserver);
          break;
        case METHODID_LIST_APIS:
          serviceImpl.listApis(
              (com.google.cloud.apihub.v1.ListApisRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ListApisResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_API:
          serviceImpl.updateApi(
              (com.google.cloud.apihub.v1.UpdateApiRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Api>) responseObserver);
          break;
        case METHODID_DELETE_API:
          serviceImpl.deleteApi(
              (com.google.cloud.apihub.v1.DeleteApiRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_VERSION:
          serviceImpl.createVersion(
              (com.google.cloud.apihub.v1.CreateVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Version>) responseObserver);
          break;
        case METHODID_GET_VERSION:
          serviceImpl.getVersion(
              (com.google.cloud.apihub.v1.GetVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Version>) responseObserver);
          break;
        case METHODID_LIST_VERSIONS:
          serviceImpl.listVersions(
              (com.google.cloud.apihub.v1.ListVersionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ListVersionsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_VERSION:
          serviceImpl.updateVersion(
              (com.google.cloud.apihub.v1.UpdateVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Version>) responseObserver);
          break;
        case METHODID_DELETE_VERSION:
          serviceImpl.deleteVersion(
              (com.google.cloud.apihub.v1.DeleteVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_SPEC:
          serviceImpl.createSpec(
              (com.google.cloud.apihub.v1.CreateSpecRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Spec>) responseObserver);
          break;
        case METHODID_GET_SPEC:
          serviceImpl.getSpec(
              (com.google.cloud.apihub.v1.GetSpecRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Spec>) responseObserver);
          break;
        case METHODID_GET_SPEC_CONTENTS:
          serviceImpl.getSpecContents(
              (com.google.cloud.apihub.v1.GetSpecContentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.SpecContents>)
                  responseObserver);
          break;
        case METHODID_LIST_SPECS:
          serviceImpl.listSpecs(
              (com.google.cloud.apihub.v1.ListSpecsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ListSpecsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SPEC:
          serviceImpl.updateSpec(
              (com.google.cloud.apihub.v1.UpdateSpecRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Spec>) responseObserver);
          break;
        case METHODID_DELETE_SPEC:
          serviceImpl.deleteSpec(
              (com.google.cloud.apihub.v1.DeleteSpecRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_API_OPERATION:
          serviceImpl.getApiOperation(
              (com.google.cloud.apihub.v1.GetApiOperationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ApiOperation>)
                  responseObserver);
          break;
        case METHODID_LIST_API_OPERATIONS:
          serviceImpl.listApiOperations(
              (com.google.cloud.apihub.v1.ListApiOperationsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ListApiOperationsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DEFINITION:
          serviceImpl.getDefinition(
              (com.google.cloud.apihub.v1.GetDefinitionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Definition>)
                  responseObserver);
          break;
        case METHODID_CREATE_DEPLOYMENT:
          serviceImpl.createDeployment(
              (com.google.cloud.apihub.v1.CreateDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Deployment>)
                  responseObserver);
          break;
        case METHODID_GET_DEPLOYMENT:
          serviceImpl.getDeployment(
              (com.google.cloud.apihub.v1.GetDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Deployment>)
                  responseObserver);
          break;
        case METHODID_LIST_DEPLOYMENTS:
          serviceImpl.listDeployments(
              (com.google.cloud.apihub.v1.ListDeploymentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ListDeploymentsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DEPLOYMENT:
          serviceImpl.updateDeployment(
              (com.google.cloud.apihub.v1.UpdateDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Deployment>)
                  responseObserver);
          break;
        case METHODID_DELETE_DEPLOYMENT:
          serviceImpl.deleteDeployment(
              (com.google.cloud.apihub.v1.DeleteDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_ATTRIBUTE:
          serviceImpl.createAttribute(
              (com.google.cloud.apihub.v1.CreateAttributeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Attribute>) responseObserver);
          break;
        case METHODID_GET_ATTRIBUTE:
          serviceImpl.getAttribute(
              (com.google.cloud.apihub.v1.GetAttributeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Attribute>) responseObserver);
          break;
        case METHODID_UPDATE_ATTRIBUTE:
          serviceImpl.updateAttribute(
              (com.google.cloud.apihub.v1.UpdateAttributeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Attribute>) responseObserver);
          break;
        case METHODID_DELETE_ATTRIBUTE:
          serviceImpl.deleteAttribute(
              (com.google.cloud.apihub.v1.DeleteAttributeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_ATTRIBUTES:
          serviceImpl.listAttributes(
              (com.google.cloud.apihub.v1.ListAttributesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ListAttributesResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_RESOURCES:
          serviceImpl.searchResources(
              (com.google.cloud.apihub.v1.SearchResourcesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.SearchResourcesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_EXTERNAL_API:
          serviceImpl.createExternalApi(
              (com.google.cloud.apihub.v1.CreateExternalApiRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ExternalApi>)
                  responseObserver);
          break;
        case METHODID_GET_EXTERNAL_API:
          serviceImpl.getExternalApi(
              (com.google.cloud.apihub.v1.GetExternalApiRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ExternalApi>)
                  responseObserver);
          break;
        case METHODID_UPDATE_EXTERNAL_API:
          serviceImpl.updateExternalApi(
              (com.google.cloud.apihub.v1.UpdateExternalApiRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ExternalApi>)
                  responseObserver);
          break;
        case METHODID_DELETE_EXTERNAL_API:
          serviceImpl.deleteExternalApi(
              (com.google.cloud.apihub.v1.DeleteExternalApiRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_EXTERNAL_APIS:
          serviceImpl.listExternalApis(
              (com.google.cloud.apihub.v1.ListExternalApisRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ListExternalApisResponse>)
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
            getCreateApiMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.CreateApiRequest, com.google.cloud.apihub.v1.Api>(
                    service, METHODID_CREATE_API)))
        .addMethod(
            getGetApiMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.GetApiRequest, com.google.cloud.apihub.v1.Api>(
                    service, METHODID_GET_API)))
        .addMethod(
            getListApisMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.ListApisRequest,
                    com.google.cloud.apihub.v1.ListApisResponse>(service, METHODID_LIST_APIS)))
        .addMethod(
            getUpdateApiMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.UpdateApiRequest, com.google.cloud.apihub.v1.Api>(
                    service, METHODID_UPDATE_API)))
        .addMethod(
            getDeleteApiMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.DeleteApiRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_API)))
        .addMethod(
            getCreateVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.CreateVersionRequest,
                    com.google.cloud.apihub.v1.Version>(service, METHODID_CREATE_VERSION)))
        .addMethod(
            getGetVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.GetVersionRequest,
                    com.google.cloud.apihub.v1.Version>(service, METHODID_GET_VERSION)))
        .addMethod(
            getListVersionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.ListVersionsRequest,
                    com.google.cloud.apihub.v1.ListVersionsResponse>(
                    service, METHODID_LIST_VERSIONS)))
        .addMethod(
            getUpdateVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.UpdateVersionRequest,
                    com.google.cloud.apihub.v1.Version>(service, METHODID_UPDATE_VERSION)))
        .addMethod(
            getDeleteVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.DeleteVersionRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_VERSION)))
        .addMethod(
            getCreateSpecMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.CreateSpecRequest, com.google.cloud.apihub.v1.Spec>(
                    service, METHODID_CREATE_SPEC)))
        .addMethod(
            getGetSpecMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.GetSpecRequest, com.google.cloud.apihub.v1.Spec>(
                    service, METHODID_GET_SPEC)))
        .addMethod(
            getGetSpecContentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.GetSpecContentsRequest,
                    com.google.cloud.apihub.v1.SpecContents>(service, METHODID_GET_SPEC_CONTENTS)))
        .addMethod(
            getListSpecsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.ListSpecsRequest,
                    com.google.cloud.apihub.v1.ListSpecsResponse>(service, METHODID_LIST_SPECS)))
        .addMethod(
            getUpdateSpecMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.UpdateSpecRequest, com.google.cloud.apihub.v1.Spec>(
                    service, METHODID_UPDATE_SPEC)))
        .addMethod(
            getDeleteSpecMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.DeleteSpecRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_SPEC)))
        .addMethod(
            getGetApiOperationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.GetApiOperationRequest,
                    com.google.cloud.apihub.v1.ApiOperation>(service, METHODID_GET_API_OPERATION)))
        .addMethod(
            getListApiOperationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.ListApiOperationsRequest,
                    com.google.cloud.apihub.v1.ListApiOperationsResponse>(
                    service, METHODID_LIST_API_OPERATIONS)))
        .addMethod(
            getGetDefinitionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.GetDefinitionRequest,
                    com.google.cloud.apihub.v1.Definition>(service, METHODID_GET_DEFINITION)))
        .addMethod(
            getCreateDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.CreateDeploymentRequest,
                    com.google.cloud.apihub.v1.Deployment>(service, METHODID_CREATE_DEPLOYMENT)))
        .addMethod(
            getGetDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.GetDeploymentRequest,
                    com.google.cloud.apihub.v1.Deployment>(service, METHODID_GET_DEPLOYMENT)))
        .addMethod(
            getListDeploymentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.ListDeploymentsRequest,
                    com.google.cloud.apihub.v1.ListDeploymentsResponse>(
                    service, METHODID_LIST_DEPLOYMENTS)))
        .addMethod(
            getUpdateDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.UpdateDeploymentRequest,
                    com.google.cloud.apihub.v1.Deployment>(service, METHODID_UPDATE_DEPLOYMENT)))
        .addMethod(
            getDeleteDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.DeleteDeploymentRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_DEPLOYMENT)))
        .addMethod(
            getCreateAttributeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.CreateAttributeRequest,
                    com.google.cloud.apihub.v1.Attribute>(service, METHODID_CREATE_ATTRIBUTE)))
        .addMethod(
            getGetAttributeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.GetAttributeRequest,
                    com.google.cloud.apihub.v1.Attribute>(service, METHODID_GET_ATTRIBUTE)))
        .addMethod(
            getUpdateAttributeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.UpdateAttributeRequest,
                    com.google.cloud.apihub.v1.Attribute>(service, METHODID_UPDATE_ATTRIBUTE)))
        .addMethod(
            getDeleteAttributeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.DeleteAttributeRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_ATTRIBUTE)))
        .addMethod(
            getListAttributesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.ListAttributesRequest,
                    com.google.cloud.apihub.v1.ListAttributesResponse>(
                    service, METHODID_LIST_ATTRIBUTES)))
        .addMethod(
            getSearchResourcesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.SearchResourcesRequest,
                    com.google.cloud.apihub.v1.SearchResourcesResponse>(
                    service, METHODID_SEARCH_RESOURCES)))
        .addMethod(
            getCreateExternalApiMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.CreateExternalApiRequest,
                    com.google.cloud.apihub.v1.ExternalApi>(service, METHODID_CREATE_EXTERNAL_API)))
        .addMethod(
            getGetExternalApiMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.GetExternalApiRequest,
                    com.google.cloud.apihub.v1.ExternalApi>(service, METHODID_GET_EXTERNAL_API)))
        .addMethod(
            getUpdateExternalApiMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.UpdateExternalApiRequest,
                    com.google.cloud.apihub.v1.ExternalApi>(service, METHODID_UPDATE_EXTERNAL_API)))
        .addMethod(
            getDeleteExternalApiMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.DeleteExternalApiRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_EXTERNAL_API)))
        .addMethod(
            getListExternalApisMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.ListExternalApisRequest,
                    com.google.cloud.apihub.v1.ListExternalApisResponse>(
                    service, METHODID_LIST_EXTERNAL_APIS)))
        .build();
  }

  private abstract static class ApiHubBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ApiHubBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.apihub.v1.ApiHubServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ApiHub");
    }
  }

  private static final class ApiHubFileDescriptorSupplier extends ApiHubBaseDescriptorSupplier {
    ApiHubFileDescriptorSupplier() {}
  }

  private static final class ApiHubMethodDescriptorSupplier extends ApiHubBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ApiHubMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ApiHubGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ApiHubFileDescriptorSupplier())
                      .addMethod(getCreateApiMethod())
                      .addMethod(getGetApiMethod())
                      .addMethod(getListApisMethod())
                      .addMethod(getUpdateApiMethod())
                      .addMethod(getDeleteApiMethod())
                      .addMethod(getCreateVersionMethod())
                      .addMethod(getGetVersionMethod())
                      .addMethod(getListVersionsMethod())
                      .addMethod(getUpdateVersionMethod())
                      .addMethod(getDeleteVersionMethod())
                      .addMethod(getCreateSpecMethod())
                      .addMethod(getGetSpecMethod())
                      .addMethod(getGetSpecContentsMethod())
                      .addMethod(getListSpecsMethod())
                      .addMethod(getUpdateSpecMethod())
                      .addMethod(getDeleteSpecMethod())
                      .addMethod(getGetApiOperationMethod())
                      .addMethod(getListApiOperationsMethod())
                      .addMethod(getGetDefinitionMethod())
                      .addMethod(getCreateDeploymentMethod())
                      .addMethod(getGetDeploymentMethod())
                      .addMethod(getListDeploymentsMethod())
                      .addMethod(getUpdateDeploymentMethod())
                      .addMethod(getDeleteDeploymentMethod())
                      .addMethod(getCreateAttributeMethod())
                      .addMethod(getGetAttributeMethod())
                      .addMethod(getUpdateAttributeMethod())
                      .addMethod(getDeleteAttributeMethod())
                      .addMethod(getListAttributesMethod())
                      .addMethod(getSearchResourcesMethod())
                      .addMethod(getCreateExternalApiMethod())
                      .addMethod(getGetExternalApiMethod())
                      .addMethod(getUpdateExternalApiMethod())
                      .addMethod(getDeleteExternalApiMethod())
                      .addMethod(getListExternalApisMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
