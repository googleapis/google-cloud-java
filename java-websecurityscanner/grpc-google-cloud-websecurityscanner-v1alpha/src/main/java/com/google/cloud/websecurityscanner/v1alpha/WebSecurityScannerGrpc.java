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
package com.google.cloud.websecurityscanner.v1alpha;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Cloud Web Security Scanner Service identifies security vulnerabilities in web
 * applications hosted on Google Cloud Platform. It crawls your application, and
 * attempts to exercise as many user inputs and event handlers as possible.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/websecurityscanner/v1alpha/web_security_scanner.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class WebSecurityScannerGrpc {

  private WebSecurityScannerGrpc() {}

  public static final String SERVICE_NAME =
      "google.cloud.websecurityscanner.v1alpha.WebSecurityScanner";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1alpha.CreateScanConfigRequest,
          com.google.cloud.websecurityscanner.v1alpha.ScanConfig>
      getCreateScanConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateScanConfig",
      requestType = com.google.cloud.websecurityscanner.v1alpha.CreateScanConfigRequest.class,
      responseType = com.google.cloud.websecurityscanner.v1alpha.ScanConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1alpha.CreateScanConfigRequest,
          com.google.cloud.websecurityscanner.v1alpha.ScanConfig>
      getCreateScanConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.websecurityscanner.v1alpha.CreateScanConfigRequest,
            com.google.cloud.websecurityscanner.v1alpha.ScanConfig>
        getCreateScanConfigMethod;
    if ((getCreateScanConfigMethod = WebSecurityScannerGrpc.getCreateScanConfigMethod) == null) {
      synchronized (WebSecurityScannerGrpc.class) {
        if ((getCreateScanConfigMethod = WebSecurityScannerGrpc.getCreateScanConfigMethod)
            == null) {
          WebSecurityScannerGrpc.getCreateScanConfigMethod =
              getCreateScanConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.websecurityscanner.v1alpha.CreateScanConfigRequest,
                          com.google.cloud.websecurityscanner.v1alpha.ScanConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateScanConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1alpha.CreateScanConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1alpha.ScanConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WebSecurityScannerMethodDescriptorSupplier("CreateScanConfig"))
                      .build();
        }
      }
    }
    return getCreateScanConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1alpha.DeleteScanConfigRequest,
          com.google.protobuf.Empty>
      getDeleteScanConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteScanConfig",
      requestType = com.google.cloud.websecurityscanner.v1alpha.DeleteScanConfigRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1alpha.DeleteScanConfigRequest,
          com.google.protobuf.Empty>
      getDeleteScanConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.websecurityscanner.v1alpha.DeleteScanConfigRequest,
            com.google.protobuf.Empty>
        getDeleteScanConfigMethod;
    if ((getDeleteScanConfigMethod = WebSecurityScannerGrpc.getDeleteScanConfigMethod) == null) {
      synchronized (WebSecurityScannerGrpc.class) {
        if ((getDeleteScanConfigMethod = WebSecurityScannerGrpc.getDeleteScanConfigMethod)
            == null) {
          WebSecurityScannerGrpc.getDeleteScanConfigMethod =
              getDeleteScanConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.websecurityscanner.v1alpha.DeleteScanConfigRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteScanConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1alpha.DeleteScanConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WebSecurityScannerMethodDescriptorSupplier("DeleteScanConfig"))
                      .build();
        }
      }
    }
    return getDeleteScanConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1alpha.GetScanConfigRequest,
          com.google.cloud.websecurityscanner.v1alpha.ScanConfig>
      getGetScanConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetScanConfig",
      requestType = com.google.cloud.websecurityscanner.v1alpha.GetScanConfigRequest.class,
      responseType = com.google.cloud.websecurityscanner.v1alpha.ScanConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1alpha.GetScanConfigRequest,
          com.google.cloud.websecurityscanner.v1alpha.ScanConfig>
      getGetScanConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.websecurityscanner.v1alpha.GetScanConfigRequest,
            com.google.cloud.websecurityscanner.v1alpha.ScanConfig>
        getGetScanConfigMethod;
    if ((getGetScanConfigMethod = WebSecurityScannerGrpc.getGetScanConfigMethod) == null) {
      synchronized (WebSecurityScannerGrpc.class) {
        if ((getGetScanConfigMethod = WebSecurityScannerGrpc.getGetScanConfigMethod) == null) {
          WebSecurityScannerGrpc.getGetScanConfigMethod =
              getGetScanConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.websecurityscanner.v1alpha.GetScanConfigRequest,
                          com.google.cloud.websecurityscanner.v1alpha.ScanConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetScanConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1alpha.GetScanConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1alpha.ScanConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WebSecurityScannerMethodDescriptorSupplier("GetScanConfig"))
                      .build();
        }
      }
    }
    return getGetScanConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1alpha.ListScanConfigsRequest,
          com.google.cloud.websecurityscanner.v1alpha.ListScanConfigsResponse>
      getListScanConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListScanConfigs",
      requestType = com.google.cloud.websecurityscanner.v1alpha.ListScanConfigsRequest.class,
      responseType = com.google.cloud.websecurityscanner.v1alpha.ListScanConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1alpha.ListScanConfigsRequest,
          com.google.cloud.websecurityscanner.v1alpha.ListScanConfigsResponse>
      getListScanConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.websecurityscanner.v1alpha.ListScanConfigsRequest,
            com.google.cloud.websecurityscanner.v1alpha.ListScanConfigsResponse>
        getListScanConfigsMethod;
    if ((getListScanConfigsMethod = WebSecurityScannerGrpc.getListScanConfigsMethod) == null) {
      synchronized (WebSecurityScannerGrpc.class) {
        if ((getListScanConfigsMethod = WebSecurityScannerGrpc.getListScanConfigsMethod) == null) {
          WebSecurityScannerGrpc.getListScanConfigsMethod =
              getListScanConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.websecurityscanner.v1alpha.ListScanConfigsRequest,
                          com.google.cloud.websecurityscanner.v1alpha.ListScanConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListScanConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1alpha.ListScanConfigsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1alpha.ListScanConfigsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WebSecurityScannerMethodDescriptorSupplier("ListScanConfigs"))
                      .build();
        }
      }
    }
    return getListScanConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1alpha.UpdateScanConfigRequest,
          com.google.cloud.websecurityscanner.v1alpha.ScanConfig>
      getUpdateScanConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateScanConfig",
      requestType = com.google.cloud.websecurityscanner.v1alpha.UpdateScanConfigRequest.class,
      responseType = com.google.cloud.websecurityscanner.v1alpha.ScanConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1alpha.UpdateScanConfigRequest,
          com.google.cloud.websecurityscanner.v1alpha.ScanConfig>
      getUpdateScanConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.websecurityscanner.v1alpha.UpdateScanConfigRequest,
            com.google.cloud.websecurityscanner.v1alpha.ScanConfig>
        getUpdateScanConfigMethod;
    if ((getUpdateScanConfigMethod = WebSecurityScannerGrpc.getUpdateScanConfigMethod) == null) {
      synchronized (WebSecurityScannerGrpc.class) {
        if ((getUpdateScanConfigMethod = WebSecurityScannerGrpc.getUpdateScanConfigMethod)
            == null) {
          WebSecurityScannerGrpc.getUpdateScanConfigMethod =
              getUpdateScanConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.websecurityscanner.v1alpha.UpdateScanConfigRequest,
                          com.google.cloud.websecurityscanner.v1alpha.ScanConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateScanConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1alpha.UpdateScanConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1alpha.ScanConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WebSecurityScannerMethodDescriptorSupplier("UpdateScanConfig"))
                      .build();
        }
      }
    }
    return getUpdateScanConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1alpha.StartScanRunRequest,
          com.google.cloud.websecurityscanner.v1alpha.ScanRun>
      getStartScanRunMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartScanRun",
      requestType = com.google.cloud.websecurityscanner.v1alpha.StartScanRunRequest.class,
      responseType = com.google.cloud.websecurityscanner.v1alpha.ScanRun.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1alpha.StartScanRunRequest,
          com.google.cloud.websecurityscanner.v1alpha.ScanRun>
      getStartScanRunMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.websecurityscanner.v1alpha.StartScanRunRequest,
            com.google.cloud.websecurityscanner.v1alpha.ScanRun>
        getStartScanRunMethod;
    if ((getStartScanRunMethod = WebSecurityScannerGrpc.getStartScanRunMethod) == null) {
      synchronized (WebSecurityScannerGrpc.class) {
        if ((getStartScanRunMethod = WebSecurityScannerGrpc.getStartScanRunMethod) == null) {
          WebSecurityScannerGrpc.getStartScanRunMethod =
              getStartScanRunMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.websecurityscanner.v1alpha.StartScanRunRequest,
                          com.google.cloud.websecurityscanner.v1alpha.ScanRun>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartScanRun"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1alpha.StartScanRunRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1alpha.ScanRun
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WebSecurityScannerMethodDescriptorSupplier("StartScanRun"))
                      .build();
        }
      }
    }
    return getStartScanRunMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1alpha.GetScanRunRequest,
          com.google.cloud.websecurityscanner.v1alpha.ScanRun>
      getGetScanRunMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetScanRun",
      requestType = com.google.cloud.websecurityscanner.v1alpha.GetScanRunRequest.class,
      responseType = com.google.cloud.websecurityscanner.v1alpha.ScanRun.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1alpha.GetScanRunRequest,
          com.google.cloud.websecurityscanner.v1alpha.ScanRun>
      getGetScanRunMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.websecurityscanner.v1alpha.GetScanRunRequest,
            com.google.cloud.websecurityscanner.v1alpha.ScanRun>
        getGetScanRunMethod;
    if ((getGetScanRunMethod = WebSecurityScannerGrpc.getGetScanRunMethod) == null) {
      synchronized (WebSecurityScannerGrpc.class) {
        if ((getGetScanRunMethod = WebSecurityScannerGrpc.getGetScanRunMethod) == null) {
          WebSecurityScannerGrpc.getGetScanRunMethod =
              getGetScanRunMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.websecurityscanner.v1alpha.GetScanRunRequest,
                          com.google.cloud.websecurityscanner.v1alpha.ScanRun>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetScanRun"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1alpha.GetScanRunRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1alpha.ScanRun
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WebSecurityScannerMethodDescriptorSupplier("GetScanRun"))
                      .build();
        }
      }
    }
    return getGetScanRunMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1alpha.ListScanRunsRequest,
          com.google.cloud.websecurityscanner.v1alpha.ListScanRunsResponse>
      getListScanRunsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListScanRuns",
      requestType = com.google.cloud.websecurityscanner.v1alpha.ListScanRunsRequest.class,
      responseType = com.google.cloud.websecurityscanner.v1alpha.ListScanRunsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1alpha.ListScanRunsRequest,
          com.google.cloud.websecurityscanner.v1alpha.ListScanRunsResponse>
      getListScanRunsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.websecurityscanner.v1alpha.ListScanRunsRequest,
            com.google.cloud.websecurityscanner.v1alpha.ListScanRunsResponse>
        getListScanRunsMethod;
    if ((getListScanRunsMethod = WebSecurityScannerGrpc.getListScanRunsMethod) == null) {
      synchronized (WebSecurityScannerGrpc.class) {
        if ((getListScanRunsMethod = WebSecurityScannerGrpc.getListScanRunsMethod) == null) {
          WebSecurityScannerGrpc.getListScanRunsMethod =
              getListScanRunsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.websecurityscanner.v1alpha.ListScanRunsRequest,
                          com.google.cloud.websecurityscanner.v1alpha.ListScanRunsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListScanRuns"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1alpha.ListScanRunsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1alpha.ListScanRunsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WebSecurityScannerMethodDescriptorSupplier("ListScanRuns"))
                      .build();
        }
      }
    }
    return getListScanRunsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1alpha.StopScanRunRequest,
          com.google.cloud.websecurityscanner.v1alpha.ScanRun>
      getStopScanRunMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopScanRun",
      requestType = com.google.cloud.websecurityscanner.v1alpha.StopScanRunRequest.class,
      responseType = com.google.cloud.websecurityscanner.v1alpha.ScanRun.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1alpha.StopScanRunRequest,
          com.google.cloud.websecurityscanner.v1alpha.ScanRun>
      getStopScanRunMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.websecurityscanner.v1alpha.StopScanRunRequest,
            com.google.cloud.websecurityscanner.v1alpha.ScanRun>
        getStopScanRunMethod;
    if ((getStopScanRunMethod = WebSecurityScannerGrpc.getStopScanRunMethod) == null) {
      synchronized (WebSecurityScannerGrpc.class) {
        if ((getStopScanRunMethod = WebSecurityScannerGrpc.getStopScanRunMethod) == null) {
          WebSecurityScannerGrpc.getStopScanRunMethod =
              getStopScanRunMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.websecurityscanner.v1alpha.StopScanRunRequest,
                          com.google.cloud.websecurityscanner.v1alpha.ScanRun>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopScanRun"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1alpha.StopScanRunRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1alpha.ScanRun
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WebSecurityScannerMethodDescriptorSupplier("StopScanRun"))
                      .build();
        }
      }
    }
    return getStopScanRunMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1alpha.ListCrawledUrlsRequest,
          com.google.cloud.websecurityscanner.v1alpha.ListCrawledUrlsResponse>
      getListCrawledUrlsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCrawledUrls",
      requestType = com.google.cloud.websecurityscanner.v1alpha.ListCrawledUrlsRequest.class,
      responseType = com.google.cloud.websecurityscanner.v1alpha.ListCrawledUrlsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1alpha.ListCrawledUrlsRequest,
          com.google.cloud.websecurityscanner.v1alpha.ListCrawledUrlsResponse>
      getListCrawledUrlsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.websecurityscanner.v1alpha.ListCrawledUrlsRequest,
            com.google.cloud.websecurityscanner.v1alpha.ListCrawledUrlsResponse>
        getListCrawledUrlsMethod;
    if ((getListCrawledUrlsMethod = WebSecurityScannerGrpc.getListCrawledUrlsMethod) == null) {
      synchronized (WebSecurityScannerGrpc.class) {
        if ((getListCrawledUrlsMethod = WebSecurityScannerGrpc.getListCrawledUrlsMethod) == null) {
          WebSecurityScannerGrpc.getListCrawledUrlsMethod =
              getListCrawledUrlsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.websecurityscanner.v1alpha.ListCrawledUrlsRequest,
                          com.google.cloud.websecurityscanner.v1alpha.ListCrawledUrlsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCrawledUrls"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1alpha.ListCrawledUrlsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1alpha.ListCrawledUrlsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WebSecurityScannerMethodDescriptorSupplier("ListCrawledUrls"))
                      .build();
        }
      }
    }
    return getListCrawledUrlsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1alpha.GetFindingRequest,
          com.google.cloud.websecurityscanner.v1alpha.Finding>
      getGetFindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFinding",
      requestType = com.google.cloud.websecurityscanner.v1alpha.GetFindingRequest.class,
      responseType = com.google.cloud.websecurityscanner.v1alpha.Finding.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1alpha.GetFindingRequest,
          com.google.cloud.websecurityscanner.v1alpha.Finding>
      getGetFindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.websecurityscanner.v1alpha.GetFindingRequest,
            com.google.cloud.websecurityscanner.v1alpha.Finding>
        getGetFindingMethod;
    if ((getGetFindingMethod = WebSecurityScannerGrpc.getGetFindingMethod) == null) {
      synchronized (WebSecurityScannerGrpc.class) {
        if ((getGetFindingMethod = WebSecurityScannerGrpc.getGetFindingMethod) == null) {
          WebSecurityScannerGrpc.getGetFindingMethod =
              getGetFindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.websecurityscanner.v1alpha.GetFindingRequest,
                          com.google.cloud.websecurityscanner.v1alpha.Finding>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1alpha.GetFindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1alpha.Finding
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WebSecurityScannerMethodDescriptorSupplier("GetFinding"))
                      .build();
        }
      }
    }
    return getGetFindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1alpha.ListFindingsRequest,
          com.google.cloud.websecurityscanner.v1alpha.ListFindingsResponse>
      getListFindingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFindings",
      requestType = com.google.cloud.websecurityscanner.v1alpha.ListFindingsRequest.class,
      responseType = com.google.cloud.websecurityscanner.v1alpha.ListFindingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1alpha.ListFindingsRequest,
          com.google.cloud.websecurityscanner.v1alpha.ListFindingsResponse>
      getListFindingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.websecurityscanner.v1alpha.ListFindingsRequest,
            com.google.cloud.websecurityscanner.v1alpha.ListFindingsResponse>
        getListFindingsMethod;
    if ((getListFindingsMethod = WebSecurityScannerGrpc.getListFindingsMethod) == null) {
      synchronized (WebSecurityScannerGrpc.class) {
        if ((getListFindingsMethod = WebSecurityScannerGrpc.getListFindingsMethod) == null) {
          WebSecurityScannerGrpc.getListFindingsMethod =
              getListFindingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.websecurityscanner.v1alpha.ListFindingsRequest,
                          com.google.cloud.websecurityscanner.v1alpha.ListFindingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFindings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1alpha.ListFindingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1alpha.ListFindingsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WebSecurityScannerMethodDescriptorSupplier("ListFindings"))
                      .build();
        }
      }
    }
    return getListFindingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1alpha.ListFindingTypeStatsRequest,
          com.google.cloud.websecurityscanner.v1alpha.ListFindingTypeStatsResponse>
      getListFindingTypeStatsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFindingTypeStats",
      requestType = com.google.cloud.websecurityscanner.v1alpha.ListFindingTypeStatsRequest.class,
      responseType = com.google.cloud.websecurityscanner.v1alpha.ListFindingTypeStatsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1alpha.ListFindingTypeStatsRequest,
          com.google.cloud.websecurityscanner.v1alpha.ListFindingTypeStatsResponse>
      getListFindingTypeStatsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.websecurityscanner.v1alpha.ListFindingTypeStatsRequest,
            com.google.cloud.websecurityscanner.v1alpha.ListFindingTypeStatsResponse>
        getListFindingTypeStatsMethod;
    if ((getListFindingTypeStatsMethod = WebSecurityScannerGrpc.getListFindingTypeStatsMethod)
        == null) {
      synchronized (WebSecurityScannerGrpc.class) {
        if ((getListFindingTypeStatsMethod = WebSecurityScannerGrpc.getListFindingTypeStatsMethod)
            == null) {
          WebSecurityScannerGrpc.getListFindingTypeStatsMethod =
              getListFindingTypeStatsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.websecurityscanner.v1alpha.ListFindingTypeStatsRequest,
                          com.google.cloud.websecurityscanner.v1alpha.ListFindingTypeStatsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListFindingTypeStats"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1alpha
                                  .ListFindingTypeStatsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1alpha
                                  .ListFindingTypeStatsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WebSecurityScannerMethodDescriptorSupplier("ListFindingTypeStats"))
                      .build();
        }
      }
    }
    return getListFindingTypeStatsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static WebSecurityScannerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WebSecurityScannerStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WebSecurityScannerStub>() {
          @java.lang.Override
          public WebSecurityScannerStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WebSecurityScannerStub(channel, callOptions);
          }
        };
    return WebSecurityScannerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WebSecurityScannerBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WebSecurityScannerBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WebSecurityScannerBlockingStub>() {
          @java.lang.Override
          public WebSecurityScannerBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WebSecurityScannerBlockingStub(channel, callOptions);
          }
        };
    return WebSecurityScannerBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static WebSecurityScannerFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WebSecurityScannerFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WebSecurityScannerFutureStub>() {
          @java.lang.Override
          public WebSecurityScannerFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WebSecurityScannerFutureStub(channel, callOptions);
          }
        };
    return WebSecurityScannerFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Cloud Web Security Scanner Service identifies security vulnerabilities in web
   * applications hosted on Google Cloud Platform. It crawls your application, and
   * attempts to exercise as many user inputs and event handlers as possible.
   * </pre>
   */
  public abstract static class WebSecurityScannerImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a new ScanConfig.
     * </pre>
     */
    public void createScanConfig(
        com.google.cloud.websecurityscanner.v1alpha.CreateScanConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1alpha.ScanConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateScanConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing ScanConfig and its child resources.
     * </pre>
     */
    public void deleteScanConfig(
        com.google.cloud.websecurityscanner.v1alpha.DeleteScanConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteScanConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a ScanConfig.
     * </pre>
     */
    public void getScanConfig(
        com.google.cloud.websecurityscanner.v1alpha.GetScanConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1alpha.ScanConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetScanConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ScanConfigs under a given project.
     * </pre>
     */
    public void listScanConfigs(
        com.google.cloud.websecurityscanner.v1alpha.ListScanConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.websecurityscanner.v1alpha.ListScanConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListScanConfigsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a ScanConfig. This method support partial update of a ScanConfig.
     * </pre>
     */
    public void updateScanConfig(
        com.google.cloud.websecurityscanner.v1alpha.UpdateScanConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1alpha.ScanConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateScanConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Start a ScanRun according to the given ScanConfig.
     * </pre>
     */
    public void startScanRun(
        com.google.cloud.websecurityscanner.v1alpha.StartScanRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1alpha.ScanRun>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getStartScanRunMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a ScanRun.
     * </pre>
     */
    public void getScanRun(
        com.google.cloud.websecurityscanner.v1alpha.GetScanRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1alpha.ScanRun>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetScanRunMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ScanRuns under a given ScanConfig, in descending order of ScanRun
     * stop time.
     * </pre>
     */
    public void listScanRuns(
        com.google.cloud.websecurityscanner.v1alpha.ListScanRunsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.websecurityscanner.v1alpha.ListScanRunsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListScanRunsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Stops a ScanRun. The stopped ScanRun is returned.
     * </pre>
     */
    public void stopScanRun(
        com.google.cloud.websecurityscanner.v1alpha.StopScanRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1alpha.ScanRun>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getStopScanRunMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List CrawledUrls under a given ScanRun.
     * </pre>
     */
    public void listCrawledUrls(
        com.google.cloud.websecurityscanner.v1alpha.ListCrawledUrlsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.websecurityscanner.v1alpha.ListCrawledUrlsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCrawledUrlsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a Finding.
     * </pre>
     */
    public void getFinding(
        com.google.cloud.websecurityscanner.v1alpha.GetFindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1alpha.Finding>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List Findings under a given ScanRun.
     * </pre>
     */
    public void listFindings(
        com.google.cloud.websecurityscanner.v1alpha.ListFindingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.websecurityscanner.v1alpha.ListFindingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListFindingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all FindingTypeStats under a given ScanRun.
     * </pre>
     */
    public void listFindingTypeStats(
        com.google.cloud.websecurityscanner.v1alpha.ListFindingTypeStatsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.websecurityscanner.v1alpha.ListFindingTypeStatsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListFindingTypeStatsMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateScanConfigMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.websecurityscanner.v1alpha.CreateScanConfigRequest,
                      com.google.cloud.websecurityscanner.v1alpha.ScanConfig>(
                      this, METHODID_CREATE_SCAN_CONFIG)))
          .addMethod(
              getDeleteScanConfigMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.websecurityscanner.v1alpha.DeleteScanConfigRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_SCAN_CONFIG)))
          .addMethod(
              getGetScanConfigMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.websecurityscanner.v1alpha.GetScanConfigRequest,
                      com.google.cloud.websecurityscanner.v1alpha.ScanConfig>(
                      this, METHODID_GET_SCAN_CONFIG)))
          .addMethod(
              getListScanConfigsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.websecurityscanner.v1alpha.ListScanConfigsRequest,
                      com.google.cloud.websecurityscanner.v1alpha.ListScanConfigsResponse>(
                      this, METHODID_LIST_SCAN_CONFIGS)))
          .addMethod(
              getUpdateScanConfigMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.websecurityscanner.v1alpha.UpdateScanConfigRequest,
                      com.google.cloud.websecurityscanner.v1alpha.ScanConfig>(
                      this, METHODID_UPDATE_SCAN_CONFIG)))
          .addMethod(
              getStartScanRunMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.websecurityscanner.v1alpha.StartScanRunRequest,
                      com.google.cloud.websecurityscanner.v1alpha.ScanRun>(
                      this, METHODID_START_SCAN_RUN)))
          .addMethod(
              getGetScanRunMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.websecurityscanner.v1alpha.GetScanRunRequest,
                      com.google.cloud.websecurityscanner.v1alpha.ScanRun>(
                      this, METHODID_GET_SCAN_RUN)))
          .addMethod(
              getListScanRunsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.websecurityscanner.v1alpha.ListScanRunsRequest,
                      com.google.cloud.websecurityscanner.v1alpha.ListScanRunsResponse>(
                      this, METHODID_LIST_SCAN_RUNS)))
          .addMethod(
              getStopScanRunMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.websecurityscanner.v1alpha.StopScanRunRequest,
                      com.google.cloud.websecurityscanner.v1alpha.ScanRun>(
                      this, METHODID_STOP_SCAN_RUN)))
          .addMethod(
              getListCrawledUrlsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.websecurityscanner.v1alpha.ListCrawledUrlsRequest,
                      com.google.cloud.websecurityscanner.v1alpha.ListCrawledUrlsResponse>(
                      this, METHODID_LIST_CRAWLED_URLS)))
          .addMethod(
              getGetFindingMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.websecurityscanner.v1alpha.GetFindingRequest,
                      com.google.cloud.websecurityscanner.v1alpha.Finding>(
                      this, METHODID_GET_FINDING)))
          .addMethod(
              getListFindingsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.websecurityscanner.v1alpha.ListFindingsRequest,
                      com.google.cloud.websecurityscanner.v1alpha.ListFindingsResponse>(
                      this, METHODID_LIST_FINDINGS)))
          .addMethod(
              getListFindingTypeStatsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.websecurityscanner.v1alpha.ListFindingTypeStatsRequest,
                      com.google.cloud.websecurityscanner.v1alpha.ListFindingTypeStatsResponse>(
                      this, METHODID_LIST_FINDING_TYPE_STATS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Cloud Web Security Scanner Service identifies security vulnerabilities in web
   * applications hosted on Google Cloud Platform. It crawls your application, and
   * attempts to exercise as many user inputs and event handlers as possible.
   * </pre>
   */
  public static final class WebSecurityScannerStub
      extends io.grpc.stub.AbstractAsyncStub<WebSecurityScannerStub> {
    private WebSecurityScannerStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WebSecurityScannerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WebSecurityScannerStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ScanConfig.
     * </pre>
     */
    public void createScanConfig(
        com.google.cloud.websecurityscanner.v1alpha.CreateScanConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1alpha.ScanConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateScanConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing ScanConfig and its child resources.
     * </pre>
     */
    public void deleteScanConfig(
        com.google.cloud.websecurityscanner.v1alpha.DeleteScanConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteScanConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a ScanConfig.
     * </pre>
     */
    public void getScanConfig(
        com.google.cloud.websecurityscanner.v1alpha.GetScanConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1alpha.ScanConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetScanConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ScanConfigs under a given project.
     * </pre>
     */
    public void listScanConfigs(
        com.google.cloud.websecurityscanner.v1alpha.ListScanConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.websecurityscanner.v1alpha.ListScanConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListScanConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a ScanConfig. This method support partial update of a ScanConfig.
     * </pre>
     */
    public void updateScanConfig(
        com.google.cloud.websecurityscanner.v1alpha.UpdateScanConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1alpha.ScanConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateScanConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Start a ScanRun according to the given ScanConfig.
     * </pre>
     */
    public void startScanRun(
        com.google.cloud.websecurityscanner.v1alpha.StartScanRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1alpha.ScanRun>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartScanRunMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a ScanRun.
     * </pre>
     */
    public void getScanRun(
        com.google.cloud.websecurityscanner.v1alpha.GetScanRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1alpha.ScanRun>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetScanRunMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ScanRuns under a given ScanConfig, in descending order of ScanRun
     * stop time.
     * </pre>
     */
    public void listScanRuns(
        com.google.cloud.websecurityscanner.v1alpha.ListScanRunsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.websecurityscanner.v1alpha.ListScanRunsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListScanRunsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Stops a ScanRun. The stopped ScanRun is returned.
     * </pre>
     */
    public void stopScanRun(
        com.google.cloud.websecurityscanner.v1alpha.StopScanRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1alpha.ScanRun>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopScanRunMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List CrawledUrls under a given ScanRun.
     * </pre>
     */
    public void listCrawledUrls(
        com.google.cloud.websecurityscanner.v1alpha.ListCrawledUrlsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.websecurityscanner.v1alpha.ListCrawledUrlsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCrawledUrlsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a Finding.
     * </pre>
     */
    public void getFinding(
        com.google.cloud.websecurityscanner.v1alpha.GetFindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1alpha.Finding>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFindingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List Findings under a given ScanRun.
     * </pre>
     */
    public void listFindings(
        com.google.cloud.websecurityscanner.v1alpha.ListFindingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.websecurityscanner.v1alpha.ListFindingsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFindingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all FindingTypeStats under a given ScanRun.
     * </pre>
     */
    public void listFindingTypeStats(
        com.google.cloud.websecurityscanner.v1alpha.ListFindingTypeStatsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.websecurityscanner.v1alpha.ListFindingTypeStatsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFindingTypeStatsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Cloud Web Security Scanner Service identifies security vulnerabilities in web
   * applications hosted on Google Cloud Platform. It crawls your application, and
   * attempts to exercise as many user inputs and event handlers as possible.
   * </pre>
   */
  public static final class WebSecurityScannerBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<WebSecurityScannerBlockingStub> {
    private WebSecurityScannerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WebSecurityScannerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WebSecurityScannerBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ScanConfig.
     * </pre>
     */
    public com.google.cloud.websecurityscanner.v1alpha.ScanConfig createScanConfig(
        com.google.cloud.websecurityscanner.v1alpha.CreateScanConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateScanConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing ScanConfig and its child resources.
     * </pre>
     */
    public com.google.protobuf.Empty deleteScanConfig(
        com.google.cloud.websecurityscanner.v1alpha.DeleteScanConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteScanConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a ScanConfig.
     * </pre>
     */
    public com.google.cloud.websecurityscanner.v1alpha.ScanConfig getScanConfig(
        com.google.cloud.websecurityscanner.v1alpha.GetScanConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetScanConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ScanConfigs under a given project.
     * </pre>
     */
    public com.google.cloud.websecurityscanner.v1alpha.ListScanConfigsResponse listScanConfigs(
        com.google.cloud.websecurityscanner.v1alpha.ListScanConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListScanConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a ScanConfig. This method support partial update of a ScanConfig.
     * </pre>
     */
    public com.google.cloud.websecurityscanner.v1alpha.ScanConfig updateScanConfig(
        com.google.cloud.websecurityscanner.v1alpha.UpdateScanConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateScanConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Start a ScanRun according to the given ScanConfig.
     * </pre>
     */
    public com.google.cloud.websecurityscanner.v1alpha.ScanRun startScanRun(
        com.google.cloud.websecurityscanner.v1alpha.StartScanRunRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartScanRunMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a ScanRun.
     * </pre>
     */
    public com.google.cloud.websecurityscanner.v1alpha.ScanRun getScanRun(
        com.google.cloud.websecurityscanner.v1alpha.GetScanRunRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetScanRunMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ScanRuns under a given ScanConfig, in descending order of ScanRun
     * stop time.
     * </pre>
     */
    public com.google.cloud.websecurityscanner.v1alpha.ListScanRunsResponse listScanRuns(
        com.google.cloud.websecurityscanner.v1alpha.ListScanRunsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListScanRunsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Stops a ScanRun. The stopped ScanRun is returned.
     * </pre>
     */
    public com.google.cloud.websecurityscanner.v1alpha.ScanRun stopScanRun(
        com.google.cloud.websecurityscanner.v1alpha.StopScanRunRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopScanRunMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List CrawledUrls under a given ScanRun.
     * </pre>
     */
    public com.google.cloud.websecurityscanner.v1alpha.ListCrawledUrlsResponse listCrawledUrls(
        com.google.cloud.websecurityscanner.v1alpha.ListCrawledUrlsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCrawledUrlsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a Finding.
     * </pre>
     */
    public com.google.cloud.websecurityscanner.v1alpha.Finding getFinding(
        com.google.cloud.websecurityscanner.v1alpha.GetFindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List Findings under a given ScanRun.
     * </pre>
     */
    public com.google.cloud.websecurityscanner.v1alpha.ListFindingsResponse listFindings(
        com.google.cloud.websecurityscanner.v1alpha.ListFindingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFindingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all FindingTypeStats under a given ScanRun.
     * </pre>
     */
    public com.google.cloud.websecurityscanner.v1alpha.ListFindingTypeStatsResponse
        listFindingTypeStats(
            com.google.cloud.websecurityscanner.v1alpha.ListFindingTypeStatsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFindingTypeStatsMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Cloud Web Security Scanner Service identifies security vulnerabilities in web
   * applications hosted on Google Cloud Platform. It crawls your application, and
   * attempts to exercise as many user inputs and event handlers as possible.
   * </pre>
   */
  public static final class WebSecurityScannerFutureStub
      extends io.grpc.stub.AbstractFutureStub<WebSecurityScannerFutureStub> {
    private WebSecurityScannerFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WebSecurityScannerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WebSecurityScannerFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ScanConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.websecurityscanner.v1alpha.ScanConfig>
        createScanConfig(
            com.google.cloud.websecurityscanner.v1alpha.CreateScanConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateScanConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing ScanConfig and its child resources.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteScanConfig(
            com.google.cloud.websecurityscanner.v1alpha.DeleteScanConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteScanConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a ScanConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.websecurityscanner.v1alpha.ScanConfig>
        getScanConfig(com.google.cloud.websecurityscanner.v1alpha.GetScanConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetScanConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ScanConfigs under a given project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.websecurityscanner.v1alpha.ListScanConfigsResponse>
        listScanConfigs(
            com.google.cloud.websecurityscanner.v1alpha.ListScanConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListScanConfigsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a ScanConfig. This method support partial update of a ScanConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.websecurityscanner.v1alpha.ScanConfig>
        updateScanConfig(
            com.google.cloud.websecurityscanner.v1alpha.UpdateScanConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateScanConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Start a ScanRun according to the given ScanConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.websecurityscanner.v1alpha.ScanRun>
        startScanRun(com.google.cloud.websecurityscanner.v1alpha.StartScanRunRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartScanRunMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a ScanRun.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.websecurityscanner.v1alpha.ScanRun>
        getScanRun(com.google.cloud.websecurityscanner.v1alpha.GetScanRunRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetScanRunMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ScanRuns under a given ScanConfig, in descending order of ScanRun
     * stop time.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.websecurityscanner.v1alpha.ListScanRunsResponse>
        listScanRuns(com.google.cloud.websecurityscanner.v1alpha.ListScanRunsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListScanRunsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Stops a ScanRun. The stopped ScanRun is returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.websecurityscanner.v1alpha.ScanRun>
        stopScanRun(com.google.cloud.websecurityscanner.v1alpha.StopScanRunRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopScanRunMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List CrawledUrls under a given ScanRun.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.websecurityscanner.v1alpha.ListCrawledUrlsResponse>
        listCrawledUrls(
            com.google.cloud.websecurityscanner.v1alpha.ListCrawledUrlsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCrawledUrlsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a Finding.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.websecurityscanner.v1alpha.Finding>
        getFinding(com.google.cloud.websecurityscanner.v1alpha.GetFindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List Findings under a given ScanRun.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.websecurityscanner.v1alpha.ListFindingsResponse>
        listFindings(com.google.cloud.websecurityscanner.v1alpha.ListFindingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFindingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List all FindingTypeStats under a given ScanRun.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.websecurityscanner.v1alpha.ListFindingTypeStatsResponse>
        listFindingTypeStats(
            com.google.cloud.websecurityscanner.v1alpha.ListFindingTypeStatsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFindingTypeStatsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SCAN_CONFIG = 0;
  private static final int METHODID_DELETE_SCAN_CONFIG = 1;
  private static final int METHODID_GET_SCAN_CONFIG = 2;
  private static final int METHODID_LIST_SCAN_CONFIGS = 3;
  private static final int METHODID_UPDATE_SCAN_CONFIG = 4;
  private static final int METHODID_START_SCAN_RUN = 5;
  private static final int METHODID_GET_SCAN_RUN = 6;
  private static final int METHODID_LIST_SCAN_RUNS = 7;
  private static final int METHODID_STOP_SCAN_RUN = 8;
  private static final int METHODID_LIST_CRAWLED_URLS = 9;
  private static final int METHODID_GET_FINDING = 10;
  private static final int METHODID_LIST_FINDINGS = 11;
  private static final int METHODID_LIST_FINDING_TYPE_STATS = 12;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WebSecurityScannerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WebSecurityScannerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_SCAN_CONFIG:
          serviceImpl.createScanConfig(
              (com.google.cloud.websecurityscanner.v1alpha.CreateScanConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1alpha.ScanConfig>)
                  responseObserver);
          break;
        case METHODID_DELETE_SCAN_CONFIG:
          serviceImpl.deleteScanConfig(
              (com.google.cloud.websecurityscanner.v1alpha.DeleteScanConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_SCAN_CONFIG:
          serviceImpl.getScanConfig(
              (com.google.cloud.websecurityscanner.v1alpha.GetScanConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1alpha.ScanConfig>)
                  responseObserver);
          break;
        case METHODID_LIST_SCAN_CONFIGS:
          serviceImpl.listScanConfigs(
              (com.google.cloud.websecurityscanner.v1alpha.ListScanConfigsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.websecurityscanner.v1alpha.ListScanConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SCAN_CONFIG:
          serviceImpl.updateScanConfig(
              (com.google.cloud.websecurityscanner.v1alpha.UpdateScanConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1alpha.ScanConfig>)
                  responseObserver);
          break;
        case METHODID_START_SCAN_RUN:
          serviceImpl.startScanRun(
              (com.google.cloud.websecurityscanner.v1alpha.StartScanRunRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1alpha.ScanRun>)
                  responseObserver);
          break;
        case METHODID_GET_SCAN_RUN:
          serviceImpl.getScanRun(
              (com.google.cloud.websecurityscanner.v1alpha.GetScanRunRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1alpha.ScanRun>)
                  responseObserver);
          break;
        case METHODID_LIST_SCAN_RUNS:
          serviceImpl.listScanRuns(
              (com.google.cloud.websecurityscanner.v1alpha.ListScanRunsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.websecurityscanner.v1alpha.ListScanRunsResponse>)
                  responseObserver);
          break;
        case METHODID_STOP_SCAN_RUN:
          serviceImpl.stopScanRun(
              (com.google.cloud.websecurityscanner.v1alpha.StopScanRunRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1alpha.ScanRun>)
                  responseObserver);
          break;
        case METHODID_LIST_CRAWLED_URLS:
          serviceImpl.listCrawledUrls(
              (com.google.cloud.websecurityscanner.v1alpha.ListCrawledUrlsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.websecurityscanner.v1alpha.ListCrawledUrlsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_FINDING:
          serviceImpl.getFinding(
              (com.google.cloud.websecurityscanner.v1alpha.GetFindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1alpha.Finding>)
                  responseObserver);
          break;
        case METHODID_LIST_FINDINGS:
          serviceImpl.listFindings(
              (com.google.cloud.websecurityscanner.v1alpha.ListFindingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.websecurityscanner.v1alpha.ListFindingsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_FINDING_TYPE_STATS:
          serviceImpl.listFindingTypeStats(
              (com.google.cloud.websecurityscanner.v1alpha.ListFindingTypeStatsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.websecurityscanner.v1alpha.ListFindingTypeStatsResponse>)
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

  private abstract static class WebSecurityScannerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WebSecurityScannerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.websecurityscanner.v1alpha.WebSecurityScannerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WebSecurityScanner");
    }
  }

  private static final class WebSecurityScannerFileDescriptorSupplier
      extends WebSecurityScannerBaseDescriptorSupplier {
    WebSecurityScannerFileDescriptorSupplier() {}
  }

  private static final class WebSecurityScannerMethodDescriptorSupplier
      extends WebSecurityScannerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WebSecurityScannerMethodDescriptorSupplier(String methodName) {
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
      synchronized (WebSecurityScannerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new WebSecurityScannerFileDescriptorSupplier())
                      .addMethod(getCreateScanConfigMethod())
                      .addMethod(getDeleteScanConfigMethod())
                      .addMethod(getGetScanConfigMethod())
                      .addMethod(getListScanConfigsMethod())
                      .addMethod(getUpdateScanConfigMethod())
                      .addMethod(getStartScanRunMethod())
                      .addMethod(getGetScanRunMethod())
                      .addMethod(getListScanRunsMethod())
                      .addMethod(getStopScanRunMethod())
                      .addMethod(getListCrawledUrlsMethod())
                      .addMethod(getGetFindingMethod())
                      .addMethod(getListFindingsMethod())
                      .addMethod(getListFindingTypeStatsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
