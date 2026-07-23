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
package com.google.cloud.sql.v1beta4;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Cloud SQL connect service.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class SqlConnectServiceGrpc {

  private SqlConnectServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.sql.v1beta4.SqlConnectService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.GetConnectSettingsRequest,
          com.google.cloud.sql.v1beta4.ConnectSettings>
      getGetConnectSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConnectSettings",
      requestType = com.google.cloud.sql.v1beta4.GetConnectSettingsRequest.class,
      responseType = com.google.cloud.sql.v1beta4.ConnectSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.GetConnectSettingsRequest,
          com.google.cloud.sql.v1beta4.ConnectSettings>
      getGetConnectSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.GetConnectSettingsRequest,
            com.google.cloud.sql.v1beta4.ConnectSettings>
        getGetConnectSettingsMethod;
    if ((getGetConnectSettingsMethod = SqlConnectServiceGrpc.getGetConnectSettingsMethod) == null) {
      synchronized (SqlConnectServiceGrpc.class) {
        if ((getGetConnectSettingsMethod = SqlConnectServiceGrpc.getGetConnectSettingsMethod)
            == null) {
          SqlConnectServiceGrpc.getGetConnectSettingsMethod =
              getGetConnectSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.GetConnectSettingsRequest,
                          com.google.cloud.sql.v1beta4.ConnectSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetConnectSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.GetConnectSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.ConnectSettings.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlConnectServiceMethodDescriptorSupplier("GetConnectSettings"))
                      .build();
        }
      }
    }
    return getGetConnectSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.ResolveConnectSettingsRequest,
          com.google.cloud.sql.v1beta4.ConnectSettings>
      getResolveConnectSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResolveConnectSettings",
      requestType = com.google.cloud.sql.v1beta4.ResolveConnectSettingsRequest.class,
      responseType = com.google.cloud.sql.v1beta4.ConnectSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.ResolveConnectSettingsRequest,
          com.google.cloud.sql.v1beta4.ConnectSettings>
      getResolveConnectSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.ResolveConnectSettingsRequest,
            com.google.cloud.sql.v1beta4.ConnectSettings>
        getResolveConnectSettingsMethod;
    if ((getResolveConnectSettingsMethod = SqlConnectServiceGrpc.getResolveConnectSettingsMethod)
        == null) {
      synchronized (SqlConnectServiceGrpc.class) {
        if ((getResolveConnectSettingsMethod =
                SqlConnectServiceGrpc.getResolveConnectSettingsMethod)
            == null) {
          SqlConnectServiceGrpc.getResolveConnectSettingsMethod =
              getResolveConnectSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.ResolveConnectSettingsRequest,
                          com.google.cloud.sql.v1beta4.ConnectSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ResolveConnectSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.ResolveConnectSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.ConnectSettings.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlConnectServiceMethodDescriptorSupplier("ResolveConnectSettings"))
                      .build();
        }
      }
    }
    return getResolveConnectSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.GenerateEphemeralCertRequest,
          com.google.cloud.sql.v1beta4.GenerateEphemeralCertResponse>
      getGenerateEphemeralCertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateEphemeralCert",
      requestType = com.google.cloud.sql.v1beta4.GenerateEphemeralCertRequest.class,
      responseType = com.google.cloud.sql.v1beta4.GenerateEphemeralCertResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.GenerateEphemeralCertRequest,
          com.google.cloud.sql.v1beta4.GenerateEphemeralCertResponse>
      getGenerateEphemeralCertMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.GenerateEphemeralCertRequest,
            com.google.cloud.sql.v1beta4.GenerateEphemeralCertResponse>
        getGenerateEphemeralCertMethod;
    if ((getGenerateEphemeralCertMethod = SqlConnectServiceGrpc.getGenerateEphemeralCertMethod)
        == null) {
      synchronized (SqlConnectServiceGrpc.class) {
        if ((getGenerateEphemeralCertMethod = SqlConnectServiceGrpc.getGenerateEphemeralCertMethod)
            == null) {
          SqlConnectServiceGrpc.getGenerateEphemeralCertMethod =
              getGenerateEphemeralCertMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.GenerateEphemeralCertRequest,
                          com.google.cloud.sql.v1beta4.GenerateEphemeralCertResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GenerateEphemeralCert"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.GenerateEphemeralCertRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.GenerateEphemeralCertResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlConnectServiceMethodDescriptorSupplier("GenerateEphemeralCert"))
                      .build();
        }
      }
    }
    return getGenerateEphemeralCertMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SqlConnectServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlConnectServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlConnectServiceStub>() {
          @java.lang.Override
          public SqlConnectServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlConnectServiceStub(channel, callOptions);
          }
        };
    return SqlConnectServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static SqlConnectServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlConnectServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlConnectServiceBlockingV2Stub>() {
          @java.lang.Override
          public SqlConnectServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlConnectServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return SqlConnectServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SqlConnectServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlConnectServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlConnectServiceBlockingStub>() {
          @java.lang.Override
          public SqlConnectServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlConnectServiceBlockingStub(channel, callOptions);
          }
        };
    return SqlConnectServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SqlConnectServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlConnectServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlConnectServiceFutureStub>() {
          @java.lang.Override
          public SqlConnectServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlConnectServiceFutureStub(channel, callOptions);
          }
        };
    return SqlConnectServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Cloud SQL connect service.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Retrieves connect settings about a Cloud SQL instance.
     * </pre>
     */
    default void getConnectSettings(
        com.google.cloud.sql.v1beta4.GetConnectSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.ConnectSettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetConnectSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves connect settings about a Cloud SQL instance using the instance
     * DNS name.
     * </pre>
     */
    default void resolveConnectSettings(
        com.google.cloud.sql.v1beta4.ResolveConnectSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.ConnectSettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getResolveConnectSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates a short-lived X509 certificate containing the provided public key
     * and signed by a private key specific to the target instance. Users may use
     * the certificate to authenticate as themselves when connecting to the
     * database.
     * </pre>
     */
    default void generateEphemeralCert(
        com.google.cloud.sql.v1beta4.GenerateEphemeralCertRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.GenerateEphemeralCertResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateEphemeralCertMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SqlConnectService.
   *
   * <pre>
   * Cloud SQL connect service.
   * </pre>
   */
  public abstract static class SqlConnectServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SqlConnectServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SqlConnectService.
   *
   * <pre>
   * Cloud SQL connect service.
   * </pre>
   */
  public static final class SqlConnectServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SqlConnectServiceStub> {
    private SqlConnectServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlConnectServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlConnectServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves connect settings about a Cloud SQL instance.
     * </pre>
     */
    public void getConnectSettings(
        com.google.cloud.sql.v1beta4.GetConnectSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.ConnectSettings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetConnectSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves connect settings about a Cloud SQL instance using the instance
     * DNS name.
     * </pre>
     */
    public void resolveConnectSettings(
        com.google.cloud.sql.v1beta4.ResolveConnectSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.ConnectSettings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResolveConnectSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates a short-lived X509 certificate containing the provided public key
     * and signed by a private key specific to the target instance. Users may use
     * the certificate to authenticate as themselves when connecting to the
     * database.
     * </pre>
     */
    public void generateEphemeralCert(
        com.google.cloud.sql.v1beta4.GenerateEphemeralCertRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.GenerateEphemeralCertResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateEphemeralCertMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SqlConnectService.
   *
   * <pre>
   * Cloud SQL connect service.
   * </pre>
   */
  public static final class SqlConnectServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<SqlConnectServiceBlockingV2Stub> {
    private SqlConnectServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlConnectServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlConnectServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves connect settings about a Cloud SQL instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.ConnectSettings getConnectSettings(
        com.google.cloud.sql.v1beta4.GetConnectSettingsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetConnectSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves connect settings about a Cloud SQL instance using the instance
     * DNS name.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.ConnectSettings resolveConnectSettings(
        com.google.cloud.sql.v1beta4.ResolveConnectSettingsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getResolveConnectSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generates a short-lived X509 certificate containing the provided public key
     * and signed by a private key specific to the target instance. Users may use
     * the certificate to authenticate as themselves when connecting to the
     * database.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.GenerateEphemeralCertResponse generateEphemeralCert(
        com.google.cloud.sql.v1beta4.GenerateEphemeralCertRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGenerateEphemeralCertMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service SqlConnectService.
   *
   * <pre>
   * Cloud SQL connect service.
   * </pre>
   */
  public static final class SqlConnectServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SqlConnectServiceBlockingStub> {
    private SqlConnectServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlConnectServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlConnectServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves connect settings about a Cloud SQL instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.ConnectSettings getConnectSettings(
        com.google.cloud.sql.v1beta4.GetConnectSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConnectSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves connect settings about a Cloud SQL instance using the instance
     * DNS name.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.ConnectSettings resolveConnectSettings(
        com.google.cloud.sql.v1beta4.ResolveConnectSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResolveConnectSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generates a short-lived X509 certificate containing the provided public key
     * and signed by a private key specific to the target instance. Users may use
     * the certificate to authenticate as themselves when connecting to the
     * database.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.GenerateEphemeralCertResponse generateEphemeralCert(
        com.google.cloud.sql.v1beta4.GenerateEphemeralCertRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateEphemeralCertMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SqlConnectService.
   *
   * <pre>
   * Cloud SQL connect service.
   * </pre>
   */
  public static final class SqlConnectServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SqlConnectServiceFutureStub> {
    private SqlConnectServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlConnectServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlConnectServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves connect settings about a Cloud SQL instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.ConnectSettings>
        getConnectSettings(com.google.cloud.sql.v1beta4.GetConnectSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetConnectSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves connect settings about a Cloud SQL instance using the instance
     * DNS name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.ConnectSettings>
        resolveConnectSettings(com.google.cloud.sql.v1beta4.ResolveConnectSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResolveConnectSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Generates a short-lived X509 certificate containing the provided public key
     * and signed by a private key specific to the target instance. Users may use
     * the certificate to authenticate as themselves when connecting to the
     * database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.GenerateEphemeralCertResponse>
        generateEphemeralCert(com.google.cloud.sql.v1beta4.GenerateEphemeralCertRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateEphemeralCertMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_CONNECT_SETTINGS = 0;
  private static final int METHODID_RESOLVE_CONNECT_SETTINGS = 1;
  private static final int METHODID_GENERATE_EPHEMERAL_CERT = 2;

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
        case METHODID_GET_CONNECT_SETTINGS:
          serviceImpl.getConnectSettings(
              (com.google.cloud.sql.v1beta4.GetConnectSettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.ConnectSettings>)
                  responseObserver);
          break;
        case METHODID_RESOLVE_CONNECT_SETTINGS:
          serviceImpl.resolveConnectSettings(
              (com.google.cloud.sql.v1beta4.ResolveConnectSettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.ConnectSettings>)
                  responseObserver);
          break;
        case METHODID_GENERATE_EPHEMERAL_CERT:
          serviceImpl.generateEphemeralCert(
              (com.google.cloud.sql.v1beta4.GenerateEphemeralCertRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.sql.v1beta4.GenerateEphemeralCertResponse>)
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
            getGetConnectSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.GetConnectSettingsRequest,
                    com.google.cloud.sql.v1beta4.ConnectSettings>(
                    service, METHODID_GET_CONNECT_SETTINGS)))
        .addMethod(
            getResolveConnectSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.ResolveConnectSettingsRequest,
                    com.google.cloud.sql.v1beta4.ConnectSettings>(
                    service, METHODID_RESOLVE_CONNECT_SETTINGS)))
        .addMethod(
            getGenerateEphemeralCertMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.GenerateEphemeralCertRequest,
                    com.google.cloud.sql.v1beta4.GenerateEphemeralCertResponse>(
                    service, METHODID_GENERATE_EPHEMERAL_CERT)))
        .build();
  }

  private abstract static class SqlConnectServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SqlConnectServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.sql.v1beta4.CloudSqlConnectProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SqlConnectService");
    }
  }

  private static final class SqlConnectServiceFileDescriptorSupplier
      extends SqlConnectServiceBaseDescriptorSupplier {
    SqlConnectServiceFileDescriptorSupplier() {}
  }

  private static final class SqlConnectServiceMethodDescriptorSupplier
      extends SqlConnectServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SqlConnectServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SqlConnectServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SqlConnectServiceFileDescriptorSupplier())
                      .addMethod(getGetConnectSettingsMethod())
                      .addMethod(getResolveConnectSettingsMethod())
                      .addMethod(getGenerateEphemeralCertMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
