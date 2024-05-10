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
package com.google.cloud.kms.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Provides interfaces for using Cloud KMS Autokey to provision new
 * [CryptoKeys][google.cloud.kms.v1.CryptoKey], ready for Customer Managed
 * Encryption Key (CMEK) use, on-demand. To support certain client tooling, this
 * feature is modeled around a [KeyHandle][google.cloud.kms.v1.KeyHandle]
 * resource: creating a [KeyHandle][google.cloud.kms.v1.KeyHandle] in a resource
 * project and given location triggers Cloud KMS Autokey to provision a
 * [CryptoKey][google.cloud.kms.v1.CryptoKey] in the configured key project and
 * the same location.
 * Prior to use in a given resource project,
 * [UpdateAutokeyConfig][google.cloud.kms.v1.AutokeyAdmin.UpdateAutokeyConfig]
 * should have been called on an ancestor folder, setting the key project where
 * Cloud KMS Autokey should create new
 * [CryptoKeys][google.cloud.kms.v1.CryptoKey]. See documentation for additional
 * prerequisites. To check what key project, if any, is currently configured on
 * a resource project's ancestor folder, see
 * [ShowEffectiveAutokeyConfig][google.cloud.kms.v1.AutokeyAdmin.ShowEffectiveAutokeyConfig].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/kms/v1/autokey.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AutokeyGrpc {

  private AutokeyGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.kms.v1.Autokey";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.CreateKeyHandleRequest, com.google.longrunning.Operation>
      getCreateKeyHandleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateKeyHandle",
      requestType = com.google.cloud.kms.v1.CreateKeyHandleRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.CreateKeyHandleRequest, com.google.longrunning.Operation>
      getCreateKeyHandleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.CreateKeyHandleRequest, com.google.longrunning.Operation>
        getCreateKeyHandleMethod;
    if ((getCreateKeyHandleMethod = AutokeyGrpc.getCreateKeyHandleMethod) == null) {
      synchronized (AutokeyGrpc.class) {
        if ((getCreateKeyHandleMethod = AutokeyGrpc.getCreateKeyHandleMethod) == null) {
          AutokeyGrpc.getCreateKeyHandleMethod =
              getCreateKeyHandleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.CreateKeyHandleRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateKeyHandle"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.CreateKeyHandleRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AutokeyMethodDescriptorSupplier("CreateKeyHandle"))
                      .build();
        }
      }
    }
    return getCreateKeyHandleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.GetKeyHandleRequest, com.google.cloud.kms.v1.KeyHandle>
      getGetKeyHandleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetKeyHandle",
      requestType = com.google.cloud.kms.v1.GetKeyHandleRequest.class,
      responseType = com.google.cloud.kms.v1.KeyHandle.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.GetKeyHandleRequest, com.google.cloud.kms.v1.KeyHandle>
      getGetKeyHandleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.GetKeyHandleRequest, com.google.cloud.kms.v1.KeyHandle>
        getGetKeyHandleMethod;
    if ((getGetKeyHandleMethod = AutokeyGrpc.getGetKeyHandleMethod) == null) {
      synchronized (AutokeyGrpc.class) {
        if ((getGetKeyHandleMethod = AutokeyGrpc.getGetKeyHandleMethod) == null) {
          AutokeyGrpc.getGetKeyHandleMethod =
              getGetKeyHandleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.GetKeyHandleRequest,
                          com.google.cloud.kms.v1.KeyHandle>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetKeyHandle"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.GetKeyHandleRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.KeyHandle.getDefaultInstance()))
                      .setSchemaDescriptor(new AutokeyMethodDescriptorSupplier("GetKeyHandle"))
                      .build();
        }
      }
    }
    return getGetKeyHandleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.ListKeyHandlesRequest,
          com.google.cloud.kms.v1.ListKeyHandlesResponse>
      getListKeyHandlesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListKeyHandles",
      requestType = com.google.cloud.kms.v1.ListKeyHandlesRequest.class,
      responseType = com.google.cloud.kms.v1.ListKeyHandlesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.ListKeyHandlesRequest,
          com.google.cloud.kms.v1.ListKeyHandlesResponse>
      getListKeyHandlesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.ListKeyHandlesRequest,
            com.google.cloud.kms.v1.ListKeyHandlesResponse>
        getListKeyHandlesMethod;
    if ((getListKeyHandlesMethod = AutokeyGrpc.getListKeyHandlesMethod) == null) {
      synchronized (AutokeyGrpc.class) {
        if ((getListKeyHandlesMethod = AutokeyGrpc.getListKeyHandlesMethod) == null) {
          AutokeyGrpc.getListKeyHandlesMethod =
              getListKeyHandlesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.ListKeyHandlesRequest,
                          com.google.cloud.kms.v1.ListKeyHandlesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListKeyHandles"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.ListKeyHandlesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.ListKeyHandlesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new AutokeyMethodDescriptorSupplier("ListKeyHandles"))
                      .build();
        }
      }
    }
    return getListKeyHandlesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AutokeyStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AutokeyStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AutokeyStub>() {
          @java.lang.Override
          public AutokeyStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AutokeyStub(channel, callOptions);
          }
        };
    return AutokeyStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AutokeyBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AutokeyBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AutokeyBlockingStub>() {
          @java.lang.Override
          public AutokeyBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AutokeyBlockingStub(channel, callOptions);
          }
        };
    return AutokeyBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AutokeyFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AutokeyFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AutokeyFutureStub>() {
          @java.lang.Override
          public AutokeyFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AutokeyFutureStub(channel, callOptions);
          }
        };
    return AutokeyFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Provides interfaces for using Cloud KMS Autokey to provision new
   * [CryptoKeys][google.cloud.kms.v1.CryptoKey], ready for Customer Managed
   * Encryption Key (CMEK) use, on-demand. To support certain client tooling, this
   * feature is modeled around a [KeyHandle][google.cloud.kms.v1.KeyHandle]
   * resource: creating a [KeyHandle][google.cloud.kms.v1.KeyHandle] in a resource
   * project and given location triggers Cloud KMS Autokey to provision a
   * [CryptoKey][google.cloud.kms.v1.CryptoKey] in the configured key project and
   * the same location.
   * Prior to use in a given resource project,
   * [UpdateAutokeyConfig][google.cloud.kms.v1.AutokeyAdmin.UpdateAutokeyConfig]
   * should have been called on an ancestor folder, setting the key project where
   * Cloud KMS Autokey should create new
   * [CryptoKeys][google.cloud.kms.v1.CryptoKey]. See documentation for additional
   * prerequisites. To check what key project, if any, is currently configured on
   * a resource project's ancestor folder, see
   * [ShowEffectiveAutokeyConfig][google.cloud.kms.v1.AutokeyAdmin.ShowEffectiveAutokeyConfig].
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a new [KeyHandle][google.cloud.kms.v1.KeyHandle], triggering the
     * provisioning of a new [CryptoKey][google.cloud.kms.v1.CryptoKey] for CMEK
     * use with the given resource type in the configured key project and the same
     * location. [GetOperation][Operations.GetOperation] should be used to resolve
     * the resulting long-running operation and get the resulting
     * [KeyHandle][google.cloud.kms.v1.KeyHandle] and
     * [CryptoKey][google.cloud.kms.v1.CryptoKey].
     * </pre>
     */
    default void createKeyHandle(
        com.google.cloud.kms.v1.CreateKeyHandleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateKeyHandleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the [KeyHandle][google.cloud.kms.v1.KeyHandle].
     * </pre>
     */
    default void getKeyHandle(
        com.google.cloud.kms.v1.GetKeyHandleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.KeyHandle> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetKeyHandleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists [KeyHandles][google.cloud.kms.v1.KeyHandle].
     * </pre>
     */
    default void listKeyHandles(
        com.google.cloud.kms.v1.ListKeyHandlesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ListKeyHandlesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListKeyHandlesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Autokey.
   *
   * <pre>
   * Provides interfaces for using Cloud KMS Autokey to provision new
   * [CryptoKeys][google.cloud.kms.v1.CryptoKey], ready for Customer Managed
   * Encryption Key (CMEK) use, on-demand. To support certain client tooling, this
   * feature is modeled around a [KeyHandle][google.cloud.kms.v1.KeyHandle]
   * resource: creating a [KeyHandle][google.cloud.kms.v1.KeyHandle] in a resource
   * project and given location triggers Cloud KMS Autokey to provision a
   * [CryptoKey][google.cloud.kms.v1.CryptoKey] in the configured key project and
   * the same location.
   * Prior to use in a given resource project,
   * [UpdateAutokeyConfig][google.cloud.kms.v1.AutokeyAdmin.UpdateAutokeyConfig]
   * should have been called on an ancestor folder, setting the key project where
   * Cloud KMS Autokey should create new
   * [CryptoKeys][google.cloud.kms.v1.CryptoKey]. See documentation for additional
   * prerequisites. To check what key project, if any, is currently configured on
   * a resource project's ancestor folder, see
   * [ShowEffectiveAutokeyConfig][google.cloud.kms.v1.AutokeyAdmin.ShowEffectiveAutokeyConfig].
   * </pre>
   */
  public abstract static class AutokeyImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AutokeyGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Autokey.
   *
   * <pre>
   * Provides interfaces for using Cloud KMS Autokey to provision new
   * [CryptoKeys][google.cloud.kms.v1.CryptoKey], ready for Customer Managed
   * Encryption Key (CMEK) use, on-demand. To support certain client tooling, this
   * feature is modeled around a [KeyHandle][google.cloud.kms.v1.KeyHandle]
   * resource: creating a [KeyHandle][google.cloud.kms.v1.KeyHandle] in a resource
   * project and given location triggers Cloud KMS Autokey to provision a
   * [CryptoKey][google.cloud.kms.v1.CryptoKey] in the configured key project and
   * the same location.
   * Prior to use in a given resource project,
   * [UpdateAutokeyConfig][google.cloud.kms.v1.AutokeyAdmin.UpdateAutokeyConfig]
   * should have been called on an ancestor folder, setting the key project where
   * Cloud KMS Autokey should create new
   * [CryptoKeys][google.cloud.kms.v1.CryptoKey]. See documentation for additional
   * prerequisites. To check what key project, if any, is currently configured on
   * a resource project's ancestor folder, see
   * [ShowEffectiveAutokeyConfig][google.cloud.kms.v1.AutokeyAdmin.ShowEffectiveAutokeyConfig].
   * </pre>
   */
  public static final class AutokeyStub extends io.grpc.stub.AbstractAsyncStub<AutokeyStub> {
    private AutokeyStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutokeyStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutokeyStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new [KeyHandle][google.cloud.kms.v1.KeyHandle], triggering the
     * provisioning of a new [CryptoKey][google.cloud.kms.v1.CryptoKey] for CMEK
     * use with the given resource type in the configured key project and the same
     * location. [GetOperation][Operations.GetOperation] should be used to resolve
     * the resulting long-running operation and get the resulting
     * [KeyHandle][google.cloud.kms.v1.KeyHandle] and
     * [CryptoKey][google.cloud.kms.v1.CryptoKey].
     * </pre>
     */
    public void createKeyHandle(
        com.google.cloud.kms.v1.CreateKeyHandleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateKeyHandleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the [KeyHandle][google.cloud.kms.v1.KeyHandle].
     * </pre>
     */
    public void getKeyHandle(
        com.google.cloud.kms.v1.GetKeyHandleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.KeyHandle> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetKeyHandleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists [KeyHandles][google.cloud.kms.v1.KeyHandle].
     * </pre>
     */
    public void listKeyHandles(
        com.google.cloud.kms.v1.ListKeyHandlesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ListKeyHandlesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListKeyHandlesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Autokey.
   *
   * <pre>
   * Provides interfaces for using Cloud KMS Autokey to provision new
   * [CryptoKeys][google.cloud.kms.v1.CryptoKey], ready for Customer Managed
   * Encryption Key (CMEK) use, on-demand. To support certain client tooling, this
   * feature is modeled around a [KeyHandle][google.cloud.kms.v1.KeyHandle]
   * resource: creating a [KeyHandle][google.cloud.kms.v1.KeyHandle] in a resource
   * project and given location triggers Cloud KMS Autokey to provision a
   * [CryptoKey][google.cloud.kms.v1.CryptoKey] in the configured key project and
   * the same location.
   * Prior to use in a given resource project,
   * [UpdateAutokeyConfig][google.cloud.kms.v1.AutokeyAdmin.UpdateAutokeyConfig]
   * should have been called on an ancestor folder, setting the key project where
   * Cloud KMS Autokey should create new
   * [CryptoKeys][google.cloud.kms.v1.CryptoKey]. See documentation for additional
   * prerequisites. To check what key project, if any, is currently configured on
   * a resource project's ancestor folder, see
   * [ShowEffectiveAutokeyConfig][google.cloud.kms.v1.AutokeyAdmin.ShowEffectiveAutokeyConfig].
   * </pre>
   */
  public static final class AutokeyBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AutokeyBlockingStub> {
    private AutokeyBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutokeyBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutokeyBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new [KeyHandle][google.cloud.kms.v1.KeyHandle], triggering the
     * provisioning of a new [CryptoKey][google.cloud.kms.v1.CryptoKey] for CMEK
     * use with the given resource type in the configured key project and the same
     * location. [GetOperation][Operations.GetOperation] should be used to resolve
     * the resulting long-running operation and get the resulting
     * [KeyHandle][google.cloud.kms.v1.KeyHandle] and
     * [CryptoKey][google.cloud.kms.v1.CryptoKey].
     * </pre>
     */
    public com.google.longrunning.Operation createKeyHandle(
        com.google.cloud.kms.v1.CreateKeyHandleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateKeyHandleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the [KeyHandle][google.cloud.kms.v1.KeyHandle].
     * </pre>
     */
    public com.google.cloud.kms.v1.KeyHandle getKeyHandle(
        com.google.cloud.kms.v1.GetKeyHandleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetKeyHandleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists [KeyHandles][google.cloud.kms.v1.KeyHandle].
     * </pre>
     */
    public com.google.cloud.kms.v1.ListKeyHandlesResponse listKeyHandles(
        com.google.cloud.kms.v1.ListKeyHandlesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListKeyHandlesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Autokey.
   *
   * <pre>
   * Provides interfaces for using Cloud KMS Autokey to provision new
   * [CryptoKeys][google.cloud.kms.v1.CryptoKey], ready for Customer Managed
   * Encryption Key (CMEK) use, on-demand. To support certain client tooling, this
   * feature is modeled around a [KeyHandle][google.cloud.kms.v1.KeyHandle]
   * resource: creating a [KeyHandle][google.cloud.kms.v1.KeyHandle] in a resource
   * project and given location triggers Cloud KMS Autokey to provision a
   * [CryptoKey][google.cloud.kms.v1.CryptoKey] in the configured key project and
   * the same location.
   * Prior to use in a given resource project,
   * [UpdateAutokeyConfig][google.cloud.kms.v1.AutokeyAdmin.UpdateAutokeyConfig]
   * should have been called on an ancestor folder, setting the key project where
   * Cloud KMS Autokey should create new
   * [CryptoKeys][google.cloud.kms.v1.CryptoKey]. See documentation for additional
   * prerequisites. To check what key project, if any, is currently configured on
   * a resource project's ancestor folder, see
   * [ShowEffectiveAutokeyConfig][google.cloud.kms.v1.AutokeyAdmin.ShowEffectiveAutokeyConfig].
   * </pre>
   */
  public static final class AutokeyFutureStub
      extends io.grpc.stub.AbstractFutureStub<AutokeyFutureStub> {
    private AutokeyFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutokeyFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutokeyFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new [KeyHandle][google.cloud.kms.v1.KeyHandle], triggering the
     * provisioning of a new [CryptoKey][google.cloud.kms.v1.CryptoKey] for CMEK
     * use with the given resource type in the configured key project and the same
     * location. [GetOperation][Operations.GetOperation] should be used to resolve
     * the resulting long-running operation and get the resulting
     * [KeyHandle][google.cloud.kms.v1.KeyHandle] and
     * [CryptoKey][google.cloud.kms.v1.CryptoKey].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createKeyHandle(com.google.cloud.kms.v1.CreateKeyHandleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateKeyHandleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the [KeyHandle][google.cloud.kms.v1.KeyHandle].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.KeyHandle>
        getKeyHandle(com.google.cloud.kms.v1.GetKeyHandleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetKeyHandleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists [KeyHandles][google.cloud.kms.v1.KeyHandle].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.kms.v1.ListKeyHandlesResponse>
        listKeyHandles(com.google.cloud.kms.v1.ListKeyHandlesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListKeyHandlesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_KEY_HANDLE = 0;
  private static final int METHODID_GET_KEY_HANDLE = 1;
  private static final int METHODID_LIST_KEY_HANDLES = 2;

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
        case METHODID_CREATE_KEY_HANDLE:
          serviceImpl.createKeyHandle(
              (com.google.cloud.kms.v1.CreateKeyHandleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_KEY_HANDLE:
          serviceImpl.getKeyHandle(
              (com.google.cloud.kms.v1.GetKeyHandleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.KeyHandle>) responseObserver);
          break;
        case METHODID_LIST_KEY_HANDLES:
          serviceImpl.listKeyHandles(
              (com.google.cloud.kms.v1.ListKeyHandlesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ListKeyHandlesResponse>)
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
            getCreateKeyHandleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.kms.v1.CreateKeyHandleRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_KEY_HANDLE)))
        .addMethod(
            getGetKeyHandleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.kms.v1.GetKeyHandleRequest, com.google.cloud.kms.v1.KeyHandle>(
                    service, METHODID_GET_KEY_HANDLE)))
        .addMethod(
            getListKeyHandlesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.kms.v1.ListKeyHandlesRequest,
                    com.google.cloud.kms.v1.ListKeyHandlesResponse>(
                    service, METHODID_LIST_KEY_HANDLES)))
        .build();
  }

  private abstract static class AutokeyBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AutokeyBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.kms.v1.AutokeyProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Autokey");
    }
  }

  private static final class AutokeyFileDescriptorSupplier extends AutokeyBaseDescriptorSupplier {
    AutokeyFileDescriptorSupplier() {}
  }

  private static final class AutokeyMethodDescriptorSupplier extends AutokeyBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AutokeyMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AutokeyGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AutokeyFileDescriptorSupplier())
                      .addMethod(getCreateKeyHandleMethod())
                      .addMethod(getGetKeyHandleMethod())
                      .addMethod(getListKeyHandlesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
