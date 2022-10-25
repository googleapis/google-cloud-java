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
package com.google.cloud.discoveryengine.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for ingesting
 * [Document][google.cloud.discoveryengine.v1beta.Document] information of the
 * customer's website.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/discoveryengine/v1beta/document_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DocumentServiceGrpc {

  private DocumentServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.discoveryengine.v1beta.DocumentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.GetDocumentRequest,
          com.google.cloud.discoveryengine.v1beta.Document>
      getGetDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDocument",
      requestType = com.google.cloud.discoveryengine.v1beta.GetDocumentRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.Document.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.GetDocumentRequest,
          com.google.cloud.discoveryengine.v1beta.Document>
      getGetDocumentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.GetDocumentRequest,
            com.google.cloud.discoveryengine.v1beta.Document>
        getGetDocumentMethod;
    if ((getGetDocumentMethod = DocumentServiceGrpc.getGetDocumentMethod) == null) {
      synchronized (DocumentServiceGrpc.class) {
        if ((getGetDocumentMethod = DocumentServiceGrpc.getGetDocumentMethod) == null) {
          DocumentServiceGrpc.getGetDocumentMethod =
              getGetDocumentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.GetDocumentRequest,
                          com.google.cloud.discoveryengine.v1beta.Document>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDocument"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.GetDocumentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.Document
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
          com.google.cloud.discoveryengine.v1beta.ListDocumentsRequest,
          com.google.cloud.discoveryengine.v1beta.ListDocumentsResponse>
      getListDocumentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDocuments",
      requestType = com.google.cloud.discoveryengine.v1beta.ListDocumentsRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.ListDocumentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.ListDocumentsRequest,
          com.google.cloud.discoveryengine.v1beta.ListDocumentsResponse>
      getListDocumentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.ListDocumentsRequest,
            com.google.cloud.discoveryengine.v1beta.ListDocumentsResponse>
        getListDocumentsMethod;
    if ((getListDocumentsMethod = DocumentServiceGrpc.getListDocumentsMethod) == null) {
      synchronized (DocumentServiceGrpc.class) {
        if ((getListDocumentsMethod = DocumentServiceGrpc.getListDocumentsMethod) == null) {
          DocumentServiceGrpc.getListDocumentsMethod =
              getListDocumentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.ListDocumentsRequest,
                          com.google.cloud.discoveryengine.v1beta.ListDocumentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDocuments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.ListDocumentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.ListDocumentsResponse
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
          com.google.cloud.discoveryengine.v1beta.CreateDocumentRequest,
          com.google.cloud.discoveryengine.v1beta.Document>
      getCreateDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDocument",
      requestType = com.google.cloud.discoveryengine.v1beta.CreateDocumentRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.Document.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.CreateDocumentRequest,
          com.google.cloud.discoveryengine.v1beta.Document>
      getCreateDocumentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.CreateDocumentRequest,
            com.google.cloud.discoveryengine.v1beta.Document>
        getCreateDocumentMethod;
    if ((getCreateDocumentMethod = DocumentServiceGrpc.getCreateDocumentMethod) == null) {
      synchronized (DocumentServiceGrpc.class) {
        if ((getCreateDocumentMethod = DocumentServiceGrpc.getCreateDocumentMethod) == null) {
          DocumentServiceGrpc.getCreateDocumentMethod =
              getCreateDocumentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.CreateDocumentRequest,
                          com.google.cloud.discoveryengine.v1beta.Document>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDocument"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.CreateDocumentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.Document
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentServiceMethodDescriptorSupplier("CreateDocument"))
                      .build();
        }
      }
    }
    return getCreateDocumentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.UpdateDocumentRequest,
          com.google.cloud.discoveryengine.v1beta.Document>
      getUpdateDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDocument",
      requestType = com.google.cloud.discoveryengine.v1beta.UpdateDocumentRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.Document.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.UpdateDocumentRequest,
          com.google.cloud.discoveryengine.v1beta.Document>
      getUpdateDocumentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.UpdateDocumentRequest,
            com.google.cloud.discoveryengine.v1beta.Document>
        getUpdateDocumentMethod;
    if ((getUpdateDocumentMethod = DocumentServiceGrpc.getUpdateDocumentMethod) == null) {
      synchronized (DocumentServiceGrpc.class) {
        if ((getUpdateDocumentMethod = DocumentServiceGrpc.getUpdateDocumentMethod) == null) {
          DocumentServiceGrpc.getUpdateDocumentMethod =
              getUpdateDocumentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.UpdateDocumentRequest,
                          com.google.cloud.discoveryengine.v1beta.Document>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDocument"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.UpdateDocumentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.Document
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentServiceMethodDescriptorSupplier("UpdateDocument"))
                      .build();
        }
      }
    }
    return getUpdateDocumentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.DeleteDocumentRequest, com.google.protobuf.Empty>
      getDeleteDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDocument",
      requestType = com.google.cloud.discoveryengine.v1beta.DeleteDocumentRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.DeleteDocumentRequest, com.google.protobuf.Empty>
      getDeleteDocumentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.DeleteDocumentRequest,
            com.google.protobuf.Empty>
        getDeleteDocumentMethod;
    if ((getDeleteDocumentMethod = DocumentServiceGrpc.getDeleteDocumentMethod) == null) {
      synchronized (DocumentServiceGrpc.class) {
        if ((getDeleteDocumentMethod = DocumentServiceGrpc.getDeleteDocumentMethod) == null) {
          DocumentServiceGrpc.getDeleteDocumentMethod =
              getDeleteDocumentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.DeleteDocumentRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDocument"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.DeleteDocumentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentServiceMethodDescriptorSupplier("DeleteDocument"))
                      .build();
        }
      }
    }
    return getDeleteDocumentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.ImportDocumentsRequest,
          com.google.longrunning.Operation>
      getImportDocumentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportDocuments",
      requestType = com.google.cloud.discoveryengine.v1beta.ImportDocumentsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.ImportDocumentsRequest,
          com.google.longrunning.Operation>
      getImportDocumentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.ImportDocumentsRequest,
            com.google.longrunning.Operation>
        getImportDocumentsMethod;
    if ((getImportDocumentsMethod = DocumentServiceGrpc.getImportDocumentsMethod) == null) {
      synchronized (DocumentServiceGrpc.class) {
        if ((getImportDocumentsMethod = DocumentServiceGrpc.getImportDocumentsMethod) == null) {
          DocumentServiceGrpc.getImportDocumentsMethod =
              getImportDocumentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.ImportDocumentsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportDocuments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.ImportDocumentsRequest
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
   * Service for ingesting
   * [Document][google.cloud.discoveryengine.v1beta.Document] information of the
   * customer's website.
   * </pre>
   */
  public abstract static class DocumentServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Gets a [Document][google.cloud.discoveryengine.v1beta.Document].
     * </pre>
     */
    public void getDocument(
        com.google.cloud.discoveryengine.v1beta.GetDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Document>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDocumentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of [Document][google.cloud.discoveryengine.v1beta.Document]s.
     * </pre>
     */
    public void listDocuments(
        com.google.cloud.discoveryengine.v1beta.ListDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.ListDocumentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDocumentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a [Document][google.cloud.discoveryengine.v1beta.Document].
     * </pre>
     */
    public void createDocument(
        com.google.cloud.discoveryengine.v1beta.CreateDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Document>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDocumentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a [Document][google.cloud.discoveryengine.v1beta.Document].
     * </pre>
     */
    public void updateDocument(
        com.google.cloud.discoveryengine.v1beta.UpdateDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Document>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDocumentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a [Document][google.cloud.discoveryengine.v1beta.Document].
     * </pre>
     */
    public void deleteDocument(
        com.google.cloud.discoveryengine.v1beta.DeleteDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDocumentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Bulk import of multiple
     * [Document][google.cloud.discoveryengine.v1beta.Document]s. Request
     * processing may be synchronous. Non-existing items will be created.
     * Note: It is possible for a subset of the
     * [Document][google.cloud.discoveryengine.v1beta.Document]s to be
     * successfully updated.
     * </pre>
     */
    public void importDocuments(
        com.google.cloud.discoveryengine.v1beta.ImportDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportDocumentsMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getGetDocumentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.discoveryengine.v1beta.GetDocumentRequest,
                      com.google.cloud.discoveryengine.v1beta.Document>(
                      this, METHODID_GET_DOCUMENT)))
          .addMethod(
              getListDocumentsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.discoveryengine.v1beta.ListDocumentsRequest,
                      com.google.cloud.discoveryengine.v1beta.ListDocumentsResponse>(
                      this, METHODID_LIST_DOCUMENTS)))
          .addMethod(
              getCreateDocumentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.discoveryengine.v1beta.CreateDocumentRequest,
                      com.google.cloud.discoveryengine.v1beta.Document>(
                      this, METHODID_CREATE_DOCUMENT)))
          .addMethod(
              getUpdateDocumentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.discoveryengine.v1beta.UpdateDocumentRequest,
                      com.google.cloud.discoveryengine.v1beta.Document>(
                      this, METHODID_UPDATE_DOCUMENT)))
          .addMethod(
              getDeleteDocumentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.discoveryengine.v1beta.DeleteDocumentRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_DOCUMENT)))
          .addMethod(
              getImportDocumentsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.discoveryengine.v1beta.ImportDocumentsRequest,
                      com.google.longrunning.Operation>(this, METHODID_IMPORT_DOCUMENTS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service for ingesting
   * [Document][google.cloud.discoveryengine.v1beta.Document] information of the
   * customer's website.
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
     * Gets a [Document][google.cloud.discoveryengine.v1beta.Document].
     * </pre>
     */
    public void getDocument(
        com.google.cloud.discoveryengine.v1beta.GetDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Document>
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
     * Gets a list of [Document][google.cloud.discoveryengine.v1beta.Document]s.
     * </pre>
     */
    public void listDocuments(
        com.google.cloud.discoveryengine.v1beta.ListDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.ListDocumentsResponse>
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
     * Creates a [Document][google.cloud.discoveryengine.v1beta.Document].
     * </pre>
     */
    public void createDocument(
        com.google.cloud.discoveryengine.v1beta.CreateDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Document>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDocumentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a [Document][google.cloud.discoveryengine.v1beta.Document].
     * </pre>
     */
    public void updateDocument(
        com.google.cloud.discoveryengine.v1beta.UpdateDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Document>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDocumentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a [Document][google.cloud.discoveryengine.v1beta.Document].
     * </pre>
     */
    public void deleteDocument(
        com.google.cloud.discoveryengine.v1beta.DeleteDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDocumentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Bulk import of multiple
     * [Document][google.cloud.discoveryengine.v1beta.Document]s. Request
     * processing may be synchronous. Non-existing items will be created.
     * Note: It is possible for a subset of the
     * [Document][google.cloud.discoveryengine.v1beta.Document]s to be
     * successfully updated.
     * </pre>
     */
    public void importDocuments(
        com.google.cloud.discoveryengine.v1beta.ImportDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportDocumentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for ingesting
   * [Document][google.cloud.discoveryengine.v1beta.Document] information of the
   * customer's website.
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
     * Gets a [Document][google.cloud.discoveryengine.v1beta.Document].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.Document getDocument(
        com.google.cloud.discoveryengine.v1beta.GetDocumentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDocumentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of [Document][google.cloud.discoveryengine.v1beta.Document]s.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.ListDocumentsResponse listDocuments(
        com.google.cloud.discoveryengine.v1beta.ListDocumentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDocumentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a [Document][google.cloud.discoveryengine.v1beta.Document].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.Document createDocument(
        com.google.cloud.discoveryengine.v1beta.CreateDocumentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDocumentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a [Document][google.cloud.discoveryengine.v1beta.Document].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.Document updateDocument(
        com.google.cloud.discoveryengine.v1beta.UpdateDocumentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDocumentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a [Document][google.cloud.discoveryengine.v1beta.Document].
     * </pre>
     */
    public com.google.protobuf.Empty deleteDocument(
        com.google.cloud.discoveryengine.v1beta.DeleteDocumentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDocumentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Bulk import of multiple
     * [Document][google.cloud.discoveryengine.v1beta.Document]s. Request
     * processing may be synchronous. Non-existing items will be created.
     * Note: It is possible for a subset of the
     * [Document][google.cloud.discoveryengine.v1beta.Document]s to be
     * successfully updated.
     * </pre>
     */
    public com.google.longrunning.Operation importDocuments(
        com.google.cloud.discoveryengine.v1beta.ImportDocumentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportDocumentsMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for ingesting
   * [Document][google.cloud.discoveryengine.v1beta.Document] information of the
   * customer's website.
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
     * Gets a [Document][google.cloud.discoveryengine.v1beta.Document].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.Document>
        getDocument(com.google.cloud.discoveryengine.v1beta.GetDocumentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDocumentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of [Document][google.cloud.discoveryengine.v1beta.Document]s.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.ListDocumentsResponse>
        listDocuments(com.google.cloud.discoveryengine.v1beta.ListDocumentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDocumentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a [Document][google.cloud.discoveryengine.v1beta.Document].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.Document>
        createDocument(com.google.cloud.discoveryengine.v1beta.CreateDocumentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDocumentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a [Document][google.cloud.discoveryengine.v1beta.Document].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.Document>
        updateDocument(com.google.cloud.discoveryengine.v1beta.UpdateDocumentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDocumentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a [Document][google.cloud.discoveryengine.v1beta.Document].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteDocument(com.google.cloud.discoveryengine.v1beta.DeleteDocumentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDocumentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Bulk import of multiple
     * [Document][google.cloud.discoveryengine.v1beta.Document]s. Request
     * processing may be synchronous. Non-existing items will be created.
     * Note: It is possible for a subset of the
     * [Document][google.cloud.discoveryengine.v1beta.Document]s to be
     * successfully updated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importDocuments(com.google.cloud.discoveryengine.v1beta.ImportDocumentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportDocumentsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_DOCUMENT = 0;
  private static final int METHODID_LIST_DOCUMENTS = 1;
  private static final int METHODID_CREATE_DOCUMENT = 2;
  private static final int METHODID_UPDATE_DOCUMENT = 3;
  private static final int METHODID_DELETE_DOCUMENT = 4;
  private static final int METHODID_IMPORT_DOCUMENTS = 5;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DocumentServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DocumentServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_DOCUMENT:
          serviceImpl.getDocument(
              (com.google.cloud.discoveryengine.v1beta.GetDocumentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Document>)
                  responseObserver);
          break;
        case METHODID_LIST_DOCUMENTS:
          serviceImpl.listDocuments(
              (com.google.cloud.discoveryengine.v1beta.ListDocumentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.discoveryengine.v1beta.ListDocumentsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_DOCUMENT:
          serviceImpl.createDocument(
              (com.google.cloud.discoveryengine.v1beta.CreateDocumentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Document>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DOCUMENT:
          serviceImpl.updateDocument(
              (com.google.cloud.discoveryengine.v1beta.UpdateDocumentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Document>)
                  responseObserver);
          break;
        case METHODID_DELETE_DOCUMENT:
          serviceImpl.deleteDocument(
              (com.google.cloud.discoveryengine.v1beta.DeleteDocumentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_IMPORT_DOCUMENTS:
          serviceImpl.importDocuments(
              (com.google.cloud.discoveryengine.v1beta.ImportDocumentsRequest) request,
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

  private abstract static class DocumentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DocumentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1beta.DocumentServiceProto.getDescriptor();
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
    private final String methodName;

    DocumentServiceMethodDescriptorSupplier(String methodName) {
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
                      .addMethod(getGetDocumentMethod())
                      .addMethod(getListDocumentsMethod())
                      .addMethod(getCreateDocumentMethod())
                      .addMethod(getUpdateDocumentMethod())
                      .addMethod(getDeleteDocumentMethod())
                      .addMethod(getImportDocumentsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
