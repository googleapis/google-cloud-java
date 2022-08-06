package com.google.monitoring.v3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The Notification Channel API provides access to configuration that
 * controls how messages related to incidents are sent.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/monitoring/v3/notification_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class NotificationChannelServiceGrpc {

  private NotificationChannelServiceGrpc() {}

  public static final String SERVICE_NAME = "google.monitoring.v3.NotificationChannelService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.monitoring.v3.ListNotificationChannelDescriptorsRequest,
      com.google.monitoring.v3.ListNotificationChannelDescriptorsResponse> getListNotificationChannelDescriptorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListNotificationChannelDescriptors",
      requestType = com.google.monitoring.v3.ListNotificationChannelDescriptorsRequest.class,
      responseType = com.google.monitoring.v3.ListNotificationChannelDescriptorsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.monitoring.v3.ListNotificationChannelDescriptorsRequest,
      com.google.monitoring.v3.ListNotificationChannelDescriptorsResponse> getListNotificationChannelDescriptorsMethod() {
    io.grpc.MethodDescriptor<com.google.monitoring.v3.ListNotificationChannelDescriptorsRequest, com.google.monitoring.v3.ListNotificationChannelDescriptorsResponse> getListNotificationChannelDescriptorsMethod;
    if ((getListNotificationChannelDescriptorsMethod = NotificationChannelServiceGrpc.getListNotificationChannelDescriptorsMethod) == null) {
      synchronized (NotificationChannelServiceGrpc.class) {
        if ((getListNotificationChannelDescriptorsMethod = NotificationChannelServiceGrpc.getListNotificationChannelDescriptorsMethod) == null) {
          NotificationChannelServiceGrpc.getListNotificationChannelDescriptorsMethod = getListNotificationChannelDescriptorsMethod =
              io.grpc.MethodDescriptor.<com.google.monitoring.v3.ListNotificationChannelDescriptorsRequest, com.google.monitoring.v3.ListNotificationChannelDescriptorsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListNotificationChannelDescriptors"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.ListNotificationChannelDescriptorsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.ListNotificationChannelDescriptorsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NotificationChannelServiceMethodDescriptorSupplier("ListNotificationChannelDescriptors"))
              .build();
        }
      }
    }
    return getListNotificationChannelDescriptorsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.monitoring.v3.GetNotificationChannelDescriptorRequest,
      com.google.monitoring.v3.NotificationChannelDescriptor> getGetNotificationChannelDescriptorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNotificationChannelDescriptor",
      requestType = com.google.monitoring.v3.GetNotificationChannelDescriptorRequest.class,
      responseType = com.google.monitoring.v3.NotificationChannelDescriptor.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.monitoring.v3.GetNotificationChannelDescriptorRequest,
      com.google.monitoring.v3.NotificationChannelDescriptor> getGetNotificationChannelDescriptorMethod() {
    io.grpc.MethodDescriptor<com.google.monitoring.v3.GetNotificationChannelDescriptorRequest, com.google.monitoring.v3.NotificationChannelDescriptor> getGetNotificationChannelDescriptorMethod;
    if ((getGetNotificationChannelDescriptorMethod = NotificationChannelServiceGrpc.getGetNotificationChannelDescriptorMethod) == null) {
      synchronized (NotificationChannelServiceGrpc.class) {
        if ((getGetNotificationChannelDescriptorMethod = NotificationChannelServiceGrpc.getGetNotificationChannelDescriptorMethod) == null) {
          NotificationChannelServiceGrpc.getGetNotificationChannelDescriptorMethod = getGetNotificationChannelDescriptorMethod =
              io.grpc.MethodDescriptor.<com.google.monitoring.v3.GetNotificationChannelDescriptorRequest, com.google.monitoring.v3.NotificationChannelDescriptor>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNotificationChannelDescriptor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.GetNotificationChannelDescriptorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.NotificationChannelDescriptor.getDefaultInstance()))
              .setSchemaDescriptor(new NotificationChannelServiceMethodDescriptorSupplier("GetNotificationChannelDescriptor"))
              .build();
        }
      }
    }
    return getGetNotificationChannelDescriptorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.monitoring.v3.ListNotificationChannelsRequest,
      com.google.monitoring.v3.ListNotificationChannelsResponse> getListNotificationChannelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListNotificationChannels",
      requestType = com.google.monitoring.v3.ListNotificationChannelsRequest.class,
      responseType = com.google.monitoring.v3.ListNotificationChannelsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.monitoring.v3.ListNotificationChannelsRequest,
      com.google.monitoring.v3.ListNotificationChannelsResponse> getListNotificationChannelsMethod() {
    io.grpc.MethodDescriptor<com.google.monitoring.v3.ListNotificationChannelsRequest, com.google.monitoring.v3.ListNotificationChannelsResponse> getListNotificationChannelsMethod;
    if ((getListNotificationChannelsMethod = NotificationChannelServiceGrpc.getListNotificationChannelsMethod) == null) {
      synchronized (NotificationChannelServiceGrpc.class) {
        if ((getListNotificationChannelsMethod = NotificationChannelServiceGrpc.getListNotificationChannelsMethod) == null) {
          NotificationChannelServiceGrpc.getListNotificationChannelsMethod = getListNotificationChannelsMethod =
              io.grpc.MethodDescriptor.<com.google.monitoring.v3.ListNotificationChannelsRequest, com.google.monitoring.v3.ListNotificationChannelsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListNotificationChannels"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.ListNotificationChannelsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.ListNotificationChannelsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NotificationChannelServiceMethodDescriptorSupplier("ListNotificationChannels"))
              .build();
        }
      }
    }
    return getListNotificationChannelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.monitoring.v3.GetNotificationChannelRequest,
      com.google.monitoring.v3.NotificationChannel> getGetNotificationChannelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNotificationChannel",
      requestType = com.google.monitoring.v3.GetNotificationChannelRequest.class,
      responseType = com.google.monitoring.v3.NotificationChannel.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.monitoring.v3.GetNotificationChannelRequest,
      com.google.monitoring.v3.NotificationChannel> getGetNotificationChannelMethod() {
    io.grpc.MethodDescriptor<com.google.monitoring.v3.GetNotificationChannelRequest, com.google.monitoring.v3.NotificationChannel> getGetNotificationChannelMethod;
    if ((getGetNotificationChannelMethod = NotificationChannelServiceGrpc.getGetNotificationChannelMethod) == null) {
      synchronized (NotificationChannelServiceGrpc.class) {
        if ((getGetNotificationChannelMethod = NotificationChannelServiceGrpc.getGetNotificationChannelMethod) == null) {
          NotificationChannelServiceGrpc.getGetNotificationChannelMethod = getGetNotificationChannelMethod =
              io.grpc.MethodDescriptor.<com.google.monitoring.v3.GetNotificationChannelRequest, com.google.monitoring.v3.NotificationChannel>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNotificationChannel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.GetNotificationChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.NotificationChannel.getDefaultInstance()))
              .setSchemaDescriptor(new NotificationChannelServiceMethodDescriptorSupplier("GetNotificationChannel"))
              .build();
        }
      }
    }
    return getGetNotificationChannelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.monitoring.v3.CreateNotificationChannelRequest,
      com.google.monitoring.v3.NotificationChannel> getCreateNotificationChannelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateNotificationChannel",
      requestType = com.google.monitoring.v3.CreateNotificationChannelRequest.class,
      responseType = com.google.monitoring.v3.NotificationChannel.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.monitoring.v3.CreateNotificationChannelRequest,
      com.google.monitoring.v3.NotificationChannel> getCreateNotificationChannelMethod() {
    io.grpc.MethodDescriptor<com.google.monitoring.v3.CreateNotificationChannelRequest, com.google.monitoring.v3.NotificationChannel> getCreateNotificationChannelMethod;
    if ((getCreateNotificationChannelMethod = NotificationChannelServiceGrpc.getCreateNotificationChannelMethod) == null) {
      synchronized (NotificationChannelServiceGrpc.class) {
        if ((getCreateNotificationChannelMethod = NotificationChannelServiceGrpc.getCreateNotificationChannelMethod) == null) {
          NotificationChannelServiceGrpc.getCreateNotificationChannelMethod = getCreateNotificationChannelMethod =
              io.grpc.MethodDescriptor.<com.google.monitoring.v3.CreateNotificationChannelRequest, com.google.monitoring.v3.NotificationChannel>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateNotificationChannel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.CreateNotificationChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.NotificationChannel.getDefaultInstance()))
              .setSchemaDescriptor(new NotificationChannelServiceMethodDescriptorSupplier("CreateNotificationChannel"))
              .build();
        }
      }
    }
    return getCreateNotificationChannelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.monitoring.v3.UpdateNotificationChannelRequest,
      com.google.monitoring.v3.NotificationChannel> getUpdateNotificationChannelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateNotificationChannel",
      requestType = com.google.monitoring.v3.UpdateNotificationChannelRequest.class,
      responseType = com.google.monitoring.v3.NotificationChannel.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.monitoring.v3.UpdateNotificationChannelRequest,
      com.google.monitoring.v3.NotificationChannel> getUpdateNotificationChannelMethod() {
    io.grpc.MethodDescriptor<com.google.monitoring.v3.UpdateNotificationChannelRequest, com.google.monitoring.v3.NotificationChannel> getUpdateNotificationChannelMethod;
    if ((getUpdateNotificationChannelMethod = NotificationChannelServiceGrpc.getUpdateNotificationChannelMethod) == null) {
      synchronized (NotificationChannelServiceGrpc.class) {
        if ((getUpdateNotificationChannelMethod = NotificationChannelServiceGrpc.getUpdateNotificationChannelMethod) == null) {
          NotificationChannelServiceGrpc.getUpdateNotificationChannelMethod = getUpdateNotificationChannelMethod =
              io.grpc.MethodDescriptor.<com.google.monitoring.v3.UpdateNotificationChannelRequest, com.google.monitoring.v3.NotificationChannel>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateNotificationChannel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.UpdateNotificationChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.NotificationChannel.getDefaultInstance()))
              .setSchemaDescriptor(new NotificationChannelServiceMethodDescriptorSupplier("UpdateNotificationChannel"))
              .build();
        }
      }
    }
    return getUpdateNotificationChannelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.monitoring.v3.DeleteNotificationChannelRequest,
      com.google.protobuf.Empty> getDeleteNotificationChannelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteNotificationChannel",
      requestType = com.google.monitoring.v3.DeleteNotificationChannelRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.monitoring.v3.DeleteNotificationChannelRequest,
      com.google.protobuf.Empty> getDeleteNotificationChannelMethod() {
    io.grpc.MethodDescriptor<com.google.monitoring.v3.DeleteNotificationChannelRequest, com.google.protobuf.Empty> getDeleteNotificationChannelMethod;
    if ((getDeleteNotificationChannelMethod = NotificationChannelServiceGrpc.getDeleteNotificationChannelMethod) == null) {
      synchronized (NotificationChannelServiceGrpc.class) {
        if ((getDeleteNotificationChannelMethod = NotificationChannelServiceGrpc.getDeleteNotificationChannelMethod) == null) {
          NotificationChannelServiceGrpc.getDeleteNotificationChannelMethod = getDeleteNotificationChannelMethod =
              io.grpc.MethodDescriptor.<com.google.monitoring.v3.DeleteNotificationChannelRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteNotificationChannel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.DeleteNotificationChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new NotificationChannelServiceMethodDescriptorSupplier("DeleteNotificationChannel"))
              .build();
        }
      }
    }
    return getDeleteNotificationChannelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.monitoring.v3.SendNotificationChannelVerificationCodeRequest,
      com.google.protobuf.Empty> getSendNotificationChannelVerificationCodeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendNotificationChannelVerificationCode",
      requestType = com.google.monitoring.v3.SendNotificationChannelVerificationCodeRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.monitoring.v3.SendNotificationChannelVerificationCodeRequest,
      com.google.protobuf.Empty> getSendNotificationChannelVerificationCodeMethod() {
    io.grpc.MethodDescriptor<com.google.monitoring.v3.SendNotificationChannelVerificationCodeRequest, com.google.protobuf.Empty> getSendNotificationChannelVerificationCodeMethod;
    if ((getSendNotificationChannelVerificationCodeMethod = NotificationChannelServiceGrpc.getSendNotificationChannelVerificationCodeMethod) == null) {
      synchronized (NotificationChannelServiceGrpc.class) {
        if ((getSendNotificationChannelVerificationCodeMethod = NotificationChannelServiceGrpc.getSendNotificationChannelVerificationCodeMethod) == null) {
          NotificationChannelServiceGrpc.getSendNotificationChannelVerificationCodeMethod = getSendNotificationChannelVerificationCodeMethod =
              io.grpc.MethodDescriptor.<com.google.monitoring.v3.SendNotificationChannelVerificationCodeRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendNotificationChannelVerificationCode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.SendNotificationChannelVerificationCodeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new NotificationChannelServiceMethodDescriptorSupplier("SendNotificationChannelVerificationCode"))
              .build();
        }
      }
    }
    return getSendNotificationChannelVerificationCodeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.monitoring.v3.GetNotificationChannelVerificationCodeRequest,
      com.google.monitoring.v3.GetNotificationChannelVerificationCodeResponse> getGetNotificationChannelVerificationCodeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNotificationChannelVerificationCode",
      requestType = com.google.monitoring.v3.GetNotificationChannelVerificationCodeRequest.class,
      responseType = com.google.monitoring.v3.GetNotificationChannelVerificationCodeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.monitoring.v3.GetNotificationChannelVerificationCodeRequest,
      com.google.monitoring.v3.GetNotificationChannelVerificationCodeResponse> getGetNotificationChannelVerificationCodeMethod() {
    io.grpc.MethodDescriptor<com.google.monitoring.v3.GetNotificationChannelVerificationCodeRequest, com.google.monitoring.v3.GetNotificationChannelVerificationCodeResponse> getGetNotificationChannelVerificationCodeMethod;
    if ((getGetNotificationChannelVerificationCodeMethod = NotificationChannelServiceGrpc.getGetNotificationChannelVerificationCodeMethod) == null) {
      synchronized (NotificationChannelServiceGrpc.class) {
        if ((getGetNotificationChannelVerificationCodeMethod = NotificationChannelServiceGrpc.getGetNotificationChannelVerificationCodeMethod) == null) {
          NotificationChannelServiceGrpc.getGetNotificationChannelVerificationCodeMethod = getGetNotificationChannelVerificationCodeMethod =
              io.grpc.MethodDescriptor.<com.google.monitoring.v3.GetNotificationChannelVerificationCodeRequest, com.google.monitoring.v3.GetNotificationChannelVerificationCodeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNotificationChannelVerificationCode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.GetNotificationChannelVerificationCodeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.GetNotificationChannelVerificationCodeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NotificationChannelServiceMethodDescriptorSupplier("GetNotificationChannelVerificationCode"))
              .build();
        }
      }
    }
    return getGetNotificationChannelVerificationCodeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.monitoring.v3.VerifyNotificationChannelRequest,
      com.google.monitoring.v3.NotificationChannel> getVerifyNotificationChannelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "VerifyNotificationChannel",
      requestType = com.google.monitoring.v3.VerifyNotificationChannelRequest.class,
      responseType = com.google.monitoring.v3.NotificationChannel.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.monitoring.v3.VerifyNotificationChannelRequest,
      com.google.monitoring.v3.NotificationChannel> getVerifyNotificationChannelMethod() {
    io.grpc.MethodDescriptor<com.google.monitoring.v3.VerifyNotificationChannelRequest, com.google.monitoring.v3.NotificationChannel> getVerifyNotificationChannelMethod;
    if ((getVerifyNotificationChannelMethod = NotificationChannelServiceGrpc.getVerifyNotificationChannelMethod) == null) {
      synchronized (NotificationChannelServiceGrpc.class) {
        if ((getVerifyNotificationChannelMethod = NotificationChannelServiceGrpc.getVerifyNotificationChannelMethod) == null) {
          NotificationChannelServiceGrpc.getVerifyNotificationChannelMethod = getVerifyNotificationChannelMethod =
              io.grpc.MethodDescriptor.<com.google.monitoring.v3.VerifyNotificationChannelRequest, com.google.monitoring.v3.NotificationChannel>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "VerifyNotificationChannel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.VerifyNotificationChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.NotificationChannel.getDefaultInstance()))
              .setSchemaDescriptor(new NotificationChannelServiceMethodDescriptorSupplier("VerifyNotificationChannel"))
              .build();
        }
      }
    }
    return getVerifyNotificationChannelMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static NotificationChannelServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NotificationChannelServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NotificationChannelServiceStub>() {
        @java.lang.Override
        public NotificationChannelServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NotificationChannelServiceStub(channel, callOptions);
        }
      };
    return NotificationChannelServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NotificationChannelServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NotificationChannelServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NotificationChannelServiceBlockingStub>() {
        @java.lang.Override
        public NotificationChannelServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NotificationChannelServiceBlockingStub(channel, callOptions);
        }
      };
    return NotificationChannelServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static NotificationChannelServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NotificationChannelServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NotificationChannelServiceFutureStub>() {
        @java.lang.Override
        public NotificationChannelServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NotificationChannelServiceFutureStub(channel, callOptions);
        }
      };
    return NotificationChannelServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The Notification Channel API provides access to configuration that
   * controls how messages related to incidents are sent.
   * </pre>
   */
  public static abstract class NotificationChannelServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists the descriptors for supported channel types. The use of descriptors
     * makes it possible for new channel types to be dynamically added.
     * </pre>
     */
    public void listNotificationChannelDescriptors(com.google.monitoring.v3.ListNotificationChannelDescriptorsRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.ListNotificationChannelDescriptorsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListNotificationChannelDescriptorsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a single channel descriptor. The descriptor indicates which fields
     * are expected / permitted for a notification channel of the given type.
     * </pre>
     */
    public void getNotificationChannelDescriptor(com.google.monitoring.v3.GetNotificationChannelDescriptorRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.NotificationChannelDescriptor> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetNotificationChannelDescriptorMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists the notification channels that have been created for the project.
     * </pre>
     */
    public void listNotificationChannels(com.google.monitoring.v3.ListNotificationChannelsRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.ListNotificationChannelsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListNotificationChannelsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a single notification channel. The channel includes the relevant
     * configuration details with which the channel was created. However, the
     * response may truncate or omit passwords, API keys, or other private key
     * matter and thus the response may not be 100% identical to the information
     * that was supplied in the call to the create method.
     * </pre>
     */
    public void getNotificationChannel(com.google.monitoring.v3.GetNotificationChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.NotificationChannel> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetNotificationChannelMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new notification channel, representing a single notification
     * endpoint such as an email address, SMS number, or PagerDuty service.
     * </pre>
     */
    public void createNotificationChannel(com.google.monitoring.v3.CreateNotificationChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.NotificationChannel> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateNotificationChannelMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a notification channel. Fields not specified in the field mask
     * remain unchanged.
     * </pre>
     */
    public void updateNotificationChannel(com.google.monitoring.v3.UpdateNotificationChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.NotificationChannel> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateNotificationChannelMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a notification channel.
     * </pre>
     */
    public void deleteNotificationChannel(com.google.monitoring.v3.DeleteNotificationChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteNotificationChannelMethod(), responseObserver);
    }

    /**
     * <pre>
     * Causes a verification code to be delivered to the channel. The code
     * can then be supplied in `VerifyNotificationChannel` to verify the channel.
     * </pre>
     */
    public void sendNotificationChannelVerificationCode(com.google.monitoring.v3.SendNotificationChannelVerificationCodeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendNotificationChannelVerificationCodeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Requests a verification code for an already verified channel that can then
     * be used in a call to VerifyNotificationChannel() on a different channel
     * with an equivalent identity in the same or in a different project. This
     * makes it possible to copy a channel between projects without requiring
     * manual reverification of the channel. If the channel is not in the
     * verified state, this method will fail (in other words, this may only be
     * used if the SendNotificationChannelVerificationCode and
     * VerifyNotificationChannel paths have already been used to put the given
     * channel into the verified state).
     * There is no guarantee that the verification codes returned by this method
     * will be of a similar structure or form as the ones that are delivered
     * to the channel via SendNotificationChannelVerificationCode; while
     * VerifyNotificationChannel() will recognize both the codes delivered via
     * SendNotificationChannelVerificationCode() and returned from
     * GetNotificationChannelVerificationCode(), it is typically the case that
     * the verification codes delivered via
     * SendNotificationChannelVerificationCode() will be shorter and also
     * have a shorter expiration (e.g. codes such as "G-123456") whereas
     * GetVerificationCode() will typically return a much longer, websafe base
     * 64 encoded string that has a longer expiration time.
     * </pre>
     */
    public void getNotificationChannelVerificationCode(com.google.monitoring.v3.GetNotificationChannelVerificationCodeRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.GetNotificationChannelVerificationCodeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetNotificationChannelVerificationCodeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Verifies a `NotificationChannel` by proving receipt of the code
     * delivered to the channel as a result of calling
     * `SendNotificationChannelVerificationCode`.
     * </pre>
     */
    public void verifyNotificationChannel(com.google.monitoring.v3.VerifyNotificationChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.NotificationChannel> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getVerifyNotificationChannelMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListNotificationChannelDescriptorsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.monitoring.v3.ListNotificationChannelDescriptorsRequest,
                com.google.monitoring.v3.ListNotificationChannelDescriptorsResponse>(
                  this, METHODID_LIST_NOTIFICATION_CHANNEL_DESCRIPTORS)))
          .addMethod(
            getGetNotificationChannelDescriptorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.monitoring.v3.GetNotificationChannelDescriptorRequest,
                com.google.monitoring.v3.NotificationChannelDescriptor>(
                  this, METHODID_GET_NOTIFICATION_CHANNEL_DESCRIPTOR)))
          .addMethod(
            getListNotificationChannelsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.monitoring.v3.ListNotificationChannelsRequest,
                com.google.monitoring.v3.ListNotificationChannelsResponse>(
                  this, METHODID_LIST_NOTIFICATION_CHANNELS)))
          .addMethod(
            getGetNotificationChannelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.monitoring.v3.GetNotificationChannelRequest,
                com.google.monitoring.v3.NotificationChannel>(
                  this, METHODID_GET_NOTIFICATION_CHANNEL)))
          .addMethod(
            getCreateNotificationChannelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.monitoring.v3.CreateNotificationChannelRequest,
                com.google.monitoring.v3.NotificationChannel>(
                  this, METHODID_CREATE_NOTIFICATION_CHANNEL)))
          .addMethod(
            getUpdateNotificationChannelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.monitoring.v3.UpdateNotificationChannelRequest,
                com.google.monitoring.v3.NotificationChannel>(
                  this, METHODID_UPDATE_NOTIFICATION_CHANNEL)))
          .addMethod(
            getDeleteNotificationChannelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.monitoring.v3.DeleteNotificationChannelRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_NOTIFICATION_CHANNEL)))
          .addMethod(
            getSendNotificationChannelVerificationCodeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.monitoring.v3.SendNotificationChannelVerificationCodeRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_SEND_NOTIFICATION_CHANNEL_VERIFICATION_CODE)))
          .addMethod(
            getGetNotificationChannelVerificationCodeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.monitoring.v3.GetNotificationChannelVerificationCodeRequest,
                com.google.monitoring.v3.GetNotificationChannelVerificationCodeResponse>(
                  this, METHODID_GET_NOTIFICATION_CHANNEL_VERIFICATION_CODE)))
          .addMethod(
            getVerifyNotificationChannelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.monitoring.v3.VerifyNotificationChannelRequest,
                com.google.monitoring.v3.NotificationChannel>(
                  this, METHODID_VERIFY_NOTIFICATION_CHANNEL)))
          .build();
    }
  }

  /**
   * <pre>
   * The Notification Channel API provides access to configuration that
   * controls how messages related to incidents are sent.
   * </pre>
   */
  public static final class NotificationChannelServiceStub extends io.grpc.stub.AbstractAsyncStub<NotificationChannelServiceStub> {
    private NotificationChannelServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NotificationChannelServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NotificationChannelServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the descriptors for supported channel types. The use of descriptors
     * makes it possible for new channel types to be dynamically added.
     * </pre>
     */
    public void listNotificationChannelDescriptors(com.google.monitoring.v3.ListNotificationChannelDescriptorsRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.ListNotificationChannelDescriptorsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListNotificationChannelDescriptorsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a single channel descriptor. The descriptor indicates which fields
     * are expected / permitted for a notification channel of the given type.
     * </pre>
     */
    public void getNotificationChannelDescriptor(com.google.monitoring.v3.GetNotificationChannelDescriptorRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.NotificationChannelDescriptor> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNotificationChannelDescriptorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists the notification channels that have been created for the project.
     * </pre>
     */
    public void listNotificationChannels(com.google.monitoring.v3.ListNotificationChannelsRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.ListNotificationChannelsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListNotificationChannelsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a single notification channel. The channel includes the relevant
     * configuration details with which the channel was created. However, the
     * response may truncate or omit passwords, API keys, or other private key
     * matter and thus the response may not be 100% identical to the information
     * that was supplied in the call to the create method.
     * </pre>
     */
    public void getNotificationChannel(com.google.monitoring.v3.GetNotificationChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.NotificationChannel> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNotificationChannelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new notification channel, representing a single notification
     * endpoint such as an email address, SMS number, or PagerDuty service.
     * </pre>
     */
    public void createNotificationChannel(com.google.monitoring.v3.CreateNotificationChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.NotificationChannel> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateNotificationChannelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a notification channel. Fields not specified in the field mask
     * remain unchanged.
     * </pre>
     */
    public void updateNotificationChannel(com.google.monitoring.v3.UpdateNotificationChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.NotificationChannel> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateNotificationChannelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a notification channel.
     * </pre>
     */
    public void deleteNotificationChannel(com.google.monitoring.v3.DeleteNotificationChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteNotificationChannelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Causes a verification code to be delivered to the channel. The code
     * can then be supplied in `VerifyNotificationChannel` to verify the channel.
     * </pre>
     */
    public void sendNotificationChannelVerificationCode(com.google.monitoring.v3.SendNotificationChannelVerificationCodeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendNotificationChannelVerificationCodeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Requests a verification code for an already verified channel that can then
     * be used in a call to VerifyNotificationChannel() on a different channel
     * with an equivalent identity in the same or in a different project. This
     * makes it possible to copy a channel between projects without requiring
     * manual reverification of the channel. If the channel is not in the
     * verified state, this method will fail (in other words, this may only be
     * used if the SendNotificationChannelVerificationCode and
     * VerifyNotificationChannel paths have already been used to put the given
     * channel into the verified state).
     * There is no guarantee that the verification codes returned by this method
     * will be of a similar structure or form as the ones that are delivered
     * to the channel via SendNotificationChannelVerificationCode; while
     * VerifyNotificationChannel() will recognize both the codes delivered via
     * SendNotificationChannelVerificationCode() and returned from
     * GetNotificationChannelVerificationCode(), it is typically the case that
     * the verification codes delivered via
     * SendNotificationChannelVerificationCode() will be shorter and also
     * have a shorter expiration (e.g. codes such as "G-123456") whereas
     * GetVerificationCode() will typically return a much longer, websafe base
     * 64 encoded string that has a longer expiration time.
     * </pre>
     */
    public void getNotificationChannelVerificationCode(com.google.monitoring.v3.GetNotificationChannelVerificationCodeRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.GetNotificationChannelVerificationCodeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNotificationChannelVerificationCodeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Verifies a `NotificationChannel` by proving receipt of the code
     * delivered to the channel as a result of calling
     * `SendNotificationChannelVerificationCode`.
     * </pre>
     */
    public void verifyNotificationChannel(com.google.monitoring.v3.VerifyNotificationChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.NotificationChannel> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getVerifyNotificationChannelMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The Notification Channel API provides access to configuration that
   * controls how messages related to incidents are sent.
   * </pre>
   */
  public static final class NotificationChannelServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<NotificationChannelServiceBlockingStub> {
    private NotificationChannelServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NotificationChannelServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NotificationChannelServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the descriptors for supported channel types. The use of descriptors
     * makes it possible for new channel types to be dynamically added.
     * </pre>
     */
    public com.google.monitoring.v3.ListNotificationChannelDescriptorsResponse listNotificationChannelDescriptors(com.google.monitoring.v3.ListNotificationChannelDescriptorsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListNotificationChannelDescriptorsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a single channel descriptor. The descriptor indicates which fields
     * are expected / permitted for a notification channel of the given type.
     * </pre>
     */
    public com.google.monitoring.v3.NotificationChannelDescriptor getNotificationChannelDescriptor(com.google.monitoring.v3.GetNotificationChannelDescriptorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNotificationChannelDescriptorMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists the notification channels that have been created for the project.
     * </pre>
     */
    public com.google.monitoring.v3.ListNotificationChannelsResponse listNotificationChannels(com.google.monitoring.v3.ListNotificationChannelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListNotificationChannelsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a single notification channel. The channel includes the relevant
     * configuration details with which the channel was created. However, the
     * response may truncate or omit passwords, API keys, or other private key
     * matter and thus the response may not be 100% identical to the information
     * that was supplied in the call to the create method.
     * </pre>
     */
    public com.google.monitoring.v3.NotificationChannel getNotificationChannel(com.google.monitoring.v3.GetNotificationChannelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNotificationChannelMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new notification channel, representing a single notification
     * endpoint such as an email address, SMS number, or PagerDuty service.
     * </pre>
     */
    public com.google.monitoring.v3.NotificationChannel createNotificationChannel(com.google.monitoring.v3.CreateNotificationChannelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateNotificationChannelMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a notification channel. Fields not specified in the field mask
     * remain unchanged.
     * </pre>
     */
    public com.google.monitoring.v3.NotificationChannel updateNotificationChannel(com.google.monitoring.v3.UpdateNotificationChannelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateNotificationChannelMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a notification channel.
     * </pre>
     */
    public com.google.protobuf.Empty deleteNotificationChannel(com.google.monitoring.v3.DeleteNotificationChannelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteNotificationChannelMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Causes a verification code to be delivered to the channel. The code
     * can then be supplied in `VerifyNotificationChannel` to verify the channel.
     * </pre>
     */
    public com.google.protobuf.Empty sendNotificationChannelVerificationCode(com.google.monitoring.v3.SendNotificationChannelVerificationCodeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendNotificationChannelVerificationCodeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Requests a verification code for an already verified channel that can then
     * be used in a call to VerifyNotificationChannel() on a different channel
     * with an equivalent identity in the same or in a different project. This
     * makes it possible to copy a channel between projects without requiring
     * manual reverification of the channel. If the channel is not in the
     * verified state, this method will fail (in other words, this may only be
     * used if the SendNotificationChannelVerificationCode and
     * VerifyNotificationChannel paths have already been used to put the given
     * channel into the verified state).
     * There is no guarantee that the verification codes returned by this method
     * will be of a similar structure or form as the ones that are delivered
     * to the channel via SendNotificationChannelVerificationCode; while
     * VerifyNotificationChannel() will recognize both the codes delivered via
     * SendNotificationChannelVerificationCode() and returned from
     * GetNotificationChannelVerificationCode(), it is typically the case that
     * the verification codes delivered via
     * SendNotificationChannelVerificationCode() will be shorter and also
     * have a shorter expiration (e.g. codes such as "G-123456") whereas
     * GetVerificationCode() will typically return a much longer, websafe base
     * 64 encoded string that has a longer expiration time.
     * </pre>
     */
    public com.google.monitoring.v3.GetNotificationChannelVerificationCodeResponse getNotificationChannelVerificationCode(com.google.monitoring.v3.GetNotificationChannelVerificationCodeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNotificationChannelVerificationCodeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Verifies a `NotificationChannel` by proving receipt of the code
     * delivered to the channel as a result of calling
     * `SendNotificationChannelVerificationCode`.
     * </pre>
     */
    public com.google.monitoring.v3.NotificationChannel verifyNotificationChannel(com.google.monitoring.v3.VerifyNotificationChannelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getVerifyNotificationChannelMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The Notification Channel API provides access to configuration that
   * controls how messages related to incidents are sent.
   * </pre>
   */
  public static final class NotificationChannelServiceFutureStub extends io.grpc.stub.AbstractFutureStub<NotificationChannelServiceFutureStub> {
    private NotificationChannelServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NotificationChannelServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NotificationChannelServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the descriptors for supported channel types. The use of descriptors
     * makes it possible for new channel types to be dynamically added.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.monitoring.v3.ListNotificationChannelDescriptorsResponse> listNotificationChannelDescriptors(
        com.google.monitoring.v3.ListNotificationChannelDescriptorsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListNotificationChannelDescriptorsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a single channel descriptor. The descriptor indicates which fields
     * are expected / permitted for a notification channel of the given type.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.monitoring.v3.NotificationChannelDescriptor> getNotificationChannelDescriptor(
        com.google.monitoring.v3.GetNotificationChannelDescriptorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNotificationChannelDescriptorMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists the notification channels that have been created for the project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.monitoring.v3.ListNotificationChannelsResponse> listNotificationChannels(
        com.google.monitoring.v3.ListNotificationChannelsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListNotificationChannelsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a single notification channel. The channel includes the relevant
     * configuration details with which the channel was created. However, the
     * response may truncate or omit passwords, API keys, or other private key
     * matter and thus the response may not be 100% identical to the information
     * that was supplied in the call to the create method.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.monitoring.v3.NotificationChannel> getNotificationChannel(
        com.google.monitoring.v3.GetNotificationChannelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNotificationChannelMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new notification channel, representing a single notification
     * endpoint such as an email address, SMS number, or PagerDuty service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.monitoring.v3.NotificationChannel> createNotificationChannel(
        com.google.monitoring.v3.CreateNotificationChannelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateNotificationChannelMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a notification channel. Fields not specified in the field mask
     * remain unchanged.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.monitoring.v3.NotificationChannel> updateNotificationChannel(
        com.google.monitoring.v3.UpdateNotificationChannelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateNotificationChannelMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a notification channel.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteNotificationChannel(
        com.google.monitoring.v3.DeleteNotificationChannelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteNotificationChannelMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Causes a verification code to be delivered to the channel. The code
     * can then be supplied in `VerifyNotificationChannel` to verify the channel.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> sendNotificationChannelVerificationCode(
        com.google.monitoring.v3.SendNotificationChannelVerificationCodeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendNotificationChannelVerificationCodeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Requests a verification code for an already verified channel that can then
     * be used in a call to VerifyNotificationChannel() on a different channel
     * with an equivalent identity in the same or in a different project. This
     * makes it possible to copy a channel between projects without requiring
     * manual reverification of the channel. If the channel is not in the
     * verified state, this method will fail (in other words, this may only be
     * used if the SendNotificationChannelVerificationCode and
     * VerifyNotificationChannel paths have already been used to put the given
     * channel into the verified state).
     * There is no guarantee that the verification codes returned by this method
     * will be of a similar structure or form as the ones that are delivered
     * to the channel via SendNotificationChannelVerificationCode; while
     * VerifyNotificationChannel() will recognize both the codes delivered via
     * SendNotificationChannelVerificationCode() and returned from
     * GetNotificationChannelVerificationCode(), it is typically the case that
     * the verification codes delivered via
     * SendNotificationChannelVerificationCode() will be shorter and also
     * have a shorter expiration (e.g. codes such as "G-123456") whereas
     * GetVerificationCode() will typically return a much longer, websafe base
     * 64 encoded string that has a longer expiration time.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.monitoring.v3.GetNotificationChannelVerificationCodeResponse> getNotificationChannelVerificationCode(
        com.google.monitoring.v3.GetNotificationChannelVerificationCodeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNotificationChannelVerificationCodeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Verifies a `NotificationChannel` by proving receipt of the code
     * delivered to the channel as a result of calling
     * `SendNotificationChannelVerificationCode`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.monitoring.v3.NotificationChannel> verifyNotificationChannel(
        com.google.monitoring.v3.VerifyNotificationChannelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getVerifyNotificationChannelMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_NOTIFICATION_CHANNEL_DESCRIPTORS = 0;
  private static final int METHODID_GET_NOTIFICATION_CHANNEL_DESCRIPTOR = 1;
  private static final int METHODID_LIST_NOTIFICATION_CHANNELS = 2;
  private static final int METHODID_GET_NOTIFICATION_CHANNEL = 3;
  private static final int METHODID_CREATE_NOTIFICATION_CHANNEL = 4;
  private static final int METHODID_UPDATE_NOTIFICATION_CHANNEL = 5;
  private static final int METHODID_DELETE_NOTIFICATION_CHANNEL = 6;
  private static final int METHODID_SEND_NOTIFICATION_CHANNEL_VERIFICATION_CODE = 7;
  private static final int METHODID_GET_NOTIFICATION_CHANNEL_VERIFICATION_CODE = 8;
  private static final int METHODID_VERIFY_NOTIFICATION_CHANNEL = 9;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final NotificationChannelServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(NotificationChannelServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_NOTIFICATION_CHANNEL_DESCRIPTORS:
          serviceImpl.listNotificationChannelDescriptors((com.google.monitoring.v3.ListNotificationChannelDescriptorsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.ListNotificationChannelDescriptorsResponse>) responseObserver);
          break;
        case METHODID_GET_NOTIFICATION_CHANNEL_DESCRIPTOR:
          serviceImpl.getNotificationChannelDescriptor((com.google.monitoring.v3.GetNotificationChannelDescriptorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.NotificationChannelDescriptor>) responseObserver);
          break;
        case METHODID_LIST_NOTIFICATION_CHANNELS:
          serviceImpl.listNotificationChannels((com.google.monitoring.v3.ListNotificationChannelsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.ListNotificationChannelsResponse>) responseObserver);
          break;
        case METHODID_GET_NOTIFICATION_CHANNEL:
          serviceImpl.getNotificationChannel((com.google.monitoring.v3.GetNotificationChannelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.NotificationChannel>) responseObserver);
          break;
        case METHODID_CREATE_NOTIFICATION_CHANNEL:
          serviceImpl.createNotificationChannel((com.google.monitoring.v3.CreateNotificationChannelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.NotificationChannel>) responseObserver);
          break;
        case METHODID_UPDATE_NOTIFICATION_CHANNEL:
          serviceImpl.updateNotificationChannel((com.google.monitoring.v3.UpdateNotificationChannelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.NotificationChannel>) responseObserver);
          break;
        case METHODID_DELETE_NOTIFICATION_CHANNEL:
          serviceImpl.deleteNotificationChannel((com.google.monitoring.v3.DeleteNotificationChannelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_SEND_NOTIFICATION_CHANNEL_VERIFICATION_CODE:
          serviceImpl.sendNotificationChannelVerificationCode((com.google.monitoring.v3.SendNotificationChannelVerificationCodeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_NOTIFICATION_CHANNEL_VERIFICATION_CODE:
          serviceImpl.getNotificationChannelVerificationCode((com.google.monitoring.v3.GetNotificationChannelVerificationCodeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.GetNotificationChannelVerificationCodeResponse>) responseObserver);
          break;
        case METHODID_VERIFY_NOTIFICATION_CHANNEL:
          serviceImpl.verifyNotificationChannel((com.google.monitoring.v3.VerifyNotificationChannelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.NotificationChannel>) responseObserver);
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

  private static abstract class NotificationChannelServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NotificationChannelServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.monitoring.v3.NotificationServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("NotificationChannelService");
    }
  }

  private static final class NotificationChannelServiceFileDescriptorSupplier
      extends NotificationChannelServiceBaseDescriptorSupplier {
    NotificationChannelServiceFileDescriptorSupplier() {}
  }

  private static final class NotificationChannelServiceMethodDescriptorSupplier
      extends NotificationChannelServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    NotificationChannelServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (NotificationChannelServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new NotificationChannelServiceFileDescriptorSupplier())
              .addMethod(getListNotificationChannelDescriptorsMethod())
              .addMethod(getGetNotificationChannelDescriptorMethod())
              .addMethod(getListNotificationChannelsMethod())
              .addMethod(getGetNotificationChannelMethod())
              .addMethod(getCreateNotificationChannelMethod())
              .addMethod(getUpdateNotificationChannelMethod())
              .addMethod(getDeleteNotificationChannelMethod())
              .addMethod(getSendNotificationChannelVerificationCodeMethod())
              .addMethod(getGetNotificationChannelVerificationCodeMethod())
              .addMethod(getVerifyNotificationChannelMethod())
              .build();
        }
      }
    }
    return result;
  }
}
