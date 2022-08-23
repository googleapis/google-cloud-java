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
package com.google.cloud.dialogflow.cx.v3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing [Pages][google.cloud.dialogflow.cx.v3.Page].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/cx/v3/page.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PagesGrpc {

  private PagesGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dialogflow.cx.v3.Pages";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.ListPagesRequest,
          com.google.cloud.dialogflow.cx.v3.ListPagesResponse>
      getListPagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPages",
      requestType = com.google.cloud.dialogflow.cx.v3.ListPagesRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.ListPagesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.ListPagesRequest,
          com.google.cloud.dialogflow.cx.v3.ListPagesResponse>
      getListPagesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.ListPagesRequest,
            com.google.cloud.dialogflow.cx.v3.ListPagesResponse>
        getListPagesMethod;
    if ((getListPagesMethod = PagesGrpc.getListPagesMethod) == null) {
      synchronized (PagesGrpc.class) {
        if ((getListPagesMethod = PagesGrpc.getListPagesMethod) == null) {
          PagesGrpc.getListPagesMethod =
              getListPagesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.ListPagesRequest,
                          com.google.cloud.dialogflow.cx.v3.ListPagesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPages"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.ListPagesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.ListPagesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new PagesMethodDescriptorSupplier("ListPages"))
                      .build();
        }
      }
    }
    return getListPagesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.GetPageRequest, com.google.cloud.dialogflow.cx.v3.Page>
      getGetPageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPage",
      requestType = com.google.cloud.dialogflow.cx.v3.GetPageRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.Page.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.GetPageRequest, com.google.cloud.dialogflow.cx.v3.Page>
      getGetPageMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.GetPageRequest,
            com.google.cloud.dialogflow.cx.v3.Page>
        getGetPageMethod;
    if ((getGetPageMethod = PagesGrpc.getGetPageMethod) == null) {
      synchronized (PagesGrpc.class) {
        if ((getGetPageMethod = PagesGrpc.getGetPageMethod) == null) {
          PagesGrpc.getGetPageMethod =
              getGetPageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.GetPageRequest,
                          com.google.cloud.dialogflow.cx.v3.Page>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.GetPageRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.Page.getDefaultInstance()))
                      .setSchemaDescriptor(new PagesMethodDescriptorSupplier("GetPage"))
                      .build();
        }
      }
    }
    return getGetPageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.CreatePageRequest,
          com.google.cloud.dialogflow.cx.v3.Page>
      getCreatePageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePage",
      requestType = com.google.cloud.dialogflow.cx.v3.CreatePageRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.Page.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.CreatePageRequest,
          com.google.cloud.dialogflow.cx.v3.Page>
      getCreatePageMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.CreatePageRequest,
            com.google.cloud.dialogflow.cx.v3.Page>
        getCreatePageMethod;
    if ((getCreatePageMethod = PagesGrpc.getCreatePageMethod) == null) {
      synchronized (PagesGrpc.class) {
        if ((getCreatePageMethod = PagesGrpc.getCreatePageMethod) == null) {
          PagesGrpc.getCreatePageMethod =
              getCreatePageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.CreatePageRequest,
                          com.google.cloud.dialogflow.cx.v3.Page>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.CreatePageRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.Page.getDefaultInstance()))
                      .setSchemaDescriptor(new PagesMethodDescriptorSupplier("CreatePage"))
                      .build();
        }
      }
    }
    return getCreatePageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.UpdatePageRequest,
          com.google.cloud.dialogflow.cx.v3.Page>
      getUpdatePageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePage",
      requestType = com.google.cloud.dialogflow.cx.v3.UpdatePageRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.Page.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.UpdatePageRequest,
          com.google.cloud.dialogflow.cx.v3.Page>
      getUpdatePageMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.UpdatePageRequest,
            com.google.cloud.dialogflow.cx.v3.Page>
        getUpdatePageMethod;
    if ((getUpdatePageMethod = PagesGrpc.getUpdatePageMethod) == null) {
      synchronized (PagesGrpc.class) {
        if ((getUpdatePageMethod = PagesGrpc.getUpdatePageMethod) == null) {
          PagesGrpc.getUpdatePageMethod =
              getUpdatePageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.UpdatePageRequest,
                          com.google.cloud.dialogflow.cx.v3.Page>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdatePage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.UpdatePageRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.Page.getDefaultInstance()))
                      .setSchemaDescriptor(new PagesMethodDescriptorSupplier("UpdatePage"))
                      .build();
        }
      }
    }
    return getUpdatePageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.DeletePageRequest, com.google.protobuf.Empty>
      getDeletePageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePage",
      requestType = com.google.cloud.dialogflow.cx.v3.DeletePageRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.DeletePageRequest, com.google.protobuf.Empty>
      getDeletePageMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.DeletePageRequest, com.google.protobuf.Empty>
        getDeletePageMethod;
    if ((getDeletePageMethod = PagesGrpc.getDeletePageMethod) == null) {
      synchronized (PagesGrpc.class) {
        if ((getDeletePageMethod = PagesGrpc.getDeletePageMethod) == null) {
          PagesGrpc.getDeletePageMethod =
              getDeletePageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.DeletePageRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeletePage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.DeletePageRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new PagesMethodDescriptorSupplier("DeletePage"))
                      .build();
        }
      }
    }
    return getDeletePageMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static PagesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PagesStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PagesStub>() {
          @java.lang.Override
          public PagesStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PagesStub(channel, callOptions);
          }
        };
    return PagesStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PagesBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PagesBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PagesBlockingStub>() {
          @java.lang.Override
          public PagesBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PagesBlockingStub(channel, callOptions);
          }
        };
    return PagesBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static PagesFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PagesFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PagesFutureStub>() {
          @java.lang.Override
          public PagesFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PagesFutureStub(channel, callOptions);
          }
        };
    return PagesFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Pages][google.cloud.dialogflow.cx.v3.Page].
   * </pre>
   */
  public abstract static class PagesImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Returns the list of all pages in the specified flow.
     * </pre>
     */
    public void listPages(
        com.google.cloud.dialogflow.cx.v3.ListPagesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.ListPagesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListPagesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified page.
     * </pre>
     */
    public void getPage(
        com.google.cloud.dialogflow.cx.v3.GetPageRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Page> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPageMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a page in the specified flow.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public void createPage(
        com.google.cloud.dialogflow.cx.v3.CreatePageRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Page> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreatePageMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified page.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public void updatePage(
        com.google.cloud.dialogflow.cx.v3.UpdatePageRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Page> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdatePageMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified page.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public void deletePage(
        com.google.cloud.dialogflow.cx.v3.DeletePageRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeletePageMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListPagesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3.ListPagesRequest,
                      com.google.cloud.dialogflow.cx.v3.ListPagesResponse>(
                      this, METHODID_LIST_PAGES)))
          .addMethod(
              getGetPageMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3.GetPageRequest,
                      com.google.cloud.dialogflow.cx.v3.Page>(this, METHODID_GET_PAGE)))
          .addMethod(
              getCreatePageMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3.CreatePageRequest,
                      com.google.cloud.dialogflow.cx.v3.Page>(this, METHODID_CREATE_PAGE)))
          .addMethod(
              getUpdatePageMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3.UpdatePageRequest,
                      com.google.cloud.dialogflow.cx.v3.Page>(this, METHODID_UPDATE_PAGE)))
          .addMethod(
              getDeletePageMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3.DeletePageRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_PAGE)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Pages][google.cloud.dialogflow.cx.v3.Page].
   * </pre>
   */
  public static final class PagesStub extends io.grpc.stub.AbstractAsyncStub<PagesStub> {
    private PagesStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PagesStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PagesStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all pages in the specified flow.
     * </pre>
     */
    public void listPages(
        com.google.cloud.dialogflow.cx.v3.ListPagesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.ListPagesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPagesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified page.
     * </pre>
     */
    public void getPage(
        com.google.cloud.dialogflow.cx.v3.GetPageRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Page> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a page in the specified flow.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public void createPage(
        com.google.cloud.dialogflow.cx.v3.CreatePageRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Page> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified page.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public void updatePage(
        com.google.cloud.dialogflow.cx.v3.UpdatePageRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Page> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified page.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public void deletePage(
        com.google.cloud.dialogflow.cx.v3.DeletePageRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Pages][google.cloud.dialogflow.cx.v3.Page].
   * </pre>
   */
  public static final class PagesBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PagesBlockingStub> {
    private PagesBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PagesBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PagesBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all pages in the specified flow.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.ListPagesResponse listPages(
        com.google.cloud.dialogflow.cx.v3.ListPagesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPagesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified page.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.Page getPage(
        com.google.cloud.dialogflow.cx.v3.GetPageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a page in the specified flow.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.Page createPage(
        com.google.cloud.dialogflow.cx.v3.CreatePageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified page.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.Page updatePage(
        com.google.cloud.dialogflow.cx.v3.UpdatePageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified page.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public com.google.protobuf.Empty deletePage(
        com.google.cloud.dialogflow.cx.v3.DeletePageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePageMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Pages][google.cloud.dialogflow.cx.v3.Page].
   * </pre>
   */
  public static final class PagesFutureStub
      extends io.grpc.stub.AbstractFutureStub<PagesFutureStub> {
    private PagesFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PagesFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PagesFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all pages in the specified flow.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3.ListPagesResponse>
        listPages(com.google.cloud.dialogflow.cx.v3.ListPagesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPagesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified page.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3.Page>
        getPage(com.google.cloud.dialogflow.cx.v3.GetPageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPageMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a page in the specified flow.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3.Page>
        createPage(com.google.cloud.dialogflow.cx.v3.CreatePageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePageMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified page.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3.Page>
        updatePage(com.google.cloud.dialogflow.cx.v3.UpdatePageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePageMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified page.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deletePage(
        com.google.cloud.dialogflow.cx.v3.DeletePageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_PAGES = 0;
  private static final int METHODID_GET_PAGE = 1;
  private static final int METHODID_CREATE_PAGE = 2;
  private static final int METHODID_UPDATE_PAGE = 3;
  private static final int METHODID_DELETE_PAGE = 4;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PagesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PagesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_PAGES:
          serviceImpl.listPages(
              (com.google.cloud.dialogflow.cx.v3.ListPagesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.ListPagesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PAGE:
          serviceImpl.getPage(
              (com.google.cloud.dialogflow.cx.v3.GetPageRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Page>)
                  responseObserver);
          break;
        case METHODID_CREATE_PAGE:
          serviceImpl.createPage(
              (com.google.cloud.dialogflow.cx.v3.CreatePageRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Page>)
                  responseObserver);
          break;
        case METHODID_UPDATE_PAGE:
          serviceImpl.updatePage(
              (com.google.cloud.dialogflow.cx.v3.UpdatePageRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Page>)
                  responseObserver);
          break;
        case METHODID_DELETE_PAGE:
          serviceImpl.deletePage(
              (com.google.cloud.dialogflow.cx.v3.DeletePageRequest) request,
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

  private abstract static class PagesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PagesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.cx.v3.PageProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Pages");
    }
  }

  private static final class PagesFileDescriptorSupplier extends PagesBaseDescriptorSupplier {
    PagesFileDescriptorSupplier() {}
  }

  private static final class PagesMethodDescriptorSupplier extends PagesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PagesMethodDescriptorSupplier(String methodName) {
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
      synchronized (PagesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new PagesFileDescriptorSupplier())
                      .addMethod(getListPagesMethod())
                      .addMethod(getGetPageMethod())
                      .addMethod(getCreatePageMethod())
                      .addMethod(getUpdatePageMethod())
                      .addMethod(getDeletePageMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
