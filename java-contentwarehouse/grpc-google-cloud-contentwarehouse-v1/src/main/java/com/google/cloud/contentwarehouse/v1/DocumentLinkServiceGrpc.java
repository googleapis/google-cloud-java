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
 * This service lets you manage document-links.
 * Document-Links are treated as sub-resources under source documents.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/contentwarehouse/v1/document_link_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DocumentLinkServiceGrpc {

  private DocumentLinkServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.contentwarehouse.v1.DocumentLinkService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.ListLinkedTargetsRequest,
          com.google.cloud.contentwarehouse.v1.ListLinkedTargetsResponse>
      getListLinkedTargetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListLinkedTargets",
      requestType = com.google.cloud.contentwarehouse.v1.ListLinkedTargetsRequest.class,
      responseType = com.google.cloud.contentwarehouse.v1.ListLinkedTargetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.ListLinkedTargetsRequest,
          com.google.cloud.contentwarehouse.v1.ListLinkedTargetsResponse>
      getListLinkedTargetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contentwarehouse.v1.ListLinkedTargetsRequest,
            com.google.cloud.contentwarehouse.v1.ListLinkedTargetsResponse>
        getListLinkedTargetsMethod;
    if ((getListLinkedTargetsMethod = DocumentLinkServiceGrpc.getListLinkedTargetsMethod) == null) {
      synchronized (DocumentLinkServiceGrpc.class) {
        if ((getListLinkedTargetsMethod = DocumentLinkServiceGrpc.getListLinkedTargetsMethod)
            == null) {
          DocumentLinkServiceGrpc.getListLinkedTargetsMethod =
              getListLinkedTargetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contentwarehouse.v1.ListLinkedTargetsRequest,
                          com.google.cloud.contentwarehouse.v1.ListLinkedTargetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListLinkedTargets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.ListLinkedTargetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.ListLinkedTargetsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentLinkServiceMethodDescriptorSupplier("ListLinkedTargets"))
                      .build();
        }
      }
    }
    return getListLinkedTargetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.ListLinkedSourcesRequest,
          com.google.cloud.contentwarehouse.v1.ListLinkedSourcesResponse>
      getListLinkedSourcesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListLinkedSources",
      requestType = com.google.cloud.contentwarehouse.v1.ListLinkedSourcesRequest.class,
      responseType = com.google.cloud.contentwarehouse.v1.ListLinkedSourcesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.ListLinkedSourcesRequest,
          com.google.cloud.contentwarehouse.v1.ListLinkedSourcesResponse>
      getListLinkedSourcesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contentwarehouse.v1.ListLinkedSourcesRequest,
            com.google.cloud.contentwarehouse.v1.ListLinkedSourcesResponse>
        getListLinkedSourcesMethod;
    if ((getListLinkedSourcesMethod = DocumentLinkServiceGrpc.getListLinkedSourcesMethod) == null) {
      synchronized (DocumentLinkServiceGrpc.class) {
        if ((getListLinkedSourcesMethod = DocumentLinkServiceGrpc.getListLinkedSourcesMethod)
            == null) {
          DocumentLinkServiceGrpc.getListLinkedSourcesMethod =
              getListLinkedSourcesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contentwarehouse.v1.ListLinkedSourcesRequest,
                          com.google.cloud.contentwarehouse.v1.ListLinkedSourcesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListLinkedSources"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.ListLinkedSourcesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.ListLinkedSourcesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentLinkServiceMethodDescriptorSupplier("ListLinkedSources"))
                      .build();
        }
      }
    }
    return getListLinkedSourcesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.CreateDocumentLinkRequest,
          com.google.cloud.contentwarehouse.v1.DocumentLink>
      getCreateDocumentLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDocumentLink",
      requestType = com.google.cloud.contentwarehouse.v1.CreateDocumentLinkRequest.class,
      responseType = com.google.cloud.contentwarehouse.v1.DocumentLink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.CreateDocumentLinkRequest,
          com.google.cloud.contentwarehouse.v1.DocumentLink>
      getCreateDocumentLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contentwarehouse.v1.CreateDocumentLinkRequest,
            com.google.cloud.contentwarehouse.v1.DocumentLink>
        getCreateDocumentLinkMethod;
    if ((getCreateDocumentLinkMethod = DocumentLinkServiceGrpc.getCreateDocumentLinkMethod)
        == null) {
      synchronized (DocumentLinkServiceGrpc.class) {
        if ((getCreateDocumentLinkMethod = DocumentLinkServiceGrpc.getCreateDocumentLinkMethod)
            == null) {
          DocumentLinkServiceGrpc.getCreateDocumentLinkMethod =
              getCreateDocumentLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contentwarehouse.v1.CreateDocumentLinkRequest,
                          com.google.cloud.contentwarehouse.v1.DocumentLink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDocumentLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.CreateDocumentLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.DocumentLink
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentLinkServiceMethodDescriptorSupplier("CreateDocumentLink"))
                      .build();
        }
      }
    }
    return getCreateDocumentLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.DeleteDocumentLinkRequest, com.google.protobuf.Empty>
      getDeleteDocumentLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDocumentLink",
      requestType = com.google.cloud.contentwarehouse.v1.DeleteDocumentLinkRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.DeleteDocumentLinkRequest, com.google.protobuf.Empty>
      getDeleteDocumentLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contentwarehouse.v1.DeleteDocumentLinkRequest,
            com.google.protobuf.Empty>
        getDeleteDocumentLinkMethod;
    if ((getDeleteDocumentLinkMethod = DocumentLinkServiceGrpc.getDeleteDocumentLinkMethod)
        == null) {
      synchronized (DocumentLinkServiceGrpc.class) {
        if ((getDeleteDocumentLinkMethod = DocumentLinkServiceGrpc.getDeleteDocumentLinkMethod)
            == null) {
          DocumentLinkServiceGrpc.getDeleteDocumentLinkMethod =
              getDeleteDocumentLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contentwarehouse.v1.DeleteDocumentLinkRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDocumentLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.DeleteDocumentLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentLinkServiceMethodDescriptorSupplier("DeleteDocumentLink"))
                      .build();
        }
      }
    }
    return getDeleteDocumentLinkMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DocumentLinkServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DocumentLinkServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DocumentLinkServiceStub>() {
          @java.lang.Override
          public DocumentLinkServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DocumentLinkServiceStub(channel, callOptions);
          }
        };
    return DocumentLinkServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DocumentLinkServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DocumentLinkServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DocumentLinkServiceBlockingStub>() {
          @java.lang.Override
          public DocumentLinkServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DocumentLinkServiceBlockingStub(channel, callOptions);
          }
        };
    return DocumentLinkServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DocumentLinkServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DocumentLinkServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DocumentLinkServiceFutureStub>() {
          @java.lang.Override
          public DocumentLinkServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DocumentLinkServiceFutureStub(channel, callOptions);
          }
        };
    return DocumentLinkServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * This service lets you manage document-links.
   * Document-Links are treated as sub-resources under source documents.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Return all target document-links from the document.
     * </pre>
     */
    default void listLinkedTargets(
        com.google.cloud.contentwarehouse.v1.ListLinkedTargetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.ListLinkedTargetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListLinkedTargetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Return all source document-links from the document.
     * </pre>
     */
    default void listLinkedSources(
        com.google.cloud.contentwarehouse.v1.ListLinkedSourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.ListLinkedSourcesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListLinkedSourcesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a link between a source document and a target document.
     * </pre>
     */
    default void createDocumentLink(
        com.google.cloud.contentwarehouse.v1.CreateDocumentLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.DocumentLink>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDocumentLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Remove the link between the source and target documents.
     * </pre>
     */
    default void deleteDocumentLink(
        com.google.cloud.contentwarehouse.v1.DeleteDocumentLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDocumentLinkMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DocumentLinkService.
   *
   * <pre>
   * This service lets you manage document-links.
   * Document-Links are treated as sub-resources under source documents.
   * </pre>
   */
  public abstract static class DocumentLinkServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DocumentLinkServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DocumentLinkService.
   *
   * <pre>
   * This service lets you manage document-links.
   * Document-Links are treated as sub-resources under source documents.
   * </pre>
   */
  public static final class DocumentLinkServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DocumentLinkServiceStub> {
    private DocumentLinkServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DocumentLinkServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DocumentLinkServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Return all target document-links from the document.
     * </pre>
     */
    public void listLinkedTargets(
        com.google.cloud.contentwarehouse.v1.ListLinkedTargetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.ListLinkedTargetsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListLinkedTargetsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Return all source document-links from the document.
     * </pre>
     */
    public void listLinkedSources(
        com.google.cloud.contentwarehouse.v1.ListLinkedSourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.ListLinkedSourcesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListLinkedSourcesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a link between a source document and a target document.
     * </pre>
     */
    public void createDocumentLink(
        com.google.cloud.contentwarehouse.v1.CreateDocumentLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.DocumentLink>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDocumentLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Remove the link between the source and target documents.
     * </pre>
     */
    public void deleteDocumentLink(
        com.google.cloud.contentwarehouse.v1.DeleteDocumentLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDocumentLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DocumentLinkService.
   *
   * <pre>
   * This service lets you manage document-links.
   * Document-Links are treated as sub-resources under source documents.
   * </pre>
   */
  public static final class DocumentLinkServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DocumentLinkServiceBlockingStub> {
    private DocumentLinkServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DocumentLinkServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DocumentLinkServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Return all target document-links from the document.
     * </pre>
     */
    public com.google.cloud.contentwarehouse.v1.ListLinkedTargetsResponse listLinkedTargets(
        com.google.cloud.contentwarehouse.v1.ListLinkedTargetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListLinkedTargetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Return all source document-links from the document.
     * </pre>
     */
    public com.google.cloud.contentwarehouse.v1.ListLinkedSourcesResponse listLinkedSources(
        com.google.cloud.contentwarehouse.v1.ListLinkedSourcesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListLinkedSourcesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a link between a source document and a target document.
     * </pre>
     */
    public com.google.cloud.contentwarehouse.v1.DocumentLink createDocumentLink(
        com.google.cloud.contentwarehouse.v1.CreateDocumentLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDocumentLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Remove the link between the source and target documents.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDocumentLink(
        com.google.cloud.contentwarehouse.v1.DeleteDocumentLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDocumentLinkMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DocumentLinkService.
   *
   * <pre>
   * This service lets you manage document-links.
   * Document-Links are treated as sub-resources under source documents.
   * </pre>
   */
  public static final class DocumentLinkServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DocumentLinkServiceFutureStub> {
    private DocumentLinkServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DocumentLinkServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DocumentLinkServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Return all target document-links from the document.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contentwarehouse.v1.ListLinkedTargetsResponse>
        listLinkedTargets(com.google.cloud.contentwarehouse.v1.ListLinkedTargetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListLinkedTargetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Return all source document-links from the document.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contentwarehouse.v1.ListLinkedSourcesResponse>
        listLinkedSources(com.google.cloud.contentwarehouse.v1.ListLinkedSourcesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListLinkedSourcesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a link between a source document and a target document.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contentwarehouse.v1.DocumentLink>
        createDocumentLink(com.google.cloud.contentwarehouse.v1.CreateDocumentLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDocumentLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Remove the link between the source and target documents.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteDocumentLink(com.google.cloud.contentwarehouse.v1.DeleteDocumentLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDocumentLinkMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_LINKED_TARGETS = 0;
  private static final int METHODID_LIST_LINKED_SOURCES = 1;
  private static final int METHODID_CREATE_DOCUMENT_LINK = 2;
  private static final int METHODID_DELETE_DOCUMENT_LINK = 3;

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
        case METHODID_LIST_LINKED_TARGETS:
          serviceImpl.listLinkedTargets(
              (com.google.cloud.contentwarehouse.v1.ListLinkedTargetsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.contentwarehouse.v1.ListLinkedTargetsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_LINKED_SOURCES:
          serviceImpl.listLinkedSources(
              (com.google.cloud.contentwarehouse.v1.ListLinkedSourcesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.contentwarehouse.v1.ListLinkedSourcesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_DOCUMENT_LINK:
          serviceImpl.createDocumentLink(
              (com.google.cloud.contentwarehouse.v1.CreateDocumentLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.DocumentLink>)
                  responseObserver);
          break;
        case METHODID_DELETE_DOCUMENT_LINK:
          serviceImpl.deleteDocumentLink(
              (com.google.cloud.contentwarehouse.v1.DeleteDocumentLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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
            getListLinkedTargetsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contentwarehouse.v1.ListLinkedTargetsRequest,
                    com.google.cloud.contentwarehouse.v1.ListLinkedTargetsResponse>(
                    service, METHODID_LIST_LINKED_TARGETS)))
        .addMethod(
            getListLinkedSourcesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contentwarehouse.v1.ListLinkedSourcesRequest,
                    com.google.cloud.contentwarehouse.v1.ListLinkedSourcesResponse>(
                    service, METHODID_LIST_LINKED_SOURCES)))
        .addMethod(
            getCreateDocumentLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contentwarehouse.v1.CreateDocumentLinkRequest,
                    com.google.cloud.contentwarehouse.v1.DocumentLink>(
                    service, METHODID_CREATE_DOCUMENT_LINK)))
        .addMethod(
            getDeleteDocumentLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contentwarehouse.v1.DeleteDocumentLinkRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_DOCUMENT_LINK)))
        .build();
  }

  private abstract static class DocumentLinkServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DocumentLinkServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.contentwarehouse.v1.DocumentLinkServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DocumentLinkService");
    }
  }

  private static final class DocumentLinkServiceFileDescriptorSupplier
      extends DocumentLinkServiceBaseDescriptorSupplier {
    DocumentLinkServiceFileDescriptorSupplier() {}
  }

  private static final class DocumentLinkServiceMethodDescriptorSupplier
      extends DocumentLinkServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DocumentLinkServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DocumentLinkServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DocumentLinkServiceFileDescriptorSupplier())
                      .addMethod(getListLinkedTargetsMethod())
                      .addMethod(getListLinkedSourcesMethod())
                      .addMethod(getCreateDocumentLinkMethod())
                      .addMethod(getDeleteDocumentLinkMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
