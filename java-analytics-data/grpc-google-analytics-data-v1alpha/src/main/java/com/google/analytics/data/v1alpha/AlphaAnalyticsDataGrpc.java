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
package com.google.analytics.data.v1alpha;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Google Analytics reporting data service.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/analytics/data/v1alpha/analytics_data_api.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AlphaAnalyticsDataGrpc {

  private AlphaAnalyticsDataGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.analytics.data.v1alpha.AlphaAnalyticsData";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.RunFunnelReportRequest,
          com.google.analytics.data.v1alpha.RunFunnelReportResponse>
      getRunFunnelReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RunFunnelReport",
      requestType = com.google.analytics.data.v1alpha.RunFunnelReportRequest.class,
      responseType = com.google.analytics.data.v1alpha.RunFunnelReportResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.RunFunnelReportRequest,
          com.google.analytics.data.v1alpha.RunFunnelReportResponse>
      getRunFunnelReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.data.v1alpha.RunFunnelReportRequest,
            com.google.analytics.data.v1alpha.RunFunnelReportResponse>
        getRunFunnelReportMethod;
    if ((getRunFunnelReportMethod = AlphaAnalyticsDataGrpc.getRunFunnelReportMethod) == null) {
      synchronized (AlphaAnalyticsDataGrpc.class) {
        if ((getRunFunnelReportMethod = AlphaAnalyticsDataGrpc.getRunFunnelReportMethod) == null) {
          AlphaAnalyticsDataGrpc.getRunFunnelReportMethod =
              getRunFunnelReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.data.v1alpha.RunFunnelReportRequest,
                          com.google.analytics.data.v1alpha.RunFunnelReportResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RunFunnelReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.RunFunnelReportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.RunFunnelReportResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlphaAnalyticsDataMethodDescriptorSupplier("RunFunnelReport"))
                      .build();
        }
      }
    }
    return getRunFunnelReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.CreateAudienceListRequest,
          com.google.longrunning.Operation>
      getCreateAudienceListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAudienceList",
      requestType = com.google.analytics.data.v1alpha.CreateAudienceListRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.CreateAudienceListRequest,
          com.google.longrunning.Operation>
      getCreateAudienceListMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.data.v1alpha.CreateAudienceListRequest,
            com.google.longrunning.Operation>
        getCreateAudienceListMethod;
    if ((getCreateAudienceListMethod = AlphaAnalyticsDataGrpc.getCreateAudienceListMethod)
        == null) {
      synchronized (AlphaAnalyticsDataGrpc.class) {
        if ((getCreateAudienceListMethod = AlphaAnalyticsDataGrpc.getCreateAudienceListMethod)
            == null) {
          AlphaAnalyticsDataGrpc.getCreateAudienceListMethod =
              getCreateAudienceListMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.data.v1alpha.CreateAudienceListRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAudienceList"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.CreateAudienceListRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlphaAnalyticsDataMethodDescriptorSupplier("CreateAudienceList"))
                      .build();
        }
      }
    }
    return getCreateAudienceListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.QueryAudienceListRequest,
          com.google.analytics.data.v1alpha.QueryAudienceListResponse>
      getQueryAudienceListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryAudienceList",
      requestType = com.google.analytics.data.v1alpha.QueryAudienceListRequest.class,
      responseType = com.google.analytics.data.v1alpha.QueryAudienceListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.QueryAudienceListRequest,
          com.google.analytics.data.v1alpha.QueryAudienceListResponse>
      getQueryAudienceListMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.data.v1alpha.QueryAudienceListRequest,
            com.google.analytics.data.v1alpha.QueryAudienceListResponse>
        getQueryAudienceListMethod;
    if ((getQueryAudienceListMethod = AlphaAnalyticsDataGrpc.getQueryAudienceListMethod) == null) {
      synchronized (AlphaAnalyticsDataGrpc.class) {
        if ((getQueryAudienceListMethod = AlphaAnalyticsDataGrpc.getQueryAudienceListMethod)
            == null) {
          AlphaAnalyticsDataGrpc.getQueryAudienceListMethod =
              getQueryAudienceListMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.data.v1alpha.QueryAudienceListRequest,
                          com.google.analytics.data.v1alpha.QueryAudienceListResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QueryAudienceList"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.QueryAudienceListRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.QueryAudienceListResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlphaAnalyticsDataMethodDescriptorSupplier("QueryAudienceList"))
                      .build();
        }
      }
    }
    return getQueryAudienceListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.SheetExportAudienceListRequest,
          com.google.analytics.data.v1alpha.SheetExportAudienceListResponse>
      getSheetExportAudienceListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SheetExportAudienceList",
      requestType = com.google.analytics.data.v1alpha.SheetExportAudienceListRequest.class,
      responseType = com.google.analytics.data.v1alpha.SheetExportAudienceListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.SheetExportAudienceListRequest,
          com.google.analytics.data.v1alpha.SheetExportAudienceListResponse>
      getSheetExportAudienceListMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.data.v1alpha.SheetExportAudienceListRequest,
            com.google.analytics.data.v1alpha.SheetExportAudienceListResponse>
        getSheetExportAudienceListMethod;
    if ((getSheetExportAudienceListMethod = AlphaAnalyticsDataGrpc.getSheetExportAudienceListMethod)
        == null) {
      synchronized (AlphaAnalyticsDataGrpc.class) {
        if ((getSheetExportAudienceListMethod =
                AlphaAnalyticsDataGrpc.getSheetExportAudienceListMethod)
            == null) {
          AlphaAnalyticsDataGrpc.getSheetExportAudienceListMethod =
              getSheetExportAudienceListMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.data.v1alpha.SheetExportAudienceListRequest,
                          com.google.analytics.data.v1alpha.SheetExportAudienceListResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SheetExportAudienceList"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.SheetExportAudienceListRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.SheetExportAudienceListResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlphaAnalyticsDataMethodDescriptorSupplier("SheetExportAudienceList"))
                      .build();
        }
      }
    }
    return getSheetExportAudienceListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.GetAudienceListRequest,
          com.google.analytics.data.v1alpha.AudienceList>
      getGetAudienceListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAudienceList",
      requestType = com.google.analytics.data.v1alpha.GetAudienceListRequest.class,
      responseType = com.google.analytics.data.v1alpha.AudienceList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.GetAudienceListRequest,
          com.google.analytics.data.v1alpha.AudienceList>
      getGetAudienceListMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.data.v1alpha.GetAudienceListRequest,
            com.google.analytics.data.v1alpha.AudienceList>
        getGetAudienceListMethod;
    if ((getGetAudienceListMethod = AlphaAnalyticsDataGrpc.getGetAudienceListMethod) == null) {
      synchronized (AlphaAnalyticsDataGrpc.class) {
        if ((getGetAudienceListMethod = AlphaAnalyticsDataGrpc.getGetAudienceListMethod) == null) {
          AlphaAnalyticsDataGrpc.getGetAudienceListMethod =
              getGetAudienceListMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.data.v1alpha.GetAudienceListRequest,
                          com.google.analytics.data.v1alpha.AudienceList>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAudienceList"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.GetAudienceListRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.AudienceList.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlphaAnalyticsDataMethodDescriptorSupplier("GetAudienceList"))
                      .build();
        }
      }
    }
    return getGetAudienceListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.ListAudienceListsRequest,
          com.google.analytics.data.v1alpha.ListAudienceListsResponse>
      getListAudienceListsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAudienceLists",
      requestType = com.google.analytics.data.v1alpha.ListAudienceListsRequest.class,
      responseType = com.google.analytics.data.v1alpha.ListAudienceListsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.ListAudienceListsRequest,
          com.google.analytics.data.v1alpha.ListAudienceListsResponse>
      getListAudienceListsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.data.v1alpha.ListAudienceListsRequest,
            com.google.analytics.data.v1alpha.ListAudienceListsResponse>
        getListAudienceListsMethod;
    if ((getListAudienceListsMethod = AlphaAnalyticsDataGrpc.getListAudienceListsMethod) == null) {
      synchronized (AlphaAnalyticsDataGrpc.class) {
        if ((getListAudienceListsMethod = AlphaAnalyticsDataGrpc.getListAudienceListsMethod)
            == null) {
          AlphaAnalyticsDataGrpc.getListAudienceListsMethod =
              getListAudienceListsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.data.v1alpha.ListAudienceListsRequest,
                          com.google.analytics.data.v1alpha.ListAudienceListsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAudienceLists"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.ListAudienceListsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.ListAudienceListsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlphaAnalyticsDataMethodDescriptorSupplier("ListAudienceLists"))
                      .build();
        }
      }
    }
    return getListAudienceListsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.CreateRecurringAudienceListRequest,
          com.google.analytics.data.v1alpha.RecurringAudienceList>
      getCreateRecurringAudienceListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRecurringAudienceList",
      requestType = com.google.analytics.data.v1alpha.CreateRecurringAudienceListRequest.class,
      responseType = com.google.analytics.data.v1alpha.RecurringAudienceList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.CreateRecurringAudienceListRequest,
          com.google.analytics.data.v1alpha.RecurringAudienceList>
      getCreateRecurringAudienceListMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.data.v1alpha.CreateRecurringAudienceListRequest,
            com.google.analytics.data.v1alpha.RecurringAudienceList>
        getCreateRecurringAudienceListMethod;
    if ((getCreateRecurringAudienceListMethod =
            AlphaAnalyticsDataGrpc.getCreateRecurringAudienceListMethod)
        == null) {
      synchronized (AlphaAnalyticsDataGrpc.class) {
        if ((getCreateRecurringAudienceListMethod =
                AlphaAnalyticsDataGrpc.getCreateRecurringAudienceListMethod)
            == null) {
          AlphaAnalyticsDataGrpc.getCreateRecurringAudienceListMethod =
              getCreateRecurringAudienceListMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.data.v1alpha.CreateRecurringAudienceListRequest,
                          com.google.analytics.data.v1alpha.RecurringAudienceList>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateRecurringAudienceList"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.CreateRecurringAudienceListRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.RecurringAudienceList
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlphaAnalyticsDataMethodDescriptorSupplier(
                              "CreateRecurringAudienceList"))
                      .build();
        }
      }
    }
    return getCreateRecurringAudienceListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.GetRecurringAudienceListRequest,
          com.google.analytics.data.v1alpha.RecurringAudienceList>
      getGetRecurringAudienceListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRecurringAudienceList",
      requestType = com.google.analytics.data.v1alpha.GetRecurringAudienceListRequest.class,
      responseType = com.google.analytics.data.v1alpha.RecurringAudienceList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.GetRecurringAudienceListRequest,
          com.google.analytics.data.v1alpha.RecurringAudienceList>
      getGetRecurringAudienceListMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.data.v1alpha.GetRecurringAudienceListRequest,
            com.google.analytics.data.v1alpha.RecurringAudienceList>
        getGetRecurringAudienceListMethod;
    if ((getGetRecurringAudienceListMethod =
            AlphaAnalyticsDataGrpc.getGetRecurringAudienceListMethod)
        == null) {
      synchronized (AlphaAnalyticsDataGrpc.class) {
        if ((getGetRecurringAudienceListMethod =
                AlphaAnalyticsDataGrpc.getGetRecurringAudienceListMethod)
            == null) {
          AlphaAnalyticsDataGrpc.getGetRecurringAudienceListMethod =
              getGetRecurringAudienceListMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.data.v1alpha.GetRecurringAudienceListRequest,
                          com.google.analytics.data.v1alpha.RecurringAudienceList>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetRecurringAudienceList"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.GetRecurringAudienceListRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.RecurringAudienceList
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlphaAnalyticsDataMethodDescriptorSupplier(
                              "GetRecurringAudienceList"))
                      .build();
        }
      }
    }
    return getGetRecurringAudienceListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.ListRecurringAudienceListsRequest,
          com.google.analytics.data.v1alpha.ListRecurringAudienceListsResponse>
      getListRecurringAudienceListsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRecurringAudienceLists",
      requestType = com.google.analytics.data.v1alpha.ListRecurringAudienceListsRequest.class,
      responseType = com.google.analytics.data.v1alpha.ListRecurringAudienceListsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.ListRecurringAudienceListsRequest,
          com.google.analytics.data.v1alpha.ListRecurringAudienceListsResponse>
      getListRecurringAudienceListsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.data.v1alpha.ListRecurringAudienceListsRequest,
            com.google.analytics.data.v1alpha.ListRecurringAudienceListsResponse>
        getListRecurringAudienceListsMethod;
    if ((getListRecurringAudienceListsMethod =
            AlphaAnalyticsDataGrpc.getListRecurringAudienceListsMethod)
        == null) {
      synchronized (AlphaAnalyticsDataGrpc.class) {
        if ((getListRecurringAudienceListsMethod =
                AlphaAnalyticsDataGrpc.getListRecurringAudienceListsMethod)
            == null) {
          AlphaAnalyticsDataGrpc.getListRecurringAudienceListsMethod =
              getListRecurringAudienceListsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.data.v1alpha.ListRecurringAudienceListsRequest,
                          com.google.analytics.data.v1alpha.ListRecurringAudienceListsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListRecurringAudienceLists"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.ListRecurringAudienceListsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.ListRecurringAudienceListsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlphaAnalyticsDataMethodDescriptorSupplier(
                              "ListRecurringAudienceLists"))
                      .build();
        }
      }
    }
    return getListRecurringAudienceListsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.CreateReportTaskRequest,
          com.google.longrunning.Operation>
      getCreateReportTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateReportTask",
      requestType = com.google.analytics.data.v1alpha.CreateReportTaskRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.CreateReportTaskRequest,
          com.google.longrunning.Operation>
      getCreateReportTaskMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.data.v1alpha.CreateReportTaskRequest,
            com.google.longrunning.Operation>
        getCreateReportTaskMethod;
    if ((getCreateReportTaskMethod = AlphaAnalyticsDataGrpc.getCreateReportTaskMethod) == null) {
      synchronized (AlphaAnalyticsDataGrpc.class) {
        if ((getCreateReportTaskMethod = AlphaAnalyticsDataGrpc.getCreateReportTaskMethod)
            == null) {
          AlphaAnalyticsDataGrpc.getCreateReportTaskMethod =
              getCreateReportTaskMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.data.v1alpha.CreateReportTaskRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateReportTask"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.CreateReportTaskRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlphaAnalyticsDataMethodDescriptorSupplier("CreateReportTask"))
                      .build();
        }
      }
    }
    return getCreateReportTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.QueryReportTaskRequest,
          com.google.analytics.data.v1alpha.QueryReportTaskResponse>
      getQueryReportTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryReportTask",
      requestType = com.google.analytics.data.v1alpha.QueryReportTaskRequest.class,
      responseType = com.google.analytics.data.v1alpha.QueryReportTaskResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.QueryReportTaskRequest,
          com.google.analytics.data.v1alpha.QueryReportTaskResponse>
      getQueryReportTaskMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.data.v1alpha.QueryReportTaskRequest,
            com.google.analytics.data.v1alpha.QueryReportTaskResponse>
        getQueryReportTaskMethod;
    if ((getQueryReportTaskMethod = AlphaAnalyticsDataGrpc.getQueryReportTaskMethod) == null) {
      synchronized (AlphaAnalyticsDataGrpc.class) {
        if ((getQueryReportTaskMethod = AlphaAnalyticsDataGrpc.getQueryReportTaskMethod) == null) {
          AlphaAnalyticsDataGrpc.getQueryReportTaskMethod =
              getQueryReportTaskMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.data.v1alpha.QueryReportTaskRequest,
                          com.google.analytics.data.v1alpha.QueryReportTaskResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QueryReportTask"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.QueryReportTaskRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.QueryReportTaskResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlphaAnalyticsDataMethodDescriptorSupplier("QueryReportTask"))
                      .build();
        }
      }
    }
    return getQueryReportTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.GetReportTaskRequest,
          com.google.analytics.data.v1alpha.ReportTask>
      getGetReportTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReportTask",
      requestType = com.google.analytics.data.v1alpha.GetReportTaskRequest.class,
      responseType = com.google.analytics.data.v1alpha.ReportTask.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.GetReportTaskRequest,
          com.google.analytics.data.v1alpha.ReportTask>
      getGetReportTaskMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.data.v1alpha.GetReportTaskRequest,
            com.google.analytics.data.v1alpha.ReportTask>
        getGetReportTaskMethod;
    if ((getGetReportTaskMethod = AlphaAnalyticsDataGrpc.getGetReportTaskMethod) == null) {
      synchronized (AlphaAnalyticsDataGrpc.class) {
        if ((getGetReportTaskMethod = AlphaAnalyticsDataGrpc.getGetReportTaskMethod) == null) {
          AlphaAnalyticsDataGrpc.getGetReportTaskMethod =
              getGetReportTaskMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.data.v1alpha.GetReportTaskRequest,
                          com.google.analytics.data.v1alpha.ReportTask>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetReportTask"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.GetReportTaskRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.ReportTask.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlphaAnalyticsDataMethodDescriptorSupplier("GetReportTask"))
                      .build();
        }
      }
    }
    return getGetReportTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.ListReportTasksRequest,
          com.google.analytics.data.v1alpha.ListReportTasksResponse>
      getListReportTasksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListReportTasks",
      requestType = com.google.analytics.data.v1alpha.ListReportTasksRequest.class,
      responseType = com.google.analytics.data.v1alpha.ListReportTasksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.ListReportTasksRequest,
          com.google.analytics.data.v1alpha.ListReportTasksResponse>
      getListReportTasksMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.data.v1alpha.ListReportTasksRequest,
            com.google.analytics.data.v1alpha.ListReportTasksResponse>
        getListReportTasksMethod;
    if ((getListReportTasksMethod = AlphaAnalyticsDataGrpc.getListReportTasksMethod) == null) {
      synchronized (AlphaAnalyticsDataGrpc.class) {
        if ((getListReportTasksMethod = AlphaAnalyticsDataGrpc.getListReportTasksMethod) == null) {
          AlphaAnalyticsDataGrpc.getListReportTasksMethod =
              getListReportTasksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.data.v1alpha.ListReportTasksRequest,
                          com.google.analytics.data.v1alpha.ListReportTasksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListReportTasks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.ListReportTasksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.ListReportTasksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlphaAnalyticsDataMethodDescriptorSupplier("ListReportTasks"))
                      .build();
        }
      }
    }
    return getListReportTasksMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AlphaAnalyticsDataStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AlphaAnalyticsDataStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AlphaAnalyticsDataStub>() {
          @java.lang.Override
          public AlphaAnalyticsDataStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AlphaAnalyticsDataStub(channel, callOptions);
          }
        };
    return AlphaAnalyticsDataStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AlphaAnalyticsDataBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AlphaAnalyticsDataBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AlphaAnalyticsDataBlockingStub>() {
          @java.lang.Override
          public AlphaAnalyticsDataBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AlphaAnalyticsDataBlockingStub(channel, callOptions);
          }
        };
    return AlphaAnalyticsDataBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AlphaAnalyticsDataFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AlphaAnalyticsDataFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AlphaAnalyticsDataFutureStub>() {
          @java.lang.Override
          public AlphaAnalyticsDataFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AlphaAnalyticsDataFutureStub(channel, callOptions);
          }
        };
    return AlphaAnalyticsDataFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Google Analytics reporting data service.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Returns a customized funnel report of your Google Analytics event data. The
     * data returned from the API is as a table with columns for the requested
     * dimensions and metrics.
     * Funnel exploration lets you visualize the steps your users take to complete
     * a task and quickly see how well they are succeeding or failing at each
     * step. For example, how do prospects become shoppers and then become buyers?
     * How do one time buyers become repeat buyers? With this information, you can
     * improve inefficient or abandoned customer journeys. To learn more, see [GA4
     * Funnel Explorations](https://support.google.com/analytics/answer/9327974).
     * This method is introduced at alpha stability with the intention of
     * gathering feedback on syntax and capabilities before entering beta. To give
     * your feedback on this API, complete the [Google Analytics Data API Funnel
     * Reporting
     * Feedback](https://docs.google.com/forms/d/e/1FAIpQLSdwOlQDJAUoBiIgUZZ3S_Lwi8gr7Bb0k1jhvc-DEg7Rol3UjA/viewform).
     * </pre>
     */
    default void runFunnelReport(
        com.google.analytics.data.v1alpha.RunFunnelReportRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.RunFunnelReportResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRunFunnelReportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an audience list for later retrieval. This method quickly returns
     * the audience list's resource name and initiates a long running asynchronous
     * request to form an audience list. To list the users in an audience list,
     * first create the audience list through this method and then send the
     * audience resource name to the `QueryAudienceList` method.
     * See [Creating an Audience
     * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Lists with examples.
     * An audience list is a snapshot of the users currently in the audience at
     * the time of audience list creation. Creating audience lists for one
     * audience on different days will return different results as users enter and
     * exit the audience.
     * Audiences in Google Analytics 4 allow you to segment your users in the ways
     * that are important to your business. To learn more, see
     * https://support.google.com/analytics/answer/9267572. Audience lists contain
     * the users in each audience.
     * This method is available at beta stability at
     * [audienceExports.create](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/create).
     * To give your feedback on this API, complete the [Google Analytics Audience
     * Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    default void createAudienceList(
        com.google.analytics.data.v1alpha.CreateAudienceListRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAudienceListMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an audience list of users. After creating an audience, the users
     * are not immediately available for listing. First, a request to
     * `CreateAudienceList` is necessary to create an audience list of users, and
     * then second, this method is used to retrieve the users in the audience
     * list.
     * See [Creating an Audience
     * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Lists with examples.
     * Audiences in Google Analytics 4 allow you to segment your users in the ways
     * that are important to your business. To learn more, see
     * https://support.google.com/analytics/answer/9267572.
     * This method is available at beta stability at
     * [audienceExports.query](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/query).
     * To give your feedback on this API, complete the [Google Analytics Audience
     * Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    default void queryAudienceList(
        com.google.analytics.data.v1alpha.QueryAudienceListRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.QueryAudienceListResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getQueryAudienceListMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports an audience list of users to a Google Sheet. After creating an
     * audience, the users are not immediately available for listing. First, a
     * request to `CreateAudienceList` is necessary to create an audience list of
     * users, and then second, this method is used to export those users in the
     * audience list to a Google Sheet.
     * See [Creating an Audience
     * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Lists with examples.
     * Audiences in Google Analytics 4 allow you to segment your users in the ways
     * that are important to your business. To learn more, see
     * https://support.google.com/analytics/answer/9267572.
     * This method is introduced at alpha stability with the intention of
     * gathering feedback on syntax and capabilities before entering beta. To give
     * your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    default void sheetExportAudienceList(
        com.google.analytics.data.v1alpha.SheetExportAudienceListRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.data.v1alpha.SheetExportAudienceListResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSheetExportAudienceListMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets configuration metadata about a specific audience list. This method
     * can be used to understand an audience list after it has been created.
     * See [Creating an Audience
     * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Lists with examples.
     * This method is available at beta stability at
     * [audienceExports.get](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/get).
     * To give your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    default void getAudienceList(
        com.google.analytics.data.v1alpha.GetAudienceListRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.AudienceList>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAudienceListMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all audience lists for a property. This method can be used for you to
     * find and reuse existing audience lists rather than creating unnecessary new
     * audience lists. The same audience can have multiple audience lists that
     * represent the list of users that were in an audience on different days.
     * See [Creating an Audience
     * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Lists with examples.
     * This method is available at beta stability at
     * [audienceExports.list](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/list).
     * To give your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    default void listAudienceLists(
        com.google.analytics.data.v1alpha.ListAudienceListsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.ListAudienceListsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAudienceListsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a recurring audience list. Recurring audience lists produces new
     * audience lists each day. Audience lists are users in an audience at the
     * time of the list's creation.
     * A recurring audience list ensures that you have audience list based on the
     * most recent data available for use each day. If you manually create
     * audience list, you don't know when an audience list based on an additional
     * day's data is available. This recurring audience list automates the
     * creation of an audience list when an additional day's data is available.
     * You will consume fewer quota tokens by using recurring audience list versus
     * manually creating audience list at various times of day trying to guess
     * when an additional day's data is ready.
     * This method is introduced at alpha stability with the intention of
     * gathering feedback on syntax and capabilities before entering beta. To give
     * your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    default void createRecurringAudienceList(
        com.google.analytics.data.v1alpha.CreateRecurringAudienceListRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.RecurringAudienceList>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateRecurringAudienceListMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets configuration metadata about a specific recurring audience list. This
     * method can be used to understand a recurring audience list's state after it
     * has been created. For example, a recurring audience list resource will
     * generate audience list instances for each day, and this method can be used
     * to get the resource name of the most recent audience list instance.
     * This method is introduced at alpha stability with the intention of
     * gathering feedback on syntax and capabilities before entering beta. To give
     * your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    default void getRecurringAudienceList(
        com.google.analytics.data.v1alpha.GetRecurringAudienceListRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.RecurringAudienceList>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetRecurringAudienceListMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all recurring audience lists for a property. This method can be used
     * for you to find and reuse existing recurring audience lists rather than
     * creating unnecessary new recurring audience lists. The same audience can
     * have multiple recurring audience lists that represent different dimension
     * combinations; for example, just the dimension `deviceId` or both the
     * dimensions `deviceId` and `userId`.
     * This method is introduced at alpha stability with the intention of
     * gathering feedback on syntax and capabilities before entering beta. To give
     * your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    default void listRecurringAudienceLists(
        com.google.analytics.data.v1alpha.ListRecurringAudienceListsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.data.v1alpha.ListRecurringAudienceListsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRecurringAudienceListsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Initiates the creation of a report task. This method quickly
     * returns a report task and initiates a long running
     * asynchronous request to form a customized report of your Google Analytics
     * event data.
     * </pre>
     */
    default void createReportTask(
        com.google.analytics.data.v1alpha.CreateReportTaskRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateReportTaskMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a report task's content. After requesting the `CreateReportTask`,
     * you are able to retrieve the report content once the report is
     * ACTIVE. This method will return an error if the report task's state is not
     * `ACTIVE`. A query response will return the tabular row &amp; column values of
     * the report.
     * </pre>
     */
    default void queryReportTask(
        com.google.analytics.data.v1alpha.QueryReportTaskRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.QueryReportTaskResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getQueryReportTaskMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets report metadata about a specific report task. After creating a report
     * task, use this method to check its processing state or inspect its
     * report definition.
     * </pre>
     */
    default void getReportTask(
        com.google.analytics.data.v1alpha.GetReportTaskRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.ReportTask>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetReportTaskMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all report tasks for a property.
     * </pre>
     */
    default void listReportTasks(
        com.google.analytics.data.v1alpha.ListReportTasksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.ListReportTasksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListReportTasksMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AlphaAnalyticsData.
   *
   * <pre>
   * Google Analytics reporting data service.
   * </pre>
   */
  public abstract static class AlphaAnalyticsDataImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AlphaAnalyticsDataGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AlphaAnalyticsData.
   *
   * <pre>
   * Google Analytics reporting data service.
   * </pre>
   */
  public static final class AlphaAnalyticsDataStub
      extends io.grpc.stub.AbstractAsyncStub<AlphaAnalyticsDataStub> {
    private AlphaAnalyticsDataStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlphaAnalyticsDataStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AlphaAnalyticsDataStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns a customized funnel report of your Google Analytics event data. The
     * data returned from the API is as a table with columns for the requested
     * dimensions and metrics.
     * Funnel exploration lets you visualize the steps your users take to complete
     * a task and quickly see how well they are succeeding or failing at each
     * step. For example, how do prospects become shoppers and then become buyers?
     * How do one time buyers become repeat buyers? With this information, you can
     * improve inefficient or abandoned customer journeys. To learn more, see [GA4
     * Funnel Explorations](https://support.google.com/analytics/answer/9327974).
     * This method is introduced at alpha stability with the intention of
     * gathering feedback on syntax and capabilities before entering beta. To give
     * your feedback on this API, complete the [Google Analytics Data API Funnel
     * Reporting
     * Feedback](https://docs.google.com/forms/d/e/1FAIpQLSdwOlQDJAUoBiIgUZZ3S_Lwi8gr7Bb0k1jhvc-DEg7Rol3UjA/viewform).
     * </pre>
     */
    public void runFunnelReport(
        com.google.analytics.data.v1alpha.RunFunnelReportRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.RunFunnelReportResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRunFunnelReportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an audience list for later retrieval. This method quickly returns
     * the audience list's resource name and initiates a long running asynchronous
     * request to form an audience list. To list the users in an audience list,
     * first create the audience list through this method and then send the
     * audience resource name to the `QueryAudienceList` method.
     * See [Creating an Audience
     * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Lists with examples.
     * An audience list is a snapshot of the users currently in the audience at
     * the time of audience list creation. Creating audience lists for one
     * audience on different days will return different results as users enter and
     * exit the audience.
     * Audiences in Google Analytics 4 allow you to segment your users in the ways
     * that are important to your business. To learn more, see
     * https://support.google.com/analytics/answer/9267572. Audience lists contain
     * the users in each audience.
     * This method is available at beta stability at
     * [audienceExports.create](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/create).
     * To give your feedback on this API, complete the [Google Analytics Audience
     * Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public void createAudienceList(
        com.google.analytics.data.v1alpha.CreateAudienceListRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAudienceListMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an audience list of users. After creating an audience, the users
     * are not immediately available for listing. First, a request to
     * `CreateAudienceList` is necessary to create an audience list of users, and
     * then second, this method is used to retrieve the users in the audience
     * list.
     * See [Creating an Audience
     * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Lists with examples.
     * Audiences in Google Analytics 4 allow you to segment your users in the ways
     * that are important to your business. To learn more, see
     * https://support.google.com/analytics/answer/9267572.
     * This method is available at beta stability at
     * [audienceExports.query](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/query).
     * To give your feedback on this API, complete the [Google Analytics Audience
     * Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public void queryAudienceList(
        com.google.analytics.data.v1alpha.QueryAudienceListRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.QueryAudienceListResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQueryAudienceListMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports an audience list of users to a Google Sheet. After creating an
     * audience, the users are not immediately available for listing. First, a
     * request to `CreateAudienceList` is necessary to create an audience list of
     * users, and then second, this method is used to export those users in the
     * audience list to a Google Sheet.
     * See [Creating an Audience
     * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Lists with examples.
     * Audiences in Google Analytics 4 allow you to segment your users in the ways
     * that are important to your business. To learn more, see
     * https://support.google.com/analytics/answer/9267572.
     * This method is introduced at alpha stability with the intention of
     * gathering feedback on syntax and capabilities before entering beta. To give
     * your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public void sheetExportAudienceList(
        com.google.analytics.data.v1alpha.SheetExportAudienceListRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.data.v1alpha.SheetExportAudienceListResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSheetExportAudienceListMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets configuration metadata about a specific audience list. This method
     * can be used to understand an audience list after it has been created.
     * See [Creating an Audience
     * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Lists with examples.
     * This method is available at beta stability at
     * [audienceExports.get](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/get).
     * To give your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public void getAudienceList(
        com.google.analytics.data.v1alpha.GetAudienceListRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.AudienceList>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAudienceListMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all audience lists for a property. This method can be used for you to
     * find and reuse existing audience lists rather than creating unnecessary new
     * audience lists. The same audience can have multiple audience lists that
     * represent the list of users that were in an audience on different days.
     * See [Creating an Audience
     * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Lists with examples.
     * This method is available at beta stability at
     * [audienceExports.list](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/list).
     * To give your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public void listAudienceLists(
        com.google.analytics.data.v1alpha.ListAudienceListsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.ListAudienceListsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAudienceListsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a recurring audience list. Recurring audience lists produces new
     * audience lists each day. Audience lists are users in an audience at the
     * time of the list's creation.
     * A recurring audience list ensures that you have audience list based on the
     * most recent data available for use each day. If you manually create
     * audience list, you don't know when an audience list based on an additional
     * day's data is available. This recurring audience list automates the
     * creation of an audience list when an additional day's data is available.
     * You will consume fewer quota tokens by using recurring audience list versus
     * manually creating audience list at various times of day trying to guess
     * when an additional day's data is ready.
     * This method is introduced at alpha stability with the intention of
     * gathering feedback on syntax and capabilities before entering beta. To give
     * your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public void createRecurringAudienceList(
        com.google.analytics.data.v1alpha.CreateRecurringAudienceListRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.RecurringAudienceList>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRecurringAudienceListMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets configuration metadata about a specific recurring audience list. This
     * method can be used to understand a recurring audience list's state after it
     * has been created. For example, a recurring audience list resource will
     * generate audience list instances for each day, and this method can be used
     * to get the resource name of the most recent audience list instance.
     * This method is introduced at alpha stability with the intention of
     * gathering feedback on syntax and capabilities before entering beta. To give
     * your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public void getRecurringAudienceList(
        com.google.analytics.data.v1alpha.GetRecurringAudienceListRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.RecurringAudienceList>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRecurringAudienceListMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all recurring audience lists for a property. This method can be used
     * for you to find and reuse existing recurring audience lists rather than
     * creating unnecessary new recurring audience lists. The same audience can
     * have multiple recurring audience lists that represent different dimension
     * combinations; for example, just the dimension `deviceId` or both the
     * dimensions `deviceId` and `userId`.
     * This method is introduced at alpha stability with the intention of
     * gathering feedback on syntax and capabilities before entering beta. To give
     * your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public void listRecurringAudienceLists(
        com.google.analytics.data.v1alpha.ListRecurringAudienceListsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.data.v1alpha.ListRecurringAudienceListsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRecurringAudienceListsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Initiates the creation of a report task. This method quickly
     * returns a report task and initiates a long running
     * asynchronous request to form a customized report of your Google Analytics
     * event data.
     * </pre>
     */
    public void createReportTask(
        com.google.analytics.data.v1alpha.CreateReportTaskRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateReportTaskMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a report task's content. After requesting the `CreateReportTask`,
     * you are able to retrieve the report content once the report is
     * ACTIVE. This method will return an error if the report task's state is not
     * `ACTIVE`. A query response will return the tabular row &amp; column values of
     * the report.
     * </pre>
     */
    public void queryReportTask(
        com.google.analytics.data.v1alpha.QueryReportTaskRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.QueryReportTaskResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQueryReportTaskMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets report metadata about a specific report task. After creating a report
     * task, use this method to check its processing state or inspect its
     * report definition.
     * </pre>
     */
    public void getReportTask(
        com.google.analytics.data.v1alpha.GetReportTaskRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.ReportTask>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetReportTaskMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all report tasks for a property.
     * </pre>
     */
    public void listReportTasks(
        com.google.analytics.data.v1alpha.ListReportTasksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.ListReportTasksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListReportTasksMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AlphaAnalyticsData.
   *
   * <pre>
   * Google Analytics reporting data service.
   * </pre>
   */
  public static final class AlphaAnalyticsDataBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AlphaAnalyticsDataBlockingStub> {
    private AlphaAnalyticsDataBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlphaAnalyticsDataBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AlphaAnalyticsDataBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns a customized funnel report of your Google Analytics event data. The
     * data returned from the API is as a table with columns for the requested
     * dimensions and metrics.
     * Funnel exploration lets you visualize the steps your users take to complete
     * a task and quickly see how well they are succeeding or failing at each
     * step. For example, how do prospects become shoppers and then become buyers?
     * How do one time buyers become repeat buyers? With this information, you can
     * improve inefficient or abandoned customer journeys. To learn more, see [GA4
     * Funnel Explorations](https://support.google.com/analytics/answer/9327974).
     * This method is introduced at alpha stability with the intention of
     * gathering feedback on syntax and capabilities before entering beta. To give
     * your feedback on this API, complete the [Google Analytics Data API Funnel
     * Reporting
     * Feedback](https://docs.google.com/forms/d/e/1FAIpQLSdwOlQDJAUoBiIgUZZ3S_Lwi8gr7Bb0k1jhvc-DEg7Rol3UjA/viewform).
     * </pre>
     */
    public com.google.analytics.data.v1alpha.RunFunnelReportResponse runFunnelReport(
        com.google.analytics.data.v1alpha.RunFunnelReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRunFunnelReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an audience list for later retrieval. This method quickly returns
     * the audience list's resource name and initiates a long running asynchronous
     * request to form an audience list. To list the users in an audience list,
     * first create the audience list through this method and then send the
     * audience resource name to the `QueryAudienceList` method.
     * See [Creating an Audience
     * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Lists with examples.
     * An audience list is a snapshot of the users currently in the audience at
     * the time of audience list creation. Creating audience lists for one
     * audience on different days will return different results as users enter and
     * exit the audience.
     * Audiences in Google Analytics 4 allow you to segment your users in the ways
     * that are important to your business. To learn more, see
     * https://support.google.com/analytics/answer/9267572. Audience lists contain
     * the users in each audience.
     * This method is available at beta stability at
     * [audienceExports.create](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/create).
     * To give your feedback on this API, complete the [Google Analytics Audience
     * Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public com.google.longrunning.Operation createAudienceList(
        com.google.analytics.data.v1alpha.CreateAudienceListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAudienceListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an audience list of users. After creating an audience, the users
     * are not immediately available for listing. First, a request to
     * `CreateAudienceList` is necessary to create an audience list of users, and
     * then second, this method is used to retrieve the users in the audience
     * list.
     * See [Creating an Audience
     * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Lists with examples.
     * Audiences in Google Analytics 4 allow you to segment your users in the ways
     * that are important to your business. To learn more, see
     * https://support.google.com/analytics/answer/9267572.
     * This method is available at beta stability at
     * [audienceExports.query](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/query).
     * To give your feedback on this API, complete the [Google Analytics Audience
     * Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public com.google.analytics.data.v1alpha.QueryAudienceListResponse queryAudienceList(
        com.google.analytics.data.v1alpha.QueryAudienceListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryAudienceListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports an audience list of users to a Google Sheet. After creating an
     * audience, the users are not immediately available for listing. First, a
     * request to `CreateAudienceList` is necessary to create an audience list of
     * users, and then second, this method is used to export those users in the
     * audience list to a Google Sheet.
     * See [Creating an Audience
     * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Lists with examples.
     * Audiences in Google Analytics 4 allow you to segment your users in the ways
     * that are important to your business. To learn more, see
     * https://support.google.com/analytics/answer/9267572.
     * This method is introduced at alpha stability with the intention of
     * gathering feedback on syntax and capabilities before entering beta. To give
     * your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public com.google.analytics.data.v1alpha.SheetExportAudienceListResponse
        sheetExportAudienceList(
            com.google.analytics.data.v1alpha.SheetExportAudienceListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSheetExportAudienceListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets configuration metadata about a specific audience list. This method
     * can be used to understand an audience list after it has been created.
     * See [Creating an Audience
     * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Lists with examples.
     * This method is available at beta stability at
     * [audienceExports.get](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/get).
     * To give your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public com.google.analytics.data.v1alpha.AudienceList getAudienceList(
        com.google.analytics.data.v1alpha.GetAudienceListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAudienceListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all audience lists for a property. This method can be used for you to
     * find and reuse existing audience lists rather than creating unnecessary new
     * audience lists. The same audience can have multiple audience lists that
     * represent the list of users that were in an audience on different days.
     * See [Creating an Audience
     * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Lists with examples.
     * This method is available at beta stability at
     * [audienceExports.list](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/list).
     * To give your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public com.google.analytics.data.v1alpha.ListAudienceListsResponse listAudienceLists(
        com.google.analytics.data.v1alpha.ListAudienceListsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAudienceListsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a recurring audience list. Recurring audience lists produces new
     * audience lists each day. Audience lists are users in an audience at the
     * time of the list's creation.
     * A recurring audience list ensures that you have audience list based on the
     * most recent data available for use each day. If you manually create
     * audience list, you don't know when an audience list based on an additional
     * day's data is available. This recurring audience list automates the
     * creation of an audience list when an additional day's data is available.
     * You will consume fewer quota tokens by using recurring audience list versus
     * manually creating audience list at various times of day trying to guess
     * when an additional day's data is ready.
     * This method is introduced at alpha stability with the intention of
     * gathering feedback on syntax and capabilities before entering beta. To give
     * your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public com.google.analytics.data.v1alpha.RecurringAudienceList createRecurringAudienceList(
        com.google.analytics.data.v1alpha.CreateRecurringAudienceListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRecurringAudienceListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets configuration metadata about a specific recurring audience list. This
     * method can be used to understand a recurring audience list's state after it
     * has been created. For example, a recurring audience list resource will
     * generate audience list instances for each day, and this method can be used
     * to get the resource name of the most recent audience list instance.
     * This method is introduced at alpha stability with the intention of
     * gathering feedback on syntax and capabilities before entering beta. To give
     * your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public com.google.analytics.data.v1alpha.RecurringAudienceList getRecurringAudienceList(
        com.google.analytics.data.v1alpha.GetRecurringAudienceListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRecurringAudienceListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all recurring audience lists for a property. This method can be used
     * for you to find and reuse existing recurring audience lists rather than
     * creating unnecessary new recurring audience lists. The same audience can
     * have multiple recurring audience lists that represent different dimension
     * combinations; for example, just the dimension `deviceId` or both the
     * dimensions `deviceId` and `userId`.
     * This method is introduced at alpha stability with the intention of
     * gathering feedback on syntax and capabilities before entering beta. To give
     * your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public com.google.analytics.data.v1alpha.ListRecurringAudienceListsResponse
        listRecurringAudienceLists(
            com.google.analytics.data.v1alpha.ListRecurringAudienceListsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRecurringAudienceListsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates the creation of a report task. This method quickly
     * returns a report task and initiates a long running
     * asynchronous request to form a customized report of your Google Analytics
     * event data.
     * </pre>
     */
    public com.google.longrunning.Operation createReportTask(
        com.google.analytics.data.v1alpha.CreateReportTaskRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateReportTaskMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a report task's content. After requesting the `CreateReportTask`,
     * you are able to retrieve the report content once the report is
     * ACTIVE. This method will return an error if the report task's state is not
     * `ACTIVE`. A query response will return the tabular row &amp; column values of
     * the report.
     * </pre>
     */
    public com.google.analytics.data.v1alpha.QueryReportTaskResponse queryReportTask(
        com.google.analytics.data.v1alpha.QueryReportTaskRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryReportTaskMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets report metadata about a specific report task. After creating a report
     * task, use this method to check its processing state or inspect its
     * report definition.
     * </pre>
     */
    public com.google.analytics.data.v1alpha.ReportTask getReportTask(
        com.google.analytics.data.v1alpha.GetReportTaskRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetReportTaskMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all report tasks for a property.
     * </pre>
     */
    public com.google.analytics.data.v1alpha.ListReportTasksResponse listReportTasks(
        com.google.analytics.data.v1alpha.ListReportTasksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListReportTasksMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AlphaAnalyticsData.
   *
   * <pre>
   * Google Analytics reporting data service.
   * </pre>
   */
  public static final class AlphaAnalyticsDataFutureStub
      extends io.grpc.stub.AbstractFutureStub<AlphaAnalyticsDataFutureStub> {
    private AlphaAnalyticsDataFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlphaAnalyticsDataFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AlphaAnalyticsDataFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns a customized funnel report of your Google Analytics event data. The
     * data returned from the API is as a table with columns for the requested
     * dimensions and metrics.
     * Funnel exploration lets you visualize the steps your users take to complete
     * a task and quickly see how well they are succeeding or failing at each
     * step. For example, how do prospects become shoppers and then become buyers?
     * How do one time buyers become repeat buyers? With this information, you can
     * improve inefficient or abandoned customer journeys. To learn more, see [GA4
     * Funnel Explorations](https://support.google.com/analytics/answer/9327974).
     * This method is introduced at alpha stability with the intention of
     * gathering feedback on syntax and capabilities before entering beta. To give
     * your feedback on this API, complete the [Google Analytics Data API Funnel
     * Reporting
     * Feedback](https://docs.google.com/forms/d/e/1FAIpQLSdwOlQDJAUoBiIgUZZ3S_Lwi8gr7Bb0k1jhvc-DEg7Rol3UjA/viewform).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.data.v1alpha.RunFunnelReportResponse>
        runFunnelReport(com.google.analytics.data.v1alpha.RunFunnelReportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRunFunnelReportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an audience list for later retrieval. This method quickly returns
     * the audience list's resource name and initiates a long running asynchronous
     * request to form an audience list. To list the users in an audience list,
     * first create the audience list through this method and then send the
     * audience resource name to the `QueryAudienceList` method.
     * See [Creating an Audience
     * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Lists with examples.
     * An audience list is a snapshot of the users currently in the audience at
     * the time of audience list creation. Creating audience lists for one
     * audience on different days will return different results as users enter and
     * exit the audience.
     * Audiences in Google Analytics 4 allow you to segment your users in the ways
     * that are important to your business. To learn more, see
     * https://support.google.com/analytics/answer/9267572. Audience lists contain
     * the users in each audience.
     * This method is available at beta stability at
     * [audienceExports.create](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/create).
     * To give your feedback on this API, complete the [Google Analytics Audience
     * Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createAudienceList(com.google.analytics.data.v1alpha.CreateAudienceListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAudienceListMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an audience list of users. After creating an audience, the users
     * are not immediately available for listing. First, a request to
     * `CreateAudienceList` is necessary to create an audience list of users, and
     * then second, this method is used to retrieve the users in the audience
     * list.
     * See [Creating an Audience
     * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Lists with examples.
     * Audiences in Google Analytics 4 allow you to segment your users in the ways
     * that are important to your business. To learn more, see
     * https://support.google.com/analytics/answer/9267572.
     * This method is available at beta stability at
     * [audienceExports.query](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/query).
     * To give your feedback on this API, complete the [Google Analytics Audience
     * Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.data.v1alpha.QueryAudienceListResponse>
        queryAudienceList(com.google.analytics.data.v1alpha.QueryAudienceListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQueryAudienceListMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Exports an audience list of users to a Google Sheet. After creating an
     * audience, the users are not immediately available for listing. First, a
     * request to `CreateAudienceList` is necessary to create an audience list of
     * users, and then second, this method is used to export those users in the
     * audience list to a Google Sheet.
     * See [Creating an Audience
     * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Lists with examples.
     * Audiences in Google Analytics 4 allow you to segment your users in the ways
     * that are important to your business. To learn more, see
     * https://support.google.com/analytics/answer/9267572.
     * This method is introduced at alpha stability with the intention of
     * gathering feedback on syntax and capabilities before entering beta. To give
     * your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.data.v1alpha.SheetExportAudienceListResponse>
        sheetExportAudienceList(
            com.google.analytics.data.v1alpha.SheetExportAudienceListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSheetExportAudienceListMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets configuration metadata about a specific audience list. This method
     * can be used to understand an audience list after it has been created.
     * See [Creating an Audience
     * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Lists with examples.
     * This method is available at beta stability at
     * [audienceExports.get](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/get).
     * To give your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.data.v1alpha.AudienceList>
        getAudienceList(com.google.analytics.data.v1alpha.GetAudienceListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAudienceListMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all audience lists for a property. This method can be used for you to
     * find and reuse existing audience lists rather than creating unnecessary new
     * audience lists. The same audience can have multiple audience lists that
     * represent the list of users that were in an audience on different days.
     * See [Creating an Audience
     * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Lists with examples.
     * This method is available at beta stability at
     * [audienceExports.list](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/list).
     * To give your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.data.v1alpha.ListAudienceListsResponse>
        listAudienceLists(com.google.analytics.data.v1alpha.ListAudienceListsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAudienceListsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a recurring audience list. Recurring audience lists produces new
     * audience lists each day. Audience lists are users in an audience at the
     * time of the list's creation.
     * A recurring audience list ensures that you have audience list based on the
     * most recent data available for use each day. If you manually create
     * audience list, you don't know when an audience list based on an additional
     * day's data is available. This recurring audience list automates the
     * creation of an audience list when an additional day's data is available.
     * You will consume fewer quota tokens by using recurring audience list versus
     * manually creating audience list at various times of day trying to guess
     * when an additional day's data is ready.
     * This method is introduced at alpha stability with the intention of
     * gathering feedback on syntax and capabilities before entering beta. To give
     * your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.data.v1alpha.RecurringAudienceList>
        createRecurringAudienceList(
            com.google.analytics.data.v1alpha.CreateRecurringAudienceListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRecurringAudienceListMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets configuration metadata about a specific recurring audience list. This
     * method can be used to understand a recurring audience list's state after it
     * has been created. For example, a recurring audience list resource will
     * generate audience list instances for each day, and this method can be used
     * to get the resource name of the most recent audience list instance.
     * This method is introduced at alpha stability with the intention of
     * gathering feedback on syntax and capabilities before entering beta. To give
     * your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.data.v1alpha.RecurringAudienceList>
        getRecurringAudienceList(
            com.google.analytics.data.v1alpha.GetRecurringAudienceListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRecurringAudienceListMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all recurring audience lists for a property. This method can be used
     * for you to find and reuse existing recurring audience lists rather than
     * creating unnecessary new recurring audience lists. The same audience can
     * have multiple recurring audience lists that represent different dimension
     * combinations; for example, just the dimension `deviceId` or both the
     * dimensions `deviceId` and `userId`.
     * This method is introduced at alpha stability with the intention of
     * gathering feedback on syntax and capabilities before entering beta. To give
     * your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.data.v1alpha.ListRecurringAudienceListsResponse>
        listRecurringAudienceLists(
            com.google.analytics.data.v1alpha.ListRecurringAudienceListsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRecurringAudienceListsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates the creation of a report task. This method quickly
     * returns a report task and initiates a long running
     * asynchronous request to form a customized report of your Google Analytics
     * event data.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createReportTask(com.google.analytics.data.v1alpha.CreateReportTaskRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateReportTaskMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a report task's content. After requesting the `CreateReportTask`,
     * you are able to retrieve the report content once the report is
     * ACTIVE. This method will return an error if the report task's state is not
     * `ACTIVE`. A query response will return the tabular row &amp; column values of
     * the report.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.data.v1alpha.QueryReportTaskResponse>
        queryReportTask(com.google.analytics.data.v1alpha.QueryReportTaskRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQueryReportTaskMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets report metadata about a specific report task. After creating a report
     * task, use this method to check its processing state or inspect its
     * report definition.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.data.v1alpha.ReportTask>
        getReportTask(com.google.analytics.data.v1alpha.GetReportTaskRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetReportTaskMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all report tasks for a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.data.v1alpha.ListReportTasksResponse>
        listReportTasks(com.google.analytics.data.v1alpha.ListReportTasksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListReportTasksMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RUN_FUNNEL_REPORT = 0;
  private static final int METHODID_CREATE_AUDIENCE_LIST = 1;
  private static final int METHODID_QUERY_AUDIENCE_LIST = 2;
  private static final int METHODID_SHEET_EXPORT_AUDIENCE_LIST = 3;
  private static final int METHODID_GET_AUDIENCE_LIST = 4;
  private static final int METHODID_LIST_AUDIENCE_LISTS = 5;
  private static final int METHODID_CREATE_RECURRING_AUDIENCE_LIST = 6;
  private static final int METHODID_GET_RECURRING_AUDIENCE_LIST = 7;
  private static final int METHODID_LIST_RECURRING_AUDIENCE_LISTS = 8;
  private static final int METHODID_CREATE_REPORT_TASK = 9;
  private static final int METHODID_QUERY_REPORT_TASK = 10;
  private static final int METHODID_GET_REPORT_TASK = 11;
  private static final int METHODID_LIST_REPORT_TASKS = 12;

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
        case METHODID_RUN_FUNNEL_REPORT:
          serviceImpl.runFunnelReport(
              (com.google.analytics.data.v1alpha.RunFunnelReportRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.data.v1alpha.RunFunnelReportResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_AUDIENCE_LIST:
          serviceImpl.createAudienceList(
              (com.google.analytics.data.v1alpha.CreateAudienceListRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_QUERY_AUDIENCE_LIST:
          serviceImpl.queryAudienceList(
              (com.google.analytics.data.v1alpha.QueryAudienceListRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.data.v1alpha.QueryAudienceListResponse>)
                  responseObserver);
          break;
        case METHODID_SHEET_EXPORT_AUDIENCE_LIST:
          serviceImpl.sheetExportAudienceList(
              (com.google.analytics.data.v1alpha.SheetExportAudienceListRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.data.v1alpha.SheetExportAudienceListResponse>)
                  responseObserver);
          break;
        case METHODID_GET_AUDIENCE_LIST:
          serviceImpl.getAudienceList(
              (com.google.analytics.data.v1alpha.GetAudienceListRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.AudienceList>)
                  responseObserver);
          break;
        case METHODID_LIST_AUDIENCE_LISTS:
          serviceImpl.listAudienceLists(
              (com.google.analytics.data.v1alpha.ListAudienceListsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.data.v1alpha.ListAudienceListsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_RECURRING_AUDIENCE_LIST:
          serviceImpl.createRecurringAudienceList(
              (com.google.analytics.data.v1alpha.CreateRecurringAudienceListRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.RecurringAudienceList>)
                  responseObserver);
          break;
        case METHODID_GET_RECURRING_AUDIENCE_LIST:
          serviceImpl.getRecurringAudienceList(
              (com.google.analytics.data.v1alpha.GetRecurringAudienceListRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.RecurringAudienceList>)
                  responseObserver);
          break;
        case METHODID_LIST_RECURRING_AUDIENCE_LISTS:
          serviceImpl.listRecurringAudienceLists(
              (com.google.analytics.data.v1alpha.ListRecurringAudienceListsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.data.v1alpha.ListRecurringAudienceListsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_REPORT_TASK:
          serviceImpl.createReportTask(
              (com.google.analytics.data.v1alpha.CreateReportTaskRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_QUERY_REPORT_TASK:
          serviceImpl.queryReportTask(
              (com.google.analytics.data.v1alpha.QueryReportTaskRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.data.v1alpha.QueryReportTaskResponse>)
                  responseObserver);
          break;
        case METHODID_GET_REPORT_TASK:
          serviceImpl.getReportTask(
              (com.google.analytics.data.v1alpha.GetReportTaskRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.ReportTask>)
                  responseObserver);
          break;
        case METHODID_LIST_REPORT_TASKS:
          serviceImpl.listReportTasks(
              (com.google.analytics.data.v1alpha.ListReportTasksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.data.v1alpha.ListReportTasksResponse>)
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
            getRunFunnelReportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.data.v1alpha.RunFunnelReportRequest,
                    com.google.analytics.data.v1alpha.RunFunnelReportResponse>(
                    service, METHODID_RUN_FUNNEL_REPORT)))
        .addMethod(
            getCreateAudienceListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.data.v1alpha.CreateAudienceListRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_AUDIENCE_LIST)))
        .addMethod(
            getQueryAudienceListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.data.v1alpha.QueryAudienceListRequest,
                    com.google.analytics.data.v1alpha.QueryAudienceListResponse>(
                    service, METHODID_QUERY_AUDIENCE_LIST)))
        .addMethod(
            getSheetExportAudienceListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.data.v1alpha.SheetExportAudienceListRequest,
                    com.google.analytics.data.v1alpha.SheetExportAudienceListResponse>(
                    service, METHODID_SHEET_EXPORT_AUDIENCE_LIST)))
        .addMethod(
            getGetAudienceListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.data.v1alpha.GetAudienceListRequest,
                    com.google.analytics.data.v1alpha.AudienceList>(
                    service, METHODID_GET_AUDIENCE_LIST)))
        .addMethod(
            getListAudienceListsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.data.v1alpha.ListAudienceListsRequest,
                    com.google.analytics.data.v1alpha.ListAudienceListsResponse>(
                    service, METHODID_LIST_AUDIENCE_LISTS)))
        .addMethod(
            getCreateRecurringAudienceListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.data.v1alpha.CreateRecurringAudienceListRequest,
                    com.google.analytics.data.v1alpha.RecurringAudienceList>(
                    service, METHODID_CREATE_RECURRING_AUDIENCE_LIST)))
        .addMethod(
            getGetRecurringAudienceListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.data.v1alpha.GetRecurringAudienceListRequest,
                    com.google.analytics.data.v1alpha.RecurringAudienceList>(
                    service, METHODID_GET_RECURRING_AUDIENCE_LIST)))
        .addMethod(
            getListRecurringAudienceListsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.data.v1alpha.ListRecurringAudienceListsRequest,
                    com.google.analytics.data.v1alpha.ListRecurringAudienceListsResponse>(
                    service, METHODID_LIST_RECURRING_AUDIENCE_LISTS)))
        .addMethod(
            getCreateReportTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.data.v1alpha.CreateReportTaskRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_REPORT_TASK)))
        .addMethod(
            getQueryReportTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.data.v1alpha.QueryReportTaskRequest,
                    com.google.analytics.data.v1alpha.QueryReportTaskResponse>(
                    service, METHODID_QUERY_REPORT_TASK)))
        .addMethod(
            getGetReportTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.data.v1alpha.GetReportTaskRequest,
                    com.google.analytics.data.v1alpha.ReportTask>(
                    service, METHODID_GET_REPORT_TASK)))
        .addMethod(
            getListReportTasksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.data.v1alpha.ListReportTasksRequest,
                    com.google.analytics.data.v1alpha.ListReportTasksResponse>(
                    service, METHODID_LIST_REPORT_TASKS)))
        .build();
  }

  private abstract static class AlphaAnalyticsDataBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AlphaAnalyticsDataBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.analytics.data.v1alpha.AnalyticsDataApiProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AlphaAnalyticsData");
    }
  }

  private static final class AlphaAnalyticsDataFileDescriptorSupplier
      extends AlphaAnalyticsDataBaseDescriptorSupplier {
    AlphaAnalyticsDataFileDescriptorSupplier() {}
  }

  private static final class AlphaAnalyticsDataMethodDescriptorSupplier
      extends AlphaAnalyticsDataBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AlphaAnalyticsDataMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AlphaAnalyticsDataGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AlphaAnalyticsDataFileDescriptorSupplier())
                      .addMethod(getRunFunnelReportMethod())
                      .addMethod(getCreateAudienceListMethod())
                      .addMethod(getQueryAudienceListMethod())
                      .addMethod(getSheetExportAudienceListMethod())
                      .addMethod(getGetAudienceListMethod())
                      .addMethod(getListAudienceListsMethod())
                      .addMethod(getCreateRecurringAudienceListMethod())
                      .addMethod(getGetRecurringAudienceListMethod())
                      .addMethod(getListRecurringAudienceListsMethod())
                      .addMethod(getCreateReportTaskMethod())
                      .addMethod(getQueryReportTaskMethod())
                      .addMethod(getGetReportTaskMethod())
                      .addMethod(getListReportTasksMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
