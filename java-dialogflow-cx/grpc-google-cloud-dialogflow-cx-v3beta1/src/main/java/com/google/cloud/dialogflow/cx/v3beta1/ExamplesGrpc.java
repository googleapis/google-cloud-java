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
package com.google.cloud.dialogflow.cx.v3beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing [Examples][google.cloud.dialogflow.cx.v3beta1.Example].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/cx/v3beta1/example.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ExamplesGrpc {

  private ExamplesGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.dialogflow.cx.v3beta1.Examples";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.CreateExampleRequest,
          com.google.cloud.dialogflow.cx.v3beta1.Example>
      getCreateExampleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateExample",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.CreateExampleRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.Example.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.CreateExampleRequest,
          com.google.cloud.dialogflow.cx.v3beta1.Example>
      getCreateExampleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.CreateExampleRequest,
            com.google.cloud.dialogflow.cx.v3beta1.Example>
        getCreateExampleMethod;
    if ((getCreateExampleMethod = ExamplesGrpc.getCreateExampleMethod) == null) {
      synchronized (ExamplesGrpc.class) {
        if ((getCreateExampleMethod = ExamplesGrpc.getCreateExampleMethod) == null) {
          ExamplesGrpc.getCreateExampleMethod =
              getCreateExampleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.CreateExampleRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.Example>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateExample"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.CreateExampleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.Example.getDefaultInstance()))
                      .setSchemaDescriptor(new ExamplesMethodDescriptorSupplier("CreateExample"))
                      .build();
        }
      }
    }
    return getCreateExampleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.DeleteExampleRequest, com.google.protobuf.Empty>
      getDeleteExampleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteExample",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.DeleteExampleRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.DeleteExampleRequest, com.google.protobuf.Empty>
      getDeleteExampleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.DeleteExampleRequest, com.google.protobuf.Empty>
        getDeleteExampleMethod;
    if ((getDeleteExampleMethod = ExamplesGrpc.getDeleteExampleMethod) == null) {
      synchronized (ExamplesGrpc.class) {
        if ((getDeleteExampleMethod = ExamplesGrpc.getDeleteExampleMethod) == null) {
          ExamplesGrpc.getDeleteExampleMethod =
              getDeleteExampleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.DeleteExampleRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteExample"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.DeleteExampleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new ExamplesMethodDescriptorSupplier("DeleteExample"))
                      .build();
        }
      }
    }
    return getDeleteExampleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.ListExamplesRequest,
          com.google.cloud.dialogflow.cx.v3beta1.ListExamplesResponse>
      getListExamplesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListExamples",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.ListExamplesRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.ListExamplesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.ListExamplesRequest,
          com.google.cloud.dialogflow.cx.v3beta1.ListExamplesResponse>
      getListExamplesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.ListExamplesRequest,
            com.google.cloud.dialogflow.cx.v3beta1.ListExamplesResponse>
        getListExamplesMethod;
    if ((getListExamplesMethod = ExamplesGrpc.getListExamplesMethod) == null) {
      synchronized (ExamplesGrpc.class) {
        if ((getListExamplesMethod = ExamplesGrpc.getListExamplesMethod) == null) {
          ExamplesGrpc.getListExamplesMethod =
              getListExamplesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.ListExamplesRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.ListExamplesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListExamples"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.ListExamplesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.ListExamplesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ExamplesMethodDescriptorSupplier("ListExamples"))
                      .build();
        }
      }
    }
    return getListExamplesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.GetExampleRequest,
          com.google.cloud.dialogflow.cx.v3beta1.Example>
      getGetExampleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetExample",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.GetExampleRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.Example.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.GetExampleRequest,
          com.google.cloud.dialogflow.cx.v3beta1.Example>
      getGetExampleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.GetExampleRequest,
            com.google.cloud.dialogflow.cx.v3beta1.Example>
        getGetExampleMethod;
    if ((getGetExampleMethod = ExamplesGrpc.getGetExampleMethod) == null) {
      synchronized (ExamplesGrpc.class) {
        if ((getGetExampleMethod = ExamplesGrpc.getGetExampleMethod) == null) {
          ExamplesGrpc.getGetExampleMethod =
              getGetExampleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.GetExampleRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.Example>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetExample"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.GetExampleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.Example.getDefaultInstance()))
                      .setSchemaDescriptor(new ExamplesMethodDescriptorSupplier("GetExample"))
                      .build();
        }
      }
    }
    return getGetExampleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.UpdateExampleRequest,
          com.google.cloud.dialogflow.cx.v3beta1.Example>
      getUpdateExampleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateExample",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.UpdateExampleRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.Example.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.UpdateExampleRequest,
          com.google.cloud.dialogflow.cx.v3beta1.Example>
      getUpdateExampleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.UpdateExampleRequest,
            com.google.cloud.dialogflow.cx.v3beta1.Example>
        getUpdateExampleMethod;
    if ((getUpdateExampleMethod = ExamplesGrpc.getUpdateExampleMethod) == null) {
      synchronized (ExamplesGrpc.class) {
        if ((getUpdateExampleMethod = ExamplesGrpc.getUpdateExampleMethod) == null) {
          ExamplesGrpc.getUpdateExampleMethod =
              getUpdateExampleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.UpdateExampleRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.Example>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateExample"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.UpdateExampleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.Example.getDefaultInstance()))
                      .setSchemaDescriptor(new ExamplesMethodDescriptorSupplier("UpdateExample"))
                      .build();
        }
      }
    }
    return getUpdateExampleMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ExamplesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExamplesStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ExamplesStub>() {
          @java.lang.Override
          public ExamplesStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ExamplesStub(channel, callOptions);
          }
        };
    return ExamplesStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ExamplesBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExamplesBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ExamplesBlockingStub>() {
          @java.lang.Override
          public ExamplesBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ExamplesBlockingStub(channel, callOptions);
          }
        };
    return ExamplesBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ExamplesFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExamplesFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ExamplesFutureStub>() {
          @java.lang.Override
          public ExamplesFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ExamplesFutureStub(channel, callOptions);
          }
        };
    return ExamplesFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Examples][google.cloud.dialogflow.cx.v3beta1.Example].
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates an example in the specified playbook.
     * </pre>
     */
    default void createExample(
        com.google.cloud.dialogflow.cx.v3beta1.CreateExampleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Example>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateExampleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified example.
     * </pre>
     */
    default void deleteExample(
        com.google.cloud.dialogflow.cx.v3beta1.DeleteExampleRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteExampleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of examples in the specified playbook.
     * </pre>
     */
    default void listExamples(
        com.google.cloud.dialogflow.cx.v3beta1.ListExamplesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.ListExamplesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListExamplesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified example.
     * </pre>
     */
    default void getExample(
        com.google.cloud.dialogflow.cx.v3beta1.GetExampleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Example>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetExampleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update the specified example.
     * </pre>
     */
    default void updateExample(
        com.google.cloud.dialogflow.cx.v3beta1.UpdateExampleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Example>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateExampleMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Examples.
   *
   * <pre>
   * Service for managing [Examples][google.cloud.dialogflow.cx.v3beta1.Example].
   * </pre>
   */
  public abstract static class ExamplesImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ExamplesGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Examples.
   *
   * <pre>
   * Service for managing [Examples][google.cloud.dialogflow.cx.v3beta1.Example].
   * </pre>
   */
  public static final class ExamplesStub extends io.grpc.stub.AbstractAsyncStub<ExamplesStub> {
    private ExamplesStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExamplesStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExamplesStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an example in the specified playbook.
     * </pre>
     */
    public void createExample(
        com.google.cloud.dialogflow.cx.v3beta1.CreateExampleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Example>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateExampleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified example.
     * </pre>
     */
    public void deleteExample(
        com.google.cloud.dialogflow.cx.v3beta1.DeleteExampleRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteExampleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of examples in the specified playbook.
     * </pre>
     */
    public void listExamples(
        com.google.cloud.dialogflow.cx.v3beta1.ListExamplesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.ListExamplesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListExamplesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified example.
     * </pre>
     */
    public void getExample(
        com.google.cloud.dialogflow.cx.v3beta1.GetExampleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Example>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetExampleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update the specified example.
     * </pre>
     */
    public void updateExample(
        com.google.cloud.dialogflow.cx.v3beta1.UpdateExampleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Example>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateExampleMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Examples.
   *
   * <pre>
   * Service for managing [Examples][google.cloud.dialogflow.cx.v3beta1.Example].
   * </pre>
   */
  public static final class ExamplesBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ExamplesBlockingStub> {
    private ExamplesBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExamplesBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExamplesBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an example in the specified playbook.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.Example createExample(
        com.google.cloud.dialogflow.cx.v3beta1.CreateExampleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateExampleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified example.
     * </pre>
     */
    public com.google.protobuf.Empty deleteExample(
        com.google.cloud.dialogflow.cx.v3beta1.DeleteExampleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteExampleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of examples in the specified playbook.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.ListExamplesResponse listExamples(
        com.google.cloud.dialogflow.cx.v3beta1.ListExamplesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListExamplesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified example.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.Example getExample(
        com.google.cloud.dialogflow.cx.v3beta1.GetExampleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetExampleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update the specified example.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.Example updateExample(
        com.google.cloud.dialogflow.cx.v3beta1.UpdateExampleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateExampleMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Examples.
   *
   * <pre>
   * Service for managing [Examples][google.cloud.dialogflow.cx.v3beta1.Example].
   * </pre>
   */
  public static final class ExamplesFutureStub
      extends io.grpc.stub.AbstractFutureStub<ExamplesFutureStub> {
    private ExamplesFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExamplesFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExamplesFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an example in the specified playbook.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.Example>
        createExample(com.google.cloud.dialogflow.cx.v3beta1.CreateExampleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateExampleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified example.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteExample(com.google.cloud.dialogflow.cx.v3beta1.DeleteExampleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteExampleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of examples in the specified playbook.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.ListExamplesResponse>
        listExamples(com.google.cloud.dialogflow.cx.v3beta1.ListExamplesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListExamplesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified example.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.Example>
        getExample(com.google.cloud.dialogflow.cx.v3beta1.GetExampleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetExampleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update the specified example.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.Example>
        updateExample(com.google.cloud.dialogflow.cx.v3beta1.UpdateExampleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateExampleMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_EXAMPLE = 0;
  private static final int METHODID_DELETE_EXAMPLE = 1;
  private static final int METHODID_LIST_EXAMPLES = 2;
  private static final int METHODID_GET_EXAMPLE = 3;
  private static final int METHODID_UPDATE_EXAMPLE = 4;

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
        case METHODID_CREATE_EXAMPLE:
          serviceImpl.createExample(
              (com.google.cloud.dialogflow.cx.v3beta1.CreateExampleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Example>)
                  responseObserver);
          break;
        case METHODID_DELETE_EXAMPLE:
          serviceImpl.deleteExample(
              (com.google.cloud.dialogflow.cx.v3beta1.DeleteExampleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_EXAMPLES:
          serviceImpl.listExamples(
              (com.google.cloud.dialogflow.cx.v3beta1.ListExamplesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.cx.v3beta1.ListExamplesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_EXAMPLE:
          serviceImpl.getExample(
              (com.google.cloud.dialogflow.cx.v3beta1.GetExampleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Example>)
                  responseObserver);
          break;
        case METHODID_UPDATE_EXAMPLE:
          serviceImpl.updateExample(
              (com.google.cloud.dialogflow.cx.v3beta1.UpdateExampleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Example>)
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
            getCreateExampleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3beta1.CreateExampleRequest,
                    com.google.cloud.dialogflow.cx.v3beta1.Example>(
                    service, METHODID_CREATE_EXAMPLE)))
        .addMethod(
            getDeleteExampleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3beta1.DeleteExampleRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_EXAMPLE)))
        .addMethod(
            getListExamplesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3beta1.ListExamplesRequest,
                    com.google.cloud.dialogflow.cx.v3beta1.ListExamplesResponse>(
                    service, METHODID_LIST_EXAMPLES)))
        .addMethod(
            getGetExampleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3beta1.GetExampleRequest,
                    com.google.cloud.dialogflow.cx.v3beta1.Example>(service, METHODID_GET_EXAMPLE)))
        .addMethod(
            getUpdateExampleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3beta1.UpdateExampleRequest,
                    com.google.cloud.dialogflow.cx.v3beta1.Example>(
                    service, METHODID_UPDATE_EXAMPLE)))
        .build();
  }

  private abstract static class ExamplesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ExamplesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.cx.v3beta1.ExampleProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Examples");
    }
  }

  private static final class ExamplesFileDescriptorSupplier extends ExamplesBaseDescriptorSupplier {
    ExamplesFileDescriptorSupplier() {}
  }

  private static final class ExamplesMethodDescriptorSupplier extends ExamplesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ExamplesMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ExamplesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ExamplesFileDescriptorSupplier())
                      .addMethod(getCreateExampleMethod())
                      .addMethod(getDeleteExampleMethod())
                      .addMethod(getListExamplesMethod())
                      .addMethod(getGetExampleMethod())
                      .addMethod(getUpdateExampleMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
