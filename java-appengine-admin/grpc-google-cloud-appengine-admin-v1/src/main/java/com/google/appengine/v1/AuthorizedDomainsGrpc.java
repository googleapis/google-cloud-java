/*
 * Copyright 2020 Google LLC
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
package com.google.appengine.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Manages domains a user is authorized to administer. To authorize use of a
 * domain, verify ownership via
 * [Webmaster Central](https://www.google.com/webmasters/verification/home).
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/appengine/v1/appengine.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AuthorizedDomainsGrpc {

  private AuthorizedDomainsGrpc() {}

  public static final String SERVICE_NAME = "google.appengine.v1.AuthorizedDomains";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.appengine.v1.ListAuthorizedDomainsRequest,
          com.google.appengine.v1.ListAuthorizedDomainsResponse>
      getListAuthorizedDomainsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAuthorizedDomains",
      requestType = com.google.appengine.v1.ListAuthorizedDomainsRequest.class,
      responseType = com.google.appengine.v1.ListAuthorizedDomainsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.appengine.v1.ListAuthorizedDomainsRequest,
          com.google.appengine.v1.ListAuthorizedDomainsResponse>
      getListAuthorizedDomainsMethod() {
    io.grpc.MethodDescriptor<
            com.google.appengine.v1.ListAuthorizedDomainsRequest,
            com.google.appengine.v1.ListAuthorizedDomainsResponse>
        getListAuthorizedDomainsMethod;
    if ((getListAuthorizedDomainsMethod = AuthorizedDomainsGrpc.getListAuthorizedDomainsMethod)
        == null) {
      synchronized (AuthorizedDomainsGrpc.class) {
        if ((getListAuthorizedDomainsMethod = AuthorizedDomainsGrpc.getListAuthorizedDomainsMethod)
            == null) {
          AuthorizedDomainsGrpc.getListAuthorizedDomainsMethod =
              getListAuthorizedDomainsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.appengine.v1.ListAuthorizedDomainsRequest,
                          com.google.appengine.v1.ListAuthorizedDomainsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAuthorizedDomains"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.appengine.v1.ListAuthorizedDomainsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.appengine.v1.ListAuthorizedDomainsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AuthorizedDomainsMethodDescriptorSupplier("ListAuthorizedDomains"))
                      .build();
        }
      }
    }
    return getListAuthorizedDomainsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AuthorizedDomainsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthorizedDomainsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AuthorizedDomainsStub>() {
          @java.lang.Override
          public AuthorizedDomainsStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AuthorizedDomainsStub(channel, callOptions);
          }
        };
    return AuthorizedDomainsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AuthorizedDomainsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthorizedDomainsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AuthorizedDomainsBlockingStub>() {
          @java.lang.Override
          public AuthorizedDomainsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AuthorizedDomainsBlockingStub(channel, callOptions);
          }
        };
    return AuthorizedDomainsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AuthorizedDomainsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthorizedDomainsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AuthorizedDomainsFutureStub>() {
          @java.lang.Override
          public AuthorizedDomainsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AuthorizedDomainsFutureStub(channel, callOptions);
          }
        };
    return AuthorizedDomainsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Manages domains a user is authorized to administer. To authorize use of a
   * domain, verify ownership via
   * [Webmaster Central](https://www.google.com/webmasters/verification/home).
   * </pre>
   */
  public abstract static class AuthorizedDomainsImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Lists all domains the user is authorized to administer.
     * </pre>
     */
    public void listAuthorizedDomains(
        com.google.appengine.v1.ListAuthorizedDomainsRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.ListAuthorizedDomainsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAuthorizedDomainsMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListAuthorizedDomainsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.appengine.v1.ListAuthorizedDomainsRequest,
                      com.google.appengine.v1.ListAuthorizedDomainsResponse>(
                      this, METHODID_LIST_AUTHORIZED_DOMAINS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Manages domains a user is authorized to administer. To authorize use of a
   * domain, verify ownership via
   * [Webmaster Central](https://www.google.com/webmasters/verification/home).
   * </pre>
   */
  public static final class AuthorizedDomainsStub
      extends io.grpc.stub.AbstractAsyncStub<AuthorizedDomainsStub> {
    private AuthorizedDomainsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthorizedDomainsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthorizedDomainsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all domains the user is authorized to administer.
     * </pre>
     */
    public void listAuthorizedDomains(
        com.google.appengine.v1.ListAuthorizedDomainsRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.ListAuthorizedDomainsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAuthorizedDomainsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Manages domains a user is authorized to administer. To authorize use of a
   * domain, verify ownership via
   * [Webmaster Central](https://www.google.com/webmasters/verification/home).
   * </pre>
   */
  public static final class AuthorizedDomainsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AuthorizedDomainsBlockingStub> {
    private AuthorizedDomainsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthorizedDomainsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthorizedDomainsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all domains the user is authorized to administer.
     * </pre>
     */
    public com.google.appengine.v1.ListAuthorizedDomainsResponse listAuthorizedDomains(
        com.google.appengine.v1.ListAuthorizedDomainsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAuthorizedDomainsMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Manages domains a user is authorized to administer. To authorize use of a
   * domain, verify ownership via
   * [Webmaster Central](https://www.google.com/webmasters/verification/home).
   * </pre>
   */
  public static final class AuthorizedDomainsFutureStub
      extends io.grpc.stub.AbstractFutureStub<AuthorizedDomainsFutureStub> {
    private AuthorizedDomainsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthorizedDomainsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthorizedDomainsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all domains the user is authorized to administer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.appengine.v1.ListAuthorizedDomainsResponse>
        listAuthorizedDomains(com.google.appengine.v1.ListAuthorizedDomainsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAuthorizedDomainsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_AUTHORIZED_DOMAINS = 0;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AuthorizedDomainsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AuthorizedDomainsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_AUTHORIZED_DOMAINS:
          serviceImpl.listAuthorizedDomains(
              (com.google.appengine.v1.ListAuthorizedDomainsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.appengine.v1.ListAuthorizedDomainsResponse>)
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

  private abstract static class AuthorizedDomainsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AuthorizedDomainsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.appengine.v1.AppengineProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AuthorizedDomains");
    }
  }

  private static final class AuthorizedDomainsFileDescriptorSupplier
      extends AuthorizedDomainsBaseDescriptorSupplier {
    AuthorizedDomainsFileDescriptorSupplier() {}
  }

  private static final class AuthorizedDomainsMethodDescriptorSupplier
      extends AuthorizedDomainsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AuthorizedDomainsMethodDescriptorSupplier(String methodName) {
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
      synchronized (AuthorizedDomainsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AuthorizedDomainsFileDescriptorSupplier())
                      .addMethod(getListAuthorizedDomainsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
