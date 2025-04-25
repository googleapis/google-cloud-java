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
package com.google.shopping.merchant.accounts.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service to manage the automatic improvements of an account. The automatic
 * improvements of the account can be used to automatically update products,
 * improve images and shipping.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/accounts/v1beta/automaticimprovements.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AutomaticImprovementsServiceGrpc {

  private AutomaticImprovementsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.accounts.v1beta.AutomaticImprovementsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.GetAutomaticImprovementsRequest,
          com.google.shopping.merchant.accounts.v1beta.AutomaticImprovements>
      getGetAutomaticImprovementsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAutomaticImprovements",
      requestType =
          com.google.shopping.merchant.accounts.v1beta.GetAutomaticImprovementsRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.AutomaticImprovements.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.GetAutomaticImprovementsRequest,
          com.google.shopping.merchant.accounts.v1beta.AutomaticImprovements>
      getGetAutomaticImprovementsMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.GetAutomaticImprovementsRequest,
            com.google.shopping.merchant.accounts.v1beta.AutomaticImprovements>
        getGetAutomaticImprovementsMethod;
    if ((getGetAutomaticImprovementsMethod =
            AutomaticImprovementsServiceGrpc.getGetAutomaticImprovementsMethod)
        == null) {
      synchronized (AutomaticImprovementsServiceGrpc.class) {
        if ((getGetAutomaticImprovementsMethod =
                AutomaticImprovementsServiceGrpc.getGetAutomaticImprovementsMethod)
            == null) {
          AutomaticImprovementsServiceGrpc.getGetAutomaticImprovementsMethod =
              getGetAutomaticImprovementsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta
                              .GetAutomaticImprovementsRequest,
                          com.google.shopping.merchant.accounts.v1beta.AutomaticImprovements>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetAutomaticImprovements"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta
                                  .GetAutomaticImprovementsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.AutomaticImprovements
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AutomaticImprovementsServiceMethodDescriptorSupplier(
                              "GetAutomaticImprovements"))
                      .build();
        }
      }
    }
    return getGetAutomaticImprovementsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.UpdateAutomaticImprovementsRequest,
          com.google.shopping.merchant.accounts.v1beta.AutomaticImprovements>
      getUpdateAutomaticImprovementsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAutomaticImprovements",
      requestType =
          com.google.shopping.merchant.accounts.v1beta.UpdateAutomaticImprovementsRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.AutomaticImprovements.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.UpdateAutomaticImprovementsRequest,
          com.google.shopping.merchant.accounts.v1beta.AutomaticImprovements>
      getUpdateAutomaticImprovementsMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.UpdateAutomaticImprovementsRequest,
            com.google.shopping.merchant.accounts.v1beta.AutomaticImprovements>
        getUpdateAutomaticImprovementsMethod;
    if ((getUpdateAutomaticImprovementsMethod =
            AutomaticImprovementsServiceGrpc.getUpdateAutomaticImprovementsMethod)
        == null) {
      synchronized (AutomaticImprovementsServiceGrpc.class) {
        if ((getUpdateAutomaticImprovementsMethod =
                AutomaticImprovementsServiceGrpc.getUpdateAutomaticImprovementsMethod)
            == null) {
          AutomaticImprovementsServiceGrpc.getUpdateAutomaticImprovementsMethod =
              getUpdateAutomaticImprovementsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta
                              .UpdateAutomaticImprovementsRequest,
                          com.google.shopping.merchant.accounts.v1beta.AutomaticImprovements>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateAutomaticImprovements"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta
                                  .UpdateAutomaticImprovementsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.AutomaticImprovements
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AutomaticImprovementsServiceMethodDescriptorSupplier(
                              "UpdateAutomaticImprovements"))
                      .build();
        }
      }
    }
    return getUpdateAutomaticImprovementsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AutomaticImprovementsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AutomaticImprovementsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AutomaticImprovementsServiceStub>() {
          @java.lang.Override
          public AutomaticImprovementsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AutomaticImprovementsServiceStub(channel, callOptions);
          }
        };
    return AutomaticImprovementsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AutomaticImprovementsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AutomaticImprovementsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AutomaticImprovementsServiceBlockingStub>() {
          @java.lang.Override
          public AutomaticImprovementsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AutomaticImprovementsServiceBlockingStub(channel, callOptions);
          }
        };
    return AutomaticImprovementsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AutomaticImprovementsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AutomaticImprovementsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AutomaticImprovementsServiceFutureStub>() {
          @java.lang.Override
          public AutomaticImprovementsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AutomaticImprovementsServiceFutureStub(channel, callOptions);
          }
        };
    return AutomaticImprovementsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to manage the automatic improvements of an account. The automatic
   * improvements of the account can be used to automatically update products,
   * improve images and shipping.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Retrieves the automatic improvements of an account.
     * </pre>
     */
    default void getAutomaticImprovements(
        com.google.shopping.merchant.accounts.v1beta.GetAutomaticImprovementsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1beta.AutomaticImprovements>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAutomaticImprovementsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the automatic improvements of an account.
     * </pre>
     */
    default void updateAutomaticImprovements(
        com.google.shopping.merchant.accounts.v1beta.UpdateAutomaticImprovementsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1beta.AutomaticImprovements>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAutomaticImprovementsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AutomaticImprovementsService.
   *
   * <pre>
   * Service to manage the automatic improvements of an account. The automatic
   * improvements of the account can be used to automatically update products,
   * improve images and shipping.
   * </pre>
   */
  public abstract static class AutomaticImprovementsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AutomaticImprovementsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AutomaticImprovementsService.
   *
   * <pre>
   * Service to manage the automatic improvements of an account. The automatic
   * improvements of the account can be used to automatically update products,
   * improve images and shipping.
   * </pre>
   */
  public static final class AutomaticImprovementsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AutomaticImprovementsServiceStub> {
    private AutomaticImprovementsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutomaticImprovementsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutomaticImprovementsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the automatic improvements of an account.
     * </pre>
     */
    public void getAutomaticImprovements(
        com.google.shopping.merchant.accounts.v1beta.GetAutomaticImprovementsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1beta.AutomaticImprovements>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAutomaticImprovementsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the automatic improvements of an account.
     * </pre>
     */
    public void updateAutomaticImprovements(
        com.google.shopping.merchant.accounts.v1beta.UpdateAutomaticImprovementsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1beta.AutomaticImprovements>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAutomaticImprovementsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AutomaticImprovementsService.
   *
   * <pre>
   * Service to manage the automatic improvements of an account. The automatic
   * improvements of the account can be used to automatically update products,
   * improve images and shipping.
   * </pre>
   */
  public static final class AutomaticImprovementsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AutomaticImprovementsServiceBlockingStub> {
    private AutomaticImprovementsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutomaticImprovementsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutomaticImprovementsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the automatic improvements of an account.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.AutomaticImprovements
        getAutomaticImprovements(
            com.google.shopping.merchant.accounts.v1beta.GetAutomaticImprovementsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAutomaticImprovementsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the automatic improvements of an account.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.AutomaticImprovements
        updateAutomaticImprovements(
            com.google.shopping.merchant.accounts.v1beta.UpdateAutomaticImprovementsRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAutomaticImprovementsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * AutomaticImprovementsService.
   *
   * <pre>
   * Service to manage the automatic improvements of an account. The automatic
   * improvements of the account can be used to automatically update products,
   * improve images and shipping.
   * </pre>
   */
  public static final class AutomaticImprovementsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AutomaticImprovementsServiceFutureStub> {
    private AutomaticImprovementsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutomaticImprovementsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutomaticImprovementsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the automatic improvements of an account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.AutomaticImprovements>
        getAutomaticImprovements(
            com.google.shopping.merchant.accounts.v1beta.GetAutomaticImprovementsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAutomaticImprovementsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the automatic improvements of an account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.AutomaticImprovements>
        updateAutomaticImprovements(
            com.google.shopping.merchant.accounts.v1beta.UpdateAutomaticImprovementsRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAutomaticImprovementsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_AUTOMATIC_IMPROVEMENTS = 0;
  private static final int METHODID_UPDATE_AUTOMATIC_IMPROVEMENTS = 1;

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
        case METHODID_GET_AUTOMATIC_IMPROVEMENTS:
          serviceImpl.getAutomaticImprovements(
              (com.google.shopping.merchant.accounts.v1beta.GetAutomaticImprovementsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1beta.AutomaticImprovements>)
                  responseObserver);
          break;
        case METHODID_UPDATE_AUTOMATIC_IMPROVEMENTS:
          serviceImpl.updateAutomaticImprovements(
              (com.google.shopping.merchant.accounts.v1beta.UpdateAutomaticImprovementsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1beta.AutomaticImprovements>)
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
            getGetAutomaticImprovementsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.GetAutomaticImprovementsRequest,
                    com.google.shopping.merchant.accounts.v1beta.AutomaticImprovements>(
                    service, METHODID_GET_AUTOMATIC_IMPROVEMENTS)))
        .addMethod(
            getUpdateAutomaticImprovementsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.UpdateAutomaticImprovementsRequest,
                    com.google.shopping.merchant.accounts.v1beta.AutomaticImprovements>(
                    service, METHODID_UPDATE_AUTOMATIC_IMPROVEMENTS)))
        .build();
  }

  private abstract static class AutomaticImprovementsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AutomaticImprovementsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.accounts.v1beta.AutomaticImprovementsProto
          .getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AutomaticImprovementsService");
    }
  }

  private static final class AutomaticImprovementsServiceFileDescriptorSupplier
      extends AutomaticImprovementsServiceBaseDescriptorSupplier {
    AutomaticImprovementsServiceFileDescriptorSupplier() {}
  }

  private static final class AutomaticImprovementsServiceMethodDescriptorSupplier
      extends AutomaticImprovementsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AutomaticImprovementsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AutomaticImprovementsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AutomaticImprovementsServiceFileDescriptorSupplier())
                      .addMethod(getGetAutomaticImprovementsMethod())
                      .addMethod(getUpdateAutomaticImprovementsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
