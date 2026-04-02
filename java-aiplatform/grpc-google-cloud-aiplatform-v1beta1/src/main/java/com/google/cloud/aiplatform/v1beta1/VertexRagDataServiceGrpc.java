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
package com.google.cloud.aiplatform.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A service for managing user data for RAG.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class VertexRagDataServiceGrpc {

  private VertexRagDataServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.aiplatform.v1beta1.VertexRagDataService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateRagCorpusRequest,
          com.google.longrunning.Operation>
      getCreateRagCorpusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRagCorpus",
      requestType = com.google.cloud.aiplatform.v1beta1.CreateRagCorpusRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateRagCorpusRequest,
          com.google.longrunning.Operation>
      getCreateRagCorpusMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.CreateRagCorpusRequest,
            com.google.longrunning.Operation>
        getCreateRagCorpusMethod;
    if ((getCreateRagCorpusMethod = VertexRagDataServiceGrpc.getCreateRagCorpusMethod) == null) {
      synchronized (VertexRagDataServiceGrpc.class) {
        if ((getCreateRagCorpusMethod = VertexRagDataServiceGrpc.getCreateRagCorpusMethod)
            == null) {
          VertexRagDataServiceGrpc.getCreateRagCorpusMethod =
              getCreateRagCorpusMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.CreateRagCorpusRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRagCorpus"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.CreateRagCorpusRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VertexRagDataServiceMethodDescriptorSupplier("CreateRagCorpus"))
                      .build();
        }
      }
    }
    return getCreateRagCorpusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateRagCorpusRequest,
          com.google.longrunning.Operation>
      getUpdateRagCorpusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateRagCorpus",
      requestType = com.google.cloud.aiplatform.v1beta1.UpdateRagCorpusRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateRagCorpusRequest,
          com.google.longrunning.Operation>
      getUpdateRagCorpusMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.UpdateRagCorpusRequest,
            com.google.longrunning.Operation>
        getUpdateRagCorpusMethod;
    if ((getUpdateRagCorpusMethod = VertexRagDataServiceGrpc.getUpdateRagCorpusMethod) == null) {
      synchronized (VertexRagDataServiceGrpc.class) {
        if ((getUpdateRagCorpusMethod = VertexRagDataServiceGrpc.getUpdateRagCorpusMethod)
            == null) {
          VertexRagDataServiceGrpc.getUpdateRagCorpusMethod =
              getUpdateRagCorpusMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.UpdateRagCorpusRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateRagCorpus"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.UpdateRagCorpusRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VertexRagDataServiceMethodDescriptorSupplier("UpdateRagCorpus"))
                      .build();
        }
      }
    }
    return getUpdateRagCorpusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetRagCorpusRequest,
          com.google.cloud.aiplatform.v1beta1.RagCorpus>
      getGetRagCorpusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRagCorpus",
      requestType = com.google.cloud.aiplatform.v1beta1.GetRagCorpusRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.RagCorpus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetRagCorpusRequest,
          com.google.cloud.aiplatform.v1beta1.RagCorpus>
      getGetRagCorpusMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetRagCorpusRequest,
            com.google.cloud.aiplatform.v1beta1.RagCorpus>
        getGetRagCorpusMethod;
    if ((getGetRagCorpusMethod = VertexRagDataServiceGrpc.getGetRagCorpusMethod) == null) {
      synchronized (VertexRagDataServiceGrpc.class) {
        if ((getGetRagCorpusMethod = VertexRagDataServiceGrpc.getGetRagCorpusMethod) == null) {
          VertexRagDataServiceGrpc.getGetRagCorpusMethod =
              getGetRagCorpusMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GetRagCorpusRequest,
                          com.google.cloud.aiplatform.v1beta1.RagCorpus>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRagCorpus"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.GetRagCorpusRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.RagCorpus.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VertexRagDataServiceMethodDescriptorSupplier("GetRagCorpus"))
                      .build();
        }
      }
    }
    return getGetRagCorpusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListRagCorporaRequest,
          com.google.cloud.aiplatform.v1beta1.ListRagCorporaResponse>
      getListRagCorporaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRagCorpora",
      requestType = com.google.cloud.aiplatform.v1beta1.ListRagCorporaRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListRagCorporaResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListRagCorporaRequest,
          com.google.cloud.aiplatform.v1beta1.ListRagCorporaResponse>
      getListRagCorporaMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListRagCorporaRequest,
            com.google.cloud.aiplatform.v1beta1.ListRagCorporaResponse>
        getListRagCorporaMethod;
    if ((getListRagCorporaMethod = VertexRagDataServiceGrpc.getListRagCorporaMethod) == null) {
      synchronized (VertexRagDataServiceGrpc.class) {
        if ((getListRagCorporaMethod = VertexRagDataServiceGrpc.getListRagCorporaMethod) == null) {
          VertexRagDataServiceGrpc.getListRagCorporaMethod =
              getListRagCorporaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ListRagCorporaRequest,
                          com.google.cloud.aiplatform.v1beta1.ListRagCorporaResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRagCorpora"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListRagCorporaRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListRagCorporaResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VertexRagDataServiceMethodDescriptorSupplier("ListRagCorpora"))
                      .build();
        }
      }
    }
    return getListRagCorporaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteRagCorpusRequest,
          com.google.longrunning.Operation>
      getDeleteRagCorpusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRagCorpus",
      requestType = com.google.cloud.aiplatform.v1beta1.DeleteRagCorpusRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteRagCorpusRequest,
          com.google.longrunning.Operation>
      getDeleteRagCorpusMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeleteRagCorpusRequest,
            com.google.longrunning.Operation>
        getDeleteRagCorpusMethod;
    if ((getDeleteRagCorpusMethod = VertexRagDataServiceGrpc.getDeleteRagCorpusMethod) == null) {
      synchronized (VertexRagDataServiceGrpc.class) {
        if ((getDeleteRagCorpusMethod = VertexRagDataServiceGrpc.getDeleteRagCorpusMethod)
            == null) {
          VertexRagDataServiceGrpc.getDeleteRagCorpusMethod =
              getDeleteRagCorpusMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.DeleteRagCorpusRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRagCorpus"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.DeleteRagCorpusRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VertexRagDataServiceMethodDescriptorSupplier("DeleteRagCorpus"))
                      .build();
        }
      }
    }
    return getDeleteRagCorpusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UploadRagFileRequest,
          com.google.cloud.aiplatform.v1beta1.UploadRagFileResponse>
      getUploadRagFileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UploadRagFile",
      requestType = com.google.cloud.aiplatform.v1beta1.UploadRagFileRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.UploadRagFileResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UploadRagFileRequest,
          com.google.cloud.aiplatform.v1beta1.UploadRagFileResponse>
      getUploadRagFileMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.UploadRagFileRequest,
            com.google.cloud.aiplatform.v1beta1.UploadRagFileResponse>
        getUploadRagFileMethod;
    if ((getUploadRagFileMethod = VertexRagDataServiceGrpc.getUploadRagFileMethod) == null) {
      synchronized (VertexRagDataServiceGrpc.class) {
        if ((getUploadRagFileMethod = VertexRagDataServiceGrpc.getUploadRagFileMethod) == null) {
          VertexRagDataServiceGrpc.getUploadRagFileMethod =
              getUploadRagFileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.UploadRagFileRequest,
                          com.google.cloud.aiplatform.v1beta1.UploadRagFileResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UploadRagFile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.UploadRagFileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.UploadRagFileResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VertexRagDataServiceMethodDescriptorSupplier("UploadRagFile"))
                      .build();
        }
      }
    }
    return getUploadRagFileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ImportRagFilesRequest,
          com.google.longrunning.Operation>
      getImportRagFilesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportRagFiles",
      requestType = com.google.cloud.aiplatform.v1beta1.ImportRagFilesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ImportRagFilesRequest,
          com.google.longrunning.Operation>
      getImportRagFilesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ImportRagFilesRequest,
            com.google.longrunning.Operation>
        getImportRagFilesMethod;
    if ((getImportRagFilesMethod = VertexRagDataServiceGrpc.getImportRagFilesMethod) == null) {
      synchronized (VertexRagDataServiceGrpc.class) {
        if ((getImportRagFilesMethod = VertexRagDataServiceGrpc.getImportRagFilesMethod) == null) {
          VertexRagDataServiceGrpc.getImportRagFilesMethod =
              getImportRagFilesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ImportRagFilesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportRagFiles"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ImportRagFilesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VertexRagDataServiceMethodDescriptorSupplier("ImportRagFiles"))
                      .build();
        }
      }
    }
    return getImportRagFilesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetRagFileRequest,
          com.google.cloud.aiplatform.v1beta1.RagFile>
      getGetRagFileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRagFile",
      requestType = com.google.cloud.aiplatform.v1beta1.GetRagFileRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.RagFile.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetRagFileRequest,
          com.google.cloud.aiplatform.v1beta1.RagFile>
      getGetRagFileMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetRagFileRequest,
            com.google.cloud.aiplatform.v1beta1.RagFile>
        getGetRagFileMethod;
    if ((getGetRagFileMethod = VertexRagDataServiceGrpc.getGetRagFileMethod) == null) {
      synchronized (VertexRagDataServiceGrpc.class) {
        if ((getGetRagFileMethod = VertexRagDataServiceGrpc.getGetRagFileMethod) == null) {
          VertexRagDataServiceGrpc.getGetRagFileMethod =
              getGetRagFileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GetRagFileRequest,
                          com.google.cloud.aiplatform.v1beta1.RagFile>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRagFile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.GetRagFileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.RagFile.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VertexRagDataServiceMethodDescriptorSupplier("GetRagFile"))
                      .build();
        }
      }
    }
    return getGetRagFileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListRagFilesRequest,
          com.google.cloud.aiplatform.v1beta1.ListRagFilesResponse>
      getListRagFilesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRagFiles",
      requestType = com.google.cloud.aiplatform.v1beta1.ListRagFilesRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListRagFilesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListRagFilesRequest,
          com.google.cloud.aiplatform.v1beta1.ListRagFilesResponse>
      getListRagFilesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListRagFilesRequest,
            com.google.cloud.aiplatform.v1beta1.ListRagFilesResponse>
        getListRagFilesMethod;
    if ((getListRagFilesMethod = VertexRagDataServiceGrpc.getListRagFilesMethod) == null) {
      synchronized (VertexRagDataServiceGrpc.class) {
        if ((getListRagFilesMethod = VertexRagDataServiceGrpc.getListRagFilesMethod) == null) {
          VertexRagDataServiceGrpc.getListRagFilesMethod =
              getListRagFilesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ListRagFilesRequest,
                          com.google.cloud.aiplatform.v1beta1.ListRagFilesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRagFiles"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListRagFilesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListRagFilesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VertexRagDataServiceMethodDescriptorSupplier("ListRagFiles"))
                      .build();
        }
      }
    }
    return getListRagFilesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteRagFileRequest,
          com.google.longrunning.Operation>
      getDeleteRagFileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRagFile",
      requestType = com.google.cloud.aiplatform.v1beta1.DeleteRagFileRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteRagFileRequest,
          com.google.longrunning.Operation>
      getDeleteRagFileMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeleteRagFileRequest,
            com.google.longrunning.Operation>
        getDeleteRagFileMethod;
    if ((getDeleteRagFileMethod = VertexRagDataServiceGrpc.getDeleteRagFileMethod) == null) {
      synchronized (VertexRagDataServiceGrpc.class) {
        if ((getDeleteRagFileMethod = VertexRagDataServiceGrpc.getDeleteRagFileMethod) == null) {
          VertexRagDataServiceGrpc.getDeleteRagFileMethod =
              getDeleteRagFileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.DeleteRagFileRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRagFile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.DeleteRagFileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VertexRagDataServiceMethodDescriptorSupplier("DeleteRagFile"))
                      .build();
        }
      }
    }
    return getDeleteRagFileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateRagEngineConfigRequest,
          com.google.longrunning.Operation>
      getUpdateRagEngineConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateRagEngineConfig",
      requestType = com.google.cloud.aiplatform.v1beta1.UpdateRagEngineConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateRagEngineConfigRequest,
          com.google.longrunning.Operation>
      getUpdateRagEngineConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.UpdateRagEngineConfigRequest,
            com.google.longrunning.Operation>
        getUpdateRagEngineConfigMethod;
    if ((getUpdateRagEngineConfigMethod = VertexRagDataServiceGrpc.getUpdateRagEngineConfigMethod)
        == null) {
      synchronized (VertexRagDataServiceGrpc.class) {
        if ((getUpdateRagEngineConfigMethod =
                VertexRagDataServiceGrpc.getUpdateRagEngineConfigMethod)
            == null) {
          VertexRagDataServiceGrpc.getUpdateRagEngineConfigMethod =
              getUpdateRagEngineConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.UpdateRagEngineConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateRagEngineConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.UpdateRagEngineConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VertexRagDataServiceMethodDescriptorSupplier("UpdateRagEngineConfig"))
                      .build();
        }
      }
    }
    return getUpdateRagEngineConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetRagEngineConfigRequest,
          com.google.cloud.aiplatform.v1beta1.RagEngineConfig>
      getGetRagEngineConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRagEngineConfig",
      requestType = com.google.cloud.aiplatform.v1beta1.GetRagEngineConfigRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.RagEngineConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetRagEngineConfigRequest,
          com.google.cloud.aiplatform.v1beta1.RagEngineConfig>
      getGetRagEngineConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetRagEngineConfigRequest,
            com.google.cloud.aiplatform.v1beta1.RagEngineConfig>
        getGetRagEngineConfigMethod;
    if ((getGetRagEngineConfigMethod = VertexRagDataServiceGrpc.getGetRagEngineConfigMethod)
        == null) {
      synchronized (VertexRagDataServiceGrpc.class) {
        if ((getGetRagEngineConfigMethod = VertexRagDataServiceGrpc.getGetRagEngineConfigMethod)
            == null) {
          VertexRagDataServiceGrpc.getGetRagEngineConfigMethod =
              getGetRagEngineConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GetRagEngineConfigRequest,
                          com.google.cloud.aiplatform.v1beta1.RagEngineConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRagEngineConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.GetRagEngineConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.RagEngineConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VertexRagDataServiceMethodDescriptorSupplier("GetRagEngineConfig"))
                      .build();
        }
      }
    }
    return getGetRagEngineConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateRagDataSchemaRequest,
          com.google.cloud.aiplatform.v1beta1.RagDataSchema>
      getCreateRagDataSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRagDataSchema",
      requestType = com.google.cloud.aiplatform.v1beta1.CreateRagDataSchemaRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.RagDataSchema.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateRagDataSchemaRequest,
          com.google.cloud.aiplatform.v1beta1.RagDataSchema>
      getCreateRagDataSchemaMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.CreateRagDataSchemaRequest,
            com.google.cloud.aiplatform.v1beta1.RagDataSchema>
        getCreateRagDataSchemaMethod;
    if ((getCreateRagDataSchemaMethod = VertexRagDataServiceGrpc.getCreateRagDataSchemaMethod)
        == null) {
      synchronized (VertexRagDataServiceGrpc.class) {
        if ((getCreateRagDataSchemaMethod = VertexRagDataServiceGrpc.getCreateRagDataSchemaMethod)
            == null) {
          VertexRagDataServiceGrpc.getCreateRagDataSchemaMethod =
              getCreateRagDataSchemaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.CreateRagDataSchemaRequest,
                          com.google.cloud.aiplatform.v1beta1.RagDataSchema>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateRagDataSchema"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.CreateRagDataSchemaRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.RagDataSchema
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VertexRagDataServiceMethodDescriptorSupplier("CreateRagDataSchema"))
                      .build();
        }
      }
    }
    return getCreateRagDataSchemaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.BatchCreateRagDataSchemasRequest,
          com.google.longrunning.Operation>
      getBatchCreateRagDataSchemasMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchCreateRagDataSchemas",
      requestType = com.google.cloud.aiplatform.v1beta1.BatchCreateRagDataSchemasRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.BatchCreateRagDataSchemasRequest,
          com.google.longrunning.Operation>
      getBatchCreateRagDataSchemasMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.BatchCreateRagDataSchemasRequest,
            com.google.longrunning.Operation>
        getBatchCreateRagDataSchemasMethod;
    if ((getBatchCreateRagDataSchemasMethod =
            VertexRagDataServiceGrpc.getBatchCreateRagDataSchemasMethod)
        == null) {
      synchronized (VertexRagDataServiceGrpc.class) {
        if ((getBatchCreateRagDataSchemasMethod =
                VertexRagDataServiceGrpc.getBatchCreateRagDataSchemasMethod)
            == null) {
          VertexRagDataServiceGrpc.getBatchCreateRagDataSchemasMethod =
              getBatchCreateRagDataSchemasMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.BatchCreateRagDataSchemasRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchCreateRagDataSchemas"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.BatchCreateRagDataSchemasRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VertexRagDataServiceMethodDescriptorSupplier(
                              "BatchCreateRagDataSchemas"))
                      .build();
        }
      }
    }
    return getBatchCreateRagDataSchemasMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetRagDataSchemaRequest,
          com.google.cloud.aiplatform.v1beta1.RagDataSchema>
      getGetRagDataSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRagDataSchema",
      requestType = com.google.cloud.aiplatform.v1beta1.GetRagDataSchemaRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.RagDataSchema.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetRagDataSchemaRequest,
          com.google.cloud.aiplatform.v1beta1.RagDataSchema>
      getGetRagDataSchemaMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetRagDataSchemaRequest,
            com.google.cloud.aiplatform.v1beta1.RagDataSchema>
        getGetRagDataSchemaMethod;
    if ((getGetRagDataSchemaMethod = VertexRagDataServiceGrpc.getGetRagDataSchemaMethod) == null) {
      synchronized (VertexRagDataServiceGrpc.class) {
        if ((getGetRagDataSchemaMethod = VertexRagDataServiceGrpc.getGetRagDataSchemaMethod)
            == null) {
          VertexRagDataServiceGrpc.getGetRagDataSchemaMethod =
              getGetRagDataSchemaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GetRagDataSchemaRequest,
                          com.google.cloud.aiplatform.v1beta1.RagDataSchema>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRagDataSchema"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.GetRagDataSchemaRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.RagDataSchema
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VertexRagDataServiceMethodDescriptorSupplier("GetRagDataSchema"))
                      .build();
        }
      }
    }
    return getGetRagDataSchemaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListRagDataSchemasRequest,
          com.google.cloud.aiplatform.v1beta1.ListRagDataSchemasResponse>
      getListRagDataSchemasMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRagDataSchemas",
      requestType = com.google.cloud.aiplatform.v1beta1.ListRagDataSchemasRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListRagDataSchemasResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListRagDataSchemasRequest,
          com.google.cloud.aiplatform.v1beta1.ListRagDataSchemasResponse>
      getListRagDataSchemasMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListRagDataSchemasRequest,
            com.google.cloud.aiplatform.v1beta1.ListRagDataSchemasResponse>
        getListRagDataSchemasMethod;
    if ((getListRagDataSchemasMethod = VertexRagDataServiceGrpc.getListRagDataSchemasMethod)
        == null) {
      synchronized (VertexRagDataServiceGrpc.class) {
        if ((getListRagDataSchemasMethod = VertexRagDataServiceGrpc.getListRagDataSchemasMethod)
            == null) {
          VertexRagDataServiceGrpc.getListRagDataSchemasMethod =
              getListRagDataSchemasMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ListRagDataSchemasRequest,
                          com.google.cloud.aiplatform.v1beta1.ListRagDataSchemasResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRagDataSchemas"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListRagDataSchemasRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListRagDataSchemasResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VertexRagDataServiceMethodDescriptorSupplier("ListRagDataSchemas"))
                      .build();
        }
      }
    }
    return getListRagDataSchemasMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteRagDataSchemaRequest, com.google.protobuf.Empty>
      getDeleteRagDataSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRagDataSchema",
      requestType = com.google.cloud.aiplatform.v1beta1.DeleteRagDataSchemaRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteRagDataSchemaRequest, com.google.protobuf.Empty>
      getDeleteRagDataSchemaMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeleteRagDataSchemaRequest,
            com.google.protobuf.Empty>
        getDeleteRagDataSchemaMethod;
    if ((getDeleteRagDataSchemaMethod = VertexRagDataServiceGrpc.getDeleteRagDataSchemaMethod)
        == null) {
      synchronized (VertexRagDataServiceGrpc.class) {
        if ((getDeleteRagDataSchemaMethod = VertexRagDataServiceGrpc.getDeleteRagDataSchemaMethod)
            == null) {
          VertexRagDataServiceGrpc.getDeleteRagDataSchemaMethod =
              getDeleteRagDataSchemaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.DeleteRagDataSchemaRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteRagDataSchema"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.DeleteRagDataSchemaRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VertexRagDataServiceMethodDescriptorSupplier("DeleteRagDataSchema"))
                      .build();
        }
      }
    }
    return getDeleteRagDataSchemaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.BatchDeleteRagDataSchemasRequest,
          com.google.longrunning.Operation>
      getBatchDeleteRagDataSchemasMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchDeleteRagDataSchemas",
      requestType = com.google.cloud.aiplatform.v1beta1.BatchDeleteRagDataSchemasRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.BatchDeleteRagDataSchemasRequest,
          com.google.longrunning.Operation>
      getBatchDeleteRagDataSchemasMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.BatchDeleteRagDataSchemasRequest,
            com.google.longrunning.Operation>
        getBatchDeleteRagDataSchemasMethod;
    if ((getBatchDeleteRagDataSchemasMethod =
            VertexRagDataServiceGrpc.getBatchDeleteRagDataSchemasMethod)
        == null) {
      synchronized (VertexRagDataServiceGrpc.class) {
        if ((getBatchDeleteRagDataSchemasMethod =
                VertexRagDataServiceGrpc.getBatchDeleteRagDataSchemasMethod)
            == null) {
          VertexRagDataServiceGrpc.getBatchDeleteRagDataSchemasMethod =
              getBatchDeleteRagDataSchemasMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.BatchDeleteRagDataSchemasRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchDeleteRagDataSchemas"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.BatchDeleteRagDataSchemasRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VertexRagDataServiceMethodDescriptorSupplier(
                              "BatchDeleteRagDataSchemas"))
                      .build();
        }
      }
    }
    return getBatchDeleteRagDataSchemasMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateRagMetadataRequest,
          com.google.cloud.aiplatform.v1beta1.RagMetadata>
      getCreateRagMetadataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRagMetadata",
      requestType = com.google.cloud.aiplatform.v1beta1.CreateRagMetadataRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.RagMetadata.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateRagMetadataRequest,
          com.google.cloud.aiplatform.v1beta1.RagMetadata>
      getCreateRagMetadataMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.CreateRagMetadataRequest,
            com.google.cloud.aiplatform.v1beta1.RagMetadata>
        getCreateRagMetadataMethod;
    if ((getCreateRagMetadataMethod = VertexRagDataServiceGrpc.getCreateRagMetadataMethod)
        == null) {
      synchronized (VertexRagDataServiceGrpc.class) {
        if ((getCreateRagMetadataMethod = VertexRagDataServiceGrpc.getCreateRagMetadataMethod)
            == null) {
          VertexRagDataServiceGrpc.getCreateRagMetadataMethod =
              getCreateRagMetadataMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.CreateRagMetadataRequest,
                          com.google.cloud.aiplatform.v1beta1.RagMetadata>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRagMetadata"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.CreateRagMetadataRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.RagMetadata.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VertexRagDataServiceMethodDescriptorSupplier("CreateRagMetadata"))
                      .build();
        }
      }
    }
    return getCreateRagMetadataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.BatchCreateRagMetadataRequest,
          com.google.longrunning.Operation>
      getBatchCreateRagMetadataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchCreateRagMetadata",
      requestType = com.google.cloud.aiplatform.v1beta1.BatchCreateRagMetadataRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.BatchCreateRagMetadataRequest,
          com.google.longrunning.Operation>
      getBatchCreateRagMetadataMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.BatchCreateRagMetadataRequest,
            com.google.longrunning.Operation>
        getBatchCreateRagMetadataMethod;
    if ((getBatchCreateRagMetadataMethod = VertexRagDataServiceGrpc.getBatchCreateRagMetadataMethod)
        == null) {
      synchronized (VertexRagDataServiceGrpc.class) {
        if ((getBatchCreateRagMetadataMethod =
                VertexRagDataServiceGrpc.getBatchCreateRagMetadataMethod)
            == null) {
          VertexRagDataServiceGrpc.getBatchCreateRagMetadataMethod =
              getBatchCreateRagMetadataMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.BatchCreateRagMetadataRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchCreateRagMetadata"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.BatchCreateRagMetadataRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VertexRagDataServiceMethodDescriptorSupplier(
                              "BatchCreateRagMetadata"))
                      .build();
        }
      }
    }
    return getBatchCreateRagMetadataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateRagMetadataRequest,
          com.google.cloud.aiplatform.v1beta1.RagMetadata>
      getUpdateRagMetadataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateRagMetadata",
      requestType = com.google.cloud.aiplatform.v1beta1.UpdateRagMetadataRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.RagMetadata.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateRagMetadataRequest,
          com.google.cloud.aiplatform.v1beta1.RagMetadata>
      getUpdateRagMetadataMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.UpdateRagMetadataRequest,
            com.google.cloud.aiplatform.v1beta1.RagMetadata>
        getUpdateRagMetadataMethod;
    if ((getUpdateRagMetadataMethod = VertexRagDataServiceGrpc.getUpdateRagMetadataMethod)
        == null) {
      synchronized (VertexRagDataServiceGrpc.class) {
        if ((getUpdateRagMetadataMethod = VertexRagDataServiceGrpc.getUpdateRagMetadataMethod)
            == null) {
          VertexRagDataServiceGrpc.getUpdateRagMetadataMethod =
              getUpdateRagMetadataMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.UpdateRagMetadataRequest,
                          com.google.cloud.aiplatform.v1beta1.RagMetadata>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateRagMetadata"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.UpdateRagMetadataRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.RagMetadata.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VertexRagDataServiceMethodDescriptorSupplier("UpdateRagMetadata"))
                      .build();
        }
      }
    }
    return getUpdateRagMetadataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetRagMetadataRequest,
          com.google.cloud.aiplatform.v1beta1.RagMetadata>
      getGetRagMetadataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRagMetadata",
      requestType = com.google.cloud.aiplatform.v1beta1.GetRagMetadataRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.RagMetadata.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetRagMetadataRequest,
          com.google.cloud.aiplatform.v1beta1.RagMetadata>
      getGetRagMetadataMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetRagMetadataRequest,
            com.google.cloud.aiplatform.v1beta1.RagMetadata>
        getGetRagMetadataMethod;
    if ((getGetRagMetadataMethod = VertexRagDataServiceGrpc.getGetRagMetadataMethod) == null) {
      synchronized (VertexRagDataServiceGrpc.class) {
        if ((getGetRagMetadataMethod = VertexRagDataServiceGrpc.getGetRagMetadataMethod) == null) {
          VertexRagDataServiceGrpc.getGetRagMetadataMethod =
              getGetRagMetadataMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GetRagMetadataRequest,
                          com.google.cloud.aiplatform.v1beta1.RagMetadata>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRagMetadata"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.GetRagMetadataRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.RagMetadata.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VertexRagDataServiceMethodDescriptorSupplier("GetRagMetadata"))
                      .build();
        }
      }
    }
    return getGetRagMetadataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListRagMetadataRequest,
          com.google.cloud.aiplatform.v1beta1.ListRagMetadataResponse>
      getListRagMetadataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRagMetadata",
      requestType = com.google.cloud.aiplatform.v1beta1.ListRagMetadataRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListRagMetadataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListRagMetadataRequest,
          com.google.cloud.aiplatform.v1beta1.ListRagMetadataResponse>
      getListRagMetadataMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListRagMetadataRequest,
            com.google.cloud.aiplatform.v1beta1.ListRagMetadataResponse>
        getListRagMetadataMethod;
    if ((getListRagMetadataMethod = VertexRagDataServiceGrpc.getListRagMetadataMethod) == null) {
      synchronized (VertexRagDataServiceGrpc.class) {
        if ((getListRagMetadataMethod = VertexRagDataServiceGrpc.getListRagMetadataMethod)
            == null) {
          VertexRagDataServiceGrpc.getListRagMetadataMethod =
              getListRagMetadataMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ListRagMetadataRequest,
                          com.google.cloud.aiplatform.v1beta1.ListRagMetadataResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRagMetadata"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListRagMetadataRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListRagMetadataResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VertexRagDataServiceMethodDescriptorSupplier("ListRagMetadata"))
                      .build();
        }
      }
    }
    return getListRagMetadataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteRagMetadataRequest, com.google.protobuf.Empty>
      getDeleteRagMetadataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRagMetadata",
      requestType = com.google.cloud.aiplatform.v1beta1.DeleteRagMetadataRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteRagMetadataRequest, com.google.protobuf.Empty>
      getDeleteRagMetadataMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeleteRagMetadataRequest, com.google.protobuf.Empty>
        getDeleteRagMetadataMethod;
    if ((getDeleteRagMetadataMethod = VertexRagDataServiceGrpc.getDeleteRagMetadataMethod)
        == null) {
      synchronized (VertexRagDataServiceGrpc.class) {
        if ((getDeleteRagMetadataMethod = VertexRagDataServiceGrpc.getDeleteRagMetadataMethod)
            == null) {
          VertexRagDataServiceGrpc.getDeleteRagMetadataMethod =
              getDeleteRagMetadataMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.DeleteRagMetadataRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRagMetadata"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.DeleteRagMetadataRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VertexRagDataServiceMethodDescriptorSupplier("DeleteRagMetadata"))
                      .build();
        }
      }
    }
    return getDeleteRagMetadataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.BatchDeleteRagMetadataRequest,
          com.google.longrunning.Operation>
      getBatchDeleteRagMetadataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchDeleteRagMetadata",
      requestType = com.google.cloud.aiplatform.v1beta1.BatchDeleteRagMetadataRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.BatchDeleteRagMetadataRequest,
          com.google.longrunning.Operation>
      getBatchDeleteRagMetadataMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.BatchDeleteRagMetadataRequest,
            com.google.longrunning.Operation>
        getBatchDeleteRagMetadataMethod;
    if ((getBatchDeleteRagMetadataMethod = VertexRagDataServiceGrpc.getBatchDeleteRagMetadataMethod)
        == null) {
      synchronized (VertexRagDataServiceGrpc.class) {
        if ((getBatchDeleteRagMetadataMethod =
                VertexRagDataServiceGrpc.getBatchDeleteRagMetadataMethod)
            == null) {
          VertexRagDataServiceGrpc.getBatchDeleteRagMetadataMethod =
              getBatchDeleteRagMetadataMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.BatchDeleteRagMetadataRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchDeleteRagMetadata"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.BatchDeleteRagMetadataRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VertexRagDataServiceMethodDescriptorSupplier(
                              "BatchDeleteRagMetadata"))
                      .build();
        }
      }
    }
    return getBatchDeleteRagMetadataMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static VertexRagDataServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VertexRagDataServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<VertexRagDataServiceStub>() {
          @java.lang.Override
          public VertexRagDataServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new VertexRagDataServiceStub(channel, callOptions);
          }
        };
    return VertexRagDataServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static VertexRagDataServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VertexRagDataServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<VertexRagDataServiceBlockingV2Stub>() {
          @java.lang.Override
          public VertexRagDataServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new VertexRagDataServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return VertexRagDataServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static VertexRagDataServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VertexRagDataServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<VertexRagDataServiceBlockingStub>() {
          @java.lang.Override
          public VertexRagDataServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new VertexRagDataServiceBlockingStub(channel, callOptions);
          }
        };
    return VertexRagDataServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static VertexRagDataServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VertexRagDataServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<VertexRagDataServiceFutureStub>() {
          @java.lang.Override
          public VertexRagDataServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new VertexRagDataServiceFutureStub(channel, callOptions);
          }
        };
    return VertexRagDataServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * A service for managing user data for RAG.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a RagCorpus.
     * </pre>
     */
    default void createRagCorpus(
        com.google.cloud.aiplatform.v1beta1.CreateRagCorpusRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateRagCorpusMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a RagCorpus.
     * </pre>
     */
    default void updateRagCorpus(
        com.google.cloud.aiplatform.v1beta1.UpdateRagCorpusRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateRagCorpusMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a RagCorpus.
     * </pre>
     */
    default void getRagCorpus(
        com.google.cloud.aiplatform.v1beta1.GetRagCorpusRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.RagCorpus>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetRagCorpusMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists RagCorpora in a Location.
     * </pre>
     */
    default void listRagCorpora(
        com.google.cloud.aiplatform.v1beta1.ListRagCorporaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListRagCorporaResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRagCorporaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a RagCorpus.
     * </pre>
     */
    default void deleteRagCorpus(
        com.google.cloud.aiplatform.v1beta1.DeleteRagCorpusRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteRagCorpusMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Upload a file into a RagCorpus.
     * </pre>
     */
    default void uploadRagFile(
        com.google.cloud.aiplatform.v1beta1.UploadRagFileRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.UploadRagFileResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUploadRagFileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Import files from Google Cloud Storage or Google Drive into a RagCorpus.
     * </pre>
     */
    default void importRagFiles(
        com.google.cloud.aiplatform.v1beta1.ImportRagFilesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportRagFilesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a RagFile.
     * </pre>
     */
    default void getRagFile(
        com.google.cloud.aiplatform.v1beta1.GetRagFileRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.RagFile> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRagFileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists RagFiles in a RagCorpus.
     * </pre>
     */
    default void listRagFiles(
        com.google.cloud.aiplatform.v1beta1.ListRagFilesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListRagFilesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRagFilesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a RagFile.
     * </pre>
     */
    default void deleteRagFile(
        com.google.cloud.aiplatform.v1beta1.DeleteRagFileRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteRagFileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a RagEngineConfig.
     * </pre>
     */
    default void updateRagEngineConfig(
        com.google.cloud.aiplatform.v1beta1.UpdateRagEngineConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateRagEngineConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a RagEngineConfig.
     * </pre>
     */
    default void getRagEngineConfig(
        com.google.cloud.aiplatform.v1beta1.GetRagEngineConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.RagEngineConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetRagEngineConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a RagDataSchema.
     * </pre>
     */
    default void createRagDataSchema(
        com.google.cloud.aiplatform.v1beta1.CreateRagDataSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.RagDataSchema>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateRagDataSchemaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Batch Create one or more RagDataSchemas
     * </pre>
     */
    default void batchCreateRagDataSchemas(
        com.google.cloud.aiplatform.v1beta1.BatchCreateRagDataSchemasRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchCreateRagDataSchemasMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a RagDataSchema.
     * </pre>
     */
    default void getRagDataSchema(
        com.google.cloud.aiplatform.v1beta1.GetRagDataSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.RagDataSchema>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetRagDataSchemaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists RagDataSchemas in a Location.
     * </pre>
     */
    default void listRagDataSchemas(
        com.google.cloud.aiplatform.v1beta1.ListRagDataSchemasRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListRagDataSchemasResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRagDataSchemasMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a RagDataSchema.
     * </pre>
     */
    default void deleteRagDataSchema(
        com.google.cloud.aiplatform.v1beta1.DeleteRagDataSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteRagDataSchemaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Batch Deletes one or more RagDataSchemas
     * </pre>
     */
    default void batchDeleteRagDataSchemas(
        com.google.cloud.aiplatform.v1beta1.BatchDeleteRagDataSchemasRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchDeleteRagDataSchemasMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a RagMetadata.
     * </pre>
     */
    default void createRagMetadata(
        com.google.cloud.aiplatform.v1beta1.CreateRagMetadataRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.RagMetadata>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateRagMetadataMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Batch Create one or more RagMetadatas
     * </pre>
     */
    default void batchCreateRagMetadata(
        com.google.cloud.aiplatform.v1beta1.BatchCreateRagMetadataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchCreateRagMetadataMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a RagMetadata.
     * </pre>
     */
    default void updateRagMetadata(
        com.google.cloud.aiplatform.v1beta1.UpdateRagMetadataRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.RagMetadata>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateRagMetadataMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a RagMetadata.
     * </pre>
     */
    default void getRagMetadata(
        com.google.cloud.aiplatform.v1beta1.GetRagMetadataRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.RagMetadata>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetRagMetadataMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists RagMetadata in a RagFile.
     * </pre>
     */
    default void listRagMetadata(
        com.google.cloud.aiplatform.v1beta1.ListRagMetadataRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListRagMetadataResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRagMetadataMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a RagMetadata.
     * </pre>
     */
    default void deleteRagMetadata(
        com.google.cloud.aiplatform.v1beta1.DeleteRagMetadataRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteRagMetadataMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Batch Deletes one or more RagMetadata.
     * </pre>
     */
    default void batchDeleteRagMetadata(
        com.google.cloud.aiplatform.v1beta1.BatchDeleteRagMetadataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchDeleteRagMetadataMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service VertexRagDataService.
   *
   * <pre>
   * A service for managing user data for RAG.
   * </pre>
   */
  public abstract static class VertexRagDataServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return VertexRagDataServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service VertexRagDataService.
   *
   * <pre>
   * A service for managing user data for RAG.
   * </pre>
   */
  public static final class VertexRagDataServiceStub
      extends io.grpc.stub.AbstractAsyncStub<VertexRagDataServiceStub> {
    private VertexRagDataServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VertexRagDataServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VertexRagDataServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a RagCorpus.
     * </pre>
     */
    public void createRagCorpus(
        com.google.cloud.aiplatform.v1beta1.CreateRagCorpusRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRagCorpusMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a RagCorpus.
     * </pre>
     */
    public void updateRagCorpus(
        com.google.cloud.aiplatform.v1beta1.UpdateRagCorpusRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateRagCorpusMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a RagCorpus.
     * </pre>
     */
    public void getRagCorpus(
        com.google.cloud.aiplatform.v1beta1.GetRagCorpusRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.RagCorpus>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRagCorpusMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists RagCorpora in a Location.
     * </pre>
     */
    public void listRagCorpora(
        com.google.cloud.aiplatform.v1beta1.ListRagCorporaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListRagCorporaResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRagCorporaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a RagCorpus.
     * </pre>
     */
    public void deleteRagCorpus(
        com.google.cloud.aiplatform.v1beta1.DeleteRagCorpusRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRagCorpusMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Upload a file into a RagCorpus.
     * </pre>
     */
    public void uploadRagFile(
        com.google.cloud.aiplatform.v1beta1.UploadRagFileRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.UploadRagFileResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUploadRagFileMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Import files from Google Cloud Storage or Google Drive into a RagCorpus.
     * </pre>
     */
    public void importRagFiles(
        com.google.cloud.aiplatform.v1beta1.ImportRagFilesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportRagFilesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a RagFile.
     * </pre>
     */
    public void getRagFile(
        com.google.cloud.aiplatform.v1beta1.GetRagFileRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.RagFile> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRagFileMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists RagFiles in a RagCorpus.
     * </pre>
     */
    public void listRagFiles(
        com.google.cloud.aiplatform.v1beta1.ListRagFilesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListRagFilesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRagFilesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a RagFile.
     * </pre>
     */
    public void deleteRagFile(
        com.google.cloud.aiplatform.v1beta1.DeleteRagFileRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRagFileMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a RagEngineConfig.
     * </pre>
     */
    public void updateRagEngineConfig(
        com.google.cloud.aiplatform.v1beta1.UpdateRagEngineConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateRagEngineConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a RagEngineConfig.
     * </pre>
     */
    public void getRagEngineConfig(
        com.google.cloud.aiplatform.v1beta1.GetRagEngineConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.RagEngineConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRagEngineConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a RagDataSchema.
     * </pre>
     */
    public void createRagDataSchema(
        com.google.cloud.aiplatform.v1beta1.CreateRagDataSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.RagDataSchema>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRagDataSchemaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Batch Create one or more RagDataSchemas
     * </pre>
     */
    public void batchCreateRagDataSchemas(
        com.google.cloud.aiplatform.v1beta1.BatchCreateRagDataSchemasRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchCreateRagDataSchemasMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a RagDataSchema.
     * </pre>
     */
    public void getRagDataSchema(
        com.google.cloud.aiplatform.v1beta1.GetRagDataSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.RagDataSchema>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRagDataSchemaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists RagDataSchemas in a Location.
     * </pre>
     */
    public void listRagDataSchemas(
        com.google.cloud.aiplatform.v1beta1.ListRagDataSchemasRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListRagDataSchemasResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRagDataSchemasMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a RagDataSchema.
     * </pre>
     */
    public void deleteRagDataSchema(
        com.google.cloud.aiplatform.v1beta1.DeleteRagDataSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRagDataSchemaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Batch Deletes one or more RagDataSchemas
     * </pre>
     */
    public void batchDeleteRagDataSchemas(
        com.google.cloud.aiplatform.v1beta1.BatchDeleteRagDataSchemasRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchDeleteRagDataSchemasMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a RagMetadata.
     * </pre>
     */
    public void createRagMetadata(
        com.google.cloud.aiplatform.v1beta1.CreateRagMetadataRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.RagMetadata>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRagMetadataMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Batch Create one or more RagMetadatas
     * </pre>
     */
    public void batchCreateRagMetadata(
        com.google.cloud.aiplatform.v1beta1.BatchCreateRagMetadataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchCreateRagMetadataMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a RagMetadata.
     * </pre>
     */
    public void updateRagMetadata(
        com.google.cloud.aiplatform.v1beta1.UpdateRagMetadataRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.RagMetadata>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateRagMetadataMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a RagMetadata.
     * </pre>
     */
    public void getRagMetadata(
        com.google.cloud.aiplatform.v1beta1.GetRagMetadataRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.RagMetadata>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRagMetadataMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists RagMetadata in a RagFile.
     * </pre>
     */
    public void listRagMetadata(
        com.google.cloud.aiplatform.v1beta1.ListRagMetadataRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListRagMetadataResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRagMetadataMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a RagMetadata.
     * </pre>
     */
    public void deleteRagMetadata(
        com.google.cloud.aiplatform.v1beta1.DeleteRagMetadataRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRagMetadataMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Batch Deletes one or more RagMetadata.
     * </pre>
     */
    public void batchDeleteRagMetadata(
        com.google.cloud.aiplatform.v1beta1.BatchDeleteRagMetadataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchDeleteRagMetadataMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service VertexRagDataService.
   *
   * <pre>
   * A service for managing user data for RAG.
   * </pre>
   */
  public static final class VertexRagDataServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<VertexRagDataServiceBlockingV2Stub> {
    private VertexRagDataServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VertexRagDataServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VertexRagDataServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a RagCorpus.
     * </pre>
     */
    public com.google.longrunning.Operation createRagCorpus(
        com.google.cloud.aiplatform.v1beta1.CreateRagCorpusRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateRagCorpusMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a RagCorpus.
     * </pre>
     */
    public com.google.longrunning.Operation updateRagCorpus(
        com.google.cloud.aiplatform.v1beta1.UpdateRagCorpusRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateRagCorpusMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a RagCorpus.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.RagCorpus getRagCorpus(
        com.google.cloud.aiplatform.v1beta1.GetRagCorpusRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetRagCorpusMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists RagCorpora in a Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListRagCorporaResponse listRagCorpora(
        com.google.cloud.aiplatform.v1beta1.ListRagCorporaRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListRagCorporaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a RagCorpus.
     * </pre>
     */
    public com.google.longrunning.Operation deleteRagCorpus(
        com.google.cloud.aiplatform.v1beta1.DeleteRagCorpusRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteRagCorpusMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Upload a file into a RagCorpus.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.UploadRagFileResponse uploadRagFile(
        com.google.cloud.aiplatform.v1beta1.UploadRagFileRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUploadRagFileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Import files from Google Cloud Storage or Google Drive into a RagCorpus.
     * </pre>
     */
    public com.google.longrunning.Operation importRagFiles(
        com.google.cloud.aiplatform.v1beta1.ImportRagFilesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getImportRagFilesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a RagFile.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.RagFile getRagFile(
        com.google.cloud.aiplatform.v1beta1.GetRagFileRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetRagFileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists RagFiles in a RagCorpus.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListRagFilesResponse listRagFiles(
        com.google.cloud.aiplatform.v1beta1.ListRagFilesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListRagFilesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a RagFile.
     * </pre>
     */
    public com.google.longrunning.Operation deleteRagFile(
        com.google.cloud.aiplatform.v1beta1.DeleteRagFileRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteRagFileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a RagEngineConfig.
     * </pre>
     */
    public com.google.longrunning.Operation updateRagEngineConfig(
        com.google.cloud.aiplatform.v1beta1.UpdateRagEngineConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateRagEngineConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a RagEngineConfig.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.RagEngineConfig getRagEngineConfig(
        com.google.cloud.aiplatform.v1beta1.GetRagEngineConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetRagEngineConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a RagDataSchema.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.RagDataSchema createRagDataSchema(
        com.google.cloud.aiplatform.v1beta1.CreateRagDataSchemaRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateRagDataSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Batch Create one or more RagDataSchemas
     * </pre>
     */
    public com.google.longrunning.Operation batchCreateRagDataSchemas(
        com.google.cloud.aiplatform.v1beta1.BatchCreateRagDataSchemasRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getBatchCreateRagDataSchemasMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a RagDataSchema.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.RagDataSchema getRagDataSchema(
        com.google.cloud.aiplatform.v1beta1.GetRagDataSchemaRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetRagDataSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists RagDataSchemas in a Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListRagDataSchemasResponse listRagDataSchemas(
        com.google.cloud.aiplatform.v1beta1.ListRagDataSchemasRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListRagDataSchemasMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a RagDataSchema.
     * </pre>
     */
    public com.google.protobuf.Empty deleteRagDataSchema(
        com.google.cloud.aiplatform.v1beta1.DeleteRagDataSchemaRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteRagDataSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Batch Deletes one or more RagDataSchemas
     * </pre>
     */
    public com.google.longrunning.Operation batchDeleteRagDataSchemas(
        com.google.cloud.aiplatform.v1beta1.BatchDeleteRagDataSchemasRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getBatchDeleteRagDataSchemasMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a RagMetadata.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.RagMetadata createRagMetadata(
        com.google.cloud.aiplatform.v1beta1.CreateRagMetadataRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateRagMetadataMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Batch Create one or more RagMetadatas
     * </pre>
     */
    public com.google.longrunning.Operation batchCreateRagMetadata(
        com.google.cloud.aiplatform.v1beta1.BatchCreateRagMetadataRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getBatchCreateRagMetadataMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a RagMetadata.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.RagMetadata updateRagMetadata(
        com.google.cloud.aiplatform.v1beta1.UpdateRagMetadataRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateRagMetadataMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a RagMetadata.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.RagMetadata getRagMetadata(
        com.google.cloud.aiplatform.v1beta1.GetRagMetadataRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetRagMetadataMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists RagMetadata in a RagFile.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListRagMetadataResponse listRagMetadata(
        com.google.cloud.aiplatform.v1beta1.ListRagMetadataRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListRagMetadataMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a RagMetadata.
     * </pre>
     */
    public com.google.protobuf.Empty deleteRagMetadata(
        com.google.cloud.aiplatform.v1beta1.DeleteRagMetadataRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteRagMetadataMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Batch Deletes one or more RagMetadata.
     * </pre>
     */
    public com.google.longrunning.Operation batchDeleteRagMetadata(
        com.google.cloud.aiplatform.v1beta1.BatchDeleteRagMetadataRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getBatchDeleteRagMetadataMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service VertexRagDataService.
   *
   * <pre>
   * A service for managing user data for RAG.
   * </pre>
   */
  public static final class VertexRagDataServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<VertexRagDataServiceBlockingStub> {
    private VertexRagDataServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VertexRagDataServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VertexRagDataServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a RagCorpus.
     * </pre>
     */
    public com.google.longrunning.Operation createRagCorpus(
        com.google.cloud.aiplatform.v1beta1.CreateRagCorpusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRagCorpusMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a RagCorpus.
     * </pre>
     */
    public com.google.longrunning.Operation updateRagCorpus(
        com.google.cloud.aiplatform.v1beta1.UpdateRagCorpusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRagCorpusMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a RagCorpus.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.RagCorpus getRagCorpus(
        com.google.cloud.aiplatform.v1beta1.GetRagCorpusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRagCorpusMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists RagCorpora in a Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListRagCorporaResponse listRagCorpora(
        com.google.cloud.aiplatform.v1beta1.ListRagCorporaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRagCorporaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a RagCorpus.
     * </pre>
     */
    public com.google.longrunning.Operation deleteRagCorpus(
        com.google.cloud.aiplatform.v1beta1.DeleteRagCorpusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRagCorpusMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Upload a file into a RagCorpus.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.UploadRagFileResponse uploadRagFile(
        com.google.cloud.aiplatform.v1beta1.UploadRagFileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUploadRagFileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Import files from Google Cloud Storage or Google Drive into a RagCorpus.
     * </pre>
     */
    public com.google.longrunning.Operation importRagFiles(
        com.google.cloud.aiplatform.v1beta1.ImportRagFilesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportRagFilesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a RagFile.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.RagFile getRagFile(
        com.google.cloud.aiplatform.v1beta1.GetRagFileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRagFileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists RagFiles in a RagCorpus.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListRagFilesResponse listRagFiles(
        com.google.cloud.aiplatform.v1beta1.ListRagFilesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRagFilesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a RagFile.
     * </pre>
     */
    public com.google.longrunning.Operation deleteRagFile(
        com.google.cloud.aiplatform.v1beta1.DeleteRagFileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRagFileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a RagEngineConfig.
     * </pre>
     */
    public com.google.longrunning.Operation updateRagEngineConfig(
        com.google.cloud.aiplatform.v1beta1.UpdateRagEngineConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRagEngineConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a RagEngineConfig.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.RagEngineConfig getRagEngineConfig(
        com.google.cloud.aiplatform.v1beta1.GetRagEngineConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRagEngineConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a RagDataSchema.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.RagDataSchema createRagDataSchema(
        com.google.cloud.aiplatform.v1beta1.CreateRagDataSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRagDataSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Batch Create one or more RagDataSchemas
     * </pre>
     */
    public com.google.longrunning.Operation batchCreateRagDataSchemas(
        com.google.cloud.aiplatform.v1beta1.BatchCreateRagDataSchemasRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchCreateRagDataSchemasMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a RagDataSchema.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.RagDataSchema getRagDataSchema(
        com.google.cloud.aiplatform.v1beta1.GetRagDataSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRagDataSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists RagDataSchemas in a Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListRagDataSchemasResponse listRagDataSchemas(
        com.google.cloud.aiplatform.v1beta1.ListRagDataSchemasRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRagDataSchemasMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a RagDataSchema.
     * </pre>
     */
    public com.google.protobuf.Empty deleteRagDataSchema(
        com.google.cloud.aiplatform.v1beta1.DeleteRagDataSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRagDataSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Batch Deletes one or more RagDataSchemas
     * </pre>
     */
    public com.google.longrunning.Operation batchDeleteRagDataSchemas(
        com.google.cloud.aiplatform.v1beta1.BatchDeleteRagDataSchemasRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchDeleteRagDataSchemasMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a RagMetadata.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.RagMetadata createRagMetadata(
        com.google.cloud.aiplatform.v1beta1.CreateRagMetadataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRagMetadataMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Batch Create one or more RagMetadatas
     * </pre>
     */
    public com.google.longrunning.Operation batchCreateRagMetadata(
        com.google.cloud.aiplatform.v1beta1.BatchCreateRagMetadataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchCreateRagMetadataMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a RagMetadata.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.RagMetadata updateRagMetadata(
        com.google.cloud.aiplatform.v1beta1.UpdateRagMetadataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRagMetadataMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a RagMetadata.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.RagMetadata getRagMetadata(
        com.google.cloud.aiplatform.v1beta1.GetRagMetadataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRagMetadataMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists RagMetadata in a RagFile.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListRagMetadataResponse listRagMetadata(
        com.google.cloud.aiplatform.v1beta1.ListRagMetadataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRagMetadataMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a RagMetadata.
     * </pre>
     */
    public com.google.protobuf.Empty deleteRagMetadata(
        com.google.cloud.aiplatform.v1beta1.DeleteRagMetadataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRagMetadataMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Batch Deletes one or more RagMetadata.
     * </pre>
     */
    public com.google.longrunning.Operation batchDeleteRagMetadata(
        com.google.cloud.aiplatform.v1beta1.BatchDeleteRagMetadataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchDeleteRagMetadataMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service VertexRagDataService.
   *
   * <pre>
   * A service for managing user data for RAG.
   * </pre>
   */
  public static final class VertexRagDataServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<VertexRagDataServiceFutureStub> {
    private VertexRagDataServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VertexRagDataServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VertexRagDataServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a RagCorpus.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createRagCorpus(com.google.cloud.aiplatform.v1beta1.CreateRagCorpusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRagCorpusMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a RagCorpus.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateRagCorpus(com.google.cloud.aiplatform.v1beta1.UpdateRagCorpusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateRagCorpusMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a RagCorpus.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.RagCorpus>
        getRagCorpus(com.google.cloud.aiplatform.v1beta1.GetRagCorpusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRagCorpusMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists RagCorpora in a Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ListRagCorporaResponse>
        listRagCorpora(com.google.cloud.aiplatform.v1beta1.ListRagCorporaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRagCorporaMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a RagCorpus.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteRagCorpus(com.google.cloud.aiplatform.v1beta1.DeleteRagCorpusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRagCorpusMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Upload a file into a RagCorpus.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.UploadRagFileResponse>
        uploadRagFile(com.google.cloud.aiplatform.v1beta1.UploadRagFileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUploadRagFileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Import files from Google Cloud Storage or Google Drive into a RagCorpus.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importRagFiles(com.google.cloud.aiplatform.v1beta1.ImportRagFilesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportRagFilesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a RagFile.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.RagFile>
        getRagFile(com.google.cloud.aiplatform.v1beta1.GetRagFileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRagFileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists RagFiles in a RagCorpus.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ListRagFilesResponse>
        listRagFiles(com.google.cloud.aiplatform.v1beta1.ListRagFilesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRagFilesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a RagFile.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteRagFile(com.google.cloud.aiplatform.v1beta1.DeleteRagFileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRagFileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a RagEngineConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateRagEngineConfig(
            com.google.cloud.aiplatform.v1beta1.UpdateRagEngineConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateRagEngineConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a RagEngineConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.RagEngineConfig>
        getRagEngineConfig(com.google.cloud.aiplatform.v1beta1.GetRagEngineConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRagEngineConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a RagDataSchema.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.RagDataSchema>
        createRagDataSchema(
            com.google.cloud.aiplatform.v1beta1.CreateRagDataSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRagDataSchemaMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Batch Create one or more RagDataSchemas
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchCreateRagDataSchemas(
            com.google.cloud.aiplatform.v1beta1.BatchCreateRagDataSchemasRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchCreateRagDataSchemasMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a RagDataSchema.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.RagDataSchema>
        getRagDataSchema(com.google.cloud.aiplatform.v1beta1.GetRagDataSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRagDataSchemaMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists RagDataSchemas in a Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ListRagDataSchemasResponse>
        listRagDataSchemas(com.google.cloud.aiplatform.v1beta1.ListRagDataSchemasRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRagDataSchemasMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a RagDataSchema.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteRagDataSchema(
            com.google.cloud.aiplatform.v1beta1.DeleteRagDataSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRagDataSchemaMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Batch Deletes one or more RagDataSchemas
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchDeleteRagDataSchemas(
            com.google.cloud.aiplatform.v1beta1.BatchDeleteRagDataSchemasRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchDeleteRagDataSchemasMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a RagMetadata.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.RagMetadata>
        createRagMetadata(com.google.cloud.aiplatform.v1beta1.CreateRagMetadataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRagMetadataMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Batch Create one or more RagMetadatas
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchCreateRagMetadata(
            com.google.cloud.aiplatform.v1beta1.BatchCreateRagMetadataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchCreateRagMetadataMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a RagMetadata.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.RagMetadata>
        updateRagMetadata(com.google.cloud.aiplatform.v1beta1.UpdateRagMetadataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateRagMetadataMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a RagMetadata.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.RagMetadata>
        getRagMetadata(com.google.cloud.aiplatform.v1beta1.GetRagMetadataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRagMetadataMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists RagMetadata in a RagFile.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ListRagMetadataResponse>
        listRagMetadata(com.google.cloud.aiplatform.v1beta1.ListRagMetadataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRagMetadataMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a RagMetadata.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteRagMetadata(com.google.cloud.aiplatform.v1beta1.DeleteRagMetadataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRagMetadataMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Batch Deletes one or more RagMetadata.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchDeleteRagMetadata(
            com.google.cloud.aiplatform.v1beta1.BatchDeleteRagMetadataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchDeleteRagMetadataMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_RAG_CORPUS = 0;
  private static final int METHODID_UPDATE_RAG_CORPUS = 1;
  private static final int METHODID_GET_RAG_CORPUS = 2;
  private static final int METHODID_LIST_RAG_CORPORA = 3;
  private static final int METHODID_DELETE_RAG_CORPUS = 4;
  private static final int METHODID_UPLOAD_RAG_FILE = 5;
  private static final int METHODID_IMPORT_RAG_FILES = 6;
  private static final int METHODID_GET_RAG_FILE = 7;
  private static final int METHODID_LIST_RAG_FILES = 8;
  private static final int METHODID_DELETE_RAG_FILE = 9;
  private static final int METHODID_UPDATE_RAG_ENGINE_CONFIG = 10;
  private static final int METHODID_GET_RAG_ENGINE_CONFIG = 11;
  private static final int METHODID_CREATE_RAG_DATA_SCHEMA = 12;
  private static final int METHODID_BATCH_CREATE_RAG_DATA_SCHEMAS = 13;
  private static final int METHODID_GET_RAG_DATA_SCHEMA = 14;
  private static final int METHODID_LIST_RAG_DATA_SCHEMAS = 15;
  private static final int METHODID_DELETE_RAG_DATA_SCHEMA = 16;
  private static final int METHODID_BATCH_DELETE_RAG_DATA_SCHEMAS = 17;
  private static final int METHODID_CREATE_RAG_METADATA = 18;
  private static final int METHODID_BATCH_CREATE_RAG_METADATA = 19;
  private static final int METHODID_UPDATE_RAG_METADATA = 20;
  private static final int METHODID_GET_RAG_METADATA = 21;
  private static final int METHODID_LIST_RAG_METADATA = 22;
  private static final int METHODID_DELETE_RAG_METADATA = 23;
  private static final int METHODID_BATCH_DELETE_RAG_METADATA = 24;

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
        case METHODID_CREATE_RAG_CORPUS:
          serviceImpl.createRagCorpus(
              (com.google.cloud.aiplatform.v1beta1.CreateRagCorpusRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_RAG_CORPUS:
          serviceImpl.updateRagCorpus(
              (com.google.cloud.aiplatform.v1beta1.UpdateRagCorpusRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_RAG_CORPUS:
          serviceImpl.getRagCorpus(
              (com.google.cloud.aiplatform.v1beta1.GetRagCorpusRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.RagCorpus>)
                  responseObserver);
          break;
        case METHODID_LIST_RAG_CORPORA:
          serviceImpl.listRagCorpora(
              (com.google.cloud.aiplatform.v1beta1.ListRagCorporaRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ListRagCorporaResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_RAG_CORPUS:
          serviceImpl.deleteRagCorpus(
              (com.google.cloud.aiplatform.v1beta1.DeleteRagCorpusRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPLOAD_RAG_FILE:
          serviceImpl.uploadRagFile(
              (com.google.cloud.aiplatform.v1beta1.UploadRagFileRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.UploadRagFileResponse>)
                  responseObserver);
          break;
        case METHODID_IMPORT_RAG_FILES:
          serviceImpl.importRagFiles(
              (com.google.cloud.aiplatform.v1beta1.ImportRagFilesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_RAG_FILE:
          serviceImpl.getRagFile(
              (com.google.cloud.aiplatform.v1beta1.GetRagFileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.RagFile>)
                  responseObserver);
          break;
        case METHODID_LIST_RAG_FILES:
          serviceImpl.listRagFiles(
              (com.google.cloud.aiplatform.v1beta1.ListRagFilesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ListRagFilesResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_RAG_FILE:
          serviceImpl.deleteRagFile(
              (com.google.cloud.aiplatform.v1beta1.DeleteRagFileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_RAG_ENGINE_CONFIG:
          serviceImpl.updateRagEngineConfig(
              (com.google.cloud.aiplatform.v1beta1.UpdateRagEngineConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_RAG_ENGINE_CONFIG:
          serviceImpl.getRagEngineConfig(
              (com.google.cloud.aiplatform.v1beta1.GetRagEngineConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.RagEngineConfig>)
                  responseObserver);
          break;
        case METHODID_CREATE_RAG_DATA_SCHEMA:
          serviceImpl.createRagDataSchema(
              (com.google.cloud.aiplatform.v1beta1.CreateRagDataSchemaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.RagDataSchema>)
                  responseObserver);
          break;
        case METHODID_BATCH_CREATE_RAG_DATA_SCHEMAS:
          serviceImpl.batchCreateRagDataSchemas(
              (com.google.cloud.aiplatform.v1beta1.BatchCreateRagDataSchemasRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_RAG_DATA_SCHEMA:
          serviceImpl.getRagDataSchema(
              (com.google.cloud.aiplatform.v1beta1.GetRagDataSchemaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.RagDataSchema>)
                  responseObserver);
          break;
        case METHODID_LIST_RAG_DATA_SCHEMAS:
          serviceImpl.listRagDataSchemas(
              (com.google.cloud.aiplatform.v1beta1.ListRagDataSchemasRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ListRagDataSchemasResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_RAG_DATA_SCHEMA:
          serviceImpl.deleteRagDataSchema(
              (com.google.cloud.aiplatform.v1beta1.DeleteRagDataSchemaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_BATCH_DELETE_RAG_DATA_SCHEMAS:
          serviceImpl.batchDeleteRagDataSchemas(
              (com.google.cloud.aiplatform.v1beta1.BatchDeleteRagDataSchemasRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_RAG_METADATA:
          serviceImpl.createRagMetadata(
              (com.google.cloud.aiplatform.v1beta1.CreateRagMetadataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.RagMetadata>)
                  responseObserver);
          break;
        case METHODID_BATCH_CREATE_RAG_METADATA:
          serviceImpl.batchCreateRagMetadata(
              (com.google.cloud.aiplatform.v1beta1.BatchCreateRagMetadataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_RAG_METADATA:
          serviceImpl.updateRagMetadata(
              (com.google.cloud.aiplatform.v1beta1.UpdateRagMetadataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.RagMetadata>)
                  responseObserver);
          break;
        case METHODID_GET_RAG_METADATA:
          serviceImpl.getRagMetadata(
              (com.google.cloud.aiplatform.v1beta1.GetRagMetadataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.RagMetadata>)
                  responseObserver);
          break;
        case METHODID_LIST_RAG_METADATA:
          serviceImpl.listRagMetadata(
              (com.google.cloud.aiplatform.v1beta1.ListRagMetadataRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ListRagMetadataResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_RAG_METADATA:
          serviceImpl.deleteRagMetadata(
              (com.google.cloud.aiplatform.v1beta1.DeleteRagMetadataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_BATCH_DELETE_RAG_METADATA:
          serviceImpl.batchDeleteRagMetadata(
              (com.google.cloud.aiplatform.v1beta1.BatchDeleteRagMetadataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
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
            getCreateRagCorpusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.CreateRagCorpusRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_RAG_CORPUS)))
        .addMethod(
            getUpdateRagCorpusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.UpdateRagCorpusRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_RAG_CORPUS)))
        .addMethod(
            getGetRagCorpusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.GetRagCorpusRequest,
                    com.google.cloud.aiplatform.v1beta1.RagCorpus>(
                    service, METHODID_GET_RAG_CORPUS)))
        .addMethod(
            getListRagCorporaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.ListRagCorporaRequest,
                    com.google.cloud.aiplatform.v1beta1.ListRagCorporaResponse>(
                    service, METHODID_LIST_RAG_CORPORA)))
        .addMethod(
            getDeleteRagCorpusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.DeleteRagCorpusRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_RAG_CORPUS)))
        .addMethod(
            getUploadRagFileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.UploadRagFileRequest,
                    com.google.cloud.aiplatform.v1beta1.UploadRagFileResponse>(
                    service, METHODID_UPLOAD_RAG_FILE)))
        .addMethod(
            getImportRagFilesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.ImportRagFilesRequest,
                    com.google.longrunning.Operation>(service, METHODID_IMPORT_RAG_FILES)))
        .addMethod(
            getGetRagFileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.GetRagFileRequest,
                    com.google.cloud.aiplatform.v1beta1.RagFile>(service, METHODID_GET_RAG_FILE)))
        .addMethod(
            getListRagFilesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.ListRagFilesRequest,
                    com.google.cloud.aiplatform.v1beta1.ListRagFilesResponse>(
                    service, METHODID_LIST_RAG_FILES)))
        .addMethod(
            getDeleteRagFileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.DeleteRagFileRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_RAG_FILE)))
        .addMethod(
            getUpdateRagEngineConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.UpdateRagEngineConfigRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_RAG_ENGINE_CONFIG)))
        .addMethod(
            getGetRagEngineConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.GetRagEngineConfigRequest,
                    com.google.cloud.aiplatform.v1beta1.RagEngineConfig>(
                    service, METHODID_GET_RAG_ENGINE_CONFIG)))
        .addMethod(
            getCreateRagDataSchemaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.CreateRagDataSchemaRequest,
                    com.google.cloud.aiplatform.v1beta1.RagDataSchema>(
                    service, METHODID_CREATE_RAG_DATA_SCHEMA)))
        .addMethod(
            getBatchCreateRagDataSchemasMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.BatchCreateRagDataSchemasRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_BATCH_CREATE_RAG_DATA_SCHEMAS)))
        .addMethod(
            getGetRagDataSchemaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.GetRagDataSchemaRequest,
                    com.google.cloud.aiplatform.v1beta1.RagDataSchema>(
                    service, METHODID_GET_RAG_DATA_SCHEMA)))
        .addMethod(
            getListRagDataSchemasMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.ListRagDataSchemasRequest,
                    com.google.cloud.aiplatform.v1beta1.ListRagDataSchemasResponse>(
                    service, METHODID_LIST_RAG_DATA_SCHEMAS)))
        .addMethod(
            getDeleteRagDataSchemaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.DeleteRagDataSchemaRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_RAG_DATA_SCHEMA)))
        .addMethod(
            getBatchDeleteRagDataSchemasMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.BatchDeleteRagDataSchemasRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_BATCH_DELETE_RAG_DATA_SCHEMAS)))
        .addMethod(
            getCreateRagMetadataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.CreateRagMetadataRequest,
                    com.google.cloud.aiplatform.v1beta1.RagMetadata>(
                    service, METHODID_CREATE_RAG_METADATA)))
        .addMethod(
            getBatchCreateRagMetadataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.BatchCreateRagMetadataRequest,
                    com.google.longrunning.Operation>(service, METHODID_BATCH_CREATE_RAG_METADATA)))
        .addMethod(
            getUpdateRagMetadataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.UpdateRagMetadataRequest,
                    com.google.cloud.aiplatform.v1beta1.RagMetadata>(
                    service, METHODID_UPDATE_RAG_METADATA)))
        .addMethod(
            getGetRagMetadataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.GetRagMetadataRequest,
                    com.google.cloud.aiplatform.v1beta1.RagMetadata>(
                    service, METHODID_GET_RAG_METADATA)))
        .addMethod(
            getListRagMetadataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.ListRagMetadataRequest,
                    com.google.cloud.aiplatform.v1beta1.ListRagMetadataResponse>(
                    service, METHODID_LIST_RAG_METADATA)))
        .addMethod(
            getDeleteRagMetadataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.DeleteRagMetadataRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_RAG_METADATA)))
        .addMethod(
            getBatchDeleteRagMetadataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.BatchDeleteRagMetadataRequest,
                    com.google.longrunning.Operation>(service, METHODID_BATCH_DELETE_RAG_METADATA)))
        .build();
  }

  private abstract static class VertexRagDataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    VertexRagDataServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1beta1.VertexRagDataServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("VertexRagDataService");
    }
  }

  private static final class VertexRagDataServiceFileDescriptorSupplier
      extends VertexRagDataServiceBaseDescriptorSupplier {
    VertexRagDataServiceFileDescriptorSupplier() {}
  }

  private static final class VertexRagDataServiceMethodDescriptorSupplier
      extends VertexRagDataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    VertexRagDataServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (VertexRagDataServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new VertexRagDataServiceFileDescriptorSupplier())
                      .addMethod(getCreateRagCorpusMethod())
                      .addMethod(getUpdateRagCorpusMethod())
                      .addMethod(getGetRagCorpusMethod())
                      .addMethod(getListRagCorporaMethod())
                      .addMethod(getDeleteRagCorpusMethod())
                      .addMethod(getUploadRagFileMethod())
                      .addMethod(getImportRagFilesMethod())
                      .addMethod(getGetRagFileMethod())
                      .addMethod(getListRagFilesMethod())
                      .addMethod(getDeleteRagFileMethod())
                      .addMethod(getUpdateRagEngineConfigMethod())
                      .addMethod(getGetRagEngineConfigMethod())
                      .addMethod(getCreateRagDataSchemaMethod())
                      .addMethod(getBatchCreateRagDataSchemasMethod())
                      .addMethod(getGetRagDataSchemaMethod())
                      .addMethod(getListRagDataSchemasMethod())
                      .addMethod(getDeleteRagDataSchemaMethod())
                      .addMethod(getBatchDeleteRagDataSchemasMethod())
                      .addMethod(getCreateRagMetadataMethod())
                      .addMethod(getBatchCreateRagMetadataMethod())
                      .addMethod(getUpdateRagMetadataMethod())
                      .addMethod(getGetRagMetadataMethod())
                      .addMethod(getListRagMetadataMethod())
                      .addMethod(getDeleteRagMetadataMethod())
                      .addMethod(getBatchDeleteRagMetadataMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
