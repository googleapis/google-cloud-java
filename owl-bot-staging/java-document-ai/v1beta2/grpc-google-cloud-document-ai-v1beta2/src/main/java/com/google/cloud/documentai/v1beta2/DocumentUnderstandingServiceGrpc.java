package com.google.cloud.documentai.v1beta2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Service to parse structured information from unstructured or semi-structured
 * documents using state-of-the-art Google AI such as natural language,
 * computer vision, and translation.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/documentai/v1beta2/document_understanding.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DocumentUnderstandingServiceGrpc {

  private DocumentUnderstandingServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.documentai.v1beta2.DocumentUnderstandingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.documentai.v1beta2.BatchProcessDocumentsRequest,
      com.google.longrunning.Operation> getBatchProcessDocumentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchProcessDocuments",
      requestType = com.google.cloud.documentai.v1beta2.BatchProcessDocumentsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.documentai.v1beta2.BatchProcessDocumentsRequest,
      com.google.longrunning.Operation> getBatchProcessDocumentsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.documentai.v1beta2.BatchProcessDocumentsRequest, com.google.longrunning.Operation> getBatchProcessDocumentsMethod;
    if ((getBatchProcessDocumentsMethod = DocumentUnderstandingServiceGrpc.getBatchProcessDocumentsMethod) == null) {
      synchronized (DocumentUnderstandingServiceGrpc.class) {
        if ((getBatchProcessDocumentsMethod = DocumentUnderstandingServiceGrpc.getBatchProcessDocumentsMethod) == null) {
          DocumentUnderstandingServiceGrpc.getBatchProcessDocumentsMethod = getBatchProcessDocumentsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.documentai.v1beta2.BatchProcessDocumentsRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchProcessDocuments"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.documentai.v1beta2.BatchProcessDocumentsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DocumentUnderstandingServiceMethodDescriptorSupplier("BatchProcessDocuments"))
              .build();
        }
      }
    }
    return getBatchProcessDocumentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.documentai.v1beta2.ProcessDocumentRequest,
      com.google.cloud.documentai.v1beta2.Document> getProcessDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProcessDocument",
      requestType = com.google.cloud.documentai.v1beta2.ProcessDocumentRequest.class,
      responseType = com.google.cloud.documentai.v1beta2.Document.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.documentai.v1beta2.ProcessDocumentRequest,
      com.google.cloud.documentai.v1beta2.Document> getProcessDocumentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.documentai.v1beta2.ProcessDocumentRequest, com.google.cloud.documentai.v1beta2.Document> getProcessDocumentMethod;
    if ((getProcessDocumentMethod = DocumentUnderstandingServiceGrpc.getProcessDocumentMethod) == null) {
      synchronized (DocumentUnderstandingServiceGrpc.class) {
        if ((getProcessDocumentMethod = DocumentUnderstandingServiceGrpc.getProcessDocumentMethod) == null) {
          DocumentUnderstandingServiceGrpc.getProcessDocumentMethod = getProcessDocumentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.documentai.v1beta2.ProcessDocumentRequest, com.google.cloud.documentai.v1beta2.Document>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ProcessDocument"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.documentai.v1beta2.ProcessDocumentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.documentai.v1beta2.Document.getDefaultInstance()))
              .setSchemaDescriptor(new DocumentUnderstandingServiceMethodDescriptorSupplier("ProcessDocument"))
              .build();
        }
      }
    }
    return getProcessDocumentMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DocumentUnderstandingServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DocumentUnderstandingServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DocumentUnderstandingServiceStub>() {
        @java.lang.Override
        public DocumentUnderstandingServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DocumentUnderstandingServiceStub(channel, callOptions);
        }
      };
    return DocumentUnderstandingServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DocumentUnderstandingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DocumentUnderstandingServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DocumentUnderstandingServiceBlockingStub>() {
        @java.lang.Override
        public DocumentUnderstandingServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DocumentUnderstandingServiceBlockingStub(channel, callOptions);
        }
      };
    return DocumentUnderstandingServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DocumentUnderstandingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DocumentUnderstandingServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DocumentUnderstandingServiceFutureStub>() {
        @java.lang.Override
        public DocumentUnderstandingServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DocumentUnderstandingServiceFutureStub(channel, callOptions);
        }
      };
    return DocumentUnderstandingServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service to parse structured information from unstructured or semi-structured
   * documents using state-of-the-art Google AI such as natural language,
   * computer vision, and translation.
   * </pre>
   */
  public static abstract class DocumentUnderstandingServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * LRO endpoint to batch process many documents. The output is written
     * to Cloud Storage as JSON in the [Document] format.
     * </pre>
     */
    public void batchProcessDocuments(com.google.cloud.documentai.v1beta2.BatchProcessDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBatchProcessDocumentsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Processes a single document.
     * </pre>
     */
    public void processDocument(com.google.cloud.documentai.v1beta2.ProcessDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1beta2.Document> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getProcessDocumentMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getBatchProcessDocumentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.documentai.v1beta2.BatchProcessDocumentsRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_BATCH_PROCESS_DOCUMENTS)))
          .addMethod(
            getProcessDocumentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.documentai.v1beta2.ProcessDocumentRequest,
                com.google.cloud.documentai.v1beta2.Document>(
                  this, METHODID_PROCESS_DOCUMENT)))
          .build();
    }
  }

  /**
   * <pre>
   * Service to parse structured information from unstructured or semi-structured
   * documents using state-of-the-art Google AI such as natural language,
   * computer vision, and translation.
   * </pre>
   */
  public static final class DocumentUnderstandingServiceStub extends io.grpc.stub.AbstractAsyncStub<DocumentUnderstandingServiceStub> {
    private DocumentUnderstandingServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DocumentUnderstandingServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DocumentUnderstandingServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * LRO endpoint to batch process many documents. The output is written
     * to Cloud Storage as JSON in the [Document] format.
     * </pre>
     */
    public void batchProcessDocuments(com.google.cloud.documentai.v1beta2.BatchProcessDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchProcessDocumentsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Processes a single document.
     * </pre>
     */
    public void processDocument(com.google.cloud.documentai.v1beta2.ProcessDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1beta2.Document> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getProcessDocumentMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service to parse structured information from unstructured or semi-structured
   * documents using state-of-the-art Google AI such as natural language,
   * computer vision, and translation.
   * </pre>
   */
  public static final class DocumentUnderstandingServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<DocumentUnderstandingServiceBlockingStub> {
    private DocumentUnderstandingServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DocumentUnderstandingServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DocumentUnderstandingServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * LRO endpoint to batch process many documents. The output is written
     * to Cloud Storage as JSON in the [Document] format.
     * </pre>
     */
    public com.google.longrunning.Operation batchProcessDocuments(com.google.cloud.documentai.v1beta2.BatchProcessDocumentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchProcessDocumentsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Processes a single document.
     * </pre>
     */
    public com.google.cloud.documentai.v1beta2.Document processDocument(com.google.cloud.documentai.v1beta2.ProcessDocumentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getProcessDocumentMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service to parse structured information from unstructured or semi-structured
   * documents using state-of-the-art Google AI such as natural language,
   * computer vision, and translation.
   * </pre>
   */
  public static final class DocumentUnderstandingServiceFutureStub extends io.grpc.stub.AbstractFutureStub<DocumentUnderstandingServiceFutureStub> {
    private DocumentUnderstandingServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DocumentUnderstandingServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DocumentUnderstandingServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * LRO endpoint to batch process many documents. The output is written
     * to Cloud Storage as JSON in the [Document] format.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> batchProcessDocuments(
        com.google.cloud.documentai.v1beta2.BatchProcessDocumentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchProcessDocumentsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Processes a single document.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.documentai.v1beta2.Document> processDocument(
        com.google.cloud.documentai.v1beta2.ProcessDocumentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getProcessDocumentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_BATCH_PROCESS_DOCUMENTS = 0;
  private static final int METHODID_PROCESS_DOCUMENT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DocumentUnderstandingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DocumentUnderstandingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BATCH_PROCESS_DOCUMENTS:
          serviceImpl.batchProcessDocuments((com.google.cloud.documentai.v1beta2.BatchProcessDocumentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_PROCESS_DOCUMENT:
          serviceImpl.processDocument((com.google.cloud.documentai.v1beta2.ProcessDocumentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1beta2.Document>) responseObserver);
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

  private static abstract class DocumentUnderstandingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DocumentUnderstandingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.documentai.v1beta2.DocumentAiProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DocumentUnderstandingService");
    }
  }

  private static final class DocumentUnderstandingServiceFileDescriptorSupplier
      extends DocumentUnderstandingServiceBaseDescriptorSupplier {
    DocumentUnderstandingServiceFileDescriptorSupplier() {}
  }

  private static final class DocumentUnderstandingServiceMethodDescriptorSupplier
      extends DocumentUnderstandingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DocumentUnderstandingServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DocumentUnderstandingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DocumentUnderstandingServiceFileDescriptorSupplier())
              .addMethod(getBatchProcessDocumentsMethod())
              .addMethod(getProcessDocumentMethod())
              .build();
        }
      }
    }
    return result;
  }
}
