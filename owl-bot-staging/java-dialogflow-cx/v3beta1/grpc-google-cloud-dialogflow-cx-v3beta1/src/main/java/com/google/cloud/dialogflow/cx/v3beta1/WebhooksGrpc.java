package com.google.cloud.dialogflow.cx.v3beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Service for managing [Webhooks][google.cloud.dialogflow.cx.v3beta1.Webhook].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/cx/v3beta1/webhook.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class WebhooksGrpc {

  private WebhooksGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dialogflow.cx.v3beta1.Webhooks";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.ListWebhooksRequest,
      com.google.cloud.dialogflow.cx.v3beta1.ListWebhooksResponse> getListWebhooksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListWebhooks",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.ListWebhooksRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.ListWebhooksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.ListWebhooksRequest,
      com.google.cloud.dialogflow.cx.v3beta1.ListWebhooksResponse> getListWebhooksMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.ListWebhooksRequest, com.google.cloud.dialogflow.cx.v3beta1.ListWebhooksResponse> getListWebhooksMethod;
    if ((getListWebhooksMethod = WebhooksGrpc.getListWebhooksMethod) == null) {
      synchronized (WebhooksGrpc.class) {
        if ((getListWebhooksMethod = WebhooksGrpc.getListWebhooksMethod) == null) {
          WebhooksGrpc.getListWebhooksMethod = getListWebhooksMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3beta1.ListWebhooksRequest, com.google.cloud.dialogflow.cx.v3beta1.ListWebhooksResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListWebhooks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.ListWebhooksRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.ListWebhooksResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WebhooksMethodDescriptorSupplier("ListWebhooks"))
              .build();
        }
      }
    }
    return getListWebhooksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.GetWebhookRequest,
      com.google.cloud.dialogflow.cx.v3beta1.Webhook> getGetWebhookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetWebhook",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.GetWebhookRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.Webhook.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.GetWebhookRequest,
      com.google.cloud.dialogflow.cx.v3beta1.Webhook> getGetWebhookMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.GetWebhookRequest, com.google.cloud.dialogflow.cx.v3beta1.Webhook> getGetWebhookMethod;
    if ((getGetWebhookMethod = WebhooksGrpc.getGetWebhookMethod) == null) {
      synchronized (WebhooksGrpc.class) {
        if ((getGetWebhookMethod = WebhooksGrpc.getGetWebhookMethod) == null) {
          WebhooksGrpc.getGetWebhookMethod = getGetWebhookMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3beta1.GetWebhookRequest, com.google.cloud.dialogflow.cx.v3beta1.Webhook>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetWebhook"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.GetWebhookRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.Webhook.getDefaultInstance()))
              .setSchemaDescriptor(new WebhooksMethodDescriptorSupplier("GetWebhook"))
              .build();
        }
      }
    }
    return getGetWebhookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.CreateWebhookRequest,
      com.google.cloud.dialogflow.cx.v3beta1.Webhook> getCreateWebhookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateWebhook",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.CreateWebhookRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.Webhook.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.CreateWebhookRequest,
      com.google.cloud.dialogflow.cx.v3beta1.Webhook> getCreateWebhookMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.CreateWebhookRequest, com.google.cloud.dialogflow.cx.v3beta1.Webhook> getCreateWebhookMethod;
    if ((getCreateWebhookMethod = WebhooksGrpc.getCreateWebhookMethod) == null) {
      synchronized (WebhooksGrpc.class) {
        if ((getCreateWebhookMethod = WebhooksGrpc.getCreateWebhookMethod) == null) {
          WebhooksGrpc.getCreateWebhookMethod = getCreateWebhookMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3beta1.CreateWebhookRequest, com.google.cloud.dialogflow.cx.v3beta1.Webhook>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateWebhook"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.CreateWebhookRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.Webhook.getDefaultInstance()))
              .setSchemaDescriptor(new WebhooksMethodDescriptorSupplier("CreateWebhook"))
              .build();
        }
      }
    }
    return getCreateWebhookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.UpdateWebhookRequest,
      com.google.cloud.dialogflow.cx.v3beta1.Webhook> getUpdateWebhookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateWebhook",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.UpdateWebhookRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.Webhook.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.UpdateWebhookRequest,
      com.google.cloud.dialogflow.cx.v3beta1.Webhook> getUpdateWebhookMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.UpdateWebhookRequest, com.google.cloud.dialogflow.cx.v3beta1.Webhook> getUpdateWebhookMethod;
    if ((getUpdateWebhookMethod = WebhooksGrpc.getUpdateWebhookMethod) == null) {
      synchronized (WebhooksGrpc.class) {
        if ((getUpdateWebhookMethod = WebhooksGrpc.getUpdateWebhookMethod) == null) {
          WebhooksGrpc.getUpdateWebhookMethod = getUpdateWebhookMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3beta1.UpdateWebhookRequest, com.google.cloud.dialogflow.cx.v3beta1.Webhook>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateWebhook"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.UpdateWebhookRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.Webhook.getDefaultInstance()))
              .setSchemaDescriptor(new WebhooksMethodDescriptorSupplier("UpdateWebhook"))
              .build();
        }
      }
    }
    return getUpdateWebhookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.DeleteWebhookRequest,
      com.google.protobuf.Empty> getDeleteWebhookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteWebhook",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.DeleteWebhookRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.DeleteWebhookRequest,
      com.google.protobuf.Empty> getDeleteWebhookMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.DeleteWebhookRequest, com.google.protobuf.Empty> getDeleteWebhookMethod;
    if ((getDeleteWebhookMethod = WebhooksGrpc.getDeleteWebhookMethod) == null) {
      synchronized (WebhooksGrpc.class) {
        if ((getDeleteWebhookMethod = WebhooksGrpc.getDeleteWebhookMethod) == null) {
          WebhooksGrpc.getDeleteWebhookMethod = getDeleteWebhookMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3beta1.DeleteWebhookRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteWebhook"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.DeleteWebhookRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new WebhooksMethodDescriptorSupplier("DeleteWebhook"))
              .build();
        }
      }
    }
    return getDeleteWebhookMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WebhooksStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WebhooksStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WebhooksStub>() {
        @java.lang.Override
        public WebhooksStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WebhooksStub(channel, callOptions);
        }
      };
    return WebhooksStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WebhooksBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WebhooksBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WebhooksBlockingStub>() {
        @java.lang.Override
        public WebhooksBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WebhooksBlockingStub(channel, callOptions);
        }
      };
    return WebhooksBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WebhooksFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WebhooksFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WebhooksFutureStub>() {
        @java.lang.Override
        public WebhooksFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WebhooksFutureStub(channel, callOptions);
        }
      };
    return WebhooksFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service for managing [Webhooks][google.cloud.dialogflow.cx.v3beta1.Webhook].
   * </pre>
   */
  public static abstract class WebhooksImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Returns the list of all webhooks in the specified agent.
     * </pre>
     */
    public void listWebhooks(com.google.cloud.dialogflow.cx.v3beta1.ListWebhooksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.ListWebhooksResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListWebhooksMethod(), responseObserver);
    }

    /**
     * <pre>
     * Retrieves the specified webhook.
     * </pre>
     */
    public void getWebhook(com.google.cloud.dialogflow.cx.v3beta1.GetWebhookRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Webhook> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetWebhookMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a webhook in the specified agent.
     * </pre>
     */
    public void createWebhook(com.google.cloud.dialogflow.cx.v3beta1.CreateWebhookRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Webhook> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateWebhookMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the specified webhook.
     * </pre>
     */
    public void updateWebhook(com.google.cloud.dialogflow.cx.v3beta1.UpdateWebhookRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Webhook> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateWebhookMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified webhook.
     * </pre>
     */
    public void deleteWebhook(com.google.cloud.dialogflow.cx.v3beta1.DeleteWebhookRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteWebhookMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListWebhooksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.cx.v3beta1.ListWebhooksRequest,
                com.google.cloud.dialogflow.cx.v3beta1.ListWebhooksResponse>(
                  this, METHODID_LIST_WEBHOOKS)))
          .addMethod(
            getGetWebhookMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.cx.v3beta1.GetWebhookRequest,
                com.google.cloud.dialogflow.cx.v3beta1.Webhook>(
                  this, METHODID_GET_WEBHOOK)))
          .addMethod(
            getCreateWebhookMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.cx.v3beta1.CreateWebhookRequest,
                com.google.cloud.dialogflow.cx.v3beta1.Webhook>(
                  this, METHODID_CREATE_WEBHOOK)))
          .addMethod(
            getUpdateWebhookMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.cx.v3beta1.UpdateWebhookRequest,
                com.google.cloud.dialogflow.cx.v3beta1.Webhook>(
                  this, METHODID_UPDATE_WEBHOOK)))
          .addMethod(
            getDeleteWebhookMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.cx.v3beta1.DeleteWebhookRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_WEBHOOK)))
          .build();
    }
  }

  /**
   * <pre>
   * Service for managing [Webhooks][google.cloud.dialogflow.cx.v3beta1.Webhook].
   * </pre>
   */
  public static final class WebhooksStub extends io.grpc.stub.AbstractAsyncStub<WebhooksStub> {
    private WebhooksStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WebhooksStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WebhooksStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns the list of all webhooks in the specified agent.
     * </pre>
     */
    public void listWebhooks(com.google.cloud.dialogflow.cx.v3beta1.ListWebhooksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.ListWebhooksResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListWebhooksMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves the specified webhook.
     * </pre>
     */
    public void getWebhook(com.google.cloud.dialogflow.cx.v3beta1.GetWebhookRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Webhook> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetWebhookMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a webhook in the specified agent.
     * </pre>
     */
    public void createWebhook(com.google.cloud.dialogflow.cx.v3beta1.CreateWebhookRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Webhook> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateWebhookMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the specified webhook.
     * </pre>
     */
    public void updateWebhook(com.google.cloud.dialogflow.cx.v3beta1.UpdateWebhookRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Webhook> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateWebhookMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified webhook.
     * </pre>
     */
    public void deleteWebhook(com.google.cloud.dialogflow.cx.v3beta1.DeleteWebhookRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteWebhookMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service for managing [Webhooks][google.cloud.dialogflow.cx.v3beta1.Webhook].
   * </pre>
   */
  public static final class WebhooksBlockingStub extends io.grpc.stub.AbstractBlockingStub<WebhooksBlockingStub> {
    private WebhooksBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WebhooksBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WebhooksBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns the list of all webhooks in the specified agent.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.ListWebhooksResponse listWebhooks(com.google.cloud.dialogflow.cx.v3beta1.ListWebhooksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListWebhooksMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves the specified webhook.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.Webhook getWebhook(com.google.cloud.dialogflow.cx.v3beta1.GetWebhookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetWebhookMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a webhook in the specified agent.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.Webhook createWebhook(com.google.cloud.dialogflow.cx.v3beta1.CreateWebhookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateWebhookMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the specified webhook.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.Webhook updateWebhook(com.google.cloud.dialogflow.cx.v3beta1.UpdateWebhookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateWebhookMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the specified webhook.
     * </pre>
     */
    public com.google.protobuf.Empty deleteWebhook(com.google.cloud.dialogflow.cx.v3beta1.DeleteWebhookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteWebhookMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service for managing [Webhooks][google.cloud.dialogflow.cx.v3beta1.Webhook].
   * </pre>
   */
  public static final class WebhooksFutureStub extends io.grpc.stub.AbstractFutureStub<WebhooksFutureStub> {
    private WebhooksFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WebhooksFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WebhooksFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns the list of all webhooks in the specified agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.cx.v3beta1.ListWebhooksResponse> listWebhooks(
        com.google.cloud.dialogflow.cx.v3beta1.ListWebhooksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListWebhooksMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves the specified webhook.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.cx.v3beta1.Webhook> getWebhook(
        com.google.cloud.dialogflow.cx.v3beta1.GetWebhookRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetWebhookMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a webhook in the specified agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.cx.v3beta1.Webhook> createWebhook(
        com.google.cloud.dialogflow.cx.v3beta1.CreateWebhookRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateWebhookMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the specified webhook.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.cx.v3beta1.Webhook> updateWebhook(
        com.google.cloud.dialogflow.cx.v3beta1.UpdateWebhookRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateWebhookMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the specified webhook.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteWebhook(
        com.google.cloud.dialogflow.cx.v3beta1.DeleteWebhookRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteWebhookMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_WEBHOOKS = 0;
  private static final int METHODID_GET_WEBHOOK = 1;
  private static final int METHODID_CREATE_WEBHOOK = 2;
  private static final int METHODID_UPDATE_WEBHOOK = 3;
  private static final int METHODID_DELETE_WEBHOOK = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WebhooksImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WebhooksImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_WEBHOOKS:
          serviceImpl.listWebhooks((com.google.cloud.dialogflow.cx.v3beta1.ListWebhooksRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.ListWebhooksResponse>) responseObserver);
          break;
        case METHODID_GET_WEBHOOK:
          serviceImpl.getWebhook((com.google.cloud.dialogflow.cx.v3beta1.GetWebhookRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Webhook>) responseObserver);
          break;
        case METHODID_CREATE_WEBHOOK:
          serviceImpl.createWebhook((com.google.cloud.dialogflow.cx.v3beta1.CreateWebhookRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Webhook>) responseObserver);
          break;
        case METHODID_UPDATE_WEBHOOK:
          serviceImpl.updateWebhook((com.google.cloud.dialogflow.cx.v3beta1.UpdateWebhookRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Webhook>) responseObserver);
          break;
        case METHODID_DELETE_WEBHOOK:
          serviceImpl.deleteWebhook((com.google.cloud.dialogflow.cx.v3beta1.DeleteWebhookRequest) request,
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

  private static abstract class WebhooksBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WebhooksBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.cx.v3beta1.WebhookProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Webhooks");
    }
  }

  private static final class WebhooksFileDescriptorSupplier
      extends WebhooksBaseDescriptorSupplier {
    WebhooksFileDescriptorSupplier() {}
  }

  private static final class WebhooksMethodDescriptorSupplier
      extends WebhooksBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WebhooksMethodDescriptorSupplier(String methodName) {
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
      synchronized (WebhooksGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WebhooksFileDescriptorSupplier())
              .addMethod(getListWebhooksMethod())
              .addMethod(getGetWebhookMethod())
              .addMethod(getCreateWebhookMethod())
              .addMethod(getUpdateWebhookMethod())
              .addMethod(getDeleteWebhookMethod())
              .build();
        }
      }
    }
    return result;
  }
}
