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
package com.google.cloud.dialogflow.cx.v3beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing
 * [Playbooks][google.cloud.dialogflow.cx.v3beta1.Playbook].
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class PlaybooksGrpc {

  private PlaybooksGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.dialogflow.cx.v3beta1.Playbooks";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookRequest,
          com.google.cloud.dialogflow.cx.v3beta1.Playbook>
      getCreatePlaybookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePlaybook",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.Playbook.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookRequest,
          com.google.cloud.dialogflow.cx.v3beta1.Playbook>
      getCreatePlaybookMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookRequest,
            com.google.cloud.dialogflow.cx.v3beta1.Playbook>
        getCreatePlaybookMethod;
    if ((getCreatePlaybookMethod = PlaybooksGrpc.getCreatePlaybookMethod) == null) {
      synchronized (PlaybooksGrpc.class) {
        if ((getCreatePlaybookMethod = PlaybooksGrpc.getCreatePlaybookMethod) == null) {
          PlaybooksGrpc.getCreatePlaybookMethod =
              getCreatePlaybookMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.Playbook>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePlaybook"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.Playbook.getDefaultInstance()))
                      .setSchemaDescriptor(new PlaybooksMethodDescriptorSupplier("CreatePlaybook"))
                      .build();
        }
      }
    }
    return getCreatePlaybookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookRequest, com.google.protobuf.Empty>
      getDeletePlaybookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePlaybook",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookRequest, com.google.protobuf.Empty>
      getDeletePlaybookMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookRequest, com.google.protobuf.Empty>
        getDeletePlaybookMethod;
    if ((getDeletePlaybookMethod = PlaybooksGrpc.getDeletePlaybookMethod) == null) {
      synchronized (PlaybooksGrpc.class) {
        if ((getDeletePlaybookMethod = PlaybooksGrpc.getDeletePlaybookMethod) == null) {
          PlaybooksGrpc.getDeletePlaybookMethod =
              getDeletePlaybookMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeletePlaybook"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new PlaybooksMethodDescriptorSupplier("DeletePlaybook"))
                      .build();
        }
      }
    }
    return getDeletePlaybookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksRequest,
          com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksResponse>
      getListPlaybooksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPlaybooks",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksRequest,
          com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksResponse>
      getListPlaybooksMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksRequest,
            com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksResponse>
        getListPlaybooksMethod;
    if ((getListPlaybooksMethod = PlaybooksGrpc.getListPlaybooksMethod) == null) {
      synchronized (PlaybooksGrpc.class) {
        if ((getListPlaybooksMethod = PlaybooksGrpc.getListPlaybooksMethod) == null) {
          PlaybooksGrpc.getListPlaybooksMethod =
              getListPlaybooksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPlaybooks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new PlaybooksMethodDescriptorSupplier("ListPlaybooks"))
                      .build();
        }
      }
    }
    return getListPlaybooksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookRequest,
          com.google.cloud.dialogflow.cx.v3beta1.Playbook>
      getGetPlaybookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPlaybook",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.Playbook.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookRequest,
          com.google.cloud.dialogflow.cx.v3beta1.Playbook>
      getGetPlaybookMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookRequest,
            com.google.cloud.dialogflow.cx.v3beta1.Playbook>
        getGetPlaybookMethod;
    if ((getGetPlaybookMethod = PlaybooksGrpc.getGetPlaybookMethod) == null) {
      synchronized (PlaybooksGrpc.class) {
        if ((getGetPlaybookMethod = PlaybooksGrpc.getGetPlaybookMethod) == null) {
          PlaybooksGrpc.getGetPlaybookMethod =
              getGetPlaybookMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.Playbook>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPlaybook"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.Playbook.getDefaultInstance()))
                      .setSchemaDescriptor(new PlaybooksMethodDescriptorSupplier("GetPlaybook"))
                      .build();
        }
      }
    }
    return getGetPlaybookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.ExportPlaybookRequest,
          com.google.longrunning.Operation>
      getExportPlaybookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportPlaybook",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.ExportPlaybookRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.ExportPlaybookRequest,
          com.google.longrunning.Operation>
      getExportPlaybookMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.ExportPlaybookRequest,
            com.google.longrunning.Operation>
        getExportPlaybookMethod;
    if ((getExportPlaybookMethod = PlaybooksGrpc.getExportPlaybookMethod) == null) {
      synchronized (PlaybooksGrpc.class) {
        if ((getExportPlaybookMethod = PlaybooksGrpc.getExportPlaybookMethod) == null) {
          PlaybooksGrpc.getExportPlaybookMethod =
              getExportPlaybookMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.ExportPlaybookRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportPlaybook"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.ExportPlaybookRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new PlaybooksMethodDescriptorSupplier("ExportPlaybook"))
                      .build();
        }
      }
    }
    return getExportPlaybookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.ImportPlaybookRequest,
          com.google.longrunning.Operation>
      getImportPlaybookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportPlaybook",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.ImportPlaybookRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.ImportPlaybookRequest,
          com.google.longrunning.Operation>
      getImportPlaybookMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.ImportPlaybookRequest,
            com.google.longrunning.Operation>
        getImportPlaybookMethod;
    if ((getImportPlaybookMethod = PlaybooksGrpc.getImportPlaybookMethod) == null) {
      synchronized (PlaybooksGrpc.class) {
        if ((getImportPlaybookMethod = PlaybooksGrpc.getImportPlaybookMethod) == null) {
          PlaybooksGrpc.getImportPlaybookMethod =
              getImportPlaybookMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.ImportPlaybookRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportPlaybook"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.ImportPlaybookRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new PlaybooksMethodDescriptorSupplier("ImportPlaybook"))
                      .build();
        }
      }
    }
    return getImportPlaybookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.UpdatePlaybookRequest,
          com.google.cloud.dialogflow.cx.v3beta1.Playbook>
      getUpdatePlaybookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePlaybook",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.UpdatePlaybookRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.Playbook.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.UpdatePlaybookRequest,
          com.google.cloud.dialogflow.cx.v3beta1.Playbook>
      getUpdatePlaybookMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.UpdatePlaybookRequest,
            com.google.cloud.dialogflow.cx.v3beta1.Playbook>
        getUpdatePlaybookMethod;
    if ((getUpdatePlaybookMethod = PlaybooksGrpc.getUpdatePlaybookMethod) == null) {
      synchronized (PlaybooksGrpc.class) {
        if ((getUpdatePlaybookMethod = PlaybooksGrpc.getUpdatePlaybookMethod) == null) {
          PlaybooksGrpc.getUpdatePlaybookMethod =
              getUpdatePlaybookMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.UpdatePlaybookRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.Playbook>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdatePlaybook"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.UpdatePlaybookRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.Playbook.getDefaultInstance()))
                      .setSchemaDescriptor(new PlaybooksMethodDescriptorSupplier("UpdatePlaybook"))
                      .build();
        }
      }
    }
    return getUpdatePlaybookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookVersionRequest,
          com.google.cloud.dialogflow.cx.v3beta1.PlaybookVersion>
      getCreatePlaybookVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePlaybookVersion",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookVersionRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.PlaybookVersion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookVersionRequest,
          com.google.cloud.dialogflow.cx.v3beta1.PlaybookVersion>
      getCreatePlaybookVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookVersionRequest,
            com.google.cloud.dialogflow.cx.v3beta1.PlaybookVersion>
        getCreatePlaybookVersionMethod;
    if ((getCreatePlaybookVersionMethod = PlaybooksGrpc.getCreatePlaybookVersionMethod) == null) {
      synchronized (PlaybooksGrpc.class) {
        if ((getCreatePlaybookVersionMethod = PlaybooksGrpc.getCreatePlaybookVersionMethod)
            == null) {
          PlaybooksGrpc.getCreatePlaybookVersionMethod =
              getCreatePlaybookVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookVersionRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.PlaybookVersion>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreatePlaybookVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.PlaybookVersion
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PlaybooksMethodDescriptorSupplier("CreatePlaybookVersion"))
                      .build();
        }
      }
    }
    return getCreatePlaybookVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookVersionRequest,
          com.google.cloud.dialogflow.cx.v3beta1.PlaybookVersion>
      getGetPlaybookVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPlaybookVersion",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookVersionRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.PlaybookVersion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookVersionRequest,
          com.google.cloud.dialogflow.cx.v3beta1.PlaybookVersion>
      getGetPlaybookVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookVersionRequest,
            com.google.cloud.dialogflow.cx.v3beta1.PlaybookVersion>
        getGetPlaybookVersionMethod;
    if ((getGetPlaybookVersionMethod = PlaybooksGrpc.getGetPlaybookVersionMethod) == null) {
      synchronized (PlaybooksGrpc.class) {
        if ((getGetPlaybookVersionMethod = PlaybooksGrpc.getGetPlaybookVersionMethod) == null) {
          PlaybooksGrpc.getGetPlaybookVersionMethod =
              getGetPlaybookVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookVersionRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.PlaybookVersion>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPlaybookVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.PlaybookVersion
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PlaybooksMethodDescriptorSupplier("GetPlaybookVersion"))
                      .build();
        }
      }
    }
    return getGetPlaybookVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.RestorePlaybookVersionRequest,
          com.google.cloud.dialogflow.cx.v3beta1.RestorePlaybookVersionResponse>
      getRestorePlaybookVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RestorePlaybookVersion",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.RestorePlaybookVersionRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.RestorePlaybookVersionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.RestorePlaybookVersionRequest,
          com.google.cloud.dialogflow.cx.v3beta1.RestorePlaybookVersionResponse>
      getRestorePlaybookVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.RestorePlaybookVersionRequest,
            com.google.cloud.dialogflow.cx.v3beta1.RestorePlaybookVersionResponse>
        getRestorePlaybookVersionMethod;
    if ((getRestorePlaybookVersionMethod = PlaybooksGrpc.getRestorePlaybookVersionMethod) == null) {
      synchronized (PlaybooksGrpc.class) {
        if ((getRestorePlaybookVersionMethod = PlaybooksGrpc.getRestorePlaybookVersionMethod)
            == null) {
          PlaybooksGrpc.getRestorePlaybookVersionMethod =
              getRestorePlaybookVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.RestorePlaybookVersionRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.RestorePlaybookVersionResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RestorePlaybookVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.RestorePlaybookVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.RestorePlaybookVersionResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PlaybooksMethodDescriptorSupplier("RestorePlaybookVersion"))
                      .build();
        }
      }
    }
    return getRestorePlaybookVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsRequest,
          com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsResponse>
      getListPlaybookVersionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPlaybookVersions",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsRequest,
          com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsResponse>
      getListPlaybookVersionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsRequest,
            com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsResponse>
        getListPlaybookVersionsMethod;
    if ((getListPlaybookVersionsMethod = PlaybooksGrpc.getListPlaybookVersionsMethod) == null) {
      synchronized (PlaybooksGrpc.class) {
        if ((getListPlaybookVersionsMethod = PlaybooksGrpc.getListPlaybookVersionsMethod) == null) {
          PlaybooksGrpc.getListPlaybookVersionsMethod =
              getListPlaybookVersionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListPlaybookVersions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PlaybooksMethodDescriptorSupplier("ListPlaybookVersions"))
                      .build();
        }
      }
    }
    return getListPlaybookVersionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookVersionRequest,
          com.google.protobuf.Empty>
      getDeletePlaybookVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePlaybookVersion",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookVersionRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookVersionRequest,
          com.google.protobuf.Empty>
      getDeletePlaybookVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookVersionRequest,
            com.google.protobuf.Empty>
        getDeletePlaybookVersionMethod;
    if ((getDeletePlaybookVersionMethod = PlaybooksGrpc.getDeletePlaybookVersionMethod) == null) {
      synchronized (PlaybooksGrpc.class) {
        if ((getDeletePlaybookVersionMethod = PlaybooksGrpc.getDeletePlaybookVersionMethod)
            == null) {
          PlaybooksGrpc.getDeletePlaybookVersionMethod =
              getDeletePlaybookVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookVersionRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeletePlaybookVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PlaybooksMethodDescriptorSupplier("DeletePlaybookVersion"))
                      .build();
        }
      }
    }
    return getDeletePlaybookVersionMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static PlaybooksStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PlaybooksStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PlaybooksStub>() {
          @java.lang.Override
          public PlaybooksStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PlaybooksStub(channel, callOptions);
          }
        };
    return PlaybooksStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static PlaybooksBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PlaybooksBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PlaybooksBlockingV2Stub>() {
          @java.lang.Override
          public PlaybooksBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PlaybooksBlockingV2Stub(channel, callOptions);
          }
        };
    return PlaybooksBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PlaybooksBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PlaybooksBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PlaybooksBlockingStub>() {
          @java.lang.Override
          public PlaybooksBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PlaybooksBlockingStub(channel, callOptions);
          }
        };
    return PlaybooksBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static PlaybooksFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PlaybooksFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PlaybooksFutureStub>() {
          @java.lang.Override
          public PlaybooksFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PlaybooksFutureStub(channel, callOptions);
          }
        };
    return PlaybooksFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing
   * [Playbooks][google.cloud.dialogflow.cx.v3beta1.Playbook].
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a playbook in a specified agent.
     * </pre>
     */
    default void createPlaybook(
        com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Playbook>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreatePlaybookMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specified playbook.
     * </pre>
     */
    default void deletePlaybook(
        com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeletePlaybookMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of playbooks in the specified agent.
     * </pre>
     */
    default void listPlaybooks(
        com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPlaybooksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified Playbook.
     * </pre>
     */
    default void getPlaybook(
        com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Playbook>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetPlaybookMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports the specified playbook to a binary file.
     * Note that resources (e.g. examples, tools) that the playbook
     * references will also be exported.
     * </pre>
     */
    default void exportPlaybook(
        com.google.cloud.dialogflow.cx.v3beta1.ExportPlaybookRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExportPlaybookMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports the specified playbook to the specified agent from a binary file.
     * </pre>
     */
    default void importPlaybook(
        com.google.cloud.dialogflow.cx.v3beta1.ImportPlaybookRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportPlaybookMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified Playbook.
     * </pre>
     */
    default void updatePlaybook(
        com.google.cloud.dialogflow.cx.v3beta1.UpdatePlaybookRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Playbook>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdatePlaybookMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a version for the specified Playbook.
     * </pre>
     */
    default void createPlaybookVersion(
        com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.PlaybookVersion>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreatePlaybookVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified version of the Playbook.
     * </pre>
     */
    default void getPlaybookVersion(
        com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.PlaybookVersion>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetPlaybookVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified version of the Playbook and stores it as the
     * current playbook draft, returning the playbook with resources updated.
     * </pre>
     */
    default void restorePlaybookVersion(
        com.google.cloud.dialogflow.cx.v3beta1.RestorePlaybookVersionRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.dialogflow.cx.v3beta1.RestorePlaybookVersionResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRestorePlaybookVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists versions for the specified Playbook.
     * </pre>
     */
    default void listPlaybookVersions(
        com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPlaybookVersionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified version of the Playbook.
     * </pre>
     */
    default void deletePlaybookVersion(
        com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeletePlaybookVersionMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Playbooks.
   *
   * <pre>
   * Service for managing
   * [Playbooks][google.cloud.dialogflow.cx.v3beta1.Playbook].
   * </pre>
   */
  public abstract static class PlaybooksImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return PlaybooksGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Playbooks.
   *
   * <pre>
   * Service for managing
   * [Playbooks][google.cloud.dialogflow.cx.v3beta1.Playbook].
   * </pre>
   */
  public static final class PlaybooksStub extends io.grpc.stub.AbstractAsyncStub<PlaybooksStub> {
    private PlaybooksStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PlaybooksStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PlaybooksStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a playbook in a specified agent.
     * </pre>
     */
    public void createPlaybook(
        com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Playbook>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePlaybookMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specified playbook.
     * </pre>
     */
    public void deletePlaybook(
        com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePlaybookMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of playbooks in the specified agent.
     * </pre>
     */
    public void listPlaybooks(
        com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPlaybooksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified Playbook.
     * </pre>
     */
    public void getPlaybook(
        com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Playbook>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPlaybookMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports the specified playbook to a binary file.
     * Note that resources (e.g. examples, tools) that the playbook
     * references will also be exported.
     * </pre>
     */
    public void exportPlaybook(
        com.google.cloud.dialogflow.cx.v3beta1.ExportPlaybookRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportPlaybookMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports the specified playbook to the specified agent from a binary file.
     * </pre>
     */
    public void importPlaybook(
        com.google.cloud.dialogflow.cx.v3beta1.ImportPlaybookRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportPlaybookMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified Playbook.
     * </pre>
     */
    public void updatePlaybook(
        com.google.cloud.dialogflow.cx.v3beta1.UpdatePlaybookRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Playbook>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePlaybookMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a version for the specified Playbook.
     * </pre>
     */
    public void createPlaybookVersion(
        com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.PlaybookVersion>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePlaybookVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified version of the Playbook.
     * </pre>
     */
    public void getPlaybookVersion(
        com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.PlaybookVersion>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPlaybookVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified version of the Playbook and stores it as the
     * current playbook draft, returning the playbook with resources updated.
     * </pre>
     */
    public void restorePlaybookVersion(
        com.google.cloud.dialogflow.cx.v3beta1.RestorePlaybookVersionRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.dialogflow.cx.v3beta1.RestorePlaybookVersionResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestorePlaybookVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists versions for the specified Playbook.
     * </pre>
     */
    public void listPlaybookVersions(
        com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPlaybookVersionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified version of the Playbook.
     * </pre>
     */
    public void deletePlaybookVersion(
        com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePlaybookVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Playbooks.
   *
   * <pre>
   * Service for managing
   * [Playbooks][google.cloud.dialogflow.cx.v3beta1.Playbook].
   * </pre>
   */
  public static final class PlaybooksBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<PlaybooksBlockingV2Stub> {
    private PlaybooksBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PlaybooksBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PlaybooksBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a playbook in a specified agent.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.Playbook createPlaybook(
        com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreatePlaybookMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specified playbook.
     * </pre>
     */
    public com.google.protobuf.Empty deletePlaybook(
        com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeletePlaybookMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of playbooks in the specified agent.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksResponse listPlaybooks(
        com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListPlaybooksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified Playbook.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.Playbook getPlaybook(
        com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetPlaybookMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports the specified playbook to a binary file.
     * Note that resources (e.g. examples, tools) that the playbook
     * references will also be exported.
     * </pre>
     */
    public com.google.longrunning.Operation exportPlaybook(
        com.google.cloud.dialogflow.cx.v3beta1.ExportPlaybookRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getExportPlaybookMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports the specified playbook to the specified agent from a binary file.
     * </pre>
     */
    public com.google.longrunning.Operation importPlaybook(
        com.google.cloud.dialogflow.cx.v3beta1.ImportPlaybookRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getImportPlaybookMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified Playbook.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.Playbook updatePlaybook(
        com.google.cloud.dialogflow.cx.v3beta1.UpdatePlaybookRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdatePlaybookMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a version for the specified Playbook.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.PlaybookVersion createPlaybookVersion(
        com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookVersionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreatePlaybookVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified version of the Playbook.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.PlaybookVersion getPlaybookVersion(
        com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookVersionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetPlaybookVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified version of the Playbook and stores it as the
     * current playbook draft, returning the playbook with resources updated.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.RestorePlaybookVersionResponse
        restorePlaybookVersion(
            com.google.cloud.dialogflow.cx.v3beta1.RestorePlaybookVersionRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRestorePlaybookVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists versions for the specified Playbook.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsResponse listPlaybookVersions(
        com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListPlaybookVersionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified version of the Playbook.
     * </pre>
     */
    public com.google.protobuf.Empty deletePlaybookVersion(
        com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookVersionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeletePlaybookVersionMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Playbooks.
   *
   * <pre>
   * Service for managing
   * [Playbooks][google.cloud.dialogflow.cx.v3beta1.Playbook].
   * </pre>
   */
  public static final class PlaybooksBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PlaybooksBlockingStub> {
    private PlaybooksBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PlaybooksBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PlaybooksBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a playbook in a specified agent.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.Playbook createPlaybook(
        com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePlaybookMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specified playbook.
     * </pre>
     */
    public com.google.protobuf.Empty deletePlaybook(
        com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePlaybookMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of playbooks in the specified agent.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksResponse listPlaybooks(
        com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPlaybooksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified Playbook.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.Playbook getPlaybook(
        com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPlaybookMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports the specified playbook to a binary file.
     * Note that resources (e.g. examples, tools) that the playbook
     * references will also be exported.
     * </pre>
     */
    public com.google.longrunning.Operation exportPlaybook(
        com.google.cloud.dialogflow.cx.v3beta1.ExportPlaybookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportPlaybookMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports the specified playbook to the specified agent from a binary file.
     * </pre>
     */
    public com.google.longrunning.Operation importPlaybook(
        com.google.cloud.dialogflow.cx.v3beta1.ImportPlaybookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportPlaybookMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified Playbook.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.Playbook updatePlaybook(
        com.google.cloud.dialogflow.cx.v3beta1.UpdatePlaybookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePlaybookMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a version for the specified Playbook.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.PlaybookVersion createPlaybookVersion(
        com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePlaybookVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified version of the Playbook.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.PlaybookVersion getPlaybookVersion(
        com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPlaybookVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified version of the Playbook and stores it as the
     * current playbook draft, returning the playbook with resources updated.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.RestorePlaybookVersionResponse
        restorePlaybookVersion(
            com.google.cloud.dialogflow.cx.v3beta1.RestorePlaybookVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestorePlaybookVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists versions for the specified Playbook.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsResponse listPlaybookVersions(
        com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPlaybookVersionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified version of the Playbook.
     * </pre>
     */
    public com.google.protobuf.Empty deletePlaybookVersion(
        com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePlaybookVersionMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Playbooks.
   *
   * <pre>
   * Service for managing
   * [Playbooks][google.cloud.dialogflow.cx.v3beta1.Playbook].
   * </pre>
   */
  public static final class PlaybooksFutureStub
      extends io.grpc.stub.AbstractFutureStub<PlaybooksFutureStub> {
    private PlaybooksFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PlaybooksFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PlaybooksFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a playbook in a specified agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.Playbook>
        createPlaybook(com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePlaybookMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specified playbook.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deletePlaybook(com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePlaybookMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of playbooks in the specified agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksResponse>
        listPlaybooks(com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPlaybooksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified Playbook.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.Playbook>
        getPlaybook(com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPlaybookMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Exports the specified playbook to a binary file.
     * Note that resources (e.g. examples, tools) that the playbook
     * references will also be exported.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportPlaybook(com.google.cloud.dialogflow.cx.v3beta1.ExportPlaybookRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportPlaybookMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Imports the specified playbook to the specified agent from a binary file.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importPlaybook(com.google.cloud.dialogflow.cx.v3beta1.ImportPlaybookRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportPlaybookMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified Playbook.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.Playbook>
        updatePlaybook(com.google.cloud.dialogflow.cx.v3beta1.UpdatePlaybookRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePlaybookMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a version for the specified Playbook.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.PlaybookVersion>
        createPlaybookVersion(
            com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePlaybookVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified version of the Playbook.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.PlaybookVersion>
        getPlaybookVersion(
            com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPlaybookVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified version of the Playbook and stores it as the
     * current playbook draft, returning the playbook with resources updated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.RestorePlaybookVersionResponse>
        restorePlaybookVersion(
            com.google.cloud.dialogflow.cx.v3beta1.RestorePlaybookVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestorePlaybookVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists versions for the specified Playbook.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsResponse>
        listPlaybookVersions(
            com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPlaybookVersionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified version of the Playbook.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deletePlaybookVersion(
            com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePlaybookVersionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_PLAYBOOK = 0;
  private static final int METHODID_DELETE_PLAYBOOK = 1;
  private static final int METHODID_LIST_PLAYBOOKS = 2;
  private static final int METHODID_GET_PLAYBOOK = 3;
  private static final int METHODID_EXPORT_PLAYBOOK = 4;
  private static final int METHODID_IMPORT_PLAYBOOK = 5;
  private static final int METHODID_UPDATE_PLAYBOOK = 6;
  private static final int METHODID_CREATE_PLAYBOOK_VERSION = 7;
  private static final int METHODID_GET_PLAYBOOK_VERSION = 8;
  private static final int METHODID_RESTORE_PLAYBOOK_VERSION = 9;
  private static final int METHODID_LIST_PLAYBOOK_VERSIONS = 10;
  private static final int METHODID_DELETE_PLAYBOOK_VERSION = 11;

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
        case METHODID_CREATE_PLAYBOOK:
          serviceImpl.createPlaybook(
              (com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Playbook>)
                  responseObserver);
          break;
        case METHODID_DELETE_PLAYBOOK:
          serviceImpl.deletePlaybook(
              (com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_PLAYBOOKS:
          serviceImpl.listPlaybooks(
              (com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PLAYBOOK:
          serviceImpl.getPlaybook(
              (com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Playbook>)
                  responseObserver);
          break;
        case METHODID_EXPORT_PLAYBOOK:
          serviceImpl.exportPlaybook(
              (com.google.cloud.dialogflow.cx.v3beta1.ExportPlaybookRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_IMPORT_PLAYBOOK:
          serviceImpl.importPlaybook(
              (com.google.cloud.dialogflow.cx.v3beta1.ImportPlaybookRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_PLAYBOOK:
          serviceImpl.updatePlaybook(
              (com.google.cloud.dialogflow.cx.v3beta1.UpdatePlaybookRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Playbook>)
                  responseObserver);
          break;
        case METHODID_CREATE_PLAYBOOK_VERSION:
          serviceImpl.createPlaybookVersion(
              (com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.PlaybookVersion>)
                  responseObserver);
          break;
        case METHODID_GET_PLAYBOOK_VERSION:
          serviceImpl.getPlaybookVersion(
              (com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.PlaybookVersion>)
                  responseObserver);
          break;
        case METHODID_RESTORE_PLAYBOOK_VERSION:
          serviceImpl.restorePlaybookVersion(
              (com.google.cloud.dialogflow.cx.v3beta1.RestorePlaybookVersionRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.cx.v3beta1.RestorePlaybookVersionResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_PLAYBOOK_VERSIONS:
          serviceImpl.listPlaybookVersions(
              (com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_PLAYBOOK_VERSION:
          serviceImpl.deletePlaybookVersion(
              (com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookVersionRequest) request,
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
            getCreatePlaybookMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookRequest,
                    com.google.cloud.dialogflow.cx.v3beta1.Playbook>(
                    service, METHODID_CREATE_PLAYBOOK)))
        .addMethod(
            getDeletePlaybookMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_PLAYBOOK)))
        .addMethod(
            getListPlaybooksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksRequest,
                    com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksResponse>(
                    service, METHODID_LIST_PLAYBOOKS)))
        .addMethod(
            getGetPlaybookMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookRequest,
                    com.google.cloud.dialogflow.cx.v3beta1.Playbook>(
                    service, METHODID_GET_PLAYBOOK)))
        .addMethod(
            getExportPlaybookMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3beta1.ExportPlaybookRequest,
                    com.google.longrunning.Operation>(service, METHODID_EXPORT_PLAYBOOK)))
        .addMethod(
            getImportPlaybookMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3beta1.ImportPlaybookRequest,
                    com.google.longrunning.Operation>(service, METHODID_IMPORT_PLAYBOOK)))
        .addMethod(
            getUpdatePlaybookMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3beta1.UpdatePlaybookRequest,
                    com.google.cloud.dialogflow.cx.v3beta1.Playbook>(
                    service, METHODID_UPDATE_PLAYBOOK)))
        .addMethod(
            getCreatePlaybookVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookVersionRequest,
                    com.google.cloud.dialogflow.cx.v3beta1.PlaybookVersion>(
                    service, METHODID_CREATE_PLAYBOOK_VERSION)))
        .addMethod(
            getGetPlaybookVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookVersionRequest,
                    com.google.cloud.dialogflow.cx.v3beta1.PlaybookVersion>(
                    service, METHODID_GET_PLAYBOOK_VERSION)))
        .addMethod(
            getRestorePlaybookVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3beta1.RestorePlaybookVersionRequest,
                    com.google.cloud.dialogflow.cx.v3beta1.RestorePlaybookVersionResponse>(
                    service, METHODID_RESTORE_PLAYBOOK_VERSION)))
        .addMethod(
            getListPlaybookVersionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsRequest,
                    com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsResponse>(
                    service, METHODID_LIST_PLAYBOOK_VERSIONS)))
        .addMethod(
            getDeletePlaybookVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookVersionRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_PLAYBOOK_VERSION)))
        .build();
  }

  private abstract static class PlaybooksBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PlaybooksBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.cx.v3beta1.PlaybookProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Playbooks");
    }
  }

  private static final class PlaybooksFileDescriptorSupplier
      extends PlaybooksBaseDescriptorSupplier {
    PlaybooksFileDescriptorSupplier() {}
  }

  private static final class PlaybooksMethodDescriptorSupplier
      extends PlaybooksBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    PlaybooksMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (PlaybooksGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new PlaybooksFileDescriptorSupplier())
                      .addMethod(getCreatePlaybookMethod())
                      .addMethod(getDeletePlaybookMethod())
                      .addMethod(getListPlaybooksMethod())
                      .addMethod(getGetPlaybookMethod())
                      .addMethod(getExportPlaybookMethod())
                      .addMethod(getImportPlaybookMethod())
                      .addMethod(getUpdatePlaybookMethod())
                      .addMethod(getCreatePlaybookVersionMethod())
                      .addMethod(getGetPlaybookVersionMethod())
                      .addMethod(getRestorePlaybookVersionMethod())
                      .addMethod(getListPlaybookVersionsMethod())
                      .addMethod(getDeletePlaybookVersionMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
