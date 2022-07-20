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
package com.google.cloud.dataplex.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * ContentService manages Notebook and SQL Scripts for Dataplex.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dataplex/v1/content.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ContentServiceGrpc {

  private ContentServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dataplex.v1.ContentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.CreateContentRequest, com.google.cloud.dataplex.v1.Content>
      getCreateContentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateContent",
      requestType = com.google.cloud.dataplex.v1.CreateContentRequest.class,
      responseType = com.google.cloud.dataplex.v1.Content.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.CreateContentRequest, com.google.cloud.dataplex.v1.Content>
      getCreateContentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.CreateContentRequest, com.google.cloud.dataplex.v1.Content>
        getCreateContentMethod;
    if ((getCreateContentMethod = ContentServiceGrpc.getCreateContentMethod) == null) {
      synchronized (ContentServiceGrpc.class) {
        if ((getCreateContentMethod = ContentServiceGrpc.getCreateContentMethod) == null) {
          ContentServiceGrpc.getCreateContentMethod =
              getCreateContentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.CreateContentRequest,
                          com.google.cloud.dataplex.v1.Content>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateContent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.CreateContentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.Content.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContentServiceMethodDescriptorSupplier("CreateContent"))
                      .build();
        }
      }
    }
    return getCreateContentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.UpdateContentRequest, com.google.cloud.dataplex.v1.Content>
      getUpdateContentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateContent",
      requestType = com.google.cloud.dataplex.v1.UpdateContentRequest.class,
      responseType = com.google.cloud.dataplex.v1.Content.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.UpdateContentRequest, com.google.cloud.dataplex.v1.Content>
      getUpdateContentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.UpdateContentRequest, com.google.cloud.dataplex.v1.Content>
        getUpdateContentMethod;
    if ((getUpdateContentMethod = ContentServiceGrpc.getUpdateContentMethod) == null) {
      synchronized (ContentServiceGrpc.class) {
        if ((getUpdateContentMethod = ContentServiceGrpc.getUpdateContentMethod) == null) {
          ContentServiceGrpc.getUpdateContentMethod =
              getUpdateContentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.UpdateContentRequest,
                          com.google.cloud.dataplex.v1.Content>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateContent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.UpdateContentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.Content.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContentServiceMethodDescriptorSupplier("UpdateContent"))
                      .build();
        }
      }
    }
    return getUpdateContentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.DeleteContentRequest, com.google.protobuf.Empty>
      getDeleteContentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteContent",
      requestType = com.google.cloud.dataplex.v1.DeleteContentRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.DeleteContentRequest, com.google.protobuf.Empty>
      getDeleteContentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.DeleteContentRequest, com.google.protobuf.Empty>
        getDeleteContentMethod;
    if ((getDeleteContentMethod = ContentServiceGrpc.getDeleteContentMethod) == null) {
      synchronized (ContentServiceGrpc.class) {
        if ((getDeleteContentMethod = ContentServiceGrpc.getDeleteContentMethod) == null) {
          ContentServiceGrpc.getDeleteContentMethod =
              getDeleteContentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.DeleteContentRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteContent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.DeleteContentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContentServiceMethodDescriptorSupplier("DeleteContent"))
                      .build();
        }
      }
    }
    return getDeleteContentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.GetContentRequest, com.google.cloud.dataplex.v1.Content>
      getGetContentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetContent",
      requestType = com.google.cloud.dataplex.v1.GetContentRequest.class,
      responseType = com.google.cloud.dataplex.v1.Content.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.GetContentRequest, com.google.cloud.dataplex.v1.Content>
      getGetContentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.GetContentRequest, com.google.cloud.dataplex.v1.Content>
        getGetContentMethod;
    if ((getGetContentMethod = ContentServiceGrpc.getGetContentMethod) == null) {
      synchronized (ContentServiceGrpc.class) {
        if ((getGetContentMethod = ContentServiceGrpc.getGetContentMethod) == null) {
          ContentServiceGrpc.getGetContentMethod =
              getGetContentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.GetContentRequest,
                          com.google.cloud.dataplex.v1.Content>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetContent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.GetContentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.Content.getDefaultInstance()))
                      .setSchemaDescriptor(new ContentServiceMethodDescriptorSupplier("GetContent"))
                      .build();
        }
      }
    }
    return getGetContentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.ListContentRequest,
          com.google.cloud.dataplex.v1.ListContentResponse>
      getListContentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListContent",
      requestType = com.google.cloud.dataplex.v1.ListContentRequest.class,
      responseType = com.google.cloud.dataplex.v1.ListContentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.ListContentRequest,
          com.google.cloud.dataplex.v1.ListContentResponse>
      getListContentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.ListContentRequest,
            com.google.cloud.dataplex.v1.ListContentResponse>
        getListContentMethod;
    if ((getListContentMethod = ContentServiceGrpc.getListContentMethod) == null) {
      synchronized (ContentServiceGrpc.class) {
        if ((getListContentMethod = ContentServiceGrpc.getListContentMethod) == null) {
          ContentServiceGrpc.getListContentMethod =
              getListContentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.ListContentRequest,
                          com.google.cloud.dataplex.v1.ListContentResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListContent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.ListContentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.ListContentResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContentServiceMethodDescriptorSupplier("ListContent"))
                      .build();
        }
      }
    }
    return getListContentMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ContentServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContentServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ContentServiceStub>() {
          @java.lang.Override
          public ContentServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ContentServiceStub(channel, callOptions);
          }
        };
    return ContentServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ContentServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContentServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ContentServiceBlockingStub>() {
          @java.lang.Override
          public ContentServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ContentServiceBlockingStub(channel, callOptions);
          }
        };
    return ContentServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ContentServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContentServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ContentServiceFutureStub>() {
          @java.lang.Override
          public ContentServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ContentServiceFutureStub(channel, callOptions);
          }
        };
    return ContentServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * ContentService manages Notebook and SQL Scripts for Dataplex.
   * </pre>
   */
  public abstract static class ContentServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Create a content.
     * </pre>
     */
    public void createContent(
        com.google.cloud.dataplex.v1.CreateContentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Content> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateContentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a content. Only supports full resource update.
     * </pre>
     */
    public void updateContent(
        com.google.cloud.dataplex.v1.UpdateContentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Content> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateContentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a content.
     * </pre>
     */
    public void deleteContent(
        com.google.cloud.dataplex.v1.DeleteContentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteContentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a content resource.
     * </pre>
     */
    public void getContent(
        com.google.cloud.dataplex.v1.GetContentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Content> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetContentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List content.
     * </pre>
     */
    public void listContent(
        com.google.cloud.dataplex.v1.ListContentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListContentResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListContentMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateContentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataplex.v1.CreateContentRequest,
                      com.google.cloud.dataplex.v1.Content>(this, METHODID_CREATE_CONTENT)))
          .addMethod(
              getUpdateContentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataplex.v1.UpdateContentRequest,
                      com.google.cloud.dataplex.v1.Content>(this, METHODID_UPDATE_CONTENT)))
          .addMethod(
              getDeleteContentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataplex.v1.DeleteContentRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_CONTENT)))
          .addMethod(
              getGetContentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataplex.v1.GetContentRequest,
                      com.google.cloud.dataplex.v1.Content>(this, METHODID_GET_CONTENT)))
          .addMethod(
              getListContentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataplex.v1.ListContentRequest,
                      com.google.cloud.dataplex.v1.ListContentResponse>(
                      this, METHODID_LIST_CONTENT)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * ContentService manages Notebook and SQL Scripts for Dataplex.
   * </pre>
   */
  public static final class ContentServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ContentServiceStub> {
    private ContentServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContentServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContentServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a content.
     * </pre>
     */
    public void createContent(
        com.google.cloud.dataplex.v1.CreateContentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Content> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateContentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a content. Only supports full resource update.
     * </pre>
     */
    public void updateContent(
        com.google.cloud.dataplex.v1.UpdateContentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Content> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateContentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a content.
     * </pre>
     */
    public void deleteContent(
        com.google.cloud.dataplex.v1.DeleteContentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteContentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a content resource.
     * </pre>
     */
    public void getContent(
        com.google.cloud.dataplex.v1.GetContentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Content> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetContentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List content.
     * </pre>
     */
    public void listContent(
        com.google.cloud.dataplex.v1.ListContentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListContentResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListContentMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * ContentService manages Notebook and SQL Scripts for Dataplex.
   * </pre>
   */
  public static final class ContentServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ContentServiceBlockingStub> {
    private ContentServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContentServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContentServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a content.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.Content createContent(
        com.google.cloud.dataplex.v1.CreateContentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateContentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a content. Only supports full resource update.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.Content updateContent(
        com.google.cloud.dataplex.v1.UpdateContentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateContentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a content.
     * </pre>
     */
    public com.google.protobuf.Empty deleteContent(
        com.google.cloud.dataplex.v1.DeleteContentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteContentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a content resource.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.Content getContent(
        com.google.cloud.dataplex.v1.GetContentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetContentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List content.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListContentResponse listContent(
        com.google.cloud.dataplex.v1.ListContentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListContentMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * ContentService manages Notebook and SQL Scripts for Dataplex.
   * </pre>
   */
  public static final class ContentServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ContentServiceFutureStub> {
    private ContentServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContentServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContentServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a content.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.Content>
        createContent(com.google.cloud.dataplex.v1.CreateContentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateContentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a content. Only supports full resource update.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.Content>
        updateContent(com.google.cloud.dataplex.v1.UpdateContentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateContentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a content.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteContent(com.google.cloud.dataplex.v1.DeleteContentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteContentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get a content resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.Content>
        getContent(com.google.cloud.dataplex.v1.GetContentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetContentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List content.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataplex.v1.ListContentResponse>
        listContent(com.google.cloud.dataplex.v1.ListContentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListContentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_CONTENT = 0;
  private static final int METHODID_UPDATE_CONTENT = 1;
  private static final int METHODID_DELETE_CONTENT = 2;
  private static final int METHODID_GET_CONTENT = 3;
  private static final int METHODID_LIST_CONTENT = 4;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ContentServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ContentServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_CONTENT:
          serviceImpl.createContent(
              (com.google.cloud.dataplex.v1.CreateContentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Content>) responseObserver);
          break;
        case METHODID_UPDATE_CONTENT:
          serviceImpl.updateContent(
              (com.google.cloud.dataplex.v1.UpdateContentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Content>) responseObserver);
          break;
        case METHODID_DELETE_CONTENT:
          serviceImpl.deleteContent(
              (com.google.cloud.dataplex.v1.DeleteContentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_CONTENT:
          serviceImpl.getContent(
              (com.google.cloud.dataplex.v1.GetContentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Content>) responseObserver);
          break;
        case METHODID_LIST_CONTENT:
          serviceImpl.listContent(
              (com.google.cloud.dataplex.v1.ListContentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListContentResponse>)
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

  private abstract static class ContentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ContentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dataplex.v1.ContentProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ContentService");
    }
  }

  private static final class ContentServiceFileDescriptorSupplier
      extends ContentServiceBaseDescriptorSupplier {
    ContentServiceFileDescriptorSupplier() {}
  }

  private static final class ContentServiceMethodDescriptorSupplier
      extends ContentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ContentServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ContentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ContentServiceFileDescriptorSupplier())
                      .addMethod(getCreateContentMethod())
                      .addMethod(getUpdateContentMethod())
                      .addMethod(getDeleteContentMethod())
                      .addMethod(getGetContentMethod())
                      .addMethod(getListContentMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
