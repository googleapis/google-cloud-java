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
package com.google.shopping.merchant.accounts.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The service facilitates the management of a merchant's LFP provider settings.
 * This API defines the following resource model:
 * - [LfpProvider][google.shopping.merchant.accounts.v1.LfpProvider]
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/accounts/v1/lfpproviders.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LfpProvidersServiceGrpc {

  private LfpProvidersServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.accounts.v1.LfpProvidersService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.FindLfpProvidersRequest,
          com.google.shopping.merchant.accounts.v1.FindLfpProvidersResponse>
      getFindLfpProvidersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindLfpProviders",
      requestType = com.google.shopping.merchant.accounts.v1.FindLfpProvidersRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1.FindLfpProvidersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.FindLfpProvidersRequest,
          com.google.shopping.merchant.accounts.v1.FindLfpProvidersResponse>
      getFindLfpProvidersMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1.FindLfpProvidersRequest,
            com.google.shopping.merchant.accounts.v1.FindLfpProvidersResponse>
        getFindLfpProvidersMethod;
    if ((getFindLfpProvidersMethod = LfpProvidersServiceGrpc.getFindLfpProvidersMethod) == null) {
      synchronized (LfpProvidersServiceGrpc.class) {
        if ((getFindLfpProvidersMethod = LfpProvidersServiceGrpc.getFindLfpProvidersMethod)
            == null) {
          LfpProvidersServiceGrpc.getFindLfpProvidersMethod =
              getFindLfpProvidersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1.FindLfpProvidersRequest,
                          com.google.shopping.merchant.accounts.v1.FindLfpProvidersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindLfpProviders"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.FindLfpProvidersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.FindLfpProvidersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LfpProvidersServiceMethodDescriptorSupplier("FindLfpProviders"))
                      .build();
        }
      }
    }
    return getFindLfpProvidersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.LinkLfpProviderRequest,
          com.google.shopping.merchant.accounts.v1.LinkLfpProviderResponse>
      getLinkLfpProviderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LinkLfpProvider",
      requestType = com.google.shopping.merchant.accounts.v1.LinkLfpProviderRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1.LinkLfpProviderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.LinkLfpProviderRequest,
          com.google.shopping.merchant.accounts.v1.LinkLfpProviderResponse>
      getLinkLfpProviderMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1.LinkLfpProviderRequest,
            com.google.shopping.merchant.accounts.v1.LinkLfpProviderResponse>
        getLinkLfpProviderMethod;
    if ((getLinkLfpProviderMethod = LfpProvidersServiceGrpc.getLinkLfpProviderMethod) == null) {
      synchronized (LfpProvidersServiceGrpc.class) {
        if ((getLinkLfpProviderMethod = LfpProvidersServiceGrpc.getLinkLfpProviderMethod) == null) {
          LfpProvidersServiceGrpc.getLinkLfpProviderMethod =
              getLinkLfpProviderMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1.LinkLfpProviderRequest,
                          com.google.shopping.merchant.accounts.v1.LinkLfpProviderResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LinkLfpProvider"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.LinkLfpProviderRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.LinkLfpProviderResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LfpProvidersServiceMethodDescriptorSupplier("LinkLfpProvider"))
                      .build();
        }
      }
    }
    return getLinkLfpProviderMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static LfpProvidersServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LfpProvidersServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LfpProvidersServiceStub>() {
          @java.lang.Override
          public LfpProvidersServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LfpProvidersServiceStub(channel, callOptions);
          }
        };
    return LfpProvidersServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static LfpProvidersServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LfpProvidersServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LfpProvidersServiceBlockingV2Stub>() {
          @java.lang.Override
          public LfpProvidersServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LfpProvidersServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return LfpProvidersServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LfpProvidersServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LfpProvidersServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LfpProvidersServiceBlockingStub>() {
          @java.lang.Override
          public LfpProvidersServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LfpProvidersServiceBlockingStub(channel, callOptions);
          }
        };
    return LfpProvidersServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static LfpProvidersServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LfpProvidersServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LfpProvidersServiceFutureStub>() {
          @java.lang.Override
          public LfpProvidersServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LfpProvidersServiceFutureStub(channel, callOptions);
          }
        };
    return LfpProvidersServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The service facilitates the management of a merchant's LFP provider settings.
   * This API defines the following resource model:
   * - [LfpProvider][google.shopping.merchant.accounts.v1.LfpProvider]
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Find the LFP provider candidates in a given country.
     * </pre>
     */
    default void findLfpProviders(
        com.google.shopping.merchant.accounts.v1.FindLfpProvidersRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1.FindLfpProvidersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFindLfpProvidersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Link the specified merchant to a LFP provider for the specified country.
     * </pre>
     */
    default void linkLfpProvider(
        com.google.shopping.merchant.accounts.v1.LinkLfpProviderRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1.LinkLfpProviderResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getLinkLfpProviderMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service LfpProvidersService.
   *
   * <pre>
   * The service facilitates the management of a merchant's LFP provider settings.
   * This API defines the following resource model:
   * - [LfpProvider][google.shopping.merchant.accounts.v1.LfpProvider]
   * </pre>
   */
  public abstract static class LfpProvidersServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return LfpProvidersServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service LfpProvidersService.
   *
   * <pre>
   * The service facilitates the management of a merchant's LFP provider settings.
   * This API defines the following resource model:
   * - [LfpProvider][google.shopping.merchant.accounts.v1.LfpProvider]
   * </pre>
   */
  public static final class LfpProvidersServiceStub
      extends io.grpc.stub.AbstractAsyncStub<LfpProvidersServiceStub> {
    private LfpProvidersServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LfpProvidersServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LfpProvidersServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Find the LFP provider candidates in a given country.
     * </pre>
     */
    public void findLfpProviders(
        com.google.shopping.merchant.accounts.v1.FindLfpProvidersRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1.FindLfpProvidersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindLfpProvidersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Link the specified merchant to a LFP provider for the specified country.
     * </pre>
     */
    public void linkLfpProvider(
        com.google.shopping.merchant.accounts.v1.LinkLfpProviderRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1.LinkLfpProviderResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLinkLfpProviderMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service LfpProvidersService.
   *
   * <pre>
   * The service facilitates the management of a merchant's LFP provider settings.
   * This API defines the following resource model:
   * - [LfpProvider][google.shopping.merchant.accounts.v1.LfpProvider]
   * </pre>
   */
  public static final class LfpProvidersServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<LfpProvidersServiceBlockingV2Stub> {
    private LfpProvidersServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LfpProvidersServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LfpProvidersServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Find the LFP provider candidates in a given country.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.FindLfpProvidersResponse findLfpProviders(
        com.google.shopping.merchant.accounts.v1.FindLfpProvidersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindLfpProvidersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Link the specified merchant to a LFP provider for the specified country.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.LinkLfpProviderResponse linkLfpProvider(
        com.google.shopping.merchant.accounts.v1.LinkLfpProviderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLinkLfpProviderMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service LfpProvidersService.
   *
   * <pre>
   * The service facilitates the management of a merchant's LFP provider settings.
   * This API defines the following resource model:
   * - [LfpProvider][google.shopping.merchant.accounts.v1.LfpProvider]
   * </pre>
   */
  public static final class LfpProvidersServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LfpProvidersServiceBlockingStub> {
    private LfpProvidersServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LfpProvidersServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LfpProvidersServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Find the LFP provider candidates in a given country.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.FindLfpProvidersResponse findLfpProviders(
        com.google.shopping.merchant.accounts.v1.FindLfpProvidersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindLfpProvidersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Link the specified merchant to a LFP provider for the specified country.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.LinkLfpProviderResponse linkLfpProvider(
        com.google.shopping.merchant.accounts.v1.LinkLfpProviderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLinkLfpProviderMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service LfpProvidersService.
   *
   * <pre>
   * The service facilitates the management of a merchant's LFP provider settings.
   * This API defines the following resource model:
   * - [LfpProvider][google.shopping.merchant.accounts.v1.LfpProvider]
   * </pre>
   */
  public static final class LfpProvidersServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<LfpProvidersServiceFutureStub> {
    private LfpProvidersServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LfpProvidersServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LfpProvidersServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Find the LFP provider candidates in a given country.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1.FindLfpProvidersResponse>
        findLfpProviders(com.google.shopping.merchant.accounts.v1.FindLfpProvidersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindLfpProvidersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Link the specified merchant to a LFP provider for the specified country.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1.LinkLfpProviderResponse>
        linkLfpProvider(com.google.shopping.merchant.accounts.v1.LinkLfpProviderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLinkLfpProviderMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FIND_LFP_PROVIDERS = 0;
  private static final int METHODID_LINK_LFP_PROVIDER = 1;

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
        case METHODID_FIND_LFP_PROVIDERS:
          serviceImpl.findLfpProviders(
              (com.google.shopping.merchant.accounts.v1.FindLfpProvidersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1.FindLfpProvidersResponse>)
                  responseObserver);
          break;
        case METHODID_LINK_LFP_PROVIDER:
          serviceImpl.linkLfpProvider(
              (com.google.shopping.merchant.accounts.v1.LinkLfpProviderRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1.LinkLfpProviderResponse>)
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
            getFindLfpProvidersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1.FindLfpProvidersRequest,
                    com.google.shopping.merchant.accounts.v1.FindLfpProvidersResponse>(
                    service, METHODID_FIND_LFP_PROVIDERS)))
        .addMethod(
            getLinkLfpProviderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1.LinkLfpProviderRequest,
                    com.google.shopping.merchant.accounts.v1.LinkLfpProviderResponse>(
                    service, METHODID_LINK_LFP_PROVIDER)))
        .build();
  }

  private abstract static class LfpProvidersServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LfpProvidersServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.accounts.v1.LfpProvidersProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LfpProvidersService");
    }
  }

  private static final class LfpProvidersServiceFileDescriptorSupplier
      extends LfpProvidersServiceBaseDescriptorSupplier {
    LfpProvidersServiceFileDescriptorSupplier() {}
  }

  private static final class LfpProvidersServiceMethodDescriptorSupplier
      extends LfpProvidersServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    LfpProvidersServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (LfpProvidersServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new LfpProvidersServiceFileDescriptorSupplier())
                      .addMethod(getFindLfpProvidersMethod())
                      .addMethod(getLinkLfpProviderMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
