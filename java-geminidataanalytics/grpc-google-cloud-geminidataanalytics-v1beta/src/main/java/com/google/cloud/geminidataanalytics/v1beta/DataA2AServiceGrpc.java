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
package com.google.cloud.geminidataanalytics.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * DataA2AService defines the Agent-to-Agent (A2A) protocol service for Gemini
 * Data Analytics.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class DataA2AServiceGrpc {

  private DataA2AServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.geminidataanalytics.v1beta.DataA2AService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.SendMessageRequest,
          com.google.cloud.geminidataanalytics.v1beta.SendMessageResponse>
      getSendMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendMessage",
      requestType = com.google.cloud.geminidataanalytics.v1beta.SendMessageRequest.class,
      responseType = com.google.cloud.geminidataanalytics.v1beta.SendMessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.SendMessageRequest,
          com.google.cloud.geminidataanalytics.v1beta.SendMessageResponse>
      getSendMessageMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.geminidataanalytics.v1beta.SendMessageRequest,
            com.google.cloud.geminidataanalytics.v1beta.SendMessageResponse>
        getSendMessageMethod;
    if ((getSendMessageMethod = DataA2AServiceGrpc.getSendMessageMethod) == null) {
      synchronized (DataA2AServiceGrpc.class) {
        if ((getSendMessageMethod = DataA2AServiceGrpc.getSendMessageMethod) == null) {
          DataA2AServiceGrpc.getSendMessageMethod =
              getSendMessageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.geminidataanalytics.v1beta.SendMessageRequest,
                          com.google.cloud.geminidataanalytics.v1beta.SendMessageResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendMessage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta.SendMessageRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta.SendMessageResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataA2AServiceMethodDescriptorSupplier("SendMessage"))
                      .build();
        }
      }
    }
    return getSendMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.SendMessageRequest,
          com.google.cloud.geminidataanalytics.v1beta.StreamResponse>
      getSendStreamingMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendStreamingMessage",
      requestType = com.google.cloud.geminidataanalytics.v1beta.SendMessageRequest.class,
      responseType = com.google.cloud.geminidataanalytics.v1beta.StreamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.SendMessageRequest,
          com.google.cloud.geminidataanalytics.v1beta.StreamResponse>
      getSendStreamingMessageMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.geminidataanalytics.v1beta.SendMessageRequest,
            com.google.cloud.geminidataanalytics.v1beta.StreamResponse>
        getSendStreamingMessageMethod;
    if ((getSendStreamingMessageMethod = DataA2AServiceGrpc.getSendStreamingMessageMethod)
        == null) {
      synchronized (DataA2AServiceGrpc.class) {
        if ((getSendStreamingMessageMethod = DataA2AServiceGrpc.getSendStreamingMessageMethod)
            == null) {
          DataA2AServiceGrpc.getSendStreamingMessageMethod =
              getSendStreamingMessageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.geminidataanalytics.v1beta.SendMessageRequest,
                          com.google.cloud.geminidataanalytics.v1beta.StreamResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SendStreamingMessage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta.SendMessageRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta.StreamResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataA2AServiceMethodDescriptorSupplier("SendStreamingMessage"))
                      .build();
        }
      }
    }
    return getSendStreamingMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.GetAgentCardRequest,
          com.google.cloud.geminidataanalytics.v1beta.AgentCard>
      getGetAgentCardMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAgentCard",
      requestType = com.google.cloud.geminidataanalytics.v1beta.GetAgentCardRequest.class,
      responseType = com.google.cloud.geminidataanalytics.v1beta.AgentCard.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.GetAgentCardRequest,
          com.google.cloud.geminidataanalytics.v1beta.AgentCard>
      getGetAgentCardMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.geminidataanalytics.v1beta.GetAgentCardRequest,
            com.google.cloud.geminidataanalytics.v1beta.AgentCard>
        getGetAgentCardMethod;
    if ((getGetAgentCardMethod = DataA2AServiceGrpc.getGetAgentCardMethod) == null) {
      synchronized (DataA2AServiceGrpc.class) {
        if ((getGetAgentCardMethod = DataA2AServiceGrpc.getGetAgentCardMethod) == null) {
          DataA2AServiceGrpc.getGetAgentCardMethod =
              getGetAgentCardMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.geminidataanalytics.v1beta.GetAgentCardRequest,
                          com.google.cloud.geminidataanalytics.v1beta.AgentCard>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAgentCard"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta.GetAgentCardRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta.AgentCard
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataA2AServiceMethodDescriptorSupplier("GetAgentCard"))
                      .build();
        }
      }
    }
    return getGetAgentCardMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DataA2AServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataA2AServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataA2AServiceStub>() {
          @java.lang.Override
          public DataA2AServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataA2AServiceStub(channel, callOptions);
          }
        };
    return DataA2AServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static DataA2AServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataA2AServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataA2AServiceBlockingV2Stub>() {
          @java.lang.Override
          public DataA2AServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataA2AServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return DataA2AServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataA2AServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataA2AServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataA2AServiceBlockingStub>() {
          @java.lang.Override
          public DataA2AServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataA2AServiceBlockingStub(channel, callOptions);
          }
        };
    return DataA2AServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DataA2AServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataA2AServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataA2AServiceFutureStub>() {
          @java.lang.Override
          public DataA2AServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataA2AServiceFutureStub(channel, callOptions);
          }
        };
    return DataA2AServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * DataA2AService defines the Agent-to-Agent (A2A) protocol service for Gemini
   * Data Analytics.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Send a message to the agent. This is a blocking call that will return the
     * task once it is completed.
     * </pre>
     */
    default void sendMessage(
        com.google.cloud.geminidataanalytics.v1beta.SendMessageRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.geminidataanalytics.v1beta.SendMessageResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSendMessageMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * SendStreamingMessage is a streaming call that will return a stream of
     * task update events until the Task is in an interrupted or terminal state.
     * </pre>
     */
    default void sendStreamingMessage(
        com.google.cloud.geminidataanalytics.v1beta.SendMessageRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.geminidataanalytics.v1beta.StreamResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSendStreamingMessageMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * GetAgentCard returns the agent card for the agent.
     * </pre>
     */
    default void getAgentCard(
        com.google.cloud.geminidataanalytics.v1beta.GetAgentCardRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.geminidataanalytics.v1beta.AgentCard>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAgentCardMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DataA2AService.
   *
   * <pre>
   * DataA2AService defines the Agent-to-Agent (A2A) protocol service for Gemini
   * Data Analytics.
   * </pre>
   */
  public abstract static class DataA2AServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DataA2AServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DataA2AService.
   *
   * <pre>
   * DataA2AService defines the Agent-to-Agent (A2A) protocol service for Gemini
   * Data Analytics.
   * </pre>
   */
  public static final class DataA2AServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DataA2AServiceStub> {
    private DataA2AServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataA2AServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataA2AServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Send a message to the agent. This is a blocking call that will return the
     * task once it is completed.
     * </pre>
     */
    public void sendMessage(
        com.google.cloud.geminidataanalytics.v1beta.SendMessageRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.geminidataanalytics.v1beta.SendMessageResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * SendStreamingMessage is a streaming call that will return a stream of
     * task update events until the Task is in an interrupted or terminal state.
     * </pre>
     */
    public void sendStreamingMessage(
        com.google.cloud.geminidataanalytics.v1beta.SendMessageRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.geminidataanalytics.v1beta.StreamResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSendStreamingMessageMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * GetAgentCard returns the agent card for the agent.
     * </pre>
     */
    public void getAgentCard(
        com.google.cloud.geminidataanalytics.v1beta.GetAgentCardRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.geminidataanalytics.v1beta.AgentCard>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAgentCardMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DataA2AService.
   *
   * <pre>
   * DataA2AService defines the Agent-to-Agent (A2A) protocol service for Gemini
   * Data Analytics.
   * </pre>
   */
  public static final class DataA2AServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<DataA2AServiceBlockingV2Stub> {
    private DataA2AServiceBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataA2AServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataA2AServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Send a message to the agent. This is a blocking call that will return the
     * task once it is completed.
     * </pre>
     */
    public com.google.cloud.geminidataanalytics.v1beta.SendMessageResponse sendMessage(
        com.google.cloud.geminidataanalytics.v1beta.SendMessageRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSendMessageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * SendStreamingMessage is a streaming call that will return a stream of
     * task update events until the Task is in an interrupted or terminal state.
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<
            ?, com.google.cloud.geminidataanalytics.v1beta.StreamResponse>
        sendStreamingMessage(
            com.google.cloud.geminidataanalytics.v1beta.SendMessageRequest request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getSendStreamingMessageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * GetAgentCard returns the agent card for the agent.
     * </pre>
     */
    public com.google.cloud.geminidataanalytics.v1beta.AgentCard getAgentCard(
        com.google.cloud.geminidataanalytics.v1beta.GetAgentCardRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetAgentCardMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service DataA2AService.
   *
   * <pre>
   * DataA2AService defines the Agent-to-Agent (A2A) protocol service for Gemini
   * Data Analytics.
   * </pre>
   */
  public static final class DataA2AServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DataA2AServiceBlockingStub> {
    private DataA2AServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataA2AServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataA2AServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Send a message to the agent. This is a blocking call that will return the
     * task once it is completed.
     * </pre>
     */
    public com.google.cloud.geminidataanalytics.v1beta.SendMessageResponse sendMessage(
        com.google.cloud.geminidataanalytics.v1beta.SendMessageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendMessageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * SendStreamingMessage is a streaming call that will return a stream of
     * task update events until the Task is in an interrupted or terminal state.
     * </pre>
     */
    public java.util.Iterator<com.google.cloud.geminidataanalytics.v1beta.StreamResponse>
        sendStreamingMessage(
            com.google.cloud.geminidataanalytics.v1beta.SendMessageRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSendStreamingMessageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * GetAgentCard returns the agent card for the agent.
     * </pre>
     */
    public com.google.cloud.geminidataanalytics.v1beta.AgentCard getAgentCard(
        com.google.cloud.geminidataanalytics.v1beta.GetAgentCardRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAgentCardMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DataA2AService.
   *
   * <pre>
   * DataA2AService defines the Agent-to-Agent (A2A) protocol service for Gemini
   * Data Analytics.
   * </pre>
   */
  public static final class DataA2AServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DataA2AServiceFutureStub> {
    private DataA2AServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataA2AServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataA2AServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Send a message to the agent. This is a blocking call that will return the
     * task once it is completed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.geminidataanalytics.v1beta.SendMessageResponse>
        sendMessage(com.google.cloud.geminidataanalytics.v1beta.SendMessageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * GetAgentCard returns the agent card for the agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.geminidataanalytics.v1beta.AgentCard>
        getAgentCard(com.google.cloud.geminidataanalytics.v1beta.GetAgentCardRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAgentCardMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_MESSAGE = 0;
  private static final int METHODID_SEND_STREAMING_MESSAGE = 1;
  private static final int METHODID_GET_AGENT_CARD = 2;

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
        case METHODID_SEND_MESSAGE:
          serviceImpl.sendMessage(
              (com.google.cloud.geminidataanalytics.v1beta.SendMessageRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.geminidataanalytics.v1beta.SendMessageResponse>)
                  responseObserver);
          break;
        case METHODID_SEND_STREAMING_MESSAGE:
          serviceImpl.sendStreamingMessage(
              (com.google.cloud.geminidataanalytics.v1beta.SendMessageRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.geminidataanalytics.v1beta.StreamResponse>)
                  responseObserver);
          break;
        case METHODID_GET_AGENT_CARD:
          serviceImpl.getAgentCard(
              (com.google.cloud.geminidataanalytics.v1beta.GetAgentCardRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.geminidataanalytics.v1beta.AgentCard>)
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
            getSendMessageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.geminidataanalytics.v1beta.SendMessageRequest,
                    com.google.cloud.geminidataanalytics.v1beta.SendMessageResponse>(
                    service, METHODID_SEND_MESSAGE)))
        .addMethod(
            getSendStreamingMessageMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
                new MethodHandlers<
                    com.google.cloud.geminidataanalytics.v1beta.SendMessageRequest,
                    com.google.cloud.geminidataanalytics.v1beta.StreamResponse>(
                    service, METHODID_SEND_STREAMING_MESSAGE)))
        .addMethod(
            getGetAgentCardMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.geminidataanalytics.v1beta.GetAgentCardRequest,
                    com.google.cloud.geminidataanalytics.v1beta.AgentCard>(
                    service, METHODID_GET_AGENT_CARD)))
        .build();
  }

  private abstract static class DataA2AServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataA2AServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.geminidataanalytics.v1beta.DataA2AServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataA2AService");
    }
  }

  private static final class DataA2AServiceFileDescriptorSupplier
      extends DataA2AServiceBaseDescriptorSupplier {
    DataA2AServiceFileDescriptorSupplier() {}
  }

  private static final class DataA2AServiceMethodDescriptorSupplier
      extends DataA2AServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DataA2AServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DataA2AServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DataA2AServiceFileDescriptorSupplier())
                      .addMethod(getSendMessageMethod())
                      .addMethod(getSendStreamingMessageMethod())
                      .addMethod(getGetAgentCardMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
