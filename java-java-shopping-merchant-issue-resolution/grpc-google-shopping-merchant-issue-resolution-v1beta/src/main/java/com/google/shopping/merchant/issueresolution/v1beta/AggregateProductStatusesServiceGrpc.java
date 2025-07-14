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
package com.google.shopping.merchant.issueresolution.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service to manage aggregate product statuses.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments =
        "Source: google/shopping/merchant/issueresolution/v1beta/aggregateproductstatuses.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AggregateProductStatusesServiceGrpc {

  private AggregateProductStatusesServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.issueresolution.v1beta.AggregateProductStatusesService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.issueresolution.v1beta.ListAggregateProductStatusesRequest,
          com.google.shopping.merchant.issueresolution.v1beta.ListAggregateProductStatusesResponse>
      getListAggregateProductStatusesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAggregateProductStatuses",
      requestType =
          com.google.shopping.merchant.issueresolution.v1beta.ListAggregateProductStatusesRequest
              .class,
      responseType =
          com.google.shopping.merchant.issueresolution.v1beta.ListAggregateProductStatusesResponse
              .class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.issueresolution.v1beta.ListAggregateProductStatusesRequest,
          com.google.shopping.merchant.issueresolution.v1beta.ListAggregateProductStatusesResponse>
      getListAggregateProductStatusesMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.issueresolution.v1beta.ListAggregateProductStatusesRequest,
            com.google.shopping.merchant.issueresolution.v1beta
                .ListAggregateProductStatusesResponse>
        getListAggregateProductStatusesMethod;
    if ((getListAggregateProductStatusesMethod =
            AggregateProductStatusesServiceGrpc.getListAggregateProductStatusesMethod)
        == null) {
      synchronized (AggregateProductStatusesServiceGrpc.class) {
        if ((getListAggregateProductStatusesMethod =
                AggregateProductStatusesServiceGrpc.getListAggregateProductStatusesMethod)
            == null) {
          AggregateProductStatusesServiceGrpc.getListAggregateProductStatusesMethod =
              getListAggregateProductStatusesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.issueresolution.v1beta
                              .ListAggregateProductStatusesRequest,
                          com.google.shopping.merchant.issueresolution.v1beta
                              .ListAggregateProductStatusesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAggregateProductStatuses"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.issueresolution.v1beta
                                  .ListAggregateProductStatusesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.issueresolution.v1beta
                                  .ListAggregateProductStatusesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AggregateProductStatusesServiceMethodDescriptorSupplier(
                              "ListAggregateProductStatuses"))
                      .build();
        }
      }
    }
    return getListAggregateProductStatusesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AggregateProductStatusesServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AggregateProductStatusesServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AggregateProductStatusesServiceStub>() {
          @java.lang.Override
          public AggregateProductStatusesServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AggregateProductStatusesServiceStub(channel, callOptions);
          }
        };
    return AggregateProductStatusesServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static AggregateProductStatusesServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AggregateProductStatusesServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AggregateProductStatusesServiceBlockingV2Stub>() {
          @java.lang.Override
          public AggregateProductStatusesServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AggregateProductStatusesServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return AggregateProductStatusesServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AggregateProductStatusesServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AggregateProductStatusesServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AggregateProductStatusesServiceBlockingStub>() {
          @java.lang.Override
          public AggregateProductStatusesServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AggregateProductStatusesServiceBlockingStub(channel, callOptions);
          }
        };
    return AggregateProductStatusesServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AggregateProductStatusesServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AggregateProductStatusesServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AggregateProductStatusesServiceFutureStub>() {
          @java.lang.Override
          public AggregateProductStatusesServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AggregateProductStatusesServiceFutureStub(channel, callOptions);
          }
        };
    return AggregateProductStatusesServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to manage aggregate product statuses.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists the `AggregateProductStatuses` resources for your merchant account.
     * The response might contain fewer items than specified by `pageSize`.
     * If `pageToken` was returned in previous request, it can be used to obtain
     * additional results.
     * </pre>
     */
    default void listAggregateProductStatuses(
        com.google.shopping.merchant.issueresolution.v1beta.ListAggregateProductStatusesRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.issueresolution.v1beta
                    .ListAggregateProductStatusesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAggregateProductStatusesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AggregateProductStatusesService.
   *
   * <pre>
   * Service to manage aggregate product statuses.
   * </pre>
   */
  public abstract static class AggregateProductStatusesServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AggregateProductStatusesServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service
   * AggregateProductStatusesService.
   *
   * <pre>
   * Service to manage aggregate product statuses.
   * </pre>
   */
  public static final class AggregateProductStatusesServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AggregateProductStatusesServiceStub> {
    private AggregateProductStatusesServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AggregateProductStatusesServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AggregateProductStatusesServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the `AggregateProductStatuses` resources for your merchant account.
     * The response might contain fewer items than specified by `pageSize`.
     * If `pageToken` was returned in previous request, it can be used to obtain
     * additional results.
     * </pre>
     */
    public void listAggregateProductStatuses(
        com.google.shopping.merchant.issueresolution.v1beta.ListAggregateProductStatusesRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.issueresolution.v1beta
                    .ListAggregateProductStatusesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAggregateProductStatusesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AggregateProductStatusesService.
   *
   * <pre>
   * Service to manage aggregate product statuses.
   * </pre>
   */
  public static final class AggregateProductStatusesServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<AggregateProductStatusesServiceBlockingV2Stub> {
    private AggregateProductStatusesServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AggregateProductStatusesServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AggregateProductStatusesServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the `AggregateProductStatuses` resources for your merchant account.
     * The response might contain fewer items than specified by `pageSize`.
     * If `pageToken` was returned in previous request, it can be used to obtain
     * additional results.
     * </pre>
     */
    public com.google.shopping.merchant.issueresolution.v1beta.ListAggregateProductStatusesResponse
        listAggregateProductStatuses(
            com.google.shopping.merchant.issueresolution.v1beta.ListAggregateProductStatusesRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAggregateProductStatusesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service
   * AggregateProductStatusesService.
   *
   * <pre>
   * Service to manage aggregate product statuses.
   * </pre>
   */
  public static final class AggregateProductStatusesServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AggregateProductStatusesServiceBlockingStub> {
    private AggregateProductStatusesServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AggregateProductStatusesServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AggregateProductStatusesServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the `AggregateProductStatuses` resources for your merchant account.
     * The response might contain fewer items than specified by `pageSize`.
     * If `pageToken` was returned in previous request, it can be used to obtain
     * additional results.
     * </pre>
     */
    public com.google.shopping.merchant.issueresolution.v1beta.ListAggregateProductStatusesResponse
        listAggregateProductStatuses(
            com.google.shopping.merchant.issueresolution.v1beta.ListAggregateProductStatusesRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAggregateProductStatusesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * AggregateProductStatusesService.
   *
   * <pre>
   * Service to manage aggregate product statuses.
   * </pre>
   */
  public static final class AggregateProductStatusesServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AggregateProductStatusesServiceFutureStub> {
    private AggregateProductStatusesServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AggregateProductStatusesServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AggregateProductStatusesServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the `AggregateProductStatuses` resources for your merchant account.
     * The response might contain fewer items than specified by `pageSize`.
     * If `pageToken` was returned in previous request, it can be used to obtain
     * additional results.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.issueresolution.v1beta
                .ListAggregateProductStatusesResponse>
        listAggregateProductStatuses(
            com.google.shopping.merchant.issueresolution.v1beta.ListAggregateProductStatusesRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAggregateProductStatusesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_AGGREGATE_PRODUCT_STATUSES = 0;

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
        case METHODID_LIST_AGGREGATE_PRODUCT_STATUSES:
          serviceImpl.listAggregateProductStatuses(
              (com.google.shopping.merchant.issueresolution.v1beta
                      .ListAggregateProductStatusesRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.issueresolution.v1beta
                          .ListAggregateProductStatusesResponse>)
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
            getListAggregateProductStatusesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.issueresolution.v1beta
                        .ListAggregateProductStatusesRequest,
                    com.google.shopping.merchant.issueresolution.v1beta
                        .ListAggregateProductStatusesResponse>(
                    service, METHODID_LIST_AGGREGATE_PRODUCT_STATUSES)))
        .build();
  }

  private abstract static class AggregateProductStatusesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AggregateProductStatusesServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.issueresolution.v1beta.AggregateProductStatusesProto
          .getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AggregateProductStatusesService");
    }
  }

  private static final class AggregateProductStatusesServiceFileDescriptorSupplier
      extends AggregateProductStatusesServiceBaseDescriptorSupplier {
    AggregateProductStatusesServiceFileDescriptorSupplier() {}
  }

  private static final class AggregateProductStatusesServiceMethodDescriptorSupplier
      extends AggregateProductStatusesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AggregateProductStatusesServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AggregateProductStatusesServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(
                          new AggregateProductStatusesServiceFileDescriptorSupplier())
                      .addMethod(getListAggregateProductStatusesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
