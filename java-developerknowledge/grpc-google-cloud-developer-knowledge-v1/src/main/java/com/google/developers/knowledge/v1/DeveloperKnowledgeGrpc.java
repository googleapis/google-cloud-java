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
package com.google.developers.knowledge.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The Developer Knowledge API provides programmatic access to Google's public
 * developer documentation, enabling you to integrate this knowledge base into
 * your own applications and workflows.
 * The API is designed to be the canonical source for machine-readable access to
 * Google's developer documentation.
 * A typical use case is to first use
 * [DeveloperKnowledge.SearchDocumentChunks][google.developers.knowledge.v1.DeveloperKnowledge.SearchDocumentChunks]
 * to find relevant page URIs based on a query, and then use
 * [DeveloperKnowledge.GetDocument][google.developers.knowledge.v1.DeveloperKnowledge.GetDocument]
 * or
 * [DeveloperKnowledge.BatchGetDocuments][google.developers.knowledge.v1.DeveloperKnowledge.BatchGetDocuments]
 * to fetch the full content of the top results.
 * All document content is provided in Markdown format.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class DeveloperKnowledgeGrpc {

  private DeveloperKnowledgeGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.developers.knowledge.v1.DeveloperKnowledge";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.developers.knowledge.v1.SearchDocumentChunksRequest,
          com.google.developers.knowledge.v1.SearchDocumentChunksResponse>
      getSearchDocumentChunksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchDocumentChunks",
      requestType = com.google.developers.knowledge.v1.SearchDocumentChunksRequest.class,
      responseType = com.google.developers.knowledge.v1.SearchDocumentChunksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.developers.knowledge.v1.SearchDocumentChunksRequest,
          com.google.developers.knowledge.v1.SearchDocumentChunksResponse>
      getSearchDocumentChunksMethod() {
    io.grpc.MethodDescriptor<
            com.google.developers.knowledge.v1.SearchDocumentChunksRequest,
            com.google.developers.knowledge.v1.SearchDocumentChunksResponse>
        getSearchDocumentChunksMethod;
    if ((getSearchDocumentChunksMethod = DeveloperKnowledgeGrpc.getSearchDocumentChunksMethod)
        == null) {
      synchronized (DeveloperKnowledgeGrpc.class) {
        if ((getSearchDocumentChunksMethod = DeveloperKnowledgeGrpc.getSearchDocumentChunksMethod)
            == null) {
          DeveloperKnowledgeGrpc.getSearchDocumentChunksMethod =
              getSearchDocumentChunksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.developers.knowledge.v1.SearchDocumentChunksRequest,
                          com.google.developers.knowledge.v1.SearchDocumentChunksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SearchDocumentChunks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.developers.knowledge.v1.SearchDocumentChunksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.developers.knowledge.v1.SearchDocumentChunksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeveloperKnowledgeMethodDescriptorSupplier("SearchDocumentChunks"))
                      .build();
        }
      }
    }
    return getSearchDocumentChunksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.developers.knowledge.v1.GetDocumentRequest,
          com.google.developers.knowledge.v1.Document>
      getGetDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDocument",
      requestType = com.google.developers.knowledge.v1.GetDocumentRequest.class,
      responseType = com.google.developers.knowledge.v1.Document.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.developers.knowledge.v1.GetDocumentRequest,
          com.google.developers.knowledge.v1.Document>
      getGetDocumentMethod() {
    io.grpc.MethodDescriptor<
            com.google.developers.knowledge.v1.GetDocumentRequest,
            com.google.developers.knowledge.v1.Document>
        getGetDocumentMethod;
    if ((getGetDocumentMethod = DeveloperKnowledgeGrpc.getGetDocumentMethod) == null) {
      synchronized (DeveloperKnowledgeGrpc.class) {
        if ((getGetDocumentMethod = DeveloperKnowledgeGrpc.getGetDocumentMethod) == null) {
          DeveloperKnowledgeGrpc.getGetDocumentMethod =
              getGetDocumentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.developers.knowledge.v1.GetDocumentRequest,
                          com.google.developers.knowledge.v1.Document>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDocument"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.developers.knowledge.v1.GetDocumentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.developers.knowledge.v1.Document.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeveloperKnowledgeMethodDescriptorSupplier("GetDocument"))
                      .build();
        }
      }
    }
    return getGetDocumentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.developers.knowledge.v1.BatchGetDocumentsRequest,
          com.google.developers.knowledge.v1.BatchGetDocumentsResponse>
      getBatchGetDocumentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchGetDocuments",
      requestType = com.google.developers.knowledge.v1.BatchGetDocumentsRequest.class,
      responseType = com.google.developers.knowledge.v1.BatchGetDocumentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.developers.knowledge.v1.BatchGetDocumentsRequest,
          com.google.developers.knowledge.v1.BatchGetDocumentsResponse>
      getBatchGetDocumentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.developers.knowledge.v1.BatchGetDocumentsRequest,
            com.google.developers.knowledge.v1.BatchGetDocumentsResponse>
        getBatchGetDocumentsMethod;
    if ((getBatchGetDocumentsMethod = DeveloperKnowledgeGrpc.getBatchGetDocumentsMethod) == null) {
      synchronized (DeveloperKnowledgeGrpc.class) {
        if ((getBatchGetDocumentsMethod = DeveloperKnowledgeGrpc.getBatchGetDocumentsMethod)
            == null) {
          DeveloperKnowledgeGrpc.getBatchGetDocumentsMethod =
              getBatchGetDocumentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.developers.knowledge.v1.BatchGetDocumentsRequest,
                          com.google.developers.knowledge.v1.BatchGetDocumentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchGetDocuments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.developers.knowledge.v1.BatchGetDocumentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.developers.knowledge.v1.BatchGetDocumentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeveloperKnowledgeMethodDescriptorSupplier("BatchGetDocuments"))
                      .build();
        }
      }
    }
    return getBatchGetDocumentsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DeveloperKnowledgeStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeveloperKnowledgeStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DeveloperKnowledgeStub>() {
          @java.lang.Override
          public DeveloperKnowledgeStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DeveloperKnowledgeStub(channel, callOptions);
          }
        };
    return DeveloperKnowledgeStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static DeveloperKnowledgeBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeveloperKnowledgeBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DeveloperKnowledgeBlockingV2Stub>() {
          @java.lang.Override
          public DeveloperKnowledgeBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DeveloperKnowledgeBlockingV2Stub(channel, callOptions);
          }
        };
    return DeveloperKnowledgeBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DeveloperKnowledgeBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeveloperKnowledgeBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DeveloperKnowledgeBlockingStub>() {
          @java.lang.Override
          public DeveloperKnowledgeBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DeveloperKnowledgeBlockingStub(channel, callOptions);
          }
        };
    return DeveloperKnowledgeBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DeveloperKnowledgeFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeveloperKnowledgeFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DeveloperKnowledgeFutureStub>() {
          @java.lang.Override
          public DeveloperKnowledgeFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DeveloperKnowledgeFutureStub(channel, callOptions);
          }
        };
    return DeveloperKnowledgeFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The Developer Knowledge API provides programmatic access to Google's public
   * developer documentation, enabling you to integrate this knowledge base into
   * your own applications and workflows.
   * The API is designed to be the canonical source for machine-readable access to
   * Google's developer documentation.
   * A typical use case is to first use
   * [DeveloperKnowledge.SearchDocumentChunks][google.developers.knowledge.v1.DeveloperKnowledge.SearchDocumentChunks]
   * to find relevant page URIs based on a query, and then use
   * [DeveloperKnowledge.GetDocument][google.developers.knowledge.v1.DeveloperKnowledge.GetDocument]
   * or
   * [DeveloperKnowledge.BatchGetDocuments][google.developers.knowledge.v1.DeveloperKnowledge.BatchGetDocuments]
   * to fetch the full content of the top results.
   * All document content is provided in Markdown format.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Searches for developer knowledge across Google's developer documentation.
     * Returns [DocumentChunk][google.developers.knowledge.v1.DocumentChunk]s
     * based on the user's query. There may be many chunks from the same
     * [Document][google.developers.knowledge.v1.Document].  To retrieve full
     * documents, use
     * [DeveloperKnowledge.GetDocument][google.developers.knowledge.v1.DeveloperKnowledge.GetDocument]
     * or
     * [DeveloperKnowledge.BatchGetDocuments][google.developers.knowledge.v1.DeveloperKnowledge.BatchGetDocuments]
     * with the
     * [DocumentChunk.parent][google.developers.knowledge.v1.DocumentChunk.parent]
     * returned in the
     * [SearchDocumentChunksResponse.results][google.developers.knowledge.v1.SearchDocumentChunksResponse.results].
     * </pre>
     */
    default void searchDocumentChunks(
        com.google.developers.knowledge.v1.SearchDocumentChunksRequest request,
        io.grpc.stub.StreamObserver<com.google.developers.knowledge.v1.SearchDocumentChunksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchDocumentChunksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a single document with its full Markdown content.
     * </pre>
     */
    default void getDocument(
        com.google.developers.knowledge.v1.GetDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.developers.knowledge.v1.Document> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDocumentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves multiple documents, each with its full Markdown content.
     * </pre>
     */
    default void batchGetDocuments(
        com.google.developers.knowledge.v1.BatchGetDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.developers.knowledge.v1.BatchGetDocumentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchGetDocumentsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DeveloperKnowledge.
   *
   * <pre>
   * The Developer Knowledge API provides programmatic access to Google's public
   * developer documentation, enabling you to integrate this knowledge base into
   * your own applications and workflows.
   * The API is designed to be the canonical source for machine-readable access to
   * Google's developer documentation.
   * A typical use case is to first use
   * [DeveloperKnowledge.SearchDocumentChunks][google.developers.knowledge.v1.DeveloperKnowledge.SearchDocumentChunks]
   * to find relevant page URIs based on a query, and then use
   * [DeveloperKnowledge.GetDocument][google.developers.knowledge.v1.DeveloperKnowledge.GetDocument]
   * or
   * [DeveloperKnowledge.BatchGetDocuments][google.developers.knowledge.v1.DeveloperKnowledge.BatchGetDocuments]
   * to fetch the full content of the top results.
   * All document content is provided in Markdown format.
   * </pre>
   */
  public abstract static class DeveloperKnowledgeImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DeveloperKnowledgeGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DeveloperKnowledge.
   *
   * <pre>
   * The Developer Knowledge API provides programmatic access to Google's public
   * developer documentation, enabling you to integrate this knowledge base into
   * your own applications and workflows.
   * The API is designed to be the canonical source for machine-readable access to
   * Google's developer documentation.
   * A typical use case is to first use
   * [DeveloperKnowledge.SearchDocumentChunks][google.developers.knowledge.v1.DeveloperKnowledge.SearchDocumentChunks]
   * to find relevant page URIs based on a query, and then use
   * [DeveloperKnowledge.GetDocument][google.developers.knowledge.v1.DeveloperKnowledge.GetDocument]
   * or
   * [DeveloperKnowledge.BatchGetDocuments][google.developers.knowledge.v1.DeveloperKnowledge.BatchGetDocuments]
   * to fetch the full content of the top results.
   * All document content is provided in Markdown format.
   * </pre>
   */
  public static final class DeveloperKnowledgeStub
      extends io.grpc.stub.AbstractAsyncStub<DeveloperKnowledgeStub> {
    private DeveloperKnowledgeStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeveloperKnowledgeStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeveloperKnowledgeStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Searches for developer knowledge across Google's developer documentation.
     * Returns [DocumentChunk][google.developers.knowledge.v1.DocumentChunk]s
     * based on the user's query. There may be many chunks from the same
     * [Document][google.developers.knowledge.v1.Document].  To retrieve full
     * documents, use
     * [DeveloperKnowledge.GetDocument][google.developers.knowledge.v1.DeveloperKnowledge.GetDocument]
     * or
     * [DeveloperKnowledge.BatchGetDocuments][google.developers.knowledge.v1.DeveloperKnowledge.BatchGetDocuments]
     * with the
     * [DocumentChunk.parent][google.developers.knowledge.v1.DocumentChunk.parent]
     * returned in the
     * [SearchDocumentChunksResponse.results][google.developers.knowledge.v1.SearchDocumentChunksResponse.results].
     * </pre>
     */
    public void searchDocumentChunks(
        com.google.developers.knowledge.v1.SearchDocumentChunksRequest request,
        io.grpc.stub.StreamObserver<com.google.developers.knowledge.v1.SearchDocumentChunksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchDocumentChunksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a single document with its full Markdown content.
     * </pre>
     */
    public void getDocument(
        com.google.developers.knowledge.v1.GetDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.developers.knowledge.v1.Document> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDocumentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves multiple documents, each with its full Markdown content.
     * </pre>
     */
    public void batchGetDocuments(
        com.google.developers.knowledge.v1.BatchGetDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.developers.knowledge.v1.BatchGetDocumentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchGetDocumentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DeveloperKnowledge.
   *
   * <pre>
   * The Developer Knowledge API provides programmatic access to Google's public
   * developer documentation, enabling you to integrate this knowledge base into
   * your own applications and workflows.
   * The API is designed to be the canonical source for machine-readable access to
   * Google's developer documentation.
   * A typical use case is to first use
   * [DeveloperKnowledge.SearchDocumentChunks][google.developers.knowledge.v1.DeveloperKnowledge.SearchDocumentChunks]
   * to find relevant page URIs based on a query, and then use
   * [DeveloperKnowledge.GetDocument][google.developers.knowledge.v1.DeveloperKnowledge.GetDocument]
   * or
   * [DeveloperKnowledge.BatchGetDocuments][google.developers.knowledge.v1.DeveloperKnowledge.BatchGetDocuments]
   * to fetch the full content of the top results.
   * All document content is provided in Markdown format.
   * </pre>
   */
  public static final class DeveloperKnowledgeBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<DeveloperKnowledgeBlockingV2Stub> {
    private DeveloperKnowledgeBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeveloperKnowledgeBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeveloperKnowledgeBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Searches for developer knowledge across Google's developer documentation.
     * Returns [DocumentChunk][google.developers.knowledge.v1.DocumentChunk]s
     * based on the user's query. There may be many chunks from the same
     * [Document][google.developers.knowledge.v1.Document].  To retrieve full
     * documents, use
     * [DeveloperKnowledge.GetDocument][google.developers.knowledge.v1.DeveloperKnowledge.GetDocument]
     * or
     * [DeveloperKnowledge.BatchGetDocuments][google.developers.knowledge.v1.DeveloperKnowledge.BatchGetDocuments]
     * with the
     * [DocumentChunk.parent][google.developers.knowledge.v1.DocumentChunk.parent]
     * returned in the
     * [SearchDocumentChunksResponse.results][google.developers.knowledge.v1.SearchDocumentChunksResponse.results].
     * </pre>
     */
    public com.google.developers.knowledge.v1.SearchDocumentChunksResponse searchDocumentChunks(
        com.google.developers.knowledge.v1.SearchDocumentChunksRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSearchDocumentChunksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a single document with its full Markdown content.
     * </pre>
     */
    public com.google.developers.knowledge.v1.Document getDocument(
        com.google.developers.knowledge.v1.GetDocumentRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetDocumentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves multiple documents, each with its full Markdown content.
     * </pre>
     */
    public com.google.developers.knowledge.v1.BatchGetDocumentsResponse batchGetDocuments(
        com.google.developers.knowledge.v1.BatchGetDocumentsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getBatchGetDocumentsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service DeveloperKnowledge.
   *
   * <pre>
   * The Developer Knowledge API provides programmatic access to Google's public
   * developer documentation, enabling you to integrate this knowledge base into
   * your own applications and workflows.
   * The API is designed to be the canonical source for machine-readable access to
   * Google's developer documentation.
   * A typical use case is to first use
   * [DeveloperKnowledge.SearchDocumentChunks][google.developers.knowledge.v1.DeveloperKnowledge.SearchDocumentChunks]
   * to find relevant page URIs based on a query, and then use
   * [DeveloperKnowledge.GetDocument][google.developers.knowledge.v1.DeveloperKnowledge.GetDocument]
   * or
   * [DeveloperKnowledge.BatchGetDocuments][google.developers.knowledge.v1.DeveloperKnowledge.BatchGetDocuments]
   * to fetch the full content of the top results.
   * All document content is provided in Markdown format.
   * </pre>
   */
  public static final class DeveloperKnowledgeBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DeveloperKnowledgeBlockingStub> {
    private DeveloperKnowledgeBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeveloperKnowledgeBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeveloperKnowledgeBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Searches for developer knowledge across Google's developer documentation.
     * Returns [DocumentChunk][google.developers.knowledge.v1.DocumentChunk]s
     * based on the user's query. There may be many chunks from the same
     * [Document][google.developers.knowledge.v1.Document].  To retrieve full
     * documents, use
     * [DeveloperKnowledge.GetDocument][google.developers.knowledge.v1.DeveloperKnowledge.GetDocument]
     * or
     * [DeveloperKnowledge.BatchGetDocuments][google.developers.knowledge.v1.DeveloperKnowledge.BatchGetDocuments]
     * with the
     * [DocumentChunk.parent][google.developers.knowledge.v1.DocumentChunk.parent]
     * returned in the
     * [SearchDocumentChunksResponse.results][google.developers.knowledge.v1.SearchDocumentChunksResponse.results].
     * </pre>
     */
    public com.google.developers.knowledge.v1.SearchDocumentChunksResponse searchDocumentChunks(
        com.google.developers.knowledge.v1.SearchDocumentChunksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchDocumentChunksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a single document with its full Markdown content.
     * </pre>
     */
    public com.google.developers.knowledge.v1.Document getDocument(
        com.google.developers.knowledge.v1.GetDocumentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDocumentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves multiple documents, each with its full Markdown content.
     * </pre>
     */
    public com.google.developers.knowledge.v1.BatchGetDocumentsResponse batchGetDocuments(
        com.google.developers.knowledge.v1.BatchGetDocumentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchGetDocumentsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DeveloperKnowledge.
   *
   * <pre>
   * The Developer Knowledge API provides programmatic access to Google's public
   * developer documentation, enabling you to integrate this knowledge base into
   * your own applications and workflows.
   * The API is designed to be the canonical source for machine-readable access to
   * Google's developer documentation.
   * A typical use case is to first use
   * [DeveloperKnowledge.SearchDocumentChunks][google.developers.knowledge.v1.DeveloperKnowledge.SearchDocumentChunks]
   * to find relevant page URIs based on a query, and then use
   * [DeveloperKnowledge.GetDocument][google.developers.knowledge.v1.DeveloperKnowledge.GetDocument]
   * or
   * [DeveloperKnowledge.BatchGetDocuments][google.developers.knowledge.v1.DeveloperKnowledge.BatchGetDocuments]
   * to fetch the full content of the top results.
   * All document content is provided in Markdown format.
   * </pre>
   */
  public static final class DeveloperKnowledgeFutureStub
      extends io.grpc.stub.AbstractFutureStub<DeveloperKnowledgeFutureStub> {
    private DeveloperKnowledgeFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeveloperKnowledgeFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeveloperKnowledgeFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Searches for developer knowledge across Google's developer documentation.
     * Returns [DocumentChunk][google.developers.knowledge.v1.DocumentChunk]s
     * based on the user's query. There may be many chunks from the same
     * [Document][google.developers.knowledge.v1.Document].  To retrieve full
     * documents, use
     * [DeveloperKnowledge.GetDocument][google.developers.knowledge.v1.DeveloperKnowledge.GetDocument]
     * or
     * [DeveloperKnowledge.BatchGetDocuments][google.developers.knowledge.v1.DeveloperKnowledge.BatchGetDocuments]
     * with the
     * [DocumentChunk.parent][google.developers.knowledge.v1.DocumentChunk.parent]
     * returned in the
     * [SearchDocumentChunksResponse.results][google.developers.knowledge.v1.SearchDocumentChunksResponse.results].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.developers.knowledge.v1.SearchDocumentChunksResponse>
        searchDocumentChunks(
            com.google.developers.knowledge.v1.SearchDocumentChunksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchDocumentChunksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a single document with its full Markdown content.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.developers.knowledge.v1.Document>
        getDocument(com.google.developers.knowledge.v1.GetDocumentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDocumentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves multiple documents, each with its full Markdown content.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.developers.knowledge.v1.BatchGetDocumentsResponse>
        batchGetDocuments(com.google.developers.knowledge.v1.BatchGetDocumentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchGetDocumentsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEARCH_DOCUMENT_CHUNKS = 0;
  private static final int METHODID_GET_DOCUMENT = 1;
  private static final int METHODID_BATCH_GET_DOCUMENTS = 2;

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
        case METHODID_SEARCH_DOCUMENT_CHUNKS:
          serviceImpl.searchDocumentChunks(
              (com.google.developers.knowledge.v1.SearchDocumentChunksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.developers.knowledge.v1.SearchDocumentChunksResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DOCUMENT:
          serviceImpl.getDocument(
              (com.google.developers.knowledge.v1.GetDocumentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.developers.knowledge.v1.Document>)
                  responseObserver);
          break;
        case METHODID_BATCH_GET_DOCUMENTS:
          serviceImpl.batchGetDocuments(
              (com.google.developers.knowledge.v1.BatchGetDocumentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.developers.knowledge.v1.BatchGetDocumentsResponse>)
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
            getSearchDocumentChunksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.developers.knowledge.v1.SearchDocumentChunksRequest,
                    com.google.developers.knowledge.v1.SearchDocumentChunksResponse>(
                    service, METHODID_SEARCH_DOCUMENT_CHUNKS)))
        .addMethod(
            getGetDocumentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.developers.knowledge.v1.GetDocumentRequest,
                    com.google.developers.knowledge.v1.Document>(service, METHODID_GET_DOCUMENT)))
        .addMethod(
            getBatchGetDocumentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.developers.knowledge.v1.BatchGetDocumentsRequest,
                    com.google.developers.knowledge.v1.BatchGetDocumentsResponse>(
                    service, METHODID_BATCH_GET_DOCUMENTS)))
        .build();
  }

  private abstract static class DeveloperKnowledgeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DeveloperKnowledgeBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.developers.knowledge.v1.DeveloperKnowledgeProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DeveloperKnowledge");
    }
  }

  private static final class DeveloperKnowledgeFileDescriptorSupplier
      extends DeveloperKnowledgeBaseDescriptorSupplier {
    DeveloperKnowledgeFileDescriptorSupplier() {}
  }

  private static final class DeveloperKnowledgeMethodDescriptorSupplier
      extends DeveloperKnowledgeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DeveloperKnowledgeMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DeveloperKnowledgeGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DeveloperKnowledgeFileDescriptorSupplier())
                      .addMethod(getSearchDocumentChunksMethod())
                      .addMethod(getGetDocumentMethod())
                      .addMethod(getBatchGetDocumentsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
