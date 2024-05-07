/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.visionai.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Streaming service for receiving and sending packets.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/visionai/v1/streaming_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class StreamingServiceGrpc {

  private StreamingServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.visionai.v1.StreamingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.SendPacketsRequest,
          com.google.cloud.visionai.v1.SendPacketsResponse>
      getSendPacketsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendPackets",
      requestType = com.google.cloud.visionai.v1.SendPacketsRequest.class,
      responseType = com.google.cloud.visionai.v1.SendPacketsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.SendPacketsRequest,
          com.google.cloud.visionai.v1.SendPacketsResponse>
      getSendPacketsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.SendPacketsRequest,
            com.google.cloud.visionai.v1.SendPacketsResponse>
        getSendPacketsMethod;
    if ((getSendPacketsMethod = StreamingServiceGrpc.getSendPacketsMethod) == null) {
      synchronized (StreamingServiceGrpc.class) {
        if ((getSendPacketsMethod = StreamingServiceGrpc.getSendPacketsMethod) == null) {
          StreamingServiceGrpc.getSendPacketsMethod =
              getSendPacketsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.SendPacketsRequest,
                          com.google.cloud.visionai.v1.SendPacketsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendPackets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.SendPacketsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.SendPacketsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StreamingServiceMethodDescriptorSupplier("SendPackets"))
                      .build();
        }
      }
    }
    return getSendPacketsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ReceivePacketsRequest,
          com.google.cloud.visionai.v1.ReceivePacketsResponse>
      getReceivePacketsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReceivePackets",
      requestType = com.google.cloud.visionai.v1.ReceivePacketsRequest.class,
      responseType = com.google.cloud.visionai.v1.ReceivePacketsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ReceivePacketsRequest,
          com.google.cloud.visionai.v1.ReceivePacketsResponse>
      getReceivePacketsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.ReceivePacketsRequest,
            com.google.cloud.visionai.v1.ReceivePacketsResponse>
        getReceivePacketsMethod;
    if ((getReceivePacketsMethod = StreamingServiceGrpc.getReceivePacketsMethod) == null) {
      synchronized (StreamingServiceGrpc.class) {
        if ((getReceivePacketsMethod = StreamingServiceGrpc.getReceivePacketsMethod) == null) {
          StreamingServiceGrpc.getReceivePacketsMethod =
              getReceivePacketsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.ReceivePacketsRequest,
                          com.google.cloud.visionai.v1.ReceivePacketsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReceivePackets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ReceivePacketsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ReceivePacketsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StreamingServiceMethodDescriptorSupplier("ReceivePackets"))
                      .build();
        }
      }
    }
    return getReceivePacketsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ReceiveEventsRequest,
          com.google.cloud.visionai.v1.ReceiveEventsResponse>
      getReceiveEventsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReceiveEvents",
      requestType = com.google.cloud.visionai.v1.ReceiveEventsRequest.class,
      responseType = com.google.cloud.visionai.v1.ReceiveEventsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ReceiveEventsRequest,
          com.google.cloud.visionai.v1.ReceiveEventsResponse>
      getReceiveEventsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.ReceiveEventsRequest,
            com.google.cloud.visionai.v1.ReceiveEventsResponse>
        getReceiveEventsMethod;
    if ((getReceiveEventsMethod = StreamingServiceGrpc.getReceiveEventsMethod) == null) {
      synchronized (StreamingServiceGrpc.class) {
        if ((getReceiveEventsMethod = StreamingServiceGrpc.getReceiveEventsMethod) == null) {
          StreamingServiceGrpc.getReceiveEventsMethod =
              getReceiveEventsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.ReceiveEventsRequest,
                          com.google.cloud.visionai.v1.ReceiveEventsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReceiveEvents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ReceiveEventsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ReceiveEventsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StreamingServiceMethodDescriptorSupplier("ReceiveEvents"))
                      .build();
        }
      }
    }
    return getReceiveEventsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.AcquireLeaseRequest, com.google.cloud.visionai.v1.Lease>
      getAcquireLeaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AcquireLease",
      requestType = com.google.cloud.visionai.v1.AcquireLeaseRequest.class,
      responseType = com.google.cloud.visionai.v1.Lease.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.AcquireLeaseRequest, com.google.cloud.visionai.v1.Lease>
      getAcquireLeaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.AcquireLeaseRequest, com.google.cloud.visionai.v1.Lease>
        getAcquireLeaseMethod;
    if ((getAcquireLeaseMethod = StreamingServiceGrpc.getAcquireLeaseMethod) == null) {
      synchronized (StreamingServiceGrpc.class) {
        if ((getAcquireLeaseMethod = StreamingServiceGrpc.getAcquireLeaseMethod) == null) {
          StreamingServiceGrpc.getAcquireLeaseMethod =
              getAcquireLeaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.AcquireLeaseRequest,
                          com.google.cloud.visionai.v1.Lease>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AcquireLease"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.AcquireLeaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.Lease.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StreamingServiceMethodDescriptorSupplier("AcquireLease"))
                      .build();
        }
      }
    }
    return getAcquireLeaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.RenewLeaseRequest, com.google.cloud.visionai.v1.Lease>
      getRenewLeaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RenewLease",
      requestType = com.google.cloud.visionai.v1.RenewLeaseRequest.class,
      responseType = com.google.cloud.visionai.v1.Lease.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.RenewLeaseRequest, com.google.cloud.visionai.v1.Lease>
      getRenewLeaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.RenewLeaseRequest, com.google.cloud.visionai.v1.Lease>
        getRenewLeaseMethod;
    if ((getRenewLeaseMethod = StreamingServiceGrpc.getRenewLeaseMethod) == null) {
      synchronized (StreamingServiceGrpc.class) {
        if ((getRenewLeaseMethod = StreamingServiceGrpc.getRenewLeaseMethod) == null) {
          StreamingServiceGrpc.getRenewLeaseMethod =
              getRenewLeaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.RenewLeaseRequest,
                          com.google.cloud.visionai.v1.Lease>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RenewLease"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.RenewLeaseRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.Lease.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StreamingServiceMethodDescriptorSupplier("RenewLease"))
                      .build();
        }
      }
    }
    return getRenewLeaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ReleaseLeaseRequest,
          com.google.cloud.visionai.v1.ReleaseLeaseResponse>
      getReleaseLeaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReleaseLease",
      requestType = com.google.cloud.visionai.v1.ReleaseLeaseRequest.class,
      responseType = com.google.cloud.visionai.v1.ReleaseLeaseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ReleaseLeaseRequest,
          com.google.cloud.visionai.v1.ReleaseLeaseResponse>
      getReleaseLeaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.ReleaseLeaseRequest,
            com.google.cloud.visionai.v1.ReleaseLeaseResponse>
        getReleaseLeaseMethod;
    if ((getReleaseLeaseMethod = StreamingServiceGrpc.getReleaseLeaseMethod) == null) {
      synchronized (StreamingServiceGrpc.class) {
        if ((getReleaseLeaseMethod = StreamingServiceGrpc.getReleaseLeaseMethod) == null) {
          StreamingServiceGrpc.getReleaseLeaseMethod =
              getReleaseLeaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.ReleaseLeaseRequest,
                          com.google.cloud.visionai.v1.ReleaseLeaseResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReleaseLease"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ReleaseLeaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ReleaseLeaseResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StreamingServiceMethodDescriptorSupplier("ReleaseLease"))
                      .build();
        }
      }
    }
    return getReleaseLeaseMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static StreamingServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StreamingServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<StreamingServiceStub>() {
          @java.lang.Override
          public StreamingServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new StreamingServiceStub(channel, callOptions);
          }
        };
    return StreamingServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StreamingServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StreamingServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<StreamingServiceBlockingStub>() {
          @java.lang.Override
          public StreamingServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new StreamingServiceBlockingStub(channel, callOptions);
          }
        };
    return StreamingServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static StreamingServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StreamingServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<StreamingServiceFutureStub>() {
          @java.lang.Override
          public StreamingServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new StreamingServiceFutureStub(channel, callOptions);
          }
        };
    return StreamingServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Streaming service for receiving and sending packets.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Send packets to the series.
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.SendPacketsRequest>
        sendPackets(
            io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.SendPacketsResponse>
                responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(
          getSendPacketsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Receive packets from the series.
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ReceivePacketsRequest>
        receivePackets(
            io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ReceivePacketsResponse>
                responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(
          getReceivePacketsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Receive events given the stream name.
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ReceiveEventsRequest>
        receiveEvents(
            io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ReceiveEventsResponse>
                responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(
          getReceiveEventsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * AcquireLease acquires a lease.
     * </pre>
     */
    default void acquireLease(
        com.google.cloud.visionai.v1.AcquireLeaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Lease> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAcquireLeaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * RenewLease renews a lease.
     * </pre>
     */
    default void renewLease(
        com.google.cloud.visionai.v1.RenewLeaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Lease> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRenewLeaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * RleaseLease releases a lease.
     * </pre>
     */
    default void releaseLease(
        com.google.cloud.visionai.v1.ReleaseLeaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ReleaseLeaseResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getReleaseLeaseMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service StreamingService.
   *
   * <pre>
   * Streaming service for receiving and sending packets.
   * </pre>
   */
  public abstract static class StreamingServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return StreamingServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service StreamingService.
   *
   * <pre>
   * Streaming service for receiving and sending packets.
   * </pre>
   */
  public static final class StreamingServiceStub
      extends io.grpc.stub.AbstractAsyncStub<StreamingServiceStub> {
    private StreamingServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamingServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StreamingServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Send packets to the series.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.SendPacketsRequest> sendPackets(
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.SendPacketsResponse>
            responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getSendPacketsMethod(), getCallOptions()), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Receive packets from the series.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ReceivePacketsRequest>
        receivePackets(
            io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ReceivePacketsResponse>
                responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getReceivePacketsMethod(), getCallOptions()), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Receive events given the stream name.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ReceiveEventsRequest>
        receiveEvents(
            io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ReceiveEventsResponse>
                responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getReceiveEventsMethod(), getCallOptions()), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * AcquireLease acquires a lease.
     * </pre>
     */
    public void acquireLease(
        com.google.cloud.visionai.v1.AcquireLeaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Lease> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAcquireLeaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * RenewLease renews a lease.
     * </pre>
     */
    public void renewLease(
        com.google.cloud.visionai.v1.RenewLeaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Lease> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRenewLeaseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * RleaseLease releases a lease.
     * </pre>
     */
    public void releaseLease(
        com.google.cloud.visionai.v1.ReleaseLeaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ReleaseLeaseResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReleaseLeaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service StreamingService.
   *
   * <pre>
   * Streaming service for receiving and sending packets.
   * </pre>
   */
  public static final class StreamingServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<StreamingServiceBlockingStub> {
    private StreamingServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamingServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StreamingServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * AcquireLease acquires a lease.
     * </pre>
     */
    public com.google.cloud.visionai.v1.Lease acquireLease(
        com.google.cloud.visionai.v1.AcquireLeaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAcquireLeaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * RenewLease renews a lease.
     * </pre>
     */
    public com.google.cloud.visionai.v1.Lease renewLease(
        com.google.cloud.visionai.v1.RenewLeaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRenewLeaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * RleaseLease releases a lease.
     * </pre>
     */
    public com.google.cloud.visionai.v1.ReleaseLeaseResponse releaseLease(
        com.google.cloud.visionai.v1.ReleaseLeaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReleaseLeaseMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service StreamingService.
   *
   * <pre>
   * Streaming service for receiving and sending packets.
   * </pre>
   */
  public static final class StreamingServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<StreamingServiceFutureStub> {
    private StreamingServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamingServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StreamingServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * AcquireLease acquires a lease.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.visionai.v1.Lease>
        acquireLease(com.google.cloud.visionai.v1.AcquireLeaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAcquireLeaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * RenewLease renews a lease.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.visionai.v1.Lease>
        renewLease(com.google.cloud.visionai.v1.RenewLeaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRenewLeaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * RleaseLease releases a lease.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.ReleaseLeaseResponse>
        releaseLease(com.google.cloud.visionai.v1.ReleaseLeaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReleaseLeaseMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ACQUIRE_LEASE = 0;
  private static final int METHODID_RENEW_LEASE = 1;
  private static final int METHODID_RELEASE_LEASE = 2;
  private static final int METHODID_SEND_PACKETS = 3;
  private static final int METHODID_RECEIVE_PACKETS = 4;
  private static final int METHODID_RECEIVE_EVENTS = 5;

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
        case METHODID_ACQUIRE_LEASE:
          serviceImpl.acquireLease(
              (com.google.cloud.visionai.v1.AcquireLeaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Lease>) responseObserver);
          break;
        case METHODID_RENEW_LEASE:
          serviceImpl.renewLease(
              (com.google.cloud.visionai.v1.RenewLeaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Lease>) responseObserver);
          break;
        case METHODID_RELEASE_LEASE:
          serviceImpl.releaseLease(
              (com.google.cloud.visionai.v1.ReleaseLeaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ReleaseLeaseResponse>)
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
        case METHODID_SEND_PACKETS:
          return (io.grpc.stub.StreamObserver<Req>)
              serviceImpl.sendPackets(
                  (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.SendPacketsResponse>)
                      responseObserver);
        case METHODID_RECEIVE_PACKETS:
          return (io.grpc.stub.StreamObserver<Req>)
              serviceImpl.receivePackets(
                  (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ReceivePacketsResponse>)
                      responseObserver);
        case METHODID_RECEIVE_EVENTS:
          return (io.grpc.stub.StreamObserver<Req>)
              serviceImpl.receiveEvents(
                  (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ReceiveEventsResponse>)
                      responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getSendPacketsMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.SendPacketsRequest,
                    com.google.cloud.visionai.v1.SendPacketsResponse>(
                    service, METHODID_SEND_PACKETS)))
        .addMethod(
            getReceivePacketsMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.ReceivePacketsRequest,
                    com.google.cloud.visionai.v1.ReceivePacketsResponse>(
                    service, METHODID_RECEIVE_PACKETS)))
        .addMethod(
            getReceiveEventsMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.ReceiveEventsRequest,
                    com.google.cloud.visionai.v1.ReceiveEventsResponse>(
                    service, METHODID_RECEIVE_EVENTS)))
        .addMethod(
            getAcquireLeaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.AcquireLeaseRequest,
                    com.google.cloud.visionai.v1.Lease>(service, METHODID_ACQUIRE_LEASE)))
        .addMethod(
            getRenewLeaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.RenewLeaseRequest,
                    com.google.cloud.visionai.v1.Lease>(service, METHODID_RENEW_LEASE)))
        .addMethod(
            getReleaseLeaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.ReleaseLeaseRequest,
                    com.google.cloud.visionai.v1.ReleaseLeaseResponse>(
                    service, METHODID_RELEASE_LEASE)))
        .build();
  }

  private abstract static class StreamingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StreamingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.visionai.v1.StreamingServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StreamingService");
    }
  }

  private static final class StreamingServiceFileDescriptorSupplier
      extends StreamingServiceBaseDescriptorSupplier {
    StreamingServiceFileDescriptorSupplier() {}
  }

  private static final class StreamingServiceMethodDescriptorSupplier
      extends StreamingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    StreamingServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (StreamingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new StreamingServiceFileDescriptorSupplier())
                      .addMethod(getSendPacketsMethod())
                      .addMethod(getReceivePacketsMethod())
                      .addMethod(getReceiveEventsMethod())
                      .addMethod(getAcquireLeaseMethod())
                      .addMethod(getRenewLeaseMethod())
                      .addMethod(getReleaseLeaseMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
