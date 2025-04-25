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
package com.google.analytics.data.v1beta;

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
    comments = "Source: google/analytics/data/v1beta/analytics_data_api.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BetaAnalyticsDataGrpc {

  private BetaAnalyticsDataGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.analytics.data.v1beta.BetaAnalyticsData";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.data.v1beta.RunReportRequest,
          com.google.analytics.data.v1beta.RunReportResponse>
      getRunReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RunReport",
      requestType = com.google.analytics.data.v1beta.RunReportRequest.class,
      responseType = com.google.analytics.data.v1beta.RunReportResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.data.v1beta.RunReportRequest,
          com.google.analytics.data.v1beta.RunReportResponse>
      getRunReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.data.v1beta.RunReportRequest,
            com.google.analytics.data.v1beta.RunReportResponse>
        getRunReportMethod;
    if ((getRunReportMethod = BetaAnalyticsDataGrpc.getRunReportMethod) == null) {
      synchronized (BetaAnalyticsDataGrpc.class) {
        if ((getRunReportMethod = BetaAnalyticsDataGrpc.getRunReportMethod) == null) {
          BetaAnalyticsDataGrpc.getRunReportMethod =
              getRunReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.data.v1beta.RunReportRequest,
                          com.google.analytics.data.v1beta.RunReportResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RunReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1beta.RunReportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1beta.RunReportResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BetaAnalyticsDataMethodDescriptorSupplier("RunReport"))
                      .build();
        }
      }
    }
    return getRunReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.data.v1beta.RunPivotReportRequest,
          com.google.analytics.data.v1beta.RunPivotReportResponse>
      getRunPivotReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RunPivotReport",
      requestType = com.google.analytics.data.v1beta.RunPivotReportRequest.class,
      responseType = com.google.analytics.data.v1beta.RunPivotReportResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.data.v1beta.RunPivotReportRequest,
          com.google.analytics.data.v1beta.RunPivotReportResponse>
      getRunPivotReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.data.v1beta.RunPivotReportRequest,
            com.google.analytics.data.v1beta.RunPivotReportResponse>
        getRunPivotReportMethod;
    if ((getRunPivotReportMethod = BetaAnalyticsDataGrpc.getRunPivotReportMethod) == null) {
      synchronized (BetaAnalyticsDataGrpc.class) {
        if ((getRunPivotReportMethod = BetaAnalyticsDataGrpc.getRunPivotReportMethod) == null) {
          BetaAnalyticsDataGrpc.getRunPivotReportMethod =
              getRunPivotReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.data.v1beta.RunPivotReportRequest,
                          com.google.analytics.data.v1beta.RunPivotReportResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RunPivotReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1beta.RunPivotReportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1beta.RunPivotReportResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BetaAnalyticsDataMethodDescriptorSupplier("RunPivotReport"))
                      .build();
        }
      }
    }
    return getRunPivotReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.data.v1beta.BatchRunReportsRequest,
          com.google.analytics.data.v1beta.BatchRunReportsResponse>
      getBatchRunReportsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchRunReports",
      requestType = com.google.analytics.data.v1beta.BatchRunReportsRequest.class,
      responseType = com.google.analytics.data.v1beta.BatchRunReportsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.data.v1beta.BatchRunReportsRequest,
          com.google.analytics.data.v1beta.BatchRunReportsResponse>
      getBatchRunReportsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.data.v1beta.BatchRunReportsRequest,
            com.google.analytics.data.v1beta.BatchRunReportsResponse>
        getBatchRunReportsMethod;
    if ((getBatchRunReportsMethod = BetaAnalyticsDataGrpc.getBatchRunReportsMethod) == null) {
      synchronized (BetaAnalyticsDataGrpc.class) {
        if ((getBatchRunReportsMethod = BetaAnalyticsDataGrpc.getBatchRunReportsMethod) == null) {
          BetaAnalyticsDataGrpc.getBatchRunReportsMethod =
              getBatchRunReportsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.data.v1beta.BatchRunReportsRequest,
                          com.google.analytics.data.v1beta.BatchRunReportsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchRunReports"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1beta.BatchRunReportsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1beta.BatchRunReportsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BetaAnalyticsDataMethodDescriptorSupplier("BatchRunReports"))
                      .build();
        }
      }
    }
    return getBatchRunReportsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.data.v1beta.BatchRunPivotReportsRequest,
          com.google.analytics.data.v1beta.BatchRunPivotReportsResponse>
      getBatchRunPivotReportsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchRunPivotReports",
      requestType = com.google.analytics.data.v1beta.BatchRunPivotReportsRequest.class,
      responseType = com.google.analytics.data.v1beta.BatchRunPivotReportsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.data.v1beta.BatchRunPivotReportsRequest,
          com.google.analytics.data.v1beta.BatchRunPivotReportsResponse>
      getBatchRunPivotReportsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.data.v1beta.BatchRunPivotReportsRequest,
            com.google.analytics.data.v1beta.BatchRunPivotReportsResponse>
        getBatchRunPivotReportsMethod;
    if ((getBatchRunPivotReportsMethod = BetaAnalyticsDataGrpc.getBatchRunPivotReportsMethod)
        == null) {
      synchronized (BetaAnalyticsDataGrpc.class) {
        if ((getBatchRunPivotReportsMethod = BetaAnalyticsDataGrpc.getBatchRunPivotReportsMethod)
            == null) {
          BetaAnalyticsDataGrpc.getBatchRunPivotReportsMethod =
              getBatchRunPivotReportsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.data.v1beta.BatchRunPivotReportsRequest,
                          com.google.analytics.data.v1beta.BatchRunPivotReportsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchRunPivotReports"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1beta.BatchRunPivotReportsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1beta.BatchRunPivotReportsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BetaAnalyticsDataMethodDescriptorSupplier("BatchRunPivotReports"))
                      .build();
        }
      }
    }
    return getBatchRunPivotReportsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.data.v1beta.GetMetadataRequest,
          com.google.analytics.data.v1beta.Metadata>
      getGetMetadataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMetadata",
      requestType = com.google.analytics.data.v1beta.GetMetadataRequest.class,
      responseType = com.google.analytics.data.v1beta.Metadata.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.data.v1beta.GetMetadataRequest,
          com.google.analytics.data.v1beta.Metadata>
      getGetMetadataMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.data.v1beta.GetMetadataRequest,
            com.google.analytics.data.v1beta.Metadata>
        getGetMetadataMethod;
    if ((getGetMetadataMethod = BetaAnalyticsDataGrpc.getGetMetadataMethod) == null) {
      synchronized (BetaAnalyticsDataGrpc.class) {
        if ((getGetMetadataMethod = BetaAnalyticsDataGrpc.getGetMetadataMethod) == null) {
          BetaAnalyticsDataGrpc.getGetMetadataMethod =
              getGetMetadataMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.data.v1beta.GetMetadataRequest,
                          com.google.analytics.data.v1beta.Metadata>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMetadata"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1beta.GetMetadataRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1beta.Metadata.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BetaAnalyticsDataMethodDescriptorSupplier("GetMetadata"))
                      .build();
        }
      }
    }
    return getGetMetadataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.data.v1beta.RunRealtimeReportRequest,
          com.google.analytics.data.v1beta.RunRealtimeReportResponse>
      getRunRealtimeReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RunRealtimeReport",
      requestType = com.google.analytics.data.v1beta.RunRealtimeReportRequest.class,
      responseType = com.google.analytics.data.v1beta.RunRealtimeReportResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.data.v1beta.RunRealtimeReportRequest,
          com.google.analytics.data.v1beta.RunRealtimeReportResponse>
      getRunRealtimeReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.data.v1beta.RunRealtimeReportRequest,
            com.google.analytics.data.v1beta.RunRealtimeReportResponse>
        getRunRealtimeReportMethod;
    if ((getRunRealtimeReportMethod = BetaAnalyticsDataGrpc.getRunRealtimeReportMethod) == null) {
      synchronized (BetaAnalyticsDataGrpc.class) {
        if ((getRunRealtimeReportMethod = BetaAnalyticsDataGrpc.getRunRealtimeReportMethod)
            == null) {
          BetaAnalyticsDataGrpc.getRunRealtimeReportMethod =
              getRunRealtimeReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.data.v1beta.RunRealtimeReportRequest,
                          com.google.analytics.data.v1beta.RunRealtimeReportResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RunRealtimeReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1beta.RunRealtimeReportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1beta.RunRealtimeReportResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BetaAnalyticsDataMethodDescriptorSupplier("RunRealtimeReport"))
                      .build();
        }
      }
    }
    return getRunRealtimeReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.data.v1beta.CheckCompatibilityRequest,
          com.google.analytics.data.v1beta.CheckCompatibilityResponse>
      getCheckCompatibilityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckCompatibility",
      requestType = com.google.analytics.data.v1beta.CheckCompatibilityRequest.class,
      responseType = com.google.analytics.data.v1beta.CheckCompatibilityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.data.v1beta.CheckCompatibilityRequest,
          com.google.analytics.data.v1beta.CheckCompatibilityResponse>
      getCheckCompatibilityMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.data.v1beta.CheckCompatibilityRequest,
            com.google.analytics.data.v1beta.CheckCompatibilityResponse>
        getCheckCompatibilityMethod;
    if ((getCheckCompatibilityMethod = BetaAnalyticsDataGrpc.getCheckCompatibilityMethod) == null) {
      synchronized (BetaAnalyticsDataGrpc.class) {
        if ((getCheckCompatibilityMethod = BetaAnalyticsDataGrpc.getCheckCompatibilityMethod)
            == null) {
          BetaAnalyticsDataGrpc.getCheckCompatibilityMethod =
              getCheckCompatibilityMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.data.v1beta.CheckCompatibilityRequest,
                          com.google.analytics.data.v1beta.CheckCompatibilityResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CheckCompatibility"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1beta.CheckCompatibilityRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1beta.CheckCompatibilityResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BetaAnalyticsDataMethodDescriptorSupplier("CheckCompatibility"))
                      .build();
        }
      }
    }
    return getCheckCompatibilityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.data.v1beta.CreateAudienceExportRequest,
          com.google.longrunning.Operation>
      getCreateAudienceExportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAudienceExport",
      requestType = com.google.analytics.data.v1beta.CreateAudienceExportRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.data.v1beta.CreateAudienceExportRequest,
          com.google.longrunning.Operation>
      getCreateAudienceExportMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.data.v1beta.CreateAudienceExportRequest,
            com.google.longrunning.Operation>
        getCreateAudienceExportMethod;
    if ((getCreateAudienceExportMethod = BetaAnalyticsDataGrpc.getCreateAudienceExportMethod)
        == null) {
      synchronized (BetaAnalyticsDataGrpc.class) {
        if ((getCreateAudienceExportMethod = BetaAnalyticsDataGrpc.getCreateAudienceExportMethod)
            == null) {
          BetaAnalyticsDataGrpc.getCreateAudienceExportMethod =
              getCreateAudienceExportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.data.v1beta.CreateAudienceExportRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateAudienceExport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1beta.CreateAudienceExportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BetaAnalyticsDataMethodDescriptorSupplier("CreateAudienceExport"))
                      .build();
        }
      }
    }
    return getCreateAudienceExportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.data.v1beta.QueryAudienceExportRequest,
          com.google.analytics.data.v1beta.QueryAudienceExportResponse>
      getQueryAudienceExportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryAudienceExport",
      requestType = com.google.analytics.data.v1beta.QueryAudienceExportRequest.class,
      responseType = com.google.analytics.data.v1beta.QueryAudienceExportResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.data.v1beta.QueryAudienceExportRequest,
          com.google.analytics.data.v1beta.QueryAudienceExportResponse>
      getQueryAudienceExportMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.data.v1beta.QueryAudienceExportRequest,
            com.google.analytics.data.v1beta.QueryAudienceExportResponse>
        getQueryAudienceExportMethod;
    if ((getQueryAudienceExportMethod = BetaAnalyticsDataGrpc.getQueryAudienceExportMethod)
        == null) {
      synchronized (BetaAnalyticsDataGrpc.class) {
        if ((getQueryAudienceExportMethod = BetaAnalyticsDataGrpc.getQueryAudienceExportMethod)
            == null) {
          BetaAnalyticsDataGrpc.getQueryAudienceExportMethod =
              getQueryAudienceExportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.data.v1beta.QueryAudienceExportRequest,
                          com.google.analytics.data.v1beta.QueryAudienceExportResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "QueryAudienceExport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1beta.QueryAudienceExportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1beta.QueryAudienceExportResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BetaAnalyticsDataMethodDescriptorSupplier("QueryAudienceExport"))
                      .build();
        }
      }
    }
    return getQueryAudienceExportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.data.v1beta.GetAudienceExportRequest,
          com.google.analytics.data.v1beta.AudienceExport>
      getGetAudienceExportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAudienceExport",
      requestType = com.google.analytics.data.v1beta.GetAudienceExportRequest.class,
      responseType = com.google.analytics.data.v1beta.AudienceExport.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.data.v1beta.GetAudienceExportRequest,
          com.google.analytics.data.v1beta.AudienceExport>
      getGetAudienceExportMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.data.v1beta.GetAudienceExportRequest,
            com.google.analytics.data.v1beta.AudienceExport>
        getGetAudienceExportMethod;
    if ((getGetAudienceExportMethod = BetaAnalyticsDataGrpc.getGetAudienceExportMethod) == null) {
      synchronized (BetaAnalyticsDataGrpc.class) {
        if ((getGetAudienceExportMethod = BetaAnalyticsDataGrpc.getGetAudienceExportMethod)
            == null) {
          BetaAnalyticsDataGrpc.getGetAudienceExportMethod =
              getGetAudienceExportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.data.v1beta.GetAudienceExportRequest,
                          com.google.analytics.data.v1beta.AudienceExport>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAudienceExport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1beta.GetAudienceExportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1beta.AudienceExport.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BetaAnalyticsDataMethodDescriptorSupplier("GetAudienceExport"))
                      .build();
        }
      }
    }
    return getGetAudienceExportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.data.v1beta.ListAudienceExportsRequest,
          com.google.analytics.data.v1beta.ListAudienceExportsResponse>
      getListAudienceExportsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAudienceExports",
      requestType = com.google.analytics.data.v1beta.ListAudienceExportsRequest.class,
      responseType = com.google.analytics.data.v1beta.ListAudienceExportsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.data.v1beta.ListAudienceExportsRequest,
          com.google.analytics.data.v1beta.ListAudienceExportsResponse>
      getListAudienceExportsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.data.v1beta.ListAudienceExportsRequest,
            com.google.analytics.data.v1beta.ListAudienceExportsResponse>
        getListAudienceExportsMethod;
    if ((getListAudienceExportsMethod = BetaAnalyticsDataGrpc.getListAudienceExportsMethod)
        == null) {
      synchronized (BetaAnalyticsDataGrpc.class) {
        if ((getListAudienceExportsMethod = BetaAnalyticsDataGrpc.getListAudienceExportsMethod)
            == null) {
          BetaAnalyticsDataGrpc.getListAudienceExportsMethod =
              getListAudienceExportsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.data.v1beta.ListAudienceExportsRequest,
                          com.google.analytics.data.v1beta.ListAudienceExportsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAudienceExports"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1beta.ListAudienceExportsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1beta.ListAudienceExportsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BetaAnalyticsDataMethodDescriptorSupplier("ListAudienceExports"))
                      .build();
        }
      }
    }
    return getListAudienceExportsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static BetaAnalyticsDataStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BetaAnalyticsDataStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BetaAnalyticsDataStub>() {
          @java.lang.Override
          public BetaAnalyticsDataStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BetaAnalyticsDataStub(channel, callOptions);
          }
        };
    return BetaAnalyticsDataStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BetaAnalyticsDataBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BetaAnalyticsDataBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BetaAnalyticsDataBlockingStub>() {
          @java.lang.Override
          public BetaAnalyticsDataBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BetaAnalyticsDataBlockingStub(channel, callOptions);
          }
        };
    return BetaAnalyticsDataBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static BetaAnalyticsDataFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BetaAnalyticsDataFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BetaAnalyticsDataFutureStub>() {
          @java.lang.Override
          public BetaAnalyticsDataFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BetaAnalyticsDataFutureStub(channel, callOptions);
          }
        };
    return BetaAnalyticsDataFutureStub.newStub(factory, channel);
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
     * Returns a customized report of your Google Analytics event data. Reports
     * contain statistics derived from data collected by the Google Analytics
     * tracking code. The data returned from the API is as a table with columns
     * for the requested dimensions and metrics. Metrics are individual
     * measurements of user activity on your property, such as active users or
     * event count. Dimensions break down metrics across some common criteria,
     * such as country or event name.
     * For a guide to constructing requests &amp; understanding responses, see
     * [Creating a
     * Report](https://developers.google.com/analytics/devguides/reporting/data/v1/basics).
     * </pre>
     */
    default void runReport(
        com.google.analytics.data.v1beta.RunReportRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1beta.RunReportResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRunReportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a customized pivot report of your Google Analytics event data.
     * Pivot reports are more advanced and expressive formats than regular
     * reports. In a pivot report, dimensions are only visible if they are
     * included in a pivot. Multiple pivots can be specified to further dissect
     * your data.
     * </pre>
     */
    default void runPivotReport(
        com.google.analytics.data.v1beta.RunPivotReportRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1beta.RunPivotReportResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRunPivotReportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns multiple reports in a batch. All reports must be for the same
     * Google Analytics property.
     * </pre>
     */
    default void batchRunReports(
        com.google.analytics.data.v1beta.BatchRunReportsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1beta.BatchRunReportsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchRunReportsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns multiple pivot reports in a batch. All reports must be for the same
     * Google Analytics property.
     * </pre>
     */
    default void batchRunPivotReports(
        com.google.analytics.data.v1beta.BatchRunPivotReportsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1beta.BatchRunPivotReportsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchRunPivotReportsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for dimensions and metrics available in reporting methods.
     * Used to explore the dimensions and metrics. In this method, a Google
     * Analytics property identifier is specified in the request, and
     * the metadata response includes Custom dimensions and metrics as well as
     * Universal metadata.
     * For example if a custom metric with parameter name `levels_unlocked` is
     * registered to a property, the Metadata response will contain
     * `customEvent:levels_unlocked`. Universal metadata are dimensions and
     * metrics applicable to any property such as `country` and `totalUsers`.
     * </pre>
     */
    default void getMetadata(
        com.google.analytics.data.v1beta.GetMetadataRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1beta.Metadata> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetMetadataMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a customized report of realtime event data for your property.
     * Events appear in realtime reports seconds after they have been sent to
     * the Google Analytics. Realtime reports show events and usage data for the
     * periods of time ranging from the present moment to 30 minutes ago (up to
     * 60 minutes for Google Analytics 360 properties).
     * For a guide to constructing realtime requests &amp; understanding responses,
     * see [Creating a Realtime
     * Report](https://developers.google.com/analytics/devguides/reporting/data/v1/realtime-basics).
     * </pre>
     */
    default void runRealtimeReport(
        com.google.analytics.data.v1beta.RunRealtimeReportRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1beta.RunRealtimeReportResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRunRealtimeReportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This compatibility method lists dimensions and metrics that can be added to
     * a report request and maintain compatibility. This method fails if the
     * request's dimensions and metrics are incompatible.
     * In Google Analytics, reports fail if they request incompatible dimensions
     * and/or metrics; in that case, you will need to remove dimensions and/or
     * metrics from the incompatible report until the report is compatible.
     * The Realtime and Core reports have different compatibility rules. This
     * method checks compatibility for Core reports.
     * </pre>
     */
    default void checkCompatibility(
        com.google.analytics.data.v1beta.CheckCompatibilityRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1beta.CheckCompatibilityResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCheckCompatibilityMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an audience export for later retrieval. This method quickly returns
     * the audience export's resource name and initiates a long running
     * asynchronous request to form an audience export. To export the users in an
     * audience export, first create the audience export through this method and
     * then send the audience resource name to the `QueryAudienceExport` method.
     * See [Creating an Audience
     * Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Exports with examples.
     * An audience export is a snapshot of the users currently in the audience at
     * the time of audience export creation. Creating audience exports for one
     * audience on different days will return different results as users enter and
     * exit the audience.
     * Audiences in Google Analytics 4 allow you to segment your users in the ways
     * that are important to your business. To learn more, see
     * https://support.google.com/analytics/answer/9267572. Audience exports
     * contain the users in each audience.
     * Audience Export APIs have some methods at alpha and other methods at beta
     * stability. The intention is to advance methods to beta stability after some
     * feedback and adoption. To give your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    default void createAudienceExport(
        com.google.analytics.data.v1beta.CreateAudienceExportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAudienceExportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an audience export of users. After creating an audience, the
     * users are not immediately available for exporting. First, a request to
     * `CreateAudienceExport` is necessary to create an audience export of users,
     * and then second, this method is used to retrieve the users in the audience
     * export.
     * See [Creating an Audience
     * Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Exports with examples.
     * Audiences in Google Analytics 4 allow you to segment your users in the ways
     * that are important to your business. To learn more, see
     * https://support.google.com/analytics/answer/9267572.
     * Audience Export APIs have some methods at alpha and other methods at beta
     * stability. The intention is to advance methods to beta stability after some
     * feedback and adoption. To give your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    default void queryAudienceExport(
        com.google.analytics.data.v1beta.QueryAudienceExportRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1beta.QueryAudienceExportResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getQueryAudienceExportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets configuration metadata about a specific audience export. This method
     * can be used to understand an audience export after it has been created.
     * See [Creating an Audience
     * Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Exports with examples.
     * Audience Export APIs have some methods at alpha and other methods at beta
     * stability. The intention is to advance methods to beta stability after some
     * feedback and adoption. To give your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    default void getAudienceExport(
        com.google.analytics.data.v1beta.GetAudienceExportRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1beta.AudienceExport>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAudienceExportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all audience exports for a property. This method can be used for you
     * to find and reuse existing audience exports rather than creating
     * unnecessary new audience exports. The same audience can have multiple
     * audience exports that represent the export of users that were in an
     * audience on different days.
     * See [Creating an Audience
     * Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Exports with examples.
     * Audience Export APIs have some methods at alpha and other methods at beta
     * stability. The intention is to advance methods to beta stability after some
     * feedback and adoption. To give your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    default void listAudienceExports(
        com.google.analytics.data.v1beta.ListAudienceExportsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1beta.ListAudienceExportsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAudienceExportsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service BetaAnalyticsData.
   *
   * <pre>
   * Google Analytics reporting data service.
   * </pre>
   */
  public abstract static class BetaAnalyticsDataImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return BetaAnalyticsDataGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service BetaAnalyticsData.
   *
   * <pre>
   * Google Analytics reporting data service.
   * </pre>
   */
  public static final class BetaAnalyticsDataStub
      extends io.grpc.stub.AbstractAsyncStub<BetaAnalyticsDataStub> {
    private BetaAnalyticsDataStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BetaAnalyticsDataStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BetaAnalyticsDataStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns a customized report of your Google Analytics event data. Reports
     * contain statistics derived from data collected by the Google Analytics
     * tracking code. The data returned from the API is as a table with columns
     * for the requested dimensions and metrics. Metrics are individual
     * measurements of user activity on your property, such as active users or
     * event count. Dimensions break down metrics across some common criteria,
     * such as country or event name.
     * For a guide to constructing requests &amp; understanding responses, see
     * [Creating a
     * Report](https://developers.google.com/analytics/devguides/reporting/data/v1/basics).
     * </pre>
     */
    public void runReport(
        com.google.analytics.data.v1beta.RunReportRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1beta.RunReportResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRunReportMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a customized pivot report of your Google Analytics event data.
     * Pivot reports are more advanced and expressive formats than regular
     * reports. In a pivot report, dimensions are only visible if they are
     * included in a pivot. Multiple pivots can be specified to further dissect
     * your data.
     * </pre>
     */
    public void runPivotReport(
        com.google.analytics.data.v1beta.RunPivotReportRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1beta.RunPivotReportResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRunPivotReportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns multiple reports in a batch. All reports must be for the same
     * Google Analytics property.
     * </pre>
     */
    public void batchRunReports(
        com.google.analytics.data.v1beta.BatchRunReportsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1beta.BatchRunReportsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchRunReportsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns multiple pivot reports in a batch. All reports must be for the same
     * Google Analytics property.
     * </pre>
     */
    public void batchRunPivotReports(
        com.google.analytics.data.v1beta.BatchRunPivotReportsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1beta.BatchRunPivotReportsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchRunPivotReportsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for dimensions and metrics available in reporting methods.
     * Used to explore the dimensions and metrics. In this method, a Google
     * Analytics property identifier is specified in the request, and
     * the metadata response includes Custom dimensions and metrics as well as
     * Universal metadata.
     * For example if a custom metric with parameter name `levels_unlocked` is
     * registered to a property, the Metadata response will contain
     * `customEvent:levels_unlocked`. Universal metadata are dimensions and
     * metrics applicable to any property such as `country` and `totalUsers`.
     * </pre>
     */
    public void getMetadata(
        com.google.analytics.data.v1beta.GetMetadataRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1beta.Metadata> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMetadataMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a customized report of realtime event data for your property.
     * Events appear in realtime reports seconds after they have been sent to
     * the Google Analytics. Realtime reports show events and usage data for the
     * periods of time ranging from the present moment to 30 minutes ago (up to
     * 60 minutes for Google Analytics 360 properties).
     * For a guide to constructing realtime requests &amp; understanding responses,
     * see [Creating a Realtime
     * Report](https://developers.google.com/analytics/devguides/reporting/data/v1/realtime-basics).
     * </pre>
     */
    public void runRealtimeReport(
        com.google.analytics.data.v1beta.RunRealtimeReportRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1beta.RunRealtimeReportResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRunRealtimeReportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This compatibility method lists dimensions and metrics that can be added to
     * a report request and maintain compatibility. This method fails if the
     * request's dimensions and metrics are incompatible.
     * In Google Analytics, reports fail if they request incompatible dimensions
     * and/or metrics; in that case, you will need to remove dimensions and/or
     * metrics from the incompatible report until the report is compatible.
     * The Realtime and Core reports have different compatibility rules. This
     * method checks compatibility for Core reports.
     * </pre>
     */
    public void checkCompatibility(
        com.google.analytics.data.v1beta.CheckCompatibilityRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1beta.CheckCompatibilityResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckCompatibilityMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an audience export for later retrieval. This method quickly returns
     * the audience export's resource name and initiates a long running
     * asynchronous request to form an audience export. To export the users in an
     * audience export, first create the audience export through this method and
     * then send the audience resource name to the `QueryAudienceExport` method.
     * See [Creating an Audience
     * Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Exports with examples.
     * An audience export is a snapshot of the users currently in the audience at
     * the time of audience export creation. Creating audience exports for one
     * audience on different days will return different results as users enter and
     * exit the audience.
     * Audiences in Google Analytics 4 allow you to segment your users in the ways
     * that are important to your business. To learn more, see
     * https://support.google.com/analytics/answer/9267572. Audience exports
     * contain the users in each audience.
     * Audience Export APIs have some methods at alpha and other methods at beta
     * stability. The intention is to advance methods to beta stability after some
     * feedback and adoption. To give your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public void createAudienceExport(
        com.google.analytics.data.v1beta.CreateAudienceExportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAudienceExportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an audience export of users. After creating an audience, the
     * users are not immediately available for exporting. First, a request to
     * `CreateAudienceExport` is necessary to create an audience export of users,
     * and then second, this method is used to retrieve the users in the audience
     * export.
     * See [Creating an Audience
     * Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Exports with examples.
     * Audiences in Google Analytics 4 allow you to segment your users in the ways
     * that are important to your business. To learn more, see
     * https://support.google.com/analytics/answer/9267572.
     * Audience Export APIs have some methods at alpha and other methods at beta
     * stability. The intention is to advance methods to beta stability after some
     * feedback and adoption. To give your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public void queryAudienceExport(
        com.google.analytics.data.v1beta.QueryAudienceExportRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1beta.QueryAudienceExportResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQueryAudienceExportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets configuration metadata about a specific audience export. This method
     * can be used to understand an audience export after it has been created.
     * See [Creating an Audience
     * Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Exports with examples.
     * Audience Export APIs have some methods at alpha and other methods at beta
     * stability. The intention is to advance methods to beta stability after some
     * feedback and adoption. To give your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public void getAudienceExport(
        com.google.analytics.data.v1beta.GetAudienceExportRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1beta.AudienceExport>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAudienceExportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all audience exports for a property. This method can be used for you
     * to find and reuse existing audience exports rather than creating
     * unnecessary new audience exports. The same audience can have multiple
     * audience exports that represent the export of users that were in an
     * audience on different days.
     * See [Creating an Audience
     * Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Exports with examples.
     * Audience Export APIs have some methods at alpha and other methods at beta
     * stability. The intention is to advance methods to beta stability after some
     * feedback and adoption. To give your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public void listAudienceExports(
        com.google.analytics.data.v1beta.ListAudienceExportsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1beta.ListAudienceExportsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAudienceExportsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service BetaAnalyticsData.
   *
   * <pre>
   * Google Analytics reporting data service.
   * </pre>
   */
  public static final class BetaAnalyticsDataBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<BetaAnalyticsDataBlockingStub> {
    private BetaAnalyticsDataBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BetaAnalyticsDataBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BetaAnalyticsDataBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns a customized report of your Google Analytics event data. Reports
     * contain statistics derived from data collected by the Google Analytics
     * tracking code. The data returned from the API is as a table with columns
     * for the requested dimensions and metrics. Metrics are individual
     * measurements of user activity on your property, such as active users or
     * event count. Dimensions break down metrics across some common criteria,
     * such as country or event name.
     * For a guide to constructing requests &amp; understanding responses, see
     * [Creating a
     * Report](https://developers.google.com/analytics/devguides/reporting/data/v1/basics).
     * </pre>
     */
    public com.google.analytics.data.v1beta.RunReportResponse runReport(
        com.google.analytics.data.v1beta.RunReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRunReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a customized pivot report of your Google Analytics event data.
     * Pivot reports are more advanced and expressive formats than regular
     * reports. In a pivot report, dimensions are only visible if they are
     * included in a pivot. Multiple pivots can be specified to further dissect
     * your data.
     * </pre>
     */
    public com.google.analytics.data.v1beta.RunPivotReportResponse runPivotReport(
        com.google.analytics.data.v1beta.RunPivotReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRunPivotReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns multiple reports in a batch. All reports must be for the same
     * Google Analytics property.
     * </pre>
     */
    public com.google.analytics.data.v1beta.BatchRunReportsResponse batchRunReports(
        com.google.analytics.data.v1beta.BatchRunReportsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchRunReportsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns multiple pivot reports in a batch. All reports must be for the same
     * Google Analytics property.
     * </pre>
     */
    public com.google.analytics.data.v1beta.BatchRunPivotReportsResponse batchRunPivotReports(
        com.google.analytics.data.v1beta.BatchRunPivotReportsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchRunPivotReportsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for dimensions and metrics available in reporting methods.
     * Used to explore the dimensions and metrics. In this method, a Google
     * Analytics property identifier is specified in the request, and
     * the metadata response includes Custom dimensions and metrics as well as
     * Universal metadata.
     * For example if a custom metric with parameter name `levels_unlocked` is
     * registered to a property, the Metadata response will contain
     * `customEvent:levels_unlocked`. Universal metadata are dimensions and
     * metrics applicable to any property such as `country` and `totalUsers`.
     * </pre>
     */
    public com.google.analytics.data.v1beta.Metadata getMetadata(
        com.google.analytics.data.v1beta.GetMetadataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMetadataMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a customized report of realtime event data for your property.
     * Events appear in realtime reports seconds after they have been sent to
     * the Google Analytics. Realtime reports show events and usage data for the
     * periods of time ranging from the present moment to 30 minutes ago (up to
     * 60 minutes for Google Analytics 360 properties).
     * For a guide to constructing realtime requests &amp; understanding responses,
     * see [Creating a Realtime
     * Report](https://developers.google.com/analytics/devguides/reporting/data/v1/realtime-basics).
     * </pre>
     */
    public com.google.analytics.data.v1beta.RunRealtimeReportResponse runRealtimeReport(
        com.google.analytics.data.v1beta.RunRealtimeReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRunRealtimeReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * This compatibility method lists dimensions and metrics that can be added to
     * a report request and maintain compatibility. This method fails if the
     * request's dimensions and metrics are incompatible.
     * In Google Analytics, reports fail if they request incompatible dimensions
     * and/or metrics; in that case, you will need to remove dimensions and/or
     * metrics from the incompatible report until the report is compatible.
     * The Realtime and Core reports have different compatibility rules. This
     * method checks compatibility for Core reports.
     * </pre>
     */
    public com.google.analytics.data.v1beta.CheckCompatibilityResponse checkCompatibility(
        com.google.analytics.data.v1beta.CheckCompatibilityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckCompatibilityMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an audience export for later retrieval. This method quickly returns
     * the audience export's resource name and initiates a long running
     * asynchronous request to form an audience export. To export the users in an
     * audience export, first create the audience export through this method and
     * then send the audience resource name to the `QueryAudienceExport` method.
     * See [Creating an Audience
     * Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Exports with examples.
     * An audience export is a snapshot of the users currently in the audience at
     * the time of audience export creation. Creating audience exports for one
     * audience on different days will return different results as users enter and
     * exit the audience.
     * Audiences in Google Analytics 4 allow you to segment your users in the ways
     * that are important to your business. To learn more, see
     * https://support.google.com/analytics/answer/9267572. Audience exports
     * contain the users in each audience.
     * Audience Export APIs have some methods at alpha and other methods at beta
     * stability. The intention is to advance methods to beta stability after some
     * feedback and adoption. To give your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public com.google.longrunning.Operation createAudienceExport(
        com.google.analytics.data.v1beta.CreateAudienceExportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAudienceExportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an audience export of users. After creating an audience, the
     * users are not immediately available for exporting. First, a request to
     * `CreateAudienceExport` is necessary to create an audience export of users,
     * and then second, this method is used to retrieve the users in the audience
     * export.
     * See [Creating an Audience
     * Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Exports with examples.
     * Audiences in Google Analytics 4 allow you to segment your users in the ways
     * that are important to your business. To learn more, see
     * https://support.google.com/analytics/answer/9267572.
     * Audience Export APIs have some methods at alpha and other methods at beta
     * stability. The intention is to advance methods to beta stability after some
     * feedback and adoption. To give your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public com.google.analytics.data.v1beta.QueryAudienceExportResponse queryAudienceExport(
        com.google.analytics.data.v1beta.QueryAudienceExportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryAudienceExportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets configuration metadata about a specific audience export. This method
     * can be used to understand an audience export after it has been created.
     * See [Creating an Audience
     * Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Exports with examples.
     * Audience Export APIs have some methods at alpha and other methods at beta
     * stability. The intention is to advance methods to beta stability after some
     * feedback and adoption. To give your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public com.google.analytics.data.v1beta.AudienceExport getAudienceExport(
        com.google.analytics.data.v1beta.GetAudienceExportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAudienceExportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all audience exports for a property. This method can be used for you
     * to find and reuse existing audience exports rather than creating
     * unnecessary new audience exports. The same audience can have multiple
     * audience exports that represent the export of users that were in an
     * audience on different days.
     * See [Creating an Audience
     * Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Exports with examples.
     * Audience Export APIs have some methods at alpha and other methods at beta
     * stability. The intention is to advance methods to beta stability after some
     * feedback and adoption. To give your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public com.google.analytics.data.v1beta.ListAudienceExportsResponse listAudienceExports(
        com.google.analytics.data.v1beta.ListAudienceExportsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAudienceExportsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service BetaAnalyticsData.
   *
   * <pre>
   * Google Analytics reporting data service.
   * </pre>
   */
  public static final class BetaAnalyticsDataFutureStub
      extends io.grpc.stub.AbstractFutureStub<BetaAnalyticsDataFutureStub> {
    private BetaAnalyticsDataFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BetaAnalyticsDataFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BetaAnalyticsDataFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns a customized report of your Google Analytics event data. Reports
     * contain statistics derived from data collected by the Google Analytics
     * tracking code. The data returned from the API is as a table with columns
     * for the requested dimensions and metrics. Metrics are individual
     * measurements of user activity on your property, such as active users or
     * event count. Dimensions break down metrics across some common criteria,
     * such as country or event name.
     * For a guide to constructing requests &amp; understanding responses, see
     * [Creating a
     * Report](https://developers.google.com/analytics/devguides/reporting/data/v1/basics).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.data.v1beta.RunReportResponse>
        runReport(com.google.analytics.data.v1beta.RunReportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRunReportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a customized pivot report of your Google Analytics event data.
     * Pivot reports are more advanced and expressive formats than regular
     * reports. In a pivot report, dimensions are only visible if they are
     * included in a pivot. Multiple pivots can be specified to further dissect
     * your data.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.data.v1beta.RunPivotReportResponse>
        runPivotReport(com.google.analytics.data.v1beta.RunPivotReportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRunPivotReportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns multiple reports in a batch. All reports must be for the same
     * Google Analytics property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.data.v1beta.BatchRunReportsResponse>
        batchRunReports(com.google.analytics.data.v1beta.BatchRunReportsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchRunReportsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns multiple pivot reports in a batch. All reports must be for the same
     * Google Analytics property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.data.v1beta.BatchRunPivotReportsResponse>
        batchRunPivotReports(com.google.analytics.data.v1beta.BatchRunPivotReportsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchRunPivotReportsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for dimensions and metrics available in reporting methods.
     * Used to explore the dimensions and metrics. In this method, a Google
     * Analytics property identifier is specified in the request, and
     * the metadata response includes Custom dimensions and metrics as well as
     * Universal metadata.
     * For example if a custom metric with parameter name `levels_unlocked` is
     * registered to a property, the Metadata response will contain
     * `customEvent:levels_unlocked`. Universal metadata are dimensions and
     * metrics applicable to any property such as `country` and `totalUsers`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.data.v1beta.Metadata>
        getMetadata(com.google.analytics.data.v1beta.GetMetadataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMetadataMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a customized report of realtime event data for your property.
     * Events appear in realtime reports seconds after they have been sent to
     * the Google Analytics. Realtime reports show events and usage data for the
     * periods of time ranging from the present moment to 30 minutes ago (up to
     * 60 minutes for Google Analytics 360 properties).
     * For a guide to constructing realtime requests &amp; understanding responses,
     * see [Creating a Realtime
     * Report](https://developers.google.com/analytics/devguides/reporting/data/v1/realtime-basics).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.data.v1beta.RunRealtimeReportResponse>
        runRealtimeReport(com.google.analytics.data.v1beta.RunRealtimeReportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRunRealtimeReportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * This compatibility method lists dimensions and metrics that can be added to
     * a report request and maintain compatibility. This method fails if the
     * request's dimensions and metrics are incompatible.
     * In Google Analytics, reports fail if they request incompatible dimensions
     * and/or metrics; in that case, you will need to remove dimensions and/or
     * metrics from the incompatible report until the report is compatible.
     * The Realtime and Core reports have different compatibility rules. This
     * method checks compatibility for Core reports.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.data.v1beta.CheckCompatibilityResponse>
        checkCompatibility(com.google.analytics.data.v1beta.CheckCompatibilityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckCompatibilityMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an audience export for later retrieval. This method quickly returns
     * the audience export's resource name and initiates a long running
     * asynchronous request to form an audience export. To export the users in an
     * audience export, first create the audience export through this method and
     * then send the audience resource name to the `QueryAudienceExport` method.
     * See [Creating an Audience
     * Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Exports with examples.
     * An audience export is a snapshot of the users currently in the audience at
     * the time of audience export creation. Creating audience exports for one
     * audience on different days will return different results as users enter and
     * exit the audience.
     * Audiences in Google Analytics 4 allow you to segment your users in the ways
     * that are important to your business. To learn more, see
     * https://support.google.com/analytics/answer/9267572. Audience exports
     * contain the users in each audience.
     * Audience Export APIs have some methods at alpha and other methods at beta
     * stability. The intention is to advance methods to beta stability after some
     * feedback and adoption. To give your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createAudienceExport(com.google.analytics.data.v1beta.CreateAudienceExportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAudienceExportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an audience export of users. After creating an audience, the
     * users are not immediately available for exporting. First, a request to
     * `CreateAudienceExport` is necessary to create an audience export of users,
     * and then second, this method is used to retrieve the users in the audience
     * export.
     * See [Creating an Audience
     * Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Exports with examples.
     * Audiences in Google Analytics 4 allow you to segment your users in the ways
     * that are important to your business. To learn more, see
     * https://support.google.com/analytics/answer/9267572.
     * Audience Export APIs have some methods at alpha and other methods at beta
     * stability. The intention is to advance methods to beta stability after some
     * feedback and adoption. To give your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.data.v1beta.QueryAudienceExportResponse>
        queryAudienceExport(com.google.analytics.data.v1beta.QueryAudienceExportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQueryAudienceExportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets configuration metadata about a specific audience export. This method
     * can be used to understand an audience export after it has been created.
     * See [Creating an Audience
     * Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Exports with examples.
     * Audience Export APIs have some methods at alpha and other methods at beta
     * stability. The intention is to advance methods to beta stability after some
     * feedback and adoption. To give your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.data.v1beta.AudienceExport>
        getAudienceExport(com.google.analytics.data.v1beta.GetAudienceExportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAudienceExportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all audience exports for a property. This method can be used for you
     * to find and reuse existing audience exports rather than creating
     * unnecessary new audience exports. The same audience can have multiple
     * audience exports that represent the export of users that were in an
     * audience on different days.
     * See [Creating an Audience
     * Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
     * for an introduction to Audience Exports with examples.
     * Audience Export APIs have some methods at alpha and other methods at beta
     * stability. The intention is to advance methods to beta stability after some
     * feedback and adoption. To give your feedback on this API, complete the
     * [Google Analytics Audience Export API
     * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.data.v1beta.ListAudienceExportsResponse>
        listAudienceExports(com.google.analytics.data.v1beta.ListAudienceExportsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAudienceExportsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RUN_REPORT = 0;
  private static final int METHODID_RUN_PIVOT_REPORT = 1;
  private static final int METHODID_BATCH_RUN_REPORTS = 2;
  private static final int METHODID_BATCH_RUN_PIVOT_REPORTS = 3;
  private static final int METHODID_GET_METADATA = 4;
  private static final int METHODID_RUN_REALTIME_REPORT = 5;
  private static final int METHODID_CHECK_COMPATIBILITY = 6;
  private static final int METHODID_CREATE_AUDIENCE_EXPORT = 7;
  private static final int METHODID_QUERY_AUDIENCE_EXPORT = 8;
  private static final int METHODID_GET_AUDIENCE_EXPORT = 9;
  private static final int METHODID_LIST_AUDIENCE_EXPORTS = 10;

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
        case METHODID_RUN_REPORT:
          serviceImpl.runReport(
              (com.google.analytics.data.v1beta.RunReportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.data.v1beta.RunReportResponse>)
                  responseObserver);
          break;
        case METHODID_RUN_PIVOT_REPORT:
          serviceImpl.runPivotReport(
              (com.google.analytics.data.v1beta.RunPivotReportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.data.v1beta.RunPivotReportResponse>)
                  responseObserver);
          break;
        case METHODID_BATCH_RUN_REPORTS:
          serviceImpl.batchRunReports(
              (com.google.analytics.data.v1beta.BatchRunReportsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.data.v1beta.BatchRunReportsResponse>)
                  responseObserver);
          break;
        case METHODID_BATCH_RUN_PIVOT_REPORTS:
          serviceImpl.batchRunPivotReports(
              (com.google.analytics.data.v1beta.BatchRunPivotReportsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.data.v1beta.BatchRunPivotReportsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_METADATA:
          serviceImpl.getMetadata(
              (com.google.analytics.data.v1beta.GetMetadataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.data.v1beta.Metadata>)
                  responseObserver);
          break;
        case METHODID_RUN_REALTIME_REPORT:
          serviceImpl.runRealtimeReport(
              (com.google.analytics.data.v1beta.RunRealtimeReportRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.data.v1beta.RunRealtimeReportResponse>)
                  responseObserver);
          break;
        case METHODID_CHECK_COMPATIBILITY:
          serviceImpl.checkCompatibility(
              (com.google.analytics.data.v1beta.CheckCompatibilityRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.data.v1beta.CheckCompatibilityResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_AUDIENCE_EXPORT:
          serviceImpl.createAudienceExport(
              (com.google.analytics.data.v1beta.CreateAudienceExportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_QUERY_AUDIENCE_EXPORT:
          serviceImpl.queryAudienceExport(
              (com.google.analytics.data.v1beta.QueryAudienceExportRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.data.v1beta.QueryAudienceExportResponse>)
                  responseObserver);
          break;
        case METHODID_GET_AUDIENCE_EXPORT:
          serviceImpl.getAudienceExport(
              (com.google.analytics.data.v1beta.GetAudienceExportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.data.v1beta.AudienceExport>)
                  responseObserver);
          break;
        case METHODID_LIST_AUDIENCE_EXPORTS:
          serviceImpl.listAudienceExports(
              (com.google.analytics.data.v1beta.ListAudienceExportsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.data.v1beta.ListAudienceExportsResponse>)
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
            getRunReportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.data.v1beta.RunReportRequest,
                    com.google.analytics.data.v1beta.RunReportResponse>(
                    service, METHODID_RUN_REPORT)))
        .addMethod(
            getRunPivotReportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.data.v1beta.RunPivotReportRequest,
                    com.google.analytics.data.v1beta.RunPivotReportResponse>(
                    service, METHODID_RUN_PIVOT_REPORT)))
        .addMethod(
            getBatchRunReportsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.data.v1beta.BatchRunReportsRequest,
                    com.google.analytics.data.v1beta.BatchRunReportsResponse>(
                    service, METHODID_BATCH_RUN_REPORTS)))
        .addMethod(
            getBatchRunPivotReportsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.data.v1beta.BatchRunPivotReportsRequest,
                    com.google.analytics.data.v1beta.BatchRunPivotReportsResponse>(
                    service, METHODID_BATCH_RUN_PIVOT_REPORTS)))
        .addMethod(
            getGetMetadataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.data.v1beta.GetMetadataRequest,
                    com.google.analytics.data.v1beta.Metadata>(service, METHODID_GET_METADATA)))
        .addMethod(
            getRunRealtimeReportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.data.v1beta.RunRealtimeReportRequest,
                    com.google.analytics.data.v1beta.RunRealtimeReportResponse>(
                    service, METHODID_RUN_REALTIME_REPORT)))
        .addMethod(
            getCheckCompatibilityMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.data.v1beta.CheckCompatibilityRequest,
                    com.google.analytics.data.v1beta.CheckCompatibilityResponse>(
                    service, METHODID_CHECK_COMPATIBILITY)))
        .addMethod(
            getCreateAudienceExportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.data.v1beta.CreateAudienceExportRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_AUDIENCE_EXPORT)))
        .addMethod(
            getQueryAudienceExportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.data.v1beta.QueryAudienceExportRequest,
                    com.google.analytics.data.v1beta.QueryAudienceExportResponse>(
                    service, METHODID_QUERY_AUDIENCE_EXPORT)))
        .addMethod(
            getGetAudienceExportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.data.v1beta.GetAudienceExportRequest,
                    com.google.analytics.data.v1beta.AudienceExport>(
                    service, METHODID_GET_AUDIENCE_EXPORT)))
        .addMethod(
            getListAudienceExportsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.analytics.data.v1beta.ListAudienceExportsRequest,
                    com.google.analytics.data.v1beta.ListAudienceExportsResponse>(
                    service, METHODID_LIST_AUDIENCE_EXPORTS)))
        .build();
  }

  private abstract static class BetaAnalyticsDataBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BetaAnalyticsDataBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.analytics.data.v1beta.AnalyticsDataApiProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BetaAnalyticsData");
    }
  }

  private static final class BetaAnalyticsDataFileDescriptorSupplier
      extends BetaAnalyticsDataBaseDescriptorSupplier {
    BetaAnalyticsDataFileDescriptorSupplier() {}
  }

  private static final class BetaAnalyticsDataMethodDescriptorSupplier
      extends BetaAnalyticsDataBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    BetaAnalyticsDataMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (BetaAnalyticsDataGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new BetaAnalyticsDataFileDescriptorSupplier())
                      .addMethod(getRunReportMethod())
                      .addMethod(getRunPivotReportMethod())
                      .addMethod(getBatchRunReportsMethod())
                      .addMethod(getBatchRunPivotReportsMethod())
                      .addMethod(getGetMetadataMethod())
                      .addMethod(getRunRealtimeReportMethod())
                      .addMethod(getCheckCompatibilityMethod())
                      .addMethod(getCreateAudienceExportMethod())
                      .addMethod(getQueryAudienceExportMethod())
                      .addMethod(getGetAudienceExportMethod())
                      .addMethod(getListAudienceExportsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
