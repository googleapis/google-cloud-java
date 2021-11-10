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
package com.google.cloud.dialogflow.v2beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing [Intents][google.cloud.dialogflow.v2beta1.Intent].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/v2beta1/intent.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class IntentsGrpc {

  private IntentsGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dialogflow.v2beta1.Intents";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.ListIntentsRequest,
          com.google.cloud.dialogflow.v2beta1.ListIntentsResponse>
      getListIntentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListIntents",
      requestType = com.google.cloud.dialogflow.v2beta1.ListIntentsRequest.class,
      responseType = com.google.cloud.dialogflow.v2beta1.ListIntentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.ListIntentsRequest,
          com.google.cloud.dialogflow.v2beta1.ListIntentsResponse>
      getListIntentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.ListIntentsRequest,
            com.google.cloud.dialogflow.v2beta1.ListIntentsResponse>
        getListIntentsMethod;
    if ((getListIntentsMethod = IntentsGrpc.getListIntentsMethod) == null) {
      synchronized (IntentsGrpc.class) {
        if ((getListIntentsMethod = IntentsGrpc.getListIntentsMethod) == null) {
          IntentsGrpc.getListIntentsMethod =
              getListIntentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.ListIntentsRequest,
                          com.google.cloud.dialogflow.v2beta1.ListIntentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListIntents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.ListIntentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.ListIntentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new IntentsMethodDescriptorSupplier("ListIntents"))
                      .build();
        }
      }
    }
    return getListIntentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.GetIntentRequest,
          com.google.cloud.dialogflow.v2beta1.Intent>
      getGetIntentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIntent",
      requestType = com.google.cloud.dialogflow.v2beta1.GetIntentRequest.class,
      responseType = com.google.cloud.dialogflow.v2beta1.Intent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.GetIntentRequest,
          com.google.cloud.dialogflow.v2beta1.Intent>
      getGetIntentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.GetIntentRequest,
            com.google.cloud.dialogflow.v2beta1.Intent>
        getGetIntentMethod;
    if ((getGetIntentMethod = IntentsGrpc.getGetIntentMethod) == null) {
      synchronized (IntentsGrpc.class) {
        if ((getGetIntentMethod = IntentsGrpc.getGetIntentMethod) == null) {
          IntentsGrpc.getGetIntentMethod =
              getGetIntentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.GetIntentRequest,
                          com.google.cloud.dialogflow.v2beta1.Intent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIntent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.GetIntentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.Intent.getDefaultInstance()))
                      .setSchemaDescriptor(new IntentsMethodDescriptorSupplier("GetIntent"))
                      .build();
        }
      }
    }
    return getGetIntentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.CreateIntentRequest,
          com.google.cloud.dialogflow.v2beta1.Intent>
      getCreateIntentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateIntent",
      requestType = com.google.cloud.dialogflow.v2beta1.CreateIntentRequest.class,
      responseType = com.google.cloud.dialogflow.v2beta1.Intent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.CreateIntentRequest,
          com.google.cloud.dialogflow.v2beta1.Intent>
      getCreateIntentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.CreateIntentRequest,
            com.google.cloud.dialogflow.v2beta1.Intent>
        getCreateIntentMethod;
    if ((getCreateIntentMethod = IntentsGrpc.getCreateIntentMethod) == null) {
      synchronized (IntentsGrpc.class) {
        if ((getCreateIntentMethod = IntentsGrpc.getCreateIntentMethod) == null) {
          IntentsGrpc.getCreateIntentMethod =
              getCreateIntentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.CreateIntentRequest,
                          com.google.cloud.dialogflow.v2beta1.Intent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateIntent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.CreateIntentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.Intent.getDefaultInstance()))
                      .setSchemaDescriptor(new IntentsMethodDescriptorSupplier("CreateIntent"))
                      .build();
        }
      }
    }
    return getCreateIntentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.UpdateIntentRequest,
          com.google.cloud.dialogflow.v2beta1.Intent>
      getUpdateIntentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateIntent",
      requestType = com.google.cloud.dialogflow.v2beta1.UpdateIntentRequest.class,
      responseType = com.google.cloud.dialogflow.v2beta1.Intent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.UpdateIntentRequest,
          com.google.cloud.dialogflow.v2beta1.Intent>
      getUpdateIntentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.UpdateIntentRequest,
            com.google.cloud.dialogflow.v2beta1.Intent>
        getUpdateIntentMethod;
    if ((getUpdateIntentMethod = IntentsGrpc.getUpdateIntentMethod) == null) {
      synchronized (IntentsGrpc.class) {
        if ((getUpdateIntentMethod = IntentsGrpc.getUpdateIntentMethod) == null) {
          IntentsGrpc.getUpdateIntentMethod =
              getUpdateIntentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.UpdateIntentRequest,
                          com.google.cloud.dialogflow.v2beta1.Intent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateIntent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.UpdateIntentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.Intent.getDefaultInstance()))
                      .setSchemaDescriptor(new IntentsMethodDescriptorSupplier("UpdateIntent"))
                      .build();
        }
      }
    }
    return getUpdateIntentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.DeleteIntentRequest, com.google.protobuf.Empty>
      getDeleteIntentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteIntent",
      requestType = com.google.cloud.dialogflow.v2beta1.DeleteIntentRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.DeleteIntentRequest, com.google.protobuf.Empty>
      getDeleteIntentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.DeleteIntentRequest, com.google.protobuf.Empty>
        getDeleteIntentMethod;
    if ((getDeleteIntentMethod = IntentsGrpc.getDeleteIntentMethod) == null) {
      synchronized (IntentsGrpc.class) {
        if ((getDeleteIntentMethod = IntentsGrpc.getDeleteIntentMethod) == null) {
          IntentsGrpc.getDeleteIntentMethod =
              getDeleteIntentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.DeleteIntentRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteIntent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.DeleteIntentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new IntentsMethodDescriptorSupplier("DeleteIntent"))
                      .build();
        }
      }
    }
    return getDeleteIntentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.BatchUpdateIntentsRequest,
          com.google.longrunning.Operation>
      getBatchUpdateIntentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchUpdateIntents",
      requestType = com.google.cloud.dialogflow.v2beta1.BatchUpdateIntentsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.BatchUpdateIntentsRequest,
          com.google.longrunning.Operation>
      getBatchUpdateIntentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.BatchUpdateIntentsRequest,
            com.google.longrunning.Operation>
        getBatchUpdateIntentsMethod;
    if ((getBatchUpdateIntentsMethod = IntentsGrpc.getBatchUpdateIntentsMethod) == null) {
      synchronized (IntentsGrpc.class) {
        if ((getBatchUpdateIntentsMethod = IntentsGrpc.getBatchUpdateIntentsMethod) == null) {
          IntentsGrpc.getBatchUpdateIntentsMethod =
              getBatchUpdateIntentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.BatchUpdateIntentsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchUpdateIntents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.BatchUpdateIntentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IntentsMethodDescriptorSupplier("BatchUpdateIntents"))
                      .build();
        }
      }
    }
    return getBatchUpdateIntentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.BatchDeleteIntentsRequest,
          com.google.longrunning.Operation>
      getBatchDeleteIntentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchDeleteIntents",
      requestType = com.google.cloud.dialogflow.v2beta1.BatchDeleteIntentsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.BatchDeleteIntentsRequest,
          com.google.longrunning.Operation>
      getBatchDeleteIntentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.BatchDeleteIntentsRequest,
            com.google.longrunning.Operation>
        getBatchDeleteIntentsMethod;
    if ((getBatchDeleteIntentsMethod = IntentsGrpc.getBatchDeleteIntentsMethod) == null) {
      synchronized (IntentsGrpc.class) {
        if ((getBatchDeleteIntentsMethod = IntentsGrpc.getBatchDeleteIntentsMethod) == null) {
          IntentsGrpc.getBatchDeleteIntentsMethod =
              getBatchDeleteIntentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.BatchDeleteIntentsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchDeleteIntents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.BatchDeleteIntentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IntentsMethodDescriptorSupplier("BatchDeleteIntents"))
                      .build();
        }
      }
    }
    return getBatchDeleteIntentsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static IntentsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IntentsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IntentsStub>() {
          @java.lang.Override
          public IntentsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IntentsStub(channel, callOptions);
          }
        };
    return IntentsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IntentsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IntentsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IntentsBlockingStub>() {
          @java.lang.Override
          public IntentsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IntentsBlockingStub(channel, callOptions);
          }
        };
    return IntentsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static IntentsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IntentsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IntentsFutureStub>() {
          @java.lang.Override
          public IntentsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IntentsFutureStub(channel, callOptions);
          }
        };
    return IntentsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Intents][google.cloud.dialogflow.v2beta1.Intent].
   * </pre>
   */
  public abstract static class IntentsImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Returns the list of all intents in the specified agent.
     * </pre>
     */
    public void listIntents(
        com.google.cloud.dialogflow.v2beta1.ListIntentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.ListIntentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListIntentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified intent.
     * </pre>
     */
    public void getIntent(
        com.google.cloud.dialogflow.v2beta1.GetIntentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Intent> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetIntentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an intent in the specified agent.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public void createIntent(
        com.google.cloud.dialogflow.v2beta1.CreateIntentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Intent> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateIntentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified intent.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public void updateIntent(
        com.google.cloud.dialogflow.v2beta1.UpdateIntentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Intent> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateIntentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified intent and its direct or indirect followup intents.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public void deleteIntent(
        com.google.cloud.dialogflow.v2beta1.DeleteIntentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteIntentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates/Creates multiple intents in the specified agent.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: [BatchUpdateIntentsResponse][google.cloud.dialogflow.v2beta1.BatchUpdateIntentsResponse]
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public void batchUpdateIntents(
        com.google.cloud.dialogflow.v2beta1.BatchUpdateIntentsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchUpdateIntentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes intents in the specified agent.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public void batchDeleteIntents(
        com.google.cloud.dialogflow.v2beta1.BatchDeleteIntentsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchDeleteIntentsMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListIntentsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.ListIntentsRequest,
                      com.google.cloud.dialogflow.v2beta1.ListIntentsResponse>(
                      this, METHODID_LIST_INTENTS)))
          .addMethod(
              getGetIntentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.GetIntentRequest,
                      com.google.cloud.dialogflow.v2beta1.Intent>(this, METHODID_GET_INTENT)))
          .addMethod(
              getCreateIntentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.CreateIntentRequest,
                      com.google.cloud.dialogflow.v2beta1.Intent>(this, METHODID_CREATE_INTENT)))
          .addMethod(
              getUpdateIntentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.UpdateIntentRequest,
                      com.google.cloud.dialogflow.v2beta1.Intent>(this, METHODID_UPDATE_INTENT)))
          .addMethod(
              getDeleteIntentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.DeleteIntentRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_INTENT)))
          .addMethod(
              getBatchUpdateIntentsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.BatchUpdateIntentsRequest,
                      com.google.longrunning.Operation>(this, METHODID_BATCH_UPDATE_INTENTS)))
          .addMethod(
              getBatchDeleteIntentsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.BatchDeleteIntentsRequest,
                      com.google.longrunning.Operation>(this, METHODID_BATCH_DELETE_INTENTS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Intents][google.cloud.dialogflow.v2beta1.Intent].
   * </pre>
   */
  public static final class IntentsStub extends io.grpc.stub.AbstractAsyncStub<IntentsStub> {
    private IntentsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IntentsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IntentsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all intents in the specified agent.
     * </pre>
     */
    public void listIntents(
        com.google.cloud.dialogflow.v2beta1.ListIntentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.ListIntentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListIntentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified intent.
     * </pre>
     */
    public void getIntent(
        com.google.cloud.dialogflow.v2beta1.GetIntentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Intent> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIntentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an intent in the specified agent.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public void createIntent(
        com.google.cloud.dialogflow.v2beta1.CreateIntentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Intent> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateIntentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified intent.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public void updateIntent(
        com.google.cloud.dialogflow.v2beta1.UpdateIntentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Intent> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateIntentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified intent and its direct or indirect followup intents.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public void deleteIntent(
        com.google.cloud.dialogflow.v2beta1.DeleteIntentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteIntentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates/Creates multiple intents in the specified agent.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: [BatchUpdateIntentsResponse][google.cloud.dialogflow.v2beta1.BatchUpdateIntentsResponse]
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public void batchUpdateIntents(
        com.google.cloud.dialogflow.v2beta1.BatchUpdateIntentsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchUpdateIntentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes intents in the specified agent.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public void batchDeleteIntents(
        com.google.cloud.dialogflow.v2beta1.BatchDeleteIntentsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchDeleteIntentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Intents][google.cloud.dialogflow.v2beta1.Intent].
   * </pre>
   */
  public static final class IntentsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<IntentsBlockingStub> {
    private IntentsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IntentsBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IntentsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all intents in the specified agent.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.ListIntentsResponse listIntents(
        com.google.cloud.dialogflow.v2beta1.ListIntentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListIntentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified intent.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.Intent getIntent(
        com.google.cloud.dialogflow.v2beta1.GetIntentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIntentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an intent in the specified agent.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.Intent createIntent(
        com.google.cloud.dialogflow.v2beta1.CreateIntentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateIntentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified intent.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.Intent updateIntent(
        com.google.cloud.dialogflow.v2beta1.UpdateIntentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateIntentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified intent and its direct or indirect followup intents.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public com.google.protobuf.Empty deleteIntent(
        com.google.cloud.dialogflow.v2beta1.DeleteIntentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteIntentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates/Creates multiple intents in the specified agent.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: [BatchUpdateIntentsResponse][google.cloud.dialogflow.v2beta1.BatchUpdateIntentsResponse]
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public com.google.longrunning.Operation batchUpdateIntents(
        com.google.cloud.dialogflow.v2beta1.BatchUpdateIntentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchUpdateIntentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes intents in the specified agent.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public com.google.longrunning.Operation batchDeleteIntents(
        com.google.cloud.dialogflow.v2beta1.BatchDeleteIntentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchDeleteIntentsMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Intents][google.cloud.dialogflow.v2beta1.Intent].
   * </pre>
   */
  public static final class IntentsFutureStub
      extends io.grpc.stub.AbstractFutureStub<IntentsFutureStub> {
    private IntentsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IntentsFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IntentsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all intents in the specified agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.ListIntentsResponse>
        listIntents(com.google.cloud.dialogflow.v2beta1.ListIntentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListIntentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified intent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.Intent>
        getIntent(com.google.cloud.dialogflow.v2beta1.GetIntentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIntentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an intent in the specified agent.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.Intent>
        createIntent(com.google.cloud.dialogflow.v2beta1.CreateIntentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateIntentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified intent.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.Intent>
        updateIntent(com.google.cloud.dialogflow.v2beta1.UpdateIntentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateIntentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified intent and its direct or indirect followup intents.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteIntent(com.google.cloud.dialogflow.v2beta1.DeleteIntentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteIntentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates/Creates multiple intents in the specified agent.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: [BatchUpdateIntentsResponse][google.cloud.dialogflow.v2beta1.BatchUpdateIntentsResponse]
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchUpdateIntents(com.google.cloud.dialogflow.v2beta1.BatchUpdateIntentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchUpdateIntentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes intents in the specified agent.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchDeleteIntents(com.google.cloud.dialogflow.v2beta1.BatchDeleteIntentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchDeleteIntentsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_INTENTS = 0;
  private static final int METHODID_GET_INTENT = 1;
  private static final int METHODID_CREATE_INTENT = 2;
  private static final int METHODID_UPDATE_INTENT = 3;
  private static final int METHODID_DELETE_INTENT = 4;
  private static final int METHODID_BATCH_UPDATE_INTENTS = 5;
  private static final int METHODID_BATCH_DELETE_INTENTS = 6;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final IntentsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(IntentsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_INTENTS:
          serviceImpl.listIntents(
              (com.google.cloud.dialogflow.v2beta1.ListIntentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.ListIntentsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_INTENT:
          serviceImpl.getIntent(
              (com.google.cloud.dialogflow.v2beta1.GetIntentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Intent>)
                  responseObserver);
          break;
        case METHODID_CREATE_INTENT:
          serviceImpl.createIntent(
              (com.google.cloud.dialogflow.v2beta1.CreateIntentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Intent>)
                  responseObserver);
          break;
        case METHODID_UPDATE_INTENT:
          serviceImpl.updateIntent(
              (com.google.cloud.dialogflow.v2beta1.UpdateIntentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Intent>)
                  responseObserver);
          break;
        case METHODID_DELETE_INTENT:
          serviceImpl.deleteIntent(
              (com.google.cloud.dialogflow.v2beta1.DeleteIntentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_BATCH_UPDATE_INTENTS:
          serviceImpl.batchUpdateIntents(
              (com.google.cloud.dialogflow.v2beta1.BatchUpdateIntentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_BATCH_DELETE_INTENTS:
          serviceImpl.batchDeleteIntents(
              (com.google.cloud.dialogflow.v2beta1.BatchDeleteIntentsRequest) request,
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

  private abstract static class IntentsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    IntentsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.v2beta1.IntentProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Intents");
    }
  }

  private static final class IntentsFileDescriptorSupplier extends IntentsBaseDescriptorSupplier {
    IntentsFileDescriptorSupplier() {}
  }

  private static final class IntentsMethodDescriptorSupplier extends IntentsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    IntentsMethodDescriptorSupplier(String methodName) {
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
      synchronized (IntentsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new IntentsFileDescriptorSupplier())
                      .addMethod(getListIntentsMethod())
                      .addMethod(getGetIntentMethod())
                      .addMethod(getCreateIntentMethod())
                      .addMethod(getUpdateIntentMethod())
                      .addMethod(getDeleteIntentMethod())
                      .addMethod(getBatchUpdateIntentsMethod())
                      .addMethod(getBatchDeleteIntentsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
