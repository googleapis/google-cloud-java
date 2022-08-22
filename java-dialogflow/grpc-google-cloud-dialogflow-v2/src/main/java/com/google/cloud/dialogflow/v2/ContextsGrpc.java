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
 * Service for managing [Contexts][google.cloud.dialogflow.v2.Context].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/v2/context.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ContextsGrpc {

  private ContextsGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dialogflow.v2.Contexts";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.ListContextsRequest,
          com.google.cloud.dialogflow.v2.ListContextsResponse>
      getListContextsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListContexts",
      requestType = com.google.cloud.dialogflow.v2.ListContextsRequest.class,
      responseType = com.google.cloud.dialogflow.v2.ListContextsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.ListContextsRequest,
          com.google.cloud.dialogflow.v2.ListContextsResponse>
      getListContextsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.ListContextsRequest,
            com.google.cloud.dialogflow.v2.ListContextsResponse>
        getListContextsMethod;
    if ((getListContextsMethod = ContextsGrpc.getListContextsMethod) == null) {
      synchronized (ContextsGrpc.class) {
        if ((getListContextsMethod = ContextsGrpc.getListContextsMethod) == null) {
          ContextsGrpc.getListContextsMethod =
              getListContextsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.ListContextsRequest,
                          com.google.cloud.dialogflow.v2.ListContextsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListContexts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.ListContextsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.ListContextsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ContextsMethodDescriptorSupplier("ListContexts"))
                      .build();
        }
      }
    }
    return getListContextsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.GetContextRequest, com.google.cloud.dialogflow.v2.Context>
      getGetContextMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetContext",
      requestType = com.google.cloud.dialogflow.v2.GetContextRequest.class,
      responseType = com.google.cloud.dialogflow.v2.Context.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.GetContextRequest, com.google.cloud.dialogflow.v2.Context>
      getGetContextMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.GetContextRequest,
            com.google.cloud.dialogflow.v2.Context>
        getGetContextMethod;
    if ((getGetContextMethod = ContextsGrpc.getGetContextMethod) == null) {
      synchronized (ContextsGrpc.class) {
        if ((getGetContextMethod = ContextsGrpc.getGetContextMethod) == null) {
          ContextsGrpc.getGetContextMethod =
              getGetContextMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.GetContextRequest,
                          com.google.cloud.dialogflow.v2.Context>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetContext"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.GetContextRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.Context.getDefaultInstance()))
                      .setSchemaDescriptor(new ContextsMethodDescriptorSupplier("GetContext"))
                      .build();
        }
      }
    }
    return getGetContextMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.CreateContextRequest,
          com.google.cloud.dialogflow.v2.Context>
      getCreateContextMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateContext",
      requestType = com.google.cloud.dialogflow.v2.CreateContextRequest.class,
      responseType = com.google.cloud.dialogflow.v2.Context.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.CreateContextRequest,
          com.google.cloud.dialogflow.v2.Context>
      getCreateContextMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.CreateContextRequest,
            com.google.cloud.dialogflow.v2.Context>
        getCreateContextMethod;
    if ((getCreateContextMethod = ContextsGrpc.getCreateContextMethod) == null) {
      synchronized (ContextsGrpc.class) {
        if ((getCreateContextMethod = ContextsGrpc.getCreateContextMethod) == null) {
          ContextsGrpc.getCreateContextMethod =
              getCreateContextMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.CreateContextRequest,
                          com.google.cloud.dialogflow.v2.Context>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateContext"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.CreateContextRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.Context.getDefaultInstance()))
                      .setSchemaDescriptor(new ContextsMethodDescriptorSupplier("CreateContext"))
                      .build();
        }
      }
    }
    return getCreateContextMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.UpdateContextRequest,
          com.google.cloud.dialogflow.v2.Context>
      getUpdateContextMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateContext",
      requestType = com.google.cloud.dialogflow.v2.UpdateContextRequest.class,
      responseType = com.google.cloud.dialogflow.v2.Context.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.UpdateContextRequest,
          com.google.cloud.dialogflow.v2.Context>
      getUpdateContextMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.UpdateContextRequest,
            com.google.cloud.dialogflow.v2.Context>
        getUpdateContextMethod;
    if ((getUpdateContextMethod = ContextsGrpc.getUpdateContextMethod) == null) {
      synchronized (ContextsGrpc.class) {
        if ((getUpdateContextMethod = ContextsGrpc.getUpdateContextMethod) == null) {
          ContextsGrpc.getUpdateContextMethod =
              getUpdateContextMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.UpdateContextRequest,
                          com.google.cloud.dialogflow.v2.Context>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateContext"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.UpdateContextRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.Context.getDefaultInstance()))
                      .setSchemaDescriptor(new ContextsMethodDescriptorSupplier("UpdateContext"))
                      .build();
        }
      }
    }
    return getUpdateContextMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.DeleteContextRequest, com.google.protobuf.Empty>
      getDeleteContextMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteContext",
      requestType = com.google.cloud.dialogflow.v2.DeleteContextRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.DeleteContextRequest, com.google.protobuf.Empty>
      getDeleteContextMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.DeleteContextRequest, com.google.protobuf.Empty>
        getDeleteContextMethod;
    if ((getDeleteContextMethod = ContextsGrpc.getDeleteContextMethod) == null) {
      synchronized (ContextsGrpc.class) {
        if ((getDeleteContextMethod = ContextsGrpc.getDeleteContextMethod) == null) {
          ContextsGrpc.getDeleteContextMethod =
              getDeleteContextMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.DeleteContextRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteContext"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.DeleteContextRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new ContextsMethodDescriptorSupplier("DeleteContext"))
                      .build();
        }
      }
    }
    return getDeleteContextMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.DeleteAllContextsRequest, com.google.protobuf.Empty>
      getDeleteAllContextsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAllContexts",
      requestType = com.google.cloud.dialogflow.v2.DeleteAllContextsRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.DeleteAllContextsRequest, com.google.protobuf.Empty>
      getDeleteAllContextsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.DeleteAllContextsRequest, com.google.protobuf.Empty>
        getDeleteAllContextsMethod;
    if ((getDeleteAllContextsMethod = ContextsGrpc.getDeleteAllContextsMethod) == null) {
      synchronized (ContextsGrpc.class) {
        if ((getDeleteAllContextsMethod = ContextsGrpc.getDeleteAllContextsMethod) == null) {
          ContextsGrpc.getDeleteAllContextsMethod =
              getDeleteAllContextsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.DeleteAllContextsRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAllContexts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.DeleteAllContextsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContextsMethodDescriptorSupplier("DeleteAllContexts"))
                      .build();
        }
      }
    }
    return getDeleteAllContextsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ContextsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContextsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ContextsStub>() {
          @java.lang.Override
          public ContextsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ContextsStub(channel, callOptions);
          }
        };
    return ContextsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ContextsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContextsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ContextsBlockingStub>() {
          @java.lang.Override
          public ContextsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ContextsBlockingStub(channel, callOptions);
          }
        };
    return ContextsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ContextsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContextsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ContextsFutureStub>() {
          @java.lang.Override
          public ContextsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ContextsFutureStub(channel, callOptions);
          }
        };
    return ContextsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Contexts][google.cloud.dialogflow.v2.Context].
   * </pre>
   */
  public abstract static class ContextsImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Returns the list of all contexts in the specified session.
     * </pre>
     */
    public void listContexts(
        com.google.cloud.dialogflow.v2.ListContextsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListContextsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListContextsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified context.
     * </pre>
     */
    public void getContext(
        com.google.cloud.dialogflow.v2.GetContextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Context> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetContextMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a context.
     * If the specified context already exists, overrides the context.
     * </pre>
     */
    public void createContext(
        com.google.cloud.dialogflow.v2.CreateContextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Context> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateContextMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified context.
     * </pre>
     */
    public void updateContext(
        com.google.cloud.dialogflow.v2.UpdateContextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Context> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateContextMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified context.
     * </pre>
     */
    public void deleteContext(
        com.google.cloud.dialogflow.v2.DeleteContextRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteContextMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes all active contexts in the specified session.
     * </pre>
     */
    public void deleteAllContexts(
        com.google.cloud.dialogflow.v2.DeleteAllContextsRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAllContextsMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListContextsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.ListContextsRequest,
                      com.google.cloud.dialogflow.v2.ListContextsResponse>(
                      this, METHODID_LIST_CONTEXTS)))
          .addMethod(
              getGetContextMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.GetContextRequest,
                      com.google.cloud.dialogflow.v2.Context>(this, METHODID_GET_CONTEXT)))
          .addMethod(
              getCreateContextMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.CreateContextRequest,
                      com.google.cloud.dialogflow.v2.Context>(this, METHODID_CREATE_CONTEXT)))
          .addMethod(
              getUpdateContextMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.UpdateContextRequest,
                      com.google.cloud.dialogflow.v2.Context>(this, METHODID_UPDATE_CONTEXT)))
          .addMethod(
              getDeleteContextMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.DeleteContextRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_CONTEXT)))
          .addMethod(
              getDeleteAllContextsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.DeleteAllContextsRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_ALL_CONTEXTS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Contexts][google.cloud.dialogflow.v2.Context].
   * </pre>
   */
  public static final class ContextsStub extends io.grpc.stub.AbstractAsyncStub<ContextsStub> {
    private ContextsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContextsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContextsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all contexts in the specified session.
     * </pre>
     */
    public void listContexts(
        com.google.cloud.dialogflow.v2.ListContextsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListContextsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListContextsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified context.
     * </pre>
     */
    public void getContext(
        com.google.cloud.dialogflow.v2.GetContextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Context> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetContextMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a context.
     * If the specified context already exists, overrides the context.
     * </pre>
     */
    public void createContext(
        com.google.cloud.dialogflow.v2.CreateContextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Context> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateContextMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified context.
     * </pre>
     */
    public void updateContext(
        com.google.cloud.dialogflow.v2.UpdateContextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Context> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateContextMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified context.
     * </pre>
     */
    public void deleteContext(
        com.google.cloud.dialogflow.v2.DeleteContextRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteContextMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes all active contexts in the specified session.
     * </pre>
     */
    public void deleteAllContexts(
        com.google.cloud.dialogflow.v2.DeleteAllContextsRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAllContextsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Contexts][google.cloud.dialogflow.v2.Context].
   * </pre>
   */
  public static final class ContextsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ContextsBlockingStub> {
    private ContextsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContextsBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContextsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all contexts in the specified session.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.ListContextsResponse listContexts(
        com.google.cloud.dialogflow.v2.ListContextsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListContextsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified context.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.Context getContext(
        com.google.cloud.dialogflow.v2.GetContextRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetContextMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a context.
     * If the specified context already exists, overrides the context.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.Context createContext(
        com.google.cloud.dialogflow.v2.CreateContextRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateContextMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified context.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.Context updateContext(
        com.google.cloud.dialogflow.v2.UpdateContextRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateContextMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified context.
     * </pre>
     */
    public com.google.protobuf.Empty deleteContext(
        com.google.cloud.dialogflow.v2.DeleteContextRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteContextMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes all active contexts in the specified session.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAllContexts(
        com.google.cloud.dialogflow.v2.DeleteAllContextsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAllContextsMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Contexts][google.cloud.dialogflow.v2.Context].
   * </pre>
   */
  public static final class ContextsFutureStub
      extends io.grpc.stub.AbstractFutureStub<ContextsFutureStub> {
    private ContextsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContextsFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContextsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all contexts in the specified session.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.ListContextsResponse>
        listContexts(com.google.cloud.dialogflow.v2.ListContextsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListContextsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified context.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.Context>
        getContext(com.google.cloud.dialogflow.v2.GetContextRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetContextMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a context.
     * If the specified context already exists, overrides the context.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.Context>
        createContext(com.google.cloud.dialogflow.v2.CreateContextRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateContextMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified context.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.Context>
        updateContext(com.google.cloud.dialogflow.v2.UpdateContextRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateContextMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified context.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteContext(com.google.cloud.dialogflow.v2.DeleteContextRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteContextMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes all active contexts in the specified session.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteAllContexts(com.google.cloud.dialogflow.v2.DeleteAllContextsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAllContextsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_CONTEXTS = 0;
  private static final int METHODID_GET_CONTEXT = 1;
  private static final int METHODID_CREATE_CONTEXT = 2;
  private static final int METHODID_UPDATE_CONTEXT = 3;
  private static final int METHODID_DELETE_CONTEXT = 4;
  private static final int METHODID_DELETE_ALL_CONTEXTS = 5;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ContextsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ContextsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_CONTEXTS:
          serviceImpl.listContexts(
              (com.google.cloud.dialogflow.v2.ListContextsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListContextsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CONTEXT:
          serviceImpl.getContext(
              (com.google.cloud.dialogflow.v2.GetContextRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Context>)
                  responseObserver);
          break;
        case METHODID_CREATE_CONTEXT:
          serviceImpl.createContext(
              (com.google.cloud.dialogflow.v2.CreateContextRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Context>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CONTEXT:
          serviceImpl.updateContext(
              (com.google.cloud.dialogflow.v2.UpdateContextRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Context>)
                  responseObserver);
          break;
        case METHODID_DELETE_CONTEXT:
          serviceImpl.deleteContext(
              (com.google.cloud.dialogflow.v2.DeleteContextRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_DELETE_ALL_CONTEXTS:
          serviceImpl.deleteAllContexts(
              (com.google.cloud.dialogflow.v2.DeleteAllContextsRequest) request,
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

  private abstract static class ContextsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ContextsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.v2.ContextProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Contexts");
    }
  }

  private static final class ContextsFileDescriptorSupplier extends ContextsBaseDescriptorSupplier {
    ContextsFileDescriptorSupplier() {}
  }

  private static final class ContextsMethodDescriptorSupplier extends ContextsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ContextsMethodDescriptorSupplier(String methodName) {
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
      synchronized (ContextsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ContextsFileDescriptorSupplier())
                      .addMethod(getListContextsMethod())
                      .addMethod(getGetContextMethod())
                      .addMethod(getCreateContextMethod())
                      .addMethod(getUpdateContextMethod())
                      .addMethod(getDeleteContextMethod())
                      .addMethod(getDeleteAllContextsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
