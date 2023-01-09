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
 * Manages SSL certificates a user is authorized to administer. A user can
 * administer any SSL certificates applicable to their authorized domains.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/appengine/v1/appengine.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AuthorizedCertificatesGrpc {

  private AuthorizedCertificatesGrpc() {}

  public static final String SERVICE_NAME = "google.appengine.v1.AuthorizedCertificates";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.appengine.v1.ListAuthorizedCertificatesRequest,
          com.google.appengine.v1.ListAuthorizedCertificatesResponse>
      getListAuthorizedCertificatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAuthorizedCertificates",
      requestType = com.google.appengine.v1.ListAuthorizedCertificatesRequest.class,
      responseType = com.google.appengine.v1.ListAuthorizedCertificatesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.appengine.v1.ListAuthorizedCertificatesRequest,
          com.google.appengine.v1.ListAuthorizedCertificatesResponse>
      getListAuthorizedCertificatesMethod() {
    io.grpc.MethodDescriptor<
            com.google.appengine.v1.ListAuthorizedCertificatesRequest,
            com.google.appengine.v1.ListAuthorizedCertificatesResponse>
        getListAuthorizedCertificatesMethod;
    if ((getListAuthorizedCertificatesMethod =
            AuthorizedCertificatesGrpc.getListAuthorizedCertificatesMethod)
        == null) {
      synchronized (AuthorizedCertificatesGrpc.class) {
        if ((getListAuthorizedCertificatesMethod =
                AuthorizedCertificatesGrpc.getListAuthorizedCertificatesMethod)
            == null) {
          AuthorizedCertificatesGrpc.getListAuthorizedCertificatesMethod =
              getListAuthorizedCertificatesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.appengine.v1.ListAuthorizedCertificatesRequest,
                          com.google.appengine.v1.ListAuthorizedCertificatesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAuthorizedCertificates"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.appengine.v1.ListAuthorizedCertificatesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.appengine.v1.ListAuthorizedCertificatesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AuthorizedCertificatesMethodDescriptorSupplier(
                              "ListAuthorizedCertificates"))
                      .build();
        }
      }
    }
    return getListAuthorizedCertificatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.appengine.v1.GetAuthorizedCertificateRequest,
          com.google.appengine.v1.AuthorizedCertificate>
      getGetAuthorizedCertificateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAuthorizedCertificate",
      requestType = com.google.appengine.v1.GetAuthorizedCertificateRequest.class,
      responseType = com.google.appengine.v1.AuthorizedCertificate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.appengine.v1.GetAuthorizedCertificateRequest,
          com.google.appengine.v1.AuthorizedCertificate>
      getGetAuthorizedCertificateMethod() {
    io.grpc.MethodDescriptor<
            com.google.appengine.v1.GetAuthorizedCertificateRequest,
            com.google.appengine.v1.AuthorizedCertificate>
        getGetAuthorizedCertificateMethod;
    if ((getGetAuthorizedCertificateMethod =
            AuthorizedCertificatesGrpc.getGetAuthorizedCertificateMethod)
        == null) {
      synchronized (AuthorizedCertificatesGrpc.class) {
        if ((getGetAuthorizedCertificateMethod =
                AuthorizedCertificatesGrpc.getGetAuthorizedCertificateMethod)
            == null) {
          AuthorizedCertificatesGrpc.getGetAuthorizedCertificateMethod =
              getGetAuthorizedCertificateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.appengine.v1.GetAuthorizedCertificateRequest,
                          com.google.appengine.v1.AuthorizedCertificate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetAuthorizedCertificate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.appengine.v1.GetAuthorizedCertificateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.appengine.v1.AuthorizedCertificate.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AuthorizedCertificatesMethodDescriptorSupplier(
                              "GetAuthorizedCertificate"))
                      .build();
        }
      }
    }
    return getGetAuthorizedCertificateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.appengine.v1.CreateAuthorizedCertificateRequest,
          com.google.appengine.v1.AuthorizedCertificate>
      getCreateAuthorizedCertificateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAuthorizedCertificate",
      requestType = com.google.appengine.v1.CreateAuthorizedCertificateRequest.class,
      responseType = com.google.appengine.v1.AuthorizedCertificate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.appengine.v1.CreateAuthorizedCertificateRequest,
          com.google.appengine.v1.AuthorizedCertificate>
      getCreateAuthorizedCertificateMethod() {
    io.grpc.MethodDescriptor<
            com.google.appengine.v1.CreateAuthorizedCertificateRequest,
            com.google.appengine.v1.AuthorizedCertificate>
        getCreateAuthorizedCertificateMethod;
    if ((getCreateAuthorizedCertificateMethod =
            AuthorizedCertificatesGrpc.getCreateAuthorizedCertificateMethod)
        == null) {
      synchronized (AuthorizedCertificatesGrpc.class) {
        if ((getCreateAuthorizedCertificateMethod =
                AuthorizedCertificatesGrpc.getCreateAuthorizedCertificateMethod)
            == null) {
          AuthorizedCertificatesGrpc.getCreateAuthorizedCertificateMethod =
              getCreateAuthorizedCertificateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.appengine.v1.CreateAuthorizedCertificateRequest,
                          com.google.appengine.v1.AuthorizedCertificate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateAuthorizedCertificate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.appengine.v1.CreateAuthorizedCertificateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.appengine.v1.AuthorizedCertificate.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AuthorizedCertificatesMethodDescriptorSupplier(
                              "CreateAuthorizedCertificate"))
                      .build();
        }
      }
    }
    return getCreateAuthorizedCertificateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.appengine.v1.UpdateAuthorizedCertificateRequest,
          com.google.appengine.v1.AuthorizedCertificate>
      getUpdateAuthorizedCertificateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAuthorizedCertificate",
      requestType = com.google.appengine.v1.UpdateAuthorizedCertificateRequest.class,
      responseType = com.google.appengine.v1.AuthorizedCertificate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.appengine.v1.UpdateAuthorizedCertificateRequest,
          com.google.appengine.v1.AuthorizedCertificate>
      getUpdateAuthorizedCertificateMethod() {
    io.grpc.MethodDescriptor<
            com.google.appengine.v1.UpdateAuthorizedCertificateRequest,
            com.google.appengine.v1.AuthorizedCertificate>
        getUpdateAuthorizedCertificateMethod;
    if ((getUpdateAuthorizedCertificateMethod =
            AuthorizedCertificatesGrpc.getUpdateAuthorizedCertificateMethod)
        == null) {
      synchronized (AuthorizedCertificatesGrpc.class) {
        if ((getUpdateAuthorizedCertificateMethod =
                AuthorizedCertificatesGrpc.getUpdateAuthorizedCertificateMethod)
            == null) {
          AuthorizedCertificatesGrpc.getUpdateAuthorizedCertificateMethod =
              getUpdateAuthorizedCertificateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.appengine.v1.UpdateAuthorizedCertificateRequest,
                          com.google.appengine.v1.AuthorizedCertificate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateAuthorizedCertificate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.appengine.v1.UpdateAuthorizedCertificateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.appengine.v1.AuthorizedCertificate.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AuthorizedCertificatesMethodDescriptorSupplier(
                              "UpdateAuthorizedCertificate"))
                      .build();
        }
      }
    }
    return getUpdateAuthorizedCertificateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.appengine.v1.DeleteAuthorizedCertificateRequest, com.google.protobuf.Empty>
      getDeleteAuthorizedCertificateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAuthorizedCertificate",
      requestType = com.google.appengine.v1.DeleteAuthorizedCertificateRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.appengine.v1.DeleteAuthorizedCertificateRequest, com.google.protobuf.Empty>
      getDeleteAuthorizedCertificateMethod() {
    io.grpc.MethodDescriptor<
            com.google.appengine.v1.DeleteAuthorizedCertificateRequest, com.google.protobuf.Empty>
        getDeleteAuthorizedCertificateMethod;
    if ((getDeleteAuthorizedCertificateMethod =
            AuthorizedCertificatesGrpc.getDeleteAuthorizedCertificateMethod)
        == null) {
      synchronized (AuthorizedCertificatesGrpc.class) {
        if ((getDeleteAuthorizedCertificateMethod =
                AuthorizedCertificatesGrpc.getDeleteAuthorizedCertificateMethod)
            == null) {
          AuthorizedCertificatesGrpc.getDeleteAuthorizedCertificateMethod =
              getDeleteAuthorizedCertificateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.appengine.v1.DeleteAuthorizedCertificateRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteAuthorizedCertificate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.appengine.v1.DeleteAuthorizedCertificateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AuthorizedCertificatesMethodDescriptorSupplier(
                              "DeleteAuthorizedCertificate"))
                      .build();
        }
      }
    }
    return getDeleteAuthorizedCertificateMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AuthorizedCertificatesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthorizedCertificatesStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AuthorizedCertificatesStub>() {
          @java.lang.Override
          public AuthorizedCertificatesStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AuthorizedCertificatesStub(channel, callOptions);
          }
        };
    return AuthorizedCertificatesStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AuthorizedCertificatesBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthorizedCertificatesBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AuthorizedCertificatesBlockingStub>() {
          @java.lang.Override
          public AuthorizedCertificatesBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AuthorizedCertificatesBlockingStub(channel, callOptions);
          }
        };
    return AuthorizedCertificatesBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AuthorizedCertificatesFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthorizedCertificatesFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AuthorizedCertificatesFutureStub>() {
          @java.lang.Override
          public AuthorizedCertificatesFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AuthorizedCertificatesFutureStub(channel, callOptions);
          }
        };
    return AuthorizedCertificatesFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Manages SSL certificates a user is authorized to administer. A user can
   * administer any SSL certificates applicable to their authorized domains.
   * </pre>
   */
  public abstract static class AuthorizedCertificatesImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Lists all SSL certificates the user is authorized to administer.
     * </pre>
     */
    public void listAuthorizedCertificates(
        com.google.appengine.v1.ListAuthorizedCertificatesRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.ListAuthorizedCertificatesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAuthorizedCertificatesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified SSL certificate.
     * </pre>
     */
    public void getAuthorizedCertificate(
        com.google.appengine.v1.GetAuthorizedCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.AuthorizedCertificate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAuthorizedCertificateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Uploads the specified SSL certificate.
     * </pre>
     */
    public void createAuthorizedCertificate(
        com.google.appengine.v1.CreateAuthorizedCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.AuthorizedCertificate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAuthorizedCertificateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified SSL certificate. To renew a certificate and maintain
     * its existing domain mappings, update `certificate_data` with a new
     * certificate. The new certificate must be applicable to the same domains as
     * the original certificate. The certificate `display_name` may also be
     * updated.
     * </pre>
     */
    public void updateAuthorizedCertificate(
        com.google.appengine.v1.UpdateAuthorizedCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.AuthorizedCertificate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAuthorizedCertificateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified SSL certificate.
     * </pre>
     */
    public void deleteAuthorizedCertificate(
        com.google.appengine.v1.DeleteAuthorizedCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAuthorizedCertificateMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListAuthorizedCertificatesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.appengine.v1.ListAuthorizedCertificatesRequest,
                      com.google.appengine.v1.ListAuthorizedCertificatesResponse>(
                      this, METHODID_LIST_AUTHORIZED_CERTIFICATES)))
          .addMethod(
              getGetAuthorizedCertificateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.appengine.v1.GetAuthorizedCertificateRequest,
                      com.google.appengine.v1.AuthorizedCertificate>(
                      this, METHODID_GET_AUTHORIZED_CERTIFICATE)))
          .addMethod(
              getCreateAuthorizedCertificateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.appengine.v1.CreateAuthorizedCertificateRequest,
                      com.google.appengine.v1.AuthorizedCertificate>(
                      this, METHODID_CREATE_AUTHORIZED_CERTIFICATE)))
          .addMethod(
              getUpdateAuthorizedCertificateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.appengine.v1.UpdateAuthorizedCertificateRequest,
                      com.google.appengine.v1.AuthorizedCertificate>(
                      this, METHODID_UPDATE_AUTHORIZED_CERTIFICATE)))
          .addMethod(
              getDeleteAuthorizedCertificateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.appengine.v1.DeleteAuthorizedCertificateRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_AUTHORIZED_CERTIFICATE)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Manages SSL certificates a user is authorized to administer. A user can
   * administer any SSL certificates applicable to their authorized domains.
   * </pre>
   */
  public static final class AuthorizedCertificatesStub
      extends io.grpc.stub.AbstractAsyncStub<AuthorizedCertificatesStub> {
    private AuthorizedCertificatesStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthorizedCertificatesStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthorizedCertificatesStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all SSL certificates the user is authorized to administer.
     * </pre>
     */
    public void listAuthorizedCertificates(
        com.google.appengine.v1.ListAuthorizedCertificatesRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.ListAuthorizedCertificatesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAuthorizedCertificatesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified SSL certificate.
     * </pre>
     */
    public void getAuthorizedCertificate(
        com.google.appengine.v1.GetAuthorizedCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.AuthorizedCertificate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAuthorizedCertificateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Uploads the specified SSL certificate.
     * </pre>
     */
    public void createAuthorizedCertificate(
        com.google.appengine.v1.CreateAuthorizedCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.AuthorizedCertificate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAuthorizedCertificateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified SSL certificate. To renew a certificate and maintain
     * its existing domain mappings, update `certificate_data` with a new
     * certificate. The new certificate must be applicable to the same domains as
     * the original certificate. The certificate `display_name` may also be
     * updated.
     * </pre>
     */
    public void updateAuthorizedCertificate(
        com.google.appengine.v1.UpdateAuthorizedCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.AuthorizedCertificate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAuthorizedCertificateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified SSL certificate.
     * </pre>
     */
    public void deleteAuthorizedCertificate(
        com.google.appengine.v1.DeleteAuthorizedCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAuthorizedCertificateMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Manages SSL certificates a user is authorized to administer. A user can
   * administer any SSL certificates applicable to their authorized domains.
   * </pre>
   */
  public static final class AuthorizedCertificatesBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AuthorizedCertificatesBlockingStub> {
    private AuthorizedCertificatesBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthorizedCertificatesBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthorizedCertificatesBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all SSL certificates the user is authorized to administer.
     * </pre>
     */
    public com.google.appengine.v1.ListAuthorizedCertificatesResponse listAuthorizedCertificates(
        com.google.appengine.v1.ListAuthorizedCertificatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAuthorizedCertificatesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified SSL certificate.
     * </pre>
     */
    public com.google.appengine.v1.AuthorizedCertificate getAuthorizedCertificate(
        com.google.appengine.v1.GetAuthorizedCertificateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAuthorizedCertificateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Uploads the specified SSL certificate.
     * </pre>
     */
    public com.google.appengine.v1.AuthorizedCertificate createAuthorizedCertificate(
        com.google.appengine.v1.CreateAuthorizedCertificateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAuthorizedCertificateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified SSL certificate. To renew a certificate and maintain
     * its existing domain mappings, update `certificate_data` with a new
     * certificate. The new certificate must be applicable to the same domains as
     * the original certificate. The certificate `display_name` may also be
     * updated.
     * </pre>
     */
    public com.google.appengine.v1.AuthorizedCertificate updateAuthorizedCertificate(
        com.google.appengine.v1.UpdateAuthorizedCertificateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAuthorizedCertificateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified SSL certificate.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAuthorizedCertificate(
        com.google.appengine.v1.DeleteAuthorizedCertificateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAuthorizedCertificateMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Manages SSL certificates a user is authorized to administer. A user can
   * administer any SSL certificates applicable to their authorized domains.
   * </pre>
   */
  public static final class AuthorizedCertificatesFutureStub
      extends io.grpc.stub.AbstractFutureStub<AuthorizedCertificatesFutureStub> {
    private AuthorizedCertificatesFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthorizedCertificatesFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthorizedCertificatesFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all SSL certificates the user is authorized to administer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.appengine.v1.ListAuthorizedCertificatesResponse>
        listAuthorizedCertificates(
            com.google.appengine.v1.ListAuthorizedCertificatesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAuthorizedCertificatesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified SSL certificate.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.appengine.v1.AuthorizedCertificate>
        getAuthorizedCertificate(com.google.appengine.v1.GetAuthorizedCertificateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAuthorizedCertificateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Uploads the specified SSL certificate.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.appengine.v1.AuthorizedCertificate>
        createAuthorizedCertificate(
            com.google.appengine.v1.CreateAuthorizedCertificateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAuthorizedCertificateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified SSL certificate. To renew a certificate and maintain
     * its existing domain mappings, update `certificate_data` with a new
     * certificate. The new certificate must be applicable to the same domains as
     * the original certificate. The certificate `display_name` may also be
     * updated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.appengine.v1.AuthorizedCertificate>
        updateAuthorizedCertificate(
            com.google.appengine.v1.UpdateAuthorizedCertificateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAuthorizedCertificateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified SSL certificate.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteAuthorizedCertificate(
            com.google.appengine.v1.DeleteAuthorizedCertificateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAuthorizedCertificateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_AUTHORIZED_CERTIFICATES = 0;
  private static final int METHODID_GET_AUTHORIZED_CERTIFICATE = 1;
  private static final int METHODID_CREATE_AUTHORIZED_CERTIFICATE = 2;
  private static final int METHODID_UPDATE_AUTHORIZED_CERTIFICATE = 3;
  private static final int METHODID_DELETE_AUTHORIZED_CERTIFICATE = 4;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AuthorizedCertificatesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AuthorizedCertificatesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_AUTHORIZED_CERTIFICATES:
          serviceImpl.listAuthorizedCertificates(
              (com.google.appengine.v1.ListAuthorizedCertificatesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.appengine.v1.ListAuthorizedCertificatesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_AUTHORIZED_CERTIFICATE:
          serviceImpl.getAuthorizedCertificate(
              (com.google.appengine.v1.GetAuthorizedCertificateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.appengine.v1.AuthorizedCertificate>)
                  responseObserver);
          break;
        case METHODID_CREATE_AUTHORIZED_CERTIFICATE:
          serviceImpl.createAuthorizedCertificate(
              (com.google.appengine.v1.CreateAuthorizedCertificateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.appengine.v1.AuthorizedCertificate>)
                  responseObserver);
          break;
        case METHODID_UPDATE_AUTHORIZED_CERTIFICATE:
          serviceImpl.updateAuthorizedCertificate(
              (com.google.appengine.v1.UpdateAuthorizedCertificateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.appengine.v1.AuthorizedCertificate>)
                  responseObserver);
          break;
        case METHODID_DELETE_AUTHORIZED_CERTIFICATE:
          serviceImpl.deleteAuthorizedCertificate(
              (com.google.appengine.v1.DeleteAuthorizedCertificateRequest) request,
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

  private abstract static class AuthorizedCertificatesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AuthorizedCertificatesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.appengine.v1.AppengineProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AuthorizedCertificates");
    }
  }

  private static final class AuthorizedCertificatesFileDescriptorSupplier
      extends AuthorizedCertificatesBaseDescriptorSupplier {
    AuthorizedCertificatesFileDescriptorSupplier() {}
  }

  private static final class AuthorizedCertificatesMethodDescriptorSupplier
      extends AuthorizedCertificatesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AuthorizedCertificatesMethodDescriptorSupplier(String methodName) {
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
      synchronized (AuthorizedCertificatesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AuthorizedCertificatesFileDescriptorSupplier())
                      .addMethod(getListAuthorizedCertificatesMethod())
                      .addMethod(getGetAuthorizedCertificateMethod())
                      .addMethod(getCreateAuthorizedCertificateMethod())
                      .addMethod(getUpdateAuthorizedCertificateMethod())
                      .addMethod(getDeleteAuthorizedCertificateMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
