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
 * Service for managing [SipTrunks][google.cloud.dialogflow.v2beta1.SipTrunk].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/v2beta1/sip_trunk.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SipTrunksGrpc {

  private SipTrunksGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.dialogflow.v2beta1.SipTrunks";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.CreateSipTrunkRequest,
          com.google.cloud.dialogflow.v2beta1.SipTrunk>
      getCreateSipTrunkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSipTrunk",
      requestType = com.google.cloud.dialogflow.v2beta1.CreateSipTrunkRequest.class,
      responseType = com.google.cloud.dialogflow.v2beta1.SipTrunk.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.CreateSipTrunkRequest,
          com.google.cloud.dialogflow.v2beta1.SipTrunk>
      getCreateSipTrunkMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.CreateSipTrunkRequest,
            com.google.cloud.dialogflow.v2beta1.SipTrunk>
        getCreateSipTrunkMethod;
    if ((getCreateSipTrunkMethod = SipTrunksGrpc.getCreateSipTrunkMethod) == null) {
      synchronized (SipTrunksGrpc.class) {
        if ((getCreateSipTrunkMethod = SipTrunksGrpc.getCreateSipTrunkMethod) == null) {
          SipTrunksGrpc.getCreateSipTrunkMethod =
              getCreateSipTrunkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.CreateSipTrunkRequest,
                          com.google.cloud.dialogflow.v2beta1.SipTrunk>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSipTrunk"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.CreateSipTrunkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.SipTrunk.getDefaultInstance()))
                      .setSchemaDescriptor(new SipTrunksMethodDescriptorSupplier("CreateSipTrunk"))
                      .build();
        }
      }
    }
    return getCreateSipTrunkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.DeleteSipTrunkRequest, com.google.protobuf.Empty>
      getDeleteSipTrunkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSipTrunk",
      requestType = com.google.cloud.dialogflow.v2beta1.DeleteSipTrunkRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.DeleteSipTrunkRequest, com.google.protobuf.Empty>
      getDeleteSipTrunkMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.DeleteSipTrunkRequest, com.google.protobuf.Empty>
        getDeleteSipTrunkMethod;
    if ((getDeleteSipTrunkMethod = SipTrunksGrpc.getDeleteSipTrunkMethod) == null) {
      synchronized (SipTrunksGrpc.class) {
        if ((getDeleteSipTrunkMethod = SipTrunksGrpc.getDeleteSipTrunkMethod) == null) {
          SipTrunksGrpc.getDeleteSipTrunkMethod =
              getDeleteSipTrunkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.DeleteSipTrunkRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSipTrunk"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.DeleteSipTrunkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new SipTrunksMethodDescriptorSupplier("DeleteSipTrunk"))
                      .build();
        }
      }
    }
    return getDeleteSipTrunkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.ListSipTrunksRequest,
          com.google.cloud.dialogflow.v2beta1.ListSipTrunksResponse>
      getListSipTrunksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSipTrunks",
      requestType = com.google.cloud.dialogflow.v2beta1.ListSipTrunksRequest.class,
      responseType = com.google.cloud.dialogflow.v2beta1.ListSipTrunksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.ListSipTrunksRequest,
          com.google.cloud.dialogflow.v2beta1.ListSipTrunksResponse>
      getListSipTrunksMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.ListSipTrunksRequest,
            com.google.cloud.dialogflow.v2beta1.ListSipTrunksResponse>
        getListSipTrunksMethod;
    if ((getListSipTrunksMethod = SipTrunksGrpc.getListSipTrunksMethod) == null) {
      synchronized (SipTrunksGrpc.class) {
        if ((getListSipTrunksMethod = SipTrunksGrpc.getListSipTrunksMethod) == null) {
          SipTrunksGrpc.getListSipTrunksMethod =
              getListSipTrunksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.ListSipTrunksRequest,
                          com.google.cloud.dialogflow.v2beta1.ListSipTrunksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSipTrunks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.ListSipTrunksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.ListSipTrunksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new SipTrunksMethodDescriptorSupplier("ListSipTrunks"))
                      .build();
        }
      }
    }
    return getListSipTrunksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.GetSipTrunkRequest,
          com.google.cloud.dialogflow.v2beta1.SipTrunk>
      getGetSipTrunkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSipTrunk",
      requestType = com.google.cloud.dialogflow.v2beta1.GetSipTrunkRequest.class,
      responseType = com.google.cloud.dialogflow.v2beta1.SipTrunk.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.GetSipTrunkRequest,
          com.google.cloud.dialogflow.v2beta1.SipTrunk>
      getGetSipTrunkMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.GetSipTrunkRequest,
            com.google.cloud.dialogflow.v2beta1.SipTrunk>
        getGetSipTrunkMethod;
    if ((getGetSipTrunkMethod = SipTrunksGrpc.getGetSipTrunkMethod) == null) {
      synchronized (SipTrunksGrpc.class) {
        if ((getGetSipTrunkMethod = SipTrunksGrpc.getGetSipTrunkMethod) == null) {
          SipTrunksGrpc.getGetSipTrunkMethod =
              getGetSipTrunkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.GetSipTrunkRequest,
                          com.google.cloud.dialogflow.v2beta1.SipTrunk>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSipTrunk"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.GetSipTrunkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.SipTrunk.getDefaultInstance()))
                      .setSchemaDescriptor(new SipTrunksMethodDescriptorSupplier("GetSipTrunk"))
                      .build();
        }
      }
    }
    return getGetSipTrunkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.UpdateSipTrunkRequest,
          com.google.cloud.dialogflow.v2beta1.SipTrunk>
      getUpdateSipTrunkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSipTrunk",
      requestType = com.google.cloud.dialogflow.v2beta1.UpdateSipTrunkRequest.class,
      responseType = com.google.cloud.dialogflow.v2beta1.SipTrunk.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.UpdateSipTrunkRequest,
          com.google.cloud.dialogflow.v2beta1.SipTrunk>
      getUpdateSipTrunkMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.UpdateSipTrunkRequest,
            com.google.cloud.dialogflow.v2beta1.SipTrunk>
        getUpdateSipTrunkMethod;
    if ((getUpdateSipTrunkMethod = SipTrunksGrpc.getUpdateSipTrunkMethod) == null) {
      synchronized (SipTrunksGrpc.class) {
        if ((getUpdateSipTrunkMethod = SipTrunksGrpc.getUpdateSipTrunkMethod) == null) {
          SipTrunksGrpc.getUpdateSipTrunkMethod =
              getUpdateSipTrunkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.UpdateSipTrunkRequest,
                          com.google.cloud.dialogflow.v2beta1.SipTrunk>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSipTrunk"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.UpdateSipTrunkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.SipTrunk.getDefaultInstance()))
                      .setSchemaDescriptor(new SipTrunksMethodDescriptorSupplier("UpdateSipTrunk"))
                      .build();
        }
      }
    }
    return getUpdateSipTrunkMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SipTrunksStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SipTrunksStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SipTrunksStub>() {
          @java.lang.Override
          public SipTrunksStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SipTrunksStub(channel, callOptions);
          }
        };
    return SipTrunksStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SipTrunksBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SipTrunksBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SipTrunksBlockingStub>() {
          @java.lang.Override
          public SipTrunksBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SipTrunksBlockingStub(channel, callOptions);
          }
        };
    return SipTrunksBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SipTrunksFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SipTrunksFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SipTrunksFutureStub>() {
          @java.lang.Override
          public SipTrunksFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SipTrunksFutureStub(channel, callOptions);
          }
        };
    return SipTrunksFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing [SipTrunks][google.cloud.dialogflow.v2beta1.SipTrunk].
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a SipTrunk for a specified location.
     * </pre>
     */
    default void createSipTrunk(
        com.google.cloud.dialogflow.v2beta1.CreateSipTrunkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.SipTrunk>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSipTrunkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specified SipTrunk.
     * </pre>
     */
    default void deleteSipTrunk(
        com.google.cloud.dialogflow.v2beta1.DeleteSipTrunkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSipTrunkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of SipTrunks in the specified location.
     * </pre>
     */
    default void listSipTrunks(
        com.google.cloud.dialogflow.v2beta1.ListSipTrunksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.ListSipTrunksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSipTrunksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified SipTrunk.
     * </pre>
     */
    default void getSipTrunk(
        com.google.cloud.dialogflow.v2beta1.GetSipTrunkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.SipTrunk>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSipTrunkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified SipTrunk.
     * </pre>
     */
    default void updateSipTrunk(
        com.google.cloud.dialogflow.v2beta1.UpdateSipTrunkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.SipTrunk>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSipTrunkMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SipTrunks.
   *
   * <pre>
   * Service for managing [SipTrunks][google.cloud.dialogflow.v2beta1.SipTrunk].
   * </pre>
   */
  public abstract static class SipTrunksImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SipTrunksGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SipTrunks.
   *
   * <pre>
   * Service for managing [SipTrunks][google.cloud.dialogflow.v2beta1.SipTrunk].
   * </pre>
   */
  public static final class SipTrunksStub extends io.grpc.stub.AbstractAsyncStub<SipTrunksStub> {
    private SipTrunksStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SipTrunksStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SipTrunksStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a SipTrunk for a specified location.
     * </pre>
     */
    public void createSipTrunk(
        com.google.cloud.dialogflow.v2beta1.CreateSipTrunkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.SipTrunk>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSipTrunkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specified SipTrunk.
     * </pre>
     */
    public void deleteSipTrunk(
        com.google.cloud.dialogflow.v2beta1.DeleteSipTrunkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSipTrunkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of SipTrunks in the specified location.
     * </pre>
     */
    public void listSipTrunks(
        com.google.cloud.dialogflow.v2beta1.ListSipTrunksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.ListSipTrunksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSipTrunksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified SipTrunk.
     * </pre>
     */
    public void getSipTrunk(
        com.google.cloud.dialogflow.v2beta1.GetSipTrunkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.SipTrunk>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSipTrunkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified SipTrunk.
     * </pre>
     */
    public void updateSipTrunk(
        com.google.cloud.dialogflow.v2beta1.UpdateSipTrunkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.SipTrunk>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSipTrunkMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SipTrunks.
   *
   * <pre>
   * Service for managing [SipTrunks][google.cloud.dialogflow.v2beta1.SipTrunk].
   * </pre>
   */
  public static final class SipTrunksBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SipTrunksBlockingStub> {
    private SipTrunksBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SipTrunksBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SipTrunksBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a SipTrunk for a specified location.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.SipTrunk createSipTrunk(
        com.google.cloud.dialogflow.v2beta1.CreateSipTrunkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSipTrunkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specified SipTrunk.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSipTrunk(
        com.google.cloud.dialogflow.v2beta1.DeleteSipTrunkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSipTrunkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of SipTrunks in the specified location.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.ListSipTrunksResponse listSipTrunks(
        com.google.cloud.dialogflow.v2beta1.ListSipTrunksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSipTrunksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified SipTrunk.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.SipTrunk getSipTrunk(
        com.google.cloud.dialogflow.v2beta1.GetSipTrunkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSipTrunkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified SipTrunk.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.SipTrunk updateSipTrunk(
        com.google.cloud.dialogflow.v2beta1.UpdateSipTrunkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSipTrunkMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SipTrunks.
   *
   * <pre>
   * Service for managing [SipTrunks][google.cloud.dialogflow.v2beta1.SipTrunk].
   * </pre>
   */
  public static final class SipTrunksFutureStub
      extends io.grpc.stub.AbstractFutureStub<SipTrunksFutureStub> {
    private SipTrunksFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SipTrunksFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SipTrunksFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a SipTrunk for a specified location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.SipTrunk>
        createSipTrunk(com.google.cloud.dialogflow.v2beta1.CreateSipTrunkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSipTrunkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specified SipTrunk.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteSipTrunk(com.google.cloud.dialogflow.v2beta1.DeleteSipTrunkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSipTrunkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of SipTrunks in the specified location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.ListSipTrunksResponse>
        listSipTrunks(com.google.cloud.dialogflow.v2beta1.ListSipTrunksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSipTrunksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified SipTrunk.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.SipTrunk>
        getSipTrunk(com.google.cloud.dialogflow.v2beta1.GetSipTrunkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSipTrunkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified SipTrunk.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.SipTrunk>
        updateSipTrunk(com.google.cloud.dialogflow.v2beta1.UpdateSipTrunkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSipTrunkMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SIP_TRUNK = 0;
  private static final int METHODID_DELETE_SIP_TRUNK = 1;
  private static final int METHODID_LIST_SIP_TRUNKS = 2;
  private static final int METHODID_GET_SIP_TRUNK = 3;
  private static final int METHODID_UPDATE_SIP_TRUNK = 4;

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
        case METHODID_CREATE_SIP_TRUNK:
          serviceImpl.createSipTrunk(
              (com.google.cloud.dialogflow.v2beta1.CreateSipTrunkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.SipTrunk>)
                  responseObserver);
          break;
        case METHODID_DELETE_SIP_TRUNK:
          serviceImpl.deleteSipTrunk(
              (com.google.cloud.dialogflow.v2beta1.DeleteSipTrunkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_SIP_TRUNKS:
          serviceImpl.listSipTrunks(
              (com.google.cloud.dialogflow.v2beta1.ListSipTrunksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.v2beta1.ListSipTrunksResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SIP_TRUNK:
          serviceImpl.getSipTrunk(
              (com.google.cloud.dialogflow.v2beta1.GetSipTrunkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.SipTrunk>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SIP_TRUNK:
          serviceImpl.updateSipTrunk(
              (com.google.cloud.dialogflow.v2beta1.UpdateSipTrunkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.SipTrunk>)
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
            getCreateSipTrunkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2beta1.CreateSipTrunkRequest,
                    com.google.cloud.dialogflow.v2beta1.SipTrunk>(
                    service, METHODID_CREATE_SIP_TRUNK)))
        .addMethod(
            getDeleteSipTrunkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2beta1.DeleteSipTrunkRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_SIP_TRUNK)))
        .addMethod(
            getListSipTrunksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2beta1.ListSipTrunksRequest,
                    com.google.cloud.dialogflow.v2beta1.ListSipTrunksResponse>(
                    service, METHODID_LIST_SIP_TRUNKS)))
        .addMethod(
            getGetSipTrunkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2beta1.GetSipTrunkRequest,
                    com.google.cloud.dialogflow.v2beta1.SipTrunk>(service, METHODID_GET_SIP_TRUNK)))
        .addMethod(
            getUpdateSipTrunkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2beta1.UpdateSipTrunkRequest,
                    com.google.cloud.dialogflow.v2beta1.SipTrunk>(
                    service, METHODID_UPDATE_SIP_TRUNK)))
        .build();
  }

  private abstract static class SipTrunksBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SipTrunksBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.v2beta1.SipTrunkProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SipTrunks");
    }
  }

  private static final class SipTrunksFileDescriptorSupplier
      extends SipTrunksBaseDescriptorSupplier {
    SipTrunksFileDescriptorSupplier() {}
  }

  private static final class SipTrunksMethodDescriptorSupplier
      extends SipTrunksBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SipTrunksMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SipTrunksGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SipTrunksFileDescriptorSupplier())
                      .addMethod(getCreateSipTrunkMethod())
                      .addMethod(getDeleteSipTrunkMethod())
                      .addMethod(getListSipTrunksMethod())
                      .addMethod(getGetSipTrunkMethod())
                      .addMethod(getUpdateSipTrunkMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
