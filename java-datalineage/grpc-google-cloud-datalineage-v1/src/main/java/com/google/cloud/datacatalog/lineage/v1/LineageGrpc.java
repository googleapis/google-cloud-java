/*
 * Copyright 2023 Google LLC
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
package com.google.cloud.datacatalog.lineage.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Lineage is used to track data flows between assets over time. You can
 * create [LineageEvents][google.cloud.datacatalog.lineage.v1.LineageEvent]
 * to record lineage between multiple sources and a single target, for
 * example, when table data is based on data from multiple tables.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/datacatalog/lineage/v1/lineage.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LineageGrpc {

  private LineageGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.datacatalog.lineage.v1.Lineage";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.v1.CreateProcessRequest,
          com.google.cloud.datacatalog.lineage.v1.Process>
      getCreateProcessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateProcess",
      requestType = com.google.cloud.datacatalog.lineage.v1.CreateProcessRequest.class,
      responseType = com.google.cloud.datacatalog.lineage.v1.Process.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.v1.CreateProcessRequest,
          com.google.cloud.datacatalog.lineage.v1.Process>
      getCreateProcessMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.lineage.v1.CreateProcessRequest,
            com.google.cloud.datacatalog.lineage.v1.Process>
        getCreateProcessMethod;
    if ((getCreateProcessMethod = LineageGrpc.getCreateProcessMethod) == null) {
      synchronized (LineageGrpc.class) {
        if ((getCreateProcessMethod = LineageGrpc.getCreateProcessMethod) == null) {
          LineageGrpc.getCreateProcessMethod =
              getCreateProcessMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.lineage.v1.CreateProcessRequest,
                          com.google.cloud.datacatalog.lineage.v1.Process>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateProcess"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.lineage.v1.CreateProcessRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.lineage.v1.Process.getDefaultInstance()))
                      .setSchemaDescriptor(new LineageMethodDescriptorSupplier("CreateProcess"))
                      .build();
        }
      }
    }
    return getCreateProcessMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.v1.UpdateProcessRequest,
          com.google.cloud.datacatalog.lineage.v1.Process>
      getUpdateProcessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateProcess",
      requestType = com.google.cloud.datacatalog.lineage.v1.UpdateProcessRequest.class,
      responseType = com.google.cloud.datacatalog.lineage.v1.Process.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.v1.UpdateProcessRequest,
          com.google.cloud.datacatalog.lineage.v1.Process>
      getUpdateProcessMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.lineage.v1.UpdateProcessRequest,
            com.google.cloud.datacatalog.lineage.v1.Process>
        getUpdateProcessMethod;
    if ((getUpdateProcessMethod = LineageGrpc.getUpdateProcessMethod) == null) {
      synchronized (LineageGrpc.class) {
        if ((getUpdateProcessMethod = LineageGrpc.getUpdateProcessMethod) == null) {
          LineageGrpc.getUpdateProcessMethod =
              getUpdateProcessMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.lineage.v1.UpdateProcessRequest,
                          com.google.cloud.datacatalog.lineage.v1.Process>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateProcess"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.lineage.v1.UpdateProcessRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.lineage.v1.Process.getDefaultInstance()))
                      .setSchemaDescriptor(new LineageMethodDescriptorSupplier("UpdateProcess"))
                      .build();
        }
      }
    }
    return getUpdateProcessMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.v1.GetProcessRequest,
          com.google.cloud.datacatalog.lineage.v1.Process>
      getGetProcessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProcess",
      requestType = com.google.cloud.datacatalog.lineage.v1.GetProcessRequest.class,
      responseType = com.google.cloud.datacatalog.lineage.v1.Process.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.v1.GetProcessRequest,
          com.google.cloud.datacatalog.lineage.v1.Process>
      getGetProcessMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.lineage.v1.GetProcessRequest,
            com.google.cloud.datacatalog.lineage.v1.Process>
        getGetProcessMethod;
    if ((getGetProcessMethod = LineageGrpc.getGetProcessMethod) == null) {
      synchronized (LineageGrpc.class) {
        if ((getGetProcessMethod = LineageGrpc.getGetProcessMethod) == null) {
          LineageGrpc.getGetProcessMethod =
              getGetProcessMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.lineage.v1.GetProcessRequest,
                          com.google.cloud.datacatalog.lineage.v1.Process>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProcess"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.lineage.v1.GetProcessRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.lineage.v1.Process.getDefaultInstance()))
                      .setSchemaDescriptor(new LineageMethodDescriptorSupplier("GetProcess"))
                      .build();
        }
      }
    }
    return getGetProcessMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.v1.ListProcessesRequest,
          com.google.cloud.datacatalog.lineage.v1.ListProcessesResponse>
      getListProcessesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListProcesses",
      requestType = com.google.cloud.datacatalog.lineage.v1.ListProcessesRequest.class,
      responseType = com.google.cloud.datacatalog.lineage.v1.ListProcessesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.v1.ListProcessesRequest,
          com.google.cloud.datacatalog.lineage.v1.ListProcessesResponse>
      getListProcessesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.lineage.v1.ListProcessesRequest,
            com.google.cloud.datacatalog.lineage.v1.ListProcessesResponse>
        getListProcessesMethod;
    if ((getListProcessesMethod = LineageGrpc.getListProcessesMethod) == null) {
      synchronized (LineageGrpc.class) {
        if ((getListProcessesMethod = LineageGrpc.getListProcessesMethod) == null) {
          LineageGrpc.getListProcessesMethod =
              getListProcessesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.lineage.v1.ListProcessesRequest,
                          com.google.cloud.datacatalog.lineage.v1.ListProcessesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListProcesses"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.lineage.v1.ListProcessesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.lineage.v1.ListProcessesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new LineageMethodDescriptorSupplier("ListProcesses"))
                      .build();
        }
      }
    }
    return getListProcessesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.v1.DeleteProcessRequest,
          com.google.longrunning.Operation>
      getDeleteProcessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteProcess",
      requestType = com.google.cloud.datacatalog.lineage.v1.DeleteProcessRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.v1.DeleteProcessRequest,
          com.google.longrunning.Operation>
      getDeleteProcessMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.lineage.v1.DeleteProcessRequest,
            com.google.longrunning.Operation>
        getDeleteProcessMethod;
    if ((getDeleteProcessMethod = LineageGrpc.getDeleteProcessMethod) == null) {
      synchronized (LineageGrpc.class) {
        if ((getDeleteProcessMethod = LineageGrpc.getDeleteProcessMethod) == null) {
          LineageGrpc.getDeleteProcessMethod =
              getDeleteProcessMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.lineage.v1.DeleteProcessRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteProcess"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.lineage.v1.DeleteProcessRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new LineageMethodDescriptorSupplier("DeleteProcess"))
                      .build();
        }
      }
    }
    return getDeleteProcessMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.v1.CreateRunRequest,
          com.google.cloud.datacatalog.lineage.v1.Run>
      getCreateRunMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRun",
      requestType = com.google.cloud.datacatalog.lineage.v1.CreateRunRequest.class,
      responseType = com.google.cloud.datacatalog.lineage.v1.Run.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.v1.CreateRunRequest,
          com.google.cloud.datacatalog.lineage.v1.Run>
      getCreateRunMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.lineage.v1.CreateRunRequest,
            com.google.cloud.datacatalog.lineage.v1.Run>
        getCreateRunMethod;
    if ((getCreateRunMethod = LineageGrpc.getCreateRunMethod) == null) {
      synchronized (LineageGrpc.class) {
        if ((getCreateRunMethod = LineageGrpc.getCreateRunMethod) == null) {
          LineageGrpc.getCreateRunMethod =
              getCreateRunMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.lineage.v1.CreateRunRequest,
                          com.google.cloud.datacatalog.lineage.v1.Run>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRun"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.lineage.v1.CreateRunRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.lineage.v1.Run.getDefaultInstance()))
                      .setSchemaDescriptor(new LineageMethodDescriptorSupplier("CreateRun"))
                      .build();
        }
      }
    }
    return getCreateRunMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.v1.UpdateRunRequest,
          com.google.cloud.datacatalog.lineage.v1.Run>
      getUpdateRunMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateRun",
      requestType = com.google.cloud.datacatalog.lineage.v1.UpdateRunRequest.class,
      responseType = com.google.cloud.datacatalog.lineage.v1.Run.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.v1.UpdateRunRequest,
          com.google.cloud.datacatalog.lineage.v1.Run>
      getUpdateRunMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.lineage.v1.UpdateRunRequest,
            com.google.cloud.datacatalog.lineage.v1.Run>
        getUpdateRunMethod;
    if ((getUpdateRunMethod = LineageGrpc.getUpdateRunMethod) == null) {
      synchronized (LineageGrpc.class) {
        if ((getUpdateRunMethod = LineageGrpc.getUpdateRunMethod) == null) {
          LineageGrpc.getUpdateRunMethod =
              getUpdateRunMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.lineage.v1.UpdateRunRequest,
                          com.google.cloud.datacatalog.lineage.v1.Run>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateRun"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.lineage.v1.UpdateRunRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.lineage.v1.Run.getDefaultInstance()))
                      .setSchemaDescriptor(new LineageMethodDescriptorSupplier("UpdateRun"))
                      .build();
        }
      }
    }
    return getUpdateRunMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.v1.GetRunRequest,
          com.google.cloud.datacatalog.lineage.v1.Run>
      getGetRunMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRun",
      requestType = com.google.cloud.datacatalog.lineage.v1.GetRunRequest.class,
      responseType = com.google.cloud.datacatalog.lineage.v1.Run.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.v1.GetRunRequest,
          com.google.cloud.datacatalog.lineage.v1.Run>
      getGetRunMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.lineage.v1.GetRunRequest,
            com.google.cloud.datacatalog.lineage.v1.Run>
        getGetRunMethod;
    if ((getGetRunMethod = LineageGrpc.getGetRunMethod) == null) {
      synchronized (LineageGrpc.class) {
        if ((getGetRunMethod = LineageGrpc.getGetRunMethod) == null) {
          LineageGrpc.getGetRunMethod =
              getGetRunMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.lineage.v1.GetRunRequest,
                          com.google.cloud.datacatalog.lineage.v1.Run>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRun"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.lineage.v1.GetRunRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.lineage.v1.Run.getDefaultInstance()))
                      .setSchemaDescriptor(new LineageMethodDescriptorSupplier("GetRun"))
                      .build();
        }
      }
    }
    return getGetRunMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.v1.ListRunsRequest,
          com.google.cloud.datacatalog.lineage.v1.ListRunsResponse>
      getListRunsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRuns",
      requestType = com.google.cloud.datacatalog.lineage.v1.ListRunsRequest.class,
      responseType = com.google.cloud.datacatalog.lineage.v1.ListRunsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.v1.ListRunsRequest,
          com.google.cloud.datacatalog.lineage.v1.ListRunsResponse>
      getListRunsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.lineage.v1.ListRunsRequest,
            com.google.cloud.datacatalog.lineage.v1.ListRunsResponse>
        getListRunsMethod;
    if ((getListRunsMethod = LineageGrpc.getListRunsMethod) == null) {
      synchronized (LineageGrpc.class) {
        if ((getListRunsMethod = LineageGrpc.getListRunsMethod) == null) {
          LineageGrpc.getListRunsMethod =
              getListRunsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.lineage.v1.ListRunsRequest,
                          com.google.cloud.datacatalog.lineage.v1.ListRunsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRuns"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.lineage.v1.ListRunsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.lineage.v1.ListRunsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new LineageMethodDescriptorSupplier("ListRuns"))
                      .build();
        }
      }
    }
    return getListRunsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.v1.DeleteRunRequest,
          com.google.longrunning.Operation>
      getDeleteRunMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRun",
      requestType = com.google.cloud.datacatalog.lineage.v1.DeleteRunRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.v1.DeleteRunRequest,
          com.google.longrunning.Operation>
      getDeleteRunMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.lineage.v1.DeleteRunRequest,
            com.google.longrunning.Operation>
        getDeleteRunMethod;
    if ((getDeleteRunMethod = LineageGrpc.getDeleteRunMethod) == null) {
      synchronized (LineageGrpc.class) {
        if ((getDeleteRunMethod = LineageGrpc.getDeleteRunMethod) == null) {
          LineageGrpc.getDeleteRunMethod =
              getDeleteRunMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.lineage.v1.DeleteRunRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRun"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.lineage.v1.DeleteRunRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new LineageMethodDescriptorSupplier("DeleteRun"))
                      .build();
        }
      }
    }
    return getDeleteRunMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.v1.CreateLineageEventRequest,
          com.google.cloud.datacatalog.lineage.v1.LineageEvent>
      getCreateLineageEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateLineageEvent",
      requestType = com.google.cloud.datacatalog.lineage.v1.CreateLineageEventRequest.class,
      responseType = com.google.cloud.datacatalog.lineage.v1.LineageEvent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.v1.CreateLineageEventRequest,
          com.google.cloud.datacatalog.lineage.v1.LineageEvent>
      getCreateLineageEventMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.lineage.v1.CreateLineageEventRequest,
            com.google.cloud.datacatalog.lineage.v1.LineageEvent>
        getCreateLineageEventMethod;
    if ((getCreateLineageEventMethod = LineageGrpc.getCreateLineageEventMethod) == null) {
      synchronized (LineageGrpc.class) {
        if ((getCreateLineageEventMethod = LineageGrpc.getCreateLineageEventMethod) == null) {
          LineageGrpc.getCreateLineageEventMethod =
              getCreateLineageEventMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.lineage.v1.CreateLineageEventRequest,
                          com.google.cloud.datacatalog.lineage.v1.LineageEvent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateLineageEvent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.lineage.v1.CreateLineageEventRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.lineage.v1.LineageEvent
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LineageMethodDescriptorSupplier("CreateLineageEvent"))
                      .build();
        }
      }
    }
    return getCreateLineageEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.v1.GetLineageEventRequest,
          com.google.cloud.datacatalog.lineage.v1.LineageEvent>
      getGetLineageEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLineageEvent",
      requestType = com.google.cloud.datacatalog.lineage.v1.GetLineageEventRequest.class,
      responseType = com.google.cloud.datacatalog.lineage.v1.LineageEvent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.v1.GetLineageEventRequest,
          com.google.cloud.datacatalog.lineage.v1.LineageEvent>
      getGetLineageEventMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.lineage.v1.GetLineageEventRequest,
            com.google.cloud.datacatalog.lineage.v1.LineageEvent>
        getGetLineageEventMethod;
    if ((getGetLineageEventMethod = LineageGrpc.getGetLineageEventMethod) == null) {
      synchronized (LineageGrpc.class) {
        if ((getGetLineageEventMethod = LineageGrpc.getGetLineageEventMethod) == null) {
          LineageGrpc.getGetLineageEventMethod =
              getGetLineageEventMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.lineage.v1.GetLineageEventRequest,
                          com.google.cloud.datacatalog.lineage.v1.LineageEvent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLineageEvent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.lineage.v1.GetLineageEventRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.lineage.v1.LineageEvent
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new LineageMethodDescriptorSupplier("GetLineageEvent"))
                      .build();
        }
      }
    }
    return getGetLineageEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.v1.ListLineageEventsRequest,
          com.google.cloud.datacatalog.lineage.v1.ListLineageEventsResponse>
      getListLineageEventsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListLineageEvents",
      requestType = com.google.cloud.datacatalog.lineage.v1.ListLineageEventsRequest.class,
      responseType = com.google.cloud.datacatalog.lineage.v1.ListLineageEventsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.v1.ListLineageEventsRequest,
          com.google.cloud.datacatalog.lineage.v1.ListLineageEventsResponse>
      getListLineageEventsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.lineage.v1.ListLineageEventsRequest,
            com.google.cloud.datacatalog.lineage.v1.ListLineageEventsResponse>
        getListLineageEventsMethod;
    if ((getListLineageEventsMethod = LineageGrpc.getListLineageEventsMethod) == null) {
      synchronized (LineageGrpc.class) {
        if ((getListLineageEventsMethod = LineageGrpc.getListLineageEventsMethod) == null) {
          LineageGrpc.getListLineageEventsMethod =
              getListLineageEventsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.lineage.v1.ListLineageEventsRequest,
                          com.google.cloud.datacatalog.lineage.v1.ListLineageEventsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListLineageEvents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.lineage.v1.ListLineageEventsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.lineage.v1.ListLineageEventsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new LineageMethodDescriptorSupplier("ListLineageEvents"))
                      .build();
        }
      }
    }
    return getListLineageEventsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.v1.DeleteLineageEventRequest,
          com.google.protobuf.Empty>
      getDeleteLineageEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteLineageEvent",
      requestType = com.google.cloud.datacatalog.lineage.v1.DeleteLineageEventRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.v1.DeleteLineageEventRequest,
          com.google.protobuf.Empty>
      getDeleteLineageEventMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.lineage.v1.DeleteLineageEventRequest,
            com.google.protobuf.Empty>
        getDeleteLineageEventMethod;
    if ((getDeleteLineageEventMethod = LineageGrpc.getDeleteLineageEventMethod) == null) {
      synchronized (LineageGrpc.class) {
        if ((getDeleteLineageEventMethod = LineageGrpc.getDeleteLineageEventMethod) == null) {
          LineageGrpc.getDeleteLineageEventMethod =
              getDeleteLineageEventMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.lineage.v1.DeleteLineageEventRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteLineageEvent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.lineage.v1.DeleteLineageEventRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LineageMethodDescriptorSupplier("DeleteLineageEvent"))
                      .build();
        }
      }
    }
    return getDeleteLineageEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.v1.SearchLinksRequest,
          com.google.cloud.datacatalog.lineage.v1.SearchLinksResponse>
      getSearchLinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchLinks",
      requestType = com.google.cloud.datacatalog.lineage.v1.SearchLinksRequest.class,
      responseType = com.google.cloud.datacatalog.lineage.v1.SearchLinksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.v1.SearchLinksRequest,
          com.google.cloud.datacatalog.lineage.v1.SearchLinksResponse>
      getSearchLinksMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.lineage.v1.SearchLinksRequest,
            com.google.cloud.datacatalog.lineage.v1.SearchLinksResponse>
        getSearchLinksMethod;
    if ((getSearchLinksMethod = LineageGrpc.getSearchLinksMethod) == null) {
      synchronized (LineageGrpc.class) {
        if ((getSearchLinksMethod = LineageGrpc.getSearchLinksMethod) == null) {
          LineageGrpc.getSearchLinksMethod =
              getSearchLinksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.lineage.v1.SearchLinksRequest,
                          com.google.cloud.datacatalog.lineage.v1.SearchLinksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchLinks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.lineage.v1.SearchLinksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.lineage.v1.SearchLinksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new LineageMethodDescriptorSupplier("SearchLinks"))
                      .build();
        }
      }
    }
    return getSearchLinksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.v1.BatchSearchLinkProcessesRequest,
          com.google.cloud.datacatalog.lineage.v1.BatchSearchLinkProcessesResponse>
      getBatchSearchLinkProcessesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchSearchLinkProcesses",
      requestType = com.google.cloud.datacatalog.lineage.v1.BatchSearchLinkProcessesRequest.class,
      responseType = com.google.cloud.datacatalog.lineage.v1.BatchSearchLinkProcessesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.v1.BatchSearchLinkProcessesRequest,
          com.google.cloud.datacatalog.lineage.v1.BatchSearchLinkProcessesResponse>
      getBatchSearchLinkProcessesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.lineage.v1.BatchSearchLinkProcessesRequest,
            com.google.cloud.datacatalog.lineage.v1.BatchSearchLinkProcessesResponse>
        getBatchSearchLinkProcessesMethod;
    if ((getBatchSearchLinkProcessesMethod = LineageGrpc.getBatchSearchLinkProcessesMethod)
        == null) {
      synchronized (LineageGrpc.class) {
        if ((getBatchSearchLinkProcessesMethod = LineageGrpc.getBatchSearchLinkProcessesMethod)
            == null) {
          LineageGrpc.getBatchSearchLinkProcessesMethod =
              getBatchSearchLinkProcessesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.lineage.v1.BatchSearchLinkProcessesRequest,
                          com.google.cloud.datacatalog.lineage.v1.BatchSearchLinkProcessesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchSearchLinkProcesses"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.lineage.v1
                                  .BatchSearchLinkProcessesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.lineage.v1
                                  .BatchSearchLinkProcessesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LineageMethodDescriptorSupplier("BatchSearchLinkProcesses"))
                      .build();
        }
      }
    }
    return getBatchSearchLinkProcessesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static LineageStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LineageStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LineageStub>() {
          @java.lang.Override
          public LineageStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LineageStub(channel, callOptions);
          }
        };
    return LineageStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LineageBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LineageBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LineageBlockingStub>() {
          @java.lang.Override
          public LineageBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LineageBlockingStub(channel, callOptions);
          }
        };
    return LineageBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static LineageFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LineageFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LineageFutureStub>() {
          @java.lang.Override
          public LineageFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LineageFutureStub(channel, callOptions);
          }
        };
    return LineageFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Lineage is used to track data flows between assets over time. You can
   * create [LineageEvents][google.cloud.datacatalog.lineage.v1.LineageEvent]
   * to record lineage between multiple sources and a single target, for
   * example, when table data is based on data from multiple tables.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a new process.
     * </pre>
     */
    default void createProcess(
        com.google.cloud.datacatalog.lineage.v1.CreateProcessRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.v1.Process>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateProcessMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a process.
     * </pre>
     */
    default void updateProcess(
        com.google.cloud.datacatalog.lineage.v1.UpdateProcessRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.v1.Process>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateProcessMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of the specified process.
     * </pre>
     */
    default void getProcess(
        com.google.cloud.datacatalog.lineage.v1.GetProcessRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.v1.Process>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetProcessMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List processes in the given project and location. List order is descending
     * by insertion time.
     * </pre>
     */
    default void listProcesses(
        com.google.cloud.datacatalog.lineage.v1.ListProcessesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.v1.ListProcessesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListProcessesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the process with the specified name.
     * </pre>
     */
    default void deleteProcess(
        com.google.cloud.datacatalog.lineage.v1.DeleteProcessRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteProcessMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new run.
     * </pre>
     */
    default void createRun(
        com.google.cloud.datacatalog.lineage.v1.CreateRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.v1.Run> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateRunMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a run.
     * </pre>
     */
    default void updateRun(
        com.google.cloud.datacatalog.lineage.v1.UpdateRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.v1.Run> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateRunMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of the specified run.
     * </pre>
     */
    default void getRun(
        com.google.cloud.datacatalog.lineage.v1.GetRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.v1.Run> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRunMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists runs in the given project and location. List order is descending by
     * `start_time`.
     * </pre>
     */
    default void listRuns(
        com.google.cloud.datacatalog.lineage.v1.ListRunsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.v1.ListRunsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListRunsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the run with the specified name.
     * </pre>
     */
    default void deleteRun(
        com.google.cloud.datacatalog.lineage.v1.DeleteRunRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteRunMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new lineage event.
     * </pre>
     */
    default void createLineageEvent(
        com.google.cloud.datacatalog.lineage.v1.CreateLineageEventRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.v1.LineageEvent>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateLineageEventMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a specified lineage event.
     * </pre>
     */
    default void getLineageEvent(
        com.google.cloud.datacatalog.lineage.v1.GetLineageEventRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.v1.LineageEvent>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetLineageEventMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists lineage events in the given project and location. The list order is
     * not defined.
     * </pre>
     */
    default void listLineageEvents(
        com.google.cloud.datacatalog.lineage.v1.ListLineageEventsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.datacatalog.lineage.v1.ListLineageEventsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListLineageEventsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the lineage event with the specified name.
     * </pre>
     */
    default void deleteLineageEvent(
        com.google.cloud.datacatalog.lineage.v1.DeleteLineageEventRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteLineageEventMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a list of links connected to a specific asset.
     * Links represent the data flow between **source** (upstream)
     * and **target** (downstream) assets in transformation pipelines.
     * Links are stored in the same project as the Lineage Events that create
     * them.
     * You can retrieve links in every project where you have the
     * `datalineage.events.get` permission. The project provided in the URL
     * is used for Billing and Quota.
     * </pre>
     */
    default void searchLinks(
        com.google.cloud.datacatalog.lineage.v1.SearchLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.v1.SearchLinksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchLinksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve information about LineageProcesses associated with specific
     * links. LineageProcesses are transformation pipelines that result in data
     * flowing from **source** to **target** assets. Links between assets
     * represent this operation.
     * If you have specific link names, you can use this method to
     * verify which LineageProcesses contribute to creating those links.
     * See the
     * [SearchLinks][google.cloud.datacatalog.lineage.v1.Lineage.SearchLinks]
     * method for more information on how to retrieve link name.
     * You can retrieve the LineageProcess information in every project where you
     * have the `datalineage.events.get` permission. The project provided in the
     * URL is used for Billing and Quota.
     * </pre>
     */
    default void batchSearchLinkProcesses(
        com.google.cloud.datacatalog.lineage.v1.BatchSearchLinkProcessesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.datacatalog.lineage.v1.BatchSearchLinkProcessesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchSearchLinkProcessesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Lineage.
   *
   * <pre>
   * Lineage is used to track data flows between assets over time. You can
   * create [LineageEvents][google.cloud.datacatalog.lineage.v1.LineageEvent]
   * to record lineage between multiple sources and a single target, for
   * example, when table data is based on data from multiple tables.
   * </pre>
   */
  public abstract static class LineageImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return LineageGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Lineage.
   *
   * <pre>
   * Lineage is used to track data flows between assets over time. You can
   * create [LineageEvents][google.cloud.datacatalog.lineage.v1.LineageEvent]
   * to record lineage between multiple sources and a single target, for
   * example, when table data is based on data from multiple tables.
   * </pre>
   */
  public static final class LineageStub extends io.grpc.stub.AbstractAsyncStub<LineageStub> {
    private LineageStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LineageStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LineageStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new process.
     * </pre>
     */
    public void createProcess(
        com.google.cloud.datacatalog.lineage.v1.CreateProcessRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.v1.Process>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateProcessMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a process.
     * </pre>
     */
    public void updateProcess(
        com.google.cloud.datacatalog.lineage.v1.UpdateProcessRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.v1.Process>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateProcessMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of the specified process.
     * </pre>
     */
    public void getProcess(
        com.google.cloud.datacatalog.lineage.v1.GetProcessRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.v1.Process>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProcessMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List processes in the given project and location. List order is descending
     * by insertion time.
     * </pre>
     */
    public void listProcesses(
        com.google.cloud.datacatalog.lineage.v1.ListProcessesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.v1.ListProcessesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListProcessesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the process with the specified name.
     * </pre>
     */
    public void deleteProcess(
        com.google.cloud.datacatalog.lineage.v1.DeleteProcessRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteProcessMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new run.
     * </pre>
     */
    public void createRun(
        com.google.cloud.datacatalog.lineage.v1.CreateRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.v1.Run> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRunMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a run.
     * </pre>
     */
    public void updateRun(
        com.google.cloud.datacatalog.lineage.v1.UpdateRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.v1.Run> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateRunMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of the specified run.
     * </pre>
     */
    public void getRun(
        com.google.cloud.datacatalog.lineage.v1.GetRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.v1.Run> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRunMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists runs in the given project and location. List order is descending by
     * `start_time`.
     * </pre>
     */
    public void listRuns(
        com.google.cloud.datacatalog.lineage.v1.ListRunsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.v1.ListRunsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRunsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the run with the specified name.
     * </pre>
     */
    public void deleteRun(
        com.google.cloud.datacatalog.lineage.v1.DeleteRunRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRunMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new lineage event.
     * </pre>
     */
    public void createLineageEvent(
        com.google.cloud.datacatalog.lineage.v1.CreateLineageEventRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.v1.LineageEvent>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateLineageEventMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a specified lineage event.
     * </pre>
     */
    public void getLineageEvent(
        com.google.cloud.datacatalog.lineage.v1.GetLineageEventRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.v1.LineageEvent>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLineageEventMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists lineage events in the given project and location. The list order is
     * not defined.
     * </pre>
     */
    public void listLineageEvents(
        com.google.cloud.datacatalog.lineage.v1.ListLineageEventsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.datacatalog.lineage.v1.ListLineageEventsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListLineageEventsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the lineage event with the specified name.
     * </pre>
     */
    public void deleteLineageEvent(
        com.google.cloud.datacatalog.lineage.v1.DeleteLineageEventRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteLineageEventMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a list of links connected to a specific asset.
     * Links represent the data flow between **source** (upstream)
     * and **target** (downstream) assets in transformation pipelines.
     * Links are stored in the same project as the Lineage Events that create
     * them.
     * You can retrieve links in every project where you have the
     * `datalineage.events.get` permission. The project provided in the URL
     * is used for Billing and Quota.
     * </pre>
     */
    public void searchLinks(
        com.google.cloud.datacatalog.lineage.v1.SearchLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.v1.SearchLinksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchLinksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve information about LineageProcesses associated with specific
     * links. LineageProcesses are transformation pipelines that result in data
     * flowing from **source** to **target** assets. Links between assets
     * represent this operation.
     * If you have specific link names, you can use this method to
     * verify which LineageProcesses contribute to creating those links.
     * See the
     * [SearchLinks][google.cloud.datacatalog.lineage.v1.Lineage.SearchLinks]
     * method for more information on how to retrieve link name.
     * You can retrieve the LineageProcess information in every project where you
     * have the `datalineage.events.get` permission. The project provided in the
     * URL is used for Billing and Quota.
     * </pre>
     */
    public void batchSearchLinkProcesses(
        com.google.cloud.datacatalog.lineage.v1.BatchSearchLinkProcessesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.datacatalog.lineage.v1.BatchSearchLinkProcessesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchSearchLinkProcessesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Lineage.
   *
   * <pre>
   * Lineage is used to track data flows between assets over time. You can
   * create [LineageEvents][google.cloud.datacatalog.lineage.v1.LineageEvent]
   * to record lineage between multiple sources and a single target, for
   * example, when table data is based on data from multiple tables.
   * </pre>
   */
  public static final class LineageBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LineageBlockingStub> {
    private LineageBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LineageBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LineageBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new process.
     * </pre>
     */
    public com.google.cloud.datacatalog.lineage.v1.Process createProcess(
        com.google.cloud.datacatalog.lineage.v1.CreateProcessRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateProcessMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a process.
     * </pre>
     */
    public com.google.cloud.datacatalog.lineage.v1.Process updateProcess(
        com.google.cloud.datacatalog.lineage.v1.UpdateProcessRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateProcessMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of the specified process.
     * </pre>
     */
    public com.google.cloud.datacatalog.lineage.v1.Process getProcess(
        com.google.cloud.datacatalog.lineage.v1.GetProcessRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProcessMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List processes in the given project and location. List order is descending
     * by insertion time.
     * </pre>
     */
    public com.google.cloud.datacatalog.lineage.v1.ListProcessesResponse listProcesses(
        com.google.cloud.datacatalog.lineage.v1.ListProcessesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListProcessesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the process with the specified name.
     * </pre>
     */
    public com.google.longrunning.Operation deleteProcess(
        com.google.cloud.datacatalog.lineage.v1.DeleteProcessRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteProcessMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new run.
     * </pre>
     */
    public com.google.cloud.datacatalog.lineage.v1.Run createRun(
        com.google.cloud.datacatalog.lineage.v1.CreateRunRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRunMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a run.
     * </pre>
     */
    public com.google.cloud.datacatalog.lineage.v1.Run updateRun(
        com.google.cloud.datacatalog.lineage.v1.UpdateRunRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRunMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of the specified run.
     * </pre>
     */
    public com.google.cloud.datacatalog.lineage.v1.Run getRun(
        com.google.cloud.datacatalog.lineage.v1.GetRunRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRunMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists runs in the given project and location. List order is descending by
     * `start_time`.
     * </pre>
     */
    public com.google.cloud.datacatalog.lineage.v1.ListRunsResponse listRuns(
        com.google.cloud.datacatalog.lineage.v1.ListRunsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRunsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the run with the specified name.
     * </pre>
     */
    public com.google.longrunning.Operation deleteRun(
        com.google.cloud.datacatalog.lineage.v1.DeleteRunRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRunMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new lineage event.
     * </pre>
     */
    public com.google.cloud.datacatalog.lineage.v1.LineageEvent createLineageEvent(
        com.google.cloud.datacatalog.lineage.v1.CreateLineageEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateLineageEventMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a specified lineage event.
     * </pre>
     */
    public com.google.cloud.datacatalog.lineage.v1.LineageEvent getLineageEvent(
        com.google.cloud.datacatalog.lineage.v1.GetLineageEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLineageEventMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists lineage events in the given project and location. The list order is
     * not defined.
     * </pre>
     */
    public com.google.cloud.datacatalog.lineage.v1.ListLineageEventsResponse listLineageEvents(
        com.google.cloud.datacatalog.lineage.v1.ListLineageEventsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListLineageEventsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the lineage event with the specified name.
     * </pre>
     */
    public com.google.protobuf.Empty deleteLineageEvent(
        com.google.cloud.datacatalog.lineage.v1.DeleteLineageEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteLineageEventMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a list of links connected to a specific asset.
     * Links represent the data flow between **source** (upstream)
     * and **target** (downstream) assets in transformation pipelines.
     * Links are stored in the same project as the Lineage Events that create
     * them.
     * You can retrieve links in every project where you have the
     * `datalineage.events.get` permission. The project provided in the URL
     * is used for Billing and Quota.
     * </pre>
     */
    public com.google.cloud.datacatalog.lineage.v1.SearchLinksResponse searchLinks(
        com.google.cloud.datacatalog.lineage.v1.SearchLinksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchLinksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve information about LineageProcesses associated with specific
     * links. LineageProcesses are transformation pipelines that result in data
     * flowing from **source** to **target** assets. Links between assets
     * represent this operation.
     * If you have specific link names, you can use this method to
     * verify which LineageProcesses contribute to creating those links.
     * See the
     * [SearchLinks][google.cloud.datacatalog.lineage.v1.Lineage.SearchLinks]
     * method for more information on how to retrieve link name.
     * You can retrieve the LineageProcess information in every project where you
     * have the `datalineage.events.get` permission. The project provided in the
     * URL is used for Billing and Quota.
     * </pre>
     */
    public com.google.cloud.datacatalog.lineage.v1.BatchSearchLinkProcessesResponse
        batchSearchLinkProcesses(
            com.google.cloud.datacatalog.lineage.v1.BatchSearchLinkProcessesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchSearchLinkProcessesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Lineage.
   *
   * <pre>
   * Lineage is used to track data flows between assets over time. You can
   * create [LineageEvents][google.cloud.datacatalog.lineage.v1.LineageEvent]
   * to record lineage between multiple sources and a single target, for
   * example, when table data is based on data from multiple tables.
   * </pre>
   */
  public static final class LineageFutureStub
      extends io.grpc.stub.AbstractFutureStub<LineageFutureStub> {
    private LineageFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LineageFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LineageFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new process.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.lineage.v1.Process>
        createProcess(com.google.cloud.datacatalog.lineage.v1.CreateProcessRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateProcessMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a process.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.lineage.v1.Process>
        updateProcess(com.google.cloud.datacatalog.lineage.v1.UpdateProcessRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateProcessMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of the specified process.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.lineage.v1.Process>
        getProcess(com.google.cloud.datacatalog.lineage.v1.GetProcessRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProcessMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List processes in the given project and location. List order is descending
     * by insertion time.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.lineage.v1.ListProcessesResponse>
        listProcesses(com.google.cloud.datacatalog.lineage.v1.ListProcessesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListProcessesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the process with the specified name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteProcess(com.google.cloud.datacatalog.lineage.v1.DeleteProcessRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteProcessMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new run.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.lineage.v1.Run>
        createRun(com.google.cloud.datacatalog.lineage.v1.CreateRunRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRunMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a run.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.lineage.v1.Run>
        updateRun(com.google.cloud.datacatalog.lineage.v1.UpdateRunRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateRunMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of the specified run.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.lineage.v1.Run>
        getRun(com.google.cloud.datacatalog.lineage.v1.GetRunRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRunMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists runs in the given project and location. List order is descending by
     * `start_time`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.lineage.v1.ListRunsResponse>
        listRuns(com.google.cloud.datacatalog.lineage.v1.ListRunsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRunsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the run with the specified name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteRun(com.google.cloud.datacatalog.lineage.v1.DeleteRunRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRunMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new lineage event.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.lineage.v1.LineageEvent>
        createLineageEvent(
            com.google.cloud.datacatalog.lineage.v1.CreateLineageEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateLineageEventMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a specified lineage event.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.lineage.v1.LineageEvent>
        getLineageEvent(com.google.cloud.datacatalog.lineage.v1.GetLineageEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLineageEventMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists lineage events in the given project and location. The list order is
     * not defined.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.lineage.v1.ListLineageEventsResponse>
        listLineageEvents(
            com.google.cloud.datacatalog.lineage.v1.ListLineageEventsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListLineageEventsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the lineage event with the specified name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteLineageEvent(
            com.google.cloud.datacatalog.lineage.v1.DeleteLineageEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteLineageEventMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a list of links connected to a specific asset.
     * Links represent the data flow between **source** (upstream)
     * and **target** (downstream) assets in transformation pipelines.
     * Links are stored in the same project as the Lineage Events that create
     * them.
     * You can retrieve links in every project where you have the
     * `datalineage.events.get` permission. The project provided in the URL
     * is used for Billing and Quota.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.lineage.v1.SearchLinksResponse>
        searchLinks(com.google.cloud.datacatalog.lineage.v1.SearchLinksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchLinksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve information about LineageProcesses associated with specific
     * links. LineageProcesses are transformation pipelines that result in data
     * flowing from **source** to **target** assets. Links between assets
     * represent this operation.
     * If you have specific link names, you can use this method to
     * verify which LineageProcesses contribute to creating those links.
     * See the
     * [SearchLinks][google.cloud.datacatalog.lineage.v1.Lineage.SearchLinks]
     * method for more information on how to retrieve link name.
     * You can retrieve the LineageProcess information in every project where you
     * have the `datalineage.events.get` permission. The project provided in the
     * URL is used for Billing and Quota.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.lineage.v1.BatchSearchLinkProcessesResponse>
        batchSearchLinkProcesses(
            com.google.cloud.datacatalog.lineage.v1.BatchSearchLinkProcessesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchSearchLinkProcessesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_PROCESS = 0;
  private static final int METHODID_UPDATE_PROCESS = 1;
  private static final int METHODID_GET_PROCESS = 2;
  private static final int METHODID_LIST_PROCESSES = 3;
  private static final int METHODID_DELETE_PROCESS = 4;
  private static final int METHODID_CREATE_RUN = 5;
  private static final int METHODID_UPDATE_RUN = 6;
  private static final int METHODID_GET_RUN = 7;
  private static final int METHODID_LIST_RUNS = 8;
  private static final int METHODID_DELETE_RUN = 9;
  private static final int METHODID_CREATE_LINEAGE_EVENT = 10;
  private static final int METHODID_GET_LINEAGE_EVENT = 11;
  private static final int METHODID_LIST_LINEAGE_EVENTS = 12;
  private static final int METHODID_DELETE_LINEAGE_EVENT = 13;
  private static final int METHODID_SEARCH_LINKS = 14;
  private static final int METHODID_BATCH_SEARCH_LINK_PROCESSES = 15;

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
        case METHODID_CREATE_PROCESS:
          serviceImpl.createProcess(
              (com.google.cloud.datacatalog.lineage.v1.CreateProcessRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.v1.Process>)
                  responseObserver);
          break;
        case METHODID_UPDATE_PROCESS:
          serviceImpl.updateProcess(
              (com.google.cloud.datacatalog.lineage.v1.UpdateProcessRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.v1.Process>)
                  responseObserver);
          break;
        case METHODID_GET_PROCESS:
          serviceImpl.getProcess(
              (com.google.cloud.datacatalog.lineage.v1.GetProcessRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.v1.Process>)
                  responseObserver);
          break;
        case METHODID_LIST_PROCESSES:
          serviceImpl.listProcesses(
              (com.google.cloud.datacatalog.lineage.v1.ListProcessesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.datacatalog.lineage.v1.ListProcessesResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_PROCESS:
          serviceImpl.deleteProcess(
              (com.google.cloud.datacatalog.lineage.v1.DeleteProcessRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_RUN:
          serviceImpl.createRun(
              (com.google.cloud.datacatalog.lineage.v1.CreateRunRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.v1.Run>)
                  responseObserver);
          break;
        case METHODID_UPDATE_RUN:
          serviceImpl.updateRun(
              (com.google.cloud.datacatalog.lineage.v1.UpdateRunRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.v1.Run>)
                  responseObserver);
          break;
        case METHODID_GET_RUN:
          serviceImpl.getRun(
              (com.google.cloud.datacatalog.lineage.v1.GetRunRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.v1.Run>)
                  responseObserver);
          break;
        case METHODID_LIST_RUNS:
          serviceImpl.listRuns(
              (com.google.cloud.datacatalog.lineage.v1.ListRunsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.datacatalog.lineage.v1.ListRunsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_RUN:
          serviceImpl.deleteRun(
              (com.google.cloud.datacatalog.lineage.v1.DeleteRunRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_LINEAGE_EVENT:
          serviceImpl.createLineageEvent(
              (com.google.cloud.datacatalog.lineage.v1.CreateLineageEventRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.v1.LineageEvent>)
                  responseObserver);
          break;
        case METHODID_GET_LINEAGE_EVENT:
          serviceImpl.getLineageEvent(
              (com.google.cloud.datacatalog.lineage.v1.GetLineageEventRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.v1.LineageEvent>)
                  responseObserver);
          break;
        case METHODID_LIST_LINEAGE_EVENTS:
          serviceImpl.listLineageEvents(
              (com.google.cloud.datacatalog.lineage.v1.ListLineageEventsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.datacatalog.lineage.v1.ListLineageEventsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_LINEAGE_EVENT:
          serviceImpl.deleteLineageEvent(
              (com.google.cloud.datacatalog.lineage.v1.DeleteLineageEventRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_SEARCH_LINKS:
          serviceImpl.searchLinks(
              (com.google.cloud.datacatalog.lineage.v1.SearchLinksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.datacatalog.lineage.v1.SearchLinksResponse>)
                  responseObserver);
          break;
        case METHODID_BATCH_SEARCH_LINK_PROCESSES:
          serviceImpl.batchSearchLinkProcesses(
              (com.google.cloud.datacatalog.lineage.v1.BatchSearchLinkProcessesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.datacatalog.lineage.v1.BatchSearchLinkProcessesResponse>)
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
            getCreateProcessMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.datacatalog.lineage.v1.CreateProcessRequest,
                    com.google.cloud.datacatalog.lineage.v1.Process>(
                    service, METHODID_CREATE_PROCESS)))
        .addMethod(
            getUpdateProcessMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.datacatalog.lineage.v1.UpdateProcessRequest,
                    com.google.cloud.datacatalog.lineage.v1.Process>(
                    service, METHODID_UPDATE_PROCESS)))
        .addMethod(
            getGetProcessMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.datacatalog.lineage.v1.GetProcessRequest,
                    com.google.cloud.datacatalog.lineage.v1.Process>(
                    service, METHODID_GET_PROCESS)))
        .addMethod(
            getListProcessesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.datacatalog.lineage.v1.ListProcessesRequest,
                    com.google.cloud.datacatalog.lineage.v1.ListProcessesResponse>(
                    service, METHODID_LIST_PROCESSES)))
        .addMethod(
            getDeleteProcessMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.datacatalog.lineage.v1.DeleteProcessRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_PROCESS)))
        .addMethod(
            getCreateRunMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.datacatalog.lineage.v1.CreateRunRequest,
                    com.google.cloud.datacatalog.lineage.v1.Run>(service, METHODID_CREATE_RUN)))
        .addMethod(
            getUpdateRunMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.datacatalog.lineage.v1.UpdateRunRequest,
                    com.google.cloud.datacatalog.lineage.v1.Run>(service, METHODID_UPDATE_RUN)))
        .addMethod(
            getGetRunMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.datacatalog.lineage.v1.GetRunRequest,
                    com.google.cloud.datacatalog.lineage.v1.Run>(service, METHODID_GET_RUN)))
        .addMethod(
            getListRunsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.datacatalog.lineage.v1.ListRunsRequest,
                    com.google.cloud.datacatalog.lineage.v1.ListRunsResponse>(
                    service, METHODID_LIST_RUNS)))
        .addMethod(
            getDeleteRunMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.datacatalog.lineage.v1.DeleteRunRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_RUN)))
        .addMethod(
            getCreateLineageEventMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.datacatalog.lineage.v1.CreateLineageEventRequest,
                    com.google.cloud.datacatalog.lineage.v1.LineageEvent>(
                    service, METHODID_CREATE_LINEAGE_EVENT)))
        .addMethod(
            getGetLineageEventMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.datacatalog.lineage.v1.GetLineageEventRequest,
                    com.google.cloud.datacatalog.lineage.v1.LineageEvent>(
                    service, METHODID_GET_LINEAGE_EVENT)))
        .addMethod(
            getListLineageEventsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.datacatalog.lineage.v1.ListLineageEventsRequest,
                    com.google.cloud.datacatalog.lineage.v1.ListLineageEventsResponse>(
                    service, METHODID_LIST_LINEAGE_EVENTS)))
        .addMethod(
            getDeleteLineageEventMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.datacatalog.lineage.v1.DeleteLineageEventRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_LINEAGE_EVENT)))
        .addMethod(
            getSearchLinksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.datacatalog.lineage.v1.SearchLinksRequest,
                    com.google.cloud.datacatalog.lineage.v1.SearchLinksResponse>(
                    service, METHODID_SEARCH_LINKS)))
        .addMethod(
            getBatchSearchLinkProcessesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.datacatalog.lineage.v1.BatchSearchLinkProcessesRequest,
                    com.google.cloud.datacatalog.lineage.v1.BatchSearchLinkProcessesResponse>(
                    service, METHODID_BATCH_SEARCH_LINK_PROCESSES)))
        .build();
  }

  private abstract static class LineageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LineageBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.datacatalog.lineage.v1.LineageProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Lineage");
    }
  }

  private static final class LineageFileDescriptorSupplier extends LineageBaseDescriptorSupplier {
    LineageFileDescriptorSupplier() {}
  }

  private static final class LineageMethodDescriptorSupplier extends LineageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    LineageMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (LineageGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new LineageFileDescriptorSupplier())
                      .addMethod(getCreateProcessMethod())
                      .addMethod(getUpdateProcessMethod())
                      .addMethod(getGetProcessMethod())
                      .addMethod(getListProcessesMethod())
                      .addMethod(getDeleteProcessMethod())
                      .addMethod(getCreateRunMethod())
                      .addMethod(getUpdateRunMethod())
                      .addMethod(getGetRunMethod())
                      .addMethod(getListRunsMethod())
                      .addMethod(getDeleteRunMethod())
                      .addMethod(getCreateLineageEventMethod())
                      .addMethod(getGetLineageEventMethod())
                      .addMethod(getListLineageEventsMethod())
                      .addMethod(getDeleteLineageEventMethod())
                      .addMethod(getSearchLinksMethod())
                      .addMethod(getBatchSearchLinkProcessesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
