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
package com.google.cloud.dialogflow.v2beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing knowledge [Documents][google.cloud.dialogflow.v2beta1.Document].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/v2beta1/document.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DocumentsGrpc {

  private DocumentsGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dialogflow.v2beta1.Documents";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.ListDocumentsRequest,
          com.google.cloud.dialogflow.v2beta1.ListDocumentsResponse>
      getListDocumentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDocuments",
      requestType = com.google.cloud.dialogflow.v2beta1.ListDocumentsRequest.class,
      responseType = com.google.cloud.dialogflow.v2beta1.ListDocumentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.ListDocumentsRequest,
          com.google.cloud.dialogflow.v2beta1.ListDocumentsResponse>
      getListDocumentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.ListDocumentsRequest,
            com.google.cloud.dialogflow.v2beta1.ListDocumentsResponse>
        getListDocumentsMethod;
    if ((getListDocumentsMethod = DocumentsGrpc.getListDocumentsMethod) == null) {
      synchronized (DocumentsGrpc.class) {
        if ((getListDocumentsMethod = DocumentsGrpc.getListDocumentsMethod) == null) {
          DocumentsGrpc.getListDocumentsMethod =
              getListDocumentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.ListDocumentsRequest,
                          com.google.cloud.dialogflow.v2beta1.ListDocumentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDocuments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.ListDocumentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.ListDocumentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new DocumentsMethodDescriptorSupplier("ListDocuments"))
                      .build();
        }
      }
    }
    return getListDocumentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.GetDocumentRequest,
          com.google.cloud.dialogflow.v2beta1.Document>
      getGetDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDocument",
      requestType = com.google.cloud.dialogflow.v2beta1.GetDocumentRequest.class,
      responseType = com.google.cloud.dialogflow.v2beta1.Document.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.GetDocumentRequest,
          com.google.cloud.dialogflow.v2beta1.Document>
      getGetDocumentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.GetDocumentRequest,
            com.google.cloud.dialogflow.v2beta1.Document>
        getGetDocumentMethod;
    if ((getGetDocumentMethod = DocumentsGrpc.getGetDocumentMethod) == null) {
      synchronized (DocumentsGrpc.class) {
        if ((getGetDocumentMethod = DocumentsGrpc.getGetDocumentMethod) == null) {
          DocumentsGrpc.getGetDocumentMethod =
              getGetDocumentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.GetDocumentRequest,
                          com.google.cloud.dialogflow.v2beta1.Document>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDocument"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.GetDocumentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.Document.getDefaultInstance()))
                      .setSchemaDescriptor(new DocumentsMethodDescriptorSupplier("GetDocument"))
                      .build();
        }
      }
    }
    return getGetDocumentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.CreateDocumentRequest,
          com.google.longrunning.Operation>
      getCreateDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDocument",
      requestType = com.google.cloud.dialogflow.v2beta1.CreateDocumentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.CreateDocumentRequest,
          com.google.longrunning.Operation>
      getCreateDocumentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.CreateDocumentRequest,
            com.google.longrunning.Operation>
        getCreateDocumentMethod;
    if ((getCreateDocumentMethod = DocumentsGrpc.getCreateDocumentMethod) == null) {
      synchronized (DocumentsGrpc.class) {
        if ((getCreateDocumentMethod = DocumentsGrpc.getCreateDocumentMethod) == null) {
          DocumentsGrpc.getCreateDocumentMethod =
              getCreateDocumentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.CreateDocumentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDocument"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.CreateDocumentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new DocumentsMethodDescriptorSupplier("CreateDocument"))
                      .build();
        }
      }
    }
    return getCreateDocumentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.ImportDocumentsRequest,
          com.google.longrunning.Operation>
      getImportDocumentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportDocuments",
      requestType = com.google.cloud.dialogflow.v2beta1.ImportDocumentsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.ImportDocumentsRequest,
          com.google.longrunning.Operation>
      getImportDocumentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.ImportDocumentsRequest,
            com.google.longrunning.Operation>
        getImportDocumentsMethod;
    if ((getImportDocumentsMethod = DocumentsGrpc.getImportDocumentsMethod) == null) {
      synchronized (DocumentsGrpc.class) {
        if ((getImportDocumentsMethod = DocumentsGrpc.getImportDocumentsMethod) == null) {
          DocumentsGrpc.getImportDocumentsMethod =
              getImportDocumentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.ImportDocumentsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportDocuments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.ImportDocumentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new DocumentsMethodDescriptorSupplier("ImportDocuments"))
                      .build();
        }
      }
    }
    return getImportDocumentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.DeleteDocumentRequest,
          com.google.longrunning.Operation>
      getDeleteDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDocument",
      requestType = com.google.cloud.dialogflow.v2beta1.DeleteDocumentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.DeleteDocumentRequest,
          com.google.longrunning.Operation>
      getDeleteDocumentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.DeleteDocumentRequest,
            com.google.longrunning.Operation>
        getDeleteDocumentMethod;
    if ((getDeleteDocumentMethod = DocumentsGrpc.getDeleteDocumentMethod) == null) {
      synchronized (DocumentsGrpc.class) {
        if ((getDeleteDocumentMethod = DocumentsGrpc.getDeleteDocumentMethod) == null) {
          DocumentsGrpc.getDeleteDocumentMethod =
              getDeleteDocumentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.DeleteDocumentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDocument"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.DeleteDocumentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new DocumentsMethodDescriptorSupplier("DeleteDocument"))
                      .build();
        }
      }
    }
    return getDeleteDocumentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.UpdateDocumentRequest,
          com.google.longrunning.Operation>
      getUpdateDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDocument",
      requestType = com.google.cloud.dialogflow.v2beta1.UpdateDocumentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.UpdateDocumentRequest,
          com.google.longrunning.Operation>
      getUpdateDocumentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.UpdateDocumentRequest,
            com.google.longrunning.Operation>
        getUpdateDocumentMethod;
    if ((getUpdateDocumentMethod = DocumentsGrpc.getUpdateDocumentMethod) == null) {
      synchronized (DocumentsGrpc.class) {
        if ((getUpdateDocumentMethod = DocumentsGrpc.getUpdateDocumentMethod) == null) {
          DocumentsGrpc.getUpdateDocumentMethod =
              getUpdateDocumentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.UpdateDocumentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDocument"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.UpdateDocumentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new DocumentsMethodDescriptorSupplier("UpdateDocument"))
                      .build();
        }
      }
    }
    return getUpdateDocumentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.ReloadDocumentRequest,
          com.google.longrunning.Operation>
      getReloadDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReloadDocument",
      requestType = com.google.cloud.dialogflow.v2beta1.ReloadDocumentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.ReloadDocumentRequest,
          com.google.longrunning.Operation>
      getReloadDocumentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.ReloadDocumentRequest,
            com.google.longrunning.Operation>
        getReloadDocumentMethod;
    if ((getReloadDocumentMethod = DocumentsGrpc.getReloadDocumentMethod) == null) {
      synchronized (DocumentsGrpc.class) {
        if ((getReloadDocumentMethod = DocumentsGrpc.getReloadDocumentMethod) == null) {
          DocumentsGrpc.getReloadDocumentMethod =
              getReloadDocumentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.ReloadDocumentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReloadDocument"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.ReloadDocumentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new DocumentsMethodDescriptorSupplier("ReloadDocument"))
                      .build();
        }
      }
    }
    return getReloadDocumentMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DocumentsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DocumentsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DocumentsStub>() {
          @java.lang.Override
          public DocumentsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DocumentsStub(channel, callOptions);
          }
        };
    return DocumentsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DocumentsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DocumentsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DocumentsBlockingStub>() {
          @java.lang.Override
          public DocumentsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DocumentsBlockingStub(channel, callOptions);
          }
        };
    return DocumentsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DocumentsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DocumentsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DocumentsFutureStub>() {
          @java.lang.Override
          public DocumentsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DocumentsFutureStub(channel, callOptions);
          }
        };
    return DocumentsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing knowledge [Documents][google.cloud.dialogflow.v2beta1.Document].
   * </pre>
   */
  public abstract static class DocumentsImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Returns the list of all documents of the knowledge base.
     * Note: The `projects.agent.knowledgeBases.documents` resource is deprecated;
     * only use `projects.knowledgeBases.documents`.
     * </pre>
     */
    public void listDocuments(
        com.google.cloud.dialogflow.v2beta1.ListDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.ListDocumentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDocumentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified document.
     * Note: The `projects.agent.knowledgeBases.documents` resource is deprecated;
     * only use `projects.knowledgeBases.documents`.
     * </pre>
     */
    public void getDocument(
        com.google.cloud.dialogflow.v2beta1.GetDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Document>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDocumentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new document.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [KnowledgeOperationMetadata][google.cloud.dialogflow.v2beta1.KnowledgeOperationMetadata]
     * - `response`: [Document][google.cloud.dialogflow.v2beta1.Document]
     * Note: The `projects.agent.knowledgeBases.documents` resource is deprecated;
     * only use `projects.knowledgeBases.documents`.
     * </pre>
     */
    public void createDocument(
        com.google.cloud.dialogflow.v2beta1.CreateDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDocumentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create documents by importing data from external sources.
     * Dialogflow supports up to 350 documents in each request. If you try to
     * import more, Dialogflow will return an error.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [KnowledgeOperationMetadata][google.cloud.dialogflow.v2beta1.KnowledgeOperationMetadata]
     * - `response`: [ImportDocumentsResponse][google.cloud.dialogflow.v2beta1.ImportDocumentsResponse]
     * </pre>
     */
    public void importDocuments(
        com.google.cloud.dialogflow.v2beta1.ImportDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportDocumentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified document.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [KnowledgeOperationMetadata][google.cloud.dialogflow.v2beta1.KnowledgeOperationMetadata]
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * Note: The `projects.agent.knowledgeBases.documents` resource is deprecated;
     * only use `projects.knowledgeBases.documents`.
     * </pre>
     */
    public void deleteDocument(
        com.google.cloud.dialogflow.v2beta1.DeleteDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDocumentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified document.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [KnowledgeOperationMetadata][google.cloud.dialogflow.v2beta1.KnowledgeOperationMetadata]
     * - `response`: [Document][google.cloud.dialogflow.v2beta1.Document]
     * Note: The `projects.agent.knowledgeBases.documents` resource is deprecated;
     * only use `projects.knowledgeBases.documents`.
     * </pre>
     */
    public void updateDocument(
        com.google.cloud.dialogflow.v2beta1.UpdateDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDocumentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reloads the specified document from its specified source, content_uri or
     * content. The previously loaded content of the document will be deleted.
     * Note: Even when the content of the document has not changed, there still
     * may be side effects because of internal implementation changes.
     * Note: If the document source is Google Cloud Storage URI, its metadata will
     * be replaced with the custom metadata from Google Cloud Storage if the
     * `import_gcs_custom_metadata` field is set to true in the request.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [KnowledgeOperationMetadata][google.cloud.dialogflow.v2beta1.KnowledgeOperationMetadata]
     * - `response`: [Document][google.cloud.dialogflow.v2beta1.Document]
     * Note: The `projects.agent.knowledgeBases.documents` resource is deprecated;
     * only use `projects.knowledgeBases.documents`.
     * </pre>
     */
    public void reloadDocument(
        com.google.cloud.dialogflow.v2beta1.ReloadDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getReloadDocumentMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListDocumentsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.ListDocumentsRequest,
                      com.google.cloud.dialogflow.v2beta1.ListDocumentsResponse>(
                      this, METHODID_LIST_DOCUMENTS)))
          .addMethod(
              getGetDocumentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.GetDocumentRequest,
                      com.google.cloud.dialogflow.v2beta1.Document>(this, METHODID_GET_DOCUMENT)))
          .addMethod(
              getCreateDocumentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.CreateDocumentRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_DOCUMENT)))
          .addMethod(
              getImportDocumentsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.ImportDocumentsRequest,
                      com.google.longrunning.Operation>(this, METHODID_IMPORT_DOCUMENTS)))
          .addMethod(
              getDeleteDocumentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.DeleteDocumentRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_DOCUMENT)))
          .addMethod(
              getUpdateDocumentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.UpdateDocumentRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_DOCUMENT)))
          .addMethod(
              getReloadDocumentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.ReloadDocumentRequest,
                      com.google.longrunning.Operation>(this, METHODID_RELOAD_DOCUMENT)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing knowledge [Documents][google.cloud.dialogflow.v2beta1.Document].
   * </pre>
   */
  public static final class DocumentsStub extends io.grpc.stub.AbstractAsyncStub<DocumentsStub> {
    private DocumentsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DocumentsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DocumentsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all documents of the knowledge base.
     * Note: The `projects.agent.knowledgeBases.documents` resource is deprecated;
     * only use `projects.knowledgeBases.documents`.
     * </pre>
     */
    public void listDocuments(
        com.google.cloud.dialogflow.v2beta1.ListDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.ListDocumentsResponse>
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
     * Retrieves the specified document.
     * Note: The `projects.agent.knowledgeBases.documents` resource is deprecated;
     * only use `projects.knowledgeBases.documents`.
     * </pre>
     */
    public void getDocument(
        com.google.cloud.dialogflow.v2beta1.GetDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Document>
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
     * Creates a new document.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [KnowledgeOperationMetadata][google.cloud.dialogflow.v2beta1.KnowledgeOperationMetadata]
     * - `response`: [Document][google.cloud.dialogflow.v2beta1.Document]
     * Note: The `projects.agent.knowledgeBases.documents` resource is deprecated;
     * only use `projects.knowledgeBases.documents`.
     * </pre>
     */
    public void createDocument(
        com.google.cloud.dialogflow.v2beta1.CreateDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDocumentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create documents by importing data from external sources.
     * Dialogflow supports up to 350 documents in each request. If you try to
     * import more, Dialogflow will return an error.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [KnowledgeOperationMetadata][google.cloud.dialogflow.v2beta1.KnowledgeOperationMetadata]
     * - `response`: [ImportDocumentsResponse][google.cloud.dialogflow.v2beta1.ImportDocumentsResponse]
     * </pre>
     */
    public void importDocuments(
        com.google.cloud.dialogflow.v2beta1.ImportDocumentsRequest request,
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
     * Deletes the specified document.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [KnowledgeOperationMetadata][google.cloud.dialogflow.v2beta1.KnowledgeOperationMetadata]
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * Note: The `projects.agent.knowledgeBases.documents` resource is deprecated;
     * only use `projects.knowledgeBases.documents`.
     * </pre>
     */
    public void deleteDocument(
        com.google.cloud.dialogflow.v2beta1.DeleteDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDocumentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified document.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [KnowledgeOperationMetadata][google.cloud.dialogflow.v2beta1.KnowledgeOperationMetadata]
     * - `response`: [Document][google.cloud.dialogflow.v2beta1.Document]
     * Note: The `projects.agent.knowledgeBases.documents` resource is deprecated;
     * only use `projects.knowledgeBases.documents`.
     * </pre>
     */
    public void updateDocument(
        com.google.cloud.dialogflow.v2beta1.UpdateDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDocumentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reloads the specified document from its specified source, content_uri or
     * content. The previously loaded content of the document will be deleted.
     * Note: Even when the content of the document has not changed, there still
     * may be side effects because of internal implementation changes.
     * Note: If the document source is Google Cloud Storage URI, its metadata will
     * be replaced with the custom metadata from Google Cloud Storage if the
     * `import_gcs_custom_metadata` field is set to true in the request.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [KnowledgeOperationMetadata][google.cloud.dialogflow.v2beta1.KnowledgeOperationMetadata]
     * - `response`: [Document][google.cloud.dialogflow.v2beta1.Document]
     * Note: The `projects.agent.knowledgeBases.documents` resource is deprecated;
     * only use `projects.knowledgeBases.documents`.
     * </pre>
     */
    public void reloadDocument(
        com.google.cloud.dialogflow.v2beta1.ReloadDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReloadDocumentMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing knowledge [Documents][google.cloud.dialogflow.v2beta1.Document].
   * </pre>
   */
  public static final class DocumentsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DocumentsBlockingStub> {
    private DocumentsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DocumentsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DocumentsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all documents of the knowledge base.
     * Note: The `projects.agent.knowledgeBases.documents` resource is deprecated;
     * only use `projects.knowledgeBases.documents`.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.ListDocumentsResponse listDocuments(
        com.google.cloud.dialogflow.v2beta1.ListDocumentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDocumentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified document.
     * Note: The `projects.agent.knowledgeBases.documents` resource is deprecated;
     * only use `projects.knowledgeBases.documents`.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.Document getDocument(
        com.google.cloud.dialogflow.v2beta1.GetDocumentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDocumentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new document.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [KnowledgeOperationMetadata][google.cloud.dialogflow.v2beta1.KnowledgeOperationMetadata]
     * - `response`: [Document][google.cloud.dialogflow.v2beta1.Document]
     * Note: The `projects.agent.knowledgeBases.documents` resource is deprecated;
     * only use `projects.knowledgeBases.documents`.
     * </pre>
     */
    public com.google.longrunning.Operation createDocument(
        com.google.cloud.dialogflow.v2beta1.CreateDocumentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDocumentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create documents by importing data from external sources.
     * Dialogflow supports up to 350 documents in each request. If you try to
     * import more, Dialogflow will return an error.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [KnowledgeOperationMetadata][google.cloud.dialogflow.v2beta1.KnowledgeOperationMetadata]
     * - `response`: [ImportDocumentsResponse][google.cloud.dialogflow.v2beta1.ImportDocumentsResponse]
     * </pre>
     */
    public com.google.longrunning.Operation importDocuments(
        com.google.cloud.dialogflow.v2beta1.ImportDocumentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportDocumentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified document.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [KnowledgeOperationMetadata][google.cloud.dialogflow.v2beta1.KnowledgeOperationMetadata]
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * Note: The `projects.agent.knowledgeBases.documents` resource is deprecated;
     * only use `projects.knowledgeBases.documents`.
     * </pre>
     */
    public com.google.longrunning.Operation deleteDocument(
        com.google.cloud.dialogflow.v2beta1.DeleteDocumentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDocumentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified document.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [KnowledgeOperationMetadata][google.cloud.dialogflow.v2beta1.KnowledgeOperationMetadata]
     * - `response`: [Document][google.cloud.dialogflow.v2beta1.Document]
     * Note: The `projects.agent.knowledgeBases.documents` resource is deprecated;
     * only use `projects.knowledgeBases.documents`.
     * </pre>
     */
    public com.google.longrunning.Operation updateDocument(
        com.google.cloud.dialogflow.v2beta1.UpdateDocumentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDocumentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Reloads the specified document from its specified source, content_uri or
     * content. The previously loaded content of the document will be deleted.
     * Note: Even when the content of the document has not changed, there still
     * may be side effects because of internal implementation changes.
     * Note: If the document source is Google Cloud Storage URI, its metadata will
     * be replaced with the custom metadata from Google Cloud Storage if the
     * `import_gcs_custom_metadata` field is set to true in the request.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [KnowledgeOperationMetadata][google.cloud.dialogflow.v2beta1.KnowledgeOperationMetadata]
     * - `response`: [Document][google.cloud.dialogflow.v2beta1.Document]
     * Note: The `projects.agent.knowledgeBases.documents` resource is deprecated;
     * only use `projects.knowledgeBases.documents`.
     * </pre>
     */
    public com.google.longrunning.Operation reloadDocument(
        com.google.cloud.dialogflow.v2beta1.ReloadDocumentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReloadDocumentMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing knowledge [Documents][google.cloud.dialogflow.v2beta1.Document].
   * </pre>
   */
  public static final class DocumentsFutureStub
      extends io.grpc.stub.AbstractFutureStub<DocumentsFutureStub> {
    private DocumentsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DocumentsFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DocumentsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all documents of the knowledge base.
     * Note: The `projects.agent.knowledgeBases.documents` resource is deprecated;
     * only use `projects.knowledgeBases.documents`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.ListDocumentsResponse>
        listDocuments(com.google.cloud.dialogflow.v2beta1.ListDocumentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDocumentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified document.
     * Note: The `projects.agent.knowledgeBases.documents` resource is deprecated;
     * only use `projects.knowledgeBases.documents`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.Document>
        getDocument(com.google.cloud.dialogflow.v2beta1.GetDocumentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDocumentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new document.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [KnowledgeOperationMetadata][google.cloud.dialogflow.v2beta1.KnowledgeOperationMetadata]
     * - `response`: [Document][google.cloud.dialogflow.v2beta1.Document]
     * Note: The `projects.agent.knowledgeBases.documents` resource is deprecated;
     * only use `projects.knowledgeBases.documents`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createDocument(com.google.cloud.dialogflow.v2beta1.CreateDocumentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDocumentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create documents by importing data from external sources.
     * Dialogflow supports up to 350 documents in each request. If you try to
     * import more, Dialogflow will return an error.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [KnowledgeOperationMetadata][google.cloud.dialogflow.v2beta1.KnowledgeOperationMetadata]
     * - `response`: [ImportDocumentsResponse][google.cloud.dialogflow.v2beta1.ImportDocumentsResponse]
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importDocuments(com.google.cloud.dialogflow.v2beta1.ImportDocumentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportDocumentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified document.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [KnowledgeOperationMetadata][google.cloud.dialogflow.v2beta1.KnowledgeOperationMetadata]
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * Note: The `projects.agent.knowledgeBases.documents` resource is deprecated;
     * only use `projects.knowledgeBases.documents`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteDocument(com.google.cloud.dialogflow.v2beta1.DeleteDocumentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDocumentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified document.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [KnowledgeOperationMetadata][google.cloud.dialogflow.v2beta1.KnowledgeOperationMetadata]
     * - `response`: [Document][google.cloud.dialogflow.v2beta1.Document]
     * Note: The `projects.agent.knowledgeBases.documents` resource is deprecated;
     * only use `projects.knowledgeBases.documents`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateDocument(com.google.cloud.dialogflow.v2beta1.UpdateDocumentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDocumentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Reloads the specified document from its specified source, content_uri or
     * content. The previously loaded content of the document will be deleted.
     * Note: Even when the content of the document has not changed, there still
     * may be side effects because of internal implementation changes.
     * Note: If the document source is Google Cloud Storage URI, its metadata will
     * be replaced with the custom metadata from Google Cloud Storage if the
     * `import_gcs_custom_metadata` field is set to true in the request.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [KnowledgeOperationMetadata][google.cloud.dialogflow.v2beta1.KnowledgeOperationMetadata]
     * - `response`: [Document][google.cloud.dialogflow.v2beta1.Document]
     * Note: The `projects.agent.knowledgeBases.documents` resource is deprecated;
     * only use `projects.knowledgeBases.documents`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        reloadDocument(com.google.cloud.dialogflow.v2beta1.ReloadDocumentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReloadDocumentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_DOCUMENTS = 0;
  private static final int METHODID_GET_DOCUMENT = 1;
  private static final int METHODID_CREATE_DOCUMENT = 2;
  private static final int METHODID_IMPORT_DOCUMENTS = 3;
  private static final int METHODID_DELETE_DOCUMENT = 4;
  private static final int METHODID_UPDATE_DOCUMENT = 5;
  private static final int METHODID_RELOAD_DOCUMENT = 6;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DocumentsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DocumentsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_DOCUMENTS:
          serviceImpl.listDocuments(
              (com.google.cloud.dialogflow.v2beta1.ListDocumentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.v2beta1.ListDocumentsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DOCUMENT:
          serviceImpl.getDocument(
              (com.google.cloud.dialogflow.v2beta1.GetDocumentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Document>)
                  responseObserver);
          break;
        case METHODID_CREATE_DOCUMENT:
          serviceImpl.createDocument(
              (com.google.cloud.dialogflow.v2beta1.CreateDocumentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_IMPORT_DOCUMENTS:
          serviceImpl.importDocuments(
              (com.google.cloud.dialogflow.v2beta1.ImportDocumentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_DOCUMENT:
          serviceImpl.deleteDocument(
              (com.google.cloud.dialogflow.v2beta1.DeleteDocumentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_DOCUMENT:
          serviceImpl.updateDocument(
              (com.google.cloud.dialogflow.v2beta1.UpdateDocumentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RELOAD_DOCUMENT:
          serviceImpl.reloadDocument(
              (com.google.cloud.dialogflow.v2beta1.ReloadDocumentRequest) request,
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

  private abstract static class DocumentsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DocumentsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.v2beta1.DocumentProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Documents");
    }
  }

  private static final class DocumentsFileDescriptorSupplier
      extends DocumentsBaseDescriptorSupplier {
    DocumentsFileDescriptorSupplier() {}
  }

  private static final class DocumentsMethodDescriptorSupplier
      extends DocumentsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DocumentsMethodDescriptorSupplier(String methodName) {
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
      synchronized (DocumentsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DocumentsFileDescriptorSupplier())
                      .addMethod(getListDocumentsMethod())
                      .addMethod(getGetDocumentMethod())
                      .addMethod(getCreateDocumentMethod())
                      .addMethod(getImportDocumentsMethod())
                      .addMethod(getDeleteDocumentMethod())
                      .addMethod(getUpdateDocumentMethod())
                      .addMethod(getReloadDocumentMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
