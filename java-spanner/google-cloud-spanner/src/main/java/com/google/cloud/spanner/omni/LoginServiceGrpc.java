/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.omni;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The LoginService is used to authenticate users.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.64.0)",
    comments = "Source: login.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LoginServiceGrpc {

  private LoginServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.spanner.auth.v1.LoginService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.spanner.omni.Login.LoginRequest,
          com.google.cloud.spanner.omni.Login.LoginResponse>
      getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Login",
      requestType = com.google.cloud.spanner.omni.Login.LoginRequest.class,
      responseType = com.google.cloud.spanner.omni.Login.LoginResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.spanner.omni.Login.LoginRequest,
          com.google.cloud.spanner.omni.Login.LoginResponse>
      getLoginMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.spanner.omni.Login.LoginRequest,
            com.google.cloud.spanner.omni.Login.LoginResponse>
        getLoginMethod;
    if ((getLoginMethod = LoginServiceGrpc.getLoginMethod) == null) {
      synchronized (LoginServiceGrpc.class) {
        if ((getLoginMethod = LoginServiceGrpc.getLoginMethod) == null) {
          LoginServiceGrpc.getLoginMethod =
              getLoginMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.spanner.omni.Login.LoginRequest,
                          com.google.cloud.spanner.omni.Login.LoginResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Login"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.spanner.omni.Login.LoginRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.spanner.omni.Login.LoginResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new LoginServiceMethodDescriptorSupplier("Login"))
                      .build();
        }
      }
    }
    return getLoginMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static LoginServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LoginServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LoginServiceStub>() {
          @java.lang.Override
          public LoginServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LoginServiceStub(channel, callOptions);
          }
        };
    return LoginServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LoginServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LoginServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LoginServiceBlockingStub>() {
          @java.lang.Override
          public LoginServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LoginServiceBlockingStub(channel, callOptions);
          }
        };
    return LoginServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static LoginServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LoginServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LoginServiceFutureStub>() {
          @java.lang.Override
          public LoginServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LoginServiceFutureStub(channel, callOptions);
          }
        };
    return LoginServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The LoginService is used to authenticate users.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Performs the login for Spanner Omni.
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.google.cloud.spanner.omni.Login.LoginRequest> login(
        io.grpc.stub.StreamObserver<com.google.cloud.spanner.omni.Login.LoginResponse>
            responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(
          getLoginMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service LoginService.
   *
   * <pre>
   * The LoginService is used to authenticate users.
   * </pre>
   */
  public abstract static class LoginServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return LoginServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service LoginService.
   *
   * <pre>
   * The LoginService is used to authenticate users.
   * </pre>
   */
  public static final class LoginServiceStub
      extends io.grpc.stub.AbstractAsyncStub<LoginServiceStub> {
    private LoginServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoginServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LoginServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Performs the login for Spanner Omni.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.cloud.spanner.omni.Login.LoginRequest> login(
        io.grpc.stub.StreamObserver<com.google.cloud.spanner.omni.Login.LoginResponse>
            responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service LoginService.
   *
   * <pre>
   * The LoginService is used to authenticate users.
   * </pre>
   */
  public static final class LoginServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LoginServiceBlockingStub> {
    private LoginServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoginServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LoginServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service LoginService.
   *
   * <pre>
   * The LoginService is used to authenticate users.
   * </pre>
   */
  public static final class LoginServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<LoginServiceFutureStub> {
    private LoginServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoginServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LoginServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_LOGIN = 0;

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
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN:
          return (io.grpc.stub.StreamObserver<Req>)
              serviceImpl.login(
                  (io.grpc.stub.StreamObserver<com.google.cloud.spanner.omni.Login.LoginResponse>)
                      responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getLoginMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
                new MethodHandlers<
                    com.google.cloud.spanner.omni.Login.LoginRequest,
                    com.google.cloud.spanner.omni.Login.LoginResponse>(service, METHODID_LOGIN)))
        .build();
  }

  private abstract static class LoginServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LoginServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.spanner.omni.Login.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LoginService");
    }
  }

  private static final class LoginServiceFileDescriptorSupplier
      extends LoginServiceBaseDescriptorSupplier {
    LoginServiceFileDescriptorSupplier() {}
  }

  private static final class LoginServiceMethodDescriptorSupplier
      extends LoginServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    LoginServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (LoginServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new LoginServiceFileDescriptorSupplier())
                      .addMethod(getLoginMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
