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
package com.google.cloud.networkconnectivity.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The CLH based service for managing RemoteTransportProfiles and Transports.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class TransportManagerGrpc {

  private TransportManagerGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.networkconnectivity.v1beta.TransportManager";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.ListRemoteTransportProfilesRequest,
          com.google.cloud.networkconnectivity.v1beta.ListRemoteTransportProfilesResponse>
      getListRemoteTransportProfilesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRemoteTransportProfiles",
      requestType =
          com.google.cloud.networkconnectivity.v1beta.ListRemoteTransportProfilesRequest.class,
      responseType =
          com.google.cloud.networkconnectivity.v1beta.ListRemoteTransportProfilesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.ListRemoteTransportProfilesRequest,
          com.google.cloud.networkconnectivity.v1beta.ListRemoteTransportProfilesResponse>
      getListRemoteTransportProfilesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.ListRemoteTransportProfilesRequest,
            com.google.cloud.networkconnectivity.v1beta.ListRemoteTransportProfilesResponse>
        getListRemoteTransportProfilesMethod;
    if ((getListRemoteTransportProfilesMethod =
            TransportManagerGrpc.getListRemoteTransportProfilesMethod)
        == null) {
      synchronized (TransportManagerGrpc.class) {
        if ((getListRemoteTransportProfilesMethod =
                TransportManagerGrpc.getListRemoteTransportProfilesMethod)
            == null) {
          TransportManagerGrpc.getListRemoteTransportProfilesMethod =
              getListRemoteTransportProfilesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta
                              .ListRemoteTransportProfilesRequest,
                          com.google.cloud.networkconnectivity.v1beta
                              .ListRemoteTransportProfilesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListRemoteTransportProfiles"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta
                                  .ListRemoteTransportProfilesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta
                                  .ListRemoteTransportProfilesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TransportManagerMethodDescriptorSupplier(
                              "ListRemoteTransportProfiles"))
                      .build();
        }
      }
    }
    return getListRemoteTransportProfilesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.GetRemoteTransportProfileRequest,
          com.google.cloud.networkconnectivity.v1beta.RemoteTransportProfile>
      getGetRemoteTransportProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRemoteTransportProfile",
      requestType =
          com.google.cloud.networkconnectivity.v1beta.GetRemoteTransportProfileRequest.class,
      responseType = com.google.cloud.networkconnectivity.v1beta.RemoteTransportProfile.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.GetRemoteTransportProfileRequest,
          com.google.cloud.networkconnectivity.v1beta.RemoteTransportProfile>
      getGetRemoteTransportProfileMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.GetRemoteTransportProfileRequest,
            com.google.cloud.networkconnectivity.v1beta.RemoteTransportProfile>
        getGetRemoteTransportProfileMethod;
    if ((getGetRemoteTransportProfileMethod =
            TransportManagerGrpc.getGetRemoteTransportProfileMethod)
        == null) {
      synchronized (TransportManagerGrpc.class) {
        if ((getGetRemoteTransportProfileMethod =
                TransportManagerGrpc.getGetRemoteTransportProfileMethod)
            == null) {
          TransportManagerGrpc.getGetRemoteTransportProfileMethod =
              getGetRemoteTransportProfileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta
                              .GetRemoteTransportProfileRequest,
                          com.google.cloud.networkconnectivity.v1beta.RemoteTransportProfile>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetRemoteTransportProfile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta
                                  .GetRemoteTransportProfileRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.RemoteTransportProfile
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TransportManagerMethodDescriptorSupplier("GetRemoteTransportProfile"))
                      .build();
        }
      }
    }
    return getGetRemoteTransportProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.ListTransportsRequest,
          com.google.cloud.networkconnectivity.v1beta.ListTransportsResponse>
      getListTransportsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTransports",
      requestType = com.google.cloud.networkconnectivity.v1beta.ListTransportsRequest.class,
      responseType = com.google.cloud.networkconnectivity.v1beta.ListTransportsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.ListTransportsRequest,
          com.google.cloud.networkconnectivity.v1beta.ListTransportsResponse>
      getListTransportsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.ListTransportsRequest,
            com.google.cloud.networkconnectivity.v1beta.ListTransportsResponse>
        getListTransportsMethod;
    if ((getListTransportsMethod = TransportManagerGrpc.getListTransportsMethod) == null) {
      synchronized (TransportManagerGrpc.class) {
        if ((getListTransportsMethod = TransportManagerGrpc.getListTransportsMethod) == null) {
          TransportManagerGrpc.getListTransportsMethod =
              getListTransportsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta.ListTransportsRequest,
                          com.google.cloud.networkconnectivity.v1beta.ListTransportsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTransports"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.ListTransportsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.ListTransportsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TransportManagerMethodDescriptorSupplier("ListTransports"))
                      .build();
        }
      }
    }
    return getListTransportsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.GetTransportRequest,
          com.google.cloud.networkconnectivity.v1beta.Transport>
      getGetTransportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTransport",
      requestType = com.google.cloud.networkconnectivity.v1beta.GetTransportRequest.class,
      responseType = com.google.cloud.networkconnectivity.v1beta.Transport.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.GetTransportRequest,
          com.google.cloud.networkconnectivity.v1beta.Transport>
      getGetTransportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.GetTransportRequest,
            com.google.cloud.networkconnectivity.v1beta.Transport>
        getGetTransportMethod;
    if ((getGetTransportMethod = TransportManagerGrpc.getGetTransportMethod) == null) {
      synchronized (TransportManagerGrpc.class) {
        if ((getGetTransportMethod = TransportManagerGrpc.getGetTransportMethod) == null) {
          TransportManagerGrpc.getGetTransportMethod =
              getGetTransportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta.GetTransportRequest,
                          com.google.cloud.networkconnectivity.v1beta.Transport>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTransport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.GetTransportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.Transport
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TransportManagerMethodDescriptorSupplier("GetTransport"))
                      .build();
        }
      }
    }
    return getGetTransportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.GetStatusRequest,
          com.google.cloud.networkconnectivity.v1beta.GetStatusResponse>
      getGetStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStatus",
      requestType = com.google.cloud.networkconnectivity.v1beta.GetStatusRequest.class,
      responseType = com.google.cloud.networkconnectivity.v1beta.GetStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.GetStatusRequest,
          com.google.cloud.networkconnectivity.v1beta.GetStatusResponse>
      getGetStatusMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.GetStatusRequest,
            com.google.cloud.networkconnectivity.v1beta.GetStatusResponse>
        getGetStatusMethod;
    if ((getGetStatusMethod = TransportManagerGrpc.getGetStatusMethod) == null) {
      synchronized (TransportManagerGrpc.class) {
        if ((getGetStatusMethod = TransportManagerGrpc.getGetStatusMethod) == null) {
          TransportManagerGrpc.getGetStatusMethod =
              getGetStatusMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta.GetStatusRequest,
                          com.google.cloud.networkconnectivity.v1beta.GetStatusResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetStatus"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.GetStatusRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.GetStatusResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TransportManagerMethodDescriptorSupplier("GetStatus"))
                      .build();
        }
      }
    }
    return getGetStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.CreateTransportRequest,
          com.google.longrunning.Operation>
      getCreateTransportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTransport",
      requestType = com.google.cloud.networkconnectivity.v1beta.CreateTransportRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.CreateTransportRequest,
          com.google.longrunning.Operation>
      getCreateTransportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.CreateTransportRequest,
            com.google.longrunning.Operation>
        getCreateTransportMethod;
    if ((getCreateTransportMethod = TransportManagerGrpc.getCreateTransportMethod) == null) {
      synchronized (TransportManagerGrpc.class) {
        if ((getCreateTransportMethod = TransportManagerGrpc.getCreateTransportMethod) == null) {
          TransportManagerGrpc.getCreateTransportMethod =
              getCreateTransportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta.CreateTransportRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTransport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.CreateTransportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TransportManagerMethodDescriptorSupplier("CreateTransport"))
                      .build();
        }
      }
    }
    return getCreateTransportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.UpdateTransportRequest,
          com.google.longrunning.Operation>
      getUpdateTransportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTransport",
      requestType = com.google.cloud.networkconnectivity.v1beta.UpdateTransportRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.UpdateTransportRequest,
          com.google.longrunning.Operation>
      getUpdateTransportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.UpdateTransportRequest,
            com.google.longrunning.Operation>
        getUpdateTransportMethod;
    if ((getUpdateTransportMethod = TransportManagerGrpc.getUpdateTransportMethod) == null) {
      synchronized (TransportManagerGrpc.class) {
        if ((getUpdateTransportMethod = TransportManagerGrpc.getUpdateTransportMethod) == null) {
          TransportManagerGrpc.getUpdateTransportMethod =
              getUpdateTransportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta.UpdateTransportRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTransport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.UpdateTransportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TransportManagerMethodDescriptorSupplier("UpdateTransport"))
                      .build();
        }
      }
    }
    return getUpdateTransportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.DeleteTransportRequest,
          com.google.longrunning.Operation>
      getDeleteTransportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTransport",
      requestType = com.google.cloud.networkconnectivity.v1beta.DeleteTransportRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.DeleteTransportRequest,
          com.google.longrunning.Operation>
      getDeleteTransportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.DeleteTransportRequest,
            com.google.longrunning.Operation>
        getDeleteTransportMethod;
    if ((getDeleteTransportMethod = TransportManagerGrpc.getDeleteTransportMethod) == null) {
      synchronized (TransportManagerGrpc.class) {
        if ((getDeleteTransportMethod = TransportManagerGrpc.getDeleteTransportMethod) == null) {
          TransportManagerGrpc.getDeleteTransportMethod =
              getDeleteTransportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta.DeleteTransportRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTransport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.DeleteTransportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TransportManagerMethodDescriptorSupplier("DeleteTransport"))
                      .build();
        }
      }
    }
    return getDeleteTransportMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static TransportManagerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TransportManagerStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TransportManagerStub>() {
          @java.lang.Override
          public TransportManagerStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TransportManagerStub(channel, callOptions);
          }
        };
    return TransportManagerStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static TransportManagerBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TransportManagerBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TransportManagerBlockingV2Stub>() {
          @java.lang.Override
          public TransportManagerBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TransportManagerBlockingV2Stub(channel, callOptions);
          }
        };
    return TransportManagerBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TransportManagerBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TransportManagerBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TransportManagerBlockingStub>() {
          @java.lang.Override
          public TransportManagerBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TransportManagerBlockingStub(channel, callOptions);
          }
        };
    return TransportManagerBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static TransportManagerFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TransportManagerFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TransportManagerFutureStub>() {
          @java.lang.Override
          public TransportManagerFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TransportManagerFutureStub(channel, callOptions);
          }
        };
    return TransportManagerFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The CLH based service for managing RemoteTransportProfiles and Transports.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists RemoteTransportProfiles in a given project and location.
     * </pre>
     */
    default void listRemoteTransportProfiles(
        com.google.cloud.networkconnectivity.v1beta.ListRemoteTransportProfilesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1beta.ListRemoteTransportProfilesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRemoteTransportProfilesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single RemoteTransportProfile.
     * </pre>
     */
    default void getRemoteTransportProfile(
        com.google.cloud.networkconnectivity.v1beta.GetRemoteTransportProfileRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1beta.RemoteTransportProfile>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetRemoteTransportProfileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Transports in a given project and location.
     * </pre>
     */
    default void listTransports(
        com.google.cloud.networkconnectivity.v1beta.ListTransportsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1beta.ListTransportsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListTransportsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Transport.
     * </pre>
     */
    default void getTransport(
        com.google.cloud.networkconnectivity.v1beta.GetTransportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1beta.Transport>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetTransportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the operational status of a single Transport.
     * </pre>
     */
    default void getStatus(
        com.google.cloud.networkconnectivity.v1beta.GetStatusRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1beta.GetStatusResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetStatusMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Transport in a given project and location.
     * </pre>
     */
    default void createTransport(
        com.google.cloud.networkconnectivity.v1beta.CreateTransportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateTransportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Transport.
     * </pre>
     */
    default void updateTransport(
        com.google.cloud.networkconnectivity.v1beta.UpdateTransportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateTransportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Transport.
     * </pre>
     */
    default void deleteTransport(
        com.google.cloud.networkconnectivity.v1beta.DeleteTransportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteTransportMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service TransportManager.
   *
   * <pre>
   * The CLH based service for managing RemoteTransportProfiles and Transports.
   * </pre>
   */
  public abstract static class TransportManagerImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return TransportManagerGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service TransportManager.
   *
   * <pre>
   * The CLH based service for managing RemoteTransportProfiles and Transports.
   * </pre>
   */
  public static final class TransportManagerStub
      extends io.grpc.stub.AbstractAsyncStub<TransportManagerStub> {
    private TransportManagerStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransportManagerStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TransportManagerStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists RemoteTransportProfiles in a given project and location.
     * </pre>
     */
    public void listRemoteTransportProfiles(
        com.google.cloud.networkconnectivity.v1beta.ListRemoteTransportProfilesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1beta.ListRemoteTransportProfilesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRemoteTransportProfilesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single RemoteTransportProfile.
     * </pre>
     */
    public void getRemoteTransportProfile(
        com.google.cloud.networkconnectivity.v1beta.GetRemoteTransportProfileRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1beta.RemoteTransportProfile>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRemoteTransportProfileMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Transports in a given project and location.
     * </pre>
     */
    public void listTransports(
        com.google.cloud.networkconnectivity.v1beta.ListTransportsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1beta.ListTransportsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTransportsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Transport.
     * </pre>
     */
    public void getTransport(
        com.google.cloud.networkconnectivity.v1beta.GetTransportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1beta.Transport>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTransportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the operational status of a single Transport.
     * </pre>
     */
    public void getStatus(
        com.google.cloud.networkconnectivity.v1beta.GetStatusRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1beta.GetStatusResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Transport in a given project and location.
     * </pre>
     */
    public void createTransport(
        com.google.cloud.networkconnectivity.v1beta.CreateTransportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTransportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Transport.
     * </pre>
     */
    public void updateTransport(
        com.google.cloud.networkconnectivity.v1beta.UpdateTransportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTransportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Transport.
     * </pre>
     */
    public void deleteTransport(
        com.google.cloud.networkconnectivity.v1beta.DeleteTransportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTransportMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service TransportManager.
   *
   * <pre>
   * The CLH based service for managing RemoteTransportProfiles and Transports.
   * </pre>
   */
  public static final class TransportManagerBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<TransportManagerBlockingV2Stub> {
    private TransportManagerBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransportManagerBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TransportManagerBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists RemoteTransportProfiles in a given project and location.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.ListRemoteTransportProfilesResponse
        listRemoteTransportProfiles(
            com.google.cloud.networkconnectivity.v1beta.ListRemoteTransportProfilesRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListRemoteTransportProfilesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single RemoteTransportProfile.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.RemoteTransportProfile
        getRemoteTransportProfile(
            com.google.cloud.networkconnectivity.v1beta.GetRemoteTransportProfileRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetRemoteTransportProfileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Transports in a given project and location.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.ListTransportsResponse listTransports(
        com.google.cloud.networkconnectivity.v1beta.ListTransportsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListTransportsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Transport.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.Transport getTransport(
        com.google.cloud.networkconnectivity.v1beta.GetTransportRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetTransportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the operational status of a single Transport.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.GetStatusResponse getStatus(
        com.google.cloud.networkconnectivity.v1beta.GetStatusRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetStatusMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Transport in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createTransport(
        com.google.cloud.networkconnectivity.v1beta.CreateTransportRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateTransportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Transport.
     * </pre>
     */
    public com.google.longrunning.Operation updateTransport(
        com.google.cloud.networkconnectivity.v1beta.UpdateTransportRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateTransportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Transport.
     * </pre>
     */
    public com.google.longrunning.Operation deleteTransport(
        com.google.cloud.networkconnectivity.v1beta.DeleteTransportRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteTransportMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service TransportManager.
   *
   * <pre>
   * The CLH based service for managing RemoteTransportProfiles and Transports.
   * </pre>
   */
  public static final class TransportManagerBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TransportManagerBlockingStub> {
    private TransportManagerBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransportManagerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TransportManagerBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists RemoteTransportProfiles in a given project and location.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.ListRemoteTransportProfilesResponse
        listRemoteTransportProfiles(
            com.google.cloud.networkconnectivity.v1beta.ListRemoteTransportProfilesRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRemoteTransportProfilesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single RemoteTransportProfile.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.RemoteTransportProfile
        getRemoteTransportProfile(
            com.google.cloud.networkconnectivity.v1beta.GetRemoteTransportProfileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRemoteTransportProfileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Transports in a given project and location.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.ListTransportsResponse listTransports(
        com.google.cloud.networkconnectivity.v1beta.ListTransportsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTransportsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Transport.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.Transport getTransport(
        com.google.cloud.networkconnectivity.v1beta.GetTransportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTransportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the operational status of a single Transport.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.GetStatusResponse getStatus(
        com.google.cloud.networkconnectivity.v1beta.GetStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetStatusMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Transport in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createTransport(
        com.google.cloud.networkconnectivity.v1beta.CreateTransportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTransportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Transport.
     * </pre>
     */
    public com.google.longrunning.Operation updateTransport(
        com.google.cloud.networkconnectivity.v1beta.UpdateTransportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTransportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Transport.
     * </pre>
     */
    public com.google.longrunning.Operation deleteTransport(
        com.google.cloud.networkconnectivity.v1beta.DeleteTransportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTransportMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service TransportManager.
   *
   * <pre>
   * The CLH based service for managing RemoteTransportProfiles and Transports.
   * </pre>
   */
  public static final class TransportManagerFutureStub
      extends io.grpc.stub.AbstractFutureStub<TransportManagerFutureStub> {
    private TransportManagerFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransportManagerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TransportManagerFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists RemoteTransportProfiles in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1beta.ListRemoteTransportProfilesResponse>
        listRemoteTransportProfiles(
            com.google.cloud.networkconnectivity.v1beta.ListRemoteTransportProfilesRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRemoteTransportProfilesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single RemoteTransportProfile.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1beta.RemoteTransportProfile>
        getRemoteTransportProfile(
            com.google.cloud.networkconnectivity.v1beta.GetRemoteTransportProfileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRemoteTransportProfileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Transports in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1beta.ListTransportsResponse>
        listTransports(com.google.cloud.networkconnectivity.v1beta.ListTransportsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTransportsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Transport.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1beta.Transport>
        getTransport(com.google.cloud.networkconnectivity.v1beta.GetTransportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTransportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the operational status of a single Transport.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1beta.GetStatusResponse>
        getStatus(com.google.cloud.networkconnectivity.v1beta.GetStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetStatusMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Transport in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createTransport(
            com.google.cloud.networkconnectivity.v1beta.CreateTransportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTransportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Transport.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateTransport(
            com.google.cloud.networkconnectivity.v1beta.UpdateTransportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTransportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Transport.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteTransport(
            com.google.cloud.networkconnectivity.v1beta.DeleteTransportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTransportMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_REMOTE_TRANSPORT_PROFILES = 0;
  private static final int METHODID_GET_REMOTE_TRANSPORT_PROFILE = 1;
  private static final int METHODID_LIST_TRANSPORTS = 2;
  private static final int METHODID_GET_TRANSPORT = 3;
  private static final int METHODID_GET_STATUS = 4;
  private static final int METHODID_CREATE_TRANSPORT = 5;
  private static final int METHODID_UPDATE_TRANSPORT = 6;
  private static final int METHODID_DELETE_TRANSPORT = 7;

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
        case METHODID_LIST_REMOTE_TRANSPORT_PROFILES:
          serviceImpl.listRemoteTransportProfiles(
              (com.google.cloud.networkconnectivity.v1beta.ListRemoteTransportProfilesRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkconnectivity.v1beta
                          .ListRemoteTransportProfilesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_REMOTE_TRANSPORT_PROFILE:
          serviceImpl.getRemoteTransportProfile(
              (com.google.cloud.networkconnectivity.v1beta.GetRemoteTransportProfileRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkconnectivity.v1beta.RemoteTransportProfile>)
                  responseObserver);
          break;
        case METHODID_LIST_TRANSPORTS:
          serviceImpl.listTransports(
              (com.google.cloud.networkconnectivity.v1beta.ListTransportsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkconnectivity.v1beta.ListTransportsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_TRANSPORT:
          serviceImpl.getTransport(
              (com.google.cloud.networkconnectivity.v1beta.GetTransportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1beta.Transport>)
                  responseObserver);
          break;
        case METHODID_GET_STATUS:
          serviceImpl.getStatus(
              (com.google.cloud.networkconnectivity.v1beta.GetStatusRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkconnectivity.v1beta.GetStatusResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_TRANSPORT:
          serviceImpl.createTransport(
              (com.google.cloud.networkconnectivity.v1beta.CreateTransportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_TRANSPORT:
          serviceImpl.updateTransport(
              (com.google.cloud.networkconnectivity.v1beta.UpdateTransportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_TRANSPORT:
          serviceImpl.deleteTransport(
              (com.google.cloud.networkconnectivity.v1beta.DeleteTransportRequest) request,
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
            getListRemoteTransportProfilesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.ListRemoteTransportProfilesRequest,
                    com.google.cloud.networkconnectivity.v1beta
                        .ListRemoteTransportProfilesResponse>(
                    service, METHODID_LIST_REMOTE_TRANSPORT_PROFILES)))
        .addMethod(
            getGetRemoteTransportProfileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.GetRemoteTransportProfileRequest,
                    com.google.cloud.networkconnectivity.v1beta.RemoteTransportProfile>(
                    service, METHODID_GET_REMOTE_TRANSPORT_PROFILE)))
        .addMethod(
            getListTransportsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.ListTransportsRequest,
                    com.google.cloud.networkconnectivity.v1beta.ListTransportsResponse>(
                    service, METHODID_LIST_TRANSPORTS)))
        .addMethod(
            getGetTransportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.GetTransportRequest,
                    com.google.cloud.networkconnectivity.v1beta.Transport>(
                    service, METHODID_GET_TRANSPORT)))
        .addMethod(
            getGetStatusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.GetStatusRequest,
                    com.google.cloud.networkconnectivity.v1beta.GetStatusResponse>(
                    service, METHODID_GET_STATUS)))
        .addMethod(
            getCreateTransportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.CreateTransportRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_TRANSPORT)))
        .addMethod(
            getUpdateTransportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.UpdateTransportRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_TRANSPORT)))
        .addMethod(
            getDeleteTransportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.DeleteTransportRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_TRANSPORT)))
        .build();
  }

  private abstract static class TransportManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TransportManagerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.networkconnectivity.v1beta.TransportManagerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TransportManager");
    }
  }

  private static final class TransportManagerFileDescriptorSupplier
      extends TransportManagerBaseDescriptorSupplier {
    TransportManagerFileDescriptorSupplier() {}
  }

  private static final class TransportManagerMethodDescriptorSupplier
      extends TransportManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    TransportManagerMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (TransportManagerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new TransportManagerFileDescriptorSupplier())
                      .addMethod(getListRemoteTransportProfilesMethod())
                      .addMethod(getGetRemoteTransportProfileMethod())
                      .addMethod(getListTransportsMethod())
                      .addMethod(getGetTransportMethod())
                      .addMethod(getGetStatusMethod())
                      .addMethod(getCreateTransportMethod())
                      .addMethod(getUpdateTransportMethod())
                      .addMethod(getDeleteTransportMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
