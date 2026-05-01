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
package com.google.cloud.chronicle.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A service providing functionality for managing native dashboards.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class NativeDashboardServiceGrpc {

  private NativeDashboardServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.chronicle.v1.NativeDashboardService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.CreateNativeDashboardRequest,
          com.google.cloud.chronicle.v1.NativeDashboard>
      getCreateNativeDashboardMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateNativeDashboard",
      requestType = com.google.cloud.chronicle.v1.CreateNativeDashboardRequest.class,
      responseType = com.google.cloud.chronicle.v1.NativeDashboard.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.CreateNativeDashboardRequest,
          com.google.cloud.chronicle.v1.NativeDashboard>
      getCreateNativeDashboardMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.CreateNativeDashboardRequest,
            com.google.cloud.chronicle.v1.NativeDashboard>
        getCreateNativeDashboardMethod;
    if ((getCreateNativeDashboardMethod = NativeDashboardServiceGrpc.getCreateNativeDashboardMethod)
        == null) {
      synchronized (NativeDashboardServiceGrpc.class) {
        if ((getCreateNativeDashboardMethod =
                NativeDashboardServiceGrpc.getCreateNativeDashboardMethod)
            == null) {
          NativeDashboardServiceGrpc.getCreateNativeDashboardMethod =
              getCreateNativeDashboardMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.CreateNativeDashboardRequest,
                          com.google.cloud.chronicle.v1.NativeDashboard>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateNativeDashboard"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.CreateNativeDashboardRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.NativeDashboard.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NativeDashboardServiceMethodDescriptorSupplier(
                              "CreateNativeDashboard"))
                      .build();
        }
      }
    }
    return getCreateNativeDashboardMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.GetNativeDashboardRequest,
          com.google.cloud.chronicle.v1.NativeDashboard>
      getGetNativeDashboardMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNativeDashboard",
      requestType = com.google.cloud.chronicle.v1.GetNativeDashboardRequest.class,
      responseType = com.google.cloud.chronicle.v1.NativeDashboard.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.GetNativeDashboardRequest,
          com.google.cloud.chronicle.v1.NativeDashboard>
      getGetNativeDashboardMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.GetNativeDashboardRequest,
            com.google.cloud.chronicle.v1.NativeDashboard>
        getGetNativeDashboardMethod;
    if ((getGetNativeDashboardMethod = NativeDashboardServiceGrpc.getGetNativeDashboardMethod)
        == null) {
      synchronized (NativeDashboardServiceGrpc.class) {
        if ((getGetNativeDashboardMethod = NativeDashboardServiceGrpc.getGetNativeDashboardMethod)
            == null) {
          NativeDashboardServiceGrpc.getGetNativeDashboardMethod =
              getGetNativeDashboardMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.GetNativeDashboardRequest,
                          com.google.cloud.chronicle.v1.NativeDashboard>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNativeDashboard"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.GetNativeDashboardRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.NativeDashboard.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NativeDashboardServiceMethodDescriptorSupplier("GetNativeDashboard"))
                      .build();
        }
      }
    }
    return getGetNativeDashboardMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ListNativeDashboardsRequest,
          com.google.cloud.chronicle.v1.ListNativeDashboardsResponse>
      getListNativeDashboardsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListNativeDashboards",
      requestType = com.google.cloud.chronicle.v1.ListNativeDashboardsRequest.class,
      responseType = com.google.cloud.chronicle.v1.ListNativeDashboardsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ListNativeDashboardsRequest,
          com.google.cloud.chronicle.v1.ListNativeDashboardsResponse>
      getListNativeDashboardsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.ListNativeDashboardsRequest,
            com.google.cloud.chronicle.v1.ListNativeDashboardsResponse>
        getListNativeDashboardsMethod;
    if ((getListNativeDashboardsMethod = NativeDashboardServiceGrpc.getListNativeDashboardsMethod)
        == null) {
      synchronized (NativeDashboardServiceGrpc.class) {
        if ((getListNativeDashboardsMethod =
                NativeDashboardServiceGrpc.getListNativeDashboardsMethod)
            == null) {
          NativeDashboardServiceGrpc.getListNativeDashboardsMethod =
              getListNativeDashboardsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.ListNativeDashboardsRequest,
                          com.google.cloud.chronicle.v1.ListNativeDashboardsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListNativeDashboards"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.ListNativeDashboardsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.ListNativeDashboardsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NativeDashboardServiceMethodDescriptorSupplier(
                              "ListNativeDashboards"))
                      .build();
        }
      }
    }
    return getListNativeDashboardsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.UpdateNativeDashboardRequest,
          com.google.cloud.chronicle.v1.NativeDashboard>
      getUpdateNativeDashboardMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateNativeDashboard",
      requestType = com.google.cloud.chronicle.v1.UpdateNativeDashboardRequest.class,
      responseType = com.google.cloud.chronicle.v1.NativeDashboard.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.UpdateNativeDashboardRequest,
          com.google.cloud.chronicle.v1.NativeDashboard>
      getUpdateNativeDashboardMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.UpdateNativeDashboardRequest,
            com.google.cloud.chronicle.v1.NativeDashboard>
        getUpdateNativeDashboardMethod;
    if ((getUpdateNativeDashboardMethod = NativeDashboardServiceGrpc.getUpdateNativeDashboardMethod)
        == null) {
      synchronized (NativeDashboardServiceGrpc.class) {
        if ((getUpdateNativeDashboardMethod =
                NativeDashboardServiceGrpc.getUpdateNativeDashboardMethod)
            == null) {
          NativeDashboardServiceGrpc.getUpdateNativeDashboardMethod =
              getUpdateNativeDashboardMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.UpdateNativeDashboardRequest,
                          com.google.cloud.chronicle.v1.NativeDashboard>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateNativeDashboard"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.UpdateNativeDashboardRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.NativeDashboard.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NativeDashboardServiceMethodDescriptorSupplier(
                              "UpdateNativeDashboard"))
                      .build();
        }
      }
    }
    return getUpdateNativeDashboardMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.DuplicateNativeDashboardRequest,
          com.google.cloud.chronicle.v1.NativeDashboard>
      getDuplicateNativeDashboardMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DuplicateNativeDashboard",
      requestType = com.google.cloud.chronicle.v1.DuplicateNativeDashboardRequest.class,
      responseType = com.google.cloud.chronicle.v1.NativeDashboard.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.DuplicateNativeDashboardRequest,
          com.google.cloud.chronicle.v1.NativeDashboard>
      getDuplicateNativeDashboardMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.DuplicateNativeDashboardRequest,
            com.google.cloud.chronicle.v1.NativeDashboard>
        getDuplicateNativeDashboardMethod;
    if ((getDuplicateNativeDashboardMethod =
            NativeDashboardServiceGrpc.getDuplicateNativeDashboardMethod)
        == null) {
      synchronized (NativeDashboardServiceGrpc.class) {
        if ((getDuplicateNativeDashboardMethod =
                NativeDashboardServiceGrpc.getDuplicateNativeDashboardMethod)
            == null) {
          NativeDashboardServiceGrpc.getDuplicateNativeDashboardMethod =
              getDuplicateNativeDashboardMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.DuplicateNativeDashboardRequest,
                          com.google.cloud.chronicle.v1.NativeDashboard>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DuplicateNativeDashboard"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.DuplicateNativeDashboardRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.NativeDashboard.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NativeDashboardServiceMethodDescriptorSupplier(
                              "DuplicateNativeDashboard"))
                      .build();
        }
      }
    }
    return getDuplicateNativeDashboardMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.DeleteNativeDashboardRequest, com.google.protobuf.Empty>
      getDeleteNativeDashboardMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteNativeDashboard",
      requestType = com.google.cloud.chronicle.v1.DeleteNativeDashboardRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.DeleteNativeDashboardRequest, com.google.protobuf.Empty>
      getDeleteNativeDashboardMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.DeleteNativeDashboardRequest, com.google.protobuf.Empty>
        getDeleteNativeDashboardMethod;
    if ((getDeleteNativeDashboardMethod = NativeDashboardServiceGrpc.getDeleteNativeDashboardMethod)
        == null) {
      synchronized (NativeDashboardServiceGrpc.class) {
        if ((getDeleteNativeDashboardMethod =
                NativeDashboardServiceGrpc.getDeleteNativeDashboardMethod)
            == null) {
          NativeDashboardServiceGrpc.getDeleteNativeDashboardMethod =
              getDeleteNativeDashboardMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.DeleteNativeDashboardRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteNativeDashboard"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.DeleteNativeDashboardRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NativeDashboardServiceMethodDescriptorSupplier(
                              "DeleteNativeDashboard"))
                      .build();
        }
      }
    }
    return getDeleteNativeDashboardMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.AddChartRequest,
          com.google.cloud.chronicle.v1.AddChartResponse>
      getAddChartMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddChart",
      requestType = com.google.cloud.chronicle.v1.AddChartRequest.class,
      responseType = com.google.cloud.chronicle.v1.AddChartResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.AddChartRequest,
          com.google.cloud.chronicle.v1.AddChartResponse>
      getAddChartMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.AddChartRequest,
            com.google.cloud.chronicle.v1.AddChartResponse>
        getAddChartMethod;
    if ((getAddChartMethod = NativeDashboardServiceGrpc.getAddChartMethod) == null) {
      synchronized (NativeDashboardServiceGrpc.class) {
        if ((getAddChartMethod = NativeDashboardServiceGrpc.getAddChartMethod) == null) {
          NativeDashboardServiceGrpc.getAddChartMethod =
              getAddChartMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.AddChartRequest,
                          com.google.cloud.chronicle.v1.AddChartResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddChart"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.AddChartRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.AddChartResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NativeDashboardServiceMethodDescriptorSupplier("AddChart"))
                      .build();
        }
      }
    }
    return getAddChartMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.RemoveChartRequest,
          com.google.cloud.chronicle.v1.NativeDashboard>
      getRemoveChartMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveChart",
      requestType = com.google.cloud.chronicle.v1.RemoveChartRequest.class,
      responseType = com.google.cloud.chronicle.v1.NativeDashboard.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.RemoveChartRequest,
          com.google.cloud.chronicle.v1.NativeDashboard>
      getRemoveChartMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.RemoveChartRequest,
            com.google.cloud.chronicle.v1.NativeDashboard>
        getRemoveChartMethod;
    if ((getRemoveChartMethod = NativeDashboardServiceGrpc.getRemoveChartMethod) == null) {
      synchronized (NativeDashboardServiceGrpc.class) {
        if ((getRemoveChartMethod = NativeDashboardServiceGrpc.getRemoveChartMethod) == null) {
          NativeDashboardServiceGrpc.getRemoveChartMethod =
              getRemoveChartMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.RemoveChartRequest,
                          com.google.cloud.chronicle.v1.NativeDashboard>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RemoveChart"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.RemoveChartRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.NativeDashboard.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NativeDashboardServiceMethodDescriptorSupplier("RemoveChart"))
                      .build();
        }
      }
    }
    return getRemoveChartMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.EditChartRequest,
          com.google.cloud.chronicle.v1.EditChartResponse>
      getEditChartMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EditChart",
      requestType = com.google.cloud.chronicle.v1.EditChartRequest.class,
      responseType = com.google.cloud.chronicle.v1.EditChartResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.EditChartRequest,
          com.google.cloud.chronicle.v1.EditChartResponse>
      getEditChartMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.EditChartRequest,
            com.google.cloud.chronicle.v1.EditChartResponse>
        getEditChartMethod;
    if ((getEditChartMethod = NativeDashboardServiceGrpc.getEditChartMethod) == null) {
      synchronized (NativeDashboardServiceGrpc.class) {
        if ((getEditChartMethod = NativeDashboardServiceGrpc.getEditChartMethod) == null) {
          NativeDashboardServiceGrpc.getEditChartMethod =
              getEditChartMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.EditChartRequest,
                          com.google.cloud.chronicle.v1.EditChartResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EditChart"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.EditChartRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.EditChartResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NativeDashboardServiceMethodDescriptorSupplier("EditChart"))
                      .build();
        }
      }
    }
    return getEditChartMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.DuplicateChartRequest,
          com.google.cloud.chronicle.v1.DuplicateChartResponse>
      getDuplicateChartMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DuplicateChart",
      requestType = com.google.cloud.chronicle.v1.DuplicateChartRequest.class,
      responseType = com.google.cloud.chronicle.v1.DuplicateChartResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.DuplicateChartRequest,
          com.google.cloud.chronicle.v1.DuplicateChartResponse>
      getDuplicateChartMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.DuplicateChartRequest,
            com.google.cloud.chronicle.v1.DuplicateChartResponse>
        getDuplicateChartMethod;
    if ((getDuplicateChartMethod = NativeDashboardServiceGrpc.getDuplicateChartMethod) == null) {
      synchronized (NativeDashboardServiceGrpc.class) {
        if ((getDuplicateChartMethod = NativeDashboardServiceGrpc.getDuplicateChartMethod)
            == null) {
          NativeDashboardServiceGrpc.getDuplicateChartMethod =
              getDuplicateChartMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.DuplicateChartRequest,
                          com.google.cloud.chronicle.v1.DuplicateChartResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DuplicateChart"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.DuplicateChartRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.DuplicateChartResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NativeDashboardServiceMethodDescriptorSupplier("DuplicateChart"))
                      .build();
        }
      }
    }
    return getDuplicateChartMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ExportNativeDashboardsRequest,
          com.google.cloud.chronicle.v1.ExportNativeDashboardsResponse>
      getExportNativeDashboardsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportNativeDashboards",
      requestType = com.google.cloud.chronicle.v1.ExportNativeDashboardsRequest.class,
      responseType = com.google.cloud.chronicle.v1.ExportNativeDashboardsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ExportNativeDashboardsRequest,
          com.google.cloud.chronicle.v1.ExportNativeDashboardsResponse>
      getExportNativeDashboardsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.ExportNativeDashboardsRequest,
            com.google.cloud.chronicle.v1.ExportNativeDashboardsResponse>
        getExportNativeDashboardsMethod;
    if ((getExportNativeDashboardsMethod =
            NativeDashboardServiceGrpc.getExportNativeDashboardsMethod)
        == null) {
      synchronized (NativeDashboardServiceGrpc.class) {
        if ((getExportNativeDashboardsMethod =
                NativeDashboardServiceGrpc.getExportNativeDashboardsMethod)
            == null) {
          NativeDashboardServiceGrpc.getExportNativeDashboardsMethod =
              getExportNativeDashboardsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.ExportNativeDashboardsRequest,
                          com.google.cloud.chronicle.v1.ExportNativeDashboardsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ExportNativeDashboards"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.ExportNativeDashboardsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.ExportNativeDashboardsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NativeDashboardServiceMethodDescriptorSupplier(
                              "ExportNativeDashboards"))
                      .build();
        }
      }
    }
    return getExportNativeDashboardsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ImportNativeDashboardsRequest,
          com.google.cloud.chronicle.v1.ImportNativeDashboardsResponse>
      getImportNativeDashboardsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportNativeDashboards",
      requestType = com.google.cloud.chronicle.v1.ImportNativeDashboardsRequest.class,
      responseType = com.google.cloud.chronicle.v1.ImportNativeDashboardsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ImportNativeDashboardsRequest,
          com.google.cloud.chronicle.v1.ImportNativeDashboardsResponse>
      getImportNativeDashboardsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.ImportNativeDashboardsRequest,
            com.google.cloud.chronicle.v1.ImportNativeDashboardsResponse>
        getImportNativeDashboardsMethod;
    if ((getImportNativeDashboardsMethod =
            NativeDashboardServiceGrpc.getImportNativeDashboardsMethod)
        == null) {
      synchronized (NativeDashboardServiceGrpc.class) {
        if ((getImportNativeDashboardsMethod =
                NativeDashboardServiceGrpc.getImportNativeDashboardsMethod)
            == null) {
          NativeDashboardServiceGrpc.getImportNativeDashboardsMethod =
              getImportNativeDashboardsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.ImportNativeDashboardsRequest,
                          com.google.cloud.chronicle.v1.ImportNativeDashboardsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ImportNativeDashboards"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.ImportNativeDashboardsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.ImportNativeDashboardsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NativeDashboardServiceMethodDescriptorSupplier(
                              "ImportNativeDashboards"))
                      .build();
        }
      }
    }
    return getImportNativeDashboardsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static NativeDashboardServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NativeDashboardServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<NativeDashboardServiceStub>() {
          @java.lang.Override
          public NativeDashboardServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new NativeDashboardServiceStub(channel, callOptions);
          }
        };
    return NativeDashboardServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static NativeDashboardServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NativeDashboardServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<NativeDashboardServiceBlockingV2Stub>() {
          @java.lang.Override
          public NativeDashboardServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new NativeDashboardServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return NativeDashboardServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NativeDashboardServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NativeDashboardServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<NativeDashboardServiceBlockingStub>() {
          @java.lang.Override
          public NativeDashboardServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new NativeDashboardServiceBlockingStub(channel, callOptions);
          }
        };
    return NativeDashboardServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static NativeDashboardServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NativeDashboardServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<NativeDashboardServiceFutureStub>() {
          @java.lang.Override
          public NativeDashboardServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new NativeDashboardServiceFutureStub(channel, callOptions);
          }
        };
    return NativeDashboardServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * A service providing functionality for managing native dashboards.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Create a dashboard.
     * </pre>
     */
    default void createNativeDashboard(
        com.google.cloud.chronicle.v1.CreateNativeDashboardRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.NativeDashboard>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateNativeDashboardMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a dashboard.
     * </pre>
     */
    default void getNativeDashboard(
        com.google.cloud.chronicle.v1.GetNativeDashboardRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.NativeDashboard>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetNativeDashboardMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all dashboards.
     * </pre>
     */
    default void listNativeDashboards(
        com.google.cloud.chronicle.v1.ListNativeDashboardsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ListNativeDashboardsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListNativeDashboardsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a dashboard.
     * </pre>
     */
    default void updateNativeDashboard(
        com.google.cloud.chronicle.v1.UpdateNativeDashboardRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.NativeDashboard>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateNativeDashboardMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Duplicate a dashboard.
     * </pre>
     */
    default void duplicateNativeDashboard(
        com.google.cloud.chronicle.v1.DuplicateNativeDashboardRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.NativeDashboard>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDuplicateNativeDashboardMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a dashboard.
     * </pre>
     */
    default void deleteNativeDashboard(
        com.google.cloud.chronicle.v1.DeleteNativeDashboardRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteNativeDashboardMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Add chart in a dashboard.
     * </pre>
     */
    default void addChart(
        com.google.cloud.chronicle.v1.AddChartRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.AddChartResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddChartMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Remove chart from a dashboard.
     * </pre>
     */
    default void removeChart(
        com.google.cloud.chronicle.v1.RemoveChartRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.NativeDashboard>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRemoveChartMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Edit chart in a dashboard.
     * </pre>
     */
    default void editChart(
        com.google.cloud.chronicle.v1.EditChartRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.EditChartResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEditChartMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Duplicate chart in a dashboard.
     * </pre>
     */
    default void duplicateChart(
        com.google.cloud.chronicle.v1.DuplicateChartRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.DuplicateChartResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDuplicateChartMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports the dashboards.
     * </pre>
     */
    default void exportNativeDashboards(
        com.google.cloud.chronicle.v1.ExportNativeDashboardsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ExportNativeDashboardsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExportNativeDashboardsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports the dashboards.
     * </pre>
     */
    default void importNativeDashboards(
        com.google.cloud.chronicle.v1.ImportNativeDashboardsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ImportNativeDashboardsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportNativeDashboardsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service NativeDashboardService.
   *
   * <pre>
   * A service providing functionality for managing native dashboards.
   * </pre>
   */
  public abstract static class NativeDashboardServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return NativeDashboardServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service NativeDashboardService.
   *
   * <pre>
   * A service providing functionality for managing native dashboards.
   * </pre>
   */
  public static final class NativeDashboardServiceStub
      extends io.grpc.stub.AbstractAsyncStub<NativeDashboardServiceStub> {
    private NativeDashboardServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NativeDashboardServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NativeDashboardServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a dashboard.
     * </pre>
     */
    public void createNativeDashboard(
        com.google.cloud.chronicle.v1.CreateNativeDashboardRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.NativeDashboard>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateNativeDashboardMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a dashboard.
     * </pre>
     */
    public void getNativeDashboard(
        com.google.cloud.chronicle.v1.GetNativeDashboardRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.NativeDashboard>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNativeDashboardMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all dashboards.
     * </pre>
     */
    public void listNativeDashboards(
        com.google.cloud.chronicle.v1.ListNativeDashboardsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ListNativeDashboardsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListNativeDashboardsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a dashboard.
     * </pre>
     */
    public void updateNativeDashboard(
        com.google.cloud.chronicle.v1.UpdateNativeDashboardRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.NativeDashboard>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateNativeDashboardMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Duplicate a dashboard.
     * </pre>
     */
    public void duplicateNativeDashboard(
        com.google.cloud.chronicle.v1.DuplicateNativeDashboardRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.NativeDashboard>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDuplicateNativeDashboardMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a dashboard.
     * </pre>
     */
    public void deleteNativeDashboard(
        com.google.cloud.chronicle.v1.DeleteNativeDashboardRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteNativeDashboardMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Add chart in a dashboard.
     * </pre>
     */
    public void addChart(
        com.google.cloud.chronicle.v1.AddChartRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.AddChartResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddChartMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Remove chart from a dashboard.
     * </pre>
     */
    public void removeChart(
        com.google.cloud.chronicle.v1.RemoveChartRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.NativeDashboard>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveChartMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Edit chart in a dashboard.
     * </pre>
     */
    public void editChart(
        com.google.cloud.chronicle.v1.EditChartRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.EditChartResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEditChartMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Duplicate chart in a dashboard.
     * </pre>
     */
    public void duplicateChart(
        com.google.cloud.chronicle.v1.DuplicateChartRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.DuplicateChartResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDuplicateChartMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports the dashboards.
     * </pre>
     */
    public void exportNativeDashboards(
        com.google.cloud.chronicle.v1.ExportNativeDashboardsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ExportNativeDashboardsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportNativeDashboardsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports the dashboards.
     * </pre>
     */
    public void importNativeDashboards(
        com.google.cloud.chronicle.v1.ImportNativeDashboardsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ImportNativeDashboardsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportNativeDashboardsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service NativeDashboardService.
   *
   * <pre>
   * A service providing functionality for managing native dashboards.
   * </pre>
   */
  public static final class NativeDashboardServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<NativeDashboardServiceBlockingV2Stub> {
    private NativeDashboardServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NativeDashboardServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NativeDashboardServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a dashboard.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.NativeDashboard createNativeDashboard(
        com.google.cloud.chronicle.v1.CreateNativeDashboardRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateNativeDashboardMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a dashboard.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.NativeDashboard getNativeDashboard(
        com.google.cloud.chronicle.v1.GetNativeDashboardRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetNativeDashboardMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all dashboards.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ListNativeDashboardsResponse listNativeDashboards(
        com.google.cloud.chronicle.v1.ListNativeDashboardsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListNativeDashboardsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a dashboard.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.NativeDashboard updateNativeDashboard(
        com.google.cloud.chronicle.v1.UpdateNativeDashboardRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateNativeDashboardMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Duplicate a dashboard.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.NativeDashboard duplicateNativeDashboard(
        com.google.cloud.chronicle.v1.DuplicateNativeDashboardRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDuplicateNativeDashboardMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a dashboard.
     * </pre>
     */
    public com.google.protobuf.Empty deleteNativeDashboard(
        com.google.cloud.chronicle.v1.DeleteNativeDashboardRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteNativeDashboardMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Add chart in a dashboard.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.AddChartResponse addChart(
        com.google.cloud.chronicle.v1.AddChartRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getAddChartMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Remove chart from a dashboard.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.NativeDashboard removeChart(
        com.google.cloud.chronicle.v1.RemoveChartRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRemoveChartMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Edit chart in a dashboard.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.EditChartResponse editChart(
        com.google.cloud.chronicle.v1.EditChartRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getEditChartMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Duplicate chart in a dashboard.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.DuplicateChartResponse duplicateChart(
        com.google.cloud.chronicle.v1.DuplicateChartRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDuplicateChartMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports the dashboards.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ExportNativeDashboardsResponse exportNativeDashboards(
        com.google.cloud.chronicle.v1.ExportNativeDashboardsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getExportNativeDashboardsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports the dashboards.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ImportNativeDashboardsResponse importNativeDashboards(
        com.google.cloud.chronicle.v1.ImportNativeDashboardsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getImportNativeDashboardsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service NativeDashboardService.
   *
   * <pre>
   * A service providing functionality for managing native dashboards.
   * </pre>
   */
  public static final class NativeDashboardServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<NativeDashboardServiceBlockingStub> {
    private NativeDashboardServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NativeDashboardServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NativeDashboardServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a dashboard.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.NativeDashboard createNativeDashboard(
        com.google.cloud.chronicle.v1.CreateNativeDashboardRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateNativeDashboardMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a dashboard.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.NativeDashboard getNativeDashboard(
        com.google.cloud.chronicle.v1.GetNativeDashboardRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNativeDashboardMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all dashboards.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ListNativeDashboardsResponse listNativeDashboards(
        com.google.cloud.chronicle.v1.ListNativeDashboardsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListNativeDashboardsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a dashboard.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.NativeDashboard updateNativeDashboard(
        com.google.cloud.chronicle.v1.UpdateNativeDashboardRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateNativeDashboardMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Duplicate a dashboard.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.NativeDashboard duplicateNativeDashboard(
        com.google.cloud.chronicle.v1.DuplicateNativeDashboardRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDuplicateNativeDashboardMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a dashboard.
     * </pre>
     */
    public com.google.protobuf.Empty deleteNativeDashboard(
        com.google.cloud.chronicle.v1.DeleteNativeDashboardRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteNativeDashboardMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Add chart in a dashboard.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.AddChartResponse addChart(
        com.google.cloud.chronicle.v1.AddChartRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddChartMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Remove chart from a dashboard.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.NativeDashboard removeChart(
        com.google.cloud.chronicle.v1.RemoveChartRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveChartMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Edit chart in a dashboard.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.EditChartResponse editChart(
        com.google.cloud.chronicle.v1.EditChartRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEditChartMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Duplicate chart in a dashboard.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.DuplicateChartResponse duplicateChart(
        com.google.cloud.chronicle.v1.DuplicateChartRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDuplicateChartMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports the dashboards.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ExportNativeDashboardsResponse exportNativeDashboards(
        com.google.cloud.chronicle.v1.ExportNativeDashboardsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportNativeDashboardsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports the dashboards.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ImportNativeDashboardsResponse importNativeDashboards(
        com.google.cloud.chronicle.v1.ImportNativeDashboardsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportNativeDashboardsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * NativeDashboardService.
   *
   * <pre>
   * A service providing functionality for managing native dashboards.
   * </pre>
   */
  public static final class NativeDashboardServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<NativeDashboardServiceFutureStub> {
    private NativeDashboardServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NativeDashboardServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NativeDashboardServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a dashboard.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.NativeDashboard>
        createNativeDashboard(com.google.cloud.chronicle.v1.CreateNativeDashboardRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateNativeDashboardMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get a dashboard.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.NativeDashboard>
        getNativeDashboard(com.google.cloud.chronicle.v1.GetNativeDashboardRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNativeDashboardMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List all dashboards.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.ListNativeDashboardsResponse>
        listNativeDashboards(com.google.cloud.chronicle.v1.ListNativeDashboardsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListNativeDashboardsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a dashboard.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.NativeDashboard>
        updateNativeDashboard(com.google.cloud.chronicle.v1.UpdateNativeDashboardRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateNativeDashboardMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Duplicate a dashboard.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.NativeDashboard>
        duplicateNativeDashboard(
            com.google.cloud.chronicle.v1.DuplicateNativeDashboardRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDuplicateNativeDashboardMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a dashboard.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteNativeDashboard(com.google.cloud.chronicle.v1.DeleteNativeDashboardRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteNativeDashboardMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Add chart in a dashboard.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.AddChartResponse>
        addChart(com.google.cloud.chronicle.v1.AddChartRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddChartMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Remove chart from a dashboard.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.NativeDashboard>
        removeChart(com.google.cloud.chronicle.v1.RemoveChartRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveChartMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Edit chart in a dashboard.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.EditChartResponse>
        editChart(com.google.cloud.chronicle.v1.EditChartRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEditChartMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Duplicate chart in a dashboard.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.DuplicateChartResponse>
        duplicateChart(com.google.cloud.chronicle.v1.DuplicateChartRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDuplicateChartMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Exports the dashboards.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.ExportNativeDashboardsResponse>
        exportNativeDashboards(
            com.google.cloud.chronicle.v1.ExportNativeDashboardsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportNativeDashboardsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Imports the dashboards.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.ImportNativeDashboardsResponse>
        importNativeDashboards(
            com.google.cloud.chronicle.v1.ImportNativeDashboardsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportNativeDashboardsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_NATIVE_DASHBOARD = 0;
  private static final int METHODID_GET_NATIVE_DASHBOARD = 1;
  private static final int METHODID_LIST_NATIVE_DASHBOARDS = 2;
  private static final int METHODID_UPDATE_NATIVE_DASHBOARD = 3;
  private static final int METHODID_DUPLICATE_NATIVE_DASHBOARD = 4;
  private static final int METHODID_DELETE_NATIVE_DASHBOARD = 5;
  private static final int METHODID_ADD_CHART = 6;
  private static final int METHODID_REMOVE_CHART = 7;
  private static final int METHODID_EDIT_CHART = 8;
  private static final int METHODID_DUPLICATE_CHART = 9;
  private static final int METHODID_EXPORT_NATIVE_DASHBOARDS = 10;
  private static final int METHODID_IMPORT_NATIVE_DASHBOARDS = 11;

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
        case METHODID_CREATE_NATIVE_DASHBOARD:
          serviceImpl.createNativeDashboard(
              (com.google.cloud.chronicle.v1.CreateNativeDashboardRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.NativeDashboard>)
                  responseObserver);
          break;
        case METHODID_GET_NATIVE_DASHBOARD:
          serviceImpl.getNativeDashboard(
              (com.google.cloud.chronicle.v1.GetNativeDashboardRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.NativeDashboard>)
                  responseObserver);
          break;
        case METHODID_LIST_NATIVE_DASHBOARDS:
          serviceImpl.listNativeDashboards(
              (com.google.cloud.chronicle.v1.ListNativeDashboardsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.chronicle.v1.ListNativeDashboardsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_NATIVE_DASHBOARD:
          serviceImpl.updateNativeDashboard(
              (com.google.cloud.chronicle.v1.UpdateNativeDashboardRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.NativeDashboard>)
                  responseObserver);
          break;
        case METHODID_DUPLICATE_NATIVE_DASHBOARD:
          serviceImpl.duplicateNativeDashboard(
              (com.google.cloud.chronicle.v1.DuplicateNativeDashboardRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.NativeDashboard>)
                  responseObserver);
          break;
        case METHODID_DELETE_NATIVE_DASHBOARD:
          serviceImpl.deleteNativeDashboard(
              (com.google.cloud.chronicle.v1.DeleteNativeDashboardRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_ADD_CHART:
          serviceImpl.addChart(
              (com.google.cloud.chronicle.v1.AddChartRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.AddChartResponse>)
                  responseObserver);
          break;
        case METHODID_REMOVE_CHART:
          serviceImpl.removeChart(
              (com.google.cloud.chronicle.v1.RemoveChartRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.NativeDashboard>)
                  responseObserver);
          break;
        case METHODID_EDIT_CHART:
          serviceImpl.editChart(
              (com.google.cloud.chronicle.v1.EditChartRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.EditChartResponse>)
                  responseObserver);
          break;
        case METHODID_DUPLICATE_CHART:
          serviceImpl.duplicateChart(
              (com.google.cloud.chronicle.v1.DuplicateChartRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.DuplicateChartResponse>)
                  responseObserver);
          break;
        case METHODID_EXPORT_NATIVE_DASHBOARDS:
          serviceImpl.exportNativeDashboards(
              (com.google.cloud.chronicle.v1.ExportNativeDashboardsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.chronicle.v1.ExportNativeDashboardsResponse>)
                  responseObserver);
          break;
        case METHODID_IMPORT_NATIVE_DASHBOARDS:
          serviceImpl.importNativeDashboards(
              (com.google.cloud.chronicle.v1.ImportNativeDashboardsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.chronicle.v1.ImportNativeDashboardsResponse>)
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
            getCreateNativeDashboardMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.CreateNativeDashboardRequest,
                    com.google.cloud.chronicle.v1.NativeDashboard>(
                    service, METHODID_CREATE_NATIVE_DASHBOARD)))
        .addMethod(
            getGetNativeDashboardMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.GetNativeDashboardRequest,
                    com.google.cloud.chronicle.v1.NativeDashboard>(
                    service, METHODID_GET_NATIVE_DASHBOARD)))
        .addMethod(
            getListNativeDashboardsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.ListNativeDashboardsRequest,
                    com.google.cloud.chronicle.v1.ListNativeDashboardsResponse>(
                    service, METHODID_LIST_NATIVE_DASHBOARDS)))
        .addMethod(
            getUpdateNativeDashboardMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.UpdateNativeDashboardRequest,
                    com.google.cloud.chronicle.v1.NativeDashboard>(
                    service, METHODID_UPDATE_NATIVE_DASHBOARD)))
        .addMethod(
            getDuplicateNativeDashboardMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.DuplicateNativeDashboardRequest,
                    com.google.cloud.chronicle.v1.NativeDashboard>(
                    service, METHODID_DUPLICATE_NATIVE_DASHBOARD)))
        .addMethod(
            getDeleteNativeDashboardMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.DeleteNativeDashboardRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_NATIVE_DASHBOARD)))
        .addMethod(
            getAddChartMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.AddChartRequest,
                    com.google.cloud.chronicle.v1.AddChartResponse>(service, METHODID_ADD_CHART)))
        .addMethod(
            getRemoveChartMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.RemoveChartRequest,
                    com.google.cloud.chronicle.v1.NativeDashboard>(service, METHODID_REMOVE_CHART)))
        .addMethod(
            getEditChartMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.EditChartRequest,
                    com.google.cloud.chronicle.v1.EditChartResponse>(service, METHODID_EDIT_CHART)))
        .addMethod(
            getDuplicateChartMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.DuplicateChartRequest,
                    com.google.cloud.chronicle.v1.DuplicateChartResponse>(
                    service, METHODID_DUPLICATE_CHART)))
        .addMethod(
            getExportNativeDashboardsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.ExportNativeDashboardsRequest,
                    com.google.cloud.chronicle.v1.ExportNativeDashboardsResponse>(
                    service, METHODID_EXPORT_NATIVE_DASHBOARDS)))
        .addMethod(
            getImportNativeDashboardsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.ImportNativeDashboardsRequest,
                    com.google.cloud.chronicle.v1.ImportNativeDashboardsResponse>(
                    service, METHODID_IMPORT_NATIVE_DASHBOARDS)))
        .build();
  }

  private abstract static class NativeDashboardServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NativeDashboardServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.chronicle.v1.NativeDashboardProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("NativeDashboardService");
    }
  }

  private static final class NativeDashboardServiceFileDescriptorSupplier
      extends NativeDashboardServiceBaseDescriptorSupplier {
    NativeDashboardServiceFileDescriptorSupplier() {}
  }

  private static final class NativeDashboardServiceMethodDescriptorSupplier
      extends NativeDashboardServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    NativeDashboardServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (NativeDashboardServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new NativeDashboardServiceFileDescriptorSupplier())
                      .addMethod(getCreateNativeDashboardMethod())
                      .addMethod(getGetNativeDashboardMethod())
                      .addMethod(getListNativeDashboardsMethod())
                      .addMethod(getUpdateNativeDashboardMethod())
                      .addMethod(getDuplicateNativeDashboardMethod())
                      .addMethod(getDeleteNativeDashboardMethod())
                      .addMethod(getAddChartMethod())
                      .addMethod(getRemoveChartMethod())
                      .addMethod(getEditChartMethod())
                      .addMethod(getDuplicateChartMethod())
                      .addMethod(getExportNativeDashboardsMethod())
                      .addMethod(getImportNativeDashboardsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
