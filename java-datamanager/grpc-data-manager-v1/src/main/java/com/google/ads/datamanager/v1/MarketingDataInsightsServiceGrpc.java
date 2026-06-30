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
package com.google.ads.datamanager.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service to return insights on marketing data.
 * This feature is only available to data partners.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class MarketingDataInsightsServiceGrpc {

  private MarketingDataInsightsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.ads.datamanager.v1.MarketingDataInsightsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.RetrieveInsightsRequest,
          com.google.ads.datamanager.v1.RetrieveInsightsResponse>
      getRetrieveInsightsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RetrieveInsights",
      requestType = com.google.ads.datamanager.v1.RetrieveInsightsRequest.class,
      responseType = com.google.ads.datamanager.v1.RetrieveInsightsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.RetrieveInsightsRequest,
          com.google.ads.datamanager.v1.RetrieveInsightsResponse>
      getRetrieveInsightsMethod() {
    io.grpc.MethodDescriptor<
            com.google.ads.datamanager.v1.RetrieveInsightsRequest,
            com.google.ads.datamanager.v1.RetrieveInsightsResponse>
        getRetrieveInsightsMethod;
    if ((getRetrieveInsightsMethod = MarketingDataInsightsServiceGrpc.getRetrieveInsightsMethod)
        == null) {
      synchronized (MarketingDataInsightsServiceGrpc.class) {
        if ((getRetrieveInsightsMethod = MarketingDataInsightsServiceGrpc.getRetrieveInsightsMethod)
            == null) {
          MarketingDataInsightsServiceGrpc.getRetrieveInsightsMethod =
              getRetrieveInsightsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.ads.datamanager.v1.RetrieveInsightsRequest,
                          com.google.ads.datamanager.v1.RetrieveInsightsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RetrieveInsights"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.RetrieveInsightsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.RetrieveInsightsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MarketingDataInsightsServiceMethodDescriptorSupplier(
                              "RetrieveInsights"))
                      .build();
        }
      }
    }
    return getRetrieveInsightsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static MarketingDataInsightsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MarketingDataInsightsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MarketingDataInsightsServiceStub>() {
          @java.lang.Override
          public MarketingDataInsightsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MarketingDataInsightsServiceStub(channel, callOptions);
          }
        };
    return MarketingDataInsightsServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static MarketingDataInsightsServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MarketingDataInsightsServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MarketingDataInsightsServiceBlockingV2Stub>() {
          @java.lang.Override
          public MarketingDataInsightsServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MarketingDataInsightsServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return MarketingDataInsightsServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MarketingDataInsightsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MarketingDataInsightsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MarketingDataInsightsServiceBlockingStub>() {
          @java.lang.Override
          public MarketingDataInsightsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MarketingDataInsightsServiceBlockingStub(channel, callOptions);
          }
        };
    return MarketingDataInsightsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static MarketingDataInsightsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MarketingDataInsightsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MarketingDataInsightsServiceFutureStub>() {
          @java.lang.Override
          public MarketingDataInsightsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MarketingDataInsightsServiceFutureStub(channel, callOptions);
          }
        };
    return MarketingDataInsightsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to return insights on marketing data.
   * This feature is only available to data partners.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Retrieves marketing data insights for a given user list.
     * This feature is only available to data partners.
     * Authorization Headers:
     * This method supports the following optional headers to define how the API
     * authorizes access for the request:
     * * `login-account`: (Optional) The resource name of the account where the
     *   Google Account of the credentials is a user. If not set, defaults to the
     *   account of the request. Format:
     *   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
     * * `linked-account`: (Optional) The resource name of the account with an
     *    established product link to the `login-account`. Format:
     *    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
     * </pre>
     */
    default void retrieveInsights(
        com.google.ads.datamanager.v1.RetrieveInsightsRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.RetrieveInsightsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRetrieveInsightsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MarketingDataInsightsService.
   *
   * <pre>
   * Service to return insights on marketing data.
   * This feature is only available to data partners.
   * </pre>
   */
  public abstract static class MarketingDataInsightsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return MarketingDataInsightsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service MarketingDataInsightsService.
   *
   * <pre>
   * Service to return insights on marketing data.
   * This feature is only available to data partners.
   * </pre>
   */
  public static final class MarketingDataInsightsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<MarketingDataInsightsServiceStub> {
    private MarketingDataInsightsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MarketingDataInsightsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MarketingDataInsightsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves marketing data insights for a given user list.
     * This feature is only available to data partners.
     * Authorization Headers:
     * This method supports the following optional headers to define how the API
     * authorizes access for the request:
     * * `login-account`: (Optional) The resource name of the account where the
     *   Google Account of the credentials is a user. If not set, defaults to the
     *   account of the request. Format:
     *   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
     * * `linked-account`: (Optional) The resource name of the account with an
     *    established product link to the `login-account`. Format:
     *    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
     * </pre>
     */
    public void retrieveInsights(
        com.google.ads.datamanager.v1.RetrieveInsightsRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.RetrieveInsightsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRetrieveInsightsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service MarketingDataInsightsService.
   *
   * <pre>
   * Service to return insights on marketing data.
   * This feature is only available to data partners.
   * </pre>
   */
  public static final class MarketingDataInsightsServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<MarketingDataInsightsServiceBlockingV2Stub> {
    private MarketingDataInsightsServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MarketingDataInsightsServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MarketingDataInsightsServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves marketing data insights for a given user list.
     * This feature is only available to data partners.
     * Authorization Headers:
     * This method supports the following optional headers to define how the API
     * authorizes access for the request:
     * * `login-account`: (Optional) The resource name of the account where the
     *   Google Account of the credentials is a user. If not set, defaults to the
     *   account of the request. Format:
     *   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
     * * `linked-account`: (Optional) The resource name of the account with an
     *    established product link to the `login-account`. Format:
     *    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
     * </pre>
     */
    public com.google.ads.datamanager.v1.RetrieveInsightsResponse retrieveInsights(
        com.google.ads.datamanager.v1.RetrieveInsightsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRetrieveInsightsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service
   * MarketingDataInsightsService.
   *
   * <pre>
   * Service to return insights on marketing data.
   * This feature is only available to data partners.
   * </pre>
   */
  public static final class MarketingDataInsightsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MarketingDataInsightsServiceBlockingStub> {
    private MarketingDataInsightsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MarketingDataInsightsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MarketingDataInsightsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves marketing data insights for a given user list.
     * This feature is only available to data partners.
     * Authorization Headers:
     * This method supports the following optional headers to define how the API
     * authorizes access for the request:
     * * `login-account`: (Optional) The resource name of the account where the
     *   Google Account of the credentials is a user. If not set, defaults to the
     *   account of the request. Format:
     *   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
     * * `linked-account`: (Optional) The resource name of the account with an
     *    established product link to the `login-account`. Format:
     *    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
     * </pre>
     */
    public com.google.ads.datamanager.v1.RetrieveInsightsResponse retrieveInsights(
        com.google.ads.datamanager.v1.RetrieveInsightsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRetrieveInsightsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * MarketingDataInsightsService.
   *
   * <pre>
   * Service to return insights on marketing data.
   * This feature is only available to data partners.
   * </pre>
   */
  public static final class MarketingDataInsightsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<MarketingDataInsightsServiceFutureStub> {
    private MarketingDataInsightsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MarketingDataInsightsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MarketingDataInsightsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves marketing data insights for a given user list.
     * This feature is only available to data partners.
     * Authorization Headers:
     * This method supports the following optional headers to define how the API
     * authorizes access for the request:
     * * `login-account`: (Optional) The resource name of the account where the
     *   Google Account of the credentials is a user. If not set, defaults to the
     *   account of the request. Format:
     *   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
     * * `linked-account`: (Optional) The resource name of the account with an
     *    established product link to the `login-account`. Format:
     *    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.ads.datamanager.v1.RetrieveInsightsResponse>
        retrieveInsights(com.google.ads.datamanager.v1.RetrieveInsightsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRetrieveInsightsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RETRIEVE_INSIGHTS = 0;

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
        case METHODID_RETRIEVE_INSIGHTS:
          serviceImpl.retrieveInsights(
              (com.google.ads.datamanager.v1.RetrieveInsightsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.RetrieveInsightsResponse>)
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
            getRetrieveInsightsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.ads.datamanager.v1.RetrieveInsightsRequest,
                    com.google.ads.datamanager.v1.RetrieveInsightsResponse>(
                    service, METHODID_RETRIEVE_INSIGHTS)))
        .build();
  }

  private abstract static class MarketingDataInsightsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MarketingDataInsightsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.ads.datamanager.v1.InsightsServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MarketingDataInsightsService");
    }
  }

  private static final class MarketingDataInsightsServiceFileDescriptorSupplier
      extends MarketingDataInsightsServiceBaseDescriptorSupplier {
    MarketingDataInsightsServiceFileDescriptorSupplier() {}
  }

  private static final class MarketingDataInsightsServiceMethodDescriptorSupplier
      extends MarketingDataInsightsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MarketingDataInsightsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (MarketingDataInsightsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new MarketingDataInsightsServiceFileDescriptorSupplier())
                      .addMethod(getRetrieveInsightsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
