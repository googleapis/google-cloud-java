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
package com.google.cloud.dialogflow.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing [KnowledgeBases][google.cloud.dialogflow.v2.KnowledgeBase].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/v2/knowledge_base.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class KnowledgeBasesGrpc {

  private KnowledgeBasesGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dialogflow.v2.KnowledgeBases";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.ListKnowledgeBasesRequest,
          com.google.cloud.dialogflow.v2.ListKnowledgeBasesResponse>
      getListKnowledgeBasesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListKnowledgeBases",
      requestType = com.google.cloud.dialogflow.v2.ListKnowledgeBasesRequest.class,
      responseType = com.google.cloud.dialogflow.v2.ListKnowledgeBasesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.ListKnowledgeBasesRequest,
          com.google.cloud.dialogflow.v2.ListKnowledgeBasesResponse>
      getListKnowledgeBasesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.ListKnowledgeBasesRequest,
            com.google.cloud.dialogflow.v2.ListKnowledgeBasesResponse>
        getListKnowledgeBasesMethod;
    if ((getListKnowledgeBasesMethod = KnowledgeBasesGrpc.getListKnowledgeBasesMethod) == null) {
      synchronized (KnowledgeBasesGrpc.class) {
        if ((getListKnowledgeBasesMethod = KnowledgeBasesGrpc.getListKnowledgeBasesMethod)
            == null) {
          KnowledgeBasesGrpc.getListKnowledgeBasesMethod =
              getListKnowledgeBasesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.ListKnowledgeBasesRequest,
                          com.google.cloud.dialogflow.v2.ListKnowledgeBasesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListKnowledgeBases"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.ListKnowledgeBasesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.ListKnowledgeBasesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new KnowledgeBasesMethodDescriptorSupplier("ListKnowledgeBases"))
                      .build();
        }
      }
    }
    return getListKnowledgeBasesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.GetKnowledgeBaseRequest,
          com.google.cloud.dialogflow.v2.KnowledgeBase>
      getGetKnowledgeBaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetKnowledgeBase",
      requestType = com.google.cloud.dialogflow.v2.GetKnowledgeBaseRequest.class,
      responseType = com.google.cloud.dialogflow.v2.KnowledgeBase.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.GetKnowledgeBaseRequest,
          com.google.cloud.dialogflow.v2.KnowledgeBase>
      getGetKnowledgeBaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.GetKnowledgeBaseRequest,
            com.google.cloud.dialogflow.v2.KnowledgeBase>
        getGetKnowledgeBaseMethod;
    if ((getGetKnowledgeBaseMethod = KnowledgeBasesGrpc.getGetKnowledgeBaseMethod) == null) {
      synchronized (KnowledgeBasesGrpc.class) {
        if ((getGetKnowledgeBaseMethod = KnowledgeBasesGrpc.getGetKnowledgeBaseMethod) == null) {
          KnowledgeBasesGrpc.getGetKnowledgeBaseMethod =
              getGetKnowledgeBaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.GetKnowledgeBaseRequest,
                          com.google.cloud.dialogflow.v2.KnowledgeBase>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetKnowledgeBase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.GetKnowledgeBaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.KnowledgeBase.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new KnowledgeBasesMethodDescriptorSupplier("GetKnowledgeBase"))
                      .build();
        }
      }
    }
    return getGetKnowledgeBaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.CreateKnowledgeBaseRequest,
          com.google.cloud.dialogflow.v2.KnowledgeBase>
      getCreateKnowledgeBaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateKnowledgeBase",
      requestType = com.google.cloud.dialogflow.v2.CreateKnowledgeBaseRequest.class,
      responseType = com.google.cloud.dialogflow.v2.KnowledgeBase.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.CreateKnowledgeBaseRequest,
          com.google.cloud.dialogflow.v2.KnowledgeBase>
      getCreateKnowledgeBaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.CreateKnowledgeBaseRequest,
            com.google.cloud.dialogflow.v2.KnowledgeBase>
        getCreateKnowledgeBaseMethod;
    if ((getCreateKnowledgeBaseMethod = KnowledgeBasesGrpc.getCreateKnowledgeBaseMethod) == null) {
      synchronized (KnowledgeBasesGrpc.class) {
        if ((getCreateKnowledgeBaseMethod = KnowledgeBasesGrpc.getCreateKnowledgeBaseMethod)
            == null) {
          KnowledgeBasesGrpc.getCreateKnowledgeBaseMethod =
              getCreateKnowledgeBaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.CreateKnowledgeBaseRequest,
                          com.google.cloud.dialogflow.v2.KnowledgeBase>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateKnowledgeBase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.CreateKnowledgeBaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.KnowledgeBase.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new KnowledgeBasesMethodDescriptorSupplier("CreateKnowledgeBase"))
                      .build();
        }
      }
    }
    return getCreateKnowledgeBaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.DeleteKnowledgeBaseRequest, com.google.protobuf.Empty>
      getDeleteKnowledgeBaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteKnowledgeBase",
      requestType = com.google.cloud.dialogflow.v2.DeleteKnowledgeBaseRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.DeleteKnowledgeBaseRequest, com.google.protobuf.Empty>
      getDeleteKnowledgeBaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.DeleteKnowledgeBaseRequest, com.google.protobuf.Empty>
        getDeleteKnowledgeBaseMethod;
    if ((getDeleteKnowledgeBaseMethod = KnowledgeBasesGrpc.getDeleteKnowledgeBaseMethod) == null) {
      synchronized (KnowledgeBasesGrpc.class) {
        if ((getDeleteKnowledgeBaseMethod = KnowledgeBasesGrpc.getDeleteKnowledgeBaseMethod)
            == null) {
          KnowledgeBasesGrpc.getDeleteKnowledgeBaseMethod =
              getDeleteKnowledgeBaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.DeleteKnowledgeBaseRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteKnowledgeBase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.DeleteKnowledgeBaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new KnowledgeBasesMethodDescriptorSupplier("DeleteKnowledgeBase"))
                      .build();
        }
      }
    }
    return getDeleteKnowledgeBaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.UpdateKnowledgeBaseRequest,
          com.google.cloud.dialogflow.v2.KnowledgeBase>
      getUpdateKnowledgeBaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateKnowledgeBase",
      requestType = com.google.cloud.dialogflow.v2.UpdateKnowledgeBaseRequest.class,
      responseType = com.google.cloud.dialogflow.v2.KnowledgeBase.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.UpdateKnowledgeBaseRequest,
          com.google.cloud.dialogflow.v2.KnowledgeBase>
      getUpdateKnowledgeBaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.UpdateKnowledgeBaseRequest,
            com.google.cloud.dialogflow.v2.KnowledgeBase>
        getUpdateKnowledgeBaseMethod;
    if ((getUpdateKnowledgeBaseMethod = KnowledgeBasesGrpc.getUpdateKnowledgeBaseMethod) == null) {
      synchronized (KnowledgeBasesGrpc.class) {
        if ((getUpdateKnowledgeBaseMethod = KnowledgeBasesGrpc.getUpdateKnowledgeBaseMethod)
            == null) {
          KnowledgeBasesGrpc.getUpdateKnowledgeBaseMethod =
              getUpdateKnowledgeBaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.UpdateKnowledgeBaseRequest,
                          com.google.cloud.dialogflow.v2.KnowledgeBase>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateKnowledgeBase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.UpdateKnowledgeBaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.KnowledgeBase.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new KnowledgeBasesMethodDescriptorSupplier("UpdateKnowledgeBase"))
                      .build();
        }
      }
    }
    return getUpdateKnowledgeBaseMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static KnowledgeBasesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<KnowledgeBasesStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<KnowledgeBasesStub>() {
          @java.lang.Override
          public KnowledgeBasesStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new KnowledgeBasesStub(channel, callOptions);
          }
        };
    return KnowledgeBasesStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static KnowledgeBasesBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<KnowledgeBasesBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<KnowledgeBasesBlockingStub>() {
          @java.lang.Override
          public KnowledgeBasesBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new KnowledgeBasesBlockingStub(channel, callOptions);
          }
        };
    return KnowledgeBasesBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static KnowledgeBasesFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<KnowledgeBasesFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<KnowledgeBasesFutureStub>() {
          @java.lang.Override
          public KnowledgeBasesFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new KnowledgeBasesFutureStub(channel, callOptions);
          }
        };
    return KnowledgeBasesFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing [KnowledgeBases][google.cloud.dialogflow.v2.KnowledgeBase].
   * </pre>
   */
  public abstract static class KnowledgeBasesImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Returns the list of all knowledge bases of the specified agent.
     * </pre>
     */
    public void listKnowledgeBases(
        com.google.cloud.dialogflow.v2.ListKnowledgeBasesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListKnowledgeBasesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListKnowledgeBasesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified knowledge base.
     * </pre>
     */
    public void getKnowledgeBase(
        com.google.cloud.dialogflow.v2.GetKnowledgeBaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.KnowledgeBase>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetKnowledgeBaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a knowledge base.
     * </pre>
     */
    public void createKnowledgeBase(
        com.google.cloud.dialogflow.v2.CreateKnowledgeBaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.KnowledgeBase>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateKnowledgeBaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified knowledge base.
     * </pre>
     */
    public void deleteKnowledgeBase(
        com.google.cloud.dialogflow.v2.DeleteKnowledgeBaseRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteKnowledgeBaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified knowledge base.
     * </pre>
     */
    public void updateKnowledgeBase(
        com.google.cloud.dialogflow.v2.UpdateKnowledgeBaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.KnowledgeBase>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateKnowledgeBaseMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListKnowledgeBasesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.ListKnowledgeBasesRequest,
                      com.google.cloud.dialogflow.v2.ListKnowledgeBasesResponse>(
                      this, METHODID_LIST_KNOWLEDGE_BASES)))
          .addMethod(
              getGetKnowledgeBaseMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.GetKnowledgeBaseRequest,
                      com.google.cloud.dialogflow.v2.KnowledgeBase>(
                      this, METHODID_GET_KNOWLEDGE_BASE)))
          .addMethod(
              getCreateKnowledgeBaseMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.CreateKnowledgeBaseRequest,
                      com.google.cloud.dialogflow.v2.KnowledgeBase>(
                      this, METHODID_CREATE_KNOWLEDGE_BASE)))
          .addMethod(
              getDeleteKnowledgeBaseMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.DeleteKnowledgeBaseRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_KNOWLEDGE_BASE)))
          .addMethod(
              getUpdateKnowledgeBaseMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.UpdateKnowledgeBaseRequest,
                      com.google.cloud.dialogflow.v2.KnowledgeBase>(
                      this, METHODID_UPDATE_KNOWLEDGE_BASE)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [KnowledgeBases][google.cloud.dialogflow.v2.KnowledgeBase].
   * </pre>
   */
  public static final class KnowledgeBasesStub
      extends io.grpc.stub.AbstractAsyncStub<KnowledgeBasesStub> {
    private KnowledgeBasesStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KnowledgeBasesStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new KnowledgeBasesStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all knowledge bases of the specified agent.
     * </pre>
     */
    public void listKnowledgeBases(
        com.google.cloud.dialogflow.v2.ListKnowledgeBasesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListKnowledgeBasesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListKnowledgeBasesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified knowledge base.
     * </pre>
     */
    public void getKnowledgeBase(
        com.google.cloud.dialogflow.v2.GetKnowledgeBaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.KnowledgeBase>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetKnowledgeBaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a knowledge base.
     * </pre>
     */
    public void createKnowledgeBase(
        com.google.cloud.dialogflow.v2.CreateKnowledgeBaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.KnowledgeBase>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateKnowledgeBaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified knowledge base.
     * </pre>
     */
    public void deleteKnowledgeBase(
        com.google.cloud.dialogflow.v2.DeleteKnowledgeBaseRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteKnowledgeBaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified knowledge base.
     * </pre>
     */
    public void updateKnowledgeBase(
        com.google.cloud.dialogflow.v2.UpdateKnowledgeBaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.KnowledgeBase>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateKnowledgeBaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [KnowledgeBases][google.cloud.dialogflow.v2.KnowledgeBase].
   * </pre>
   */
  public static final class KnowledgeBasesBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<KnowledgeBasesBlockingStub> {
    private KnowledgeBasesBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KnowledgeBasesBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new KnowledgeBasesBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all knowledge bases of the specified agent.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.ListKnowledgeBasesResponse listKnowledgeBases(
        com.google.cloud.dialogflow.v2.ListKnowledgeBasesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListKnowledgeBasesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified knowledge base.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.KnowledgeBase getKnowledgeBase(
        com.google.cloud.dialogflow.v2.GetKnowledgeBaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetKnowledgeBaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a knowledge base.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.KnowledgeBase createKnowledgeBase(
        com.google.cloud.dialogflow.v2.CreateKnowledgeBaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateKnowledgeBaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified knowledge base.
     * </pre>
     */
    public com.google.protobuf.Empty deleteKnowledgeBase(
        com.google.cloud.dialogflow.v2.DeleteKnowledgeBaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteKnowledgeBaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified knowledge base.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.KnowledgeBase updateKnowledgeBase(
        com.google.cloud.dialogflow.v2.UpdateKnowledgeBaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateKnowledgeBaseMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [KnowledgeBases][google.cloud.dialogflow.v2.KnowledgeBase].
   * </pre>
   */
  public static final class KnowledgeBasesFutureStub
      extends io.grpc.stub.AbstractFutureStub<KnowledgeBasesFutureStub> {
    private KnowledgeBasesFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KnowledgeBasesFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new KnowledgeBasesFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all knowledge bases of the specified agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.ListKnowledgeBasesResponse>
        listKnowledgeBases(com.google.cloud.dialogflow.v2.ListKnowledgeBasesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListKnowledgeBasesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified knowledge base.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.KnowledgeBase>
        getKnowledgeBase(com.google.cloud.dialogflow.v2.GetKnowledgeBaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetKnowledgeBaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a knowledge base.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.KnowledgeBase>
        createKnowledgeBase(com.google.cloud.dialogflow.v2.CreateKnowledgeBaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateKnowledgeBaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified knowledge base.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteKnowledgeBase(com.google.cloud.dialogflow.v2.DeleteKnowledgeBaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteKnowledgeBaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified knowledge base.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.KnowledgeBase>
        updateKnowledgeBase(com.google.cloud.dialogflow.v2.UpdateKnowledgeBaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateKnowledgeBaseMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_KNOWLEDGE_BASES = 0;
  private static final int METHODID_GET_KNOWLEDGE_BASE = 1;
  private static final int METHODID_CREATE_KNOWLEDGE_BASE = 2;
  private static final int METHODID_DELETE_KNOWLEDGE_BASE = 3;
  private static final int METHODID_UPDATE_KNOWLEDGE_BASE = 4;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final KnowledgeBasesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(KnowledgeBasesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_KNOWLEDGE_BASES:
          serviceImpl.listKnowledgeBases(
              (com.google.cloud.dialogflow.v2.ListKnowledgeBasesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.v2.ListKnowledgeBasesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_KNOWLEDGE_BASE:
          serviceImpl.getKnowledgeBase(
              (com.google.cloud.dialogflow.v2.GetKnowledgeBaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.KnowledgeBase>)
                  responseObserver);
          break;
        case METHODID_CREATE_KNOWLEDGE_BASE:
          serviceImpl.createKnowledgeBase(
              (com.google.cloud.dialogflow.v2.CreateKnowledgeBaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.KnowledgeBase>)
                  responseObserver);
          break;
        case METHODID_DELETE_KNOWLEDGE_BASE:
          serviceImpl.deleteKnowledgeBase(
              (com.google.cloud.dialogflow.v2.DeleteKnowledgeBaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_KNOWLEDGE_BASE:
          serviceImpl.updateKnowledgeBase(
              (com.google.cloud.dialogflow.v2.UpdateKnowledgeBaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.KnowledgeBase>)
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

  private abstract static class KnowledgeBasesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    KnowledgeBasesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.v2.KnowledgeBaseProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("KnowledgeBases");
    }
  }

  private static final class KnowledgeBasesFileDescriptorSupplier
      extends KnowledgeBasesBaseDescriptorSupplier {
    KnowledgeBasesFileDescriptorSupplier() {}
  }

  private static final class KnowledgeBasesMethodDescriptorSupplier
      extends KnowledgeBasesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    KnowledgeBasesMethodDescriptorSupplier(String methodName) {
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
      synchronized (KnowledgeBasesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new KnowledgeBasesFileDescriptorSupplier())
                      .addMethod(getListKnowledgeBasesMethod())
                      .addMethod(getGetKnowledgeBaseMethod())
                      .addMethod(getCreateKnowledgeBaseMethod())
                      .addMethod(getDeleteKnowledgeBaseMethod())
                      .addMethod(getUpdateKnowledgeBaseMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
