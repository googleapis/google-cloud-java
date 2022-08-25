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
package com.google.cloud.apigeeregistry.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The Registry service allows teams to manage descriptions of APIs.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/apigeeregistry/v1/registry_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RegistryGrpc {

  private RegistryGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.apigeeregistry.v1.Registry";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.ListApisRequest,
          com.google.cloud.apigeeregistry.v1.ListApisResponse>
      getListApisMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListApis",
      requestType = com.google.cloud.apigeeregistry.v1.ListApisRequest.class,
      responseType = com.google.cloud.apigeeregistry.v1.ListApisResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.ListApisRequest,
          com.google.cloud.apigeeregistry.v1.ListApisResponse>
      getListApisMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.ListApisRequest,
            com.google.cloud.apigeeregistry.v1.ListApisResponse>
        getListApisMethod;
    if ((getListApisMethod = RegistryGrpc.getListApisMethod) == null) {
      synchronized (RegistryGrpc.class) {
        if ((getListApisMethod = RegistryGrpc.getListApisMethod) == null) {
          RegistryGrpc.getListApisMethod =
              getListApisMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.ListApisRequest,
                          com.google.cloud.apigeeregistry.v1.ListApisResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListApis"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.ListApisRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.ListApisResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new RegistryMethodDescriptorSupplier("ListApis"))
                      .build();
        }
      }
    }
    return getListApisMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.GetApiRequest, com.google.cloud.apigeeregistry.v1.Api>
      getGetApiMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetApi",
      requestType = com.google.cloud.apigeeregistry.v1.GetApiRequest.class,
      responseType = com.google.cloud.apigeeregistry.v1.Api.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.GetApiRequest, com.google.cloud.apigeeregistry.v1.Api>
      getGetApiMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.GetApiRequest,
            com.google.cloud.apigeeregistry.v1.Api>
        getGetApiMethod;
    if ((getGetApiMethod = RegistryGrpc.getGetApiMethod) == null) {
      synchronized (RegistryGrpc.class) {
        if ((getGetApiMethod = RegistryGrpc.getGetApiMethod) == null) {
          RegistryGrpc.getGetApiMethod =
              getGetApiMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.GetApiRequest,
                          com.google.cloud.apigeeregistry.v1.Api>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetApi"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.GetApiRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.Api.getDefaultInstance()))
                      .setSchemaDescriptor(new RegistryMethodDescriptorSupplier("GetApi"))
                      .build();
        }
      }
    }
    return getGetApiMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.CreateApiRequest,
          com.google.cloud.apigeeregistry.v1.Api>
      getCreateApiMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateApi",
      requestType = com.google.cloud.apigeeregistry.v1.CreateApiRequest.class,
      responseType = com.google.cloud.apigeeregistry.v1.Api.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.CreateApiRequest,
          com.google.cloud.apigeeregistry.v1.Api>
      getCreateApiMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.CreateApiRequest,
            com.google.cloud.apigeeregistry.v1.Api>
        getCreateApiMethod;
    if ((getCreateApiMethod = RegistryGrpc.getCreateApiMethod) == null) {
      synchronized (RegistryGrpc.class) {
        if ((getCreateApiMethod = RegistryGrpc.getCreateApiMethod) == null) {
          RegistryGrpc.getCreateApiMethod =
              getCreateApiMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.CreateApiRequest,
                          com.google.cloud.apigeeregistry.v1.Api>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateApi"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.CreateApiRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.Api.getDefaultInstance()))
                      .setSchemaDescriptor(new RegistryMethodDescriptorSupplier("CreateApi"))
                      .build();
        }
      }
    }
    return getCreateApiMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.UpdateApiRequest,
          com.google.cloud.apigeeregistry.v1.Api>
      getUpdateApiMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateApi",
      requestType = com.google.cloud.apigeeregistry.v1.UpdateApiRequest.class,
      responseType = com.google.cloud.apigeeregistry.v1.Api.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.UpdateApiRequest,
          com.google.cloud.apigeeregistry.v1.Api>
      getUpdateApiMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.UpdateApiRequest,
            com.google.cloud.apigeeregistry.v1.Api>
        getUpdateApiMethod;
    if ((getUpdateApiMethod = RegistryGrpc.getUpdateApiMethod) == null) {
      synchronized (RegistryGrpc.class) {
        if ((getUpdateApiMethod = RegistryGrpc.getUpdateApiMethod) == null) {
          RegistryGrpc.getUpdateApiMethod =
              getUpdateApiMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.UpdateApiRequest,
                          com.google.cloud.apigeeregistry.v1.Api>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateApi"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.UpdateApiRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.Api.getDefaultInstance()))
                      .setSchemaDescriptor(new RegistryMethodDescriptorSupplier("UpdateApi"))
                      .build();
        }
      }
    }
    return getUpdateApiMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.DeleteApiRequest, com.google.protobuf.Empty>
      getDeleteApiMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteApi",
      requestType = com.google.cloud.apigeeregistry.v1.DeleteApiRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.DeleteApiRequest, com.google.protobuf.Empty>
      getDeleteApiMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.DeleteApiRequest, com.google.protobuf.Empty>
        getDeleteApiMethod;
    if ((getDeleteApiMethod = RegistryGrpc.getDeleteApiMethod) == null) {
      synchronized (RegistryGrpc.class) {
        if ((getDeleteApiMethod = RegistryGrpc.getDeleteApiMethod) == null) {
          RegistryGrpc.getDeleteApiMethod =
              getDeleteApiMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.DeleteApiRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteApi"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.DeleteApiRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new RegistryMethodDescriptorSupplier("DeleteApi"))
                      .build();
        }
      }
    }
    return getDeleteApiMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.ListApiVersionsRequest,
          com.google.cloud.apigeeregistry.v1.ListApiVersionsResponse>
      getListApiVersionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListApiVersions",
      requestType = com.google.cloud.apigeeregistry.v1.ListApiVersionsRequest.class,
      responseType = com.google.cloud.apigeeregistry.v1.ListApiVersionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.ListApiVersionsRequest,
          com.google.cloud.apigeeregistry.v1.ListApiVersionsResponse>
      getListApiVersionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.ListApiVersionsRequest,
            com.google.cloud.apigeeregistry.v1.ListApiVersionsResponse>
        getListApiVersionsMethod;
    if ((getListApiVersionsMethod = RegistryGrpc.getListApiVersionsMethod) == null) {
      synchronized (RegistryGrpc.class) {
        if ((getListApiVersionsMethod = RegistryGrpc.getListApiVersionsMethod) == null) {
          RegistryGrpc.getListApiVersionsMethod =
              getListApiVersionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.ListApiVersionsRequest,
                          com.google.cloud.apigeeregistry.v1.ListApiVersionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListApiVersions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.ListApiVersionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.ListApiVersionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new RegistryMethodDescriptorSupplier("ListApiVersions"))
                      .build();
        }
      }
    }
    return getListApiVersionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.GetApiVersionRequest,
          com.google.cloud.apigeeregistry.v1.ApiVersion>
      getGetApiVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetApiVersion",
      requestType = com.google.cloud.apigeeregistry.v1.GetApiVersionRequest.class,
      responseType = com.google.cloud.apigeeregistry.v1.ApiVersion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.GetApiVersionRequest,
          com.google.cloud.apigeeregistry.v1.ApiVersion>
      getGetApiVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.GetApiVersionRequest,
            com.google.cloud.apigeeregistry.v1.ApiVersion>
        getGetApiVersionMethod;
    if ((getGetApiVersionMethod = RegistryGrpc.getGetApiVersionMethod) == null) {
      synchronized (RegistryGrpc.class) {
        if ((getGetApiVersionMethod = RegistryGrpc.getGetApiVersionMethod) == null) {
          RegistryGrpc.getGetApiVersionMethod =
              getGetApiVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.GetApiVersionRequest,
                          com.google.cloud.apigeeregistry.v1.ApiVersion>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetApiVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.GetApiVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.ApiVersion.getDefaultInstance()))
                      .setSchemaDescriptor(new RegistryMethodDescriptorSupplier("GetApiVersion"))
                      .build();
        }
      }
    }
    return getGetApiVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.CreateApiVersionRequest,
          com.google.cloud.apigeeregistry.v1.ApiVersion>
      getCreateApiVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateApiVersion",
      requestType = com.google.cloud.apigeeregistry.v1.CreateApiVersionRequest.class,
      responseType = com.google.cloud.apigeeregistry.v1.ApiVersion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.CreateApiVersionRequest,
          com.google.cloud.apigeeregistry.v1.ApiVersion>
      getCreateApiVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.CreateApiVersionRequest,
            com.google.cloud.apigeeregistry.v1.ApiVersion>
        getCreateApiVersionMethod;
    if ((getCreateApiVersionMethod = RegistryGrpc.getCreateApiVersionMethod) == null) {
      synchronized (RegistryGrpc.class) {
        if ((getCreateApiVersionMethod = RegistryGrpc.getCreateApiVersionMethod) == null) {
          RegistryGrpc.getCreateApiVersionMethod =
              getCreateApiVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.CreateApiVersionRequest,
                          com.google.cloud.apigeeregistry.v1.ApiVersion>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateApiVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.CreateApiVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.ApiVersion.getDefaultInstance()))
                      .setSchemaDescriptor(new RegistryMethodDescriptorSupplier("CreateApiVersion"))
                      .build();
        }
      }
    }
    return getCreateApiVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.UpdateApiVersionRequest,
          com.google.cloud.apigeeregistry.v1.ApiVersion>
      getUpdateApiVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateApiVersion",
      requestType = com.google.cloud.apigeeregistry.v1.UpdateApiVersionRequest.class,
      responseType = com.google.cloud.apigeeregistry.v1.ApiVersion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.UpdateApiVersionRequest,
          com.google.cloud.apigeeregistry.v1.ApiVersion>
      getUpdateApiVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.UpdateApiVersionRequest,
            com.google.cloud.apigeeregistry.v1.ApiVersion>
        getUpdateApiVersionMethod;
    if ((getUpdateApiVersionMethod = RegistryGrpc.getUpdateApiVersionMethod) == null) {
      synchronized (RegistryGrpc.class) {
        if ((getUpdateApiVersionMethod = RegistryGrpc.getUpdateApiVersionMethod) == null) {
          RegistryGrpc.getUpdateApiVersionMethod =
              getUpdateApiVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.UpdateApiVersionRequest,
                          com.google.cloud.apigeeregistry.v1.ApiVersion>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateApiVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.UpdateApiVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.ApiVersion.getDefaultInstance()))
                      .setSchemaDescriptor(new RegistryMethodDescriptorSupplier("UpdateApiVersion"))
                      .build();
        }
      }
    }
    return getUpdateApiVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.DeleteApiVersionRequest, com.google.protobuf.Empty>
      getDeleteApiVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteApiVersion",
      requestType = com.google.cloud.apigeeregistry.v1.DeleteApiVersionRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.DeleteApiVersionRequest, com.google.protobuf.Empty>
      getDeleteApiVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.DeleteApiVersionRequest, com.google.protobuf.Empty>
        getDeleteApiVersionMethod;
    if ((getDeleteApiVersionMethod = RegistryGrpc.getDeleteApiVersionMethod) == null) {
      synchronized (RegistryGrpc.class) {
        if ((getDeleteApiVersionMethod = RegistryGrpc.getDeleteApiVersionMethod) == null) {
          RegistryGrpc.getDeleteApiVersionMethod =
              getDeleteApiVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.DeleteApiVersionRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteApiVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.DeleteApiVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new RegistryMethodDescriptorSupplier("DeleteApiVersion"))
                      .build();
        }
      }
    }
    return getDeleteApiVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.ListApiSpecsRequest,
          com.google.cloud.apigeeregistry.v1.ListApiSpecsResponse>
      getListApiSpecsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListApiSpecs",
      requestType = com.google.cloud.apigeeregistry.v1.ListApiSpecsRequest.class,
      responseType = com.google.cloud.apigeeregistry.v1.ListApiSpecsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.ListApiSpecsRequest,
          com.google.cloud.apigeeregistry.v1.ListApiSpecsResponse>
      getListApiSpecsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.ListApiSpecsRequest,
            com.google.cloud.apigeeregistry.v1.ListApiSpecsResponse>
        getListApiSpecsMethod;
    if ((getListApiSpecsMethod = RegistryGrpc.getListApiSpecsMethod) == null) {
      synchronized (RegistryGrpc.class) {
        if ((getListApiSpecsMethod = RegistryGrpc.getListApiSpecsMethod) == null) {
          RegistryGrpc.getListApiSpecsMethod =
              getListApiSpecsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.ListApiSpecsRequest,
                          com.google.cloud.apigeeregistry.v1.ListApiSpecsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListApiSpecs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.ListApiSpecsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.ListApiSpecsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new RegistryMethodDescriptorSupplier("ListApiSpecs"))
                      .build();
        }
      }
    }
    return getListApiSpecsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.GetApiSpecRequest,
          com.google.cloud.apigeeregistry.v1.ApiSpec>
      getGetApiSpecMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetApiSpec",
      requestType = com.google.cloud.apigeeregistry.v1.GetApiSpecRequest.class,
      responseType = com.google.cloud.apigeeregistry.v1.ApiSpec.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.GetApiSpecRequest,
          com.google.cloud.apigeeregistry.v1.ApiSpec>
      getGetApiSpecMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.GetApiSpecRequest,
            com.google.cloud.apigeeregistry.v1.ApiSpec>
        getGetApiSpecMethod;
    if ((getGetApiSpecMethod = RegistryGrpc.getGetApiSpecMethod) == null) {
      synchronized (RegistryGrpc.class) {
        if ((getGetApiSpecMethod = RegistryGrpc.getGetApiSpecMethod) == null) {
          RegistryGrpc.getGetApiSpecMethod =
              getGetApiSpecMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.GetApiSpecRequest,
                          com.google.cloud.apigeeregistry.v1.ApiSpec>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetApiSpec"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.GetApiSpecRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.ApiSpec.getDefaultInstance()))
                      .setSchemaDescriptor(new RegistryMethodDescriptorSupplier("GetApiSpec"))
                      .build();
        }
      }
    }
    return getGetApiSpecMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.GetApiSpecContentsRequest, com.google.api.HttpBody>
      getGetApiSpecContentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetApiSpecContents",
      requestType = com.google.cloud.apigeeregistry.v1.GetApiSpecContentsRequest.class,
      responseType = com.google.api.HttpBody.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.GetApiSpecContentsRequest, com.google.api.HttpBody>
      getGetApiSpecContentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.GetApiSpecContentsRequest, com.google.api.HttpBody>
        getGetApiSpecContentsMethod;
    if ((getGetApiSpecContentsMethod = RegistryGrpc.getGetApiSpecContentsMethod) == null) {
      synchronized (RegistryGrpc.class) {
        if ((getGetApiSpecContentsMethod = RegistryGrpc.getGetApiSpecContentsMethod) == null) {
          RegistryGrpc.getGetApiSpecContentsMethod =
              getGetApiSpecContentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.GetApiSpecContentsRequest,
                          com.google.api.HttpBody>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetApiSpecContents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.GetApiSpecContentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.api.HttpBody.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegistryMethodDescriptorSupplier("GetApiSpecContents"))
                      .build();
        }
      }
    }
    return getGetApiSpecContentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.CreateApiSpecRequest,
          com.google.cloud.apigeeregistry.v1.ApiSpec>
      getCreateApiSpecMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateApiSpec",
      requestType = com.google.cloud.apigeeregistry.v1.CreateApiSpecRequest.class,
      responseType = com.google.cloud.apigeeregistry.v1.ApiSpec.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.CreateApiSpecRequest,
          com.google.cloud.apigeeregistry.v1.ApiSpec>
      getCreateApiSpecMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.CreateApiSpecRequest,
            com.google.cloud.apigeeregistry.v1.ApiSpec>
        getCreateApiSpecMethod;
    if ((getCreateApiSpecMethod = RegistryGrpc.getCreateApiSpecMethod) == null) {
      synchronized (RegistryGrpc.class) {
        if ((getCreateApiSpecMethod = RegistryGrpc.getCreateApiSpecMethod) == null) {
          RegistryGrpc.getCreateApiSpecMethod =
              getCreateApiSpecMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.CreateApiSpecRequest,
                          com.google.cloud.apigeeregistry.v1.ApiSpec>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateApiSpec"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.CreateApiSpecRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.ApiSpec.getDefaultInstance()))
                      .setSchemaDescriptor(new RegistryMethodDescriptorSupplier("CreateApiSpec"))
                      .build();
        }
      }
    }
    return getCreateApiSpecMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.UpdateApiSpecRequest,
          com.google.cloud.apigeeregistry.v1.ApiSpec>
      getUpdateApiSpecMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateApiSpec",
      requestType = com.google.cloud.apigeeregistry.v1.UpdateApiSpecRequest.class,
      responseType = com.google.cloud.apigeeregistry.v1.ApiSpec.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.UpdateApiSpecRequest,
          com.google.cloud.apigeeregistry.v1.ApiSpec>
      getUpdateApiSpecMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.UpdateApiSpecRequest,
            com.google.cloud.apigeeregistry.v1.ApiSpec>
        getUpdateApiSpecMethod;
    if ((getUpdateApiSpecMethod = RegistryGrpc.getUpdateApiSpecMethod) == null) {
      synchronized (RegistryGrpc.class) {
        if ((getUpdateApiSpecMethod = RegistryGrpc.getUpdateApiSpecMethod) == null) {
          RegistryGrpc.getUpdateApiSpecMethod =
              getUpdateApiSpecMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.UpdateApiSpecRequest,
                          com.google.cloud.apigeeregistry.v1.ApiSpec>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateApiSpec"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.UpdateApiSpecRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.ApiSpec.getDefaultInstance()))
                      .setSchemaDescriptor(new RegistryMethodDescriptorSupplier("UpdateApiSpec"))
                      .build();
        }
      }
    }
    return getUpdateApiSpecMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.DeleteApiSpecRequest, com.google.protobuf.Empty>
      getDeleteApiSpecMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteApiSpec",
      requestType = com.google.cloud.apigeeregistry.v1.DeleteApiSpecRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.DeleteApiSpecRequest, com.google.protobuf.Empty>
      getDeleteApiSpecMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.DeleteApiSpecRequest, com.google.protobuf.Empty>
        getDeleteApiSpecMethod;
    if ((getDeleteApiSpecMethod = RegistryGrpc.getDeleteApiSpecMethod) == null) {
      synchronized (RegistryGrpc.class) {
        if ((getDeleteApiSpecMethod = RegistryGrpc.getDeleteApiSpecMethod) == null) {
          RegistryGrpc.getDeleteApiSpecMethod =
              getDeleteApiSpecMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.DeleteApiSpecRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteApiSpec"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.DeleteApiSpecRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new RegistryMethodDescriptorSupplier("DeleteApiSpec"))
                      .build();
        }
      }
    }
    return getDeleteApiSpecMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.TagApiSpecRevisionRequest,
          com.google.cloud.apigeeregistry.v1.ApiSpec>
      getTagApiSpecRevisionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TagApiSpecRevision",
      requestType = com.google.cloud.apigeeregistry.v1.TagApiSpecRevisionRequest.class,
      responseType = com.google.cloud.apigeeregistry.v1.ApiSpec.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.TagApiSpecRevisionRequest,
          com.google.cloud.apigeeregistry.v1.ApiSpec>
      getTagApiSpecRevisionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.TagApiSpecRevisionRequest,
            com.google.cloud.apigeeregistry.v1.ApiSpec>
        getTagApiSpecRevisionMethod;
    if ((getTagApiSpecRevisionMethod = RegistryGrpc.getTagApiSpecRevisionMethod) == null) {
      synchronized (RegistryGrpc.class) {
        if ((getTagApiSpecRevisionMethod = RegistryGrpc.getTagApiSpecRevisionMethod) == null) {
          RegistryGrpc.getTagApiSpecRevisionMethod =
              getTagApiSpecRevisionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.TagApiSpecRevisionRequest,
                          com.google.cloud.apigeeregistry.v1.ApiSpec>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TagApiSpecRevision"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.TagApiSpecRevisionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.ApiSpec.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegistryMethodDescriptorSupplier("TagApiSpecRevision"))
                      .build();
        }
      }
    }
    return getTagApiSpecRevisionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.ListApiSpecRevisionsRequest,
          com.google.cloud.apigeeregistry.v1.ListApiSpecRevisionsResponse>
      getListApiSpecRevisionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListApiSpecRevisions",
      requestType = com.google.cloud.apigeeregistry.v1.ListApiSpecRevisionsRequest.class,
      responseType = com.google.cloud.apigeeregistry.v1.ListApiSpecRevisionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.ListApiSpecRevisionsRequest,
          com.google.cloud.apigeeregistry.v1.ListApiSpecRevisionsResponse>
      getListApiSpecRevisionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.ListApiSpecRevisionsRequest,
            com.google.cloud.apigeeregistry.v1.ListApiSpecRevisionsResponse>
        getListApiSpecRevisionsMethod;
    if ((getListApiSpecRevisionsMethod = RegistryGrpc.getListApiSpecRevisionsMethod) == null) {
      synchronized (RegistryGrpc.class) {
        if ((getListApiSpecRevisionsMethod = RegistryGrpc.getListApiSpecRevisionsMethod) == null) {
          RegistryGrpc.getListApiSpecRevisionsMethod =
              getListApiSpecRevisionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.ListApiSpecRevisionsRequest,
                          com.google.cloud.apigeeregistry.v1.ListApiSpecRevisionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListApiSpecRevisions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.ListApiSpecRevisionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.ListApiSpecRevisionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegistryMethodDescriptorSupplier("ListApiSpecRevisions"))
                      .build();
        }
      }
    }
    return getListApiSpecRevisionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.RollbackApiSpecRequest,
          com.google.cloud.apigeeregistry.v1.ApiSpec>
      getRollbackApiSpecMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RollbackApiSpec",
      requestType = com.google.cloud.apigeeregistry.v1.RollbackApiSpecRequest.class,
      responseType = com.google.cloud.apigeeregistry.v1.ApiSpec.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.RollbackApiSpecRequest,
          com.google.cloud.apigeeregistry.v1.ApiSpec>
      getRollbackApiSpecMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.RollbackApiSpecRequest,
            com.google.cloud.apigeeregistry.v1.ApiSpec>
        getRollbackApiSpecMethod;
    if ((getRollbackApiSpecMethod = RegistryGrpc.getRollbackApiSpecMethod) == null) {
      synchronized (RegistryGrpc.class) {
        if ((getRollbackApiSpecMethod = RegistryGrpc.getRollbackApiSpecMethod) == null) {
          RegistryGrpc.getRollbackApiSpecMethod =
              getRollbackApiSpecMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.RollbackApiSpecRequest,
                          com.google.cloud.apigeeregistry.v1.ApiSpec>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RollbackApiSpec"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.RollbackApiSpecRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.ApiSpec.getDefaultInstance()))
                      .setSchemaDescriptor(new RegistryMethodDescriptorSupplier("RollbackApiSpec"))
                      .build();
        }
      }
    }
    return getRollbackApiSpecMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.DeleteApiSpecRevisionRequest,
          com.google.cloud.apigeeregistry.v1.ApiSpec>
      getDeleteApiSpecRevisionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteApiSpecRevision",
      requestType = com.google.cloud.apigeeregistry.v1.DeleteApiSpecRevisionRequest.class,
      responseType = com.google.cloud.apigeeregistry.v1.ApiSpec.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.DeleteApiSpecRevisionRequest,
          com.google.cloud.apigeeregistry.v1.ApiSpec>
      getDeleteApiSpecRevisionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.DeleteApiSpecRevisionRequest,
            com.google.cloud.apigeeregistry.v1.ApiSpec>
        getDeleteApiSpecRevisionMethod;
    if ((getDeleteApiSpecRevisionMethod = RegistryGrpc.getDeleteApiSpecRevisionMethod) == null) {
      synchronized (RegistryGrpc.class) {
        if ((getDeleteApiSpecRevisionMethod = RegistryGrpc.getDeleteApiSpecRevisionMethod)
            == null) {
          RegistryGrpc.getDeleteApiSpecRevisionMethod =
              getDeleteApiSpecRevisionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.DeleteApiSpecRevisionRequest,
                          com.google.cloud.apigeeregistry.v1.ApiSpec>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteApiSpecRevision"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.DeleteApiSpecRevisionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.ApiSpec.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegistryMethodDescriptorSupplier("DeleteApiSpecRevision"))
                      .build();
        }
      }
    }
    return getDeleteApiSpecRevisionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.ListApiDeploymentsRequest,
          com.google.cloud.apigeeregistry.v1.ListApiDeploymentsResponse>
      getListApiDeploymentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListApiDeployments",
      requestType = com.google.cloud.apigeeregistry.v1.ListApiDeploymentsRequest.class,
      responseType = com.google.cloud.apigeeregistry.v1.ListApiDeploymentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.ListApiDeploymentsRequest,
          com.google.cloud.apigeeregistry.v1.ListApiDeploymentsResponse>
      getListApiDeploymentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.ListApiDeploymentsRequest,
            com.google.cloud.apigeeregistry.v1.ListApiDeploymentsResponse>
        getListApiDeploymentsMethod;
    if ((getListApiDeploymentsMethod = RegistryGrpc.getListApiDeploymentsMethod) == null) {
      synchronized (RegistryGrpc.class) {
        if ((getListApiDeploymentsMethod = RegistryGrpc.getListApiDeploymentsMethod) == null) {
          RegistryGrpc.getListApiDeploymentsMethod =
              getListApiDeploymentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.ListApiDeploymentsRequest,
                          com.google.cloud.apigeeregistry.v1.ListApiDeploymentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListApiDeployments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.ListApiDeploymentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.ListApiDeploymentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegistryMethodDescriptorSupplier("ListApiDeployments"))
                      .build();
        }
      }
    }
    return getListApiDeploymentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.GetApiDeploymentRequest,
          com.google.cloud.apigeeregistry.v1.ApiDeployment>
      getGetApiDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetApiDeployment",
      requestType = com.google.cloud.apigeeregistry.v1.GetApiDeploymentRequest.class,
      responseType = com.google.cloud.apigeeregistry.v1.ApiDeployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.GetApiDeploymentRequest,
          com.google.cloud.apigeeregistry.v1.ApiDeployment>
      getGetApiDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.GetApiDeploymentRequest,
            com.google.cloud.apigeeregistry.v1.ApiDeployment>
        getGetApiDeploymentMethod;
    if ((getGetApiDeploymentMethod = RegistryGrpc.getGetApiDeploymentMethod) == null) {
      synchronized (RegistryGrpc.class) {
        if ((getGetApiDeploymentMethod = RegistryGrpc.getGetApiDeploymentMethod) == null) {
          RegistryGrpc.getGetApiDeploymentMethod =
              getGetApiDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.GetApiDeploymentRequest,
                          com.google.cloud.apigeeregistry.v1.ApiDeployment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetApiDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.GetApiDeploymentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.ApiDeployment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new RegistryMethodDescriptorSupplier("GetApiDeployment"))
                      .build();
        }
      }
    }
    return getGetApiDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.CreateApiDeploymentRequest,
          com.google.cloud.apigeeregistry.v1.ApiDeployment>
      getCreateApiDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateApiDeployment",
      requestType = com.google.cloud.apigeeregistry.v1.CreateApiDeploymentRequest.class,
      responseType = com.google.cloud.apigeeregistry.v1.ApiDeployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.CreateApiDeploymentRequest,
          com.google.cloud.apigeeregistry.v1.ApiDeployment>
      getCreateApiDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.CreateApiDeploymentRequest,
            com.google.cloud.apigeeregistry.v1.ApiDeployment>
        getCreateApiDeploymentMethod;
    if ((getCreateApiDeploymentMethod = RegistryGrpc.getCreateApiDeploymentMethod) == null) {
      synchronized (RegistryGrpc.class) {
        if ((getCreateApiDeploymentMethod = RegistryGrpc.getCreateApiDeploymentMethod) == null) {
          RegistryGrpc.getCreateApiDeploymentMethod =
              getCreateApiDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.CreateApiDeploymentRequest,
                          com.google.cloud.apigeeregistry.v1.ApiDeployment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateApiDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.CreateApiDeploymentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.ApiDeployment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegistryMethodDescriptorSupplier("CreateApiDeployment"))
                      .build();
        }
      }
    }
    return getCreateApiDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.UpdateApiDeploymentRequest,
          com.google.cloud.apigeeregistry.v1.ApiDeployment>
      getUpdateApiDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateApiDeployment",
      requestType = com.google.cloud.apigeeregistry.v1.UpdateApiDeploymentRequest.class,
      responseType = com.google.cloud.apigeeregistry.v1.ApiDeployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.UpdateApiDeploymentRequest,
          com.google.cloud.apigeeregistry.v1.ApiDeployment>
      getUpdateApiDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.UpdateApiDeploymentRequest,
            com.google.cloud.apigeeregistry.v1.ApiDeployment>
        getUpdateApiDeploymentMethod;
    if ((getUpdateApiDeploymentMethod = RegistryGrpc.getUpdateApiDeploymentMethod) == null) {
      synchronized (RegistryGrpc.class) {
        if ((getUpdateApiDeploymentMethod = RegistryGrpc.getUpdateApiDeploymentMethod) == null) {
          RegistryGrpc.getUpdateApiDeploymentMethod =
              getUpdateApiDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.UpdateApiDeploymentRequest,
                          com.google.cloud.apigeeregistry.v1.ApiDeployment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateApiDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.UpdateApiDeploymentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.ApiDeployment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegistryMethodDescriptorSupplier("UpdateApiDeployment"))
                      .build();
        }
      }
    }
    return getUpdateApiDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.DeleteApiDeploymentRequest, com.google.protobuf.Empty>
      getDeleteApiDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteApiDeployment",
      requestType = com.google.cloud.apigeeregistry.v1.DeleteApiDeploymentRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.DeleteApiDeploymentRequest, com.google.protobuf.Empty>
      getDeleteApiDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.DeleteApiDeploymentRequest,
            com.google.protobuf.Empty>
        getDeleteApiDeploymentMethod;
    if ((getDeleteApiDeploymentMethod = RegistryGrpc.getDeleteApiDeploymentMethod) == null) {
      synchronized (RegistryGrpc.class) {
        if ((getDeleteApiDeploymentMethod = RegistryGrpc.getDeleteApiDeploymentMethod) == null) {
          RegistryGrpc.getDeleteApiDeploymentMethod =
              getDeleteApiDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.DeleteApiDeploymentRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteApiDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.DeleteApiDeploymentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegistryMethodDescriptorSupplier("DeleteApiDeployment"))
                      .build();
        }
      }
    }
    return getDeleteApiDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.TagApiDeploymentRevisionRequest,
          com.google.cloud.apigeeregistry.v1.ApiDeployment>
      getTagApiDeploymentRevisionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TagApiDeploymentRevision",
      requestType = com.google.cloud.apigeeregistry.v1.TagApiDeploymentRevisionRequest.class,
      responseType = com.google.cloud.apigeeregistry.v1.ApiDeployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.TagApiDeploymentRevisionRequest,
          com.google.cloud.apigeeregistry.v1.ApiDeployment>
      getTagApiDeploymentRevisionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.TagApiDeploymentRevisionRequest,
            com.google.cloud.apigeeregistry.v1.ApiDeployment>
        getTagApiDeploymentRevisionMethod;
    if ((getTagApiDeploymentRevisionMethod = RegistryGrpc.getTagApiDeploymentRevisionMethod)
        == null) {
      synchronized (RegistryGrpc.class) {
        if ((getTagApiDeploymentRevisionMethod = RegistryGrpc.getTagApiDeploymentRevisionMethod)
            == null) {
          RegistryGrpc.getTagApiDeploymentRevisionMethod =
              getTagApiDeploymentRevisionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.TagApiDeploymentRevisionRequest,
                          com.google.cloud.apigeeregistry.v1.ApiDeployment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "TagApiDeploymentRevision"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.TagApiDeploymentRevisionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.ApiDeployment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegistryMethodDescriptorSupplier("TagApiDeploymentRevision"))
                      .build();
        }
      }
    }
    return getTagApiDeploymentRevisionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.ListApiDeploymentRevisionsRequest,
          com.google.cloud.apigeeregistry.v1.ListApiDeploymentRevisionsResponse>
      getListApiDeploymentRevisionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListApiDeploymentRevisions",
      requestType = com.google.cloud.apigeeregistry.v1.ListApiDeploymentRevisionsRequest.class,
      responseType = com.google.cloud.apigeeregistry.v1.ListApiDeploymentRevisionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.ListApiDeploymentRevisionsRequest,
          com.google.cloud.apigeeregistry.v1.ListApiDeploymentRevisionsResponse>
      getListApiDeploymentRevisionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.ListApiDeploymentRevisionsRequest,
            com.google.cloud.apigeeregistry.v1.ListApiDeploymentRevisionsResponse>
        getListApiDeploymentRevisionsMethod;
    if ((getListApiDeploymentRevisionsMethod = RegistryGrpc.getListApiDeploymentRevisionsMethod)
        == null) {
      synchronized (RegistryGrpc.class) {
        if ((getListApiDeploymentRevisionsMethod = RegistryGrpc.getListApiDeploymentRevisionsMethod)
            == null) {
          RegistryGrpc.getListApiDeploymentRevisionsMethod =
              getListApiDeploymentRevisionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.ListApiDeploymentRevisionsRequest,
                          com.google.cloud.apigeeregistry.v1.ListApiDeploymentRevisionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListApiDeploymentRevisions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.ListApiDeploymentRevisionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.ListApiDeploymentRevisionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegistryMethodDescriptorSupplier("ListApiDeploymentRevisions"))
                      .build();
        }
      }
    }
    return getListApiDeploymentRevisionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.RollbackApiDeploymentRequest,
          com.google.cloud.apigeeregistry.v1.ApiDeployment>
      getRollbackApiDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RollbackApiDeployment",
      requestType = com.google.cloud.apigeeregistry.v1.RollbackApiDeploymentRequest.class,
      responseType = com.google.cloud.apigeeregistry.v1.ApiDeployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.RollbackApiDeploymentRequest,
          com.google.cloud.apigeeregistry.v1.ApiDeployment>
      getRollbackApiDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.RollbackApiDeploymentRequest,
            com.google.cloud.apigeeregistry.v1.ApiDeployment>
        getRollbackApiDeploymentMethod;
    if ((getRollbackApiDeploymentMethod = RegistryGrpc.getRollbackApiDeploymentMethod) == null) {
      synchronized (RegistryGrpc.class) {
        if ((getRollbackApiDeploymentMethod = RegistryGrpc.getRollbackApiDeploymentMethod)
            == null) {
          RegistryGrpc.getRollbackApiDeploymentMethod =
              getRollbackApiDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.RollbackApiDeploymentRequest,
                          com.google.cloud.apigeeregistry.v1.ApiDeployment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RollbackApiDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.RollbackApiDeploymentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.ApiDeployment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegistryMethodDescriptorSupplier("RollbackApiDeployment"))
                      .build();
        }
      }
    }
    return getRollbackApiDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.DeleteApiDeploymentRevisionRequest,
          com.google.cloud.apigeeregistry.v1.ApiDeployment>
      getDeleteApiDeploymentRevisionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteApiDeploymentRevision",
      requestType = com.google.cloud.apigeeregistry.v1.DeleteApiDeploymentRevisionRequest.class,
      responseType = com.google.cloud.apigeeregistry.v1.ApiDeployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.DeleteApiDeploymentRevisionRequest,
          com.google.cloud.apigeeregistry.v1.ApiDeployment>
      getDeleteApiDeploymentRevisionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.DeleteApiDeploymentRevisionRequest,
            com.google.cloud.apigeeregistry.v1.ApiDeployment>
        getDeleteApiDeploymentRevisionMethod;
    if ((getDeleteApiDeploymentRevisionMethod = RegistryGrpc.getDeleteApiDeploymentRevisionMethod)
        == null) {
      synchronized (RegistryGrpc.class) {
        if ((getDeleteApiDeploymentRevisionMethod =
                RegistryGrpc.getDeleteApiDeploymentRevisionMethod)
            == null) {
          RegistryGrpc.getDeleteApiDeploymentRevisionMethod =
              getDeleteApiDeploymentRevisionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.DeleteApiDeploymentRevisionRequest,
                          com.google.cloud.apigeeregistry.v1.ApiDeployment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteApiDeploymentRevision"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.DeleteApiDeploymentRevisionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.ApiDeployment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegistryMethodDescriptorSupplier("DeleteApiDeploymentRevision"))
                      .build();
        }
      }
    }
    return getDeleteApiDeploymentRevisionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.ListArtifactsRequest,
          com.google.cloud.apigeeregistry.v1.ListArtifactsResponse>
      getListArtifactsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListArtifacts",
      requestType = com.google.cloud.apigeeregistry.v1.ListArtifactsRequest.class,
      responseType = com.google.cloud.apigeeregistry.v1.ListArtifactsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.ListArtifactsRequest,
          com.google.cloud.apigeeregistry.v1.ListArtifactsResponse>
      getListArtifactsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.ListArtifactsRequest,
            com.google.cloud.apigeeregistry.v1.ListArtifactsResponse>
        getListArtifactsMethod;
    if ((getListArtifactsMethod = RegistryGrpc.getListArtifactsMethod) == null) {
      synchronized (RegistryGrpc.class) {
        if ((getListArtifactsMethod = RegistryGrpc.getListArtifactsMethod) == null) {
          RegistryGrpc.getListArtifactsMethod =
              getListArtifactsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.ListArtifactsRequest,
                          com.google.cloud.apigeeregistry.v1.ListArtifactsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListArtifacts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.ListArtifactsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.ListArtifactsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new RegistryMethodDescriptorSupplier("ListArtifacts"))
                      .build();
        }
      }
    }
    return getListArtifactsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.GetArtifactRequest,
          com.google.cloud.apigeeregistry.v1.Artifact>
      getGetArtifactMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetArtifact",
      requestType = com.google.cloud.apigeeregistry.v1.GetArtifactRequest.class,
      responseType = com.google.cloud.apigeeregistry.v1.Artifact.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.GetArtifactRequest,
          com.google.cloud.apigeeregistry.v1.Artifact>
      getGetArtifactMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.GetArtifactRequest,
            com.google.cloud.apigeeregistry.v1.Artifact>
        getGetArtifactMethod;
    if ((getGetArtifactMethod = RegistryGrpc.getGetArtifactMethod) == null) {
      synchronized (RegistryGrpc.class) {
        if ((getGetArtifactMethod = RegistryGrpc.getGetArtifactMethod) == null) {
          RegistryGrpc.getGetArtifactMethod =
              getGetArtifactMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.GetArtifactRequest,
                          com.google.cloud.apigeeregistry.v1.Artifact>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetArtifact"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.GetArtifactRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.Artifact.getDefaultInstance()))
                      .setSchemaDescriptor(new RegistryMethodDescriptorSupplier("GetArtifact"))
                      .build();
        }
      }
    }
    return getGetArtifactMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.GetArtifactContentsRequest, com.google.api.HttpBody>
      getGetArtifactContentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetArtifactContents",
      requestType = com.google.cloud.apigeeregistry.v1.GetArtifactContentsRequest.class,
      responseType = com.google.api.HttpBody.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.GetArtifactContentsRequest, com.google.api.HttpBody>
      getGetArtifactContentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.GetArtifactContentsRequest, com.google.api.HttpBody>
        getGetArtifactContentsMethod;
    if ((getGetArtifactContentsMethod = RegistryGrpc.getGetArtifactContentsMethod) == null) {
      synchronized (RegistryGrpc.class) {
        if ((getGetArtifactContentsMethod = RegistryGrpc.getGetArtifactContentsMethod) == null) {
          RegistryGrpc.getGetArtifactContentsMethod =
              getGetArtifactContentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.GetArtifactContentsRequest,
                          com.google.api.HttpBody>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetArtifactContents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.GetArtifactContentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.api.HttpBody.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegistryMethodDescriptorSupplier("GetArtifactContents"))
                      .build();
        }
      }
    }
    return getGetArtifactContentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.CreateArtifactRequest,
          com.google.cloud.apigeeregistry.v1.Artifact>
      getCreateArtifactMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateArtifact",
      requestType = com.google.cloud.apigeeregistry.v1.CreateArtifactRequest.class,
      responseType = com.google.cloud.apigeeregistry.v1.Artifact.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.CreateArtifactRequest,
          com.google.cloud.apigeeregistry.v1.Artifact>
      getCreateArtifactMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.CreateArtifactRequest,
            com.google.cloud.apigeeregistry.v1.Artifact>
        getCreateArtifactMethod;
    if ((getCreateArtifactMethod = RegistryGrpc.getCreateArtifactMethod) == null) {
      synchronized (RegistryGrpc.class) {
        if ((getCreateArtifactMethod = RegistryGrpc.getCreateArtifactMethod) == null) {
          RegistryGrpc.getCreateArtifactMethod =
              getCreateArtifactMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.CreateArtifactRequest,
                          com.google.cloud.apigeeregistry.v1.Artifact>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateArtifact"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.CreateArtifactRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.Artifact.getDefaultInstance()))
                      .setSchemaDescriptor(new RegistryMethodDescriptorSupplier("CreateArtifact"))
                      .build();
        }
      }
    }
    return getCreateArtifactMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.ReplaceArtifactRequest,
          com.google.cloud.apigeeregistry.v1.Artifact>
      getReplaceArtifactMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReplaceArtifact",
      requestType = com.google.cloud.apigeeregistry.v1.ReplaceArtifactRequest.class,
      responseType = com.google.cloud.apigeeregistry.v1.Artifact.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.ReplaceArtifactRequest,
          com.google.cloud.apigeeregistry.v1.Artifact>
      getReplaceArtifactMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.ReplaceArtifactRequest,
            com.google.cloud.apigeeregistry.v1.Artifact>
        getReplaceArtifactMethod;
    if ((getReplaceArtifactMethod = RegistryGrpc.getReplaceArtifactMethod) == null) {
      synchronized (RegistryGrpc.class) {
        if ((getReplaceArtifactMethod = RegistryGrpc.getReplaceArtifactMethod) == null) {
          RegistryGrpc.getReplaceArtifactMethod =
              getReplaceArtifactMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.ReplaceArtifactRequest,
                          com.google.cloud.apigeeregistry.v1.Artifact>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReplaceArtifact"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.ReplaceArtifactRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.Artifact.getDefaultInstance()))
                      .setSchemaDescriptor(new RegistryMethodDescriptorSupplier("ReplaceArtifact"))
                      .build();
        }
      }
    }
    return getReplaceArtifactMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.DeleteArtifactRequest, com.google.protobuf.Empty>
      getDeleteArtifactMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteArtifact",
      requestType = com.google.cloud.apigeeregistry.v1.DeleteArtifactRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeregistry.v1.DeleteArtifactRequest, com.google.protobuf.Empty>
      getDeleteArtifactMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeregistry.v1.DeleteArtifactRequest, com.google.protobuf.Empty>
        getDeleteArtifactMethod;
    if ((getDeleteArtifactMethod = RegistryGrpc.getDeleteArtifactMethod) == null) {
      synchronized (RegistryGrpc.class) {
        if ((getDeleteArtifactMethod = RegistryGrpc.getDeleteArtifactMethod) == null) {
          RegistryGrpc.getDeleteArtifactMethod =
              getDeleteArtifactMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeregistry.v1.DeleteArtifactRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteArtifact"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeregistry.v1.DeleteArtifactRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new RegistryMethodDescriptorSupplier("DeleteArtifact"))
                      .build();
        }
      }
    }
    return getDeleteArtifactMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static RegistryStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegistryStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RegistryStub>() {
          @java.lang.Override
          public RegistryStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RegistryStub(channel, callOptions);
          }
        };
    return RegistryStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RegistryBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegistryBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RegistryBlockingStub>() {
          @java.lang.Override
          public RegistryBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RegistryBlockingStub(channel, callOptions);
          }
        };
    return RegistryBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static RegistryFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegistryFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RegistryFutureStub>() {
          @java.lang.Override
          public RegistryFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RegistryFutureStub(channel, callOptions);
          }
        };
    return RegistryFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The Registry service allows teams to manage descriptions of APIs.
   * </pre>
   */
  public abstract static class RegistryImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Returns matching APIs.
     * </pre>
     */
    public void listApis(
        com.google.cloud.apigeeregistry.v1.ListApisRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ListApisResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListApisMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a specified API.
     * </pre>
     */
    public void getApi(
        com.google.cloud.apigeeregistry.v1.GetApiRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.Api> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetApiMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a specified API.
     * </pre>
     */
    public void createApi(
        com.google.cloud.apigeeregistry.v1.CreateApiRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.Api> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateApiMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Used to modify a specified API.
     * </pre>
     */
    public void updateApi(
        com.google.cloud.apigeeregistry.v1.UpdateApiRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.Api> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateApiMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes a specified API and all of the resources that it
     * owns.
     * </pre>
     */
    public void deleteApi(
        com.google.cloud.apigeeregistry.v1.DeleteApiRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteApiMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns matching versions.
     * </pre>
     */
    public void listApiVersions(
        com.google.cloud.apigeeregistry.v1.ListApiVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ListApiVersionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListApiVersionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a specified version.
     * </pre>
     */
    public void getApiVersion(
        com.google.cloud.apigeeregistry.v1.GetApiVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiVersion>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetApiVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a specified version.
     * </pre>
     */
    public void createApiVersion(
        com.google.cloud.apigeeregistry.v1.CreateApiVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiVersion>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateApiVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Used to modify a specified version.
     * </pre>
     */
    public void updateApiVersion(
        com.google.cloud.apigeeregistry.v1.UpdateApiVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiVersion>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateApiVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes a specified version and all of the resources that
     * it owns.
     * </pre>
     */
    public void deleteApiVersion(
        com.google.cloud.apigeeregistry.v1.DeleteApiVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteApiVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns matching specs.
     * </pre>
     */
    public void listApiSpecs(
        com.google.cloud.apigeeregistry.v1.ListApiSpecsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ListApiSpecsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListApiSpecsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a specified spec.
     * </pre>
     */
    public void getApiSpec(
        com.google.cloud.apigeeregistry.v1.GetApiSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiSpec> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetApiSpecMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the contents of a specified spec.
     * If specs are stored with GZip compression, the default behavior
     * is to return the spec uncompressed (the mime_type response field
     * indicates the exact format returned).
     * </pre>
     */
    public void getApiSpecContents(
        com.google.cloud.apigeeregistry.v1.GetApiSpecContentsRequest request,
        io.grpc.stub.StreamObserver<com.google.api.HttpBody> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetApiSpecContentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a specified spec.
     * </pre>
     */
    public void createApiSpec(
        com.google.cloud.apigeeregistry.v1.CreateApiSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiSpec> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateApiSpecMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Used to modify a specified spec.
     * </pre>
     */
    public void updateApiSpec(
        com.google.cloud.apigeeregistry.v1.UpdateApiSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiSpec> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateApiSpecMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes a specified spec, all revisions, and all child
     * resources (e.g., artifacts).
     * </pre>
     */
    public void deleteApiSpec(
        com.google.cloud.apigeeregistry.v1.DeleteApiSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteApiSpecMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds a tag to a specified revision of a spec.
     * </pre>
     */
    public void tagApiSpecRevision(
        com.google.cloud.apigeeregistry.v1.TagApiSpecRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiSpec> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getTagApiSpecRevisionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all revisions of a spec.
     * Revisions are returned in descending order of revision creation time.
     * </pre>
     */
    public void listApiSpecRevisions(
        com.google.cloud.apigeeregistry.v1.ListApiSpecRevisionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ListApiSpecRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListApiSpecRevisionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the current revision to a specified prior revision.
     * Note that this creates a new revision with a new revision ID.
     * </pre>
     */
    public void rollbackApiSpec(
        com.google.cloud.apigeeregistry.v1.RollbackApiSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiSpec> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRollbackApiSpecMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a revision of a spec.
     * </pre>
     */
    public void deleteApiSpecRevision(
        com.google.cloud.apigeeregistry.v1.DeleteApiSpecRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiSpec> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteApiSpecRevisionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns matching deployments.
     * </pre>
     */
    public void listApiDeployments(
        com.google.cloud.apigeeregistry.v1.ListApiDeploymentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ListApiDeploymentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListApiDeploymentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a specified deployment.
     * </pre>
     */
    public void getApiDeployment(
        com.google.cloud.apigeeregistry.v1.GetApiDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiDeployment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetApiDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a specified deployment.
     * </pre>
     */
    public void createApiDeployment(
        com.google.cloud.apigeeregistry.v1.CreateApiDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiDeployment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateApiDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Used to modify a specified deployment.
     * </pre>
     */
    public void updateApiDeployment(
        com.google.cloud.apigeeregistry.v1.UpdateApiDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiDeployment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateApiDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes a specified deployment, all revisions, and all
     * child resources (e.g., artifacts).
     * </pre>
     */
    public void deleteApiDeployment(
        com.google.cloud.apigeeregistry.v1.DeleteApiDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteApiDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds a tag to a specified revision of a
     * deployment.
     * </pre>
     */
    public void tagApiDeploymentRevision(
        com.google.cloud.apigeeregistry.v1.TagApiDeploymentRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiDeployment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getTagApiDeploymentRevisionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all revisions of a deployment.
     * Revisions are returned in descending order of revision creation time.
     * </pre>
     */
    public void listApiDeploymentRevisions(
        com.google.cloud.apigeeregistry.v1.ListApiDeploymentRevisionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.apigeeregistry.v1.ListApiDeploymentRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListApiDeploymentRevisionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the current revision to a specified prior
     * revision. Note that this creates a new revision with a new revision ID.
     * </pre>
     */
    public void rollbackApiDeployment(
        com.google.cloud.apigeeregistry.v1.RollbackApiDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiDeployment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRollbackApiDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a revision of a deployment.
     * </pre>
     */
    public void deleteApiDeploymentRevision(
        com.google.cloud.apigeeregistry.v1.DeleteApiDeploymentRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiDeployment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteApiDeploymentRevisionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns matching artifacts.
     * </pre>
     */
    public void listArtifacts(
        com.google.cloud.apigeeregistry.v1.ListArtifactsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ListArtifactsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListArtifactsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a specified artifact.
     * </pre>
     */
    public void getArtifact(
        com.google.cloud.apigeeregistry.v1.GetArtifactRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.Artifact> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetArtifactMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the contents of a specified artifact.
     * If artifacts are stored with GZip compression, the default behavior
     * is to return the artifact uncompressed (the mime_type response field
     * indicates the exact format returned).
     * </pre>
     */
    public void getArtifactContents(
        com.google.cloud.apigeeregistry.v1.GetArtifactContentsRequest request,
        io.grpc.stub.StreamObserver<com.google.api.HttpBody> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetArtifactContentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a specified artifact.
     * </pre>
     */
    public void createArtifact(
        com.google.cloud.apigeeregistry.v1.CreateArtifactRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.Artifact> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateArtifactMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Used to replace a specified artifact.
     * </pre>
     */
    public void replaceArtifact(
        com.google.cloud.apigeeregistry.v1.ReplaceArtifactRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.Artifact> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getReplaceArtifactMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes a specified artifact.
     * </pre>
     */
    public void deleteArtifact(
        com.google.cloud.apigeeregistry.v1.DeleteArtifactRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteArtifactMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListApisMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.ListApisRequest,
                      com.google.cloud.apigeeregistry.v1.ListApisResponse>(
                      this, METHODID_LIST_APIS)))
          .addMethod(
              getGetApiMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.GetApiRequest,
                      com.google.cloud.apigeeregistry.v1.Api>(this, METHODID_GET_API)))
          .addMethod(
              getCreateApiMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.CreateApiRequest,
                      com.google.cloud.apigeeregistry.v1.Api>(this, METHODID_CREATE_API)))
          .addMethod(
              getUpdateApiMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.UpdateApiRequest,
                      com.google.cloud.apigeeregistry.v1.Api>(this, METHODID_UPDATE_API)))
          .addMethod(
              getDeleteApiMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.DeleteApiRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_API)))
          .addMethod(
              getListApiVersionsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.ListApiVersionsRequest,
                      com.google.cloud.apigeeregistry.v1.ListApiVersionsResponse>(
                      this, METHODID_LIST_API_VERSIONS)))
          .addMethod(
              getGetApiVersionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.GetApiVersionRequest,
                      com.google.cloud.apigeeregistry.v1.ApiVersion>(
                      this, METHODID_GET_API_VERSION)))
          .addMethod(
              getCreateApiVersionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.CreateApiVersionRequest,
                      com.google.cloud.apigeeregistry.v1.ApiVersion>(
                      this, METHODID_CREATE_API_VERSION)))
          .addMethod(
              getUpdateApiVersionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.UpdateApiVersionRequest,
                      com.google.cloud.apigeeregistry.v1.ApiVersion>(
                      this, METHODID_UPDATE_API_VERSION)))
          .addMethod(
              getDeleteApiVersionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.DeleteApiVersionRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_API_VERSION)))
          .addMethod(
              getListApiSpecsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.ListApiSpecsRequest,
                      com.google.cloud.apigeeregistry.v1.ListApiSpecsResponse>(
                      this, METHODID_LIST_API_SPECS)))
          .addMethod(
              getGetApiSpecMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.GetApiSpecRequest,
                      com.google.cloud.apigeeregistry.v1.ApiSpec>(this, METHODID_GET_API_SPEC)))
          .addMethod(
              getGetApiSpecContentsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.GetApiSpecContentsRequest,
                      com.google.api.HttpBody>(this, METHODID_GET_API_SPEC_CONTENTS)))
          .addMethod(
              getCreateApiSpecMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.CreateApiSpecRequest,
                      com.google.cloud.apigeeregistry.v1.ApiSpec>(this, METHODID_CREATE_API_SPEC)))
          .addMethod(
              getUpdateApiSpecMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.UpdateApiSpecRequest,
                      com.google.cloud.apigeeregistry.v1.ApiSpec>(this, METHODID_UPDATE_API_SPEC)))
          .addMethod(
              getDeleteApiSpecMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.DeleteApiSpecRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_API_SPEC)))
          .addMethod(
              getTagApiSpecRevisionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.TagApiSpecRevisionRequest,
                      com.google.cloud.apigeeregistry.v1.ApiSpec>(
                      this, METHODID_TAG_API_SPEC_REVISION)))
          .addMethod(
              getListApiSpecRevisionsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.ListApiSpecRevisionsRequest,
                      com.google.cloud.apigeeregistry.v1.ListApiSpecRevisionsResponse>(
                      this, METHODID_LIST_API_SPEC_REVISIONS)))
          .addMethod(
              getRollbackApiSpecMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.RollbackApiSpecRequest,
                      com.google.cloud.apigeeregistry.v1.ApiSpec>(
                      this, METHODID_ROLLBACK_API_SPEC)))
          .addMethod(
              getDeleteApiSpecRevisionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.DeleteApiSpecRevisionRequest,
                      com.google.cloud.apigeeregistry.v1.ApiSpec>(
                      this, METHODID_DELETE_API_SPEC_REVISION)))
          .addMethod(
              getListApiDeploymentsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.ListApiDeploymentsRequest,
                      com.google.cloud.apigeeregistry.v1.ListApiDeploymentsResponse>(
                      this, METHODID_LIST_API_DEPLOYMENTS)))
          .addMethod(
              getGetApiDeploymentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.GetApiDeploymentRequest,
                      com.google.cloud.apigeeregistry.v1.ApiDeployment>(
                      this, METHODID_GET_API_DEPLOYMENT)))
          .addMethod(
              getCreateApiDeploymentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.CreateApiDeploymentRequest,
                      com.google.cloud.apigeeregistry.v1.ApiDeployment>(
                      this, METHODID_CREATE_API_DEPLOYMENT)))
          .addMethod(
              getUpdateApiDeploymentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.UpdateApiDeploymentRequest,
                      com.google.cloud.apigeeregistry.v1.ApiDeployment>(
                      this, METHODID_UPDATE_API_DEPLOYMENT)))
          .addMethod(
              getDeleteApiDeploymentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.DeleteApiDeploymentRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_API_DEPLOYMENT)))
          .addMethod(
              getTagApiDeploymentRevisionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.TagApiDeploymentRevisionRequest,
                      com.google.cloud.apigeeregistry.v1.ApiDeployment>(
                      this, METHODID_TAG_API_DEPLOYMENT_REVISION)))
          .addMethod(
              getListApiDeploymentRevisionsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.ListApiDeploymentRevisionsRequest,
                      com.google.cloud.apigeeregistry.v1.ListApiDeploymentRevisionsResponse>(
                      this, METHODID_LIST_API_DEPLOYMENT_REVISIONS)))
          .addMethod(
              getRollbackApiDeploymentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.RollbackApiDeploymentRequest,
                      com.google.cloud.apigeeregistry.v1.ApiDeployment>(
                      this, METHODID_ROLLBACK_API_DEPLOYMENT)))
          .addMethod(
              getDeleteApiDeploymentRevisionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.DeleteApiDeploymentRevisionRequest,
                      com.google.cloud.apigeeregistry.v1.ApiDeployment>(
                      this, METHODID_DELETE_API_DEPLOYMENT_REVISION)))
          .addMethod(
              getListArtifactsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.ListArtifactsRequest,
                      com.google.cloud.apigeeregistry.v1.ListArtifactsResponse>(
                      this, METHODID_LIST_ARTIFACTS)))
          .addMethod(
              getGetArtifactMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.GetArtifactRequest,
                      com.google.cloud.apigeeregistry.v1.Artifact>(this, METHODID_GET_ARTIFACT)))
          .addMethod(
              getGetArtifactContentsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.GetArtifactContentsRequest,
                      com.google.api.HttpBody>(this, METHODID_GET_ARTIFACT_CONTENTS)))
          .addMethod(
              getCreateArtifactMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.CreateArtifactRequest,
                      com.google.cloud.apigeeregistry.v1.Artifact>(this, METHODID_CREATE_ARTIFACT)))
          .addMethod(
              getReplaceArtifactMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.ReplaceArtifactRequest,
                      com.google.cloud.apigeeregistry.v1.Artifact>(
                      this, METHODID_REPLACE_ARTIFACT)))
          .addMethod(
              getDeleteArtifactMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.apigeeregistry.v1.DeleteArtifactRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_ARTIFACT)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * The Registry service allows teams to manage descriptions of APIs.
   * </pre>
   */
  public static final class RegistryStub extends io.grpc.stub.AbstractAsyncStub<RegistryStub> {
    private RegistryStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegistryStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegistryStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns matching APIs.
     * </pre>
     */
    public void listApis(
        com.google.cloud.apigeeregistry.v1.ListApisRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ListApisResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListApisMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a specified API.
     * </pre>
     */
    public void getApi(
        com.google.cloud.apigeeregistry.v1.GetApiRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.Api> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetApiMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a specified API.
     * </pre>
     */
    public void createApi(
        com.google.cloud.apigeeregistry.v1.CreateApiRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.Api> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateApiMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Used to modify a specified API.
     * </pre>
     */
    public void updateApi(
        com.google.cloud.apigeeregistry.v1.UpdateApiRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.Api> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateApiMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes a specified API and all of the resources that it
     * owns.
     * </pre>
     */
    public void deleteApi(
        com.google.cloud.apigeeregistry.v1.DeleteApiRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteApiMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns matching versions.
     * </pre>
     */
    public void listApiVersions(
        com.google.cloud.apigeeregistry.v1.ListApiVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ListApiVersionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListApiVersionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a specified version.
     * </pre>
     */
    public void getApiVersion(
        com.google.cloud.apigeeregistry.v1.GetApiVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiVersion>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetApiVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a specified version.
     * </pre>
     */
    public void createApiVersion(
        com.google.cloud.apigeeregistry.v1.CreateApiVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiVersion>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateApiVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Used to modify a specified version.
     * </pre>
     */
    public void updateApiVersion(
        com.google.cloud.apigeeregistry.v1.UpdateApiVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiVersion>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateApiVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes a specified version and all of the resources that
     * it owns.
     * </pre>
     */
    public void deleteApiVersion(
        com.google.cloud.apigeeregistry.v1.DeleteApiVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteApiVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns matching specs.
     * </pre>
     */
    public void listApiSpecs(
        com.google.cloud.apigeeregistry.v1.ListApiSpecsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ListApiSpecsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListApiSpecsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a specified spec.
     * </pre>
     */
    public void getApiSpec(
        com.google.cloud.apigeeregistry.v1.GetApiSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiSpec> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetApiSpecMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the contents of a specified spec.
     * If specs are stored with GZip compression, the default behavior
     * is to return the spec uncompressed (the mime_type response field
     * indicates the exact format returned).
     * </pre>
     */
    public void getApiSpecContents(
        com.google.cloud.apigeeregistry.v1.GetApiSpecContentsRequest request,
        io.grpc.stub.StreamObserver<com.google.api.HttpBody> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetApiSpecContentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a specified spec.
     * </pre>
     */
    public void createApiSpec(
        com.google.cloud.apigeeregistry.v1.CreateApiSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiSpec> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateApiSpecMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Used to modify a specified spec.
     * </pre>
     */
    public void updateApiSpec(
        com.google.cloud.apigeeregistry.v1.UpdateApiSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiSpec> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateApiSpecMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes a specified spec, all revisions, and all child
     * resources (e.g., artifacts).
     * </pre>
     */
    public void deleteApiSpec(
        com.google.cloud.apigeeregistry.v1.DeleteApiSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteApiSpecMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds a tag to a specified revision of a spec.
     * </pre>
     */
    public void tagApiSpecRevision(
        com.google.cloud.apigeeregistry.v1.TagApiSpecRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiSpec> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTagApiSpecRevisionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all revisions of a spec.
     * Revisions are returned in descending order of revision creation time.
     * </pre>
     */
    public void listApiSpecRevisions(
        com.google.cloud.apigeeregistry.v1.ListApiSpecRevisionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ListApiSpecRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListApiSpecRevisionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the current revision to a specified prior revision.
     * Note that this creates a new revision with a new revision ID.
     * </pre>
     */
    public void rollbackApiSpec(
        com.google.cloud.apigeeregistry.v1.RollbackApiSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiSpec> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRollbackApiSpecMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a revision of a spec.
     * </pre>
     */
    public void deleteApiSpecRevision(
        com.google.cloud.apigeeregistry.v1.DeleteApiSpecRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiSpec> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteApiSpecRevisionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns matching deployments.
     * </pre>
     */
    public void listApiDeployments(
        com.google.cloud.apigeeregistry.v1.ListApiDeploymentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ListApiDeploymentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListApiDeploymentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a specified deployment.
     * </pre>
     */
    public void getApiDeployment(
        com.google.cloud.apigeeregistry.v1.GetApiDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiDeployment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetApiDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a specified deployment.
     * </pre>
     */
    public void createApiDeployment(
        com.google.cloud.apigeeregistry.v1.CreateApiDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiDeployment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateApiDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Used to modify a specified deployment.
     * </pre>
     */
    public void updateApiDeployment(
        com.google.cloud.apigeeregistry.v1.UpdateApiDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiDeployment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateApiDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes a specified deployment, all revisions, and all
     * child resources (e.g., artifacts).
     * </pre>
     */
    public void deleteApiDeployment(
        com.google.cloud.apigeeregistry.v1.DeleteApiDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteApiDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds a tag to a specified revision of a
     * deployment.
     * </pre>
     */
    public void tagApiDeploymentRevision(
        com.google.cloud.apigeeregistry.v1.TagApiDeploymentRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiDeployment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTagApiDeploymentRevisionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all revisions of a deployment.
     * Revisions are returned in descending order of revision creation time.
     * </pre>
     */
    public void listApiDeploymentRevisions(
        com.google.cloud.apigeeregistry.v1.ListApiDeploymentRevisionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.apigeeregistry.v1.ListApiDeploymentRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListApiDeploymentRevisionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the current revision to a specified prior
     * revision. Note that this creates a new revision with a new revision ID.
     * </pre>
     */
    public void rollbackApiDeployment(
        com.google.cloud.apigeeregistry.v1.RollbackApiDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiDeployment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRollbackApiDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a revision of a deployment.
     * </pre>
     */
    public void deleteApiDeploymentRevision(
        com.google.cloud.apigeeregistry.v1.DeleteApiDeploymentRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiDeployment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteApiDeploymentRevisionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns matching artifacts.
     * </pre>
     */
    public void listArtifacts(
        com.google.cloud.apigeeregistry.v1.ListArtifactsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ListArtifactsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListArtifactsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a specified artifact.
     * </pre>
     */
    public void getArtifact(
        com.google.cloud.apigeeregistry.v1.GetArtifactRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.Artifact> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetArtifactMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the contents of a specified artifact.
     * If artifacts are stored with GZip compression, the default behavior
     * is to return the artifact uncompressed (the mime_type response field
     * indicates the exact format returned).
     * </pre>
     */
    public void getArtifactContents(
        com.google.cloud.apigeeregistry.v1.GetArtifactContentsRequest request,
        io.grpc.stub.StreamObserver<com.google.api.HttpBody> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetArtifactContentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a specified artifact.
     * </pre>
     */
    public void createArtifact(
        com.google.cloud.apigeeregistry.v1.CreateArtifactRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.Artifact> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateArtifactMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Used to replace a specified artifact.
     * </pre>
     */
    public void replaceArtifact(
        com.google.cloud.apigeeregistry.v1.ReplaceArtifactRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.Artifact> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReplaceArtifactMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes a specified artifact.
     * </pre>
     */
    public void deleteArtifact(
        com.google.cloud.apigeeregistry.v1.DeleteArtifactRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteArtifactMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * The Registry service allows teams to manage descriptions of APIs.
   * </pre>
   */
  public static final class RegistryBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RegistryBlockingStub> {
    private RegistryBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegistryBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegistryBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns matching APIs.
     * </pre>
     */
    public com.google.cloud.apigeeregistry.v1.ListApisResponse listApis(
        com.google.cloud.apigeeregistry.v1.ListApisRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListApisMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a specified API.
     * </pre>
     */
    public com.google.cloud.apigeeregistry.v1.Api getApi(
        com.google.cloud.apigeeregistry.v1.GetApiRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetApiMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a specified API.
     * </pre>
     */
    public com.google.cloud.apigeeregistry.v1.Api createApi(
        com.google.cloud.apigeeregistry.v1.CreateApiRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateApiMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Used to modify a specified API.
     * </pre>
     */
    public com.google.cloud.apigeeregistry.v1.Api updateApi(
        com.google.cloud.apigeeregistry.v1.UpdateApiRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateApiMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Removes a specified API and all of the resources that it
     * owns.
     * </pre>
     */
    public com.google.protobuf.Empty deleteApi(
        com.google.cloud.apigeeregistry.v1.DeleteApiRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteApiMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns matching versions.
     * </pre>
     */
    public com.google.cloud.apigeeregistry.v1.ListApiVersionsResponse listApiVersions(
        com.google.cloud.apigeeregistry.v1.ListApiVersionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListApiVersionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a specified version.
     * </pre>
     */
    public com.google.cloud.apigeeregistry.v1.ApiVersion getApiVersion(
        com.google.cloud.apigeeregistry.v1.GetApiVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetApiVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a specified version.
     * </pre>
     */
    public com.google.cloud.apigeeregistry.v1.ApiVersion createApiVersion(
        com.google.cloud.apigeeregistry.v1.CreateApiVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateApiVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Used to modify a specified version.
     * </pre>
     */
    public com.google.cloud.apigeeregistry.v1.ApiVersion updateApiVersion(
        com.google.cloud.apigeeregistry.v1.UpdateApiVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateApiVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Removes a specified version and all of the resources that
     * it owns.
     * </pre>
     */
    public com.google.protobuf.Empty deleteApiVersion(
        com.google.cloud.apigeeregistry.v1.DeleteApiVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteApiVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns matching specs.
     * </pre>
     */
    public com.google.cloud.apigeeregistry.v1.ListApiSpecsResponse listApiSpecs(
        com.google.cloud.apigeeregistry.v1.ListApiSpecsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListApiSpecsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a specified spec.
     * </pre>
     */
    public com.google.cloud.apigeeregistry.v1.ApiSpec getApiSpec(
        com.google.cloud.apigeeregistry.v1.GetApiSpecRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetApiSpecMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the contents of a specified spec.
     * If specs are stored with GZip compression, the default behavior
     * is to return the spec uncompressed (the mime_type response field
     * indicates the exact format returned).
     * </pre>
     */
    public com.google.api.HttpBody getApiSpecContents(
        com.google.cloud.apigeeregistry.v1.GetApiSpecContentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetApiSpecContentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a specified spec.
     * </pre>
     */
    public com.google.cloud.apigeeregistry.v1.ApiSpec createApiSpec(
        com.google.cloud.apigeeregistry.v1.CreateApiSpecRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateApiSpecMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Used to modify a specified spec.
     * </pre>
     */
    public com.google.cloud.apigeeregistry.v1.ApiSpec updateApiSpec(
        com.google.cloud.apigeeregistry.v1.UpdateApiSpecRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateApiSpecMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Removes a specified spec, all revisions, and all child
     * resources (e.g., artifacts).
     * </pre>
     */
    public com.google.protobuf.Empty deleteApiSpec(
        com.google.cloud.apigeeregistry.v1.DeleteApiSpecRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteApiSpecMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a tag to a specified revision of a spec.
     * </pre>
     */
    public com.google.cloud.apigeeregistry.v1.ApiSpec tagApiSpecRevision(
        com.google.cloud.apigeeregistry.v1.TagApiSpecRevisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTagApiSpecRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all revisions of a spec.
     * Revisions are returned in descending order of revision creation time.
     * </pre>
     */
    public com.google.cloud.apigeeregistry.v1.ListApiSpecRevisionsResponse listApiSpecRevisions(
        com.google.cloud.apigeeregistry.v1.ListApiSpecRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListApiSpecRevisionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the current revision to a specified prior revision.
     * Note that this creates a new revision with a new revision ID.
     * </pre>
     */
    public com.google.cloud.apigeeregistry.v1.ApiSpec rollbackApiSpec(
        com.google.cloud.apigeeregistry.v1.RollbackApiSpecRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRollbackApiSpecMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a revision of a spec.
     * </pre>
     */
    public com.google.cloud.apigeeregistry.v1.ApiSpec deleteApiSpecRevision(
        com.google.cloud.apigeeregistry.v1.DeleteApiSpecRevisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteApiSpecRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns matching deployments.
     * </pre>
     */
    public com.google.cloud.apigeeregistry.v1.ListApiDeploymentsResponse listApiDeployments(
        com.google.cloud.apigeeregistry.v1.ListApiDeploymentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListApiDeploymentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a specified deployment.
     * </pre>
     */
    public com.google.cloud.apigeeregistry.v1.ApiDeployment getApiDeployment(
        com.google.cloud.apigeeregistry.v1.GetApiDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetApiDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a specified deployment.
     * </pre>
     */
    public com.google.cloud.apigeeregistry.v1.ApiDeployment createApiDeployment(
        com.google.cloud.apigeeregistry.v1.CreateApiDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateApiDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Used to modify a specified deployment.
     * </pre>
     */
    public com.google.cloud.apigeeregistry.v1.ApiDeployment updateApiDeployment(
        com.google.cloud.apigeeregistry.v1.UpdateApiDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateApiDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Removes a specified deployment, all revisions, and all
     * child resources (e.g., artifacts).
     * </pre>
     */
    public com.google.protobuf.Empty deleteApiDeployment(
        com.google.cloud.apigeeregistry.v1.DeleteApiDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteApiDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a tag to a specified revision of a
     * deployment.
     * </pre>
     */
    public com.google.cloud.apigeeregistry.v1.ApiDeployment tagApiDeploymentRevision(
        com.google.cloud.apigeeregistry.v1.TagApiDeploymentRevisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTagApiDeploymentRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all revisions of a deployment.
     * Revisions are returned in descending order of revision creation time.
     * </pre>
     */
    public com.google.cloud.apigeeregistry.v1.ListApiDeploymentRevisionsResponse
        listApiDeploymentRevisions(
            com.google.cloud.apigeeregistry.v1.ListApiDeploymentRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListApiDeploymentRevisionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the current revision to a specified prior
     * revision. Note that this creates a new revision with a new revision ID.
     * </pre>
     */
    public com.google.cloud.apigeeregistry.v1.ApiDeployment rollbackApiDeployment(
        com.google.cloud.apigeeregistry.v1.RollbackApiDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRollbackApiDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a revision of a deployment.
     * </pre>
     */
    public com.google.cloud.apigeeregistry.v1.ApiDeployment deleteApiDeploymentRevision(
        com.google.cloud.apigeeregistry.v1.DeleteApiDeploymentRevisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteApiDeploymentRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns matching artifacts.
     * </pre>
     */
    public com.google.cloud.apigeeregistry.v1.ListArtifactsResponse listArtifacts(
        com.google.cloud.apigeeregistry.v1.ListArtifactsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListArtifactsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a specified artifact.
     * </pre>
     */
    public com.google.cloud.apigeeregistry.v1.Artifact getArtifact(
        com.google.cloud.apigeeregistry.v1.GetArtifactRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetArtifactMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the contents of a specified artifact.
     * If artifacts are stored with GZip compression, the default behavior
     * is to return the artifact uncompressed (the mime_type response field
     * indicates the exact format returned).
     * </pre>
     */
    public com.google.api.HttpBody getArtifactContents(
        com.google.cloud.apigeeregistry.v1.GetArtifactContentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetArtifactContentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a specified artifact.
     * </pre>
     */
    public com.google.cloud.apigeeregistry.v1.Artifact createArtifact(
        com.google.cloud.apigeeregistry.v1.CreateArtifactRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateArtifactMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Used to replace a specified artifact.
     * </pre>
     */
    public com.google.cloud.apigeeregistry.v1.Artifact replaceArtifact(
        com.google.cloud.apigeeregistry.v1.ReplaceArtifactRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReplaceArtifactMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Removes a specified artifact.
     * </pre>
     */
    public com.google.protobuf.Empty deleteArtifact(
        com.google.cloud.apigeeregistry.v1.DeleteArtifactRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteArtifactMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * The Registry service allows teams to manage descriptions of APIs.
   * </pre>
   */
  public static final class RegistryFutureStub
      extends io.grpc.stub.AbstractFutureStub<RegistryFutureStub> {
    private RegistryFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegistryFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegistryFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns matching APIs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apigeeregistry.v1.ListApisResponse>
        listApis(com.google.cloud.apigeeregistry.v1.ListApisRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListApisMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a specified API.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apigeeregistry.v1.Api>
        getApi(com.google.cloud.apigeeregistry.v1.GetApiRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetApiMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a specified API.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apigeeregistry.v1.Api>
        createApi(com.google.cloud.apigeeregistry.v1.CreateApiRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateApiMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Used to modify a specified API.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apigeeregistry.v1.Api>
        updateApi(com.google.cloud.apigeeregistry.v1.UpdateApiRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateApiMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Removes a specified API and all of the resources that it
     * owns.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteApi(
        com.google.cloud.apigeeregistry.v1.DeleteApiRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteApiMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns matching versions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apigeeregistry.v1.ListApiVersionsResponse>
        listApiVersions(com.google.cloud.apigeeregistry.v1.ListApiVersionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListApiVersionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a specified version.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apigeeregistry.v1.ApiVersion>
        getApiVersion(com.google.cloud.apigeeregistry.v1.GetApiVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetApiVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a specified version.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apigeeregistry.v1.ApiVersion>
        createApiVersion(com.google.cloud.apigeeregistry.v1.CreateApiVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateApiVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Used to modify a specified version.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apigeeregistry.v1.ApiVersion>
        updateApiVersion(com.google.cloud.apigeeregistry.v1.UpdateApiVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateApiVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Removes a specified version and all of the resources that
     * it owns.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteApiVersion(com.google.cloud.apigeeregistry.v1.DeleteApiVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteApiVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns matching specs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apigeeregistry.v1.ListApiSpecsResponse>
        listApiSpecs(com.google.cloud.apigeeregistry.v1.ListApiSpecsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListApiSpecsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a specified spec.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apigeeregistry.v1.ApiSpec>
        getApiSpec(com.google.cloud.apigeeregistry.v1.GetApiSpecRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetApiSpecMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the contents of a specified spec.
     * If specs are stored with GZip compression, the default behavior
     * is to return the spec uncompressed (the mime_type response field
     * indicates the exact format returned).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.HttpBody>
        getApiSpecContents(com.google.cloud.apigeeregistry.v1.GetApiSpecContentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetApiSpecContentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a specified spec.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apigeeregistry.v1.ApiSpec>
        createApiSpec(com.google.cloud.apigeeregistry.v1.CreateApiSpecRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateApiSpecMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Used to modify a specified spec.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apigeeregistry.v1.ApiSpec>
        updateApiSpec(com.google.cloud.apigeeregistry.v1.UpdateApiSpecRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateApiSpecMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Removes a specified spec, all revisions, and all child
     * resources (e.g., artifacts).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteApiSpec(com.google.cloud.apigeeregistry.v1.DeleteApiSpecRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteApiSpecMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a tag to a specified revision of a spec.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apigeeregistry.v1.ApiSpec>
        tagApiSpecRevision(com.google.cloud.apigeeregistry.v1.TagApiSpecRevisionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTagApiSpecRevisionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all revisions of a spec.
     * Revisions are returned in descending order of revision creation time.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apigeeregistry.v1.ListApiSpecRevisionsResponse>
        listApiSpecRevisions(
            com.google.cloud.apigeeregistry.v1.ListApiSpecRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListApiSpecRevisionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the current revision to a specified prior revision.
     * Note that this creates a new revision with a new revision ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apigeeregistry.v1.ApiSpec>
        rollbackApiSpec(com.google.cloud.apigeeregistry.v1.RollbackApiSpecRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRollbackApiSpecMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a revision of a spec.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apigeeregistry.v1.ApiSpec>
        deleteApiSpecRevision(
            com.google.cloud.apigeeregistry.v1.DeleteApiSpecRevisionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteApiSpecRevisionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns matching deployments.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apigeeregistry.v1.ListApiDeploymentsResponse>
        listApiDeployments(com.google.cloud.apigeeregistry.v1.ListApiDeploymentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListApiDeploymentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a specified deployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apigeeregistry.v1.ApiDeployment>
        getApiDeployment(com.google.cloud.apigeeregistry.v1.GetApiDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetApiDeploymentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a specified deployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apigeeregistry.v1.ApiDeployment>
        createApiDeployment(com.google.cloud.apigeeregistry.v1.CreateApiDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateApiDeploymentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Used to modify a specified deployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apigeeregistry.v1.ApiDeployment>
        updateApiDeployment(com.google.cloud.apigeeregistry.v1.UpdateApiDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateApiDeploymentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Removes a specified deployment, all revisions, and all
     * child resources (e.g., artifacts).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteApiDeployment(com.google.cloud.apigeeregistry.v1.DeleteApiDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteApiDeploymentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a tag to a specified revision of a
     * deployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apigeeregistry.v1.ApiDeployment>
        tagApiDeploymentRevision(
            com.google.cloud.apigeeregistry.v1.TagApiDeploymentRevisionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTagApiDeploymentRevisionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all revisions of a deployment.
     * Revisions are returned in descending order of revision creation time.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apigeeregistry.v1.ListApiDeploymentRevisionsResponse>
        listApiDeploymentRevisions(
            com.google.cloud.apigeeregistry.v1.ListApiDeploymentRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListApiDeploymentRevisionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the current revision to a specified prior
     * revision. Note that this creates a new revision with a new revision ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apigeeregistry.v1.ApiDeployment>
        rollbackApiDeployment(
            com.google.cloud.apigeeregistry.v1.RollbackApiDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRollbackApiDeploymentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a revision of a deployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apigeeregistry.v1.ApiDeployment>
        deleteApiDeploymentRevision(
            com.google.cloud.apigeeregistry.v1.DeleteApiDeploymentRevisionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteApiDeploymentRevisionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns matching artifacts.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apigeeregistry.v1.ListArtifactsResponse>
        listArtifacts(com.google.cloud.apigeeregistry.v1.ListArtifactsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListArtifactsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a specified artifact.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apigeeregistry.v1.Artifact>
        getArtifact(com.google.cloud.apigeeregistry.v1.GetArtifactRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetArtifactMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the contents of a specified artifact.
     * If artifacts are stored with GZip compression, the default behavior
     * is to return the artifact uncompressed (the mime_type response field
     * indicates the exact format returned).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.HttpBody>
        getArtifactContents(com.google.cloud.apigeeregistry.v1.GetArtifactContentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetArtifactContentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a specified artifact.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apigeeregistry.v1.Artifact>
        createArtifact(com.google.cloud.apigeeregistry.v1.CreateArtifactRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateArtifactMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Used to replace a specified artifact.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apigeeregistry.v1.Artifact>
        replaceArtifact(com.google.cloud.apigeeregistry.v1.ReplaceArtifactRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReplaceArtifactMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Removes a specified artifact.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteArtifact(com.google.cloud.apigeeregistry.v1.DeleteArtifactRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteArtifactMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_APIS = 0;
  private static final int METHODID_GET_API = 1;
  private static final int METHODID_CREATE_API = 2;
  private static final int METHODID_UPDATE_API = 3;
  private static final int METHODID_DELETE_API = 4;
  private static final int METHODID_LIST_API_VERSIONS = 5;
  private static final int METHODID_GET_API_VERSION = 6;
  private static final int METHODID_CREATE_API_VERSION = 7;
  private static final int METHODID_UPDATE_API_VERSION = 8;
  private static final int METHODID_DELETE_API_VERSION = 9;
  private static final int METHODID_LIST_API_SPECS = 10;
  private static final int METHODID_GET_API_SPEC = 11;
  private static final int METHODID_GET_API_SPEC_CONTENTS = 12;
  private static final int METHODID_CREATE_API_SPEC = 13;
  private static final int METHODID_UPDATE_API_SPEC = 14;
  private static final int METHODID_DELETE_API_SPEC = 15;
  private static final int METHODID_TAG_API_SPEC_REVISION = 16;
  private static final int METHODID_LIST_API_SPEC_REVISIONS = 17;
  private static final int METHODID_ROLLBACK_API_SPEC = 18;
  private static final int METHODID_DELETE_API_SPEC_REVISION = 19;
  private static final int METHODID_LIST_API_DEPLOYMENTS = 20;
  private static final int METHODID_GET_API_DEPLOYMENT = 21;
  private static final int METHODID_CREATE_API_DEPLOYMENT = 22;
  private static final int METHODID_UPDATE_API_DEPLOYMENT = 23;
  private static final int METHODID_DELETE_API_DEPLOYMENT = 24;
  private static final int METHODID_TAG_API_DEPLOYMENT_REVISION = 25;
  private static final int METHODID_LIST_API_DEPLOYMENT_REVISIONS = 26;
  private static final int METHODID_ROLLBACK_API_DEPLOYMENT = 27;
  private static final int METHODID_DELETE_API_DEPLOYMENT_REVISION = 28;
  private static final int METHODID_LIST_ARTIFACTS = 29;
  private static final int METHODID_GET_ARTIFACT = 30;
  private static final int METHODID_GET_ARTIFACT_CONTENTS = 31;
  private static final int METHODID_CREATE_ARTIFACT = 32;
  private static final int METHODID_REPLACE_ARTIFACT = 33;
  private static final int METHODID_DELETE_ARTIFACT = 34;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RegistryImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RegistryImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_APIS:
          serviceImpl.listApis(
              (com.google.cloud.apigeeregistry.v1.ListApisRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ListApisResponse>)
                  responseObserver);
          break;
        case METHODID_GET_API:
          serviceImpl.getApi(
              (com.google.cloud.apigeeregistry.v1.GetApiRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.Api>)
                  responseObserver);
          break;
        case METHODID_CREATE_API:
          serviceImpl.createApi(
              (com.google.cloud.apigeeregistry.v1.CreateApiRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.Api>)
                  responseObserver);
          break;
        case METHODID_UPDATE_API:
          serviceImpl.updateApi(
              (com.google.cloud.apigeeregistry.v1.UpdateApiRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.Api>)
                  responseObserver);
          break;
        case METHODID_DELETE_API:
          serviceImpl.deleteApi(
              (com.google.cloud.apigeeregistry.v1.DeleteApiRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_API_VERSIONS:
          serviceImpl.listApiVersions(
              (com.google.cloud.apigeeregistry.v1.ListApiVersionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.apigeeregistry.v1.ListApiVersionsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_API_VERSION:
          serviceImpl.getApiVersion(
              (com.google.cloud.apigeeregistry.v1.GetApiVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiVersion>)
                  responseObserver);
          break;
        case METHODID_CREATE_API_VERSION:
          serviceImpl.createApiVersion(
              (com.google.cloud.apigeeregistry.v1.CreateApiVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiVersion>)
                  responseObserver);
          break;
        case METHODID_UPDATE_API_VERSION:
          serviceImpl.updateApiVersion(
              (com.google.cloud.apigeeregistry.v1.UpdateApiVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiVersion>)
                  responseObserver);
          break;
        case METHODID_DELETE_API_VERSION:
          serviceImpl.deleteApiVersion(
              (com.google.cloud.apigeeregistry.v1.DeleteApiVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_API_SPECS:
          serviceImpl.listApiSpecs(
              (com.google.cloud.apigeeregistry.v1.ListApiSpecsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ListApiSpecsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_API_SPEC:
          serviceImpl.getApiSpec(
              (com.google.cloud.apigeeregistry.v1.GetApiSpecRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiSpec>)
                  responseObserver);
          break;
        case METHODID_GET_API_SPEC_CONTENTS:
          serviceImpl.getApiSpecContents(
              (com.google.cloud.apigeeregistry.v1.GetApiSpecContentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.HttpBody>) responseObserver);
          break;
        case METHODID_CREATE_API_SPEC:
          serviceImpl.createApiSpec(
              (com.google.cloud.apigeeregistry.v1.CreateApiSpecRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiSpec>)
                  responseObserver);
          break;
        case METHODID_UPDATE_API_SPEC:
          serviceImpl.updateApiSpec(
              (com.google.cloud.apigeeregistry.v1.UpdateApiSpecRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiSpec>)
                  responseObserver);
          break;
        case METHODID_DELETE_API_SPEC:
          serviceImpl.deleteApiSpec(
              (com.google.cloud.apigeeregistry.v1.DeleteApiSpecRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_TAG_API_SPEC_REVISION:
          serviceImpl.tagApiSpecRevision(
              (com.google.cloud.apigeeregistry.v1.TagApiSpecRevisionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiSpec>)
                  responseObserver);
          break;
        case METHODID_LIST_API_SPEC_REVISIONS:
          serviceImpl.listApiSpecRevisions(
              (com.google.cloud.apigeeregistry.v1.ListApiSpecRevisionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.apigeeregistry.v1.ListApiSpecRevisionsResponse>)
                  responseObserver);
          break;
        case METHODID_ROLLBACK_API_SPEC:
          serviceImpl.rollbackApiSpec(
              (com.google.cloud.apigeeregistry.v1.RollbackApiSpecRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiSpec>)
                  responseObserver);
          break;
        case METHODID_DELETE_API_SPEC_REVISION:
          serviceImpl.deleteApiSpecRevision(
              (com.google.cloud.apigeeregistry.v1.DeleteApiSpecRevisionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiSpec>)
                  responseObserver);
          break;
        case METHODID_LIST_API_DEPLOYMENTS:
          serviceImpl.listApiDeployments(
              (com.google.cloud.apigeeregistry.v1.ListApiDeploymentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.apigeeregistry.v1.ListApiDeploymentsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_API_DEPLOYMENT:
          serviceImpl.getApiDeployment(
              (com.google.cloud.apigeeregistry.v1.GetApiDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiDeployment>)
                  responseObserver);
          break;
        case METHODID_CREATE_API_DEPLOYMENT:
          serviceImpl.createApiDeployment(
              (com.google.cloud.apigeeregistry.v1.CreateApiDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiDeployment>)
                  responseObserver);
          break;
        case METHODID_UPDATE_API_DEPLOYMENT:
          serviceImpl.updateApiDeployment(
              (com.google.cloud.apigeeregistry.v1.UpdateApiDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiDeployment>)
                  responseObserver);
          break;
        case METHODID_DELETE_API_DEPLOYMENT:
          serviceImpl.deleteApiDeployment(
              (com.google.cloud.apigeeregistry.v1.DeleteApiDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_TAG_API_DEPLOYMENT_REVISION:
          serviceImpl.tagApiDeploymentRevision(
              (com.google.cloud.apigeeregistry.v1.TagApiDeploymentRevisionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiDeployment>)
                  responseObserver);
          break;
        case METHODID_LIST_API_DEPLOYMENT_REVISIONS:
          serviceImpl.listApiDeploymentRevisions(
              (com.google.cloud.apigeeregistry.v1.ListApiDeploymentRevisionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.apigeeregistry.v1.ListApiDeploymentRevisionsResponse>)
                  responseObserver);
          break;
        case METHODID_ROLLBACK_API_DEPLOYMENT:
          serviceImpl.rollbackApiDeployment(
              (com.google.cloud.apigeeregistry.v1.RollbackApiDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiDeployment>)
                  responseObserver);
          break;
        case METHODID_DELETE_API_DEPLOYMENT_REVISION:
          serviceImpl.deleteApiDeploymentRevision(
              (com.google.cloud.apigeeregistry.v1.DeleteApiDeploymentRevisionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.ApiDeployment>)
                  responseObserver);
          break;
        case METHODID_LIST_ARTIFACTS:
          serviceImpl.listArtifacts(
              (com.google.cloud.apigeeregistry.v1.ListArtifactsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.apigeeregistry.v1.ListArtifactsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ARTIFACT:
          serviceImpl.getArtifact(
              (com.google.cloud.apigeeregistry.v1.GetArtifactRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.Artifact>)
                  responseObserver);
          break;
        case METHODID_GET_ARTIFACT_CONTENTS:
          serviceImpl.getArtifactContents(
              (com.google.cloud.apigeeregistry.v1.GetArtifactContentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.HttpBody>) responseObserver);
          break;
        case METHODID_CREATE_ARTIFACT:
          serviceImpl.createArtifact(
              (com.google.cloud.apigeeregistry.v1.CreateArtifactRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.Artifact>)
                  responseObserver);
          break;
        case METHODID_REPLACE_ARTIFACT:
          serviceImpl.replaceArtifact(
              (com.google.cloud.apigeeregistry.v1.ReplaceArtifactRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.Artifact>)
                  responseObserver);
          break;
        case METHODID_DELETE_ARTIFACT:
          serviceImpl.deleteArtifact(
              (com.google.cloud.apigeeregistry.v1.DeleteArtifactRequest) request,
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

  private abstract static class RegistryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RegistryBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.apigeeregistry.v1.RegistryServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Registry");
    }
  }

  private static final class RegistryFileDescriptorSupplier extends RegistryBaseDescriptorSupplier {
    RegistryFileDescriptorSupplier() {}
  }

  private static final class RegistryMethodDescriptorSupplier extends RegistryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RegistryMethodDescriptorSupplier(String methodName) {
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
      synchronized (RegistryGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new RegistryFileDescriptorSupplier())
                      .addMethod(getListApisMethod())
                      .addMethod(getGetApiMethod())
                      .addMethod(getCreateApiMethod())
                      .addMethod(getUpdateApiMethod())
                      .addMethod(getDeleteApiMethod())
                      .addMethod(getListApiVersionsMethod())
                      .addMethod(getGetApiVersionMethod())
                      .addMethod(getCreateApiVersionMethod())
                      .addMethod(getUpdateApiVersionMethod())
                      .addMethod(getDeleteApiVersionMethod())
                      .addMethod(getListApiSpecsMethod())
                      .addMethod(getGetApiSpecMethod())
                      .addMethod(getGetApiSpecContentsMethod())
                      .addMethod(getCreateApiSpecMethod())
                      .addMethod(getUpdateApiSpecMethod())
                      .addMethod(getDeleteApiSpecMethod())
                      .addMethod(getTagApiSpecRevisionMethod())
                      .addMethod(getListApiSpecRevisionsMethod())
                      .addMethod(getRollbackApiSpecMethod())
                      .addMethod(getDeleteApiSpecRevisionMethod())
                      .addMethod(getListApiDeploymentsMethod())
                      .addMethod(getGetApiDeploymentMethod())
                      .addMethod(getCreateApiDeploymentMethod())
                      .addMethod(getUpdateApiDeploymentMethod())
                      .addMethod(getDeleteApiDeploymentMethod())
                      .addMethod(getTagApiDeploymentRevisionMethod())
                      .addMethod(getListApiDeploymentRevisionsMethod())
                      .addMethod(getRollbackApiDeploymentMethod())
                      .addMethod(getDeleteApiDeploymentRevisionMethod())
                      .addMethod(getListArtifactsMethod())
                      .addMethod(getGetArtifactMethod())
                      .addMethod(getGetArtifactContentsMethod())
                      .addMethod(getCreateArtifactMethod())
                      .addMethod(getReplaceArtifactMethod())
                      .addMethod(getDeleteArtifactMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
