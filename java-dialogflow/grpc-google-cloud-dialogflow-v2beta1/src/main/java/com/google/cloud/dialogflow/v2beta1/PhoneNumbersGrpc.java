/*
 * Copyright 2025 Google LLC
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
 * Service for managing
 * [PhoneNumbers][google.cloud.dialogflow.v2beta1.PhoneNumber].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/v2beta1/phone_number.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PhoneNumbersGrpc {

  private PhoneNumbersGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.dialogflow.v2beta1.PhoneNumbers";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.ListPhoneNumbersRequest,
          com.google.cloud.dialogflow.v2beta1.ListPhoneNumbersResponse>
      getListPhoneNumbersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPhoneNumbers",
      requestType = com.google.cloud.dialogflow.v2beta1.ListPhoneNumbersRequest.class,
      responseType = com.google.cloud.dialogflow.v2beta1.ListPhoneNumbersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.ListPhoneNumbersRequest,
          com.google.cloud.dialogflow.v2beta1.ListPhoneNumbersResponse>
      getListPhoneNumbersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.ListPhoneNumbersRequest,
            com.google.cloud.dialogflow.v2beta1.ListPhoneNumbersResponse>
        getListPhoneNumbersMethod;
    if ((getListPhoneNumbersMethod = PhoneNumbersGrpc.getListPhoneNumbersMethod) == null) {
      synchronized (PhoneNumbersGrpc.class) {
        if ((getListPhoneNumbersMethod = PhoneNumbersGrpc.getListPhoneNumbersMethod) == null) {
          PhoneNumbersGrpc.getListPhoneNumbersMethod =
              getListPhoneNumbersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.ListPhoneNumbersRequest,
                          com.google.cloud.dialogflow.v2beta1.ListPhoneNumbersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPhoneNumbers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.ListPhoneNumbersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.ListPhoneNumbersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PhoneNumbersMethodDescriptorSupplier("ListPhoneNumbers"))
                      .build();
        }
      }
    }
    return getListPhoneNumbersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.UpdatePhoneNumberRequest,
          com.google.cloud.dialogflow.v2beta1.PhoneNumber>
      getUpdatePhoneNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePhoneNumber",
      requestType = com.google.cloud.dialogflow.v2beta1.UpdatePhoneNumberRequest.class,
      responseType = com.google.cloud.dialogflow.v2beta1.PhoneNumber.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.UpdatePhoneNumberRequest,
          com.google.cloud.dialogflow.v2beta1.PhoneNumber>
      getUpdatePhoneNumberMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.UpdatePhoneNumberRequest,
            com.google.cloud.dialogflow.v2beta1.PhoneNumber>
        getUpdatePhoneNumberMethod;
    if ((getUpdatePhoneNumberMethod = PhoneNumbersGrpc.getUpdatePhoneNumberMethod) == null) {
      synchronized (PhoneNumbersGrpc.class) {
        if ((getUpdatePhoneNumberMethod = PhoneNumbersGrpc.getUpdatePhoneNumberMethod) == null) {
          PhoneNumbersGrpc.getUpdatePhoneNumberMethod =
              getUpdatePhoneNumberMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.UpdatePhoneNumberRequest,
                          com.google.cloud.dialogflow.v2beta1.PhoneNumber>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdatePhoneNumber"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.UpdatePhoneNumberRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.PhoneNumber.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PhoneNumbersMethodDescriptorSupplier("UpdatePhoneNumber"))
                      .build();
        }
      }
    }
    return getUpdatePhoneNumberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.DeletePhoneNumberRequest,
          com.google.cloud.dialogflow.v2beta1.PhoneNumber>
      getDeletePhoneNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePhoneNumber",
      requestType = com.google.cloud.dialogflow.v2beta1.DeletePhoneNumberRequest.class,
      responseType = com.google.cloud.dialogflow.v2beta1.PhoneNumber.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.DeletePhoneNumberRequest,
          com.google.cloud.dialogflow.v2beta1.PhoneNumber>
      getDeletePhoneNumberMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.DeletePhoneNumberRequest,
            com.google.cloud.dialogflow.v2beta1.PhoneNumber>
        getDeletePhoneNumberMethod;
    if ((getDeletePhoneNumberMethod = PhoneNumbersGrpc.getDeletePhoneNumberMethod) == null) {
      synchronized (PhoneNumbersGrpc.class) {
        if ((getDeletePhoneNumberMethod = PhoneNumbersGrpc.getDeletePhoneNumberMethod) == null) {
          PhoneNumbersGrpc.getDeletePhoneNumberMethod =
              getDeletePhoneNumberMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.DeletePhoneNumberRequest,
                          com.google.cloud.dialogflow.v2beta1.PhoneNumber>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeletePhoneNumber"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.DeletePhoneNumberRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.PhoneNumber.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PhoneNumbersMethodDescriptorSupplier("DeletePhoneNumber"))
                      .build();
        }
      }
    }
    return getDeletePhoneNumberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.UndeletePhoneNumberRequest,
          com.google.cloud.dialogflow.v2beta1.PhoneNumber>
      getUndeletePhoneNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UndeletePhoneNumber",
      requestType = com.google.cloud.dialogflow.v2beta1.UndeletePhoneNumberRequest.class,
      responseType = com.google.cloud.dialogflow.v2beta1.PhoneNumber.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.UndeletePhoneNumberRequest,
          com.google.cloud.dialogflow.v2beta1.PhoneNumber>
      getUndeletePhoneNumberMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.UndeletePhoneNumberRequest,
            com.google.cloud.dialogflow.v2beta1.PhoneNumber>
        getUndeletePhoneNumberMethod;
    if ((getUndeletePhoneNumberMethod = PhoneNumbersGrpc.getUndeletePhoneNumberMethod) == null) {
      synchronized (PhoneNumbersGrpc.class) {
        if ((getUndeletePhoneNumberMethod = PhoneNumbersGrpc.getUndeletePhoneNumberMethod)
            == null) {
          PhoneNumbersGrpc.getUndeletePhoneNumberMethod =
              getUndeletePhoneNumberMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.UndeletePhoneNumberRequest,
                          com.google.cloud.dialogflow.v2beta1.PhoneNumber>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UndeletePhoneNumber"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.UndeletePhoneNumberRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.PhoneNumber.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PhoneNumbersMethodDescriptorSupplier("UndeletePhoneNumber"))
                      .build();
        }
      }
    }
    return getUndeletePhoneNumberMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static PhoneNumbersStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PhoneNumbersStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PhoneNumbersStub>() {
          @java.lang.Override
          public PhoneNumbersStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PhoneNumbersStub(channel, callOptions);
          }
        };
    return PhoneNumbersStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static PhoneNumbersBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PhoneNumbersBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PhoneNumbersBlockingV2Stub>() {
          @java.lang.Override
          public PhoneNumbersBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PhoneNumbersBlockingV2Stub(channel, callOptions);
          }
        };
    return PhoneNumbersBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PhoneNumbersBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PhoneNumbersBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PhoneNumbersBlockingStub>() {
          @java.lang.Override
          public PhoneNumbersBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PhoneNumbersBlockingStub(channel, callOptions);
          }
        };
    return PhoneNumbersBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static PhoneNumbersFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PhoneNumbersFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PhoneNumbersFutureStub>() {
          @java.lang.Override
          public PhoneNumbersFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PhoneNumbersFutureStub(channel, callOptions);
          }
        };
    return PhoneNumbersFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing
   * [PhoneNumbers][google.cloud.dialogflow.v2beta1.PhoneNumber].
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Returns the list of all phone numbers in the specified project.
     * </pre>
     */
    default void listPhoneNumbers(
        com.google.cloud.dialogflow.v2beta1.ListPhoneNumbersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.ListPhoneNumbersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPhoneNumbersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified `PhoneNumber`.
     * </pre>
     */
    default void updatePhoneNumber(
        com.google.cloud.dialogflow.v2beta1.UpdatePhoneNumberRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.PhoneNumber>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdatePhoneNumberMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Requests deletion of a `PhoneNumber`. The `PhoneNumber` is moved into the
     * [DELETE_REQUESTED][google.cloud.dialogflow.v2beta1.PhoneNumber.LifecycleState.DELETE_REQUESTED]
     * state immediately, and is deleted approximately 30 days later. This method
     * may only be called on a `PhoneNumber` in the
     * [ACTIVE][google.cloud.dialogflow.v2beta1.PhoneNumber.LifecycleState.ACTIVE]
     * state.
     * </pre>
     */
    default void deletePhoneNumber(
        com.google.cloud.dialogflow.v2beta1.DeletePhoneNumberRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.PhoneNumber>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeletePhoneNumberMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels the deletion request for a `PhoneNumber`. This method may only be
     * called on a `PhoneNumber` in the
     * [DELETE_REQUESTED][google.cloud.dialogflow.v2beta1.PhoneNumber.LifecycleState.DELETE_REQUESTED]
     * state.
     * </pre>
     */
    default void undeletePhoneNumber(
        com.google.cloud.dialogflow.v2beta1.UndeletePhoneNumberRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.PhoneNumber>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUndeletePhoneNumberMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service PhoneNumbers.
   *
   * <pre>
   * Service for managing
   * [PhoneNumbers][google.cloud.dialogflow.v2beta1.PhoneNumber].
   * </pre>
   */
  public abstract static class PhoneNumbersImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return PhoneNumbersGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service PhoneNumbers.
   *
   * <pre>
   * Service for managing
   * [PhoneNumbers][google.cloud.dialogflow.v2beta1.PhoneNumber].
   * </pre>
   */
  public static final class PhoneNumbersStub
      extends io.grpc.stub.AbstractAsyncStub<PhoneNumbersStub> {
    private PhoneNumbersStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PhoneNumbersStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PhoneNumbersStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all phone numbers in the specified project.
     * </pre>
     */
    public void listPhoneNumbers(
        com.google.cloud.dialogflow.v2beta1.ListPhoneNumbersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.ListPhoneNumbersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPhoneNumbersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified `PhoneNumber`.
     * </pre>
     */
    public void updatePhoneNumber(
        com.google.cloud.dialogflow.v2beta1.UpdatePhoneNumberRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.PhoneNumber>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePhoneNumberMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Requests deletion of a `PhoneNumber`. The `PhoneNumber` is moved into the
     * [DELETE_REQUESTED][google.cloud.dialogflow.v2beta1.PhoneNumber.LifecycleState.DELETE_REQUESTED]
     * state immediately, and is deleted approximately 30 days later. This method
     * may only be called on a `PhoneNumber` in the
     * [ACTIVE][google.cloud.dialogflow.v2beta1.PhoneNumber.LifecycleState.ACTIVE]
     * state.
     * </pre>
     */
    public void deletePhoneNumber(
        com.google.cloud.dialogflow.v2beta1.DeletePhoneNumberRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.PhoneNumber>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePhoneNumberMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels the deletion request for a `PhoneNumber`. This method may only be
     * called on a `PhoneNumber` in the
     * [DELETE_REQUESTED][google.cloud.dialogflow.v2beta1.PhoneNumber.LifecycleState.DELETE_REQUESTED]
     * state.
     * </pre>
     */
    public void undeletePhoneNumber(
        com.google.cloud.dialogflow.v2beta1.UndeletePhoneNumberRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.PhoneNumber>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUndeletePhoneNumberMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service PhoneNumbers.
   *
   * <pre>
   * Service for managing
   * [PhoneNumbers][google.cloud.dialogflow.v2beta1.PhoneNumber].
   * </pre>
   */
  public static final class PhoneNumbersBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<PhoneNumbersBlockingV2Stub> {
    private PhoneNumbersBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PhoneNumbersBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PhoneNumbersBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all phone numbers in the specified project.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.ListPhoneNumbersResponse listPhoneNumbers(
        com.google.cloud.dialogflow.v2beta1.ListPhoneNumbersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPhoneNumbersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified `PhoneNumber`.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.PhoneNumber updatePhoneNumber(
        com.google.cloud.dialogflow.v2beta1.UpdatePhoneNumberRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePhoneNumberMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Requests deletion of a `PhoneNumber`. The `PhoneNumber` is moved into the
     * [DELETE_REQUESTED][google.cloud.dialogflow.v2beta1.PhoneNumber.LifecycleState.DELETE_REQUESTED]
     * state immediately, and is deleted approximately 30 days later. This method
     * may only be called on a `PhoneNumber` in the
     * [ACTIVE][google.cloud.dialogflow.v2beta1.PhoneNumber.LifecycleState.ACTIVE]
     * state.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.PhoneNumber deletePhoneNumber(
        com.google.cloud.dialogflow.v2beta1.DeletePhoneNumberRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePhoneNumberMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels the deletion request for a `PhoneNumber`. This method may only be
     * called on a `PhoneNumber` in the
     * [DELETE_REQUESTED][google.cloud.dialogflow.v2beta1.PhoneNumber.LifecycleState.DELETE_REQUESTED]
     * state.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.PhoneNumber undeletePhoneNumber(
        com.google.cloud.dialogflow.v2beta1.UndeletePhoneNumberRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeletePhoneNumberMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service PhoneNumbers.
   *
   * <pre>
   * Service for managing
   * [PhoneNumbers][google.cloud.dialogflow.v2beta1.PhoneNumber].
   * </pre>
   */
  public static final class PhoneNumbersBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PhoneNumbersBlockingStub> {
    private PhoneNumbersBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PhoneNumbersBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PhoneNumbersBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all phone numbers in the specified project.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.ListPhoneNumbersResponse listPhoneNumbers(
        com.google.cloud.dialogflow.v2beta1.ListPhoneNumbersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPhoneNumbersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified `PhoneNumber`.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.PhoneNumber updatePhoneNumber(
        com.google.cloud.dialogflow.v2beta1.UpdatePhoneNumberRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePhoneNumberMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Requests deletion of a `PhoneNumber`. The `PhoneNumber` is moved into the
     * [DELETE_REQUESTED][google.cloud.dialogflow.v2beta1.PhoneNumber.LifecycleState.DELETE_REQUESTED]
     * state immediately, and is deleted approximately 30 days later. This method
     * may only be called on a `PhoneNumber` in the
     * [ACTIVE][google.cloud.dialogflow.v2beta1.PhoneNumber.LifecycleState.ACTIVE]
     * state.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.PhoneNumber deletePhoneNumber(
        com.google.cloud.dialogflow.v2beta1.DeletePhoneNumberRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePhoneNumberMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels the deletion request for a `PhoneNumber`. This method may only be
     * called on a `PhoneNumber` in the
     * [DELETE_REQUESTED][google.cloud.dialogflow.v2beta1.PhoneNumber.LifecycleState.DELETE_REQUESTED]
     * state.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.PhoneNumber undeletePhoneNumber(
        com.google.cloud.dialogflow.v2beta1.UndeletePhoneNumberRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeletePhoneNumberMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service PhoneNumbers.
   *
   * <pre>
   * Service for managing
   * [PhoneNumbers][google.cloud.dialogflow.v2beta1.PhoneNumber].
   * </pre>
   */
  public static final class PhoneNumbersFutureStub
      extends io.grpc.stub.AbstractFutureStub<PhoneNumbersFutureStub> {
    private PhoneNumbersFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PhoneNumbersFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PhoneNumbersFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all phone numbers in the specified project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.ListPhoneNumbersResponse>
        listPhoneNumbers(com.google.cloud.dialogflow.v2beta1.ListPhoneNumbersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPhoneNumbersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified `PhoneNumber`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.PhoneNumber>
        updatePhoneNumber(com.google.cloud.dialogflow.v2beta1.UpdatePhoneNumberRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePhoneNumberMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Requests deletion of a `PhoneNumber`. The `PhoneNumber` is moved into the
     * [DELETE_REQUESTED][google.cloud.dialogflow.v2beta1.PhoneNumber.LifecycleState.DELETE_REQUESTED]
     * state immediately, and is deleted approximately 30 days later. This method
     * may only be called on a `PhoneNumber` in the
     * [ACTIVE][google.cloud.dialogflow.v2beta1.PhoneNumber.LifecycleState.ACTIVE]
     * state.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.PhoneNumber>
        deletePhoneNumber(com.google.cloud.dialogflow.v2beta1.DeletePhoneNumberRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePhoneNumberMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels the deletion request for a `PhoneNumber`. This method may only be
     * called on a `PhoneNumber` in the
     * [DELETE_REQUESTED][google.cloud.dialogflow.v2beta1.PhoneNumber.LifecycleState.DELETE_REQUESTED]
     * state.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.PhoneNumber>
        undeletePhoneNumber(
            com.google.cloud.dialogflow.v2beta1.UndeletePhoneNumberRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUndeletePhoneNumberMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_PHONE_NUMBERS = 0;
  private static final int METHODID_UPDATE_PHONE_NUMBER = 1;
  private static final int METHODID_DELETE_PHONE_NUMBER = 2;
  private static final int METHODID_UNDELETE_PHONE_NUMBER = 3;

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
        case METHODID_LIST_PHONE_NUMBERS:
          serviceImpl.listPhoneNumbers(
              (com.google.cloud.dialogflow.v2beta1.ListPhoneNumbersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.v2beta1.ListPhoneNumbersResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_PHONE_NUMBER:
          serviceImpl.updatePhoneNumber(
              (com.google.cloud.dialogflow.v2beta1.UpdatePhoneNumberRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.PhoneNumber>)
                  responseObserver);
          break;
        case METHODID_DELETE_PHONE_NUMBER:
          serviceImpl.deletePhoneNumber(
              (com.google.cloud.dialogflow.v2beta1.DeletePhoneNumberRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.PhoneNumber>)
                  responseObserver);
          break;
        case METHODID_UNDELETE_PHONE_NUMBER:
          serviceImpl.undeletePhoneNumber(
              (com.google.cloud.dialogflow.v2beta1.UndeletePhoneNumberRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.PhoneNumber>)
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
            getListPhoneNumbersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2beta1.ListPhoneNumbersRequest,
                    com.google.cloud.dialogflow.v2beta1.ListPhoneNumbersResponse>(
                    service, METHODID_LIST_PHONE_NUMBERS)))
        .addMethod(
            getUpdatePhoneNumberMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2beta1.UpdatePhoneNumberRequest,
                    com.google.cloud.dialogflow.v2beta1.PhoneNumber>(
                    service, METHODID_UPDATE_PHONE_NUMBER)))
        .addMethod(
            getDeletePhoneNumberMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2beta1.DeletePhoneNumberRequest,
                    com.google.cloud.dialogflow.v2beta1.PhoneNumber>(
                    service, METHODID_DELETE_PHONE_NUMBER)))
        .addMethod(
            getUndeletePhoneNumberMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2beta1.UndeletePhoneNumberRequest,
                    com.google.cloud.dialogflow.v2beta1.PhoneNumber>(
                    service, METHODID_UNDELETE_PHONE_NUMBER)))
        .build();
  }

  private abstract static class PhoneNumbersBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PhoneNumbersBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.v2beta1.PhoneNumberProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PhoneNumbers");
    }
  }

  private static final class PhoneNumbersFileDescriptorSupplier
      extends PhoneNumbersBaseDescriptorSupplier {
    PhoneNumbersFileDescriptorSupplier() {}
  }

  private static final class PhoneNumbersMethodDescriptorSupplier
      extends PhoneNumbersBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    PhoneNumbersMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (PhoneNumbersGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new PhoneNumbersFileDescriptorSupplier())
                      .addMethod(getListPhoneNumbersMethod())
                      .addMethod(getUpdatePhoneNumberMethod())
                      .addMethod(getDeletePhoneNumberMethod())
                      .addMethod(getUndeletePhoneNumberMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
