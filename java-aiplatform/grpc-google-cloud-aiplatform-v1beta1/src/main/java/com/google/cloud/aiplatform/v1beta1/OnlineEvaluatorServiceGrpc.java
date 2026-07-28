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
package com.google.cloud.aiplatform.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * This service is used to create and manage Vertex AI OnlineEvaluators.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class OnlineEvaluatorServiceGrpc {

  private OnlineEvaluatorServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.aiplatform.v1beta1.OnlineEvaluatorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateOnlineEvaluatorRequest,
          com.google.longrunning.Operation>
      getCreateOnlineEvaluatorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateOnlineEvaluator",
      requestType = com.google.cloud.aiplatform.v1beta1.CreateOnlineEvaluatorRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateOnlineEvaluatorRequest,
          com.google.longrunning.Operation>
      getCreateOnlineEvaluatorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.CreateOnlineEvaluatorRequest,
            com.google.longrunning.Operation>
        getCreateOnlineEvaluatorMethod;
    if ((getCreateOnlineEvaluatorMethod = OnlineEvaluatorServiceGrpc.getCreateOnlineEvaluatorMethod)
        == null) {
      synchronized (OnlineEvaluatorServiceGrpc.class) {
        if ((getCreateOnlineEvaluatorMethod =
                OnlineEvaluatorServiceGrpc.getCreateOnlineEvaluatorMethod)
            == null) {
          OnlineEvaluatorServiceGrpc.getCreateOnlineEvaluatorMethod =
              getCreateOnlineEvaluatorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.CreateOnlineEvaluatorRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateOnlineEvaluator"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.CreateOnlineEvaluatorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OnlineEvaluatorServiceMethodDescriptorSupplier(
                              "CreateOnlineEvaluator"))
                      .build();
        }
      }
    }
    return getCreateOnlineEvaluatorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetOnlineEvaluatorRequest,
          com.google.cloud.aiplatform.v1beta1.OnlineEvaluator>
      getGetOnlineEvaluatorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOnlineEvaluator",
      requestType = com.google.cloud.aiplatform.v1beta1.GetOnlineEvaluatorRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.OnlineEvaluator.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetOnlineEvaluatorRequest,
          com.google.cloud.aiplatform.v1beta1.OnlineEvaluator>
      getGetOnlineEvaluatorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetOnlineEvaluatorRequest,
            com.google.cloud.aiplatform.v1beta1.OnlineEvaluator>
        getGetOnlineEvaluatorMethod;
    if ((getGetOnlineEvaluatorMethod = OnlineEvaluatorServiceGrpc.getGetOnlineEvaluatorMethod)
        == null) {
      synchronized (OnlineEvaluatorServiceGrpc.class) {
        if ((getGetOnlineEvaluatorMethod = OnlineEvaluatorServiceGrpc.getGetOnlineEvaluatorMethod)
            == null) {
          OnlineEvaluatorServiceGrpc.getGetOnlineEvaluatorMethod =
              getGetOnlineEvaluatorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GetOnlineEvaluatorRequest,
                          com.google.cloud.aiplatform.v1beta1.OnlineEvaluator>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetOnlineEvaluator"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.GetOnlineEvaluatorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.OnlineEvaluator
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OnlineEvaluatorServiceMethodDescriptorSupplier("GetOnlineEvaluator"))
                      .build();
        }
      }
    }
    return getGetOnlineEvaluatorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateOnlineEvaluatorRequest,
          com.google.longrunning.Operation>
      getUpdateOnlineEvaluatorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateOnlineEvaluator",
      requestType = com.google.cloud.aiplatform.v1beta1.UpdateOnlineEvaluatorRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateOnlineEvaluatorRequest,
          com.google.longrunning.Operation>
      getUpdateOnlineEvaluatorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.UpdateOnlineEvaluatorRequest,
            com.google.longrunning.Operation>
        getUpdateOnlineEvaluatorMethod;
    if ((getUpdateOnlineEvaluatorMethod = OnlineEvaluatorServiceGrpc.getUpdateOnlineEvaluatorMethod)
        == null) {
      synchronized (OnlineEvaluatorServiceGrpc.class) {
        if ((getUpdateOnlineEvaluatorMethod =
                OnlineEvaluatorServiceGrpc.getUpdateOnlineEvaluatorMethod)
            == null) {
          OnlineEvaluatorServiceGrpc.getUpdateOnlineEvaluatorMethod =
              getUpdateOnlineEvaluatorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.UpdateOnlineEvaluatorRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateOnlineEvaluator"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.UpdateOnlineEvaluatorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OnlineEvaluatorServiceMethodDescriptorSupplier(
                              "UpdateOnlineEvaluator"))
                      .build();
        }
      }
    }
    return getUpdateOnlineEvaluatorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteOnlineEvaluatorRequest,
          com.google.longrunning.Operation>
      getDeleteOnlineEvaluatorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteOnlineEvaluator",
      requestType = com.google.cloud.aiplatform.v1beta1.DeleteOnlineEvaluatorRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteOnlineEvaluatorRequest,
          com.google.longrunning.Operation>
      getDeleteOnlineEvaluatorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeleteOnlineEvaluatorRequest,
            com.google.longrunning.Operation>
        getDeleteOnlineEvaluatorMethod;
    if ((getDeleteOnlineEvaluatorMethod = OnlineEvaluatorServiceGrpc.getDeleteOnlineEvaluatorMethod)
        == null) {
      synchronized (OnlineEvaluatorServiceGrpc.class) {
        if ((getDeleteOnlineEvaluatorMethod =
                OnlineEvaluatorServiceGrpc.getDeleteOnlineEvaluatorMethod)
            == null) {
          OnlineEvaluatorServiceGrpc.getDeleteOnlineEvaluatorMethod =
              getDeleteOnlineEvaluatorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.DeleteOnlineEvaluatorRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteOnlineEvaluator"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.DeleteOnlineEvaluatorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OnlineEvaluatorServiceMethodDescriptorSupplier(
                              "DeleteOnlineEvaluator"))
                      .build();
        }
      }
    }
    return getDeleteOnlineEvaluatorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListOnlineEvaluatorsRequest,
          com.google.cloud.aiplatform.v1beta1.ListOnlineEvaluatorsResponse>
      getListOnlineEvaluatorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListOnlineEvaluators",
      requestType = com.google.cloud.aiplatform.v1beta1.ListOnlineEvaluatorsRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListOnlineEvaluatorsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListOnlineEvaluatorsRequest,
          com.google.cloud.aiplatform.v1beta1.ListOnlineEvaluatorsResponse>
      getListOnlineEvaluatorsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListOnlineEvaluatorsRequest,
            com.google.cloud.aiplatform.v1beta1.ListOnlineEvaluatorsResponse>
        getListOnlineEvaluatorsMethod;
    if ((getListOnlineEvaluatorsMethod = OnlineEvaluatorServiceGrpc.getListOnlineEvaluatorsMethod)
        == null) {
      synchronized (OnlineEvaluatorServiceGrpc.class) {
        if ((getListOnlineEvaluatorsMethod =
                OnlineEvaluatorServiceGrpc.getListOnlineEvaluatorsMethod)
            == null) {
          OnlineEvaluatorServiceGrpc.getListOnlineEvaluatorsMethod =
              getListOnlineEvaluatorsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ListOnlineEvaluatorsRequest,
                          com.google.cloud.aiplatform.v1beta1.ListOnlineEvaluatorsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListOnlineEvaluators"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListOnlineEvaluatorsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListOnlineEvaluatorsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OnlineEvaluatorServiceMethodDescriptorSupplier(
                              "ListOnlineEvaluators"))
                      .build();
        }
      }
    }
    return getListOnlineEvaluatorsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ActivateOnlineEvaluatorRequest,
          com.google.longrunning.Operation>
      getActivateOnlineEvaluatorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ActivateOnlineEvaluator",
      requestType = com.google.cloud.aiplatform.v1beta1.ActivateOnlineEvaluatorRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ActivateOnlineEvaluatorRequest,
          com.google.longrunning.Operation>
      getActivateOnlineEvaluatorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ActivateOnlineEvaluatorRequest,
            com.google.longrunning.Operation>
        getActivateOnlineEvaluatorMethod;
    if ((getActivateOnlineEvaluatorMethod =
            OnlineEvaluatorServiceGrpc.getActivateOnlineEvaluatorMethod)
        == null) {
      synchronized (OnlineEvaluatorServiceGrpc.class) {
        if ((getActivateOnlineEvaluatorMethod =
                OnlineEvaluatorServiceGrpc.getActivateOnlineEvaluatorMethod)
            == null) {
          OnlineEvaluatorServiceGrpc.getActivateOnlineEvaluatorMethod =
              getActivateOnlineEvaluatorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ActivateOnlineEvaluatorRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ActivateOnlineEvaluator"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ActivateOnlineEvaluatorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OnlineEvaluatorServiceMethodDescriptorSupplier(
                              "ActivateOnlineEvaluator"))
                      .build();
        }
      }
    }
    return getActivateOnlineEvaluatorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.SuspendOnlineEvaluatorRequest,
          com.google.longrunning.Operation>
      getSuspendOnlineEvaluatorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SuspendOnlineEvaluator",
      requestType = com.google.cloud.aiplatform.v1beta1.SuspendOnlineEvaluatorRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.SuspendOnlineEvaluatorRequest,
          com.google.longrunning.Operation>
      getSuspendOnlineEvaluatorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.SuspendOnlineEvaluatorRequest,
            com.google.longrunning.Operation>
        getSuspendOnlineEvaluatorMethod;
    if ((getSuspendOnlineEvaluatorMethod =
            OnlineEvaluatorServiceGrpc.getSuspendOnlineEvaluatorMethod)
        == null) {
      synchronized (OnlineEvaluatorServiceGrpc.class) {
        if ((getSuspendOnlineEvaluatorMethod =
                OnlineEvaluatorServiceGrpc.getSuspendOnlineEvaluatorMethod)
            == null) {
          OnlineEvaluatorServiceGrpc.getSuspendOnlineEvaluatorMethod =
              getSuspendOnlineEvaluatorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.SuspendOnlineEvaluatorRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SuspendOnlineEvaluator"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.SuspendOnlineEvaluatorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OnlineEvaluatorServiceMethodDescriptorSupplier(
                              "SuspendOnlineEvaluator"))
                      .build();
        }
      }
    }
    return getSuspendOnlineEvaluatorMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static OnlineEvaluatorServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OnlineEvaluatorServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OnlineEvaluatorServiceStub>() {
          @java.lang.Override
          public OnlineEvaluatorServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OnlineEvaluatorServiceStub(channel, callOptions);
          }
        };
    return OnlineEvaluatorServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static OnlineEvaluatorServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OnlineEvaluatorServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OnlineEvaluatorServiceBlockingV2Stub>() {
          @java.lang.Override
          public OnlineEvaluatorServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OnlineEvaluatorServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return OnlineEvaluatorServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OnlineEvaluatorServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OnlineEvaluatorServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OnlineEvaluatorServiceBlockingStub>() {
          @java.lang.Override
          public OnlineEvaluatorServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OnlineEvaluatorServiceBlockingStub(channel, callOptions);
          }
        };
    return OnlineEvaluatorServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static OnlineEvaluatorServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OnlineEvaluatorServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OnlineEvaluatorServiceFutureStub>() {
          @java.lang.Override
          public OnlineEvaluatorServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OnlineEvaluatorServiceFutureStub(channel, callOptions);
          }
        };
    return OnlineEvaluatorServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * This service is used to create and manage Vertex AI OnlineEvaluators.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates an OnlineEvaluator in the given project and location.
     * </pre>
     */
    default void createOnlineEvaluator(
        com.google.cloud.aiplatform.v1beta1.CreateOnlineEvaluatorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateOnlineEvaluatorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of an OnlineEvaluator.
     * </pre>
     */
    default void getOnlineEvaluator(
        com.google.cloud.aiplatform.v1beta1.GetOnlineEvaluatorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.OnlineEvaluator>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetOnlineEvaluatorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the fields of an OnlineEvaluator.
     * </pre>
     */
    default void updateOnlineEvaluator(
        com.google.cloud.aiplatform.v1beta1.UpdateOnlineEvaluatorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateOnlineEvaluatorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an OnlineEvaluator.
     * </pre>
     */
    default void deleteOnlineEvaluator(
        com.google.cloud.aiplatform.v1beta1.DeleteOnlineEvaluatorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteOnlineEvaluatorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the OnlineEvaluators for the given project and location.
     * </pre>
     */
    default void listOnlineEvaluators(
        com.google.cloud.aiplatform.v1beta1.ListOnlineEvaluatorsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.ListOnlineEvaluatorsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListOnlineEvaluatorsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Activates an OnlineEvaluator.
     * </pre>
     */
    default void activateOnlineEvaluator(
        com.google.cloud.aiplatform.v1beta1.ActivateOnlineEvaluatorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getActivateOnlineEvaluatorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Suspends an OnlineEvaluator. When an OnlineEvaluator is suspended, it won't
     * run any evaluations until it is activated again.
     * </pre>
     */
    default void suspendOnlineEvaluator(
        com.google.cloud.aiplatform.v1beta1.SuspendOnlineEvaluatorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSuspendOnlineEvaluatorMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service OnlineEvaluatorService.
   *
   * <pre>
   * This service is used to create and manage Vertex AI OnlineEvaluators.
   * </pre>
   */
  public abstract static class OnlineEvaluatorServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return OnlineEvaluatorServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service OnlineEvaluatorService.
   *
   * <pre>
   * This service is used to create and manage Vertex AI OnlineEvaluators.
   * </pre>
   */
  public static final class OnlineEvaluatorServiceStub
      extends io.grpc.stub.AbstractAsyncStub<OnlineEvaluatorServiceStub> {
    private OnlineEvaluatorServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OnlineEvaluatorServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OnlineEvaluatorServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an OnlineEvaluator in the given project and location.
     * </pre>
     */
    public void createOnlineEvaluator(
        com.google.cloud.aiplatform.v1beta1.CreateOnlineEvaluatorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateOnlineEvaluatorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of an OnlineEvaluator.
     * </pre>
     */
    public void getOnlineEvaluator(
        com.google.cloud.aiplatform.v1beta1.GetOnlineEvaluatorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.OnlineEvaluator>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOnlineEvaluatorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the fields of an OnlineEvaluator.
     * </pre>
     */
    public void updateOnlineEvaluator(
        com.google.cloud.aiplatform.v1beta1.UpdateOnlineEvaluatorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateOnlineEvaluatorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an OnlineEvaluator.
     * </pre>
     */
    public void deleteOnlineEvaluator(
        com.google.cloud.aiplatform.v1beta1.DeleteOnlineEvaluatorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteOnlineEvaluatorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the OnlineEvaluators for the given project and location.
     * </pre>
     */
    public void listOnlineEvaluators(
        com.google.cloud.aiplatform.v1beta1.ListOnlineEvaluatorsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.ListOnlineEvaluatorsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListOnlineEvaluatorsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Activates an OnlineEvaluator.
     * </pre>
     */
    public void activateOnlineEvaluator(
        com.google.cloud.aiplatform.v1beta1.ActivateOnlineEvaluatorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getActivateOnlineEvaluatorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Suspends an OnlineEvaluator. When an OnlineEvaluator is suspended, it won't
     * run any evaluations until it is activated again.
     * </pre>
     */
    public void suspendOnlineEvaluator(
        com.google.cloud.aiplatform.v1beta1.SuspendOnlineEvaluatorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSuspendOnlineEvaluatorMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service OnlineEvaluatorService.
   *
   * <pre>
   * This service is used to create and manage Vertex AI OnlineEvaluators.
   * </pre>
   */
  public static final class OnlineEvaluatorServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<OnlineEvaluatorServiceBlockingV2Stub> {
    private OnlineEvaluatorServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OnlineEvaluatorServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OnlineEvaluatorServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an OnlineEvaluator in the given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createOnlineEvaluator(
        com.google.cloud.aiplatform.v1beta1.CreateOnlineEvaluatorRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateOnlineEvaluatorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of an OnlineEvaluator.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.OnlineEvaluator getOnlineEvaluator(
        com.google.cloud.aiplatform.v1beta1.GetOnlineEvaluatorRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetOnlineEvaluatorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the fields of an OnlineEvaluator.
     * </pre>
     */
    public com.google.longrunning.Operation updateOnlineEvaluator(
        com.google.cloud.aiplatform.v1beta1.UpdateOnlineEvaluatorRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateOnlineEvaluatorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an OnlineEvaluator.
     * </pre>
     */
    public com.google.longrunning.Operation deleteOnlineEvaluator(
        com.google.cloud.aiplatform.v1beta1.DeleteOnlineEvaluatorRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteOnlineEvaluatorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the OnlineEvaluators for the given project and location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListOnlineEvaluatorsResponse listOnlineEvaluators(
        com.google.cloud.aiplatform.v1beta1.ListOnlineEvaluatorsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListOnlineEvaluatorsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Activates an OnlineEvaluator.
     * </pre>
     */
    public com.google.longrunning.Operation activateOnlineEvaluator(
        com.google.cloud.aiplatform.v1beta1.ActivateOnlineEvaluatorRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getActivateOnlineEvaluatorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Suspends an OnlineEvaluator. When an OnlineEvaluator is suspended, it won't
     * run any evaluations until it is activated again.
     * </pre>
     */
    public com.google.longrunning.Operation suspendOnlineEvaluator(
        com.google.cloud.aiplatform.v1beta1.SuspendOnlineEvaluatorRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSuspendOnlineEvaluatorMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service OnlineEvaluatorService.
   *
   * <pre>
   * This service is used to create and manage Vertex AI OnlineEvaluators.
   * </pre>
   */
  public static final class OnlineEvaluatorServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<OnlineEvaluatorServiceBlockingStub> {
    private OnlineEvaluatorServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OnlineEvaluatorServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OnlineEvaluatorServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an OnlineEvaluator in the given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createOnlineEvaluator(
        com.google.cloud.aiplatform.v1beta1.CreateOnlineEvaluatorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateOnlineEvaluatorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of an OnlineEvaluator.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.OnlineEvaluator getOnlineEvaluator(
        com.google.cloud.aiplatform.v1beta1.GetOnlineEvaluatorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOnlineEvaluatorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the fields of an OnlineEvaluator.
     * </pre>
     */
    public com.google.longrunning.Operation updateOnlineEvaluator(
        com.google.cloud.aiplatform.v1beta1.UpdateOnlineEvaluatorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateOnlineEvaluatorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an OnlineEvaluator.
     * </pre>
     */
    public com.google.longrunning.Operation deleteOnlineEvaluator(
        com.google.cloud.aiplatform.v1beta1.DeleteOnlineEvaluatorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteOnlineEvaluatorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the OnlineEvaluators for the given project and location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListOnlineEvaluatorsResponse listOnlineEvaluators(
        com.google.cloud.aiplatform.v1beta1.ListOnlineEvaluatorsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListOnlineEvaluatorsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Activates an OnlineEvaluator.
     * </pre>
     */
    public com.google.longrunning.Operation activateOnlineEvaluator(
        com.google.cloud.aiplatform.v1beta1.ActivateOnlineEvaluatorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getActivateOnlineEvaluatorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Suspends an OnlineEvaluator. When an OnlineEvaluator is suspended, it won't
     * run any evaluations until it is activated again.
     * </pre>
     */
    public com.google.longrunning.Operation suspendOnlineEvaluator(
        com.google.cloud.aiplatform.v1beta1.SuspendOnlineEvaluatorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSuspendOnlineEvaluatorMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * OnlineEvaluatorService.
   *
   * <pre>
   * This service is used to create and manage Vertex AI OnlineEvaluators.
   * </pre>
   */
  public static final class OnlineEvaluatorServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<OnlineEvaluatorServiceFutureStub> {
    private OnlineEvaluatorServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OnlineEvaluatorServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OnlineEvaluatorServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an OnlineEvaluator in the given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createOnlineEvaluator(
            com.google.cloud.aiplatform.v1beta1.CreateOnlineEvaluatorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateOnlineEvaluatorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of an OnlineEvaluator.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.OnlineEvaluator>
        getOnlineEvaluator(com.google.cloud.aiplatform.v1beta1.GetOnlineEvaluatorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOnlineEvaluatorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the fields of an OnlineEvaluator.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateOnlineEvaluator(
            com.google.cloud.aiplatform.v1beta1.UpdateOnlineEvaluatorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateOnlineEvaluatorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an OnlineEvaluator.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteOnlineEvaluator(
            com.google.cloud.aiplatform.v1beta1.DeleteOnlineEvaluatorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteOnlineEvaluatorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the OnlineEvaluators for the given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ListOnlineEvaluatorsResponse>
        listOnlineEvaluators(
            com.google.cloud.aiplatform.v1beta1.ListOnlineEvaluatorsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListOnlineEvaluatorsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Activates an OnlineEvaluator.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        activateOnlineEvaluator(
            com.google.cloud.aiplatform.v1beta1.ActivateOnlineEvaluatorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getActivateOnlineEvaluatorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Suspends an OnlineEvaluator. When an OnlineEvaluator is suspended, it won't
     * run any evaluations until it is activated again.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        suspendOnlineEvaluator(
            com.google.cloud.aiplatform.v1beta1.SuspendOnlineEvaluatorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSuspendOnlineEvaluatorMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ONLINE_EVALUATOR = 0;
  private static final int METHODID_GET_ONLINE_EVALUATOR = 1;
  private static final int METHODID_UPDATE_ONLINE_EVALUATOR = 2;
  private static final int METHODID_DELETE_ONLINE_EVALUATOR = 3;
  private static final int METHODID_LIST_ONLINE_EVALUATORS = 4;
  private static final int METHODID_ACTIVATE_ONLINE_EVALUATOR = 5;
  private static final int METHODID_SUSPEND_ONLINE_EVALUATOR = 6;

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
        case METHODID_CREATE_ONLINE_EVALUATOR:
          serviceImpl.createOnlineEvaluator(
              (com.google.cloud.aiplatform.v1beta1.CreateOnlineEvaluatorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_ONLINE_EVALUATOR:
          serviceImpl.getOnlineEvaluator(
              (com.google.cloud.aiplatform.v1beta1.GetOnlineEvaluatorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.OnlineEvaluator>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ONLINE_EVALUATOR:
          serviceImpl.updateOnlineEvaluator(
              (com.google.cloud.aiplatform.v1beta1.UpdateOnlineEvaluatorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ONLINE_EVALUATOR:
          serviceImpl.deleteOnlineEvaluator(
              (com.google.cloud.aiplatform.v1beta1.DeleteOnlineEvaluatorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_ONLINE_EVALUATORS:
          serviceImpl.listOnlineEvaluators(
              (com.google.cloud.aiplatform.v1beta1.ListOnlineEvaluatorsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ListOnlineEvaluatorsResponse>)
                  responseObserver);
          break;
        case METHODID_ACTIVATE_ONLINE_EVALUATOR:
          serviceImpl.activateOnlineEvaluator(
              (com.google.cloud.aiplatform.v1beta1.ActivateOnlineEvaluatorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_SUSPEND_ONLINE_EVALUATOR:
          serviceImpl.suspendOnlineEvaluator(
              (com.google.cloud.aiplatform.v1beta1.SuspendOnlineEvaluatorRequest) request,
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
            getCreateOnlineEvaluatorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.CreateOnlineEvaluatorRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_ONLINE_EVALUATOR)))
        .addMethod(
            getGetOnlineEvaluatorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.GetOnlineEvaluatorRequest,
                    com.google.cloud.aiplatform.v1beta1.OnlineEvaluator>(
                    service, METHODID_GET_ONLINE_EVALUATOR)))
        .addMethod(
            getUpdateOnlineEvaluatorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.UpdateOnlineEvaluatorRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_ONLINE_EVALUATOR)))
        .addMethod(
            getDeleteOnlineEvaluatorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.DeleteOnlineEvaluatorRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_ONLINE_EVALUATOR)))
        .addMethod(
            getListOnlineEvaluatorsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.ListOnlineEvaluatorsRequest,
                    com.google.cloud.aiplatform.v1beta1.ListOnlineEvaluatorsResponse>(
                    service, METHODID_LIST_ONLINE_EVALUATORS)))
        .addMethod(
            getActivateOnlineEvaluatorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.ActivateOnlineEvaluatorRequest,
                    com.google.longrunning.Operation>(service, METHODID_ACTIVATE_ONLINE_EVALUATOR)))
        .addMethod(
            getSuspendOnlineEvaluatorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.SuspendOnlineEvaluatorRequest,
                    com.google.longrunning.Operation>(service, METHODID_SUSPEND_ONLINE_EVALUATOR)))
        .build();
  }

  private abstract static class OnlineEvaluatorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OnlineEvaluatorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1beta1.OnlineEvaluatorServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OnlineEvaluatorService");
    }
  }

  private static final class OnlineEvaluatorServiceFileDescriptorSupplier
      extends OnlineEvaluatorServiceBaseDescriptorSupplier {
    OnlineEvaluatorServiceFileDescriptorSupplier() {}
  }

  private static final class OnlineEvaluatorServiceMethodDescriptorSupplier
      extends OnlineEvaluatorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    OnlineEvaluatorServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (OnlineEvaluatorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new OnlineEvaluatorServiceFileDescriptorSupplier())
                      .addMethod(getCreateOnlineEvaluatorMethod())
                      .addMethod(getGetOnlineEvaluatorMethod())
                      .addMethod(getUpdateOnlineEvaluatorMethod())
                      .addMethod(getDeleteOnlineEvaluatorMethod())
                      .addMethod(getListOnlineEvaluatorsMethod())
                      .addMethod(getActivateOnlineEvaluatorMethod())
                      .addMethod(getSuspendOnlineEvaluatorMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
