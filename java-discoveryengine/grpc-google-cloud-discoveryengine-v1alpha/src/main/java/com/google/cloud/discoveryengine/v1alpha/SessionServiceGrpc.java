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
package com.google.cloud.discoveryengine.v1alpha;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing Sessions and Session-related resources.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/discoveryengine/v1alpha/session_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SessionServiceGrpc {

  private SessionServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.discoveryengine.v1alpha.SessionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.CreateSessionRequest,
          com.google.cloud.discoveryengine.v1alpha.Session>
      getCreateSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSession",
      requestType = com.google.cloud.discoveryengine.v1alpha.CreateSessionRequest.class,
      responseType = com.google.cloud.discoveryengine.v1alpha.Session.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.CreateSessionRequest,
          com.google.cloud.discoveryengine.v1alpha.Session>
      getCreateSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1alpha.CreateSessionRequest,
            com.google.cloud.discoveryengine.v1alpha.Session>
        getCreateSessionMethod;
    if ((getCreateSessionMethod = SessionServiceGrpc.getCreateSessionMethod) == null) {
      synchronized (SessionServiceGrpc.class) {
        if ((getCreateSessionMethod = SessionServiceGrpc.getCreateSessionMethod) == null) {
          SessionServiceGrpc.getCreateSessionMethod =
              getCreateSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1alpha.CreateSessionRequest,
                          com.google.cloud.discoveryengine.v1alpha.Session>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.CreateSessionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.Session
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SessionServiceMethodDescriptorSupplier("CreateSession"))
                      .build();
        }
      }
    }
    return getCreateSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.DeleteSessionRequest, com.google.protobuf.Empty>
      getDeleteSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSession",
      requestType = com.google.cloud.discoveryengine.v1alpha.DeleteSessionRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.DeleteSessionRequest, com.google.protobuf.Empty>
      getDeleteSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1alpha.DeleteSessionRequest,
            com.google.protobuf.Empty>
        getDeleteSessionMethod;
    if ((getDeleteSessionMethod = SessionServiceGrpc.getDeleteSessionMethod) == null) {
      synchronized (SessionServiceGrpc.class) {
        if ((getDeleteSessionMethod = SessionServiceGrpc.getDeleteSessionMethod) == null) {
          SessionServiceGrpc.getDeleteSessionMethod =
              getDeleteSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1alpha.DeleteSessionRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.DeleteSessionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SessionServiceMethodDescriptorSupplier("DeleteSession"))
                      .build();
        }
      }
    }
    return getDeleteSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.UpdateSessionRequest,
          com.google.cloud.discoveryengine.v1alpha.Session>
      getUpdateSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSession",
      requestType = com.google.cloud.discoveryengine.v1alpha.UpdateSessionRequest.class,
      responseType = com.google.cloud.discoveryengine.v1alpha.Session.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.UpdateSessionRequest,
          com.google.cloud.discoveryengine.v1alpha.Session>
      getUpdateSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1alpha.UpdateSessionRequest,
            com.google.cloud.discoveryengine.v1alpha.Session>
        getUpdateSessionMethod;
    if ((getUpdateSessionMethod = SessionServiceGrpc.getUpdateSessionMethod) == null) {
      synchronized (SessionServiceGrpc.class) {
        if ((getUpdateSessionMethod = SessionServiceGrpc.getUpdateSessionMethod) == null) {
          SessionServiceGrpc.getUpdateSessionMethod =
              getUpdateSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1alpha.UpdateSessionRequest,
                          com.google.cloud.discoveryengine.v1alpha.Session>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.UpdateSessionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.Session
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SessionServiceMethodDescriptorSupplier("UpdateSession"))
                      .build();
        }
      }
    }
    return getUpdateSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.GetSessionRequest,
          com.google.cloud.discoveryengine.v1alpha.Session>
      getGetSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSession",
      requestType = com.google.cloud.discoveryengine.v1alpha.GetSessionRequest.class,
      responseType = com.google.cloud.discoveryengine.v1alpha.Session.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.GetSessionRequest,
          com.google.cloud.discoveryengine.v1alpha.Session>
      getGetSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1alpha.GetSessionRequest,
            com.google.cloud.discoveryengine.v1alpha.Session>
        getGetSessionMethod;
    if ((getGetSessionMethod = SessionServiceGrpc.getGetSessionMethod) == null) {
      synchronized (SessionServiceGrpc.class) {
        if ((getGetSessionMethod = SessionServiceGrpc.getGetSessionMethod) == null) {
          SessionServiceGrpc.getGetSessionMethod =
              getGetSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1alpha.GetSessionRequest,
                          com.google.cloud.discoveryengine.v1alpha.Session>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.GetSessionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.Session
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new SessionServiceMethodDescriptorSupplier("GetSession"))
                      .build();
        }
      }
    }
    return getGetSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.ListSessionsRequest,
          com.google.cloud.discoveryengine.v1alpha.ListSessionsResponse>
      getListSessionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSessions",
      requestType = com.google.cloud.discoveryengine.v1alpha.ListSessionsRequest.class,
      responseType = com.google.cloud.discoveryengine.v1alpha.ListSessionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.ListSessionsRequest,
          com.google.cloud.discoveryengine.v1alpha.ListSessionsResponse>
      getListSessionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1alpha.ListSessionsRequest,
            com.google.cloud.discoveryengine.v1alpha.ListSessionsResponse>
        getListSessionsMethod;
    if ((getListSessionsMethod = SessionServiceGrpc.getListSessionsMethod) == null) {
      synchronized (SessionServiceGrpc.class) {
        if ((getListSessionsMethod = SessionServiceGrpc.getListSessionsMethod) == null) {
          SessionServiceGrpc.getListSessionsMethod =
              getListSessionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1alpha.ListSessionsRequest,
                          com.google.cloud.discoveryengine.v1alpha.ListSessionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSessions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.ListSessionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.ListSessionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SessionServiceMethodDescriptorSupplier("ListSessions"))
                      .build();
        }
      }
    }
    return getListSessionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.ListFilesRequest,
          com.google.cloud.discoveryengine.v1alpha.ListFilesResponse>
      getListFilesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFiles",
      requestType = com.google.cloud.discoveryengine.v1alpha.ListFilesRequest.class,
      responseType = com.google.cloud.discoveryengine.v1alpha.ListFilesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.ListFilesRequest,
          com.google.cloud.discoveryengine.v1alpha.ListFilesResponse>
      getListFilesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1alpha.ListFilesRequest,
            com.google.cloud.discoveryengine.v1alpha.ListFilesResponse>
        getListFilesMethod;
    if ((getListFilesMethod = SessionServiceGrpc.getListFilesMethod) == null) {
      synchronized (SessionServiceGrpc.class) {
        if ((getListFilesMethod = SessionServiceGrpc.getListFilesMethod) == null) {
          SessionServiceGrpc.getListFilesMethod =
              getListFilesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1alpha.ListFilesRequest,
                          com.google.cloud.discoveryengine.v1alpha.ListFilesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFiles"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.ListFilesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.ListFilesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new SessionServiceMethodDescriptorSupplier("ListFiles"))
                      .build();
        }
      }
    }
    return getListFilesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SessionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SessionServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SessionServiceStub>() {
          @java.lang.Override
          public SessionServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SessionServiceStub(channel, callOptions);
          }
        };
    return SessionServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static SessionServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SessionServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SessionServiceBlockingV2Stub>() {
          @java.lang.Override
          public SessionServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SessionServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return SessionServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SessionServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SessionServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SessionServiceBlockingStub>() {
          @java.lang.Override
          public SessionServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SessionServiceBlockingStub(channel, callOptions);
          }
        };
    return SessionServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SessionServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SessionServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SessionServiceFutureStub>() {
          @java.lang.Override
          public SessionServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SessionServiceFutureStub(channel, callOptions);
          }
        };
    return SessionServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing Sessions and Session-related resources.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a Session.
     * If the [Session][google.cloud.discoveryengine.v1alpha.Session] to create
     * already exists, an ALREADY_EXISTS error is returned.
     * </pre>
     */
    default void createSession(
        com.google.cloud.discoveryengine.v1alpha.CreateSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.Session>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Session.
     * If the [Session][google.cloud.discoveryengine.v1alpha.Session] to delete
     * does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    default void deleteSession(
        com.google.cloud.discoveryengine.v1alpha.DeleteSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a Session.
     * [Session][google.cloud.discoveryengine.v1alpha.Session] action type cannot
     * be changed. If the [Session][google.cloud.discoveryengine.v1alpha.Session]
     * to update does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    default void updateSession(
        com.google.cloud.discoveryengine.v1alpha.UpdateSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.Session>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a Session.
     * </pre>
     */
    default void getSession(
        com.google.cloud.discoveryengine.v1alpha.GetSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.Session>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all Sessions by their parent
     * [DataStore][google.cloud.discoveryengine.v1alpha.DataStore].
     * </pre>
     */
    default void listSessions(
        com.google.cloud.discoveryengine.v1alpha.ListSessionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.ListSessionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSessionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists metadata for all files in the current session.
     * </pre>
     */
    default void listFiles(
        com.google.cloud.discoveryengine.v1alpha.ListFilesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.ListFilesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListFilesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SessionService.
   *
   * <pre>
   * Service for managing Sessions and Session-related resources.
   * </pre>
   */
  public abstract static class SessionServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SessionServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SessionService.
   *
   * <pre>
   * Service for managing Sessions and Session-related resources.
   * </pre>
   */
  public static final class SessionServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SessionServiceStub> {
    private SessionServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SessionServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SessionServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a Session.
     * If the [Session][google.cloud.discoveryengine.v1alpha.Session] to create
     * already exists, an ALREADY_EXISTS error is returned.
     * </pre>
     */
    public void createSession(
        com.google.cloud.discoveryengine.v1alpha.CreateSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.Session>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSessionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Session.
     * If the [Session][google.cloud.discoveryengine.v1alpha.Session] to delete
     * does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    public void deleteSession(
        com.google.cloud.discoveryengine.v1alpha.DeleteSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSessionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a Session.
     * [Session][google.cloud.discoveryengine.v1alpha.Session] action type cannot
     * be changed. If the [Session][google.cloud.discoveryengine.v1alpha.Session]
     * to update does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    public void updateSession(
        com.google.cloud.discoveryengine.v1alpha.UpdateSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.Session>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSessionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a Session.
     * </pre>
     */
    public void getSession(
        com.google.cloud.discoveryengine.v1alpha.GetSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.Session>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSessionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all Sessions by their parent
     * [DataStore][google.cloud.discoveryengine.v1alpha.DataStore].
     * </pre>
     */
    public void listSessions(
        com.google.cloud.discoveryengine.v1alpha.ListSessionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.ListSessionsResponse>
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
     * Lists metadata for all files in the current session.
     * </pre>
     */
    public void listFiles(
        com.google.cloud.discoveryengine.v1alpha.ListFilesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.ListFilesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFilesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SessionService.
   *
   * <pre>
   * Service for managing Sessions and Session-related resources.
   * </pre>
   */
  public static final class SessionServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<SessionServiceBlockingV2Stub> {
    private SessionServiceBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SessionServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SessionServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a Session.
     * If the [Session][google.cloud.discoveryengine.v1alpha.Session] to create
     * already exists, an ALREADY_EXISTS error is returned.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1alpha.Session createSession(
        com.google.cloud.discoveryengine.v1alpha.CreateSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Session.
     * If the [Session][google.cloud.discoveryengine.v1alpha.Session] to delete
     * does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSession(
        com.google.cloud.discoveryengine.v1alpha.DeleteSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Session.
     * [Session][google.cloud.discoveryengine.v1alpha.Session] action type cannot
     * be changed. If the [Session][google.cloud.discoveryengine.v1alpha.Session]
     * to update does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1alpha.Session updateSession(
        com.google.cloud.discoveryengine.v1alpha.UpdateSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a Session.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1alpha.Session getSession(
        com.google.cloud.discoveryengine.v1alpha.GetSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all Sessions by their parent
     * [DataStore][google.cloud.discoveryengine.v1alpha.DataStore].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1alpha.ListSessionsResponse listSessions(
        com.google.cloud.discoveryengine.v1alpha.ListSessionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSessionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists metadata for all files in the current session.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1alpha.ListFilesResponse listFiles(
        com.google.cloud.discoveryengine.v1alpha.ListFilesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFilesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service SessionService.
   *
   * <pre>
   * Service for managing Sessions and Session-related resources.
   * </pre>
   */
  public static final class SessionServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SessionServiceBlockingStub> {
    private SessionServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SessionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SessionServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a Session.
     * If the [Session][google.cloud.discoveryengine.v1alpha.Session] to create
     * already exists, an ALREADY_EXISTS error is returned.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1alpha.Session createSession(
        com.google.cloud.discoveryengine.v1alpha.CreateSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Session.
     * If the [Session][google.cloud.discoveryengine.v1alpha.Session] to delete
     * does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSession(
        com.google.cloud.discoveryengine.v1alpha.DeleteSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Session.
     * [Session][google.cloud.discoveryengine.v1alpha.Session] action type cannot
     * be changed. If the [Session][google.cloud.discoveryengine.v1alpha.Session]
     * to update does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1alpha.Session updateSession(
        com.google.cloud.discoveryengine.v1alpha.UpdateSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a Session.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1alpha.Session getSession(
        com.google.cloud.discoveryengine.v1alpha.GetSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all Sessions by their parent
     * [DataStore][google.cloud.discoveryengine.v1alpha.DataStore].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1alpha.ListSessionsResponse listSessions(
        com.google.cloud.discoveryengine.v1alpha.ListSessionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSessionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists metadata for all files in the current session.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1alpha.ListFilesResponse listFiles(
        com.google.cloud.discoveryengine.v1alpha.ListFilesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFilesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SessionService.
   *
   * <pre>
   * Service for managing Sessions and Session-related resources.
   * </pre>
   */
  public static final class SessionServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SessionServiceFutureStub> {
    private SessionServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SessionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SessionServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a Session.
     * If the [Session][google.cloud.discoveryengine.v1alpha.Session] to create
     * already exists, an ALREADY_EXISTS error is returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1alpha.Session>
        createSession(com.google.cloud.discoveryengine.v1alpha.CreateSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSessionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Session.
     * If the [Session][google.cloud.discoveryengine.v1alpha.Session] to delete
     * does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteSession(com.google.cloud.discoveryengine.v1alpha.DeleteSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSessionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Session.
     * [Session][google.cloud.discoveryengine.v1alpha.Session] action type cannot
     * be changed. If the [Session][google.cloud.discoveryengine.v1alpha.Session]
     * to update does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1alpha.Session>
        updateSession(com.google.cloud.discoveryengine.v1alpha.UpdateSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSessionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a Session.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1alpha.Session>
        getSession(com.google.cloud.discoveryengine.v1alpha.GetSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSessionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all Sessions by their parent
     * [DataStore][google.cloud.discoveryengine.v1alpha.DataStore].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1alpha.ListSessionsResponse>
        listSessions(com.google.cloud.discoveryengine.v1alpha.ListSessionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSessionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists metadata for all files in the current session.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1alpha.ListFilesResponse>
        listFiles(com.google.cloud.discoveryengine.v1alpha.ListFilesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFilesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SESSION = 0;
  private static final int METHODID_DELETE_SESSION = 1;
  private static final int METHODID_UPDATE_SESSION = 2;
  private static final int METHODID_GET_SESSION = 3;
  private static final int METHODID_LIST_SESSIONS = 4;
  private static final int METHODID_LIST_FILES = 5;

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
              (com.google.cloud.discoveryengine.v1alpha.CreateSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.Session>)
                  responseObserver);
          break;
        case METHODID_DELETE_SESSION:
          serviceImpl.deleteSession(
              (com.google.cloud.discoveryengine.v1alpha.DeleteSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_SESSION:
          serviceImpl.updateSession(
              (com.google.cloud.discoveryengine.v1alpha.UpdateSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.Session>)
                  responseObserver);
          break;
        case METHODID_GET_SESSION:
          serviceImpl.getSession(
              (com.google.cloud.discoveryengine.v1alpha.GetSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.Session>)
                  responseObserver);
          break;
        case METHODID_LIST_SESSIONS:
          serviceImpl.listSessions(
              (com.google.cloud.discoveryengine.v1alpha.ListSessionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.discoveryengine.v1alpha.ListSessionsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_FILES:
          serviceImpl.listFiles(
              (com.google.cloud.discoveryengine.v1alpha.ListFilesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.discoveryengine.v1alpha.ListFilesResponse>)
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
            getCreateSessionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1alpha.CreateSessionRequest,
                    com.google.cloud.discoveryengine.v1alpha.Session>(
                    service, METHODID_CREATE_SESSION)))
        .addMethod(
            getDeleteSessionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1alpha.DeleteSessionRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_SESSION)))
        .addMethod(
            getUpdateSessionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1alpha.UpdateSessionRequest,
                    com.google.cloud.discoveryengine.v1alpha.Session>(
                    service, METHODID_UPDATE_SESSION)))
        .addMethod(
            getGetSessionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1alpha.GetSessionRequest,
                    com.google.cloud.discoveryengine.v1alpha.Session>(
                    service, METHODID_GET_SESSION)))
        .addMethod(
            getListSessionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1alpha.ListSessionsRequest,
                    com.google.cloud.discoveryengine.v1alpha.ListSessionsResponse>(
                    service, METHODID_LIST_SESSIONS)))
        .addMethod(
            getListFilesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1alpha.ListFilesRequest,
                    com.google.cloud.discoveryengine.v1alpha.ListFilesResponse>(
                    service, METHODID_LIST_FILES)))
        .build();
  }

  private abstract static class SessionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SessionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1alpha.SessionServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SessionService");
    }
  }

  private static final class SessionServiceFileDescriptorSupplier
      extends SessionServiceBaseDescriptorSupplier {
    SessionServiceFileDescriptorSupplier() {}
  }

  private static final class SessionServiceMethodDescriptorSupplier
      extends SessionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SessionServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SessionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SessionServiceFileDescriptorSupplier())
                      .addMethod(getCreateSessionMethod())
                      .addMethod(getDeleteSessionMethod())
                      .addMethod(getUpdateSessionMethod())
                      .addMethod(getGetSessionMethod())
                      .addMethod(getListSessionsMethod())
                      .addMethod(getListFilesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
