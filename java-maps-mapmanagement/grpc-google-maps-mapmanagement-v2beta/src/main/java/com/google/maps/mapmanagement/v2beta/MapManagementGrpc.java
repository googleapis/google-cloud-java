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
package com.google.maps.mapmanagement.v2beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The Map Management API uses your inputs to create and manage
 * Google Cloud based styling resources for Google Maps.
 * Using this API, you can can create and manage MapConfigs (Map IDs),
 * StyleConfigs (JSON-based styling), and MapContextConfigs (associations
 * between styles, datasets, and map variants).
 * This API offers features through three channels:
 * * `v2alpha`: Experimental features.
 * * `v2beta`: Preview features, recommended for early adoption.
 * * `v2`: General Availability (GA) features.
 * Capabilities described here are generally available across both the v2alpha
 * and v2beta endpoints.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class MapManagementGrpc {

  private MapManagementGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.maps.mapmanagement.v2beta.MapManagement";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.mapmanagement.v2beta.CreateMapConfigRequest,
          com.google.maps.mapmanagement.v2beta.MapConfig>
      getCreateMapConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMapConfig",
      requestType = com.google.maps.mapmanagement.v2beta.CreateMapConfigRequest.class,
      responseType = com.google.maps.mapmanagement.v2beta.MapConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.mapmanagement.v2beta.CreateMapConfigRequest,
          com.google.maps.mapmanagement.v2beta.MapConfig>
      getCreateMapConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.mapmanagement.v2beta.CreateMapConfigRequest,
            com.google.maps.mapmanagement.v2beta.MapConfig>
        getCreateMapConfigMethod;
    if ((getCreateMapConfigMethod = MapManagementGrpc.getCreateMapConfigMethod) == null) {
      synchronized (MapManagementGrpc.class) {
        if ((getCreateMapConfigMethod = MapManagementGrpc.getCreateMapConfigMethod) == null) {
          MapManagementGrpc.getCreateMapConfigMethod =
              getCreateMapConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.mapmanagement.v2beta.CreateMapConfigRequest,
                          com.google.maps.mapmanagement.v2beta.MapConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateMapConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapmanagement.v2beta.CreateMapConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapmanagement.v2beta.MapConfig.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MapManagementMethodDescriptorSupplier("CreateMapConfig"))
                      .build();
        }
      }
    }
    return getCreateMapConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.mapmanagement.v2beta.GetMapConfigRequest,
          com.google.maps.mapmanagement.v2beta.MapConfig>
      getGetMapConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMapConfig",
      requestType = com.google.maps.mapmanagement.v2beta.GetMapConfigRequest.class,
      responseType = com.google.maps.mapmanagement.v2beta.MapConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.mapmanagement.v2beta.GetMapConfigRequest,
          com.google.maps.mapmanagement.v2beta.MapConfig>
      getGetMapConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.mapmanagement.v2beta.GetMapConfigRequest,
            com.google.maps.mapmanagement.v2beta.MapConfig>
        getGetMapConfigMethod;
    if ((getGetMapConfigMethod = MapManagementGrpc.getGetMapConfigMethod) == null) {
      synchronized (MapManagementGrpc.class) {
        if ((getGetMapConfigMethod = MapManagementGrpc.getGetMapConfigMethod) == null) {
          MapManagementGrpc.getGetMapConfigMethod =
              getGetMapConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.mapmanagement.v2beta.GetMapConfigRequest,
                          com.google.maps.mapmanagement.v2beta.MapConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMapConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapmanagement.v2beta.GetMapConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapmanagement.v2beta.MapConfig.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MapManagementMethodDescriptorSupplier("GetMapConfig"))
                      .build();
        }
      }
    }
    return getGetMapConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.mapmanagement.v2beta.ListMapConfigsRequest,
          com.google.maps.mapmanagement.v2beta.ListMapConfigsResponse>
      getListMapConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMapConfigs",
      requestType = com.google.maps.mapmanagement.v2beta.ListMapConfigsRequest.class,
      responseType = com.google.maps.mapmanagement.v2beta.ListMapConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.mapmanagement.v2beta.ListMapConfigsRequest,
          com.google.maps.mapmanagement.v2beta.ListMapConfigsResponse>
      getListMapConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.mapmanagement.v2beta.ListMapConfigsRequest,
            com.google.maps.mapmanagement.v2beta.ListMapConfigsResponse>
        getListMapConfigsMethod;
    if ((getListMapConfigsMethod = MapManagementGrpc.getListMapConfigsMethod) == null) {
      synchronized (MapManagementGrpc.class) {
        if ((getListMapConfigsMethod = MapManagementGrpc.getListMapConfigsMethod) == null) {
          MapManagementGrpc.getListMapConfigsMethod =
              getListMapConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.mapmanagement.v2beta.ListMapConfigsRequest,
                          com.google.maps.mapmanagement.v2beta.ListMapConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListMapConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapmanagement.v2beta.ListMapConfigsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapmanagement.v2beta.ListMapConfigsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MapManagementMethodDescriptorSupplier("ListMapConfigs"))
                      .build();
        }
      }
    }
    return getListMapConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.mapmanagement.v2beta.UpdateMapConfigRequest,
          com.google.maps.mapmanagement.v2beta.MapConfig>
      getUpdateMapConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateMapConfig",
      requestType = com.google.maps.mapmanagement.v2beta.UpdateMapConfigRequest.class,
      responseType = com.google.maps.mapmanagement.v2beta.MapConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.mapmanagement.v2beta.UpdateMapConfigRequest,
          com.google.maps.mapmanagement.v2beta.MapConfig>
      getUpdateMapConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.mapmanagement.v2beta.UpdateMapConfigRequest,
            com.google.maps.mapmanagement.v2beta.MapConfig>
        getUpdateMapConfigMethod;
    if ((getUpdateMapConfigMethod = MapManagementGrpc.getUpdateMapConfigMethod) == null) {
      synchronized (MapManagementGrpc.class) {
        if ((getUpdateMapConfigMethod = MapManagementGrpc.getUpdateMapConfigMethod) == null) {
          MapManagementGrpc.getUpdateMapConfigMethod =
              getUpdateMapConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.mapmanagement.v2beta.UpdateMapConfigRequest,
                          com.google.maps.mapmanagement.v2beta.MapConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateMapConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapmanagement.v2beta.UpdateMapConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapmanagement.v2beta.MapConfig.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MapManagementMethodDescriptorSupplier("UpdateMapConfig"))
                      .build();
        }
      }
    }
    return getUpdateMapConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.mapmanagement.v2beta.DeleteMapConfigRequest, com.google.protobuf.Empty>
      getDeleteMapConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMapConfig",
      requestType = com.google.maps.mapmanagement.v2beta.DeleteMapConfigRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.mapmanagement.v2beta.DeleteMapConfigRequest, com.google.protobuf.Empty>
      getDeleteMapConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.mapmanagement.v2beta.DeleteMapConfigRequest, com.google.protobuf.Empty>
        getDeleteMapConfigMethod;
    if ((getDeleteMapConfigMethod = MapManagementGrpc.getDeleteMapConfigMethod) == null) {
      synchronized (MapManagementGrpc.class) {
        if ((getDeleteMapConfigMethod = MapManagementGrpc.getDeleteMapConfigMethod) == null) {
          MapManagementGrpc.getDeleteMapConfigMethod =
              getDeleteMapConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.mapmanagement.v2beta.DeleteMapConfigRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteMapConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapmanagement.v2beta.DeleteMapConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MapManagementMethodDescriptorSupplier("DeleteMapConfig"))
                      .build();
        }
      }
    }
    return getDeleteMapConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.mapmanagement.v2beta.CreateStyleConfigRequest,
          com.google.maps.mapmanagement.v2beta.StyleConfig>
      getCreateStyleConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateStyleConfig",
      requestType = com.google.maps.mapmanagement.v2beta.CreateStyleConfigRequest.class,
      responseType = com.google.maps.mapmanagement.v2beta.StyleConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.mapmanagement.v2beta.CreateStyleConfigRequest,
          com.google.maps.mapmanagement.v2beta.StyleConfig>
      getCreateStyleConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.mapmanagement.v2beta.CreateStyleConfigRequest,
            com.google.maps.mapmanagement.v2beta.StyleConfig>
        getCreateStyleConfigMethod;
    if ((getCreateStyleConfigMethod = MapManagementGrpc.getCreateStyleConfigMethod) == null) {
      synchronized (MapManagementGrpc.class) {
        if ((getCreateStyleConfigMethod = MapManagementGrpc.getCreateStyleConfigMethod) == null) {
          MapManagementGrpc.getCreateStyleConfigMethod =
              getCreateStyleConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.mapmanagement.v2beta.CreateStyleConfigRequest,
                          com.google.maps.mapmanagement.v2beta.StyleConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateStyleConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapmanagement.v2beta.CreateStyleConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapmanagement.v2beta.StyleConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MapManagementMethodDescriptorSupplier("CreateStyleConfig"))
                      .build();
        }
      }
    }
    return getCreateStyleConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.mapmanagement.v2beta.GetStyleConfigRequest,
          com.google.maps.mapmanagement.v2beta.StyleConfig>
      getGetStyleConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStyleConfig",
      requestType = com.google.maps.mapmanagement.v2beta.GetStyleConfigRequest.class,
      responseType = com.google.maps.mapmanagement.v2beta.StyleConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.mapmanagement.v2beta.GetStyleConfigRequest,
          com.google.maps.mapmanagement.v2beta.StyleConfig>
      getGetStyleConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.mapmanagement.v2beta.GetStyleConfigRequest,
            com.google.maps.mapmanagement.v2beta.StyleConfig>
        getGetStyleConfigMethod;
    if ((getGetStyleConfigMethod = MapManagementGrpc.getGetStyleConfigMethod) == null) {
      synchronized (MapManagementGrpc.class) {
        if ((getGetStyleConfigMethod = MapManagementGrpc.getGetStyleConfigMethod) == null) {
          MapManagementGrpc.getGetStyleConfigMethod =
              getGetStyleConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.mapmanagement.v2beta.GetStyleConfigRequest,
                          com.google.maps.mapmanagement.v2beta.StyleConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetStyleConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapmanagement.v2beta.GetStyleConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapmanagement.v2beta.StyleConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MapManagementMethodDescriptorSupplier("GetStyleConfig"))
                      .build();
        }
      }
    }
    return getGetStyleConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.mapmanagement.v2beta.ListStyleConfigsRequest,
          com.google.maps.mapmanagement.v2beta.ListStyleConfigsResponse>
      getListStyleConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListStyleConfigs",
      requestType = com.google.maps.mapmanagement.v2beta.ListStyleConfigsRequest.class,
      responseType = com.google.maps.mapmanagement.v2beta.ListStyleConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.mapmanagement.v2beta.ListStyleConfigsRequest,
          com.google.maps.mapmanagement.v2beta.ListStyleConfigsResponse>
      getListStyleConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.mapmanagement.v2beta.ListStyleConfigsRequest,
            com.google.maps.mapmanagement.v2beta.ListStyleConfigsResponse>
        getListStyleConfigsMethod;
    if ((getListStyleConfigsMethod = MapManagementGrpc.getListStyleConfigsMethod) == null) {
      synchronized (MapManagementGrpc.class) {
        if ((getListStyleConfigsMethod = MapManagementGrpc.getListStyleConfigsMethod) == null) {
          MapManagementGrpc.getListStyleConfigsMethod =
              getListStyleConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.mapmanagement.v2beta.ListStyleConfigsRequest,
                          com.google.maps.mapmanagement.v2beta.ListStyleConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListStyleConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapmanagement.v2beta.ListStyleConfigsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapmanagement.v2beta.ListStyleConfigsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MapManagementMethodDescriptorSupplier("ListStyleConfigs"))
                      .build();
        }
      }
    }
    return getListStyleConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.mapmanagement.v2beta.UpdateStyleConfigRequest,
          com.google.maps.mapmanagement.v2beta.StyleConfig>
      getUpdateStyleConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateStyleConfig",
      requestType = com.google.maps.mapmanagement.v2beta.UpdateStyleConfigRequest.class,
      responseType = com.google.maps.mapmanagement.v2beta.StyleConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.mapmanagement.v2beta.UpdateStyleConfigRequest,
          com.google.maps.mapmanagement.v2beta.StyleConfig>
      getUpdateStyleConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.mapmanagement.v2beta.UpdateStyleConfigRequest,
            com.google.maps.mapmanagement.v2beta.StyleConfig>
        getUpdateStyleConfigMethod;
    if ((getUpdateStyleConfigMethod = MapManagementGrpc.getUpdateStyleConfigMethod) == null) {
      synchronized (MapManagementGrpc.class) {
        if ((getUpdateStyleConfigMethod = MapManagementGrpc.getUpdateStyleConfigMethod) == null) {
          MapManagementGrpc.getUpdateStyleConfigMethod =
              getUpdateStyleConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.mapmanagement.v2beta.UpdateStyleConfigRequest,
                          com.google.maps.mapmanagement.v2beta.StyleConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateStyleConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapmanagement.v2beta.UpdateStyleConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapmanagement.v2beta.StyleConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MapManagementMethodDescriptorSupplier("UpdateStyleConfig"))
                      .build();
        }
      }
    }
    return getUpdateStyleConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.mapmanagement.v2beta.DeleteStyleConfigRequest, com.google.protobuf.Empty>
      getDeleteStyleConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteStyleConfig",
      requestType = com.google.maps.mapmanagement.v2beta.DeleteStyleConfigRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.mapmanagement.v2beta.DeleteStyleConfigRequest, com.google.protobuf.Empty>
      getDeleteStyleConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.mapmanagement.v2beta.DeleteStyleConfigRequest,
            com.google.protobuf.Empty>
        getDeleteStyleConfigMethod;
    if ((getDeleteStyleConfigMethod = MapManagementGrpc.getDeleteStyleConfigMethod) == null) {
      synchronized (MapManagementGrpc.class) {
        if ((getDeleteStyleConfigMethod = MapManagementGrpc.getDeleteStyleConfigMethod) == null) {
          MapManagementGrpc.getDeleteStyleConfigMethod =
              getDeleteStyleConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.mapmanagement.v2beta.DeleteStyleConfigRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteStyleConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapmanagement.v2beta.DeleteStyleConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MapManagementMethodDescriptorSupplier("DeleteStyleConfig"))
                      .build();
        }
      }
    }
    return getDeleteStyleConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.mapmanagement.v2beta.CreateMapContextConfigRequest,
          com.google.maps.mapmanagement.v2beta.MapContextConfig>
      getCreateMapContextConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMapContextConfig",
      requestType = com.google.maps.mapmanagement.v2beta.CreateMapContextConfigRequest.class,
      responseType = com.google.maps.mapmanagement.v2beta.MapContextConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.mapmanagement.v2beta.CreateMapContextConfigRequest,
          com.google.maps.mapmanagement.v2beta.MapContextConfig>
      getCreateMapContextConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.mapmanagement.v2beta.CreateMapContextConfigRequest,
            com.google.maps.mapmanagement.v2beta.MapContextConfig>
        getCreateMapContextConfigMethod;
    if ((getCreateMapContextConfigMethod = MapManagementGrpc.getCreateMapContextConfigMethod)
        == null) {
      synchronized (MapManagementGrpc.class) {
        if ((getCreateMapContextConfigMethod = MapManagementGrpc.getCreateMapContextConfigMethod)
            == null) {
          MapManagementGrpc.getCreateMapContextConfigMethod =
              getCreateMapContextConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.mapmanagement.v2beta.CreateMapContextConfigRequest,
                          com.google.maps.mapmanagement.v2beta.MapContextConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateMapContextConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapmanagement.v2beta.CreateMapContextConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapmanagement.v2beta.MapContextConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MapManagementMethodDescriptorSupplier("CreateMapContextConfig"))
                      .build();
        }
      }
    }
    return getCreateMapContextConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.mapmanagement.v2beta.GetMapContextConfigRequest,
          com.google.maps.mapmanagement.v2beta.MapContextConfig>
      getGetMapContextConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMapContextConfig",
      requestType = com.google.maps.mapmanagement.v2beta.GetMapContextConfigRequest.class,
      responseType = com.google.maps.mapmanagement.v2beta.MapContextConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.mapmanagement.v2beta.GetMapContextConfigRequest,
          com.google.maps.mapmanagement.v2beta.MapContextConfig>
      getGetMapContextConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.mapmanagement.v2beta.GetMapContextConfigRequest,
            com.google.maps.mapmanagement.v2beta.MapContextConfig>
        getGetMapContextConfigMethod;
    if ((getGetMapContextConfigMethod = MapManagementGrpc.getGetMapContextConfigMethod) == null) {
      synchronized (MapManagementGrpc.class) {
        if ((getGetMapContextConfigMethod = MapManagementGrpc.getGetMapContextConfigMethod)
            == null) {
          MapManagementGrpc.getGetMapContextConfigMethod =
              getGetMapContextConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.mapmanagement.v2beta.GetMapContextConfigRequest,
                          com.google.maps.mapmanagement.v2beta.MapContextConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetMapContextConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapmanagement.v2beta.GetMapContextConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapmanagement.v2beta.MapContextConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MapManagementMethodDescriptorSupplier("GetMapContextConfig"))
                      .build();
        }
      }
    }
    return getGetMapContextConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.mapmanagement.v2beta.ListMapContextConfigsRequest,
          com.google.maps.mapmanagement.v2beta.ListMapContextConfigsResponse>
      getListMapContextConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMapContextConfigs",
      requestType = com.google.maps.mapmanagement.v2beta.ListMapContextConfigsRequest.class,
      responseType = com.google.maps.mapmanagement.v2beta.ListMapContextConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.mapmanagement.v2beta.ListMapContextConfigsRequest,
          com.google.maps.mapmanagement.v2beta.ListMapContextConfigsResponse>
      getListMapContextConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.mapmanagement.v2beta.ListMapContextConfigsRequest,
            com.google.maps.mapmanagement.v2beta.ListMapContextConfigsResponse>
        getListMapContextConfigsMethod;
    if ((getListMapContextConfigsMethod = MapManagementGrpc.getListMapContextConfigsMethod)
        == null) {
      synchronized (MapManagementGrpc.class) {
        if ((getListMapContextConfigsMethod = MapManagementGrpc.getListMapContextConfigsMethod)
            == null) {
          MapManagementGrpc.getListMapContextConfigsMethod =
              getListMapContextConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.mapmanagement.v2beta.ListMapContextConfigsRequest,
                          com.google.maps.mapmanagement.v2beta.ListMapContextConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListMapContextConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapmanagement.v2beta.ListMapContextConfigsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapmanagement.v2beta.ListMapContextConfigsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MapManagementMethodDescriptorSupplier("ListMapContextConfigs"))
                      .build();
        }
      }
    }
    return getListMapContextConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.mapmanagement.v2beta.UpdateMapContextConfigRequest,
          com.google.maps.mapmanagement.v2beta.MapContextConfig>
      getUpdateMapContextConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateMapContextConfig",
      requestType = com.google.maps.mapmanagement.v2beta.UpdateMapContextConfigRequest.class,
      responseType = com.google.maps.mapmanagement.v2beta.MapContextConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.mapmanagement.v2beta.UpdateMapContextConfigRequest,
          com.google.maps.mapmanagement.v2beta.MapContextConfig>
      getUpdateMapContextConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.mapmanagement.v2beta.UpdateMapContextConfigRequest,
            com.google.maps.mapmanagement.v2beta.MapContextConfig>
        getUpdateMapContextConfigMethod;
    if ((getUpdateMapContextConfigMethod = MapManagementGrpc.getUpdateMapContextConfigMethod)
        == null) {
      synchronized (MapManagementGrpc.class) {
        if ((getUpdateMapContextConfigMethod = MapManagementGrpc.getUpdateMapContextConfigMethod)
            == null) {
          MapManagementGrpc.getUpdateMapContextConfigMethod =
              getUpdateMapContextConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.mapmanagement.v2beta.UpdateMapContextConfigRequest,
                          com.google.maps.mapmanagement.v2beta.MapContextConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateMapContextConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapmanagement.v2beta.UpdateMapContextConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapmanagement.v2beta.MapContextConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MapManagementMethodDescriptorSupplier("UpdateMapContextConfig"))
                      .build();
        }
      }
    }
    return getUpdateMapContextConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.mapmanagement.v2beta.DeleteMapContextConfigRequest,
          com.google.protobuf.Empty>
      getDeleteMapContextConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMapContextConfig",
      requestType = com.google.maps.mapmanagement.v2beta.DeleteMapContextConfigRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.mapmanagement.v2beta.DeleteMapContextConfigRequest,
          com.google.protobuf.Empty>
      getDeleteMapContextConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.mapmanagement.v2beta.DeleteMapContextConfigRequest,
            com.google.protobuf.Empty>
        getDeleteMapContextConfigMethod;
    if ((getDeleteMapContextConfigMethod = MapManagementGrpc.getDeleteMapContextConfigMethod)
        == null) {
      synchronized (MapManagementGrpc.class) {
        if ((getDeleteMapContextConfigMethod = MapManagementGrpc.getDeleteMapContextConfigMethod)
            == null) {
          MapManagementGrpc.getDeleteMapContextConfigMethod =
              getDeleteMapContextConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.mapmanagement.v2beta.DeleteMapContextConfigRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteMapContextConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapmanagement.v2beta.DeleteMapContextConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MapManagementMethodDescriptorSupplier("DeleteMapContextConfig"))
                      .build();
        }
      }
    }
    return getDeleteMapContextConfigMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static MapManagementStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MapManagementStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MapManagementStub>() {
          @java.lang.Override
          public MapManagementStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MapManagementStub(channel, callOptions);
          }
        };
    return MapManagementStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static MapManagementBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MapManagementBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MapManagementBlockingV2Stub>() {
          @java.lang.Override
          public MapManagementBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MapManagementBlockingV2Stub(channel, callOptions);
          }
        };
    return MapManagementBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MapManagementBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MapManagementBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MapManagementBlockingStub>() {
          @java.lang.Override
          public MapManagementBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MapManagementBlockingStub(channel, callOptions);
          }
        };
    return MapManagementBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static MapManagementFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MapManagementFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MapManagementFutureStub>() {
          @java.lang.Override
          public MapManagementFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MapManagementFutureStub(channel, callOptions);
          }
        };
    return MapManagementFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The Map Management API uses your inputs to create and manage
   * Google Cloud based styling resources for Google Maps.
   * Using this API, you can can create and manage MapConfigs (Map IDs),
   * StyleConfigs (JSON-based styling), and MapContextConfigs (associations
   * between styles, datasets, and map variants).
   * This API offers features through three channels:
   * * `v2alpha`: Experimental features.
   * * `v2beta`: Preview features, recommended for early adoption.
   * * `v2`: General Availability (GA) features.
   * Capabilities described here are generally available across both the v2alpha
   * and v2beta endpoints.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a MapConfig in a project.
     * </pre>
     */
    default void createMapConfig(
        com.google.maps.mapmanagement.v2beta.CreateMapConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.mapmanagement.v2beta.MapConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateMapConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a MapConfig.
     * </pre>
     */
    default void getMapConfig(
        com.google.maps.mapmanagement.v2beta.GetMapConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.mapmanagement.v2beta.MapConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetMapConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists MapConfigs for a project.
     * </pre>
     */
    default void listMapConfigs(
        com.google.maps.mapmanagement.v2beta.ListMapConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.mapmanagement.v2beta.ListMapConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMapConfigsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a MapConfig.
     * </pre>
     */
    default void updateMapConfig(
        com.google.maps.mapmanagement.v2beta.UpdateMapConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.mapmanagement.v2beta.MapConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateMapConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a MapConfig.
     * </pre>
     */
    default void deleteMapConfig(
        com.google.maps.mapmanagement.v2beta.DeleteMapConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteMapConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a StyleConfig.
     * </pre>
     */
    default void createStyleConfig(
        com.google.maps.mapmanagement.v2beta.CreateStyleConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.mapmanagement.v2beta.StyleConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateStyleConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a StyleConfig.
     * </pre>
     */
    default void getStyleConfig(
        com.google.maps.mapmanagement.v2beta.GetStyleConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.mapmanagement.v2beta.StyleConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetStyleConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists StyleConfigs.
     * </pre>
     */
    default void listStyleConfigs(
        com.google.maps.mapmanagement.v2beta.ListStyleConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.mapmanagement.v2beta.ListStyleConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListStyleConfigsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a StyleConfig.
     * </pre>
     */
    default void updateStyleConfig(
        com.google.maps.mapmanagement.v2beta.UpdateStyleConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.mapmanagement.v2beta.StyleConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateStyleConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a StyleConfig.
     * </pre>
     */
    default void deleteStyleConfig(
        com.google.maps.mapmanagement.v2beta.DeleteStyleConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteStyleConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a MapContextConfig.
     * </pre>
     */
    default void createMapContextConfig(
        com.google.maps.mapmanagement.v2beta.CreateMapContextConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.mapmanagement.v2beta.MapContextConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateMapContextConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a MapContextConfig.
     * </pre>
     */
    default void getMapContextConfig(
        com.google.maps.mapmanagement.v2beta.GetMapContextConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.mapmanagement.v2beta.MapContextConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetMapContextConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists MapContextConfigs.
     * </pre>
     */
    default void listMapContextConfigs(
        com.google.maps.mapmanagement.v2beta.ListMapContextConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.maps.mapmanagement.v2beta.ListMapContextConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMapContextConfigsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a MapContextConfig.
     * </pre>
     */
    default void updateMapContextConfig(
        com.google.maps.mapmanagement.v2beta.UpdateMapContextConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.mapmanagement.v2beta.MapContextConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateMapContextConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a MapContextConfig.
     * </pre>
     */
    default void deleteMapContextConfig(
        com.google.maps.mapmanagement.v2beta.DeleteMapContextConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteMapContextConfigMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MapManagement.
   *
   * <pre>
   * The Map Management API uses your inputs to create and manage
   * Google Cloud based styling resources for Google Maps.
   * Using this API, you can can create and manage MapConfigs (Map IDs),
   * StyleConfigs (JSON-based styling), and MapContextConfigs (associations
   * between styles, datasets, and map variants).
   * This API offers features through three channels:
   * * `v2alpha`: Experimental features.
   * * `v2beta`: Preview features, recommended for early adoption.
   * * `v2`: General Availability (GA) features.
   * Capabilities described here are generally available across both the v2alpha
   * and v2beta endpoints.
   * </pre>
   */
  public abstract static class MapManagementImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return MapManagementGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service MapManagement.
   *
   * <pre>
   * The Map Management API uses your inputs to create and manage
   * Google Cloud based styling resources for Google Maps.
   * Using this API, you can can create and manage MapConfigs (Map IDs),
   * StyleConfigs (JSON-based styling), and MapContextConfigs (associations
   * between styles, datasets, and map variants).
   * This API offers features through three channels:
   * * `v2alpha`: Experimental features.
   * * `v2beta`: Preview features, recommended for early adoption.
   * * `v2`: General Availability (GA) features.
   * Capabilities described here are generally available across both the v2alpha
   * and v2beta endpoints.
   * </pre>
   */
  public static final class MapManagementStub
      extends io.grpc.stub.AbstractAsyncStub<MapManagementStub> {
    private MapManagementStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MapManagementStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MapManagementStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a MapConfig in a project.
     * </pre>
     */
    public void createMapConfig(
        com.google.maps.mapmanagement.v2beta.CreateMapConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.mapmanagement.v2beta.MapConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMapConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a MapConfig.
     * </pre>
     */
    public void getMapConfig(
        com.google.maps.mapmanagement.v2beta.GetMapConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.mapmanagement.v2beta.MapConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMapConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists MapConfigs for a project.
     * </pre>
     */
    public void listMapConfigs(
        com.google.maps.mapmanagement.v2beta.ListMapConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.mapmanagement.v2beta.ListMapConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMapConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a MapConfig.
     * </pre>
     */
    public void updateMapConfig(
        com.google.maps.mapmanagement.v2beta.UpdateMapConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.mapmanagement.v2beta.MapConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMapConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a MapConfig.
     * </pre>
     */
    public void deleteMapConfig(
        com.google.maps.mapmanagement.v2beta.DeleteMapConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMapConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a StyleConfig.
     * </pre>
     */
    public void createStyleConfig(
        com.google.maps.mapmanagement.v2beta.CreateStyleConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.mapmanagement.v2beta.StyleConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateStyleConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a StyleConfig.
     * </pre>
     */
    public void getStyleConfig(
        com.google.maps.mapmanagement.v2beta.GetStyleConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.mapmanagement.v2beta.StyleConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetStyleConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists StyleConfigs.
     * </pre>
     */
    public void listStyleConfigs(
        com.google.maps.mapmanagement.v2beta.ListStyleConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.mapmanagement.v2beta.ListStyleConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListStyleConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a StyleConfig.
     * </pre>
     */
    public void updateStyleConfig(
        com.google.maps.mapmanagement.v2beta.UpdateStyleConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.mapmanagement.v2beta.StyleConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateStyleConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a StyleConfig.
     * </pre>
     */
    public void deleteStyleConfig(
        com.google.maps.mapmanagement.v2beta.DeleteStyleConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteStyleConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a MapContextConfig.
     * </pre>
     */
    public void createMapContextConfig(
        com.google.maps.mapmanagement.v2beta.CreateMapContextConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.mapmanagement.v2beta.MapContextConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMapContextConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a MapContextConfig.
     * </pre>
     */
    public void getMapContextConfig(
        com.google.maps.mapmanagement.v2beta.GetMapContextConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.mapmanagement.v2beta.MapContextConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMapContextConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists MapContextConfigs.
     * </pre>
     */
    public void listMapContextConfigs(
        com.google.maps.mapmanagement.v2beta.ListMapContextConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.maps.mapmanagement.v2beta.ListMapContextConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMapContextConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a MapContextConfig.
     * </pre>
     */
    public void updateMapContextConfig(
        com.google.maps.mapmanagement.v2beta.UpdateMapContextConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.mapmanagement.v2beta.MapContextConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMapContextConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a MapContextConfig.
     * </pre>
     */
    public void deleteMapContextConfig(
        com.google.maps.mapmanagement.v2beta.DeleteMapContextConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMapContextConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service MapManagement.
   *
   * <pre>
   * The Map Management API uses your inputs to create and manage
   * Google Cloud based styling resources for Google Maps.
   * Using this API, you can can create and manage MapConfigs (Map IDs),
   * StyleConfigs (JSON-based styling), and MapContextConfigs (associations
   * between styles, datasets, and map variants).
   * This API offers features through three channels:
   * * `v2alpha`: Experimental features.
   * * `v2beta`: Preview features, recommended for early adoption.
   * * `v2`: General Availability (GA) features.
   * Capabilities described here are generally available across both the v2alpha
   * and v2beta endpoints.
   * </pre>
   */
  public static final class MapManagementBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<MapManagementBlockingV2Stub> {
    private MapManagementBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MapManagementBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MapManagementBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a MapConfig in a project.
     * </pre>
     */
    public com.google.maps.mapmanagement.v2beta.MapConfig createMapConfig(
        com.google.maps.mapmanagement.v2beta.CreateMapConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateMapConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a MapConfig.
     * </pre>
     */
    public com.google.maps.mapmanagement.v2beta.MapConfig getMapConfig(
        com.google.maps.mapmanagement.v2beta.GetMapConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetMapConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists MapConfigs for a project.
     * </pre>
     */
    public com.google.maps.mapmanagement.v2beta.ListMapConfigsResponse listMapConfigs(
        com.google.maps.mapmanagement.v2beta.ListMapConfigsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListMapConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a MapConfig.
     * </pre>
     */
    public com.google.maps.mapmanagement.v2beta.MapConfig updateMapConfig(
        com.google.maps.mapmanagement.v2beta.UpdateMapConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateMapConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a MapConfig.
     * </pre>
     */
    public com.google.protobuf.Empty deleteMapConfig(
        com.google.maps.mapmanagement.v2beta.DeleteMapConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteMapConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a StyleConfig.
     * </pre>
     */
    public com.google.maps.mapmanagement.v2beta.StyleConfig createStyleConfig(
        com.google.maps.mapmanagement.v2beta.CreateStyleConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateStyleConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a StyleConfig.
     * </pre>
     */
    public com.google.maps.mapmanagement.v2beta.StyleConfig getStyleConfig(
        com.google.maps.mapmanagement.v2beta.GetStyleConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetStyleConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists StyleConfigs.
     * </pre>
     */
    public com.google.maps.mapmanagement.v2beta.ListStyleConfigsResponse listStyleConfigs(
        com.google.maps.mapmanagement.v2beta.ListStyleConfigsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListStyleConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a StyleConfig.
     * </pre>
     */
    public com.google.maps.mapmanagement.v2beta.StyleConfig updateStyleConfig(
        com.google.maps.mapmanagement.v2beta.UpdateStyleConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateStyleConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a StyleConfig.
     * </pre>
     */
    public com.google.protobuf.Empty deleteStyleConfig(
        com.google.maps.mapmanagement.v2beta.DeleteStyleConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteStyleConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a MapContextConfig.
     * </pre>
     */
    public com.google.maps.mapmanagement.v2beta.MapContextConfig createMapContextConfig(
        com.google.maps.mapmanagement.v2beta.CreateMapContextConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateMapContextConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a MapContextConfig.
     * </pre>
     */
    public com.google.maps.mapmanagement.v2beta.MapContextConfig getMapContextConfig(
        com.google.maps.mapmanagement.v2beta.GetMapContextConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetMapContextConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists MapContextConfigs.
     * </pre>
     */
    public com.google.maps.mapmanagement.v2beta.ListMapContextConfigsResponse listMapContextConfigs(
        com.google.maps.mapmanagement.v2beta.ListMapContextConfigsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListMapContextConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a MapContextConfig.
     * </pre>
     */
    public com.google.maps.mapmanagement.v2beta.MapContextConfig updateMapContextConfig(
        com.google.maps.mapmanagement.v2beta.UpdateMapContextConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateMapContextConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a MapContextConfig.
     * </pre>
     */
    public com.google.protobuf.Empty deleteMapContextConfig(
        com.google.maps.mapmanagement.v2beta.DeleteMapContextConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteMapContextConfigMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service MapManagement.
   *
   * <pre>
   * The Map Management API uses your inputs to create and manage
   * Google Cloud based styling resources for Google Maps.
   * Using this API, you can can create and manage MapConfigs (Map IDs),
   * StyleConfigs (JSON-based styling), and MapContextConfigs (associations
   * between styles, datasets, and map variants).
   * This API offers features through three channels:
   * * `v2alpha`: Experimental features.
   * * `v2beta`: Preview features, recommended for early adoption.
   * * `v2`: General Availability (GA) features.
   * Capabilities described here are generally available across both the v2alpha
   * and v2beta endpoints.
   * </pre>
   */
  public static final class MapManagementBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MapManagementBlockingStub> {
    private MapManagementBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MapManagementBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MapManagementBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a MapConfig in a project.
     * </pre>
     */
    public com.google.maps.mapmanagement.v2beta.MapConfig createMapConfig(
        com.google.maps.mapmanagement.v2beta.CreateMapConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMapConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a MapConfig.
     * </pre>
     */
    public com.google.maps.mapmanagement.v2beta.MapConfig getMapConfig(
        com.google.maps.mapmanagement.v2beta.GetMapConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMapConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists MapConfigs for a project.
     * </pre>
     */
    public com.google.maps.mapmanagement.v2beta.ListMapConfigsResponse listMapConfigs(
        com.google.maps.mapmanagement.v2beta.ListMapConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMapConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a MapConfig.
     * </pre>
     */
    public com.google.maps.mapmanagement.v2beta.MapConfig updateMapConfig(
        com.google.maps.mapmanagement.v2beta.UpdateMapConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMapConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a MapConfig.
     * </pre>
     */
    public com.google.protobuf.Empty deleteMapConfig(
        com.google.maps.mapmanagement.v2beta.DeleteMapConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMapConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a StyleConfig.
     * </pre>
     */
    public com.google.maps.mapmanagement.v2beta.StyleConfig createStyleConfig(
        com.google.maps.mapmanagement.v2beta.CreateStyleConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateStyleConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a StyleConfig.
     * </pre>
     */
    public com.google.maps.mapmanagement.v2beta.StyleConfig getStyleConfig(
        com.google.maps.mapmanagement.v2beta.GetStyleConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetStyleConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists StyleConfigs.
     * </pre>
     */
    public com.google.maps.mapmanagement.v2beta.ListStyleConfigsResponse listStyleConfigs(
        com.google.maps.mapmanagement.v2beta.ListStyleConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListStyleConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a StyleConfig.
     * </pre>
     */
    public com.google.maps.mapmanagement.v2beta.StyleConfig updateStyleConfig(
        com.google.maps.mapmanagement.v2beta.UpdateStyleConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateStyleConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a StyleConfig.
     * </pre>
     */
    public com.google.protobuf.Empty deleteStyleConfig(
        com.google.maps.mapmanagement.v2beta.DeleteStyleConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteStyleConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a MapContextConfig.
     * </pre>
     */
    public com.google.maps.mapmanagement.v2beta.MapContextConfig createMapContextConfig(
        com.google.maps.mapmanagement.v2beta.CreateMapContextConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMapContextConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a MapContextConfig.
     * </pre>
     */
    public com.google.maps.mapmanagement.v2beta.MapContextConfig getMapContextConfig(
        com.google.maps.mapmanagement.v2beta.GetMapContextConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMapContextConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists MapContextConfigs.
     * </pre>
     */
    public com.google.maps.mapmanagement.v2beta.ListMapContextConfigsResponse listMapContextConfigs(
        com.google.maps.mapmanagement.v2beta.ListMapContextConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMapContextConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a MapContextConfig.
     * </pre>
     */
    public com.google.maps.mapmanagement.v2beta.MapContextConfig updateMapContextConfig(
        com.google.maps.mapmanagement.v2beta.UpdateMapContextConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMapContextConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a MapContextConfig.
     * </pre>
     */
    public com.google.protobuf.Empty deleteMapContextConfig(
        com.google.maps.mapmanagement.v2beta.DeleteMapContextConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMapContextConfigMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service MapManagement.
   *
   * <pre>
   * The Map Management API uses your inputs to create and manage
   * Google Cloud based styling resources for Google Maps.
   * Using this API, you can can create and manage MapConfigs (Map IDs),
   * StyleConfigs (JSON-based styling), and MapContextConfigs (associations
   * between styles, datasets, and map variants).
   * This API offers features through three channels:
   * * `v2alpha`: Experimental features.
   * * `v2beta`: Preview features, recommended for early adoption.
   * * `v2`: General Availability (GA) features.
   * Capabilities described here are generally available across both the v2alpha
   * and v2beta endpoints.
   * </pre>
   */
  public static final class MapManagementFutureStub
      extends io.grpc.stub.AbstractFutureStub<MapManagementFutureStub> {
    private MapManagementFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MapManagementFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MapManagementFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a MapConfig in a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.maps.mapmanagement.v2beta.MapConfig>
        createMapConfig(com.google.maps.mapmanagement.v2beta.CreateMapConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMapConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a MapConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.maps.mapmanagement.v2beta.MapConfig>
        getMapConfig(com.google.maps.mapmanagement.v2beta.GetMapConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMapConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists MapConfigs for a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.maps.mapmanagement.v2beta.ListMapConfigsResponse>
        listMapConfigs(com.google.maps.mapmanagement.v2beta.ListMapConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMapConfigsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a MapConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.maps.mapmanagement.v2beta.MapConfig>
        updateMapConfig(com.google.maps.mapmanagement.v2beta.UpdateMapConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMapConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a MapConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteMapConfig(com.google.maps.mapmanagement.v2beta.DeleteMapConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMapConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a StyleConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.maps.mapmanagement.v2beta.StyleConfig>
        createStyleConfig(com.google.maps.mapmanagement.v2beta.CreateStyleConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateStyleConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a StyleConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.maps.mapmanagement.v2beta.StyleConfig>
        getStyleConfig(com.google.maps.mapmanagement.v2beta.GetStyleConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetStyleConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists StyleConfigs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.maps.mapmanagement.v2beta.ListStyleConfigsResponse>
        listStyleConfigs(com.google.maps.mapmanagement.v2beta.ListStyleConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListStyleConfigsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a StyleConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.maps.mapmanagement.v2beta.StyleConfig>
        updateStyleConfig(com.google.maps.mapmanagement.v2beta.UpdateStyleConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateStyleConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a StyleConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteStyleConfig(com.google.maps.mapmanagement.v2beta.DeleteStyleConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteStyleConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a MapContextConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.maps.mapmanagement.v2beta.MapContextConfig>
        createMapContextConfig(
            com.google.maps.mapmanagement.v2beta.CreateMapContextConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMapContextConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a MapContextConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.maps.mapmanagement.v2beta.MapContextConfig>
        getMapContextConfig(
            com.google.maps.mapmanagement.v2beta.GetMapContextConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMapContextConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists MapContextConfigs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.maps.mapmanagement.v2beta.ListMapContextConfigsResponse>
        listMapContextConfigs(
            com.google.maps.mapmanagement.v2beta.ListMapContextConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMapContextConfigsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a MapContextConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.maps.mapmanagement.v2beta.MapContextConfig>
        updateMapContextConfig(
            com.google.maps.mapmanagement.v2beta.UpdateMapContextConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMapContextConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a MapContextConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteMapContextConfig(
            com.google.maps.mapmanagement.v2beta.DeleteMapContextConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMapContextConfigMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_MAP_CONFIG = 0;
  private static final int METHODID_GET_MAP_CONFIG = 1;
  private static final int METHODID_LIST_MAP_CONFIGS = 2;
  private static final int METHODID_UPDATE_MAP_CONFIG = 3;
  private static final int METHODID_DELETE_MAP_CONFIG = 4;
  private static final int METHODID_CREATE_STYLE_CONFIG = 5;
  private static final int METHODID_GET_STYLE_CONFIG = 6;
  private static final int METHODID_LIST_STYLE_CONFIGS = 7;
  private static final int METHODID_UPDATE_STYLE_CONFIG = 8;
  private static final int METHODID_DELETE_STYLE_CONFIG = 9;
  private static final int METHODID_CREATE_MAP_CONTEXT_CONFIG = 10;
  private static final int METHODID_GET_MAP_CONTEXT_CONFIG = 11;
  private static final int METHODID_LIST_MAP_CONTEXT_CONFIGS = 12;
  private static final int METHODID_UPDATE_MAP_CONTEXT_CONFIG = 13;
  private static final int METHODID_DELETE_MAP_CONTEXT_CONFIG = 14;

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
        case METHODID_CREATE_MAP_CONFIG:
          serviceImpl.createMapConfig(
              (com.google.maps.mapmanagement.v2beta.CreateMapConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.maps.mapmanagement.v2beta.MapConfig>)
                  responseObserver);
          break;
        case METHODID_GET_MAP_CONFIG:
          serviceImpl.getMapConfig(
              (com.google.maps.mapmanagement.v2beta.GetMapConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.maps.mapmanagement.v2beta.MapConfig>)
                  responseObserver);
          break;
        case METHODID_LIST_MAP_CONFIGS:
          serviceImpl.listMapConfigs(
              (com.google.maps.mapmanagement.v2beta.ListMapConfigsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.maps.mapmanagement.v2beta.ListMapConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_MAP_CONFIG:
          serviceImpl.updateMapConfig(
              (com.google.maps.mapmanagement.v2beta.UpdateMapConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.maps.mapmanagement.v2beta.MapConfig>)
                  responseObserver);
          break;
        case METHODID_DELETE_MAP_CONFIG:
          serviceImpl.deleteMapConfig(
              (com.google.maps.mapmanagement.v2beta.DeleteMapConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_STYLE_CONFIG:
          serviceImpl.createStyleConfig(
              (com.google.maps.mapmanagement.v2beta.CreateStyleConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.maps.mapmanagement.v2beta.StyleConfig>)
                  responseObserver);
          break;
        case METHODID_GET_STYLE_CONFIG:
          serviceImpl.getStyleConfig(
              (com.google.maps.mapmanagement.v2beta.GetStyleConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.maps.mapmanagement.v2beta.StyleConfig>)
                  responseObserver);
          break;
        case METHODID_LIST_STYLE_CONFIGS:
          serviceImpl.listStyleConfigs(
              (com.google.maps.mapmanagement.v2beta.ListStyleConfigsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.maps.mapmanagement.v2beta.ListStyleConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_STYLE_CONFIG:
          serviceImpl.updateStyleConfig(
              (com.google.maps.mapmanagement.v2beta.UpdateStyleConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.maps.mapmanagement.v2beta.StyleConfig>)
                  responseObserver);
          break;
        case METHODID_DELETE_STYLE_CONFIG:
          serviceImpl.deleteStyleConfig(
              (com.google.maps.mapmanagement.v2beta.DeleteStyleConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_MAP_CONTEXT_CONFIG:
          serviceImpl.createMapContextConfig(
              (com.google.maps.mapmanagement.v2beta.CreateMapContextConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.maps.mapmanagement.v2beta.MapContextConfig>)
                  responseObserver);
          break;
        case METHODID_GET_MAP_CONTEXT_CONFIG:
          serviceImpl.getMapContextConfig(
              (com.google.maps.mapmanagement.v2beta.GetMapContextConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.maps.mapmanagement.v2beta.MapContextConfig>)
                  responseObserver);
          break;
        case METHODID_LIST_MAP_CONTEXT_CONFIGS:
          serviceImpl.listMapContextConfigs(
              (com.google.maps.mapmanagement.v2beta.ListMapContextConfigsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.maps.mapmanagement.v2beta.ListMapContextConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_MAP_CONTEXT_CONFIG:
          serviceImpl.updateMapContextConfig(
              (com.google.maps.mapmanagement.v2beta.UpdateMapContextConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.maps.mapmanagement.v2beta.MapContextConfig>)
                  responseObserver);
          break;
        case METHODID_DELETE_MAP_CONTEXT_CONFIG:
          serviceImpl.deleteMapContextConfig(
              (com.google.maps.mapmanagement.v2beta.DeleteMapContextConfigRequest) request,
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
            getCreateMapConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.mapmanagement.v2beta.CreateMapConfigRequest,
                    com.google.maps.mapmanagement.v2beta.MapConfig>(
                    service, METHODID_CREATE_MAP_CONFIG)))
        .addMethod(
            getGetMapConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.mapmanagement.v2beta.GetMapConfigRequest,
                    com.google.maps.mapmanagement.v2beta.MapConfig>(
                    service, METHODID_GET_MAP_CONFIG)))
        .addMethod(
            getListMapConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.mapmanagement.v2beta.ListMapConfigsRequest,
                    com.google.maps.mapmanagement.v2beta.ListMapConfigsResponse>(
                    service, METHODID_LIST_MAP_CONFIGS)))
        .addMethod(
            getUpdateMapConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.mapmanagement.v2beta.UpdateMapConfigRequest,
                    com.google.maps.mapmanagement.v2beta.MapConfig>(
                    service, METHODID_UPDATE_MAP_CONFIG)))
        .addMethod(
            getDeleteMapConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.mapmanagement.v2beta.DeleteMapConfigRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_MAP_CONFIG)))
        .addMethod(
            getCreateStyleConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.mapmanagement.v2beta.CreateStyleConfigRequest,
                    com.google.maps.mapmanagement.v2beta.StyleConfig>(
                    service, METHODID_CREATE_STYLE_CONFIG)))
        .addMethod(
            getGetStyleConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.mapmanagement.v2beta.GetStyleConfigRequest,
                    com.google.maps.mapmanagement.v2beta.StyleConfig>(
                    service, METHODID_GET_STYLE_CONFIG)))
        .addMethod(
            getListStyleConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.mapmanagement.v2beta.ListStyleConfigsRequest,
                    com.google.maps.mapmanagement.v2beta.ListStyleConfigsResponse>(
                    service, METHODID_LIST_STYLE_CONFIGS)))
        .addMethod(
            getUpdateStyleConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.mapmanagement.v2beta.UpdateStyleConfigRequest,
                    com.google.maps.mapmanagement.v2beta.StyleConfig>(
                    service, METHODID_UPDATE_STYLE_CONFIG)))
        .addMethod(
            getDeleteStyleConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.mapmanagement.v2beta.DeleteStyleConfigRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_STYLE_CONFIG)))
        .addMethod(
            getCreateMapContextConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.mapmanagement.v2beta.CreateMapContextConfigRequest,
                    com.google.maps.mapmanagement.v2beta.MapContextConfig>(
                    service, METHODID_CREATE_MAP_CONTEXT_CONFIG)))
        .addMethod(
            getGetMapContextConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.mapmanagement.v2beta.GetMapContextConfigRequest,
                    com.google.maps.mapmanagement.v2beta.MapContextConfig>(
                    service, METHODID_GET_MAP_CONTEXT_CONFIG)))
        .addMethod(
            getListMapContextConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.mapmanagement.v2beta.ListMapContextConfigsRequest,
                    com.google.maps.mapmanagement.v2beta.ListMapContextConfigsResponse>(
                    service, METHODID_LIST_MAP_CONTEXT_CONFIGS)))
        .addMethod(
            getUpdateMapContextConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.mapmanagement.v2beta.UpdateMapContextConfigRequest,
                    com.google.maps.mapmanagement.v2beta.MapContextConfig>(
                    service, METHODID_UPDATE_MAP_CONTEXT_CONFIG)))
        .addMethod(
            getDeleteMapContextConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.mapmanagement.v2beta.DeleteMapContextConfigRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_MAP_CONTEXT_CONFIG)))
        .build();
  }

  private abstract static class MapManagementBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MapManagementBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.maps.mapmanagement.v2beta.MapManagementServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MapManagement");
    }
  }

  private static final class MapManagementFileDescriptorSupplier
      extends MapManagementBaseDescriptorSupplier {
    MapManagementFileDescriptorSupplier() {}
  }

  private static final class MapManagementMethodDescriptorSupplier
      extends MapManagementBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MapManagementMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (MapManagementGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new MapManagementFileDescriptorSupplier())
                      .addMethod(getCreateMapConfigMethod())
                      .addMethod(getGetMapConfigMethod())
                      .addMethod(getListMapConfigsMethod())
                      .addMethod(getUpdateMapConfigMethod())
                      .addMethod(getDeleteMapConfigMethod())
                      .addMethod(getCreateStyleConfigMethod())
                      .addMethod(getGetStyleConfigMethod())
                      .addMethod(getListStyleConfigsMethod())
                      .addMethod(getUpdateStyleConfigMethod())
                      .addMethod(getDeleteStyleConfigMethod())
                      .addMethod(getCreateMapContextConfigMethod())
                      .addMethod(getGetMapContextConfigMethod())
                      .addMethod(getListMapContextConfigsMethod())
                      .addMethod(getUpdateMapContextConfigMethod())
                      .addMethod(getDeleteMapContextConfigMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
