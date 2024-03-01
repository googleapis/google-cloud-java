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
 * The SessionTemplateController provides methods to manage session templates.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dataproc/v1/session_templates.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SessionTemplateControllerGrpc {

  private SessionTemplateControllerGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.dataproc.v1.SessionTemplateController";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.CreateSessionTemplateRequest,
          com.google.cloud.dataproc.v1.SessionTemplate>
      getCreateSessionTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSessionTemplate",
      requestType = com.google.cloud.dataproc.v1.CreateSessionTemplateRequest.class,
      responseType = com.google.cloud.dataproc.v1.SessionTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.CreateSessionTemplateRequest,
          com.google.cloud.dataproc.v1.SessionTemplate>
      getCreateSessionTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1.CreateSessionTemplateRequest,
            com.google.cloud.dataproc.v1.SessionTemplate>
        getCreateSessionTemplateMethod;
    if ((getCreateSessionTemplateMethod =
            SessionTemplateControllerGrpc.getCreateSessionTemplateMethod)
        == null) {
      synchronized (SessionTemplateControllerGrpc.class) {
        if ((getCreateSessionTemplateMethod =
                SessionTemplateControllerGrpc.getCreateSessionTemplateMethod)
            == null) {
          SessionTemplateControllerGrpc.getCreateSessionTemplateMethod =
              getCreateSessionTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataproc.v1.CreateSessionTemplateRequest,
                          com.google.cloud.dataproc.v1.SessionTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateSessionTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.CreateSessionTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.SessionTemplate.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SessionTemplateControllerMethodDescriptorSupplier(
                              "CreateSessionTemplate"))
                      .build();
        }
      }
    }
    return getCreateSessionTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.UpdateSessionTemplateRequest,
          com.google.cloud.dataproc.v1.SessionTemplate>
      getUpdateSessionTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSessionTemplate",
      requestType = com.google.cloud.dataproc.v1.UpdateSessionTemplateRequest.class,
      responseType = com.google.cloud.dataproc.v1.SessionTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.UpdateSessionTemplateRequest,
          com.google.cloud.dataproc.v1.SessionTemplate>
      getUpdateSessionTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1.UpdateSessionTemplateRequest,
            com.google.cloud.dataproc.v1.SessionTemplate>
        getUpdateSessionTemplateMethod;
    if ((getUpdateSessionTemplateMethod =
            SessionTemplateControllerGrpc.getUpdateSessionTemplateMethod)
        == null) {
      synchronized (SessionTemplateControllerGrpc.class) {
        if ((getUpdateSessionTemplateMethod =
                SessionTemplateControllerGrpc.getUpdateSessionTemplateMethod)
            == null) {
          SessionTemplateControllerGrpc.getUpdateSessionTemplateMethod =
              getUpdateSessionTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataproc.v1.UpdateSessionTemplateRequest,
                          com.google.cloud.dataproc.v1.SessionTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateSessionTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.UpdateSessionTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.SessionTemplate.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SessionTemplateControllerMethodDescriptorSupplier(
                              "UpdateSessionTemplate"))
                      .build();
        }
      }
    }
    return getUpdateSessionTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.GetSessionTemplateRequest,
          com.google.cloud.dataproc.v1.SessionTemplate>
      getGetSessionTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSessionTemplate",
      requestType = com.google.cloud.dataproc.v1.GetSessionTemplateRequest.class,
      responseType = com.google.cloud.dataproc.v1.SessionTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.GetSessionTemplateRequest,
          com.google.cloud.dataproc.v1.SessionTemplate>
      getGetSessionTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1.GetSessionTemplateRequest,
            com.google.cloud.dataproc.v1.SessionTemplate>
        getGetSessionTemplateMethod;
    if ((getGetSessionTemplateMethod = SessionTemplateControllerGrpc.getGetSessionTemplateMethod)
        == null) {
      synchronized (SessionTemplateControllerGrpc.class) {
        if ((getGetSessionTemplateMethod =
                SessionTemplateControllerGrpc.getGetSessionTemplateMethod)
            == null) {
          SessionTemplateControllerGrpc.getGetSessionTemplateMethod =
              getGetSessionTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataproc.v1.GetSessionTemplateRequest,
                          com.google.cloud.dataproc.v1.SessionTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSessionTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.GetSessionTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.SessionTemplate.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SessionTemplateControllerMethodDescriptorSupplier(
                              "GetSessionTemplate"))
                      .build();
        }
      }
    }
    return getGetSessionTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.ListSessionTemplatesRequest,
          com.google.cloud.dataproc.v1.ListSessionTemplatesResponse>
      getListSessionTemplatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSessionTemplates",
      requestType = com.google.cloud.dataproc.v1.ListSessionTemplatesRequest.class,
      responseType = com.google.cloud.dataproc.v1.ListSessionTemplatesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.ListSessionTemplatesRequest,
          com.google.cloud.dataproc.v1.ListSessionTemplatesResponse>
      getListSessionTemplatesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1.ListSessionTemplatesRequest,
            com.google.cloud.dataproc.v1.ListSessionTemplatesResponse>
        getListSessionTemplatesMethod;
    if ((getListSessionTemplatesMethod =
            SessionTemplateControllerGrpc.getListSessionTemplatesMethod)
        == null) {
      synchronized (SessionTemplateControllerGrpc.class) {
        if ((getListSessionTemplatesMethod =
                SessionTemplateControllerGrpc.getListSessionTemplatesMethod)
            == null) {
          SessionTemplateControllerGrpc.getListSessionTemplatesMethod =
              getListSessionTemplatesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataproc.v1.ListSessionTemplatesRequest,
                          com.google.cloud.dataproc.v1.ListSessionTemplatesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListSessionTemplates"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.ListSessionTemplatesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.ListSessionTemplatesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SessionTemplateControllerMethodDescriptorSupplier(
                              "ListSessionTemplates"))
                      .build();
        }
      }
    }
    return getListSessionTemplatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.DeleteSessionTemplateRequest, com.google.protobuf.Empty>
      getDeleteSessionTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSessionTemplate",
      requestType = com.google.cloud.dataproc.v1.DeleteSessionTemplateRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.DeleteSessionTemplateRequest, com.google.protobuf.Empty>
      getDeleteSessionTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1.DeleteSessionTemplateRequest, com.google.protobuf.Empty>
        getDeleteSessionTemplateMethod;
    if ((getDeleteSessionTemplateMethod =
            SessionTemplateControllerGrpc.getDeleteSessionTemplateMethod)
        == null) {
      synchronized (SessionTemplateControllerGrpc.class) {
        if ((getDeleteSessionTemplateMethod =
                SessionTemplateControllerGrpc.getDeleteSessionTemplateMethod)
            == null) {
          SessionTemplateControllerGrpc.getDeleteSessionTemplateMethod =
              getDeleteSessionTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataproc.v1.DeleteSessionTemplateRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteSessionTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.DeleteSessionTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SessionTemplateControllerMethodDescriptorSupplier(
                              "DeleteSessionTemplate"))
                      .build();
        }
      }
    }
    return getDeleteSessionTemplateMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SessionTemplateControllerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SessionTemplateControllerStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SessionTemplateControllerStub>() {
          @java.lang.Override
          public SessionTemplateControllerStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SessionTemplateControllerStub(channel, callOptions);
          }
        };
    return SessionTemplateControllerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SessionTemplateControllerBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SessionTemplateControllerBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SessionTemplateControllerBlockingStub>() {
          @java.lang.Override
          public SessionTemplateControllerBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SessionTemplateControllerBlockingStub(channel, callOptions);
          }
        };
    return SessionTemplateControllerBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SessionTemplateControllerFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SessionTemplateControllerFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SessionTemplateControllerFutureStub>() {
          @java.lang.Override
          public SessionTemplateControllerFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SessionTemplateControllerFutureStub(channel, callOptions);
          }
        };
    return SessionTemplateControllerFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The SessionTemplateController provides methods to manage session templates.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Create a session template synchronously.
     * </pre>
     */
    default void createSessionTemplate(
        com.google.cloud.dataproc.v1.CreateSessionTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.SessionTemplate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSessionTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the session template synchronously.
     * </pre>
     */
    default void updateSessionTemplate(
        com.google.cloud.dataproc.v1.UpdateSessionTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.SessionTemplate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSessionTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the resource representation for a session template.
     * </pre>
     */
    default void getSessionTemplate(
        com.google.cloud.dataproc.v1.GetSessionTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.SessionTemplate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSessionTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists session templates.
     * </pre>
     */
    default void listSessionTemplates(
        com.google.cloud.dataproc.v1.ListSessionTemplatesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.ListSessionTemplatesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSessionTemplatesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a session template.
     * </pre>
     */
    default void deleteSessionTemplate(
        com.google.cloud.dataproc.v1.DeleteSessionTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSessionTemplateMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SessionTemplateController.
   *
   * <pre>
   * The SessionTemplateController provides methods to manage session templates.
   * </pre>
   */
  public abstract static class SessionTemplateControllerImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SessionTemplateControllerGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SessionTemplateController.
   *
   * <pre>
   * The SessionTemplateController provides methods to manage session templates.
   * </pre>
   */
  public static final class SessionTemplateControllerStub
      extends io.grpc.stub.AbstractAsyncStub<SessionTemplateControllerStub> {
    private SessionTemplateControllerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SessionTemplateControllerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SessionTemplateControllerStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a session template synchronously.
     * </pre>
     */
    public void createSessionTemplate(
        com.google.cloud.dataproc.v1.CreateSessionTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.SessionTemplate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSessionTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the session template synchronously.
     * </pre>
     */
    public void updateSessionTemplate(
        com.google.cloud.dataproc.v1.UpdateSessionTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.SessionTemplate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSessionTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the resource representation for a session template.
     * </pre>
     */
    public void getSessionTemplate(
        com.google.cloud.dataproc.v1.GetSessionTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.SessionTemplate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSessionTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists session templates.
     * </pre>
     */
    public void listSessionTemplates(
        com.google.cloud.dataproc.v1.ListSessionTemplatesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.ListSessionTemplatesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSessionTemplatesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a session template.
     * </pre>
     */
    public void deleteSessionTemplate(
        com.google.cloud.dataproc.v1.DeleteSessionTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSessionTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SessionTemplateController.
   *
   * <pre>
   * The SessionTemplateController provides methods to manage session templates.
   * </pre>
   */
  public static final class SessionTemplateControllerBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SessionTemplateControllerBlockingStub> {
    private SessionTemplateControllerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SessionTemplateControllerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SessionTemplateControllerBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a session template synchronously.
     * </pre>
     */
    public com.google.cloud.dataproc.v1.SessionTemplate createSessionTemplate(
        com.google.cloud.dataproc.v1.CreateSessionTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSessionTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the session template synchronously.
     * </pre>
     */
    public com.google.cloud.dataproc.v1.SessionTemplate updateSessionTemplate(
        com.google.cloud.dataproc.v1.UpdateSessionTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSessionTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the resource representation for a session template.
     * </pre>
     */
    public com.google.cloud.dataproc.v1.SessionTemplate getSessionTemplate(
        com.google.cloud.dataproc.v1.GetSessionTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSessionTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists session templates.
     * </pre>
     */
    public com.google.cloud.dataproc.v1.ListSessionTemplatesResponse listSessionTemplates(
        com.google.cloud.dataproc.v1.ListSessionTemplatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSessionTemplatesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a session template.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSessionTemplate(
        com.google.cloud.dataproc.v1.DeleteSessionTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSessionTemplateMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * SessionTemplateController.
   *
   * <pre>
   * The SessionTemplateController provides methods to manage session templates.
   * </pre>
   */
  public static final class SessionTemplateControllerFutureStub
      extends io.grpc.stub.AbstractFutureStub<SessionTemplateControllerFutureStub> {
    private SessionTemplateControllerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SessionTemplateControllerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SessionTemplateControllerFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a session template synchronously.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataproc.v1.SessionTemplate>
        createSessionTemplate(com.google.cloud.dataproc.v1.CreateSessionTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSessionTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the session template synchronously.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataproc.v1.SessionTemplate>
        updateSessionTemplate(com.google.cloud.dataproc.v1.UpdateSessionTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSessionTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the resource representation for a session template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataproc.v1.SessionTemplate>
        getSessionTemplate(com.google.cloud.dataproc.v1.GetSessionTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSessionTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists session templates.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataproc.v1.ListSessionTemplatesResponse>
        listSessionTemplates(com.google.cloud.dataproc.v1.ListSessionTemplatesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSessionTemplatesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a session template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteSessionTemplate(com.google.cloud.dataproc.v1.DeleteSessionTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSessionTemplateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SESSION_TEMPLATE = 0;
  private static final int METHODID_UPDATE_SESSION_TEMPLATE = 1;
  private static final int METHODID_GET_SESSION_TEMPLATE = 2;
  private static final int METHODID_LIST_SESSION_TEMPLATES = 3;
  private static final int METHODID_DELETE_SESSION_TEMPLATE = 4;

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
        case METHODID_CREATE_SESSION_TEMPLATE:
          serviceImpl.createSessionTemplate(
              (com.google.cloud.dataproc.v1.CreateSessionTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.SessionTemplate>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SESSION_TEMPLATE:
          serviceImpl.updateSessionTemplate(
              (com.google.cloud.dataproc.v1.UpdateSessionTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.SessionTemplate>)
                  responseObserver);
          break;
        case METHODID_GET_SESSION_TEMPLATE:
          serviceImpl.getSessionTemplate(
              (com.google.cloud.dataproc.v1.GetSessionTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.SessionTemplate>)
                  responseObserver);
          break;
        case METHODID_LIST_SESSION_TEMPLATES:
          serviceImpl.listSessionTemplates(
              (com.google.cloud.dataproc.v1.ListSessionTemplatesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dataproc.v1.ListSessionTemplatesResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_SESSION_TEMPLATE:
          serviceImpl.deleteSessionTemplate(
              (com.google.cloud.dataproc.v1.DeleteSessionTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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
            getCreateSessionTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataproc.v1.CreateSessionTemplateRequest,
                    com.google.cloud.dataproc.v1.SessionTemplate>(
                    service, METHODID_CREATE_SESSION_TEMPLATE)))
        .addMethod(
            getUpdateSessionTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataproc.v1.UpdateSessionTemplateRequest,
                    com.google.cloud.dataproc.v1.SessionTemplate>(
                    service, METHODID_UPDATE_SESSION_TEMPLATE)))
        .addMethod(
            getGetSessionTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataproc.v1.GetSessionTemplateRequest,
                    com.google.cloud.dataproc.v1.SessionTemplate>(
                    service, METHODID_GET_SESSION_TEMPLATE)))
        .addMethod(
            getListSessionTemplatesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataproc.v1.ListSessionTemplatesRequest,
                    com.google.cloud.dataproc.v1.ListSessionTemplatesResponse>(
                    service, METHODID_LIST_SESSION_TEMPLATES)))
        .addMethod(
            getDeleteSessionTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataproc.v1.DeleteSessionTemplateRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_SESSION_TEMPLATE)))
        .build();
  }

  private abstract static class SessionTemplateControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SessionTemplateControllerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dataproc.v1.SessionTemplatesProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SessionTemplateController");
    }
  }

  private static final class SessionTemplateControllerFileDescriptorSupplier
      extends SessionTemplateControllerBaseDescriptorSupplier {
    SessionTemplateControllerFileDescriptorSupplier() {}
  }

  private static final class SessionTemplateControllerMethodDescriptorSupplier
      extends SessionTemplateControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SessionTemplateControllerMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SessionTemplateControllerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SessionTemplateControllerFileDescriptorSupplier())
                      .addMethod(getCreateSessionTemplateMethod())
                      .addMethod(getUpdateSessionTemplateMethod())
                      .addMethod(getGetSessionTemplateMethod())
                      .addMethod(getListSessionTemplatesMethod())
                      .addMethod(getDeleteSessionTemplateMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
