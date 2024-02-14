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
package com.google.cloud.dataproc.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The `SessionController` provides methods to manage interactive sessions.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dataproc/v1/sessions.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SessionControllerGrpc {

  private SessionControllerGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.dataproc.v1.SessionController";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.CreateSessionRequest, com.google.longrunning.Operation>
      getCreateSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSession",
      requestType = com.google.cloud.dataproc.v1.CreateSessionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.CreateSessionRequest, com.google.longrunning.Operation>
      getCreateSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1.CreateSessionRequest, com.google.longrunning.Operation>
        getCreateSessionMethod;
    if ((getCreateSessionMethod = SessionControllerGrpc.getCreateSessionMethod) == null) {
      synchronized (SessionControllerGrpc.class) {
        if ((getCreateSessionMethod = SessionControllerGrpc.getCreateSessionMethod) == null) {
          SessionControllerGrpc.getCreateSessionMethod =
              getCreateSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataproc.v1.CreateSessionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.CreateSessionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SessionControllerMethodDescriptorSupplier("CreateSession"))
                      .build();
        }
      }
    }
    return getCreateSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.GetSessionRequest, com.google.cloud.dataproc.v1.Session>
      getGetSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSession",
      requestType = com.google.cloud.dataproc.v1.GetSessionRequest.class,
      responseType = com.google.cloud.dataproc.v1.Session.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.GetSessionRequest, com.google.cloud.dataproc.v1.Session>
      getGetSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1.GetSessionRequest, com.google.cloud.dataproc.v1.Session>
        getGetSessionMethod;
    if ((getGetSessionMethod = SessionControllerGrpc.getGetSessionMethod) == null) {
      synchronized (SessionControllerGrpc.class) {
        if ((getGetSessionMethod = SessionControllerGrpc.getGetSessionMethod) == null) {
          SessionControllerGrpc.getGetSessionMethod =
              getGetSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataproc.v1.GetSessionRequest,
                          com.google.cloud.dataproc.v1.Session>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.GetSessionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.Session.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SessionControllerMethodDescriptorSupplier("GetSession"))
                      .build();
        }
      }
    }
    return getGetSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.ListSessionsRequest,
          com.google.cloud.dataproc.v1.ListSessionsResponse>
      getListSessionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSessions",
      requestType = com.google.cloud.dataproc.v1.ListSessionsRequest.class,
      responseType = com.google.cloud.dataproc.v1.ListSessionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.ListSessionsRequest,
          com.google.cloud.dataproc.v1.ListSessionsResponse>
      getListSessionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1.ListSessionsRequest,
            com.google.cloud.dataproc.v1.ListSessionsResponse>
        getListSessionsMethod;
    if ((getListSessionsMethod = SessionControllerGrpc.getListSessionsMethod) == null) {
      synchronized (SessionControllerGrpc.class) {
        if ((getListSessionsMethod = SessionControllerGrpc.getListSessionsMethod) == null) {
          SessionControllerGrpc.getListSessionsMethod =
              getListSessionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataproc.v1.ListSessionsRequest,
                          com.google.cloud.dataproc.v1.ListSessionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSessions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.ListSessionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.ListSessionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SessionControllerMethodDescriptorSupplier("ListSessions"))
                      .build();
        }
      }
    }
    return getListSessionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.TerminateSessionRequest, com.google.longrunning.Operation>
      getTerminateSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TerminateSession",
      requestType = com.google.cloud.dataproc.v1.TerminateSessionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.TerminateSessionRequest, com.google.longrunning.Operation>
      getTerminateSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1.TerminateSessionRequest, com.google.longrunning.Operation>
        getTerminateSessionMethod;
    if ((getTerminateSessionMethod = SessionControllerGrpc.getTerminateSessionMethod) == null) {
      synchronized (SessionControllerGrpc.class) {
        if ((getTerminateSessionMethod = SessionControllerGrpc.getTerminateSessionMethod) == null) {
          SessionControllerGrpc.getTerminateSessionMethod =
              getTerminateSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataproc.v1.TerminateSessionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TerminateSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.TerminateSessionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SessionControllerMethodDescriptorSupplier("TerminateSession"))
                      .build();
        }
      }
    }
    return getTerminateSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.DeleteSessionRequest, com.google.longrunning.Operation>
      getDeleteSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSession",
      requestType = com.google.cloud.dataproc.v1.DeleteSessionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.DeleteSessionRequest, com.google.longrunning.Operation>
      getDeleteSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1.DeleteSessionRequest, com.google.longrunning.Operation>
        getDeleteSessionMethod;
    if ((getDeleteSessionMethod = SessionControllerGrpc.getDeleteSessionMethod) == null) {
      synchronized (SessionControllerGrpc.class) {
        if ((getDeleteSessionMethod = SessionControllerGrpc.getDeleteSessionMethod) == null) {
          SessionControllerGrpc.getDeleteSessionMethod =
              getDeleteSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataproc.v1.DeleteSessionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.DeleteSessionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SessionControllerMethodDescriptorSupplier("DeleteSession"))
                      .build();
        }
      }
    }
    return getDeleteSessionMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SessionControllerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SessionControllerStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SessionControllerStub>() {
          @java.lang.Override
          public SessionControllerStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SessionControllerStub(channel, callOptions);
          }
        };
    return SessionControllerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SessionControllerBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SessionControllerBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SessionControllerBlockingStub>() {
          @java.lang.Override
          public SessionControllerBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SessionControllerBlockingStub(channel, callOptions);
          }
        };
    return SessionControllerBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SessionControllerFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SessionControllerFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SessionControllerFutureStub>() {
          @java.lang.Override
          public SessionControllerFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SessionControllerFutureStub(channel, callOptions);
          }
        };
    return SessionControllerFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The `SessionController` provides methods to manage interactive sessions.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Create an interactive session asynchronously.
     * </pre>
     */
    default void createSession(
        com.google.cloud.dataproc.v1.CreateSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the resource representation for an interactive session.
     * </pre>
     */
    default void getSession(
        com.google.cloud.dataproc.v1.GetSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.Session> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists interactive sessions.
     * </pre>
     */
    default void listSessions(
        com.google.cloud.dataproc.v1.ListSessionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.ListSessionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSessionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Terminates the interactive session.
     * </pre>
     */
    default void terminateSession(
        com.google.cloud.dataproc.v1.TerminateSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getTerminateSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the interactive session resource. If the session is not in terminal
     * state, it is terminated, and then deleted.
     * </pre>
     */
    default void deleteSession(
        com.google.cloud.dataproc.v1.DeleteSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSessionMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SessionController.
   *
   * <pre>
   * The `SessionController` provides methods to manage interactive sessions.
   * </pre>
   */
  public abstract static class SessionControllerImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SessionControllerGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SessionController.
   *
   * <pre>
   * The `SessionController` provides methods to manage interactive sessions.
   * </pre>
   */
  public static final class SessionControllerStub
      extends io.grpc.stub.AbstractAsyncStub<SessionControllerStub> {
    private SessionControllerStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SessionControllerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SessionControllerStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create an interactive session asynchronously.
     * </pre>
     */
    public void createSession(
        com.google.cloud.dataproc.v1.CreateSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSessionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the resource representation for an interactive session.
     * </pre>
     */
    public void getSession(
        com.google.cloud.dataproc.v1.GetSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.Session> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSessionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists interactive sessions.
     * </pre>
     */
    public void listSessions(
        com.google.cloud.dataproc.v1.ListSessionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.ListSessionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSessionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Terminates the interactive session.
     * </pre>
     */
    public void terminateSession(
        com.google.cloud.dataproc.v1.TerminateSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTerminateSessionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the interactive session resource. If the session is not in terminal
     * state, it is terminated, and then deleted.
     * </pre>
     */
    public void deleteSession(
        com.google.cloud.dataproc.v1.DeleteSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSessionMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SessionController.
   *
   * <pre>
   * The `SessionController` provides methods to manage interactive sessions.
   * </pre>
   */
  public static final class SessionControllerBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SessionControllerBlockingStub> {
    private SessionControllerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SessionControllerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SessionControllerBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create an interactive session asynchronously.
     * </pre>
     */
    public com.google.longrunning.Operation createSession(
        com.google.cloud.dataproc.v1.CreateSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the resource representation for an interactive session.
     * </pre>
     */
    public com.google.cloud.dataproc.v1.Session getSession(
        com.google.cloud.dataproc.v1.GetSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists interactive sessions.
     * </pre>
     */
    public com.google.cloud.dataproc.v1.ListSessionsResponse listSessions(
        com.google.cloud.dataproc.v1.ListSessionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSessionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Terminates the interactive session.
     * </pre>
     */
    public com.google.longrunning.Operation terminateSession(
        com.google.cloud.dataproc.v1.TerminateSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTerminateSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the interactive session resource. If the session is not in terminal
     * state, it is terminated, and then deleted.
     * </pre>
     */
    public com.google.longrunning.Operation deleteSession(
        com.google.cloud.dataproc.v1.DeleteSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSessionMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SessionController.
   *
   * <pre>
   * The `SessionController` provides methods to manage interactive sessions.
   * </pre>
   */
  public static final class SessionControllerFutureStub
      extends io.grpc.stub.AbstractFutureStub<SessionControllerFutureStub> {
    private SessionControllerFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SessionControllerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SessionControllerFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create an interactive session asynchronously.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createSession(com.google.cloud.dataproc.v1.CreateSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSessionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the resource representation for an interactive session.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataproc.v1.Session>
        getSession(com.google.cloud.dataproc.v1.GetSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSessionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists interactive sessions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataproc.v1.ListSessionsResponse>
        listSessions(com.google.cloud.dataproc.v1.ListSessionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSessionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Terminates the interactive session.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        terminateSession(com.google.cloud.dataproc.v1.TerminateSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTerminateSessionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the interactive session resource. If the session is not in terminal
     * state, it is terminated, and then deleted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteSession(com.google.cloud.dataproc.v1.DeleteSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSessionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SESSION = 0;
  private static final int METHODID_GET_SESSION = 1;
  private static final int METHODID_LIST_SESSIONS = 2;
  private static final int METHODID_TERMINATE_SESSION = 3;
  private static final int METHODID_DELETE_SESSION = 4;

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
        case METHODID_CREATE_SESSION:
          serviceImpl.createSession(
              (com.google.cloud.dataproc.v1.CreateSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_SESSION:
          serviceImpl.getSession(
              (com.google.cloud.dataproc.v1.GetSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.Session>) responseObserver);
          break;
        case METHODID_LIST_SESSIONS:
          serviceImpl.listSessions(
              (com.google.cloud.dataproc.v1.ListSessionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.ListSessionsResponse>)
                  responseObserver);
          break;
        case METHODID_TERMINATE_SESSION:
          serviceImpl.terminateSession(
              (com.google.cloud.dataproc.v1.TerminateSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SESSION:
          serviceImpl.deleteSession(
              (com.google.cloud.dataproc.v1.DeleteSessionRequest) request,
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
            getCreateSessionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataproc.v1.CreateSessionRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_SESSION)))
        .addMethod(
            getGetSessionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataproc.v1.GetSessionRequest,
                    com.google.cloud.dataproc.v1.Session>(service, METHODID_GET_SESSION)))
        .addMethod(
            getListSessionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataproc.v1.ListSessionsRequest,
                    com.google.cloud.dataproc.v1.ListSessionsResponse>(
                    service, METHODID_LIST_SESSIONS)))
        .addMethod(
            getTerminateSessionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataproc.v1.TerminateSessionRequest,
                    com.google.longrunning.Operation>(service, METHODID_TERMINATE_SESSION)))
        .addMethod(
            getDeleteSessionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataproc.v1.DeleteSessionRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_SESSION)))
        .build();
  }

  private abstract static class SessionControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SessionControllerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dataproc.v1.SessionsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SessionController");
    }
  }

  private static final class SessionControllerFileDescriptorSupplier
      extends SessionControllerBaseDescriptorSupplier {
    SessionControllerFileDescriptorSupplier() {}
  }

  private static final class SessionControllerMethodDescriptorSupplier
      extends SessionControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SessionControllerMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SessionControllerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SessionControllerFileDescriptorSupplier())
                      .addMethod(getCreateSessionMethod())
                      .addMethod(getGetSessionMethod())
                      .addMethod(getListSessionsMethod())
                      .addMethod(getTerminateSessionMethod())
                      .addMethod(getDeleteSessionMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
