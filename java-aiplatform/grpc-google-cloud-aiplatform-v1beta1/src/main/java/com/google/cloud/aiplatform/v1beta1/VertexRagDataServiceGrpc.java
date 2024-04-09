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
package com.google.cloud.aiplatform.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A service for managing user data for RAG.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1beta1/vertex_rag_data_service.proto")
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
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service VertexRagDataService.
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
  }

  private static final int METHODID_CREATE_RAG_CORPUS = 0;
  private static final int METHODID_GET_RAG_CORPUS = 1;
  private static final int METHODID_LIST_RAG_CORPORA = 2;
  private static final int METHODID_DELETE_RAG_CORPUS = 3;
  private static final int METHODID_UPLOAD_RAG_FILE = 4;
  private static final int METHODID_IMPORT_RAG_FILES = 5;
  private static final int METHODID_GET_RAG_FILE = 6;
  private static final int METHODID_LIST_RAG_FILES = 7;
  private static final int METHODID_DELETE_RAG_FILE = 8;

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
                      .addMethod(getGetRagCorpusMethod())
                      .addMethod(getListRagCorporaMethod())
                      .addMethod(getDeleteRagCorpusMethod())
                      .addMethod(getUploadRagFileMethod())
                      .addMethod(getImportRagFilesMethod())
                      .addMethod(getGetRagFileMethod())
                      .addMethod(getListRagFilesMethod())
                      .addMethod(getDeleteRagFileMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
