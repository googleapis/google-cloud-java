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
package com.google.cloud.contentwarehouse.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * This service lets you manage document.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/contentwarehouse/v1/document_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DocumentServiceGrpc {

  private DocumentServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.contentwarehouse.v1.DocumentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.CreateDocumentRequest,
          com.google.cloud.contentwarehouse.v1.CreateDocumentResponse>
      getCreateDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDocument",
      requestType = com.google.cloud.contentwarehouse.v1.CreateDocumentRequest.class,
      responseType = com.google.cloud.contentwarehouse.v1.CreateDocumentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.CreateDocumentRequest,
          com.google.cloud.contentwarehouse.v1.CreateDocumentResponse>
      getCreateDocumentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contentwarehouse.v1.CreateDocumentRequest,
            com.google.cloud.contentwarehouse.v1.CreateDocumentResponse>
        getCreateDocumentMethod;
    if ((getCreateDocumentMethod = DocumentServiceGrpc.getCreateDocumentMethod) == null) {
      synchronized (DocumentServiceGrpc.class) {
        if ((getCreateDocumentMethod = DocumentServiceGrpc.getCreateDocumentMethod) == null) {
          DocumentServiceGrpc.getCreateDocumentMethod =
              getCreateDocumentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contentwarehouse.v1.CreateDocumentRequest,
                          com.google.cloud.contentwarehouse.v1.CreateDocumentResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDocument"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.CreateDocumentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.CreateDocumentResponse
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
          com.google.cloud.contentwarehouse.v1.GetDocumentRequest,
          com.google.cloud.contentwarehouse.v1.Document>
      getGetDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDocument",
      requestType = com.google.cloud.contentwarehouse.v1.GetDocumentRequest.class,
      responseType = com.google.cloud.contentwarehouse.v1.Document.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.GetDocumentRequest,
          com.google.cloud.contentwarehouse.v1.Document>
      getGetDocumentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contentwarehouse.v1.GetDocumentRequest,
            com.google.cloud.contentwarehouse.v1.Document>
        getGetDocumentMethod;
    if ((getGetDocumentMethod = DocumentServiceGrpc.getGetDocumentMethod) == null) {
      synchronized (DocumentServiceGrpc.class) {
        if ((getGetDocumentMethod = DocumentServiceGrpc.getGetDocumentMethod) == null) {
          DocumentServiceGrpc.getGetDocumentMethod =
              getGetDocumentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contentwarehouse.v1.GetDocumentRequest,
                          com.google.cloud.contentwarehouse.v1.Document>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDocument"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.GetDocumentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.Document.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentServiceMethodDescriptorSupplier("GetDocument"))
                      .build();
        }
      }
    }
    return getGetDocumentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.UpdateDocumentRequest,
          com.google.cloud.contentwarehouse.v1.UpdateDocumentResponse>
      getUpdateDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDocument",
      requestType = com.google.cloud.contentwarehouse.v1.UpdateDocumentRequest.class,
      responseType = com.google.cloud.contentwarehouse.v1.UpdateDocumentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.UpdateDocumentRequest,
          com.google.cloud.contentwarehouse.v1.UpdateDocumentResponse>
      getUpdateDocumentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contentwarehouse.v1.UpdateDocumentRequest,
            com.google.cloud.contentwarehouse.v1.UpdateDocumentResponse>
        getUpdateDocumentMethod;
    if ((getUpdateDocumentMethod = DocumentServiceGrpc.getUpdateDocumentMethod) == null) {
      synchronized (DocumentServiceGrpc.class) {
        if ((getUpdateDocumentMethod = DocumentServiceGrpc.getUpdateDocumentMethod) == null) {
          DocumentServiceGrpc.getUpdateDocumentMethod =
              getUpdateDocumentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contentwarehouse.v1.UpdateDocumentRequest,
                          com.google.cloud.contentwarehouse.v1.UpdateDocumentResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDocument"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.UpdateDocumentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.UpdateDocumentResponse
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
          com.google.cloud.contentwarehouse.v1.DeleteDocumentRequest, com.google.protobuf.Empty>
      getDeleteDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDocument",
      requestType = com.google.cloud.contentwarehouse.v1.DeleteDocumentRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.DeleteDocumentRequest, com.google.protobuf.Empty>
      getDeleteDocumentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contentwarehouse.v1.DeleteDocumentRequest, com.google.protobuf.Empty>
        getDeleteDocumentMethod;
    if ((getDeleteDocumentMethod = DocumentServiceGrpc.getDeleteDocumentMethod) == null) {
      synchronized (DocumentServiceGrpc.class) {
        if ((getDeleteDocumentMethod = DocumentServiceGrpc.getDeleteDocumentMethod) == null) {
          DocumentServiceGrpc.getDeleteDocumentMethod =
              getDeleteDocumentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contentwarehouse.v1.DeleteDocumentRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDocument"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.DeleteDocumentRequest
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
          com.google.cloud.contentwarehouse.v1.SearchDocumentsRequest,
          com.google.cloud.contentwarehouse.v1.SearchDocumentsResponse>
      getSearchDocumentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchDocuments",
      requestType = com.google.cloud.contentwarehouse.v1.SearchDocumentsRequest.class,
      responseType = com.google.cloud.contentwarehouse.v1.SearchDocumentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.SearchDocumentsRequest,
          com.google.cloud.contentwarehouse.v1.SearchDocumentsResponse>
      getSearchDocumentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contentwarehouse.v1.SearchDocumentsRequest,
            com.google.cloud.contentwarehouse.v1.SearchDocumentsResponse>
        getSearchDocumentsMethod;
    if ((getSearchDocumentsMethod = DocumentServiceGrpc.getSearchDocumentsMethod) == null) {
      synchronized (DocumentServiceGrpc.class) {
        if ((getSearchDocumentsMethod = DocumentServiceGrpc.getSearchDocumentsMethod) == null) {
          DocumentServiceGrpc.getSearchDocumentsMethod =
              getSearchDocumentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contentwarehouse.v1.SearchDocumentsRequest,
                          com.google.cloud.contentwarehouse.v1.SearchDocumentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchDocuments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.SearchDocumentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.SearchDocumentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentServiceMethodDescriptorSupplier("SearchDocuments"))
                      .build();
        }
      }
    }
    return getSearchDocumentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.LockDocumentRequest,
          com.google.cloud.contentwarehouse.v1.Document>
      getLockDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LockDocument",
      requestType = com.google.cloud.contentwarehouse.v1.LockDocumentRequest.class,
      responseType = com.google.cloud.contentwarehouse.v1.Document.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.LockDocumentRequest,
          com.google.cloud.contentwarehouse.v1.Document>
      getLockDocumentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contentwarehouse.v1.LockDocumentRequest,
            com.google.cloud.contentwarehouse.v1.Document>
        getLockDocumentMethod;
    if ((getLockDocumentMethod = DocumentServiceGrpc.getLockDocumentMethod) == null) {
      synchronized (DocumentServiceGrpc.class) {
        if ((getLockDocumentMethod = DocumentServiceGrpc.getLockDocumentMethod) == null) {
          DocumentServiceGrpc.getLockDocumentMethod =
              getLockDocumentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contentwarehouse.v1.LockDocumentRequest,
                          com.google.cloud.contentwarehouse.v1.Document>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LockDocument"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.LockDocumentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.Document.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentServiceMethodDescriptorSupplier("LockDocument"))
                      .build();
        }
      }
    }
    return getLockDocumentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.FetchAclRequest,
          com.google.cloud.contentwarehouse.v1.FetchAclResponse>
      getFetchAclMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchAcl",
      requestType = com.google.cloud.contentwarehouse.v1.FetchAclRequest.class,
      responseType = com.google.cloud.contentwarehouse.v1.FetchAclResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.FetchAclRequest,
          com.google.cloud.contentwarehouse.v1.FetchAclResponse>
      getFetchAclMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contentwarehouse.v1.FetchAclRequest,
            com.google.cloud.contentwarehouse.v1.FetchAclResponse>
        getFetchAclMethod;
    if ((getFetchAclMethod = DocumentServiceGrpc.getFetchAclMethod) == null) {
      synchronized (DocumentServiceGrpc.class) {
        if ((getFetchAclMethod = DocumentServiceGrpc.getFetchAclMethod) == null) {
          DocumentServiceGrpc.getFetchAclMethod =
              getFetchAclMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contentwarehouse.v1.FetchAclRequest,
                          com.google.cloud.contentwarehouse.v1.FetchAclResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FetchAcl"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.FetchAclRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.FetchAclResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new DocumentServiceMethodDescriptorSupplier("FetchAcl"))
                      .build();
        }
      }
    }
    return getFetchAclMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.SetAclRequest,
          com.google.cloud.contentwarehouse.v1.SetAclResponse>
      getSetAclMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetAcl",
      requestType = com.google.cloud.contentwarehouse.v1.SetAclRequest.class,
      responseType = com.google.cloud.contentwarehouse.v1.SetAclResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.SetAclRequest,
          com.google.cloud.contentwarehouse.v1.SetAclResponse>
      getSetAclMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contentwarehouse.v1.SetAclRequest,
            com.google.cloud.contentwarehouse.v1.SetAclResponse>
        getSetAclMethod;
    if ((getSetAclMethod = DocumentServiceGrpc.getSetAclMethod) == null) {
      synchronized (DocumentServiceGrpc.class) {
        if ((getSetAclMethod = DocumentServiceGrpc.getSetAclMethod) == null) {
          DocumentServiceGrpc.getSetAclMethod =
              getSetAclMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contentwarehouse.v1.SetAclRequest,
                          com.google.cloud.contentwarehouse.v1.SetAclResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetAcl"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.SetAclRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.SetAclResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new DocumentServiceMethodDescriptorSupplier("SetAcl"))
                      .build();
        }
      }
    }
    return getSetAclMethod;
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
   * This service lets you manage document.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a document.
     * </pre>
     */
    default void createDocument(
        com.google.cloud.contentwarehouse.v1.CreateDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.CreateDocumentResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDocumentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a document. Returns NOT_FOUND if the document does not exist.
     * </pre>
     */
    default void getDocument(
        com.google.cloud.contentwarehouse.v1.GetDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.Document>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDocumentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a document. Returns INVALID_ARGUMENT if the name of the document
     * is non-empty and does not equal the existing name.
     * </pre>
     */
    default void updateDocument(
        com.google.cloud.contentwarehouse.v1.UpdateDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.UpdateDocumentResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDocumentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a document. Returns NOT_FOUND if the document does not exist.
     * </pre>
     */
    default void deleteDocument(
        com.google.cloud.contentwarehouse.v1.DeleteDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDocumentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches for documents using provided
     * [SearchDocumentsRequest][google.cloud.contentwarehouse.v1.SearchDocumentsRequest].
     * This call only returns documents that the caller has permission to search
     * against.
     * </pre>
     */
    default void searchDocuments(
        com.google.cloud.contentwarehouse.v1.SearchDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.SearchDocumentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchDocumentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lock the document so the document cannot be updated by other users.
     * </pre>
     */
    default void lockDocument(
        com.google.cloud.contentwarehouse.v1.LockDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.Document>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getLockDocumentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a resource. Returns NOT_FOUND error if
     * the resource does not exist. Returns an empty policy if the resource exists
     * but does not have a policy set.
     * </pre>
     */
    default void fetchAcl(
        com.google.cloud.contentwarehouse.v1.FetchAclRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.FetchAclResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFetchAclMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy for a resource. Replaces any existing
     * policy.
     * </pre>
     */
    default void setAcl(
        com.google.cloud.contentwarehouse.v1.SetAclRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.SetAclResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetAclMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DocumentService.
   *
   * <pre>
   * This service lets you manage document.
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
   * This service lets you manage document.
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
     * Creates a document.
     * </pre>
     */
    public void createDocument(
        com.google.cloud.contentwarehouse.v1.CreateDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.CreateDocumentResponse>
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
     * Gets a document. Returns NOT_FOUND if the document does not exist.
     * </pre>
     */
    public void getDocument(
        com.google.cloud.contentwarehouse.v1.GetDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.Document>
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
     * Updates a document. Returns INVALID_ARGUMENT if the name of the document
     * is non-empty and does not equal the existing name.
     * </pre>
     */
    public void updateDocument(
        com.google.cloud.contentwarehouse.v1.UpdateDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.UpdateDocumentResponse>
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
     * Deletes a document. Returns NOT_FOUND if the document does not exist.
     * </pre>
     */
    public void deleteDocument(
        com.google.cloud.contentwarehouse.v1.DeleteDocumentRequest request,
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
     * Searches for documents using provided
     * [SearchDocumentsRequest][google.cloud.contentwarehouse.v1.SearchDocumentsRequest].
     * This call only returns documents that the caller has permission to search
     * against.
     * </pre>
     */
    public void searchDocuments(
        com.google.cloud.contentwarehouse.v1.SearchDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.SearchDocumentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchDocumentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lock the document so the document cannot be updated by other users.
     * </pre>
     */
    public void lockDocument(
        com.google.cloud.contentwarehouse.v1.LockDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.Document>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLockDocumentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a resource. Returns NOT_FOUND error if
     * the resource does not exist. Returns an empty policy if the resource exists
     * but does not have a policy set.
     * </pre>
     */
    public void fetchAcl(
        com.google.cloud.contentwarehouse.v1.FetchAclRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.FetchAclResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchAclMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy for a resource. Replaces any existing
     * policy.
     * </pre>
     */
    public void setAcl(
        com.google.cloud.contentwarehouse.v1.SetAclRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.SetAclResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetAclMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DocumentService.
   *
   * <pre>
   * This service lets you manage document.
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
     * Creates a document.
     * </pre>
     */
    public com.google.cloud.contentwarehouse.v1.CreateDocumentResponse createDocument(
        com.google.cloud.contentwarehouse.v1.CreateDocumentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDocumentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a document. Returns NOT_FOUND if the document does not exist.
     * </pre>
     */
    public com.google.cloud.contentwarehouse.v1.Document getDocument(
        com.google.cloud.contentwarehouse.v1.GetDocumentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDocumentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a document. Returns INVALID_ARGUMENT if the name of the document
     * is non-empty and does not equal the existing name.
     * </pre>
     */
    public com.google.cloud.contentwarehouse.v1.UpdateDocumentResponse updateDocument(
        com.google.cloud.contentwarehouse.v1.UpdateDocumentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDocumentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a document. Returns NOT_FOUND if the document does not exist.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDocument(
        com.google.cloud.contentwarehouse.v1.DeleteDocumentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDocumentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Searches for documents using provided
     * [SearchDocumentsRequest][google.cloud.contentwarehouse.v1.SearchDocumentsRequest].
     * This call only returns documents that the caller has permission to search
     * against.
     * </pre>
     */
    public com.google.cloud.contentwarehouse.v1.SearchDocumentsResponse searchDocuments(
        com.google.cloud.contentwarehouse.v1.SearchDocumentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchDocumentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lock the document so the document cannot be updated by other users.
     * </pre>
     */
    public com.google.cloud.contentwarehouse.v1.Document lockDocument(
        com.google.cloud.contentwarehouse.v1.LockDocumentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLockDocumentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a resource. Returns NOT_FOUND error if
     * the resource does not exist. Returns an empty policy if the resource exists
     * but does not have a policy set.
     * </pre>
     */
    public com.google.cloud.contentwarehouse.v1.FetchAclResponse fetchAcl(
        com.google.cloud.contentwarehouse.v1.FetchAclRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchAclMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy for a resource. Replaces any existing
     * policy.
     * </pre>
     */
    public com.google.cloud.contentwarehouse.v1.SetAclResponse setAcl(
        com.google.cloud.contentwarehouse.v1.SetAclRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetAclMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DocumentService.
   *
   * <pre>
   * This service lets you manage document.
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
     * Creates a document.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contentwarehouse.v1.CreateDocumentResponse>
        createDocument(com.google.cloud.contentwarehouse.v1.CreateDocumentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDocumentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a document. Returns NOT_FOUND if the document does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contentwarehouse.v1.Document>
        getDocument(com.google.cloud.contentwarehouse.v1.GetDocumentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDocumentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a document. Returns INVALID_ARGUMENT if the name of the document
     * is non-empty and does not equal the existing name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contentwarehouse.v1.UpdateDocumentResponse>
        updateDocument(com.google.cloud.contentwarehouse.v1.UpdateDocumentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDocumentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a document. Returns NOT_FOUND if the document does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteDocument(com.google.cloud.contentwarehouse.v1.DeleteDocumentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDocumentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Searches for documents using provided
     * [SearchDocumentsRequest][google.cloud.contentwarehouse.v1.SearchDocumentsRequest].
     * This call only returns documents that the caller has permission to search
     * against.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contentwarehouse.v1.SearchDocumentsResponse>
        searchDocuments(com.google.cloud.contentwarehouse.v1.SearchDocumentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchDocumentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lock the document so the document cannot be updated by other users.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contentwarehouse.v1.Document>
        lockDocument(com.google.cloud.contentwarehouse.v1.LockDocumentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLockDocumentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a resource. Returns NOT_FOUND error if
     * the resource does not exist. Returns an empty policy if the resource exists
     * but does not have a policy set.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contentwarehouse.v1.FetchAclResponse>
        fetchAcl(com.google.cloud.contentwarehouse.v1.FetchAclRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchAclMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy for a resource. Replaces any existing
     * policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contentwarehouse.v1.SetAclResponse>
        setAcl(com.google.cloud.contentwarehouse.v1.SetAclRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetAclMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_DOCUMENT = 0;
  private static final int METHODID_GET_DOCUMENT = 1;
  private static final int METHODID_UPDATE_DOCUMENT = 2;
  private static final int METHODID_DELETE_DOCUMENT = 3;
  private static final int METHODID_SEARCH_DOCUMENTS = 4;
  private static final int METHODID_LOCK_DOCUMENT = 5;
  private static final int METHODID_FETCH_ACL = 6;
  private static final int METHODID_SET_ACL = 7;

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
        case METHODID_CREATE_DOCUMENT:
          serviceImpl.createDocument(
              (com.google.cloud.contentwarehouse.v1.CreateDocumentRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.contentwarehouse.v1.CreateDocumentResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DOCUMENT:
          serviceImpl.getDocument(
              (com.google.cloud.contentwarehouse.v1.GetDocumentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.Document>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DOCUMENT:
          serviceImpl.updateDocument(
              (com.google.cloud.contentwarehouse.v1.UpdateDocumentRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.contentwarehouse.v1.UpdateDocumentResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_DOCUMENT:
          serviceImpl.deleteDocument(
              (com.google.cloud.contentwarehouse.v1.DeleteDocumentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_SEARCH_DOCUMENTS:
          serviceImpl.searchDocuments(
              (com.google.cloud.contentwarehouse.v1.SearchDocumentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.contentwarehouse.v1.SearchDocumentsResponse>)
                  responseObserver);
          break;
        case METHODID_LOCK_DOCUMENT:
          serviceImpl.lockDocument(
              (com.google.cloud.contentwarehouse.v1.LockDocumentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.Document>)
                  responseObserver);
          break;
        case METHODID_FETCH_ACL:
          serviceImpl.fetchAcl(
              (com.google.cloud.contentwarehouse.v1.FetchAclRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.FetchAclResponse>)
                  responseObserver);
          break;
        case METHODID_SET_ACL:
          serviceImpl.setAcl(
              (com.google.cloud.contentwarehouse.v1.SetAclRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.SetAclResponse>)
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
            getCreateDocumentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contentwarehouse.v1.CreateDocumentRequest,
                    com.google.cloud.contentwarehouse.v1.CreateDocumentResponse>(
                    service, METHODID_CREATE_DOCUMENT)))
        .addMethod(
            getGetDocumentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contentwarehouse.v1.GetDocumentRequest,
                    com.google.cloud.contentwarehouse.v1.Document>(service, METHODID_GET_DOCUMENT)))
        .addMethod(
            getUpdateDocumentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contentwarehouse.v1.UpdateDocumentRequest,
                    com.google.cloud.contentwarehouse.v1.UpdateDocumentResponse>(
                    service, METHODID_UPDATE_DOCUMENT)))
        .addMethod(
            getDeleteDocumentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contentwarehouse.v1.DeleteDocumentRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_DOCUMENT)))
        .addMethod(
            getSearchDocumentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contentwarehouse.v1.SearchDocumentsRequest,
                    com.google.cloud.contentwarehouse.v1.SearchDocumentsResponse>(
                    service, METHODID_SEARCH_DOCUMENTS)))
        .addMethod(
            getLockDocumentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contentwarehouse.v1.LockDocumentRequest,
                    com.google.cloud.contentwarehouse.v1.Document>(
                    service, METHODID_LOCK_DOCUMENT)))
        .addMethod(
            getFetchAclMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contentwarehouse.v1.FetchAclRequest,
                    com.google.cloud.contentwarehouse.v1.FetchAclResponse>(
                    service, METHODID_FETCH_ACL)))
        .addMethod(
            getSetAclMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contentwarehouse.v1.SetAclRequest,
                    com.google.cloud.contentwarehouse.v1.SetAclResponse>(
                    service, METHODID_SET_ACL)))
        .build();
  }

  private abstract static class DocumentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DocumentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.contentwarehouse.v1.DocumentServiceProto.getDescriptor();
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
                      .addMethod(getCreateDocumentMethod())
                      .addMethod(getGetDocumentMethod())
                      .addMethod(getUpdateDocumentMethod())
                      .addMethod(getDeleteDocumentMethod())
                      .addMethod(getSearchDocumentsMethod())
                      .addMethod(getLockDocumentMethod())
                      .addMethod(getFetchAclMethod())
                      .addMethod(getSetAclMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
