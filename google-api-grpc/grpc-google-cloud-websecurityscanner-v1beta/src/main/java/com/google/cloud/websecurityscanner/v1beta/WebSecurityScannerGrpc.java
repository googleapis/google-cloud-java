package com.google.cloud.websecurityscanner.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

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
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/websecurityscanner/v1beta/web_security_scanner.proto")
public final class WebSecurityScannerGrpc {

  private WebSecurityScannerGrpc() {}

  public static final String SERVICE_NAME =
      "google.cloud.websecurityscanner.v1beta.WebSecurityScanner";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateScanConfigMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.CreateScanConfigRequest,
          com.google.cloud.websecurityscanner.v1beta.ScanConfig>
      METHOD_CREATE_SCAN_CONFIG = getCreateScanConfigMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.CreateScanConfigRequest,
          com.google.cloud.websecurityscanner.v1beta.ScanConfig>
      getCreateScanConfigMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.CreateScanConfigRequest,
          com.google.cloud.websecurityscanner.v1beta.ScanConfig>
      getCreateScanConfigMethod() {
    return getCreateScanConfigMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.CreateScanConfigRequest,
          com.google.cloud.websecurityscanner.v1beta.ScanConfig>
      getCreateScanConfigMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.websecurityscanner.v1beta.CreateScanConfigRequest,
            com.google.cloud.websecurityscanner.v1beta.ScanConfig>
        getCreateScanConfigMethod;
    if ((getCreateScanConfigMethod = WebSecurityScannerGrpc.getCreateScanConfigMethod) == null) {
      synchronized (WebSecurityScannerGrpc.class) {
        if ((getCreateScanConfigMethod = WebSecurityScannerGrpc.getCreateScanConfigMethod)
            == null) {
          WebSecurityScannerGrpc.getCreateScanConfigMethod =
              getCreateScanConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.websecurityscanner.v1beta.CreateScanConfigRequest,
                          com.google.cloud.websecurityscanner.v1beta.ScanConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.websecurityscanner.v1beta.WebSecurityScanner",
                              "CreateScanConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1beta.CreateScanConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1beta.ScanConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WebSecurityScannerMethodDescriptorSupplier("CreateScanConfig"))
                      .build();
        }
      }
    }
    return getCreateScanConfigMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteScanConfigMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.DeleteScanConfigRequest,
          com.google.protobuf.Empty>
      METHOD_DELETE_SCAN_CONFIG = getDeleteScanConfigMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.DeleteScanConfigRequest,
          com.google.protobuf.Empty>
      getDeleteScanConfigMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.DeleteScanConfigRequest,
          com.google.protobuf.Empty>
      getDeleteScanConfigMethod() {
    return getDeleteScanConfigMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.DeleteScanConfigRequest,
          com.google.protobuf.Empty>
      getDeleteScanConfigMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.websecurityscanner.v1beta.DeleteScanConfigRequest,
            com.google.protobuf.Empty>
        getDeleteScanConfigMethod;
    if ((getDeleteScanConfigMethod = WebSecurityScannerGrpc.getDeleteScanConfigMethod) == null) {
      synchronized (WebSecurityScannerGrpc.class) {
        if ((getDeleteScanConfigMethod = WebSecurityScannerGrpc.getDeleteScanConfigMethod)
            == null) {
          WebSecurityScannerGrpc.getDeleteScanConfigMethod =
              getDeleteScanConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.websecurityscanner.v1beta.DeleteScanConfigRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.websecurityscanner.v1beta.WebSecurityScanner",
                              "DeleteScanConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1beta.DeleteScanConfigRequest
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetScanConfigMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.GetScanConfigRequest,
          com.google.cloud.websecurityscanner.v1beta.ScanConfig>
      METHOD_GET_SCAN_CONFIG = getGetScanConfigMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.GetScanConfigRequest,
          com.google.cloud.websecurityscanner.v1beta.ScanConfig>
      getGetScanConfigMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.GetScanConfigRequest,
          com.google.cloud.websecurityscanner.v1beta.ScanConfig>
      getGetScanConfigMethod() {
    return getGetScanConfigMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.GetScanConfigRequest,
          com.google.cloud.websecurityscanner.v1beta.ScanConfig>
      getGetScanConfigMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.websecurityscanner.v1beta.GetScanConfigRequest,
            com.google.cloud.websecurityscanner.v1beta.ScanConfig>
        getGetScanConfigMethod;
    if ((getGetScanConfigMethod = WebSecurityScannerGrpc.getGetScanConfigMethod) == null) {
      synchronized (WebSecurityScannerGrpc.class) {
        if ((getGetScanConfigMethod = WebSecurityScannerGrpc.getGetScanConfigMethod) == null) {
          WebSecurityScannerGrpc.getGetScanConfigMethod =
              getGetScanConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.websecurityscanner.v1beta.GetScanConfigRequest,
                          com.google.cloud.websecurityscanner.v1beta.ScanConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.websecurityscanner.v1beta.WebSecurityScanner",
                              "GetScanConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1beta.GetScanConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1beta.ScanConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WebSecurityScannerMethodDescriptorSupplier("GetScanConfig"))
                      .build();
        }
      }
    }
    return getGetScanConfigMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListScanConfigsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.ListScanConfigsRequest,
          com.google.cloud.websecurityscanner.v1beta.ListScanConfigsResponse>
      METHOD_LIST_SCAN_CONFIGS = getListScanConfigsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.ListScanConfigsRequest,
          com.google.cloud.websecurityscanner.v1beta.ListScanConfigsResponse>
      getListScanConfigsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.ListScanConfigsRequest,
          com.google.cloud.websecurityscanner.v1beta.ListScanConfigsResponse>
      getListScanConfigsMethod() {
    return getListScanConfigsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.ListScanConfigsRequest,
          com.google.cloud.websecurityscanner.v1beta.ListScanConfigsResponse>
      getListScanConfigsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.websecurityscanner.v1beta.ListScanConfigsRequest,
            com.google.cloud.websecurityscanner.v1beta.ListScanConfigsResponse>
        getListScanConfigsMethod;
    if ((getListScanConfigsMethod = WebSecurityScannerGrpc.getListScanConfigsMethod) == null) {
      synchronized (WebSecurityScannerGrpc.class) {
        if ((getListScanConfigsMethod = WebSecurityScannerGrpc.getListScanConfigsMethod) == null) {
          WebSecurityScannerGrpc.getListScanConfigsMethod =
              getListScanConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.websecurityscanner.v1beta.ListScanConfigsRequest,
                          com.google.cloud.websecurityscanner.v1beta.ListScanConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.websecurityscanner.v1beta.WebSecurityScanner",
                              "ListScanConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1beta.ListScanConfigsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1beta.ListScanConfigsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WebSecurityScannerMethodDescriptorSupplier("ListScanConfigs"))
                      .build();
        }
      }
    }
    return getListScanConfigsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateScanConfigMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.UpdateScanConfigRequest,
          com.google.cloud.websecurityscanner.v1beta.ScanConfig>
      METHOD_UPDATE_SCAN_CONFIG = getUpdateScanConfigMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.UpdateScanConfigRequest,
          com.google.cloud.websecurityscanner.v1beta.ScanConfig>
      getUpdateScanConfigMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.UpdateScanConfigRequest,
          com.google.cloud.websecurityscanner.v1beta.ScanConfig>
      getUpdateScanConfigMethod() {
    return getUpdateScanConfigMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.UpdateScanConfigRequest,
          com.google.cloud.websecurityscanner.v1beta.ScanConfig>
      getUpdateScanConfigMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.websecurityscanner.v1beta.UpdateScanConfigRequest,
            com.google.cloud.websecurityscanner.v1beta.ScanConfig>
        getUpdateScanConfigMethod;
    if ((getUpdateScanConfigMethod = WebSecurityScannerGrpc.getUpdateScanConfigMethod) == null) {
      synchronized (WebSecurityScannerGrpc.class) {
        if ((getUpdateScanConfigMethod = WebSecurityScannerGrpc.getUpdateScanConfigMethod)
            == null) {
          WebSecurityScannerGrpc.getUpdateScanConfigMethod =
              getUpdateScanConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.websecurityscanner.v1beta.UpdateScanConfigRequest,
                          com.google.cloud.websecurityscanner.v1beta.ScanConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.websecurityscanner.v1beta.WebSecurityScanner",
                              "UpdateScanConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1beta.UpdateScanConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1beta.ScanConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WebSecurityScannerMethodDescriptorSupplier("UpdateScanConfig"))
                      .build();
        }
      }
    }
    return getUpdateScanConfigMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getStartScanRunMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.StartScanRunRequest,
          com.google.cloud.websecurityscanner.v1beta.ScanRun>
      METHOD_START_SCAN_RUN = getStartScanRunMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.StartScanRunRequest,
          com.google.cloud.websecurityscanner.v1beta.ScanRun>
      getStartScanRunMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.StartScanRunRequest,
          com.google.cloud.websecurityscanner.v1beta.ScanRun>
      getStartScanRunMethod() {
    return getStartScanRunMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.StartScanRunRequest,
          com.google.cloud.websecurityscanner.v1beta.ScanRun>
      getStartScanRunMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.websecurityscanner.v1beta.StartScanRunRequest,
            com.google.cloud.websecurityscanner.v1beta.ScanRun>
        getStartScanRunMethod;
    if ((getStartScanRunMethod = WebSecurityScannerGrpc.getStartScanRunMethod) == null) {
      synchronized (WebSecurityScannerGrpc.class) {
        if ((getStartScanRunMethod = WebSecurityScannerGrpc.getStartScanRunMethod) == null) {
          WebSecurityScannerGrpc.getStartScanRunMethod =
              getStartScanRunMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.websecurityscanner.v1beta.StartScanRunRequest,
                          com.google.cloud.websecurityscanner.v1beta.ScanRun>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.websecurityscanner.v1beta.WebSecurityScanner",
                              "StartScanRun"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1beta.StartScanRunRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1beta.ScanRun
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WebSecurityScannerMethodDescriptorSupplier("StartScanRun"))
                      .build();
        }
      }
    }
    return getStartScanRunMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetScanRunMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.GetScanRunRequest,
          com.google.cloud.websecurityscanner.v1beta.ScanRun>
      METHOD_GET_SCAN_RUN = getGetScanRunMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.GetScanRunRequest,
          com.google.cloud.websecurityscanner.v1beta.ScanRun>
      getGetScanRunMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.GetScanRunRequest,
          com.google.cloud.websecurityscanner.v1beta.ScanRun>
      getGetScanRunMethod() {
    return getGetScanRunMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.GetScanRunRequest,
          com.google.cloud.websecurityscanner.v1beta.ScanRun>
      getGetScanRunMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.websecurityscanner.v1beta.GetScanRunRequest,
            com.google.cloud.websecurityscanner.v1beta.ScanRun>
        getGetScanRunMethod;
    if ((getGetScanRunMethod = WebSecurityScannerGrpc.getGetScanRunMethod) == null) {
      synchronized (WebSecurityScannerGrpc.class) {
        if ((getGetScanRunMethod = WebSecurityScannerGrpc.getGetScanRunMethod) == null) {
          WebSecurityScannerGrpc.getGetScanRunMethod =
              getGetScanRunMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.websecurityscanner.v1beta.GetScanRunRequest,
                          com.google.cloud.websecurityscanner.v1beta.ScanRun>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.websecurityscanner.v1beta.WebSecurityScanner",
                              "GetScanRun"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1beta.GetScanRunRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1beta.ScanRun
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WebSecurityScannerMethodDescriptorSupplier("GetScanRun"))
                      .build();
        }
      }
    }
    return getGetScanRunMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListScanRunsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.ListScanRunsRequest,
          com.google.cloud.websecurityscanner.v1beta.ListScanRunsResponse>
      METHOD_LIST_SCAN_RUNS = getListScanRunsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.ListScanRunsRequest,
          com.google.cloud.websecurityscanner.v1beta.ListScanRunsResponse>
      getListScanRunsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.ListScanRunsRequest,
          com.google.cloud.websecurityscanner.v1beta.ListScanRunsResponse>
      getListScanRunsMethod() {
    return getListScanRunsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.ListScanRunsRequest,
          com.google.cloud.websecurityscanner.v1beta.ListScanRunsResponse>
      getListScanRunsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.websecurityscanner.v1beta.ListScanRunsRequest,
            com.google.cloud.websecurityscanner.v1beta.ListScanRunsResponse>
        getListScanRunsMethod;
    if ((getListScanRunsMethod = WebSecurityScannerGrpc.getListScanRunsMethod) == null) {
      synchronized (WebSecurityScannerGrpc.class) {
        if ((getListScanRunsMethod = WebSecurityScannerGrpc.getListScanRunsMethod) == null) {
          WebSecurityScannerGrpc.getListScanRunsMethod =
              getListScanRunsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.websecurityscanner.v1beta.ListScanRunsRequest,
                          com.google.cloud.websecurityscanner.v1beta.ListScanRunsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.websecurityscanner.v1beta.WebSecurityScanner",
                              "ListScanRuns"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1beta.ListScanRunsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1beta.ListScanRunsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WebSecurityScannerMethodDescriptorSupplier("ListScanRuns"))
                      .build();
        }
      }
    }
    return getListScanRunsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getStopScanRunMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.StopScanRunRequest,
          com.google.cloud.websecurityscanner.v1beta.ScanRun>
      METHOD_STOP_SCAN_RUN = getStopScanRunMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.StopScanRunRequest,
          com.google.cloud.websecurityscanner.v1beta.ScanRun>
      getStopScanRunMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.StopScanRunRequest,
          com.google.cloud.websecurityscanner.v1beta.ScanRun>
      getStopScanRunMethod() {
    return getStopScanRunMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.StopScanRunRequest,
          com.google.cloud.websecurityscanner.v1beta.ScanRun>
      getStopScanRunMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.websecurityscanner.v1beta.StopScanRunRequest,
            com.google.cloud.websecurityscanner.v1beta.ScanRun>
        getStopScanRunMethod;
    if ((getStopScanRunMethod = WebSecurityScannerGrpc.getStopScanRunMethod) == null) {
      synchronized (WebSecurityScannerGrpc.class) {
        if ((getStopScanRunMethod = WebSecurityScannerGrpc.getStopScanRunMethod) == null) {
          WebSecurityScannerGrpc.getStopScanRunMethod =
              getStopScanRunMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.websecurityscanner.v1beta.StopScanRunRequest,
                          com.google.cloud.websecurityscanner.v1beta.ScanRun>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.websecurityscanner.v1beta.WebSecurityScanner",
                              "StopScanRun"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1beta.StopScanRunRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1beta.ScanRun
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WebSecurityScannerMethodDescriptorSupplier("StopScanRun"))
                      .build();
        }
      }
    }
    return getStopScanRunMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListCrawledUrlsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.ListCrawledUrlsRequest,
          com.google.cloud.websecurityscanner.v1beta.ListCrawledUrlsResponse>
      METHOD_LIST_CRAWLED_URLS = getListCrawledUrlsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.ListCrawledUrlsRequest,
          com.google.cloud.websecurityscanner.v1beta.ListCrawledUrlsResponse>
      getListCrawledUrlsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.ListCrawledUrlsRequest,
          com.google.cloud.websecurityscanner.v1beta.ListCrawledUrlsResponse>
      getListCrawledUrlsMethod() {
    return getListCrawledUrlsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.ListCrawledUrlsRequest,
          com.google.cloud.websecurityscanner.v1beta.ListCrawledUrlsResponse>
      getListCrawledUrlsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.websecurityscanner.v1beta.ListCrawledUrlsRequest,
            com.google.cloud.websecurityscanner.v1beta.ListCrawledUrlsResponse>
        getListCrawledUrlsMethod;
    if ((getListCrawledUrlsMethod = WebSecurityScannerGrpc.getListCrawledUrlsMethod) == null) {
      synchronized (WebSecurityScannerGrpc.class) {
        if ((getListCrawledUrlsMethod = WebSecurityScannerGrpc.getListCrawledUrlsMethod) == null) {
          WebSecurityScannerGrpc.getListCrawledUrlsMethod =
              getListCrawledUrlsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.websecurityscanner.v1beta.ListCrawledUrlsRequest,
                          com.google.cloud.websecurityscanner.v1beta.ListCrawledUrlsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.websecurityscanner.v1beta.WebSecurityScanner",
                              "ListCrawledUrls"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1beta.ListCrawledUrlsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1beta.ListCrawledUrlsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WebSecurityScannerMethodDescriptorSupplier("ListCrawledUrls"))
                      .build();
        }
      }
    }
    return getListCrawledUrlsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetFindingMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.GetFindingRequest,
          com.google.cloud.websecurityscanner.v1beta.Finding>
      METHOD_GET_FINDING = getGetFindingMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.GetFindingRequest,
          com.google.cloud.websecurityscanner.v1beta.Finding>
      getGetFindingMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.GetFindingRequest,
          com.google.cloud.websecurityscanner.v1beta.Finding>
      getGetFindingMethod() {
    return getGetFindingMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.GetFindingRequest,
          com.google.cloud.websecurityscanner.v1beta.Finding>
      getGetFindingMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.websecurityscanner.v1beta.GetFindingRequest,
            com.google.cloud.websecurityscanner.v1beta.Finding>
        getGetFindingMethod;
    if ((getGetFindingMethod = WebSecurityScannerGrpc.getGetFindingMethod) == null) {
      synchronized (WebSecurityScannerGrpc.class) {
        if ((getGetFindingMethod = WebSecurityScannerGrpc.getGetFindingMethod) == null) {
          WebSecurityScannerGrpc.getGetFindingMethod =
              getGetFindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.websecurityscanner.v1beta.GetFindingRequest,
                          com.google.cloud.websecurityscanner.v1beta.Finding>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.websecurityscanner.v1beta.WebSecurityScanner",
                              "GetFinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1beta.GetFindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1beta.Finding
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WebSecurityScannerMethodDescriptorSupplier("GetFinding"))
                      .build();
        }
      }
    }
    return getGetFindingMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListFindingsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.ListFindingsRequest,
          com.google.cloud.websecurityscanner.v1beta.ListFindingsResponse>
      METHOD_LIST_FINDINGS = getListFindingsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.ListFindingsRequest,
          com.google.cloud.websecurityscanner.v1beta.ListFindingsResponse>
      getListFindingsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.ListFindingsRequest,
          com.google.cloud.websecurityscanner.v1beta.ListFindingsResponse>
      getListFindingsMethod() {
    return getListFindingsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.ListFindingsRequest,
          com.google.cloud.websecurityscanner.v1beta.ListFindingsResponse>
      getListFindingsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.websecurityscanner.v1beta.ListFindingsRequest,
            com.google.cloud.websecurityscanner.v1beta.ListFindingsResponse>
        getListFindingsMethod;
    if ((getListFindingsMethod = WebSecurityScannerGrpc.getListFindingsMethod) == null) {
      synchronized (WebSecurityScannerGrpc.class) {
        if ((getListFindingsMethod = WebSecurityScannerGrpc.getListFindingsMethod) == null) {
          WebSecurityScannerGrpc.getListFindingsMethod =
              getListFindingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.websecurityscanner.v1beta.ListFindingsRequest,
                          com.google.cloud.websecurityscanner.v1beta.ListFindingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.websecurityscanner.v1beta.WebSecurityScanner",
                              "ListFindings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1beta.ListFindingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1beta.ListFindingsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WebSecurityScannerMethodDescriptorSupplier("ListFindings"))
                      .build();
        }
      }
    }
    return getListFindingsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListFindingTypeStatsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.ListFindingTypeStatsRequest,
          com.google.cloud.websecurityscanner.v1beta.ListFindingTypeStatsResponse>
      METHOD_LIST_FINDING_TYPE_STATS = getListFindingTypeStatsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.ListFindingTypeStatsRequest,
          com.google.cloud.websecurityscanner.v1beta.ListFindingTypeStatsResponse>
      getListFindingTypeStatsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.ListFindingTypeStatsRequest,
          com.google.cloud.websecurityscanner.v1beta.ListFindingTypeStatsResponse>
      getListFindingTypeStatsMethod() {
    return getListFindingTypeStatsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.websecurityscanner.v1beta.ListFindingTypeStatsRequest,
          com.google.cloud.websecurityscanner.v1beta.ListFindingTypeStatsResponse>
      getListFindingTypeStatsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.websecurityscanner.v1beta.ListFindingTypeStatsRequest,
            com.google.cloud.websecurityscanner.v1beta.ListFindingTypeStatsResponse>
        getListFindingTypeStatsMethod;
    if ((getListFindingTypeStatsMethod = WebSecurityScannerGrpc.getListFindingTypeStatsMethod)
        == null) {
      synchronized (WebSecurityScannerGrpc.class) {
        if ((getListFindingTypeStatsMethod = WebSecurityScannerGrpc.getListFindingTypeStatsMethod)
            == null) {
          WebSecurityScannerGrpc.getListFindingTypeStatsMethod =
              getListFindingTypeStatsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.websecurityscanner.v1beta.ListFindingTypeStatsRequest,
                          com.google.cloud.websecurityscanner.v1beta.ListFindingTypeStatsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.websecurityscanner.v1beta.WebSecurityScanner",
                              "ListFindingTypeStats"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1beta.ListFindingTypeStatsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.websecurityscanner.v1beta
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
    return new WebSecurityScannerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WebSecurityScannerBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new WebSecurityScannerBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static WebSecurityScannerFutureStub newFutureStub(io.grpc.Channel channel) {
    return new WebSecurityScannerFutureStub(channel);
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
        com.google.cloud.websecurityscanner.v1beta.CreateScanConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1beta.ScanConfig>
            responseObserver) {
      asyncUnimplementedUnaryCall(getCreateScanConfigMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing ScanConfig and its child resources.
     * </pre>
     */
    public void deleteScanConfig(
        com.google.cloud.websecurityscanner.v1beta.DeleteScanConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteScanConfigMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a ScanConfig.
     * </pre>
     */
    public void getScanConfig(
        com.google.cloud.websecurityscanner.v1beta.GetScanConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1beta.ScanConfig>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetScanConfigMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ScanConfigs under a given project.
     * </pre>
     */
    public void listScanConfigs(
        com.google.cloud.websecurityscanner.v1beta.ListScanConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.websecurityscanner.v1beta.ListScanConfigsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListScanConfigsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a ScanConfig. This method support partial update of a ScanConfig.
     * </pre>
     */
    public void updateScanConfig(
        com.google.cloud.websecurityscanner.v1beta.UpdateScanConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1beta.ScanConfig>
            responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateScanConfigMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Start a ScanRun according to the given ScanConfig.
     * </pre>
     */
    public void startScanRun(
        com.google.cloud.websecurityscanner.v1beta.StartScanRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1beta.ScanRun>
            responseObserver) {
      asyncUnimplementedUnaryCall(getStartScanRunMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a ScanRun.
     * </pre>
     */
    public void getScanRun(
        com.google.cloud.websecurityscanner.v1beta.GetScanRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1beta.ScanRun>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetScanRunMethodHelper(), responseObserver);
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
        com.google.cloud.websecurityscanner.v1beta.ListScanRunsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1beta.ListScanRunsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListScanRunsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Stops a ScanRun. The stopped ScanRun is returned.
     * </pre>
     */
    public void stopScanRun(
        com.google.cloud.websecurityscanner.v1beta.StopScanRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1beta.ScanRun>
            responseObserver) {
      asyncUnimplementedUnaryCall(getStopScanRunMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List CrawledUrls under a given ScanRun.
     * </pre>
     */
    public void listCrawledUrls(
        com.google.cloud.websecurityscanner.v1beta.ListCrawledUrlsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.websecurityscanner.v1beta.ListCrawledUrlsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListCrawledUrlsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a Finding.
     * </pre>
     */
    public void getFinding(
        com.google.cloud.websecurityscanner.v1beta.GetFindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1beta.Finding>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetFindingMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List Findings under a given ScanRun.
     * </pre>
     */
    public void listFindings(
        com.google.cloud.websecurityscanner.v1beta.ListFindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1beta.ListFindingsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListFindingsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all FindingTypeStats under a given ScanRun.
     * </pre>
     */
    public void listFindingTypeStats(
        com.google.cloud.websecurityscanner.v1beta.ListFindingTypeStatsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.websecurityscanner.v1beta.ListFindingTypeStatsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListFindingTypeStatsMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateScanConfigMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.websecurityscanner.v1beta.CreateScanConfigRequest,
                      com.google.cloud.websecurityscanner.v1beta.ScanConfig>(
                      this, METHODID_CREATE_SCAN_CONFIG)))
          .addMethod(
              getDeleteScanConfigMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.websecurityscanner.v1beta.DeleteScanConfigRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_SCAN_CONFIG)))
          .addMethod(
              getGetScanConfigMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.websecurityscanner.v1beta.GetScanConfigRequest,
                      com.google.cloud.websecurityscanner.v1beta.ScanConfig>(
                      this, METHODID_GET_SCAN_CONFIG)))
          .addMethod(
              getListScanConfigsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.websecurityscanner.v1beta.ListScanConfigsRequest,
                      com.google.cloud.websecurityscanner.v1beta.ListScanConfigsResponse>(
                      this, METHODID_LIST_SCAN_CONFIGS)))
          .addMethod(
              getUpdateScanConfigMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.websecurityscanner.v1beta.UpdateScanConfigRequest,
                      com.google.cloud.websecurityscanner.v1beta.ScanConfig>(
                      this, METHODID_UPDATE_SCAN_CONFIG)))
          .addMethod(
              getStartScanRunMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.websecurityscanner.v1beta.StartScanRunRequest,
                      com.google.cloud.websecurityscanner.v1beta.ScanRun>(
                      this, METHODID_START_SCAN_RUN)))
          .addMethod(
              getGetScanRunMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.websecurityscanner.v1beta.GetScanRunRequest,
                      com.google.cloud.websecurityscanner.v1beta.ScanRun>(
                      this, METHODID_GET_SCAN_RUN)))
          .addMethod(
              getListScanRunsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.websecurityscanner.v1beta.ListScanRunsRequest,
                      com.google.cloud.websecurityscanner.v1beta.ListScanRunsResponse>(
                      this, METHODID_LIST_SCAN_RUNS)))
          .addMethod(
              getStopScanRunMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.websecurityscanner.v1beta.StopScanRunRequest,
                      com.google.cloud.websecurityscanner.v1beta.ScanRun>(
                      this, METHODID_STOP_SCAN_RUN)))
          .addMethod(
              getListCrawledUrlsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.websecurityscanner.v1beta.ListCrawledUrlsRequest,
                      com.google.cloud.websecurityscanner.v1beta.ListCrawledUrlsResponse>(
                      this, METHODID_LIST_CRAWLED_URLS)))
          .addMethod(
              getGetFindingMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.websecurityscanner.v1beta.GetFindingRequest,
                      com.google.cloud.websecurityscanner.v1beta.Finding>(
                      this, METHODID_GET_FINDING)))
          .addMethod(
              getListFindingsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.websecurityscanner.v1beta.ListFindingsRequest,
                      com.google.cloud.websecurityscanner.v1beta.ListFindingsResponse>(
                      this, METHODID_LIST_FINDINGS)))
          .addMethod(
              getListFindingTypeStatsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.websecurityscanner.v1beta.ListFindingTypeStatsRequest,
                      com.google.cloud.websecurityscanner.v1beta.ListFindingTypeStatsResponse>(
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
      extends io.grpc.stub.AbstractStub<WebSecurityScannerStub> {
    private WebSecurityScannerStub(io.grpc.Channel channel) {
      super(channel);
    }

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
        com.google.cloud.websecurityscanner.v1beta.CreateScanConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1beta.ScanConfig>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateScanConfigMethodHelper(), getCallOptions()),
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
        com.google.cloud.websecurityscanner.v1beta.DeleteScanConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteScanConfigMethodHelper(), getCallOptions()),
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
        com.google.cloud.websecurityscanner.v1beta.GetScanConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1beta.ScanConfig>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetScanConfigMethodHelper(), getCallOptions()),
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
        com.google.cloud.websecurityscanner.v1beta.ListScanConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.websecurityscanner.v1beta.ListScanConfigsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListScanConfigsMethodHelper(), getCallOptions()),
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
        com.google.cloud.websecurityscanner.v1beta.UpdateScanConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1beta.ScanConfig>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateScanConfigMethodHelper(), getCallOptions()),
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
        com.google.cloud.websecurityscanner.v1beta.StartScanRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1beta.ScanRun>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStartScanRunMethodHelper(), getCallOptions()),
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
        com.google.cloud.websecurityscanner.v1beta.GetScanRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1beta.ScanRun>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetScanRunMethodHelper(), getCallOptions()),
          request,
          responseObserver);
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
        com.google.cloud.websecurityscanner.v1beta.ListScanRunsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1beta.ListScanRunsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListScanRunsMethodHelper(), getCallOptions()),
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
        com.google.cloud.websecurityscanner.v1beta.StopScanRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1beta.ScanRun>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStopScanRunMethodHelper(), getCallOptions()),
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
        com.google.cloud.websecurityscanner.v1beta.ListCrawledUrlsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.websecurityscanner.v1beta.ListCrawledUrlsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListCrawledUrlsMethodHelper(), getCallOptions()),
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
        com.google.cloud.websecurityscanner.v1beta.GetFindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1beta.Finding>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetFindingMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List Findings under a given ScanRun.
     * </pre>
     */
    public void listFindings(
        com.google.cloud.websecurityscanner.v1beta.ListFindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1beta.ListFindingsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListFindingsMethodHelper(), getCallOptions()),
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
        com.google.cloud.websecurityscanner.v1beta.ListFindingTypeStatsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.websecurityscanner.v1beta.ListFindingTypeStatsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListFindingTypeStatsMethodHelper(), getCallOptions()),
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
      extends io.grpc.stub.AbstractStub<WebSecurityScannerBlockingStub> {
    private WebSecurityScannerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

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
    public com.google.cloud.websecurityscanner.v1beta.ScanConfig createScanConfig(
        com.google.cloud.websecurityscanner.v1beta.CreateScanConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateScanConfigMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing ScanConfig and its child resources.
     * </pre>
     */
    public com.google.protobuf.Empty deleteScanConfig(
        com.google.cloud.websecurityscanner.v1beta.DeleteScanConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteScanConfigMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a ScanConfig.
     * </pre>
     */
    public com.google.cloud.websecurityscanner.v1beta.ScanConfig getScanConfig(
        com.google.cloud.websecurityscanner.v1beta.GetScanConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetScanConfigMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ScanConfigs under a given project.
     * </pre>
     */
    public com.google.cloud.websecurityscanner.v1beta.ListScanConfigsResponse listScanConfigs(
        com.google.cloud.websecurityscanner.v1beta.ListScanConfigsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListScanConfigsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a ScanConfig. This method support partial update of a ScanConfig.
     * </pre>
     */
    public com.google.cloud.websecurityscanner.v1beta.ScanConfig updateScanConfig(
        com.google.cloud.websecurityscanner.v1beta.UpdateScanConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateScanConfigMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Start a ScanRun according to the given ScanConfig.
     * </pre>
     */
    public com.google.cloud.websecurityscanner.v1beta.ScanRun startScanRun(
        com.google.cloud.websecurityscanner.v1beta.StartScanRunRequest request) {
      return blockingUnaryCall(
          getChannel(), getStartScanRunMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a ScanRun.
     * </pre>
     */
    public com.google.cloud.websecurityscanner.v1beta.ScanRun getScanRun(
        com.google.cloud.websecurityscanner.v1beta.GetScanRunRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetScanRunMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ScanRuns under a given ScanConfig, in descending order of ScanRun
     * stop time.
     * </pre>
     */
    public com.google.cloud.websecurityscanner.v1beta.ListScanRunsResponse listScanRuns(
        com.google.cloud.websecurityscanner.v1beta.ListScanRunsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListScanRunsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Stops a ScanRun. The stopped ScanRun is returned.
     * </pre>
     */
    public com.google.cloud.websecurityscanner.v1beta.ScanRun stopScanRun(
        com.google.cloud.websecurityscanner.v1beta.StopScanRunRequest request) {
      return blockingUnaryCall(
          getChannel(), getStopScanRunMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List CrawledUrls under a given ScanRun.
     * </pre>
     */
    public com.google.cloud.websecurityscanner.v1beta.ListCrawledUrlsResponse listCrawledUrls(
        com.google.cloud.websecurityscanner.v1beta.ListCrawledUrlsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListCrawledUrlsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a Finding.
     * </pre>
     */
    public com.google.cloud.websecurityscanner.v1beta.Finding getFinding(
        com.google.cloud.websecurityscanner.v1beta.GetFindingRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetFindingMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List Findings under a given ScanRun.
     * </pre>
     */
    public com.google.cloud.websecurityscanner.v1beta.ListFindingsResponse listFindings(
        com.google.cloud.websecurityscanner.v1beta.ListFindingsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListFindingsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all FindingTypeStats under a given ScanRun.
     * </pre>
     */
    public com.google.cloud.websecurityscanner.v1beta.ListFindingTypeStatsResponse
        listFindingTypeStats(
            com.google.cloud.websecurityscanner.v1beta.ListFindingTypeStatsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListFindingTypeStatsMethodHelper(), getCallOptions(), request);
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
      extends io.grpc.stub.AbstractStub<WebSecurityScannerFutureStub> {
    private WebSecurityScannerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

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
            com.google.cloud.websecurityscanner.v1beta.ScanConfig>
        createScanConfig(
            com.google.cloud.websecurityscanner.v1beta.CreateScanConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateScanConfigMethodHelper(), getCallOptions()), request);
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
            com.google.cloud.websecurityscanner.v1beta.DeleteScanConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteScanConfigMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a ScanConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.websecurityscanner.v1beta.ScanConfig>
        getScanConfig(com.google.cloud.websecurityscanner.v1beta.GetScanConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetScanConfigMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ScanConfigs under a given project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.websecurityscanner.v1beta.ListScanConfigsResponse>
        listScanConfigs(com.google.cloud.websecurityscanner.v1beta.ListScanConfigsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListScanConfigsMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a ScanConfig. This method support partial update of a ScanConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.websecurityscanner.v1beta.ScanConfig>
        updateScanConfig(
            com.google.cloud.websecurityscanner.v1beta.UpdateScanConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateScanConfigMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Start a ScanRun according to the given ScanConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.websecurityscanner.v1beta.ScanRun>
        startScanRun(com.google.cloud.websecurityscanner.v1beta.StartScanRunRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getStartScanRunMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a ScanRun.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.websecurityscanner.v1beta.ScanRun>
        getScanRun(com.google.cloud.websecurityscanner.v1beta.GetScanRunRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetScanRunMethodHelper(), getCallOptions()), request);
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
            com.google.cloud.websecurityscanner.v1beta.ListScanRunsResponse>
        listScanRuns(com.google.cloud.websecurityscanner.v1beta.ListScanRunsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListScanRunsMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Stops a ScanRun. The stopped ScanRun is returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.websecurityscanner.v1beta.ScanRun>
        stopScanRun(com.google.cloud.websecurityscanner.v1beta.StopScanRunRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getStopScanRunMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List CrawledUrls under a given ScanRun.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.websecurityscanner.v1beta.ListCrawledUrlsResponse>
        listCrawledUrls(com.google.cloud.websecurityscanner.v1beta.ListCrawledUrlsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListCrawledUrlsMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a Finding.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.websecurityscanner.v1beta.Finding>
        getFinding(com.google.cloud.websecurityscanner.v1beta.GetFindingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetFindingMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List Findings under a given ScanRun.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.websecurityscanner.v1beta.ListFindingsResponse>
        listFindings(com.google.cloud.websecurityscanner.v1beta.ListFindingsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListFindingsMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List all FindingTypeStats under a given ScanRun.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.websecurityscanner.v1beta.ListFindingTypeStatsResponse>
        listFindingTypeStats(
            com.google.cloud.websecurityscanner.v1beta.ListFindingTypeStatsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListFindingTypeStatsMethodHelper(), getCallOptions()), request);
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
              (com.google.cloud.websecurityscanner.v1beta.CreateScanConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1beta.ScanConfig>)
                  responseObserver);
          break;
        case METHODID_DELETE_SCAN_CONFIG:
          serviceImpl.deleteScanConfig(
              (com.google.cloud.websecurityscanner.v1beta.DeleteScanConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_SCAN_CONFIG:
          serviceImpl.getScanConfig(
              (com.google.cloud.websecurityscanner.v1beta.GetScanConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1beta.ScanConfig>)
                  responseObserver);
          break;
        case METHODID_LIST_SCAN_CONFIGS:
          serviceImpl.listScanConfigs(
              (com.google.cloud.websecurityscanner.v1beta.ListScanConfigsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.websecurityscanner.v1beta.ListScanConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SCAN_CONFIG:
          serviceImpl.updateScanConfig(
              (com.google.cloud.websecurityscanner.v1beta.UpdateScanConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1beta.ScanConfig>)
                  responseObserver);
          break;
        case METHODID_START_SCAN_RUN:
          serviceImpl.startScanRun(
              (com.google.cloud.websecurityscanner.v1beta.StartScanRunRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1beta.ScanRun>)
                  responseObserver);
          break;
        case METHODID_GET_SCAN_RUN:
          serviceImpl.getScanRun(
              (com.google.cloud.websecurityscanner.v1beta.GetScanRunRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1beta.ScanRun>)
                  responseObserver);
          break;
        case METHODID_LIST_SCAN_RUNS:
          serviceImpl.listScanRuns(
              (com.google.cloud.websecurityscanner.v1beta.ListScanRunsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.websecurityscanner.v1beta.ListScanRunsResponse>)
                  responseObserver);
          break;
        case METHODID_STOP_SCAN_RUN:
          serviceImpl.stopScanRun(
              (com.google.cloud.websecurityscanner.v1beta.StopScanRunRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1beta.ScanRun>)
                  responseObserver);
          break;
        case METHODID_LIST_CRAWLED_URLS:
          serviceImpl.listCrawledUrls(
              (com.google.cloud.websecurityscanner.v1beta.ListCrawledUrlsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.websecurityscanner.v1beta.ListCrawledUrlsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_FINDING:
          serviceImpl.getFinding(
              (com.google.cloud.websecurityscanner.v1beta.GetFindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.websecurityscanner.v1beta.Finding>)
                  responseObserver);
          break;
        case METHODID_LIST_FINDINGS:
          serviceImpl.listFindings(
              (com.google.cloud.websecurityscanner.v1beta.ListFindingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.websecurityscanner.v1beta.ListFindingsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_FINDING_TYPE_STATS:
          serviceImpl.listFindingTypeStats(
              (com.google.cloud.websecurityscanner.v1beta.ListFindingTypeStatsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.websecurityscanner.v1beta.ListFindingTypeStatsResponse>)
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
      return com.google.cloud.websecurityscanner.v1beta.WebSecurityScannerProto.getDescriptor();
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
                      .addMethod(getCreateScanConfigMethodHelper())
                      .addMethod(getDeleteScanConfigMethodHelper())
                      .addMethod(getGetScanConfigMethodHelper())
                      .addMethod(getListScanConfigsMethodHelper())
                      .addMethod(getUpdateScanConfigMethodHelper())
                      .addMethod(getStartScanRunMethodHelper())
                      .addMethod(getGetScanRunMethodHelper())
                      .addMethod(getListScanRunsMethodHelper())
                      .addMethod(getStopScanRunMethodHelper())
                      .addMethod(getListCrawledUrlsMethodHelper())
                      .addMethod(getGetFindingMethodHelper())
                      .addMethod(getListFindingsMethodHelper())
                      .addMethod(getListFindingTypeStatsMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
