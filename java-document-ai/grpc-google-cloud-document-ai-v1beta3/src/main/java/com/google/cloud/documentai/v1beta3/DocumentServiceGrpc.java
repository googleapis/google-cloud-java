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
package com.google.cloud.documentai.v1beta3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service to call Cloud DocumentAI to manage document collection (dataset).
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/documentai/v1beta3/document_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DocumentServiceGrpc {

  private DocumentServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.documentai.v1beta3.DocumentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1beta3.UpdateDatasetRequest,
          com.google.longrunning.Operation>
      getUpdateDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDataset",
      requestType = com.google.cloud.documentai.v1beta3.UpdateDatasetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1beta3.UpdateDatasetRequest,
          com.google.longrunning.Operation>
      getUpdateDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.documentai.v1beta3.UpdateDatasetRequest,
            com.google.longrunning.Operation>
        getUpdateDatasetMethod;
    if ((getUpdateDatasetMethod = DocumentServiceGrpc.getUpdateDatasetMethod) == null) {
      synchronized (DocumentServiceGrpc.class) {
        if ((getUpdateDatasetMethod = DocumentServiceGrpc.getUpdateDatasetMethod) == null) {
          DocumentServiceGrpc.getUpdateDatasetMethod =
              getUpdateDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.documentai.v1beta3.UpdateDatasetRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1beta3.UpdateDatasetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentServiceMethodDescriptorSupplier("UpdateDataset"))
                      .build();
        }
      }
    }
    return getUpdateDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1beta3.ImportDocumentsRequest,
          com.google.longrunning.Operation>
      getImportDocumentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportDocuments",
      requestType = com.google.cloud.documentai.v1beta3.ImportDocumentsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1beta3.ImportDocumentsRequest,
          com.google.longrunning.Operation>
      getImportDocumentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.documentai.v1beta3.ImportDocumentsRequest,
            com.google.longrunning.Operation>
        getImportDocumentsMethod;
    if ((getImportDocumentsMethod = DocumentServiceGrpc.getImportDocumentsMethod) == null) {
      synchronized (DocumentServiceGrpc.class) {
        if ((getImportDocumentsMethod = DocumentServiceGrpc.getImportDocumentsMethod) == null) {
          DocumentServiceGrpc.getImportDocumentsMethod =
              getImportDocumentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.documentai.v1beta3.ImportDocumentsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportDocuments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1beta3.ImportDocumentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentServiceMethodDescriptorSupplier("ImportDocuments"))
                      .build();
        }
      }
    }
    return getImportDocumentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1beta3.GetDocumentRequest,
          com.google.cloud.documentai.v1beta3.GetDocumentResponse>
      getGetDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDocument",
      requestType = com.google.cloud.documentai.v1beta3.GetDocumentRequest.class,
      responseType = com.google.cloud.documentai.v1beta3.GetDocumentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1beta3.GetDocumentRequest,
          com.google.cloud.documentai.v1beta3.GetDocumentResponse>
      getGetDocumentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.documentai.v1beta3.GetDocumentRequest,
            com.google.cloud.documentai.v1beta3.GetDocumentResponse>
        getGetDocumentMethod;
    if ((getGetDocumentMethod = DocumentServiceGrpc.getGetDocumentMethod) == null) {
      synchronized (DocumentServiceGrpc.class) {
        if ((getGetDocumentMethod = DocumentServiceGrpc.getGetDocumentMethod) == null) {
          DocumentServiceGrpc.getGetDocumentMethod =
              getGetDocumentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.documentai.v1beta3.GetDocumentRequest,
                          com.google.cloud.documentai.v1beta3.GetDocumentResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDocument"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1beta3.GetDocumentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1beta3.GetDocumentResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentServiceMethodDescriptorSupplier("GetDocument"))
                      .build();
        }
      }
    }
    return getGetDocumentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1beta3.ListDocumentsRequest,
          com.google.cloud.documentai.v1beta3.ListDocumentsResponse>
      getListDocumentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDocuments",
      requestType = com.google.cloud.documentai.v1beta3.ListDocumentsRequest.class,
      responseType = com.google.cloud.documentai.v1beta3.ListDocumentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1beta3.ListDocumentsRequest,
          com.google.cloud.documentai.v1beta3.ListDocumentsResponse>
      getListDocumentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.documentai.v1beta3.ListDocumentsRequest,
            com.google.cloud.documentai.v1beta3.ListDocumentsResponse>
        getListDocumentsMethod;
    if ((getListDocumentsMethod = DocumentServiceGrpc.getListDocumentsMethod) == null) {
      synchronized (DocumentServiceGrpc.class) {
        if ((getListDocumentsMethod = DocumentServiceGrpc.getListDocumentsMethod) == null) {
          DocumentServiceGrpc.getListDocumentsMethod =
              getListDocumentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.documentai.v1beta3.ListDocumentsRequest,
                          com.google.cloud.documentai.v1beta3.ListDocumentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDocuments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1beta3.ListDocumentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1beta3.ListDocumentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentServiceMethodDescriptorSupplier("ListDocuments"))
                      .build();
        }
      }
    }
    return getListDocumentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1beta3.BatchDeleteDocumentsRequest,
          com.google.longrunning.Operation>
      getBatchDeleteDocumentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchDeleteDocuments",
      requestType = com.google.cloud.documentai.v1beta3.BatchDeleteDocumentsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1beta3.BatchDeleteDocumentsRequest,
          com.google.longrunning.Operation>
      getBatchDeleteDocumentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.documentai.v1beta3.BatchDeleteDocumentsRequest,
            com.google.longrunning.Operation>
        getBatchDeleteDocumentsMethod;
    if ((getBatchDeleteDocumentsMethod = DocumentServiceGrpc.getBatchDeleteDocumentsMethod)
        == null) {
      synchronized (DocumentServiceGrpc.class) {
        if ((getBatchDeleteDocumentsMethod = DocumentServiceGrpc.getBatchDeleteDocumentsMethod)
            == null) {
          DocumentServiceGrpc.getBatchDeleteDocumentsMethod =
              getBatchDeleteDocumentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.documentai.v1beta3.BatchDeleteDocumentsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchDeleteDocuments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1beta3.BatchDeleteDocumentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentServiceMethodDescriptorSupplier("BatchDeleteDocuments"))
                      .build();
        }
      }
    }
    return getBatchDeleteDocumentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1beta3.GetDatasetSchemaRequest,
          com.google.cloud.documentai.v1beta3.DatasetSchema>
      getGetDatasetSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDatasetSchema",
      requestType = com.google.cloud.documentai.v1beta3.GetDatasetSchemaRequest.class,
      responseType = com.google.cloud.documentai.v1beta3.DatasetSchema.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1beta3.GetDatasetSchemaRequest,
          com.google.cloud.documentai.v1beta3.DatasetSchema>
      getGetDatasetSchemaMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.documentai.v1beta3.GetDatasetSchemaRequest,
            com.google.cloud.documentai.v1beta3.DatasetSchema>
        getGetDatasetSchemaMethod;
    if ((getGetDatasetSchemaMethod = DocumentServiceGrpc.getGetDatasetSchemaMethod) == null) {
      synchronized (DocumentServiceGrpc.class) {
        if ((getGetDatasetSchemaMethod = DocumentServiceGrpc.getGetDatasetSchemaMethod) == null) {
          DocumentServiceGrpc.getGetDatasetSchemaMethod =
              getGetDatasetSchemaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.documentai.v1beta3.GetDatasetSchemaRequest,
                          com.google.cloud.documentai.v1beta3.DatasetSchema>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDatasetSchema"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1beta3.GetDatasetSchemaRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1beta3.DatasetSchema
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentServiceMethodDescriptorSupplier("GetDatasetSchema"))
                      .build();
        }
      }
    }
    return getGetDatasetSchemaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1beta3.UpdateDatasetSchemaRequest,
          com.google.cloud.documentai.v1beta3.DatasetSchema>
      getUpdateDatasetSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDatasetSchema",
      requestType = com.google.cloud.documentai.v1beta3.UpdateDatasetSchemaRequest.class,
      responseType = com.google.cloud.documentai.v1beta3.DatasetSchema.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1beta3.UpdateDatasetSchemaRequest,
          com.google.cloud.documentai.v1beta3.DatasetSchema>
      getUpdateDatasetSchemaMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.documentai.v1beta3.UpdateDatasetSchemaRequest,
            com.google.cloud.documentai.v1beta3.DatasetSchema>
        getUpdateDatasetSchemaMethod;
    if ((getUpdateDatasetSchemaMethod = DocumentServiceGrpc.getUpdateDatasetSchemaMethod) == null) {
      synchronized (DocumentServiceGrpc.class) {
        if ((getUpdateDatasetSchemaMethod = DocumentServiceGrpc.getUpdateDatasetSchemaMethod)
            == null) {
          DocumentServiceGrpc.getUpdateDatasetSchemaMethod =
              getUpdateDatasetSchemaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.documentai.v1beta3.UpdateDatasetSchemaRequest,
                          com.google.cloud.documentai.v1beta3.DatasetSchema>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateDatasetSchema"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1beta3.UpdateDatasetSchemaRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1beta3.DatasetSchema
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentServiceMethodDescriptorSupplier("UpdateDatasetSchema"))
                      .build();
        }
      }
    }
    return getUpdateDatasetSchemaMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DocumentServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DocumentServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DocumentServiceStub>() {
          @java.lang.Override
          public DocumentServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DocumentServiceStub(channel, callOptions);
          }
        };
    return DocumentServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DocumentServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DocumentServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DocumentServiceBlockingStub>() {
          @java.lang.Override
          public DocumentServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DocumentServiceBlockingStub(channel, callOptions);
          }
        };
    return DocumentServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DocumentServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DocumentServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DocumentServiceFutureStub>() {
          @java.lang.Override
          public DocumentServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DocumentServiceFutureStub(channel, callOptions);
          }
        };
    return DocumentServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to call Cloud DocumentAI to manage document collection (dataset).
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Updates metadata associated with a dataset.
     * </pre>
     */
    default void updateDataset(
        com.google.cloud.documentai.v1beta3.UpdateDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDatasetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Import documents into a dataset.
     * </pre>
     */
    default void importDocuments(
        com.google.cloud.documentai.v1beta3.ImportDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportDocumentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns relevant fields present in the requested document.
     * </pre>
     */
    default void getDocument(
        com.google.cloud.documentai.v1beta3.GetDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1beta3.GetDocumentResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDocumentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of documents present in the dataset.
     * </pre>
     */
    default void listDocuments(
        com.google.cloud.documentai.v1beta3.ListDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1beta3.ListDocumentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDocumentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a set of documents.
     * </pre>
     */
    default void batchDeleteDocuments(
        com.google.cloud.documentai.v1beta3.BatchDeleteDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchDeleteDocumentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the `DatasetSchema` of a `Dataset`.
     * </pre>
     */
    default void getDatasetSchema(
        com.google.cloud.documentai.v1beta3.GetDatasetSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1beta3.DatasetSchema>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDatasetSchemaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a `DatasetSchema`.
     * </pre>
     */
    default void updateDatasetSchema(
        com.google.cloud.documentai.v1beta3.UpdateDatasetSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1beta3.DatasetSchema>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDatasetSchemaMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DocumentService.
   *
   * <pre>
   * Service to call Cloud DocumentAI to manage document collection (dataset).
   * </pre>
   */
  public abstract static class DocumentServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DocumentServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DocumentService.
   *
   * <pre>
   * Service to call Cloud DocumentAI to manage document collection (dataset).
   * </pre>
   */
  public static final class DocumentServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DocumentServiceStub> {
    private DocumentServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DocumentServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DocumentServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Updates metadata associated with a dataset.
     * </pre>
     */
    public void updateDataset(
        com.google.cloud.documentai.v1beta3.UpdateDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDatasetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Import documents into a dataset.
     * </pre>
     */
    public void importDocuments(
        com.google.cloud.documentai.v1beta3.ImportDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportDocumentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns relevant fields present in the requested document.
     * </pre>
     */
    public void getDocument(
        com.google.cloud.documentai.v1beta3.GetDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1beta3.GetDocumentResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDocumentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of documents present in the dataset.
     * </pre>
     */
    public void listDocuments(
        com.google.cloud.documentai.v1beta3.ListDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1beta3.ListDocumentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDocumentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a set of documents.
     * </pre>
     */
    public void batchDeleteDocuments(
        com.google.cloud.documentai.v1beta3.BatchDeleteDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchDeleteDocumentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the `DatasetSchema` of a `Dataset`.
     * </pre>
     */
    public void getDatasetSchema(
        com.google.cloud.documentai.v1beta3.GetDatasetSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1beta3.DatasetSchema>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDatasetSchemaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a `DatasetSchema`.
     * </pre>
     */
    public void updateDatasetSchema(
        com.google.cloud.documentai.v1beta3.UpdateDatasetSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1beta3.DatasetSchema>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDatasetSchemaMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DocumentService.
   *
   * <pre>
   * Service to call Cloud DocumentAI to manage document collection (dataset).
   * </pre>
   */
  public static final class DocumentServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DocumentServiceBlockingStub> {
    private DocumentServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DocumentServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DocumentServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Updates metadata associated with a dataset.
     * </pre>
     */
    public com.google.longrunning.Operation updateDataset(
        com.google.cloud.documentai.v1beta3.UpdateDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Import documents into a dataset.
     * </pre>
     */
    public com.google.longrunning.Operation importDocuments(
        com.google.cloud.documentai.v1beta3.ImportDocumentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportDocumentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns relevant fields present in the requested document.
     * </pre>
     */
    public com.google.cloud.documentai.v1beta3.GetDocumentResponse getDocument(
        com.google.cloud.documentai.v1beta3.GetDocumentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDocumentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of documents present in the dataset.
     * </pre>
     */
    public com.google.cloud.documentai.v1beta3.ListDocumentsResponse listDocuments(
        com.google.cloud.documentai.v1beta3.ListDocumentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDocumentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a set of documents.
     * </pre>
     */
    public com.google.longrunning.Operation batchDeleteDocuments(
        com.google.cloud.documentai.v1beta3.BatchDeleteDocumentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchDeleteDocumentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the `DatasetSchema` of a `Dataset`.
     * </pre>
     */
    public com.google.cloud.documentai.v1beta3.DatasetSchema getDatasetSchema(
        com.google.cloud.documentai.v1beta3.GetDatasetSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDatasetSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a `DatasetSchema`.
     * </pre>
     */
    public com.google.cloud.documentai.v1beta3.DatasetSchema updateDatasetSchema(
        com.google.cloud.documentai.v1beta3.UpdateDatasetSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDatasetSchemaMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DocumentService.
   *
   * <pre>
   * Service to call Cloud DocumentAI to manage document collection (dataset).
   * </pre>
   */
  public static final class DocumentServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DocumentServiceFutureStub> {
    private DocumentServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DocumentServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DocumentServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Updates metadata associated with a dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateDataset(com.google.cloud.documentai.v1beta3.UpdateDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDatasetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Import documents into a dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importDocuments(com.google.cloud.documentai.v1beta3.ImportDocumentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportDocumentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns relevant fields present in the requested document.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.documentai.v1beta3.GetDocumentResponse>
        getDocument(com.google.cloud.documentai.v1beta3.GetDocumentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDocumentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of documents present in the dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.documentai.v1beta3.ListDocumentsResponse>
        listDocuments(com.google.cloud.documentai.v1beta3.ListDocumentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDocumentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a set of documents.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchDeleteDocuments(
            com.google.cloud.documentai.v1beta3.BatchDeleteDocumentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchDeleteDocumentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the `DatasetSchema` of a `Dataset`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.documentai.v1beta3.DatasetSchema>
        getDatasetSchema(com.google.cloud.documentai.v1beta3.GetDatasetSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDatasetSchemaMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a `DatasetSchema`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.documentai.v1beta3.DatasetSchema>
        updateDatasetSchema(
            com.google.cloud.documentai.v1beta3.UpdateDatasetSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDatasetSchemaMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_UPDATE_DATASET = 0;
  private static final int METHODID_IMPORT_DOCUMENTS = 1;
  private static final int METHODID_GET_DOCUMENT = 2;
  private static final int METHODID_LIST_DOCUMENTS = 3;
  private static final int METHODID_BATCH_DELETE_DOCUMENTS = 4;
  private static final int METHODID_GET_DATASET_SCHEMA = 5;
  private static final int METHODID_UPDATE_DATASET_SCHEMA = 6;

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
        case METHODID_UPDATE_DATASET:
          serviceImpl.updateDataset(
              (com.google.cloud.documentai.v1beta3.UpdateDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_IMPORT_DOCUMENTS:
          serviceImpl.importDocuments(
              (com.google.cloud.documentai.v1beta3.ImportDocumentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_DOCUMENT:
          serviceImpl.getDocument(
              (com.google.cloud.documentai.v1beta3.GetDocumentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1beta3.GetDocumentResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_DOCUMENTS:
          serviceImpl.listDocuments(
              (com.google.cloud.documentai.v1beta3.ListDocumentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.documentai.v1beta3.ListDocumentsResponse>)
                  responseObserver);
          break;
        case METHODID_BATCH_DELETE_DOCUMENTS:
          serviceImpl.batchDeleteDocuments(
              (com.google.cloud.documentai.v1beta3.BatchDeleteDocumentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_DATASET_SCHEMA:
          serviceImpl.getDatasetSchema(
              (com.google.cloud.documentai.v1beta3.GetDatasetSchemaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1beta3.DatasetSchema>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DATASET_SCHEMA:
          serviceImpl.updateDatasetSchema(
              (com.google.cloud.documentai.v1beta3.UpdateDatasetSchemaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1beta3.DatasetSchema>)
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
            getUpdateDatasetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.documentai.v1beta3.UpdateDatasetRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_DATASET)))
        .addMethod(
            getImportDocumentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.documentai.v1beta3.ImportDocumentsRequest,
                    com.google.longrunning.Operation>(service, METHODID_IMPORT_DOCUMENTS)))
        .addMethod(
            getGetDocumentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.documentai.v1beta3.GetDocumentRequest,
                    com.google.cloud.documentai.v1beta3.GetDocumentResponse>(
                    service, METHODID_GET_DOCUMENT)))
        .addMethod(
            getListDocumentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.documentai.v1beta3.ListDocumentsRequest,
                    com.google.cloud.documentai.v1beta3.ListDocumentsResponse>(
                    service, METHODID_LIST_DOCUMENTS)))
        .addMethod(
            getBatchDeleteDocumentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.documentai.v1beta3.BatchDeleteDocumentsRequest,
                    com.google.longrunning.Operation>(service, METHODID_BATCH_DELETE_DOCUMENTS)))
        .addMethod(
            getGetDatasetSchemaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.documentai.v1beta3.GetDatasetSchemaRequest,
                    com.google.cloud.documentai.v1beta3.DatasetSchema>(
                    service, METHODID_GET_DATASET_SCHEMA)))
        .addMethod(
            getUpdateDatasetSchemaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.documentai.v1beta3.UpdateDatasetSchemaRequest,
                    com.google.cloud.documentai.v1beta3.DatasetSchema>(
                    service, METHODID_UPDATE_DATASET_SCHEMA)))
        .build();
  }

  private abstract static class DocumentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DocumentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.documentai.v1beta3.DocumentAiDocumentService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DocumentService");
    }
  }

  private static final class DocumentServiceFileDescriptorSupplier
      extends DocumentServiceBaseDescriptorSupplier {
    DocumentServiceFileDescriptorSupplier() {}
  }

  private static final class DocumentServiceMethodDescriptorSupplier
      extends DocumentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DocumentServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DocumentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DocumentServiceFileDescriptorSupplier())
                      .addMethod(getUpdateDatasetMethod())
                      .addMethod(getImportDocumentsMethod())
                      .addMethod(getGetDocumentMethod())
                      .addMethod(getListDocumentsMethod())
                      .addMethod(getBatchDeleteDocumentsMethod())
                      .addMethod(getGetDatasetSchemaMethod())
                      .addMethod(getUpdateDatasetSchemaMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
