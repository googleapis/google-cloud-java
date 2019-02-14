package com.google.cloud.dialogflow.v2beta1;

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
 * Manages documents of a knowledge base.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/dialogflow/v2beta1/document.proto")
public final class DocumentsGrpc {

  private DocumentsGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dialogflow.v2beta1.Documents";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListDocumentsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.ListDocumentsRequest,
          com.google.cloud.dialogflow.v2beta1.ListDocumentsResponse>
      METHOD_LIST_DOCUMENTS = getListDocumentsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.ListDocumentsRequest,
          com.google.cloud.dialogflow.v2beta1.ListDocumentsResponse>
      getListDocumentsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.ListDocumentsRequest,
          com.google.cloud.dialogflow.v2beta1.ListDocumentsResponse>
      getListDocumentsMethod() {
    return getListDocumentsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.ListDocumentsRequest,
          com.google.cloud.dialogflow.v2beta1.ListDocumentsResponse>
      getListDocumentsMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dialogflow.v2beta1.Documents", "ListDocuments"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetDocumentMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.GetDocumentRequest,
          com.google.cloud.dialogflow.v2beta1.Document>
      METHOD_GET_DOCUMENT = getGetDocumentMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.GetDocumentRequest,
          com.google.cloud.dialogflow.v2beta1.Document>
      getGetDocumentMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.GetDocumentRequest,
          com.google.cloud.dialogflow.v2beta1.Document>
      getGetDocumentMethod() {
    return getGetDocumentMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.GetDocumentRequest,
          com.google.cloud.dialogflow.v2beta1.Document>
      getGetDocumentMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dialogflow.v2beta1.Documents", "GetDocument"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateDocumentMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.CreateDocumentRequest,
          com.google.longrunning.Operation>
      METHOD_CREATE_DOCUMENT = getCreateDocumentMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.CreateDocumentRequest,
          com.google.longrunning.Operation>
      getCreateDocumentMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.CreateDocumentRequest,
          com.google.longrunning.Operation>
      getCreateDocumentMethod() {
    return getCreateDocumentMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.CreateDocumentRequest,
          com.google.longrunning.Operation>
      getCreateDocumentMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dialogflow.v2beta1.Documents", "CreateDocument"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteDocumentMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.DeleteDocumentRequest,
          com.google.longrunning.Operation>
      METHOD_DELETE_DOCUMENT = getDeleteDocumentMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.DeleteDocumentRequest,
          com.google.longrunning.Operation>
      getDeleteDocumentMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.DeleteDocumentRequest,
          com.google.longrunning.Operation>
      getDeleteDocumentMethod() {
    return getDeleteDocumentMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.DeleteDocumentRequest,
          com.google.longrunning.Operation>
      getDeleteDocumentMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dialogflow.v2beta1.Documents", "DeleteDocument"))
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

  /** Creates a new async stub that supports all call types for the service */
  public static DocumentsStub newStub(io.grpc.Channel channel) {
    return new DocumentsStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DocumentsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new DocumentsBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DocumentsFutureStub newFutureStub(io.grpc.Channel channel) {
    return new DocumentsFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * Manages documents of a knowledge base.
   * </pre>
   */
  public abstract static class DocumentsImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Returns the list of all documents of the knowledge base.
     * </pre>
     */
    public void listDocuments(
        com.google.cloud.dialogflow.v2beta1.ListDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.ListDocumentsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListDocumentsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified document.
     * </pre>
     */
    public void getDocument(
        com.google.cloud.dialogflow.v2beta1.GetDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Document>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetDocumentMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new document.
     * Operation &lt;response: [Document][google.cloud.dialogflow.v2beta1.Document],
     *            metadata: [KnowledgeOperationMetadata][google.cloud.dialogflow.v2beta1.KnowledgeOperationMetadata]&gt;
     * </pre>
     */
    public void createDocument(
        com.google.cloud.dialogflow.v2beta1.CreateDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateDocumentMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified document.
     * Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty],
     *            metadata: [KnowledgeOperationMetadata][google.cloud.dialogflow.v2beta1.KnowledgeOperationMetadata]&gt;
     * </pre>
     */
    public void deleteDocument(
        com.google.cloud.dialogflow.v2beta1.DeleteDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteDocumentMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListDocumentsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.ListDocumentsRequest,
                      com.google.cloud.dialogflow.v2beta1.ListDocumentsResponse>(
                      this, METHODID_LIST_DOCUMENTS)))
          .addMethod(
              getGetDocumentMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.GetDocumentRequest,
                      com.google.cloud.dialogflow.v2beta1.Document>(this, METHODID_GET_DOCUMENT)))
          .addMethod(
              getCreateDocumentMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.CreateDocumentRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_DOCUMENT)))
          .addMethod(
              getDeleteDocumentMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.DeleteDocumentRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_DOCUMENT)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Manages documents of a knowledge base.
   * </pre>
   */
  public static final class DocumentsStub extends io.grpc.stub.AbstractStub<DocumentsStub> {
    private DocumentsStub(io.grpc.Channel channel) {
      super(channel);
    }

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
     * </pre>
     */
    public void listDocuments(
        com.google.cloud.dialogflow.v2beta1.ListDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.ListDocumentsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListDocumentsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified document.
     * </pre>
     */
    public void getDocument(
        com.google.cloud.dialogflow.v2beta1.GetDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Document>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetDocumentMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new document.
     * Operation &lt;response: [Document][google.cloud.dialogflow.v2beta1.Document],
     *            metadata: [KnowledgeOperationMetadata][google.cloud.dialogflow.v2beta1.KnowledgeOperationMetadata]&gt;
     * </pre>
     */
    public void createDocument(
        com.google.cloud.dialogflow.v2beta1.CreateDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateDocumentMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified document.
     * Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty],
     *            metadata: [KnowledgeOperationMetadata][google.cloud.dialogflow.v2beta1.KnowledgeOperationMetadata]&gt;
     * </pre>
     */
    public void deleteDocument(
        com.google.cloud.dialogflow.v2beta1.DeleteDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteDocumentMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Manages documents of a knowledge base.
   * </pre>
   */
  public static final class DocumentsBlockingStub
      extends io.grpc.stub.AbstractStub<DocumentsBlockingStub> {
    private DocumentsBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

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
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.ListDocumentsResponse listDocuments(
        com.google.cloud.dialogflow.v2beta1.ListDocumentsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListDocumentsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified document.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.Document getDocument(
        com.google.cloud.dialogflow.v2beta1.GetDocumentRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetDocumentMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new document.
     * Operation &lt;response: [Document][google.cloud.dialogflow.v2beta1.Document],
     *            metadata: [KnowledgeOperationMetadata][google.cloud.dialogflow.v2beta1.KnowledgeOperationMetadata]&gt;
     * </pre>
     */
    public com.google.longrunning.Operation createDocument(
        com.google.cloud.dialogflow.v2beta1.CreateDocumentRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateDocumentMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified document.
     * Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty],
     *            metadata: [KnowledgeOperationMetadata][google.cloud.dialogflow.v2beta1.KnowledgeOperationMetadata]&gt;
     * </pre>
     */
    public com.google.longrunning.Operation deleteDocument(
        com.google.cloud.dialogflow.v2beta1.DeleteDocumentRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteDocumentMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Manages documents of a knowledge base.
   * </pre>
   */
  public static final class DocumentsFutureStub
      extends io.grpc.stub.AbstractStub<DocumentsFutureStub> {
    private DocumentsFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

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
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.ListDocumentsResponse>
        listDocuments(com.google.cloud.dialogflow.v2beta1.ListDocumentsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListDocumentsMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified document.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.Document>
        getDocument(com.google.cloud.dialogflow.v2beta1.GetDocumentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetDocumentMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new document.
     * Operation &lt;response: [Document][google.cloud.dialogflow.v2beta1.Document],
     *            metadata: [KnowledgeOperationMetadata][google.cloud.dialogflow.v2beta1.KnowledgeOperationMetadata]&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createDocument(com.google.cloud.dialogflow.v2beta1.CreateDocumentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateDocumentMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified document.
     * Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty],
     *            metadata: [KnowledgeOperationMetadata][google.cloud.dialogflow.v2beta1.KnowledgeOperationMetadata]&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteDocument(com.google.cloud.dialogflow.v2beta1.DeleteDocumentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteDocumentMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_DOCUMENTS = 0;
  private static final int METHODID_GET_DOCUMENT = 1;
  private static final int METHODID_CREATE_DOCUMENT = 2;
  private static final int METHODID_DELETE_DOCUMENT = 3;

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
        case METHODID_DELETE_DOCUMENT:
          serviceImpl.deleteDocument(
              (com.google.cloud.dialogflow.v2beta1.DeleteDocumentRequest) request,
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
                      .addMethod(getListDocumentsMethodHelper())
                      .addMethod(getGetDocumentMethodHelper())
                      .addMethod(getCreateDocumentMethodHelper())
                      .addMethod(getDeleteDocumentMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
