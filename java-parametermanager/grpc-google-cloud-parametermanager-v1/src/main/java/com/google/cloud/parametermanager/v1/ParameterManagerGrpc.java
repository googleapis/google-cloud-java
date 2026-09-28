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
package com.google.cloud.parametermanager.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service describing handlers for resources
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class ParameterManagerGrpc {

  private ParameterManagerGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.parametermanager.v1.ParameterManager";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.ListParametersRequest,
          com.google.cloud.parametermanager.v1.ListParametersResponse>
      getListParametersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListParameters",
      requestType = com.google.cloud.parametermanager.v1.ListParametersRequest.class,
      responseType = com.google.cloud.parametermanager.v1.ListParametersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.ListParametersRequest,
          com.google.cloud.parametermanager.v1.ListParametersResponse>
      getListParametersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.parametermanager.v1.ListParametersRequest,
            com.google.cloud.parametermanager.v1.ListParametersResponse>
        getListParametersMethod;
    if ((getListParametersMethod = ParameterManagerGrpc.getListParametersMethod) == null) {
      synchronized (ParameterManagerGrpc.class) {
        if ((getListParametersMethod = ParameterManagerGrpc.getListParametersMethod) == null) {
          ParameterManagerGrpc.getListParametersMethod =
              getListParametersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.parametermanager.v1.ListParametersRequest,
                          com.google.cloud.parametermanager.v1.ListParametersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListParameters"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.ListParametersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.ListParametersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParameterManagerMethodDescriptorSupplier("ListParameters"))
                      .build();
        }
      }
    }
    return getListParametersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.GetParameterRequest,
          com.google.cloud.parametermanager.v1.Parameter>
      getGetParameterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetParameter",
      requestType = com.google.cloud.parametermanager.v1.GetParameterRequest.class,
      responseType = com.google.cloud.parametermanager.v1.Parameter.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.GetParameterRequest,
          com.google.cloud.parametermanager.v1.Parameter>
      getGetParameterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.parametermanager.v1.GetParameterRequest,
            com.google.cloud.parametermanager.v1.Parameter>
        getGetParameterMethod;
    if ((getGetParameterMethod = ParameterManagerGrpc.getGetParameterMethod) == null) {
      synchronized (ParameterManagerGrpc.class) {
        if ((getGetParameterMethod = ParameterManagerGrpc.getGetParameterMethod) == null) {
          ParameterManagerGrpc.getGetParameterMethod =
              getGetParameterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.parametermanager.v1.GetParameterRequest,
                          com.google.cloud.parametermanager.v1.Parameter>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetParameter"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.GetParameterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.Parameter.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParameterManagerMethodDescriptorSupplier("GetParameter"))
                      .build();
        }
      }
    }
    return getGetParameterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.CreateParameterRequest,
          com.google.cloud.parametermanager.v1.Parameter>
      getCreateParameterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateParameter",
      requestType = com.google.cloud.parametermanager.v1.CreateParameterRequest.class,
      responseType = com.google.cloud.parametermanager.v1.Parameter.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.CreateParameterRequest,
          com.google.cloud.parametermanager.v1.Parameter>
      getCreateParameterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.parametermanager.v1.CreateParameterRequest,
            com.google.cloud.parametermanager.v1.Parameter>
        getCreateParameterMethod;
    if ((getCreateParameterMethod = ParameterManagerGrpc.getCreateParameterMethod) == null) {
      synchronized (ParameterManagerGrpc.class) {
        if ((getCreateParameterMethod = ParameterManagerGrpc.getCreateParameterMethod) == null) {
          ParameterManagerGrpc.getCreateParameterMethod =
              getCreateParameterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.parametermanager.v1.CreateParameterRequest,
                          com.google.cloud.parametermanager.v1.Parameter>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateParameter"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.CreateParameterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.Parameter.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParameterManagerMethodDescriptorSupplier("CreateParameter"))
                      .build();
        }
      }
    }
    return getCreateParameterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.UpdateParameterRequest,
          com.google.cloud.parametermanager.v1.Parameter>
      getUpdateParameterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateParameter",
      requestType = com.google.cloud.parametermanager.v1.UpdateParameterRequest.class,
      responseType = com.google.cloud.parametermanager.v1.Parameter.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.UpdateParameterRequest,
          com.google.cloud.parametermanager.v1.Parameter>
      getUpdateParameterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.parametermanager.v1.UpdateParameterRequest,
            com.google.cloud.parametermanager.v1.Parameter>
        getUpdateParameterMethod;
    if ((getUpdateParameterMethod = ParameterManagerGrpc.getUpdateParameterMethod) == null) {
      synchronized (ParameterManagerGrpc.class) {
        if ((getUpdateParameterMethod = ParameterManagerGrpc.getUpdateParameterMethod) == null) {
          ParameterManagerGrpc.getUpdateParameterMethod =
              getUpdateParameterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.parametermanager.v1.UpdateParameterRequest,
                          com.google.cloud.parametermanager.v1.Parameter>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateParameter"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.UpdateParameterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.Parameter.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParameterManagerMethodDescriptorSupplier("UpdateParameter"))
                      .build();
        }
      }
    }
    return getUpdateParameterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.DeleteParameterRequest, com.google.protobuf.Empty>
      getDeleteParameterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteParameter",
      requestType = com.google.cloud.parametermanager.v1.DeleteParameterRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.DeleteParameterRequest, com.google.protobuf.Empty>
      getDeleteParameterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.parametermanager.v1.DeleteParameterRequest, com.google.protobuf.Empty>
        getDeleteParameterMethod;
    if ((getDeleteParameterMethod = ParameterManagerGrpc.getDeleteParameterMethod) == null) {
      synchronized (ParameterManagerGrpc.class) {
        if ((getDeleteParameterMethod = ParameterManagerGrpc.getDeleteParameterMethod) == null) {
          ParameterManagerGrpc.getDeleteParameterMethod =
              getDeleteParameterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.parametermanager.v1.DeleteParameterRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteParameter"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.DeleteParameterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParameterManagerMethodDescriptorSupplier("DeleteParameter"))
                      .build();
        }
      }
    }
    return getDeleteParameterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.ListParameterVersionsRequest,
          com.google.cloud.parametermanager.v1.ListParameterVersionsResponse>
      getListParameterVersionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListParameterVersions",
      requestType = com.google.cloud.parametermanager.v1.ListParameterVersionsRequest.class,
      responseType = com.google.cloud.parametermanager.v1.ListParameterVersionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.ListParameterVersionsRequest,
          com.google.cloud.parametermanager.v1.ListParameterVersionsResponse>
      getListParameterVersionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.parametermanager.v1.ListParameterVersionsRequest,
            com.google.cloud.parametermanager.v1.ListParameterVersionsResponse>
        getListParameterVersionsMethod;
    if ((getListParameterVersionsMethod = ParameterManagerGrpc.getListParameterVersionsMethod)
        == null) {
      synchronized (ParameterManagerGrpc.class) {
        if ((getListParameterVersionsMethod = ParameterManagerGrpc.getListParameterVersionsMethod)
            == null) {
          ParameterManagerGrpc.getListParameterVersionsMethod =
              getListParameterVersionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.parametermanager.v1.ListParameterVersionsRequest,
                          com.google.cloud.parametermanager.v1.ListParameterVersionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListParameterVersions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.ListParameterVersionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.ListParameterVersionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParameterManagerMethodDescriptorSupplier("ListParameterVersions"))
                      .build();
        }
      }
    }
    return getListParameterVersionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.GetParameterVersionRequest,
          com.google.cloud.parametermanager.v1.ParameterVersion>
      getGetParameterVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetParameterVersion",
      requestType = com.google.cloud.parametermanager.v1.GetParameterVersionRequest.class,
      responseType = com.google.cloud.parametermanager.v1.ParameterVersion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.GetParameterVersionRequest,
          com.google.cloud.parametermanager.v1.ParameterVersion>
      getGetParameterVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.parametermanager.v1.GetParameterVersionRequest,
            com.google.cloud.parametermanager.v1.ParameterVersion>
        getGetParameterVersionMethod;
    if ((getGetParameterVersionMethod = ParameterManagerGrpc.getGetParameterVersionMethod)
        == null) {
      synchronized (ParameterManagerGrpc.class) {
        if ((getGetParameterVersionMethod = ParameterManagerGrpc.getGetParameterVersionMethod)
            == null) {
          ParameterManagerGrpc.getGetParameterVersionMethod =
              getGetParameterVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.parametermanager.v1.GetParameterVersionRequest,
                          com.google.cloud.parametermanager.v1.ParameterVersion>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetParameterVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.GetParameterVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.ParameterVersion
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParameterManagerMethodDescriptorSupplier("GetParameterVersion"))
                      .build();
        }
      }
    }
    return getGetParameterVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.RenderParameterVersionRequest,
          com.google.cloud.parametermanager.v1.RenderParameterVersionResponse>
      getRenderParameterVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RenderParameterVersion",
      requestType = com.google.cloud.parametermanager.v1.RenderParameterVersionRequest.class,
      responseType = com.google.cloud.parametermanager.v1.RenderParameterVersionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.RenderParameterVersionRequest,
          com.google.cloud.parametermanager.v1.RenderParameterVersionResponse>
      getRenderParameterVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.parametermanager.v1.RenderParameterVersionRequest,
            com.google.cloud.parametermanager.v1.RenderParameterVersionResponse>
        getRenderParameterVersionMethod;
    if ((getRenderParameterVersionMethod = ParameterManagerGrpc.getRenderParameterVersionMethod)
        == null) {
      synchronized (ParameterManagerGrpc.class) {
        if ((getRenderParameterVersionMethod = ParameterManagerGrpc.getRenderParameterVersionMethod)
            == null) {
          ParameterManagerGrpc.getRenderParameterVersionMethod =
              getRenderParameterVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.parametermanager.v1.RenderParameterVersionRequest,
                          com.google.cloud.parametermanager.v1.RenderParameterVersionResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RenderParameterVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.RenderParameterVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.RenderParameterVersionResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParameterManagerMethodDescriptorSupplier("RenderParameterVersion"))
                      .build();
        }
      }
    }
    return getRenderParameterVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.CreateParameterVersionRequest,
          com.google.cloud.parametermanager.v1.ParameterVersion>
      getCreateParameterVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateParameterVersion",
      requestType = com.google.cloud.parametermanager.v1.CreateParameterVersionRequest.class,
      responseType = com.google.cloud.parametermanager.v1.ParameterVersion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.CreateParameterVersionRequest,
          com.google.cloud.parametermanager.v1.ParameterVersion>
      getCreateParameterVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.parametermanager.v1.CreateParameterVersionRequest,
            com.google.cloud.parametermanager.v1.ParameterVersion>
        getCreateParameterVersionMethod;
    if ((getCreateParameterVersionMethod = ParameterManagerGrpc.getCreateParameterVersionMethod)
        == null) {
      synchronized (ParameterManagerGrpc.class) {
        if ((getCreateParameterVersionMethod = ParameterManagerGrpc.getCreateParameterVersionMethod)
            == null) {
          ParameterManagerGrpc.getCreateParameterVersionMethod =
              getCreateParameterVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.parametermanager.v1.CreateParameterVersionRequest,
                          com.google.cloud.parametermanager.v1.ParameterVersion>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateParameterVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.CreateParameterVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.ParameterVersion
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParameterManagerMethodDescriptorSupplier("CreateParameterVersion"))
                      .build();
        }
      }
    }
    return getCreateParameterVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.UpdateParameterVersionRequest,
          com.google.cloud.parametermanager.v1.ParameterVersion>
      getUpdateParameterVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateParameterVersion",
      requestType = com.google.cloud.parametermanager.v1.UpdateParameterVersionRequest.class,
      responseType = com.google.cloud.parametermanager.v1.ParameterVersion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.UpdateParameterVersionRequest,
          com.google.cloud.parametermanager.v1.ParameterVersion>
      getUpdateParameterVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.parametermanager.v1.UpdateParameterVersionRequest,
            com.google.cloud.parametermanager.v1.ParameterVersion>
        getUpdateParameterVersionMethod;
    if ((getUpdateParameterVersionMethod = ParameterManagerGrpc.getUpdateParameterVersionMethod)
        == null) {
      synchronized (ParameterManagerGrpc.class) {
        if ((getUpdateParameterVersionMethod = ParameterManagerGrpc.getUpdateParameterVersionMethod)
            == null) {
          ParameterManagerGrpc.getUpdateParameterVersionMethod =
              getUpdateParameterVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.parametermanager.v1.UpdateParameterVersionRequest,
                          com.google.cloud.parametermanager.v1.ParameterVersion>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateParameterVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.UpdateParameterVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.ParameterVersion
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParameterManagerMethodDescriptorSupplier("UpdateParameterVersion"))
                      .build();
        }
      }
    }
    return getUpdateParameterVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.DeleteParameterVersionRequest,
          com.google.protobuf.Empty>
      getDeleteParameterVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteParameterVersion",
      requestType = com.google.cloud.parametermanager.v1.DeleteParameterVersionRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.DeleteParameterVersionRequest,
          com.google.protobuf.Empty>
      getDeleteParameterVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.parametermanager.v1.DeleteParameterVersionRequest,
            com.google.protobuf.Empty>
        getDeleteParameterVersionMethod;
    if ((getDeleteParameterVersionMethod = ParameterManagerGrpc.getDeleteParameterVersionMethod)
        == null) {
      synchronized (ParameterManagerGrpc.class) {
        if ((getDeleteParameterVersionMethod = ParameterManagerGrpc.getDeleteParameterVersionMethod)
            == null) {
          ParameterManagerGrpc.getDeleteParameterVersionMethod =
              getDeleteParameterVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.parametermanager.v1.DeleteParameterVersionRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteParameterVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.DeleteParameterVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParameterManagerMethodDescriptorSupplier("DeleteParameterVersion"))
                      .build();
        }
      }
    }
    return getDeleteParameterVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.ListTemplatesRequest,
          com.google.cloud.parametermanager.v1.ListTemplatesResponse>
      getListTemplatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTemplates",
      requestType = com.google.cloud.parametermanager.v1.ListTemplatesRequest.class,
      responseType = com.google.cloud.parametermanager.v1.ListTemplatesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.ListTemplatesRequest,
          com.google.cloud.parametermanager.v1.ListTemplatesResponse>
      getListTemplatesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.parametermanager.v1.ListTemplatesRequest,
            com.google.cloud.parametermanager.v1.ListTemplatesResponse>
        getListTemplatesMethod;
    if ((getListTemplatesMethod = ParameterManagerGrpc.getListTemplatesMethod) == null) {
      synchronized (ParameterManagerGrpc.class) {
        if ((getListTemplatesMethod = ParameterManagerGrpc.getListTemplatesMethod) == null) {
          ParameterManagerGrpc.getListTemplatesMethod =
              getListTemplatesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.parametermanager.v1.ListTemplatesRequest,
                          com.google.cloud.parametermanager.v1.ListTemplatesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTemplates"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.ListTemplatesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.ListTemplatesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParameterManagerMethodDescriptorSupplier("ListTemplates"))
                      .build();
        }
      }
    }
    return getListTemplatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.GetTemplateRequest,
          com.google.cloud.parametermanager.v1.Template>
      getGetTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTemplate",
      requestType = com.google.cloud.parametermanager.v1.GetTemplateRequest.class,
      responseType = com.google.cloud.parametermanager.v1.Template.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.GetTemplateRequest,
          com.google.cloud.parametermanager.v1.Template>
      getGetTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.parametermanager.v1.GetTemplateRequest,
            com.google.cloud.parametermanager.v1.Template>
        getGetTemplateMethod;
    if ((getGetTemplateMethod = ParameterManagerGrpc.getGetTemplateMethod) == null) {
      synchronized (ParameterManagerGrpc.class) {
        if ((getGetTemplateMethod = ParameterManagerGrpc.getGetTemplateMethod) == null) {
          ParameterManagerGrpc.getGetTemplateMethod =
              getGetTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.parametermanager.v1.GetTemplateRequest,
                          com.google.cloud.parametermanager.v1.Template>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.GetTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.Template.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParameterManagerMethodDescriptorSupplier("GetTemplate"))
                      .build();
        }
      }
    }
    return getGetTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.CreateTemplateRequest,
          com.google.cloud.parametermanager.v1.Template>
      getCreateTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTemplate",
      requestType = com.google.cloud.parametermanager.v1.CreateTemplateRequest.class,
      responseType = com.google.cloud.parametermanager.v1.Template.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.CreateTemplateRequest,
          com.google.cloud.parametermanager.v1.Template>
      getCreateTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.parametermanager.v1.CreateTemplateRequest,
            com.google.cloud.parametermanager.v1.Template>
        getCreateTemplateMethod;
    if ((getCreateTemplateMethod = ParameterManagerGrpc.getCreateTemplateMethod) == null) {
      synchronized (ParameterManagerGrpc.class) {
        if ((getCreateTemplateMethod = ParameterManagerGrpc.getCreateTemplateMethod) == null) {
          ParameterManagerGrpc.getCreateTemplateMethod =
              getCreateTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.parametermanager.v1.CreateTemplateRequest,
                          com.google.cloud.parametermanager.v1.Template>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.CreateTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.Template.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParameterManagerMethodDescriptorSupplier("CreateTemplate"))
                      .build();
        }
      }
    }
    return getCreateTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.UpdateTemplateRequest,
          com.google.cloud.parametermanager.v1.Template>
      getUpdateTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTemplate",
      requestType = com.google.cloud.parametermanager.v1.UpdateTemplateRequest.class,
      responseType = com.google.cloud.parametermanager.v1.Template.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.UpdateTemplateRequest,
          com.google.cloud.parametermanager.v1.Template>
      getUpdateTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.parametermanager.v1.UpdateTemplateRequest,
            com.google.cloud.parametermanager.v1.Template>
        getUpdateTemplateMethod;
    if ((getUpdateTemplateMethod = ParameterManagerGrpc.getUpdateTemplateMethod) == null) {
      synchronized (ParameterManagerGrpc.class) {
        if ((getUpdateTemplateMethod = ParameterManagerGrpc.getUpdateTemplateMethod) == null) {
          ParameterManagerGrpc.getUpdateTemplateMethod =
              getUpdateTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.parametermanager.v1.UpdateTemplateRequest,
                          com.google.cloud.parametermanager.v1.Template>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.UpdateTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.Template.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParameterManagerMethodDescriptorSupplier("UpdateTemplate"))
                      .build();
        }
      }
    }
    return getUpdateTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.DeleteTemplateRequest, com.google.protobuf.Empty>
      getDeleteTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTemplate",
      requestType = com.google.cloud.parametermanager.v1.DeleteTemplateRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.DeleteTemplateRequest, com.google.protobuf.Empty>
      getDeleteTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.parametermanager.v1.DeleteTemplateRequest, com.google.protobuf.Empty>
        getDeleteTemplateMethod;
    if ((getDeleteTemplateMethod = ParameterManagerGrpc.getDeleteTemplateMethod) == null) {
      synchronized (ParameterManagerGrpc.class) {
        if ((getDeleteTemplateMethod = ParameterManagerGrpc.getDeleteTemplateMethod) == null) {
          ParameterManagerGrpc.getDeleteTemplateMethod =
              getDeleteTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.parametermanager.v1.DeleteTemplateRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.DeleteTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParameterManagerMethodDescriptorSupplier("DeleteTemplate"))
                      .build();
        }
      }
    }
    return getDeleteTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.ListTemplateVersionsRequest,
          com.google.cloud.parametermanager.v1.ListTemplateVersionsResponse>
      getListTemplateVersionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTemplateVersions",
      requestType = com.google.cloud.parametermanager.v1.ListTemplateVersionsRequest.class,
      responseType = com.google.cloud.parametermanager.v1.ListTemplateVersionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.ListTemplateVersionsRequest,
          com.google.cloud.parametermanager.v1.ListTemplateVersionsResponse>
      getListTemplateVersionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.parametermanager.v1.ListTemplateVersionsRequest,
            com.google.cloud.parametermanager.v1.ListTemplateVersionsResponse>
        getListTemplateVersionsMethod;
    if ((getListTemplateVersionsMethod = ParameterManagerGrpc.getListTemplateVersionsMethod)
        == null) {
      synchronized (ParameterManagerGrpc.class) {
        if ((getListTemplateVersionsMethod = ParameterManagerGrpc.getListTemplateVersionsMethod)
            == null) {
          ParameterManagerGrpc.getListTemplateVersionsMethod =
              getListTemplateVersionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.parametermanager.v1.ListTemplateVersionsRequest,
                          com.google.cloud.parametermanager.v1.ListTemplateVersionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListTemplateVersions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.ListTemplateVersionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.ListTemplateVersionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParameterManagerMethodDescriptorSupplier("ListTemplateVersions"))
                      .build();
        }
      }
    }
    return getListTemplateVersionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.GetTemplateVersionRequest,
          com.google.cloud.parametermanager.v1.TemplateVersion>
      getGetTemplateVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTemplateVersion",
      requestType = com.google.cloud.parametermanager.v1.GetTemplateVersionRequest.class,
      responseType = com.google.cloud.parametermanager.v1.TemplateVersion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.GetTemplateVersionRequest,
          com.google.cloud.parametermanager.v1.TemplateVersion>
      getGetTemplateVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.parametermanager.v1.GetTemplateVersionRequest,
            com.google.cloud.parametermanager.v1.TemplateVersion>
        getGetTemplateVersionMethod;
    if ((getGetTemplateVersionMethod = ParameterManagerGrpc.getGetTemplateVersionMethod) == null) {
      synchronized (ParameterManagerGrpc.class) {
        if ((getGetTemplateVersionMethod = ParameterManagerGrpc.getGetTemplateVersionMethod)
            == null) {
          ParameterManagerGrpc.getGetTemplateVersionMethod =
              getGetTemplateVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.parametermanager.v1.GetTemplateVersionRequest,
                          com.google.cloud.parametermanager.v1.TemplateVersion>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTemplateVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.GetTemplateVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.TemplateVersion
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParameterManagerMethodDescriptorSupplier("GetTemplateVersion"))
                      .build();
        }
      }
    }
    return getGetTemplateVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.CreateTemplateVersionRequest,
          com.google.cloud.parametermanager.v1.TemplateVersion>
      getCreateTemplateVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTemplateVersion",
      requestType = com.google.cloud.parametermanager.v1.CreateTemplateVersionRequest.class,
      responseType = com.google.cloud.parametermanager.v1.TemplateVersion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.CreateTemplateVersionRequest,
          com.google.cloud.parametermanager.v1.TemplateVersion>
      getCreateTemplateVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.parametermanager.v1.CreateTemplateVersionRequest,
            com.google.cloud.parametermanager.v1.TemplateVersion>
        getCreateTemplateVersionMethod;
    if ((getCreateTemplateVersionMethod = ParameterManagerGrpc.getCreateTemplateVersionMethod)
        == null) {
      synchronized (ParameterManagerGrpc.class) {
        if ((getCreateTemplateVersionMethod = ParameterManagerGrpc.getCreateTemplateVersionMethod)
            == null) {
          ParameterManagerGrpc.getCreateTemplateVersionMethod =
              getCreateTemplateVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.parametermanager.v1.CreateTemplateVersionRequest,
                          com.google.cloud.parametermanager.v1.TemplateVersion>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateTemplateVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.CreateTemplateVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.TemplateVersion
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParameterManagerMethodDescriptorSupplier("CreateTemplateVersion"))
                      .build();
        }
      }
    }
    return getCreateTemplateVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.UpdateTemplateVersionRequest,
          com.google.cloud.parametermanager.v1.TemplateVersion>
      getUpdateTemplateVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTemplateVersion",
      requestType = com.google.cloud.parametermanager.v1.UpdateTemplateVersionRequest.class,
      responseType = com.google.cloud.parametermanager.v1.TemplateVersion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.UpdateTemplateVersionRequest,
          com.google.cloud.parametermanager.v1.TemplateVersion>
      getUpdateTemplateVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.parametermanager.v1.UpdateTemplateVersionRequest,
            com.google.cloud.parametermanager.v1.TemplateVersion>
        getUpdateTemplateVersionMethod;
    if ((getUpdateTemplateVersionMethod = ParameterManagerGrpc.getUpdateTemplateVersionMethod)
        == null) {
      synchronized (ParameterManagerGrpc.class) {
        if ((getUpdateTemplateVersionMethod = ParameterManagerGrpc.getUpdateTemplateVersionMethod)
            == null) {
          ParameterManagerGrpc.getUpdateTemplateVersionMethod =
              getUpdateTemplateVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.parametermanager.v1.UpdateTemplateVersionRequest,
                          com.google.cloud.parametermanager.v1.TemplateVersion>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateTemplateVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.UpdateTemplateVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.TemplateVersion
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParameterManagerMethodDescriptorSupplier("UpdateTemplateVersion"))
                      .build();
        }
      }
    }
    return getUpdateTemplateVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.DeleteTemplateVersionRequest,
          com.google.protobuf.Empty>
      getDeleteTemplateVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTemplateVersion",
      requestType = com.google.cloud.parametermanager.v1.DeleteTemplateVersionRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.DeleteTemplateVersionRequest,
          com.google.protobuf.Empty>
      getDeleteTemplateVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.parametermanager.v1.DeleteTemplateVersionRequest,
            com.google.protobuf.Empty>
        getDeleteTemplateVersionMethod;
    if ((getDeleteTemplateVersionMethod = ParameterManagerGrpc.getDeleteTemplateVersionMethod)
        == null) {
      synchronized (ParameterManagerGrpc.class) {
        if ((getDeleteTemplateVersionMethod = ParameterManagerGrpc.getDeleteTemplateVersionMethod)
            == null) {
          ParameterManagerGrpc.getDeleteTemplateVersionMethod =
              getDeleteTemplateVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.parametermanager.v1.DeleteTemplateVersionRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteTemplateVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.DeleteTemplateVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParameterManagerMethodDescriptorSupplier("DeleteTemplateVersion"))
                      .build();
        }
      }
    }
    return getDeleteTemplateVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.RenderTemplateVersionRequest,
          com.google.cloud.parametermanager.v1.RenderTemplateVersionResponse>
      getRenderTemplateVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RenderTemplateVersion",
      requestType = com.google.cloud.parametermanager.v1.RenderTemplateVersionRequest.class,
      responseType = com.google.cloud.parametermanager.v1.RenderTemplateVersionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.parametermanager.v1.RenderTemplateVersionRequest,
          com.google.cloud.parametermanager.v1.RenderTemplateVersionResponse>
      getRenderTemplateVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.parametermanager.v1.RenderTemplateVersionRequest,
            com.google.cloud.parametermanager.v1.RenderTemplateVersionResponse>
        getRenderTemplateVersionMethod;
    if ((getRenderTemplateVersionMethod = ParameterManagerGrpc.getRenderTemplateVersionMethod)
        == null) {
      synchronized (ParameterManagerGrpc.class) {
        if ((getRenderTemplateVersionMethod = ParameterManagerGrpc.getRenderTemplateVersionMethod)
            == null) {
          ParameterManagerGrpc.getRenderTemplateVersionMethod =
              getRenderTemplateVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.parametermanager.v1.RenderTemplateVersionRequest,
                          com.google.cloud.parametermanager.v1.RenderTemplateVersionResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RenderTemplateVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.RenderTemplateVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parametermanager.v1.RenderTemplateVersionResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParameterManagerMethodDescriptorSupplier("RenderTemplateVersion"))
                      .build();
        }
      }
    }
    return getRenderTemplateVersionMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ParameterManagerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ParameterManagerStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ParameterManagerStub>() {
          @java.lang.Override
          public ParameterManagerStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ParameterManagerStub(channel, callOptions);
          }
        };
    return ParameterManagerStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static ParameterManagerBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ParameterManagerBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ParameterManagerBlockingV2Stub>() {
          @java.lang.Override
          public ParameterManagerBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ParameterManagerBlockingV2Stub(channel, callOptions);
          }
        };
    return ParameterManagerBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ParameterManagerBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ParameterManagerBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ParameterManagerBlockingStub>() {
          @java.lang.Override
          public ParameterManagerBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ParameterManagerBlockingStub(channel, callOptions);
          }
        };
    return ParameterManagerBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ParameterManagerFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ParameterManagerFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ParameterManagerFutureStub>() {
          @java.lang.Override
          public ParameterManagerFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ParameterManagerFutureStub(channel, callOptions);
          }
        };
    return ParameterManagerFutureStub.newStub(factory, channel);
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
     * Lists Parameters in a given project and location.
     * </pre>
     */
    default void listParameters(
        com.google.cloud.parametermanager.v1.ListParametersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.ListParametersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListParametersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Parameter.
     * </pre>
     */
    default void getParameter(
        com.google.cloud.parametermanager.v1.GetParameterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.Parameter>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetParameterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Parameter in a given project and location.
     * </pre>
     */
    default void createParameter(
        com.google.cloud.parametermanager.v1.CreateParameterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.Parameter>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateParameterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a single Parameter.
     * </pre>
     */
    default void updateParameter(
        com.google.cloud.parametermanager.v1.UpdateParameterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.Parameter>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateParameterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Parameter.
     * </pre>
     */
    default void deleteParameter(
        com.google.cloud.parametermanager.v1.DeleteParameterRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteParameterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ParameterVersions in a given project, location, and parameter.
     * </pre>
     */
    default void listParameterVersions(
        com.google.cloud.parametermanager.v1.ListParameterVersionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.parametermanager.v1.ListParameterVersionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListParameterVersionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ParameterVersion.
     * </pre>
     */
    default void getParameterVersion(
        com.google.cloud.parametermanager.v1.GetParameterVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.ParameterVersion>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetParameterVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets rendered version of a ParameterVersion.
     * </pre>
     */
    default void renderParameterVersion(
        com.google.cloud.parametermanager.v1.RenderParameterVersionRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.parametermanager.v1.RenderParameterVersionResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRenderParameterVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ParameterVersion in a given project, location, and parameter.
     * </pre>
     */
    default void createParameterVersion(
        com.google.cloud.parametermanager.v1.CreateParameterVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.ParameterVersion>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateParameterVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a single ParameterVersion.
     * </pre>
     */
    default void updateParameterVersion(
        com.google.cloud.parametermanager.v1.UpdateParameterVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.ParameterVersion>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateParameterVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ParameterVersion.
     * </pre>
     */
    default void deleteParameterVersion(
        com.google.cloud.parametermanager.v1.DeleteParameterVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteParameterVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Templates in a given project and location.
     * </pre>
     */
    default void listTemplates(
        com.google.cloud.parametermanager.v1.ListTemplatesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.ListTemplatesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListTemplatesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Template.
     * </pre>
     */
    default void getTemplate(
        com.google.cloud.parametermanager.v1.GetTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.Template>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Template in a given project and location.
     * </pre>
     */
    default void createTemplate(
        com.google.cloud.parametermanager.v1.CreateTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.Template>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a single Template.
     * </pre>
     */
    default void updateTemplate(
        com.google.cloud.parametermanager.v1.UpdateTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.Template>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Template.
     * </pre>
     */
    default void deleteTemplate(
        com.google.cloud.parametermanager.v1.DeleteTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists TemplateVersions in a given project, location, and template.
     * </pre>
     */
    default void listTemplateVersions(
        com.google.cloud.parametermanager.v1.ListTemplateVersionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.parametermanager.v1.ListTemplateVersionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListTemplateVersionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single TemplateVersion.
     * </pre>
     */
    default void getTemplateVersion(
        com.google.cloud.parametermanager.v1.GetTemplateVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.TemplateVersion>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetTemplateVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TemplateVersion in a given project, location, and template.
     * </pre>
     */
    default void createTemplateVersion(
        com.google.cloud.parametermanager.v1.CreateTemplateVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.TemplateVersion>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateTemplateVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a single TemplateVersion.
     * </pre>
     */
    default void updateTemplateVersion(
        com.google.cloud.parametermanager.v1.UpdateTemplateVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.TemplateVersion>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateTemplateVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single TemplateVersion.
     * </pre>
     */
    default void deleteTemplateVersion(
        com.google.cloud.parametermanager.v1.DeleteTemplateVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteTemplateVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets rendered version of a TemplateVersion.
     * </pre>
     */
    default void renderTemplateVersion(
        com.google.cloud.parametermanager.v1.RenderTemplateVersionRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.parametermanager.v1.RenderTemplateVersionResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRenderTemplateVersionMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ParameterManager.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public abstract static class ParameterManagerImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ParameterManagerGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ParameterManager.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class ParameterManagerStub
      extends io.grpc.stub.AbstractAsyncStub<ParameterManagerStub> {
    private ParameterManagerStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ParameterManagerStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ParameterManagerStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Parameters in a given project and location.
     * </pre>
     */
    public void listParameters(
        com.google.cloud.parametermanager.v1.ListParametersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.ListParametersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListParametersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Parameter.
     * </pre>
     */
    public void getParameter(
        com.google.cloud.parametermanager.v1.GetParameterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.Parameter>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetParameterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Parameter in a given project and location.
     * </pre>
     */
    public void createParameter(
        com.google.cloud.parametermanager.v1.CreateParameterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.Parameter>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateParameterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a single Parameter.
     * </pre>
     */
    public void updateParameter(
        com.google.cloud.parametermanager.v1.UpdateParameterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.Parameter>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateParameterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Parameter.
     * </pre>
     */
    public void deleteParameter(
        com.google.cloud.parametermanager.v1.DeleteParameterRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteParameterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ParameterVersions in a given project, location, and parameter.
     * </pre>
     */
    public void listParameterVersions(
        com.google.cloud.parametermanager.v1.ListParameterVersionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.parametermanager.v1.ListParameterVersionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListParameterVersionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ParameterVersion.
     * </pre>
     */
    public void getParameterVersion(
        com.google.cloud.parametermanager.v1.GetParameterVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.ParameterVersion>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetParameterVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets rendered version of a ParameterVersion.
     * </pre>
     */
    public void renderParameterVersion(
        com.google.cloud.parametermanager.v1.RenderParameterVersionRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.parametermanager.v1.RenderParameterVersionResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRenderParameterVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ParameterVersion in a given project, location, and parameter.
     * </pre>
     */
    public void createParameterVersion(
        com.google.cloud.parametermanager.v1.CreateParameterVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.ParameterVersion>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateParameterVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a single ParameterVersion.
     * </pre>
     */
    public void updateParameterVersion(
        com.google.cloud.parametermanager.v1.UpdateParameterVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.ParameterVersion>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateParameterVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ParameterVersion.
     * </pre>
     */
    public void deleteParameterVersion(
        com.google.cloud.parametermanager.v1.DeleteParameterVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteParameterVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Templates in a given project and location.
     * </pre>
     */
    public void listTemplates(
        com.google.cloud.parametermanager.v1.ListTemplatesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.ListTemplatesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTemplatesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Template.
     * </pre>
     */
    public void getTemplate(
        com.google.cloud.parametermanager.v1.GetTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.Template>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Template in a given project and location.
     * </pre>
     */
    public void createTemplate(
        com.google.cloud.parametermanager.v1.CreateTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.Template>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a single Template.
     * </pre>
     */
    public void updateTemplate(
        com.google.cloud.parametermanager.v1.UpdateTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.Template>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Template.
     * </pre>
     */
    public void deleteTemplate(
        com.google.cloud.parametermanager.v1.DeleteTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists TemplateVersions in a given project, location, and template.
     * </pre>
     */
    public void listTemplateVersions(
        com.google.cloud.parametermanager.v1.ListTemplateVersionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.parametermanager.v1.ListTemplateVersionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTemplateVersionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single TemplateVersion.
     * </pre>
     */
    public void getTemplateVersion(
        com.google.cloud.parametermanager.v1.GetTemplateVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.TemplateVersion>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTemplateVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TemplateVersion in a given project, location, and template.
     * </pre>
     */
    public void createTemplateVersion(
        com.google.cloud.parametermanager.v1.CreateTemplateVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.TemplateVersion>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTemplateVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a single TemplateVersion.
     * </pre>
     */
    public void updateTemplateVersion(
        com.google.cloud.parametermanager.v1.UpdateTemplateVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.TemplateVersion>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTemplateVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single TemplateVersion.
     * </pre>
     */
    public void deleteTemplateVersion(
        com.google.cloud.parametermanager.v1.DeleteTemplateVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTemplateVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets rendered version of a TemplateVersion.
     * </pre>
     */
    public void renderTemplateVersion(
        com.google.cloud.parametermanager.v1.RenderTemplateVersionRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.parametermanager.v1.RenderTemplateVersionResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRenderTemplateVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ParameterManager.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class ParameterManagerBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<ParameterManagerBlockingV2Stub> {
    private ParameterManagerBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ParameterManagerBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ParameterManagerBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Parameters in a given project and location.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.ListParametersResponse listParameters(
        com.google.cloud.parametermanager.v1.ListParametersRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListParametersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Parameter.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.Parameter getParameter(
        com.google.cloud.parametermanager.v1.GetParameterRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetParameterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Parameter in a given project and location.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.Parameter createParameter(
        com.google.cloud.parametermanager.v1.CreateParameterRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateParameterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a single Parameter.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.Parameter updateParameter(
        com.google.cloud.parametermanager.v1.UpdateParameterRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateParameterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Parameter.
     * </pre>
     */
    public com.google.protobuf.Empty deleteParameter(
        com.google.cloud.parametermanager.v1.DeleteParameterRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteParameterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ParameterVersions in a given project, location, and parameter.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.ListParameterVersionsResponse listParameterVersions(
        com.google.cloud.parametermanager.v1.ListParameterVersionsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListParameterVersionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ParameterVersion.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.ParameterVersion getParameterVersion(
        com.google.cloud.parametermanager.v1.GetParameterVersionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetParameterVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets rendered version of a ParameterVersion.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.RenderParameterVersionResponse
        renderParameterVersion(
            com.google.cloud.parametermanager.v1.RenderParameterVersionRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRenderParameterVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ParameterVersion in a given project, location, and parameter.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.ParameterVersion createParameterVersion(
        com.google.cloud.parametermanager.v1.CreateParameterVersionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateParameterVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a single ParameterVersion.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.ParameterVersion updateParameterVersion(
        com.google.cloud.parametermanager.v1.UpdateParameterVersionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateParameterVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ParameterVersion.
     * </pre>
     */
    public com.google.protobuf.Empty deleteParameterVersion(
        com.google.cloud.parametermanager.v1.DeleteParameterVersionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteParameterVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Templates in a given project and location.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.ListTemplatesResponse listTemplates(
        com.google.cloud.parametermanager.v1.ListTemplatesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListTemplatesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Template.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.Template getTemplate(
        com.google.cloud.parametermanager.v1.GetTemplateRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Template in a given project and location.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.Template createTemplate(
        com.google.cloud.parametermanager.v1.CreateTemplateRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a single Template.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.Template updateTemplate(
        com.google.cloud.parametermanager.v1.UpdateTemplateRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Template.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTemplate(
        com.google.cloud.parametermanager.v1.DeleteTemplateRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists TemplateVersions in a given project, location, and template.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.ListTemplateVersionsResponse listTemplateVersions(
        com.google.cloud.parametermanager.v1.ListTemplateVersionsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListTemplateVersionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single TemplateVersion.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.TemplateVersion getTemplateVersion(
        com.google.cloud.parametermanager.v1.GetTemplateVersionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetTemplateVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TemplateVersion in a given project, location, and template.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.TemplateVersion createTemplateVersion(
        com.google.cloud.parametermanager.v1.CreateTemplateVersionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateTemplateVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a single TemplateVersion.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.TemplateVersion updateTemplateVersion(
        com.google.cloud.parametermanager.v1.UpdateTemplateVersionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateTemplateVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single TemplateVersion.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTemplateVersion(
        com.google.cloud.parametermanager.v1.DeleteTemplateVersionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteTemplateVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets rendered version of a TemplateVersion.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.RenderTemplateVersionResponse renderTemplateVersion(
        com.google.cloud.parametermanager.v1.RenderTemplateVersionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRenderTemplateVersionMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service ParameterManager.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class ParameterManagerBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ParameterManagerBlockingStub> {
    private ParameterManagerBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ParameterManagerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ParameterManagerBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Parameters in a given project and location.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.ListParametersResponse listParameters(
        com.google.cloud.parametermanager.v1.ListParametersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListParametersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Parameter.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.Parameter getParameter(
        com.google.cloud.parametermanager.v1.GetParameterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetParameterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Parameter in a given project and location.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.Parameter createParameter(
        com.google.cloud.parametermanager.v1.CreateParameterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateParameterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a single Parameter.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.Parameter updateParameter(
        com.google.cloud.parametermanager.v1.UpdateParameterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateParameterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Parameter.
     * </pre>
     */
    public com.google.protobuf.Empty deleteParameter(
        com.google.cloud.parametermanager.v1.DeleteParameterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteParameterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ParameterVersions in a given project, location, and parameter.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.ListParameterVersionsResponse listParameterVersions(
        com.google.cloud.parametermanager.v1.ListParameterVersionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListParameterVersionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ParameterVersion.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.ParameterVersion getParameterVersion(
        com.google.cloud.parametermanager.v1.GetParameterVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetParameterVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets rendered version of a ParameterVersion.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.RenderParameterVersionResponse
        renderParameterVersion(
            com.google.cloud.parametermanager.v1.RenderParameterVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRenderParameterVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ParameterVersion in a given project, location, and parameter.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.ParameterVersion createParameterVersion(
        com.google.cloud.parametermanager.v1.CreateParameterVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateParameterVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a single ParameterVersion.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.ParameterVersion updateParameterVersion(
        com.google.cloud.parametermanager.v1.UpdateParameterVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateParameterVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ParameterVersion.
     * </pre>
     */
    public com.google.protobuf.Empty deleteParameterVersion(
        com.google.cloud.parametermanager.v1.DeleteParameterVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteParameterVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Templates in a given project and location.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.ListTemplatesResponse listTemplates(
        com.google.cloud.parametermanager.v1.ListTemplatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTemplatesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Template.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.Template getTemplate(
        com.google.cloud.parametermanager.v1.GetTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Template in a given project and location.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.Template createTemplate(
        com.google.cloud.parametermanager.v1.CreateTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a single Template.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.Template updateTemplate(
        com.google.cloud.parametermanager.v1.UpdateTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Template.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTemplate(
        com.google.cloud.parametermanager.v1.DeleteTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists TemplateVersions in a given project, location, and template.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.ListTemplateVersionsResponse listTemplateVersions(
        com.google.cloud.parametermanager.v1.ListTemplateVersionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTemplateVersionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single TemplateVersion.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.TemplateVersion getTemplateVersion(
        com.google.cloud.parametermanager.v1.GetTemplateVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTemplateVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TemplateVersion in a given project, location, and template.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.TemplateVersion createTemplateVersion(
        com.google.cloud.parametermanager.v1.CreateTemplateVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTemplateVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a single TemplateVersion.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.TemplateVersion updateTemplateVersion(
        com.google.cloud.parametermanager.v1.UpdateTemplateVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTemplateVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single TemplateVersion.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTemplateVersion(
        com.google.cloud.parametermanager.v1.DeleteTemplateVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTemplateVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets rendered version of a TemplateVersion.
     * </pre>
     */
    public com.google.cloud.parametermanager.v1.RenderTemplateVersionResponse renderTemplateVersion(
        com.google.cloud.parametermanager.v1.RenderTemplateVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRenderTemplateVersionMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ParameterManager.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class ParameterManagerFutureStub
      extends io.grpc.stub.AbstractFutureStub<ParameterManagerFutureStub> {
    private ParameterManagerFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ParameterManagerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ParameterManagerFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Parameters in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.parametermanager.v1.ListParametersResponse>
        listParameters(com.google.cloud.parametermanager.v1.ListParametersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListParametersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Parameter.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.parametermanager.v1.Parameter>
        getParameter(com.google.cloud.parametermanager.v1.GetParameterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetParameterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Parameter in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.parametermanager.v1.Parameter>
        createParameter(com.google.cloud.parametermanager.v1.CreateParameterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateParameterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a single Parameter.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.parametermanager.v1.Parameter>
        updateParameter(com.google.cloud.parametermanager.v1.UpdateParameterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateParameterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Parameter.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteParameter(com.google.cloud.parametermanager.v1.DeleteParameterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteParameterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ParameterVersions in a given project, location, and parameter.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.parametermanager.v1.ListParameterVersionsResponse>
        listParameterVersions(
            com.google.cloud.parametermanager.v1.ListParameterVersionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListParameterVersionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ParameterVersion.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.parametermanager.v1.ParameterVersion>
        getParameterVersion(
            com.google.cloud.parametermanager.v1.GetParameterVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetParameterVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets rendered version of a ParameterVersion.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.parametermanager.v1.RenderParameterVersionResponse>
        renderParameterVersion(
            com.google.cloud.parametermanager.v1.RenderParameterVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRenderParameterVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ParameterVersion in a given project, location, and parameter.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.parametermanager.v1.ParameterVersion>
        createParameterVersion(
            com.google.cloud.parametermanager.v1.CreateParameterVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateParameterVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a single ParameterVersion.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.parametermanager.v1.ParameterVersion>
        updateParameterVersion(
            com.google.cloud.parametermanager.v1.UpdateParameterVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateParameterVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ParameterVersion.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteParameterVersion(
            com.google.cloud.parametermanager.v1.DeleteParameterVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteParameterVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Templates in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.parametermanager.v1.ListTemplatesResponse>
        listTemplates(com.google.cloud.parametermanager.v1.ListTemplatesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTemplatesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.parametermanager.v1.Template>
        getTemplate(com.google.cloud.parametermanager.v1.GetTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Template in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.parametermanager.v1.Template>
        createTemplate(com.google.cloud.parametermanager.v1.CreateTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a single Template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.parametermanager.v1.Template>
        updateTemplate(com.google.cloud.parametermanager.v1.UpdateTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteTemplate(com.google.cloud.parametermanager.v1.DeleteTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists TemplateVersions in a given project, location, and template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.parametermanager.v1.ListTemplateVersionsResponse>
        listTemplateVersions(
            com.google.cloud.parametermanager.v1.ListTemplateVersionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTemplateVersionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single TemplateVersion.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.parametermanager.v1.TemplateVersion>
        getTemplateVersion(com.google.cloud.parametermanager.v1.GetTemplateVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTemplateVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TemplateVersion in a given project, location, and template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.parametermanager.v1.TemplateVersion>
        createTemplateVersion(
            com.google.cloud.parametermanager.v1.CreateTemplateVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTemplateVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a single TemplateVersion.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.parametermanager.v1.TemplateVersion>
        updateTemplateVersion(
            com.google.cloud.parametermanager.v1.UpdateTemplateVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTemplateVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single TemplateVersion.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteTemplateVersion(
            com.google.cloud.parametermanager.v1.DeleteTemplateVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTemplateVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets rendered version of a TemplateVersion.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.parametermanager.v1.RenderTemplateVersionResponse>
        renderTemplateVersion(
            com.google.cloud.parametermanager.v1.RenderTemplateVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRenderTemplateVersionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_PARAMETERS = 0;
  private static final int METHODID_GET_PARAMETER = 1;
  private static final int METHODID_CREATE_PARAMETER = 2;
  private static final int METHODID_UPDATE_PARAMETER = 3;
  private static final int METHODID_DELETE_PARAMETER = 4;
  private static final int METHODID_LIST_PARAMETER_VERSIONS = 5;
  private static final int METHODID_GET_PARAMETER_VERSION = 6;
  private static final int METHODID_RENDER_PARAMETER_VERSION = 7;
  private static final int METHODID_CREATE_PARAMETER_VERSION = 8;
  private static final int METHODID_UPDATE_PARAMETER_VERSION = 9;
  private static final int METHODID_DELETE_PARAMETER_VERSION = 10;
  private static final int METHODID_LIST_TEMPLATES = 11;
  private static final int METHODID_GET_TEMPLATE = 12;
  private static final int METHODID_CREATE_TEMPLATE = 13;
  private static final int METHODID_UPDATE_TEMPLATE = 14;
  private static final int METHODID_DELETE_TEMPLATE = 15;
  private static final int METHODID_LIST_TEMPLATE_VERSIONS = 16;
  private static final int METHODID_GET_TEMPLATE_VERSION = 17;
  private static final int METHODID_CREATE_TEMPLATE_VERSION = 18;
  private static final int METHODID_UPDATE_TEMPLATE_VERSION = 19;
  private static final int METHODID_DELETE_TEMPLATE_VERSION = 20;
  private static final int METHODID_RENDER_TEMPLATE_VERSION = 21;

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
        case METHODID_LIST_PARAMETERS:
          serviceImpl.listParameters(
              (com.google.cloud.parametermanager.v1.ListParametersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.parametermanager.v1.ListParametersResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PARAMETER:
          serviceImpl.getParameter(
              (com.google.cloud.parametermanager.v1.GetParameterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.Parameter>)
                  responseObserver);
          break;
        case METHODID_CREATE_PARAMETER:
          serviceImpl.createParameter(
              (com.google.cloud.parametermanager.v1.CreateParameterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.Parameter>)
                  responseObserver);
          break;
        case METHODID_UPDATE_PARAMETER:
          serviceImpl.updateParameter(
              (com.google.cloud.parametermanager.v1.UpdateParameterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.Parameter>)
                  responseObserver);
          break;
        case METHODID_DELETE_PARAMETER:
          serviceImpl.deleteParameter(
              (com.google.cloud.parametermanager.v1.DeleteParameterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_PARAMETER_VERSIONS:
          serviceImpl.listParameterVersions(
              (com.google.cloud.parametermanager.v1.ListParameterVersionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.parametermanager.v1.ListParameterVersionsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PARAMETER_VERSION:
          serviceImpl.getParameterVersion(
              (com.google.cloud.parametermanager.v1.GetParameterVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.ParameterVersion>)
                  responseObserver);
          break;
        case METHODID_RENDER_PARAMETER_VERSION:
          serviceImpl.renderParameterVersion(
              (com.google.cloud.parametermanager.v1.RenderParameterVersionRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.parametermanager.v1.RenderParameterVersionResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_PARAMETER_VERSION:
          serviceImpl.createParameterVersion(
              (com.google.cloud.parametermanager.v1.CreateParameterVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.ParameterVersion>)
                  responseObserver);
          break;
        case METHODID_UPDATE_PARAMETER_VERSION:
          serviceImpl.updateParameterVersion(
              (com.google.cloud.parametermanager.v1.UpdateParameterVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.ParameterVersion>)
                  responseObserver);
          break;
        case METHODID_DELETE_PARAMETER_VERSION:
          serviceImpl.deleteParameterVersion(
              (com.google.cloud.parametermanager.v1.DeleteParameterVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_TEMPLATES:
          serviceImpl.listTemplates(
              (com.google.cloud.parametermanager.v1.ListTemplatesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.parametermanager.v1.ListTemplatesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_TEMPLATE:
          serviceImpl.getTemplate(
              (com.google.cloud.parametermanager.v1.GetTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.Template>)
                  responseObserver);
          break;
        case METHODID_CREATE_TEMPLATE:
          serviceImpl.createTemplate(
              (com.google.cloud.parametermanager.v1.CreateTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.Template>)
                  responseObserver);
          break;
        case METHODID_UPDATE_TEMPLATE:
          serviceImpl.updateTemplate(
              (com.google.cloud.parametermanager.v1.UpdateTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.Template>)
                  responseObserver);
          break;
        case METHODID_DELETE_TEMPLATE:
          serviceImpl.deleteTemplate(
              (com.google.cloud.parametermanager.v1.DeleteTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_TEMPLATE_VERSIONS:
          serviceImpl.listTemplateVersions(
              (com.google.cloud.parametermanager.v1.ListTemplateVersionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.parametermanager.v1.ListTemplateVersionsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_TEMPLATE_VERSION:
          serviceImpl.getTemplateVersion(
              (com.google.cloud.parametermanager.v1.GetTemplateVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.TemplateVersion>)
                  responseObserver);
          break;
        case METHODID_CREATE_TEMPLATE_VERSION:
          serviceImpl.createTemplateVersion(
              (com.google.cloud.parametermanager.v1.CreateTemplateVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.TemplateVersion>)
                  responseObserver);
          break;
        case METHODID_UPDATE_TEMPLATE_VERSION:
          serviceImpl.updateTemplateVersion(
              (com.google.cloud.parametermanager.v1.UpdateTemplateVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.parametermanager.v1.TemplateVersion>)
                  responseObserver);
          break;
        case METHODID_DELETE_TEMPLATE_VERSION:
          serviceImpl.deleteTemplateVersion(
              (com.google.cloud.parametermanager.v1.DeleteTemplateVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_RENDER_TEMPLATE_VERSION:
          serviceImpl.renderTemplateVersion(
              (com.google.cloud.parametermanager.v1.RenderTemplateVersionRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.parametermanager.v1.RenderTemplateVersionResponse>)
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
            getListParametersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.parametermanager.v1.ListParametersRequest,
                    com.google.cloud.parametermanager.v1.ListParametersResponse>(
                    service, METHODID_LIST_PARAMETERS)))
        .addMethod(
            getGetParameterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.parametermanager.v1.GetParameterRequest,
                    com.google.cloud.parametermanager.v1.Parameter>(
                    service, METHODID_GET_PARAMETER)))
        .addMethod(
            getCreateParameterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.parametermanager.v1.CreateParameterRequest,
                    com.google.cloud.parametermanager.v1.Parameter>(
                    service, METHODID_CREATE_PARAMETER)))
        .addMethod(
            getUpdateParameterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.parametermanager.v1.UpdateParameterRequest,
                    com.google.cloud.parametermanager.v1.Parameter>(
                    service, METHODID_UPDATE_PARAMETER)))
        .addMethod(
            getDeleteParameterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.parametermanager.v1.DeleteParameterRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_PARAMETER)))
        .addMethod(
            getListParameterVersionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.parametermanager.v1.ListParameterVersionsRequest,
                    com.google.cloud.parametermanager.v1.ListParameterVersionsResponse>(
                    service, METHODID_LIST_PARAMETER_VERSIONS)))
        .addMethod(
            getGetParameterVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.parametermanager.v1.GetParameterVersionRequest,
                    com.google.cloud.parametermanager.v1.ParameterVersion>(
                    service, METHODID_GET_PARAMETER_VERSION)))
        .addMethod(
            getRenderParameterVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.parametermanager.v1.RenderParameterVersionRequest,
                    com.google.cloud.parametermanager.v1.RenderParameterVersionResponse>(
                    service, METHODID_RENDER_PARAMETER_VERSION)))
        .addMethod(
            getCreateParameterVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.parametermanager.v1.CreateParameterVersionRequest,
                    com.google.cloud.parametermanager.v1.ParameterVersion>(
                    service, METHODID_CREATE_PARAMETER_VERSION)))
        .addMethod(
            getUpdateParameterVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.parametermanager.v1.UpdateParameterVersionRequest,
                    com.google.cloud.parametermanager.v1.ParameterVersion>(
                    service, METHODID_UPDATE_PARAMETER_VERSION)))
        .addMethod(
            getDeleteParameterVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.parametermanager.v1.DeleteParameterVersionRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_PARAMETER_VERSION)))
        .addMethod(
            getListTemplatesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.parametermanager.v1.ListTemplatesRequest,
                    com.google.cloud.parametermanager.v1.ListTemplatesResponse>(
                    service, METHODID_LIST_TEMPLATES)))
        .addMethod(
            getGetTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.parametermanager.v1.GetTemplateRequest,
                    com.google.cloud.parametermanager.v1.Template>(service, METHODID_GET_TEMPLATE)))
        .addMethod(
            getCreateTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.parametermanager.v1.CreateTemplateRequest,
                    com.google.cloud.parametermanager.v1.Template>(
                    service, METHODID_CREATE_TEMPLATE)))
        .addMethod(
            getUpdateTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.parametermanager.v1.UpdateTemplateRequest,
                    com.google.cloud.parametermanager.v1.Template>(
                    service, METHODID_UPDATE_TEMPLATE)))
        .addMethod(
            getDeleteTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.parametermanager.v1.DeleteTemplateRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_TEMPLATE)))
        .addMethod(
            getListTemplateVersionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.parametermanager.v1.ListTemplateVersionsRequest,
                    com.google.cloud.parametermanager.v1.ListTemplateVersionsResponse>(
                    service, METHODID_LIST_TEMPLATE_VERSIONS)))
        .addMethod(
            getGetTemplateVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.parametermanager.v1.GetTemplateVersionRequest,
                    com.google.cloud.parametermanager.v1.TemplateVersion>(
                    service, METHODID_GET_TEMPLATE_VERSION)))
        .addMethod(
            getCreateTemplateVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.parametermanager.v1.CreateTemplateVersionRequest,
                    com.google.cloud.parametermanager.v1.TemplateVersion>(
                    service, METHODID_CREATE_TEMPLATE_VERSION)))
        .addMethod(
            getUpdateTemplateVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.parametermanager.v1.UpdateTemplateVersionRequest,
                    com.google.cloud.parametermanager.v1.TemplateVersion>(
                    service, METHODID_UPDATE_TEMPLATE_VERSION)))
        .addMethod(
            getDeleteTemplateVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.parametermanager.v1.DeleteTemplateVersionRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_TEMPLATE_VERSION)))
        .addMethod(
            getRenderTemplateVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.parametermanager.v1.RenderTemplateVersionRequest,
                    com.google.cloud.parametermanager.v1.RenderTemplateVersionResponse>(
                    service, METHODID_RENDER_TEMPLATE_VERSION)))
        .build();
  }

  private abstract static class ParameterManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ParameterManagerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.parametermanager.v1.V1mainProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ParameterManager");
    }
  }

  private static final class ParameterManagerFileDescriptorSupplier
      extends ParameterManagerBaseDescriptorSupplier {
    ParameterManagerFileDescriptorSupplier() {}
  }

  private static final class ParameterManagerMethodDescriptorSupplier
      extends ParameterManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ParameterManagerMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ParameterManagerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ParameterManagerFileDescriptorSupplier())
                      .addMethod(getListParametersMethod())
                      .addMethod(getGetParameterMethod())
                      .addMethod(getCreateParameterMethod())
                      .addMethod(getUpdateParameterMethod())
                      .addMethod(getDeleteParameterMethod())
                      .addMethod(getListParameterVersionsMethod())
                      .addMethod(getGetParameterVersionMethod())
                      .addMethod(getRenderParameterVersionMethod())
                      .addMethod(getCreateParameterVersionMethod())
                      .addMethod(getUpdateParameterVersionMethod())
                      .addMethod(getDeleteParameterVersionMethod())
                      .addMethod(getListTemplatesMethod())
                      .addMethod(getGetTemplateMethod())
                      .addMethod(getCreateTemplateMethod())
                      .addMethod(getUpdateTemplateMethod())
                      .addMethod(getDeleteTemplateMethod())
                      .addMethod(getListTemplateVersionsMethod())
                      .addMethod(getGetTemplateVersionMethod())
                      .addMethod(getCreateTemplateVersionMethod())
                      .addMethod(getUpdateTemplateVersionMethod())
                      .addMethod(getDeleteTemplateVersionMethod())
                      .addMethod(getRenderTemplateVersionMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
