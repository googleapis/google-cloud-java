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
package com.google.api.cloudquotas.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The Quotas Adjuster Settings API is an infrastructure service for Google
 *  Cloud that lets service consumers view and update their quota adjuster
 *  settings.
 * - Update quota adjuster settings.
 * - Get the name of the configurations.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/api/cloudquotas/v1beta/quota_adjuster_settings.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class QuotaAdjusterSettingsManagerGrpc {

  private QuotaAdjusterSettingsManagerGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.api.cloudquotas.v1beta.QuotaAdjusterSettingsManager";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.api.cloudquotas.v1beta.UpdateQuotaAdjusterSettingsRequest,
          com.google.api.cloudquotas.v1beta.QuotaAdjusterSettings>
      getUpdateQuotaAdjusterSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateQuotaAdjusterSettings",
      requestType = com.google.api.cloudquotas.v1beta.UpdateQuotaAdjusterSettingsRequest.class,
      responseType = com.google.api.cloudquotas.v1beta.QuotaAdjusterSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.api.cloudquotas.v1beta.UpdateQuotaAdjusterSettingsRequest,
          com.google.api.cloudquotas.v1beta.QuotaAdjusterSettings>
      getUpdateQuotaAdjusterSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.api.cloudquotas.v1beta.UpdateQuotaAdjusterSettingsRequest,
            com.google.api.cloudquotas.v1beta.QuotaAdjusterSettings>
        getUpdateQuotaAdjusterSettingsMethod;
    if ((getUpdateQuotaAdjusterSettingsMethod =
            QuotaAdjusterSettingsManagerGrpc.getUpdateQuotaAdjusterSettingsMethod)
        == null) {
      synchronized (QuotaAdjusterSettingsManagerGrpc.class) {
        if ((getUpdateQuotaAdjusterSettingsMethod =
                QuotaAdjusterSettingsManagerGrpc.getUpdateQuotaAdjusterSettingsMethod)
            == null) {
          QuotaAdjusterSettingsManagerGrpc.getUpdateQuotaAdjusterSettingsMethod =
              getUpdateQuotaAdjusterSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.api.cloudquotas.v1beta.UpdateQuotaAdjusterSettingsRequest,
                          com.google.api.cloudquotas.v1beta.QuotaAdjusterSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateQuotaAdjusterSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.api.cloudquotas.v1beta.UpdateQuotaAdjusterSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.api.cloudquotas.v1beta.QuotaAdjusterSettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new QuotaAdjusterSettingsManagerMethodDescriptorSupplier(
                              "UpdateQuotaAdjusterSettings"))
                      .build();
        }
      }
    }
    return getUpdateQuotaAdjusterSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.api.cloudquotas.v1beta.GetQuotaAdjusterSettingsRequest,
          com.google.api.cloudquotas.v1beta.QuotaAdjusterSettings>
      getGetQuotaAdjusterSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetQuotaAdjusterSettings",
      requestType = com.google.api.cloudquotas.v1beta.GetQuotaAdjusterSettingsRequest.class,
      responseType = com.google.api.cloudquotas.v1beta.QuotaAdjusterSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.api.cloudquotas.v1beta.GetQuotaAdjusterSettingsRequest,
          com.google.api.cloudquotas.v1beta.QuotaAdjusterSettings>
      getGetQuotaAdjusterSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.api.cloudquotas.v1beta.GetQuotaAdjusterSettingsRequest,
            com.google.api.cloudquotas.v1beta.QuotaAdjusterSettings>
        getGetQuotaAdjusterSettingsMethod;
    if ((getGetQuotaAdjusterSettingsMethod =
            QuotaAdjusterSettingsManagerGrpc.getGetQuotaAdjusterSettingsMethod)
        == null) {
      synchronized (QuotaAdjusterSettingsManagerGrpc.class) {
        if ((getGetQuotaAdjusterSettingsMethod =
                QuotaAdjusterSettingsManagerGrpc.getGetQuotaAdjusterSettingsMethod)
            == null) {
          QuotaAdjusterSettingsManagerGrpc.getGetQuotaAdjusterSettingsMethod =
              getGetQuotaAdjusterSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.api.cloudquotas.v1beta.GetQuotaAdjusterSettingsRequest,
                          com.google.api.cloudquotas.v1beta.QuotaAdjusterSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetQuotaAdjusterSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.api.cloudquotas.v1beta.GetQuotaAdjusterSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.api.cloudquotas.v1beta.QuotaAdjusterSettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new QuotaAdjusterSettingsManagerMethodDescriptorSupplier(
                              "GetQuotaAdjusterSettings"))
                      .build();
        }
      }
    }
    return getGetQuotaAdjusterSettingsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static QuotaAdjusterSettingsManagerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<QuotaAdjusterSettingsManagerStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<QuotaAdjusterSettingsManagerStub>() {
          @java.lang.Override
          public QuotaAdjusterSettingsManagerStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new QuotaAdjusterSettingsManagerStub(channel, callOptions);
          }
        };
    return QuotaAdjusterSettingsManagerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static QuotaAdjusterSettingsManagerBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<QuotaAdjusterSettingsManagerBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<QuotaAdjusterSettingsManagerBlockingStub>() {
          @java.lang.Override
          public QuotaAdjusterSettingsManagerBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new QuotaAdjusterSettingsManagerBlockingStub(channel, callOptions);
          }
        };
    return QuotaAdjusterSettingsManagerBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static QuotaAdjusterSettingsManagerFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<QuotaAdjusterSettingsManagerFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<QuotaAdjusterSettingsManagerFutureStub>() {
          @java.lang.Override
          public QuotaAdjusterSettingsManagerFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new QuotaAdjusterSettingsManagerFutureStub(channel, callOptions);
          }
        };
    return QuotaAdjusterSettingsManagerFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The Quotas Adjuster Settings API is an infrastructure service for Google
   *  Cloud that lets service consumers view and update their quota adjuster
   *  settings.
   * - Update quota adjuster settings.
   * - Get the name of the configurations.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * RPC Method for updating QuotaAdjusterSettings based on the request
     * </pre>
     */
    default void updateQuotaAdjusterSettings(
        com.google.api.cloudquotas.v1beta.UpdateQuotaAdjusterSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.api.cloudquotas.v1beta.QuotaAdjusterSettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateQuotaAdjusterSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * RPC Method for getting QuotaAdjusterSettings based on the request
     * </pre>
     */
    default void getQuotaAdjusterSettings(
        com.google.api.cloudquotas.v1beta.GetQuotaAdjusterSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.api.cloudquotas.v1beta.QuotaAdjusterSettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetQuotaAdjusterSettingsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service QuotaAdjusterSettingsManager.
   *
   * <pre>
   * The Quotas Adjuster Settings API is an infrastructure service for Google
   *  Cloud that lets service consumers view and update their quota adjuster
   *  settings.
   * - Update quota adjuster settings.
   * - Get the name of the configurations.
   * </pre>
   */
  public abstract static class QuotaAdjusterSettingsManagerImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return QuotaAdjusterSettingsManagerGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service QuotaAdjusterSettingsManager.
   *
   * <pre>
   * The Quotas Adjuster Settings API is an infrastructure service for Google
   *  Cloud that lets service consumers view and update their quota adjuster
   *  settings.
   * - Update quota adjuster settings.
   * - Get the name of the configurations.
   * </pre>
   */
  public static final class QuotaAdjusterSettingsManagerStub
      extends io.grpc.stub.AbstractAsyncStub<QuotaAdjusterSettingsManagerStub> {
    private QuotaAdjusterSettingsManagerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected QuotaAdjusterSettingsManagerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new QuotaAdjusterSettingsManagerStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * RPC Method for updating QuotaAdjusterSettings based on the request
     * </pre>
     */
    public void updateQuotaAdjusterSettings(
        com.google.api.cloudquotas.v1beta.UpdateQuotaAdjusterSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.api.cloudquotas.v1beta.QuotaAdjusterSettings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateQuotaAdjusterSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * RPC Method for getting QuotaAdjusterSettings based on the request
     * </pre>
     */
    public void getQuotaAdjusterSettings(
        com.google.api.cloudquotas.v1beta.GetQuotaAdjusterSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.api.cloudquotas.v1beta.QuotaAdjusterSettings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetQuotaAdjusterSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service QuotaAdjusterSettingsManager.
   *
   * <pre>
   * The Quotas Adjuster Settings API is an infrastructure service for Google
   *  Cloud that lets service consumers view and update their quota adjuster
   *  settings.
   * - Update quota adjuster settings.
   * - Get the name of the configurations.
   * </pre>
   */
  public static final class QuotaAdjusterSettingsManagerBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<QuotaAdjusterSettingsManagerBlockingStub> {
    private QuotaAdjusterSettingsManagerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected QuotaAdjusterSettingsManagerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new QuotaAdjusterSettingsManagerBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * RPC Method for updating QuotaAdjusterSettings based on the request
     * </pre>
     */
    public com.google.api.cloudquotas.v1beta.QuotaAdjusterSettings updateQuotaAdjusterSettings(
        com.google.api.cloudquotas.v1beta.UpdateQuotaAdjusterSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateQuotaAdjusterSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * RPC Method for getting QuotaAdjusterSettings based on the request
     * </pre>
     */
    public com.google.api.cloudquotas.v1beta.QuotaAdjusterSettings getQuotaAdjusterSettings(
        com.google.api.cloudquotas.v1beta.GetQuotaAdjusterSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetQuotaAdjusterSettingsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * QuotaAdjusterSettingsManager.
   *
   * <pre>
   * The Quotas Adjuster Settings API is an infrastructure service for Google
   *  Cloud that lets service consumers view and update their quota adjuster
   *  settings.
   * - Update quota adjuster settings.
   * - Get the name of the configurations.
   * </pre>
   */
  public static final class QuotaAdjusterSettingsManagerFutureStub
      extends io.grpc.stub.AbstractFutureStub<QuotaAdjusterSettingsManagerFutureStub> {
    private QuotaAdjusterSettingsManagerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected QuotaAdjusterSettingsManagerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new QuotaAdjusterSettingsManagerFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * RPC Method for updating QuotaAdjusterSettings based on the request
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.api.cloudquotas.v1beta.QuotaAdjusterSettings>
        updateQuotaAdjusterSettings(
            com.google.api.cloudquotas.v1beta.UpdateQuotaAdjusterSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateQuotaAdjusterSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * RPC Method for getting QuotaAdjusterSettings based on the request
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.api.cloudquotas.v1beta.QuotaAdjusterSettings>
        getQuotaAdjusterSettings(
            com.google.api.cloudquotas.v1beta.GetQuotaAdjusterSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetQuotaAdjusterSettingsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_UPDATE_QUOTA_ADJUSTER_SETTINGS = 0;
  private static final int METHODID_GET_QUOTA_ADJUSTER_SETTINGS = 1;

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
        case METHODID_UPDATE_QUOTA_ADJUSTER_SETTINGS:
          serviceImpl.updateQuotaAdjusterSettings(
              (com.google.api.cloudquotas.v1beta.UpdateQuotaAdjusterSettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.cloudquotas.v1beta.QuotaAdjusterSettings>)
                  responseObserver);
          break;
        case METHODID_GET_QUOTA_ADJUSTER_SETTINGS:
          serviceImpl.getQuotaAdjusterSettings(
              (com.google.api.cloudquotas.v1beta.GetQuotaAdjusterSettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.cloudquotas.v1beta.QuotaAdjusterSettings>)
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
            getUpdateQuotaAdjusterSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.api.cloudquotas.v1beta.UpdateQuotaAdjusterSettingsRequest,
                    com.google.api.cloudquotas.v1beta.QuotaAdjusterSettings>(
                    service, METHODID_UPDATE_QUOTA_ADJUSTER_SETTINGS)))
        .addMethod(
            getGetQuotaAdjusterSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.api.cloudquotas.v1beta.GetQuotaAdjusterSettingsRequest,
                    com.google.api.cloudquotas.v1beta.QuotaAdjusterSettings>(
                    service, METHODID_GET_QUOTA_ADJUSTER_SETTINGS)))
        .build();
  }

  private abstract static class QuotaAdjusterSettingsManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    QuotaAdjusterSettingsManagerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.api.cloudquotas.v1beta.QuotaAdjusterSettingsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("QuotaAdjusterSettingsManager");
    }
  }

  private static final class QuotaAdjusterSettingsManagerFileDescriptorSupplier
      extends QuotaAdjusterSettingsManagerBaseDescriptorSupplier {
    QuotaAdjusterSettingsManagerFileDescriptorSupplier() {}
  }

  private static final class QuotaAdjusterSettingsManagerMethodDescriptorSupplier
      extends QuotaAdjusterSettingsManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    QuotaAdjusterSettingsManagerMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (QuotaAdjusterSettingsManagerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new QuotaAdjusterSettingsManagerFileDescriptorSupplier())
                      .addMethod(getUpdateQuotaAdjusterSettingsMethod())
                      .addMethod(getGetQuotaAdjusterSettingsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
