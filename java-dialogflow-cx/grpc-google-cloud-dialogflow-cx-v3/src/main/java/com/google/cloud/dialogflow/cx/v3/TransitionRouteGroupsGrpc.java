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
 * Service for managing [TransitionRouteGroups][google.cloud.dialogflow.cx.v3.TransitionRouteGroup].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/cx/v3/transition_route_group.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TransitionRouteGroupsGrpc {

  private TransitionRouteGroupsGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dialogflow.cx.v3.TransitionRouteGroups";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.ListTransitionRouteGroupsRequest,
          com.google.cloud.dialogflow.cx.v3.ListTransitionRouteGroupsResponse>
      getListTransitionRouteGroupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTransitionRouteGroups",
      requestType = com.google.cloud.dialogflow.cx.v3.ListTransitionRouteGroupsRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.ListTransitionRouteGroupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.ListTransitionRouteGroupsRequest,
          com.google.cloud.dialogflow.cx.v3.ListTransitionRouteGroupsResponse>
      getListTransitionRouteGroupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.ListTransitionRouteGroupsRequest,
            com.google.cloud.dialogflow.cx.v3.ListTransitionRouteGroupsResponse>
        getListTransitionRouteGroupsMethod;
    if ((getListTransitionRouteGroupsMethod =
            TransitionRouteGroupsGrpc.getListTransitionRouteGroupsMethod)
        == null) {
      synchronized (TransitionRouteGroupsGrpc.class) {
        if ((getListTransitionRouteGroupsMethod =
                TransitionRouteGroupsGrpc.getListTransitionRouteGroupsMethod)
            == null) {
          TransitionRouteGroupsGrpc.getListTransitionRouteGroupsMethod =
              getListTransitionRouteGroupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.ListTransitionRouteGroupsRequest,
                          com.google.cloud.dialogflow.cx.v3.ListTransitionRouteGroupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListTransitionRouteGroups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.ListTransitionRouteGroupsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.ListTransitionRouteGroupsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TransitionRouteGroupsMethodDescriptorSupplier(
                              "ListTransitionRouteGroups"))
                      .build();
        }
      }
    }
    return getListTransitionRouteGroupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.GetTransitionRouteGroupRequest,
          com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup>
      getGetTransitionRouteGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTransitionRouteGroup",
      requestType = com.google.cloud.dialogflow.cx.v3.GetTransitionRouteGroupRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.GetTransitionRouteGroupRequest,
          com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup>
      getGetTransitionRouteGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.GetTransitionRouteGroupRequest,
            com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup>
        getGetTransitionRouteGroupMethod;
    if ((getGetTransitionRouteGroupMethod =
            TransitionRouteGroupsGrpc.getGetTransitionRouteGroupMethod)
        == null) {
      synchronized (TransitionRouteGroupsGrpc.class) {
        if ((getGetTransitionRouteGroupMethod =
                TransitionRouteGroupsGrpc.getGetTransitionRouteGroupMethod)
            == null) {
          TransitionRouteGroupsGrpc.getGetTransitionRouteGroupMethod =
              getGetTransitionRouteGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.GetTransitionRouteGroupRequest,
                          com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetTransitionRouteGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.GetTransitionRouteGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TransitionRouteGroupsMethodDescriptorSupplier(
                              "GetTransitionRouteGroup"))
                      .build();
        }
      }
    }
    return getGetTransitionRouteGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.CreateTransitionRouteGroupRequest,
          com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup>
      getCreateTransitionRouteGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTransitionRouteGroup",
      requestType = com.google.cloud.dialogflow.cx.v3.CreateTransitionRouteGroupRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.CreateTransitionRouteGroupRequest,
          com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup>
      getCreateTransitionRouteGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.CreateTransitionRouteGroupRequest,
            com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup>
        getCreateTransitionRouteGroupMethod;
    if ((getCreateTransitionRouteGroupMethod =
            TransitionRouteGroupsGrpc.getCreateTransitionRouteGroupMethod)
        == null) {
      synchronized (TransitionRouteGroupsGrpc.class) {
        if ((getCreateTransitionRouteGroupMethod =
                TransitionRouteGroupsGrpc.getCreateTransitionRouteGroupMethod)
            == null) {
          TransitionRouteGroupsGrpc.getCreateTransitionRouteGroupMethod =
              getCreateTransitionRouteGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.CreateTransitionRouteGroupRequest,
                          com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateTransitionRouteGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.CreateTransitionRouteGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TransitionRouteGroupsMethodDescriptorSupplier(
                              "CreateTransitionRouteGroup"))
                      .build();
        }
      }
    }
    return getCreateTransitionRouteGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.UpdateTransitionRouteGroupRequest,
          com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup>
      getUpdateTransitionRouteGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTransitionRouteGroup",
      requestType = com.google.cloud.dialogflow.cx.v3.UpdateTransitionRouteGroupRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.UpdateTransitionRouteGroupRequest,
          com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup>
      getUpdateTransitionRouteGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.UpdateTransitionRouteGroupRequest,
            com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup>
        getUpdateTransitionRouteGroupMethod;
    if ((getUpdateTransitionRouteGroupMethod =
            TransitionRouteGroupsGrpc.getUpdateTransitionRouteGroupMethod)
        == null) {
      synchronized (TransitionRouteGroupsGrpc.class) {
        if ((getUpdateTransitionRouteGroupMethod =
                TransitionRouteGroupsGrpc.getUpdateTransitionRouteGroupMethod)
            == null) {
          TransitionRouteGroupsGrpc.getUpdateTransitionRouteGroupMethod =
              getUpdateTransitionRouteGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.UpdateTransitionRouteGroupRequest,
                          com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateTransitionRouteGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.UpdateTransitionRouteGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TransitionRouteGroupsMethodDescriptorSupplier(
                              "UpdateTransitionRouteGroup"))
                      .build();
        }
      }
    }
    return getUpdateTransitionRouteGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.DeleteTransitionRouteGroupRequest,
          com.google.protobuf.Empty>
      getDeleteTransitionRouteGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTransitionRouteGroup",
      requestType = com.google.cloud.dialogflow.cx.v3.DeleteTransitionRouteGroupRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.DeleteTransitionRouteGroupRequest,
          com.google.protobuf.Empty>
      getDeleteTransitionRouteGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.DeleteTransitionRouteGroupRequest,
            com.google.protobuf.Empty>
        getDeleteTransitionRouteGroupMethod;
    if ((getDeleteTransitionRouteGroupMethod =
            TransitionRouteGroupsGrpc.getDeleteTransitionRouteGroupMethod)
        == null) {
      synchronized (TransitionRouteGroupsGrpc.class) {
        if ((getDeleteTransitionRouteGroupMethod =
                TransitionRouteGroupsGrpc.getDeleteTransitionRouteGroupMethod)
            == null) {
          TransitionRouteGroupsGrpc.getDeleteTransitionRouteGroupMethod =
              getDeleteTransitionRouteGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.DeleteTransitionRouteGroupRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteTransitionRouteGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.DeleteTransitionRouteGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TransitionRouteGroupsMethodDescriptorSupplier(
                              "DeleteTransitionRouteGroup"))
                      .build();
        }
      }
    }
    return getDeleteTransitionRouteGroupMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static TransitionRouteGroupsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TransitionRouteGroupsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TransitionRouteGroupsStub>() {
          @java.lang.Override
          public TransitionRouteGroupsStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TransitionRouteGroupsStub(channel, callOptions);
          }
        };
    return TransitionRouteGroupsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TransitionRouteGroupsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TransitionRouteGroupsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TransitionRouteGroupsBlockingStub>() {
          @java.lang.Override
          public TransitionRouteGroupsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TransitionRouteGroupsBlockingStub(channel, callOptions);
          }
        };
    return TransitionRouteGroupsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static TransitionRouteGroupsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TransitionRouteGroupsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TransitionRouteGroupsFutureStub>() {
          @java.lang.Override
          public TransitionRouteGroupsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TransitionRouteGroupsFutureStub(channel, callOptions);
          }
        };
    return TransitionRouteGroupsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing [TransitionRouteGroups][google.cloud.dialogflow.cx.v3.TransitionRouteGroup].
   * </pre>
   */
  public abstract static class TransitionRouteGroupsImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Returns the list of all transition route groups in the specified flow.
     * </pre>
     */
    public void listTransitionRouteGroups(
        com.google.cloud.dialogflow.cx.v3.ListTransitionRouteGroupsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.dialogflow.cx.v3.ListTransitionRouteGroupsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListTransitionRouteGroupsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified [TransitionRouteGroup][google.cloud.dialogflow.cx.v3.TransitionRouteGroup].
     * </pre>
     */
    public void getTransitionRouteGroup(
        com.google.cloud.dialogflow.cx.v3.GetTransitionRouteGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetTransitionRouteGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an [TransitionRouteGroup][google.cloud.dialogflow.cx.v3.TransitionRouteGroup] in the specified flow.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public void createTransitionRouteGroup(
        com.google.cloud.dialogflow.cx.v3.CreateTransitionRouteGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateTransitionRouteGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified [TransitionRouteGroup][google.cloud.dialogflow.cx.v3.TransitionRouteGroup].
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public void updateTransitionRouteGroup(
        com.google.cloud.dialogflow.cx.v3.UpdateTransitionRouteGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateTransitionRouteGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified [TransitionRouteGroup][google.cloud.dialogflow.cx.v3.TransitionRouteGroup].
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public void deleteTransitionRouteGroup(
        com.google.cloud.dialogflow.cx.v3.DeleteTransitionRouteGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteTransitionRouteGroupMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListTransitionRouteGroupsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3.ListTransitionRouteGroupsRequest,
                      com.google.cloud.dialogflow.cx.v3.ListTransitionRouteGroupsResponse>(
                      this, METHODID_LIST_TRANSITION_ROUTE_GROUPS)))
          .addMethod(
              getGetTransitionRouteGroupMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3.GetTransitionRouteGroupRequest,
                      com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup>(
                      this, METHODID_GET_TRANSITION_ROUTE_GROUP)))
          .addMethod(
              getCreateTransitionRouteGroupMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3.CreateTransitionRouteGroupRequest,
                      com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup>(
                      this, METHODID_CREATE_TRANSITION_ROUTE_GROUP)))
          .addMethod(
              getUpdateTransitionRouteGroupMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3.UpdateTransitionRouteGroupRequest,
                      com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup>(
                      this, METHODID_UPDATE_TRANSITION_ROUTE_GROUP)))
          .addMethod(
              getDeleteTransitionRouteGroupMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3.DeleteTransitionRouteGroupRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_TRANSITION_ROUTE_GROUP)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [TransitionRouteGroups][google.cloud.dialogflow.cx.v3.TransitionRouteGroup].
   * </pre>
   */
  public static final class TransitionRouteGroupsStub
      extends io.grpc.stub.AbstractAsyncStub<TransitionRouteGroupsStub> {
    private TransitionRouteGroupsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransitionRouteGroupsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TransitionRouteGroupsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all transition route groups in the specified flow.
     * </pre>
     */
    public void listTransitionRouteGroups(
        com.google.cloud.dialogflow.cx.v3.ListTransitionRouteGroupsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.dialogflow.cx.v3.ListTransitionRouteGroupsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTransitionRouteGroupsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified [TransitionRouteGroup][google.cloud.dialogflow.cx.v3.TransitionRouteGroup].
     * </pre>
     */
    public void getTransitionRouteGroup(
        com.google.cloud.dialogflow.cx.v3.GetTransitionRouteGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTransitionRouteGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an [TransitionRouteGroup][google.cloud.dialogflow.cx.v3.TransitionRouteGroup] in the specified flow.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public void createTransitionRouteGroup(
        com.google.cloud.dialogflow.cx.v3.CreateTransitionRouteGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTransitionRouteGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified [TransitionRouteGroup][google.cloud.dialogflow.cx.v3.TransitionRouteGroup].
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public void updateTransitionRouteGroup(
        com.google.cloud.dialogflow.cx.v3.UpdateTransitionRouteGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTransitionRouteGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified [TransitionRouteGroup][google.cloud.dialogflow.cx.v3.TransitionRouteGroup].
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public void deleteTransitionRouteGroup(
        com.google.cloud.dialogflow.cx.v3.DeleteTransitionRouteGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTransitionRouteGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [TransitionRouteGroups][google.cloud.dialogflow.cx.v3.TransitionRouteGroup].
   * </pre>
   */
  public static final class TransitionRouteGroupsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TransitionRouteGroupsBlockingStub> {
    private TransitionRouteGroupsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransitionRouteGroupsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TransitionRouteGroupsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all transition route groups in the specified flow.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.ListTransitionRouteGroupsResponse
        listTransitionRouteGroups(
            com.google.cloud.dialogflow.cx.v3.ListTransitionRouteGroupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTransitionRouteGroupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified [TransitionRouteGroup][google.cloud.dialogflow.cx.v3.TransitionRouteGroup].
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup getTransitionRouteGroup(
        com.google.cloud.dialogflow.cx.v3.GetTransitionRouteGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTransitionRouteGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an [TransitionRouteGroup][google.cloud.dialogflow.cx.v3.TransitionRouteGroup] in the specified flow.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup createTransitionRouteGroup(
        com.google.cloud.dialogflow.cx.v3.CreateTransitionRouteGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTransitionRouteGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified [TransitionRouteGroup][google.cloud.dialogflow.cx.v3.TransitionRouteGroup].
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup updateTransitionRouteGroup(
        com.google.cloud.dialogflow.cx.v3.UpdateTransitionRouteGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTransitionRouteGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified [TransitionRouteGroup][google.cloud.dialogflow.cx.v3.TransitionRouteGroup].
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public com.google.protobuf.Empty deleteTransitionRouteGroup(
        com.google.cloud.dialogflow.cx.v3.DeleteTransitionRouteGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTransitionRouteGroupMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [TransitionRouteGroups][google.cloud.dialogflow.cx.v3.TransitionRouteGroup].
   * </pre>
   */
  public static final class TransitionRouteGroupsFutureStub
      extends io.grpc.stub.AbstractFutureStub<TransitionRouteGroupsFutureStub> {
    private TransitionRouteGroupsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransitionRouteGroupsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TransitionRouteGroupsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all transition route groups in the specified flow.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3.ListTransitionRouteGroupsResponse>
        listTransitionRouteGroups(
            com.google.cloud.dialogflow.cx.v3.ListTransitionRouteGroupsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTransitionRouteGroupsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified [TransitionRouteGroup][google.cloud.dialogflow.cx.v3.TransitionRouteGroup].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup>
        getTransitionRouteGroup(
            com.google.cloud.dialogflow.cx.v3.GetTransitionRouteGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTransitionRouteGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an [TransitionRouteGroup][google.cloud.dialogflow.cx.v3.TransitionRouteGroup] in the specified flow.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup>
        createTransitionRouteGroup(
            com.google.cloud.dialogflow.cx.v3.CreateTransitionRouteGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTransitionRouteGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified [TransitionRouteGroup][google.cloud.dialogflow.cx.v3.TransitionRouteGroup].
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup>
        updateTransitionRouteGroup(
            com.google.cloud.dialogflow.cx.v3.UpdateTransitionRouteGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTransitionRouteGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified [TransitionRouteGroup][google.cloud.dialogflow.cx.v3.TransitionRouteGroup].
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteTransitionRouteGroup(
            com.google.cloud.dialogflow.cx.v3.DeleteTransitionRouteGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTransitionRouteGroupMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_TRANSITION_ROUTE_GROUPS = 0;
  private static final int METHODID_GET_TRANSITION_ROUTE_GROUP = 1;
  private static final int METHODID_CREATE_TRANSITION_ROUTE_GROUP = 2;
  private static final int METHODID_UPDATE_TRANSITION_ROUTE_GROUP = 3;
  private static final int METHODID_DELETE_TRANSITION_ROUTE_GROUP = 4;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TransitionRouteGroupsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TransitionRouteGroupsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_TRANSITION_ROUTE_GROUPS:
          serviceImpl.listTransitionRouteGroups(
              (com.google.cloud.dialogflow.cx.v3.ListTransitionRouteGroupsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.cx.v3.ListTransitionRouteGroupsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_TRANSITION_ROUTE_GROUP:
          serviceImpl.getTransitionRouteGroup(
              (com.google.cloud.dialogflow.cx.v3.GetTransitionRouteGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup>)
                  responseObserver);
          break;
        case METHODID_CREATE_TRANSITION_ROUTE_GROUP:
          serviceImpl.createTransitionRouteGroup(
              (com.google.cloud.dialogflow.cx.v3.CreateTransitionRouteGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup>)
                  responseObserver);
          break;
        case METHODID_UPDATE_TRANSITION_ROUTE_GROUP:
          serviceImpl.updateTransitionRouteGroup(
              (com.google.cloud.dialogflow.cx.v3.UpdateTransitionRouteGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup>)
                  responseObserver);
          break;
        case METHODID_DELETE_TRANSITION_ROUTE_GROUP:
          serviceImpl.deleteTransitionRouteGroup(
              (com.google.cloud.dialogflow.cx.v3.DeleteTransitionRouteGroupRequest) request,
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

  private abstract static class TransitionRouteGroupsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TransitionRouteGroupsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.cx.v3.TransitionRouteGroupProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TransitionRouteGroups");
    }
  }

  private static final class TransitionRouteGroupsFileDescriptorSupplier
      extends TransitionRouteGroupsBaseDescriptorSupplier {
    TransitionRouteGroupsFileDescriptorSupplier() {}
  }

  private static final class TransitionRouteGroupsMethodDescriptorSupplier
      extends TransitionRouteGroupsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TransitionRouteGroupsMethodDescriptorSupplier(String methodName) {
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
      synchronized (TransitionRouteGroupsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new TransitionRouteGroupsFileDescriptorSupplier())
                      .addMethod(getListTransitionRouteGroupsMethod())
                      .addMethod(getGetTransitionRouteGroupMethod())
                      .addMethod(getCreateTransitionRouteGroupMethod())
                      .addMethod(getUpdateTransitionRouteGroupMethod())
                      .addMethod(getDeleteTransitionRouteGroupMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
