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
package com.google.cloud.aiplatform.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The service that manages Vertex Session related resources.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1beta1/session_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SessionServiceGrpc {

  private SessionServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.aiplatform.v1beta1.SessionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateSessionRequest,
          com.google.longrunning.Operation>
      getCreateSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSession",
      requestType = com.google.cloud.aiplatform.v1beta1.CreateSessionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateSessionRequest,
          com.google.longrunning.Operation>
      getCreateSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.CreateSessionRequest,
            com.google.longrunning.Operation>
        getCreateSessionMethod;
    if ((getCreateSessionMethod = SessionServiceGrpc.getCreateSessionMethod) == null) {
      synchronized (SessionServiceGrpc.class) {
        if ((getCreateSessionMethod = SessionServiceGrpc.getCreateSessionMethod) == null) {
          SessionServiceGrpc.getCreateSessionMethod =
              getCreateSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.CreateSessionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.CreateSessionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SessionServiceMethodDescriptorSupplier("CreateSession"))
                      .build();
        }
      }
    }
    return getCreateSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetSessionRequest,
          com.google.cloud.aiplatform.v1beta1.Session>
      getGetSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSession",
      requestType = com.google.cloud.aiplatform.v1beta1.GetSessionRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.Session.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetSessionRequest,
          com.google.cloud.aiplatform.v1beta1.Session>
      getGetSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetSessionRequest,
            com.google.cloud.aiplatform.v1beta1.Session>
        getGetSessionMethod;
    if ((getGetSessionMethod = SessionServiceGrpc.getGetSessionMethod) == null) {
      synchronized (SessionServiceGrpc.class) {
        if ((getGetSessionMethod = SessionServiceGrpc.getGetSessionMethod) == null) {
          SessionServiceGrpc.getGetSessionMethod =
              getGetSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GetSessionRequest,
                          com.google.cloud.aiplatform.v1beta1.Session>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.GetSessionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.Session.getDefaultInstance()))
                      .setSchemaDescriptor(new SessionServiceMethodDescriptorSupplier("GetSession"))
                      .build();
        }
      }
    }
    return getGetSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListSessionsRequest,
          com.google.cloud.aiplatform.v1beta1.ListSessionsResponse>
      getListSessionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSessions",
      requestType = com.google.cloud.aiplatform.v1beta1.ListSessionsRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListSessionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListSessionsRequest,
          com.google.cloud.aiplatform.v1beta1.ListSessionsResponse>
      getListSessionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListSessionsRequest,
            com.google.cloud.aiplatform.v1beta1.ListSessionsResponse>
        getListSessionsMethod;
    if ((getListSessionsMethod = SessionServiceGrpc.getListSessionsMethod) == null) {
      synchronized (SessionServiceGrpc.class) {
        if ((getListSessionsMethod = SessionServiceGrpc.getListSessionsMethod) == null) {
          SessionServiceGrpc.getListSessionsMethod =
              getListSessionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ListSessionsRequest,
                          com.google.cloud.aiplatform.v1beta1.ListSessionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSessions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListSessionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListSessionsResponse
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
          com.google.cloud.aiplatform.v1beta1.UpdateSessionRequest,
          com.google.cloud.aiplatform.v1beta1.Session>
      getUpdateSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSession",
      requestType = com.google.cloud.aiplatform.v1beta1.UpdateSessionRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.Session.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateSessionRequest,
          com.google.cloud.aiplatform.v1beta1.Session>
      getUpdateSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.UpdateSessionRequest,
            com.google.cloud.aiplatform.v1beta1.Session>
        getUpdateSessionMethod;
    if ((getUpdateSessionMethod = SessionServiceGrpc.getUpdateSessionMethod) == null) {
      synchronized (SessionServiceGrpc.class) {
        if ((getUpdateSessionMethod = SessionServiceGrpc.getUpdateSessionMethod) == null) {
          SessionServiceGrpc.getUpdateSessionMethod =
              getUpdateSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.UpdateSessionRequest,
                          com.google.cloud.aiplatform.v1beta1.Session>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.UpdateSessionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.Session.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SessionServiceMethodDescriptorSupplier("UpdateSession"))
                      .build();
        }
      }
    }
    return getUpdateSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteSessionRequest,
          com.google.longrunning.Operation>
      getDeleteSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSession",
      requestType = com.google.cloud.aiplatform.v1beta1.DeleteSessionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteSessionRequest,
          com.google.longrunning.Operation>
      getDeleteSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeleteSessionRequest,
            com.google.longrunning.Operation>
        getDeleteSessionMethod;
    if ((getDeleteSessionMethod = SessionServiceGrpc.getDeleteSessionMethod) == null) {
      synchronized (SessionServiceGrpc.class) {
        if ((getDeleteSessionMethod = SessionServiceGrpc.getDeleteSessionMethod) == null) {
          SessionServiceGrpc.getDeleteSessionMethod =
              getDeleteSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.DeleteSessionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.DeleteSessionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SessionServiceMethodDescriptorSupplier("DeleteSession"))
                      .build();
        }
      }
    }
    return getDeleteSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListEventsRequest,
          com.google.cloud.aiplatform.v1beta1.ListEventsResponse>
      getListEventsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEvents",
      requestType = com.google.cloud.aiplatform.v1beta1.ListEventsRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListEventsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListEventsRequest,
          com.google.cloud.aiplatform.v1beta1.ListEventsResponse>
      getListEventsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListEventsRequest,
            com.google.cloud.aiplatform.v1beta1.ListEventsResponse>
        getListEventsMethod;
    if ((getListEventsMethod = SessionServiceGrpc.getListEventsMethod) == null) {
      synchronized (SessionServiceGrpc.class) {
        if ((getListEventsMethod = SessionServiceGrpc.getListEventsMethod) == null) {
          SessionServiceGrpc.getListEventsMethod =
              getListEventsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ListEventsRequest,
                          com.google.cloud.aiplatform.v1beta1.ListEventsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEvents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListEventsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListEventsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new SessionServiceMethodDescriptorSupplier("ListEvents"))
                      .build();
        }
      }
    }
    return getListEventsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.AppendEventRequest,
          com.google.cloud.aiplatform.v1beta1.AppendEventResponse>
      getAppendEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AppendEvent",
      requestType = com.google.cloud.aiplatform.v1beta1.AppendEventRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.AppendEventResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.AppendEventRequest,
          com.google.cloud.aiplatform.v1beta1.AppendEventResponse>
      getAppendEventMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.AppendEventRequest,
            com.google.cloud.aiplatform.v1beta1.AppendEventResponse>
        getAppendEventMethod;
    if ((getAppendEventMethod = SessionServiceGrpc.getAppendEventMethod) == null) {
      synchronized (SessionServiceGrpc.class) {
        if ((getAppendEventMethod = SessionServiceGrpc.getAppendEventMethod) == null) {
          SessionServiceGrpc.getAppendEventMethod =
              getAppendEventMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.AppendEventRequest,
                          com.google.cloud.aiplatform.v1beta1.AppendEventResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AppendEvent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.AppendEventRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.AppendEventResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SessionServiceMethodDescriptorSupplier("AppendEvent"))
                      .build();
        }
      }
    }
    return getAppendEventMethod;
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
   * The service that manages Vertex Session related resources.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a new [Session][google.cloud.aiplatform.v1beta1.Session] in a given
     * project and location.
     * </pre>
     */
    default void createSession(
        com.google.cloud.aiplatform.v1beta1.CreateSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specific
     * [Session][google.cloud.aiplatform.v1beta1.Session].
     * </pre>
     */
    default void getSession(
        com.google.cloud.aiplatform.v1beta1.GetSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Session> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists [Sessions][google.cloud.aiplatform.v1beta1.Session] in a given
     * project and location.
     * </pre>
     */
    default void listSessions(
        com.google.cloud.aiplatform.v1beta1.ListSessionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListSessionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSessionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specific [Session][google.cloud.aiplatform.v1beta1.Session].
     * </pre>
     */
    default void updateSession(
        com.google.cloud.aiplatform.v1beta1.UpdateSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Session> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes details of the specific
     * [Session][google.cloud.aiplatform.v1beta1.Session].
     * </pre>
     */
    default void deleteSession(
        com.google.cloud.aiplatform.v1beta1.DeleteSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists [Events][google.cloud.aiplatform.v1beta1.Event] in a given session.
     * </pre>
     */
    default void listEvents(
        com.google.cloud.aiplatform.v1beta1.ListEventsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListEventsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListEventsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Appends an event to a given session.
     * </pre>
     */
    default void appendEvent(
        com.google.cloud.aiplatform.v1beta1.AppendEventRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.AppendEventResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAppendEventMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SessionService.
   *
   * <pre>
   * The service that manages Vertex Session related resources.
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
   * The service that manages Vertex Session related resources.
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
     * Creates a new [Session][google.cloud.aiplatform.v1beta1.Session] in a given
     * project and location.
     * </pre>
     */
    public void createSession(
        com.google.cloud.aiplatform.v1beta1.CreateSessionRequest request,
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
     * Gets details of the specific
     * [Session][google.cloud.aiplatform.v1beta1.Session].
     * </pre>
     */
    public void getSession(
        com.google.cloud.aiplatform.v1beta1.GetSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Session> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSessionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists [Sessions][google.cloud.aiplatform.v1beta1.Session] in a given
     * project and location.
     * </pre>
     */
    public void listSessions(
        com.google.cloud.aiplatform.v1beta1.ListSessionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListSessionsResponse>
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
     * Updates the specific [Session][google.cloud.aiplatform.v1beta1.Session].
     * </pre>
     */
    public void updateSession(
        com.google.cloud.aiplatform.v1beta1.UpdateSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Session> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSessionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes details of the specific
     * [Session][google.cloud.aiplatform.v1beta1.Session].
     * </pre>
     */
    public void deleteSession(
        com.google.cloud.aiplatform.v1beta1.DeleteSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSessionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists [Events][google.cloud.aiplatform.v1beta1.Event] in a given session.
     * </pre>
     */
    public void listEvents(
        com.google.cloud.aiplatform.v1beta1.ListEventsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListEventsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEventsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Appends an event to a given session.
     * </pre>
     */
    public void appendEvent(
        com.google.cloud.aiplatform.v1beta1.AppendEventRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.AppendEventResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAppendEventMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SessionService.
   *
   * <pre>
   * The service that manages Vertex Session related resources.
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
     * Creates a new [Session][google.cloud.aiplatform.v1beta1.Session] in a given
     * project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createSession(
        com.google.cloud.aiplatform.v1beta1.CreateSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specific
     * [Session][google.cloud.aiplatform.v1beta1.Session].
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.Session getSession(
        com.google.cloud.aiplatform.v1beta1.GetSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists [Sessions][google.cloud.aiplatform.v1beta1.Session] in a given
     * project and location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListSessionsResponse listSessions(
        com.google.cloud.aiplatform.v1beta1.ListSessionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSessionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specific [Session][google.cloud.aiplatform.v1beta1.Session].
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.Session updateSession(
        com.google.cloud.aiplatform.v1beta1.UpdateSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes details of the specific
     * [Session][google.cloud.aiplatform.v1beta1.Session].
     * </pre>
     */
    public com.google.longrunning.Operation deleteSession(
        com.google.cloud.aiplatform.v1beta1.DeleteSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists [Events][google.cloud.aiplatform.v1beta1.Event] in a given session.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListEventsResponse listEvents(
        com.google.cloud.aiplatform.v1beta1.ListEventsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEventsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Appends an event to a given session.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.AppendEventResponse appendEvent(
        com.google.cloud.aiplatform.v1beta1.AppendEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAppendEventMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SessionService.
   *
   * <pre>
   * The service that manages Vertex Session related resources.
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
     * Creates a new [Session][google.cloud.aiplatform.v1beta1.Session] in a given
     * project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createSession(com.google.cloud.aiplatform.v1beta1.CreateSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSessionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specific
     * [Session][google.cloud.aiplatform.v1beta1.Session].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.Session>
        getSession(com.google.cloud.aiplatform.v1beta1.GetSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSessionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists [Sessions][google.cloud.aiplatform.v1beta1.Session] in a given
     * project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ListSessionsResponse>
        listSessions(com.google.cloud.aiplatform.v1beta1.ListSessionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSessionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specific [Session][google.cloud.aiplatform.v1beta1.Session].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.Session>
        updateSession(com.google.cloud.aiplatform.v1beta1.UpdateSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSessionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes details of the specific
     * [Session][google.cloud.aiplatform.v1beta1.Session].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteSession(com.google.cloud.aiplatform.v1beta1.DeleteSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSessionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists [Events][google.cloud.aiplatform.v1beta1.Event] in a given session.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ListEventsResponse>
        listEvents(com.google.cloud.aiplatform.v1beta1.ListEventsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEventsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Appends an event to a given session.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.AppendEventResponse>
        appendEvent(com.google.cloud.aiplatform.v1beta1.AppendEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAppendEventMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SESSION = 0;
  private static final int METHODID_GET_SESSION = 1;
  private static final int METHODID_LIST_SESSIONS = 2;
  private static final int METHODID_UPDATE_SESSION = 3;
  private static final int METHODID_DELETE_SESSION = 4;
  private static final int METHODID_LIST_EVENTS = 5;
  private static final int METHODID_APPEND_EVENT = 6;

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
              (com.google.cloud.aiplatform.v1beta1.CreateSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_SESSION:
          serviceImpl.getSession(
              (com.google.cloud.aiplatform.v1beta1.GetSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Session>)
                  responseObserver);
          break;
        case METHODID_LIST_SESSIONS:
          serviceImpl.listSessions(
              (com.google.cloud.aiplatform.v1beta1.ListSessionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ListSessionsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SESSION:
          serviceImpl.updateSession(
              (com.google.cloud.aiplatform.v1beta1.UpdateSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Session>)
                  responseObserver);
          break;
        case METHODID_DELETE_SESSION:
          serviceImpl.deleteSession(
              (com.google.cloud.aiplatform.v1beta1.DeleteSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_EVENTS:
          serviceImpl.listEvents(
              (com.google.cloud.aiplatform.v1beta1.ListEventsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListEventsResponse>)
                  responseObserver);
          break;
        case METHODID_APPEND_EVENT:
          serviceImpl.appendEvent(
              (com.google.cloud.aiplatform.v1beta1.AppendEventRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.AppendEventResponse>)
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
                    com.google.cloud.aiplatform.v1beta1.CreateSessionRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_SESSION)))
        .addMethod(
            getGetSessionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.GetSessionRequest,
                    com.google.cloud.aiplatform.v1beta1.Session>(service, METHODID_GET_SESSION)))
        .addMethod(
            getListSessionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.ListSessionsRequest,
                    com.google.cloud.aiplatform.v1beta1.ListSessionsResponse>(
                    service, METHODID_LIST_SESSIONS)))
        .addMethod(
            getUpdateSessionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.UpdateSessionRequest,
                    com.google.cloud.aiplatform.v1beta1.Session>(service, METHODID_UPDATE_SESSION)))
        .addMethod(
            getDeleteSessionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.DeleteSessionRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_SESSION)))
        .addMethod(
            getListEventsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.ListEventsRequest,
                    com.google.cloud.aiplatform.v1beta1.ListEventsResponse>(
                    service, METHODID_LIST_EVENTS)))
        .addMethod(
            getAppendEventMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.AppendEventRequest,
                    com.google.cloud.aiplatform.v1beta1.AppendEventResponse>(
                    service, METHODID_APPEND_EVENT)))
        .build();
  }

  private abstract static class SessionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SessionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1beta1.SessionServiceProto.getDescriptor();
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
                      .addMethod(getGetSessionMethod())
                      .addMethod(getListSessionsMethod())
                      .addMethod(getUpdateSessionMethod())
                      .addMethod(getDeleteSessionMethod())
                      .addMethod(getListEventsMethod())
                      .addMethod(getAppendEventMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
