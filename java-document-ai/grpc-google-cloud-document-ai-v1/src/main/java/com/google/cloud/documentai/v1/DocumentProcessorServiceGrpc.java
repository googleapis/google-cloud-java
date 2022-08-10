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
package com.google.cloud.documentai.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service to call Cloud DocumentAI to process documents according to the
 * processor's definition. Processors are built using state-of-the-art Google
 * AI such as natural language, computer vision, and translation to extract
 * structured information from unstructured or semi-structured documents.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/documentai/v1/document_processor_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DocumentProcessorServiceGrpc {

  private DocumentProcessorServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.documentai.v1.DocumentProcessorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.ProcessRequest,
          com.google.cloud.documentai.v1.ProcessResponse>
      getProcessDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProcessDocument",
      requestType = com.google.cloud.documentai.v1.ProcessRequest.class,
      responseType = com.google.cloud.documentai.v1.ProcessResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.ProcessRequest,
          com.google.cloud.documentai.v1.ProcessResponse>
      getProcessDocumentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.documentai.v1.ProcessRequest,
            com.google.cloud.documentai.v1.ProcessResponse>
        getProcessDocumentMethod;
    if ((getProcessDocumentMethod = DocumentProcessorServiceGrpc.getProcessDocumentMethod)
        == null) {
      synchronized (DocumentProcessorServiceGrpc.class) {
        if ((getProcessDocumentMethod = DocumentProcessorServiceGrpc.getProcessDocumentMethod)
            == null) {
          DocumentProcessorServiceGrpc.getProcessDocumentMethod =
              getProcessDocumentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.documentai.v1.ProcessRequest,
                          com.google.cloud.documentai.v1.ProcessResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ProcessDocument"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1.ProcessRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1.ProcessResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentProcessorServiceMethodDescriptorSupplier("ProcessDocument"))
                      .build();
        }
      }
    }
    return getProcessDocumentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.BatchProcessRequest, com.google.longrunning.Operation>
      getBatchProcessDocumentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchProcessDocuments",
      requestType = com.google.cloud.documentai.v1.BatchProcessRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.BatchProcessRequest, com.google.longrunning.Operation>
      getBatchProcessDocumentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.documentai.v1.BatchProcessRequest, com.google.longrunning.Operation>
        getBatchProcessDocumentsMethod;
    if ((getBatchProcessDocumentsMethod =
            DocumentProcessorServiceGrpc.getBatchProcessDocumentsMethod)
        == null) {
      synchronized (DocumentProcessorServiceGrpc.class) {
        if ((getBatchProcessDocumentsMethod =
                DocumentProcessorServiceGrpc.getBatchProcessDocumentsMethod)
            == null) {
          DocumentProcessorServiceGrpc.getBatchProcessDocumentsMethod =
              getBatchProcessDocumentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.documentai.v1.BatchProcessRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchProcessDocuments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1.BatchProcessRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentProcessorServiceMethodDescriptorSupplier(
                              "BatchProcessDocuments"))
                      .build();
        }
      }
    }
    return getBatchProcessDocumentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.ReviewDocumentRequest, com.google.longrunning.Operation>
      getReviewDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReviewDocument",
      requestType = com.google.cloud.documentai.v1.ReviewDocumentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.ReviewDocumentRequest, com.google.longrunning.Operation>
      getReviewDocumentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.documentai.v1.ReviewDocumentRequest, com.google.longrunning.Operation>
        getReviewDocumentMethod;
    if ((getReviewDocumentMethod = DocumentProcessorServiceGrpc.getReviewDocumentMethod) == null) {
      synchronized (DocumentProcessorServiceGrpc.class) {
        if ((getReviewDocumentMethod = DocumentProcessorServiceGrpc.getReviewDocumentMethod)
            == null) {
          DocumentProcessorServiceGrpc.getReviewDocumentMethod =
              getReviewDocumentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.documentai.v1.ReviewDocumentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReviewDocument"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1.ReviewDocumentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentProcessorServiceMethodDescriptorSupplier("ReviewDocument"))
                      .build();
        }
      }
    }
    return getReviewDocumentMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DocumentProcessorServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DocumentProcessorServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DocumentProcessorServiceStub>() {
          @java.lang.Override
          public DocumentProcessorServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DocumentProcessorServiceStub(channel, callOptions);
          }
        };
    return DocumentProcessorServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DocumentProcessorServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DocumentProcessorServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DocumentProcessorServiceBlockingStub>() {
          @java.lang.Override
          public DocumentProcessorServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DocumentProcessorServiceBlockingStub(channel, callOptions);
          }
        };
    return DocumentProcessorServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DocumentProcessorServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DocumentProcessorServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DocumentProcessorServiceFutureStub>() {
          @java.lang.Override
          public DocumentProcessorServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DocumentProcessorServiceFutureStub(channel, callOptions);
          }
        };
    return DocumentProcessorServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to call Cloud DocumentAI to process documents according to the
   * processor's definition. Processors are built using state-of-the-art Google
   * AI such as natural language, computer vision, and translation to extract
   * structured information from unstructured or semi-structured documents.
   * </pre>
   */
  public abstract static class DocumentProcessorServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Processes a single document.
     * </pre>
     */
    public void processDocument(
        com.google.cloud.documentai.v1.ProcessRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1.ProcessResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getProcessDocumentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * LRO endpoint to batch process many documents. The output is written
     * to Cloud Storage as JSON in the [Document] format.
     * </pre>
     */
    public void batchProcessDocuments(
        com.google.cloud.documentai.v1.BatchProcessRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchProcessDocumentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Send a document for Human Review. The input document should be processed by
     * the specified processor.
     * </pre>
     */
    public void reviewDocument(
        com.google.cloud.documentai.v1.ReviewDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getReviewDocumentMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getProcessDocumentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.documentai.v1.ProcessRequest,
                      com.google.cloud.documentai.v1.ProcessResponse>(
                      this, METHODID_PROCESS_DOCUMENT)))
          .addMethod(
              getBatchProcessDocumentsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.documentai.v1.BatchProcessRequest,
                      com.google.longrunning.Operation>(this, METHODID_BATCH_PROCESS_DOCUMENTS)))
          .addMethod(
              getReviewDocumentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.documentai.v1.ReviewDocumentRequest,
                      com.google.longrunning.Operation>(this, METHODID_REVIEW_DOCUMENT)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service to call Cloud DocumentAI to process documents according to the
   * processor's definition. Processors are built using state-of-the-art Google
   * AI such as natural language, computer vision, and translation to extract
   * structured information from unstructured or semi-structured documents.
   * </pre>
   */
  public static final class DocumentProcessorServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DocumentProcessorServiceStub> {
    private DocumentProcessorServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DocumentProcessorServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DocumentProcessorServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Processes a single document.
     * </pre>
     */
    public void processDocument(
        com.google.cloud.documentai.v1.ProcessRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1.ProcessResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getProcessDocumentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * LRO endpoint to batch process many documents. The output is written
     * to Cloud Storage as JSON in the [Document] format.
     * </pre>
     */
    public void batchProcessDocuments(
        com.google.cloud.documentai.v1.BatchProcessRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchProcessDocumentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Send a document for Human Review. The input document should be processed by
     * the specified processor.
     * </pre>
     */
    public void reviewDocument(
        com.google.cloud.documentai.v1.ReviewDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReviewDocumentMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service to call Cloud DocumentAI to process documents according to the
   * processor's definition. Processors are built using state-of-the-art Google
   * AI such as natural language, computer vision, and translation to extract
   * structured information from unstructured or semi-structured documents.
   * </pre>
   */
  public static final class DocumentProcessorServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DocumentProcessorServiceBlockingStub> {
    private DocumentProcessorServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DocumentProcessorServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DocumentProcessorServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Processes a single document.
     * </pre>
     */
    public com.google.cloud.documentai.v1.ProcessResponse processDocument(
        com.google.cloud.documentai.v1.ProcessRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getProcessDocumentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * LRO endpoint to batch process many documents. The output is written
     * to Cloud Storage as JSON in the [Document] format.
     * </pre>
     */
    public com.google.longrunning.Operation batchProcessDocuments(
        com.google.cloud.documentai.v1.BatchProcessRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchProcessDocumentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Send a document for Human Review. The input document should be processed by
     * the specified processor.
     * </pre>
     */
    public com.google.longrunning.Operation reviewDocument(
        com.google.cloud.documentai.v1.ReviewDocumentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReviewDocumentMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service to call Cloud DocumentAI to process documents according to the
   * processor's definition. Processors are built using state-of-the-art Google
   * AI such as natural language, computer vision, and translation to extract
   * structured information from unstructured or semi-structured documents.
   * </pre>
   */
  public static final class DocumentProcessorServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DocumentProcessorServiceFutureStub> {
    private DocumentProcessorServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DocumentProcessorServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DocumentProcessorServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Processes a single document.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.documentai.v1.ProcessResponse>
        processDocument(com.google.cloud.documentai.v1.ProcessRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getProcessDocumentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * LRO endpoint to batch process many documents. The output is written
     * to Cloud Storage as JSON in the [Document] format.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchProcessDocuments(com.google.cloud.documentai.v1.BatchProcessRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchProcessDocumentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Send a document for Human Review. The input document should be processed by
     * the specified processor.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        reviewDocument(com.google.cloud.documentai.v1.ReviewDocumentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReviewDocumentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PROCESS_DOCUMENT = 0;
  private static final int METHODID_BATCH_PROCESS_DOCUMENTS = 1;
  private static final int METHODID_REVIEW_DOCUMENT = 2;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DocumentProcessorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DocumentProcessorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PROCESS_DOCUMENT:
          serviceImpl.processDocument(
              (com.google.cloud.documentai.v1.ProcessRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1.ProcessResponse>)
                  responseObserver);
          break;
        case METHODID_BATCH_PROCESS_DOCUMENTS:
          serviceImpl.batchProcessDocuments(
              (com.google.cloud.documentai.v1.BatchProcessRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_REVIEW_DOCUMENT:
          serviceImpl.reviewDocument(
              (com.google.cloud.documentai.v1.ReviewDocumentRequest) request,
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

  private abstract static class DocumentProcessorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DocumentProcessorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.documentai.v1.DocumentAiProcessorService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DocumentProcessorService");
    }
  }

  private static final class DocumentProcessorServiceFileDescriptorSupplier
      extends DocumentProcessorServiceBaseDescriptorSupplier {
    DocumentProcessorServiceFileDescriptorSupplier() {}
  }

  private static final class DocumentProcessorServiceMethodDescriptorSupplier
      extends DocumentProcessorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DocumentProcessorServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DocumentProcessorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DocumentProcessorServiceFileDescriptorSupplier())
                      .addMethod(getProcessDocumentMethod())
                      .addMethod(getBatchProcessDocumentsMethod())
                      .addMethod(getReviewDocumentMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
