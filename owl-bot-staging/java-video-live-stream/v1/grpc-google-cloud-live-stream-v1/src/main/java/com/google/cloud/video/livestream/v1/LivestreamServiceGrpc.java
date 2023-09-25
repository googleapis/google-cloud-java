package com.google.cloud.video.livestream.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Using Live Stream API, you can generate live streams in the various
 * renditions and streaming formats. The streaming format include HTTP Live
 * Streaming (HLS) and Dynamic Adaptive Streaming over HTTP (DASH). You can send
 * a source stream in the various ways, including Real-Time Messaging
 * Protocol (RTMP) and Secure Reliable Transport (SRT).
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/video/livestream/v1/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LivestreamServiceGrpc {

  private LivestreamServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.video.livestream.v1.LivestreamService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.CreateChannelRequest,
      com.google.longrunning.Operation> getCreateChannelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateChannel",
      requestType = com.google.cloud.video.livestream.v1.CreateChannelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.CreateChannelRequest,
      com.google.longrunning.Operation> getCreateChannelMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.CreateChannelRequest, com.google.longrunning.Operation> getCreateChannelMethod;
    if ((getCreateChannelMethod = LivestreamServiceGrpc.getCreateChannelMethod) == null) {
      synchronized (LivestreamServiceGrpc.class) {
        if ((getCreateChannelMethod = LivestreamServiceGrpc.getCreateChannelMethod) == null) {
          LivestreamServiceGrpc.getCreateChannelMethod = getCreateChannelMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.video.livestream.v1.CreateChannelRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateChannel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.video.livestream.v1.CreateChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new LivestreamServiceMethodDescriptorSupplier("CreateChannel"))
              .build();
        }
      }
    }
    return getCreateChannelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.ListChannelsRequest,
      com.google.cloud.video.livestream.v1.ListChannelsResponse> getListChannelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListChannels",
      requestType = com.google.cloud.video.livestream.v1.ListChannelsRequest.class,
      responseType = com.google.cloud.video.livestream.v1.ListChannelsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.ListChannelsRequest,
      com.google.cloud.video.livestream.v1.ListChannelsResponse> getListChannelsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.ListChannelsRequest, com.google.cloud.video.livestream.v1.ListChannelsResponse> getListChannelsMethod;
    if ((getListChannelsMethod = LivestreamServiceGrpc.getListChannelsMethod) == null) {
      synchronized (LivestreamServiceGrpc.class) {
        if ((getListChannelsMethod = LivestreamServiceGrpc.getListChannelsMethod) == null) {
          LivestreamServiceGrpc.getListChannelsMethod = getListChannelsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.video.livestream.v1.ListChannelsRequest, com.google.cloud.video.livestream.v1.ListChannelsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListChannels"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.video.livestream.v1.ListChannelsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.video.livestream.v1.ListChannelsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LivestreamServiceMethodDescriptorSupplier("ListChannels"))
              .build();
        }
      }
    }
    return getListChannelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.GetChannelRequest,
      com.google.cloud.video.livestream.v1.Channel> getGetChannelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetChannel",
      requestType = com.google.cloud.video.livestream.v1.GetChannelRequest.class,
      responseType = com.google.cloud.video.livestream.v1.Channel.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.GetChannelRequest,
      com.google.cloud.video.livestream.v1.Channel> getGetChannelMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.GetChannelRequest, com.google.cloud.video.livestream.v1.Channel> getGetChannelMethod;
    if ((getGetChannelMethod = LivestreamServiceGrpc.getGetChannelMethod) == null) {
      synchronized (LivestreamServiceGrpc.class) {
        if ((getGetChannelMethod = LivestreamServiceGrpc.getGetChannelMethod) == null) {
          LivestreamServiceGrpc.getGetChannelMethod = getGetChannelMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.video.livestream.v1.GetChannelRequest, com.google.cloud.video.livestream.v1.Channel>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetChannel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.video.livestream.v1.GetChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.video.livestream.v1.Channel.getDefaultInstance()))
              .setSchemaDescriptor(new LivestreamServiceMethodDescriptorSupplier("GetChannel"))
              .build();
        }
      }
    }
    return getGetChannelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.DeleteChannelRequest,
      com.google.longrunning.Operation> getDeleteChannelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteChannel",
      requestType = com.google.cloud.video.livestream.v1.DeleteChannelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.DeleteChannelRequest,
      com.google.longrunning.Operation> getDeleteChannelMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.DeleteChannelRequest, com.google.longrunning.Operation> getDeleteChannelMethod;
    if ((getDeleteChannelMethod = LivestreamServiceGrpc.getDeleteChannelMethod) == null) {
      synchronized (LivestreamServiceGrpc.class) {
        if ((getDeleteChannelMethod = LivestreamServiceGrpc.getDeleteChannelMethod) == null) {
          LivestreamServiceGrpc.getDeleteChannelMethod = getDeleteChannelMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.video.livestream.v1.DeleteChannelRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteChannel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.video.livestream.v1.DeleteChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new LivestreamServiceMethodDescriptorSupplier("DeleteChannel"))
              .build();
        }
      }
    }
    return getDeleteChannelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.UpdateChannelRequest,
      com.google.longrunning.Operation> getUpdateChannelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateChannel",
      requestType = com.google.cloud.video.livestream.v1.UpdateChannelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.UpdateChannelRequest,
      com.google.longrunning.Operation> getUpdateChannelMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.UpdateChannelRequest, com.google.longrunning.Operation> getUpdateChannelMethod;
    if ((getUpdateChannelMethod = LivestreamServiceGrpc.getUpdateChannelMethod) == null) {
      synchronized (LivestreamServiceGrpc.class) {
        if ((getUpdateChannelMethod = LivestreamServiceGrpc.getUpdateChannelMethod) == null) {
          LivestreamServiceGrpc.getUpdateChannelMethod = getUpdateChannelMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.video.livestream.v1.UpdateChannelRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateChannel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.video.livestream.v1.UpdateChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new LivestreamServiceMethodDescriptorSupplier("UpdateChannel"))
              .build();
        }
      }
    }
    return getUpdateChannelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.StartChannelRequest,
      com.google.longrunning.Operation> getStartChannelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartChannel",
      requestType = com.google.cloud.video.livestream.v1.StartChannelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.StartChannelRequest,
      com.google.longrunning.Operation> getStartChannelMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.StartChannelRequest, com.google.longrunning.Operation> getStartChannelMethod;
    if ((getStartChannelMethod = LivestreamServiceGrpc.getStartChannelMethod) == null) {
      synchronized (LivestreamServiceGrpc.class) {
        if ((getStartChannelMethod = LivestreamServiceGrpc.getStartChannelMethod) == null) {
          LivestreamServiceGrpc.getStartChannelMethod = getStartChannelMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.video.livestream.v1.StartChannelRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartChannel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.video.livestream.v1.StartChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new LivestreamServiceMethodDescriptorSupplier("StartChannel"))
              .build();
        }
      }
    }
    return getStartChannelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.StopChannelRequest,
      com.google.longrunning.Operation> getStopChannelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopChannel",
      requestType = com.google.cloud.video.livestream.v1.StopChannelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.StopChannelRequest,
      com.google.longrunning.Operation> getStopChannelMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.StopChannelRequest, com.google.longrunning.Operation> getStopChannelMethod;
    if ((getStopChannelMethod = LivestreamServiceGrpc.getStopChannelMethod) == null) {
      synchronized (LivestreamServiceGrpc.class) {
        if ((getStopChannelMethod = LivestreamServiceGrpc.getStopChannelMethod) == null) {
          LivestreamServiceGrpc.getStopChannelMethod = getStopChannelMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.video.livestream.v1.StopChannelRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopChannel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.video.livestream.v1.StopChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new LivestreamServiceMethodDescriptorSupplier("StopChannel"))
              .build();
        }
      }
    }
    return getStopChannelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.CreateInputRequest,
      com.google.longrunning.Operation> getCreateInputMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateInput",
      requestType = com.google.cloud.video.livestream.v1.CreateInputRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.CreateInputRequest,
      com.google.longrunning.Operation> getCreateInputMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.CreateInputRequest, com.google.longrunning.Operation> getCreateInputMethod;
    if ((getCreateInputMethod = LivestreamServiceGrpc.getCreateInputMethod) == null) {
      synchronized (LivestreamServiceGrpc.class) {
        if ((getCreateInputMethod = LivestreamServiceGrpc.getCreateInputMethod) == null) {
          LivestreamServiceGrpc.getCreateInputMethod = getCreateInputMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.video.livestream.v1.CreateInputRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateInput"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.video.livestream.v1.CreateInputRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new LivestreamServiceMethodDescriptorSupplier("CreateInput"))
              .build();
        }
      }
    }
    return getCreateInputMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.ListInputsRequest,
      com.google.cloud.video.livestream.v1.ListInputsResponse> getListInputsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInputs",
      requestType = com.google.cloud.video.livestream.v1.ListInputsRequest.class,
      responseType = com.google.cloud.video.livestream.v1.ListInputsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.ListInputsRequest,
      com.google.cloud.video.livestream.v1.ListInputsResponse> getListInputsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.ListInputsRequest, com.google.cloud.video.livestream.v1.ListInputsResponse> getListInputsMethod;
    if ((getListInputsMethod = LivestreamServiceGrpc.getListInputsMethod) == null) {
      synchronized (LivestreamServiceGrpc.class) {
        if ((getListInputsMethod = LivestreamServiceGrpc.getListInputsMethod) == null) {
          LivestreamServiceGrpc.getListInputsMethod = getListInputsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.video.livestream.v1.ListInputsRequest, com.google.cloud.video.livestream.v1.ListInputsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListInputs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.video.livestream.v1.ListInputsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.video.livestream.v1.ListInputsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LivestreamServiceMethodDescriptorSupplier("ListInputs"))
              .build();
        }
      }
    }
    return getListInputsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.GetInputRequest,
      com.google.cloud.video.livestream.v1.Input> getGetInputMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInput",
      requestType = com.google.cloud.video.livestream.v1.GetInputRequest.class,
      responseType = com.google.cloud.video.livestream.v1.Input.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.GetInputRequest,
      com.google.cloud.video.livestream.v1.Input> getGetInputMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.GetInputRequest, com.google.cloud.video.livestream.v1.Input> getGetInputMethod;
    if ((getGetInputMethod = LivestreamServiceGrpc.getGetInputMethod) == null) {
      synchronized (LivestreamServiceGrpc.class) {
        if ((getGetInputMethod = LivestreamServiceGrpc.getGetInputMethod) == null) {
          LivestreamServiceGrpc.getGetInputMethod = getGetInputMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.video.livestream.v1.GetInputRequest, com.google.cloud.video.livestream.v1.Input>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInput"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.video.livestream.v1.GetInputRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.video.livestream.v1.Input.getDefaultInstance()))
              .setSchemaDescriptor(new LivestreamServiceMethodDescriptorSupplier("GetInput"))
              .build();
        }
      }
    }
    return getGetInputMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.DeleteInputRequest,
      com.google.longrunning.Operation> getDeleteInputMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteInput",
      requestType = com.google.cloud.video.livestream.v1.DeleteInputRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.DeleteInputRequest,
      com.google.longrunning.Operation> getDeleteInputMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.DeleteInputRequest, com.google.longrunning.Operation> getDeleteInputMethod;
    if ((getDeleteInputMethod = LivestreamServiceGrpc.getDeleteInputMethod) == null) {
      synchronized (LivestreamServiceGrpc.class) {
        if ((getDeleteInputMethod = LivestreamServiceGrpc.getDeleteInputMethod) == null) {
          LivestreamServiceGrpc.getDeleteInputMethod = getDeleteInputMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.video.livestream.v1.DeleteInputRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteInput"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.video.livestream.v1.DeleteInputRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new LivestreamServiceMethodDescriptorSupplier("DeleteInput"))
              .build();
        }
      }
    }
    return getDeleteInputMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.UpdateInputRequest,
      com.google.longrunning.Operation> getUpdateInputMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateInput",
      requestType = com.google.cloud.video.livestream.v1.UpdateInputRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.UpdateInputRequest,
      com.google.longrunning.Operation> getUpdateInputMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.UpdateInputRequest, com.google.longrunning.Operation> getUpdateInputMethod;
    if ((getUpdateInputMethod = LivestreamServiceGrpc.getUpdateInputMethod) == null) {
      synchronized (LivestreamServiceGrpc.class) {
        if ((getUpdateInputMethod = LivestreamServiceGrpc.getUpdateInputMethod) == null) {
          LivestreamServiceGrpc.getUpdateInputMethod = getUpdateInputMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.video.livestream.v1.UpdateInputRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateInput"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.video.livestream.v1.UpdateInputRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new LivestreamServiceMethodDescriptorSupplier("UpdateInput"))
              .build();
        }
      }
    }
    return getUpdateInputMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.CreateEventRequest,
      com.google.cloud.video.livestream.v1.Event> getCreateEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEvent",
      requestType = com.google.cloud.video.livestream.v1.CreateEventRequest.class,
      responseType = com.google.cloud.video.livestream.v1.Event.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.CreateEventRequest,
      com.google.cloud.video.livestream.v1.Event> getCreateEventMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.CreateEventRequest, com.google.cloud.video.livestream.v1.Event> getCreateEventMethod;
    if ((getCreateEventMethod = LivestreamServiceGrpc.getCreateEventMethod) == null) {
      synchronized (LivestreamServiceGrpc.class) {
        if ((getCreateEventMethod = LivestreamServiceGrpc.getCreateEventMethod) == null) {
          LivestreamServiceGrpc.getCreateEventMethod = getCreateEventMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.video.livestream.v1.CreateEventRequest, com.google.cloud.video.livestream.v1.Event>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateEvent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.video.livestream.v1.CreateEventRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.video.livestream.v1.Event.getDefaultInstance()))
              .setSchemaDescriptor(new LivestreamServiceMethodDescriptorSupplier("CreateEvent"))
              .build();
        }
      }
    }
    return getCreateEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.ListEventsRequest,
      com.google.cloud.video.livestream.v1.ListEventsResponse> getListEventsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEvents",
      requestType = com.google.cloud.video.livestream.v1.ListEventsRequest.class,
      responseType = com.google.cloud.video.livestream.v1.ListEventsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.ListEventsRequest,
      com.google.cloud.video.livestream.v1.ListEventsResponse> getListEventsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.ListEventsRequest, com.google.cloud.video.livestream.v1.ListEventsResponse> getListEventsMethod;
    if ((getListEventsMethod = LivestreamServiceGrpc.getListEventsMethod) == null) {
      synchronized (LivestreamServiceGrpc.class) {
        if ((getListEventsMethod = LivestreamServiceGrpc.getListEventsMethod) == null) {
          LivestreamServiceGrpc.getListEventsMethod = getListEventsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.video.livestream.v1.ListEventsRequest, com.google.cloud.video.livestream.v1.ListEventsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEvents"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.video.livestream.v1.ListEventsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.video.livestream.v1.ListEventsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LivestreamServiceMethodDescriptorSupplier("ListEvents"))
              .build();
        }
      }
    }
    return getListEventsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.GetEventRequest,
      com.google.cloud.video.livestream.v1.Event> getGetEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEvent",
      requestType = com.google.cloud.video.livestream.v1.GetEventRequest.class,
      responseType = com.google.cloud.video.livestream.v1.Event.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.GetEventRequest,
      com.google.cloud.video.livestream.v1.Event> getGetEventMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.GetEventRequest, com.google.cloud.video.livestream.v1.Event> getGetEventMethod;
    if ((getGetEventMethod = LivestreamServiceGrpc.getGetEventMethod) == null) {
      synchronized (LivestreamServiceGrpc.class) {
        if ((getGetEventMethod = LivestreamServiceGrpc.getGetEventMethod) == null) {
          LivestreamServiceGrpc.getGetEventMethod = getGetEventMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.video.livestream.v1.GetEventRequest, com.google.cloud.video.livestream.v1.Event>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEvent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.video.livestream.v1.GetEventRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.video.livestream.v1.Event.getDefaultInstance()))
              .setSchemaDescriptor(new LivestreamServiceMethodDescriptorSupplier("GetEvent"))
              .build();
        }
      }
    }
    return getGetEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.DeleteEventRequest,
      com.google.protobuf.Empty> getDeleteEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEvent",
      requestType = com.google.cloud.video.livestream.v1.DeleteEventRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.DeleteEventRequest,
      com.google.protobuf.Empty> getDeleteEventMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.DeleteEventRequest, com.google.protobuf.Empty> getDeleteEventMethod;
    if ((getDeleteEventMethod = LivestreamServiceGrpc.getDeleteEventMethod) == null) {
      synchronized (LivestreamServiceGrpc.class) {
        if ((getDeleteEventMethod = LivestreamServiceGrpc.getDeleteEventMethod) == null) {
          LivestreamServiceGrpc.getDeleteEventMethod = getDeleteEventMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.video.livestream.v1.DeleteEventRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteEvent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.video.livestream.v1.DeleteEventRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new LivestreamServiceMethodDescriptorSupplier("DeleteEvent"))
              .build();
        }
      }
    }
    return getDeleteEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.CreateAssetRequest,
      com.google.longrunning.Operation> getCreateAssetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAsset",
      requestType = com.google.cloud.video.livestream.v1.CreateAssetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.CreateAssetRequest,
      com.google.longrunning.Operation> getCreateAssetMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.CreateAssetRequest, com.google.longrunning.Operation> getCreateAssetMethod;
    if ((getCreateAssetMethod = LivestreamServiceGrpc.getCreateAssetMethod) == null) {
      synchronized (LivestreamServiceGrpc.class) {
        if ((getCreateAssetMethod = LivestreamServiceGrpc.getCreateAssetMethod) == null) {
          LivestreamServiceGrpc.getCreateAssetMethod = getCreateAssetMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.video.livestream.v1.CreateAssetRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAsset"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.video.livestream.v1.CreateAssetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new LivestreamServiceMethodDescriptorSupplier("CreateAsset"))
              .build();
        }
      }
    }
    return getCreateAssetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.DeleteAssetRequest,
      com.google.longrunning.Operation> getDeleteAssetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAsset",
      requestType = com.google.cloud.video.livestream.v1.DeleteAssetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.DeleteAssetRequest,
      com.google.longrunning.Operation> getDeleteAssetMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.DeleteAssetRequest, com.google.longrunning.Operation> getDeleteAssetMethod;
    if ((getDeleteAssetMethod = LivestreamServiceGrpc.getDeleteAssetMethod) == null) {
      synchronized (LivestreamServiceGrpc.class) {
        if ((getDeleteAssetMethod = LivestreamServiceGrpc.getDeleteAssetMethod) == null) {
          LivestreamServiceGrpc.getDeleteAssetMethod = getDeleteAssetMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.video.livestream.v1.DeleteAssetRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAsset"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.video.livestream.v1.DeleteAssetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new LivestreamServiceMethodDescriptorSupplier("DeleteAsset"))
              .build();
        }
      }
    }
    return getDeleteAssetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.GetAssetRequest,
      com.google.cloud.video.livestream.v1.Asset> getGetAssetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAsset",
      requestType = com.google.cloud.video.livestream.v1.GetAssetRequest.class,
      responseType = com.google.cloud.video.livestream.v1.Asset.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.GetAssetRequest,
      com.google.cloud.video.livestream.v1.Asset> getGetAssetMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.GetAssetRequest, com.google.cloud.video.livestream.v1.Asset> getGetAssetMethod;
    if ((getGetAssetMethod = LivestreamServiceGrpc.getGetAssetMethod) == null) {
      synchronized (LivestreamServiceGrpc.class) {
        if ((getGetAssetMethod = LivestreamServiceGrpc.getGetAssetMethod) == null) {
          LivestreamServiceGrpc.getGetAssetMethod = getGetAssetMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.video.livestream.v1.GetAssetRequest, com.google.cloud.video.livestream.v1.Asset>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAsset"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.video.livestream.v1.GetAssetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.video.livestream.v1.Asset.getDefaultInstance()))
              .setSchemaDescriptor(new LivestreamServiceMethodDescriptorSupplier("GetAsset"))
              .build();
        }
      }
    }
    return getGetAssetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.ListAssetsRequest,
      com.google.cloud.video.livestream.v1.ListAssetsResponse> getListAssetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAssets",
      requestType = com.google.cloud.video.livestream.v1.ListAssetsRequest.class,
      responseType = com.google.cloud.video.livestream.v1.ListAssetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.ListAssetsRequest,
      com.google.cloud.video.livestream.v1.ListAssetsResponse> getListAssetsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.ListAssetsRequest, com.google.cloud.video.livestream.v1.ListAssetsResponse> getListAssetsMethod;
    if ((getListAssetsMethod = LivestreamServiceGrpc.getListAssetsMethod) == null) {
      synchronized (LivestreamServiceGrpc.class) {
        if ((getListAssetsMethod = LivestreamServiceGrpc.getListAssetsMethod) == null) {
          LivestreamServiceGrpc.getListAssetsMethod = getListAssetsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.video.livestream.v1.ListAssetsRequest, com.google.cloud.video.livestream.v1.ListAssetsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAssets"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.video.livestream.v1.ListAssetsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.video.livestream.v1.ListAssetsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LivestreamServiceMethodDescriptorSupplier("ListAssets"))
              .build();
        }
      }
    }
    return getListAssetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.GetPoolRequest,
      com.google.cloud.video.livestream.v1.Pool> getGetPoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPool",
      requestType = com.google.cloud.video.livestream.v1.GetPoolRequest.class,
      responseType = com.google.cloud.video.livestream.v1.Pool.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.GetPoolRequest,
      com.google.cloud.video.livestream.v1.Pool> getGetPoolMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.GetPoolRequest, com.google.cloud.video.livestream.v1.Pool> getGetPoolMethod;
    if ((getGetPoolMethod = LivestreamServiceGrpc.getGetPoolMethod) == null) {
      synchronized (LivestreamServiceGrpc.class) {
        if ((getGetPoolMethod = LivestreamServiceGrpc.getGetPoolMethod) == null) {
          LivestreamServiceGrpc.getGetPoolMethod = getGetPoolMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.video.livestream.v1.GetPoolRequest, com.google.cloud.video.livestream.v1.Pool>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.video.livestream.v1.GetPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.video.livestream.v1.Pool.getDefaultInstance()))
              .setSchemaDescriptor(new LivestreamServiceMethodDescriptorSupplier("GetPool"))
              .build();
        }
      }
    }
    return getGetPoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.UpdatePoolRequest,
      com.google.longrunning.Operation> getUpdatePoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePool",
      requestType = com.google.cloud.video.livestream.v1.UpdatePoolRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.UpdatePoolRequest,
      com.google.longrunning.Operation> getUpdatePoolMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.video.livestream.v1.UpdatePoolRequest, com.google.longrunning.Operation> getUpdatePoolMethod;
    if ((getUpdatePoolMethod = LivestreamServiceGrpc.getUpdatePoolMethod) == null) {
      synchronized (LivestreamServiceGrpc.class) {
        if ((getUpdatePoolMethod = LivestreamServiceGrpc.getUpdatePoolMethod) == null) {
          LivestreamServiceGrpc.getUpdatePoolMethod = getUpdatePoolMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.video.livestream.v1.UpdatePoolRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdatePool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.video.livestream.v1.UpdatePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new LivestreamServiceMethodDescriptorSupplier("UpdatePool"))
              .build();
        }
      }
    }
    return getUpdatePoolMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LivestreamServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LivestreamServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LivestreamServiceStub>() {
        @java.lang.Override
        public LivestreamServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LivestreamServiceStub(channel, callOptions);
        }
      };
    return LivestreamServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LivestreamServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LivestreamServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LivestreamServiceBlockingStub>() {
        @java.lang.Override
        public LivestreamServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LivestreamServiceBlockingStub(channel, callOptions);
        }
      };
    return LivestreamServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LivestreamServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LivestreamServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LivestreamServiceFutureStub>() {
        @java.lang.Override
        public LivestreamServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LivestreamServiceFutureStub(channel, callOptions);
        }
      };
    return LivestreamServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Using Live Stream API, you can generate live streams in the various
   * renditions and streaming formats. The streaming format include HTTP Live
   * Streaming (HLS) and Dynamic Adaptive Streaming over HTTP (DASH). You can send
   * a source stream in the various ways, including Real-Time Messaging
   * Protocol (RTMP) and Secure Reliable Transport (SRT).
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Creates a channel with the provided unique ID in the specified
     * region.
     * </pre>
     */
    default void createChannel(com.google.cloud.video.livestream.v1.CreateChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateChannelMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns a list of all channels in the specified region.
     * </pre>
     */
    default void listChannels(com.google.cloud.video.livestream.v1.ListChannelsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.livestream.v1.ListChannelsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListChannelsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns the specified channel.
     * </pre>
     */
    default void getChannel(com.google.cloud.video.livestream.v1.GetChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.livestream.v1.Channel> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetChannelMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified channel.
     * </pre>
     */
    default void deleteChannel(com.google.cloud.video.livestream.v1.DeleteChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteChannelMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the specified channel.
     * </pre>
     */
    default void updateChannel(com.google.cloud.video.livestream.v1.UpdateChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateChannelMethod(), responseObserver);
    }

    /**
     * <pre>
     * Starts the specified channel. Part of the video pipeline will be created
     * only when the StartChannel request is received by the server.
     * </pre>
     */
    default void startChannel(com.google.cloud.video.livestream.v1.StartChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartChannelMethod(), responseObserver);
    }

    /**
     * <pre>
     * Stops the specified channel. Part of the video pipeline will be released
     * when the StopChannel request is received by the server.
     * </pre>
     */
    default void stopChannel(com.google.cloud.video.livestream.v1.StopChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStopChannelMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates an input with the provided unique ID in the specified region.
     * </pre>
     */
    default void createInput(com.google.cloud.video.livestream.v1.CreateInputRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateInputMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns a list of all inputs in the specified region.
     * </pre>
     */
    default void listInputs(com.google.cloud.video.livestream.v1.ListInputsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.livestream.v1.ListInputsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListInputsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns the specified input.
     * </pre>
     */
    default void getInput(com.google.cloud.video.livestream.v1.GetInputRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.livestream.v1.Input> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetInputMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified input.
     * </pre>
     */
    default void deleteInput(com.google.cloud.video.livestream.v1.DeleteInputRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteInputMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the specified input.
     * </pre>
     */
    default void updateInput(com.google.cloud.video.livestream.v1.UpdateInputRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateInputMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates an event with the provided unique ID in the specified channel.
     * </pre>
     */
    default void createEvent(com.google.cloud.video.livestream.v1.CreateEventRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.livestream.v1.Event> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateEventMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns a list of all events in the specified channel.
     * </pre>
     */
    default void listEvents(com.google.cloud.video.livestream.v1.ListEventsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.livestream.v1.ListEventsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListEventsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns the specified event.
     * </pre>
     */
    default void getEvent(com.google.cloud.video.livestream.v1.GetEventRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.livestream.v1.Event> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetEventMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified event.
     * </pre>
     */
    default void deleteEvent(com.google.cloud.video.livestream.v1.DeleteEventRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteEventMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a Asset with the provided unique ID in the specified
     * region.
     * </pre>
     */
    default void createAsset(com.google.cloud.video.livestream.v1.CreateAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateAssetMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified asset if it is not used.
     * </pre>
     */
    default void deleteAsset(com.google.cloud.video.livestream.v1.DeleteAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteAssetMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns the specified asset.
     * </pre>
     */
    default void getAsset(com.google.cloud.video.livestream.v1.GetAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.livestream.v1.Asset> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAssetMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns a list of all assets in the specified region.
     * </pre>
     */
    default void listAssets(com.google.cloud.video.livestream.v1.ListAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.livestream.v1.ListAssetsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAssetsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns the specified pool.
     * </pre>
     */
    default void getPool(com.google.cloud.video.livestream.v1.GetPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.livestream.v1.Pool> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPoolMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the specified pool.
     * </pre>
     */
    default void updatePool(com.google.cloud.video.livestream.v1.UpdatePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdatePoolMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service LivestreamService.
   * <pre>
   * Using Live Stream API, you can generate live streams in the various
   * renditions and streaming formats. The streaming format include HTTP Live
   * Streaming (HLS) and Dynamic Adaptive Streaming over HTTP (DASH). You can send
   * a source stream in the various ways, including Real-Time Messaging
   * Protocol (RTMP) and Secure Reliable Transport (SRT).
   * </pre>
   */
  public static abstract class LivestreamServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return LivestreamServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service LivestreamService.
   * <pre>
   * Using Live Stream API, you can generate live streams in the various
   * renditions and streaming formats. The streaming format include HTTP Live
   * Streaming (HLS) and Dynamic Adaptive Streaming over HTTP (DASH). You can send
   * a source stream in the various ways, including Real-Time Messaging
   * Protocol (RTMP) and Secure Reliable Transport (SRT).
   * </pre>
   */
  public static final class LivestreamServiceStub
      extends io.grpc.stub.AbstractAsyncStub<LivestreamServiceStub> {
    private LivestreamServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LivestreamServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LivestreamServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a channel with the provided unique ID in the specified
     * region.
     * </pre>
     */
    public void createChannel(com.google.cloud.video.livestream.v1.CreateChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateChannelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns a list of all channels in the specified region.
     * </pre>
     */
    public void listChannels(com.google.cloud.video.livestream.v1.ListChannelsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.livestream.v1.ListChannelsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListChannelsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns the specified channel.
     * </pre>
     */
    public void getChannel(com.google.cloud.video.livestream.v1.GetChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.livestream.v1.Channel> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetChannelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified channel.
     * </pre>
     */
    public void deleteChannel(com.google.cloud.video.livestream.v1.DeleteChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteChannelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the specified channel.
     * </pre>
     */
    public void updateChannel(com.google.cloud.video.livestream.v1.UpdateChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateChannelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Starts the specified channel. Part of the video pipeline will be created
     * only when the StartChannel request is received by the server.
     * </pre>
     */
    public void startChannel(com.google.cloud.video.livestream.v1.StartChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartChannelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Stops the specified channel. Part of the video pipeline will be released
     * when the StopChannel request is received by the server.
     * </pre>
     */
    public void stopChannel(com.google.cloud.video.livestream.v1.StopChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopChannelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates an input with the provided unique ID in the specified region.
     * </pre>
     */
    public void createInput(com.google.cloud.video.livestream.v1.CreateInputRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateInputMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns a list of all inputs in the specified region.
     * </pre>
     */
    public void listInputs(com.google.cloud.video.livestream.v1.ListInputsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.livestream.v1.ListInputsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListInputsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns the specified input.
     * </pre>
     */
    public void getInput(com.google.cloud.video.livestream.v1.GetInputRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.livestream.v1.Input> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInputMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified input.
     * </pre>
     */
    public void deleteInput(com.google.cloud.video.livestream.v1.DeleteInputRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteInputMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the specified input.
     * </pre>
     */
    public void updateInput(com.google.cloud.video.livestream.v1.UpdateInputRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateInputMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates an event with the provided unique ID in the specified channel.
     * </pre>
     */
    public void createEvent(com.google.cloud.video.livestream.v1.CreateEventRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.livestream.v1.Event> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEventMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns a list of all events in the specified channel.
     * </pre>
     */
    public void listEvents(com.google.cloud.video.livestream.v1.ListEventsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.livestream.v1.ListEventsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEventsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns the specified event.
     * </pre>
     */
    public void getEvent(com.google.cloud.video.livestream.v1.GetEventRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.livestream.v1.Event> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEventMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified event.
     * </pre>
     */
    public void deleteEvent(com.google.cloud.video.livestream.v1.DeleteEventRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEventMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a Asset with the provided unique ID in the specified
     * region.
     * </pre>
     */
    public void createAsset(com.google.cloud.video.livestream.v1.CreateAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAssetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified asset if it is not used.
     * </pre>
     */
    public void deleteAsset(com.google.cloud.video.livestream.v1.DeleteAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAssetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns the specified asset.
     * </pre>
     */
    public void getAsset(com.google.cloud.video.livestream.v1.GetAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.livestream.v1.Asset> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAssetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns a list of all assets in the specified region.
     * </pre>
     */
    public void listAssets(com.google.cloud.video.livestream.v1.ListAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.livestream.v1.ListAssetsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAssetsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns the specified pool.
     * </pre>
     */
    public void getPool(com.google.cloud.video.livestream.v1.GetPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.livestream.v1.Pool> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPoolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the specified pool.
     * </pre>
     */
    public void updatePool(com.google.cloud.video.livestream.v1.UpdatePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePoolMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service LivestreamService.
   * <pre>
   * Using Live Stream API, you can generate live streams in the various
   * renditions and streaming formats. The streaming format include HTTP Live
   * Streaming (HLS) and Dynamic Adaptive Streaming over HTTP (DASH). You can send
   * a source stream in the various ways, including Real-Time Messaging
   * Protocol (RTMP) and Secure Reliable Transport (SRT).
   * </pre>
   */
  public static final class LivestreamServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LivestreamServiceBlockingStub> {
    private LivestreamServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LivestreamServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LivestreamServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a channel with the provided unique ID in the specified
     * region.
     * </pre>
     */
    public com.google.longrunning.Operation createChannel(com.google.cloud.video.livestream.v1.CreateChannelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateChannelMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns a list of all channels in the specified region.
     * </pre>
     */
    public com.google.cloud.video.livestream.v1.ListChannelsResponse listChannels(com.google.cloud.video.livestream.v1.ListChannelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListChannelsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns the specified channel.
     * </pre>
     */
    public com.google.cloud.video.livestream.v1.Channel getChannel(com.google.cloud.video.livestream.v1.GetChannelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetChannelMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the specified channel.
     * </pre>
     */
    public com.google.longrunning.Operation deleteChannel(com.google.cloud.video.livestream.v1.DeleteChannelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteChannelMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the specified channel.
     * </pre>
     */
    public com.google.longrunning.Operation updateChannel(com.google.cloud.video.livestream.v1.UpdateChannelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateChannelMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Starts the specified channel. Part of the video pipeline will be created
     * only when the StartChannel request is received by the server.
     * </pre>
     */
    public com.google.longrunning.Operation startChannel(com.google.cloud.video.livestream.v1.StartChannelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartChannelMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Stops the specified channel. Part of the video pipeline will be released
     * when the StopChannel request is received by the server.
     * </pre>
     */
    public com.google.longrunning.Operation stopChannel(com.google.cloud.video.livestream.v1.StopChannelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopChannelMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates an input with the provided unique ID in the specified region.
     * </pre>
     */
    public com.google.longrunning.Operation createInput(com.google.cloud.video.livestream.v1.CreateInputRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateInputMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns a list of all inputs in the specified region.
     * </pre>
     */
    public com.google.cloud.video.livestream.v1.ListInputsResponse listInputs(com.google.cloud.video.livestream.v1.ListInputsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInputsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns the specified input.
     * </pre>
     */
    public com.google.cloud.video.livestream.v1.Input getInput(com.google.cloud.video.livestream.v1.GetInputRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInputMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the specified input.
     * </pre>
     */
    public com.google.longrunning.Operation deleteInput(com.google.cloud.video.livestream.v1.DeleteInputRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteInputMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the specified input.
     * </pre>
     */
    public com.google.longrunning.Operation updateInput(com.google.cloud.video.livestream.v1.UpdateInputRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateInputMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates an event with the provided unique ID in the specified channel.
     * </pre>
     */
    public com.google.cloud.video.livestream.v1.Event createEvent(com.google.cloud.video.livestream.v1.CreateEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEventMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns a list of all events in the specified channel.
     * </pre>
     */
    public com.google.cloud.video.livestream.v1.ListEventsResponse listEvents(com.google.cloud.video.livestream.v1.ListEventsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEventsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns the specified event.
     * </pre>
     */
    public com.google.cloud.video.livestream.v1.Event getEvent(com.google.cloud.video.livestream.v1.GetEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEventMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the specified event.
     * </pre>
     */
    public com.google.protobuf.Empty deleteEvent(com.google.cloud.video.livestream.v1.DeleteEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEventMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a Asset with the provided unique ID in the specified
     * region.
     * </pre>
     */
    public com.google.longrunning.Operation createAsset(com.google.cloud.video.livestream.v1.CreateAssetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAssetMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the specified asset if it is not used.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAsset(com.google.cloud.video.livestream.v1.DeleteAssetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAssetMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns the specified asset.
     * </pre>
     */
    public com.google.cloud.video.livestream.v1.Asset getAsset(com.google.cloud.video.livestream.v1.GetAssetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAssetMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns a list of all assets in the specified region.
     * </pre>
     */
    public com.google.cloud.video.livestream.v1.ListAssetsResponse listAssets(com.google.cloud.video.livestream.v1.ListAssetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAssetsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns the specified pool.
     * </pre>
     */
    public com.google.cloud.video.livestream.v1.Pool getPool(com.google.cloud.video.livestream.v1.GetPoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPoolMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the specified pool.
     * </pre>
     */
    public com.google.longrunning.Operation updatePool(com.google.cloud.video.livestream.v1.UpdatePoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePoolMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service LivestreamService.
   * <pre>
   * Using Live Stream API, you can generate live streams in the various
   * renditions and streaming formats. The streaming format include HTTP Live
   * Streaming (HLS) and Dynamic Adaptive Streaming over HTTP (DASH). You can send
   * a source stream in the various ways, including Real-Time Messaging
   * Protocol (RTMP) and Secure Reliable Transport (SRT).
   * </pre>
   */
  public static final class LivestreamServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<LivestreamServiceFutureStub> {
    private LivestreamServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LivestreamServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LivestreamServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a channel with the provided unique ID in the specified
     * region.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createChannel(
        com.google.cloud.video.livestream.v1.CreateChannelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateChannelMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns a list of all channels in the specified region.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.video.livestream.v1.ListChannelsResponse> listChannels(
        com.google.cloud.video.livestream.v1.ListChannelsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListChannelsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns the specified channel.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.video.livestream.v1.Channel> getChannel(
        com.google.cloud.video.livestream.v1.GetChannelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetChannelMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the specified channel.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteChannel(
        com.google.cloud.video.livestream.v1.DeleteChannelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteChannelMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the specified channel.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateChannel(
        com.google.cloud.video.livestream.v1.UpdateChannelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateChannelMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Starts the specified channel. Part of the video pipeline will be created
     * only when the StartChannel request is received by the server.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> startChannel(
        com.google.cloud.video.livestream.v1.StartChannelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartChannelMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Stops the specified channel. Part of the video pipeline will be released
     * when the StopChannel request is received by the server.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> stopChannel(
        com.google.cloud.video.livestream.v1.StopChannelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopChannelMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates an input with the provided unique ID in the specified region.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createInput(
        com.google.cloud.video.livestream.v1.CreateInputRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateInputMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns a list of all inputs in the specified region.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.video.livestream.v1.ListInputsResponse> listInputs(
        com.google.cloud.video.livestream.v1.ListInputsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListInputsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns the specified input.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.video.livestream.v1.Input> getInput(
        com.google.cloud.video.livestream.v1.GetInputRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInputMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the specified input.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteInput(
        com.google.cloud.video.livestream.v1.DeleteInputRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteInputMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the specified input.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateInput(
        com.google.cloud.video.livestream.v1.UpdateInputRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateInputMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates an event with the provided unique ID in the specified channel.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.video.livestream.v1.Event> createEvent(
        com.google.cloud.video.livestream.v1.CreateEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEventMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns a list of all events in the specified channel.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.video.livestream.v1.ListEventsResponse> listEvents(
        com.google.cloud.video.livestream.v1.ListEventsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEventsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns the specified event.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.video.livestream.v1.Event> getEvent(
        com.google.cloud.video.livestream.v1.GetEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEventMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the specified event.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteEvent(
        com.google.cloud.video.livestream.v1.DeleteEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEventMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a Asset with the provided unique ID in the specified
     * region.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createAsset(
        com.google.cloud.video.livestream.v1.CreateAssetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAssetMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the specified asset if it is not used.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteAsset(
        com.google.cloud.video.livestream.v1.DeleteAssetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAssetMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns the specified asset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.video.livestream.v1.Asset> getAsset(
        com.google.cloud.video.livestream.v1.GetAssetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAssetMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns a list of all assets in the specified region.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.video.livestream.v1.ListAssetsResponse> listAssets(
        com.google.cloud.video.livestream.v1.ListAssetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAssetsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns the specified pool.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.video.livestream.v1.Pool> getPool(
        com.google.cloud.video.livestream.v1.GetPoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPoolMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the specified pool.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updatePool(
        com.google.cloud.video.livestream.v1.UpdatePoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePoolMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_CHANNEL = 0;
  private static final int METHODID_LIST_CHANNELS = 1;
  private static final int METHODID_GET_CHANNEL = 2;
  private static final int METHODID_DELETE_CHANNEL = 3;
  private static final int METHODID_UPDATE_CHANNEL = 4;
  private static final int METHODID_START_CHANNEL = 5;
  private static final int METHODID_STOP_CHANNEL = 6;
  private static final int METHODID_CREATE_INPUT = 7;
  private static final int METHODID_LIST_INPUTS = 8;
  private static final int METHODID_GET_INPUT = 9;
  private static final int METHODID_DELETE_INPUT = 10;
  private static final int METHODID_UPDATE_INPUT = 11;
  private static final int METHODID_CREATE_EVENT = 12;
  private static final int METHODID_LIST_EVENTS = 13;
  private static final int METHODID_GET_EVENT = 14;
  private static final int METHODID_DELETE_EVENT = 15;
  private static final int METHODID_CREATE_ASSET = 16;
  private static final int METHODID_DELETE_ASSET = 17;
  private static final int METHODID_GET_ASSET = 18;
  private static final int METHODID_LIST_ASSETS = 19;
  private static final int METHODID_GET_POOL = 20;
  private static final int METHODID_UPDATE_POOL = 21;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
        case METHODID_CREATE_CHANNEL:
          serviceImpl.createChannel((com.google.cloud.video.livestream.v1.CreateChannelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_CHANNELS:
          serviceImpl.listChannels((com.google.cloud.video.livestream.v1.ListChannelsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.video.livestream.v1.ListChannelsResponse>) responseObserver);
          break;
        case METHODID_GET_CHANNEL:
          serviceImpl.getChannel((com.google.cloud.video.livestream.v1.GetChannelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.video.livestream.v1.Channel>) responseObserver);
          break;
        case METHODID_DELETE_CHANNEL:
          serviceImpl.deleteChannel((com.google.cloud.video.livestream.v1.DeleteChannelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_CHANNEL:
          serviceImpl.updateChannel((com.google.cloud.video.livestream.v1.UpdateChannelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_START_CHANNEL:
          serviceImpl.startChannel((com.google.cloud.video.livestream.v1.StartChannelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_STOP_CHANNEL:
          serviceImpl.stopChannel((com.google.cloud.video.livestream.v1.StopChannelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_INPUT:
          serviceImpl.createInput((com.google.cloud.video.livestream.v1.CreateInputRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_INPUTS:
          serviceImpl.listInputs((com.google.cloud.video.livestream.v1.ListInputsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.video.livestream.v1.ListInputsResponse>) responseObserver);
          break;
        case METHODID_GET_INPUT:
          serviceImpl.getInput((com.google.cloud.video.livestream.v1.GetInputRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.video.livestream.v1.Input>) responseObserver);
          break;
        case METHODID_DELETE_INPUT:
          serviceImpl.deleteInput((com.google.cloud.video.livestream.v1.DeleteInputRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_INPUT:
          serviceImpl.updateInput((com.google.cloud.video.livestream.v1.UpdateInputRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_EVENT:
          serviceImpl.createEvent((com.google.cloud.video.livestream.v1.CreateEventRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.video.livestream.v1.Event>) responseObserver);
          break;
        case METHODID_LIST_EVENTS:
          serviceImpl.listEvents((com.google.cloud.video.livestream.v1.ListEventsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.video.livestream.v1.ListEventsResponse>) responseObserver);
          break;
        case METHODID_GET_EVENT:
          serviceImpl.getEvent((com.google.cloud.video.livestream.v1.GetEventRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.video.livestream.v1.Event>) responseObserver);
          break;
        case METHODID_DELETE_EVENT:
          serviceImpl.deleteEvent((com.google.cloud.video.livestream.v1.DeleteEventRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_ASSET:
          serviceImpl.createAsset((com.google.cloud.video.livestream.v1.CreateAssetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ASSET:
          serviceImpl.deleteAsset((com.google.cloud.video.livestream.v1.DeleteAssetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_ASSET:
          serviceImpl.getAsset((com.google.cloud.video.livestream.v1.GetAssetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.video.livestream.v1.Asset>) responseObserver);
          break;
        case METHODID_LIST_ASSETS:
          serviceImpl.listAssets((com.google.cloud.video.livestream.v1.ListAssetsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.video.livestream.v1.ListAssetsResponse>) responseObserver);
          break;
        case METHODID_GET_POOL:
          serviceImpl.getPool((com.google.cloud.video.livestream.v1.GetPoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.video.livestream.v1.Pool>) responseObserver);
          break;
        case METHODID_UPDATE_POOL:
          serviceImpl.updatePool((com.google.cloud.video.livestream.v1.UpdatePoolRequest) request,
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getCreateChannelMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.video.livestream.v1.CreateChannelRequest,
              com.google.longrunning.Operation>(
                service, METHODID_CREATE_CHANNEL)))
        .addMethod(
          getListChannelsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.video.livestream.v1.ListChannelsRequest,
              com.google.cloud.video.livestream.v1.ListChannelsResponse>(
                service, METHODID_LIST_CHANNELS)))
        .addMethod(
          getGetChannelMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.video.livestream.v1.GetChannelRequest,
              com.google.cloud.video.livestream.v1.Channel>(
                service, METHODID_GET_CHANNEL)))
        .addMethod(
          getDeleteChannelMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.video.livestream.v1.DeleteChannelRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DELETE_CHANNEL)))
        .addMethod(
          getUpdateChannelMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.video.livestream.v1.UpdateChannelRequest,
              com.google.longrunning.Operation>(
                service, METHODID_UPDATE_CHANNEL)))
        .addMethod(
          getStartChannelMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.video.livestream.v1.StartChannelRequest,
              com.google.longrunning.Operation>(
                service, METHODID_START_CHANNEL)))
        .addMethod(
          getStopChannelMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.video.livestream.v1.StopChannelRequest,
              com.google.longrunning.Operation>(
                service, METHODID_STOP_CHANNEL)))
        .addMethod(
          getCreateInputMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.video.livestream.v1.CreateInputRequest,
              com.google.longrunning.Operation>(
                service, METHODID_CREATE_INPUT)))
        .addMethod(
          getListInputsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.video.livestream.v1.ListInputsRequest,
              com.google.cloud.video.livestream.v1.ListInputsResponse>(
                service, METHODID_LIST_INPUTS)))
        .addMethod(
          getGetInputMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.video.livestream.v1.GetInputRequest,
              com.google.cloud.video.livestream.v1.Input>(
                service, METHODID_GET_INPUT)))
        .addMethod(
          getDeleteInputMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.video.livestream.v1.DeleteInputRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DELETE_INPUT)))
        .addMethod(
          getUpdateInputMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.video.livestream.v1.UpdateInputRequest,
              com.google.longrunning.Operation>(
                service, METHODID_UPDATE_INPUT)))
        .addMethod(
          getCreateEventMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.video.livestream.v1.CreateEventRequest,
              com.google.cloud.video.livestream.v1.Event>(
                service, METHODID_CREATE_EVENT)))
        .addMethod(
          getListEventsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.video.livestream.v1.ListEventsRequest,
              com.google.cloud.video.livestream.v1.ListEventsResponse>(
                service, METHODID_LIST_EVENTS)))
        .addMethod(
          getGetEventMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.video.livestream.v1.GetEventRequest,
              com.google.cloud.video.livestream.v1.Event>(
                service, METHODID_GET_EVENT)))
        .addMethod(
          getDeleteEventMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.video.livestream.v1.DeleteEventRequest,
              com.google.protobuf.Empty>(
                service, METHODID_DELETE_EVENT)))
        .addMethod(
          getCreateAssetMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.video.livestream.v1.CreateAssetRequest,
              com.google.longrunning.Operation>(
                service, METHODID_CREATE_ASSET)))
        .addMethod(
          getDeleteAssetMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.video.livestream.v1.DeleteAssetRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DELETE_ASSET)))
        .addMethod(
          getGetAssetMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.video.livestream.v1.GetAssetRequest,
              com.google.cloud.video.livestream.v1.Asset>(
                service, METHODID_GET_ASSET)))
        .addMethod(
          getListAssetsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.video.livestream.v1.ListAssetsRequest,
              com.google.cloud.video.livestream.v1.ListAssetsResponse>(
                service, METHODID_LIST_ASSETS)))
        .addMethod(
          getGetPoolMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.video.livestream.v1.GetPoolRequest,
              com.google.cloud.video.livestream.v1.Pool>(
                service, METHODID_GET_POOL)))
        .addMethod(
          getUpdatePoolMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.video.livestream.v1.UpdatePoolRequest,
              com.google.longrunning.Operation>(
                service, METHODID_UPDATE_POOL)))
        .build();
  }

  private static abstract class LivestreamServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LivestreamServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.video.livestream.v1.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LivestreamService");
    }
  }

  private static final class LivestreamServiceFileDescriptorSupplier
      extends LivestreamServiceBaseDescriptorSupplier {
    LivestreamServiceFileDescriptorSupplier() {}
  }

  private static final class LivestreamServiceMethodDescriptorSupplier
      extends LivestreamServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    LivestreamServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (LivestreamServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LivestreamServiceFileDescriptorSupplier())
              .addMethod(getCreateChannelMethod())
              .addMethod(getListChannelsMethod())
              .addMethod(getGetChannelMethod())
              .addMethod(getDeleteChannelMethod())
              .addMethod(getUpdateChannelMethod())
              .addMethod(getStartChannelMethod())
              .addMethod(getStopChannelMethod())
              .addMethod(getCreateInputMethod())
              .addMethod(getListInputsMethod())
              .addMethod(getGetInputMethod())
              .addMethod(getDeleteInputMethod())
              .addMethod(getUpdateInputMethod())
              .addMethod(getCreateEventMethod())
              .addMethod(getListEventsMethod())
              .addMethod(getGetEventMethod())
              .addMethod(getDeleteEventMethod())
              .addMethod(getCreateAssetMethod())
              .addMethod(getDeleteAssetMethod())
              .addMethod(getGetAssetMethod())
              .addMethod(getListAssetsMethod())
              .addMethod(getGetPoolMethod())
              .addMethod(getUpdatePoolMethod())
              .build();
        }
      }
    }
    return result;
  }
}
